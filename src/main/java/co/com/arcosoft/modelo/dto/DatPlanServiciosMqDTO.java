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
public class DatPlanServiciosMqDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqDTO.class);
    private Integer NPases;
    private Integer anio;
    private String cierreOt;
    private Long compania;
    private Long consecutivo;
    private Double costoTotalEstimado;
    private Long datPlanServiciosMqId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCierreOt;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaReaperturaOt;
    private String idMobile;
    private String infoAdicional;
    private String infoAdicional2;
    private Double latitud;
    private Double longitud;
    private String nivelAutorizacion1;
    private String nivelAutorizacion2;
    private String observacion;
    private String observacionAnularReg;
    private Date periodoFinal;
    private Date periodoInicial;
    private Double precision1;
    private Long usuarioDigitacion;
    private Long trabId_Trabajador;
    private Long zonaGeograficaId_ZonaGeografica;
    private String codigoSupervisor;
    private String nombreSupervisor;
    private String nombreZona;
    
    private Long persEmpr;
    private Long nivel2Clientesmq;
   
    private String nombreCliente;
    private String nombreHacienda;
   

 private String tipoProyecto;
 
 
 
    
    public String getTipoProyecto() {
	return tipoProyecto;
}

public void setTipoProyecto(String tipoProyecto) {
	this.tipoProyecto = tipoProyecto;
}

	public Long getPersEmpr() {
		return persEmpr;
	}

	public void setPersEmpr(Long persEmpr) {
		this.persEmpr = persEmpr;
	}

	public Long getNivel2Clientesmq() {
		return nivel2Clientesmq;
	}

	public void setNivel2Clientesmq(Long nivel2Clientesmq) {
		this.nivel2Clientesmq = nivel2Clientesmq;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreHacienda() {
		return nombreHacienda;
	}

	public void setNombreHacienda(String nombreHacienda) {
		this.nombreHacienda = nombreHacienda;
	}

	public String getCodigoSupervisor() {
		return codigoSupervisor;
	}

	public void setCodigoSupervisor(String codigoSupervisor) {
		this.codigoSupervisor = codigoSupervisor;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public Integer getNPases() {
        return NPases;
    }

    public void setNPases(Integer NPases) {
        this.NPases = NPases;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
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

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Double getCostoTotalEstimado() {
        return costoTotalEstimado;
    }

    public void setCostoTotalEstimado(Double costoTotalEstimado) {
        this.costoTotalEstimado = costoTotalEstimado;
    }

    public Long getDatPlanServiciosMqId() {
        return datPlanServiciosMqId;
    }

    public void setDatPlanServiciosMqId(Long datPlanServiciosMqId) {
        this.datPlanServiciosMqId = datPlanServiciosMqId;
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

    public String getIdMobile() {
        return idMobile;
    }

    public void setIdMobile(String idMobile) {
        this.idMobile = idMobile;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getInfoAdicional2() {
        return infoAdicional2;
    }

    public void setInfoAdicional2(String infoAdicional2) {
        this.infoAdicional2 = infoAdicional2;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getNivelAutorizacion1() {
        return nivelAutorizacion1;
    }

    public void setNivelAutorizacion1(String nivelAutorizacion1) {
        this.nivelAutorizacion1 = nivelAutorizacion1;
    }

    public String getNivelAutorizacion2() {
        return nivelAutorizacion2;
    }

    public void setNivelAutorizacion2(String nivelAutorizacion2) {
        this.nivelAutorizacion2 = nivelAutorizacion2;
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

    public Date getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Date getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Date periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public Double getPrecision1() {
        return precision1;
    }

    public void setPrecision1(Double precision1) {
        this.precision1 = precision1;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Long getTrabId_Trabajador() {
        return trabId_Trabajador;
    }

    public void setTrabId_Trabajador(Long trabId_Trabajador) {
        this.trabId_Trabajador = trabId_Trabajador;
    }

    public Long getZonaGeograficaId_ZonaGeografica() {
        return zonaGeograficaId_ZonaGeografica;
    }

    public void setZonaGeograficaId_ZonaGeografica(
        Long zonaGeograficaId_ZonaGeografica) {
        this.zonaGeograficaId_ZonaGeografica = zonaGeograficaId_ZonaGeografica;
    }
}
