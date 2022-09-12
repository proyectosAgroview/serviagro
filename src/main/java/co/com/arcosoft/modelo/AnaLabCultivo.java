package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * AnaLabCultivo generated by hbm2java
 */
public class AnaLabCultivo implements java.io.Serializable {

	private Long anaLabCultId;
	private Cultivo cultivo;
	private AnaLaboratorio anaLaboratorio;
	public Long compania;
	private Date fechaCreacion;
	private Date fechaModificacion;

	public AnaLabCultivo() {
	}

	public AnaLabCultivo(Long anaLabCultId) {
		this.anaLabCultId = anaLabCultId;
	}

	public AnaLabCultivo(Long anaLabCultId, Cultivo cultivo, AnaLaboratorio anaLaboratorio, Long compania,
			Date fechaCreacion, Date fechaModificacion) {
		this.anaLabCultId = anaLabCultId;
		this.cultivo = cultivo;
		this.anaLaboratorio = anaLaboratorio;
		this.compania = compania;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Long getAnaLabCultId() {
		return this.anaLabCultId;
	}

	public void setAnaLabCultId(Long anaLabCultId) {
		this.anaLabCultId = anaLabCultId;
	}

	public Cultivo getCultivo() {
		return this.cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public AnaLaboratorio getAnaLaboratorio() {
		return this.anaLaboratorio;
	}

	public void setAnaLaboratorio(AnaLaboratorio anaLaboratorio) {
		this.anaLaboratorio = anaLaboratorio;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

}
