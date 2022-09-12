package co.com.arcosoft.modelo;

// Generated 17-mar-2015 15:25:33 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * RangoValor generated by hbm2java
 */
public class RangoValor implements java.io.Serializable {

	private Long rangoValorId;
	private Variable variable;
	private String codigo;
	private String clasificacion;
	private Double valorInicial;
	private Double valorFinal;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;

	public RangoValor() {
	}

	public RangoValor(Long rangoValorId) {
		this.rangoValorId = rangoValorId;
	}

	public RangoValor(Long rangoValorId, Variable variable, String codigo, String clasificacion, Double valorInicial,
			Double valorFinal, Long compania, String infoAdicional, String infoAdicional2, Date fechaCreacion,
			Date fechaModificacion, String estado) {
		this.rangoValorId = rangoValorId;
		this.variable = variable;
		this.codigo = codigo;
		this.clasificacion = clasificacion;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Long getRangoValorId() {
		return this.rangoValorId;
	}

	public void setRangoValorId(Long rangoValorId) {
		this.rangoValorId = rangoValorId;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Double getValorInicial() {
		return this.valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorFinal() {
		return this.valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}