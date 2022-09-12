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
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Estado;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.CiudadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CiudadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CiudadView.class);
	private InputText txtCodigo;
	private SelectOneRadio txtEstado_1;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	// private InputText txtEstadoId_Estado;
	private InputText txtCiudadId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CiudadDTO> data;
	private CiudadDTO selectedCiudad;
	private Ciudad entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	// Select Pais
	private SelectOneMenu txtEstadoId_Estado;
	SelectItem[] selectEstado;
	private List<Estado> estado;

	public CiudadView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CiudadDTO ciudadDTO = (CiudadDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(ciudadDTO.getCodigo());

			if (txtEstado_1 == null) {
				txtEstado_1 = new SelectOneRadio();
			}

			txtEstado_1.setValue(ciudadDTO.getEstado_1());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(ciudadDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(ciudadDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(ciudadDTO.getNombre());

			if (txtEstadoId_Estado == null) {
				txtEstadoId_Estado = new SelectOneMenu();
			}

			txtEstadoId_Estado.setValue(ciudadDTO.getEstadoId_Estado());

			if (txtCiudadId == null) {
				txtCiudadId = new InputText();
			}

			txtCiudadId.setValue(ciudadDTO.getCiudadId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(ciudadDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(ciudadDTO.getFechaModificacion());

			Long ciudadId = FacesUtils.checkLong(txtCiudadId);
			entity = businessDelegatorView.getCiudad(ciudadId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCiudad = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCiudad = null;
		PrimeFaces.current().resetInputs(":dialogCiudad :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtEstado_1 != null) {
			txtEstado_1.setValue("A");
			txtEstado_1.setDisabled(true);
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

		if (txtEstadoId_Estado != null) {
			txtEstadoId_Estado.setValue(null);
			txtEstadoId_Estado.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtCiudadId != null) {
			txtCiudadId.setValue(null);
			txtCiudadId.setDisabled(false);
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
			Long ciudadId = FacesUtils.checkLong(txtCiudadId);
			entity = (ciudadId != null) ? businessDelegatorView.getCiudad(ciudadId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtEstado_1.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtEstadoId_Estado.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtCiudadId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtEstado_1.setValue(entity.getEstado_1());
			txtEstado_1.setDisabled(false);
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
			txtEstadoId_Estado.setValue(entity.getEstado().getEstadoId());
			txtEstadoId_Estado.setDisabled(false);
			txtCiudadId.setValue(entity.getCiudadId());
			txtCiudadId.setDisabled(true);
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
			List<Ciudad> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInCiudad(condicion, null, null)
					: null;

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
			txtEstado_1.setDisabled(false);
			txtEstadoId_Estado.setDisabled(false);
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
			txtEstado_1.setValue(entity.getEstado());
			txtEstado_1.setDisabled(false);
			txtEstadoId_Estado.setValue(entity.getEstado());
			txtEstadoId_Estado.setDisabled(false);
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
			txtCiudadId.setValue(entity.getCiudadId());
			txtCiudadId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCiudad = (CiudadDTO) (evt.getComponent().getAttributes().get("selectedCiudad"));
		try {

			String codigo = selectedCiudad.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Ciudad> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInCiudad(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado_1.setValue(entity.getEstado_1());
				txtEstado_1.setDisabled(false);
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
				txtEstadoId_Estado.setValue(entity.getEstado().getEstadoId());
				txtEstadoId_Estado.setDisabled(false);
				txtCiudadId.setValue(entity.getCiudadId());
				txtCiudadId.setDisabled(true);
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
			if ((selectedCiudad == null) && (entity == null)) {
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
			entity = new Ciudad();
			Date date = new Date();

			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado_1(FacesUtils.checkString(txtEstado_1));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setEstado((FacesUtils.checkLong(txtEstadoId_Estado) != null)
					? businessDelegatorView.getEstado(FacesUtils.checkLong(txtEstadoId_Estado)) : null);
			businessDelegatorView.saveCiudad(entity);
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
				Long ciudadId = new Long(selectedCiudad.getCiudadId());
				entity = businessDelegatorView.getCiudad(ciudadId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado_1(FacesUtils.checkString(txtEstado_1));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setEstado((FacesUtils.checkLong(txtEstadoId_Estado) != null)
					? businessDelegatorView.getEstado(FacesUtils.checkLong(txtEstadoId_Estado)) : null);
			businessDelegatorView.updateCiudad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCiudad = (CiudadDTO) (evt.getComponent().getAttributes().get("selectedCiudad"));

			Long ciudadId = new Long(selectedCiudad.getCiudadId());
			entity = businessDelegatorView.getCiudad(ciudadId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long ciudadId = FacesUtils.checkLong(txtCiudadId);
			entity = businessDelegatorView.getCiudad(ciudadId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCiudad(entity);
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
			selectedCiudad = (CiudadDTO) (evt.getComponent().getAttributes().get("selectedCiudad"));

			Long ciudadId = new Long(selectedCiudad.getCiudadId());
			entity = businessDelegatorView.getCiudad(ciudadId);
			businessDelegatorView.deleteCiudad(entity);
			data.remove(selectedCiudad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ciudadId, String codigo, String estado_1, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre, Long estadoId_Estado,
			Long compania) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setEstado_1(FacesUtils.checkString(estado_1));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setCompania(FacesUtils.checkLong(compania));
			businessDelegatorView.updateCiudad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CiudadView").requestRender();
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

	public SelectOneRadio getTxtEstado_1() {
		return txtEstado_1;
	}

	public void setTxtEstado_1(SelectOneRadio txtEstado_1) {
		this.txtEstado_1 = txtEstado_1;
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

	public SelectOneMenu getTxtEstadoId_Estado() {
		return txtEstadoId_Estado;
	}

	public void setTxtEstadoId_Estado(SelectOneMenu txtEstadoId_Estado) {
		this.txtEstadoId_Estado = txtEstadoId_Estado;
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

	public InputText getTxtCiudadId() {
		return txtCiudadId;
	}

	public void setTxtCiudadId(InputText txtCiudadId) {
		this.txtCiudadId = txtCiudadId;
	}

	public List<CiudadDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCiudad();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CiudadDTO> ciudadDTO) {
		this.data = ciudadDTO;
	}

	public CiudadDTO getSelectedCiudad() {
		return selectedCiudad;
	}

	public void setSelectedCiudad(CiudadDTO ciudad) {
		this.selectedCiudad = ciudad;
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

	public SelectItem[] getselectEstado() {

		if (estado == null || estado.size() == 0) {

			estado = new ArrayList<Estado>();

			try {

				estado = businessDelegatorView.getEstado(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Estado> lista = businessDelegatorView.findByCriteriaInEstado(condicion, null, null);
				selectEstado = new SelectItem[lista.size()];

				int i = 0;
				for (Estado estado : lista) {
					selectEstado[i] = new SelectItem(estado.getEstadoId(), estado.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEstado;
	}

	public void setselectEstado(SelectItem[] selectEstado) {
		this.selectEstado = selectEstado;
	}

}
