package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatCompraMateriaPrimaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatCompraMateriaPrimaDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datCompraMateriaPrimaId;
    private Long datMantenimientoEquipoId;
    private String detalleNota;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Long numFactura;
    private String observacion;
    private String observacionAnularReg;
    private Long provComisiones;
    private Long provGastosNacionales;
    private Long provImpuestosAranceles;
    private Long provOtros;
    private Long provTransporteFlete;
    private Double subTotalFactura;
    private Double tasaConversionTrm;
    private String tipoMoneda;
    private String transportadoraFactura;
    private String transportadoraNguia;
    private Double transportadoraValorFlete;
    private Long usuarioDigitacion;
    private Double valComisiones;
    private Double valGastosNacionales;
    private Double valImpuestosAranceles;
    private Double valOtros;
    private Double valSumaProvs;
    private Double valTransporteFlete;
    private Double valorAdicional;
    private Double valorDescuento;
    private Double valorFactura;
    private Double valorIva;
    private Long persEmprId_PersEmpr;

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

    public Long getDatCompraMateriaPrimaId() {
        return datCompraMateriaPrimaId;
    }

    public void setDatCompraMateriaPrimaId(Long datCompraMateriaPrimaId) {
        this.datCompraMateriaPrimaId = datCompraMateriaPrimaId;
    }

    public Long getDatMantenimientoEquipoId() {
        return datMantenimientoEquipoId;
    }

    public void setDatMantenimientoEquipoId(Long datMantenimientoEquipoId) {
        this.datMantenimientoEquipoId = datMantenimientoEquipoId;
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

    public Long getProvComisiones() {
        return provComisiones;
    }

    public void setProvComisiones(Long provComisiones) {
        this.provComisiones = provComisiones;
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

    public Long getProvOtros() {
        return provOtros;
    }

    public void setProvOtros(Long provOtros) {
        this.provOtros = provOtros;
    }

    public Long getProvTransporteFlete() {
        return provTransporteFlete;
    }

    public void setProvTransporteFlete(Long provTransporteFlete) {
        this.provTransporteFlete = provTransporteFlete;
    }

    public Double getSubTotalFactura() {
        return subTotalFactura;
    }

    public void setSubTotalFactura(Double subTotalFactura) {
        this.subTotalFactura = subTotalFactura;
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

    public String getTransportadoraFactura() {
        return transportadoraFactura;
    }

    public void setTransportadoraFactura(String transportadoraFactura) {
        this.transportadoraFactura = transportadoraFactura;
    }

    public String getTransportadoraNguia() {
        return transportadoraNguia;
    }

    public void setTransportadoraNguia(String transportadoraNguia) {
        this.transportadoraNguia = transportadoraNguia;
    }

    public Double getTransportadoraValorFlete() {
        return transportadoraValorFlete;
    }

    public void setTransportadoraValorFlete(Double transportadoraValorFlete) {
        this.transportadoraValorFlete = transportadoraValorFlete;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getValComisiones() {
        return valComisiones;
    }

    public void setValComisiones(Double valComisiones) {
        this.valComisiones = valComisiones;
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

    public Double getValTransporteFlete() {
        return valTransporteFlete;
    }

    public void setValTransporteFlete(Double valTransporteFlete) {
        this.valTransporteFlete = valTransporteFlete;
    }

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
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
}
