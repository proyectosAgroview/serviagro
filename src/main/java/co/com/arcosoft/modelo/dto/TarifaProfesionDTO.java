package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TarifaProfesionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaProfesionDTO.class);
	private Long compania;
	private PersEmpr contratistaId;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Double tarifa;
	private Long tarifaProfId;
	private ConceptoNomina ceptoNominaId_ConceptoNomina;
	private Profesion profId_Profesion;
	private UdadMed udadMedId_UdadMed;

	private String codContratista;
	private String codConceptoNomina;
	private String codUdadMed;

	public String getCodContratista() {
		return codContratista;
	}

	public void setCodContratista(String codContratista) {
		this.codContratista = codContratista;
	}

	public String getCodConceptoNomina() {
		return codConceptoNomina;
	}

	public void setCodConceptoNomina(String codConceptoNomina) {
		this.codConceptoNomina = codConceptoNomina;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public PersEmpr getContratistaId() {
		return contratistaId;
	}

	public void setContratistaId(PersEmpr contratistaId) {
		this.contratistaId = contratistaId;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Long getTarifaProfId() {
		return tarifaProfId;
	}

	public void setTarifaProfId(Long tarifaProfId) {
		this.tarifaProfId = tarifaProfId;
	}

	public ConceptoNomina getCeptoNominaId_ConceptoNomina() {
		return ceptoNominaId_ConceptoNomina;
	}

	public void setCeptoNominaId_ConceptoNomina(ConceptoNomina ceptoNominaId_ConceptoNomina) {
		this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
	}

	public Profesion getProfId_Profesion() {
		return profId_Profesion;
	}

	public void setProfId_Profesion(Profesion profId_Profesion) {
		this.profId_Profesion = profId_Profesion;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMed) {
		this.udadMedId_UdadMed = udadMed;
	}
}
