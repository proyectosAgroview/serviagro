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
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnioFiscal;
import co.com.arcosoft.modelo.Calendario;
import co.com.arcosoft.modelo.TipoDia;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.CalendarioDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CalendarioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CalendarioView.class);
	private InputText txtCodigo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	// private InputText txtAnioFiscalId_AnioFiscal;
	// private InputText txtTipDiaId_TipoDia;
	private InputText txtCalendarId;
	private Calendar txtDia;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CalendarioDTO> data;
	private CalendarioDTO selectedCalendario;
	private Calendario entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	// Select Tipo de dia
	private SelectOneMenu txtTipDiaId_TipoDia;
	SelectItem[] selectTipoDia;
	private List<TipoDia> tipoDia;

	// Select Año fiscal
	private SelectOneMenu txtAnioFiscalId_AnioFiscal;
	SelectItem[] selectAnioFiscal;
	private List<AnioFiscal> anioFiscal;

	private ScheduleModel eventModel;

	private ScheduleModel lazyEventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	public CalendarioView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CalendarioDTO calendarioDTO = (CalendarioDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(calendarioDTO.getCodigo());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(calendarioDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(calendarioDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(calendarioDTO.getInfoAdicional2());

			if (txtAnioFiscalId_AnioFiscal == null) {
				txtAnioFiscalId_AnioFiscal = new SelectOneMenu();
			}

			txtAnioFiscalId_AnioFiscal.setValue(calendarioDTO.getAnioFiscalId_AnioFiscal());

			if (txtTipDiaId_TipoDia == null) {
				txtTipDiaId_TipoDia = new SelectOneMenu();
			}

			txtTipDiaId_TipoDia.setValue(calendarioDTO.getTipDiaId_TipoDia());

			if (txtCalendarId == null) {
				txtCalendarId = new InputText();
			}

			txtCalendarId.setValue(calendarioDTO.getCalendarId());

			if (txtDia == null) {
				txtDia = new Calendar();
			}

			txtDia.setValue(calendarioDTO.getDia());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(calendarioDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(calendarioDTO.getFechaModificacion());

			Long calendarId = FacesUtils.checkLong(txtCalendarId);
			entity = businessDelegatorView.getCalendario(calendarId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCalendario = null;
		setShowDialog(true);
		PrimeFaces.current().resetInputs(":dialogCalendario :frm");

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCalendario = null;

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

		if (txtAnioFiscalId_AnioFiscal != null) {
			txtAnioFiscalId_AnioFiscal.setValue(null);
			txtAnioFiscalId_AnioFiscal.setDisabled(true);
		}

		if (txtTipDiaId_TipoDia != null) {
			txtTipDiaId_TipoDia.setValue(null);
			txtTipDiaId_TipoDia.setDisabled(true);
		}

		if (txtDia != null) {
			txtDia.setValue(null);
			txtDia.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtCalendarId != null) {
			txtCalendarId.setValue(null);
			txtCalendarId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtDia() {
		Date inputDate = (Date) txtDia.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
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
			Long calendarId = FacesUtils.checkLong(txtCalendarId);
			entity = (calendarId != null) ? businessDelegatorView.getCalendario(calendarId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtAnioFiscalId_AnioFiscal.setDisabled(false);
			txtTipDiaId_TipoDia.setDisabled(false);
			txtDia.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtCalendarId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDia.setValue(entity.getDia());
			txtDia.setDisabled(false);
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
			txtAnioFiscalId_AnioFiscal.setValue(entity.getAnioFiscal().getAnioFiscalId());
			txtAnioFiscalId_AnioFiscal.setDisabled(false);
			txtTipDiaId_TipoDia.setValue(entity.getTipoDia().getTipDiaId());
			txtTipDiaId_TipoDia.setDisabled(false);
			txtCalendarId.setValue(entity.getCalendarId());
			txtCalendarId.setDisabled(true);
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
			List<Calendario> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCalendario(condicion, null, null) : null;

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
			txtTipDiaId_TipoDia.setDisabled(false);
			txtAnioFiscalId_AnioFiscal.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtDia.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDia.setValue(entity.getDia());
			txtDia.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtTipDiaId_TipoDia.setValue(entity.getTipoDia().getTipDiaId());
			txtTipDiaId_TipoDia.setDisabled(false);
			txtAnioFiscalId_AnioFiscal.setValue(entity.getAnioFiscal().getAnioFiscalId());
			txtAnioFiscalId_AnioFiscal.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtCalendarId.setValue(entity.getCalendarId());
			txtCalendarId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCalendario = (CalendarioDTO) (evt.getComponent().getAttributes().get("selectedCalendario"));
		try {

			String codigo = selectedCalendario.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Calendario> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCalendario(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtDia.setValue(entity.getDia());
				txtDia.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedCalendario.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedCalendario.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtAnioFiscalId_AnioFiscal.setValue(entity.getAnioFiscal().getAnioFiscalId());
				txtAnioFiscalId_AnioFiscal.setDisabled(false);
				txtTipDiaId_TipoDia.setValue(entity.getTipoDia().getTipDiaId());
				txtTipDiaId_TipoDia.setDisabled(false);
				txtCalendarId.setValue(entity.getCalendarId());
				txtCalendarId.setDisabled(true);
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
			if ((selectedCalendario == null) && (entity == null)) {
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

		/*
		 * FacesContext.getCurrentInstance(); fc.addMessage(null, new
		 * FacesMessage("Autenticacion", "Nombre de usuario: "
		 * +login+" Password: "+passWord + " Id "+ user.getUsuarioId()+
		 * " Compania: ") );
		 */

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
			entity = new Calendario();

			// Long calendarId = FacesUtils.checkLong(txtCalendarId);
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			entity.setCompania(compania);
			// entity.setCalendarId(calendarId);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDia(FacesUtils.checkDate(txtDia));
			String estado = "A";
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setAnioFiscal((FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal) != null)
					? businessDelegatorView.getAnioFiscal(FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal)) : null);
			entity.setTipoDia((FacesUtils.checkLong(txtTipDiaId_TipoDia) != null)
					? businessDelegatorView.getTipoDia(FacesUtils.checkLong(txtTipDiaId_TipoDia)) : null);
			businessDelegatorView.saveCalendario(entity);
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
				Long calendarId = new Long(selectedCalendario.getCalendarId());
				entity = businessDelegatorView.getCalendario(calendarId);
			}
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDia(FacesUtils.checkDate(txtDia));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setAnioFiscal((FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal) != null)
					? businessDelegatorView.getAnioFiscal(FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal)) : null);
			entity.setTipoDia((FacesUtils.checkLong(txtTipDiaId_TipoDia) != null)
					? businessDelegatorView.getTipoDia(FacesUtils.checkLong(txtTipDiaId_TipoDia)) : null);
			businessDelegatorView.updateCalendario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCalendario = (CalendarioDTO) (evt.getComponent().getAttributes().get("selectedCalendario"));

			Long calendarId = new Long(selectedCalendario.getCalendarId());
			entity = businessDelegatorView.getCalendario(calendarId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long calendarId = FacesUtils.checkLong(txtCalendarId);
			entity = businessDelegatorView.getCalendario(calendarId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCalendario(entity);
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
			selectedCalendario = (CalendarioDTO) (evt.getComponent().getAttributes().get("selectedCalendario"));

			Long calendarId = new Long(selectedCalendario.getCalendarId());
			entity = businessDelegatorView.getCalendario(calendarId);
			businessDelegatorView.deleteCalendario(entity);
			data.remove(selectedCalendario);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long calendarId, String codigo, Date dia, String estado, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, Long anioFiscalId_AnioFiscal,
			Long tipDiaId_TipoDia) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDia(FacesUtils.checkDate(dia));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			businessDelegatorView.updateCalendario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CalendarioView").requestRender();
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

	public SelectOneMenu getTxtAnioFiscalId_AnioFiscal() {
		return txtAnioFiscalId_AnioFiscal;
	}

	public void setTxtAnioFiscalId_AnioFiscal(SelectOneMenu txtAnioFiscalId_AnioFiscal) {
		this.txtAnioFiscalId_AnioFiscal = txtAnioFiscalId_AnioFiscal;
	}

	public SelectOneMenu getTxtTipDiaId_TipoDia() {
		return txtTipDiaId_TipoDia;
	}

	public void setTxtTipDiaId_TipoDia(SelectOneMenu txtTipDiaId_TipoDia) {
		this.txtTipDiaId_TipoDia = txtTipDiaId_TipoDia;
	}

	public Calendar getTxtDia() {
		return txtDia;
	}

	public void setTxtDia(Calendar txtDia) {
		this.txtDia = txtDia;
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

	public InputText getTxtCalendarId() {
		return txtCalendarId;
	}

	public void setTxtCalendarId(InputText txtCalendarId) {
		this.txtCalendarId = txtCalendarId;
	}

	public List<CalendarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCalendario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CalendarioDTO> calendarioDTO) {
		this.data = calendarioDTO;
	}

	public CalendarioDTO getSelectedCalendario() {
		return selectedCalendario;
	}

	public void setSelectedCalendario(CalendarioDTO calendario) {
		this.selectedCalendario = calendario;
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

	public SelectItem[] getSelectTipoDia() {

		if (tipoDia == null || tipoDia.size() == 0) {

			tipoDia = new ArrayList<TipoDia>();

			try {

				tipoDia = businessDelegatorView.getTipoDia(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoDia> lista = businessDelegatorView.findByCriteriaInTipoDia(condicion, null, null);
				selectTipoDia = new SelectItem[lista.size()];

				int i = 0;
				for (TipoDia tipoDia : lista) {
					selectTipoDia[i] = new SelectItem(tipoDia.getTipDiaId(), tipoDia.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoDia;
	}

	public void setSelectTipoDia(SelectItem[] selectTipoDia) {
		this.selectTipoDia = selectTipoDia;
	}

	public SelectItem[] getSelectAnioFiscal() {

		if (anioFiscal == null || anioFiscal.size() == 0) {

			anioFiscal = new ArrayList<AnioFiscal>();

			try {

				anioFiscal = businessDelegatorView.getAnioFiscal(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<AnioFiscal> lista = businessDelegatorView.findByCriteriaInAnioFiscal(condicion, null, null);
				selectAnioFiscal = new SelectItem[lista.size()];

				int i = 0;
				for (AnioFiscal anioFiscal : lista) {
					selectAnioFiscal[i] = new SelectItem(anioFiscal.getAnioFiscalId(), anioFiscal.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAnioFiscal;
	}

	public void setSelectAnioFiscal(SelectItem[] selectAnioFiscal) {
		this.selectAnioFiscal = selectAnioFiscal;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);

		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
