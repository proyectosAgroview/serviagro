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
public class DatClimatDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatClimatDTO.class);
	private String codigo;
	private Long compania;
	private Long datsClimatoId;
	private Double direccionViento;
	private Double energiaSolar;
	private String estado;
	private Double evaporacion;
	private Double evaporacionTranspiracion;
	private Date fechaAnulacion;
	private Date fechaCreacion;
	private Date fechaLluvia;
	private Date fechaModificacion;
	private Double gradosDiaCalor;
	private Double gradosDiaFrio;
	private Double humedadMaxima;
	private Double horasLuz;
	private Double horasSol;
	private Double humedadExterior;
	private Double humedadInterior;
	private Double humedadMedia;
	private Double humedadMinima;
	private String infoAdicional;
	private String infoAdicional2;
	private Double insolacion;
	private Double nubosidad;
	private String observacion;
	private String observacionAnularReg;
	private Double precipitacion;
	private Double puntoRocio;
	private Double radiacionSolar;
	private Double sensacionTermica;
	private Double temperaturaAmbiente;
	private Double temperaturaMaxima;
	private Double temperaturaMedia;
	private Double temperaturaMinima;
	private Double velocidadMaxima;
	private Double velocidadViento;
	private Long estClimatId_EstClimat;
	private String nombreEstclimat;
	private String estadoTrue;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getDatsClimatoId() {
		return datsClimatoId;
	}

	public void setDatsClimatoId(Long datsClimatoId) {
		this.datsClimatoId = datsClimatoId;
	}

	public Double getDireccionViento() {
		return direccionViento;
	}

	public void setDireccionViento(Double direccionViento) {
		this.direccionViento = direccionViento;
	}

	public Double getEnergiaSolar() {
		return energiaSolar;
	}

	public void setEnergiaSolar(Double energiaSolar) {
		this.energiaSolar = energiaSolar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getEvaporacion() {
		return evaporacion;
	}

	public void setEvaporacion(Double evaporacion) {
		this.evaporacion = evaporacion;
	}

	public Double getEvaporacionTranspiracion() {
		return evaporacionTranspiracion;
	}

	public void setEvaporacionTranspiracion(Double evaporacionTranspiracion) {
		this.evaporacionTranspiracion = evaporacionTranspiracion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaLluvia() {
		return fechaLluvia;
	}

	public void setFechaLluvia(Date fechaLluvia) {
		this.fechaLluvia = fechaLluvia;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Double getGradosDiaCalor() {
		return gradosDiaCalor;
	}

	public void setGradosDiaCalor(Double gradosDiaCalor) {
		this.gradosDiaCalor = gradosDiaCalor;
	}

	public Double getGradosDiaFrio() {
		return gradosDiaFrio;
	}

	public void setGradosDiaFrio(Double gradosDiaFrio) {
		this.gradosDiaFrio = gradosDiaFrio;
	}

	public Double getHemedadMaxima() {
		return humedadMaxima;
	}

	public void setHemedadMaxima(Double hemedadMaxima) {
		this.humedadMaxima = hemedadMaxima;
	}

	public Double getHorasLuz() {
		return horasLuz;
	}

	public void setHorasLuz(Double horasLuz) {
		this.horasLuz = horasLuz;
	}

	public Double getHorasSol() {
		return horasSol;
	}

	public void setHorasSol(Double horasSol) {
		this.horasSol = horasSol;
	}

	public Double getHumedadExterior() {
		return humedadExterior;
	}

	public void setHumedadExterior(Double humedadExterior) {
		this.humedadExterior = humedadExterior;
	}

	public Double getHumedadInterior() {
		return humedadInterior;
	}

	public void setHumedadInterior(Double humedadInterior) {
		this.humedadInterior = humedadInterior;
	}

	public Double getHumedadMedia() {
		return humedadMedia;
	}

	public void setHumedadMedia(Double humedadMedia) {
		this.humedadMedia = humedadMedia;
	}

	public Double getHumedadMinima() {
		return humedadMinima;
	}

	public void setHumedadMinima(Double humedadMinima) {
		this.humedadMinima = humedadMinima;
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

	public Double getInsolacion() {
		return insolacion;
	}

	public void setInsolacion(Double insolacion) {
		this.insolacion = insolacion;
	}

	public Double getNubosidad() {
		return nubosidad;
	}

	public void setNubosidad(Double nubosidad) {
		this.nubosidad = nubosidad;
	}

	public Double getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(Double precipitacion) {
		this.precipitacion = precipitacion;
	}

	public Double getPuntoRocio() {
		return puntoRocio;
	}

	public void setPuntoRocio(Double puntoRocio) {
		this.puntoRocio = puntoRocio;
	}

	public Double getRadiacionSolar() {
		return radiacionSolar;
	}

	public void setRadiacionSolar(Double radiacionSolar) {
		this.radiacionSolar = radiacionSolar;
	}

	public Double getSensacionTermica() {
		return sensacionTermica;
	}

	public void setSensacionTermica(Double sensacionTermica) {
		this.sensacionTermica = sensacionTermica;
	}

	public Double getTemperaturaAmbiente() {
		return temperaturaAmbiente;
	}

	public void setTemperaturaAmbiente(Double temperaturaAmbiente) {
		this.temperaturaAmbiente = temperaturaAmbiente;
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

	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Double getVelocidadViento() {
		return velocidadViento;
	}

	public void setVelocidadViento(Double velocidadViento) {
		this.velocidadViento = velocidadViento;
	}

	public Long getEstClimatId_EstClimat() {
		return estClimatId_EstClimat;
	}

	public void setEstClimatId_EstClimat(Long estClimatId_EstClimat) {
		this.estClimatId_EstClimat = estClimatId_EstClimat;
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

	public String getNombreEstclimat() {
		return nombreEstclimat;
	}

	public void setNombreEstclimat(String nombreEstclimat) {
		this.nombreEstclimat = nombreEstclimat;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

}
