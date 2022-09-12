package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class MaquinariaDTO {

	private String codigo;
	private Long compania;
	private Long equipoId;
	private String estado;
	private String nombre;
	private String horometroInicial;
	private Long categEquipId_CategoriaEquipo;
	private String trabajadorId;
	private String nombreTrabajador;
	private String rangoDifHorometro;
	private String horometroTanqueo;
	
	
	
	

	public String getHorometroTanqueo() {
		return horometroTanqueo;
	}

	public void setHorometroTanqueo(String horometroTanqueo) {
		this.horometroTanqueo = horometroTanqueo;
	}

	public String getRangoDifHorometro() {
		return rangoDifHorometro;
	}

	public void setRangoDifHorometro(String rangoDifHorometro) {
		this.rangoDifHorometro = rangoDifHorometro;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public String getTrabajadorId() {
		return trabajadorId;
	}
	
	public void setTrabajadorId(String trabajadorId) {
		this.trabajadorId = trabajadorId;
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
	public Long getCategEquipId_CategoriaEquipo() {
		return categEquipId_CategoriaEquipo;
	}
	public void setCategEquipId_CategoriaEquipo(Long categEquipId_CategoriaEquipo) {
		this.categEquipId_CategoriaEquipo = categEquipId_CategoriaEquipo;
	}
	public String getHorometroInicial() {
		return horometroInicial;
	}
	public void setHorometroInicial(String horometroInicial) {
		this.horometroInicial = horometroInicial;
	}
	
	
}
