package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class ClientesDTO {

	private String codigo;
	private Long compania;
	private String estado;
	private String nombre;
	private Long persEmprId;
	private String tipoEmpresa;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getPersEmprId() {
		return persEmprId;
	}
	public void setPersEmprId(Long persEmprId) {
		this.persEmprId = persEmprId;
	}
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	
	
	
	
	
	
}
