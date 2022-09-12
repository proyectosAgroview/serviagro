package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProduccionAniosDTO {

	private Integer mes;
	private String nombreCompania;
	private BigDecimal tonActual;
	private BigDecimal tonActualMenos1;
	private BigDecimal tonActualMenos2;
	private BigDecimal tonActualMenos3;
	private BigDecimal tonActualMenos4;

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

	public BigDecimal getTonActualMenos1() {
		return tonActualMenos1;
	}

	public void setTonActualMenos1(BigDecimal tonActualMenos1) {
		this.tonActualMenos1 = tonActualMenos1;
	}

	public BigDecimal getTonActualMenos2() {
		return tonActualMenos2;
	}

	public void setTonActualMenos2(BigDecimal tonActualMenos2) {
		this.tonActualMenos2 = tonActualMenos2;
	}

	public BigDecimal getTonActualMenos3() {
		return tonActualMenos3;
	}

	public void setTonActualMenos3(BigDecimal tonActualMenos3) {
		this.tonActualMenos3 = tonActualMenos3;
	}

	public BigDecimal getTonActual() {
		return tonActual;
	}

	public void setTonActual(BigDecimal tonActual) {
		this.tonActual = tonActual;
	}

	public BigDecimal getTonActualMenos4() {
		return tonActualMenos4;
	}

	public void setTonActualMenos4(BigDecimal tonActualMenos4) {
		this.tonActualMenos4 = tonActualMenos4;
	}

}
