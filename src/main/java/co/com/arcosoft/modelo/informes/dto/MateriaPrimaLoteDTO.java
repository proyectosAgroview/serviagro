package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class MateriaPrimaLoteDTO {

	private BigDecimal cantidadCos;
	private BigDecimal area;
	private String loteA;
	private BigDecimal ingresos;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;

	private String nombreCompania;

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getNomFinca() {
		return nomFinca;
	}

	public void setNomFinca(String nomFinca) {
		this.nomFinca = nomFinca;
	}

	public String getCodBloque() {
		return codBloque;
	}

	public void setCodBloque(String codBloque) {
		this.codBloque = codBloque;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public BigDecimal getIngresos() {
		return ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public String getLoteA() {
		return loteA;
	}

	public void setLoteA(String loteA) {
		this.loteA = loteA;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getCantidadCos() {
		return cantidadCos;
	}

	public void setCantidadCos(BigDecimal cantidadCos) {
		this.cantidadCos = cantidadCos;
	}

	@Override
	public String toString() {
		return "ProntuarioLotes [cantidadCos=" + cantidadCos + ", area=" + area + ", loteA=" + loteA + "]";
	}

}
