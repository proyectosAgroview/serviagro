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
public class LaborServicioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaborServicioDTO.class);
	private Long laborId;
	private Long servicioId;
	private Long laborId_Labor;
	private Long servicioId_Servicio;

	public Long getLaborId() {
		return laborId;
	}

	public void setLaborId(Long laborId) {
		this.laborId = laborId;
	}

	public Long getServicioId() {
		return servicioId;
	}

	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Long getServicioId_Servicio() {
		return servicioId_Servicio;
	}

	public void setServicioId_Servicio(Long servicioId_Servicio) {
		this.servicioId_Servicio = servicioId_Servicio;
	}
}
