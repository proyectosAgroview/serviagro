package co.com.arcosoft.modelo;

// Generated 15-sep-2015 10:09:32 by Hibernate Tools 4.0.0

/**
 * DatTransProdDet generated by hbm2java
 */
public class DatTransProdDet implements java.io.Serializable {

	private Long datTransProdDetId;
	private UdadMed udadMed;
	private Producto producto;
	private PersEmpr cliente;
	private Empaque empaque;
	private DatTransProd datTransProd;
	private Ciudad ciudad;
	private Long consecutivo;
	private Long compania;
	private Double areaCosechada;
	private Double cantidadReal;
	private Double cantidadSolicitada;
	private Double valorUnitario;
	private Double valorTotal;
	private String documetoErp;
	private Double rendimiento;
	private Double valorDeduccion;
	private Double valorNeto;
	private Double cantidadKilosLiq;
	private String certificacionAceite;
	private Long vagon;
	
	public DatTransProdDet() {
	}

	public DatTransProdDet(Long datTransProdDetId) {
		this.datTransProdDetId = datTransProdDetId;
	}

	public DatTransProdDet(Long datTransProdDetId, UdadMed udadMed, Producto producto, PersEmpr cliente,
			Empaque empaque, DatTransProd datTransProd, Ciudad ciudad, Long consecutivo, Long compania,
			Double areaCosechada, Double cantidadKilosLiq, Double cantidadReal, Double cantidadSolicitada,
			Double rendimiento, Double valorUnitario, Double valorTotal, String documetoErp, Double valorDeduccion,
			Double valorNeto, Long vagon, String certificacionAceite) {
		this.datTransProdDetId = datTransProdDetId;
		this.udadMed = udadMed;
		this.producto = producto;
		this.cliente = cliente;
		this.empaque = empaque;
		this.datTransProd = datTransProd;
		this.ciudad = ciudad;
		this.consecutivo = consecutivo;
		this.compania = compania;
		this.areaCosechada = areaCosechada;
		this.cantidadReal = cantidadReal;
		this.cantidadSolicitada = cantidadSolicitada;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.documetoErp = documetoErp;
		this.rendimiento = rendimiento;
		this.valorDeduccion = valorDeduccion;
		this.valorNeto = valorNeto;
		this.cantidadKilosLiq = cantidadKilosLiq;
		this.vagon= vagon;
		this.certificacionAceite = certificacionAceite;
	}

	public String getCertificacionAceite() {
		return certificacionAceite;
	}

	public void setCertificacionAceite(String certificacionAceite) {
		this.certificacionAceite = certificacionAceite;
	}

	public Long getVagon() {
		return vagon;
	}

	public void setVagon(Long vagon) {
		this.vagon = vagon;
	}

	public Double getCantidadKilosLiq() {
		return cantidadKilosLiq;
	}

	public void setCantidadKilosLiq(Double cantidadKilosLiq) {
		this.cantidadKilosLiq = cantidadKilosLiq;
	}

	public Double getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public Double getValorNeto() {
		return valorNeto;
	}

	public void setValorNeto(Double valorNeto) {
		this.valorNeto = valorNeto;
	}

	public Double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Long getDatTransProdDetId() {
		return this.datTransProdDetId;
	}

	public void setDatTransProdDetId(Long datTransProdDetId) {
		this.datTransProdDetId = datTransProdDetId;
	}

	public UdadMed getUdadMed() {
		return this.udadMed;
	}

	public void setUdadMed(UdadMed udadMed) {
		this.udadMed = udadMed;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public PersEmpr getCliente() {
		return this.cliente;
	}

	public void setCliente(PersEmpr cliente) {
		this.cliente = cliente;
	}

	public Empaque getEmpaque() {
		return this.empaque;
	}

	public void setEmpaque(Empaque empaque) {
		this.empaque = empaque;
	}

	public DatTransProd getDatTransProd() {
		return this.datTransProd;
	}

	public void setDatTransProd(DatTransProd datTransProd) {
		this.datTransProd = datTransProd;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getAreaCosechada() {
		return this.areaCosechada;
	}

	public void setAreaCosechada(Double areaCosechada) {
		this.areaCosechada = areaCosechada;
	}

	public Double getCantidadReal() {
		return this.cantidadReal;
	}

	public void setCantidadReal(Double cantidadReal) {
		this.cantidadReal = cantidadReal;
	}

	public Double getCantidadSolicitada() {
		return this.cantidadSolicitada;
	}

	public void setCantidadSolicitada(Double cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDocumetoErp() {
		return this.documetoErp;
	}

	public void setDocumetoErp(String documetoErp) {
		this.documetoErp = documetoErp;
	}

}
