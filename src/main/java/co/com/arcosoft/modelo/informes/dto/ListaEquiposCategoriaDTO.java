package co.com.arcosoft.modelo.informes.dto;

import java.math.BigInteger;

public class ListaEquiposCategoriaDTO {

	private BigInteger equipo_id;
	private String cod_equipo;
	private String nom_equipo;
	private String descripcion;
	private BigInteger categ_equip_id;
	private BigInteger tag_id;
	private String codCategoria;
	private String nomCategoria;
	
	

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public BigInteger getTag_id() {
		return tag_id;
	}

	public void setTag_id(BigInteger tag_id) {
		this.tag_id = tag_id;
	}

	public BigInteger getEquipo_id() {
		return equipo_id;
	}

	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
	}

	public String getCod_equipo() {
		return cod_equipo;
	}

	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}

	public String getNom_equipo() {
		return nom_equipo;
	}

	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigInteger getCateg_equip_id() {
		return categ_equip_id;
	}

	public void setCateg_equip_id(BigInteger categ_equip_id) {
		this.categ_equip_id = categ_equip_id;
	}
}