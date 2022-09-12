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
public class MaduranteProductoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MaduranteProductoDTO.class);
	private Long productoId;
	private Long cultivoId;
	private Long ndiasEfecto;
	private Long ndiasReaplic;
	private Long cultivoId_Cultivo;
	private Long productoId_Producto;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getCultivoId() {
		return cultivoId;
	}

	public void setCultivoId(Long cultivoId) {
		this.cultivoId = cultivoId;
	}

	public Long getNdiasEfecto() {
		return ndiasEfecto;
	}

	public void setNdiasEfecto(Long ndiasEfecto) {
		this.ndiasEfecto = ndiasEfecto;
	}

	public Long getNdiasReaplic() {
		return ndiasReaplic;
	}

	public void setNdiasReaplic(Long ndiasReaplic) {
		this.ndiasReaplic = ndiasReaplic;
	}

	public Long getCultivoId_Cultivo() {
		return cultivoId_Cultivo;
	}

	public void setCultivoId_Cultivo(Long cultivoId_Cultivo) {
		this.cultivoId_Cultivo = cultivoId_Cultivo;
	}

	public Long getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Long productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}
}
