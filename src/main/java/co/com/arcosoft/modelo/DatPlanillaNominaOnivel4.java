package co.com.arcosoft.modelo;
// Generated 25-nov-2016 9:22:56 by Hibernate Tools 4.0.0



/**
 * DatPlanillaNominaOnivel4 generated by hbm2java
 */
public class DatPlanillaNominaOnivel4  implements java.io.Serializable {


     private Long detPlanillaNominaOnivel4Id;
     private Nivel4 nivel4;
     private Nivel2 nivel2;
     private DatPlanillaNomina datPlanillaNomina;
     private Double areaNeta;
     private Variedad variedad;
     private Etapa etapa;
     
    public DatPlanillaNominaOnivel4() {
    }

    public DatPlanillaNominaOnivel4(Nivel4 nivel4, Nivel2 nivel2, DatPlanillaNomina datPlanillaNomina, Double areaNeta,
    		Variedad variedad, Etapa etapa
    		) {
       this.nivel4 = nivel4;
       this.nivel2 = nivel2;
       this.datPlanillaNomina = datPlanillaNomina;
       this.areaNeta = areaNeta;
       this.etapa=etapa;
       this.variedad=variedad;
    }
   
    public Variedad getVariedad() {
		return variedad;
	}

	public void setVariedad(Variedad variedad) {
		this.variedad = variedad;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Long getDetPlanillaNominaOnivel4Id() {
        return this.detPlanillaNominaOnivel4Id;
    }
    
    public void setDetPlanillaNominaOnivel4Id(Long detPlanillaNominaOnivel4Id) {
        this.detPlanillaNominaOnivel4Id = detPlanillaNominaOnivel4Id;
    }
    public Nivel4 getNivel4() {
        return this.nivel4;
    }
    
    public void setNivel4(Nivel4 nivel4) {
        this.nivel4 = nivel4;
    }
    public Nivel2 getNivel2() {
        return this.nivel2;
    }
    
    
    public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public void setNivel2(Nivel2 nivel2) {
        this.nivel2 = nivel2;
    }
    public DatPlanillaNomina getDatPlanillaNomina() {
        return this.datPlanillaNomina;
    }
    
    public void setDatPlanillaNomina(DatPlanillaNomina datPlanillaNomina) {
        this.datPlanillaNomina = datPlanillaNomina;
    }




}

