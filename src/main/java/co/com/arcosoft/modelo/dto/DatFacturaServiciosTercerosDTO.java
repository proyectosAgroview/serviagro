package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.utilities.FacesUtils;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatFacturaServiciosTercerosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatFacturaServiciosTercerosDTO.class);
    private Long centCostId;
    private Long compania;
    private Long consecutivo;
    private Long datFacturaServiciosTercerosId;
    private String detalleFactura;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Date fechaVencimiento;
    private String formaPago;
    private String observacion;
    private String observacionAnularReg;
    private Long plazo;
    private String prefijo;
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
    private Long persEmprByClienteId;
    private Long persEmprByPersEmprId;
    
    private String tipoOperacion;
    
    

    public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Long getPersEmprByClienteId() {
		return persEmprByClienteId;
	}

	public Long getPersEmprByPersEmprId() {
		return persEmprByPersEmprId;
	}

	public void setPersEmprByClienteId(Long persEmprByClienteId) {
		this.persEmprByClienteId = persEmprByClienteId;
	}

	public void setPersEmprByPersEmprId(Long persEmprByPersEmprId) {
		this.persEmprByPersEmprId = persEmprByPersEmprId;
	}

	public Long getCentCostId() {
        return centCostId;
    }

    public void setCentCostId(Long centCostId) {
        this.centCostId = centCostId;
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

    public Long getDatFacturaServiciosTercerosId() {
        return datFacturaServiciosTercerosId;
    }

    public void setDatFacturaServiciosTercerosId(
        Long datFacturaServiciosTercerosId) {
        this.datFacturaServiciosTercerosId = datFacturaServiciosTercerosId;
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

    public Long getPlazo() {
        return plazo;
    }

    public void setPlazo(Long plazo) {
        this.plazo = plazo;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
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
