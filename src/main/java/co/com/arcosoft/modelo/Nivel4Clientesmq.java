package co.com.arcosoft.modelo;
// Generated 10-ago-2018 0:43:32 by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * Nivel4Clientesmq generated by hbm2java
 */
public class Nivel4Clientesmq  implements java.io.Serializable {


     private Long nivel4ClientesmqId;
     private Nivel2Clientesmq nivel2Clientesmq;
     private String codigo;
     private Double areaNeta;
     private Long compania;
     private String nombre;
     private String infoAdicional;
     private String infoAdicional2;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estado;
     private String codigoAlternativo;
     private Double numeroPlantas;

    public Nivel4Clientesmq() {
    }

    public Nivel4Clientesmq(Nivel2Clientesmq nivel2Clientesmq, String codigo, Double areaNeta, Long compania, String nombre, String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, String codigoAlternativo, Double numeroPlantas) {
       this.nivel2Clientesmq = nivel2Clientesmq;
       this.codigo = codigo;
       this.areaNeta = areaNeta;
       this.compania = compania;
       this.nombre = nombre;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estado = estado;
       this.codigoAlternativo = codigoAlternativo;
       this.numeroPlantas = numeroPlantas;
    }
   
    public Long getNivel4ClientesmqId() {
        return this.nivel4ClientesmqId;
    }
    
    public void setNivel4ClientesmqId(Long nivel4ClientesmqId) {
        this.nivel4ClientesmqId = nivel4ClientesmqId;
    }
    public Nivel2Clientesmq getNivel2Clientesmq() {
        return this.nivel2Clientesmq;
    }
    
    public void setNivel2Clientesmq(Nivel2Clientesmq nivel2Clientesmq) {
        this.nivel2Clientesmq = nivel2Clientesmq;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Double getAreaNeta() {
        return this.areaNeta;
    }
    
    public void setAreaNeta(Double areaNeta) {
        this.areaNeta = areaNeta;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public String getCodigoAlternativo() {
        return this.codigoAlternativo;
    }
    
    public void setCodigoAlternativo(String codigoAlternativo) {
        this.codigoAlternativo = codigoAlternativo;
    }
    public Double getNumeroPlantas() {
        return this.numeroPlantas;
    }
    
    public void setNumeroPlantas(Double numeroPlantas) {
        this.numeroPlantas = numeroPlantas;
    }




}


