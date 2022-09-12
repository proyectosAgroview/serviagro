package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Fitosanidad;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class ValorVarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ValorVarDTO.class);
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String valor;
	private Long valorVarId;
	private Long datSanVegId_DatSanVeg;
	private Long variableId_Variable;

	private Double variable1;
	private Double variable2;
	private Double variable3;
	private Double variable4;
	private Double variable5;
	private Double variable6;
	private Double variable7;
	private Double variable8;
	private Double variable9;
	private Double variable10;
	private String variableText1;
	private String variableText2;
	private String variableText3;
	private String variableText4;
	private String variableText5;
	private String variableText6;
	private String variableText7;
	private String variableText8;
	private String variableText9;
	private String variableText10;
	private Date variableDate1;

	private Fitosanidad fitosanidad;
	private String nombreFitosanidad;
	private String nombreVariable;
	
	
	
	/**
	 * @return the nombreVariable
	 */
	public String getNombreVariable() {
		return nombreVariable;
	}

	/**
	 * @param nombreVariable the nombreVariable to set
	 */
	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}

	public String getNombreFitosanidad() {
		return nombreFitosanidad;
	}

	public void setNombreFitosanidad(String nombreFitosanidad) {
		this.nombreFitosanidad = nombreFitosanidad;
	}

	public Fitosanidad getFitosanidad() {
		return fitosanidad;
	}

	public void setFitosanidad(Fitosanidad fitosanidad) {
		this.fitosanidad = fitosanidad;
	}

	public Double getVariable1() {
		return variable1;
	}

	public void setVariable1(Double variable1) {
		this.variable1 = variable1;
	}

	public Double getVariable2() {
		return variable2;
	}

	public void setVariable2(Double variable2) {
		this.variable2 = variable2;
	}

	public Double getVariable3() {
		return variable3;
	}

	public void setVariable3(Double variable3) {
		this.variable3 = variable3;
	}

	public Double getVariable4() {
		return variable4;
	}

	public void setVariable4(Double variable4) {
		this.variable4 = variable4;
	}

	public Double getVariable5() {
		return variable5;
	}

	public void setVariable5(Double variable5) {
		this.variable5 = variable5;
	}

	public Double getVariable6() {
		return variable6;
	}

	public void setVariable6(Double variable6) {
		this.variable6 = variable6;
	}

	public Double getVariable7() {
		return variable7;
	}

	public void setVariable7(Double variable7) {
		this.variable7 = variable7;
	}

	public Double getVariable8() {
		return variable8;
	}

	public void setVariable8(Double variable8) {
		this.variable8 = variable8;
	}

	public Double getVariable9() {
		return variable9;
	}

	public void setVariable9(Double variable9) {
		this.variable9 = variable9;
	}

	public Double getVariable10() {
		return variable10;
	}

	public void setVariable10(Double variable10) {
		this.variable10 = variable10;
	}

	public String getVariableText1() {
		return variableText1;
	}

	public void setVariableText1(String variableText1) {
		this.variableText1 = variableText1;
	}

	public String getVariableText2() {
		return variableText2;
	}

	public void setVariableText2(String variableText2) {
		this.variableText2 = variableText2;
	}

	public String getVariableText3() {
		return variableText3;
	}

	public void setVariableText3(String variableText3) {
		this.variableText3 = variableText3;
	}

	public String getVariableText4() {
		return variableText4;
	}

	public void setVariableText4(String variableText4) {
		this.variableText4 = variableText4;
	}

	public String getVariableText5() {
		return variableText5;
	}

	public void setVariableText5(String variableText5) {
		this.variableText5 = variableText5;
	}

	public String getVariableText6() {
		return variableText6;
	}

	public void setVariableText6(String variableText6) {
		this.variableText6 = variableText6;
	}

	public String getVariableText7() {
		return variableText7;
	}

	public void setVariableText7(String variableText7) {
		this.variableText7 = variableText7;
	}

	public String getVariableText8() {
		return variableText8;
	}

	public void setVariableText8(String variableText8) {
		this.variableText8 = variableText8;
	}

	public String getVariableText9() {
		return variableText9;
	}

	public void setVariableText9(String variableText9) {
		this.variableText9 = variableText9;
	}

	public String getVariableText10() {
		return variableText10;
	}

	public void setVariableText10(String variableText10) {
		this.variableText10 = variableText10;
	}

	public Date getVariableDate1() {
		return variableDate1;
	}

	public void setVariableDate1(Date variableDate1) {
		this.variableDate1 = variableDate1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getValorVarId() {
		return valorVarId;
	}

	public void setValorVarId(Long valorVarId) {
		this.valorVarId = valorVarId;
	}

	public Long getDatSanVegId_DatSanVeg() {
		return datSanVegId_DatSanVeg;
	}

	public void setDatSanVegId_DatSanVeg(Long datSanVegId_DatSanVeg) {
		this.datSanVegId_DatSanVeg = datSanVegId_DatSanVeg;
	}

	public Long getVariableId_Variable() {
		return variableId_Variable;
	}

	public void setVariableId_Variable(Long variableId_Variable) {
		this.variableId_Variable = variableId_Variable;
	}
}
