package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class EstPluvioDTO{

	private String codigo;
	private Long compania;
	private Long estPluvioId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String nombre;

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

	public Long getEstPluvioId() {
		return estPluvioId;
	}

	public void setEstPluvioId(Long estPluvioId) {
		this.estPluvioId = estPluvioId;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
