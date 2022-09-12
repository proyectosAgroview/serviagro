package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CronogramaLaboresNivel4;
import co.com.arcosoft.modelo.dto.CronogramaLaboresNivel4DTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CronogramaLaboresNivel4View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresNivel4View.class);
	private InputText txtCronogramaLaboresId_CronogramaLabores;
	private InputText txtNivel4Id_Nivel4;
	private InputText txtCronogramaLaboresNivel4Id;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CronogramaLaboresNivel4DTO> data;
	private CronogramaLaboresNivel4DTO selectedCronogramaLaboresNivel4;
	private CronogramaLaboresNivel4 entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CronogramaLaboresNivel4View() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CronogramaLaboresNivel4DTO cronogramaLaboresNivel4DTO = (CronogramaLaboresNivel4DTO) e.getObject();

			if (txtCronogramaLaboresId_CronogramaLabores == null) {
				txtCronogramaLaboresId_CronogramaLabores = new InputText();
			}

			txtCronogramaLaboresId_CronogramaLabores
					.setValue(cronogramaLaboresNivel4DTO.getCronogramaLaboresId_CronogramaLabores());

			if (txtNivel4Id_Nivel4 == null) {
				txtNivel4Id_Nivel4 = new InputText();
			}

			txtNivel4Id_Nivel4.setValue(cronogramaLaboresNivel4DTO.getNivel4Id_Nivel4());

			if (txtCronogramaLaboresNivel4Id == null) {
				txtCronogramaLaboresNivel4Id = new InputText();
			}

			txtCronogramaLaboresNivel4Id.setValue(cronogramaLaboresNivel4DTO.getCronogramaLaboresNivel4Id());

			Long cronogramaLaboresNivel4Id = FacesUtils.checkLong(txtCronogramaLaboresNivel4Id);
			entity = businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCronogramaLaboresNivel4 = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCronogramaLaboresNivel4 = null;

		if (txtCronogramaLaboresId_CronogramaLabores != null) {
			txtCronogramaLaboresId_CronogramaLabores.setValue(null);
			txtCronogramaLaboresId_CronogramaLabores.setDisabled(true);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (txtCronogramaLaboresNivel4Id != null) {
			txtCronogramaLaboresNivel4Id.setValue(null);
			txtCronogramaLaboresNivel4Id.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtId() {
		try {
			Long cronogramaLaboresNivel4Id = FacesUtils.checkLong(txtCronogramaLaboresNivel4Id);
			entity = (cronogramaLaboresNivel4Id != null)
					? businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCronogramaLaboresId_CronogramaLabores.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
			txtCronogramaLaboresNivel4Id.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCronogramaLaboresId_CronogramaLabores.setValue(entity.getCronogramaLabores().getCronogramaLaboresId());
			txtCronogramaLaboresId_CronogramaLabores.setDisabled(false);
			txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
			txtNivel4Id_Nivel4.setDisabled(false);
			txtCronogramaLaboresNivel4Id.setValue(entity.getCronogramaLaboresNivel4Id());
			txtCronogramaLaboresNivel4Id.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCronogramaLaboresNivel4 = (CronogramaLaboresNivel4DTO) (evt.getComponent().getAttributes()
				.get("selectedCronogramaLaboresNivel4"));
		txtCronogramaLaboresId_CronogramaLabores
				.setValue(selectedCronogramaLaboresNivel4.getCronogramaLaboresId_CronogramaLabores());
		txtCronogramaLaboresId_CronogramaLabores.setDisabled(false);
		txtNivel4Id_Nivel4.setValue(selectedCronogramaLaboresNivel4.getNivel4Id_Nivel4());
		txtNivel4Id_Nivel4.setDisabled(false);
		txtCronogramaLaboresNivel4Id.setValue(selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id());
		txtCronogramaLaboresNivel4Id.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCronogramaLaboresNivel4 == null) && (entity == null)) {
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
			entity = new CronogramaLaboresNivel4();

			Long cronogramaLaboresNivel4Id = FacesUtils.checkLong(txtCronogramaLaboresNivel4Id);

			entity.setCronogramaLaboresNivel4Id(cronogramaLaboresNivel4Id);
			entity.setCronogramaLabores(
					(FacesUtils.checkLong(txtCronogramaLaboresId_CronogramaLabores) != null) ? businessDelegatorView
							.getCronogramaLabores(FacesUtils.checkLong(txtCronogramaLaboresId_CronogramaLabores))
							: null);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			businessDelegatorView.saveCronogramaLaboresNivel4(entity);
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
				Long cronogramaLaboresNivel4Id = new Long(
						selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id());
				entity = businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
			}

			entity.setCronogramaLabores(
					(FacesUtils.checkLong(txtCronogramaLaboresId_CronogramaLabores) != null) ? businessDelegatorView
							.getCronogramaLabores(FacesUtils.checkLong(txtCronogramaLaboresId_CronogramaLabores))
							: null);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			businessDelegatorView.updateCronogramaLaboresNivel4(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCronogramaLaboresNivel4 = (CronogramaLaboresNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedCronogramaLaboresNivel4"));

			Long cronogramaLaboresNivel4Id = new Long(selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id());
			entity = businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long cronogramaLaboresNivel4Id = FacesUtils.checkLong(txtCronogramaLaboresNivel4Id);
			entity = businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCronogramaLaboresNivel4(entity);
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
			selectedCronogramaLaboresNivel4 = (CronogramaLaboresNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedCronogramaLaboresNivel4"));

			Long cronogramaLaboresNivel4Id = new Long(selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id());
			entity = businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
			businessDelegatorView.deleteCronogramaLaboresNivel4(entity);
			data.remove(selectedCronogramaLaboresNivel4);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long cronogramaLaboresNivel4Id, Long cronogramaLaboresId_CronogramaLabores,
			Long nivel4Id_Nivel4) throws Exception {
		try {
			businessDelegatorView.updateCronogramaLaboresNivel4(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CronogramaLaboresNivel4View").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCronogramaLaboresId_CronogramaLabores() {
		return txtCronogramaLaboresId_CronogramaLabores;
	}

	public void setTxtCronogramaLaboresId_CronogramaLabores(InputText txtCronogramaLaboresId_CronogramaLabores) {
		this.txtCronogramaLaboresId_CronogramaLabores = txtCronogramaLaboresId_CronogramaLabores;
	}

	public InputText getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(InputText txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public InputText getTxtCronogramaLaboresNivel4Id() {
		return txtCronogramaLaboresNivel4Id;
	}

	public void setTxtCronogramaLaboresNivel4Id(InputText txtCronogramaLaboresNivel4Id) {
		this.txtCronogramaLaboresNivel4Id = txtCronogramaLaboresNivel4Id;
	}

	public List<CronogramaLaboresNivel4DTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCronogramaLaboresNivel4();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CronogramaLaboresNivel4DTO> cronogramaLaboresNivel4DTO) {
		this.data = cronogramaLaboresNivel4DTO;
	}

	public CronogramaLaboresNivel4DTO getSelectedCronogramaLaboresNivel4() {
		return selectedCronogramaLaboresNivel4;
	}

	public void setSelectedCronogramaLaboresNivel4(CronogramaLaboresNivel4DTO cronogramaLaboresNivel4) {
		this.selectedCronogramaLaboresNivel4 = cronogramaLaboresNivel4;
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
