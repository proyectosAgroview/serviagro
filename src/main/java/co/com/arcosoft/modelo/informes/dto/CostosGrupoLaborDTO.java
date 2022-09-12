package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class CostosGrupoLaborDTO {

	private BigDecimal costoTotal;
	private String grpLabor;
	private String nombreCompania;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getGrpLabor() {
		return grpLabor;
	}

	public void setGrpLabor(String grpLabor) {
		this.grpLabor = grpLabor;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	@Override
	public String toString() {
		return "CostosGrupoLabor [costoTotal=" + costoTotal + ", grupoLabor=" + grpLabor + "]";
	}

}
