package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatAplicProdDet;

import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.DatServicioDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.EquipoTrabajo;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.SistemaRiego;
import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.TurnoCampo;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.modelo.dto.DatAplicProductoDTO;

import co.com.arcosoft.modelo.dto.DatPlanillaNominaDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;
import co.com.arcosoft.modelo.dto.DatRiegoDTO;
import co.com.arcosoft.modelo.dto.DatServicioDTO;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;
import co.com.arcosoft.modelo.dto.Nivel4DTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.CostosInsumosDetalladoDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDetalladoDTO;
import co.com.arcosoft.modelo.informes.dto.NominaDetalladaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.DriverManagerDataSourceUtils;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatLaboresManoObraMecanizadasView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatLaboresManoObraMecanizadasView.class);
	private Spinner txtNPases;
	private InputText txtAnio;
	private InputText txtCantidadPago;
	private InputText txtCantidadProd;
	private InputText txtCierreCostos;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtCostoTotal;
	private InputText txtDocumetoErp;
	private InputText txtEdadEjecucion;
	private SelectOneRadio txtEstado;
	private InputText txtEtapaId;
	private Calendar txtFechaRegistro;
	private InputText txtIdMobile;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private Calendar txtFechaAnulacion;
	private InputText txtPrecision;
	private InputText txtUsuarioDigitacion;
	private InputText txtValorUnitario;
	private InputText txtVariedId;
	private InputText txtPlanillaNominaId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatPlanillaNominaDTO> data;
	private BigDecimal tarifaPago = new BigDecimal("0");
	private BigDecimal tarifaNoEncontrada = new BigDecimal("0");
	private BigDecimal tarifaPagoT = new BigDecimal("0");
	private BigDecimal bonificacionT = new BigDecimal("0");
	private BigDecimal rendimientoT = new BigDecimal("0");
	private BigDecimal auxSabado = new BigDecimal("0");
	private Long diaSabado = 0L;
	private BigDecimal tarifaPagoP = new BigDecimal("0");
	private BigDecimal tarifaNoEncontradaT = new BigDecimal("0");
	private DatPlanillaNominaDTO selectedDatPlanillaNomina;
	private DatPlanillaNomina entity;
	private DatPlanillaNominaDet entityDet;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	private double result;

	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private SelectOneMenu txtEqpTrabId_EquipoTrabajo;
	SelectItem[] selectEquipoTrabajo;
	private List<EquipoTrabajo> equipoTrabajo;

	private SelectOneMenu txtOrdenTrabajo;
	SelectItem[] selectOrdenTrabajo;
	private List<DatPlanLaborDet> ordenTrabajo;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private SelectOneMenu txtNivel4Erp;
	SelectItem[] selectNivel4Erp;
	private List<ListaNivel4DTO> nivel4Erp;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtUdadMedPago;
	SelectItem[] selectUdadMedPago;
	private List<UdadMed> udadMedPago;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtContratistaId_Contratista;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	SelectItem[] selectNivel2Edit;
	private List<Nivel2> nivel2Edit;

	SelectItem[] selectNivel4Edit;
	private List<Nivel4> nivel4Edit;

	/*** detalle M.O ***/
	private List<DatPlanillaNominaDetDTO> dataPlanillaDet;
	private DatPlanillaNominaDetDTO selectedDatPlanillaDet;

	private InputText txtCodTrabajadorNomina;
	private InputText txtCodConceptoNomina;
	private InputText txtCodUmPagoNomina;

	private InputText txtPesoPromedio;
	private InputText txtCantidadDescontar;
	private SelectOneMenu txtEstadoIncidencia;
	private SelectOneMenu txtAlturaPlanta;
	
	private SelectOneMenu txtPersEmpr;
	SelectItem[] selectPersEmpr;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;
	
	private SelectOneMenu txtTipoPersonal;

	private InputText txtNombreNivel4;
	private InputText txtNombreNivel2;
	private InputText txtNombreLabor;

	private DatPlanillaNominaDet entityDatPlanillaNominaDet;

	/*************** maquinaria ***/

	private DatServicioDTO selectedDatServicio;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtUdadMaquinaria;
	SelectItem[] selectUdadMaquinaria;
	private List<UdadMed> udadMaquinaria;

	private InputText txtCostoTotalMaquinaria;
	private Calendar txtHoraFinalMaquinaria;
	private Calendar txtHoraInicialMaquinaria;
	private BigDecimal tarifaPagoMaquina = new BigDecimal("0");
	private BigDecimal tarifaMaquinariaNoEncontrada = new BigDecimal("0");
	private InputText txtTotalHorasMaquinaria;
	private InputText txtValorUnitMaquinaria;
	private InputText txtDatServicioId;

	private DatServicioDet entityDatServicioDet;

	private SelectOneRadio txtRequiereMaquinaria;

	private List<DatServicioDetDTO> dataServicioDet;
	private DatServicioDetDTO selectedDatServicioDet;

	private InputText txtCodUmPagoMaquinaria;
	private InputText txtCodEquipo;

	private SelectOneMenu txtOrdenTrabajoMaq;
	SelectItem[] selectOrdenTrabajoMaq;
	private List<DatPlanLaborDet> ordenTrabajoMaq;

	private SelectOneMenu txtNivel2IdMaq;
	SelectItem[] selectNivel2Maq;
	private List<Nivel2> nivel2Maq;

	private SelectOneMenu txtNivel3IdMaq;
	SelectItem[] selectNivel3Maq;
	private List<Nivel3> nivel3Maq;

	private SelectOneMenu txtNivel4Id_Nivel4Maq;
	SelectItem[] selectNivel4Maq;
	private List<Nivel4> nivel4Maq;

	private SelectOneMenu txtNivel4ErpMaq;
	SelectItem[] selectNivel4ErpMaq;
	private List<ListaNivel4DTO> nivel4ErpMaq;

	SelectItem[] selectNivel2MaqEdit;
	private List<Nivel2> nivel2MaqEdit;

	SelectItem[] selectNivel4MaqEdit;
	private List<Nivel4> nivel4MaqEdit;

	private SelectOneMenu txtLaborId_LaborMaq;
	SelectItem[] selectLaborIdMaq;
	private List<Labor> laborIdMaq;

	private InputText txtNombreNivel2Maq;
	private InputText txtNombreNivel4Maq;
	private InputText txtNombreLaborMaq;

	
	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;
	
	/**** insumos *****/
	private DatAplicProductoDTO selectedDatAplicProducto;

	private BigDecimal tarifaPagoInsumos = new BigDecimal("0");
	private BigDecimal tarifaInsumosNoEncontrada = new BigDecimal("0");
	private InputText txtDatAplicProdId;
	private InputText txtNumTinas;

	private DatAplicProdDet entityDatAplicProdDet;

	SelectItem[] selectNivel2ProdEdit;
	private List<Nivel2> nivel2ProdEdit;

	SelectItem[] selectNivel4ProdEdit;
	private List<Nivel4> nivel4ProdEdit;

	/** Campos de pantalla de detalle de productos **/
	private InputText txtAreaAplicada;
	private InputText txtCantidadAplicada;
	private InputText txtCostoTotalInsumos;
	private InputText txtDosis;
	private InputText txtValorUnitInsumos;
	private CommandButton btnAgregar;
	private CommandButton btnAgregarMaquinaria;
	private CommandButton btnAgregarNomina;
	private CommandButton btnAgregarRiego;

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;

	private SelectOneMenu txtSupervisorInsumos;
	SelectItem[] selectSupervisorInsumos;
	private List<Trabajador> supervisorInsumos;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtUdadMedIdProducto;
	SelectItem[] selectUdadMedProducto;
	private List<UdadMed> udadMedProducto;

	private List<DatAplicProdDetDTO> dataDetProductos;
	private DatAplicProdDetDTO selectedDatAplicProd;
	private InputText txtNroPlantas;
	private InputText txtNombreProducto;
	private InputText txtNombreUdadMed;

	private SelectOneMenu txtOrdenTrabajoProd;
	SelectItem[] selectOrdenTrabajoProd;
	private List<DatPlanLaborDet> ordenTrabajoProd;

	private SelectOneMenu txtNivel2IdProd;
	SelectItem[] selectNivel2Prod;
	private List<Nivel2> nivel2Prod;

	private SelectOneMenu txtNivel3IdProd;
	SelectItem[] selectNivel3Prod;
	private List<Nivel3> nivel3Prod;

	private SelectOneMenu txtNivel4Id_Nivel4Prod;
	SelectItem[] selectNivel4Prod;
	private List<Nivel4> nivel4Prod;

	private SelectOneMenu txtNivel4ErpProd;
	SelectItem[] selectNivel4ErpProd;
	private List<ListaNivel4DTO> nivel4ErpProd;

	SelectItem[] selectNivel2RiegoEdit;
	private List<Nivel2> nivel2RiegoEdit;

	SelectItem[] selectNivel4RiegoEdit;
	private List<Nivel4> nivel4RiegoEdit;

	private SelectOneMenu txtLaborId_LaborProd;
	SelectItem[] selectLaborIdProd;
	private List<Labor> laborIdProd;

	private InputText txtNombreNivel2Prod;
	private InputText txtNombreNivel4Prod;
	private InputText txtNombreLaborProd;
	private InputText txtNombreAlmacenProd;

	/******************************************/

	/*** riegos ***/
	private List<DatRiegoDTO> dataRiegos;
	private DatRiegoDTO selectedDatRiegos;

	private DatRiegoDTO selectedDatRiego;
	private DatRiego entityRiego;

	private SelectOneMenu txtSistemaRiegoId_SistemaRiego;
	SelectItem[] selectSistemaRiego;
	private List<SistemaRiego> sistemaRiego;

	private SelectOneMenu txtInfraId_Infraestructura;
	SelectItem[] selectInfraestructura;
	private List<Infraestructura> infratestructura;

	private SelectOneMenu txtTrabIdSupervisorRiego;
	SelectItem[] selectTrabajadorRiego;
	private List<Trabajador> trabajadorRiego;
	private InputText txtDatRiegoId;

	private InputText txtAreaRegada;
	private InputText txtCaudalNivel4;
	private Calendar txtHoraFinNivel4;
	private Calendar txtHoraIniNivel4;
	private InputText txtHoraTotalNivel4;
	private InputText txtVolTotalNivel4;
	private InputText txtNumeroTiquete;

	private InputText txtHorometroInicalMq;
	private InputText txtHorometroFinalMq;
	private InputText txtTotalHorometro;

	private Spinner txtNumeroRiegos;
	private InputText txtHorometroFinalR;
	private InputText txtHorometroInicalR;
	private InputText txtTotalAreaRegada;
	private SelectOneMenu txtTurnoCampoId_turnoCampo;
	SelectItem[] selectTurnoCampo;
	private List<TurnoCampo> turnoCampo;

	private InputText txtkwhIncial;
	private InputText txtkwhFinal;
	private InputText txtsurcosLargos;
	private InputText txtsurcosCortos;

	private SelectOneMenu txtOrdenTrabajoRiego;
	SelectItem[] selectOrdenTrabajoRiego;
	private List<DatPlanLaborDet> ordenTrabajoRiego;

	private SelectOneMenu txtNivel2IdRiego;
	SelectItem[] selectNivel2Riego;
	private List<Nivel2> nivel2Riego;

	private SelectOneMenu txtNivel3IdRiego;
	SelectItem[] selectNivel3Riego;
	private List<Nivel3> nivel3Riego;

	private SelectOneMenu txtNivel4Id_Nivel4Riego;
	SelectItem[] selectNivel4Riego;
	private List<Nivel4> nivel4Riego;

	private SelectOneMenu txtNivel4ErpRiego;
	SelectItem[] selectNivel4ErpRiego;
	private List<ListaNivel4DTO> nivel4ErpRiego;

	private SelectOneMenu txtLaborId_LaborRiego;
	SelectItem[] selectLaborIdRiego;
	private List<Labor> laborIdRiego;

	private InputText txtNombreNivel2Riego;
	private InputText txtNombreNivel4Riego;
	private InputText txtNombreLaborRiego;

	private InputText txtNombreInfraestructura;
	private InputText txtCodigoSupervisorRiego;
	private InputText txtNombreSistemaRiego;
	private InputText txtCodigoTurnoCampo;

	private int activeTapIndex = 0;
	private Spinner txtHorasTrabajadas;

	/**** FILTROS DEL REPORTE ***/

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private ListaPlanillaNominaDTO selectedDatPlanillaNominaLista;
	private List<ListaPlanillaNominaDTO> selectedDatPlanillaNominaListaMultiple;
	private List<ListaPlanillaNominaDTO> data2;

	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtCantidadAcumulado;

	private InputNumber txtTotalRegistros;
	private InputNumber txtTotalUnidades;
	private InputText txtPlanilla;
	private SelectOneMenu txtEstadoPlanilla;

	private SelectOneMenu txtTipoDistribucion;
	private SelectOneMenu txtTipoDistribucionMaq;
	private SelectOneMenu txtTipoDistribucionProd;
	private SelectOneMenu txtTipoDistribucionRiego;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";

	private List<String> selectedNivel4ManoObra;
	private List<ListaNivel4DTO> lotesManoObra;
	private List<NominaDetalladaDTO> dataDetalle;
	
	private List<String> selectedTrabajador;
	private List<Trabajador> trabajadores;

	private NominaDetalladaDTO selectNominaDetallada;

	private List<String> selectedNivel3ManoObra;
	private List<Nivel3> bloquesManoObra;

	private List<String> selectedNivel3Maq;
	private List<Nivel3> bloquesMaq;

	private List<String> selectedNivel3Prod;
	private List<Nivel3> bloquesProd;

	private List<String> selectedNivel3Riego;
	private List<Nivel3> bloquesRiego;

	private List<String> selectedNivel4Maq;
	private List<ListaNivel4DTO> lotesMaq;

	private List<String> selectedNivel4Prod;
	private List<ListaNivel4DTO> lotesProd;

	private List<String> selectedNivel4Riego;
	private List<ListaNivel4DTO> lotesRiego;

	private InputText txtCantidadMaq;
	
	private SelectOneMenu txtOrigenDatos;
	
	/*** Edit de insumos ***/	
	
	
	public DatLaboresManoObraMecanizadasView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatPlanillaNomina = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatPlanillaNomina = null;
		PrimeFaces.current().resetInputs(":dialogDatPlanillaNomina :frm");
		activeTapIndex = 0;

		if (txtHorasTrabajadas != null) {
			txtHorasTrabajadas.setValue(null);
			txtHorasTrabajadas.setDisabled(false);
		}

		if (txtTipoPersonal != null) {
			txtTipoPersonal.setValue(null);
			txtTipoPersonal.setDisabled(false);
		}

		if (txtCantidadMaq != null) {
			txtCantidadMaq.setValue(null);
			txtCantidadMaq.setDisabled(false);
		}
		
		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}
		if (dataDetProductos != null) {
			dataDetProductos = null;
		}
		if (dataPlanillaDet != null) {
			dataPlanillaDet = null;
		}
		if (dataServicioDet != null) {
			dataServicioDet = null;
		}

		if (dataRiegos != null) {
			dataRiegos = null;
		}

		if (txtNPases != null) {
			txtNPases.setValue(null);
			txtNPases.setDisabled(true);
		}

		if (txtCodConceptoNomina != null) {
			txtCodConceptoNomina.setValue(null);
			txtCodConceptoNomina.setDisabled(true);
		}

		if (txtCodTrabajadorNomina != null) {
			txtCodTrabajadorNomina.setValue(null);
			txtCodTrabajadorNomina.setDisabled(true);
		}

		if (txtCodUmPagoMaquinaria != null) {
			txtCodUmPagoMaquinaria.setValue(null);
			txtCodUmPagoMaquinaria.setDisabled(true);
		}

		if (btnAgregarNomina != null) {
			btnAgregarNomina.setDisabled(false);
		}

		if (btnAgregarRiego != null) {
			btnAgregarRiego.setDisabled(false);
		}

		if (txtAnio != null) {
			txtAnio.setValue(null);
			txtAnio.setDisabled(true);
		}

		if (txtCantidadPago != null) {
			txtCantidadPago.setValue(0);
			txtCantidadPago.setDisabled(false);
		}

		if (txtCantidadProd != null) {
			txtCantidadProd.setValue(null);
			txtCantidadProd.setDisabled(true);
		}

		if (txtCierreCostos != null) {
			txtCierreCostos.setValue(null);
			txtCierreCostos.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(0);
			txtCostoTotal.setDisabled(false);
		}

		if (txtDocumetoErp != null) {
			txtDocumetoErp.setValue(null);
			txtDocumetoErp.setDisabled(true);
		}

		if (txtEdadEjecucion != null) {
			txtEdadEjecucion.setValue(null);
			txtEdadEjecucion.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtEtapaId != null) {
			txtEtapaId.setValue(null);
			txtEtapaId.setDisabled(true);
		}

		if (txtFechaRegistro != null) {
			Date data = new Date();
			txtFechaRegistro.setValue(data);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtIdMobile != null) {
			txtIdMobile.setValue(null);
			txtIdMobile.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(true);
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

		if (txtOrdenTrabajo != null) {
			txtOrdenTrabajo.setValue(null);
			txtOrdenTrabajo.setDisabled(false);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtUdadMedPago != null) {
			txtUdadMedPago.setValue(null);
			txtUdadMedPago.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(0);
			txtValorUnitario.setDisabled(false);
		}

		if (txtVariedId != null) {
			txtVariedId.setValue(null);
			txtVariedId.setDisabled(true);
		}

		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		}

		if (txtContratistaId_Contratista != null) {
			txtContratistaId_Contratista.setValue(null);
			txtContratistaId_Contratista.setDisabled(true);
		}

		if (txtEqpTrabId_EquipoTrabajo != null) {
			txtEqpTrabId_EquipoTrabajo.setValue(null);
			txtEqpTrabId_EquipoTrabajo.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (txtNivel4Erp != null) {
			txtNivel4Erp.setValue(null);
			txtNivel4Erp.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtPersEmpr != null) {
			txtPersEmpr.setValue(null);
			txtPersEmpr.setDisabled(false);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtPlanillaNominaId != null) {
			txtPlanillaNominaId.setValue(null);
			txtPlanillaNominaId.setDisabled(false);
		}

		if (txtNombreNivel2 != null) {
			txtNombreNivel2.setValue(null);
			txtNombreNivel2.setDisabled(false);
		}

		if (txtNombreNivel4 != null) {
			txtNombreNivel4.setValue(null);
			txtNombreNivel4.setDisabled(false);
		}

		if (txtNombreLabor != null) {
			txtNombreLabor.setValue(null);
			txtNombreLabor.setDisabled(false);
		}

		/***** maquinaria ***/

		if (txtDatServicioId != null) {
			txtDatServicioId.setValue(null);
			txtDatServicioId.setDisabled(false);
		}
		if (txtCostoTotalMaquinaria != null) {
			txtCostoTotalMaquinaria.setValue(0);
			txtCostoTotalMaquinaria.setDisabled(false);
		}

		if (txtHoraFinalMaquinaria != null) {
			txtHoraFinalMaquinaria.setValue(null);
			txtHoraFinalMaquinaria.setDisabled(false);
		}
		if (txtHoraInicialMaquinaria != null) {
			txtHoraInicialMaquinaria.setValue(null);
			txtHoraInicialMaquinaria.setDisabled(false);
		}

		if (txtTotalHorasMaquinaria != null) {
			txtTotalHorasMaquinaria.setValue(0);
			txtTotalHorasMaquinaria.setDisabled(false);
		}

		if (txtValorUnitMaquinaria != null) {
			txtValorUnitMaquinaria.setValue(0);
			txtValorUnitMaquinaria.setDisabled(false);
		}

		if (txtRequiereMaquinaria != null) {
			txtRequiereMaquinaria.setValue("No");
			txtRequiereMaquinaria.setDisabled(false);
		}

		if (txtCodEquipo != null) {
			txtCodEquipo.setValue(0);
			txtCodEquipo.setDisabled(false);
		}

		if (txtCodUmPagoMaquinaria != null) {
			txtCodUmPagoMaquinaria.setValue(null);
			txtCodUmPagoMaquinaria.setDisabled(false);
		}
		if (txtNumeroTiquete != null) {
			txtNumeroTiquete.setValue(null);
			txtNumeroTiquete.setDisabled(false);
		}

		if (btnAgregarMaquinaria != null) {
			btnAgregarMaquinaria.setDisabled(false);
		}

		if (txtHorometroInicalMq != null) {
			txtHorometroInicalMq.setValue(null);
			txtHorometroInicalMq.setDisabled(false);
		}

		if (txtHorometroFinalMq != null) {
			txtHorometroFinalMq.setValue(null);
			txtHorometroFinalMq.setDisabled(false);
		}

		if (txtNivel2IdMaq != null) {
			txtNivel2IdMaq.setValue(null);
			txtNivel2IdMaq.setDisabled(false);
		}

		if (txtNivel3IdMaq != null) {
			txtNivel3IdMaq.setValue(null);
			txtNivel3IdMaq.setDisabled(false);
		}

		if (txtOrdenTrabajoMaq != null) {
			txtOrdenTrabajoMaq.setValue(null);
			txtOrdenTrabajoMaq.setDisabled(false);
		}

		if (txtLaborId_LaborMaq != null) {
			txtLaborId_LaborMaq.setValue(null);
			txtLaborId_LaborMaq.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4Maq != null) {
			txtNivel4Id_Nivel4Maq.setValue(null);
			txtNivel4Id_Nivel4Maq.setDisabled(true);
		}

		if (txtNivel4ErpMaq != null) {
			txtNivel4ErpMaq.setValue(null);
			txtNivel4ErpMaq.setDisabled(true);
		}

		if (txtNombreNivel2Maq != null) {
			txtNombreNivel2Maq.setValue(null);
			txtNombreNivel2Maq.setDisabled(false);
		}

		if (txtNombreNivel4Maq != null) {
			txtNombreNivel4Maq.setValue(null);
			txtNombreNivel4Maq.setDisabled(false);
		}

		if (txtNombreLaborMaq != null) {
			txtNombreLaborMaq.setValue(null);
			txtNombreLaborMaq.setDisabled(false);
		}

		/*** riegos **/

		if (txtNombreInfraestructura != null) {
			txtNombreInfraestructura.setValue(null);
			txtNombreInfraestructura.setDisabled(false);
		}
		if (txtCodigoSupervisorRiego != null) {
			txtCodigoSupervisorRiego.setValue(null);
			txtCodigoSupervisorRiego.setDisabled(false);
		}
		if (txtNombreSistemaRiego != null) {
			txtNombreSistemaRiego.setValue(null);
			txtNombreSistemaRiego.setDisabled(false);
		}
		if (txtCodigoTurnoCampo != null) {
			txtCodigoTurnoCampo.setValue(null);
			txtCodigoTurnoCampo.setDisabled(false);
		}

		if (txtDatRiegoId != null) {
			txtDatRiegoId.setValue(null);
			txtDatRiegoId.setDisabled(false);
		}

		if (txtSistemaRiegoId_SistemaRiego != null) {
			txtSistemaRiegoId_SistemaRiego.setValue(null);
			txtSistemaRiegoId_SistemaRiego.setDisabled(false);
		}

		if (txtInfraId_Infraestructura != null) {
			txtInfraId_Infraestructura.setValue(null);
			txtInfraId_Infraestructura.setDisabled(false);
		}

		if (txtTrabIdSupervisorRiego != null) {
			txtTrabIdSupervisorRiego.setValue(null);
			txtTrabIdSupervisorRiego.setDisabled(false);
		}

		if (txtUdadMaquinaria != null) {
			txtUdadMaquinaria.setValue(null);
			txtUdadMaquinaria.setDisabled(false);
		}

		if (txtHoraTotalNivel4 != null) {
			txtHoraTotalNivel4.setValue(0);
			txtHoraTotalNivel4.setDisabled(false);
		}

		if (txtVolTotalNivel4 != null) {
			txtVolTotalNivel4.setValue(0);
			txtVolTotalNivel4.setDisabled(false);
		}

		if (txtHoraIniNivel4 != null) {
			txtHoraIniNivel4.setValue(null);
			txtHoraIniNivel4.setDisabled(false);
		}

		if (txtHoraFinNivel4 != null) {
			txtHoraFinNivel4.setValue(null);
			txtHoraFinNivel4.setDisabled(false);
		}

		if (txtCaudalNivel4 != null) {
			txtCaudalNivel4.setValue(0);
			txtCaudalNivel4.setDisabled(false);
		}

		if (txtAreaRegada != null) {
			txtAreaRegada.setValue(0);
			txtAreaRegada.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		if (txtkwhIncial != null) {
			txtkwhIncial.setValue(0);
			txtkwhIncial.setDisabled(false);
		}

		if (txtkwhFinal != null) {
			txtkwhFinal.setValue(0);
			txtkwhFinal.setDisabled(false);
		}

		if (txtsurcosLargos != null) {
			txtsurcosLargos.setValue(0);
			txtsurcosLargos.setDisabled(false);
		}

		if (txtsurcosCortos != null) {
			txtsurcosCortos.setValue(0);
			txtsurcosCortos.setDisabled(false);
		}

		if (txtTurnoCampoId_turnoCampo != null) {
			txtTurnoCampoId_turnoCampo.setValue(null);
			txtTurnoCampoId_turnoCampo.setDisabled(false);
		}

		if (txtNumeroRiegos != null) {
			txtNumeroRiegos.setValue(null);
			txtNumeroRiegos.setDisabled(false);
		}

		if (txtHorometroFinalR != null) {
			txtHorometroFinalR.setValue(null);
			txtHorometroFinalR.setDisabled(false);
		}
		if (txtHorometroInicalR != null) {
			txtHorometroInicalR.setValue(null);
			txtHorometroInicalR.setDisabled(false);
		}
		if (txtTotalAreaRegada != null) {
			txtTotalAreaRegada.setValue(null);
			txtTotalAreaRegada.setDisabled(false);
		}
		if (txtTotalHorometro != null) {
			txtTotalHorometro.setValue(null);
			txtTotalHorometro.setDisabled(false);
		}

		if (txtNivel2IdRiego != null) {
			txtNivel2IdRiego.setValue(null);
			txtNivel2IdRiego.setDisabled(false);
		}

		if (txtNivel3IdRiego != null) {
			txtNivel3IdRiego.setValue(null);
			txtNivel3IdRiego.setDisabled(false);
		}

		if (txtOrdenTrabajoRiego != null) {
			txtOrdenTrabajoRiego.setValue(null);
			txtOrdenTrabajoRiego.setDisabled(false);
		}

		if (txtLaborId_LaborRiego != null) {
			txtLaborId_LaborRiego.setValue(null);
			txtLaborId_LaborRiego.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4Riego != null) {
			txtNivel4Id_Nivel4Riego.setValue(null);
			txtNivel4Id_Nivel4Riego.setDisabled(true);
		}

		if (txtNivel4ErpRiego != null) {
			txtNivel4ErpRiego.setValue(null);
			txtNivel4ErpRiego.setDisabled(true);
		}

		if (txtNombreNivel2Riego != null) {
			txtNombreNivel2Riego.setValue(null);
			txtNombreNivel2Riego.setDisabled(false);
		}

		if (txtNombreNivel4Riego != null) {
			txtNombreNivel4Riego.setValue(null);
			txtNombreNivel4Riego.setDisabled(false);
		}

		if (txtNombreLaborRiego != null) {
			txtNombreLaborRiego.setValue(null);
			txtNombreLaborRiego.setDisabled(false);
		}
		/***** insumos ***/

		if (txtNombreAlmacenProd != null) {
			txtNombreAlmacenProd.setValue(null);
			txtNombreAlmacenProd.setDisabled(false);
		}

		if (txtDatAplicProdId != null) {
			txtDatAplicProdId.setValue(null);
			txtDatAplicProdId.setDisabled(false);
		}
		if (txtAreaAplicada != null) {
			txtAreaAplicada.setValue(0);
			txtAreaAplicada.setDisabled(false);
		}

		if (txtCantidadAplicada != null) {
			txtCantidadAplicada.setValue(0);
			txtCantidadAplicada.setDisabled(false);
		}

		/*
		 * if (txtCostoTotalInsumos != null) { txtCostoTotalInsumos.setValue(0);
		 * txtCostoTotalInsumos.setDisabled(false); }
		 */

		if (txtDosis != null) {
			txtDosis.setValue(0);
			txtDosis.setDisabled(false);
		}

		if (txtValorUnitInsumos != null) {
			txtValorUnitInsumos.setValue(0);
			txtValorUnitInsumos.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (txtAlmacenId_Almacen != null) {
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(false);
		}

		if (txtSupervisorInsumos != null) {
			txtSupervisorInsumos.setValue(null);
			txtSupervisorInsumos.setDisabled(false);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}
		if (txtUdadMedIdProducto != null) {
			txtUdadMedIdProducto.setValue(null);
			txtUdadMedIdProducto.setDisabled(false);
		}

		if (txtNroPlantas != null) {
			txtNroPlantas.setValue(0);
			txtNroPlantas.setDisabled(false);
		}

		if (txtNombreProducto != null) {
			txtNombreProducto.setValue(null);
			txtNombreProducto.setDisabled(false);
		}

		if (txtNombreUdadMed != null) {
			txtNombreUdadMed.setValue(null);
			txtNombreUdadMed.setDisabled(false);
		}

		if (txtNumTinas != null) {
			txtNumTinas.setValue(0);
			txtNumTinas.setDisabled(true);
		}

		if (txtNivel2IdProd != null) {
			txtNivel2IdProd.setValue(null);
			txtNivel2IdProd.setDisabled(false);
		}

		if (txtNivel3IdProd != null) {
			txtNivel3IdProd.setValue(null);
			txtNivel3IdProd.setDisabled(false);
		}

		if (txtOrdenTrabajoProd != null) {
			txtOrdenTrabajoProd.setValue(null);
			txtOrdenTrabajoProd.setDisabled(false);
		}

		if (txtLaborId_LaborProd != null) {
			txtLaborId_LaborProd.setValue(null);
			txtLaborId_LaborProd.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4Prod != null) {
			txtNivel4Id_Nivel4Prod.setValue(null);
			txtNivel4Id_Nivel4Prod.setDisabled(true);
		}

		if (txtNivel4ErpProd != null) {
			txtNivel4ErpProd.setValue(null);
			txtNivel4ErpProd.setDisabled(true);
		}

		if (txtNombreNivel2Prod != null) {
			txtNombreNivel2Prod.setValue(null);
			txtNombreNivel2Prod.setDisabled(false);
		}

		if (txtNombreNivel4Prod != null) {
			txtNombreNivel4Prod.setValue(null);
			txtNombreNivel4Prod.setDisabled(false);
		}

		if (txtNombreLaborProd != null) {
			txtNombreLaborProd.setValue(null);
			txtNombreLaborProd.setDisabled(false);
		}
		/**********************/
		if (txtPesoPromedio != null) {
			txtPesoPromedio.setValue(0.0);
			txtPesoPromedio.setDisabled(false);
		}

		if (txtCantidadDescontar != null) {
			txtCantidadDescontar.setValue(0.0);
			txtCantidadDescontar.setDisabled(false);
		}
		if (txtEstadoIncidencia != null) {
			txtEstadoIncidencia.setValue(null);
			txtEstadoIncidencia.setDisabled(false);
		}

		if (txtAlturaPlanta != null) {
			txtAlturaPlanta.setValue(null);
			txtAlturaPlanta.setDisabled(false);
		}
		
		
		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}
		
		return "";
	}

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
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

	public void ConsultarSalario() throws Exception {

		Long trabId = Long.parseLong(txtTrabId_Trabajador.getValue().toString());
		Long idCeptoNomina = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);

		Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
		ConceptoNomina concepto = businessDelegatorView.getConceptoNomina(idCeptoNomina);
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Date fecharegistro = FacesUtils.checkDate(txtFechaRegistro);
		Double tarifa = 0.0;
		Double valorSalario =0.0;
		Double factorPrestacional =1.0;
		if(concepto.getFactorPrestacional()!=null) {
			factorPrestacional= concepto.getFactorPrestacional();
		}
		if(trabajador.getSalario()==null) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine interprete = manager.getEngineByName("js");
		Bindings scope = interprete.createBindings();
		String result = null;
		String consulta = "select valor_deduccion from tarifa_otros_devengos where :fecha between fecha_inicial and fecha_final and trab_id = :trabid and \r\n"
				+ "concepto_nomina_id = :ceptoid";

		// La clase Spring con la Connection
		// JdbcTemplate jdbcTemplate = new
		// JdbcTemplate(DriverManagerDataSourceUtils.getDatasource());
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DriverManagerDataSourceUtils.getDatasource());

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("trabid", trabId);
		parameters.addValue("ceptoid", idCeptoNomina);
		parameters.addValue("fecha", fecharegistro);

		// String result = new ArrayList<String>();
		ResultSetExtractor<String> extr = new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return rs.getString(1);
				}
				return null;
			}

		};

		result = namedParameterJdbcTemplate.query(consulta, parameters, extr);
		if (result == null) {
			tarifa = 0.0;
		} else {
			tarifa = Double.parseDouble(result);
		}

		String format = decimalFormat.format(tarifa);
		
		txtValorUnitario.setValue(format);
		}else {
			valorSalario=trabajador.getSalario();
			tarifa = (valorSalario/240) *factorPrestacional;
			tarifa = (double) Math.round((tarifa) * 100) / 100;
			txtValorUnitario.setValue(tarifa);
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
				FacesUtils.checkLong(txtNivel4Id_Nivel4)));

		Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
		Long nivel4Id = FacesUtils.checkLong(txtNivel4Id_Nivel4);
		String estadoInc = FacesUtils.checkString(txtEstadoIncidencia);
		String alturaMata = FacesUtils.checkString(txtAlturaPlanta);

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		tarifaPago = businessDelegatorView.consultarTarifaContratista(idCompania, idContratista, idLabor, idCeptoNomina,
				idUdadMed, idFecha, edadLote, estadoInc, nivel2Id, nivel4Id, alturaMata);

		String format = decimalFormat.format(tarifaPago);
		txtValorUnitario.setValue(format);

		if (tarifaPago == null) {
			tarifaNoEncontrada = new BigDecimal("0");
			txtValorUnitario.setValue(tarifaNoEncontrada);

		}

	}

	public void listener_calcularCostoTotal() throws Exception {

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
		Double cantidadPago = FacesUtils.checkDouble(txtCantidadPago);

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Double costoTotal = 0.0;

		if (cantidadPago != null && valorUnitario != null) {
			costoTotal = (cantidadPago.doubleValue()) * valorUnitario;
		}

		String format = decimalFormat.format(costoTotal);
		txtCostoTotal.setValue(format);

		if (txtCostoTotal == null) {
			tarifaNoEncontrada = new BigDecimal("0");
			txtCostoTotal.setValue(tarifaNoEncontrada);

		}

	}

	public void listener_ConsultaOrdenTrabajo() {

		Long planLaborDetId = null;
		if (txtOrdenTrabajo.getValue() != null) {
			planLaborDetId = Long.parseLong(txtOrdenTrabajo.getValue().toString());
			try {

				Long idCompania = new Long(getCompaniaIdSession());

				List<ConsultaOrdenTrabajoDesDTO> dataU = businessDelegatorView
						.consultarOrdenTrabajoEjecucionLabores(idCompania, planLaborDetId);

				if (dataU != null && dataU.size() > 0) {
					ConsultaOrdenTrabajoDesDTO entity1 = dataU.get(0);
					txtLaborId_Labor.setValue(entity1.getLaborId().longValue());
					txtNivel2Id.setValue(entity1.getNivel2Id().longValue());
					txtNivel3Id.setValue(entity1.getNivel3Id().longValue());
					txtNivel4Id_Nivel4.setValue(entity1.getNivel4Id().longValue());
					txtNivel4Id_Nivel4.setDisabled(false);
					txtTipoDistribucion.setDisabled(true);
					txtTipoDistribucion.setValue("lote");

					txtUdadMedPago.setValue(entity1.getUmId().longValue());
					txtCantidadPago.setValue(entity1.getCantidadPlanId());

				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaOrdenTrabajoMaq() {

		Long planLaborDetId = null;
		if (txtOrdenTrabajoMaq.getValue() != null) {
			planLaborDetId = Long.parseLong(txtOrdenTrabajoMaq.getValue().toString());
			try {

				Long idCompania = new Long(getCompaniaIdSession());

				List<ConsultaOrdenTrabajoDesDTO> dataU = businessDelegatorView
						.consultarOrdenTrabajoEjecucionLabores(idCompania, planLaborDetId);

				if (dataU != null && dataU.size() > 0) {
					ConsultaOrdenTrabajoDesDTO entity1 = dataU.get(0);
					txtLaborId_LaborMaq.setValue(entity1.getLaborId().longValue());
					txtNivel2IdMaq.setValue(entity1.getNivel2Id().longValue());
					txtNivel3IdMaq.setValue(entity1.getNivel3Id().longValue());
					txtNivel4Id_Nivel4Maq.setValue(entity1.getNivel4Id().longValue());
					txtNivel4Id_Nivel4Maq.setDisabled(false);
					txtTipoDistribucionMaq.setDisabled(true);
					txtTipoDistribucionMaq.setValue("lote");

				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaOrdenTrabajoProd() {

		Long planLaborDetId = null;
		if (txtOrdenTrabajoProd.getValue() != null) {
			planLaborDetId = Long.parseLong(txtOrdenTrabajoProd.getValue().toString());
			try {

				Long idCompania = new Long(getCompaniaIdSession());

				List<ConsultaOrdenTrabajoDesDTO> dataU = businessDelegatorView
						.consultarOrdenTrabajoEjecucionLabores(idCompania, planLaborDetId);

				if (dataU != null && dataU.size() > 0) {
					ConsultaOrdenTrabajoDesDTO entity1 = dataU.get(0);
					txtLaborId_LaborProd.setValue(entity1.getLaborId().longValue());
					txtNivel2IdProd.setValue(entity1.getNivel2Id().longValue());
					txtNivel3IdProd.setValue(entity1.getNivel3Id().longValue());
					txtNivel4Id_Nivel4Prod.setValue(entity1.getNivel4Id().longValue());
					txtNivel4Id_Nivel4Prod.setDisabled(false);
					txtTipoDistribucionProd.setDisabled(true);
					txtTipoDistribucionProd.setValue("lote");

				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaOrdenTrabajoRiego() {

		Long planLaborDetId = null;
		if (txtOrdenTrabajoRiego.getValue() != null) {
			planLaborDetId = Long.parseLong(txtOrdenTrabajoRiego.getValue().toString());
			try {

				Long idCompania = new Long(getCompaniaIdSession());
				List<ConsultaOrdenTrabajoDesDTO> dataU = businessDelegatorView
						.consultarOrdenTrabajoEjecucionLabores(idCompania, planLaborDetId);

				if (dataU != null && dataU.size() > 0) {
					ConsultaOrdenTrabajoDesDTO entity1 = dataU.get(0);
					txtLaborId_LaborRiego.setValue(entity1.getLaborId().longValue());
					txtNivel2IdRiego.setValue(entity1.getNivel2Id().longValue());
					txtNivel3IdRiego.setValue(entity1.getNivel3Id().longValue());
					txtNivel4Id_Nivel4Riego.setValue(entity1.getNivel4Id().longValue());
					txtNivel4Id_Nivel4Riego.setDisabled(false);
					txtTipoDistribucionRiego.setDisabled(true);
					txtTipoDistribucionRiego.setValue("lote");

					Nivel4 nivel4 = businessDelegatorView.getNivel4(entity1.getNivel4Id().longValue());
					txtAreaRegada.setValue(nivel4.getAreaNeta());

				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public String action_edit(ActionEvent evt) {
		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		try {
			Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
			Object[] condicion = { "planillaNominaId", true, planillaNominaId, "=" };
			List<DatPlanillaNomina> lista = (planillaNominaId != null)
					? businessDelegatorView.findByCriteriaInDatPlanillaNomina(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPlanillaNominaId.setValue(entity.getPlanillaNominaId());
				txtPlanillaNominaId.setDisabled(true);
				txtCantidadPago.setDisabled(false);
				txtValorUnitario.setDisabled(false);
				txtCantidadPago.setValue(0.0);
				txtValorUnitario.setValue(0.0);
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				txtTrabId_Trabajador.setDisabled(false);
				txtUdadMedPago.setDisabled(false);
				txtNivel2Id.setDisabled(false);

				txtLaborId_Labor.setDisabled(false);

				// txtNivel4Id_Nivel4.setDisabled(false);

				btnAgregarNomina.setDisabled(false);

				/******* sesion concerniente al detalle por trabajador ***/
				Long planillaNomina = FacesUtils.checkLong(txtPlanillaNominaId);
				dataPlanillaDet = null;
				dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNomina);

				/******* maquinaria *****/
				dataServicioDet = null;
				dataServicioDet = businessDelegatorView.getDataDatServicioDetByPlanillaNomina(planillaNomina);

				txtEquipoId_Equipo.setDisabled(false);
				txtUdadMaquinaria.setDisabled(false);
			//	txtCostoTotalMaquinaria.setDisabled(false);
			//	txtHoraFinalMaquinaria.setDisabled(false);
			//	txtHoraInicialMaquinaria.setDisabled(false);
			//	txtTotalHorasMaquinaria.setDisabled(false);
				txtValorUnitMaquinaria.setDisabled(false);
				txtImplemento.setDisabled(false);
				txtHorometroFinalMq.setDisabled(false);
				txtHorometroInicalMq.setDisabled(false);
				btnAgregarMaquinaria.setDisabled(false);
				
			
				txtCantidadMaq.setDisabled(false);
				

				txtNivel2IdMaq.setDisabled(false);
				// txtNivel3IdMaq.setDisabled(false);
				txtLaborId_LaborMaq.setDisabled(false);
				// txtNivel4Id_Nivel4Maq.setDisabled(false);

				/************************
				 * sesion concerniente al detalle de riegos
				 ****************/

				dataRiegos = null;
				dataRiegos = businessDelegatorView.getDataDatRiegoByPlanillaNomina(planillaNomina);

				txtInfraId_Infraestructura.setDisabled(false);
				txtTrabIdSupervisorRiego.setDisabled(false);
			//	txtHoraTotalNivel4.setDisabled(false);
				txtVolTotalNivel4.setDisabled(false);
			//	txtHoraIniNivel4.setDisabled(false);
			//	txtHoraFinNivel4.setDisabled(false);
				txtCaudalNivel4.setDisabled(false);
				//txtAreaRegada.setDisabled(false);

				txtTurnoCampoId_turnoCampo.setDisabled(false);
				txtNumeroRiegos.setDisabled(false);
				txtHorometroFinalR.setDisabled(false);
				txtHorometroInicalR.setDisabled(false);
				txtTotalAreaRegada.setDisabled(false);
			//	txtTotalHorometro.setDisabled(false);

				btnAgregarRiego.setDisabled(false);

				txtNivel2IdRiego.setDisabled(false);
				// txtNivel3IdRiego.setDisabled(false);
				txtLaborId_LaborRiego.setDisabled(false);
				// txtNivel4Id_Nivel4Riego.setDisabled(false);
				txtSistemaRiegoId_SistemaRiego.setDisabled(false);

				/*********************** insumos ***/
				dataDetProductos = null;
				dataDetProductos = businessDelegatorView.getDataDetProductosByPlanillaNomina(planillaNomina);

				txtNumTinas.setDisabled(false);
				txtAlmacenId_Almacen.setDisabled(false);
				txtCantidadAplicada.setDisabled(false);
				// txtCostoTotalInsumos.setDisabled(false);
				txtValorUnitInsumos.setDisabled(false);
				txtProductoId_Producto.setDisabled(false);
				txtUdadMedIdProducto.setDisabled(false);
				btnAgregar.setDisabled(false);

				txtNivel2IdProd.setDisabled(false);
				// txtNivel3IdProd.setDisabled(false);
				txtLaborId_LaborProd.setDisabled(false);
				// txtNivel4Id_Nivel4Prod.setDisabled(false);

				txtOrdenTrabajo.setDisabled(false);
				txtOrdenTrabajoProd.setDisabled(false);
				txtOrdenTrabajoMaq.setDisabled(false);
				txtOrdenTrabajoRiego.setDisabled(false);

				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
		}
		return "";
	}


	public String action_edit_riegos(ActionEvent evt) {
		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		try {
			Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
			Object[] condicion = { "planillaNominaId", true, planillaNominaId, "=" };
			List<DatPlanillaNomina> lista = (planillaNominaId != null)
					? businessDelegatorView.findByCriteriaInDatPlanillaNomina(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPlanillaNominaId.setValue(entity.getPlanillaNominaId());
				txtPlanillaNominaId.setDisabled(true);
				
				/******* sesion concerniente al detalle por trabajador ***/
				Long planillaNomina = FacesUtils.checkLong(txtPlanillaNominaId);
				
				/************************
				 * sesion concerniente al detalle de riegos
				 ****************/

				dataRiegos = null;
				dataRiegos = businessDelegatorView.getDataDatRiegoByPlanillaNomina(planillaNomina);

				txtInfraId_Infraestructura.setDisabled(false);
				txtTrabIdSupervisorRiego.setDisabled(false);
			//	txtHoraTotalNivel4.setDisabled(false);
				txtVolTotalNivel4.setDisabled(false);
			//	txtHoraIniNivel4.setDisabled(false);
			//	txtHoraFinNivel4.setDisabled(false);
				txtCaudalNivel4.setDisabled(false);
				//txtAreaRegada.setDisabled(false);

				txtTurnoCampoId_turnoCampo.setDisabled(false);
				txtNumeroRiegos.setDisabled(false);
				txtHorometroFinalR.setDisabled(false);
				txtHorometroInicalR.setDisabled(false);
				txtTotalAreaRegada.setDisabled(false);
			//	txtTotalHorometro.setDisabled(false);

				btnAgregarRiego.setDisabled(false);

				txtNivel2IdRiego.setDisabled(false);
				// txtNivel3IdRiego.setDisabled(false);
				txtLaborId_LaborRiego.setDisabled(false);
				// txtNivel4Id_Nivel4Riego.setDisabled(false);
				txtSistemaRiegoId_SistemaRiego.setDisabled(false);

				txtOrdenTrabajoRiego.setDisabled(false);

				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	


	public String action_edit_insumos(ActionEvent evt) {
		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		try {
			Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
			Object[] condicion = { "planillaNominaId", true, planillaNominaId, "=" };
			List<DatPlanillaNomina> lista = (planillaNominaId != null)
					? businessDelegatorView.findByCriteriaInDatPlanillaNomina(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPlanillaNominaId.setValue(entity.getPlanillaNominaId());
				txtPlanillaNominaId.setDisabled(true);
				
				/******* sesion concerniente al detalle por trabajador ***/
				Long planillaNomina = FacesUtils.checkLong(txtPlanillaNominaId);
				
				/*********************** insumos ***/
				dataDetProductos = null;
				dataDetProductos = businessDelegatorView.getDataDetProductosByPlanillaNomina(planillaNomina);

				txtNumTinas.setDisabled(false);
				txtAlmacenId_Almacen.setDisabled(false);
				txtCantidadAplicada.setDisabled(false);
				// txtCostoTotalInsumos.setDisabled(false);
				txtValorUnitInsumos.setDisabled(false);
				txtProductoId_Producto.setDisabled(false);
				txtUdadMedIdProducto.setDisabled(false);
				btnAgregar.setDisabled(false);

				txtNivel2IdProd.setDisabled(false);
				// txtNivel3IdProd.setDisabled(false);
				txtLaborId_LaborProd.setDisabled(false);
				// txtNivel4Id_Nivel4Prod.setDisabled(false);

				
				txtOrdenTrabajoProd.setDisabled(false);
		

				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	
	
	
	public String action_edit_mano_obra(ActionEvent evt) {
		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		try {
			Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
			Object[] condicion = { "planillaNominaId", true, planillaNominaId, "=" };
			List<DatPlanillaNomina> lista = (planillaNominaId != null)
					? businessDelegatorView.findByCriteriaInDatPlanillaNomina(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPlanillaNominaId.setValue(entity.getPlanillaNominaId());
				txtPlanillaNominaId.setDisabled(true);
				txtCantidadPago.setDisabled(false);
				txtValorUnitario.setDisabled(false);
				txtCantidadPago.setValue(0.0);
				txtValorUnitario.setValue(0.0);
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				txtTrabId_Trabajador.setDisabled(false);
				txtUdadMedPago.setDisabled(false);
				txtNivel2Id.setDisabled(false);

				txtLaborId_Labor.setDisabled(false);

				// txtNivel4Id_Nivel4.setDisabled(false);

				btnAgregarNomina.setDisabled(false);

				/******* sesion concerniente al detalle por trabajador ***/
				Long planillaNomina = FacesUtils.checkLong(txtPlanillaNominaId);
				dataPlanillaDet = null;
				dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNomina);

				
				txtOrdenTrabajo.setDisabled(false);
				
				btnSave.setDisabled(false);
				activeTapIndex = 0;

				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	

	public String action_edit_maquinaria(ActionEvent evt) {
		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		try {
			Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
			Object[] condicion = { "planillaNominaId", true, planillaNominaId, "=" };
			List<DatPlanillaNomina> lista = (planillaNominaId != null)
					? businessDelegatorView.findByCriteriaInDatPlanillaNomina(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPlanillaNominaId.setValue(entity.getPlanillaNominaId());
				txtPlanillaNominaId.setDisabled(true);
				txtCantidadPago.setDisabled(false);
				txtValorUnitario.setDisabled(false);
				txtCantidadPago.setValue(0.0);
				txtValorUnitario.setValue(0.0);
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				txtTrabId_Trabajador.setDisabled(false);
				txtUdadMedPago.setDisabled(false);
				txtNivel2Id.setDisabled(false);

				txtLaborId_Labor.setDisabled(false);

				// txtNivel4Id_Nivel4.setDisabled(false);

				btnAgregarNomina.setDisabled(false);

				/******* sesion concerniente al detalle por trabajador ***/
				Long planillaNomina = FacesUtils.checkLong(txtPlanillaNominaId);
				dataPlanillaDet = null;
				dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNomina);

				txtEquipoId_Equipo.setDisabled(false);
				//txtUdadMaquinaria.setDisabled(false);
			//	txtCostoTotalMaquinaria.setDisabled(false);
			//	txtHoraFinalMaquinaria.setDisabled(false);
			//	txtHoraInicialMaquinaria.setDisabled(false);
			//	txtTotalHorasMaquinaria.setDisabled(false);
				//txtValorUnitMaquinaria.setDisabled(false);
				txtImplemento.setDisabled(false);
				txtHorometroFinalMq.setDisabled(false);
				txtHorometroInicalMq.setDisabled(false);
				//btnAgregarMaquinaria.setDisabled(false);
				
			
				txtCantidadPago.setDisabled(false);
				

				//txtNivel2IdMaq.setDisabled(false);
				// txtNivel3IdMaq.setDisabled(false);
				//txtLaborId_LaborMaq.setDisabled(false);
				// txtNivel4Id_Nivel4Maq.setDisabled(false);

				
				txtOrdenTrabajo.setDisabled(false);
				

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
			if ((selectedDatPlanillaNomina == null) && (entity == null)
					|| ((selectedDatPlanillaNomina == null) && (entity.getPlanillaNominaId() == null))) {
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
			entity = new DatPlanillaNomina();

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setOrigenDatos("MAQUINARIA");
			GregorianCalendar calendario = new GregorianCalendar();

			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoDatPlanillaNomina(compania)));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			calendario.setTime(FacesUtils.checkDate(txtFechaRegistro));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnio(new Long(anioRegistro));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			
			/*if (dataPlanillaDet != null) {
				entity.setOrigenDatos("Manual");
			} else if (dataServicioDet != null) {
				entity.setOrigenDatos("Maquina");
			} else if (dataDetProductos != null) {
				entity.setOrigenDatos("Insumos");
			} else if (dataRiegos != null) {
				entity.setOrigenDatos("Riegos");
			}*/
			
			//entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			businessDelegatorView.saveDatPlanillaNomina(entity, dataPlanillaDet, dataServicioDet, dataDetProductos,
					dataRiegos, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoDatPlanillaNomina(compania) - 1));

			Long planillaNominaId = entity.getPlanillaNominaId();
			dataPlanillaDet = null;
			dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNominaId);

			dataServicioDet = null;
			dataServicioDet = businessDelegatorView.getDataDatServicioDetByPlanillaNomina(planillaNominaId);

			dataRiegos = null;
			dataRiegos = businessDelegatorView.getDataDatRiegoByPlanillaNomina(planillaNominaId);

			dataDetProductos = null;
			dataDetProductos = businessDelegatorView.getDataDetProductosByPlanillaNomina(planillaNominaId);

			// action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			Long planillaNominaId = null;
			if (entity == null) {
				planillaNominaId = new Long(selectedDatPlanillaNomina.getPlanillaNominaId());
				entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
			}
			planillaNominaId = entity.getPlanillaNominaId();
			Date date = new Date();
			GregorianCalendar calendario = new GregorianCalendar();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());

			entity.setNPases(1l);
			entity.setCantidadPago(FacesUtils.checkDouble(txtCantidadPago));
			// entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);			
			entity.setOrigenDatos("MAQUINARIA");
			
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			calendario.setTime(FacesUtils.checkDate(txtFechaRegistro));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnio((new Long(anioRegistro)));

			entity.setObservacion(FacesUtils.checkString(txtObservacion));
		//	entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));

			businessDelegatorView.updateDatPlanillaNomina(entity, dataPlanillaDet, dataServicioDet, dataDetProductos,
					dataRiegos, null);

			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			dataPlanillaDet = null;
			dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNominaId);

			dataServicioDet = null;
			dataServicioDet = businessDelegatorView.getDataDatServicioDetByPlanillaNomina(planillaNominaId);

			dataRiegos = null;
			dataRiegos = businessDelegatorView.getDataDatRiegoByPlanillaNomina(planillaNominaId);

			dataDetProductos = null;
			dataDetProductos = businessDelegatorView.getDataDetProductosByPlanillaNomina(planillaNominaId);

			// action_clear();

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatPlanillaNominaLista.getPlanillaNominaId());
				entity = businessDelegatorView.getDatPlanillaNomina(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			Long planillaNomina = FacesUtils.checkLong(txtPlanillaNominaId);
			dataPlanillaDet = null;
			dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNomina);
			dataServicioDet = null;
			dataServicioDet = businessDelegatorView.getDataDatServicioDetByPlanillaNomina(planillaNomina);
			dataRiegos = null;
			dataRiegos = businessDelegatorView.getDataDatRiegoByPlanillaNomina(planillaNomina);
			dataDetProductos = null;
			dataDetProductos = businessDelegatorView.getDataDetProductosByPlanillaNomina(planillaNomina);

			businessDelegatorView.updateDatPlanillaNomina(entity, dataPlanillaDet, dataServicioDet, dataDetProductos,
					dataRiegos, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));

		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanillaNominaLista"));

			Long planillaNominaId = new Long(selectedDatPlanillaNomina.getPlanillaNominaId());
			entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long planillaNominaId = FacesUtils.checkLong(txtPlanillaNominaId);
			entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatPlanillaNomina(entity);
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
			selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanillaNominaLista"));

			Long planillaNominaId = new Long(selectedDatPlanillaNomina.getPlanillaNominaId());
			entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
			businessDelegatorView.deleteDatPlanillaNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long NPases, Long anio, Double cantidadPago, Double cantidadProd,
			String cierreCostos, Long compania, Long consecutivo, Double costoTotal, String documetoErp,
			Double edadEjecucion, String estado, Long etapaId, Date fechaCreacion, Date fechaModificacion,
			Date fechaRegistro, String idMobile, String infoAdicional, String infoAdicional2, String latitud,
			String longitud, Long nivel1Id, Long nivel2Id, Long nivel3Id, String observacion,
			String observacionAnularReg, Long ordenTrabajo, Long planillaNominaId, String precision, Long udadMedPago,
			Long usuarioDigitacion, Double valorUnitario, Long variedId, Long ceptoNominaId_ConceptoNomina,
			Long contratistaId_Contratista, Long eqpTrabId_EquipoTrabajo, Long laborId_Labor, Long nivel4Id_Nivel4,
			Long trabId_Trabajador, Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setNPases(FacesUtils.checkLong(NPases));
			entity.setAnio(FacesUtils.checkLong(anio));
			entity.setCantidadPago(FacesUtils.checkDouble(cantidadPago));
			entity.setCantidadProd(FacesUtils.checkDouble(cantidadProd));
			entity.setCierreCostos(FacesUtils.checkString(cierreCostos));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setCostoTotal(FacesUtils.checkDouble(costoTotal));
			entity.setDocumetoErp(FacesUtils.checkString(documetoErp));
			entity.setEdadEjecucion(FacesUtils.checkDouble(edadEjecucion));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEtapaId(FacesUtils.checkLong(etapaId));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setIdMobile(FacesUtils.checkString(idMobile));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setNivel1Id(FacesUtils.checkLong(nivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(nivel3Id));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			entity.setVariedId(FacesUtils.checkLong(variedId));
			businessDelegatorView.updateDatPlanillaNomina(entity, dataPlanillaDet, dataServicioDet, dataDetProductos,
					dataRiegos, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	
	
	public InputText getTxtCantidadMaq() {
		return txtCantidadMaq;
	}

	public void setTxtCantidadMaq(InputText txtCantidadMaq) {
		this.txtCantidadMaq = txtCantidadMaq;
	}

	public BigDecimal getTarifaNoEncontrada() {
		return tarifaNoEncontrada;
	}

	public void setTarifaNoEncontrada(BigDecimal tarifaNoEncontrada) {
		this.tarifaNoEncontrada = tarifaNoEncontrada;
	}

	public Spinner getTxtNPases() {
		return txtNPases;
	}

	public void setTxtNPases(Spinner txtNPases) {
		this.txtNPases = txtNPases;
	}

	public InputText getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(InputText txtAnio) {
		this.txtAnio = txtAnio;
	}

	public InputText getTxtCantidadPago() {
		return txtCantidadPago;
	}

	public void setTxtCantidadPago(InputText txtCantidadPago) {
		this.txtCantidadPago = txtCantidadPago;
	}

	public InputText getTxtCantidadProd() {
		return txtCantidadProd;
	}

	public void setTxtCantidadProd(InputText txtCantidadProd) {
		this.txtCantidadProd = txtCantidadProd;
	}

	public InputText getTxtCierreCostos() {
		return txtCierreCostos;
	}

	public void setTxtCierreCostos(InputText txtCierreCostos) {
		this.txtCierreCostos = txtCierreCostos;
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

	public InputText getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputText txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public InputText getTxtDocumetoErp() {
		return txtDocumetoErp;
	}

	public void setTxtDocumetoErp(InputText txtDocumetoErp) {
		this.txtDocumetoErp = txtDocumetoErp;
	}

	public InputText getTxtEdadEjecucion() {
		return txtEdadEjecucion;
	}

	public void setTxtEdadEjecucion(InputText txtEdadEjecucion) {
		this.txtEdadEjecucion = txtEdadEjecucion;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEtapaId() {
		return txtEtapaId;
	}

	public void setTxtEtapaId(InputText txtEtapaId) {
		this.txtEtapaId = txtEtapaId;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public InputText getTxtIdMobile() {
		return txtIdMobile;
	}

	public void setTxtIdMobile(InputText txtIdMobile) {
		this.txtIdMobile = txtIdMobile;
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

	public InputText getTxtLatitud() {
		return txtLatitud;
	}

	public void setTxtLatitud(InputText txtLatitud) {
		this.txtLatitud = txtLatitud;
	}

	public InputText getTxtLongitud() {
		return txtLongitud;
	}

	public void setTxtLongitud(InputText txtLongitud) {
		this.txtLongitud = txtLongitud;
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

	public SelectOneMenu getTxtOrdenTrabajo() {
		return txtOrdenTrabajo;
	}

	public void setTxtOrdenTrabajo(SelectOneMenu txtOrdenTrabajo) {
		this.txtOrdenTrabajo = txtOrdenTrabajo;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public SelectOneMenu getTxtUdadMedPago() {
		return txtUdadMedPago;
	}

	public void setTxtUdadMedPago(SelectOneMenu txtUdadMedPago) {
		this.txtUdadMedPago = txtUdadMedPago;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputText getTxtVariedId() {
		return txtVariedId;
	}

	public void setTxtVariedId(InputText txtVariedId) {
		this.txtVariedId = txtVariedId;
	}

	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public SelectOneMenu getTxtContratistaId_Contratista() {
		return txtContratistaId_Contratista;
	}

	public void setTxtContratistaId_Contratista(SelectOneMenu txtContratistaId_Contratista) {
		this.txtContratistaId_Contratista = txtContratistaId_Contratista;
	}

	public SelectOneMenu getTxtEqpTrabId_EquipoTrabajo() {
		return txtEqpTrabId_EquipoTrabajo;
	}

	public void setTxtEqpTrabId_EquipoTrabajo(SelectOneMenu txtEqpTrabId_EquipoTrabajo) {
		this.txtEqpTrabId_EquipoTrabajo = txtEqpTrabId_EquipoTrabajo;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
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

	public InputText getTxtPlanillaNominaId() {
		return txtPlanillaNominaId;
	}

	public void setTxtPlanillaNominaId(InputText txtPlanillaNominaId) {
		this.txtPlanillaNominaId = txtPlanillaNominaId;
	}

	public LazyDataModel<DatPlanillaNominaDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatPlanillaNominaDTO> datPlanillaNominaDTO) {
		this.data = datPlanillaNominaDTO;
	}

	public DatPlanillaNominaDTO getSelectedDatPlanillaNomina() {
		return selectedDatPlanillaNomina;
	}

	public void setSelectedDatPlanillaNomina(DatPlanillaNominaDTO datPlanillaNomina) {
		this.selectedDatPlanillaNomina = datPlanillaNomina;
	}

	public BigDecimal getTarifaPago() {
		return tarifaPago;
	}

	public void setTarifaPago(BigDecimal tarifaPago) {
		this.tarifaPago = tarifaPago;
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

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public CommandButton getBtnAgregarMaquinaria() {
		return btnAgregarMaquinaria;
	}

	public void setBtnAgregarMaquinaria(CommandButton btnAgregarMaquinaria) {
		this.btnAgregarMaquinaria = btnAgregarMaquinaria;
	}

	public CommandButton getBtnAgregarNomina() {
		return btnAgregarNomina;
	}

	public void setBtnAgregarNomina(CommandButton btnAgregarNomina) {
		this.btnAgregarNomina = btnAgregarNomina;
	}

	public SelectItem[] getselectAlmacen() {

		if (almacen == null || almacen.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(), almacen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	public void setselectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public SelectItem[] getSelectProductoId() {
		if (productoId == null || productoId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				List<CatalogProductoDTO> listaProductos = businessDelegatorView
						.consultarCatalogoProductosAgricolas(idCompania);
				selectProductoId = new SelectItem[listaProductos.size()];
				int i = 0;
				for (CatalogProductoDTO listaDTO : listaProductos) {
					selectProductoId[i] = new SelectItem(listaDTO.getProductoId().longValue(), listaDTO.getNombre());
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

	public void tipoDistribucion() {
		if (txtTipoDistribucion.getValue() != null) {
			String tipoDistribucion = (String) txtTipoDistribucion.getValue();

			if (tipoDistribucion.equals("codigoErp")) {

				lotesManoObra = null;
				txtNivel4Erp.setDisabled(false);

			} else if (tipoDistribucion.equals("lote")) {

				// txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel4Erp.setDisabled(true);
			}
		} else {
			lotesManoObra = null;
			txtNivel4Erp.setValue(null);
		}

	}

	public void tipoDistribucionMaq() {
		if (txtTipoDistribucionMaq.getValue() != null) {
			String tipoDistribucion = (String) txtTipoDistribucionMaq.getValue();

			if (tipoDistribucion.equals("codigoErp")) {

				lotesMaq = null;
				txtNivel4ErpMaq.setDisabled(false);

			} else if (tipoDistribucion.equals("lote")) {

				// txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel4ErpMaq.setDisabled(true);
			}
		} else {
			lotesMaq = null;
			txtNivel4ErpMaq.setValue(null);
		}

	}

	public void tipoDistribucionProd() {
		if (txtTipoDistribucionProd.getValue() != null) {
			String tipoDistribucion = (String) txtTipoDistribucionProd.getValue();

			if (tipoDistribucion.equals("codigoErp")) {

				lotesProd = null;
				txtNivel4ErpProd.setDisabled(false);

			} else if (tipoDistribucion.equals("lote")) {

				// txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel4ErpProd.setDisabled(true);
			}
		} else {
			lotesProd = null;
			txtNivel4ErpProd.setValue(null);
		}

	}

	public void tipoDistribucionRiego() {
		if (txtTipoDistribucionRiego.getValue() != null) {
			String tipoDistribucion = (String) txtTipoDistribucionRiego.getValue();

			if (tipoDistribucion.equals("codigoErp")) {

				lotesRiego = null;
				txtNivel4ErpRiego.setDisabled(false);

			} else if (tipoDistribucion.equals("lote")) {

				// txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel4ErpRiego.setDisabled(true);
			}
		} else {
			lotesRiego = null;
			txtNivel4ErpRiego.setValue(null);
		}

	}

	public SelectItem[] getselectNivel2() {

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

	public void setselectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	@SuppressWarnings("unlikely-arg-type")
	public SelectItem[] getselectNivel4Erp() throws NumberFormatException, Exception {

		if (bloquesManoObra != null && !bloquesManoObra.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3ManoObra != null && selectedNivel3ManoObra.size() > 0) {
				bloquesSeleccionadas = selectedNivel3ManoObra.get(0);
				for (int i = 1; i < selectedNivel3ManoObra.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3ManoObra.get(i);
				}
			}
			try {

				nivel4Erp = businessDelegator2View.listaCodigosErp(bloquesSeleccionadas);
				selectNivel4Erp = new SelectItem[nivel4Erp.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : nivel4Erp) {
					selectNivel4Erp[i] = new SelectItem(nivel4.getCodigoErp(),
							nivel4.getCodigoErp() + " Área: " + nivel4.getArea_neta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4Erp;
	}

	public void setselectNivel4Erp(SelectItem[] selectNivel4Erp) {
		this.selectNivel4Erp = selectNivel4Erp;
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
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(),
							nivel4.getNombre() + '-' + "Área: " + nivel4.getAreaNeta().toString());
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

	public SelectItem[] getselectTrabajadorRiego() {

		if (trabajadorRiego == null || trabajadorRiego.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "="

				};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajadorRiego = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajadorRiego[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajadorRiego;
	}

	public void setselectTrabajadorRiego(SelectItem[] selectTrabajadorRiego) {
		this.selectTrabajadorRiego = selectTrabajadorRiego;
	}
	
	public void tipoPersonal() {
		
		String tipoPersonal = FacesUtils.checkString(txtTipoPersonal);
		
		if (tipoPersonal != null && !tipoPersonal.equals("")) {
			
			if (tipoPersonal.equals("Empleados")) {
				
				txtTrabId_Trabajador.setValue(null);
				txtTrabId_Trabajador.setDisabled(false);
				
				txtCeptoNominaId_ConceptoNomina.setValue(null);
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				
				txtPersEmpr.setValue(null);
				txtPersEmpr.setDisabled(true);
				
			} else if (tipoPersonal.equals("Contratistas")) {
				
				txtTrabId_Trabajador.setValue(null);
				txtTrabId_Trabajador.setDisabled(true);
				
				txtCeptoNominaId_ConceptoNomina.setValue(null);
				txtCeptoNominaId_ConceptoNomina.setDisabled(true);
				
				txtPersEmpr.setValue(null);
				txtPersEmpr.setDisabled(false);				
			}			
		}		
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {
			try {

				Object[] condicion = { "estado", true, "A", "="

				};
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

	public SelectItem[] getSelectPersEmpr() {

		if (selectPersEmpr == null || selectPersEmpr.length == 0) {
			
			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectPersEmpr = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectPersEmpr[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPersEmpr;
	}

	public void setSelectPersEmpr(SelectItem[] selectPersEmpr) {
		this.selectPersEmpr = selectPersEmpr;
	}

	public SelectItem[] getselectSupervisorInsumos() {

		if (supervisorInsumos == null || supervisorInsumos.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "="

				};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectSupervisorInsumos = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectSupervisorInsumos[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSupervisorInsumos;
	}

	public void setselectSupervisorInsumos(SelectItem[] selectSupervisorInsumos) {
		this.selectSupervisorInsumos = selectSupervisorInsumos;
	}

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" , "tipoLabor", true, "servicio_agricola", "="};
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

	public SelectItem[] getSelectEquipoTrabajo() {

		if (equipoTrabajo == null || equipoTrabajo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<EquipoTrabajo> lista = businessDelegatorView.findByCriteriaInEquipoTrabajo(condicion, null, null);
				selectEquipoTrabajo = new SelectItem[lista.size()];

				int i = 0;
				for (EquipoTrabajo equipoTrabajo : lista) {
					selectEquipoTrabajo[i] = new SelectItem(equipoTrabajo.getEqpTrabId(), equipoTrabajo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipoTrabajo;
	}

	public void setSelectEquipoTrabajo(SelectItem[] selectEquipoTrabajo) {

		this.selectEquipoTrabajo = selectEquipoTrabajo;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

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

	public SelectItem[] getselectUdadMedProducto() {

		if (udadMedProducto == null || udadMedProducto.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedProducto = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedProducto[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedProducto;
	}

	public void setselectUdadMedProducto(SelectItem[] selectUdadMedProducto) {
		this.selectUdadMedProducto = selectUdadMedProducto;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

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

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
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

	public SelectItem[] getselectEquipo() {

		if (equipo == null || equipo.size() == 0) {
			try {
		Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						
						"categoriaEquipo.funcion", true, "Implemento", "<>",
						"categoriaEquipo.funcion", true, "Remolques/Vagones", "<>",
						"categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"};
						
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(), equipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipo;
	}

	public void setselectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public SelectItem[] getselectUdadMaquinaria() {

		if (udadMaquinaria == null || udadMaquinaria.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMaquinaria = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMaquinaria[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMaquinaria;
	}

	public void setselectUdadMaquinaria(SelectItem[] selectUdadMaquinaria) {
		this.selectUdadMaquinaria = selectUdadMaquinaria;
	}

	private class LocalDataModelDTO extends LazyDataModel<DatPlanillaNominaDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatPlanillaNominaDTO> datPlanillaNominaDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatPlanillaNominaDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datPlanillaNominaDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberPlanillaNomina(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datPlanillaNominaDTO;

		}

		@Override
		public DatPlanillaNominaDTO getRowData(String rowKey) {
			for (DatPlanillaNominaDTO datPlanillaNominaDTOtmp : datPlanillaNominaDTO) {
				if (datPlanillaNominaDTOtmp.getPlanillaNominaId().toString().equals(rowKey))
					return datPlanillaNominaDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatPlanillaNominaDTO datPlanillaNominaDTOtmp) {
			return datPlanillaNominaDTOtmp.getPlanillaNominaId();
		}

	}

	private List<DatPlanillaNominaDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPagePlanillaNomina(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public BigDecimal getTarifaPagoT() {
		return tarifaPagoT;
	}

	public void setTarifaPagoT(BigDecimal tarifaPagoT) {
		this.tarifaPagoT = tarifaPagoT;
	}

	public BigDecimal getBonificacionT() {
		return bonificacionT;
	}

	public void setBonificacionT(BigDecimal bonificacionT) {
		this.bonificacionT = bonificacionT;
	}

	public BigDecimal getTarifaNoEncontradaT() {
		return tarifaNoEncontradaT;
	}

	public void setTarifaNoEncontradaT(BigDecimal tarifaNoEncontradaT) {
		this.tarifaNoEncontradaT = tarifaNoEncontradaT;
	}

	public BigDecimal getTarifaPagoP() {
		return tarifaPagoP;
	}

	public void setTarifaPagoP(BigDecimal tarifaPagoP) {
		this.tarifaPagoP = tarifaPagoP;
	}

	public InputText getTxtCostoTotalMaquinaria() {
		return txtCostoTotalMaquinaria;
	}

	public void setTxtCostoTotalMaquinaria(InputText txtCostoTotalMaquinaria) {
		this.txtCostoTotalMaquinaria = txtCostoTotalMaquinaria;
	}

	public Calendar getTxtHoraFinalMaquinaria() {
		return txtHoraFinalMaquinaria;
	}

	public void setTxtHoraFinalMaquinaria(Calendar txtHoraFinalMaquinaria) {
		this.txtHoraFinalMaquinaria = txtHoraFinalMaquinaria;
	}

	public Calendar getTxtHoraInicialMaquinaria() {
		return txtHoraInicialMaquinaria;
	}

	public void setTxtHoraInicialMaquinaria(Calendar txtHoraInicialMaquinaria) {
		this.txtHoraInicialMaquinaria = txtHoraInicialMaquinaria;
	}

	public InputText getTxtTotalHorasMaquinaria() {
		return txtTotalHorasMaquinaria;
	}

	public void setTxtTotalHorasMaquinaria(InputText txtTotalHorasMaquinaria) {
		this.txtTotalHorasMaquinaria = txtTotalHorasMaquinaria;
	}

	public InputText getTxtValorUnitMaquinaria() {
		return txtValorUnitMaquinaria;
	}

	public void setTxtValorUnitMaquinaria(InputText txtValorUnitMaquinaria) {
		this.txtValorUnitMaquinaria = txtValorUnitMaquinaria;
	}

	public InputText getTxtAreaAplicada() {
		return txtAreaAplicada;
	}

	public void setTxtAreaAplicada(InputText txtAreaAplicada) {
		this.txtAreaAplicada = txtAreaAplicada;
	}

	public InputText getTxtCantidadAplicada() {
		return txtCantidadAplicada;
	}

	public void setTxtCantidadAplicada(InputText txtCantidadAplicada) {
		this.txtCantidadAplicada = txtCantidadAplicada;
	}

	public InputText getTxtCostoTotalInsumos() {
		return txtCostoTotalInsumos;
	}

	public void setTxtCostoTotalInsumos(InputText txtCostoTotalInsumos) {
		this.txtCostoTotalInsumos = txtCostoTotalInsumos;
	}

	public InputText getTxtDosis() {
		return txtDosis;
	}

	public void setTxtDosis(InputText txtDosis) {
		this.txtDosis = txtDosis;
	}

	public InputText getTxtValorUnitInsumos() {
		return txtValorUnitInsumos;
	}

	public void setTxtValorUnitInsumos(InputText txtValorUnitInsumos) {
		this.txtValorUnitInsumos = txtValorUnitInsumos;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public SelectOneMenu getTxtUdadMedIdProducto() {
		return txtUdadMedIdProducto;
	}

	public void setTxtUdadMedIdProducto(SelectOneMenu txtUdadMedIdProducto) {
		this.txtUdadMedIdProducto = txtUdadMedIdProducto;
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

	public SelectOneMenu getTxtSistemaRiegoId_SistemaRiego() {
		return txtSistemaRiegoId_SistemaRiego;
	}

	public void setTxtSistemaRiegoId_SistemaRiego(SelectOneMenu txtSistemaRiegoId_SistemaRiego) {
		this.txtSistemaRiegoId_SistemaRiego = txtSistemaRiegoId_SistemaRiego;
	}

	public SelectOneMenu getTxtInfraId_Infraestructura() {
		return txtInfraId_Infraestructura;
	}

	public void setTxtInfraId_Infraestructura(SelectOneMenu txtInfraId_Infraestructura) {
		this.txtInfraId_Infraestructura = txtInfraId_Infraestructura;
	}

	public SelectOneMenu getTxtTrabIdSupervisorRiego() {
		return txtTrabIdSupervisorRiego;
	}

	public void setTxtTrabIdSupervisorRiego(SelectOneMenu txtTrabIdSupervisorRiego) {
		this.txtTrabIdSupervisorRiego = txtTrabIdSupervisorRiego;
	}

	public InputText getTxtAreaRegada() {
		return txtAreaRegada;
	}

	public void setTxtAreaRegada(InputText txtAreaRegada) {
		this.txtAreaRegada = txtAreaRegada;
	}

	public InputText getTxtCaudalNivel4() {
		return txtCaudalNivel4;
	}

	public void setTxtCaudalNivel4(InputText txtCaudalNivel4) {
		this.txtCaudalNivel4 = txtCaudalNivel4;
	}

	public Calendar getTxtHoraFinNivel4() {
		return txtHoraFinNivel4;
	}

	public void setTxtHoraFinNivel4(Calendar txtHoraFinNivel4) {
		this.txtHoraFinNivel4 = txtHoraFinNivel4;
	}

	public Calendar getTxtHoraIniNivel4() {
		return txtHoraIniNivel4;
	}

	public void setTxtHoraIniNivel4(Calendar txtHoraIniNivel4) {
		this.txtHoraIniNivel4 = txtHoraIniNivel4;
	}

	public InputText getTxtHoraTotalNivel4() {
		return txtHoraTotalNivel4;
	}

	public void setTxtHoraTotalNivel4(InputText txtHoraTotalNivel4) {
		this.txtHoraTotalNivel4 = txtHoraTotalNivel4;
	}

	public InputText getTxtVolTotalNivel4() {
		return txtVolTotalNivel4;
	}

	public void setTxtVolTotalNivel4(InputText txtVolTotalNivel4) {
		this.txtVolTotalNivel4 = txtVolTotalNivel4;
	}

	public DatServicioDTO getSelectedDatServicio() {
		return selectedDatServicio;
	}

	public void setSelectedDatServicio(DatServicioDTO selectedDatServicio) {
		this.selectedDatServicio = selectedDatServicio;
	}

	public BigDecimal getTarifaPagoMaquina() {
		return tarifaPagoMaquina;
	}

	public void setTarifaPagoMaquina(BigDecimal tarifaPagoMaquina) {
		this.tarifaPagoMaquina = tarifaPagoMaquina;
	}

	public BigDecimal getTarifaMaquinariaNoEncontrada() {
		return tarifaMaquinariaNoEncontrada;
	}

	public void setTarifaMaquinariaNoEncontrada(BigDecimal tarifaMaquinariaNoEncontrada) {
		this.tarifaMaquinariaNoEncontrada = tarifaMaquinariaNoEncontrada;
	}

	public DatAplicProductoDTO getSelectedDatAplicProducto() {
		return selectedDatAplicProducto;
	}

	public void setSelectedDatAplicProducto(DatAplicProductoDTO selectedDatAplicProducto) {
		this.selectedDatAplicProducto = selectedDatAplicProducto;
	}

	public BigDecimal getTarifaPagoInsumos() {
		return tarifaPagoInsumos;
	}

	public void setTarifaPagoInsumos(BigDecimal tarifaPagoInsumos) {
		this.tarifaPagoInsumos = tarifaPagoInsumos;
	}

	public BigDecimal getTarifaInsumosNoEncontrada() {
		return tarifaInsumosNoEncontrada;
	}

	public void setTarifaInsumosNoEncontrada(BigDecimal tarifaInsumosNoEncontrada) {
		this.tarifaInsumosNoEncontrada = tarifaInsumosNoEncontrada;
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

	public DatRiegoDTO getSelectedDatRiego() {
		return selectedDatRiego;
	}

	public void setSelectedDatRiego(DatRiegoDTO selectedDatRiego) {
		this.selectedDatRiego = selectedDatRiego;
	}

	public InputText getTxtNroPlantas() {
		return txtNroPlantas;
	}

	public void setTxtNroPlantas(InputText txtNroPlantas) {
		this.txtNroPlantas = txtNroPlantas;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public InputText getTxtDatAplicProdId() {
		return txtDatAplicProdId;
	}

	public void setTxtDatAplicProdId(InputText txtDatAplicProdId) {
		this.txtDatAplicProdId = txtDatAplicProdId;
	}

	public InputText getTxtDatRiegoId() {
		return txtDatRiegoId;
	}

	public void setTxtDatRiegoId(InputText txtDatRiegoId) {
		this.txtDatRiegoId = txtDatRiegoId;
	}

	public SelectOneMenu getTxtSupervisorInsumos() {
		return txtSupervisorInsumos;
	}

	public void setTxtSupervisorInsumos(SelectOneMenu txtSupervisorInsumos) {
		this.txtSupervisorInsumos = txtSupervisorInsumos;
	}

	public InputText getTxtDatServicioId() {
		return txtDatServicioId;
	}

	public void setTxtDatServicioId(InputText txtDatServicioId) {
		this.txtDatServicioId = txtDatServicioId;
	}

	public SelectOneMenu getTxtUdadMaquinaria() {
		return txtUdadMaquinaria;
	}

	public void setTxtUdadMaquinaria(SelectOneMenu txtUdadMaquinaria) {
		this.txtUdadMaquinaria = txtUdadMaquinaria;
	}

	public List<DatPlanillaNominaDetDTO> getDataPlanillaDet() {
		return dataPlanillaDet;
	}

	public void setDataPlanillaDet(List<DatPlanillaNominaDetDTO> dataPlanillaDet) {
		this.dataPlanillaDet = dataPlanillaDet;
	}

	public SelectOneRadio getTxtRequiereMaquinaria() {
		return txtRequiereMaquinaria;
	}

	public void setTxtRequiereMaquinaria(SelectOneRadio txtRequiereMaquinaria) {
		this.txtRequiereMaquinaria = txtRequiereMaquinaria;
	}

	public List<DatServicioDetDTO> getDataServicioDet() {
		return dataServicioDet;
	}

	public void setDataServicioDet(List<DatServicioDetDTO> dataServicioDet) {
		this.dataServicioDet = dataServicioDet;
	}

	public InputText getTxtNumTinas() {
		return txtNumTinas;
	}

	public void setTxtNumTinas(InputText txtNumTinas) {
		this.txtNumTinas = txtNumTinas;
	}

	public void setDataDetProductos(List<DatAplicProdDetDTO> dataDetProductos) {
		this.dataDetProductos = dataDetProductos;
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

	public InputText getTxtCodUmPagoMaquinaria() {
		return txtCodUmPagoMaquinaria;
	}

	public void setTxtCodUmPagoMaquinaria(InputText txtCodUmPagoMaquinaria) {
		this.txtCodUmPagoMaquinaria = txtCodUmPagoMaquinaria;
	}

	public InputText getTxtCodEquipo() {
		return txtCodEquipo;
	}

	public void setTxtCodEquipo(InputText txtCodEquipo) {
		this.txtCodEquipo = txtCodEquipo;
	}

	public SelectItem[] getSelectInfraestructura() {

		if (infratestructura == null || infratestructura.size() == 0) {

			try {
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Infraestructura> lista = businessDelegatorView.findByCriteriaInInfraestructura(condicion, null,
						null);
				selectInfraestructura = new SelectItem[lista.size()];

				int i = 0;
				for (Infraestructura infratestructura : lista) {
					selectInfraestructura[i] = new SelectItem(infratestructura.getInfraId(),
							infratestructura.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectInfraestructura;
	}

	public void setSelectInfraestructura(SelectItem[] selectInfraestructura) {
		this.selectInfraestructura = selectInfraestructura;
	}

	public SelectItem[] getSelectSistemaRiego() {

		if (sistemaRiego == null || sistemaRiego.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemaRiego> lista = businessDelegatorView.findByCriteriaInSistemaRiego(condicion, null, null);
				selectSistemaRiego = new SelectItem[lista.size()];

				int i = 0;
				for (SistemaRiego sistemaRiego : lista) {
					selectSistemaRiego[i] = new SelectItem(sistemaRiego.getSistemaRiegoId(), sistemaRiego.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSistemaRiego;
	}

	public void setSelectSistemaRiego(SelectItem[] selectSistemaRiego) {
		this.selectSistemaRiego = selectSistemaRiego;
	}

	/**************** MAQUINARIA ************************/

	public List<DatPlanillaNominaDetDTO> getDataPlanillaNominaDet1() {

		if (dataPlanillaDet == null || dataPlanillaDet.size() == 0) {
			return null;
		} else {
			return dataPlanillaDet;
		}

	}

	public void action_agregarPlanilla() throws Exception {

		Double cantidadPagoVal = 0.0;
		Double valorUnitVal = 0.0;

		cantidadPagoVal = FacesUtils.checkDouble(txtCantidadPago);
		valorUnitVal = FacesUtils.checkDouble(txtValorUnitario);

		if (txtUdadMedPago.getValue() != null && txtTipoPersonal!=null 
				&& txtCantidadPago.getValue() != null && txtLaborId_Labor.getValue() != null 
				&& txtNivel2Id.getValue() != null && txtTipoDistribucion.getValue() != null 
				&& cantidadPagoVal != null && cantidadPagoVal > 0
				&& valorUnitVal != null && valorUnitVal > 0) {

			String tipoDistribucion = (String) txtTipoDistribucion.getValue();

			int i = 0;

			if (tipoDistribucion.equals("codigoErp")
					&& txtNivel4Erp.getValue() != null & selectedNivel3ManoObra.size() == 1) {

				Long nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				String nivel3Id = selectedNivel3ManoObra.get(0);
				String codigo = txtNivel4Erp.getValue().toString();
				Object[] variables = { "codigoAlternativo", true, codigo, "=", "nivel3", true, nivel3Id, "=" };
				List<Nivel4> nivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);

				Long ordenTrabajoId = null;
				DatPlanLaborDet ot = null;
				if (txtOrdenTrabajo.getValue() != null) {
					ordenTrabajoId = Long.parseLong(txtOrdenTrabajo.getValue().toString());
					ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
				}

				Long etapaId = null;
				Long variedId = null;
				String nombreNivel4 = null;
				Double edad = 0.0;

				Double areaNetaTotal = 0.0;

				int n = 0;
				for (n = 0; n < nivel4.size();) {
					Double s = (nivel4.get(n).getAreaNeta());
					areaNetaTotal += s;
					n++;
				}
				
				String tipoPersona = FacesUtils.checkString(txtTipoPersonal);

				Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
				Labor labor = businessDelegatorView.getLabor(laborId);
				
				Long idContratista = null;
				Trabajador trabajador = null;
				String codTrabajador = null;
				
				PersEmpr contratista = null;
				String nombreContratista =null; 
				
				Long trabajadorId = FacesUtils.checkLong(txtTrabId_Trabajador);
				if (trabajadorId != null) {
					trabajador = businessDelegatorView.getTrabajador(trabajadorId);
					idContratista = trabajador.getContratista().getPersEmprId();
					codTrabajador = trabajador.getNombre();
					
					contratista = businessDelegatorView.getPersEmpr(idContratista);
					
					 nombreContratista =  contratista.getNombre();
				}else{
					idContratista = FacesUtils.checkLong(txtPersEmpr);
					contratista = businessDelegatorView.getPersEmpr(idContratista);
					 nombreContratista =  contratista.getNombre();
					}
				Long udadMedId_UdadMed = Long.parseLong(txtUdadMedPago.getValue().toString());
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

				Long conceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
				ConceptoNomina conceptoNomina = null;
				String codConceptoNomina = null;
				
				if (conceptoNominaId != null) {
					conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);
					codConceptoNomina = conceptoNomina.getNombre();
				}				
				
				String codUdadMedNomina = udadMed.getCodigo();

				String nombreLabor = labor.getNombre();
				String nombreNivel2 = nivel2.getNombre();

				Double cantidadPago = 0.0;
				Double valorUnit = 0.0;
				Double costoTotal = 0.0;
				Date data = new Date();
				Double horasTrabajadas = FacesUtils.checkDouble(txtHorasTrabajadas);

				if (dataPlanillaDet == null) {
					dataPlanillaDet = new ArrayList<DatPlanillaNominaDetDTO>();
				}

				for (i = 0; i < nivel4.size();) {

					if (nivel4.get(i).getEtapa() != null) {
						etapaId = nivel4.get(i).getEtapa().getEtapaId();
					}

					if (nivel4.get(i).getVariedad() != null) {
						variedId = nivel4.get(i).getVariedad();
					}

					nombreNivel4 = nivel4.get(i).getNombre();
					edad = (businessDelegatorView.calcularEdadLote(data, nivel4.get(i).getNivel4Id()));

					Double cantidadPago1 = FacesUtils.checkDouble(txtCantidadPago);
					Double valorUnit1 = FacesUtils.checkDouble(txtValorUnitario);

					cantidadPago = ((cantidadPago1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					cantidadPago = (double) Math.round((cantidadPago) * 10) / 10;

					valorUnit = valorUnit1;

					costoTotal = (cantidadPago * valorUnit);
					costoTotal = (double) Math.round((costoTotal) * 10) / 10;

					DatPlanillaNominaDetDTO datPlanillaNominaDetDTO2 = new DatPlanillaNominaDetDTO();
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(trabajador);
					datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(conceptoNomina);
					datPlanillaNominaDetDTO2.setUdadMedIdPago(udadMed);
					datPlanillaNominaDetDTO2.setCantidadPago(cantidadPago);
					datPlanillaNominaDetDTO2.setCodTrabajador(codTrabajador);
					datPlanillaNominaDetDTO2.setCodConceptoNomina(codConceptoNomina);
					datPlanillaNominaDetDTO2.setCodUmPago(codUdadMedNomina);
					datPlanillaNominaDetDTO2.setCostoTotal(costoTotal);
					datPlanillaNominaDetDTO2.setValorUnitario(valorUnit);
					datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(contratista);
					datPlanillaNominaDetDTO2.setNombrePersEmpr(nombreContratista);
					datPlanillaNominaDetDTO2.setNivel2Id(nivel2);
					datPlanillaNominaDetDTO2.setNivel4(nivel4.get(i));
					datPlanillaNominaDetDTO2.setLaborId(labor);
					datPlanillaNominaDetDTO2.setNombreNivel2(nombreNivel2);
					datPlanillaNominaDetDTO2.setNombreNivel4(nombreNivel4);
					datPlanillaNominaDetDTO2.setNombreLabor(nombreLabor);
					datPlanillaNominaDetDTO2.setOrdenTrabajo(ot);
					datPlanillaNominaDetDTO2.setEtapaId(etapaId);
					datPlanillaNominaDetDTO2.setVariedId(variedId);
					datPlanillaNominaDetDTO2.setEdad(edad);
					datPlanillaNominaDetDTO2.setHorasTrabajadas(horasTrabajadas);
					datPlanillaNominaDetDTO2.setTipoPersona(tipoPersona);

					dataPlanillaDet.add(datPlanillaNominaDetDTO2);

					i++;

				}
				nombreContratista=null;
				contratista=null;
				edad = null;
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
				nivel2Id = null;
				nombreLabor = null;
				nombreNivel2 = null;
				nombreNivel4 = null;
				ordenTrabajoId = null;
				ot = null;
				horasTrabajadas = null;

			} else if (tipoDistribucion.equals("lote")) {

				String lotesCheck = "";
				Double areaNetaAcumulada = 0.0;
				Double area_neta = 0.0;
				if (selectedNivel4ManoObra != null && selectedNivel4ManoObra.size() > 0) {
					// lotesCheck = selectedNivel4ManoObra.get(0);
					for (int a = 0; a < selectedNivel4ManoObra.size(); a++) {
						lotesCheck = selectedNivel4ManoObra.get(a);
						Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 entidad = listaNivel4.get(0);
						area_neta += entidad.getAreaNeta();

					}
					areaNetaAcumulada += area_neta;
				}

				String lotesSeleccionadas = "";
				if (selectedNivel4ManoObra != null && selectedNivel4ManoObra.size() > 0) {
					// lotesSeleccionadas = selectedNivel4ManoObra.get(0);
					// flagLote = 0L;
					for (int j = 0; j < selectedNivel4ManoObra.size(); j++) {
						lotesSeleccionadas = selectedNivel4ManoObra.get(j);
						Long ordenTrabajoId = null;
						DatPlanLaborDet ot = null;
						if (txtOrdenTrabajo.getValue() != null) {
							ordenTrabajoId = Long.parseLong(txtOrdenTrabajo.getValue().toString());
							ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
						}

						Long nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
						Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

						Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 nivel4 = listaNivel4.get(0);

						Long etapaId = null;
						Long variedId = null;

						if (nivel4.getEtapa() != null) {
							etapaId = nivel4.getEtapa().getEtapaId();
						}

						if (nivel4.getVariedad() != null) {
							variedId = nivel4.getVariedad();
						}
						
						String tipoPersona = FacesUtils.checkString(txtTipoPersonal);

						Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
						Labor labor = businessDelegatorView.getLabor(laborId);						

						Long idContratista = null;
						Trabajador trabajador = null;
						String codTrabajador = null;
						
						PersEmpr contratista = null;
						String nombreContratista =null; 
						
						Long trabajadorId = FacesUtils.checkLong(txtTrabId_Trabajador);
						if (trabajadorId != null) {
							trabajador = businessDelegatorView.getTrabajador(trabajadorId);
							idContratista = trabajador.getContratista().getPersEmprId();
							codTrabajador = trabajador.getNombre();
							
							contratista = businessDelegatorView.getPersEmpr(idContratista);
							
							 nombreContratista =  contratista.getNombre();
						}else{
							idContratista = FacesUtils.checkLong(txtPersEmpr);
							contratista = businessDelegatorView.getPersEmpr(idContratista);
							 nombreContratista =  contratista.getNombre();
							}
						

						Long udadMedId_UdadMed = Long.parseLong(txtUdadMedPago.getValue().toString());
						UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

						Long conceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
						ConceptoNomina conceptoNomina = null;
						String codConceptoNomina = null;
						
						if (conceptoNominaId != null) {
							conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);
							codConceptoNomina = conceptoNomina.getNombre();
						}
						
						String codUdadMedNomina = udadMed.getCodigo();

						String nombreLabor = labor.getNombre();
						String nombreNivel2 = nivel2.getNombre();
						String nombreNivel4 = nivel4.getNombre();

						Double cantidadPago = FacesUtils.checkDouble(txtCantidadPago);
						Double cantidadFinal = (cantidadPago * nivel4.getAreaNeta()) / areaNetaAcumulada;
						cantidadFinal = (double) Math.round((cantidadFinal) * 10) / 10;

						Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
						Double costoTotal = (double) Math.round((cantidadFinal * valorUnit) * 10) / 10;

						Double horasTrabajadas = 0.0;

						if (dataPlanillaDet == null) {
							dataPlanillaDet = new ArrayList<DatPlanillaNominaDetDTO>();
						}

						DatPlanillaNominaDetDTO datPlanillaNominaDetDTO2 = new DatPlanillaNominaDetDTO();
						datPlanillaNominaDetDTO2.setTrabId_Trabajador(trabajador);
						datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(conceptoNomina);
						datPlanillaNominaDetDTO2.setUdadMedIdPago(udadMed);
						datPlanillaNominaDetDTO2.setCantidadPago(cantidadFinal);
						datPlanillaNominaDetDTO2.setCodTrabajador(codTrabajador);
						datPlanillaNominaDetDTO2.setCodConceptoNomina(codConceptoNomina);
						datPlanillaNominaDetDTO2.setCodUmPago(codUdadMedNomina);
						datPlanillaNominaDetDTO2.setCostoTotal(costoTotal);
						datPlanillaNominaDetDTO2.setValorUnitario(valorUnit);
						datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(contratista);
						datPlanillaNominaDetDTO2.setNombrePersEmpr(nombreContratista);
						datPlanillaNominaDetDTO2.setNivel2Id(nivel2);
						datPlanillaNominaDetDTO2.setNivel4(nivel4);
						datPlanillaNominaDetDTO2.setLaborId(labor);
						datPlanillaNominaDetDTO2.setNombreNivel2(nombreNivel2);
						datPlanillaNominaDetDTO2.setNombreNivel4(nombreNivel4);
						datPlanillaNominaDetDTO2.setNombreLabor(nombreLabor);
						datPlanillaNominaDetDTO2.setOrdenTrabajo(ot);
						datPlanillaNominaDetDTO2.setEtapaId(etapaId);
						datPlanillaNominaDetDTO2.setVariedId(variedId);
						datPlanillaNominaDetDTO2.setHorasTrabajadas(horasTrabajadas);
						datPlanillaNominaDetDTO2.setTipoPersona(tipoPersona);

						dataPlanillaDet.add(datPlanillaNominaDetDTO2);
						nombreContratista=null;
						contratista=null;
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
						nivel2Id = null;
						nombreLabor = null;
						nombreNivel2 = null;
						ordenTrabajoId = null;
						ot = null;
						horasTrabajadas = null;

					}
				}
			}

			limpiar_pantalla();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos Orden de trabajo,  trabajador, unidad de medida, concepto, cantidad, tarifa tengan valores. "));
		}
	}

	public void limpiar_pantalla() {
		txtOrdenTrabajo.setValue(null);
		txtValorUnitario.setValue(null);
		txtCantidadPago.setValue(null);
		txtUdadMedPago.setValue(null);
		txtCeptoNominaId_ConceptoNomina.setValue(null);
		txtTipoDistribucion.setValue(null);
		txtTipoDistribucion.setDisabled(false);
		
	//	txtTipoPersonal.setValue(null);
		txtTipoPersonal.setDisabled(false);
		
		txtTrabId_Trabajador.setValue(null);
		txtLaborId_Labor.setValue(null);
		// txtNivel3Id.setValue(null);
		// txtNivel4Id_Nivel4.setValue(null);
		lotesManoObra = null;
		bloquesManoObra = null;
		selectedNivel3ManoObra = null;
		selectedNivel4ManoObra = null;
		txtNivel4Erp.setValue(null);
		txtNivel4Erp.setDisabled(false);
	}

	
	public void limpiar_pantallaMoMaquinaria() {
		txtOrdenTrabajo.setValue(null);
		txtValorUnitario.setValue(null);
		txtCantidadPago.setValue(null);
		txtUdadMedPago.setValue(null);
		txtCeptoNominaId_ConceptoNomina.setValue(null);
		txtTipoDistribucion.setValue(null);
		txtTipoDistribucion.setDisabled(false);
		
	//	txtTipoPersonal.setValue(null);
	//	txtTipoPersonal.setDisabled(false);
		
		txtTrabId_Trabajador.setValue(null);
		txtLaborId_Labor.setValue(null);
		// txtNivel3Id.setValue(null);
		// txtNivel4Id_Nivel4.setValue(null);
		lotesManoObra = null;
		bloquesManoObra = null;
		selectedNivel3ManoObra = null;
		selectedNivel4ManoObra = null;
		txtNivel4Erp.setValue(null);
		txtNivel4Erp.setDisabled(false);
		
		txtEquipoId_Equipo.setValue(null); 
		txtHorometroInicalMq.setValue(null); txtHorometroFinalMq.setValue(null);
		txtNivel2Id.setValue(null);  
	}
	
	public void limpiarConceptoNomina() {
		txtCeptoNominaId_ConceptoNomina.setValue(null);
	}

	public String actionDeleteDatPlanillaNominaDet(ActionEvent evt) {
		try {

			selectedDatPlanillaDet = (DatPlanillaNominaDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanillaDet"));

			if (selectedDatPlanillaDet.getDetPlanillaNominaId() == null) {
				dataPlanillaDet.remove(selectedDatPlanillaDet);
			} else {
				Long detPlanillaNominaDetId = new Long(selectedDatPlanillaDet.getDetPlanillaNominaId());
				DatPlanillaNominaDet entity = businessDelegatorView.getDatPlanillaNominaDet(detPlanillaNominaDetId);
				businessDelegatorView.deleteDatPlanillaNominaDet(entity);
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
		if (!txtNivel4Id_Nivel4.getValue().equals("") && !txtNivel2Id.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel4.setValue(nivel4.getNombre());
				txtNombreNivel2.setValue(nivel2.getNombre());
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
				if (labor.getUdadMedByUdadMedPago().getUdadMedId() != null) {
					txtUdadMedPago.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
				}
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

	/***************** insumos ******/

	@Autowired
	public void listener_calcularCantidadAplicada() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double dosis = FacesUtils.checkDouble(txtDosis);
		Double numTinas = FacesUtils.checkDouble(txtNumTinas);

		if (dosis != null && numTinas != null) {
			result = (numTinas * dosis);
			String format = decimalFormat.format(result);
			txtCantidadAplicada.setValue(format);
		} else {
			result = 0;
			txtCantidadAplicada.setValue(result);
		}

	}

	public void ConsultarPrecioPromProductoDet() throws Exception {

		Long idCompania = new Long(getCompaniaIdSession());
		Long idProducto = FacesUtils.checkLong(txtProductoId_Producto);
		Long idAlmacen = FacesUtils.checkLong(txtAlmacenId_Almacen);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedIdProducto);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		if (idUdadMed != null) {
			try {

				Double tarifaPagox = businessDelegatorView.consultarPrecioPromProducto(idProducto, idAlmacen, idCompania,
						idFecha);
				String format = decimalFormat.format(tarifaPagox);
				txtValorUnitInsumos.setValue(format);
				if (tarifaPagoInsumos == null) {
					tarifaInsumosNoEncontrada = new BigDecimal("0");
					txtValorUnitInsumos.setValue(tarifaNoEncontrada);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	public void listener_calcularCostoTotalInsumos() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnit = FacesUtils.checkDouble(txtValorUnitInsumos);
		Double cantidadAplicada = FacesUtils.checkDouble(getTxtCantidadAplicada());

		if (valorUnit != null && cantidadAplicada != null) {
			result = (valorUnit * cantidadAplicada);
			String format = decimalFormat.format(result);
			txtCostoTotalInsumos.setValue(format);
		} else {
			result = 0;
			txtCostoTotalInsumos.setValue(result);
		}

	}

	public List<DatAplicProdDetDTO> getDataDetProductos() {

		if (dataDetProductos == null || dataDetProductos.size() == 0) {
			return null;
		} else {
			return dataDetProductos;
		}

	}

	public void action_agregarProductos() throws Exception {
		if (txtProductoId_Producto.getValue() != null && txtUdadMedIdProducto.getValue() != null
				&& txtCantidadAplicada.getValue() != null && txtLaborId_LaborProd.getValue() != null
				&& txtNivel2IdProd.getValue() != null && txtTipoDistribucionProd.getValue() != null
				&& txtAlmacenId_Almacen.getValue() != null) {

			String tipoDistribucion = (String) txtTipoDistribucionProd.getValue();
			int i = 0;

			if (tipoDistribucion.equals("codigoErp")) {

				Long ordenTrabajoId = null;
				DatPlanLaborDet ot = null;
				if (txtOrdenTrabajoProd.getValue() != null) {
					ordenTrabajoId = Long.parseLong(txtOrdenTrabajoProd.getValue().toString());
					ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
				}

				Long nivel2Id = Long.parseLong(txtNivel2IdProd.getValue().toString());
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				String nivel3Id = selectedNivel3Prod.get(0);
				String codigo = txtNivel4ErpProd.getValue().toString();
				Object[] variables = { "codigoAlternativo", true, codigo, "=", "nivel3", true, nivel3Id, "=" }; 
				List<Nivel4> nivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);

				Long etapaId = null;
				Long variedId = null;
				String nombreNivel4 = null;
				Double edad = 0.0;

				Double areaNetaTotal = 0.0;

				int n = 0;
				for (n = 0; n < nivel4.size();) {

					Double s = (nivel4.get(n).getAreaNeta());
					areaNetaTotal += s;

					n++;
				}

				Long laborId = Long.parseLong(txtLaborId_LaborProd.getValue().toString());
				Labor labor = businessDelegatorView.getLabor(laborId);
				Long almacenId = Long.parseLong(txtAlmacenId_Almacen.getValue().toString());
				Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
				Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
				Producto producto = businessDelegatorView.getProducto(productoId);
				Long udadMedId_UdadMed = Long.parseLong(txtUdadMedIdProducto.getValue().toString());
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
				String nombreProducto = producto.getNombre(); // FacesUtils.checkString(txtNombreProducto);
				String nombreUdadMed = udadMed.getNombre(); // FacesUtils.checkString(txtNombreUdadMed);

				Double cantidadAplicada = 0.0;
				Double costoTotal = 0.0;
				Double dosis = 0.0;
				Double numTinas = 0.0;

				String nombreLabor = labor.getNombre(); // FacesUtils.checkString(txtNombreLaborProd);
				String nombreNivel2 = nivel2.getNombre();// FacesUtils.checkString(txtNombreNivel2Prod);
				String nombreAlmacen = almacen.getNombre();// FacesUtils.checkString(txtNombreAlmacenProd);

				/*
				 * if (txtNumTinas.getValue() != null && txtCantidadAplicada.getValue() != null)
				 * { if (FacesUtils.checkDouble(txtNumTinas) > 0) { dosis = cantidadAplicada /
				 * FacesUtils.checkDouble(txtNumTinas); dosis = Math.rint(dosis * 1000) / 1000;
				 * } }
				 */

				Double valorUnit = FacesUtils.checkDouble(txtValorUnitInsumos);
				Date data = new Date();

				boolean existeProducto = false;

				if (dataDetProductos == null) {
					dataDetProductos = new ArrayList<DatAplicProdDetDTO>();

				}

				for (i = 0; i < nivel4.size();) {

					if (nivel4.get(i).getEtapa() != null) {
						etapaId = nivel4.get(i).getEtapa().getEtapaId();
					}

					if (nivel4.get(i).getVariedad() != null) {
						variedId = nivel4.get(i).getVariedad();
					}

					nombreNivel4 = nivel4.get(i).getCodigo();
					edad = (businessDelegatorView.calcularEdadLote(data, nivel4.get(i).getNivel4Id()));

					Double cantidadAplicada1 = FacesUtils.checkDouble(txtCantidadAplicada);

					cantidadAplicada = ((cantidadAplicada1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					cantidadAplicada = (double) Math.round((cantidadAplicada) * 1000) / 1000;

					costoTotal = (cantidadAplicada * valorUnit);
					costoTotal = (double) Math.round((costoTotal) * 1000) / 1000;

					numTinas = nivel4.get(i).getAreaNeta();
					dosis = cantidadAplicada / nivel4.get(i).getAreaNeta();
					dosis = Math.rint(dosis * 1000) / 1000;

					if (dataDetProductos.size() > 0) {

						for (DatAplicProdDetDTO d : dataDetProductos) {

							if (d.getNivel4().getNivel4Id().longValue() == nivel4.get(i).getNivel4Id().longValue()
									&& d.getLaborId().getLaborId().longValue() == labor.getLaborId().longValue()
									&& d.getProductoId_Producto().getProductoId().longValue() == producto
											.getProductoId().longValue()) {

								existeProducto = true;

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
												"El producto " + d.getProductoId_Producto().getNombre()
														+ " ya fue agregado a la lista, por favor seleccione otro. "));

								break;
							}
						}

					}

					if (existeProducto == false) {

						DatAplicProdDetDTO datAplicProdDetDTO2 = new DatAplicProdDetDTO();
						datAplicProdDetDTO2.setProductoId_Producto(producto);
						datAplicProdDetDTO2.setUdadMedId_UdadMed(udadMed);
						datAplicProdDetDTO2.setNombreProducto(nombreProducto);
						datAplicProdDetDTO2.setNombreUdadMed(nombreUdadMed);
						datAplicProdDetDTO2.setCantidadAplicada(cantidadAplicada);
						datAplicProdDetDTO2.setCostoTotal(costoTotal);
						datAplicProdDetDTO2.setValorUnit(valorUnit);
						datAplicProdDetDTO2.setDosis(dosis);
						datAplicProdDetDTO2.setNumTinas(numTinas);

						datAplicProdDetDTO2.setNivel2Id(nivel2);
						datAplicProdDetDTO2.setNivel4(nivel4.get(i));
						datAplicProdDetDTO2.setLaborId(labor);
						datAplicProdDetDTO2.setAlmacenId(almacen);

						datAplicProdDetDTO2.setNombreNivel2(nombreNivel2);
						datAplicProdDetDTO2.setNombreNivel4(nombreNivel4);
						datAplicProdDetDTO2.setNombreLabor(nombreLabor);
						datAplicProdDetDTO2.setNombreAlmacen(nombreAlmacen);

						datAplicProdDetDTO2.setOrdenTrabajo(ot);
						datAplicProdDetDTO2.setEtapaId(etapaId);
						datAplicProdDetDTO2.setVariedId(variedId);
						datAplicProdDetDTO2.setEdad(edad);

						dataDetProductos.add(datAplicProdDetDTO2);

					}

					i++;
				}

				edad = null;
				etapaId = null;
				variedId = null;
				producto = null;
				udadMedId_UdadMed = null;
				cantidadAplicada = null;
				costoTotal = null;
				dosis = null;
				nombreProducto = null;
				nombreUdadMed = null;
				valorUnit = null;
				nivel2Id = null;
				nombreLabor = null;
				nombreNivel2 = null;
				nombreNivel4 = null;
				numTinas = null;
				ordenTrabajoId = null;
				ot = null;

			} else if (tipoDistribucion.equals("lote")) {

				String lotesCheck = "";
				Double areaNetaAcumulada = 0.0;
				Double area_neta = 0.0;
				if (selectedNivel4Prod != null && selectedNivel4Prod.size() > 0) {
					// lotesCheck = selectedNivel4Prod.get(0);
					for (int a = 0; a < selectedNivel4Prod.size(); a++) {
						lotesCheck = selectedNivel4Prod.get(a);
						Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 entidad = listaNivel4.get(0);
						area_neta += entidad.getAreaNeta();

					}
					areaNetaAcumulada += area_neta;
				}

				String lotesSeleccionadas = "";
				if (selectedNivel4Prod != null && selectedNivel4Prod.size() > 0) {
					// lotesSeleccionadas = selectedNivel4Prod.get(0);
					// flagLote = 0L;
					for (int j = 0; j < selectedNivel4Prod.size(); j++) {
						lotesSeleccionadas = selectedNivel4Prod.get(j);
						Long ordenTrabajoId = null;
						DatPlanLaborDet ot = null;
						if (txtOrdenTrabajoProd.getValue() != null) {
							ordenTrabajoId = Long.parseLong(txtOrdenTrabajoProd.getValue().toString());
							ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
						}

						Long nivel2Id = Long.parseLong(txtNivel2IdProd.getValue().toString());
						Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

						// Long nivel4Id = //Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());

						Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 nivel4 = listaNivel4.get(0);

						Long etapaId = null;
						Long variedId = null;

						if (nivel4.getEtapa() != null) {
							etapaId = nivel4.getEtapa().getEtapaId();
						}

						if (nivel4.getVariedad() != null) {
							variedId = nivel4.getVariedad();
						}

						Long laborId = Long.parseLong(txtLaborId_LaborProd.getValue().toString());
						Labor labor = businessDelegatorView.getLabor(laborId);
						Long almacenId = Long.parseLong(txtAlmacenId_Almacen.getValue().toString());
						Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
						Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
						Producto producto = businessDelegatorView.getProducto(productoId);
						Long udadMedId_UdadMed = Long.parseLong(txtUdadMedIdProducto.getValue().toString());
						UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
						String nombreProducto = producto.getNombre(); // FacesUtils.checkString(txtNombreProducto);
						String nombreUdadMed = udadMed.getNombre(); // FacesUtils.checkString(txtNombreUdadMed);
						

					

						
						
						Double cantidadAplicada = FacesUtils.checkDouble(txtCantidadAplicada);
						Double cantidadFinal = (cantidadAplicada * nivel4.getAreaNeta()) / areaNetaAcumulada;
						 cantidadFinal = (double) Math.round((cantidadFinal) * 100) / 100;
						
						
						Double valorUnit = FacesUtils.checkDouble(txtValorUnitInsumos);
						Double costoTotal = (double) Math.round((cantidadFinal * valorUnit) * 10) / 10;
						Double dosis = cantidadFinal / nivel4.getAreaNeta();
						dosis = (double) Math.round((dosis) * 100) / 100;
						String nombreLabor = labor.getNombre(); // FacesUtils.checkString(txtNombreLaborProd);
						String nombreNivel2 = nivel2.getNombre();// FacesUtils.checkString(txtNombreNivel2Prod);
						String nombreNivel4 = nivel4.getCodigo();// FacesUtils.checkString(txtNombreNivel4Prod);
						String nombreAlmacen = almacen.getNombre();// FacesUtils.checkString(txtNombreAlmacenProd);

						
						Double numTinas = nivel4.getAreaNeta();
						Date data = new Date();
						Double edad = (businessDelegatorView.calcularEdadLote(data,
								nivel4.getNivel4Id() ));

						boolean existeProducto = false;

						if (dataDetProductos == null) {
							dataDetProductos = new ArrayList<DatAplicProdDetDTO>();

						}

						if (dataDetProductos.size() > 0) {

							for (DatAplicProdDetDTO d : dataDetProductos) {

								if (d.getNivel4().getNivel4Id().longValue() == nivel4.getNivel4Id().longValue()
										&& d.getLaborId().getLaborId().longValue() == labor.getLaborId().longValue()
										&& d.getProductoId_Producto().getProductoId().longValue() == producto
												.getProductoId().longValue()) {

									existeProducto = true;

									FacesContext.getCurrentInstance().addMessage(null,
											new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!", "El producto "
													+ d.getProductoId_Producto().getNombre()
													+ " ya fue agregado a la lista, por favor seleccione otro. "));

									break;
								}
							}

						}

						if (existeProducto == false) {

							DatAplicProdDetDTO datAplicProdDetDTO2 = new DatAplicProdDetDTO();
							datAplicProdDetDTO2.setProductoId_Producto(producto);
							datAplicProdDetDTO2.setUdadMedId_UdadMed(udadMed);
							datAplicProdDetDTO2.setNombreProducto(nombreProducto);
							datAplicProdDetDTO2.setNombreUdadMed(nombreUdadMed);
							datAplicProdDetDTO2.setCantidadAplicada(cantidadFinal);
							datAplicProdDetDTO2.setCostoTotal(costoTotal);
							datAplicProdDetDTO2.setValorUnit(valorUnit);
							datAplicProdDetDTO2.setDosis(dosis);
							datAplicProdDetDTO2.setNumTinas(numTinas);

							datAplicProdDetDTO2.setNivel2Id(nivel2);
							datAplicProdDetDTO2.setNivel4(nivel4);
							datAplicProdDetDTO2.setLaborId(labor);
							datAplicProdDetDTO2.setAlmacenId(almacen);

							datAplicProdDetDTO2.setNombreNivel2(nombreNivel2);
							datAplicProdDetDTO2.setNombreNivel4(nombreNivel4);
							datAplicProdDetDTO2.setNombreLabor(nombreLabor);
							datAplicProdDetDTO2.setNombreAlmacen(nombreAlmacen);

							datAplicProdDetDTO2.setOrdenTrabajo(ot);
							datAplicProdDetDTO2.setEtapaId(etapaId);
							datAplicProdDetDTO2.setVariedId(variedId);
							datAplicProdDetDTO2.setEdad(edad);

							dataDetProductos.add(datAplicProdDetDTO2);

						}
						edad = null;
						etapaId = null;
						variedId = null;

						producto = null;
						udadMedId_UdadMed = null;
						cantidadAplicada = null;
						costoTotal = null;
						dosis = null;
						nombreProducto = null;
						nombreUdadMed = null;
						valorUnit = null;
						nivel2Id = null;
						// nivel4Id = null;
						nombreLabor = null;
						nombreNivel2 = null;
						nombreNivel4 = null;
						numTinas = null;
						ordenTrabajoId = null;
						ot = null;
					}

				}
			}
			limpiar_pantallaProd();	
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos orden de trabajo, producto, unidad de medida y cantidad aplicada tengan valores. "));
		}
	}

	public void listener_ConsultaUmProducto() {

		Long productoId = null;

		if (!txtProductoId_Producto.getValue().equals("")) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtUdadMedIdProducto.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;
		if (FacesUtils.checkLong(txtUdadMedId_UdadMed) != null) {
			if (!txtUdadMedId_UdadMed.getValue().equals("")) {
				udadMedId = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());

				try {
					UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
					txtNombreUdadMed.setValue(udadMed.getNombre());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}
			}
		}

	}

	public void listener_ConsultaNombreNivel2_Nivel4Prod() {
		Long nivel4Id = null;
		Long nivel2Id = null;
		if (!txtNivel4Id_Nivel4Prod.getValue().equals("") && !txtNivel2IdProd.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4Prod.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2IdProd.getValue().toString());
			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel4Prod.setValue(nivel4.getNombre());
				txtNombreNivel2Prod.setValue(nivel2.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreLaborProd() {
		Long laborId = null;
		if (!txtLaborId_LaborProd.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_LaborProd.getValue().toString());

			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				txtNombreLaborProd.setValue(labor.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreAlmacenProd() {
		Long almacenId = null;
		if (!txtAlmacenId_Almacen.getValue().equals("")) {
			almacenId = Long.parseLong(txtAlmacenId_Almacen.getValue().toString());
			try {
				Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
				txtNombreAlmacenProd.setValue(almacen.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public String actionDeleteDatAplicProdDet(ActionEvent evt) {
		try {

			selectedDatAplicProd = (DatAplicProdDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAplicProd"));

			if (selectedDatAplicProd.getDatProdDetId() == null) {
				dataDetProductos.remove(selectedDatAplicProd);
			} else {
				Long datProdDetId = new Long(selectedDatAplicProd.getDatProdDetId());
				DatAplicProdDet entity = businessDelegatorView.getDatAplicProdDet(datProdDetId);
				businessDelegatorView.deleteDatAplicProdDet(entity);
				dataDetProductos.remove(selectedDatAplicProd);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	/***************** maquinaria ****/

	public void ConsultarTarifaPagoMaquinaria() throws Exception {

		Long idCompania = new Long(getCompaniaIdSession());
		Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMaquinaria);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		if (idUdadMed != null) {
			try {

				tarifaPagoMaquina = businessDelegatorView.consultarTarifaEquipProp(idCompania, idEquipo, idUdadMed,
						idFecha);
				String format = decimalFormat.format(tarifaPagoMaquina);
				txtValorUnitMaquinaria.setValue(format);
				if (tarifaPagoMaquina == null) {
					tarifaMaquinariaNoEncontrada = new BigDecimal("0");
					txtValorUnitMaquinaria.setValue(tarifaMaquinariaNoEncontrada);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
		}
	}

	public void listener_calcularCostoTotalMaquinaria() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitMaquinaria);
		Double cantidadPago = FacesUtils.checkDouble(txtTotalHorasMaquinaria);

		if (valorUnitario != null && cantidadPago != null) {
			result = (valorUnitario * cantidadPago);
			String format = decimalFormat.format(result);
			txtCostoTotalMaquinaria.setValue(format);
		} else {
			result = 0;
			txtCostoTotalMaquinaria.setValue(result);
		}

	}

	public List<DatServicioDetDTO> getDataServicioDet1() {

		if (dataServicioDet == null || dataServicioDet.size() == 0) {
			return null;
		} else {
			return dataServicioDet;
		}

	}

	public void action_agregarServicio() throws Exception {
		
		Double cantidad = FacesUtils.checkDouble(txtCantidadMaq);
		
		if (txtEquipoId_Equipo.getValue() != null && txtUdadMaquinaria.getValue() != null
				&& txtLaborId_LaborMaq.getValue() != null && cantidad!=null && cantidad>0
				&& txtNivel2IdMaq.getValue() != null && txtTipoDistribucionMaq.getValue() != null) {

			String tipoDistribucion = (String) txtTipoDistribucionMaq.getValue();
			int i = 0;

			if (tipoDistribucion.equals("codigoErp")) {

				Long ordenTrabajoId = null;
				DatPlanLaborDet ot = null;
				if (txtOrdenTrabajoMaq.getValue() != null) {
					ordenTrabajoId = Long.parseLong(txtOrdenTrabajoMaq.getValue().toString());
					ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
				}

				Long nivel2Id = Long.parseLong(txtNivel2IdMaq.getValue().toString());
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				String nivel3Id = selectedNivel3Maq.get(0);
				String codigo = txtNivel4ErpMaq.getValue().toString();
				Object[] variables = { "codigoAlternativo", true, codigo, "=", "nivel3", true, nivel3Id, "=" };
				List<Nivel4> nivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);

				Long etapaId = null;
				Long variedId = null;
				String nombreNivel4 = null;
				Double edad = 0.0;

				Double areaNetaTotal = 0.0;

				int n = 0;
				for (n = 0; n < nivel4.size();) {

					Double s = (nivel4.get(n).getAreaNeta());
					areaNetaTotal += s;

					n++;
				}

				Long laborId = Long.parseLong(txtLaborId_LaborMaq.getValue().toString());
				Labor labor = businessDelegatorView.getLabor(laborId);

				Long equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
				Equipo equipo = businessDelegatorView.getEquipo(equipoId);

				Long udadMedId_UdadMed = Long.parseLong(txtUdadMaquinaria.getValue().toString());
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

				Long idContratista = equipo.getContratista().getPersEmprId();

				String codEquipo = equipo.getCodigo();// FacesUtils.checkString(txtCodEquipo);
				String codUdadPagoMaquinaria = udadMed.getNombre();// FacesUtils.checkString(txtCodUmPagoMaquinaria);
				Date horaInicial = null;//FacesUtils.checkDate(txtHoraInicialMaquinaria);
				Date horaFinal = null;//FacesUtils.checkDate(txtHoraFinalMaquinaria);

				Double horometroIni = FacesUtils.checkDouble(txtHorometroInicalMq);
				Double horometroFin = FacesUtils.checkDouble(txtHorometroFinalMq);

				Double totalHoras = 0.0;
				Double valorUnit = 0.0;

				Double costoTotal = FacesUtils.checkDouble(txtCostoTotalMaquinaria);

				String nombreLabor = labor.getNombre();// FacesUtils.checkString(txtNombreLaborMaq);
				String nombreNivel2 = nivel2.getNombre();// FacesUtils.checkString(txtNombreNivel2Maq);
				Date data = new Date();

				boolean existeProducto = false;

				if (dataServicioDet == null) {
					dataServicioDet = new ArrayList<DatServicioDetDTO>();
				}

				for (i = 0; i < nivel4.size();) {

					if (nivel4.get(i).getEtapa() != null) {
						etapaId = nivel4.get(i).getEtapa().getEtapaId();
					}

					if (nivel4.get(i).getVariedad() != null) {
						variedId = nivel4.get(i).getVariedad();
					}

					nombreNivel4 = nivel4.get(i).getNombre();
					edad = (businessDelegatorView.calcularEdadLote(data, nivel4.get(i).getNivel4Id()));

					Double totalHoras1 =horometroFin-horometroIni ;
					valorUnit = FacesUtils.checkDouble(txtValorUnitMaquinaria);
					Double cantidadPago1 = FacesUtils.checkDouble(txtCantidadMaq);
					
					totalHoras = ((totalHoras1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					totalHoras = (double) Math.round((totalHoras) * 1000) / 1000;
					
					cantidadPago1 = ((cantidadPago1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					cantidadPago1 = (double) Math.round((totalHoras) * 1000) / 1000;



					costoTotal = (cantidadPago1 * valorUnit);
					costoTotal = (double) Math.round((costoTotal) * 1000) / 1000;

					if (dataServicioDet.size() > 0) {

						for (DatServicioDetDTO d : dataServicioDet) {

							if (d.getNivel4().getNivel4Id().longValue() == nivel4.get(i).getNivel4Id().longValue()
									&& d.getLaborId().getLaborId().longValue() == labor.getLaborId().longValue()
									&& d.getEquipoId_Equipo().getEquipoId().longValue() == equipo.getEquipoId()
											.longValue()) {

								existeProducto = true;

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
												"El equipo " + d.getEquipoId_Equipo().getNombre()
														+ " ya fue agregado a la lista, por favor seleccione otro. "));

								break;
							}
						}

					}

					if (existeProducto == false) {

						DatServicioDetDTO datServicioDetDTO2 = new DatServicioDetDTO();
						datServicioDetDTO2.setEquipoId_Equipo(equipo);
						datServicioDetDTO2.setUdadMedPago(udadMed);
						datServicioDetDTO2.setCodigoEquipo(codEquipo);
						datServicioDetDTO2.setCodigoUmPago(codUdadPagoMaquinaria);
						datServicioDetDTO2.setHoraInicial(horaInicial);
						datServicioDetDTO2.setHoraFinal(horaFinal);
						datServicioDetDTO2.setOrdenTrabajo(ot);
						datServicioDetDTO2.setHorometroInicial(horometroIni);
						datServicioDetDTO2.setHorometroFinal(horometroFin);
						datServicioDetDTO2.setTotalHoras(totalHoras);
					
						datServicioDetDTO2.setCantidadPago(cantidadPago1);
						datServicioDetDTO2.setValorUnit(valorUnit);
						datServicioDetDTO2.setCostoTotal(costoTotal);
						datServicioDetDTO2.setPersEmprId_PersEmpr(idContratista);
						datServicioDetDTO2.setNivel2Id(nivel2);
						datServicioDetDTO2.setNivel4(nivel4.get(i));
						datServicioDetDTO2.setLaborId(labor);
						datServicioDetDTO2.setNombreNivel2(nombreNivel2);
						datServicioDetDTO2.setNombreNivel4(nombreNivel4);
						datServicioDetDTO2.setNombreLabor(nombreLabor);
						datServicioDetDTO2.setEtapaId(etapaId);
						datServicioDetDTO2.setVariedId(variedId);
						datServicioDetDTO2.setEdad(edad);

						dataServicioDet.add(datServicioDetDTO2);

					}
					i++;

				}

				edad = null;
				etapaId = null;
				variedId = null;
				equipo = null;
				udadMed = null;
				codEquipo = null;
				codUdadPagoMaquinaria = null;
				horaInicial = null;
				horaFinal = null;
				totalHoras = null;
				valorUnit = null;
				costoTotal = null;
				nivel2Id = null;
				nombreLabor = null;
				nombreNivel2 = null;
				nombreNivel4 = null;
				horometroIni = null;
				horometroFin = null;
				ot = null;
				ordenTrabajoId = null;

			} else if (tipoDistribucion.equals("lote")) {

				String lotesCheck = "";
				Double areaNetaAcumulada = 0.0;
				Double area_neta = 0.0;
				if (selectedNivel4Maq != null && selectedNivel4Maq.size() > 0) {
					// lotesCheck = selectedNivel4Maq.get(0);
					for (int a = 0; a < selectedNivel4Maq.size(); a++) {
						lotesCheck = selectedNivel4Maq.get(a);
						Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 entidad = listaNivel4.get(0);
						area_neta += entidad.getAreaNeta();

					}
					areaNetaAcumulada += area_neta;
				}

				String lotesSeleccionadas = "";
				if (selectedNivel4Maq != null && selectedNivel4Maq.size() > 0) {
					// lotesSeleccionadas = selectedNivel4Maq.get(0);
					// flagLote = 0L;
					for (int j = 0; j < selectedNivel4Maq.size(); j++) {
						lotesSeleccionadas = selectedNivel4Maq.get(j);
						Long ordenTrabajoId = null;
						DatPlanLaborDet ot = null;
						if (txtOrdenTrabajoMaq.getValue() != null) {
							ordenTrabajoId = Long.parseLong(txtOrdenTrabajoMaq.getValue().toString());
							ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
						}

						Long nivel2Id = Long.parseLong(txtNivel2IdMaq.getValue().toString());
						Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

						// Long nivel4Id = //Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());

						Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 nivel4 = listaNivel4.get(0);

						Long etapaId = null;
						Long variedId = null;

						if (nivel4.getEtapa() != null) {
							etapaId = nivel4.getEtapa().getEtapaId();
						}

						if (nivel4.getVariedad() != null) {
							variedId = nivel4.getVariedad();
						}

						Long laborId = Long.parseLong(txtLaborId_LaborMaq.getValue().toString());
						Labor labor = businessDelegatorView.getLabor(laborId);

						Long equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
						Equipo equipo = businessDelegatorView.getEquipo(equipoId);

						Long udadMedId_UdadMed = Long.parseLong(txtUdadMaquinaria.getValue().toString());
						UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

						Long idContratista = equipo.getContratista().getPersEmprId();

						String codEquipo = equipo.getCodigo();// FacesUtils.checkString(txtCodEquipo);
						String codUdadPagoMaquinaria = udadMed.getNombre();// FacesUtils.checkString(txtCodUmPagoMaquinaria);
						Date horaInicial =null;// FacesUtils.checkDate(txtHoraInicialMaquinaria);
						Date horaFinal =null;// FacesUtils.checkDate(txtHoraFinalMaquinaria);
						Double horometroIni = FacesUtils.checkDouble(txtHorometroInicalMq);
						Double horometroFin = FacesUtils.checkDouble(txtHorometroFinalMq);

					
						Double totalHoras = horometroFin-horometroIni;
						totalHoras = (totalHoras * nivel4.getAreaNeta()) / areaNetaAcumulada;
						totalHoras =   (double) Math.round((totalHoras ) * 100) / 100;
						
						Double cantidadMaq = FacesUtils.checkDouble(txtCantidadMaq);
						Double cantidadFinal = (cantidadMaq * nivel4.getAreaNeta()) / areaNetaAcumulada;
						cantidadFinal =  (double) Math.round((cantidadFinal ) * 100) / 100;
						Double valorUnit = FacesUtils.checkDouble(txtValorUnitMaquinaria);
						Double costoTotal = (double) Math.round((cantidadFinal * valorUnit) * 10) / 10;
						
						String nombreLabor = labor.getNombre();// FacesUtils.checkString(txtNombreLaborMaq);
						String nombreNivel2 = nivel2.getNombre();// FacesUtils.checkString(txtNombreNivel2Maq);
						String nombreNivel4 = nivel4.getNombre(); // FacesUtils.checkString(txtNombreNivel4Maq);
						Date data = new Date();
						Double edad = (businessDelegatorView.calcularEdadLote(data,
								nivel4.getNivel4Id()));

						boolean existeProducto = false;

						if (dataServicioDet == null) {
							dataServicioDet = new ArrayList<DatServicioDetDTO>();
						}

						if (dataServicioDet.size() > 0) {

							for (DatServicioDetDTO d : dataServicioDet) {

								if (d.getNivel4().getNivel4Id().longValue() == nivel4.getNivel4Id().longValue()
										&& d.getLaborId().getLaborId().longValue() == labor.getLaborId().longValue()
										&& d.getEquipoId_Equipo().getEquipoId().longValue() == equipo.getEquipoId()
												.longValue()) {

									existeProducto = true;

									FacesContext.getCurrentInstance().addMessage(null,
											new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!", "El equipo "
													+ d.getEquipoId_Equipo().getNombre()
													+ " ya fue agregado a la lista, por favor seleccione otro. "));

									break;
								}
							}

						}

						if (existeProducto == false) {

							DatServicioDetDTO datServicioDetDTO2 = new DatServicioDetDTO();
							datServicioDetDTO2.setEquipoId_Equipo(equipo);
							datServicioDetDTO2.setUdadMedPago(udadMed);
							datServicioDetDTO2.setCodigoEquipo(codEquipo);
							datServicioDetDTO2.setCodigoUmPago(codUdadPagoMaquinaria);
							datServicioDetDTO2.setHoraInicial(horaInicial);
							datServicioDetDTO2.setHoraFinal(horaFinal);
							datServicioDetDTO2.setOrdenTrabajo(ot);
							datServicioDetDTO2.setHorometroInicial(horometroIni);
							datServicioDetDTO2.setHorometroFinal(horometroFin);
							datServicioDetDTO2.setTotalHoras(totalHoras);
							datServicioDetDTO2.setCantidadPago(cantidadFinal);
							
							datServicioDetDTO2.setValorUnit(valorUnit);
							datServicioDetDTO2.setCostoTotal(costoTotal);
							datServicioDetDTO2.setPersEmprId_PersEmpr(idContratista);
							datServicioDetDTO2.setNivel2Id(nivel2);
							datServicioDetDTO2.setNivel4(nivel4);
							datServicioDetDTO2.setLaborId(labor);
							datServicioDetDTO2.setNombreNivel2(nombreNivel2);
							datServicioDetDTO2.setNombreNivel4(nombreNivel4);
							datServicioDetDTO2.setNombreLabor(nombreLabor);
							datServicioDetDTO2.setEtapaId(etapaId);
							datServicioDetDTO2.setVariedId(variedId);
							datServicioDetDTO2.setEdad(edad);

							dataServicioDet.add(datServicioDetDTO2);

						}

						edad = null;
						// etapaId = null;
						// variedId = null;
						equipo = null;
						udadMed = null;
						codEquipo = null;
						codUdadPagoMaquinaria = null;
						horaInicial = null;
						horaFinal = null;
						totalHoras = null;
						valorUnit = null;
						costoTotal = null;
						nivel2Id = null;
						// nivel4Id = null;
						nombreLabor = null;
						nombreNivel2 = null;
						nombreNivel4 = null;
						horometroIni = null;
						horometroFin = null;
						ot = null;
						ordenTrabajoId = null;
					}
				}
			}
			limpiar_pantallaMaq();	
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos Orden de trabajo, equipo, unidad de medida, horas totales   tengan valores. "));
		}

	}

	public void listener_ConsultaNombreNivel2_Nivel4Maq() {
		Long nivel4Id = null;
		Long nivel2Id = null;
		if (!txtNivel4Id_Nivel4Maq.getValue().equals("") && !txtNivel2IdMaq.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4Maq.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2IdMaq.getValue().toString());
			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel4Maq.setValue(nivel4.getNombre());
				txtNombreNivel2Maq.setValue(nivel2.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreLaborMaq() {
		Long laborId = null;
		if (!txtLaborId_LaborMaq.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_LaborMaq.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				txtNombreLaborMaq.setValue(labor.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public String actionDeleteDetServicioDet(ActionEvent evt) {
		try {

			selectedDatServicioDet = (DatServicioDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatServicioDet"));

			if (selectedDatServicioDet.getDatServicioDetId() == null) {
				dataServicioDet.remove(selectedDatServicioDet);
			} else {
				Long datServicioId = new Long(selectedDatServicioDet.getDatServicioDetId());
				DatServicioDet entity = businessDelegatorView.getDatServicioDet(datServicioId);
				businessDelegatorView.deleteDatServicioDet(entity);
				dataServicioDet.remove(selectedDatServicioDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void listener_ConsultaCodEquipo() {

		Long idEquipo = null;
		if (FacesUtils.checkLong(txtEquipoId_Equipo) != null) {
			if (!txtEquipoId_Equipo.getValue().equals("")) {
				idEquipo = Long.parseLong(txtEquipoId_Equipo.getValue().toString());

				try {
					Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
					txtCodEquipo.setValue(equipo.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodUmMaquinaria() {

		Long idCodUmMaquinaria = null;
		if (FacesUtils.checkLong(txtUdadMaquinaria) != null) {
			if (!txtUdadMaquinaria.getValue().equals("")) {
				idCodUmMaquinaria = Long.parseLong(txtUdadMaquinaria.getValue().toString());

				try {
					UdadMed udadMed = businessDelegatorView.getUdadMed(idCodUmMaquinaria);
					txtCodUmPagoMaquinaria.setValue(udadMed.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	/**************** riegos ****/

	public List<DatRiegoDTO> getDatRiego1() {

		if (dataRiegos == null || dataRiegos.size() == 0) {
			return null;
		} else {
			return dataRiegos;
		}

	}

	public void action_agregarRiego() throws Exception {
		Double totalArea = FacesUtils.checkDouble(txtTotalAreaRegada);
		
		
		if (txtInfraId_Infraestructura.getValue() != null && txtTrabIdSupervisorRiego.getValue() != null
				&& txtSistemaRiegoId_SistemaRiego.getValue() != null && txtLaborId_LaborRiego.getValue() != null
				&& txtNivel2IdRiego.getValue() != null && txtTipoDistribucionRiego.getValue() != null
				&& totalArea != null && totalArea>0 && txtTurnoCampoId_turnoCampo.getValue() != null) {

			String tipoDistribucion = (String) txtTipoDistribucionRiego.getValue();
			int i = 0;

			if (tipoDistribucion.equals("codigoErp")) {

				Long ordenTrabajoId = null;
				DatPlanLaborDet ot = null;
				if (txtOrdenTrabajoRiego.getValue() != null) {
					ordenTrabajoId = Long.parseLong(txtOrdenTrabajoRiego.getValue().toString());
					ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
				}

				Long nivel2Id = Long.parseLong(txtNivel2IdRiego.getValue().toString());
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				String nivel3Id = selectedNivel3Riego.get(0);
				String codigo = txtNivel4ErpRiego.getValue().toString();
				Object[] variables = { "codigoAlternativo", true, codigo, "=", "nivel3", true, nivel3Id, "=" };
				List<Nivel4> nivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);

				Long etapaId = null;
				Long variedId = null;
				String nombreNivel4 = null;
				Double edad = 0.0;
				Double areaNetaTotal = 0.0;

				int n = 0;
				for (n = 0; n < nivel4.size();) {

					Double s = (nivel4.get(n).getAreaNeta());
					areaNetaTotal += s;

					n++;
				}

				Long laborId = Long.parseLong(txtLaborId_LaborRiego.getValue().toString());
				Labor labor = businessDelegatorView.getLabor(laborId);

				Long infraestructuraId = Long.parseLong(txtInfraId_Infraestructura.getValue().toString());
				Infraestructura infra = businessDelegatorView.getInfraestructura(infraestructuraId);

				Long sistemaRiegoId = Long.parseLong(txtSistemaRiegoId_SistemaRiego.getValue().toString());
				SistemaRiego sistemaRiego = businessDelegatorView.getSistemaRiego(sistemaRiegoId);

				Long trabSupervisor = Long.parseLong(txtTrabIdSupervisorRiego.getValue().toString());
				Trabajador trabajador = businessDelegatorView.getTrabajador(trabSupervisor);

				Long turnoCampoId = Long.parseLong(txtTurnoCampoId_turnoCampo.getValue().toString());
				TurnoCampo turnoCampo = businessDelegatorView.getTurnoCampo(turnoCampoId);

				Date horaInicial =null; //FacesUtils.checkDate(txtHoraIniNivel4);
				Date horaFinal =null; //FacesUtils.checkDate(txtHoraFinNivel4);

				Double totalHoras = 0.0;
				Double totalVolRegado = 0.0;
				Double totalAreaRegada = 0.0;
				Double areaRegada = 0.0;

				Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicalR);
				Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinalR);
				Double totalHorometro = 0.0;//FacesUtils.checkDouble(txtTotalHorometro);
				Double numeroRiego = FacesUtils.checkDouble(txtNumeroRiegos);
				Double caudalLs = FacesUtils.checkDouble(txtCaudalNivel4);

				String nombreLabor = labor.getNombre();
				String nombreNivel2 = nivel2.getNombre();
				String nombreInfraestructura = infra.getNombre();
				String nombreSistemaRiego = sistemaRiego.getNombre();
				String codigoTrabajador = trabajador.getNombre();
				String codigoTurnoCampo = turnoCampo.getNombre();
				Date data = new Date();

				boolean existeProducto = false;

				if (dataRiegos == null) {
					dataRiegos = new ArrayList<DatRiegoDTO>();
				}

				for (i = 0; i < nivel4.size();) {

					if (nivel4.get(i).getEtapa() != null) {
						etapaId = nivel4.get(i).getEtapa().getEtapaId();
					}

					if (nivel4.get(i).getVariedad() != null) {
						variedId = nivel4.get(i).getVariedad();
					}

					nombreNivel4 = nivel4.get(i).getCodigo();
					edad = (businessDelegatorView.calcularEdadLote(data, nivel4.get(i).getNivel4Id()));

					Double totalHoras1 = horometroFinal-horometroInicial;//FacesUtils.checkDouble(txtHoraTotalNivel4);
					Double totalVolRegado1 = FacesUtils.checkDouble(txtVolTotalNivel4);
					Double totalAreaRegada1 = FacesUtils.checkDouble(txtTotalAreaRegada);

					totalHoras = ((totalHoras1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					totalHoras = (double) Math.round((totalHoras) * 100) / 100;

					totalVolRegado = ((totalVolRegado1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					totalVolRegado = (double) Math.round((totalVolRegado) * 100) / 100;

					totalAreaRegada = ((totalAreaRegada1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					totalAreaRegada = (double) Math.round((totalAreaRegada) * 100) / 100;

					areaRegada = totalAreaRegada;

					if (dataRiegos.size() > 0) {

						for (DatRiegoDTO d : dataRiegos) {

							if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4.get(i).getNivel4Id()
									.longValue()
									&& d.getLaborId_Labor().getLaborId().longValue() == labor.getLaborId()
											.longValue()) {

								existeProducto = true;

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
												"El lote " + d.getNivel4Id_Nivel4().getNombre()
														+ " ya fue agregado a la lista, por favor seleccione otro. "));

								break;
							}
						}

					}

					if (existeProducto == false) {

						DatRiegoDTO datRiegoDTO2 = new DatRiegoDTO();
						datRiegoDTO2.setInfraId_Infraestructura(infra);
						datRiegoDTO2.setSistemaRiegoId_SistemaRiego(sistemaRiego);
						datRiegoDTO2.setTurnoCampoId(turnoCampo);
						datRiegoDTO2.setTrabId_Trabajador(trabajador);
						datRiegoDTO2.setNombreInfraestructura(nombreInfraestructura);
						datRiegoDTO2.setSistemaRieNombre(nombreSistemaRiego);
						datRiegoDTO2.setTrabajadorNombre(codigoTrabajador);
						datRiegoDTO2.setCodigoTurnoCampo(codigoTurnoCampo);
						datRiegoDTO2.setTrabajadorNombre(codigoTrabajador);
						datRiegoDTO2.setHoraIniNivel4(horaInicial);
						datRiegoDTO2.setHoraFinNivel4(horaFinal);
						datRiegoDTO2.setHoraTotalNivel4(totalHoras);
						datRiegoDTO2.setHorometroInicial(horometroInicial);
						datRiegoDTO2.setHorometroFinal(horometroFinal);
						datRiegoDTO2.setTotalHorometro(totalHorometro);
						datRiegoDTO2.setTotalAreaRegada(totalAreaRegada);
						datRiegoDTO2.setAreaRegada(areaRegada);
						datRiegoDTO2.setNumeroRiegos(numeroRiego);
						datRiegoDTO2.setCaudalNivel4(caudalLs);
						datRiegoDTO2.setVolTotalNivel4(totalVolRegado);
						datRiegoDTO2.setNivel2Id(nivel2);
						datRiegoDTO2.setNivel4Id_Nivel4(nivel4.get(i));
						datRiegoDTO2.setLaborId_Labor(labor);
						datRiegoDTO2.setNivel2Nombre(nombreNivel2);
						datRiegoDTO2.setNivel4Nombre(nombreNivel4);
						datRiegoDTO2.setLaborNombre(nombreLabor);
						datRiegoDTO2.setOrdenTrabajo(ot);
						datRiegoDTO2.setEtapaId(etapaId);
						datRiegoDTO2.setVariedId(variedId);
						datRiegoDTO2.setEdadEjecucion(edad);

						dataRiegos.add(datRiegoDTO2);

					}
					i++;

				}

				edad = null;
				etapaId = null;
				variedId = null;
				infra = null;
				sistemaRiego = null;
				turnoCampo = null;
				trabajador = null;
				nombreInfraestructura = null;
				nombreSistemaRiego = null;
				codigoTrabajador = null;
				codigoTurnoCampo = null;
				codigoTrabajador = null;
				horaInicial = null;
				horaFinal = null;
				totalHoras = null;
				horometroInicial = null;
				horometroFinal = null;
				totalHorometro = null;
				totalAreaRegada = null;
				areaRegada = null;
				numeroRiego = null;
				caudalLs = null;
				totalVolRegado = null;
				nivel2 = null;
				nivel4 = null;
				labor = null;
				nombreNivel2 = null;
				nombreNivel4 = null;
				nombreLabor = null;
				horaInicial = null;
				horaFinal = null;
				totalHoras = null;
				nivel2Id = null;
				nombreLabor = null;
				nombreNivel2 = null;
				nombreNivel4 = null;
				ot = null;
				ordenTrabajoId = null;

			} else if (tipoDistribucion.equals("lote")) {
				String lotesCheck = "";
				Double areaNetaAcumulada = 0.0;
				Double area_neta = 0.0;
				if (selectedNivel4Riego != null && selectedNivel4Riego.size() > 0) {
					// lotesCheck = selectedNivel4Riego.get(0);
					for (int a = 0; a < selectedNivel4Riego.size(); a++) {
						lotesCheck = selectedNivel4Riego.get(a);
						Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 entidad = listaNivel4.get(0);
						area_neta += entidad.getAreaNeta();

					}
					areaNetaAcumulada += area_neta;
				}

				String lotesSeleccionadas = "";
				if (selectedNivel4Riego != null && selectedNivel4Riego.size() > 0) {
					// lotesSeleccionadas = selectedNivel4Riego.get(0);
					// flagLote = 0L;
					for (int j = 0; j < selectedNivel4Riego.size(); j++) {
						lotesSeleccionadas = selectedNivel4Riego.get(j);
						Long ordenTrabajoId = null;
						DatPlanLaborDet ot = null;
						if (txtOrdenTrabajoRiego.getValue() != null) {
							ordenTrabajoId = Long.parseLong(txtOrdenTrabajoRiego.getValue().toString());
							ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
						}

						Long nivel2Id = Long.parseLong(txtNivel2IdRiego.getValue().toString());
						Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

						// Long nivel4Id = //Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());

						Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 nivel4 = listaNivel4.get(0);

						Long etapaId = null;
						Long variedId = null;

						if (nivel4.getEtapa() != null) {
							etapaId = nivel4.getEtapa().getEtapaId();
						}

						if (nivel4.getVariedad() != null) {
							variedId = nivel4.getVariedad();
						}

						Long laborId = Long.parseLong(txtLaborId_LaborRiego.getValue().toString());
						Labor labor = businessDelegatorView.getLabor(laborId);

						Long infraestructuraId = Long.parseLong(txtInfraId_Infraestructura.getValue().toString());
						Infraestructura infra = businessDelegatorView.getInfraestructura(infraestructuraId);

						Long sistemaRiegoId = Long.parseLong(txtSistemaRiegoId_SistemaRiego.getValue().toString());
						SistemaRiego sistemaRiego = businessDelegatorView.getSistemaRiego(sistemaRiegoId);

						Long trabSupervisor = Long.parseLong(txtTrabIdSupervisorRiego.getValue().toString());
						Trabajador trabajador = businessDelegatorView.getTrabajador(trabSupervisor);

						Long turnoCampoId = Long.parseLong(txtTurnoCampoId_turnoCampo.getValue().toString());
						TurnoCampo turnoCampo = businessDelegatorView.getTurnoCampo(turnoCampoId);

						Date horaInicial = null;//FacesUtils.checkDate(txtHoraIniNivel4);
						Date horaFinal = null;//FacesUtils.checkDate(txtHoraFinNivel4);
						//Double totalHoras = FacesUtils.checkDouble(txtHoraTotalNivel4);

						Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicalR);
						Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinalR);
						Double totalHorometro =  horometroFinal-horometroInicial;//FacesUtils.checkDouble(txtTotalHorometro);
						Double totalAreaRegada = FacesUtils.checkDouble(txtTotalAreaRegada);
						//Double areaRegada = FacesUtils.checkDouble(txtAreaRegada);
						Double numeroRiego = FacesUtils.checkDouble(txtNumeroRiegos);
						Double caudalLs = FacesUtils.checkDouble(txtCaudalNivel4);
						Double totalVolRegado = FacesUtils.checkDouble(txtVolTotalNivel4);

						
						Double totalHorasFinal = (totalHorometro * nivel4.getAreaNeta()) / areaNetaAcumulada;
						totalHorasFinal= (double) Math.round((totalHorasFinal) * 100) / 100;
						Double totalHorometroFinal= (totalHorometro * nivel4.getAreaNeta()) / areaNetaAcumulada;
						totalHorometroFinal= (double) Math.round((totalHorometroFinal) * 100) / 100;
						Double totalAreaRegadaFinal= (totalAreaRegada * nivel4.getAreaNeta()) / areaNetaAcumulada;
						totalAreaRegadaFinal= (double) Math.round((totalAreaRegadaFinal) * 100) / 100;
						Double totalVolRegadoFinal= (totalVolRegado * nivel4.getAreaNeta()) / areaNetaAcumulada;
						totalVolRegadoFinal= (double) Math.round((totalVolRegadoFinal) * 100) / 100;
						
						
						String nombreLabor = labor.getNombre();// FacesUtils.checkString(txtNombreLaborRiego);
						String nombreNivel2 = nivel2.getNombre(); // FacesUtils.checkString(txtNombreNivel2Riego);
						String nombreNivel4 = nivel4.getNombre();// FacesUtils.checkString(txtNombreNivel4Riego);
						String nombreInfraestructura = infra.getNombre();// FacesUtils.checkString(txtNombreInfraestructura);
						String nombreSistemaRiego = sistemaRiego.getNombre(); // FacesUtils.checkString(txtNombreSistemaRiego);
						String codigoTrabajador = trabajador.getNombre();// FacesUtils.checkString(txtCodigoSupervisorRiego);
						String codigoTurnoCampo = turnoCampo.getNombre(); // FacesUtils.checkString(txtCodigoTurnoCampo);
						Date data = new Date();
						Double edad = (businessDelegatorView.calcularEdadLote(data,
								nivel4.getNivel4Id()));

						boolean existeProducto = false;

						if (dataRiegos == null) {
							dataRiegos = new ArrayList<DatRiegoDTO>();
						}

						if (dataRiegos.size() > 0) {

							for (DatRiegoDTO d : dataRiegos) {

								if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4.getNivel4Id().longValue()
										&& d.getLaborId_Labor().getLaborId().longValue() == labor.getLaborId()
												.longValue()) {

									existeProducto = true;

									FacesContext.getCurrentInstance().addMessage(null,
											new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!", "El lote "
													+ d.getNivel4Id_Nivel4().getNombre()
													+ " ya fue agregado a la lista, por favor seleccione otro. "));

									break;
								}
							}

						}

						if (existeProducto == false) {

							DatRiegoDTO datRiegoDTO2 = new DatRiegoDTO();
							datRiegoDTO2.setInfraId_Infraestructura(infra);
							datRiegoDTO2.setSistemaRiegoId_SistemaRiego(sistemaRiego);
							datRiegoDTO2.setTurnoCampoId(turnoCampo);
							datRiegoDTO2.setTrabId_Trabajador(trabajador);
							datRiegoDTO2.setNombreInfraestructura(nombreInfraestructura);
							datRiegoDTO2.setSistemaRieNombre(nombreSistemaRiego);
							datRiegoDTO2.setTrabajadorNombre(codigoTrabajador);
							datRiegoDTO2.setCodigoTurnoCampo(codigoTurnoCampo);
							datRiegoDTO2.setTrabajadorNombre(codigoTrabajador);
							datRiegoDTO2.setHoraIniNivel4(horaInicial);
							datRiegoDTO2.setHoraFinNivel4(horaFinal);
							datRiegoDTO2.setHoraTotalNivel4(totalHorasFinal);
							datRiegoDTO2.setHorometroInicial(horometroInicial);
							datRiegoDTO2.setHorometroFinal(horometroFinal);
							datRiegoDTO2.setTotalHorometro(totalHorometroFinal);
							datRiegoDTO2.setTotalAreaRegada(totalAreaRegadaFinal);
							datRiegoDTO2.setAreaRegada(totalAreaRegadaFinal);
							datRiegoDTO2.setNumeroRiegos(numeroRiego);
							datRiegoDTO2.setCaudalNivel4(caudalLs);
							datRiegoDTO2.setVolTotalNivel4(totalVolRegadoFinal);
							datRiegoDTO2.setNivel2Id(nivel2);
							datRiegoDTO2.setNivel4Id_Nivel4(nivel4);
							datRiegoDTO2.setLaborId_Labor(labor);
							datRiegoDTO2.setNivel2Nombre(nombreNivel2);
							datRiegoDTO2.setNivel4Nombre(nombreNivel4);
							datRiegoDTO2.setLaborNombre(nombreLabor);
							datRiegoDTO2.setOrdenTrabajo(ot);
							datRiegoDTO2.setEtapaId(etapaId);
							datRiegoDTO2.setVariedId(variedId);
							datRiegoDTO2.setEdadEjecucion(edad);

							dataRiegos.add(datRiegoDTO2);

						}
						edad = null;
						etapaId = null;
						variedId = null;
						infra = null;
						sistemaRiego = null;
						turnoCampo = null;
						trabajador = null;
						nombreInfraestructura = null;
						nombreSistemaRiego = null;
						codigoTrabajador = null;
						codigoTurnoCampo = null;
						codigoTrabajador = null;
					//	horaInicial = null;
					//	horaFinal = null;
						
						horometroInicial = null;
						horometroFinal = null;
						totalHorometro = null;
						totalAreaRegada = null;
						//areaRegada = null;
						numeroRiego = null;
						caudalLs = null;
						totalVolRegado = null;
						nivel2 = null;
						nivel4 = null;
						labor = null;
						nombreNivel2 = null;
						nombreNivel4 = null;
						nombreLabor = null;
					//	horaInicial = null;
					//	horaFinal = null;
						//totalHoras = null;
						nivel2Id = null;
					//	nivel4Id = null;
						nombreLabor = null;
						nombreNivel2 = null;
						nombreNivel4 = null;
						ot = null;
						ordenTrabajoId = null;
					}
				}
			}
		limpiar_pantallaRiego();	
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos Orden de trabajo, supervisor, fuente de agua, sistema de riego, turno, área regada  tengan valores. "));
		}
		
	}

	public void listener_calcularVolTotalNivel4() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double caudalNivel4 = FacesUtils.checkDouble(txtCaudalNivel4);
		Double horaTotalNivel4 = FacesUtils.checkDouble(getTxtHoraTotalNivel4());
		Double areaRegada = FacesUtils.checkDouble(txtAreaRegada);

		if (caudalNivel4 != null && horaTotalNivel4 != null && areaRegada != null) {
			result = (caudalNivel4 * horaTotalNivel4 * areaRegada * 3.6);
			String format = decimalFormat.format(result);
			txtVolTotalNivel4.setValue(format);
		} else {
			result = 0;
			txtVolTotalNivel4.setValue(result);
		}

	}

	public void listener_ConsultaNombreNivel2_Nivel4Riego() {
		Long nivel4Id = null;
		if (!txtNivel4Id_Nivel4Riego.getValue().equals("") && !txtNivel2IdRiego.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4Riego.getValue().toString());
			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				txtAreaRegada.setValue(nivel4.getAreaNeta());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreLaborRiego() {
		Long laborId = null;
		if (!txtLaborId_LaborRiego.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_LaborRiego.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				txtNombreLaborRiego.setValue(labor.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreSistemaRiegoRiego() {
		Long sistemaRiegoId = null;
		if (!txtSistemaRiegoId_SistemaRiego.getValue().equals("")) {
			sistemaRiegoId = Long.parseLong(txtSistemaRiegoId_SistemaRiego.getValue().toString());
			try {
				SistemaRiego sistemaRiego = businessDelegatorView.getSistemaRiego(sistemaRiegoId);
				txtNombreSistemaRiego.setValue(sistemaRiego.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreInfraestructuraRiego() {
		Long infraestructuraId = null;
		if (!txtInfraId_Infraestructura.getValue().equals("")) {
			infraestructuraId = Long.parseLong(txtInfraId_Infraestructura.getValue().toString());
			try {
				Infraestructura infra = businessDelegatorView.getInfraestructura(infraestructuraId);
				txtNombreInfraestructura.setValue(infra.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreSupervisorRiego() {
		Long supervisorId = null;
		if (!txtTrabIdSupervisorRiego.getValue().equals("")) {
			supervisorId = Long.parseLong(txtTrabIdSupervisorRiego.getValue().toString());
			try {
				Trabajador supervisor = businessDelegatorView.getTrabajador(supervisorId);
				txtCodigoSupervisorRiego.setValue(supervisor.getCodigo());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaCodTurnoCampo() {
		Long turnoCampoId = null;
		if (!txtTurnoCampoId_turnoCampo.getValue().equals("")) {
			turnoCampoId = Long.parseLong(txtTurnoCampoId_turnoCampo.getValue().toString());
			try {
				TurnoCampo turnoCampo = businessDelegatorView.getTurnoCampo(turnoCampoId);
				txtCodigoTurnoCampo.setValue(turnoCampo.getCodigo());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public String actionDeleteDatRiego(ActionEvent evt) {
		try {

			selectedDatRiegos = (DatRiegoDTO) (evt.getComponent().getAttributes().get("selectedDatRiegos"));

			if (selectedDatRiegos.getDatRiegoId() == null) {
				dataRiegos.remove(selectedDatRiegos);
			} else {
				Long datRiegoId = new Long(selectedDatRiegos.getDatRiegoId());
				DatRiego entity = businessDelegatorView.getDatRiego(datRiegoId);
				businessDelegatorView.deleteDatRiego(entity);
				dataRiegos.remove(selectedDatRiegos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void onCellEditManoObra(CellEditEvent event) throws Exception {

		selectedDatPlanillaDet = (DatPlanillaNominaDetDTO) (event.getComponent().getAttributes()
				.get("selectedDatPlanillaDet"));

		if (selectedDatPlanillaDet.getDetPlanillaNominaId() != null) {

			Long detPlanillaNominaId = selectedDatPlanillaDet.getDetPlanillaNominaId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long planillaNominaId = FacesUtils.checkLong(txtPlanillaNominaId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityDatPlanillaNominaDet = null;

				entityDatPlanillaNominaDet = businessDelegatorView.getDatPlanillaNominaDet(detPlanillaNominaId);

				if (columnaCell.equals("Hda")) {

					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityDatPlanillaNominaDet.setNivel2Id(Nivel2);

				} else if (columnaCell.equals("Lote")) {

					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);

					entityDatPlanillaNominaDet.setNivel4(Nivel4);

				} else if (columnaCell.equals("Labor")) {

					Long laborId = new Long(event.getNewValue().toString());
					Labor Labor = businessDelegatorView.getLabor(laborId);

					entityDatPlanillaNominaDet.setLaborId(Labor);

				} else if (columnaCell.equals("Trabajador")) {

					Long trabajadorId = new Long(event.getNewValue().toString());
					Trabajador Trabajador = businessDelegatorView.getTrabajador(trabajadorId);

					entityDatPlanillaNominaDet.setTrabajador(Trabajador);

				} else if (columnaCell.equals("Concepto")) {

					Long conceptoNomina = new Long(event.getNewValue().toString());
					ConceptoNomina ConceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNomina);

					entityDatPlanillaNominaDet.setConceptoNomina(ConceptoNomina);

				} else if (columnaCell.equals("U.M(Pago)")) {

					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

					entityDatPlanillaNominaDet.setUdadMedByUdadMedPago(udadMed);

				} else if (columnaCell.equals("Cantidad")) {

					Double tarifa = entityDatPlanillaNominaDet.getValorUnitario();
					Double cantidad = (Double) newValue;
					entityDatPlanillaNominaDet.setCantidadPago((Double) newValue);
					entityDatPlanillaNominaDet.setCostoTotal(cantidad * tarifa);

				} else if (columnaCell.equals("Tarifa")) {
					Double tarifa = (Double) newValue;
					;
					Double cantidad = entityDatPlanillaNominaDet.getCantidadPago();
					entityDatPlanillaNominaDet.setValorUnitario((Double) newValue);
					entityDatPlanillaNominaDet.setCostoTotal(cantidad * tarifa);

				} else if (columnaCell.equals("C. Total")) {

					entityDatPlanillaNominaDet.setCostoTotal((Double) newValue);

				}else if (columnaCell.equals("Equipo")) {

					Long equipoId = new Long(event.getNewValue().toString());
					Equipo Equipo = businessDelegatorView.getEquipo(equipoId);

					entityDatServicioDet.setEquipo(Equipo);

				}else if (columnaCell.equals("HorómetroInic")) {

					entityDatPlanillaNominaDet.setHorometroInicial((Double) newValue);

				} else if (columnaCell.equals("HorómetroFin")) {

					entityDatPlanillaNominaDet.setHorometroFinal((Double) newValue);

				} else if (columnaCell.equals("Horas")) {

					entityDatPlanillaNominaDet.setHorometroTotal((Double) newValue);

				} 

				entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
				entityDatPlanillaNominaDet.setPlanillaNominaId(entity);
				businessDelegatorView.updateDatPlanillaNominaDet(entityDatPlanillaNominaDet);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataPlanillaDet = null;
				entityDatPlanillaNominaDet = null;
				selectedDatPlanillaDet = null;

				dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNominaId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditMaquinaria(CellEditEvent event) throws Exception {

		selectedDatServicioDet = (DatServicioDetDTO) (event.getComponent().getAttributes()
				.get("selectedDatServicioDet"));

		if (selectedDatServicioDet.getDatServicioDetId() != null) {

			Long datServicioDetId = selectedDatServicioDet.getDatServicioDetId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long datServicioId = FacesUtils.checkLong(txtPlanillaNominaId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityDatServicioDet = null;

				entityDatServicioDet = businessDelegatorView.getDatServicioDet(datServicioDetId);

				if (columnaCell.equals("Hda")) {

					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityDatServicioDet.setNivel2Id(Nivel2);

				} else if (columnaCell.equals("Lote")) {

					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);

					entityDatServicioDet.setNivel4(Nivel4);

				} else if (columnaCell.equals("Labor")) {

					Long laborId = new Long(event.getNewValue().toString());
					Labor Labor = businessDelegatorView.getLabor(laborId);

					entityDatServicioDet.setLaborId(Labor);

				} else if (columnaCell.equals("Equipo")) {

					Long equipoId = new Long(event.getNewValue().toString());
					Equipo Equipo = businessDelegatorView.getEquipo(equipoId);

					entityDatServicioDet.setEquipo(Equipo);

				} else if (columnaCell.equals("U.M(Pago)")) {

					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

					entityDatServicioDet.setUdadMedByUdadMedPago(udadMed);

				} else if (columnaCell.equals("HoraIni")) {

					entityDatServicioDet.setHoraInicial((Date) newValue);

				} else if (columnaCell.equals("HoraFin")) {

					entityDatServicioDet.setHoraFinal((Date) newValue);

				} else if (columnaCell.equals("HorómetroInic")) {

					entityDatServicioDet.setHorometroInicial((Double) newValue);

				} else if (columnaCell.equals("HorómetroFin")) {

					entityDatServicioDet.setHorometroFinal((Double) newValue);

				} else if (columnaCell.equals("Horas")) {

					entityDatServicioDet.setTotalHoras((Double) newValue);

				} else if (columnaCell.equals("Tarifa")) {

					entityDatServicioDet.setValorUnit((Double) newValue);

				} else if (columnaCell.equals("C. Total")) {

					entityDatServicioDet.setCostoTotal((Double) newValue);

				}

				entity = businessDelegatorView.getDatPlanillaNomina(datServicioId);
				entityDatServicioDet.setDatPlanillaNominaId(entity);
				businessDelegatorView.updateDatServicioDet(entityDatServicioDet);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataServicioDet = null;
				entityDatServicioDet = null;
				selectedDatServicioDet = null;

				dataServicioDet = businessDelegatorView.getDataDatServicioDetByPlanillaNomina(datServicioId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditInsumo(CellEditEvent event) throws Exception {

		selectedDatAplicProd = (DatAplicProdDetDTO) (event.getComponent().getAttributes().get("selectedDatAplicProd"));

		if (selectedDatAplicProd.getDatProdDetId() != null) {

			Long datProdDetId = selectedDatAplicProd.getDatProdDetId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long planillaNominaId = FacesUtils.checkLong(txtPlanillaNominaId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityDatAplicProdDet = null;

				entityDatAplicProdDet = businessDelegatorView.getDatAplicProdDet(datProdDetId);

				if (columnaCell.equals("Hda")) {

					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityDatAplicProdDet.setNivel2Id(Nivel2);

				} else if (columnaCell.equals("Lote")) {

					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);

					entityDatAplicProdDet.setNivel4(Nivel4);

				} else if (columnaCell.equals("Labor")) {

					Long laborId = new Long(event.getNewValue().toString());
					Labor Labor = businessDelegatorView.getLabor(laborId);

					entityDatAplicProdDet.setLaborId(Labor);

				} else if (columnaCell.equals("Almacén")) {

					Long almacenId = new Long(event.getNewValue().toString());
					Almacen Almacen = businessDelegatorView.getAlmacen(almacenId);

					entityDatAplicProdDet.setAlmacenId(Almacen);

				} else if (columnaCell.equals("Producto")) {

					Long productoId = new Long(event.getNewValue().toString());
					Producto Producto = businessDelegatorView.getProducto(productoId);

					entityDatAplicProdDet.setProducto(Producto);

				} else if (columnaCell.equals("Unidad (Dosis)")) {

					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

					entityDatAplicProdDet.setUdadMed(udadMed);

				} else if (columnaCell.equals("Cantidad Aplicada")) {

					entityDatAplicProdDet.setCantidadAplicada((Double) newValue);

				} else if (columnaCell.equals("Valor Unitario")) {

					entityDatAplicProdDet.setValorUnit((Double) newValue);

				} else if (columnaCell.equals("Costo Total")) {

					entityDatAplicProdDet.setCostoTotal((Double) newValue);
				}

				entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
				entityDatAplicProdDet.setDatPlanillaNominaId(entity);
				businessDelegatorView.updateDatAplicProdDet(entityDatAplicProdDet);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataDetProductos = null;
				entityDatAplicProdDet = null;
				selectedDatAplicProd = null;

				dataDetProductos = businessDelegatorView.getDataDetProductosByPlanillaNomina(planillaNominaId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditRiegos(CellEditEvent event) throws Exception {

		selectedDatRiegos = (DatRiegoDTO) (event.getComponent().getAttributes().get("selectedDatRiegos"));

		if (selectedDatRiegos.getDatRiegoId() != null) {

			Long datRiegoId = selectedDatRiegos.getDatRiegoId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long planillaNominaId = FacesUtils.checkLong(txtPlanillaNominaId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityRiego = null;

				entityRiego = businessDelegatorView.getDatRiego(datRiegoId);

				if (columnaCell.equals("Hda")) {

					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);

					entityRiego.setNivel2Id(Nivel2);

				} else if (columnaCell.equals("Lote")) {

					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);

					entityRiego.setNivel4(Nivel4);

				} else if (columnaCell.equals("Labor")) {

					Long laborId = new Long(event.getNewValue().toString());
					Labor Labor = businessDelegatorView.getLabor(laborId);

					entityRiego.setLabor(Labor);

				} else if (columnaCell.equals("F.(Agua)")) {

					Long infraId = new Long(event.getNewValue().toString());
					Infraestructura Infraestructura = businessDelegatorView.getInfraestructura(infraId);

					entityRiego.setInfraestructura(Infraestructura);

				} else if (columnaCell.equals("S. Riego")) {

					Long sistemaRiegoId = new Long(event.getNewValue().toString());
					SistemaRiego SistemaRiego = businessDelegatorView.getSistemaRiego(sistemaRiegoId);

					entityRiego.setSistemaRiego(SistemaRiego);

				} else if (columnaCell.equals("Área Regada")) {

					entityRiego.setAreaRegada((Double) newValue);

				} else if (columnaCell.equals("Hras de Riego")) {

					entityRiego.setHoraTotalNivel4((Double) newValue);

				} else if (columnaCell.equals("Total. Horómetro")) {

					entityRiego.setTotalHorometro((Double) newValue);

				} else if (columnaCell.equals("Caudal(Ls)")) {

					entityRiego.setCaudalNivel4((Double) newValue);

				} else if (columnaCell.equals("Vól(M3)")) {

					entityRiego.setVolTotalNivel4((Double) newValue);
				}

				entity = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);
				entityRiego.setDatPlanillaNominaId(entity);
				businessDelegatorView.updateDatRiego(entityRiego);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataRiegos = null;
				entityRiego = null;
				selectedDatRiegos = null;

				dataRiegos = businessDelegatorView.getDataDatRiegoByPlanillaNomina(planillaNominaId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public BigDecimal getRendimientoT() {
		return rendimientoT;
	}

	public void setRendimientoT(BigDecimal rendimientoT) {
		this.rendimientoT = rendimientoT;
	}

	public BigDecimal getAuxSabado() {
		return auxSabado;
	}

	public void setAuxSabado(BigDecimal auxSabado) {
		this.auxSabado = auxSabado;
	}

	public Long getDiaSabado() {
		return diaSabado;
	}

	public void setDiaSabado(Long diaSabado) {
		this.diaSabado = diaSabado;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public InputText getTxtPesoPromedio() {
		return txtPesoPromedio;
	}

	public void setTxtPesoPromedio(InputText txtPesoPromedio) {
		this.txtPesoPromedio = txtPesoPromedio;
	}

	public InputText getTxtNumeroTiquete() {
		return txtNumeroTiquete;
	}

	public void setTxtNumeroTiquete(InputText txtNumeroTiquete) {
		this.txtNumeroTiquete = txtNumeroTiquete;
	}

	public SelectItem[] getSelectNivel2Edit() {

		if (nivel2Edit == null || nivel2Edit.size() == 0) {

			try {

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

	public SelectItem[] getSelectNivel2MaqEdit() {

		if (nivel2MaqEdit == null || nivel2MaqEdit.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2MaqEdit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2MaqEdit : lista) {
					selectNivel2MaqEdit[i] = new SelectItem(nivel2MaqEdit.getNivel2Id(), nivel2MaqEdit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2MaqEdit;
	}

	public void setSelectNivel2MaqEdit(SelectItem[] selectNivel2MaqEdit) {

		this.selectNivel2MaqEdit = selectNivel2MaqEdit;
	}

	public SelectItem[] getSelectNivel4MaqEdit() {

		if (nivel4MaqEdit == null || nivel4MaqEdit.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4MaqEdit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4MaqEdit : lista) {
					selectNivel4MaqEdit[i] = new SelectItem(nivel4MaqEdit.getNivel4Id(), nivel4MaqEdit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4MaqEdit;
	}

	public void setSelectNivel4MaqEdit(SelectItem[] selectNivel4MaqEdit) {
		this.selectNivel4MaqEdit = selectNivel4MaqEdit;
	}

	public SelectItem[] getSelectNivel2ProdEdit() {

		if (nivel2ProdEdit == null || nivel2ProdEdit.size() == 0) {

			try {
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2ProdEdit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2ProdEdit : lista) {
					selectNivel2ProdEdit[i] = new SelectItem(nivel2ProdEdit.getNivel2Id(), nivel2ProdEdit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2ProdEdit;
	}

	public void setSelectNivel2ProdEdit(SelectItem[] selectNivel2ProdEdit) {

		this.selectNivel2ProdEdit = selectNivel2ProdEdit;
	}

	public SelectItem[] getSelectNivel4ProdEdit() {

		if (nivel4ProdEdit == null || nivel4ProdEdit.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4ProdEdit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4ProdEdit : lista) {
					selectNivel4ProdEdit[i] = new SelectItem(nivel4ProdEdit.getNivel4Id(), nivel4ProdEdit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ProdEdit;
	}

	public void setSelectNivel4ProdEdit(SelectItem[] selectNivel4ProdEdit) {
		this.selectNivel4ProdEdit = selectNivel4ProdEdit;
	}

	public SelectItem[] getSelectNivel2RiegoEdit() {

		if (nivel2RiegoEdit == null || nivel2RiegoEdit.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2RiegoEdit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2RiegoEdit : lista) {
					selectNivel2RiegoEdit[i] = new SelectItem(nivel2RiegoEdit.getNivel2Id(),
							nivel2RiegoEdit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2RiegoEdit;
	}

	public void setSelectNivel2RiegoEdit(SelectItem[] selectNivel2RiegoEdit) {

		this.selectNivel2RiegoEdit = selectNivel2RiegoEdit;
	}

	public SelectItem[] getSelectNivel4RiegoEdit() {

		if (nivel4RiegoEdit == null || nivel4RiegoEdit.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4RiegoEdit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4RiegoEdit : lista) {
					selectNivel4RiegoEdit[i] = new SelectItem(nivel4RiegoEdit.getNivel4Id(),
							nivel4RiegoEdit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4RiegoEdit;
	}

	public void setSelectNivel4RiegoEdit(SelectItem[] selectNivel4RiegoEdit) {
		this.selectNivel4RiegoEdit = selectNivel4RiegoEdit;
	}

	public SelectItem[] getSelectTurnoCampo() {

		if (turnoCampo == null || turnoCampo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<TurnoCampo> lista = businessDelegatorView.findByCriteriaInTurnoCampo(condicion, null, null);
				selectTurnoCampo = new SelectItem[lista.size()];

				int i = 0;
				for (TurnoCampo tc : lista) {
					selectTurnoCampo[i] = new SelectItem(tc.getTurnoCampoId(), tc.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTurnoCampo;
	}

	public void setSelectTurnoCampo(SelectItem[] selectTurnoCampo) {
		this.selectTurnoCampo = selectTurnoCampo;
	}

	public InputText getTxtHorometroInicalMq() {
		return txtHorometroInicalMq;
	}

	public void setTxtHorometroInicalMq(InputText txtHorometroInicalMq) {
		this.txtHorometroInicalMq = txtHorometroInicalMq;
	}

	public InputText getTxtHorometroFinalMq() {
		return txtHorometroFinalMq;
	}

	public void setTxtHorometroFinalMq(InputText txtHorometroFinalMq) {
		this.txtHorometroFinalMq = txtHorometroFinalMq;
	}

	public Spinner getTxtNumeroRiegos() {
		return txtNumeroRiegos;
	}

	public void setTxtNumeroRiegos(Spinner txtNumeroRiegos) {
		this.txtNumeroRiegos = txtNumeroRiegos;
	}

	public InputText getTxtHorometroFinalR() {
		return txtHorometroFinalR;
	}

	public void setTxtHorometroFinalR(InputText txtHorometroFinalR) {
		this.txtHorometroFinalR = txtHorometroFinalR;
	}

	public InputText getTxtHorometroInicalR() {
		return txtHorometroInicalR;
	}

	public void setTxtHorometroInicalR(InputText txtHorometroInicalR) {
		this.txtHorometroInicalR = txtHorometroInicalR;
	}

	public InputText getTxtTotalAreaRegada() {
		return txtTotalAreaRegada;
	}

	public void setTxtTotalAreaRegada(InputText txtTotalAreaRegada) {
		this.txtTotalAreaRegada = txtTotalAreaRegada;
	}

	public InputText getTxtTotalHorometro() {
		return txtTotalHorometro;
	}

	public void setTxtTotalHorometro(InputText txtTotalHorometro) {
		this.txtTotalHorometro = txtTotalHorometro;
	}

	public SelectOneMenu getTxtTurnoCampoId_turnoCampo() {
		return txtTurnoCampoId_turnoCampo;
	}

	public void setTxtTurnoCampoId_turnoCampo(SelectOneMenu txtTurnoCampoId_turnoCampo) {
		this.txtTurnoCampoId_turnoCampo = txtTurnoCampoId_turnoCampo;
	}

	public InputText getTxtkwhIncial() {
		return txtkwhIncial;
	}

	public void setTxtkwhIncial(InputText txtkwhIncial) {
		this.txtkwhIncial = txtkwhIncial;
	}

	public InputText getTxtkwhFinal() {
		return txtkwhFinal;
	}

	public void setTxtkwhFinal(InputText txtkwhFinal) {
		this.txtkwhFinal = txtkwhFinal;
	}

	public InputText getTxtsurcosLargos() {
		return txtsurcosLargos;
	}

	public void setTxtsurcosLargos(InputText txtsurcosLargos) {
		this.txtsurcosLargos = txtsurcosLargos;
	}

	public InputText getTxtsurcosCortos() {
		return txtsurcosCortos;
	}

	public void setTxtsurcosCortos(InputText txtsurcosCortos) {
		this.txtsurcosCortos = txtsurcosCortos;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtCantidadDescontar() {
		return txtCantidadDescontar;
	}

	public void setTxtCantidadDescontar(InputText txtCantidadDescontar) {
		this.txtCantidadDescontar = txtCantidadDescontar;
	}

	public SelectOneMenu getTxtEstadoIncidencia() {
		return txtEstadoIncidencia;
	}

	public void setTxtEstadoIncidencia(SelectOneMenu txtEstadoIncidencia) {
		this.txtEstadoIncidencia = txtEstadoIncidencia;
	}

	public SelectOneMenu getTxtAlturaPlanta() {
		return txtAlturaPlanta;
	}

	public void setTxtAlturaPlanta(SelectOneMenu txtAlturaPlanta) {
		this.txtAlturaPlanta = txtAlturaPlanta;
	}

	/***** Consultas Maquinaria ****/

	public SelectItem[] getselectNivel2Maq() {

		if (nivel2Maq == null || nivel2Maq.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Maq = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Maq : lista) {
					selectNivel2Maq[i] = new SelectItem(nivel2Maq.getNivel2Id(), nivel2Maq.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Maq;
	}

	public void setselectNivel2Maq(SelectItem[] selectNivel2Maq) {
		this.selectNivel2Maq = selectNivel2Maq;
	}

	public SelectItem[] getselectNivel3Maq() {

		nivel3Maq = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2IdMaq != null && txtNivel2IdMaq.getValue() != null && !txtNivel2IdMaq.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdMaq.getValue().toString());

			try {
				Nivel2 nivel2Maq = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3Maq = nivel2Maq.getNivel3s().toArray();

				selectNivel3Maq = new SelectItem[niveles3Maq.length];

				int i = 0;
				for (Object object : niveles3Maq) {
					Nivel3 nivel3Maq = (Nivel3) object;
					selectNivel3Maq[i] = new SelectItem(nivel3Maq.getNivel3Id(), nivel3Maq.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3Maq;
	}

	public void setselectNivel3Maq(SelectItem[] selectNivel3Maq) {
		this.selectNivel3Maq = selectNivel3Maq;
	}

	public SelectItem[] getselectNivel4Maq() {
		nivel4Maq = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3IdMaq != null && txtNivel3IdMaq.getValue() != null && !txtNivel3IdMaq.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3IdMaq.getValue().toString());

			try {
				Nivel3 nivel3Maq = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4Maq = nivel3Maq.getNivel4s().toArray();

				selectNivel4Maq = new SelectItem[niveles4Maq.length];

				int i = 0;
				for (Object object : niveles4Maq) {
					Nivel4 nivel4Maq = (Nivel4) object;
					selectNivel4Maq[i] = new SelectItem(nivel4Maq.getNivel4Id(),
							nivel4Maq.getNombre() + '-' + "Área: " + nivel4Maq.getAreaNeta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

		return selectNivel4Maq;
	}

	@SuppressWarnings("unlikely-arg-type")
	public SelectItem[] getselectNivel4ErpMaq() throws NumberFormatException, Exception {

		if (bloquesMaq != null && !bloquesMaq.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3Maq != null && selectedNivel3Maq.size() > 0) {
				bloquesSeleccionadas = selectedNivel3Maq.get(0);
				for (int i = 1; i < selectedNivel3Maq.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3Maq.get(i);
				}
			}
			try {

				nivel4ErpMaq = businessDelegator2View.listaCodigosErp(bloquesSeleccionadas);
				selectNivel4ErpMaq = new SelectItem[nivel4ErpMaq.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : nivel4ErpMaq) {
					selectNivel4ErpMaq[i] = new SelectItem(nivel4.getCodigoErp(), nivel4.getCodigoErp());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ErpMaq;
	}

	public void setselectNivel4ErpMaq(SelectItem[] selectNivel4ErpMaq) {
		this.selectNivel4ErpMaq = selectNivel4ErpMaq;
	}

	public void setselectNivel4Maq(SelectItem[] selectNivel4Maq) {
		this.selectNivel4Maq = selectNivel4Maq;
	}

	public SelectItem[] getselectLaborIdMaq() {

		if (laborIdMaq == null || laborIdMaq.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborIdMaq = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborIdMaq : lista) {
					selectLaborIdMaq[i] = new SelectItem(laborIdMaq.getLaborId(), laborIdMaq.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborIdMaq;
	}

	public void setselectLaborIdMaq(SelectItem[] selectLaborIdMaq) {

		this.selectLaborIdMaq = selectLaborIdMaq;
	}

	/******* PRODUCTOS ****/

	public SelectItem[] getselectNivel2Prod() {

		if (nivel2Prod == null || nivel2Prod.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Prod = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Prod : lista) {
					selectNivel2Prod[i] = new SelectItem(nivel2Prod.getNivel2Id(), nivel2Prod.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Prod;
	}

	public void setselectNivel2Prod(SelectItem[] selectNivel2Prod) {
		this.selectNivel2Prod = selectNivel2Prod;
	}

	public SelectItem[] getselectNivel3Prod() {

		nivel3Prod = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2IdProd != null && txtNivel2IdProd.getValue() != null && !txtNivel2IdProd.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdProd.getValue().toString());

			try {
				Nivel2 nivel2Prod = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3Prod = nivel2Prod.getNivel3s().toArray();

				selectNivel3Prod = new SelectItem[niveles3Prod.length];

				int i = 0;
				for (Object object : niveles3Prod) {
					Nivel3 nivel3Prod = (Nivel3) object;
					selectNivel3Prod[i] = new SelectItem(nivel3Prod.getNivel3Id(), nivel3Prod.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3Prod;
	}

	public void setselectNivel3Prod(SelectItem[] selectNivel3Prod) {
		this.selectNivel3Prod = selectNivel3Prod;
	}

	public SelectItem[] getselectNivel4Prod() {
		nivel4Prod = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3IdProd != null && txtNivel3IdProd.getValue() != null && !txtNivel3IdProd.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3IdProd.getValue().toString());

			try {
				Nivel3 nivel3Prod = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4Prod = nivel3Prod.getNivel4s().toArray();

				selectNivel4Prod = new SelectItem[niveles4Prod.length];

				int i = 0;
				for (Object object : niveles4Prod) {
					Nivel4 nivel4Prod = (Nivel4) object;
					selectNivel4Prod[i] = new SelectItem(nivel4Prod.getNivel4Id(),
							nivel4Prod.getNombre() + '-' + "Área: " + nivel4Prod.getAreaNeta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4Prod;
	}

	public void setselectNivel4Prod(SelectItem[] selectNivel4Prod) {
		this.selectNivel4Prod = selectNivel4Prod;
	}

	@SuppressWarnings("unlikely-arg-type")
	public SelectItem[] getselectNivel4ErpProd() throws NumberFormatException, Exception {

		if (bloquesProd != null && !bloquesProd.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3Prod != null && selectedNivel3Prod.size() > 0) {
				bloquesSeleccionadas = selectedNivel3Prod.get(0);
				for (int i = 1; i < selectedNivel3Prod.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3Prod.get(i);
				}
			}
			try {

				nivel4ErpProd = businessDelegator2View.listaCodigosErp(bloquesSeleccionadas);
				selectNivel4ErpProd = new SelectItem[nivel4ErpProd.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : nivel4ErpProd) {
					selectNivel4ErpProd[i] = new SelectItem(nivel4.getCodigoErp(), nivel4.getCodigoErp());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ErpProd;
	}

	public void setselectNivel4ErpProd(SelectItem[] selectNivel4ErpProd) {
		this.selectNivel4ErpProd = selectNivel4ErpProd;
	}

	public SelectItem[] getselectLaborIdProd() {

		if (laborIdProd == null || laborIdProd.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborIdProd = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborIdProd : lista) {
					selectLaborIdProd[i] = new SelectItem(laborIdProd.getLaborId(), laborIdProd.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborIdProd;
	}

	public void setselectLaborIdProd(SelectItem[] selectLaborIdProd) {

		this.selectLaborIdProd = selectLaborIdProd;
	}

	/***************** RIEGOS *****/

	public SelectItem[] getselectNivel2Riego() {

		if (nivel2Riego == null || nivel2Riego.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Riego = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Riego : lista) {
					selectNivel2Riego[i] = new SelectItem(nivel2Riego.getNivel2Id(), nivel2Riego.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Riego;
	}

	public void setselectNivel2Riego(SelectItem[] selectNivel2Riego) {
		this.selectNivel2Riego = selectNivel2Riego;
	}

	public SelectItem[] getselectNivel3Riego() {

		nivel3Riego = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2IdRiego != null && txtNivel2IdRiego.getValue() != null
				&& !txtNivel2IdRiego.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdRiego.getValue().toString());

			try {
				Nivel2 nivel2Riego = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3Riego = nivel2Riego.getNivel3s().toArray();

				selectNivel3Riego = new SelectItem[niveles3Riego.length];

				int i = 0;
				for (Object object : niveles3Riego) {
					Nivel3 nivel3Riego = (Nivel3) object;
					selectNivel3Riego[i] = new SelectItem(nivel3Riego.getNivel3Id(), nivel3Riego.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3Riego;
	}

	public void setselectNivel3Riego(SelectItem[] selectNivel3Riego) {
		this.selectNivel3Riego = selectNivel3Riego;
	}

	public SelectItem[] getselectNivel4Riego() {
		nivel4Riego = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3IdRiego != null && txtNivel3IdRiego.getValue() != null
				&& !txtNivel3IdRiego.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3IdRiego.getValue().toString());

			try {
				Nivel3 nivel3Riego = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4Riego = nivel3Riego.getNivel4s().toArray();

				selectNivel4Riego = new SelectItem[niveles4Riego.length];

				int i = 0;
				for (Object object : niveles4Riego) {
					Nivel4 nivel4Riego = (Nivel4) object;
					selectNivel4Riego[i] = new SelectItem(nivel4Riego.getNivel4Id(),
							nivel4Riego.getNombre() + '-' + "Área: " + nivel4Riego.getAreaNeta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4Riego;
	}

	public void setselectNivel4Riego(SelectItem[] selectNivel4Riego) {
		this.selectNivel4Riego = selectNivel4Riego;
	}

	@SuppressWarnings("unlikely-arg-type")
	public SelectItem[] getselectNivel4ErpRiego() throws NumberFormatException, Exception {

		if (bloquesRiego != null && !bloquesRiego.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3Riego != null && selectedNivel3Riego.size() > 0) {
				bloquesSeleccionadas = selectedNivel3Riego.get(0);
				for (int i = 1; i < selectedNivel3Riego.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3Riego.get(i);
				}
			}
			try {

				nivel4ErpRiego = businessDelegator2View.listaCodigosErp(bloquesSeleccionadas);
				selectNivel4ErpRiego = new SelectItem[nivel4ErpRiego.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : nivel4ErpRiego) {
					selectNivel4ErpRiego[i] = new SelectItem(nivel4.getCodigoErp(), nivel4.getCodigoErp());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ErpRiego;
	}

	public void setselectNivel4ErpRiego(SelectItem[] selectNivel4ErpRiego) {
		this.selectNivel4ErpRiego = selectNivel4ErpRiego;
	}

	public SelectItem[] getselectLaborIdRiego() {

		if (laborIdRiego == null || laborIdRiego.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborIdRiego = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborIdRiego : lista) {
					selectLaborIdRiego[i] = new SelectItem(laborIdRiego.getLaborId(), laborIdRiego.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborIdRiego;
	}

	public void setselectLaborIdRiego(SelectItem[] selectLaborIdRiego) {

		this.selectLaborIdRiego = selectLaborIdRiego;
	}

	public InputText getTxtNombreNivel4() {
		return txtNombreNivel4;
	}

	public void setTxtNombreNivel4(InputText txtNombreNivel4) {
		this.txtNombreNivel4 = txtNombreNivel4;
	}

	public InputText getTxtNombreNivel2() {
		return txtNombreNivel2;
	}

	public void setTxtNombreNivel2(InputText txtNombreNivel2) {
		this.txtNombreNivel2 = txtNombreNivel2;
	}

	public InputText getTxtNombreLabor() {
		return txtNombreLabor;
	}

	public void setTxtNombreLabor(InputText txtNombreLabor) {
		this.txtNombreLabor = txtNombreLabor;
	}

	public SelectOneMenu getTxtOrdenTrabajoMaq() {
		return txtOrdenTrabajoMaq;
	}

	public void setTxtOrdenTrabajoMaq(SelectOneMenu txtOrdenTrabajoMaq) {
		this.txtOrdenTrabajoMaq = txtOrdenTrabajoMaq;
	}

	public SelectOneMenu getTxtNivel2IdMaq() {
		return txtNivel2IdMaq;
	}

	public void setTxtNivel2IdMaq(SelectOneMenu txtNivel2IdMaq) {
		this.txtNivel2IdMaq = txtNivel2IdMaq;
	}

	public SelectOneMenu getTxtNivel3IdMaq() {
		return txtNivel3IdMaq;
	}

	public void setTxtNivel3IdMaq(SelectOneMenu txtNivel3IdMaq) {
		this.txtNivel3IdMaq = txtNivel3IdMaq;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4Maq() {
		return txtNivel4Id_Nivel4Maq;
	}

	public void setTxtNivel4Id_Nivel4Maq(SelectOneMenu txtNivel4Id_Nivel4Maq) {
		this.txtNivel4Id_Nivel4Maq = txtNivel4Id_Nivel4Maq;
	}

	public SelectOneMenu getTxtLaborId_LaborMaq() {
		return txtLaborId_LaborMaq;
	}

	public void setTxtLaborId_LaborMaq(SelectOneMenu txtLaborId_LaborMaq) {
		this.txtLaborId_LaborMaq = txtLaborId_LaborMaq;
	}

	public InputText getTxtNombreNivel2Maq() {
		return txtNombreNivel2Maq;
	}

	public void setTxtNombreNivel2Maq(InputText txtNombreNivel2Maq) {
		this.txtNombreNivel2Maq = txtNombreNivel2Maq;
	}

	public InputText getTxtNombreNivel4Maq() {
		return txtNombreNivel4Maq;
	}

	public void setTxtNombreNivel4Maq(InputText txtNombreNivel4Maq) {
		this.txtNombreNivel4Maq = txtNombreNivel4Maq;
	}

	public InputText getTxtNombreLaborMaq() {
		return txtNombreLaborMaq;
	}

	public void setTxtNombreLaborMaq(InputText txtNombreLaborMaq) {
		this.txtNombreLaborMaq = txtNombreLaborMaq;
	}

	public SelectOneMenu getTxtOrdenTrabajoProd() {
		return txtOrdenTrabajoProd;
	}

	public void setTxtOrdenTrabajoProd(SelectOneMenu txtOrdenTrabajoProd) {
		this.txtOrdenTrabajoProd = txtOrdenTrabajoProd;
	}

	public SelectOneMenu getTxtNivel2IdProd() {
		return txtNivel2IdProd;
	}

	public void setTxtNivel2IdProd(SelectOneMenu txtNivel2IdProd) {
		this.txtNivel2IdProd = txtNivel2IdProd;
	}

	public SelectOneMenu getTxtNivel3IdProd() {
		return txtNivel3IdProd;
	}

	public void setTxtNivel3IdProd(SelectOneMenu txtNivel3IdProd) {
		this.txtNivel3IdProd = txtNivel3IdProd;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4Prod() {
		return txtNivel4Id_Nivel4Prod;
	}

	public void setTxtNivel4Id_Nivel4Prod(SelectOneMenu txtNivel4Id_Nivel4Prod) {
		this.txtNivel4Id_Nivel4Prod = txtNivel4Id_Nivel4Prod;
	}

	public SelectOneMenu getTxtLaborId_LaborProd() {
		return txtLaborId_LaborProd;
	}

	public void setTxtLaborId_LaborProd(SelectOneMenu txtLaborId_LaborProd) {
		this.txtLaborId_LaborProd = txtLaborId_LaborProd;
	}

	public InputText getTxtNombreNivel2Prod() {
		return txtNombreNivel2Prod;
	}

	public void setTxtNombreNivel2Prod(InputText txtNombreNivel2Prod) {
		this.txtNombreNivel2Prod = txtNombreNivel2Prod;
	}

	public InputText getTxtNombreNivel4Prod() {
		return txtNombreNivel4Prod;
	}

	public void setTxtNombreNivel4Prod(InputText txtNombreNivel4Prod) {
		this.txtNombreNivel4Prod = txtNombreNivel4Prod;
	}

	public InputText getTxtNombreLaborProd() {
		return txtNombreLaborProd;
	}

	public void setTxtNombreLaborProd(InputText txtNombreLaborProd) {
		this.txtNombreLaborProd = txtNombreLaborProd;
	}

	public InputText getTxtNombreAlmacenProd() {
		return txtNombreAlmacenProd;
	}

	public void setTxtNombreAlmacenProd(InputText txtNombreAlmacenProd) {
		this.txtNombreAlmacenProd = txtNombreAlmacenProd;
	}

	public SelectOneMenu getTxtOrdenTrabajoRiego() {
		return txtOrdenTrabajoRiego;
	}

	public void setTxtOrdenTrabajoRiego(SelectOneMenu txtOrdenTrabajoRiego) {
		this.txtOrdenTrabajoRiego = txtOrdenTrabajoRiego;
	}

	public SelectOneMenu getTxtNivel2IdRiego() {
		return txtNivel2IdRiego;
	}

	public void setTxtNivel2IdRiego(SelectOneMenu txtNivel2IdRiego) {
		this.txtNivel2IdRiego = txtNivel2IdRiego;
	}

	public SelectOneMenu getTxtNivel3IdRiego() {
		return txtNivel3IdRiego;
	}

	public void setTxtNivel3IdRiego(SelectOneMenu txtNivel3IdRiego) {
		this.txtNivel3IdRiego = txtNivel3IdRiego;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4Riego() {
		return txtNivel4Id_Nivel4Riego;
	}

	public void setTxtNivel4Id_Nivel4Riego(SelectOneMenu txtNivel4Id_Nivel4Riego) {
		this.txtNivel4Id_Nivel4Riego = txtNivel4Id_Nivel4Riego;
	}

	public SelectOneMenu getTxtLaborId_LaborRiego() {
		return txtLaborId_LaborRiego;
	}

	public void setTxtLaborId_LaborRiego(SelectOneMenu txtLaborId_LaborRiego) {
		this.txtLaborId_LaborRiego = txtLaborId_LaborRiego;
	}

	public InputText getTxtNombreNivel2Riego() {
		return txtNombreNivel2Riego;
	}

	public void setTxtNombreNivel2Riego(InputText txtNombreNivel2Riego) {
		this.txtNombreNivel2Riego = txtNombreNivel2Riego;
	}

	public InputText getTxtNombreNivel4Riego() {
		return txtNombreNivel4Riego;
	}

	public void setTxtNombreNivel4Riego(InputText txtNombreNivel4Riego) {
		this.txtNombreNivel4Riego = txtNombreNivel4Riego;
	}

	public InputText getTxtNombreLaborRiego() {
		return txtNombreLaborRiego;
	}

	public void setTxtNombreLaborRiego(InputText txtNombreLaborRiego) {
		this.txtNombreLaborRiego = txtNombreLaborRiego;
	}

	public InputText getTxtNombreInfraestructura() {
		return txtNombreInfraestructura;
	}

	public void setTxtNombreInfraestructura(InputText txtNombreInfraestructura) {
		this.txtNombreInfraestructura = txtNombreInfraestructura;
	}

	public InputText getTxtCodigoSupervisorRiego() {
		return txtCodigoSupervisorRiego;
	}

	public void setTxtCodigoSupervisorRiego(InputText txtCodigoSupervisorRiego) {
		this.txtCodigoSupervisorRiego = txtCodigoSupervisorRiego;
	}

	public InputText getTxtNombreSistemaRiego() {
		return txtNombreSistemaRiego;
	}

	public void setTxtNombreSistemaRiego(InputText txtNombreSistemaRiego) {
		this.txtNombreSistemaRiego = txtNombreSistemaRiego;
	}

	public InputText getTxtCodigoTurnoCampo() {
		return txtCodigoTurnoCampo;
	}

	public void setTxtCodigoTurnoCampo(InputText txtCodigoTurnoCampo) {
		this.txtCodigoTurnoCampo = txtCodigoTurnoCampo;
	}

	public CommandButton getBtnAgregarRiego() {
		return btnAgregarRiego;
	}

	public void setBtnAgregarRiego(CommandButton btnAgregarRiego) {
		this.btnAgregarRiego = btnAgregarRiego;
	}

	public List<DatRiegoDTO> getDataRiegos() {
		return dataRiegos;
	}

	public void setDataRiegos(List<DatRiegoDTO> dataRiegos) {
		this.dataRiegos = dataRiegos;
	}

	/**
	 * @return the txtHorasTrabajadas
	 */
	public Spinner getTxtHorasTrabajadas() {
		return txtHorasTrabajadas;
	}

	/**
	 * @param txtHorasTrabajadas the txtHorasTrabajadas to set
	 */
	public void setTxtHorasTrabajadas(Spinner txtHorasTrabajadas) {
		this.txtHorasTrabajadas = txtHorasTrabajadas;
	}

	public SelectItem[] getSelectOrdenTrabajo() {

		if (ordenTrabajo == null || ordenTrabajo.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				// Criteria
				Compania compania = businessDelegatorView.getCompania(idCompania);
				// Criteria
				List<ConsultaOrdenTrabajoDesDTO> listaOrdenenTrabajo = null;
				if (compania.getNivelAutorizaLabor() != null) {
					if (compania.getNivelAutorizaLabor().equals("SI")) {
						listaOrdenenTrabajo = businessDelegatorView.consultarOrdenTrabajoDesAprobacion(idCompania);
					} else {
						listaOrdenenTrabajo = businessDelegatorView.consultarOrdenTrabajoDes(idCompania);
					}
				}
				if (listaOrdenenTrabajo != null) {
					selectOrdenTrabajo = new SelectItem[listaOrdenenTrabajo.size()];

					int i = 0;
					for (ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoDesDTO : listaOrdenenTrabajo) {
						selectOrdenTrabajo[i] = new SelectItem(consultaOrdenTrabajoDesDTO.getPlanLaborId(),
								consultaOrdenTrabajoDesDTO.getDescripcion()

						);
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectOrdenTrabajo;
	}

	public void setSelectOrdenTrabajo(SelectItem[] selectOrdenTrabajo) {
		this.selectOrdenTrabajo = selectOrdenTrabajo;
	}

	public SelectItem[] getSelectOrdenTrabajoMaq() {

		if (ordenTrabajoMaq == null || ordenTrabajoMaq.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				// Criteria
				Compania compania = businessDelegatorView.getCompania(idCompania);
				// Criteria
				List<ConsultaOrdenTrabajoDesDTO> listaOrdenenTrabajoMaq = null;
				if (compania.getNivelAutorizaLabor() != null) {
					if (compania.getNivelAutorizaLabor().equals("SI")) {
						listaOrdenenTrabajoMaq = businessDelegatorView.consultarOrdenTrabajoDesAprobacion(idCompania);
					} else {
						listaOrdenenTrabajoMaq = businessDelegatorView.consultarOrdenTrabajoDes(idCompania);
					}
				}
				if (listaOrdenenTrabajoMaq != null) {
					selectOrdenTrabajoMaq = new SelectItem[listaOrdenenTrabajoMaq.size()];

					int i = 0;
					for (ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoMaqDesDTO : listaOrdenenTrabajoMaq) {
						selectOrdenTrabajoMaq[i] = new SelectItem(consultaOrdenTrabajoMaqDesDTO.getPlanLaborId(),
								consultaOrdenTrabajoMaqDesDTO.getDescripcion()

						);
						i++;
					}
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectOrdenTrabajoMaq;
	}

	public void setSelectOrdenTrabajoMaq(SelectItem[] selectOrdenTrabajoMaq) {
		this.selectOrdenTrabajoMaq = selectOrdenTrabajoMaq;
	}

	public SelectItem[] getSelectOrdenTrabajoProd() {

		if (ordenTrabajoProd == null || ordenTrabajoProd.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				// Criteria
				Compania compania = businessDelegatorView.getCompania(idCompania);
				// Criteria
				List<ConsultaOrdenTrabajoDesDTO> listaOrdenenTrabajoProd = null;
				if (compania.getNivelAutorizaLabor() != null) {
					if (compania.getNivelAutorizaLabor().equals("SI")) {
						listaOrdenenTrabajoProd = businessDelegatorView.consultarOrdenTrabajoDesAprobacion(idCompania);
					} else {
						listaOrdenenTrabajoProd = businessDelegatorView.consultarOrdenTrabajoDes(idCompania);
					}
				}
				if (listaOrdenenTrabajoProd != null) {
					selectOrdenTrabajoProd = new SelectItem[listaOrdenenTrabajoProd.size()];

					int i = 0;
					for (ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoProdDesDTO : listaOrdenenTrabajoProd) {
						selectOrdenTrabajoProd[i] = new SelectItem(consultaOrdenTrabajoProdDesDTO.getPlanLaborId(),
								consultaOrdenTrabajoProdDesDTO.getDescripcion()

						);
						i++;

					}
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectOrdenTrabajoProd;
	}

	public void setSelectOrdenTrabajoProd(SelectItem[] selectOrdenTrabajoProd) {
		this.selectOrdenTrabajoProd = selectOrdenTrabajoProd;
	}

	public SelectItem[] getSelectOrdenTrabajoRiego() {

		if (ordenTrabajoRiego == null || ordenTrabajoRiego.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				// Criteria
				Compania compania = businessDelegatorView.getCompania(idCompania);
				// Criteria
				List<ConsultaOrdenTrabajoDesDTO> listaOrdenenTrabajoRiego = null;
				if (compania.getNivelAutorizaLabor() != null) {
					if (compania.getNivelAutorizaLabor().equals("SI")) {
						listaOrdenenTrabajoRiego = businessDelegatorView.consultarOrdenTrabajoDesAprobacion(idCompania);
					} else {
						listaOrdenenTrabajoRiego = businessDelegatorView.consultarOrdenTrabajoDes(idCompania);
					}
				}

				if (listaOrdenenTrabajoRiego != null) {
					selectOrdenTrabajoRiego = new SelectItem[listaOrdenenTrabajoRiego.size()];

					int i = 0;
					for (ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoRiegoDesDTO : listaOrdenenTrabajoRiego) {
						selectOrdenTrabajoRiego[i] = new SelectItem(consultaOrdenTrabajoRiegoDesDTO.getPlanLaborId(),
								consultaOrdenTrabajoRiegoDesDTO.getDescripcion()

						);
						i++;
					}
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectOrdenTrabajoRiego;
	}

	public void setSelectOrdenTrabajoRiego(SelectItem[] selectOrdenTrabajoRiego) {
		this.selectOrdenTrabajoRiego = selectOrdenTrabajoRiego;
	}

	public void limpiarPantalla() {
		// txtValorUnitario.setValue(null);
		txtCantidadPago.setValue(null);
		txtTrabId_Trabajador.setValue(null);
		txtNivel4Id_Nivel4.setValue(null);

		// txtModoAlce.setValue(null);
		// txtModalidadCosId_ModalidadCosecha.setValue(null);
		// txtCeptoNominaId_ConceptoNomina.setValue(null);
		txtUdadMedPago.setValue(null);
		txtLaborId_Labor.setValue(null);
		txtNivel2Id.setValue(null);
		// txtClienteId.setValue(null);

	}

	public void listarPlanillaNomina() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			String origen = "MAQUINARIA";
			String estadoPlanilla = (FacesUtils.checkString(txtEstadoPlanilla));

			Long numeroPlanilla = FacesUtils.checkLong(txtPlanilla);
			if (numeroPlanilla == null) {
				numeroPlanilla = 0L;
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.consultarListaPlanillaNomina(compania, fechaInicial, fechaFinal,
						numeroPlanilla, origen, estadoPlanilla);

			} else if (compania != null && fechaInicial == null && fechaFinal == null && numeroPlanilla != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data2 = businessDelegator2View.consultarListaPlanillaNomina(compania, fechaInicial, fechaFinal,
						numeroPlanilla, origen, estadoPlanilla);

			}

			double totalRegistros = 0;
			double totalUnidades = 0;
			double totalCosto = 0;
			if (data2 != null && data2.size() >= 0) {
				for (ListaPlanillaNominaDTO data1 : data2) {
					totalRegistros += data1.getNregistrosPlanilla().doubleValue();
					// totalUnidades += data1.getUnidades().doubleValue();
					totalCosto += data1.getCostoTotalPlanilla().doubleValue();
				}
			}

			txtValorTotalAcumulado.setValue(totalCosto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SelectOneMenu getTxtEstadoPlanilla() {
		return txtEstadoPlanilla;
	}

	public void setTxtEstadoPlanilla(SelectOneMenu txtEstadoPlanilla) {
		this.txtEstadoPlanilla = txtEstadoPlanilla;
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

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public InputNumber getTxtTotalRegistros() {
		return txtTotalRegistros;
	}

	public void setTxtTotalRegistros(InputNumber txtTotalRegistros) {
		this.txtTotalRegistros = txtTotalRegistros;
	}

	public InputNumber getTxtTotalUnidades() {
		return txtTotalUnidades;
	}

	public void setTxtTotalUnidades(InputNumber txtTotalUnidades) {
		this.txtTotalUnidades = txtTotalUnidades;
	}

	public InputText getTxtPlanilla() {
		return txtPlanilla;
	}

	public void setTxtPlanilla(InputText txtPlanilla) {
		this.txtPlanilla = txtPlanilla;
	}

	public String exportPlanillasNomina() throws NumberFormatException, Exception {

		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaIni));
		fechaFinal = (FacesUtils.checkDate(txtFechaFin));
		String origen = "MAQUINARIA";
		String estadoPlanilla = (FacesUtils.checkString(txtEstadoPlanilla));

		Long numeroPlanilla = FacesUtils.checkLong(txtPlanilla);
		if (numeroPlanilla == null) {
			numeroPlanilla = 0L;
		}

		Long compania = new Long(getCompaniaIdSession());

		if (compania != null) {
			try {

				List<ListaPlanillaNominaDetalladoDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "NominaDetalladoCampo.xlsx";

				data = businessDelegator2View.reporteLaboresManualesDetalladoRD(compania, fechaInicial, fechaFinal,
						numeroPlanilla, origen, estadoPlanilla);
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(0);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);

					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.TAN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					Font font = book.createFont();
					font.setColor(IndexedColors.WHITE.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");
					style2.setFont(font);

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					dollarStyle.setDataFormat(df.getFormat("$#,#0.000"));

					if (data != null) {

						cell = row.createCell(0);
						cell.setCellValue("Fecha registro");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("Ficha");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("Cedula");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("Trabajador");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("Nomempresa");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("Cod lote");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("Nom lote");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("Cod hacienda");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("Nom hacienda");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("Cod labor");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("Nom labor");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("Cod concepto nomina");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("Nom concepto nomina");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("Cantidad pago");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("Valor unitario");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("Costo total");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("N planilla");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("Origen datos");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("Numero tiquete");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("Nom cliente");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("Cod vagon");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("Tipo corte");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("Modo alce");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("Nro comprobante");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("Peso molienda kg");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("Vagon adicional");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("Fecha carga");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("Fecha descarga");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("Planilla nomina id");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("Estado");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("Estado planilla");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("Fecha cierre planilla");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("Fecha re abertura planilla");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("Usuario cierre planilla");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("Id compania");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("Nom compania");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("Fecha anulacion");
						cell.setCellStyle(style2);
						cell = row.createCell(37);
						cell.setCellValue("Fecha creacion");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("Fecha modificacion");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("Unidad Medida");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("Periodo inicial");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("Periodo final");
						cell.setCellStyle(style2);

						int pos_i = 1;

						for (ListaPlanillaNominaDetalladoDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getFecha_registro().toString().substring(8, 10) + "/"
									+ ndDTO.getFecha_registro().toString().substring(5, 7) + "/"
									+ ndDTO.getFecha_registro().toString().substring(0, 4));

							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getFicha());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCedula());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getTrabajador());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getNomempresa());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getCod_lote());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNom_lote());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCod_hacienda());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getNom_hacienda());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getCod_labor());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getNom_labor());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getCantidad_pago().doubleValue());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getValor_unitario().doubleValue());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getCosto_total().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getN_planilla().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getOrigen_datos());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNumero_tiquete().doubleValue());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getNom_cliente());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCod_vagon());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getTipo_corte());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getModo_alce());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getNro_comprobante().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getPeso_molienda_kg().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getVagon_adicional());
							cell = row.createCell(26);
							if (!ndDTO.getFecha_carga().equals("")) {
								cell.setCellValue(ndDTO.getFecha_carga().toString().substring(8, 10) + "/"
										+ ndDTO.getFecha_carga().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_carga().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_carga());
							}

							cell = row.createCell(27);
							if (!ndDTO.getFecha_descarga().equals("")) {
								cell.setCellValue(ndDTO.getFecha_descarga().toString().substring(8, 10) + "/"
										+ ndDTO.getFecha_descarga().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_descarga().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_descarga());
							}
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getPlanilla_nomina_id().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getEstado());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getEstado_planilla());
							cell = row.createCell(31);
							if (!ndDTO.getFecha_cierre_planilla().equals("")) {
								cell.setCellValue(ndDTO.getFecha_cierre_planilla().toString().substring(8, 10) + "/"
										+ ndDTO.getFecha_cierre_planilla().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_cierre_planilla().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_cierre_planilla());
							}
							cell = row.createCell(32);

							if (!ndDTO.getFecha_re_abertura_planilla().equals("")) {
								cell.setCellValue(ndDTO.getFecha_re_abertura_planilla().toString().substring(8, 10)
										+ "/" + ndDTO.getFecha_re_abertura_planilla().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_re_abertura_planilla().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_re_abertura_planilla());
							}
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getUsuario_cierre_planilla());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getId_compania().longValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getNom_compania());
							cell = row.createCell(36);
							if (!ndDTO.getFecha_anulacion().equals("")) {
								cell.setCellValue(ndDTO.getFecha_anulacion().toString().substring(8, 10) + "/"
										+ ndDTO.getFecha_anulacion().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_anulacion().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_anulacion());
							}
							cell = row.createCell(37);
							if (!ndDTO.getFecha_creacion().equals("")) {
								cell.setCellValue(ndDTO.getFecha_creacion().toString().substring(8, 10) + "/"
										+ ndDTO.getFecha_creacion().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_creacion().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_creacion());
							}
							cell = row.createCell(38);
							if (!ndDTO.getFecha_modificacion().equals("")) {
								cell.setCellValue(ndDTO.getFecha_modificacion().toString().substring(8, 10) + "/"
										+ ndDTO.getFecha_modificacion().toString().substring(5, 7) + "/"
										+ ndDTO.getFecha_modificacion().toString().substring(0, 4));
							} else {
								cell.setCellValue(ndDTO.getFecha_modificacion());
							}

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(40);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);
							cell.setCellStyle(style);

							cell = row.createCell(41);
							cell.setCellValue(fechaF);
							cell.setCellStyle(style);

							pos_i++;

						}

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						file = new DefaultStreamedContent(stream, "application/xlsx", "NominaDetalladoCampo.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"El informe se ha generado con exito, ahora puedes Descargar el informe"));

					} else {

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
								"No existe informacion asociada a los criterios de busqueda seleccionados "));
					}

				} catch (Exception e) {

					e.printStackTrace();

					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		visible = "visible";
		disableButton = "false";
		return "";
	}

	public StreamedContent getFile() {

		return file;
	}

	public void setFile(StreamedContent file) {

		if (file != null) {
			this.file = file;
		}
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public List<ListaPlanillaNominaDTO> getData2() {
		return data2;
	}

	public void setData2(List<ListaPlanillaNominaDTO> data2) {
		this.data2 = data2;
	}

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public void action_liquidar(ActionEvent evt) throws Exception {

		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		setShowDialog(true);
		Date date = new Date();
		Long usuarioId = new Long(getUsuarioIdSession());
		Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
		DatPlanillaNomina entityPlanialla = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);

		entityPlanialla.setEstadoPlanilla("LIQUIDADA");
		entityPlanialla.setFechaCierrePlanilla(date);
		entityPlanialla.setUsuarioCierrePlanilla(usuarioId);

		String consecutivoPlanilla = selectedDatPlanillaNominaLista.getConsecutivo().toString();
		dataPlanillaDet = null;
		dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNominaId);

		businessDelegatorView.updateDatPlanillaNomina(entityPlanialla, dataPlanillaDet, null, null, null, null);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"La planilla No. " + consecutivoPlanilla, "se ha liquidado satisfactoriamente."));
		listarPlanillaNomina();

	}

	public void liquidarPlanillasRangoFechas() throws Exception {

		setShowDialog(true);
		Date date = new Date();
		Long usuarioId = new Long(getUsuarioIdSession());
		Long companiaId = new Long(getCompaniaIdSession());
		Date fechaInicial = FacesUtils.checkDate(txtFechaIni);
		Date fechaFinal = FacesUtils.checkDate(txtFechaFin);
		if (fechaInicial != null && fechaFinal != null) {
			businessDelegator2View.pr_liquidar_planilla_nomina_periodo(companiaId, fechaInicial, fechaFinal, usuarioId);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se han liquidado las planillas satisfactoriamente.", ""));
			listarPlanillaNomina();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Para poder liquidar las planillas debe especificar un rango de fechas.", ""));
		}

	}

	public void action_ReAbrirliquidacion(ActionEvent evt) throws Exception {

		selectedDatPlanillaNominaLista = (ListaPlanillaNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanillaNominaLista"));

		setShowDialog(true);
		Date date = new Date();
		Long usuarioId = new Long(getUsuarioIdSession());
		Long planillaNominaId = selectedDatPlanillaNominaLista.getPlanillaNominaId();
		DatPlanillaNomina entityPlanialla = businessDelegatorView.getDatPlanillaNomina(planillaNominaId);

		entityPlanialla.setEstadoPlanilla("ABIERTA");
		entityPlanialla.setFechaReAberturaPlanilla(date);
		entityPlanialla.setUsuarioCierrePlanilla(usuarioId);

		String consecutivoPlanilla = selectedDatPlanillaNominaLista.getConsecutivo().toString();
		dataPlanillaDet = null;
		dataPlanillaDet = businessDelegatorView.getDataDatPlanillaNominaDetByNomina(planillaNominaId);

		businessDelegatorView.updateDatPlanillaNomina(entityPlanialla, dataPlanillaDet, null, null, null, null);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"La planilla No. " + consecutivoPlanilla, "se ha re-abierto satisfactoriamente."));
		listarPlanillaNomina();

	}

	public void reAbrirPlanillasRangoFechas() throws Exception {
		setShowDialog(true);
		Long usuarioId = new Long(getUsuarioIdSession());
		Long companiaId = new Long(getCompaniaIdSession());
		Date fechaInicial = FacesUtils.checkDate(txtFechaIni);
		Date fechaFinal = FacesUtils.checkDate(txtFechaFin);

		if (fechaInicial != null && fechaFinal != null) {
			businessDelegator2View.pr_re_liquidar_planilla_nomina_periodo(companiaId, fechaInicial, fechaFinal,
					usuarioId);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se han liquidado las planillas satisfactoriamente.", ""));
			listarPlanillaNomina();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Para poder re-abrir las planillas debe especificar un rango de fechas.", ""));
		}

	}

	public SelectOneMenu getTxtTipoDistribucion() {
		return txtTipoDistribucion;
	}

	public void setTxtTipoDistribucion(SelectOneMenu txtTipoDistribucion) {
		this.txtTipoDistribucion = txtTipoDistribucion;
	}

	public SelectOneMenu getTxtNivel4Erp() {
		return txtNivel4Erp;
	}

	public void setTxtNivel4Erp(SelectOneMenu txtNivel4Erp) {
		this.txtNivel4Erp = txtNivel4Erp;
	}

	public SelectOneMenu getTxtNivel4ErpMaq() {
		return txtNivel4ErpMaq;
	}

	public void setTxtNivel4ErpMaq(SelectOneMenu txtNivel4ErpMaq) {
		this.txtNivel4ErpMaq = txtNivel4ErpMaq;
	}

	public SelectOneMenu getTxtTipoDistribucionMaq() {
		return txtTipoDistribucionMaq;
	}

	public void setTxtTipoDistribucionMaq(SelectOneMenu txtTipoDistribucionMaq) {
		this.txtTipoDistribucionMaq = txtTipoDistribucionMaq;
	}

	public SelectOneMenu getTxtNivel4ErpProd() {
		return txtNivel4ErpProd;
	}

	public void setTxtNivel4ErpProd(SelectOneMenu txtNivel4ErpProd) {
		this.txtNivel4ErpProd = txtNivel4ErpProd;
	}

	public List<ListaNivel4DTO> getNivel4ErpProd() {
		return nivel4ErpProd;
	}

	public void setNivel4ErpProd(List<ListaNivel4DTO> nivel4ErpProd) {
		this.nivel4ErpProd = nivel4ErpProd;
	}

	public SelectOneMenu getTxtTipoDistribucionProd() {
		return txtTipoDistribucionProd;
	}

	public void setTxtTipoDistribucionProd(SelectOneMenu txtTipoDistribucionProd) {
		this.txtTipoDistribucionProd = txtTipoDistribucionProd;
	}

	public SelectOneMenu getTxtNivel4ErpRiego() {
		return txtNivel4ErpRiego;
	}

	public void setTxtNivel4ErpRiego(SelectOneMenu txtNivel4ErpRiego) {
		this.txtNivel4ErpRiego = txtNivel4ErpRiego;
	}

	public List<ListaNivel4DTO> getNivel4ErpRiego() {
		return nivel4ErpRiego;
	}

	public void setNivel4ErpRiego(List<ListaNivel4DTO> nivel4ErpRiego) {
		this.nivel4ErpRiego = nivel4ErpRiego;
	}

	public SelectOneMenu getTxtTipoDistribucionRiego() {
		return txtTipoDistribucionRiego;
	}

	public void setTxtTipoDistribucionRiego(SelectOneMenu txtTipoDistribucionRiego) {
		this.txtTipoDistribucionRiego = txtTipoDistribucionRiego;
	}

	public ListaPlanillaNominaDTO getSelectedDatPlanillaNominaLista() {
		return selectedDatPlanillaNominaLista;
	}

	public void setSelectedDatPlanillaNominaLista(ListaPlanillaNominaDTO selectedDatPlanillaNominaLista) {
		this.selectedDatPlanillaNominaLista = selectedDatPlanillaNominaLista;
	}

	public List<ListaPlanillaNominaDTO> getSelectedDatPlanillaNominaListaMultiple() {
		return selectedDatPlanillaNominaListaMultiple;
	}

	public void setSelectedDatPlanillaNominaListaMultiple(
			List<ListaPlanillaNominaDTO> selectedDatPlanillaNominaListaMultiple) {
		this.selectedDatPlanillaNominaListaMultiple = selectedDatPlanillaNominaListaMultiple;
	}

	public List<String> getSelectedNivel4ManoObra() {
		return selectedNivel4ManoObra;
	}

	public void setSelectedNivel4ManoObra(List<String> selectedNivel4ManoObra) {
		this.selectedNivel4ManoObra = selectedNivel4ManoObra;
	}

	@SuppressWarnings("unlikely-arg-type")
	public List<ListaNivel4DTO> getLotesManoObra() {

		if (txtNivel2Id != null && txtNivel2Id.getValue()!=null) {
			String nivel2Id = FacesUtils.checkString(txtNivel2Id);
			

			try {
				// Object[] condicion = { "estado", true, "A", "=", "nivel3.nivel3Id", true,
				// nivel3Id, "=" };
				Long compania = new Long(getCompaniaIdSession());
				lotesManoObra = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return lotesManoObra;
	}

	public void setLotesManoObra(List<ListaNivel4DTO> lotesManoObra) {
		this.lotesManoObra = lotesManoObra;
	}

	public List<NominaDetalladaDTO> getDataDetalle() {
		return dataDetalle;
	}

	public void setDataDetalle(List<NominaDetalladaDTO> dataDetalle) {
		this.dataDetalle = dataDetalle;
	}

	public InputNumber getTxtCantidadAcumulado() {
		return txtCantidadAcumulado;
	}

	public void setTxtCantidadAcumulado(InputNumber txtCantidadAcumulado) {
		this.txtCantidadAcumulado = txtCantidadAcumulado;
	}

	public List<String> getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(List<String> selectedTrabajador) {
		this.selectedTrabajador = selectedTrabajador;
	}

	public List<Trabajador> getTrabajadores() {

		if (trabajadores == null || trabajadores.size() == 0) {

			try {
				trabajadores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public DatPlanillaNominaDet getEntityDatPlanillaNominaDet() {
		return entityDatPlanillaNominaDet;
	}

	public void setEntityDatPlanillaNominaDet(DatPlanillaNominaDet entityDatPlanillaNominaDet) {
		this.entityDatPlanillaNominaDet = entityDatPlanillaNominaDet;
	}

	/***************** Sesion de consultas a los bloques multiples ****/

	public List<Nivel3> getBloquesManoObra() {
		Long nivel2Id = null;

		if (txtNivel2Id.getValue() != null && !txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Object[] condicion = { "estado", true, "A", "=", "nivel2.nivel2Id", true, nivel2Id, "=" };
				bloquesManoObra = businessDelegatorView.findByCriteriaInNivel3(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return bloquesManoObra;
	}

	public List<Nivel3> getBloquesMaq() {
		Long nivel2Id = null;

		if (txtNivel2IdMaq.getValue() != null && !txtNivel2IdMaq.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdMaq.getValue().toString());

			try {
				Object[] condicion = { "estado", true, "A", "=", "nivel2.nivel2Id", true, nivel2Id, "=" };
				bloquesMaq = businessDelegatorView.findByCriteriaInNivel3(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return bloquesMaq;
	}

	public List<Nivel3> getBloquesProd() {

		Long nivel2Id = null;

		if (txtNivel2IdProd.getValue() != null && !txtNivel2IdProd.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdProd.getValue().toString());

			try {
				Object[] condicion = { "estado", true, "A", "=", "nivel2.nivel2Id", true, nivel2Id, "=" };
				bloquesProd = businessDelegatorView.findByCriteriaInNivel3(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return bloquesProd;
	}

	public List<Nivel3> getBloquesRiego() {

		Long nivel2Id = null;

		if (txtNivel2IdRiego.getValue() != null && !txtNivel2IdRiego.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2IdRiego.getValue().toString());

			try {
				Object[] condicion = { "estado", true, "A", "=", "nivel2.nivel2Id", true, nivel2Id, "=" };
				bloquesRiego = businessDelegatorView.findByCriteriaInNivel3(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return bloquesRiego;
	}

	@SuppressWarnings("unlikely-arg-type")
	public List<ListaNivel4DTO> getLotesMaq() {

		if (bloquesMaq != null && !bloquesMaq.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3Maq != null && selectedNivel3Maq.size() > 0) {
				bloquesSeleccionadas = selectedNivel3Maq.get(0);
				for (int i = 1; i < selectedNivel3Maq.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3Maq.get(i);
				}
			}

			try {
				// Object[] condicion = { "estado", true, "A", "=", "nivel3.nivel3Id", true,
				// nivel3Id, "=" };
				lotesMaq = businessDelegator2View.pr_lista_nivel4_filtro_nivel3(bloquesSeleccionadas);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return lotesMaq;
	}

	public List<ListaNivel4DTO> getLotesProd() {
		Long nivel3Id = null;

		if (bloquesProd != null && !bloquesProd.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3Prod != null && selectedNivel3Prod.size() > 0) {
				bloquesSeleccionadas = selectedNivel3Prod.get(0);
				for (int i = 1; i < selectedNivel3Prod.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3Prod.get(i);
				}
			}

			try {
				// Object[] condicion = { "estado", true, "A", "=", "nivel3.nivel3Id", true,
				// nivel3Id, "=" };
				lotesProd = businessDelegator2View.pr_lista_nivel4_filtro_nivel3(bloquesSeleccionadas);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return lotesProd;
	}

	public List<ListaNivel4DTO> getLotesRiego() {

		if (bloquesRiego != null && !bloquesRiego.equals("")) {
			String bloquesSeleccionadas = "";
			if (selectedNivel3Riego != null && selectedNivel3Riego.size() > 0) {
				bloquesSeleccionadas = selectedNivel3Riego.get(0);
				for (int i = 1; i < selectedNivel3Riego.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3Riego.get(i);
				}
			}

			try {
				// Object[] condicion = { "estado", true, "A", "=", "nivel3.nivel3Id", true,
				// nivel3Id, "=" };
				lotesRiego = businessDelegator2View.pr_lista_nivel4_filtro_nivel3(bloquesSeleccionadas);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return lotesRiego;
	}

	public void setBloquesManoObra(List<Nivel3> bloquesManoObra) {
		this.bloquesManoObra = bloquesManoObra;
	}

	public void setBloquesMaq(List<Nivel3> bloquesMaq) {
		this.bloquesMaq = bloquesMaq;
	}

	public void setBloquesProd(List<Nivel3> bloquesProd) {
		this.bloquesProd = bloquesProd;
	}

	public void setBloquesRiego(List<Nivel3> bloquesRiego) {
		this.bloquesRiego = bloquesRiego;
	}

	public void setLotesMaq(List<ListaNivel4DTO> lotesMaq) {

		this.lotesMaq = lotesMaq;
	}

	public void setLotesProd(List<ListaNivel4DTO> lotesProd) {

		this.lotesProd = lotesProd;
	}

	public void setLotesRiego(List<ListaNivel4DTO> lotesRiego) {

		this.lotesRiego = lotesRiego;
	}

	public List<String> getSelectedNivel3ManoObra() {
		return selectedNivel3ManoObra;
	}

	public List<String> getSelectedNivel3Maq() {
		return selectedNivel3Maq;
	}

	public List<String> getSelectedNivel3Prod() {
		return selectedNivel3Prod;
	}

	public List<String> getSelectedNivel3Riego() {
		return selectedNivel3Riego;
	}

	public List<String> getSelectedNivel4Maq() {
		return selectedNivel4Maq;
	}

	public List<String> getSelectedNivel4Prod() {
		return selectedNivel4Prod;
	}

	public List<String> getSelectedNivel4Riego() {
		return selectedNivel4Riego;
	}

	public void setSelectedNivel3ManoObra(List<String> selectedNivel3ManoObra) {
		this.selectedNivel3ManoObra = selectedNivel3ManoObra;
	}

	public void setSelectedNivel3Maq(List<String> selectedNivel3Maq) {
		this.selectedNivel3Maq = selectedNivel3Maq;
	}

	public void setSelectedNivel3Prod(List<String> selectedNivel3Prod) {
		this.selectedNivel3Prod = selectedNivel3Prod;
	}

	public void setSelectedNivel3Riego(List<String> selectedNivel3Riego) {
		this.selectedNivel3Riego = selectedNivel3Riego;
	}

	public void setSelectedNivel4Maq(List<String> selectedNivel4Maq) {
		this.selectedNivel4Maq = selectedNivel4Maq;
	}

	public void setSelectedNivel4Prod(List<String> selectedNivel4Prod) {
		this.selectedNivel4Prod = selectedNivel4Prod;
	}

	public void setSelectedNivel4Riego(List<String> selectedNivel4Riego) {
		this.selectedNivel4Riego = selectedNivel4Riego;
	}

	public void limpiar_pantallaProd() {
		txtProductoId_Producto.setValue(null);txtOrdenTrabajoProd.setValue(null);
	       txtUdadMedIdProducto.setValue(null);txtLaborId_LaborProd.setValue(null);txtNivel4ErpProd.setValue(null);
	       txtCantidadAplicada.setValue(null);txtValorUnitInsumos.setValue(null);
	    	txtNivel2IdProd.setValue(null); txtTipoDistribucionProd.setValue(null);
			txtAlmacenId_Almacen.setValue(null);
	}

	public void limpiar_pantallaMaq(){
		txtOrdenTrabajoMaq.setValue(null);	txtEquipoId_Equipo.setValue(null); 
	 txtUdadMaquinaria.setValue(null);
		txtValorUnitMaquinaria.setValue(null);
		 txtTipoDistribucionMaq.setValue(null);
		txtHorometroInicalMq.setValue(null); txtHorometroFinalMq.setValue(null);
		 txtNivel2IdMaq.setValue(null);  txtNivel4ErpMaq.setValue(null);
	}

	public void	limpiar_pantallaRiego(){
		txtOrdenTrabajoRiego.setValue(null);
		txtNumeroRiegos.setValue(null); txtTrabIdSupervisorRiego.setValue(null);
		txtHorometroFinalR.setValue(null);	txtNivel2IdRiego.setValue(null);
		txtHorometroInicalR.setValue(null);	
		txtTotalAreaRegada.setValue(null);	
		txtLaborId_LaborRiego.setValue(null);	
		txtTurnoCampoId_turnoCampo.setValue(null); txtVolTotalNivel4.setValue(null);
		txtSistemaRiegoId_SistemaRiego.setValue(null); txtInfraId_Infraestructura .setValue(null); 
		txtNivel4ErpRiego.setValue(null); txtTipoDistribucionRiego.setValue(null);
		txtCaudalNivel4.setValue(null); txtVolTotalNivel4.setValue(null);
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneMenu getTxtPersEmpr() {
		return txtPersEmpr;
	}

	public void setTxtPersEmpr(SelectOneMenu txtPersEmpr) {
		this.txtPersEmpr = txtPersEmpr;
	}

	public SelectOneMenu getTxtTipoPersonal() {
		return txtTipoPersonal;
	}

	public void setTxtTipoPersonal(SelectOneMenu txtTipoPersonal) {
		this.txtTipoPersonal = txtTipoPersonal;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	
	public void action_agregarPlanillaMaquinaria() throws Exception {

		 

		Double cantidadPagoVal = FacesUtils.checkDouble(txtCantidadPago);
		Double valorUnitVal = FacesUtils.checkDouble(txtValorUnitario);
		
		Double horometroInicialMaq  = FacesUtils.checkDouble(txtHorometroInicalMq);
		Double horometroFinalMaq  = FacesUtils.checkDouble(txtHorometroFinalMq);

		if (txtUdadMedPago.getValue() != null
				&& txtCantidadPago.getValue() != null && txtLaborId_Labor.getValue() != null 
				&& txtNivel2Id.getValue() != null && txtTipoDistribucion.getValue() != null 
				&& txtEquipoId_Equipo !=null &&  txtTrabId_Trabajador !=null && txtCeptoNominaId_ConceptoNomina !=null 
				&& horometroInicialMaq !=null  && horometroInicialMaq>0
				&& horometroFinalMaq !=null && horometroFinalMaq>0
				&& cantidadPagoVal != null && cantidadPagoVal > 0
				&& valorUnitVal != null && valorUnitVal > 0) {

			String tipoDistribucion = (String) txtTipoDistribucion.getValue();

			int i = 0;

			if (tipoDistribucion.equals("codigoErp")
					&& txtNivel4Erp.getValue() != null & selectedNivel3ManoObra.size() == 1) {

				Long nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				String nivel3Id = selectedNivel3ManoObra.get(0);
				String codigo = txtNivel4Erp.getValue().toString();
				Object[] variables = { "codigoAlternativo", true, codigo, "=", "nivel3", true, nivel3Id, "=" };
				List<Nivel4> nivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);

				Long ordenTrabajoId = null;
				DatPlanLaborDet ot = null;
				if (txtOrdenTrabajo.getValue() != null) {
					ordenTrabajoId = Long.parseLong(txtOrdenTrabajo.getValue().toString());
					ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
				}

				Long etapaId = null;
				Long variedId = null;
				String nombreNivel4 = null;
				Double edad = 0.0;

				Double areaNetaTotal = 0.0;

				int n = 0;
				for (n = 0; n < nivel4.size();) {
					Double s = (nivel4.get(n).getAreaNeta());
					areaNetaTotal += s;
					n++;
				}
				
				String tipoPersona = FacesUtils.checkString(txtTipoPersonal);

				Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
				Labor labor = businessDelegatorView.getLabor(laborId);
				
				Long idContratista = null;
				Trabajador trabajador = null;
				String codTrabajador = null;
				
				PersEmpr contratista = null;
				String nombreContratista =null; 
				
				Long trabajadorId = FacesUtils.checkLong(txtTrabId_Trabajador);
				if (trabajadorId != null) {
					trabajador = businessDelegatorView.getTrabajador(trabajadorId);
					idContratista = trabajador.getContratista().getPersEmprId();
					codTrabajador = trabajador.getNombre();
					
					contratista = businessDelegatorView.getPersEmpr(idContratista);
					
					 nombreContratista =  contratista.getNombre();
				}else{
					idContratista = FacesUtils.checkLong(txtPersEmpr);
					contratista = businessDelegatorView.getPersEmpr(idContratista);
					 nombreContratista =  contratista.getNombre();
					}
				Long udadMedId_UdadMed = Long.parseLong(txtUdadMedPago.getValue().toString());
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

				Long conceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
				ConceptoNomina conceptoNomina = null;
				String codConceptoNomina = null;
				
				if (conceptoNominaId != null) {
					conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);
					codConceptoNomina = conceptoNomina.getNombre();
				}				
				
				String codUdadMedNomina = udadMed.getCodigo();

				String nombreLabor = labor.getNombre();
				String nombreNivel2 = nivel2.getNombre();

				Double cantidadPago = 0.0;
				Double valorUnit = 0.0;
				Double costoTotal = 0.0;
				Date data = new Date();
				Double horasTrabajadas = FacesUtils.checkDouble(txtHorasTrabajadas);

				Long equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
				Equipo equipo = businessDelegatorView.getEquipo(equipoId);
				
				String codEquipo = equipo.getCodigo();// FacesUtils.checkString(txtCodEquipo);
				
				Double horometroIni = FacesUtils.checkDouble(txtHorometroInicalMq);
				Double horometroFin = FacesUtils.checkDouble(txtHorometroFinalMq);

				Double totalHoras = 0.0;
				Double valorUnitMaq = 0.0;
				Double costoTotalMaq = 0.0;
				//Date horaInicial = null;//FacesUtils.checkDate(txtHoraInicialMaquinaria);
				//Date horaFinal = null;//FacesUtils.checkDate(txtHoraFinalMaquinaria);
				
				Long implementoId = null;
				Equipo implementoEquipo =null;
				String codigoImplemento=null;
				if(txtImplemento.getValue()!=null) {
					 implementoId = Long.parseLong(txtImplemento.getValue().toString());
					 implementoEquipo = businessDelegatorView.getEquipo(implementoId);
					 codigoImplemento =implementoEquipo.getCodigo();
				}
			
				UdadMed udadMedMaq = null;
				

				if (dataPlanillaDet == null) {
					dataPlanillaDet = new ArrayList<DatPlanillaNominaDetDTO>();
				}

				for (i = 0; i < nivel4.size();) {

					if (nivel4.get(i).getEtapa() != null) {
						etapaId = nivel4.get(i).getEtapa().getEtapaId();
					}

					if (nivel4.get(i).getVariedad() != null) {
						variedId = nivel4.get(i).getVariedad();
					}

					nombreNivel4 = nivel4.get(i).getNombre();
					edad = (businessDelegatorView.calcularEdadLote(data, nivel4.get(i).getNivel4Id()));

					Double cantidadPago1 = FacesUtils.checkDouble(txtCantidadPago);
					Double valorUnit1 = FacesUtils.checkDouble(txtValorUnitario);

					cantidadPago = ((cantidadPago1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					cantidadPago = (double) Math.round((cantidadPago) * 10) / 10;

					valorUnit = valorUnit1;

					costoTotal = (cantidadPago * valorUnit);
					costoTotal = (double) Math.round((costoTotal) * 10) / 10;
					
					
					Double totalHoras1 =horometroFin-horometroIni ;
					valorUnitMaq = 0.0;//FacesUtils.checkDouble(txtValorUnitMaquinaria);
					Double cantidadPagoMaq = totalHoras1;
					
					totalHoras = ((totalHoras1 * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					totalHoras = (double) Math.round((totalHoras) * 1000) / 1000;
					
					cantidadPagoMaq = ((cantidadPagoMaq * nivel4.get(i).getAreaNeta()) / areaNetaTotal);
					cantidadPagoMaq = (double) Math.round((cantidadPagoMaq) * 1000) / 1000;

					costoTotalMaq = (cantidadPagoMaq * valorUnitMaq);
					costoTotalMaq = (double) Math.round((costoTotalMaq) * 1000) / 1000;

					DatPlanillaNominaDetDTO datPlanillaNominaDetDTO2 = new DatPlanillaNominaDetDTO();
					datPlanillaNominaDetDTO2.setTrabId_Trabajador(trabajador);
					datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(conceptoNomina);
					datPlanillaNominaDetDTO2.setUdadMedIdPago(udadMed);
					datPlanillaNominaDetDTO2.setCantidadPago(cantidadPago);
					datPlanillaNominaDetDTO2.setCodTrabajador(codTrabajador);
					datPlanillaNominaDetDTO2.setCodConceptoNomina(codConceptoNomina);
					datPlanillaNominaDetDTO2.setCodUmPago(codUdadMedNomina);
					datPlanillaNominaDetDTO2.setCostoTotal(costoTotal);
					datPlanillaNominaDetDTO2.setValorUnitario(valorUnit);
					datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(contratista);
					datPlanillaNominaDetDTO2.setNombrePersEmpr(nombreContratista);
					datPlanillaNominaDetDTO2.setNivel2Id(nivel2);
					datPlanillaNominaDetDTO2.setNivel4(nivel4.get(i));
					datPlanillaNominaDetDTO2.setLaborId(labor);
					datPlanillaNominaDetDTO2.setNombreNivel2(nombreNivel2);
					datPlanillaNominaDetDTO2.setNombreNivel4(nombreNivel4);
					datPlanillaNominaDetDTO2.setNombreLabor(nombreLabor);
					datPlanillaNominaDetDTO2.setOrdenTrabajo(ot);
					datPlanillaNominaDetDTO2.setEtapaId(etapaId);
					datPlanillaNominaDetDTO2.setVariedId(variedId);
					datPlanillaNominaDetDTO2.setEdad(edad);
					datPlanillaNominaDetDTO2.setHorasTrabajadas(horasTrabajadas);
					datPlanillaNominaDetDTO2.setTipoPersona(tipoPersona);
					
					/****** sesion de maquinaria****/
					datPlanillaNominaDetDTO2.setEquipoId(equipo);
					datPlanillaNominaDetDTO2.setNombreEquipo(codEquipo);
					datPlanillaNominaDetDTO2.setHorometroInicial(horometroIni);
					datPlanillaNominaDetDTO2.setHorometroFinal(horometroFin);
					datPlanillaNominaDetDTO2.setHorometroTotal(totalHoras);
					datPlanillaNominaDetDTO2.setCantidadMaq(cantidadPagoMaq);
					datPlanillaNominaDetDTO2.setValorUnitarioMaq(valorUnitMaq);
					datPlanillaNominaDetDTO2.setValorTotalMaq(costoTotalMaq);
					datPlanillaNominaDetDTO2.setUdadMedMaq(udadMedMaq);
					
					datPlanillaNominaDetDTO2.setImplementoId(implementoEquipo);
					datPlanillaNominaDetDTO2.setNombreImplemento(codigoImplemento);
					
					//datPlanillaNominaDetDTO2.setNomUdadMedMaq(nomUdadMedMaq);
					/*******************************/
					

					dataPlanillaDet.add(datPlanillaNominaDetDTO2);

					i++;

				}
				contratista=null;
				nombreContratista=null;
				edad = null;
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
				nivel2Id = null;
				nombreLabor = null;
				nombreNivel2 = null;
				nombreNivel4 = null;
				ordenTrabajoId = null;
				ot = null;
				horasTrabajadas = null;

			} else if (tipoDistribucion.equals("lote")) {

				String lotesCheck = "";
				Double areaNetaAcumulada = 0.0;
				Double area_neta = 0.0;
				if (selectedNivel4ManoObra != null && selectedNivel4ManoObra.size() > 0) {
					// lotesCheck = selectedNivel4ManoObra.get(0);
					for (int a = 0; a < selectedNivel4ManoObra.size(); a++) {
						lotesCheck = selectedNivel4ManoObra.get(a);
						Object[] variables = { "nivel4Id", true, lotesCheck, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 entidad = listaNivel4.get(0);
						area_neta += entidad.getAreaNeta();

					}
					areaNetaAcumulada += area_neta;
				}

				String lotesSeleccionadas = "";
				if (selectedNivel4ManoObra != null && selectedNivel4ManoObra.size() > 0) {
					// lotesSeleccionadas = selectedNivel4ManoObra.get(0);
					// flagLote = 0L;
					for (int j = 0; j < selectedNivel4ManoObra.size(); j++) {
						lotesSeleccionadas = selectedNivel4ManoObra.get(j);
						Long ordenTrabajoId = null;
						DatPlanLaborDet ot = null;
						if (txtOrdenTrabajo.getValue() != null) {
							ordenTrabajoId = Long.parseLong(txtOrdenTrabajo.getValue().toString());
							ot = businessDelegatorView.getDatPlanLaborDet(ordenTrabajoId);
						}

						Long nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
						Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

						Object[] variables = { "nivel4Id", true, lotesSeleccionadas, "=" };
						List<Nivel4> listaNivel4 = businessDelegatorView.findByCriteriaInNivel4(variables, null, null);
						Nivel4 nivel4 = listaNivel4.get(0);

						Long etapaId = null;
						Long variedId = null;

						if (nivel4.getEtapa() != null) {
							etapaId = nivel4.getEtapa().getEtapaId();
						}

						if (nivel4.getVariedad() != null) {
							variedId = nivel4.getVariedad();
						}
						
						String tipoPersona = FacesUtils.checkString(txtTipoPersonal);

						Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
						Labor labor = businessDelegatorView.getLabor(laborId);						

						Long idContratista = null;
						Trabajador trabajador = null;
						String codTrabajador = null;
						
						PersEmpr contratista = null;
						String nombreContratista =null; 
						
						Long trabajadorId = FacesUtils.checkLong(txtTrabId_Trabajador);
						if (trabajadorId != null) {
							trabajador = businessDelegatorView.getTrabajador(trabajadorId);
							idContratista = trabajador.getContratista().getPersEmprId();
							codTrabajador = trabajador.getNombre();
							
							contratista = businessDelegatorView.getPersEmpr(idContratista);
							
							 nombreContratista =  contratista.getNombre();
						}else{
							idContratista = FacesUtils.checkLong(txtPersEmpr);
							contratista = businessDelegatorView.getPersEmpr(idContratista);
							 nombreContratista =  contratista.getNombre();
							}

						Long udadMedId_UdadMed = Long.parseLong(txtUdadMedPago.getValue().toString());
						UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

						Long conceptoNominaId = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
						ConceptoNomina conceptoNomina = null;
						String codConceptoNomina = null;
						
						if (conceptoNominaId != null) {
							conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);
							codConceptoNomina = conceptoNomina.getNombre();
						}
						
						String codUdadMedNomina = udadMed.getCodigo();

						String nombreLabor = labor.getNombre();
						String nombreNivel2 = nivel2.getNombre();
						String nombreNivel4 = nivel4.getNombre();

						Double cantidadPago = FacesUtils.checkDouble(txtCantidadPago);
						Double cantidadFinal = (cantidadPago * nivel4.getAreaNeta()) / areaNetaAcumulada;
						cantidadFinal = (double) Math.round((cantidadFinal) * 10) / 10;

						Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
						Double costoTotal = (double) Math.round((cantidadFinal * valorUnit) * 10) / 10;

						Double horasTrabajadas = 0.0;
						
						
						Long equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
						Equipo equipo = businessDelegatorView.getEquipo(equipoId);
						
						String codEquipo = equipo.getCodigo();// FacesUtils.checkString(txtCodEquipo);
						
						Double horometroIni = FacesUtils.checkDouble(txtHorometroInicalMq);
						Double horometroFin = FacesUtils.checkDouble(txtHorometroFinalMq);

						Double totalHoras = 0.0;
						Double valorUnitMaq = 0.0;
						Double costoTotalMaq = 0.0;
						//Date horaInicial = null;//FacesUtils.checkDate(txtHoraInicialMaquinaria);
						//Date horaFinal = null;//FacesUtils.checkDate(txtHoraFinalMaquinaria);
						
						Long implementoId = null;
						Equipo implementoEquipo =null;
						String codigoImplemento=null;
						if(txtImplemento.getValue()!=null) {
							 implementoId = Long.parseLong(txtImplemento.getValue().toString());
							 implementoEquipo = businessDelegatorView.getEquipo(implementoId);
							 codigoImplemento =implementoEquipo.getCodigo();
						}
					
						UdadMed udadMedMaq = null;
						Double totalHoras1 =horometroFin-horometroIni ;
						valorUnitMaq = 0.0;//FacesUtils.checkDouble(txtValorUnitMaquinaria);
						Double cantidadPagoMaq = totalHoras1;
						
					
						totalHoras = ((totalHoras1 * nivel4.getAreaNeta()) / areaNetaAcumulada);
						totalHoras = (double) Math.round((totalHoras) * 1000) / 1000;
						
						cantidadPagoMaq = ((cantidadPagoMaq *  nivel4.getAreaNeta()) / areaNetaAcumulada);
						cantidadPagoMaq = (double) Math.round((cantidadPagoMaq) * 1000) / 1000;

						costoTotalMaq = (cantidadPagoMaq * valorUnitMaq);
						costoTotalMaq = (double) Math.round((costoTotalMaq) * 1000) / 1000;

						if (dataPlanillaDet == null) {
							dataPlanillaDet = new ArrayList<DatPlanillaNominaDetDTO>();
						}

						DatPlanillaNominaDetDTO datPlanillaNominaDetDTO2 = new DatPlanillaNominaDetDTO();
						datPlanillaNominaDetDTO2.setTrabId_Trabajador(trabajador);
						datPlanillaNominaDetDTO2.setCeptoNominaId_ConceptoNomina(conceptoNomina);
						datPlanillaNominaDetDTO2.setUdadMedIdPago(udadMed);
						datPlanillaNominaDetDTO2.setCantidadPago(cantidadFinal);
						datPlanillaNominaDetDTO2.setCodTrabajador(codTrabajador);
						datPlanillaNominaDetDTO2.setCodConceptoNomina(codConceptoNomina);
						datPlanillaNominaDetDTO2.setCodUmPago(codUdadMedNomina);
						datPlanillaNominaDetDTO2.setCostoTotal(costoTotal);
						datPlanillaNominaDetDTO2.setValorUnitario(valorUnit);
						datPlanillaNominaDetDTO2.setPersEmprId_PersEmpr(contratista);
						datPlanillaNominaDetDTO2.setNombrePersEmpr(nombreContratista);
						datPlanillaNominaDetDTO2.setNivel2Id(nivel2);
						datPlanillaNominaDetDTO2.setNivel4(nivel4);
						datPlanillaNominaDetDTO2.setLaborId(labor);
						datPlanillaNominaDetDTO2.setNombreNivel2(nombreNivel2);
						datPlanillaNominaDetDTO2.setNombreNivel4(nombreNivel4);
						datPlanillaNominaDetDTO2.setNombreLabor(nombreLabor);
						datPlanillaNominaDetDTO2.setOrdenTrabajo(ot);
						datPlanillaNominaDetDTO2.setEtapaId(etapaId);
						datPlanillaNominaDetDTO2.setVariedId(variedId);
						datPlanillaNominaDetDTO2.setHorasTrabajadas(horasTrabajadas);
						datPlanillaNominaDetDTO2.setTipoPersona(tipoPersona);
						
						/****** sesion de maquinaria****/
						datPlanillaNominaDetDTO2.setEquipoId(equipo);
						datPlanillaNominaDetDTO2.setNombreEquipo(codEquipo);
						datPlanillaNominaDetDTO2.setHorometroInicial(horometroIni);
						datPlanillaNominaDetDTO2.setHorometroFinal(horometroFin);
						datPlanillaNominaDetDTO2.setHorometroTotal(totalHoras);
						datPlanillaNominaDetDTO2.setCantidadMaq(cantidadPagoMaq);
						datPlanillaNominaDetDTO2.setValorUnitarioMaq(valorUnitMaq);
						datPlanillaNominaDetDTO2.setValorTotalMaq(costoTotalMaq);
						datPlanillaNominaDetDTO2.setUdadMedMaq(udadMedMaq);
						
						datPlanillaNominaDetDTO2.setImplementoId(implementoEquipo);
						datPlanillaNominaDetDTO2.setNombreImplemento(codigoImplemento);
						
						//datPlanillaNominaDetDTO2.setNomUdadMedMaq(nomUdadMedMaq);
						/*******************************/

						dataPlanillaDet.add(datPlanillaNominaDetDTO2);
						contratista=null;
						nombreContratista=null;
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
						nivel2Id = null;
						nombreLabor = null;
						nombreNivel2 = null;
						ordenTrabajoId = null;
						ot = null;
						horasTrabajadas = null;

					}
				}
			}

			limpiar_pantallaMoMaquinaria();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos Orden de trabajo,  trabajador, unidad de medida, concepto, cantidad, tarifa tengan valores. "));
		}
	}

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	public SelectItem[] getSelectImplemento() {

		if (implemento == null || implemento.size() == 0) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" 
						, "categoriaEquipo.funcion", true, "Implemento", "="
									};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo Implemento : lista) {
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(), Implemento.getNombre());
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
}
