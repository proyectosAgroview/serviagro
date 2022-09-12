package co.com.arcosoft.modelo;
// Generated 6/07/2020 04:39:37 PM by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * TipoCotizante generated by hbm2java
 */
public class TipoCotizante  implements java.io.Serializable {


     private Long tipoCotizanteId;
     private String codigo;
     private String nombre;
     private Long compania;
     private String claseCotizante;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String infoAdicional;
     private String infoAdicional2;
     private String estado;

    public TipoCotizante() {
    }

    public TipoCotizante(String codigo, String nombre, Long compania, String claseCotizante, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String estado) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.compania = compania;
       this.claseCotizante = claseCotizante;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.estado = estado;
    }
   
    public Long getTipoCotizanteId() {
        return this.tipoCotizanteId;
    }
    
    public void setTipoCotizanteId(Long tipoCotizanteId) {
        this.tipoCotizanteId = tipoCotizanteId;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
    }
    public String getClaseCotizante() {
        return this.claseCotizante;
    }
    
    public void setClaseCotizante(String claseCotizante) {
        this.claseCotizante = claseCotizante;
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
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


