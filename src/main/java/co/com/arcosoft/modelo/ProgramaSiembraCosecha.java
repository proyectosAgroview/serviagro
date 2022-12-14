package co.com.arcosoft.modelo;
// Generated 28-ene-2017 9:38:13 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProgramaSiembraCosecha generated by hbm2java
 */
public class ProgramaSiembraCosecha implements java.io.Serializable {

	private Long programaSiembraCosechaId;
	private Trabajador trabajador;
	private Long consecutivo;
	private Long anio;
	private String observacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Long compania;
	private Long usuarioDigitacion;
	private Set<ProgramaSiembraCosechaDet> programaSiembraCosechaDets = new HashSet<ProgramaSiembraCosechaDet>(0);

	public ProgramaSiembraCosecha() {
	}

	public ProgramaSiembraCosecha(Long programaSiembraCosechaId) {
		this.programaSiembraCosechaId = programaSiembraCosechaId;
	}

	public ProgramaSiembraCosecha(Long programaSiembraCosechaId, Trabajador trabajador, Long consecutivo, Long anio,
			String observacion, Date fechaCreacion, Date fechaModificacion, String estado, Long compania,
			Long usuarioDigitacion, Set<ProgramaSiembraCosechaDet> programaSiembraCosechaDets) {
		this.programaSiembraCosechaId = programaSiembraCosechaId;
		this.trabajador = trabajador;
		this.consecutivo = consecutivo;
		this.anio = anio;
		this.observacion = observacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.compania = compania;
		this.usuarioDigitacion = usuarioDigitacion;
		this.programaSiembraCosechaDets = programaSiembraCosechaDets;
	}

	public Long getProgramaSiembraCosechaId() {
		return this.programaSiembraCosechaId;
	}

	public void setProgramaSiembraCosechaId(Long programaSiembraCosechaId) {
		this.programaSiembraCosechaId = programaSiembraCosechaId;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getAnio() {
		return this.anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getUsuarioDigitacion() {
		return this.usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Set<ProgramaSiembraCosechaDet> getProgramaSiembraCosechaDets() {
		return this.programaSiembraCosechaDets;
	}

	public void setProgramaSiembraCosechaDets(Set<ProgramaSiembraCosechaDet> programaSiembraCosechaDets) {
		this.programaSiembraCosechaDets = programaSiembraCosechaDets;
	}

}
