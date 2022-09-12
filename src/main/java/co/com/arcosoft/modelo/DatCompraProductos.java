package co.com.arcosoft.modelo;
// Generated 19-oct-2018 11:57:40 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * DatCompraProductos generated by hbm2java
 */
@SuppressWarnings("serial")
public class DatCompraProductos implements java.io.Serializable {

	private Long datCompraProductosId;
	private PersEmpr persEmpr;
	private Long consecutivo;
	private Long numFactura;
	private Long compania;
	private Date fechaRegistro;
	private Double valorFactura;
	private Double valorIva;
	private Double valorDescuento;
	private String detalleNota;
	private String tipoMoneda;
	private Double tasaConversionTrm;
	private Long usuarioDigitacion;
	private Date fechaCreacion;
	private String estado;
	private String observacionAnularReg;
	private Date fechaAnulacion;
	private String observacion;
	private Date fechaModificacion;
	private Double subTotalFactura;
	private Double valorAdicional;
	private String transportadoraFactura;
	private String transportadora_nguia;
	private Double transportadora_valor_flete;
	private DatMantenimientoEquipo datMantenimientoEquipoId;
	
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
  
  
	public DatCompraProductos() {
	}

	public DatCompraProductos(PersEmpr persEmpr, Long consecutivo, Long numFactura, Long compania, Date fechaRegistro,
			Double valorFactura, Double valorIva, Double valorDescuento, String detalleNota, String tipoMoneda,
			Double tasaConversionTrm, Long usuarioDigitacion, Date fechaCreacion, String estado,
			String observacionAnularReg, Date fechaAnulacion, String observacion, Date fechaModificacion,
			Double subTotalFactura, Double valorAdicional, String transportadoraFactura, String transportadora_nguia,
			Double transportadora_valor_flete, DatMantenimientoEquipo datMantenimientoEquipoId, String referenciaCompraMp, String tipoCompra) {
		this.persEmpr = persEmpr;
		this.consecutivo = consecutivo;
		this.numFactura = numFactura;
		this.compania = compania;
		this.fechaRegistro = fechaRegistro;
		this.valorFactura = valorFactura;
		this.valorIva = valorIva;
		this.valorDescuento = valorDescuento;
		this.detalleNota = detalleNota;
		this.tipoMoneda = tipoMoneda;
		this.tasaConversionTrm = tasaConversionTrm;
		this.usuarioDigitacion = usuarioDigitacion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.observacionAnularReg = observacionAnularReg;
		this.fechaAnulacion = fechaAnulacion;
		this.observacion = observacion;
		this.fechaModificacion = fechaModificacion;
		this.subTotalFactura = subTotalFactura;
		this.valorAdicional = valorAdicional;
		this.transportadoraFactura = transportadoraFactura;
		this.transportadora_nguia = transportadora_nguia;
		this.transportadora_valor_flete = transportadora_valor_flete;
		this.datMantenimientoEquipoId = datMantenimientoEquipoId;
		this.tipoCompra= tipoCompra;
		this.referenciaCompraMp=referenciaCompraMp;
	}
	
	

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

	public DatMantenimientoEquipo getDatMantenimientoEquipoId() {
		return datMantenimientoEquipoId;
	}

	public void setDatMantenimientoEquipoId(DatMantenimientoEquipo datMantenimientoEquipoId) {
		this.datMantenimientoEquipoId = datMantenimientoEquipoId;
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

	public Long getDatCompraProductosId() {
		return this.datCompraProductosId;
	}

	public void setDatCompraProductosId(Long datCompraProductosId) {
		this.datCompraProductosId = datCompraProductosId;
	}

	public PersEmpr getPersEmpr() {
		return this.persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getNumFactura() {
		return this.numFactura;
	}

	public void setNumFactura(Long numFactura) {
		this.numFactura = numFactura;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Double getValorFactura() {
		return this.valorFactura;
	}

	public void setValorFactura(Double valorFactura) {
		this.valorFactura = valorFactura;
	}

	public Double getValorIva() {
		return this.valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	public Double getValorDescuento() {
		return this.valorDescuento;
	}

	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public String getDetalleNota() {
		return this.detalleNota;
	}

	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
	}

	public String getTipoMoneda() {
		return this.tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Double getTasaConversionTrm() {
		return this.tasaConversionTrm;
	}

	public void setTasaConversionTrm(Double tasaConversionTrm) {
		this.tasaConversionTrm = tasaConversionTrm;
	}

	public Long getUsuarioDigitacion() {
		return this.usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacionAnularReg() {
		return this.observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
