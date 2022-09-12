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
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.FabricanteEquipo;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.ModeloEquipoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ModeloEquipoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ModeloEquipoView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtVelocidadPromedio;
	// private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	// private SelectOneMenu txtFabricEquipId_FabricanteEquipo;
	private InputText txtModeloEquipoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ModeloEquipoDTO> data;
	private ModeloEquipoDTO selectedModeloEquipo;
	private ModeloEquipo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipo;

	private SelectOneMenu txtFabricEquipId_FabricanteEquipo;
	SelectItem[] selectFabricanteEquipo;
	private List<FabricanteEquipo> fabricanteEquipo;

	public ModeloEquipoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ModeloEquipoDTO modeloEquipoDTO = (ModeloEquipoDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(modeloEquipoDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(modeloEquipoDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(modeloEquipoDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(modeloEquipoDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(modeloEquipoDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(modeloEquipoDTO.getNombre());

			if (txtVelocidadPromedio == null) {
				txtVelocidadPromedio = new InputText();
			}

			txtVelocidadPromedio.setValue(modeloEquipoDTO.getVelocidadPromedio());

			if (txtCategEquipId_CategoriaEquipo == null) {
				txtCategEquipId_CategoriaEquipo = new SelectOneMenu();
			}

			txtCategEquipId_CategoriaEquipo.setValue(modeloEquipoDTO.getCategEquipId_CategoriaEquipo());

			if (txtFabricEquipId_FabricanteEquipo == null) {
				txtFabricEquipId_FabricanteEquipo = new SelectOneMenu();
			}

			txtFabricEquipId_FabricanteEquipo.setValue(modeloEquipoDTO.getFabricEquipId_FabricanteEquipo());

			if (txtModeloEquipoId == null) {
				txtModeloEquipoId = new InputText();
			}

			txtModeloEquipoId.setValue(modeloEquipoDTO.getModeloEquipoId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(modeloEquipoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(modeloEquipoDTO.getFechaModificacion());

			Long modeloEquipoId = FacesUtils.checkLong(txtModeloEquipoId);
			entity = businessDelegatorView.getModeloEquipo(modeloEquipoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedModeloEquipo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedModeloEquipo = null;
		PrimeFaces.current().resetInputs(":dialogModeloEquipo :frm");

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

		if (txtVelocidadPromedio != null) {
			txtVelocidadPromedio.setValue(null);
			txtVelocidadPromedio.setDisabled(true);
		}

		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(true);
		}

		if (txtFabricEquipId_FabricanteEquipo != null) {
			txtFabricEquipId_FabricanteEquipo.setValue(null);
			txtFabricEquipId_FabricanteEquipo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtModeloEquipoId != null) {
			txtModeloEquipoId.setValue(null);
			txtModeloEquipoId.setDisabled(false);
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
			Long modeloEquipoId = FacesUtils.checkLong(txtModeloEquipoId);
			entity = (modeloEquipoId != null) ? businessDelegatorView.getModeloEquipo(modeloEquipoId) : null;
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
			txtVelocidadPromedio.setDisabled(false);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtModeloEquipoId.setDisabled(false);
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
			txtVelocidadPromedio.setValue(entity.getVelocidadPromedio());
			txtVelocidadPromedio.setDisabled(false);
			txtCategEquipId_CategoriaEquipo.setValue(entity.getCategoriaEquipo());
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setValue(entity.getFabricanteEquipo());
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtModeloEquipoId.setValue(entity.getModeloEquipoId());
			txtModeloEquipoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<ModeloEquipo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInModeloEquipo(condicion, null, null) : null;

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
			txtVelocidadPromedio.setDisabled(false);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtModeloEquipoId.setDisabled(false);
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
			txtVelocidadPromedio.setValue(entity.getVelocidadPromedio());
			txtVelocidadPromedio.setDisabled(false);
			txtCategEquipId_CategoriaEquipo.setValue(entity.getCategoriaEquipo());
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setValue(entity.getFabricanteEquipo());
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtModeloEquipoId.setValue(entity.getModeloEquipoId());
			txtModeloEquipoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedModeloEquipo = (ModeloEquipoDTO) (evt.getComponent().getAttributes().get("selectedModeloEquipo"));
		try {

			String codigo = selectedModeloEquipo.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<ModeloEquipo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInModeloEquipo(condicion, null, null) : null;

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
				txtVelocidadPromedio.setValue(entity.getVelocidadPromedio());
				txtVelocidadPromedio.setDisabled(false);
				txtCategEquipId_CategoriaEquipo.setValue(selectedModeloEquipo.getCategEquipId_CategoriaEquipo());
				txtCategEquipId_CategoriaEquipo.setDisabled(false);
				txtFabricEquipId_FabricanteEquipo.setValue(selectedModeloEquipo.getFabricEquipId_FabricanteEquipo());
				txtFabricEquipId_FabricanteEquipo.setDisabled(false);
				txtModeloEquipoId.setValue(entity.getModeloEquipoId());
				txtModeloEquipoId.setDisabled(true);
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
			if ((selectedModeloEquipo == null) && (entity == null)) {
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
			entity = new ModeloEquipo();

			// Long modeloEquipoId = FacesUtils.checkLong(txtModeloEquipoId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setModeloEquipoId(modeloEquipoId);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setVelocidadPromedio(FacesUtils.checkDouble(txtVelocidadPromedio));
			entity.setCategoriaEquipo((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo)));
			entity.setFabricanteEquipo((FacesUtils.checkLong(txtFabricEquipId_FabricanteEquipo)));
			businessDelegatorView.saveModeloEquipo(entity);
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
				Long modeloEquipoId = new Long(selectedModeloEquipo.getModeloEquipoId());
				entity = businessDelegatorView.getModeloEquipo(modeloEquipoId);
			}
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
			entity.setVelocidadPromedio(FacesUtils.checkDouble(txtVelocidadPromedio));
			entity.setCategoriaEquipo((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo)));
			entity.setFabricanteEquipo((FacesUtils.checkLong(txtFabricEquipId_FabricanteEquipo)));
			businessDelegatorView.updateModeloEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedModeloEquipo = (ModeloEquipoDTO) (evt.getComponent().getAttributes().get("selectedModeloEquipo"));

			Long modeloEquipoId = new Long(selectedModeloEquipo.getModeloEquipoId());
			entity = businessDelegatorView.getModeloEquipo(modeloEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long modeloEquipoId = FacesUtils.checkLong(txtModeloEquipoId);
			entity = businessDelegatorView.getModeloEquipo(modeloEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteModeloEquipo(entity);
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
			selectedModeloEquipo = (ModeloEquipoDTO) (evt.getComponent().getAttributes().get("selectedModeloEquipo"));

			Long modeloEquipoId = new Long(selectedModeloEquipo.getModeloEquipoId());
			entity = businessDelegatorView.getModeloEquipo(modeloEquipoId);
			businessDelegatorView.deleteModeloEquipo(entity);
			data.remove(selectedModeloEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, Long modeloEquipoId, String nombre,
			Double velocidadPromedio, Long categEquipId_CategoriaEquipo, Long fabricEquipId_FabricanteEquipo)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setVelocidadPromedio(FacesUtils.checkDouble(velocidadPromedio));
			businessDelegatorView.updateModeloEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ModeloEquipoView").requestRender();
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

	public InputText getTxtVelocidadPromedio() {
		return txtVelocidadPromedio;
	}

	public void setTxtVelocidadPromedio(InputText txtVelocidadPromedio) {
		this.txtVelocidadPromedio = txtVelocidadPromedio;
	}

	public SelectOneMenu getTxtCategEquipId_CategoriaEquipo() {
		return txtCategEquipId_CategoriaEquipo;
	}

	public void setTxtCategEquipId_CategoriaEquipo(SelectOneMenu txtCategEquipId_CategoriaEquipo) {
		this.txtCategEquipId_CategoriaEquipo = txtCategEquipId_CategoriaEquipo;
	}

	public SelectOneMenu getTxtFabricEquipId_FabricanteEquipo() {
		return txtFabricEquipId_FabricanteEquipo;
	}

	public void setTxtFabricEquipId_FabricanteEquipo(SelectOneMenu txtFabricEquipId_FabricanteEquipo) {
		this.txtFabricEquipId_FabricanteEquipo = txtFabricEquipId_FabricanteEquipo;
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

	public InputText getTxtModeloEquipoId() {
		return txtModeloEquipoId;
	}

	public void setTxtModeloEquipoId(InputText txtModeloEquipoId) {
		this.txtModeloEquipoId = txtModeloEquipoId;
	}

	public List<ModeloEquipoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataModeloEquipo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ModeloEquipoDTO> modeloEquipoDTO) {
		this.data = modeloEquipoDTO;
	}

	public ModeloEquipoDTO getSelectedModeloEquipo() {
		return selectedModeloEquipo;
	}

	public void setSelectedModeloEquipo(ModeloEquipoDTO modeloEquipo) {
		this.selectedModeloEquipo = modeloEquipo;
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

	public SelectItem[] getselectCategoriaEquipo() {

		if (categoriaEquipo == null || categoriaEquipo.size() == 0) {

			categoriaEquipo = new ArrayList<CategoriaEquipo>();

			try {

				categoriaEquipo = businessDelegatorView.getCategoriaEquipo(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CategoriaEquipo> lista = businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null,
						null);
				selectCategoriaEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CategoriaEquipo categoriaEquipo : lista) {
					selectCategoriaEquipo[i] = new SelectItem(categoriaEquipo.getCategEquipId(),
							categoriaEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCategoriaEquipo;
	}

	public void setselectCategoriaEquipo(SelectItem[] selectCategoriaEquipo) {
		this.selectCategoriaEquipo = selectCategoriaEquipo;
	}

	public SelectItem[] getselectFabricanteEquipo() {

		if (fabricanteEquipo == null || fabricanteEquipo.size() == 0) {

			fabricanteEquipo = new ArrayList<FabricanteEquipo>();

			try {

				fabricanteEquipo = businessDelegatorView.getFabricanteEquipo(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FabricanteEquipo> lista = businessDelegatorView.findByCriteriaInFabricanteEquipo(condicion, null,
						null);
				selectFabricanteEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (FabricanteEquipo fabricanteEquipo : lista) {
					selectFabricanteEquipo[i] = new SelectItem(fabricanteEquipo.getFabricEquipId(),
							fabricanteEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFabricanteEquipo;
	}

	public void setselectFabricanteEquipo(SelectItem[] selectFabricanteEquipo) {
		this.selectFabricanteEquipo = selectFabricanteEquipo;
	}

}
