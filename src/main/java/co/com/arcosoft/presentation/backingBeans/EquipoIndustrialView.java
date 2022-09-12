package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
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
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.colorpicker.ColorPicker;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.EquipoEvento;
import co.com.arcosoft.modelo.Eventos;
import co.com.arcosoft.modelo.FlotaTransporte;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.NumeroEje;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.TarifaEquipProp;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.EquipoDTO;
import co.com.arcosoft.modelo.dto.EquipoEventoDTO;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EquipoIndustrialView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EquipoIndustrialView.class);
	private InputText txtAnioFabricacion;
	private InputText txtCodigo;
	private ColorPicker txtColor;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputText txtFoto;
	private SelectOneMenu txtTipoPropiedad;
	private SelectOneMenu txtFuncion;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtPlaca;
	private InputText txtTaraEstandar;
	private InputText txtEquipoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<EquipoDTO> data;
	private EquipoDTO selectedEquipo;
	private Equipo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;

	private SelectOneMenu txtContratistaId_Contratista;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtFlotaTranspId_FlotaTransporte;
	SelectItem[] selectFlotaTransporte;
	private List<FlotaTransporte> flotaTransporte;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLabor;
	private List<Labor> labor;

	private SelectOneMenu txtMedidorId_Medidor;
	SelectItem[] selectMedidor;
	private List<Medidor> medidor;

	private SelectOneMenu txtModeloEquipoId_ModeloEquipo;
	SelectItem[] selectModeloEquipo;
	private List<ModeloEquipo> modeloEquipo;

	private SelectOneMenu txtNumEjeId_NumeroEje;
	SelectItem[] selectNumeroEje;
	private List<NumeroEje> numeroEje;

	private SelectOneMenu txtServicioId_Servicio;
	SelectItem[] selectServicio;
	private List<Servicio> servicio;

	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipo;

	private SelectOneMenu txtProducto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private InputText txtConsumoGlHora;
	private InputText txtConsumoKmGl;
	private InputText txtHorometroActual;
	private InputText txtOdometroActual;

	private InputText txtHorasDiaEstandar;
	private InputText txtKmDiaEstandar;

	/********************/
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private Calendar txtFechaUltimoServicios;
	private Calendar txtFechaUltimoAbastecimiento;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtLaborIdLaborTarifa;
	SelectItem[] selectLaborId_tarifa;
	private List<Labor> laborId_tarifa;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private List<TarifaEquipPropDTO> dataTarifaEquipProp;
	private TarifaEquipPropDTO selectedTarifaEquipProp;

	private InputText txtCodLaborTarifa;

	private TarifaEquipProp entityTarifaEquipProp;
	/********************/
	private InputText txtCodUdadMed;

	private String txtImagenEquipo;
	private String imagenEquipo;
	private UploadedFile file;

	/***** Eventos *******/

	private Calendar txtFechaInicialVencimiento;
	private Calendar txtFechaFinalVencimiento;

	private EquipoEventoDTO selectedEventosEquiposId;

	private EquipoEvento entityEquipoEvento;

	private SelectOneMenu txtEvento;
	SelectItem[] selectEvento;
	private List<Eventos> eventos;

	private Long diasNotificacion;

	private boolean disabledCampos;

	private CommandButton btnAgregarEventos;

	private List<EquipoEventoDTO> dataEventosEquipos;

	private String fechaIni = "";
	private String fechaFin = "";
	private String descripcion = "";
	private String titulo = "";
	private String localizacion = "";
	private String url = "";
	private String fechaNotificacion = "";
	private SelectOneMenu txtOrigenDatos;
	private String moduloActivo;
	private String ocultaMttoIndustrial = "none";
	private String ocultaMttoMaquinaria = "none";

	private InputText txtAltura;
	private InputText txtDiametro;
	private InputText txtTamano;
	private InputText txtPresion;
	private InputText txtCaudal;
	private InputText txtSerial;
	private InputText txtRevoluciones;
	private InputText txtPotencia;
	private InputText txtVoltaje;
	private InputText txtCorriente;
	private int activeTapIndex = 0;
	private String modulo;

	private SelectOneMenu txtTagId_Tag;
	SelectItem[] selectTag;
	private List<Tag> tag;


	public EquipoIndustrialView() {
		super();
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

			txtOrigenDatos.setValue("Modulo_TallerAgricola");
			txtOrigenDatos.setDisabled(false);
			modulo  = "Mtto_Maquinaria";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

		} 
		
		if (moduloActivo.equals("admin_agricola")) {

			txtOrigenDatos.setValue("Modulo_TallerAgricola");
			txtOrigenDatos.setDisabled(false);
			modulo  = "Admin_Agricola";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

		} 

		
		if (moduloActivo.equals("prod_agricola")) {

			txtOrigenDatos.setValue("Modulo_TallerAgricola");
			txtOrigenDatos.setDisabled(false);
			modulo  = "Mtto_Industial";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

		} 
		
		if (moduloActivo.equals("mantenimiento_industrial")){

			txtOrigenDatos.setValue("Modulo_MttoIndustrial");
			txtOrigenDatos.setDisabled(false);

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

		}
	}

	public void rowEventListener(RowEditEvent e) {

		FacesMessage msg = new FacesMessage("Car Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		try {
			EquipoDTO equipoDTO = (EquipoDTO) e.getObject();

			if (txtAnioFabricacion == null) {
				txtAnioFabricacion = new InputText();
			}

			txtAnioFabricacion.setValue(equipoDTO.getAnioFabricacion());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(equipoDTO.getCodigo());

			if (txtColor == null) {
				txtColor = new ColorPicker();
			}

			txtColor.setValue(equipoDTO.getColor());

			if (txtTipoPropiedad == null) {
				txtTipoPropiedad = new SelectOneMenu();
			}

			txtTipoPropiedad.setValue(equipoDTO.getTipoPropiedad());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(equipoDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(equipoDTO.getEstado());

			if (txtFoto == null) {
				txtFoto = new InputText();
			}

			txtFoto.setValue(equipoDTO.getFoto());

			if (txtFuncion == null) {
				txtFuncion = new SelectOneMenu();
			}

			txtFuncion.setValue(equipoDTO.getFuncion());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(equipoDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(equipoDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(equipoDTO.getNombre());

			if (txtPlaca == null) {
				txtPlaca = new InputText();
			}

			txtPlaca.setValue(equipoDTO.getPlaca());

			if (txtTaraEstandar == null) {
				txtTaraEstandar = new InputText();
			}

			txtTaraEstandar.setValue(equipoDTO.getTaraEstandar());

			if (txtCategEquipId_CategoriaEquipo == null) {
				txtCategEquipId_CategoriaEquipo = new SelectOneMenu();
			}

			txtCategEquipId_CategoriaEquipo.setValue(equipoDTO.getCategEquipId_CategoriaEquipo());

			if (txtCentCostId_CentCost == null) {
				txtCentCostId_CentCost = new SelectOneMenu();
			}

			txtCentCostId_CentCost.setValue(equipoDTO.getCentCostId_CentCost());

			if (txtContratistaId_Contratista == null) {
				txtContratistaId_Contratista = new SelectOneMenu();
			}

			txtContratistaId_Contratista.setValue(equipoDTO.getContratistaId_Contratista());

			if (txtElemCostoId_ElementoCosto == null) {
				txtElemCostoId_ElementoCosto = new SelectOneMenu();
			}

			txtElemCostoId_ElementoCosto.setValue(equipoDTO.getElemCostoId_ElementoCosto());

			if (txtFlotaTranspId_FlotaTransporte == null) {
				txtFlotaTranspId_FlotaTransporte = new SelectOneMenu();
			}

			txtFlotaTranspId_FlotaTransporte.setValue(equipoDTO.getFlotaTranspId_FlotaTransporte());

			if (txtLaborId_Labor == null) {
				txtLaborId_Labor = new SelectOneMenu();
			}

			txtLaborId_Labor.setValue(equipoDTO.getLaborId_Labor());

			if (txtMedidorId_Medidor == null) {
				txtMedidorId_Medidor = new SelectOneMenu();
			}

			txtMedidorId_Medidor.setValue(equipoDTO.getMedidorId_Medidor());

			if (txtModeloEquipoId_ModeloEquipo == null) {
				txtModeloEquipoId_ModeloEquipo = new SelectOneMenu();
			}

			txtModeloEquipoId_ModeloEquipo.setValue(equipoDTO.getModeloEquipoId_ModeloEquipo());

			if (txtNumEjeId_NumeroEje == null) {
				txtNumEjeId_NumeroEje = new SelectOneMenu();
			}

			txtNumEjeId_NumeroEje.setValue(equipoDTO.getNumEjeId_NumeroEje());

			if (txtServicioId_Servicio == null) {
				txtServicioId_Servicio = new SelectOneMenu();
			}

			txtServicioId_Servicio.setValue(equipoDTO.getServicioId_Servicio());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(equipoDTO.getTrabId_Trabajador());

			if (txtEquipoId == null) {
				txtEquipoId = new InputText();
			}

			txtEquipoId.setValue(equipoDTO.getEquipoId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(equipoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(equipoDTO.getFechaModificacion());

			Long equipoId = FacesUtils.checkLong(txtEquipoId);
			entity = businessDelegatorView.getEquipo(equipoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_addEventoGoogleCalendar(ActionEvent evt) throws Exception {

		selectedEventosEquiposId = (EquipoEventoDTO) (evt.getComponent().getAttributes().get("selectedEquipoEventoId"));

		// Long eventosEquiposId = selectedEventosEquiposId.getId();

		GregorianCalendar calendarioPeriodoFin = new GregorianCalendar();
		GregorianCalendar calendarioPeriodoInicial = new GregorianCalendar();
		GregorianCalendar sumarDiasIni = new GregorianCalendar();

		Long eventosId = selectedEventosEquiposId.getEventosId_Eventos().getEventosId();
		Long equipoId = FacesUtils.checkLong(txtEquipoId);

		Equipo e = businessDelegatorView.getEquipo(equipoId);
		Eventos ev = businessDelegatorView.getEventos(eventosId);

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyMMdd");

		long dias = 0;
		long diasNotif = 0;
		int diasRestantes = 0;
		Date fechaDias = null;

		// Periodo Inicial

		calendarioPeriodoInicial.setTime(selectedEventosEquiposId.getFechaInicial());
		int diaI = calendarioPeriodoInicial.get(java.util.Calendar.DAY_OF_MONTH);
		int mesI = calendarioPeriodoInicial.get(java.util.Calendar.MONTH);
		int anoI = calendarioPeriodoInicial.get(java.util.Calendar.YEAR);
		calendarioPeriodoInicial.set(anoI, mesI, diaI);
		java.sql.Date fechaPeriodoInicial = new java.sql.Date(calendarioPeriodoInicial.getTimeInMillis());

		// Periodo Final

		calendarioPeriodoFin.setTime(selectedEventosEquiposId.getFechaFinal());
		int diaF = calendarioPeriodoFin.get(java.util.Calendar.DAY_OF_MONTH);
		int mesF = calendarioPeriodoFin.get(java.util.Calendar.MONTH);
		int anoF = calendarioPeriodoFin.get(java.util.Calendar.YEAR);
		calendarioPeriodoFin.set(anoF, mesF, diaF);
		java.sql.Date fechaPeriodoFinal = new java.sql.Date(calendarioPeriodoFin.getTimeInMillis());

		diasNotif = selectedEventosEquiposId.getDiasNotificacion().longValue();

		dias = (fechaPeriodoFinal.getTime() - fechaPeriodoInicial.getTime()) / (24 * 60 * 60 * 1000);

		if (dias > diasNotif) {
			diasRestantes = (int) (dias - diasNotif);
		} else {
			diasRestantes = (int) (diasNotif - dias);
		}

		// sumar dias a la fecha Inicial
		sumarDiasIni.setTime(selectedEventosEquiposId.getFechaInicial());
		int diaS = sumarDiasIni.get(java.util.Calendar.DAY_OF_MONTH);
		int mesS = sumarDiasIni.get(java.util.Calendar.MONTH);
		int anoS = sumarDiasIni.get(java.util.Calendar.YEAR);
		sumarDiasIni.set(anoF, mesF, diasRestantes + 2);
		java.sql.Date fechaFinalNotifi = new java.sql.Date(sumarDiasIni.getTimeInMillis());

		fechaIni = dmyFormat.format(selectedEventosEquiposId.getFechaInicial());
		fechaFin = dmyFormat.format(selectedEventosEquiposId.getFechaFinal());
		fechaNotificacion = dmyFormat.format(fechaFinalNotifi);

		titulo = "AgroView: Evento de compra: " + ev.getNombre() + " / " + e.getCodigo() + "-" + e.getNombre();
		descripcion = "Equipo: " + e.getCodigo() + "-" + e.getNombre() + " Vigencia: Fecha Inicial: "
				+ selectedEventosEquiposId.getFechaInicial().toString() + " Fecha Final: "
				+ selectedEventosEquiposId.getFechaFinal().toString();

		url = "http://www.google.com/calendar/event?action=TEMPLATE&text=" + titulo + "&details=" + descripcion
				+ "&dates=" + fechaIni + "/" + fechaNotificacion;

		PrimeFaces.current().ajax().addCallbackParam("url", url);

		clearEventos();

		return "";
	}

	public void clearEventos() {

		selectedEventosEquiposId = null;
		fechaIni = "";
		fechaFin = "";
		descripcion = "";
		titulo = "";
		localizacion = "";
		url = "";

	}

	public void notificacion_cantidadEventos() throws Exception {

		java.util.Date hoy = new Date();
		GregorianCalendar cPeriodoInicial = new GregorianCalendar();
		GregorianCalendar cPeriodoFinal = new GregorianCalendar();
		GregorianCalendar cHoy = new GregorianCalendar();
		GregorianCalendar cFechaNotificacion = new GregorianCalendar();
		long diasNotif = 0;
		long diasTotales = 0;
		int diasRestantes = 0;
		int contarEventos = 0;

		// List<EquipoEvento> equipoEvento = new ArrayList<EquipoEvento>();

		// EquipoEvento equipoEvento = null;

		// Long compania = new Long(getCompaniaIdSession());

		Object[] condicionEventos = { "estado", true, "A", "=" };

		List<EquipoEvento> equipoEvento = businessDelegatorView.findByCriteriaInEquipoEvento(condicionEventos, null,
				null);

		// equipoEvento = businessDelegatorView.getEquipoEvento();

		if (equipoEvento != null && equipoEvento.size() > 0) {

			for (EquipoEvento equipoEvento2 : equipoEvento) {

				if (equipoEvento2.getRegistraPago().equals("NO")) {

					cPeriodoInicial.setTime(equipoEvento2.getFechaInicial());
					int dia = cPeriodoInicial.get(java.util.Calendar.DAY_OF_MONTH);
					int mes = cPeriodoInicial.get(java.util.Calendar.MONTH);
					int ano = cPeriodoInicial.get(java.util.Calendar.YEAR);
					cPeriodoInicial.set(ano, mes, dia);
					java.sql.Date fechaPeriodoInicial = new java.sql.Date(cPeriodoInicial.getTimeInMillis());

					cPeriodoFinal.setTime(equipoEvento2.getFechaFinal());
					int diaF = cPeriodoFinal.get(java.util.Calendar.DAY_OF_MONTH);
					int mesF = cPeriodoFinal.get(java.util.Calendar.MONTH);
					int anoF = cPeriodoFinal.get(java.util.Calendar.YEAR);
					cPeriodoFinal.set(anoF, mesF, diaF);
					java.sql.Date fechaPeriodoFinal = new java.sql.Date(cPeriodoFinal.getTimeInMillis());

					cHoy.setTime(hoy);
					int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
					int mesHoy = cHoy.get(java.util.Calendar.MONTH);
					int anoHoy = cHoy.get(java.util.Calendar.YEAR);
					cHoy.set(anoHoy, mesHoy, diaHoy);
					java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

					diasNotif = equipoEvento2.getDiasNotificacion().longValue();
					diasTotales = (fechaPeriodoFinal.getTime() - fechaPeriodoInicial.getTime()) / (24 * 60 * 60 * 1000);

					if (diasTotales > diasNotif) {
						diasRestantes = (int) (diasTotales - diasNotif);
					} else {
						diasRestantes = (int) (diasNotif - diasTotales);
					}

					cFechaNotificacion.setTime(equipoEvento2.getFechaInicial());
					int diaNF = cFechaNotificacion.get(java.util.Calendar.DAY_OF_MONTH);
					int mesNF = cFechaNotificacion.get(java.util.Calendar.MONTH);
					int anoNF = cFechaNotificacion.get(java.util.Calendar.YEAR);
					cFechaNotificacion.set(anoNF, mesNF, diasRestantes + 1);
					java.sql.Date fechaNotificar = new java.sql.Date(cFechaNotificacion.getTimeInMillis());

					if (fechaHoy.getTime() >= fechaNotificar.getTime()) {

						contarEventos += contarEventos + 1;

					}

				}

			}

		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Notificación!",
				"Existen equipos con eventos " + contarEventos + " pendientes.."));

		// return contarEventos;
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		selectedEventosEquiposId = (EquipoEventoDTO) (evt.getComponent().getAttributes().get("selectedEquipoEventoId"));
		
		if (selectedEventosEquiposId.getId() != null) {

			Long eventosEquiposId = selectedEventosEquiposId.getId();
			Long equipoId = FacesUtils.checkLong(txtEquipoId);
			String columnaCell = evt.getColumn().getHeaderText();
	
			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityEquipoEvento = null;
				entityEquipoEvento = businessDelegatorView.getEquipoEvento(eventosEquiposId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityEquipoEvento.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityEquipoEvento.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Evento")) {
	
					Long EventoId = new Long(evt.getNewValue().toString());
					Eventos e = businessDelegatorView.getEventos(EventoId);
	
					entityEquipoEvento.setEventos(e);
	
				} else if (columnaCell.equals("Dias Notificación")) {
	
					entityEquipoEvento.setDiasNotificacion((Long) newValue);
				}
	
				entity = businessDelegatorView.getEquipo(equipoId);
				entityEquipoEvento.setEquipo(entity);
				businessDelegatorView.updateEquipoEvento(entityEquipoEvento);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				entity = null;
				dataEventosEquipos = null;
				selectedEventosEquiposId = null;
				entityEquipoEvento = null;
	
				dataEventosEquipos = businessDelegatorView.getDataEquipoEventoByEquipoId(equipoId);
	
			}
		
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEdit(CellEditEvent event) throws Exception {

		selectedTarifaEquipProp = (TarifaEquipPropDTO) (event.getComponent().getAttributes()
				.get("selectedTarifaEquipPropId"));
		
		if (selectedTarifaEquipProp.getTarifaEquipPropId() != null) {

			Long tarifaEquipPropId = selectedTarifaEquipProp.getTarifaEquipPropId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long equipoId = FacesUtils.checkLong(txtEquipoId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTarifaEquipProp = null;
				Date fechaModificacion = new Date();
	
				entityTarifaEquipProp = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityTarifaEquipProp.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityTarifaEquipProp.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Labor")) {
	
					Long LaborId = new Long(event.getNewValue().toString());
					Labor labor = businessDelegatorView.getLabor(LaborId);
	
					entityTarifaEquipProp.setLabor_tarifa(labor);
	
				} else if (columnaCell.equals("Unidad de medida")) {
	
					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);
	
					entityTarifaEquipProp.setUdadMed(udadMed);
	
				} else if (columnaCell.equals("Tarifa")) {
	
					Double tarifa = new Double(event.getNewValue().toString());
	
					entityTarifaEquipProp.setTarifa(tarifa);
	
				}
	
				entity = businessDelegatorView.getEquipo(equipoId);
				entityTarifaEquipProp.setEquipo(entity);
				entityTarifaEquipProp.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTarifaEquipProp(entityTarifaEquipProp);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataTarifaEquipProp = null;
				entityTarifaEquipProp = null;
				selectedTarifaEquipProp = null;
				entity = null;
	
				dataTarifaEquipProp = businessDelegatorView.getDataEquipoByTarifaEquipPropId(equipoId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public String action_new() {
		action_clear();
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedEquipo = null;
		PrimeFaces.current().resetInputs(":dialogEquipo :frm");
		dataTarifaEquipProp = null;
		dataEventosEquipos = null;
		moduloSeleccionado();	
		activeTapIndex = 0;

		if (txtAltura != null) {
			txtAltura.setValue(null);
			txtAltura.setDisabled(false);
		}
		
		if (txtDiametro != null) {
			txtDiametro.setValue(null);
			txtDiametro.setDisabled(false);
		}
		
		if (txtTamano != null) {
			txtTamano.setValue(null);
			txtTamano.setDisabled(false);
		}
		
		if (txtPresion != null) {
			txtPresion.setValue(null);
			txtPresion.setDisabled(false);
		}
		
		if (txtCaudal != null) {
			txtCaudal.setValue(null);
			txtCaudal.setDisabled(false);
		}
		
		if (txtSerial != null) {
			txtSerial.setValue(null);
			txtSerial.setDisabled(false);
		}
		
		if (txtRevoluciones != null) {
			txtRevoluciones.setValue(null);
			txtRevoluciones.setDisabled(false);
		}
		
		if (txtPotencia != null) {
			txtPotencia.setValue(null);
			txtPotencia.setDisabled(false);
		}
		
		if (txtVoltaje != null) {
			txtVoltaje.setValue(null);
			txtVoltaje.setDisabled(false);
		}
		
		if (txtCorriente != null) {
			txtCorriente.setValue(null);
			txtCorriente.setDisabled(false);
		}

		if (txtAnioFabricacion != null) {
			txtAnioFabricacion.setValue(null);
			txtAnioFabricacion.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtColor != null) {
			txtColor.setValue(null);
			// txtColor.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtFechaUltimoServicios != null) {
			txtFechaUltimoServicios.setValue(null);
			txtFechaUltimoServicios.setDisabled(true);
		}

		if (txtFechaUltimoAbastecimiento != null) {
			txtFechaUltimoAbastecimiento.setValue(null);
			txtFechaUltimoAbastecimiento.setDisabled(true);
		}

		if (txtTipoPropiedad != null) {
			txtTipoPropiedad.setValue(null);
			txtTipoPropiedad.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFoto != null) {
			txtFoto.setValue(null);
			txtFoto.setDisabled(true);
		}

		if (txtFuncion != null) {
			txtFuncion.setValue(null);
			txtFuncion.setDisabled(true);
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

		if (txtPlaca != null) {
			txtPlaca.setValue(null);
			txtPlaca.setDisabled(true);
		}

		if (txtTaraEstandar != null) {
			txtTaraEstandar.setValue(null);
			txtTaraEstandar.setDisabled(true);
		}

		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(true);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(true);
		}

		if (txtContratistaId_Contratista != null) {
			txtContratistaId_Contratista.setValue(null);
			txtContratistaId_Contratista.setDisabled(true);
		}

		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(true);
		}

		if (txtFlotaTranspId_FlotaTransporte != null) {
			txtFlotaTranspId_FlotaTransporte.setValue(null);
			txtFlotaTranspId_FlotaTransporte.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
		}

		if (txtLaborIdLaborTarifa != null) {
			txtLaborIdLaborTarifa.setValue(null);
			txtLaborIdLaborTarifa.setDisabled(true);
		}

		if (txtMedidorId_Medidor != null) {
			txtMedidorId_Medidor.setValue(null);
			txtMedidorId_Medidor.setDisabled(true);
		}

		if (txtModeloEquipoId_ModeloEquipo != null) {
			txtModeloEquipoId_ModeloEquipo.setValue(null);
			txtModeloEquipoId_ModeloEquipo.setDisabled(true);
		}

		if (txtNumEjeId_NumeroEje != null) {
			txtNumEjeId_NumeroEje.setValue(null);
			txtNumEjeId_NumeroEje.setDisabled(true);
		}

		if (txtServicioId_Servicio != null) {
			txtServicioId_Servicio.setValue(null);
			txtServicioId_Servicio.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtEquipoId != null) {
			txtEquipoId.setValue(null);
			txtEquipoId.setDisabled(false);
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

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtCodUdadMed != null) {
			txtCodUdadMed.setValue(null);
			txtCodUdadMed.setDisabled(true);
		}

		if (txtCodLaborTarifa != null) {
			txtCodLaborTarifa.setValue(null);
			txtCodLaborTarifa.setDisabled(true);
		}

		if (txtConsumoGlHora != null) {
			txtConsumoGlHora.setValue(null);
			txtConsumoGlHora.setDisabled(true);
		}

		if (txtConsumoKmGl != null) {
			txtConsumoKmGl.setValue(null);
			txtConsumoKmGl.setDisabled(true);
		}

		if (txtHorometroActual != null) {
			txtHorometroActual.setValue(null);
			txtHorometroActual.setDisabled(true);
		}

		if (txtOdometroActual != null) {
			txtOdometroActual.setValue(null);
			txtOdometroActual.setDisabled(true);
		}

		if (txtProducto != null) {
			txtProducto.setValue(null);
			txtProducto.setDisabled(true);
		}

		if (txtFechaFinalVencimiento != null) {
			txtFechaFinalVencimiento.setValue(null);
			txtFechaFinalVencimiento.setDisabled(true);
		}

		if (txtFechaInicialVencimiento != null) {
			txtFechaInicialVencimiento.setValue(null);
			txtFechaInicialVencimiento.setDisabled(true);
		}

		if (txtEvento != null) {
			txtEvento.setValue(null);
			txtEvento.setDisabled(true);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(false);
		}

		if (diasNotificacion != null) {
			diasNotificacion = null;
			disabledCampos = true;
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnAgregarEventos != null) {
			btnAgregarEventos.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		if (txtHorasDiaEstandar != null) {
			txtHorasDiaEstandar.setValue(null);
			txtHorasDiaEstandar.setDisabled(true);
		}
		if (txtKmDiaEstandar != null) {
			txtKmDiaEstandar.setValue(null);
			txtKmDiaEstandar.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaUltimoServicios() {
		Date inputDate = (Date) txtFechaUltimoServicios.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaUltimoAbastecimiento() {
		Date inputDate = (Date) txtFechaUltimoAbastecimiento.getValue();
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

	public List<TarifaEquipPropDTO> getDataEquipoByTarifaEquipPropId() {
		if (dataTarifaEquipProp == null || dataTarifaEquipProp.size() == 0) {
			return null;
		} else {
			return dataTarifaEquipProp;
		}

	}

	public List<EquipoEventoDTO> getDataEventosEquipos() {
		if (dataEventosEquipos == null || dataEventosEquipos.size() == 0) {
			return null;
		} else {
			return dataEventosEquipos;

		}

	}

	public void action_agregarEventos() throws Exception {
		if (txtFechaInicialVencimiento.getValue() != null && txtFechaFinalVencimiento.getValue() != null
				&& txtEvento.getValue() != null) {

			Date fechaInicialVencimiento = (FacesUtils.checkDate(txtFechaInicialVencimiento));
			Date fechaFinalVencimiento = (FacesUtils.checkDate(txtFechaFinalVencimiento));
			Long eventoId = FacesUtils.checkLong(txtEvento);
			Eventos eventos = businessDelegatorView.getEventos(eventoId);
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Long dias = diasNotificacion.longValue();

			if (dataEventosEquipos == null) {
				dataEventosEquipos = new ArrayList<EquipoEventoDTO>();
			}

			EquipoEventoDTO ee = new EquipoEventoDTO();
			ee.setEventosId_Eventos(eventos);
			ee.setFechaInicial(fechaInicialVencimiento);
			ee.setFechaFinal(fechaFinalVencimiento);
			ee.setFechaCreacion(fechaCreacion);
			ee.setFechaModificacion(fechaModificacion);
			ee.setDiasNotificacion(dias);
			ee.setRegistraPago("NO");

			dataEventosEquipos.add(ee);

			fechaInicialVencimiento = null;
			fechaFinalVencimiento = null;
			fechaCreacion = null;
			fechaModificacion = null;
			compania = null;
			eventoId = null;
			dias = null;
			diasNotificacion = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final y eventos tengan valores. "));
		}
	}

	public void action_agregarTarifaEquipProp() throws Exception {
		if (txtFechaInicial.getValue() != null && txtFechaFinal.getValue() != null
				&& txtLaborIdLaborTarifa.getValue() != null && txtUdadMedId_UdadMed.getValue() != null
				&& txtValorUnit.getValue() != null) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();

			Long laborId = Long.parseLong(txtLaborIdLaborTarifa.getValue().toString());
			Labor labor = businessDelegatorView.getLabor(laborId);
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
			String codUdadMed = FacesUtils.checkString(txtCodUdadMed);
			String codLabor = FacesUtils.checkString(txtCodLaborTarifa);
			Long compania = new Long(getCompaniaIdSession());
			boolean existeProducto = false;

			if (dataTarifaEquipProp == null) {
				dataTarifaEquipProp = new ArrayList<TarifaEquipPropDTO>();
			}

			if (dataTarifaEquipProp.size() > 0) {

				for (TarifaEquipPropDTO d : dataTarifaEquipProp) {

					if (d.getFechaInicial().toString().substring(0,10) == fechaInicial.toString().substring(0,10) && d.getFechaFinal().toString() == 
							fechaFinal.toString().substring(0,10)
									& d.getLabor_tarifa().getLaborId().longValue() == labor.getLaborId().longValue()
									& d.getUdadMedId_UdadMed().getUdadMedId()
											.longValue() == udadMed.getUdadMedId().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"La labor " + d.getLabor_tarifa().getNombre()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

			TarifaEquipPropDTO tarifaEquipPropDTO = new TarifaEquipPropDTO();
			tarifaEquipPropDTO.setFechaInicial(fechaInicial);
			tarifaEquipPropDTO.setFechaFinal(fechaFinal);
			tarifaEquipPropDTO.setLabor_tarifa(labor);
			tarifaEquipPropDTO.setUdadMedId_UdadMed(udadMed);
			tarifaEquipPropDTO.setTarifa(valorUnit);
			tarifaEquipPropDTO.setCodLabortarifa(codLabor);
			tarifaEquipPropDTO.setCodUdadMed(codUdadMed);
			tarifaEquipPropDTO.setCompania(compania);
			tarifaEquipPropDTO.setFechaCreacion(fechaCreacion);
			tarifaEquipPropDTO.setFechaModificacion(fechaModificacion);

			dataTarifaEquipProp.add(tarifaEquipPropDTO);
		}
			fechaInicial = null;
			fechaFinal = null;
			codUdadMed = null;
			labor = null;
			laborId = null;
			codLabor = null;
			codUdadMed = null;
			udadMed = null;
			valorUnit = null;
			compania = null;
			fechaCreacion = null;
			fechaModificacion = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final, labor, unidad de médida y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodLabor() {

		Long laborId_tarifa = null;

		if (!txtLaborIdLaborTarifa.getValue().equals("")) {
			laborId_tarifa = Long.parseLong(txtLaborIdLaborTarifa.getValue().toString());

			try {
				Labor labor = businessDelegatorView.getLabor(laborId_tarifa);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodLaborTarifa.setValue(labor.getCodigo().toString());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMed.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodUdadMed.setValue(udadMed.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_txtCodigo() throws Exception {
		try {
			
			moduloSeleccionado();
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Equipo> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInEquipo(condicion, null, null)
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
			activeTapIndex = 0;

			txtAnioFabricacion.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtColor.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			// txtFoto.setDisabled(false);
			String urlImageDefauld = "defauldImagen.png";
			txtImagenEquipo = urlImageDefauld;
			imagenEquipo = "default.jpg";

			txtTipoPropiedad.setDisabled(false);
			// txtFuncion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtTaraEstandar.setDisabled(false);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtCentCostId_CentCost.setDisabled(false);
			txtContratistaId_Contratista.setDisabled(false);
			txtElemCostoId_ElementoCosto.setDisabled(false);
			/// txtFlotaTranspId_FlotaTransporte.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtMedidorId_Medidor.setDisabled(false);
			txtModeloEquipoId_ModeloEquipo.setDisabled(false);
			txtNumEjeId_NumeroEje.setDisabled(false);
			// txtServicioId_Servicio.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtEquipoId.setDisabled(false);
			/*** sesion tarifa ***/
			txtValorUnit.setDisabled(false);
			txtCodUdadMed.setDisabled(false);
			txtLaborIdLaborTarifa.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtCodLaborTarifa.setDisabled(false);
			
			/***caracteristicas del equipo**/
			txtConsumoGlHora.setDisabled(true);
			txtConsumoKmGl.setDisabled(true);
			txtHorometroActual.setDisabled(true);
			txtOdometroActual.setDisabled(true);
			txtHorasDiaEstandar.setDisabled(true);
			txtKmDiaEstandar.setDisabled(true);

//			txtFechaUltimoServicios.setDisabled(false);
			txtProducto.setDisabled(false);
			txtFechaUltimoAbastecimiento.setDisabled(false);
			
			txtOrigenDatos.setDisabled(false);

			//sesion eventos
			txtEvento.setDisabled(false);
			txtFechaInicialVencimiento.setDisabled(false);
			
			txtFechaFinalVencimiento.setDisabled(false);
			
			txtTagId_Tag.setDisabled(false);
			
			btnAgregar.setDisabled(false);
			btnSave.setDisabled(false);

		} else {
			txtAnioFabricacion.setValue(entity.getAnioFabricacion());
			txtAnioFabricacion.setDisabled(false);
			txtCodUdadMed.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtColor.setValue(entity.getColor());
			
			if(entity.getTagId()!=null) {
				txtTagId_Tag.setValue(entity.getTagId());
			}
			txtTagId_Tag.setDisabled(false);
			
			// txtColor.setDisabled(false);
			txtTipoPropiedad.setValue(entity.getTipoPropiedad());
			txtTipoPropiedad.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			// txtFoto.setValue(entity.getFoto());
			// txtFoto.setDisabled(false);
			imagenEquipo = entity.getFoto();

			// txtFuncion.setValue(entity.getFuncion());
			// txtFuncion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtTaraEstandar.setValue(entity.getTaraEstandar());
			txtTaraEstandar.setDisabled(false);
			txtCategEquipId_CategoriaEquipo.setValue(entity.getCategoriaEquipo().getCategEquipId());
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtCentCostId_CentCost.setValue(entity.getCentCost());
			txtCentCostId_CentCost.setDisabled(false);
			txtContratistaId_Contratista.setValue(entity.getContratista().getPersEmprId());
			txtContratistaId_Contratista.setDisabled(false);
			txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
			txtElemCostoId_ElementoCosto.setDisabled(false);
			txtLaborId_Labor.setValue(entity.getLabor());
			txtLaborId_Labor.setDisabled(false);
			txtMedidorId_Medidor.setValue(entity.getMedidor());
			txtMedidorId_Medidor.setDisabled(false);
			txtModeloEquipoId_ModeloEquipo.setValue(entity.getModeloEquipo());
			txtModeloEquipoId_ModeloEquipo.setDisabled(false);
			txtNumEjeId_NumeroEje.setValue(entity.getNumeroEje());
			txtNumEjeId_NumeroEje.setDisabled(false);
			// txtServicioId_Servicio.setValue(entity.getServicio());
			// txtServicioId_Servicio.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtEquipoId.setValue(entity.getEquipoId());
			txtEquipoId.setDisabled(true);
			txtProducto.setValue(entity.getProductoId());
			txtProducto.setDisabled(false);
			txtFechaUltimoAbastecimiento.setValue(entity.getFechaUltimoAbastecimiento());
			txtFechaUltimoAbastecimiento.setDisabled(false);
			//txtFechaUltimoServicios.setValue(entity.getFechaUltimoServicios());
			//txtFechaUltimoServicios.setDisabled(false);
			txtOrigenDatos.setValue(entity.getOrigenDatos());
			txtOrigenDatos.setDisabled(false);

			Long compania = new Long(getCompaniaIdSession());
			Long equipoId = null;
			equipoId = entity.getEquipoId();

			GregorianCalendar cHoy = new GregorianCalendar();
			java.util.Date fechaReg = new java.util.Date();

			cHoy.setTime(fechaReg);
			int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
			int mesHoy = cHoy.get(java.util.Calendar.MONTH);
			int anoHoy = cHoy.get(java.util.Calendar.YEAR);
			cHoy.set(anoHoy, mesHoy, diaHoy);
			java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

			if (equipoId != null && !equipoId.toString().isEmpty()) {

				Equipo equipo = businessDelegatorView.getEquipo(equipoId);

				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
					Long idMedidor = medidor.getMedidorId();

					if (medidor.getTipoMedidor().equals("horometro")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

						txtHorometroActual.setValue(valor);
						txtHorometroActual.setDisabled(true);

						//txtOdometroActual.setValue(entity.getOdometroActual());
						txtOdometroActual.setDisabled(true);
						
						txtHorasDiaEstandar.setValue(entity.getHorasDiaEstandar());
						txtHorasDiaEstandar.setDisabled(false);
						txtKmDiaEstandar.setValue(entity.getKmDiaEstandar());
						txtKmDiaEstandar.setDisabled(true);
						
						txtConsumoGlHora.setValue(entity.getConsumoGlHora());
						txtConsumoGlHora.setDisabled(false);
						
						txtConsumoKmGl.setValue(entity.getConsumoKmGl());
						txtConsumoKmGl.setDisabled(true);


					}
					if (medidor.getTipoMedidor().equals("odometro")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

						txtOdometroActual.setValue(valor);
						txtOdometroActual.setDisabled(false);
						txtHorometroActual.setDisabled(true);
						
						txtHorasDiaEstandar.setValue(entity.getHorasDiaEstandar());
						txtHorasDiaEstandar.setDisabled(true);
						txtKmDiaEstandar.setValue(entity.getKmDiaEstandar());
						txtKmDiaEstandar.setDisabled(false);
						
						txtConsumoGlHora.setValue(entity.getConsumoGlHora());
						txtConsumoGlHora.setDisabled(true);
						
						txtConsumoKmGl.setValue(entity.getConsumoKmGl());
						txtConsumoKmGl.setDisabled(false);

					}
					if (medidor.getTipoMedidor().equals("averiado")) {

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
										"El medidor de la maquinaria/equipo se encuentra averiado"));
						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(true);
					}
				} else {

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

					txtHorometroActual.setDisabled(true);
					txtOdometroActual.setDisabled(true);
					txtHorometroActual.setValue(null);
					txtOdometroActual.setValue(null);

				}

			}

			/*** sesion tarifa ***/
			txtValorUnit.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtLaborIdLaborTarifa.setDisabled(false);
			txtCodLaborTarifa.setDisabled(false);
			btnAgregar.setDisabled(false);

			dataTarifaEquipProp = null;
			dataTarifaEquipProp = businessDelegatorView.getDataEquipoByTarifaEquipPropId(equipoId);

			dataEventosEquipos = null;
			dataEventosEquipos = businessDelegatorView.getDataEquipoEventoByEquipoId(equipoId);


			if (dataEventosEquipos != null) {
				txtEvento.setDisabled(false);
				txtFechaInicialVencimiento.setDisabled(false);
				txtFechaFinalVencimiento.setDisabled(false);
				btnAgregarEventos.setDisabled(false);
			}

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
				activeTapIndex = 0;

			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedEquipo = (EquipoDTO) (evt.getComponent().getAttributes().get("selectedEquipo"));
		PrimeFaces.current().resetInputs(":dialogEquipo :frm");

		try {

			Long equipoId = selectedEquipo.getEquipoId();
			Object[] condicion = { "equipoId", true, equipoId, "=" };
			List<Equipo> lista = (equipoId != null) ? businessDelegatorView.findByCriteriaInEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtOrigenDatos.setValue(entity.getOrigenDatos());
				txtOrigenDatos.setDisabled(false);

				txtAnioFabricacion.setValue(selectedEquipo.getAnioFabricacion());
				txtAnioFabricacion.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtColor.setValue(entity.getColor());
				// txtColor.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtTipoPropiedad.setValue(entity.getTipoPropiedad());
				txtTipoPropiedad.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(entity.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(entity.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				// txtFoto.setValue(entity.getFoto());
				// txtFoto.setDisabled(false);

				imagenEquipo = ((entity.getFoto() != null && !entity.getFoto().equals("")) ? entity.getFoto()
						: "default.jpg");

				// txtFuncion.setValue(entity.getFuncion());
				// txtFuncion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtTaraEstandar.setValue(entity.getTaraEstandar());
				txtTaraEstandar.setDisabled(false);
				txtCategEquipId_CategoriaEquipo.setValue(entity.getCategoriaEquipo().getCategEquipId());
				txtCategEquipId_CategoriaEquipo.setDisabled(false);
				
				if(entity.getTagId()!=null) {
					txtTagId_Tag.setValue(entity.getTagId());
				}
				txtTagId_Tag.setDisabled(false);
				
				txtCentCostId_CentCost.setValue(entity.getCentCost());
				txtCentCostId_CentCost.setDisabled(false);
				txtContratistaId_Contratista.setValue(entity.getContratista().getPersEmprId());
				txtContratistaId_Contratista.setDisabled(false);
				txtElemCostoId_ElementoCosto.setValue(entity.getElementoCosto());
				txtElemCostoId_ElementoCosto.setDisabled(false);
				txtLaborId_Labor.setValue(entity.getLabor());
				txtLaborId_Labor.setDisabled(false);
				txtMedidorId_Medidor.setValue(entity.getMedidor());
				txtMedidorId_Medidor.setDisabled(false);
				txtModeloEquipoId_ModeloEquipo.setValue(entity.getModeloEquipo());
				txtModeloEquipoId_ModeloEquipo.setDisabled(false);
				txtNumEjeId_NumeroEje.setValue(entity.getNumeroEje());
				txtNumEjeId_NumeroEje.setDisabled(false);
				// txtServicioId_Servicio.setValue(entity
				// .getServicio());
				// txtServicioId_Servicio.setDisabled(false);

				txtFechaUltimoAbastecimiento.setValue(entity.getFechaUltimoAbastecimiento());
				txtFechaUltimoAbastecimiento.setDisabled(false);
			    txtFechaUltimoServicios.setValue(entity.getFechaUltimoServicios());
			    txtFechaUltimoServicios.setDisabled(false);

			//	txtFechaUltimoServicios.setDisabled(false);
				txtTrabId_Trabajador.setValue(entity.getTrabajador());
				txtTrabId_Trabajador.setDisabled(false);

				
				txtAltura.setValue(entity.getAltura());
				txtAltura.setDisabled(false);
				txtDiametro.setValue(entity.getDiametro());
				txtDiametro.setDisabled(false);
				txtTamano.setValue(entity.getTamano());
				txtTamano.setDisabled(false);
				txtPresion.setValue(entity.getPresion());
				txtPresion.setDisabled(false);
				txtCaudal.setValue(entity.getCaudal());
				txtCaudal.setDisabled(false);
				txtSerial.setValue(entity.getSerial());
				txtSerial.setDisabled(false);
				txtRevoluciones.setValue(entity.getRevoluciones());
				txtRevoluciones.setDisabled(false);
				txtPotencia.setValue(entity.getPotencia());
				txtPotencia.setDisabled(false);
				txtVoltaje.setValue(entity.getVoltaje());
				txtVoltaje.setDisabled(false);
				txtCorriente.setValue(entity.getCorriente());
				txtCorriente.setDisabled(false);
				

				
				txtProducto.setValue(entity.getProductoId());
				txtProducto.setDisabled(false);

				txtEquipoId.setValue(entity.getEquipoId());
				txtEquipoId.setDisabled(true);

				Long compania = new Long(getCompaniaIdSession());
			 
				equipoId = entity.getEquipoId();

				GregorianCalendar cHoy = new GregorianCalendar();
				java.util.Date fechaReg = new java.util.Date();

				cHoy.setTime(fechaReg);
				int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
				int mesHoy = cHoy.get(java.util.Calendar.MONTH);
				int anoHoy = cHoy.get(java.util.Calendar.YEAR);
				cHoy.set(anoHoy, mesHoy, diaHoy);
				java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

				if (equipoId != null && !equipoId.toString().isEmpty()) {

					Equipo equipo = businessDelegatorView.getEquipo(equipoId);

					if (equipo.getMedidor() != null) {

						Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
						Long idMedidor = medidor.getMedidorId();

						if (medidor.getTipoMedidor().equals("horometro")) {

							/*Double valor = Double.parseDouble(businessDelegatorView
									.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());*/

							txtHorometroActual.setValue(entity.getHorometroActual());
							txtHorometroActual.setDisabled(true);

							//txtOdometroActual.setValue(entity.getOdometroActual());
							txtOdometroActual.setDisabled(true);
							
							txtHorasDiaEstandar.setValue(entity.getHorasDiaEstandar());
							txtHorasDiaEstandar.setDisabled(false);
							txtKmDiaEstandar.setValue(entity.getKmDiaEstandar());
							txtKmDiaEstandar.setDisabled(true);
							
							txtConsumoGlHora.setValue(entity.getConsumoGlHora());
							txtConsumoGlHora.setDisabled(false);
							
							txtConsumoKmGl.setValue(entity.getConsumoKmGl());
							txtConsumoKmGl.setDisabled(true);


						}
						if (medidor.getTipoMedidor().equals("odometro")) {

							/*Double valor = Double.parseDouble(businessDelegatorView
									.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());*/

							txtOdometroActual.setValue(entity.getOdometroActual());
							txtOdometroActual.setDisabled(false);
							txtHorometroActual.setDisabled(true);
							
							txtHorasDiaEstandar.setValue(entity.getHorasDiaEstandar());
							txtHorasDiaEstandar.setDisabled(true);
							txtKmDiaEstandar.setValue(entity.getKmDiaEstandar());
							txtKmDiaEstandar.setDisabled(false);
							
							txtConsumoGlHora.setValue(entity.getConsumoGlHora());
							txtConsumoGlHora.setDisabled(true);
							
							txtConsumoKmGl.setValue(entity.getConsumoKmGl());
							txtConsumoKmGl.setDisabled(false);

						}
						if (medidor.getTipoMedidor().equals("averiado")) {

							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
											"El medidor de la maquinaria/equipo se encuentra averiado"));
							txtHorometroActual.setDisabled(true);
							txtOdometroActual.setDisabled(true);
						}
					} else {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(true);
						txtHorometroActual.setValue(null);
						txtOdometroActual.setValue(null);

					}

				}

				/*** sesion tarifa ***/
				dataTarifaEquipProp = null;
				dataTarifaEquipProp = businessDelegatorView.getDataEquipoByTarifaEquipPropId(equipoId);

				txtValorUnit.setDisabled(false);
				txtFechaInicial.setDisabled(false);
				txtFechaFinal.setDisabled(false);
				txtCodUdadMed.setDisabled(false);
				txtCodLaborTarifa.setDisabled(false);
				txtLaborIdLaborTarifa.setDisabled(false);

				txtUdadMedId_UdadMed.setDisabled(false);

				/** Eventos **/

				dataEventosEquipos = null;
				dataEventosEquipos = businessDelegatorView.getDataEquipoEventoByEquipoId(equipoId);

				if (dataEventosEquipos != null) {
					txtEvento.setDisabled(false);
					txtFechaInicialVencimiento.setDisabled(false);
					txtFechaFinalVencimiento.setDisabled(false);
					btnAgregarEventos.setDisabled(false);
				}

				btnAgregar.setDisabled(false);

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
			if ((selectedEquipo == null) && (entity == null)) {
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
			entity = new Equipo();

			// Long equipoId = FacesUtils.checkLong(txtEquipoId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));

			entity.setAnioFabricacion(FacesUtils.checkLong(txtAnioFabricacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setCompania(compania);
			// entity.setEquipoId(equipoId);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setTipoPropiedad(FacesUtils.checkString(txtTipoPropiedad));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			// entity.setFoto(FacesUtils.checkString(txtFoto));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}
			entity.setFuncion(FacesUtils.checkString(txtFuncion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPlaca(FacesUtils.checkString(txtPlaca));
			entity.setTaraEstandar(FacesUtils.checkDouble(txtTaraEstandar));
			entity.setCategoriaEquipo((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo) != null)
					? businessDelegatorView.getCategoriaEquipo(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo))
					: null);
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost)));
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtContratistaId_Contratista))
					: null);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
			entity.setFlotaTransporte((FacesUtils.checkLong(txtFlotaTranspId_FlotaTransporte)));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor)));
			entity.setMedidor((FacesUtils.checkLong(txtMedidorId_Medidor)));
			entity.setModeloEquipo((FacesUtils.checkLong(txtModeloEquipoId_ModeloEquipo)));
			entity.setNumeroEje((FacesUtils.checkLong(txtNumEjeId_NumeroEje)));
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio)));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setConsumoGlHora(FacesUtils.checkDouble(txtConsumoGlHora));
			entity.setConsumoKmGl(FacesUtils.checkDouble(txtConsumoKmGl));
			entity.setHorometroActual(FacesUtils.checkDouble(txtHorometroActual));
			entity.setOdometroActual(FacesUtils.checkDouble(txtOdometroActual));
			entity.setProductoId(FacesUtils.checkLong(txtProducto));
			entity.setFechaUltimoAbastecimiento(FacesUtils.checkDate(txtFechaUltimoAbastecimiento));
			entity.setFechaUltimoServicios(FacesUtils.checkDate(txtFechaUltimoServicios));

			entity.setHorasDiaEstandar(FacesUtils.checkDouble(txtHorasDiaEstandar));
			entity.setKmDiaEstandar(FacesUtils.checkDouble(txtKmDiaEstandar));
			
			entity.setAltura(FacesUtils.checkString(txtAltura));
			entity.setDiametro(FacesUtils.checkString(txtDiametro));
			entity.setTamano(FacesUtils.checkString(txtTamano));
			entity.setPresion(FacesUtils.checkString(txtPresion));
			entity.setCaudal(FacesUtils.checkString(txtCaudal));
			entity.setSerial(FacesUtils.checkString(txtSerial));
			entity.setRevoluciones(FacesUtils.checkString(txtRevoluciones));
			entity.setPotencia(FacesUtils.checkString(txtPotencia));
			entity.setVoltaje(FacesUtils.checkString(txtVoltaje));
			entity.setCorriente(FacesUtils.checkString(txtCorriente));

			entity.setTagId(FacesUtils.checkLong(txtTagId_Tag));
			
			businessDelegatorView.saveEquipo(entity, dataTarifaEquipProp, dataEventosEquipos);
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
				Long equipoId = new Long(selectedEquipo.getEquipoId());
				entity = businessDelegatorView.getEquipo(equipoId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));

			entity.setAnioFabricacion(FacesUtils.checkLong(txtAnioFabricacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setTipoPropiedad(FacesUtils.checkString(txtTipoPropiedad));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			// entity.setFoto(FacesUtils.checkString(txtFoto));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}

			entity.setFuncion(FacesUtils.checkString(txtFuncion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPlaca(FacesUtils.checkString(txtPlaca));
			entity.setTaraEstandar(FacesUtils.checkDouble(txtTaraEstandar));
			entity.setCategoriaEquipo((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo) != null)
					? businessDelegatorView.getCategoriaEquipo(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo))
					: null);
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost)));
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtContratistaId_Contratista))
					: null);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto)));
			entity.setFlotaTransporte((FacesUtils.checkLong(txtFlotaTranspId_FlotaTransporte)));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor)));
			entity.setMedidor((FacesUtils.checkLong(txtMedidorId_Medidor)));
			entity.setModeloEquipo((FacesUtils.checkLong(txtModeloEquipoId_ModeloEquipo)));
			entity.setNumeroEje((FacesUtils.checkLong(txtNumEjeId_NumeroEje)));
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio)));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setConsumoGlHora(FacesUtils.checkDouble(txtConsumoGlHora));
			entity.setConsumoKmGl(FacesUtils.checkDouble(txtConsumoKmGl));
			entity.setHorometroActual(FacesUtils.checkDouble(txtHorometroActual));
			entity.setOdometroActual(FacesUtils.checkDouble(txtOdometroActual));
			entity.setProductoId(FacesUtils.checkLong(txtProducto));
			entity.setFechaUltimoAbastecimiento(FacesUtils.checkDate(txtFechaUltimoAbastecimiento));
			entity.setFechaUltimoServicios(FacesUtils.checkDate(txtFechaUltimoServicios));
			entity.setHorasDiaEstandar(FacesUtils.checkDouble(txtHorasDiaEstandar));
			entity.setKmDiaEstandar(FacesUtils.checkDouble(txtKmDiaEstandar));
			entity.setAltura(FacesUtils.checkString(txtAltura));
			entity.setDiametro(FacesUtils.checkString(txtDiametro));
			entity.setTamano(FacesUtils.checkString(txtTamano));
			entity.setPresion(FacesUtils.checkString(txtPresion));
			entity.setCaudal(FacesUtils.checkString(txtCaudal));
			entity.setSerial(FacesUtils.checkString(txtSerial));
			entity.setRevoluciones(FacesUtils.checkString(txtRevoluciones));
			entity.setPotencia(FacesUtils.checkString(txtPotencia));
			entity.setVoltaje(FacesUtils.checkString(txtVoltaje));
			entity.setCorriente(FacesUtils.checkString(txtCorriente));

			entity.setTagId(FacesUtils.checkLong(txtTagId_Tag));
			
			businessDelegatorView.updateEquipo(entity, dataTarifaEquipProp, dataEventosEquipos);
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
			selectedEquipo = (EquipoDTO) (evt.getComponent().getAttributes().get("selectedEquipo"));

			Long equipoId = new Long(selectedEquipo.getEquipoId());
			entity = businessDelegatorView.getEquipo(equipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long equipoId = FacesUtils.checkLong(txtEquipoId);
			entity = businessDelegatorView.getEquipo(equipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteEquipo(entity);
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
			selectedEquipo = (EquipoDTO) (evt.getComponent().getAttributes().get("selectedEquipo"));

			Long equipoId = new Long(selectedEquipo.getEquipoId());
			entity = businessDelegatorView.getEquipo(equipoId);
			businessDelegatorView.deleteEquipo(entity);
			((Map<String, Object>) data).remove(selectedEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anioFabricacion, String codigo, Double color, Long compania, Long equipoId,
			String estado, Date fechaCreacion, Date fechaModificacion, String foto, String funcion,
			String infoAdicional, String infoAdicional2, String nombre, String placa, Double taraEstandar,
			String tipoPropiedad, Long categEquipId_CategoriaEquipo, Long centCostId_CentCost,
			Long contratistaId_Contratista, Long elemCostoId_ElementoCosto, Long flotaTranspId_FlotaTransporte,
			Long laborId_Labor, Long medidorId_Medidor, Long modeloEquipoId_ModeloEquipo, Long numEjeId_NumeroEje,
			Long servicioId_Servicio, Long trabId_Trabajador) throws Exception {
		try {
			entity.setAnioFabricacion(FacesUtils.checkLong(anioFabricacion));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setColor(FacesUtils.checkString(color));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setTipoPropiedad(FacesUtils.checkString(tipoPropiedad));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFoto(FacesUtils.checkString(foto));
			entity.setFuncion(FacesUtils.checkString(funcion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPlaca(FacesUtils.checkString(placa));
			entity.setTaraEstandar(FacesUtils.checkDouble(taraEstandar));
			businessDelegatorView.updateEquipo(entity, dataTarifaEquipProp, dataEventosEquipos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("EquipoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String actionDeleteEventos(ActionEvent evt) {

		try {

			selectedEventosEquiposId = (EquipoEventoDTO) (evt.getComponent().getAttributes()
					.get("selectedEventosEquiposId"));

			if (selectedEventosEquiposId.getId() == null) {
				dataEventosEquipos.remove(selectedEventosEquiposId);
			} else {
				Long EquipoEventosId = new Long(selectedEventosEquiposId.getId());
				EquipoEvento entity = businessDelegatorView.getEquipoEvento(EquipoEventosId);
				businessDelegatorView.deleteEquipoEvento(entity);
				dataEventosEquipos.remove(selectedEventosEquiposId);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public String actionDeleteTarifaEquipProp(ActionEvent evt) {
		try {

			selectedTarifaEquipProp = (TarifaEquipPropDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaEquipProp"));

			if (selectedTarifaEquipProp.getTarifaEquipPropId() == null) {
				dataTarifaEquipProp.remove(selectedTarifaEquipProp);
			} else {
				Long tarifaEquipPropId = new Long(selectedTarifaEquipProp.getTarifaEquipPropId());
				TarifaEquipProp entity = businessDelegatorView.getTarifaEquipProp(tarifaEquipPropId);
				businessDelegatorView.deleteTarifaEquipProp(entity);
				dataTarifaEquipProp.remove(selectedTarifaEquipProp);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public InputText getTxtAnioFabricacion() {
		return txtAnioFabricacion;
	}

	public void setTxtAnioFabricacion(InputText txtAnioFabricacion) {
		this.txtAnioFabricacion = txtAnioFabricacion;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public ColorPicker getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(ColorPicker txtColor) {
		this.txtColor = txtColor;
	}

	public SelectOneMenu getTxtTipoPropiedad() {
		return txtTipoPropiedad;
	}

	public void setTxtTipoPropiedad(SelectOneMenu txtTipoPropiedad) {
		this.txtTipoPropiedad = txtTipoPropiedad;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtFoto() {
		return txtFoto;
	}

	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
	}

	public SelectOneMenu getTxtFuncion() {
		return txtFuncion;
	}

	public void setTxtFuncion(SelectOneMenu txtFuncion) {
		this.txtFuncion = txtFuncion;
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

	public InputText getTxtPlaca() {
		return txtPlaca;
	}

	public void setTxtPlaca(InputText txtPlaca) {
		this.txtPlaca = txtPlaca;
	}

	public InputText getTxtTaraEstandar() {
		return txtTaraEstandar;
	}

	public void setTxtTaraEstandar(InputText txtTaraEstandar) {
		this.txtTaraEstandar = txtTaraEstandar;
	}

	public SelectOneMenu getTxtCategEquipId_CategoriaEquipo() {
		return txtCategEquipId_CategoriaEquipo;
	}

	public void setTxtCategEquipId_CategoriaEquipo(SelectOneMenu txtCategEquipId_CategoriaEquipo) {
		this.txtCategEquipId_CategoriaEquipo = txtCategEquipId_CategoriaEquipo;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtContratistaId_Contratista() {
		return txtContratistaId_Contratista;
	}

	public void setTxtContratistaId_Contratista(SelectOneMenu txtContratistaId_Contratista) {
		this.txtContratistaId_Contratista = txtContratistaId_Contratista;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
	}

	public SelectOneMenu getTxtFlotaTranspId_FlotaTransporte() {
		return txtFlotaTranspId_FlotaTransporte;
	}

	public void setTxtFlotaTranspId_FlotaTransporte(SelectOneMenu txtFlotaTranspId_FlotaTransporte) {
		this.txtFlotaTranspId_FlotaTransporte = txtFlotaTranspId_FlotaTransporte;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtMedidorId_Medidor() {
		return txtMedidorId_Medidor;
	}

	public void setTxtMedidorId_Medidor(SelectOneMenu txtMedidorId_Medidor) {
		this.txtMedidorId_Medidor = txtMedidorId_Medidor;
	}

	public SelectOneMenu getTxtModeloEquipoId_ModeloEquipo() {
		return txtModeloEquipoId_ModeloEquipo;
	}

	public void setTxtModeloEquipoId_ModeloEquipo(SelectOneMenu txtModeloEquipoId_ModeloEquipo) {
		this.txtModeloEquipoId_ModeloEquipo = txtModeloEquipoId_ModeloEquipo;
	}

	public SelectOneMenu getTxtNumEjeId_NumeroEje() {
		return txtNumEjeId_NumeroEje;
	}

	public void setTxtNumEjeId_NumeroEje(SelectOneMenu txtNumEjeId_NumeroEje) {
		this.txtNumEjeId_NumeroEje = txtNumEjeId_NumeroEje;
	}

	public List<TarifaEquipPropDTO> getDataTarifaEquipProp() {
		return dataTarifaEquipProp;
	}

	public void setDataTarifaEquipProp(List<TarifaEquipPropDTO> dataTarifaEquipProp) {
		this.dataTarifaEquipProp = dataTarifaEquipProp;
	}

	public SelectOneMenu getTxtServicioId_Servicio() {
		return txtServicioId_Servicio;
	}

	public void setTxtServicioId_Servicio(SelectOneMenu txtServicioId_Servicio) {
		this.txtServicioId_Servicio = txtServicioId_Servicio;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
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

	public InputText getTxtEquipoId() {
		return txtEquipoId;
	}

	public void setTxtEquipoId(InputText txtEquipoId) {
		this.txtEquipoId = txtEquipoId;
	}

	public LazyDataModel<EquipoDTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataEquipo();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<EquipoDTO> equipoDTO) {
		this.data = equipoDTO;
	}

	public EquipoDTO getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(EquipoDTO equipo) {
		this.selectedEquipo = equipo;
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

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
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

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public InputText getTxtValorUnit() {
		return txtValorUnit;
	}

	public void setTxtValorUnit(InputText txtValorUnit) {
		this.txtValorUnit = txtValorUnit;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public SelectItem[] getSelectEvento() {

		if (eventos == null || eventos.size() == 0) {

			eventos = new ArrayList<Eventos>();

			try {

				eventos = businessDelegatorView.getEventos();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Eventos> lista = businessDelegatorView.findByCriteriaInEventos(condicion, null, null);
				selectEvento = new SelectItem[lista.size()];

				int i = 0;
				for (Eventos ev : lista) {
					selectEvento[i] = new SelectItem(ev.getEventosId(), ev.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectEvento;
	}

	public void setSelectEvento(SelectItem[] selectEvento) {
		this.selectEvento = selectEvento;
	}

	public SelectItem[] getselectCategoriaEquipo() {

		if (categoriaEquipo == null || categoriaEquipo.size() == 0) {

			categoriaEquipo = new ArrayList<CategoriaEquipo>();

			try {

				categoriaEquipo = businessDelegatorView.getCategoriaEquipo(); // Fin
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

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				trabajador = businessDelegatorView.getTrabajador(); // Fin by
				// Criteria
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

	public SelectItem[] getselectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			centCost = new ArrayList<CentCost>();

			try {

				centCost = businessDelegatorView.getCentCost(); // Fin by
				// Criteria
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

	public void setselectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getselectElementoCosto() {

		if (elementoCosto == null || elementoCosto.size() == 0) {

			elementoCosto = new ArrayList<ElementoCosto>();

			try {

				elementoCosto = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
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

	public void setselectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

		

			try {

				
				// Criteria
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

	public SelectItem[] getselectNumeroEje() {

		if (numeroEje == null || numeroEje.size() == 0) {

		
			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<NumeroEje> lista = businessDelegatorView.findByCriteriaInNumeroEje(condicion, null, null);
				selectNumeroEje = new SelectItem[lista.size()];

				int i = 0;
				for (NumeroEje numeroEje : lista) {
					selectNumeroEje[i] = new SelectItem(numeroEje.getNumEjeId(), numeroEje.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNumeroEje;
	}

	public void setselectNumeroEje(SelectItem[] selectNumeroEje) {
		this.selectNumeroEje = selectNumeroEje;
	}

	public SelectItem[] getselectModeloEquipo() {

		if (modeloEquipo == null || modeloEquipo.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ModeloEquipo> lista = businessDelegatorView.findByCriteriaInModeloEquipo(condicion, null, null);
				selectModeloEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (ModeloEquipo modeloEquipo : lista) {
					selectModeloEquipo[i] = new SelectItem(modeloEquipo.getModeloEquipoId(), modeloEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectModeloEquipo;
	}

	public void setselectModeloEquipo(SelectItem[] selectModeloEquipo) {
		this.selectModeloEquipo = selectModeloEquipo;
	}

	public SelectItem[] getselectServicio() {

		if (servicio == null || servicio.size() == 0) {

			servicio = new ArrayList<Servicio>();

			try {

				servicio = businessDelegatorView.getServicio(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Servicio> lista = businessDelegatorView.findByCriteriaInServicio(condicion, null, null);
				selectServicio = new SelectItem[lista.size()];

				int i = 0;
				for (Servicio servicio : lista) {
					selectServicio[i] = new SelectItem(servicio.getServicioId(), servicio.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectServicio;
	}

	public void setselectServicio(SelectItem[] selectServicio) {
		this.selectServicio = selectServicio;
	}

	public SelectItem[] getselectLabor() {

		if (labor == null || labor.size() == 0) {

			
			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLabor = new SelectItem[lista.size()];

				int i = 0;
				for (Labor labor : lista) {
					selectLabor[i] = new SelectItem(labor.getLaborId(), labor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLabor;
	}

	public void setselectLabor(SelectItem[] selectLabor) {
		this.selectLabor = selectLabor;
	}

	public void action_selecctMedidor() {

		Long medidorId = null;

		medidorId = FacesUtils.checkLong(txtMedidorId_Medidor);

		if (medidorId != null && !medidorId.toString().isEmpty()) {

			Medidor medidor = null;
			try {
				medidor = businessDelegatorView.getMedidor(medidorId);
				if (medidor != null) {
					if (medidor.getTipoMedidor().equals("horometro")) {

						txtHorometroActual.setDisabled(true);
						txtConsumoGlHora.setDisabled(false);
						txtConsumoKmGl.setDisabled(true);
						txtOdometroActual.setDisabled(true);
						txtHorasDiaEstandar.setDisabled(false);
						txtKmDiaEstandar.setDisabled(true);
					} else if (medidor.getTipoMedidor().equals("odometro")) {

						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(true);
						txtConsumoGlHora.setDisabled(true);
						txtConsumoKmGl.setDisabled(false);
						txtHorasDiaEstandar.setDisabled(true);
						txtKmDiaEstandar.setDisabled(false);
						
					} else if (medidor.getTipoMedidor().equals("averiado")) {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));

						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(true);
						txtConsumoGlHora.setDisabled(true);
						txtConsumoKmGl.setDisabled(true);

						txtHorasDiaEstandar.setDisabled(true);
						txtKmDiaEstandar.setDisabled(true);
					}
				} else {

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

					txtHorometroActual.setDisabled(true);
					txtOdometroActual.setDisabled(true);
					txtConsumoGlHora.setDisabled(true);
					txtConsumoKmGl.setDisabled(true);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public SelectItem[] getselectMedidor() {

		if (medidor == null || medidor.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Medidor> lista = businessDelegatorView.findByCriteriaInMedidor(condicion, null, null);
				selectMedidor = new SelectItem[lista.size()];

				int i = 0;
				for (Medidor medidor : lista) {
					selectMedidor[i] = new SelectItem(medidor.getMedidorId(), medidor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMedidor;
	}

	public void setselectMedidor(SelectItem[] selectMedidor) {
		this.selectMedidor = selectMedidor;
	}

	public SelectItem[] getselectFlotaTransporte() {

		if (flotaTransporte == null || flotaTransporte.size() == 0) {

			flotaTransporte = new ArrayList<FlotaTransporte>();

			try {

				flotaTransporte = businessDelegatorView.getFlotaTransporte(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FlotaTransporte> lista = businessDelegatorView.findByCriteriaInFlotaTransporte(condicion, null,
						null);
				selectFlotaTransporte = new SelectItem[lista.size()];

				int i = 0;
				for (FlotaTransporte flotaTransporte : lista) {
					selectFlotaTransporte[i] = new SelectItem(flotaTransporte.getFlotaTranspId(),
							flotaTransporte.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFlotaTransporte;
	}

	public void setselectFlotaTransporte(SelectItem[] selectFlotaTransporte) {
		this.selectFlotaTransporte = selectFlotaTransporte;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		if (file != null) {
			this.txtImagenEquipo = file.getFileName();
		}
	}

	public String getTxtImagenEquipo() {
		return txtImagenEquipo;
	}

	public void setTxtImagenEquipo(String txtImagenEquipo) {
		this.txtImagenEquipo = txtImagenEquipo;
	}

	public String getimagenEquipo() {
		return imagenEquipo;
	}

	public void setImagenEquipo(String imagenEquipo) {
		this.imagenEquipo = imagenEquipo;
	}

	public void subirImagen() {

		ServletContext servletContext;
		String fileName = file.getFileName();

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

			String path = servletContext.getRealPath("");

			// UploadedFile file = event.getFile();
			inputStream = file.getInputstream();
			// fileName = file.getFileName();
			outputStream = new FileOutputStream(new File(path + "imagenes_subidas/" + fileName));

			int read = 0;
			byte[] bytes = new byte[100000];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			imagenEquipo = fileName;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}

	private class LocalDataModelDTO extends LazyDataModel<EquipoDTO> {
		private static final long serialVersionUID = 1L;
		private List<EquipoDTO> EquipoDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<EquipoDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			moduloSeleccionado();
			String modulo = txtOrigenDatos.getValue().toString();

			if (filters != null) {
				EquipoDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters, modulo);
				try {
					setRowCount(businessDelegatorView.findTotalNumberEquipo(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);

			return EquipoDTO;

		}

		@Override
		public EquipoDTO getRowData(String rowKey) {
			for (EquipoDTO EquipoDTOtmp : EquipoDTO) {
				if (EquipoDTOtmp.getEquipoId().toString().equals(rowKey))
					return EquipoDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(EquipoDTO EquipoDTOtmp) {
			return EquipoDTOtmp.getEquipoId();
		}

	}

	private List<EquipoDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) {
		try {
			return businessDelegatorView.getDataPageEquipo(startRow, pageSize, sortField, sortOrder, filters, modulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

	public SelectItem[] getselectLaborId_tarifa() {

		if (laborId_tarifa == null || laborId_tarifa.size() == 0) {

			laborId_tarifa = new ArrayList<Labor>();

			try {

				laborId_tarifa = businessDelegatorView.getLabor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista2 = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId_tarifa = new SelectItem[lista2.size()];

				int i = 0;
				for (Labor laborId_tarifa : lista2) {
					selectLaborId_tarifa[i] = new SelectItem(laborId_tarifa.getLaborId(), laborId_tarifa.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborId_tarifa;
	}

	public void setselectLaborId_tarifa(SelectItem[] selectLaborId_tarifa) {

		this.selectLaborId_tarifa = selectLaborId_tarifa;
	}

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public InputText getTxtCodUdadMed() {
		return txtCodUdadMed;
	}

	public void setTxtCodUdadMed(InputText txtCodUdadMed) {
		this.txtCodUdadMed = txtCodUdadMed;
	}

	public SelectOneMenu getTxtLaborIdLaborTarifa() {
		return txtLaborIdLaborTarifa;
	}

	public void setTxtLaborIdLaborTarifa(SelectOneMenu txtLaborIdLaborTarifa) {
		this.txtLaborIdLaborTarifa = txtLaborIdLaborTarifa;
	}

	public InputText getTxtCodLaborTarifa() {
		return txtCodLaborTarifa;
	}

	public void setTxtCodLaborTarifa(InputText txtCodLaborTarifa) {
		this.txtCodLaborTarifa = txtCodLaborTarifa;
	}

	public SelectItem[] getselectProductoId() {

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

	public SelectOneMenu getTxtProducto() {
		return txtProducto;
	}

	public InputText getTxtConsumoGlHora() {
		return txtConsumoGlHora;
	}

	public InputText getTxtConsumoKmGl() {
		return txtConsumoKmGl;
	}

	public InputText getTxtHorometroActual() {
		return txtHorometroActual;
	}

	public InputText getTxtOdometroActual() {
		return txtOdometroActual;
	}

	public void setTxtProducto(SelectOneMenu txtProducto) {
		this.txtProducto = txtProducto;
	}

	public void setTxtConsumoGlHora(InputText txtConsumoGlHora) {
		this.txtConsumoGlHora = txtConsumoGlHora;
	}

	public void setTxtConsumoKmGl(InputText txtConsumoKmGl) {
		this.txtConsumoKmGl = txtConsumoKmGl;
	}

	public void setTxtHorometroActual(InputText txtHorometroActual) {
		this.txtHorometroActual = txtHorometroActual;
	}

	public void setTxtOdometroActual(InputText txtOdometroActual) {
		this.txtOdometroActual = txtOdometroActual;
	}

	public Calendar getTxtFechaInicialVencimiento() {
		return txtFechaInicialVencimiento;
	}

	public Calendar getTxtFechaFinalVencimiento() {
		return txtFechaFinalVencimiento;
	}

	public void setTxtFechaInicialVencimiento(Calendar txtFechaInicialVencimiento) {
		this.txtFechaInicialVencimiento = txtFechaInicialVencimiento;
	}

	public void setTxtFechaFinalVencimiento(Calendar txtFechaFinalVencimiento) {
		this.txtFechaFinalVencimiento = txtFechaFinalVencimiento;
	}

	public SelectOneMenu getTxtEvento() {
		return txtEvento;
	}

	public void setTxtEvento(SelectOneMenu txtEvento) {
		this.txtEvento = txtEvento;
	}

	public CommandButton getBtnAgregarEventos() {
		return btnAgregarEventos;
	}

	public void setBtnAgregarEventos(CommandButton btnAgregarEventos) {
		this.btnAgregarEventos = btnAgregarEventos;
	}

	public Long getDiasNotificacion() {
		return diasNotificacion;
	}

	public void setDiasNotificacion(Long diasNotificacion) {
		this.diasNotificacion = diasNotificacion;
	}

	public boolean isDisabledCampos() {
		return disabledCampos;
	}

	public void setDisabledCampos(boolean disabledCampos) {
		this.disabledCampos = disabledCampos;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFechaNotificacion() {
		return fechaNotificacion;
	}

	public void setFechaNotificacion(String fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	public Calendar getTxtFechaUltimoServicios() {
		return txtFechaUltimoServicios;
	}

	public Calendar getTxtFechaUltimoAbastecimiento() {
		return txtFechaUltimoAbastecimiento;
	}

	public void setTxtFechaUltimoServicios(Calendar txtFechaUltimoServicios) {
		this.txtFechaUltimoServicios = txtFechaUltimoServicios;
	}

	public void setTxtFechaUltimoAbastecimiento(Calendar txtFechaUltimoAbastecimiento) {
		this.txtFechaUltimoAbastecimiento = txtFechaUltimoAbastecimiento;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public InputText getTxtHorasDiaEstandar() {
		return txtHorasDiaEstandar;
	}

	public void setTxtHorasDiaEstandar(InputText txtHorasDiaEstandar) {
		this.txtHorasDiaEstandar = txtHorasDiaEstandar;
	}

	public InputText getTxtKmDiaEstandar() {
		return txtKmDiaEstandar;
	}

	public void setTxtKmDiaEstandar(InputText txtKmDiaEstandar) {
		this.txtKmDiaEstandar = txtKmDiaEstandar;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String getOcultaMttoMaquinaria() {
		return ocultaMttoMaquinaria;
	}

	public void setOcultaMttoMaquinaria(String ocultaMttoMaquinaria) {
		this.ocultaMttoMaquinaria = ocultaMttoMaquinaria;
	}

	public String getOcultaMttoIndustrial() {
		return ocultaMttoIndustrial;
	}

	public void setOcultaMttoIndustrial(String ocultaMttoIndustrial) {
		this.ocultaMttoIndustrial = ocultaMttoIndustrial;
	}

	public InputText getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(InputText txtAltura) {
		this.txtAltura = txtAltura;
	}

	public InputText getTxtDiametro() {
		return txtDiametro;
	}

	public void setTxtDiametro(InputText txtDiametro) {
		this.txtDiametro = txtDiametro;
	}

	public InputText getTxtTamano() {
		return txtTamano;
	}

	public void setTxtTamano(InputText txtTamano) {
		this.txtTamano = txtTamano;
	}

	public InputText getTxtPresion() {
		return txtPresion;
	}

	public void setTxtPresion(InputText txtPresion) {
		this.txtPresion = txtPresion;
	}

	public InputText getTxtCaudal() {
		return txtCaudal;
	}

	public void setTxtCaudal(InputText txtCaudal) {
		this.txtCaudal = txtCaudal;
	}

	public InputText getTxtSerial() {
		return txtSerial;
	}

	public void setTxtSerial(InputText txtSerial) {
		this.txtSerial = txtSerial;
	}

	public InputText getTxtRevoluciones() {
		return txtRevoluciones;
	}

	public void setTxtRevoluciones(InputText txtRevoluciones) {
		this.txtRevoluciones = txtRevoluciones;
	}

	public InputText getTxtPotencia() {
		return txtPotencia;
	}

	public void setTxtPotencia(InputText txtPotencia) {
		this.txtPotencia = txtPotencia;
	}

	public InputText getTxtVoltaje() {
		return txtVoltaje;
	}

	public void setTxtVoltaje(InputText txtVoltaje) {
		this.txtVoltaje = txtVoltaje;
	}

	public InputText getTxtCorriente() {
		return txtCorriente;
	}

	public void setTxtCorriente(InputText txtCorriente) {
		this.txtCorriente = txtCorriente;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
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

	public SelectOneMenu getTxtTagId_Tag() {
		return txtTagId_Tag;
	}

	public void setTxtTagId_Tag(SelectOneMenu txtTagId_Tag) {
		this.txtTagId_Tag = txtTagId_Tag;
	}

	
	
}
