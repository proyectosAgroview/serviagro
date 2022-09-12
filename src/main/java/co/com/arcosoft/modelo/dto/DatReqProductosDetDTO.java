package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatReqProductosDetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatReqProductosDetDTO.class);
    private Double cantidadFaltante;
    private Double cantidadNormal;
    private Double cantidadUrgente;
    private Long datReqProductosDetId;
    private String detalleNota;
    private Double saldo;
    private Long datReqProductosId_DatReqProductos;
    private Producto productoId_Producto;
    private UdadMed udadMedId_UdadMed;
    private String codigoProducto;
    private String nombreUdadMed;
    
    

    public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public Double getCantidadFaltante() {
        return cantidadFaltante;
    }

    public void setCantidadFaltante(Double cantidadFaltante) {
        this.cantidadFaltante = cantidadFaltante;
    }

    public Double getCantidadNormal() {
        return cantidadNormal;
    }

    public void setCantidadNormal(Double cantidadNormal) {
        this.cantidadNormal = cantidadNormal;
    }

    public Double getCantidadUrgente() {
        return cantidadUrgente;
    }

    public void setCantidadUrgente(Double cantidadUrgente) {
        this.cantidadUrgente = cantidadUrgente;
    }

    public Long getDatReqProductosDetId() {
        return datReqProductosDetId;
    }

    public void setDatReqProductosDetId(Long datReqProductosDetId) {
        this.datReqProductosDetId = datReqProductosDetId;
    }

    public String getDetalleNota() {
        return detalleNota;
    }

    public void setDetalleNota(String detalleNota) {
        this.detalleNota = detalleNota;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getDatReqProductosId_DatReqProductos() {
        return datReqProductosId_DatReqProductos;
    }

    public void setDatReqProductosId_DatReqProductos(
        Long datReqProductosId_DatReqProductos) {
        this.datReqProductosId_DatReqProductos = datReqProductosId_DatReqProductos;
    }

    public Producto getProductoId_Producto() {
        return productoId_Producto;
    }

    public void setProductoId_Producto(Producto productoId_Producto) {
        this.productoId_Producto = productoId_Producto;
    }

    public UdadMed getUdadMedId_UdadMed() {
        return udadMedId_UdadMed;
    }

    public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
        this.udadMedId_UdadMed = udadMedId_UdadMed;
    }
}
