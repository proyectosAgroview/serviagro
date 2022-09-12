package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class UdadMedDTO {

	private Long udadMedId;
	private String codigo;
	private String nombre;
	private String sigla;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Long nroDecimales;
	private String clasificacionUm;

	public UdadMedDTO() {
	}

	public Long getUdadMedId() {
		return this.udadMedId;
	}

	public void setUdadMedId(Long udadMedId) {
		this.udadMedId = udadMedId;
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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

	public Long getNroDecimales() {
		return this.nroDecimales;
	}

	public void setNroDecimales(Long nroDecimales) {
		this.nroDecimales = nroDecimales;
	}

	public String getClasificacionUm() {
		return this.clasificacionUm;
	}

	public void setClasificacionUm(String clasificacionUm) {
		this.clasificacionUm = clasificacionUm;
	}

}
