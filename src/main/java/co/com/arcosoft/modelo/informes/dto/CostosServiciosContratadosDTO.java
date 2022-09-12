package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class CostosServiciosContratadosDTO {

	private BigDecimal costoTotal;
	private Integer anio;
	private Integer mes;
	private String anioMes;
	private String nombreCompania;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
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

	@Override
	public String toString() {
		return "CostosServiciosContratados [costoTotal=" + costoTotal + ", anio=" + anio + ", mes=" + mes + "]";
	}

}
