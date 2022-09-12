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
public class DatHorasTrabajoEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatHorasTrabajoEquipoDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datHorasTrabajoEquipoId;
    private Double diaActual;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Double horasActual;
    private Double kmActual;
    private Double medidor;
    private String observacion;
    private String observacionAnularReg;
    private String origenDatos;
    private Long usuarioDigitacion;
    private Long equipoId_Equipo;
    private String nombreEquipo;
    private String estadoMaquina;

    public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
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

    public Long getDatHorasTrabajoEquipoId() {
        return datHorasTrabajoEquipoId;
    }

    public void setDatHorasTrabajoEquipoId(Long datHorasTrabajoEquipoId) {
        this.datHorasTrabajoEquipoId = datHorasTrabajoEquipoId;
    }

    public Double getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(Double diaActual) {
        this.diaActual = diaActual;
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

    public Double getHorasActual() {
        return horasActual;
    }

    public void setHorasActual(Double horasActual) {
        this.horasActual = horasActual;
    }

    public Double getKmActual() {
        return kmActual;
    }

    public void setKmActual(Double kmActual) {
        this.kmActual = kmActual;
    }

    public Double getMedidor() {
        return medidor;
    }

    public void setMedidor(Double medidor) {
        this.medidor = medidor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

	public String getEstadoMaquina() {
		return estadoMaquina;
	}

	public void setEstadoMaquina(String estadoMaquina) {
		this.estadoMaquina = estadoMaquina;
	}
}
