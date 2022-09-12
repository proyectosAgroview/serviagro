package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Variedad;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatPlanillaNominaOnivel4DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatPlanillaNominaOnivel4DTO.class);
    private Long detPlanillaNominaOnivel4Id;
    private Long planillaNominaId_DatPlanillaNomina;
    private Nivel2 nivel2Id_Nivel2;
    private Nivel4 nivel4Id_Nivel4;
    private String codNivel2;
    private String codNivel4;
    private Double areaNeta;
    private Variedad variedad;
    private Etapa etapa;
    
    
    
    

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

	public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public String getCodNivel2() {
		return codNivel2;
	}

	public void setCodNivel2(String codNivel2) {
		this.codNivel2 = codNivel2;
	}

	public String getCodNivel4() {
		return codNivel4;
	}

	public void setCodNivel4(String codNivel4) {
		this.codNivel4 = codNivel4;
	}

	public Long getDetPlanillaNominaOnivel4Id() {
        return detPlanillaNominaOnivel4Id;
    }

    public void setDetPlanillaNominaOnivel4Id(Long detPlanillaNominaOnivel4Id) {
        this.detPlanillaNominaOnivel4Id = detPlanillaNominaOnivel4Id;
    }

    public Long getPlanillaNominaId_DatPlanillaNomina() {
        return planillaNominaId_DatPlanillaNomina;
    }

    public void setPlanillaNominaId_DatPlanillaNomina(
        Long planillaNominaId_DatPlanillaNomina) {
        this.planillaNominaId_DatPlanillaNomina = planillaNominaId_DatPlanillaNomina;
    }

    public Nivel2 getNivel2Id_Nivel2() {
        return nivel2Id_Nivel2;
    }

    public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
        this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
    }

    public Nivel4 getNivel4Id_Nivel4() {
        return nivel4Id_Nivel4;
    }

    public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
        this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
    }
}
