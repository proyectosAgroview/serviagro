package co.com.arcosoft.rest.service.dto;

public class TrabajadorDTO {

	private Long trabajadorId;
	private String codigo;
	private String nombre;
	private Long compania;
	private String contratistaId;
	private Long profesionId;
	
	
	public Long getProfesionId() {
		return profesionId;
	}

	public void setProfesionId(Long profesionId) {
		this.profesionId = profesionId;
	}

	public TrabajadorDTO() {

	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getTrabajadorId() {
		return trabajadorId;
	}

	public void setTrabajadorId(Long trabajadorId) {
		this.trabajadorId = trabajadorId;
	}

	public String getContratistaId() {
		return contratistaId;
	}

	public void setContratistaId(String contratistaId) {
		this.contratistaId = contratistaId;
	}

	@Override
	public String toString() {
		return "Trabajador [codigo=" + codigo + ", nombre=" + nombre + ", compania=" + compania + "]";
	}

}
