package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class DistribucionAreaVariedadDTO {

	private BigDecimal area;
	private String variedad;
	private String cultivo;
	private BigDecimal porcentajeArea;

	public BigDecimal getPorcentajeArea() {
		return porcentajeArea;
	}

	public void setPorcentajeArea(BigDecimal porcentajeArea) {
		this.porcentajeArea = porcentajeArea;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public String getCultivo() {
		return cultivo;
	}

	public void setCultivo(String cultivo) {
		this.cultivo = cultivo;
	}

	@Override
	public String toString() {
		return "DistribucionAreaVariedad [area=" + area + ", variedad=" + variedad + ", cultivo=" + cultivo + "]";
	}

}
