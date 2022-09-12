package co.com.arcosoft.modelo;
// Generated 19-jul-2016 10:41:37 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * TarifaOtrosDevengos generated by hbm2java
 */
public class TarifaOtrosDevengos implements java.io.Serializable {

	private Long odevengosId;
	private Trabajador trabId;
	private ConceptoNomina conceptoNominaId;
	private Long compania;
	private Date fechaInicial;
	private Date fechaFinal;
	private Double valorDeduccion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private String generaDomingosFestivos;
	private String generaAuxilioTransp;
	private ConceptoNomina ceptoNominaAlternativo;
	private Double horasDia;
	private Double horasMes;
	private String generaAuxilioAdmon;

	public TarifaOtrosDevengos() {
	}

	public TarifaOtrosDevengos(Long odevengosId) {
		this.odevengosId = odevengosId;
	}

	public TarifaOtrosDevengos(Long odevengosId, Trabajador trabId, ConceptoNomina conceptoNominaId, Long compania,
			Date fechaInicial, Date fechaFinal, Double valorDeduccion, Date fechaCreacion, Date fechaModificacion,
			String estado, String generaDomingosFestivos, String generaAuxilioTransp,
			ConceptoNomina ceptoNominaAlternativo, Double horasDia, Double horasMes, String generaAuxilioAdmon

	) {
		this.odevengosId = odevengosId;
		this.trabId = trabId;
		this.conceptoNominaId = conceptoNominaId;
		this.compania = compania;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.valorDeduccion = valorDeduccion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.generaDomingosFestivos = generaDomingosFestivos;
		this.generaAuxilioTransp = generaAuxilioTransp;
		this.ceptoNominaAlternativo = ceptoNominaAlternativo;
		this.horasDia = horasDia;
		this.horasMes = horasMes;
		this.generaAuxilioAdmon = generaAuxilioAdmon;

	}

	public String getGeneraAuxilioAdmon() {
		return generaAuxilioAdmon;
	}

	public void setGeneraAuxilioAdmon(String generaAuxilioAdmon) {
		this.generaAuxilioAdmon = generaAuxilioAdmon;
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

	public Long getOdevengosId() {
		return this.odevengosId;
	}

	public void setOdevengosId(Long odevengosId) {
		this.odevengosId = odevengosId;
	}

	public Trabajador getTrabId() {
		return this.trabId;
	}

	public void setTrabId(Trabajador trabId) {
		this.trabId = trabId;
	}

	public ConceptoNomina getConceptoNominaId() {
		return this.conceptoNominaId;
	}

	public void setConceptoNominaId(ConceptoNomina conceptoNominaId) {
		this.conceptoNominaId = conceptoNominaId;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Double getValorDeduccion() {
		return this.valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
