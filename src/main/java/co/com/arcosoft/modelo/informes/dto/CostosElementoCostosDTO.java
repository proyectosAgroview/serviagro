package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class CostosElementoCostosDTO {

	private BigDecimal costoTotal;
	private String nombreElementoCosto;
	private String nombreCompania;

	public String getNombreElementoCosto() {
		return nombreElementoCosto;
	}

	public void setNombreElementoCosto(String nombreElementoCosto) {
		this.nombreElementoCosto = nombreElementoCosto;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

}
