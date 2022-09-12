package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class PrecipitacionAniosDTO {

	private Integer mes;
	private String nombreCompania;
	private BigDecimal lluviaActual;
	private BigDecimal lluviaActualMenos1;
	private BigDecimal lluviaActualMenos2;
	private BigDecimal lluviaActualMenos3;
	private BigDecimal lluviaActualMenos4;

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public BigDecimal getLluviaActual() {
		return lluviaActual;
	}

	public void setLluviaActual(BigDecimal lluviaActual) {
		this.lluviaActual = lluviaActual;
	}

	public BigDecimal getLluviaActualMenos1() {
		return lluviaActualMenos1;
	}

	public void setLluviaActualMenos1(BigDecimal lluviaActualMenos1) {
		this.lluviaActualMenos1 = lluviaActualMenos1;
	}

	public BigDecimal getLluviaActualMenos2() {
		return lluviaActualMenos2;
	}

	public void setLluviaActualMenos2(BigDecimal lluviaActualMenos2) {
		this.lluviaActualMenos2 = lluviaActualMenos2;
	}

	public BigDecimal getLluviaActualMenos3() {
		return lluviaActualMenos3;
	}

	public void setLluviaActualMenos3(BigDecimal lluviaActualMenos3) {
		this.lluviaActualMenos3 = lluviaActualMenos3;
	}

	public BigDecimal getLluviaActualMenos4() {
		return lluviaActualMenos4;
	}

	public void setLluviaActualMenos4(BigDecimal lluviaActualMenos4) {
		this.lluviaActualMenos4 = lluviaActualMenos4;
	}

}
