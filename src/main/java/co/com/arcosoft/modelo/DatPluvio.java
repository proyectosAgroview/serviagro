package co.com.arcosoft.modelo;

// Generated 04-jun-2015 12:48:56 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * DatPluvio generated by hbm2java
 */
public class DatPluvio implements java.io.Serializable {

	private Long datPluvioId;
	private EstPluvio estPluvio;
	public Long compania;
	private Double precipitacion;
	private Double temperaturaMaxima;
	private Double temperaturaMedia;
	private Double temperaturaMinima;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Date fechaPrecipitacion;
	private String observacion;
	private String observacionAnularReg;
	private Date fechaAnulacion;
	private Long consecutivo;
	
	public DatPluvio() {
	}

	public DatPluvio(Long datPluvioId) {
		this.datPluvioId = datPluvioId;
	}

	public DatPluvio(Long datPluvioId, EstPluvio estPluvio, Long compania, Double precipitacion,
			Double temperaturaMaxima, Double temperaturaMedia, Double temperaturaMinima, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, Date fechaPrecipitacion,
			String observacion, String observacionAnularReg, Date fechaAnulacion, Long consecutivo) {
		this.datPluvioId = datPluvioId;
		this.estPluvio = estPluvio;
		this.compania = compania;
		this.precipitacion = precipitacion;
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMedia = temperaturaMedia;
		this.temperaturaMinima = temperaturaMinima;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.fechaPrecipitacion = fechaPrecipitacion;
		this.observacion = observacion;
		this.observacionAnularReg = observacionAnularReg;
		this.fechaAnulacion = fechaAnulacion;
		this.consecutivo = consecutivo;
	}

	
	/**
	 * @return the consecutivo
	 */
	public Long getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getDatPluvioId() {
		return this.datPluvioId;
	}

	public void setDatPluvioId(Long datPluvioId) {
		this.datPluvioId = datPluvioId;
	}

	public EstPluvio getEstPluvio() {
		return this.estPluvio;
	}

	public void setEstPluvio(EstPluvio estPluvio) {
		this.estPluvio = estPluvio;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getPrecipitacion() {
		return this.precipitacion;
	}

	public void setPrecipitacion(Double precipitacion) {
		this.precipitacion = precipitacion;
	}

	public Double getTemperaturaMaxima() {
		return this.temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Double getTemperaturaMedia() {
		return this.temperaturaMedia;
	}

	public void setTemperaturaMedia(Double temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public Double getTemperaturaMinima() {
		return this.temperaturaMinima;
	}

	public void setTemperaturaMinima(Double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
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

	public Date getFechaPrecipitacion() {
		return this.fechaPrecipitacion;
	}

	public void setFechaPrecipitacion(Date fechaPrecipitacion) {
		this.fechaPrecipitacion = fechaPrecipitacion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacionAnularReg() {
		return this.observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

}