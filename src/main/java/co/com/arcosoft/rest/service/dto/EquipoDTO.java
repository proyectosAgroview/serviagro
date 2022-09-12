package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class EquipoDTO {

	private Long anioFabricacion;
	private String codigo;
	private String color;
	private Long compania;
	private Long equipoId;
	private String estado;
	private String nombre;
	private String placa;
	private String tipoPropiedad;
	private Long categEquipId_CategoriaEquipo;
	private Double horometroOdometroActual;
	private Long operarioId;
	
	
	
	
	
	public Long getOperarioId() {
		return operarioId;
	}
	public void setOperarioId(Long operarioId) {
		this.operarioId = operarioId;
	}
	public Double getHorometroOdometroActual() {
		return horometroOdometroActual;
	}
	public void setHorometroOdometroActual(Double horometroOdometroActual) {
		this.horometroOdometroActual = horometroOdometroActual;
	}
	public Long getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(Long anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getCompania() {
		return compania;
	}
	public void setCompania(Long compania) {
		this.compania = compania;
	}
	public Long getEquipoId() {
		return equipoId;
	}
	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
	public Long getCategEquipId_CategoriaEquipo() {
		return categEquipId_CategoriaEquipo;
	}
	public void setCategEquipId_CategoriaEquipo(Long categEquipId_CategoriaEquipo) {
		this.categEquipId_CategoriaEquipo = categEquipId_CategoriaEquipo;
	}


	
}
