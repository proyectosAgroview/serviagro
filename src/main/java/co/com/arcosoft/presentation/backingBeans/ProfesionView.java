package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.TarifaProfesion;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.ProfesionDTO;
import co.com.arcosoft.modelo.dto.TarifaProfesionDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProfesionView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProfesionView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private SelectOneMenu txtFunciones;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	// private SelectOneMenu txtElemCostoId_ElementoCosto;
	private InputText txtProfId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ProfesionDTO> data;
	private ProfesionDTO selectedProfesion;
	private Profesion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;
	private Profesion entityProfesion;

	/********************/
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private SelectOneMenu txtContratistaId_Contratista;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private List<TarifaProfesionDTO> dataTarifaProfesion;
	private TarifaProfesionDTO selectedTarifaProfesion;

	/*********************/
	private InputText txtCodContratista;
	private InputText txtCodUdadMed;
	private InputText txtCodConceptoNomina;

	public ProfesionView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ProfesionDTO profesionDTO = (ProfesionDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(profesionDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(profesionDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(profesionDTO.getEstado());

			if (txtFunciones == null) {
				txtFunciones = new SelectOneMenu();
			}

			txtFunciones.setValue(profesionDTO.getFunciones());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(profesionDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(profesionDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(profesionDTO.getNombre());

			if (txtElemCostoId_ElementoCosto == null) {
				txtElemCostoId_ElementoCosto = new SelectOneMenu();
			}

			txtElemCostoId_ElementoCosto.setValue(profesionDTO.getElemCostoId_ElementoCosto());

			if (txtProfId == null) {
				txtProfId = new InputText();
			}

			txtProfId.setValue(profesionDTO.getProfId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(profesionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(profesionDTO.getFechaModificacion());

			Long profId = FacesUtils.checkLong(txtProfId);
			entity = businessDelegatorView.getProfesion(profId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedProfesion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedProfesion = null;
		PrimeFaces.current().resetInputs(":dialogProfesion :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCodConceptoNomina != null) {
			txtCodConceptoNomina.setValue(null);
			txtCodConceptoNomina.setDisabled(false);
		}

		if (txtCodContratista != null) {
			txtCodContratista.setValue(null);
			txtCodContratista.setDisabled(false);
		}

		if (txtCodUdadMed != null) {
			txtCodUdadMed.setValue(null);
			txtCodUdadMed.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFunciones != null) {
			txtFunciones.setValue(null);
			txtFunciones.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtProfId != null) {
			txtProfId.setValue(null);
			txtProfId.setDisabled(false);
		}

		if (txtValorUnit != null) {
			txtValorUnit.setValue(null);
			txtValorUnit.setDisabled(false);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (dataTarifaProfesion != null) {
			dataTarifaProfesion = null;
		}

		if (txtContratistaId_Contratista != null) {
			txtContratistaId_Contratista.setValue(null);
			txtContratistaId_Contratista.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(true);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public List<TarifaProfesionDTO> getDataProfesionByTarifaProfesionId() {

		if (dataTarifaProfesion == null || dataTarifaProfesion.size() == 0) {
			return null;
		} else {
			return dataTarifaProfesion;
		}

	}

	public void action_agregarTarifaProfesion() throws Exception {
		if (txtFechaInicial.getValue() != null && txtFechaFinal.getValue() != null
				&& txtContratistaId_Contratista.getValue() != null && txtUdadMedId_UdadMed.getValue() != null
				&& txtCeptoNominaId_ConceptoNomina.getValue() != null && txtValorUnit.getValue() != null
				) {
		Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
		UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

		Long contratistaId = Long.parseLong(txtContratistaId_Contratista.getValue().toString());
		PersEmpr contratista = businessDelegatorView.getPersEmpr(contratistaId);

		Long conceptoPagoId = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());
		ConceptoNomina conceptoPago = businessDelegatorView.getConceptoNomina(conceptoPagoId);

		String codContratista = contratista.getCodigo();
		String codUdadMed = udadMed.getCodigo();
		String codConceptoNomina = conceptoPago.getCodigo();

		Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
		Long compania = new Long(getCompaniaIdSession());
		Date fechaCreacion = new Date();
		Date fechaModificacion = new Date();

		if (dataTarifaProfesion == null) {
			dataTarifaProfesion = new ArrayList<TarifaProfesionDTO>();
		}

		TarifaProfesionDTO tarifaProfesionDTO = new TarifaProfesionDTO();
		tarifaProfesionDTO.setFechaInicial(fechaInicial);
		tarifaProfesionDTO.setFechaFinal(fechaFinal);
		tarifaProfesionDTO.setCodConceptoNomina(codConceptoNomina);
		tarifaProfesionDTO.setCodContratista(codContratista);
		tarifaProfesionDTO.setCodUdadMed(codUdadMed);

		tarifaProfesionDTO.setContratistaId(contratista);
		tarifaProfesionDTO.setCeptoNominaId_ConceptoNomina(conceptoPago);
		tarifaProfesionDTO.setUdadMedId_UdadMed(udadMed);
		tarifaProfesionDTO.setTarifa(valorUnit);
		tarifaProfesionDTO.setCompania(compania);
		tarifaProfesionDTO.setFechaCreacion(fechaCreacion);
		tarifaProfesionDTO.setFechaModificacion(fechaModificacion);

		dataTarifaProfesion.add(tarifaProfesionDTO);

		fechaInicial = null;
		fechaFinal = null;
		contratista = null;
		conceptoPago = null;
		udadMedId_UdadMed = null;
		valorUnit = null;
		fechaCreacion = null;
		fechaModificacion = null;
		codContratista = null;
		codUdadMed = null;
		codConceptoNomina = null;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final,  concepto, unidad de médida y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMed.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodUdadMed.setValue(udadMed.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodConceptoNomina() {

		Long conceptoNominaId = null;

		if (!txtCeptoNominaId_ConceptoNomina.getValue().equals("")) {
			conceptoNominaId = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());

			try {
				ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodConceptoNomina.setValue(conceptoNomina.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodContratista() {

		Long contratistaId = null;

		if (!txtContratistaId_Contratista.getValue().equals("")) {
			contratistaId = Long.parseLong(txtContratistaId_Contratista.getValue().toString());

			try {
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(contratistaId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodContratista.setValue(persEmpr.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Profesion> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInProfesion(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}
		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtFunciones.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtElemCostoId_ElementoCosto.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtProfId.setDisabled(false);

			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtFunciones.setValue(entity.getFunciones());
			txtFunciones.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
			txtElemCostoId_ElementoCosto.setDisabled(false);
			txtProfId.setValue(entity.getProfId());
			txtProfId.setDisabled(true);
			/*** sesion tarifa ***/

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedProfesion = (ProfesionDTO) (evt.getComponent().getAttributes().get("selectedProfesion"));

		try {

			String codigo = selectedProfesion.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Profesion> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInProfesion(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(entity.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(entity.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtFunciones.setValue(entity.getFunciones());
				txtFunciones.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtElemCostoId_ElementoCosto.setValue(selectedProfesion.getElemCostoId_ElementoCosto());
				txtElemCostoId_ElementoCosto.setDisabled(false);
				txtProfId.setValue(selectedProfesion.getProfId());
				txtProfId.setDisabled(true);
				/*** sesion tarifa ***/

				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedProfesion == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String getLoginSession() throws Exception {

		FacesContext fc = FacesContext.getCurrentInstance();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;
		String passWord = null;

		if (auth != null) {

			login = auth.getName();

		} else {

			throw new Exception("No user logged in ");

		}

		return login;
	}

	public String getCompaniaIdSession() throws Exception {

		String compania = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				compania = usuarios.getCompania().getCompaniaId().toString();
			}
		}

		return compania;
	}

	public String getUsuarioIdSession() throws Exception {

		String usuarioId = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				usuarioId = usuarios.getUsuarioId().toString();
			}
		}

		return usuarioId;
	}

	public String action_create() {
		try {
			entity = new Profesion();
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			// Long profId = FacesUtils.checkLong(txtProfId);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setFunciones(FacesUtils.checkString(txtFunciones));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			// entity.setProfId(profId);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
			businessDelegatorView.saveProfesion(entity, dataTarifaProfesion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long profId = new Long(selectedProfesion.getProfId());
				entity = businessDelegatorView.getProfesion(profId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setFunciones(FacesUtils.checkString(txtFunciones));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
			businessDelegatorView.updateProfesion(entity, dataTarifaProfesion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedProfesion = (ProfesionDTO) (evt.getComponent().getAttributes().get("selectedProfesion"));

			Long profId = new Long(selectedProfesion.getProfId());
			entity = businessDelegatorView.getProfesion(profId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long profId = FacesUtils.checkLong(txtProfId);
			entity = businessDelegatorView.getProfesion(profId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteProfesion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedProfesion = (ProfesionDTO) (evt.getComponent().getAttributes().get("selectedProfesion"));

			Long profId = new Long(selectedProfesion.getProfId());
			entity = businessDelegatorView.getProfesion(profId);
			businessDelegatorView.deleteProfesion(entity);
			data.remove(selectedProfesion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String funciones, String infoAdicional, String infoAdicional2, String nombre,
			Long profId, Long elemCostoId_ElementoCosto) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFunciones(FacesUtils.checkString(funciones));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateProfesion(entity, dataTarifaProfesion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ProfesionView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String actionDeleteTarifaProfesion(ActionEvent evt) {
		try {

			selectedTarifaProfesion = (TarifaProfesionDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaProfesion"));

			if (selectedTarifaProfesion.getTarifaProfId() == null) {
				dataTarifaProfesion.remove(selectedTarifaProfesion);
			} else {
				Long tarifaProfesiondId = new Long(selectedTarifaProfesion.getTarifaProfId());
				TarifaProfesion entity = businessDelegatorView.getTarifaProfesion(tarifaProfesiondId);
				businessDelegatorView.deleteTarifaProfesion(entity);
				dataTarifaProfesion.remove(selectedTarifaProfesion);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	
	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneMenu getTxtFunciones() {
		return txtFunciones;
	}

	public void setTxtFunciones(SelectOneMenu txtFunciones) {
		this.txtFunciones = txtFunciones;
	}

	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtProfId() {
		return txtProfId;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public SelectOneMenu getTxtContratistaId_Contratista() {
		return txtContratistaId_Contratista;
	}

	public void setTxtContratistaId_Contratista(SelectOneMenu txtContratistaId_Contratista) {
		this.txtContratistaId_Contratista = txtContratistaId_Contratista;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public InputText getTxtValorUnit() {
		return txtValorUnit;
	}

	public void setTxtValorUnit(InputText txtValorUnit) {
		this.txtValorUnit = txtValorUnit;
	}

	public void setTxtProfId(InputText txtProfId) {
		this.txtProfId = txtProfId;
	}

	public List<ProfesionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataProfesion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ProfesionDTO> profesionDTO) {
		this.data = profesionDTO;
	}

	public ProfesionDTO getSelectedProfesion() {
		return selectedProfesion;
	}

	public void setSelectedProfesion(ProfesionDTO profesion) {
		this.selectedProfesion = profesion;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public SelectItem[] getselectElementoCosto() {

		if (elementoCosto == null || elementoCosto.size() == 0) {

			elementoCosto = new ArrayList<ElementoCosto>();

			try {

				elementoCosto = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectElementoCosto = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectElementoCosto[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectElementoCosto;
	}

	public void setselectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
	}

	public SelectItem[] getSelectCeptoNominaId() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

			conceptoNomina = new ArrayList<ConceptoNomina>();

			try {

				conceptoNomina = businessDelegatorView.getConceptoNomina(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setselectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			contratista = new ArrayList<PersEmpr>();

			try {

				contratista = businessDelegatorView.getPersEmpr(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratista;
	}

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			udadMed = new ArrayList<UdadMed>();

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMed[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed;
	}

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public List<TarifaProfesionDTO> getDataTarifaProfesion() {
		return dataTarifaProfesion;
	}

	public void setDataTarifaProfesion(List<TarifaProfesionDTO> dataTarifaProfesion) {
		this.dataTarifaProfesion = dataTarifaProfesion;
	}

	public InputText getTxtCodContratista() {
		return txtCodContratista;
	}

	public void setTxtCodContratista(InputText txtCodContratista) {
		this.txtCodContratista = txtCodContratista;
	}

	public InputText getTxtCodUdadMed() {
		return txtCodUdadMed;
	}

	public void setTxtCodUdadMed(InputText txtCodUdadMed) {
		this.txtCodUdadMed = txtCodUdadMed;
	}

	public InputText getTxtCodConceptoNomina() {
		return txtCodConceptoNomina;
	}

	public void setTxtCodConceptoNomina(InputText txtCodConceptoNomina) {
		this.txtCodConceptoNomina = txtCodConceptoNomina;
	}

}
