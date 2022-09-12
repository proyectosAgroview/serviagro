package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class CronogramaLaboresNivel4DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresNivel4DTO.class);
	private Long cronogramaLaboresNivel4Id;
	private Long cronogramaLaboresId_CronogramaLabores;
	private Nivel4 nivel4Id_Nivel4;
	private String nombreNivel4;
	private Nivel2 nivel2Id;
	private String nombreNivel2;

	private Double areaNeta;
	private Double numeroPlantas;
private Date fechaStart;


	/**
 * @return the fechaStart
 */
public Date getFechaStart() {
	return fechaStart;
}

/**
 * @param fechaStart the fechaStart to set
 */
public void setFechaStart(Date fechaStart) {
	this.fechaStart = fechaStart;
}

	public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public Double getNumeroPlantas() {
		return numeroPlantas;
	}

	public void setNumeroPlantas(Double numeroPlantas) {
		this.numeroPlantas = numeroPlantas;
	}

	public Nivel2 getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Nivel2 nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public String getNombreNivel4() {
		return nombreNivel4;
	}

	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	public String getNombreNivel2() {
		return nombreNivel2;
	}

	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	public Long getCronogramaLaboresNivel4Id() {
		return cronogramaLaboresNivel4Id;
	}

	public void setCronogramaLaboresNivel4Id(Long cronogramaLaboresNivel4Id) {
		this.cronogramaLaboresNivel4Id = cronogramaLaboresNivel4Id;
	}

	public Long getCronogramaLaboresId_CronogramaLabores() {
		return cronogramaLaboresId_CronogramaLabores;
	}

	public void setCronogramaLaboresId_CronogramaLabores(Long cronogramaLaboresId_CronogramaLabores) {
		this.cronogramaLaboresId_CronogramaLabores = cronogramaLaboresId_CronogramaLabores;
	}

	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}
}
