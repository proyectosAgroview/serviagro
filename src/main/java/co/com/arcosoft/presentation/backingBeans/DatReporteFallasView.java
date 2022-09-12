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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AgenteCausadorParada;
import co.com.arcosoft.modelo.DatReporteFallas;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.MotivosEntradaTaller;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatReporteFallasDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatReporteFallasView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatReporteFallasView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputTextarea txtDescripcionFalla;
	private SelectOneMenu txtEsParada;
	private SelectOneRadio txtEstado;
	private InputText txtHorometroActual;
	private InputText txtOdometroActual;

	private InputText txtMedidorId;
	private InputText txtObservacionAnularReg;
	private SelectOneMenu txtOrigenDatos;

	private SelectOneMenu txtSupervisorId;
	SelectItem[] selectSupervisor;
	private List<Trabajador> supervisor;

	private SelectOneMenu txtTrabId;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private InputText txtUsuarioDigitacion;

	private SelectOneMenu txtAgenteCausadorParadaId_AgenteCausadorParada;
	SelectItem[] selectAgenteCausador;
	private List<AgenteCausadorParada> agenteCausador;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtMotivosEntradaTallerId_MotivosEntradaTaller;
	SelectItem[] selectMotivoEntradaTaller;
	private List<MotivosEntradaTaller> motivoEntradaTaller;

	private SelectOneMenu txtTagId_Tag;
	SelectItem[] selectTag;
	private List<Tag> tag;

	private InputText txtDatReporteFallasId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private Calendar txtHoraFinalParada;
	private Calendar txtHoraInicialParada;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatReporteFallasDTO> data;
	private DatReporteFallasDTO selectedDatReporteFallas;
	private DatReporteFallas entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private int activeTapIndex = 0;
	private String moduloActivo;

	public DatReporteFallasView() {
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
					moduloActivo= cookie2.getValue();

				}
			}
			
			if (moduloActivo.equals("mantenimiento_maquinaria")) {

				txtOrigenDatos.setValue("Modulo_TallerAgricola");
				txtOrigenDatos.setDisabled(false);
				
			}else {
				
				txtOrigenDatos.setValue("Modulo_MttoIndustrial");
				txtOrigenDatos.setDisabled(false);

			}
		}

	public String action_new() {
		action_clear();
		selectedDatReporteFallas = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatReporteFallas = null;
		PrimeFaces.current().resetInputs(":frm");
		moduloSeleccionado();
		activeTapIndex = 0;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtDescripcionFalla != null) {
			txtDescripcionFalla.setValue(null);
			txtDescripcionFalla.setDisabled(false);
		}

		if (txtEsParada != null) {
			txtEsParada.setValue(null);
			txtEsParada.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtHorometroActual != null) {
			txtHorometroActual.setValue(null);
			txtHorometroActual.setDisabled(true);
		}

		if (txtOdometroActual != null) {
			txtOdometroActual.setValue(null);
			txtOdometroActual.setDisabled(true);
		}

		if (txtMedidorId != null) {
			txtMedidorId.setValue(null);
			txtMedidorId.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(true);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(false);
		}

		if (txtSupervisorId != null) {
			txtSupervisorId.setValue(null);
			txtSupervisorId.setDisabled(false);
		}

		if (txtTrabId != null) {
			txtTrabId.setValue(null);
			txtTrabId.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtAgenteCausadorParadaId_AgenteCausadorParada != null) {
			txtAgenteCausadorParadaId_AgenteCausadorParada.setValue(null);
			txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtMotivosEntradaTallerId_MotivosEntradaTaller != null) {
			txtMotivosEntradaTallerId_MotivosEntradaTaller.setValue(null);
			txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);
		}

		if (txtTagId_Tag != null) {
			txtTagId_Tag.setValue(null);
			txtTagId_Tag.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(true);
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

		if (txtHoraFinalParada != null) {
			txtHoraFinalParada.setValue(null);
			txtHoraFinalParada.setDisabled(true);
		}

		if (txtHoraInicialParada != null) {
			txtHoraInicialParada.setValue(null);
			txtHoraInicialParada.setDisabled(true);
		}

		if (txtDatReporteFallasId != null) {
			txtDatReporteFallasId.setValue(null);
			txtDatReporteFallasId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
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

	public void listener_txtHoraFinalParada() {
		Date inputDate = (Date) txtHoraFinalParada.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtHoraInicialParada() {
		Date inputDate = (Date) txtHoraInicialParada.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void action_parada() throws Exception {
		
		txtHoraInicialParada.setValue(null);
		txtHoraFinalParada.setValue(null);
		
		if (txtEsParada.getValue() != null && txtEsParada.getValue().equals("SI")) {
			txtHoraInicialParada.setDisabled(false);
			txtHoraFinalParada.setDisabled(false);

		} else {
			txtHoraInicialParada.setDisabled(true);
			txtHoraFinalParada.setDisabled(true);
		}
	}

	public void action_selecctMedidorEquipo() throws Exception, Exception {

		Long compania = new Long(getCompaniaIdSession());
		Long equipoId = null;
		equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
		txtHorometroActual.setValue(null);
		txtOdometroActual.setValue(null);

		GregorianCalendar cHoy = new GregorianCalendar();
		java.util.Date fechaReg = FacesUtils.checkDate(txtFechaRegistro);

		cHoy.setTime(fechaReg);
		int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
		int mesHoy = cHoy.get(java.util.Calendar.MONTH);
		int anoHoy = cHoy.get(java.util.Calendar.YEAR);
		cHoy.set(anoHoy, mesHoy, diaHoy);
		java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

		if (equipoId != null && !equipoId.toString().isEmpty()) {

			try {

				Equipo equipo = businessDelegatorView.getEquipo(equipoId);
				if(equipo.getTagId() !=null){
					txtTagId_Tag.setValue(equipo.getTagId().longValue());
				}
				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
					Long idMedidor = medidor.getMedidorId();

					if (medidor.getTipoMedidor().equals("horometro")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

						txtHorometroActual.setValue(valor);
						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(true);

					}
					if (medidor.getTipoMedidor().equals("odometro")) {

						Double valor = Double.parseDouble(businessDelegatorView
								.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

						txtOdometroActual.setValue(valor);
						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(false);

					}
					if (medidor.getTipoMedidor().equals("averiado")) {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));
						txtHorometroActual.setDisabled(true);
						txtOdometroActual.setDisabled(true);
						txtHorometroActual.setValue(null);
						txtOdometroActual.setValue(null);
					}
				} else {

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));

					txtHorometroActual.setDisabled(true);
					txtOdometroActual.setDisabled(true);
					txtHorometroActual.setValue(null);
					txtOdometroActual.setValue(null);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public String action_edit(ActionEvent evt) {
		selectedDatReporteFallas = (DatReporteFallasDTO) (evt.getComponent().getAttributes()
				.get("selectedDatReporteFallas"));
		try {

			Long consecutivo = selectedDatReporteFallas.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatReporteFallas> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatReporteFallas(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtDescripcionFalla.setValue(entity.getDescripcionFalla());
				txtDescripcionFalla.setDisabled(false);
				txtEsParada.setValue(entity.getEsParada());
				txtEsParada.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtHoraFinalParada.setValue(entity.getHoraFinalParada());
				txtHoraFinalParada.setDisabled(false);
				txtHoraInicialParada.setValue(entity.getHoraInicialParada());
				txtHoraInicialParada.setDisabled(false);
				txtHorometroActual.setValue(entity.getHorometroActual());
				txtHorometroActual.setDisabled(false);

				txtOdometroActual.setValue(entity.getOdometroActual());
				txtOdometroActual.setDisabled(false);

				// txtMedidorId.setValue(selectedDatReporteFallas.getMedidorId());
				// txtMedidorId.setDisabled(false);
				txtOrigenDatos.setValue(entity.getOrigenDatos());
				txtOrigenDatos.setDisabled(false);
				txtSupervisorId.setValue(entity.getSupervisorId());
				txtSupervisorId.setDisabled(false);
				txtTrabId.setValue(entity.getTrabId());
				txtTrabId.setDisabled(false);
				txtAgenteCausadorParadaId_AgenteCausadorParada
						.setValue(selectedDatReporteFallas.getAgenteCausadorParadaId_AgenteCausadorParada());
				txtAgenteCausadorParadaId_AgenteCausadorParada.setDisabled(false);
				txtEquipoId_Equipo.setValue(selectedDatReporteFallas.getEquipoId_Equipo());
				txtEquipoId_Equipo.setDisabled(false);
				txtMotivosEntradaTallerId_MotivosEntradaTaller
						.setValue(selectedDatReporteFallas.getMotivosEntradaTallerId_MotivosEntradaTaller());
				txtMotivosEntradaTallerId_MotivosEntradaTaller.setDisabled(false);
				// txtTagId_Tag.setValue(selectedDatReporteFallas.getTagId_Tag());
				// txtTagId_Tag.setDisabled(false);
				txtDatReporteFallasId.setValue(entity.getDatReporteFallasId());
				txtDatReporteFallasId.setDisabled(true);

				Long compania = new Long(getCompaniaIdSession());
				Long equipoId = null;
				equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

				GregorianCalendar cHoy = new GregorianCalendar();
				java.util.Date fechaReg = entity.getFechaRegistro();

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
							txtOdometroActual.setDisabled(true);

						}
						if (medidor.getTipoMedidor().equals("odometro")) {

							Double valor = Double.parseDouble(businessDelegatorView
									.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania).toString());

							txtOdometroActual.setValue(valor);
							txtHorometroActual.setDisabled(true);
							txtOdometroActual.setDisabled(false);

						}
						if (medidor.getTipoMedidor().equals("averiado")) {

							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
											"El medidor de la maquinaria/equipo se encuentra averiado"));
							txtHorometroActual.setDisabled(true);
							txtOdometroActual.setDisabled(true);
							txtHorometroActual.setValue(null);
							txtOdometroActual.setValue(null);
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

				btnSave.setDisabled(false);
				setShowDialog(true);
				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatReporteFallas == null) && (entity == null)) {
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
			entity = new DatReporteFallas();

			// Long datReporteFallasId = FacesUtils.checkLong(txtDatReporteFallasId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setConsecutivo(businessDelegatorView.consultarConsecutivoReporteFallasEquipo(compania));
			// entity.setDatReporteFallasId(datReporteFallasId);
			entity.setDescripcionFalla(FacesUtils.checkString(txtDescripcionFalla));
			entity.setEsParada(FacesUtils.checkString(txtEsParada));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setHoraFinalParada(FacesUtils.checkDate(txtHoraFinalParada));
			entity.setHoraInicialParada(FacesUtils.checkDate(txtHoraInicialParada));
			entity.setHorometroActual(FacesUtils.checkDouble(txtHorometroActual));
			entity.setOdometroActual(FacesUtils.checkDouble(txtOdometroActual));

			entity.setMedidorId(FacesUtils.checkLong(txtMedidorId));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setSupervisorId(FacesUtils.checkLong(txtSupervisorId));
			entity.setTrabId(FacesUtils.checkLong(txtTrabId));
			entity.setAgenteCausadorParada(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada))
							: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setMotivosEntradaTaller(
					(FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller))
							: null);
			entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId_Tag))
					: null);
			businessDelegatorView.saveDatReporteFallas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoReporteFallasEquipo(compania) - 1));
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
				Long datReporteFallasId = new Long(selectedDatReporteFallas.getDatReporteFallasId());
				entity = businessDelegatorView.getDatReporteFallas(datReporteFallasId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setFechaModificacion(date);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDescripcionFalla(FacesUtils.checkString(txtDescripcionFalla));
			entity.setEsParada(FacesUtils.checkString(txtEsParada));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setHoraFinalParada(FacesUtils.checkDate(txtHoraFinalParada));
			entity.setHoraInicialParada(FacesUtils.checkDate(txtHoraInicialParada));
			entity.setHorometroActual(FacesUtils.checkDouble(txtHorometroActual));
			entity.setOdometroActual(FacesUtils.checkDouble(txtOdometroActual));

			entity.setMedidorId(FacesUtils.checkLong(txtMedidorId));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setSupervisorId(FacesUtils.checkLong(txtSupervisorId));
			entity.setTrabId(FacesUtils.checkLong(txtTrabId));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(txtUsuarioDigitacion));
			entity.setAgenteCausadorParada(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId_AgenteCausadorParada))
							: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setMotivosEntradaTaller(
					(FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosEntradaTallerId_MotivosEntradaTaller))
							: null);
			entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId_Tag))
					: null);
			businessDelegatorView.updateDatReporteFallas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatReporteFallas.getDatReporteFallasId());
				entity = businessDelegatorView.getDatReporteFallas(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatReporteFallas(entity);

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
		selectedDatReporteFallas = (DatReporteFallasDTO) (evt.getComponent().getAttributes()
				.get("selectedDatReporteFallas"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatReporteFallas = (DatReporteFallasDTO) (evt.getComponent().getAttributes()
					.get("selectedDatReporteFallas"));

			Long datReporteFallasId = new Long(selectedDatReporteFallas.getDatReporteFallasId());
			entity = businessDelegatorView.getDatReporteFallas(datReporteFallasId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datReporteFallasId = FacesUtils.checkLong(txtDatReporteFallasId);
			entity = businessDelegatorView.getDatReporteFallas(datReporteFallasId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatReporteFallas(entity);
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
			selectedDatReporteFallas = (DatReporteFallasDTO) (evt.getComponent().getAttributes()
					.get("selectedDatReporteFallas"));

			Long datReporteFallasId = new Long(selectedDatReporteFallas.getDatReporteFallasId());
			entity = businessDelegatorView.getDatReporteFallas(datReporteFallasId);
			businessDelegatorView.deleteDatReporteFallas(entity);
			data.remove(selectedDatReporteFallas);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datReporteFallasId, String descripcionFalla,
			String esParada, String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion,
			Date fechaRegistro, Date horaFinalParada, Date horaInicialParada, Double horometroActual, Long medidorId,
			String observacionAnularReg, String origenDatos, Long supervisorId, Long trabId, Long usuarioDigitacion,
			Long agenteCausadorParadaId_AgenteCausadorParada, Long equipoId_Equipo,
			Long motivosEntradaTallerId_MotivosEntradaTaller, Long tagId_Tag) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDescripcionFalla(FacesUtils.checkString(descripcionFalla));
			entity.setEsParada(FacesUtils.checkString(esParada));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setHoraFinalParada(FacesUtils.checkDate(horaFinalParada));
			entity.setHoraInicialParada(FacesUtils.checkDate(horaInicialParada));
			entity.setHorometroActual(FacesUtils.checkDouble(horometroActual));
			entity.setMedidorId(FacesUtils.checkLong(medidorId));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
			entity.setSupervisorId(FacesUtils.checkLong(supervisorId));
			entity.setTrabId(FacesUtils.checkLong(trabId));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatReporteFallas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatReporteFallasView").requestRender();
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

	public InputTextarea getTxtDescripcionFalla() {
		return txtDescripcionFalla;
	}

	public void setTxtDescripcionFalla(InputTextarea txtDescripcionFalla) {
		this.txtDescripcionFalla = txtDescripcionFalla;
	}

	public InputText getTxtHorometroActual() {
		return txtHorometroActual;
	}

	public void setTxtHorometroActual(InputText txtHorometroActual) {
		this.txtHorometroActual = txtHorometroActual;
	}

	public InputText getTxtMedidorId() {
		return txtMedidorId;
	}

	public void setTxtMedidorId(InputText txtMedidorId) {
		this.txtMedidorId = txtMedidorId;
	}

	public InputText getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputText txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
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

	public Calendar getTxtHoraFinalParada() {
		return txtHoraFinalParada;
	}

	public void setTxtHoraFinalParada(Calendar txtHoraFinalParada) {
		this.txtHoraFinalParada = txtHoraFinalParada;
	}

	public Calendar getTxtHoraInicialParada() {
		return txtHoraInicialParada;
	}

	public void setTxtHoraInicialParada(Calendar txtHoraInicialParada) {
		this.txtHoraInicialParada = txtHoraInicialParada;
	}

	public InputText getTxtDatReporteFallasId() {
		return txtDatReporteFallasId;
	}

	public void setTxtDatReporteFallasId(InputText txtDatReporteFallasId) {
		this.txtDatReporteFallasId = txtDatReporteFallasId;
	}

	public List<DatReporteFallasDTO> getData() {
		try {
			if (data == null) {
				moduloSeleccionado();
				String modulo = txtOrigenDatos.getValue().toString();
				data = businessDelegatorView.getDataDatReporteFallas(modulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatReporteFallasDTO> datReporteFallasDTO) {
		this.data = datReporteFallasDTO;
	}

	public DatReporteFallasDTO getSelectedDatReporteFallas() {
		return selectedDatReporteFallas;
	}

	public void setSelectedDatReporteFallas(DatReporteFallasDTO datReporteFallas) {
		this.selectedDatReporteFallas = datReporteFallas;
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

	public SelectOneMenu getTxtEsParada() {
		return txtEsParada;
	}

	public void setTxtEsParada(SelectOneMenu txtEsParada) {
		this.txtEsParada = txtEsParada;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtOdometroActual() {
		return txtOdometroActual;
	}

	public void setTxtOdometroActual(InputText txtOdometroActual) {
		this.txtOdometroActual = txtOdometroActual;
	}

	public SelectOneMenu getTxtSupervisorId() {
		return txtSupervisorId;
	}

	public void setTxtSupervisorId(SelectOneMenu txtSupervisorId) {
		this.txtSupervisorId = txtSupervisorId;
	}

	public SelectOneMenu getTxtTrabId() {
		return txtTrabId;
	}

	public void setTxtTrabId(SelectOneMenu txtTrabId) {
		this.txtTrabId = txtTrabId;
	}

	public List<Trabajador> getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}

	public SelectOneMenu getTxtAgenteCausadorParadaId_AgenteCausadorParada() {
		return txtAgenteCausadorParadaId_AgenteCausadorParada;
	}

	public void setTxtAgenteCausadorParadaId_AgenteCausadorParada(
			SelectOneMenu txtAgenteCausadorParadaId_AgenteCausadorParada) {
		this.txtAgenteCausadorParadaId_AgenteCausadorParada = txtAgenteCausadorParadaId_AgenteCausadorParada;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtMotivosEntradaTallerId_MotivosEntradaTaller() {
		return txtMotivosEntradaTallerId_MotivosEntradaTaller;
	}

	public void setTxtMotivosEntradaTallerId_MotivosEntradaTaller(
			SelectOneMenu txtMotivosEntradaTallerId_MotivosEntradaTaller) {
		this.txtMotivosEntradaTallerId_MotivosEntradaTaller = txtMotivosEntradaTallerId_MotivosEntradaTaller;
	}

	public SelectOneMenu getTxtTagId_Tag() {
		return txtTagId_Tag;
	}

	public void setTxtTagId_Tag(SelectOneMenu txtTagId_Tag) {
		this.txtTagId_Tag = txtTagId_Tag;
	}

	public DatReporteFallas getEntity() {
		return entity;
	}

	public void setEntity(DatReporteFallas entity) {
		this.entity = entity;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
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

	public SelectItem[] getselectSupervisor() {

		if (supervisor == null || supervisor.size() == 0) {

			supervisor = new ArrayList<Trabajador>();

			try {

				Object[] condicion = { "estado", true, "A", "="	};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectSupervisor = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador supervisor : lista) {
					selectSupervisor[i] = new SelectItem(supervisor.getTrabId(), supervisor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSupervisor;
	}

	public void setselectSupervisor(SelectItem[] selectSupervisor) {
		this.selectSupervisor = selectSupervisor;
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

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

	public SelectItem[] getselectTag() {

		if (tag == null || tag.size() == 0) {

			tag = new ArrayList<Tag>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Tag> lista = businessDelegatorView.findByCriteriaInTag(condicion, null, null);
				selectTag = new SelectItem[lista.size()];

				int i = 0;
				for (Tag tag : lista) {
					selectTag[i] = new SelectItem(tag.getTagId(), tag.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTag;
	}

	public void setselectTag(SelectItem[] selectTag) {
		this.selectTag = selectTag;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
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
