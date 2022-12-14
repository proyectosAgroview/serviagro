package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatAnaTransProd generated by hbm2java
 */
public class DatAnaTransProd implements java.io.Serializable {

	private Long datAnaTransProdId;
	private DatTransProd datTransProd;
	private AnaLaboratorio anaLaboratorio;
	private Long responsable;
	private Long consecutivo;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Date fechaAnalisis;
	private String observacion;
	private String mobileId;
	private Long usuarioDigitacion;
	private String observacionAnularReg;
	private Set<ValorVarAnaTrans> valorVarAnaTranses = new HashSet<ValorVarAnaTrans>(0);

	public DatAnaTransProd() {
	}

	public DatAnaTransProd(Long datAnaTransProdId) {
		this.datAnaTransProdId = datAnaTransProdId;
	}

	public DatAnaTransProd(Long datAnaTransProdId, DatTransProd datTransProd, AnaLaboratorio anaLaboratorio,
			Long responsable, Long consecutivo, Long compania, String infoAdicional, String infoAdicional2,
			Date fechaCreacion, Date fechaModificacion, String estado, Date fechaAnalisis, String observacion,
			String mobileId, Long usuarioDigitacion, String observacionAnularReg,
			Set<ValorVarAnaTrans> valorVarAnaTranses) {
		this.datAnaTransProdId = datAnaTransProdId;
		this.datTransProd = datTransProd;
		this.anaLaboratorio = anaLaboratorio;
		this.responsable = responsable;
		this.consecutivo = consecutivo;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.fechaAnalisis = fechaAnalisis;
		this.observacion = observacion;
		this.mobileId = mobileId;
		this.usuarioDigitacion = usuarioDigitacion;
		this.observacionAnularReg = observacionAnularReg;
		this.valorVarAnaTranses = valorVarAnaTranses;
	}

	public Long getDatAnaTransProdId() {
		return this.datAnaTransProdId;
	}

	public void setDatAnaTransProdId(Long datAnaTransProdId) {
		this.datAnaTransProdId = datAnaTransProdId;
	}

	public DatTransProd getDatTransProd() {
		return this.datTransProd;
	}

	public void setDatTransProd(DatTransProd datTransProd) {
		this.datTransProd = datTransProd;
	}

	public AnaLaboratorio getAnaLaboratorio() {
		return this.anaLaboratorio;
	}

	public void setAnaLaboratorio(AnaLaboratorio anaLaboratorio) {
		this.anaLaboratorio = anaLaboratorio;
	}

	public Long getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Long responsable) {
		this.responsable = responsable;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Date getFechaAnalisis() {
		return this.fechaAnalisis;
	}

	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getMobileId() {
		return this.mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public Long getUsuarioDigitacion() {
		return this.usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public String getObservacionAnularReg() {
		return this.observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Set<ValorVarAnaTrans> getValorVarAnaTranses() {
		return this.valorVarAnaTranses;
	}

	public void setValorVarAnaTranses(Set<ValorVarAnaTrans> valorVarAnaTranses) {
		this.valorVarAnaTranses = valorVarAnaTranses;
	}

}
