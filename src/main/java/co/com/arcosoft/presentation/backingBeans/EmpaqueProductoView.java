package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Empaque;
import co.com.arcosoft.modelo.EmpaqueProducto;
import co.com.arcosoft.modelo.EmpaqueProductoId;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.dto.EmpaqueProductoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EmpaqueProductoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EmpaqueProductoView.class);
	// private InputText txtEmpaqueId_Empaque;
	// private InputText txtProductoId_Producto;
	// private InputText txtProductoId;
	// private InputText txtEmpaqueId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EmpaqueProductoDTO> data;
	private EmpaqueProductoDTO selectedEmpaqueProducto;
	private EmpaqueProducto entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtProductoId;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtEmpaqueId;
	SelectItem[] selectEmpaqueId;
	private List<Empaque> empaqueId;

	public EmpaqueProductoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			EmpaqueProductoDTO empaqueProductoDTO = (EmpaqueProductoDTO) e.getObject();

			if (txtProductoId == null) {
				txtProductoId = new SelectOneMenu();
			}

			txtProductoId.setValue(empaqueProductoDTO.getProductoId());

			if (txtEmpaqueId == null) {
				txtEmpaqueId = new SelectOneMenu();
			}

			txtEmpaqueId.setValue(empaqueProductoDTO.getEmpaqueId());

			EmpaqueProductoId id = new EmpaqueProductoId();
			id.setProductoId((((txtProductoId.getValue()) == null) || (txtProductoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtProductoId));
			id.setEmpaqueId((((txtEmpaqueId.getValue()) == null) || (txtEmpaqueId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtEmpaqueId));
			entity = businessDelegatorView.getEmpaqueProducto(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedEmpaqueProducto = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedEmpaqueProducto = null;
		PrimeFaces.current().resetInputs(":dialogEmpaqueProducto :frm");

		if (txtProductoId != null) {
			txtProductoId.setValue(null);
			txtProductoId.setDisabled(false);
		}

		if (txtEmpaqueId != null) {
			txtEmpaqueId.setValue(null);
			txtEmpaqueId.setDisabled(false);
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
			EmpaqueProductoId id = new EmpaqueProductoId();
			id.setProductoId((((txtProductoId.getValue()) == null) || (txtProductoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtProductoId));
			id.setEmpaqueId((((txtEmpaqueId.getValue()) == null) || (txtEmpaqueId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtEmpaqueId));
			entity = (id != null) ? businessDelegatorView.getEmpaqueProducto(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {

			txtProductoId.setDisabled(false);
			txtEmpaqueId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {

			txtProductoId.setValue(entity.getId().getProductoId());
			txtProductoId.setDisabled(true);
			txtEmpaqueId.setValue(entity.getId().getEmpaqueId());
			txtEmpaqueId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedEmpaqueProducto = (EmpaqueProductoDTO) (evt.getComponent().getAttributes()
				.get("selectedEmpaqueProducto"));
		try {

			Long producto = selectedEmpaqueProducto.getProductoId();
			Object[] condicion = { "productoId", true, producto, "=" };
			List<EmpaqueProducto> lista = (producto != null)
					? businessDelegatorView.findByCriteriaInEmpaqueProducto(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtProductoId.setValue(selectedEmpaqueProducto.getProductoId());
				txtProductoId.setDisabled(true);
				txtEmpaqueId.setValue(selectedEmpaqueProducto.getEmpaqueId());
				txtEmpaqueId.setDisabled(true);
				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedEmpaqueProducto == null) && (entity == null)) {
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
			entity = new EmpaqueProducto();

			EmpaqueProductoId id = new EmpaqueProductoId();
			id.setProductoId((((txtProductoId.getValue()) == null) || (txtProductoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtProductoId));
			id.setEmpaqueId((((txtEmpaqueId.getValue()) == null) || (txtEmpaqueId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtEmpaqueId));

			entity.setId(id);
			entity.setEmpaque(businessDelegatorView.getEmpaque(entity.getId().getEmpaqueId()));
			entity.setProducto(businessDelegatorView.getProducto(entity.getId().getProductoId()));
			businessDelegatorView.saveEmpaqueProducto(entity);
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
				EmpaqueProductoId id = new EmpaqueProductoId();
				id.setProductoId(selectedEmpaqueProducto.getProductoId());
				id.setEmpaqueId(selectedEmpaqueProducto.getEmpaqueId());
				entity = businessDelegatorView.getEmpaqueProducto(id);
			}

			businessDelegatorView.updateEmpaqueProducto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedEmpaqueProducto = (EmpaqueProductoDTO) (evt.getComponent().getAttributes()
					.get("selectedEmpaqueProducto"));

			EmpaqueProductoId id = new EmpaqueProductoId();
			id.setProductoId(selectedEmpaqueProducto.getProductoId());
			id.setEmpaqueId(selectedEmpaqueProducto.getEmpaqueId());
			entity = businessDelegatorView.getEmpaqueProducto(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			EmpaqueProductoId id = new EmpaqueProductoId();
			id.setProductoId((((txtProductoId.getValue()) == null) || (txtProductoId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtProductoId));
			id.setEmpaqueId((((txtEmpaqueId.getValue()) == null) || (txtEmpaqueId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtEmpaqueId));
			entity = businessDelegatorView.getEmpaqueProducto(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteEmpaqueProducto(entity);
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
			selectedEmpaqueProducto = (EmpaqueProductoDTO) (evt.getComponent().getAttributes()
					.get("selectedEmpaqueProducto"));

			EmpaqueProductoId id = new EmpaqueProductoId();
			id.setProductoId(selectedEmpaqueProducto.getProductoId());
			id.setEmpaqueId(selectedEmpaqueProducto.getEmpaqueId());
			entity = businessDelegatorView.getEmpaqueProducto(id);
			businessDelegatorView.deleteEmpaqueProducto(entity);
			data.remove(selectedEmpaqueProducto);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long productoId, Long empaqueId, Long empaqueId_Empaque, Long productoId_Producto)
			throws Exception {
		try {
			businessDelegatorView.updateEmpaqueProducto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("EmpaqueProductoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtProductoId() {
		return txtProductoId;
	}

	public void setTxtProductoId(SelectOneMenu txtProductoId) {
		this.txtProductoId = txtProductoId;
	}

	public SelectOneMenu getTxtEmpaqueId() {
		return txtEmpaqueId;
	}

	public void setTxtEmpaqueId(SelectOneMenu txtEmpaqueId) {
		this.txtEmpaqueId = txtEmpaqueId;
	}

	public List<EmpaqueProductoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataEmpaqueProducto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<EmpaqueProductoDTO> empaqueProductoDTO) {
		this.data = empaqueProductoDTO;
	}

	public EmpaqueProductoDTO getSelectedEmpaqueProducto() {
		return selectedEmpaqueProducto;
	}

	public void setSelectedEmpaqueProducto(EmpaqueProductoDTO empaqueProducto) {
		this.selectedEmpaqueProducto = empaqueProducto;
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

	public SelectItem[] getSelectProductoId() {

		if (productoId == null || productoId.size() == 0) {

			productoId = new ArrayList<Producto>();

			try {

				productoId = businessDelegatorView.getProducto(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoId = new SelectItem[lista.size()];

				int i = 0;
				for (Producto productoId : lista) {
					selectProductoId[i] = new SelectItem(productoId.getProductoId(), productoId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoId;
	}

	public void setselectProductoId(SelectItem[] selectProductoId) {
		this.selectProductoId = selectProductoId;
	}

	public SelectItem[] getSelectEmpaqueId() {

		if (empaqueId == null || empaqueId.size() == 0) {

			empaqueId = new ArrayList<Empaque>();

			try {

				empaqueId = businessDelegatorView.getEmpaque(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Empaque> lista = businessDelegatorView.findByCriteriaInEmpaque(condicion, null, null);
				selectEmpaqueId = new SelectItem[lista.size()];

				int i = 0;
				for (Empaque empaqueId : lista) {
					selectEmpaqueId[i] = new SelectItem(empaqueId.getEmpaqueId(), empaqueId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEmpaqueId;
	}

	public void setSelectEmpaqueId(SelectItem[] selectEmpaqueId) {
		this.selectEmpaqueId = selectEmpaqueId;
	}

}
