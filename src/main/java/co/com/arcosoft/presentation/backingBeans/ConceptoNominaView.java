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
import co.com.arcosoft.modelo.CuentaContable;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.ConceptoNominaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ConceptoNominaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ConceptoNominaView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	// private InputText txtElemCostoId_ElementoCosto;
	private InputText txtCeptoNominaId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ConceptoNominaDTO> data;
	private ConceptoNominaDTO selectedConceptoNomina;
	private ConceptoNomina entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;

	private InputText txtFactorPrestacional;
	private SelectOneRadio txtExcluyeInteface;
	private SelectOneRadio txtExcluyeDominical;
	private SelectOneRadio txtExcluyeAuxilio;
	private SelectOneRadio txtExcluyeAdmon;

	
	private SelectOneMenu txtCuentaContable;
	SelectItem[] selectCuentaContable;
	private List<CuentaContable> cuentaContable;


	private SelectOneMenu txtCuentaContable2;
	SelectItem[] selectCuentaContable2;
	private List<CuentaContable> cuentaContable2;

	
	private SelectOneMenu txtUdadMedId;
	SelectItem[] selectUdadMedId;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtEsAusentismo;
	private SelectOneMenu txtTipoConcepto;
	
	
	public ConceptoNominaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ConceptoNominaDTO conceptoNominaDTO = (ConceptoNominaDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(conceptoNominaDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(conceptoNominaDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(conceptoNominaDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(conceptoNominaDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(conceptoNominaDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(conceptoNominaDTO.getNombre());

			if (txtElemCostoId_ElementoCosto == null) {
				txtElemCostoId_ElementoCosto = new SelectOneMenu();
			}

			txtElemCostoId_ElementoCosto.setValue(conceptoNominaDTO.getElemCostoId_ElementoCosto());

			if (txtCeptoNominaId == null) {
				txtCeptoNominaId = new InputText();
			}

			txtCeptoNominaId.setValue(conceptoNominaDTO.getCeptoNominaId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(conceptoNominaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(conceptoNominaDTO.getFechaModificacion());

			Long ceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId);
			entity = businessDelegatorView.getConceptoNomina(ceptoNominaId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedConceptoNomina = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedConceptoNomina = null;
		PrimeFaces.current().resetInputs(":dialogConceptoNomina :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtEsAusentismo != null) {
			txtEsAusentismo.setValue(null);
			txtEsAusentismo.setDisabled(true);
		}
		
		if (txtTipoConcepto != null) {
			txtTipoConcepto.setValue(null);
			txtTipoConcepto.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtCuentaContable != null) {
			txtCuentaContable.setValue(null);
			txtCuentaContable.setDisabled(true);
		}

		if (txtCuentaContable2 != null) {
			txtCuentaContable2.setValue(null);
			txtCuentaContable2.setDisabled(true);
		}

		if (txtUdadMedId != null) {
			txtUdadMedId.setValue(null);
			txtUdadMedId.setDisabled(true);
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

		if (txtCeptoNominaId != null) {
			txtCeptoNominaId.setValue(null);
			txtCeptoNominaId.setDisabled(false);
		}

		if (txtFactorPrestacional != null) {
			txtFactorPrestacional.setValue(1.0);
			txtFactorPrestacional.setDisabled(true);
		}

		if (txtExcluyeAuxilio != null) {
			txtExcluyeAuxilio.setValue("N");
			txtExcluyeAuxilio.setDisabled(true);
		}

		if (txtExcluyeDominical != null) {
			txtExcluyeDominical.setValue("N");
			txtExcluyeDominical.setDisabled(true);
		}

		if (txtExcluyeInteface != null) {
			txtExcluyeInteface.setValue("N");
			txtExcluyeInteface.setDisabled(true);
		}
		if (txtExcluyeAdmon != null) {
			txtExcluyeAdmon.setValue("N");
			txtExcluyeAdmon.setDisabled(true);
		}
		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
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
	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<ConceptoNomina> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null) : null;

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
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtElemCostoId_ElementoCosto.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtFactorPrestacional.setDisabled(false);
			txtCeptoNominaId.setDisabled(false);
			txtExcluyeAuxilio.setDisabled(false);
			txtExcluyeDominical.setDisabled(false);
			txtExcluyeInteface.setDisabled(false);
			txtExcluyeAdmon.setDisabled(false);
			txtCuentaContable.setDisabled(false);
			txtCuentaContable2.setDisabled(false);
			txtUdadMedId.setDisabled(false);

			txtEsAusentismo.setDisabled(false);
			txtTipoConcepto.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			
			txtEsAusentismo.setDisabled(false);
			txtEsAusentismo.setValue(entity.getEsAusentismo());

			txtCuentaContable2.setDisabled(false);
			txtCuentaContable2.setValue(entity.getCuentaContable2());
			txtUdadMedId.setValue(entity.getUdadMedId());
			txtUdadMedId.setDisabled(false);

			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFactorPrestacional.setValue(entity.getFactorPrestacional());
			txtFactorPrestacional.setDisabled(false);

			txtExcluyeAuxilio.setValue(entity.getExcluyeAuxilio());
			txtExcluyeAuxilio.setDisabled(false);
			txtExcluyeDominical.setValue(entity.getExcluyeDominical());
			txtExcluyeDominical.setDisabled(false);
			txtExcluyeInteface.setValue(entity.getExcluyeInteface());
			txtExcluyeInteface.setDisabled(false);

			txtExcluyeAdmon.setValue(entity.getExcluyeInteface());
			txtExcluyeAdmon.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
			txtElemCostoId_ElementoCosto.setDisabled(false);
			txtCeptoNominaId.setValue(entity.getCeptoNominaId());
			txtCeptoNominaId.setDisabled(true);
			btnSave.setDisabled(false);
			
			txtCuentaContable.setValue(entity.getCuentaContable());
			txtCuentaContable.setDisabled(false);
			
			txtTipoConcepto.setValue(entity.getTipoConcepto());
			txtTipoConcepto.setDisabled(false);
			
			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedConceptoNomina = (ConceptoNominaDTO) (evt.getComponent().getAttributes().get("selectedConceptoNomina"));
		try {

			String codigo = selectedConceptoNomina.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<ConceptoNomina> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);

				txtEsAusentismo.setDisabled(false);
				txtEsAusentismo.setValue(entity.getEsAusentismo());
			
				txtCuentaContable2.setDisabled(false);
				txtCuentaContable2.setValue(entity.getCuentaContable2());
				txtUdadMedId.setValue(entity.getUdadMedId());
				txtUdadMedId.setDisabled(false);

				txtCuentaContable.setValue(entity.getCuentaContable());
				txtCuentaContable.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtExcluyeAuxilio.setValue(entity.getExcluyeAuxilio());
				txtExcluyeAuxilio.setDisabled(false);
				txtExcluyeDominical.setValue(entity.getExcluyeDominical());
				txtExcluyeDominical.setDisabled(false);
				txtExcluyeInteface.setValue(entity.getExcluyeInteface());
				txtExcluyeInteface.setDisabled(false);
				txtExcluyeAdmon.setValue(entity.getExcluyeInteface());
				txtExcluyeAdmon.setDisabled(false);

				// txtFechaCreacion.setValue(entity.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(entity.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtElemCostoId_ElementoCosto.setValue(selectedConceptoNomina.getElemCostoId_ElementoCosto());
				txtElemCostoId_ElementoCosto.setDisabled(false);
				txtCeptoNominaId.setValue(entity.getCeptoNominaId());
				txtCeptoNominaId.setDisabled(true);

				txtFactorPrestacional.setValue(entity.getFactorPrestacional());
				txtFactorPrestacional.setDisabled(false);
				
				txtTipoConcepto.setValue(entity.getTipoConcepto());
				txtTipoConcepto.setDisabled(false);
				
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
			if ((selectedConceptoNomina == null) && (entity == null)) {
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
			entity = new ConceptoNomina();

			// Long ceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId);
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			// entity.setCeptoNominaId(ceptoNominaId);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setCuentaContable(FacesUtils.checkLong(txtCuentaContable));
			entity.setTipoConcepto(FacesUtils.checkString(txtTipoConcepto));
			entity.setCuentaContable2(FacesUtils.checkLong(txtCuentaContable2));
			entity.setUdadMedId(FacesUtils.checkLong(txtUdadMedId));
			
			entity.setEsAusentismo(FacesUtils.checkString(txtEsAusentismo));
			
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setFactorPrestacional(FacesUtils.checkDouble(txtFactorPrestacional));
			entity.setExcluyeAuxilio(FacesUtils.checkString(txtExcluyeAuxilio));
			entity.setExcluyeDominical(FacesUtils.checkString(txtExcluyeDominical));
			entity.setExcluyeInteface(FacesUtils.checkString(txtExcluyeInteface));
			entity.setExcluyeAdmon(FacesUtils.checkString(txtExcluyeAdmon));

			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
			businessDelegatorView.saveConceptoNomina(entity);
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
				Long ceptoNominaId = new Long(selectedConceptoNomina.getCeptoNominaId());
				entity = businessDelegatorView.getConceptoNomina(ceptoNominaId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setEsAusentismo(FacesUtils.checkString(txtEsAusentismo));
			
			entity.setTipoConcepto(FacesUtils.checkString(txtTipoConcepto));
			entity.setCuentaContable2(FacesUtils.checkLong(txtCuentaContable2));
			entity.setUdadMedId(FacesUtils.checkLong(txtUdadMedId));
			
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setCuentaContable(FacesUtils.checkLong(txtCuentaContable));
			entity.setFactorPrestacional(FacesUtils.checkDouble(txtFactorPrestacional));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setExcluyeAuxilio(FacesUtils.checkString(txtExcluyeAuxilio));
			entity.setExcluyeDominical(FacesUtils.checkString(txtExcluyeDominical));
			entity.setExcluyeInteface(FacesUtils.checkString(txtExcluyeInteface));
			entity.setExcluyeAdmon(FacesUtils.checkString(txtExcluyeAdmon));

			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
			businessDelegatorView.updateConceptoNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedConceptoNomina = (ConceptoNominaDTO) (evt.getComponent().getAttributes()
					.get("selectedConceptoNomina"));

			Long ceptoNominaId = new Long(selectedConceptoNomina.getCeptoNominaId());
			entity = businessDelegatorView.getConceptoNomina(ceptoNominaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long ceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId);
			entity = businessDelegatorView.getConceptoNomina(ceptoNominaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteConceptoNomina(entity);
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
			selectedConceptoNomina = (ConceptoNominaDTO) (evt.getComponent().getAttributes()
					.get("selectedConceptoNomina"));

			Long ceptoNominaId = new Long(selectedConceptoNomina.getCeptoNominaId());
			entity = businessDelegatorView.getConceptoNomina(ceptoNominaId);
			businessDelegatorView.deleteConceptoNomina(entity);
			data.remove(selectedConceptoNomina);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ceptoNominaId, String codigo, Long compania, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre,
			Long elemCostoId_ElementoCosto) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateConceptoNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ConceptoNominaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
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

	public InputText getTxtCeptoNominaId() {
		return txtCeptoNominaId;
	}

	public void setTxtCeptoNominaId(InputText txtCeptoNominaId) {
		this.txtCeptoNominaId = txtCeptoNominaId;
	}

	public List<ConceptoNominaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataConceptoNomina();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ConceptoNominaDTO> conceptoNominaDTO) {
		this.data = conceptoNominaDTO;
	}

	public ConceptoNominaDTO getSelectedConceptoNomina() {
		return selectedConceptoNomina;
	}

	public void setSelectedConceptoNomina(ConceptoNominaDTO conceptoNomina) {
		this.selectedConceptoNomina = conceptoNomina;
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



	public SelectItem[] getselectCuentaContable() {

		if (cuentaContable == null || cuentaContable.size() == 0) {

			cuentaContable = new ArrayList<CuentaContable>();

			try {

				cuentaContable = businessDelegatorView.getCuentaContable(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CuentaContable> lista = businessDelegatorView.findByCriteriaInCuentaContable(condicion, null, null);
				selectCuentaContable = new SelectItem[lista.size()];

				int i = 0;
				for (CuentaContable cuentaContable : lista) {
					selectCuentaContable[i] = new SelectItem(cuentaContable.getCcontableId(), cuentaContable.getCodigo() +'-'+ cuentaContable.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCuentaContable;
	}

	public void setselectCuentaContable(SelectItem[] selectCuentaContable) {
		this.selectCuentaContable = selectCuentaContable;
	}



	public SelectItem[] getselectCuentaContable2() {

		if (cuentaContable2 == null || cuentaContable2.size() == 0) {

			cuentaContable2 = new ArrayList<CuentaContable>();

			try {

				cuentaContable2 = businessDelegatorView.getCuentaContable(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CuentaContable> lista = businessDelegatorView.findByCriteriaInCuentaContable(condicion, null, null);
				selectCuentaContable2 = new SelectItem[lista.size()];

				int i = 0;
				for (CuentaContable cuentaContable2 : lista) {
					selectCuentaContable2[i] = new SelectItem(cuentaContable2.getCcontableId(), cuentaContable2.getCodigo() +'-'+ cuentaContable2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCuentaContable2;
	}

	
	

	public SelectItem[] getselectUdadMedId() {

		if (udadMed == null || udadMed.size() == 0) {

			udadMed = new ArrayList<UdadMed>();

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedId = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedId[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedId;
	}

	public void setselectUdadMedId(SelectItem[] selectUdadMedId) {
		this.selectUdadMedId = selectUdadMedId;
	}

	public void setselectCuentaContable2(SelectItem[] selectCuentaContable2) {
		this.selectCuentaContable2 = selectCuentaContable2;
	}

	public InputText getTxtFactorPrestacional() {
		return txtFactorPrestacional;
	}

	public void setTxtFactorPrestacional(InputText txtFactorPrestacional) {
		this.txtFactorPrestacional = txtFactorPrestacional;
	}

	public SelectOneRadio getTxtExcluyeInteface() {
		return txtExcluyeInteface;
	}

	public void setTxtExcluyeInteface(SelectOneRadio txtExcluyeInteface) {
		this.txtExcluyeInteface = txtExcluyeInteface;
	}

	public SelectOneRadio getTxtExcluyeDominical() {
		return txtExcluyeDominical;
	}

	public void setTxtExcluyeDominical(SelectOneRadio txtExcluyeDominical) {
		this.txtExcluyeDominical = txtExcluyeDominical;
	}

	public SelectOneRadio getTxtExcluyeAuxilio() {
		return txtExcluyeAuxilio;
	}

	public void setTxtExcluyeAuxilio(SelectOneRadio txtExcluyeAuxilio) {
		this.txtExcluyeAuxilio = txtExcluyeAuxilio;
	}

	public SelectOneRadio getTxtExcluyeAdmon() {
		return txtExcluyeAdmon;
	}

	public void setTxtExcluyeAdmon(SelectOneRadio txtExcluyeAdmon) {
		this.txtExcluyeAdmon = txtExcluyeAdmon;
	}

	/**
	 * @return the txtCuentaContable
	 */
	public SelectOneMenu getTxtCuentaContable() {
		return txtCuentaContable;
	}

	/**
	 * @param txtCuentaContable the txtCuentaContable to set
	 */
	public void setTxtCuentaContable(SelectOneMenu txtCuentaContable) {
		this.txtCuentaContable = txtCuentaContable;
	}

	/**
	 * @return the txtEsAusentismo
	 */
	public SelectOneMenu getTxtEsAusentismo() {
		return txtEsAusentismo;
	}

	/**
	 * @param txtEsAusentismo the txtEsAusentismo to set
	 */
	public void setTxtEsAusentismo(SelectOneMenu txtEsAusentismo) {
		this.txtEsAusentismo = txtEsAusentismo;
	}

	/**
	 * @return the txtCuentaContable2
	 */
	public SelectOneMenu getTxtCuentaContable2() {
		return txtCuentaContable2;
	}

	/**
	 * @param txtCuentaContable2 the txtCuentaContable2 to set
	 */
	public void setTxtCuentaContable2(SelectOneMenu txtCuentaContable2) {
		this.txtCuentaContable2 = txtCuentaContable2;
	}

	/**
	 * @return the txtUdadMedId
	 */
	public SelectOneMenu getTxtUdadMedId() {
		return txtUdadMedId;
	}

	/**
	 * @param txtUdadMedId the txtUdadMedId to set
	 */
	public void setTxtUdadMedId(SelectOneMenu txtUdadMedId) {
		this.txtUdadMedId = txtUdadMedId;
	}

	public SelectOneMenu getTxtTipoConcepto() {
		return txtTipoConcepto;
	}

	public void setTxtTipoConcepto(SelectOneMenu txtTipoConcepto) {
		this.txtTipoConcepto = txtTipoConcepto;
	}

	
}
