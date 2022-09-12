package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Equipo;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatOtrosCostosMqdetDistribuccionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosMqdetDistribuccionDTO.class);
    private Long datOtrosCostosMqdetDistrId;
    private Long datOtrosCostosMqId_DatOtrosCostosMq;
    private Equipo equipoId_Equipo;
    private String codigoEquipo;
    
    

    public Equipo getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public Long getDatOtrosCostosMqdetDistrId() {
        return datOtrosCostosMqdetDistrId;
    }

    public void setDatOtrosCostosMqdetDistrId(Long datOtrosCostosMqdetDistrId) {
        this.datOtrosCostosMqdetDistrId = datOtrosCostosMqdetDistrId;
    }

    public Long getDatOtrosCostosMqId_DatOtrosCostosMq() {
        return datOtrosCostosMqId_DatOtrosCostosMq;
    }

    public void setDatOtrosCostosMqId_DatOtrosCostosMq(
        Long datOtrosCostosMqId_DatOtrosCostosMq) {
        this.datOtrosCostosMqId_DatOtrosCostosMq = datOtrosCostosMqId_DatOtrosCostosMq;
    }

   
}
