package co.com.arcosoft.modelo.informes.dto;

public class VisitasTecnicoResumenDTO {

	private String nomCompania;
	private String Departamento;
	private String codTrabajador;
	private String nomTrabajador;
	private Integer numVisitasTotales;
	private Integer numAsociacionesVisitadas;
	private Integer numParcelasDemostrativas;
	private String productores;
	private String cultivos;

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

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public Integer getNumVisitasTotales() {
		return numVisitasTotales;
	}

	public void setNumVisitasTotales(Integer numVisitasTotales) {
		this.numVisitasTotales = numVisitasTotales;
	}

	public Integer getNumAsociacionesVisitadas() {
		return numAsociacionesVisitadas;
	}

	public void setNumAsociacionesVisitadas(Integer numAsociacionesVisitadas) {
		this.numAsociacionesVisitadas = numAsociacionesVisitadas;
	}

	public Integer getNumParcelasDemostrativas() {
		return numParcelasDemostrativas;
	}

	public void setNumParcelasDemostrativas(Integer numParcelasDemostrativas) {
		this.numParcelasDemostrativas = numParcelasDemostrativas;
	}

	public String getProductores() {
		return productores;
	}

	public void setProductores(String productores) {
		this.productores = productores;
	}

	public String getCultivos() {
		return cultivos;
	}

	public void setCultivos(String cultivos) {
		this.cultivos = cultivos;
	}

}
