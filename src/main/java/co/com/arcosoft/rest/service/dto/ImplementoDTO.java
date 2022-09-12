package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class ImplementoDTO {

	private String codigo;
	private Long compania;
	private Long implementoId;
	private String estado;
	private String nombre;
	private Long categEquipId_CategoriaEquipo;
	
	
	
	public Long getImplementoId() {
		return implementoId;
	}
	public void setImplementoId(Long implementoId) {
		this.implementoId = implementoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Long getCategEquipId_CategoriaEquipo() {
		return categEquipId_CategoriaEquipo;
	}
	public void setCategEquipId_CategoriaEquipo(Long categEquipId_CategoriaEquipo) {
		this.categEquipId_CategoriaEquipo = categEquipId_CategoriaEquipo;
	}
	
	
}
