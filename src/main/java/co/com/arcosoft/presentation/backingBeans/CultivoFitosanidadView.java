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
import co.com.arcosoft.modelo.CultivoFitosanidad;
import co.com.arcosoft.modelo.CultivoFitosanidadId;
import co.com.arcosoft.modelo.dto.CultivoFitosanidadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CultivoFitosanidadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CultivoFitosanidadView.class);
	private InputText txtCultivoId_Cultivo;
	private InputText txtFitosanidadId_Fitosanidad;
	private InputText txtCultivoId;
	private InputText txtFitosanidadId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CultivoFitosanidadDTO> data;
	private CultivoFitosanidadDTO selectedCultivoFitosanidad;
	private CultivoFitosanidad entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CultivoFitosanidadView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CultivoFitosanidadDTO cultivoFitosanidadDTO = (CultivoFitosanidadDTO) e.getObject();

			if (txtCultivoId_Cultivo == null) {
				txtCultivoId_Cultivo = new InputText();
			}

			txtCultivoId_Cultivo.setValue(cultivoFitosanidadDTO.getCultivoId_Cultivo());

			if (txtFitosanidadId_Fitosanidad == null) {
				txtFitosanidadId_Fitosanidad = new InputText();
			}

			txtFitosanidadId_Fitosanidad.setValue(cultivoFitosanidadDTO.getFitosanidadId_Fitosanidad());

			if (txtCultivoId == null) {
				txtCultivoId = new InputText();
			}

			txtCultivoId.setValue(cultivoFitosanidadDTO.getCultivoId());

			if (txtFitosanidadId == null) {
				txtFitosanidadId = new InputText();
			}

			txtFitosanidadId.setValue(cultivoFitosanidadDTO.getFitosanidadId());

			CultivoFitosanidadId id = new CultivoFitosanidadId();
			id.setCultivoId((((txtCultivoId.getValue()) == null) || (txtCultivoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCultivoId));
			id.setFitosanidadId((((txtFitosanidadId.getValue()) == null) || (txtFitosanidadId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtFitosanidadId));
			entity = businessDelegatorView.getCultivoFitosanidad(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCultivoFitosanidad = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCultivoFitosanidad = null;

		if (txtCultivoId_Cultivo != null) {
			txtCultivoId_Cultivo.setValue(null);
			txtCultivoId_Cultivo.setDisabled(true);
		}

		if (txtFitosanidadId_Fitosanidad != null) {
			txtFitosanidadId_Fitosanidad.setValue(null);
			txtFitosanidadId_Fitosanidad.setDisabled(true);
		}

		if (txtCultivoId != null) {
			txtCultivoId.setValue(null);
			txtCultivoId.setDisabled(false);
		}

		if (txtFitosanidadId != null) {
			txtFitosanidadId.setValue(null);
			txtFitosanidadId.setDisabled(false);
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
			CultivoFitosanidadId id = new CultivoFitosanidadId();
			id.setCultivoId((((txtCultivoId.getValue()) == null) || (txtCultivoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCultivoId));
			id.setFitosanidadId((((txtFitosanidadId.getValue()) == null) || (txtFitosanidadId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtFitosanidadId));
			entity = (id != null) ? businessDelegatorView.getCultivoFitosanidad(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCultivoId_Cultivo.setDisabled(false);
			txtFitosanidadId_Fitosanidad.setDisabled(false);
			txtCultivoId.setDisabled(false);
			txtFitosanidadId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			txtFitosanidadId_Fitosanidad.setValue(entity.getFitosanidad().getFitosanidadId());
			txtFitosanidadId_Fitosanidad.setDisabled(false);
			txtCultivoId.setValue(entity.getId().getCultivoId());
			txtCultivoId.setDisabled(true);
			txtFitosanidadId.setValue(entity.getId().getFitosanidadId());
			txtFitosanidadId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCultivoFitosanidad = (CultivoFitosanidadDTO) (evt.getComponent().getAttributes()
				.get("selectedCultivoFitosanidad"));
		txtCultivoId_Cultivo.setValue(selectedCultivoFitosanidad.getCultivoId_Cultivo());
		txtCultivoId_Cultivo.setDisabled(false);
		txtFitosanidadId_Fitosanidad.setValue(selectedCultivoFitosanidad.getFitosanidadId_Fitosanidad());
		txtFitosanidadId_Fitosanidad.setDisabled(false);
		txtCultivoId.setValue(selectedCultivoFitosanidad.getCultivoId());
		txtCultivoId.setDisabled(true);
		txtFitosanidadId.setValue(selectedCultivoFitosanidad.getFitosanidadId());
		txtFitosanidadId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCultivoFitosanidad == null) && (entity == null)) {
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
			entity = new CultivoFitosanidad();

			CultivoFitosanidadId id = new CultivoFitosanidadId();
			id.setCultivoId((((txtCultivoId.getValue()) == null) || (txtCultivoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCultivoId));
			id.setFitosanidadId((((txtFitosanidadId.getValue()) == null) || (txtFitosanidadId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtFitosanidadId));

			entity.setId(id);
			entity.setCultivo(businessDelegatorView.getCultivo(entity.getId().getCultivoId()));
			entity.setFitosanidad(businessDelegatorView.getFitosanidad(entity.getId().getFitosanidadId()));
			businessDelegatorView.saveCultivoFitosanidad(entity);
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
				CultivoFitosanidadId id = new CultivoFitosanidadId();
				id.setCultivoId(selectedCultivoFitosanidad.getCultivoId());
				id.setFitosanidadId(selectedCultivoFitosanidad.getFitosanidadId());
				entity = businessDelegatorView.getCultivoFitosanidad(id);
			}

			businessDelegatorView.updateCultivoFitosanidad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCultivoFitosanidad = (CultivoFitosanidadDTO) (evt.getComponent().getAttributes()
					.get("selectedCultivoFitosanidad"));

			CultivoFitosanidadId id = new CultivoFitosanidadId();
			id.setCultivoId(selectedCultivoFitosanidad.getCultivoId());
			id.setFitosanidadId(selectedCultivoFitosanidad.getFitosanidadId());
			entity = businessDelegatorView.getCultivoFitosanidad(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			CultivoFitosanidadId id = new CultivoFitosanidadId();
			id.setCultivoId((((txtCultivoId.getValue()) == null) || (txtCultivoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCultivoId));
			id.setFitosanidadId((((txtFitosanidadId.getValue()) == null) || (txtFitosanidadId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtFitosanidadId));
			entity = businessDelegatorView.getCultivoFitosanidad(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCultivoFitosanidad(entity);
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
			selectedCultivoFitosanidad = (CultivoFitosanidadDTO) (evt.getComponent().getAttributes()
					.get("selectedCultivoFitosanidad"));

			CultivoFitosanidadId id = new CultivoFitosanidadId();
			id.setCultivoId(selectedCultivoFitosanidad.getCultivoId());
			id.setFitosanidadId(selectedCultivoFitosanidad.getFitosanidadId());
			entity = businessDelegatorView.getCultivoFitosanidad(id);
			businessDelegatorView.deleteCultivoFitosanidad(entity);
			data.remove(selectedCultivoFitosanidad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long cultivoId, Long fitosanidadId, Long cultivoId_Cultivo,
			Long fitosanidadId_Fitosanidad) throws Exception {
		try {
			businessDelegatorView.updateCultivoFitosanidad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CultivoFitosanidadView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(InputText txtCultivoId_Cultivo) {
		this.txtCultivoId_Cultivo = txtCultivoId_Cultivo;
	}

	public InputText getTxtFitosanidadId_Fitosanidad() {
		return txtFitosanidadId_Fitosanidad;
	}

	public void setTxtFitosanidadId_Fitosanidad(InputText txtFitosanidadId_Fitosanidad) {
		this.txtFitosanidadId_Fitosanidad = txtFitosanidadId_Fitosanidad;
	}

	public InputText getTxtCultivoId() {
		return txtCultivoId;
	}

	public void setTxtCultivoId(InputText txtCultivoId) {
		this.txtCultivoId = txtCultivoId;
	}

	public InputText getTxtFitosanidadId() {
		return txtFitosanidadId;
	}

	public void setTxtFitosanidadId(InputText txtFitosanidadId) {
		this.txtFitosanidadId = txtFitosanidadId;
	}

	public List<CultivoFitosanidadDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCultivoFitosanidad();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CultivoFitosanidadDTO> cultivoFitosanidadDTO) {
		this.data = cultivoFitosanidadDTO;
	}

	public CultivoFitosanidadDTO getSelectedCultivoFitosanidad() {
		return selectedCultivoFitosanidad;
	}

	public void setSelectedCultivoFitosanidad(CultivoFitosanidadDTO cultivoFitosanidad) {
		this.selectedCultivoFitosanidad = cultivoFitosanidad;
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
