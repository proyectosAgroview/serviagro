package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CatalogProductoDTO {

	private BigInteger productoId;
	private String codigo;
	private String nombre;
	private String referencia;
	private String posicion;
	private String cod_tipo_producto;
	private String nom_tipo_producto;
	private String cod_um_producto;
	private BigDecimal saldo_actual_sistema;
	private String cod_almacen;
	private String nom_almacen;

	
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getCod_tipo_producto() {
		return cod_tipo_producto;
	}
	public void setCod_tipo_producto(String cod_tipo_producto) {
		this.cod_tipo_producto = cod_tipo_producto;
	}
	public String getNom_tipo_producto() {
		return nom_tipo_producto;
	}
	public void setNom_tipo_producto(String nom_tipo_producto) {
		this.nom_tipo_producto = nom_tipo_producto;
	}
	public String getCod_um_producto() {
		return cod_um_producto;
	}
	public void setCod_um_producto(String cod_um_producto) {
		this.cod_um_producto = cod_um_producto;
	}
	public BigDecimal getSaldo_actual_sistema() {
		return saldo_actual_sistema;
	}
	public void setSaldo_actual_sistema(BigDecimal saldo_actual_sistema) {
		this.saldo_actual_sistema = saldo_actual_sistema;
	}
	public String getCod_almacen() {
		return cod_almacen;
	}
	public void setCod_almacen(String cod_almacen) {
		this.cod_almacen = cod_almacen;
	}
	public String getNom_almacen() {
		return nom_almacen;
	}
	public void setNom_almacen(String nom_almacen) {
		this.nom_almacen = nom_almacen;
	}
	/**
	 * 
	 * @return the productoId
	 */
	public BigInteger getProductoId() {
		return productoId;
	}
	/**
	 * @param productoId the productoId to set
	 */
	public void setProductoId(BigInteger productoId) {
		this.productoId = productoId;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
