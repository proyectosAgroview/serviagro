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
public class ListValorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ListValorDTO.class);
	private String clasificacion;
	private String codigo;
	private Long compania;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Long listValorId;
	private String valorAlfaNumerico;
	private Long valorNumerico;
	private Long variableId_Variable;

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
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

	public Long getListValorId() {
		return listValorId;
	}

	public void setListValorId(Long listValorId) {
		this.listValorId = listValorId;
	}

	public String getValorAlfaNumerico() {
		return valorAlfaNumerico;
	}

	public void setValorAlfaNumerico(String valorAlfaNumerico) {
		this.valorAlfaNumerico = valorAlfaNumerico;
	}

	public Long getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(Long valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public Long getVariableId_Variable() {
		return variableId_Variable;
	}

	public void setVariableId_Variable(Long variableId_Variable) {
		this.variableId_Variable = variableId_Variable;
	}
}
