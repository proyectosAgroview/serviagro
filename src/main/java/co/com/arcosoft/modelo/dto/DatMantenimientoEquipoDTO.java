package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Equipo;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatMantenimientoEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoDTO.class);
    private String cierreOt;
    private Long compania;
    private Long conductor;
    private Long consecutivo;
    private Long datMantenimientoEquipoId;
    private Date duracion;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCierreOt;
    private Date fechaCreacion;
    private Date fechaEntradaTaller;
    private Date fechaModificacion;
    private Date fechaReaperturaOt;
    private String observacionAnularReg;
    private Long orderTrabajo;
    private String reporteTecnico;
    private Long usuarioDigitacion;
    private Double vidaHoras;
    private Double vidaKm;
    private Long agenteCausadorParadaId_AgenteCausadorParada;
    private Long centCostId_CentCost;
    private Equipo equipoId_Equipo;
    private Long motivosEntradaTallerId_MotivosEntradaTaller;
    private Long planRevisionEquipoId_PlanRevisionEquipo;
    private Long tallerMecanicoId_TallerMecanico;
    private Long tipoMantenimientoId_TipoMantenimiento;
    private Long trabId_Trabajador;
    private Long datSolicitudMttoId;
    private String equipoNombre ;
    private String foto;
    private String requiereParadaFabrica;
    private Long areaTrabajoId_AreaTrabajo;
    private Long nivelPrioridadId_NivelPrioridad;
    private Long tagId_Tag;
    private Long zonasFabricaId_ZonasFabrica;
    
	private String estadoTrue;
	private String estadoTrue2;
	private String tituloCierreOt;
	private String iconCierreOt;
	
	private Double vidaDias;
    
    /** plan revisión det **/
    
    private Double difKm;
    private Double difHrs;
    private Double difDias;
    private Double vidaActual;
    private String nombrePlanRevision;
    private Double vidaPlan;
    private String alerta;
    private Date proximaEjecucion;
    
    private Date fechaSalidaTaller;
    private String origenDatos;
    private String descripcionSolicitud;
    
    private String equipoCodigo;
    private String nombreTipoMantenimiento;
    private Long responsableMttoId;
    
    private String nombreResponsableMtto;
    
    private Double difTiempoMttoAnteriorActual;
    
    private String tipoOrdenMtto;
    
	private String agenteCausadorDescripcion;
	private String tipoFallaDescripcion;
	private String tallerMecanicoDescripcion;
	private Double horOdoSalida;

    
    
    
   
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

	public String getNombreResponsableMtto() {
		return nombreResponsableMtto;
	}

	public void setNombreResponsableMtto(String nombreResponsableMtto) {
		this.nombreResponsableMtto = nombreResponsableMtto;
	}

	public Long getResponsableMttoId() {
		return responsableMttoId;
	}

	public void setResponsableMttoId(Long responsableMttoId) {
		this.responsableMttoId = responsableMttoId;
	}

	public String getNombreTipoMantenimiento() {
		return nombreTipoMantenimiento;
	}

	public void setNombreTipoMantenimiento(String nombreTipoMantenimiento) {
		this.nombreTipoMantenimiento = nombreTipoMantenimiento;
	}

	public String getEquipoCodigo() {
		return equipoCodigo;
	}

	public void setEquipoCodigo(String equipoCodigo) {
		this.equipoCodigo = equipoCodigo;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

   
    public String getCierreOt() {
        return cierreOt;
    }

    public void setCierreOt(String cierreOt) {
        this.cierreOt = cierreOt;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getConductor() {
        return conductor;
    }

    public void setConductor(Long conductor) {
        this.conductor = conductor;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Long getDatMantenimientoEquipoId() {
        return datMantenimientoEquipoId;
    }

    public void setDatMantenimientoEquipoId(Long datMantenimientoEquipoId) {
        this.datMantenimientoEquipoId = datMantenimientoEquipoId;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Date getFechaCierreOt() {
        return fechaCierreOt;
    }

    public void setFechaCierreOt(Date fechaCierreOt) {
        this.fechaCierreOt = fechaCierreOt;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEntradaTaller() {
        return fechaEntradaTaller;
    }

    public void setFechaEntradaTaller(Date fechaEntradaTaller) {
        this.fechaEntradaTaller = fechaEntradaTaller;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaReaperturaOt() {
        return fechaReaperturaOt;
    }

    public void setFechaReaperturaOt(Date fechaReaperturaOt) {
        this.fechaReaperturaOt = fechaReaperturaOt;
    }

    public String getObservacionAnularReg() {
        return observacionAnularReg;
    }

    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }

    public Long getOrderTrabajo() {
        return orderTrabajo;
    }

    public void setOrderTrabajo(Long orderTrabajo) {
        this.orderTrabajo = orderTrabajo;
    }

    public String getReporteTecnico() {
        return reporteTecnico;
    }

    public void setReporteTecnico(String reporteTecnico) {
        this.reporteTecnico = reporteTecnico;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getVidaHoras() {
        return vidaHoras;
    }

    public void setVidaHoras(Double vidaHoras) {
        this.vidaHoras = vidaHoras;
    }

    public Double getVidaKm() {
        return vidaKm;
    }

    public void setVidaKm(Double vidaKm) {
        this.vidaKm = vidaKm;
    }

    public Long getAgenteCausadorParadaId_AgenteCausadorParada() {
        return agenteCausadorParadaId_AgenteCausadorParada;
    }

    public void setAgenteCausadorParadaId_AgenteCausadorParada(
        Long agenteCausadorParadaId_AgenteCausadorParada) {
        this.agenteCausadorParadaId_AgenteCausadorParada = agenteCausadorParadaId_AgenteCausadorParada;
    }

    public Long getCentCostId_CentCost() {
        return centCostId_CentCost;
    }

    public void setCentCostId_CentCost(Long centCostId_CentCost) {
        this.centCostId_CentCost = centCostId_CentCost;
    }

    public Equipo getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Long getMotivosEntradaTallerId_MotivosEntradaTaller() {
        return motivosEntradaTallerId_MotivosEntradaTaller;
    }

    public void setMotivosEntradaTallerId_MotivosEntradaTaller(
        Long motivosEntradaTallerId_MotivosEntradaTaller) {
        this.motivosEntradaTallerId_MotivosEntradaTaller = motivosEntradaTallerId_MotivosEntradaTaller;
    }

    public Long getPlanRevisionEquipoId_PlanRevisionEquipo() {
        return planRevisionEquipoId_PlanRevisionEquipo;
    }

    public void setPlanRevisionEquipoId_PlanRevisionEquipo(
        Long planRevisionEquipoId_PlanRevisionEquipo) {
        this.planRevisionEquipoId_PlanRevisionEquipo = planRevisionEquipoId_PlanRevisionEquipo;
    }

    public Long getTallerMecanicoId_TallerMecanico() {
        return tallerMecanicoId_TallerMecanico;
    }

    public void setTallerMecanicoId_TallerMecanico(
        Long tallerMecanicoId_TallerMecanico) {
        this.tallerMecanicoId_TallerMecanico = tallerMecanicoId_TallerMecanico;
    }

    public Long getTipoMantenimientoId_TipoMantenimiento() {
        return tipoMantenimientoId_TipoMantenimiento;
    }

    public void setTipoMantenimientoId_TipoMantenimiento(
        Long tipoMantenimientoId_TipoMantenimiento) {
        this.tipoMantenimientoId_TipoMantenimiento = tipoMantenimientoId_TipoMantenimiento;
    }

    public Long getTrabId_Trabajador() {
        return trabId_Trabajador;
    }

    public void setTrabId_Trabajador(Long trabId_Trabajador) {
        this.trabId_Trabajador = trabId_Trabajador;
    }

	public String getEquipoNombre() {
		return equipoNombre;
	}

	public void setEquipoNombre(String equipoNombre) {
		this.equipoNombre = equipoNombre;
	}

	public Double getDifKm() {
		return difKm;
	}

	public Double getDifHrs() {
		return difHrs;
	}

	public Double getDifDias() {
		return difDias;
	}

	public Double getVidaActual() {
		return vidaActual;
	}

	public void setDifKm(Double difKm) {
		this.difKm = difKm;
	}

	public void setDifHrs(Double difHrs) {
		this.difHrs = difHrs;
	}

	public void setDifDias(Double difDias) {
		this.difDias = difDias;
	}

	public void setVidaActual(Double vidaActual) {
		this.vidaActual = vidaActual;
	}

	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public String getNombrePlanRevision() {
		return nombrePlanRevision;
	}

	public Double getVidaPlan() {
		return vidaPlan;
	}

	public void setNombrePlanRevision(String nombrePlanRevision) {
		this.nombrePlanRevision = nombrePlanRevision;
	}

	public void setVidaPlan(Double vidaPlan) {
		this.vidaPlan = vidaPlan;
	}

	public Date getProximaEjecucion() {
		return proximaEjecucion;
	}

	public void setProximaEjecucion(Date proximaEjecucion) {
		this.proximaEjecucion = proximaEjecucion;
	}

	public Date getFechaSalidaTaller() {
		return fechaSalidaTaller;
	}

	public void setFechaSalidaTaller(Date fechaSalidaTaller) {
		this.fechaSalidaTaller = fechaSalidaTaller;
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

	public String getRequiereParadaFabrica() {
		return requiereParadaFabrica;
	}

	public void setRequiereParadaFabrica(String requiereParadaFabrica) {
		this.requiereParadaFabrica = requiereParadaFabrica;
	}

	public Long getAreaTrabajoId_AreaTrabajo() {
		return areaTrabajoId_AreaTrabajo;
	}

	public void setAreaTrabajoId_AreaTrabajo(Long areaTrabajoId_AreaTrabajo) {
		this.areaTrabajoId_AreaTrabajo = areaTrabajoId_AreaTrabajo;
	}

	public Long getNivelPrioridadId_NivelPrioridad() {
		return nivelPrioridadId_NivelPrioridad;
	}

	public void setNivelPrioridadId_NivelPrioridad(Long nivelPrioridadId_NivelPrioridad) {
		this.nivelPrioridadId_NivelPrioridad = nivelPrioridadId_NivelPrioridad;
	}

	public Long getTagId_Tag() {
		return tagId_Tag;
	}

	public void setTagId_Tag(Long tagId_Tag) {
		this.tagId_Tag = tagId_Tag;
	}

	public Long getZonasFabricaId_ZonasFabrica() {
		return zonasFabricaId_ZonasFabrica;
	}

	public void setZonasFabricaId_ZonasFabrica(Long zonasFabricaId_ZonasFabrica) {
		this.zonasFabricaId_ZonasFabrica = zonasFabricaId_ZonasFabrica;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public String getEstadoTrue2() {
		return estadoTrue2;
	}

	public void setEstadoTrue2(String estadoTrue2) {
		this.estadoTrue2 = estadoTrue2;
	}

	public String getTituloCierreOt() {
		return tituloCierreOt;
	}

	public void setTituloCierreOt(String tituloCierreOt) {
		this.tituloCierreOt = tituloCierreOt;
	}

	public String getIconCierreOt() {
		return iconCierreOt;
	}

	public void setIconCierreOt(String iconCierreOt) {
		this.iconCierreOt = iconCierreOt;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public Double getVidaDias() {
		return vidaDias;
	}

	public void setVidaDias(Double vidaDias) {
		this.vidaDias = vidaDias;
	}
	
	
	
	
	

}
