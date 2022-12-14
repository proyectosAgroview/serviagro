package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

/**
 * EmpaqueProducto generated by hbm2java
 */
public class EmpaqueProducto implements java.io.Serializable {

	private EmpaqueProductoId id;
	private Producto producto;
	private Empaque empaque;

	public EmpaqueProducto() {
	}

	public EmpaqueProducto(EmpaqueProductoId id) {
		this.id = id;
	}

	public EmpaqueProducto(EmpaqueProductoId id, Producto producto, Empaque empaque) {
		this.id = id;
		this.producto = producto;
		this.empaque = empaque;
	}

	public EmpaqueProductoId getId() {
		return this.id;
	}

	public void setId(EmpaqueProductoId id) {
		this.id = id;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Empaque getEmpaque() {
		return this.empaque;
	}

	public void setEmpaque(Empaque empaque) {
		this.empaque = empaque;
	}

}
