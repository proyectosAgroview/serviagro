package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Labor;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class PlanRevisionEquipoActivDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoActivDTO.class);
	private String codigo;
	private Date duracion;
	private String nombre;
	private Long planRevisionEquipoActivId;
	private Long secuencia;
	private Long planRevisionEquipoId_PlanRevisionEquipo;
	private Long laborId_Labor;
	private Labor laborId;
	private String codigoLabor;


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDuracion() {
		return duracion;
	}

	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPlanRevisionEquipoActivId() {
		return planRevisionEquipoActivId;
	}

	public void setPlanRevisionEquipoActivId(Long planRevisionEquipoActivId) {
		this.planRevisionEquipoActivId = planRevisionEquipoActivId;
	}

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public Long getPlanRevisionEquipoId_PlanRevisionEquipo() {
		return planRevisionEquipoId_PlanRevisionEquipo;
	}

	public void setPlanRevisionEquipoId_PlanRevisionEquipo(Long planRevisionEquipoId_PlanRevisionEquipo) {
		this.planRevisionEquipoId_PlanRevisionEquipo = planRevisionEquipoId_PlanRevisionEquipo;
	}

	public String getCodigoLabor() {
		return codigoLabor;
	}

	public void setCodigoLabor(String codigoLabor) {
		this.codigoLabor = codigoLabor;
	}

	public Labor getLaborId() {
		return laborId;
	}

	public void setLaborId(Labor laborId) {
		this.laborId = laborId;
	}
	
	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

}
