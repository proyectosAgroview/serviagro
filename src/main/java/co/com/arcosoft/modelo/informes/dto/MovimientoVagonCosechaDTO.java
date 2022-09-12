package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MovimientoVagonCosechaDTO {

	private Integer anio;
	private Integer mes;
	private String mesCorto;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String nomBloque;
	private String codLote;
	private String nomLote;
	private BigDecimal cantidadCosechadaTon;
	private BigDecimal area;
	private String nomCompania;
	private String nomVariedad;

	private BigDecimal numeroCosechas;
	private String vagon;
	private Date fechaRegistro;
	private BigDecimal viajes;

	public BigDecimal getNumeroCosechas() {
		return numeroCosechas;
	}

	public void setNumeroCosechas(BigDecimal numeroCosechas) {
		this.numeroCosechas = numeroCosechas;
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

	public BigDecimal getCantidadCosechadaTon() {
		return cantidadCosechadaTon;
	}

	public void setCantidadCosechadaTon(BigDecimal cantidadCosechadaTon) {
		this.cantidadCosechadaTon = cantidadCosechadaTon;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public String getNomVariedad() {
		return nomVariedad;
	}

	public void setNomVariedad(String nomVariedad) {
		this.nomVariedad = nomVariedad;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public BigDecimal getViajes() {
		return viajes;
	}

	public void setViajes(BigDecimal viajes) {
		this.viajes = viajes;
	}

	public String getVagon() {
		return vagon;
	}

	public void setVagon(String vagon) {
		this.vagon = vagon;
	}

}
