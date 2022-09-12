package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class Nivel1DTO {

	private Long nivel1Id;
	private Long trabajador;
	private String codigo;
	private String nombre;
	public Long compania;
	private Float latitud;
	private Float longitud;
	private Float precision;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;

	public Nivel1DTO() {
	}

	public Long getNivel1Id() {
		return this.nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Long getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Long trabajador) {
		this.trabajador = trabajador;
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

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getPrecision() {
		return this.precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
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
