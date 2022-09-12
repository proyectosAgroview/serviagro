package co.com.arcosoft.modelo;
// Generated 20/08/2020 06:51:26 PM by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * TarifasArl generated by hbm2java
 */
public class TarifasArl  implements java.io.Serializable {


     private Long tarifasArlId;
     private String codigo;
     private String nombre;
     private Double porcentaje;
     private String numeroRiesgo;
     private Long compania;
     private String infoAdicional;
     private String infoAdicional2;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estado;

    public TarifasArl() {
    }

    public TarifasArl(String codigo, String nombre, Double porcentaje, String numeroRiesgo, Long compania, String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.porcentaje = porcentaje;
       this.numeroRiesgo = numeroRiesgo;
       this.compania = compania;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estado = estado;
    }
   
    public Long getTarifasArlId() {
        return this.tarifasArlId;
    }
    
    public void setTarifasArlId(Long tarifasArlId) {
        this.tarifasArlId = tarifasArlId;
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
    public Double getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getNumeroRiesgo() {
        return this.numeroRiesgo;
    }
    
    public void setNumeroRiesgo(String numeroRiesgo) {
        this.numeroRiesgo = numeroRiesgo;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
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




}


