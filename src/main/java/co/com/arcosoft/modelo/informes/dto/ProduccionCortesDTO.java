package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProduccionCortesDTO {

	private String nombreCompania;
	private Integer anio;
	private String nCortes;
	private BigDecimal cantidadCosechada;
	private BigDecimal areaCosechada;
	private BigDecimal cantidadCosechadaHa;
	private BigDecimal rendimiento;
	private BigDecimal edadCos;
	private BigDecimal cantidadCosechadaMes;

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

	public BigDecimal getCantidadCosechadaHa() {
		return cantidadCosechadaHa;
	}

	public void setCantidadCosechadaHa(BigDecimal cantidadCosechadaHa) {
		this.cantidadCosechadaHa = cantidadCosechadaHa;
	}

	public BigDecimal getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}

	public BigDecimal getEdadCos() {
		return edadCos;
	}

	public void setEdadCos(BigDecimal edadCos) {
		this.edadCos = edadCos;
	}

	public BigDecimal getCantidadCosechadaMes() {
		return cantidadCosechadaMes;
	}

	public void setCantidadCosechadaMes(BigDecimal cantidadCosechadaMes) {
		this.cantidadCosechadaMes = cantidadCosechadaMes;
	}

	public String getnCortes() {
		return nCortes;
	}

	public void setnCortes(String nCortes) {
		this.nCortes = nCortes;
	}

}
