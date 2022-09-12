package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

/**
 * LaborAsociadaId generated by hbm2java
 */
public class LaborAsociadaId implements java.io.Serializable {

	private Long laborId;
	private Long laborAsocId;

	public LaborAsociadaId() {
	}

	public LaborAsociadaId(Long laborId, Long laborAsocId) {
		this.laborId = laborId;
		this.laborAsocId = laborAsocId;
	}

	public Long getLaborId() {
		return this.laborId;
	}

	public void setLaborId(Long laborId) {
		this.laborId = laborId;
	}

	public Long getLaborAsocId() {
		return this.laborAsocId;
	}

	public void setLaborAsocId(Long laborAsocId) {
		this.laborAsocId = laborAsocId;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LaborAsociadaId))
			return false;
		LaborAsociadaId castOther = (LaborAsociadaId) other;

		return ((this.getLaborId() == castOther.getLaborId()) || (this.getLaborId() != null
				&& castOther.getLaborId() != null && this.getLaborId().equals(castOther.getLaborId())))
				&& ((this.getLaborAsocId() == castOther.getLaborAsocId())
						|| (this.getLaborAsocId() != null && castOther.getLaborAsocId() != null
								&& this.getLaborAsocId().equals(castOther.getLaborAsocId())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLaborId() == null ? 0 : this.getLaborId().hashCode());
		result = 37 * result + (getLaborAsocId() == null ? 0 : this.getLaborAsocId().hashCode());
		return result;
	}

}
