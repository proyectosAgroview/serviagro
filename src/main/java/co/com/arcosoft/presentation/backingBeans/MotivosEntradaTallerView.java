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
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.MotivosEntradaTaller;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.MotivosEntradaTallerDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class MotivosEntradaTallerView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MotivosEntradaTallerView.class);
	private InputText txtCodigo;
	private SelectOneRadio txtEstado;
	private InputText txtNombre;
	private InputText txtMotivosEntradaTallerId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private InputText txtCompania;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<MotivosEntradaTallerDTO> data;
	private MotivosEntradaTallerDTO selectedMotivosEntradaTaller;
	private MotivosEntradaTaller entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public MotivosEntradaTallerView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			MotivosEntradaTallerDTO MotivosEntradaTallerDTO = (MotivosEntradaTallerDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(MotivosEntradaTallerDTO.getCodigo());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(MotivosEntradaTallerDTO.getEstado());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(MotivosEntradaTallerDTO.getNombre());

			if (txtMotivosEntradaTallerId == null) {
				txtMotivosEntradaTallerId = new InputText();
			}

			txtMotivosEntradaTallerId.setValue(MotivosEntradaTallerDTO.getMotivosEntradaTallerId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(MotivosEntradaTallerDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(MotivosEntradaTallerDTO.getFechaModificacion());

			Long MotivosEntradaTallerId = FacesUtils.checkLong(txtMotivosEntradaTallerId);
			entity = businessDelegatorView.getMotivosEntradaTaller(MotivosEntradaTallerId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedMotivosEntradaTaller = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedMotivosEntradaTaller = null;
		PrimeFaces.current().resetInputs(":dialogMotivosEntradaTaller :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
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

		if (txtMotivosEntradaTallerId != null) {
			txtMotivosEntradaTallerId.setValue(null);
			txtMotivosEntradaTallerId.setDisabled(false);
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
			List<MotivosEntradaTaller> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInMotivosEntradaTaller(condicion, null, null) : null;

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
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtMotivosEntradaTallerId.setValue(entity.getMotivosEntradaTallerId());
			txtMotivosEntradaTallerId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedMotivosEntradaTaller = (MotivosEntradaTallerDTO) (evt.getComponent().getAttributes()
				.get("selectedMotivosEntradaTaller"));
		try {

			String codigo = selectedMotivosEntradaTaller.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<MotivosEntradaTaller> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInMotivosEntradaTaller(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedMotivosEntradaTaller.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedMotivosEntradaTaller.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtMotivosEntradaTallerId.setValue(entity.getMotivosEntradaTallerId());
				txtMotivosEntradaTallerId.setDisabled(true);
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
			if ((selectedMotivosEntradaTaller == null) && (entity == null)) {
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
			entity = new MotivosEntradaTaller();
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			// entity.setMotivosEntradaTallerId(MotivosEntradaTallerId);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setCompania(compania);
			businessDelegatorView.saveMotivosEntradaTaller(entity);
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
				Long MotivosEntradaTallerId = new Long(selectedMotivosEntradaTaller.getMotivosEntradaTallerId());
				entity = businessDelegatorView.getMotivosEntradaTaller(MotivosEntradaTallerId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setCompania(compania);
			businessDelegatorView.updateMotivosEntradaTaller(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedMotivosEntradaTaller = (MotivosEntradaTallerDTO) (evt.getComponent().getAttributes()
					.get("selectedMotivosEntradaTaller"));

			Long MotivosEntradaTallerId = new Long(selectedMotivosEntradaTaller.getMotivosEntradaTallerId());
			entity = businessDelegatorView.getMotivosEntradaTaller(MotivosEntradaTallerId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long MotivosEntradaTallerId = FacesUtils.checkLong(txtMotivosEntradaTallerId);
			entity = businessDelegatorView.getMotivosEntradaTaller(MotivosEntradaTallerId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteMotivosEntradaTaller(entity);
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
			selectedMotivosEntradaTaller = (MotivosEntradaTallerDTO) (evt.getComponent().getAttributes()
					.get("selectedMotivosEntradaTaller"));

			Long MotivosEntradaTallerId = new Long(selectedMotivosEntradaTaller.getMotivosEntradaTallerId());
			entity = businessDelegatorView.getMotivosEntradaTaller(MotivosEntradaTallerId);
			businessDelegatorView.deleteMotivosEntradaTaller(entity);
			data.remove(selectedMotivosEntradaTaller);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String estado, Date fechaCreacion, Date fechaModificacion,
			String infoAdicional, String infoAdicional2, Long MotivosEntradaTallerId, String nombre, Long compania)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setCompania(FacesUtils.checkLong(compania));
			businessDelegatorView.updateMotivosEntradaTaller(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("MotivosEntradaTallerView").requestRender();
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

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
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

	public InputText getTxtMotivosEntradaTallerId() {
		return txtMotivosEntradaTallerId;
	}

	public void setTxtMotivosEntradaTallerId(InputText txtMotivosEntradaTallerId) {
		this.txtMotivosEntradaTallerId = txtMotivosEntradaTallerId;
	}

	public List<MotivosEntradaTallerDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataMotivosEntradaTaller();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<MotivosEntradaTallerDTO> MotivosEntradaTallerDTO) {
		this.data = MotivosEntradaTallerDTO;
	}

	public MotivosEntradaTallerDTO getSelectedMotivosEntradaTaller() {
		return selectedMotivosEntradaTaller;
	}

	public void setSelectedMotivosEntradaTaller(MotivosEntradaTallerDTO moneda) {
		this.selectedMotivosEntradaTaller = moneda;
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

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

}
