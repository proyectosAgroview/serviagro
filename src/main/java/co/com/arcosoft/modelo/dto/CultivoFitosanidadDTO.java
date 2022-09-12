package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class CultivoFitosanidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CultivoFitosanidadDTO.class);
	private Long cultivoId;
	private Long fitosanidadId;
	private Long cultivoId_Cultivo;
	private Long fitosanidadId_Fitosanidad;

	public Long getCultivoId() {
		return cultivoId;
	}

	public void setCultivoId(Long cultivoId) {
		this.cultivoId = cultivoId;
	}

	public Long getFitosanidadId() {
		return fitosanidadId;
	}

	public void setFitosanidadId(Long fitosanidadId) {
		this.fitosanidadId = fitosanidadId;
	}

	public Long getCultivoId_Cultivo() {
		return cultivoId_Cultivo;
	}

	public void setCultivoId_Cultivo(Long cultivoId_Cultivo) {
		this.cultivoId_Cultivo = cultivoId_Cultivo;
	}

	public Long getFitosanidadId_Fitosanidad() {
		return fitosanidadId_Fitosanidad;
	}

	public void setFitosanidadId_Fitosanidad(Long fitosanidadId_Fitosanidad) {
		this.fitosanidadId_Fitosanidad = fitosanidadId_Fitosanidad;
	}
}
