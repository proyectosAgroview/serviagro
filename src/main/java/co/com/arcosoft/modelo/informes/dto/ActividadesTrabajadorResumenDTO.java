package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ActividadesTrabajadorResumenDTO {

	private String codTrabajador;
	private String nomTrabajador;
	private BigDecimal totalDevengado;
	private BigDecimal totalDeducciones;
	private BigDecimal netoPagar;
	private Integer semana;
	private String fecha;
	private String nomContratista;
	private String nomCompania;
	private BigDecimal auxSabado;

	public BigDecimal getAuxSabado() {
		return auxSabado;
	}

	public void setAuxSabado(BigDecimal auxSabado) {
		this.auxSabado = auxSabado;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getNomTrabajador() {
		return nomTrabajador;
	}

	public void setNomTrabajador(String nomTrabajador) {
		this.nomTrabajador = nomTrabajador;
	}

	public BigDecimal getTotalDevengado() {
		return totalDevengado;
	}

	public void setTotalDevengado(BigDecimal totalDevengado) {
		this.totalDevengado = totalDevengado;
	}

	public BigDecimal getTotalDeducciones() {
		return totalDeducciones;
	}

	public void setTotalDeducciones(BigDecimal totalDeducciones) {
		this.totalDeducciones = totalDeducciones;
	}

	public BigDecimal getNetoPagar() {
		return netoPagar;
	}

	public void setNetoPagar(BigDecimal netoPagar) {
		this.netoPagar = netoPagar;
	}

	public Integer getSemana() {
		return semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNomContratista() {
		return nomContratista;
	}

	public void setNomContratista(String nomContratista) {
		this.nomContratista = nomContratista;
	}

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

}
