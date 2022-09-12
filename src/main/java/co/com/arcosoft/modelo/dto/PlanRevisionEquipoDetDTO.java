package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.SistemasEquipo;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class PlanRevisionEquipoDetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoDetDTO.class);
    private Equipo equipo;
    private Double periocidadDias;
    private Double periocidadHora;
    private Double periocidadKm;
    private Long planRevisionEquipoDetId;
    private Long planRevisionEquipoId_PlanRevisionEquipo;
    private String nombreEquipo;
    private Date fechaUltimoServicio;
    private Double horasUltimoServicio;
    private Double kmUltimoServicio;
    private Date fechaProxServicio;
    private Double kmProxServicio;
    private Double horasProxServicio;
    private CompartimientosEquipo compartimientosEquipo;
    private SistemasEquipo sistemasEquipo;
    private String nombreCompartimiento;
    private String nombreSistema;
    private Double alertaMin;
    private Double alertaMax;
    private String codEquipo;
    private String infoAdicional;
    private String infoAdicional2;
    private String observacion;
    
    
    
    
   
   
    
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public CompartimientosEquipo getCompartimientosEquipo() {
		return compartimientosEquipo;
	}
	
	public void setCompartimientosEquipo(CompartimientosEquipo compartimientosEquipo) {
		this.compartimientosEquipo = compartimientosEquipo;
	}
	
	public SistemasEquipo getSistemasEquipo() {
		return sistemasEquipo;
	}
	
	public void setSistemasEquipo(SistemasEquipo sistemasEquipo) {
		this.sistemasEquipo = sistemasEquipo;
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

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Double getPeriocidadDias() {
        return periocidadDias;
    }

    public void setPeriocidadDias(Double periocidadDias) {
        this.periocidadDias = periocidadDias;
    }

    public Double getPeriocidadHora() {
        return periocidadHora;
    }

    public void setPeriocidadHora(Double periocidadHora) {
        this.periocidadHora = periocidadHora;
    }

    public Double getPeriocidadKm() {
        return periocidadKm;
    }

    public void setPeriocidadKm(Double periocidadKm) {
        this.periocidadKm = periocidadKm;
    }

    public Long getPlanRevisionEquipoDetId() {
        return planRevisionEquipoDetId;
    }

    public void setPlanRevisionEquipoDetId(Long planRevisionEquipoDetId) {
        this.planRevisionEquipoDetId = planRevisionEquipoDetId;
    }

    public Long getPlanRevisionEquipoId_PlanRevisionEquipo() {
        return planRevisionEquipoId_PlanRevisionEquipo;
    }

    public void setPlanRevisionEquipoId_PlanRevisionEquipo(
        Long planRevisionEquipoId_PlanRevisionEquipo) {
        this.planRevisionEquipoId_PlanRevisionEquipo = planRevisionEquipoId_PlanRevisionEquipo;
    }

	public Date getFechaUltimoServicio() {
		return fechaUltimoServicio;
	}

	public Double getKmUltimoServicio() {
		return kmUltimoServicio;
	}

	public Double getHorasUltimoServicio() {
		return horasUltimoServicio;
	}

	public Date getFechaProxServicio() {
		return fechaProxServicio;
	}

	public Double getKmProxServicio() {
		return kmProxServicio;
	}

	public Double getHorasProxServicio() {
		return horasProxServicio;
	}

	public void setFechaUltimoServicio(Date fechaUltimoServicio) {
		this.fechaUltimoServicio = fechaUltimoServicio;
	}

	public void setKmUltimoServicio(Double kmUltimoServicio) {
		this.kmUltimoServicio = kmUltimoServicio;
	}

	public void setHorasUltimoServicio(Double horasUltimoServicio) {
		this.horasUltimoServicio = horasUltimoServicio;
	}

	public void setFechaProxServicio(Date fechaProxServicio) {
		this.fechaProxServicio = fechaProxServicio;
	}

	public void setKmProxServicio(Double kmProxServicio) {
		this.kmProxServicio = kmProxServicio;
	}

	public void setHorasProxServicio(Double horasProxServicio) {
		this.horasProxServicio = horasProxServicio;
	}

	public Double getAlertaMin() {
		return alertaMin;
	}

	public void setAlertaMin(Double alertaMin) {
		this.alertaMin = alertaMin;
	}

	public Double getAlertaMax() {
		return alertaMax;
	}

	public void setAlertaMax(Double alertaMax) {
		this.alertaMax = alertaMax;
	}
    
    
}
