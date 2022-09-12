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
public class RestriMaduranteNivel4DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RestriMaduranteNivel4DTO.class);
	private Long restrMaduranteRestMaduId;
	private Long nivel4Nivel4Id;
	private Long nivel4Id_Nivel4;
	private Long restMaduId_RestrMadurante;

	public Long getRestrMaduranteRestMaduId() {
		return restrMaduranteRestMaduId;
	}

	public void setRestrMaduranteRestMaduId(Long restrMaduranteRestMaduId) {
		this.restrMaduranteRestMaduId = restrMaduranteRestMaduId;
	}

	public Long getNivel4Nivel4Id() {
		return nivel4Nivel4Id;
	}

	public void setNivel4Nivel4Id(Long nivel4Nivel4Id) {
		this.nivel4Nivel4Id = nivel4Nivel4Id;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getRestMaduId_RestrMadurante() {
		return restMaduId_RestrMadurante;
	}

	public void setRestMaduId_RestrMadurante(Long restMaduId_RestrMadurante) {
		this.restMaduId_RestrMadurante = restMaduId_RestrMadurante;
	}
}
