package co.com.arcosoft.modelo;

// Generated 7/07/2015 10:31:58 AM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Variable generated by hbm2java
 */
public class Variable implements java.io.Serializable {

	private Long variableId;
	private AnaSanVeg anaSanVeg;
	private String codigo;
	private String nombre;
	private String tipoDato;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Long orden;
	private Long numeroDecimales;
	private Double valorMinimo;
	private Double valorMaximo;
	private Long tiempoDigitacion;
    private Set<ListValor> listValors = new HashSet<ListValor>(0);
    private Set<RangoValor> rangoValors = new HashSet<RangoValor>(0);
    private Set<ValorVar> valorVars = new HashSet<ValorVar>(0);
    private String formula;
    private String tipoVariable;
    
    
	
	public Variable() {
	}

	public Variable(Long variableId) {
		this.variableId = variableId;
	}

	public Variable(Long variableId, AnaSanVeg anaSanVeg, String codigo, String nombre, String tipoDato, Long compania,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Long orden, Long numeroDecimales, Double valorMinimo, Double valorMaximo, Long tiempoDigitacion,
			Set<ListValor> listValors, Set<RangoValor> rangoValors,
    		Set<ValorVar> valorVars,
    		 String formula,
			String tipoVariable
    ) {
		this.variableId = variableId;
		this.anaSanVeg = anaSanVeg;
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoDato = tipoDato;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.orden = orden;
		this.numeroDecimales = numeroDecimales;
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.tiempoDigitacion = tiempoDigitacion;
		this.listValors = listValors;
	    this.rangoValors = rangoValors;
	    this.valorVars = valorVars;
	    this.formula= formula;
	    this.tipoVariable= tipoVariable;
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

	public Set<ListValor> getListValors() {
		return listValors;
	}

	public void setListValors(Set<ListValor> listValors) {
		this.listValors = listValors;
	}

	public Set<RangoValor> getRangoValors() {
		return rangoValors;
	}

	public void setRangoValors(Set<RangoValor> rangoValors) {
		this.rangoValors = rangoValors;
	}

	public Set<ValorVar> getValorVars() {
		return valorVars;
	}

	public void setValorVars(Set<ValorVar> valorVars) {
		this.valorVars = valorVars;
	}

	public Long getVariableId() {
		return this.variableId;
	}

	public void setVariableId(Long variableId) {
		this.variableId = variableId;
	}

	public AnaSanVeg getAnaSanVeg() {
		return this.anaSanVeg;
	}

	public void setAnaSanVeg(AnaSanVeg anaSanVeg) {
		this.anaSanVeg = anaSanVeg;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDato() {
		return this.tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
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

	public Long getOrden() {
		return this.orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public Long getNumeroDecimales() {
		return this.numeroDecimales;
	}

	public void setNumeroDecimales(Long numeroDecimales) {
		this.numeroDecimales = numeroDecimales;
	}

	public Double getValorMinimo() {
		return this.valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Double getValorMaximo() {
		return this.valorMaximo;
	}

	public void setValorMaximo(Double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Long getTiempoDigitacion() {
		return this.tiempoDigitacion;
	}

	public void setTiempoDigitacion(Long tiempoDigitacion) {
		this.tiempoDigitacion = tiempoDigitacion;
	}

}
