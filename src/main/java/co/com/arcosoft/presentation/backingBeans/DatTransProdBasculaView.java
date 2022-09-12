package co.com.arcosoft.presentation.backingBeans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.servlet.http.HttpServletResponse;

import org.primefaces.PrimeFaces;
import org.primefaces.component.autocomplete.AutoComplete;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortPacketListener;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Bascula;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.DatTransProdNivel4;
import co.com.arcosoft.modelo.DatTransProdTrabajadores;
import co.com.arcosoft.modelo.Empaque;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.FrenteCos;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.LogBascula;
import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Transportadora;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.control.IEquipoLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.DatTransProdTrabajadoresDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaImprimirDespachosDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaImprimirProdDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@ManagedBean
@ViewScoped
public class DatTransProdBasculaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdBasculaView.class);
	private InputText txtAnioFiscalNivel4;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtConsecutivoDes;
	private InputText txtConsecutivoSer;

	private InputText txtConsecutivoNeto;
	private InputText txtConsecutivoNetoDes;
	private InputText txtConsecutivoNetoSer;

	private SelectOneMenu txtDestinoProduccion;
	private SelectOneMenu txtDestinoProduccionDes;
	private SelectOneMenu txtDestinoProduccionSer;
	private InputText txtEdadNivel4;
	private SelectOneRadio txtEstado;
	private InputText txtEtapaNivel4;
	private InputText txtFaseFenoNivel4;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicionalDes;
	private InputTextarea txtInfoAdicionalSer;
	private InputTextarea txtInfoAdicional2;
	private InputText txtMobileId;
	private InputText txtNoDocumento;
	private InputText txtNoDocumentoDes;
	private InputText txtNoDocumentoSer;
	private InputText txtOrigen;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionDes;
	private InputTextarea txtObservacionSer;
	private InputText txtObservacion2;
	private InputText txtObservacion2Des;
	private InputTextarea txtObservacion3;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtTipoTransaccion;
	private InputText txtTipoTransaccionDes;
	private InputText txtTipoTransaccionSer;
	private InputText txtUsuarioDigitacion;
	private InputText txtVariedNivel4;
	private InputText txtDatTransProdId;
	private InputText txtDatTransProdIdDes;
	private InputText txtDatTransProdIdSer;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private Calendar txtFechaRegistroDes;
	private Calendar txtFechaRegistroSer;
	private Calendar txtFechaAnulacion;
	private CommandButton btnSave;

	private CommandButton btnSavePes;
	private CommandButton btnImprimir;
	private CommandButton btnCalcular;

	private CommandButton btnSaveDes;
	private CommandButton btnSaveSer;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatTransProdDTO> data;
	private DatTransProdDTO selectedDatTransProd;
	private TiquetesBasculaDTO selectedDatBasculaTiquete;

	/*** Datos bascula ***/

	private static String valorLectura;

	private static InputNumber txtPesoBrutoPesaje;
	private static InputNumber txtPesoBrutoPesajeDes;
	private static InputNumber txtPesoBrutoPesajeSer;

	private static InputText valorPesaje;

	private static String formatoCadena;
	private int tiempoLectura;

	private String nombrePuerto = null;
	private int baudios = 0;
	private int paridad = 0;
	private int dataBits = 0;
	private int bitsDeParada = 0;
	private int inicio;
	private int fin;
	Long basculaId = null;

	private OutputLabel nombre1;
	private OutputLabel nombre2;

	private SelectOneMenu txtTipoPeso;
	private SelectOneMenu txtTipoPesoPes;

	private SelectOneMenu txtBasculaBruto;
	SelectItem[] selectBascula;
	private List<Bascula> bascula;

	private SelectOneMenu txtBasculaBrutoDes;
	SelectItem[] selectBasculaDes;
	private List<Bascula> basculaDes;

	private SelectOneMenu txtBasculaBrutoSer;
	SelectItem[] selectBasculaSer;
	private List<Bascula> basculaSer;

	private SelectOneMenu txtBasculaBrutoPes;
	private InputText txtTiquete;
	private InputText txtVehiTranspId;
	private Calendar txtFechaPesaje;
	private InputText txtTipoTransaccionPesaje;
	private static InputNumber txtPesarPesoBruto;
	private static InputNumber txtPesarPesoTara;
	private InputNumber txtPesarPesoNeto;

	private Double pesoBrutoDef;
	private Double pesoTaraDef;

	/*** Datos bascula ***/

	private CommandButton btnNewConductorPro;
	private CommandButton btnNewConductorDes;
	private CommandButton btnNewConductorSer;

	private CommandButton btnNewVehiculoPro;
	private CommandButton btnNewVehiculoDes;
	private CommandButton btnNewVehiculoSer;

	private CommandButton btnCalcularPro;
	private CommandButton btnCalcularDes;
	private CommandButton btnCalcularSer;

	private Calendar txtFechaEstadoVehiculoPro;
	private Calendar txtFechaEstadoVehiculoDes;
	private Calendar txtFechaEstadoVehiculoSer;

	private DatTransProd entity;
	private Trabajador entityTrabajador;
	private Equipo entityEquipo;

	private LogBascula entityLog;

	private double result;
	private boolean showDialog;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	@ManagedProperty(value = "#{TrabajadorLogic}")
	private ITrabajadorLogic trabajadorLogic;

	@ManagedProperty(value = "#{EquipoLogic}")
	private IEquipoLogic equipoLogic;

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

	private AutoComplete txtConductorId_Conductor;
	private AutoComplete txtConductorId_ConductorDes;
	private AutoComplete txtConductorId_ConductorSer;

	private InputText txtNuevoConductor;
	private InputText txtNuevoConductorDes;
	private InputText txtNuevoConductorSer;

	private AutoComplete txtVehiTranspId_VehiculosTransp;
	private AutoComplete txtVehiTranspId_VehiculosTranspDes;
	private AutoComplete txtVehiTranspId_VehiculosTranspSer;
	private AutoComplete txtVehiTranspId_VehiculosTranspCon;

	private InputText txtNuevoVehiculo;
	private InputText txtNuevoVehiculoDes;
	private InputText txtNuevoVehiculoSer;

	private SelectOneMenu txtFrtCosId_FrenteCos;
	SelectItem[] selectFrenteCos;
	private List<FrenteCos> frenteCos;

	private SelectOneMenu txtModalidadCosId_ModalidadCosecha;
	SelectItem[] selectModalidadCosecha;
	private List<ModalidadCosecha> modalidadCosecha;

	private SelectOneMenu txtTranspId_Transportadora;
	SelectItem[] selectTransportadora;
	private List<Transportadora> transportadora;

	private SelectOneMenu txtTranspId_TransportadoraDes;
	SelectItem[] selectTransportadoraDes;
	private List<Transportadora> transportadoraDes;

	private SelectOneMenu txtTranspId_TransportadoraSer;
	SelectItem[] selectTransportadoraSer;
	private List<Transportadora> transportadoraSer;

	SelectItem[] selectNivel2Edit;
	private List<Nivel2> nivel2Edit;

	SelectItem[] selectNivel4Edit;
	private List<Nivel4> nivel4Edit;

	SelectItem[] selectNivel2PlanEdit;
	private List<Nivel2> nivel2PlanEdit;

	SelectItem[] selectNivel4PlanEdit;
	private List<Nivel4> nivel4PlanEdit;

	/** Campos de pantalla de detalle de productos **/
	private List<DatTransProdDetDTO> dataDetTransProductos;
	private DatTransProdDetDTO selectedDatTransProdDet;
	private DatTransProdDet entityDatTransProdDet;

	private List<DatTransProdNivel4DTO> dataDetTransNivel4;
	private DatTransProdNivel4DTO selectedDatTransNivel4;
	private DatTransProdNivel4 entityDatTransProdNivel4;

	private InputText txtAreaCosechada;
	private InputText txtCantidadSolicitada;
	private InputText txtCantidadReal;
	private InputText txtValorUnitario;
	private InputText txtValorTotal;
	private SelectOneMenu txtCertificacionAceite;
	private SelectOneMenu txtCertificacionAceiteSer;

	private InputText txtRendimiento;
	private InputText txtCantidadKilosLiq;

	private CommandButton btnAgregarNivel4;
	private CommandButton btnAgregar;

	private InputText txtValorDeduccion;
	private InputText txtValorNeto;

	private SelectOneMenu txtClienteDet;
	SelectItem[] selectCliente;
	private List<PersEmpr> cliente;

	private SelectOneMenu txtClienteDetSer;
	SelectItem[] selectClienteSer;
	private List<PersEmpr> clienteSer;

	private SelectOneMenu txtUdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtCiudad;
	SelectItem[] selectCiudad;
	private List<Ciudad> ciudad;

	private SelectOneMenu txtCiudadSer;
	SelectItem[] selectCiudadSer;
	private List<Ciudad> ciudadSer;

	private SelectOneMenu txtProducto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtProductoSer;
	SelectItem[] selectProductoIdSer;
	private List<Producto> productoIdSer;

	private SelectOneMenu txtVariedadNivel4;
	SelectItem[] selectVariedadNivel4;
	private List<Variedad> variedadNivel4;

	private SelectOneMenu txtProductoCos;
	SelectItem[] selectProductoCosId;
	private List<Producto> productoCosId;

	private InputText txtNombreProductoCos;

	private SelectOneMenu txtEmpaque;
	SelectItem[] selectEmpaqueId;
	private List<Empaque> empaqueId;

	private InputText txtNombreProducto;
	private InputText txtNombreUdadMed;
	private InputText txtNombreCiudad;
	private InputText txtCodCliente;
	private InputText txtCodEmpaque;

	private InputText txtNombreNivel2;
	private InputText txtNombreNivel4;
	private InputText txtCodigoNivel4;
	private InputText txtNombreModCosecha;

	private SelectOneRadio txtFinCosecha;

	private InputText txtCantidadRacimos;
	private InputText txtPesoPromedio;
	private SelectOneMenu txtIndicadorDistribuccion;

	private Calendar txtFechaInicioCosecha;
	private Calendar txtFechaFinCosecha;

	private Date dateFechaInicial;
	private Date dateFechaFinal;

	/******* +BASCULA ***/
	private InputText txtBasculaPesoBruto;
	private InputText txtBasculaTara;
	private InputTextarea txtNumeroSellos;
	private InputText txtUsuarioPesoBruto;
	private InputText txtUsuarioPesoTara;
	private InputText txtVagon1;
	private InputText txtVagon2;
	private InputText txtVagon3;

	private InputText txtVagon1Des;
	private InputText txtVagon2Des;
	private InputText txtVagon3Des;

	private InputText txtVagon1Ser;
	private InputText txtVagon2Ser;
	private InputText txtVagon3Ser;

	private Calendar txtFechaPesoBruto;
	private Calendar txtFechaTara;
	private Calendar txtFechaPesoNeto;

	private Calendar txtFechaEntrada;
	private Calendar txtFechaSalida;
	private InputNumber txtPesoBruto;
	private InputText txtPesoNeto;
	private InputNumber txtPesoTara;

	private Calendar txtFechaEntradaDes;
	private Calendar txtFechaSalidaDes;
	private InputNumber txtPesoBrutoDes;
	private InputText txtPesoNetoDes;
	private InputNumber txtPesoTaraDes;

	private Calendar txtFechaEntradaSer;
	private Calendar txtFechaSalidaSer;
	private InputNumber txtPesoBrutoSer;
	private InputText txtPesoNetoSer;
	private InputNumber txtPesoTaraSer;

	private SelectOneMenu txtClienteNivel4;
	SelectItem[] selectClienteNivel4;
	private List<PersEmpr> clienteNivel4;

	/*** ANALISIS DE LABORATORIO ***/
	private InputTextarea txtObservacionAnalisis;
	private InputText txtVariable1;
	private InputText txtVariable2;
	
	private InputText txtVariable4;
	private Spinner txtVariable5;
	private Spinner txtVariable6;
	private InputText txtVariable7;
	private InputText txtVariable8;
	private InputText txtVariable9;
	private InputText txtVariable10;
	private  InputText txtVariableTexto1;

	/**************** CONSULTA TIQUETES DE BASCULA YA CREADOS ******/
	private List<TiquetesBasculaDTO> data2;
	private List<TiquetesBasculaImprimirProdDTO> data3;
	private List<TiquetesBasculaImprimirDespachosDTO> data4;
	private List<TiquetesBasculaDTO> data5;

	/************************** CONSULTA DE TIQUETES *****/
	private List<String> selectedEquipo;
	private InputText equipos;
	private InputText equipos2;
	private Calendar txtFechaInicialConsulta;
	private Calendar txtFechaFinalConsulta;
	private SelectOneMenu selectedTipoTransaccion;
	private SelectOneMenu selectedEstadoEquipo;
	private SelectOneMenu selectedEstadoTiquete;
	private InputText selectedTiquete;
	private List<DatTransProd> tiquetes;

	Long consecutivoT = null;

	private int activeTapIndex = 0;

	private InputText txtSello1;
	private InputText txtSello2;
	private InputText txtSello3;
	private InputText txtSello4;
	private InputText txtSello5;

	private InputText txtSello6;
	private InputText txtSello7;
	private InputText txtSello8;
	private InputText txtSello9;
	private InputText txtSello10;

	/**********************
	 * MANO DE OBRA******
	 ******/

	private List<DatTransProdTrabajadoresDTO> dataPlanillaDet;
	private DatTransProdTrabajadoresDTO selectedDatPlanillaDet;
	private DatTransProdTrabajadores entityDatTransProdTrabajadores;

	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel1IdMo;
	SelectItem[] selectNivel1Mo;
	private List<Nivel1> nivel1Mo;

	private SelectOneMenu txtNivel2IdMo;
	SelectItem[] selectNivel2Mo;
	private List<Nivel2> nivel2Mo;

	private SelectOneMenu txtNivel3IdMo;
	SelectItem[] selectNivel3Mo;
	private List<Nivel3> nivel3Mo;

	private SelectOneMenu txtNivel4IdMo;
	SelectItem[] selectNivel4Mo;
	private List<Nivel4> nivel4Mo;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtUdadMedPago;
	SelectItem[] selectUdadMedPago;
	private List<UdadMed> udadMedPago;

	private InputText txtCodTrabajadorNomina;
	private InputText txtCodConceptoNomina;
	private InputText txtCodUmPagoNomina;
	private InputText txtNombreLabor;
	private InputText txtPesoPromedioMo;
	private InputText txtCantidadDescontar;
	private CommandButton btnAgregarNomina;
	private InputText txtNombreNivel2Mo;
	private InputText txtNombreNivel4Mo;
	private InputText txtValorUnitarioMo;
	private InputText txtCostoTotal;
	private InputText txtCantidadPago;
	/************************************************************/
	private String cambioTiquete = "";

	private HttpServletResponse response;
	private FacesContext context;
	private HttpServletRequest origRequest;
	private ServletContext servletContext;

	private boolean estadoGrabar = false;
	private Equipo selectedEquipos;
	
	private InputText txtTiquetePesoNeto;

	public DatTransProdBasculaView() {
		super();
	}

	public String action_new() throws Exception {
		action_clear();
		// limpiar_transacciones();
		selectedDatTransProd = null;
		selectedDatBasculaTiquete = null;
		setShowDialog(true);

		return "";
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public void itemSelect(ItemSelectEvent event) {

		setShowDialog(true);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String action_clear() {
		entity = null;
		selectedDatTransProd = null;
		selectedDatBasculaTiquete = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		/******************************************** mano de obra *********/
		if (txtVehiTranspId_VehiculosTransp != null) {
			txtVehiTranspId_VehiculosTransp.setValue(null);
			txtVehiTranspId_VehiculosTransp.setItemLabel(null);
			txtVehiTranspId_VehiculosTransp.setDisabled(false);
		}

		if (txtConductorId_Conductor != null) {
			txtConductorId_Conductor.setValue(null);
			txtConductorId_Conductor.setItemLabel(null);
			txtConductorId_Conductor.setDisabled(false);
		}

		if (txtVehiTranspId_VehiculosTranspDes != null) {
			txtVehiTranspId_VehiculosTranspDes.setValue(null);
			txtVehiTranspId_VehiculosTranspDes.setItemLabel(null);
			txtVehiTranspId_VehiculosTranspDes.setDisabled(false);
		}

		if (txtConductorId_ConductorDes != null) {
			txtConductorId_ConductorDes.setValue(null);
			txtConductorId_ConductorDes.setItemLabel(null);
			txtConductorId_ConductorDes.setDisabled(false);
		}

		if (txtVehiTranspId_VehiculosTranspSer != null) {
			txtVehiTranspId_VehiculosTranspSer.setValue(null);
			txtVehiTranspId_VehiculosTranspSer.setItemLabel(null);
			txtVehiTranspId_VehiculosTranspSer.setDisabled(false);
		}

		if (txtConductorId_ConductorSer != null) {
			txtConductorId_ConductorSer.setValue(null);
			txtConductorId_ConductorSer.setItemLabel(null);
			txtConductorId_ConductorSer.setDisabled(false);
		}

		if (txtCodConceptoNomina != null) {
			txtCodConceptoNomina.setValue(null);
			txtCodConceptoNomina.setDisabled(true);
		}

		if (txtCodUmPagoNomina != null) {
			txtCodUmPagoNomina.setValue(null);
			txtCodUmPagoNomina.setDisabled(true);
		}

		if (txtCodTrabajadorNomina != null) {
			txtCodTrabajadorNomina.setValue(null);
			txtCodTrabajadorNomina.setDisabled(true);
		}

		if (txtBasculaBruto != null) {
			txtBasculaBruto.setValue(null);
			txtBasculaBruto.setDisabled(false);
		}

		if (txtTipoPeso != null) {
			txtTipoPeso.setValue(null);
			txtTipoPeso.setDisabled(false);
		}

		if (txtBasculaBrutoDes != null) {
			txtBasculaBrutoDes.setValue(null);
			txtBasculaBrutoDes.setDisabled(false);
		}

		if (txtBasculaBrutoSer != null) {
			txtBasculaBrutoSer.setValue(null);
			txtBasculaBrutoSer.setDisabled(false);
		}

		if (btnAgregarNomina != null) {
			btnAgregarNomina.setDisabled(false);
		}

		if (dataPlanillaDet != null) {
			dataPlanillaDet = null;
		}

		if (txtCantidadPago != null) {
			txtCantidadPago.setValue(0);
			txtCantidadPago.setDisabled(false);
		}

		if (txtPesoBrutoPesaje != null) {
			txtPesoBrutoPesaje.setReadonly(true);
			txtPesoBrutoPesaje.setValue(0.0);
		}

		if (txtPesoBrutoPesajeDes != null) {
			txtPesoBrutoPesajeDes.setReadonly(true);
			txtPesoBrutoPesajeDes.setValue(0.0);
		}

		if (txtPesoBrutoPesajeSer != null) {
			txtPesoBrutoPesajeSer.setReadonly(true);
			txtPesoBrutoPesajeSer.setValue(0.0);
		}

		if (txtPesarPesoTara != null) {
			txtPesarPesoTara.setValue(0.0);
		}

		if (txtPesarPesoBruto != null) {
			txtPesarPesoBruto.setValue(0.0);
		}

		if (txtNivel1IdMo != null) {
			txtNivel1IdMo.setValue(null);
			txtNivel1IdMo.setDisabled(false);
		}

		if (txtNivel2IdMo != null) {
			txtNivel2IdMo.setValue(null);
			txtNivel2IdMo.setDisabled(false);
		}

		if (txtNivel3IdMo != null) {
			txtNivel3IdMo.setValue(null);
			txtNivel3IdMo.setDisabled(false);
		}

		if (txtNivel4IdMo != null) {
			txtNivel4IdMo.setValue(null);
			txtNivel4IdMo.setDisabled(false);
		}

		if (txtUdadMedPago != null) {
			txtUdadMedPago.setValue(null);
			txtUdadMedPago.setDisabled(false);
		}
		if (txtValorUnitarioMo != null) {
			txtValorUnitarioMo.setValue(0);
			txtValorUnitarioMo.setDisabled(false);
		}
		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(0);
			txtCostoTotal.setDisabled(false);
		}
		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtNombreNivel2Mo != null) {
			txtNombreNivel2Mo.setValue(null);
			txtNombreNivel2Mo.setDisabled(false);
		}

		if (txtNombreNivel4Mo != null) {
			txtNombreNivel4Mo.setValue(null);
			txtNombreNivel4Mo.setDisabled(false);
		}

		if (txtNombreLabor != null) {
			txtNombreLabor.setValue(null);
			txtNombreLabor.setDisabled(false);
		}

		if (txtPesoPromedioMo != null) {
			txtPesoPromedioMo.setValue(0.0);
			txtPesoPromedioMo.setDisabled(false);
		}

		if (txtCantidadDescontar != null) {
			txtCantidadDescontar.setValue(0.0);
			txtCantidadDescontar.setDisabled(false);
		}
		/***************************************************************/
		if (txtAnioFiscalNivel4 != null) {
			txtAnioFiscalNivel4.setValue(null);
			txtAnioFiscalNivel4.setDisabled(false);
		}

		if (txtCertificacionAceite != null) {
			txtCertificacionAceite.setValue(null);
			txtCertificacionAceite.setDisabled(false);
		}

		if (txtCodCliente != null) {
			txtCodCliente.setValue(null);
			txtCodCliente.setDisabled(false);
		}

		if (txtCodEmpaque != null) {
			txtCodEmpaque.setValue(null);
			txtCodEmpaque.setDisabled(false);
		}
		if (txtNombreCiudad != null) {
			txtNombreCiudad.setValue(null);
			txtNombreCiudad.setDisabled(false);
		}
		if (txtNombreProducto != null) {
			txtNombreProducto.setValue(null);
			txtNombreProducto.setDisabled(false);
		}
		/****************************/
		if (txtProductoCos != null) {
			txtProductoCos.setValue(null);
			txtProductoCos.setDisabled(false);
		}
		if (txtNombreProductoCos != null) {
			txtNombreProductoCos.setValue(null);
			txtNombreProductoCos.setDisabled(false);
		}
		/***************************/
		if (txtNombreUdadMed != null) {
			txtNombreUdadMed.setValue(null);
			txtNombreUdadMed.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (selectTipoTransaccion != null) {
			selectTipoTransaccion.setValue(null);
			selectTipoTransaccion.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtConsecutivoDes != null) {
			txtConsecutivoDes.setValue(null);
			txtConsecutivoDes.setDisabled(true);
		}

		if (txtConsecutivoSer != null) {
			txtConsecutivoSer.setValue(null);
			txtConsecutivoSer.setDisabled(true);
		}

		if (txtDestinoProduccion != null) {
			txtDestinoProduccion.setValue(null);
			txtDestinoProduccion.setDisabled(false);
		}

		if (txtDestinoProduccionDes != null) {
			txtDestinoProduccionDes.setValue(null);
			txtDestinoProduccionDes.setDisabled(false);
		}

		if (txtDestinoProduccionSer != null) {
			txtDestinoProduccionSer.setValue(null);
			txtDestinoProduccionSer.setDisabled(false);
		}

		if (txtEdadNivel4 != null) {
			txtEdadNivel4.setValue(null);
			txtEdadNivel4.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtEtapaNivel4 != null) {
			txtEtapaNivel4.setValue(null);
			txtEtapaNivel4.setDisabled(false);
		}

		if (txtFaseFenoNivel4 != null) {
			txtFaseFenoNivel4.setValue(null);
			txtFaseFenoNivel4.setDisabled(false);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
		}

		if (txtInfoAdicionalDes != null) {
			txtInfoAdicionalDes.setValue(null);
			txtInfoAdicionalDes.setDisabled(false);
		}

		if (txtInfoAdicionalSer != null) {
			txtInfoAdicionalSer.setValue(null);
			txtInfoAdicionalSer.setDisabled(false);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(false);
		}

		if (txtMobileId != null) {
			txtMobileId.setValue(null);
			txtMobileId.setDisabled(false);
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

		if (txtObservacionDes != null) {
			txtObservacionDes.setValue(null);
			txtObservacionDes.setDisabled(false);
		}

		if (txtObservacionSer != null) {
			txtObservacionSer.setValue(null);
			txtObservacionSer.setDisabled(false);
		}

		if (txtObservacion2 != null) {
			txtObservacion2.setValue(null);
			txtObservacion2.setDisabled(false);
		}

		if (txtObservacion2Des != null) {
			txtObservacion2Des.setValue(null);
			txtObservacion2.setDisabled(false);
		}

		if (txtObservacion3 != null) {
			txtObservacion3.setValue(null);
			txtObservacion3.setDisabled(true);
		}

		if (txtOrigen != null) {
			txtOrigen.setValue(null);
			txtOrigen.setDisabled(false);
		}

		if (txtNoDocumento != null) {
			txtNoDocumento.setValue(null);
			txtNoDocumento.setDisabled(false);
		}

		if (txtNoDocumentoDes != null) {
			txtNoDocumentoDes.setValue(null);
			txtNoDocumentoDes.setDisabled(false);
		}

		if (txtNoDocumentoSer != null) {
			txtNoDocumentoSer.setValue(null);
			txtNoDocumentoSer.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
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
			txtProveId_Proveedor.setDisabled(false);
		}

		if (txtTranspId_Transportadora != null) {
			txtTranspId_Transportadora.setValue(null);
			txtTranspId_Transportadora.setDisabled(false);
		}

		if (txtTranspId_TransportadoraDes != null) {
			txtTranspId_TransportadoraDes.setValue(null);
			txtTranspId_TransportadoraDes.setDisabled(false);
		}

		if (txtTranspId_TransportadoraSer != null) {
			txtTranspId_TransportadoraSer.setValue(null);
			txtTranspId_TransportadoraSer.setDisabled(false);
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
			txtFechaRegistro.setDisabled(true);
		}

		if (txtFechaRegistroDes != null) {
			Date date = new Date();
			txtFechaRegistroDes.setValue(date);
			txtFechaRegistroDes.setDisabled(true);
		}

		if (txtFechaRegistroSer != null) {
			Date date = new Date();
			txtFechaRegistroSer.setValue(date);
			txtFechaRegistroSer.setDisabled(true);
		}

		if (txtFechaEstadoVehiculoPro != null) {
			Date date = new Date();
			txtFechaEstadoVehiculoPro.setValue(date);
			txtFechaEstadoVehiculoPro.setDisabled(false);
		}

		if (txtFechaEstadoVehiculoDes != null) {
			Date date = new Date();
			txtFechaEstadoVehiculoDes.setValue(date);
			txtFechaEstadoVehiculoDes.setDisabled(false);
		}

		if (txtFechaEstadoVehiculoSer != null) {
			Date date = new Date();
			txtFechaEstadoVehiculoSer.setValue(date);
			txtFechaEstadoVehiculoSer.setDisabled(false);
		}

		if (txtDatTransProdId != null) {
			txtDatTransProdId.setValue(null);
			txtDatTransProdId.setDisabled(false);
		}

		/* Detalle de productos */

		if (txtAreaCosechada != null) {
			txtAreaCosechada.setValue(0);
			txtAreaCosechada.setDisabled(false);
		}

		if (txtCantidadSolicitada != null) {
			txtCantidadSolicitada.setValue(0);
			txtCantidadSolicitada.setDisabled(false);
		}

		if (txtRendimiento != null) {
			txtRendimiento.setValue(0);
			txtRendimiento.setDisabled(false);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(0);
			txtValorUnitario.setDisabled(false);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(0);
			txtValorTotal.setDisabled(false);
		}

		if (txtCantidadKilosLiq != null) {
			txtCantidadKilosLiq.setValue(0);
			txtCantidadKilosLiq.setDisabled(false);
		}

		if (txtClienteDet != null) {
			txtClienteDet.setValue(null);
			txtClienteDet.setDisabled(false);
		}
		
		if (txtClienteDetSer != null) {
			txtClienteDetSer.setValue(null);
			txtClienteDetSer.setDisabled(false);
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
		
		if (txtCiudadSer != null) {
			txtCiudadSer.setValue(null);
			txtCiudadSer.setDisabled(false);
		}

		if (txtProducto != null) {
			txtProducto.setValue(null);
			txtProducto.setDisabled(false);
		}

		if (txtProductoSer != null) {
			txtProductoSer.setValue(null);
			txtProductoSer.setDisabled(false);
		}
		
		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFinCosecha != null) {
			txtFinCosecha.setValue("No");
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

		if (txtFechaInicioCosecha != null) {
			txtFechaInicioCosecha.setValue(null);
			txtFechaInicioCosecha.setDisabled(false);
		}

		if (txtFechaFinCosecha != null) {
			txtFechaFinCosecha.setValue(null);
			txtFechaFinCosecha.setDisabled(false);
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

		if (btnNewConductorPro != null) {
			btnNewConductorPro.setDisabled(true);
		}

		if (btnNewConductorDes != null) {
			btnNewConductorDes.setDisabled(true);
		}

		if (btnNewConductorSer != null) {
			btnNewConductorSer.setDisabled(true);
		}
		
		if (btnCalcular != null) {
			btnCalcular.setDisabled(false);
		}

		if (btnCalcularPro != null) {
			btnCalcularPro.setDisabled(false);
		}

		if (btnCalcularDes != null) {
			btnCalcularDes.setDisabled(false);
		}

		if (btnCalcularSer != null) {
			btnCalcularSer.setDisabled(false);
		}

		if (btnNewVehiculoPro != null) {
			btnNewVehiculoPro.setDisabled(false);
		}

		if (btnNewVehiculoDes != null) {
			btnNewVehiculoDes.setDisabled(false);
		}

		if (btnNewVehiculoSer != null) {
			btnNewVehiculoSer.setDisabled(false);
		}

		if (dataDetTransProductos != null) {
			dataDetTransProductos = null;
		}
		if (dataDetTransNivel4 != null) {
			dataDetTransNivel4 = null;
		}

		if (txtValorDeduccion != null) {
			txtValorDeduccion.setValue(0.0);
			txtValorDeduccion.setDisabled(false);
		}

		if (txtValorNeto != null) {
			txtValorNeto.setValue(0.0);
			txtValorNeto.setDisabled(false);
		}

		/****** bascula ***/

		if (txtNumeroSellos != null) {
			txtNumeroSellos.setValue(null);
			txtNumeroSellos.setDisabled(false);
		}

		if (txtObservacionAnalisis != null) {
			txtObservacionAnalisis.setValue(null);
			txtObservacionAnalisis.setDisabled(false);
		}

		if (txtPesoBruto != null) {
			txtPesoBruto.setValue(0.0);
			txtPesoBruto.setDisabled(false);
		}

		if (txtPesoNeto != null) {
			txtPesoNeto.setValue(0.0);
			txtPesoNeto.setDisabled(true);
		}

		if (txtPesoTara != null) {
			txtPesoTara.setValue(0.0);
			txtPesoTara.setDisabled(false);
		}

		if (txtVagon1 != null) {
			txtVagon1.setValue(null);
			txtVagon1.setDisabled(false);
		}

		if (txtVagon2 != null) {
			txtVagon2.setValue(null);
			txtVagon2.setDisabled(false);
		}

		if (txtVagon3 != null) {
			txtVagon3.setValue(null);
			txtVagon3.setDisabled(false);
		}

		if (txtVagon1Des != null) {
			txtVagon1Des.setValue(null);
			txtVagon1Des.setDisabled(false);
		}

		if (txtVagon2Des != null) {
			txtVagon2Des.setValue(null);
			txtVagon2Des.setDisabled(false);
		}

		if (txtVagon3Des != null) {
			txtVagon3Des.setValue(null);
			txtVagon3Des.setDisabled(false);
		}

		if (txtVagon1Ser != null) {
			txtVagon1Ser.setValue(null);
			txtVagon1Ser.setDisabled(false);
		}

		if (txtVagon2Ser != null) {
			txtVagon2Ser.setValue(null);
			txtVagon2Ser.setDisabled(false);
		}

		if (txtVagon3Ser != null) {
			txtVagon3Ser.setValue(null);
			txtVagon3Ser.setDisabled(false);
		}

		if (txtVariableTexto1 != null) {
			txtVariableTexto1.setValue(null);
			txtVariableTexto1.setDisabled(false);
		}
		if (txtVariable1 != null) {
			txtVariable1.setValue(null);
			txtVariable1.setDisabled(false);
		}

		if (txtVariable2 != null) {
			txtVariable2.setValue(null);
			txtVariable2.setDisabled(false);
		}

		if (txtVariableTexto1 != null) {
			txtVariableTexto1.setValue(null);
			txtVariableTexto1.setDisabled(false);
		}

		if (txtFechaEntrada != null) {
			txtFechaEntrada.setValue(null);
			txtFechaEntrada.setDisabled(false);
		}

		if (txtFechaPesoBruto != null) {
			txtFechaPesoBruto.setValue(null);
			txtFechaPesoBruto.setDisabled(false);
		}

		if (txtFechaPesoNeto != null) {
			txtFechaPesoNeto.setValue(null);
			txtFechaPesoNeto.setDisabled(false);
		}

		if (txtFechaSalida != null) {
			txtFechaSalida.setValue(null);
			txtFechaSalida.setDisabled(false);
		}

		if (txtFechaTara != null) {
			txtFechaTara.setValue(null);
			txtFechaTara.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtUsuarioPesoBruto != null) {
			txtUsuarioPesoBruto.setValue(null);
			txtUsuarioPesoBruto.setDisabled(false);
		}

		if (txtUsuarioPesoTara != null) {
			txtUsuarioPesoTara.setValue(null);
			txtUsuarioPesoTara.setDisabled(false);
		}

		if (txtVariable4 != null) {
			txtVariable4.setValue(null);
			txtVariable4.setDisabled(false);
		}

		if (txtVariable5 != null) {
			txtVariable5.setValue(null);
			txtVariable5.setDisabled(false);
		}

		if (txtVariable6 != null) {
			txtVariable6.setValue(null);
			txtVariable6.setDisabled(false);
		}

		if (txtVariable7 != null) {
			txtVariable7.setValue(null);
			txtVariable7.setDisabled(false);
		}

		if (txtVariable8 != null) {
			txtVariable8.setValue(null);
			txtVariable8.setDisabled(false);
		}

		if (txtVariable9 != null) {
			txtVariable9.setValue(null);
			txtVariable9.setDisabled(false);
		}

		if (txtVariable10 != null) {
			txtVariable10.setValue(null);
			txtVariable10.setDisabled(false);
		}

		if (txtSello1 != null) {
			txtSello1.setValue(null);
			txtSello1.setDisabled(true);
		}

		if (txtSello2 != null) {
			txtSello2.setValue(null);
			txtSello2.setDisabled(true);
		}

		if (txtSello3 != null) {
			txtSello3.setValue(null);
			txtSello3.setDisabled(true);
		}

		if (txtSello4 != null) {
			txtSello4.setValue(null);
			txtSello4.setDisabled(true);
		}

		if (txtSello5 != null) {
			txtSello5.setValue(null);
			txtSello5.setDisabled(true);
		}

		if (txtSello6 != null) {
			txtSello6.setValue(null);
			txtSello6.setDisabled(true);
		}

		if (txtSello7 != null) {
			txtSello7.setValue(null);
			txtSello7.setDisabled(true);
		}

		if (txtSello8 != null) {
			txtSello8.setValue(null);
			txtSello8.setDisabled(true);
		}

		if (txtSello9 != null) {
			txtSello9.setValue(null);
			txtSello9.setDisabled(true);
		}

		if (txtSello10 != null) {
			txtSello10.setValue(null);
			txtSello10.setDisabled(true);
		}

		return "";
	}

	public String limpiar_transacciones() {

		if (txtTipoTransaccion != null) {
			txtTipoTransaccion.setValue(null);
			txtTipoTransaccion.setDisabled(false);
		}

		if (txtTipoTransaccionDes != null) {
			txtTipoTransaccionDes.setValue(null);
			txtTipoTransaccionDes.setDisabled(false);
		}

		if (txtTipoTransaccionSer != null) {
			txtTipoTransaccionSer.setValue(null);
			txtTipoTransaccionSer.setDisabled(false);
		}

		return "";
	}

	public String limpiar_vehiculoConductor() {

		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		/******************************************** mano de obra *********/
		if (txtVehiTranspId_VehiculosTransp != null) {
			txtVehiTranspId_VehiculosTransp.setValue(null);
			txtVehiTranspId_VehiculosTransp.setItemLabel(null);
			txtVehiTranspId_VehiculosTransp.setDisabled(false);
		}

		if (txtConductorId_Conductor != null) {
			txtConductorId_Conductor.setValue(null);
			txtConductorId_Conductor.setItemLabel(null);
			txtConductorId_Conductor.setDisabled(false);
		}

		if (txtVehiTranspId_VehiculosTranspDes != null) {
			txtVehiTranspId_VehiculosTranspDes.setValue(null);
			txtVehiTranspId_VehiculosTranspDes.setItemLabel(null);
			txtVehiTranspId_VehiculosTranspDes.setDisabled(false);
		}

		if (txtConductorId_ConductorDes != null) {
			txtConductorId_ConductorDes.setValue(null);
			txtConductorId_ConductorDes.setItemLabel(null);
			txtConductorId_ConductorDes.setDisabled(false);
		}

		if (txtVehiTranspId_VehiculosTranspSer != null) {
			txtVehiTranspId_VehiculosTranspSer.setValue(null);
			txtVehiTranspId_VehiculosTranspSer.setItemLabel(null);
			txtVehiTranspId_VehiculosTranspSer.setDisabled(false);
		}

		if (txtConductorId_ConductorSer != null) {
			txtConductorId_ConductorSer.setValue(null);
			txtConductorId_ConductorSer.setItemLabel(null);
			txtConductorId_ConductorSer.setDisabled(false);
		}

		return "";
	}

	public String limpiar_Conductor() {

		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		/******************************************** mano de obra *********/
		
		if (txtConductorId_Conductor != null) {
			txtConductorId_Conductor.setValue(null);
			txtConductorId_Conductor.setItemLabel(null);
			txtConductorId_Conductor.setDisabled(false);
		}

		

		if (txtConductorId_ConductorDes != null) {
			txtConductorId_ConductorDes.setValue(null);
			txtConductorId_ConductorDes.setItemLabel(null);
			txtConductorId_ConductorDes.setDisabled(false);
		}

		if (txtConductorId_ConductorSer != null) {
			txtConductorId_ConductorSer.setValue(null);
			txtConductorId_ConductorSer.setItemLabel(null);
			txtConductorId_ConductorSer.setDisabled(false);
		}
		
		if (txtNuevoConductor != null) {
			txtNuevoConductor.setValue(null);
			
			txtNuevoConductor.setDisabled(false);
		}

		if (txtNuevoConductorDes != null) {
			txtNuevoConductorDes.setValue(null);
			
			txtNuevoConductorDes.setDisabled(false);
		}

		if (txtNuevoConductorSer != null) {
			txtNuevoConductorSer.setValue(null);
			
			txtConductorId_ConductorSer.setDisabled(false);
		}

		return "";
	}

	public String limpiar_peso() {
		entity = null;
		selectedDatTransProd = null;
		selectedDatBasculaTiquete = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		if (txtPesoBrutoPesaje != null) {
			txtPesoBrutoPesaje.setReadonly(true);
			txtPesoBrutoPesaje.setValue(0.0);
		}

		if (txtPesoBrutoPesajeDes != null) {
			txtPesoBrutoPesajeDes.setReadonly(true);
			txtPesoBrutoPesajeDes.setValue(0.0);
		}

		if (txtPesoBrutoPesajeSer != null) {
			txtPesoBrutoPesajeSer.setReadonly(true);
			txtPesoBrutoPesajeSer.setValue(0.0);
		}

		if (txtPesarPesoTara != null) {
			txtPesarPesoTara.setValue(0.0);
		}

		if (txtPesarPesoBruto != null) {
			txtPesarPesoBruto.setValue(0.0);
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

	public void listener_calcularValorNeto() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorFactura = FacesUtils.checkDouble(txtValorTotal);
		Double valorDeduccion = FacesUtils.checkDouble(txtValorDeduccion);

		if (valorFactura != null && valorDeduccion != null) {
			result = (valorFactura - valorDeduccion);
			String format = decimalFormat.format(result);
			txtValorNeto.setValue(format);
		} else {
			result = 0;
			txtValorNeto.setValue(result);
		}

	}

	public String setProduccion() {

		txtTipoTransaccion.setValue("Produccion");
		txtNuevoConductor.setStyle("visibility:hidden");
		txtTipoTransaccionSer.setValue("No");
		txtTipoTransaccionDes.setValue("No");

		return "";
	}

	public String setDespachos() {

		txtTipoTransaccionDes.setValue("Despachos");
		txtNuevoConductorDes.setStyle("visibility:hidden");
		txtTipoTransaccionSer.setValue("No");
		txtTipoTransaccion.setValue("No");

		return "";
	}

	public String setServicios() {

		txtTipoTransaccionSer.setValue("Servicios");
		txtNuevoConductorSer.setStyle("visibility:hidden");
		txtTipoTransaccion.setValue("No");
		txtTipoTransaccionDes.setValue("No");

		return "";
	}

	public void listener_calcularCostoTotal() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
		Double cantidadReal = FacesUtils.checkDouble(txtCantidadSolicitada);

		if (valorUnitario != null && cantidadReal != null) {
			result = (valorUnitario * cantidadReal);
			String format = decimalFormat.format(result);
			txtValorTotal.setValue(format);
		} else {
			result = 0;
			txtValorTotal.setValue(result);
		}

	}
	
	
	public List<Equipo> completarEquipos(String query) throws Exception {
		List<Equipo> allEquipos= equipoLogic.getEquipo();
		List<Equipo> filteredEquipos = new ArrayList<Equipo>();

		for (int i = 0; i < allEquipos.size(); i++) {
			Equipo equipo = allEquipos.get(i);

			if (Character.isLowerCase(query.charAt(0))) {
				if (equipo.getCodigo().toLowerCase().contains(query)) {
					filteredEquipos.add(equipo);
				}
			} else {

				if (equipo.getCodigo().toUpperCase().contains(query)) {
					filteredEquipos.add(equipo);
				}

			}
		}

		return filteredEquipos;
	}


	public List<Trabajador> completarTrabajadores(String query) throws Exception {
		List<Trabajador> allThemes = trabajadorLogic.getTrabajador();
		List<Trabajador> filteredThemes = new ArrayList<Trabajador>();

		String descripcion = "";

		for (int i = 0; i < allThemes.size(); i++) {
			Trabajador trabajador = allThemes.get(i);

			if (Character.isLowerCase(query.charAt(0))) {

				descripcion = trabajador.getNombre().toLowerCase();

			} else {

				descripcion = trabajador.getNombre().toUpperCase();
			}

			if (descripcion.contains(query)) {
				filteredThemes.add(trabajador);
			}
		}

		return filteredThemes;
	}

	public List<DatTransProdDetDTO> getDataDetTransProductos() {

		if (dataDetTransProductos == null || dataDetTransProductos.size() == 0) {
			return null;
		} else {
			return dataDetTransProductos;
		}

	}

	public void habilitarSellos() throws Exception {

		Long productoId = FacesUtils.checkLong(txtProducto);

		Producto producto = businessDelegatorView.getProducto(productoId);
		
		if (producto.getRequiereSellos() !=null){
		
		String requiereSellos = producto.getRequiereSellos();

			
		if (requiereSellos.equals("Si")) {

			txtSello1.setDisabled(false);
			txtSello2.setDisabled(false);
			txtSello3.setDisabled(false);
			txtSello4.setDisabled(false);
			txtSello5.setDisabled(false);
			txtSello6.setDisabled(false);
			txtSello7.setDisabled(false);
			txtSello8.setDisabled(false);
			txtSello9.setDisabled(false);
			txtSello10.setDisabled(false);
			txtObservacion3.setDisabled(false);

		} else {

			txtSello1.setDisabled(true);
			txtSello2.setDisabled(true);
			txtSello3.setDisabled(true);
			txtSello4.setDisabled(true);
			txtSello5.setDisabled(true);
			txtSello6.setDisabled(true);
			txtSello7.setDisabled(true);
			txtSello8.setDisabled(true);
			txtSello9.setDisabled(true);
			txtSello10.setDisabled(true);
			txtObservacion3.setDisabled(true);
		}
		}
	}

	public void action_agregarProductos() throws Exception {

		SelectOneMenu productoVista = null;
		SelectOneMenu clienteVista = null;
		SelectOneMenu ciudadVista = null;
		String certificacionAceite = null;

		if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

			productoVista = txtProducto;
			clienteVista = txtClienteDet;
			ciudadVista = txtCiudad;
			
			if (txtCertificacionAceite.getValue() != null) {
			
				certificacionAceite = FacesUtils.checkString(txtCertificacionAceite);
			
			} else {
				
				certificacionAceite = "N/A";
			}

		} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

			productoVista = txtProductoSer;
			clienteVista = txtClienteDetSer;
			ciudadVista = txtCiudadSer;
			certificacionAceite = "N/A";
		}

		Long productoId = Long.parseLong(productoVista.getValue().toString());
		Producto producto = businessDelegatorView.getProducto(productoId);

		Long clienteDet = Long.parseLong(clienteVista.getValue().toString());
		PersEmpr cliente = businessDelegatorView.getPersEmpr(clienteDet);
		
		Long ciudadId = null;
		
		if (ciudadVista.getValue() != null) {
		
			ciudadId = Long.parseLong(ciudadVista.getValue().toString());			
		
		} else {
			
			ciudadId = (long) 152;
		}
		
		Ciudad ciudad = businessDelegatorView.getCiudad(ciudadId);

		String nombreCiudad = ciudad.getNombre();
		String nombreProducto = producto.getNombre();
		String nomCliente = cliente.getNombre();
		Double canSolicitada = 0.0;
		Double valFactura = 0.0;

		UdadMed udadMed = producto.getUdadMedByUdadMedProd();

		boolean existeProducto = false;

		if (dataDetTransProductos == null) {
			dataDetTransProductos = new ArrayList<DatTransProdDetDTO>();
		}

		if (dataDetTransProductos.size() > 0) {

			for (DatTransProdDetDTO d : dataDetTransProductos) {

				if (d.getClienteId_Cliente().getPersEmprId().longValue() == cliente.getPersEmprId().longValue()) {

					existeProducto = true;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
									"El cliente " + d.getClienteId_Cliente().getPersEmprId().longValue()
											+ " ya fue agregado a la lista, por favor seleccione otro. "));

					break;
				}
			}

		}

		if (existeProducto == false) {

			DatTransProdDetDTO datTransProdDetDTO = new DatTransProdDetDTO();

			datTransProdDetDTO.setProductoId_Producto(producto);
			datTransProdDetDTO.setClienteId_Cliente(cliente);
			datTransProdDetDTO.setCiudadId_Ciudad(ciudad);
			datTransProdDetDTO.setUdadMedId_UdadMed(udadMed);
			datTransProdDetDTO.setNombreCiudad(nombreCiudad);
			datTransProdDetDTO.setNombreProducto(nombreProducto);
			datTransProdDetDTO.setNombreCliente(nomCliente);
			datTransProdDetDTO.setCantidadReal(canSolicitada);
			datTransProdDetDTO.setValorTotal(valFactura);
			datTransProdDetDTO.setCertificacionAceite(certificacionAceite);

			dataDetTransProductos.add(datTransProdDetDTO);

		}

		ciudad = null;
		udadMed = null;
		nombreCiudad = null;
		producto = null;
		cliente = null;
		nombreProducto = null;
		nomCliente = null;
		canSolicitada = null;
		valFactura = null;
		certificacionAceite = null;
	}

	public List<DatTransProdNivel4DTO> getDataDetTransNivel4s() {

		if (dataDetTransNivel4 == null || dataDetTransNivel4.size() == 0) {
			return null;
		} else {
			return dataDetTransNivel4;
		}

	}

	public void action_agregarNivel4() throws Exception {

		Long productoId = Long.parseLong(txtProductoCos.getValue().toString());
		Producto producto = businessDelegatorView.getProducto(productoId);
		String nombreProd = producto.getNombre().toString();

		Long nivel2 = null;
		Nivel2 nivel2Id = null;
		String nombreNivel2 = "";
		if (txtNivel2Id.getValue() != null) {
			nivel2 = Long.parseLong(txtNivel2Id.getValue().toString());
			nivel2Id = businessDelegatorView.getNivel2(nivel2);
			nombreNivel2 = nivel2Id.getNombre();
		}

		PersEmpr proveedor = nivel2Id.getProveedor();

		boolean existeProducto = false;

		if (dataDetTransNivel4 == null) {
			dataDetTransNivel4 = new ArrayList<DatTransProdNivel4DTO>();
		}

		if (existeProducto == false) {

			DatTransProdNivel4DTO datTransProdNivel4DTO = new DatTransProdNivel4DTO();

			datTransProdNivel4DTO.setNombreProducto(nombreProd);
			datTransProdNivel4DTO.setProducto(producto);
			datTransProdNivel4DTO.setClienteId(proveedor);
			datTransProdNivel4DTO.setNivel2Id_Nivel2(nivel2Id);
			datTransProdNivel4DTO.setNombreNivel2(nombreNivel2);
			datTransProdNivel4DTO.setVariedNivel4(businessDelegatorView.getVariedad((long) 2));
			datTransProdNivel4DTO.setModalidadCosId(businessDelegatorView.getModalidadCosecha((long) 1));

			dataDetTransNivel4.add(datTransProdNivel4DTO);
		}

		proveedor = null;
		nombreProd = null;
		productoId = null;
		nivel2Id = null;
		nombreNivel2 = null;

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

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaProductoCos() {

		Long productoId = null;

		if (!txtProductoCos.getValue().equals("")) {
			productoId = Long.parseLong(txtProductoCos.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				txtNombreProductoCos.setValue(producto.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCiudadCliente() {

		Long clienteId = null;

		if (txtClienteDet.getValue() != null) {
			clienteId = Long.parseLong(txtClienteDet.getValue().toString());

			try {
				PersEmpr cliente = businessDelegatorView.getPersEmpr(clienteId);

				if (cliente.getCiudad() != null) {

					txtCiudad.setValue(cliente.getCiudad());

				}
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

	public String tipoPesaje() {

		String tipoPesaje = (String) txtTipoPesoPes.getValue();
		Date date = new Date();

		txtTipoPesoPes.setDisabled(true);
		txtBasculaBrutoPes.setDisabled(false);

		if (tipoPesaje.equals("2")) {
			
			txtFechaTara.setValue(date);
			txtPesarPesoBruto.setDisabled(true);
			

		} else {
			
			txtFechaPesoBruto.setValue(date);
			txtPesarPesoTara.setDisabled(true);
		}

		return "";
	}

	public String action_Pesar(ActionEvent evt) {
		selectedDatBasculaTiquete = (TiquetesBasculaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatTransProd"));
		try {

			Long datTransProdId = selectedDatBasculaTiquete.getDat_trans_prod_id().longValue();
			Object[] condicion = { "datTransProdId", true, datTransProdId, "=" };
			List<DatTransProd> lista = (datTransProdId != null)
					? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null)
					: null;

			limpiar_transacciones();

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtTiquete.setValue(entity.getConsecutivo());
				txtTiquete.setReadonly(true);

				Long equipoId = entity.getVehiculoId();
				Equipo equipo = businessDelegatorView.getEquipo(equipoId);

				txtVehiTranspId.setValue(equipo.getCodigo());
				txtVehiTranspId.setReadonly(true);
				
				txtFechaPesoBruto.setValue(entity.getFechaPesoBruto());
				txtFechaPesoBruto.setDisabled(true);
				
				txtFechaTara.setValue(entity.getFechaTara());
				txtFechaTara.setDisabled(true);

				Date date = new Date();

				txtFechaPesaje.setValue(date);
				txtFechaPesaje.setReadonlyInput(true);

				txtTipoTransaccionPesaje.setValue(entity.getTipoTransaccion());
				txtTipoTransaccionPesaje.setReadonly(true);

				txtPesarPesoNeto.setValue(0.0);

				if (entity.getPesoBruto() != null && entity.getPesoBruto() > 0) {
					
					if (entity.getFechaTara() == null) {
						
						txtFechaTara.setValue(date);
					}

					txtBasculaBrutoPes.setValue("1");
					txtBasculaBrutoPes.setDisabled(false);

					txtTipoPesoPes.setValue("2");
					txtTipoPesoPes.setDisabled(true);

					pesoBrutoDef = (entity.getPesoBruto());
					txtPesarPesoBruto.setValue(pesoBrutoDef);
					txtPesarPesoBruto.setReadonly(true);
					txtPesarPesoBruto.setDisabled(false);

					txtPesarPesoTara.setValue(0.0);
					txtPesarPesoTara.setReadonly(true);
					txtPesarPesoTara.setDisabled(false);

					listener_basculaActiva();

				} else if (entity.getPesoTara() != null && entity.getPesoTara() > 0) {
					
					if (entity.getFechaPesoBruto() == null) {
						
						txtFechaPesoBruto.setValue(date);
					}

					txtBasculaBrutoPes.setValue("1");
					txtBasculaBrutoPes.setDisabled(false);

					txtTipoPesoPes.setValue("1");
					txtTipoPesoPes.setDisabled(true);

					pesoTaraDef = (entity.getPesoTara());
					txtPesarPesoTara.setValue(pesoTaraDef);
					txtPesarPesoTara.setReadonly(true);
					txtPesarPesoTara.setDisabled(false);

					txtPesarPesoBruto.setValue(0.0);
					txtPesarPesoBruto.setReadonly(true);
					txtPesarPesoBruto.setDisabled(false);

					listener_basculaActiva();

				} else if (entity.getPesoBruto() == 0.0 && entity.getPesoTara() == 0.0) {
					
					if (entity.getTipoTransaccion() != null && entity.getTipoTransaccion().equals("Produccion")) {
						if (entity.getFechaPesoBruto() == null) {
							
							txtFechaPesoBruto.setValue(date);
						}

							txtBasculaBrutoPes.setValue("1");
							txtBasculaBrutoPes.setDisabled(false);
	
							txtTipoPesoPes.setValue("1");
							txtTipoPesoPes.setDisabled(true);
	
							pesoTaraDef = (entity.getPesoTara());
							txtPesarPesoTara.setValue(pesoTaraDef);
							txtPesarPesoTara.setReadonly(true);
							txtPesarPesoTara.setDisabled(false);
	
							txtPesarPesoBruto.setValue(0.0);
							txtPesarPesoBruto.setReadonly(true);
							txtPesarPesoBruto.setDisabled(false);
	
							listener_basculaActiva();
						
						}
					
						if (entity.getTipoTransaccion() != null && entity.getTipoTransaccion().equals("Despachos")) {
							
							if (entity.getFechaTara() == null) {
								
								txtFechaTara.setValue(date);
							}

							txtBasculaBrutoPes.setValue("1");
							txtBasculaBrutoPes.setDisabled(false);

							txtTipoPesoPes.setValue("2");
							txtTipoPesoPes.setDisabled(true);

							pesoBrutoDef = (entity.getPesoBruto());
							txtPesarPesoBruto.setValue(pesoBrutoDef);
							txtPesarPesoBruto.setReadonly(true);
							txtPesarPesoBruto.setDisabled(false);

							txtPesarPesoTara.setValue(0.0);
							txtPesarPesoTara.setReadonly(true);
							txtPesarPesoTara.setDisabled(false);

							listener_basculaActiva();
						}
						 if (entity.getTipoTransaccion() != null && entity.getTipoTransaccion().equals("Servicios")) {
							 
								txtBasculaBrutoPes.setValue(null);
								txtBasculaBrutoPes.setDisabled(true);

								txtTipoPesoPes.setValue(null);
								txtTipoPesoPes.setDisabled(false);

								txtPesarPesoTara.setValue(0.0);
								txtPesarPesoTara.setReadonly(true);
								txtPesarPesoTara.setDisabled(false);

								txtPesarPesoBruto.setValue(0.0);
								txtPesarPesoBruto.setReadonly(true);
								txtPesarPesoBruto.setDisabled(false);
								
								
						 }
					
				}

				btnSavePes.setDisabled(false);
				btnImprimir.setDisabled(true);
				btnCalcular.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_edit(ActionEvent evt) {
		selectedDatBasculaTiquete = (TiquetesBasculaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatBasculaTiquete"));

		try {
			Long datTransProdId = selectedDatBasculaTiquete.getDat_trans_prod_id().longValue();
			Object[] condicion = { "datTransProdId", true, datTransProdId, "=" };
			List<DatTransProd> lista = (datTransProdId != null)
					? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				String vagon1 = "";
				String vagon2 = "";
				String vagon3 = "";
				String sello1 = "";
				String sello2 = "";
				String sello3 = "";
				String sello4 = "";
				String sello5 = "";
				String acidez = "";
				String humedad = "";
				String impurezas = "";
				String temperatura ="";
				String observacion = "";
				String destinoProduccion = "";
				String conductor = "";
				String equipo = "";
				if (entity.getVagon1() != null) {
					vagon1 = entity.getVagon1().toString();
				}

				if (entity.getVagon2() != null) {
					vagon2 = entity.getVagon2().toString();
				}

				if (entity.getVagon3() != null) {
					vagon3 = entity.getVagon3().toString();
				}

				if (entity.getSello1() != null) {
					sello1 = entity.getSello1().toString();
				}

				if (entity.getSello2() != null) {
					sello2 = entity.getSello2().toString();
				}

				if (entity.getSello3() != null) {
					sello3 = entity.getSello3().toString();
				}

				if (entity.getSello4() != null) {
					sello4 = entity.getSello4().toString();
				}

				if (entity.getSello5() != null) {
					sello5 = entity.getSello5().toString();
				}

				if (entity.getVariable1() != null) {
					acidez = entity.getVariable1().toString();
				}

				if (entity.getVariable2() != null) {
					humedad = entity.getVariable2().toString();
				}

				if (entity.getVariableTexto1() != null) {
					impurezas = entity.getVariableTexto1().toString();
				}

				if (entity.getVariable4() != null) {
					temperatura = entity.getVariable4().toString();
				}
				
				if (entity.getObservacion() != null) {
					observacion = entity.getObservacion().toString();
				}

				if (entity.getDestinoProduccion() != null) {
					destinoProduccion = entity.getDestinoProduccion().toString();
				}

				if (entity.getConductor() != null) {
					Long conductorId = entity.getConductor();
					Trabajador trab = businessDelegatorView.getTrabajador(conductorId);
					conductor = trab.getNombre();
				}
				if (entity.getVehiculoId() != null) {
					Long vehiculoId = entity.getVehiculoId();
					Equipo equip = businessDelegatorView.getEquipo(vehiculoId);
					equipo = equip.getNombre();
				}

				cambioTiquete = "Valores iniciales: Tiquete: " + entity.getConsecutivo().toString()
						+ " TipoTransaccion: " + entity.getTipoTransaccion().toString() + " Fecha registro: "
						+ entity.getFechaRegistro().toString() + " Equipo: " + equipo + " Conductor: " + conductor +

						" Vagón 1: " + vagon1 + " Vagón 2: " + vagon2 + " Vagón 3: " + vagon3
						+ " Destino de producción: " + destinoProduccion +

						" Sellos: " + sello1 + "-" + sello2 + "-" + sello3 + "-" + sello4 + "-" + sello5 + " Acidez: "
						+ acidez + " Humedad: " + humedad + " Impurezas: " + impurezas +  " Temperatura: " + temperatura +" Observación: " + observacion;

				 datTransProdId = entity.getDatTransProdId();

				if (datTransProdId != null && datTransProdId > 0) {

					dataDetTransProductos = null;
					dataDetTransProductos = businessDelegatorView
							.getDataDetTransProductosByDatTransProdId(datTransProdId);

					dataDetTransNivel4 = null;
					dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(datTransProdId);

				}

				String tipoTransaccion = selectedDatBasculaTiquete.getTipo_transaccion();

				if (tipoTransaccion != null && tipoTransaccion.equals("Produccion")) {
					
					txtPesoBrutoPesaje.setValue(null);
					txtConsecutivo.setValue(entity.getConsecutivo());
					txtConsecutivo.setDisabled(true);
					txtVagon1.setValue(entity.getVagon1());
					txtVagon1.setDisabled(false);
					txtVagon2.setValue(entity.getVagon2());
					txtVagon2.setDisabled(false);
					txtVagon3.setValue(entity.getVagon3());
					txtVagon3.setDisabled(false);
					txtInfoAdicional.setValue(entity.getInfoAdicional());
					txtInfoAdicional.setDisabled(false);
					txtFechaRegistro.setValue(entity.getFechaRegistro());
					txtFechaRegistro.setDisabled(true);
					txtObservacion.setValue(entity.getObservacion());
					txtObservacion.setDisabled(false);
					txtNoDocumento.setValue(entity.getNoDocumento());
					txtNoDocumento.setDisabled(false);
					txtFechaEstadoVehiculoPro.setValue(entity.getFechaEstadoVehiculo());
					txtFechaEstadoVehiculoPro.setDisabled(false);
					txtPesoBrutoPesaje.setDisabled(true);
					txtBasculaBruto.setDisabled(true);
					btnCalcularPro.setDisabled(true);
					btnNewVehiculoPro.setDisabled(true);
					btnNewConductorPro.setDisabled(true);
					txtTipoTransaccionDes.setValue("No");
					txtTipoTransaccionSer.setValue("No");
					txtTipoTransaccion.setValue(entity.getTipoTransaccion());
					txtTipoTransaccion.setDisabled(true);
					txtTranspId_Transportadora.setValue(entity.getTransportadora());
					txtTranspId_Transportadora.setDisabled(false);
					txtDatTransProdId.setValue(entity.getDatTransProdId());
					txtDatTransProdId.setDisabled(true);
					
					if(dataDetTransNivel4!=null && dataDetTransNivel4.size()>0) {

						txtProductoCos.setDisabled(true);
						txtNivel2Id.setDisabled(true);
					}else {
						txtProductoCos.setDisabled(false);
						txtNivel2Id.setDisabled(false);
					}
					
					if (entity.getPesoBruto() != null && entity.getPesoBruto() > 0) {
						
						txtPesoBrutoPesaje.setValue(entity.getPesoBruto());
					}

					Long trabId = entity.getConductor();
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);

					txtConductorId_Conductor.setValue(trabajador);
					txtConductorId_Conductor.setDisabled(false);

					Long equipoId = entity.getVehiculoId();
					Equipo equipo1 = businessDelegatorView.getEquipo(equipoId);

					txtVehiTranspId_VehiculosTransp.setValue(equipo1);
					txtVehiTranspId_VehiculosTransp.setDisabled(false);
					
					PrimeFaces contextDialog = PrimeFaces.current();					
					contextDialog.ajax().update("dialogDatTransProd");

				} else if (tipoTransaccion != null && tipoTransaccion.equals("Despachos - Otros movimientos")) {
					
					txtPesoBrutoPesajeDes.setValue(null);
					txtConsecutivoDes.setValue(entity.getConsecutivo());
					txtConsecutivoDes.setDisabled(true);
					txtVagon1Des.setValue(entity.getVagon1());
					txtVagon1Des.setDisabled(false);
					txtVagon2Des.setValue(entity.getVagon2());
					txtVagon2Des.setDisabled(false);
					txtVagon3Des.setValue(entity.getVagon3());
					txtVagon3Des.setDisabled(false);
					txtInfoAdicionalDes.setValue(entity.getInfoAdicional());
					txtInfoAdicionalDes.setDisabled(false);
					txtFechaRegistroDes.setValue(entity.getFechaRegistro());
					txtFechaRegistroDes.setDisabled(true);
					txtObservacionDes.setValue(entity.getObservacion());
					txtObservacionDes.setDisabled(false);
					txtObservacion2Des.setValue(entity.getObservacion2());
					txtObservacion2Des.setDisabled(false);
					txtNoDocumentoDes.setValue(entity.getNoDocumento());
					txtNoDocumentoDes.setDisabled(false);
					txtFechaEstadoVehiculoDes.setValue(entity.getFechaEstadoVehiculo());
					txtFechaEstadoVehiculoDes.setDisabled(false);
					txtPesoBrutoPesajeDes.setDisabled(true);
					txtBasculaBrutoDes.setDisabled(true);
					btnCalcularDes.setDisabled(true);
					btnNewVehiculoDes.setDisabled(true);
					btnNewConductorDes.setDisabled(true);
					txtTipoTransaccion.setValue("No");
					txtTipoTransaccionSer.setValue("No");
					txtTipoTransaccionDes.setValue(entity.getTipoTransaccion());
					txtTipoTransaccionDes.setDisabled(true);
					txtTranspId_TransportadoraDes.setValue(entity.getTransportadora());
					txtTranspId_TransportadoraDes.setDisabled(false);
					txtDatTransProdIdDes.setValue(entity.getDatTransProdId());
					txtDatTransProdIdDes.setDisabled(true);
					
					if (entity.getPesoTara() != null && entity.getPesoTara() > 0) {
	
						txtPesoBrutoPesajeDes.setValue(entity.getPesoTara());
					}

					Long trabId = entity.getConductor();
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);

					txtConductorId_ConductorDes.setValue(trabajador);
					txtConductorId_ConductorDes.setDisabled(false);

					Long equipoId = entity.getVehiculoId();
					Equipo equipo1 = businessDelegatorView.getEquipo(equipoId);

					txtVehiTranspId_VehiculosTranspDes.setValue(equipo1);
					txtVehiTranspId_VehiculosTranspDes.setDisabled(false);
					
					txtSello1.setDisabled(true);
					txtSello2.setDisabled(true);
					txtSello3.setDisabled(true);
					txtSello4.setDisabled(true);
					txtSello5.setDisabled(true);
					txtSello6.setDisabled(true);
					txtSello7.setDisabled(true);
					txtSello8.setDisabled(true);
					txtSello9.setDisabled(true);
					txtSello10.setDisabled(true);
					txtObservacion3.setDisabled(true);	
					
					if(dataDetTransProductos!=null && dataDetTransProductos.size()>0) {
						
					
						String requiereSellos = "";
						DatTransProdDetDTO dataProd = dataDetTransProductos.get(0);					
						if(dataProd.getProductoId_Producto().getRequiereSellos() !=null) {
							requiereSellos =  dataProd.getProductoId_Producto().getRequiereSellos();
							if (requiereSellos.equals("Si")) {
								
								txtSello1.setDisabled(false);
								txtSello2.setDisabled(false);
								txtSello3.setDisabled(false);
								txtSello4.setDisabled(false);
								txtSello5.setDisabled(false);
								txtSello6.setDisabled(false);
								txtSello7.setDisabled(false);
								txtSello8.setDisabled(false);
								txtSello9.setDisabled(false);
								txtSello10.setDisabled(false);
								txtObservacion3.setDisabled(false);	
								
							}	
							
						}
						
						txtClienteDet.setDisabled(true);
						txtCertificacionAceite.setDisabled(true);
						txtProducto.setDisabled(true);
						txtCiudad.setDisabled(true);
					}else{
						txtClienteDet.setDisabled(false);
						txtCertificacionAceite.setDisabled(false);
						txtProducto.setDisabled(false);
						txtCiudad.setDisabled(false);
					}

					txtSello1.setValue(entity.getSello1());
					txtSello2.setValue(entity.getSello2());
					txtSello3.setValue(entity.getSello3());
					txtSello4.setValue(entity.getSello4());
					txtSello5.setValue(entity.getSello5());
					txtSello6.setValue(entity.getSello6());
					txtSello7.setValue(entity.getSello7());
					txtSello8.setValue(entity.getSello8());
					txtSello9.setValue(entity.getSello9());
					txtSello10.setValue(entity.getSello10());
					txtVariable1.setValue(entity.getVariable1());
					txtVariable2.setValue(entity.getVariable2());
					txtVariableTexto1.setValue(entity.getVariableTexto1());
					txtVariable4.setValue(entity.getVariable4());
					txtObservacion3.setValue(entity.getObservacion3());
					txtDestinoProduccionDes.setValue(entity.getDestinoProduccion());
					txtObservacionAnalisis.setValue(entity.getObservacionAnalisis());
					
					PrimeFaces contextDialog = PrimeFaces.current();
					contextDialog.ajax().update("dialogDatTransProd2");

				} else if (tipoTransaccion != null && tipoTransaccion.equals("Servicios")) {
					
					txtPesoBrutoPesajeSer.setValue(null);
					txtConsecutivoSer.setValue(entity.getConsecutivo());
					txtConsecutivoSer.setDisabled(true);
					txtVagon1Ser.setValue(entity.getVagon1());
					txtVagon1Ser.setDisabled(false);
					txtVagon2Ser.setValue(entity.getVagon2());
					txtVagon2Ser.setDisabled(false);
					txtVagon3Ser.setValue(entity.getVagon3());
					txtVagon3Ser.setDisabled(false);
					txtInfoAdicionalSer.setValue(entity.getInfoAdicional());
					txtInfoAdicionalSer.setDisabled(false);
					txtFechaRegistroSer.setValue(entity.getFechaRegistro());
					txtFechaRegistroSer.setDisabled(true);
					txtObservacionSer.setValue(entity.getObservacion());
					txtObservacionSer.setDisabled(false);
					txtObservacion2.setValue(entity.getObservacion2());
					txtObservacion2.setDisabled(false);
					txtOrigen.setValue(entity.getOrigen());
					txtOrigen.setDisabled(false);
					txtNoDocumentoSer.setValue(entity.getNoDocumento());
					txtNoDocumentoSer.setDisabled(false);
					txtFechaEstadoVehiculoSer.setValue(entity.getFechaEstadoVehiculo());
					txtFechaEstadoVehiculoSer.setDisabled(false);
					txtPesoBrutoPesajeSer.setDisabled(true);
					txtBasculaBrutoSer.setDisabled(true);
					btnCalcularSer.setDisabled(true);
					txtTipoPeso.setDisabled(true);
					btnNewVehiculoSer.setDisabled(true);
					btnNewConductorSer.setDisabled(true);
					txtTipoTransaccionDes.setValue("No");
					txtTipoTransaccion.setValue("No");
					txtTipoTransaccionSer.setValue(entity.getTipoTransaccion());
					txtTipoTransaccionSer.setDisabled(true);
					txtTranspId_TransportadoraSer.setValue(entity.getTransportadora());
					txtTranspId_TransportadoraSer.setDisabled(false);
					txtDatTransProdIdSer.setValue(entity.getDatTransProdId());
					txtDatTransProdIdSer.setDisabled(true);
					
					if(dataDetTransProductos!=null && dataDetTransProductos.size()>0) {
						txtClienteDetSer.setDisabled(true);
						txtProductoSer.setDisabled(true);
						txtCiudadSer.setDisabled(true);
					}else {
						txtClienteDetSer.setDisabled(false);
						txtProductoSer.setDisabled(false);
						txtCiudadSer.setDisabled(false);
					}
					
					if (entity.getPesoTara() != null && entity.getPesoTara() > 0) {
						
						txtPesoBrutoPesajeSer.setValue(entity.getPesoTara());
						
					} else if (entity.getPesoBruto() != null && entity.getPesoBruto() > 0) {
						
						txtPesoBrutoPesajeSer.setValue(entity.getPesoBruto());
					}

					Long trabId = entity.getConductor();
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);

					txtConductorId_ConductorSer.setValue(trabajador);
					txtConductorId_ConductorSer.setDisabled(false);

					Long equipoId = entity.getVehiculoId();
					Equipo equipo1 = businessDelegatorView.getEquipo(equipoId);

					txtVehiTranspId_VehiculosTranspSer.setValue(equipo1);
					txtVehiTranspId_VehiculosTranspSer.setDisabled(false);

					txtDestinoProduccionSer.setValue(entity.getDestinoProduccion());
					
					PrimeFaces contextDialog = PrimeFaces.current();
					contextDialog.ajax().update("dialogDatTransProd3");
				}

				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_imprimir_tiquet(ActionEvent evt) throws Exception, Exception {

		selectedDatBasculaTiquete = (TiquetesBasculaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatBasculaTiquete"));

		if (selectedDatBasculaTiquete == null) {
			consecutivoT = (Long) txtTiquete.getValue();
		} else {
			consecutivoT = selectedDatBasculaTiquete.getConsecutivo().longValue();
		}

		Long compania = null;
		List<TiquetesBasculaImprimirProdDTO> data3 = null;

		Object[] condicion = { "consecutivo", true, consecutivoT, "=" };
		List<DatTransProd> lista = (consecutivoT != null)
				? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null)
				: null;

		if (lista != null && lista.size() > 0) {
			entity = lista.get(0);
			tipoTransaccion = entity.getTipoTransaccion();
		}

		compania = new Long(getCompaniaIdSession());
		data3 = businessDelegatorView.consultarTiqueteBasculaImprimirProd(compania, consecutivoT);

		if (data3 != null && data3.size() > 0) {

			action_abrirTiqueteBasculaPDF(consecutivoT, data3);

		} else {

			FacesUtils.addErrorMessage("No existe información para imprimir el tiquete de bascula");
		}
		entity = null;
		compania = null;
		tipoTransaccion = null;

		return "";
	}

	public void action_abrirTiqueteBasculaPDF(Long consecutivoT, List<TiquetesBasculaImprimirProdDTO> data3)
			throws Exception {

		this.servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();

		String filenImage = servletContext.getRealPath("") + File.separator + "images" + File.separator
				+ "Logo Pess.png";

		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/informes/jasperReport/tiqueteBascula.jasper");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JasperReport reporte = (JasperReport) JRLoader.loadObject(stream);

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numerotiquete", consecutivoT);
		parametros.put("image1", filenImage);

		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,
				new JRBeanCollectionDataSource(data3));

		JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

		response.setContentType("application/pdf");
		response.setContentLength(baos.size());
		response.setHeader("Content-disposition", "inline; filename=tiquete_" + consecutivoT + "_.pdf");
		response.getOutputStream().write(baos.toByteArray());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		context.responseComplete();

	}

	public String action_consultarConductorProd() throws Exception {

		txtVehiTranspId_VehiculosTranspDes.setValue(null);
		txtVehiTranspId_VehiculosTranspSer.setValue(null);

		String equipoId = (String) txtVehiTranspId_VehiculosTransp.getValue();

		try {

			Long equiId = Long.parseLong(equipoId);

			if (equiId != null) {

				Long trabId = businessDelegatorView.getEquipo(equiId).getTrabajador();

				if (trabId != null && trabId > 0) {

					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
					txtConductorId_Conductor.setValue(trabajador);

				} else {

					String codEquipo = businessDelegatorView.getEquipo(equiId).getCodigo();
					txtNuevoConductor.setValue("");

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Notificación!", "No existen conductores asociados al equipo " + codEquipo));
				}

			}

		} catch (Exception e) {

			txtConductorId_Conductor.setItemLabel(null);
		}

		return "";
	}

	public String action_consultarConductorDes() throws Exception {

		txtVehiTranspId_VehiculosTransp.setValue(null);
		txtVehiTranspId_VehiculosTranspSer.setValue(null);

		String equipoId = (String) txtVehiTranspId_VehiculosTranspDes.getValue();

		try {

			Long equiId = Long.parseLong(equipoId);

			if (equiId != null) {

				Long trabId = businessDelegatorView.getEquipo(equiId).getTrabajador();

				if (trabId != null && trabId > 0) {

					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
					txtConductorId_ConductorDes.setValue(trabajador);

				} else {

					String codEquipo = businessDelegatorView.getEquipo(equiId).getCodigo();
					txtNuevoConductorDes.setValue("");

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Notificación!", "No existen conductores asociados al equipo " + codEquipo));
				}

			}

		} catch (Exception e) {

			txtConductorId_ConductorDes.setItemLabel(null);
		}

		return "";
	}

	public String action_consultarConductorSer() throws Exception {

		txtVehiTranspId_VehiculosTranspDes.setValue(null);
		txtVehiTranspId_VehiculosTransp.setValue(null);

		String equipoId = (String) txtVehiTranspId_VehiculosTranspSer.getValue();

		try {

			Long equiId = Long.parseLong(equipoId);

			if (equiId != null) {

				Long trabId = businessDelegatorView.getEquipo(equiId).getTrabajador();

				if (trabId != null && trabId > 0) {

					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
					txtConductorId_ConductorSer.setValue(trabajador);

				} else {

					String codEquipo = businessDelegatorView.getEquipo(equiId).getCodigo();
					txtNuevoConductorSer.setValue("");

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Notificación!", "No existen conductores asociados al equipo " + codEquipo));
				}

			}

		} catch (Exception e) {

			txtConductorId_ConductorSer.setItemLabel(null);
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

	public void action_ConsultarTiqueteBascula() {
		try {
			Long compania1 = new Long(getCompaniaIdSession());
			Date fechaInicial = null;
			Date fechaFinal = null;
			String tipoMovimiento = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicialConsulta));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinalConsulta));

			String selectedTiquet = (FacesUtils.checkString(selectedTiquete));
			tipoMovimiento = "Todos";

			Long flagTipoTransaccion = 1L;
			Long flagEquipo = 1L;
			Long flagTiquet = 1L;
			Long flagEstadoTiquete = 1L;

			String vehiculoId = (FacesUtils.checkString(txtVehiTranspId_VehiculosTranspCon));
			String tiquetePesoNeto = (FacesUtils.checkString(txtTiquetePesoNeto));
			
			if (tiquetePesoNeto == null) {

				tiquetePesoNeto = "0";
			} 
			
			
			if (vehiculoId != null) {

				flagEquipo = 0L;

			} else {

				vehiculoId = "0";
			}

			if (selectedTiquet != null) {

				flagTiquet = 0L;

			} else {

				selectedTiquet = "0";
			}

			String tipoTransaccion = "0";
			if (selectedTipoTransaccion.getValue() != null) {
				if (selectedTipoTransaccion.getValue().equals("Produccion")
						|| selectedTipoTransaccion.getValue().equals("Despachos")
						|| selectedTipoTransaccion.getValue().equals("Servicios")) {
					tipoTransaccion = selectedTipoTransaccion.getValue().toString();
					flagTipoTransaccion = 0L;
				} else {
					tipoTransaccion = "0";
					flagTipoTransaccion = 1L;
				}
			}

			String estadoSeleccionado = "0";
			if (selectedEstadoTiquete.getValue() != null) {
				if (selectedEstadoTiquete.getValue().equals("A") || selectedEstadoTiquete.getValue().equals("I")) {
					estadoSeleccionado = selectedEstadoTiquete.getValue().toString();
					flagEstadoTiquete = 0L;
				} else {
					estadoSeleccionado = "0";
					flagEstadoTiquete = 1L;
				}
			}

			if (compania1 != null && fechaInicial != null && fechaFinal != null) {

				data2 = businessDelegator2View.consultarEstadoVehiculo(compania1, fechaInicial, fechaFinal,
						tipoMovimiento, tipoTransaccion, flagTipoTransaccion, vehiculoId, flagEquipo, flagEstadoTiquete,
						estadoSeleccionado, selectedTiquet, flagTiquet,tiquetePesoNeto);

			} else if (compania1 != null && fechaInicial == null && fechaFinal == null && selectedTiquet != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data2 = businessDelegator2View.consultarEstadoVehiculo(compania1, fechaInicial, fechaFinal,
						tipoMovimiento, tipoTransaccion, flagTipoTransaccion, vehiculoId, flagEquipo, flagEstadoTiquete,
						estadoSeleccionado, selectedTiquet, flagTiquet,tiquetePesoNeto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void action_ConsultarTiqueteBasculaCorreccion() {
		try {
			Long compania1 = new Long(getCompaniaIdSession());
			Date fechaInicial = null;
			Date fechaFinal = null;
			String tipoMovimiento = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicialConsulta));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinalConsulta));

			String selectedTiquet = (FacesUtils.checkString(selectedTiquete));
			tipoMovimiento = "Todos";

			Long flagTipoTransaccion = 1L;
			Long flagEquipo = 1L;
			Long flagTiquet = 1L;
			Long flagEstadoTiquete = 1L;

			String vehiculoId = (FacesUtils.checkString(txtVehiTranspId_VehiculosTranspCon));
			String tiquetePesoNeto =  FacesUtils.checkString(txtTiquetePesoNeto);
			if (vehiculoId != null) {

				flagEquipo = 0L;

			} else {

				vehiculoId = "0";
			}

			if (selectedTiquet != null) {

				flagTiquet = 0L;

			} else {

				selectedTiquet = "0";
			}

			
			if (tiquetePesoNeto == null) {

				tiquetePesoNeto = "0";
			} 
			
			String tipoTransaccion = "0";
			if (selectedTipoTransaccion.getValue() != null) {
				if (selectedTipoTransaccion.getValue().equals("Produccion")
						|| selectedTipoTransaccion.getValue().equals("Despachos")
						|| selectedTipoTransaccion.getValue().equals("Servicios")) {
					tipoTransaccion = selectedTipoTransaccion.getValue().toString();
					flagTipoTransaccion = 0L;
				} else {
					tipoTransaccion = "0";
					flagTipoTransaccion = 1L;
				}
			}

			String estadoSeleccionado = "0";
			if (selectedEstadoTiquete.getValue() != null) {
				if (selectedEstadoTiquete.getValue().equals("A") || selectedEstadoTiquete.getValue().equals("I")) {
					estadoSeleccionado = selectedEstadoTiquete.getValue().toString();
					flagEstadoTiquete = 0L;
				} else {
					estadoSeleccionado = "0";
					flagEstadoTiquete = 1L;
				}
			}

			if (compania1 != null && fechaInicial != null && fechaFinal != null) {

				data5 = businessDelegator2View.consultarEstadoVehiculoPr(compania1, fechaInicial, fechaFinal,
						tipoMovimiento, tipoTransaccion, flagTipoTransaccion, vehiculoId, flagEquipo, flagEstadoTiquete,
						estadoSeleccionado, selectedTiquet, flagTiquet, tiquetePesoNeto);

			} else if (compania1 != null && fechaInicial == null && fechaFinal == null && selectedTiquet != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data5 = businessDelegator2View.consultarEstadoVehiculoPr(compania1, fechaInicial, fechaFinal,
						tipoMovimiento, tipoTransaccion, flagTipoTransaccion, vehiculoId, flagEquipo, flagEstadoTiquete,
						estadoSeleccionado, selectedTiquet, flagTiquet,tiquetePesoNeto );

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	public String action_nuevoConductor() throws Exception {

		AutoComplete conductorId_Conductor = null;
		InputText nuevoConductor = null;
		CommandButton btnNewConductor = null;

		if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

			conductorId_Conductor = txtConductorId_Conductor;
			nuevoConductor = txtNuevoConductor;
			btnNewConductor = btnNewConductorPro;

		} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

			conductorId_Conductor = txtConductorId_ConductorDes;
			nuevoConductor = txtNuevoConductorDes;
			btnNewConductor = btnNewConductorDes;

		} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

			conductorId_Conductor = txtConductorId_ConductorSer;
			nuevoConductor = txtNuevoConductorSer;
			btnNewConductor = btnNewConductorSer;
		}

//		try {	
//			
//			Long comprobacion = (Long) conductorId_Conductor.getValue();			
			
			Date date = new Date();
			entityTrabajador = new Trabajador();

			if (conductorId_Conductor.getValue() != null && !conductorId_Conductor.getValue().equals("")) {	
				
				String codigo = (String) conductorId_Conductor.getValue();	
				String nombre = (String) nuevoConductor.getValue();
	
				entityTrabajador.setCodigo(codigo);
				entityTrabajador.setnIdentificacion(codigo);
				entityTrabajador.setPrimerNombre(nombre);
				entityTrabajador.setSegundoNombre(".");
				entityTrabajador.setPrimerApellido(".");
				entityTrabajador.setContratista(businessDelegatorView.getPersEmpr((long) 1));
				entityTrabajador.setEstado("A");
				entityTrabajador.setProfesion(businessDelegatorView.getProfesion((long) 13));
				entityTrabajador.setCompania((long) 1);
				entityTrabajador.setNombre(nombre);
				entityTrabajador.setOrigenDatos("Admin_Agricola");
				entityTrabajador.setFechaCreacion(date);
	
				Object[] condicion = { "codigo", true, codigo, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
	
				if (lista.size() == 0) {
					
					 try
					 {
						 	Double.parseDouble(codigo);
					   		businessDelegatorView.saveTrabajador(entityTrabajador, null, null);
							FacesUtils.addInfoMessage("El conductor con el codigo " + codigo + " ha sido creado exitosamente");
							btnNewConductor.setDisabled(true);
			
							Object[] condicion1 = { "codigo", true, codigo, "=", };
							List<Trabajador> lista1 = businessDelegatorView.findByCriteriaInTrabajador(condicion1, null, null);
			
							if (lista1.size() > 0) {
								Trabajador trabajador = lista1.get(0);
								conductorId_Conductor.setValue(trabajador);
							}
			
							nuevoConductor.setStyle("visibility:hidden");
							nuevoConductor.setValue("");
					 }
					 catch(NumberFormatException e)
					 {	 FacesUtils.addInfoMessage("Para crear un nuevo conductor debe introducir primero la cédula y luego el nombre ");
						 limpiar_Conductor();
					 }
	
				} else {
	
					FacesUtils.addInfoMessage("El conductor con el codigo " + codigo + " ya ha sido creado");
				}
	
			}
			
//		} catch (Exception e) {
//			
//			FacesUtils.addInfoMessage("El codigo digitado no es un numero, por favor revise el campo nuevamente");
//			conductorId_Conductor.setItemValue(null);
//			nuevoConductor.setValue("");
//		}

		return "";
	}

	public String segundoCampo() throws Exception {

		String codigoTrabajador = null;
		InputText nuevoConductor = null;
		CommandButton btnNewConductor = null;

		if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

			codigoTrabajador = (String) txtConductorId_Conductor.getValue();
			nuevoConductor = txtNuevoConductor;
			btnNewConductor = btnNewConductorPro;

		} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

			codigoTrabajador = (String) txtConductorId_ConductorDes.getValue();
			nuevoConductor = txtNuevoConductorDes;
			btnNewConductor = btnNewConductorDes;

		} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

			codigoTrabajador = (String) txtConductorId_ConductorSer.getValue();
			nuevoConductor = txtNuevoConductorSer;
			btnNewConductor = btnNewConductorSer;
		}

		Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
		List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

		if (lista.size() == 0) {
			
		
			 
			nuevoConductor.setStyle("");
			nuevoConductor.setPlaceholder("Ingrese nombre de conductor");
			btnNewConductor.setDisabled(false);
			

			FacesUtils.addInfoMessage(
					"Para crear un conductor llene en los campos el numero de cédula y nombre en ese orden");
			
		}

		return "";
	}

	public String action_nuevoVehiculo() throws Exception {

		Date date = new Date();
		entityEquipo = new Equipo();

		AutoComplete vehiTranspId_VehiculosTransp = null;
		CommandButton btnNewVehiculo = null;

		if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

			vehiTranspId_VehiculosTransp = txtVehiTranspId_VehiculosTransp;
			btnNewVehiculo = btnNewConductorPro;

		} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

			vehiTranspId_VehiculosTransp = txtVehiTranspId_VehiculosTranspDes;
			btnNewVehiculo = btnNewConductorDes;

		} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

			vehiTranspId_VehiculosTransp = txtVehiTranspId_VehiculosTranspSer;
			btnNewVehiculo = btnNewConductorSer;
		}		

		String codigo = (String) vehiTranspId_VehiculosTransp.getValue();
		
		Object[] condicion2 = { "equipoId", true, codigo, "=", };
		List<Equipo> lista2 = businessDelegatorView.findByCriteriaInEquipo(condicion2, null, null);
		
		if (lista2.size() == 0) {

			if (vehiTranspId_VehiculosTransp.getValue() != null && !vehiTranspId_VehiculosTransp.getValue().equals("")) {
	
				entityEquipo.setCodigo(codigo);
				entityEquipo.setNombre(codigo);
				entityEquipo.setPlaca(codigo);
				entityEquipo.setCompania((long) 1);
				entityEquipo.setAnioFabricacion((long) 1900);
				entityEquipo.setCategoriaEquipo(businessDelegatorView.getCategoriaEquipo((long) 13));
				entityEquipo.setTaraEstandar((double) 0);
				entityEquipo.setMedidor((long) 6);
				entityEquipo.setContratista(businessDelegatorView.getPersEmpr((long) 1));
				entityEquipo.setFechaCreacion(date);
				entityEquipo.setEstado("A");
				entityEquipo.setTipoPropiedad("Otro");
				entityEquipo.setOrigenDatos("Modulo_TallerAgricola");
	
				Object[] condicion = { "codigo", true, codigo, "=", };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
	
				if (lista.size() == 0) {
	
					businessDelegatorView.saveEquipo(entityEquipo, null, null);
					FacesUtils.addInfoMessage("El vehiculo con la placa " + codigo + " ha sido creado exitosamente");
	
					Object[] condicion1 = { "codigo", true, codigo, "=", };
					List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);
	
					if (lista1.size() > 0) {
						Equipo equipo1 = lista1.get(0);
						vehiTranspId_VehiculosTransp.setValue(equipo1);
					}
	
					btnNewVehiculo.setDisabled(true);
	
				} else {
	
					FacesUtils.addInfoMessage("El vehiculo con la placa " + codigo + " ya ha sido creado");
				}
	
			} else {
	
				FacesUtils.addInfoMessage("El vehiculo esta vacio, por favor seleccione o cree uno");
			}
			
		} else {
			
			FacesUtils.addInfoMessage("Este vehiculo ya existe");
			
			if (lista2.size() > 0) {
				Equipo equipo2 = lista2.get(0);
				vehiTranspId_VehiculosTransp.setValue(equipo2);
			}
		}

		return "";
	}

	public String action_create() throws Exception {

		try {
			Long compania = new Long(getCompaniaIdSession());
			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
			Long idEquipo = null;
			Long idTrabajador = null;
			String tipoTransaccion = "";
			List<TiquetesBasculaDTO> dataEnPatio = null;

			if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

				codigoEquipo = (String) txtVehiTranspId_VehiculosTransp.getValue();
				codigoTrabajador = (String) txtConductorId_Conductor.getValue();
				tipoTransaccion = (String) txtTipoTransaccion.getValue();

			} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

				codigoEquipo = (String) txtVehiTranspId_VehiculosTranspDes.getValue();
				codigoTrabajador = (String) txtConductorId_ConductorDes.getValue();
				tipoTransaccion = (String) txtTipoTransaccionDes.getValue();

			} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

				codigoEquipo = (String) txtVehiTranspId_VehiculosTranspSer.getValue();
				codigoTrabajador = (String) txtConductorId_ConductorSer.getValue();
				tipoTransaccion = (String) txtTipoTransaccionSer.getValue();
			}

			if (codigoEquipo != null && codigoTrabajador != null) {

				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);

				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
					idEquipo = equipo1.getEquipoId();
				}

				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
					idTrabajador = trabajador1.getTrabId();
				}
			}

			if (idEquipo != null && idEquipo > 0 && idTrabajador != null && idTrabajador > 0) {

				dataEnPatio = businessDelegator2View.pr_consulta_vehiculo_en_patio(compania, idEquipo);

				if (dataEnPatio != null && dataEnPatio.size() > 0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Upps! El vehículo que esta intentando ingresar ya se encuentra en zona de patios.",
									" Verifique por favor."));

					limpiar_vehiculoConductor();

				} else {

					entity = new DatTransProd();
					entityLog = new LogBascula();
					Long usuarioId = new Long(getUsuarioIdSession());
					Date date = new Date();
					
					entity.setCompania(compania);
					entity.setEstado("A");
					entity.setFechaCreacion(date);
					entity.setConsecutivo((businessDelegatorView.consultarConsecutivoDatTransProd(compania)));
					entity.setUsuarioDigitacion(usuarioId);

					if (tipoTransaccion != null && tipoTransaccion.equals("Produccion")) {
						
						Date fechaEntrada = (Date) txtFechaEstadoVehiculoPro.getValue();

						entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
						entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccion));
						entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
						entity.setObservacion(FacesUtils.checkString(txtObservacion));
						entity.setNoDocumento(FacesUtils.checkString(txtNoDocumento));
						entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora)));
						entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
						entity.setVagon1((FacesUtils.checkString(txtVagon1)));
						entity.setVagon2((FacesUtils.checkString(txtVagon2)));
						entity.setVagon3((FacesUtils.checkString(txtVagon3)));
						entity.setFechaEstadoVehiculo(fechaEntrada);
						entity.setConductor(idTrabajador);
						entity.setVehiculoId(idEquipo);

						Double peso = 0.0;
						try {
							peso = ((Double) txtPesoBrutoPesaje.getValue() + 0.0);
						} catch (Exception e) {
							peso = Double.parseDouble(txtPesoBrutoPesaje.getValue().toString() + 0.0);
						}

						if (peso != null && peso > 0) {

							entity.setFechaEntrada(date);
							entity.setFechaPesoBruto(date);
							entity.setPesoTara(0.0);
							entity.setPesoBruto((FacesUtils.checkDouble(txtPesoBrutoPesaje)));

						} else {

							entity.setPesoBruto(0.0);
							entity.setPesoTara(0.0);
						}

						if (txtProductoCos.getValue() != null && txtNivel2Id.getValue() != null) {

							action_agregarNivel4();

						}

					} else if (tipoTransaccion != null && tipoTransaccion.equals("Despachos")) {
						
						Date fechaEntrada = (Date) txtFechaEstadoVehiculoDes.getValue();
						entity.setFechaEstadoVehiculo(fechaEntrada);

						entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccionDes));
						entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccionDes));
						entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistroDes));
						entity.setObservacion(FacesUtils.checkString(txtObservacionDes));
						entity.setObservacion3(FacesUtils.checkString(txtObservacion3));
						entity.setNoDocumento(FacesUtils.checkString(txtNoDocumentoDes));
						entity.setTransportadora((FacesUtils.checkLong(txtTranspId_TransportadoraDes)));
						entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicionalDes));
						entity.setVagon1((FacesUtils.checkString(txtVagon1Des)));
						entity.setVagon2((FacesUtils.checkString(txtVagon2Des)));
						entity.setVagon3((FacesUtils.checkString(txtVagon3Des)));
						entity.setVariable1((FacesUtils.checkDouble(txtVariable1)));
						entity.setVariable2((FacesUtils.checkDouble(txtVariable2)));
						entity.setVariableTexto1((FacesUtils.checkString(txtVariableTexto1)));
						entity.setVariable4((FacesUtils.checkDouble(txtVariable4)));
						entity.setSello1((FacesUtils.checkString(txtSello1)));
						entity.setSello2((FacesUtils.checkString(txtSello2)));
						entity.setSello3((FacesUtils.checkString(txtSello3)));
						entity.setSello4((FacesUtils.checkString(txtSello4)));
						entity.setSello5((FacesUtils.checkString(txtSello5)));
						entity.setSello6((FacesUtils.checkString(txtSello6)));
						entity.setSello7((FacesUtils.checkString(txtSello7)));
						entity.setSello8((FacesUtils.checkString(txtSello8)));
						entity.setSello9((FacesUtils.checkString(txtSello9)));
						entity.setSello10((FacesUtils.checkString(txtSello10)));
						entity.setObservacionAnalisis((FacesUtils.checkString(txtObservacionAnalisis)));
						entity.setObservacion2(FacesUtils.checkString(txtObservacion2Des));
						entity.setConductor(idTrabajador);
						entity.setVehiculoId(idEquipo);
						entity.setPesoBruto(0.0);

						Double peso = 0.0;
						try {
							peso = ((Double) txtPesoBrutoPesajeDes.getValue() + 0.0);
						} catch (Exception e) {
							peso = Double.parseDouble(txtPesoBrutoPesajeDes.getValue().toString() + 0.0);
						}

						if (peso != null && peso > 0) {

							entity.setFechaEntrada(date);
							entity.setFechaTara(date);
							entity.setPesoBruto(0.0);
							entity.setPesoTara((FacesUtils.checkDouble(txtPesoBrutoPesajeDes)));

						} else {

							entity.setPesoBruto(0.0);
							entity.setPesoTara(0.0);
						}

						if (txtProducto.getValue() != null && txtClienteDet.getValue() != null) {

							action_agregarProductos();

						}

					} else if (tipoTransaccion != null && tipoTransaccion.equals("Servicios")) {
						
						Date fechaEntrada = (Date) txtFechaEstadoVehiculoSer.getValue();
						entity.setFechaEstadoVehiculo(fechaEntrada);

						entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccionSer));
						entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccionSer));
						entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistroSer));
						entity.setObservacion(FacesUtils.checkString(txtObservacionSer));
						entity.setObservacion2(FacesUtils.checkString(txtObservacion2));
						entity.setOrigen(FacesUtils.checkString(txtOrigen));
						entity.setNoDocumento(FacesUtils.checkString(txtNoDocumentoSer));
						entity.setTransportadora((FacesUtils.checkLong(txtTranspId_TransportadoraSer)));
						entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicionalSer));
						entity.setVagon1((FacesUtils.checkString(txtVagon1Ser)));
						entity.setVagon2((FacesUtils.checkString(txtVagon2Ser)));
						entity.setVagon3((FacesUtils.checkString(txtVagon3Ser)));
						entity.setConductor(idTrabajador);
						entity.setVehiculoId(idEquipo);

						String tipoPeso = (String) txtTipoPeso.getValue();

						Double peso = 0.0;
						try {
							peso = ((Double) txtPesoBrutoPesajeSer.getValue() + 0.0);
						} catch (Exception e) {
							peso = Double.parseDouble(txtPesoBrutoPesajeSer.getValue().toString() + 0.0);
						}

						if (tipoPeso.equals("1")) {

							if (peso != null && peso > 0) {

								entity.setFechaEntrada(date);
								entity.setFechaPesoBruto(date);
								entity.setPesoTara(0.0);
								entity.setPesoBruto((FacesUtils.checkDouble(txtPesoBrutoPesajeSer)));

							} else {

								entity.setPesoBruto(0.0);
								entity.setPesoTara(0.0);
							}

						} else if (tipoPeso.equals("2")) {

							if (peso != null && peso > 0) {

								entity.setFechaEntrada(date);
								entity.setFechaTara(date);
								entity.setPesoBruto(0.0);
								entity.setPesoTara((FacesUtils.checkDouble(txtPesoBrutoPesajeSer)));

							} else {

								entity.setPesoBruto(0.0);
								entity.setPesoTara(0.0);
							}
						}

						if (txtProductoSer.getValue() != null && txtClienteDetSer.getValue() != null) {

							action_agregarProductos();

						}
					}

					businessDelegatorView.saveDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4, null);

					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
							+ (businessDelegatorView.consultarConsecutivoDatTransProd(compania) - 1));

					entityLog.setTiquete(businessDelegatorView.consultarConsecutivoDatTransProd(compania) - 1);
					entityLog.setCompania(compania);
					entityLog.setUsuarioModificacion(usuarioId);
					Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
					entityLog.setFecha(date);

					Long consecutivo = (businessDelegatorView.consultarConsecutivoDatTransProd(compania) - 1);
					String codusuario = usuario.getLogin();
					String tipoTrans = FacesUtils.checkString(txtTipoTransaccion);
					entityLog.setObservacion("El tiquete:" + "  " + consecutivo.toString()
							+ " Fue creado por el usuario: " + codusuario + " y es de tipo: " + tipoTrans);

					businessDelegatorView.saveLogBascula(entityLog);

					if(idEquipo!=null && idTrabajador!=null) {
						entityEquipo =null;
						entityEquipo = businessDelegatorView.getEquipo(idEquipo);
						entityEquipo.setTrabajador(idTrabajador);
						businessDelegatorView.updateEquipo(entityEquipo, null, null);
					}
					
				/*
					if(tipoTransaccion != null && tipoTransaccion.equals("Produccion")){
						RequestContext.getCurrentInstance().closeDialog("dialogDatTransProd");
					}
					if(tipoTransaccion != null && tipoTransaccion.equals("Despachos")){
							RequestContext.getCurrentInstance().closeDialog("dialogDatTransProd2");					
					}
					if(tipoTransaccion != null && tipoTransaccion.equals("Servicios")){
						RequestContext.getCurrentInstance().closeDialog("dialogDatTransProd3");
					}
					*/
					
					action_clear();
					cargarTiquetes();
		
				}

			} else {
				
				/*PrimeFaces contextDialog = PrimeFaces.current();
				contextDialog.dialog().openDynamic("dialogDatTransProd");*/

				PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
						  FacesMessage.SEVERITY_ERROR, "Error!",
						  "El vehiculo o el conductor no son validos o no existen, porfavor seleccione uno existente o creelo "
						  ));
				limpiar_vehiculoConductor();
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() throws Exception {

		try {
			Long compania = new Long(getCompaniaIdSession());
			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
			Long idEquipo = null;
			Long idTrabajador = null;
			String tipoTransaccion = "";

			if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

				codigoEquipo = (String) txtVehiTranspId_VehiculosTransp.getValue();
				codigoTrabajador = (String) txtConductorId_Conductor.getValue();
				tipoTransaccion = (String) txtTipoTransaccion.getValue();

			} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

				codigoEquipo = (String) txtVehiTranspId_VehiculosTranspDes.getValue();
				codigoTrabajador = (String) txtConductorId_ConductorDes.getValue();
				tipoTransaccion = (String) txtTipoTransaccionDes.getValue();

			} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

				codigoEquipo = (String) txtVehiTranspId_VehiculosTranspSer.getValue();
				codigoTrabajador = (String) txtConductorId_ConductorSer.getValue();
				tipoTransaccion = (String) txtTipoTransaccionSer.getValue();
			}

			if (codigoEquipo != null && codigoTrabajador != null) {

				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);

				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
					idEquipo = equipo1.getEquipoId();
				}

				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
					idTrabajador = trabajador1.getTrabId();
				}
			}

			if (idEquipo != null && idEquipo > 0 && idTrabajador != null && idTrabajador > 0) {

				entityLog = new LogBascula();
				Long usuarioId = new Long(getUsuarioIdSession());
				Date date = new Date();
				entity.setCompania(compania);
				entity.setEstado("A");
				entity.setFechaModificacion(date);
				entity.setUsuarioDigitacion(usuarioId);

				if (tipoTransaccion != null && tipoTransaccion.equals("Produccion")) {
					
					Date fechaEntrada = (Date) txtFechaEstadoVehiculoPro.getValue();
					entity.setFechaEstadoVehiculo(fechaEntrada);

					entity.setDatTransProdId(FacesUtils.checkLong(txtDatTransProdId));
					entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
					entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccion));
					entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
					entity.setObservacion(FacesUtils.checkString(txtObservacion));
					entity.setNoDocumento(FacesUtils.checkString(txtNoDocumento));
					entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora)));
					entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
					entity.setVagon1((FacesUtils.checkString(txtVagon1)));
					entity.setVagon2((FacesUtils.checkString(txtVagon2)));
					entity.setVagon3((FacesUtils.checkString(txtVagon3)));
					entity.setConductor(idTrabajador);
					entity.setVehiculoId(idEquipo);

					if (txtProductoCos.getValue() != null && txtNivel2Id.getValue() != null) {

						action_agregarNivel4();

					}

				} else if (tipoTransaccion != null && tipoTransaccion.equals("Despachos")) {
					
					Date fechaEntrada = (Date) txtFechaEstadoVehiculoDes.getValue();
					entity.setFechaEstadoVehiculo(fechaEntrada);

					entity.setDatTransProdId(FacesUtils.checkLong(txtDatTransProdIdDes));
					entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccionDes));
					entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccionDes));
					entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistroDes));
					entity.setObservacion(FacesUtils.checkString(txtObservacionDes));
					entity.setObservacion3(FacesUtils.checkString(txtObservacion3));
					entity.setNoDocumento(FacesUtils.checkString(txtNoDocumentoDes));
					entity.setTransportadora((FacesUtils.checkLong(txtTranspId_TransportadoraDes)));
					entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicionalDes));
					entity.setVagon1((FacesUtils.checkString(txtVagon1Des)));
					entity.setVagon2((FacesUtils.checkString(txtVagon2Des)));
					entity.setVagon3((FacesUtils.checkString(txtVagon3Des)));
					entity.setVariable1((FacesUtils.checkDouble(txtVariable1)));
					entity.setVariable2((FacesUtils.checkDouble(txtVariable2)));
					entity.setVariableTexto1((FacesUtils.checkString(txtVariableTexto1)));
					entity.setVariable4((FacesUtils.checkDouble(txtVariable4)));
					entity.setSello1((FacesUtils.checkString(txtSello1)));
					entity.setSello2((FacesUtils.checkString(txtSello2)));
					entity.setSello3((FacesUtils.checkString(txtSello3)));
					entity.setSello4((FacesUtils.checkString(txtSello4)));
					entity.setSello5((FacesUtils.checkString(txtSello5)));
					entity.setSello6((FacesUtils.checkString(txtSello6)));
					entity.setSello7((FacesUtils.checkString(txtSello7)));
					entity.setSello8((FacesUtils.checkString(txtSello8)));
					entity.setSello9((FacesUtils.checkString(txtSello9)));
					entity.setSello10((FacesUtils.checkString(txtSello10)));
					entity.setObservacionAnalisis((FacesUtils.checkString(txtObservacionAnalisis)));
					entity.setObservacion2(FacesUtils.checkString(txtObservacion2Des));
					entity.setConductor(idTrabajador);
					entity.setVehiculoId(idEquipo);

					if (txtProducto.getValue() != null && txtClienteDet.getValue() != null
							) {

						action_agregarProductos();

					}

				} else if (tipoTransaccion != null && tipoTransaccion.equals("Servicios")) {
					
					Date fechaEntrada = (Date) txtFechaEstadoVehiculoSer.getValue();
					entity.setFechaEstadoVehiculo(fechaEntrada);

					entity.setDatTransProdId(FacesUtils.checkLong(txtDatTransProdIdSer));
					entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccionSer));
					entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccionSer));
					entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistroSer));
					entity.setObservacion(FacesUtils.checkString(txtObservacionSer));
					entity.setObservacion2(FacesUtils.checkString(txtObservacion2));
					entity.setOrigen(FacesUtils.checkString(txtOrigen));
					entity.setNoDocumento(FacesUtils.checkString(txtNoDocumentoSer));
					entity.setTransportadora((FacesUtils.checkLong(txtTranspId_TransportadoraSer)));
					entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicionalSer));
					entity.setVagon1((FacesUtils.checkString(txtVagon1Ser)));
					entity.setVagon2((FacesUtils.checkString(txtVagon2Ser)));
					entity.setVagon3((FacesUtils.checkString(txtVagon3Ser)));
					entity.setConductor(idTrabajador);
					entity.setVehiculoId(idEquipo);

					if (txtProductoSer.getValue() != null && txtClienteDetSer.getValue() != null
							) {

						action_agregarProductos();

					}
				}

				businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4, null);

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED + ". Número consecutivo: "
						+ (businessDelegatorView.consultarConsecutivoDatTransProd(compania) - 1));

				entityLog.setTiquete(entity.getConsecutivo());
				entityLog.setCompania(compania);
				entityLog.setUsuarioModificacion(usuarioId);
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
				entityLog.setFecha(date);

				Long consecutivo = null;
				String tipoTrans = "";
				String fechaRegistro = "";
				String vagon1 = "";
				String vagon2 = "";
				String vagon3 = "";
				String sellos = "";
				String acidez = "";
				String humedad = "";
				String impurezas = "";
				String observacion = "";
				String destinoProduccion = "";
				String observacion2 = "";
				String observacion3 = "";
				String pesoTara = "";
				String pesoBruto = "";
				String pesoNeto = "";
				String fechaEntrada = "";
				String fechaSalida = "";

				if (entity.getConsecutivo() != null) {
					consecutivo = entity.getConsecutivo();
				}

				if (entity.getTipoTransaccion() != null) {
					tipoTrans = entity.getTipoTransaccion();
				}

				if (entity.getFechaRegistro() != null) {
					fechaRegistro = entity.getFechaRegistro().toString();
				}

				if (entity.getVagon1() != null) {
					vagon1 = entity.getVagon1().toString();
				}

				if (entity.getVagon2() != null) {
					vagon2 = entity.getVagon2().toString();
				}

				if (entity.getVagon3() != null) {
					vagon3 = entity.getVagon3().toString();
				}

				if (entity.getSello1() != null) {
					sellos = entity.getSello1().toString() ;
				}
				
				if (entity.getSello2() != null) {
					sellos = sellos + "-" + entity.getSello2().toString() ;
				}
				
				if (entity.getSello3() != null) {
					sellos = sellos + "-" + entity.getSello3().toString() ;
				}	
				
				if (entity.getSello4() != null) {
					sellos = sellos + "-" + entity.getSello4().toString() ;
				}
				
				if (entity.getSello5() != null) {
					sellos = sellos + "-" + entity.getSello5().toString() ;
				}	
				
				if (entity.getSello6() != null) {
					sellos = sellos + "-" + entity.getSello6().toString() ;
				}
				
				if (entity.getSello7() != null) {
					sellos = sellos + "-" + entity.getSello7().toString() ;
				}	
				
				if (entity.getSello8() != null) {
					sellos = sellos + "-" + entity.getSello8().toString() ;
				}
				
				if (entity.getSello9() != null) {
					sellos = sellos + "-" + entity.getSello9().toString() ;
				}
				
				if (entity.getSello10() != null) {
					sellos = sellos + "-" + entity.getSello10().toString() ;
				}
				
				if (entity.getVariable1() != null) {
					acidez = entity.getVariable1().toString();
				}

				if (entity.getVariable2() != null) {
					humedad = entity.getVariable2().toString();
				}

				if (entity.getVariableTexto1() != null) {
					impurezas = entity.getVariableTexto1().toString();
				}

				if (entity.getObservacion() != null) {
					observacion = entity.getObservacion().toString();
				}

				if (entity.getDestinoProduccion() != null) {
					destinoProduccion = entity.getDestinoProduccion().toString();
				}

				if (entity.getObservacion2() != null) {
					observacion2 = entity.getObservacion2().toString();
				}

				if (entity.getObservacion3() != null) {
					observacion3 = entity.getObservacion3().toString();
				}

				if (entity.getPesoTara() != null) {
					pesoTara = entity.getPesoTara().toString();
				}

				if (entity.getPesoBruto() != null) {
					pesoBruto = entity.getPesoBruto().toString();
				}

				if (entity.getPesoNeto() != null) {
					pesoNeto = entity.getPesoNeto().toString();
				}

				if (entity.getFechaEntrada() != null) {
					fechaEntrada = entity.getFechaEntrada().toString();
				}

				if (entity.getFechaSalida() != null) {
					fechaSalida = entity.getFechaSalida().toString();
				}

				String equipo = equipo1.getNombre();
				String conductor = trabajador1.getNombre();
				String codusuario = usuario.getLogin();

				String valoresFinalesTiquete = "Valores finales: Tiquete: " + consecutivo.toString()
						+ " TipoTransaccion: " + tipoTrans.toString() + " Fecha registro: " + fechaRegistro
						+ " Equipo: " + equipo + " Conductor: " + conductor + " Vagón 1: " + vagon1 + " Vagón 2: "
						+ vagon2 + " Vagón 3: " + vagon3 + " Destino de producción: " + destinoProduccion
						+ " Peso tara: " + pesoTara + " Peso bruto: " + pesoBruto + " Peso neto: " + pesoNeto
						+ " Fecha entrada: " + fechaEntrada + " Fecha salida: " + fechaSalida + " Sellos: " + sellos
						+ " Acidez: " + acidez + " Humedad: " + humedad + " Impurezas: " + impurezas + " Observación: "
						+ observacion + "Observacion 2: " + observacion2 + "Observacion 3: " + observacion3;

				entityLog.setObservacion(
						"El tiquete:" + "  " + consecutivo.toString() + " Fue modificado por el usuario: " + codusuario
								+ " " + cambioTiquete + " " + valoresFinalesTiquete);

				businessDelegatorView.saveLogBascula(entityLog);

				action_clear();
				cargarTiquetes();

			} else {

				PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
						  FacesMessage.SEVERITY_ERROR, "Error!",
						  "El vehiculo o el conductor no son validos o no existen, porfavor seleccione uno existente o creelo "
						  ));
				limpiar_vehiculoConductor();
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_savePesoBruto() {

		try {
			Long id = null;
			if (entity == null) {
				id = new Long(selectedDatTransProd.getDatTransProdId());
				entity = businessDelegatorView.getDatTransProd(id);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			Double pesoBruto = 0.0;
			Double pesoTara = 0.0;

			try {
				pesoBruto = (Double) txtPesarPesoBruto.getValue() + 0.0;
				pesoTara = (Double) txtPesarPesoTara.getValue() + 0.0;

			} catch (Exception e) {

				pesoBruto = Double.parseDouble(txtPesarPesoBruto.getValue().toString() + 0.0);
				pesoTara = Double.parseDouble(txtPesarPesoTara.getValue().toString() + 0.0);
			}

			if (pesoTara.intValue() == 0.0 || pesoBruto.intValue() == 0.0) {
				
				if (txtTipoTransaccionPesaje.getValue().equals("Produccion")) {

					if (txtTipoPesoPes.getValue().equals("2")) {
						
						entity.setFechaSalida(date);
						entity.setFechaTara(date);
						entity.setFechaPesoNeto(date);
						entity.setPesoTara(pesoTara);
	
					} else if (txtTipoPesoPes.getValue().equals("1")) {
						
						entity.setFechaEntrada(date);
						entity.setFechaPesoBruto(date);
						entity.setFechaPesoNeto(date);
						entity.setPesoBruto(pesoBruto);
					}
					
				} else if (txtTipoTransaccionPesaje.getValue().equals("Despachos")) {
					
					if (txtTipoPesoPes.getValue().equals("2")) {
						
						entity.setFechaEntrada(date);
						entity.setFechaTara(date);
						entity.setFechaPesoNeto(date);
						entity.setPesoTara(pesoTara);
	
					} else if (txtTipoPesoPes.getValue().equals("1")) {
						
						entity.setFechaSalida(date);
						entity.setFechaPesoBruto(date);
						entity.setFechaPesoNeto(date);
						entity.setPesoBruto(pesoBruto);
					}
				} else if (txtTipoTransaccionPesaje.getValue().equals("Servicios")) {
					
					if (txtTipoPesoPes.getValue().equals("2")) {
						
						entity.setFechaEntrada(date);
						entity.setFechaTara(date);
						entity.setFechaPesoNeto(date);
						entity.setPesoTara(pesoTara);
	
					} else if (txtTipoPesoPes.getValue().equals("1")) {
						
						entity.setFechaEntrada(date);
						entity.setFechaPesoBruto(date);
						entity.setFechaPesoNeto(date);
						entity.setPesoBruto(pesoBruto);
					}
				}

				entity.setBasculaPesoBruto(FacesUtils.checkLong(txtBasculaBrutoPes));
				entity.setUsuarioPesoBruto(usuarioId);

				Long idBascula = FacesUtils.checkLong(txtBasculaBrutoPes);
				Bascula bascula = businessDelegatorView.getBascula(idBascula);

				entity.setTipoPesajeBruto(bascula.getTipoLectura().toString());

				businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
						dataPlanillaDet);

				if (pesoBruto > 0 && pesoTara == 0) {

					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVEDPESOBRUTO);

				} else if (pesoTara > 0 && pesoBruto == 0) {

					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVEDPESOTARA);

				}

				btnSavePes.setDisabled(true);
				btnImprimir.setDisabled(true);
				btnCalcular.setDisabled(true);
				txtPesarPesoBruto.setReadonly(true);
				txtPesarPesoTara.setReadonly(true);
				txtBasculaBrutoPes.setDisabled(true);

				cargarTiquetes();

			} else if (pesoBruto != null && pesoBruto.intValue() > 0 && pesoTara != null && pesoTara.intValue() > 0) {

				Double pesoNeto = (pesoBruto - pesoTara);

				if (pesoNeto > 0) {

					if (txtTipoTransaccionPesaje.getValue().equals("Produccion")) {

						if (txtTipoPesoPes.getValue().equals("2")) {
							
							entity.setFechaSalida(date);
							entity.setFechaTara(date);
							entity.setFechaPesoNeto(date);
							entity.setPesoTara(pesoTara);
		
						} else if (txtTipoPesoPes.getValue().equals("1")) {
							
							entity.setFechaEntrada(date);
							entity.setFechaPesoBruto(date);
							entity.setFechaPesoNeto(date);
							entity.setPesoBruto(pesoBruto);
						}
						
					} else if (txtTipoTransaccionPesaje.getValue().equals("Despachos")) {
						
						if (txtTipoPesoPes.getValue().equals("2")) {
							
							entity.setFechaEntrada(date);
							entity.setFechaTara(date);
							entity.setFechaPesoNeto(date);
							entity.setPesoTara(pesoTara);
		
						} else if (txtTipoPesoPes.getValue().equals("1")) {
							
							entity.setFechaSalida(date);
							entity.setFechaPesoBruto(date);
							entity.setFechaPesoNeto(date);
							entity.setPesoBruto(pesoBruto);
						}
						
					} else if (txtTipoTransaccionPesaje.getValue().equals("Servicios")) {
						
						if (txtTipoPesoPes.getValue().equals("2")) {
							
							entity.setFechaSalida(date);
							entity.setFechaTara(date);
							entity.setFechaPesoNeto(date);
							entity.setPesoTara(pesoTara);
		
						} else if (txtTipoPesoPes.getValue().equals("1")) {
							
							entity.setFechaSalida(date);
							entity.setFechaPesoBruto(date);
							entity.setFechaPesoNeto(date);
							entity.setPesoBruto(pesoBruto);
						}
					}

					entity.setConsecutivoPesoNeto(
							businessDelegator2View.consultarConsecutivoDatTransProdPesoNeto(compania));
					entity.setPesoNeto(pesoNeto);
					entity.setBasculaPesoBruto(FacesUtils.checkLong(txtBasculaBrutoPes));
					entity.setUsuarioPesoBruto(usuarioId);

					Long idBascula = FacesUtils.checkLong(txtBasculaBrutoPes);
					Bascula bascula = businessDelegatorView.getBascula(idBascula);

					entity.setTipoPesajeBruto(bascula.getTipoLectura().toString());

					businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
							dataPlanillaDet);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVEDPESONETO);

					btnSavePes.setDisabled(true);
					btnImprimir.setDisabled(false);
					btnCalcular.setDisabled(true);
					txtPesarPesoBruto.setReadonly(true);
					txtPesarPesoTara.setReadonly(true);
					txtBasculaBrutoPes.setDisabled(true);

					cargarTiquetes();

				} else if (pesoBruto == 0.0 || pesoTara == 0.0) {

					FacesUtils.addInfoMessage(
							"El peso neto no puede ser negativo o igual a cero " + "porfavor pese de nuevo");
				} else {

					FacesUtils.addInfoMessage(
							"El peso neto no puede ser negativo o igual a cero " + "porfavor pese de nuevo");
				}

			} else {

				FacesUtils.addInfoMessage(
						"El peso neto no puede ser negativo o igual a cero " + "porfavor pese de nuevo");
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_save_corregirPro() {

		try {

			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
			Long idEquipo = null;
			Long idTrabajador = null;

			codigoEquipo = (String) txtVehiTranspId_VehiculosTransp.getValue();
			codigoTrabajador = (String) txtConductorId_Conductor.getValue();
			

			if (codigoEquipo != null && codigoTrabajador != null) {

				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);

				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
					idEquipo = equipo1.getEquipoId();
				}

				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
					idTrabajador = trabajador1.getTrabId();
				}
			}

			if (idEquipo != null && idEquipo > 0 && idTrabajador != null && idTrabajador > 0) {

				entityLog = new LogBascula();

				Date date = new Date();
				estadoGrabar = true;
				Long compania = new Long(getCompaniaIdSession());
				Long usuarioId = new Long(getUsuarioIdSession());
				Double pesoTara1 = (Double) txtPesoTara.getValue();
				Double pesoBruto1 = (Double) txtPesoBruto.getValue();
				Date fechaEntrada1 = (Date) txtFechaEstadoVehiculoPro.getValue();
				
				txtVehiTranspId_VehiculosTransp.setValue(equipo1);
				txtConductorId_Conductor.setValue(trabajador1);

				if (pesoTara1 != null && pesoTara1 > 0 && pesoBruto1 != null && pesoBruto1 > 0) {
					
					Double pesoNeto1 = pesoBruto1 - pesoTara1;

					if (pesoNeto1 != null && pesoNeto1 > 0) {

						estadoGrabar = true;

						entity.setPesoNeto(pesoNeto1);

					} else if (pesoNeto1 < 0) {
						
						PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
								  FacesMessage.SEVERITY_ERROR, "Error!",
								  "El peso neto no puede ser negativo , para poder GRABAR debe digitar los valores correctos "
								  ));
						
						estadoGrabar = false;
						
					}

				} else {
					
					entity.setPesoNeto(0.0);
				}
				
				if (estadoGrabar == true) {
					
					if (txtProductoCos.getValue() != null && txtNivel2Id.getValue() != null) {

						action_agregarNivel4();

					}
					
					entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
					entity.setFechaEstadoVehiculo(fechaEntrada1);
					entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
					entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccion));
					entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
					entity.setObservacion(FacesUtils.checkString(txtObservacion));
					entity.setNoDocumento(FacesUtils.checkString(txtNoDocumento));
					entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora)));
					entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
					entity.setVagon1((FacesUtils.checkString(txtVagon1)));
					entity.setVagon2((FacesUtils.checkString(txtVagon2)));
					entity.setVagon3((FacesUtils.checkString(txtVagon3)));
					entity.setFechaEntrada(FacesUtils.checkDate(txtFechaEntrada));
					entity.setFechaSalida(FacesUtils.checkDate(txtFechaSalida));
					entity.setFechaPesoNeto(FacesUtils.checkDate(txtFechaSalida));
					entity.setFechaTara(FacesUtils.checkDate(txtFechaSalida));
					entity.setFechaPesoBruto(FacesUtils.checkDate(txtFechaEntrada));
					entity.setPesoTara(pesoTara1);
					entity.setPesoBruto(pesoBruto1);
					entity.setVehiculoId(idEquipo);
					entity.setConductor(idTrabajador);
					entity.setEstado("A");
					entity.setCompania(compania);
					entity.setUsuarioDigitacion(usuarioId);
					entity.setFechaModificacion(date);
					
					if(entity.getConsecutivoPesoNeto() ==null) {
						
						if(entity.getPesoNeto()!=null && entity.getPesoNeto() >0) {
							entity.setConsecutivoPesoNeto(
									businessDelegator2View.consultarConsecutivoDatTransProdPesoNeto(compania));
						}
					}
					
					
					businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
							dataPlanillaDet);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
	
					entityLog.setTiquete(entity.getConsecutivo());
					entityLog.setCompania(compania);
					entityLog.setUsuarioModificacion(usuarioId);
					Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
					entityLog.setFecha(date);
	
					Long consecutivo = null;
					String tipoTrans = "";
					String fechaRegistro = "";
					String vagon1 = "";
					String vagon2 = "";
					String vagon3 = "";
					String sellos = "";
					String acidez = "";
					String humedad = "";
					String impurezas = "";
					String observacion = "";
					String destinoProduccion = "";
					String observacion2 = "";
					String observacion3 = "";
					String pesoTara = "";
					String pesoBruto = "";
					String pesoNeto = "";
					String fechaEntrada = "";
					String fechaSalida = "";
	
					if (entity.getConsecutivo() != null) {
						consecutivo = entity.getConsecutivo();
					}
	
					if (entity.getTipoTransaccion() != null) {
						tipoTrans = entity.getTipoTransaccion();
					}
	
					if (entity.getFechaRegistro() != null) {
						fechaRegistro = entity.getFechaRegistro().toString();
					}
	
					if (entity.getVagon1() != null) {
						vagon1 = entity.getVagon1().toString();
					}
	
					if (entity.getVagon2() != null) {
						vagon2 = entity.getVagon2().toString();
					}
	
					if (entity.getVagon3() != null) {
						vagon3 = entity.getVagon3().toString();
					}
	
					if (entity.getSello1() != null) {
						sellos = entity.getSello1().toString() ;
					}
					
					if (entity.getSello2() != null) {
						sellos = sellos + "-" + entity.getSello2().toString() ;
					}
					
					if (entity.getSello3() != null) {
						sellos = sellos + "-" + entity.getSello3().toString() ;
					}	
					
					if (entity.getSello4() != null) {
						sellos = sellos + "-" + entity.getSello4().toString() ;
					}
					
					if (entity.getSello5() != null) {
						sellos = sellos + "-" + entity.getSello5().toString() ;
					}	
					
					if (entity.getSello6() != null) {
						sellos = sellos + "-" + entity.getSello6().toString() ;
					}
					
					if (entity.getSello7() != null) {
						sellos = sellos + "-" + entity.getSello7().toString() ;
					}	
					
					if (entity.getSello8() != null) {
						sellos = sellos + "-" + entity.getSello8().toString() ;
					}
					
					if (entity.getSello9() != null) {
						sellos = sellos + "-" + entity.getSello9().toString() ;
					}
					
					if (entity.getSello10() != null) {
						sellos = sellos + "-" + entity.getSello10().toString() ;
					}
	
					if (entity.getVariable1() != null) {
						acidez = entity.getVariable1().toString();
					}
	
					if (entity.getVariable2() != null) {
						humedad = entity.getVariable2().toString();
					}
	
					if (entity.getVariableTexto1() != null) {
						impurezas = entity.getVariableTexto1().toString();
					}
	
					if (entity.getObservacion() != null) {
						observacion = entity.getObservacion().toString();
					}
	
					if (entity.getDestinoProduccion() != null) {
						destinoProduccion = entity.getDestinoProduccion().toString();
					}
	
					if (entity.getObservacion2() != null) {
						observacion2 = entity.getObservacion2().toString();
					}
	
					if (entity.getObservacion3() != null) {
						observacion3 = entity.getObservacion3().toString();
					}
	
					if (entity.getPesoTara() != null) {
						pesoTara = entity.getPesoTara().toString();
					}
	
					if (entity.getPesoBruto() != null) {
						pesoBruto = entity.getPesoBruto().toString();
					}
	
					if (entity.getPesoNeto() != null) {
						pesoNeto = entity.getPesoNeto().toString();
					}
	
					if (entity.getFechaEntrada() != null) {
						fechaEntrada = entity.getFechaEntrada().toString();
					}
	
					if (entity.getFechaSalida() != null) {
						fechaSalida = entity.getFechaSalida().toString();
					}
	
					String equipo = equipo1.getNombre();
					String conductor = trabajador1.getNombre();
					String codusuario = usuario.getLogin();
	
					String valoresFinalesTiquete = "Valores finales: Tiquete: " + consecutivo.toString()
							+ " TipoTransaccion: " + tipoTrans.toString() + " Fecha registro: " + fechaRegistro
							+ " Equipo: " + equipo + " Conductor: " + conductor + " Vagón 1: " + vagon1 + " Vagón 2: "
							+ vagon2 + " Vagón 3: " + vagon3 + " Destino de producción: " + destinoProduccion
							+ " Peso tara: " + pesoTara + " Peso bruto: " + pesoBruto + " Peso neto: " + pesoNeto
							+ " Fecha entrada: " + fechaEntrada + " Fecha salida: " + fechaSalida + " Sellos: " + sellos
							+ " Acidez: " + acidez + " Humedad: " + humedad + " Impurezas: " + impurezas
							+ " Observación: " + observacion + "Observacion 2: " + observacion2 + "Observacion 3: "
							+ observacion3;
	
					entityLog.setObservacion(
							"El tiquete:" + "  " + consecutivo.toString() + " Fue modificado por el usuario: "
									+ codusuario + " " + cambioTiquete + " " + valoresFinalesTiquete);
	
					businessDelegatorView.saveLogBascula(entityLog);
	
					action_clear();
					estadoGrabar = false;
					
				}

				cargarTiquetesCorrecion();

			} else {

				PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
						  FacesMessage.SEVERITY_ERROR, "Error!",
						  "El vehiculo o el conductor no son validos o no existen, porfavor seleccione uno existente o creelo "
						  ));
				limpiar_vehiculoConductor();
			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
		return "";
	}
	
	public String action_save_corregirDes() {

		try {

			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
			Long idEquipo = null;
			Long idTrabajador = null;

			codigoEquipo = (String) txtVehiTranspId_VehiculosTranspDes.getValue();
			codigoTrabajador = (String) txtConductorId_ConductorDes.getValue();

			if (codigoEquipo != null && codigoTrabajador != null) {

				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);

				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
					idEquipo = equipo1.getEquipoId();
				}

				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
					idTrabajador = trabajador1.getTrabId();
				}
			}

			if (idEquipo != null && idEquipo > 0 && idTrabajador != null && idTrabajador > 0) {

				entityLog = new LogBascula();

				Date date = new Date();
				Long compania = new Long(getCompaniaIdSession());
				Long usuarioId = new Long(getUsuarioIdSession());
				estadoGrabar = true;
				Double pesoTara1 = (Double) txtPesoTaraDes.getValue();
				Double pesoBruto1 = (Double) txtPesoBrutoDes.getValue();
				Date fechaEntrada1 = (Date) txtFechaEstadoVehiculoDes.getValue();
				
				txtVehiTranspId_VehiculosTranspDes.setValue(equipo1);
				txtConductorId_ConductorDes.setValue(trabajador1);

				if (pesoTara1 != null && pesoTara1 > 0 && pesoBruto1 != null && pesoBruto1 > 0) {
					
					Double pesoNeto1 = pesoBruto1 - pesoTara1;

					if (pesoNeto1 != null && pesoNeto1 > 0) {

						estadoGrabar = true;

						entity.setPesoNeto(pesoNeto1);

					} else if (pesoNeto1 < 0) {
						
						PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
								  FacesMessage.SEVERITY_ERROR, "Error!",
								  "El peso neto no puede ser negativo , para poder GRABAR debe digitar los valores correctos "
								  ));
						
						estadoGrabar = false;
						
					}

				} else {
					
					entity.setPesoNeto(0.0);
				}
					
				if (estadoGrabar == true) {
					
					if (txtProducto.getValue() != null && txtClienteDet.getValue() != null) {

						action_agregarProductos();

					}
					
					entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivoDes));
					entity.setFechaEstadoVehiculo(fechaEntrada1);
					entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccionDes));
					entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccionDes));
					entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistroDes));
					entity.setObservacion(FacesUtils.checkString(txtObservacionDes));
					entity.setObservacion2(FacesUtils.checkString(txtObservacion2Des));
					entity.setObservacion3(FacesUtils.checkString(txtObservacion3));
					entity.setNoDocumento(FacesUtils.checkString(txtNoDocumentoDes));
					entity.setTransportadora((FacesUtils.checkLong(txtTranspId_TransportadoraDes)));
					entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicionalDes));
					entity.setVagon1((FacesUtils.checkString(txtVagon1Des)));
					entity.setVagon2((FacesUtils.checkString(txtVagon2Des)));
					entity.setVagon3((FacesUtils.checkString(txtVagon3Des)));
					entity.setVariable1((FacesUtils.checkDouble(txtVariable1)));
					entity.setVariable2((FacesUtils.checkDouble(txtVariable2)));
					entity.setVariableTexto1((FacesUtils.checkString(txtVariableTexto1)));
					entity.setVariable4((FacesUtils.checkDouble(txtVariable4)));
					entity.setSello1((FacesUtils.checkString(txtSello1)));
					entity.setSello2((FacesUtils.checkString(txtSello2)));
					entity.setSello3((FacesUtils.checkString(txtSello3)));
					entity.setSello4((FacesUtils.checkString(txtSello4)));
					entity.setSello5((FacesUtils.checkString(txtSello5)));
					entity.setSello6((FacesUtils.checkString(txtSello6)));
					entity.setSello7((FacesUtils.checkString(txtSello7)));
					entity.setSello8((FacesUtils.checkString(txtSello8)));
					entity.setSello9((FacesUtils.checkString(txtSello9)));
					entity.setSello10((FacesUtils.checkString(txtSello10)));
					entity.setObservacionAnalisis((FacesUtils.checkString(txtObservacionAnalisis)));
					entity.setObservacion2(FacesUtils.checkString(txtObservacion2Des));
					entity.setFechaEntrada(FacesUtils.checkDate(txtFechaEntradaDes));
					entity.setFechaSalida(FacesUtils.checkDate(txtFechaSalidaDes));
					entity.setFechaPesoNeto(FacesUtils.checkDate(txtFechaSalidaDes));
					entity.setFechaTara(FacesUtils.checkDate(txtFechaSalidaDes));
					entity.setFechaPesoBruto(FacesUtils.checkDate(txtFechaEntradaDes));
					entity.setPesoTara(pesoTara1);
					entity.setPesoBruto(pesoBruto1);
					entity.setVehiculoId(idEquipo);
					entity.setConductor(idTrabajador);
					entity.setEstado("A");
					entity.setCompania(compania);
					entity.setUsuarioDigitacion(usuarioId);
					entity.setFechaModificacion(date);
					if(entity.getConsecutivoPesoNeto() ==null) {
						
						if(entity.getPesoNeto()!=null && entity.getPesoNeto() >0) {
							entity.setConsecutivoPesoNeto(
									businessDelegator2View.consultarConsecutivoDatTransProdPesoNeto(compania));
						}
					}

					businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
							dataPlanillaDet);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

					entityLog.setTiquete(entity.getConsecutivo());
					entityLog.setCompania(compania);
					entityLog.setUsuarioModificacion(usuarioId);
					Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
					entityLog.setFecha(date);

					Long consecutivo = null;
					String tipoTrans = "";
					String fechaRegistro = "";
					String vagon1 = "";
					String vagon2 = "";
					String vagon3 = "";
					String sellos = "";
					String acidez = "";
					String humedad = "";
					String impurezas = "";
					String observacion = "";
					String destinoProduccion = "";
					String observacion2 = "";
					String observacion3 = "";
					String pesoTara = "";
					String pesoBruto = "";
					String pesoNeto = "";
					String fechaEntrada = "";
					String fechaSalida = "";

					if (entity.getConsecutivo() != null) {
						consecutivo = entity.getConsecutivo();
					}

					if (entity.getTipoTransaccion() != null) {
						tipoTrans = entity.getTipoTransaccion();
					}

					if (entity.getFechaRegistro() != null) {
						fechaRegistro = entity.getFechaRegistro().toString();
					}

					if (entity.getVagon1() != null) {
						vagon1 = entity.getVagon1().toString();
					}

					if (entity.getVagon2() != null) {
						vagon2 = entity.getVagon2().toString();
					}

					if (entity.getVagon3() != null) {
						vagon3 = entity.getVagon3().toString();
					}

					if (entity.getSello1() != null) {
						sellos = entity.getSello1().toString() ;
					}
					
					if (entity.getSello2() != null) {
						sellos = sellos + "-" + entity.getSello2().toString() ;
					}
					
					if (entity.getSello3() != null) {
						sellos = sellos + "-" + entity.getSello3().toString() ;
					}	
					
					if (entity.getSello4() != null) {
						sellos = sellos + "-" + entity.getSello4().toString() ;
					}
					
					if (entity.getSello5() != null) {
						sellos = sellos + "-" + entity.getSello5().toString() ;
					}	
					
					if (entity.getSello6() != null) {
						sellos = sellos + "-" + entity.getSello6().toString() ;
					}
					
					if (entity.getSello7() != null) {
						sellos = sellos + "-" + entity.getSello7().toString() ;
					}	
					
					if (entity.getSello8() != null) {
						sellos = sellos + "-" + entity.getSello8().toString() ;
					}
					
					if (entity.getSello9() != null) {
						sellos = sellos + "-" + entity.getSello9().toString() ;
					}
					
					if (entity.getSello10() != null) {
						sellos = sellos + "-" + entity.getSello10().toString() ;
					}

					if (entity.getVariable1() != null) {
						acidez = entity.getVariable1().toString();
					}

					if (entity.getVariable2() != null) {
						humedad = entity.getVariable2().toString();
					}

					if (entity.getVariableTexto1() != null) {
						impurezas = entity.getVariableTexto1().toString();
					}

					if (entity.getObservacion() != null) {
						observacion = entity.getObservacion().toString();
					}

					if (entity.getDestinoProduccion() != null) {
						destinoProduccion = entity.getDestinoProduccion().toString();
					}

					if (entity.getObservacion2() != null) {
						observacion2 = entity.getObservacion2().toString();
					}

					if (entity.getObservacion3() != null) {
						observacion3 = entity.getObservacion3().toString();
					}

					if (entity.getPesoTara() != null) {
						pesoTara = entity.getPesoTara().toString();
					}

					if (entity.getPesoBruto() != null) {
						pesoBruto = entity.getPesoBruto().toString();
					}

					if (entity.getPesoNeto() != null) {
						pesoNeto = entity.getPesoNeto().toString();
					}

					if (entity.getFechaEntrada() != null) {
						fechaEntrada = entity.getFechaEntrada().toString();
					}

					if (entity.getFechaSalida() != null) {
						fechaSalida = entity.getFechaSalida().toString();
					}

					String equipo = equipo1.getNombre();
					String conductor = trabajador1.getNombre();
					String codusuario = usuario.getLogin();

					String valoresFinalesTiquete = "Valores finales: Tiquete: " + consecutivo.toString()
							+ " TipoTransaccion: " + tipoTrans.toString() + " Fecha registro: " + fechaRegistro
							+ " Equipo: " + equipo + " Conductor: " + conductor + " Vagón 1: " + vagon1 + " Vagón 2: "
							+ vagon2 + " Vagón 3: " + vagon3 + " Destino de producción: " + destinoProduccion
							+ " Peso tara: " + pesoTara + " Peso bruto: " + pesoBruto + " Peso neto: " + pesoNeto
							+ " Fecha entrada: " + fechaEntrada + " Fecha salida: " + fechaSalida + " Sellos: " + sellos
							+ " Acidez: " + acidez + " Humedad: " + humedad + " Impurezas: " + impurezas
							+ " Observación: " + observacion + "Observacion 2: " + observacion2 + "Observacion 3: "
							+ observacion3;

					entityLog.setObservacion(
							"El tiquete:" + "  " + consecutivo.toString() + " Fue modificado por el usuario: "
									+ codusuario + " " + cambioTiquete + " " + valoresFinalesTiquete);

					businessDelegatorView.saveLogBascula(entityLog);

					action_clear();
					estadoGrabar = false;
				}

				cargarTiquetesCorrecion();

			} else {

				PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
						  FacesMessage.SEVERITY_ERROR, "Error!",
						  "El vehiculo o el conductor no son validos o no existen, porfavor seleccione uno existente o creelo "
						  ));

				limpiar_vehiculoConductor();
			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
		return "";
	}
	
	public String action_save_corregirSer() {

		try {

			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
			Long idEquipo = null;
			Long idTrabajador = null;
			
			codigoEquipo = (String) txtVehiTranspId_VehiculosTranspSer.getValue();
			codigoTrabajador = (String) txtConductorId_ConductorSer.getValue();
			

			if (codigoEquipo != null && codigoTrabajador != null) {

				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);

				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
					idEquipo = equipo1.getEquipoId();
				}

				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);

				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
					idTrabajador = trabajador1.getTrabId();
				}
			}

			if (idEquipo != null && idEquipo > 0 && idTrabajador != null && idTrabajador > 0) {

				entityLog = new LogBascula();

				Date date = new Date();
				Long compania = new Long(getCompaniaIdSession());
				Long usuarioId = new Long(getUsuarioIdSession());
				estadoGrabar = true;
				Double pesoTara1 = (Double) txtPesoTaraSer.getValue();
				Double pesoBruto1 = (Double) txtPesoBrutoSer.getValue();
				Date fechaEntrada1 = (Date) txtFechaEstadoVehiculoSer.getValue();
				
				txtVehiTranspId_VehiculosTranspSer.setValue(equipo1);
				txtConductorId_ConductorSer.setValue(trabajador1);

				if (pesoTara1 != null && pesoTara1 > 0 && pesoBruto1 != null && pesoBruto1 > 0) {

					Double pesoNeto1 = pesoBruto1 - pesoTara1;

					if (pesoNeto1 != null && pesoNeto1 > 0) {

						estadoGrabar = true;

						entity.setPesoNeto(pesoNeto1);

					} else if (pesoNeto1 < 0) {
						
						PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
								  FacesMessage.SEVERITY_ERROR, "Error!",
								  "El peso neto no puede ser negativo , para poder GRABAR debe digitar los valores correctos "
								  ));
						
						estadoGrabar = false;
						
					}

				} else {
					
					entity.setPesoNeto(0.0);
				}
				
				if (estadoGrabar == true) {
					
					if (txtProductoSer.getValue() != null && txtClienteDetSer.getValue() != null
							) {

						action_agregarProductos();

					}
					
					entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivoSer));
					entity.setFechaEstadoVehiculo(fechaEntrada1);
					entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccionSer));
					entity.setDestinoProduccion(FacesUtils.checkString(txtDestinoProduccionSer));
					entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistroSer));
					entity.setObservacion(FacesUtils.checkString(txtObservacionSer));
					entity.setObservacion2(FacesUtils.checkString(txtObservacion2));
					entity.setOrigen(FacesUtils.checkString(txtOrigen));
					entity.setNoDocumento(FacesUtils.checkString(txtNoDocumentoSer));
					entity.setTransportadora((FacesUtils.checkLong(txtTranspId_TransportadoraSer)));
					entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicionalSer));
					entity.setVagon1((FacesUtils.checkString(txtVagon1Ser)));
					entity.setVagon2((FacesUtils.checkString(txtVagon2Ser)));
					entity.setVagon3((FacesUtils.checkString(txtVagon3Ser)));
					entity.setFechaEntrada(FacesUtils.checkDate(txtFechaEntradaSer));
					entity.setFechaSalida(FacesUtils.checkDate(txtFechaSalidaSer));
					entity.setFechaPesoNeto(FacesUtils.checkDate(txtFechaSalidaSer));
					entity.setFechaTara(FacesUtils.checkDate(txtFechaSalidaSer));
					entity.setFechaPesoBruto(FacesUtils.checkDate(txtFechaEntradaSer));
					entity.setPesoTara(pesoTara1);
					entity.setPesoBruto(pesoBruto1);
					entity.setVehiculoId(idEquipo);
					entity.setConductor(idTrabajador);
					entity.setEstado("A");
					entity.setCompania(compania);
					entity.setUsuarioDigitacion(usuarioId);
					entity.setFechaModificacion(date);		
					
						if(entity.getConsecutivoPesoNeto() ==null) {
						
						if(entity.getPesoNeto()!=null && entity.getPesoNeto() >0) {
							entity.setConsecutivoPesoNeto(
									businessDelegator2View.consultarConsecutivoDatTransProdPesoNeto(compania));
						}
					}
	
					businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
							dataPlanillaDet);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

					entityLog.setTiquete(entity.getConsecutivo());
					entityLog.setCompania(compania);
					entityLog.setUsuarioModificacion(usuarioId);
					Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
					entityLog.setFecha(date);

					Long consecutivo = null;
					String tipoTrans = "";
					String fechaRegistro = "";
					String vagon1 = "";
					String vagon2 = "";
					String vagon3 = "";
					String sellos = "";
					String acidez = "";
					String humedad = "";
					String impurezas = "";
					String observacion = "";
					String destinoProduccion = "";
					String observacion2 = "";
					String observacion3 = "";
					String pesoTara = "";
					String pesoBruto = "";
					String pesoNeto = "";
					String fechaEntrada = "";
					String fechaSalida = "";

					if (entity.getConsecutivo() != null) {
						consecutivo = entity.getConsecutivo();
					}

					if (entity.getTipoTransaccion() != null) {
						tipoTrans = entity.getTipoTransaccion();
					}

					if (entity.getFechaRegistro() != null) {
						fechaRegistro = entity.getFechaRegistro().toString();
					}

					if (entity.getVagon1() != null) {
						vagon1 = entity.getVagon1().toString();
					}

					if (entity.getVagon2() != null) {
						vagon2 = entity.getVagon2().toString();
					}

					if (entity.getVagon3() != null) {
						vagon3 = entity.getVagon3().toString();
					}

					if (entity.getSello1() != null) {
						sellos = entity.getSello1().toString() ;
					}
					
					if (entity.getSello2() != null) {
						sellos = sellos + "-" + entity.getSello2().toString() ;
					}
					
					if (entity.getSello3() != null) {
						sellos = sellos + "-" + entity.getSello3().toString() ;
					}	
					
					if (entity.getSello4() != null) {
						sellos = sellos + "-" + entity.getSello4().toString() ;
					}
					
					if (entity.getSello5() != null) {
						sellos = sellos + "-" + entity.getSello5().toString() ;
					}	
					
					if (entity.getSello6() != null) {
						sellos = sellos + "-" + entity.getSello6().toString() ;
					}
					
					if (entity.getSello7() != null) {
						sellos = sellos + "-" + entity.getSello7().toString() ;
					}	
					
					if (entity.getSello8() != null) {
						sellos = sellos + "-" + entity.getSello8().toString() ;
					}
					
					if (entity.getSello9() != null) {
						sellos = sellos + "-" + entity.getSello9().toString() ;
					}
					
					if (entity.getSello10() != null) {
						sellos = sellos + "-" + entity.getSello10().toString() ;
					}

					if (entity.getVariable1() != null) {
						acidez = entity.getVariable1().toString();
					}

					if (entity.getVariable2() != null) {
						humedad = entity.getVariable2().toString();
					}

					if (entity.getVariableTexto1() != null) {
						impurezas = entity.getVariableTexto1().toString();
					}

					if (entity.getObservacion() != null) {
						observacion = entity.getObservacion().toString();
					}

					if (entity.getDestinoProduccion() != null) {
						destinoProduccion = entity.getDestinoProduccion().toString();
					}

					if (entity.getObservacion2() != null) {
						observacion2 = entity.getObservacion2().toString();
					}

					if (entity.getObservacion3() != null) {
						observacion3 = entity.getObservacion3().toString();
					}

					if (entity.getPesoTara() != null) {
						pesoTara = entity.getPesoTara().toString();
					}

					if (entity.getPesoBruto() != null) {
						pesoBruto = entity.getPesoBruto().toString();
					}

					if (entity.getPesoNeto() != null) {
						pesoNeto = entity.getPesoNeto().toString();
					}

					if (entity.getFechaEntrada() != null) {
						fechaEntrada = entity.getFechaEntrada().toString();
					}

					if (entity.getFechaSalida() != null) {
						fechaSalida = entity.getFechaSalida().toString();
					}

					String equipo = equipo1.getNombre();
					String conductor = trabajador1.getNombre();
					String codusuario = usuario.getLogin();

					String valoresFinalesTiquete = "Valores finales: Tiquete: " + consecutivo.toString()
							+ " TipoTransaccion: " + tipoTrans.toString() + " Fecha registro: " + fechaRegistro
							+ " Equipo: " + equipo + " Conductor: " + conductor + " Vagón 1: " + vagon1 + " Vagón 2: "
							+ vagon2 + " Vagón 3: " + vagon3 + " Destino de producción: " + destinoProduccion
							+ " Peso tara: " + pesoTara + " Peso bruto: " + pesoBruto + " Peso neto: " + pesoNeto
							+ " Fecha entrada: " + fechaEntrada + " Fecha salida: " + fechaSalida + " Sellos: " + sellos
							+ " Acidez: " + acidez + " Humedad: " + humedad + " Impurezas: " + impurezas
							+ " Observación: " + observacion + "Observacion 2: " + observacion2 + "Observacion 3: "
							+ observacion3;

					entityLog.setObservacion(
							"El tiquete:" + "  " + consecutivo.toString() + " Fue modificado por el usuario: "
									+ codusuario + " " + cambioTiquete + " " + valoresFinalesTiquete);

					businessDelegatorView.saveLogBascula(entityLog);

					action_clear();
					estadoGrabar = false;
				}

				cargarTiquetesCorrecion();

			} else {
				
				PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(
						  FacesMessage.SEVERITY_ERROR, "Error!",
						  "El vehiculo o el conductor no son validos o no existen, porfavor seleccione uno existente o creelo "
						  ));
				
			

				limpiar_vehiculoConductor();
			}

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
			businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
					dataPlanillaDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public void onCellEditNivel4(CellEditEvent event) throws Exception {

		Long datTransProdId = FacesUtils.checkLong(txtDatTransProdId);
		if (datTransProdId != null) {
			selectedDatTransNivel4 = (DatTransProdNivel4DTO) (event.getComponent().getAttributes()
					.get("selectedDatTransNivel4"));

			Long datTransProdNivel4Id = selectedDatTransNivel4.getDatTransProdNivel4Id().longValue();
			String columnaCell = event.getColumn().getHeaderText();

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityDatTransProdNivel4 = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);

				if (columnaCell.equals("Prod.")) {

					Long productoId = new Long(event.getNewValue().toString());
					Producto producto = businessDelegatorView.getProducto(productoId);

					entityDatTransProdNivel4.setProducto(producto);

				}

				if (columnaCell.equals("Variedad")) {

					Long variedId = new Long(event.getNewValue().toString());
					Variedad variedad = businessDelegatorView.getVariedad(variedId);

					entityDatTransProdNivel4.setVariedNivel4(variedad);

				}

				if (columnaCell.equals("Tipo cosecha")) {

					Long modalidadCosechaId = new Long(event.getNewValue().toString());
					ModalidadCosecha modalidadCosecha = businessDelegatorView.getModalidadCosecha(modalidadCosechaId);

					entityDatTransProdNivel4.setModalidadCosId(modalidadCosecha);

				}
				if (columnaCell.equals("Proveedor")) {

					Long proveedorId = new Long(event.getNewValue().toString());
					PersEmpr proveedor = businessDelegatorView.getPersEmpr(proveedorId);

					entityDatTransProdNivel4.setClienteId(proveedor);

				}
				if (columnaCell.equals("Finca")) {

					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityDatTransProdNivel4.setNivel2(nivel2);

				}
				entity = businessDelegatorView.getDatTransProd(datTransProdId);
				entityDatTransProdNivel4.setDatTransProd(entity);
				businessDelegatorView.updateDatTransProdNivel4(entityDatTransProdNivel4);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataDetTransNivel4 = null;
				entityDatTransProdNivel4 = null;
				selectedDatTransNivel4 = null;

				dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(datTransProdId);
			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditProd(CellEditEvent event) throws Exception {

		Long datTransProdId = null;

		if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

			datTransProdId = (Long) txtDatTransProdIdDes.getValue();

		} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

			datTransProdId = (Long) txtDatTransProdIdSer.getValue();
		}

		selectedDatTransProdDet = (DatTransProdDetDTO) (event.getComponent().getAttributes()
				.get("selectedDatTransProdDet"));

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		Long datTransProdDetId = selectedDatTransProdDet.getDatTransProdDetId().longValue();
		String columnaCell = event.getColumn().getHeaderText();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityDatTransProdDet = null;
			entityDatTransProdDet = businessDelegatorView.getDatTransProdDet(datTransProdDetId);

			if (columnaCell.equals("Clientes")) {

				Long persEmprId = new Long(event.getNewValue().toString());
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);

				entityDatTransProdDet.setCliente(persEmpr);

			} else if (columnaCell.equals("Ciudad")) {

				Long ciudadId = new Long(event.getNewValue().toString());
				Ciudad ciudad = businessDelegatorView.getCiudad(ciudadId);

				entityDatTransProdDet.setCiudad(ciudad);

			} else if (columnaCell.equals("Prod.")) {

				Long productoId = new Long(event.getNewValue().toString());
				Producto producto = businessDelegatorView.getProducto(productoId);

				entityDatTransProdDet.setProducto(producto);

			} else if (columnaCell.equals("U.M")) {

				Long UdadMedId = new Long(event.getNewValue().toString());
				UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

				entityDatTransProdDet.setUdadMed(udadMed);

			} else if (columnaCell.equals("Cant. solicitada")) {

				entityDatTransProdDet.setCantidadReal((Double) newValue);

			} else if (columnaCell.equals("V. Factura")) {

				entityDatTransProdDet.setValorTotal((Double) newValue);

			} else if (columnaCell.equals("C. Aceite")) {

				entityDatTransProdDet.setCertificacionAceite((String) newValue);

			}

			entity = businessDelegatorView.getDatTransProd(datTransProdId);
			entityDatTransProdDet.setDatTransProd(entity);
			businessDelegatorView.updateDatTransProdDet(entityDatTransProdDet);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			columnaCell = null;
			oldValue = null;
			newValue = null;
			dataDetTransProductos = null;
			entityDatTransProdDet = null;
			selectedDatTransProdDet = null;

			dataDetTransProductos = businessDelegatorView.getDataDetTransProductosByDatTransProdId(datTransProdId);

		}

	}

	public void onCellEditPlanilla(CellEditEvent event) throws Exception {
		Long datTransProdId = FacesUtils.checkLong(txtDatTransProdId);
		if (datTransProdId != null) {

			selectedDatPlanillaDet = (DatTransProdTrabajadoresDTO) (event.getComponent().getAttributes()
					.get("selectedDatPlanillaDet"));

			Long datTransProdTrabajadoresId = selectedDatPlanillaDet.getDatTransProdTrabajadoresId().longValue();
			String columnaCell = event.getColumn().getHeaderText();

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityDatTransProdTrabajadores = businessDelegatorView
						.getDatTransProdTrabajadores(datTransProdTrabajadoresId);

				if (columnaCell.equals("Hda")) {

					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityDatTransProdTrabajadores.setNivel2(nivel2);

				} else if (columnaCell.equals("Lote")) {

					Long nivel4Id = new Long(event.getNewValue().toString());
					Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

					entityDatTransProdTrabajadores.setNivel4(nivel4);

				} else if (columnaCell.equals("Labor")) {

					Long laborId = new Long(event.getNewValue().toString());
					Labor labor = businessDelegatorView.getLabor(laborId);

					entityDatTransProdTrabajadores.setLabor(labor);

				} else if (columnaCell.equals("Trabajador")) {

					Long trabajadorId = new Long(event.getNewValue().toString());
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

					entityDatTransProdTrabajadores.setTrabajador(trabajador);

				} else if (columnaCell.equals("Concepto")) {

					Long conceptoNominaId = new Long(event.getNewValue().toString());
					ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);

					entityDatTransProdTrabajadores.setCeptoNominaId(conceptoNomina);

				} else if (columnaCell.equals("U.M(Pago)")) {

					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

					entityDatTransProdTrabajadores.setUdadMed(udadMed);

				} else if (columnaCell.equals("Cantidad")) {

					entityDatTransProdTrabajadores.setCantidadPago((Double) newValue);

				} else if (columnaCell.equals("Cant. Descontar")) {

					entityDatTransProdTrabajadores.setCantidadDescontar((Double) newValue);

				} else if (columnaCell.equals("P.Promedio")) {

					entityDatTransProdTrabajadores.setPesoPromedio((Double) newValue);

				} else if (columnaCell.equals("Tarifa")) {

					entityDatTransProdTrabajadores.setValorUnitario((Double) newValue);

				} else if (columnaCell.equals("C. Total")) {

					entityDatTransProdTrabajadores.setCostoTotal((Double) newValue);

				}
				entity = businessDelegatorView.getDatTransProd(datTransProdId);
				entityDatTransProdTrabajadores.setDatTransProd(entity);
				businessDelegatorView.updateDatTransProdTrabajadores(entityDatTransProdTrabajadores);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataPlanillaDet = null;
				entityDatTransProdTrabajadores = null;
				selectedDatPlanillaDet = null;

				dataPlanillaDet = businessDelegatorView.getDataDatTransProdTrabajadoresByTrabajador(datTransProdId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public Date getDateFechaInicial() {
		return dateFechaInicial;
	}

	public void setDateFechaInicial(Date dateFechaInicial) {
		this.dateFechaInicial = dateFechaInicial;
	}

	public Date getDateFechaFinal() {
		return dateFechaFinal;
	}

	public void setDateFechaFinal(Date dateFechaFinal) {
		this.dateFechaFinal = dateFechaFinal;
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

	public InputText getTxtEtapaNivel4() {
		return txtEtapaNivel4;
	}

	public void setTxtEtapaNivel4(InputText txtEtapaNivel4) {
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

	public InputText getTxtObservacion2() {
		return txtObservacion2;
	}

	public void setTxtObservacion2(InputText txtObservacion2) {
		this.txtObservacion2 = txtObservacion2;
	}

	public InputText getTxtObservacion2Des() {
		return txtObservacion2Des;
	}

	public void setTxtObservacion2Des(InputText txtObservacion2Des) {
		this.txtObservacion2Des = txtObservacion2Des;
	}

	public InputTextarea getTxtObservacion3() {
		return txtObservacion3;
	}

	public void setTxtObservacion3(InputTextarea txtObservacion3) {
		this.txtObservacion3 = txtObservacion3;
	}

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtTipoTransaccion() {
		return txtTipoTransaccion;
	}

	public void setTxtTipoTransaccion(InputText txtTipoTransaccion) {
		this.txtTipoTransaccion = txtTipoTransaccion;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputText getTxtVariedNivel4() {
		return txtVariedNivel4;
	}

	public void setTxtVariedNivel4(InputText txtVariedNivel4) {
		this.txtVariedNivel4 = txtVariedNivel4;
	}

	public AutoComplete getTxtConductorId_Conductor() {
		return txtConductorId_Conductor;
	}

	public void setTxtConductorId_Conductor(AutoComplete txtConductorId_Conductor) {
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

	public AutoComplete getTxtVehiTranspId_VehiculosTransp() {
		return txtVehiTranspId_VehiculosTransp;
	}

	public void setTxtVehiTranspId_VehiculosTransp(AutoComplete txtVehiTranspId_VehiculosTransp) {
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

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputText getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(InputText txtValorTotal) {
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

	public LazyDataModel<DatTransProdDTO> getData() {
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

	public void rowEventEditDetTransProdListener(RowEditEvent e) {

		try {

			DatTransProdDetDTO datTransProdDet = (DatTransProdDetDTO) e.getObject();

			txtAreaCosechada.setDisabled(false);
			txtCantidadSolicitada.setDisabled(false);
			txtCantidadSolicitada.setDisabled(false);
			txtValorUnitario.setDisabled(false);
			txtValorTotal.setDisabled(false);
			txtClienteDet.setDisabled(false);
			txtUdadMed.setDisabled(false);
			txtCiudad.setDisabled(false);
			txtProducto.setDisabled(false);
			btnAgregar.setDisabled(false);

			if (txtProducto == null) {
				txtProducto = new SelectOneMenu();
			}

			txtProducto.setValue(datTransProdDet.getProductoId_Producto());

			if (txtUdadMed == null) {
				txtUdadMed = new SelectOneMenu();
			}

			txtUdadMed.setValue(datTransProdDet.getUdadMedId_UdadMed());

			if (txtAreaCosechada == null) {
				txtAreaCosechada = new InputText();

			}

			txtAreaCosechada.setValue(datTransProdDet.getAreaCosechada());

			if (txtCantidadSolicitada == null) {
				txtCantidadSolicitada = new InputText();
			}

			txtCantidadSolicitada.setValue(datTransProdDet.getCantidadSolicitada());

			if (txtCantidadSolicitada == null) {
				txtCantidadSolicitada = new InputText();
			}

			txtCantidadSolicitada.setValue(datTransProdDet.getCantidadReal());

			if (txtValorUnitario == null) {
				txtValorUnitario = new InputText();
			}

			txtValorUnitario.setValue(datTransProdDet.getValorUnitario());

			if (txtValorTotal == null) {
				txtValorTotal = new InputText();
			}

			txtValorTotal.setValue(datTransProdDet.getValorTotal());

			if (txtClienteDet == null) {
				txtClienteDet = new SelectOneMenu();
			}

			txtClienteDet.setValue(datTransProdDet.getClienteId_Cliente());

			if (txtCiudad == null) {
				txtCiudad = new SelectOneMenu();
			}

			txtCiudad.setValue(datTransProdDet.getCiudadId_Ciudad());

			if (txtEmpaque == null) {
				txtEmpaque = new SelectOneMenu();
			}

			txtEmpaque.setValue(datTransProdDet.getEmpaqueId_Empaque());

			dataDetTransProductos = new ArrayList<DatTransProdDetDTO>();
			dataDetTransProductos.add(datTransProdDet);

		} catch (Exception ex) {
		}

	}

	public String actionDeleteDatTransProdDet(ActionEvent evt) throws Exception {
		
		try {
		
			AutoComplete vehiculo = null;
			AutoComplete trabajador = null;
			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
	
			if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {
				
				vehiculo = txtVehiTranspId_VehiculosTranspDes;
				trabajador = txtConductorId_ConductorDes;
				codigoEquipo = (String) txtVehiTranspId_VehiculosTranspDes.getValue();
				codigoTrabajador = (String) txtConductorId_ConductorDes.getValue();
	
			} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {
				
				vehiculo = txtVehiTranspId_VehiculosTranspSer;
				trabajador = txtConductorId_ConductorSer;
				codigoEquipo = (String) txtVehiTranspId_VehiculosTranspSer.getValue();
				codigoTrabajador = (String) txtConductorId_ConductorSer.getValue();
			}
			
	
			if (codigoEquipo != null && codigoTrabajador != null) {
	
				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);
	
				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
				}
	
				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
	
				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
				}
			}

			selectedDatTransProdDet = (DatTransProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatTransProdDet"));
			
			vehiculo.setValue(equipo1);
			trabajador.setValue(trabajador1);

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

	public String actionDeleteDatTransProdNivel4(ActionEvent evt) throws Exception {
		
		try {
		
			String codigoEquipo = null;
			String codigoTrabajador = null;
			Trabajador trabajador1 = null;
			Equipo equipo1 = null;
		
			codigoEquipo = (String) txtVehiTranspId_VehiculosTransp.getValue();
			codigoTrabajador = (String) txtConductorId_Conductor.getValue();
			
		
			if (codigoEquipo != null && codigoTrabajador != null) {
		
				Object[] condicion1 = { "equipoId", true, codigoEquipo, "=", };
				List<Equipo> lista1 = businessDelegatorView.findByCriteriaInEquipo(condicion1, null, null);
		
				if (lista1.size() > 0) {
					equipo1 = lista1.get(0);
				}
		
				Object[] condicion = { "trabId", true, codigoTrabajador, "=", };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
		
				if (lista.size() > 0) {
					trabajador1 = lista.get(0);
				}
			}
			
			txtVehiTranspId_VehiculosTransp.setValue(equipo1);
			txtConductorId_Conductor.setValue(trabajador1);

			selectedDatTransNivel4 = (DatTransProdNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedDatTransNivel4"));

			if (selectedDatTransNivel4.getDatTransProdNivel4Id() == null) {
				dataDetTransNivel4.remove(selectedDatTransNivel4);
			} else {
				Long datTransProdNivel4Id = new Long(selectedDatTransNivel4.getDatTransProdNivel4Id());
				DatTransProdNivel4 entity = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
				businessDelegatorView.deleteDatTransProdNivel4(entity);
				dataDetTransNivel4.remove(selectedDatTransNivel4);
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

	public SelectItem[] getSelectNivel2() {

		if (nivel2 == null || nivel2.size() == 0) {

			nivel2 = new ArrayList<Nivel2>();

			try {

				nivel2 = businessDelegatorView.getNivel2();
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

	public SelectItem[] getselectNivel3() {

		nivel3 = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2Id != null && txtNivel2Id.getValue() != null && !txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3 = nivel2.getNivel3s().toArray();

				selectNivel3 = new SelectItem[niveles3.length];

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

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

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

			try {

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

			try {

				Object[] condicion = { "estado", true, "A", "=", };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectCliente = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr cliente : lista) {
					selectCliente[i] = new SelectItem(cliente.getPersEmprId(),
							cliente.getNombre() + " || CERTIFICADO RPSO: " + cliente.getCertificacion());
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

	public SelectItem[] getSelectClienteSer() {

		if (clienteSer == null || clienteSer.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectClienteSer = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr cliente : lista) {
					selectClienteSer[i] = new SelectItem(cliente.getPersEmprId(),
							cliente.getNombre() + " || CERTIFICADO RPSO: " + cliente.getCertificacion());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectClienteSer;

	}

	public void setSelectClienteSer(SelectItem[] selectClienteSer) {
		this.selectClienteSer = selectClienteSer;
	}

	public SelectItem[] getselectFrenteCos() {

		if (frenteCos == null || frenteCos.size() == 0) {

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

			try {
				ciudad = businessDelegatorView.getCiudad();
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

	public SelectItem[] getSelectCiudadSer() {

		if (ciudadSer == null || ciudadSer.size() == 0) {

			try {
				ciudadSer = businessDelegatorView.getCiudad();
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudadSer = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudad : lista) {
					selectCiudadSer[i] = new SelectItem(ciudad.getCiudadId(), ciudad.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudadSer;

	}

	public void setSelectCiudadSer(SelectItem[] selectCiudadSer) {
		this.selectCiudadSer = selectCiudadSer;
	}

	public SelectItem[] getSelectProductoId() {

		if (productoId == null || productoId.size() == 0) {

			try {
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

	public SelectItem[] getSelectProductoIdSer() {

		if (productoIdSer == null || productoIdSer.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoIdSer = new SelectItem[lista.size()];

				int i = 0;
				for (Producto productoId : lista) {
					selectProductoIdSer[i] = new SelectItem(productoId.getProductoId(), productoId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoIdSer;

	}

	public void setselectProductoIdSer(SelectItem[] selectProductoIdSer) {
		this.selectProductoIdSer = selectProductoIdSer;
	}

	public SelectItem[] getSelectEmpaqueId() {

		if (empaqueId == null || empaqueId.size() == 0) {

			try {

				empaqueId = businessDelegatorView.getEmpaque();
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

	public SelectItem[] getSelectTransportadora() {

		if (transportadora == null || transportadora.size() == 0) {

			try {

				transportadora = businessDelegatorView.getTransportadora();
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

	public void setSelectTransportadora(SelectItem[] selectTransportadora) {
		this.selectTransportadora = selectTransportadora;
	}

	public SelectItem[] getSelectTransportadoraDes() {

		if (transportadoraDes == null || transportadoraDes.size() == 0) {

			try {

				transportadoraDes = businessDelegatorView.getTransportadora();
				Object[] condicion = { "estado", true, "A", "=" };
				List<Transportadora> lista = businessDelegatorView.findByCriteriaInTransportadora(condicion, null,
						null);
				selectTransportadoraDes = new SelectItem[lista.size()];

				int i = 0;
				for (Transportadora transportadora : lista) {
					selectTransportadoraDes[i] = new SelectItem(transportadora.getTranspId(),
							transportadora.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTransportadoraDes;

	}

	public void setSelectTransportadoraDes(SelectItem[] selectTransportadoraDes) {
		this.selectTransportadoraDes = selectTransportadoraDes;
	}

	public SelectItem[] getSelectTransportadoraSer() {

		if (transportadoraSer == null || transportadoraSer.size() == 0) {

			try {

				transportadoraSer = businessDelegatorView.getTransportadora();
				Object[] condicion = { "estado", true, "A", "=" };
				List<Transportadora> lista = businessDelegatorView.findByCriteriaInTransportadora(condicion, null,
						null);
				selectTransportadoraSer = new SelectItem[lista.size()];

				int i = 0;
				for (Transportadora transportadora : lista) {
					selectTransportadoraSer[i] = new SelectItem(transportadora.getTranspId(),
							transportadora.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTransportadoraSer;

	}

	public void setSelectTransportadoraSer(SelectItem[] selectTransportadoraSer) {
		this.selectTransportadoraSer = selectTransportadoraSer;
	}

	public SelectItem[] getselectModalidadCosecha() {

		String tipoTransaccion = FacesUtils.checkString(txtTipoTransaccion);

		if (tipoTransaccion != null) {

			if (modalidadCosecha == null || modalidadCosecha.size() == 0) {

				try {

					modalidadCosecha = businessDelegatorView.getModalidadCosecha();
					Object[] condicion = { "estado", true, "A", "=" };
					List<ModalidadCosecha> lista = businessDelegatorView.findByCriteriaInModalidadCosecha(condicion,
							null, null);
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

		}

		return selectModalidadCosecha;

	}

	public String action_saveAnularReg() {
		try {
			Long id = null;
			if (entity == null) {
				id = new Long(selectedDatBasculaTiquete.getDat_trans_prod_id().longValue());
				entity = businessDelegatorView.getDatTransProd(id);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());

			Long idBascula = FacesUtils.checkLong(txtDatTransProdId);
			entityLog = new LogBascula();

			dataDetTransProductos = null;
			dataDetTransProductos = businessDelegatorView.getDataDetTransProductosByDatTransProdId(idBascula);

			dataDetTransNivel4 = null;
			dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(idBascula);

			dataPlanillaDet = null;
			dataPlanillaDet = businessDelegatorView.getDataDatTransProdTrabajadoresByTrabajador(idBascula);

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
					dataPlanillaDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);

			Long consecutivo = entity.getConsecutivo();

			entityLog.setTiquete(consecutivo);
			entityLog.setCompania(compania);
			entityLog.setUsuarioModificacion(usuarioId);
			Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
			entityLog.setFecha(date);

			String codusuario = usuario.getLogin();
			String tipoTrans = FacesUtils.checkString(txtTipoTransaccion);
			entityLog.setObservacion("El tiquete:" + "  " + consecutivo.toString() + " Fue modificado por el usuario: "
					+ codusuario + " y es de tipo: " + tipoTrans);

			businessDelegatorView.saveLogBascula(entityLog);
			
			cargarTiquetesCorrecion();
			action_clear();
			data = null;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		action_clear();
		selectedDatBasculaTiquete = (TiquetesBasculaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatBasculaTiquete"));
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

	public InputText getTxtValorDeduccion() {
		return txtValorDeduccion;
	}

	public void setTxtValorDeduccion(InputText txtValorDeduccion) {
		this.txtValorDeduccion = txtValorDeduccion;
	}

	public InputText getTxtValorNeto() {
		return txtValorNeto;
	}

	public void setTxtValorNeto(InputText txtValorNeto) {
		this.txtValorNeto = txtValorNeto;
	}

	public InputText getTxtCantidadKilosLiq() {
		return txtCantidadKilosLiq;
	}

	public void setTxtCantidadKilosLiq(InputText txtCantidadKilosLiq) {
		this.txtCantidadKilosLiq = txtCantidadKilosLiq;
	}

	public Calendar getTxtFechaInicioCosecha() {
		return txtFechaInicioCosecha;
	}

	public void setTxtFechaInicioCosecha(Calendar txtFechaInicioCosecha) {
		this.txtFechaInicioCosecha = txtFechaInicioCosecha;
	}

	public Calendar getTxtFechaFinCosecha() {
		return txtFechaFinCosecha;
	}

	public void setTxtFechaFinCosecha(Calendar txtFechaFinCosecha) {
		this.txtFechaFinCosecha = txtFechaFinCosecha;
	}

	public InputText getTxtBasculaPesoBruto() {
		return txtBasculaPesoBruto;
	}

	public void setTxtBasculaPesoBruto(InputText txtBasculaPesoBruto) {
		this.txtBasculaPesoBruto = txtBasculaPesoBruto;
	}

	public InputText getTxtBasculaTara() {
		return txtBasculaTara;
	}

	public void setTxtBasculaTara(InputText txtBasculaTara) {
		this.txtBasculaTara = txtBasculaTara;
	}

	public InputTextarea getTxtNumeroSellos() {
		return txtNumeroSellos;
	}

	public void setTxtNumeroSellos(InputTextarea txtNumeroSellos) {
		this.txtNumeroSellos = txtNumeroSellos;
	}

	public InputNumber getTxtPesoBruto() {
		return txtPesoBruto;
	}

	public void setTxtPesoBruto(InputNumber txtPesoBruto) {
		this.txtPesoBruto = txtPesoBruto;
	}

	public InputText getTxtPesoNeto() {
		return txtPesoNeto;
	}

	public void setTxtPesoNeto(InputText txtPesoNeto) {
		this.txtPesoNeto = txtPesoNeto;
	}

	public InputNumber getTxtPesoTara() {
		return txtPesoTara;
	}

	public void setTxtPesoTara(InputNumber txtPesoTara) {
		this.txtPesoTara = txtPesoTara;
	}

	public InputText getTxtUsuarioPesoBruto() {
		return txtUsuarioPesoBruto;
	}

	public void setTxtUsuarioPesoBruto(InputText txtUsuarioPesoBruto) {
		this.txtUsuarioPesoBruto = txtUsuarioPesoBruto;
	}

	public InputText getTxtUsuarioPesoTara() {
		return txtUsuarioPesoTara;
	}

	public void setTxtUsuarioPesoTara(InputText txtUsuarioPesoTara) {
		this.txtUsuarioPesoTara = txtUsuarioPesoTara;
	}

	public InputText getTxtVagon1() {
		return txtVagon1;
	}

	public void setTxtVagon1(InputText txtVagon1) {
		this.txtVagon1 = txtVagon1;
	}

	public InputText getTxtVagon2() {
		return txtVagon2;
	}

	public void setTxtVagon2(InputText txtVagon2) {
		this.txtVagon2 = txtVagon2;
	}

	public InputText getTxtVagon3() {
		return txtVagon3;
	}

	public void setTxtVagon3(InputText txtVagon3) {
		this.txtVagon3 = txtVagon3;
	}

	public Calendar getTxtFechaEntrada() {
		return txtFechaEntrada;
	}

	public void setTxtFechaEntrada(Calendar txtFechaEntrada) {
		this.txtFechaEntrada = txtFechaEntrada;
	}

	public Calendar getTxtFechaPesoBruto() {
		return txtFechaPesoBruto;
	}

	public void setTxtFechaPesoBruto(Calendar txtFechaPesoBruto) {
		this.txtFechaPesoBruto = txtFechaPesoBruto;
	}

	public Calendar getTxtFechaPesoNeto() {
		return txtFechaPesoNeto;
	}

	public void setTxtFechaPesoNeto(Calendar txtFechaPesoNeto) {
		this.txtFechaPesoNeto = txtFechaPesoNeto;
	}

	public Calendar getTxtFechaSalida() {
		return txtFechaSalida;
	}

	public void setTxtFechaSalida(Calendar txtFechaSalida) {
		this.txtFechaSalida = txtFechaSalida;
	}

	public Calendar getTxtFechaTara() {
		return txtFechaTara;
	}

	public void setTxtFechaTara(Calendar txtFechaTara) {
		this.txtFechaTara = txtFechaTara;
	}

	public InputTextarea getTxtObservacionAnalisis() {
		return txtObservacionAnalisis;
	}

	public void setTxtObservacionAnalisis(InputTextarea txtObservacionAnalisis) {
		this.txtObservacionAnalisis = txtObservacionAnalisis;
	}

	public InputText getTxtVariable1() {
		return txtVariable1;
	}

	public void setTxtVariable1(InputText txtVariable1) {
		this.txtVariable1 = txtVariable1;
	}

	public InputText getTxtVariable2() {
		return txtVariable2;
	}

	public void setTxtVariable2(InputText txtVariable2) {
		this.txtVariable2 = txtVariable2;
	}



	public InputText getTxtVariable4() {
		return txtVariable4;
	}

	public void setTxtVariable4(InputText txtVariable4) {
		this.txtVariable4 = txtVariable4;
	}

	public Spinner getTxtVariable5() {
		return txtVariable5;
	}

	public void setTxtVariable5(Spinner txtVariable5) {
		this.txtVariable5 = txtVariable5;
	}

	public Spinner getTxtVariable6() {
		return txtVariable6;
	}

	public void setTxtVariable6(Spinner txtVariable6) {
		this.txtVariable6 = txtVariable6;
	}

	public InputText getTxtVariable7() {
		return txtVariable7;
	}

	public void setTxtVariable7(InputText txtVariable7) {
		this.txtVariable7 = txtVariable7;
	}

	public InputText getTxtVariable8() {
		return txtVariable8;
	}

	public void setTxtVariable8(InputText txtVariable8) {
		this.txtVariable8 = txtVariable8;
	}

	public InputText getTxtVariable9() {
		return txtVariable9;
	}

	public void setTxtVariable9(InputText txtVariable9) {
		this.txtVariable9 = txtVariable9;
	}

	public InputText getTxtVariable10() {
		return txtVariable10;
	}

	public void setTxtVariable10(InputText txtVariable10) {
		this.txtVariable10 = txtVariable10;
	}

	public SelectOneMenu getTxtProductoCos() {
		return txtProductoCos;
	}

	public void setTxtProductoCos(SelectOneMenu txtProductoCos) {
		this.txtProductoCos = txtProductoCos;
	}

	public InputText getTxtNombreProductoCos() {
		return txtNombreProductoCos;
	}

	public void setTxtNombreProductoCos(InputText txtNombreProductoCos) {
		this.txtNombreProductoCos = txtNombreProductoCos;
	}

	public SelectItem[] getSelectProductoCosId() {

		if (productoCosId == null || productoCosId.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "flujoMovimiento", true, "Materia prima", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoCosId = new SelectItem[lista.size()];

				int i = 0;
				for (Producto productoCosId : lista) {
					selectProductoCosId[i] = new SelectItem(productoCosId.getProductoId(), productoCosId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoCosId;

	}

	public void setSelectProductoCosId(SelectItem[] selectProductoCosId) {
		this.selectProductoCosId = selectProductoCosId;
	}

	/**** sesion consulta tiquetes de bascula creados ****/
	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public Calendar getTxtFechaInicialConsulta() {
		return txtFechaInicialConsulta;
	}

	public void setTxtFechaInicialConsulta(Calendar txtFechaInicialConsulta) {
		this.txtFechaInicialConsulta = txtFechaInicialConsulta;
	}

	public Calendar getTxtFechaFinalConsulta() {
		return txtFechaFinalConsulta;
	}

	public void setTxtFechaFinalConsulta(Calendar txtFechaFinalConsulta) {
		this.txtFechaFinalConsulta = txtFechaFinalConsulta;
	}

	public SelectOneMenu getSelectedTipoTransaccion() {
		return selectedTipoTransaccion;
	}

	public void setSelectedTipoTransaccion(SelectOneMenu selectedTipoTransaccion) {
		this.selectedTipoTransaccion = selectedTipoTransaccion;
	}

	public SelectOneMenu getSelectedEstadoTiquete() {
		return selectedEstadoTiquete;
	}

	public void setSelectedEstadoTiquete(SelectOneMenu selectedEstadoTiquete) {
		this.selectedEstadoTiquete = selectedEstadoTiquete;
	}

	public InputText getSelectedTiquete() {
		return selectedTiquete;
	}

	public void setSelectedTiquete(InputText selectedTiquete) {
		this.selectedTiquete = selectedTiquete;
	}

	public List<TiquetesBasculaImprimirProdDTO> getData3() {
		return data3;
	}

	public void setData3(List<TiquetesBasculaImprimirProdDTO> data3) {
		this.data3 = data3;
	}

	public List<TiquetesBasculaImprimirDespachosDTO> getData4() {
		return data4;
	}

	public void setData4(List<TiquetesBasculaImprimirDespachosDTO> data4) {
		this.data4 = data4;
	}

	public List<DatTransProd> getTiquetes() {
		if (tiquetes == null || tiquetes.size() == 0) {

			
			try {
				tiquetes = businessDelegatorView.getDatTransProd();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return tiquetes;

	}

	public void setTiquetes(List<DatTransProd> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public TiquetesBasculaDTO getSelectedDatBasculaTiquete() {
		return selectedDatBasculaTiquete;
	}

	public void setSelectedDatBasculaTiquete(TiquetesBasculaDTO selectedDatBasculaTiquete) {
		this.selectedDatBasculaTiquete = selectedDatBasculaTiquete;
	}

	public Long getConsecutivoT() {
		return consecutivoT;
	}

	public void setConsecutivoT(Long consecutivoT) {
		this.consecutivoT = consecutivoT;
	}

	/********* impresión del tiquete producto ****/
	public List<TiquetesBasculaImprimirProdDTO> getDataTiqueteProduccion() {

		try {
			// Long compania = 1L;
			Long compania = new Long(getCompaniaIdSession());

			if (compania != null && consecutivoT != null) {

				data3 = businessDelegatorView.consultarTiqueteBasculaImprimirProd(compania, consecutivoT);
				setShowDialog(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data3;
	}

	/**************************************************/
	/*** corrección de tiquet action_corregir ***/

	public void action_corregir(ActionEvent evt) {
		selectedDatBasculaTiquete = (TiquetesBasculaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatBasculaTiquete"));

		try {

			Long datTransProdId = selectedDatBasculaTiquete.getDat_trans_prod_id().longValue();
			Object[] condicion = { "datTransProdId", true, datTransProdId, "=" };
			List<DatTransProd> lista = (datTransProdId != null)
					? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				String vagon1 = "";
				String vagon2 = "";
				String vagon3 = "";
				String pesoTara = "";
				String pesoBruto = "";
				String pesoNeto = "";
				String fechaEntrada = "";
				String fechaSalida = "";
				String sello1 = "";
				String sello2 = "";
				String sello3 = "";
				String sello4 = "";
				String sello5 = "";
				String acidez = "";
				String humedad = "";
				String impurezas = "";
				String observacion = "";
				String destinoProduccion = "";
				String conductor = "";
				String equipo = "";

				if (entity.getVagon1() != null) {
					vagon1 = entity.getVagon1().toString();
				}

				if (entity.getVagon2() != null) {
					vagon2 = entity.getVagon2().toString();
				}

				if (entity.getVagon3() != null) {
					vagon3 = entity.getVagon3().toString();
				}

				if (entity.getPesoTara() != null) {
					pesoTara = entity.getPesoTara().toString();
				}

				if (entity.getPesoBruto() != null) {
					pesoBruto = entity.getPesoBruto().toString();
				}

				if (entity.getPesoNeto() != null) {
					pesoNeto = entity.getPesoNeto().toString();
				}

				if (entity.getFechaEntrada() != null) {
					fechaEntrada = entity.getFechaEntrada().toString();
				}

				if (entity.getFechaSalida() != null) {
					fechaSalida = entity.getFechaSalida().toString();
				}

				if (entity.getSello1() != null) {
					sello1 = entity.getSello1().toString();
				}

				if (entity.getSello2() != null) {
					sello2 = entity.getSello2().toString();
				}

				if (entity.getSello3() != null) {
					sello3 = entity.getSello3().toString();
				}

				if (entity.getSello4() != null) {
					sello4 = entity.getSello4().toString();
				}

				if (entity.getSello5() != null) {
					sello5 = entity.getSello5().toString();
				}

				if (entity.getVariable1() != null) {
					acidez = entity.getVariable1().toString();
				}

				if (entity.getVariable2() != null) {
					humedad = entity.getVariable2().toString();
				}

				if (entity.getVariableTexto1() != null) {
					impurezas = entity.getVariableTexto1().toString();
				}

				if (entity.getObservacion() != null) {
					observacion = entity.getObservacion().toString();
				}

				if (entity.getDestinoProduccion() != null) {
					destinoProduccion = entity.getDestinoProduccion().toString();
				}

				if (entity.getConductor() != null) {
					Long conductorId = entity.getConductor();
					Trabajador trab = businessDelegatorView.getTrabajador(conductorId);
					conductor = trab.getNombre();
				}
				if (entity.getVehiculoId() != null) {
					Long vehiculoId = entity.getVehiculoId();
					Equipo equip = businessDelegatorView.getEquipo(vehiculoId);
					equipo = equip.getNombre();
				}

				cambioTiquete = "Valores iniciales: Tiquete: " + entity.getConsecutivo().toString()
						+ " TipoTransaccion: " + entity.getTipoTransaccion().toString() + " Fecha registro: "
						+ entity.getFechaRegistro().toString() + " Equipo: " + equipo + " Conductor: " + conductor +

						" Vagón 1: " + vagon1 + " Vagón 2: " + vagon2 + " Vagón 3: " + vagon3
						+ " Destino de producción: " + destinoProduccion +

						" Peso tara: " + pesoTara + " Peso bruto: " + pesoBruto + " Peso neto: " + pesoNeto
						+ " Fecha entrada: " + fechaEntrada + " Fecha salida: " + fechaSalida +

						" Sellos: " + sello1 + "-" + sello2 + "-" + sello3 + "-" + sello4 + "-" + sello5 + " Acidez: "
						+ acidez + " Humedad: " + humedad + " Impurezas: " + impurezas + " Observación: " + observacion;

				 datTransProdId = entity.getDatTransProdId();

				if (datTransProdId != null && datTransProdId > 0) {

					dataDetTransProductos = null;
					dataDetTransProductos = businessDelegatorView
							.getDataDetTransProductosByDatTransProdId(datTransProdId);

					dataDetTransNivel4 = null;
					dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(datTransProdId);

				}

				String tipoTransaccion = selectedDatBasculaTiquete.getTipo_transaccion();

				if (tipoTransaccion != null && tipoTransaccion.equals("Produccion")) {

					txtConsecutivo.setValue(entity.getConsecutivo());
					txtConsecutivo.setDisabled(true);
					txtConsecutivoNeto.setValue(entity.getConsecutivoPesoNeto());
					txtConsecutivoNeto.setDisabled(true);
					txtVagon1.setValue(entity.getVagon1());
					txtVagon1.setDisabled(false);
					txtVagon2.setValue(entity.getVagon2());
					txtVagon2.setDisabled(false);
					txtVagon3.setValue(entity.getVagon3());
					txtVagon3.setDisabled(false);
					txtInfoAdicional.setValue(entity.getInfoAdicional());
					txtInfoAdicional.setDisabled(false);
					txtFechaRegistro.setValue(entity.getFechaRegistro());
					txtFechaRegistro.setDisabled(true);
					txtObservacion.setValue(entity.getObservacion());
					txtObservacion.setDisabled(false);
					txtNoDocumento.setValue(entity.getNoDocumento());
					txtNoDocumento.setDisabled(false);
					txtFechaEstadoVehiculoPro.setValue(entity.getFechaEstadoVehiculo());
					txtFechaEstadoVehiculoPro.setDisabled(false);

					txtTipoTransaccionDes.setValue("No");
					txtTipoTransaccionSer.setValue("No");
					txtTipoTransaccion.setValue(entity.getTipoTransaccion());
					txtTipoTransaccion.setDisabled(true);

					txtTranspId_Transportadora.setValue(entity.getTransportadora());
					txtTranspId_Transportadora.setDisabled(false);
					txtDatTransProdId.setValue(entity.getDatTransProdId());
					txtDatTransProdId.setDisabled(true);
					txtPesoNeto.setValue(entity.getPesoNeto());
					txtPesoNeto.setDisabled(true);
					txtPesoTara.setValue(entity.getPesoTara());
					txtPesoTara.setDisabled(false);
					txtPesoBruto.setValue(entity.getPesoBruto());
					txtPesoBruto.setDisabled(false);
					txtFechaEntrada.setValue(entity.getFechaEntrada());
					txtFechaEntrada.setDisabled(false);
					txtFechaSalida.setValue(entity.getFechaSalida());
					txtFechaSalida.setDisabled(false);
					if(dataDetTransNivel4!=null && dataDetTransNivel4.size()>0) {
						
						
						txtProductoCos.setDisabled(true);
						txtNivel2Id.setDisabled(true);
					}else {
						txtProductoCos.setDisabled(false);
						txtNivel2Id.setDisabled(false);
					}

					Long trabId = entity.getConductor();
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);

					txtConductorId_Conductor.setValue(trabajador);
					txtConductorId_Conductor.setDisabled(false);

					Long equipoId = entity.getVehiculoId();
					Equipo equipo1 = businessDelegatorView.getEquipo(equipoId);

					txtVehiTranspId_VehiculosTransp.setValue(equipo1);
					txtVehiTranspId_VehiculosTransp.setDisabled(false);
					
					PrimeFaces contextDialog = PrimeFaces.current();
					contextDialog.ajax().update("dialogDatTransProd");

				} else if (tipoTransaccion != null && tipoTransaccion.equals("Despachos - Otros movimientos")) {

					txtConsecutivoDes.setValue(entity.getConsecutivo());
					txtConsecutivoDes.setDisabled(true);
					txtConsecutivoNetoDes.setValue(entity.getConsecutivoPesoNeto());
					txtConsecutivoNetoDes.setDisabled(true);
					txtVagon1Des.setValue(entity.getVagon1());
					txtVagon1Des.setDisabled(false);
					txtVagon2Des.setValue(entity.getVagon2());
					txtVagon2Des.setDisabled(false);
					txtVagon3Des.setValue(entity.getVagon3());
					txtVagon3Des.setDisabled(false);
					txtInfoAdicionalDes.setValue(entity.getInfoAdicional());
					txtInfoAdicionalDes.setDisabled(false);
					txtFechaRegistroDes.setValue(entity.getFechaRegistro());
					txtFechaRegistroDes.setDisabled(true);
					txtObservacionDes.setValue(entity.getObservacion());
					txtObservacionDes.setDisabled(false);
					txtObservacion2Des.setValue(entity.getObservacion2());
					txtObservacion2Des.setDisabled(false);
					txtNoDocumentoDes.setValue(entity.getNoDocumento());
					txtNoDocumentoDes.setDisabled(false);

					txtTipoTransaccion.setValue("No");
					txtTipoTransaccionSer.setValue("No");
					txtTipoTransaccionDes.setValue(entity.getTipoTransaccion());
					txtTipoTransaccionDes.setDisabled(true);

					txtTranspId_TransportadoraDes.setValue(entity.getTransportadora());
					txtTranspId_TransportadoraDes.setDisabled(false);
					txtDatTransProdIdDes.setValue(entity.getDatTransProdId());
					txtDatTransProdIdDes.setDisabled(true);
					txtPesoNetoDes.setValue(entity.getPesoNeto());
					txtPesoNetoDes.setDisabled(true);
					txtPesoTaraDes.setValue(entity.getPesoTara());
					txtPesoTaraDes.setDisabled(false);
					txtPesoBrutoDes.setValue(entity.getPesoBruto());
					txtPesoBrutoDes.setDisabled(false);
					txtFechaEntradaDes.setValue(entity.getFechaEntrada());
					txtFechaEntradaDes.setDisabled(false);
					txtFechaSalidaDes.setValue(entity.getFechaSalida());
					txtFechaSalidaDes.setDisabled(false);
					txtFechaEstadoVehiculoDes.setValue(entity.getFechaEstadoVehiculo());
					txtFechaEstadoVehiculoDes.setDisabled(false);

					Long trabId = entity.getConductor();
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);

					txtConductorId_ConductorDes.setValue(trabajador);
					txtConductorId_ConductorDes.setDisabled(false);

					Long equipoId = entity.getVehiculoId();
					Equipo equipo1 = businessDelegatorView.getEquipo(equipoId);

					txtVehiTranspId_VehiculosTranspDes.setValue(equipo1);
					txtVehiTranspId_VehiculosTranspDes.setDisabled(false);
					
					txtSello1.setDisabled(true);
					txtSello2.setDisabled(true);
					txtSello3.setDisabled(true);
					txtSello4.setDisabled(true);
					txtSello5.setDisabled(true);
					txtSello6.setDisabled(true);
					txtSello7.setDisabled(true);
					txtSello8.setDisabled(true);
					txtSello9.setDisabled(true);
					txtSello10.setDisabled(true);
					txtObservacion3.setDisabled(true);	
					
					if(dataDetTransProductos!=null && dataDetTransProductos.size()>0) {
						
			
					
						DatTransProdDetDTO dataServicios = dataDetTransProductos.get(0);					
						String requiereSellos = dataServicios.getProductoId_Producto().getRequiereSellos();
						
						if (requiereSellos.equals("Si")) {
							
							txtSello1.setDisabled(false);
							txtSello2.setDisabled(false);
							txtSello3.setDisabled(false);
							txtSello4.setDisabled(false);
							txtSello5.setDisabled(false);
							txtSello6.setDisabled(false);
							txtSello7.setDisabled(false);
							txtSello8.setDisabled(false);
							txtSello9.setDisabled(false);
							txtSello10.setDisabled(false);
							txtObservacion3.setDisabled(false);
							
						}		
						
						txtClienteDet.setDisabled(true);
						txtCertificacionAceite.setDisabled(true);
						txtProducto.setDisabled(true);
						txtCiudad.setDisabled(true);
					}else {
						txtClienteDet.setDisabled(false);
						txtCertificacionAceite.setDisabled(false);
						txtProducto.setDisabled(false);
						txtCiudad.setDisabled(false);
					}

					txtSello1.setValue(entity.getSello1());
					txtSello2.setValue(entity.getSello2());
					txtSello3.setValue(entity.getSello3());
					txtSello4.setValue(entity.getSello4());
					txtSello5.setValue(entity.getSello5());
					txtSello6.setValue(entity.getSello6());
					txtSello7.setValue(entity.getSello7());
					txtSello8.setValue(entity.getSello8());
					txtSello9.setValue(entity.getSello9());
					txtSello10.setValue(entity.getSello10());
					txtVariable1.setValue(entity.getVariable1());
					txtVariable2.setValue(entity.getVariable2());
					txtVariableTexto1.setValue(entity.getVariableTexto1());
					txtVariable4.setValue(entity.getVariable4());
					txtObservacion3.setValue(entity.getObservacion3());
					txtDestinoProduccionDes.setValue(entity.getDestinoProduccion());
					txtObservacionAnalisis.setValue(entity.getObservacionAnalisis());
					
					PrimeFaces contextDialog = PrimeFaces.current();
					contextDialog.ajax().update("dialogDatTransProd2");

				} else if (tipoTransaccion != null && tipoTransaccion.equals("Servicios")) {

					txtConsecutivoSer.setValue(entity.getConsecutivo());
					txtConsecutivoSer.setDisabled(true);
					txtConsecutivoNetoSer.setValue(entity.getConsecutivoPesoNeto());
					txtConsecutivoNetoSer.setDisabled(true);
					txtVagon1Ser.setValue(entity.getVagon1());
					txtVagon1Ser.setDisabled(false);
					txtVagon2Ser.setValue(entity.getVagon2());
					txtVagon2Ser.setDisabled(false);
					txtVagon3Ser.setValue(entity.getVagon3());
					txtVagon3Ser.setDisabled(false);
					txtInfoAdicionalSer.setValue(entity.getInfoAdicional());
					txtInfoAdicionalSer.setDisabled(false);
					txtFechaRegistroSer.setValue(entity.getFechaRegistro());
					txtFechaRegistroSer.setDisabled(true);
					txtObservacionSer.setValue(entity.getObservacion());
					txtObservacionSer.setDisabled(false);
					txtObservacion2.setValue(entity.getObservacion2());
					txtObservacion2.setDisabled(false);
					txtOrigen.setValue(entity.getOrigen());
					txtOrigen.setDisabled(false);
					txtNoDocumentoSer.setValue(entity.getNoDocumento());
					txtNoDocumentoSer.setDisabled(false);
					txtFechaEstadoVehiculoSer.setValue(entity.getFechaEstadoVehiculo());
					txtFechaEstadoVehiculoSer.setDisabled(false);

					txtTipoTransaccionDes.setValue("No");
					txtTipoTransaccion.setValue("No");
					txtTipoTransaccionSer.setValue(entity.getTipoTransaccion());
					txtTipoTransaccionSer.setDisabled(true);
					
					if(dataDetTransProductos!=null && dataDetTransProductos.size()>0) {
				
						
						txtClienteDetSer.setDisabled(true);
						txtProductoSer.setDisabled(true);
						txtCiudadSer.setDisabled(true);
					}else {
						txtClienteDetSer.setDisabled(false);
						txtProductoSer.setDisabled(false);
						txtCiudadSer.setDisabled(false);
					}

					txtTranspId_TransportadoraSer.setValue(entity.getTransportadora());
					txtTranspId_TransportadoraSer.setDisabled(false);
					txtDatTransProdIdSer.setValue(entity.getDatTransProdId());
					txtDatTransProdIdSer.setDisabled(true);
					txtPesoNetoSer.setValue(entity.getPesoNeto());
					txtPesoNetoSer.setDisabled(true);
					txtPesoTaraSer.setValue(entity.getPesoTara());
					txtPesoTaraSer.setDisabled(false);
					txtPesoBrutoSer.setValue(entity.getPesoBruto());
					txtPesoBrutoSer.setDisabled(false);
					txtFechaEntradaSer.setValue(entity.getFechaEntrada());
					txtFechaEntradaSer.setDisabled(false);
					txtFechaSalidaSer.setValue(entity.getFechaSalida());
					txtFechaSalidaSer.setDisabled(false);

					Long trabId = entity.getConductor();
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);

					txtConductorId_ConductorSer.setValue(trabajador);
					txtConductorId_ConductorSer.setDisabled(false);

					Long equipoId = entity.getVehiculoId();
					Equipo equipo1 = businessDelegatorView.getEquipo(equipoId);

					txtVehiTranspId_VehiculosTranspSer.setValue(equipo1);
					txtVehiTranspId_VehiculosTranspSer.setDisabled(false);

					txtDestinoProduccionSer.setValue(entity.getDestinoProduccion());
					
					PrimeFaces contextDialog = PrimeFaces.current();
					contextDialog.ajax().update("dialogDatTransProd3");
				}

				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
	}

	public String estadoConexion() {
		String estado = "";
		try {

			URL ruta = new URL("http://www.google.es");
			URLConnection rutaC = ruta.openConnection();
			rutaC.connect();
			estado = "activo";
		} catch (Exception e) {

			estado = "desactivado";
		}

		return estado;
	}

	public String listener_calcularPesoBruto() throws Exception {

		valorLectura = null;
		tiempoLectura = 0;
		Bascula bascula = null;
		boolean estado = false;

	//	log.info(".................. Capturando el peso de la BASCULA ................");

		if (basculaId != null) {

			nombrePuerto = null;
			baudios = 0;
			paridad = 0;
			dataBits = 0;
			bitsDeParada = 0;
			inicio = 0;
			fin = 0;
			tiempoLectura = 0;
			formatoCadena = null;

			bascula = businessDelegatorView.getBascula(basculaId);

			if (bascula != null) {

				String lectura = bascula.getTipoLectura();

				if (lectura.equals("Automatica")) {

					estado = true;

					nombrePuerto = bascula.getPuertoCom();
					baudios = bascula.getVelocidad().intValue();
					paridad = Integer.parseInt(bascula.getParidad());
					dataBits = Integer.parseInt(bascula.getBitDatos().trim());
					bitsDeParada = bascula.getBitParada().intValue();
					formatoCadena = bascula.getFormatoCadena();
					inicio = bascula.getIniciolectura().intValue();
					fin = bascula.getFinlectura().intValue();
					tiempoLectura = bascula.getIntervaloLectura().intValue();

				}
			}

		}

		SerialPort serialPort = SerialPort.getCommPort(nombrePuerto);
		serialPort.openPort();
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);

		if (serialPort.isOpen()) {

			if (estado == true) {
				serialPort.setComPortParameters(baudios, dataBits, bitsDeParada, paridad);
			}

			PacketListener listener = new PacketListener();
			serialPort.addDataListener(listener);

			try {
				if (tiempoLectura == 0) {
					Thread.sleep(5000);
				} else {
					Thread.sleep(tiempoLectura);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			serialPort.removeDataListener();
			serialPort.closePort();

			setValorBascula();

		} else {

			serialPort.removeDataListener();
			serialPort.closePort();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Lo sentimos!",
					"El puerto esta en uso y/o no se puede conectar al puerto : " + serialPort.getSystemPortName()));

		}

		return "";
	}

	private static class PacketListener implements SerialPortPacketListener {

		@Override
		public int getListeningEvents() {
			return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
		}

		@Override
		public int getPacketSize() {
			return 18;
		}

		@Override
		public void serialEvent(SerialPortEvent event) {

			//log.info("----Prueba de lectura de la BASCULA---------- ");

			byte[] newData = event.getReceivedData();
			String str = new String(newData);
			String[] variablesEncontradas = new String[str.length() - 1];
			StringTokenizer st = new StringTokenizer(str, "..  ,+kgST,GS,  ");

			int i = 0;
			while (st.hasMoreTokens()) {
				variablesEncontradas[i] = st.nextToken();
				i++;
			}

			valorPesaje.setValue(variablesEncontradas[0]);
		//	System.out.println("Received data 1: " + variablesEncontradas[0]);

			return;

		}
	}

	public void setPesoNeto() {

		if (txtPesarPesoBruto.getValue() != null && txtPesarPesoTara.getValue() != null) {

			Double pesoBruto = ((Double) txtPesarPesoBruto.getValue());
			Double pesoTara = ((Double) txtPesarPesoTara.getValue());

			if (pesoBruto > 0 && pesoTara > 0) {

				Double pesoNeto = pesoBruto - pesoTara;

				if (pesoNeto != null && pesoNeto > 0) {

					txtPesarPesoNeto.setValue(pesoNeto);

				}

			}

		}

	}

	public String setValorBascula() throws Exception {

		Double pesoBruto = ((Double) txtPesarPesoBruto.getValue());
		Double pesoTara = ((Double) txtPesarPesoTara.getValue());
		
		Double peso =0.0;
		
		String valor = valorPesaje.getValue().toString();
		if( !valor.equals("")) {
			peso	 = Double.parseDouble((String) valor);
		}
		
		Date date = new Date();

		try {

			if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

				txtPesoBrutoPesaje.setValue(peso);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha obtenido el peso del vehículo. Proceda a GRABAR el tiquete",
								""));

			} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

				txtPesoBrutoPesajeDes.setValue(peso);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha obtenido el peso del vehículo. Proceda a GRABAR el tiquete",
								""));

			} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

				txtPesoBrutoPesajeSer.setValue(peso);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha obtenido el peso del vehículo. Proceda a GRABAR el tiquete",
								""));
			}

		} catch (Exception e) {

			if (txtTipoTransaccionPesaje != null) {

				if (pesoBruto != null && pesoBruto > 0) {

					if ((pesoBruto - peso) > 0) {

						txtPesarPesoTara.setValue(peso);
						txtFechaTara.setValue(date);
						

					} else {

						FacesUtils.addInfoMessage("El peso tara no puede ser mayor o igual que el peso bruto "
								+ "porfavor pese de nuevo");
					}

				} else if (pesoTara != null && pesoTara > 0) {

					if ((peso - pesoTara) > 0) {

						txtPesarPesoBruto.setValue(peso);
						txtFechaPesoBruto.setValue(date);

					} else {

						FacesUtils.addInfoMessage("El peso bruto no puede ser menor o igual que el peso tara "
								+ "porfavor pese de nuevo");
					}

				} else if (pesoBruto == 0.0 && pesoTara == 0.0) {

					if (txtTipoPesoPes.getValue().equals("2")) {

						txtPesarPesoTara.setValue(peso);
						txtFechaTara.setValue(date);
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha obtenido el peso del vehículo. Proceda a GRABAR el tiquete",
										""));

					} else if (txtTipoPesoPes.getValue().equals("1")) {

						txtPesarPesoBruto.setValue(peso);
						txtFechaPesoBruto.setValue(date);
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha obtenido el peso del vehículo. Proceda a GRABAR el tiquete",
										""));
					}

					txtTipoPesoPes.setDisabled(true);

				}
				
				setPesoNeto();
				valor ="0";
			}
		}

		return "";
	}

	public String listener_basculaActiva() throws Exception {

		SelectOneMenu txtBascula = null;
		InputNumber txtPesoBrutoPesajeV = null;
		Calendar fechaRegistro = null;
		CommandButton btnCalcularP = null;
		Calendar txtFechaPeso = null;

		Double pesoBruto = ((Double) txtPesarPesoBruto.getValue());
		Double pesoTara = ((Double) txtPesarPesoTara.getValue());

		try {

			if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

				txtBascula = txtBasculaBruto;
				txtPesoBrutoPesajeV = txtPesoBrutoPesaje;
				fechaRegistro = txtFechaRegistro;
				btnCalcularP = btnCalcularPro;

			} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

				txtBascula = txtBasculaBrutoDes;
				txtPesoBrutoPesajeV = txtPesoBrutoPesajeDes;
				fechaRegistro = txtFechaRegistroDes;
				btnCalcularP = btnCalcularDes;

			} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

				txtBascula = txtBasculaBrutoSer;
				txtPesoBrutoPesajeV = txtPesoBrutoPesajeSer;
				fechaRegistro = txtFechaRegistroSer;
				btnCalcularP = btnCalcularSer;
			}

		} catch (Exception e) {

			if (txtTipoTransaccionPesaje != null) {
				
				btnCalcularP = btnCalcular;
				txtBascula = txtBasculaBrutoPes;

				if (pesoBruto != null && pesoBruto > 0) {

					txtPesoBrutoPesajeV = txtPesarPesoTara;
					txtFechaPeso = txtFechaTara;

				} else if (pesoTara != null && pesoTara > 0) {

					txtPesoBrutoPesajeV = txtPesarPesoBruto;
					txtFechaPeso = txtFechaPesoBruto;

				} else if (pesoBruto == 0.0 && pesoTara == 0.0) {

					if (txtTipoPesoPes.getValue().equals("2")) {

						txtPesoBrutoPesajeV = txtPesarPesoTara;
						txtFechaPeso = txtFechaTara;

					} else if (txtTipoPesoPes.getValue().equals("1")) {

						txtPesoBrutoPesajeV = txtPesarPesoBruto;
						txtFechaPeso = txtFechaPesoBruto;
					}
				}
			}
		}

		if (!txtBascula.getValue().equals("")) {

			basculaId = Long.parseLong(txtBascula.getValue().toString());

			try {

				Bascula bascula = businessDelegatorView.getBascula(basculaId);
				String lectura = bascula.getTipoLectura();

				if (lectura.equals("Automatica")) {

					nombrePuerto = bascula.getPuertoCom();
					txtPesoBrutoPesajeV.setReadonly(true);
					txtPesoBrutoPesajeV.setValue(0.0);
					btnCalcularP.setDisabled(false);

					if (fechaRegistro != null) {
						fechaRegistro.setDisabled(true);
					}
					
					if (txtFechaPeso != null) {
						txtFechaPeso.setDisabled(true);
					}

				} else {

					txtPesoBrutoPesajeV.setValue(0.0);
					txtPesoBrutoPesajeV.setReadonly(false);
					txtPesoBrutoPesajeV.setDisabled(false);
					btnCalcularP.setDisabled(true);

					if (fechaRegistro != null) {
						fechaRegistro.setDisabled(false);
					}
					
					if (txtFechaPeso != null) {
						txtFechaPeso.setDisabled(false);
					}
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}

		try {

			if (txtTipoTransaccion != null && txtTipoTransaccion.getValue().equals("Produccion")) {

				txtPesoBrutoPesaje = txtPesoBrutoPesajeV;
				txtFechaRegistro = fechaRegistro;
				btnCalcularPro = btnCalcularP;

			} else if (txtTipoTransaccionDes != null && txtTipoTransaccionDes.getValue().equals("Despachos")) {

				txtPesoBrutoPesajeDes = txtPesoBrutoPesajeV;
				txtFechaRegistroDes = fechaRegistro;
				btnCalcularDes = btnCalcularP;

			} else if (txtTipoTransaccionSer != null && txtTipoTransaccionSer.getValue().equals("Servicios")) {

				txtPesoBrutoPesajeSer = txtPesoBrutoPesajeV;
				txtFechaRegistroSer = fechaRegistro;
				btnCalcularSer = btnCalcularP;

			}

		} catch (Exception e) {

			if (txtTipoTransaccionPesaje != null) {

				txtBasculaBrutoPes = txtBascula;
				btnCalcular = btnCalcularP;

				if (pesoBruto != null && pesoBruto > 0) {

					txtPesoBrutoPesajeV = txtPesarPesoTara;

				} else if (pesoTara != null && pesoTara > 0) {

					txtPesoBrutoPesajeV = txtPesarPesoBruto;

				} else if (pesoBruto == 0.0 && pesoTara == 0.0) {

					if (txtTipoPesoPes.getValue().equals("2")) {

						txtPesoBrutoPesajeV = txtPesarPesoTara;

					} else if (txtTipoPesoPes.getValue().equals("1")) {

						txtPesoBrutoPesajeV = txtPesarPesoBruto;
					}
				}
			}
		}

		return "";
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtSello1() {
		return txtSello1;
	}

	public void setTxtSello1(InputText txtSello1) {
		this.txtSello1 = txtSello1;
	}

	public InputText getTxtSello2() {
		return txtSello2;
	}

	public void setTxtSello2(InputText txtSello2) {
		this.txtSello2 = txtSello2;
	}

	public InputText getTxtSello3() {
		return txtSello3;
	}

	public void setTxtSello3(InputText txtSello3) {
		this.txtSello3 = txtSello3;
	}

	public InputText getTxtSello4() {
		return txtSello4;
	}

	public void setTxtSello4(InputText txtSello4) {
		this.txtSello4 = txtSello4;
	}

	public InputText getTxtSello5() {
		return txtSello5;
	}

	public void setTxtSello5(InputText txtSello5) {
		this.txtSello5 = txtSello5;
	}

	/**************** mano de obra ************************/

	public List<DatTransProdTrabajadoresDTO> getDataPlanillaNominaDet1() {

		if (dataPlanillaDet == null || dataPlanillaDet.size() == 0) {
			return null;
		} else {
			return dataPlanillaDet;
		}

	}

	public void action_agregarPlanilla() throws Exception {
		if (txtTrabId_Trabajador.getValue() != null && txtUdadMedPago.getValue() != null
				&& txtCeptoNominaId_ConceptoNomina.getValue() != null && txtCantidadPago.getValue() != null
				&& txtLaborId_Labor.getValue() != null && txtNivel2IdMo.getValue() != null && txtNivel4IdMo != null) {

			Long nivel2Id = Long.parseLong(txtNivel2IdMo.getValue().toString());
			Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

			Long nivel4Id = Long.parseLong(txtNivel4IdMo.getValue().toString());
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

			Long etapaId = null;
			Long variedId = null;
			if (nivel4.getEtapa() != null) {
				etapaId = nivel4.getEtapa().getEtapaId();
			}

			if (nivel4.getVariedad() != null) {
				variedId = nivel4.getVariedad();
			}

			Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			Labor labor = businessDelegatorView.getLabor(laborId);

			Long trabajadorId = Long.parseLong(txtTrabId_Trabajador.getValue().toString());
			Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedPago.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

			Long conceptoNominaId = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());
			ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);

			Long idContratista = trabajador.getContratista().getPersEmprId();

			String codTrabajador = FacesUtils.checkString(txtCodTrabajadorNomina);
			String codConceptoNomina = FacesUtils.checkString(txtCodConceptoNomina);
			String codUdadMedNomina = FacesUtils.checkString(txtCodUmPagoNomina);

			String nombreLabor = FacesUtils.checkString(txtNombreLabor);
			String nombreNivel2 = FacesUtils.checkString(txtNombreNivel2Mo);
			String nombreNivel4 = FacesUtils.checkString(txtNombreNivel4Mo);

			Double cantidadPago = FacesUtils.checkDouble(txtCantidadPago);
			Double valorUnit = FacesUtils.checkDouble(txtValorUnitarioMo);
			Double costoTotal = FacesUtils.checkDouble(txtCostoTotal);
			Double catidadDescontar = FacesUtils.checkDouble(txtCantidadDescontar);
			Double pesoPromedio = FacesUtils.checkDouble(txtPesoPromedioMo);

			boolean existeProducto = false;

			if (dataPlanillaDet == null) {
				dataPlanillaDet = new ArrayList<DatTransProdTrabajadoresDTO>();

			}

			if (dataPlanillaDet.size() > 0) {

				for (DatTransProdTrabajadoresDTO d : dataPlanillaDet) {

					if (d.getTrabId_Trabajador().getTrabId().longValue() == trabajador.getTrabId().longValue()
							&& d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4.getNivel4Id().longValue()
									& d.getLaborId_Labor().getLaborId().longValue() == labor.getLaborId().longValue()
									& d.getCeptoNominaId().getCeptoNominaId().longValue() == conceptoNomina
											.getCeptoNominaId().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"El trabajador " + d.getTrabId_Trabajador().getNombre()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				DatTransProdTrabajadoresDTO datPlanillaNominaDetDTO2 = new DatTransProdTrabajadoresDTO();
				datPlanillaNominaDetDTO2.setTrabId_Trabajador(trabajador);
				datPlanillaNominaDetDTO2.setCeptoNominaId(conceptoNomina);
				datPlanillaNominaDetDTO2.setUdadMedId_UdadMed(udadMed);
				datPlanillaNominaDetDTO2.setCantidadPago(cantidadPago);
				datPlanillaNominaDetDTO2.setCodigoTrabajador(codTrabajador);
				datPlanillaNominaDetDTO2.setCodigoConceptoNomina(codConceptoNomina);
				datPlanillaNominaDetDTO2.setCodigoUdadMed(codUdadMedNomina);
				datPlanillaNominaDetDTO2.setCostoTotal(costoTotal);
				datPlanillaNominaDetDTO2.setValorUnitario(valorUnit);
				datPlanillaNominaDetDTO2.setContratistaId(idContratista);
				datPlanillaNominaDetDTO2.setCantidadDescontar(catidadDescontar);

				datPlanillaNominaDetDTO2.setPesoPromedio(pesoPromedio);

				datPlanillaNominaDetDTO2.setNivel2Id_Nivel2(nivel2);
				datPlanillaNominaDetDTO2.setNivel4Id_Nivel4(nivel4);
				datPlanillaNominaDetDTO2.setLaborId_Labor(labor);

				datPlanillaNominaDetDTO2.setCodigoNivel2(nombreNivel2);
				datPlanillaNominaDetDTO2.setCodigoNivel4(nombreNivel4);
				datPlanillaNominaDetDTO2.setCodigoLabor(nombreLabor);

				datPlanillaNominaDetDTO2.setEtapaId(etapaId);
				datPlanillaNominaDetDTO2.setVariedId(variedId);

				dataPlanillaDet.add(datPlanillaNominaDetDTO2);

			}
			etapaId = null;
			variedId = null;

			trabajador = null;
			conceptoNomina = null;
			udadMed = null;
			codTrabajador = null;
			codConceptoNomina = null;
			codUdadMedNomina = null;
			costoTotal = null;
			valorUnit = null;
			cantidadPago = null;
			catidadDescontar = null;
			pesoPromedio = null;
			nivel2Id = null;
			nivel4Id = null;
			nombreLabor = null;
			nombreNivel2 = null;
			nombreNivel4 = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos Orden de trabajo,  trabajador, unidad de medida, concepto, cantidad tengan valores. "));
		}
	}

	public String actionDeleteDatPlanillaNominaDet(ActionEvent evt) {
		try {

			selectedDatPlanillaDet = (DatTransProdTrabajadoresDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanillaDet"));

			if (selectedDatPlanillaDet.getDatTransProdTrabajadoresId() == null) {
				dataPlanillaDet.remove(selectedDatPlanillaDet);
			} else {
				Long detPlanillaNominaDetId = new Long(selectedDatPlanillaDet.getDatTransProdTrabajadoresId());
				DatTransProdTrabajadores entity = businessDelegatorView
						.getDatTransProdTrabajadores(detPlanillaNominaDetId);
				businessDelegatorView.deleteDatTransProdTrabajadores(entity);
				dataPlanillaDet.remove(selectedDatPlanillaDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void listener_ConsultaCodTrabajador() {

		Long idTrabajador = null;
		if (FacesUtils.checkLong(txtTrabId_Trabajador) != null) {
			if (!txtTrabId_Trabajador.getValue().equals("")) {
				idTrabajador = Long.parseLong(txtTrabId_Trabajador.getValue().toString());

				try {
					Trabajador trabajador = businessDelegatorView.getTrabajador(idTrabajador);
					/* valNPass = datPlanLabor.getNPases(); */
					txtCodTrabajadorNomina.setValue(trabajador.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodConceptoNomina() {

		Long idConcepto = null;
		if (FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null) {
			if (!txtCeptoNominaId_ConceptoNomina.getValue().equals("")) {
				idConcepto = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());

				try {
					ConceptoNomina concepto = businessDelegatorView.getConceptoNomina(idConcepto);
					/* valNPass = datPlanLabor.getNPases(); */
					txtCodConceptoNomina.setValue(concepto.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}

	}

	public void listener_ConsultaNombreNivel2_Nivel4Mo() {
		Long nivel4Id = null;
		Long nivel2Id = null;
		if (!txtNivel4IdMo.getValue().equals("") && !txtNivel2IdMo.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4IdMo.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2IdMo.getValue().toString());
			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel4Mo.setValue(nivel4.getNombre());
				txtNombreNivel2Mo.setValue(nivel2.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreLaborMo() {
		Long laborId = null;
		if (!txtLaborId_Labor.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				txtNombreLabor.setValue(labor.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaCodUdadMedMo() {
		Long udadMedId = null;
		if (!txtUdadMedPago.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedPago.getValue().toString());
			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				txtCodUmPagoNomina.setValue(udadMed.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void ConsultarTarifaPago() throws Exception {

		Long idCompania = new Long(getCompaniaIdSession());
		Long trabId = Long.parseLong(txtTrabId_Trabajador.getValue().toString());
		Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
		Long idContratista = trabajador.getContratista().getPersEmprId();
		Long idLabor = FacesUtils.checkLong(txtLaborId_Labor);
		Long idCeptoNomina = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedPago);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));

		Double edadLote = (businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(txtFechaRegistro),
				FacesUtils.checkLong(txtNivel4IdMo)));

		Long nivel2Id = FacesUtils.checkLong(txtNivel2IdMo);
		Long nivel4Id = FacesUtils.checkLong(txtNivel4IdMo);

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		BigDecimal tarifaPago = businessDelegatorView.consultarTarifaContratista(idCompania, idContratista, idLabor,
				idCeptoNomina, idUdadMed, idFecha, edadLote, null, nivel2Id, nivel4Id, null);

		String format = decimalFormat.format(tarifaPago);
		txtValorUnitarioMo.setValue(format);

		if (tarifaPago == null) {
			BigDecimal tarifaNoEncontrada = new BigDecimal("0");
			txtValorUnitarioMo.setValue(tarifaNoEncontrada);

		}

	}

	public void listener_calcularCostoTotalMo() throws Exception {
		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitarioMo);
		Double cantidadPago = FacesUtils.checkDouble(txtCantidadPago);
		Double cantidadDescontar = FacesUtils.checkDouble(txtCantidadDescontar);

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Double costoTotal = 0.0;

		if (cantidadPago != null && cantidadDescontar != null && valorUnitario != null) {
			costoTotal = (cantidadPago.doubleValue() - cantidadDescontar.doubleValue()) * valorUnitario;
		}

		String format = decimalFormat.format(costoTotal);
		txtCostoTotal.setValue(format);

		if (txtCostoTotal == null) {
			BigDecimal tarifaNoEncontrada = new BigDecimal("0");
			txtCostoTotal.setValue(tarifaNoEncontrada);

		}

	}

	public List<DatTransProdTrabajadoresDTO> getDataPlanillaDet() {
		return dataPlanillaDet;
	}

	public void setDataPlanillaDet(List<DatTransProdTrabajadoresDTO> dataPlanillaDet) {
		this.dataPlanillaDet = dataPlanillaDet;
	}

	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectOneMenu getTxtNivel1IdMo() {
		return txtNivel1IdMo;
	}

	public void setTxtNivel1IdMo(SelectOneMenu txtNivel1IdMo) {
		this.txtNivel1IdMo = txtNivel1IdMo;
	}

	public SelectOneMenu getTxtNivel2IdMo() {
		return txtNivel2IdMo;
	}

	public void setTxtNivel2IdMo(SelectOneMenu txtNivel2IdMo) {
		this.txtNivel2IdMo = txtNivel2IdMo;
	}

	public SelectOneMenu getTxtNivel3IdMo() {
		return txtNivel3IdMo;
	}

	public void setTxtNivel3IdMo(SelectOneMenu txtNivel3IdMo) {
		this.txtNivel3IdMo = txtNivel3IdMo;
	}

	public SelectOneMenu getTxtNivel4IdMo() {
		return txtNivel4IdMo;
	}

	public void setTxtNivel4IdMo(SelectOneMenu txtNivel4IdMo) {
		this.txtNivel4IdMo = txtNivel4IdMo;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtUdadMedPago() {
		return txtUdadMedPago;
	}

	public void setTxtUdadMedPago(SelectOneMenu txtUdadMedPago) {
		this.txtUdadMedPago = txtUdadMedPago;
	}

	public InputText getTxtCodTrabajadorNomina() {
		return txtCodTrabajadorNomina;
	}

	public void setTxtCodTrabajadorNomina(InputText txtCodTrabajadorNomina) {
		this.txtCodTrabajadorNomina = txtCodTrabajadorNomina;
	}

	public InputText getTxtCodConceptoNomina() {
		return txtCodConceptoNomina;
	}

	public void setTxtCodConceptoNomina(InputText txtCodConceptoNomina) {
		this.txtCodConceptoNomina = txtCodConceptoNomina;
	}

	public InputText getTxtCodUmPagoNomina() {
		return txtCodUmPagoNomina;
	}

	public void setTxtCodUmPagoNomina(InputText txtCodUmPagoNomina) {
		this.txtCodUmPagoNomina = txtCodUmPagoNomina;
	}

	public InputText getTxtNombreLabor() {
		return txtNombreLabor;
	}

	public void setTxtNombreLabor(InputText txtNombreLabor) {
		this.txtNombreLabor = txtNombreLabor;
	}

	public InputText getTxtPesoPromedioMo() {
		return txtPesoPromedioMo;
	}

	public void setTxtPesoPromedioMo(InputText txtPesoPromedioMo) {
		this.txtPesoPromedioMo = txtPesoPromedioMo;
	}

	public InputText getTxtCantidadDescontar() {
		return txtCantidadDescontar;
	}

	public void setTxtCantidadDescontar(InputText txtCantidadDescontar) {
		this.txtCantidadDescontar = txtCantidadDescontar;
	}

	public CommandButton getBtnAgregarNomina() {
		return btnAgregarNomina;
	}

	public void setBtnAgregarNomina(CommandButton btnAgregarNomina) {
		this.btnAgregarNomina = btnAgregarNomina;
	}

	public InputText getTxtNombreNivel2Mo() {
		return txtNombreNivel2Mo;
	}

	public void setTxtNombreNivel2Mo(InputText txtNombreNivel2Mo) {
		this.txtNombreNivel2Mo = txtNombreNivel2Mo;
	}

	public InputText getTxtNombreNivel4Mo() {
		return txtNombreNivel4Mo;
	}

	public void setTxtNombreNivel4Mo(InputText txtNombreNivel4Mo) {
		this.txtNombreNivel4Mo = txtNombreNivel4Mo;
	}

	public InputText getTxtValorUnitarioMo() {
		return txtValorUnitarioMo;
	}

	public void setTxtValorUnitarioMo(InputText txtValorUnitarioMo) {
		this.txtValorUnitarioMo = txtValorUnitarioMo;
	}

	public InputText getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputText txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public InputText getTxtCantidadPago() {
		return txtCantidadPago;
	}

	public void setTxtCantidadPago(InputText txtCantidadPago) {
		this.txtCantidadPago = txtCantidadPago;
	}

	public SelectItem[] getSelectCeptoNominaId() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setselectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

	public SelectItem[] getSelectUdadMedPago() {

		if (udadMedPago == null || udadMedPago.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedPago = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedPago : lista) {
					selectUdadMedPago[i] = new SelectItem(udadMedPago.getUdadMedId(), udadMedPago.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedPago;

	}

	public void setSelectUdadmedPago(SelectItem[] selectUdadMedPago) {
		this.selectUdadMedPago = selectUdadMedPago;
	}

	public SelectItem[] getselectNivel1Mo() {

		String tipoTransaccion = FacesUtils.checkString(txtTipoTransaccion);

		if (tipoTransaccion != null) {

			if (nivel1Mo == null || nivel1Mo.size() == 0) {

				try {

					nivel1Mo = businessDelegatorView.getNivel1();
					Object[] condicion = { "estado", true, "A", "=" };
					List<Nivel1> lista = businessDelegatorView.findByCriteriaInNivel1(condicion, null, null);
					selectNivel1Mo = new SelectItem[lista.size()];

					int i = 0;
					for (Nivel1 nivel1 : lista) {
						selectNivel1Mo[i] = new SelectItem(nivel1.getNivel1Id(), nivel1.getNombre());
						i++;

					}

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return selectNivel1Mo;
	}

	public void setselectNivel1Mo(SelectItem[] selectNivel1Mo) {
		this.selectNivel1Mo = selectNivel1Mo;
	}

	public SelectItem[] getselectNivel2Mo() {

		nivel2Mo = new ArrayList<Nivel2>();

		Long nivel1Id = null;

		if (txtNivel1IdMo != null && txtNivel1IdMo.getValue() != null && !txtNivel1IdMo.getValue().equals("")) {
			nivel1Id = Long.parseLong(txtNivel1IdMo.getValue().toString());

			try {
				Nivel1 nivel1 = businessDelegatorView.getNivel1(nivel1Id);
				Object[] niveles2 = nivel1.getNivel2s().toArray();

				selectNivel2Mo = new SelectItem[niveles2.length];

				int i = 0;
				for (Object object : niveles2) {
					Nivel2 nivel2 = (Nivel2) object;
					selectNivel2Mo[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel2Mo;
	}

	public void setselectNivel2Mo(SelectItem[] selectNivel2Mo) {
		this.selectNivel2Mo = selectNivel2Mo;
	}

	public SelectItem[] getselectNivel3Mo() {

		nivel3Mo = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2IdMo != null && txtNivel2IdMo.getValue() != null && !txtNivel2IdMo.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdMo.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3 = nivel2.getNivel3s().toArray();

				selectNivel3Mo = new SelectItem[niveles3.length];

				int i = 0;
				for (Object object : niveles3) {
					Nivel3 nivel3 = (Nivel3) object;
					selectNivel3Mo[i] = new SelectItem(nivel3.getNivel3Id(), nivel3.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3Mo;
	}

	public void setselectNivel3Mo(SelectItem[] selectNivel3Mo) {
		this.selectNivel3Mo = selectNivel3Mo;
	}

	public SelectItem[] getselectNivel4Mo() {
		nivel4Mo = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3IdMo != null && txtNivel3IdMo.getValue() != null && !txtNivel3IdMo.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3IdMo.getValue().toString());

			try {
				Nivel3 nivel3 = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4 = nivel3.getNivel4s().toArray();

				selectNivel4Mo = new SelectItem[niveles4.length];

				int i = 0;
				for (Object object : niveles4) {
					Nivel4 nivel4 = (Nivel4) object;
					selectNivel4Mo[i] = new SelectItem(nivel4.getNivel4Id(),
							nivel4.getNombre() + '-' + "Área: " + nivel4.getAreaNeta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4Mo;
	}

	public void setselectNivel4Mo(SelectItem[] selectNivel4Mo) {
		this.selectNivel4Mo = selectNivel4Mo;
	}

	public SelectItem[] getselectBascula() {

		if (bascula == null || bascula.size() == 0) {

			bascula = new ArrayList<Bascula>();

			try {

				bascula = businessDelegatorView.getBascula();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Bascula> lista = businessDelegatorView.findByCriteriaInBascula(condicion, null, null);
				selectBascula = new SelectItem[lista.size()];

				int i = 0;
				for (Bascula bascula : lista) {
					selectBascula[i] = new SelectItem(bascula.getBasculaId(), bascula.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectBascula;
	}

	public void setselectBascula(SelectItem[] selectBascula) {
		this.selectBascula = selectBascula;
	}

	public SelectItem[] getSelectBasculaDes() {

		if (basculaDes == null || basculaDes.size() == 0) {

			basculaDes = new ArrayList<Bascula>();

			try {

				basculaDes = businessDelegatorView.getBascula();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Bascula> lista = businessDelegatorView.findByCriteriaInBascula(condicion, null, null);
				selectBasculaDes = new SelectItem[lista.size()];

				int i = 0;
				for (Bascula bascula : lista) {
					selectBasculaDes[i] = new SelectItem(bascula.getBasculaId(), bascula.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectBasculaDes;
	}

	public void setSelectBasculaDes(SelectItem[] selectBasculaDes) {
		this.selectBasculaDes = selectBasculaDes;
	}

	public SelectItem[] getSelectBasculaSer() {

		if (basculaSer == null || basculaSer.size() == 0) {

			basculaSer = new ArrayList<Bascula>();

			try {

				basculaSer = businessDelegatorView.getBascula();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Bascula> lista = businessDelegatorView.findByCriteriaInBascula(condicion, null, null);
				selectBasculaSer = new SelectItem[lista.size()];

				int i = 0;
				for (Bascula bascula : lista) {
					selectBasculaSer[i] = new SelectItem(bascula.getBasculaId(), bascula.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectBasculaSer;
	}

	public void setSelectBasculaSer(SelectItem[] selectBasculaSer) {
		this.selectBasculaSer = selectBasculaSer;
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajador[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajador;
	}

	public void setselectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
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

	public void setselectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public LogBascula getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(LogBascula entityLog) {
		this.entityLog = entityLog;
	}

	public String getCambioTiquete() {
		return cambioTiquete;
	}

	public void setCambioTiquete(String cambioTiquete) {
		this.cambioTiquete = cambioTiquete;
	}

	public SelectItem[] getSelectNivel2Edit() {

		if (nivel2 == null || nivel2.size() == 0) {

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

	public void setSelectNivel2Edit(SelectItem[] selectNivel2Edit) {
		this.selectNivel2Edit = selectNivel2Edit;
	}

	public SelectItem[] getselectNivel4Edit() {

		if (nivel4 == null || nivel4.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4 : lista) {
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(),
							nivel4.getNombre() + '-' + "Área: " + nivel4.getAreaNeta().toString());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4;
	}

	public void setSelectNivel4Edit(SelectItem[] selectNivel4Edit) {
		this.selectNivel4Edit = selectNivel4Edit;
	}

	public SelectItem[] getSelectNivel2PlanEdit() {

		if (nivel2 == null || nivel2.size() == 0) {

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

	public void setSelectNivel2PlanEdit(SelectItem[] selectNivel2PlanEdit) {
		this.selectNivel2PlanEdit = selectNivel2PlanEdit;
	}

	public SelectItem[] getselectNivel4PlanEdit() {

		if (nivel4 == null || nivel4.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4 : lista) {
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(),
							nivel4.getNombre() + '-' + "Área: " + nivel4.getAreaNeta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4;
	}

	public void setSelectNivel4PlanEdit(SelectItem[] selectNivel4PlanEdit) {
		this.selectNivel4PlanEdit = selectNivel4PlanEdit;
	}

	public List<TiquetesBasculaDTO> getData2() {

		if (data2 == null) {

			try {
				Long compania1 = new Long(getCompaniaIdSession());

				Date calendar = new Date();

				GregorianCalendar fechaInicial = new GregorianCalendar();
				fechaInicial.setTime(calendar);
				fechaInicial.add(GregorianCalendar.DAY_OF_YEAR, 0);

				Date fechaFinal = new Date();
				String tipoMovimiento = null;
				tipoMovimiento = "Todos";

				if (compania1 != null && fechaInicial != null && fechaFinal != null) {

					data2 = businessDelegator2View.consultarEstadoVehiculo(compania1, fechaInicial.getTime(), fechaFinal,
							tipoMovimiento, "0", 1L, "0", 1L, 1L, "0", "0", 1L,"0");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return data2;
	}

	public List<TiquetesBasculaDTO> getData5() {

		if (data5 == null) {

			try {
				Long compania1 = new Long(getCompaniaIdSession());

				Date calendar = new Date();

				GregorianCalendar fechaInicial = new GregorianCalendar();
				fechaInicial.setTime(calendar);
				fechaInicial.add(GregorianCalendar.DAY_OF_YEAR, 0);

				Date fechaFinal = new Date();
				String tipoMovimiento = null;
				tipoMovimiento = "Todos";

				if (compania1 != null && fechaInicial != null && fechaFinal != null) {

					data5 = businessDelegator2View.consultarEstadoVehiculoPr(compania1, fechaInicial.getTime(),
							fechaFinal, tipoMovimiento, "0", 1L, "0", 1L, 1L, "0", "0", 1L,"0");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return data5;
	}

	public void setData5(List<TiquetesBasculaDTO> data5) {
		this.data5 = data5;
	}

	public void cargarTiquetes() {

		try {
			Long compania1 = new Long(getCompaniaIdSession());

			Date calendar = new Date();

			GregorianCalendar fechaInicial = new GregorianCalendar();
			fechaInicial.setTime(calendar);
			fechaInicial.add(GregorianCalendar.DAY_OF_YEAR, 0);

			Date fechaFinal = new Date();
			String tipoMovimiento = null;
			tipoMovimiento = "Todos";

			if (compania1 != null && fechaInicial != null && fechaFinal != null) {

				data2 = businessDelegator2View.consultarEstadoVehiculo(compania1, fechaInicial.getTime(), fechaFinal,
						tipoMovimiento, "0", 1L, "0", 1L, 1L, "0", "0", 1L,"0");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cargarTiquetesCorrecion() {

		try {
			Long compania1 = new Long(getCompaniaIdSession());

			Date calendar = new Date();

			GregorianCalendar fechaInicial = new GregorianCalendar();
			fechaInicial.setTime(calendar);
			fechaInicial.add(GregorianCalendar.DAY_OF_YEAR, 0);

			Date fechaFinal = new Date();
			String tipoMovimiento = null;
			tipoMovimiento = "Todos";

			if (compania1 != null && fechaInicial != null && fechaFinal != null) {

				data5 = businessDelegator2View.consultarEstadoVehiculoPr(compania1, fechaInicial.getTime(), fechaFinal,
						tipoMovimiento, "0", 1L, "0", 1L, 1L, "0", "0", 1L,"0");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SelectOneMenu getTxtVariedadNivel4() {
		return txtVariedadNivel4;
	}

	public void setTxtVariedadNivel4(SelectOneMenu txtVariedadNIvel4) {
		this.txtVariedadNivel4 = txtVariedadNIvel4;
	}

	public SelectItem[] getSelectVariedadNivel4() {

		String tipoTransaccion = FacesUtils.checkString(txtTipoTransaccion);

		if (tipoTransaccion != null) {

			if (variedadNivel4 == null || variedadNivel4.size() == 0) {

				try {
					Object[] condicion = { "estado", true, "A", "=" };
					List<Variedad> lista = businessDelegatorView.findByCriteriaInVariedad(condicion, null, null);
					selectVariedadNivel4 = new SelectItem[lista.size()];

					int i = 0;
					for (Variedad variedad : lista) {
						selectVariedadNivel4[i] = new SelectItem(variedad.getVariedId(), variedad.getNombre());
						i++;

					}

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}

		}
		return selectVariedadNivel4;

	}

	public void setSelectVariedadNivel4(SelectItem[] selectVariedadNivel4) {
		this.selectVariedadNivel4 = selectVariedadNivel4;
	}

	public InputText getTxtNoDocumento() {
		return txtNoDocumento;
	}

	public void setTxtNoDocumento(InputText txtNoDocumento) {
		this.txtNoDocumento = txtNoDocumento;
	}

	public InputText getTxtOrigen() {
		return txtOrigen;
	}

	public void setTxtOrigen(InputText txtOrigen) {
		this.txtOrigen = txtOrigen;
	}

	public InputText getEquipos() {
		return equipos;
	}

	public void setEquipos(InputText equipos) {
		this.equipos = equipos;
	}

	public InputText getEquipos2() {
		return equipos2;
	}

	public void setEquipos2(InputText equipos2) {
		this.equipos2 = equipos2;
	}

	public SelectOneMenu getTxtCertificacionAceite() {
		return txtCertificacionAceite;
	}

	public void setTxtCertificacionAceite(SelectOneMenu txtCertificacionAceite) {
		this.txtCertificacionAceite = txtCertificacionAceite;
	}

	public ITrabajadorLogic getTrabajadorLogic() {
		return trabajadorLogic;
	}

	public void setTrabajadorLogic(ITrabajadorLogic trabajadorLogic) {
		this.trabajadorLogic = trabajadorLogic;
	}

	public IEquipoLogic getEquipoLogic() {
		return equipoLogic;
	}

	public void setEquipoLogic(IEquipoLogic equipoLogic) {
		this.equipoLogic = equipoLogic;
	}

	public SelectOneMenu getTxtDestinoProduccionDes() {
		return txtDestinoProduccionDes;
	}

	public void setTxtDestinoProduccionDes(SelectOneMenu txtDestinoProduccionDes) {
		this.txtDestinoProduccionDes = txtDestinoProduccionDes;
	}

	public SelectOneMenu getTxtDestinoProduccionSer() {
		return txtDestinoProduccionSer;
	}

	public void setTxtDestinoProduccionSer(SelectOneMenu txtDestinoProduccionSer) {
		this.txtDestinoProduccionSer = txtDestinoProduccionSer;
	}

	public SelectOneMenu getTxtTranspId_TransportadoraDes() {
		return txtTranspId_TransportadoraDes;
	}

	public void setTxtTranspId_TransportadoraDes(SelectOneMenu txtTranspId_TransportadoraDes) {
		this.txtTranspId_TransportadoraDes = txtTranspId_TransportadoraDes;
	}

	public SelectOneMenu getTxtTranspId_TransportadoraSer() {
		return txtTranspId_TransportadoraSer;
	}

	public void setTxtTranspId_TransportadoraSer(SelectOneMenu txtTranspId_TransportadoraSer) {
		this.txtTranspId_TransportadoraSer = txtTranspId_TransportadoraSer;
	}

	public SelectOneMenu getTxtCertificacionAceiteSer() {
		return txtCertificacionAceiteSer;
	}

	public void setTxtCertificacionAceiteSer(SelectOneMenu txtCertificacionAceiteSer) {
		this.txtCertificacionAceiteSer = txtCertificacionAceiteSer;
	}

	public SelectOneMenu getTxtClienteDetSer() {
		return txtClienteDetSer;
	}

	public void setTxtClienteDetSer(SelectOneMenu txtClienteDetSer) {
		this.txtClienteDetSer = txtClienteDetSer;
	}

	public SelectOneMenu getTxtClienteNivel4() {
		return txtClienteNivel4;
	}

	public void setTxtClienteNivel4(SelectOneMenu txtClienteNivel4) {
		this.txtClienteNivel4 = txtClienteNivel4;
	}

	public SelectOneMenu getTxtProductoSer() {
		return txtProductoSer;
	}

	public void setTxtProductoSer(SelectOneMenu txtProductoSer) {
		this.txtProductoSer = txtProductoSer;
	}

	public void setSelectProductoIdSer(SelectItem[] selectProductoIdSer) {
		this.selectProductoIdSer = selectProductoIdSer;
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

	public InputText getTxtTipoTransaccionDes() {
		return txtTipoTransaccionDes;
	}

	public void setTxtTipoTransaccionDes(InputText txtTipoTransaccionDes) {
		this.txtTipoTransaccionDes = txtTipoTransaccionDes;
	}

	public InputText getTxtTipoTransaccionSer() {
		return txtTipoTransaccionSer;
	}

	public void setTxtTipoTransaccionSer(InputText txtTipoTransaccionSer) {
		this.txtTipoTransaccionSer = txtTipoTransaccionSer;
	}

	public AutoComplete getTxtConductorId_ConductorDes() {
		return txtConductorId_ConductorDes;
	}

	public void setTxtConductorId_ConductorDes(AutoComplete txtConductorId_ConductorDes) {
		this.txtConductorId_ConductorDes = txtConductorId_ConductorDes;
	}

	public AutoComplete getTxtConductorId_ConductorSer() {
		return txtConductorId_ConductorSer;
	}

	public void setTxtConductorId_ConductorSer(AutoComplete txtConductorId_ConductorSer) {
		this.txtConductorId_ConductorSer = txtConductorId_ConductorSer;
	}

	public AutoComplete getTxtVehiTranspId_VehiculosTranspDes() {
		return txtVehiTranspId_VehiculosTranspDes;
	}

	public void setTxtVehiTranspId_VehiculosTranspDes(AutoComplete txtVehiTranspId_VehiculosTranspDes) {
		this.txtVehiTranspId_VehiculosTranspDes = txtVehiTranspId_VehiculosTranspDes;
	}

	public AutoComplete getTxtVehiTranspId_VehiculosTranspSer() {
		return txtVehiTranspId_VehiculosTranspSer;
	}

	public void setTxtVehiTranspId_VehiculosTranspSer(AutoComplete txtVehiTranspId_VehiculosTranspSer) {
		this.txtVehiTranspId_VehiculosTranspSer = txtVehiTranspId_VehiculosTranspSer;
	}

	public InputText getTxtVagon1Des() {
		return txtVagon1Des;
	}

	public void setTxtVagon1Des(InputText txtVagon1Des) {
		this.txtVagon1Des = txtVagon1Des;
	}

	public InputText getTxtVagon2Des() {
		return txtVagon2Des;
	}

	public void setTxtVagon2Des(InputText txtVagon2Des) {
		this.txtVagon2Des = txtVagon2Des;
	}

	public InputText getTxtVagon3Des() {
		return txtVagon3Des;
	}

	public void setTxtVagon3Des(InputText txtVagon3Des) {
		this.txtVagon3Des = txtVagon3Des;
	}

	public InputText getTxtVagon1Ser() {
		return txtVagon1Ser;
	}

	public void setTxtVagon1Ser(InputText txtVagon1Ser) {
		this.txtVagon1Ser = txtVagon1Ser;
	}

	public InputText getTxtVagon2Ser() {
		return txtVagon2Ser;
	}

	public void setTxtVagon2Ser(InputText txtVagon2Ser) {
		this.txtVagon2Ser = txtVagon2Ser;
	}

	public InputText getTxtVagon3Ser() {
		return txtVagon3Ser;
	}

	public void setTxtVagon3Ser(InputText txtVagon3Ser) {
		this.txtVagon3Ser = txtVagon3Ser;
	}

	public SelectOneMenu getSelectedEstadoEquipo() {
		return selectedEstadoEquipo;
	}

	public void setSelectedEstadoEquipo(SelectOneMenu selectedEstadoEquipo) {
		this.selectedEstadoEquipo = selectedEstadoEquipo;
	}

	public InputTextarea getTxtInfoAdicionalDes() {
		return txtInfoAdicionalDes;
	}

	public void setTxtInfoAdicionalDes(InputTextarea txtInfoAdicionalDes) {
		this.txtInfoAdicionalDes = txtInfoAdicionalDes;
	}

	public InputTextarea getTxtInfoAdicionalSer() {
		return txtInfoAdicionalSer;
	}

	public void setTxtInfoAdicionalSer(InputTextarea txtInfoAdicionalSer) {
		this.txtInfoAdicionalSer = txtInfoAdicionalSer;
	}

	public InputText getTxtNoDocumentoDes() {
		return txtNoDocumentoDes;
	}

	public void setTxtNoDocumentoDes(InputText txtNoDocumentoDes) {
		this.txtNoDocumentoDes = txtNoDocumentoDes;
	}

	public InputText getTxtNoDocumentoSer() {
		return txtNoDocumentoSer;
	}

	public void setTxtNoDocumentoSer(InputText txtNoDocumentoSer) {
		this.txtNoDocumentoSer = txtNoDocumentoSer;
	}

	public InputTextarea getTxtObservacionDes() {
		return txtObservacionDes;
	}

	public void setTxtObservacionDes(InputTextarea txtObservacionDes) {
		this.txtObservacionDes = txtObservacionDes;
	}

	public InputTextarea getTxtObservacionSer() {
		return txtObservacionSer;
	}

	public void setTxtObservacionSer(InputTextarea txtObservacionSer) {
		this.txtObservacionSer = txtObservacionSer;
	}

	public InputText getTxtDatTransProdIdDes() {
		return txtDatTransProdIdDes;
	}

	public void setTxtDatTransProdIdDes(InputText txtDatTransProdIdDes) {
		this.txtDatTransProdIdDes = txtDatTransProdIdDes;
	}

	public InputText getTxtDatTransProdIdSer() {
		return txtDatTransProdIdSer;
	}

	public void setTxtDatTransProdIdSer(InputText txtDatTransProdIdSer) {
		this.txtDatTransProdIdSer = txtDatTransProdIdSer;
	}

	public InputText getTxtSello6() {
		return txtSello6;
	}

	public void setTxtSello6(InputText txtSello6) {
		this.txtSello6 = txtSello6;
	}

	public InputText getTxtSello7() {
		return txtSello7;
	}

	public void setTxtSello7(InputText txtSello7) {
		this.txtSello7 = txtSello7;
	}

	public InputText getTxtSello8() {
		return txtSello8;
	}

	public void setTxtSello8(InputText txtSello8) {
		this.txtSello8 = txtSello8;
	}

	public InputText getTxtSello9() {
		return txtSello9;
	}

	public void setTxtSello9(InputText txtSello9) {
		this.txtSello9 = txtSello9;
	}

	public InputText getTxtSello10() {
		return txtSello10;
	}

	public void setTxtSello10(InputText txtSello10) {
		this.txtSello10 = txtSello10;
	}

	public InputText getTxtNuevoConductorSer() {
		return txtNuevoConductorSer;
	}

	public void setTxtNuevoConductorSer(InputText txtNuevoConductorSer) {
		this.txtNuevoConductorSer = txtNuevoConductorSer;
	}

	public InputText getTxtNuevoVehiculo() {
		return txtNuevoVehiculo;
	}

	public void setTxtNuevoVehiculo(InputText txtNuevoVehiculo) {
		this.txtNuevoVehiculo = txtNuevoVehiculo;
	}

	public InputText getTxtNuevoVehiculoDes() {
		return txtNuevoVehiculoDes;
	}

	public void setTxtNuevoVehiculoDes(InputText txtNuevoVehiculoDes) {
		this.txtNuevoVehiculoDes = txtNuevoVehiculoDes;
	}

	public InputText getTxtNuevoVehiculoSer() {
		return txtNuevoVehiculoSer;
	}

	public void setTxtNuevoVehiculoSer(InputText txtNuevoVehiculoSer) {
		this.txtNuevoVehiculoSer = txtNuevoVehiculoSer;
	}

	public InputText getTxtNuevoConductor() {
		return txtNuevoConductor;
	}

	public void setTxtNuevoConductor(InputText txtNuevoConductor) {
		this.txtNuevoConductor = txtNuevoConductor;
	}

	public InputText getTxtNuevoConductorDes() {
		return txtNuevoConductorDes;
	}

	public void setTxtNuevoConductorDes(InputText txtNuevoConductorDes) {
		this.txtNuevoConductorDes = txtNuevoConductorDes;
	}

	public AutoComplete getTxtVehiTranspId_VehiculosTranspCon() {
		return txtVehiTranspId_VehiculosTranspCon;
	}

	public void setTxtVehiTranspId_VehiculosTranspCon(AutoComplete txtVehiTranspId_VehiculosTranspCon) {
		this.txtVehiTranspId_VehiculosTranspCon = txtVehiTranspId_VehiculosTranspCon;
	}

	public SelectOneMenu getTxtCiudadSer() {
		return txtCiudadSer;
	}

	public void setTxtCiudadSer(SelectOneMenu txtCiudadSer) {
		this.txtCiudadSer = txtCiudadSer;
	}

	public Calendar getTxtFechaEntradaDes() {
		return txtFechaEntradaDes;
	}

	public void setTxtFechaEntradaDes(Calendar txtFechaEntradaDes) {
		this.txtFechaEntradaDes = txtFechaEntradaDes;
	}

	public Calendar getTxtFechaSalidaDes() {
		return txtFechaSalidaDes;
	}

	public void setTxtFechaSalidaDes(Calendar txtFechaSalidaDes) {
		this.txtFechaSalidaDes = txtFechaSalidaDes;
	}

	public InputNumber getTxtPesoBrutoDes() {
		return txtPesoBrutoDes;
	}

	public void setTxtPesoBrutoDes(InputNumber txtPesoBrutoDes) {
		this.txtPesoBrutoDes = txtPesoBrutoDes;
	}

	public InputText getTxtPesoNetoDes() {
		return txtPesoNetoDes;
	}

	public void setTxtPesoNetoDes(InputText txtPesoNetoDes) {
		this.txtPesoNetoDes = txtPesoNetoDes;
	}

	public InputNumber getTxtPesoTaraDes() {
		return txtPesoTaraDes;
	}

	public void setTxtPesoTaraDes(InputNumber txtPesoTaraDes) {
		this.txtPesoTaraDes = txtPesoTaraDes;
	}

	public Calendar getTxtFechaEntradaSer() {
		return txtFechaEntradaSer;
	}

	public void setTxtFechaEntradaSer(Calendar txtFechaEntradaSer) {
		this.txtFechaEntradaSer = txtFechaEntradaSer;
	}

	public Calendar getTxtFechaSalidaSer() {
		return txtFechaSalidaSer;
	}

	public void setTxtFechaSalidaSer(Calendar txtFechaSalidaSer) {
		this.txtFechaSalidaSer = txtFechaSalidaSer;
	}

	public InputNumber getTxtPesoBrutoSer() {
		return txtPesoBrutoSer;
	}

	public void setTxtPesoBrutoSer(InputNumber txtPesoBrutoSer) {
		this.txtPesoBrutoSer = txtPesoBrutoSer;
	}

	public InputText getTxtPesoNetoSer() {
		return txtPesoNetoSer;
	}

	public void setTxtPesoNetoSer(InputText txtPesoNetoSer) {
		this.txtPesoNetoSer = txtPesoNetoSer;
	}

	public InputNumber getTxtPesoTaraSer() {
		return txtPesoTaraSer;
	}

	public void setTxtPesoTaraSer(InputNumber txtPesoTaraSer) {
		this.txtPesoTaraSer = txtPesoTaraSer;
	}

	public int getBaudios() {
		return baudios;
	}

	public void setBaudios(int baudios) {
		this.baudios = baudios;
	}

	public int getParidad() {
		return paridad;
	}

	public void setParidad(int paridad) {
		this.paridad = paridad;
	}

	public int getDataBits() {
		return dataBits;
	}

	public void setDataBits(int dataBits) {
		this.dataBits = dataBits;
	}

	public int getBitsDeParada() {
		return bitsDeParada;
	}

	public void setBitsDeParada(int bitsDeParada) {
		this.bitsDeParada = bitsDeParada;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public SelectOneMenu getTxtBasculaBruto() {
		return txtBasculaBruto;
	}

	public void setTxtBasculaBruto(SelectOneMenu txtBasculaBruto) {
		this.txtBasculaBruto = txtBasculaBruto;
	}

	public InputNumber getTxtPesoBrutoPesaje() {
		return txtPesoBrutoPesaje;
	}

	public void setTxtPesoBrutoPesaje(InputNumber txtPesoBrutoPesaje) {
		this.txtPesoBrutoPesaje = txtPesoBrutoPesaje;
	}

	public InputNumber getTxtPesoBrutoPesajeDes() {
		return txtPesoBrutoPesajeDes;
	}

	public void setTxtPesoBrutoPesajeDes(InputNumber txtPesoBrutoPesajeDes) {
		this.txtPesoBrutoPesajeDes = txtPesoBrutoPesajeDes;
	}

	public InputNumber getTxtPesoBrutoPesajeSer() {
		return txtPesoBrutoPesajeSer;
	}

	public void setTxtPesoBrutoPesajeSer(InputNumber txtPesoBrutoPesajeSer) {
		this.txtPesoBrutoPesajeSer = txtPesoBrutoPesajeSer;
	}

	public SelectOneMenu getTxtTipoPeso() {
		return txtTipoPeso;
	}

	public void setTxtTipoPeso(SelectOneMenu txtTipoPeso) {
		this.txtTipoPeso = txtTipoPeso;
	}

	public SelectOneMenu getTxtBasculaBrutoDes() {
		return txtBasculaBrutoDes;
	}

	public void setTxtBasculaBrutoDes(SelectOneMenu txtBasculaBrutoDes) {
		this.txtBasculaBrutoDes = txtBasculaBrutoDes;
	}

	public SelectOneMenu getTxtBasculaBrutoSer() {
		return txtBasculaBrutoSer;
	}

	public void setTxtBasculaBrutoSer(SelectOneMenu txtBasculaBrutoSer) {
		this.txtBasculaBrutoSer = txtBasculaBrutoSer;
	}

	public SelectOneMenu getTxtBasculaBrutoPes() {
		return txtBasculaBrutoPes;
	}

	public void setTxtBasculaBrutoPes(SelectOneMenu txtBasculaBrutoPes) {
		this.txtBasculaBrutoPes = txtBasculaBrutoPes;
	}

	public InputText getTxtTiquete() {
		return txtTiquete;
	}

	public void setTxtTiquete(InputText txtTiquete) {
		this.txtTiquete = txtTiquete;
	}

	public InputText getTxtVehiTranspId() {
		return txtVehiTranspId;
	}

	public void setTxtVehiTranspId(InputText txtVehiTranspId) {
		this.txtVehiTranspId = txtVehiTranspId;
	}

	public Calendar getTxtFechaPesaje() {
		return txtFechaPesaje;
	}

	public void setTxtFechaPesaje(Calendar txtFechaPesaje) {
		this.txtFechaPesaje = txtFechaPesaje;
	}

	public InputText getTxtTipoTransaccionPesaje() {
		return txtTipoTransaccionPesaje;
	}

	public void setTxtTipoTransaccionPesaje(InputText txtTipoTransaccionPesaje) {
		this.txtTipoTransaccionPesaje = txtTipoTransaccionPesaje;
	}

	public InputNumber getTxtPesarPesoBruto() {
		return txtPesarPesoBruto;
	}

	public void setTxtPesarPesoBruto(InputNumber txtPesarPesoBruto) {
		this.txtPesarPesoBruto = txtPesarPesoBruto;
	}

	public InputNumber getTxtPesarPesoTara() {
		return txtPesarPesoTara;
	}

	public void setTxtPesarPesoTara(InputNumber txtPesarPesoTara) {
		this.txtPesarPesoTara = txtPesarPesoTara;
	}

	public InputText getValorPesaje() {
		return valorPesaje;
	}

	public void setValorPesaje(InputText valorPesaje) {
		this.valorPesaje = valorPesaje;
	}

	public Double getPesoBrutoDef() {
		return pesoBrutoDef;
	}

	public void setPesoBrutoDef(Double pesoBrutoDef) {
		this.pesoBrutoDef = pesoBrutoDef;
	}

	public Double getPesoTaraDef() {
		return pesoTaraDef;
	}

	public void setPesoTaraDef(Double pesoTaraDef) {
		this.pesoTaraDef = pesoTaraDef;
	}

	public SelectOneMenu getTxtTipoPesoPes() {
		return txtTipoPesoPes;
	}

	public void setTxtTipoPesoPes(SelectOneMenu txtTipoPesoPes) {
		this.txtTipoPesoPes = txtTipoPesoPes;
	}

	public OutputLabel getNombre1() {
		return nombre1;
	}

	public void setNombre1(OutputLabel nombre1) {
		this.nombre1 = nombre1;
	}

	public OutputLabel getNombre2() {
		return nombre2;
	}

	public void setNombre2(OutputLabel nombre2) {
		this.nombre2 = nombre2;
	}

	public CommandButton getBtnSavePes() {
		return btnSavePes;
	}

	public void setBtnSavePes(CommandButton btnSavePes) {
		this.btnSavePes = btnSavePes;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public HttpServletRequest getOrigRequest() {
		return origRequest;
	}

	public void setOrigRequest(HttpServletRequest origRequest) {
		this.origRequest = origRequest;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public CommandButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(CommandButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

	public CommandButton getBtnCalcular() {
		return btnCalcular;
	}

	public void setBtnCalcular(CommandButton btnCalcular) {
		this.btnCalcular = btnCalcular;
	}

	public boolean isEstadoGrabar() {
		return estadoGrabar;
	}

	public void setEstadoGrabar(boolean estadoGrabar) {
		this.estadoGrabar = estadoGrabar;
	}

	public InputNumber getTxtPesarPesoNeto() {
		return txtPesarPesoNeto;
	}

	public void setTxtPesarPesoNeto(InputNumber txtPesarPesoNeto) {
		this.txtPesarPesoNeto = txtPesarPesoNeto;
	}

	public InputText getTxtConsecutivoNeto() {
		return txtConsecutivoNeto;
	}

	public void setTxtConsecutivoNeto(InputText txtConsecutivoNeto) {
		this.txtConsecutivoNeto = txtConsecutivoNeto;
	}

	public InputText getTxtConsecutivoNetoDes() {
		return txtConsecutivoNetoDes;
	}

	public void setTxtConsecutivoNetoDes(InputText txtConsecutivoNetoDes) {
		this.txtConsecutivoNetoDes = txtConsecutivoNetoDes;
	}

	public InputText getTxtConsecutivoNetoSer() {
		return txtConsecutivoNetoSer;
	}

	public void setTxtConsecutivoNetoSer(InputText txtConsecutivoNetoSer) {
		this.txtConsecutivoNetoSer = txtConsecutivoNetoSer;
	}

	public CommandButton getBtnNewConductorPro() {
		return btnNewConductorPro;
	}

	public void setBtnNewConductorPro(CommandButton btnNewConductorPro) {
		this.btnNewConductorPro = btnNewConductorPro;
	}

	public CommandButton getBtnNewConductorDes() {
		return btnNewConductorDes;
	}

	public void setBtnNewConductorDes(CommandButton btnNewConductorDes) {
		this.btnNewConductorDes = btnNewConductorDes;
	}

	public CommandButton getBtnNewConductorSer() {
		return btnNewConductorSer;
	}

	public void setBtnNewConductorSer(CommandButton btnNewConductorSer) {
		this.btnNewConductorSer = btnNewConductorSer;
	}

	public CommandButton getBtnNewVehiculoPro() {
		return btnNewVehiculoPro;
	}

	public void setBtnNewVehiculoPro(CommandButton btnNewVehiculoPro) {
		this.btnNewVehiculoPro = btnNewVehiculoPro;
	}

	public CommandButton getBtnNewVehiculoDes() {
		return btnNewVehiculoDes;
	}

	public void setBtnNewVehiculoDes(CommandButton btnNewVehiculoDes) {
		this.btnNewVehiculoDes = btnNewVehiculoDes;
	}

	public CommandButton getBtnNewVehiculoSer() {
		return btnNewVehiculoSer;
	}

	public void setBtnNewVehiculoSer(CommandButton btnNewVehiculoSer) {
		this.btnNewVehiculoSer = btnNewVehiculoSer;
	}

	public CommandButton getBtnCalcularPro() {
		return btnCalcularPro;
	}

	public void setBtnCalcularPro(CommandButton btnCalcularPro) {
		this.btnCalcularPro = btnCalcularPro;
	}

	public CommandButton getBtnCalcularDes() {
		return btnCalcularDes;
	}

	public void setBtnCalcularDes(CommandButton btnCalcularDes) {
		this.btnCalcularDes = btnCalcularDes;
	}

	public CommandButton getBtnCalcularSer() {
		return btnCalcularSer;
	}

	public void setBtnCalcularSer(CommandButton btnCalcularSer) {
		this.btnCalcularSer = btnCalcularSer;
	}

	public Calendar getTxtFechaEstadoVehiculoPro() {
		return txtFechaEstadoVehiculoPro;
	}

	public void setTxtFechaEstadoVehiculoPro(Calendar txtFechaEstadoVehiculoPro) {
		this.txtFechaEstadoVehiculoPro = txtFechaEstadoVehiculoPro;
	}

	public Calendar getTxtFechaEstadoVehiculoDes() {
		return txtFechaEstadoVehiculoDes;
	}

	public void setTxtFechaEstadoVehiculoDes(Calendar txtFechaEstadoVehiculoDes) {
		this.txtFechaEstadoVehiculoDes = txtFechaEstadoVehiculoDes;
	}

	public Calendar getTxtFechaEstadoVehiculoSer() {
		return txtFechaEstadoVehiculoSer;
	}

	public void setTxtFechaEstadoVehiculoSer(Calendar txtFechaEstadoVehiculoSer) {
		this.txtFechaEstadoVehiculoSer = txtFechaEstadoVehiculoSer;
	}

	public Equipo getSelectedEquipos() {
		return selectedEquipos;
	}

	public void setSelectedEquipos(Equipo selectedEquipos) {
		this.selectedEquipos = selectedEquipos;
	}

	public InputText getTxtVariableTexto1() {
		return txtVariableTexto1;
	}

	public void setTxtVariableTexto1(InputText txtVariableTexto1) {
		this.txtVariableTexto1 = txtVariableTexto1;
	}

	public InputText getTxtTiquetePesoNeto() {
		return txtTiquetePesoNeto;
	}

	public void setTxtTiquetePesoNeto(InputText txtTiquetePesoNeto) {
		this.txtTiquetePesoNeto = txtTiquetePesoNeto;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
	
}
