package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class ProductoDTO {

	private Long productoId;
	private Long claseToxicologica;
	private Long tipoProducto;
	private Long almacen;
	private Long udadMedByUdadMedCosecha;
	private Long centCost;
	private Long udadMedByUdadMedProd;
	private Long elementoCosto;
	private String codigo;
	private String nombre;
	public Long compania;
	private String flujoMovimiento;
	private String esGranel;
	private String observacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Double saldo;
	
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public ProductoDTO() {
	}

	public Long getProductoId() {
		return this.productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getClaseToxicologica() {
		return this.claseToxicologica;
	}

	public void setClaseToxicologica(Long claseToxicologica) {
		this.claseToxicologica = claseToxicologica;
	}

	public Long getUdadMedByUdadMedCosecha() {
		return this.udadMedByUdadMedCosecha;
	}

	public void setUdadMedByUdadMedCosecha(Long udadMedByUdadMedCosecha) {
		this.udadMedByUdadMedCosecha = udadMedByUdadMedCosecha;
	}

	public Long getCentCost() {
		return this.centCost;
	}

	public void setCentCost(Long centCost) {
		this.centCost = centCost;
	}

	public Long getElementoCosto() {
		return this.elementoCosto;
	}

	public void setElementoCosto(Long elementoCosto) {
		this.elementoCosto = elementoCosto;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getFlujoMovimiento() {
		return this.flujoMovimiento;
	}

	public void setFlujoMovimiento(String flujoMovimiento) {
		this.flujoMovimiento = flujoMovimiento;
	}

	public String getEsGranel() {
		return this.esGranel;
	}

	public void setEsGranel(String esGranel) {
		this.esGranel = esGranel;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public Long getAlmacen() {
		return almacen;
	}

	public Long getUdadMedByUdadMedProd() {
		return udadMedByUdadMedProd;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public void setAlmacen(Long almacen) {
		this.almacen = almacen;
	}

	public void setUdadMedByUdadMedProd(Long udadMedByUdadMedProd) {
		this.udadMedByUdadMedProd = udadMedByUdadMedProd;
	}

}
