package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CosechasLoteDTO {

	private String nomCompania;
	private BigDecimal anio;
	private BigDecimal mes;
	private String codZona;
	private String nomZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String nomBloque;
	private String codLote;
	private String loteA;
	private BigDecimal costoTotal;
	private BigDecimal cantCosechada;
	private BigDecimal areaCosechada;
	private BigDecimal ingresos;
	private BigInteger numCosechas;
	private String fechaUltCorte;
	private String variedad;
	private BigDecimal areaNeta;
	private BigDecimal edadUltCosecha;
	private BigDecimal rendimiento;

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public BigDecimal getAnio() {
		return anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public BigDecimal getMes() {
		return mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}

	public String getNomZona() {
		return nomZona;
	}

	public void setNomZona(String nomZona) {
		this.nomZona = nomZona;
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

	public String getNomBloque() {
		return nomBloque;
	}

	public void setNomBloque(String nomBloque) {
		this.nomBloque = nomBloque;
	}

	public String getCodLote() {
		return codLote;
	}

	public void setCodLote(String codLote) {
		this.codLote = codLote;
	}

	public String getLoteA() {
		return loteA;
	}

	public void setLoteA(String loteA) {
		this.loteA = loteA;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public BigDecimal getCantCosechada() {
		return cantCosechada;
	}

	public void setCantCosechada(BigDecimal cantCosechada) {
		this.cantCosechada = cantCosechada;
	}

	public BigDecimal getAreaCosechada() {
		return areaCosechada;
	}

	public void setAreaCosechada(BigDecimal areaCosechada) {
		this.areaCosechada = areaCosechada;
	}

	public BigDecimal getIngresos() {
		return ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public BigInteger getNumCosechas() {
		return numCosechas;
	}

	public void setNumCosechas(BigInteger numCosechas) {
		this.numCosechas = numCosechas;
	}

	public String getFechaUltCorte() {
		return fechaUltCorte;
	}

	public void setFechaUltCorte(String fechaUltCorte) {
		this.fechaUltCorte = fechaUltCorte;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public BigDecimal getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(BigDecimal areaNeta) {
		this.areaNeta = areaNeta;
	}

	public BigDecimal getEdadUltCosecha() {
		return edadUltCosecha;
	}

	public void setEdadUltCosecha(BigDecimal edadUltCosecha) {
		this.edadUltCosecha = edadUltCosecha;
	}

	public BigDecimal getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}
}
