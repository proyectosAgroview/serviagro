package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

/**
 * IngrActivProd generated by hbm2java
 */
public class IngrActivProd implements java.io.Serializable {

	private IngrActivProdId id;
	private Producto producto;
	private IngredienteActivo ingredienteActivo;

	public IngrActivProd() {
	}

	public IngrActivProd(IngrActivProdId id) {
		this.id = id;
	}

	public IngrActivProd(IngrActivProdId id, Producto producto, IngredienteActivo ingredienteActivo) {
		this.id = id;
		this.producto = producto;
		this.ingredienteActivo = ingredienteActivo;
	}

	public IngrActivProdId getId() {
		return this.id;
	}

	public void setId(IngrActivProdId id) {
		this.id = id;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public IngredienteActivo getIngredienteActivo() {
		return this.ingredienteActivo;
	}

	public void setIngredienteActivo(IngredienteActivo ingredienteActivo) {
		this.ingredienteActivo = ingredienteActivo;
	}

}
