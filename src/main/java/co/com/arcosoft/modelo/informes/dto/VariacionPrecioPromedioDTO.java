package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class VariacionPrecioPromedioDTO {

	private String nomCompania;
	private Integer anio;
	private String fecha;
	private Integer mes;
	private Integer semana;
	private BigDecimal precioSemana;
	private BigDecimal precioMes;

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getSemana() {
		return semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
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
