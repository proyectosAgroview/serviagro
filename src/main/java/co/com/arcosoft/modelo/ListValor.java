package co.com.arcosoft.modelo;

// Generated 17-mar-2015 15:25:33 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * ListValor generated by hbm2java
 */
public class ListValor implements java.io.Serializable {

	private Long listValorId;
	private Variable variable;
	private String codigo;
	private Long valorNumerico;
	private String valorAlfaNumerico;
	private String clasificacion;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;

	public ListValor() {
	}

	public ListValor(Long listValorId) {
		this.listValorId = listValorId;
	}

	public ListValor(Long listValorId, Variable variable, String codigo, Long valorNumerico, String valorAlfaNumerico,
			String clasificacion, Long compania, String infoAdicional, String infoAdicional2, Date fechaCreacion,
			Date fechaModificacion) {
		this.listValorId = listValorId;
		this.variable = variable;
		this.codigo = codigo;
		this.valorNumerico = valorNumerico;
		this.valorAlfaNumerico = valorAlfaNumerico;
		this.clasificacion = clasificacion;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;

	}

	public Long getListValorId() {
		return this.listValorId;
	}

	public void setListValorId(Long listValorId) {
		this.listValorId = listValorId;
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

	public Long getValorNumerico() {
		return this.valorNumerico;
	}

	public void setValorNumerico(Long valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getValorAlfaNumerico() {
		return this.valorAlfaNumerico;
	}

	public void setValorAlfaNumerico(String valorAlfaNumerico) {
		this.valorAlfaNumerico = valorAlfaNumerico;
	}

	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
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

}
