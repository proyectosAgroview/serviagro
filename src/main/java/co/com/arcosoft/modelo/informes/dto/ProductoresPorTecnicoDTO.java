package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProductoresPorTecnicoDTO {

	private String codProductor;
	private String nomProductor;
	private String tipoProductor;
	private String tipoEmpresa;
	private String tecnico;
	private String ciudad;
	private BigDecimal nroProductores;

	public String getCodProductor() {
		return codProductor;
	}

	public void setCodProductor(String codProductor) {
		this.codProductor = codProductor;
	}

	public String getNomProductor() {
		return nomProductor;
	}

	public void setNomProductor(String nomProductor) {
		this.nomProductor = nomProductor;
	}

	public String getTipoProductor() {
		return tipoProductor;
	}

	public void setTipoProductor(String tipoProductor) {
		this.tipoProductor = tipoProductor;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public BigDecimal getNroProductores() {
		return nroProductores;
	}

	public void setNroProductores(BigDecimal nroProductores) {
		this.nroProductores = nroProductores;
	}

}
