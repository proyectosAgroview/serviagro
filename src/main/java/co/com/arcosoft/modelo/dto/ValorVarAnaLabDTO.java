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
public class ValorVarAnaLabDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ValorVarAnaLabDTO.class);
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String valor;
	private Long valorVarAnaLabId;
	private Long datAnaLabId_DatAnaLaboratorio;
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

	public Long getValorVarAnaLabId() {
		return valorVarAnaLabId;
	}

	public void setValorVarAnaLabId(Long valorVarAnaLabId) {
		this.valorVarAnaLabId = valorVarAnaLabId;
	}

	public Long getDatAnaLabId_DatAnaLaboratorio() {
		return datAnaLabId_DatAnaLaboratorio;
	}

	public void setDatAnaLabId_DatAnaLaboratorio(Long datAnaLabId_DatAnaLaboratorio) {
		this.datAnaLabId_DatAnaLaboratorio = datAnaLabId_DatAnaLaboratorio;
	}

	public Long getVariableLabId_VariableLab() {
		return variableLabId_VariableLab;
	}

	public void setVariableLabId_VariableLab(Long variableLabId_VariableLab) {
		this.variableLabId_VariableLab = variableLabId_VariableLab;
	}
}
