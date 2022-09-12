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
public class DatCheckListEquipoDetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatCheckListEquipoDetDTO.class);
    private Long datCheckListEquipoDetId;
    private Double diasHoy;
    private Double horasHoy;
    private Double kmHoy;
    private Long compartimientosEquipoId_CompartimientosEquipo;
    private Long datCheckListEquipoId_DatCheckListEquipo;
    private Long equipoId_Equipo;
    private Long sistemasEquipoId_SistemasEquipo;
    
    private String nombreEquipo;
    private String nombreCompartimiento;
    private String nombreSistema;

    public Long getDatCheckListEquipoDetId() {
        return datCheckListEquipoDetId;
    }

    public void setDatCheckListEquipoDetId(Long datCheckListEquipoDetId) {
        this.datCheckListEquipoDetId = datCheckListEquipoDetId;
    }

    public Double getDiasHoy() {
        return diasHoy;
    }

    public void setDiasHoy(Double diasHoy) {
        this.diasHoy = diasHoy;
    }

    public Double getHorasHoy() {
        return horasHoy;
    }

    public void setHorasHoy(Double horasHoy) {
        this.horasHoy = horasHoy;
    }

    public Double getKmHoy() {
        return kmHoy;
    }

    public void setKmHoy(Double kmHoy) {
        this.kmHoy = kmHoy;
    }

    public Long getCompartimientosEquipoId_CompartimientosEquipo() {
        return compartimientosEquipoId_CompartimientosEquipo;
    }

    public void setCompartimientosEquipoId_CompartimientosEquipo(
        Long compartimientosEquipoId_CompartimientosEquipo) {
        this.compartimientosEquipoId_CompartimientosEquipo = compartimientosEquipoId_CompartimientosEquipo;
    }

    public Long getDatCheckListEquipoId_DatCheckListEquipo() {
        return datCheckListEquipoId_DatCheckListEquipo;
    }

    public void setDatCheckListEquipoId_DatCheckListEquipo(
        Long datCheckListEquipoId_DatCheckListEquipo) {
        this.datCheckListEquipoId_DatCheckListEquipo = datCheckListEquipoId_DatCheckListEquipo;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Long getSistemasEquipoId_SistemasEquipo() {
        return sistemasEquipoId_SistemasEquipo;
    }

    public void setSistemasEquipoId_SistemasEquipo(
        Long sistemasEquipoId_SistemasEquipo) {
        this.sistemasEquipoId_SistemasEquipo = sistemasEquipoId_SistemasEquipo;
    }

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNombreCompartimiento() {
		return nombreCompartimiento;
	}

	public void setNombreCompartimiento(String nombreCompartimiento) {
		this.nombreCompartimiento = nombreCompartimiento;
	}

	public String getNombreSistema() {
		return nombreSistema;
	}

	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}
}
