package co.com.arcosoft.modelo.informes.dto;

import java.util.Date;

public class VisitasTecnicoDetalladoDTO {
	private String nomCompania;
	private Date fecha;
	private String Departamento;
	private String codTrabajador;
	private String nomTrabajador;
	private String productores;
	private String variedad;
	private String nomCiudad;

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getNomTrabajador() {
		return nomTrabajador;
	}

	public void setNomTrabajador(String nomTrabajador) {
		this.nomTrabajador = nomTrabajador;
	}

	public String getProductores() {
		return productores;
	}

	public void setProductores(String productores) {
		this.productores = productores;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

}
