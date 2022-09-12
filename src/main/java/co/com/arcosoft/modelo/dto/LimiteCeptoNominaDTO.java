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
public class LimiteCeptoNominaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LimiteCeptoNominaDTO.class);
	private Long ceptoNominaId;
	private Long udadMedId;
	private Long compania;
	private Double cantidadPermitida;
	private Long ceptoNominaId_ConceptoNomina;
	private Long udadMedId_UdadMed;

	public Long getCeptoNominaId() {
		return ceptoNominaId;
	}

	public void setCeptoNominaId(Long ceptoNominaId) {
		this.ceptoNominaId = ceptoNominaId;
	}

	public Long getUdadMedId() {
		return udadMedId;
	}

	public void setUdadMedId(Long udadMedId) {
		this.udadMedId = udadMedId;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getCantidadPermitida() {
		return cantidadPermitida;
	}

	public void setCantidadPermitida(Double cantidadPermitida) {
		this.cantidadPermitida = cantidadPermitida;
	}

	public Long getCeptoNominaId_ConceptoNomina() {
		return ceptoNominaId_ConceptoNomina;
	}

	public void setCeptoNominaId_ConceptoNomina(Long ceptoNominaId_ConceptoNomina) {
		this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
	}

	public Long getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}
}
