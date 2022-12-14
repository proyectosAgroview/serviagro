package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

/**
 * MaduranteProductoId generated by hbm2java
 */
public class MaduranteProductoId implements java.io.Serializable {

	private Long productoId;
	private Long cultivoId;
	private Long ndiasEfecto;
	private Long ndiasReaplic;

	public MaduranteProductoId() {
	}

	public MaduranteProductoId(Long productoId, Long cultivoId, Long ndiasEfecto, Long ndiasReaplic) {
		this.productoId = productoId;
		this.cultivoId = cultivoId;
		this.ndiasEfecto = ndiasEfecto;
		this.ndiasReaplic = ndiasReaplic;
	}

	public Long getProductoId() {
		return this.productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getCultivoId() {
		return this.cultivoId;
	}

	public void setCultivoId(Long cultivoId) {
		this.cultivoId = cultivoId;
	}

	public Long getNdiasEfecto() {
		return this.ndiasEfecto;
	}

	public void setNdiasEfecto(Long ndiasEfecto) {
		this.ndiasEfecto = ndiasEfecto;
	}

	public Long getNdiasReaplic() {
		return this.ndiasReaplic;
	}

	public void setNdiasReaplic(Long ndiasReaplic) {
		this.ndiasReaplic = ndiasReaplic;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MaduranteProductoId))
			return false;
		MaduranteProductoId castOther = (MaduranteProductoId) other;

		return ((this.getProductoId() == castOther.getProductoId()) || (this.getProductoId() != null
				&& castOther.getProductoId() != null && this.getProductoId().equals(castOther.getProductoId())))
				&& ((this.getCultivoId() == castOther.getCultivoId()) || (this.getCultivoId() != null
						&& castOther.getCultivoId() != null && this.getCultivoId().equals(castOther.getCultivoId())))
				&& ((this.getNdiasEfecto() == castOther.getNdiasEfecto())
						|| (this.getNdiasEfecto() != null && castOther.getNdiasEfecto() != null
								&& this.getNdiasEfecto().equals(castOther.getNdiasEfecto())))
				&& ((this.getNdiasReaplic() == castOther.getNdiasReaplic())
						|| (this.getNdiasReaplic() != null && castOther.getNdiasReaplic() != null
								&& this.getNdiasReaplic().equals(castOther.getNdiasReaplic())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductoId() == null ? 0 : this.getProductoId().hashCode());
		result = 37 * result + (getCultivoId() == null ? 0 : this.getCultivoId().hashCode());
		result = 37 * result + (getNdiasEfecto() == null ? 0 : this.getNdiasEfecto().hashCode());
		result = 37 * result + (getNdiasReaplic() == null ? 0 : this.getNdiasReaplic().hashCode());
		return result;
	}

}
