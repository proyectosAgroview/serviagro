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
public class DatPlanServiciosMqdetEjecDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqdetEjecDTO.class);
    private Double cantidadRealizada;
    private Long datPlanServiciosMqdetEjecId;
    private Date fechaRegistro;
    private Long datPlanServiciosMqdetId_DatPlanServiciosMqdet;
    private Long equipoId_Equipo;
    private Long operarioId;
    
    


    public Long getOperarioId() {
		return operarioId;
	}

	public void setOperarioId(Long operarioId) {
		this.operarioId = operarioId;
	}

	public Double getCantidadRealizada() {
        return cantidadRealizada;
    }

    public void setCantidadRealizada(Double cantidadRealizada) {
        this.cantidadRealizada = cantidadRealizada;
    }

    public Long getDatPlanServiciosMqdetEjecId() {
        return datPlanServiciosMqdetEjecId;
    }

    public void setDatPlanServiciosMqdetEjecId(Long datPlanServiciosMqdetEjecId) {
        this.datPlanServiciosMqdetEjecId = datPlanServiciosMqdetEjecId;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getDatPlanServiciosMqdetId_DatPlanServiciosMqdet() {
        return datPlanServiciosMqdetId_DatPlanServiciosMqdet;
    }

    public void setDatPlanServiciosMqdetId_DatPlanServiciosMqdet(
        Long datPlanServiciosMqdetId_DatPlanServiciosMqdet) {
        this.datPlanServiciosMqdetId_DatPlanServiciosMqdet = datPlanServiciosMqdetId_DatPlanServiciosMqdet;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }
}
