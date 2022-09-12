package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConsultaStockMaquinariaDTO {
	private String codTipoProducto;
	private String nomTipoProducto;
	private String codProducto;
	private String nomProducto;
	private String almacen;
	private BigDecimal cantidadDisponible;
	private String nombreUdadMed;
	private String fechaMovimiento;
	private BigDecimal cantidadIngresada;
	private BigDecimal cantidadSalida;
	private BigDecimal saldoMinimo;
	private String fechaEntrada;
	private String fechaSalida;
	private BigDecimal costo_total;
	private BigDecimal v_unitario;
	
	private Double cantidadPedido;
	private String codAlmacen;
	private String referencia;
	
	private BigDecimal ndias_para_consumir_producto;
	private BigDecimal ndias_ultima_compra_producto;
	
	private String nombreUbicacion;
	private BigInteger ubicacionAlmacen;
	private String color1;
	private String color2;
	private Double cantidadDigitada;
	
	private BigInteger idAlmacen;
	private BigInteger idProducto;
	private BigInteger idUdadMed;
	 
	
	
	
	
	
	public BigInteger getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(BigInteger idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public BigInteger getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(BigInteger idProducto) {
		this.idProducto = idProducto;
	}
	public BigInteger getIdUdadMed() {
		return idUdadMed;
	}
	public void setIdUdadMed(BigInteger idUdadMed) {
		this.idUdadMed = idUdadMed;
	}
	public Double getCantidadDigitada() {
		return cantidadDigitada;
	}
	public void setCantidadDigitada(Double cantidadDigitada) {
		this.cantidadDigitada = cantidadDigitada;
	}
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	public BigInteger getUbicacionAlmacen() {
		return ubicacionAlmacen;
	}
	public void setUbicacionAlmacen(BigInteger ubicacionAlmacen) {
		this.ubicacionAlmacen = ubicacionAlmacen;
	}
	public BigDecimal getNdias_para_consumir_producto() {
		return ndias_para_consumir_producto;
	}
	public void setNdias_para_consumir_producto(BigDecimal ndias_para_consumir_producto) {
		this.ndias_para_consumir_producto = ndias_para_consumir_producto;
	}
	public BigDecimal getNdias_ultima_compra_producto() {
		return ndias_ultima_compra_producto;
	}
	public void setNdias_ultima_compra_producto(BigDecimal ndias_ultima_compra_producto) {
		this.ndias_ultima_compra_producto = ndias_ultima_compra_producto;
	}
	
	
	

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCodTipoProducto() {
		return codTipoProducto;
	}

	public void setCodTipoProducto(String codTipoProducto) {
		this.codTipoProducto = codTipoProducto;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public BigDecimal getCosto_total() {
		return costo_total;
	}

	public void setCosto_total(BigDecimal costo_total) {
		this.costo_total = costo_total;
	}

	public BigDecimal getV_unitario() {
		return v_unitario;
	}

	public void setV_unitario(BigDecimal v_unitario) {
		this.v_unitario = v_unitario;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public Double getCantidadPedido() {
		return cantidadPedido;
	}

	public void setCantidadPedido(Double cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}

	public BigDecimal getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(BigDecimal saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
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

	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
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
