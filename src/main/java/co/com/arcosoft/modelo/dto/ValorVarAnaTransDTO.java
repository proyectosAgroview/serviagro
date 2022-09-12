package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class ValorVarAnaTransDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ValorVarAnaTransDTO.class);
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String valor;
	private Long valorVarAnaTransId;
	private Long datAnaTransProdId_DatAnaTransProd;
	private Long variableLabId_VariableLab;

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

	public Long getValorVarAnaTransId() {
		return valorVarAnaTransId;
	}

	public void setValorVarAnaTransId(Long valorVarAnaTransId) {
		this.valorVarAnaTransId = valorVarAnaTransId;
	}

	public Long getDatAnaTransProdId_DatAnaTransProd() {
		return datAnaTransProdId_DatAnaTransProd;
	}

	public void setDatAnaTransProdId_DatAnaTransProd(Long datAnaTransProdId_DatAnaTransProd) {
		this.datAnaTransProdId_DatAnaTransProd = datAnaTransProdId_DatAnaTransProd;
	}

	public Long getVariableLabId_VariableLab() {
		return variableLabId_VariableLab;
	}

	public void setVariableLabId_VariableLab(Long variableLabId_VariableLab) {
		this.variableLabId_VariableLab = variableLabId_VariableLab;
	}
}
