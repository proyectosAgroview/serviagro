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
public class DatCheckListEquipoLaborDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatCheckListEquipoLaborDTO.class);
    private Long datCheckListEquipoLaborId;
    private String observacion;
    private String resultado;
    private Long datCheckListEquipoDetId_DatCheckListEquipoDet;
    private Long laborId_Labor;
    
    private String nombreLabor;

    public Long getDatCheckListEquipoLaborId() {
        return datCheckListEquipoLaborId;
    }

    public void setDatCheckListEquipoLaborId(Long datCheckListEquipoLaborId) {
        this.datCheckListEquipoLaborId = datCheckListEquipoLaborId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Long getDatCheckListEquipoDetId_DatCheckListEquipoDet() {
        return datCheckListEquipoDetId_DatCheckListEquipoDet;
    }

    public void setDatCheckListEquipoDetId_DatCheckListEquipoDet(
        Long datCheckListEquipoDetId_DatCheckListEquipoDet) {
        this.datCheckListEquipoDetId_DatCheckListEquipoDet = datCheckListEquipoDetId_DatCheckListEquipoDet;
    }

    public Long getLaborId_Labor() {
        return laborId_Labor;
    }

    public void setLaborId_Labor(Long laborId_Labor) {
        this.laborId_Labor = laborId_Labor;
    }

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}
}
