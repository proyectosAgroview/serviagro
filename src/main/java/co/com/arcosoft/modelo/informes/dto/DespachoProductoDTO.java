package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class DespachoProductoDTO {

	private BigDecimal cantidadDespachada;
	private String nombreProducto;
	private String nombreCompania;

	public BigDecimal getCantidadDespachada() {
		return cantidadDespachada;
	}

	public void setCantidadDespachada(BigDecimal cantidadDespachada) {
		this.cantidadDespachada = cantidadDespachada;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
}
