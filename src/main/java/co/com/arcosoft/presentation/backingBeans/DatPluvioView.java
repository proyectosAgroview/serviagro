package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPluvio;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatPluvioDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatPluvioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPluvioView.class);
	private InputText txtCompania;
	private InputText txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtPrecipitacion;
	private InputText txtTemperaturaMaxima;
	private InputText txtTemperaturaMedia;
	private InputText txtTemperaturaMinima;
	private InputText txtDatPluvioId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaPrecipitacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatPluvioDTO> data;
	private DatPluvioDTO selectedDatPluvio;
	private DatPluvio entity;
	private boolean showDialog;

	// Select Estaciones Pluviometricas
	private SelectOneMenu txtEstPluvioId_EstPluvio;
	SelectItem[] selectEstPluvio;
	private List<EstPluvio> estPluvio;

	private double result;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
	public DatPluvioView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatPluvioDTO datPluvioDTO = (DatPluvioDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datPluvioDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(datPluvioDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(datPluvioDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(datPluvioDTO.getInfoAdicional2());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datPluvioDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datPluvioDTO.getObservacionAnularReg());

			if (txtPrecipitacion == null) {
				txtPrecipitacion = new InputText();
			}

			txtPrecipitacion.setValue(datPluvioDTO.getPrecipitacion());

			if (txtTemperaturaMaxima == null) {
				txtTemperaturaMaxima = new InputText();
			}

			txtTemperaturaMaxima.setValue(datPluvioDTO.getTemperaturaMaxima());

			if (txtTemperaturaMedia == null) {
				txtTemperaturaMedia = new InputText();
			}

			txtTemperaturaMedia.setValue(datPluvioDTO.getTemperaturaMedia());

			if (txtTemperaturaMinima == null) {
				txtTemperaturaMinima = new InputText();
			}

			txtTemperaturaMinima.setValue(datPluvioDTO.getTemperaturaMinima());

			if (txtEstPluvioId_EstPluvio == null) {
				txtEstPluvioId_EstPluvio = new SelectOneMenu();
			}

			txtEstPluvioId_EstPluvio.setValue(datPluvioDTO.getEstPluvioId_EstPluvio());

			if (txtDatPluvioId == null) {
				txtDatPluvioId = new InputText();
			}

			txtDatPluvioId.setValue(datPluvioDTO.getDatPluvioId());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datPluvioDTO.getFechaAnulacion());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datPluvioDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datPluvioDTO.getFechaModificacion());

			if (txtFechaPrecipitacion == null) {
				txtFechaPrecipitacion = new Calendar();
			}

			txtFechaPrecipitacion.setValue(datPluvioDTO.getFechaPrecipitacion());

			Long datPluvioId = FacesUtils.checkLong(txtDatPluvioId);
			entity = businessDelegatorView.getDatPluvio(datPluvioId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatPluvio = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatPluvio = null;
		PrimeFaces.current().resetInputs(":dialogDatPluvio :frm");
		PrimeFaces.current().resetInputs(":dialogAnularReg :formDialogAnularReg");

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtPrecipitacion != null) {
			txtPrecipitacion.setValue(null);
			txtPrecipitacion.setDisabled(false);
		}

		if (txtTemperaturaMaxima != null) {
			txtTemperaturaMaxima.setValue(null);
			txtTemperaturaMaxima.setDisabled(false);
		}

		if (txtTemperaturaMedia != null) {
			txtTemperaturaMedia.setValue(null);
			txtTemperaturaMedia.setDisabled(true);
		}

		if (txtTemperaturaMinima != null) {
			txtTemperaturaMinima.setValue(null);
			txtTemperaturaMinima.setDisabled(false);
		}

		if (txtEstPluvioId_EstPluvio != null) {
			txtEstPluvioId_EstPluvio.setValue(null);
			txtEstPluvioId_EstPluvio.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaPrecipitacion != null) {
			txtFechaPrecipitacion.setValue(null);
			txtFechaPrecipitacion.setDisabled(false);
		}

		if (txtDatPluvioId != null) {
			txtDatPluvioId.setValue(null);
			txtDatPluvioId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	public void listener_txtFechaAnulacion() {
		Date inputDate = (Date) txtFechaAnulacion.getValue();
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

	public void listener_txtFechaPrecipitacion() {
		Date inputDate = (Date) txtFechaPrecipitacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long datPluvioId = FacesUtils.checkLong(txtDatPluvioId);
			entity = (datPluvioId != null) ? businessDelegatorView.getDatPluvio(datPluvioId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setDisabled(false);
			txtPrecipitacion.setDisabled(false);
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setDisabled(false);
			txtEstPluvioId_EstPluvio.setDisabled(false);
			txtFechaAnulacion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaPrecipitacion.setDisabled(false);
			txtDatPluvioId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaAnulacion.setValue(entity.getFechaAnulacion());
			txtFechaAnulacion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaPrecipitacion.setValue(entity.getFechaPrecipitacion());
			txtFechaPrecipitacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setValue(entity.getObservacionAnularReg());
			txtObservacionAnularReg.setDisabled(false);
			txtPrecipitacion.setValue(entity.getPrecipitacion());
			txtPrecipitacion.setDisabled(false);
			txtTemperaturaMaxima.setValue(entity.getTemperaturaMaxima());
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setValue(entity.getTemperaturaMedia());
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setValue(entity.getTemperaturaMinima());
			txtTemperaturaMinima.setDisabled(false);
			txtEstPluvioId_EstPluvio.setValue(entity.getEstPluvio().getEstPluvioId());
			txtEstPluvioId_EstPluvio.setDisabled(false);
			txtDatPluvioId.setValue(entity.getDatPluvioId());
			txtDatPluvioId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {

		selectedDatPluvio = (DatPluvioDTO) (evt.getComponent().getAttributes().get("selectedDatPluvio"));

		try {

			Long datPluvioId = new Long(selectedDatPluvio.getDatPluvioId());
			entity = businessDelegatorView.getDatPluvio(datPluvioId);

			// txtCompania.setValue(selectedDatPluvio.getCompania());
			// txtCompania.setDisabled(false);
			// txtEstado.setValue(selectedDatPluvio.getEstado());
			// txtEstado.setDisabled(false);
			// txtFechaAnulacion.setValue(selectedDatPluvio.getFechaAnulacion());
			// txtFechaAnulacion.setDisabled(false);
			// txtFechaCreacion.setValue(selectedDatPluvio.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(selectedDatPluvio.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtFechaPrecipitacion.setValue(entity.getFechaPrecipitacion());
			txtFechaPrecipitacion.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			// txtObservacionAnularReg.setValue(selectedDatPluvio.getObservacionAnularReg());
			// txtObservacionAnularReg.setDisabled(false);
			txtPrecipitacion.setValue(entity.getPrecipitacion());
			txtPrecipitacion.setDisabled(false);
			txtTemperaturaMaxima.setValue(entity.getTemperaturaMaxima());
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setValue(entity.getTemperaturaMedia());
			txtTemperaturaMedia.setDisabled(true);
			txtTemperaturaMinima.setValue(entity.getTemperaturaMinima());
			txtTemperaturaMinima.setDisabled(false);
			txtEstPluvioId_EstPluvio.setValue(entity.getEstPluvio().getEstPluvioId());
			txtEstPluvioId_EstPluvio.setDisabled(false);
			txtDatPluvioId.setValue(entity.getDatPluvioId());
			txtDatPluvioId.setDisabled(true);
			btnSave.setDisabled(false);
			setShowDialog(true);

		} catch (Exception e) {
			entity = null;
		}
		return "";

	}

	public String action_save() {
		try {
			if ((selectedDatPluvio == null) && (entity == null)) {
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
			entity = new DatPluvio();
			Date date = new Date();
			// Long datPluvioId = FacesUtils.checkLong(txtDatPluvioId);

			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setDatPluvioId(datPluvioId);
			String estado = "A";
			entity.setEstado(estado);
			// entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaModificacion(date);
			entity.setFechaPrecipitacion(FacesUtils.checkDate(txtFechaPrecipitacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setConsecutivo(
					(businessDelegator2View.consultarConsec_dat_pluvio(compania)));
			

			
			/*
			 * entity.setObservacionAnularReg(FacesUtils.checkString(
			 * txtObservacionAnularReg));
			 */
			entity.setPrecipitacion(FacesUtils.checkDouble(txtPrecipitacion));
			entity.setTemperaturaMaxima(FacesUtils.checkDouble(txtTemperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkDouble(txtTemperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkDouble(txtTemperaturaMinima));
			entity.setEstPluvio((FacesUtils.checkLong(txtEstPluvioId_EstPluvio) != null)
					? businessDelegatorView.getEstPluvio(FacesUtils.checkLong(txtEstPluvioId_EstPluvio)) : null);
			businessDelegatorView.saveDatPluvio(entity);
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
				Long datPluvioId = new Long(selectedDatPluvio.getDatPluvioId());
				entity = businessDelegatorView.getDatPluvio(datPluvioId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(entity.getFechaCreacion());
			entity.setFechaModificacion(date);
			entity.setFechaPrecipitacion(FacesUtils.checkDate(txtFechaPrecipitacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			/*
			 * entity.setObservacionAnularReg(FacesUtils.checkString(
			 * txtObservacionAnularReg));
			 */
			entity.setPrecipitacion(FacesUtils.checkDouble(txtPrecipitacion));
			entity.setTemperaturaMaxima(FacesUtils.checkDouble(txtTemperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkDouble(txtTemperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkDouble(txtTemperaturaMinima));
			entity.setEstPluvio((FacesUtils.checkLong(txtEstPluvioId_EstPluvio) != null)
					? businessDelegatorView.getEstPluvio(FacesUtils.checkLong(txtEstPluvioId_EstPluvio)) : null);
			businessDelegatorView.updateDatPluvio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatPluvio = (DatPluvioDTO) (evt.getComponent().getAttributes().get("selectedDatPluvio"));

			Long datPluvioId = new Long(selectedDatPluvio.getDatPluvioId());
			entity = businessDelegatorView.getDatPluvio(datPluvioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datPluvioId = FacesUtils.checkLong(txtDatPluvioId);
			entity = businessDelegatorView.getDatPluvio(datPluvioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatPluvio(entity);
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
			selectedDatPluvio = (DatPluvioDTO) (evt.getComponent().getAttributes().get("selectedDatPluvio"));

			Long datPluvioId = new Long(selectedDatPluvio.getDatPluvioId());
			entity = businessDelegatorView.getDatPluvio(datPluvioId);
			businessDelegatorView.deleteDatPluvio(entity);
			((Map<String, Object>) data).remove(selectedDatPluvio);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long datPluvioId, String estado, Date fechaAnulacion,
			Date fechaCreacion, Date fechaModificacion, Date fechaPrecipitacion, String infoAdicional,
			String infoAdicional2, String observacion, String observacionAnularReg, Double precipitacion,
			Double temperaturaMaxima, Double temperaturaMedia, Double temperaturaMinima, Long estPluvioId_EstPluvio)
			throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaPrecipitacion(FacesUtils.checkDate(fechaPrecipitacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPrecipitacion(FacesUtils.checkDouble(precipitacion));
			entity.setTemperaturaMaxima(FacesUtils.checkDouble(temperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkDouble(temperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkDouble(temperaturaMinima));
			businessDelegatorView.updateDatPluvio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatPluvioView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
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

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtPrecipitacion() {
		return txtPrecipitacion;
	}

	public void setTxtPrecipitacion(InputText txtPrecipitacion) {
		this.txtPrecipitacion = txtPrecipitacion;
	}

	public InputText getTxtTemperaturaMaxima() {
		return txtTemperaturaMaxima;
	}

	public void setTxtTemperaturaMaxima(InputText txtTemperaturaMaxima) {
		this.txtTemperaturaMaxima = txtTemperaturaMaxima;
	}

	public InputText getTxtTemperaturaMedia() {
		return txtTemperaturaMedia;
	}

	public void setTxtTemperaturaMedia(InputText txtTemperaturaMedia) {
		this.txtTemperaturaMedia = txtTemperaturaMedia;
	}

	public InputText getTxtTemperaturaMinima() {
		return txtTemperaturaMinima;
	}

	public void setTxtTemperaturaMinima(InputText txtTemperaturaMinima) {
		this.txtTemperaturaMinima = txtTemperaturaMinima;
	}

	public SelectOneMenu getTxtEstPluvioId_EstPluvio() {
		return txtEstPluvioId_EstPluvio;
	}

	public void setTxtEstPluvioId_EstPluvio(SelectOneMenu txtEstPluvioId_EstPluvio) {
		this.txtEstPluvioId_EstPluvio = txtEstPluvioId_EstPluvio;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
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

	public Calendar getTxtFechaPrecipitacion() {
		return txtFechaPrecipitacion;
	}

	public void setTxtFechaPrecipitacion(Calendar txtFechaPrecipitacion) {
		this.txtFechaPrecipitacion = txtFechaPrecipitacion;
	}

	public InputText getTxtDatPluvioId() {
		return txtDatPluvioId;
	}

	public void setTxtDatPluvioId(InputText txtDatPluvioId) {
		this.txtDatPluvioId = txtDatPluvioId;
	}

	public LazyDataModel<DatPluvioDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatPluvioDTO> datPluvioDTO) {
		this.data = datPluvioDTO;
	}

	public DatPluvioDTO getSelectedDatPluvio() {
		return selectedDatPluvio;
	}

	public void setSelectedDatPluvio(DatPluvioDTO datPluvio) {
		this.selectedDatPluvio = datPluvio;
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

	public SelectItem[] getSelectEstPluvio() {

		if (estPluvio == null || estPluvio.size() == 0) {

			estPluvio = new ArrayList<EstPluvio>();

			try {

				estPluvio = businessDelegatorView.getEstPluvio(); // Fin by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstPluvio> lista = businessDelegatorView.findByCriteriaInEstPluvio(condicion, null, null);
				selectEstPluvio = new SelectItem[lista.size()];

				int i = 0;
				for (EstPluvio pluvio : lista) {
					selectEstPluvio[i] = new SelectItem(pluvio.getEstPluvioId(), pluvio.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEstPluvio;
	}

	public void setSelectEstPluvio(SelectItem[] selectEstPluvio) {
		this.selectEstPluvio = selectEstPluvio;
	}

	public void listener_calculartempMedia() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double tempMinima = FacesUtils.checkDouble(getTxtTemperaturaMinima());
		Double tempMaxima = FacesUtils.checkDouble(getTxtTemperaturaMaxima());

		if (tempMinima != null && tempMaxima != null) {
			result = (tempMinima + tempMaxima) / 2;
			String format = decimalFormat.format(result);
			txtTemperaturaMedia.setValue(format);
		} else {
			result = 0;
			txtTemperaturaMedia.setValue(result);
		}

	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {

				Long datPluvioId = new Long(selectedDatPluvio.getDatPluvioId());
				entity = businessDelegatorView.getDatPluvio(datPluvioId);

			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatPluvio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		action_clear();
		selectedDatPluvio = (DatPluvioDTO) (evt.getComponent().getAttributes().get("selectedDatPluvio"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	private class LocalDataModelDTO extends LazyDataModel<DatPluvioDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatPluvioDTO> datPluvioDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatPluvioDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datPluvioDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberDatPluvio(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datPluvioDTO;

		}

		@Override
		public DatPluvioDTO getRowData(String rowKey) {
			for (DatPluvioDTO datPluvioDTOtmp : datPluvioDTO) {
				if (datPluvioDTOtmp.getDatPluvioId().toString().equals(rowKey))
					return datPluvioDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatPluvioDTO datPluvioDTOtmp) {
			return datPluvioDTOtmp.getDatPluvioId();
		}

	}

	private List<DatPluvioDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageDatPluvio(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	
}
