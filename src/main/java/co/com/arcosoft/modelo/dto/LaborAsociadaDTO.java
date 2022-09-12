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
public class LaborAsociadaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaborAsociadaDTO.class);
	private Long laborId;
	private Long laborAsocId;
	private Long laborId_Labor;
	private Long laborId_Labor_Asoc;

	public Long getLaborId() {
		return laborId;
	}

	public void setLaborId(Long laborId) {
		this.laborId = laborId;
	}

	public Long getLaborAsocId() {
		return laborAsocId;
	}

	public void setLaborAsocId(Long laborAsocId) {
		this.laborAsocId = laborAsocId;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Long getLaborId_Labor_Asoc() {
		return laborId_Labor_Asoc;
	}

	public void setLaborId_Labor_Asoc(Long laborId_Labor_Asoc) {
		this.laborId_Labor_Asoc = laborId_Labor_Asoc;
	}

}
