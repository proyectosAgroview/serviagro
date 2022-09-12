package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Medidor;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class PlanRevisionEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoDTO.class);
    private String codigo;
    private Long compania;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String nombre;
    private String observacion;
    private Long planRevisionEquipoId;
    private String tipoPlanRev;
    private String origenDatos;
    private String tipoProcedimiento;
    private Medidor medidorId;
    
    
    
    public String getTipoProcedimiento() {
		return tipoProcedimiento;
	}

	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.tipoProcedimiento = tipoProcedimiento;
	}

	public  String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getPlanRevisionEquipoId() {
        return planRevisionEquipoId;
    }

    public void setPlanRevisionEquipoId(Long planRevisionEquipoId) {
        this.planRevisionEquipoId = planRevisionEquipoId;
    }

	public String getTipoPlanRev() {
		return tipoPlanRev;
	}

	public void setTipoPlanRev(String tipoPlanRev) {
		this.tipoPlanRev = tipoPlanRev;
	}

	public Medidor getMedidorId() {
		return medidorId;
	}

	public void setMedidorId(Medidor medidorId) {
		this.medidorId = medidorId;
	}


    
    
}
