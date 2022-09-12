package co.com.arcosoft.modelo.informes.dto;

import java.math.BigInteger;

public class CatalogoPlanRevisionDTO {

	private BigInteger planRevisionId;
	private String codigoPlan;
	private String nombrePlan;
	/**
	 * @return the equipoId
	 */
	public BigInteger getPlanRevisionId() {
		return planRevisionId;
	}
	public void setPlanRevisionId(BigInteger planRevisionId) {
		this.planRevisionId = planRevisionId;
	}
	public String getCodigoPlan() {
		return codigoPlan;
	}
	public void setCodigoPlan(String codigoPlan) {
		this.codigoPlan = codigoPlan;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

}
