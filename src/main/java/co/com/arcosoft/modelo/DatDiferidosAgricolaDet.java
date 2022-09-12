package co.com.arcosoft.modelo;
// Generated 29/07/2019 11:07:22 AM by Hibernate Tools 4.0.0

/**
 * DatDiferidosAgricolaDet generated by hbm2java
 */
public class DatDiferidosAgricolaDet implements java.io.Serializable {

	private Long datDiferidosAgricolaDetId;
	private Nivel4 nivel4;
	private DatDiferidosAgricola datDiferidosAgricola;
	private Nivel2 nivel2;
	private Double valorFactura;
	private Long etapaId;
	private Long variedadId;
	private Double areaNeta;

	public DatDiferidosAgricolaDet(Nivel4 nivel4, DatDiferidosAgricola datDiferidosAgricola, Nivel2 nivel2,
			Double valorFactura, Long etapaId, Long variedadId, Double areNeta) {
		this.nivel4 = nivel4;
		this.datDiferidosAgricola = datDiferidosAgricola;
		this.nivel2 = nivel2;
		this.valorFactura = valorFactura;
		this.etapaId = etapaId;
		this.variedadId = variedadId;
		this.areaNeta = areNeta;
	}

	public Long getDatDiferidosAgricolaDetId() {
		return this.datDiferidosAgricolaDetId;
	}

	public void setDatDiferidosAgricolaDetId(Long datDiferidosAgricolaDetId) {
		this.datDiferidosAgricolaDetId = datDiferidosAgricolaDetId;
	}

	public Nivel4 getNivel4() {
		return this.nivel4;
	}

	public void setNivel4(Nivel4 nivel4) {
		this.nivel4 = nivel4;
	}

	public DatDiferidosAgricola getDatDiferidosAgricola() {
		return this.datDiferidosAgricola;
	}

	public void setDatDiferidosAgricola(DatDiferidosAgricola datDiferidosAgricola) {
		this.datDiferidosAgricola = datDiferidosAgricola;
	}

	public Nivel2 getNivel2() {
		return this.nivel2;
	}

	public void setNivel2(Nivel2 nivel2) {
		this.nivel2 = nivel2;
	}

	public Double getValorFactura() {
		return this.valorFactura;
	}

	public void setValorFactura(Double valorFactura) {
		this.valorFactura = valorFactura;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Long getVariedadId() {
		return variedadId;
	}

	public void setVariedadId(Long variedadId) {
		this.variedadId = variedadId;
	}

	public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public DatDiferidosAgricolaDet() {
	}

}