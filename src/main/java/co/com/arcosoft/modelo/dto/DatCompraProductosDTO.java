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
public class DatCompraProductosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DatCompraProductosDTO.class);
	private Long compania;
	private Long consecutivo;
	private Long datCompraProductosId;
	private String detalleNota;
	private String estado;
	private Date fechaAnulacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private Long numFactura;
	private String observacion;
	private String observacionAnularReg;
	private Double tasaConversionTrm;
	private String tipoMoneda;
	private Long usuarioDigitacion;
	private Double valorDescuento;
	private Double valorFactura;
	private Double valorIva;
	private Long persEmprId_PersEmpr;
	private String nomProveedor;
	private Double subTotalFactura;
	private Double valorAdicional;

	private String transportadoraFactura;
	private String transportadora_nguia;
	private Double transportadora_valor_flete;

	private Long datMantenimientoEquipoId;
	private Long numeroOrdenTrabajo;

	private Long provTransporteFlete;
	private Long provGastosNacionales;
	private Long provImpuestosAranceles;
	private Long provComisiones;
	private Long provOtros;
	
	private Double valTransporteFlete;
	private Double valGastosNacionales;
	private Double valImpuestosAranceles;
	private Double valComisiones;
	private Double valOtros;
	private Double valSumaProvs;
	 private String referenciaCompraMp;
	  private String tipoCompra;
	  
	  
	  
	public String getReferenciaCompraMp() {
		return referenciaCompraMp;
	}

	public void setReferenciaCompraMp(String referenciaCompraMp) {
		this.referenciaCompraMp = referenciaCompraMp;
	}

	public String getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(String tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public Long getDatMantenimientoEquipoId() {
		return datMantenimientoEquipoId;
	}

	public void setDatMantenimientoEquipoId(Long datMantenimientoEquipoId) {
		this.datMantenimientoEquipoId = datMantenimientoEquipoId;
	}

	public Long getNumeroOrdenTrabajo() {
		return numeroOrdenTrabajo;
	}

	public void setNumeroOrdenTrabajo(Long numeroOrdenTrabajo) {
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
	}

	public String getTransportadora_nguia() {
		return transportadora_nguia;
	}

	public void setTransportadora_nguia(String transportadora_nguia) {
		this.transportadora_nguia = transportadora_nguia;
	}

	public Double getTransportadora_valor_flete() {
		return transportadora_valor_flete;
	}

	public void setTransportadora_valor_flete(Double transportadora_valor_flete) {
		this.transportadora_valor_flete = transportadora_valor_flete;
	}

	public String getTransportadoraFactura() {
		return transportadoraFactura;
	}

	public void setTransportadoraFactura(String transportadoraFactura) {
		this.transportadoraFactura = transportadoraFactura;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public Double getSubTotalFactura() {
		return subTotalFactura;
	}

	public void setSubTotalFactura(Double subTotalFactura) {
		this.subTotalFactura = subTotalFactura;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
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

	public Long getDatCompraProductosId() {
		return datCompraProductosId;
	}

	public void setDatCompraProductosId(Long datCompraProductosId) {
		this.datCompraProductosId = datCompraProductosId;
	}

	public String getDetalleNota() {
		return detalleNota;
	}

	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
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

	public Double getTasaConversionTrm() {
		return tasaConversionTrm;
	}

	public void setTasaConversionTrm(Double tasaConversionTrm) {
		this.tasaConversionTrm = tasaConversionTrm;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public Double getValorFactura() {
		return valorFactura;
	}

	public void setValorFactura(Double valorFactura) {
		this.valorFactura = valorFactura;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	public Long getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public Long getProvTransporteFlete() {
		return provTransporteFlete;
	}

	public void setProvTransporteFlete(Long provTransporteFlete) {
		this.provTransporteFlete = provTransporteFlete;
	}

	public Long getProvGastosNacionales() {
		return provGastosNacionales;
	}

	public void setProvGastosNacionales(Long provGastosNacionales) {
		this.provGastosNacionales = provGastosNacionales;
	}

	public Long getProvImpuestosAranceles() {
		return provImpuestosAranceles;
	}

	public void setProvImpuestosAranceles(Long provImpuestosAranceles) {
		this.provImpuestosAranceles = provImpuestosAranceles;
	}

	public Long getProvComisiones() {
		return provComisiones;
	}

	public void setProvComisiones(Long provComisiones) {
		this.provComisiones = provComisiones;
	}

	public Long getProvOtros() {
		return provOtros;
	}

	public void setProvOtros(Long provOtros) {
		this.provOtros = provOtros;
	}

	public Double getValTransporteFlete() {
		return valTransporteFlete;
	}

	public void setValTransporteFlete(Double valTransporteFlete) {
		this.valTransporteFlete = valTransporteFlete;
	}

	public Double getValGastosNacionales() {
		return valGastosNacionales;
	}

	public void setValGastosNacionales(Double valGastosNacionales) {
		this.valGastosNacionales = valGastosNacionales;
	}

	public Double getValImpuestosAranceles() {
		return valImpuestosAranceles;
	}

	public void setValImpuestosAranceles(Double valImpuestosAranceles) {
		this.valImpuestosAranceles = valImpuestosAranceles;
	}

	public Double getValComisiones() {
		return valComisiones;
	}

	public void setValComisiones(Double valComisiones) {
		this.valComisiones = valComisiones;
	}

	public Double getValOtros() {
		return valOtros;
	}

	public void setValOtros(Double valOtros) {
		this.valOtros = valOtros;
	}

	public Double getValSumaProvs() {
		return valSumaProvs;
	}

	public void setValSumaProvs(Double valSumaProvs) {
		this.valSumaProvs = valSumaProvs;
	}
}
