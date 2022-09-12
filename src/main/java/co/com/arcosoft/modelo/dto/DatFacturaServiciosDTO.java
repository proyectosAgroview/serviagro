package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatFacturaServiciosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatFacturaServiciosDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datFacturaServiciosId;
    private String detalleFactura;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaRegistro;
    private Date fechaVencimiento;
    private String formaPago;
    private String numFactura;
    private String observacion;
    private String observacionAnularReg;
    private Long persEmprId;
    private Long plazo;
    private Double retencion;
    private Long usuarioDigitacion;
    private Double valorBaseIva;
    private Double valorDescuento;
    private Double valorDescuentoCenicana;
    private Double valorDescuentoTimbre;
    private Double valorFactura;
    private Double valorIva;
    private Double valorReteIca;
    private Double valorReteIva;
    private Double valorRetencionContrato;
    private Long numPrefactura;
    private Date fechaModificacion;
    
    
    

    public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getNumPrefactura() {
		return numPrefactura;
	}

	public void setNumPrefactura(Long numPrefactura) {
		this.numPrefactura = numPrefactura;
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

    public Long getDatFacturaServiciosId() {
        return datFacturaServiciosId;
    }

    public void setDatFacturaServiciosId(Long datFacturaServiciosId) {
        this.datFacturaServiciosId = datFacturaServiciosId;
    }

    public String getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(String detalleFactura) {
        this.detalleFactura = detalleFactura;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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

    public Long getPersEmprId() {
        return persEmprId;
    }

    public void setPersEmprId(Long persEmprId) {
        this.persEmprId = persEmprId;
    }

    public Long getPlazo() {
        return plazo;
    }

    public void setPlazo(Long plazo) {
        this.plazo = plazo;
    }

    public Double getRetencion() {
        return retencion;
    }

    public void setRetencion(Double retencion) {
        this.retencion = retencion;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getValorBaseIva() {
        return valorBaseIva;
    }

    public void setValorBaseIva(Double valorBaseIva) {
        this.valorBaseIva = valorBaseIva;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public Double getValorDescuentoCenicana() {
        return valorDescuentoCenicana;
    }

    public void setValorDescuentoCenicana(Double valorDescuentoCenicana) {
        this.valorDescuentoCenicana = valorDescuentoCenicana;
    }

    public Double getValorDescuentoTimbre() {
        return valorDescuentoTimbre;
    }

    public void setValorDescuentoTimbre(Double valorDescuentoTimbre) {
        this.valorDescuentoTimbre = valorDescuentoTimbre;
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

    public Double getValorReteIca() {
        return valorReteIca;
    }

    public void setValorReteIca(Double valorReteIca) {
        this.valorReteIca = valorReteIca;
    }

    public Double getValorReteIva() {
        return valorReteIva;
    }

    public void setValorReteIva(Double valorReteIva) {
        this.valorReteIva = valorReteIva;
    }

    public Double getValorRetencionContrato() {
        return valorRetencionContrato;
    }

    public void setValorRetencionContrato(Double valorRetencionContrato) {
        this.valorRetencionContrato = valorRetencionContrato;
    }
}
