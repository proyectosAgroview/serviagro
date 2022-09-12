package co.com.arcosoft.modelo.informes.dto;

public class EstadoOrdenTrabajoDTO {

	private String nombreCompania;
	private Integer anio;
	private Integer mes;
	private String estadoOrdenTrabajo;
	private Integer numOrdenTrabajo;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getEstadoOrdenTrabajo() {
		return estadoOrdenTrabajo;
	}

	public void setEstadoOrdenTrabajo(String estadoOrdenTrabajo) {
		this.estadoOrdenTrabajo = estadoOrdenTrabajo;
	}

	public Integer getNumOrdenTrabajo() {
		return numOrdenTrabajo;
	}

	public void setNumOrdenTrabajo(Integer numOrdenTrabajo) {
		this.numOrdenTrabajo = numOrdenTrabajo;
	}

}
