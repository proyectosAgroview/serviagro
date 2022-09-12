package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConsultaOrdenTrabajoDesDTO {

	private BigInteger planLaborId;
	private String descripcion;
	private BigInteger planLaborDetId;
	private BigInteger nivel1Id;
	private BigInteger nivel2Id;
	private BigInteger nivel3Id;
	private BigInteger nivel4Id;
	private BigInteger laborId;
	private BigInteger umId;
	private BigDecimal cantidadPlanId;
	private BigDecimal pesoPromedio;
	private String nombreNivel2;
	private String nombreNivel4;
	private String nombreLabor;
	private String nombreUdadMed;
	
	
	
	
	
	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getNombreNivel2() {
		return nombreNivel2;
	}

	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	public String getNombreNivel4() {
		return nombreNivel4;
	}

	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	public BigDecimal getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(BigDecimal pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public BigInteger getPlanLaborId() {
		return planLaborId;
	}

	public void setPlanLaborId(BigInteger planLaborId) {
		this.planLaborId = planLaborId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigInteger getPlanLaborDetId() {
		return planLaborDetId;
	}

	public void setPlanLaborDetId(BigInteger planLaborDetId) {
		this.planLaborDetId = planLaborDetId;
	}

	public BigInteger getNivel1Id() {
		return nivel1Id;
	}

	public void setNivel1Id(BigInteger nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public BigInteger getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(BigInteger nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public BigInteger getNivel3Id() {
		return nivel3Id;
	}

	public void setNivel3Id(BigInteger nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public BigInteger getNivel4Id() {
		return nivel4Id;
	}

	public void setNivel4Id(BigInteger nivel4Id) {
		this.nivel4Id = nivel4Id;
	}

	public BigInteger getLaborId() {
		return laborId;
	}

	public void setLaborId(BigInteger laborId) {
		this.laborId = laborId;
	}

	public BigInteger getUmId() {
		return umId;
	}

	public void setUmId(BigInteger umId) {
		this.umId = umId;
	}

	public BigDecimal getCantidadPlanId() {
		return cantidadPlanId;
	}

	public void setCantidadPlanId(BigDecimal cantidadPlanId) {
		this.cantidadPlanId = cantidadPlanId;
	}

}
