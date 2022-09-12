package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class AnalisisProcesoIndustrialDTO {

	private	BigInteger	dat_ana_lab_id	;
	private	BigInteger	consecutivo	;
	private	String	cod_analisis	;
	private	String	nom_grupo_analisis	;
	private	String	cod_variable	;
	private	String	nom_variable	;
	private	BigInteger	orden_digitacion	;
	private	String	tipo_variable	;
	private	Date	fecha_analisis	;
	private	String	horas	;
	private	BigDecimal	valor_variable	;
	private	String	zona	;
	private	String	cod_finca	;
	private	String	finca	;
	private	String	bloque	;
	private	String	lote	;
	private	BigDecimal	anio	;
	private	BigDecimal	mes	;
	private	String	anio_mes	;
	private	BigDecimal	nro_ticket	;
	private	String	tipoValor	;
	private	String	tipoAcumulado	;
	
	
	
	public String getTipoValor() {
		return tipoValor;
	}
	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}
	public String getTipoAcumulado() {
		return tipoAcumulado;
	}
	public void setTipoAcumulado(String tipoAcumulado) {
		this.tipoAcumulado = tipoAcumulado;
	}
	/**
	 * @return the dat_ana_lab_id
	 */
	public BigInteger getDat_ana_lab_id() {
		return dat_ana_lab_id;
	}
	/**
	 * @param dat_ana_lab_id the dat_ana_lab_id to set
	 */
	public void setDat_ana_lab_id(BigInteger dat_ana_lab_id) {
		this.dat_ana_lab_id = dat_ana_lab_id;
	}
	/**
	 * @return the consecutivo
	 */
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	/**
	 * @return the cod_analisis
	 */
	public String getCod_analisis() {
		return cod_analisis;
	}
	/**
	 * @param cod_analisis the cod_analisis to set
	 */
	public void setCod_analisis(String cod_analisis) {
		this.cod_analisis = cod_analisis;
	}
	/**
	 * @return the nom_grupo_analisis
	 */
	public String getNom_grupo_analisis() {
		return nom_grupo_analisis;
	}
	/**
	 * @param nom_grupo_analisis the nom_grupo_analisis to set
	 */
	public void setNom_grupo_analisis(String nom_grupo_analisis) {
		this.nom_grupo_analisis = nom_grupo_analisis;
	}
	/**
	 * @return the cod_variable
	 */
	public String getCod_variable() {
		return cod_variable;
	}
	/**
	 * @param cod_variable the cod_variable to set
	 */
	public void setCod_variable(String cod_variable) {
		this.cod_variable = cod_variable;
	}
	/**
	 * @return the nom_variable
	 */
	public String getNom_variable() {
		return nom_variable;
	}
	/**
	 * @param nom_variable the nom_variable to set
	 */
	public void setNom_variable(String nom_variable) {
		this.nom_variable = nom_variable;
	}
	/**
	 * @return the orden_digitacion
	 */
	public BigInteger getOrden_digitacion() {
		return orden_digitacion;
	}
	/**
	 * @param orden_digitacion the orden_digitacion to set
	 */
	public void setOrden_digitacion(BigInteger orden_digitacion) {
		this.orden_digitacion = orden_digitacion;
	}
	/**
	 * @return the tipo_variable
	 */
	public String getTipo_variable() {
		return tipo_variable;
	}
	/**
	 * @param tipo_variable the tipo_variable to set
	 */
	public void setTipo_variable(String tipo_variable) {
		this.tipo_variable = tipo_variable;
	}
	/**
	 * @return the fecha_analisis
	 */
	public Date getFecha_analisis() {
		return fecha_analisis;
	}
	/**
	 * @param fecha_analisis the fecha_analisis to set
	 */
	public void setFecha_analisis(Date fecha_analisis) {
		this.fecha_analisis = fecha_analisis;
	}
	/**
	 * @return the horas
	 */
	public String getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(String horas) {
		this.horas = horas;
	}
	/**
	 * @return the valor_variable
	 */
	public BigDecimal getValor_variable() {
		return valor_variable;
	}
	/**
	 * @param valor_variable the valor_variable to set
	 */
	public void setValor_variable(BigDecimal valor_variable) {
		this.valor_variable = valor_variable;
	}
	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}
	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}
	/**
	 * @return the cod_finca
	 */
	public String getCod_finca() {
		return cod_finca;
	}
	/**
	 * @param cod_finca the cod_finca to set
	 */
	public void setCod_finca(String cod_finca) {
		this.cod_finca = cod_finca;
	}
	/**
	 * @return the finca
	 */
	public String getFinca() {
		return finca;
	}
	/**
	 * @param finca the finca to set
	 */
	public void setFinca(String finca) {
		this.finca = finca;
	}
	/**
	 * @return the bloque
	 */
	public String getBloque() {
		return bloque;
	}
	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}
	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	/**
	 * @return the anio
	 */
	public BigDecimal getAnio() {
		return anio;
	}
	/**
	 * @param anio the anio to set
	 */
	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}
	/**
	 * @return the mes
	 */
	public BigDecimal getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}
	/**
	 * @return the anio_mes
	 */
	public String getAnio_mes() {
		return anio_mes;
	}
	/**
	 * @param anio_mes the anio_mes to set
	 */
	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}
	/**
	 * @return the nro_ticket
	 */
	public BigDecimal getNro_ticket() {
		return nro_ticket;
	}
	/**
	 * @param nro_ticket the nro_ticket to set
	 */
	public void setNro_ticket(BigDecimal nro_ticket) {
		this.nro_ticket = nro_ticket;
	}

	
	
}
