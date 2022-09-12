package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
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
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatOtrosMovInventarioDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOtrosMovimientosInventarioDTO;
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
public class DatOtrosMovInventarioAgricolaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosMovInventarioAgricolaView.class);
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

	private Calendar txtFechaInicial;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;

	private SelectOneMenu txtAlmacenId_Almacen2;
	SelectItem[] selectAlmacen2;
	private List<Almacen> almacen2;
	private InputText txtSaldo;

	private SelectOneMenu txtAlmacenId_Almacen3;
	SelectItem[] selectAlmacen3;
	private List<Almacen> almacen3;

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

	private PrecioPromProd entityPrecioProd;

	private InputText txtValorTotalProducto;
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

	private List<ListaNivel4DTO> lotes;
	private List<String> selectedLotes;
	
	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;
	
	public DatOtrosMovInventarioAgricolaView() {
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

		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
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
			txtPorcentajeIva.setValue(null);
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
			/*	if (txtEquipoId_Equipo != null) {
					txtEquipoId_Equipo.setValue(null);
					txtEquipoId_Equipo.setDisabled(false);
				}*/
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
				if (txtNivel4Id_Nivel4 != null) {
					txtNivel4Id_Nivel4.setValue(null);
					txtNivel4Id_Nivel4.setDisabled(false);
				}
*/
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
			/*	if (txtEquipoId_Equipo != null) {
					txtEquipoId_Equipo.setValue(null);
					txtEquipoId_Equipo.setDisabled(false);
				}*/
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

			/*	if (txtNivel4Id_Nivel4 != null) {
					txtNivel4Id_Nivel4.setValue(null);
					txtNivel4Id_Nivel4.setDisabled(false);
				}*/

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

				btnSave.setDisabled(false);
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

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);
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

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);
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

			businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);

			entity.setConceptoKardex(businessDelegator2View.getConceptoKardex(9L));
			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductosEntrada);
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

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);
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
			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);
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

	public List<PrecioPromProdDTO> getDataDetPrecioProductosEntrada() {

		if (dataDetPrecioProductosEntrada == null || dataDetPrecioProductosEntrada.size() == 0) {
			return null;
		} else {
			return dataDetPrecioProductosEntrada;
		}

	}

	public void action_agregarPrecioProductos() throws Exception {

		if (txtProductoId_Producto.getValue() != null && txtAlmacenId_Almacen2.getValue() != null
				&& txtUnidadMedida.getValue() != null && txtFechaRegistro.getValue() != null
				&& txtValorUnit.getValue() != null && cantidadCompra.getValue() != null
				&& txtPorcentajeIva.getValue() != null
				&& txtNivel2Id_Nivel2.getValue() != null
				) {
			
			String lotesCheck = "";
			Double areaNetaAcumulada = 0.0;
			Double area_neta = 0.0;
			if (selectedLotes != null && selectedLotes.size() > 0) {
				// lotesCheck = selectedLotes.get(0);
				for (int a = 0; a < selectedLotes.size(); a++) {
					lotesCheck = selectedLotes.get(a);
					Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
					List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
					Nivel4 entidad = listaNivel4.get(0);
					area_neta += entidad.getAreaNeta();

				}
				areaNetaAcumulada += area_neta;
			}

			String lotesSeleccionadas = "";
			if (selectedLotes != null && selectedLotes.size() > 0) {
			
				for (int j = 0; j < selectedLotes.size(); j++) {
					lotesSeleccionadas = selectedLotes.get(j);
			
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

			

			Long nivel2Id = null;
			Nivel2 nivel2 = null;
			String codigoNivel2 = "";

			if (txtNivel2Id_Nivel2 != null && txtNivel2Id_Nivel2.getValue() != null) {
				nivel2Id = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());
				nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				codigoNivel2 = nivel2.getCodigo();
			}

			Long nivel4Id = null;
		//	Nivel4 nivel4 = null;
			String codigoNivel4 = "";
			Etapa etapa = null;
			Long etapaId = null;
			Long variedId = null;

						
			Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
			List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
			Nivel4 nivel4 = listaNivel4.get(0);

			if (nivel4.getEtapa() != null) {
				etapaId = nivel4.getEtapa().getEtapaId();
			}

			if (nivel4.getVariedad() != null) {
				variedId = nivel4.getVariedad();
			}

			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();

			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			Double valorUnit = 0.0;

			if (txtValorUnit.getValue() != null) {
				valorUnit = FacesUtils.checkDouble(txtValorUnit);
			}

			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
			Double cantidadFinal = (cantidad_Compra * nivel4.getAreaNeta()) / areaNetaAcumulada;
			cantidadFinal = (double) Math.round((cantidadFinal) * 100) / 100;

			Double porcIva = 0.0;
			Double valorIva = 0.0;
			if (txtPorcentajeIva.getValue() != null) {
				porcIva = FacesUtils.checkDouble(txtPorcentajeIva);
				valorIva = (porcIva / 100) * valorUnit * cantidad_Compra;
			}

			Double costoTotal = (valorUnit * cantidadFinal) + valorIva;
			 costoTotal = (double) Math.round(costoTotal * 100) / 100;

			
			Long numFactura = null;

			if (txtNumFactura.getValue() != null) {
				numFactura = FacesUtils.checkLong(txtNumFactura);
			}
			
			String origenDatos = FacesUtils.checkString(txtOrigenDatos);

			Long compania = new Long(getCompaniaIdSession());

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
					precioPromProdDTO.setCantidadCompra(cantidadFinal);
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
				//	precioPromProdDTO.setEquipoId(equipo);
					precioPromProdDTO.setConceptoKardexId(conceptoKardex);
					precioPromProdDTO.setProducto(producto);
					precioPromProdDTO.setCodProducto(codProducto);
					precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
					precioPromProdDTO.setPorcIva(porcIva);
					precioPromProdDTO.setValorIva(valorIva);
					precioPromProdDTO.setCostoTotal(costoTotal);
					precioPromProdDTO.setTipoMovimiento(tipoM);
					precioPromProdDTO.setNumFacturaCompra(numFactura);
				//	precioPromProdDTO.setCodEquipo(codEquipo);
					precioPromProdDTO.setOrigenDatos(origenDatos);
					precioPromProdDTO.setNivel2Id_Nivel2(nivel2);
					precioPromProdDTO.setCodNivel2(codigoNivel2);
					precioPromProdDTO.setNivel4Id_Nivel4(nivel4);
					precioPromProdDTO.setCodNivel4(codigoNivel4);
					precioPromProdDTO.setEtapaId(etapaId);
					precioPromProdDTO.setVariedId(variedId);
					

					dataDetPrecioProductos.add(precioPromProdDTO);

					fechaInicial = null;
					almacen = null;
					valorUnit = null;
					codAlmacen = null;
					almacenId = null;
					date = null;
					compania = null;
					cantidad_Compra = null;
					unidadMedida = null;
					persEmpr = null;
					codPersEmpr = null;
					cantidadFinal = null;
					conceptoKardex = null;
					producto = null;
					codProducto = null;
					codConceptoKardex = null;
					porcIva = null;
					valorIva = null;
					costoTotal = null;
					tipoM = null;
					numFactura = null;
					nivel2Id = null;
					codigoNivel2 = null;
					nivel4Id = null;
					codigoNivel4 = null;
				
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
				precioPromProdDTO.setFechaInicial(fechaInicial);
				precioPromProdDTO.setCantidadCompra(cantidadFinal);
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
			//	precioPromProdDTO.setEquipoId(equipo);
				precioPromProdDTO.setConceptoKardexId(conceptoKardex);
				precioPromProdDTO.setProducto(producto);
				precioPromProdDTO.setCodProducto(codProducto);
				precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
				precioPromProdDTO.setPorcIva(porcIva);
				precioPromProdDTO.setValorIva(valorIva);
				precioPromProdDTO.setCostoTotal(costoTotal);
				precioPromProdDTO.setTipoMovimiento(tipoM);
				precioPromProdDTO.setNumFacturaCompra(numFactura);
			//	precioPromProdDTO.setCodEquipo(codEquipo);
				precioPromProdDTO.setOrigenDatos(origenDatos);
				precioPromProdDTO.setNivel2Id_Nivel2(nivel2);
				precioPromProdDTO.setCodNivel2(codigoNivel2);
				precioPromProdDTO.setNivel4Id_Nivel4(nivel4);
				precioPromProdDTO.setCodNivel4(codigoNivel4);

				dataDetPrecioProductos.add(precioPromProdDTO);

				fechaInicial = null;
				almacen = null;
				valorUnit = null;
				codAlmacen = null;
				almacenId = null;
				date = null;
				compania = null;
				cantidad_Compra = null;
				unidadMedida = null;
				persEmpr = null;
				codPersEmpr = null;
				cantidadFinal = null;
				conceptoKardex = null;
				producto = null;
				codProducto = null;
				codConceptoKardex = null;
				porcIva = null;
				valorIva = null;
				costoTotal = null;
				tipoM = null;
				numFactura = null;
				nivel2Id = null;
				codigoNivel2 = null;
				nivel4Id = null;
				codigoNivel4 = null;

				}
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
		limpiar_pantalla2();
	}

	public void action_agregarPrecioProductosSalidaSuministro() throws Exception {

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && cantidadCompra.getValue() != null
				&& txtNivel2Id_Nivel2.getValue() != null
				) {
			
			String lotesCheck = "";
			Double areaNetaAcumulada = 0.0;
			Double area_neta = 0.0;
			if (selectedLotes != null && selectedLotes.size() > 0) {
				// lotesCheck = selectedLotes.get(0);
				for (int a = 0; a < selectedLotes.size(); a++) {
					lotesCheck = selectedLotes.get(a);
					Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
					List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
					Nivel4 entidad = listaNivel4.get(0);
					area_neta += entidad.getAreaNeta();

				}
				areaNetaAcumulada += area_neta;
			}

			String lotesSeleccionadas = "";
			if (selectedLotes != null && selectedLotes.size() > 0) {
			
				for (int j = 0; j < selectedLotes.size(); j++) {
					lotesSeleccionadas = selectedLotes.get(j);
				
				{
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);
			Date idFecha = FacesUtils.checkDate(txtFechaRegistro);

			Long equipoId = null;
			Equipo equipo = null;
			String codEquipo = "";

			if (txtEquipoId_Equipo != null && txtEquipoId_Equipo.getValue() != null) {
				equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
				equipo = businessDelegatorView.getEquipo(equipoId);
				codEquipo = equipo.getCodigo();
			}

			Long nivel2Id = null;
			Nivel2 nivel2 = null;
			String codigoNivel2 = "";

			if (txtNivel2Id_Nivel2 != null && txtNivel2Id_Nivel2.getValue() != null) {
				nivel2Id = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());
				nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				codigoNivel2 = nivel2.getCodigo();
			}

			Long nivel4Id = null;
			//	Nivel4 nivel4 = null;
				String codigoNivel4 = "";
				Etapa etapa = null;
				Long etapaId = null;
				Long variedId = null;

							
				Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
				List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
				Nivel4 nivel4 = listaNivel4.get(0);

				if (nivel4.getEtapa() != null) {
					etapaId = nivel4.getEtapa().getEtapaId();
				}

				if (nivel4.getVariedad() != null) {
					variedId = nivel4.getVariedad();
				}


			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);

			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();
			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();

			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			Double valorUnit = 0.0;

			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
			Double cantidadFinal = (cantidad_Compra * nivel4.getAreaNeta()) / areaNetaAcumulada;
			cantidadFinal = (double) Math.round((cantidadFinal) * 100) / 100;

			Double porcIva = 0.0;
			Double valorIva = 0.0;
			Double costoTotal = 0.0;

			if (idFecha != null && unidadMedida != null && compania != null && almacenId != null
					&& productoId != null) {

				valorUnit = businessDelegatorView.consultarPrecioPromProducto(productoId, almacenId, compania, idFecha)
						.doubleValue();
				costoTotal = (valorUnit * cantidadFinal);
			  costoTotal = (double) Math.round(costoTotal * 100) / 100;

			}

			String infoAdicional = "";
			if (txtInfoAdicional.getValue() != null) {
				infoAdicional = FacesUtils.checkString(txtInfoAdicional);
			}
			
			String origenDatos = FacesUtils.checkString(txtOrigenDatos);

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

					if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
						dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
					}

					PrecioPromProdDTO precioPromProdDTO = new PrecioPromProdDTO();
					precioPromProdDTO.setNomProducto(nomProducto);
					precioPromProdDTO.setFechaInicial(fechaInicial);
					precioPromProdDTO.setCantidadCompra(cantidadFinal);
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
					precioPromProdDTO.setOrigenDatos(origenDatos);
					precioPromProdDTO.setNivel2Id_Nivel2(nivel2);
					precioPromProdDTO.setCodNivel2(codigoNivel2);
					precioPromProdDTO.setNivel4Id_Nivel4(nivel4);
					precioPromProdDTO.setCodNivel4(codigoNivel4);
					precioPromProdDTO.setEtapaId(etapaId);
					precioPromProdDTO.setVariedId(variedId);
					
					dataDetPrecioProductos.add(precioPromProdDTO);

					conceptoGasto = null;
					codEquipo = null;
					infoAdicional = null;
					infoAdicional = null;
					fechaInicial = null;
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
					nivel2Id = null;
					codigoNivel2 = null;
					nivel4Id = null;
					codigoNivel4 = null;
					cantidadFinal=null;

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!",
							"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));
				}
			}
     	}
		}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
		}
		limpiar_pantalla();
	}
	
	
	public void action_agregarPrecioProductosSalidaSuministroTaller() throws Exception {

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && cantidadCompra.getValue() != null) {
			Date date = new Date();
			Long almacenId = Long.parseLong(txtAlmacenId_Almacen2.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);
			Date idFecha = FacesUtils.checkDate(txtFechaRegistro);
			Long conceptoKardexId = Long.parseLong(txtConceptoKardex.getValue().toString());
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

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
			Double costoTotal = 0.0;
			Long compania = new Long(getCompaniaIdSession());
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
			
			String origenDatos = FacesUtils.checkString(txtOrigenDatos);
			
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
					precioPromProdDTO.setOrigenDatos(origenDatos);
					dataDetPrecioProductos.add(precioPromProdDTO);

					conceptoGasto = null;
					infoAdicional = null;
					infoAdicional = null;
					fechaInicial = null;
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

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!",
							"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
		limpiar_pantalla2();
	}

	
	
	
	
	public void action_agregarTraslados() throws Exception {

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && cantidadCompra.getValue() != null
				&& txtAlmacenId_Almacen3.getValue() != null) {
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
									&& d.getUnidadMedida().getUdadMedId() == udadMed.getUdadMedId()) {

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
						precioPromProdDTO.setOrigenDatos(origenDatos);

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

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!",
							"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));

				}
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha, almacén entrada y sálida,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
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
				for (Producto producto2 : lista) {
					selectProducto2[i] = new SelectItem(producto2.getProductoId(),
							producto2.getCodigo() + " - " + producto2.getNombre());
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

	public SelectItem[] getSelectContratista() {

		if (contratista == null || contratista.size() == 0) {

			// contratista = new ArrayList<PersEmpr>();

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

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
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

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		Long datOtrosMovInventario = FacesUtils.checkLong(txtDatOtrosMovInventarioId);
		if (datOtrosMovInventario != null) {
			selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioProductos"));

			Long precioProdId = selectedPrecioProductos.getPrecioProdId().longValue();

			String columnaCell = evt.getColumn().getHeaderText();

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null) {

				entityPrecioProd = null;
				entityPrecioProd = businessDelegatorView.getPrecioPromProd(precioProdId);

				if (columnaCell.equals("Fecha")) {

					entityPrecioProd.setFechaInicial((Date) newValue);

				}
				if (columnaCell.equals("Almacen")) {

					Long almacenId = new Long(evt.getNewValue().toString());
					Almacen e = businessDelegatorView.getAlmacen(almacenId);

					entityPrecioProd.setAlmacenId(e);

				}
				if (columnaCell.equals("Prod.")) {

					Long productoId = new Long(evt.getNewValue().toString());
					Producto e = businessDelegatorView.getProducto(productoId);

					entityPrecioProd.setProducto(e);

				}
				if (columnaCell.equals("U.M.")) {

					Long umId = new Long(evt.getNewValue().toString());
					UdadMed e = businessDelegatorView.getUdadMed(umId);

					entityPrecioProd.setUnidadMedida(e);

				}
				if (columnaCell.equals("Cant.")) {

					entityPrecioProd.setCantidadCompra(Double.valueOf(evt.getNewValue().toString()));

				}
				if (columnaCell.equals("Precio")) {

					entityPrecioProd.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));

				}
				if (columnaCell.equals("Iva")) {

					entityPrecioProd.setValorIva(Double.valueOf(evt.getNewValue().toString()));

				}
				if (columnaCell.equals("VR. Total")) {

					entityPrecioProd.setCostoTotal(Double.valueOf(evt.getNewValue().toString()));

				}
				if (columnaCell.equals("Maq")) {

					Long maqId = new Long(evt.getNewValue().toString());
					Equipo e = businessDelegatorView.getEquipo(maqId);

					entityPrecioProd.setEquipoId(e);

				}
				if (columnaCell.equals("Hacienda")) {

					Long nivel2Id = new Long(evt.getNewValue().toString());
					Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityPrecioProd.setNivel2Id(nivel2);

				}
				if (columnaCell.equals("Suerte")) {

					Long nivel4Id = new Long(evt.getNewValue().toString());
					Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

					entityPrecioProd.setNivel4Id(nivel4);
				}

				entity = businessDelegator2View.getDatOtrosMovInventario(datOtrosMovInventario);
				entityPrecioProd.setDatOtrosMovInventarioId(entity);
				businessDelegatorView.updatePrecioPromProd(entityPrecioProd);

				selectedPrecioProductos = null;
				entityPrecioProd = null;

				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datOtrosMovInventario);

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"Para poder modificar la información, primero los datos deben estar grabados. "));
			}
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

	public void limpiar_pantalla() {
		//txtTipoProducto.setValue(null);
		txtProductoId_Producto.setValue(null);
		txtAlmacenId_Almacen2.setValue(null);
		txtSaldo.setValue(null);
		// txtValorUnit.setValue(null);
		cantidadCompra.setValue(null);
		txtUnidadMedida.setValue(null);

		
			txtNivel2Id_Nivel2.setValue(null);
		//txtNivel4Id_Nivel4.setValue(null);
			lotes=null;
		
		txtInfoAdicional.setValue(null);
		txtLaborId_Labor.setValue(null);
	}

	public void limpiar_pantalla2() {
		txtSaldo.setValue(null);
	//	txtTipoProducto.setValue(null);
		txtProductoId_Producto.setValue(null);
		txtAlmacenId_Almacen2.setValue(null);
		// txtValorUnit.setValue(null);
		lotes=null;
		txtNivel2Id_Nivel2.setValue(null);
		cantidadCompra.setValue(null);
		txtUnidadMedida.setValue(null);
		// txtEquipoId_Equipo.setValue(null);
		//txtInfoAdicional.setValue(null);
		//txtLaborId_Labor.setValue(null);
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
						documento, 0l,centCost);
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


	public SelectItem[] getSelectProductoId() {

		if (productoId == null || productoId.size() == 0) {

			// producto2 = new ArrayList<Producto2>();

			try {

				//producto2 = businessDelegatorView.getProducto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoId = new SelectItem[lista.size()];

				int i = 0;
				for (Producto producto2 : lista) {
					selectProductoId[i] = new SelectItem(producto2.getProductoId(),
							producto2.getCodigo() + " - " + producto2.getNombre());
					i++;

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

		if (txtNivel2Id_Nivel2 != null && txtNivel2Id_Nivel2.getValue()!=null) {
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

	public SelectOneMenu getTxtCentCostConsulta() {
		return txtCentCostConsulta;
	}

	public void setTxtCentCostConsulta(SelectOneMenu txtCentCostConsulta) {
		this.txtCentCostConsulta = txtCentCostConsulta;
	}

	
	

}
