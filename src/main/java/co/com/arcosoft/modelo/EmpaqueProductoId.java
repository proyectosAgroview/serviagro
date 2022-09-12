package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

/**
 * EmpaqueProductoId generated by hbm2java
 */
public class EmpaqueProductoId implements java.io.Serializable {

	private Long productoId;
	private Long empaqueId;

	public EmpaqueProductoId() {
	}

	public EmpaqueProductoId(Long productoId, Long empaqueId) {
		this.productoId = productoId;
		this.empaqueId = empaqueId;
	}

	public Long getProductoId() {
		return this.productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getEmpaqueId() {
		return this.empaqueId;
	}

	public void setEmpaqueId(Long empaqueId) {
		this.empaqueId = empaqueId;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmpaqueProductoId))
			return false;
		EmpaqueProductoId castOther = (EmpaqueProductoId) other;

		return ((this.getProductoId() == castOther.getProductoId()) || (this.getProductoId() != null
				&& castOther.getProductoId() != null && this.getProductoId().equals(castOther.getProductoId())))
				&& ((this.getEmpaqueId() == castOther.getEmpaqueId()) || (this.getEmpaqueId() != null
						&& castOther.getEmpaqueId() != null && this.getEmpaqueId().equals(castOther.getEmpaqueId())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductoId() == null ? 0 : this.getProductoId().hashCode());
		result = 37 * result + (getEmpaqueId() == null ? 0 : this.getEmpaqueId().hashCode());
		return result;
	}

}
