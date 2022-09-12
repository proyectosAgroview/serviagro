package co.com.arcosoft.rest.service.dto;

public class InsumosDetDTO {

	private Double cantidadAplicada;
	private Double costoTotal;
	private Long datProdDetId;
	private Double dosis;
	private Double valorUnit;
	private Long datAplicProdId_DatAplicProducto;
	private Long productoId_Producto;
	private Long udadMedId_UdadMed;

	public Double getCantidadAplicada() {
		return cantidadAplicada;
	}

	public void setCantidadAplicada(Double cantidadAplicada) {
		this.cantidadAplicada = cantidadAplicada;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDatProdDetId() {
		return datProdDetId;
	}

	public void setDatProdDetId(Long datProdDetId) {
		this.datProdDetId = datProdDetId;
	}

	public Double getDosis() {
		return dosis;
	}

	public void setDosis(Double dosis) {
		this.dosis = dosis;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Long getDatAplicProdId_DatAplicProducto() {
		return datAplicProdId_DatAplicProducto;
	}

	public void setDatAplicProdId_DatAplicProducto(Long datAplicProdId_DatAplicProducto) {
		this.datAplicProdId_DatAplicProducto = datAplicProdId_DatAplicProducto;
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

}
