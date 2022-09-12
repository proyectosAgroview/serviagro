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
public class Nivel4ClientesmqDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Nivel4ClientesmqDTO.class);
    private Double areaNeta;
    private String codigo;
    private String codigoAlternativo;
    private Long compania;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String infoAdicional;
    private String infoAdicional2;
    private Long nivel4ClientesmqId;
    private String nombre;
    private Double numeroPlantas;
    private Long nivel2ClientesmqId_Nivel2Clientesmq;
    private String nombreHacienda;
    
    public String getNombreHacienda() {
		return nombreHacienda;
	}

	public void setNombreHacienda(String nombreHacienda) {
		this.nombreHacienda = nombreHacienda;
	}

	public Double getAreaNeta() {
        return areaNeta;
    }

    public void setAreaNeta(Double areaNeta) {
        this.areaNeta = areaNeta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAlternativo() {
        return codigoAlternativo;
    }

    public void setCodigoAlternativo(String codigoAlternativo) {
        this.codigoAlternativo = codigoAlternativo;
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

    public Long getNivel4ClientesmqId() {
        return nivel4ClientesmqId;
    }

    public void setNivel4ClientesmqId(Long nivel4ClientesmqId) {
        this.nivel4ClientesmqId = nivel4ClientesmqId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNumeroPlantas() {
        return numeroPlantas;
    }

    public void setNumeroPlantas(Double numeroPlantas) {
        this.numeroPlantas = numeroPlantas;
    }

    public Long getNivel2ClientesmqId_Nivel2Clientesmq() {
        return nivel2ClientesmqId_Nivel2Clientesmq;
    }

    public void setNivel2ClientesmqId_Nivel2Clientesmq(
        Long nivel2ClientesmqId_Nivel2Clientesmq) {
        this.nivel2ClientesmqId_Nivel2Clientesmq = nivel2ClientesmqId_Nivel2Clientesmq;
    }
}
