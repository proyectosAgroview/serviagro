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
import co.com.arcosoft.modelo.GroupMembers;
import co.com.arcosoft.modelo.dto.GroupMembersDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GroupMembersView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GroupMembersView.class);
	private InputText txtId_Groups;
	private InputText txtUsuarioId_Usuarios;
	private InputText txtId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GroupMembersDTO> data;
	private GroupMembersDTO selectedGroupMembers;
	private GroupMembers entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GroupMembersView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			GroupMembersDTO groupMembersDTO = (GroupMembersDTO) e.getObject();

			if (txtId_Groups == null) {
				txtId_Groups = new InputText();
			}

			txtId_Groups.setValue(groupMembersDTO.getId_Groups());

			if (txtUsuarioId_Usuarios == null) {
				txtUsuarioId_Usuarios = new InputText();
			}

			txtUsuarioId_Usuarios.setValue(groupMembersDTO.getUsuarioId_Usuarios());

			if (txtId == null) {
				txtId = new InputText();
			}

			txtId.setValue(groupMembersDTO.getId());

			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getGroupMembers(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGroupMembers = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGroupMembers = null;

		if (txtId_Groups != null) {
			txtId_Groups.setValue(null);
			txtId_Groups.setDisabled(true);
		}

		if (txtUsuarioId_Usuarios != null) {
			txtUsuarioId_Usuarios.setValue(null);
			txtUsuarioId_Usuarios.setDisabled(true);
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
			entity = (id != null) ? businessDelegatorView.getGroupMembers(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtId_Groups.setDisabled(false);
			txtUsuarioId_Usuarios.setDisabled(false);
			txtId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtId_Groups.setValue(entity.getGroups().getId());
			txtId_Groups.setDisabled(false);
			txtUsuarioId_Usuarios.setValue(entity.getUsuarios().getUsuarioId());
			txtUsuarioId_Usuarios.setDisabled(false);
			txtId.setValue(entity.getId());
			txtId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGroupMembers = (GroupMembersDTO) (evt.getComponent().getAttributes().get("selectedGroupMembers"));
		txtId_Groups.setValue(selectedGroupMembers.getId_Groups());
		txtId_Groups.setDisabled(false);
		txtUsuarioId_Usuarios.setValue(selectedGroupMembers.getUsuarioId_Usuarios());
		txtUsuarioId_Usuarios.setDisabled(false);
		txtId.setValue(selectedGroupMembers.getId());
		txtId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGroupMembers == null) && (entity == null)) {
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
			entity = new GroupMembers();

			Long id = FacesUtils.checkLong(txtId);

			entity.setId(id);
			entity.setGroups((FacesUtils.checkLong(txtId_Groups) != null)
					? businessDelegatorView.getGroups(FacesUtils.checkLong(txtId_Groups)) : null);
			entity.setUsuarios((FacesUtils.checkLong(txtUsuarioId_Usuarios) != null)
					? businessDelegatorView.getUsuarios(FacesUtils.checkLong(txtUsuarioId_Usuarios)) : null);
			businessDelegatorView.saveGroupMembers(entity);
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
				Long id = new Long(selectedGroupMembers.getId());
				entity = businessDelegatorView.getGroupMembers(id);
			}

			entity.setGroups((FacesUtils.checkLong(txtId_Groups) != null)
					? businessDelegatorView.getGroups(FacesUtils.checkLong(txtId_Groups)) : null);
			entity.setUsuarios((FacesUtils.checkLong(txtUsuarioId_Usuarios) != null)
					? businessDelegatorView.getUsuarios(FacesUtils.checkLong(txtUsuarioId_Usuarios)) : null);
			businessDelegatorView.updateGroupMembers(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGroupMembers = (GroupMembersDTO) (evt.getComponent().getAttributes().get("selectedGroupMembers"));

			Long id = new Long(selectedGroupMembers.getId());
			entity = businessDelegatorView.getGroupMembers(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getGroupMembers(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGroupMembers(entity);
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
			selectedGroupMembers = (GroupMembersDTO) (evt.getComponent().getAttributes().get("selectedGroupMembers"));

			Long id = new Long(selectedGroupMembers.getId());
			entity = businessDelegatorView.getGroupMembers(id);
			businessDelegatorView.deleteGroupMembers(entity);
			data.remove(selectedGroupMembers);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long id, Long id_Groups, Long usuarioId_Usuarios) throws Exception {
		try {
			businessDelegatorView.updateGroupMembers(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GroupMembersView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtId_Groups() {
		return txtId_Groups;
	}

	public void setTxtId_Groups(InputText txtId_Groups) {
		this.txtId_Groups = txtId_Groups;
	}

	public InputText getTxtUsuarioId_Usuarios() {
		return txtUsuarioId_Usuarios;
	}

	public void setTxtUsuarioId_Usuarios(InputText txtUsuarioId_Usuarios) {
		this.txtUsuarioId_Usuarios = txtUsuarioId_Usuarios;
	}

	public InputText getTxtId() {
		return txtId;
	}

	public void setTxtId(InputText txtId) {
		this.txtId = txtId;
	}

	public List<GroupMembersDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGroupMembers();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GroupMembersDTO> groupMembersDTO) {
		this.data = groupMembersDTO;
	}

	public GroupMembersDTO getSelectedGroupMembers() {
		return selectedGroupMembers;
	}

	public void setSelectedGroupMembers(GroupMembersDTO groupMembers) {
		this.selectedGroupMembers = groupMembers;
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
