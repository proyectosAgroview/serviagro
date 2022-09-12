package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import co.com.arcosoft.modelo.AreaTrabajo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.DatSolicitudesMtto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.NivelPrioridad;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.TallerMecanico;
import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.ZonasFabrica;
import co.com.arcosoft.modelo.dto.DatSolicitudesMttoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaSolicitudesParaMttoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatSolicitudesMttoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatSolicitudesMttoView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtCierreSolicitud;
	private Calendar txtFechaCierre;
	private InputTextarea txtDescripcionSolicitud;
	private InputText txtEstado;
	private InputTextarea txtObservacionAnularReg;
	private InputTextarea txtObservaciones;
	private InputText txtDatSolicitudesMttoId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatSolicitudesMttoDTO> data1;
	private DatSolicitudesMttoDTO selectedDatSolicitudesMtto;
	private ConsultaSolicitudesParaMttoDTO selectedDatConsultaSolicitudesMtto;
	private DatSolicitudesMtto entity;
	private boolean showDialog;

	private SelectOneMenu txtSolicitante;
	SelectItem[] selectTrabajadorSolicitante;
	private List<Trabajador> trabajadorSolicitante;

	private SelectOneMenu txtZonasFabricaId_ZonasFabrica;
	SelectItem[] selectZona;
	private List<ZonasFabrica> zona;

	private SelectOneMenu txtTipoMantenimientoId_TipoMantenimiento;
	SelectItem[] selectTipoMantenimiento;
	private List<TipoMantenimiento> tipoMantenimiento;

	private SelectOneMenu txtAreaTrabajoId_AreaTrabajo;
	SelectItem[] selectAreaTrabajo;
	private List<AreaTrabajo> area;

	private SelectOneMenu txtTagId_Tag;
	SelectItem[] selectTag;
	private List<Tag> tag;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneRadio txtRequiereParadaFabrica;

	private SelectOneMenu txtNivelPrioridadId_NivelPrioridad;
	SelectItem[] selectNivel;
	private List<NivelPrioridad> nivel;

	private SelectOneMenu txtTallerId;
	SelectItem[] selectTallerMecanico;
	private List<TallerMecanico> tallerMecanico;

	private SelectOneMenu txtOrigenDatos;

	// filtros Consulta

	private SelectOneMenu txtCompaniaFiltro;
	SelectItem[] selectCompaniaFiltro;
	private List<Compania> companiafiltro;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private List<String> selectedTipoMtto;
	private List<TipoMantenimiento> tipoMtto;

	private List<String> selectedSolicitante;
	private List<Trabajador> solicitanteMtto;

	private List<String> selectedNivelPrioridad;
	private List<NivelPrioridad> nivelprioridadMtto;

	private SelectOneMenu txtOrigenDatosFiltro;

	private List<ConsultaSolicitudesParaMttoDTO> data;

	private String url = "";
	private String idSolicitud = "";

	private String moduloActivo;
	private String compoRequieridoMttoIndustrial = "false";
	private String compoRequieridoMttoMaquinaria = "false";
	private String ocultaMttoIndustrial = "none";
	private String ocultaMttoMaquinaria = "none";

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatSolicitudesMttoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatSolicitudesMttoDTO datSolicitudesMttoDTO = (DatSolicitudesMttoDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datSolicitudesMttoDTO.getCompania());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datSolicitudesMttoDTO.getConsecutivo());

			if (txtDescripcionSolicitud == null) {
				txtDescripcionSolicitud = new InputTextarea();
			}

			txtDescripcionSolicitud.setValue(datSolicitudesMttoDTO.getDescripcionSolicitud());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(datSolicitudesMttoDTO.getEstado());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datSolicitudesMttoDTO.getObservacionAnularReg());

			if (txtObservaciones == null) {
				txtObservaciones = new InputTextarea();
			}

			txtObservaciones.setValue(datSolicitudesMttoDTO.getObservaciones());

			if (txtRequiereParadaFabrica == null) {
				txtRequiereParadaFabrica = new SelectOneRadio();
			}

			txtRequiereParadaFabrica.setValue(datSolicitudesMttoDTO.getRequiereParadaFabrica());

			if (txtAreaTrabajoId_AreaTrabajo == null) {
				txtAreaTrabajoId_AreaTrabajo = new SelectOneMenu();
			}

			txtAreaTrabajoId_AreaTrabajo.setValue(datSolicitudesMttoDTO.getAreaTrabajoId_AreaTrabajo());

			if (txtEquipoId_Equipo == null) {
				txtEquipoId_Equipo = new SelectOneMenu();
			}

			txtEquipoId_Equipo.setValue(datSolicitudesMttoDTO.getEquipoId_Equipo());

			if (txtNivelPrioridadId_NivelPrioridad == null) {
				txtNivelPrioridadId_NivelPrioridad = new SelectOneMenu();
			}

			txtNivelPrioridadId_NivelPrioridad.setValue(datSolicitudesMttoDTO.getNivelPrioridadId_NivelPrioridad());

			if (txtTagId_Tag == null) {
				txtTagId_Tag = new SelectOneMenu();
			}

			txtTagId_Tag.setValue(datSolicitudesMttoDTO.getTagId_Tag());

			if (txtTipoMantenimientoId_TipoMantenimiento == null) {
				txtTipoMantenimientoId_TipoMantenimiento = new SelectOneMenu();
			}

			txtTipoMantenimientoId_TipoMantenimiento
					.setValue(datSolicitudesMttoDTO.getTipoMantenimientoId_TipoMantenimiento());

			if (txtSolicitante == null) {
				txtSolicitante = new SelectOneMenu();
			}

			txtSolicitante.setValue(datSolicitudesMttoDTO.getTrabId_Trabajador());

			if (txtZonasFabricaId_ZonasFabrica == null) {
				txtZonasFabricaId_ZonasFabrica = new SelectOneMenu();
			}

			txtZonasFabricaId_ZonasFabrica.setValue(datSolicitudesMttoDTO.getZonasFabricaId_ZonasFabrica());

			if (txtDatSolicitudesMttoId == null) {
				txtDatSolicitudesMttoId = new InputText();
			}

			txtDatSolicitudesMttoId.setValue(datSolicitudesMttoDTO.getDatSolicitudesMttoId());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datSolicitudesMttoDTO.getFechaAnulacion());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datSolicitudesMttoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datSolicitudesMttoDTO.getFechaModificacion());

			if (txtFechaRegistro == null) {
				txtFechaRegistro = new Calendar();
			}

			txtFechaRegistro.setValue(datSolicitudesMttoDTO.getFechaRegistro());

			Long datSolicitudesMttoId = FacesUtils.checkLong(txtDatSolicitudesMttoId);
			entity = businessDelegatorView.getDatSolicitudesMtto(datSolicitudesMttoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_informe() {
		setShowDialog(true);
		//selectedDatConsultaSolicitudesMtto = null;
		return "";
	}

	public String action_new() {
		action_clear();
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

		} else {

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

			compoRequieridoMttoIndustrial = "true";
			compoRequieridoMttoMaquinaria = "false";

		}
	}

	public String action_clear() {
		entity = null;
		selectedDatSolicitudesMtto = null;
		selectedDatConsultaSolicitudesMtto = null;
		
		moduloSeleccionado();

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtCierreSolicitud != null) {
			txtCierreSolicitud.setValue("A");
			txtCierreSolicitud.setDisabled(false);
		}

		if (txtFechaCierre != null) {
			txtFechaCierre.setValue(null);
			txtFechaCierre.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtDescripcionSolicitud != null) {
			txtDescripcionSolicitud.setValue(null);
			txtDescripcionSolicitud.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtObservaciones != null) {
			txtObservaciones.setValue(null);
			txtObservaciones.setDisabled(false);
		}

		if (txtRequiereParadaFabrica != null) {
			txtRequiereParadaFabrica.setValue("NO");
			txtRequiereParadaFabrica.setDisabled(false);
		}

		if (txtAreaTrabajoId_AreaTrabajo != null) {
			txtAreaTrabajoId_AreaTrabajo.setValue(null);
			txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtNivelPrioridadId_NivelPrioridad != null) {
			txtNivelPrioridadId_NivelPrioridad.setValue(null);
			txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
		}

		if (txtTipoMantenimientoId_TipoMantenimiento != null) {
			txtTipoMantenimientoId_TipoMantenimiento.setValue(null);
			txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
		}

		if (txtSolicitante != null) {
			txtSolicitante.setValue(null);
			txtSolicitante.setDisabled(false);
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

		if (txtDatSolicitudesMttoId != null) {
			txtDatSolicitudesMttoId.setValue(null);
			txtDatSolicitudesMttoId.setDisabled(false);
		}

		// mantenimiento de maquinaria

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			compoRequieridoMttoIndustrial = "false";
			compoRequieridoMttoMaquinaria = "true";

			ocultaMttoIndustrial = "none";
			ocultaMttoMaquinaria = "block";

			if (txtTallerId != null) {
				txtTallerId.setValue(null);
				txtTallerId.setDisabled(false);
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

			if (txtOrigenDatos != null) {
				txtOrigenDatos.setValue("Modulo_TallerAgricola");
				txtOrigenDatos.setDisabled(true);
			}

		} else {

			compoRequieridoMttoMaquinaria = "false";
			compoRequieridoMttoIndustrial = "true";

			ocultaMttoIndustrial = "block";
			ocultaMttoMaquinaria = "none";

			if (txtTallerId != null) {
				txtTallerId.setValue(null);
				txtTallerId.setDisabled(true);
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

			if (txtOrigenDatos != null) {
				txtOrigenDatos.setValue("Modulo_MttoIndustrial");
				txtOrigenDatos.setDisabled(true);
			}

		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
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

	public String action_edit(ActionEvent evt) {

		moduloSeleccionado();
		
		selectedDatConsultaSolicitudesMtto = (ConsultaSolicitudesParaMttoDTO) (evt.getComponent().getAttributes()
			.get("selectedDatSolicitudesMtto"));

		entity = null;
		

		try {

			//Long consecutivo = selectedDatSolicitudesMtto.getConsecutivo();
			Long consecutivo = Long.parseLong(selectedDatConsultaSolicitudesMtto.getConsecutivo().toString());
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatSolicitudesMtto> listaEdit = businessDelegatorView.findByCriteriaInDatSolicitudesMtto(condicion, null, null);

			if (listaEdit != null && listaEdit.size() > 0) {
				
				entity = listaEdit.get(0);

				// txtCompania.setValue(selectedDatSolicitudesMtto.getCompania());
				// txtCompania.setDisabled(false);
				txtConsecutivo.setValue(selectedDatConsultaSolicitudesMtto.getConsecutivo().intValue());
				txtConsecutivo.setDisabled(false);
				txtDescripcionSolicitud.setValue(entity.getDescripcionSolicitud());
				txtDescripcionSolicitud.setDisabled(false);
				txtOrigenDatos.setValue(entity.getOrigenDatos().toString());
				txtOrigenDatos.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservaciones.setValue(entity.getObservaciones());
				txtObservaciones.setDisabled(false);
				txtRequiereParadaFabrica.setValue(entity.getRequiereParadaFabrica());
				txtRequiereParadaFabrica.setDisabled(false);
				txtAreaTrabajoId_AreaTrabajo.setValue(selectedDatConsultaSolicitudesMtto.getArea_trabajo_id().intValue());
				txtEquipoId_Equipo.setValue(selectedDatConsultaSolicitudesMtto.getEquipo_id().intValue());
				txtEquipoId_Equipo.setDisabled(false);
				txtNivelPrioridadId_NivelPrioridad.setValue(selectedDatConsultaSolicitudesMtto.getNivel_prioridad_id().intValue());
				txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
				txtTagId_Tag.setValue(selectedDatConsultaSolicitudesMtto.getTipo_mantenimiento_id().intValue());
				txtTipoMantenimientoId_TipoMantenimiento
						.setValue(selectedDatConsultaSolicitudesMtto.getTipo_mantenimiento_id().intValue());
				txtTipoMantenimientoId_TipoMantenimiento.setDisabled(false);
				
				//Long solicitanteId1 = new Long(entity.getTrabajador().getTrabId().toString().trim());
				Long solicitanteId = Long.valueOf(selectedDatConsultaSolicitudesMtto.getTrab_solicitante_id().toString());
				//businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtSolicitante)
			
				txtSolicitante.setValue(selectedDatConsultaSolicitudesMtto.getTrab_solicitante_id().intValue());
				txtSolicitante.setDisabled(false);
				
				txtZonasFabricaId_ZonasFabrica.setValue(selectedDatConsultaSolicitudesMtto.getZonas_fabrica_id().intValue());
				//txtZonasFabricaId_ZonasFabrica.setDisabled(false);
				txtDatSolicitudesMttoId.setValue(selectedDatConsultaSolicitudesMtto.getDat_solicitudes_mtto_id().intValue());
				txtDatSolicitudesMttoId.setDisabled(true);
				
                // mantenimiento de maquinaria
				
				if (moduloActivo.equals("mantenimiento_maquinaria")) {
					
					compoRequieridoMttoIndustrial= "false";
					compoRequieridoMttoMaquinaria = "true";
					
					ocultaMttoIndustrial = "none";
					ocultaMttoMaquinaria = "block";
					
					txtTallerId.setValue(entity.getTallerId().getTallerMecanicoId().longValue());
					
					txtTallerId.setDisabled(false);
					txtAreaTrabajoId_AreaTrabajo.setDisabled(true);
					txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					txtTagId_Tag.setDisabled(true);
					txtZonasFabricaId_ZonasFabrica.setDisabled(true);
                  
					
					
				}else {
					
					ocultaMttoIndustrial = "block";
					ocultaMttoMaquinaria = "none";
					
					compoRequieridoMttoIndustrial= "true";
					compoRequieridoMttoMaquinaria = "false";
					
					txtTallerId.setDisabled(true);
					txtAreaTrabajoId_AreaTrabajo.setDisabled(false);
					txtNivelPrioridadId_NivelPrioridad.setDisabled(false);
					txtTagId_Tag.setDisabled(false);
					txtZonasFabricaId_ZonasFabrica.setDisabled(false);

				}
				
				
				btnSave.setDisabled(false);
				setShowDialog(true);

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatConsultaSolicitudesMtto == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new DatSolicitudesMtto();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			entity.setCompania(compania);
			
			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				entity.setOrigenDatos("Modulo_TallerAgricola");
			}else {
				entity.setOrigenDatos("Modulo_MttoIndustrial");
			}
			
			//entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setConsecutivo(businessDelegatorView.consultarConsecutivoDatSolicitudesMtto(compania));
			// entity.setDatSolicitudesMttoId(datSolicitudesMttoId);
			entity.setDescripcionSolicitud(FacesUtils.checkString(txtDescripcionSolicitud));
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setTallerId((FacesUtils.checkLong(txtTallerId) != null)
					? businessDelegatorView.getTallerMecanico(FacesUtils.checkLong(txtTallerId))
					: null);
			entity.setFechaCreacion(date);
			entity.setEstado("A");
			String cierre = "A";
			entity.setCierreSolicitud(cierre);
			// entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setObservaciones(FacesUtils.checkString(txtObservaciones));
			entity.setRequiereParadaFabrica(FacesUtils.checkString(txtRequiereParadaFabrica));
			entity.setAreaTrabajo((FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo))
					: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setNivelPrioridad((FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad) != null)
					? businessDelegatorView.getNivelPrioridad(FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad))
					: null);
			entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId_Tag))
					: null);
			entity.setTipoMantenimiento(
					(FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento) != null)
							? businessDelegatorView.getTipoMantenimiento(
									FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtSolicitante) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtSolicitante))
					: null);
			entity.setZonasFabrica((FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica) != null)
					? businessDelegatorView.getZonasFabrica(FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica))
					: null);
			businessDelegatorView.saveDatSolicitudesMtto(entity);
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
				Long datSolicitudesMttoId = new Long(selectedDatConsultaSolicitudesMtto.getDat_solicitudes_mtto_id().intValue());
				entity = businessDelegatorView.getDatSolicitudesMtto(datSolicitudesMttoId);
			}
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			
			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				entity.setOrigenDatos("Modulo_TallerAgricola");
			}else {
				entity.setOrigenDatos("Modulo_MttoIndustrial");
			}

			// entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDescripcionSolicitud(FacesUtils.checkString(txtDescripcionSolicitud));
			//entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setTallerId((FacesUtils.checkLong(txtTallerId) != null)
					? businessDelegatorView.getTallerMecanico(FacesUtils.checkLong(txtTallerId))
					: null);
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			// entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setObservaciones(FacesUtils.checkString(txtObservaciones));
			entity.setRequiereParadaFabrica(FacesUtils.checkString(txtRequiereParadaFabrica));
			entity.setAreaTrabajo((FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId_AreaTrabajo))
					: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setNivelPrioridad((FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad) != null)
					? businessDelegatorView.getNivelPrioridad(FacesUtils.checkLong(txtNivelPrioridadId_NivelPrioridad))
					: null);
			entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId_Tag))
					: null);
			entity.setTipoMantenimiento(
					(FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento) != null)
							? businessDelegatorView.getTipoMantenimiento(
									FacesUtils.checkLong(txtTipoMantenimientoId_TipoMantenimiento))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtSolicitante) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtSolicitante))
					: null);
			entity.setZonasFabrica((FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica) != null)
					? businessDelegatorView.getZonasFabrica(FacesUtils.checkLong(txtZonasFabricaId_ZonasFabrica))
					: null);
			businessDelegatorView.updateDatSolicitudesMtto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_cierreReaperturaOt(ActionEvent evt) {

		selectedDatConsultaSolicitudesMtto = (ConsultaSolicitudesParaMttoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatSolicitudesMtto"));

		try {

			Long id = new Long(selectedDatConsultaSolicitudesMtto.getDat_solicitudes_mtto_id().toString());
			entity = businessDelegatorView.getDatSolicitudesMtto(id);

			if (entity.getCierreSolicitud().equals("A")) {

				Date date = new Date();
				entity.setFechaCierre(date);
				entity.setCierreSolicitud("C");

				businessDelegatorView.updateDatSolicitudesMtto(entity);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYCLOSESOLICITUD);
				action_clear();
				data = null;

			} else {

				Date date = new Date();
				entity.setFechaCierre(date);
				entity.setCierreSolicitud("A");

				businessDelegatorView.updateDatSolicitudesMtto(entity);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYOPENSOLICITUD);
				action_clear();
				data = null;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_ERRORSOLICITUD);
		}

		return "";

	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatConsultaSolicitudesMtto.getDat_solicitudes_mtto_id().intValue());
				entity = businessDelegatorView.getDatSolicitudesMtto(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatSolicitudesMtto(entity);
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

		selectedDatConsultaSolicitudesMtto = (ConsultaSolicitudesParaMttoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatSolicitudesMtto"));

		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	
	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatSolicitudesMtto = (DatSolicitudesMttoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatSolicitudesMtto"));

			Long datSolicitudesMttoId = new Long(selectedDatSolicitudesMtto.getDatSolicitudesMttoId());
			entity = businessDelegatorView.getDatSolicitudesMtto(datSolicitudesMttoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datSolicitudesMttoId = FacesUtils.checkLong(txtDatSolicitudesMttoId);
			entity = businessDelegatorView.getDatSolicitudesMtto(datSolicitudesMttoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatSolicitudesMtto(entity);
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
			selectedDatSolicitudesMtto = (DatSolicitudesMttoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatSolicitudesMtto"));

			Long datSolicitudesMttoId = new Long(selectedDatSolicitudesMtto.getDatSolicitudesMttoId());
			entity = businessDelegatorView.getDatSolicitudesMtto(datSolicitudesMttoId);
			businessDelegatorView.deleteDatSolicitudesMtto(entity);
			data.remove(selectedDatSolicitudesMtto);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datSolicitudesMttoId,
			String descripcionSolicitud, String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion,
			Date fechaRegistro, String observacionAnularReg, String observaciones, String requiereParadaFabrica,
			Long areaTrabajoId_AreaTrabajo, Long equipoId_Equipo, Long nivelPrioridadId_NivelPrioridad, Long tagId_Tag,
			Long tipoMantenimientoId_TipoMantenimiento, Long trabId_Trabajador, Long zonasFabricaId_ZonasFabrica)
			throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDescripcionSolicitud(FacesUtils.checkString(descripcionSolicitud));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setObservaciones(FacesUtils.checkString(observaciones));
			entity.setRequiereParadaFabrica(FacesUtils.checkString(requiereParadaFabrica));
			businessDelegatorView.updateDatSolicitudesMtto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatSolicitudesMttoView").requestRender();
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

	public InputTextarea getTxtDescripcionSolicitud() {
		return txtDescripcionSolicitud;
	}

	public void setTxtDescripcionSolicitud(InputTextarea txtDescripcionSolicitud) {
		this.txtDescripcionSolicitud = txtDescripcionSolicitud;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputTextarea getTxtObservaciones() {
		return txtObservaciones;
	}

	public void setTxtObservaciones(InputTextarea txtObservaciones) {
		this.txtObservaciones = txtObservaciones;
	}

	public SelectOneRadio getTxtRequiereParadaFabrica() {
		return txtRequiereParadaFabrica;
	}

	public void setTxtRequiereParadaFabrica(SelectOneRadio txtRequiereParadaFabrica) {
		this.txtRequiereParadaFabrica = txtRequiereParadaFabrica;
	}

	public SelectOneMenu getTxtAreaTrabajoId_AreaTrabajo() {
		return txtAreaTrabajoId_AreaTrabajo;
	}

	public void setTxtAreaTrabajoId_AreaTrabajo(SelectOneMenu txtAreaTrabajoId_AreaTrabajo) {
		this.txtAreaTrabajoId_AreaTrabajo = txtAreaTrabajoId_AreaTrabajo;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtNivelPrioridadId_NivelPrioridad() {
		return txtNivelPrioridadId_NivelPrioridad;
	}

	public void setTxtNivelPrioridadId_NivelPrioridad(SelectOneMenu txtNivelPrioridadId_NivelPrioridad) {
		this.txtNivelPrioridadId_NivelPrioridad = txtNivelPrioridadId_NivelPrioridad;
	}

	public SelectOneMenu getTxtTagId_Tag() {
		return txtTagId_Tag;
	}

	public void setTxtTagId_Tag(SelectOneMenu txtTagId_Tag) {
		this.txtTagId_Tag = txtTagId_Tag;
	}

	public SelectOneMenu getTxtTipoMantenimientoId_TipoMantenimiento() {
		return txtTipoMantenimientoId_TipoMantenimiento;
	}

	public void setTxtTipoMantenimientoId_TipoMantenimiento(SelectOneMenu txtTipoMantenimientoId_TipoMantenimiento) {
		this.txtTipoMantenimientoId_TipoMantenimiento = txtTipoMantenimientoId_TipoMantenimiento;
	}

	

	public SelectOneMenu getTxtSolicitante() {
		return txtSolicitante;
	}

	public void setTxtSolicitante(SelectOneMenu txtSolicitante) {
		this.txtSolicitante = txtSolicitante;
	}

	public SelectOneMenu getTxtZonasFabricaId_ZonasFabrica() {
		return txtZonasFabricaId_ZonasFabrica;
	}

	public void setTxtZonasFabricaId_ZonasFabrica(SelectOneMenu txtZonasFabricaId_ZonasFabrica) {
		this.txtZonasFabricaId_ZonasFabrica = txtZonasFabricaId_ZonasFabrica;
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

	public InputText getTxtDatSolicitudesMttoId() {
		return txtDatSolicitudesMttoId;
	}

	public void setTxtDatSolicitudesMttoId(InputText txtDatSolicitudesMttoId) {
		this.txtDatSolicitudesMttoId = txtDatSolicitudesMttoId;
	}

	public List<DatSolicitudesMttoDTO> getData1() {
		try {
			if (data1 == null) {
				data1 = businessDelegatorView.getDataDatSolicitudesMtto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data1;
	}

	public void consultaSolicitudesMtto() {
		try {

			Long compania =   new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			String origenDatos = FacesUtils.checkString(txtOrigenDatosFiltro);

			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			Long flagSolicitante = 1L;
			Long flagEquipo = 1L;
			Long flagTipoMtto = 1L;
			Long flagNivelPrioridad = 1L;

			String solicitantesSeleccionados = "";
			if (selectedSolicitante != null && selectedSolicitante.size() > 0) {
				solicitantesSeleccionados = selectedSolicitante.get(0);
				flagSolicitante = 0L;
				for (int i = 1; i < selectedSolicitante.size(); i++) {
					solicitantesSeleccionados += "," + selectedSolicitante.get(i);
				}
			}

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += " , " + selectedEquipo.get(i);
				}
			}

			String tipoMttoSeleccionadas = "";
			if (selectedTipoMtto != null && selectedTipoMtto.size() > 0) {
				tipoMttoSeleccionadas = selectedTipoMtto.get(0);
				flagTipoMtto = 0L;
				for (int i = 1; i < selectedTipoMtto.size(); i++) {
					tipoMttoSeleccionadas += "," + selectedTipoMtto.get(i);
				}
			}

			String nivelPrioridadSeleccionadas = "";
			if (selectedNivelPrioridad != null && selectedNivelPrioridad.size() > 0) {
				nivelPrioridadSeleccionadas = selectedNivelPrioridad.get(0);
				flagNivelPrioridad = 0L;
				for (int i = 1; i < selectedNivelPrioridad.size(); i++) {
					nivelPrioridadSeleccionadas += "," + selectedNivelPrioridad.get(i);
				}
			}

			if (compania != null && fechaInicial != null && fechaFinal != null) {
				data = businessDelegatorView.consultaSolicitudesParaMtto(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo, tipoMttoSeleccionadas, flagTipoMtto,
						solicitantesSeleccionados, flagSolicitante, nivelPrioridadSeleccionadas, flagNivelPrioridad,
						origenDatos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	 
	}

	
	
	public List<ConsultaSolicitudesParaMttoDTO> getData() {
		return data;
	}

	public void setData(List<ConsultaSolicitudesParaMttoDTO> datSolicitudesMttoDTO) {
		this.data = datSolicitudesMttoDTO;
	}

	public void setData1(List<DatSolicitudesMttoDTO> datSolicitudesMttoDTO1) {
		this.data1 = datSolicitudesMttoDTO1;
	}

	public DatSolicitudesMttoDTO getSelectedDatSolicitudesMtto() {
		return selectedDatSolicitudesMtto;
	}

	public void setSelectedDatSolicitudesMtto(DatSolicitudesMttoDTO datSolicitudesMtto) {
		this.selectedDatSolicitudesMtto = datSolicitudesMtto;
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

    public SelectItem[] getSelectTrabajadorSolicitante() {
		
		if (trabajadorSolicitante == null || trabajadorSolicitante.size() == 0) {

		 
			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajadorSolicitante = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajadorSolicitante[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		
		
		return selectTrabajadorSolicitante;
	}

	public void setSelectTrabajadorSolicitante(SelectItem[] selectTrabajadorSolicitante) {
		this.selectTrabajadorSolicitante = selectTrabajadorSolicitante;
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

	public SelectItem[] getSelectTipoMantenimiento() {

		if (tipoMantenimiento == null || tipoMantenimiento.size() == 0) {

		 
			try {

				Object[] condicion = { "estado", true, "A", "=" };
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

	public SelectItem[] getselectEquipo() {
		if(txtOrigenDatos.getValue() !=null){
		if (equipo == null || equipo.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				String modulo = txtOrigenDatos.getValue().toString();
				// Criteria
				List<CatalogoEquiposDTO> listaEquipos = businessDelegatorView
						.consultarCatalogoEquipos(idCompania, modulo);
				selectEquipo = new SelectItem[listaEquipos.size()];
				int i = 0;
				for (CatalogoEquiposDTO listaEquiposDTO : listaEquipos) {
					selectEquipo[i] = new SelectItem(listaEquiposDTO.getEquipoId().longValue(),
							listaEquiposDTO.getNom_equipo()

					);
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		}
		return selectEquipo;
	}


	public void setselectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	
	public void setSelectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
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

	public SelectItem[] getSelectTallerMecanico() {

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

	public void setSelectTallerMecanico(SelectItem[] selectTallerMecanico) {
		this.selectTallerMecanico = selectTallerMecanico;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public SelectOneMenu getTxtTallerId() {
		return txtTallerId;
	}

	public void setTxtTallerId(SelectOneMenu txtTallerId) {
		this.txtTallerId = txtTallerId;
	}

	public SelectOneMenu getTxtCompaniaFiltro() {
		return txtCompaniaFiltro;
	}

	public void setTxtCompaniaFiltro(SelectOneMenu txtCompaniaFiltro) {
		this.txtCompaniaFiltro = txtCompaniaFiltro;
	}

	public SelectItem[] getSelectCompaniaFiltro() {

		if (companiafiltro == null || companiafiltro.size() == 0) {
		 	try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Compania> lista = businessDelegatorView.findByCriteriaInCompania(condicion, null, null);
				selectCompaniaFiltro = new SelectItem[lista.size()];

				int i = 0;
				for (Compania compania : lista) {
					selectCompaniaFiltro[i] = new SelectItem(compania.getCompaniaId(), compania.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCompaniaFiltro;
	}

	public void setSelectCompaniaFiltro(SelectItem[] selectCompaniaFiltro) {
		this.selectCompaniaFiltro = selectCompaniaFiltro;
	}

	public List<TipoMantenimiento> getTipoMtto() {
		if (tipoMtto == null || tipoMtto.size() == 0) {
 

			try {
				tipoMtto = businessDelegatorView.getTipoMantenimiento();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return tipoMtto;
	}

	public void setTipoMantenimiento(List<TipoMantenimiento> tipoMtto) {
		this.tipoMtto = tipoMtto;
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

	public List<Trabajador> getSolicitanteMtto() {

		if (solicitanteMtto == null || solicitanteMtto.size() == 0) {
 
			try {
				solicitanteMtto = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return solicitanteMtto;
	}

	public void setSolicitanteMtto(List<Trabajador> solicitanteMtto) {
		this.solicitanteMtto = solicitanteMtto;
	}

	public List<NivelPrioridad> getNivelprioridadMtto() {

		if (nivelprioridadMtto == null || nivelprioridadMtto.size() == 0) {
 

			try {
				nivelprioridadMtto = businessDelegatorView.getNivelPrioridad();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return nivelprioridadMtto;
	}

	public void setNivelprioridadMtto(List<NivelPrioridad> nivelprioridadMtto) {
		this.nivelprioridadMtto = nivelprioridadMtto;
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

	public List<String> getSelectedTipoMtto() {
		return selectedTipoMtto;
	}

	public void setSelectedTipoMtto(List<String> selectedTipoMtto) {
		this.selectedTipoMtto = selectedTipoMtto;
	}

	public List<String> getSelectedSolicitante() {
		return selectedSolicitante;
	}
	
	

	public void setSelectedSolicitante(List<String> selectedSolicitante) {
		this.selectedSolicitante = selectedSolicitante;
	}

	public List<String> getSelectedNivelPrioridad() {
		return selectedNivelPrioridad;
	}

	public void setSelectedNivelPrioridad(List<String> selectedNivelPrioridad) {
		this.selectedNivelPrioridad = selectedNivelPrioridad;
	}

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectTipoMantenimiento(SelectItem[] selectTipoMantenimiento) {
		this.selectTipoMantenimiento = selectTipoMantenimiento;
	}

	public SelectOneMenu getTxtOrigenDatosFiltro() {
		return txtOrigenDatosFiltro;
	}

	public void setTxtOrigenDatosFiltro(SelectOneMenu txtOrigenDatosFiltro) {
		this.txtOrigenDatosFiltro = txtOrigenDatosFiltro;
	}

	public InputText getTxtCierreSolicitud() {
		return txtCierreSolicitud;
	}

	public void setTxtCierreSolicitud(InputText txtCierreSolicitud) {
		this.txtCierreSolicitud = txtCierreSolicitud;
	}

	public Calendar getTxtFechaCierre() {
		return txtFechaCierre;
	}

	public void setTxtFechaCierre(Calendar txtFechaCierre) {
		this.txtFechaCierre = txtFechaCierre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getCompoRequieridoMttoIndustrial() {
		return compoRequieridoMttoIndustrial;
	}

	public void setCompoRequieridoMttoIndustrial(String compoRequieridoMttoIndustrial) {
		this.compoRequieridoMttoIndustrial = compoRequieridoMttoIndustrial;
	}

	public String getOcultaMttoIndustrial() {
		return ocultaMttoIndustrial;
	}

	public void setOcultaMttoIndustrial(String ocultaMttoIndustrial) {
		this.ocultaMttoIndustrial = ocultaMttoIndustrial;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String getCompoRequieridoMttoMaquinaria() {
		return compoRequieridoMttoMaquinaria;
	}

	public void setCompoRequieridoMttoMaquinaria(String compoRequieridoMttoMaquinaria) {
		this.compoRequieridoMttoMaquinaria = compoRequieridoMttoMaquinaria;
	}

	public String getOcultaMttoMaquinaria() {
		return ocultaMttoMaquinaria;
	}

	public void setOcultaMttoMaquinaria(String ocultaMttoMaquinaria) {
		this.ocultaMttoMaquinaria = ocultaMttoMaquinaria;
	}

	public void listener_ConsultaTag() {

		Long equipoid = null;

		if (!txtEquipoId_Equipo.getValue().equals("")) {
			equipoid = Long.parseLong(txtEquipoId_Equipo.getValue().toString());

			try {
				Equipo equipoId = businessDelegatorView.getEquipo(equipoid);
				/* valNPass = datPlanLabor.getNPases(); */
				if(equipoId.getTagId()!=null){
					txtTagId_Tag.setValue(equipoId.getTagId().longValue());
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

}
