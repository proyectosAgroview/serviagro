package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.DatProductosRelacionados;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatOtrosMovInventarioDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraMateriaPrimaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOtrosMovimientosInventarioDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
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
public class DatOtrosMovInventarioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosMovInventarioView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputTextarea txtDetalleNota;
	private InputText txtDistribuirCantidad;
	private SelectOneRadio txtEstado;
	private InputText txtNumFactura;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatOtrosMovInventarioId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatOtrosMovInventarioDTO> data;
	private DatOtrosMovInventarioDTO selectedDatOtrosMovInventario;
	private DatOtrosMovInventario entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	/** Campos de pantalla de precios por producto **/

	private Calendar fechaVencimiento;

	private SelectOneMenu txtUnidadMedida;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private InputText cantidadCompra;
	private InputText loteCompraProducto;
	private InputText registroIca;

	private Double costoTotalProductoFormula;

	private Calendar txtFechaInicial;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;

	private SelectOneMenu txtAlmacenId_Almacen2;
	SelectItem[] selectAlmacen2;
	private List<Almacen> almacen2;
	private InputText txtSaldo;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private InputText txtCodAlmacen;
	private InputText txtCodUnidadMedida;

	private InputText txtCodPersEmpr;

	private SelectOneMenu txtPersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	SelectItem[] selectProducto2;
	private List<Producto> producto2;

	private int activeTapIndex = 0;

	private List<PrecioPromProdDTO> dataDetPrecioProductos;
	private List<PrecioPromProdDTO> dataDetPrecioProductosEntrada;
	private PrecioPromProdDTO selectedPrecioProductos;

	private SelectOneMenu txtUbicacionesAlmacen;
	SelectItem[] selectUbAlmacen;

	private PrecioPromProd entityPrecioProd;

	private InputText txtValorIvaProducto;

	private InputText txtConsecutivoPrecioPromedio;

	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;
	private List<ConceptoKardex> conceptoKardex;

	private InputText txtTipoMovimiento;
	private InputText txtNumFacturaPPromedio;
	private InputText txtCostoTotalPPromedio;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtTrabajadorId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;
	private InputText txtPorcentajeIva;

	private InputTextarea txtInfoAdicional;

	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipo;

	private List<ListaEquiposCategoriaDTO> dataEquiposCategoriaDTO;
	private InputText txtDocumentoC;
	private List<ConsultaOtrosMovimientosInventarioDTO> data2;
	private ConsultaOtrosMovimientosInventarioDTO selectedDatOtrosMovInventario2;

	private InputText txtOrigenDatos;
	private InputText txtHorometroAbastecimiento;

	private List<ListaNivel4DTO> lotes;
	private List<String> selectedLotes;

	/*** consulta saldos por ubicacio ***/
	private List<ConsultaStockMaquinariaDTO> dataProductoUbicacion;
	private List<ConsultaStockMaquinariaDTO> dataProductoUbicacionX;
	ConsultaStockMaquinariaDTO selectedProductoUbicacion;

	private Calendar txtFechaEntrega;

	private SelectOneMenu txtEquipoConsulta;
	SelectItem[] selectEquipoConsulta;
	private List<Equipo> equipoConsulta;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;
	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;

	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;

	private List<String> selectedOrdenMp;
	private List<ConsultaCompraProductosDTO> ordenMp;

	/**************** nuevos campos para modulo de puntas **********************/
	private SelectOneMenu txtConceptoKardex2;
	SelectItem[] selectConceptoKardex1;
	SelectItem[] selectConceptoKardex2;
	private List<ConceptoKardex> conceptoKardex2;

	private SelectOneMenu txtAlmacenId_Almacen3;
	SelectItem[] selectAlmacen3;
	private List<Almacen> almacen3;

	private SelectOneMenu txtTipoProducto2;
	SelectItem[] selectTipoProducto2;
	private List<TipoProducto> tipoProducto2;

	private SelectOneMenu txtProductoId_Producto2;
	SelectItem[] selectProductoId2;

	private SelectOneMenu txtUbicacionesAlmacen2;
	SelectItem[] selectUbAlmacen2;

	private SelectOneMenu txtUnidadMedida2;
	SelectItem[] selectUdadMed2;

	private InputText txtSaldo2;
	private InputText cantidadCompra2;

	private CommandButton btnAgregar2;
	private InputText txtValorTotalProducto;

	SelectItem[] selectProducto3;
	private List<Producto> producto3;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private List<PrecioPromProdDTO> dataDetPrecioProductos2;

	public DatOtrosMovInventarioView() {
		super();
	}

	public String action_new() throws Exception {
		action_clear();
		selectedDatOtrosMovInventario = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws Exception {
		entity = null;
		selectedDatOtrosMovInventario = null;
		PrimeFaces.current().resetInputs(":frm");

		activeTapIndex = 0;
		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}

		if (txtConceptoKardex2 != null) {
			txtConceptoKardex2.setValue(null);
			txtConceptoKardex2.setDisabled(false);
		}
		if (txtAlmacenId_Almacen3 != null) {
			txtAlmacenId_Almacen3.setValue(null);
			txtAlmacenId_Almacen3.setDisabled(false);
		}
		if (txtTipoProducto2 != null) {
			txtTipoProducto2.setValue(null);
			txtTipoProducto2.setDisabled(false);
		}
		if (txtProductoId_Producto2 != null) {
			txtProductoId_Producto2.setValue(null);
			txtProductoId_Producto2.setDisabled(false);
		}
		if (txtUbicacionesAlmacen2 != null) {
			txtUbicacionesAlmacen2.setValue(null);
			txtUbicacionesAlmacen2.setDisabled(false);
		}
		if (txtUnidadMedida2 != null) {
			txtUnidadMedida2.setValue(null);
			txtUnidadMedida2.setDisabled(false);
		}
		if (txtSaldo2 != null) {
			txtSaldo2.setValue(null);
			txtSaldo2.setDisabled(false);
		}
		if (cantidadCompra2 != null) {
			cantidadCompra2.setValue(null);
			cantidadCompra2.setDisabled(false);
		}
		if (btnAgregar2 != null) {

			btnAgregar2.setDisabled(false);
		}
		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}
		if (txtFechaEntrega != null) {
			Date date = new Date();
			txtFechaEntrega.setValue(date);
			txtFechaEntrega.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (ordenMp != null) {
			ordenMp = null;

		}
		if (selectedOrdenMp != null) {
			selectedOrdenMp = null;

		}

		if (txtHorometroAbastecimiento != null) {
			txtHorometroAbastecimiento.setValue(null);
			txtHorometroAbastecimiento.setDisabled(false);
		}

		if (txtDetalleNota != null) {
			txtDetalleNota.setValue(null);
			txtDetalleNota.setDisabled(false);
		}

		if (txtSaldo != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(true);
		}

		if (txtAlmacenId_Almacen3 != null) {
			txtAlmacenId_Almacen3.setValue(null);
			txtAlmacenId_Almacen3.setDisabled(false);
		}

		if (txtDistribuirCantidad != null) {
			txtDistribuirCantidad.setValue(null);
			txtDistribuirCantidad.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtNumFactura != null) {
			txtNumFactura.setValue(null);
			txtNumFactura.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			Date date = new Date();
			txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtDatOtrosMovInventarioId != null) {
			txtDatOtrosMovInventarioId.setValue(null);
			txtDatOtrosMovInventarioId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		/************** Detalle productos ***/

		if (dataDetPrecioProductos != null) {
			dataDetPrecioProductos = null;
		}

		if (dataDetPrecioProductos2 != null) {
			dataDetPrecioProductos2 = null;
		}

		if (dataDetPrecioProductosEntrada != null) {
			dataDetPrecioProductosEntrada = null;
		}

		if (txtValorUnit != null) {
			txtValorUnit.setValue(null);
			txtValorUnit.setDisabled(false);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(false);
		}

		if (txtPorcentajeIva != null) {
			txtPorcentajeIva.setValue(0);
			txtPorcentajeIva.setDisabled(false);
		}
		if (txtAlmacenId_Almacen2 != null) {
			txtAlmacenId_Almacen2.setValue(null);
			txtAlmacenId_Almacen2.setDisabled(false);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}

		if (fechaVencimiento != null) {
			fechaVencimiento.setValue(null);
			fechaVencimiento.setDisabled(false);
		}

		if (txtUnidadMedida != null) {
			txtUnidadMedida.setValue(null);
			txtUnidadMedida.setDisabled(false);
		}

		if (cantidadCompra != null) {
			cantidadCompra.setValue(null);
			cantidadCompra.setDisabled(false);
		}

		if (loteCompraProducto != null) {
			loteCompraProducto.setValue(null);
			loteCompraProducto.setDisabled(false);
		}

		if (registroIca != null) {
			registroIca.setValue(null);
			registroIca.setDisabled(false);
		}

		if (txtPersEmpr != null) {
			txtPersEmpr.setValue(null);
			txtPersEmpr.setDisabled(false);
		}

		if (txtValorTotalProducto != null) {
			txtValorTotalProducto.setValue(null);
			txtValorTotalProducto.setDisabled(false);
		}

		if (txtValorTotalProducto != null) {
			txtValorTotalProducto.setValue(null);
			txtValorTotalProducto.setDisabled(false);
		}

		if (txtConsecutivoPrecioPromedio != null) {
			txtConsecutivoPrecioPromedio.setValue(null);
			txtConsecutivoPrecioPromedio.setDisabled(false);
		}

		if (txtConceptoKardex != null) {
			txtConceptoKardex.setValue(null);
			txtConceptoKardex.setDisabled(false);
		}

		if (txtTipoMovimiento != null) {
			txtTipoMovimiento.setValue(null);
			txtTipoMovimiento.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtNumFacturaPPromedio != null) {
			txtNumFacturaPPromedio.setValue(null);
			txtNumFacturaPPromedio.setDisabled(false);
		}

		if (txtCostoTotalPPromedio != null) {
			txtCostoTotalPPromedio.setValue(null);
			txtCostoTotalPPromedio.setDisabled(false);
		}

		if (txtTrabajadorId_Trabajador != null) {
			txtTrabajadorId_Trabajador.setValue(null);
			txtTrabajadorId_Trabajador.setDisabled(false);
		}

		if (txtTipoProducto != null) {
			txtTipoProducto.setValue(null);
			txtTipoProducto.setDisabled(false);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
		}

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaAnulacion() {
		Date inputDate = (Date) txtFechaAnulacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
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

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public String action_edit(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtSaldo.setDisabled(true);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtNumFactura.setValue(entity.getNumFactura());
				txtNumFactura.setDisabled(false);
				txtConceptoKardex.setValue(entity.getConceptoKardex().getConceptoKardexId());
				txtConceptoKardex.setDisabled(false);

				if (entity.getPersEmpr() != null) {
					txtPersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
				}

				txtPersEmpr.setDisabled(false);

				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);

				txtDatOtrosMovInventarioId.setValue(entity.getDatOtrosMovInventarioId());
				txtDatOtrosMovInventarioId.setDisabled(true);

				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventarioId);

				if (txtTipoProducto != null) {
					txtTipoProducto.setValue(null);
					txtTipoProducto.setDisabled(false);
				}

				if (txtValorUnit != null) {
					txtValorUnit.setValue(null);
					txtValorUnit.setDisabled(false);
				}

				if (txtPorcentajeIva != null) {
					txtPorcentajeIva.setValue(null);
					txtPorcentajeIva.setDisabled(false);
				}
				if (txtFechaInicial != null) {
					txtFechaInicial.setValue(null);
					txtFechaInicial.setDisabled(false);
				}

				if (txtAlmacenId_Almacen2 != null) {
					txtAlmacenId_Almacen2.setValue(null);
					txtAlmacenId_Almacen2.setDisabled(false);
				}

				if (txtProductoId_Producto != null) {
					txtProductoId_Producto.setValue(null);
					txtProductoId_Producto.setDisabled(false);
				}

				if (fechaVencimiento != null) {
					fechaVencimiento.setValue(null);
					fechaVencimiento.setDisabled(false);
				}

				if (txtUnidadMedida != null) {
					txtUnidadMedida.setValue(null);
					txtUnidadMedida.setDisabled(false);
				}

				if (cantidadCompra != null) {
					cantidadCompra.setValue(null);
					cantidadCompra.setDisabled(false);
				}

				if (loteCompraProducto != null) {
					loteCompraProducto.setValue(null);
					loteCompraProducto.setDisabled(false);
				}

				if (registroIca != null) {
					registroIca.setValue(null);
					registroIca.setDisabled(false);
				}

				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}
				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}

				if (txtConsecutivoPrecioPromedio != null) {
					txtConsecutivoPrecioPromedio.setValue(null);
					txtConsecutivoPrecioPromedio.setDisabled(false);
				}
				if (txtTipoMovimiento != null) {
					txtTipoMovimiento.setValue(null);
					txtTipoMovimiento.setDisabled(false);
				}
				/*
				 * if (txtEquipoId_Equipo != null) { txtEquipoId_Equipo.setValue(null);
				 * txtEquipoId_Equipo.setDisabled(false); }
				 */
				if (txtNumFacturaPPromedio != null) {
					txtNumFacturaPPromedio.setValue(null);
					txtNumFacturaPPromedio.setDisabled(false);
				}
				if (txtCostoTotalPPromedio != null) {
					txtCostoTotalPPromedio.setValue(null);
					txtCostoTotalPPromedio.setDisabled(false);
				}
				if (txtTrabajadorId_Trabajador != null) {
					txtTrabajadorId_Trabajador.setValue(null);
					txtTrabajadorId_Trabajador.setDisabled(false);
				}

				if (txtNivel2Id_Nivel2 != null) {
					txtNivel2Id_Nivel2.setValue(null);
					txtNivel2Id_Nivel2.setDisabled(false);
				}
				/*
				 * if (txtNivel4Id_Nivel4 != null) { txtNivel4Id_Nivel4.setValue(null);
				 * txtNivel4Id_Nivel4.setDisabled(false); }
				 */
				if (txtHorometroAbastecimiento != null) {
					txtHorometroAbastecimiento.setValue(0.0);
					txtHorometroAbastecimiento.setDisabled(false);
				}
				txtImplemento.setDisabled(false);

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_editProductosInternos(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtSaldo.setDisabled(true);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtNumFactura.setValue(entity.getNumFactura());
				txtNumFactura.setDisabled(false);
				txtConceptoKardex.setValue(entity.getConceptoKardex().getConceptoKardexId());
				txtConceptoKardex.setDisabled(false);

				if (entity.getPersEmpr() != null) {
					txtPersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
				}

				txtPersEmpr.setDisabled(false);

				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);

				txtDatOtrosMovInventarioId.setValue(entity.getDatOtrosMovInventarioId());
				txtDatOtrosMovInventarioId.setDisabled(true);

				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventarioId);

				if (txtTipoProducto != null) {
					txtTipoProducto.setValue(null);
					txtTipoProducto.setDisabled(false);
				}

				if (txtValorUnit != null) {
					txtValorUnit.setValue(null);
					txtValorUnit.setDisabled(false);
				}

				if (txtPorcentajeIva != null) {
					txtPorcentajeIva.setValue(null);
					txtPorcentajeIva.setDisabled(false);
				}
				if (txtFechaInicial != null) {
					txtFechaInicial.setValue(null);
					txtFechaInicial.setDisabled(false);
				}

				if (txtAlmacenId_Almacen2 != null) {
					txtAlmacenId_Almacen2.setValue(null);
					txtAlmacenId_Almacen2.setDisabled(false);
				}

				if (txtProductoId_Producto != null) {
					txtProductoId_Producto.setValue(null);
					txtProductoId_Producto.setDisabled(false);
				}

				if (fechaVencimiento != null) {
					fechaVencimiento.setValue(null);
					fechaVencimiento.setDisabled(false);
				}

				if (txtUnidadMedida != null) {
					txtUnidadMedida.setValue(null);
					txtUnidadMedida.setDisabled(false);
				}

				if (cantidadCompra != null) {
					cantidadCompra.setValue(null);
					cantidadCompra.setDisabled(false);
				}

				if (loteCompraProducto != null) {
					loteCompraProducto.setValue(null);
					loteCompraProducto.setDisabled(false);
				}

				if (registroIca != null) {
					registroIca.setValue(null);
					registroIca.setDisabled(false);
				}

				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}

				if (txtConsecutivoPrecioPromedio != null) {
					txtConsecutivoPrecioPromedio.setValue(null);
					txtConsecutivoPrecioPromedio.setDisabled(false);
				}
				if (txtTipoMovimiento != null) {
					txtTipoMovimiento.setValue(null);
					txtTipoMovimiento.setDisabled(false);
				}
				/*
				 * if (txtEquipoId_Equipo != null) { txtEquipoId_Equipo.setValue(null);
				 * txtEquipoId_Equipo.setDisabled(false); }
				 */
				if (txtNumFacturaPPromedio != null) {
					txtNumFacturaPPromedio.setValue(null);
					txtNumFacturaPPromedio.setDisabled(false);
				}
				if (txtCostoTotalPPromedio != null) {
					txtCostoTotalPPromedio.setValue(null);
					txtCostoTotalPPromedio.setDisabled(false);
				}
				if (txtTrabajadorId_Trabajador != null) {
					txtTrabajadorId_Trabajador.setValue(null);
					txtTrabajadorId_Trabajador.setDisabled(false);
				}

				if (txtNivel2Id_Nivel2 != null) {
					txtNivel2Id_Nivel2.setValue(null);
					txtNivel2Id_Nivel2.setDisabled(false);
				}
				/*
				 * if (txtNivel4Id_Nivel4 != null) { txtNivel4Id_Nivel4.setValue(null);
				 * txtNivel4Id_Nivel4.setDisabled(false); }
				 */

				if (txtConceptoKardex2 != null) {
					txtConceptoKardex2.setValue(null);
					txtConceptoKardex2.setDisabled(false);
				}
				if (txtAlmacenId_Almacen3 != null) {
					txtAlmacenId_Almacen3.setValue(null);
					txtAlmacenId_Almacen3.setDisabled(false);
				}
				if (txtTipoProducto2 != null) {
					txtTipoProducto2.setValue(null);
					txtTipoProducto2.setDisabled(false);
				}
				if (txtProductoId_Producto2 != null) {
					txtProductoId_Producto2.setValue(null);
					txtProductoId_Producto2.setDisabled(false);
				}
				if (txtUbicacionesAlmacen2 != null) {
					txtUbicacionesAlmacen2.setValue(null);
					txtUbicacionesAlmacen2.setDisabled(false);
				}
				if (txtUnidadMedida2 != null) {
					txtUnidadMedida2.setValue(null);
					txtUnidadMedida2.setDisabled(false);
				}
				if (txtSaldo2 != null) {
					txtSaldo2.setValue(null);
					txtSaldo2.setDisabled(false);
				}
				if (cantidadCompra2 != null) {
					cantidadCompra2.setValue(null);
					cantidadCompra2.setDisabled(false);
				}
				if (btnAgregar2 != null) {
					btnAgregar2.setValue(null);
					btnAgregar2.setDisabled(false);
				}

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_editSalidaSuministros(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtConceptoKardex.setValue(entity.getConceptoKardex().getConceptoKardexId());
				txtConceptoKardex.setDisabled(false);

				txtLaborId_Labor.setValue(null);
				if (entity.getLabor() != null) {
					txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
				}

				txtLaborId_Labor.setDisabled(false);

				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);

				txtDatOtrosMovInventarioId.setValue(entity.getDatOtrosMovInventarioId());
				txtDatOtrosMovInventarioId.setDisabled(true);

				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventarioId);

				if (txtInfoAdicional != null) {
					txtInfoAdicional.setValue(null);
					txtInfoAdicional.setDisabled(false);
				}

				if (txtTipoProducto != null) {
					txtTipoProducto.setValue(null);
					txtTipoProducto.setDisabled(false);
				}

				if (txtValorUnit != null) {
					txtValorUnit.setValue(null);
					txtValorUnit.setDisabled(false);
				}

				if (txtPorcentajeIva != null) {
					txtPorcentajeIva.setValue(null);
					txtPorcentajeIva.setDisabled(false);
				}
				if (txtFechaInicial != null) {
					txtFechaInicial.setValue(null);
					txtFechaInicial.setDisabled(false);
				}

				if (txtAlmacenId_Almacen2 != null) {
					txtAlmacenId_Almacen2.setValue(null);
					txtAlmacenId_Almacen2.setDisabled(false);
				}

				if (txtProductoId_Producto != null) {
					txtProductoId_Producto.setValue(null);
					txtProductoId_Producto.setDisabled(false);
				}

				if (fechaVencimiento != null) {
					fechaVencimiento.setValue(null);
					fechaVencimiento.setDisabled(false);
				}

				if (txtUnidadMedida != null) {
					txtUnidadMedida.setValue(null);
					txtUnidadMedida.setDisabled(false);
				}

				if (cantidadCompra != null) {
					cantidadCompra.setValue(null);
					cantidadCompra.setDisabled(false);
				}

				if (loteCompraProducto != null) {
					loteCompraProducto.setValue(null);
					loteCompraProducto.setDisabled(false);
				}

				if (registroIca != null) {
					registroIca.setValue(null);
					registroIca.setDisabled(false);
				}

				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}
				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}

				if (txtConsecutivoPrecioPromedio != null) {
					txtConsecutivoPrecioPromedio.setValue(null);
					txtConsecutivoPrecioPromedio.setDisabled(false);
				}
				if (txtTipoMovimiento != null) {
					txtTipoMovimiento.setValue(null);
					txtTipoMovimiento.setDisabled(false);
				}
				/*
				 * if (txtEquipoId_Equipo != null) { txtEquipoId_Equipo.setValue(null);
				 * txtEquipoId_Equipo.setDisabled(false); }
				 */
				if (txtNumFacturaPPromedio != null) {
					txtNumFacturaPPromedio.setValue(null);
					txtNumFacturaPPromedio.setDisabled(false);
				}
				if (txtCostoTotalPPromedio != null) {
					txtCostoTotalPPromedio.setValue(null);
					txtCostoTotalPPromedio.setDisabled(false);
				}
				if (txtTrabajadorId_Trabajador != null) {
					txtTrabajadorId_Trabajador.setValue(null);
					txtTrabajadorId_Trabajador.setDisabled(false);
				}

				if (txtNivel2Id_Nivel2 != null) {
					txtNivel2Id_Nivel2.setValue(null);
					txtNivel2Id_Nivel2.setDisabled(false);
				}

				if (txtHorometroAbastecimiento != null) {
					txtHorometroAbastecimiento.setValue(0.0);
					txtHorometroAbastecimiento.setDisabled(false);
				}

				/*
				 * if (txtNivel4Id_Nivel4 != null) { txtNivel4Id_Nivel4.setValue(null);
				 * txtNivel4Id_Nivel4.setDisabled(false); }
				 */
				txtImplemento.setDisabled(false);

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_editSalidaSuministrosTaller(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				if (entity.getCategoria() != null) {
					txtCategEquipId_CategoriaEquipo.setValue(entity.getCategoria().getCategEquipId());
				}
				txtCategEquipId_CategoriaEquipo.setDisabled(true);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtConceptoKardex.setValue(entity.getConceptoKardex().getConceptoKardexId());
				txtConceptoKardex.setDisabled(true);
				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);

				txtLaborId_Labor.setValue(null);
				if (entity.getLabor() != null) {
					txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
				}
				txtLaborId_Labor.setDisabled(false);
				txtDatOtrosMovInventarioId.setValue(entity.getDatOtrosMovInventarioId());
				txtDatOtrosMovInventarioId.setDisabled(true);

				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventarioId);

				if (txtInfoAdicional != null) {
					txtInfoAdicional.setValue(null);
					txtInfoAdicional.setDisabled(false);
				}

				if (txtTipoProducto != null) {
					txtTipoProducto.setValue(null);
					txtTipoProducto.setDisabled(false);
				}

				if (txtValorUnit != null) {
					txtValorUnit.setValue(null);
					txtValorUnit.setDisabled(false);
				}

				if (txtPorcentajeIva != null) {
					txtPorcentajeIva.setValue(null);
					txtPorcentajeIva.setDisabled(false);
				}
				if (txtFechaInicial != null) {
					txtFechaInicial.setValue(null);
					txtFechaInicial.setDisabled(false);
				}

				if (txtAlmacenId_Almacen2 != null) {
					txtAlmacenId_Almacen2.setValue(null);
					txtAlmacenId_Almacen2.setDisabled(false);
				}

				if (txtProductoId_Producto != null) {
					txtProductoId_Producto.setValue(null);
					txtProductoId_Producto.setDisabled(false);
				}

				if (fechaVencimiento != null) {
					fechaVencimiento.setValue(null);
					fechaVencimiento.setDisabled(false);
				}

				if (txtUnidadMedida != null) {
					txtUnidadMedida.setValue(null);
					txtUnidadMedida.setDisabled(false);
				}

				if (cantidadCompra != null) {
					cantidadCompra.setValue(null);
					cantidadCompra.setDisabled(false);
				}

				if (loteCompraProducto != null) {
					loteCompraProducto.setValue(null);
					loteCompraProducto.setDisabled(false);
				}

				if (registroIca != null) {
					registroIca.setValue(null);
					registroIca.setDisabled(false);
				}

				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}
				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}

				if (txtConsecutivoPrecioPromedio != null) {
					txtConsecutivoPrecioPromedio.setValue(null);
					txtConsecutivoPrecioPromedio.setDisabled(false);
				}
				if (txtTipoMovimiento != null) {
					txtTipoMovimiento.setValue(null);
					txtTipoMovimiento.setDisabled(false);
				}
				if (txtEquipoId_Equipo != null) {
					txtEquipoId_Equipo.setValue(null);
					txtEquipoId_Equipo.setDisabled(false);
				}
				if (txtNumFacturaPPromedio != null) {
					txtNumFacturaPPromedio.setValue(null);
					txtNumFacturaPPromedio.setDisabled(false);
				}
				if (txtCostoTotalPPromedio != null) {
					txtCostoTotalPPromedio.setValue(null);
					txtCostoTotalPPromedio.setDisabled(false);
				}
				if (txtTrabajadorId_Trabajador != null) {
					txtTrabajadorId_Trabajador.setValue(null);
					txtTrabajadorId_Trabajador.setDisabled(false);
				}
				// txtImplemento.setDisabled(false);

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_editTraslados(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtConceptoKardex.setValue(entity.getConceptoKardex().getConceptoKardexId());
				txtConceptoKardex.setDisabled(false);
				txtDatOtrosMovInventarioId.setValue(entity.getDatOtrosMovInventarioId());
				txtDatOtrosMovInventarioId.setDisabled(true);
				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);
				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventarioId);

				if (txtAlmacenId_Almacen3 != null) {
					txtAlmacenId_Almacen3.setValue(null);
					txtAlmacenId_Almacen3.setDisabled(false);
				}

				if (txtSaldo != null) {
					txtSaldo.setValue(null);
					txtSaldo.setDisabled(true);
				}

				if (txtInfoAdicional != null) {
					txtInfoAdicional.setValue(null);
					txtInfoAdicional.setDisabled(false);
				}

				if (txtTipoProducto != null) {
					txtTipoProducto.setValue(null);
					txtTipoProducto.setDisabled(false);
				}

				if (txtValorUnit != null) {
					txtValorUnit.setValue(null);
					txtValorUnit.setDisabled(false);
				}

				if (txtPorcentajeIva != null) {
					txtPorcentajeIva.setValue(null);
					txtPorcentajeIva.setDisabled(false);
				}
				if (txtFechaInicial != null) {
					txtFechaInicial.setValue(null);
					txtFechaInicial.setDisabled(false);
				}

				if (txtAlmacenId_Almacen2 != null) {
					txtAlmacenId_Almacen2.setValue(null);
					txtAlmacenId_Almacen2.setDisabled(false);
				}

				if (txtProductoId_Producto != null) {
					txtProductoId_Producto.setValue(null);
					txtProductoId_Producto.setDisabled(false);
				}

				if (fechaVencimiento != null) {
					fechaVencimiento.setValue(null);
					fechaVencimiento.setDisabled(false);
				}

				if (txtUnidadMedida != null) {
					txtUnidadMedida.setValue(null);
					txtUnidadMedida.setDisabled(false);
				}

				if (cantidadCompra != null) {
					cantidadCompra.setValue(null);
					cantidadCompra.setDisabled(false);
				}

				if (loteCompraProducto != null) {
					loteCompraProducto.setValue(null);
					loteCompraProducto.setDisabled(false);
				}

				if (registroIca != null) {
					registroIca.setValue(null);
					registroIca.setDisabled(false);
				}

				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}
				if (txtValorTotalProducto != null) {
					txtValorTotalProducto.setValue(null);
					txtValorTotalProducto.setDisabled(false);
				}

				if (txtConsecutivoPrecioPromedio != null) {
					txtConsecutivoPrecioPromedio.setValue(null);
					txtConsecutivoPrecioPromedio.setDisabled(false);
				}
				if (txtTipoMovimiento != null) {
					txtTipoMovimiento.setValue(null);
					txtTipoMovimiento.setDisabled(false);
				}
				if (txtEquipoId_Equipo != null) {
					txtEquipoId_Equipo.setValue(null);
					txtEquipoId_Equipo.setDisabled(false);
				}
				if (txtNumFacturaPPromedio != null) {
					txtNumFacturaPPromedio.setValue(null);
					txtNumFacturaPPromedio.setDisabled(false);
				}
				if (txtCostoTotalPPromedio != null) {
					txtCostoTotalPPromedio.setValue(null);
					txtCostoTotalPPromedio.setDisabled(false);
				}
				if (txtTrabajadorId_Trabajador != null) {
					txtTrabajadorId_Trabajador.setValue(null);
					txtTrabajadorId_Trabajador.setDisabled(false);
				}

				btnSave.setDisabled(true);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String getLoginSession() throws Exception {

		FacesContext fc = FacesContext.getCurrentInstance();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;
		String passWord = null;

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

	public String action_save() {
		try {
			if ((selectedDatOtrosMovInventario == null) && (entity == null)) {
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

	public String action_saveTraslados() {
		try {
			if ((selectedDatOtrosMovInventario == null) && (entity == null)) {
				action_createTraslados();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_savePrductosInternos() {
		try {
			if ((selectedDatOtrosMovInventario == null) && (entity == null)) {
				action_createProductosInternos();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveSalidasTaller() {
		try {
			if ((selectedDatOtrosMovInventario == null) && (entity == null)) {
				action_createSalidasTaller();
			} else {
				action_modifySalidasTaller();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_createProductosInternos() {
		try {
			entity = new DatOtrosMovInventario();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setCompania(compania);
			entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(compania));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(txtDistribuirCantidad));
			entity.setEstado("A");
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			/*** CONCEPTO PARA SALIDA DE INVENTARIO **/

			entity.setConceptoKardex(businessDelegator2View.getConceptoKardex(7L));

			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -5000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				if (dataDetPrecioProductos2 != null && dataDetPrecioProductos2.size() > 0
						&& dataDetPrecioProductos != null && dataDetPrecioProductos.size() > 0) {

					businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);
					entity.setConceptoKardex((FacesUtils.checkLong(txtConceptoKardex2) != null)
							? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex2))
							: null);

					businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos2);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
							+ (businessDelegator2View.consec_otros_mov_inventario(compania) - 1));
					action_clear();

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!, Verifique que haya completado de manera correcta el paso 1 y el paso 2 ", ""));
					action_clear();
				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

				entity = null;

			}
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create() {
		try {
			entity = new DatOtrosMovInventario();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setCompania(compania);
			entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(compania));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(txtDistribuirCantidad));
			entity.setEstado("A");
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConceptoKardex((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -5000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
						+ (businessDelegator2View.consec_otros_mov_inventario(compania) - 1));

				action_clear();

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

				entity = null;

			}
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_createSalidasTaller() {
		try {
			entity = new DatOtrosMovInventario();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setCompania(compania);
			entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(compania));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(txtDistribuirCantidad));
			entity.setEstado("A");
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConceptoKardex((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);

			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setCategoria((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo) != null)
					? businessDelegatorView.getCategoriaEquipo(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -5000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
				dataEquiposCategoriaDTO = businessDelegator2View.pr_lista_equipo(categoria);
				if (dataEquiposCategoriaDTO != null && dataEquiposCategoriaDTO.size() > 0) {
					businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);

					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
							+ (businessDelegator2View.consec_otros_mov_inventario(compania) - 1));
					action_clear();
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps! La categoría que ha seleccionado para distribuir los productos no tiene máquinas asociadas, la información no sera grabada ",
							""));
				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

				entity = null;

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_createTraslados() {
		try {
			entity = new DatOtrosMovInventario();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setCompania(compania);
			entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(compania));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(txtDistribuirCantidad));
			entity.setEstado("A");
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConceptoKardex((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);

			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -5000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				if (dataDetPrecioProductosEntrada != null && dataDetPrecioProductosEntrada.size() > 0
						&& dataDetPrecioProductos != null && dataDetPrecioProductos.size() > 0) {

					businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);
					entity.setConceptoKardex(businessDelegator2View.getConceptoKardex(9L));
					businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductosEntrada);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
							+ (businessDelegator2View.consec_otros_mov_inventario(compania) - 1));
					action_clear();

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!, Falta registrar y agregar el producto a ser trasladado ", ""));
					action_clear();
				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

				entity = null;

			}
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long datOtrosMovInventarioId = new Long(selectedDatOtrosMovInventario.getDatOtrosMovInventarioId());
				entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventarioId);
			}
			entity = new DatOtrosMovInventario();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setCompania(compania);
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(txtDistribuirCantidad));
			entity.setEstado("A");

			entity.setDatOtrosMovInventarioId(FacesUtils.checkLong(txtDatOtrosMovInventarioId));

			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConceptoKardex((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -5000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				if (dataDetPrecioProductos != null && dataDetPrecioProductos.size() > 0) {

					businessDelegator2View.updateDatOtrosMovInventario(entity, dataDetPrecioProductos);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
					action_clear();

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!, Falta registrar y agregar el producto a ser trasladado ", ""));
					action_clear();
				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

			}
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifySalidasTaller() {
		try {
			if (entity == null) {
				Long datOtrosMovInventarioId = new Long(selectedDatOtrosMovInventario.getDatOtrosMovInventarioId());
				entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventarioId);
			}
			entity = new DatOtrosMovInventario();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setCompania(compania);
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(txtDistribuirCantidad));
			// entity.setEstado(FacesUtils.checkString(txtEstado));

			entity.setDatOtrosMovInventarioId(FacesUtils.checkLong(txtDatOtrosMovInventarioId));

			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConceptoKardex((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setCategoria((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo) != null)
					? businessDelegatorView.getCategoriaEquipo(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -5000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				businessDelegator2View.updateDatOtrosMovInventario(entity, dataDetPrecioProductos);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				action_clear();

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatOtrosMovInventario = (DatOtrosMovInventarioDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosMovInventario"));

			Long datOtrosMovInventarioId = new Long(selectedDatOtrosMovInventario.getDatOtrosMovInventarioId());
			entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventarioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datOtrosMovInventarioId = FacesUtils.checkLong(txtDatOtrosMovInventarioId);
			entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventarioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatOtrosMovInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws Exception {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatOtrosMovInventario = (DatOtrosMovInventarioDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosMovInventario"));

			Long datOtrosMovInventarioId = new Long(selectedDatOtrosMovInventario.getDatOtrosMovInventarioId());
			entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventarioId);
			businessDelegator2View.deleteDatOtrosMovInventario(entity);
			data.remove(selectedDatOtrosMovInventario);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datOtrosMovInventarioId, String detalleNota,
			String distribuirCantidad, String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion,
			Date fechaRegistro, Long numFactura, String observacion, String observacionAnularReg,
			Long usuarioDigitacion, Long conceptoKardexId_ConceptoKardex, Long laborId_Labor, Long persEmprId_PersEmpr)
			throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDetalleNota(FacesUtils.checkString(detalleNota));
			entity.setDistribuirCantidad(FacesUtils.checkString(distribuirCantidad));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(numFactura));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegator2View.updateDatOtrosMovInventario(entity, dataDetPrecioProductos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatOtrosMovInventarioView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
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

	public InputTextarea getTxtDetalleNota() {
		return txtDetalleNota;
	}

	public void setTxtDetalleNota(InputTextarea txtDetalleNota) {
		this.txtDetalleNota = txtDetalleNota;
	}

	public InputText getTxtDistribuirCantidad() {
		return txtDistribuirCantidad;
	}

	public void setTxtDistribuirCantidad(InputText txtDistribuirCantidad) {
		this.txtDistribuirCantidad = txtDistribuirCantidad;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
	}

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
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

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public InputText getTxtDatOtrosMovInventarioId() {
		return txtDatOtrosMovInventarioId;
	}

	public void setTxtDatOtrosMovInventarioId(InputText txtDatOtrosMovInventarioId) {
		this.txtDatOtrosMovInventarioId = txtDatOtrosMovInventarioId;
	}

	public List<DatOtrosMovInventarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatOtrosMovInventario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatOtrosMovInventarioDTO> datOtrosMovInventarioDTO) {
		this.data = datOtrosMovInventarioDTO;
	}

	public DatOtrosMovInventarioDTO getSelectedDatOtrosMovInventario() {
		return selectedDatOtrosMovInventario;
	}

	public void setSelectedDatOtrosMovInventario(DatOtrosMovInventarioDTO datOtrosMovInventario) {
		this.selectedDatOtrosMovInventario = datOtrosMovInventario;
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

	public List<PrecioPromProdDTO> getDataDetPrecioProductos() {

		if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
			return null;
		} else {
			return dataDetPrecioProductos;
		}

	}

	public void action_agregarTraslados() throws Exception {

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && cantidadCompra.getValue() != null
				&& txtAlmacenId_Almacen3.getValue() != null &&
				txtUbicacionesAlmacen.getValue() != null
				) {

			Date date = new Date();
			Date idFecha = FacesUtils.checkDate(txtFechaRegistro);
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);

			Long almacenEntradaId = Long.parseLong(txtAlmacenId_Almacen3.getValue().toString());
			Almacen almacenEntrada = businessDelegatorView.getAlmacen(almacenEntradaId);

			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long conceptoKardexEntradaId = 9L;
			ConceptoKardex conceptoKardexEntrada = businessDelegator2View.getConceptoKardex(conceptoKardexEntradaId);
			String tipoMEntrada = conceptoKardexEntrada.getTipoMovimiento();

			Long ubicacionesAlmacenId = null;
			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";
			if (txtUbicacionesAlmacen.getValue() != null) {
				ubicacionesAlmacenId = Long.parseLong(txtUbicacionesAlmacen.getValue().toString());
				ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
				codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
			}

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);

			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();
			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			Double valorUnit = 0.0;
			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
			Double porcIva = 0.0;
			Double valorIva = 0.0;

			Long compania = new Long(getCompaniaIdSession());

			Double costoTotal = 0.0;

			if (idFecha != null && unidadMedida != null && compania != null && almacenId != null
					&& productoId != null) {
				valorUnit = businessDelegatorView.consultarPrecioPromProducto(productoId, almacenId, compania, idFecha)
						.doubleValue();
				costoTotal = (valorUnit * cantidad_Compra);
			}

			String origenDatos = FacesUtils.checkString(txtOrigenDatos);
			Double saldoProducto = 0.0;
			saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
					.doubleValue();
			String nomProducto = producto.getNombre();

			if (tipoM.equals("SAL")) {
				if (saldoProducto >= cantidad_Compra) {

					boolean existeProducto = false;

					if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
						dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
					}
					if (dataDetPrecioProductosEntrada == null || dataDetPrecioProductosEntrada.size() == 0) {
						dataDetPrecioProductosEntrada = new ArrayList<PrecioPromProdDTO>();
					}

					if (dataDetPrecioProductos.size() > 0) {

						for (PrecioPromProdDTO d : dataDetPrecioProductos) {

							if (d.getProducto().getProductoId() == producto.getProductoId()
									&& d.getUnidadMedida().getUdadMedId() == udadMed.getUdadMedId()
									&& d.getAlmacenId().getAlmacenId() == producto.getAlmacen().getAlmacenId()

							) {

								existeProducto = true;

								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
										FacesMessage.SEVERITY_WARN, "Upps!",
										"El producto seleccionado ya fue agregado a la grid "
												+ "Verifique el codigo del producto y su  unidad de médida asociada "));

								break;
							}
						}

					}

					if (existeProducto == false) {

						PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
						precioPromProdDTO.setNomProducto(nomProducto);
						precioPromProdDTO.setFechaInicial(fechaInicial);
						precioPromProdDTO.setCantidadCompra(cantidad_Compra);
						precioPromProdDTO.setUnidadMedida(udadMed);
						precioPromProdDTO.setAlmacenId(almacen);
						precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
						precioPromProdDTO.setCodAlmacen(codAlmacen);
						precioPromProdDTO.setValorUnitario(valorUnit);
						precioPromProdDTO.setCompania(compania);
						precioPromProdDTO.setFechaCreacion(date);
						precioPromProdDTO.setFechaModificacion(date);
						precioPromProdDTO.setConceptoKardexId(conceptoKardex);
						precioPromProdDTO.setProducto(producto);
						precioPromProdDTO.setCodProducto(codProducto);
						precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
						precioPromProdDTO.setPorcIva(porcIva);
						precioPromProdDTO.setValorIva(valorIva);
						precioPromProdDTO.setCostoTotal(costoTotal);
						precioPromProdDTO.setTipoMovimiento(tipoM);
						precioPromProdDTO.setOrigenDatos(origenDatos);
						precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
						precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);
						dataDetPrecioProductos.add(precioPromProdDTO);

						PrecioPromProdDTO precioPromProdEntradaDTO = new PrecioPromProdDTO();
						precioPromProdEntradaDTO.setFechaInicial(fechaInicial);
						precioPromProdEntradaDTO.setCantidadCompra(cantidad_Compra);
						precioPromProdEntradaDTO.setUnidadMedida(udadMed);
						precioPromProdEntradaDTO.setAlmacenId(almacenEntrada);
						precioPromProdEntradaDTO.setNombreUnidadMedida(codUnidadMed);
						precioPromProdEntradaDTO.setValorUnitario(valorUnit);
						precioPromProdEntradaDTO.setCompania(compania);
						precioPromProdEntradaDTO.setFechaCreacion(date);
						precioPromProdEntradaDTO.setFechaModificacion(date);
						precioPromProdEntradaDTO.setConceptoKardexId(conceptoKardexEntrada);
						precioPromProdEntradaDTO.setProducto(producto);
						precioPromProdEntradaDTO.setCodProducto(codProducto);
						precioPromProdEntradaDTO.setPorcIva(porcIva);
						precioPromProdEntradaDTO.setValorIva(valorIva);
						precioPromProdEntradaDTO.setCostoTotal(costoTotal);
						precioPromProdEntradaDTO.setTipoMovimiento(tipoMEntrada);
						precioPromProdEntradaDTO.setOrigenDatos(origenDatos);
						precioPromProdEntradaDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
						precioPromProdEntradaDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);
						dataDetPrecioProductosEntrada.add(precioPromProdEntradaDTO);

					}
					fechaInicial = null;
					almacenEntrada = null;
					conceptoKardexEntrada = null;
					tipoMEntrada = null;
					almacen = null;
					valorUnit = null;
					codAlmacen = null;
					almacenId = null;
					date = null;
					compania = null;
					cantidad_Compra = null;
					unidadMedida = null;
					conceptoKardex = null;
					producto = null;
					codProducto = null;
					codConceptoKardex = null;
					porcIva = null;
					valorIva = null;
					costoTotal = null;
					tipoM = null;

					ubicacionesAlmacenId = null;
					ubicacionesAlmacen = null;
					codUbicacionesAlmacen = null;

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!",
							"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));
				}
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha, almacén entrada y sálida, ubicación,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
	}

	public DatOtrosMovInventario getEntity() {
		return entity;
	}

	public void setEntity(DatOtrosMovInventario entity) {
		this.entity = entity;
	}

	public Calendar getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Calendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public SelectOneMenu getTxtUnidadMedida() {
		return txtUnidadMedida;
	}

	public void setTxtUnidadMedida(SelectOneMenu txtUnidadMedida) {
		this.txtUnidadMedida = txtUnidadMedida;
	}

	public InputText getLoteCompraProducto() {
		return loteCompraProducto;
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

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
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

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public InputText getTxtCodAlmacen() {
		return txtCodAlmacen;
	}

	public void setTxtCodAlmacen(InputText txtCodAlmacen) {
		this.txtCodAlmacen = txtCodAlmacen;
	}

	public InputText getTxtCodUnidadMedida() {
		return txtCodUnidadMedida;
	}

	public void setTxtCodUnidadMedida(InputText txtCodUnidadMedida) {
		this.txtCodUnidadMedida = txtCodUnidadMedida;
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

	public PrecioPromProd getEntityPrecioProd() {
		return entityPrecioProd;
	}

	public void setEntityPrecioProd(PrecioPromProd entityPrecioProd) {
		this.entityPrecioProd = entityPrecioProd;
	}

	public InputText getTxtValorTotalProducto() {
		return txtValorTotalProducto;
	}

	public void setTxtValorTotalProducto(InputText txtValorTotalProducto) {
		this.txtValorTotalProducto = txtValorTotalProducto;
	}

	public InputText getTxtValorIvaProducto() {
		return txtValorIvaProducto;
	}

	public void setTxtValorIvaProducto(InputText txtValorIvaProducto) {
		this.txtValorIvaProducto = txtValorIvaProducto;
	}

	public InputText getTxtConsecutivoPrecioPromedio() {
		return txtConsecutivoPrecioPromedio;
	}

	public void setTxtConsecutivoPrecioPromedio(InputText txtConsecutivoPrecioPromedio) {
		this.txtConsecutivoPrecioPromedio = txtConsecutivoPrecioPromedio;
	}

	public SelectOneMenu getTxtConceptoKardex() {
		return txtConceptoKardex;
	}

	public void setTxtConceptoKardex(SelectOneMenu txtConceptoKardex) {
		this.txtConceptoKardex = txtConceptoKardex;
	}

	public InputText getTxtTipoMovimiento() {
		return txtTipoMovimiento;
	}

	public void setTxtTipoMovimiento(InputText txtTipoMovimiento) {
		this.txtTipoMovimiento = txtTipoMovimiento;
	}

	public InputText getTxtNumFacturaPPromedio() {
		return txtNumFacturaPPromedio;
	}

	public void setTxtNumFacturaPPromedio(InputText txtNumFacturaPPromedio) {
		this.txtNumFacturaPPromedio = txtNumFacturaPPromedio;
	}

	public InputText getTxtCostoTotalPPromedio() {
		return txtCostoTotalPPromedio;
	}

	public void setTxtCostoTotalPPromedio(InputText txtCostoTotalPPromedio) {
		this.txtCostoTotalPPromedio = txtCostoTotalPPromedio;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtTrabajadorId_Trabajador() {
		return txtTrabajadorId_Trabajador;
	}

	public void setTxtTrabajadorId_Trabajador(SelectOneMenu txtTrabajadorId_Trabajador) {
		this.txtTrabajadorId_Trabajador = txtTrabajadorId_Trabajador;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public void setDataDetPrecioProductos(List<PrecioPromProdDTO> dataDetPrecioProductos) {
		this.dataDetPrecioProductos = dataDetPrecioProductos;
	}

	public InputText getTxtPorcentajeIva() {
		return txtPorcentajeIva;
	}

	public void setTxtPorcentajeIva(InputText txtPorcentajeIva) {
		this.txtPorcentajeIva = txtPorcentajeIva;
	}

	public SelectOneMenu getTxtTipoProducto() {
		return txtTipoProducto;
	}

	public void setTxtTipoProducto(SelectOneMenu txtTipoProducto) {
		this.txtTipoProducto = txtTipoProducto;
	}

	public SelectItem[] getSelectProducto2() {

		if (producto2 == null || producto2.size() == 0) {

			// producto2 = new ArrayList<Producto2>();

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProducto2 = new SelectItem[lista.size()];

				int i = 0;
				for (Producto producto : lista) {
					selectProducto2[i] = new SelectItem(producto.getProductoId(),
							producto.getCodigo() + "-" + producto.getNombre() +"-"+producto.getInfoAdicional()+"-"+producto.getInfoAdicional2());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProducto2;
	}

	public void setSelectProducto2(SelectItem[] selectProducto2) {
		this.selectProducto2 = selectProducto2;
	}

	public SelectItem[] getSelectTipoProducto() {

		if (tipoProducto == null || tipoProducto.size() == 0) {

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

	public SelectItem[] getSelectTipoProducto2() {

		if (tipoProducto2 == null || tipoProducto2.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProducto2 = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto2 : lista) {
					selectTipoProducto2[i] = new SelectItem(tipoProducto2.getTipoProdId(),
							tipoProducto2.getCodigo() + " - " + tipoProducto2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProducto2;
	}

	public void setSelectTipoProducto2(SelectItem[] selectTipoProducto2) {
		this.selectTipoProducto2 = selectTipoProducto2;
	}

	public SelectItem[] getSelectContratista() {

		if (contratista == null || contratista.size() == 0) {
			Date fechaRegistro = null;
			fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);
			// contratista = new ArrayList<PersEmpr>();
			if (fechaRegistro != null) {
				try {

					// Criteria
					Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "=" };
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
		}

		return selectContratista;
	}

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			try {

				// Criteria
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

	public SelectItem[] getSelectUdadMed2() {

		if (udadMed == null || udadMed.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed2 = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed2 : lista) {
					selectUdadMed2[i] = new SelectItem(udadMed2.getUdadMedId(), udadMed2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed2;
	}

	public void setSelectUdadMed2(SelectItem[] selectUdadMed2) {
		this.selectUdadMed2 = selectUdadMed2;
	}

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(),
							equipo.getCodigo() + " - " + equipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipo;
	}

	public void setSelectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public SelectItem[] getSelectAlmacen2() {

		if (almacen2 == null || almacen2.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(),
							almacen2.getCodigo() + " - " + almacen2.getNombre());
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

	public SelectItem[] getSelectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborId : lista) {
					selectLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborId;
	}

	public void setSelectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getSelectConceptoKardex() {

		if (conceptoKardex == null || conceptoKardex.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectConceptoKardex[i] = new SelectItem(conceptoKardex.getConceptoKardexId(),
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex;
	}

	public void setSelectConceptoKardex(SelectItem[] selectConceptoKardex) {
		this.selectConceptoKardex = selectConceptoKardex;
	}

	public SelectItem[] getSelectConceptoKardex1() {

		if (selectConceptoKardex1 == null || selectConceptoKardex1.length == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoMovimiento", true, "SAL", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex1 = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex1 : lista) {
					selectConceptoKardex1[i] = new SelectItem(conceptoKardex1.getConceptoKardexId(),
							conceptoKardex1.getCodigo() + " - " + conceptoKardex1.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex1;
	}

	public void setSelectConceptoKardex1(SelectItem[] selectConceptoKardex1) {
		this.selectConceptoKardex1 = selectConceptoKardex1;
	}

	public SelectItem[] getSelectConceptoKardex2() {

		if (conceptoKardex2 == null || conceptoKardex2.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoMovimiento", true, "ENT", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex2 = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex2 : lista) {
					selectConceptoKardex2[i] = new SelectItem(conceptoKardex2.getConceptoKardexId(),
							conceptoKardex2.getCodigo() + " - " + conceptoKardex2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex2;
	}

	public void setSelectConceptoKardex2(SelectItem[] selectConceptoKardex2) {
		this.selectConceptoKardex2 = selectConceptoKardex2;
	}

	public void listener_ConsultaUmProducto() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		Long productoId = null;
		Long almacenId = null;
		if (txtProductoId_Producto.getValue() != null) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			if (txtAlmacenId_Almacen2.getValue() != null) {
				almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			}

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				if (producto.getUdadMedByUdadMedProd() != null) {
					txtUnidadMedida.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				}
				if (producto.getUbicacionesAlmacenId() != null) {
					txtUbicacionesAlmacen.setValue(producto.getUbicacionesAlmacenId().getUbicacionesAlmacenId());
				}
				Double saldoProducto = 0.0;
				saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
						.doubleValue();
				txtSaldo.setValue(saldoProducto);
				txtSaldo.setDisabled(true);
				txtUnidadMedida.setDisabled(true);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaUmProducto2() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		Long productoId = null;
		Long almacenId = null;
		Long unidadMedida = null;
		Double valorUnit = 0.0;
		Double saldoProducto = 0.0;
		Date idFecha = FacesUtils.checkDate(txtFechaRegistro);
		if (txtProductoId_Producto.getValue() != null) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			if (txtAlmacenId_Almacen2.getValue() != null) {
				almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			}

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				if (producto.getUdadMedByUdadMedProd() != null) {
					txtUnidadMedida.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
					unidadMedida = producto.getUdadMedByUdadMedProd().getUdadMedId();
				}

				if (idFecha != null && unidadMedida != null && compania != null && almacenId != null
						&& productoId != null) {
					valorUnit = businessDelegatorView
							.consultarPrecioPromProducto(productoId, almacenId, compania, idFecha).doubleValue();

				}
				if (producto.getUbicacionesAlmacenId() != null) {
					Long idUbicacion = producto.getUbicacionesAlmacenId().getUbicacionesAlmacenId();
					txtUbicacionesAlmacen.setValue(idUbicacion);

				}

				saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania);
				valorUnit = (double) (Math.round(valorUnit * 100) / 100);
				txtValorUnit.setValue(valorUnit);
				txtSaldo.setValue(saldoProducto);
				txtSaldo.setDisabled(true);
				txtUnidadMedida.setDisabled(true);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaUmProducto3() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		Long productoId = null;
		Long almacenId = null;
		Long unidadMedida = null;
		Double valorUnit = 0.0;
		Double saldoProducto = 0.0;
		Date idFecha = FacesUtils.checkDate(txtFechaRegistro);
		if (txtProductoId_Producto2.getValue() != null) {
			productoId = Long.parseLong(txtProductoId_Producto2.getValue().toString());
			if (txtAlmacenId_Almacen3.getValue() != null) {
				almacenId = Long.parseLong(txtAlmacenId_Almacen3.getValue().toString());
			}

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				if (producto.getUdadMedByUdadMedProd() != null) {
					txtUnidadMedida2.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
					unidadMedida = producto.getUdadMedByUdadMedProd().getUdadMedId();
				}

				if (idFecha != null && unidadMedida != null && compania != null && almacenId != null
						&& productoId != null) {
					valorUnit = businessDelegatorView
							.consultarPrecioPromProducto(productoId, almacenId, compania, idFecha).doubleValue();

				}
				if (producto.getUbicacionesAlmacenId() != null) {
					Long idUbicacion = producto.getUbicacionesAlmacenId().getUbicacionesAlmacenId();
					txtUbicacionesAlmacen2.setValue(idUbicacion);

				}

				saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania);
				valorUnit = (double) (Math.round(valorUnit * 100) / 100);

				txtSaldo2.setValue(saldoProducto);
				txtSaldo2.setDisabled(true);
				txtUnidadMedida2.setDisabled(true);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		Long datOtrosMovInventario = FacesUtils.checkLong(txtDatOtrosMovInventarioId);
		// if (datOtrosMovInventario != null) {
		selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
				.get("selectedPrecioProductos"));

		Long precioProdId = selectedPrecioProductos.getPrecioProdId().longValue();

		String columnaCell = evt.getColumn().getHeaderText();

		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityPrecioProd = null;
			entityPrecioProd = businessDelegatorView.getPrecioPromProd(precioProdId);

			if (columnaCell.equals("Fecha")) {

				entityPrecioProd.setFechaInicial((Date) newValue);

			} else if (columnaCell.equals("Almacen")) {

				Long almacenId = new Long(evt.getNewValue().toString());
				Almacen e = businessDelegatorView.getAlmacen(almacenId);

				entityPrecioProd.setAlmacenId(e);

			} else if (columnaCell.equals("Prod.")) {

				Long productoId = new Long(evt.getNewValue().toString());
				Producto e = businessDelegatorView.getProducto(productoId);

				entityPrecioProd.setProducto(e);

			} else if (columnaCell.equals("U.M.")) {

				Long umId = new Long(evt.getNewValue().toString());
				UdadMed e = businessDelegatorView.getUdadMed(umId);

				entityPrecioProd.setUnidadMedida(e);

			} else if (columnaCell.equals("Cant.")) {

				entityPrecioProd.setCantidadCompra(Double.valueOf(evt.getNewValue().toString()));
				Double cantidad = Double.valueOf(evt.getNewValue().toString());
				Double valorUnitario = entityPrecioProd.getValorUnitario();
				Double valorTotal = cantidad * valorUnitario;
				entityPrecioProd.setCostoTotal(valorTotal);

			} else if (columnaCell.equals("Hór. Tanqueo")) {

				entityPrecioProd.setHorometro_abastecimiento(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Precio")) {

				entityPrecioProd.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));

				Double valorUnitario = Double.valueOf(evt.getNewValue().toString());
				Double cantidad = entityPrecioProd.getCantidadCompra();
				Double valorTotal = cantidad * valorUnitario;
				entityPrecioProd.setCostoTotal(valorTotal);

			} else if (columnaCell.equals("Iva")) {

				entityPrecioProd.setValorIva(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("VR. Total")) {

				entityPrecioProd.setCostoTotal(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Maq")) {

				Long maqId = new Long(evt.getNewValue().toString());
				Equipo e = businessDelegatorView.getEquipo(maqId);

				entityPrecioProd.setEquipoId(e);

			} else if (columnaCell.equals("Implemento")) {

				Long impelemto = new Long(evt.getNewValue().toString());
				Equipo i = businessDelegatorView.getEquipo(impelemto);

				entityPrecioProd.setImplementoId(i);

			} /*
				 * else if (columnaCell.equals("Hacienda")) {
				 * 
				 * Long nivel2Id = new Long(evt.getNewValue().toString()); Nivel2 nivel2 =
				 * businessDelegatorView.getNivel2(nivel2Id);
				 * 
				 * entityPrecioProd.setNivel2Id(nivel2);
				 * 
				 * } else if (columnaCell.equals("Suerte")) {
				 * 
				 * Long nivel4Id = new Long(evt.getNewValue().toString()); Nivel4 nivel4 =
				 * businessDelegatorView.getNivel4(nivel4Id);
				 * 
				 * entityPrecioProd.setNivel4Id(nivel4);
				 * 
				 * }
				 **/ else if (columnaCell.equals("Ubicaciones")) {

				Long ubAlmacen = new Long(evt.getNewValue().toString());
				UbicacionesAlmacen e = businessDelegator2View.getUbicacionesAlmacen(ubAlmacen);

				entityPrecioProd.setUbicacionesAlmacen(e);
			}

			entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventario);
			entityPrecioProd.setDatOtrosMovInventarioId(entity);
			businessDelegatorView.updatePrecioPromProd(entityPrecioProd);

			selectedPrecioProductos = null;
			entityPrecioProd = null;

			dataDetPrecioProductos = null;
			dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventario);

			/*
			 * } else { FacesContext.getCurrentInstance().addMessage(null, new
			 * FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
			 * "Para poder modificar la información, primero los datos deben estar grabados. "
			 * )); }
			 */
		}

	}

	public void onCellEditEventos2(CellEditEvent evt) throws Exception {

		Long datOtrosMovInventario = FacesUtils.checkLong(txtDatOtrosMovInventarioId);
		// if (datOtrosMovInventario != null) {
		selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
				.get("selectedPrecioProductos"));

		Long precioProdId = selectedPrecioProductos.getPrecioProdId().longValue();

		String columnaCell = evt.getColumn().getHeaderText();

		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityPrecioProd = null;
			entityPrecioProd = businessDelegatorView.getPrecioPromProd(precioProdId);

			if (columnaCell.equals("Fecha")) {

				entityPrecioProd.setFechaInicial((Date) newValue);

			} else if (columnaCell.equals("Almacen")) {

				Long almacenId = new Long(evt.getNewValue().toString());
				Almacen e = businessDelegatorView.getAlmacen(almacenId);

				entityPrecioProd.setAlmacenId(e);

			} else if (columnaCell.equals("Prod.")) {

				Long productoId = new Long(evt.getNewValue().toString());
				Producto e = businessDelegatorView.getProducto(productoId);

				entityPrecioProd.setProducto(e);

			} else if (columnaCell.equals("U.M.")) {

				Long umId = new Long(evt.getNewValue().toString());
				UdadMed e = businessDelegatorView.getUdadMed(umId);

				entityPrecioProd.setUnidadMedida(e);

			} else if (columnaCell.equals("Cant.")) {

				entityPrecioProd.setCantidadCompra(Double.valueOf(evt.getNewValue().toString()));
				Double cantidad = Double.valueOf(evt.getNewValue().toString());
				Double valorUnitario = entityPrecioProd.getValorUnitario();
				Double valorTotal = cantidad * valorUnitario;
				entityPrecioProd.setCostoTotal(valorTotal);

			} else if (columnaCell.equals("Hór. Tanqueo")) {

				entityPrecioProd.setHorometro_abastecimiento(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Precio")) {

				entityPrecioProd.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));

				Double valorUnitario = Double.valueOf(evt.getNewValue().toString());
				Double cantidad = entityPrecioProd.getCantidadCompra();
				Double valorTotal = cantidad * valorUnitario;
				entityPrecioProd.setCostoTotal(valorTotal);

			} else if (columnaCell.equals("Iva")) {

				entityPrecioProd.setValorIva(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("VR. Total")) {

				entityPrecioProd.setCostoTotal(Double.valueOf(evt.getNewValue().toString()));

			} else if (columnaCell.equals("Maq")) {

				Long maqId = new Long(evt.getNewValue().toString());
				Equipo e = businessDelegatorView.getEquipo(maqId);

				entityPrecioProd.setEquipoId(e);

			} /*
				 * else if (columnaCell.equals("Hacienda")) {
				 * 
				 * Long nivel2Id = new Long(evt.getNewValue().toString()); Nivel2 nivel2 =
				 * businessDelegatorView.getNivel2(nivel2Id);
				 * 
				 * entityPrecioProd.setNivel2Id(nivel2);
				 * 
				 * } else if (columnaCell.equals("Suerte")) {
				 * 
				 * Long nivel4Id = new Long(evt.getNewValue().toString()); Nivel4 nivel4 =
				 * businessDelegatorView.getNivel4(nivel4Id);
				 * 
				 * entityPrecioProd.setNivel4Id(nivel4);
				 * 
				 * }
				 **/ else if (columnaCell.equals("Ubicaciones")) {

				Long ubAlmacen = new Long(evt.getNewValue().toString());
				UbicacionesAlmacen e = businessDelegator2View.getUbicacionesAlmacen(ubAlmacen);

				entityPrecioProd.setUbicacionesAlmacen(e);
			} else if (columnaCell.equals("Implemento")) {

				Long impelemto = new Long(evt.getNewValue().toString());
				Equipo i = businessDelegatorView.getEquipo(impelemto);

				entityPrecioProd.setImplementoId(i);

			}

			entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventario);
			entityPrecioProd.setDatOtrosMovInventarioId(entity);
			businessDelegatorView.updatePrecioPromProd(entityPrecioProd);

			selectedPrecioProductos = null;
			entityPrecioProd = null;

			dataDetPrecioProductos = null;
			dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventario);

			/*
			 * } else { FacesContext.getCurrentInstance().addMessage(null, new
			 * FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
			 * "Para poder modificar la información, primero los datos deben estar grabados. "
			 * )); }
			 */
		}

	}

	public InputText getCantidadCompra() {
		return cantidadCompra;
	}

	public void setCantidadCompra(InputText cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public String actionDeletePrecioPromProd(ActionEvent evt) {
		try {

			selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioProductos"));

			if (selectedPrecioProductos.getPrecioProdId() == null) {
				dataDetPrecioProductos.remove(selectedPrecioProductos);
			} else {
				Long datPrecioPromProdId = new Long(selectedPrecioProductos.getPrecioProdId());
				PrecioPromProd entity = businessDelegatorView.getPrecioPromProd(datPrecioPromProdId);
				businessDelegatorView.deletePrecioPromProd(entity);
				dataDetPrecioProductos.remove(selectedPrecioProductos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeletePrecioPromProd2(ActionEvent evt) {
		try {

			selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioProductos"));

			if (selectedPrecioProductos.getPrecioProdId() == null) {
				dataDetPrecioProductos2.remove(selectedPrecioProductos);
			} else {
				Long datPrecioPromProdId = new Long(selectedPrecioProductos.getPrecioProdId());
				PrecioPromProd entity = businessDelegatorView.getPrecioPromProd(datPrecioPromProdId);
				businessDelegatorView.deletePrecioPromProd(entity);
				dataDetPrecioProductos2.remove(selectedPrecioProductos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public SelectItem[] getSelectAlmacen3() {

		if (almacen3 == null || almacen3.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen3 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen3 : lista) {
					selectAlmacen3[i] = new SelectItem(almacen3.getAlmacenId(),
							almacen3.getCodigo() + " - " + almacen3.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen3;
	}

	public void setSelectAlmacen3(SelectItem[] selectAlmacen3) {
		this.selectAlmacen3 = selectAlmacen3;
	}

	public InputText getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(InputText txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen3() {
		return txtAlmacenId_Almacen3;
	}

	public void setTxtAlmacenId_Almacen3(SelectOneMenu txtAlmacenId_Almacen3) {
		this.txtAlmacenId_Almacen3 = txtAlmacenId_Almacen3;
	}

	public void setDataDetPrecioProductosEntrada(List<PrecioPromProdDTO> dataDetPrecioProductosEntrada) {
		this.dataDetPrecioProductosEntrada = dataDetPrecioProductosEntrada;
	}
	public void limpiar_pantalla4() {
		txtEquipoId_Equipo.setValue(null);
		txtProductoId_Producto.setValue(null);
		// txtAlmacenId_Almacen2.setValue(null);
		txtSaldo.setValue(null);
		// txtValorUnit.setValue(null);

		txtUnidadMedida.setValue(null);
		txtHorometroAbastecimiento.setValue(null);
	 
		 txtImplemento.setValue(null);
		txtInfoAdicional.setValue(null);
		txtLaborId_Labor.setValue(null);
		

	}
	public void limpiar_pantalla() {
		// txtTipoProducto.setValue(null);
		txtProductoId_Producto.setValue(null);
		// txtAlmacenId_Almacen2.setValue(null);
		txtSaldo.setValue(null);
		// txtValorUnit.setValue(null);
		cantidadCompra.setValue(null);
		txtUnidadMedida.setValue(null);
		txtHorometroAbastecimiento.setValue(null);
		// txtNivel2Id_Nivel2.setValue(null);
		// txtNivel4Id_Nivel4.setValue(null);
		// lotes=null;
		equipos = null;
		selectEquipo = null;
		txtInfoAdicional.setValue(null);
		txtLaborId_Labor.setValue(null);
		

	}

	public void limpiar_pantalla2() {
		txtSaldo.setValue(null);
		// txtTipoProducto.setValue(null);
		txtProductoId_Producto.setValue(null);
		txtAlmacenId_Almacen2.setValue(null);
		// txtValorUnit.setValue(null);
		lotes = null;
		txtNivel2Id_Nivel2.setValue(null);
		cantidadCompra.setValue(null);
		txtUnidadMedida.setValue(null);
		// txtEquipoId_Equipo.setValue(null);
		// txtInfoAdicional.setValue(null);
		// txtLaborId_Labor.setValue(null);
	}

	public SelectOneMenu getTxtCategEquipId_CategoriaEquipo() {
		return txtCategEquipId_CategoriaEquipo;
	}

	public void setTxtCategEquipId_CategoriaEquipo(SelectOneMenu txtCategEquipId_CategoriaEquipo) {
		this.txtCategEquipId_CategoriaEquipo = txtCategEquipId_CategoriaEquipo;
	}

	public SelectItem[] getselectCategoriaEquipo() {

		if (categoriaEquipo == null || categoriaEquipo.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CategoriaEquipo> lista = businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null,
						null);
				selectCategoriaEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CategoriaEquipo categoriaEquipo : lista) {
					selectCategoriaEquipo[i] = new SelectItem(categoriaEquipo.getCategEquipId(),
							categoriaEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCategoriaEquipo;
	}

	public void setselectCategoriaEquipo(SelectItem[] selectCategoriaEquipo) {
		this.selectCategoriaEquipo = selectCategoriaEquipo;
	}

	public Calendar getTxtFechaIni() {
		return txtFechaIni;
	}

	public void setTxtFechaIni(Calendar txtFechaIni) {
		this.txtFechaIni = txtFechaIni;
	}

	public Calendar getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(Calendar txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}

	public void listarMovimientosInventario() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));

			fechaFinal = FacesUtils.checkDate(txtFechaFin);

			// String zona = "1";
			Long documento = 0L;
			documento = FacesUtils.checkLong(txtDocumentoC);

			Long equipoId = 0L;
			if (txtEquipoConsulta.getValue() != null) {
				equipoId = FacesUtils.checkLong(txtEquipoConsulta);
			}

			if (documento == null) {
				documento = 0L;
			}
			Long compania = new Long(getCompaniaIdSession());

			Long centCost = 0L;
			centCost = FacesUtils.checkLong(txtCentCostConsulta);

			if (centCost == null) {
				centCost = 0L;
			}
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_lista_otros_mov_productos(compania, fechaInicial, fechaFinal,
						documento, equipoId, centCost);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public InputText getTxtDocumentoC() {
		return txtDocumentoC;
	}

	public void setTxtDocumentoC(InputText txtDocumentoC) {
		this.txtDocumentoC = txtDocumentoC;
	}

	public List<ConsultaOtrosMovimientosInventarioDTO> getData2() {
		return data2;
	}

	public void setData2(List<ConsultaOtrosMovimientosInventarioDTO> data2) {
		this.data2 = data2;
	}

	public SelectItem[] getSelectProductoId() throws NumberFormatException, Exception {
		if (txtTipoProducto.getValue() != null) {
			//
			// if (productoId == null || productoId.size() == 0) {

			Long idCompania = new Long(getCompaniaIdSession());
			Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
			try {
				// List<CatalogProductoDTO> lista = null;
				List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania,
						tipoProducto);
				selectProductoId = new SelectItem[lista.size()];
				/*
				 * int i = 0; for (CatalogProductoDTO catalogProductoDTO : lista) {
				 * selectProductoId[i] = new
				 * SelectItem(catalogProductoDTO.getProductoId().longValue(),
				 * catalogProductoDTO.getCodigo()+"-"+ catalogProductoDTO.getNombre()
				 * 
				 * ); i++;
				 * 
				 * }
				 */

				for (int j = 0; j < lista.size(); j++) {
					selectProductoId[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
							lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoId;
	}

	public void setSelectProductoId(SelectItem[] selectProductoId) {
		this.selectProductoId = selectProductoId;
	}

	public SelectItem[] getSelectProductoId2() throws NumberFormatException, Exception {
		if (txtTipoProducto2.getValue() != null) {

			Long idCompania = new Long(getCompaniaIdSession());
			Long tipoProducto = FacesUtils.checkLong(txtTipoProducto2);
			try {
				// List<CatalogProductoDTO> lista = null;
				List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania,
						tipoProducto);
				selectProductoId2 = new SelectItem[lista.size()];

				for (int j = 0; j < lista.size(); j++) {
					selectProductoId2[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
							lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoId2;
	}

	public void setSelectProductoId2(SelectItem[] selectProductoId2) {
		this.selectProductoId2 = selectProductoId2;
	}

	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {
						Long borrarDetalle = businessDelegator2View
								.pr_borrar_dat_otros_movimientos_detalle(datOtrosMovInventarioId);
						Long borrarGeneral = businessDelegator2View
								.pr_borrar_dat_otros_movimientos(datOtrosMovInventarioId);
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Proceso exitoso!", "El movimiento de compra fue eliminado exitosamente!!!"));

					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!",
								"Para poder eliminar el movimiento de compra debe tener permisos de administrador "));

					}
				}
				setShowDialog(true);

				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectItem[] getSelectNivel2() {

		if (nivel2 == null || nivel2.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2 : lista) {
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(),
							nivel2.getCodigo() + " - " + nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2;
	}

	public void setSelectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	public SelectOneMenu getTxtNivel2Id_Nivel2() {
		return txtNivel2Id_Nivel2;
	}

	public void setTxtNivel2Id_Nivel2(SelectOneMenu txtNivel2Id_Nivel2) {
		this.txtNivel2Id_Nivel2 = txtNivel2Id_Nivel2;
	}

	public SelectItem[] getSelectNivel4() {

		if (selectNivel4 == null || selectNivel4.length == 0) {

			try {

				Long compania = new Long(getCompaniaIdSession());
				String nivel2Id = FacesUtils.checkString(txtNivel2Id_Nivel2);
				List<ListaNivel4DTO> lista = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
				selectNivel4 = new SelectItem[lista.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : lista) {
					selectNivel4[i] = new SelectItem(nivel4.getNivel4_id(),
							nivel4.getCod_nivel4() + " - " + nivel4.getNom_nivel4());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4;
	}

	public void setSelectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public InputText getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(InputText txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public void setLotes(List<ListaNivel4DTO> lotes) {
		this.lotes = lotes;
	}

	public List<String> getSelectedLotes() {
		return selectedLotes;
	}

	public void setSelectedLotes(List<String> selectedLotes) {
		this.selectedLotes = selectedLotes;
	}

	@SuppressWarnings("unlikely-arg-type")
	public List<ListaNivel4DTO> getLotes() {

		if (txtNivel2Id_Nivel2 != null && txtNivel2Id_Nivel2.getValue() != null) {
			String nivel2Id = FacesUtils.checkString(txtNivel2Id_Nivel2);

			try {
				// Object[] condicion = { "estado", true, "A", "=", "nivel3.nivel3Id", true,
				// nivel3Id, "=" };
				Long compania = new Long(getCompaniaIdSession());
				lotes = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return lotes;
	}

	public void action_agregarPrecioProductosMaquinaria() throws Exception {

		if (txtProductoId_Producto.getValue() != null && txtAlmacenId_Almacen2.getValue() != null
				&& txtUnidadMedida.getValue() != null && txtFechaRegistro.getValue() != null
				&& txtValorUnit.getValue() != null && cantidadCompra.getValue() != null
				&& txtPorcentajeIva.getValue() != null) {

			Date date = new Date();
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);

			Long persEmprId = null;
			PersEmpr persEmpr = null;
			String codPersEmpr = "";
			if (txtPersEmpr.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmpr.getValue().toString());
				persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				codPersEmpr = persEmpr.getCodigo();

			}

			Long ubicacionesAlmacenId = null;
			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";
			if (txtUbicacionesAlmacen.getValue() != null) {
				ubicacionesAlmacenId = Long.parseLong(txtUbicacionesAlmacen.getValue().toString());
				ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
				codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
			}

			Long equipoId = null;
			Equipo equipo = null;
			String codEquipo = "";
			Long indicador_vuelta_medidor = 0L;

			if (txtEquipoId_Equipo.getValue() != null) {
				equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
				equipo = businessDelegatorView.getEquipo(equipoId);
				codEquipo = equipo.getCodigo();
				if (equipo.getIndicador_vuelta_medidor() != null) {
					indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
				}
			}
			String nombreImplemento = "";
			Long implementoId = null;
			Equipo implemento = null;
			if (txtImplemento.getValue() != null) {
				implementoId = Long.parseLong(txtImplemento.getValue().toString());
				implemento = businessDelegatorView.getEquipo(implementoId);
				nombreImplemento = implemento.getCodigo() + "-" + implemento.getNombre();
			}

			Double horometroAbastecimiento = FacesUtils.checkDouble(txtHorometroAbastecimiento);

			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			/*
			 * Long trabId =null; Trabajador trabajador = null; String codTrabajador ="";
			 * if(txtTrabajadorId_Trabajador !=null){ trabId =
			 * Long.parseLong(txtTrabajadorId_Trabajador.getValue().toString()); trabajador
			 * = businessDelegatorView.getTrabajador(trabId); codTrabajador =
			 * trabajador.getCodigo(); }
			 */
			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();

			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			// String fechaInicialFormat = dmyFormat.format(fechaInicial);
			Double valorUnit = 0.0;
			if (txtValorUnit.getValue() != null) {
				valorUnit = FacesUtils.checkDouble(txtValorUnit);
			}
			// Date fecha_Vencimiento =
			// (FacesUtils.checkDate(fechaVencimiento));
			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
			Double porcIva = 0.0;
			Double valorIva = 0.0;
			if (txtPorcentajeIva.getValue() != null) {
				porcIva = FacesUtils.checkDouble(txtPorcentajeIva);
				valorIva = (porcIva / 100) * valorUnit * cantidad_Compra;
			}

			Double costoTotal = (valorUnit * cantidad_Compra) + valorIva;
			// String tipoM = FacesUtils.checkString(txtTipoMovimiento);
			Long numFactura = null;
			if (txtNumFactura.getValue() != null) {
				numFactura = FacesUtils.checkLong(txtNumFactura);
			}
			// String fechaVencimientoFormat =
			// dmyFormat.format(fecha_Vencimiento);
			/*
			 * String loteCompra =""; String registro_ica="";
			 * if(loteCompraProducto.getValue() !=null){ loteCompra =
			 * FacesUtils.checkString(loteCompraProducto); }
			 * if(registroIca.getValue()!=null){ registro_ica =
			 * FacesUtils.checkString(registroIca); }
			 * 
			 * String infoAdicional =""; if(txtInfoAdicional.getValue() !=null){
			 * infoAdicional = FacesUtils.checkString(txtInfoAdicional); }
			 */
			// Long consecutivo = FacesUtils.checkLong(txtConsecutivo);

			Long compania = new Long(getCompaniaIdSession());

			boolean existeProducto = false;

			Double saldoProducto = 0.0;
			saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
					.doubleValue();

			String nomProducto = producto.getNombre();
			if (tipoM.equals("SAL")) {
				if (saldoProducto >= cantidad_Compra) {

					if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
						dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
					}

					PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
					precioPromProdDTO.setNomProducto(nomProducto);
					precioPromProdDTO.setFechaInicial(fechaInicial);
					precioPromProdDTO.setCantidadCompra(cantidad_Compra);
					precioPromProdDTO.setUnidadMedida(udadMed);
					precioPromProdDTO.setAlmacenId(almacen);
					precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
					precioPromProdDTO.setCodAlmacen(codAlmacen);
					precioPromProdDTO.setValorUnitario(valorUnit);
					precioPromProdDTO.setCompania(compania);
					precioPromProdDTO.setFechaCreacion(date);
					precioPromProdDTO.setFechaModificacion(date);
					precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
					precioPromProdDTO.setCodPersEmpr(codPersEmpr);
					precioPromProdDTO.setEquipoId(equipo);
					precioPromProdDTO.setConceptoKardexId(conceptoKardex);
					precioPromProdDTO.setProducto(producto);
					precioPromProdDTO.setCodProducto(codProducto);
					precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
					precioPromProdDTO.setPorcIva(porcIva);
					precioPromProdDTO.setValorIva(valorIva);
					precioPromProdDTO.setCostoTotal(costoTotal);
					precioPromProdDTO.setTipoMovimiento(tipoM);
					precioPromProdDTO.setNumFacturaCompra(numFactura);
					precioPromProdDTO.setCodEquipo(codEquipo);
					precioPromProdDTO.setHorometro_abastecimiento(horometroAbastecimiento);
					precioPromProdDTO.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
					precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
					precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

					precioPromProdDTO.setCodImplemento(nombreImplemento);

					precioPromProdDTO.setImplementoId(implementoId);

					dataDetPrecioProductos.add(precioPromProdDTO);
					indicador_vuelta_medidor = null;
					// infoAdicional = null;
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
					// loteCompra = null;
					// registro_ica = null;
					persEmpr = null;
					codPersEmpr = null;
					equipo = null;
					conceptoKardex = null;
					producto = null;
					// trabajador = null;
					codProducto = null;
					// codTrabajador = null;
					codConceptoKardex = null;
					porcIva = null;
					valorIva = null;
					costoTotal = null;
					tipoM = null;
					numFactura = null;
					horometroAbastecimiento = null;

					ubicacionesAlmacenId = null;
					ubicacionesAlmacen = null;
					codUbicacionesAlmacen = null;

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps! Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. ",
							""));

				}
			} else {

				if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
					dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
				}

				PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
				precioPromProdDTO.setFechaInicial(fechaInicial);
				precioPromProdDTO.setNomProducto(nomProducto);
				// precioPromProdDTO.setFechaVencimiento(fecha_Vencimiento);
				precioPromProdDTO.setCantidadCompra(cantidad_Compra);
				precioPromProdDTO.setUnidadMedida(udadMed);
				// precioPromProdDTO.setLoteCompraProducto(loteCompra);
				// precioPromProdDTO.setRegistroIca(registro_ica);
				precioPromProdDTO.setAlmacenId(almacen);
				precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
				precioPromProdDTO.setCodAlmacen(codAlmacen);
				precioPromProdDTO.setValorUnitario(valorUnit);
				precioPromProdDTO.setCompania(compania);
				precioPromProdDTO.setFechaCreacion(date);
				precioPromProdDTO.setFechaModificacion(date);
				precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
				precioPromProdDTO.setCodPersEmpr(codPersEmpr);
				precioPromProdDTO.setEquipoId(equipo);
				precioPromProdDTO.setConceptoKardexId(conceptoKardex);
				precioPromProdDTO.setProducto(producto);
				// precioPromProdDTO.setTrabajador(trabajador);
				precioPromProdDTO.setCodProducto(codProducto);
				// precioPromProdDTO.setCodTrabajador(codTrabajador);
				precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
				precioPromProdDTO.setPorcIva(porcIva);
				precioPromProdDTO.setValorIva(valorIva);
				precioPromProdDTO.setCostoTotal(costoTotal);
				precioPromProdDTO.setTipoMovimiento(tipoM);
				precioPromProdDTO.setNumFacturaCompra(numFactura);
				// precioPromProdDTO.setInfoAdicional(infoAdicional);
				precioPromProdDTO.setCodEquipo(codEquipo);
				precioPromProdDTO.setHorometro_abastecimiento(horometroAbastecimiento);
				precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
				precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

				precioPromProdDTO.setCodImplemento(nombreImplemento);
				precioPromProdDTO.setImplementoId(implementoId);
				dataDetPrecioProductos.add(precioPromProdDTO);

				// infoAdicional = null;
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
				// loteCompra = null;
				// registro_ica = null;
				persEmpr = null;
				codPersEmpr = null;
				equipo = null;
				conceptoKardex = null;
				producto = null;
				// trabajador = null;
				codProducto = null;
				// codTrabajador = null;
				codConceptoKardex = null;
				porcIva = null;
				valorIva = null;
				costoTotal = null;
				tipoM = null;
				numFactura = null;
				horometroAbastecimiento = null;

				ubicacionesAlmacenId = null;
				ubicacionesAlmacen = null;
				codUbicacionesAlmacen = null;
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Upps!, Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. ",
					""));
		}
	}

	public void action_agregarProductosInternos() throws Exception {

		if (txtProductoId_Producto2.getValue() != null && txtAlmacenId_Almacen3.getValue() != null
				&& txtUnidadMedida2.getValue() != null && txtFechaRegistro.getValue() != null
				&& cantidadCompra2.getValue() != null && txtConceptoKardex2.getValue() != null) {

			Date date = new Date();
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen3.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida2.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);

			Long persEmprId = null;
			PersEmpr persEmpr = null;
			String codPersEmpr = "";
			if (txtPersEmpr.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmpr.getValue().toString());
				persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				codPersEmpr = persEmpr.getCodigo();

			}

			Long ubicacionesAlmacenId = null;
			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";
			if (txtUbicacionesAlmacen2.getValue() != null) {
				ubicacionesAlmacenId = Long.parseLong(txtUbicacionesAlmacen2.getValue().toString());
				ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
				codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
			}

			Long equipoId = null;
			Equipo equipo = null;
			String codEquipo = "";
			Long indicador_vuelta_medidor = 0L;

			Long conceptoKardexId = Long.parseLong(txtConceptoKardex2.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto2.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			/*
			 * Long trabId =null; Trabajador trabajador = null; String codTrabajador ="";
			 * if(txtTrabajadorId_Trabajador !=null){ trabId =
			 * Long.parseLong(txtTrabajadorId_Trabajador.getValue().toString()); trabajador
			 * = businessDelegatorView.getTrabajador(trabId); codTrabajador =
			 * trabajador.getCodigo(); }
			 */
			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();

			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			// String fechaInicialFormat = dmyFormat.format(fechaInicial);
			Double valorUnit = 0.0;
			Double costoTotal = 0.0;
			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra2);
			if (costoTotalProductoFormula != null) {
				costoTotal = costoTotalProductoFormula;
				if (cantidad_Compra > 0) {
					valorUnit = (costoTotal / cantidad_Compra);
				}
			}

			// Date fecha_Vencimiento =
			// (FacesUtils.checkDate(fechaVencimiento));

			Double porcIva = 0.0;
			Double valorIva = 0.0;

			// String tipoM = FacesUtils.checkString(txtTipoMovimiento);
			Long numFactura = null;
			if (txtNumFactura.getValue() != null) {
				numFactura = FacesUtils.checkLong(txtNumFactura);
			}
			// String fechaVencimientoFormat =
			// dmyFormat.format(fecha_Vencimiento);
			/*
			 * String loteCompra =""; String registro_ica="";
			 * if(loteCompraProducto.getValue() !=null){ loteCompra =
			 * FacesUtils.checkString(loteCompraProducto); }
			 * if(registroIca.getValue()!=null){ registro_ica =
			 * FacesUtils.checkString(registroIca); }
			 * 
			 * String infoAdicional =""; if(txtInfoAdicional.getValue() !=null){
			 * infoAdicional = FacesUtils.checkString(txtInfoAdicional); }
			 */
			// Long consecutivo = FacesUtils.checkLong(txtConsecutivo);

			String cadereferenciaCompraMp = "";
			/*
			 * if (selectedOrdenMp != null) { List<String> aux1 = selectedOrdenMp; for (int
			 * i = 0; i < aux1.size(); i++) { cadereferenciaCompraMp += aux1.get(i) + ","; }
			 * }
			 */

			Long compania = new Long(getCompaniaIdSession());

			boolean existeProducto = false;

			Double saldoProducto = 0.0;
			saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
					.doubleValue();

			String nomProducto = producto.getNombre();
			if (tipoM.equals("SAL")) {
				if (saldoProducto >= cantidad_Compra) {

					if (dataDetPrecioProductos2 == null || dataDetPrecioProductos2.size() == 0) {
						dataDetPrecioProductos2 = new ArrayList<PrecioPromProdDTO>();
					}

					PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
					precioPromProdDTO.setNomProducto(nomProducto);
					precioPromProdDTO.setFechaInicial(fechaInicial);
					precioPromProdDTO.setCantidadCompra(cantidad_Compra);
					precioPromProdDTO.setUnidadMedida(udadMed);
					precioPromProdDTO.setAlmacenId(almacen);
					precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
					precioPromProdDTO.setCodAlmacen(codAlmacen);
					precioPromProdDTO.setValorUnitario(valorUnit);
					precioPromProdDTO.setCompania(compania);
					precioPromProdDTO.setFechaCreacion(date);
					precioPromProdDTO.setFechaModificacion(date);
					precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
					precioPromProdDTO.setCodPersEmpr(codPersEmpr);
					precioPromProdDTO.setEquipoId(equipo);
					precioPromProdDTO.setConceptoKardexId(conceptoKardex);
					precioPromProdDTO.setProducto(producto);
					precioPromProdDTO.setCodProducto(codProducto);
					precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
					precioPromProdDTO.setPorcIva(porcIva);
					precioPromProdDTO.setValorIva(valorIva);
					precioPromProdDTO.setCostoTotal(costoTotal);
					precioPromProdDTO.setTipoMovimiento(tipoM);
					precioPromProdDTO.setNumFacturaCompra(numFactura);
					precioPromProdDTO.setCodEquipo(codEquipo);
					precioPromProdDTO.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
					precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
					precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);
					precioPromProdDTO.setReferenciaFacCompra(cadereferenciaCompraMp);

					dataDetPrecioProductos2.add(precioPromProdDTO);
					indicador_vuelta_medidor = null;
					// infoAdicional = null;
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
					// loteCompra = null;
					// registro_ica = null;
					persEmpr = null;
					codPersEmpr = null;
					equipo = null;
					conceptoKardex = null;
					producto = null;
					// trabajador = null;
					codProducto = null;
					// codTrabajador = null;
					codConceptoKardex = null;
					porcIva = null;
					valorIva = null;
					costoTotal = null;
					tipoM = null;
					numFactura = null;
					ubicacionesAlmacenId = null;
					ubicacionesAlmacen = null;
					codUbicacionesAlmacen = null;
					costoTotalProductoFormula = 0.0;
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps! Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. ",
							""));

				}
			} else {

				if (dataDetPrecioProductos2 == null || dataDetPrecioProductos2.size() == 0) {
					dataDetPrecioProductos2 = new ArrayList<PrecioPromProdDTO>();
				}

				PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
				precioPromProdDTO.setNomProducto(nomProducto);
				precioPromProdDTO.setFechaInicial(fechaInicial);
				// precioPromProdDTO.setFechaVencimiento(fecha_Vencimiento);
				precioPromProdDTO.setCantidadCompra(cantidad_Compra);
				precioPromProdDTO.setUnidadMedida(udadMed);
				// precioPromProdDTO.setLoteCompraProducto(loteCompra);
				// precioPromProdDTO.setRegistroIca(registro_ica);
				precioPromProdDTO.setAlmacenId(almacen);
				precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
				precioPromProdDTO.setCodAlmacen(codAlmacen);
				precioPromProdDTO.setValorUnitario(valorUnit);
				precioPromProdDTO.setCompania(compania);
				precioPromProdDTO.setFechaCreacion(date);
				precioPromProdDTO.setFechaModificacion(date);
				precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
				precioPromProdDTO.setCodPersEmpr(codPersEmpr);
				precioPromProdDTO.setEquipoId(equipo);
				precioPromProdDTO.setConceptoKardexId(conceptoKardex);
				precioPromProdDTO.setProducto(producto);
				// precioPromProdDTO.setTrabajador(trabajador);
				precioPromProdDTO.setCodProducto(codProducto);
				// precioPromProdDTO.setCodTrabajador(codTrabajador);
				precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
				precioPromProdDTO.setPorcIva(porcIva);
				precioPromProdDTO.setValorIva(valorIva);
				precioPromProdDTO.setCostoTotal(costoTotal);
				precioPromProdDTO.setTipoMovimiento(tipoM);
				precioPromProdDTO.setNumFacturaCompra(numFactura);
				// precioPromProdDTO.setInfoAdicional(infoAdicional);
				precioPromProdDTO.setReferenciaFacCompra(cadereferenciaCompraMp);
				precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
				precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

				precioPromProdDTO.setReferenciaFacCompra(cadereferenciaCompraMp);

				dataDetPrecioProductos2.add(precioPromProdDTO);

				// infoAdicional = null;
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
				// loteCompra = null;
				// registro_ica = null;
				persEmpr = null;
				codPersEmpr = null;
				equipo = null;
				conceptoKardex = null;
				producto = null;
				// trabajador = null;
				codProducto = null;
				// codTrabajador = null;
				codConceptoKardex = null;
				porcIva = null;
				valorIva = null;
				costoTotal = null;
				tipoM = null;
				numFactura = null;

				ubicacionesAlmacenId = null;
				ubicacionesAlmacen = null;
				codUbicacionesAlmacen = null;
				costoTotalProductoFormula = 0.0;
			}

			cantidadCompra2.setValue(0.0);

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Upps!, Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. ",
					""));
		}
	}

	public void action_agregarSalidaProductosFabricacion() throws Exception {

		if (txtProductoId_Producto.getValue() != null && txtAlmacenId_Almacen2.getValue() != null
				&& txtUnidadMedida.getValue() != null && txtFechaRegistro.getValue() != null
				&& txtValorUnit.getValue() != null && cantidadCompra.getValue() != null) {

			Date date = new Date();
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);

			Long persEmprId = null;
			PersEmpr persEmpr = null;
			String codPersEmpr = "";
			if (txtPersEmpr.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmpr.getValue().toString());
				persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				codPersEmpr = persEmpr.getCodigo();

			}

			Long ubicacionesAlmacenId = null;
			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";
			if (txtUbicacionesAlmacen.getValue() != null) {
				ubicacionesAlmacenId = Long.parseLong(txtUbicacionesAlmacen.getValue().toString());
				ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
				codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
			}

			Long equipoId = null;
			Equipo equipo = null;
			String codEquipo = "";
			Long indicador_vuelta_medidor = 0L;

			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			/*
			 * Long trabId =null; Trabajador trabajador = null; String codTrabajador ="";
			 * if(txtTrabajadorId_Trabajador !=null){ trabId =
			 * Long.parseLong(txtTrabajadorId_Trabajador.getValue().toString()); trabajador
			 * = businessDelegatorView.getTrabajador(trabId); codTrabajador =
			 * trabajador.getCodigo(); }
			 */
			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();

			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			// String fechaInicialFormat = dmyFormat.format(fechaInicial);
			Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
			Double costoTotal = 0.0;
			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);

			if (valorUnit != null && cantidad_Compra != null) {
				costoTotal = valorUnit * cantidad_Compra;

			}

			// Date fecha_Vencimiento =
			// (FacesUtils.checkDate(fechaVencimiento));

			Double porcIva = 0.0;
			Double valorIva = 0.0;

			// String tipoM = FacesUtils.checkString(txtTipoMovimiento);
			Long numFactura = null;
			if (txtNumFactura.getValue() != null) {
				numFactura = FacesUtils.checkLong(txtNumFactura);
			}
			// String fechaVencimientoFormat =
			// dmyFormat.format(fecha_Vencimiento);
			/*
			 * String loteCompra =""; String registro_ica="";
			 * if(loteCompraProducto.getValue() !=null){ loteCompra =
			 * FacesUtils.checkString(loteCompraProducto); }
			 * if(registroIca.getValue()!=null){ registro_ica =
			 * FacesUtils.checkString(registroIca); }
			 * 
			 * String infoAdicional =""; if(txtInfoAdicional.getValue() !=null){
			 * infoAdicional = FacesUtils.checkString(txtInfoAdicional); }
			 */
			// Long consecutivo = FacesUtils.checkLong(txtConsecutivo);

			String cadereferenciaCompraMp = "";

			Long compania = new Long(getCompaniaIdSession());

			boolean existeProducto = false;

			Double saldoProducto = 0.0;
			saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
					.doubleValue();

			String nomProducto = producto.getNombre();
			if (tipoM.equals("SAL")) {
				if (saldoProducto >= cantidad_Compra) {

					if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
						dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
					}

					PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
					precioPromProdDTO.setNomProducto(nomProducto);
					precioPromProdDTO.setFechaInicial(fechaInicial);
					precioPromProdDTO.setCantidadCompra(cantidad_Compra);
					precioPromProdDTO.setUnidadMedida(udadMed);
					precioPromProdDTO.setAlmacenId(almacen);
					precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
					precioPromProdDTO.setCodAlmacen(codAlmacen);
					precioPromProdDTO.setValorUnitario(valorUnit);
					precioPromProdDTO.setCompania(compania);
					precioPromProdDTO.setFechaCreacion(date);
					precioPromProdDTO.setFechaModificacion(date);
					precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
					precioPromProdDTO.setCodPersEmpr(codPersEmpr);
					precioPromProdDTO.setEquipoId(equipo);
					precioPromProdDTO.setConceptoKardexId(conceptoKardex);
					precioPromProdDTO.setProducto(producto);
					precioPromProdDTO.setCodProducto(codProducto);
					precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
					precioPromProdDTO.setPorcIva(porcIva);
					precioPromProdDTO.setValorIva(valorIva);
					precioPromProdDTO.setCostoTotal(costoTotal);
					precioPromProdDTO.setTipoMovimiento(tipoM);
					precioPromProdDTO.setNumFacturaCompra(numFactura);
					precioPromProdDTO.setCodEquipo(codEquipo);
					precioPromProdDTO.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
					precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
					precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);
					precioPromProdDTO.setReferenciaFacCompra(cadereferenciaCompraMp);

					Double valorTotal = 0.0;
					dataDetPrecioProductos.add(precioPromProdDTO);
					if (dataDetPrecioProductos != null && dataDetPrecioProductos.size() > 0) {
						for (PrecioPromProdDTO data1 : dataDetPrecioProductos) {
							valorTotal += data1.getCostoTotal();
						}
						txtValorTotalProducto.setValue(valorTotal);

					}

					indicador_vuelta_medidor = null;
					// infoAdicional = null;
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
					// loteCompra = null;
					// registro_ica = null;
					persEmpr = null;
					codPersEmpr = null;
					equipo = null;
					conceptoKardex = null;
					producto = null;
					// trabajador = null;
					codProducto = null;
					// codTrabajador = null;
					codConceptoKardex = null;
					porcIva = null;
					valorIva = null;
					costoTotal = null;
					tipoM = null;
					numFactura = null;
					ubicacionesAlmacenId = null;
					ubicacionesAlmacen = null;
					codUbicacionesAlmacen = null;

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps! Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. ",
							""));

				}
			} else {

				if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
					dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
				}

				PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
				precioPromProdDTO.setFechaInicial(fechaInicial);
				// precioPromProdDTO.setFechaVencimiento(fecha_Vencimiento);
				precioPromProdDTO.setCantidadCompra(cantidad_Compra);
				precioPromProdDTO.setUnidadMedida(udadMed);
				// precioPromProdDTO.setLoteCompraProducto(loteCompra);
				// precioPromProdDTO.setRegistroIca(registro_ica);
				precioPromProdDTO.setAlmacenId(almacen);
				precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
				precioPromProdDTO.setCodAlmacen(codAlmacen);
				precioPromProdDTO.setValorUnitario(valorUnit);
				precioPromProdDTO.setCompania(compania);
				precioPromProdDTO.setFechaCreacion(date);
				precioPromProdDTO.setFechaModificacion(date);
				precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
				precioPromProdDTO.setCodPersEmpr(codPersEmpr);
				precioPromProdDTO.setEquipoId(equipo);
				precioPromProdDTO.setConceptoKardexId(conceptoKardex);
				precioPromProdDTO.setProducto(producto);
				// precioPromProdDTO.setTrabajador(trabajador);
				precioPromProdDTO.setCodProducto(codProducto);
				// precioPromProdDTO.setCodTrabajador(codTrabajador);
				precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
				precioPromProdDTO.setPorcIva(porcIva);
				precioPromProdDTO.setValorIva(valorIva);
				precioPromProdDTO.setCostoTotal(costoTotal);
				precioPromProdDTO.setTipoMovimiento(tipoM);
				precioPromProdDTO.setNumFacturaCompra(numFactura);
				// precioPromProdDTO.setInfoAdicional(infoAdicional);
				precioPromProdDTO.setReferenciaFacCompra(cadereferenciaCompraMp);
				precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
				precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

				dataDetPrecioProductos.add(precioPromProdDTO);

				// infoAdicional = null;
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
				// loteCompra = null;
				// registro_ica = null;
				persEmpr = null;
				codPersEmpr = null;
				equipo = null;
				conceptoKardex = null;
				producto = null;
				// trabajador = null;
				codProducto = null;
				// codTrabajador = null;
				codConceptoKardex = null;
				porcIva = null;
				valorIva = null;
				costoTotal = null;
				tipoM = null;
				numFactura = null;

				ubicacionesAlmacenId = null;
				ubicacionesAlmacen = null;
				codUbicacionesAlmacen = null;
			}
			cantidadCompra.setValue(0.0);
			txtValorUnit.setValue(0.0);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Upps!, Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. ",
					""));
		}
	}

	public void action_agregarSalidaSuministroMaquinaria() throws Exception {
		Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && cantidad_Compra != null) {
			String equipos = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				for (int i = 0; i < selectedEquipo.size(); i++) {
					equipos = selectedEquipo.get(i);
					Double cantidadRegistros = (double) selectedEquipo.size();
					Double cantidad_Compra_final = cantidad_Compra/ cantidadRegistros;
					cantidad_Compra_final = (double) Math.round(cantidad_Compra_final * 100) / 100;
					
					Date date = new Date();
					Long compania = new Long(getCompaniaIdSession());
					Double horometroAbastecimiento = FacesUtils.checkDouble(txtHorometroAbastecimiento);
					Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
					Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
					Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);
					Date idFecha = FacesUtils.checkDate(txtFechaRegistro);

					Long equipoId = Long.parseLong(equipos);
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);
					 
					Long indicador_vuelta_medidor = 0L;
					if (equipo.getIndicador_vuelta_medidor() != null) {
						indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
					}

					Long ubicacionesAlmacenId = null;
					UbicacionesAlmacen ubicacionesAlmacen = null;
					String codUbicacionesAlmacen = "";
					if (txtUbicacionesAlmacen.getValue() != null) {
						ubicacionesAlmacenId = Long.parseLong(txtUbicacionesAlmacen.getValue().toString());
						ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
						codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
					}

					String nombreImplemento = "";
					Long implementoId = null;
					Equipo implemento = null;
					if (txtImplemento.getValue() != null) {
						implementoId = Long.parseLong(txtImplemento.getValue().toString());
						implemento = businessDelegatorView.getEquipo(implementoId);
						nombreImplemento = implemento.getCodigo() + "-" + implemento.getNombre();
					}

					Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
					ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
					String tipoM = conceptoKardex.getTipoMovimiento();

					Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
					Producto producto = businessDelegatorView.getProducto(productoId);

					String codConceptoKardex = conceptoKardex.getCodigo();
					String codProducto = producto.getCodigo();
					String codEquipo = equipo.getCodigo();
					String codAlmacen = almacen.getCodigo();
					String codUnidadMed = udadMed.getCodigo();

					SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
					Double valorUnit = 0.0;

					
					
				 
					Double porcIva = 0.0;
					Double valorIva = 0.0;
					Double costoTotal = 0.0;

					if (idFecha != null && unidadMedida != null && compania != null && almacenId != null
							&& productoId != null) {

						valorUnit = businessDelegatorView
								.consultarPrecioPromProducto(productoId, almacenId, compania, idFecha).doubleValue();
						costoTotal = (valorUnit * cantidad_Compra_final);

					}

					String infoAdicional = "";
					if (txtInfoAdicional.getValue() != null) {
						infoAdicional = FacesUtils.checkString(txtInfoAdicional);
					}

					// Long consecutivo = FacesUtils.checkLong(txtConsecutivo);

					Double saldoProducto = 0.0;
					saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
							.doubleValue();
					String nomProducto = producto.getNombre();

					Long conceptoGasto = null;
					if (txtLaborId_Labor.getValue() != null) {
						conceptoGasto = Long.parseLong(txtLaborId_Labor.getValue().toString());
					}

					if (tipoM.equals("SAL")) {
						if (saldoProducto >= cantidad_Compra) {

							boolean existeProducto = false;

							if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
								dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
							}

							PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
							precioPromProdDTO.setNomProducto(nomProducto);
							precioPromProdDTO.setFechaInicial(fechaInicial);
							precioPromProdDTO.setCantidadCompra(cantidad_Compra_final);
							precioPromProdDTO.setUnidadMedida(udadMed);
							precioPromProdDTO.setAlmacenId(almacen);
							precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
							precioPromProdDTO.setCodAlmacen(codAlmacen);
							precioPromProdDTO.setValorUnitario(valorUnit);
							precioPromProdDTO.setCompania(compania);
							precioPromProdDTO.setFechaCreacion(date);
							precioPromProdDTO.setFechaModificacion(date);
							precioPromProdDTO.setEquipoId(equipo);
							precioPromProdDTO.setCodEquipo(codEquipo);
							precioPromProdDTO.setConceptoKardexId(conceptoKardex);
							precioPromProdDTO.setProducto(producto);
							precioPromProdDTO.setCodProducto(codProducto);
							precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
							precioPromProdDTO.setPorcIva(porcIva);
							precioPromProdDTO.setValorIva(valorIva);
							precioPromProdDTO.setCostoTotal(costoTotal);
							precioPromProdDTO.setTipoMovimiento(tipoM);
							precioPromProdDTO.setInfoAdicional(infoAdicional);
					
							precioPromProdDTO.setConceptoGastoId(conceptoGasto);
							precioPromProdDTO.setHorometro_abastecimiento(horometroAbastecimiento);
							precioPromProdDTO.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
							precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
							precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

							precioPromProdDTO.setCodImplemento(nombreImplemento);
							precioPromProdDTO.setImplementoId(implementoId);

							dataDetPrecioProductos.add(precioPromProdDTO);
							

						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_WARN, "Upps!",
									"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));
						}
					}
				}
			}
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
		limpiar_pantalla();
	}

	public InputText getTxtHorometroAbastecimiento() {
		return txtHorometroAbastecimiento;
	}

	public void setTxtHorometroAbastecimiento(InputText txtHorometroAbastecimiento) {
		this.txtHorometroAbastecimiento = txtHorometroAbastecimiento;
	}

	public SelectOneMenu getTxtUbicacionesAlmacen() {
		return txtUbicacionesAlmacen;
	}

	public void setTxtUbicacionesAlmacen(SelectOneMenu txtUbicacionesAlmacen) {
		this.txtUbicacionesAlmacen = txtUbicacionesAlmacen;
	}

	public SelectItem[] getSelectUbAlmacen() {

		if (selectUbAlmacen == null || selectUbAlmacen.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion,
						null, null);
				selectUbAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (UbicacionesAlmacen ubicacionesAlmacen : lista) {
					selectUbAlmacen[i] = new SelectItem(ubicacionesAlmacen.getUbicacionesAlmacenId(),
							ubicacionesAlmacen.getNombre());
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

	public SelectItem[] getSelectUbAlmacen2() {

		if (selectUbAlmacen2 == null || selectUbAlmacen2.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion,
						null, null);
				selectUbAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (UbicacionesAlmacen ubicacionesAlmacen2 : lista) {
					selectUbAlmacen2[i] = new SelectItem(ubicacionesAlmacen2.getUbicacionesAlmacenId(),
							ubicacionesAlmacen2.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUbAlmacen2;
	}

	public void setSelectUbAlmacen2(SelectItem[] selectUbAlmacen2) {
		this.selectUbAlmacen2 = selectUbAlmacen2;
	}

	/*
	 * public List<ConsultaStockMaquinariaDTO> getDataProductoUbicacion() { return
	 * dataProductoUbicacion; }
	 */

	public void setDataProductoUbicacion(List<ConsultaStockMaquinariaDTO> dataProductoUbicacion) {
		this.dataProductoUbicacion = dataProductoUbicacion;
	}

	public ConsultaStockMaquinariaDTO getSelectedProductoUbicacion() {
		return selectedProductoUbicacion;
	}

	public void setSelectedProductoUbicacion(ConsultaStockMaquinariaDTO selectedProductoUbicacion) {
		this.selectedProductoUbicacion = selectedProductoUbicacion;
	}

	public void action_cargarsaldos() throws NumberFormatException, Exception {

		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen2);
		String productoId = FacesUtils.checkString(txtProductoId_Producto);
		Long compania = new Long(getCompaniaIdSession());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();

		if (txtAlmacenId_Almacen2.getValue() != null && txtProductoId_Producto.getValue() != null) {
			dataProductoUbicacion = businessDelegator2View.pr_inventario_saldo_producto_ubicacion(compania,
					fechaFinalDateRegistro, date, almacenId, 0L, productoId, 0l);
		}

	}

	public List<ConsultaStockMaquinariaDTO> getDataProductoUbicacion() {

		if (dataProductoUbicacion == null || dataProductoUbicacion.size() == 0) {
			return null;
		} else {
			return dataProductoUbicacion;
		}
	}

	Double cantidad = null;
	Long idUbicacion = null;

	public void onCellProductoUbicacion(CellEditEvent evt) throws Exception {

		selectedProductoUbicacion = (ConsultaStockMaquinariaDTO) (evt.getComponent().getAttributes()
				.get("selectedProductoUbicacion"));

		Double Cant = 0.0;
		String columnaCell = evt.getColumn().getHeaderText();

		Object newValue = evt.getNewValue();

		if (newValue != null) {

			if (columnaCell.equals("Cant.")) {

				cantidad = new Double(evt.getNewValue().toString());
				Double cantidadDisponible = selectedProductoUbicacion.getCantidadDisponible().doubleValue();

				if (cantidad > cantidadDisponible) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps! Verifique que la cantidad del producto sea menor o igual al saldo en la ubicación. ",
							""));
					cantidad = 0.0;
				}

			}

			if (selectedProductoUbicacion.getUbicacionAlmacen() != null) {
				idUbicacion = selectedProductoUbicacion.getUbicacionAlmacen().longValue();

			}

		}

		action_agregarSuministrosUbicacion();
	}

	public void action_agregarSuministrosUbicacion() throws Exception {

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && txtFechaEntrega.getValue() != null
				&& txtEquipoId_Equipo.getValue() != null && cantidad != null && cantidad > 0) {
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Double horometroAbastecimiento = FacesUtils.checkDouble(txtHorometroAbastecimiento);
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);
			Date idFecha = FacesUtils.checkDate(txtFechaEntrega);

			Long equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
			Equipo equipo = businessDelegatorView.getEquipo(equipoId);

			Long indicador_vuelta_medidor = 0L;
			if (equipo.getIndicador_vuelta_medidor() != null) {
				indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
			}

			Long ubicacionesAlmacenId = null;
			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";
			if (idUbicacion != null) {
				ubicacionesAlmacenId = selectedProductoUbicacion.getUbicacionAlmacen().longValue();
				if (ubicacionesAlmacenId != 0) {
					ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
					codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
				}
			}

			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);

			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();
			String codEquipo = equipo.getCodigo();
			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
			// Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			Double valorUnit = 0.0;

			Double cantidad_Compra = cantidad;
			Double porcIva = 0.0;
			Double valorIva = 0.0;
			Double costoTotal = 0.0;

			if (idFecha != null && unidadMedida != null && compania != null && almacenId != null
					&& productoId != null) {

				valorUnit = businessDelegatorView.consultarPrecioPromProducto(productoId, almacenId, compania, idFecha)
						.doubleValue();
				costoTotal = (valorUnit * cantidad_Compra);

			}

			String infoAdicional = "";
			if (txtInfoAdicional.getValue() != null) {
				infoAdicional = FacesUtils.checkString(txtInfoAdicional);
			}

			// Long consecutivo = FacesUtils.checkLong(txtConsecutivo);

			Double saldoProducto = 0.0;
			saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
					.doubleValue();
			String nomProducto = producto.getNombre();

			Long conceptoGasto = null;
			if (txtLaborId_Labor.getValue() != null) {
				conceptoGasto = Long.parseLong(txtLaborId_Labor.getValue().toString());
			}

			Long persEmprId = null;
			PersEmpr persEmpr = null;
			String codPersEmpr = "";
			if (txtPersEmpr.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmpr.getValue().toString());
				persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				codPersEmpr = persEmpr.getCodigo();

			}
			Long numFactura = null;
			if (txtNumFactura.getValue() != null) {
				numFactura = FacesUtils.checkLong(txtNumFactura);
			}

			String nombreImplemento = "";
			Long implementoId = null;
			Equipo implemento = null;
			if (txtImplemento.getValue() != null) {
				implementoId = Long.parseLong(txtImplemento.getValue().toString());
				implemento = businessDelegatorView.getEquipo(implementoId);
				nombreImplemento = implemento.getCodigo() + "-" + implemento.getNombre();
			}

			if (tipoM.equals("SAL")) {
				if (saldoProducto >= cantidad_Compra) {

					boolean existeProducto = false;

					if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
						dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
					}

					PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
					precioPromProdDTO.setNomProducto(nomProducto);
					precioPromProdDTO.setFechaInicial(idFecha);
					precioPromProdDTO.setCantidadCompra(cantidad);
					precioPromProdDTO.setUnidadMedida(udadMed);
					precioPromProdDTO.setAlmacenId(almacen);
					precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
					precioPromProdDTO.setCodAlmacen(codAlmacen);
					precioPromProdDTO.setValorUnitario(valorUnit);
					precioPromProdDTO.setCompania(compania);
					precioPromProdDTO.setFechaCreacion(date);
					precioPromProdDTO.setFechaModificacion(date);
					precioPromProdDTO.setEquipoId(equipo);
					precioPromProdDTO.setConceptoKardexId(conceptoKardex);
					precioPromProdDTO.setProducto(producto);
					precioPromProdDTO.setCodProducto(codProducto);
					precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
					precioPromProdDTO.setPorcIva(porcIva);
					precioPromProdDTO.setValorIva(valorIva);
					precioPromProdDTO.setCostoTotal(costoTotal);
					precioPromProdDTO.setTipoMovimiento(tipoM);
					precioPromProdDTO.setInfoAdicional(infoAdicional);
					precioPromProdDTO.setCodEquipo(codEquipo);
					precioPromProdDTO.setConceptoGastoId(conceptoGasto);
					precioPromProdDTO.setHorometro_abastecimiento(horometroAbastecimiento);
					precioPromProdDTO.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
					precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
					precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

					precioPromProdDTO.setCodImplemento(nombreImplemento);
					precioPromProdDTO.setImplementoId(implementoId);

					dataDetPrecioProductos.add(precioPromProdDTO);
					horometroAbastecimiento = null;
					indicador_vuelta_medidor = null;
					conceptoGasto = null;
					codEquipo = null;
					infoAdicional = null;
					infoAdicional = null;
					idFecha = null;
					almacen = null;
					valorUnit = null;
					codAlmacen = null;
					almacenId = null;
					date = null;
					compania = null;
					cantidad_Compra = null;
					unidadMedida = null;
					equipo = null;
					conceptoKardex = null;
					producto = null;
					codProducto = null;
					codConceptoKardex = null;
					porcIva = null;
					valorIva = null;
					costoTotal = null;
					tipoM = null;

					ubicacionesAlmacenId = null;
					ubicacionesAlmacen = null;
					codUbicacionesAlmacen = null;

					cantidad = null;

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!",
							"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));
				}
			} else {

				if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
					dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
				}

				PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
				precioPromProdDTO.setFechaInicial(idFecha);
				// precioPromProdDTO.setFechaVencimiento(fecha_Vencimiento);
				precioPromProdDTO.setCantidadCompra(cantidad_Compra);
				precioPromProdDTO.setUnidadMedida(udadMed);
				// precioPromProdDTO.setLoteCompraProducto(loteCompra);
				// precioPromProdDTO.setRegistroIca(registro_ica);
				precioPromProdDTO.setAlmacenId(almacen);
				precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
				precioPromProdDTO.setCodAlmacen(codAlmacen);
				precioPromProdDTO.setValorUnitario(valorUnit);
				precioPromProdDTO.setCompania(compania);
				precioPromProdDTO.setFechaCreacion(date);
				precioPromProdDTO.setFechaModificacion(date);
				precioPromProdDTO.setPersEmprId_PersEmpr(persEmpr);
				precioPromProdDTO.setCodPersEmpr(codPersEmpr);
				precioPromProdDTO.setEquipoId(equipo);
				precioPromProdDTO.setConceptoKardexId(conceptoKardex);
				precioPromProdDTO.setProducto(producto);
				// precioPromProdDTO.setTrabajador(trabajador);
				precioPromProdDTO.setCodProducto(codProducto);
				// precioPromProdDTO.setCodTrabajador(codTrabajador);
				precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
				precioPromProdDTO.setPorcIva(porcIva);
				precioPromProdDTO.setValorIva(valorIva);
				precioPromProdDTO.setCostoTotal(costoTotal);
				precioPromProdDTO.setTipoMovimiento(tipoM);
				precioPromProdDTO.setNumFacturaCompra(numFactura);
				// precioPromProdDTO.setInfoAdicional(infoAdicional);
				precioPromProdDTO.setCodEquipo(codEquipo);
				precioPromProdDTO.setHorometro_abastecimiento(horometroAbastecimiento);
				precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
				precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);

				precioPromProdDTO.setCodImplemento(nombreImplemento);
				precioPromProdDTO.setImplementoId(implementoId);

				dataDetPrecioProductos.add(precioPromProdDTO);
				cantidad = null;
				// infoAdicional = null;
				idFecha = null;
				// fecha_Vencimiento = null;
				almacen = null;
				valorUnit = null;
				codAlmacen = null;
				almacenId = null;
				date = null;
				compania = null;
				cantidad_Compra = null;
				unidadMedida = null;
				// loteCompra = null;
				// registro_ica = null;
				persEmpr = null;
				codPersEmpr = null;
				equipo = null;
				conceptoKardex = null;
				producto = null;
				// trabajador = null;
				codProducto = null;
				// codTrabajador = null;
				codConceptoKardex = null;
				porcIva = null;
				valorIva = null;
				costoTotal = null;
				tipoM = null;
				numFactura = null;
				horometroAbastecimiento = null;

				ubicacionesAlmacenId = null;
				ubicacionesAlmacen = null;
				codUbicacionesAlmacen = null;
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha , fecha de entrega,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}

		limpiar_pantalla4();
	}

	public String action_edit_ubicacion(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {

			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId", true, datOtrosMovInventarioId, "=" };
			List<DatOtrosMovInventario> lista = (datOtrosMovInventarioId != null)
					? businessDelegator2View.findByCriteriaInDatOtrosMovInventario(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtSaldo.setDisabled(true);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtNumFactura.setValue(entity.getNumFactura());
				txtNumFactura.setDisabled(false);
				txtConceptoKardex.setValue(entity.getConceptoKardex().getConceptoKardexId());
				txtConceptoKardex.setDisabled(false);

				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);

				txtFechaEntrega.setDisabled(false);

				txtPersEmpr.setValue(null);
				if (entity.getPersEmpr() != null) {
					txtPersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
				}

				txtPersEmpr.setDisabled(false);
				txtDatOtrosMovInventarioId.setValue(entity.getDatOtrosMovInventarioId());
				txtDatOtrosMovInventarioId.setDisabled(true);

				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventarioId);

				if (txtTipoProducto != null) {
					txtTipoProducto.setValue(null);
					txtTipoProducto.setDisabled(false);
				}

				if (txtLaborId_Labor != null) {
					txtLaborId_Labor.setValue(null);
					txtLaborId_Labor.setDisabled(false);
				}

				txtLaborId_Labor.setDisabled(false);
				if (txtFechaInicial != null) {
					txtFechaInicial.setValue(null);
					txtFechaInicial.setDisabled(false);
				}

				if (txtAlmacenId_Almacen2 != null) {
					txtAlmacenId_Almacen2.setValue(null);
					txtAlmacenId_Almacen2.setDisabled(false);
				}

				if (txtProductoId_Producto != null) {
					txtProductoId_Producto.setValue(null);
					txtProductoId_Producto.setDisabled(false);
				}

				if (txtUnidadMedida != null) {
					txtUnidadMedida.setValue(null);
					txtUnidadMedida.setDisabled(false);
				}

				if (txtHorometroAbastecimiento != null) {
					txtHorometroAbastecimiento.setValue(0.0);
					txtHorometroAbastecimiento.setDisabled(false);
				}
				txtImplemento.setDisabled(false);

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public Calendar getTxtFechaEntrega() {
		return txtFechaEntrega;
	}

	public void setTxtFechaEntrega(Calendar txtFechaEntrega) {
		this.txtFechaEntrega = txtFechaEntrega;
	}

	public SelectItem[] getselectEquipoConsulta() {

		if (equipoConsulta == null || equipoConsulta.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipoConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipoConsulta : lista) {
					selectEquipoConsulta[i] = new SelectItem(equipoConsulta.getEquipoId(),
							equipoConsulta.getCodigo() + "-" + equipoConsulta.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipoConsulta;
	}

	public void setselectEquipoConsulta(SelectItem[] selectEquipoConsulta) {
		this.selectEquipoConsulta = selectEquipoConsulta;
	}

	public SelectOneMenu getTxtEquipoConsulta() {
		return txtEquipoConsulta;
	}

	public void setTxtEquipoConsulta(SelectOneMenu txtEquipoConsulta) {
		this.txtEquipoConsulta = txtEquipoConsulta;
	}

	public String procesar_salidas_inventario(ActionEvent evt) {
		selectedDatOtrosMovInventario2 = (ConsultaOtrosMovimientosInventarioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosMovInventario2"));
		try {
			Long datOtrosMovInventarioId = selectedDatOtrosMovInventario2.getDat_otros_mov_inventario_id().longValue();
			Object[] condicion = { "datOtrosMovInventarioId.datOtrosMovInventarioId", true, datOtrosMovInventarioId,
					"=" };
			List<PrecioPromProd> lista = (datOtrosMovInventarioId != null)
					? businessDelegatorView.findByCriteriaInPrecioPromProd(condicion, null, null)
					: null;
			if (lista != null && lista.size() > 0) {
				for (int a = 0; a < lista.size(); a++) {
					PrecioPromProd entityDetalle = lista.get(a);
					entityDetalle.setTipoMovimiento("SAL");
					businessDelegatorView.updatePrecioPromProd(entityDetalle);

				}
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Los movimientos del día fueron procesados exitosamente y ya hacen parte de las sálidas del inventario!",
						"  "));
			}

		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_vericiar_saldos_ubicacion() throws Exception {

		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen2);
		String productoId = FacesUtils.checkString(txtProductoId_Producto);
		Long compania = new Long(getCompaniaIdSession());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();

		if (txtAlmacenId_Almacen2.getValue() != null && txtProductoId_Producto.getValue() != null) {
			dataProductoUbicacionX = businessDelegator2View.pr_inventario_saldo_producto_ubicacion(compania,
					fechaFinalDateRegistro, date, almacenId, 0L, productoId, 0l);
		}
		setShowDialog(true);
		return "";

	}

	public String action_vericiar_saldos_ubicacion2() throws Exception {

		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen3);
		String productoId = FacesUtils.checkString(txtProductoId_Producto2);
		Long compania = new Long(getCompaniaIdSession());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();

		if (txtAlmacenId_Almacen3.getValue() != null && txtProductoId_Producto2.getValue() != null) {
			dataProductoUbicacionX = businessDelegator2View.pr_inventario_saldo_producto_ubicacion(compania,
					fechaFinalDateRegistro, date, almacenId, 0L, productoId, 0l);
		}
		setShowDialog(true);
		return "";

	}

	public List<ConsultaStockMaquinariaDTO> getDataProductoUbicacionX() {
		return dataProductoUbicacionX;
	}

	public void setDataProductoUbicacionX(List<ConsultaStockMaquinariaDTO> dataProductoUbicacionX) {
		this.dataProductoUbicacionX = dataProductoUbicacionX;
	}

	public SelectItem[] getSelectImplemento() {

		if (implemento == null || implemento.size() == 0) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Implemento", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo Implemento : lista) {
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(),
							Implemento.getCodigo() + "-" + Implemento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectImplemento;
	}

	public void setSelectImplemento(SelectItem[] selectImplemento) {
		this.selectImplemento = selectImplemento;
	}

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
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

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtCentCostConsulta() {
		return txtCentCostConsulta;
	}

	public void setTxtCentCostConsulta(SelectOneMenu txtCentCostConsulta) {
		this.txtCentCostConsulta = txtCentCostConsulta;
	}

	public void setSelectCentCostConsulta(SelectItem[] selectCentCostConsulta) {
		this.selectCentCostConsulta = selectCentCostConsulta;
	}

	public SelectItem[] getSelectCentCostConsulta() {

		if (selectCentCostConsulta == null || selectCentCostConsulta.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCostConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCostConsulta[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCostConsulta;
	}

	public List<String> getSelectedOrdenMp() {
		selectedOrdenMp = null;
		return selectedOrdenMp;
	}

	public void setSelectedOrdenMp(List<String> selectedOrdenMp) {
		this.selectedOrdenMp = selectedOrdenMp;
	}

	public List<ConsultaCompraProductosDTO> getOrdenMp() {

		if (ordenMp == null || ordenMp.size() == 0) {

			try {
				Long idCompania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

				GregorianCalendar calendario4 = new GregorianCalendar();
				calendario4.add(GregorianCalendar.DAY_OF_YEAR, -90);
				java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

				Date fechaFinalDateRegistro = null;
				Date fechaOriginalFinal = foriginal.parse("2100-12-31");
				String fsalidaFinal = sdf.format(fechaOriginalFinal);
				fechaFinalDateRegistro = sdf.parse(fsalidaFinal);

				Long idRegistro = 0L;
				ordenMp = null;
				ordenMp = businessDelegator2View.pr_lista_compra_productos(idCompania, fechaMinimaPermitida,
						fechaFinalDateRegistro, "0", 1l, 0L, "Nacional", 0l);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return ordenMp;
	}

	public void listener_obtener_valor_factura() {

		Long udadMedId = null;
		Long nivel4Id = null;
		Long nivel2Id = null;
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');

		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Double result = 0.0;
		String ordenesSeleccionadas = "";
		Double costoTotal = 0.0;
		if (selectedOrdenMp != null && selectedOrdenMp.size() > 0) {

			for (int j = 0; j < selectedOrdenMp.size(); j++) {
				ordenesSeleccionadas = selectedOrdenMp.get(j);

				try {

					Object[] variables = { "datCompraProductosId", true, ordenesSeleccionadas, "=" };
					List<DatCompraProductos> lista = businessDelegator2View
							.findByCriteriaInDatCompraProductos(variables, null, null);
					if (lista != null && lista.size() > 0) {
						DatCompraProductos datCompraProductos = lista.get(0);
						costoTotal += datCompraProductos.getValorFactura();
					}

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}
			}
			txtValorTotalProducto.setValue(costoTotal);
		}

	}

	public SelectOneMenu getTxtConceptoKardex2() {
		return txtConceptoKardex2;
	}

	public SelectOneMenu getTxtTipoProducto2() {
		return txtTipoProducto2;
	}

	public SelectOneMenu getTxtProductoId_Producto2() {
		return txtProductoId_Producto2;
	}

	public SelectOneMenu getTxtUbicacionesAlmacen2() {
		return txtUbicacionesAlmacen2;
	}

	public SelectOneMenu getTxtUnidadMedida2() {
		return txtUnidadMedida2;
	}

	public InputText getTxtSaldo2() {
		return txtSaldo2;
	}

	public InputText getCantidadCompra2() {
		return cantidadCompra2;
	}

	public CommandButton getBtnAgregar2() {
		return btnAgregar2;
	}

	public List<PrecioPromProdDTO> getDataDetPrecioProductos2() {
		return dataDetPrecioProductos2;
	}

	public void setTxtConceptoKardex2(SelectOneMenu txtConceptoKardex2) {
		this.txtConceptoKardex2 = txtConceptoKardex2;
	}

	public void setTxtTipoProducto2(SelectOneMenu txtTipoProducto2) {
		this.txtTipoProducto2 = txtTipoProducto2;
	}

	public void setTxtProductoId_Producto2(SelectOneMenu txtProductoId_Producto2) {
		this.txtProductoId_Producto2 = txtProductoId_Producto2;
	}

	public void setTxtUbicacionesAlmacen2(SelectOneMenu txtUbicacionesAlmacen2) {
		this.txtUbicacionesAlmacen2 = txtUbicacionesAlmacen2;
	}

	public void setTxtUnidadMedida2(SelectOneMenu txtUnidadMedida2) {
		this.txtUnidadMedida2 = txtUnidadMedida2;
	}

	public void setTxtSaldo2(InputText txtSaldo2) {
		this.txtSaldo2 = txtSaldo2;
	}

	public void setCantidadCompra2(InputText cantidadCompra2) {
		this.cantidadCompra2 = cantidadCompra2;
	}

	public void setBtnAgregar2(CommandButton btnAgregar2) {
		this.btnAgregar2 = btnAgregar2;
	}

	public void setDataDetPrecioProductos2(List<PrecioPromProdDTO> dataDetPrecioProductos2) {
		this.dataDetPrecioProductos2 = dataDetPrecioProductos2;
	}

	public void action_agregarProductosInternos2() throws Exception {

		if (txtProductoId_Producto2.getValue() != null && txtAlmacenId_Almacen3.getValue() != null
				&& txtUnidadMedida2.getValue() != null && txtFechaRegistro.getValue() != null
				&& cantidadCompra2.getValue() != null && txtConceptoKardex2.getValue() != null) {

			Long indicador_vuelta_medidor = 0L;
			String cadereferenciaCompraMp = "";

			Long idCompania = new Long(getCompaniaIdSession());

			Long productoId = FacesUtils.checkLong(txtProductoId_Producto2);
			Object[] condicion = { "producto.productoId", true, productoId, "=" };
			List<DatProductosRelacionados> lista = (productoId != null)
					? businessDelegator2View.findByCriteriaInDatProductosRelacionados(condicion, null, null)
					: null;
			if (lista != null && lista.size() > 0) {
				costoTotalProductoFormula = 0.0;
				for (int t = 0; t < lista.size(); t++) {
					DatProductosRelacionados datProductosRelacionados = lista.get(t);

					Long productoAsociado = datProductosRelacionados.getProductoAsociadoId();
					Long unidadMedidaAsociadoId = datProductosRelacionados.getUdadMed().getUdadMedId();
					UdadMed udadMedAsociado = businessDelegatorView.getUdadMed(unidadMedidaAsociadoId);

					Double dosis = datProductosRelacionados.getDosis();

					String lotesCheck = "";
					Double areaNetaAcumulada = 0.0;
					Double area_neta = 0.0;

					Date date = new Date();
					Long compania = new Long(getCompaniaIdSession());

					// businessDelegatorView.getAlmacen(almacenId);

					Date idFecha = FacesUtils.checkDate(txtFechaRegistro);

					Long equipoId = null;
					Equipo equipo = null;
					String codEquipo = "";

					if (txtEquipoId_Equipo != null && txtEquipoId_Equipo.getValue() != null) {
						equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
						equipo = businessDelegatorView.getEquipo(equipoId);
						codEquipo = equipo.getCodigo();
					}

					Long conceptoKardexId = 7L;
					ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
					String tipoM = conceptoKardex.getTipoMovimiento();

					Producto producto = businessDelegatorView.getProducto(productoAsociado);

					String codConceptoKardex = conceptoKardex.getCodigo();
					String codProducto = producto.getCodigo();

					String codUnidadMed = udadMedAsociado.getCodigo();

					Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
					Double valorUnit = 0.0;

					Double cantidadFabricar = FacesUtils.checkDouble(cantidadCompra2);

					Double cantidadProductoRelacionado = cantidadFabricar * dosis;

					Double porcIva = 0.0;
					Double valorIva = 0.0;
					Double costoTotal = 0.0;

					Long almacenIdProductoAsociado = 0L;
					String codAlmacen = null;
					Almacen almacen = null;
					if (producto.getAlmacen() != null) {
						almacenIdProductoAsociado = producto.getAlmacen().getAlmacenId();
						almacen = businessDelegatorView.getAlmacen(almacenIdProductoAsociado);
						codAlmacen = almacen.getCodigo();
					}

					Long ubicacionesAlmacenId = null;
					UbicacionesAlmacen ubicacionesAlmacen = null;
					String codUbicacionesAlmacen = "";
					if (producto.getUbicacionesAlmacenId() != null) {
						ubicacionesAlmacenId = producto.getUbicacionesAlmacenId().getUbicacionesAlmacenId();
						ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
						codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
					}

					if (idFecha != null && unidadMedidaAsociadoId != null && compania != null
							&& almacenIdProductoAsociado != null && productoAsociado != null) {

						valorUnit = businessDelegatorView.consultarPrecioPromProducto(productoAsociado,
								almacenIdProductoAsociado, compania, idFecha).doubleValue();
						costoTotal = (valorUnit * cantidadProductoRelacionado);
						costoTotal = (double) Math.round(costoTotal * 100) / 100;

					}

					String infoAdicional = "";

					Double saldoProducto = 0.0;
					saldoProducto = businessDelegator2View
							.pr_saldo_prom_producto(productoAsociado, almacenIdProductoAsociado, compania)
							.doubleValue();
					String nomProducto = producto.getNombre();

					String loteCompraX = "";
					if (tipoM.equals("SAL")) {

						if (saldoProducto >= cantidadProductoRelacionado) {

							if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
								dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
							}

							PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
							precioPromProdDTO.setNomProducto(nomProducto);
							precioPromProdDTO.setFechaInicial(fechaInicial);
							precioPromProdDTO.setCantidadCompra(cantidadProductoRelacionado);
							precioPromProdDTO.setUnidadMedida(udadMedAsociado);
							precioPromProdDTO.setAlmacenId(almacen);
							precioPromProdDTO.setNombreUnidadMedida(codUnidadMed);
							precioPromProdDTO.setCodAlmacen(codAlmacen);
							precioPromProdDTO.setValorUnitario(valorUnit);
							precioPromProdDTO.setCompania(compania);
							precioPromProdDTO.setFechaCreacion(date);
							precioPromProdDTO.setFechaModificacion(date);
							precioPromProdDTO.setEquipoId(equipo);
							precioPromProdDTO.setConceptoKardexId(conceptoKardex);
							precioPromProdDTO.setProducto(producto);
							precioPromProdDTO.setCodProducto(codProducto);
							precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
							precioPromProdDTO.setPorcIva(porcIva);
							precioPromProdDTO.setValorIva(valorIva);
							precioPromProdDTO.setCostoTotal(costoTotal);
							precioPromProdDTO.setTipoMovimiento(tipoM);
							precioPromProdDTO.setInfoAdicional(infoAdicional);
							precioPromProdDTO.setCodEquipo(codEquipo);

							precioPromProdDTO.setLoteCompraProducto(loteCompraX);

							precioPromProdDTO.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
							precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
							precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);
							precioPromProdDTO.setReferenciaFacCompra(cadereferenciaCompraMp);

							dataDetPrecioProductos.add(precioPromProdDTO);

							loteCompraX = null;
							codEquipo = null;
							infoAdicional = null;
							infoAdicional = null;
							fechaInicial = null;
							almacen = null;
							valorUnit = null;
							codAlmacen = null;

							date = null;
							compania = null;

							equipo = null;
							conceptoKardex = null;
							producto = null;
							codProducto = null;
							codConceptoKardex = null;
							porcIva = null;
							valorIva = null;

							tipoM = null;
							costoTotalProductoFormula += costoTotal;

						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!"
											+ " Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. ",
											""));
						}

					}

				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Upps! " + "Verifique que la fórmula tenga productos asociados ", ""));
			}
			action_agregarProductosInternos();
			limpiar_pantalla3();

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!"
					+ " Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. ",
					""));
		}
		// limpiar_pantalla3();
	}

	public void limpiar_pantalla3() {
		txtProductoId_Producto2.setValue(null);
		txtUbicacionesAlmacen2.setValue(null);
		txtUnidadMedida2.setValue(null);

	}

	public Double getCostoTotalProductoFormula() {
		return costoTotalProductoFormula;
	}

	public void setCostoTotalProductoFormula(Double costoTotalProductoFormula) {
		this.costoTotalProductoFormula = costoTotalProductoFormula;
	}

	public List<String> getSelectedEquipo() {
		selectedEquipo = null;
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>" };
				equipos = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

}
