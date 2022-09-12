package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProduccionPalmaPesoPromedioDTO {

	private Long anio;
	private Long mes;
	private String mesCorto;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String nomBloque;
	private String codLote;
	private String nomLote;
	private BigDecimal area;
	private BigDecimal cantRacimos;
	private BigDecimal pesoPromedio;
	private BigDecimal produccionLoteTon;
	private BigDecimal cantidadCosechadaTon;
	private BigDecimal tonHa;
	private BigDecimal tonHaAnio;

	public Long getAnio() {
		return anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public String getMesCorto() {
		return mesCorto;
	}

	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}

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

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getCantRacimos() {
		return cantRacimos;
	}

	public void setCantRacimos(BigDecimal cantRacimos) {
		this.cantRacimos = cantRacimos;
	}

	public BigDecimal getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(BigDecimal pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public BigDecimal getProduccionLoteTon() {
		return produccionLoteTon;
	}

	public void setProduccionLoteTon(BigDecimal produccionLoteTon) {
		this.produccionLoteTon = produccionLoteTon;
	}

	public BigDecimal getCantidadCosechadaTon() {
		return cantidadCosechadaTon;
	}

	public void setCantidadCosechadaTon(BigDecimal cantidadCosechadaTon) {
		this.cantidadCosechadaTon = cantidadCosechadaTon;
	}

	public BigDecimal getTonHa() {
		return tonHa;
	}

	public void setTonHa(BigDecimal tonHa) {
		this.tonHa = tonHa;
	}

	public BigDecimal getTonHaAnio() {
		return tonHaAnio;
	}

	public void setTonHaAnio(BigDecimal tonHaAnio) {
		this.tonHaAnio = tonHaAnio;
	}

}
