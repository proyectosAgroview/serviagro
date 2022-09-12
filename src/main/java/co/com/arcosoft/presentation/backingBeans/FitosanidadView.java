package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.CultivoFitosanidad;
import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.FitosanidadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class FitosanidadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FitosanidadView.class);
	private InputText txtClaseFitosanidad;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtNombreCientifico;
	private InputText txtTipoFitosanidad;
	private InputText txtFitosanidadId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnSearch;
	private List<FitosanidadDTO> data;
	private FitosanidadDTO selectedFitosanidad;
	private Fitosanidad entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	// varables nuevas
	private String clase;
	private String tipo;
	private SelectItem[] idClaseFitosanidad;
	private SelectOneMenu selectClaseFitosanidad;
	private SelectItem[] idTipoFitosanidad;
	private SelectOneMenu selectTipoFitosanidad;

	private List<String> selectedCultivos;
	private List<Cultivo> cultivos;

	public FitosanidadView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FitosanidadDTO fitosanidadDTO = (FitosanidadDTO) e.getObject();

			if (txtClaseFitosanidad == null) {
				txtClaseFitosanidad = new InputText();
			}

			txtClaseFitosanidad.setValue(fitosanidadDTO.getClaseFitosanidad());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(fitosanidadDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(fitosanidadDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(fitosanidadDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(fitosanidadDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(fitosanidadDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(fitosanidadDTO.getNombre());

			if (txtNombreCientifico == null) {
				txtNombreCientifico = new InputText();
			}

			txtNombreCientifico.setValue(fitosanidadDTO.getNombreCientifico());

			if (txtTipoFitosanidad == null) {
				txtTipoFitosanidad = new InputText();
			}

			txtTipoFitosanidad.setValue(fitosanidadDTO.getTipoFitosanidad());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(fitosanidadDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(fitosanidadDTO.getFechaModificacion());

			if (txtFitosanidadId == null) {
				txtFitosanidadId = new InputText();
			}

			txtFitosanidadId.setValue(fitosanidadDTO.getFitosanidadId());

			Long fitosanidadId = FacesUtils.checkLong(txtFitosanidadId);
			entity = businessDelegatorView.getFitosanidad(fitosanidadId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFitosanidad = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFitosanidad = null;
		selectedCultivos = null;
		PrimeFaces.current().resetInputs(":dialogFitosanidad :frm");

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

		if (txtNombreCientifico != null) {
			txtNombreCientifico.setValue(null);
			txtNombreCientifico.setDisabled(true);
		}

		if (txtFitosanidadId != null) {
			txtFitosanidadId.setValue(null);
			txtFitosanidadId.setDisabled(false);
		}

		if (selectClaseFitosanidad != null) {
			selectClaseFitosanidad.setValue("");
			selectClaseFitosanidad.setDisabled(true);
		}

		if (selectTipoFitosanidad != null) {
			selectTipoFitosanidad.setValue("");
			selectTipoFitosanidad.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtId() {
		try {
			Long fitosanidadId = FacesUtils.checkLong(txtFitosanidadId);
			entity = (fitosanidadId != null) ? businessDelegatorView.getFitosanidad(fitosanidadId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtClaseFitosanidad.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNombreCientifico.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtTipoFitosanidad.setDisabled(false);
			txtFitosanidadId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtClaseFitosanidad.setValue(entity.getClaseFitosanidad());
			txtClaseFitosanidad.setDisabled(false);
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
			txtNombreCientifico.setValue(entity.getNombreCientifico());
			txtNombreCientifico.setDisabled(false);
			txtTipoFitosanidad.setValue(entity.getTipoFitosanidad());
			txtTipoFitosanidad.setDisabled(false);
			txtFitosanidadId.setValue(entity.getFitosanidadId());
			txtFitosanidadId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtCodigo() throws Exception {
		try {

			String fitosanidadCodigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, fitosanidadCodigo, "=" };
			List<Fitosanidad> lista = (fitosanidadCodigo != null)
					? businessDelegatorView.findByCriteriaInFitosanidad(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ fitosanidadCodigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtClaseFitosanidad.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNombreCientifico.setDisabled(false);
			// txtTipoFitosanidad.setDisabled(false);
			// txtFitosanidadId.setDisabled(false);
			btnSave.setDisabled(false);

			selectClaseFitosanidad.setDisabled(false);
			selectTipoFitosanidad.setDisabled(false);

		} else {
			// txtClaseFitosanidad.setValue(entity.getClaseFitosanidad());
			// txtClaseFitosanidad.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNombreCientifico.setValue(entity.getNombreCientifico());
			txtNombreCientifico.setDisabled(false);
			// txtTipoFitosanidad.setValue(entity.getTipoFitosanidad());
			// txtTipoFitosanidad.setDisabled(false);
			txtFitosanidadId.setValue(entity.getFitosanidadId());
			// txtFitosanidadId.setDisabled(true);
			txtCodigo.setDisabled(true);
			btnSave.setDisabled(false);

			selectClaseFitosanidad.setDisabled(false);
			selectClaseFitosanidad.setValue(entity.getClaseFitosanidad());
			selectTipoFitosanidad.setDisabled(false);
			selectTipoFitosanidad.setValue(entity.getTipoFitosanidad());

			Object[] variables = { "fitosanidad.fitosanidadId", false, entity.getFitosanidadId(), "=" };
			List<CultivoFitosanidad> cf = businessDelegatorView.findByCriteriaInCultivoFitosanidad(variables, null,
					null);

			if (cf != null && cf.size() > 0) {

				Object[] cultivoFitosanidads = cf.toArray();

				selectedCultivos = new ArrayList<String>();

				for (int i = 0; i < cultivoFitosanidads.length; i++) {
					CultivoFitosanidad cultivoFitosanidad = (CultivoFitosanidad) cultivoFitosanidads[i];
					selectedCultivos.add(cultivoFitosanidad.getCultivo().getCultivoId().toString());
				}

			}

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFitosanidad = (FitosanidadDTO) (evt.getComponent().getAttributes().get("selectedFitosanidad"));

		try {

			String fitosanidadCodigo = selectedFitosanidad.getCodigo();
			Object[] condicion = { "codigo", true, fitosanidadCodigo, "=" };
			List<Fitosanidad> lista = (fitosanidadCodigo != null)
					? businessDelegatorView.findByCriteriaInFitosanidad(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtNombreCientifico.setValue(entity.getNombreCientifico());
				txtNombreCientifico.setDisabled(false);
				// txtTipoFitosanidad.setValue(entity.getTipoFitosanidad());
				// txtTipoFitosanidad.setDisabled(false);
				txtFitosanidadId.setValue(entity.getFitosanidadId());
				// txtFitosanidadId.setDisabled(true);
				txtCodigo.setDisabled(true);
				btnSave.setDisabled(false);

				selectClaseFitosanidad.setDisabled(false);
				selectClaseFitosanidad.setValue(entity.getClaseFitosanidad());
				selectTipoFitosanidad.setDisabled(false);
				selectTipoFitosanidad.setValue(entity.getTipoFitosanidad());

				Object[] variables = { "fitosanidad.fitosanidadId", false, entity.getFitosanidadId(), "=" };
				List<CultivoFitosanidad> cf = businessDelegatorView.findByCriteriaInCultivoFitosanidad(variables, null,
						null);

				if (cf != null && cf.size() > 0) {

					Object[] cultivoFitosanidads = cf.toArray();
					selectedCultivos = new ArrayList<String>();

					for (int i = 0; i < cultivoFitosanidads.length; i++) {

						CultivoFitosanidad cultivoFitosanidad = (CultivoFitosanidad) cultivoFitosanidads[i];

						selectedCultivos.add(cultivoFitosanidad.getCultivo().getCultivoId().toString());

					}
				}

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
			if ((selectedFitosanidad == null) && (entity == null)) {
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
			entity = new Fitosanidad();
			Date date = new Date();

			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);

			entity.setClaseFitosanidad(FacesUtils.checkString(selectClaseFitosanidad));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNombreCientifico(FacesUtils.checkString(txtNombreCientifico));
			entity.setTipoFitosanidad(FacesUtils.checkString(selectTipoFitosanidad));
			businessDelegatorView.saveFitosanidad(entity, selectedCultivos);

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
				Long fitosanidadId = new Long(selectedFitosanidad.getFitosanidadId());
				entity = businessDelegatorView.getFitosanidad(fitosanidadId);
			}
			Date date = new Date();
			entity.setClaseFitosanidad(FacesUtils.checkString(selectClaseFitosanidad));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(entity.getFechaCreacion());
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNombreCientifico(FacesUtils.checkString(txtNombreCientifico));
			entity.setTipoFitosanidad(FacesUtils.checkString(selectTipoFitosanidad));
			businessDelegatorView.updateFitosanidad(entity, selectedCultivos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedFitosanidad = (FitosanidadDTO) (evt.getComponent().getAttributes().get("selectedFitosanidad"));

			Long fitosanidadId = new Long(selectedFitosanidad.getFitosanidadId());
			entity = businessDelegatorView.getFitosanidad(fitosanidadId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long fitosanidadId = FacesUtils.checkLong(txtFitosanidadId);
			entity = businessDelegatorView.getFitosanidad(fitosanidadId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteFitosanidad(entity);
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
			selectedFitosanidad = (FitosanidadDTO) (evt.getComponent().getAttributes().get("selectedFitosanidad"));

			Long fitosanidadId = new Long(selectedFitosanidad.getFitosanidadId());
			entity = businessDelegatorView.getFitosanidad(fitosanidadId);
			businessDelegatorView.deleteFitosanidad(entity);
			data.remove(selectedFitosanidad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String claseFitosanidad, String codigo, Long compania, String estado,
			Date fechaCreacion, Date fechaModificacion, Long fitosanidadId, String infoAdicional, String infoAdicional2,
			String nombre, String nombreCientifico, String tipoFitosanidad) throws Exception {
		try {
			entity.setClaseFitosanidad(FacesUtils.checkString(claseFitosanidad));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setNombreCientifico(FacesUtils.checkString(nombreCientifico));
			entity.setTipoFitosanidad(FacesUtils.checkString(tipoFitosanidad));
			businessDelegatorView.updateFitosanidad(entity, selectedCultivos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FitosanidadView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtClaseFitosanidad() {
		return txtClaseFitosanidad;
	}

	public void setTxtClaseFitosanidad(InputText txtClaseFitosanidad) {
		this.txtClaseFitosanidad = txtClaseFitosanidad;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
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

	public InputText getTxtNombreCientifico() {
		return txtNombreCientifico;
	}

	public void setTxtNombreCientifico(InputText txtNombreCientifico) {
		this.txtNombreCientifico = txtNombreCientifico;
	}

	public InputText getTxtTipoFitosanidad() {
		return txtTipoFitosanidad;
	}

	public void setTxtTipoFitosanidad(InputText txtTipoFitosanidad) {
		this.txtTipoFitosanidad = txtTipoFitosanidad;
	}

	public InputText getTxtFitosanidadId() {
		return txtFitosanidadId;
	}

	public void setTxtFitosanidadId(InputText txtFitosanidadId) {
		this.txtFitosanidadId = txtFitosanidadId;
	}

	public List<FitosanidadDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFitosanidad();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FitosanidadDTO> fitosanidadDTO) {
		this.data = fitosanidadDTO;
	}

	public FitosanidadDTO getSelectedFitosanidad() {
		return selectedFitosanidad;
	}

	public void setSelectedFitosanidad(FitosanidadDTO fitosanidad) {
		this.selectedFitosanidad = fitosanidad;
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

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public SelectOneMenu getSelectClaseFitosanidad() {
		return selectClaseFitosanidad;
	}

	public void setSelectClaseFitosanidad(SelectOneMenu selectClaseFitosanidad) {
		this.selectClaseFitosanidad = selectClaseFitosanidad;
	}

	public SelectItem[] getIdClaseFitosanidad() {

		idClaseFitosanidad = new SelectItem[3];

		idClaseFitosanidad[0] = new SelectItem("ENFERMEDAD", "ENFERMEDAD");
		idClaseFitosanidad[1] = new SelectItem("MALEZA", "MALEZA");
		idClaseFitosanidad[2] = new SelectItem("PLAGA", "PLAGA");

		return idClaseFitosanidad;
	}

	public void setIdClaseFitosanidad(SelectItem[] idClaseFitosanidad) {
		this.idClaseFitosanidad = idClaseFitosanidad;
	}

	public SelectItem[] getIdTipoFitosanidad() {

		idTipoFitosanidad = new SelectItem[9];

		idTipoFitosanidad[0] = new SelectItem("GUSANO", "GUSANO");
		idTipoFitosanidad[1] = new SelectItem("ROEEDOR", "ROEEDOR");
		idTipoFitosanidad[2] = new SelectItem("INSECTO", "INSECTO");
		idTipoFitosanidad[3] = new SelectItem("VIRUS", "VIRUS");
		idTipoFitosanidad[4] = new SelectItem("BACTERIA", "BACTERIA");
		idTipoFitosanidad[5] = new SelectItem("HIERBA", "HIERBA");
		idTipoFitosanidad[6] = new SelectItem("HONGO", "HONGO");
		idTipoFitosanidad[7] = new SelectItem("GUSANO", "GUSANO");
		idTipoFitosanidad[8] = new SelectItem("OTRO", "OTRO");

		return idTipoFitosanidad;
	}

	public void setIdTipoFitosanidad(SelectItem[] idTipoFitosanidad) {
		this.idTipoFitosanidad = idTipoFitosanidad;
	}

	public SelectOneMenu getSelectTipoFitosanidad() {
		return selectTipoFitosanidad;
	}

	public void setSelectTipoFitosanidad(SelectOneMenu selectTipoFitosanidad) {
		this.selectTipoFitosanidad = selectTipoFitosanidad;
	}

	public List<String> getSelectedCultivos() {
		return selectedCultivos;
	}

	public void setSelectedCultivos(List<String> selectedCultivos) {
		this.selectedCultivos = selectedCultivos;
	}

	public List<Cultivo> getCultivos() {

		if (cultivos == null || cultivos.size() == 0) {

			cultivos = new ArrayList<Cultivo>();

			try {
				cultivos = businessDelegatorView.getCultivo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return cultivos;
	}

	public void setCultivos(List<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}

	public CommandButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(CommandButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
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

}
