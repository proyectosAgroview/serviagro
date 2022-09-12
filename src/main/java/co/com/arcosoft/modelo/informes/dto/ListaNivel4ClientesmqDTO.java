package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ListaNivel4ClientesmqDTO {

	private BigInteger id;
	private String lote;
	private String cod_hda;
	private String nom_hda;
	private BigDecimal area;
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
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
	 * @return the cod_hda
	 */
	public String getCod_hda() {
		return cod_hda;
	}
	/**
	 * @param cod_hda the cod_hda to set
	 */
	public void setCod_hda(String cod_hda) {
		this.cod_hda = cod_hda;
	}
	/**
	 * @return the nom_hda
	 */
	public String getNom_hda() {
		return nom_hda;
	}
	/**
	 * @param nom_hda the nom_hda to set
	 */
	public void setNom_hda(String nom_hda) {
		this.nom_hda = nom_hda;
	}
	/**
	 * @return the area
	 */
	public BigDecimal getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	
	
}
