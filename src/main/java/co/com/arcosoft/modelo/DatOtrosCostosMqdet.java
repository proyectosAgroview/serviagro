package co.com.arcosoft.modelo;
// Generated 06-ago-2017 12:13:29 by Hibernate Tools 4.0.0

/**
 * DatOtrosCostosMqdet generated by hbm2java
 */
public class DatOtrosCostosMqdet implements java.io.Serializable {

	private Long datOtrosCostosMqdetId;
	private Equipo equipo;
	private DatOtrosCostosMq datOtrosCostosMq;
	private Tag tag;
	private Double porcentaje;
	private String origenDatos;
	private UdadMed udadMed;
	private Producto producto;
	private Double cantidad;
	private Double valorUnitario;
	private Double costoTotal;
	private String descripcion;
	private Labor labor;
	private CuentaContable ccontable;
	private PersEmpr persEmpr;
	private Double horometroServicio;
	private String nroFactura;
	private Equipo implementoId;
	private CentCost centCost;

	public DatOtrosCostosMqdet() {
	}

	public DatOtrosCostosMqdet(Equipo equipo, DatOtrosCostosMq datOtrosCostosMq, Tag tag, Double porcentaje,
			String origenDatos, Producto producto, UdadMed udadMed, Double cantidad, Double valorUnitario,
			Double costoTotal, String descripcion, Labor labor, CuentaContable ccontable, PersEmpr persEmpr,
			Double horometroServicio, String nroFactura, Equipo implementoId, CentCost centCost) {
		this.equipo = equipo;
		this.datOtrosCostosMq = datOtrosCostosMq;
		this.tag = tag;
		this.porcentaje = porcentaje;
		this.origenDatos = origenDatos;
		this.producto = producto;
		this.udadMed = udadMed;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
		this.costoTotal = costoTotal;
		this.descripcion = descripcion;
		this.labor = labor;
		this.ccontable = ccontable;
		this.persEmpr = persEmpr;
		this.horometroServicio = horometroServicio;
		this.nroFactura = nroFactura;
		this.implementoId = implementoId;
		this.centCost = centCost;
	}

	public CentCost getCentCost() {
		return centCost;
	}

	public void setCentCost(CentCost centCost) {
		this.centCost = centCost;
	}

	public Equipo getImplementoId() {
		return implementoId;
	}

	public void setImplementoId(Equipo implementoId) {
		this.implementoId = implementoId;
	}

	public CuentaContable getCcontable() {
		return ccontable;
	}

	public void setCcontable(CuentaContable ccontable) {
		this.ccontable = ccontable;
	}

	public Labor getLabor() {
		return labor;
	}

	public void setLabor(Labor labor) {
		this.labor = labor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UdadMed getUdadMed() {
		return udadMed;
	}

	public void setUdadMed(UdadMed udadMed) {
		this.udadMed = udadMed;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDatOtrosCostosMqdetId() {
		return this.datOtrosCostosMqdetId;
	}

	public void setDatOtrosCostosMqdetId(Long datOtrosCostosMqdetId) {
		this.datOtrosCostosMqdetId = datOtrosCostosMqdetId;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public DatOtrosCostosMq getDatOtrosCostosMq() {
		return this.datOtrosCostosMq;
	}

	public void setDatOtrosCostosMq(DatOtrosCostosMq datOtrosCostosMq) {
		this.datOtrosCostosMq = datOtrosCostosMq;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Double getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getOrigenDatos() {
		return this.origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public PersEmpr getPersEmpr() {
		return persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	public Double getHorometroServicio() {
		return horometroServicio;
	}

	public void setHorometroServicio(Double horometroServicio) {
		this.horometroServicio = horometroServicio;
	}

	public String getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}

}
