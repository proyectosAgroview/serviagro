package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CategoriaEquipo;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatOtrosCostosMqDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosMqDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datOtrosCostosMqId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaInicial;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private String infoAdicional;
    private String infoAdicional2;
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
    private String origenDatos;
    private CategoriaEquipo categoria;
    private Double cantidad;
    private String tipoGasto;
    
    
    
    public String getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public CategoriaEquipo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEquipo categoria) {
		this.categoria = categoria;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
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

    public Long getDatOtrosCostosMqId() {
        return datOtrosCostosMqId;
    }

    public void setDatOtrosCostosMqId(Long datOtrosCostosMqId) {
        this.datOtrosCostosMqId = datOtrosCostosMqId;
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

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
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
}
