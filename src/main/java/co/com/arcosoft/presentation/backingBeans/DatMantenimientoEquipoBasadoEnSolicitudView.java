package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AgenteCausadorParada;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.AreaTrabajo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatHorasTrabajoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipoMec;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.MotivosEntradaTaller;
import co.com.arcosoft.modelo.NivelPrioridad;
import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.TallerMecanico;
import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.ZonasFabrica;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.modelo.informes.dto.CalculoProxMttoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatMantenimientoEquipoBasadoEnSolicitudView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoBasadoEnSolicitudView.class);
	private InputText txtCierreOt;
	private InputText txtCompania;

	private SelectOneMenu txtConductor;
	SelectItem[] selectConductor;
	private List<Trabajador> conductor;

	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtOrderTrabajo;
	private InputTextarea txtReporteTecnico;
	private InputText txtUsuarioDigitacion;
	//private InputText txtVidaHora;
	private InputText txtVidaHora;
	private InputText txtVidaKm;

	private SelectOneMenu txtAgenteCausadorParadaId_AgenteCausadorParada;
	SelectItem[] selectAgenteCausador;
	private List<AgenteCausadorParada> agenteCausador;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	// equipo industrial
	private SelectOneMenu txtEquipoId_Industrial;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtMotivosEntradaTallerId_MotivosEntradaTaller;
	SelectItem[] selectMotivoEntradaTaller;
	private List<MotivosEntradaTaller> motivoEntradaTaller;

	private SelectOneMenu txtPlanRevisionEquipoId_PlanRevisionEquipo;
	SelectItem[] selectPlanRevision;
	private List<PlanRevisionEquipo> planRevision;

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

	private SelectOneMenu txtAlmacenId;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;

	private InputText txtCantidadProd;
	private InputText txtCostoTotalProd;
	private InputText txtValorUnitarioProd;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

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
	private SelectOneMenu txtOrigenDatos;

	private SelectOneMenu txtCompartimientosEquipoId;
	SelectItem[] selectCompartimientosEquipo;
	private List<CompartimientosEquipo> compartimiento;

	private SelectOneMenu txtSistemasEquipoId;
	SelectItem[] selectSistemasEquipo;
	private List<SistemasEquipo> sistema;

	private String solicitudId;
	private String idSolicitante;
	private String nombreSolicitante;
	private String equipo_id;
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

	private String nivel_prioridad_id;
	private String taller_id;
	private String tipo_mantenimiento_id;
	private String tag_id;
	private DatHorasTrabajoEquipo entity_hrt;
	private PlanRevisionEquipoDet entity_prdet;
	private Equipo entity_equipo;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private int activeTapIndex = 0;
	
	private SelectOneMenu txtCompartimientosEquipoProdId;
	SelectItem[] selectCompartimientosEquipoProd;
	private List<CompartimientosEquipo> compartimientoProd;

	private SelectOneMenu txtSistemasEquipoProdId;
	SelectItem[] selectSistemasEquipoProd;
	private List<SistemasEquipo> sistemaProd;

	private InputText txtCodCompartimientoEquipoProd;
	private InputText txtCodSistemaEquipoProd;
	
	private String requeridoHorometro = "false";
	private String requeridoOdometro = "false";
	
	private Calendar txtFechaProd;

	public DatMantenimientoEquipoBasadoEnSolicitudView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatMantenimientoEquipoDTO datMantenimientoEquipoDTO = (DatMantenimientoEquipoDTO) e.getObject();

			if (txtCierreOt == null) {
				txtCierreOt = new InputText();
			}

			txtCierreOt.setValue(datMantenimientoEquipoDTO.getCierreOt());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datMantenimientoEquipoDTO.getCompania());

			if (txtConductor == null) {
				txtConductor = new SelectOneMenu();
			}

			txtConductor.setValue(datMantenimientoEquipoDTO.getConductor());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datMantenimientoEquipoDTO.getConsecutivo());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datMantenimientoEquipoDTO.getEstado());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datMantenimientoEquipoDTO.getObservacionAnularReg());

			if (txtOrderTrabajo == null) {
				txtOrderTrabajo = new InputText();
			}

			txtOrderTrabajo.setValue(datMantenimientoEquipoDTO.getOrderTrabajo());

			if (txtReporteTecnico == null) {
				txtReporteTecnico = new InputTextarea();
			}

			txtReporteTecnico.setValue(datMantenimientoEquipoDTO.getReporteTecnico());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datMantenimientoEquipoDTO.getUsuarioDigitacion());

			if (txtVidaHora == null) {
				txtVidaHora = new InputText();
			}

			txtVidaHora.setValue(datMantenimientoEquipoDTO.getVidaHoras());

			if (txtVidaKm == null) {
				txtVidaKm = new InputText();
			}

			txtVidaKm.setValue(datMantenimientoEquipoDTO.getVidaKm());

			if (txtAgenteCausadorParadaId_AgenteCausadorParada == null) {
				txtAgenteCausadorParadaId_AgenteCausadorParada = new SelectOneMenu();
			}

			txtAgenteCausadorParadaId_AgenteCausadorParada
					.setValue(datMantenimientoEquipoDTO.getAgenteCausadorParadaId_AgenteCausadorParada());

			if (txtCentCostId_CentCost == null) {
				txtCentCostId_CentCost = new SelectOneMenu();
			}

			txtCentCostId_CentCost.setValue(datMantenimientoEquipoDTO.getCentCostId_CentCost());

			if (txtEquipoId_Equipo == null) {
				txtEquipoId_Equipo = new SelectOneMenu();
			}

			txtEquipoId_Equipo.setValue(datMantenimientoEquipoDTO.getEquipoId_Equipo());

			if (txtMotivosEntradaTallerId_MotivosEntradaTaller == null) {
				txtMotivosEntradaTallerId_MotivosEntradaTaller = new SelectOneMenu();
			}

			txtMotivosEntradaTallerId_MotivosEntradaTaller
					.setValue(datMantenimientoEquipoDTO.getMotivosEntradaTallerId_MotivosEntradaTaller());

			if (txtPlanRevisionEquipoId_PlanRevisionEquipo == null) {
				txtPlanRevisionEquipoId_PlanRevisionEquipo = new SelectOneMenu();
			}

			txtPlanRevisionEquipoId_PlanRevisionEquipo
					.setValue(datMantenimientoEquipoDTO.getPlanRevisionEquipoId_PlanRevisionEquipo());

			if (txtTallerMecanicoId_TallerMecanico == null) {
				txtTallerMecanicoId_TallerMecanico = new SelectOneMenu();
			}

			txtTallerMecanicoId_TallerMecanico.setValue(datMantenimientoEquipoDTO.getTallerMecanicoId_TallerMecanico());

			if (txtTipoMantenimientoId_TipoMantenimiento == null) {
				txtTipoMantenimientoId_TipoMantenimiento = new SelectOneMenu();
			}

			txtTipoMantenimientoId_TipoMantenimiento
					.setValue(datMantenimientoEquipoDTO.getTipoMantenimientoId_TipoMantenimiento());

			if (txtSolicitante == null) {
				txtSolicitante = new SelectOneMenu();
			}

			txtSolicitante.setValue(datMantenimientoEquipoDTO.getTrabId_Trabajador());

			if (txtDatMantenimientoEquipoId == null) {
				txtDatMantenimientoEquipoId = new InputText();
			}

			txtDatMantenimientoEquipoId.setValue(datMantenimientoEquipoDTO.getDatMantenimientoEquipoId());

			if (txtDuracion == null) {
				txtDuracion = new Calendar();
			}

			txtDuracion.setValue(datMantenimientoEquipoDTO.getDuracion());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datMantenimientoEquipoDTO.getFechaAnulacion());

			if (txtFechaCierreOt == null) {
				txtFechaCierreOt = new Calendar();
			}

			txtFechaCierreOt.setValue(datMantenimientoEquipoDTO.getFechaCierreOt());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datMantenimientoEquipoDTO.getFechaCreacion());

			if (txtFechaEntradaTaller == null) {
				txtFechaEntradaTaller = new Calendar();
			}

			txtFechaEntradaTaller.setValue(datMantenimientoEquipoDTO.getFechaEntradaTaller());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datMantenimientoEquipoDTO.getFechaModificacion());

			if (txtFechaReaperturaOt == null) {
				txtFechaReaperturaOt = new Calendar();
			}

			txtFechaReaperturaOt.setValue(datMantenimientoEquipoDTO.getFechaReaperturaOt());

			Long datMantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
			entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() throws Exception {
		action_clear();
		selectedDatMantenimientoEquipo = null;
		setShowDialog(true);

		return "";
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Object contextPath = peticion.getContextPath();

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

	public String action_clear() throws Exception {
		entity = null;
		entity_hrt = null;
		entity_prdet = null;
		entity_equipo = null;
		selectedDatMantenimientoEquipo = null;
		PrimeFaces.current().resetInputs(":dialogDatMantenimientoEquipo :frm");
		activeTapIndex = 0;

		moduloSeleccionado();
		Long idSolicitud = 0L;
		if(!solicitudId.equals(null)){
			idSolicitud = new Long(solicitudId);
		}
		Long idSolicitudExistente = businessDelegatorView.consultarExistenciaOtParaSolicitudMq(idSolicitud) ;
		
		if(idSolicitudExistente == 0){
		
		// información compartida entre modulos

		if (txtCierreOt != null) {
			txtCierreOt.setValue("A");
			txtCierreOt.setDisabled(false);
		}

		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(solicitud);
			txtDescripcionSolicitud.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
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
				txtTallerMecanicoId_TallerMecanico.setDisabled(true);
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
			txtFechaRegistro.setValue(null);
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
			txtFechaProd.setValue(null);
			txtFechaProd.setDisabled(false);
		}
		
	 }else{
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!",
					"Esta intentando generar una Orden de trabajo para una solicitud que ya tiene una OT registrada. "));
		 action_clear2();
	 }
		return "";

	}

	public void listener_txtDuracion() {
		Date inputDate = (Date) txtDuracion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaAnulacion() {
		Date inputDate = (Date) txtFechaAnulacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCierreOt() {
		Date inputDate = (Date) txtFechaCierreOt.getValue();
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

	public void listener_txtFechaEntradaTaller() {
		Date inputDate = (Date) txtFechaEntradaTaller.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaSalidaTaller() {
		Date inputDate = (Date) txtFechaSalidaTaller.getValue();
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

	public void listener_txtFechaReaperturaOt() {
		Date inputDate = (Date) txtFechaReaperturaOt.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
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
		if (txtMecanico.getValue() != null && txtCeptoNominaId_ConceptoNomina.getValue() != null
				&& txtCeptoNominaId_ConceptoNomina.getValue() != null && txtCantidadMec.getValue() != null
				&& txtUdadMedMec.getValue() != null
				&& txtTarea.getValue() != null && txtFechaRegistro != null) {
		
		Long mecanicoId = Long.parseLong(txtMecanico.getValue().toString());
		Trabajador mecanico = businessDelegatorView.getTrabajador(mecanicoId);

		Long udadMedId_UdadMed = Long.parseLong(txtUdadMedMec.getValue().toString());
		UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

		Long conceptoNominaId = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());
		ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);

		CompartimientosEquipo compartimiento =null;
		SistemasEquipo sistema = null;
		String codsistema = null;
		Long sistemaId = null;
		Long compartientoId = null;
		String codCompartimiento = null;
		//Long sistemaId2 = Long.parseLong(txtSistemasEquipoId.getValue().toString());
		if(txtSistemasEquipoId.getValue() !=null){
			sistemaId = FacesUtils.checkLong(txtSistemasEquipoId);
			sistema = businessDelegatorView.getSistemasEquipo(sistemaId);
			 codsistema = sistema.getCodigo();

		}
		if(txtCompartimientosEquipoId.getValue() !=null){
			
		 compartientoId = Long.parseLong(txtCompartimientosEquipoId.getValue().toString());
		 compartimiento = businessDelegatorView.getCompartimientosEquipo(compartientoId);
		  codCompartimiento = compartimiento.getCodigo();
			
		}
		
		String codTrabajador = mecanico.getCodigo();
		String codConceptoNomina = conceptoNomina.getCodigo();
		String codUdadMedNomina = udadMed.getCodigo();
		Double cantidadPago = FacesUtils.checkDouble(txtCantidadMec);
		Double valorUnit = FacesUtils.checkDouble(txtValorUnitarioMec);
		Double costoTotal = FacesUtils.checkDouble(txtCostoTotalMec);
		Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

		Long codTarea = FacesUtils.checkLong(txtTarea);
		Labor tarea = businessDelegatorView.getLabor(codTarea);
		Date horaIni = FacesUtils.checkDate(txtHoraIniMec);
		Date horaFin = FacesUtils.checkDate(txtHoraFinMec);
		String codLabor =tarea.getCodigo();
		// String codLabor =tarea.getCodigo().toString();

		// boolean existe= false;

		if (dataEquipoMec == null) {
			dataEquipoMec = new ArrayList<DatMantenimientoEquipoMecDTO>();

		}

		
		DatMantenimientoEquipoMecDTO datMantenimientoEquipoMec = new DatMantenimientoEquipoMecDTO();
		datMantenimientoEquipoMec.setTrabId_Trabajador(mecanico);
		datMantenimientoEquipoMec.setCeptoNominaId_ConceptoNomina(conceptoNomina);
		datMantenimientoEquipoMec.setUdadMedId_UdadMed(udadMed);
		datMantenimientoEquipoMec.setCantidad(cantidadPago);
		datMantenimientoEquipoMec.setCodTrabajador(codTrabajador);
		datMantenimientoEquipoMec.setCodConcepto(codConceptoNomina);
		datMantenimientoEquipoMec.setCodUdadMed(codUdadMedNomina);
		datMantenimientoEquipoMec.setCostoTotal(costoTotal);
		datMantenimientoEquipoMec.setValorUnitario(valorUnit);
		datMantenimientoEquipoMec.setFechaRegistro(fechaRegistro);
		datMantenimientoEquipoMec.setLaborId_Labor(tarea);
		datMantenimientoEquipoMec.setHoraIniMec(horaIni);
		datMantenimientoEquipoMec.setHoraFinMec(horaFin);
		datMantenimientoEquipoMec.setCodLabor(codLabor);
		datMantenimientoEquipoMec.setCodCompartimiento(codCompartimiento);
		datMantenimientoEquipoMec.setCodSistema(codsistema);
		datMantenimientoEquipoMec.setCompartimiento(compartimiento);
		datMantenimientoEquipoMec.setSistema(sistema);

		dataEquipoMec.add(datMantenimientoEquipoMec);
		
		sistema = null;
		compartimiento = null;
		mecanico = null;
		conceptoNomina = null;
		udadMed = null;
		codTrabajador = null;
		codConceptoNomina = null;
		codUdadMedNomina = null;
		costoTotal = null;
		valorUnit = null;
		cantidadPago = null;
		codTarea = null;
		tarea = null;
		horaIni = null;
		horaFin = null;
		codCompartimiento = null;
		codsistema = null;
		// dataDetProductos = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos de fecha de atención, trabajador, unidad de medida, concepto, cantidad tengan valores. "));
		}
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
		BigDecimal cantidad = (FacesUtils.checkBigDecimal(txtCantidadMec));
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		BigDecimal tarifaPagoP = new BigDecimal("0");
		BigDecimal tarifaNoEncontrada = new BigDecimal("0");
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
		BigDecimal tarifaPago = new BigDecimal("0");

		if (idUdadMed != null) {
			try {

				Double tarifaPagox = businessDelegatorView.consultarPrecioPromProducto(idProducto, idAlmacen, idCompania,
						idFecha);
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
		if (txtProductoId_Producto.getValue() != null && txtUdadMedProd.getValue() != null
				&& txtJefeMtto.getValue() != null && txtAlmacenId.getValue() != null
				&& txtFechaProd.getValue() != null
				&& txtCantidadProd.getValue() !=null ) {
		
		Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
		Producto producto = businessDelegatorView.getProducto(productoId);

		Long udadMedId_UdadMed = Long.parseLong(txtUdadMedProd.getValue().toString());
		Long jefeMtto = Long.parseLong(txtJefeMtto.getValue().toString());
		Trabajador trabajador = businessDelegatorView.getTrabajador(jefeMtto);

		Long almacenId = Long.parseLong(txtAlmacenId.getValue().toString());
		Almacen almacen = businessDelegatorView.getAlmacen(almacenId);

		UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
		String tipoSuministro = (FacesUtils.checkString(txtTipoSuministro));

		String codTrabajador = trabajador.getCodigo();
		String codAlmacen = almacen.getCodigo();
		String codProducto = producto.getCodigo();
		String codUdadMed = udadMed.getCodigo();
		Double cantidadAplicada = FacesUtils.checkDouble(txtCantidadProd);
		Double costoTotal = FacesUtils.checkDouble(txtCostoTotalProd);
		Double valorUnit = FacesUtils.checkDouble(txtValorUnitarioProd);
		Date fechaProd =  FacesUtils.checkDate(txtFechaProd);
		
		CompartimientosEquipo compartimiento =null;
		SistemasEquipo sistema = null;
		
		Long sistemaId = null;
		Long compartientoId = null;
		String codsistema =null;
		 String codCompartimiento = null;
		//Long sistemaId2 = Long.parseLong(txtSistemasEquipoId.getValue().toString());
		if(txtSistemasEquipoProdId.getValue() !=null){
			sistemaId = FacesUtils.checkLong(txtSistemasEquipoProdId);
			sistema = businessDelegatorView.getSistemasEquipo(sistemaId);
			 codsistema = sistema.getCodigo();
		}
		if(txtCompartimientosEquipoProdId.getValue() !=null){
			
		 compartientoId = Long.parseLong(txtCompartimientosEquipoProdId.getValue().toString());
		 compartimiento = businessDelegatorView.getCompartimientosEquipo(compartientoId);
		  codCompartimiento = compartimiento.getCodigo();;
		}
		
		

		boolean existeProducto = false;

		if (dataEquipoProd == null) {
			dataEquipoProd = new ArrayList<DatMantenimientoEquipoProdDTO>();

		}

		if (dataEquipoProd.size() > 0) {

			for (DatMantenimientoEquipoProdDTO d : dataEquipoProd) {

				if (d.getProductoId_Producto().getProductoId().longValue() == producto.getProductoId().longValue()) {

					existeProducto = true;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
									"El producto " + d.getProductoId_Producto().getProductoId().longValue()
											+ " ya fue agregado a la lista, por favor seleccione otro. "));

					break;
				}
			}

		}

		if (existeProducto == false) {

			DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO = new DatMantenimientoEquipoProdDTO();
			datMantenimientoEquipoProdDTO.setProductoId_Producto(producto);
			datMantenimientoEquipoProdDTO.setUdadMedId_UdadMed(udadMed);
			datMantenimientoEquipoProdDTO.setCodProducto(codProducto);
			datMantenimientoEquipoProdDTO.setCodUdadMed(codUdadMed);
			datMantenimientoEquipoProdDTO.setCantidad(cantidadAplicada);
			datMantenimientoEquipoProdDTO.setCostoTotal(costoTotal);
			datMantenimientoEquipoProdDTO.setValorUnitario(valorUnit);
			datMantenimientoEquipoProdDTO.setAlmacenId(almacen);
			datMantenimientoEquipoProdDTO.setTrabId_Trabajador(trabajador);
			datMantenimientoEquipoProdDTO.setCodAlmacen(codAlmacen);
			datMantenimientoEquipoProdDTO.setCodTrabajador(codTrabajador);
			datMantenimientoEquipoProdDTO.setTipoSuministro(tipoSuministro);
			datMantenimientoEquipoProdDTO.setCodCompartimientosEquipo(codCompartimiento);
			datMantenimientoEquipoProdDTO.setCodSistemasEquipo(codsistema);
			datMantenimientoEquipoProdDTO.setCompartimientosEquipo(compartimiento);
			datMantenimientoEquipoProdDTO.setSistemasEquipo(sistema);
			datMantenimientoEquipoProdDTO.setFechaRegistro(fechaProd);

			dataEquipoProd.add(datMantenimientoEquipoProdDTO);

		}
		codCompartimiento=null;
		codsistema=null;
		compartimiento=null;
		sistema=null;
		producto = null;
		udadMedId_UdadMed = null;
		cantidadAplicada = null;
		costoTotal = null;
		codProducto = null;
		codUdadMed = null;
		almacen = null;
		trabajador = null;
		valorUnit = null;
		codAlmacen = null;
		codTrabajador = null;
		tipoSuministro = null;

		// dataDetProductos = null;
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos de fecha de requesición, almacén, producto, jefe de Mtto, unidad de medida,  cantidad tengan valores. "));
		
		}
	}


	public void listener_ConsultaUmProducto() {

		Long productoId = null;

		if (!txtProductoId_Producto.getValue().equals("")) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtUdadMedProd.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				//txtCodProducto.setValue(producto.getNombre());
				Long udadMedId = Long.parseLong(txtUdadMedProd.getValue().toString());

				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				//txtCodUdadMedProd.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodAlmacen() {

		Long almacenId = null;
		if (FacesUtils.checkLong(txtAlmacenId) != null) {
			if (!txtAlmacenId.getValue().equals("")) {
				almacenId = Long.parseLong(txtAlmacenId.getValue().toString());

				try {
					Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
					/* valNPass = datPlanLabor.getNPases(); */
					txtCodAlmacen.setValue(almacen.getNombre());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}
			}
		}

	}

	public void listener_ConsultaCodJefeMtto() {

		Long trabajadorId = null;
		if (FacesUtils.checkLong(txtJefeMtto) != null) {
			if (!txtJefeMtto.getValue().equals("")) {
				trabajadorId = Long.parseLong(txtJefeMtto.getValue().toString());

				try {
					Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);
					/* valNPass = datPlanLabor.getNPases(); */
					txtCodJefeMtto.setValue(trabajador.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}
			}
		}

	}

	
	

	public void listener_ConsultaCodSistemaProd() {

		Long id = null;

		if (FacesUtils.checkLong(txtSistemasEquipoProdId) != null) {

			if (!txtSistemasEquipoProdId.getValue().equals("")) {

				id = Long.parseLong(txtSistemasEquipoProdId.getValue().toString());

				try {
					SistemasEquipo l = businessDelegatorView.getSistemasEquipo(id);
					txtCodSistemaEquipoProd.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodSCompartimientoProd() {

		Long id = null;

		if (FacesUtils.checkLong(txtCompartimientosEquipoProdId) != null) {

			if (!txtCompartimientosEquipoProdId.getValue().equals("")) {

				id = Long.parseLong(txtCompartimientosEquipoProdId.getValue().toString());

				try {
					CompartimientosEquipo l = businessDelegatorView.getCompartimientosEquipo(id);
					txtCodCompartimientoEquipoProd.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
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

		selectedDatMantenimientoEquipo = (DatMantenimientoEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatMantenimientoEquipo"));
		try {

			Long consecutivo = selectedDatMantenimientoEquipo.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatMantenimientoEquipo> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatMantenimientoEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				// txtOrigenDatos.setValue(entity.getOrigenDatos());
				// txtOrigenDatos.setDisabled(true);
				txtDescripcionSolicitud.setValue(entity.getDescripcionSolicitud());
				txtDescripcionSolicitud.setDisabled(false);
				txtConductor.setValue(entity.getConductor());
				txtConductor.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				txtDuracion.setValue(entity.getDuracion());
				txtDuracion.setDisabled(false);
				txtFechaEntradaTaller.setValue(entity.getFechaEntradaTaller());
				txtFechaEntradaTaller.setDisabled(false);
				txtReporteTecnico.setValue(entity.getReporteTecnico());
				txtReporteTecnico.setDisabled(false);
				txtVidaHora.setDisabled(false);
				txtVidaKm.setDisabled(false);
				txtRequiereParadaFabrica.setValue(entity.getRequiereParadaFabrica());
				txtRequiereParadaFabrica.setDisabled(false);


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

				} else {

					ocultaMttoIndustrial = "block";
					ocultaMttoMaquinaria = "none";

					compoRequieridoMttoIndustrial = "true";
					compoRequieridoMttoMaquinaria = "false";

					txtTallerMecanicoId_TallerMecanico.setDisabled(true);
					txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
					txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					txtTagId_Tag.setDisabled(false);
					txtZonasFabricaId_ZonasFabrica.setDisabled(false);

				}

				txtAreaTrabajoId_AreaTrabajo.setValue(selectedDatMantenimientoEquipo.getAreaTrabajoId_AreaTrabajo());
				txtNivelPrioridadId_NivelPrioridad
						.setValue(selectedDatMantenimientoEquipo.getNivelPrioridadId_NivelPrioridad());
				txtTagId_Tag.setValue(selectedDatMantenimientoEquipo.getTagId_Tag());
				txtZonasFabricaId_ZonasFabrica
						.setValue(selectedDatMantenimientoEquipo.getZonasFabricaId_ZonasFabrica());

				txtAgenteCausadorParadaId_AgenteCausadorParada
						.setValue(selectedDatMantenimientoEquipo.getAgenteCausadorParadaId_AgenteCausadorParada());
				txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);
				// txtCentCostId_CentCost.setValue(selectedDatMantenimientoEquipo.getCentCostId_CentCost());
				// txtCentCostId_CentCost.setDisabled(false);
				txtEquipoId_Equipo.setValue(selectedDatMantenimientoEquipo.getEquipoId_Equipo().getEquipoId());
				txtEquipoId_Equipo.setDisabled(false);
				txtMotivosEntradaTallerId_MotivosEntradaTaller
						.setValue(selectedDatMantenimientoEquipo.getMotivosEntradaTallerId_MotivosEntradaTaller());
				txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);
				txtPlanRevisionEquipoId_PlanRevisionEquipo
						.setValue(selectedDatMantenimientoEquipo.getPlanRevisionEquipoId_PlanRevisionEquipo());
				txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
				txtTallerMecanicoId_TallerMecanico
						.setValue(selectedDatMantenimientoEquipo.getTallerMecanicoId_TallerMecanico());

				txtTipoMantenimientoId_TipoMantenimiento
						.setValue(selectedDatMantenimientoEquipo.getTipoMantenimientoId_TipoMantenimiento());
				txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
				txtSolicitante.setValue(selectedDatMantenimientoEquipo.getTrabId_Trabajador());
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
				txtCantidadMec.setDisabled(false);
				txtCostoTotalMec.setDisabled(false);
				txtValorUnitarioMec.setDisabled(false);
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				txtMecanico.setDisabled(false);
				txtUdadMedMec.setDisabled(false);
				
				Date date = new Date();
				txtFechaRegistro.setValue(date);
				txtFechaRegistro.setDisabled(false);
				btnAgregarMecanico.setDisabled(false);

				txtAlmacenId.setDisabled(false);
				txtCantidadProd.setDisabled(false);
				txtCostoTotalProd.setDisabled(false);
				txtProductoId_Producto.setDisabled(false);
				txtValorUnitarioProd.setDisabled(false);
				txtJefeMtto.setDisabled(false);
				txtUdadMedProd.setDisabled(false);
				btnAgregarProd.setDisabled(false);

			//	txtCodJefeMtto.setDisabled(false);
				//	txtCodProducto.setDisabled(false);
				//	txtCodAlmacen.setDisabled(false);
				//	txtCodUdadMedProd.setDisabled(false);
				//	txtCodMecanico.setDisabled(false);
				//	txtCodUdadMedMec.setDisabled(false);
				//	txtCodConceptoNomina.setDisabled(false);

				txtTipoSuministro.setDisabled(false);

				txtCompartimientosEquipoProdId.setDisabled(false);
				txtSistemasEquipoProdId.setDisabled(false);
				//	txtCodSistemaEquipoProd.setDisabled(false);
				//	txtCodCompartimientoEquipoProd.setDisabled(false);
				txtFechaRegistro.setValue(date);
				txtFechaProd.setDisabled(false);
				

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

							if (medidor.getTipoMedidor().equals("horometro")) {

								Double valor = Double.parseDouble(businessDelegatorView
										.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());
								txtVidaActual.setValue(valor);
								txtVidaActual.setDisabled(true);
								txtVidaHora.setValue(selectedDatMantenimientoEquipo.getVidaHoras().doubleValue());
								txtVidaHora.setDisabled(false);
								txtVidaKm.setDisabled(true);
								txtVidaKm.setValue(null);

							} else if (medidor.getTipoMedidor().equals("odometro")) {

								Double valor = Double.parseDouble(businessDelegatorView
										.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

								txtVidaActual.setValue(valor);
								txtVidaActual.setDisabled(true);
								txtVidaKm.setValue(selectedDatMantenimientoEquipo.getVidaKm().doubleValue());
								txtVidaKm.setDisabled(false);
								txtVidaHora.setDisabled(true);
								txtVidaHora.setValue(null);

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

							}
						}

					} else {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

						txtVidaActual.setDisabled(true);
						txtVidaActual.setValue(null);
						txtVidaHora.setValue(null);
						txtVidaKm.setValue(null);
						txtVidaHora.setDisabled(true);
						txtVidaKm.setDisabled(true);

					}
				}

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
			entity = new DatMantenimientoEquipo();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			boolean flagGrabar = false;
			boolean flagGrabarPlanDet = false;

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
			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania,"correctivo")));
			// entity.setDatMantenimientoEquipoId(datMantenimientoEquipoId);
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
			entity.setAreaTrabajo((FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo))
					: null);
			entity.setNivelPrioridad((FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad) != null)
					? businessDelegatorView.getNivelPrioridad(FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad))
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
			entity.setPlanRevisionEquipo(
					(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo) != null)
							? businessDelegatorView.getPlanRevisionEquipo(
									FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo))
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

			entity.setFechaSalidaTaller(FacesUtils.checkDate(txtFechaSalidaTaller));
			
			entity.setVidaHoras(FacesUtils.checkDouble(txtVidaHora));
			entity.setVidaKm(FacesUtils.checkDouble(txtVidaKm));

			
			// actualizando registro plaan revisión det
			entity_prdet= null;
		
			Long IdEquipo = entity.getEquipo().getEquipoId();
			Long IdPlanRevision = entity.getPlanRevisionEquipo().getPlanRevisionEquipoId();
			Date fecha = entity.getFechaEntradaTaller();

			// actualizar fecha de ultimo servicio
			
			entity_equipo=null;
			entity_equipo = new Equipo();
			entity_equipo = businessDelegatorView.getEquipo(IdEquipo);
			entity_equipo.setFechaUltimoServicios(fecha);

			// creando registro dat_horas_trabajadas
			entity_hrt = null;
			Equipo equipo = null;
			Medidor medidor = null;

			entity_hrt = new DatHorasTrabajoEquipo();
			entity_hrt.setConsecutivo(businessDelegatorView.consultarConsecutivoRegistroHorasEquipo(compania));
			entity_hrt.setEstado("A");
			entity_hrt.setCompania(compania);
			entity_hrt.setUsuarioDigitacion(usuarioId);
			entity_hrt.setFechaRegistro(entity.getFechaEntradaTaller());
			entity_hrt.setOrigenDatos(entity.getOrigenDatos());
			entity_hrt.setEquipo(entity.getEquipo());

			entity_hrt.setFechaCreacion(date);

			if (entity.getVidaHoras() != null) {
				entity_hrt.setHorasActual(entity.getVidaHoras());
			} else {
				entity_hrt.setHorasActual(null);
			}

			if (entity.getVidaKm() != null) {
				entity_hrt.setKmActual(entity.getVidaKm());
			} else {
				entity_hrt.setKmActual(null);
			}

			entity_hrt.setObservacion("Registro creado automaticamente desde mantenimiento equipos/maquinaria");
			equipo = businessDelegatorView.getEquipo(entity.getEquipo().getEquipoId());
			
			if (equipo.getMedidor() != null) {
            
				medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
				entity_hrt.setMedidor(medidor.getMedidorId().doubleValue());
				Long idMedidor = medidor.getMedidorId();
				Long equipoId = entity.getEquipo().getEquipoId();
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				PlanRevisionEquipoDet pdet = new PlanRevisionEquipoDet();

				if (medidor.getTipoMedidor().equals("horometro")) {
					
					// llamado del procedimiento para actualizacion registro plaan revisión det
					
					Double horasIngresadas = entity.getVidaHoras().doubleValue();
					
					List<CalculoProxMttoDTO> listHr = businessDelegatorView.consultarProximoMtto(fecha, IdEquipo,
							IdPlanRevision, horasIngresadas , 0.0);
					entity_prdet = businessDelegatorView
							.getPlanRevisionEquipoDet(listHr.get(0).getPlan_revision_equipo_det_id().longValue());
					
					Double hrps = listHr.get(0).getHoras_prox_mtto().doubleValue();

					entity_prdet.setPlanRevisionEquipoDetId(listHr.get(0).getPlan_revision_equipo_det_id().longValue());
					entity_prdet.setEquipo(equipo);
					entity_prdet.setPlanRevisionEquipo(entity.getPlanRevisionEquipo());
					entity_prdet.setFechaProxServicio(listHr.get(0).getFecha_prox_mtto());
					entity_prdet.setHorasProxServicio(hrps);
					entity_prdet.setHorasUltimoServicio(horasIngresadas);
					entity_prdet.setFechaUltimoServicio(fecha);
					entity_prdet.setSistemasEquipo(entity_prdet.getSistemasEquipo());
					entity_prdet.setCompartimientosEquipo(entity_prdet.getCompartimientosEquipo());
					


					Double valor = Double.parseDouble(businessDelegatorView
							.consultarHorometroActual(entity.getFechaEntradaTaller(), equipoId, idMedidor, compania)
							.toString());
					
					

					if (entity.getVidaHoras().doubleValue() < valor) {

						flagGrabar = false;

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!",
								"El Horómetro digitado de la maquinaria/equipo debe ser mayor que el anterior"));

					} else {

						flagGrabar = true;

					}

				}

				if (medidor.getTipoMedidor().equals("odometro")) {

					Double valor = Double.parseDouble(businessDelegatorView
							.consultarOdometroActual(entity.getFechaEntradaTaller(), equipoId, idMedidor, compania)
							.toString());
					
		            // llamado del procedimiento para actualizacion registro plaan revisión det
					
					Double kmIngresadas = entity.getVidaKm().doubleValue();
					
					List<CalculoProxMttoDTO> listHr = businessDelegatorView.consultarProximoMtto(fecha, IdEquipo,
							IdPlanRevision, 0.0 , kmIngresadas);
					entity_prdet = businessDelegatorView
							.getPlanRevisionEquipoDet(listHr.get(0).getPlan_revision_equipo_det_id().longValue());
					
					Double kmps = listHr.get(0).getKm_prox_mtto().doubleValue();

					entity_prdet.setPlanRevisionEquipoDetId(listHr.get(0).getPlan_revision_equipo_det_id().longValue());
					entity_prdet.setEquipo(equipo);
					entity_prdet.setPlanRevisionEquipo(entity.getPlanRevisionEquipo());
					entity_prdet.setFechaProxServicio(listHr.get(0).getFecha_prox_mtto());
					entity_prdet.setKmProxServicio(kmps);
					entity_prdet.setKmUltimoServicio(kmIngresadas);
					entity_prdet.setFechaUltimoServicio(fecha);
					entity_prdet.setSistemasEquipo(entity_prdet.getSistemasEquipo());
					entity_prdet.setCompartimientosEquipo(entity_prdet.getCompartimientosEquipo());

					if (entity.getVidaKm().doubleValue() < valor) {

						flagGrabar = false;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
										"El Odómetro digitado de la maquinaria/equipo debe ser mayor que el anterior"));

					} else {

						flagGrabar = true;
					}

				}

			} else {

				flagGrabar = false;

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
						"La Maquinaria y/o el Equipo no tiene medidor asignado, por favor registrarlo antes de continuar."));

			}
			
			if (flagGrabar) {

				businessDelegatorView.saveDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd, null, entity_hrt);
				businessDelegatorView.updateEquipo(entity_equipo, null, null);
				
				if(entity_prdet !=null) {
				   businessDelegatorView.updatePlanRevisionEquipoDet(entity_prdet);
				}
			
				
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
						+ (businessDelegatorView.consultarConsecutivoMantenimientoMaquinaria(compania,"correctivo") - 1));

				action_clear();
			}else {
				entity = null;
				entity_hrt = null;
				entity_equipo = null;
				entity_prdet= null;
				equipo = null;
				medidor = null;
			}
			
		} catch (Exception e) {
			
			entity = null;
			entity_hrt = null;
			entity_equipo = null;
			entity_prdet= null;
			equipo = null;
			//medidor = null;
			
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long datMantenimientoEquipoId = new Long(selectedDatMantenimientoEquipo.getDatMantenimientoEquipoId());
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
			entity.setPlanRevisionEquipo(
					(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo) != null)
							? businessDelegatorView.getPlanRevisionEquipo(
									FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo))
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
			businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd, null);
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
				Long id = new Long(selectedDatMantenimientoEquipo.getDatMantenimientoEquipoId());
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

	public String action_anularReg(ActionEvent evt) throws Exception {

		action_clear();
		selectedDatMantenimientoEquipo = (DatMantenimientoEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatMantenimientoEquipo"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_cierreReaperturaOt(ActionEvent evt) {

		selectedDatMantenimientoEquipo = (DatMantenimientoEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatMantenimientoEquipo"));

		try {

			Long id = new Long(selectedDatMantenimientoEquipo.getDatMantenimientoEquipoId());
			entity = businessDelegatorView.getDatMantenimientoEquipo(id);

			if (entity.getCierreOt().equals("A")) {

				Date date = new Date();
				entity.setFechaCierreOt(date);
				entity.setCierreOt("C");

				Long mantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
				dataEquipoMec = null;
				dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(mantenimientoEquipoId);
				dataEquipoProd = null;
				dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(mantenimientoEquipoId);

				businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd, null);

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYCLOSEOT);
				action_clear();
				data = null;

			} else {

				Date date = new Date();
				entity.setFechaReaperturaOt(date);
				entity.setCierreOt("A");

				Long mantenimientoEquipoId = FacesUtils.checkLong(txtDatMantenimientoEquipoId);
				dataEquipoMec = null;
				dataEquipoMec = businessDelegatorView.getDataDatMantenimientoEquipoMecByMec(mantenimientoEquipoId);
				dataEquipoProd = null;
				dataEquipoProd = businessDelegatorView.getDataDatMantenimientoEquipoProdByProd(mantenimientoEquipoId);

				businessDelegatorView.updateDatMantenimientoEquipo(entity, dataEquipoMec, dataEquipoProd, null);

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
			selectedDatMantenimientoEquipo = (DatMantenimientoEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatMantenimientoEquipo"));

			Long datMantenimientoEquipoId = new Long(selectedDatMantenimientoEquipo.getDatMantenimientoEquipoId());
			entity = businessDelegatorView.getDatMantenimientoEquipo(datMantenimientoEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
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

	public String action_closeDialog() throws Exception {
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


	
	public SelectItem[] getselectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "equipoId", true, equipo_id, "=", 
						"origenDatos", true,	origendatos, "=" };
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

	public SelectItem[] getSelectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			centCost = new ArrayList<CentCost>();

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

			motivoEntradaTaller = new ArrayList<MotivosEntradaTaller>();

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

			agenteCausador = new ArrayList<AgenteCausadorParada>();

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

			tipoMantenimiento = new ArrayList<TipoMantenimiento>();

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

		Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

		if (equipoId != null && !equipoId.toString().isEmpty()) {

			try {

				List<PlanRevisionEquipoDetDTO> prqdet = businessDelegatorView
						.getDataPlanRevisionEquipoDetByEquipoId(equipoId);

				if (prqdet != null && prqdet.size() > 0) {

					Object[] condicion = { "estado", true, "A", "=" };
					List<PlanRevisionEquipo> lista1 = businessDelegatorView
							.findByCriteriaInPlanRevisionEquipo(condicion, null, null);

					selectPlanRevision = new SelectItem[prqdet.size()];

					int i = 0;
					for (PlanRevisionEquipo planRevision : lista1) {

						for (PlanRevisionEquipoDetDTO preDTO : prqdet) {

							if (preDTO.getPlanRevisionEquipoId_PlanRevisionEquipo().longValue() == planRevision
									.getPlanRevisionEquipoId().longValue()) {

								selectPlanRevision[i] = new SelectItem(planRevision.getPlanRevisionEquipoId(),
										planRevision.getCodigo()+"-"+ planRevision.getNombre());
								i++;

							}

						}

					}

				} else {

					Object[] condicion = { "estado", true, "A", "=" };
					List<PlanRevisionEquipo> lista = businessDelegatorView.findByCriteriaInPlanRevisionEquipo(condicion,
							null, null);
					selectPlanRevision = new SelectItem[lista.size()];

					int i = 0;
					for (PlanRevisionEquipo planRevision : lista) {
						selectPlanRevision[i] = new SelectItem(planRevision.getPlanRevisionEquipoId(),
								planRevision.getNombre());
						i++;

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return selectPlanRevision;
	}

	public void setselectPlanRevision(SelectItem[] selectPlanRevision) {
		this.selectPlanRevision = selectPlanRevision;
	}

	public SelectItem[] getselectLaborId() {

		List<PlanRevisionEquipoActivDTO> lista1 = null;
		List<Labor> lista2 = null;
		Long planRevisionId = FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo);
		String tipoLabor = null;

		if (planRevisionId != null && !planRevisionId.toString().isEmpty()) {
			
			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				tipoLabor="Mtto_Maquinaria";
			} else {
				tipoLabor="Mtto_Industial";
			}

			try {

				PlanRevisionEquipo prq = businessDelegatorView.getPlanRevisionEquipo(planRevisionId);
				String tipoPlan = prq.getTipoPlan().toString();

				if (tipoPlan.equals("Preventivo")) {

					lista1 = businessDelegatorView.getDataPlanRevisionEquipoActivByEquipo(planRevisionId);
					selectLaborId = new SelectItem[lista1.size()];

					int i = 0;

					for (PlanRevisionEquipoActivDTO planRevisionEquipoActiv : lista1) {

						selectLaborId[i] = new SelectItem(planRevisionEquipoActiv.getLaborId().getLaborId(),
								planRevisionEquipoActiv.getLaborId().getNombre());

						i++;

					}

				} else if(tipoPlan.equals("Correctivo")) {

					Object[] condicion2 = {"estado",true,"A","=", 
							               "tipoLabor", true, tipoLabor.toString(),"=" };

					lista2 = businessDelegatorView.findByCriteriaInLabor(condicion2, null, null);
					selectLaborId = new SelectItem[lista2.size()];
                   
					if(lista2 !=null & lista2.size() > 0) {				
                    	int i = 0;
						for (Labor laborId : lista2) {
							selectLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
							i++;
	
						}
					
                    }
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return selectLaborId;

	}

	public void setselectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getselectSolicitante() {

		if (solicitante == null || solicitante.size() == 0) {

			solicitante = new ArrayList<Trabajador>();

			try {

				Object[] condicion = { "estado", true, "A", "=", "trabId", true, idSolicitante, "=" };
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

			conductor = new ArrayList<Trabajador>();

			try {

				conductor = businessDelegatorView.getTrabajador(); // Fin by
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

			tallerMecanico = new ArrayList<TallerMecanico>();

			try {
				Object[] condicion = { "estado", true, "A", "=" , "tallerMecanicoId", true,  taller_id, "="};
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

			mecanico = new ArrayList<Trabajador>();

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

			jefeMtto = new ArrayList<Trabajador>();

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


	public SelectItem[] getSelectProductoId() {
		if (productoId == null || productoId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				
				// Criteria
				List<CatalogProductoDTO> listaProductos= businessDelegatorView
						.consultarCatalogoProductosMtto(idCompania);
				selectProductoId = new SelectItem[listaProductos.size()];
				int i = 0;
				for (CatalogProductoDTO listaDTO : listaProductos) {
					selectProductoId[i] = new SelectItem(listaDTO.getProductoId().longValue(),
							listaDTO.getCodigo() +"-"+listaDTO.getNombre()
					);
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

				Object[] condicion = { "estado", true, "A", "=",   "nivelPrioridadId", true, nivel_prioridad_id, "="};
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

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
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

	/**
	 * @return the equipo_id
	 */
	public String getEquipo_id() {
		return equipo_id;
	}

	/**
	 * @param equipo_id the equipo_id to set
	 */
	public void setEquipo_id(String equipo_id) {
		this.equipo_id = equipo_id;
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

	public List<PlanRevisionEquipo> getPlanRevision() {
		return planRevision;
	}

	public void setPlanRevision(List<PlanRevisionEquipo> planRevision) {
		this.planRevision = planRevision;
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


	
	
		/**
	 * @return the nivel_prioridad_id
	 */
	public String getNivel_prioridad_id() {
		return nivel_prioridad_id;
	}

	/**
	 * @param nivel_prioridad_id the nivel_prioridad_id to set
	 */
	public void setNivel_prioridad_id(String nivel_prioridad_id) {
		this.nivel_prioridad_id = nivel_prioridad_id;
	}

	/**
	 * @return the taller_id
	 */
	public String getTaller_id() {
		return taller_id;
	}

	/**
	 * @param taller_id the taller_id to set
	 */
	public void setTaller_id(String taller_id) {
		this.taller_id = taller_id;
	}

	

	/**
	 * @return the tipo_mantenimiento_id
	 */
	public String getTipo_mantenimiento_id() {
		return tipo_mantenimiento_id;
	}

	/**
	 * @param tipo_mantenimiento_id the tipo_mantenimiento_id to set
	 */
	public void setTipo_mantenimiento_id(String tipo_mantenimiento_id) {
		this.tipo_mantenimiento_id = tipo_mantenimiento_id;
	}

	/**
	 * @return the tag_id
	 */
	public String getTag_id() {
		return tag_id;
	}

	/**
	 * @param tag_id the tag_id to set
	 */
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
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
	 * @return the txtCompartimientosEquipoProdId
	 */
	public SelectOneMenu getTxtCompartimientosEquipoProdId() {
		return txtCompartimientosEquipoProdId;
	}

	/**
	 * @param txtCompartimientosEquipoProdId the txtCompartimientosEquipoProdId to set
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
	 * @param txtCodCompartimientoEquipoProd the txtCodCompartimientoEquipoProd to set
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
	
	public SelectItem[] getselectSistemasEquipoProd() {

		if (sistemaProd == null || sistemaProd.size() == 0) {

			sistemaProd = new ArrayList<SistemasEquipo>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemasEquipo> lista = businessDelegatorView.findByCriteriaInSistemasEquipo(condicion, null,
						null);
				selectSistemasEquipoProd = new SelectItem[lista.size()];

				int i = 0;
				for (SistemasEquipo sistemaProd : lista) {
					selectSistemasEquipoProd[i] = new SelectItem(sistemaProd.getSistemasEquipoId(), sistemaProd.getNombre());
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

			compartimientoProd = new ArrayList<CompartimientosEquipo>();

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

	

	public void listener_ConsultaDatosEquipo() {

		Long equipoid = null;

		if (txtEquipoId_Equipo.getValue()!=null) {
			equipoid = Long.parseLong(txtEquipoId_Equipo.getValue().toString());

			try {
				Equipo equipo = businessDelegatorView.getEquipo(equipoid);
				/* valNPass = datPlanLabor.getNPases(); */
				if(equipo.getTagId()!=null){
					txtTagId_Tag.setValue(equipo.getTagId().longValue());
				}


					Long compania = new Long(getCompaniaIdSession());

					//txtVidaActual.setValue(null);
					//txtVidaHora.setValue(null);
					//txtVidaKm.setValue(null);
					java.util.Date fechaReg = new Date();
					GregorianCalendar cHoy = new GregorianCalendar();
					if(txtFechaEntradaTaller.getValue()!=null){
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

							if (medidor.getTipoMedidor().equals("horometro")) {

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
								requeridoOdometro = "true";
								requeridoHorometro = "false";
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
						txtVidaHora.setValue(null);
						txtVidaKm.setValue(null);
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


		if (txtHoraIniMec.getValue() !=null && txtHoraFinMec.getValue() !=null) {
			
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
			Date fechaInicial = FacesUtils.checkDate(txtHoraIniMec);
			Date fechaFinal  =FacesUtils.checkDate(txtHoraFinMec);
			
			GregorianCalendar horaInicial = new GregorianCalendar();
			horaInicial.setTime(FacesUtils.checkDate(txtHoraIniMec));
			Double horaI = (double) horaInicial.get(java.util.Calendar.HOUR_OF_DAY);
			
			GregorianCalendar minInicial = new GregorianCalendar();
			minInicial.setTime(FacesUtils.checkDate(txtHoraIniMec));
			Double minI =(double) minInicial.get(java.util.Calendar.MINUTE);
			
			Double horaIni = horaI +(minI/60);
			
			
			GregorianCalendar horaFinal = new GregorianCalendar();
			horaFinal.setTime(FacesUtils.checkDate(txtHoraFinMec));
			Double horaF = (double) horaFinal.get(java.util.Calendar.HOUR_OF_DAY);
			
			GregorianCalendar minFinal = new GregorianCalendar();
			minFinal.setTime(FacesUtils.checkDate(txtHoraFinMec));
			Double minF =(double) minFinal.get(java.util.Calendar.MINUTE);
			
			Double horaFin = horaF +(minF/60);
			
			Double horas = 0.0;
			
			if(horaFin.equals(horaIni) ){
				horas = 24.0 ;
			}
			
			if(horaFin.equals(0.0) && !horaFin.equals(horaIni)){
				horas = 24 - horaIni;
			}
			
			if(!horaFin.equals(0.0) && !horaFin.equals(horaIni)){
				horas = horaFin - horaIni;
			}
			
			//horas = businessDelegatorView.calcularHoras(fechaFinal, fechaInicial);
			String format = decimalFormat.format(horas);
			txtCantidadMec.setValue(format);
						
		}

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

	

	public String action_clear2() {
		entity = null;
		entity_hrt = null;
		entity_prdet = null;
		entity_equipo = null;
		selectedDatMantenimientoEquipo = null;
		PrimeFaces.current().resetInputs(":dialogDatMantenimientoEquipo :frm");
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
				txtTallerMecanicoId_TallerMecanico.setDisabled(true);
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
			btnSave.setDisabled(true);
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


}
