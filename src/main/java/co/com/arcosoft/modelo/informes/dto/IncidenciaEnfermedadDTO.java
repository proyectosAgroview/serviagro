package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class IncidenciaEnfermedadDTO {

	private String nombreCompania;
	private Integer anio;
	private Integer mes;
	private String enfermedad;
	private Integer casos;
	private BigDecimal incidenciaAcumulada;
	private BigDecimal incidenciaActual;

	public BigDecimal getIncidenciaActual() {
		return incidenciaActual;
	}

	public void setIncidenciaActual(BigDecimal incidenciaActual) {
		this.incidenciaActual = incidenciaActual;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Integer getCasos() {
		return casos;
	}

	public void setCasos(Integer casos) {
		this.casos = casos;
	}

	public BigDecimal getIncidenciaAcumulada() {
		return incidenciaAcumulada;
	}

	public void setIncidenciaAcumulada(BigDecimal incidenciaAcumulada) {
		this.incidenciaAcumulada = incidenciaAcumulada;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

}
