package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class PlanRevisionProdDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PlanRevisionProdDTO.class);
    private Double cantidad;
    private Long planRevisionEquipoId;
    private Long planRevisionProdId;
    private Producto productoId_Producto;
    private UdadMed udadMedId_UdadMed;
    
    private String nombreUdadMed;
    private String nombreProducto;
    private String codProducto;
    
    

    public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPlanRevisionEquipoId() {
        return planRevisionEquipoId;
    }

    public void setPlanRevisionEquipoId(Long planRevisionEquipoId) {
        this.planRevisionEquipoId = planRevisionEquipoId;
    }

    public Long getPlanRevisionProdId() {
        return planRevisionProdId;
    }

    public void setPlanRevisionProdId(Long planRevisionProdId) {
        this.planRevisionProdId = planRevisionProdId;
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

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
}
