package co.com.arcosoft.modelo;
// Generated 24-ago-2016 15:04:52 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TipoMantenimiento generated by hbm2java
 */
public class TipoMantenimiento implements java.io.Serializable {

	private Long tipoMantenimientoId;
	private String codigo;
	private String nombre;
	public Long compania;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<DatMantenimientoEquipo> datMantenimientoEquipos = new HashSet<DatMantenimientoEquipo>(0);

	public TipoMantenimiento() {
	}

	public TipoMantenimiento(Long tipoMantenimientoId) {
		this.tipoMantenimientoId = tipoMantenimientoId;
	}

	public TipoMantenimiento(Long tipoMantenimientoId, String codigo, String nombre, Long compania, Date fechaCreacion,
			Date fechaModificacion, String estado, Set<DatMantenimientoEquipo> datMantenimientoEquipos) {
		this.tipoMantenimientoId = tipoMantenimientoId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.datMantenimientoEquipos = datMantenimientoEquipos;
	}

	public Long getTipoMantenimientoId() {
		return this.tipoMantenimientoId;
	}

	public void setTipoMantenimientoId(Long tipoMantenimientoId) {
		this.tipoMantenimientoId = tipoMantenimientoId;
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

	public Set<DatMantenimientoEquipo> getDatMantenimientoEquipos() {
		return this.datMantenimientoEquipos;
	}

	public void setDatMantenimientoEquipos(Set<DatMantenimientoEquipo> datMantenimientoEquipos) {
		this.datMantenimientoEquipos = datMantenimientoEquipos;
	}

}