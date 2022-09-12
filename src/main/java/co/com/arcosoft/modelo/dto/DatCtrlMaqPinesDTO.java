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
public class DatCtrlMaqPinesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatCtrlMaqPinesDTO.class);
    private Long boletaFinal;
    private Long boletaInicial;
    private Long compania;
    private Long consecutivoPin;
    private Long datCtrlMaqPinesId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String observacion;
    private String observacionAnularReg;
    private Double ultHoroOdoMetro;
    private Long usuarioDigitacion;
    private Long equipoId_Equipo;
    private String codigoEquipo;
    
    private Long indicador_vuelta_medidor;
    private Double ultHorometroTanqueo;
    
    

    public Double getUltHorometroTanqueo() {
		return ultHorometroTanqueo;
	}

	public void setUltHorometroTanqueo(Double ultHorometroTanqueo) {
		this.ultHorometroTanqueo = ultHorometroTanqueo;
	}

	public Long getIndicador_vuelta_medidor() {
		return indicador_vuelta_medidor;
	}

	public void setIndicador_vuelta_medidor(Long indicador_vuelta_medidor) {
		this.indicador_vuelta_medidor = indicador_vuelta_medidor;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public Long getBoletaFinal() {
        return boletaFinal;
    }

    public void setBoletaFinal(Long boletaFinal) {
        this.boletaFinal = boletaFinal;
    }

    public Long getBoletaInicial() {
        return boletaInicial;
    }

    public void setBoletaInicial(Long boletaInicial) {
        this.boletaInicial = boletaInicial;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getConsecutivoPin() {
        return consecutivoPin;
    }

    public void setConsecutivoPin(Long consecutivoPin) {
        this.consecutivoPin = consecutivoPin;
    }

    public Long getDatCtrlMaqPinesId() {
        return datCtrlMaqPinesId;
    }

    public void setDatCtrlMaqPinesId(Long datCtrlMaqPinesId) {
        this.datCtrlMaqPinesId = datCtrlMaqPinesId;
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

    public Double getUltHoroOdoMetro() {
        return ultHoroOdoMetro;
    }

    public void setUltHoroOdoMetro(Double ultHoroOdoMetro) {
        this.ultHoroOdoMetro = ultHoroOdoMetro;
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
}
