package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatNominaTrabajadorDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorDetDTO.class);
	private Long datNominaTrabajadorDetId;
	private Double valorTotal;
	private ConceptoNomina ceptoNominaId_ConceptoNomina;
	private Long datNominaTrabajadorId_DatNominaTrabajador;
	private Trabajador trabId_Trabajador;

	private String nombreConceptoNomina;
	private String nombreTrabajador;
	private Double cantidad;
	private UdadMed udadMedId;
	private Double valorDeduccion;
	private String tipoMovimiento;

	private String nombreUdadMed;
	
	
	
	/**
	 * @return the nombreUdadMed
	 */
	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	/**
	 * @param nombreUdadMed the nombreUdadMed to set
	 */
	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	/**
	 * @return the cantidad
	 */
	public Double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the udadMedId
	 */
	public UdadMed getUdadMedId() {
		return udadMedId;
	}

	/**
	 * @param udadMedId the udadMedId to set
	 */
	public void setUdadMedId(UdadMed udadMedId) {
		this.udadMedId = udadMedId;
	}

	public String getNombreConceptoNomina() {
		return nombreConceptoNomina;
	}

	public void setNombreConceptoNomina(String nombreConceptoNomina) {
		this.nombreConceptoNomina = nombreConceptoNomina;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Long getDatNominaTrabajadorDetId() {
		return datNominaTrabajadorDetId;
	}

	public void setDatNominaTrabajadorDetId(Long datNominaTrabajadorDetId) {
		this.datNominaTrabajadorDetId = datNominaTrabajadorDetId;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ConceptoNomina getCeptoNominaId_ConceptoNomina() {
		return ceptoNominaId_ConceptoNomina;
	}

	public void setCeptoNominaId_ConceptoNomina(ConceptoNomina ceptoNominaId_ConceptoNomina) {
		this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
	}

	public Long getDatNominaTrabajadorId_DatNominaTrabajador() {
		return datNominaTrabajadorId_DatNominaTrabajador;
	}

	public void setDatNominaTrabajadorId_DatNominaTrabajador(Long datNominaTrabajadorId_DatNominaTrabajador) {
		this.datNominaTrabajadorId_DatNominaTrabajador = datNominaTrabajadorId_DatNominaTrabajador;
	}

	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Double getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
}
