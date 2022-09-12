package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DetalleInsumosLoteDTO {

	private String nomTipoProducto;
	private String codProducto;
	private String nomProducto;
	private String almacen;
	private BigDecimal cantidadDisponible;
	private String nombreUdadMed;
	private String lote;
	private BigDecimal cantidadIngresada;
	private BigDecimal cantidadSalida;
	private Date fechaMovimiento;
	
	

	/**
	 * @return the fechaMovimiento
	 */
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	/**
	 * @param fechaMovimiento the fechaMovimiento to set
	 */
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNomTipoProducto() {
		return nomTipoProducto;
	}

	public void setNomTipoProducto(String nomTipoProducto) {
		this.nomTipoProducto = nomTipoProducto;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getAlmacen() {
		return almacen;
	}

	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public BigDecimal getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(BigDecimal cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public BigDecimal getCantidadIngresada() {
		return cantidadIngresada;
	}

	public void setCantidadIngresada(BigDecimal cantidadIngresada) {
		this.cantidadIngresada = cantidadIngresada;
	}

	public BigDecimal getCantidadSalida() {
		return cantidadSalida;
	}

	public void setCantidadSalida(BigDecimal cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}

}
