package co.com.arcosoft.modelo;
// Generated 08-may-2018 0:04:52 by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * LogBascula generated by hbm2java
 */
public class LogBascula  implements java.io.Serializable {


     private Long logBasculaId;
     private Long tiquete;
     public Long compania;
     private Long usuarioModificacion;
     private String observacion;
     private Date fecha;

    public LogBascula() {
    }

    public LogBascula(Long tiquete, Long compania, Long usuarioModificacion, String observacion, Date fecha) {
       this.tiquete = tiquete;
       this.compania = compania;
       this.usuarioModificacion = usuarioModificacion;
       this.observacion = observacion;
       this.fecha = fecha;
    }
   
    public Long getLogBasculaId() {
        return this.logBasculaId;
    }
    
    public void setLogBasculaId(Long logBasculaId) {
        this.logBasculaId = logBasculaId;
    }
    public Long getTiquete() {
        return this.tiquete;
    }
    
    public void setTiquete(Long tiquete) {
        this.tiquete = tiquete;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
    }
    public Long getUsuarioModificacion() {
        return this.usuarioModificacion;
    }
    
    public void setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


