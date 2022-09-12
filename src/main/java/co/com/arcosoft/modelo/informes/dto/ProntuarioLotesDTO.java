package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProntuarioLotesDTO {
	private String codZona;
	private String nomFinca;
	private String codBloque;
	private String loteA;
	private String fechaUltCorte;
	private BigInteger nCortes;
	private BigDecimal area;
	private BigDecimal tchEstimado;
	private BigDecimal edadUltCorte;
	private String edadHoy;
	private BigDecimal distSiembra;
	private String fechaEstCorte;
	private String nomTenencia;
	private String zonaAgroeC;
	private BigDecimal tchmUltCorte;
	private String variedad;
	private BigDecimal rendimiento;
	private BigDecimal tchUltCorte;
	private String fechaSiembra;
	private String nomLote;
	private BigDecimal numPlantasActuales;
	private String codProveedor;
	private String nomProveedor;
	private String codFinca;
	private BigInteger nivel4ClientesMqId;
	private BigInteger nivel2ClientesMqId;
	
	
	
	

	public BigInteger getNivel2ClientesMqId() {
		return nivel2ClientesMqId;
	}

	public void setNivel2ClientesMqId(BigInteger nivel2ClientesMqId) {
		this.nivel2ClientesMqId = nivel2ClientesMqId;
	}

	public BigInteger getNivel4ClientesMqId() {
		return nivel4ClientesMqId;
	}

	public void setNivel4ClientesMqId(BigInteger nivel4ClientesMqId) {
		this.nivel4ClientesMqId = nivel4ClientesMqId;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public BigDecimal getNumPlantasActuales() {
		return numPlantasActuales;
	}

	public void setNumPlantasActuales(BigDecimal numPlantasActuales) {
		this.numPlantasActuales = numPlantasActuales;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public String getFechaSiembra() {
		return fechaSiembra;
	}

	public void setFechaSiembra(String fechaSiembra) {
		this.fechaSiembra = fechaSiembra;
	}

	public BigDecimal getTchUltCorte() {
		return tchUltCorte;
	}

	public void setTchUltCorte(BigDecimal tchUltCorte) {
		this.tchUltCorte = tchUltCorte;
	}

	public BigDecimal getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}

	public BigDecimal getTchmUltCorte() {
		return tchmUltCorte;
	}

	public void setTchmUltCorte(BigDecimal tchmUltCorte) {
		this.tchmUltCorte = tchmUltCorte;
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

	public BigInteger getnCortes() {
		return nCortes;
	}

	public void setnCortes(BigInteger nCortes) {
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

	public String getEdadHoy() {
		return edadHoy;
	}

	public void setEdadHoy(String edadHoy) {
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
