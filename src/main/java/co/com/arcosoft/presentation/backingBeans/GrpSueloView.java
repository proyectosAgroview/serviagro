package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.GrpSuelo;
import co.com.arcosoft.modelo.LaraEdad;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.GrpSueloDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GrpSueloView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GrpSueloView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private Spinner txtNumeroDiasCierreRiego;
	private SelectOneRadio txtRegistrarLaras;
	private InputText txtGrupoSuelo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GrpSueloDTO> data;
	private GrpSueloDTO selectedGrpSuelo;
	private GrpSuelo entity;
	private LaraEdad entity2;
	private boolean showDialog;
	private Tab tapLaraEdad;

	/* Pestaña LARA_EDAD */
	private InputText laraEdadInicial;
	private InputText laraEdadFinal;
	private InputText valorLara;
	private InputText txtLaraEdadId;
	private boolean flagTab = false;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GrpSueloView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			GrpSueloDTO grpSueloDTO = (GrpSueloDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(grpSueloDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(grpSueloDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(grpSueloDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(grpSueloDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(grpSueloDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(grpSueloDTO.getNombre());

			if (txtNumeroDiasCierreRiego == null) {
				txtNumeroDiasCierreRiego = new Spinner();
			}

			txtNumeroDiasCierreRiego.setValue(grpSueloDTO.getNumeroDiasCierreRiego());

			if (txtRegistrarLaras == null) {
				txtRegistrarLaras = new SelectOneRadio();
			}

			txtRegistrarLaras.setValue(grpSueloDTO.getRegistrarLaras());

			if (txtGrupoSuelo == null) {
				txtGrupoSuelo = new InputText();
			}

			txtGrupoSuelo.setValue(grpSueloDTO.getGrupoSuelo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(grpSueloDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(grpSueloDTO.getFechaModificacion());

			Long grupoSuelo = FacesUtils.checkLong(txtGrupoSuelo);
			entity = businessDelegatorView.getGrpSuelo(grupoSuelo);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGrpSuelo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		entity2 = null;
		selectedGrpSuelo = null;
		flagTab = true;
		// setFlagTab("false");

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

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtNumeroDiasCierreRiego != null) {
			txtNumeroDiasCierreRiego.setValue(null);
			txtNumeroDiasCierreRiego.setDisabled(true);
		}

		if (txtRegistrarLaras != null) {
			txtRegistrarLaras.setValue("0");
			txtRegistrarLaras.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtGrupoSuelo != null) {
			txtGrupoSuelo.setValue(null);
			txtGrupoSuelo.setDisabled(false);
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

	public void listener_txtId() {
		try {
			Long grupoSuelo = FacesUtils.checkLong(txtGrupoSuelo);
			entity = (grupoSuelo != null) ? businessDelegatorView.getGrpSuelo(grupoSuelo) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNumeroDiasCierreRiego.setDisabled(false);
			txtRegistrarLaras.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtGrupoSuelo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumeroDiasCierreRiego.setValue(entity.getNumeroDiasCierreRiego());
			txtNumeroDiasCierreRiego.setDisabled(false);
			txtRegistrarLaras.setValue(entity.getRegistrarLaras());
			txtRegistrarLaras.setDisabled(false);
			txtGrupoSuelo.setValue(entity.getGrupoSuelo());
			txtGrupoSuelo.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtCodigo() throws Exception {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<GrpSuelo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInGrpSuelo(condicion, null, null) : null;

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
			txtNumeroDiasCierreRiego.setDisabled(false);
			// txtRegistrarLaras.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtGrupoSuelo.setDisabled(false);
			txtLaraEdadId.setDisabled(false);
			flagTab = true;
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
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumeroDiasCierreRiego.setValue(entity.getNumeroDiasCierreRiego());
			txtNumeroDiasCierreRiego.setDisabled(false);
			// txtRegistrarLaras.setValue(entity.getRegistrarLaras());
			// txtRegistrarLaras.setDisabled(false);
			txtGrupoSuelo.setValue(entity.getGrupoSuelo());
			txtGrupoSuelo.setDisabled(true);

			/*
			 * Long GrupoSueloId = FacesUtils.checkLong(txtGrupoSuelo); Object[]
			 * condicion2 = { "grpSuelo", true, GrupoSueloId, "=" };
			 * List<LaraEdad> lista2 = (GrupoSueloId != null) ?
			 * businessDelegatorView .findByCriteriaInLaraEdad(condicion2, null,
			 * null) : null;
			 * 
			 * if (lista2 != null && lista2.size() > 0) { entity2 =
			 * lista2.get(0);
			 * 
			 * laraEdadInicial.setValue(entity2.getEdadInicial());
			 * laraEdadFinal.setValue(entity2.getEdadFinal());
			 * valorLara.setValue(entity2.getValorLaraEdad());
			 * txtLaraEdadId.setValue(entity2.getLaraEdadId());
			 * 
			 * flagTab = false;
			 * 
			 * } else {
			 * 
			 * flagTab = true; }
			 */

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGrpSuelo = (GrpSueloDTO) (evt.getComponent().getAttributes().get("selectedGrpSuelo"));

		try {

			String codigo = selectedGrpSuelo.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<GrpSuelo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInGrpSuelo(condicion, null, null) : null;

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
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtNumeroDiasCierreRiego.setValue(entity.getNumeroDiasCierreRiego());
				txtNumeroDiasCierreRiego.setDisabled(false);
				// txtRegistrarLaras.setValue(entity.getRegistrarLaras());
				// txtRegistrarLaras.setDisabled(false);
				txtGrupoSuelo.setValue(entity.getGrupoSuelo());
				txtGrupoSuelo.setDisabled(true);
				/*
				 * Long GrupoSueloId = FacesUtils.checkLong(txtGrupoSuelo);
				 * Object[] condicion2 = { "grpSuelo", true, GrupoSueloId, "="
				 * }; List<LaraEdad> lista2 = (GrupoSueloId != null) ?
				 * businessDelegatorView .findByCriteriaInLaraEdad(condicion2,
				 * null, null) : null;
				 * 
				 * if (lista2 != null && lista2.size() > 0) { entity2 =
				 * lista2.get(0);
				 * 
				 * laraEdadInicial.setValue(entity2.getEdadInicial());
				 * laraEdadFinal.setValue(entity2.getEdadFinal());
				 * valorLara.setValue(entity2.getValorLaraEdad());
				 * txtLaraEdadId.setValue(entity2.getLaraEdadId());
				 * 
				 * flagTab = false;
				 * 
				 * } else {
				 * 
				 * flagTab = true; }
				 */
				btnSave.setDisabled(false);
				setShowDialog(true);

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGrpSuelo == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new GrpSuelo();
			entity2 = null;
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			Long grupoSuelo = FacesUtils.checkLong(txtGrupoSuelo);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setGrupoSuelo(grupoSuelo);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumeroDiasCierreRiego(FacesUtils.checkLong(txtNumeroDiasCierreRiego));
			entity.setRegistrarLaras(FacesUtils.checkString(txtRegistrarLaras));

			/*
			 * double edadInicial = FacesUtils.checkDouble(laraEdadInicial);
			 * double edadFinal = FacesUtils.checkDouble(laraEdadFinal); double
			 * valor = FacesUtils.checkDouble(valorLara);
			 * 
			 * if (FacesUtils.checkDouble(laraEdadInicial) != null &&
			 * FacesUtils.checkDouble(laraEdadFinal) != null &&
			 * FacesUtils.checkDouble(valorLara) != null) {
			 * 
			 * // Long laraEdadId = FacesUtils.checkLong(txtLaraEdadId);
			 * 
			 * entity2 = new LaraEdad(); entity2.setEdadInicial(edadInicial);
			 * entity2.setEdadFinal(edadFinal); entity2.setValorLaraEdad(valor);
			 * // entity2.setLaraEdadId(laraEdadId); //
			 * entity2.setGrpSuelo(entity);
			 * 
			 * flagTab = false;
			 * 
			 * } else {
			 * 
			 * flagTab = true; }
			 */
			businessDelegatorView.saveGrpSuelo(entity, entity2);
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
				Long grupoSuelo = new Long(selectedGrpSuelo.getGrupoSuelo());
				entity = businessDelegatorView.getGrpSuelo(grupoSuelo);
			}
			entity2 = null;
			/*
			 * if (entity2 == null) {
			 * 
			 * Long grupoSuelo2 = new Long(selectedGrpSuelo.getGrupoSuelo());
			 * Object[] condicion2 = { "grpSuelo", true, grupoSuelo2, "=" };
			 * List<LaraEdad> lista2 = (grupoSuelo2 != null) ?
			 * businessDelegatorView .findByCriteriaInLaraEdad(condicion2, null,
			 * null) : null; entity2 = lista2.get(0);
			 * 
			 * }
			 */
			// entity2 = null;
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumeroDiasCierreRiego(FacesUtils.checkLong(txtNumeroDiasCierreRiego));
			entity.setRegistrarLaras(FacesUtils.checkString(txtRegistrarLaras));
			/*
			 * if (FacesUtils.checkDouble(laraEdadInicial) != null &&
			 * FacesUtils.checkDouble(laraEdadFinal) != null &&
			 * FacesUtils.checkDouble(valorLara) != null) {
			 * 
			 * entity2.setEdadInicial(FacesUtils.checkDouble(laraEdadInicial));
			 * entity2.setEdadFinal(FacesUtils.checkDouble(laraEdadFinal));
			 * entity2.setValorLaraEdad(FacesUtils.checkDouble(valorLara));
			 * 
			 * }
			 * 
			 */ businessDelegatorView.updateGrpSuelo(entity, entity2);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGrpSuelo = (GrpSueloDTO) (evt.getComponent().getAttributes().get("selectedGrpSuelo"));

			Long grupoSuelo = new Long(selectedGrpSuelo.getGrupoSuelo());
			entity = businessDelegatorView.getGrpSuelo(grupoSuelo);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long grupoSuelo = FacesUtils.checkLong(txtGrupoSuelo);
			entity = businessDelegatorView.getGrpSuelo(grupoSuelo);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGrpSuelo(entity);
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
			selectedGrpSuelo = (GrpSueloDTO) (evt.getComponent().getAttributes().get("selectedGrpSuelo"));

			Long grupoSuelo = new Long(selectedGrpSuelo.getGrupoSuelo());
			entity = businessDelegatorView.getGrpSuelo(grupoSuelo);
			businessDelegatorView.deleteGrpSuelo(entity);
			data.remove(selectedGrpSuelo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, Long grupoSuelo, String infoAdicional, String infoAdicional2, String nombre,
			Long numeroDiasCierreRiego, String registrarLaras) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setNumeroDiasCierreRiego(FacesUtils.checkLong(numeroDiasCierreRiego));
			entity.setRegistrarLaras(FacesUtils.checkString(registrarLaras));
			businessDelegatorView.updateGrpSuelo(entity, entity2);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GrpSueloView").requestRender();
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

	public Spinner getTxtNumeroDiasCierreRiego() {
		return txtNumeroDiasCierreRiego;
	}

	public void setTxtNumeroDiasCierreRiego(Spinner txtNumeroDiasCierreRiego) {
		this.txtNumeroDiasCierreRiego = txtNumeroDiasCierreRiego;
	}

	public SelectOneRadio getTxtRegistrarLaras() {
		return txtRegistrarLaras;
	}

	public void setTxtRegistrarLaras(SelectOneRadio txtRegistrarLaras) {
		this.txtRegistrarLaras = txtRegistrarLaras;
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

	public InputText getTxtGrupoSuelo() {
		return txtGrupoSuelo;
	}

	public void setTxtGrupoSuelo(InputText txtGrupoSuelo) {
		this.txtGrupoSuelo = txtGrupoSuelo;
	}

	public List<GrpSueloDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGrpSuelo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GrpSueloDTO> grpSueloDTO) {
		this.data = grpSueloDTO;
	}

	public GrpSueloDTO getSelectedGrpSuelo() {
		return selectedGrpSuelo;
	}

	public void setSelectedGrpSuelo(GrpSueloDTO grpSuelo) {
		this.selectedGrpSuelo = grpSuelo;
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

	public InputText getLaraEdadInicial() {
		return laraEdadInicial;
	}

	public void setLaraEdadInicial(InputText laraEdadInicial) {
		this.laraEdadInicial = laraEdadInicial;
	}

	public InputText getLaraEdadFinal() {
		return laraEdadFinal;
	}

	public void setLaraEdadFinal(InputText laraEdadFinal) {
		this.laraEdadFinal = laraEdadFinal;
	}

	public InputText getValorLara() {
		return valorLara;
	}

	public void setValorLara(InputText valorLara) {
		this.valorLara = valorLara;
	}

	public InputText getTxtLaraEdadId() {
		return txtLaraEdadId;
	}

	public void setTxtLaraEdadId(InputText txtLaraEdadId) {
		this.txtLaraEdadId = txtLaraEdadId;
	}

	public Tab getTapLaraEdad() {
		return tapLaraEdad;
	}

	public void setTapLaraEdad(Tab tapLaraEdad) {
		this.tapLaraEdad = tapLaraEdad;
	}

	public boolean getFlagTab() {
		return flagTab;
	}

	public void setFlagTab(boolean flagTab) {
		this.flagTab = flagTab;
	}

	public void listener_tabLara() {

		if (txtRegistrarLaras != null && txtRegistrarLaras.getValue() != null
				&& txtRegistrarLaras.getValue().equals("1")) {

			flagTab = false;

			// tapLaraEdad.setDisabled(false);

		} else {

			flagTab = true;
			// tapLaraEdad.setDisabled(true);

		}

	}

}
