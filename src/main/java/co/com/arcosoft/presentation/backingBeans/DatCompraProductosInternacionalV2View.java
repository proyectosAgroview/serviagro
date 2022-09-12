package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
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
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatCompraProductosDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.dto.ProductoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraMateriaPrimaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
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
public class DatCompraProductosInternacionalV2View implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DatCompraProductosInternacionalV2View.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputTextarea txtDetalleNota;
	private InputText txtDistribuirCantidad;
	private SelectOneRadio txtEstado;
	private InputText txtNumFactura;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatCompraProductosId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatCompraProductosDTO> data;
	private List<ConsultaCompraProductosDTO> data2;
	private ConsultaCompraProductosDTO selectedDatCompraProductos2;
	private DatCompraProductosDTO selectedDatCompraProductos;
	private DatCompraProductos entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;

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

	private InputText txtSaldo;

	private SelectOneMenu txtAlmacenId_Almacen3;
	SelectItem[] selectAlmacen3;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private InputText txtCodAlmacen;
	private InputText txtCodUnidadMedida;

	private InputText txtCodPersEmpr;

	private SelectOneMenu txtPersEmpr;
	SelectItem[] selectContratista;

	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;

	SelectItem[] selectProducto2;

	private int activeTapIndex = 0;

	private List<PrecioPromProdDTO> dataDetPrecioProductos;
	private List<PrecioPromProdDTO> dataDetPrecioProductosEntrada;
	private PrecioPromProdDTO selectedPrecioProductos;

	private PrecioPromProd entityPrecioProd;

	private InputText txtValorTotalProducto;
	private InputText txtImpuestosProducto;

	private InputText txtConsecutivoPrecioPromedio;

	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;

	private InputText txtTipoMovimiento;
	private InputText txtNumFacturaPPromedio;
	private InputText txtCostoTotalPPromedio;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;

	private SelectOneMenu txtTrabajadorId_Trabajador;
	SelectItem[] selectTrabajador;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;

	private InputText txtPorcentajeIva;

	private InputTextarea txtInfoAdicional;
	private SelectOneMenu txtTipoMoneda;
	private InputText txtTasaConversionTrm;

	private InputNumber txtSubTotalValorFactura;
	private InputNumber txtValorFactura;
	private InputNumber txtImpuestos;
	private InputNumber txtValorDescuento;

	private List<String> selectedCliente;

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;

	private InputText txtDocumentoC;
	private InputNumber txtValorAdicional;
	private List<Producto> dataProducto;
	private List<ProductoDTO> dataProducto2;
	private ProductoDTO selectedProducto;
	private InputText txtProductoCodigo;
	private InputText txtProductoDescripcion;

	private Producto entityProducto;
	private InputTextarea txtTransportadoraFactura;

	private InputText txtTransportadoraNGuia;
	private InputNumber txtTransportadoraValorFlete;

	private InputText txtUbicacionAlmacen;
	SelectItem[] selectUbAlmacen;

	/*** consulta saldos por ubicacio***/
	private List<ConsultaStockMaquinariaDTO> dataProductoUbicacion;
	ConsultaStockMaquinariaDTO	selectedProductoUbicacion;	
	
	private SelectOneMenu txtDatMantenimientoEquipoId;
	SelectItem[] selectDatMantenimientoEquipoId;
	
	/*** ***** Proveedores ***** ***/
	
	private SelectOneMenu txtProvTransporteFlete;
	SelectItem[] selectProvTransporteFlete;
	
	private SelectOneMenu txtProvGastosNacionales;
	SelectItem[] selectProvGastosNacionales;
	
	private SelectOneMenu txtProvImpuestosAranceles;
	SelectItem[] selectProvImpuestosAranceles;
	
	private SelectOneMenu txtProvComisiones;
	SelectItem[] selectProvComisiones;
	
	private SelectOneMenu txtProvOtros;
	SelectItem[] selectProvOtros;
	
	private InputNumber txtValTransporteFlete;	
	private InputNumber txtValGastosNacionales;	
	private InputNumber txtValImpuestosAranceles;	
	private InputNumber txtValComisiones;	
	private InputNumber txtValOtros;
	
	private InputNumber txtValTotalSuma;
	private InputNumber txtValTotalSuma2; //adicional
	
	
	private List<String> selectedOrdenMtto;
	private List<SolicitudesMttoEquipoDTO> ordenMtto;
	
	
	private List<String> selectedOrdenMp;
	private List<ConsultaCompraMateriaPrimaDTO> ordenMp;
	private SelectOneMenu txtTipoCompraFiltro;
	private InputText txtDocumentoFactura;
	public DatCompraProductosInternacionalV2View() {
		super();
	}

	public String action_new() throws Exception {
		action_clear();
		selectedDatCompraProductos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws Exception {
		entity = null;
		selectedDatCompraProductos = null;
		PrimeFaces.current().resetInputs(":frm");

		activeTapIndex = 0;
		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtDatMantenimientoEquipoId != null) {
			txtDatMantenimientoEquipoId.setValue(null);
			txtDatMantenimientoEquipoId.setDisabled(false);
		}
		if (ordenMp != null) {
			ordenMp = null;
			
		}
		
		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtProductoCodigo != null) {
			txtProductoCodigo.setValue(null);
			txtProductoCodigo.setDisabled(false);
		}

		if (txtTransportadoraFactura != null) {
			txtTransportadoraFactura.setValue(null);
			txtTransportadoraFactura.setDisabled(false);
		}

		if (txtTransportadoraNGuia != null) {
			txtTransportadoraNGuia.setValue(null);
			txtTransportadoraNGuia.setDisabled(false);
		}

		if (txtTransportadoraValorFlete != null) {
			txtTransportadoraValorFlete.setValue(null);
			txtTransportadoraValorFlete.setDisabled(false);
		}

		if (txtProductoDescripcion != null) {
			txtProductoDescripcion.setValue(null);
			txtProductoDescripcion.setDisabled(false);
		}

		if (txtDetalleNota != null) {
			txtDetalleNota.setValue(null);
			txtDetalleNota.setDisabled(false);
		}

		if (txtTipoMoneda != null) {
			txtTipoMoneda.setValue(null);
			txtTipoMoneda.setDisabled(false);
		}
		if (txtValorAdicional != null) {
			txtValorAdicional.setValue(null);
			txtValorAdicional.setDisabled(false);
		}

		if (txtSubTotalValorFactura != null) {
			txtSubTotalValorFactura.setValue(null);
			txtSubTotalValorFactura.setDisabled(false);
		}
		
		if (txtValorFactura != null) {
			txtValorFactura.setValue(null);
			txtValorFactura.setDisabled(false);
		}

		if (txtImpuestos != null) {
			txtImpuestos.setValue(null);
			txtImpuestos.setDisabled(false);
		}

		if (txtValorDescuento != null) {
			txtValorDescuento.setValue(null);
			txtValorDescuento.setDisabled(false);
		}

		if (txtTasaConversionTrm != null) {
			txtTasaConversionTrm.setValue(null);
			txtTasaConversionTrm.setDisabled(true);
		}

		if (txtSaldo != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(false);
		}

		if (txtAlmacenId_Almacen3 != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(false);
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

		if (txtDatCompraProductosId != null) {
			txtDatCompraProductosId.setValue(null);
			txtDatCompraProductosId.setDisabled(false);
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
			txtValorUnit.setValue(0);
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

		if (txtUbicacionAlmacen != null) {
			txtUbicacionAlmacen.setValue(null);
			txtUbicacionAlmacen.setDisabled(false);
		}
		
		/*** ***** Proveedores ***** ***/

		if (txtProvTransporteFlete != null) {
			txtProvTransporteFlete.setValue(null);
			txtProvTransporteFlete.setDisabled(false);
		}

		if (txtProvGastosNacionales != null) {
			txtProvGastosNacionales.setValue(null);
			txtProvGastosNacionales.setDisabled(false);
		}

		if (txtProvImpuestosAranceles != null) {
			txtProvImpuestosAranceles.setValue(null);
			txtProvImpuestosAranceles.setDisabled(false);
		}

		if (txtProvComisiones != null) {
			txtProvComisiones.setValue(null);
			txtProvComisiones.setDisabled(false);
		}

		if (txtProvOtros != null) {
			txtProvOtros.setValue(null);
			txtProvOtros.setDisabled(false);
		}

		if (txtValTransporteFlete != null) {
			txtValTransporteFlete.setValue(null);
			txtValTransporteFlete.setDisabled(false);
		}

		if (txtValGastosNacionales != null) {
			txtValGastosNacionales.setValue(null);
			txtValGastosNacionales.setDisabled(false);
		}

		if (txtValImpuestosAranceles != null) {
			txtValImpuestosAranceles.setValue(null);
			txtValImpuestosAranceles.setDisabled(false);
		}

		if (txtValComisiones != null) {
			txtValComisiones.setValue(null);
			txtValComisiones.setDisabled(false);
		}

		if (txtValOtros != null) {
			txtValOtros.setValue(null);
			txtValOtros.setDisabled(false);
		}

		if (txtValTotalSuma != null) {
			txtValTotalSuma.setValue(null);
			txtValTotalSuma.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		if (txtValTotalSuma2 != null) {
			txtValTotalSuma2.setValue(null);
			txtValTotalSuma2.setDisabled(false);
		}

		
		return "";
	}

	public String action_edit(ActionEvent evt) {
		selectedDatCompraProductos2 = (ConsultaCompraProductosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatCompraProductos2"));
		try {

			Long datCompraProductosId = selectedDatCompraProductos2.getDatCompraProductosId().longValue();
			Object[] condicion = { "datCompraProductosId", true, datCompraProductosId, "=" };
			List<DatCompraProductos> lista = (datCompraProductosId != null)
					? businessDelegator2View.findByCriteriaInDatCompraProductos(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);

			//	txtDatMantenimientoEquipoId.setValue(entity.getDatMantenimientoEquipoId() != null ? entity.getDatMantenimientoEquipoId().getDatMantenimientoEquipoId() : null);				
			///	txtDatMantenimientoEquipoId.setDisabled(false);
				
				txtTransportadoraFactura.setValue(entity.getTransportadoraFactura());
				txtTransportadoraFactura.setDisabled(false);
				txtTransportadoraNGuia.setValue(entity.getTransportadora_nguia());
				txtTransportadoraNGuia.setDisabled(false);
				txtTransportadoraValorFlete.setValue(entity.getTransportadora_valor_flete());
				txtTransportadoraValorFlete.setDisabled(false);

				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtTipoMoneda.setValue(entity.getTipoMoneda());
				txtTipoMoneda.setDisabled(false);
				
				if (entity.getSubTotalFactura() != null) {
					txtSubTotalValorFactura.setValue(entity.getSubTotalFactura());
				} else {
					txtSubTotalValorFactura.setValue(0.0);
				}
				
				txtSubTotalValorFactura.setDisabled(false);
				txtValorFactura.setValue(entity.getValorFactura());
				txtValorFactura.setDisabled(false);
				txtImpuestos.setValue(entity.getValorIva());
				txtImpuestos.setDisabled(false);
				txtValorDescuento.setValue(entity.getValorDescuento());
				txtValorDescuento.setDisabled(false);

				txtTasaConversionTrm.setValue(entity.getTasaConversionTrm());

				if (txtTipoMoneda.getValue() != null) {
					if (txtTipoMoneda.getValue().equals("Dolares")) {
						txtTasaConversionTrm.setDisabled(false);
						txtValorDescuento.setDisabled(true);

					} else {
						txtTasaConversionTrm.setDisabled(true);
						txtValorDescuento.setDisabled(false);
					}
				}

				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtNumFactura.setValue(entity.getNumFactura());
				txtNumFactura.setDisabled(false);

				txtPersEmpr.setValue(entity.getPersEmpr() != null ?  entity.getPersEmpr().getPersEmprId() : null);
				txtPersEmpr.setDisabled(false);
				
				txtDatCompraProductosId.setValue(entity.getDatCompraProductosId());
				txtDatCompraProductosId.setDisabled(true);
				
				if(entity.getObservacion()!=null){
						String aux_cadena = entity.getObservacion();
						if(!aux_cadena.equals("")) {
						String[] tmp = new String[aux_cadena.length() - 1];

						StringTokenizer st = new StringTokenizer(aux_cadena, ", ");

						selectedOrdenMtto = new ArrayList<String>();

						int i = 0;
						while (st.hasMoreTokens()) {
							tmp[i] = st.nextToken();
							selectedOrdenMtto.add(tmp[i]);
							i++;
						}
						String cadena = ""; List<String> aux1= selectedOrdenMtto; for (int j = 0; j <
								 aux1.size(); j++) { cadena +=aux1.get(j)+","; }
						}
						}

				if(entity.getReferenciaCompraMp()!=null){
					String aux_cadena = entity.getReferenciaCompraMp();
					if(!aux_cadena.equals("")) {
					String[] tmp = new String[aux_cadena.length() - 1];

					StringTokenizer st = new StringTokenizer(aux_cadena, ", ");

					selectedOrdenMp = new ArrayList<String>();

					int i = 0;
					while (st.hasMoreTokens()) {
						tmp[i] = st.nextToken();
						selectedOrdenMp.add(tmp[i]);
						i++;
					}
					String cadena = ""; List<String> aux1= selectedOrdenMp; for (int j = 0; j <
							 aux1.size(); j++) { cadena +=aux1.get(j)+","; }
					}
					}		
				
				
				/*** ***** Proveedores ***** ***/
				if(entity.getProvTransporteFlete()!=null) {
				txtProvTransporteFlete.setValue(entity.getProvTransporteFlete());
				}
				txtProvTransporteFlete.setDisabled(false);
				
				if(	entity.getProvGastosNacionales()!=null) {
			
				txtProvGastosNacionales.setValue(entity.getProvGastosNacionales());
				}
				txtProvGastosNacionales.setDisabled(false);
				
				if(entity.getProvImpuestosAranceles()!=null) {
				txtProvImpuestosAranceles.setValue(entity.getProvImpuestosAranceles());
				}
				txtProvImpuestosAranceles.setDisabled(false);
				
				if(entity.getProvComisiones()!=null) {
				txtProvComisiones.setValue(entity.getProvComisiones());
				}
				txtProvComisiones.setDisabled(false);
				
				if(entity.getProvOtros()!=null) {
				txtProvOtros.setValue(entity.getProvOtros());
				}
				txtProvOtros.setDisabled(false);
				
				
				txtValTransporteFlete.setValue(entity.getValTransporteFlete());
				txtValTransporteFlete.setDisabled(false);
				txtValGastosNacionales.setValue(entity.getValGastosNacionales());
				txtValGastosNacionales.setDisabled(false);
				txtValImpuestosAranceles.setValue(entity.getValImpuestosAranceles());
				txtValImpuestosAranceles.setDisabled(false);
				txtValComisiones.setValue(entity.getValComisiones());
				txtValComisiones.setDisabled(false);
				txtValOtros.setValue(entity.getValOtros());
				txtValOtros.setDisabled(false);
				if(entity.getValSumaProvs()!=null) {
					txtValTotalSuma.setValue(entity.getValSumaProvs());
					txtValTotalSuma2.setValue(entity.getValSumaProvs());
				}
				txtValTotalSuma.setDisabled(false);
				txtValTotalSuma2.setDisabled(false);
				
				/*** ***** Detalle productos ***** ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByCompras(datCompraProductosId);

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

				if (txtUbicacionAlmacen != null) {
					txtUbicacionAlmacen.setValue(null);
					txtUbicacionAlmacen.setDisabled(false);
				}
				
				btnAgregar.setDisabled(true);
				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	@SuppressWarnings("unused")
	public String actionDeleteCompras(ActionEvent evt) {
		selectedDatCompraProductos2 = (ConsultaCompraProductosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatCompraProductos2"));
		try {

			Long datCompraProductosId = selectedDatCompraProductos2.getDatCompraProductosId().longValue();
			Object[] condicion = { "datCompraProductosId", true, datCompraProductosId, "=" };
			List<DatCompraProductos> lista = (datCompraProductosId != null)
					? businessDelegator2View.findByCriteriaInDatCompraProductos(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {
						Long borrarDetalle = businessDelegator2View.pr_borrar_dat_compra_detalle(datCompraProductosId);
						Long borrarCompra = businessDelegator2View.pr_borrar_compra(datCompraProductosId);
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

	public String action_editSalidaSuministros(ActionEvent evt) {
		selectedDatCompraProductos = (DatCompraProductosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatCompraProductos"));
		try {

			Long datCompraProductosId = selectedDatCompraProductos.getDatCompraProductosId();
			Object[] condicion = { "datCompraProductosId", true, datCompraProductosId, "=" };
			List<DatCompraProductos> lista = (datCompraProductosId != null)
					? businessDelegator2View.findByCriteriaInDatCompraProductos(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtDatCompraProductosId.setValue(entity.getDatCompraProductosId());
				txtDatCompraProductosId.setDisabled(true);

				/************** Detalle productos ***/
				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByInventarios(datCompraProductosId);

				if (txtInfoAdicional != null) {
					txtInfoAdicional.setValue(null);
					txtInfoAdicional.setDisabled(false);
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

	public String action_save() {
		try {
			if ((selectedDatCompraProductos == null) && (entity == null)) {
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

	@SuppressWarnings("unused")
	public String action_create() {
		try {
			entity = new DatCompraProductos();
			
			
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			
			Double valorFactura = FacesUtils.checkDouble(txtValorFactura);
			Double totalSuma = FacesUtils.checkDouble(txtValTotalSuma);
			
			String cadena = "";
			if(selectedOrdenMtto!=null) {
			List<String> aux1 = selectedOrdenMtto;
			for (int i = 0; i < aux1.size(); i++) {
				cadena += aux1.get(i) + ",";
			}
			}
			
			String cadereferenciaCompraMp = "";
			if (selectedOrdenMp != null) {
				List<String> aux1 = selectedOrdenMp;
				for (int i = 0; i < aux1.size(); i++) {
					cadereferenciaCompraMp += aux1.get(i) + ",";
				}
			}
			entity.setReferenciaCompraMp(cadereferenciaCompraMp);
			entity.setObservacion(cadena);

			entity.setTipoCompra("Internacional");
			entity.setTransportadoraFactura(FacesUtils.checkString(txtTransportadoraFactura));
			entity.setTransportadora_nguia(FacesUtils.checkString(txtTransportadoraNGuia));
			entity.setTransportadora_valor_flete(FacesUtils.checkDouble(txtTransportadoraValorFlete));
			entity.setCompania(compania);
			entity.setConsecutivo(businessDelegator2View.consultarConsecutivoDatCompraProductos(compania));
			entity.setTasaConversionTrm(FacesUtils.checkDouble(txtTasaConversionTrm));
			entity.setTipoMoneda(FacesUtils.checkString(txtTipoMoneda));			
			entity.setValorFactura(valorFactura);			
			entity.setValorIva(FacesUtils.checkDouble(txtImpuestos));
			entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
			entity.setSubTotalFactura(FacesUtils.checkDouble(txtSubTotalValorFactura));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setEstado("A");
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);

			entity.setProvTransporteFlete(FacesUtils.checkLong(txtProvTransporteFlete));
			entity.setProvGastosNacionales(FacesUtils.checkLong(txtProvGastosNacionales));
			entity.setProvImpuestosAranceles(FacesUtils.checkLong(txtProvImpuestosAranceles));
			entity.setProvComisiones(FacesUtils.checkLong(txtProvComisiones));
			entity.setProvOtros(FacesUtils.checkLong(txtProvOtros));

			entity.setValTransporteFlete(FacesUtils.checkDouble(txtValTransporteFlete));
			entity.setValGastosNacionales(FacesUtils.checkDouble(txtValGastosNacionales));
			entity.setValImpuestosAranceles(FacesUtils.checkDouble(txtValImpuestosAranceles));
			entity.setValComisiones(FacesUtils.checkDouble(txtValComisiones));
			entity.setValOtros(FacesUtils.checkDouble(txtValOtros));
			
			entity.setValSumaProvs(totalSuma);
			
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setDatMantenimientoEquipoId((FacesUtils.checkLong(txtDatMantenimientoEquipoId) != null)
					? businessDelegatorView.getDatMantenimientoEquipo(FacesUtils.checkLong(txtDatMantenimientoEquipoId))
					: null);

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -1000);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {
				
				businessDelegator2View.saveDatCompraProductos(entity, dataDetPrecioProductos, valorFactura, totalSuma);

				Long idCompras = businessDelegator2View.pr_max_id_unico_dat_compras(compania);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
						+ (businessDelegator2View.consultarConsecutivoDatCompraProductos(compania) - 1));
				
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

	@SuppressWarnings("unused")
	public String action_modify() {
		try {
			if (entity == null) {
				Long datCompraProductosId = new Long(selectedDatCompraProductos.getDatCompraProductosId());
				entity = businessDelegator2View.getDatCompraProductos(datCompraProductosId);
			}
			entity = new DatCompraProductos();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			String cadena = "";
			if(selectedOrdenMtto!=null) {
			List<String> aux1 = selectedOrdenMtto;
			for (int i = 0; i < aux1.size(); i++) {
				cadena += aux1.get(i) + ",";
			}
			}
			String cadereferenciaCompraMp = "";
			if (selectedOrdenMp != null) {
				List<String> aux1 = selectedOrdenMp;
				for (int i = 0; i < aux1.size(); i++) {
					cadereferenciaCompraMp += aux1.get(i) + ",";
				}
			}
			entity.setReferenciaCompraMp(cadereferenciaCompraMp);
			entity.setObservacion(cadena);

			entity.setTipoCompra("Internacional");
			entity.setTransportadoraFactura(FacesUtils.checkString(txtTransportadoraFactura));
			entity.setTransportadora_nguia(FacesUtils.checkString(txtTransportadoraNGuia));
			entity.setTransportadora_valor_flete(FacesUtils.checkDouble(txtTransportadoraValorFlete));
			entity.setTasaConversionTrm(FacesUtils.checkDouble(txtTasaConversionTrm));
			entity.setTipoMoneda(FacesUtils.checkString(txtTipoMoneda));
			entity.setValorFactura(FacesUtils.checkDouble(txtValorFactura));
			entity.setValorIva(FacesUtils.checkDouble(txtImpuestos));
			entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
			entity.setSubTotalFactura(FacesUtils.checkDouble(txtSubTotalValorFactura));
			entity.setCompania(compania);
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setDatCompraProductosId(FacesUtils.checkLong(txtDatCompraProductosId));
			entity.setEstado(estado);
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(usuarioId);
			
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);
			entity.setDatMantenimientoEquipoId((FacesUtils.checkLong(txtDatMantenimientoEquipoId) != null)
					? businessDelegatorView.getDatMantenimientoEquipo(FacesUtils.checkLong(txtDatMantenimientoEquipoId))
					: null);

			entity.setProvTransporteFlete(FacesUtils.checkLong(txtProvTransporteFlete));
			entity.setProvGastosNacionales(FacesUtils.checkLong(txtProvGastosNacionales));
			entity.setProvImpuestosAranceles(FacesUtils.checkLong(txtProvImpuestosAranceles));
			entity.setProvComisiones(FacesUtils.checkLong(txtProvComisiones));
			entity.setProvOtros(FacesUtils.checkLong(txtProvOtros));

			entity.setValTransporteFlete(FacesUtils.checkDouble(txtValTransporteFlete));
			entity.setValGastosNacionales(FacesUtils.checkDouble(txtValGastosNacionales));
			entity.setValImpuestosAranceles(FacesUtils.checkDouble(txtValImpuestosAranceles));
			entity.setValComisiones(FacesUtils.checkDouble(txtValComisiones));
			entity.setValOtros(FacesUtils.checkDouble(txtValOtros));
			
			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -365);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				businessDelegator2View.updateDatCompraProductos(entity, dataDetPrecioProductos);
				Long idCompras = FacesUtils.checkLong(txtDatCompraProductosId);
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
			selectedDatCompraProductos = (DatCompraProductosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatCompraProductos"));

			Long datCompraProductosId = new Long(selectedDatCompraProductos.getDatCompraProductosId());
			entity = businessDelegator2View.getDatCompraProductos(datCompraProductosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datCompraProductosId = FacesUtils.checkLong(txtDatCompraProductosId);
			entity = businessDelegator2View.getDatCompraProductos(datCompraProductosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatCompraProductos(entity);
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
			selectedDatCompraProductos = (DatCompraProductosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatCompraProductos"));

			Long datCompraProductosId = new Long(selectedDatCompraProductos.getDatCompraProductosId());
			entity = businessDelegator2View.getDatCompraProductos(datCompraProductosId);
			businessDelegator2View.deleteDatCompraProductos(entity);
			data.remove(selectedDatCompraProductos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
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

	public InputText getTxtDatCompraProductosId() {
		return txtDatCompraProductosId;
	}

	public void setTxtDatCompraProductosId(InputText txtDatCompraProductosId) {
		this.txtDatCompraProductosId = txtDatCompraProductosId;
	}

	public List<DatCompraProductosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatCompraProductos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatCompraProductosDTO> datCompraProductosDTO) {
		this.data = datCompraProductosDTO;
	}

	public DatCompraProductosDTO getSelectedDatCompraProductos() {
		return selectedDatCompraProductos;
	}

	public void setSelectedDatCompraProductos(DatCompraProductosDTO datCompraProductos) {
		this.selectedDatCompraProductos = datCompraProductos;
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

		if (txtAlmacenId_Almacen2.getValue() != null && txtUnidadMedida.getValue() != null
				&& txtFechaRegistro.getValue() != null && txtValorUnit.getValue() != null
				&& cantidadCompra.getValue() != null && txtPorcentajeIva.getValue() != null) {

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

			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";			
			if (txtUbicacionAlmacen != null && !txtUbicacionAlmacen.getValue().equals("")) {
				String nombre = FacesUtils.checkString(txtUbicacionAlmacen);
				
				Object[] condicion = { "codigo", true, nombre, "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion, null, null);
				
				if (lista != null && lista.size() > 0) {					
					ubicacionesAlmacen = lista.get(0);
					codUbicacionesAlmacen = ubicacionesAlmacen.getNombre();
					
				} else {					
					ubicacionesAlmacen = new UbicacionesAlmacen();
					
					ubicacionesAlmacen.setCodigo(nombre);
					ubicacionesAlmacen.setCompania(Long.parseLong(getCompaniaIdSession()));
					ubicacionesAlmacen.setEstado("A");
					ubicacionesAlmacen.setFechaCreacion(date);
					ubicacionesAlmacen.setNombre(nombre);
					businessDelegator2View.saveUbicacionesAlmacen(ubicacionesAlmacen);

					codUbicacionesAlmacen = ubicacionesAlmacen.getNombre();
				}
			}

			Long conceptoKardexId = 4L;
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String tipoM = conceptoKardex.getTipoMovimiento();

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);

			String codConceptoKardex = conceptoKardex.getCodigo();
			String codProducto = producto.getCodigo();

			String codAlmacen = almacen.getCodigo();
			String codUnidadMed = udadMed.getCodigo();
			String nomProducto = producto.getNombre();
			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));

			Double valorUnit = 0.0;

			if (txtTasaConversionTrm.getValue() != null && txtTipoMoneda.getValue() != null) {
				if (txtTipoMoneda.getValue().equals("Dolares")) {
					if (txtValorUnit.getValue() != null) {
						Double val1 = FacesUtils.checkDouble(txtValorUnit);
						Double val2 = FacesUtils.checkDouble(txtTasaConversionTrm);
						valorUnit = val1 * val2;
					}
				} else {
					if (txtValorUnit.getValue() != null) {
						valorUnit = FacesUtils.checkDouble(txtValorUnit);
					}
				}
			} else {
				if (txtValorUnit.getValue() != null) {
					valorUnit = FacesUtils.checkDouble(txtValorUnit);
				}
			}

			Double cantidad_Compra = FacesUtils.checkDouble(cantidadCompra);
			Double porcIva = 0.0;
			Double valorIva = 0.0;

			if (txtTasaConversionTrm.getValue() != null && txtTipoMoneda.getValue() != null) {
				if (txtTipoMoneda.getValue().equals("Dolares")) {
					if (txtPorcentajeIva.getValue() != null) {
						porcIva = FacesUtils.checkDouble(txtPorcentajeIva);
						valorIva = (porcIva / 100) * valorUnit * cantidad_Compra;
					}
				} else {
					if (txtPorcentajeIva.getValue() != null) {
						porcIva = FacesUtils.checkDouble(txtPorcentajeIva);
						valorIva = (porcIva / 100) * valorUnit * cantidad_Compra;
					}
				}
			} else {
				if (txtPorcentajeIva.getValue() != null) {
					porcIva = FacesUtils.checkDouble(txtPorcentajeIva);
					valorIva = (porcIva / 100) * valorUnit * cantidad_Compra;
				}
			}

			Double costoTotal = (valorUnit * cantidad_Compra) + valorIva;
			// String tipoM = FacesUtils.checkString(txtTipoMovimiento);
			Long numFactura = null;
			if (txtNumFactura.getValue() != null) {
				numFactura = FacesUtils.checkLong(txtNumFactura);
			}

			Long compania = new Long(getCompaniaIdSession());

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
			precioPromProdDTO.setConceptoKardexId(conceptoKardex);
			precioPromProdDTO.setProducto(producto);
			precioPromProdDTO.setCodProducto(codProducto);
			precioPromProdDTO.setCodConceptoKardex(codConceptoKardex);
			precioPromProdDTO.setPorcIva(porcIva);
			precioPromProdDTO.setValorIva(valorIva);
			precioPromProdDTO.setCostoTotal(costoTotal);
			precioPromProdDTO.setTipoMovimiento(tipoM);
			precioPromProdDTO.setNumFacturaCompra(numFactura);
			precioPromProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
			precioPromProdDTO.setNomUbicacionesAlmacen(codUbicacionesAlmacen);
			dataDetPrecioProductos.add(precioPromProdDTO);

			double subTotalValorTotal = 0;
			double impuestos = 0;
			double valorTotal = 0;
			for (PrecioPromProdDTO data1 : dataDetPrecioProductos) {
				subTotalValorTotal += (data1.getCostoTotal().doubleValue() - data1.getValorIva().doubleValue());
				impuestos += data1.getValorIva().doubleValue();
				valorTotal += data1.getCostoTotal().doubleValue();
			}

			Double valorDescuento = FacesUtils.checkDouble(txtValorDescuento);

			if (valorDescuento != null) {

				Double subTotalMenosDescuento = subTotalValorTotal - valorDescuento;
				Double porimp1 = FacesUtils.checkDouble(txtPorcentajeIva);
				txtImpuestos.setValue((porimp1 / 100) * subTotalMenosDescuento);
				txtValorFactura.setValue(subTotalMenosDescuento + impuestos);
				txtSubTotalValorFactura.setValue(subTotalValorTotal);
			}

			if (valorDescuento == null) {

				txtSubTotalValorFactura.setValue(subTotalValorTotal);
				txtImpuestos.setValue(impuestos);
				txtValorFactura.setValue(valorTotal);
			}

			producto.setUbicacionesAlmacenId(ubicacionesAlmacen);
			businessDelegatorView.updateProducto(producto);
			
			limpiar_pantalla();
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

			conceptoKardex = null;
			producto = null;
			codProducto = null;
			codConceptoKardex = null;
			porcIva = null;
			valorIva = null;
			costoTotal = null;
			tipoM = null;
			numFactura = null;

			ubicacionesAlmacen = null;
			codUbicacionesAlmacen = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
	}

	public DatCompraProductos getEntity() {
		return entity;
	}

	public void setEntity(DatCompraProductos entity) {
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

	public InputText getTxtImpuestosProducto() {
		return txtImpuestosProducto;
	}

	public void setTxtImpuestosProducto(InputText txtImpuestosProducto) {
		this.txtImpuestosProducto = txtImpuestosProducto;
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

		if (selectProducto2 == null || selectProducto2.length == 0) {

			try {
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

	public SelectItem[] getSelectProductoId() throws NumberFormatException, Exception {
		if (txtTipoProducto.getValue() != null) {

			Long idCompania = new Long(getCompaniaIdSession());
			Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
			
			try {
				List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania, tipoProducto);
				selectProductoId = new SelectItem[lista.size()];

				for (int j = 0; j < lista.size(); j++) {
					selectProductoId[j] = new SelectItem(lista.get(j).getProductoId().longValue(), lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
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
	public SelectItem[] getSelectContratista() {

		if (selectContratista == null || selectContratista.length == 0) {
			Date fechaRegistro = null;
			fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);
			
			if(fechaRegistro != null) {
				try {
					Object[] condicion = { "estado", true, "A", "="							
							, "tipoEmpresa", true, "4", "<>" 
							, "tipoEmpresa", true, "3", "<>"
							, "tipoEmpresa", true, "5", "<>"  };
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

	public SelectItem[] getSelectEquipo() {

		if (selectEquipo == null || selectEquipo.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(), equipo.getCodigo() + " - " + equipo.getNombre());
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

		if (selectAlmacen2 == null || selectAlmacen2.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(), almacen2.getCodigo() + " - " + almacen2.getNombre());
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

		if (selectLaborId == null || selectLaborId.length == 0) {

			try {
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

		if (selectConceptoKardex == null || selectConceptoKardex.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null, null);
				selectConceptoKardex = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectConceptoKardex[i] = new SelectItem(conceptoKardex.getConceptoKardexId(), conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
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

	public void listener_ConsultaUmProducto() {

		Long productoId = null;
		Long idUbicacion = null;
		if (txtProductoId_Producto.getValue() != null) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				if (producto.getUdadMedByUdadMedProd() != null) {
					txtUnidadMedida.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				}
				
				if(producto.getUbicacionesAlmacenId()!=null) {
					idUbicacion = producto.getUbicacionesAlmacenId().getUbicacionesAlmacenId();
					UbicacionesAlmacen ubicacion = businessDelegator2View.getUbicacionesAlmacen(idUbicacion);
					txtUbicacionAlmacen.setValue(ubicacion.getCodigo());				
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		Long datCompras = FacesUtils.checkLong(txtDatCompraProductosId);
		if (datCompras != null) {
			selectedPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioProductos"));
			if (selectedPrecioProductos.getPrecioProdId() != null) {
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

					} else if (columnaCell.equals("Maq")) {

						Long maqId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(maqId);

						entityPrecioProd.setEquipoId(e);

					}
					
					entity = businessDelegator2View.getDatCompraProductos(datCompras);
					entityPrecioProd.setDatCompraProductosId(entity);
					businessDelegatorView.updatePrecioPromProd(entityPrecioProd);

					selectedPrecioProductos = null;
					entityPrecioProd = null;
					dataDetPrecioProductos = null;

					dataDetPrecioProductos = businessDelegator2View.getDataProductosByCompras(datCompras);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));
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

		if (selectAlmacen3 == null || selectAlmacen3.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen3 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen3 : lista) {
					selectAlmacen3[i] = new SelectItem(almacen3.getAlmacenId(), almacen3.getCodigo() + " - " + almacen3.getNombre());
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

	public SelectOneMenu getTxtTipoMoneda() {
		return txtTipoMoneda;
	}

	public void setTxtTipoMoneda(SelectOneMenu txtTipoMoneda) {
		this.txtTipoMoneda = txtTipoMoneda;
	}

	public InputText getTxtTasaConversionTrm() {
		return txtTasaConversionTrm;
	}

	public void setTxtTasaConversionTrm(InputText txtTasaConversionTrm) {
		this.txtTasaConversionTrm = txtTasaConversionTrm;
	}

	public void action_tasa_conversion() {
		if (txtTipoMoneda.getValue() != null) {
			if (txtTipoMoneda.getValue().equals("Dolares")) {
				txtTasaConversionTrm.setDisabled(false);
				txtValorDescuento.setDisabled(true);

			} else {
				txtTasaConversionTrm.setDisabled(true);
				txtValorDescuento.setDisabled(false);

			}
		}
	}

	public InputNumber getTxtValorFactura() {
		return txtValorFactura;
	}

	public void setTxtValorFactura(InputNumber txtValorFactura) {
		this.txtValorFactura = txtValorFactura;
	}

	public InputNumber getTxtImpuestos() {
		return txtImpuestos;
	}

	public void setTxtImpuestos(InputNumber txtImpuestos) {
		this.txtImpuestos = txtImpuestos;
	}

	public InputNumber getTxtValorDescuento() {
		return txtValorDescuento;
	}

	public void setTxtValorDescuento(InputNumber txtValorDescuento) {
		this.txtValorDescuento = txtValorDescuento;
	}

	public InputNumber getTxtSubTotalValorFactura() {
		return txtSubTotalValorFactura;
	}

	public void setTxtSubTotalValorFactura(InputNumber txtSubTotalValorFactura) {
		this.txtSubTotalValorFactura = txtSubTotalValorFactura;
	}

	public void limpiar_pantalla() {
		// txtTipoProducto.setValue(null);
		txtProductoId_Producto.setValue(null);
	//	txtAlmacenId_Almacen2.setValue(null);
		txtValorUnit.setValue(null);
		cantidadCompra.setValue(null);
		txtUnidadMedida.setValue(null);
	}

	public void consultarVRTOTAL() {
		
		if (txtValorDescuento.getValue() != null) {
			Double subTotal = FacesUtils.checkDouble(txtSubTotalValorFactura);
			Double valorDescuento = FacesUtils.checkDouble(txtValorDescuento);
			Double subTotalMenosDescuento = subTotal - valorDescuento;
			Double totalProv = FacesUtils.checkDouble(txtValTotalSuma) != null ? FacesUtils.checkDouble(txtValTotalSuma) : 0.0;
			Double impuestos = 0.0;
			if (txtPorcentajeIva.getValue() != null) {
				impuestos = FacesUtils.checkDouble(txtPorcentajeIva);
			}
			txtSubTotalValorFactura.setValue(subTotalMenosDescuento);
			txtImpuestos.setValue((impuestos / 100) * subTotalMenosDescuento);
			Double totalImpuestos = FacesUtils.checkDouble(txtImpuestos);
			txtValorFactura.setValue(subTotalMenosDescuento + totalImpuestos + totalProv);
			txtValTotalSuma2.setValue(totalProv);
		}

		if (txtValorDescuento.getValue() == null) {
			Double subTotal = FacesUtils.checkDouble(txtSubTotalValorFactura);
			Double subTotalMenosDescuento = subTotal;
			Double totalProv = FacesUtils.checkDouble(txtValTotalSuma) != null ? FacesUtils.checkDouble(txtValTotalSuma) : 0.0;
			Double impuestos = 0.0;
			if (txtPorcentajeIva.getValue() != null) {
				impuestos = FacesUtils.checkDouble(txtPorcentajeIva);
			}

			txtSubTotalValorFactura.setValue(subTotalMenosDescuento);
			txtImpuestos.setValue((impuestos / 100) * subTotalMenosDescuento);
			Double totalImpuestos = FacesUtils.checkDouble(txtImpuestos);
			txtValorFactura.setValue(subTotalMenosDescuento + totalImpuestos + totalProv);
			txtValTotalSuma2.setValue(totalProv);
		}
		
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public List<String> getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(List<String> selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public List<PersEmpr> getContratistas() throws Exception {
		if (contratistas == null || contratistas.size() == 0) {


			Object[] condicion = { "estado", true, "A", "=", 			
					"tipoEmpresa", true, "4", "<>" 
				, "tipoEmpresa", true, "3", "<>"
				, "tipoEmpresa", true, "5", "<>"   };

			try {
				contratistas = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return contratistas;
	}

	public void setContratistas(List<PersEmpr> contratistas) {
		this.contratistas = contratistas;
	}

	public void listarCompras() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			// String zona = "1";
			Long documento = 0L;
			documento = FacesUtils.checkLong(txtDocumentoC);

			if (documento == null) {
				documento = 0L;
			}
			Long documentof = 0L;
			documentof = FacesUtils.checkLong(txtDocumentoFactura);

			if (documentof == null) {
				documentof = 0L;
			}
			
			Long compania = new Long(getCompaniaIdSession());
			String tipoCompra = FacesUtils.checkString(txtTipoCompraFiltro);
			Long flagContratista = 1L;

			String contratistasSeleccionadas = "";
			if (selectedContratista != null && selectedContratista.size() > 0) {
				contratistasSeleccionadas = selectedContratista.get(0);
				flagContratista = 0L;
				for (int i = 1; i < selectedContratista.size(); i++) {
					contratistasSeleccionadas += "," + selectedContratista.get(i);
				}
			}

			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_lista_compra_productos(compania, fechaInicial, fechaFinal,
						contratistasSeleccionadas, flagContratista, documento, tipoCompra,documentof);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ConsultaCompraProductosDTO> getData2() {
		return data2;
	}

	public InputText getTxtDocumentoC() {
		return txtDocumentoC;
	}

	public void setTxtDocumentoC(InputText txtDocumentoC) {
		this.txtDocumentoC = txtDocumentoC;
	}

	public void setData2(List<ConsultaCompraProductosDTO> data2) {
		this.data2 = data2;
	}

	public ConsultaCompraProductosDTO getSelectedDatCompraProductos2() {
		return selectedDatCompraProductos2;
	}

	public void setSelectedDatCompraProductos2(ConsultaCompraProductosDTO selectedDatCompraProductos2) {
		this.selectedDatCompraProductos2 = selectedDatCompraProductos2;
	}

	public InputNumber getTxtValorAdicional() {
		return txtValorAdicional;
	}

	public void setTxtValorAdicional(InputNumber txtValorAdicional) {
		this.txtValorAdicional = txtValorAdicional;
	}

	public void consultaListaProducto() {
		try {
			if (dataProducto2 == null) {
				dataProducto2 = businessDelegatorView.getDataProducto();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ProductoDTO> getDataProducto2() {
		return dataProducto2;
	}

	public void setDataProducto2(List<ProductoDTO> dataProducto2) {
		this.dataProducto2 = dataProducto2;
	}

	public List<Producto> getDataProducto() {
		return dataProducto;
	}

	public void setDataProducto(List<Producto> dataProducto) {
		this.dataProducto = dataProducto;
	}

	public ProductoDTO getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(ProductoDTO selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public String action_seleccionProducto(ActionEvent evt) {
		// selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes()
		// .get("selectedProducto"));
		try {

			Long productoId = selectedProducto.getProductoId().longValue();
			Object[] condicion = { "productoId", true, productoId, "=" };
			List<Producto> lista = (productoId != null)
					? businessDelegatorView.findByCriteriaInProducto(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entityProducto = lista.get(0);

				txtProductoId_Producto.setValue(entityProducto.getProductoId());
				txtProductoId_Producto.setDisabled(true);
				txtUnidadMedida.setValue(entityProducto.getUdadMedByUdadMedProd().getUdadMedId());
				txtUnidadMedida.setDisabled(true);

				txtProductoDescripcion.setValue(entityProducto.getNombre());
				txtProductoDescripcion.setDisabled(true);

				txtProductoCodigo.setValue(entityProducto.getCodigo());
				txtProductoCodigo.setDisabled(true);

				setShowDialog(true);

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public Producto getEntityProducto() {
		return entityProducto;
	}

	public void setEntityProducto(Producto entityProducto) {
		this.entityProducto = entityProducto;
	}

	public InputText getTxtProductoCodigo() {
		return txtProductoCodigo;
	}

	public void setTxtProductoCodigo(InputText txtProductoCodigo) {
		this.txtProductoCodigo = txtProductoCodigo;
	}

	public InputText getTxtProductoDescripcion() {
		return txtProductoDescripcion;
	}

	public void setTxtProductoDescripcion(InputText txtProductoDescripcion) {
		this.txtProductoDescripcion = txtProductoDescripcion;
	}

	public InputTextarea getTxtTransportadoraFactura() {
		return txtTransportadoraFactura;
	}

	public void setTxtTransportadoraFactura(InputTextarea txtTransportadoraFactura) {
		this.txtTransportadoraFactura = txtTransportadoraFactura;
	}

	public InputText getTxtTransportadoraNGuia() {
		return txtTransportadoraNGuia;
	}

	public void setTxtTransportadoraNGuia(InputText txtTransportadoraNGuia) {
		this.txtTransportadoraNGuia = txtTransportadoraNGuia;
	}

	public InputNumber getTxtTransportadoraValorFlete() {
		return txtTransportadoraValorFlete;
	}

	public void setTxtTransportadoraValorFlete(InputNumber txtTransportadoraValorFlete) {
		this.txtTransportadoraValorFlete = txtTransportadoraValorFlete;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputText getTxtUbicacionAlmacen() {
		return txtUbicacionAlmacen;
	}

	public void setTxtUbicacionAlmacen(InputText txtUbicacionAlmacen) {
		this.txtUbicacionAlmacen = txtUbicacionAlmacen;
	}

	public SelectItem[] getSelectUbAlmacen() {

		if (selectUbAlmacen == null || selectUbAlmacen.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion, null, null);
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

	public String action_vericiar_saldos_ubicacion() throws Exception {

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
		setShowDialog(true);
		return "";
	}

	public List<ConsultaStockMaquinariaDTO> getDataProductoUbicacion() {
		return dataProductoUbicacion;
	}

	public void setDataProductoUbicacion(List<ConsultaStockMaquinariaDTO> dataProductoUbicacion) {
		this.dataProductoUbicacion = dataProductoUbicacion;
	}

	public SelectOneMenu getTxtDatMantenimientoEquipoId() {
		return txtDatMantenimientoEquipoId;
	}

	public void setTxtDatMantenimientoEquipoId(SelectOneMenu txtDatMantenimientoEquipoId) {
		this.txtDatMantenimientoEquipoId = txtDatMantenimientoEquipoId;
	}
	
	
	public SelectItem[] getSelectDatMantenimientoEquipoId() {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				
				GregorianCalendar calendario4 = new GregorianCalendar();
				calendario4.add(GregorianCalendar.DAY_OF_YEAR, -30);
				java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

				
				Date fechaFinalDateRegistro =null;
				Date fechaOriginalFinal = foriginal.parse("2100-12-31");
				String fsalidaFinal = sdf.format(fechaOriginalFinal);
				fechaFinalDateRegistro = sdf.parse(fsalidaFinal);		
				
				Long idRegistro = 0L;
				
				
				List<SolicitudesMttoEquipoDTO> listaMtto = null;
				listaMtto = businessDelegator2View.pr_formato_impresion_ot(idCompania, fechaMinimaPermitida, fechaFinalDateRegistro, 
						"0", 1L, "0", 1L, "0", 1L, idRegistro);
				
				if (listaMtto != null) {
					selectDatMantenimientoEquipoId = new SelectItem[listaMtto.size()];

					int i = 0;
					for (SolicitudesMttoEquipoDTO solicitudesMttoEquipoDTO : listaMtto) {
						selectDatMantenimientoEquipoId[i] = new SelectItem(solicitudesMttoEquipoDTO.getDat_mantenimiento_equipo_id().longValue(),
								"Ot: "+solicitudesMttoEquipoDTO.getConsecutivo().toString()+" - Maq: "+solicitudesMttoEquipoDTO.getCod_equipo()
								+" - Mtto: "+solicitudesMttoEquipoDTO.getPlan_revision()
						);
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		return selectDatMantenimientoEquipoId;
	}

	public void setSelectDatMantenimientoEquipoId(SelectItem[] selectDatMantenimientoEquipoId) {
		this.selectDatMantenimientoEquipoId = selectDatMantenimientoEquipoId;
	}

	public SelectOneMenu getTxtProvTransporteFlete() {
		return txtProvTransporteFlete;
	}

	public void setTxtProvTransporteFlete(SelectOneMenu txtProvTransporteFlete) {
		this.txtProvTransporteFlete = txtProvTransporteFlete;
	}

	public SelectItem[] getSelectProvTransporteFlete() {

		if (selectProvTransporteFlete == null || selectProvTransporteFlete.length == 0) {
			
			
			if(txtPersEmpr.getValue() != null) {
			
			try {
				Object[] condicion = { "estado", true, "A", "=" , "tipoEmpresa", true, "2", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProvTransporteFlete = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectProvTransporteFlete[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
			}
		}

		return selectProvTransporteFlete;
	}

	public void setSelectProvTransporteFlete(SelectItem[] selectProvTransporteFlete) {
		this.selectProvTransporteFlete = selectProvTransporteFlete;
	}

	public SelectOneMenu getTxtProvGastosNacionales() {
		return txtProvGastosNacionales;
	}

	public void setTxtProvGastosNacionales(SelectOneMenu txtProvGastosNacionales) {
		this.txtProvGastosNacionales = txtProvGastosNacionales;
	}

	public SelectItem[] getSelectProvGastosNacionales() {

		if (selectProvGastosNacionales == null || selectProvGastosNacionales.length == 0) {
			if(txtPersEmpr.getValue() != null) {
			try {
				Object[] condicion = { "estado", true, "A", "=" , "tipoEmpresa", true, "2", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProvGastosNacionales = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectProvGastosNacionales[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
			}
		}

		return selectProvGastosNacionales;
	}

	public void setSelectProvGastosNacionales(SelectItem[] selectProvGastosNacionales) {
		this.selectProvGastosNacionales = selectProvGastosNacionales;
	}

	public SelectOneMenu getTxtProvImpuestosAranceles() {
		return txtProvImpuestosAranceles;
	}

	public void setTxtProvImpuestosAranceles(SelectOneMenu txtProvImpuestosAranceles) {
		this.txtProvImpuestosAranceles = txtProvImpuestosAranceles;
	}

	public SelectItem[] getSelectProvImpuestosAranceles() {

		if (selectProvImpuestosAranceles == null || selectProvImpuestosAranceles.length == 0) {
			if(txtPersEmpr.getValue() != null) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="  };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProvImpuestosAranceles = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectProvImpuestosAranceles[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
			}
		}

		return selectProvImpuestosAranceles;
	}

	public void setSelectProvImpuestosAranceles(SelectItem[] selectProvImpuestosAranceles) {
		this.selectProvImpuestosAranceles = selectProvImpuestosAranceles;
	}

	public SelectOneMenu getTxtProvComisiones() {
		return txtProvComisiones;
	}

	public void setTxtProvComisiones(SelectOneMenu txtProvComisiones) {
		this.txtProvComisiones = txtProvComisiones;
	}

	public SelectItem[] getSelectProvComisiones() {

		if (selectProvComisiones == null || selectProvComisiones.length == 0) {
			if(txtPersEmpr.getValue() != null) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="  };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProvComisiones = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectProvComisiones[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
			}
		}

		return selectProvComisiones;
	}

	public void setSelectProvComisiones(SelectItem[] selectProvComisiones) {
		this.selectProvComisiones = selectProvComisiones;
	}

	public SelectOneMenu getTxtProvOtros() {
		return txtProvOtros;
	}

	public void setTxtProvOtros(SelectOneMenu txtProvOtros) {
		this.txtProvOtros = txtProvOtros;
	}

	public SelectItem[] getSelectProvOtros() {

		if (selectProvOtros == null || selectProvOtros.length == 0) {
			if(txtPersEmpr.getValue() != null) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="  };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProvOtros = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectProvOtros[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
			}
		}

		return selectProvOtros;
	}

	public void setSelectProvOtros(SelectItem[] selectProvOtros) {
	}

	public InputNumber getTxtValTransporteFlete() {
		return txtValTransporteFlete;
	}

	public void setTxtValTransporteFlete(InputNumber txtValTransporteFlete) {
		this.txtValTransporteFlete = txtValTransporteFlete;
	}

	public InputNumber getTxtValGastosNacionales() {
		return txtValGastosNacionales;
	}

	public void setTxtValGastosNacionales(InputNumber txtValGastosNacionales) {
		this.txtValGastosNacionales = txtValGastosNacionales;
	}

	public InputNumber getTxtValImpuestosAranceles() {
		return txtValImpuestosAranceles;
	}

	public void setTxtValImpuestosAranceles(InputNumber txtValImpuestosAranceles) {
		this.txtValImpuestosAranceles = txtValImpuestosAranceles;
	}

	public InputNumber getTxtValComisiones() {
		return txtValComisiones;
	}

	public void setTxtValComisiones(InputNumber txtValComisiones) {
		this.txtValComisiones = txtValComisiones;
	}

	public InputNumber getTxtValOtros() {
		return txtValOtros;
	}

	public void setTxtValOtros(InputNumber txtValOtros) {
		this.txtValOtros = txtValOtros;
	}

	public InputNumber getTxtValTotalSuma() {
		return txtValTotalSuma;
	}

	public void setTxtValTotalSuma(InputNumber txtValTotalSuma) {
		this.txtValTotalSuma = txtValTotalSuma;
	}	
	
	public void calcularTotalProveedores() {
			
		Double sumaTotal =  0.0;
		
		if (FacesUtils.checkDouble(txtValTransporteFlete) != null && FacesUtils.checkDouble(txtValTransporteFlete) > 0) {
			sumaTotal = sumaTotal + FacesUtils.checkDouble(txtValTransporteFlete);
			
		} if (FacesUtils.checkDouble(txtValGastosNacionales) != null && FacesUtils.checkDouble(txtValGastosNacionales) > 0) {
			sumaTotal = sumaTotal + FacesUtils.checkDouble(txtValGastosNacionales);
			
		} if (FacesUtils.checkDouble(txtValImpuestosAranceles) != null && FacesUtils.checkDouble(txtValImpuestosAranceles) > 0) {
			sumaTotal = sumaTotal + FacesUtils.checkDouble(txtValImpuestosAranceles);
			
		} if (FacesUtils.checkDouble(txtValComisiones) != null && FacesUtils.checkDouble(txtValComisiones) > 0) {
			sumaTotal = sumaTotal + FacesUtils.checkDouble(txtValComisiones);
			
		} if (FacesUtils.checkDouble(txtValOtros) != null && FacesUtils.checkDouble(txtValOtros) > 0) {
			sumaTotal = sumaTotal + FacesUtils.checkDouble(txtValOtros);
		}
				
		Double promedio = (double) Math.round(sumaTotal * 100) / 100;
		
		txtValTotalSuma.setValue(null);
		txtValTotalSuma.setValue(promedio);		
	}

	public InputNumber getTxtValTotalSuma2() {
		return txtValTotalSuma2;
	}

	public void setTxtValTotalSuma2(InputNumber txtValTotalSuma2) {
		this.txtValTotalSuma2 = txtValTotalSuma2;
	}

	public List<String> getSelectedOrdenMtto() {
		
		return selectedOrdenMtto;
	}

	public void setSelectedOrdenMtto(List<String> selectedOrdenMtto) {
		this.selectedOrdenMtto = selectedOrdenMtto;
	}


	public List<SolicitudesMttoEquipoDTO> getOrdenMtto() {

		if (ordenMtto == null || ordenMtto.size() == 0) {
			
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				
				GregorianCalendar calendario4 = new GregorianCalendar();
				calendario4.add(GregorianCalendar.DAY_OF_YEAR, -30);
				java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

				
				Date fechaFinalDateRegistro =null;
				Date fechaOriginalFinal = foriginal.parse("2100-12-31");
				String fsalidaFinal = sdf.format(fechaOriginalFinal);
				fechaFinalDateRegistro = sdf.parse(fsalidaFinal);		
				
				Long idRegistro = 0L;
				ordenMtto = null;
				ordenMtto = businessDelegator2View.pr_ot_plan_revision(idCompania, fechaMinimaPermitida, fechaFinalDateRegistro, 
						 "0", 1L, idRegistro);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return ordenMtto;
	}

	
	public void setOrdenMtto(List<SolicitudesMttoEquipoDTO> ordenMtto) {
		this.ordenMtto = ordenMtto;
	}
	

	public List<ConsultaCompraMateriaPrimaDTO> getOrdenMp() {

		if (ordenMp == null || ordenMp.size() == 0) {
			
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				
				GregorianCalendar calendario4 = new GregorianCalendar();
				calendario4.add(GregorianCalendar.DAY_OF_YEAR, -90);
				java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

				
				Date fechaFinalDateRegistro =null;
				Date fechaOriginalFinal = foriginal.parse("2100-12-31");
				String fsalidaFinal = sdf.format(fechaOriginalFinal);
				fechaFinalDateRegistro = sdf.parse(fsalidaFinal);		
				
				Long idRegistro = 0L;
				ordenMp = null;
				ordenMp =businessDelegator2View.pr_lista_compra_materia_prima(idCompania, fechaMinimaPermitida, fechaFinalDateRegistro,
						"0", 1l, 0L);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return ordenMp;
	}

	public void setOrdenMp(List<ConsultaCompraMateriaPrimaDTO> ordenMp) {
		this.ordenMp = ordenMp;
	}

	public List<String> getSelectedOrdenMp() {
		return selectedOrdenMp;
	}

	public void setSelectedOrdenMp(List<String> selectedOrdenMp) {
		this.selectedOrdenMp = selectedOrdenMp;
	}

	public SelectOneMenu getTxtTipoCompraFiltro() {
		return txtTipoCompraFiltro;
	}

	public void setTxtTipoCompraFiltro(SelectOneMenu txtTipoCompraFiltro) {
		this.txtTipoCompraFiltro = txtTipoCompraFiltro;
	}
	
	public void validarExistenciaFactura() throws Exception {
		Long persEmprId = FacesUtils.checkLong(txtPersEmpr);
		Long numFactura = FacesUtils.checkLong(txtNumFactura);
		
		Object[] condicion = { "numFactura", true, numFactura, "=", "persEmpr.persEmprId", true, persEmprId, "="  };
		List<DatCompraProductos> lista = (persEmprId != null)
				? businessDelegator2View.findByCriteriaInDatCompraProductos(condicion, null, null)
				: null;

		if (lista != null && lista.size() > 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Upps!, La factura registrada ya se encuentra en el sistema, válide por favor",""));
		}
	}
	
	public InputText getTxtDocumentoFactura() {
		return txtDocumentoFactura;
	}

	public void setTxtDocumentoFactura(InputText txtDocumentoFactura) {
		this.txtDocumentoFactura = txtDocumentoFactura;
	}

	
	
}