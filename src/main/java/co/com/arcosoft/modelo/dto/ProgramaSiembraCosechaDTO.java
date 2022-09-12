package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class ProgramaSiembraCosechaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaSiembraCosechaDTO.class);
	private Long anio;
	private Long compania;
	private Long consecutivo;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String observacion;
	private Long programaSiembraCosechaId;
	private Long usuarioDigitacion;
	private Long trabId_Trabajador;
	private String tecnicoNombre;
	private String estadoTrue;
	private String estadoTrue2;

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public String getEstadoTrue2() {
		return estadoTrue2;
	}

	public void setEstadoTrue2(String estadoTrue2) {
		this.estadoTrue2 = estadoTrue2;
	}

	public String getTecnicoNombre() {
		return tecnicoNombre;
	}

	public void setTecnicoNombre(String tecnicoNombre) {
		this.tecnicoNombre = tecnicoNombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Long getAnio() {
		return anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getProgramaSiembraCosechaId() {
		return programaSiembraCosechaId;
	}

	public void setProgramaSiembraCosechaId(Long programaSiembraCosechaId) {
		this.programaSiembraCosechaId = programaSiembraCosechaId;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}
}
