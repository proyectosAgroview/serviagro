package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * ValorVarAnaTrans generated by hbm2java
 */
public class ValorVarAnaTrans implements java.io.Serializable {

	private Long valorVarAnaTransId;
	private VariableLab variableLab;
	private DatAnaTransProd datAnaTransProd;
	private String valor;
	private Date fechaCreacion;
	private Date fechaModificacion;

	public ValorVarAnaTrans() {
	}

	public ValorVarAnaTrans(Long valorVarAnaTransId) {
		this.valorVarAnaTransId = valorVarAnaTransId;
	}

	public ValorVarAnaTrans(Long valorVarAnaTransId, VariableLab variableLab, DatAnaTransProd datAnaTransProd,
			String valor, Date fechaCreacion, Date fechaModificacion) {
		this.valorVarAnaTransId = valorVarAnaTransId;
		this.variableLab = variableLab;
		this.datAnaTransProd = datAnaTransProd;
		this.valor = valor;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Long getValorVarAnaTransId() {
		return this.valorVarAnaTransId;
	}

	public void setValorVarAnaTransId(Long valorVarAnaTransId) {
		this.valorVarAnaTransId = valorVarAnaTransId;
	}

	public VariableLab getVariableLab() {
		return this.variableLab;
	}

	public void setVariableLab(VariableLab variableLab) {
		this.variableLab = variableLab;
	}

	public DatAnaTransProd getDatAnaTransProd() {
		return this.datAnaTransProd;
	}

	public void setDatAnaTransProd(DatAnaTransProd datAnaTransProd) {
		this.datAnaTransProd = datAnaTransProd;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}