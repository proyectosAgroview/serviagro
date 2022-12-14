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
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Transportadora;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.TransportadoraDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TransportadoraView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TransportadoraView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtDireccion;
	private InputText txtEmail;
	private SelectOneRadio txtEstado;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNit;
	private InputText txtNombre;
	private InputMask txtTelefono;
	private InputText txtTranspId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TransportadoraDTO> data;
	private TransportadoraDTO selectedTransportadora;
	private Transportadora entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TransportadoraView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TransportadoraDTO transportadoraDTO = (TransportadoraDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(transportadoraDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(transportadoraDTO.getCompania());

			if (txtDireccion == null) {
				txtDireccion = new InputText();
			}

			txtDireccion.setValue(transportadoraDTO.getDireccion());

			if (txtEmail == null) {
				txtEmail = new InputText();
			}

			txtEmail.setValue(transportadoraDTO.getEmail());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(transportadoraDTO.getEstado());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(transportadoraDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(transportadoraDTO.getFechaModificacion());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(transportadoraDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(transportadoraDTO.getInfoAdicional2());

			if (txtNit == null) {
				txtNit = new InputText();
			}

			txtNit.setValue(transportadoraDTO.getNit());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(transportadoraDTO.getNombre());

			if (txtTelefono == null) {
				txtTelefono = new InputMask();
			}

			txtTelefono.setValue(transportadoraDTO.getTelefono());

			if (txtTranspId == null) {
				txtTranspId = new InputText();
			}

			txtTranspId.setValue(transportadoraDTO.getTranspId());

			Long transpId = FacesUtils.checkLong(txtTranspId);
			entity = businessDelegatorView.getTransportadora(transpId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTransportadora = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTransportadora = null;
		PrimeFaces.current().resetInputs(":dialogTransportadora :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(true);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtNit != null) {
			txtNit.setValue(null);
			txtNit.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtTranspId != null) {
			txtTranspId.setValue(null);
			txtTranspId.setDisabled(false);
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
			Long transpId = FacesUtils.checkLong(txtTranspId);
			entity = (transpId != null) ? businessDelegatorView.getTransportadora(transpId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			txtEstado.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNit.setDisabled(false);
			txtNombre.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTranspId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
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
			txtNit.setValue(entity.getNit());
			txtNit.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTranspId.setValue(entity.getTranspId());
			txtTranspId.setDisabled(true);
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
			List<Transportadora> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTransportadora(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El C??digo digitado no existe!, si deseas puedes crear un nuevo registro con el c??digo: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}
		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNit.setDisabled(false);
			txtNombre.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTranspId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
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
			txtNit.setValue(entity.getNit());
			txtNit.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTranspId.setValue(entity.getTranspId());
			txtTranspId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTransportadora = (TransportadoraDTO) (evt.getComponent().getAttributes().get("selectedTransportadora"));

		try {

			String codigo = selectedTransportadora.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Transportadora> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTransportadora(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtDireccion.setValue(entity.getDireccion());
				txtDireccion.setDisabled(false);
				txtEmail.setValue(entity.getEmail());
				txtEmail.setDisabled(false);
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
				txtNit.setValue(entity.getNit());
				txtNit.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				txtTranspId.setValue(entity.getTranspId());
				txtTranspId.setDisabled(true);
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
			if ((selectedTransportadora == null) && (entity == null)) {
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
			entity = new Transportadora();

			// Long transpId = FacesUtils.checkLong(txtTranspId);
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkString(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNit(FacesUtils.checkString(txtNit));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			// entity.setTranspId(transpId);
			businessDelegatorView.saveTransportadora(entity);
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
				Long transpId = new Long(selectedTransportadora.getTranspId());
				entity = businessDelegatorView.getTransportadora(transpId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkString(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNit(FacesUtils.checkString(txtNit));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			businessDelegatorView.updateTransportadora(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTransportadora = (TransportadoraDTO) (evt.getComponent().getAttributes()
					.get("selectedTransportadora"));

			Long transpId = new Long(selectedTransportadora.getTranspId());
			entity = businessDelegatorView.getTransportadora(transpId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long transpId = FacesUtils.checkLong(txtTranspId);
			entity = businessDelegatorView.getTransportadora(transpId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTransportadora(entity);
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
			selectedTransportadora = (TransportadoraDTO) (evt.getComponent().getAttributes()
					.get("selectedTransportadora"));

			Long transpId = new Long(selectedTransportadora.getTranspId());
			entity = businessDelegatorView.getTransportadora(transpId);
			businessDelegatorView.deleteTransportadora(entity);
			data.remove(selectedTransportadora);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String direccion, String email, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nit,
			String nombre, String telefono, Long transpId) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNit(FacesUtils.checkString(nit));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setTelefono(FacesUtils.checkString(telefono));
			businessDelegatorView.updateTransportadora(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TransportadoraView").requestRender();
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

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
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

	public InputText getTxtNit() {
		return txtNit;
	}

	public void setTxtNit(InputText txtNit) {
		this.txtNit = txtNit;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputMask getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputMask txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public InputText getTxtTranspId() {
		return txtTranspId;
	}

	public void setTxtTranspId(InputText txtTranspId) {
		this.txtTranspId = txtTranspId;
	}

	public List<TransportadoraDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTransportadora();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TransportadoraDTO> transportadoraDTO) {
		this.data = transportadoraDTO;
	}

	public TransportadoraDTO getSelectedTransportadora() {
		return selectedTransportadora;
	}

	public void setSelectedTransportadora(TransportadoraDTO transportadora) {
		this.selectedTransportadora = transportadora;
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
