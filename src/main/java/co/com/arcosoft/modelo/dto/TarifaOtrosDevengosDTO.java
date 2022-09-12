package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Trabajador;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TarifaOtrosDevengosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaOtrosDevengosDTO.class);
	private Long compania;
	private ConceptoNomina conceptoNominaId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Long odevengosId;
	private Trabajador trabId;
	private Double valorDeduccion;
	private String codConceptoNomina;
	private String generaDomingosFestivos;
	private String generaAuxilioTransp;
	private ConceptoNomina ceptoNominaAlternativo;
	private String codConceptoAlternativo;
	private Double horasDia;
	private Double horasMes;
	private String generaAuxilioAdmon;

	public String getGeneraAuxilioAdmon() {
		return generaAuxilioAdmon;
	}

	public void setGeneraAuxilioAdmon(String generaAuxilioAdmon) {
		this.generaAuxilioAdmon = generaAuxilioAdmon;
	}

	public String getCodConceptoAlternativo() {
		return codConceptoAlternativo;
	}

	public void setCodConceptoAlternativo(String codConceptoAlternativo) {
		this.codConceptoAlternativo = codConceptoAlternativo;
	}

	public String getGeneraDomingosFestivos() {
		return generaDomingosFestivos;
	}

	public void setGeneraDomingosFestivos(String generaDomingosFestivos) {
		this.generaDomingosFestivos = generaDomingosFestivos;
	}

	public String getGeneraAuxilioTransp() {
		return generaAuxilioTransp;
	}

	public void setGeneraAuxilioTransp(String generaAuxilioTransp) {
		this.generaAuxilioTransp = generaAuxilioTransp;
	}

	public ConceptoNomina getCeptoNominaAlternativo() {
		return ceptoNominaAlternativo;
	}

	public void setCeptoNominaAlternativo(ConceptoNomina ceptoNominaAlternativo) {
		this.ceptoNominaAlternativo = ceptoNominaAlternativo;
	}

	public Double getHorasDia() {
		return horasDia;
	}

	public void setHorasDia(Double horasDia) {
		this.horasDia = horasDia;
	}

	public Double getHorasMes() {
		return horasMes;
	}

	public void setHorasMes(Double horasMes) {
		this.horasMes = horasMes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public ConceptoNomina getConceptoNominaId() {
		return conceptoNominaId;
	}

	public void setConceptoNominaId(ConceptoNomina conceptoNominaId) {
		this.conceptoNominaId = conceptoNominaId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Long getOdevengosId() {
		return odevengosId;
	}

	public void setOdevengosId(Long odevengosId) {
		this.odevengosId = odevengosId;
	}

	public Trabajador getTrabId() {
		return trabId;
	}

	public void setTrabId(Trabajador trabId) {
		this.trabId = trabId;
	}

	public Double getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public String getCodConceptoNomina() {
		return codConceptoNomina;
	}

	public void setCodConceptoNomina(String codConceptoNomina) {
		this.codConceptoNomina = codConceptoNomina;
	}

}
