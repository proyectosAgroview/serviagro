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
import co.com.arcosoft.modelo.VariedadNivel4;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VariedadNivel4View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VariedadNivel4View.class);
	private InputText txtPorcentajeArea;
	private InputText txtNivel4Id_Nivel4;
	private InputText txtVariedId_Variedad;
	private InputText txtVariedadNivel4Id;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<VariedadNivel4DTO> data;
	private VariedadNivel4DTO selectedVariedadNivel4;
	private VariedadNivel4 entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public VariedadNivel4View() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			VariedadNivel4DTO variedadNivel4DTO = (VariedadNivel4DTO) e.getObject();

			if (txtPorcentajeArea == null) {
				txtPorcentajeArea = new InputText();
			}

			txtPorcentajeArea.setValue(variedadNivel4DTO.getPorcentajeArea());

			if (txtNivel4Id_Nivel4 == null) {
				txtNivel4Id_Nivel4 = new InputText();
			}

			txtNivel4Id_Nivel4.setValue(variedadNivel4DTO.getNivel4Id_Nivel4());

			if (txtVariedId_Variedad == null) {
				txtVariedId_Variedad = new InputText();
			}

			txtVariedId_Variedad.setValue(variedadNivel4DTO.getVariedId_Variedad());

			if (txtVariedadNivel4Id == null) {
				txtVariedadNivel4Id = new InputText();
			}

			txtVariedadNivel4Id.setValue(variedadNivel4DTO.getVariedadNivel4Id());

			Long variedadNivel4Id = FacesUtils.checkLong(txtVariedadNivel4Id);
			entity = businessDelegatorView.getVariedadNivel4(variedadNivel4Id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedVariedadNivel4 = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedVariedadNivel4 = null;

		if (txtPorcentajeArea != null) {
			txtPorcentajeArea.setValue(null);
			txtPorcentajeArea.setDisabled(true);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (txtVariedId_Variedad != null) {
			txtVariedId_Variedad.setValue(null);
			txtVariedId_Variedad.setDisabled(true);
		}

		if (txtVariedadNivel4Id != null) {
			txtVariedadNivel4Id.setValue(null);
			txtVariedadNivel4Id.setDisabled(false);
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
			Long variedadNivel4Id = FacesUtils.checkLong(txtVariedadNivel4Id);
			entity = (variedadNivel4Id != null) ? businessDelegatorView.getVariedadNivel4(variedadNivel4Id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtPorcentajeArea.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
			txtVariedId_Variedad.setDisabled(false);
			txtVariedadNivel4Id.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtPorcentajeArea.setValue(entity.getPorcentajeArea());
			txtPorcentajeArea.setDisabled(false);
			txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
			txtNivel4Id_Nivel4.setDisabled(false);
			txtVariedId_Variedad.setValue(entity.getVariedad().getVariedId());
			txtVariedId_Variedad.setDisabled(false);
			txtVariedadNivel4Id.setValue(entity.getVariedadNivel4Id());
			txtVariedadNivel4Id.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedVariedadNivel4 = (VariedadNivel4DTO) (evt.getComponent().getAttributes().get("selectedVariedadNivel4"));
		txtPorcentajeArea.setValue(selectedVariedadNivel4.getPorcentajeArea());
		txtPorcentajeArea.setDisabled(false);
		txtNivel4Id_Nivel4.setValue(selectedVariedadNivel4.getNivel4Id_Nivel4());
		txtNivel4Id_Nivel4.setDisabled(false);
		txtVariedId_Variedad.setValue(selectedVariedadNivel4.getVariedId_Variedad());
		txtVariedId_Variedad.setDisabled(false);
		txtVariedadNivel4Id.setValue(selectedVariedadNivel4.getVariedadNivel4Id());
		txtVariedadNivel4Id.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedVariedadNivel4 == null) && (entity == null)) {
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
			entity = new VariedadNivel4();

			Long variedadNivel4Id = FacesUtils.checkLong(txtVariedadNivel4Id);

			entity.setPorcentajeArea(FacesUtils.checkDouble(txtPorcentajeArea));
			entity.setVariedadNivel4Id(variedadNivel4Id);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setVariedad((FacesUtils.checkLong(txtVariedId_Variedad) != null)
					? businessDelegatorView.getVariedad(FacesUtils.checkLong(txtVariedId_Variedad)) : null);
			businessDelegatorView.saveVariedadNivel4(entity);
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
				Long variedadNivel4Id = new Long(selectedVariedadNivel4.getVariedadNivel4Id());
				entity = businessDelegatorView.getVariedadNivel4(variedadNivel4Id);
			}

			entity.setPorcentajeArea(FacesUtils.checkDouble(txtPorcentajeArea));
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setVariedad((FacesUtils.checkLong(txtVariedId_Variedad) != null)
					? businessDelegatorView.getVariedad(FacesUtils.checkLong(txtVariedId_Variedad)) : null);
			businessDelegatorView.updateVariedadNivel4(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedVariedadNivel4 = (VariedadNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedVariedadNivel4"));

			Long variedadNivel4Id = new Long(selectedVariedadNivel4.getVariedadNivel4Id());
			entity = businessDelegatorView.getVariedadNivel4(variedadNivel4Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long variedadNivel4Id = FacesUtils.checkLong(txtVariedadNivel4Id);
			entity = businessDelegatorView.getVariedadNivel4(variedadNivel4Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteVariedadNivel4(entity);
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
			selectedVariedadNivel4 = (VariedadNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedVariedadNivel4"));

			Long variedadNivel4Id = new Long(selectedVariedadNivel4.getVariedadNivel4Id());
			entity = businessDelegatorView.getVariedadNivel4(variedadNivel4Id);
			businessDelegatorView.deleteVariedadNivel4(entity);
			data.remove(selectedVariedadNivel4);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double porcentajeArea, Long variedadNivel4Id, Long nivel4Id_Nivel4,
			Long variedId_Variedad) throws Exception {
		try {
			entity.setPorcentajeArea(FacesUtils.checkDouble(porcentajeArea));
			businessDelegatorView.updateVariedadNivel4(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("VariedadNivel4View").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtPorcentajeArea() {
		return txtPorcentajeArea;
	}

	public void setTxtPorcentajeArea(InputText txtPorcentajeArea) {
		this.txtPorcentajeArea = txtPorcentajeArea;
	}

	public InputText getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(InputText txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public InputText getTxtVariedId_Variedad() {
		return txtVariedId_Variedad;
	}

	public void setTxtVariedId_Variedad(InputText txtVariedId_Variedad) {
		this.txtVariedId_Variedad = txtVariedId_Variedad;
	}

	public InputText getTxtVariedadNivel4Id() {
		return txtVariedadNivel4Id;
	}

	public void setTxtVariedadNivel4Id(InputText txtVariedadNivel4Id) {
		this.txtVariedadNivel4Id = txtVariedadNivel4Id;
	}

	public List<VariedadNivel4DTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVariedadNivel4();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<VariedadNivel4DTO> variedadNivel4DTO) {
		this.data = variedadNivel4DTO;
	}

	public VariedadNivel4DTO getSelectedVariedadNivel4() {
		return selectedVariedadNivel4;
	}

	public void setSelectedVariedadNivel4(VariedadNivel4DTO variedadNivel4) {
		this.selectedVariedadNivel4 = variedadNivel4;
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
