package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class DespachoProductoClienteDTO {

	private BigDecimal cantidadDespachada;
	private String nombreCliente;
	private String nombreCompania;

	public BigDecimal getCantidadDespachada() {
		return cantidadDespachada;
	}

	public void setCantidadDespachada(BigDecimal cantidadDespachada) {
		this.cantidadDespachada = cantidadDespachada;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

}
