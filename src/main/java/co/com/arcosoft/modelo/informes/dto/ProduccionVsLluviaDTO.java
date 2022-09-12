package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProduccionVsLluviaDTO {

	private Integer anio;
	private Integer mes;
	private String nombreCompania;
	private BigDecimal toneladas;
	private BigDecimal lluvia;

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

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public BigDecimal getToneladas() {
		return toneladas;
	}

	public void setToneladas(BigDecimal toneladas) {
		this.toneladas = toneladas;
	}

	public BigDecimal getLluvia() {
		return lluvia;
	}

	public void setLluvia(BigDecimal lluvia) {
		this.lluvia = lluvia;
	}

}
