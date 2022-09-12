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
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.NumeroEje;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.NumeroEjeDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class NumeroEjeView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(NumeroEjeView.class);
	private Spinner txtCantidadEjes;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtPesoMaximo;
	private InputText txtPesoMinimo;
	private InputText txtNumEjeId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<NumeroEjeDTO> data;
	private NumeroEjeDTO selectedNumeroEje;
	private NumeroEje entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public NumeroEjeView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			NumeroEjeDTO numeroEjeDTO = (NumeroEjeDTO) e.getObject();

			if (txtCantidadEjes == null) {
				txtCantidadEjes = new Spinner();
			}

			txtCantidadEjes.setValue(numeroEjeDTO.getCantidadEjes());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(numeroEjeDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(numeroEjeDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(numeroEjeDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(numeroEjeDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(numeroEjeDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(numeroEjeDTO.getNombre());

			if (txtPesoMaximo == null) {
				txtPesoMaximo = new InputText();
			}

			txtPesoMaximo.setValue(numeroEjeDTO.getPesoMaximo());

			if (txtPesoMinimo == null) {
				txtPesoMinimo = new InputText();
			}

			txtPesoMinimo.setValue(numeroEjeDTO.getPesoMinimo());

			if (txtNumEjeId == null) {
				txtNumEjeId = new InputText();
			}

			txtNumEjeId.setValue(numeroEjeDTO.getNumEjeId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(numeroEjeDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(numeroEjeDTO.getFechaModificacion());

			Long numEjeId = FacesUtils.checkLong(txtNumEjeId);
			entity = businessDelegatorView.getNumeroEje(numEjeId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedNumeroEje = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedNumeroEje = null;
		PrimeFaces.current().resetInputs(":dialogNumeroEje :frm");

		if (txtCantidadEjes != null) {
			txtCantidadEjes.setValue(null);
			txtCantidadEjes.setDisabled(true);
		}

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

		if (txtPesoMaximo != null) {
			txtPesoMaximo.setValue(null);
			txtPesoMaximo.setDisabled(true);
		}

		if (txtPesoMinimo != null) {
			txtPesoMinimo.setValue(null);
			txtPesoMinimo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtNumEjeId != null) {
			txtNumEjeId.setValue(null);
			txtNumEjeId.setDisabled(false);
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
			Long numEjeId = FacesUtils.checkLong(txtNumEjeId);
			entity = (numEjeId != null) ? businessDelegatorView.getNumeroEje(numEjeId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCantidadEjes.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPesoMaximo.setDisabled(false);
			txtPesoMinimo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtNumEjeId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadEjes.setValue(entity.getCantidadEjes());
			txtCantidadEjes.setDisabled(false);
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
			txtPesoMaximo.setValue(entity.getPesoMaximo());
			txtPesoMaximo.setDisabled(false);
			txtPesoMinimo.setValue(entity.getPesoMinimo());
			txtPesoMinimo.setDisabled(false);
			txtNumEjeId.setValue(entity.getNumEjeId());
			txtNumEjeId.setDisabled(true);
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
			List<NumeroEje> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInNumeroEje(condicion, null, null) : null;

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
			txtCantidadEjes.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPesoMaximo.setDisabled(false);
			txtPesoMinimo.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtNumEjeId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadEjes.setValue(entity.getCantidadEjes());
			txtCantidadEjes.setDisabled(false);
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
			txtPesoMaximo.setValue(entity.getPesoMaximo());
			txtPesoMaximo.setDisabled(false);
			txtPesoMinimo.setValue(entity.getPesoMinimo());
			txtPesoMinimo.setDisabled(false);
			txtNumEjeId.setValue(entity.getNumEjeId());
			txtNumEjeId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedNumeroEje = (NumeroEjeDTO) (evt.getComponent().getAttributes().get("selectedNumeroEje"));

		try {

			String codigo = selectedNumeroEje.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<NumeroEje> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInNumeroEje(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCantidadEjes.setValue(entity.getCantidadEjes());
				txtCantidadEjes.setDisabled(false);
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
				txtPesoMaximo.setValue(entity.getPesoMaximo());
				txtPesoMaximo.setDisabled(false);
				txtPesoMinimo.setValue(entity.getPesoMinimo());
				txtPesoMinimo.setDisabled(false);
				txtNumEjeId.setValue(entity.getNumEjeId());
				txtNumEjeId.setDisabled(true);
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
			if ((selectedNumeroEje == null) && (entity == null)) {
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
			entity = new NumeroEje();
			Date date = new Date();
			// Long numEjeId = FacesUtils.checkLong(txtNumEjeId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setCantidadEjes(FacesUtils.checkDouble(txtCantidadEjes));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			// entity.setNumEjeId(numEjeId);
			entity.setPesoMaximo(FacesUtils.checkDouble(txtPesoMaximo));
			entity.setPesoMinimo(FacesUtils.checkDouble(txtPesoMinimo));
			businessDelegatorView.saveNumeroEje(entity);
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
				Long numEjeId = new Long(selectedNumeroEje.getNumEjeId());
				entity = businessDelegatorView.getNumeroEje(numEjeId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCantidadEjes(FacesUtils.checkDouble(txtCantidadEjes));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPesoMaximo(FacesUtils.checkDouble(txtPesoMaximo));
			entity.setPesoMinimo(FacesUtils.checkDouble(txtPesoMinimo));
			businessDelegatorView.updateNumeroEje(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedNumeroEje = (NumeroEjeDTO) (evt.getComponent().getAttributes().get("selectedNumeroEje"));

			Long numEjeId = new Long(selectedNumeroEje.getNumEjeId());
			entity = businessDelegatorView.getNumeroEje(numEjeId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long numEjeId = FacesUtils.checkLong(txtNumEjeId);
			entity = businessDelegatorView.getNumeroEje(numEjeId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteNumeroEje(entity);
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
			selectedNumeroEje = (NumeroEjeDTO) (evt.getComponent().getAttributes().get("selectedNumeroEje"));

			Long numEjeId = new Long(selectedNumeroEje.getNumEjeId());
			entity = businessDelegatorView.getNumeroEje(numEjeId);
			businessDelegatorView.deleteNumeroEje(entity);
			data.remove(selectedNumeroEje);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long cantidadEjes, String codigo, Long compania, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre,
			Long numEjeId, Double pesoMaximo, Double pesoMinimo) throws Exception {
		try {
			entity.setCantidadEjes(FacesUtils.checkDouble(cantidadEjes));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPesoMaximo(FacesUtils.checkDouble(pesoMaximo));
			entity.setPesoMinimo(FacesUtils.checkDouble(pesoMinimo));
			businessDelegatorView.updateNumeroEje(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("NumeroEjeView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public Spinner getTxtCantidadEjes() {
		return txtCantidadEjes;
	}

	public void setTxtCantidadEjes(Spinner txtCantidadEjes) {
		this.txtCantidadEjes = txtCantidadEjes;
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

	public InputText getTxtPesoMaximo() {
		return txtPesoMaximo;
	}

	public void setTxtPesoMaximo(InputText txtPesoMaximo) {
		this.txtPesoMaximo = txtPesoMaximo;
	}

	public InputText getTxtPesoMinimo() {
		return txtPesoMinimo;
	}

	public void setTxtPesoMinimo(InputText txtPesoMinimo) {
		this.txtPesoMinimo = txtPesoMinimo;
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

	public InputText getTxtNumEjeId() {
		return txtNumEjeId;
	}

	public void setTxtNumEjeId(InputText txtNumEjeId) {
		this.txtNumEjeId = txtNumEjeId;
	}

	public List<NumeroEjeDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataNumeroEje();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<NumeroEjeDTO> numeroEjeDTO) {
		this.data = numeroEjeDTO;
	}

	public NumeroEjeDTO getSelectedNumeroEje() {
		return selectedNumeroEje;
	}

	public void setSelectedNumeroEje(NumeroEjeDTO numeroEje) {
		this.selectedNumeroEje = numeroEje;
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
