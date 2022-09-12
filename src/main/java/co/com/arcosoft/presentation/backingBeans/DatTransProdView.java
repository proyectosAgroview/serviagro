package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
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
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.DatTransProdNivel4;
import co.com.arcosoft.modelo.Empaque;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.FrenteCos;
import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.RestrMadurante;
import co.com.arcosoft.modelo.RestrQuema;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Transportadora;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaProduccionDTO;
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
public class DatTransProdView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdView.class);
	private InputText txtAnioFiscalNivel4;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtConsecutivoDes;
	private InputText txtConsecutivoSer;
	private SelectOneMenu txtDestinoProduccion;
	private InputText txtEdadNivel4;
	private SelectOneRadio txtEstado;
	private InputText txtFaseFenoNivel4;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtMobileId;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private SelectOneMenu txtTipoTransaccion;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatTransProdId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private Calendar txtFechaRegistroDes;
	private Calendar txtFechaRegistroSer;
	private Calendar txtFechaInicial;
	private Calendar txtFechaAnulacion;
	private CommandButton btnSave;
	private CommandButton btnSaveDes;
	private CommandButton btnSaveSer;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatTransProdDTO> data;
	private List<DatTransProdDTO> data2;
	private DatTransProdDTO selectedDatTransProd;
	private DatTransProd entity;
	private double result;
	private boolean showDialog;
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private List<String> restriccionDeQuema;
	private List<RestrQuema> selectItemRestriccionQuema;

	private List<String> restriccionDeMadurante;
	private List<RestrMadurante> selectItemRestriccionMadurante;

	private List<VariedadNivel4DTO> dataVariedad;
	private VariedadNivel4DTO selectedVariedad;

	private String tipoTransaccion;
	private SelectOneMenu selectTipoTransaccion;

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private SelectOneMenu txtEmpresaCompradora;
	SelectItem[] selectEmpresaCompradora;
	private List<PersEmpr> empresaCompradora;
	
	private SelectOneMenu txtProveId_Proveedor;
	SelectItem[] selectProveedor;
	private List<PersEmpr> proveedor;

	private SelectOneMenu txtConductorId_Conductor;
	SelectItem[] selectConductor;
	private List<Trabajador> conductor;

	private SelectOneMenu txtFrtCosId_FrenteCos;
	SelectItem[] selectFrenteCos;
	private List<FrenteCos> frenteCos;

	private SelectOneMenu txtModalidadCosId_ModalidadCosecha;
	SelectItem[] selectModalidadCosecha;
	private List<ModalidadCosecha> modalidadCosecha;

	private SelectOneMenu txtTranspId_Transportadora;
	SelectItem[] selectTransportadora;
	private List<Transportadora> transportadora;

	private SelectOneMenu txtVehiTranspId_VehiculosTransp;
	SelectItem[] selectVehiculosTransp;
	private List<Equipo> vehiculosTransp;
	
	SelectItem[] selectNivel2Edit;
	private List<Nivel2> nivel2Edit;
	
	SelectItem[] selectNivel4Edit;
	private List<Nivel4> nivel4Edit;
	
	/** Campos de pantalla de detalle de productos **/
	private List<DatTransProdDetDTO> dataDetTransProductos;
	private DatTransProdDetDTO selectedDatTransProdDet;

	private List<DatTransProdNivel4DTO> dataDetTransNivel4;
	private List<DatTransProdNivel4DTO> dataDetTransNivel4Cosecha;
	private DatTransProdNivel4DTO selectedDatTransNivel4;
	
	private DatTransProdNivel4 entityDatTransProdNivel4;

	private InputText txtAreaCosechada;
	private InputText txtCantidadSolicitada;
	private InputText txtCantidadReal;
	private InputText txtRendimiento;
	private CommandButton btnAgregarNivel4;
	private CommandButton btnAgregar;
	
	private InputText txtKilogramosAzucarToneladas;
	private InputText txtValorKilogramosAzucar;
	private InputText txtValorUnitarioCosecha;
	private InputNumber txtIngresoBruto;
	
	private InputNumber txtAjusteLiquidacion;
	private InputNumber txtBonificion;
	private InputNumber txtOtrosIngresos;
	private InputNumber txtRetenciones;
	private InputNumber txtDescuentos;

	private SelectOneMenu txtClienteDet;
	SelectItem[] selectCliente;
	private List<PersEmpr> cliente;

	private SelectOneMenu txtUdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtCiudad;
	SelectItem[] selectCiudad;
	private List<Ciudad> ciudad;

	private SelectOneMenu txtProducto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtEmpaque;
	SelectItem[] selectEmpaqueId;
	private List<Empaque> empaqueId;

	private InputText txtNombreProducto;
	private InputText txtNombreUdadMed;
	private InputText txtNombreCiudad;
	private InputText txtCodCliente;
	private InputText txtCodEmpaque;
	private InputText txtCodVagon;

	private InputText txtNombreNivel2;
	private InputText txtNombreNivel4;
	private InputText txtCodigoNivel4;
	private InputText txtNombreModCosecha;

	private SelectOneMenu txtVagonId;
	SelectItem[] selectVagon;
	private List<Equipo> equipo;

	private SelectOneRadio txtFinCosecha;

	private InputText txtCantidadRacimos;
	private InputText txtPesoPromedio;
	private SelectOneMenu txtIndicadorDistribuccion;

	/*** Nuevos campos ***/

	private SelectOneMenu txtEtapaNivel4;
	SelectItem[] selectItemEtapa;
	private List<Etapa> etapa;

	private SelectOneMenu txtVariedNivel4;
	SelectItem[] selectItemVariedad;
	private List<Variedad> variedad;


	private SelectOneMenu txtClienteNivel4;
	SelectItem[] selectClienteNivel4;
	private List<PersEmpr> clienteNivel4;
	
	private InputText txtNombreEtapa;
	private InputText txtNombreVariedad;

	private Spinner txtCantidadKilosLiq;
	private Spinner txtValorDeduccion;
	private Spinner txtValorNeto;

	private Spinner txtValorUnitario;
	private Spinner txtValorTotal;

	private InputText txtCantidadCosechada;
	private InputText txtPorcMateriaExtrana;
	private InputText txtPorcSacarosa;
	private InputText txtKilosPorTonelada;
	private InputText txtPorcRendimiento;
	private InputText txtCantidadCosechadaHa;

	private Spinner txtNumeroViajes;
	private InputText txtCantidadCosechadaHaMes;
	private InputText txtTonAzucarHaMes;
	
	private InputNumber txtPlanilla;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	
	private int activeTapIndex = 0;
	SelectItem[] selectLote;
	
	private ListaProduccionDTO selectDetalle;
	private List<ListaProduccionDTO> dataDetalle;
	

	private List<String> selectedHacienda;
	private List<Nivel2> haciendas;

	private List<String> selectedLote;
	private List<Nivel4> lotes;
	
	public DatTransProdView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatTransProd = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatTransProd = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		if (txtAnioFiscalNivel4 != null) {
			txtAnioFiscalNivel4.setValue(null);
			txtAnioFiscalNivel4.setDisabled(true);
		}

		if (txtCodCliente != null) {
			txtCodCliente.setValue(null);
			txtCodCliente.setDisabled(true);
		}

		if (txtCodEmpaque != null) {
			txtCodEmpaque.setValue(null);
			txtCodEmpaque.setDisabled(true);
		}
		if (txtNombreCiudad != null) {
			txtNombreCiudad.setValue(null);
			txtNombreCiudad.setDisabled(true);
		}
		if (txtNombreProducto != null) {
			txtNombreProducto.setValue(null);
			txtNombreProducto.setDisabled(true);
		}
		if (txtNombreUdadMed != null) {
			txtNombreUdadMed.setValue(null);
			txtNombreUdadMed.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (selectTipoTransaccion != null) {
			selectTipoTransaccion.setValue(null);
			selectTipoTransaccion.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtDestinoProduccion != null) {
			txtDestinoProduccion.setValue(null);
			txtDestinoProduccion.setDisabled(false);
		}
		
		if (txtValorKilogramosAzucar != null) {
			txtValorKilogramosAzucar.setValue(null);
			txtValorKilogramosAzucar.setDisabled(false);			
		}
		
		if (txtKilogramosAzucarToneladas != null) {
			txtKilogramosAzucarToneladas.setValue(null);
			txtKilogramosAzucarToneladas.setDisabled(false);			
		}
		
		if (txtValorUnitarioCosecha != null) {
			txtValorUnitarioCosecha.setValue(null);
			txtValorUnitarioCosecha.setDisabled(false);			
		}
		
		if (txtIngresoBruto != null) {
			txtIngresoBruto.setValue(null);
			txtIngresoBruto.setDisabled(false);			
		}

		if (txtEdadNivel4 != null) {
			txtEdadNivel4.setValue(null);
			txtEdadNivel4.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}
		
		if (txtAjusteLiquidacion != null) {
			txtAjusteLiquidacion.setValue(null);
			txtAjusteLiquidacion.setDisabled(false);			
		}
		
		if (txtBonificion != null) {
			txtBonificion.setValue(null);
			txtBonificion.setDisabled(false);			
		}
		
		if (txtOtrosIngresos != null) {
			txtOtrosIngresos.setValue(null);
			txtOtrosIngresos.setDisabled(false);			
		}
		
		if (txtRetenciones != null) {
			txtRetenciones.setValue(null);
			txtRetenciones.setDisabled(false);			
		}

		if (txtDescuentos != null) {
			txtDescuentos.setValue(null);
			txtDescuentos.setDisabled(false);
		}

		if (txtEtapaNivel4 != null) {
			txtEtapaNivel4.setValue(null);
			txtEtapaNivel4.setDisabled(false);
		}

		if (txtFaseFenoNivel4 != null) {
			txtFaseFenoNivel4.setValue(null);
			txtFaseFenoNivel4.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtMobileId != null) {
			txtMobileId.setValue(null);
			txtMobileId.setDisabled(true);
		}

		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtTipoTransaccion != null) {
			txtTipoTransaccion.setValue(null);
			txtTipoTransaccion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtVariedNivel4 != null) {
			txtVariedNivel4.setValue(null);
			txtVariedNivel4.setDisabled(false);
		}

		if (txtEmpresaCompradora != null) {
			txtEmpresaCompradora.setValue(null);
			txtEmpresaCompradora.setDisabled(false);
		}

		if (txtConductorId_Conductor != null) {
			txtConductorId_Conductor.setValue(null);
			txtConductorId_Conductor.setDisabled(false);
		}

		if (txtFrtCosId_FrenteCos != null) {
			txtFrtCosId_FrenteCos.setValue(null);
			txtFrtCosId_FrenteCos.setDisabled(false);
		}

		if (txtModalidadCosId_ModalidadCosecha != null) {
			txtModalidadCosId_ModalidadCosecha.setValue(null);
			txtModalidadCosId_ModalidadCosecha.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}

		if (txtProveId_Proveedor != null) {
			txtProveId_Proveedor.setValue(null);
			txtProveId_Proveedor.setDisabled(true);
		}

		if (txtTranspId_Transportadora != null) {
			txtTranspId_Transportadora.setValue(null);
			txtTranspId_Transportadora.setDisabled(false);
		}

		if (txtVehiTranspId_VehiculosTransp != null) {
			txtVehiTranspId_VehiculosTransp.setValue(null);
			txtVehiTranspId_VehiculosTransp.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaRegistro != null) {
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(false);
		}
		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(false);
		}

		if (txtDatTransProdId != null) {
			txtDatTransProdId.setValue(null);
			txtDatTransProdId.setDisabled(false);
		}

		/* Detalle de productos */

		if (txtAreaCosechada != null) {
			txtAreaCosechada.setValue(null);
			txtAreaCosechada.setDisabled(false);
		}

		if (txtCantidadSolicitada != null) {
			txtCantidadSolicitada.setValue(null);
			txtCantidadSolicitada.setDisabled(false);
		}
		if (txtCantidadReal != null) {
			txtCantidadReal.setValue(null);
			txtCantidadReal.setDisabled(false);
		}
		if (txtRendimiento != null) {
			txtRendimiento.setValue(null);
			txtRendimiento.setDisabled(false);
		}
		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(false);
		}
		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(false);
		}
		if (txtClienteDet != null) {
			txtClienteDet.setValue(null);
			txtClienteDet.setDisabled(false);
		}
		if (txtUdadMed != null) {
			txtUdadMed.setValue(null);
			txtUdadMed.setDisabled(false);
		}
		if (txtEmpaque != null) {
			txtEmpaque.setValue(null);
			txtEmpaque.setDisabled(false);
		}

		if (txtCiudad != null) {
			txtCiudad.setValue(null);
			txtCiudad.setDisabled(false);
		}
		if (txtProducto != null) {
			txtProducto.setValue(null);
			txtProducto.setDisabled(false);
		}
		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}
		if (txtFinCosecha != null) {
			txtFinCosecha.setValue("Si");
			txtFinCosecha.setDisabled(false);
		}

		if (txtCantidadRacimos != null) {
			txtCantidadRacimos.setValue(0.0);
			txtCantidadRacimos.setDisabled(false);
		}

		if (txtPesoPromedio != null) {
			txtPesoPromedio.setValue(0.0);
			txtPesoPromedio.setDisabled(false);
		}

		if (txtIndicadorDistribuccion != null) {
			txtIndicadorDistribuccion.setValue(null);
			txtIndicadorDistribuccion.setDisabled(false);
		}

		if (txtCantidadCosechada != null) {
			txtCantidadCosechada.setValue(null);
			txtCantidadCosechada.setDisabled(false);
		}
		if (txtPorcMateriaExtrana != null) {
			txtPorcMateriaExtrana.setValue(null);
			txtPorcMateriaExtrana.setDisabled(false);
		}
		if (txtPorcSacarosa != null) {
			txtPorcSacarosa.setValue(null);
			txtPorcSacarosa.setDisabled(false);
		}
		if (txtKilosPorTonelada != null) {
			txtKilosPorTonelada.setValue(null);
			txtKilosPorTonelada.setDisabled(false);
		}
		if (txtPorcRendimiento != null) {
			txtPorcRendimiento.setValue(null);
			txtPorcRendimiento.setDisabled(false);
		}

		if (txtCantidadCosechadaHa != null) {
			txtCantidadCosechadaHa.setValue(null);
			txtCantidadCosechadaHa.setDisabled(false);
		}

		if (txtNumeroViajes != null) {
			txtNumeroViajes.setValue(null);
			txtNumeroViajes.setDisabled(false);
		}

		if (txtCantidadCosechadaHaMes != null) {
			txtCantidadCosechadaHaMes.setValue(null);
			txtCantidadCosechadaHaMes.setDisabled(false);
		}

		if (txtTonAzucarHaMes != null) {
			txtTonAzucarHaMes.setValue(null);
			txtTonAzucarHaMes.setDisabled(false);
		}
		if (txtClienteNivel4 != null) {
			txtClienteNivel4.setValue(null);
			txtClienteNivel4.setDisabled(false);
		}
		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnAgregarNivel4 != null) {
			btnAgregarNivel4.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		if (dataDetTransProductos != null) {
			dataDetTransProductos = null;
		}

		if (dataDetTransNivel4Cosecha != null) {
			dataDetTransNivel4Cosecha = null;
		}
		
		if (dataDetTransNivel4 != null) {
			dataDetTransNivel4 = null;
		}

		if (txtNombreEtapa != null) {
			txtNombreEtapa.setValue(null);
			txtNombreEtapa.setDisabled(false);
		}
		if (txtNombreVariedad != null) {
			txtNombreVariedad.setValue(null);
			txtNombreVariedad.setDisabled(false);
		}

		if (txtCantidadKilosLiq != null) {
			txtCantidadKilosLiq.setValue(null);
			txtCantidadKilosLiq.setDisabled(false);
		}
		if (txtValorDeduccion != null) {
			txtValorDeduccion.setValue(null);
			txtValorDeduccion.setDisabled(false);
		}

		if (txtVagonId != null) {
			txtVagonId.setValue(null);
			txtVagonId.setDisabled(false);
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

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_calcularCostoTotal() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
		Double kilosPagar = FacesUtils.checkDouble(txtCantidadKilosLiq);

		if (valorUnitario != null && kilosPagar != null) {
			result = (valorUnitario * kilosPagar);
			String format = decimalFormat.format(result);
			txtValorTotal.setValue(format);
		} else {
			result = 0;
			txtValorTotal.setValue(result);
		}

	}

	public void listener_calcularTonHa() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double area = FacesUtils.checkDouble(txtAreaCosechada);
		Double cantidad = FacesUtils.checkDouble(txtCantidadCosechada);
		Double result =0.0;
		if (area != null && cantidad != null) {
				result = (cantidad / area);
			
			String format = decimalFormat.format(result);
			txtCantidadCosechadaHa.setValue(format);
		} else {
			result = 0.0;
			txtCantidadCosechada.setValue(result);
		}

	}

	public void listener_calcularTonHaMes() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double area = FacesUtils.checkDouble(txtAreaCosechada);
		Double cantidad = FacesUtils.checkDouble(txtCantidadCosechada);
		Double edad = FacesUtils.checkDouble(txtEdadNivel4);
		Double result =0.0;
		
		if (area != null && cantidad != null && edad !=null) {
				result = (cantidad / area)/edad;
			
			String format = decimalFormat.format(result);
			txtCantidadCosechadaHaMes.setValue(format);
		} else {
			result = 0.0;
			txtCantidadCosechadaHaMes.setValue(result);
		}

	}

	public void listener_calcularTonAzucarHaMes() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double tchm = FacesUtils.checkDouble(txtCantidadCosechadaHaMes);
		Double rendimiento = FacesUtils.checkDouble(txtPorcRendimiento);
		//Double edad = FacesUtils.checkDouble(txtEdadNivel4);
		Double result =0.0;
		
		if (tchm != null && rendimiento != null ) {
			
			result = tchm*rendimiento;
			String format = decimalFormat.format(result);
			txtTonAzucarHaMes.setValue(format);
		} else {
			result = 0.0;
			txtTonAzucarHaMes.setValue(result);
		}

	}

	public void listener_calcularValorNeto() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorDeduccion = FacesUtils.checkDouble(txtValorDeduccion);
		Double ValorTotal = FacesUtils.checkDouble(txtValorTotal);
		Double result =0.0;
		
		if (ValorTotal != null && valorDeduccion != null) {
			result = (ValorTotal - valorDeduccion);
			String format = decimalFormat.format(result);
			txtValorNeto.setValue(format);
		} else {
			result = 0.0;
			txtValorNeto.setValue(result);
		}

	}
	
	public List<DatTransProdNivel4DTO> getDataDetTransNivel4s() {

		if (dataDetTransNivel4 == null || dataDetTransNivel4.size() == 0) {
			return null;
		} else {
			return dataDetTransNivel4;
		}

	}

	public void action_agregarNivel4() throws Exception {

		if (txtModalidadCosId_ModalidadCosecha.getValue() != null && txtNivel2Id.getValue() != null && txtProducto.getValue() !=null 
				&& txtNivel4Id_Nivel4.getValue() != null && txtVariedNivel4.getValue() != null
				&& txtEtapaNivel4.getValue() != null && txtAreaCosechada.getValue() != null
				&& txtCantidadCosechada.getValue() != null
				&& txtClienteNivel4.getValue() !=null
				) {

			
			Long clienteId = Long.parseLong(txtClienteNivel4.getValue().toString());
			PersEmpr cliente  = businessDelegatorView.getPersEmpr(clienteId);
			String nombreCliente = cliente.getNombre();
			
			String destinoProduccion = txtDestinoProduccion.getValue().toString();
			Long modCosecha = Long.parseLong(txtModalidadCosId_ModalidadCosecha.getValue().toString());
			ModalidadCosecha modCosechaId = businessDelegatorView.getModalidadCosecha(modCosecha);

			Long nivel1Id = Long.parseLong(txtNivel1Id.getValue().toString());
			Long nivel2 = Long.parseLong(txtNivel2Id.getValue().toString());
			Nivel2 nivel2Id = businessDelegatorView.getNivel2(nivel2);

			Long nivel3Id = Long.parseLong(txtNivel3Id.getValue().toString());
			Long nivel4 = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			Nivel4 nivel4Id = businessDelegatorView.getNivel4(nivel4);

			Long variedad = Long.parseLong(txtVariedNivel4.getValue().toString());
			Variedad variedadId = businessDelegatorView.getVariedad(variedad);

			Long etapa = Long.parseLong(txtEtapaNivel4.getValue().toString());
			Etapa etapaId = businessDelegatorView.getEtapa(etapa);

			Long productoId = Long.parseLong(txtProducto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);

			
			Long vagonId=null;
			Equipo vagon =null;
			
			
			String nombreVagon =null;
			if(txtVagonId.getValue() !=null){
				 vagonId = Long.parseLong(txtVagonId.getValue().toString());
				 vagon = businessDelegatorView.getEquipo(vagonId);
				   nombreVagon = vagon.getCodigo();
				
			}
			
			String nombreModCos = modCosechaId.getNombre();
			String nombreNivel2 = nivel2Id.getNombre();
			String codigoNivel4 = nivel4Id.getNombre();
			String nombreNivel4 = nivel4Id.getNombre();
			String nombreVariedad = variedadId.getNombre();
			String nombreEtapa = etapaId.getNombre();
			
			String nombreProducto = producto.getNombre();

			String finCosecha = FacesUtils.checkString(txtFinCosecha);
			Double areaCosechada = FacesUtils.checkDouble(txtAreaCosechada);

			Double edadNivel4 = FacesUtils.checkDouble(txtEdadNivel4);
			Double cantidadCosechada = FacesUtils.checkDouble(txtCantidadCosechada);
			Double porcMateriaExtrana = FacesUtils.checkDouble(txtPorcMateriaExtrana);
			Double porcSacarosa = FacesUtils.checkDouble(txtPorcSacarosa);
			Double kilosPorTonelada = FacesUtils.checkDouble(txtKilosPorTonelada);
			Double porcRendimiento = FacesUtils.checkDouble(txtPorcRendimiento);
			Double cantidadCosechadaHa = FacesUtils.checkDouble(txtCantidadCosechadaHa);

			Double cantidadCosechadaHaMes = FacesUtils.checkDouble(txtCantidadCosechadaHaMes);
			Double tonAzucarHaMes = FacesUtils.checkDouble(txtTonAzucarHaMes);
			Double numeroViajes = FacesUtils.checkDouble(txtNumeroViajes);

			
			boolean existeProducto = false;

			if (dataDetTransNivel4 == null) {
				dataDetTransNivel4 = new ArrayList<DatTransProdNivel4DTO>();
			}

			if (dataDetTransNivel4.size() > 0) {

				for (DatTransProdNivel4DTO d : dataDetTransNivel4) {

					if(vagonId != null){
						
					}else{
						if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() 
								== nivel4Id.getNivel4Id().longValue()
										&& d.getClienteId().getPersEmprId() == cliente.getPersEmprId().longValue()
								) {
	
							existeProducto = true;
	
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
											"El Lote " + d.getNivel4Id_Nivel4().getNivel4Id().longValue()
													+ " ya fue agregado a la lista, por favor seleccione otro. "));
	
							break;
						}
					}
				}

			}

			if (existeProducto == false) {

				DatTransProdNivel4DTO datTransProdNivel4DTO = new DatTransProdNivel4DTO();

				datTransProdNivel4DTO.setNivel1Id(nivel1Id);
				datTransProdNivel4DTO.setNivel2Id_Nivel2(nivel2Id);
				datTransProdNivel4DTO.setNombreNivel2(nombreNivel2);
				datTransProdNivel4DTO.setNivel3Id(nivel3Id);
				datTransProdNivel4DTO.setNivel4Id_Nivel4(nivel4Id);
				datTransProdNivel4DTO.setCodigoNivel4(codigoNivel4);
				datTransProdNivel4DTO.setNombreNivel4(nombreNivel4);
				datTransProdNivel4DTO.setModalidadCosId(modCosechaId);
				datTransProdNivel4DTO.setNombreModCos(nombreModCos);
				datTransProdNivel4DTO.setFinCosecha(finCosecha);
				datTransProdNivel4DTO.setAreaCosechada(areaCosechada);
				datTransProdNivel4DTO.setEdadNivel4(edadNivel4);
				datTransProdNivel4DTO.setEtapaNivel4(etapaId);
				datTransProdNivel4DTO.setVariedNivel4(variedadId);
				datTransProdNivel4DTO.setNombreEtapa(nombreEtapa);
				datTransProdNivel4DTO.setNombreVariedad(nombreVariedad);
				datTransProdNivel4DTO.setCantidadCosechada(cantidadCosechada);
				datTransProdNivel4DTO.setPorcMateriaExtrana(porcMateriaExtrana);
				datTransProdNivel4DTO.setPorcSacarosa(porcSacarosa);
				datTransProdNivel4DTO.setKilosPorTonelada(kilosPorTonelada);
				datTransProdNivel4DTO.setPorcRendimiento(porcRendimiento);
				datTransProdNivel4DTO.setCantidadCosechadaHa(cantidadCosechadaHa);
				datTransProdNivel4DTO.setVagonId(vagon);
				datTransProdNivel4DTO.setNombreVagon(nombreVagon);				
				datTransProdNivel4DTO.setNombreProducto(nombreProducto);				
				datTransProdNivel4DTO.setClienteId(cliente);
				datTransProdNivel4DTO.setNomClienteId(nombreCliente);
				datTransProdNivel4DTO.setDestinoProduccion(destinoProduccion);				
				datTransProdNivel4DTO.setCantidadCosechadaHaMes(cantidadCosechadaHaMes);
				datTransProdNivel4DTO.setTonAzucarHaMes(tonAzucarHaMes);
				datTransProdNivel4DTO.setNumeroViajes(numeroViajes);				
				datTransProdNivel4DTO.setProducto(producto);
				
				dataDetTransNivel4.add(datTransProdNivel4DTO);				
			}
			
			destinoProduccion= null;
			cliente = null;
			nombreCliente = null;
			numeroViajes = null;
			cantidadCosechadaHaMes = null;
			tonAzucarHaMes = null;			
			nombreVagon = null;
			nombreProducto=null;
			producto=null;
			productoId=null;
			vagonId=null;
			vagon =null;
			nivel1Id = null;
			nivel2Id = null;
			nombreNivel2 = null;
			nivel3Id = null;
			nivel4Id = null;
			codigoNivel4 = null;
			nombreNivel4 = null;
			etapaId = null;
			variedadId = null;
			etapa = null;
			variedad = null;
			nombreEtapa = null;
			nombreVariedad = null;
			modCosechaId = null;
			nombreModCos = null;
			finCosecha = null;
			areaCosechada = null;
			cantidadCosechada = null;
			porcMateriaExtrana = null;
			porcSacarosa = null;
			kilosPorTonelada = null;
			porcRendimiento = null;
			cantidadCosechadaHa = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos tipo de cosecha, finca, lote, área cosechada, variedad, N° de cosechas, cantidad cosechada tengan valores. "));
		}
	}

	public void listener_ConsultaNombreNivel2() {

		Long nivel2Id = null;

		if (!txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel2.setValue(nivel2.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodigoVagon() {

		Long vagonId = null;

		if (!txtVagonId.getValue().equals("")) {
			vagonId = Long.parseLong(txtVagonId.getValue().toString());

			try {
				Equipo vagon = businessDelegatorView.getEquipo(vagonId);
				txtCodVagon.setValue(vagon.getCodigo());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaNombreModCos() {

		Long modCosecha = null;

		if (!txtModalidadCosId_ModalidadCosecha.getValue().equals("")) {

			modCosecha = Long.parseLong(txtModalidadCosId_ModalidadCosecha.getValue().toString());

			try {
				ModalidadCosecha modCosechaId = businessDelegatorView.getModalidadCosecha(modCosecha);
				txtNombreModCosecha.setValue(modCosechaId.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaAreaNivel4() {

		Long nivel4Id = null;

		if (!txtNivel4Id_Nivel4.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());

			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				txtAreaCosechada.setValue(nivel4.getAreaNeta());
				txtEtapaNivel4.setValue(nivel4.getEtapa().getEtapaId());
				txtVariedNivel4.setValue(nivel4.getVariedad());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}
	
	public void listener_ConsultaAreaNivel4Cosecha() {

		Long nivel4Id = null;

		if (!txtNivel4Id_Nivel4.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());

			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				txtAreaCosechada.setValue(nivel4.getAreaNeta());
				txtEtapaNivel4.setValue(nivel4.getEtapa().getEtapaId());
				txtVariedNivel4.setValue(nivel4.getVariedad());
				Date fechaCosecha = FacesUtils.checkDate(txtFechaRegistro);
				Double edad = businessDelegatorView.calcularEdadLote(fechaCosecha, nivel4Id);
				txtEdadNivel4.setValue(edad);
				Long companiaId = new Long(getCompaniaIdSession());
				Compania compania = businessDelegatorView.getCompania(companiaId);
				
				Double AzTc = 0.0;//compania.getKilosAzucarTc();
				Double valorKgAzucar =0.0;// compania.getValorKgAzucar();
				txtKilogramosAzucarToneladas.setValue(AzTc);
				txtValorKilogramosAzucar.setValue(valorKgAzucar);
				txtValorUnitarioCosecha.setValue(AzTc*valorKgAzucar);
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaVariedad() {

		Long variedad = null;

		if (!txtVariedNivel4.getValue().equals("")) {
			variedad = Long.parseLong(txtVariedNivel4.getValue().toString());

			try {

				Variedad variedadId = businessDelegatorView.getVariedad(variedad);
				txtNombreVariedad.setValue(variedadId.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCosechas() {

		Long etapa = null;

		if (!txtEtapaNivel4.getValue().equals("")) {
			etapa = Long.parseLong(txtEtapaNivel4.getValue().toString());

			try {

				Etapa etapaId = businessDelegatorView.getEtapa(etapa);
				txtNombreEtapa.setValue(etapaId.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaUmProducto() {

		Long productoId = null;

		if (!txtProducto.getValue().equals("")) {
			productoId = Long.parseLong(txtProducto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				txtUdadMed.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				txtNombreProducto.setValue(producto.getNombre());
				Long udadMedId = Long.parseLong(txtUdadMed.getValue().toString());

				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				txtNombreUdadMed.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;

		if (!txtUdadMed.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMed.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				txtNombreUdadMed.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaNombreCiudad() {

		Long ciudadId = null;

		if (!txtCiudad.getValue().equals("")) {
			ciudadId = Long.parseLong(txtCiudad.getValue().toString());

			try {
				Ciudad ciudad = businessDelegatorView.getCiudad(ciudadId);
				txtNombreCiudad.setValue(ciudad.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodCliente() {

		Long contratistaId = null;

		if (!txtClienteDet.getValue().equals("")) {
			contratistaId = Long.parseLong(txtClienteDet.getValue().toString());

			try {
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(contratistaId);
				txtCodCliente.setValue(persEmpr.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodEmpaque() {

		Long empaqueId = null;

		if (!txtEmpaque.getValue().equals("")) {
			empaqueId = Long.parseLong(txtEmpaque.getValue().toString());

			try {
				Empaque empaque = businessDelegatorView.getEmpaque(empaqueId);
				txtCodEmpaque.setValue(empaque.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public String action_edit(ActionEvent evt) {
		selectedDatTransProd = (DatTransProdDTO) (evt.getComponent().getAttributes().get("selectedDatTransProd"));

		try {

			Long consecutivo = selectedDatTransProd.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatTransProd> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				selectTipoTransaccion.setValue(entity.getTipoTransaccion());
				selectTipoTransaccion.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtFechaInicial.setValue(entity.getFechaInicial());
				txtFechaInicial.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtConductorId_Conductor.setValue(selectedDatTransProd.getConductorId_Conductor());
				txtConductorId_Conductor.setDisabled(false);
				txtTranspId_Transportadora.setValue(entity.getTransportadora());
				txtTranspId_Transportadora.setDisabled(false);
				txtVehiTranspId_VehiculosTransp.setValue(entity.getVehiculoId());
				txtVehiTranspId_VehiculosTransp.setDisabled(false);
				txtDatTransProdId.setValue(entity.getDatTransProdId());
				txtDatTransProdId.setDisabled(true);
				txtValorUnitario.setValue(entity.getValorUnitario());
				txtValorUnitario.setDisabled(false);
				txtValorTotal.setValue(entity.getValorTotal());
				txtValorTotal.setDisabled(false);
				txtCantidadKilosLiq.setValue(entity.getCantidadKilosLiq());
				txtCantidadKilosLiq.setDisabled(false);
				
				/******* sesion concerniente al detalle por producto ***/
				
				txtModalidadCosId_ModalidadCosecha.setDisabled(false);
				txtNivel1Id.setDisabled(false);
				txtNivel2Id.setDisabled(false);
				txtNivel3Id.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);
				txtFinCosecha.setDisabled(false);
				txtEtapaNivel4.setDisabled(false);
				txtVariedNivel4.setDisabled(false);
				txtCantidadCosechada.setDisabled(false);
				txtPorcMateriaExtrana.setDisabled(false);
				txtPorcSacarosa.setDisabled(false);
				txtKilosPorTonelada.setDisabled(false);
				txtPorcRendimiento.setDisabled(false);
				txtCantidadCosechadaHa.setDisabled(false);
				txtAreaCosechada.setDisabled(false);
				txtEdadNivel4.setDisabled(false);
				txtVagonId.setDisabled(false);
				txtClienteNivel4.setDisabled(false);
				txtNumeroViajes.setDisabled(false);
				txtCantidadCosechadaHaMes.setDisabled(false);
				txtTonAzucarHaMes.setDisabled(false);				
				txtDestinoProduccion.setDisabled(false);				
				btnAgregarNivel4.setDisabled(false);
				
				Long datTransProdId = FacesUtils.checkLong(txtDatTransProdId);
				
				dataDetTransNivel4 = null;
				dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(datTransProdId);

				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}
	
	public void calcular_valor_unitario() {
		
		if (txtKilogramosAzucarToneladas != null && txtKilogramosAzucarToneladas.getValue() != null
				&& txtValorKilogramosAzucar != null && txtValorKilogramosAzucar.getValue() != null) {
			
			Double valorKilAzucar = (Double) txtValorKilogramosAzucar.getValue();
			Double kilToneladasAzucar = (Double) txtKilogramosAzucarToneladas.getValue();
			
			Double valorUnitario = 0.0;
			
			if (valorKilAzucar > 0 && kilToneladasAzucar > 0) {
			
				valorUnitario = (valorKilAzucar * kilToneladasAzucar);
			
			}
			
			txtValorUnitarioCosecha.setValue(valorUnitario);	
			calcular_ingreso_bruto();
		}
	}
	
	public void calcular_ingreso_bruto() {
		
		if (txtValorUnitarioCosecha != null && txtValorUnitarioCosecha.getValue() != null
				&& txtCantidadCosechada != null && txtCantidadCosechada.getValue() != null) {
			
			Double cantidadCosechada = (Double) txtCantidadCosechada.getValue();
			Double valorUnitario = (Double) txtValorUnitarioCosecha.getValue();
			
			Double ingresoBruto = 0.0;
			
			if (cantidadCosechada > 0 && valorUnitario > 0) {
			
				ingresoBruto = (cantidadCosechada * valorUnitario);
			
			}
			
			txtIngresoBruto.setValue(ingresoBruto);			
		}
	}
	
	
	
	public void calcular_bonificacion_descuentos() throws NumberFormatException, Exception {
		
		if (txtIngresoBruto != null && txtIngresoBruto.getValue() != null
				&& txtPorcRendimiento != null && txtPorcRendimiento.getValue() != null) {
			
			Double ingresoBruto = FacesUtils.checkDouble(txtIngresoBruto);
			Double rendimiento = (Double) txtPorcRendimiento.getValue();
			
			Long companiaId = new Long(getCompaniaIdSession());
			Compania compania = businessDelegatorView.getCompania(companiaId);
			
			Double AzTc = 0.0;//compania.getKilosAzucarTc();
			Double valorKgAzucar = 0.0;//compania.getValorKgAzucar();
			Double porcentajeRetenciones = 0.0;//compania.getRefPorcentaje();

			Double porcentajeDescuento =0.0;// compania.getRdcPorcentaje();
			Double rendimientoBase = 0.0;//compania.getRendimientoIngenio();
			Double bonificacion =0.0;
			Double descuento =0.0;
			Double retenciones=0.0;
			
			Double rtoFinal = rendimiento -rendimientoBase;
			if(rtoFinal>0) {
				bonificacion = ((rtoFinal*10)/100)*ingresoBruto;
				descuento = (porcentajeDescuento/100)*(ingresoBruto+bonificacion);
				retenciones =  (porcentajeRetenciones/100)*(ingresoBruto+bonificacion);
			}else {
				bonificacion = 0.0;
				descuento = (porcentajeDescuento/100)*(ingresoBruto+bonificacion);
				retenciones =  (porcentajeRetenciones/100)*(ingresoBruto+bonificacion);
			}
			
			
			txtBonificion.setValue(bonificacion);		
			txtRetenciones.setValue(retenciones);	
			txtDescuentos.setValue(descuento);	
			
		}
	}
	public String action_edit_cosecha(ActionEvent evt) {
		selectDetalle = (ListaProduccionDTO) (evt.getComponent().getAttributes().get("selectDetalle"));

		try {
			Long datTransProdNivel4Id = selectDetalle.getId().longValue();
			Object[] condicion = { "datTransProdNivel4Id", true, datTransProdNivel4Id, "=" };
			List<DatTransProd> lista = (datTransProdNivel4Id != null)
					? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				selectTipoTransaccion.setValue(entity.getTipoTransaccion());
				selectTipoTransaccion.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtFechaInicial.setValue(entity.getFechaInicial());
				txtFechaInicial.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtDatTransProdId.setValue(entity.getDatTransProdId());
				txtDatTransProdId.setDisabled(true);
				
				/******* sesion concerniente al detalle por producto ***/
				
				txtAreaCosechada.setDisabled(false);
				txtVariedNivel4.setDisabled(false);
				txtEtapaNivel4.setDisabled(false);
				
			//	txtNivel1Id.setDisabled(false);
				//txtNivel2Id.setDisabled(false);
			//	txtNivel3Id.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);
				txtFinCosecha.setDisabled(false);
				txtCantidadCosechada.setDisabled(false);
				txtPorcRendimiento.setDisabled(false);				
				txtKilogramosAzucarToneladas.setDisabled(false);
				txtValorKilogramosAzucar.setDisabled(false);
				txtValorUnitarioCosecha.setDisabled(false);
				txtIngresoBruto.setDisabled(false);				
				txtAjusteLiquidacion.setDisabled(false);
				txtBonificion.setDisabled(false);
				txtOtrosIngresos.setDisabled(false);
				txtRetenciones.setDisabled(false);
				txtDescuentos.setDisabled(false);
				
				btnAgregarNivel4.setDisabled(false);
				
				Long datTransProdId = FacesUtils.checkLong(txtDatTransProdId);
				
				dataDetTransNivel4 = null;
				dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(datTransProdId);

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
			if ((selectedDatTransProd == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new DatTransProd();

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			entity.setCompania(compania);
			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoDatTransProd(compania)));
			entity.setTipoTransaccion(FacesUtils.checkString(selectTipoTransaccion));
			entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccion));
			entity.setEstado("A");
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConductor((FacesUtils.checkLong(txtConductorId_Conductor)));
			entity.setFrenteCos((FacesUtils.checkLong(txtFrtCosId_FrenteCos)));
			entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora)));
			entity.setVehiculoId((FacesUtils.checkLong(txtVehiTranspId_VehiculosTransp)));
			entity.setEmpresaCompradora((FacesUtils.checkLong(txtEmpresaCompradora)));
			entity.setValorUnitario((FacesUtils.checkDouble(txtValorUnitario)));
			entity.setValorTotal((FacesUtils.checkDouble(txtValorTotal)));
			entity.setValorDeduccion((FacesUtils.checkDouble(txtValorDeduccion)));
			entity.setValorNeto((FacesUtils.checkDouble(txtValorNeto)));
			entity.setCantidadKilosLiq((FacesUtils.checkDouble(txtCantidadKilosLiq)));
			
			businessDelegatorView.saveDatTransProd(entity, dataDetTransProductos, 
					dataDetTransNivel4, null);

			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoDatTransProd(compania) - 1));
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
				Long datTransProdId = new Long(selectedDatTransProd.getDatTransProdId());
				entity = businessDelegatorView.getDatTransProd(datTransProdId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			entity.setEstado("A");
			entity.setCompania(compania);
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setTipoTransaccion(FacesUtils.checkString(selectTipoTransaccion));
			entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));

			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setConductor((FacesUtils.checkLong(txtConductorId_Conductor)));
			entity.setFrenteCos((FacesUtils.checkLong(txtFrtCosId_FrenteCos)));
			entity.setModalidadCosecha((FacesUtils.checkLong(txtModalidadCosId_ModalidadCosecha)));
			entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora)));
			entity.setVehiculoId((FacesUtils.checkLong(txtVehiTranspId_VehiculosTransp)));
			entity.setEmpresaCompradora((FacesUtils.checkLong(txtEmpresaCompradora)));
			entity.setValorUnitario((FacesUtils.checkDouble(txtValorUnitario)));
			entity.setValorTotal((FacesUtils.checkDouble(txtValorTotal)));
			entity.setValorDeduccion((FacesUtils.checkDouble(txtValorDeduccion)));
			entity.setValorNeto((FacesUtils.checkDouble(txtValorNeto)));
			entity.setCantidadKilosLiq((FacesUtils.checkDouble(txtCantidadKilosLiq)));

			businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, 
					dataDetTransNivel4, null);
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
			selectedDatTransProd = (DatTransProdDTO) (evt.getComponent().getAttributes().get("selectedDatTransProd"));

			Long datTransProdId = new Long(selectedDatTransProd.getDatTransProdId());
			entity = businessDelegatorView.getDatTransProd(datTransProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datTransProdId = FacesUtils.checkLong(txtDatTransProdId);
			entity = businessDelegatorView.getDatTransProd(datTransProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatTransProd(entity);
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
			selectedDatTransProd = (DatTransProdDTO) (evt.getComponent().getAttributes().get("selectedDatTransProd"));

			Long datTransProdId = new Long(selectedDatTransProd.getDatTransProdId());
			entity = businessDelegatorView.getDatTransProd(datTransProdId);
			businessDelegatorView.deleteDatTransProd(entity);
			((Map<String, Object>) data).remove(selectedDatTransProd);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anioFiscalNivel4, Long compania, Long consecutivo, Long datTransProdId,
			String destinoProduccion, Double edadNivel4, String estado, Long etapaNivel4, Long faseFenoNivel4,
			Date fechaCreacion, Date fechaModificacion, Date fechaRegistro, String infoAdicional, String infoAdicional2,
			String mobileId, Long nivel1Id, Long nivel2Id, Long nivel3Id, String observacion,
			String observacionAnularReg, String tipoTransaccion, Long usuarioDigitacion, Long variedNivel4,
			Long empresaCompradora, Long conductorId_Conductor, Long frtCosId_FrenteCos,
			Long modalidadCosId_ModalidadCosecha, Long nivel4Id_Nivel4, Long proveId_Proveedor,
			Long transpId_Transportadora, Long vehiTranspId_VehiculosTransp) throws Exception {
		try {
			entity.setAnioFiscalNivel4(FacesUtils.checkLong(anioFiscalNivel4));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDestinoProduccion(FacesUtils.checkString(destinoProduccion));
			entity.setEdadNivel4(FacesUtils.checkDouble(edadNivel4));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEtapaNivel4(FacesUtils.checkLong(etapaNivel4));
			entity.setFaseFenoNivel4(FacesUtils.checkLong(faseFenoNivel4));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setMobileId(FacesUtils.checkString(mobileId));
			entity.setNivel1Id(FacesUtils.checkLong(nivel1Id));
			entity.setNivel2Id(FacesUtils.checkLong(nivel2Id));
			entity.setNivel3Id(FacesUtils.checkLong(nivel3Id));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setTipoTransaccion(FacesUtils.checkString(tipoTransaccion));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setVariedNivel4(FacesUtils.checkLong(variedNivel4));
			businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatTransProdView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}
	
	public void onCellEditProd(CellEditEvent event) throws Exception {
		Long transProd = FacesUtils.checkLong(txtDatTransProdId);
		
		
		if (transProd != null) {
			selectedDatTransNivel4 = (DatTransProdNivel4DTO) (event.getComponent().getAttributes()
					.get("selectedDatTransNivel4"));
			
			Long datTransProdNivel4Id = selectedDatTransNivel4.getDatTransProdNivel4Id().longValue();
			String columnaCell = event.getColumn().getHeaderText();
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityDatTransProdNivel4 = null;
	
				entityDatTransProdNivel4 = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
				
				if (columnaCell.equals("Hacienda")) {
	
					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);
	
					entityDatTransProdNivel4.setNivel2(Nivel2);
	
				} else if (columnaCell.equals("Lote")) {
	
					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);
	
					entityDatTransProdNivel4.setNivel4(Nivel4);
	
	
				} else if (columnaCell.equals("Producto")) {
	
					Long productoId = new Long(event.getNewValue().toString());
					Producto producto = businessDelegatorView.getProducto(productoId);
	
					entityDatTransProdNivel4.setProducto(producto);
	
				} else if (columnaCell.equals("Variedad")) {
	
					Long variedId = new Long(event.getNewValue().toString());
					Variedad variedad = businessDelegatorView.getVariedad(variedId);
	
					entityDatTransProdNivel4.setVariedNivel4(variedad);
	
				} else if (columnaCell.equals("N. Cortes")) {
	
					Long etapaId = new Long(event.getNewValue().toString());
					Etapa etapa = businessDelegatorView.getEtapa(etapaId);
	
					entityDatTransProdNivel4.setEtapaNivel4(etapa);
	
				} else if (columnaCell.equals("Área Cos")) {
	
					entityDatTransProdNivel4.setAreaCosechada((Double) newValue);
	
				} else if (columnaCell.equals("Tons")) {
	
					entityDatTransProdNivel4.setCantidadCosechada((Double) newValue);
	
				} else if (columnaCell.equals("TON/HA")) {
	
					entityDatTransProdNivel4.setCantidadCosechadaHa((Double) newValue);
	
				} else if (columnaCell.equals("Edad")) {
	
					entityDatTransProdNivel4.setEdadNivel4((Double) newValue);
	
				}else if (columnaCell.equals("No. Viajes")) {
	
					entityDatTransProdNivel4.setNumeroViajes((Double) newValue);
	
				}else if (columnaCell.equals("Cliente")) {
	
					Long persEmprId = new Long(event.getNewValue().toString());
					PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
	
					entityDatTransProdNivel4.setClienteId(persEmpr);
	
				}
				entity = businessDelegatorView.getDatTransProd(transProd);
				entityDatTransProdNivel4.setDatTransProd(entity);
				businessDelegatorView.updateDatTransProdNivel4(entityDatTransProdNivel4);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataDetTransNivel4 = null;
				entityDatTransProdNivel4 = null;
				selectedDatTransNivel4 = null;
	
				dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(transProd);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}		

	}

	public InputText getTxtRendimiento() {
		return txtRendimiento;
	}

	public void setTxtRendimiento(InputText txtRendimiento) {
		this.txtRendimiento = txtRendimiento;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public SelectOneMenu getSelectTipoTransaccion() {
		return selectTipoTransaccion;
	}

	public void setSelectTipoTransaccion(SelectOneMenu selectTipoTransaccion) {
		this.selectTipoTransaccion = selectTipoTransaccion;
	}

	public InputText getTxtAnioFiscalNivel4() {
		return txtAnioFiscalNivel4;
	}

	public void setTxtAnioFiscalNivel4(InputText txtAnioFiscalNivel4) {
		this.txtAnioFiscalNivel4 = txtAnioFiscalNivel4;
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

	public SelectOneMenu getTxtDestinoProduccion() {
		return txtDestinoProduccion;
	}

	public void setTxtDestinoProduccion(SelectOneMenu txtDestinoProduccion) {
		this.txtDestinoProduccion = txtDestinoProduccion;
	}

	public InputText getTxtEdadNivel4() {
		return txtEdadNivel4;
	}

	public void setTxtEdadNivel4(InputText txtEdadNivel4) {
		this.txtEdadNivel4 = txtEdadNivel4;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneMenu getTxtEtapaNivel4() {
		return txtEtapaNivel4;
	}

	public void setTxtEtapaNivel4(SelectOneMenu txtEtapaNivel4) {
		this.txtEtapaNivel4 = txtEtapaNivel4;
	}

	public InputText getTxtFaseFenoNivel4() {
		return txtFaseFenoNivel4;
	}

	public void setTxtFaseFenoNivel4(InputText txtFaseFenoNivel4) {
		this.txtFaseFenoNivel4 = txtFaseFenoNivel4;
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

	public InputText getTxtMobileId() {
		return txtMobileId;
	}

	public void setTxtMobileId(InputText txtMobileId) {
		this.txtMobileId = txtMobileId;
	}

	public SelectOneMenu getTxtNivel1Id() {
		return txtNivel1Id;
	}

	public void setTxtNivel1Id(SelectOneMenu txtNivel1Id) {
		this.txtNivel1Id = txtNivel1Id;
	}

	public SelectOneMenu getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(SelectOneMenu txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
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

	public SelectOneMenu getTxtTipoTransaccion() {
		return txtTipoTransaccion;
	}

	public void setTxtTipoTransaccion(SelectOneMenu txtTipoTransaccion) {
		this.txtTipoTransaccion = txtTipoTransaccion;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public SelectOneMenu getTxtVariedNivel4() {
		return txtVariedNivel4;
	}

	public void setTxtVariedNivel4(SelectOneMenu txtVariedNivel4) {
		this.txtVariedNivel4 = txtVariedNivel4;
	}

	public SelectOneMenu getTxtConductorId_Conductor() {
		return txtConductorId_Conductor;
	}

	public void setTxtConductorId_Conductor(SelectOneMenu txtConductorId_Conductor) {
		this.txtConductorId_Conductor = txtConductorId_Conductor;
	}

	public SelectOneMenu getTxtFrtCosId_FrenteCos() {
		return txtFrtCosId_FrenteCos;
	}

	public void setTxtFrtCosId_FrenteCos(SelectOneMenu txtFrtCosId_FrenteCos) {
		this.txtFrtCosId_FrenteCos = txtFrtCosId_FrenteCos;
	}

	public SelectOneMenu getTxtModalidadCosId_ModalidadCosecha() {
		return txtModalidadCosId_ModalidadCosecha;
	}

	public void setTxtModalidadCosId_ModalidadCosecha(SelectOneMenu txtModalidadCosId_ModalidadCosecha) {
		this.txtModalidadCosId_ModalidadCosecha = txtModalidadCosId_ModalidadCosecha;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public SelectOneMenu getTxtProveId_Proveedor() {
		return txtProveId_Proveedor;
	}

	public void setTxtProveId_Proveedor(SelectOneMenu txtProveId_Proveedor) {
		this.txtProveId_Proveedor = txtProveId_Proveedor;
	}

	public SelectOneMenu getTxtTranspId_Transportadora() {
		return txtTranspId_Transportadora;
	}

	public void setTxtTranspId_Transportadora(SelectOneMenu txtTranspId_Transportadora) {
		this.txtTranspId_Transportadora = txtTranspId_Transportadora;
	}

	public SelectOneMenu getTxtVehiTranspId_VehiculosTransp() {
		return txtVehiTranspId_VehiculosTransp;
	}

	public void setTxtVehiTranspId_VehiculosTransp(SelectOneMenu txtVehiTranspId_VehiculosTransp) {
		this.txtVehiTranspId_VehiculosTransp = txtVehiTranspId_VehiculosTransp;
	}

	public SelectOneMenu getTxtEmpresaCompradora() {
		return txtEmpresaCompradora;
	}

	public void setTxtEmpresaCompradora(SelectOneMenu txtEmpresaCompradora) {
		this.txtEmpresaCompradora = txtEmpresaCompradora;
	}

	public InputText getTxtAreaCosechada() {
		return txtAreaCosechada;
	}

	public void setTxtAreaCosechada(InputText txtAreaCosechada) {
		this.txtAreaCosechada = txtAreaCosechada;
	}

	public InputText getTxtCantidadSolicitada() {
		return txtCantidadSolicitada;
	}

	public void setTxtCantidadSolicitada(InputText txtCantidadSolicitada) {
		this.txtCantidadSolicitada = txtCantidadSolicitada;
	}

	public InputText getTxtCantidadReal() {
		return txtCantidadReal;
	}

	public void setTxtCantidadReal(InputText txtCantidadReal) {
		this.txtCantidadReal = txtCantidadReal;
	}

	public Spinner getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(Spinner txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public Spinner getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(Spinner txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public SelectOneMenu getTxtClienteDet() {
		return txtClienteDet;
	}

	public void setTxtClienteDet(SelectOneMenu txtClienteDet) {
		this.txtClienteDet = txtClienteDet;
	}

	public SelectOneMenu getTxtUdadMed() {
		return txtUdadMed;
	}

	public void setTxtUdadMed(SelectOneMenu txtUdadMed) {
		this.txtUdadMed = txtUdadMed;
	}

	public SelectOneMenu getTxtCiudad() {
		return txtCiudad;
	}

	public void setTxtCiudad(SelectOneMenu txtCiudad) {
		this.txtCiudad = txtCiudad;
	}

	public SelectOneMenu getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(SelectOneMenu txtProducto) {
		this.txtProducto = txtProducto;
	}

	public SelectOneMenu gettxtEmpaque() {
		return txtEmpaque;
	}

	public void settxtEmpaque(SelectOneMenu txtEmpaque) {
		this.txtEmpaque = txtEmpaque;
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

	public InputText getTxtDatTransProdId() {
		return txtDatTransProdId;
	}

	public void setTxtDatTransProdId(InputText txtDatTransProdId) {
		this.txtDatTransProdId = txtDatTransProdId;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	/*public LazyDataModel<DatTransProdDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatTransProdDTO> datTransProdDTO) {
		this.data = datTransProdDTO;
	}*/
	
	public List<DatTransProdDTO> getData() {
		return data;
	}

	public void setData(List<DatTransProdDTO> datTransProdDTO) {
		this.data = datTransProdDTO;
	}
	
	public List<DatTransProdDTO> getData2() {
		try {
			if (data2 == null) {
				data2 = businessDelegatorView.getDataDatTransProd();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data2;
	}

	public void setData2(List<DatTransProdDTO> data2) {
		this.data2 = data2;
	}

	public DatTransProdDTO getSelectedDatTransProd() {
		return selectedDatTransProd;
	}

	public void setSelectedDatTransProd(DatTransProdDTO datTransProd) {
		this.selectedDatTransProd = datTransProd;
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

	public String actionDeleteDatTransProdDet(ActionEvent evt) {
		try {

			selectedDatTransProdDet = (DatTransProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatTransProdDet"));

			if (selectedDatTransProdDet.getDatTransProdDetId() == null) {
				dataDetTransProductos.remove(selectedDatTransProdDet);
			} else {
				Long datTransProdDetId = new Long(selectedDatTransProdDet.getDatTransProdDetId());
				DatTransProdDet entity = businessDelegatorView.getDatTransProdDet(datTransProdDetId);
				businessDelegatorView.deleteDatTransProdDet(entity);
				dataDetTransProductos.remove(selectedDatTransProdDet);
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteDatTransProdNivel4(ActionEvent evt) {
		try {

			selectedDatTransNivel4 = (DatTransProdNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedDatTransNivel4"));

			if (selectedDatTransNivel4.getDatTransProdNivel4Id() == null) {
				dataDetTransNivel4Cosecha.remove(selectedDatTransNivel4);
			} else {
				Long datTransProdNivel4Id = new Long(selectedDatTransNivel4.getDatTransProdNivel4Id());
				DatTransProdNivel4 entity = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
				businessDelegatorView.deleteDatTransProdNivel4(entity);
				dataDetTransNivel4Cosecha.remove(selectedDatTransNivel4);
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectItem[] getselectNivel1() {

		if (nivel1 == null || nivel1.size() == 0) {

			nivel1 = new ArrayList<Nivel1>();

			try {

				nivel1 = businessDelegatorView.getNivel1(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel1> lista = businessDelegatorView.findByCriteriaInNivel1(condicion, null, null);
				selectNivel1 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel1 nivel1 : lista) {
					selectNivel1[i] = new SelectItem(nivel1.getNivel1Id(), nivel1.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel1;
	}

	public void setselectNivel1(SelectItem[] selectNivel1) {
		this.selectNivel1 = selectNivel1;
	}
/*
	public SelectItem[] getselectNivel2() {

		nivel2 = new ArrayList<Nivel2>();

		Long nivel1Id = null;

		if (txtNivel1Id != null && txtNivel1Id.getValue() != null && !txtNivel1Id.getValue().equals("")) {
			nivel1Id = Long.parseLong(txtNivel1Id.getValue().toString());

			try {
				Nivel1 nivel1 = businessDelegatorView.getNivel1(nivel1Id);
				Object[] niveles2 = nivel1.getNivel2s().toArray();

				selectNivel2 = new SelectItem[niveles2.length];

				int i = 0;
				for (Object object : niveles2) {
					Nivel2 nivel2 = (Nivel2) object;
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel2;
	}

	public void setselectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}
*/
	public SelectItem[] getselectNivel3() {

		nivel3 = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2Id != null && txtNivel2Id.getValue() != null && !txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				//Object[] niveles3 = nivel2.getNivel3s().toArray();
				Object[] condicion = { "nivel2", true, nivel2Id, "=" };
				List<Nivel3> niveles3 = businessDelegatorView.findByCriteriaInNivel3(condicion, null, null);
				
				selectNivel3 = new SelectItem[niveles3.size()];

				int i = 0;
				for (Object object : niveles3) {
					Nivel3 nivel3 = (Nivel3) object;
					selectNivel3[i] = new SelectItem(nivel3.getNivel3Id(), nivel3.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3;
	}

	public void setselectNivel3(SelectItem[] selectNivel3) {
		this.selectNivel3 = selectNivel3;
	}

	public SelectItem[] getselectNivel4() {
		nivel4 = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3Id != null && txtNivel3Id.getValue() != null && !txtNivel3Id.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3Id.getValue().toString());

			try {
				Nivel3 nivel3 = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4 = nivel3.getNivel4s().toArray();

				selectNivel4 = new SelectItem[niveles4.length];

				int i = 0;
				for (Object object : niveles4) {
					Nivel4 nivel4 = (Nivel4) object;
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(), nivel4.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4;
	}

	public void setselectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}
	
	public SelectItem[] getSelectNivel2Edit() {

		if (nivel2Edit == null || nivel2Edit.size() == 0) {


			try {

				nivel2Edit = businessDelegatorView.getNivel2(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Edit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Edit : lista) {
					selectNivel2Edit[i] = new SelectItem(nivel2Edit.getNivel2Id(), nivel2Edit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Edit;
	}


	public void setSelectNivel2Edit(SelectItem[] selectNivel2Edit) {

		this.selectNivel2Edit = selectNivel2Edit;
	}
	
	public SelectItem[] getSelectNivel4Edit() {

		if (nivel4Edit == null || nivel4Edit.size() == 0) {


			try {

				nivel4Edit = businessDelegatorView.getNivel4();
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4Edit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4Edit : lista) {
					selectNivel4Edit[i] = new SelectItem(nivel4Edit.getNivel4Id(), nivel4Edit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4Edit;
	}
	
	public void setSelectNivel4Edit(SelectItem[] selectNivel4Edit) {
		this.selectNivel4Edit = selectNivel4Edit;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			udadMed = new ArrayList<UdadMed>();

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin by
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

	public SelectItem[] getselectEmpresaCompradora() {

		if (empresaCompradora == null || empresaCompradora.size() == 0) {


			try {

				empresaCompradora = businessDelegatorView.getPersEmpr(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectEmpresaCompradora = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr empresaCompradora : lista) {
					selectEmpresaCompradora[i] = new SelectItem(empresaCompradora.getPersEmprId(),
							empresaCompradora.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEmpresaCompradora;
	}

	public void setselectEmpresaCompradora(SelectItem[] selectEmpresaCompradora) {
		this.selectEmpresaCompradora = selectEmpresaCompradora;
	}

	public SelectItem[] getselectProveedor() {

		if (proveedor == null || proveedor.size() == 0) {

			proveedor = new ArrayList<PersEmpr>();

			try {

				proveedor = businessDelegatorView.getPersEmpr(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProveedor = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr proveedor : lista) {
					selectProveedor[i] = new SelectItem(proveedor.getPersEmprId(), proveedor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProveedor;
	}

	public void setselectProveedor(SelectItem[] selectProveedor) {
		this.selectProveedor = selectProveedor;
	}

	public SelectItem[] getselectCliente() {

		if (cliente == null || cliente.size() == 0) {

			cliente = new ArrayList<PersEmpr>();

			try {

				cliente = businessDelegatorView.getPersEmpr(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectCliente = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr cliente : lista) {
					selectCliente[i] = new SelectItem(cliente.getPersEmprId(), cliente.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCliente;
	}

	public void setselectCliente(SelectItem[] selectCliente) {
		this.selectCliente = selectCliente;
	}

	public SelectItem[] getselectFrenteCos() {

		if (frenteCos == null || frenteCos.size() == 0) {

			frenteCos = new ArrayList<FrenteCos>();

			try {

				frenteCos = businessDelegatorView.getFrenteCos(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FrenteCos> lista = businessDelegatorView.findByCriteriaInFrenteCos(condicion, null, null);
				selectFrenteCos = new SelectItem[lista.size()];

				int i = 0;
				for (FrenteCos frenteCos : lista) {
					selectFrenteCos[i] = new SelectItem(frenteCos.getFrtCosId(), frenteCos.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFrenteCos;
	}

	public void setselectFrenteCos(SelectItem[] selectFrenteCos) {
		this.selectFrenteCos = selectFrenteCos;
	}

	public SelectItem[] getselectCiudad() {

		if (ciudad == null || ciudad.size() == 0) {

			ciudad = new ArrayList<Ciudad>();

			try {

				ciudad = businessDelegatorView.getCiudad(); // Fin by
				// Criteria
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudad = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudad : lista) {
					selectCiudad[i] = new SelectItem(ciudad.getCiudadId(), ciudad.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudad;
	}

	public void setselectCiudad(SelectItem[] selectCiudad) {
		this.selectCiudad = selectCiudad;
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

	public SelectItem[] getselectTransportadora() {

		if (transportadora == null || transportadora.size() == 0) {

			transportadora = new ArrayList<Transportadora>();

			try {

				transportadora = businessDelegatorView.getTransportadora(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Transportadora> lista = businessDelegatorView.findByCriteriaInTransportadora(condicion, null,
						null);
				selectTransportadora = new SelectItem[lista.size()];

				int i = 0;
				for (Transportadora transportadora : lista) {
					selectTransportadora[i] = new SelectItem(transportadora.getTranspId(), transportadora.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTransportadora;
	}

	public void setselectTransportadora(SelectItem[] selectTransportadora) {
		this.selectTransportadora = selectTransportadora;
	}

	public SelectItem[] getSelectConductor() {

		if (conductor == null || conductor.size() == 0) {

			conductor = new ArrayList<Trabajador>();

			try {

				conductor = businessDelegatorView.getTrabajador(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectConductor = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador conductor : lista) {
					selectConductor[i] = new SelectItem(conductor.getTrabId(), conductor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConductor;
		
	}

	public void setSelectConductor(SelectItem[] selectConductor) {
		this.selectConductor = selectConductor;
	}

	public SelectItem[] getSelectVehiculosTransp() {
		
		if (vehiculosTransp == null || vehiculosTransp.size() == 0) {

			vehiculosTransp = new ArrayList<Equipo>();

			try {

				vehiculosTransp = businessDelegatorView.getEquipo(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null,
						null);
				selectVehiculosTransp = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo vehiculosTransp : lista) {
					selectVehiculosTransp[i] = new SelectItem(vehiculosTransp.getEquipoId(),
							vehiculosTransp.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectVehiculosTransp;		
	}

	public void setSelectVehiculosTransp(SelectItem[] selectVehiculosTransp) {
		this.selectVehiculosTransp = selectVehiculosTransp;
	}

	public SelectItem[] getselectModalidadCosecha() {

		if (modalidadCosecha == null || modalidadCosecha.size() == 0) {

			
			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ModalidadCosecha> lista = businessDelegatorView.findByCriteriaInModalidadCosecha(condicion, null,
						null);
				selectModalidadCosecha = new SelectItem[lista.size()];

				int i = 0;
				for (ModalidadCosecha modalidadCosecha : lista) {
					selectModalidadCosecha[i] = new SelectItem(modalidadCosecha.getModalidadCosId(),
							modalidadCosecha.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectModalidadCosecha;
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectDetalle.getId());
				entity = businessDelegatorView.getDatTransProd(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		selectDetalle = (ListaProduccionDTO) (evt.getComponent().getAttributes().get("selectDetalle"));

		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public void selectModalidadCosecha(SelectItem[] selectModalidadCosecha) {
		this.selectModalidadCosecha = selectModalidadCosecha;
	}

	private class LocalDataModelDTO extends LazyDataModel<DatTransProdDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatTransProdDTO> datTransProdDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatTransProdDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datTransProdDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberDatTransProd(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datTransProdDTO;

		}

		@Override
		public DatTransProdDTO getRowData(String rowKey) {
			for (DatTransProdDTO datTransProdDTOtmp : datTransProdDTO) {
				if (datTransProdDTOtmp.getDatTransProdId().toString().equals(rowKey))
					return datTransProdDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatTransProdDTO datTransProdDTOtmp) {
			return datTransProdDTOtmp.getDatTransProdId();
		}

	}

	private List<DatTransProdDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageDatTransProd(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public SelectItem[] getselectVagon() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectVagon = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectVagon[i] = new SelectItem(equipo.getEquipoId(), equipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectVagon;
	}


	public void setselectVagon(SelectItem[] selectVagon) {
		this.selectVagon = selectVagon;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public InputText getTxtNombreProducto() {
		return txtNombreProducto;
	}

	public void setTxtNombreProducto(InputText txtNombreProducto) {
		this.txtNombreProducto = txtNombreProducto;
	}

	public InputText getTxtNombreUdadMed() {
		return txtNombreUdadMed;
	}

	public void setTxtNombreUdadMed(InputText txtNombreUdadMed) {
		this.txtNombreUdadMed = txtNombreUdadMed;
	}

	public InputText getTxtNombreCiudad() {
		return txtNombreCiudad;
	}

	public void setTxtNombreCiudad(InputText txtNombreCiudad) {
		this.txtNombreCiudad = txtNombreCiudad;
	}

	public InputText getTxtCodCliente() {
		return txtCodCliente;
	}

	public void setTxtCodCliente(InputText txtCodCliente) {
		this.txtCodCliente = txtCodCliente;
	}

	public InputText getTxtCodEmpaque() {
		return txtCodEmpaque;
	}

	public void setTxtCodEmpaque(InputText txtCodEmpaque) {
		this.txtCodEmpaque = txtCodEmpaque;
	}

	public SelectOneMenu getTxtEmpaque() {
		return txtEmpaque;
	}

	public void setTxtEmpaque(SelectOneMenu txtEmpaque) {
		this.txtEmpaque = txtEmpaque;
	}

	public List<DatTransProdNivel4DTO> getDataDetTransNivel4() {
		return dataDetTransNivel4;
	}

	public void setDataDetTransNivel4(List<DatTransProdNivel4DTO> dataDetTransNivel4) {
		this.dataDetTransNivel4 = dataDetTransNivel4;
	}

	public void setDataDetTransProductos(List<DatTransProdDetDTO> dataDetTransProductos) {
		this.dataDetTransProductos = dataDetTransProductos;
	}

	public CommandButton getBtnAgregarNivel4() {
		return btnAgregarNivel4;
	}

	public void setBtnAgregarNivel4(CommandButton btnAgregarNivel4) {
		this.btnAgregarNivel4 = btnAgregarNivel4;
	}

	public InputText getTxtNombreNivel2() {
		return txtNombreNivel2;
	}

	public void setTxtNombreNivel2(InputText txtNombreNivel2) {
		this.txtNombreNivel2 = txtNombreNivel2;
	}

	public InputText getTxtNombreNivel4() {
		return txtNombreNivel4;
	}

	public void setTxtNombreNivel4(InputText txtNombreNivel4) {
		this.txtNombreNivel4 = txtNombreNivel4;
	}

	public InputText getTxtCodigoNivel4() {
		return txtCodigoNivel4;
	}

	public void setTxtCodigoNivel4(InputText txtCodigoNivel4) {
		this.txtCodigoNivel4 = txtCodigoNivel4;
	}

	public InputText getTxtNombreModCosecha() {
		return txtNombreModCosecha;
	}

	public void setTxtNombreModCosecha(InputText txtNombreModCosecha) {
		this.txtNombreModCosecha = txtNombreModCosecha;
	}

	public SelectOneRadio getTxtFinCosecha() {
		return txtFinCosecha;
	}

	public void setTxtFinCosecha(SelectOneRadio txtFinCosecha) {
		this.txtFinCosecha = txtFinCosecha;
	}

	public List<String> getRestriccionDeQuema() {
		return restriccionDeQuema;
	}

	public void setRestriccionDeQuema(List<String> restriccionDeQuema) {
		this.restriccionDeQuema = restriccionDeQuema;
	}

	public List<String> getRestriccionDeMadurante() {
		return restriccionDeMadurante;
	}

	public void setRestriccionDeMadurante(List<String> restriccionDeMadurante) {
		this.restriccionDeMadurante = restriccionDeMadurante;
	}

	public List<VariedadNivel4DTO> getDataVariedad() {
		return dataVariedad;
	}

	public void setDataVariedad(List<VariedadNivel4DTO> dataVariedad) {
		this.dataVariedad = dataVariedad;
	}

	public InputText getTxtCantidadRacimos() {
		return txtCantidadRacimos;
	}

	public void setTxtCantidadRacimos(InputText txtCantidadRacimos) {
		this.txtCantidadRacimos = txtCantidadRacimos;
	}

	public InputText getTxtPesoPromedio() {
		return txtPesoPromedio;
	}

	public void setTxtPesoPromedio(InputText txtPesoPromedio) {
		this.txtPesoPromedio = txtPesoPromedio;
	}

	public SelectOneMenu getTxtIndicadorDistribuccion() {
		return txtIndicadorDistribuccion;
	}

	public void setTxtIndicadorDistribuccion(SelectOneMenu txtIndicadorDistribuccion) {
		this.txtIndicadorDistribuccion = txtIndicadorDistribuccion;
	}

	public SelectOneMenu getTxtVagonId() {
		return txtVagonId;
	}

	public void setTxtVagonId(SelectOneMenu txtVagonId) {
		this.txtVagonId = txtVagonId;
	}

	public InputText getTxtCodVagon() {
		return txtCodVagon;
	}

	public void setTxtCodVagon(InputText txtCodVagon) {
		this.txtCodVagon = txtCodVagon;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public SelectItem[] getSelectItemVariedad() {

		if (variedad == null || variedad.size() == 0) {


			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Variedad> lista = businessDelegatorView.findByCriteriaInVariedad(condicion, null, null);
				selectItemVariedad = new SelectItem[lista.size()];

				int i = 0;
				for (Variedad v : lista) {
					selectItemVariedad[i] = new SelectItem(v.getVariedId(), v.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemVariedad;
	}

	public void setSelectItemVariedad(SelectItem[] selectItemVariedad) {
		this.selectItemVariedad = selectItemVariedad;
	}

	public SelectItem[] getSelectItemEtapa() {

		if (etapa == null || etapa.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Etapa> lista = businessDelegatorView.findByCriteriaInEtapa(condicion, null, null);
				selectItemEtapa = new SelectItem[lista.size()];

				int i = 0;
				for (Etapa et : lista) {
					selectItemEtapa[i] = new SelectItem(et.getEtapaId(), et.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemEtapa;
	}

	public void setSelectItemEtapa(SelectItem[] selectItemEtapa) {
		this.selectItemEtapa = selectItemEtapa;
	}

	public InputText getTxtNombreEtapa() {
		return txtNombreEtapa;
	}

	public void setTxtNombreEtapa(InputText txtNombreEtapa) {
		this.txtNombreEtapa = txtNombreEtapa;
	}

	public InputText getTxtNombreVariedad() {
		return txtNombreVariedad;
	}

	public void setTxtNombreVariedad(InputText txtNombreVariedad) {
		this.txtNombreVariedad = txtNombreVariedad;
	}

	public Spinner getTxtCantidadKilosLiq() {
		return txtCantidadKilosLiq;
	}

	public void setTxtCantidadKilosLiq(Spinner txtCantidadKilosLiq) {
		this.txtCantidadKilosLiq = txtCantidadKilosLiq;
	}

	public Spinner getTxtValorDeduccion() {
		return txtValorDeduccion;
	}

	public void setTxtValorDeduccion(Spinner txtValorDeduccion) {
		this.txtValorDeduccion = txtValorDeduccion;
	}

	public Spinner getTxtValorNeto() {
		return txtValorNeto;
	}

	public void setTxtValorNeto(Spinner txtValorNeto) {
		this.txtValorNeto = txtValorNeto;
	}

	public InputText getTxtCantidadCosechada() {
		return txtCantidadCosechada;
	}

	public void setTxtCantidadCosechada(InputText txtCantidadCosechada) {
		this.txtCantidadCosechada = txtCantidadCosechada;
	}

	public InputText getTxtPorcMateriaExtrana() {
		return txtPorcMateriaExtrana;
	}

	public void setTxtPorcMateriaExtrana(InputText txtPorcMateriaExtrana) {
		this.txtPorcMateriaExtrana = txtPorcMateriaExtrana;
	}

	public InputText getTxtPorcSacarosa() {
		return txtPorcSacarosa;
	}

	public void setTxtPorcSacarosa(InputText txtPorcSacarosa) {
		this.txtPorcSacarosa = txtPorcSacarosa;
	}

	public InputText getTxtKilosPorTonelada() {
		return txtKilosPorTonelada;
	}

	public void setTxtKilosPorTonelada(InputText txtKilosPorTonelada) {
		this.txtKilosPorTonelada = txtKilosPorTonelada;
	}

	public InputText getTxtPorcRendimiento() {
		return txtPorcRendimiento;
	}

	public void setTxtPorcRendimiento(InputText txtPorcRendimiento) {
		this.txtPorcRendimiento = txtPorcRendimiento;
	}

	public InputText getTxtCantidadCosechadaHa() {
		return txtCantidadCosechadaHa;
	}

	public void setTxtCantidadCosechadaHa(InputText txtCantidadCosechadaHa) {
		this.txtCantidadCosechadaHa = txtCantidadCosechadaHa;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the dataDetTransProductos
	 */
	public List<DatTransProdDetDTO> getDataDetTransProductos() {
		return dataDetTransProductos;
	}

	/**
	 * @return the txtClienteNivel4
	 */
	public SelectOneMenu getTxtClienteNivel4() {
		return txtClienteNivel4;
	}

	/**
	 * @param txtClienteNivel4 the txtClienteNivel4 to set
	 */
	public void setTxtClienteNivel4(SelectOneMenu txtClienteNivel4) {
		this.txtClienteNivel4 = txtClienteNivel4;
	}

	/**
	 * @return the txtNumeroViajes
	 */
	public Spinner getTxtNumeroViajes() {
		return txtNumeroViajes;
	}

	/**
	 * @param txtNumeroViajes the txtNumeroViajes to set
	 */
	public void setTxtNumeroViajes(Spinner txtNumeroViajes) {
		this.txtNumeroViajes = txtNumeroViajes;
	}

	/**
	 * @return the txtCantidadCosechadaHaMes
	 */
	public InputText getTxtCantidadCosechadaHaMes() {
		return txtCantidadCosechadaHaMes;
	}

	/**
	 * @param txtCantidadCosechadaHaMes the txtCantidadCosechadaHaMes to set
	 */
	public void setTxtCantidadCosechadaHaMes(InputText txtCantidadCosechadaHaMes) {
		this.txtCantidadCosechadaHaMes = txtCantidadCosechadaHaMes;
	}

	/**
	 * @return the txtTonAzucarHaMes
	 */
	public InputText getTxtTonAzucarHaMes() {
		return txtTonAzucarHaMes;
	}

	/**
	 * @param txtTonAzucarHaMes the txtTonAzucarHaMes to set
	 */
	public void setTxtTonAzucarHaMes(InputText txtTonAzucarHaMes) {
		this.txtTonAzucarHaMes = txtTonAzucarHaMes;
	}
	

	public SelectItem[] getselectClienteNivel4() {

		if (clienteNivel4 == null || clienteNivel4.size() == 0) {

			
			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=","tipoEmpresa", true, "4", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectClienteNivel4 = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr clienteNivel4 : lista) {
					selectClienteNivel4[i] = new SelectItem(clienteNivel4.getPersEmprId(), clienteNivel4.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectClienteNivel4;
	}

	public void setselectClienteNivel4(SelectItem[] selectClienteNivel4) {
		this.selectClienteNivel4 = selectClienteNivel4;
	}


	public void listener_ConsultaConductor() {

		Long idEquipo = null;
		if (txtVehiTranspId_VehiculosTransp.getValue() != null) {
			if (!txtVehiTranspId_VehiculosTransp.getValue().equals("")) {
				idEquipo = Long.parseLong(txtVehiTranspId_VehiculosTransp.getValue().toString());

				try {
					Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
					/* valNPass = datPlanLabor.getNPases(); */
					txtConductorId_Conductor.setValue(equipo.getTrabajador());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}

	}
	


	public void action_agregarNivel4_cosecha() throws Exception {

		if (txtCantidadCosechada.getValue() != null && txtKilogramosAzucarToneladas.getValue() != null 
			&& txtValorKilogramosAzucar.getValue() !=null  && txtValorUnitarioCosecha.getValue() != null 
			&& txtIngresoBruto.getValue() != null && txtPorcRendimiento.getValue() != null 
			
			) {
			
					
			Long nivel2 = Long.parseLong(txtNivel2Id.getValue().toString());
			Nivel2 nivel2Id = businessDelegatorView.getNivel2(nivel2);
			Long nivel1Id =nivel2Id.getNivel1().getNivel1Id(); //Long.parseLong(txtNivel1Id.getValue().toString());	
			Long nivel4 = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			
			Nivel4 nivel4Id = businessDelegatorView.getNivel4(nivel4);			
			
			Long nivel3Id =nivel4Id.getNivel3().getNivel3Id();			
			Double areaLote =0.0;
			if (txtAreaCosechada.getValue()!=null) {
				 areaLote = FacesUtils.checkDouble(txtAreaCosechada);
			}else {
				areaLote = nivel4Id.getAreaNeta();
			}
			
			Variedad variedad = null;
			Etapa etapa = null;
			Long etapaId = null;
			Long variedadId = null;
			
			if (txtEtapaNivel4.getValue()!=null) {
				etapaId = FacesUtils.checkLong(txtEtapaNivel4);
				etapa = businessDelegatorView.getEtapa(etapaId);
			}
			
			if (txtVariedNivel4.getValue()!=null) {
				variedadId = FacesUtils.checkLong(txtVariedNivel4);
				variedad = businessDelegatorView.getVariedad(variedadId);
			}
			
			String nombreNivel2 = nivel2Id.getNombre();
			String codigoNivel4 = nivel4Id.getNombre();
			String nombreNivel4 = nivel4Id.getNombre();
			
			Double cantidadCosechada = FacesUtils.checkDouble(txtCantidadCosechada);
			Double kilAzucarTonelada = FacesUtils.checkDouble(txtKilogramosAzucarToneladas);
			Double valKilogramosAzucar = FacesUtils.checkDouble(txtValorKilogramosAzucar);
			Double valUnitarioCosecha = FacesUtils.checkDouble(txtValorUnitarioCosecha);
			Double ingresoBruto = FacesUtils.checkDouble(txtIngresoBruto);			
			Double rendimiento = FacesUtils.checkDouble(txtPorcRendimiento);
			Double ajusteLiquidacion = FacesUtils.checkDouble(txtAjusteLiquidacion);
			Double bonificacion = FacesUtils.checkDouble(txtBonificion);			
			Double otrosIngresos = FacesUtils.checkDouble(txtOtrosIngresos);
			Double retenciones = FacesUtils.checkDouble(txtRetenciones);
			Double descuentos = FacesUtils.checkDouble(txtDescuentos);
			Double edadCultivo = FacesUtils.checkDouble(txtEdadNivel4);
			String finCosecha = FacesUtils.checkString(txtFinCosecha);
			
			Date fechaInicioCosecha = FacesUtils.checkDate(txtFechaInicial);
			Date fechaFinCosecha = FacesUtils.checkDate(txtFechaRegistro);
			
			Double tonHectarea = cantidadCosechada / areaLote;			
			Double tonHectMes = tonHectarea / edadCultivo;
			
			boolean existeProducto = false;

			if (dataDetTransNivel4 == null) {
				dataDetTransNivel4 = new ArrayList<DatTransProdNivel4DTO>();
			}

			if (dataDetTransNivel4.size() > 0) {

				for (DatTransProdNivel4DTO d : dataDetTransNivel4) {

					if( nivel4 != null ) {
						
					} else {
						
						if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4Id.getNivel4Id().longValue()) {
	
								existeProducto = true;
	
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
								"El Lote " + d.getNivel4Id_Nivel4().getNivel4Id().longValue()
										+ " ya fue agregado a la lista, por favor seleccione otro. "));
	
							break;
						}
					}
				}

			}

			if (existeProducto == false) {

				DatTransProdNivel4DTO datTransProdNivel4DTO = new DatTransProdNivel4DTO();

				datTransProdNivel4DTO.setNivel1Id(nivel1Id);
				datTransProdNivel4DTO.setNivel2Id_Nivel2(nivel2Id);
				
				datTransProdNivel4DTO.setVariedNivel4(variedad);
				datTransProdNivel4DTO.setEtapaNivel4(etapa);
				
				datTransProdNivel4DTO.setNombreNivel2(nombreNivel2);
				datTransProdNivel4DTO.setNivel3Id(nivel3Id);
				datTransProdNivel4DTO.setNivel4Id_Nivel4(nivel4Id);
				datTransProdNivel4DTO.setCodigoNivel4(codigoNivel4);
				datTransProdNivel4DTO.setNombreNivel4(nombreNivel4);				
				datTransProdNivel4DTO.setCantidadCosechada(cantidadCosechada);				 
				datTransProdNivel4DTO.setKilogramosAzucarTonelada(kilAzucarTonelada);				
				datTransProdNivel4DTO.setValorKilogramosAzucar(valKilogramosAzucar);				
				datTransProdNivel4DTO.setValorUnitario(valUnitarioCosecha);				
				datTransProdNivel4DTO.setIngresoBruto(ingresoBruto);				
				datTransProdNivel4DTO.setPorcRendimiento(rendimiento);				
				datTransProdNivel4DTO.setAjusteLiquidacion(ajusteLiquidacion);				
				datTransProdNivel4DTO.setBonificacion(bonificacion);				
				datTransProdNivel4DTO.setOtrosIngresos(otrosIngresos);				
				datTransProdNivel4DTO.setRetenciones(retenciones);
				datTransProdNivel4DTO.setDescuentos(descuentos);	
				datTransProdNivel4DTO.setFinCosecha(finCosecha);
				datTransProdNivel4DTO.setEdadNivel4(edadCultivo);
				datTransProdNivel4DTO.setCantidadCosechadaHa(tonHectarea);
				datTransProdNivel4DTO.setCantidadCosechadaHaMes(tonHectMes);
				datTransProdNivel4DTO.setFechaInicioCosecha(fechaInicioCosecha);
				datTransProdNivel4DTO.setFechaFinCosecha(fechaFinCosecha);				
				
				dataDetTransNivel4.add(datTransProdNivel4DTO);				
			}
			etapa=null;
			variedad=null;
			etapaId=null;
			variedadId=null;
			nivel1Id = null;
			nivel2Id = null;
			nombreNivel2 = null;
			nivel3Id = null;
			nivel4Id = null;
			codigoNivel4 = null;
			nombreNivel4 = null;
			cantidadCosechada = null;			
			kilAzucarTonelada = null;
			valKilogramosAzucar = null;
			valUnitarioCosecha = null;
			ingresoBruto = null;
			rendimiento = null;
			ajusteLiquidacion = null;
			bonificacion = null;
			otrosIngresos = null;	
			retenciones = null;
			descuentos = null;
			finCosecha = null;
			areaLote = null;
			edadCultivo = null;
			tonHectarea = null;
			tonHectMes = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps! Verifique que los campos tipo de cosecha, finca, lote, área cosechada, variedad, N° de cosechas, cantidad cosechada tengan valores. 0" ,""));
		}
	}
	

	
	public void onCellEditProdCosecha(CellEditEvent event) throws Exception {

		selectedDatTransNivel4 = (DatTransProdNivel4DTO) (event.getComponent().getAttributes()
				.get("selectedDatTransNivel4"));
		
		Long datTransProdNivel4Id = selectedDatTransNivel4.getDatTransProdNivel4Id().longValue();
		String columnaCell = event.getColumn().getHeaderText();
		Long transProd = FacesUtils.checkLong(txtDatTransProdId);

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityDatTransProdNivel4 = null;
			entityDatTransProdNivel4 = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
			
			if (columnaCell.equals("Hacienda")) {

				Long nivel2Id = new Long(event.getNewValue().toString());
				Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				entityDatTransProdNivel4.setNivel2(Nivel2);

			} else if (columnaCell.equals("Lote")) {

				Long nivel4 = new Long(event.getNewValue().toString());
				Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);

				entityDatTransProdNivel4.setNivel4(Nivel4);

			} else if (columnaCell.equals("Cant. cosechada")) {

				entityDatTransProdNivel4.setCantidadCosechada((Double) newValue);

			} else if (columnaCell.equals("Kg. Az/TC")) {

				entityDatTransProdNivel4.setKilogramosAzucarTonelada((Double) newValue);

			} else if (columnaCell.equals("Valor Kg. Az")) {

				entityDatTransProdNivel4.setValorKilogramosAzucar((Double) newValue);

			} else if (columnaCell.equals("Val. Unitario")) {

				entityDatTransProdNivel4.setValorUnitario((Double) newValue);

			} else if (columnaCell.equals("Ingreso bruto")) {

				entityDatTransProdNivel4.setIngresoBruto((Double) newValue);

			} else if (columnaCell.equals("Rendimiento")) {

				entityDatTransProdNivel4.setPorcRendimiento((Double) newValue);

			} else if (columnaCell.equals("Bonificación")) {

				entityDatTransProdNivel4.setBonificacion((Double) newValue);

			} else if (columnaCell.equals("Fin cosecha")) {

				entityDatTransProdNivel4.setFinCosecha((String) newValue);
			}
			
			entity = businessDelegatorView.getDatTransProd(transProd);
			entityDatTransProdNivel4.setDatTransProd(entity);
			businessDelegatorView.updateDatTransProdNivel4(entityDatTransProdNivel4);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataDetTransNivel4Cosecha = null;
			entityDatTransProdNivel4 = null;
			selectedDatTransNivel4 = null;

			dataDetTransNivel4Cosecha = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(transProd);

		}	

	}

	public InputText getTxtConsecutivoDes() {
		return txtConsecutivoDes;
	}

	public void setTxtConsecutivoDes(InputText txtConsecutivoDes) {
		this.txtConsecutivoDes = txtConsecutivoDes;
	}

	public InputText getTxtConsecutivoSer() {
		return txtConsecutivoSer;
	}

	public void setTxtConsecutivoSer(InputText txtConsecutivoSer) {
		this.txtConsecutivoSer = txtConsecutivoSer;
	}

	public Calendar getTxtFechaRegistroDes() {
		return txtFechaRegistroDes;
	}

	public void setTxtFechaRegistroDes(Calendar txtFechaRegistroDes) {
		this.txtFechaRegistroDes = txtFechaRegistroDes;
	}

	public Calendar getTxtFechaRegistroSer() {
		return txtFechaRegistroSer;
	}

	public void setTxtFechaRegistroSer(Calendar txtFechaRegistroSer) {
		this.txtFechaRegistroSer = txtFechaRegistroSer;
	}

	public CommandButton getBtnSaveDes() {
		return btnSaveDes;
	}

	public void setBtnSaveDes(CommandButton btnSaveDes) {
		this.btnSaveDes = btnSaveDes;
	}

	public CommandButton getBtnSaveSer() {
		return btnSaveSer;
	}

	public void setBtnSaveSer(CommandButton btnSaveSer) {
		this.btnSaveSer = btnSaveSer;
	}

	public InputText getTxtKilogramosAzucarToneladas() {
		return txtKilogramosAzucarToneladas;
	}

	public void setTxtKilogramosAzucarToneladas(InputText txtKilogramosAzucarToneladas) {
		this.txtKilogramosAzucarToneladas = txtKilogramosAzucarToneladas;
	}

	public InputText getTxtValorKilogramosAzucar() {
		return txtValorKilogramosAzucar;
	}

	public void setTxtValorKilogramosAzucar(InputText txtValorKilogramosAzucar) {
		this.txtValorKilogramosAzucar = txtValorKilogramosAzucar;
	}

	public InputText getTxtValorUnitarioCosecha() {
		return txtValorUnitarioCosecha;
	}

	public void setTxtValorUnitarioCosecha(InputText txtValorUnitarioCosecha) {
		this.txtValorUnitarioCosecha = txtValorUnitarioCosecha;
	}

	public InputNumber getTxtIngresoBruto() {
		return txtIngresoBruto;
	}

	public void setTxtIngresoBruto(InputNumber txtIngresoBruto) {
		this.txtIngresoBruto = txtIngresoBruto;
	}

	public InputNumber getTxtAjusteLiquidacion() {
		return txtAjusteLiquidacion;
	}

	public void setTxtAjusteLiquidacion(InputNumber txtAjusteLiquidacion) {
		this.txtAjusteLiquidacion = txtAjusteLiquidacion;
	}

	public InputNumber getTxtBonificion() {
		return txtBonificion;
	}

	public void setTxtBonificion(InputNumber txtBonificion) {
		this.txtBonificion = txtBonificion;
	}

	public InputNumber getTxtOtrosIngresos() {
		return txtOtrosIngresos;
	}

	public void setTxtOtrosIngresos(InputNumber txtOtrosIngresos) {
		this.txtOtrosIngresos = txtOtrosIngresos;
	}

	public InputNumber getTxtRetenciones() {
		return txtRetenciones;
	}

	public void setTxtRetenciones(InputNumber txtRetenciones) {
		this.txtRetenciones = txtRetenciones;
	}

	public InputNumber getTxtDescuentos() {
		return txtDescuentos;
	}

	public void setTxtDescuentos(InputNumber txtDescuentos) {
		this.txtDescuentos = txtDescuentos;
	}

	public List<DatTransProdNivel4DTO> getDataDetTransNivel4Cosecha() {
		return dataDetTransNivel4Cosecha;
	}

	public void setDataDetTransNivel4Cosecha(List<DatTransProdNivel4DTO> dataDetTransNivel4Cosecha) {
		this.dataDetTransNivel4Cosecha = dataDetTransNivel4Cosecha;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputNumber getTxtPlanilla() {
		return txtPlanilla;
	}

	public void setTxtPlanilla(InputNumber txtPlanilla) {
		this.txtPlanilla = txtPlanilla;
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
	
	public SelectItem[] getSelectNivel2() {

		if (selectNivel2 == null || selectNivel2.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2 : lista) {
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
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
	
	
		public SelectItem[] getSelectLote() {
				
				if (txtNivel2Id != null && txtNivel2Id.getValue() != null) {
			
					try {
		
						Long compania = new Long(getCompaniaIdSession());
						String nivel2Id = FacesUtils.checkString(txtNivel2Id);				
						List<ListaNivel4DTO> lista = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
						selectLote = new SelectItem[lista.size()];
		
						int i = 0;
						for (ListaNivel4DTO nivel4 : lista) {
							selectLote[i] = new SelectItem(nivel4.getNivel4_id(), nivel4.getNom_nivel4());
							i++;
						}
		
					} catch (Exception e) {
						FacesUtils.addErrorMessage(e.getMessage());
						e.printStackTrace();
					}
				}
		
				return selectLote;
			}
		
		public void setSelectLote(SelectItem[] selectLote) {
			this.selectLote = selectLote;
		}
		
		public void listarProduccion() {
			try {

				Date fechaInicial = null;
				Date fechaFinal = null;
				fechaInicial = (FacesUtils.checkDate(txtFechaIni));
				fechaFinal = (FacesUtils.checkDate(txtFechaFin));
				Long planilla = FacesUtils.checkLong(txtPlanilla);

				if (planilla == null) {
					planilla = 0L;
				}

				Long flagHacienda = 1L;
				String haciendasSeleccionadas = "0";
				if (selectedHacienda != null && selectedHacienda.size() > 0) {
					haciendasSeleccionadas = selectedHacienda.get(0);
					flagHacienda = 0L;
					for (int i = 1; i < selectedHacienda.size(); i++) {
						haciendasSeleccionadas += "," + selectedHacienda.get(i);
					}
				}

				Long flagLote = 1L;
				String lotesSeleccionados = "0";
				if (selectedLote != null && selectedLote.size() > 0) {
					lotesSeleccionados = selectedLote.get(0);
					flagLote = 0L;
					for (int i = 1; i < selectedLote.size(); i++) {
						lotesSeleccionados += "," + selectedLote.get(i);
					}
				}

				Long compania = new Long(getCompaniaIdSession());
				if (compania != null && fechaInicial != null && fechaFinal != null) {

					dataDetalle = businessDelegator2View.pr_listar_reg_produccion(compania, fechaInicial, fechaFinal,
							planilla, haciendasSeleccionadas, flagHacienda, lotesSeleccionados, flagLote);

				} else if (compania != null && fechaInicial == null && fechaFinal == null) {

					SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
					fechaInicial = foriginal.parse("1970-01-01");
					fechaFinal = new Date();

					dataDetalle = businessDelegator2View.pr_listar_reg_produccion(compania, fechaInicial, fechaFinal,
							planilla, haciendasSeleccionadas, flagHacienda, lotesSeleccionados, flagLote);
				}

				/*double totalUnidades = 0; double totalCosto = 0; if (dataDetalle != null &&
				dataDetalle.size() >= 0) { for (GastosProduccionDTO data1 : dataDetalle) {
				totalUnidades += data1.getIngresoBruto().doubleValue(); totalCosto +=
				data1.getValorUnitario().doubleValue(); } }
				  
				txtValorTotalAcumulado.setValue(totalCosto);
				txtCantidadAcumulado.setValue(totalUnidades);*/

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		

		public List<String> getSelectedHacienda() {
			return selectedHacienda;
		}

		public void setSelectedHacienda(List<String> selectedHacienda) {
			this.selectedHacienda = selectedHacienda;
		}

		public List<Nivel2> getHaciendas() {

			if (haciendas == null || haciendas.size() == 0) {

				try {
					haciendas = businessDelegatorView.getNivel2();
				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}

			return haciendas;
		}

		public void setHaciendas(List<Nivel2> haciendas) {
			this.haciendas = haciendas;
		}

		public List<String> getSelectedLote() {
			return selectedLote;
		}

		public void setSelectedLote(List<String> selectedLote) {
			this.selectedLote = selectedLote;
		}

		public List<Nivel4> getLotes() {

			if (lotes == null || lotes.size() == 0) {

				try {
					lotes = businessDelegatorView.getNivel4();
				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}

			return lotes;
		}

		public void setLotes(List<Nivel4> lotes) {
			this.lotes = lotes;
		}

		public List<ListaProduccionDTO> getDataDetalle() {
			return dataDetalle;
		}

		public void setDataDetalle(List<ListaProduccionDTO> dataDetalle) {
			this.dataDetalle = dataDetalle;
		}
		
		
}
