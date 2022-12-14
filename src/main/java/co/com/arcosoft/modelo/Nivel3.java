package co.com.arcosoft.modelo;

// Generated 05-ago-2015 14:10:19 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Nivel3 generated by hbm2java
 */
public class Nivel3 implements java.io.Serializable {

	private Long nivel3Id;
	private Long trabajador;
	private Nivel2 nivel2;
	private String codigo;
	public Long compania;
	private String nombre;
	private Float longitud;
	private Float latitud;
	private Float precision;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<Nivel4> nivel4s = new HashSet<Nivel4>(0);
	private String codigoAlternativo;

	public Nivel3() {
	}

	public Nivel3(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Nivel3(Long nivel3Id, Long trabajador, Nivel2 nivel2, String codigo, Long compania, String nombre,
			Float longitud, Float latitud, String codigoAlternativo, Float precision, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, Set<Nivel4> nivel4s) {
		this.nivel3Id = nivel3Id;
		this.trabajador = trabajador;
		this.nivel2 = nivel2;
		this.codigo = codigo;
		this.compania = compania;
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
		this.precision = precision;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.nivel4s = nivel4s;
		this.codigoAlternativo = codigoAlternativo;
	}

	public String getCodigoAlternativo() {
		return codigoAlternativo;
	}

	public void setCodigoAlternativo(String codigoAlternativo) {
		this.codigoAlternativo = codigoAlternativo;
	}

	public Long getNivel3Id() {
		return this.nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Long getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Long trabajador) {
		this.trabajador = trabajador;
	}

	public Nivel2 getNivel2() {
		return this.nivel2;
	}

	public void setNivel2(Nivel2 nivel2) {
		this.nivel2 = nivel2;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getPrecision() {
		return this.precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Nivel4> getNivel4s() {
		return this.nivel4s;
	}

	public void setNivel4s(Set<Nivel4> nivel4s) {
		this.nivel4s = nivel4s;
	}

}
