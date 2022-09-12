package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CategoriaEquipo;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatOtrosMovInventarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosMovInventarioDTO.class);
	private Long compania;
	private Long consecutivo;
	private Long datOtrosMovInventarioId;
	private String detalleNota;
	private String distribuirCantidad;
	private String estado;
	private Date fechaAnulacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private Long numFactura;
	private String observacion;
	private String observacionAnularReg;
	private Long usuarioDigitacion;
	private Long conceptoKardexId_ConceptoKardex;
	private Long laborId_Labor;
	private Long persEmprId_PersEmpr;
	private String nomConceptoKardex;
	private String tipoMovimiento;
	private CategoriaEquipo categoria;

	private Long centCostId;
	

	public Long getCentCostId() {
		return centCostId;
	}

	public void setCentCostId(Long centCostId) {
		this.centCostId = centCostId;
	}

	public CategoriaEquipo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEquipo categoria) {
		this.categoria = categoria;
	}

	public String getNomConceptoKardex() {
		return nomConceptoKardex;
	}

	public void setNomConceptoKardex(String nomConceptoKardex) {
		this.nomConceptoKardex = nomConceptoKardex;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
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

	public Long getDatOtrosMovInventarioId() {
		return datOtrosMovInventarioId;
	}

	public void setDatOtrosMovInventarioId(Long datOtrosMovInventarioId) {
		this.datOtrosMovInventarioId = datOtrosMovInventarioId;
	}

	public String getDetalleNota() {
		return detalleNota;
	}

	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
	}

	public String getDistribuirCantidad() {
		return distribuirCantidad;
	}

	public void setDistribuirCantidad(String distribuirCantidad) {
		this.distribuirCantidad = distribuirCantidad;
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

	public Long getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(Long numFactura) {
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

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getConceptoKardexId_ConceptoKardex() {
		return conceptoKardexId_ConceptoKardex;
	}

	public void setConceptoKardexId_ConceptoKardex(Long conceptoKardexId_ConceptoKardex) {
		this.conceptoKardexId_ConceptoKardex = conceptoKardexId_ConceptoKardex;
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
}
