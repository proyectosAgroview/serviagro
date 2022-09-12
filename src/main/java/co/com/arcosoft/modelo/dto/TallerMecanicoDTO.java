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
public class TallerMecanicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TallerMecanicoDTO.class);
	private String codigo;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String nombre;
	private Long tallerMecanicoId;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTallerMecanicoId() {
		return tallerMecanicoId;
	}

	public void setTallerMecanicoId(Long tallerMecanicoId) {
		this.tallerMecanicoId = tallerMecanicoId;
	}
}
