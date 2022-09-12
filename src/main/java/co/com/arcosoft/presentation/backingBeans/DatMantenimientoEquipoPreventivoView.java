package co.com.arcosoft.presentation.backingBeans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
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
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
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
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AgenteCausadorParada;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.AreaTrabajo;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.DatHorasTrabajoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipoMec;
import co.com.arcosoft.modelo.DatMantenimientoEquipoPlanRevision;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.MotivosEntradaTaller;
import co.com.arcosoft.modelo.NivelPrioridad;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.PlanRevisionProd;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.TallerMecanico;
import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.ZonasFabrica;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoPlanRevisionDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;
import co.com.arcosoft.modelo.informes.dto.AnalisisProcesoIndustrialDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoPlanRevisionDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.ProgMttoPreventivosMaqDTO;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathuraf
 * 
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatMantenimientoEquipoPreventivoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoPreventivoView.class);
	private InputText txtCierreOt;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtOrderTrabajo;
	private InputTextarea txtReporteTecnico;
	private InputText txtUsuarioDigitacion;
	private InputText txtVidaDia;
	private InputText txtVidaHora;
	private InputText txtVidaKm;
	private SelectOneMenu txtAgenteCausadorParadaId_AgenteCausadorParada;
	SelectItem[] selectAgenteCausador;
	private List<AgenteCausadorParada> agenteCausador;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private SelectOneMenu txtConductor;
	SelectItem[] selectConductor;
	private List<Trabajador> conductor;

	private SelectOneMenu txtEquipoId_Industrial;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtMotivosEntradaTallerId_MotivosEntradaTaller;
	SelectItem[] selectMotivoEntradaTaller;
	private List<MotivosEntradaTaller> motivoEntradaTaller;

	private SelectOneMenu txtTallerMecanicoId_TallerMecanico;
	SelectItem[] selectTallerMecanico;
	private List<TallerMecanico> tallerMecanico;

	private SelectOneMenu txtTipoMantenimientoId_TipoMantenimiento;
	SelectItem[] selectTipoMantenimiento;
	private List<TipoMantenimiento> tipoMantenimiento;

	private SelectOneMenu txtSolicitante;
	SelectItem[] selectSolicitante;
	private List<Trabajador> solicitante;

	/** mantenimiento industrial **/

	private SelectOneMenu txtZonasFabricaId_ZonasFabrica;
	SelectItem[] selectZona;
	private List<ZonasFabrica> zona;

	private SelectOneMenu txtAreaTrabajoId_AreaTrabajo;
	SelectItem[] selectAreaTrabajo;
	private List<AreaTrabajo> area;

	private SelectOneMenu txtTagId_Tag;
	SelectItem[] selectTag;
	private List<Tag> tag;

	private SelectOneMenu txtNivelPrioridadId_NivelPrioridad;
	SelectItem[] selectNivel;
	private List<NivelPrioridad> nivel;

	private SelectOneRadio txtRequiereParadaFabrica;
	private InputTextarea txtDescripcionSolicitud;
	private InputText txtVidaActual;
	private InputText txtDatMantenimientoEquipoId;
	private Calendar txtDuracion;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCierreOt;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaEntradaTaller;
	private Calendar txtFechaSalidaTaller;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaReaperturaOt;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatMantenimientoEquipoDTO> data;

	private DatMantenimientoEquipoDTO selectedDatMantenimientoEquipo;
	private DatMantenimientoEquipo entity;
	private boolean showDialog;

	/***** campos adicionales ***/

	/*** mecanic ***/
	private List<DatMantenimientoEquipoMecDTO> dataEquipoMec;
	private DatMantenimientoEquipoMecDTO selectedDatEquipoMec;
	private DatMantenimientoEquipoMec entityDatMantenimientoEquipoMec;

	private InputText txtCantidadMec;
	private InputText txtCostoTotalMec;
	private InputText txtValorUnitarioMec;
	private Calendar txtHoraIniMec;
	private Calendar txtHoraFinMec;

	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNomina;
	private List<ConceptoNomina> conceptoNomina;

	private SelectOneMenu txtMecanico;
	SelectItem[] selectMecanico;
	private List<Trabajador> mecanico;

	private SelectOneMenu txtUdadMedMec;
	SelectItem[] selectUdadMedMec;
	private List<UdadMed> udadMedMec;

	private SelectOneMenu txtTarea;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private Calendar txtFechaRegistro;
	private CommandButton btnAgregarMecanico;

	private InputText txtCodMecanico;
	private InputText txtCodUdadMedMec;
	private InputText txtCodLaborMec;
	private InputText txtCodConceptoNomina;
	private InputText txtCodSistema;
	private InputText txtCodCompartimiento;

	/*** productos ***/
	private List<DatMantenimientoEquipoProdDTO> dataEquipoProd;
	private DatMantenimientoEquipoProdDTO selectedDatEquipoProd;
	private DatMantenimientoEquipoProd entityDatMantenimientoEquipoProd;

	private SelectOneMenu txtAlmacenId;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;

	private SelectOneMenu txtUbAlmacen;
	SelectItem[] selectUbAlmacen;

	private InputText txtCantidadProd;
	private InputText txtCostoTotalProd;
	private InputText txtValorUnitarioProd;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;

	private SelectOneMenu txtProductoId_ProductoInds;
	SelectItem[] selectProductoIdInds;
	private List<Producto> productoIdInds;

	private SelectOneMenu txtJefeMtto;
	SelectItem[] selectJefeMtto;
	private List<Trabajador> jefeMtto;

	private SelectOneMenu txtUdadMedProd;
	SelectItem[] selectUdadMedProd;
	private List<UdadMed> udadMedProd;

	private CommandButton btnAgregarProd;
	private InputText txtCodJefeMtto;
	private InputText txtCodProducto;
	private InputText txtCodAlmacen;
	private InputText txtCodUdadMedProd;

	private SelectOneMenu txtTipoSuministro;
	private InputText txtOrigenDatos;

	private SelectOneMenu txtCompartimientosEquipoId;
	SelectItem[] selectCompartimientosEquipo;
	private List<CompartimientosEquipo> compartimiento;

	private SelectOneMenu txtSistemasEquipoId;
	SelectItem[] selectSistemasEquipo;
	private List<SistemasEquipo> sistema;

	private String solicitudId;
	private String idSolicitante;
	private String nombreSolicitante;
	private String equipoId;
	private String equipoNombre;
	private String nombreTipoMtto;
	private String nombreNivelPrioridad;
	private String nombreTaller;
	private String solicitud;
	private String moduloActivo;
	private String compoRequieridoMttoIndustrial = "false";
	private String compoRequieridoMttoMaquinaria = "false";
	private String ocultaMttoIndustrial = "none";
	private String ocultaMttoMaquinaria = "none";
	private String origendatos;

	private SelectOneMenu txtCompartimientosEquipoProdId;
	SelectItem[] selectCompartimientosEquipoProd;
	private List<CompartimientosEquipo> compartimientoProd;

	private SelectOneMenu txtSistemasEquipoProdId;
	SelectItem[] selectSistemasEquipoProd;
	private List<SistemasEquipo> sistemaProd;

	private InputText txtCodCompartimientoEquipoProd;
	private InputText txtCodSistemaEquipoProd;

	private Calendar txtFechaProd;
	private DatHorasTrabajoEquipo entity_hrt;
	private PlanRevisionEquipoDet entity_prdet;
	private Equipo entity_equipo;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private int activeTapIndex = 0;
	private String requeridoHorometro = "false";
	private String requeridoOdometro = "false";

	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtTipoPersonal;

	private ListadoProximosMttoEquiposDTO selectedOt;

	private HttpServletResponse response;
	private FacesContext context;
	private HttpServletRequest origRequest;
	private ServletContext servletContext;

	/****** DatMantenimientoEquipoPlanRevision ******/

	private List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision;
	private DatMantenimientoEquipoPlanRevisionDTO selectedPlanRevision;

	private SelectOneMenu txtPlanRevisionEquipoId_PlanRevisionEquipo;
	SelectItem[] selectPlanRevision;

	private SelectOneMenu txtResponsableMttoId;
	private List<Trabajador> responsableMtto;
	SelectItem[] selectResponsableMtto;

	private SelectOneMenu txtResponsableConsulta;
	SelectItem[] selectResponsableConsulta;
	private List<Trabajador> responsableConsulta;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private InputText txtConsecutivoConsulta;
	private List<ProgMttoPreventivosMaqDTO> dataListadoOrdenesMtto;
	private ProgMttoPreventivosMaqDTO selectedListadoMtto;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";

	/*** consulta saldos por ubicacio ***/
	private List<ConsultaStockMaquinariaDTO> dataProductoUbicacion;
	ConsultaStockMaquinariaDTO selectedProductoUbicacion;

	private InputText txtSurtidor;

	private SelectOneMenu txtEstadoOrdenServicio;
	private InputText txtDifTiempoMttoAnteriorActual;

	/** productos ***/

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen2;
	private List<Almacen> almacen2;

	private SelectOneMenu txtTipoProductoConsulta;
	SelectItem[] selectTipoProductoConsulta;
	private List<TipoProducto> tipoProductoConsulta;

	private SelectOneMenu txtProductoIdConsulta;
	SelectItem[] selectProductoIdConsulta;
	private List<Producto> productoIdConsulta;

	private Calendar txtFechaInicialConsulta;
	private Calendar txtFechaFinalConsulta;

	private List<SolicitudesMttoEquipoDTO> dataProductos;
	private SolicitudesMttoEquipoDTO selectedListadoProductos;

	private DatMantenimientoEquipoProd entityDetProd;

	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;
	private List<ConceptoKardex> conceptoKardex;
	private StreamedContent fileImagen;

	private DefaultStreamedContent file01 = null;

	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;
	private SelectOneMenu txtDescargaInventario;

	public DatMantenimientoEquipoPreventivoView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatMantenimientoEquipo = null;
		setShowDialog(true);

		return "";
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();

			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			compoRequieridoMttoIndustrial = "false";
			compoRequieridoMttoMaquinaria = "true";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

			origendatos = "Modulo_TallerAgricola";

		} else {

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

			compoRequieridoMttoIndustrial = "true";
			compoRequieridoMttoMaquinaria = "false";

			origendatos = "Modulo_MttoIndustrial";

		}
	}

	public String action_clear() {
		entity = null;
		entity_hrt = null;
		entity_prdet = null;
		entity_equipo = null;
		entityDetProd = null;
		selectedDatMantenimientoEquipo = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		moduloSeleccionado();

		// información compartida entre modulos

		if (txtCierreOt != null) {
			txtCierreOt.setValue("A");
			txtCierreOt.setDisabled(false);
		}
		if (txtUbAlmacen != null) {
			txtUbAlmacen.setValue(null);
			txtUbAlmacen.setDisabled(false);
		}
		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(null);
			txtDescripcionSolicitud.setDisabled(false);
		}
		if (txtFechaRegistro != null) {
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(false);
		}
		if (txtConceptoKardex != null) {
			txtConceptoKardex.setValue(null);
			txtConceptoKardex.setDisabled(false);
		}
		if (txtDescargaInventario != null) {
			txtDescargaInventario.setValue(null);
			txtDescargaInventario.setDisabled(false);
		}
		if (txtResponsableMttoId != null) {
			txtResponsableMttoId.setValue(null);
			txtResponsableMttoId.setDisabled(false);
		}

		if (txtTipoProducto != null) {
			txtTipoProducto.setValue(null);
			txtTipoProducto.setDisabled(false);
		}

		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
		}

		if (txtTipoPersonal != null) {
			txtTipoPersonal.setValue(null);
			txtTipoPersonal.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtNivelPrioridadId_NivelPrioridad != null) {
			txtNivelPrioridadId_NivelPrioridad.setValue(null);
			txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
		}

		if (txtTallerMecanicoId_TallerMecanico != null) {
			txtTallerMecanicoId_TallerMecanico.setValue(null);
			txtTallerMecanicoId_TallerMecanico.setDisabled(false);
		}

		if (txtTipoMantenimientoId_TipoMantenimiento != null) {
			txtTipoMantenimientoId_TipoMantenimiento.setValue(null);
			txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
		}

		if (txtSolicitante != null) {
			txtSolicitante.setValue(null);
			txtSolicitante.setDisabled(false);
		}

		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(null);
			txtDescripcionSolicitud.setDisabled(false);
		}
		if (txtConductor != null) {
			txtConductor.setValue(null);
			txtConductor.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtOrderTrabajo != null) {
			txtOrderTrabajo.setValue(null);
			txtOrderTrabajo.setDisabled(false);
		}

		if (txtReporteTecnico != null) {
			txtReporteTecnico.setValue(null);
			txtReporteTecnico.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtFechaSalidaTaller != null) {
			txtFechaSalidaTaller.setValue(null);
			txtFechaSalidaTaller.setDisabled(false);
		}

		if (txtVidaHora != null) {
			txtVidaHora.setValue(null);
			txtVidaHora.setDisabled(true);
		}

		if (txtVidaKm != null) {
			txtVidaKm.setValue(null);
			txtVidaKm.setDisabled(true);
		}

		if (txtVidaDia != null) {
			txtVidaDia.setValue(null);
			txtVidaDia.setDisabled(true);
		}

		if (txtAgenteCausadorParadaId_AgenteCausadorParada != null) {
			txtAgenteCausadorParadaId_AgenteCausadorParada.setValue(null);
			txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtMotivosEntradaTallerId_MotivosEntradaTaller != null) {
			txtMotivosEntradaTallerId_MotivosEntradaTaller.setValue(null);
			txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);
		}

		if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null) {
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(null);
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
		}

		if (txtTipoMantenimientoId_TipoMantenimiento != null) {
			txtTipoMantenimientoId_TipoMantenimiento.setValue(null);
			txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
		}

		if (txtSolicitante != null) {
			txtSolicitante.setValue(null);
			txtSolicitante.setDisabled(false);
		}

		if (txtDuracion != null) {
			txtDuracion.setValue(null);
			txtDuracion.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCierreOt != null) {
			txtFechaCierreOt.setValue(null);
			txtFechaCierreOt.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaEntradaTaller != null) {
			Date data = new Date();
			txtFechaEntradaTaller.setValue(data);
			txtFechaEntradaTaller.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaReaperturaOt != null) {
			txtFechaReaperturaOt.setValue(null);
			txtFechaReaperturaOt.setDisabled(false);
		}

		if (txtDatMantenimientoEquipoId != null) {
			txtDatMantenimientoEquipoId.setValue(null);
			txtDatMantenimientoEquipoId.setDisabled(false);
		}

		if (txtRequiereParadaFabrica != null) {
			txtRequiereParadaFabrica.setValue("NO");
			txtRequiereParadaFabrica.setDisabled(false);
		}

		// mantenimiento de maquinaria

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			compoRequieridoMttoIndustrial = "false";
			compoRequieridoMttoMaquinaria = "true";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

			if (txtTallerMecanicoId_TallerMecanico != null) {
				txtTallerMecanicoId_TallerMecanico.setValue(null);
				txtTallerMecanicoId_TallerMecanico.setDisabled(false);
			}

			if (txtAreaTrabajoId_AreaTrabajo != null) {
				txtAreaTrabajoId_AreaTrabajo.setValue(null);
				txtAreaTrabajoId_AreaTrabajo.setDisabled(true);
			}

			if (txtZonasFabricaId_ZonasFabrica != null) {
				txtZonasFabricaId_ZonasFabrica.setValue(null);
				txtZonasFabricaId_ZonasFabrica.setDisabled(true);
			}

			if (txtTagId_Tag != null) {
				txtTagId_Tag.setValue(null);
				txtTagId_Tag.setDisabled(true);
			}

			if (txtSurtidor != null) {
				txtSurtidor.setValue(null);
				txtSurtidor.setDisabled(false);
			}

			origendatos = "Modulo_TallerAgricola";

			/*
			 * if (txtOrigenDatos != null) {
			 * txtOrigenDatos.setValue("Modulo_TallerAgricola");
			 * txtOrigenDatos.setDisabled(true); }
			 */

		} else {

			compoRequieridoMttoMaquinaria = "false";
			compoRequieridoMttoIndustrial = "true";

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

			if (txtTallerMecanicoId_TallerMecanico != null) {
				txtTallerMecanicoId_TallerMecanico.setValue(null);
				txtTallerMecanicoId_TallerMecanico.setDisabled(false);
			}

			if (txtAreaTrabajoId_AreaTrabajo != null) {
				txtAreaTrabajoId_AreaTrabajo.setValue(null);
				txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
			}

			if (txtZonasFabricaId_ZonasFabrica != null) {
				txtZonasFabricaId_ZonasFabrica.setValue(null);
				txtZonasFabricaId_ZonasFabrica.setDisabled(false);
			}

			if (txtTagId_Tag != null) {
				txtTagId_Tag.setValue(null);
				txtTagId_Tag.setDisabled(false);
			}

			/*
			 * if (txtOrigenDatos != null) {
			 * txtOrigenDatos.setValue("Modulo_MttoIndustrial");
			 * txtOrigenDatos.setDisabled(true); }
			 */

			origendatos = "Modulo_MttoIndustrial";

		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		/*** mecanic ***/

		if (dataEquipoMec != null) {
			dataEquipoMec = null;
		}
		if (txtCantidadMec != null) {
			txtCantidadMec.setValue(null);
			txtCantidadMec.setDisabled(false);
		}

		if (txtCostoTotalMec != null) {
			txtCostoTotalMec.setValue(null);
			txtCostoTotalMec.setDisabled(false);
		}
		if (txtValorUnitarioMec != null) {
			txtValorUnitarioMec.setValue(null);
			txtValorUnitarioMec.setDisabled(false);
		}
		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		}
		if (txtMecanico != null) {
			txtMecanico.setValue(null);
			txtMecanico.setDisabled(false);
		}
		if (txtUdadMedMec != null) {
			txtUdadMedMec.setValue(null);
			txtUdadMedMec.setDisabled(false);
		}
		if (txtFechaRegistro != null) {
			Date date = new Date();
			txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}
		if (btnAgregarMecanico != null) {
			btnAgregarMecanico.setDisabled(false);
		}

		if (txtCodMecanico != null) {
			txtCodMecanico.setValue(null);
			txtCodMecanico.setDisabled(false);
		}
		if (txtCodUdadMedMec != null) {
			txtCodUdadMedMec.setValue(null);
			txtCodUdadMedMec.setDisabled(false);
		}
		if (txtCodConceptoNomina != null) {
			txtCodConceptoNomina.setValue(null);
			txtCodConceptoNomina.setDisabled(false);
		}

		if (txtCompartimientosEquipoId != null) {
			txtCompartimientosEquipoId.setValue(null);
			txtCompartimientosEquipoId.setDisabled(false);
		}

		if (txtSistemasEquipoId != null) {
			txtSistemasEquipoId.setValue(null);
			txtSistemasEquipoId.setDisabled(false);
		}

		if (txtCodSistema != null) {
			txtCodSistema.setValue(null);
			txtCodSistema.setDisabled(false);
		}

		if (txtCodCompartimiento != null) {
			txtCodCompartimiento.setValue(null);
			txtCodCompartimiento.setDisabled(false);
		}

		/*** productos ***/
		if (dataEquipoProd != null) {
			dataEquipoProd = null;
		}
		if (txtAlmacenId != null) {
			txtAlmacenId.setValue(null);
			txtAlmacenId.setDisabled(false);
		}
		if (txtCantidadProd != null) {
			txtCantidadProd.setValue(null);
			txtCantidadProd.setDisabled(false);
		}
		if (txtCostoTotalProd != null) {
			txtCostoTotalProd.setValue(null);
			txtCostoTotalProd.setDisabled(false);
		}
		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}
		if (txtValorUnitarioProd != null) {
			txtValorUnitarioProd.setValue(null);
			txtValorUnitarioProd.setDisabled(false);
		}
		if (txtJefeMtto != null) {
			txtJefeMtto.setValue(null);
			txtJefeMtto.setDisabled(false);
		}
		if (txtUdadMedProd != null) {
			txtUdadMedProd.setValue(null);
			txtUdadMedProd.setDisabled(false);
		}

		if (btnAgregarProd != null) {
			btnAgregarProd.setDisabled(false);
		}
		if (txtCodJefeMtto != null) {
			txtCodJefeMtto.setValue(null);
			txtCodJefeMtto.setDisabled(false);
		}
		if (txtCodProducto != null) {
			txtCodProducto.setValue(null);
			txtCodProducto.setDisabled(false);
		}
		if (txtCodAlmacen != null) {
			txtCodAlmacen.setValue(null);
			txtCodAlmacen.setDisabled(false);
		}
		if (txtCodUdadMedProd != null) {
			txtCodUdadMedProd.setValue(null);
			txtCodUdadMedProd.setDisabled(false);
		}
		if (txtTipoSuministro != null) {
			txtTipoSuministro.setValue(null);
			txtTipoSuministro.setDisabled(false);
		}

		if (txtCompartimientosEquipoProdId != null) {
			txtCompartimientosEquipoProdId.setValue(null);
			txtCompartimientosEquipoProdId.setDisabled(false);
		}

		if (txtSistemasEquipoProdId != null) {
			txtSistemasEquipoProdId.setValue(null);
			txtSistemasEquipoProdId.setDisabled(false);
		}

		if (txtCodSistemaEquipoProd != null) {
			txtCodSistemaEquipoProd.setValue(null);
			txtCodSistemaEquipoProd.setDisabled(false);
		}

		if (txtCodCompartimientoEquipoProd != null) {
			txtCodCompartimientoEquipoProd.setValue(null);
			txtCodCompartimientoEquipoProd.setDisabled(false);
		}

		if (dataPlanRevision != null) {
			dataPlanRevision = null;
		}

		if (txtFechaProd != null) {
			Date date = new Date();
			txtFechaProd.setValue(date);
			txtFechaProd.setDisabled(false);
		}

		return "";
	}

	public void listener_TipoPersonalServicio() {

		if (txtTipoPersonal.getValue() != null) {
			if (txtTipoPersonal.getValue().equals("Propio")) {
				txtMecanico.setDisabled(false);
				txtPersEmprId_PersEmpr.setDisabled(true);

			}
			if (txtTipoPersonal.getValue().equals("Externo")) {
				txtMecanico.setDisabled(true);
				txtPersEmprId_PersEmpr.setDisabled(false);

			}
		}

	}

	/**************** mecanicos ************************/

	public List<DatMantenimientoEquipoMecDTO> getDatMantenimientoEquipoMec1() {

		if (dataEquipoMec == null || dataEquipoMec.size() == 0) {
			return null;
		} else {
			return dataEquipoMec;
		}

	}

	public void action_agregarMecanico() throws Exception {
		if (txtTipoPersonal.getValue() != null) {

			Long mecanicoId = null;
			Trabajador mecanico = null;
			String codTrabajador = "";
			if (txtMecanico.getValue() != null) {
				mecanicoId = Long.parseLong(txtMecanico.getValue().toString());
				mecanico = businessDelegatorView.getTrabajador(mecanicoId);
				codTrabajador = mecanico.getNombre();
			}

			Long persEmprId = null;
			PersEmpr persEmpr = null;
			String nomProveedor = "";
			if (txtPersEmprId_PersEmpr.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());
				persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				nomProveedor = persEmpr.getNombre();
			}

			Long udadMedId_UdadMed = null;
			UdadMed udadMed = null;
			String codUdadMedNomina = "";
			if (txtUdadMedMec.getValue() != null) {
				udadMedId_UdadMed = Long.parseLong(txtUdadMedMec.getValue().toString());
				udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
				codUdadMedNomina = udadMed.getCodigo();
			}

			Long codTarea = null;
			Labor tarea = null;
			String codLabor = "";
			if (txtTarea.getValue() != null) {
				codTarea = Long.parseLong(txtTarea.getValue().toString());
				tarea = businessDelegatorView.getLabor(codTarea);
				codLabor = tarea.getNombre();
			}
			Double cantidadPago = FacesUtils.checkDouble(txtCantidadMec);
			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			String tipoPersonal = FacesUtils.checkString(txtTipoPersonal);
			// String codLabor =tarea.getCodigo().toString();

			// boolean existe= false;

			if (dataEquipoMec == null) {
				dataEquipoMec = new ArrayList<DatMantenimientoEquipoMecDTO>();

			}

			DatMantenimientoEquipoMecDTO datMantenimientoEquipoMec = new DatMantenimientoEquipoMecDTO();
			datMantenimientoEquipoMec.setTrabId_Trabajador(mecanico);
			datMantenimientoEquipoMec.setTipoPersonal(tipoPersonal);
			datMantenimientoEquipoMec.setContratistaId(persEmpr);
			datMantenimientoEquipoMec.setNomProveedor(nomProveedor);
			datMantenimientoEquipoMec.setUdadMedId_UdadMed(udadMed);
			datMantenimientoEquipoMec.setCantidad(cantidadPago);
			datMantenimientoEquipoMec.setCodTrabajador(codTrabajador);
			datMantenimientoEquipoMec.setCodUdadMed(codUdadMedNomina);
			datMantenimientoEquipoMec.setFechaRegistro(fechaRegistro);
			datMantenimientoEquipoMec.setLaborId_Labor(tarea);
			datMantenimientoEquipoMec.setCodLabor(codLabor);

			dataEquipoMec.add(datMantenimientoEquipoMec);

			// sistema = null;
			// compartimiento = null;
			persEmpr = null;
			mecanico = null;
			conceptoNomina = null;
			udadMed = null;
			codTrabajador = null;
			codUdadMedNomina = null;
			cantidadPago = null;
			codTarea = null;
			tarea = null;
			limpiar_pantalla_mec();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos de fecha de atención, trabajador, unidad de medida, concepto, cantidad tengan valores. "));
		}
	}

	public void limpiar_pantalla_mec() throws Exception {
		txtMecanico.setDisabled(false);
		txtCantidadMec.setDisabled(false);
		txtUdadMedMec.setDisabled(false);
		txtTarea.setDisabled(false);
		txtPersEmprId_PersEmpr.setDisabled(false);

		txtMecanico.setValue(true);
		txtCantidadMec.setValue(true);
		txtUdadMedMec.setValue(true);
		txtTarea.setValue(true);
		txtPersEmprId_PersEmpr.setValue(true);
	}

	public String actionDeletedataEquipoMec(ActionEvent evt) {
		try {

			selectedDatEquipoMec = (DatMantenimientoEquipoMecDTO) (evt.getComponent().getAttributes()
					.get("selectedDatEquipoMec"));

			if (selectedDatEquipoMec.getDatMantenimientoEquipoMecId() == null) {
				dataEquipoMec.remove(selectedDatEquipoMec);
			} else {
				Long datMantenimientoEquipoMecId = new Long(selectedDatEquipoMec.getDatMantenimientoEquipoMecId());
				DatMantenimientoEquipoMec entity = businessDelegatorView
						.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);
				businessDelegatorView.deleteDatMantenimientoEquipoMec(entity);
				dataEquipoMec.remove(selectedDatEquipoMec);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void listener_ConsultaCodLabor() {

		Long idLabor = null;

		if (FacesUtils.checkLong(txtTarea) != null) {
			if (!txtTarea.getValue().equals("")) {
				idLabor = Long.parseLong(txtTarea.getValue().toString());

				try {
					Labor l = businessDelegatorView.getLabor(idLabor);
					txtCodLaborMec.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaUmProducto() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		Long idProducto = null;
		Long almacenId = null;
		Double valorUnit = 0.0;
		Date idFecha = FacesUtils.checkDate(txtFechaProd);
		if (FacesUtils.checkLong(txtProductoId_Producto) != null) {
			if (!txtProductoId_Producto.getValue().equals("")) {
				idProducto = Long.parseLong(txtProductoId_Producto.getValue().toString());

				try {
					Producto p = businessDelegatorView.getProducto(idProducto);
					if (p.getUdadMedByUdadMedProd() != null) {
						txtUdadMedProd.setValue(p.getUdadMedByUdadMedProd().getUdadMedId());

					}
					if (p.getUbicacionesAlmacenId() != null) {
						txtUbAlmacen.setValue(p.getUbicacionesAlmacenId().getUbicacionesAlmacenId());
					}
					if (txtAlmacenId.getValue() != null) {
						almacenId = Long.parseLong(txtAlmacenId.getValue().toString());
					}
					if (idFecha != null && p.getUdadMedByUdadMedProd().getUdadMedId() != null && compania != null
							&& almacenId != null && idProducto != null) {
						valorUnit = businessDelegatorView
								.consultarPrecioPromProducto(idProducto, almacenId, compania, idFecha).doubleValue();

					}
					txtValorUnitarioProd.setValue(valorUnit);
				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodSistema() {

		Long id = null;

		if (FacesUtils.checkLong(txtSistemasEquipoId) != null) {

			if (!txtSistemasEquipoId.getValue().equals("")) {

				id = Long.parseLong(txtSistemasEquipoId.getValue().toString());

				try {
					SistemasEquipo l = businessDelegatorView.getSistemasEquipo(id);
					txtCodSistema.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodSCompartimiento() {

		Long id = null;

		if (FacesUtils.checkLong(txtCompartimientosEquipoId) != null) {

			if (!txtCompartimientosEquipoId.getValue().equals("")) {

				id = Long.parseLong(txtCompartimientosEquipoId.getValue().toString());

				try {
					CompartimientosEquipo l = businessDelegatorView.getCompartimientosEquipo(id);
					txtCodCompartimiento.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodTrabajador() {

		Long idTrabajador = null;
		if (FacesUtils.checkLong(txtMecanico) != null) {
			if (!txtMecanico.getValue().equals("")) {
				idTrabajador = Long.parseLong(txtMecanico.getValue().toString());

				try {
					Trabajador trabajador = businessDelegatorView.getTrabajador(idTrabajador);
					/* valNPass = datPlanLabor.getNPases(); */
					txtCodMecanico.setValue(trabajador.getCodigo());

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

	public void listener_ConsultaCodUdadMedMec() {

		Long idUdadMed = null;
		if (FacesUtils.checkLong(txtUdadMedMec) != null) {
			if (!txtUdadMedMec.getValue().equals("")) {
				idUdadMed = Long.parseLong(txtUdadMedMec.getValue().toString());

				try {
					UdadMed udadMed = businessDelegatorView.getUdadMed(idUdadMed);
					/* valNPass = datPlanLabor.getNPases(); */
					txtCodUdadMedMec.setValue(udadMed.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}

	}

	public void ConsultarTarifaPago() throws Exception {
		// Long compania = 1L;

		Long idCompania = new Long(getCompaniaIdSession());
		Long trabId = Long.parseLong(txtMecanico.getValue().toString());
		Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
		Long idContratista = trabajador.getContratista().getPersEmprId();
		Long idProfesion = trabajador.getProfesion().getProfId();
		Long idCeptoNomina = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedMec);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		BigDecimal tarifaPago = new BigDecimal("0");
		BigDecimal tarifaNoEncontrada = new BigDecimal("0");

		tarifaPago = businessDelegatorView.consultarTarifaProfesion(idCompania, idContratista, idProfesion,
				idCeptoNomina, idUdadMed, idFecha);
		String format = decimalFormat.format(tarifaPago);
		txtValorUnitarioMec.setValue(format);

		if (tarifaPago == null) {
			tarifaNoEncontrada = new BigDecimal("0");
			txtValorUnitarioMec.setValue(tarifaNoEncontrada);

		}

	}

	public void listener_calcularCostoTotal() throws Exception {

		Long idCompania = new Long(getCompaniaIdSession());
		Long trabId = Long.parseLong(txtMecanico.getValue().toString());
		Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
		Long idContratista = trabajador.getContratista().getPersEmprId();
		Long idProfesion = trabajador.getProfesion().getProfId();
		Long idCeptoNomina = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedMec);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		@SuppressWarnings("unused")
		BigDecimal tarifaPagoP = new BigDecimal("0");
		Double result = 0.0;
		tarifaPagoP = businessDelegatorView.consultarTarifaProfesion(idCompania, idContratista, idProfesion,
				idCeptoNomina, idUdadMed, idFecha);

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitarioMec);
		Double cantidadPago = FacesUtils.checkDouble(txtCantidadMec);

		if (valorUnitario != null && cantidadPago != null) {
			result = (valorUnitario * cantidadPago);
			String format = decimalFormat.format(result);
			txtCostoTotalMec.setValue(format);
		} else {
			result = 0.0;
			txtCostoTotalMec.setValue(result);
		}

	}

	/**************** productos ************************/
	public void ConsultarPrecioPromProductoDet() throws Exception {
		// Long compania = 1L;

		Long idCompania = new Long(getCompaniaIdSession());
		Long idProducto = FacesUtils.checkLong(txtProductoId_Producto);
		Long idAlmacen = FacesUtils.checkLong(txtAlmacenId);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedProd);
		Date idFecha = (FacesUtils.checkDate(txtFechaProd));

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		if (idUdadMed != null) {
			try {

				Double tarifaPagox = businessDelegatorView.consultarPrecioPromProducto(idProducto, idAlmacen,
						idCompania, idFecha);
				String format = decimalFormat.format(tarifaPagox);
				txtValorUnitarioProd.setValue(format);
				if (tarifaPagox == null) {
					tarifaPagox = 0.0;
					txtValorUnitarioProd.setValue(tarifaPagox);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
		}
	}

	public void listener_calcularCostoTotalInsumos() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnit = FacesUtils.checkDouble(txtValorUnitarioProd);
		Double cantidadAplicada = FacesUtils.checkDouble(txtCantidadProd);
		Double result = 0.0;

		if (valorUnit != null && cantidadAplicada != null) {
			result = (valorUnit * cantidadAplicada);
			String format = decimalFormat.format(result);
			txtCostoTotalProd.setValue(format);
		} else {
			result = 0.0;
			txtCostoTotalProd.setValue(result);
		}

	}

	public List<DatMantenimientoEquipoProdDTO> geDatMantenimientoEquipoProd1() {

		if (dataEquipoProd == null || dataEquipoProd.size() == 0) {
			return null;
		} else {
			return dataEquipoProd;
		}

	}

	public void action_agregarProductos() throws Exception {
		Date fechaProd = FacesUtils.checkDate(txtFechaProd);
		if (txtProductoId_Producto.getValue() != null && txtUdadMedProd.getValue() != null
				&& txtCantidadProd.getValue() != null && txtUbAlmacen.getValue() != null
				&& txtAlmacenId.getValue() != null && txtConceptoKardex.getValue() != null && fechaProd!=null) {
			Long compania = new Long(getCompaniaIdSession());
			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			Long conceptoKardexId = FacesUtils.checkLong(txtConceptoKardex);
			ConceptoKardex ckardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
			String nombreConceptoKardex = ckardex.getCodigo() + "-" + ckardex.getNombre();
			String tipoM = ckardex.getTipoMovimiento();

			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedProd.getValue().toString());
			// Long jefeMtto = Long.parseLong(txtJefeMtto.getValue().toString());
			// Trabajador trabajador = businessDelegatorView.getTrabajador(jefeMtto);

			Long almacenId = Long.parseLong(txtAlmacenId.getValue().toString());
			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);

			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			String tipoSuministro = (FacesUtils.checkString(txtTipoSuministro));

			Long compartimientosEquipoId = null;
			CompartimientosEquipo compartimientosEquipo = null;
			String codCompEquipos = "";
			if (txtCompartimientosEquipoProdId.getValue() != null) {
				compartimientosEquipoId = FacesUtils.checkLong(txtCompartimientosEquipoProdId);
				compartimientosEquipo = businessDelegatorView.getCompartimientosEquipo(compartimientosEquipoId);
				codCompEquipos = compartimientosEquipo.getNombre();
			}

			Long ubicacionesAlmacenId = null;
			UbicacionesAlmacen ubicacionesAlmacen = null;
			String codUbicacionesAlmacen = "";
			if (txtUbAlmacen.getValue() != null) {
				ubicacionesAlmacenId = Long.parseLong(txtUbAlmacen.getValue().toString());
				ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacenId);
				codUbicacionesAlmacen = ubicacionesAlmacen.getCodigo();
			}

			// String codTrabajador = trabajador.getCodigo();
			String codAlmacen = almacen.getCodigo();
			String codProducto = producto.getCodigo();
			String nomProducto = producto.getNombre();
			String codUdadMed = udadMed.getCodigo();
			Double cantidadAplicada = FacesUtils.checkDouble(txtCantidadProd);
			Double costoTotal = 0.0;
			Double valorUnit = FacesUtils.checkDouble(txtValorUnitarioProd);
			if (valorUnit != null && cantidadAplicada != null) {
				costoTotal = valorUnit * cantidadAplicada;
			}
		
			String descargaInventario = FacesUtils.checkString(txtDescargaInventario);
			Double saldoProducto = 0.0;
			saldoProducto = businessDelegator2View.pr_saldo_prom_producto(productoId, almacenId, compania)
					.doubleValue();

			if (tipoM.equals("SAL") && descargaInventario.equals("SI")) {
				if (saldoProducto >= cantidadAplicada) {
					if (dataEquipoProd == null) {
						dataEquipoProd = new ArrayList<DatMantenimientoEquipoProdDTO>();
					}
					if (dataEquipoProd == null) {
						dataEquipoProd = new ArrayList<DatMantenimientoEquipoProdDTO>();
					}

					DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO = new DatMantenimientoEquipoProdDTO();
					datMantenimientoEquipoProdDTO.setProductoId_Producto(producto);
					datMantenimientoEquipoProdDTO.setUdadMedId_UdadMed(udadMed);
					datMantenimientoEquipoProdDTO.setCodProducto(codProducto);
					datMantenimientoEquipoProdDTO.setNomProducto(nomProducto);
					datMantenimientoEquipoProdDTO.setCodUdadMed(codUdadMed);
					datMantenimientoEquipoProdDTO.setCantidad(cantidadAplicada);
					datMantenimientoEquipoProdDTO.setCostoTotal(costoTotal);
					datMantenimientoEquipoProdDTO.setValorUnitario(valorUnit);
					datMantenimientoEquipoProdDTO.setTipoSuministro(tipoSuministro);
					datMantenimientoEquipoProdDTO.setFechaRegistro(fechaProd);
					datMantenimientoEquipoProdDTO.setAlmacenId(almacen);
					datMantenimientoEquipoProdDTO.setCodAlmacen(codAlmacen);
					datMantenimientoEquipoProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
					datMantenimientoEquipoProdDTO.setNomUbAlmacen(codUbicacionesAlmacen);
					datMantenimientoEquipoProdDTO.setCompartimientosEquipo(compartimientosEquipo);
					datMantenimientoEquipoProdDTO.setCodCompartimientosEquipo(codCompEquipos);
					datMantenimientoEquipoProdDTO.setConceptoKardexId(ckardex);
					datMantenimientoEquipoProdDTO.setNomConceptoKardexId(nombreConceptoKardex);
					datMantenimientoEquipoProdDTO.setPendienteImportacion("NO");
					datMantenimientoEquipoProdDTO.setDescargaInventario(descargaInventario);
					dataEquipoProd.add(datMantenimientoEquipoProdDTO);

					// codCompartimiento=null;
					// codsistema=null;
					// compartimiento=null;
					// sistema=null;
					producto = null;
					udadMedId_UdadMed = null;
					cantidadAplicada = null;
					costoTotal = null;
					codProducto = null;
					codUdadMed = null;
					almacen = null;
					// trabajador = null;
					valorUnit = null;
					codAlmacen = null;
					// codTrabajador = null;
					tipoSuministro = null;

					ubicacionesAlmacenId = null;
					ubicacionesAlmacen = null;
					codUbicacionesAlmacen = null;
					compartimientosEquipoId = null;
					compartimientosEquipo = null;
					codCompEquipos = null;

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!",
							"Verifique que la cantidad del producto sea menor o igual al saldo en la bodega. "));
				}
			} else {
				if (dataEquipoProd == null) {
					dataEquipoProd = new ArrayList<DatMantenimientoEquipoProdDTO>();
				}

				DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO = new DatMantenimientoEquipoProdDTO();
				datMantenimientoEquipoProdDTO.setProductoId_Producto(producto);
				datMantenimientoEquipoProdDTO.setUdadMedId_UdadMed(udadMed);
				datMantenimientoEquipoProdDTO.setCodProducto(codProducto);
				datMantenimientoEquipoProdDTO.setNomProducto(nomProducto);
				datMantenimientoEquipoProdDTO.setCodUdadMed(codUdadMed);
				datMantenimientoEquipoProdDTO.setCantidad(cantidadAplicada);
				datMantenimientoEquipoProdDTO.setCostoTotal(costoTotal);
				datMantenimientoEquipoProdDTO.setValorUnitario(valorUnit);
				datMantenimientoEquipoProdDTO.setTipoSuministro(tipoSuministro);
				datMantenimientoEquipoProdDTO.setFechaRegistro(fechaProd);
				datMantenimientoEquipoProdDTO.setAlmacenId(almacen);
				datMantenimientoEquipoProdDTO.setCodAlmacen(codAlmacen);
				datMantenimientoEquipoProdDTO.setUbicacionesAlmacen(ubicacionesAlmacen);
				datMantenimientoEquipoProdDTO.setNomUbAlmacen(codUbicacionesAlmacen);
				datMantenimientoEquipoProdDTO.setCompartimientosEquipo(compartimientosEquipo);
				datMantenimientoEquipoProdDTO.setCodCompartimientosEquipo(codCompEquipos);
				datMantenimientoEquipoProdDTO.setConceptoKardexId(ckardex);
				datMantenimientoEquipoProdDTO.setNomConceptoKardexId(nombreConceptoKardex);
				datMantenimientoEquipoProdDTO.setPendienteImportacion("NO");
				datMantenimientoEquipoProdDTO.setDescargaInventario(descargaInventario);
				dataEquipoProd.add(datMantenimientoEquipoProdDTO);

				// codCompartimiento=null;
				// codsistema=null;
				// compartimiento=null;
				// sistema=null;
				producto = null;
				udadMedId_UdadMed = null;
				cantidadAplicada = null;
				costoTotal = null;
				codProducto = null;
				codUdadMed = null;
				almacen = null;
				// trabajador = null;
				valorUnit = null;
				codAlmacen = null;
				// codTrabajador = null;
				tipoSuministro = null;

				ubicacionesAlmacenId = null;
				ubicacionesAlmacen = null;
				codUbicacionesAlmacen = null;
				compartimientosEquipoId = null;
				compartimientosEquipo = null;
				codCompEquipos = null;
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos de fecha de almacén, producto, ubicación, unidad de medida y cantidad tengan valores. "));

		}
		limpiar_pantalla_prod();
	}

	public void limpiar_pantalla_prod() throws Exception {
		txtProductoId_Producto.setDisabled(false);
		txtTipoProducto.setDisabled(false);
		txtUdadMedProd.setDisabled(false);
		txtCantidadProd.setDisabled(false);
		txtAlmacenId.setDisabled(false);
		txtUbAlmacen.setDisabled(false);

		txtProductoId_Producto.setValue(null);
		txtTipoProducto.setValue(null);
		txtUdadMedProd.setValue(null);
		txtCantidadProd.setValue(null);

		txtUbAlmacen.setValue(null);
	}

	public String actionDeleteDatEquipoProd(ActionEvent evt) {
		try {

			selectedDatEquipoProd = (DatMantenimientoEquipoProdDTO) (evt.getComponent().getAttributes()
					.get("selectedDatEquipoProd"));

			if (selectedDatEquipoProd.getDatMantenimientoEquipoProdId() == null) {
				dataEquipoProd.remove(selectedDatEquipoProd);
			} else {
				Long datMantenimientoEquipoProdId = new Long(selectedDatEquipoProd.getDatMantenimientoEquipoProdId());
				DatMantenimientoEquipoProd entity = businessDelegatorView
						.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
				businessDelegatorView.deleteDatMantenimientoEquipoProd(entity);
				dataEquipoProd.remove(selectedDatEquipoProd);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_edit(ActionEvent evt) {

		moduloSeleccionado();

		selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoMtto"));
		try {

			Long datMantenimientoEquipoId = selectedListadoMtto.getId_mtto().longValue();
			Object[] condicion = { "datMantenimientoEquipoId", true, datMantenimientoEquipoId, "=" };
			List<DatMantenimientoEquipo> lista = (datMantenimientoEquipoId != null)
					? businessDelegatorView.findByCriteriaInDatMantenimientoEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				if (entity.getResponsableMttoId() != null) {
					txtResponsableMttoId.setValue(entity.getResponsableMttoId().getTrabId());

				}
				txtResponsableMttoId.setDisabled(false);
				txtDescripcionSolicitud.setValue(entity.getDescripcionSolicitud());
				txtDescripcionSolicitud.setDisabled(false);
				txtConductor.setValue(entity.getConductor());
				txtConductor.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				// txtDuracion.setValue(entity.getDuracion());
				// txtDuracion.setDisabled(false);
				txtFechaEntradaTaller.setValue(entity.getFechaEntradaTaller());
				txtFechaEntradaTaller.setDisabled(false);
				txtReporteTecnico.setValue(entity.getReporteTecnico());
				txtReporteTecnico.setDisabled(false);
				txtVidaHora.setDisabled(false);
				// txtVidaDia.setDisabled(false);
				txtVidaKm.setDisabled(false);
				
				txtReporteTecnico.setValue(entity.getReporteTecnico());
				txtReporteTecnico.setDisabled(false);
				
				txtRequiereParadaFabrica.setValue(entity.getRequiereParadaFabrica());
				txtRequiereParadaFabrica.setDisabled(false);
				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCost() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);
				// mantenimiento de maquinaria

				if (moduloActivo.equals("mantenimiento_maquinaria")) {

					compoRequieridoMttoIndustrial = "false";
					compoRequieridoMttoMaquinaria = "true";

					ocultaMttoIndustrial = "none";
					ocultaMttoMaquinaria = "block";

					txtTallerMecanicoId_TallerMecanico.setDisabled(false);
					txtAreaTrabajoId_AreaTrabajo.setDisabled(true);
					txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					txtTagId_Tag.setDisabled(true);
					txtZonasFabricaId_ZonasFabrica.setDisabled(true);

					txtPersEmprId_PersEmpr.setDisabled(false);
					txtTipoPersonal.setDisabled(false);
					txtTipoProducto.setDisabled(false);

				} else {

					ocultaMttoIndustrial = "block";
					ocultaMttoMaquinaria = "none";

					compoRequieridoMttoIndustrial = "true";
					compoRequieridoMttoMaquinaria = "false";

					txtTallerMecanicoId_TallerMecanico.setDisabled(false);
					txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
					txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					txtTagId_Tag.setDisabled(false);
					txtZonasFabricaId_ZonasFabrica.setDisabled(false);

				}

				if (entity.getAreaTrabajo() != null) {
					txtAreaTrabajoId_AreaTrabajo.setValue(entity.getAreaTrabajo().getAreaTrabajoId());

				}

				if (entity.getNivelPrioridad() != null) {
					txtNivelPrioridadId_NivelPrioridad.setValue(entity.getNivelPrioridad().getNivelPrioridadId());
				}

				if (entity.getTag() != null) {
					txtTagId_Tag.setValue(entity.getTag().getTagId());
				}

				if (entity.getZonasFabrica() != null) {
					txtZonasFabricaId_ZonasFabrica.setValue(entity.getZonasFabrica().getZonasFabricaId());
				}

				if (entity.getAgenteCausadorParada() != null) {
					txtAgenteCausadorParadaId_AgenteCausadorParada
							.setValue(entity.getAgenteCausadorParada().getAgenteCausadorParadaId());
				}
				txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);

				if (entity.getEquipo() != null) {
					txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
				}
				txtEquipoId_Equipo.setDisabled(false);

				if (entity.getMotivosEntradaTaller() != null) {
					txtMotivosEntradaTallerId_MotivosEntradaTaller
							.setValue(entity.getMotivosEntradaTaller().getMotivosEntradaTallerId());
				}
				txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);

				if (entity.getTallerMecanico() != null) {
					txtTallerMecanicoId_TallerMecanico.setValue(entity.getTallerMecanico().getTallerMecanicoId());
				}

				if (entity.getTipoMantenimiento() != null) {
					txtTipoMantenimientoId_TipoMantenimiento
							.setValue(entity.getTipoMantenimiento().getTipoMantenimientoId());
				}
				txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);

				if (entity.getTrabajador() != null) {
					txtSolicitante.setValue(entity.getTrabajador().getTrabId());
				}
				txtSolicitante.setDisabled(false);

				txtDatMantenimientoEquipoId.setValue(entity.getDatMantenimientoEquipoId());
				txtDatMantenimientoEquipoId.setDisabled(true);

				txtFechaSalidaTaller.setValue(entity.getFechaSalidaTaller());
				txtFechaSalidaTaller.setDisabled(false);

				Long mantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
				dataEquipoMec = null;
				dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(mantenimientoEquipoId);
				dataEquipoProd = null;
				dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(mantenimientoEquipoId);
				dataPlanRevision = null;
				dataPlanRevision = businessDelegator2View
						.getDataDatMantenimientoEquipoPlanRevisionByMec(mantenimientoEquipoId);

				txtCantidadMec.setDisabled(false);
				txtMecanico.setDisabled(false);
				txtUdadMedMec.setDisabled(false);
				txtFechaRegistro.setDisabled(false);
				btnAgregarMecanico.setDisabled(false);

				txtProductoId_Producto.setDisabled(false);
				txtCantidadProd.setDisabled(false);
				txtFechaProd.setDisabled(false);
				txtUdadMedMec.setDisabled(false);
				btnAgregarProd.setDisabled(false);
				txtDescargaInventario.setDisabled(false);

				Long compania = new Long(getCompaniaIdSession());

				GregorianCalendar cHoy = new GregorianCalendar();
				java.util.Date fechaReg = entity.getFechaEntradaTaller();

				cHoy.setTime(fechaReg);
				int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
				int mesHoy = cHoy.get(java.util.Calendar.MONTH);
				int anoHoy = cHoy.get(java.util.Calendar.YEAR);
				cHoy.set(anoHoy, mesHoy, diaHoy);
				java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

				Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

				if (equipoId != null && !equipoId.toString().isEmpty()) {
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);

					if (equipo.getMedidor() != null) {

						Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
						Long idMedidor = medidor.getMedidorId();

						if (medidor != null) {

							if (medidor.getTipoMedidor().equals("horometro")
									|| medidor.getTipoMedidor().equals("dia")) {

								Double valor = Double.parseDouble(businessDelegatorView
										.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());
								txtVidaActual.setValue(valor);
								txtVidaActual.setDisabled(true);
								if (entity.getVidaHoras() != null) {
									txtVidaHora.setValue(entity.getVidaHoras().doubleValue());
								}
								txtVidaHora.setDisabled(false);
								txtVidaKm.setDisabled(true);
								txtVidaKm.setValue(null);
								// txtVidaDia.setDisabled(true);
								// txtVidaDia.setValue(null);

							} else if (medidor.getTipoMedidor().equals("odometro")) {

								Double valor = Double.parseDouble(businessDelegatorView
										.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

								txtVidaActual.setValue(valor);
								txtVidaActual.setDisabled(true);
								if (entity.getVidaKm() != null) {
									txtVidaKm.setValue(entity.getVidaKm().doubleValue());
								}
								txtVidaKm.setDisabled(false);
								txtVidaHora.setDisabled(true);
								txtVidaHora.setValue(null);
								// txtVidaDia.setDisabled(true);
								// txtVidaDia.setValue(null);

							} else if (medidor.getTipoMedidor().equals("averiado")) {

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
												"El medidor de la maquinaria/equipo se encuentra averiado"));

								txtVidaActual.setDisabled(true);
								txtVidaKm.setDisabled(true);
								txtVidaHora.setDisabled(true);
								// txtVidaDia.setDisabled(true);

								txtVidaActual.setValue(null);
								txtVidaHora.setValue(null);
								txtVidaKm.setValue(null);
								// txtVidaDia.setValue(null);

							}
						}

					} else {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

						txtVidaActual.setDisabled(true);
						txtVidaActual.setValue(null);

						txtVidaHora.setValue(null);
						txtVidaKm.setValue(null);
						// txtVidaDia.setValue(null);

						txtVidaHora.setDisabled(true);
						txtVidaKm.setDisabled(true);
						// txtVidaDia.setDisabled(true);

					}
				}

				txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
			entity_hrt = null;
			entity_equipo = null;
			entity_prdet = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatMantenimientoEquipo == null) && (entity == null)) {
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
			entity = new DatMantenimientoEquipo();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			if (solicitudId != null) {
				Long datSolicitudMttoId = new Long(solicitudId);
				entity.setDatSolicitudMttoId(datSolicitudMttoId);
			}

			if (solicitud != null) {
				entity.setDescripcionSolicitud(solicitud);
			} else {
				entity.setDescripcionSolicitud(FacesUtils.checkString(txtDescripcionSolicitud));
			}

			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				entity.setOrigenDatos("Modulo_TallerAgricola");
			} else {
				entity.setOrigenDatos("Modulo_MttoIndustrial");
			}

			entity.setCierreOt("A");
			entity.setCompania(compania);
			entity.setConductor(FacesUtils.checkLong(txtConductor));
			entity.setTipoOrdenMtto("preventivo");
			entity.setConsecutivo(
					(businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania, "preventivo")));
			entity.setDuracion(FacesUtils.checkDate(txtDuracion));
			entity.setEstado(estado);
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(txtFechaCierreOt));
			entity.setFechaCreacion(date);
			entity.setFechaEntradaTaller(FacesUtils.checkDate(txtFechaEntradaTaller));
			entity.setFechaReaperturaOt(FacesUtils.checkDate(txtFechaReaperturaOt));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrderTrabajo(FacesUtils.checkLong(txtOrderTrabajo));
			entity.setReporteTecnico(FacesUtils.checkString(txtReporteTecnico));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setRequiereParadaFabrica(FacesUtils.checkString(txtRequiereParadaFabrica));
			entity.setFechaSalidaTaller(FacesUtils.checkDate(txtFechaSalidaTaller));

			entity.setAreaTrabajo((FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo))
					: null);
			entity.setNivelPrioridad((FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad) != null)
					? businessDelegatorView.getNivelPrioridad(FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad))
					: null);
			entity.setZonasFabrica((FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica) != null)
					? businessDelegatorView.getZonasFabrica(FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica))
					: null);
			entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId_Tag))
					: null);

			entity.setAgenteCausadorParada(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada))
							: null);
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
					: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setMotivosEntradaTaller(
					(FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller))
							: null);
			entity.setTallerMecanico((FacesUtils.checkLong(txtTallerMecanicoId_TallerMecanico) != null)
					? businessDelegatorView.getTallerMecanico(FacesUtils.checkLong(txtTallerMecanicoId_TallerMecanico))
					: null);
			entity.setTipoMantenimiento(
					(FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento) != null)
							? businessDelegatorView.getTipoMantenimiento(
									FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtSolicitante) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtSolicitante))
					: null);

			entity.setResponsableMttoId((FacesUtils.checkLong(txtResponsableMttoId) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtResponsableMttoId))
					: null);

			entity.setVidaHoras(FacesUtils.checkDouble(txtVidaHora));
			entity.setVidaKm(FacesUtils.checkDouble(txtVidaKm));
			entity.setVidaDias(FacesUtils.checkDouble(txtVidaDia));

			Date fecha = entity.getFechaEntradaTaller();
			Long IdEquipo = entity.getEquipo().getEquipoId();

			String planesSeleccionadas = "";
			String cadena = "";

			if (dataPlanRevision != null && dataPlanRevision.size() >= 0) {
				for (DatMantenimientoEquipoPlanRevisionDTO data1 : dataPlanRevision) {
					planesSeleccionadas += ","
							+ data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();
					Long idPlan = data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

					Object[] condicionPlan = { "planRevisionEquipo.planRevisionEquipoId", true, idPlan, "=",
							"equipo.equipoId", true, equipoId, "=" };
					List<PlanRevisionEquipoDet> listaPlan = (idPlan != null)
							? businessDelegatorView.findByCriteriaInPlanRevisionEquipoDet(condicionPlan, null, null)
							: null;
					if (listaPlan != null && listaPlan.size() > 0) {
						PlanRevisionEquipoDet entityPlan = listaPlan.get(0);
						Double horAnterior = 0.0;
						Double kmAnterior = 0.0;
						Double diferencia = 0.0;
						Double horActual = 0.0;
						Double kmActual = 0.0;

						if (entity.getVidaHoras() != null && entity.getVidaHoras() > 0) {
							if (entityPlan.getHorasUltimoServicio() != null) {
								horAnterior = entityPlan.getHorasUltimoServicio();
							}
							horActual = entity.getVidaHoras();
							diferencia = horActual - horAnterior;

						}
						if (entity.getVidaKm() != null && entity.getVidaKm() > 0) {
							if (entityPlan.getKmUltimoServicio() != null) {
								kmAnterior = entityPlan.getKmUltimoServicio();
							}
							kmActual = entity.getVidaKm();
							diferencia = kmActual - kmAnterior;
						}
						if (entity.getDifTiempoMttoAnteriorActual() == null
								|| entity.getDifTiempoMttoAnteriorActual() == 0) {
							entity.setDifTiempoMttoAnteriorActual(diferencia);
						}
					}
				}

				businessDelegatorView.saveDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd,
						dataPlanRevision, entity_hrt);

				cadena = "0" + planesSeleccionadas;
				Double vidaHoras = FacesUtils.checkDouble(txtVidaHora);
				Double vidaKm = FacesUtils.checkDouble(txtVidaKm);
				if (vidaHoras == null) {
					vidaHoras = 0.0;
				}
				if (vidaKm == null) {
					vidaKm = 0.0;
				}
				if (vidaKm > 0 || vidaHoras > 0) {
					businessDelegator2View.pr_actualizar_plan_revision_det(IdEquipo, fecha, vidaHoras, vidaKm, cadena,
							"Ejecutado");
				}
				if (vidaKm == 0 && vidaHoras == 0) {
					businessDelegator2View.pr_actualizar_plan_revision_det(IdEquipo, fecha, vidaHoras, vidaKm, cadena,
							"Programado");
				}

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
						+ (businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania, "preventivo")
								- 1));

			} else {

				businessDelegatorView.saveDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd,
						dataPlanRevision, entity_hrt);

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
						+ (businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania, "preventivo")
								- 1));
			}

			action_clear2();

		} catch (Exception e) {

			entity = null;
			entity_hrt = null;
			entity_equipo = null;
			entity_prdet = null;
			equipo = null;
			// medidor = null;

			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long datMantenimientoEquipoId = new Long(selectedListadoMtto.getId_mtto().longValue());
				entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			String estado = "A";

			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				entity.setOrigenDatos("Modulo_TallerAgricola");
			} else {
				entity.setOrigenDatos("Modulo_MttoIndustrial");
			}

			entity.setDescripcionSolicitud(FacesUtils.checkString(txtDescripcionSolicitud));
			// entity.setCierreOt(FacesUtils.checkString(txtCierreOt));
			entity.setCompania(compania);
			entity.setConductor(FacesUtils.checkLong(txtConductor));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDuracion(FacesUtils.checkDate(txtDuracion));
			entity.setEstado(estado);
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(txtFechaCierreOt));
			entity.setFechaEntradaTaller(FacesUtils.checkDate(txtFechaEntradaTaller));
			entity.setFechaModificacion(date);
			entity.setFechaReaperturaOt(FacesUtils.checkDate(txtFechaReaperturaOt));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrderTrabajo(FacesUtils.checkLong(txtOrderTrabajo));
			entity.setReporteTecnico(FacesUtils.checkString(txtReporteTecnico));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setVidaHoras(FacesUtils.checkDouble(txtVidaHora));
			entity.setVidaDias(FacesUtils.checkDouble(txtVidaDia));
			entity.setVidaKm(FacesUtils.checkDouble(txtVidaKm));
			entity.setFechaSalidaTaller(FacesUtils.checkDate(txtFechaSalidaTaller));

			entity.setRequiereParadaFabrica(FacesUtils.checkString(txtRequiereParadaFabrica));
			entity.setAreaTrabajo((FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo))
					: null);
			entity.setNivelPrioridad((FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad) != null)
					? businessDelegatorView.getNivelPrioridad(FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad))
					: null);
			entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId_Tag))
					: null);
			entity.setZonasFabrica((FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica) != null)
					? businessDelegatorView.getZonasFabrica(FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica))
					: null);

			entity.setAgenteCausadorParada(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada))
							: null);
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
					: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setMotivosEntradaTaller(
					(FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller))
							: null);

			entity.setTallerMecanico((FacesUtils.checkLong(txtTallerMecanicoId_TallerMecanico) != null)
					? businessDelegatorView.getTallerMecanico(FacesUtils.checkLong(txtTallerMecanicoId_TallerMecanico))
					: null);
			entity.setTipoMantenimiento(
					(FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento) != null)
							? businessDelegatorView.getTipoMantenimiento(
									FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtSolicitante) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtSolicitante))
					: null);
			entity.setResponsableMttoId((FacesUtils.checkLong(txtResponsableMttoId) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtResponsableMttoId))
					: null);

			Date fecha = entity.getFechaEntradaTaller();
			Long IdEquipo = entity.getEquipo().getEquipoId();

			String planesSeleccionadas = "";
			String cadena = "";

			if (dataPlanRevision != null && dataPlanRevision.size() >= 0) {
				for (DatMantenimientoEquipoPlanRevisionDTO data1 : dataPlanRevision) {
					planesSeleccionadas += ","
							+ data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();
					Long idPlan = data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

					Object[] condicionPlan = { "planRevisionEquipo.planRevisionEquipoId", true, idPlan, "=",
							"equipo.equipoId", true, equipoId, "=" };
					List<PlanRevisionEquipoDet> listaPlan = (idPlan != null)
							? businessDelegatorView.findByCriteriaInPlanRevisionEquipoDet(condicionPlan, null, null)
							: null;
					if (listaPlan != null && listaPlan.size() > 0) {
						PlanRevisionEquipoDet entityPlan = listaPlan.get(0);
						Double horAnterior = 0.0;
						Double kmAnterior = 0.0;
						Double diferencia = 0.0;
						Double horActual = 0.0;
						Double kmActual = 0.0;

						if (entity.getVidaHoras() != null && entity.getVidaHoras() > 0) {
							if (entityPlan.getHorasUltimoServicio() != null) {
								horAnterior = entityPlan.getHorasUltimoServicio();
							}
							horActual = entity.getVidaHoras();
							diferencia = horActual - horAnterior;

						}
						if (entity.getVidaKm() != null && entity.getVidaKm() > 0) {
							if (entityPlan.getKmUltimoServicio() != null) {
								kmAnterior = entityPlan.getKmUltimoServicio();
							}
							kmActual = entity.getVidaKm();
							diferencia = kmActual - kmAnterior;
						}
						if (entity.getDifTiempoMttoAnteriorActual() == null
								|| entity.getDifTiempoMttoAnteriorActual() == 0) {
							entity.setDifTiempoMttoAnteriorActual(diferencia);
						}
					}
				}
				businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd,
						dataPlanRevision);
				cadena = "0" + planesSeleccionadas;
				Double vidaHoras = FacesUtils.checkDouble(txtVidaHora);
				Double vidaKm = FacesUtils.checkDouble(txtVidaKm);
				if (vidaHoras == null) {
					vidaHoras = 0.0;
				}
				if (vidaKm == null) {
					vidaKm = 0.0;
				}
				if (vidaKm > 0 || vidaHoras > 0) {
					businessDelegator2View.pr_actualizar_plan_revision_det(IdEquipo, fecha, vidaHoras, vidaKm, cadena,
							"Ejecutado");
				}
				if (vidaKm == 0 && vidaHoras == 0) {
					businessDelegator2View.pr_actualizar_plan_revision_det(IdEquipo, fecha, vidaHoras, vidaKm, cadena,
							"Programado");
				}
			} else {
				businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd,
						dataPlanRevision);
			}

			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedListadoMtto.getId_mtto().longValue());
				entity = businessDelegatorView.getDatMantenimientoEquipo(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			Long mantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
			dataEquipoMec = null;
			dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(mantenimientoEquipoId);
			dataEquipoProd = null;
			dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(mantenimientoEquipoId);

			businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd, null);

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

		action_clear();
		selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoMtto"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_cierreReaperturaOt(ActionEvent evt) {

		selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoMtto"));

		try {

			Long id = new Long(selectedListadoMtto.getId_mtto().longValue());
			entity = businessDelegatorView.getDatMantenimientoEquipo(id);

			if (entity.getCierreOt().equals("A")) {
				Date fechaSalidaTaller = entity.getFechaSalidaTaller();
				Date date = new Date();
				entity.setFechaCierreOt(date);
				entity.setCierreOt("C");

				Long equipoId = 0L;
				if (entity.getEquipo() != null) {
					equipoId = entity.getEquipo().getEquipoId();
				}
				// Long mantenimientoEquipoId = id
				// FacesUtils.checkLong(txtDatMantenimientoEquipoId);
				dataEquipoMec = null;
				dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(id);
				dataEquipoProd = null;
				dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(id);
				dataPlanRevision = null;
				dataPlanRevision = businessDelegator2View.getDataDatMantenimientoEquipoPlanRevisionByMec(id);

				String planesSeleccionadas = "";
				String cadena = "";
				if (dataPlanRevision != null && dataPlanRevision.size() >= 0) {
					for (DatMantenimientoEquipoPlanRevisionDTO data1 : dataPlanRevision) {
						planesSeleccionadas += ","
								+ data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

						Long idPlan = data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

						Object[] condicionPlan = { "planRevisionEquipo.planRevisionEquipoId", true, idPlan, "=",
								"equipo.equipoId", true, equipoId, "=" };
						List<PlanRevisionEquipoDet> listaPlan = (idPlan != null)
								? businessDelegatorView.findByCriteriaInPlanRevisionEquipoDet(condicionPlan, null, null)
								: null;
						if (listaPlan != null && listaPlan.size() > 0) {
							PlanRevisionEquipoDet entityPlan = listaPlan.get(0);
							Double horAnterior = 0.0;
							Double kmAnterior = 0.0;
							Double diferencia = 0.0;
							Double horActual = 0.0;
							Double kmActual = 0.0;

							if (entity.getVidaHoras() != null && entity.getVidaHoras() > 0) {
								if (entityPlan.getHorasUltimoServicio() != null) {
									horAnterior = entityPlan.getHorasUltimoServicio();
								}
								horActual = entity.getVidaHoras();
								diferencia = horActual - horAnterior;

							}
							if (entity.getVidaKm() != null && entity.getVidaKm() > 0) {

								if (entityPlan.getKmUltimoServicio() != null) {
									kmAnterior = entityPlan.getKmUltimoServicio();
								}
								kmActual = entity.getVidaKm();
								diferencia = kmActual - kmAnterior;
							}
							if (entity.getDifTiempoMttoAnteriorActual() == null
									|| entity.getDifTiempoMttoAnteriorActual() == 0) {
								entity.setDifTiempoMttoAnteriorActual(diferencia);
							}
						}

					}
					if (dataEquipoProd != null && dataEquipoProd.size() >= 0) {
						for (DatMantenimientoEquipoProdDTO data1 : dataEquipoProd) {
							DatMantenimientoEquipoProd entityMttoProd = businessDelegatorView.getDatMantenimientoEquipoProd(data1.getDatMantenimientoEquipoProdId());
							entityMttoProd.setDescargaInventario("SI");
						}
					}
					businessDelegatorView.updateDatMantenimientoEquipo(entity, null, null,
							null);

					cadena = "0" + planesSeleccionadas;
					Double vidaHoras = entity.getVidaHoras();
					Double vidaKm = entity.getVidaKm();
					if (vidaHoras == null) {
						vidaHoras = 0.0;
					}
					if (vidaKm == null) {
						vidaKm = 0.0;
					}

					if (vidaKm > 0 || vidaHoras > 0) {
						businessDelegator2View.pr_actualizar_plan_revision_det(equipoId, fechaSalidaTaller, vidaHoras,
								vidaKm, cadena, "Sin Programar");
					}
					if (vidaKm == 0 && vidaHoras == 0) {
						businessDelegator2View.pr_actualizar_plan_revision_det(equipoId, fechaSalidaTaller, vidaHoras,
								vidaKm, cadena, "Programado");
					}

				}

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYCLOSEOT);
				action_clear();
				data = null;

			} else {

				Date date = new Date();
				entity.setFechaReaperturaOt(date);
				entity.setCierreOt("A");
				Date fechaSalidaTaller = entity.getFechaSalidaTaller();

				entity.setFechaCierreOt(date);

				Long equipoId = 0L;
				if (entity.getEquipo() != null) {
					equipoId = entity.getEquipo().getEquipoId();
				}
				Long mantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
				dataEquipoMec = null;
				dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(id);
				dataEquipoProd = null;
				dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(id);
				dataPlanRevision = null;
				dataPlanRevision = businessDelegator2View.getDataDatMantenimientoEquipoPlanRevisionByMec(id);

				String planesSeleccionadas = "";
				String cadena = "";
				if (dataPlanRevision != null && dataPlanRevision.size() >= 0) {
					for (DatMantenimientoEquipoPlanRevisionDTO data1 : dataPlanRevision) {
						planesSeleccionadas += ","
								+ data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

						Long idPlan = data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

						Object[] condicionPlan = { "planRevisionEquipo.planRevisionEquipoId", true, idPlan, "=",
								"equipo.equipoId", true, equipoId, "=" };
						List<PlanRevisionEquipoDet> listaPlan = (idPlan != null)
								? businessDelegatorView.findByCriteriaInPlanRevisionEquipoDet(condicionPlan, null, null)
								: null;
						if (listaPlan != null && listaPlan.size() > 0) {
							PlanRevisionEquipoDet entityPlan = listaPlan.get(0);
							Double horAnterior = 0.0;
							Double kmAnterior = 0.0;
							Double diferencia = 0.0;
							Double horActual = 0.0;
							Double kmActual = 0.0;

							if (entity.getVidaHoras() != null && entity.getVidaHoras() > 0) {

								if (entityPlan.getHorasUltimoServicio() != null) {
									horAnterior = entityPlan.getHorasUltimoServicio();
								}
								horActual = entity.getVidaHoras();
								diferencia = horActual - horAnterior;

							}
							if (entity.getVidaKm() != null && entity.getVidaKm() > 0) {
								if (entityPlan.getKmUltimoServicio() != null) {
									kmAnterior = entityPlan.getKmUltimoServicio();
								}
								kmActual = entity.getVidaKm();
								diferencia = kmActual - kmAnterior;
							}
							if (entity.getDifTiempoMttoAnteriorActual() == null
									|| entity.getDifTiempoMttoAnteriorActual() == 0) {
								entity.setDifTiempoMttoAnteriorActual(diferencia);
							}
						}

					}
					if (dataEquipoProd != null && dataEquipoProd.size() >= 0) {
						for (DatMantenimientoEquipoProdDTO data1 : dataEquipoProd) {
							DatMantenimientoEquipoProd entityMttoProd = businessDelegatorView.getDatMantenimientoEquipoProd(data1.getDatMantenimientoEquipoProdId());
							entityMttoProd.setDescargaInventario("NO");
						}
					}
					businessDelegatorView.updateDatMantenimientoEquipo(entity, null, null,
							null);

					cadena = "0" + planesSeleccionadas;
					Double vidaHoras = entity.getVidaHoras();
					Double vidaKm = entity.getVidaKm();
					if (vidaHoras == null) {
						vidaHoras = 0.0;
					}
					if (vidaKm == null) {
						vidaKm = 0.0;
					}

					if (vidaKm > 0 || vidaHoras > 0) {
						businessDelegator2View.pr_actualizar_plan_revision_det(equipoId, fechaSalidaTaller, vidaHoras,
								vidaKm, cadena, "Ejecutado");
					}
					if (vidaKm == 0 && vidaHoras == 0) {
						businessDelegator2View.pr_actualizar_plan_revision_det(equipoId, fechaSalidaTaller, vidaHoras,
								vidaKm, cadena, "Programado");
					}

				}

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYOPENOT);
				action_clear();
				data = null;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
					.get("selectedListadoMtto"));

			Long datMantenimientoEquipoId = new Long(selectedListadoMtto.getId_mtto().longValue());
			entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);

			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatMantenimientoEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_delete_master() {
		try {
			Long datMantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
			entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatMantenimientoEquipo = (DatMantenimientoEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatMantenimientoEquipo"));

			Long datMantenimientoEquipoId = new Long(selectedDatMantenimientoEquipo.getDatMantenimientoEquipoId());
			entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);
			businessDelegatorView.deleteDatMantenimientoEquipo(entity);
			data.remove(selectedDatMantenimientoEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String cierreOt, Long compania, Long conductor, Long consecutivo,
			Long datMantenimientoEquipoId, Date duracion, String estado, Date fechaAnulacion, Date fechaCierreOt,
			Date fechaCreacion, Date fechaEntradaTaller, Date fechaModificacion, Date fechaReaperturaOt,
			String observacionAnularReg, Long orderTrabajo, String reporteTecnico, Long usuarioDigitacion,
			Double vidaHoras, Double vidaKm, Long agenteCausadorParadaId_AgenteCausadorParada, Long centCostId_CentCost,
			Long equipoId_Equipo, Long motivosEntradaTallerId_MotivosEntradaTaller,
			Long planRevisionEquipoId_PlanRevisionEquipo, Long tallerMecanicoId_TallerMecanico,
			Long tipoMantenimientoId_TipoMantenimiento, Long trabId_Trabajador, Date fechaSalidaTaller)
			throws Exception {
		try {
			entity.setCierreOt(FacesUtils.checkString(cierreOt));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConductor(FacesUtils.checkLong(conductor));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDuracion(FacesUtils.checkDate(duracion));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(fechaCierreOt));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaEntradaTaller(FacesUtils.checkDate(fechaEntradaTaller));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaReaperturaOt(FacesUtils.checkDate(fechaReaperturaOt));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setOrderTrabajo(FacesUtils.checkLong(orderTrabajo));
			entity.setReporteTecnico(FacesUtils.checkString(reporteTecnico));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setVidaHoras(FacesUtils.checkDouble(vidaHoras));
			entity.setVidaKm(FacesUtils.checkDouble(vidaKm));
			entity.setFechaSalidaTaller(FacesUtils.checkDate(fechaSalidaTaller));
			businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatMantenimientoEquipoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public void onCellEditManObra(CellEditEvent event) throws Exception {

		selectedDatEquipoMec = (DatMantenimientoEquipoMecDTO) (event.getComponent().getAttributes()
				.get("selectedDatEquipoMec"));

		if (selectedDatEquipoMec.getDatMantenimientoEquipoMecId() != null) {

			Long datMantenimientoEquipoMecId = selectedDatEquipoMec.getDatMantenimientoEquipoMecId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long datMantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityDatMantenimientoEquipoMec = null;
				Date fechaModificacion = new Date();

				entityDatMantenimientoEquipoMec = businessDelegatorView
						.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);

				if (columnaCell.equals("Fecha de atención")) {

					entityDatMantenimientoEquipoMec.setFechaRegistro((Date) newValue);

				} else if (columnaCell.equals("Mecánico")) {

					Long trabajadorId = new Long(event.getNewValue().toString());
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

					entityDatMantenimientoEquipoMec.setTrabajador(trabajador);

				} else if (columnaCell.equals("Proveedor")) {

					Long persEmprId = new Long(event.getNewValue().toString());
					PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);

					entityDatMantenimientoEquipoMec.setContratistaId(persEmpr);

				} else if (columnaCell.equals("Tarea")) {

					Long LaborId = new Long(event.getNewValue().toString());
					Labor labor = businessDelegatorView.getLabor(LaborId);

					entityDatMantenimientoEquipoMec.setLabor(labor);

				} else if (columnaCell.equals("Sistema")) {

					Long sistemasEquipoId = new Long(event.getNewValue().toString());
					SistemasEquipo sistemasEquipo = businessDelegatorView.getSistemasEquipo(sistemasEquipoId);

					entityDatMantenimientoEquipoMec.setSistemasEquipo(sistemasEquipo);

				} else if (columnaCell.equals("Compartimiento")) {

					Long comEquipoId = new Long(event.getNewValue().toString());
					CompartimientosEquipo compartimientosEquipo = businessDelegatorView
							.getCompartimientosEquipo(comEquipoId);

					entityDatMantenimientoEquipoMec.setCompartimientosEquipo(compartimientosEquipo);

				} else if (columnaCell.equals("HoraIni")) {

					entityDatMantenimientoEquipoMec.setHoraIniMec((Date) newValue);

				} else if (columnaCell.equals("HoraFin")) {

					entityDatMantenimientoEquipoMec.setHoraFinMec((Date) newValue);

				} else if (columnaCell.equals("Cepto Nómina")) {

					Long conceptoNominaId = new Long(event.getNewValue().toString());
					ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);

					entityDatMantenimientoEquipoMec.setConceptoNomina(conceptoNomina);

				} else if (columnaCell.equals("U.M(Pago)")) {

					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

					entityDatMantenimientoEquipoMec.setUdadMed(udadMed);

				} else if (columnaCell.equals("Cantidad")) {

					entityDatMantenimientoEquipoMec.setCantidad((Double) newValue);

				} else if (columnaCell.equals("Tarifa")) {

					entityDatMantenimientoEquipoMec.setValorUnitario((Double) newValue);

				} else if (columnaCell.equals("C. Total")) {

					entityDatMantenimientoEquipoMec.setCostoTotal((Double) newValue);

				} else if (columnaCell.equals("T. Personal")) {

					entityDatMantenimientoEquipoMec.setTipoPersonal((String) newValue);

				}

				entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);
				entityDatMantenimientoEquipoMec.setDatMantenimientoEquipo(entity);
				entityDatMantenimientoEquipoMec.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateDatMantenimientoEquipoMec(entityDatMantenimientoEquipoMec);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataEquipoMec = null;
				entityDatMantenimientoEquipoMec = null;
				selectedDatEquipoMec = null;

				dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(datMantenimientoEquipoId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditProd(CellEditEvent event) throws Exception {

		selectedDatEquipoProd = (DatMantenimientoEquipoProdDTO) (event.getComponent().getAttributes()
				.get("selectedDatEquipoProd"));

		if (selectedDatEquipoProd.getDatMantenimientoEquipoProdId() != null) {

			Long datMantenimientoEquipoProdId = selectedDatEquipoProd.getDatMantenimientoEquipoProdId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long datMantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null) {

				entityDatMantenimientoEquipoProd = null;
				Date fechaModificacion = new Date();

				entityDatMantenimientoEquipoProd = businessDelegatorView
						.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);

				if (columnaCell.equals("Almacén")) {

					Long almacenId = new Long(event.getNewValue().toString());
					Almacen almacen = businessDelegatorView.getAlmacen(almacenId);

					entityDatMantenimientoEquipoProd.setAlmacenId(almacen);

				} else if (columnaCell.equals("Producto")) {

					Long productoId = new Long(event.getNewValue().toString());
					Producto producto = businessDelegatorView.getProducto(productoId);

					entityDatMantenimientoEquipoProd.setProducto(producto);

				} else if (columnaCell.equals("U. Medida")) {

					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);

					entityDatMantenimientoEquipoProd.setUdadMed(udadMed);

				} else if (columnaCell.equals("Cantidad")) {

					entityDatMantenimientoEquipoProd.setCantidad((Double) newValue);

				} else if (columnaCell.equals("Valor unitario")) {

					entityDatMantenimientoEquipoProd.setValorUnitario((Double) newValue);

				} else if (columnaCell.equals("T. Suministro")) {

					entityDatMantenimientoEquipoProd.setTipoSuministro((String) newValue);

				} else if (columnaCell.equals("Ubicación")) {

					Long ubAlmacen = new Long(event.getNewValue().toString());
					UbicacionesAlmacen ubicacionesAlmacen = businessDelegator2View.getUbicacionesAlmacen(ubAlmacen);

					entityDatMantenimientoEquipoProd.setUbicacionesAlmacen(ubicacionesAlmacen);

				} else if (columnaCell.equals("Compartimiento")) {

					Long comEquipoId = new Long(event.getNewValue().toString());
					CompartimientosEquipo comEquipo = businessDelegatorView.getCompartimientosEquipo(comEquipoId);

					entityDatMantenimientoEquipoProd.setCompartimientosEquipo(comEquipo);
				} else if (columnaCell.equals("Descarga Inventario")) {

					entityDatMantenimientoEquipoProd.setDescargaInventario((String) newValue);

				}

				entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);
				entityDatMantenimientoEquipoProd.setDatMantenimientoEquipo(entity);
				entityDatMantenimientoEquipoProd.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateDatMantenimientoEquipoProd(entityDatMantenimientoEquipoProd);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataEquipoProd = null;
				entityDatMantenimientoEquipoProd = null;
				selectedDatEquipoProd = null;

				dataEquipoProd = businessDelegatorView
						.getDataDatMantenimientoEquipoProdByProd(datMantenimientoEquipoId);
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}
	}

	public InputText getTxtCierreOt() {
		return txtCierreOt;
	}

	public void setTxtCierreOt(InputText txtCierreOt) {
		this.txtCierreOt = txtCierreOt;
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

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtOrderTrabajo() {
		return txtOrderTrabajo;
	}

	public void setTxtOrderTrabajo(InputText txtOrderTrabajo) {
		this.txtOrderTrabajo = txtOrderTrabajo;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputText getTxtVidaKm() {
		return txtVidaKm;
	}

	public void setTxtVidaKm(InputText txtVidaKm) {
		this.txtVidaKm = txtVidaKm;
	}

	public SelectOneMenu getTxtMotivosEntradaTallerId_MotivosEntradaTaller() {
		return txtMotivosEntradaTallerId_MotivosEntradaTaller;
	}

	public void setTxtMotivosEntradaTallerId_MotivosEntradaTaller(
			SelectOneMenu txtMotivosEntradaTallerId_MotivosEntradaTaller) {
		this.txtMotivosEntradaTallerId_MotivosEntradaTaller = txtMotivosEntradaTallerId_MotivosEntradaTaller;
	}

	public SelectOneMenu getTxtPlanRevisionEquipoId_PlanRevisionEquipo() {
		return txtPlanRevisionEquipoId_PlanRevisionEquipo;
	}

	public void setTxtPlanRevisionEquipoId_PlanRevisionEquipo(
			SelectOneMenu txtPlanRevisionEquipoId_PlanRevisionEquipo) {
		this.txtPlanRevisionEquipoId_PlanRevisionEquipo = txtPlanRevisionEquipoId_PlanRevisionEquipo;
	}

	public SelectOneMenu getTxtTallerMecanicoId_TallerMecanico() {
		return txtTallerMecanicoId_TallerMecanico;
	}

	public void setTxtTallerMecanicoId_TallerMecanico(SelectOneMenu txtTallerMecanicoId_TallerMecanico) {
		this.txtTallerMecanicoId_TallerMecanico = txtTallerMecanicoId_TallerMecanico;
	}

	public SelectOneMenu getTxtTipoMantenimientoId_TipoMantenimiento() {
		return txtTipoMantenimientoId_TipoMantenimiento;
	}

	public void setTxtTipoMantenimientoId_TipoMantenimiento(SelectOneMenu txtTipoMantenimientoId_TipoMantenimiento) {
		this.txtTipoMantenimientoId_TipoMantenimiento = txtTipoMantenimientoId_TipoMantenimiento;
	}

	public Calendar getTxtDuracion() {
		return txtDuracion;
	}

	public void setTxtDuracion(Calendar txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public Calendar getTxtFechaCierreOt() {
		return txtFechaCierreOt;
	}

	public void setTxtFechaCierreOt(Calendar txtFechaCierreOt) {
		this.txtFechaCierreOt = txtFechaCierreOt;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaEntradaTaller() {
		return txtFechaEntradaTaller;
	}

	public void setTxtFechaEntradaTaller(Calendar txtFechaEntradaTaller) {
		this.txtFechaEntradaTaller = txtFechaEntradaTaller;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaReaperturaOt() {
		return txtFechaReaperturaOt;
	}

	public void setTxtFechaReaperturaOt(Calendar txtFechaReaperturaOt) {
		this.txtFechaReaperturaOt = txtFechaReaperturaOt;
	}

	public InputText getTxtDatMantenimientoEquipoId() {
		return txtDatMantenimientoEquipoId;
	}

	public void setTxtDatMantenimientoEquipoId(InputText txtDatMantenimientoEquipoId) {
		this.txtDatMantenimientoEquipoId = txtDatMantenimientoEquipoId;
	}

	public List<DatMantenimientoEquipoDTO> getData() {
		try {
			if (data == null) {
				moduloSeleccionado();
				String modulo = origendatos;
				data = businessDelegatorView.getDataDatMantenimientoEquipo(modulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatMantenimientoEquipoDTO> datMantenimientoEquipoDTO) {
		this.data = datMantenimientoEquipoDTO;
	}

	public DatMantenimientoEquipoDTO getSelectedDatMantenimientoEquipo() {
		return selectedDatMantenimientoEquipo;
	}

	public void setSelectedDatMantenimientoEquipo(DatMantenimientoEquipoDTO datMantenimientoEquipo) {
		this.selectedDatMantenimientoEquipo = datMantenimientoEquipo;
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

	public CommandButton getBtnAgregarProd() {
		return btnAgregarProd;
	}

	public void setBtnAgregarProd(CommandButton btnAgregarProd) {
		this.btnAgregarProd = btnAgregarProd;
	}

	public SelectOneMenu getTxtConductor() {
		return txtConductor;
	}

	public void setTxtConductor(SelectOneMenu txtConductor) {
		this.txtConductor = txtConductor;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputTextarea getTxtReporteTecnico() {
		return txtReporteTecnico;
	}

	public void setTxtReporteTecnico(InputTextarea txtReporteTecnico) {
		this.txtReporteTecnico = txtReporteTecnico;
	}

	public SelectOneMenu getTxtAgenteCausadorParadaId_AgenteCausadorParada() {
		return txtAgenteCausadorParadaId_AgenteCausadorParada;
	}

	public void setTxtAgenteCausadorParadaId_AgenteCausadorParada(
			SelectOneMenu txtAgenteCausadorParadaId_AgenteCausadorParada) {
		this.txtAgenteCausadorParadaId_AgenteCausadorParada = txtAgenteCausadorParadaId_AgenteCausadorParada;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtSolicitante() {
		return txtSolicitante;
	}

	public void setTxtSolicitante(SelectOneMenu txtSolicitante) {
		this.txtSolicitante = txtSolicitante;
	}

	public InputText getTxtCantidadMec() {
		return txtCantidadMec;
	}

	public void setTxtCantidadMec(InputText txtCantidadMec) {
		this.txtCantidadMec = txtCantidadMec;
	}

	public InputText getTxtCostoTotalMec() {
		return txtCostoTotalMec;
	}

	public void setTxtCostoTotalMec(InputText txtCostoTotalMec) {
		this.txtCostoTotalMec = txtCostoTotalMec;
	}

	public InputText getTxtValorUnitarioMec() {
		return txtValorUnitarioMec;
	}

	public void setTxtValorUnitarioMec(InputText txtValorUnitarioMec) {
		this.txtValorUnitarioMec = txtValorUnitarioMec;
	}

	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public SelectOneMenu getTxtMecanico() {
		return txtMecanico;
	}

	public void setTxtMecanico(SelectOneMenu txtMecanico) {
		this.txtMecanico = txtMecanico;
	}

	public SelectOneMenu getTxtUdadMedMec() {
		return txtUdadMedMec;
	}

	public void setTxtUdadMedMec(SelectOneMenu txtUdadMedMec) {
		this.txtUdadMedMec = txtUdadMedMec;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public CommandButton getBtnAgregarMecanico() {
		return btnAgregarMecanico;
	}

	public void setBtnAgregarMecanico(CommandButton btnAgregarMecanico) {
		this.btnAgregarMecanico = btnAgregarMecanico;
	}

	public SelectOneMenu getTxtAlmacenId() {
		return txtAlmacenId;
	}

	public void setTxtAlmacenId(SelectOneMenu txtAlmacenId) {
		this.txtAlmacenId = txtAlmacenId;
	}

	public InputText getTxtCantidadProd() {
		return txtCantidadProd;
	}

	public void setTxtCantidadProd(InputText txtCantidadProd) {
		this.txtCantidadProd = txtCantidadProd;
	}

	public InputText getTxtCostoTotalProd() {
		return txtCostoTotalProd;
	}

	public void setTxtCostoTotalProd(InputText txtCostoTotalProd) {
		this.txtCostoTotalProd = txtCostoTotalProd;
	}

	public InputText getTxtValorUnitarioProd() {
		return txtValorUnitarioProd;
	}

	public void setTxtValorUnitarioProd(InputText txtValorUnitarioProd) {
		this.txtValorUnitarioProd = txtValorUnitarioProd;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public SelectOneMenu getTxtJefeMtto() {
		return txtJefeMtto;
	}

	public void setTxtJefeMtto(SelectOneMenu txtJefeMtto) {
		this.txtJefeMtto = txtJefeMtto;
	}

	public SelectOneMenu getTxtUdadMedProd() {
		return txtUdadMedProd;
	}

	public void setTxtUdadMedProd(SelectOneMenu txtUdadMedProd) {
		this.txtUdadMedProd = txtUdadMedProd;
	}

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",

						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"

				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(),
							equipo.getCodigo() + "-" + equipo.getNombre());
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

	public SelectItem[] getSelectCentCost() {

		if (centCost == null || centCost.size() == 0) {

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

	public SelectItem[] getSelectMotivoEntradaTaller() {

		if (motivoEntradaTaller == null || motivoEntradaTaller.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<MotivosEntradaTaller> lista = businessDelegatorView.findByCriteriaInMotivosEntradaTaller(condicion,
						null, null);
				selectMotivoEntradaTaller = new SelectItem[lista.size()];

				int i = 0;
				for (MotivosEntradaTaller motivoEntradaTaller : lista) {
					selectMotivoEntradaTaller[i] = new SelectItem(motivoEntradaTaller.getMotivosEntradaTallerId(),
							motivoEntradaTaller.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMotivoEntradaTaller;
	}

	public void setselectMotivoEntradaTaller(SelectItem[] selectMotivoEntradaTaller) {
		this.selectMotivoEntradaTaller = selectMotivoEntradaTaller;
	}

	public SelectItem[] getSelectAgenteCausador() {

		if (agenteCausador == null || agenteCausador.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<AgenteCausadorParada> lista = businessDelegatorView.findByCriteriaInAgenteCausadorParada(condicion,
						null, null);
				selectAgenteCausador = new SelectItem[lista.size()];

				int i = 0;
				for (AgenteCausadorParada agenteCausador : lista) {
					selectAgenteCausador[i] = new SelectItem(agenteCausador.getAgenteCausadorParadaId(),
							agenteCausador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAgenteCausador;
	}

	public void setselectAgenteCausador(SelectItem[] selectAgenteCausador) {
		this.selectAgenteCausador = selectAgenteCausador;
	}

	public SelectItem[] getSelectTipoMantenimiento() {

		if (tipoMantenimiento == null || tipoMantenimiento.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "nombre", true, nombreTipoMtto, "=" };
				List<TipoMantenimiento> lista = businessDelegatorView.findByCriteriaInTipoMantenimiento(condicion, null,
						null);
				selectTipoMantenimiento = new SelectItem[lista.size()];

				int i = 0;
				for (TipoMantenimiento tipoMantenimiento : lista) {
					selectTipoMantenimiento[i] = new SelectItem(tipoMantenimiento.getTipoMantenimientoId(),
							tipoMantenimiento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoMantenimiento;
	}

	public void setselectTipoMantenimiento(SelectItem[] selectTipoMantenimiento) {
		this.selectTipoMantenimiento = selectTipoMantenimiento;
	}

	public SelectItem[] getSelectPlanRevision() {

		if (txtEquipoId_Equipo.getValue() != null) {

			Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

			if (selectPlanRevision == null || selectPlanRevision.length == 0) {

				try {

					List<CatalogoPlanRevisionDTO> lista = businessDelegator2View
							.pr_lista_plan_revision_equipo(equipoId);
					selectPlanRevision = new SelectItem[lista.size()];

					int i = 0;
					for (CatalogoPlanRevisionDTO planRevision : lista) {
						selectPlanRevision[i] = new SelectItem(planRevision.getPlanRevisionId(),
								planRevision.getCodigoPlan() + "-" + planRevision.getNombrePlan());
						i++;
					}

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return selectPlanRevision;
	}

	public void setselectPlanRevision(SelectItem[] selectPlanRevision) {
		this.selectPlanRevision = selectPlanRevision;
	}

	public void action_agregarPlanesRevision() throws Exception {

		if (txtPlanRevisionEquipoId_PlanRevisionEquipo.getValue() != null && txtEquipoId_Equipo.getValue() != null) {
			Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
			Long planRevisionId = FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo);
			PlanRevisionEquipo planRevisionEquipo = businessDelegatorView.getPlanRevisionEquipo(planRevisionId);
			String nombrePlanRevision = planRevisionEquipo.getNombre();

			if (dataPlanRevision == null) {
				dataPlanRevision = new ArrayList<DatMantenimientoEquipoPlanRevisionDTO>();
			}

			boolean existe = false;

			if (dataPlanRevision != null || dataPlanRevision.size() > 0) {
				for (DatMantenimientoEquipoPlanRevisionDTO data : dataPlanRevision) {

					if (data.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId()
							.longValue() == planRevisionId.longValue()) {
						existe = true;
					}
				}

				if (existe == false) {

					DatMantenimientoEquipoPlanRevisionDTO dataDTO = new DatMantenimientoEquipoPlanRevisionDTO();
					dataDTO.setPlanRevisionEquipoId_PlanRevisionEquipo(planRevisionEquipo);
					dataDTO.setNombrePlanRevision(nombrePlanRevision);

					dataPlanRevision.add(dataDTO);

					prodAsociadosPlanRevision(planRevisionId, equipoId);

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps!", "Ya se agrego este plan de revisión. "));
				}
			}

			txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(null);
			planRevisionId = null;
			planRevisionEquipo = null;
			nombrePlanRevision = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que el campos de plan de revisión tengan valores. "));
		}
	}

	public void prodAsociadosPlanRevision(Long planRevisionId, Long equipoId) throws Exception {

		if (planRevisionId != null) {

			Object[] condicion = { "planRevisionEquipoId.planRevisionEquipoId", true, planRevisionId, "=" };
			List<PlanRevisionProd> data = businessDelegator2View.findByCriteriaInPlanRevisionProd(condicion, null,
					null);
			Date date = new Date();

			Equipo equipo = businessDelegatorView.getEquipo(equipoId);
			Long categoriaId = equipo.getCategoriaEquipo().getCategEquipId();
			CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);

			ConceptoKardex conceptoKardex = null;
			String codConceptoKardex = "";

			if (categoria.getConceptoKardexId() != null) {
				Long conceptoKardexId = categoria.getConceptoKardexId().getConceptoKardexId();
				conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexId);
				codConceptoKardex = conceptoKardex.getNombre() + "-" + conceptoKardex.getNombre();

			}

			Long companiaId = new Long(getCompaniaIdSession());
			Compania compania = businessDelegatorView.getCompania(companiaId);
			if (data != null && data.size() > 0) {

				if (dataEquipoProd == null) {
					dataEquipoProd = new ArrayList<DatMantenimientoEquipoProdDTO>();
				}

				for (PlanRevisionProd planRevisionProd : data) {

					Producto prod = businessDelegatorView.getProducto(planRevisionProd.getProducto().getProductoId());
					String codProducto = prod.getCodigo();
					String nomProducto = prod.getNombre();

					UdadMed udadMed = null;
					String codUdadMed = "";
					if (prod.getUdadMedByUdadMedProd() != null) {
						udadMed = businessDelegatorView.getUdadMed(prod.getUdadMedByUdadMedProd().getUdadMedId());
						codUdadMed = udadMed.getNombre();
					}

					Almacen almacen = null;
					String codAlmacen = "";
					Long idAlmacen = 0L;
					if (prod.getAlmacen() != null) {
						almacen = businessDelegatorView.getAlmacen(prod.getAlmacen().getAlmacenId());
						codAlmacen = almacen.getNombre();
						idAlmacen = prod.getAlmacen().getAlmacenId();
					}

					UbicacionesAlmacen ubAlmacen = null;
					String codUbAlmacen = "";
					if (prod.getUbicacionesAlmacenId() != null) {
						ubAlmacen = businessDelegator2View
								.getUbicacionesAlmacen(prod.getUbicacionesAlmacenId().getUbicacionesAlmacenId());
						codUbAlmacen = ubAlmacen.getNombre();
					}
					Double cantidad = planRevisionProd.getCantidad();

					Double cantidad_Compra = cantidad;
					Double valorUnitario = 0.0;
					Double porcIva = 0.0;
					Double valorIva = 0.0;
					Double costoTotal = 0.0;

					if (planRevisionProd.getProducto() != null && compania != null && idAlmacen != null) {
						valorUnitario = businessDelegatorView
								.consultarPrecioPromProducto(planRevisionProd.getProducto().getProductoId(), idAlmacen,
										companiaId, date)
								.doubleValue();
						costoTotal = (valorUnitario * cantidad_Compra);

					}
					Double saldoProducto = 0.0;
					saldoProducto = businessDelegator2View.pr_saldo_prom_producto(
							planRevisionProd.getProducto().getProductoId(), idAlmacen, companiaId).doubleValue();

					DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO = new DatMantenimientoEquipoProdDTO();
					datMantenimientoEquipoProdDTO.setProductoId_Producto(prod);
					datMantenimientoEquipoProdDTO.setUdadMedId_UdadMed(udadMed);
					datMantenimientoEquipoProdDTO.setCodProducto(codProducto);
					datMantenimientoEquipoProdDTO.setNomProducto(nomProducto);
					datMantenimientoEquipoProdDTO.setCodUdadMed(codUdadMed);
					datMantenimientoEquipoProdDTO.setCantidad(cantidad);
					datMantenimientoEquipoProdDTO.setCostoTotal(costoTotal);
					datMantenimientoEquipoProdDTO.setValorUnitario(valorUnitario);
					datMantenimientoEquipoProdDTO.setTipoSuministro("Cambios");
					datMantenimientoEquipoProdDTO.setFechaRegistro(date);
					datMantenimientoEquipoProdDTO.setAlmacenId(almacen);
					datMantenimientoEquipoProdDTO.setCodAlmacen(codAlmacen);
					datMantenimientoEquipoProdDTO.setUbicacionesAlmacen(ubAlmacen);
					datMantenimientoEquipoProdDTO.setNomUbAlmacen(codUbAlmacen);
					datMantenimientoEquipoProdDTO.setConceptoKardexId(conceptoKardex);
					datMantenimientoEquipoProdDTO.setNomConceptoKardexId(codConceptoKardex);
					datMantenimientoEquipoProdDTO.setPendienteImportacion("NO");
					if (saldoProducto > cantidad) {
						datMantenimientoEquipoProdDTO.setDescargaInventario("SI");
					} else {
						datMantenimientoEquipoProdDTO.setDescargaInventario("NO");
					}

					dataEquipoProd.add(datMantenimientoEquipoProdDTO);

				}
			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"No hay productos asociados a este plan de revision. "));
			}
		}
	}

	public String actionDeleteDatPlanRev(ActionEvent evt) {
		try {

			selectedPlanRevision = (DatMantenimientoEquipoPlanRevisionDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevision"));

			if (selectedPlanRevision.getDatManPlanRevivionId() == null) {
				dataPlanRevision.remove(selectedPlanRevision);
			} else {
				Long datManPlanRevisionId = new Long(selectedPlanRevision.getDatManPlanRevivionId());
				DatMantenimientoEquipoPlanRevision entity = businessDelegator2View
						.getDatMantenimientoEquipoPlanRevision(datManPlanRevisionId);
				businessDelegator2View.deleteDatMantenimientoEquipoPlanRevision(entity);
				dataPlanRevision.remove(selectedPlanRevision);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectItem[] getSelectLaborId() {

		if (selectLaborId == null || selectLaborId.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor labor : lista) {
					selectLaborId[i] = new SelectItem(labor.getLaborId(), labor.getNombre());
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

	public SelectItem[] getselectSolicitante() {

		if (solicitante == null || solicitante.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectSolicitante = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador solicitante : lista) {
					selectSolicitante[i] = new SelectItem(solicitante.getTrabId(), solicitante.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSolicitante;
	}

	public void setselectSolicitante(SelectItem[] selectSolicitante) {
		this.selectSolicitante = selectSolicitante;
	}

	public SelectItem[] getselectConductor() {

		if (conductor == null || conductor.size() == 0) {

			try {
				// Criteria
				Object[] condicion = { "estado", true, "A", "="

				};
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

	public void setselectConductor(SelectItem[] selectConductor) {
		this.selectConductor = selectConductor;
	}

	public SelectItem[] getselectTallerMecanico() {

		if (tallerMecanico == null || tallerMecanico.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TallerMecanico> lista = businessDelegatorView.findByCriteriaInTallerMecanico(condicion, null,
						null);
				selectTallerMecanico = new SelectItem[lista.size()];

				int i = 0;
				for (TallerMecanico tallerMecanico : lista) {
					selectTallerMecanico[i] = new SelectItem(tallerMecanico.getTallerMecanicoId(),
							tallerMecanico.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTallerMecanico;
	}

	public void setselectTallerMecanico(SelectItem[] selectTallerMecanico) {
		this.selectTallerMecanico = selectTallerMecanico;
	}

	public SelectItem[] getselectMecanico() {

		if (mecanico == null || mecanico.size() == 0) {
			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectMecanico = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador mecanico : lista) {
					selectMecanico[i] = new SelectItem(mecanico.getTrabId(), mecanico.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMecanico;
	}

	public void setselectMecanico(SelectItem[] selectMecanico) {
		this.selectMecanico = selectMecanico;
	}

	public SelectItem[] getselectJefeMtto() {

		if (jefeMtto == null || jefeMtto.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectJefeMtto = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador jefeMtto : lista) {
					selectJefeMtto[i] = new SelectItem(jefeMtto.getTrabId(), jefeMtto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectJefeMtto;
	}

	public void setselectJefeMtto(SelectItem[] selectJefeMtto) {
		this.selectJefeMtto = selectJefeMtto;
	}

	public SelectItem[] getSelectProductoIdInds() {

		if (productoIdInds == null || productoIdInds.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoIdInds = new SelectItem[lista.size()];

				int i = 0;
				for (Producto producto : lista) {
					selectProductoIdInds[i] = new SelectItem(producto.getProductoId(),
							producto.getCodigo() + "-" + producto.getNombre() +"-"+producto.getInfoAdicional()+"-"+producto.getInfoAdicional2());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoIdInds;
	}

	public void setSelectProductoIdInds(SelectItem[] selectProductoIdInds) {
		this.selectProductoIdInds = selectProductoIdInds;
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

	public SelectItem[] getSelectUdadMedMec() {

		if (udadMedMec == null || udadMedMec.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedMec = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedMec : lista) {
					selectUdadMedMec[i] = new SelectItem(udadMedMec.getUdadMedId(), udadMedMec.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedMec;
	}

	public void setselectUdadMedMec(SelectItem[] selectUdadMedMec) {
		this.selectUdadMedMec = selectUdadMedMec;
	}

	public SelectItem[] getSelectUdadMedProd() {

		if (udadMedProd == null || udadMedProd.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedProd = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedProd : lista) {
					selectUdadMedProd[i] = new SelectItem(udadMedProd.getUdadMedId(), udadMedProd.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedProd;
	}

	public void setselectUdadMedProd(SelectItem[] selectUdadMedProd) {
		this.selectUdadMedProd = selectUdadMedProd;
	}

	public SelectItem[] getSelectCeptoNomina() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNomina = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNomina[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNomina;
	}

	public void setselectCeptoNomina(SelectItem[] selectCeptoNomina) {
		this.selectCeptoNomina = selectCeptoNomina;
	}

	public SelectItem[] getSelectAlmacen() {

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

	public SelectItem[] getselectSistemasEquipo() {

		if (sistema == null || sistema.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemasEquipo> lista = businessDelegatorView.findByCriteriaInSistemasEquipo(condicion, null,
						null);
				selectSistemasEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (SistemasEquipo sistema : lista) {
					selectSistemasEquipo[i] = new SelectItem(sistema.getSistemasEquipoId(), sistema.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSistemasEquipo;
	}

	public void setselectSistemasEquipo(SelectItem[] selectSistemasEquipo) {
		this.selectSistemasEquipo = selectSistemasEquipo;
	}

	public SelectItem[] getselectCompartimientosEquipo() {

		if (compartimiento == null || compartimiento.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<CompartimientosEquipo> lista = businessDelegatorView
						.findByCriteriaInCompartimientosEquipo(condicion, null, null);
				selectCompartimientosEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CompartimientosEquipo compartimiento : lista) {
					selectCompartimientosEquipo[i] = new SelectItem(compartimiento.getCompartimientosEquipoId(),
							compartimiento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCompartimientosEquipo;
	}

	public void setselectCompartimientosEquipo(SelectItem[] selectCompartimientosEquipo) {
		this.selectCompartimientosEquipo = selectCompartimientosEquipo;
	}

	public SelectItem[] getSelectAreaTrabajo() {

		if (area == null || area.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<AreaTrabajo> lista = businessDelegatorView.findByCriteriaInAreaTrabajo(condicion, null, null);
				selectAreaTrabajo = new SelectItem[lista.size()];

				int i = 0;
				for (AreaTrabajo valor : lista) {
					selectAreaTrabajo[i] = new SelectItem(valor.getAreaTrabajoId(), valor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAreaTrabajo;
	}

	public void setSelectAreaTrabajo(SelectItem[] selectAreaTrabajo) {
		this.selectAreaTrabajo = selectAreaTrabajo;
	}

	public SelectItem[] getSelectTag() {

		if (tag == null || tag.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Tag> lista = businessDelegatorView.findByCriteriaInTag(condicion, null, null);
				selectTag = new SelectItem[lista.size()];

				int i = 0;
				for (Tag valor : lista) {
					selectTag[i] = new SelectItem(valor.getTagId(), valor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTag;
	}

	public void setSelectTag(SelectItem[] selectTag) {
		this.selectTag = selectTag;
	}

	public SelectItem[] getSelectZona() {

		if (zona == null || zona.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<ZonasFabrica> lista = businessDelegatorView.findByCriteriaInZonasFabrica(condicion, null, null);
				selectZona = new SelectItem[lista.size()];

				int i = 0;
				for (ZonasFabrica valor : lista) {
					selectZona[i] = new SelectItem(valor.getZonasFabricaId(), valor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectZona;
	}

	public void setSelectZona(SelectItem[] selectZona) {
		this.selectZona = selectZona;
	}

	public SelectItem[] getSelectNivel() {

		if (nivel == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<NivelPrioridad> lista = businessDelegatorView.findByCriteriaInNivelPrioridad(condicion, null,
						null);
				selectNivel = new SelectItem[lista.size()];

				int i = 0;
				for (NivelPrioridad valor : lista) {
					selectNivel[i] = new SelectItem(valor.getNivelPrioridadId(), valor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel;
	}

	public void setSelectNivel(SelectItem[] selectNivel) {
		this.selectNivel = selectNivel;
	}

	public void setselectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public InputText getTxtCodMecanico() {
		return txtCodMecanico;
	}

	public void setTxtCodMecanico(InputText txtCodMecanico) {
		this.txtCodMecanico = txtCodMecanico;
	}

	public InputText getTxtCodUdadMedMec() {
		return txtCodUdadMedMec;
	}

	public void setTxtCodUdadMedMec(InputText txtCodUdadMedMec) {
		this.txtCodUdadMedMec = txtCodUdadMedMec;
	}

	public InputText getTxtCodConceptoNomina() {
		return txtCodConceptoNomina;
	}

	public void setTxtCodConceptoNomina(InputText txtCodConceptoNomina) {
		this.txtCodConceptoNomina = txtCodConceptoNomina;
	}

	public InputText getTxtCodJefeMtto() {
		return txtCodJefeMtto;
	}

	public void setTxtCodJefeMtto(InputText txtCodJefeMtto) {
		this.txtCodJefeMtto = txtCodJefeMtto;
	}

	public InputText getTxtCodProducto() {
		return txtCodProducto;
	}

	public void setTxtCodProducto(InputText txtCodProducto) {
		this.txtCodProducto = txtCodProducto;
	}

	public InputText getTxtCodAlmacen() {
		return txtCodAlmacen;
	}

	public void setTxtCodAlmacen(InputText txtCodAlmacen) {
		this.txtCodAlmacen = txtCodAlmacen;
	}

	public InputText getTxtCodUdadMedProd() {
		return txtCodUdadMedProd;
	}

	public void setTxtCodUdadMedProd(InputText txtCodUdadMedProd) {
		this.txtCodUdadMedProd = txtCodUdadMedProd;
	}

	public List<DatMantenimientoEquipoMecDTO> getDataEquipoMec() {
		return dataEquipoMec;
	}

	public void setDataEquipoMec(List<DatMantenimientoEquipoMecDTO> dataEquipoMec) {
		this.dataEquipoMec = dataEquipoMec;
	}

	public List<DatMantenimientoEquipoProdDTO> getDataEquipoProd() {
		return dataEquipoProd;
	}

	public void setDataEquipoProd(List<DatMantenimientoEquipoProdDTO> dataEquipoProd) {
		this.dataEquipoProd = dataEquipoProd;
	}

	public SelectOneMenu getTxtTipoSuministro() {
		return txtTipoSuministro;
	}

	public void setTxtTipoSuministro(SelectOneMenu txtTipoSuministro) {
		this.txtTipoSuministro = txtTipoSuministro;
	}

	public SelectOneMenu getTxtTarea() {
		return txtTarea;
	}

	public void setTxtTarea(SelectOneMenu txtTarea) {
		this.txtTarea = txtTarea;
	}

	public Calendar getTxtHoraIniMec() {
		return txtHoraIniMec;
	}

	public Calendar getTxtHoraFinMec() {
		return txtHoraFinMec;
	}

	public void setTxtHoraIniMec(Calendar txtHoraIniMec) {
		this.txtHoraIniMec = txtHoraIniMec;
	}

	public void setTxtHoraFinMec(Calendar txtHoraFinMec) {
		this.txtHoraFinMec = txtHoraFinMec;
	}

	public InputText getTxtCodLaborMec() {
		return txtCodLaborMec;
	}

	public void setTxtCodLaborMec(InputText txtCodLaborMec) {
		this.txtCodLaborMec = txtCodLaborMec;
	}

	public InputText getTxtVidaActual() {
		return txtVidaActual;
	}

	public void setTxtVidaActual(InputText txtVidaActual) {
		this.txtVidaActual = txtVidaActual;
	}

	public Calendar getTxtFechaSalidaTaller() {
		return txtFechaSalidaTaller;
	}

	public void setTxtFechaSalidaTaller(Calendar txtFechaSalidaTaller) {
		this.txtFechaSalidaTaller = txtFechaSalidaTaller;
	}

	public InputText getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(InputText txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public InputText getTxtCodSistema() {
		return txtCodSistema;
	}

	public void setTxtCodSistema(InputText txtCodSistema) {
		this.txtCodSistema = txtCodSistema;
	}

	public InputText getTxtCodCompartimiento() {
		return txtCodCompartimiento;
	}

	public void setTxtCodCompartimiento(InputText txtCodCompartimiento) {
		this.txtCodCompartimiento = txtCodCompartimiento;
	}

	public SelectOneMenu getTxtCompartimientosEquipoId() {
		return txtCompartimientosEquipoId;
	}

	public void setTxtCompartimientosEquipoId(SelectOneMenu txtCompartimientosEquipoId) {
		this.txtCompartimientosEquipoId = txtCompartimientosEquipoId;
	}

	public SelectOneMenu getTxtSistemasEquipoId() {
		return txtSistemasEquipoId;
	}

	public void setTxtSistemasEquipoId(SelectOneMenu txtSistemasEquipoId) {
		this.txtSistemasEquipoId = txtSistemasEquipoId;
	}

	public String getSolicitudId() {

		return solicitudId;
	}

	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}

	public String getIdSolicitante() {
		return idSolicitante;
	}

	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
	}

	public String getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(String equipoId) {
		this.equipoId = equipoId;
	}

	public String getEquipoNombre() {
		return equipoNombre;
	}

	public void setEquipoNombre(String equipoNombre) {
		this.equipoNombre = equipoNombre;
	}

	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public String getNombreTipoMtto() {
		return nombreTipoMtto;
	}

	public void setNombreTipoMtto(String nombreTipoMtto) {
		this.nombreTipoMtto = nombreTipoMtto;
	}

	public String getNombreNivelPrioridad() {
		return nombreNivelPrioridad;
	}

	public void setNombreNivelPrioridad(String nombreNivelPrioridad) {
		this.nombreNivelPrioridad = nombreNivelPrioridad;
	}

	public String getNombreTaller() {
		return nombreTaller;
	}

	public void setNombreTaller(String nombreTaller) {
		this.nombreTaller = nombreTaller;
	}

	public SelectOneMenu getTxtZonasFabricaId_ZonasFabrica() {
		return txtZonasFabricaId_ZonasFabrica;
	}

	public void setTxtZonasFabricaId_ZonasFabrica(SelectOneMenu txtZonasFabricaId_ZonasFabrica) {
		this.txtZonasFabricaId_ZonasFabrica = txtZonasFabricaId_ZonasFabrica;
	}

	public SelectOneMenu getTxtAreaTrabajoId_AreaTrabajo() {
		return txtAreaTrabajoId_AreaTrabajo;
	}

	public void setTxtAreaTrabajoId_AreaTrabajo(SelectOneMenu txtAreaTrabajoId_AreaTrabajo) {
		this.txtAreaTrabajoId_AreaTrabajo = txtAreaTrabajoId_AreaTrabajo;
	}

	public SelectOneMenu getTxtTagId_Tag() {
		return txtTagId_Tag;
	}

	public void setTxtTagId_Tag(SelectOneMenu txtTagId_Tag) {
		this.txtTagId_Tag = txtTagId_Tag;
	}

	public SelectOneMenu getTxtNivelPrioridadId_NivelPrioridad() {
		return txtNivelPrioridadId_NivelPrioridad;
	}

	public void setTxtNivelPrioridadId_NivelPrioridad(SelectOneMenu txtNivelPrioridadId_NivelPrioridad) {
		this.txtNivelPrioridadId_NivelPrioridad = txtNivelPrioridadId_NivelPrioridad;
	}

	public SelectOneRadio getTxtRequiereParadaFabrica() {
		return txtRequiereParadaFabrica;
	}

	public void setTxtRequiereParadaFabrica(SelectOneRadio txtRequiereParadaFabrica) {
		this.txtRequiereParadaFabrica = txtRequiereParadaFabrica;
	}

	public SelectOneMenu getTxtEquipoId_Industrial() {
		return txtEquipoId_Industrial;
	}

	public void setTxtEquipoId_Industrial(SelectOneMenu txtEquipoId_Industrial) {
		this.txtEquipoId_Industrial = txtEquipoId_Industrial;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String getCompoRequieridoMttoIndustrial() {
		return compoRequieridoMttoIndustrial;
	}

	public void setCompoRequieridoMttoIndustrial(String compoRequieridoMttoIndustrial) {
		this.compoRequieridoMttoIndustrial = compoRequieridoMttoIndustrial;
	}

	public String getCompoRequieridoMttoMaquinaria() {
		return compoRequieridoMttoMaquinaria;
	}

	public void setCompoRequieridoMttoMaquinaria(String compoRequieridoMttoMaquinaria) {
		this.compoRequieridoMttoMaquinaria = compoRequieridoMttoMaquinaria;
	}

	public String getOcultaMttoIndustrial() {
		return ocultaMttoIndustrial;
	}

	public void setOcultaMttoIndustrial(String ocultaMttoIndustrial) {
		this.ocultaMttoIndustrial = ocultaMttoIndustrial;
	}

	public String getOcultaMttoMaquinaria() {
		return ocultaMttoMaquinaria;
	}

	public void setOcultaMttoMaquinaria(String ocultaMttoMaquinaria) {
		this.ocultaMttoMaquinaria = ocultaMttoMaquinaria;
	}

	public InputTextarea getTxtDescripcionSolicitud() {
		return txtDescripcionSolicitud;
	}

	public void setTxtDescripcionSolicitud(InputTextarea txtDescripcionSolicitud) {
		this.txtDescripcionSolicitud = txtDescripcionSolicitud;
	}

	public String getOrigendatos() {
		return origendatos;
	}

	public void setOrigendatos(String origendatos) {
		this.origendatos = origendatos;
	}

	public InputText getTxtVidaHora() {
		return txtVidaHora;
	}

	public void setTxtVidaHora(InputText txtVidaHora) {
		this.txtVidaHora = txtVidaHora;
	}

	public List<Labor> getLaborId() {
		return laborId;
	}

	public void setLaborId(List<Labor> laborId) {
		this.laborId = laborId;
	}

	public PlanRevisionEquipoDet getEntity_prdet() {
		return entity_prdet;
	}

	public void setEntity_prdet(PlanRevisionEquipoDet entity_prdet) {
		this.entity_prdet = entity_prdet;
	}

	public Equipo getEntity_equipo() {
		return entity_equipo;
	}

	public void setEntity_equipo(Equipo entity_equipo) {
		this.entity_equipo = entity_equipo;
	}

	public SelectItem[] getselectSistemasEquipoProd() {

		if (sistemaProd == null || sistemaProd.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemasEquipo> lista = businessDelegatorView.findByCriteriaInSistemasEquipo(condicion, null,
						null);
				selectSistemasEquipoProd = new SelectItem[lista.size()];

				int i = 0;
				for (SistemasEquipo sistemaProd : lista) {
					selectSistemasEquipoProd[i] = new SelectItem(sistemaProd.getSistemasEquipoId(),
							sistemaProd.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSistemasEquipoProd;
	}

	public void setselectSistemasEquipoProd(SelectItem[] selectSistemasEquipoProd) {
		this.selectSistemasEquipoProd = selectSistemasEquipoProd;
	}

	public SelectItem[] getselectCompartimientosEquipoProd() {

		if (compartimientoProd == null || compartimientoProd.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<CompartimientosEquipo> lista = businessDelegatorView
						.findByCriteriaInCompartimientosEquipo(condicion, null, null);
				selectCompartimientosEquipoProd = new SelectItem[lista.size()];

				int i = 0;
				for (CompartimientosEquipo compartimientoProd : lista) {
					selectCompartimientosEquipoProd[i] = new SelectItem(compartimientoProd.getCompartimientosEquipoId(),
							compartimientoProd.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCompartimientosEquipoProd;
	}

	public void setselectCompartimientosEquipoProd(SelectItem[] selectCompartimientosEquipoProd) {
		this.selectCompartimientosEquipoProd = selectCompartimientosEquipoProd;
	}

	/**
	 * @return the txtCompartimientosEquipoProdId
	 */
	public SelectOneMenu getTxtCompartimientosEquipoProdId() {
		return txtCompartimientosEquipoProdId;
	}

	/**
	 * @param txtCompartimientosEquipoProdId the txtCompartimientosEquipoProdId to
	 *                                       set
	 */
	public void setTxtCompartimientosEquipoProdId(SelectOneMenu txtCompartimientosEquipoProdId) {
		this.txtCompartimientosEquipoProdId = txtCompartimientosEquipoProdId;
	}

	/**
	 * @return the txtSistemasEquipoProdId
	 */
	public SelectOneMenu getTxtSistemasEquipoProdId() {
		return txtSistemasEquipoProdId;
	}

	/**
	 * @param txtSistemasEquipoProdId the txtSistemasEquipoProdId to set
	 */
	public void setTxtSistemasEquipoProdId(SelectOneMenu txtSistemasEquipoProdId) {
		this.txtSistemasEquipoProdId = txtSistemasEquipoProdId;
	}

	/**
	 * @return the txtCodCompartimientoEquipoProd
	 */
	public InputText getTxtCodCompartimientoEquipoProd() {
		return txtCodCompartimientoEquipoProd;
	}

	/**
	 * @param txtCodCompartimientoEquipoProd the txtCodCompartimientoEquipoProd to
	 *                                       set
	 */
	public void setTxtCodCompartimientoEquipoProd(InputText txtCodCompartimientoEquipoProd) {
		this.txtCodCompartimientoEquipoProd = txtCodCompartimientoEquipoProd;
	}

	/**
	 * @return the txtCodSistemaEquipoProd
	 */
	public InputText getTxtCodSistemaEquipoProd() {
		return txtCodSistemaEquipoProd;
	}

	/**
	 * @param txtCodSistemaEquipoProd the txtCodSistemaEquipoProd to set
	 */
	public void setTxtCodSistemaEquipoProd(InputText txtCodSistemaEquipoProd) {
		this.txtCodSistemaEquipoProd = txtCodSistemaEquipoProd;
	}

	/**
	 * @return the txtFechaProd
	 */
	public Calendar getTxtFechaProd() {
		return txtFechaProd;
	}

	/**
	 * @param txtFechaProd the txtFechaProd to set
	 */
	public void setTxtFechaProd(Calendar txtFechaProd) {
		this.txtFechaProd = txtFechaProd;
	}

	public void listener_ConsultaDatosEquipo() {

		Long equipoid = null;

		if (txtEquipoId_Equipo.getValue() != null) {
			equipoid = Long.parseLong(txtEquipoId_Equipo.getValue().toString());

			try {
				Equipo equipo = businessDelegatorView.getEquipo(equipoid);
				/* valNPass = datPlanLabor.getNPases(); */
				if (equipo.getTagId() != null) {
					txtTagId_Tag.setValue(equipo.getTagId().longValue());
				}

				Long compania = new Long(getCompaniaIdSession());

				// txtVidaActual.setValue(null);
				// txtVidaHora.setValue(null);
				// txtVidaKm.setValue(null);
				java.util.Date fechaReg = new Date();
				GregorianCalendar cHoy = new GregorianCalendar();
				if (txtFechaEntradaTaller.getValue() != null) {
					fechaReg = FacesUtils.checkDate(txtFechaEntradaTaller);
				}
				cHoy.setTime(fechaReg);
				int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
				int mesHoy = cHoy.get(java.util.Calendar.MONTH);
				int anoHoy = cHoy.get(java.util.Calendar.YEAR);
				cHoy.set(anoHoy, mesHoy, diaHoy);
				java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
					Long idMedidor = medidor.getMedidorId();

					if (medidor != null) {

						if (medidor.getTipoMedidor().equals("horometro") || medidor.getTipoMedidor().equals("dia")) {

							Double valor = Double.parseDouble(businessDelegatorView
									.consultarHorometroActual(fechaHoy, equipoid, idMedidor, compania).toString());
							txtVidaActual.setValue(valor);
							txtVidaActual.setDisabled(true);

							txtVidaHora.setDisabled(false);
							txtVidaKm.setDisabled(true);
							requeridoHorometro = "true";
							requeridoOdometro = "false";

						} else if (medidor.getTipoMedidor().equals("odometro")) {

							Double valor = Double.parseDouble(businessDelegatorView
									.consultarOdometroActual(fechaHoy, equipoid, idMedidor, compania).toString());

							txtVidaActual.setValue(valor);
							txtVidaActual.setDisabled(true);
							txtVidaKm.setDisabled(false);
							txtVidaHora.setDisabled(true);
							requeridoHorometro = "false";
							requeridoOdometro = "true";
						} else if (medidor.getTipoMedidor().equals("averiado")) {

							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
											"El medidor de la maquinaria/equipo se encuentra averiado"));

							txtVidaActual.setDisabled(true);
							txtVidaKm.setDisabled(true);
							txtVidaHora.setDisabled(true);

							txtVidaActual.setValue(null);
							txtVidaHora.setValue(null);
							txtVidaKm.setValue(null);
							requeridoHorometro = "false";
							requeridoOdometro = "false";
						}
					}

				} else {

					equipo = null;

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

					txtVidaActual.setDisabled(true);
					txtVidaActual.setValue(null);
					// txtVidaDia.setDisabled(true);

					txtVidaHora.setValue(null);
					txtVidaKm.setValue(null);
					// txtVidaDia.setValue(null);

					txtVidaHora.setDisabled(true);
					txtVidaKm.setDisabled(true);

					requeridoHorometro = "false";
					requeridoOdometro = "false";
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_CalcularHoras() throws Exception {

		if (txtHoraIniMec.getValue() != null && txtHoraFinMec.getValue() != null) {

			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			GregorianCalendar horaInicial = new GregorianCalendar();
			horaInicial.setTime(FacesUtils.checkDate(txtHoraIniMec));
			Double horaI = (double) horaInicial.get(java.util.Calendar.HOUR_OF_DAY);

			GregorianCalendar minInicial = new GregorianCalendar();
			minInicial.setTime(FacesUtils.checkDate(txtHoraIniMec));
			Double minI = (double) minInicial.get(java.util.Calendar.MINUTE);

			Double horaIni = horaI + (minI / 60);

			GregorianCalendar horaFinal = new GregorianCalendar();
			horaFinal.setTime(FacesUtils.checkDate(txtHoraFinMec));
			Double horaF = (double) horaFinal.get(java.util.Calendar.HOUR_OF_DAY);

			GregorianCalendar minFinal = new GregorianCalendar();
			minFinal.setTime(FacesUtils.checkDate(txtHoraFinMec));
			Double minF = (double) minFinal.get(java.util.Calendar.MINUTE);

			Double horaFin = horaF + (minF / 60);

			Double horas = 0.0;

			if (horaFin.equals(horaIni)) {
				horas = 24.0;
			}

			if (horaFin.equals(0.0) && !horaFin.equals(horaIni)) {
				horas = 24 - horaIni;
			}

			if (!horaFin.equals(0.0) && !horaFin.equals(horaIni)) {
				horas = horaFin - horaIni;
			}

			// horas = businessDelegatorView.calcularHoras(fechaFinal, fechaInicial);
			String format = decimalFormat.format(horas);
			txtCantidadMec.setValue(format);

		}

	}

	public String action_clear2() {
		entity = null;
		entity_hrt = null;
		entity_prdet = null;
		entity_equipo = null;
		selectedDatMantenimientoEquipo = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		moduloSeleccionado();

		// información compartida entre modulos

		if (txtCierreOt != null) {
			txtCierreOt.setValue("A");
			txtCierreOt.setDisabled(false);
		}

		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(null);
			txtDescripcionSolicitud.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtNivelPrioridadId_NivelPrioridad != null) {
			txtNivelPrioridadId_NivelPrioridad.setValue(null);
			txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
		}

		if (txtTallerMecanicoId_TallerMecanico != null) {
			txtTallerMecanicoId_TallerMecanico.setValue(null);
			txtTallerMecanicoId_TallerMecanico.setDisabled(false);
		}

		if (txtTipoMantenimientoId_TipoMantenimiento != null) {
			txtTipoMantenimientoId_TipoMantenimiento.setValue(null);
			txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
		}

		if (txtSolicitante != null) {
			txtSolicitante.setValue(null);
			txtSolicitante.setDisabled(false);
		}

		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(null);
			txtDescripcionSolicitud.setDisabled(false);
		}
		if (txtConductor != null) {
			txtConductor.setValue(null);
			txtConductor.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtOrderTrabajo != null) {
			txtOrderTrabajo.setValue(null);
			txtOrderTrabajo.setDisabled(false);
		}

		if (txtReporteTecnico != null) {
			txtReporteTecnico.setValue(null);
			txtReporteTecnico.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtFechaSalidaTaller != null) {
			txtFechaSalidaTaller.setValue(null);
			txtFechaSalidaTaller.setDisabled(false);
		}

		if (txtVidaHora != null) {
			txtVidaHora.setValue(null);
			txtVidaHora.setDisabled(true);
		}

		if (txtVidaDia != null) {
			txtVidaDia.setValue(null);
			txtVidaDia.setDisabled(true);
		}

		if (txtVidaKm != null) {
			txtVidaKm.setValue(null);
			txtVidaKm.setDisabled(true);
		}

		if (txtAgenteCausadorParadaId_AgenteCausadorParada != null) {
			txtAgenteCausadorParadaId_AgenteCausadorParada.setValue(null);
			txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtMotivosEntradaTallerId_MotivosEntradaTaller != null) {
			txtMotivosEntradaTallerId_MotivosEntradaTaller.setValue(null);
			txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);
		}

		if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null) {
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(null);
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
		}

		if (txtTipoMantenimientoId_TipoMantenimiento != null) {
			txtTipoMantenimientoId_TipoMantenimiento.setValue(null);
			txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
		}

		if (txtSolicitante != null) {
			txtSolicitante.setValue(null);
			txtSolicitante.setDisabled(false);
		}

		if (txtDuracion != null) {
			txtDuracion.setValue(null);
			txtDuracion.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCierreOt != null) {
			txtFechaCierreOt.setValue(null);
			txtFechaCierreOt.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaEntradaTaller != null) {
			Date data = new Date();
			txtFechaEntradaTaller.setValue(data);
			txtFechaEntradaTaller.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaReaperturaOt != null) {
			txtFechaReaperturaOt.setValue(null);
			txtFechaReaperturaOt.setDisabled(false);
		}

		if (txtDatMantenimientoEquipoId != null) {
			txtDatMantenimientoEquipoId.setValue(null);
			txtDatMantenimientoEquipoId.setDisabled(false);
		}

		if (txtRequiereParadaFabrica != null) {
			txtRequiereParadaFabrica.setValue("NO");
			txtRequiereParadaFabrica.setDisabled(false);
		}

		// mantenimiento de maquinaria

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			compoRequieridoMttoIndustrial = "false";
			compoRequieridoMttoMaquinaria = "true";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

			if (txtTallerMecanicoId_TallerMecanico != null) {
				txtTallerMecanicoId_TallerMecanico.setValue(null);
				txtTallerMecanicoId_TallerMecanico.setDisabled(false);
			}

			if (txtAreaTrabajoId_AreaTrabajo != null) {
				txtAreaTrabajoId_AreaTrabajo.setValue(null);
				txtAreaTrabajoId_AreaTrabajo.setDisabled(true);
			}

			if (txtZonasFabricaId_ZonasFabrica != null) {
				txtZonasFabricaId_ZonasFabrica.setValue(null);
				txtZonasFabricaId_ZonasFabrica.setDisabled(true);
			}

			if (txtTagId_Tag != null) {
				txtTagId_Tag.setValue(null);
				txtTagId_Tag.setDisabled(true);
			}

			origendatos = "Modulo_TallerAgricola";

			/*
			 * if (txtOrigenDatos != null) {
			 * txtOrigenDatos.setValue("Modulo_TallerAgricola");
			 * txtOrigenDatos.setDisabled(true); }
			 */

		} else {

			compoRequieridoMttoMaquinaria = "false";
			compoRequieridoMttoIndustrial = "true";

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

			if (txtTallerMecanicoId_TallerMecanico != null) {
				txtTallerMecanicoId_TallerMecanico.setValue(null);
				txtTallerMecanicoId_TallerMecanico.setDisabled(false);
			}

			if (txtAreaTrabajoId_AreaTrabajo != null) {
				txtAreaTrabajoId_AreaTrabajo.setValue(null);
				txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
			}

			if (txtZonasFabricaId_ZonasFabrica != null) {
				txtZonasFabricaId_ZonasFabrica.setValue(null);
				txtZonasFabricaId_ZonasFabrica.setDisabled(false);
			}

			if (txtTagId_Tag != null) {
				txtTagId_Tag.setValue(null);
				txtTagId_Tag.setDisabled(false);
			}

			/*
			 * if (txtOrigenDatos != null) {
			 * txtOrigenDatos.setValue("Modulo_MttoIndustrial");
			 * txtOrigenDatos.setDisabled(true); }
			 */

			origendatos = "Modulo_MttoIndustrial";

		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		/*** mecanic ***/

		if (dataEquipoMec != null) {
			dataEquipoMec = null;
		}
		if (txtCantidadMec != null) {
			txtCantidadMec.setValue(null);
			txtCantidadMec.setDisabled(false);
		}

		if (txtCostoTotalMec != null) {
			txtCostoTotalMec.setValue(null);
			txtCostoTotalMec.setDisabled(false);
		}
		if (txtValorUnitarioMec != null) {
			txtValorUnitarioMec.setValue(null);
			txtValorUnitarioMec.setDisabled(false);
		}
		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		}
		if (txtMecanico != null) {
			txtMecanico.setValue(null);
			txtMecanico.setDisabled(false);
		}
		if (txtUdadMedMec != null) {
			txtUdadMedMec.setValue(null);
			txtUdadMedMec.setDisabled(false);
		}
		if (txtFechaRegistro != null) {
			Date date = new Date();
			txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}
		if (btnAgregarMecanico != null) {
			btnAgregarMecanico.setDisabled(false);
		}

		if (txtCodMecanico != null) {
			txtCodMecanico.setValue(null);
			txtCodMecanico.setDisabled(false);
		}
		if (txtCodUdadMedMec != null) {
			txtCodUdadMedMec.setValue(null);
			txtCodUdadMedMec.setDisabled(false);
		}
		if (txtCodConceptoNomina != null) {
			txtCodConceptoNomina.setValue(null);
			txtCodConceptoNomina.setDisabled(false);
		}

		if (txtCompartimientosEquipoId != null) {
			txtCompartimientosEquipoId.setValue(null);
			txtCompartimientosEquipoId.setDisabled(false);
		}

		if (txtSistemasEquipoId != null) {
			txtSistemasEquipoId.setValue(null);
			txtSistemasEquipoId.setDisabled(false);
		}

		if (txtCodSistema != null) {
			txtCodSistema.setValue(null);
			txtCodSistema.setDisabled(false);
		}

		if (txtCodCompartimiento != null) {
			txtCodCompartimiento.setValue(null);
			txtCodCompartimiento.setDisabled(false);
		}

		/*** productos ***/
		if (dataEquipoProd != null) {
			dataEquipoProd = null;
		}
		if (txtAlmacenId != null) {
			txtAlmacenId.setValue(null);
			txtAlmacenId.setDisabled(false);
		}
		if (txtCantidadProd != null) {
			txtCantidadProd.setValue(null);
			txtCantidadProd.setDisabled(false);
		}
		if (txtCostoTotalProd != null) {
			txtCostoTotalProd.setValue(null);
			txtCostoTotalProd.setDisabled(false);
		}
		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}
		if (txtValorUnitarioProd != null) {
			txtValorUnitarioProd.setValue(null);
			txtValorUnitarioProd.setDisabled(false);
		}
		if (txtJefeMtto != null) {
			txtJefeMtto.setValue(null);
			txtJefeMtto.setDisabled(false);
		}
		if (txtUdadMedProd != null) {
			txtUdadMedProd.setValue(null);
			txtUdadMedProd.setDisabled(false);
		}

		if (btnAgregarProd != null) {
			btnAgregarProd.setDisabled(false);
		}
		if (txtCodJefeMtto != null) {
			txtCodJefeMtto.setValue(null);
			txtCodJefeMtto.setDisabled(false);
		}
		if (txtCodProducto != null) {
			txtCodProducto.setValue(null);
			txtCodProducto.setDisabled(false);
		}
		if (txtCodAlmacen != null) {
			txtCodAlmacen.setValue(null);
			txtCodAlmacen.setDisabled(false);
		}
		if (txtCodUdadMedProd != null) {
			txtCodUdadMedProd.setValue(null);
			txtCodUdadMedProd.setDisabled(false);
		}
		if (txtTipoSuministro != null) {
			txtTipoSuministro.setValue(null);
			txtTipoSuministro.setDisabled(false);
		}

		if (txtCompartimientosEquipoProdId != null) {
			txtCompartimientosEquipoProdId.setValue(null);
			txtCompartimientosEquipoProdId.setDisabled(false);
		}

		if (txtSistemasEquipoProdId != null) {
			txtSistemasEquipoProdId.setValue(null);
			txtSistemasEquipoProdId.setDisabled(false);
		}

		if (txtCodSistemaEquipoProd != null) {
			txtCodSistemaEquipoProd.setValue(null);
			txtCodSistemaEquipoProd.setDisabled(false);
		}

		if (txtCodCompartimientoEquipoProd != null) {
			txtCodCompartimientoEquipoProd.setValue(null);
			txtCodCompartimientoEquipoProd.setDisabled(false);
		}

		if (txtFechaProd != null) {
			Date date = new Date();
			txtFechaProd.setValue(date);
			txtFechaProd.setDisabled(false);
		}

		return "";
	}

	/**
	 * @return the activeTapIndex
	 */
	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	/**
	 * @param activeTapIndex the activeTapIndex to set
	 */
	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the requeridoHorometro
	 */
	public String getRequeridoHorometro() {
		return requeridoHorometro;
	}

	/**
	 * @param requeridoHorometro the requeridoHorometro to set
	 */
	public void setRequeridoHorometro(String requeridoHorometro) {
		this.requeridoHorometro = requeridoHorometro;
	}

	/**
	 * @return the requeridoOdometro
	 */
	public String getRequeridoOdometro() {
		return requeridoOdometro;
	}

	/**
	 * @param requeridoOdometro the requeridoOdometro to set
	 */
	public void setRequeridoOdometro(String requeridoOdometro) {
		this.requeridoOdometro = requeridoOdometro;
	}

	public void listener_ConsultaCodUdadMedLabor() {

		Long laborId = null;

		if (txtTarea.getValue() != null) {

			laborId = Long.parseLong(txtTarea.getValue().toString());

			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				/* valNPass = datPlanLabor.getNPases(); */
				if (labor.getUdadMedByUdadMedPago() != null) {
					txtUdadMedMec.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public SelectItem[] getSelectTipoProducto() {

		if (tipoProducto == null || tipoProducto.size() == 0) {

			// tipoProducto = new ArrayList<TipoProducto>();

			try {

				// tipoProducto = businessDelegatorView.getTipoProducto(); // Fin
				// by
				// Criteria
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

	public SelectOneMenu getTxtTipoProducto() {
		return txtTipoProducto;
	}

	public void setTxtTipoProducto(SelectOneMenu txtTipoProducto) {
		this.txtTipoProducto = txtTipoProducto;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "4", "<>", "tipoEmpresa", true,
						"3", "<>", "tipoEmpresa", true, "5", "<>" };
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

	public String action_editNuevaOt(ActionEvent evt) throws NumberFormatException, Exception {

		moduloSeleccionado();

		selectedOt = (ListadoProximosMttoEquiposDTO) (evt.getComponent().getAttributes().get("selectedOt"));
		Long compania = new Long(getCompaniaIdSession());
		Date date = new Date();

		txtFechaEntradaTaller.setValue(date);
		txtFechaEntradaTaller.setDisabled(false);

		txtEquipoId_Equipo.setValue(selectedOt.getEquipo_id());
		txtEquipoId_Equipo.setDisabled(false);

		if (selectedOt.getPlan_revision_equipo_id() != null) {
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(selectedOt.getPlan_revision_equipo_id());
		}

		txtVidaHora.setDisabled(false);
		txtVidaKm.setDisabled(false);
		txtCentCostId_CentCost.setValue(null);
		if (entity.getCentCost() != null) {
			txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
		}
		txtCentCostId_CentCost.setDisabled(false);

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			compoRequieridoMttoIndustrial = "false";
			compoRequieridoMttoMaquinaria = "true";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

			txtTallerMecanicoId_TallerMecanico.setDisabled(false);
			txtAreaTrabajoId_AreaTrabajo.setDisabled(true);
			txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
			txtTagId_Tag.setDisabled(true);
			txtZonasFabricaId_ZonasFabrica.setDisabled(true);

		} else {

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

			compoRequieridoMttoIndustrial = "true";
			compoRequieridoMttoMaquinaria = "false";

			txtTallerMecanicoId_TallerMecanico.setDisabled(false);
			txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
			txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
			txtTagId_Tag.setDisabled(false);
			txtZonasFabricaId_ZonasFabrica.setDisabled(false);
		}

		GregorianCalendar cHoy = new GregorianCalendar();
		java.util.Date fechaReg = date;

		cHoy.setTime(fechaReg);
		int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
		int mesHoy = cHoy.get(java.util.Calendar.MONTH);
		int anoHoy = cHoy.get(java.util.Calendar.YEAR);
		cHoy.set(anoHoy, mesHoy, diaHoy);
		java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

		Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

		if (equipoId != null && !equipoId.toString().isEmpty()) {
			Equipo equipo = businessDelegatorView.getEquipo(equipoId);

			if (equipo.getMedidor() != null) {

				Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
				Long idMedidor = medidor.getMedidorId();

				if (medidor != null) {

					if (medidor.getTipoMedidor().equals("horometro") || medidor.getTipoMedidor().equals("dia")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());
						txtVidaActual.setValue(valor);
						txtVidaActual.setDisabled(true);
						txtVidaHora.setDisabled(false);
						txtVidaKm.setDisabled(true);
						txtVidaKm.setValue(null);

					} else if (medidor.getTipoMedidor().equals("odometro")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

						txtVidaActual.setValue(valor);
						txtVidaActual.setDisabled(true);
						txtVidaKm.setDisabled(false);
						txtVidaHora.setDisabled(true);
						txtVidaHora.setValue(null);

					} else if (medidor.getTipoMedidor().equals("averiado")) {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));

						txtVidaActual.setDisabled(true);
						txtVidaKm.setDisabled(true);
						txtVidaHora.setDisabled(true);
						txtVidaActual.setValue(null);
						txtVidaHora.setValue(null);
						txtVidaKm.setValue(null);
					}
				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
						"No se ha asignado un medidor a la maquinaria/equipo"));

				txtVidaActual.setDisabled(true);
				txtVidaActual.setValue(null);

				txtVidaHora.setValue(null);
				txtVidaKm.setValue(null);

				txtVidaHora.setDisabled(true);
				txtVidaKm.setDisabled(true);

			}

			/*************************************/

		}

		btnSave.setDisabled(false);
		setShowDialog(true);
		activeTapIndex = 0;

		return "";
	}

	@SuppressWarnings("unused")
	public String action_imprimirPDF(ActionEvent evt) throws Exception {

		selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoMtto"));

		Long idRegistro = selectedListadoMtto.getId_mtto().longValue();
		Object[] condicion = { "datMantenimientoEquipoId", true, idRegistro, "=" };
		List<DatMantenimientoEquipo> lista = (idRegistro != null)
				? businessDelegatorView.findByCriteriaInDatMantenimientoEquipo(condicion, null, null)
				: null;

		if (lista != null && lista.size() > 0) {

			List<SolicitudesMttoEquipoDTO> data = null;
			String filename = " ";
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();

			filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
					+ "SolicitudesMttoEquipos.xlsx";
			Long compania = new Long(getCompaniaIdSession());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicialDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);
			fechaInicialDateRegistro = sdf.parse(fsalida);

			Date fechaFinalDateRegistro = null;
			Date fechaOriginalFinal = foriginal.parse("2100-12-31");
			String fsalidaFinal = sdf.format(fechaOriginalFinal);
			fechaFinalDateRegistro = sdf.parse(fsalidaFinal);

			data = businessDelegator2View.pr_formato_impresion_ot(compania, fechaInicialDateRegistro,
					fechaFinalDateRegistro, "0", 1L, "0", 1L, "0", 1L, idRegistro);

			if (data != null && data.size() >= 0) {
				action_abrirTicketPDF(idRegistro, data);
			}
		}
		return "";

	}

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public void action_abrirTicketPDF(Long idRegistro, List<SolicitudesMttoEquipoDTO> dataReporte) throws Exception {

		this.servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();

		origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		String filenReporte = servletContext.getRealPath("") + File.separator + "jasperReport" + File.separator
				+ "OtMantenimiento.jasper";

		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/informes/jasperReport/OtMantenimiento.jasper");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JasperReport reporte = (JasperReport) JRLoader.loadObject(stream);

		Map parametros = new HashMap();
		parametros.put("consecutivo", idRegistro);

		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,
				new JRBeanCollectionDataSource(dataReporte));

		JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

		response.reset();
		response.setContentType("application/pdf");
		response.setContentLength(baos.size());
		response.setHeader("Content-disposition", "inline; filename=ticket_" + idRegistro + "_.pdf");
		response.getOutputStream().write(baos.toByteArray());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		context.responseComplete();

	}

	public SelectOneMenu getTxtTipoPersonal() {
		return txtTipoPersonal;
	}

	public void setTxtTipoPersonal(SelectOneMenu txtTipoPersonal) {
		this.txtTipoPersonal = txtTipoPersonal;
	}

	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneMenu getTxtProductoId_ProductoInds() {
		return txtProductoId_ProductoInds;
	}

	public void setTxtProductoId_ProductoInds(SelectOneMenu txtProductoId_ProductoInds) {
		this.txtProductoId_ProductoInds = txtProductoId_ProductoInds;
	}

	public InputText getTxtVidaDia() {
		return txtVidaDia;
	}

	public void setTxtVidaDia(InputText txtVidaDia) {
		this.txtVidaDia = txtVidaDia;
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

	public List<DatMantenimientoEquipoPlanRevisionDTO> getDataPlanRevision() {
		return dataPlanRevision;
	}

	public SelectOneMenu getTxtResponsableMttoId() {
		return txtResponsableMttoId;
	}

	public void setTxtResponsableMttoId(SelectOneMenu txtResponsableMttoId) {
		this.txtResponsableMttoId = txtResponsableMttoId;
	}

	public void setDataPlanRevision(List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision) {
		this.dataPlanRevision = dataPlanRevision;
	}

	public SelectItem[] getSelectResponsableMtto() {

		if (responsableMtto == null || responsableMtto.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectResponsableMtto = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador solicitante : lista) {
					selectResponsableMtto[i] = new SelectItem(solicitante.getTrabId(), solicitante.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectResponsableMtto;
	}

	public void setSelectResponsableMtto(SelectItem[] selectResponsableMtto) {
		this.selectResponsableMtto = selectResponsableMtto;
	}

	public void action_clear_ot() throws Exception {

		entity = null;
		dataPlanRevision = null;
		dataEquipoProd = null;
		moduloSeleccionado();

		if (txtSurtidor != null) {
			txtSurtidor.setValue(null);
			txtSurtidor.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(false);
		}

		if (txtFechaEntradaTaller != null) {
			txtFechaEntradaTaller.setValue(null);
			txtFechaEntradaTaller.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtSolicitante != null) {
			txtSolicitante.setValue(null);
			txtSolicitante.setDisabled(false);
		}

		if (txtResponsableMttoId != null) {
			txtResponsableMttoId.setValue(null);
			txtResponsableMttoId.setDisabled(false);
		}

		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(null);
			txtDescripcionSolicitud.setDisabled(false);
		}

		if (txtDatMantenimientoEquipoId != null) {
			txtDatMantenimientoEquipoId.setValue(null);
			txtDatMantenimientoEquipoId.setDisabled(false);
		}

		if (txtVidaActual != null) {
			txtVidaActual.setValue(null);
			txtVidaActual.setDisabled(false);
		}

		/*** ***** Productos ***** ***/

		if (txtFechaProd != null) {
			Date date = new Date();
			txtFechaProd.setValue(date);
			txtFechaProd.setDisabled(false);
		}

		if (txtTipoSuministro != null) {
			txtTipoSuministro.setValue(null);
			txtTipoSuministro.setDisabled(false);
		}

		if (txtAlmacenId != null) {
			txtAlmacenId.setValue(null);
			txtAlmacenId.setDisabled(false);
		}

		if (txtTipoProducto != null) {
			txtTipoProducto.setValue(null);
			txtTipoProducto.setDisabled(false);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}

		if (txtUbAlmacen != null) {
			txtUbAlmacen.setValue(null);
			txtUbAlmacen.setDisabled(false);
		}

		if (txtUdadMedProd != null) {
			txtUdadMedProd.setValue(null);
			txtUdadMedProd.setDisabled(false);
		}

		if (txtCantidadProd != null) {
			txtCantidadProd.setValue(null);
			txtCantidadProd.setDisabled(false);
		}

		if (txtCompartimientosEquipoProdId != null) {
			txtCompartimientosEquipoProdId.setValue(null);
			txtCompartimientosEquipoProdId.setDisabled(false);
		}
	}

	public void action_create_ot(ActionEvent evt) throws Exception {

		action_clear_ot();
		selectedOt = (ListadoProximosMttoEquiposDTO) (evt.getComponent().getAttributes().get("selectedOt"));

		entity = new DatMantenimientoEquipo();
		Long compania = new Long(getCompaniaIdSession());
		Long usuarioId = new Long(getUsuarioIdSession());
		Date date = new Date();

		if (moduloActivo.equals("mantenimiento_maquinaria")) {
			entity.setOrigenDatos("Modulo_TallerAgricola");
		} else {
			entity.setOrigenDatos("Modulo_MttoIndustrial");
		}
		entity.setTipoOrdenMtto("preventivo");
		entity.setCierreOt("A");
		entity.setCompania(compania);
		entity.setConsecutivo(
				(businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania, "preventivo")));
		entity.setEstado("A");
		entity.setFechaCreacion(date);
		entity.setFechaEntradaTaller(date);
		entity.setUsuarioDigitacion(usuarioId);

		entity.setEquipo((selectedOt.getEquipo_id() != null)
				? businessDelegatorView.getEquipo(selectedOt.getEquipo_id().longValue())
				: null);

		/****
		 * mejorar implementación, modificando el maestro de tipo de mantenimiento,
		 * agregando tipos de mtto por defecto
		 **/
		entity.setTipoMantenimiento(businessDelegatorView.getTipoMantenimiento(2l));

		if (selectedOt.getPlan_revision_equipo_id() != null) {

			Long planRevisionId = selectedOt.getPlan_revision_equipo_id().longValue();
			PlanRevisionEquipo planRevisionEquipo = businessDelegatorView.getPlanRevisionEquipo(planRevisionId);
			String nombrePlanRevision = planRevisionEquipo.getNombre();

			if (dataPlanRevision == null) {
				dataPlanRevision = new ArrayList<DatMantenimientoEquipoPlanRevisionDTO>();
			}

			DatMantenimientoEquipoPlanRevisionDTO dataDTO = new DatMantenimientoEquipoPlanRevisionDTO();
			dataDTO.setPlanRevisionEquipoId_PlanRevisionEquipo(planRevisionEquipo);
			dataDTO.setNombrePlanRevision(nombrePlanRevision);

			dataPlanRevision.add(dataDTO);

			prodAsociadosPlanRevision(planRevisionId, selectedOt.getEquipo_id().longValue());

		}

		businessDelegatorView.saveDatMantenimientoEquipo(entity, null, dataEquipoProd, dataPlanRevision, null);
		String planesSeleccionadas = "";
		String cadena = "";

		if (dataPlanRevision != null && dataPlanRevision.size() >= 0) {
			for (DatMantenimientoEquipoPlanRevisionDTO data1 : dataPlanRevision) {
				planesSeleccionadas += ","
						+ data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

			}

			cadena = "0" + planesSeleccionadas;
			Double vidaHoras = FacesUtils.checkDouble(txtVidaHora);
			Double vidaKm = FacesUtils.checkDouble(txtVidaKm);
			if (vidaHoras == null) {
				vidaHoras = 0.0;
			}
			if (vidaKm == null) {
				vidaKm = 0.0;
			}

			/*
			 * if(vidaKm>0 || vidaHoras>0) {
			 * businessDelegator2View.pr_actualizar_plan_revision_det(selectedOt.
			 * getEquipo_id().longValue(), date, vidaHoras ,vidaKm, cadena, "Ejecutado" ); }
			 */
			if (vidaKm == 0 && vidaHoras == 0) {
				businessDelegator2View.pr_actualizar_plan_revision_det(selectedOt.getEquipo_id().longValue(), date,
						vidaHoras, vidaKm, cadena, "Programado");
			}

			Equipo equipo = businessDelegatorView.getEquipo(selectedOt.getEquipo_id().longValue());
			PrecioPromProd entityProductos = null;
			/**** consulta ultima bomba con que se tanqueo del vehiculo ***/
			Double horTanqueo = businessDelegator2View.pr_ult_horo_odometro_tanqueo(compania,
					selectedOt.getEquipo_id().longValue());

			Object[] condicion = { "equipoId.equipoId", true, selectedOt.getEquipo_id().longValue(), "=",
					"horometro_abastecimiento", true, horTanqueo, ">=", "indicador_vuelta_medidor", true,
					equipo.getIndicador_vuelta_medidor(), "=", "producto.productoId", true, 1L, "=", };
			List<PrecioPromProd> lista = (selectedOt.getEquipo_id() != null)
					? businessDelegatorView.findByCriteriaInPrecioPromProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entityProductos = lista.get(0);

				Date fechaIni = entityProductos.getFechaInicial();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// sdf.format(fechaIni);

				String surtidor = "";
				Almacen almacen = null;
				String nomAlmacen = "";

				if (entityProductos.getAlmacenId() != null) {
					Long almacenId = entityProductos.getAlmacenId().getAlmacenId();
					almacen = businessDelegatorView.getAlmacen(almacenId);
					nomAlmacen = almacen.getCodigo();
				}
				surtidor = nomAlmacen + " Hr/Km tanqueo: " + horTanqueo + " Fecha: " + sdf.format(fechaIni);
				txtSurtidor.setValue(surtidor);

			}

		}

		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
				+ (businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania, "preventivo") - 1));
		action_consulta_ot();
	}

	public void action_consulta_ot() throws Exception {

		txtConsecutivo.setValue(entity.getConsecutivo());
		txtConsecutivo.setReadonly(true);

		txtFechaEntradaTaller.setValue(entity.getFechaEntradaTaller());
		txtVidaActual.setDisabled(true);

		txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
		txtEquipoId_Equipo.setDisabled(true);

		Long mantenimientoEquipoId = entity.getDatMantenimientoEquipoId();
		txtDatMantenimientoEquipoId.setValue(mantenimientoEquipoId);

		dataEquipoProd = null;
		dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(mantenimientoEquipoId);

		dataPlanRevision = null;
		dataPlanRevision = businessDelegator2View.getDataDatMantenimientoEquipoPlanRevisionByMec(mantenimientoEquipoId);

		Long compania = new Long(getCompaniaIdSession());
		GregorianCalendar cHoy = new GregorianCalendar();
		java.util.Date fechaReg = entity.getFechaEntradaTaller();

		cHoy.setTime(fechaReg);
		int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
		int mesHoy = cHoy.get(java.util.Calendar.MONTH);
		int anoHoy = cHoy.get(java.util.Calendar.YEAR);
		cHoy.set(anoHoy, mesHoy, diaHoy);
		java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

		Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

		if (equipoId != null && !equipoId.toString().isEmpty()) {
			Equipo equipo = businessDelegatorView.getEquipo(equipoId);

			if (equipo.getMedidor() != null) {

				Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
				Long idMedidor = medidor.getMedidorId();

				if (medidor != null) {

					if (medidor.getTipoMedidor().equals("horometro") || medidor.getTipoMedidor().equals("dia")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());
						txtVidaActual.setValue(valor);
						txtVidaActual.setDisabled(true);

						// txtVidaHora.setDisabled(false);
						// txtVidaKm.setDisabled(true);
						// requeridoHorometro = "true";
						// requeridoOdometro = "false";

					} else if (medidor.getTipoMedidor().equals("odometro")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

						txtVidaActual.setValue(valor);
						txtVidaActual.setDisabled(true);
						// txtVidaKm.setDisabled(false);
						// txtVidaHora.setDisabled(true);
						// requeridoHorometro = "false";
						// requeridoOdometro = "true";
					} else if (medidor.getTipoMedidor().equals("averiado")) {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));

						txtVidaActual.setDisabled(true);
						txtVidaActual.setValue(0.0);
						// txtVidaKm.setDisabled(true);
						// txtVidaHora.setDisabled(true);

						// txtVidaHora.setValue(null);
						// txtVidaKm.setValue(null);
						// requeridoHorometro = "false";
						// requeridoOdometro = "false";
					}

				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
						"No se ha asignado un medidor a la maquinaria/equipo"));

				txtVidaActual.setValue(null);
			}
		}

		setShowDialog(true);
	}

	public void action_update_ot() throws Exception {

		Date date = new Date();

		if (solicitud != null) {
			entity.setDescripcionSolicitud(solicitud);
		} else {
			entity.setDescripcionSolicitud(FacesUtils.checkString(txtDescripcionSolicitud));
		}

		entity.setFechaModificacion(date);
		entity.setFechaEntradaTaller(FacesUtils.checkDate(txtFechaEntradaTaller));

		entity.setTrabajador((FacesUtils.checkLong(txtSolicitante) != null)
				? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtSolicitante))
				: null);

		entity.setResponsableMttoId((FacesUtils.checkLong(txtResponsableMttoId) != null)
				? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtResponsableMttoId))
				: null);
		entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
				? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
				: null);

		Date fecha = FacesUtils.checkDate(txtFechaEntradaTaller);

		String planesSeleccionadas = "";
		String cadena = "";

		if (dataPlanRevision != null && dataPlanRevision.size() >= 0) {
			for (DatMantenimientoEquipoPlanRevisionDTO data1 : dataPlanRevision) {
				planesSeleccionadas += ","
						+ data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

				Long idPlan = data1.getPlanRevisionEquipoId_PlanRevisionEquipo().getPlanRevisionEquipoId();

				Object[] condicionPlan = { "planRevisionEquipo.planRevisionEquipoId", true, idPlan, "=",
						"equipo.equipoId", true, equipoId, "=" };
				List<PlanRevisionEquipoDet> listaPlan = (idPlan != null)
						? businessDelegatorView.findByCriteriaInPlanRevisionEquipoDet(condicionPlan, null, null)
						: null;
				if (listaPlan != null && listaPlan.size() > 0) {
					PlanRevisionEquipoDet entityPlan = listaPlan.get(0);
					Double horAnterior = 0.0;
					Double kmAnterior = 0.0;
					Double diferencia = 0.0;
					Double horActual = 0.0;
					Double kmActual = 0.0;

					if (entity.getVidaHoras() != null && entity.getVidaHoras() > 0) {
						if (entityPlan.getHorasUltimoServicio() != null) {
							horAnterior = entityPlan.getHorasUltimoServicio();
						}
						horActual = entity.getVidaHoras();
						diferencia = horActual - horAnterior;

					}
					if (entity.getVidaKm() != null && entity.getVidaKm() > 0) {
						if (entityPlan.getKmUltimoServicio() != null) {
							kmAnterior = entityPlan.getKmUltimoServicio();
						}
						kmActual = entity.getVidaKm();
						diferencia = kmActual - kmAnterior;
					}
					if (entity.getDifTiempoMttoAnteriorActual() == null
							|| entity.getDifTiempoMttoAnteriorActual() == 0) {
						entity.setDifTiempoMttoAnteriorActual(diferencia);
					}
				}
			}
			businessDelegatorView.updateDatMantenimientoEquipo(entity, null, dataEquipoProd, dataPlanRevision);
			cadena = "0" + planesSeleccionadas;
			Double vidaHoras = FacesUtils.checkDouble(txtVidaHora);
			Double vidaKm = FacesUtils.checkDouble(txtVidaKm);
			if (vidaHoras == null) {
				vidaHoras = 0.0;
			}
			if (vidaKm == null) {
				vidaKm = 0.0;
			}

			if (vidaKm > 0 || vidaHoras > 0) {
				businessDelegator2View.pr_actualizar_plan_revision_det(selectedOt.getEquipo_id().longValue(), fecha,
						vidaHoras, vidaKm, cadena, "Ejecutado");
			}
			if (vidaKm == 0 && vidaHoras == 0) {
				businessDelegator2View.pr_actualizar_plan_revision_det(selectedOt.getEquipo_id().longValue(), fecha,
						vidaHoras, vidaKm, cadena, "Programado");
			}

		}

		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		action_consulta_ot();
	}

	public String action_edit_mtto_preventivo(ActionEvent evt) {

		moduloSeleccionado();

		selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoMtto"));
		try {

			Long datMantenimientoEquipoId = selectedListadoMtto.getId_mtto().longValue();
			Object[] condicion = { "datMantenimientoEquipoId", true, datMantenimientoEquipoId, "=" };
			List<DatMantenimientoEquipo> lista = (datMantenimientoEquipoId != null)
					? businessDelegatorView.findByCriteriaInDatMantenimientoEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				if (entity.getResponsableMttoId() != null) {
					txtResponsableMttoId.setValue(entity.getResponsableMttoId().getTrabId());

				}
				txtResponsableMttoId.setDisabled(false);
				txtDescripcionSolicitud.setValue(entity.getDescripcionSolicitud());
				txtDescripcionSolicitud.setDisabled(false);
				// txtConductor.setValue(entity.getConductor());
				// txtConductor.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				// txtDuracion.setValue(entity.getDuracion());
				// txtDuracion.setDisabled(false);
				txtFechaEntradaTaller.setValue(entity.getFechaEntradaTaller());
				txtFechaEntradaTaller.setDisabled(false);
				// txtReporteTecnico.setValue(entity.getReporteTecnico());
				// txtReporteTecnico.setDisabled(false);
				txtVidaHora.setDisabled(false);
				// txtVidaDia.setDisabled(false);
				txtVidaKm.setDisabled(false);
				// txtRequiereParadaFabrica.setValue(entity.getRequiereParadaFabrica());
				// txtRequiereParadaFabrica.setDisabled(false);
				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCost() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);
				// mantenimiento de maquinaria

				if (moduloActivo.equals("mantenimiento_maquinaria")) {

					compoRequieridoMttoIndustrial = "false";
					compoRequieridoMttoMaquinaria = "true";

					ocultaMttoIndustrial = "none";
					ocultaMttoMaquinaria = "block";

					// txtTallerMecanicoId_TallerMecanico.setDisabled(false);
					// txtAreaTrabajoId_AreaTrabajo.setDisabled(true);
					// txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					// txtTagId_Tag.setDisabled(true);
					// txtZonasFabricaId_ZonasFabrica.setDisabled(true);

					// txtPersEmprId_PersEmpr.setDisabled(false);
					// txtTipoPersonal.setDisabled(false);
					// txtTipoProducto.setDisabled(false);

				} else {

					ocultaMttoIndustrial = "block";
					ocultaMttoMaquinaria = "none";

					compoRequieridoMttoIndustrial = "true";
					compoRequieridoMttoMaquinaria = "false";

					txtTallerMecanicoId_TallerMecanico.setDisabled(false);
					txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
					txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					txtTagId_Tag.setDisabled(false);
					txtZonasFabricaId_ZonasFabrica.setDisabled(false);

				}

				/*
				 * txtAreaTrabajoId_AreaTrabajo.setValue(selectedDatMantenimientoEquipo.
				 * getAreaTrabajoId_AreaTrabajo()); txtNivelPrioridadId_NivelPrioridad
				 * .setValue(selectedDatMantenimientoEquipo.getNivelPrioridadId_NivelPrioridad()
				 * );
				 * 
				 * txtTagId_Tag.setValue(selectedDatMantenimientoEquipo.getTagId_Tag());
				 * txtZonasFabricaId_ZonasFabrica
				 * .setValue(selectedDatMantenimientoEquipo.getZonasFabricaId_ZonasFabrica());
				 * 
				 * txtAgenteCausadorParadaId_AgenteCausadorParada
				 * .setValue(selectedDatMantenimientoEquipo.
				 * getAgenteCausadorParadaId_AgenteCausadorParada());
				 * txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);
				 */
				txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
				txtEquipoId_Equipo.setDisabled(false);
				/*
				 * txtMotivosEntradaTallerId_MotivosEntradaTaller
				 * .setValue(selectedDatMantenimientoEquipo.
				 * getMotivosEntradaTallerId_MotivosEntradaTaller());
				 * txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);
				 * 
				 * txtTallerMecanicoId_TallerMecanico
				 * .setValue(selectedDatMantenimientoEquipo.getTallerMecanicoId_TallerMecanico()
				 * );
				 * 
				 * txtTipoMantenimientoId_TipoMantenimiento
				 * .setValue(selectedDatMantenimientoEquipo.
				 * getTipoMantenimientoId_TipoMantenimiento());
				 * txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
				 */
				if (entity.getTrabajador() != null) {
					txtSolicitante.setValue(entity.getTrabajador().getTrabId());
				}
				txtSolicitante.setDisabled(false);
				txtDatMantenimientoEquipoId.setValue(entity.getDatMantenimientoEquipoId());
				txtDatMantenimientoEquipoId.setDisabled(true);

				txtFechaSalidaTaller.setValue(entity.getFechaSalidaTaller());
				txtFechaSalidaTaller.setDisabled(false);

				Long mantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
				// dataEquipoMec = null;
				// dataEquipoMec =
				// businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(mantenimientoEquipoId);
				dataEquipoProd = null;
				dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(mantenimientoEquipoId);
				dataPlanRevision = null;
				dataPlanRevision = businessDelegator2View
						.getDataDatMantenimientoEquipoPlanRevisionByMec(mantenimientoEquipoId);

				/*
				 * txtCantidadMec.setDisabled(false); txtMecanico.setDisabled(false);
				 * txtUdadMedMec.setDisabled(false); txtFechaRegistro.setDisabled(false);
				 * btnAgregarMecanico.setDisabled(false);
				 */
				txtProductoId_Producto.setDisabled(false);
				txtCantidadProd.setDisabled(false);
				txtFechaProd.setDisabled(false);
				txtUdadMedProd.setDisabled(false);
				btnAgregarProd.setDisabled(false);
				txtDescargaInventario.setDisabled(false);
				Long compania = new Long(getCompaniaIdSession());

				GregorianCalendar cHoy = new GregorianCalendar();
				java.util.Date fechaReg = entity.getFechaEntradaTaller();

				cHoy.setTime(fechaReg);
				int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
				int mesHoy = cHoy.get(java.util.Calendar.MONTH);
				int anoHoy = cHoy.get(java.util.Calendar.YEAR);
				cHoy.set(anoHoy, mesHoy, diaHoy);
				java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

				Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

				if (equipoId != null && !equipoId.toString().isEmpty()) {
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);

					if (equipo.getMedidor() != null) {

						Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
						Long idMedidor = medidor.getMedidorId();

						if (medidor != null) {

							if (medidor.getTipoMedidor().equals("horometro")
									|| medidor.getTipoMedidor().equals("dia")) {

								Double valor = Double.parseDouble(businessDelegatorView
										.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());
								txtVidaActual.setValue(valor);
								txtVidaActual.setDisabled(true);
								if (entity.getVidaHoras() != null) {
									txtVidaHora.setValue(entity.getVidaHoras().doubleValue());
								}
								txtVidaHora.setDisabled(false);
								txtVidaKm.setDisabled(true);
								txtVidaKm.setValue(null);
								// txtVidaDia.setDisabled(true);
								// txtVidaDia.setValue(null);

							} else if (medidor.getTipoMedidor().equals("odometro")) {

								Double valor = Double.parseDouble(businessDelegatorView
										.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

								txtVidaActual.setValue(valor);
								txtVidaActual.setDisabled(true);
								if (entity.getVidaKm() != null) {
									txtVidaKm.setValue(entity.getVidaKm().doubleValue());
								}
								txtVidaKm.setDisabled(false);
								txtVidaHora.setDisabled(true);
								txtVidaHora.setValue(null);
								// txtVidaDia.setDisabled(true);
								// txtVidaDia.setValue(null);

							} else if (medidor.getTipoMedidor().equals("averiado")) {

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
												"El medidor de la maquinaria/equipo se encuentra averiado"));

								txtVidaActual.setDisabled(true);
								txtVidaKm.setDisabled(true);
								txtVidaHora.setDisabled(true);
								// txtVidaDia.setDisabled(true);

								txtVidaActual.setValue(null);
								txtVidaHora.setValue(null);
								txtVidaKm.setValue(null);
								// txtVidaDia.setValue(null);

							}
						}

					} else {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

						txtVidaActual.setDisabled(true);
						txtVidaActual.setValue(null);

						txtVidaHora.setValue(null);
						txtVidaKm.setValue(null);
						// txtVidaDia.setValue(null);

						txtVidaHora.setDisabled(true);
						txtVidaKm.setDisabled(true);
						// txtVidaDia.setDisabled(true);

					}
				}

				txtReporteTecnico.setValue(entity.getReporteTecnico());
				txtReporteTecnico.setDisabled(false);
				
				
				txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
			entity_hrt = null;
			entity_equipo = null;
			entity_prdet = null;
		}

		return "";
	}

	public SelectOneMenu getTxtResponsableConsulta() {
		return txtResponsableConsulta;
	}

	public void setTxtResponsableConsulta(SelectOneMenu txtResponsableConsulta) {
		this.txtResponsableConsulta = txtResponsableConsulta;
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

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			try {
				equipos = businessDelegatorView.getEquipo();
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

	public InputText getTxtConsecutivoConsulta() {
		return txtConsecutivoConsulta;
	}

	public void setTxtConsecutivoConsulta(InputText txtConsecutivoConsulta) {
		this.txtConsecutivoConsulta = txtConsecutivoConsulta;
	}

	public List<ProgMttoPreventivosMaqDTO> getDataListadoOrdenesMtto() {
		return dataListadoOrdenesMtto;
	}

	public void setDataListadoOrdenesMtto(List<ProgMttoPreventivosMaqDTO> dataListadoOrdenesMtto) {
		this.dataListadoOrdenesMtto = dataListadoOrdenesMtto;
	}

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public void listarMantenimientos() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;

			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Long compania = new Long(getCompaniaIdSession());
			// String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen);

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);

			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();
			Long flagEquipo = 1L;
			Long flagEquipoCategoriaEquipos = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += "," + selectedEquipo.get(i);
				}
			}

			Long consecutivo = FacesUtils.checkLong(txtConsecutivoConsulta);
			if (consecutivo == null) {
				consecutivo = 0L;
			}

			String idResponsable = "0";
			Long flagResponsable = 1l;
			if (txtResponsableConsulta.getValue() != null) {
				idResponsable = FacesUtils.checkString(txtResponsableConsulta);
				flagResponsable = 0l;
			}

			String estadoOrdenServicio = "0";
			if (txtEstadoOrdenServicio.getValue() != null) {
				estadoOrdenServicio = FacesUtils.checkString(txtEstadoOrdenServicio);
			}

			Long centCost = 0L;
			centCost = FacesUtils.checkLong(txtCentCostConsulta);

			if (centCost == null) {
				centCost = 0L;
			}

			if (fechaInicial != null & fechaFinal != null) {
				dataListadoOrdenesMtto = businessDelegator2View.pr_ordenes_trabajao_mtto_maq(compania, fechaInicial,
						fechaFinal, equiposSeleccionadas, flagEquipo, idResponsable, flagResponsable, consecutivo,
						estadoOrdenServicio, centCost, "preventivo");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"Verifique que los campos de fechas,   tengan valores. "));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exportarMantenimientos() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Long compania = new Long(getCompaniaIdSession());
		// String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();
		Long flagEquipo = 1L;
		Long flagEquipoCategoriaEquipos = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		Long consecutivo = FacesUtils.checkLong(txtConsecutivoConsulta);
		if (consecutivo == null) {
			consecutivo = 0L;
		}

		String idResponsable = "0";
		Long flagResponsable = 1l;
		if (txtResponsableConsulta.getValue() != null) {
			idResponsable = FacesUtils.checkString(txtResponsableConsulta);
			flagResponsable = 0l;
		}

		if (fechaInicial != null & fechaFinal != null) {
			try {
				List<ProgMttoPreventivosMaqDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoListaMttoPorRealizar.xlsx";

				data = businessDelegator2View.pr_ordenes_trabajao_mtto_maq_detalle(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo, idResponsable, flagResponsable, consecutivo, "preventivo");

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);
					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style1.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style1.setBorderRight((CellStyle.BORDER_MEDIUM));
					style1.setBorderTop((CellStyle.BORDER_MEDIUM));
					style1.setBorderBottom((CellStyle.BORDER_MEDIUM));

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					style2.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style2.setBorderRight((CellStyle.BORDER_MEDIUM));
					style2.setBorderTop((CellStyle.BORDER_MEDIUM));
					style2.setBorderBottom((CellStyle.BORDER_MEDIUM));

					style2.setAlignment(CellStyle.ALIGN_CENTER);

					Font font = book.createFont();
					font.setColor(IndexedColors.WHITE.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");

					style2.setFont(font);

					CellStyle style3 = book.createCellStyle();
					style3.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style3.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style3.setBorderRight((CellStyle.BORDER_MEDIUM));
					style3.setBorderTop((CellStyle.BORDER_MEDIUM));
					style3.setBorderBottom((CellStyle.BORDER_MEDIUM));

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));

					if (data != null) {

						// int numColumnas = 3;
						// construyendo las columnas de excel

						Cell columna1 = row.createCell(0);
						columna1.setCellValue("ID_MTTO");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("FECHA_ENTRADA_TALLER");
						columna2.setCellStyle(style2);
						Cell columna3 = row.createCell(2);
						columna3.setCellValue("FECHA_SALIDA_TALLER");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("CONSECUTIVO");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("ID_EQUIPO");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("COD_EQUIPO");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("NOM_EQUIPO");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("HORO_ODO_ENTRADA");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("ID_PLAN_REVISION");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("COD_PLAN_REVISION");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("PLAN_REVISION");
						columna11.setCellStyle(style2);
						Cell columna12 = row.createCell(11);
						columna12.setCellValue("COD_SOLICITANTE");
						columna12.setCellStyle(style2);
						Cell columna13 = row.createCell(12);
						columna13.setCellValue("SOLICITANTE");
						columna13.setCellStyle(style2);
						Cell columna14 = row.createCell(13);
						columna14.setCellValue("RESPONSABLE_MTTO");
						columna14.setCellStyle(style2);
						Cell columna15 = row.createCell(14);
						columna15.setCellValue("COD_RESPONSABLE_TTO");
						columna15.setCellStyle(style2);
						Cell columna16 = row.createCell(15);
						columna16.setCellValue("NOM_RESPONSABLE_MTTO");
						columna16.setCellStyle(style2);
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("ID_USUARIO_RESPONSABLE");
						columna17.setCellStyle(style2);
						Cell columna18 = row.createCell(17);
						columna18.setCellValue("DESCRIPCION_SOLICITUD");
						columna18.setCellStyle(style2);
						Cell columna19 = row.createCell(18);
						columna19.setCellValue("DESCRIPCION_OT");
						columna19.setCellStyle(style2);
						Cell columna20 = row.createCell(19);
						columna20.setCellValue("COD_ALMACEN");
						columna20.setCellStyle(style2);
						Cell columna21 = row.createCell(20);
						columna21.setCellValue("NOM_ALMACEN");
						columna21.setCellStyle(style2);
						Cell columna22 = row.createCell(21);
						columna22.setCellValue("COD_PRODUCTO");
						columna22.setCellStyle(style2);
						Cell columna23 = row.createCell(22);
						columna23.setCellValue("NOM_PRODUCTO");
						columna23.setCellStyle(style2);
						Cell columna24 = row.createCell(23);
						columna24.setCellValue("NOM_UDAD_MED");
						columna24.setCellStyle(style2);
						Cell columna25 = row.createCell(24);
						columna25.setCellValue("COD_UBICACION");
						columna25.setCellStyle(style2);
						Cell columna26 = row.createCell(25);
						columna26.setCellValue("CANTIDAD_REQUERIDA");
						columna26.setCellStyle(style2);

						Cell columna27 = row.createCell(26);
						columna27.setCellValue("F. INICIAL");
						columna27.setCellStyle(style2);

						Cell columna28 = row.createCell(27);
						columna28.setCellValue("F. FINAL");
						columna28.setCellStyle(style2);

						Cell columna29 = row.createCell(28);
						columna29.setCellValue("DATOS MTTO");
						columna29.setCellStyle(style2);
						Cell columna30 = row.createCell(29);
						columna30.setCellValue("ESTADO OT");
						columna30.setCellStyle(style2);
						Cell columna31 = row.createCell(30);
						columna31.setCellValue("FIRMA RESPONSABLE");
						columna31.setCellStyle(style2);
						Cell columna32 = row.createCell(31);
						columna32.setCellValue("HOR/KM ENTRADA");
						columna32.setCellStyle(style2);

						Cell columna33 = row.createCell(32);
						columna33.setCellValue("HOR_KM_ANTERIOR");
						columna33.setCellStyle(style2);
						Cell columna34 = row.createCell(33);
						columna34.setCellValue("HORAS PARA MTTO");
						columna34.setCellStyle(style2);
						Cell columna35 = row.createCell(34);
						columna35.setCellValue("F. APLIC. MTTO");
						columna35.setCellStyle(style2);
						Cell columna36 = row.createCell(35);
						columna36.setCellValue("HOR/KM MTTO");
						columna36.setCellStyle(style2);

						Cell columna37 = row.createCell(36);
						columna37.setCellValue("F. ULT. MTTO");
						columna37.setCellStyle(style2);
						Cell columna38 = row.createCell(37);
						columna38.setCellValue("HR/KM ACTUAL - ULT. MTTO");
						columna38.setCellStyle(style2);

						int pos_i = 8;

						for (ProgMttoPreventivosMaqDTO reporte : data) {

							row = sheet.createRow(pos_i);

							Cell cell1 = row.createCell(0);
							Cell cell2 = row.createCell(1);
							Cell cell3 = row.createCell(2);
							Cell cell4 = row.createCell(3);
							Cell cell5 = row.createCell(4);
							Cell cell6 = row.createCell(5);
							Cell cell7 = row.createCell(6);
							Cell cell8 = row.createCell(7);
							Cell cell9 = row.createCell(8);
							Cell cell10 = row.createCell(9);
							Cell cell11 = row.createCell(10);
							Cell cell12 = row.createCell(11);
							Cell cell13 = row.createCell(12);
							Cell cell14 = row.createCell(13);
							Cell cell15 = row.createCell(14);
							Cell cell16 = row.createCell(15);
							Cell cell17 = row.createCell(16);
							Cell cell18 = row.createCell(17);
							Cell cell19 = row.createCell(18);
							Cell cell20 = row.createCell(19);
							Cell cell21 = row.createCell(20);
							Cell cell22 = row.createCell(21);
							Cell cell23 = row.createCell(22);
							Cell cell24 = row.createCell(23);
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
							Cell cell33 = row.createCell(32);
							Cell cell34 = row.createCell(33);
							Cell cell35 = row.createCell(34);
							Cell cell36 = row.createCell(35);
							Cell cell37 = row.createCell(36);
							Cell cell38 = row.createCell(37);

							cell1.setCellValue(reporte.getId_mtto().longValue());
							cell1.setCellStyle(style);
							cell2.setCellValue(reporte.getFecha_entrada_taller());
							cell2.setCellStyle(style);
							cell3.setCellValue(reporte.getFecha_salida_taller());
							cell3.setCellStyle(style);
							cell4.setCellValue(reporte.getConsecutivo().longValue());
							cell4.setCellStyle(style);
							cell5.setCellValue(reporte.getId_equipo().longValue());
							cell5.setCellStyle(style);
							cell6.setCellValue(reporte.getCod_equipo());
							cell6.setCellStyle(style);
							cell7.setCellValue(reporte.getNom_equipo());
							cell7.setCellStyle(style);
							cell8.setCellValue(reporte.getHoro_odo_entrada().doubleValue());
							cell8.setCellStyle(style);
							cell9.setCellValue(reporte.getId_plan_revision2());
							cell9.setCellStyle(style);
							cell10.setCellValue(reporte.getCod_plan_revision());
							cell10.setCellStyle(style);
							cell11.setCellValue(reporte.getNom_plan_revision());
							cell11.setCellStyle(style);
							cell12.setCellValue(reporte.getCod_solicitante());
							cell12.setCellStyle(style);
							cell13.setCellValue(reporte.getSolicitante());
							cell13.setCellStyle(style);
							cell14.setCellValue(reporte.getResponsable_mtto().longValue());
							cell14.setCellStyle(style);
							cell15.setCellValue(reporte.getCod_responsable_tto());
							cell15.setCellStyle(style);
							cell16.setCellValue(reporte.getNom_responsable_mtto());
							cell16.setCellStyle(style);
							cell17.setCellValue(reporte.getId_usuario_responsable().longValue());
							cell17.setCellStyle(style);
							cell18.setCellValue(reporte.getDescripcion_solicitud());
							cell18.setCellStyle(style);
							cell19.setCellValue(reporte.getDescripcion_ot());
							cell19.setCellStyle(style);
							cell20.setCellValue(reporte.getCodAlmacen());
							cell20.setCellStyle(style);
							cell21.setCellValue(reporte.getNomAlmacen());
							cell21.setCellStyle(style);
							cell22.setCellValue(reporte.getCod_producto());
							cell22.setCellStyle(style);
							cell23.setCellValue(reporte.getNom_producto());
							cell23.setCellStyle(style);
							cell24.setCellValue(reporte.getUm_producto());
							cell24.setCellStyle(style);
							cell25.setCellValue(reporte.getNomUbicacion());
							cell25.setCellStyle(style);
							cell26.setCellValue(reporte.getCantidad().doubleValue());
							cell26.setCellStyle(style);

							cell27.setCellValue(sdf.format(fechaInicial));
							cell27.setCellStyle(style);

							cell28.setCellValue(sdf.format(fechaFinal));
							cell28.setCellStyle(style);

							cell29.setCellValue(reporte.getDatosMatto());
							cell29.setCellStyle(style);

							cell30.setCellValue(reporte.getCierreOt());
							cell30.setCellStyle(style);

							cell31.setCellValue(".");
							cell31.setCellStyle(style);

							cell32.setCellValue(reporte.getHorOdoActual().doubleValue());
							cell32.setCellStyle(style);

							cell33.setCellValue(reporte.getHorKmAnterior());
							cell33.setCellStyle(style);

							cell34.setCellValue(reporte.getHorasParaMtto());
							cell34.setCellStyle(style);

							cell35.setCellValue(".");
							cell35.setCellStyle(style);

							cell36.setCellValue(".");
							cell36.setCellStyle(style);

							cell37.setCellValue(reporte.getFechaUltimoServicio());
							cell37.setCellStyle(style);

							cell38.setCellValue(reporte.getHorOdoDifMtto());
							cell38.setCellStyle(style);

							// cell20.setCellValue(d1);
							// cell21.setCellValue(d2);

							pos_i++;

						}

						// int numFilas = data.size() + 1;

						// for (int i = 0; i < numFilas; i++) {
						// sheet.autoSizeColumn(i);
						// }

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoListaMttoPorRealizar.xlsx");

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

	}

	public SelectItem[] getSelectResponsableConsulta() {

		if (responsableConsulta == null || responsableConsulta.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectResponsableConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador responsableConsulta : lista) {
					selectResponsableConsulta[i] = new SelectItem(responsableConsulta.getTrabId(),
							responsableConsulta.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectResponsableConsulta;
	}

	public void setSelectResponsableConsulta(SelectItem[] selectResponsableConsulta) {
		this.selectResponsableConsulta = selectResponsableConsulta;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public ProgMttoPreventivosMaqDTO getSelectedListadoMtto() {
		return selectedListadoMtto;
	}

	public void setSelectedListadoMtto(ProgMttoPreventivosMaqDTO selectedListadoMtto) {
		this.selectedListadoMtto = selectedListadoMtto;
	}

	public InputText getTxtDifTiempoMttoAnteriorActual() {
		return txtDifTiempoMttoAnteriorActual;
	}

	public void setTxtDifTiempoMttoAnteriorActual(InputText txtDifTiempoMttoAnteriorActual) {
		this.txtDifTiempoMttoAnteriorActual = txtDifTiempoMttoAnteriorActual;
	}

	public String action_vericiar_saldos_ubicacion() throws Exception {

		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		String almacenId = FacesUtils.checkString(txtAlmacenId);
		String productoId = FacesUtils.checkString(txtProductoId_Producto);
		Long compania = new Long(getCompaniaIdSession());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();

		if (txtAlmacenId.getValue() != null && txtProductoId_Producto.getValue() != null) {
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

	public InputText getTxtSurtidor() {
		return txtSurtidor;
	}

	public void setTxtSurtidor(InputText txtSurtidor) {
		this.txtSurtidor = txtSurtidor;
	}

	public SelectOneMenu getTxtEstadoOrdenServicio() {
		return txtEstadoOrdenServicio;
	}

	public void setTxtEstadoOrdenServicio(SelectOneMenu txtEstadoOrdenServicio) {
		this.txtEstadoOrdenServicio = txtEstadoOrdenServicio;
	}

	public void listarMantenimientosProductos() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;

			fechaInicial = (FacesUtils.checkDate(txtFechaInicialConsulta));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinalConsulta));
			Long compania = new Long(getCompaniaIdSession());
			// String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen);

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);

			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();
			Long flagEquipo = 1L;
			Long flagEquipoCategoriaEquipos = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += "," + selectedEquipo.get(i);
				}
			}

			String almacenId = "0";
			String productoId = "0";
			Long flagAlmacen = 1L;
			Long flagProducto = 1L;
			Long tipoProducto = 0L;
			if (txtAlmacenId_Almacen.getValue() != null) {
				almacenId = (FacesUtils.checkString(txtAlmacenId_Almacen));
				flagAlmacen = 0L;
			}

			if (txtProductoIdConsulta.getValue() != null) {
				productoId = (FacesUtils.checkString(txtProductoIdConsulta));
				flagProducto = 0L;
			}
			if (txtTipoProductoConsulta.getValue() != null) {
				tipoProducto = FacesUtils.checkLong(txtTipoProductoConsulta);

			}

			if (fechaInicial != null & fechaFinal != null) {
				dataProductos = businessDelegator2View.pr_solicitudes_mtto_equipo_productos(compania, fechaInicial,
						fechaFinal, equiposSeleccionadas, flagEquipo, productoId, flagProducto, almacenId, flagAlmacen,
						0L, 0L, tipoProducto);
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"Verifique que los campos de fechas,   tengan valores. "));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SelectItem[] getSelectTipoProductoConsulta() {

		if (tipoProductoConsulta == null || tipoProductoConsulta.size() == 0) {

			// tipoProducto = new ArrayList<TipoProducto>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProductoConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto : lista) {
					selectTipoProductoConsulta[i] = new SelectItem(tipoProducto.getTipoProdId(),
							tipoProducto.getCodigo() + " - " + tipoProducto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProductoConsulta;
	}

	public void setSelectTipoProductoConsulta(SelectItem[] selectTipoProductoConsulta) {
		this.selectTipoProductoConsulta = selectTipoProductoConsulta;
	}

	public SelectItem[] getSelectAlmacen2() {

		if (almacen2 == null || almacen2.size() == 0) {

			try {

				// almacen2 = businessDelegatorView.getAlmacen(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(),
							almacen2.getCodigo() + " - " + almacen2.getCodigo());
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

	public SelectItem[] getSelectProductoIdConsulta() throws NumberFormatException, Exception {
		if (txtTipoProductoConsulta.getValue() != null) {

			// if (productoId == null || productoId.size() == 0) {

			Long idCompania = new Long(getCompaniaIdSession());
			Long tipoProducto = FacesUtils.checkLong(txtTipoProductoConsulta);
			try {
				// List<CatalogProductoDTO> lista = null;
				List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania,
						tipoProducto);
				selectProductoIdConsulta = new SelectItem[lista.size()];
				/*
				 * int i = 0; for (CatalogProductoDTO catalogProductoDTO : lista) {
				 * selectProductoIdConsulta[i] = new
				 * SelectItem(catalogProductoDTO.getProductoIdConsulta().longValue(),
				 * catalogProductoDTO.getCodigo()+"-"+ catalogProductoDTO.getNombre()
				 * 
				 * ); i++;
				 * 
				 * }
				 */
				for (int j = 0; j < lista.size(); j++) {
					selectProductoIdConsulta[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
							lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoIdConsulta;
	}

	public void setSelectProductoIdConsulta(SelectItem[] selectProductoIdConsulta) {
		this.selectProductoIdConsulta = selectProductoIdConsulta;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public SelectOneMenu getTxtTipoProductoConsulta() {
		return txtTipoProductoConsulta;
	}

	public SelectOneMenu getTxtProductoIdConsulta() {
		return txtProductoIdConsulta;
	}

	public Calendar getTxtFechaInicialConsulta() {
		return txtFechaInicialConsulta;
	}

	public Calendar getTxtFechaFinalConsulta() {
		return txtFechaFinalConsulta;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}

	public void setTxtTipoProductoConsulta(SelectOneMenu txtTipoProductoConsulta) {
		this.txtTipoProductoConsulta = txtTipoProductoConsulta;
	}

	public void setTxtProductoIdConsulta(SelectOneMenu txtProductoIdConsulta) {
		this.txtProductoIdConsulta = txtProductoIdConsulta;
	}

	public void setTxtFechaInicialConsulta(Calendar txtFechaInicialConsulta) {
		this.txtFechaInicialConsulta = txtFechaInicialConsulta;
	}

	public void setTxtFechaFinalConsulta(Calendar txtFechaFinalConsulta) {
		this.txtFechaFinalConsulta = txtFechaFinalConsulta;
	}

	public List<SolicitudesMttoEquipoDTO> getDataProductos() {
		return dataProductos;
	}

	public void setDataProductos(List<SolicitudesMttoEquipoDTO> dataProductos) {
		this.dataProductos = dataProductos;
	}

	public String action_edit_mtto_productos(ActionEvent evt) {

		moduloSeleccionado();

		selectedListadoProductos = (SolicitudesMttoEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoProductos"));
		try {

			Long datMantenimientoEquipoProdId = selectedListadoProductos.getDatMantenimientoEquipoProdId().longValue();
			Object[] condicion = { "datMantenimientoEquipoProdId", true, datMantenimientoEquipoProdId, "=" };
			List<DatMantenimientoEquipoProd> lista = (datMantenimientoEquipoProdId != null)
					? businessDelegatorView.findByCriteriaInDatMantenimientoEquipoProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entityDetProd = lista.get(0);

				txtConsecutivo.setValue(selectedListadoProductos.getConsecutivo());
				txtConsecutivo.setDisabled(true);

				txtFechaEntradaTaller.setValue(selectedListadoProductos.getFecha_entrada_taller());
				txtFechaEntradaTaller.setDisabled(true);

				txtVidaHora.setDisabled(true);

				txtVidaKm.setDisabled(true);

				txtEquipoId_Equipo.setValue(selectedListadoProductos.getEquipoId());
				txtEquipoId_Equipo.setDisabled(true);

				txtFechaSalidaTaller.setValue(selectedListadoProductos.getFecha_salida_taller());
				txtFechaSalidaTaller.setDisabled(true);

				txtTipoSuministro.setValue(null);
				txtProductoId_Producto.setValue(null);
				txtCantidadProd.setValue(null);
				txtFechaProd.setValue(null);
				txtUdadMedProd.setValue(null);
				txtValorUnitarioProd.setValue(null);
				txtCostoTotalProd.setValue(null);
				txtCompartimientosEquipoProdId.setValue(null);

				txtTipoSuministro.setDisabled(false);
				txtProductoId_Producto.setDisabled(false);
				txtCantidadProd.setDisabled(false);
				txtFechaProd.setDisabled(false);
				txtUdadMedProd.setDisabled(false);
				txtValorUnitarioProd.setDisabled(false);
				txtCostoTotalProd.setDisabled(false);
				txtCompartimientosEquipoProdId.setDisabled(false);

				txtProductoId_Producto.setValue(entityDetProd.getProducto().getProductoId());
				txtCantidadProd.setValue(entityDetProd.getCantidad());
				txtFechaProd.setValue(entityDetProd.getFechaRegistro());
				txtUdadMedProd.setValue(entityDetProd.getUdadMed().getUdadMedId());
				txtValorUnitarioProd.setValue(entityDetProd.getValorUnitario());
				txtCostoTotalProd.setValue(entityDetProd.getCostoTotal());
				txtTipoSuministro.setValue(entityDetProd.getTipoSuministro());

				txtDescargaInventario.setValue(null);
				if (entityDetProd.getDescargaInventario() != null) {
					txtDescargaInventario.setValue(entityDetProd.getDescargaInventario());
				}
				txtDescargaInventario.setDisabled(false);

				if (entityDetProd.getCompartimientosEquipo() != null) {
					txtCompartimientosEquipoProdId
							.setValue(entityDetProd.getCompartimientosEquipo().getCompartimientosEquipoId());
				}

				txtConceptoKardex.setValue(null);
				if (entityDetProd.getConceptoKardexId() != null) {
					txtConceptoKardex.setValue(entityDetProd.getConceptoKardexId().getConceptoKardexId());
				}

				txtConceptoKardex.setDisabled(false);

				txtUbAlmacen.setValue(null);
				if (entityDetProd.getUbicacionesAlmacen() != null) {
					txtUbAlmacen.setValue(entityDetProd.getUbicacionesAlmacen().getUbicacionesAlmacenId());
				}

				txtUbAlmacen.setDisabled(false);

				txtAlmacenId.setValue(null);
				if (entityDetProd.getAlmacenId() != null) {
					txtAlmacenId.setValue(entityDetProd.getAlmacenId().getAlmacenId());
				}
				txtAlmacenId.setDisabled(false);

				txtTipoProducto.setValue(null);
				if (entityDetProd.getProducto() != null) {
					Long productoId = entityDetProd.getProducto().getProductoId();
					Producto producto = businessDelegatorView.getProducto(productoId);
					txtTipoProducto.setValue(producto.getTipoProducto().getTipoProdId());
					txtTipoProducto.setDisabled(true);

				}

				txtVidaHora.setValue(selectedListadoProductos.getHoro_odo_entrada());
				txtVidaKm.setValue(selectedListadoProductos.getOdomentro_entrada());

				txtVidaHora.setDisabled(true);
				txtVidaKm.setDisabled(true);

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
			entity_hrt = null;
			entity_equipo = null;
			entity_prdet = null;
		}

		return "";
	}

	public SolicitudesMttoEquipoDTO getSelectedListadoProductos() {
		return selectedListadoProductos;
	}

	public void setSelectedListadoProductos(SolicitudesMttoEquipoDTO selectedListadoProductos) {
		this.selectedListadoProductos = selectedListadoProductos;
	}

	public SelectItem[] getSelectConceptoKardex() {

		if (conceptoKardex == null || conceptoKardex.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoMovimiento", true, "SAL", "=" };
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

	public SelectOneMenu getTxtConceptoKardex() {
		return txtConceptoKardex;
	}

	public void setTxtConceptoKardex(SelectOneMenu txtConceptoKardex) {
		this.txtConceptoKardex = txtConceptoKardex;
	}

	public String action_modify_producto() {
		try {
			if (entityDetProd == null) {
				Long datMantenimientoEquipoProdId = new Long(
						selectedListadoProductos.getDatMantenimientoEquipoProdId().longValue());
				entityDetProd = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
			}

			// entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId));
			entityDetProd.setCantidad(FacesUtils.checkDouble(txtCantidadProd));
			entityDetProd.setCostoTotal(FacesUtils.checkDouble(txtCostoTotalProd));
			// entityDetProd.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entityDetProd.setFechaModificacion(new Date());
			entityDetProd.setValorUnitario(FacesUtils.checkDouble(txtValorUnitarioProd));

			entityDetProd.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto))
					: null);

			entityDetProd.setUdadMed((FacesUtils.checkLong(txtUdadMedProd) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedProd))
					: null);

			entityDetProd.setConceptoKardexId((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);

			entityDetProd.setAlmacenId((FacesUtils.checkLong(txtAlmacenId) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId))
					: null);

			entityDetProd
					.setCompartimientosEquipo(
							(FacesUtils.checkLong(txtCompartimientosEquipoProdId) != null)
									? businessDelegatorView.getCompartimientosEquipo(
											FacesUtils.checkLong(txtCompartimientosEquipoProdId))
									: null);

			entityDetProd.setUbicacionesAlmacen((FacesUtils.checkLong(txtUbAlmacen) != null)
					? businessDelegator2View.getUbicacionesAlmacen(FacesUtils.checkLong(txtUbAlmacen))
					: null);

			entityDetProd.setTipoSuministro(FacesUtils.checkString(txtTipoSuministro));

			businessDelegatorView.updateDatMantenimientoEquipoProd(entityDetProd);
			action_clear();

			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public DefaultStreamedContent getFile01() {
		return file01;
	}

	public void setFile01(DefaultStreamedContent file01) {
		this.file01 = file01;
	}

	public void action_descargarfoto1(ActionEvent evt) {

		selectedListadoMtto = (ProgMttoPreventivosMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedListadoMtto"));

		try {

			Long datMantenimientoEquipoId = selectedListadoMtto.getId_mtto().longValue();
			Object[] condicion = { "datMantenimientoEquipoId", true, datMantenimientoEquipoId, "=" };
			List<DatMantenimientoEquipo> lista = (datMantenimientoEquipoId != null)
					? businessDelegatorView.findByCriteriaInDatMantenimientoEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				String rutaDescarga = servletContext.getRealPath("") + File.separator + "imagenes_subidas"
						+ File.separator;

				if (entity.getFoto() != null && !entity.getFoto().equals("")) {

					abrirFichero(rutaDescarga + entity.getFoto());

					/*
					 * File file = new File(rutaDescarga + imagen1); InputStream input = new
					 * FileInputStream(file); ExternalContext externalContext =
					 * FacesContext.getCurrentInstance().getExternalContext(); setFile01(new
					 * DefaultStreamedContent(input, externalContext.getMimeType(file.getName()),
					 * file.getName()));
					 */

					// externalContext.responseComplete();

					// System.out.println("PREP = " + file01.getName());

					/*
					 * try { //Desktop.getDesktop().open(file); } catch (IOException e) {
					 * e.printStackTrace(); }
					 */

				}

			}

		} catch (Exception e) {
			System.out.println(e);
			entity = null;
		}

	}

	public void abrirFichero(String ruta) {
		try {
			File archivo = new File(ruta);
			FacesContext context = FacesContext.getCurrentInstance();
			FileInputStream fis = new FileInputStream(archivo);
			int longitud;

			longitud = fis.available();

			byte[] datos = new byte[longitud];
			int read = 0;

			if (!context.getResponseComplete()) {
				String fileName = archivo.getName();
				String contentType = "application/octet-stream";

				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

				response.setContentType(contentType);

				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

				ServletOutputStream out = response.getOutputStream();

				while ((read = fis.read(datos)) != -1) {
					out.write(datos, 0, read);
				}

				out.flush();
				out.close();
				context.responseComplete();
			}

			fis.read(datos);
			fis.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public StreamedContent getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(StreamedContent fileImagen) {
		this.fileImagen = fileImagen;
	}

	public String actionDeleteProductoMtto(ActionEvent evt) {
		try {
			selectedListadoProductos = (SolicitudesMttoEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedListadoProductos"));

			Long datMantenimientoEquipoProdId = new Long(
					selectedListadoProductos.getDatMantenimientoEquipoProdId().longValue());
			entityDetProd = businessDelegatorView.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);

			action_deleteProducto();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_deleteProducto() throws Exception {
		try {
			businessDelegatorView.deleteDatMantenimientoEquipoProd(entityDetProd);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			listarMantenimientosProductos();
		} catch (Exception e) {
			throw e;
		}
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

	public SelectOneMenu getTxtDescargaInventario() {
		return txtDescargaInventario;
	}

	public void setTxtDescargaInventario(SelectOneMenu txtDescargaInventario) {
		this.txtDescargaInventario = txtDescargaInventario;
	}

}