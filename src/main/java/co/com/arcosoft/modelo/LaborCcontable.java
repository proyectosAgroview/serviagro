package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

/**
 * LaborCcontable generated by hbm2java
 */
public class LaborCcontable implements java.io.Serializable {

	private Long laborCcontableId;
	private Labor labor;
	private CuentaContable cuentaContable;

	public LaborCcontable() {
	}

	public LaborCcontable(Long laborCcontableId, Labor labor, CuentaContable cuentaContable) {
		this.laborCcontableId = laborCcontableId;
		this.labor = labor;
		this.cuentaContable = cuentaContable;
		
	}

	public Long getLaborCcontableId() {
		return laborCcontableId;
	}



	public void setLaborCcontableId(Long laborCcontableId) {
		this.laborCcontableId = laborCcontableId;
	}



	public Labor getLabor() {
		return this.labor;
	}

	public void setLabor(Labor labor) {
		this.labor = labor;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentaContable;
	}

	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

}
