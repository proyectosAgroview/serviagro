package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class IngrActivProdDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(IngrActivProdDTO.class);
	private Long productoId;
	private Long ingredienteActId;
	private Long compania;
	private Double ptjeContribuccion;
	private Long ingredienteActId_IngredienteActivo;
	private Long productoId_Producto;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getIngredienteActId() {
		return ingredienteActId;
	}

	public void setIngredienteActId(Long ingredienteActId) {
		this.ingredienteActId = ingredienteActId;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getPtjeContribuccion() {
		return ptjeContribuccion;
	}

	public void setPtjeContribuccion(Double ptjeContribuccion) {
		this.ptjeContribuccion = ptjeContribuccion;
	}

	public Long getIngredienteActId_IngredienteActivo() {
		return ingredienteActId_IngredienteActivo;
	}

	public void setIngredienteActId_IngredienteActivo(Long ingredienteActId_IngredienteActivo) {
		this.ingredienteActId_IngredienteActivo = ingredienteActId_IngredienteActivo;
	}

	public Long getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Long productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}
}
