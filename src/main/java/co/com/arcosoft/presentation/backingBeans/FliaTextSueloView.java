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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.FliaTextSuelo;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.FliaTextSueloDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class FliaTextSueloView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FliaTextSueloView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtFliaTextSueloId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FliaTextSueloDTO> data;
	private FliaTextSueloDTO selectedFliaTextSuelo;
	private FliaTextSuelo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public FliaTextSueloView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FliaTextSueloDTO fliaTextSueloDTO = (FliaTextSueloDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(fliaTextSueloDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(fliaTextSueloDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(fliaTextSueloDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(fliaTextSueloDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(fliaTextSueloDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(fliaTextSueloDTO.getNombre());

			if (txtFliaTextSueloId == null) {
				txtFliaTextSueloId = new InputText();
			}

			txtFliaTextSueloId.setValue(fliaTextSueloDTO.getFliaTextSueloId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(fliaTextSueloDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(fliaTextSueloDTO.getFechaModificacion());

			Long fliaTextSueloId = FacesUtils.checkLong(txtFliaTextSueloId);
			entity = businessDelegatorView.getFliaTextSuelo(fliaTextSueloId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFliaTextSuelo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFliaTextSuelo = null;
		PrimeFaces.current().resetInputs(":dialogFliaTextSuelo :frm");

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

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFliaTextSueloId != null) {
			txtFliaTextSueloId.setValue(null);
			txtFliaTextSueloId.setDisabled(false);
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
			Long fliaTextSueloId = FacesUtils.checkLong(txtFliaTextSueloId);
			entity = (fliaTextSueloId != null) ? businessDelegatorView.getFliaTextSuelo(fliaTextSueloId) : null;
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
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFliaTextSueloId.setDisabled(false);
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
			txtFliaTextSueloId.setValue(entity.getFliaTextSueloId());
			txtFliaTextSueloId.setDisabled(true);
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
			List<FliaTextSuelo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFliaTextSuelo(condicion, null, null) : null;

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
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
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
			txtFliaTextSueloId.setValue(entity.getFliaTextSueloId());
			txtFliaTextSueloId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFliaTextSuelo = (FliaTextSueloDTO) (evt.getComponent().getAttributes().get("selectedFliaTextSuelo"));
		try {

			String codigo = selectedFliaTextSuelo.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<FliaTextSuelo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFliaTextSuelo(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(selectedFliaTextSuelo.getCompania());
				// txtCompania.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedFliaTextSuelo.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedFliaTextSuelo.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtFliaTextSueloId.setValue(entity.getFliaTextSueloId());
				txtFliaTextSueloId.setDisabled(true);
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
			if ((selectedFliaTextSuelo == null) && (entity == null)) {
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
			entity = new FliaTextSuelo();
			Date date = new Date();
			// Long fliaTextSueloId = FacesUtils.checkLong(txtFliaTextSueloId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			// entity.setFliaTextSueloId(fliaTextSueloId);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			businessDelegatorView.saveFliaTextSuelo(entity);
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
				Long fliaTextSueloId = new Long(selectedFliaTextSuelo.getFliaTextSueloId());
				entity = businessDelegatorView.getFliaTextSuelo(fliaTextSueloId);
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
			businessDelegatorView.updateFliaTextSuelo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedFliaTextSuelo = (FliaTextSueloDTO) (evt.getComponent().getAttributes()
					.get("selectedFliaTextSuelo"));

			Long fliaTextSueloId = new Long(selectedFliaTextSuelo.getFliaTextSueloId());
			entity = businessDelegatorView.getFliaTextSuelo(fliaTextSueloId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long fliaTextSueloId = FacesUtils.checkLong(txtFliaTextSueloId);
			entity = businessDelegatorView.getFliaTextSuelo(fliaTextSueloId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteFliaTextSuelo(entity);
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
			selectedFliaTextSuelo = (FliaTextSueloDTO) (evt.getComponent().getAttributes()
					.get("selectedFliaTextSuelo"));

			Long fliaTextSueloId = new Long(selectedFliaTextSuelo.getFliaTextSueloId());
			entity = businessDelegatorView.getFliaTextSuelo(fliaTextSueloId);
			businessDelegatorView.deleteFliaTextSuelo(entity);
			data.remove(selectedFliaTextSuelo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, Long fliaTextSueloId, String infoAdicional, String infoAdicional2, String nombre)
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
			businessDelegatorView.updateFliaTextSuelo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FliaTextSueloView").requestRender();
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

	public InputText getTxtFliaTextSueloId() {
		return txtFliaTextSueloId;
	}

	public void setTxtFliaTextSueloId(InputText txtFliaTextSueloId) {
		this.txtFliaTextSueloId = txtFliaTextSueloId;
	}

	public List<FliaTextSueloDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFliaTextSuelo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FliaTextSueloDTO> fliaTextSueloDTO) {
		this.data = fliaTextSueloDTO;
	}

	public FliaTextSueloDTO getSelectedFliaTextSuelo() {
		return selectedFliaTextSuelo;
	}

	public void setSelectedFliaTextSuelo(FliaTextSueloDTO fliaTextSuelo) {
		this.selectedFliaTextSuelo = fliaTextSuelo;
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
}