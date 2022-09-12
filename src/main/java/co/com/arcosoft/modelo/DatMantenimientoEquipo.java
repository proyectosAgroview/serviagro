package co.com.arcosoft.modelo;
// Generated 23-jul-2017 14:00:29 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatMantenimientoEquipo generated by hbm2java
 */
public class DatMantenimientoEquipo implements java.io.Serializable {

	private Long datMantenimientoEquipoId;
	private Equipo equipo;
	private Trabajador trabajador;
	private TallerMecanico tallerMecanico;
	private PlanRevisionEquipo planRevisionEquipo;
	private AgenteCausadorParada agenteCausadorParada;
	private CentCost centCost;
	private MotivosEntradaTaller motivosEntradaTaller;
	private TipoMantenimiento tipoMantenimiento;
	private Long orderTrabajo;
	private Long consecutivo;
	private Date fechaEntradaTaller;
	private Double vidaKm;
	private Double vidaHoras;
	private Date duracion;
	private Long conductor;
	private String reporteTecnico;
	private Long compania;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long usuarioDigitacion;
	private String observacionAnularReg;
	private Date fechaAnulacion;
	private Date fechaCierreOt;
	private Date fechaReaperturaOt;
	private String cierreOt;
	private String estado;
	private Date fechaSalidaTaller;
	private NivelPrioridad nivelPrioridad;
	private ZonasFabrica zonasFabrica;
	private Tag tag;
	private AreaTrabajo areaTrabajo;
	private String tipoProcedimiento;
	private Double vidaDias;
	private String foto;
	private Set<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs = new HashSet<DatMantenimientoEquipoMec>(0);
	private Set<DatMantenimientoEquipoProd> datMantenimientoEquipoProds = new HashSet<DatMantenimientoEquipoProd>(0);
	private String origenDatos;
	private Long datSolicitudMttoId;
	private String requiereParadaFabrica;
	private String descripcionSolicitud;
	private Trabajador responsableMttoId;
	private Double difTiempoMttoAnteriorActual;
	private String tipoOrdenMtto;
	private String agenteCausadorDescripcion;
	private String tipoFallaDescripcion;
	private String tallerMecanicoDescripcion;
	private Double horOdoSalida;

	public DatMantenimientoEquipo() {
	}

	public DatMantenimientoEquipo(String tipoOrdenMtto, String foto, Equipo equipo, Trabajador trabajador,
			TallerMecanico tallerMecanico, PlanRevisionEquipo planRevisionEquipo,
			AgenteCausadorParada agenteCausadorParada, CentCost centCost, MotivosEntradaTaller motivosEntradaTaller,
			TipoMantenimiento tipoMantenimiento, Long orderTrabajo, Long consecutivo, Date fechaEntradaTaller,
			Double vidaKm, Double vidaHoras, Date duracion, Long conductor, String reporteTecnico, Long compania,
			Date fechaCreacion, Date fechaModificacion, Long usuarioDigitacion, String observacionAnularReg,
			Date fechaAnulacion, Date fechaCierreOt, Date fechaReaperturaOt, String cierreOt, String estado,
			Date fechaSalidaTaller, Tag tag, NivelPrioridad nivelPrioridad, String tipoProcedimiento, Double vidaDias,
			Set<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs,
			Set<DatMantenimientoEquipoProd> datMantenimientoEquipoProds, String origenDatos,
			Set<DatSolicitudesMtto> datSolicitudesMttos, Long datSolicitudMttoId, String requiereParadaFabrica,
			AreaTrabajo areaTrabajo, ZonasFabrica zonasFabrica, String descripcionSolicitud,
			Trabajador responsableMttoId, Double difTiempoMttoAnteriorActual, String agenteCausadorDescripcion,
			String tipoFallaDescripcion, String tallerMecanicoDescripcion, Double horOdoSalida) {
		this.equipo = equipo;
		this.trabajador = trabajador;
		this.tallerMecanico = tallerMecanico;
		this.planRevisionEquipo = planRevisionEquipo;
		this.agenteCausadorParada = agenteCausadorParada;
		this.centCost = centCost;
		this.motivosEntradaTaller = motivosEntradaTaller;
		this.tipoMantenimiento = tipoMantenimiento;
		this.orderTrabajo = orderTrabajo;
		this.consecutivo = consecutivo;
		this.fechaEntradaTaller = fechaEntradaTaller;
		this.vidaKm = vidaKm;
		this.vidaHoras = vidaHoras;
		this.duracion = duracion;
		this.conductor = conductor;
		this.reporteTecnico = reporteTecnico;
		this.compania = compania;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioDigitacion = usuarioDigitacion;
		this.observacionAnularReg = observacionAnularReg;
		this.fechaAnulacion = fechaAnulacion;
		this.fechaCierreOt = fechaCierreOt;
		this.fechaReaperturaOt = fechaReaperturaOt;
		this.cierreOt = cierreOt;
		this.estado = estado;
		this.fechaSalidaTaller = fechaSalidaTaller;
		this.tag = tag;
		this.nivelPrioridad = nivelPrioridad;
		this.tipoProcedimiento = tipoProcedimiento;
		this.vidaDias = vidaDias;
		this.datMantenimientoEquipoMecs = datMantenimientoEquipoMecs;
		this.datMantenimientoEquipoProds = datMantenimientoEquipoProds;
		this.origenDatos = origenDatos;
		this.datSolicitudMttoId = datSolicitudMttoId;
		this.requiereParadaFabrica = requiereParadaFabrica;
		this.areaTrabajo = areaTrabajo;
		this.zonasFabrica = zonasFabrica;
		this.descripcionSolicitud = descripcionSolicitud;
		this.responsableMttoId = responsableMttoId;
		this.difTiempoMttoAnteriorActual = difTiempoMttoAnteriorActual;
		this.tipoOrdenMtto = tipoOrdenMtto;
		this. agenteCausadorDescripcion =agenteCausadorDescripcion;
		this. tipoFallaDescripcion=tipoFallaDescripcion;
		this. tallerMecanicoDescripcion=tallerMecanicoDescripcion;
		this. horOdoSalida=horOdoSalida;
	}
	
	

	public String getAgenteCausadorDescripcion() {
		return agenteCausadorDescripcion;
	}

	public String getTipoFallaDescripcion() {
		return tipoFallaDescripcion;
	}

	public String getTallerMecanicoDescripcion() {
		return tallerMecanicoDescripcion;
	}

	public Double getHorOdoSalida() {
		return horOdoSalida;
	}

	public void setAgenteCausadorDescripcion(String agenteCausadorDescripcion) {
		this.agenteCausadorDescripcion = agenteCausadorDescripcion;
	}

	public void setTipoFallaDescripcion(String tipoFallaDescripcion) {
		this.tipoFallaDescripcion = tipoFallaDescripcion;
	}

	public void setTallerMecanicoDescripcion(String tallerMecanicoDescripcion) {
		this.tallerMecanicoDescripcion = tallerMecanicoDescripcion;
	}

	public void setHorOdoSalida(Double horOdoSalida) {
		this.horOdoSalida = horOdoSalida;
	}

	public String getTipoOrdenMtto() {
		return tipoOrdenMtto;
	}

	public void setTipoOrdenMtto(String tipoOrdenMtto) {
		this.tipoOrdenMtto = tipoOrdenMtto;
	}

	public Double getDifTiempoMttoAnteriorActual() {
		return difTiempoMttoAnteriorActual;
	}

	public void setDifTiempoMttoAnteriorActual(Double difTiempoMttoAnteriorActual) {
		this.difTiempoMttoAnteriorActual = difTiempoMttoAnteriorActual;
	}

	public Trabajador getResponsableMttoId() {
		return responsableMttoId;
	}

	public void setResponsableMttoId(Trabajador responsableMttoId) {
		this.responsableMttoId = responsableMttoId;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Long getDatMantenimientoEquipoId() {
		return this.datMantenimientoEquipoId;
	}

	public void setDatMantenimientoEquipoId(Long datMantenimientoEquipoId) {
		this.datMantenimientoEquipoId = datMantenimientoEquipoId;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public TallerMecanico getTallerMecanico() {
		return this.tallerMecanico;
	}

	public void setTallerMecanico(TallerMecanico tallerMecanico) {
		this.tallerMecanico = tallerMecanico;
	}

	public PlanRevisionEquipo getPlanRevisionEquipo() {
		return this.planRevisionEquipo;
	}

	public void setPlanRevisionEquipo(PlanRevisionEquipo planRevisionEquipo) {
		this.planRevisionEquipo = planRevisionEquipo;
	}

	public AgenteCausadorParada getAgenteCausadorParada() {
		return this.agenteCausadorParada;
	}

	public void setAgenteCausadorParada(AgenteCausadorParada agenteCausadorParada) {
		this.agenteCausadorParada = agenteCausadorParada;
	}

	public CentCost getCentCost() {
		return this.centCost;
	}

	public void setCentCost(CentCost centCost) {
		this.centCost = centCost;
	}

	public MotivosEntradaTaller getMotivosEntradaTaller() {
		return this.motivosEntradaTaller;
	}

	public void setMotivosEntradaTaller(MotivosEntradaTaller motivosEntradaTaller) {
		this.motivosEntradaTaller = motivosEntradaTaller;
	}

	public TipoMantenimiento getTipoMantenimiento() {
		return this.tipoMantenimiento;
	}

	public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public Long getOrderTrabajo() {
		return this.orderTrabajo;
	}

	public void setOrderTrabajo(Long orderTrabajo) {
		this.orderTrabajo = orderTrabajo;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Date getFechaEntradaTaller() {
		return this.fechaEntradaTaller;
	}

	public void setFechaEntradaTaller(Date fechaEntradaTaller) {
		this.fechaEntradaTaller = fechaEntradaTaller;
	}

	public Double getVidaKm() {
		return this.vidaKm;
	}

	public void setVidaKm(Double vidaKm) {
		this.vidaKm = vidaKm;
	}

	public Double getVidaHoras() {
		return this.vidaHoras;
	}

	public void setVidaHoras(Double vidaHoras) {
		this.vidaHoras = vidaHoras;
	}

	public Date getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}

	public Long getConductor() {
		return this.conductor;
	}

	public void setConductor(Long conductor) {
		this.conductor = conductor;
	}

	public String getReporteTecnico() {
		return this.reporteTecnico;
	}

	public void setReporteTecnico(String reporteTecnico) {
		this.reporteTecnico = reporteTecnico;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getUsuarioDigitacion() {
		return this.usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public String getObservacionAnularReg() {
		return this.observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Date getFechaCierreOt() {
		return this.fechaCierreOt;
	}

	public void setFechaCierreOt(Date fechaCierreOt) {
		this.fechaCierreOt = fechaCierreOt;
	}

	public Date getFechaReaperturaOt() {
		return this.fechaReaperturaOt;
	}

	public void setFechaReaperturaOt(Date fechaReaperturaOt) {
		this.fechaReaperturaOt = fechaReaperturaOt;
	}

	public String getCierreOt() {
		return this.cierreOt;
	}

	public void setCierreOt(String cierreOt) {
		this.cierreOt = cierreOt;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaSalidaTaller() {
		return this.fechaSalidaTaller;
	}

	public void setFechaSalidaTaller(Date fechaSalidaTaller) {
		this.fechaSalidaTaller = fechaSalidaTaller;
	}

	public String getTipoProcedimiento() {
		return this.tipoProcedimiento;
	}

	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.tipoProcedimiento = tipoProcedimiento;
	}

	public Double getVidaDias() {
		return this.vidaDias;
	}

	public void setVidaDias(Double vidaDias) {
		this.vidaDias = vidaDias;
	}

	public Set<DatMantenimientoEquipoMec> getDatMantenimientoEquipoMecs() {
		return this.datMantenimientoEquipoMecs;
	}

	public void setDatMantenimientoEquipoMecs(Set<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs) {
		this.datMantenimientoEquipoMecs = datMantenimientoEquipoMecs;
	}

	public Set<DatMantenimientoEquipoProd> getDatMantenimientoEquipoProds() {
		return this.datMantenimientoEquipoProds;
	}

	public void setDatMantenimientoEquipoProds(Set<DatMantenimientoEquipoProd> datMantenimientoEquipoProds) {
		this.datMantenimientoEquipoProds = datMantenimientoEquipoProds;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getDatSolicitudMttoId() {
		return datSolicitudMttoId;
	}

	public void setDatSolicitudMttoId(Long datSolicitudMttoId) {
		this.datSolicitudMttoId = datSolicitudMttoId;
	}

	public NivelPrioridad getNivelPrioridad() {
		return nivelPrioridad;
	}

	public void setNivelPrioridad(NivelPrioridad nivelPrioridad) {
		this.nivelPrioridad = nivelPrioridad;
	}

	public ZonasFabrica getZonasFabrica() {
		return zonasFabrica;
	}

	public void setZonasFabrica(ZonasFabrica zonasFabrica) {
		this.zonasFabrica = zonasFabrica;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public AreaTrabajo getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(AreaTrabajo areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	public String getRequiereParadaFabrica() {
		return requiereParadaFabrica;
	}

	public void setRequiereParadaFabrica(String requiereParadaFabrica) {
		this.requiereParadaFabrica = requiereParadaFabrica;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

}