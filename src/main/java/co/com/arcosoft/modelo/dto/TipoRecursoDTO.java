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
public class TipoRecursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoRecursoDTO.class);
	private String claseRecurso;
	private String codigo;
	private Long compania;
	private String controlCosto;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private Long tpRecursoId;

	public String getClaseRecurso() {
		return claseRecurso;
	}

	public void setClaseRecurso(String claseRecurso) {
		this.claseRecurso = claseRecurso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getControlCosto() {
		return controlCosto;
	}

	public void setControlCosto(String controlCosto) {
		this.controlCosto = controlCosto;
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

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTpRecursoId() {
		return tpRecursoId;
	}

	public void setTpRecursoId(Long tpRecursoId) {
		this.tpRecursoId = tpRecursoId;
	}
}
