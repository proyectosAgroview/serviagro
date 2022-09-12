package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProgramaCosechaDTO {
	private String codZona;
	private String nomFinca;
	private String codBloque;
	private String loteA;
	private String fechaUltCorte;
	private BigDecimal nCortes;
	private BigDecimal area;
	private BigDecimal tchEstimado;
	private Double tchmEstimado;
	private BigDecimal tonEstimado;
	private BigDecimal edadUltCorte;
	private Double edadHoy;
	private BigDecimal distSiembra;
	private String fechaEstCorte;
	private String nomTenencia;
	private String zonaAgroeC;
	private String variedad;

	public Double getTchmEstimado() {
		return tchmEstimado;
	}

	public void setTchmEstimado(Double tchmEstimado) {
		this.tchmEstimado = tchmEstimado;
	}

	public BigDecimal getTonEstimado() {
		return tonEstimado;
	}

	public void setTonEstimado(BigDecimal tonEstimado) {
		this.tonEstimado = tonEstimado;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
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

	public String getFechaUltCorte() {
		return fechaUltCorte;
	}

	public void setFechaUltCorte(String fechaUltCorte) {
		this.fechaUltCorte = fechaUltCorte;
	}

	public BigDecimal getnCortes() {
		return nCortes;
	}

	public void setnCortes(BigDecimal nCortes) {
		this.nCortes = nCortes;
	}

	public BigDecimal getTchEstimado() {
		return tchEstimado;
	}

	public void setTchEstimado(BigDecimal tchEstimado) {
		this.tchEstimado = tchEstimado;
	}

	public BigDecimal getEdadUltCorte() {
		return edadUltCorte;
	}

	public void setEdadUltCorte(BigDecimal edadUltCorte) {
		this.edadUltCorte = edadUltCorte;
	}

	public Double getEdadHoy() {
		return edadHoy;
	}

	public void setEdadHoy(Double edadHoy) {
		this.edadHoy = edadHoy;
	}

	public BigDecimal getDistSiembra() {
		return distSiembra;
	}

	public void setDistSiembra(BigDecimal distSiembra) {
		this.distSiembra = distSiembra;
	}

	public String getFechaEstCorte() {
		return fechaEstCorte;
	}

	public void setFechaEstCorte(String fechaEstCorte) {
		this.fechaEstCorte = fechaEstCorte;
	}

	public String getNomTenencia() {
		return nomTenencia;
	}

	public void setNomTenencia(String nomTenencia) {
		this.nomTenencia = nomTenencia;
	}

	public String getZonaAgroeC() {
		return zonaAgroeC;
	}

	public void setZonaAgroeC(String zonaAgroeC) {
		this.zonaAgroeC = zonaAgroeC;
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

	@Override
	public String toString() {
		return "ProntuarioLotes [area=" + area + ", loteA=" + loteA + "]";
	}

}
