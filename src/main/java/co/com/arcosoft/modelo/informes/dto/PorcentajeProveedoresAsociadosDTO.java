package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class PorcentajeProveedoresAsociadosDTO {
	private String nomCompania;
	private String tipoProductor;
	private BigDecimal area;
	private BigDecimal porcArea;
	private Double porcProductores;

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public String getTipoProductor() {
		return tipoProductor;
	}

	public void setTipoProductor(String tipoProductor) {
		this.tipoProductor = tipoProductor;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getPorcArea() {
		return porcArea;
	}

	public void setPorcArea(BigDecimal porcArea) {
		this.porcArea = porcArea;
	}

	public Double getPorcProductores() {
		return porcProductores;
	}

	public void setPorcProductores(Double porcProductores) {
		this.porcProductores = porcProductores;
	}

}
