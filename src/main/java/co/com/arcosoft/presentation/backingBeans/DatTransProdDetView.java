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
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatTransProdDetView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdDetView.class);
	private InputText txtAreaCosechada;
	private InputText txtCantidadReal;
	private InputText txtCantidadSolicitada;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtDocumetoErp;
	private InputText txtValorTotal;
	private InputText txtValorUnitario;
	private InputText txtCiudadId_Ciudad;
	private InputText txtClienteId_Cliente;
	private InputText txtDatTransProdId_DatTransProd;
	private InputText txtEmpaqueId_Empaque;
	private InputText txtProductoId_Producto;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtDatTransProdDetId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatTransProdDetDTO> data;
	private DatTransProdDetDTO selectedDatTransProdDet;
	private DatTransProdDet entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatTransProdDetView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatTransProdDetDTO datTransProdDetDTO = (DatTransProdDetDTO) e.getObject();

			if (txtAreaCosechada == null) {
				txtAreaCosechada = new InputText();
			}

			txtAreaCosechada.setValue(datTransProdDetDTO.getAreaCosechada());

			if (txtCantidadReal == null) {
				txtCantidadReal = new InputText();
			}

			txtCantidadReal.setValue(datTransProdDetDTO.getCantidadReal());

			if (txtCantidadSolicitada == null) {
				txtCantidadSolicitada = new InputText();
			}

			txtCantidadSolicitada.setValue(datTransProdDetDTO.getCantidadSolicitada());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datTransProdDetDTO.getCompania());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datTransProdDetDTO.getConsecutivo());

			if (txtDocumetoErp == null) {
				txtDocumetoErp = new InputText();
			}

			txtDocumetoErp.setValue(datTransProdDetDTO.getDocumetoErp());

			if (txtValorTotal == null) {
				txtValorTotal = new InputText();
			}

			txtValorTotal.setValue(datTransProdDetDTO.getValorTotal());

			if (txtValorUnitario == null) {
				txtValorUnitario = new InputText();
			}

			txtValorUnitario.setValue(datTransProdDetDTO.getValorUnitario());

			if (txtCiudadId_Ciudad == null) {
				txtCiudadId_Ciudad = new InputText();
			}

			txtCiudadId_Ciudad.setValue(datTransProdDetDTO.getCiudadId_Ciudad());

			if (txtClienteId_Cliente == null) {
				txtClienteId_Cliente = new InputText();
			}

			txtClienteId_Cliente.setValue(datTransProdDetDTO.getClienteId_Cliente());

			if (txtDatTransProdId_DatTransProd == null) {
				txtDatTransProdId_DatTransProd = new InputText();
			}

			txtDatTransProdId_DatTransProd.setValue(datTransProdDetDTO.getDatTransProdId_DatTransProd());

			if (txtEmpaqueId_Empaque == null) {
				txtEmpaqueId_Empaque = new InputText();
			}

			txtEmpaqueId_Empaque.setValue(datTransProdDetDTO.getEmpaqueId_Empaque());

			if (txtProductoId_Producto == null) {
				txtProductoId_Producto = new InputText();
			}

			txtProductoId_Producto.setValue(datTransProdDetDTO.getProductoId_Producto());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(datTransProdDetDTO.getUdadMedId_UdadMed());

			if (txtDatTransProdDetId == null) {
				txtDatTransProdDetId = new InputText();
			}

			txtDatTransProdDetId.setValue(datTransProdDetDTO.getDatTransProdDetId());

			Long datTransProdDetId = FacesUtils.checkLong(txtDatTransProdDetId);
			entity = businessDelegatorView.getDatTransProdDet(datTransProdDetId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatTransProdDet = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatTransProdDet = null;

		if (txtAreaCosechada != null) {
			txtAreaCosechada.setValue(null);
			txtAreaCosechada.setDisabled(true);
		}

		if (txtCantidadReal != null) {
			txtCantidadReal.setValue(null);
			txtCantidadReal.setDisabled(true);
		}

		if (txtCantidadSolicitada != null) {
			txtCantidadSolicitada.setValue(null);
			txtCantidadSolicitada.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtDocumetoErp != null) {
			txtDocumetoErp.setValue(null);
			txtDocumetoErp.setDisabled(true);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(true);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(true);
		}

		if (txtCiudadId_Ciudad != null) {
			txtCiudadId_Ciudad.setValue(null);
			txtCiudadId_Ciudad.setDisabled(true);
		}

		if (txtClienteId_Cliente != null) {
			txtClienteId_Cliente.setValue(null);
			txtClienteId_Cliente.setDisabled(true);
		}

		if (txtDatTransProdId_DatTransProd != null) {
			txtDatTransProdId_DatTransProd.setValue(null);
			txtDatTransProdId_DatTransProd.setDisabled(true);
		}

		if (txtEmpaqueId_Empaque != null) {
			txtEmpaqueId_Empaque.setValue(null);
			txtEmpaqueId_Empaque.setDisabled(true);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtDatTransProdDetId != null) {
			txtDatTransProdDetId.setValue(null);
			txtDatTransProdDetId.setDisabled(false);
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
			Long datTransProdDetId = FacesUtils.checkLong(txtDatTransProdDetId);
			entity = (datTransProdDetId != null) ? businessDelegatorView.getDatTransProdDet(datTransProdDetId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtAreaCosechada.setDisabled(false);
			txtCantidadReal.setDisabled(false);
			txtCantidadSolicitada.setDisabled(false);
			txtCompania.setDisabled(false);
			txtConsecutivo.setDisabled(false);
			txtDocumetoErp.setDisabled(false);
			txtValorTotal.setDisabled(false);
			txtValorUnitario.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtClienteId_Cliente.setDisabled(false);
			txtDatTransProdId_DatTransProd.setDisabled(false);
			txtEmpaqueId_Empaque.setDisabled(false);
			txtProductoId_Producto.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatTransProdDetId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAreaCosechada.setValue(entity.getAreaCosechada());
			txtAreaCosechada.setDisabled(false);
			txtCantidadReal.setValue(entity.getCantidadReal());
			txtCantidadReal.setDisabled(false);
			txtCantidadSolicitada.setValue(entity.getCantidadSolicitada());
			txtCantidadSolicitada.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtConsecutivo.setValue(entity.getConsecutivo());
			txtConsecutivo.setDisabled(false);
			txtDocumetoErp.setValue(entity.getDocumetoErp());
			txtDocumetoErp.setDisabled(false);
			txtValorTotal.setValue(entity.getValorTotal());
			txtValorTotal.setDisabled(false);
			txtValorUnitario.setValue(entity.getValorUnitario());
			txtValorUnitario.setDisabled(false);
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtClienteId_Cliente.setValue(entity.getCliente());
			txtClienteId_Cliente.setDisabled(false);
			txtDatTransProdId_DatTransProd.setValue(entity.getDatTransProd().getDatTransProdId());
			txtDatTransProdId_DatTransProd.setDisabled(false);
			txtEmpaqueId_Empaque.setValue(entity.getEmpaque());
			txtEmpaqueId_Empaque.setDisabled(false);
			txtProductoId_Producto.setValue(entity.getProducto());
			txtProductoId_Producto.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatTransProdDetId.setValue(entity.getDatTransProdDetId());
			txtDatTransProdDetId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatTransProdDet = (DatTransProdDetDTO) (evt.getComponent().getAttributes()
				.get("selectedDatTransProdDet"));
		txtAreaCosechada.setValue(selectedDatTransProdDet.getAreaCosechada());
		txtAreaCosechada.setDisabled(false);
		txtCantidadReal.setValue(selectedDatTransProdDet.getCantidadReal());
		txtCantidadReal.setDisabled(false);
		txtCantidadSolicitada.setValue(selectedDatTransProdDet.getCantidadSolicitada());
		txtCantidadSolicitada.setDisabled(false);
		txtCompania.setValue(selectedDatTransProdDet.getCompania());
		txtCompania.setDisabled(false);
		txtConsecutivo.setValue(selectedDatTransProdDet.getConsecutivo());
		txtConsecutivo.setDisabled(false);
		txtDocumetoErp.setValue(selectedDatTransProdDet.getDocumetoErp());
		txtDocumetoErp.setDisabled(false);
		txtValorTotal.setValue(selectedDatTransProdDet.getValorTotal());
		txtValorTotal.setDisabled(false);
		txtValorUnitario.setValue(selectedDatTransProdDet.getValorUnitario());
		txtValorUnitario.setDisabled(false);
		txtCiudadId_Ciudad.setValue(selectedDatTransProdDet.getCiudadId_Ciudad());
		txtCiudadId_Ciudad.setDisabled(false);
		txtClienteId_Cliente.setValue(selectedDatTransProdDet.getClienteId_Cliente());
		txtClienteId_Cliente.setDisabled(false);
		txtDatTransProdId_DatTransProd.setValue(selectedDatTransProdDet.getDatTransProdId_DatTransProd());
		txtDatTransProdId_DatTransProd.setDisabled(false);
		txtEmpaqueId_Empaque.setValue(selectedDatTransProdDet.getEmpaqueId_Empaque());
		txtEmpaqueId_Empaque.setDisabled(false);
		txtProductoId_Producto.setValue(selectedDatTransProdDet.getProductoId_Producto());
		txtProductoId_Producto.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedDatTransProdDet.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtDatTransProdDetId.setValue(selectedDatTransProdDet.getDatTransProdDetId());
		txtDatTransProdDetId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatTransProdDet == null) && (entity == null)) {
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
			entity = new DatTransProdDet();

			Long datTransProdDetId = FacesUtils.checkLong(txtDatTransProdDetId);

			entity.setAreaCosechada(FacesUtils.checkDouble(txtAreaCosechada));
			entity.setCantidadReal(FacesUtils.checkDouble(txtCantidadReal));
			entity.setCantidadSolicitada(FacesUtils.checkDouble(txtCantidadSolicitada));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDatTransProdDetId(datTransProdDetId);
			entity.setDocumetoErp(FacesUtils.checkString(txtDocumetoErp));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_Ciudad)) : null);
			entity.setCliente((FacesUtils.checkLong(txtClienteId_Cliente) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtClienteId_Cliente)) : null);

			entity.setDatTransProd((FacesUtils.checkLong(txtDatTransProdId_DatTransProd) != null)
					? businessDelegatorView.getDatTransProd(FacesUtils.checkLong(txtDatTransProdId_DatTransProd))
					: null);
			entity.setEmpaque((FacesUtils.checkLong(txtEmpaqueId_Empaque) != null)
					? businessDelegatorView.getEmpaque(FacesUtils.checkLong(txtEmpaqueId_Empaque)) : null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.saveDatTransProdDet(entity);
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
				Long datTransProdDetId = new Long(selectedDatTransProdDet.getDatTransProdDetId());
				entity = businessDelegatorView.getDatTransProdDet(datTransProdDetId);
			}

			entity.setAreaCosechada(FacesUtils.checkDouble(txtAreaCosechada));
			entity.setCantidadReal(FacesUtils.checkDouble(txtCantidadReal));
			entity.setCantidadSolicitada(FacesUtils.checkDouble(txtCantidadSolicitada));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDocumetoErp(FacesUtils.checkString(txtDocumetoErp));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_Ciudad)) : null);
			entity.setCliente((FacesUtils.checkLong(txtClienteId_Cliente) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtClienteId_Cliente)) : null);

			entity.setDatTransProd((FacesUtils.checkLong(txtDatTransProdId_DatTransProd) != null)
					? businessDelegatorView.getDatTransProd(FacesUtils.checkLong(txtDatTransProdId_DatTransProd))
					: null);
			entity.setEmpaque((FacesUtils.checkLong(txtEmpaqueId_Empaque) != null)
					? businessDelegatorView.getEmpaque(FacesUtils.checkLong(txtEmpaqueId_Empaque)) : null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			businessDelegatorView.updateDatTransProdDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatTransProdDet = (DatTransProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatTransProdDet"));

			Long datTransProdDetId = new Long(selectedDatTransProdDet.getDatTransProdDetId());
			entity = businessDelegatorView.getDatTransProdDet(datTransProdDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datTransProdDetId = FacesUtils.checkLong(txtDatTransProdDetId);
			entity = businessDelegatorView.getDatTransProdDet(datTransProdDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatTransProdDet(entity);
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
			selectedDatTransProdDet = (DatTransProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatTransProdDet"));

			Long datTransProdDetId = new Long(selectedDatTransProdDet.getDatTransProdDetId());
			entity = businessDelegatorView.getDatTransProdDet(datTransProdDetId);
			businessDelegatorView.deleteDatTransProdDet(entity);
			data.remove(selectedDatTransProdDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long areaCosechada, Long cantidadReal, Long cantidadSolicitada, Long compania,
			Long consecutivo, Long datTransProdDetId, String documetoErp, Long valorTotal, Long valorUnitario,
			Long ciudadId_Ciudad, Long clienteId_Cliente, Long datTransProdId_DatTransProd, Long empaqueId_Empaque,
			Long productoId_Producto, Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setAreaCosechada(FacesUtils.checkDouble(areaCosechada));
			entity.setCantidadReal(FacesUtils.checkDouble(cantidadReal));
			entity.setCantidadSolicitada(FacesUtils.checkDouble(cantidadSolicitada));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDocumetoErp(FacesUtils.checkString(documetoErp));
			entity.setValorTotal(FacesUtils.checkDouble(valorTotal));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updateDatTransProdDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatTransProdDetView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAreaCosechada() {
		return txtAreaCosechada;
	}

	public void setTxtAreaCosechada(InputText txtAreaCosechada) {
		this.txtAreaCosechada = txtAreaCosechada;
	}

	public InputText getTxtCantidadReal() {
		return txtCantidadReal;
	}

	public void setTxtCantidadReal(InputText txtCantidadReal) {
		this.txtCantidadReal = txtCantidadReal;
	}

	public InputText getTxtCantidadSolicitada() {
		return txtCantidadSolicitada;
	}

	public void setTxtCantidadSolicitada(InputText txtCantidadSolicitada) {
		this.txtCantidadSolicitada = txtCantidadSolicitada;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public InputText getTxtDocumetoErp() {
		return txtDocumetoErp;
	}

	public void setTxtDocumetoErp(InputText txtDocumetoErp) {
		this.txtDocumetoErp = txtDocumetoErp;
	}

	public InputText getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(InputText txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputText getTxtCiudadId_Ciudad() {
		return txtCiudadId_Ciudad;
	}

	public void setTxtCiudadId_Ciudad(InputText txtCiudadId_Ciudad) {
		this.txtCiudadId_Ciudad = txtCiudadId_Ciudad;
	}

	public InputText getTxtClienteId_Cliente() {
		return txtClienteId_Cliente;
	}

	public void setTxtClienteId_Cliente(InputText txtClienteId_Cliente) {
		this.txtClienteId_Cliente = txtClienteId_Cliente;
	}

	public InputText getTxtDatTransProdId_DatTransProd() {
		return txtDatTransProdId_DatTransProd;
	}

	public void setTxtDatTransProdId_DatTransProd(InputText txtDatTransProdId_DatTransProd) {
		this.txtDatTransProdId_DatTransProd = txtDatTransProdId_DatTransProd;
	}

	public InputText getTxtEmpaqueId_Empaque() {
		return txtEmpaqueId_Empaque;
	}

	public void setTxtEmpaqueId_Empaque(InputText txtEmpaqueId_Empaque) {
		this.txtEmpaqueId_Empaque = txtEmpaqueId_Empaque;
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

	public InputText getTxtDatTransProdDetId() {
		return txtDatTransProdDetId;
	}

	public void setTxtDatTransProdDetId(InputText txtDatTransProdDetId) {
		this.txtDatTransProdDetId = txtDatTransProdDetId;
	}

	public List<DatTransProdDetDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatTransProdDet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatTransProdDetDTO> datTransProdDetDTO) {
		this.data = datTransProdDetDTO;
	}

	public DatTransProdDetDTO getSelectedDatTransProdDet() {
		return selectedDatTransProdDet;
	}

	public void setSelectedDatTransProdDet(DatTransProdDetDTO datTransProdDet) {
		this.selectedDatTransProdDet = datTransProdDet;
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
