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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaEquipProp;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TarifaEquipPropView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaEquipPropView.class);
	private InputText txtCompania;
	private InputText txtTarifa;
	private InputText txtEquipoId_Equipo;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtTarifaEquipPropId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TarifaEquipPropDTO> data;
	private TarifaEquipPropDTO selectedTarifaEquipProp;
	private TarifaEquipProp entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TarifaEquipPropView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TarifaEquipPropDTO tarifaEquipPropDTO = (TarifaEquipPropDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tarifaEquipPropDTO.getCompania());

			if (txtTarifa == null) {
				txtTarifa = new InputText();
			}

			txtTarifa.setValue(tarifaEquipPropDTO.getTarifa());

			if (txtEquipoId_Equipo == null) {
				txtEquipoId_Equipo = new InputText();
			}

			txtEquipoId_Equipo.setValue(tarifaEquipPropDTO.getEquipoId_Equipo());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(tarifaEquipPropDTO.getUdadMedId_UdadMed());

			if (txtTarifaEquipPropId == null) {
				txtTarifaEquipPropId = new InputText();
			}

			txtTarifaEquipPropId.setValue(tarifaEquipPropDTO.getTarifaEquipPropId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tarifaEquipPropDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(tarifaEquipPropDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(tarifaEquipPropDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tarifaEquipPropDTO.getFechaModificacion());

			Long tarifaEquipPropId = FacesUtils.checkLong(txtTarifaEquipPropId);
			entity = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTarifaEquipProp = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTarifaEquipProp = null;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtTarifa != null) {
			txtTarifa.setValue(null);
			txtTarifa.setDisabled(true);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtTarifaEquipPropId != null) {
			txtTarifaEquipPropId.setValue(null);
			txtTarifaEquipPropId.setDisabled(false);
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

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
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
			Long tarifaEquipPropId = FacesUtils.checkLong(txtTarifaEquipPropId);
			entity = (tarifaEquipPropId != null) ? businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtTarifa.setDisabled(false);
			txtEquipoId_Equipo.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtTarifaEquipPropId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtTarifa.setValue(entity.getTarifa());
			txtTarifa.setDisabled(false);
			txtEquipoId_Equipo.setValue(entity.getEquipo());
			txtEquipoId_Equipo.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtTarifaEquipPropId.setValue(entity.getTarifaEquipPropId());
			txtTarifaEquipPropId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTarifaEquipProp = (TarifaEquipPropDTO) (evt.getComponent().getAttributes()
				.get("selectedTarifaEquipProp"));
		txtCompania.setValue(selectedTarifaEquipProp.getCompania());
		txtCompania.setDisabled(false);
		txtFechaCreacion.setValue(selectedTarifaEquipProp.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedTarifaEquipProp.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedTarifaEquipProp.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedTarifaEquipProp.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtTarifa.setValue(selectedTarifaEquipProp.getTarifa());
		txtTarifa.setDisabled(false);
		txtEquipoId_Equipo.setValue(selectedTarifaEquipProp.getEquipoId_Equipo());
		txtEquipoId_Equipo.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedTarifaEquipProp.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtTarifaEquipPropId.setValue(selectedTarifaEquipProp.getTarifaEquipPropId());
		txtTarifaEquipPropId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTarifaEquipProp == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new TarifaEquipProp();

			Long tarifaEquipPropId = FacesUtils.checkLong(txtTarifaEquipPropId);

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setTarifaEquipPropId(tarifaEquipPropId);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.saveTarifaEquipProp(entity);
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
				Long tarifaEquipPropId = new Long(selectedTarifaEquipProp.getTarifaEquipPropId());
				entity = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.updateTarifaEquipProp(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTarifaEquipProp = (TarifaEquipPropDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaEquipProp"));

			Long tarifaEquipPropId = new Long(selectedTarifaEquipProp.getTarifaEquipPropId());
			entity = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long tarifaEquipPropId = FacesUtils.checkLong(txtTarifaEquipPropId);
			entity = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTarifaEquipProp(entity);
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
			selectedTarifaEquipProp = (TarifaEquipPropDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaEquipProp"));

			Long tarifaEquipPropId = new Long(selectedTarifaEquipProp.getTarifaEquipPropId());
			entity = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);
			businessDelegatorView.deleteTarifaEquipProp(entity);
			data.remove(selectedTarifaEquipProp);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Double tarifa, Long tarifaEquipPropId, Long equipoId_Equipo, Long udadMedId_UdadMed)
			throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(tarifa));
			businessDelegatorView.updateTarifaEquipProp(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TarifaEquipPropView").requestRender();
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

	public InputText getTxtTarifa() {
		return txtTarifa;
	}

	public void setTxtTarifa(InputText txtTarifa) {
		this.txtTarifa = txtTarifa;
	}

	public InputText getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(InputText txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public InputText getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(InputText txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtTarifaEquipPropId() {
		return txtTarifaEquipPropId;
	}

	public void setTxtTarifaEquipPropId(InputText txtTarifaEquipPropId) {
		this.txtTarifaEquipPropId = txtTarifaEquipPropId;
	}

	public List<TarifaEquipPropDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTarifaEquipProp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TarifaEquipPropDTO> tarifaEquipPropDTO) {
		this.data = tarifaEquipPropDTO;
	}

	public TarifaEquipPropDTO getSelectedTarifaEquipProp() {
		return selectedTarifaEquipProp;
	}

	public void setSelectedTarifaEquipProp(TarifaEquipPropDTO tarifaEquipProp) {
		this.selectedTarifaEquipProp = tarifaEquipProp;
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
