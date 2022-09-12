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
public class AnaLaboratorioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AnaLaboratorioDTO.class);
    private Long anaLabId;
    private String codigo;
    private Long compania;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String frecuenciaDigitacion;
    private Date horaInicialDigitacion;
    private String infoAdicional;
    private String infoAdicional2;
    private String nombre;
    private String tipoAnalisis;

    public Long getAnaLabId() {
        return anaLabId;
    }

    public void setAnaLabId(Long anaLabId) {
        this.anaLabId = anaLabId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getFrecuenciaDigitacion() {
        return frecuenciaDigitacion;
    }

    public void setFrecuenciaDigitacion(String frecuenciaDigitacion) {
        this.frecuenciaDigitacion = frecuenciaDigitacion;
    }

    public Date getHoraInicialDigitacion() {
        return horaInicialDigitacion;
    }

    public void setHoraInicialDigitacion(Date horaInicialDigitacion) {
        this.horaInicialDigitacion = horaInicialDigitacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }
}
