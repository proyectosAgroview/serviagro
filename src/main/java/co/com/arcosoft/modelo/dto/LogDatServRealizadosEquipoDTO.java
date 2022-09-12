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
public class LogDatServRealizadosEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LogDatServRealizadosEquipoDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datServRealizadosEquipoId;
    private Date fecha;
    private Long logDatServRealizadosEquipoId;
    private String observacion;
    private Long usuarioModificacion;
    private Long equipoId;
    private String codEquipo;
    
    
    public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
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

    public Long getDatServRealizadosEquipoId() {
        return datServRealizadosEquipoId;
    }

    public void setDatServRealizadosEquipoId(Long datServRealizadosEquipoId) {
        this.datServRealizadosEquipoId = datServRealizadosEquipoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getLogDatServRealizadosEquipoId() {
        return logDatServRealizadosEquipoId;
    }

    public void setLogDatServRealizadosEquipoId(
        Long logDatServRealizadosEquipoId) {
        this.logDatServRealizadosEquipoId = logDatServRealizadosEquipoId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
