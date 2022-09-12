package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class PuntosLubricacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PuntosLubricacionDTO.class);
    private Long codigo;
    private Long compania;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String infoAdicional1;
    private String infoAdicional2;
    private String nombre;
    private Long puntoLubricacionId;
    private String estado;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
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

    public String getInfoAdicional1() {
        return infoAdicional1;
    }

    public void setInfoAdicional1(String infoAdicional1) {
        this.infoAdicional1 = infoAdicional1;
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

    public Long getPuntoLubricacionId() {
        return puntoLubricacionId;
    }

    public void setPuntoLubricacionId(Long puntoLubricacionId) {
        this.puntoLubricacionId = puntoLubricacionId;
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
