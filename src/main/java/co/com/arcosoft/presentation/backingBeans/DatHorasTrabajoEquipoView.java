package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import co.com.arcosoft.modelo.DatHorasTrabajoEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatHorasTrabajoEquipoDTO;
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
public class DatHorasTrabajoEquipoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatHorasTrabajoEquipoView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputText txtDiaActual;
	private InputText txtHorasActual;
	private InputText txtKmActual;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private SelectOneMenu txtOrigenDatos;
	private SelectOneMenu txtEstadoMaquina;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatHorasTrabajoEquipoId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatHorasTrabajoEquipoDTO> data;
	private DatHorasTrabajoEquipoDTO selectedDatHorasTrabajoEquipo;
	private DatHorasTrabajoEquipo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtMedidor;
	SelectItem[] selectMedidor;
	private List<Medidor> medidor;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private InputText txtUltimoMedidorHoras;
	private InputText txtUltimoMedidorKm;
	private InputText txtUltimoMedidorDias;
	private String moduloActivo;

	public DatHorasTrabajoEquipoView() {
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
		selectedDatHorasTrabajoEquipo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatHorasTrabajoEquipo = null;
		PrimeFaces.current().resetInputs(":frm");
		moduloSeleccionado();
		
		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtDiaActual != null) {
			txtDiaActual.setValue(null);
			txtDiaActual.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}
		
		if (txtEstadoMaquina != null) {
			txtEstadoMaquina.setValue(null);
			txtEstadoMaquina.setDisabled(false);
		}

		if (txtHorasActual != null) {
			txtHorasActual.setValue(null);
			txtHorasActual.setDisabled(false);
		}

		if (txtKmActual != null) {
			txtKmActual.setValue(null);
			txtKmActual.setDisabled(false);
		}

		if (txtMedidor != null) {
			txtMedidor.setValue(null);
			txtMedidor.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(true);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
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
			Date date = new Date();
			txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtDatHorasTrabajoEquipoId != null) {
			txtDatHorasTrabajoEquipoId.setValue(null);
			txtDatHorasTrabajoEquipoId.setDisabled(false);
		}

		if (txtUltimoMedidorHoras != null) {
			txtUltimoMedidorHoras.setValue(null);
			txtUltimoMedidorHoras.setDisabled(true);
		}
		if (txtUltimoMedidorKm != null) {
			txtUltimoMedidorKm.setValue(null);
			txtUltimoMedidorKm.setDisabled(true);
		}
		if (txtUltimoMedidorDias != null) {
			txtUltimoMedidorDias.setValue(null);
			txtUltimoMedidorDias.setDisabled(true);
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

	public void action_selectMedidorEquipo() throws Exception {

		Long equipoId = null;
		equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
		Long compania = new Long(getCompaniaIdSession());
		txtMedidor.setValue(null);
		txtObservacion.setValue(null);
		
		GregorianCalendar cHoy = new GregorianCalendar();
		java.util.Date fechaReg = FacesUtils.checkDate(txtFechaRegistro);
		
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

				if (medidor != null) {
					
					Long idMedidor = medidor.getMedidorId();
					txtMedidor.setValue(equipo.getMedidor().longValue());
					txtMedidor.setDisabled(true);

					if (medidor.getTipoMedidor().equals("horometro")) {
						
						txtUltimoMedidorKm.setValue(null);
						txtKmActual.setValue(null);

						txtUltimoMedidorDias.setValue(null);
						txtDiaActual.setValue(null);

						BigDecimal valor = businessDelegatorView
								.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania);
						
						txtUltimoMedidorHoras.setValue(valor);
						txtUltimoMedidorHoras.setDisabled(true);
						
						txtHorasActual.setDisabled(false);						
						txtKmActual.setDisabled(true);
						
						txtUltimoMedidorKm.setDisabled(true);
						txtUltimoMedidorDias.setDisabled(true);
						
						txtDiaActual.setDisabled(true);
					}					
					
					if (medidor.getTipoMedidor().equals("odometro")) {
												
						txtUltimoMedidorHoras.setValue(null);
						txtHorasActual.setValue(null);

						txtUltimoMedidorDias.setValue(null);
						txtDiaActual.setValue(null);

						BigDecimal valor = businessDelegatorView
								.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania);
						
						txtUltimoMedidorKm.setValue(valor);
						txtUltimoMedidorKm.setDisabled(true);
						
						txtHorasActual.setDisabled(true);
						txtKmActual.setDisabled(false);
						
						txtUltimoMedidorHoras.setDisabled(true);
						txtUltimoMedidorDias.setDisabled(true);
						
						txtDiaActual.setDisabled(true);
					}
					
					if (medidor.getTipoMedidor().equals("dias")) {
						
						txtUltimoMedidorHoras.setValue(null);
						txtHorasActual.setValue(null);

						txtUltimoMedidorKm.setValue(null);
						txtKmActual.setValue(null);

						BigDecimal valor = businessDelegatorView
								.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania);
						
						txtUltimoMedidorDias.setValue(valor);
						txtUltimoMedidorDias.setDisabled(true);
						
						txtKmActual.setDisabled(true);
						txtDiaActual.setDisabled(false);
						
						txtUltimoMedidorHoras.setDisabled(true);
						txtHorasActual.setDisabled(true);
					}					

					if (medidor.getTipoMedidor().equals("averiado")) {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));
						txtHorasActual.setDisabled(true);
						txtUltimoMedidorHoras.setDisabled(true);
						txtKmActual.setDisabled(true);
						txtUltimoMedidorKm.setDisabled(true);
						txtDiaActual.setDisabled(true);
						txtObservacion.setDisabled(true);						
					}
				}
			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
						"No se ha asignado un medidor a la maquinaria/equipo"));

				txtHorasActual.setDisabled(true);
				txtUltimoMedidorHoras.setDisabled(true);
				txtKmActual.setDisabled(true);
				txtUltimoMedidorKm.setDisabled(true);
				txtDiaActual.setDisabled(true);
				txtUltimoMedidorDias.setDisabled(true);
				
				txtHorasActual.setValue(null);
				txtKmActual.setValue(null);
				txtUltimoMedidorHoras.setValue(null);
				txtUltimoMedidorKm.setValue(null);
				txtUltimoMedidorDias.setValue(null);
				txtDiaActual.setValue(null);
                
				txtObservacion.setValue(null);
				txtMedidor.setValue(null);
				txtMedidor.setDisabled(true);
				txtObservacion.setDisabled(true);

			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatHorasTrabajoEquipo = (DatHorasTrabajoEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatHorasTrabajoEquipo"));

		try {

			Long consecutivo = selectedDatHorasTrabajoEquipo.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatHorasTrabajoEquipo> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatHorasTrabajoEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtOrigenDatos.setValue(entity.getOrigenDatos());
				txtOrigenDatos.setDisabled(false);
				txtEquipoId_Equipo.setValue(selectedDatHorasTrabajoEquipo.getEquipoId_Equipo());
				txtEquipoId_Equipo.setDisabled(false);
				txtDatHorasTrabajoEquipoId.setValue(entity.getDatHorasTrabajoEquipoId());
				txtDatHorasTrabajoEquipoId.setDisabled(true);
				txtMedidor.setValue(entity.getMedidor());
				txtMedidor.setDisabled(true);
				
				txtEstadoMaquina.setValue(entity.getEstadoMaquina());
				txtEstadoMaquina.setDisabled(false);

				Long equipoId = null;
				equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
				Long compania = new Long(getCompaniaIdSession());

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

						if (medidor != null) {
							
							Long idMedidor = medidor.getMedidorId();
							txtMedidor.setValue(equipo.getMedidor().longValue());
							txtMedidor.setDisabled(true);

							if (medidor.getTipoMedidor().equals("horometro")) {
								
								txtUltimoMedidorKm.setValue(null);
								txtKmActual.setValue(null);

								txtUltimoMedidorDias.setValue(null);
								txtDiaActual.setValue(null);

								BigDecimal valor = businessDelegatorView
										.consultarHorometroActual(fechaHoy, equipoId, idMedidor, compania);
								
								txtUltimoMedidorHoras.setValue(valor);
								txtUltimoMedidorHoras.setDisabled(true);
								
								txtHorasActual.setValue(entity.getHorasActual());
								txtHorasActual.setDisabled(true);						
								
								txtKmActual.setDisabled(true);
								
								txtUltimoMedidorKm.setDisabled(true);
								txtUltimoMedidorDias.setDisabled(true);
								
								txtDiaActual.setDisabled(true);
							}					
							
							if (medidor.getTipoMedidor().equals("odometro")) {
														
								txtUltimoMedidorHoras.setValue(null);
								txtHorasActual.setValue(null);

								txtUltimoMedidorDias.setValue(null);
								txtDiaActual.setValue(null);

								BigDecimal valor = businessDelegatorView
										.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania);
								
								txtUltimoMedidorKm.setValue(valor);
								txtUltimoMedidorKm.setDisabled(true);
								
								txtHorasActual.setDisabled(true);
								
								txtKmActual.setValue(entity.getKmActual());
								txtKmActual.setDisabled(true);
								
								txtUltimoMedidorHoras.setDisabled(true);
								txtUltimoMedidorDias.setDisabled(true);
								
								txtDiaActual.setDisabled(true);
							}
							
							if (medidor.getTipoMedidor().equals("dias")) {
								
								txtUltimoMedidorHoras.setValue(null);
								txtHorasActual.setValue(null);

								txtUltimoMedidorKm.setValue(null);
								txtKmActual.setValue(null);

								BigDecimal valor = businessDelegatorView
										.consultarOdometroActual(fechaHoy, equipoId, idMedidor, compania);
								
								txtUltimoMedidorDias.setValue(valor);
								txtUltimoMedidorDias.setDisabled(true);
								
								txtKmActual.setDisabled(true);
								
								txtDiaActual.setValue(entity.getDiaActual());
								txtDiaActual.setDisabled(true);
								
								txtUltimoMedidorHoras.setDisabled(true);
								txtHorasActual.setDisabled(true);
							}					

							if (medidor.getTipoMedidor().equals("averiado")) {

								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));
								txtHorasActual.setDisabled(true);
								txtUltimoMedidorHoras.setDisabled(true);
								txtKmActual.setDisabled(true);
								txtDiaActual.setDisabled(true);
								txtUltimoMedidorKm.setDisabled(true);
								txtObservacion.setDisabled(true);						
							}
						}
					} else {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
								"No se ha asignado un medidor a la maquinaria/equipo"));

						txtHorasActual.setDisabled(true);
						txtUltimoMedidorHoras.setDisabled(true);
						txtKmActual.setDisabled(true);
						txtUltimoMedidorKm.setDisabled(true);
						txtDiaActual.setDisabled(true);
						txtUltimoMedidorDias.setDisabled(true);
						
						txtHorasActual.setValue(null);
						txtKmActual.setValue(null);
						txtUltimoMedidorHoras.setValue(null);
						txtUltimoMedidorKm.setValue(null);
						txtUltimoMedidorDias.setValue(null);
						txtDiaActual.setValue(null);
		                
						txtObservacion.setValue(null);
						txtMedidor.setValue(null);
						txtMedidor.setDisabled(true);
						txtObservacion.setDisabled(true);

					}
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
			if ((selectedDatHorasTrabajoEquipo == null) && (entity == null)) {
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

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatHorasTrabajoEquipo.getDatHorasTrabajoEquipoId());
				entity = businessDelegatorView.getDatHorasTrabajoEquipo(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatHorasTrabajoEquipo(entity);
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
		selectedDatHorasTrabajoEquipo = (DatHorasTrabajoEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatHorasTrabajoEquipo"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_create() {
		try {
			entity = new DatHorasTrabajoEquipo();

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			Long equipoId = null;
			equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
			boolean flagGrabar = false;			
			
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setConsecutivo(businessDelegatorView.consultarConsecutivoRegistroHorasEquipo(compania));
			// entity.setDatHorasTrabajoEquipoId(datHorasTrabajoEquipoId);
			entity.setDiaActual(FacesUtils.checkDouble(txtDiaActual));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setMedidor(FacesUtils.checkDouble(txtMedidor));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setEstadoMaquina(FacesUtils.checkString(txtEstadoMaquina));
			entity.setHorasActual(FacesUtils.checkDouble(txtHorasActual));
			entity.setKmActual(FacesUtils.checkDouble(txtKmActual));
			entity.setDiaActual(FacesUtils.checkDouble(txtDiaActual));

			if (equipoId != null && !equipoId.toString().isEmpty()) {

				Equipo equipo = businessDelegatorView.getEquipo(equipoId);

				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());

					if (medidor != null) {
						
						Long idMedidor = medidor.getMedidorId();
						txtMedidor.setValue(equipo.getMedidor().longValue());
						txtMedidor.setDisabled(true);

						if (medidor.getTipoMedidor().equals("horometro")) {							
							
							Double valor = Double.parseDouble( businessDelegatorView
									.consultarHorometroActual(entity.getFechaRegistro(), equipoId, idMedidor, compania).toString());
														
							if(entity.getHorasActual().doubleValue() < valor ) {
								
								flagGrabar = false;
								
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor digitado de la maquinaria/equipo debe ser mayor que el anterior"));
							
							} else {								
								
								flagGrabar = true;
								
							}

						}					
						
						if (medidor.getTipoMedidor().equals("odometro")) {


							Double valor = Double.parseDouble( businessDelegatorView
									.consultarOdometroActual(entity.getFechaRegistro(), equipoId, idMedidor, compania).toString());							
							
                            if(entity.getKmActual().doubleValue() < valor ) {
                            	
                            	flagGrabar = false;
								
                            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor digitado de la maquinaria/equipo debe ser mayor que el anterior"));
							
							}else {
								
								flagGrabar = true;
							}

						}
						
						if (medidor.getTipoMedidor().equals("dias")) {

							Double valor = Double.parseDouble( businessDelegatorView
									.consultarOdometroActual(entity.getFechaRegistro(), equipoId, idMedidor, compania).toString());							
							
                            if(entity.getDiaActual().doubleValue() < valor ) {
                            	
                            	flagGrabar = false;
								
                            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor digitado de la maquinaria/equipo debe ser mayor que el anterior"));
							
							}else {
								
								flagGrabar = true;
							}

						} 					
					}
				} 			
			}
			
			if(flagGrabar) {
				
				businessDelegatorView.saveDatHorasTrabajoEquipo(entity);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
						+ (businessDelegatorView.consultarConsecutivoRegistroHorasEquipo(compania) - 1));
				action_clear();
				
			}else {
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
				Long datHorasTrabajoEquipoId = new Long(selectedDatHorasTrabajoEquipo.getDatHorasTrabajoEquipoId());
				entity = businessDelegatorView.getDatHorasTrabajoEquipo(datHorasTrabajoEquipoId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			Long equipoId = null;
			equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
			boolean flagGrabar = false;
			
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));

			entity.setDiaActual(FacesUtils.checkDouble(txtDiaActual));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setHorasActual(FacesUtils.checkDouble(txtHorasActual));
			entity.setKmActual(FacesUtils.checkDouble(txtKmActual));
			entity.setMedidor(FacesUtils.checkDouble(txtMedidor));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setEstadoMaquina(FacesUtils.checkString(txtEstadoMaquina));
			
			if (equipoId != null && !equipoId.toString().isEmpty()) {

				Equipo equipo = businessDelegatorView.getEquipo(equipoId);

				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());

					if (medidor != null) {
						
						Long idMedidor = medidor.getMedidorId();
						txtMedidor.setValue(equipo.getMedidor().longValue());
						txtMedidor.setDisabled(true);

						if (medidor.getTipoMedidor().equals("horometro")) {							
							
							Double valor = Double.parseDouble( businessDelegatorView
									.consultarHorometroActual(entity.getFechaRegistro(), equipoId, idMedidor, compania).toString());
														
							if(entity.getHorasActual().doubleValue() < valor ) {
								
								flagGrabar = false;
								
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor digitado de la maquinaria/equipo debe ser mayor que el anterior"));
							
							} else {								
								
								flagGrabar = true;
								
							}

						}					
						
						if (medidor.getTipoMedidor().equals("odometro")) {

							Double valor = Double.parseDouble( businessDelegatorView
									.consultarOdometroActual(entity.getFechaRegistro(), equipoId, idMedidor, compania).toString());
							
							
                            if(entity.getHorasActual().doubleValue() < valor ) {
                            	
                            	flagGrabar = false;
								
                            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor digitado de la maquinaria/equipo debe ser mayor que el anterior"));
							
							} else {
								
								flagGrabar = true;
							}

						}
						
						if (medidor.getTipoMedidor().equals("dias")) {

							Double valor = Double.parseDouble( businessDelegatorView
									.consultarOdometroActual(entity.getFechaRegistro(), equipoId, idMedidor, compania).toString());							
							
                            if(entity.getDiaActual().doubleValue() < valor ) {
                            	
                            	flagGrabar = false;
								
                            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upss!", "El medidor digitado de la maquinaria/equipo debe ser mayor que el anterior"));
							
							} else {
								
								flagGrabar = true;
							}

						} 							
					}
				} 			
			}
			
			if(flagGrabar) {
				
				businessDelegatorView.updateDatHorasTrabajoEquipo(entity);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				
			}else {
				data = null;
			}
			

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatHorasTrabajoEquipo = (DatHorasTrabajoEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatHorasTrabajoEquipo"));

			Long datHorasTrabajoEquipoId = new Long(selectedDatHorasTrabajoEquipo.getDatHorasTrabajoEquipoId());
			entity = businessDelegatorView.getDatHorasTrabajoEquipo(datHorasTrabajoEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datHorasTrabajoEquipoId = FacesUtils.checkLong(txtDatHorasTrabajoEquipoId);
			entity = businessDelegatorView.getDatHorasTrabajoEquipo(datHorasTrabajoEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatHorasTrabajoEquipo(entity);
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
			selectedDatHorasTrabajoEquipo = (DatHorasTrabajoEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatHorasTrabajoEquipo"));

			Long datHorasTrabajoEquipoId = new Long(selectedDatHorasTrabajoEquipo.getDatHorasTrabajoEquipoId());
			entity = businessDelegatorView.getDatHorasTrabajoEquipo(datHorasTrabajoEquipoId);
			businessDelegatorView.deleteDatHorasTrabajoEquipo(entity);
			data.remove(selectedDatHorasTrabajoEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datHorasTrabajoEquipoId, Double diaActual,
			String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, Date fechaRegistro,
			Double horasActual, Double kmActual, Double medidor, String observacion, String observacionAnularReg,
			String origenDatos, Long usuarioDigitacion, Long equipoId_Equipo) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDiaActual(FacesUtils.checkDouble(diaActual));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setHorasActual(FacesUtils.checkDouble(horasActual));
			entity.setKmActual(FacesUtils.checkDouble(kmActual));
			entity.setMedidor(FacesUtils.checkDouble(medidor));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatHorasTrabajoEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatHorasTrabajoEquipoView").requestRender();
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

	public InputText getTxtDiaActual() {
		return txtDiaActual;
	}

	public void setTxtDiaActual(InputText txtDiaActual) {
		this.txtDiaActual = txtDiaActual;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtHorasActual() {
		return txtHorasActual;
	}

	public void setTxtHorasActual(InputText txtHorasActual) {
		this.txtHorasActual = txtHorasActual;
	}

	public InputText getTxtKmActual() {
		return txtKmActual;
	}

	public void setTxtKmActual(InputText txtKmActual) {
		this.txtKmActual = txtKmActual;
	}

	public SelectOneMenu getTxtMedidor() {
		return txtMedidor;
	}

	public void setTxtMedidor(SelectOneMenu txtMedidor) {
		this.txtMedidor = txtMedidor;
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

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
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

	public InputText getTxtDatHorasTrabajoEquipoId() {
		return txtDatHorasTrabajoEquipoId;
	}

	public void setTxtDatHorasTrabajoEquipoId(InputText txtDatHorasTrabajoEquipoId) {
		this.txtDatHorasTrabajoEquipoId = txtDatHorasTrabajoEquipoId;
	}

	public List<DatHorasTrabajoEquipoDTO> getData() {
		try {
			if (data == null) {
				moduloSeleccionado();
				String modulo = txtOrigenDatos.getValue().toString();
				data = businessDelegatorView.getDataDatHorasTrabajoEquipo(modulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatHorasTrabajoEquipoDTO> datHorasTrabajoEquipoDTO) {
		this.data = datHorasTrabajoEquipoDTO;
	}

	public DatHorasTrabajoEquipoDTO getSelectedDatHorasTrabajoEquipo() {
		return selectedDatHorasTrabajoEquipo;
	}

	public void setSelectedDatHorasTrabajoEquipo(DatHorasTrabajoEquipoDTO datHorasTrabajoEquipo) {
		this.selectedDatHorasTrabajoEquipo = datHorasTrabajoEquipo;
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

	public InputText getTxtUltimoMedidorHoras() {
		return txtUltimoMedidorHoras;
	}

	public void setTxtUltimoMedidorHoras(InputText txtUltimoMedidorHoras) {
		this.txtUltimoMedidorHoras = txtUltimoMedidorHoras;
	}

	public InputText getTxtUltimoMedidorKm() {
		return txtUltimoMedidorKm;
	}

	public void setTxtUltimoMedidorKm(InputText txtUltimoMedidorKm) {
		this.txtUltimoMedidorKm = txtUltimoMedidorKm;
	}

	public InputText getTxtUltimoMedidorDias() {
		return txtUltimoMedidorDias;
	}

	public void setTxtUltimoMedidorDias(InputText txtUltimoMedidorDias) {
		this.txtUltimoMedidorDias = txtUltimoMedidorDias;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public SelectOneMenu getTxtEstadoMaquina() {
		return txtEstadoMaquina;
	}

	public void setTxtEstadoMaquina(SelectOneMenu txtEstadoMaquina) {
		this.txtEstadoMaquina = txtEstadoMaquina;
	}



}
