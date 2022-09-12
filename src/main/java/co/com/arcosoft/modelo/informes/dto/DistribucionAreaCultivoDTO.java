package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class DistribucionAreaCultivoDTO {

	private BigDecimal area;
	private String compania;
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

	public void setCultivo(String cultivo) {
		this.cultivo = cultivo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getCultivo() {
		return cultivo;
	}

}
