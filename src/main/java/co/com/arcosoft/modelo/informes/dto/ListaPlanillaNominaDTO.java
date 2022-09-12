package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ListaPlanillaNominaDTO {

	private Long planillaNominaId;
	private Date	fechaRegistro;
	private Long consecutivo;
	private String estado;
	private String origenDatos;
	private String estadoPlanilla;
	private String fechaCierrePlanilla;
	private String fechaAberturaPlanilla;
	private String usuarioCierrePlanilla;
	private Long companiaId;
	private String fechaAnulacion;
	private String fechaCreacion;
	private String fechaModificacion;
	private BigDecimal nregistrosPlanilla;
	private BigDecimal unidades;
	
	private BigDecimal costoTotalPlanilla;
	private String estadoLiquidacionTrue;
	private String usuarioDigitacion;
	private String observacion;
	private String  estadoReAbrirLiquidacion;
	private String tipoPlanilla;
	
	
	
	public String getTipoPlanilla() {
		return tipoPlanilla;
	}
	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}
	public String getEstadoReAbrirLiquidacion() {
		return estadoReAbrirLiquidacion;
	}
	public void setEstadoReAbrirLiquidacion(String estadoReAbrirLiquidacion) {
		this.estadoReAbrirLiquidacion = estadoReAbrirLiquidacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getUsuarioDigitacion() {
		return usuarioDigitacion;
	}
	public void setUsuarioDigitacion(String usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}
	public Long getPlanillaNominaId() {
		return planillaNominaId;
	}
	public void setPlanillaNominaId(Long planillaNominaId) {
		this.planillaNominaId = planillaNominaId;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Long getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getOrigenDatos() {
		return origenDatos;
	}
	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}
	public String getEstadoPlanilla() {
		return estadoPlanilla;
	}
	public void setEstadoPlanilla(String estadoPlanilla) {
		this.estadoPlanilla = estadoPlanilla;
	}
	public String getFechaCierrePlanilla() {
		return fechaCierrePlanilla;
	}
	public void setFechaCierrePlanilla(String fechaCierrePlanilla) {
		this.fechaCierrePlanilla = fechaCierrePlanilla;
	}
	public String getFechaAberturaPlanilla() {
		return fechaAberturaPlanilla;
	}
	public void setFechaAberturaPlanilla(String fechaAberturaPlanilla) {
		this.fechaAberturaPlanilla = fechaAberturaPlanilla;
	}
	public String getUsuarioCierrePlanilla() {
		return usuarioCierrePlanilla;
	}
	public void setUsuarioCierrePlanilla(String usuarioCierrePlanilla) {
		this.usuarioCierrePlanilla = usuarioCierrePlanilla;
	}
	public Long getCompaniaId() {
		return companiaId;
	}
	public void setCompaniaId(Long companiaId) {
		this.companiaId = companiaId;
	}
	public String getFechaAnulacion() {
		return fechaAnulacion;
	}
	public void setFechaAnulacion(String fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public BigDecimal getNregistrosPlanilla() {
		return nregistrosPlanilla;
	}
	public void setNregistrosPlanilla(BigDecimal nregistrosPlanilla) {
		this.nregistrosPlanilla = nregistrosPlanilla;
	}
	public BigDecimal getUnidades() {
		return unidades;
	}
	public void setUnidades(BigDecimal unidades) {
		this.unidades = unidades;
	}
	public BigDecimal getCostoTotalPlanilla() {
		return costoTotalPlanilla;
	}
	public void setCostoTotalPlanilla(BigDecimal costoTotalPlanilla) {
		this.costoTotalPlanilla = costoTotalPlanilla;
	}
	public String getEstadoLiquidacionTrue() {
		return estadoLiquidacionTrue;
	}
	public void setEstadoLiquidacionTrue(String estadoLiquidacionTrue) {
		this.estadoLiquidacionTrue = estadoLiquidacionTrue;
	}
	
	

	
		
}
