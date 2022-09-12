package co.com.arcosoft.modelo;
// Generated 14-abr-2016 14:31:07 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * TarifaProfesionId generated by hbm2java
 */
public class TarifaProfesionId implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	public Long compania;
	private Long tarifaProfId;
	private Profesion profesionId;
	private Long ceptoNominaId;
	private Long udadMedId;
	private Double tarifa;
	private Date fechaInicial;
	private Date fechaFinal;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long persEmprId;

	public Long getPersEmprId() {
		return persEmprId;
	}

	public void setPersEmprId(Long persEmprId) {
		this.persEmprId = persEmprId;
	}

	public TarifaProfesionId() {
	}

	public TarifaProfesionId(Long tarifaProfId) {
		this.tarifaProfId = tarifaProfId;
	}

	public TarifaProfesionId(Long compania, Long tarifaProfId, Profesion profesionId, Long ceptoNominaId,
			Long udadMedId, Double tarifa, Date fechaInicial, Long persEmprId, Date fechaFinal, Date fechaCreacion,
			Date fechaModificacion) {
		this.compania = compania;
		this.tarifaProfId = tarifaProfId;
		this.profesionId = profesionId;
		this.ceptoNominaId = ceptoNominaId;
		this.udadMedId = udadMedId;
		this.tarifa = tarifa;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.persEmprId = persEmprId;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getTarifaProfId() {
		return this.tarifaProfId;
	}

	public void setTarifaProfId(Long tarifaProfId) {
		this.tarifaProfId = tarifaProfId;
	}

	public Profesion getProfesionId() {
		return this.profesionId;
	}

	public void setProfesionId(Profesion entity) {
		this.profesionId = entity;
	}

	public Long getCeptoNominaId() {
		return this.ceptoNominaId;
	}

	public void setCeptoNominaId(Long ceptoNominaId) {
		this.ceptoNominaId = ceptoNominaId;
	}

	public Long getUdadMedId() {
		return this.udadMedId;
	}

	public void setUdadMedId(Long udadMedId) {
		this.udadMedId = udadMedId;
	}

	public Double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
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

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TarifaProfesionId))
			return false;
		TarifaProfesionId castOther = (TarifaProfesionId) other;

		return ((this.getCompania() == castOther.getCompania()) || (this.getCompania() != null
				&& castOther.getCompania() != null && this.getCompania().equals(castOther.getCompania())))
				&& ((this.getTarifaProfId() == castOther.getTarifaProfId())
						|| (this.getTarifaProfId() != null && castOther.getTarifaProfId() != null
								&& this.getTarifaProfId().equals(castOther.getTarifaProfId())))
				&& ((this.getProfesionId() == castOther.getProfesionId())
						|| (this.getProfesionId() != null && castOther.getProfesionId() != null
								&& this.getProfesionId().equals(castOther.getProfesionId())))
				&& ((this.getCeptoNominaId() == castOther.getCeptoNominaId())
						|| (this.getCeptoNominaId() != null && castOther.getCeptoNominaId() != null
								&& this.getCeptoNominaId().equals(castOther.getCeptoNominaId())))
				&& ((this.getUdadMedId() == castOther.getUdadMedId()) || (this.getUdadMedId() != null
						&& castOther.getUdadMedId() != null && this.getUdadMedId().equals(castOther.getUdadMedId())))
				&& ((this.getTarifa() == castOther.getTarifa()) || (this.getTarifa() != null
						&& castOther.getTarifa() != null && this.getTarifa().equals(castOther.getTarifa())))
				&& ((this.getFechaInicial() == castOther.getFechaInicial())
						|| (this.getFechaInicial() != null && castOther.getFechaInicial() != null
								&& this.getFechaInicial().equals(castOther.getFechaInicial())))
				&& ((this.getFechaFinal() == castOther.getFechaFinal()) || (this.getFechaFinal() != null
						&& castOther.getFechaFinal() != null && this.getFechaFinal().equals(castOther.getFechaFinal())))
				&& ((this.getFechaCreacion() == castOther.getFechaCreacion())
						|| (this.getFechaCreacion() != null && castOther.getFechaCreacion() != null
								&& this.getFechaCreacion().equals(castOther.getFechaCreacion())))
				&& ((this.getFechaModificacion() == castOther.getFechaModificacion())
						|| (this.getFechaModificacion() != null && castOther.getFechaModificacion() != null
								&& this.getFechaModificacion().equals(castOther.getFechaModificacion())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCompania() == null ? 0 : this.getCompania().hashCode());
		result = 37 * result + (getTarifaProfId() == null ? 0 : this.getTarifaProfId().hashCode());
		result = 37 * result + (getProfesionId() == null ? 0 : this.getProfesionId().hashCode());
		result = 37 * result + (getCeptoNominaId() == null ? 0 : this.getCeptoNominaId().hashCode());
		result = 37 * result + (getUdadMedId() == null ? 0 : this.getUdadMedId().hashCode());
		result = 37 * result + (getTarifa() == null ? 0 : this.getTarifa().hashCode());
		result = 37 * result + (getFechaInicial() == null ? 0 : this.getFechaInicial().hashCode());
		result = 37 * result + (getFechaFinal() == null ? 0 : this.getFechaFinal().hashCode());
		result = 37 * result + (getFechaCreacion() == null ? 0 : this.getFechaCreacion().hashCode());
		result = 37 * result + (getFechaModificacion() == null ? 0 : this.getFechaModificacion().hashCode());
		return result;
	}

	public void setProfesionId(Long long1) {
		// TODO Auto-generated method stub

	}

}