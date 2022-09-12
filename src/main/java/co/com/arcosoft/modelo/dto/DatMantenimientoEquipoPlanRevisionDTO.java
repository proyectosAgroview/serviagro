package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.PlanRevisionEquipo;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatMantenimientoEquipoPlanRevisionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoPlanRevisionDTO.class);
    private Long datManPlanRevivionId;
    private Long datMantenimientoEquipoId_DatMantenimientoEquipo;
    private PlanRevisionEquipo planRevisionEquipoId_PlanRevisionEquipo;
    
    private String nombrePlanRevision;

    public Long getDatManPlanRevivionId() {
        return datManPlanRevivionId;
    }

    public void setDatManPlanRevivionId(Long datManPlanRevivionId) {
        this.datManPlanRevivionId = datManPlanRevivionId;
    }

    public Long getDatMantenimientoEquipoId_DatMantenimientoEquipo() {
        return datMantenimientoEquipoId_DatMantenimientoEquipo;
    }

    public void setDatMantenimientoEquipoId_DatMantenimientoEquipo(
        Long datMantenimientoEquipoId_DatMantenimientoEquipo) {
        this.datMantenimientoEquipoId_DatMantenimientoEquipo = datMantenimientoEquipoId_DatMantenimientoEquipo;
    }

    public PlanRevisionEquipo getPlanRevisionEquipoId_PlanRevisionEquipo() {
        return planRevisionEquipoId_PlanRevisionEquipo;
    }

    public void setPlanRevisionEquipoId_PlanRevisionEquipo(PlanRevisionEquipo planRevisionEquipoId_PlanRevisionEquipo) {
        this.planRevisionEquipoId_PlanRevisionEquipo = planRevisionEquipoId_PlanRevisionEquipo;
    }

	public String getNombrePlanRevision() {
		return nombrePlanRevision;
	}

	public void setNombrePlanRevision(String nombrePlanRevision) {
		this.nombrePlanRevision = nombrePlanRevision;
	}
}
