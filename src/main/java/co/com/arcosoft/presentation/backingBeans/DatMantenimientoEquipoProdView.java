package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatMantenimientoEquipoProdView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoProdView.class);
	private InputText txtAlmacenId;
	private InputText txtCantidad;
	private InputText txtCostoTotal;
	private InputText txtValorUnitario;
	private InputText txtDatMantenimientoEquipoId_DatMantenimientoEquipo;
	private InputText txtProductoId_Producto;
	private InputText txtTrabId_Trabajador;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtDatMantenimientoEquipoProdId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatMantenimientoEquipoProdDTO> data;
	private DatMantenimientoEquipoProdDTO selectedDatMantenimientoEquipoProd;
	private DatMantenimientoEquipoProd entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatMantenimientoEquipoProdView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO = (DatMantenimientoEquipoProdDTO) e.getObject();

			if (txtAlmacenId == null) {
				txtAlmacenId = new InputText();
			}

			txtAlmacenId.setValue(datMantenimientoEquipoProdDTO.getAlmacenId());

			if (txtCantidad == null) {
				txtCantidad = new InputText();
			}

			txtCantidad.setValue(datMantenimientoEquipoProdDTO.getCantidad());

			if (txtCostoTotal == null) {
				txtCostoTotal = new InputText();
			}

			txtCostoTotal.setValue(datMantenimientoEquipoProdDTO.getCostoTotal());

			if (txtValorUnitario == null) {
				txtValorUnitario = new InputText();
			}

			txtValorUnitario.setValue(datMantenimientoEquipoProdDTO.getValorUnitario());

			if (txtDatMantenimientoEquipoId_DatMantenimientoEquipo == null) {
				txtDatMantenimientoEquipoId_DatMantenimientoEquipo = new InputText();
			}

			txtDatMantenimientoEquipoId_DatMantenimientoEquipo
					.setValue(datMantenimientoEquipoProdDTO.getDatMantenimientoEquipoId_DatMantenimientoEquipo());

			if (txtProductoId_Producto == null) {
				txtProductoId_Producto = new InputText();
			}

			txtProductoId_Producto.setValue(datMantenimientoEquipoProdDTO.getProductoId_Producto());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new InputText();
			}

			txtTrabId_Trabajador.setValue(datMantenimientoEquipoProdDTO.getTrabId_Trabajador());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(datMantenimientoEquipoProdDTO.getUdadMedId_UdadMed());

			if (txtDatMantenimientoEquipoProdId == null) {
				txtDatMantenimientoEquipoProdId = new InputText();
			}

			txtDatMantenimientoEquipoProdId.setValue(datMantenimientoEquipoProdDTO.getDatMantenimientoEquipoProdId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datMantenimientoEquipoProdDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datMantenimientoEquipoProdDTO.getFechaModificacion());

			Long datMantenimientoEquipoProdId = FacesUtils.checkLong(txtDatMantenimientoEquipoProdId);
			entity = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatMantenimientoEquipoProd = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatMantenimientoEquipoProd = null;

		if (txtAlmacenId != null) {
			txtAlmacenId.setValue(null);
			txtAlmacenId.setDisabled(true);
		}

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(true);
		}

		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(null);
			txtCostoTotal.setDisabled(true);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(true);
		}

		if (txtDatMantenimientoEquipoId_DatMantenimientoEquipo != null) {
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setValue(null);
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(true);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtDatMantenimientoEquipoProdId != null) {
			txtDatMantenimientoEquipoProdId.setValue(null);
			txtDatMantenimientoEquipoProdId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long datMantenimientoEquipoProdId = FacesUtils.checkLong(txtDatMantenimientoEquipoProdId);
			entity = (datMantenimientoEquipoProdId != null)
					? businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtAlmacenId.setDisabled(false);
			txtCantidad.setDisabled(false);
			txtCostoTotal.setDisabled(false);
			txtValorUnitario.setDisabled(false);
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(false);
			txtProductoId_Producto.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtDatMantenimientoEquipoProdId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAlmacenId.setValue(entity.getAlmacenId());
			txtAlmacenId.setDisabled(false);
			txtCantidad.setValue(entity.getCantidad());
			txtCantidad.setDisabled(false);
			txtCostoTotal.setValue(entity.getCostoTotal());
			txtCostoTotal.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtValorUnitario.setValue(entity.getValorUnitario());
			txtValorUnitario.setDisabled(false);
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo
					.setValue(entity.getDatMantenimientoEquipo().getDatMantenimientoEquipoId());
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(false);
			txtProductoId_Producto.setValue(entity.getProducto().getProductoId());
			txtProductoId_Producto.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatMantenimientoEquipoProdId.setValue(entity.getDatMantenimientoEquipoProdId());
			txtDatMantenimientoEquipoProdId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatMantenimientoEquipoProd = (DatMantenimientoEquipoProdDTO) (evt.getComponent().getAttributes()
				.get("selectedDatMantenimientoEquipoProd"));
		txtAlmacenId.setValue(selectedDatMantenimientoEquipoProd.getAlmacenId());
		txtAlmacenId.setDisabled(false);
		txtCantidad.setValue(selectedDatMantenimientoEquipoProd.getCantidad());
		txtCantidad.setDisabled(false);
		txtCostoTotal.setValue(selectedDatMantenimientoEquipoProd.getCostoTotal());
		txtCostoTotal.setDisabled(false);
		txtFechaCreacion.setValue(selectedDatMantenimientoEquipoProd.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDatMantenimientoEquipoProd.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtValorUnitario.setValue(selectedDatMantenimientoEquipoProd.getValorUnitario());
		txtValorUnitario.setDisabled(false);
		txtDatMantenimientoEquipoId_DatMantenimientoEquipo
				.setValue(selectedDatMantenimientoEquipoProd.getDatMantenimientoEquipoId_DatMantenimientoEquipo());
		txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(false);
		txtProductoId_Producto.setValue(selectedDatMantenimientoEquipoProd.getProductoId_Producto());
		txtProductoId_Producto.setDisabled(false);
		txtTrabId_Trabajador.setValue(selectedDatMantenimientoEquipoProd.getTrabId_Trabajador());
		txtTrabId_Trabajador.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedDatMantenimientoEquipoProd.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtDatMantenimientoEquipoProdId.setValue(selectedDatMantenimientoEquipoProd.getDatMantenimientoEquipoProdId());
		txtDatMantenimientoEquipoProdId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatMantenimientoEquipoProd == null) && (entity == null)) {
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
			entity = new DatMantenimientoEquipoProd();

			Long datMantenimientoEquipoProdId = FacesUtils.checkLong(txtDatMantenimientoEquipoProdId);

			// entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId));
			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			entity.setDatMantenimientoEquipoProdId(datMantenimientoEquipoProdId);
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setDatMantenimientoEquipo(
					(FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo) != null)
							? businessDelegatorView.getDatMantenimientoEquipo(
									FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo))
							: null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.saveDatMantenimientoEquipoProd(entity);
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
				Long datMantenimientoEquipoProdId = new Long(
						selectedDatMantenimientoEquipoProd.getDatMantenimientoEquipoProdId());
				entity = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
			}

			// entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId));
			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setDatMantenimientoEquipo(
					(FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo) != null)
							? businessDelegatorView.getDatMantenimientoEquipo(
									FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo))
							: null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.updateDatMantenimientoEquipoProd(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatMantenimientoEquipoProd = (DatMantenimientoEquipoProdDTO) (evt.getComponent().getAttributes()
					.get("selectedDatMantenimientoEquipoProd"));

			Long datMantenimientoEquipoProdId = new Long(
					selectedDatMantenimientoEquipoProd.getDatMantenimientoEquipoProdId());
			entity = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datMantenimientoEquipoProdId = FacesUtils.checkLong(txtDatMantenimientoEquipoProdId);
			entity = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatMantenimientoEquipoProd(entity);
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
			selectedDatMantenimientoEquipoProd = (DatMantenimientoEquipoProdDTO) (evt.getComponent().getAttributes()
					.get("selectedDatMantenimientoEquipoProd"));

			Long datMantenimientoEquipoProdId = new Long(
					selectedDatMantenimientoEquipoProd.getDatMantenimientoEquipoProdId());
			entity = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
			businessDelegatorView.deleteDatMantenimientoEquipoProd(entity);
			data.remove(selectedDatMantenimientoEquipoProd);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long almacenId, Double cantidad, Double costoTotal,
			Long datMantenimientoEquipoProdId, Date fechaCreacion, Date fechaModificacion, Double valorUnitario,
			Long datMantenimientoEquipoId_DatMantenimientoEquipo, Long productoId_Producto, Long trabId_Trabajador,
			Long udadMedId_UdadMed) throws Exception {
		try {
			// entity.setAlmacenId(FacesUtils.checkLong(almacenId));
			entity.setCantidad(FacesUtils.checkDouble(cantidad));
			entity.setCostoTotal(FacesUtils.checkDouble(costoTotal));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updateDatMantenimientoEquipoProd(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatMantenimientoEquipoProdView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAlmacenId() {
		return txtAlmacenId;
	}

	public void setTxtAlmacenId(InputText txtAlmacenId) {
		this.txtAlmacenId = txtAlmacenId;
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public InputText getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputText txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputText getTxtDatMantenimientoEquipoId_DatMantenimientoEquipo() {
		return txtDatMantenimientoEquipoId_DatMantenimientoEquipo;
	}

	public void setTxtDatMantenimientoEquipoId_DatMantenimientoEquipo(
			InputText txtDatMantenimientoEquipoId_DatMantenimientoEquipo) {
		this.txtDatMantenimientoEquipoId_DatMantenimientoEquipo = txtDatMantenimientoEquipoId_DatMantenimientoEquipo;
	}

	public InputText getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(InputText txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public InputText getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(InputText txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public InputText getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(InputText txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtDatMantenimientoEquipoProdId() {
		return txtDatMantenimientoEquipoProdId;
	}

	public void setTxtDatMantenimientoEquipoProdId(InputText txtDatMantenimientoEquipoProdId) {
		this.txtDatMantenimientoEquipoProdId = txtDatMantenimientoEquipoProdId;
	}

	public List<DatMantenimientoEquipoProdDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatMantenimientoEquipoProd();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatMantenimientoEquipoProdDTO> datMantenimientoEquipoProdDTO) {
		this.data = datMantenimientoEquipoProdDTO;
	}

	public DatMantenimientoEquipoProdDTO getSelectedDatMantenimientoEquipoProd() {
		return selectedDatMantenimientoEquipoProd;
	}

	public void setSelectedDatMantenimientoEquipoProd(DatMantenimientoEquipoProdDTO datMantenimientoEquipoProd) {
		this.selectedDatMantenimientoEquipoProd = datMantenimientoEquipoProd;
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
