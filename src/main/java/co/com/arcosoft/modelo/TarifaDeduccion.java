package co.com.arcosoft.modelo;
// Generated 19-jul-2016 10:41:37 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * TarifaDeduccion generated by hbm2java
 */
public class TarifaDeduccion implements java.io.Serializable {

	private Long deduccionId;
	private Trabajador trabajador;
	private ConceptoNomina conceptoNominaId;
	private Long compania;
	private Date fechaInicial;
	private Date fechaFinal;
	private Double valorDeduccion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;

	public TarifaDeduccion() {
	}

	public TarifaDeduccion(Long deduccionId) {
		this.deduccionId = deduccionId;
	}

	public TarifaDeduccion(Long deduccionId, Trabajador trabajador, ConceptoNomina conceptoNominaId, Long compania,
			Date fechaInicial, Date fechaFinal, Double valorDeduccion, Date fechaCreacion, Date fechaModificacion,
			String estado) {
		this.deduccionId = deduccionId;
		this.trabajador = trabajador;
		this.conceptoNominaId = conceptoNominaId;
		this.compania = compania;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.valorDeduccion = valorDeduccion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Long getDeduccionId() {
		return this.deduccionId;
	}

	public void setDeduccionId(Long deduccionId) {
		this.deduccionId = deduccionId;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
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
