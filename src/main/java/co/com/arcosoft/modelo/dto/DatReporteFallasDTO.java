package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatReporteFallasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatReporteFallasDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datReporteFallasId;
    private String descripcionFalla;
    private String esParada;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Date horaFinalParada;
    private Date horaInicialParada;
    private Double horometroActual;
    private Long medidorId;
    private String observacionAnularReg;
    private String origenDatos;
    private Long supervisorId;
    private Long trabId;
    private Long usuarioDigitacion;
    private Long agenteCausadorParadaId_AgenteCausadorParada;
    private Long equipoId_Equipo;
    private Long motivosEntradaTallerId_MotivosEntradaTaller;
    private Long tagId_Tag;
    private Double odometroActual;
    private String equipoNombre;
    private String tagNombre;
    
    
    
    /**
	 * @return the tagNombre
	 */
	public String getTagNombre() {
		return tagNombre;
	}

	/**
	 * @param tagNombre the tagNombre to set
	 */
	public void setTagNombre(String tagNombre) {
		this.tagNombre = tagNombre;
	}

	public String getEquipoNombre() {
		return equipoNombre;
	}

	public void setEquipoNombre(String equipoNombre) {
		this.equipoNombre = equipoNombre;
	}

	public Double getOdometroActual() {
		return odometroActual;
	}

	public void setOdometroActual(Double odometroActual) {
		this.odometroActual = odometroActual;
	}

	public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Long getDatReporteFallasId() {
        return datReporteFallasId;
    }

    public void setDatReporteFallasId(Long datReporteFallasId) {
        this.datReporteFallasId = datReporteFallasId;
    }

    public String getDescripcionFalla() {
        return descripcionFalla;
    }

    public void setDescripcionFalla(String descripcionFalla) {
        this.descripcionFalla = descripcionFalla;
    }

    public String getEsParada() {
        return esParada;
    }

    public void setEsParada(String esParada) {
        this.esParada = esParada;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getHoraFinalParada() {
        return horaFinalParada;
    }

    public void setHoraFinalParada(Date horaFinalParada) {
        this.horaFinalParada = horaFinalParada;
    }

    public Date getHoraInicialParada() {
        return horaInicialParada;
    }

    public void setHoraInicialParada(Date horaInicialParada) {
        this.horaInicialParada = horaInicialParada;
    }

    public Double getHorometroActual() {
        return horometroActual;
    }

    public void setHorometroActual(Double horometroActual) {
        this.horometroActual = horometroActual;
    }

    public Long getMedidorId() {
        return medidorId;
    }

    public void setMedidorId(Long medidorId) {
        this.medidorId = medidorId;
    }

    public String getObservacionAnularReg() {
        return observacionAnularReg;
    }

    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }

    public String getOrigenDatos() {
        return origenDatos;
    }

    public void setOrigenDatos(String origenDatos) {
        this.origenDatos = origenDatos;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getTrabId() {
        return trabId;
    }

    public void setTrabId(Long trabId) {
        this.trabId = trabId;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Long getAgenteCausadorParadaId_AgenteCausadorParada() {
        return agenteCausadorParadaId_AgenteCausadorParada;
    }

    public void setAgenteCausadorParadaId_AgenteCausadorParada(
        Long agenteCausadorParadaId_AgenteCausadorParada) {
        this.agenteCausadorParadaId_AgenteCausadorParada = agenteCausadorParadaId_AgenteCausadorParada;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Long getMotivosEntradaTallerId_MotivosEntradaTaller() {
        return motivosEntradaTallerId_MotivosEntradaTaller;
    }

    public void setMotivosEntradaTallerId_MotivosEntradaTaller(
        Long motivosEntradaTallerId_MotivosEntradaTaller) {
        this.motivosEntradaTallerId_MotivosEntradaTaller = motivosEntradaTallerId_MotivosEntradaTaller;
    }

    public Long getTagId_Tag() {
        return tagId_Tag;
    }

    public void setTagId_Tag(Long tagId_Tag) {
        this.tagId_Tag = tagId_Tag;
    }
}
