package co.com.arcosoft.modelo.informes.dto;

import java.math.BigInteger;

public class ListaNivel2ClientesmqDTO {

	private BigInteger id;
	private String hacienda;
	private String cod_cliente;
	private String nom_cliente;
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
	 * @return the hacienda
	 */
	public String getHacienda() {
		return hacienda;
	}
	/**
	 * @param hacienda the hacienda to set
	 */
	public void setHacienda(String hacienda) {
		this.hacienda = hacienda;
	}
	/**
	 * @return the cod_cliente
	 */
	public String getCod_cliente() {
		return cod_cliente;
	}
	/**
	 * @param cod_cliente the cod_cliente to set
	 */
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	/**
	 * @return the nom_cliente
	 */
	public String getNom_cliente() {
		return nom_cliente;
	}
	/**
	 * @param nom_cliente the nom_cliente to set
	 */
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	
	
	
	
}
