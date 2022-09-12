package co.com.arcosoft.modelo;

// Generated 17-mar-2015 15:25:33 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * DatEvaporimetro generated by hbm2java
 */
public class DatEvaporimetro implements java.io.Serializable {

	private Long datEvaporimetroId;
	private EstEvaporimetro estEvaporimetro;
	public Long compania;
	private Long evaporacion;
	private Long temperaturaMaxima;
	private Long temperaturaMedia;
	private Long temperaturaMinima;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Date fechaEvaporacion;
	private String observacion;
	private String observacionAnularReg;
	private Date fechaAnulacion;

	public DatEvaporimetro() {
	}

	public DatEvaporimetro(Long datEvaporimetroId) {
		this.datEvaporimetroId = datEvaporimetroId;
	}

	public DatEvaporimetro(Long datEvaporimetroId, EstEvaporimetro estEvaporimetro, String codigo, Long compania,
			Long evaporacion, Long temperaturaMaxima, Long temperaturaMedia, Long temperaturaMinima,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Date fechaEvaporacion, String observacion, String observacionAnularReg, Date fechaAnulacion) {
		this.datEvaporimetroId = datEvaporimetroId;
		this.estEvaporimetro = estEvaporimetro;
		this.compania = compania;
		this.evaporacion = evaporacion;
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMedia = temperaturaMedia;
		this.temperaturaMinima = temperaturaMinima;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.fechaEvaporacion = fechaEvaporacion;
		this.observacion = observacion;
		this.observacionAnularReg = observacionAnularReg;
		this.fechaAnulacion = fechaAnulacion;
	}

	public Long getDatEvaporimetroId() {
		return this.datEvaporimetroId;
	}

	public void setDatEvaporimetroId(Long datEvaporimetroId) {
		this.datEvaporimetroId = datEvaporimetroId;
	}

	public EstEvaporimetro getEstEvaporimetro() {
		return this.estEvaporimetro;
	}

	public void setEstEvaporimetro(EstEvaporimetro estEvaporimetro) {
		this.estEvaporimetro = estEvaporimetro;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getEvaporacion() {
		return this.evaporacion;
	}

	public void setEvaporacion(Long evaporacion) {
		this.evaporacion = evaporacion;
	}

	public Long getTemperaturaMaxima() {
		return this.temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Long temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Long getTemperaturaMedia() {
		return this.temperaturaMedia;
	}

	public void setTemperaturaMedia(Long temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public Long getTemperaturaMinima() {
		return this.temperaturaMinima;
	}

	public void setTemperaturaMinima(Long temperaturaMinima) {
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

	public Date getFechaEvaporacion() {
		return this.fechaEvaporacion;
	}

	public void setFechaEvaporacion(Date fechaEvaporacion) {
		this.fechaEvaporacion = fechaEvaporacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacionAnularReg() {
		return observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

}