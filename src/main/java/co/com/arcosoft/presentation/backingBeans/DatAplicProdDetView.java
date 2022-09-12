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
import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatAplicProdDetView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatAplicProdDetView.class);

	private InputText txtCantidadAplicada;
	private InputText txtCompania;
	private InputText txtCostoTotal;
	private InputText txtDosis;
	private InputText txtValorUnit;
	private InputText txtDatAplicProdId_DatAplicProducto;
	private InputText txtProductoId_Producto;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtDatProdDetId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatAplicProdDetDTO> data;
	private DatAplicProdDetDTO selectedDatAplicProdDet;
	private DatAplicProdDet entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatAplicProdDetView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatAplicProdDetDTO datAplicProdDetDTO = (DatAplicProdDetDTO) e.getObject();

			if (txtCantidadAplicada == null) {
				txtCantidadAplicada = new InputText();
			}

			txtCantidadAplicada.setValue(datAplicProdDetDTO.getCantidadAplicada());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datAplicProdDetDTO.getCompania());

			if (txtCostoTotal == null) {
				txtCostoTotal = new InputText();
			}

			txtCostoTotal.setValue(datAplicProdDetDTO.getCostoTotal());

			if (txtDosis == null) {
				txtDosis = new InputText();
			}

			txtDosis.setValue(datAplicProdDetDTO.getDosis());

			if (txtValorUnit == null) {
				txtValorUnit = new InputText();
			}

			txtValorUnit.setValue(datAplicProdDetDTO.getValorUnit());

			if (txtDatAplicProdId_DatAplicProducto == null) {
				txtDatAplicProdId_DatAplicProducto = new InputText();
			}

			txtDatAplicProdId_DatAplicProducto.setValue(datAplicProdDetDTO.getDatAplicProdId_DatAplicProducto());

			if (txtProductoId_Producto == null) {
				txtProductoId_Producto = new InputText();
			}

			txtProductoId_Producto.setValue(datAplicProdDetDTO.getProductoId_Producto());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(datAplicProdDetDTO.getUdadMedId_UdadMed());

			if (txtDatProdDetId == null) {
				txtDatProdDetId = new InputText();
			}

			txtDatProdDetId.setValue(datAplicProdDetDTO.getDatProdDetId());

			Long datProdDetId = FacesUtils.checkLong(txtDatProdDetId);
			entity = businessDelegatorView.getDatAplicProdDet(datProdDetId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatAplicProdDet = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatAplicProdDet = null;

		if (txtCantidadAplicada != null) {
			txtCantidadAplicada.setValue(null);
			txtCantidadAplicada.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(null);
			txtCostoTotal.setDisabled(true);
		}

		if (txtDosis != null) {
			txtDosis.setValue(null);
			txtDosis.setDisabled(true);
		}

		if (txtValorUnit != null) {
			txtValorUnit.setValue(null);
			txtValorUnit.setDisabled(true);
		}

		if (txtDatAplicProdId_DatAplicProducto != null) {
			txtDatAplicProdId_DatAplicProducto.setValue(null);
			txtDatAplicProdId_DatAplicProducto.setDisabled(true);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtDatProdDetId != null) {
			txtDatProdDetId.setValue(null);
			txtDatProdDetId.setDisabled(false);
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
			Long datProdDetId = FacesUtils.checkLong(txtDatProdDetId);
			entity = (datProdDetId != null) ? businessDelegatorView.getDatAplicProdDet(datProdDetId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCantidadAplicada.setDisabled(false);
			txtCompania.setDisabled(false);
			txtCostoTotal.setDisabled(false);
			txtDosis.setDisabled(false);
			txtValorUnit.setDisabled(false);
			txtDatAplicProdId_DatAplicProducto.setDisabled(false);
			txtProductoId_Producto.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatProdDetId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadAplicada.setValue(entity.getCantidadAplicada());
			txtCantidadAplicada.setDisabled(false);
			txtCompania.setDisabled(false);
			txtCostoTotal.setValue(entity.getCostoTotal());
			txtCostoTotal.setDisabled(false);
			txtDosis.setValue(entity.getDosis());
			txtDosis.setDisabled(false);
			txtValorUnit.setValue(entity.getValorUnit());
			txtValorUnit.setDisabled(false);
			txtDatAplicProdId_DatAplicProducto.setValue(entity.getDatAplicProducto().getDatAplicProdId());
			txtDatAplicProdId_DatAplicProducto.setDisabled(false);
			txtProductoId_Producto.setValue(entity.getProducto());
			txtProductoId_Producto.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatProdDetId.setValue(entity.getDatProdDetId());
			txtDatProdDetId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatAplicProdDet = (DatAplicProdDetDTO) (evt.getComponent().getAttributes()
				.get("selectedDatAplicProdDet"));
		txtCantidadAplicada.setValue(selectedDatAplicProdDet.getCantidadAplicada());
		txtCantidadAplicada.setDisabled(false);
		txtCompania.setValue(selectedDatAplicProdDet.getCompania());
		txtCompania.setDisabled(false);
		txtCostoTotal.setValue(selectedDatAplicProdDet.getCostoTotal());
		txtCostoTotal.setDisabled(false);
		txtDosis.setValue(selectedDatAplicProdDet.getDosis());
		txtDosis.setDisabled(false);
		txtValorUnit.setValue(selectedDatAplicProdDet.getValorUnit());
		txtValorUnit.setDisabled(false);
		txtDatAplicProdId_DatAplicProducto.setValue(selectedDatAplicProdDet.getDatAplicProdId_DatAplicProducto());
		txtDatAplicProdId_DatAplicProducto.setDisabled(false);
		txtProductoId_Producto.setValue(selectedDatAplicProdDet.getProductoId_Producto());
		txtProductoId_Producto.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedDatAplicProdDet.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtDatProdDetId.setValue(selectedDatAplicProdDet.getDatProdDetId());
		txtDatProdDetId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatAplicProdDet == null) && (entity == null)) {
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
			entity = new DatAplicProdDet();

			Long datProdDetId = FacesUtils.checkLong(txtDatProdDetId);
			entity.setCantidadAplicada(FacesUtils.checkDouble(txtCantidadAplicada));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			entity.setDatProdDetId(datProdDetId);
			entity.setDosis(FacesUtils.checkDouble(txtDosis));
			entity.setValorUnit(FacesUtils.checkDouble(txtValorUnit));
			entity.setDatAplicProducto(
					(FacesUtils.checkLong(txtDatAplicProdId_DatAplicProducto) != null) ? businessDelegatorView
							.getDatAplicProducto(FacesUtils.checkLong(txtDatAplicProdId_DatAplicProducto)) : null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			businessDelegatorView.saveDatAplicProdDet(entity);
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
				Long datProdDetId = new Long(selectedDatAplicProdDet.getDatProdDetId());
				entity = businessDelegatorView.getDatAplicProdDet(datProdDetId);
			}
			entity.setCantidadAplicada(FacesUtils.checkDouble(txtCantidadAplicada));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			entity.setDosis(FacesUtils.checkDouble(txtDosis));
			entity.setValorUnit(FacesUtils.checkDouble(txtValorUnit));
			entity.setDatAplicProducto(
					(FacesUtils.checkLong(txtDatAplicProdId_DatAplicProducto) != null) ? businessDelegatorView
							.getDatAplicProducto(FacesUtils.checkLong(txtDatAplicProdId_DatAplicProducto)) : null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			businessDelegatorView.updateDatAplicProdDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatAplicProdDet = (DatAplicProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAplicProdDet"));

			Long datProdDetId = new Long(selectedDatAplicProdDet.getDatProdDetId());
			entity = businessDelegatorView.getDatAplicProdDet(datProdDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datProdDetId = FacesUtils.checkLong(txtDatProdDetId);
			entity = businessDelegatorView.getDatAplicProdDet(datProdDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatAplicProdDet(entity);
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
			selectedDatAplicProdDet = (DatAplicProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAplicProdDet"));

			Long datProdDetId = new Long(selectedDatAplicProdDet.getDatProdDetId());
			entity = businessDelegatorView.getDatAplicProdDet(datProdDetId);
			businessDelegatorView.deleteDatAplicProdDet(entity);
			data.remove(selectedDatAplicProdDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double areaAplicada, Double cantidadAplicada, Long compania, Double costoTotal,
			Long datProdDetId, Double dosis, Double valorUnit, Long datAplicProdId_DatAplicProducto,
			Long productoId_Producto, Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setCantidadAplicada(FacesUtils.checkDouble(cantidadAplicada));
			entity.setCostoTotal(FacesUtils.checkDouble(costoTotal));
			entity.setDosis(FacesUtils.checkDouble(dosis));
			entity.setValorUnit(FacesUtils.checkDouble(valorUnit));
			businessDelegatorView.updateDatAplicProdDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatAplicProdDetView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidadAplicada() {
		return txtCantidadAplicada;
	}

	public void setTxtCantidadAplicada(InputText txtCantidadAplicada) {
		this.txtCantidadAplicada = txtCantidadAplicada;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputText txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public InputText getTxtDosis() {
		return txtDosis;
	}

	public void setTxtDosis(InputText txtDosis) {
		this.txtDosis = txtDosis;
	}

	public InputText getTxtValorUnit() {
		return txtValorUnit;
	}

	public void setTxtValorUnit(InputText txtValorUnit) {
		this.txtValorUnit = txtValorUnit;
	}

	public InputText getTxtDatAplicProdId_DatAplicProducto() {
		return txtDatAplicProdId_DatAplicProducto;
	}

	public void setTxtDatAplicProdId_DatAplicProducto(InputText txtDatAplicProdId_DatAplicProducto) {
		this.txtDatAplicProdId_DatAplicProducto = txtDatAplicProdId_DatAplicProducto;
	}

	public InputText getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(InputText txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public InputText getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(InputText txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public InputText getTxtDatProdDetId() {
		return txtDatProdDetId;
	}

	public void setTxtDatProdDetId(InputText txtDatProdDetId) {
		this.txtDatProdDetId = txtDatProdDetId;
	}

	public List<DatAplicProdDetDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatAplicProdDet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatAplicProdDetDTO> datAplicProdDetDTO) {
		this.data = datAplicProdDetDTO;
	}

	public DatAplicProdDetDTO getSelectedDatAplicProdDet() {
		return selectedDatAplicProdDet;
	}

	public void setSelectedDatAplicProdDet(DatAplicProdDetDTO datAplicProdDet) {
		this.selectedDatAplicProdDet = datAplicProdDet;
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
