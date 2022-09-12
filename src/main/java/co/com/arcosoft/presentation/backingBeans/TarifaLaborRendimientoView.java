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
import co.com.arcosoft.modelo.TarifaLaborRendimiento;
import co.com.arcosoft.modelo.dto.TarifaLaborRendimientoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TarifaLaborRendimientoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaLaborRendimientoView.class);
	private InputText txtBonificacion;
	private InputText txtCompania;
	private InputText txtContratistaId;
	private InputText txtNivel2Id;
	private InputText txtRendimiento;
	private InputText txtTarifa;
	private InputText txtUdadMedId;
	private InputText txtLaborId_Labor;
	private InputText txtTarifaLaborId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TarifaLaborRendimientoDTO> data;
	private TarifaLaborRendimientoDTO selectedTarifaLaborRendimiento;
	private TarifaLaborRendimiento entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TarifaLaborRendimientoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TarifaLaborRendimientoDTO tarifaLaborRendimientoDTO = (TarifaLaborRendimientoDTO) e.getObject();

			if (txtBonificacion == null) {
				txtBonificacion = new InputText();
			}

			txtBonificacion.setValue(tarifaLaborRendimientoDTO.getBonificacion());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tarifaLaborRendimientoDTO.getCompania());

			if (txtContratistaId == null) {
				txtContratistaId = new InputText();
			}

			txtContratistaId.setValue(tarifaLaborRendimientoDTO.getContratistaId());

			if (txtNivel2Id == null) {
				txtNivel2Id = new InputText();
			}

			txtNivel2Id.setValue(tarifaLaborRendimientoDTO.getNivel2Id());

			if (txtRendimiento == null) {
				txtRendimiento = new InputText();
			}

			txtRendimiento.setValue(tarifaLaborRendimientoDTO.getRendimiento());

			if (txtTarifa == null) {
				txtTarifa = new InputText();
			}

			txtTarifa.setValue(tarifaLaborRendimientoDTO.getTarifa());

			if (txtUdadMedId == null) {
				txtUdadMedId = new InputText();
			}

			txtUdadMedId.setValue(tarifaLaborRendimientoDTO.getUdadMedId());

			if (txtLaborId_Labor == null) {
				txtLaborId_Labor = new InputText();
			}

			txtLaborId_Labor.setValue(tarifaLaborRendimientoDTO.getLaborId_Labor());

			if (txtTarifaLaborId == null) {
				txtTarifaLaborId = new InputText();
			}

			txtTarifaLaborId.setValue(tarifaLaborRendimientoDTO.getTarifaLaborId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tarifaLaborRendimientoDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(tarifaLaborRendimientoDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(tarifaLaborRendimientoDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tarifaLaborRendimientoDTO.getFechaModificacion());

			Long tarifaLaborId = FacesUtils.checkLong(txtTarifaLaborId);
			entity = businessDelegatorView.getTarifaLaborRendimiento(tarifaLaborId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTarifaLaborRendimiento = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTarifaLaborRendimiento = null;

		if (txtBonificacion != null) {
			txtBonificacion.setValue(null);
			txtBonificacion.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtContratistaId != null) {
			txtContratistaId.setValue(null);
			txtContratistaId.setDisabled(true);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(true);
		}

		if (txtRendimiento != null) {
			txtRendimiento.setValue(null);
			txtRendimiento.setDisabled(true);
		}

		if (txtTarifa != null) {
			txtTarifa.setValue(null);
			txtTarifa.setDisabled(true);
		}

		if (txtUdadMedId != null) {
			txtUdadMedId.setValue(null);
			txtUdadMedId.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
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

		if (txtTarifaLaborId != null) {
			txtTarifaLaborId.setValue(null);
			txtTarifaLaborId.setDisabled(false);
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
			Long tarifaLaborId = FacesUtils.checkLong(txtTarifaLaborId);
			entity = (tarifaLaborId != null) ? businessDelegatorView.getTarifaLaborRendimiento(tarifaLaborId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtBonificacion.setDisabled(false);
			txtCompania.setDisabled(false);
			txtContratistaId.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtRendimiento.setDisabled(false);
			txtTarifa.setDisabled(false);
			txtUdadMedId.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtTarifaLaborId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtBonificacion.setValue(entity.getBonificacion());
			txtBonificacion.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtContratistaId.setValue(entity.getContratistaId());
			txtContratistaId.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id());
			txtNivel2Id.setDisabled(false);
			txtRendimiento.setValue(entity.getRendimiento());
			txtRendimiento.setDisabled(false);
			txtTarifa.setValue(entity.getTarifa());
			txtTarifa.setDisabled(false);
			txtUdadMedId.setValue(entity.getUdadMedId());
			txtUdadMedId.setDisabled(false);
			txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
			txtLaborId_Labor.setDisabled(false);
			txtTarifaLaborId.setValue(entity.getTarifaLaborId());
			txtTarifaLaborId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTarifaLaborRendimiento = (TarifaLaborRendimientoDTO) (evt.getComponent().getAttributes()
				.get("selectedTarifaLaborRendimiento"));
		txtBonificacion.setValue(selectedTarifaLaborRendimiento.getBonificacion());
		txtBonificacion.setDisabled(false);
		txtCompania.setValue(selectedTarifaLaborRendimiento.getCompania());
		txtCompania.setDisabled(false);
		txtContratistaId.setValue(selectedTarifaLaborRendimiento.getContratistaId());
		txtContratistaId.setDisabled(false);
		txtFechaCreacion.setValue(selectedTarifaLaborRendimiento.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedTarifaLaborRendimiento.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedTarifaLaborRendimiento.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedTarifaLaborRendimiento.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNivel2Id.setValue(selectedTarifaLaborRendimiento.getNivel2Id());
		txtNivel2Id.setDisabled(false);
		txtRendimiento.setValue(selectedTarifaLaborRendimiento.getRendimiento());
		txtRendimiento.setDisabled(false);
		txtTarifa.setValue(selectedTarifaLaborRendimiento.getTarifa());
		txtTarifa.setDisabled(false);
		txtUdadMedId.setValue(selectedTarifaLaborRendimiento.getUdadMedId());
		txtUdadMedId.setDisabled(false);
		txtLaborId_Labor.setValue(selectedTarifaLaborRendimiento.getLaborId_Labor());
		txtLaborId_Labor.setDisabled(false);
		txtTarifaLaborId.setValue(selectedTarifaLaborRendimiento.getTarifaLaborId());
		txtTarifaLaborId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTarifaLaborRendimiento == null) && (entity == null)) {
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
			entity = new TarifaLaborRendimiento();

			Long tarifaLaborId = FacesUtils.checkLong(txtTarifaLaborId);

			entity.setBonificacion(FacesUtils.checkDouble(txtBonificacion));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);

			entity.setContratistaId((FacesUtils.checkLong(txtContratistaId) != null)
					? businessDelegatorView.getPersEmpr((FacesUtils.checkLong(txtContratistaId))) : null);
			entity.setUdadMedId((FacesUtils.checkLong(txtUdadMedId) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId)) : null);
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);

			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setRendimiento(FacesUtils.checkDouble(txtRendimiento));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setTarifaLaborId(tarifaLaborId);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);
			businessDelegatorView.saveTarifaLaborRendimiento(entity);
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
				Long tarifaLaborId = new Long(selectedTarifaLaborRendimiento.getTarifaLaborId());
				entity = businessDelegatorView.getTarifaLaborRendimiento(tarifaLaborId);
			}

			entity.setBonificacion(FacesUtils.checkDouble(txtBonificacion));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setRendimiento(FacesUtils.checkDouble(txtRendimiento));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setContratistaId((FacesUtils.checkLong(txtContratistaId) != null)
					? businessDelegatorView.getPersEmpr((FacesUtils.checkLong(txtContratistaId))) : null);
			entity.setUdadMedId((FacesUtils.checkLong(txtUdadMedId) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId)) : null);
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);
			businessDelegatorView.updateTarifaLaborRendimiento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTarifaLaborRendimiento = (TarifaLaborRendimientoDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaLaborRendimiento"));

			Long tarifaLaborId = new Long(selectedTarifaLaborRendimiento.getTarifaLaborId());
			entity = businessDelegatorView.getTarifaLaborRendimiento(tarifaLaborId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long tarifaLaborId = FacesUtils.checkLong(txtTarifaLaborId);
			entity = businessDelegatorView.getTarifaLaborRendimiento(tarifaLaborId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTarifaLaborRendimiento(entity);
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
			selectedTarifaLaborRendimiento = (TarifaLaborRendimientoDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaLaborRendimiento"));

			Long tarifaLaborId = new Long(selectedTarifaLaborRendimiento.getTarifaLaborId());
			entity = businessDelegatorView.getTarifaLaborRendimiento(tarifaLaborId);
			businessDelegatorView.deleteTarifaLaborRendimiento(entity);
			data.remove(selectedTarifaLaborRendimiento);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long bonificacion, Long compania, Long contratistaId, Date fechaCreacion,
			Date fechaFinal, Date fechaInicial, Date fechaModificacion, Long nivel2Id, Double rendimiento,
			Double tarifa, Long tarifaLaborId, Long udadMedId, Long laborId_Labor) throws Exception {
		try {
			entity.setBonificacion(FacesUtils.checkDouble(bonificacion));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setRendimiento(FacesUtils.checkDouble(rendimiento));
			entity.setTarifa(FacesUtils.checkDouble(tarifa));
			businessDelegatorView.updateTarifaLaborRendimiento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TarifaLaborRendimientoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtBonificacion() {
		return txtBonificacion;
	}

	public void setTxtBonificacion(InputText txtBonificacion) {
		this.txtBonificacion = txtBonificacion;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtContratistaId() {
		return txtContratistaId;
	}

	public void setTxtContratistaId(InputText txtContratistaId) {
		this.txtContratistaId = txtContratistaId;
	}

	public InputText getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(InputText txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public InputText getTxtRendimiento() {
		return txtRendimiento;
	}

	public void setTxtRendimiento(InputText txtRendimiento) {
		this.txtRendimiento = txtRendimiento;
	}

	public InputText getTxtTarifa() {
		return txtTarifa;
	}

	public void setTxtTarifa(InputText txtTarifa) {
		this.txtTarifa = txtTarifa;
	}

	public InputText getTxtUdadMedId() {
		return txtUdadMedId;
	}

	public void setTxtUdadMedId(InputText txtUdadMedId) {
		this.txtUdadMedId = txtUdadMedId;
	}

	public InputText getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(InputText txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
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

	public InputText getTxtTarifaLaborId() {
		return txtTarifaLaborId;
	}

	public void setTxtTarifaLaborId(InputText txtTarifaLaborId) {
		this.txtTarifaLaborId = txtTarifaLaborId;
	}

	public List<TarifaLaborRendimientoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTarifaLaborRendimiento();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TarifaLaborRendimientoDTO> tarifaLaborRendimientoDTO) {
		this.data = tarifaLaborRendimientoDTO;
	}

	public TarifaLaborRendimientoDTO getSelectedTarifaLaborRendimiento() {
		return selectedTarifaLaborRendimiento;
	}

	public void setSelectedTarifaLaborRendimiento(TarifaLaborRendimientoDTO tarifaLaborRendimiento) {
		this.selectedTarifaLaborRendimiento = tarifaLaborRendimiento;
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
