package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProgramacionLaboresMobileDTO {

	private BigDecimal planLaborId;
	private BigDecimal compania;
	private BigDecimal ordenTrabajo;
	private BigDecimal Nivel1Id;
	private BigDecimal Nivel12d;
	private BigDecimal Nivel13d;
	private BigDecimal Nivel14d;
	private BigDecimal LaborId;
	private BigDecimal cantidadPlan;
	private Date periodoInicial;
	private Date periodoFinal;
	private String descripcion;
	private BigDecimal UdadMedId;

	public BigDecimal getPlanLaborId() {
		return planLaborId;
	}

	public void setPlanLaborId(BigDecimal planLaborId) {
		this.planLaborId = planLaborId;
	}

	public BigDecimal getCompania() {
		return compania;
	}

	public void setCompania(BigDecimal compania) {
		this.compania = compania;
	}

	public BigDecimal getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(BigDecimal ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public BigDecimal getNivel1Id() {
		return Nivel1Id;
	}

	public void setNivel1Id(BigDecimal nivel1Id) {
		Nivel1Id = nivel1Id;
	}

	public BigDecimal getNivel12d() {
		return Nivel12d;
	}

	public void setNivel12d(BigDecimal nivel12d) {
		Nivel12d = nivel12d;
	}

	public BigDecimal getNivel13d() {
		return Nivel13d;
	}

	public void setNivel13d(BigDecimal nivel13d) {
		Nivel13d = nivel13d;
	}

	public BigDecimal getNivel14d() {
		return Nivel14d;
	}

	public void setNivel14d(BigDecimal nivel14d) {
		Nivel14d = nivel14d;
	}

	public BigDecimal getLaborId() {
		return LaborId;
	}

	public void setLaborId(BigDecimal laborId) {
		LaborId = laborId;
	}

	public BigDecimal getCantidadPlan() {
		return cantidadPlan;
	}

	public void setCantidadPlan(BigDecimal cantidadPlan) {
		this.cantidadPlan = cantidadPlan;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getUdadMedId() {
		return UdadMedId;
	}

	public void setUdadMedId(BigDecimal udadMedId) {
		UdadMedId = udadMedId;
	}

}
