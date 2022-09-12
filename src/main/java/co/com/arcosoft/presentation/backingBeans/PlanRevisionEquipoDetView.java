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
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PlanRevisionEquipoDetView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoDetView.class);
	private InputText txtEquipo;
	private InputText txtPeriocidadDias;
	private InputText txtPeriocidadHora;
	private InputText txtPeriocidadKm;
	private InputText txtPlanRevisionEquipoId_PlanRevisionEquipo;
	private InputText txtPlanRevisionEquipoDetId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PlanRevisionEquipoDetDTO> data;
	private PlanRevisionEquipoDetDTO selectedPlanRevisionEquipoDet;
	private PlanRevisionEquipoDet entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public PlanRevisionEquipoDetView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PlanRevisionEquipoDetDTO planRevisionEquipoDetDTO = (PlanRevisionEquipoDetDTO) e.getObject();

			if (txtEquipo == null) {
				txtEquipo = new InputText();
			}

			txtEquipo.setValue(planRevisionEquipoDetDTO.getEquipo());

			if (txtPeriocidadDias == null) {
				txtPeriocidadDias = new InputText();
			}

			txtPeriocidadDias.setValue(planRevisionEquipoDetDTO.getPeriocidadDias());

			if (txtPeriocidadHora == null) {
				txtPeriocidadHora = new InputText();
			}

			txtPeriocidadHora.setValue(planRevisionEquipoDetDTO.getPeriocidadHora());

			if (txtPeriocidadKm == null) {
				txtPeriocidadKm = new InputText();
			}

			txtPeriocidadKm.setValue(planRevisionEquipoDetDTO.getPeriocidadKm());

			if (txtPlanRevisionEquipoId_PlanRevisionEquipo == null) {
				txtPlanRevisionEquipoId_PlanRevisionEquipo = new InputText();
			}

			txtPlanRevisionEquipoId_PlanRevisionEquipo
					.setValue(planRevisionEquipoDetDTO.getPlanRevisionEquipoId_PlanRevisionEquipo());

			if (txtPlanRevisionEquipoDetId == null) {
				txtPlanRevisionEquipoDetId = new InputText();
			}

			txtPlanRevisionEquipoDetId.setValue(planRevisionEquipoDetDTO.getPlanRevisionEquipoDetId());

			Long planRevisionEquipoDetId = FacesUtils.checkLong(txtPlanRevisionEquipoDetId);
			entity = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPlanRevisionEquipoDet = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPlanRevisionEquipoDet = null;

		if (txtEquipo != null) {
			txtEquipo.setValue(null);
			txtEquipo.setDisabled(true);
		}

		if (txtPeriocidadDias != null) {
			txtPeriocidadDias.setValue(null);
			txtPeriocidadDias.setDisabled(true);
		}

		if (txtPeriocidadHora != null) {
			txtPeriocidadHora.setValue(null);
			txtPeriocidadHora.setDisabled(true);
		}

		if (txtPeriocidadKm != null) {
			txtPeriocidadKm.setValue(null);
			txtPeriocidadKm.setDisabled(true);
		}

		if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null) {
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(null);
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(true);
		}

		if (txtPlanRevisionEquipoDetId != null) {
			txtPlanRevisionEquipoDetId.setValue(null);
			txtPlanRevisionEquipoDetId.setDisabled(false);
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
			Long planRevisionEquipoDetId = FacesUtils.checkLong(txtPlanRevisionEquipoDetId);
			entity = (planRevisionEquipoDetId != null)
					? businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtEquipo.setDisabled(false);
			txtPeriocidadDias.setDisabled(false);
			txtPeriocidadHora.setDisabled(false);
			txtPeriocidadKm.setDisabled(false);
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
			txtPlanRevisionEquipoDetId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEquipo.setValue(entity.getEquipo());
			txtEquipo.setDisabled(false);
			txtPeriocidadDias.setValue(entity.getPeriocidadDias());
			txtPeriocidadDias.setDisabled(false);
			txtPeriocidadHora.setValue(entity.getPeriocidadHora());
			txtPeriocidadHora.setDisabled(false);
			txtPeriocidadKm.setValue(entity.getPeriocidadKm());
			txtPeriocidadKm.setDisabled(false);
			txtPlanRevisionEquipoId_PlanRevisionEquipo
					.setValue(entity.getPlanRevisionEquipo().getPlanRevisionEquipoId());
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
			txtPlanRevisionEquipoDetId.setValue(entity.getPlanRevisionEquipoDetId());
			txtPlanRevisionEquipoDetId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPlanRevisionEquipoDet = (PlanRevisionEquipoDetDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionEquipoDet"));
		txtEquipo.setValue(selectedPlanRevisionEquipoDet.getEquipo());
		txtEquipo.setDisabled(false);
		txtPeriocidadDias.setValue(selectedPlanRevisionEquipoDet.getPeriocidadDias());
		txtPeriocidadDias.setDisabled(false);
		txtPeriocidadHora.setValue(selectedPlanRevisionEquipoDet.getPeriocidadHora());
		txtPeriocidadHora.setDisabled(false);
		txtPeriocidadKm.setValue(selectedPlanRevisionEquipoDet.getPeriocidadKm());
		txtPeriocidadKm.setDisabled(false);
		txtPlanRevisionEquipoId_PlanRevisionEquipo
				.setValue(selectedPlanRevisionEquipoDet.getPlanRevisionEquipoId_PlanRevisionEquipo());
		txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
		txtPlanRevisionEquipoDetId.setValue(selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId());
		txtPlanRevisionEquipoDetId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPlanRevisionEquipoDet == null) && (entity == null)) {
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
			entity = new PlanRevisionEquipoDet();

			Long planRevisionEquipoDetId = FacesUtils.checkLong(txtPlanRevisionEquipoDetId);

			// entity.setEquipo(FacesUtils.checkLong(txtEquipo));
			entity.setPeriocidadDias(FacesUtils.checkDouble(txtPeriocidadDias));
			entity.setPeriocidadHora(FacesUtils.checkDouble(txtPeriocidadHora));
			entity.setPeriocidadKm(FacesUtils.checkDouble(txtPeriocidadKm));
			entity.setPlanRevisionEquipoDetId(planRevisionEquipoDetId);
			entity.setPlanRevisionEquipo(
					(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo) != null) ? businessDelegatorView
							.getPlanRevisionEquipo(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo))
							: null);
			businessDelegatorView.savePlanRevisionEquipoDet(entity);
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
				Long planRevisionEquipoDetId = new Long(selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId());
				entity = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);
			}

			// entity.setEquipo(FacesUtils.checkLong(txtEquipo));
			entity.setPeriocidadDias(FacesUtils.checkDouble(txtPeriocidadDias));
			entity.setPeriocidadHora(FacesUtils.checkDouble(txtPeriocidadHora));
			entity.setPeriocidadKm(FacesUtils.checkDouble(txtPeriocidadKm));
			entity.setPlanRevisionEquipo(
					(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo) != null) ? businessDelegatorView
							.getPlanRevisionEquipo(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo))
							: null);
			businessDelegatorView.updatePlanRevisionEquipoDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedPlanRevisionEquipoDet = (PlanRevisionEquipoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipoDet"));

			Long planRevisionEquipoDetId = new Long(selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId());
			entity = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long planRevisionEquipoDetId = FacesUtils.checkLong(txtPlanRevisionEquipoDetId);
			entity = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deletePlanRevisionEquipoDet(entity);
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
			selectedPlanRevisionEquipoDet = (PlanRevisionEquipoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipoDet"));

			Long planRevisionEquipoDetId = new Long(selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId());
			entity = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);
			businessDelegatorView.deletePlanRevisionEquipoDet(entity);
			data.remove(selectedPlanRevisionEquipoDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long equipo, Double periocidadDias, Double periocidadHora, Double periocidadKm,
			Long planRevisionEquipoDetId, Long planRevisionEquipoId_PlanRevisionEquipo) throws Exception {
		try {
			// entity.setEquipo(FacesUtils.checkLong(equipo));
			entity.setPeriocidadDias(FacesUtils.checkDouble(periocidadDias));
			entity.setPeriocidadHora(FacesUtils.checkDouble(periocidadHora));
			entity.setPeriocidadKm(FacesUtils.checkDouble(periocidadKm));
			businessDelegatorView.updatePlanRevisionEquipoDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PlanRevisionEquipoDetView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtEquipo() {
		return txtEquipo;
	}

	public void setTxtEquipo(InputText txtEquipo) {
		this.txtEquipo = txtEquipo;
	}

	public InputText getTxtPeriocidadDias() {
		return txtPeriocidadDias;
	}

	public void setTxtPeriocidadDias(InputText txtPeriocidadDias) {
		this.txtPeriocidadDias = txtPeriocidadDias;
	}

	public InputText getTxtPeriocidadHora() {
		return txtPeriocidadHora;
	}

	public void setTxtPeriocidadHora(InputText txtPeriocidadHora) {
		this.txtPeriocidadHora = txtPeriocidadHora;
	}

	public InputText getTxtPeriocidadKm() {
		return txtPeriocidadKm;
	}

	public void setTxtPeriocidadKm(InputText txtPeriocidadKm) {
		this.txtPeriocidadKm = txtPeriocidadKm;
	}

	public InputText getTxtPlanRevisionEquipoId_PlanRevisionEquipo() {
		return txtPlanRevisionEquipoId_PlanRevisionEquipo;
	}

	public void setTxtPlanRevisionEquipoId_PlanRevisionEquipo(InputText txtPlanRevisionEquipoId_PlanRevisionEquipo) {
		this.txtPlanRevisionEquipoId_PlanRevisionEquipo = txtPlanRevisionEquipoId_PlanRevisionEquipo;
	}

	public InputText getTxtPlanRevisionEquipoDetId() {
		return txtPlanRevisionEquipoDetId;
	}

	public void setTxtPlanRevisionEquipoDetId(InputText txtPlanRevisionEquipoDetId) {
		this.txtPlanRevisionEquipoDetId = txtPlanRevisionEquipoDetId;
	}

	public List<PlanRevisionEquipoDetDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPlanRevisionEquipoDet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PlanRevisionEquipoDetDTO> planRevisionEquipoDetDTO) {
		this.data = planRevisionEquipoDetDTO;
	}

	public PlanRevisionEquipoDetDTO getSelectedPlanRevisionEquipoDet() {
		return selectedPlanRevisionEquipoDet;
	}

	public void setSelectedPlanRevisionEquipoDet(PlanRevisionEquipoDetDTO planRevisionEquipoDet) {
		this.selectedPlanRevisionEquipoDet = planRevisionEquipoDet;
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
