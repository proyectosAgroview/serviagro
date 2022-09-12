package co.com.arcosoft.rest.service.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class HistoricoLaboresFincaLoteDTO {

	private BigInteger idLote;
	private String nombreLote;
	private BigDecimal area;
	private String fechaRegistro;
	private String nombreLabor;
	private String nombreProducto;
	private BigDecimal cantidadIns;
	private String nombreUdadMedIns;
	private BigDecimal costoTotal;
	private BigDecimal cantidadCos;

	public BigInteger getIdLote() {
		return idLote;
	}

	public void setIdLote(BigInteger idLote) {
		this.idLote = idLote;
	}

	public String getNombreLote() {
		return nombreLote;
	}

	public void setNombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public BigDecimal getCantidadIns() {
		return cantidadIns;
	}

	public void setCantidadIns(BigDecimal cantidadIns) {
		this.cantidadIns = cantidadIns;
	}

	public String getNombreUdadMedIns() {
		return nombreUdadMedIns;
	}

	public void setNombreUdadMedIns(String nombreUdadMedIns) {
		this.nombreUdadMedIns = nombreUdadMedIns;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public BigDecimal getCantidadCos() {
		return cantidadCos;
	}

	public void setCantidadCos(BigDecimal cantidadCos) {
		this.cantidadCos = cantidadCos;
	}

}
