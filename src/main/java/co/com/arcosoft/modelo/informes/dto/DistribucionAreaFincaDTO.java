package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class DistribucionAreaFincaDTO {

	private BigDecimal area;
	private String finca;

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getFinca() {
		return finca;
	}

	public void setFinca(String finca) {
		this.finca = finca;
	}

	@Override
	public String toString() {
		return "DistribuccionAreaFincaDTO [area=" + area + ", finca=" + finca + "]";
	}

}
