package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CostosInsumosDetalladoDTO {

	private String nombreCompania;
	private Date fecha;
	private String codZona;
	private String nomZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String nomBloque;
	private String loteA;
	private String nomLote;
	private String codLabor;
	private String nombreLabor;
	private String nomProducto;
	private String codUdadMedAplic;
	private BigDecimal cantidadAplicada;
	private BigDecimal valorUnit;
	private BigDecimal costoTotal;
	private BigDecimal areaAplicada;
	private BigDecimal dosis;
	private BigDecimal costoHa;
	private String mesCorto;
	private String generico;
	private BigInteger idInsumos;
	private BigInteger consecutivo;

	public String getMesCorto() {
		return mesCorto;
	}

	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public BigDecimal getCostoHa() {
		return costoHa;
	}

	public void setCostoHa(BigDecimal costoHa) {
		this.costoHa = costoHa;
	}

	public String getNomZona() {
		return nomZona;
	}

	public void setNomZona(String nomZona) {
		this.nomZona = nomZona;
	}

	public String getNomBloque() {
		return nomBloque;
	}

	public void setNomBloque(String nomBloque) {
		this.nomBloque = nomBloque;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public String getLoteA() {
		return loteA;
	}

	public void setLoteA(String loteA) {
		this.loteA = loteA;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getCodUdadMedAplic() {
		return codUdadMedAplic;
	}

	public void setCodUdadMedAplic(String codUdadMedAplic) {
		this.codUdadMedAplic = codUdadMedAplic;
	}

	public BigDecimal getCantidadAplicada() {
		return cantidadAplicada;
	}

	public void setCantidadAplicada(BigDecimal cantidadAplicada) {
		this.cantidadAplicada = cantidadAplicada;
	}

	public BigDecimal getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(BigDecimal valorUnit) {
		this.valorUnit = valorUnit;
	}

	public BigDecimal getAreaAplicada() {
		return areaAplicada;
	}

	public void setAreaAplicada(BigDecimal areaAplicada) {
		this.areaAplicada = areaAplicada;
	}

	public BigDecimal getDosis() {
		return dosis;
	}

	public void setDosis(BigDecimal dosis) {
		this.dosis = dosis;
	}

	public BigInteger getIdInsumos() {
		return idInsumos;
	}

	public void setIdInsumos(BigInteger idInsumos) {
		this.idInsumos = idInsumos;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
}
