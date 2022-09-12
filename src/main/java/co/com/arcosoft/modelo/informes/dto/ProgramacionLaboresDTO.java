package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ProgramacionLaboresDTO {

	private BigDecimal cantidadPlan;
	private Integer anio;
	private Integer mes;
	private String anioMes;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String loteA;
	private String codLabor;
	private String nombreLabor;
	private Date periodoInicial;
	private Date periodoFinal;
	private String nombreUdadMed;
	private BigInteger ordenTrabajo;
	private String nombreSupervisor;
	private String observacion;
	private String nomLote;
	private String objetivo;
	private String evidencia;
	private String municipio;
	private String observacionRealizado;
	private Date fechaRealizado;
	private String evidenciaRealizado;
	private BigDecimal rendimientoMO;
	private BigDecimal rendimientoMQ;
	private BigDecimal area;
	private BigDecimal consumoAcpm;
	private BigDecimal plantas;
	private String estadoOt;
	
	
	
	public String getEstadoOt() {
		return estadoOt;
	}

	public void setEstadoOt(String estadoOt) {
		this.estadoOt = estadoOt;
	}

	public BigDecimal getCantidadPlan() {
		return cantidadPlan;
	}

	public void setCantidadPlan(BigDecimal cantidadPlan) {
		this.cantidadPlan = cantidadPlan;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getNomFinca() {
		return nomFinca;
	}

	public void setNomFinca(String nomFinca) {
		this.nomFinca = nomFinca;
	}

	public String getCodBloque() {
		return codBloque;
	}

	public void setCodBloque(String codBloque) {
		this.codBloque = codBloque;
	}

	public String getLoteA() {
		return loteA;
	}

	public void setLoteA(String loteA) {
		this.loteA = loteA;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
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

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public BigInteger getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(BigInteger ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(String evidencia) {
		this.evidencia = evidencia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getObservacionRealizado() {
		return observacionRealizado;
	}

	public void setObservacionRealizado(String observacionRealizado) {
		this.observacionRealizado = observacionRealizado;
	}

	public Date getFechaRealizado() {
		return fechaRealizado;
	}

	public void setFechaRealizado(Date fechaRealizado) {
		this.fechaRealizado = fechaRealizado;
	}

	public String getEvidenciaRealizado() {
		return evidenciaRealizado;
	}

	public void setEvidenciaRealizado(String evidenciaRealizado) {
		this.evidenciaRealizado = evidenciaRealizado;
	}

	public BigDecimal getRendimientoMO() {
		return rendimientoMO;
	}

	public void setRendimientoMO(BigDecimal rendimientoMO) {
		this.rendimientoMO = rendimientoMO;
	}

	public BigDecimal getRendimientoMQ() {
		return rendimientoMQ;
	}

	public void setRendimientoMQ(BigDecimal rendimientoMQ) {
		this.rendimientoMQ = rendimientoMQ;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getConsumoAcpm() {
		return consumoAcpm;
	}

	public void setConsumoAcpm(BigDecimal consumoAcpm) {
		this.consumoAcpm = consumoAcpm;
	}

	public BigDecimal getPlantas() {
		return plantas;
	}

	public void setPlantas(BigDecimal plantas) {
		this.plantas = plantas;
	}

}
