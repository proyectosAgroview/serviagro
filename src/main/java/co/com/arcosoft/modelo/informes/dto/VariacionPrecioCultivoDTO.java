package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class VariacionPrecioCultivoDTO {

	private String nomCompania;
	private Integer anio;
	private Integer mes;
	private Integer semana;
	private String nombreUdadMed;
	private BigDecimal cantCosechada;
	private BigDecimal costoTotal;
	private BigDecimal precioSemana;
	private BigDecimal precioMes;

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
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

	public Integer getSemana() {
		return semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
	}

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public BigDecimal getCantCosechada() {
		return cantCosechada;
	}

	public void setCantCosechada(BigDecimal cantCosechada) {
		this.cantCosechada = cantCosechada;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public BigDecimal getPrecioSemana() {
		return precioSemana;
	}

	public void setPrecioSemana(BigDecimal precioSemana) {
		this.precioSemana = precioSemana;
	}

	public BigDecimal getPrecioMes() {
		return precioMes;
	}

	public void setPrecioMes(BigDecimal precioMes) {
		this.precioMes = precioMes;
	}

}
