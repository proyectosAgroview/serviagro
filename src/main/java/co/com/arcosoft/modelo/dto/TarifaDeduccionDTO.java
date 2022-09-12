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
public class TarifaDeduccionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaDeduccionDTO.class);
	private Long compania;
	private ConceptoNomina conceptoNominaId;
	private Long deduccionId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Double valorDeduccion;
	private Trabajador trabId_Trabajador;
	private String codConceptoNomina;

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

	public Long getDeduccionId() {
		return deduccionId;
	}

	public void setDeduccionId(Long deduccionId) {
		this.deduccionId = deduccionId;
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

	public Double getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public String getCodConceptoNomina() {
		return codConceptoNomina;
	}

	public void setCodConceptoNomina(String codConceptoNomina) {
		this.codConceptoNomina = codConceptoNomina;
	}

}
