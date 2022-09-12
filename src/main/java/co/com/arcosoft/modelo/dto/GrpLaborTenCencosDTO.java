package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class GrpLaborTenCencosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GrpLaborTenCencosDTO.class);
	private Long grpLaborId;
	private Long centCostId;
	private Long tenenId;
	private Long centCostId_CentCost;
	private Long grpLaborId_GrpLabor;
	private Long tenenId_Tenencia;

	public Long getGrpLaborId() {
		return grpLaborId;
	}

	public void setGrpLaborId(Long grpLaborId) {
		this.grpLaborId = grpLaborId;
	}

	public Long getCentCostId() {
		return centCostId;
	}

	public void setCentCostId(Long centCostId) {
		this.centCostId = centCostId;
	}

	public Long getTenenId() {
		return tenenId;
	}

	public void setTenenId(Long tenenId) {
		this.tenenId = tenenId;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getGrpLaborId_GrpLabor() {
		return grpLaborId_GrpLabor;
	}

	public void setGrpLaborId_GrpLabor(Long grpLaborId_GrpLabor) {
		this.grpLaborId_GrpLabor = grpLaborId_GrpLabor;
	}

	public Long getTenenId_Tenencia() {
		return tenenId_Tenencia;
	}

	public void setTenenId_Tenencia(Long tenenId_Tenencia) {
		this.tenenId_Tenencia = tenenId_Tenencia;
	}
}
