package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ImportarNominaEmpAdmonDTO {

	private BigInteger idTabla ;
	private BigInteger idTrabajador;
	private BigInteger idConceptoNomina;
	private BigInteger idCompania ;
	private Date periodoInicial ;
	private Date periodoFinal ;
	private String tipoMovimiento;
	private BigDecimal devengo;
	private BigDecimal descuentos;
	private String notas;
	private BigInteger 	 idCentCost ;
	private BigInteger idEquipo;
	
	
	public BigInteger getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(BigInteger idEquipo) {
		this.idEquipo = idEquipo;
	}
	public BigInteger getIdCentCost() {
		return idCentCost;
	}
	public void setIdCentCost(BigInteger idCentCost) {
		this.idCentCost = idCentCost;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public BigInteger getIdTabla() {
		return idTabla;
	}
	public void setIdTabla(BigInteger idTabla) {
		this.idTabla = idTabla;
	}
	public BigInteger getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(BigInteger idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public BigInteger getIdConceptoNomina() {
		return idConceptoNomina;
	}
	public void setIdConceptoNomina(BigInteger idConceptoNomina) {
		this.idConceptoNomina = idConceptoNomina;
	}
	public BigInteger getIdCompania() {
		return idCompania;
	}
	public void setIdCompania(BigInteger idCompania) {
		this.idCompania = idCompania;
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

	public BigDecimal getDevengo() {
		return devengo;
	}
	public void setDevengo(BigDecimal devengo) {
		this.devengo = devengo;
	}
	public BigDecimal getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}
	
	

}
