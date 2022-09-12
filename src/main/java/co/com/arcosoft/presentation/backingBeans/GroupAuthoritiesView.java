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
import co.com.arcosoft.modelo.GroupAuthorities;
import co.com.arcosoft.modelo.dto.GroupAuthoritiesDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GroupAuthoritiesView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GroupAuthoritiesView.class);
	private String txtAuthority;
	private InputText txtId_Groups;
	private InputText txtId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GroupAuthoritiesDTO> data;
	private GroupAuthoritiesDTO selectedGroupAuthorities;
	private GroupAuthorities entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GroupAuthoritiesView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			GroupAuthoritiesDTO groupAuthoritiesDTO = (GroupAuthoritiesDTO) e.getObject();

			/*
			 * if (txtAuthority == null) { txtAuthority = new String(); }
			 * 
			 * txtAuthority.setValue(groupAuthoritiesDTO.getAuthority());
			 */

			if (txtId_Groups == null) {
				txtId_Groups = new InputText();
			}

			txtId_Groups.setValue(groupAuthoritiesDTO.getId_Groups());

			if (txtId == null) {
				txtId = new InputText();
			}

			txtId.setValue(groupAuthoritiesDTO.getId());

			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getGroupAuthorities(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGroupAuthorities = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGroupAuthorities = null;

		/*
		 * if (txtAuthority != null) { txtAuthority = ""; // }
		 */

		if (txtId_Groups != null) {
			txtId_Groups.setValue(null);
			txtId_Groups.setDisabled(true);
		}

		if (txtId != null) {
			txtId.setValue(null);
			txtId.setDisabled(false);
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
			Long id = FacesUtils.checkLong(txtId);
			entity = (id != null) ? businessDelegatorView.getGroupAuthorities(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtAuthority.setDisabled(false);
			txtId_Groups.setDisabled(false);
			txtId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAuthority = entity.getAuthority();
			// txtAuthority.setDisabled(false);
			txtId_Groups.setValue(entity.getGroups().getId());
			txtId_Groups.setDisabled(false);
			txtId.setValue(entity.getId());
			txtId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGroupAuthorities = (GroupAuthoritiesDTO) (evt.getComponent().getAttributes()
				.get("selectedGroupAuthorities"));
		txtAuthority = selectedGroupAuthorities.getAuthority().toString();
		// txtAuthority.setDisabled(false);
		txtId_Groups.setValue(selectedGroupAuthorities.getId_Groups());
		txtId_Groups.setDisabled(false);
		txtId.setValue(selectedGroupAuthorities.getId());
		txtId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGroupAuthorities == null) && (entity == null)) {
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
			entity = new GroupAuthorities();

			Long id = FacesUtils.checkLong(txtId);

			entity.setAuthority(FacesUtils.checkString(txtAuthority));
			entity.setId(id);
			entity.setGroups((FacesUtils.checkLong(txtId_Groups) != null)
					? businessDelegatorView.getGroups(FacesUtils.checkLong(txtId_Groups)) : null);
			businessDelegatorView.saveGroupAuthorities(entity);
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
				Long id = new Long(selectedGroupAuthorities.getId());
				entity = businessDelegatorView.getGroupAuthorities(id);
			}

			entity.setAuthority(FacesUtils.checkString(txtAuthority));
			entity.setGroups((FacesUtils.checkLong(txtId_Groups) != null)
					? businessDelegatorView.getGroups(FacesUtils.checkLong(txtId_Groups)) : null);
			businessDelegatorView.updateGroupAuthorities(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGroupAuthorities = (GroupAuthoritiesDTO) (evt.getComponent().getAttributes()
					.get("selectedGroupAuthorities"));

			Long id = new Long(selectedGroupAuthorities.getId());
			entity = businessDelegatorView.getGroupAuthorities(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getGroupAuthorities(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGroupAuthorities(entity);
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
			selectedGroupAuthorities = (GroupAuthoritiesDTO) (evt.getComponent().getAttributes()
					.get("selectedGroupAuthorities"));

			Long id = new Long(selectedGroupAuthorities.getId());
			entity = businessDelegatorView.getGroupAuthorities(id);
			businessDelegatorView.deleteGroupAuthorities(entity);
			data.remove(selectedGroupAuthorities);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String authority, Long id, Long id_Groups) throws Exception {
		try {
			entity.setAuthority(FacesUtils.checkString(authority));
			businessDelegatorView.updateGroupAuthorities(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GroupAuthoritiesView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String getTxtAuthority() {
		return txtAuthority;
	}

	public void setTxtAuthority(String txtAuthority) {
		this.txtAuthority = txtAuthority;
	}

	public InputText getTxtId_Groups() {
		return txtId_Groups;
	}

	public void setTxtId_Groups(InputText txtId_Groups) {
		this.txtId_Groups = txtId_Groups;
	}

	public InputText getTxtId() {
		return txtId;
	}

	public void setTxtId(InputText txtId) {
		this.txtId = txtId;
	}

	public List<GroupAuthoritiesDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGroupAuthorities();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GroupAuthoritiesDTO> groupAuthoritiesDTO) {
		this.data = groupAuthoritiesDTO;
	}

	public GroupAuthoritiesDTO getSelectedGroupAuthorities() {
		return selectedGroupAuthorities;
	}

	public void setSelectedGroupAuthorities(GroupAuthoritiesDTO groupAuthorities) {
		this.selectedGroupAuthorities = groupAuthorities;
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
