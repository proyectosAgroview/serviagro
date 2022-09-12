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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.GroupAuthorities;
import co.com.arcosoft.modelo.Groups;
import co.com.arcosoft.modelo.dto.GroupsDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GroupsView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GroupsView.class);
	private InputText txtGroupName;
	private InputText txtId;
	private SelectOneMenu txtAuthority;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GroupsDTO> data;
	private GroupsDTO selectedGroups;
	private Groups entity;
	private GroupAuthorities entity2;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GroupsView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			GroupsDTO groupsDTO = (GroupsDTO) e.getObject();

			if (txtGroupName == null) {
				txtGroupName = new InputText();
			}

			txtGroupName.setValue(groupsDTO.getGroupName());

			if (txtId == null) {
				txtId = new InputText();
			}

			txtId.setValue(groupsDTO.getId());

			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getGroups(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGroups = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGroups = null;

		if (txtGroupName != null) {
			txtGroupName.setValue(null);
			txtGroupName.setDisabled(false);
		}

		if (txtId != null) {
			txtId.setValue(null);
			txtId.setDisabled(false);
		}

		if (txtAuthority != null) {
			txtAuthority.setValue(null);
			txtAuthority.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	public void listener_txtId() {
		try {
			Long id = FacesUtils.checkLong(txtId);
			entity = (id != null) ? businessDelegatorView.getGroups(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtGroupName.setDisabled(false);
			txtId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtGroupName.setValue(entity.getGroupName());
			txtGroupName.setDisabled(false);
			txtId.setValue(entity.getId());
			txtId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGroups = (GroupsDTO) (evt.getComponent().getAttributes().get("selectedGroups"));
		try {

			String id = selectedGroups.getId().toString();
			Object[] condicion1 = { "id", true, id, "=" };
			List<Groups> lista = (id != null) ? businessDelegatorView.findByCriteriaInGroups(condicion1, null, null)
					: null;

			Object[] condicion2 = { "groups.id", false, selectedGroups.getId().longValue(), "=", "id", true,
					selectedGroups.getId_GroupsAutoridad(), "=" };
			List<GroupAuthorities> ga = businessDelegatorView.findByCriteriaInGroupAuthorities(condicion2, null, null);

			if ((lista != null && lista.size() > 0) && (ga != null && ga.size() > 0)) {
				entity = lista.get(0);
				entity2 = ga.get(0);

				txtGroupName.setValue(entity.getGroupName());
				txtGroupName.setDisabled(false);
				txtId.setValue(entity.getId());
				txtId.setDisabled(true);
				txtAuthority.setValue(entity2.getAuthority());
				txtAuthority.setDisabled(false);

				btnSave.setDisabled(false);
				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
			entity2 = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGroups == null) && (entity == null)) {
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
			entity = new Groups();
			entity2 = new GroupAuthorities();

			entity.setGroupName(FacesUtils.checkString(txtGroupName));
			entity2.setAuthority(FacesUtils.checkString(txtAuthority));

			businessDelegatorView.saveGroups(entity, entity2);
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
				Long id = new Long(selectedGroups.getId());
				entity = businessDelegatorView.getGroups(id);

				Long id_grupoAuth = new Long(selectedGroups.getId_GroupsAutoridad());
				entity2 = businessDelegatorView.getGroupAuthorities(id_grupoAuth);
			}

			entity.setGroupName(FacesUtils.checkString(txtGroupName));
			entity2.setAuthority(FacesUtils.checkString(txtAuthority));

			businessDelegatorView.updateGroups(entity, entity2);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGroups = (GroupsDTO) (evt.getComponent().getAttributes().get("selectedGroups"));

			Long id = new Long(selectedGroups.getId());
			entity = businessDelegatorView.getGroups(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getGroups(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGroups(entity);
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
			selectedGroups = (GroupsDTO) (evt.getComponent().getAttributes().get("selectedGroups"));

			Long id = new Long(selectedGroups.getId());
			entity = businessDelegatorView.getGroups(id);
			businessDelegatorView.deleteGroups(entity);
			data.remove(selectedGroups);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String groupName, Long id) throws Exception {
		try {
			entity.setGroupName(FacesUtils.checkString(groupName));
			businessDelegatorView.updateGroups(entity, entity2);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GroupsView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtGroupName() {
		return txtGroupName;
	}

	public void setTxtGroupName(InputText txtGroupName) {
		this.txtGroupName = txtGroupName;
	}

	public InputText getTxtId() {
		return txtId;
	}

	public void setTxtId(InputText txtId) {
		this.txtId = txtId;
	}

	public List<GroupsDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGroups();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GroupsDTO> groupsDTO) {
		this.data = groupsDTO;
	}

	public GroupsDTO getSelectedGroups() {
		return selectedGroups;
	}

	public void setSelectedGroups(GroupsDTO groups) {
		this.selectedGroups = groups;
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

	public SelectOneMenu getTxtAuthority() {
		return txtAuthority;
	}

	public void setTxtAuthority(SelectOneMenu txtAuthority) {
		this.txtAuthority = txtAuthority;
	}

}
