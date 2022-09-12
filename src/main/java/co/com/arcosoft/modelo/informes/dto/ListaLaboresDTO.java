package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ListaLaboresDTO {

 private BigInteger laborId;
	private String codLabor;
	private String nomLabor;
	private String nomGrupoLabor;
	private String codGrupoLabor;
	
	
	
	public String getCodGrupoLabor() {
		return codGrupoLabor;
	}
	public void setCodGrupoLabor(String codGrupoLabor) {
		this.codGrupoLabor = codGrupoLabor;
	}
	public BigInteger getLaborId() {
		return laborId;
	}
	public void setLaborId(BigInteger laborId) {
		this.laborId = laborId;
	}
	public String getCodLabor() {
		return codLabor;
	}
	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}
	public String getNomLabor() {
		return nomLabor;
	}
	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}
	public String getNomGrupoLabor() {
		return nomGrupoLabor;
	}
	public void setNomGrupoLabor(String nomGrupoLabor) {
		this.nomGrupoLabor = nomGrupoLabor;
	}

	
}
