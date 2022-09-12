package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaProgLaboresMaqDTO {
	private BigInteger compania;
	private Date periodo_inicial;
	private BigInteger consecutivo;
	private BigInteger dat_plan_servicios_mq_id;
	private BigInteger id_programa;
	private BigInteger labor_id;
	private String cod_labor;
	private String nom_labor;
	private BigInteger id_cliente;

	private String nom_cliente;
	private BigInteger id_finca;
	
	private String nom_finca;
	private BigInteger id_lote;
	private String nom_lote;
	private BigDecimal cantidad_pendiente;
	private BigDecimal area_programada;
	private BigInteger udad_med_id;
	
	
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public BigInteger getCompania() {
		return compania;
	}
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}
	public Date getPeriodo_inicial() {
		return periodo_inicial;
	}
	public void setPeriodo_inicial(Date periodo_inicial) {
		this.periodo_inicial = periodo_inicial;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	public BigInteger getDat_plan_servicios_mq_id() {
		return dat_plan_servicios_mq_id;
	}
	public void setDat_plan_servicios_mq_id(BigInteger dat_plan_servicios_mq_id) {
		this.dat_plan_servicios_mq_id = dat_plan_servicios_mq_id;
	}
	public BigInteger getId_programa() {
		return id_programa;
	}
	public void setId_programa(BigInteger id_programa) {
		this.id_programa = id_programa;
	}
	public BigInteger getLabor_id() {
		return labor_id;
	}
	public void setLabor_id(BigInteger labor_id) {
		this.labor_id = labor_id;
	}
	public String getCod_labor() {
		return cod_labor;
	}
	public void setCod_labor(String cod_labor) {
		this.cod_labor = cod_labor;
	}
	public String getNom_labor() {
		return nom_labor;
	}
	public void setNom_labor(String nom_labor) {
		this.nom_labor = nom_labor;
	}
	public BigInteger getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(BigInteger id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public BigInteger getId_finca() {
		return id_finca;
	}
	public void setId_finca(BigInteger id_finca) {
		this.id_finca = id_finca;
	}

	public String getNom_finca() {
		return nom_finca;
	}
	public void setNom_finca(String nom_finca) {
		this.nom_finca = nom_finca;
	}
	public BigInteger getId_lote() {
		return id_lote;
	}
	public void setId_lote(BigInteger id_lote) {
		this.id_lote = id_lote;
	}
	public String getNom_lote() {
		return nom_lote;
	}
	public void setNom_lote(String nom_lote) {
		this.nom_lote = nom_lote;
	}
	public BigDecimal getCantidad_pendiente() {
		return cantidad_pendiente;
	}
	public void setCantidad_pendiente(BigDecimal cantidad_pendiente) {
		this.cantidad_pendiente = cantidad_pendiente;
	}
	public BigDecimal getArea_programada() {
		return area_programada;
	}
	public void setArea_programada(BigDecimal area_programada) {
		this.area_programada = area_programada;
	}
	public BigInteger getUdad_med_id() {
		return udad_med_id;
	}
	public void setUdad_med_id(BigInteger udad_med_id) {
		this.udad_med_id = udad_med_id;
	}

	
	
}
