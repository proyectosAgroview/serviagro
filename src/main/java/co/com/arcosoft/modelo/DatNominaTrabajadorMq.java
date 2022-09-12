package co.com.arcosoft.modelo;
// Generated 12-jul-2018 7:59:19 by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatNominaTrabajadorMq generated by hbm2java
 */
public class DatNominaTrabajadorMq  implements java.io.Serializable {


     private Long datNominaTrabajadorMqId;
     private Date fechaInicial;
     private Date fechaFinal;
     private Long consecutivo;
     private Long compania;
     private String observacion;
     private Long usuarioDigitacion;
     private String infoAdicional;
     private String infoAdicional2;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estado;
     private String observacionAnularReg;
     private Date fechaAnulacion;
     private Set<DatNominaTrabajadorMqdet> datNominaTrabajadorMqdets = new HashSet<DatNominaTrabajadorMqdet>(0);
     private String tipoNomina;
     private String estadoNomina;
    public DatNominaTrabajadorMq() {
    }

    public DatNominaTrabajadorMq(Date fechaInicial, Date fechaFinal, Long consecutivo, Long compania, String observacion, Long usuarioDigitacion, 
    		String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, String observacionAnularReg, 
    		Date fechaAnulacion, Set<DatNominaTrabajadorMqdet> datNominaTrabajadorMqdets, String tipoNomina, String estadoNomina) {
       this.fechaInicial = fechaInicial;
       this.fechaFinal = fechaFinal;
       this.consecutivo = consecutivo;
       this.compania = compania;
       this.observacion = observacion;
       this.usuarioDigitacion = usuarioDigitacion;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estado = estado;
       this.observacionAnularReg = observacionAnularReg;
       this.fechaAnulacion = fechaAnulacion;
       this.datNominaTrabajadorMqdets = datNominaTrabajadorMqdets;
       this.tipoNomina=tipoNomina;
       this.estadoNomina=estadoNomina;
    }
   
    
    public String getEstadoNomina() {
		return estadoNomina;
	}

	public void setEstadoNomina(String estadoNomina) {
		this.estadoNomina = estadoNomina;
	}

	public String getTipoNomina() {
		return tipoNomina;
	}

	public void setTipoNomina(String tipoNomina) {
		this.tipoNomina = tipoNomina;
	}

	public Long getDatNominaTrabajadorMqId() {
        return this.datNominaTrabajadorMqId;
    }
    
    public void setDatNominaTrabajadorMqId(Long datNominaTrabajadorMqId) {
        this.datNominaTrabajadorMqId = datNominaTrabajadorMqId;
    }
    public Date getFechaInicial() {
        return this.fechaInicial;
    }
    
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }
    public Date getFechaFinal() {
        return this.fechaFinal;
    }
    
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public Long getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Long getUsuarioDigitacion() {
        return this.usuarioDigitacion;
    }
    
    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }
    public String getInfoAdicional() {
        return this.infoAdicional;
    }
    
    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
    public String getInfoAdicional2() {
        return this.infoAdicional2;
    }
    
    public void setInfoAdicional2(String infoAdicional2) {
        this.infoAdicional2 = infoAdicional2;
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
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
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
    public Set<DatNominaTrabajadorMqdet> getDatNominaTrabajadorMqdets() {
        return this.datNominaTrabajadorMqdets;
    }
    
    public void setDatNominaTrabajadorMqdets(Set<DatNominaTrabajadorMqdet> datNominaTrabajadorMqdets) {
        this.datNominaTrabajadorMqdets = datNominaTrabajadorMqdets;
    }




}


