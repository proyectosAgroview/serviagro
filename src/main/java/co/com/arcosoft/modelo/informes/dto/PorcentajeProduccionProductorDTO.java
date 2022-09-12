package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class PorcentajeProduccionProductorDTO {

	private String nombreCompania;
	private Integer anio;
	private BigDecimal cantidadCosechada;
	private BigDecimal areaCosechada;
	private BigDecimal cantidadEstimada;
	private BigDecimal porcentajeEstimado;
	private BigDecimal PorcentajeOtrosDestinos;
	private Integer mes;

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

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public BigDecimal getCantidadCosechada() {
		return cantidadCosechada;
	}

	public void setCantidadCosechada(BigDecimal cantidadCosechada) {
		this.cantidadCosechada = cantidadCosechada;
	}

	public BigDecimal getAreaCosechada() {
		return areaCosechada;
	}

	public void setAreaCosechada(BigDecimal areaCosechada) {
		this.areaCosechada = areaCosechada;
	}

	public BigDecimal getCantidadEstimada() {
		return cantidadEstimada;
	}

	public void setCantidadEstimada(BigDecimal cantidadEstimada) {
		this.cantidadEstimada = cantidadEstimada;
	}

	public BigDecimal getPorcentajeEstimado() {
		return porcentajeEstimado;
	}

	public void setPorcentajeEstimado(BigDecimal porcentajeEstimado) {
		this.porcentajeEstimado = porcentajeEstimado;
	}

	public BigDecimal getPorcentajeOtrosDestinos() {
		return PorcentajeOtrosDestinos;
	}

	public void setPorcentajeOtrosDestinos(BigDecimal porcentajeOtrosDestinos) {
		PorcentajeOtrosDestinos = porcentajeOtrosDestinos;
	}

}
