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
public class DatCheckListEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatCheckListEquipoDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datCheckListEquipoId;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String observacion;
    private String origenDatos;
    private Long supervisorId;
    private Long usuarioDigitacion;
    private Long planRevisionEquipoId_PlanRevisionEquipo;

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

    public Long getDatCheckListEquipoId() {
        return datCheckListEquipoId;
    }

    public void setDatCheckListEquipoId(Long datCheckListEquipoId) {
        this.datCheckListEquipoId = datCheckListEquipoId;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getOrigenDatos() {
        return origenDatos;
    }

    public void setOrigenDatos(String origenDatos) {
        this.origenDatos = origenDatos;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Long getPlanRevisionEquipoId_PlanRevisionEquipo() {
        return planRevisionEquipoId_PlanRevisionEquipo;
    }

    public void setPlanRevisionEquipoId_PlanRevisionEquipo(
        Long planRevisionEquipoId_PlanRevisionEquipo) {
        this.planRevisionEquipoId_PlanRevisionEquipo = planRevisionEquipoId_PlanRevisionEquipo;
    }
}
