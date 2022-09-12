package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaDiferidosDTO {

	private BigInteger consecutivo;
	private Date fechaRegistro;
	private BigDecimal valorInicial;
	private BigDecimal valorCuota;
	private BigInteger periodos;
	private String detalleNota;
	private BigDecimal anio;
	private BigDecimal mes;
	private String observacion;
	private String nomZona;
	private String codHacienda;
	private String nomHacienda;
	private String codBloque;
	private String nomBloque;
	private String codLote;
	private String nomLote;
	private String numeroFactura;
	private Date fecha;
	private String codGasto;
	private String nomGasto;
	private String anioMes;
	

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public BigDecimal getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(BigDecimal valorCuota) {
		this.valorCuota = valorCuota;
	}

	public BigInteger getPeriodos() {
		return periodos;
	}

	public void setPeriodos(BigInteger periodos) {
		this.periodos = periodos;
	}

	public String getDetalleNota() {
		return detalleNota;
	}

	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNomZona() {
		return nomZona;
	}

	public void setNomZona(String nomZona) {
		this.nomZona = nomZona;
	}

	public String getCodHacienda() {
		return codHacienda;
	}

	public void setCodHacienda(String codHacienda) {
		this.codHacienda = codHacienda;
	}

	public String getNomHacienda() {
		return nomHacienda;
	}

	public void setNomHacienda(String nomHacienda) {
		this.nomHacienda = nomHacienda;
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

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodGasto() {
		return codGasto;
	}

	public void setCodGasto(String codGasto) {
		this.codGasto = codGasto;
	}

	public String getNomGasto() {
		return nomGasto;
	}

	public void setNomGasto(String nomGasto) {
		this.nomGasto = nomGasto;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

}
