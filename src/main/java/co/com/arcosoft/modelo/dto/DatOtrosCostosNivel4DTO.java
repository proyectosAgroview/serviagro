package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatOtrosCostosNivel4DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosNivel4DTO.class);
	private Long datOtrosCostosNivel4Id;
	private Long datOtrosCostosId_DatOtrosCostos;
	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;
	private String nombreNivel2;
	private String nombreNivel4;
	private Double areaNivel4;
	private Long etapaId;
	private Long variedId;

	public Double getAreaNivel4() {
		return areaNivel4;
	}

	public void setAreaNivel4(Double areaNivel4) {
		this.areaNivel4 = areaNivel4;
	}

	public String getNombreNivel2() {
		return nombreNivel2;
	}

	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	public String getNombreNivel4() {
		return nombreNivel4;
	}

	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Long getDatOtrosCostosNivel4Id() {
		return datOtrosCostosNivel4Id;
	}

	public void setDatOtrosCostosNivel4Id(Long datOtrosCostosNivel4Id) {
		this.datOtrosCostosNivel4Id = datOtrosCostosNivel4Id;
	}

	public Long getDatOtrosCostosId_DatOtrosCostos() {
		return datOtrosCostosId_DatOtrosCostos;
	}

	public void setDatOtrosCostosId_DatOtrosCostos(Long datOtrosCostosId_DatOtrosCostos) {
		this.datOtrosCostosId_DatOtrosCostos = datOtrosCostosId_DatOtrosCostos;
	}

	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}
}
