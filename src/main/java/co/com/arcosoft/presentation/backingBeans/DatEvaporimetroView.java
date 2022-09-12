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
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatEvaporimetro;
import co.com.arcosoft.modelo.EstEvaporimetro;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatEvaporimetroDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatEvaporimetroView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatEvaporimetroView.class);
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputText txtEvaporacion;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtTemperaturaMaxima;
	private InputText txtTemperaturaMedia;
	private InputText txtTemperaturaMinima;
	private InputText txtDatEvaporimetroId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaEvaporacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatEvaporimetroDTO> data;
	private DatEvaporimetroDTO selectedDatEvaporimetro;
	private DatEvaporimetro entity;
	private boolean showDialog;

	// Select Estaciones Evaporimetros
	private SelectOneMenu txtEstEvaporimetroId_EstEvaporimetro;
	SelectItem[] evaporimetro;
	private List<EstEvaporimetro> estEvaporimetros;

	private double result;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatEvaporimetroView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatEvaporimetroDTO datEvaporimetroDTO = (DatEvaporimetroDTO) e.getObject();

			txtCompania.setValue(datEvaporimetroDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datEvaporimetroDTO.getEstado());

			if (txtEvaporacion == null) {
				txtEvaporacion = new InputText();
			}

			txtEvaporacion.setValue(datEvaporimetroDTO.getEvaporacion());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(datEvaporimetroDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(datEvaporimetroDTO.getInfoAdicional2());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datEvaporimetroDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			if (txtTemperaturaMaxima == null) {
				txtTemperaturaMaxima = new InputText();
			}

			txtTemperaturaMaxima.setValue(datEvaporimetroDTO.getTemperaturaMaxima());

			if (txtTemperaturaMedia == null) {
				txtTemperaturaMedia = new InputText();
			}

			txtTemperaturaMedia.setValue(datEvaporimetroDTO.getTemperaturaMedia());

			if (txtTemperaturaMinima == null) {
				txtTemperaturaMinima = new InputText();
			}

			txtTemperaturaMinima.setValue(datEvaporimetroDTO.getTemperaturaMinima());

			if (txtEstEvaporimetroId_EstEvaporimetro == null) {
				txtEstEvaporimetroId_EstEvaporimetro = new SelectOneMenu();
			}

			txtEstEvaporimetroId_EstEvaporimetro.setValue(datEvaporimetroDTO.getEstEvaporimetroId_EstEvaporimetro());

			if (txtDatEvaporimetroId == null) {
				txtDatEvaporimetroId = new InputText();
			}

			txtDatEvaporimetroId.setValue(datEvaporimetroDTO.getDatEvaporimetroId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datEvaporimetroDTO.getFechaCreacion());

			if (txtFechaEvaporacion == null) {
				txtFechaEvaporacion = new Calendar();
			}

			txtFechaEvaporacion.setValue(datEvaporimetroDTO.getFechaEvaporacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datEvaporimetroDTO.getFechaModificacion());

			Long datEvaporimetroId = FacesUtils.checkLong(txtDatEvaporimetroId);
			entity = businessDelegatorView.getDatEvaporimetro(datEvaporimetroId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatEvaporimetro = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		estEvaporimetros = null;
		selectedDatEvaporimetro = null;
		PrimeFaces.current().resetInputs(":dialogDatEvaporimetro :frm");
		PrimeFaces.current().resetInputs(":dialogAnularReg :formDialogAnularReg");

		if (txtCompania != null) {
			txtCompania.setValue(null);
			// txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			// txtEstado.setDisabled(true);
		}

		if (txtEvaporacion != null) {
			txtEvaporacion.setValue(null);
			// txtEvaporacion.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			// txtObservacion.setDisabled(true);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			// txtObservacionAnularReg.setDisabled(true);
		}

		if (txtTemperaturaMaxima != null) {
			txtTemperaturaMaxima.setValue(null);
			// txtTemperaturaMaxima.setDisabled(true);
		}

		if (txtTemperaturaMedia != null) {
			txtTemperaturaMedia.setValue(null);
			txtTemperaturaMedia.setDisabled(true);
		}

		if (txtTemperaturaMinima != null) {
			txtTemperaturaMinima.setValue(null);
			// txtTemperaturaMinima.setDisabled(true);
		}

		if (txtEstEvaporimetroId_EstEvaporimetro != null) {
			txtEstEvaporimetroId_EstEvaporimetro.setValue(null);
			// txtEstEvaporimetroId_EstEvaporimetro.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaEvaporacion != null) {
			txtFechaEvaporacion.setValue(null);
			// txtFechaEvaporacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtDatEvaporimetroId != null) {
			txtDatEvaporimetroId.setValue(null);
			// txtDatEvaporimetroId.setDisabled(false);
		}

		if (btnSave != null) {
			// btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			// btnDelete.setDisabled(true);
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

	public void listener_txtFechaEvaporacion() {
		Date inputDate = (Date) txtFechaEvaporacion.getValue();
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
			Long datEvaporimetroId = FacesUtils.checkLong(txtDatEvaporimetroId);
			entity = (datEvaporimetroId != null) ? businessDelegatorView.getDatEvaporimetro(datEvaporimetroId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEvaporacion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setDisabled(false);
			txtEstEvaporimetroId_EstEvaporimetro.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaEvaporacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtDatEvaporimetroId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {

			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEvaporacion.setValue(entity.getEvaporacion());
			txtEvaporacion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaEvaporacion.setValue(entity.getFechaEvaporacion());
			txtFechaEvaporacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtTemperaturaMaxima.setValue(entity.getTemperaturaMaxima());
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setValue(entity.getTemperaturaMedia());
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setValue(entity.getTemperaturaMinima());
			txtTemperaturaMinima.setDisabled(false);
			txtEstEvaporimetroId_EstEvaporimetro.setValue(entity.getEstEvaporimetro().getEstEvaporimetroId());
			txtEstEvaporimetroId_EstEvaporimetro.setDisabled(false);
			txtDatEvaporimetroId.setValue(entity.getDatEvaporimetroId());
			txtDatEvaporimetroId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatEvaporimetro = (DatEvaporimetroDTO) (evt.getComponent().getAttributes()
				.get("selectedDatEvaporimetro"));
		try {
			Long datEvaporimetroId = new Long(selectedDatEvaporimetro.getDatEvaporimetroId());
			entity = businessDelegatorView.getDatEvaporimetro(datEvaporimetroId);

			// txtEstado.setValue(entity.getEstado());
			// txtEstado.setDisabled(false);
			txtEvaporacion.setValue(entity.getEvaporacion());
			txtEvaporacion.setDisabled(false);
			txtFechaEvaporacion.setValue(entity.getFechaEvaporacion());
			txtFechaEvaporacion.setDisabled(false);
			txtTemperaturaMaxima.setValue(entity.getTemperaturaMaxima());
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setValue(entity.getTemperaturaMedia());
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setValue(entity.getTemperaturaMinima());
			txtTemperaturaMinima.setDisabled(false);
			txtEstEvaporimetroId_EstEvaporimetro.setValue(entity.getEstEvaporimetro().getEstEvaporimetroId());
			txtEstEvaporimetroId_EstEvaporimetro.setDisabled(false);
			txtDatEvaporimetroId.setValue(entity.getDatEvaporimetroId());
			txtDatEvaporimetroId.setDisabled(false);

			btnSave.setDisabled(false);
			setShowDialog(true);

		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatEvaporimetro == null) && (entity == null)) {
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
			entity = new DatEvaporimetro();
			Date date = new Date();
			// Long datEvaporimetroId =
			// FacesUtils.checkLong(txtDatEvaporimetroId);

			// entity.setCodigo(FacesUtils.checkString(txtCodigo));
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setDatEvaporimetroId(datEvaporimetroId);
			String estado = "A";
			entity.setEstado(estado);
			entity.setEvaporacion(FacesUtils.checkLong(txtEvaporacion));
			entity.setFechaCreacion(date);
			entity.setFechaEvaporacion(FacesUtils.checkDate(txtFechaEvaporacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setTemperaturaMaxima(FacesUtils.checkLong(txtTemperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkLong(txtTemperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkLong(txtTemperaturaMinima));
			entity.setEstEvaporimetro(
					(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro) != null) ? businessDelegatorView
							.getEstEvaporimetro(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro)) : null);
			businessDelegatorView.saveDatEvaporimetro(entity);
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
				Long datEvaporimetroId = new Long(selectedDatEvaporimetro.getDatEvaporimetroId());
				entity = businessDelegatorView.getDatEvaporimetro(datEvaporimetroId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEvaporacion(FacesUtils.checkLong(txtEvaporacion));
			entity.setFechaCreacion(entity.getFechaCreacion());
			entity.setFechaEvaporacion(FacesUtils.checkDate(txtFechaEvaporacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setTemperaturaMaxima(FacesUtils.checkLong(txtTemperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkLong(txtTemperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkLong(txtTemperaturaMinima));
			entity.setEstEvaporimetro(
					(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro) != null) ? businessDelegatorView
							.getEstEvaporimetro(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro)) : null);
			businessDelegatorView.updateDatEvaporimetro(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatEvaporimetro = (DatEvaporimetroDTO) (evt.getComponent().getAttributes()
					.get("selectedDatEvaporimetro"));

			Long datEvaporimetroId = new Long(selectedDatEvaporimetro.getDatEvaporimetroId());
			entity = businessDelegatorView.getDatEvaporimetro(datEvaporimetroId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datEvaporimetroId = FacesUtils.checkLong(txtDatEvaporimetroId);
			entity = businessDelegatorView.getDatEvaporimetro(datEvaporimetroId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatEvaporimetro(entity);
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
			selectedDatEvaporimetro = (DatEvaporimetroDTO) (evt.getComponent().getAttributes()
					.get("selectedDatEvaporimetro"));

			Long datEvaporimetroId = new Long(selectedDatEvaporimetro.getDatEvaporimetroId());
			entity = businessDelegatorView.getDatEvaporimetro(datEvaporimetroId);
			businessDelegatorView.deleteDatEvaporimetro(entity);
			((Map<String, Object>) data).remove(selectedDatEvaporimetro);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long datEvaporimetroId, String estado, Long evaporacion,
			Date fechaAnulacion, Date fechaCreacion, Date fechaEvaporacion, Date fechaModificacion,
			String infoAdicional, String infoAdicional2, String observacion, String observacionAnularReg,
			Long temperaturaMaxima, Long temperaturaMedia, Long temperaturaMinima,
			Long estEvaporimetroId_EstEvaporimetro) throws Exception {
		try {

			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEvaporacion(FacesUtils.checkLong(evaporacion));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaEvaporacion(FacesUtils.checkDate(fechaEvaporacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setTemperaturaMaxima(FacesUtils.checkLong(temperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkLong(temperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkLong(temperaturaMinima));
			businessDelegatorView.updateDatEvaporimetro(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatEvaporimetroView").requestRender();
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

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEvaporacion() {
		return txtEvaporacion;
	}

	public void setTxtEvaporacion(InputText txtEvaporacion) {
		this.txtEvaporacion = txtEvaporacion;
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

	public SelectOneMenu getTxtEstEvaporimetroId_EstEvaporimetro() {
		return txtEstEvaporimetroId_EstEvaporimetro;
	}

	public void setTxtEstEvaporimetroId_EstEvaporimetro(SelectOneMenu txtEstEvaporimetroId_EstEvaporimetro) {
		this.txtEstEvaporimetroId_EstEvaporimetro = txtEstEvaporimetroId_EstEvaporimetro;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaEvaporacion() {
		return txtFechaEvaporacion;
	}

	public void setTxtFechaEvaporacion(Calendar txtFechaEvaporacion) {
		this.txtFechaEvaporacion = txtFechaEvaporacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtDatEvaporimetroId() {
		return txtDatEvaporimetroId;
	}

	public void setTxtDatEvaporimetroId(InputText txtDatEvaporimetroId) {
		this.txtDatEvaporimetroId = txtDatEvaporimetroId;
	}

	public LazyDataModel<DatEvaporimetroDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatEvaporimetroDTO> datEvaporimetroDTO) {
		this.data = datEvaporimetroDTO;
	}

	public DatEvaporimetroDTO getSelectedDatEvaporimetro() {
		return selectedDatEvaporimetro;
	}

	public void setSelectedDatEvaporimetro(DatEvaporimetroDTO datEvaporimetro) {
		this.selectedDatEvaporimetro = datEvaporimetro;
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

	public SelectItem[] getEvaporimetro() {

		if (estEvaporimetros == null || estEvaporimetros.size() == 0) {

			estEvaporimetros = new ArrayList<EstEvaporimetro>();

			try {

				estEvaporimetros = businessDelegatorView.getEstEvaporimetro(); // Fin
																				// by
																				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstEvaporimetro> lista = businessDelegatorView.findByCriteriaInEstEvaporimetro(condicion, null,
						null);
				evaporimetro = new SelectItem[lista.size()];

				int i = 0;
				for (EstEvaporimetro eva : lista) {
					evaporimetro[i] = new SelectItem(eva.getEstEvaporimetroId(), eva.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return evaporimetro;
	}

	public void setEvaporimetro(SelectItem[] evaporimetro) {
		this.evaporimetro = evaporimetro;
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

				Long datEvaporimtroId = new Long(selectedDatEvaporimetro.getDatEvaporimetroId());
				entity = businessDelegatorView.getDatEvaporimetro(datEvaporimtroId);

			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatEvaporimetro(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		// selectedDatEvaporimetro = null;
		return "";

	}

	public String action_anularReg(ActionEvent evt) {

		action_clear();
		selectedDatEvaporimetro = (DatEvaporimetroDTO) (evt.getComponent().getAttributes()
				.get("selectedDatEvaporimetro"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

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

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
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

	private class LocalDataModelDTO extends LazyDataModel<DatEvaporimetroDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatEvaporimetroDTO> datEvaporimetroDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatEvaporimetroDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datEvaporimetroDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberDatEvaporimetro(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datEvaporimetroDTO;

		}

		@Override
		public DatEvaporimetroDTO getRowData(String rowKey) {
			for (DatEvaporimetroDTO datEvaporimetroDTOtmp : datEvaporimetroDTO) {
				if (datEvaporimetroDTOtmp.getDatEvaporimetroId().toString().equals(rowKey))
					return datEvaporimetroDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatEvaporimetroDTO datEvaporimetroDTOtmp) {
			return datEvaporimetroDTOtmp.getDatEvaporimetroId();
		}

	}

	private List<DatEvaporimetroDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageDatEvaporimetro(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
