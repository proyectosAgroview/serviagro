package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * CostoRecursoId generated by hbm2java
 */
public class CostoRecursoId implements java.io.Serializable {

	private Long recursoId;
	public Long compania;
	private Date fechaInicial;
	private Date fechaFinal;
	private Long udadMedId;
	private Double valorUnitEst;
	private Long elemCostoId;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;

	public CostoRecursoId() {
	}

	public CostoRecursoId(Long recursoId, Long compania, Date fechaInicial, Date fechaFinal, Long udadMedId,
			Double valorUnitEst, Long elemCostoId, String infoAdicional, String infoAdicional2, Date fechaCreacion,
			Date fechaModificacion, String estado) {
		this.recursoId = recursoId;
		this.compania = compania;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.udadMedId = udadMedId;
		this.valorUnitEst = valorUnitEst;
		this.elemCostoId = elemCostoId;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Long getRecursoId() {
		return this.recursoId;
	}

	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
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

	public Long getUdadMedId() {
		return this.udadMedId;
	}

	public void setUdadMedId(Long udadMedId) {
		this.udadMedId = udadMedId;
	}

	public Double getValorUnitEst() {
		return this.valorUnitEst;
	}

	public void setValorUnitEst(Double valorUnitEst) {
		this.valorUnitEst = valorUnitEst;
	}

	public Long getElemCostoId() {
		return this.elemCostoId;
	}

	public void setElemCostoId(Long elemCostoId) {
		this.elemCostoId = elemCostoId;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
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

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CostoRecursoId))
			return false;
		CostoRecursoId castOther = (CostoRecursoId) other;

		return ((this.getRecursoId() == castOther.getRecursoId()) || (this.getRecursoId() != null
				&& castOther.getRecursoId() != null && this.getRecursoId().equals(castOther.getRecursoId())))
				&& ((this.getCompania() == castOther.getCompania()) || (this.getCompania() != null
						&& castOther.getCompania() != null && this.getCompania().equals(castOther.getCompania())))
				&& ((this.getFechaInicial() == castOther.getFechaInicial())
						|| (this.getFechaInicial() != null && castOther.getFechaInicial() != null
								&& this.getFechaInicial().equals(castOther.getFechaInicial())))
				&& ((this.getFechaFinal() == castOther.getFechaFinal()) || (this.getFechaFinal() != null
						&& castOther.getFechaFinal() != null && this.getFechaFinal().equals(castOther.getFechaFinal())))
				&& ((this.getUdadMedId() == castOther.getUdadMedId()) || (this.getUdadMedId() != null
						&& castOther.getUdadMedId() != null && this.getUdadMedId().equals(castOther.getUdadMedId())))
				&& ((this.getValorUnitEst() == castOther.getValorUnitEst())
						|| (this.getValorUnitEst() != null && castOther.getValorUnitEst() != null
								&& this.getValorUnitEst().equals(castOther.getValorUnitEst())))
				&& ((this.getElemCostoId() == castOther.getElemCostoId())
						|| (this.getElemCostoId() != null && castOther.getElemCostoId() != null
								&& this.getElemCostoId().equals(castOther.getElemCostoId())))
				&& ((this.getInfoAdicional() == castOther.getInfoAdicional())
						|| (this.getInfoAdicional() != null && castOther.getInfoAdicional() != null
								&& this.getInfoAdicional().equals(castOther.getInfoAdicional())))
				&& ((this.getInfoAdicional2() == castOther.getInfoAdicional2())
						|| (this.getInfoAdicional2() != null && castOther.getInfoAdicional2() != null
								&& this.getInfoAdicional2().equals(castOther.getInfoAdicional2())))
				&& ((this.getFechaCreacion() == castOther.getFechaCreacion())
						|| (this.getFechaCreacion() != null && castOther.getFechaCreacion() != null
								&& this.getFechaCreacion().equals(castOther.getFechaCreacion())))
				&& ((this.getFechaModificacion() == castOther.getFechaModificacion())
						|| (this.getFechaModificacion() != null && castOther.getFechaModificacion() != null
								&& this.getFechaModificacion().equals(castOther.getFechaModificacion())))
				&& ((this.getEstado() == castOther.getEstado()) || (this.getEstado() != null
						&& castOther.getEstado() != null && this.getEstado().equals(castOther.getEstado())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRecursoId() == null ? 0 : this.getRecursoId().hashCode());
		result = 37 * result + (getCompania() == null ? 0 : this.getCompania().hashCode());
		result = 37 * result + (getFechaInicial() == null ? 0 : this.getFechaInicial().hashCode());
		result = 37 * result + (getFechaFinal() == null ? 0 : this.getFechaFinal().hashCode());
		result = 37 * result + (getUdadMedId() == null ? 0 : this.getUdadMedId().hashCode());
		result = 37 * result + (getValorUnitEst() == null ? 0 : this.getValorUnitEst().hashCode());
		result = 37 * result + (getElemCostoId() == null ? 0 : this.getElemCostoId().hashCode());
		result = 37 * result + (getInfoAdicional() == null ? 0 : this.getInfoAdicional().hashCode());
		result = 37 * result + (getInfoAdicional2() == null ? 0 : this.getInfoAdicional2().hashCode());
		result = 37 * result + (getFechaCreacion() == null ? 0 : this.getFechaCreacion().hashCode());
		result = 37 * result + (getFechaModificacion() == null ? 0 : this.getFechaModificacion().hashCode());
		result = 37 * result + (getEstado() == null ? 0 : this.getEstado().hashCode());
		return result;
	}

}
