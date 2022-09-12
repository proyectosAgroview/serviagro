package co.com.arcosoft.rest.service.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrdenDeTrabajoDTO {

	private BigInteger idPlanLabor;
	private String ordenDeTrabajo;
	private BigInteger idCompania;
	private String periodoInicial;
	private String periodoFinal;
	private BigInteger idLabor;
	private String nombreLabor;
	private BigInteger idZona;
	private String nombreZona;
	private BigInteger idFinca;
	private String nombreFinca;
	private BigInteger idBloque;
	private String nombreBloque;
	private BigInteger idLote;
	private String nombreLote;
	private String codigoTrabajador;

	private BigDecimal cantidadPlaneada;
	private BigDecimal numeroPases;
	private BigInteger codigoUnidadMedida;
	private String nombreUnidadMedida;
	private String nombreTrabajador;
	private String tipoLabor;

	public String getTipoLabor() {
		return tipoLabor;
	}

	public void setTipoLabor(String tipoLabor) {
		this.tipoLabor = tipoLabor;
	}

	public BigInteger getIdPlanLabor() {
		return idPlanLabor;
	}

	public void setIdPlanLabor(BigInteger idPlanLabor) {
		this.idPlanLabor = idPlanLabor;
	}

	public String getOrdenDeTrabajo() {
		return ordenDeTrabajo;
	}

	public void setOrdenDeTrabajo(String ordenDeTrabajo) {
		this.ordenDeTrabajo = ordenDeTrabajo;
	}

	public BigInteger getIdCompania() {
		return idCompania;
	}

	public void setIdCompania(BigInteger idCompania) {
		this.idCompania = idCompania;
	}

	public String getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(String periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public String getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(String periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public BigInteger getIdLabor() {
		return idLabor;
	}

	public void setIdLabor(BigInteger idLabor) {
		this.idLabor = idLabor;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public BigInteger getIdZona() {
		return idZona;
	}

	public void setIdZona(BigInteger idZona) {
		this.idZona = idZona;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public BigInteger getIdFinca() {
		return idFinca;
	}

	public void setIdFinca(BigInteger idFinca) {
		this.idFinca = idFinca;
	}

	public String getNombreFinca() {
		return nombreFinca;
	}

	public void setNombreFinca(String nombreFinca) {
		this.nombreFinca = nombreFinca;
	}

	public BigInteger getIdBloque() {
		return idBloque;
	}

	public void setIdBloque(BigInteger idBloque) {
		this.idBloque = idBloque;
	}

	public String getNombreBloque() {
		return nombreBloque;
	}

	public void setNombreBloque(String nombreBloque) {
		this.nombreBloque = nombreBloque;
	}

	public BigInteger getIdLote() {
		return idLote;
	}

	public void setIdLote(BigInteger idLote) {
		this.idLote = idLote;
	}

	public String getNombreLote() {
		return nombreLote;
	}

	public void setNombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}

	public String getCodigoTrabajador() {
		return codigoTrabajador;
	}

	public void setCodigoTrabajador(String codigoTrabajador) {
		this.codigoTrabajador = codigoTrabajador;
	}

	public BigDecimal getCantidadPlaneada() {
		return cantidadPlaneada;
	}

	public void setCantidadPlaneada(BigDecimal cantidadPlaneada) {
		this.cantidadPlaneada = cantidadPlaneada;
	}

	public BigDecimal getNumeroPases() {
		return numeroPases;
	}

	public void setNumeroPases(BigDecimal numeroPases) {
		this.numeroPases = numeroPases;
	}

	public BigInteger getCodigoUnidadMedida() {
		return codigoUnidadMedida;
	}

	public void setCodigoUnidadMedida(BigInteger codigoUnidadMedida) {
		this.codigoUnidadMedida = codigoUnidadMedida;
	}

	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

}
