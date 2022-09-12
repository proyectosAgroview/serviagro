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
public class DatAnaTransProdDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatAnaTransProdDTO.class);
	private Long compania;
	private Long consecutivo;
	private Long datAnaTransProdId;
	private String estado;
	private Date fechaAnalisis;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String mobileId;
	private String observacion;
	private String observacionAnularReg;
	private Long responsable;
	private Long usuarioDigitacion;
	private Long anaLabId_AnaLaboratorio;
	private Long datTransProdId_DatTransProd;

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getDatAnaTransProdId() {
		return datAnaTransProdId;
	}

	public void setDatAnaTransProdId(Long datAnaTransProdId) {
		this.datAnaTransProdId = datAnaTransProdId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}

	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
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

	public Long getResponsable() {
		return responsable;
	}

	public void setResponsable(Long responsable) {
		this.responsable = responsable;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getAnaLabId_AnaLaboratorio() {
		return anaLabId_AnaLaboratorio;
	}

	public void setAnaLabId_AnaLaboratorio(Long anaLabId_AnaLaboratorio) {
		this.anaLabId_AnaLaboratorio = anaLabId_AnaLaboratorio;
	}

	public Long getDatTransProdId_DatTransProd() {
		return datTransProdId_DatTransProd;
	}

	public void setDatTransProdId_DatTransProd(Long datTransProdId_DatTransProd) {
		this.datTransProdId_DatTransProd = datTransProdId_DatTransProd;
	}
}
