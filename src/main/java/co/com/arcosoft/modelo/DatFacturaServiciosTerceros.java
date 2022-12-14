package co.com.arcosoft.modelo;
// Generated 10/08/2021 12:07:31 PM by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * DatFacturaServiciosTerceros generated by hbm2java
 */
public class DatFacturaServiciosTerceros  implements java.io.Serializable {


     private Long datFacturaServiciosTercerosId;
     private PersEmpr persEmprByClienteId;
     private PersEmpr persEmprByPersEmprId;
     private Long consecutivo;
     private Long centCostId;
     private Long compania;
     private Date fechaRegistro;
     private Date fechaVencimiento;
     private String formaPago;
     private Long plazo;
     private Double valorFactura;
     private Double retencion;
     private Double valorIva;
     private Double valorBaseIva;
     private Double valorReteIva;
     private Double valorReteIca;
     private Double valorDescuento;
     private Double valorDescuentoCenicana;
     private Double valorDescuentoTimbre;
     private Double valorRetencionContrato;
     private String detalleFactura;
     private Long usuarioDigitacion;
     private Date fechaCreacion;
     private String estado;
     private String observacionAnularReg;
     private Date fechaAnulacion;
     private String observacion;
     private Date fechaModificacion;
     private String prefijo;
     private String tipoOperacion; 
    public DatFacturaServiciosTerceros() {
    }

    public DatFacturaServiciosTerceros(String tipoOperacion, PersEmpr persEmprByClienteId, PersEmpr persEmprByPersEmprId, Long consecutivo, Long centCostId, Long compania, Date fechaRegistro, Date fechaVencimiento, String formaPago, Long plazo, Double valorFactura, Double retencion, Double valorIva, Double valorBaseIva, Double valorReteIva, Double valorReteIca, Double valorDescuento, Double valorDescuentoCenicana, Double valorDescuentoTimbre, Double valorRetencionContrato, String detalleFactura, Long usuarioDigitacion, Date fechaCreacion, String estado, String observacionAnularReg, Date fechaAnulacion, String observacion, Date fechaModificacion, String prefijo) {
       this.persEmprByClienteId = persEmprByClienteId;
       this.persEmprByPersEmprId = persEmprByPersEmprId;
       this.consecutivo = consecutivo;
       this.centCostId = centCostId;
       this.compania = compania;
       this.fechaRegistro = fechaRegistro;
       this.fechaVencimiento = fechaVencimiento;
       this.formaPago = formaPago;
       this.plazo = plazo;
       this.valorFactura = valorFactura;
       this.retencion = retencion;
       this.valorIva = valorIva;
       this.valorBaseIva = valorBaseIva;
       this.valorReteIva = valorReteIva;
       this.valorReteIca = valorReteIca;
       this.valorDescuento = valorDescuento;
       this.valorDescuentoCenicana = valorDescuentoCenicana;
       this.valorDescuentoTimbre = valorDescuentoTimbre;
       this.valorRetencionContrato = valorRetencionContrato;
       this.detalleFactura = detalleFactura;
       this.usuarioDigitacion = usuarioDigitacion;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.observacionAnularReg = observacionAnularReg;
       this.fechaAnulacion = fechaAnulacion;
       this.observacion = observacion;
       this.fechaModificacion = fechaModificacion;
       this.prefijo = prefijo;
       this.tipoOperacion= tipoOperacion;
    }
   
    public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Long getDatFacturaServiciosTercerosId() {
        return this.datFacturaServiciosTercerosId;
    }
    
    public void setDatFacturaServiciosTercerosId(Long datFacturaServiciosTercerosId) {
        this.datFacturaServiciosTercerosId = datFacturaServiciosTercerosId;
    }
    public PersEmpr getPersEmprByClienteId() {
        return this.persEmprByClienteId;
    }
    
    public void setPersEmprByClienteId(PersEmpr persEmprByClienteId) {
        this.persEmprByClienteId = persEmprByClienteId;
    }
    public PersEmpr getPersEmprByPersEmprId() {
        return this.persEmprByPersEmprId;
    }
    
    public void setPersEmprByPersEmprId(PersEmpr persEmprByPersEmprId) {
        this.persEmprByPersEmprId = persEmprByPersEmprId;
    }
    public Long getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Long getCentCostId() {
        return this.centCostId;
    }
    
    public void setCentCostId(Long centCostId) {
        this.centCostId = centCostId;
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
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }
    
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public String getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public Long getPlazo() {
        return this.plazo;
    }
    
    public void setPlazo(Long plazo) {
        this.plazo = plazo;
    }
    public Double getValorFactura() {
        return this.valorFactura;
    }
    
    public void setValorFactura(Double valorFactura) {
        this.valorFactura = valorFactura;
    }
    public Double getRetencion() {
        return this.retencion;
    }
    
    public void setRetencion(Double retencion) {
        this.retencion = retencion;
    }
    public Double getValorIva() {
        return this.valorIva;
    }
    
    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }
    public Double getValorBaseIva() {
        return this.valorBaseIva;
    }
    
    public void setValorBaseIva(Double valorBaseIva) {
        this.valorBaseIva = valorBaseIva;
    }
    public Double getValorReteIva() {
        return this.valorReteIva;
    }
    
    public void setValorReteIva(Double valorReteIva) {
        this.valorReteIva = valorReteIva;
    }
    public Double getValorReteIca() {
        return this.valorReteIca;
    }
    
    public void setValorReteIca(Double valorReteIca) {
        this.valorReteIca = valorReteIca;
    }
    public Double getValorDescuento() {
        return this.valorDescuento;
    }
    
    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
    public Double getValorDescuentoCenicana() {
        return this.valorDescuentoCenicana;
    }
    
    public void setValorDescuentoCenicana(Double valorDescuentoCenicana) {
        this.valorDescuentoCenicana = valorDescuentoCenicana;
    }
    public Double getValorDescuentoTimbre() {
        return this.valorDescuentoTimbre;
    }
    
    public void setValorDescuentoTimbre(Double valorDescuentoTimbre) {
        this.valorDescuentoTimbre = valorDescuentoTimbre;
    }
    public Double getValorRetencionContrato() {
        return this.valorRetencionContrato;
    }
    
    public void setValorRetencionContrato(Double valorRetencionContrato) {
        this.valorRetencionContrato = valorRetencionContrato;
    }
    public String getDetalleFactura() {
        return this.detalleFactura;
    }
    
    public void setDetalleFactura(String detalleFactura) {
        this.detalleFactura = detalleFactura;
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
    public String getPrefijo() {
        return this.prefijo;
    }
    
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }




}


