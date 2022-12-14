package co.com.arcosoft.modelo;
// Generated 14-abr-2016 14:31:07 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * PrecioPromProdId generated by hbm2java
 */
public class PrecioPromProdId implements java.io.Serializable {

	private Long productoId;
	private Long almacenId;
	public Long compania;
	private Double valorUnitario;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaInicial;
	private Date fechaFinal;
	private Long precioProdId;

	public Long getPrecioProdId() {
		return precioProdId;
	}

	public void setPrecioProdId(Long precioProdId) {
		this.precioProdId = precioProdId;
	}

	public PrecioPromProdId() {
	}

	public PrecioPromProdId(Long productoId, Long almacenId, Long precioProdId, Long compania, Double valorUnitario,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, Date fechaInicial,
			Date fechaFinal) {
		this.productoId = productoId;
		this.almacenId = almacenId;
		this.compania = compania;
		this.valorUnitario = valorUnitario;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.precioProdId = precioProdId;
	}

	public Long getProductoId() {
		return this.productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getAlmacenId() {
		return this.almacenId;
	}

	public void setAlmacenId(Long almacenId) {
		this.almacenId = almacenId;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrecioPromProdId))
			return false;
		PrecioPromProdId castOther = (PrecioPromProdId) other;

		return ((this.getProductoId() == castOther.getProductoId()) || (this.getProductoId() != null
				&& castOther.getProductoId() != null && this.getProductoId().equals(castOther.getProductoId())))
				&& ((this.getAlmacenId() == castOther.getAlmacenId()) || (this.getAlmacenId() != null
						&& castOther.getAlmacenId() != null && this.getAlmacenId().equals(castOther.getAlmacenId())))
				&& ((this.getCompania() == castOther.getCompania()) || (this.getCompania() != null
						&& castOther.getCompania() != null && this.getCompania().equals(castOther.getCompania())))
				&& ((this.getValorUnitario() == castOther.getValorUnitario())
						|| (this.getValorUnitario() != null && castOther.getValorUnitario() != null
								&& this.getValorUnitario().equals(castOther.getValorUnitario())))
				&& ((this.getInfoAdicional() == castOther.getInfoAdicional())
						|| (this.getInfoAdicional() != null && castOther.getInfoAdicional() != null
								&& this.getInfoAdicional().equals(castOther.getInfoAdicional())))
				&& ((this.getInfoAdicional2() == castOther.getInfoAdicional2())
						|| (this.getInfoAdicional2() != null && castOther.getInfoAdicional2() != null
								&& this.getInfoAdicional2().equals(castOther.getInfoAdicional2())))
				&& ((this.getFechaCreacion() == castOther.getFechaCreacion())
						|| (this.getFechaCreacion() != null && castOther.getFechaCreacion() != null
								&& this.getFechaCreacion().equals(castOther.getFechaCreacion())))
				&& ((this.getFechaModificacion() == castOther.getFechaModificacion())
						|| (this.getFechaModificacion() != null && castOther.getFechaModificacion() != null
								&& this.getFechaModificacion().equals(castOther.getFechaModificacion())))
				&& ((this.getFechaInicial() == castOther.getFechaInicial())
						|| (this.getFechaInicial() != null && castOther.getFechaInicial() != null
								&& this.getFechaInicial().equals(castOther.getFechaInicial())))
				&& ((this.getFechaFinal() == castOther.getFechaFinal())
						|| (this.getFechaFinal() != null && castOther.getFechaFinal() != null
								&& this.getFechaFinal().equals(castOther.getFechaFinal())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductoId() == null ? 0 : this.getProductoId().hashCode());
		result = 37 * result + (getAlmacenId() == null ? 0 : this.getAlmacenId().hashCode());
		result = 37 * result + (getCompania() == null ? 0 : this.getCompania().hashCode());
		result = 37 * result + (getValorUnitario() == null ? 0 : this.getValorUnitario().hashCode());
		result = 37 * result + (getInfoAdicional() == null ? 0 : this.getInfoAdicional().hashCode());
		result = 37 * result + (getInfoAdicional2() == null ? 0 : this.getInfoAdicional2().hashCode());
		result = 37 * result + (getFechaCreacion() == null ? 0 : this.getFechaCreacion().hashCode());
		result = 37 * result + (getFechaModificacion() == null ? 0 : this.getFechaModificacion().hashCode());
		result = 37 * result + (getFechaInicial() == null ? 0 : this.getFechaInicial().hashCode());
		result = 37 * result + (getFechaFinal() == null ? 0 : this.getFechaFinal().hashCode());
		return result;
	}

}
