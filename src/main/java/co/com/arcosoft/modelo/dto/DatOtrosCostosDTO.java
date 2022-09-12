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
public class DatOtrosCostosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosDTO.class);
	private Long compania;
	private Long consecutivo;
	private Long datOtrosCostosId;
	private Long equipoId;
	private String estado;
	private Date fechaAnulacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private String infoAdicional;
	private String infoAdicional2;
	private Long infraId;
	private String numFactura;
	private String observacion;
	private String observacionAnularReg;
	private String reglaDistribuccion;
	private String serieFactura;
	private String tipoTransaccion;
	private Long usuarioDigitacion;
	private Double valorTotal;
	private Long centCostId_CentCost;
	private Long elemCostoId_ElementoCosto;
	private Long laborId_Labor;
	private Long persEmprId_PersEmpr;
	private Date fechaInicial;
	private Long nivel2Indicador;

	private String nomUsuarioDigitacion;
	private String codLabor;
	private String nomLabor;	
	private String proveedor;

	public Long getNivel2Indicador() {
		return nivel2Indicador;
	}
	
	public void setNivel2Indicador(Long nivel2Indicador) {
		this.nivel2Indicador = nivel2Indicador;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

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

	public Long getDatOtrosCostosId() {
		return datOtrosCostosId;
	}

	public void setDatOtrosCostosId(Long datOtrosCostosId) {
		this.datOtrosCostosId = datOtrosCostosId;
	}

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	public Long getInfraId() {
		return infraId;
	}

	public void setInfraId(Long infraId) {
		this.infraId = infraId;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
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

	public String getReglaDistribuccion() {
		return reglaDistribuccion;
	}

	public void setReglaDistribuccion(String reglaDistribuccion) {
		this.reglaDistribuccion = reglaDistribuccion;
	}

	public String getSerieFactura() {
		return serieFactura;
	}

	public void setSerieFactura(String serieFactura) {
		this.serieFactura = serieFactura;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Long getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getNomLabor() {
		return nomLabor;
	}

	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getNomUsuarioDigitacion() {
		return nomUsuarioDigitacion;
	}

	public void setNomUsuarioDigitacion(String nomUsuarioDigitacion) {
		this.nomUsuarioDigitacion = nomUsuarioDigitacion;
	}
}
