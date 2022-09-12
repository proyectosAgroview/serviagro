package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ListaVariablesSanidadDTO {

	private BigInteger idAnalisis;
	private String  nombreAnalisis;
	private BigInteger idVariable;
	private String codVariable;
	private String nomVariable;
	private Short orden;
	private String tipoVariable;
	private String formula;
	private BigInteger companiaId;
	private BigDecimal valorVariable;
	
	
	/**
	 * @return the valorVariable
	 */
	public BigDecimal getValorVariable() {
		return valorVariable;
	}
	/**
	 * @param valorVariable the valorVariable to set
	 */
	public void setValorVariable(BigDecimal valorVariable) {
		this.valorVariable = valorVariable;
	}
	/**
	 * @return the idAnalisis
	 */
	public BigInteger getIdAnalisis() {
		return idAnalisis;
	}
	/**
	 * @param idAnalisis the idAnalisis to set
	 */
	public void setIdAnalisis(BigInteger idAnalisis) {
		this.idAnalisis = idAnalisis;
	}
	/**
	 * @return the nombreAnalisis
	 */
	public String getNombreAnalisis() {
		return nombreAnalisis;
	}
	/**
	 * @param nombreAnalisis the nombreAnalisis to set
	 */
	public void setNombreAnalisis(String nombreAnalisis) {
		this.nombreAnalisis = nombreAnalisis;
	}
	/**
	 * @return the idVariable
	 */
	public BigInteger getIdVariable() {
		return idVariable;
	}
	/**
	 * @param idVariable the idVariable to set
	 */
	public void setIdVariable(BigInteger idVariable) {
		this.idVariable = idVariable;
	}
	/**
	 * @return the codVariable
	 */
	public String getCodVariable() {
		return codVariable;
	}
	/**
	 * @param codVariable the codVariable to set
	 */
	public void setCodVariable(String codVariable) {
		this.codVariable = codVariable;
	}
	/**
	 * @return the nomVariable
	 */
	public String getNomVariable() {
		return nomVariable;
	}
	/**
	 * @param nomVariable the nomVariable to set
	 */
	public void setNomVariable(String nomVariable) {
		this.nomVariable = nomVariable;
	}
	/**
	 * @return the orden
	 */
	public Short getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Short orden) {
		this.orden = orden;
	}
	/**
	 * @return the tipoVariable
	 */
	public String getTipoVariable() {
		return tipoVariable;
	}
	/**
	 * @param tipoVariable the tipoVariable to set
	 */
	public void setTipoVariable(String tipoVariable) {
		this.tipoVariable = tipoVariable;
	}
	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}
	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}
	/**
	 * @return the companiaId
	 */
	public BigInteger getCompaniaId() {
		return companiaId;
	}
	/**
	 * @param companiaId the companiaId to set
	 */
	public void setCompaniaId(BigInteger companiaId) {
		this.companiaId = companiaId;
	}
	
	
	
}
