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
public class DatProductosRelacionadosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatProductosRelacionadosDTO.class);
    private Long datProductosAgregadosId;
    private Double porcentaje;
    private Long productoAsociadoId;
    private Long productoId_Producto;
    private Long udadMedId_UdadMed;
    
    private String nomProducto;
    private String nomUdadMed;
    private Double dosis;
    private Double cantidad;
    
    
    public Double getDosis() {
		return dosis;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setDosis(Double dosis) {
		this.dosis = dosis;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Long getDatProductosAgregadosId() {
        return datProductosAgregadosId;
    }

    public void setDatProductosAgregadosId(Long datProductosAgregadosId) {
        this.datProductosAgregadosId = datProductosAgregadosId;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Long getProductoAsociadoId() {
        return productoAsociadoId;
    }

    public void setProductoAsociadoId(Long productoAsociadoId) {
        this.productoAsociadoId = productoAsociadoId;
    }

    public Long getProductoId_Producto() {
        return productoId_Producto;
    }

    public void setProductoId_Producto(Long productoId_Producto) {
        this.productoId_Producto = productoId_Producto;
    }

    public Long getUdadMedId_UdadMed() {
        return udadMedId_UdadMed;
    }

    public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
        this.udadMedId_UdadMed = udadMedId_UdadMed;
    }

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getNomUdadMed() {
		return nomUdadMed;
	}

	public void setNomUdadMed(String nomUdadMed) {
		this.nomUdadMed = nomUdadMed;
	}
}
