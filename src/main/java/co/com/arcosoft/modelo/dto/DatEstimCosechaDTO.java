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
public class DatEstimCosechaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatEstimCosechaDTO.class);
	private Long anioFiscalNivel4;
	private Double areaNeta;
	private Double cantidadTotalEst;
	private Long compania;
	private Long trabajador;
	private Long consecutivo;
	private Long datEstimCosechaId;
	private Double edadNivel4;
	private String estado;
	private Long etapaNivel4;
	private Long faseFenoNivel4;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaMuestra;
	private String infoAdicional;
	private String infoAdicional2;
	private String mobileId;
	private Long nivel1Id;
	private Long nivel2Id;
	private Long nivel3Id;
	private Long nivel4Id;
	private String observacion;
	private String observacionAnularReg;
	private Double thEstimado;
	private Long usuarioDigitacion;
	private Long variedNivel4;
	private Long motEstimId_MotEstim;
	private String nivel2Nombre;
	private String nivel4Nombre;
	private String trabajadorCodigo;
	private String trabajadorNombre;
	private Float latitud;
	private Float longitud;
	private Float precision;
	private Date fechaAnulacion;
	private String estadoTrue;

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getNivel2Nombre() {
		return nivel2Nombre;
	}

	public void setNivel2Nombre(String nivel2Nombre) {
		this.nivel2Nombre = nivel2Nombre;
	}

	public String getNivel4Nombre() {
		return nivel4Nombre;
	}

	public void setNivel4Nombre(String nivel4Nombre) {
		this.nivel4Nombre = nivel4Nombre;
	}

	public String getTrabajadorCodigo() {
		return trabajadorCodigo;
	}

	public void setTrabajadorCodigo(String trabajadorCodigo) {
		this.trabajadorCodigo = trabajadorCodigo;
	}

	public String getTrabajadorNombre() {
		return trabajadorNombre;
	}

	public void setTrabajadorNombre(String trabajadorNombre) {
		this.trabajadorNombre = trabajadorNombre;
	}

	public Long getAnioFiscalNivel4() {
		return anioFiscalNivel4;
	}

	public void setAnioFiscalNivel4(Long anioFiscalNivel4) {
		this.anioFiscalNivel4 = anioFiscalNivel4;
	}

	public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public Double getCantidadTotalEst() {
		return cantidadTotalEst;
	}

	public Long getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Long trabajador) {
		this.trabajador = trabajador;
	}

	public void setCantidadTotalEst(Double cantidadTotalEst) {
		this.cantidadTotalEst = cantidadTotalEst;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getDatEstimCosechaId() {
		return datEstimCosechaId;
	}

	public void setDatEstimCosechaId(Long datEstimCosechaId) {
		this.datEstimCosechaId = datEstimCosechaId;
	}

	public Double getEdadNivel4() {
		return edadNivel4;
	}

	public void setEdadNivel4(Double edadNivel4) {
		this.edadNivel4 = edadNivel4;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEtapaNivel4() {
		return etapaNivel4;
	}

	public void setEtapaNivel4(Long etapaNivel4) {
		this.etapaNivel4 = etapaNivel4;
	}

	public Long getFaseFenoNivel4() {
		return faseFenoNivel4;
	}

	public void setFaseFenoNivel4(Long faseFenoNivel4) {
		this.faseFenoNivel4 = faseFenoNivel4;
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

	public Date getFechaMuestra() {
		return fechaMuestra;
	}

	public void setFechaMuestra(Date fechaMuestra) {
		this.fechaMuestra = fechaMuestra;
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

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public Long getNivel1Id() {
		return nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Long getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Long nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Long getNivel3Id() {
		return nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Long getNivel4Id() {
		return nivel4Id;
	}

	public void setNivel4Id(Long nivel4Id) {
		this.nivel4Id = nivel4Id;
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

	public Double getThEstimado() {
		return thEstimado;
	}

	public void setThEstimado(Double thEstimado) {
		this.thEstimado = thEstimado;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getVariedNivel4() {
		return variedNivel4;
	}

	public void setVariedNivel4(Long variedNivel4) {
		this.variedNivel4 = variedNivel4;
	}

	public Long getMotEstimId_MotEstim() {
		return motEstimId_MotEstim;
	}

	public void setMotEstimId_MotEstim(Long motEstimId_MotEstim) {
		this.motEstimId_MotEstim = motEstimId_MotEstim;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

}
