package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org}
 * 
 *
 */
public class VariableDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VariableDTO.class);
	private String codigo;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private Long numeroDecimales;
	private Long orden;
	private Long tiempoDigitacion;
	private String tipoDato;
	private Double valorMaximo;
	private Double valorMinimo;
	private Long variableId;
	private Long anaSanVegId_AnaSanVeg;
	private String analisis;
	private String formula;
    private String tipoVariable;
    
    
    
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNumeroDecimales() {
		return numeroDecimales;
	}

	public void setNumeroDecimales(Long numeroDecimales) {
		this.numeroDecimales = numeroDecimales;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public Long getTiempoDigitacion() {
		return tiempoDigitacion;
	}

	public void setTiempoDigitacion(Long tiempoDigitacion) {
		this.tiempoDigitacion = tiempoDigitacion;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public Double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Long getVariableId() {
		return variableId;
	}

	public void setVariableId(Long variableId) {
		this.variableId = variableId;
	}

	public Long getAnaSanVegId_AnaSanVeg() {
		return anaSanVegId_AnaSanVeg;
	}

	public void setAnaSanVegId_AnaSanVeg(Long anaSanVegId_AnaSanVeg) {
		this.anaSanVegId_AnaSanVeg = anaSanVegId_AnaSanVeg;
	}

	public String getAnalisis() {
		return analisis;
	}

	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}

}
