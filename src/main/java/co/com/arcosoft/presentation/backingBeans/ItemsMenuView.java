package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.editor.Editor;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ItemsMenu;
import co.com.arcosoft.modelo.dto.ItemsMenuDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ItemsMenuView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ItemsMenuView.class);
	private Editor txtDescripcion;
	private String text;
	private String modulo;
	private SelectOneRadio txtEstado;
	private InputText txtNombreItem;
	private SelectOneMenu txtNombreModulo;
	private InputText txtNombreTabla;
	private InputText txtUrl;
	private InputText txtId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ItemsMenuDTO> data;
	private List<ItemsMenuDTO> dataGlosario;
	private ItemsMenuDTO selectedItemsMenu;
	private ItemsMenu entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ItemsMenuView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ItemsMenuDTO itemsMenuDTO = (ItemsMenuDTO) e.getObject();

			if (txtDescripcion == null) {
				txtDescripcion = new Editor();
			}

			txtDescripcion.setValue(itemsMenuDTO.getDescripcion());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(itemsMenuDTO.getEstado());

			if (txtNombreItem == null) {
				txtNombreItem = new InputText();
			}

			txtNombreItem.setValue(itemsMenuDTO.getNombreItem());

			if (txtNombreModulo == null) {
				txtNombreModulo = new SelectOneMenu();
			}

			txtNombreModulo.setValue(itemsMenuDTO.getNombreModulo());

			if (txtNombreTabla == null) {
				txtNombreTabla = new InputText();
			}

			txtNombreTabla.setValue(itemsMenuDTO.getNombreTabla());

			if (txtUrl == null) {
				txtUrl = new InputText();
			}

			txtUrl.setValue(itemsMenuDTO.getUrl());

			if (txtId == null) {
				txtId = new InputText();
			}

			txtId.setValue(itemsMenuDTO.getId());

			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getItemsMenu(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedItemsMenu = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedItemsMenu = null;
		PrimeFaces.current().resetInputs(":dialogItemsMenu :frm");

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtNombreItem != null) {
			txtNombreItem.setValue(null);
			txtNombreItem.setDisabled(false);
		}

		if (txtNombreModulo != null) {
			txtNombreModulo.setValue(null);
			txtNombreModulo.setDisabled(false);
		}

		if (txtNombreTabla != null) {
			txtNombreTabla.setValue(null);
			txtNombreTabla.setDisabled(false);
		}

		if (txtUrl != null) {
			txtUrl.setValue(null);
			txtUrl.setDisabled(false);
		}

		if (txtId != null) {
			txtId.setValue(null);
			txtId.setDisabled(false);
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
			entity = (id != null) ? businessDelegatorView.getItemsMenu(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtDescripcion.setDisabled(false);
			txtEstado.setDisabled(false);
			txtNombreItem.setDisabled(false);
			txtNombreModulo.setDisabled(false);
			txtNombreTabla.setDisabled(false);
			txtUrl.setDisabled(false);
			txtId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			// txtDescripcion.setValue(entity.getDescripcion());
			text = entity.getDescripcion().toString();
			// txtDescripcion.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtNombreItem.setValue(entity.getNombreItem());
			txtNombreItem.setDisabled(false);
			txtNombreModulo.setValue(entity.getNombreModulo());
			txtNombreModulo.setDisabled(false);
			txtNombreTabla.setValue(entity.getNombreTabla());
			txtNombreTabla.setDisabled(false);
			txtUrl.setValue(entity.getUrl());
			txtUrl.setDisabled(false);
			txtId.setValue(entity.getId());
			txtId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedItemsMenu = (ItemsMenuDTO) (evt.getComponent().getAttributes().get("selectedItemsMenu"));

		PrimeFaces.current().resetInputs(":dialogItemsMenu :frm");

		try {

			Long id = selectedItemsMenu.getId().longValue();
			entity = (id != null) ? businessDelegatorView.getItemsMenu(id) : null;

			if (entity != null) {
				// txtDescripcion.setValue(entity.getDescripcion());
				if (entity.getDescripcion() != null) {
					text = entity.getDescripcion().toString();
				} else {
					text = " ";
				}
				// txtDescripcion.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtNombreItem.setValue(entity.getNombreItem());
				txtNombreItem.setDisabled(false);
				txtNombreModulo.setValue(entity.getNombreModulo());
				txtNombreModulo.setDisabled(false);
				txtNombreTabla.setValue(entity.getNombreTabla());
				txtNombreTabla.setDisabled(false);
				txtUrl.setValue(entity.getUrl());
				txtUrl.setDisabled(false);
				txtId.setValue(selectedItemsMenu.getId());
				txtId.setDisabled(true);
				btnSave.setDisabled(false);
				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedItemsMenu == null) && (entity == null)) {
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
			entity = new ItemsMenu();

			Long id = FacesUtils.checkLong(txtId);

			entity.setDescripcion(text);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setId(id);
			entity.setNombreItem(FacesUtils.checkString(txtNombreItem));
			entity.setNombreModulo(FacesUtils.checkString(txtNombreModulo));
			entity.setNombreTabla(FacesUtils.checkString(txtNombreTabla));
			entity.setUrl(FacesUtils.checkString(txtUrl));
			businessDelegatorView.saveItemsMenu(entity);
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
				Long id = new Long(selectedItemsMenu.getId());
				entity = businessDelegatorView.getItemsMenu(id);
			}

			entity.setDescripcion(text);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setNombreItem(FacesUtils.checkString(txtNombreItem));
			entity.setNombreModulo(FacesUtils.checkString(txtNombreModulo));
			entity.setNombreTabla(FacesUtils.checkString(txtNombreTabla));
			entity.setUrl(FacesUtils.checkString(txtUrl));
			businessDelegatorView.updateItemsMenu(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedItemsMenu = (ItemsMenuDTO) (evt.getComponent().getAttributes().get("selectedItemsMenu"));

			Long id = new Long(selectedItemsMenu.getId());
			entity = businessDelegatorView.getItemsMenu(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long id = FacesUtils.checkLong(txtId);
			entity = businessDelegatorView.getItemsMenu(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteItemsMenu(entity);
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
			selectedItemsMenu = (ItemsMenuDTO) (evt.getComponent().getAttributes().get("selectedItemsMenu"));

			Long id = new Long(selectedItemsMenu.getId());
			entity = businessDelegatorView.getItemsMenu(id);
			businessDelegatorView.deleteItemsMenu(entity);
			data.remove(selectedItemsMenu);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String descripcion, String estado, Long id, String nombreItem,
			String nombreModulo, String nombreTabla, String url) throws Exception {
		try {
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setNombreItem(FacesUtils.checkString(nombreItem));
			entity.setNombreModulo(FacesUtils.checkString(nombreModulo));
			entity.setNombreTabla(FacesUtils.checkString(nombreTabla));
			entity.setUrl(FacesUtils.checkString(url));
			businessDelegatorView.updateItemsMenu(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ItemsMenuView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public Editor getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(Editor txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtNombreItem() {
		return txtNombreItem;
	}

	public void setTxtNombreItem(InputText txtNombreItem) {
		this.txtNombreItem = txtNombreItem;
	}

	public SelectOneMenu getTxtNombreModulo() {
		return txtNombreModulo;
	}

	public void setTxtNombreModulo(SelectOneMenu txtNombreModulo) {
		this.txtNombreModulo = txtNombreModulo;
	}

	public InputText getTxtNombreTabla() {
		return txtNombreTabla;
	}

	public void setTxtNombreTabla(InputText txtNombreTabla) {
		this.txtNombreTabla = txtNombreTabla;
	}

	public InputText getTxtUrl() {
		return txtUrl;
	}

	public void setTxtUrl(InputText txtUrl) {
		this.txtUrl = txtUrl;
	}

	public InputText getTxtId() {
		return txtId;
	}

	public void setTxtId(InputText txtId) {
		this.txtId = txtId;
	}

	public List<ItemsMenuDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataItemsMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ItemsMenuDTO> itemsMenuDTO) {
		this.data = itemsMenuDTO;
	}

	public ItemsMenuDTO getSelectedItemsMenu() {
		return selectedItemsMenu;
	}

	public void setSelectedItemsMenu(ItemsMenuDTO itemsMenu) {
		this.selectedItemsMenu = itemsMenu;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<ItemsMenuDTO> getDataGlosario() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				this.modulo = cookie2.getValue();

			}
		}

		try {
			if (dataGlosario == null) {
				dataGlosario = businessDelegatorView.getDataItemsMenuGlosario(this.modulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataGlosario;
	}

	public void setDataGlosario(List<ItemsMenuDTO> dataGlosario) {
		this.dataGlosario = dataGlosario;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

}
