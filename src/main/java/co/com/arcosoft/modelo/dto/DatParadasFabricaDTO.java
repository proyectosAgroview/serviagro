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
public class DatParadasFabricaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatParadasFabricaDTO.class);
    private Long agenteCausadorParadaId;
    private Long areaTrabajoId;
    private Long compania;
    private Long consecutivo;
    private Long datParadasFabricaId;
    private String descripcionParada;
    private Long equipoId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechapFinal;
    private Date fechapInicial;
    private Date horapFinal;
    private Date horapInicial;
    private Long motivosParadaId;
    private String observacionAnularReg;
    private String observaciones;
    private String paradaCritica;
    private Long tagId;
    private Long usuarioDigitacion;
    private String nombreEquipo;
    private String  nombreTag;
    private String nombreAreaTrabajo;
    private String nombreAgente;
    private String nombreMotivoParada;
    
    
    
    /**
	 * @return the nombreEquipo
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * @param nombreEquipo the nombreEquipo to set
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * @return the nombreTag
	 */
	public String getNombreTag() {
		return nombreTag;
	}

	/**
	 * @param nombreTag the nombreTag to set
	 */
	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

	/**
	 * @return the nombreAreaTrabajo
	 */
	public String getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}

	/**
	 * @param nombreAreaTrabajo the nombreAreaTrabajo to set
	 */
	public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}

	/**
	 * @return the nombreAgente
	 */
	public String getNombreAgente() {
		return nombreAgente;
	}

	/**
	 * @param nombreAgente the nombreAgente to set
	 */
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	/**
	 * @return the nombreMotivoParada
	 */
	public String getNombreMotivoParada() {
		return nombreMotivoParada;
	}

	/**
	 * @param nombreMotivoParada the nombreMotivoParada to set
	 */
	public void setNombreMotivoParada(String nombreMotivoParada) {
		this.nombreMotivoParada = nombreMotivoParada;
	}

	/**
	 * @return the usuarioDigitacion
	 */
	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	/**
	 * @param usuarioDigitacion the usuarioDigitacion to set
	 */
	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getAgenteCausadorParadaId() {
        return agenteCausadorParadaId;
    }

    public void setAgenteCausadorParadaId(Long agenteCausadorParadaId) {
        this.agenteCausadorParadaId = agenteCausadorParadaId;
    }

    public Long getAreaTrabajoId() {
        return areaTrabajoId;
    }

    public void setAreaTrabajoId(Long areaTrabajoId) {
        this.areaTrabajoId = areaTrabajoId;
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

    public Long getDatParadasFabricaId() {
        return datParadasFabricaId;
    }

    public void setDatParadasFabricaId(Long datParadasFabricaId) {
        this.datParadasFabricaId = datParadasFabricaId;
    }

    public String getDescripcionParada() {
        return descripcionParada;
    }

    public void setDescripcionParada(String descripcionParada) {
        this.descripcionParada = descripcionParada;
    }

    public Long getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Long equipoId) {
        this.equipoId = equipoId;
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

    public Date getFechapFinal() {
        return fechapFinal;
    }

    public void setFechapFinal(Date fechapFinal) {
        this.fechapFinal = fechapFinal;
    }

    public Date getFechapInicial() {
        return fechapInicial;
    }

    public void setFechapInicial(Date fechapInicial) {
        this.fechapInicial = fechapInicial;
    }

    public Date getHorapFinal() {
        return horapFinal;
    }

    public void setHorapFinal(Date horapFinal) {
        this.horapFinal = horapFinal;
    }

    public Date getHorapInicial() {
        return horapInicial;
    }

    public void setHorapInicial(Date horapInicial) {
        this.horapInicial = horapInicial;
    }

    public Long getMotivosParadaId() {
        return motivosParadaId;
    }

    public void setMotivosParadaId(Long motivosParadaId) {
        this.motivosParadaId = motivosParadaId;
    }

    public String getObservacionAnularReg() {
        return observacionAnularReg;
    }

    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getParadaCritica() {
        return paradaCritica;
    }

    public void setParadaCritica(String paradaCritica) {
        this.paradaCritica = paradaCritica;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
