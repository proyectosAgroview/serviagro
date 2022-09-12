package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ListaVariablesAnaLaboratorioDTO {

	private BigInteger idAnalisis;
	private String  nombreAnalisis;
	private BigInteger idVariable;
	private String codVariable;
	private String nomVariable;
	private BigInteger orden;
	private String tipoVariable;
	private String formula;
	private BigInteger companiaId;
	private BigDecimal valorVariableDia;
	private BigDecimal valorVariableHora1;
	private BigDecimal valorVariableHora2;
	private BigDecimal valorVariableHora3;
	private BigDecimal valorVariableHora4;
	private BigDecimal valorVariableHora5;
	
	private BigDecimal valorVariableHora6;
	private BigDecimal valorVariableHora7;
	private BigDecimal valorVariableHora8;
	private BigDecimal valorVariableHora9;
	private BigDecimal valorVariableHora10;
	private BigDecimal valorVariableHora11;
	private BigDecimal valorVariableHora12;
	private BigDecimal valorVariableHora13;
	private BigDecimal valorVariableHora14;
	private BigDecimal valorVariableHora15;
	private BigDecimal valorVariableHora16;
	private BigDecimal valorVariableHora17;
	private BigDecimal valorVariableHora18;
	private BigDecimal valorVariableHora19;
	private BigDecimal valorVariableHora20;
	private BigDecimal valorVariableHora21;
	private BigDecimal valorVariableHora22;
	private BigDecimal valorVariableHora23;
	private BigDecimal valorVariableHora0;
	
	private String horaDigitacion;
	private String frecuenciaDigitacion;
	 private String variableTexto;
	    private String observacion;
	private String clasificacionTexto;
	private Date fechaAnalisis;

	private String estado;
	private BigInteger dat_ana_lab_id;

	    
	    
	
	
	
	
	
	
	
	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}
	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public BigInteger getDat_ana_lab_id() {
		return dat_ana_lab_id;
	}
	public void setDat_ana_lab_id(BigInteger dat_ana_lab_id) {
		this.dat_ana_lab_id = dat_ana_lab_id;
	}
	public String getClasificacionTexto() {
		return clasificacionTexto;
	}
	public void setClasificacionTexto(String clasificacionTexto) {
		this.clasificacionTexto = clasificacionTexto;
	}
	public String getVariableTexto() {
			return variableTexto;
		}
		public void setVariableTexto(String variableTexto) {
			this.variableTexto = variableTexto;
		}
		public String getObservacion() {
			return observacion;
		}
		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}
	/**
	 * @return the horaDigitacion
	 */
	public String getHoraDigitacion() {
		return horaDigitacion;
	}
	/**
	 * @param horaDigitacion the horaDigitacion to set
	 */
	public void setHoraDigitacion(String horaDigitacion) {
		this.horaDigitacion = horaDigitacion;
	}
	/**
	 * @return the frecuenciaDigitacion
	 */
	public String getFrecuenciaDigitacion() {
		return frecuenciaDigitacion;
	}
	/**
	 * @param frecuenciaDigitacion the frecuenciaDigitacion to set
	 */
	public void setFrecuenciaDigitacion(String frecuenciaDigitacion) {
		this.frecuenciaDigitacion = frecuenciaDigitacion;
	}
	/**
	 * @return the valorVariableHora6
	 */
	public BigDecimal getValorVariableHora6() {
		return valorVariableHora6;
	}
	/**
	 * @param valorVariableHora6 the valorVariableHora6 to set
	 */
	public void setValorVariableHora6(BigDecimal valorVariableHora6) {
		this.valorVariableHora6 = valorVariableHora6;
	}
	/**
	 * @return the valorVariableHora7
	 */
	public BigDecimal getValorVariableHora7() {
		return valorVariableHora7;
	}
	/**
	 * @param valorVariableHora7 the valorVariableHora7 to set
	 */
	public void setValorVariableHora7(BigDecimal valorVariableHora7) {
		this.valorVariableHora7 = valorVariableHora7;
	}
	/**
	 * @return the valorVariableHora8
	 */
	public BigDecimal getValorVariableHora8() {
		return valorVariableHora8;
	}
	/**
	 * @param valorVariableHora8 the valorVariableHora8 to set
	 */
	public void setValorVariableHora8(BigDecimal valorVariableHora8) {
		this.valorVariableHora8 = valorVariableHora8;
	}
	/**
	 * @return the valorVariableHora9
	 */
	public BigDecimal getValorVariableHora9() {
		return valorVariableHora9;
	}
	/**
	 * @param valorVariableHora9 the valorVariableHora9 to set
	 */
	public void setValorVariableHora9(BigDecimal valorVariableHora9) {
		this.valorVariableHora9 = valorVariableHora9;
	}
	/**
	 * @return the valorVariableHora10
	 */
	public BigDecimal getValorVariableHora10() {
		return valorVariableHora10;
	}
	/**
	 * @param valorVariableHora10 the valorVariableHora10 to set
	 */
	public void setValorVariableHora10(BigDecimal valorVariableHora10) {
		this.valorVariableHora10 = valorVariableHora10;
	}
	/**
	 * @return the valorVariableHora11
	 */
	public BigDecimal getValorVariableHora11() {
		return valorVariableHora11;
	}
	/**
	 * @param valorVariableHora11 the valorVariableHora11 to set
	 */
	public void setValorVariableHora11(BigDecimal valorVariableHora11) {
		this.valorVariableHora11 = valorVariableHora11;
	}
	/**
	 * @return the valorVariableHora12
	 */
	public BigDecimal getValorVariableHora12() {
		return valorVariableHora12;
	}
	/**
	 * @param valorVariableHora12 the valorVariableHora12 to set
	 */
	public void setValorVariableHora12(BigDecimal valorVariableHora12) {
		this.valorVariableHora12 = valorVariableHora12;
	}
	/**
	 * @return the valorVariableHora13
	 */
	public BigDecimal getValorVariableHora13() {
		return valorVariableHora13;
	}
	/**
	 * @param valorVariableHora13 the valorVariableHora13 to set
	 */
	public void setValorVariableHora13(BigDecimal valorVariableHora13) {
		this.valorVariableHora13 = valorVariableHora13;
	}
	/**
	 * @return the valorVariableHora14
	 */
	public BigDecimal getValorVariableHora14() {
		return valorVariableHora14;
	}
	/**
	 * @param valorVariableHora14 the valorVariableHora14 to set
	 */
	public void setValorVariableHora14(BigDecimal valorVariableHora14) {
		this.valorVariableHora14 = valorVariableHora14;
	}
	/**
	 * @return the valorVariableHora15
	 */
	public BigDecimal getValorVariableHora15() {
		return valorVariableHora15;
	}
	/**
	 * @param valorVariableHora15 the valorVariableHora15 to set
	 */
	public void setValorVariableHora15(BigDecimal valorVariableHora15) {
		this.valorVariableHora15 = valorVariableHora15;
	}
	/**
	 * @return the valorVariableHora16
	 */
	public BigDecimal getValorVariableHora16() {
		return valorVariableHora16;
	}
	/**
	 * @param valorVariableHora16 the valorVariableHora16 to set
	 */
	public void setValorVariableHora16(BigDecimal valorVariableHora16) {
		this.valorVariableHora16 = valorVariableHora16;
	}
	/**
	 * @return the valorVariableHora17
	 */
	public BigDecimal getValorVariableHora17() {
		return valorVariableHora17;
	}
	/**
	 * @param valorVariableHora17 the valorVariableHora17 to set
	 */
	public void setValorVariableHora17(BigDecimal valorVariableHora17) {
		this.valorVariableHora17 = valorVariableHora17;
	}
	/**
	 * @return the valorVariableHora18
	 */
	public BigDecimal getValorVariableHora18() {
		return valorVariableHora18;
	}
	/**
	 * @param valorVariableHora18 the valorVariableHora18 to set
	 */
	public void setValorVariableHora18(BigDecimal valorVariableHora18) {
		this.valorVariableHora18 = valorVariableHora18;
	}
	/**
	 * @return the valorVariableHora19
	 */
	public BigDecimal getValorVariableHora19() {
		return valorVariableHora19;
	}
	/**
	 * @param valorVariableHora19 the valorVariableHora19 to set
	 */
	public void setValorVariableHora19(BigDecimal valorVariableHora19) {
		this.valorVariableHora19 = valorVariableHora19;
	}
	/**
	 * @return the valorVariableHora20
	 */
	public BigDecimal getValorVariableHora20() {
		return valorVariableHora20;
	}
	/**
	 * @param valorVariableHora20 the valorVariableHora20 to set
	 */
	public void setValorVariableHora20(BigDecimal valorVariableHora20) {
		this.valorVariableHora20 = valorVariableHora20;
	}
	/**
	 * @return the valorVariableHora21
	 */
	public BigDecimal getValorVariableHora21() {
		return valorVariableHora21;
	}
	/**
	 * @param valorVariableHora21 the valorVariableHora21 to set
	 */
	public void setValorVariableHora21(BigDecimal valorVariableHora21) {
		this.valorVariableHora21 = valorVariableHora21;
	}
	/**
	 * @return the valorVariableHora22
	 */
	public BigDecimal getValorVariableHora22() {
		return valorVariableHora22;
	}
	/**
	 * @param valorVariableHora22 the valorVariableHora22 to set
	 */
	public void setValorVariableHora22(BigDecimal valorVariableHora22) {
		this.valorVariableHora22 = valorVariableHora22;
	}
	/**
	 * @return the valorVariableHora23
	 */
	public BigDecimal getValorVariableHora23() {
		return valorVariableHora23;
	}
	/**
	 * @param valorVariableHora23 the valorVariableHora23 to set
	 */
	public void setValorVariableHora23(BigDecimal valorVariableHora23) {
		this.valorVariableHora23 = valorVariableHora23;
	}
	/**
	 * @return the valorVariableHora0
	 */
	public BigDecimal getValorVariableHora0() {
		return valorVariableHora0;
	}
	/**
	 * @param valorVariableHora0 the valorVariableHora0 to set
	 */
	public void setValorVariableHora0(BigDecimal valorVariableHora0) {
		this.valorVariableHora0 = valorVariableHora0;
	}
	/**
	 * @return the valorVariableDia
	 */
	public BigDecimal getValorVariableDia() {
		return valorVariableDia;
	}
	/**
	 * @param valorVariableDia the valorVariableDia to set
	 */
	public void setValorVariableDia(BigDecimal valorVariableDia) {
		this.valorVariableDia = valorVariableDia;
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
	public BigInteger getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(BigInteger orden) {
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
	/**
	 * @return the valorVariableHora1
	 */
	public BigDecimal getValorVariableHora1() {
		return valorVariableHora1;
	}
	/**
	 * @param valorVariableHora1 the valorVariableHora1 to set
	 */
	public void setValorVariableHora1(BigDecimal valorVariableHora1) {
		this.valorVariableHora1 = valorVariableHora1;
	}
	/**
	 * @return the valorVariableHora2
	 */
	public BigDecimal getValorVariableHora2() {
		return valorVariableHora2;
	}
	/**
	 * @param valorVariableHora2 the valorVariableHora2 to set
	 */
	public void setValorVariableHora2(BigDecimal valorVariableHora2) {
		this.valorVariableHora2 = valorVariableHora2;
	}
	/**
	 * @return the valorVariableHora3
	 */
	public BigDecimal getValorVariableHora3() {
		return valorVariableHora3;
	}
	/**
	 * @param valorVariableHora3 the valorVariableHora3 to set
	 */
	public void setValorVariableHora3(BigDecimal valorVariableHora3) {
		this.valorVariableHora3 = valorVariableHora3;
	}
	/**
	 * @return the valorVariableHora4
	 */
	public BigDecimal getValorVariableHora4() {
		return valorVariableHora4;
	}
	/**
	 * @param valorVariableHora4 the valorVariableHora4 to set
	 */
	public void setValorVariableHora4(BigDecimal valorVariableHora4) {
		this.valorVariableHora4 = valorVariableHora4;
	}
	/**
	 * @return the valorVariableHora5
	 */
	public BigDecimal getValorVariableHora5() {
		return valorVariableHora5;
	}
	/**
	 * @param valorVariableHora5 the valorVariableHora5 to set
	 */
	public void setValorVariableHora5(BigDecimal valorVariableHora5) {
		this.valorVariableHora5 = valorVariableHora5;
	}
	
	
	
}
