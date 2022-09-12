package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.ClaseToxicologica;
import co.com.arcosoft.modelo.DatProductosRelacionados;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.AnaLaboratorioVariableDTO;
import co.com.arcosoft.modelo.dto.DatProductosRelacionadosDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.dto.ProductoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProductoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ProductoView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEsGranel;
	private SelectOneRadio txtEstado;
	private SelectOneMenu txtFlujoMovimiento;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputTextarea txtObservacion;
	private InputText txtProductoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<ProductoDTO> data;
	private ProductoDTO selectedProducto;
	private Producto entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;

	private SelectOneMenu txtClaseToxicId_ClaseToxicologica;
	SelectItem[] selectClaseToxicologica;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;

	private SelectOneMenu txtTipoProdId_TipoProducto;
	SelectItem[] selectTipoProducto;

	private SelectOneMenu txtUdadMedId_UdadMed_Cosecha;
	SelectItem[] selectUdadMed_Cos;

	private SelectOneMenu txtUdadMedId_UdadMed_Prod;
	SelectItem[] selectUdadMed_Prod;

	private SelectOneMenu txtUbAlmacen;
	SelectItem[] selectUbAlmacen;

	/** Campos de pantalla de precios por producto **/

	private Calendar fechaVencimiento;

	private SelectOneMenu txtUnidadMedida;
	SelectItem[] selectUdadMed;

	private InputText cantidadCompra;
	private InputText loteCompraProducto;
	private InputText registroIca;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private SelectOneMenu txtAlmacenId_Almacen2;
	SelectItem[] selectAlmacen2;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private InputText txtCodAlmacen;
	private InputText txtCodUnidadMedida;

	private InputText txtCodPersEmpr;

	private SelectOneMenu txtPersEmpr;
	SelectItem[] selectContratista;

	private int activeTapIndex = 0;

	private List<PrecioPromProdDTO> dataDetPrecioProductos;
	private PrecioPromProdDTO selectedPrecioProductos;

	private PrecioPromProd entityPrecioProd;
	private Spinner txtSaldoMinimo;
	private Spinner txtSaldoMaximo;

	private InputText txtUbicacionAlmacen;

	/*** ***** DatProductosRelacionados ***** ***/

	private List<DatProductosRelacionadosDTO> dataProdRelacionado;
	private DatProductosRelacionadosDTO selectedProdRelacionado;
	private DatProductosRelacionados entityProdRelacionado;

	private SelectOneMenu txtProductoRel;
	SelectItem[] selectProductoRel;

	private SelectOneMenu txtUdadMedRel;
	SelectItem[] selectUdadMedRel;

	private InputNumber txtPorcentajeRel;

	private CommandButton btnAgregarRel;

	private InputText txtDosisRel;
	private InputNumber txtCantidadRel;
	
	private SelectOneMenu txtEsFormula;
	
	public ProductoView() {
		super();
	}

	public String action_new() {
		action_clear();
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedProducto = null;
		dataDetPrecioProductos = null;
		activeTapIndex = 0;
		PrimeFaces.current().resetInputs(":frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}
		if (txtCodAlmacen != null) {
			txtCodAlmacen.setValue(null);
			txtCodAlmacen.setDisabled(false);
		}
		if (txtEsFormula != null) {
			txtEsFormula.setValue(null);
			txtEsFormula.setDisabled(true);
		}

		if (txtUbAlmacen != null) {
			txtUbAlmacen.setValue(null);
			txtUbAlmacen.setDisabled(false);
		}

		if (txtSaldoMinimo != null) {
			txtSaldoMinimo.setValue(null);
			txtSaldoMinimo.setDisabled(true);
		}

		if (txtSaldoMaximo != null) {
			txtSaldoMaximo.setValue(null);
			txtSaldoMaximo.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEsGranel != null) {
			txtEsGranel.setValue("N");
			txtEsGranel.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFlujoMovimiento != null) {
			txtFlujoMovimiento.setValue("Recibidos");
			txtFlujoMovimiento.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtAlmacenId_Almacen != null) {
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(true);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(true);
		}

		if (txtClaseToxicId_ClaseToxicologica != null) {
			txtClaseToxicId_ClaseToxicologica.setValue(null);
			txtClaseToxicId_ClaseToxicologica.setDisabled(true);
		}

		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(true);
		}

		if (txtTipoProdId_TipoProducto != null) {
			txtTipoProdId_TipoProducto.setValue(null);
			txtTipoProdId_TipoProducto.setDisabled(false);
		}

		if (txtUdadMedId_UdadMed_Prod != null) {
			txtUdadMedId_UdadMed_Prod.setValue(null);
			txtUdadMedId_UdadMed_Prod.setDisabled(true);
		}

		if (dataDetPrecioProductos != null) {
			dataDetPrecioProductos = null;
		}

		if (txtValorUnit != null) {
			txtValorUnit.setValue(null);
			txtValorUnit.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtAlmacenId_Almacen2 != null) {
			txtAlmacenId_Almacen2.setValue(null);
			txtAlmacenId_Almacen2.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtProductoId != null) {
			txtProductoId.setValue(null);
			txtProductoId.setDisabled(false);
		}

		if (fechaVencimiento != null) {
			fechaVencimiento.setValue(null);
			fechaVencimiento.setDisabled(true);
		}

		if (txtUnidadMedida != null) {
			txtUnidadMedida.setValue(null);
			txtUnidadMedida.setDisabled(true);
		}

		if (cantidadCompra != null) {
			cantidadCompra.setValue(null);
			cantidadCompra.setDisabled(true);
		}

		if (loteCompraProducto != null) {
			loteCompraProducto.setValue(null);
			loteCompraProducto.setDisabled(true);
		}

		if (registroIca != null) {
			registroIca.setValue(null);
			registroIca.setDisabled(true);
		}

		if (txtCodPersEmpr != null) {
			txtCodPersEmpr.setValue(null);
			txtCodPersEmpr.setDisabled(true);
		}

		if (txtPersEmpr != null) {
			txtPersEmpr.setValue(null);
			txtPersEmpr.setDisabled(true);
		}

		if (txtUbicacionAlmacen != null) {
			txtUbicacionAlmacen.setValue(null);
			txtUbicacionAlmacen.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		/*** ***** DatProductosRelacionados ***** ***/

		if (dataProdRelacionado != null) {
			dataProdRelacionado = null;
		}

		if (txtProductoRel != null) {
			txtProductoRel.setValue(null);
			txtProductoRel.setDisabled(true);
		}

		if (txtUdadMedRel != null) {
			txtUdadMedRel.setValue(null);
			txtUdadMedRel.setDisabled(true);
		}

		if (txtPorcentajeRel != null) {
			txtPorcentajeRel.setValue(null);
			txtPorcentajeRel.setDisabled(true);
		}
		
		if (txtDosisRel != null) {
			txtDosisRel.setValue(null);
			txtDosisRel.setDisabled(true);
		}
		
		if (txtCantidadRel != null) {
			txtCantidadRel.setValue(null);
			txtCantidadRel.setDisabled(true);
		}

		if (btnAgregarRel != null) {
			btnAgregarRel.setDisabled(false);
		}

		/*** ***** DatProductosRelacionados ***** ***/

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public List<PrecioPromProdDTO> getDataDetPrecioProductos() {

		if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
			return null;
		} else {
			return dataDetPrecioProductos;
		}

	}

	public void action_agregarPrecioProductos() throws Exception {

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtPersEmpr.getValue() != null && txtFechaInicial.getValue() != null
				&& txtValorUnit.getValue() != null && cantidadCompra.getValue() != null) {
			Date date = new Date();
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);

			Long persEmprId = Long.parseLong(txtPersEmpr.getValue().toString());
			PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);

			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();
			String codPersEmpr = persEmpr.getCodigo();

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			// String fechaInicialFormat = dmyFormat.format(fechaInicial);
			Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
			Date fecha_Vencimiento = (FacesUtils.checkDate(fechaVencimiento));
			// String fechaVencimientoFormat =
			// dmyFormat.format(fecha_Vencimiento);
			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
			String loteCompra = FacesUtils.checkString(loteCompraProducto);
			String registro_ica = FacesUtils.checkString(registroIca);

			Long compania = new Long(getCompaniaIdSession());

			if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
				dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
			}

			PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
			precioPromProdDTO.setFechaInicial(fechaInicial);
			precioPromProdDTO.setFechaVencimiento(fecha_Vencimiento);
			precioPromProdDTO.setCantidadCompra(cantidad_Compra);
			precioPromProdDTO.setUnidadMedida(udadMed);
			precioPromProdDTO.setLoteCompraProducto(loteCompra);
			precioPromProdDTO.setRegistroIca(registro_ica);
			precioPromProdDTO.setAlmacenId(almacen);
			precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
			precioPromProdDTO.setCodAlmacen(codAlmacen);
			precioPromProdDTO.setValorUnitario(valorUnit);
			precioPromProdDTO.setCompania(compania);
			precioPromProdDTO.setFechaCreacion(date);
			precioPromProdDTO.setFechaModificacion(date);
			precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
			precioPromProdDTO.setCodPersEmpr(codPersEmpr);

			dataDetPrecioProductos.add(precioPromProdDTO);

			fechaInicial = null;
			// fecha_Vencimiento = null;
			almacen = null;
			valorUnit = null;
			codAlmacen = null;
			almacenId = null;
			date = null;
			compania = null;
			cantidad_Compra = null;
			unidadMedida = null;
			loteCompra = null;
			registro_ica = null;
			persEmpr = null;
			codPersEmpr = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha, labor, producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
	}

	public void listener_ConsultaCodPersEmpr() {

		Long persEmprId = null;

		if (!txtPersEmpr.getValue().equals("")) {
			persEmprId = Long.parseLong(txtPersEmpr.getValue().toString());

			try {
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				txtCodPersEmpr.setValue(persEmpr.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodAlmacen() {

		Long almacenId = null;

		if (!txtAlmacenId_Almacen2.getValue().equals("")) {
			almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());

			try {
				Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
				txtCodAlmacen.setValue(almacen.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_consultaCodUnidadMedida() {

		Long unidadMedidaId = null;

		if (!txtUnidadMedida.getValue().equals("")) {
			unidadMedidaId = Long.parseLong(txtUnidadMedida.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedidaId);
				txtCodUnidadMedida.setValue(udadMed.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_txtCodigo() throws Exception {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Producto> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInProducto(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEsGranel.setDisabled(false);
			txtEstado.setDisabled(false);
			txtFlujoMovimiento.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtAlmacenId_Almacen.setDisabled(false);
			txtCentCostId_CentCost.setDisabled(false);
			txtClaseToxicId_ClaseToxicologica.setDisabled(false);
			txtElemCostoId_ElementoCosto.setDisabled(false);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtUbAlmacen.setDisabled(false);
			txtProductoId.setDisabled(false);
			/*** campos de precio promedio ***/

			txtSaldoMinimo.setDisabled(false);
			txtSaldoMaximo.setDisabled(false);

			/*** ***** DatProductosRelacionados ***** ***/

			dataProdRelacionado = null;

			txtProductoRel.setDisabled(false);
			txtUdadMedRel.setDisabled(false);
			txtDosisRel.setDisabled(false);
			btnAgregarRel.setDisabled(false);

			if (txtEsFormula != null) {
				txtEsFormula.setValue(null);
				txtEsFormula.setDisabled(false);
			}
			
			
			/*** ***** DatProductosRelacionados ***** ***/

			btnSave.setDisabled(false);

		} else {

			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtEsGranel.setValue(entity.getEsGranel());
			txtEsGranel.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFlujoMovimiento.setValue(entity.getFlujoMovimiento());
			txtFlujoMovimiento.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtCentCostId_CentCost.setValue(entity.getCentCost());
			txtCentCostId_CentCost.setDisabled(false);
			txtClaseToxicId_ClaseToxicologica.setValue(entity.getClaseToxicologica());
			txtClaseToxicId_ClaseToxicologica.setDisabled(false);
			txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
			txtElemCostoId_ElementoCosto.setDisabled(false);
			txtTipoProdId_TipoProducto.setValue(entity.getTipoProducto().getTipoProdId());
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setValue(entity.getUdadMedByUdadMedProd().getUdadMedId());
			txtUdadMedId_UdadMed_Prod.setDisabled(false);

			txtProductoId.setValue(entity.getProductoId());
			txtProductoId.setDisabled(true);

			if (entity.getUbicacionesAlmacenId() != null) {
				txtUbAlmacen.setValue(entity.getUbicacionesAlmacenId().getUbicacionesAlmacenId());
			}
			txtUbAlmacen.setDisabled(false);

			if (entity.getAlmacen() != null) {
				txtAlmacenId_Almacen.setValue(entity.getAlmacen().getAlmacenId());
			}
			txtAlmacenId_Almacen.setDisabled(false);

			/*** sesion precio promedio ***/

			txtSaldoMinimo.setValue(entity.getSaldoMinimo());
			txtSaldoMinimo.setDisabled(false);
			txtSaldoMaximo.setValue(entity.getSaldoMaximo());
			txtSaldoMaximo.setDisabled(false);

			/*** ***** DatProductosRelacionados ***** ***/

			txtProductoRel.setDisabled(false);
			txtUdadMedRel.setDisabled(false);
			txtDosisRel.setDisabled(false);
			btnAgregarRel.setDisabled(false);
			
			txtEsFormula.setValue(null);
			txtEsFormula.setValue(entity.getEsFormula());
			txtEsFormula.setDisabled(false);
			
			

			dataProdRelacionado = null;
			dataProdRelacionado = businessDelegator2View
					.getDataDatProductosRelacionadosByProducto(entity.getProductoId());

			/*** ***** DatProductosRelacionados ***** ***/

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes().get("selectedProducto"));
		PrimeFaces.current().resetInputs(":frm");

		try {

			Long  productoId = selectedProducto.getProductoId();
			Object[] condicion = { "productoId", true, productoId, "=" };
			List<Producto> lista = (productoId != null)
					? businessDelegatorView.findByCriteriaInProducto(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEsGranel.setValue(entity.getEsGranel());
				txtEsGranel.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtFlujoMovimiento.setValue(entity.getFlujoMovimiento());
				txtFlujoMovimiento.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);

				txtCentCostId_CentCost.setValue(entity.getCentCost());
				txtCentCostId_CentCost.setDisabled(false);
				txtClaseToxicId_ClaseToxicologica.setValue(entity.getClaseToxicologica());
				txtClaseToxicId_ClaseToxicologica.setDisabled(false);
				txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
				txtElemCostoId_ElementoCosto.setDisabled(false);
				txtTipoProdId_TipoProducto.setValue(entity.getTipoProducto().getTipoProdId());
				txtTipoProdId_TipoProducto.setDisabled(false);
				txtUdadMedId_UdadMed_Prod.setValue(entity.getUdadMedByUdadMedProd().getUdadMedId());
				txtUdadMedId_UdadMed_Prod.setDisabled(false);

				if (entity.getUbicacionesAlmacenId() != null) {
					txtUbAlmacen.setValue(entity.getUbicacionesAlmacenId().getUbicacionesAlmacenId());
				}
				txtUbAlmacen.setDisabled(false);

				if (entity.getAlmacen() != null) {
					txtAlmacenId_Almacen.setValue(entity.getAlmacen().getAlmacenId());
				}
				txtAlmacenId_Almacen.setDisabled(false);

				txtProductoId.setValue(entity.getProductoId());
				txtProductoId.setDisabled(true);

				txtSaldoMinimo.setValue(entity.getSaldoMinimo());
				txtSaldoMinimo.setDisabled(false);
				txtSaldoMaximo.setValue(entity.getSaldoMaximo());
				txtSaldoMaximo.setDisabled(false);

				/*** ***** DatProductosRelacionados ***** ***/

				txtProductoRel.setDisabled(false);
				txtUdadMedRel.setDisabled(false);
				txtDosisRel.setDisabled(false);
				btnAgregarRel.setDisabled(false);
			
				txtEsFormula.setValue(null);
				txtEsFormula.setValue(entity.getEsFormula());
				txtEsFormula.setDisabled(false);
				
				dataProdRelacionado = null;
				dataProdRelacionado = businessDelegator2View
						.getDataDatProductosRelacionadosByProducto(entity.getProductoId());

				/*** ***** DatProductosRelacionados ***** ***/

				btnSave.setDisabled(false);
				activeTapIndex = 0;
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedProducto == null) && (entity == null)) {
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

	public String getLoginSession() throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;

		if (auth != null) {

			login = auth.getName();

		} else {

			throw new Exception("No user logged in ");

		}

		return login;
	}

	public String getCompaniaIdSession() throws Exception {

		String compania = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				compania = usuarios.getCompania().getCompaniaId().toString();
			}
		}

		return compania;
	}

	public String getUsuarioIdSession() throws Exception {

		String usuarioId = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				usuarioId = usuarios.getUsuarioId().toString();
			}
		}

		return usuarioId;
	}

	public String action_create() {
		try {

			
				entity = new Producto();

				Long compania = new Long(getCompaniaIdSession());
				Date date = new Date();
				entity.setCodigo(FacesUtils.checkString(txtCodigo));
				entity.setCompania(compania);
				entity.setEsGranel(FacesUtils.checkString(txtEsGranel));
				entity.setEstado(FacesUtils.checkString(txtEstado));
				entity.setFechaCreacion(date);
				entity.setSaldoMinimo(FacesUtils.checkDouble(txtSaldoMinimo));
				entity.setSaldoMaximo(FacesUtils.checkDouble(txtSaldoMaximo));
				entity.setFlujoMovimiento(FacesUtils.checkString(txtFlujoMovimiento));
				entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
				entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
				entity.setNombre(FacesUtils.checkString(txtNombre));
				entity.setObservacion(FacesUtils.checkString(txtObservacion));
				entity.setUsuarioDigitacion(Long.parseLong(getUsuarioIdSession()));

				entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null)
						? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen))
						: null);

				entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost)));
				entity.setClaseToxicologica((FacesUtils.checkLong(txtClaseToxicId_ClaseToxicologica)));
				entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));

				entity.setTipoProducto((FacesUtils.checkLong(txtTipoProdId_TipoProducto) != null)
						? businessDelegatorView.getTipoProducto(FacesUtils.checkLong(txtTipoProdId_TipoProducto))
						: null);

				entity.setUdadMedByUdadMedCosecha((FacesUtils.checkLong(txtUdadMedId_UdadMed_Cosecha)));

				entity.setUdadMedByUdadMedProd((FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod) != null)
						? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod))
						: null);

				entity.setUbicacionesAlmacenId((FacesUtils.checkLong(txtUbAlmacen) != null)
						? businessDelegator2View.getUbicacionesAlmacen(FacesUtils.checkLong(txtUbAlmacen))
						: null);

				entity.setEsFormula(FacesUtils.checkString(txtEsFormula));
				
				businessDelegatorView.saveProducto(entity, null, dataProdRelacionado);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
				action_clear();

			
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create_mini() {
		try {
			entity = new Producto();

			Long compania = Long.parseLong(getCompaniaIdSession());
			Date date = new Date();

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado("A");
			entity.setFechaCreacion(date);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setSaldoMaximo(0.0);
			entity.setSaldoMinimo(0.0);
			entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen))
					: null);
			entity.setTipoProducto((FacesUtils.checkLong(txtTipoProdId_TipoProducto) != null)
					? businessDelegatorView.getTipoProducto(FacesUtils.checkLong(txtTipoProdId_TipoProducto))
					: null);
			entity.setUdadMedByUdadMedProd((FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod))
					: null);

			
			  UbicacionesAlmacen ubicacionesAlmacen = null;
			  
			if (txtUbicacionAlmacen.getValue() != null && !txtUbicacionAlmacen.getValue().equals("")) {
				String nombre = FacesUtils.checkString(txtUbicacionAlmacen);

				Object[] condicion = { "codigo", true, nombre, "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion,
						null, null);

				if (lista != null && lista.size() > 0) {
					ubicacionesAlmacen = lista.get(0);

				} else {
					ubicacionesAlmacen = new UbicacionesAlmacen();

					ubicacionesAlmacen.setCodigo(nombre);
					ubicacionesAlmacen.setCompania(Long.parseLong(getCompaniaIdSession()));
					ubicacionesAlmacen.setEstado("A");
					ubicacionesAlmacen.setFechaCreacion(date);
					ubicacionesAlmacen.setNombre(nombre);
					businessDelegator2View.saveUbicacionesAlmacen(ubicacionesAlmacen);
					
					Object[] condicion2 = { "codigo", true, nombre, "=" };
					List<UbicacionesAlmacen> lista2 = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion2,
							null, null);

					if (lista2 != null && lista2.size() > 0) {
						ubicacionesAlmacen = lista2.get(0);
					}
				}
			}
			if(ubicacionesAlmacen!=null) {
			entity.setUbicacionesAlmacenId(ubicacionesAlmacen);
			}

			businessDelegatorView.saveProducto(entity, null, null);
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
				Long productoId = new Long(selectedProducto.getProductoId());
				entity = businessDelegatorView.getProducto(productoId);
			}

		
				Date date = new Date();
				Long compania = new Long(getCompaniaIdSession());
				entity.setCodigo(FacesUtils.checkString(txtCodigo));
				entity.setCompania(compania);
				entity.setEsGranel(FacesUtils.checkString(txtEsGranel));
				entity.setEstado(FacesUtils.checkString(txtEstado));
				entity.setSaldoMinimo(FacesUtils.checkDouble(txtSaldoMinimo));
				entity.setSaldoMaximo(FacesUtils.checkDouble(txtSaldoMaximo));
				entity.setFechaModificacion(date);
				entity.setFlujoMovimiento(FacesUtils.checkString(txtFlujoMovimiento));
				entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
				entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
				entity.setNombre(FacesUtils.checkString(txtNombre));
				entity.setObservacion(FacesUtils.checkString(txtObservacion));

				entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null)
						? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen))
						: null);

				entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost)));
				entity.setClaseToxicologica((FacesUtils.checkLong(txtClaseToxicId_ClaseToxicologica)));
				entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
				entity.setUsuarioDigitacion(Long.parseLong(getUsuarioIdSession()));

				entity.setTipoProducto((FacesUtils.checkLong(txtTipoProdId_TipoProducto) != null)
						? businessDelegatorView.getTipoProducto(FacesUtils.checkLong(txtTipoProdId_TipoProducto))
						: null);

				entity.setUdadMedByUdadMedCosecha((FacesUtils.checkLong(txtUdadMedId_UdadMed_Cosecha)));

				entity.setUdadMedByUdadMedProd((FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod) != null)
						? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod))
						: null);

				entity.setUbicacionesAlmacenId((FacesUtils.checkLong(txtUbAlmacen) != null)
						? businessDelegator2View.getUbicacionesAlmacen(FacesUtils.checkLong(txtUbAlmacen))
						: null);
				entity.setEsFormula(FacesUtils.checkString(txtEsFormula));
				businessDelegatorView.updateProducto(entity, null, dataProdRelacionado);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				action_clear();

			
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes().get("selectedProducto"));

			Long productoId = new Long(selectedProducto.getProductoId());
			entity = businessDelegatorView.getProducto(productoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long productoId = FacesUtils.checkLong(txtProductoId);
			entity = businessDelegatorView.getProducto(productoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteProducto(entity);
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

	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes().get("selectedProducto"));

			Long productoId = new Long(selectedProducto.getProductoId());
			entity = businessDelegatorView.getProducto(productoId);
			businessDelegatorView.deleteProducto(entity);
			((Map<String, Object>) data).remove(selectedProducto);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String esGranel, String estado, Date fechaCreacion,
			Date fechaModificacion, String flujoMovimiento, String infoAdicional, String infoAdicional2, String nombre,
			String observacion, Long productoId, Long almacenId_Almacen, Long centCostId_CentCost,
			Long claseToxicId_ClaseToxicologica, Long elemCostoId_ElementoCosto, Long tipoProdId_TipoProducto,
			Long udadMedId_UdadMed, Long udadMedId_UdadMed0) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEsGranel(FacesUtils.checkString(esGranel));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFlujoMovimiento(FacesUtils.checkString(flujoMovimiento));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setObservacion(FacesUtils.checkString(observacion));
			businessDelegatorView.updateProducto(entity, dataDetPrecioProductos, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ProductoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectOneRadio getTxtEsGranel() {
		return txtEsGranel;
	}

	public void setTxtEsGranel(SelectOneRadio txtEsGranel) {
		this.txtEsGranel = txtEsGranel;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneMenu getTxtFlujoMovimiento() {
		return txtFlujoMovimiento;
	}

	public void setTxtFlujoMovimiento(SelectOneMenu txtFlujoMovimiento) {
		this.txtFlujoMovimiento = txtFlujoMovimiento;
	}

	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtClaseToxicId_ClaseToxicologica() {
		return txtClaseToxicId_ClaseToxicologica;
	}

	public void setTxtClaseToxicId_ClaseToxicologica(SelectOneMenu txtClaseToxicId_ClaseToxicologica) {
		this.txtClaseToxicId_ClaseToxicologica = txtClaseToxicId_ClaseToxicologica;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
	}

	public SelectOneMenu getTxtTipoProdId_TipoProducto() {
		return txtTipoProdId_TipoProducto;
	}

	public void setTxtTipoProdId_TipoProducto(SelectOneMenu txtTipoProdId_TipoProducto) {
		this.txtTipoProdId_TipoProducto = txtTipoProdId_TipoProducto;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed_Prod() {
		return txtUdadMedId_UdadMed_Prod;
	}

	public void setTxtUdadMedId_UdadMed_Prod(SelectOneMenu txtUdadMedId_UdadMed_Prod) {
		this.txtUdadMedId_UdadMed_Prod = txtUdadMedId_UdadMed_Prod;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed_Cosecha() {
		return txtUdadMedId_UdadMed_Cosecha;
	}

	public void setTxtUdadMedId_UdadMed_Cosecha(SelectOneMenu txtUdadMedId_UdadMed_Cosecha) {
		this.txtUdadMedId_UdadMed_Cosecha = txtUdadMedId_UdadMed_Cosecha;
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

	public InputText getTxtProductoId() {
		return txtProductoId;
	}

	public void setTxtProductoId(InputText txtProductoId) {
		this.txtProductoId = txtProductoId;
	}

	public LazyDataModel<ProductoDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<ProductoDTO> productoDTO) {
		this.data = productoDTO;
	}

	public ProductoDTO getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(ProductoDTO producto) {
		this.selectedProducto = producto;
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

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen2() {
		return txtAlmacenId_Almacen2;
	}

	public void setTxtAlmacenId_Almacen2(SelectOneMenu txtAlmacenId_Almacen2) {
		this.txtAlmacenId_Almacen2 = txtAlmacenId_Almacen2;
	}

	public InputText getTxtValorUnit() {
		return txtValorUnit;
	}

	public void setTxtValorUnit(InputText txtValorUnit) {
		this.txtValorUnit = txtValorUnit;
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

	public SelectItem[] getSelectCentCost() {

		if (selectCentCost == null || selectCentCost.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCost = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCost[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCost;
	}

	public void setSelectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getSelectElementoCosto() {

		if (selectElementoCosto == null || selectElementoCosto.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectElementoCosto = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectElementoCosto[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectElementoCosto;
	}

	public void setSelectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
	}

	public SelectItem[] getSelectUdadMed() {

		if (selectUdadMed == null || selectUdadMed.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMed[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed;
	}

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public SelectItem[] getSelectUdadMed_Prod() {

		if (selectUdadMed_Prod == null || selectUdadMed_Prod.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed_Prod = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed_Prod : lista) {
					selectUdadMed_Prod[i] = new SelectItem(udadMed_Prod.getUdadMedId(), udadMed_Prod.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed_Prod;
	}

	public void setSelectUdadMed_Prod(SelectItem[] selectUdadMed_Prod) {
		this.selectUdadMed_Prod = selectUdadMed_Prod;
	}

	public SelectItem[] getSelectUdadMed_Cos() {

		if (selectUdadMed_Cos == null || selectUdadMed_Cos.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed_Cos = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed_Cosecha : lista) {
					selectUdadMed_Cos[i] = new SelectItem(udadMed_Cosecha.getUdadMedId(), udadMed_Cosecha.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed_Cos;
	}

	public void setSelectUdadMed_Cos(SelectItem[] selectUdadMed_Cos) {
		this.selectUdadMed_Cos = selectUdadMed_Cos;
	}

	public SelectItem[] getSelectAlmacen() {

		if (selectAlmacen == null || selectAlmacen.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(), almacen.getCodigo()+"-"+ almacen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	public void setSelectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public SelectItem[] getSelectAlmacen2() {

		if (selectAlmacen2 == null || selectAlmacen2.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(), almacen2.getCodigo());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen2;
	}

	public void setSelectAlmacen2(SelectItem[] selectAlmacen2) {
		this.selectAlmacen2 = selectAlmacen2;
	}

	public SelectItem[] getSelectClaseToxicologica() {

		if (selectClaseToxicologica == null || selectClaseToxicologica.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ClaseToxicologica> lista = businessDelegatorView.findByCriteriaInClaseToxicologica(condicion, null,
						null);
				selectClaseToxicologica = new SelectItem[lista.size()];

				int i = 0;
				for (ClaseToxicologica claseToxicologica : lista) {
					selectClaseToxicologica[i] = new SelectItem(claseToxicologica.getClaseToxicId(),
							claseToxicologica.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectClaseToxicologica;
	}

	public void setSelectClaseToxicologica(SelectItem[] selectClaseToxicologica) {
		this.selectClaseToxicologica = selectClaseToxicologica;
	}

	public SelectItem[] getSelectTipoProducto() {

		if (selectTipoProducto == null || selectTipoProducto.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProducto = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto : lista) {
					selectTipoProducto[i] = new SelectItem(tipoProducto.getTipoProdId(),
							tipoProducto.getCodigo() + " - " + tipoProducto.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProducto;
	}

	public void setSelectTipoProducto(SelectItem[] selectTipoProducto) {
		this.selectTipoProducto = selectTipoProducto;
	}

	public class LocalDataModelDTO extends LazyDataModel<ProductoDTO> {
		private static final long serialVersionUID = 1L;
		private List<ProductoDTO> productoDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<ProductoDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				productoDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberProducto(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return productoDTO;

		}

		@Override
		public ProductoDTO getRowData(String rowKey) {
			for (ProductoDTO productoDTOtmp : productoDTO) {
				if (productoDTOtmp.getProductoId().toString().equals(rowKey))
					return productoDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(ProductoDTO productoDTOtmp) {
			return productoDTOtmp.getProductoId();
		}

	}

	private List<ProductoDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageProducto(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public InputText getTxtCodAlmacen() {
		return txtCodAlmacen;
	}

	public void setTxtCodAlmacen(InputText txtCodAlmacen) {
		this.txtCodAlmacen = txtCodAlmacen;
	}

	public Calendar getFechaVencimiento() {
		return fechaVencimiento;
	}

	public SelectOneMenu getTxtUnidadMedida() {
		return txtUnidadMedida;
	}

	public InputText getCantidadCompra() {
		return cantidadCompra;
	}

	public InputText getLoteCompraProducto() {
		return loteCompraProducto;
	}

	public void setFechaVencimiento(Calendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setTxtUnidadMedida(SelectOneMenu txtUnidadMedida) {
		this.txtUnidadMedida = txtUnidadMedida;
	}

	public void setCantidadCompra(InputText cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public void setLoteCompraProducto(InputText loteCompraProducto) {
		this.loteCompraProducto = loteCompraProducto;
	}

	public InputText getRegistroIca() {
		return registroIca;
	}

	public void setRegistroIca(InputText registroIca) {
		this.registroIca = registroIca;
	}

	public InputText getTxtCodUnidadMedida() {
		return txtCodUnidadMedida;
	}

	public void setTxtCodUnidadMedida(InputText txtCodUnidadMedida) {
		this.txtCodUnidadMedida = txtCodUnidadMedida;
	}

	public SelectItem[] getSelectContratista() {

		if (selectContratista == null || selectContratista.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratista;
	}

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public InputText getTxtCodPersEmpr() {
		return txtCodPersEmpr;
	}

	public void setTxtCodPersEmpr(InputText txtCodPersEmpr) {
		this.txtCodPersEmpr = txtCodPersEmpr;
	}

	public SelectOneMenu getTxtPersEmpr() {
		return txtPersEmpr;
	}

	public void setTxtPersEmpr(SelectOneMenu txtPersEmpr) {
		this.txtPersEmpr = txtPersEmpr;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
				.get("selectedPrecioProductos"));

		Long precioProdId = selectedPrecioProductos.getPrecioProdId().longValue();
		String columnaCell = evt.getColumn().getHeaderText();
		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityPrecioProd = null;
			entityPrecioProd = businessDelegatorView.getPrecioPromProd(precioProdId);

			if (columnaCell.equals("Fecha inicial")) {

				entityPrecioProd.setFechaInicial((Date) newValue);

			} else if (columnaCell.equals("Almacén")) {

				Long almacenId = new Long(evt.getNewValue().toString());
				Almacen e = businessDelegatorView.getAlmacen(almacenId);

				entityPrecioProd.setAlmacenId(e);

			} else if (columnaCell.equals("U.M.")) {

				Long umId = new Long(evt.getNewValue().toString());
				UdadMed e = businessDelegatorView.getUdadMed(umId);

				entityPrecioProd.setUnidadMedida(e);

			} else if (columnaCell.equals("Prov.")) {

				Long provId = new Long(evt.getNewValue().toString());
				PersEmpr e = businessDelegatorView.getPersEmpr(provId);

				entityPrecioProd.setPersEmpr(e);

			} else if (columnaCell.equals("Cant.")) {

				entityPrecioProd.setCantidadCompra(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Precio")) {

				entityPrecioProd.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Fecha Ven.")) {

				entityPrecioProd.setFechaVencimiento((Date) newValue);

			} else if (columnaCell.equals("LoteC")) {

				entityPrecioProd.setLoteCompraProducto(String.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Regis. ICA")) {

				entityPrecioProd.setRegistroIca(String.valueOf(evt.getNewValue().toString()));

			}

			businessDelegatorView.updatePrecioPromProd(entityPrecioProd);
			entityPrecioProd = null;
			selectedPrecioProductos = null;
		}

	}

	public PrecioPromProd getEntityPrecioProd() {
		return entityPrecioProd;
	}

	public void setEntityPrecioProd(PrecioPromProd entityPrecioProd) {
		this.entityPrecioProd = entityPrecioProd;
	}

	public Spinner getTxtSaldoMinimo() {
		return txtSaldoMinimo;
	}

	public void setTxtSaldoMinimo(Spinner txtSaldoMinimo) {
		this.txtSaldoMinimo = txtSaldoMinimo;
	}

	public Spinner getTxtSaldoMaximo() {
		return txtSaldoMaximo;
	}

	public void setTxtSaldoMaximo(Spinner txtSaldoMaximo) {
		this.txtSaldoMaximo = txtSaldoMaximo;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneMenu getTxtUbAlmacen() {
		return txtUbAlmacen;
	}

	public void setTxtUbAlmacen(SelectOneMenu txtUbAlmacen) {
		this.txtUbAlmacen = txtUbAlmacen;
	}

	public SelectItem[] getSelectUbAlmacen() {

		if (selectUbAlmacen == null || selectUbAlmacen.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion,
						null, null);
				selectUbAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (UbicacionesAlmacen ubAlmacen : lista) {
					selectUbAlmacen[i] = new SelectItem(ubAlmacen.getUbicacionesAlmacenId(), ubAlmacen.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUbAlmacen;
	}

	public void setSelectUbAlmacen(SelectItem[] selectUbAlmacen) {
		this.selectUbAlmacen = selectUbAlmacen;
	}

	public InputText getTxtUbicacionAlmacen() {
		return txtUbicacionAlmacen;
	}

	public void setTxtUbicacionAlmacen(InputText txtUbicacionAlmacen) {
		this.txtUbicacionAlmacen = txtUbicacionAlmacen;
	}

	public void listener_txtCodigo_mini() throws Exception {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Producto> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInProducto(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtNombre.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtAlmacenId_Almacen.setDisabled(false);
			txtUbicacionAlmacen.setDisabled(false);
			btnSave.setDisabled(false);

		} else {

			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
			txtNombre.setValue(null);
			txtNombre.setDisabled(false);
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
			txtTipoProdId_TipoProducto.setValue(null);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setValue(null);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(false);
			txtUbicacionAlmacen.setDisabled(false);
			btnSave.setDisabled(false);

			FacesUtils.addInfoMessage("Upps! El Código digitado ya existe!, porfavor intente con otro");
		}
	}

	public void listener_txtCodigo_mini_agricola() throws Exception {
		Long compania = new Long(getCompaniaIdSession());
		Long consecProducto = businessDelegator2View.pr_consec_producto_tipo(compania, 0L);
		String codigo = consecProducto.toString();
		try {

			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Producto> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInProducto(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else {
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);
				entity = null;
			}

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setValue(codigo);
			txtCodigo.setDisabled(false);
			txtNombre.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtAlmacenId_Almacen.setDisabled(false);
			btnSave.setDisabled(false);

		} else {

			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
			txtNombre.setValue(null);
			txtNombre.setDisabled(false);
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setValue(null);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(false);
			btnSave.setDisabled(false);

			FacesUtils.addInfoMessage("Upps! El Código digitado ya existe!, porfavor intente con otro");
		}
	}

	public void listener_txtCodigo_mini_mtto() throws NumberFormatException, Exception {

		Long compania = new Long(getCompaniaIdSession());
		Long tipoProducto = FacesUtils.checkLong(txtTipoProdId_TipoProducto);
		Long consecProducto = businessDelegator2View.pr_consec_producto_tipo(compania, tipoProducto);

		String codigo = consecProducto.toString();
		try {

			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Producto> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInProducto(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else {
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);
				entity = null;
			}

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setValue(codigo);
			txtCodigo.setDisabled(false);
			txtNombre.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtAlmacenId_Almacen.setDisabled(false);
			txtUbicacionAlmacen.setDisabled(false);
			btnSave.setDisabled(false);

		} else {

			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
			txtNombre.setValue(null);
			txtNombre.setDisabled(false);
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
			txtTipoProdId_TipoProducto.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setValue(null);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(false);
			txtUbicacionAlmacen.setDisabled(false);
			btnSave.setDisabled(false);

			FacesUtils.addInfoMessage("Upps! El Código digitado ya existe!, porfavor intente con otro");
		}
	}

	public List<DatProductosRelacionadosDTO> getDataProdRelacionado() {
		return dataProdRelacionado;
	}

	public void setDataProdRelacionado(List<DatProductosRelacionadosDTO> dataProdRelacionado) {
		this.dataProdRelacionado = dataProdRelacionado;
	}

	public DatProductosRelacionadosDTO getSelectedProdRelacionado() {
		return selectedProdRelacionado;
	}

	public void setSelectedProdRelacionado(DatProductosRelacionadosDTO selectedProdRelacionado) {
		this.selectedProdRelacionado = selectedProdRelacionado;
	}

	public SelectOneMenu getTxtProductoRel() {
		return txtProductoRel;
	}

	public void setTxtProductoRel(SelectOneMenu txtProductoRel) {
		this.txtProductoRel = txtProductoRel;
	}

	public SelectItem[] getSelectProductoRel() {

		if (selectProductoRel == null || selectProductoRel.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoRel = new SelectItem[lista.size()];

				int i = 0;
				for (Producto prod : lista) {
					selectProductoRel[i] = new SelectItem(prod.getProductoId(), prod.getCodigo()+"-"+prod.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoRel;
	}

	public void setSelectProductoRel(SelectItem[] selectProductoRel) {
		this.selectProductoRel = selectProductoRel;
	}

	public SelectOneMenu getTxtUdadMedRel() {
		return txtUdadMedRel;
	}

	public void setTxtUdadMedRel(SelectOneMenu txtUdadMedRel) {
		this.txtUdadMedRel = txtUdadMedRel;
	}

	public SelectItem[] getSelectUdadMedRel() {

		if (selectUdadMedRel == null || selectUdadMedRel.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedRel = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedRel[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedRel;
	}

	public void setSelectUdadMedRel(SelectItem[] selectUdadMedRel) {
		this.selectUdadMedRel = selectUdadMedRel;
	}

	public InputNumber getTxtPorcentajeRel() {
		return txtPorcentajeRel;
	}

	public void setTxtPorcentajeRel(InputNumber txtPorcentajeRel) {
		this.txtPorcentajeRel = txtPorcentajeRel;
	}

	public void action_agregarProductosRelacionados() throws Exception {
		Double dosis = FacesUtils.checkDouble(txtDosisRel);
		if (txtProductoRel.getValue() != null && txtUdadMedRel.getValue() != null
				&& dosis != null   && dosis > 0   ) {

			Long productoId = FacesUtils.checkLong(txtProductoRel);
			Producto producto = businessDelegatorView.getProducto(productoId);
			String nomProducto = producto.getNombre();

			Long udadMedId = FacesUtils.checkLong(txtUdadMedRel);
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
			String nomUdadMed = udadMed.getNombre();
			boolean existeProducto = false;

			if (dataProdRelacionado == null || dataProdRelacionado.size() == 0) {
				dataProdRelacionado = new ArrayList<DatProductosRelacionadosDTO>();

			} 
			if (dataProdRelacionado.size() > 0) {

				for (DatProductosRelacionadosDTO d : dataProdRelacionado) {

					if (d.getProductoAsociadoId().longValue() == productoId.longValue()) {

						existeProducto = true;
						
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upps! Ya éxiste el producto " + nomProducto.toString(),
										" " + "Verifie nuevamente. "));

						break;
					}
				}

			}
			if (existeProducto == false) {
				DatProductosRelacionadosDTO datProductosRelacionadosDTO = new DatProductosRelacionadosDTO();
				datProductosRelacionadosDTO.setProductoAsociadoId(productoId);
				datProductosRelacionadosDTO.setNomProducto(nomProducto);
				datProductosRelacionadosDTO.setUdadMedId_UdadMed(udadMedId);
				datProductosRelacionadosDTO.setNomUdadMed(nomUdadMed);
				datProductosRelacionadosDTO.setPorcentaje(0.0);
				datProductosRelacionadosDTO.setDosis(dosis);
				datProductosRelacionadosDTO.setCantidad(0.0);
				

				dataProdRelacionado.add(datProductosRelacionadosDTO);

				productoId = null;
				producto = null;
				nomProducto = null;
				udadMedId = null;
				udadMed = null;
				nomUdadMed = null;
				limpiar_pantalla();
				//porcentaje = null;

			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos producto, udad med y porcentaje tengan valores. "));
		}
	}
	
	public void limpiar_pantalla () {
		txtDosisRel.setValue(null);
		txtProductoRel.setValue(null);
		txtUdadMedRel.setValue(null);
	}

	public void onCellEditProdRelacionados(CellEditEvent evt) throws Exception {

		selectedProdRelacionado = (DatProductosRelacionadosDTO) (evt.getComponent().getAttributes()
				.get("selectedProdRelacionado"));

		Long datProductosAgregadosId = selectedProdRelacionado.getDatProductosAgregadosId();
		if (datProductosAgregadosId != null) {
			String columnaCell = evt.getColumn().getHeaderText();
			Long productoId = FacesUtils.checkLong(txtProductoId);

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityProdRelacionado = null;
				entityProdRelacionado = businessDelegator2View.getDatProductosRelacionados(datProductosAgregadosId);

				if (columnaCell.equals("Producto")) {

					entityProdRelacionado.setProductoAsociadoId((Long) newValue);

				} else if (columnaCell.equals("U.M")) {

					Long udadMedId = FacesUtils.checkLong(newValue);
					UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);

					entityProdRelacionado.setUdadMed(udadMed);

				} else if (columnaCell.equals("Porcentaje")) {

					Double porcent = 0.0;
					if (dataProdRelacionado != null) {
						for (DatProductosRelacionadosDTO dataRel : dataProdRelacionado) {

							porcent += dataRel.getPorcentaje();
						}
					}

					if (porcent > 100) {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Ya se alcanzo el porcentaje maximo permitido. "));
						selectedProdRelacionado.setPorcentaje((Double) oldValue);

					} else {

						entityProdRelacionado.setPorcentaje((Double) newValue);
					}
				}else if (columnaCell.equals("Dosis")) {

					entityProdRelacionado.setDosis(Double.valueOf(evt.getNewValue().toString()));

				}

				entity = businessDelegatorView.getProducto(productoId);
				entityProdRelacionado.setProducto(entity);
				businessDelegator2View.updateDatProductosRelacionados(entityProdRelacionado);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				entityProdRelacionado = null;
				selectedProdRelacionado = null;
				entity = null;

				dataProdRelacionado = null;
				dataProdRelacionado = businessDelegator2View.getDataDatProductosRelacionadosByProducto(productoId);
			}
		}
	}

	public String actionDeleteProductoRelacionado(ActionEvent evt) {
		try {

			selectedProdRelacionado = (DatProductosRelacionadosDTO) (evt.getComponent().getAttributes()
					.get("selectedProdRelacionado"));

			if (selectedProdRelacionado.getDatProductosAgregadosId() == null) {
				dataProdRelacionado.remove(selectedProdRelacionado);
			} else {
				Long datProductosAgregadosId = new Long(selectedProdRelacionado.getDatProductosAgregadosId());
				DatProductosRelacionados entity = businessDelegator2View
						.getDatProductosRelacionados(datProductosAgregadosId);
				businessDelegator2View.deleteDatProductosRelacionados(entity);
				dataProdRelacionado.remove(selectedProdRelacionado);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void consultarUdadMed() throws Exception {

		Long productoId = FacesUtils.checkLong(txtProductoRel);
		txtUdadMedRel.setValue(null);

		if (productoId != null) {

			Producto producto = businessDelegatorView.getProducto(productoId);
			txtUdadMedRel.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
		}
	}

	public CommandButton getBtnAgregarRel() {
		return btnAgregarRel;
	}

	public void setBtnAgregarRel(CommandButton btnAgregarRel) {
		this.btnAgregarRel = btnAgregarRel;
	}

	 

	public InputNumber getTxtCantidadRel() {
		return txtCantidadRel;
	}

 

	public InputText getTxtDosisRel() {
		return txtDosisRel;
	}

	public void setTxtDosisRel(InputText txtDosisRel) {
		this.txtDosisRel = txtDosisRel;
	}

	public void setTxtCantidadRel(InputNumber txtCantidadRel) {
		this.txtCantidadRel = txtCantidadRel;
	}

	public SelectOneMenu getTxtEsFormula() {
		return txtEsFormula;
	}

	public void setTxtEsFormula(SelectOneMenu txtEsFormula) {
		this.txtEsFormula = txtEsFormula;
	}
	
	
}