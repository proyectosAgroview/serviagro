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
public class DatEvaporimetroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatEvaporimetroDTO.class);

	private Long compania;
	private Long datEvaporimetroId;
	private String estado;
	private Long evaporacion;
	private Date fechaAnulacion;
	private Date fechaCreacion;
	private Date fechaEvaporacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String observacion;
	private String observacionAnularReg;
	private Long temperaturaMaxima;
	private Long temperaturaMedia;
	private Long temperaturaMinima;
	private Long estEvaporimetroId_EstEvaporimetro;
	private String estacionEvaporimetro;
	private String estadoTrue;

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getDatEvaporimetroId() {
		return datEvaporimetroId;
	}

	public void setDatEvaporimetroId(Long datEvaporimetroId) {
		this.datEvaporimetroId = datEvaporimetroId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEvaporacion() {
		return evaporacion;
	}

	public void setEvaporacion(Long evaporacion) {
		this.evaporacion = evaporacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEvaporacion() {
		return fechaEvaporacion;
	}

	public void setFechaEvaporacion(Date fechaEvaporacion) {
		this.fechaEvaporacion = fechaEvaporacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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

	public Long getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Long temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Long getTemperaturaMedia() {
		return temperaturaMedia;
	}

	public void setTemperaturaMedia(Long temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public Long getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(Long temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public Long getEstEvaporimetroId_EstEvaporimetro() {
		return estEvaporimetroId_EstEvaporimetro;
	}

	public void setEstEvaporimetroId_EstEvaporimetro(Long estEvaporimetroId_EstEvaporimetro) {
		this.estEvaporimetroId_EstEvaporimetro = estEvaporimetroId_EstEvaporimetro;
	}

	public String getEstacionEvaporimetro() {
		return estacionEvaporimetro;
	}

	public void setEstacionEvaporimetro(String estacionEvaporimetro) {
		this.estacionEvaporimetro = estacionEvaporimetro;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
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

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

}
