package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ListaNivel4DTO {

	private BigInteger nivel1_id;
	private BigInteger nivel2_id;
	private String  cod_nivel2;
	private String  nom_nivel2;
	private BigInteger nivel3_id;
	private BigInteger nivel4_id;
	private String  cod_nivel4;
	private String  nom_nivel4;
	private String lote;
	private BigDecimal area_neta;
	private BigDecimal num_plantas_sembradas;
	private String codigoProveedor;
	private String nombreProveedor;
	private String codigoErp;
	private BigInteger cantidadTablones;
	
	private String codEtapa;
	private String nomEtapa;
	private BigDecimal numeroCosechas;
	private BigInteger etapaId;
	
	
	
	
	
	public BigInteger getEtapaId() {
		return etapaId;
	}
	public void setEtapaId(BigInteger etapaId) {
		this.etapaId = etapaId;
	}
	public String getCodEtapa() {
		return codEtapa;
	}
	public void setCodEtapa(String codEtapa) {
		this.codEtapa = codEtapa;
	}
	public String getNomEtapa() {
		return nomEtapa;
	}
	public void setNomEtapa(String nomEtapa) {
		this.nomEtapa = nomEtapa;
	}
	public BigDecimal getNumeroCosechas() {
		return numeroCosechas;
	}
	public void setNumeroCosechas(BigDecimal numeroCosechas) {
		this.numeroCosechas = numeroCosechas;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	/**
	 * @return the nivel1_id
	 */
	public BigInteger getNivel1_id() {
		return nivel1_id;
	}
	/**
	 * @param nivel1_id the nivel1_id to set
	 */
	public void setNivel1_id(BigInteger nivel1_id) {
		this.nivel1_id = nivel1_id;
	}
	/**
	 * @return the nivel2_id
	 */
	public BigInteger getNivel2_id() {
		return nivel2_id;
	}
	/**
	 * @param nivel2_id the nivel2_id to set
	 */
	public void setNivel2_id(BigInteger nivel2_id) {
		this.nivel2_id = nivel2_id;
	}
	/**
	 * @return the cod_nivel2
	 */
	public String getCod_nivel2() {
		return cod_nivel2;
	}
	/**
	 * @param cod_nivel2 the cod_nivel2 to set
	 */
	public void setCod_nivel2(String cod_nivel2) {
		this.cod_nivel2 = cod_nivel2;
	}
	/**
	 * @return the nom_nivel2
	 */
	public String getNom_nivel2() {
		return nom_nivel2;
	}
	/**
	 * @param nom_nivel2 the nom_nivel2 to set
	 */
	public void setNom_nivel2(String nom_nivel2) {
		this.nom_nivel2 = nom_nivel2;
	}
	/**
	 * @return the nivel3_id
	 */
	public BigInteger getNivel3_id() {
		return nivel3_id;
	}
	/**
	 * @param nivel3_id the nivel3_id to set
	 */
	public void setNivel3_id(BigInteger nivel3_id) {
		this.nivel3_id = nivel3_id;
	}
	/**
	 * @return the nivel4_id
	 */
	public BigInteger getNivel4_id() {
		return nivel4_id;
	}
	/**
	 * @param nivel4_id the nivel4_id to set
	 */
	public void setNivel4_id(BigInteger nivel4_id) {
		this.nivel4_id = nivel4_id;
	}
	/**
	 * @return the cod_nivel4
	 */
	public String getCod_nivel4() {
		return cod_nivel4;
	}
	/**
	 * @param cod_nivel4 the cod_nivel4 to set
	 */
	public void setCod_nivel4(String cod_nivel4) {
		this.cod_nivel4 = cod_nivel4;
	}
	/**
	 * @return the nom_nivel4
	 */
	public String getNom_nivel4() {
		return nom_nivel4;
	}
	/**
	 * @param nom_nivel4 the nom_nivel4 to set
	 */
	public void setNom_nivel4(String nom_nivel4) {
		this.nom_nivel4 = nom_nivel4;
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
	 * @return the area_neta
	 */
	public BigDecimal getArea_neta() {
		return area_neta;
	}
	/**
	 * @param area_neta the area_neta to set
	 */
	public void setArea_neta(BigDecimal area_neta) {
		this.area_neta = area_neta;
	}
	/**
	 * @return the num_plantas_sembradas
	 */
	public BigDecimal getNum_plantas_sembradas() {
		return num_plantas_sembradas;
	}
	/**
	 * @param num_plantas_sembradas the num_plantas_sembradas to set
	 */
	public void setNum_plantas_sembradas(BigDecimal num_plantas_sembradas) {
		this.num_plantas_sembradas = num_plantas_sembradas;
	}
	public String getCodigoErp() {
		return codigoErp;
	}
	public void setCodigoErp(String codigoErp) {
		this.codigoErp = codigoErp;
	}
	public BigInteger getCantidadTablones() {
		return cantidadTablones;
	}
	public void setCantidadTablones(BigInteger cantidadTablones) {
		this.cantidadTablones = cantidadTablones;
	}
	
	
		
}
