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
public class EmpaqueProductoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EmpaqueProductoDTO.class);
	private Long productoId;
	private Long empaqueId;
	private Long empaqueId_Empaque;
	private Long productoId_Producto;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getEmpaqueId() {
		return empaqueId;
	}

	public void setEmpaqueId(Long empaqueId) {
		this.empaqueId = empaqueId;
	}

	public Long getEmpaqueId_Empaque() {
		return empaqueId_Empaque;
	}

	public void setEmpaqueId_Empaque(Long empaqueId_Empaque) {
		this.empaqueId_Empaque = empaqueId_Empaque;
	}

	public Long getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Long productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}
}
