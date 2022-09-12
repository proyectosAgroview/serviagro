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
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Eventos;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.EventosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EventosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EventosView.class);
	private InputText txtCodigo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtEventosId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private InputText txtCompania;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EventosDTO> data;
	private EventosDTO selectedEventos;
	private Eventos entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;

	public EventosView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			EventosDTO eventosDTO = (EventosDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(eventosDTO.getCodigo());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(eventosDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(eventosDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(eventosDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(eventosDTO.getNombre());

			if (txtEventosId == null) {
				txtEventosId = new InputText();
			}

			txtEventosId.setValue(eventosDTO.getEventosId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(eventosDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(eventosDTO.getFechaModificacion());

			Long eventosId = FacesUtils.checkLong(txtEventosId);
			entity = businessDelegatorView.getEventos(eventosId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedEventos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedEventos = null;
		PrimeFaces.current().resetInputs(":dialogEventos :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
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

		if (txtEventosId != null) {
			txtEventosId.setValue(null);
			txtEventosId.setDisabled(false);
		}


		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(true);
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
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Eventos> lista = (codigo != null) ? businessDelegatorView
					.findByCriteriaInEventos(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils
						.addInfoMessage("Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
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
			txtElemCostoId_ElementoCosto.setDisabled(false);

			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
			txtElemCostoId_ElementoCosto.setDisabled(false);

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
			txtEventosId.setValue(entity.getEventosId());
			txtEventosId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedEventos = (EventosDTO) (evt.getComponent().getAttributes()
				.get("selectedEventos"));
		try {

			String codigo = selectedEventos.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Eventos> lista = (codigo != null) ? businessDelegatorView
					.findByCriteriaInEventos(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedEventos.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedEventos.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtElemCostoId_ElementoCosto.setValue(selectedEventos.getElemCostoId_ElementoCosto());
				txtElemCostoId_ElementoCosto.setDisabled(false);

				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtEventosId.setValue(entity.getEventosId());
				txtEventosId.setDisabled(true);
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
			if ((selectedEventos == null) && (entity == null)) {
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
	
	 public String getLoginSession() throws Exception{
			
			FacesContext fc = FacesContext.getCurrentInstance();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String login = null;
			String passWord = null;
			
			if(auth != null){
				
				login = auth.getName();
				
			}else{
				
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
			entity = new Eventos();
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
						
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto) != null) ? businessDelegatorView
				.getElementoCosto(FacesUtils.checkLong(txtElemCostoId_ElementoCosto))
				: null);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setEventosId(eventosId);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setCompania(compania);
			businessDelegatorView.saveEventos(entity);
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
				Long eventosId = new Long(selectedEventos.getEventosId());
				entity = businessDelegatorView.getEventos(eventosId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto) != null) ? businessDelegatorView
					.getElementoCosto(FacesUtils.checkLong(txtElemCostoId_ElementoCosto))
					: null);

			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setCompania(compania);
			businessDelegatorView.updateEventos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedEventos = (EventosDTO) (evt.getComponent().getAttributes()
					.get("selectedEventos"));

			Long eventosId = new Long(selectedEventos.getEventosId());
			entity = businessDelegatorView.getEventos(eventosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long eventosId = FacesUtils.checkLong(txtEventosId);
			entity = businessDelegatorView.getEventos(eventosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteEventos(entity);
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
			selectedEventos = (EventosDTO) (evt.getComponent().getAttributes()
					.get("selectedEventos"));

			Long eventosId = new Long(selectedEventos.getEventosId());
			entity = businessDelegatorView.getEventos(eventosId);
			businessDelegatorView.deleteEventos(entity);
			data.remove(selectedEventos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional,
			String infoAdicional2, Long eventosId, String nombre, Long compania)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setCompania(FacesUtils.checkLong(compania));
			businessDelegatorView.updateEventos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("EventosView").requestRender();
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

	public InputText getTxtEventosId() {
		return txtEventosId;
	}

	public void setTxtEventosId(InputText txtEventosId) {
		this.txtEventosId = txtEventosId;
	}

	public List<EventosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataEventos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<EventosDTO> eventosDTO) {
		this.data = eventosDTO;
	}

	public EventosDTO getSelectedEventos() {
		return selectedEventos;
	}

	public void setSelectedEventos(EventosDTO eventos) {
		this.selectedEventos = eventos;
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

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
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
	

	public SelectItem[] getselectElementoCosto() {

		if (elementoCosto == null || elementoCosto.size() == 0) {

			elementoCosto = new ArrayList<ElementoCosto>();

			try {

				elementoCosto = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView
						.findByCriteriaInElementoCosto(condicion, null, null);
				selectElementoCosto = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectElementoCosto[i] = new SelectItem(
							elementoCosto.getElemCostoId(),
							elementoCosto.getNombre());
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

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
	}

	
	

	
}
