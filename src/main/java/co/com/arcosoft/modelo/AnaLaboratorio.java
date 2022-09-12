package co.com.arcosoft.modelo;
// Generated 13-abr-2018 9:41:11 by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AnaLaboratorio generated by hbm2java
 */
public class AnaLaboratorio  implements java.io.Serializable {


     private Long anaLabId;
     private String codigo;
     private String nombre;
     private Long compania;
     private String infoAdicional;
     private String infoAdicional2;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estado;
     private String tipoAnalisis;
     private String frecuenciaDigitacion;
     private Date horaInicialDigitacion;
     private Set<DatAnaLaboratorio> datAnaLaboratorios = new HashSet<DatAnaLaboratorio>(0);
     private Set<AnaLaboratorioVariable> anaLaboratorioVariables = new HashSet<AnaLaboratorioVariable>(0);

    public AnaLaboratorio() {
    }

    public AnaLaboratorio(String codigo, String nombre, Long compania, String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, String tipoAnalisis, String frecuenciaDigitacion, Date horaInicialDigitacion, Set<DatAnaLaboratorio> datAnaLaboratorios, Set<AnaLaboratorioVariable> anaLaboratorioVariables) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.compania = compania;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estado = estado;
       this.tipoAnalisis = tipoAnalisis;
       this.frecuenciaDigitacion = frecuenciaDigitacion;
       this.horaInicialDigitacion = horaInicialDigitacion;
       this.datAnaLaboratorios = datAnaLaboratorios;
       this.anaLaboratorioVariables = anaLaboratorioVariables;
    }
   
    public Long getAnaLabId() {
        return this.anaLabId;
    }
    
    public void setAnaLabId(Long anaLabId) {
        this.anaLabId = anaLabId;
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
    public String getTipoAnalisis() {
        return this.tipoAnalisis;
    }
    
    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }
    public String getFrecuenciaDigitacion() {
        return this.frecuenciaDigitacion;
    }
    
    public void setFrecuenciaDigitacion(String frecuenciaDigitacion) {
        this.frecuenciaDigitacion = frecuenciaDigitacion;
    }
    public Date getHoraInicialDigitacion() {
        return this.horaInicialDigitacion;
    }
    
    public void setHoraInicialDigitacion(Date horaInicialDigitacion) {
        this.horaInicialDigitacion = horaInicialDigitacion;
    }
    public Set<DatAnaLaboratorio> getDatAnaLaboratorios() {
        return this.datAnaLaboratorios;
    }
    
    public void setDatAnaLaboratorios(Set<DatAnaLaboratorio> datAnaLaboratorios) {
        this.datAnaLaboratorios = datAnaLaboratorios;
    }
    public Set<AnaLaboratorioVariable> getAnaLaboratorioVariables() {
        return this.anaLaboratorioVariables;
    }
    
    public void setAnaLaboratorioVariables(Set<AnaLaboratorioVariable> anaLaboratorioVariables) {
        this.anaLaboratorioVariables = anaLaboratorioVariables;
    }




}

