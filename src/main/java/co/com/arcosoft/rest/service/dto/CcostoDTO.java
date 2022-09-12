package co.com.arcosoft.rest.service.dto;

public class CcostoDTO {

	private Long id;
	private String codigo;
	private String nombre;

	public CcostoDTO() {
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
