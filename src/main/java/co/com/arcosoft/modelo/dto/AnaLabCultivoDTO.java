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
public class AnaLabCultivoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(AnaLabCultivoDTO.class);
	private Long anaLabCultId;
	private Long compania;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long anaLabId_AnaLaboratorio;
	private Long cultivoId_Cultivo;

	public Long getAnaLabCultId() {
		return anaLabCultId;
	}

	public void setAnaLabCultId(Long anaLabCultId) {
		this.anaLabCultId = anaLabCultId;
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

	public Long getAnaLabId_AnaLaboratorio() {
		return anaLabId_AnaLaboratorio;
	}

	public void setAnaLabId_AnaLaboratorio(Long anaLabId_AnaLaboratorio) {
		this.anaLabId_AnaLaboratorio = anaLabId_AnaLaboratorio;
	}

	public Long getCultivoId_Cultivo() {
		return cultivoId_Cultivo;
	}

	public void setCultivoId_Cultivo(Long cultivoId_Cultivo) {
		this.cultivoId_Cultivo = cultivoId_Cultivo;
	}
}
