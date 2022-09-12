package co.com.arcosoft.modelo;

// Generated 05-ago-2015 14:10:19 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SerieSuelo generated by hbm2java
 */
public class SerieSuelo implements java.io.Serializable {

	private Long serieSueloId;
	private String codigo;
	private String nombre;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<Nivel4> nivel4s = new HashSet<Nivel4>(0);

	public SerieSuelo() {
	}

	public SerieSuelo(Long serieSueloId) {
		this.serieSueloId = serieSueloId;
	}

	public SerieSuelo(Long serieSueloId, String codigo, String nombre, Long compania, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, Set<Nivel4> nivel4s) {
		this.serieSueloId = serieSueloId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.nivel4s = nivel4s;
	}

	public Long getSerieSueloId() {
		return this.serieSueloId;
	}

	public void setSerieSueloId(Long serieSueloId) {
		this.serieSueloId = serieSueloId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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
