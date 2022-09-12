package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class PlanRevisionEquipoRecursosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoRecursosDTO.class);
    private String nombreRecurso;
    private Long planRevisionEquipoRecursosId;
    private Long recursoId;
    private Double rendimientoRecurso;
    private TipoRecurso tpRecursoId;
    private UdadMed udadMedId;
    private Long planRevisionEquipoId_PlanRevisionEquipo;
    private String nombreUm;
    private String nombreTipoRecurso;
    
    
	public String getNombreUm() {
		return nombreUm;
	}
	public void setNombreUm(String nombreUm) {
		this.nombreUm = nombreUm;
	}
	public String getNombreTipoRecurso() {
		return nombreTipoRecurso;
	}
	public void setNombreTipoRecurso(String nombreTipoRecurso) {
		this.nombreTipoRecurso = nombreTipoRecurso;
	}

	public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public Long getPlanRevisionEquipoRecursosId() {
        return planRevisionEquipoRecursosId;
    }

    public void setPlanRevisionEquipoRecursosId(
        Long planRevisionEquipoRecursosId) {
        this.planRevisionEquipoRecursosId = planRevisionEquipoRecursosId;
    }
    
	public Long getRecursoId() {
		return recursoId;
	}
	
	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
	}
	
	public Double getRendimientoRecurso() {
		return rendimientoRecurso;
	}
	
	public void setRendimientoRecurso(Double rendimientoRecurso) {
		this.rendimientoRecurso = rendimientoRecurso;
	}
	
	public TipoRecurso getTpRecursoId() {
		return tpRecursoId;
	}
	
	public void setTpRecursoId(TipoRecurso tpRecursoId) {
		this.tpRecursoId = tpRecursoId;
	}
	
	public UdadMed getUdadMedId() {
		return udadMedId;
	}
	
	public void setUdadMedId(UdadMed udadMedId) {
		this.udadMedId = udadMedId;
	}
	
	public Long getPlanRevisionEquipoId_PlanRevisionEquipo() {
		return planRevisionEquipoId_PlanRevisionEquipo;
	}
	
	public void setPlanRevisionEquipoId_PlanRevisionEquipo(Long planRevisionEquipoId_PlanRevisionEquipo) {
		this.planRevisionEquipoId_PlanRevisionEquipo = planRevisionEquipoId_PlanRevisionEquipo;
	}
}
