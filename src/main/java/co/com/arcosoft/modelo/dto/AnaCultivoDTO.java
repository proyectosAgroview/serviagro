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
 *
 */
public class AnaCultivoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(AnaCultivoDTO.class);
	private Long anaCultId;
	private Long compania;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long anaSanVegId_AnaSanVeg;
	private Long cultivoId_Cultivo;

	public Long getAnaCultId() {
		return anaCultId;
	}

	public void setAnaCultId(Long anaCultId) {
		this.anaCultId = anaCultId;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Long getAnaSanVegId_AnaSanVeg() {
		return anaSanVegId_AnaSanVeg;
	}

	public void setAnaSanVegId_AnaSanVeg(Long anaSanVegId_AnaSanVeg) {
		this.anaSanVegId_AnaSanVeg = anaSanVegId_AnaSanVeg;
	}

	public Long getCultivoId_Cultivo() {
		return cultivoId_Cultivo;
	}

	public void setCultivoId_Cultivo(Long cultivoId_Cultivo) {
		this.cultivoId_Cultivo = cultivoId_Cultivo;
	}
}
