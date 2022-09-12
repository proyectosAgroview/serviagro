package co.com.arcosoft.modelo;
// Generated 24-mar-2018 15:52:14 by Hibernate Tools 4.0.0



/**
 * PlanRevisionEquipoRecursos generated by hbm2java
 */
public class PlanRevisionEquipoRecursos  implements java.io.Serializable {


     private Long planRevisionEquipoRecursosId;
     private PlanRevisionEquipo planRevisionEquipo;
     private TipoRecurso tpRecursoId;
     private Long recursoId;
     private UdadMed udadMedId;
     private Double rendimientoRecurso;
     private String nombreRecurso;

    public PlanRevisionEquipoRecursos() {
    }

    public PlanRevisionEquipoRecursos(PlanRevisionEquipo planRevisionEquipo, TipoRecurso tpRecursoId, Long recursoId, UdadMed udadMedId, Double rendimientoRecurso, String nombreRecurso) {
       this.planRevisionEquipo = planRevisionEquipo;
       this.tpRecursoId = tpRecursoId;
       this.recursoId = recursoId;
       this.udadMedId = udadMedId;
       this.rendimientoRecurso = rendimientoRecurso;
       this.nombreRecurso = nombreRecurso;
    }
   
    public Long getPlanRevisionEquipoRecursosId() {
        return this.planRevisionEquipoRecursosId;
    }
    
    public void setPlanRevisionEquipoRecursosId(Long planRevisionEquipoRecursosId) {
        this.planRevisionEquipoRecursosId = planRevisionEquipoRecursosId;
    }
    public PlanRevisionEquipo getPlanRevisionEquipo() {
        return this.planRevisionEquipo;
    }
    
    public void setPlanRevisionEquipo(PlanRevisionEquipo planRevisionEquipo) {
        this.planRevisionEquipo = planRevisionEquipo;
    }
  
    public Long getRecursoId() {
        return this.recursoId;
    }
    
    public void setRecursoId(Long recursoId) {
        this.recursoId = recursoId;
    }
    public Double getRendimientoRecurso() {
        return this.rendimientoRecurso;
    }
    
    public void setRendimientoRecurso(Double rendimientoRecurso) {
        this.rendimientoRecurso = rendimientoRecurso;
    }
    public String getNombreRecurso() {
        return this.nombreRecurso;
    }
    
    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

	/**
	 * @return the tpRecursoId
	 */
	public TipoRecurso getTpRecursoId() {
		return tpRecursoId;
	}

	/**
	 * @param tpRecursoId the tpRecursoId to set
	 */
	public void setTpRecursoId(TipoRecurso tpRecursoId) {
		this.tpRecursoId = tpRecursoId;
	}

	/**
	 * @return the udadMedId
	 */
	public UdadMed getUdadMedId() {
		return udadMedId;
	}

	/**
	 * @param udadMedId the udadMedId to set
	 */
	public void setUdadMedId(UdadMed udadMedId) {
		this.udadMedId = udadMedId;
	}




}


