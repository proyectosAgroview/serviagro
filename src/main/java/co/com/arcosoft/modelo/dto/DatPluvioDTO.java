package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatPluvioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPluvioDTO.class);
	private Long compania;
	private Long datPluvioId;
	private String estado;
	private Date fechaAnulacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaPrecipitacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String observacion;
	private String observacionAnularReg;
	private Double precipitacion;
	private Double temperaturaMaxima;
	private Double temperaturaMedia;
	private Double temperaturaMinima;
	private Long estPluvioId_EstPluvio;
	private String EstacionPluvio;
	private String estadoTrue;
	private Long consecutivo;
	

	
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

	public String getEstacionPluvio() {
		return EstacionPluvio;
	}

	public void setEstacionPluvio(String estacionPluvio) {
		EstacionPluvio = estacionPluvio;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getDatPluvioId() {
		return datPluvioId;
	}

	public void setDatPluvioId(Long datPluvioId) {
		this.datPluvioId = datPluvioId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaPrecipitacion() {
		return fechaPrecipitacion;
	}

	public void setFechaPrecipitacion(Date fechaPrecipitacion) {
		this.fechaPrecipitacion = fechaPrecipitacion;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
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

	public Double getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(Double precipitacion) {
		this.precipitacion = precipitacion;
	}

	public Double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Double getTemperaturaMedia() {
		return temperaturaMedia;
	}

	public void setTemperaturaMedia(Double temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public Double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(Double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public Long getEstPluvioId_EstPluvio() {
		return estPluvioId_EstPluvio;
	}

	public void setEstPluvioId_EstPluvio(Long estPluvioId_EstPluvio) {
		this.estPluvioId_EstPluvio = estPluvioId_EstPluvio;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

}
