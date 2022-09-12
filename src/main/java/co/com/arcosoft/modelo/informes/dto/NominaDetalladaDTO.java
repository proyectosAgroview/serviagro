package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class NominaDetalladaDTO {

	private Date fechaRegistro;
	private String ficha;
	private String cedula;
	private String trabajador;
	private String cod_empresa;
	private String nomEmpresa;
	private String horaInicial;
	private String horaFinal;
	private String codLote;
	private String nomLote;
	private String codHacienda;
	private String nomHacienda;
	private String codLabor;
	private String nomLabor;
	private String codConceptoNomina;
	private String nomConceptoNomina;
	private BigDecimal cantidadPago;
	private BigDecimal factorPrestacional;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private BigDecimal cantidadAuxilioTransp;
	private BigDecimal costoAuxilioTransp;
	private BigDecimal cantidadAuxilioAdmon;
	private BigDecimal costoAuxilioAdmon;
	private String origenDatos;
	private BigDecimal area;
	private BigDecimal totalDevengado;
	private BigDecimal prestaciones4_17;
	private BigDecimal prestaciones17_66;
	private BigDecimal aportesPension;
	private BigDecimal aportesCaja;
	private BigDecimal aportesArl;
	private BigDecimal totalGeneral;
	private BigDecimal totalGeneralIva;
	private String ubicacion;
	private String codigoAlternativoNivel2;
	private String codigoAlternativoNivel4;
	private String unidadPago;
	private BigInteger planillaNominaId;
	private BigInteger detPlanillaNominaId;
	private BigInteger consecutivo;	
	private String observacion;
	
	private BigDecimal devengo;
	private BigDecimal deduccion;
	private String tipoMovimiento;
	private BigInteger compania;
	private String nomCompania;
	private String nomProfesion;

	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public BigInteger getPlanillaNominaId() {
		return planillaNominaId;
	}

	public BigInteger getDetPlanillaNominaId() {
		return detPlanillaNominaId;
	}

	public void setPlanillaNominaId(BigInteger planillaNominaId) {
		this.planillaNominaId = planillaNominaId;
	}

	public void setDetPlanillaNominaId(BigInteger detPlanillaNominaId) {
		this.detPlanillaNominaId = detPlanillaNominaId;
	}

	/**
	 * @return the unidadPago
	 */
	public String getUnidadPago() {
		return unidadPago;
	}

	/**
	 * @param unidadPago the unidadPago to set
	 */
	public void setUnidadPago(String unidadPago) {
		this.unidadPago = unidadPago;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCodigoAlternativoNivel2() {
		return codigoAlternativoNivel2;
	}

	public void setCodigoAlternativoNivel2(String codigoAlternativoNivel2) {
		this.codigoAlternativoNivel2 = codigoAlternativoNivel2;
	}

	public String getCodigoAlternativoNivel4() {
		return codigoAlternativoNivel4;
	}

	public void setCodigoAlternativoNivel4(String codigoAlternativoNivel4) {
		this.codigoAlternativoNivel4 = codigoAlternativoNivel4;
	}

	public BigDecimal getPrestaciones4_17() {
		return prestaciones4_17;
	}

	public void setPrestaciones4_17(BigDecimal prestaciones4_17) {
		this.prestaciones4_17 = prestaciones4_17;
	}

	public BigDecimal getPrestaciones17_66() {
		return prestaciones17_66;
	}

	public void setPrestaciones17_66(BigDecimal prestaciones17_66) {
		this.prestaciones17_66 = prestaciones17_66;
	}

	public BigDecimal getTotalDevengado() {
		return totalDevengado;
	}

	public void setTotalDevengado(BigDecimal totalDevengado) {
		this.totalDevengado = totalDevengado;
	}

	public BigDecimal getAportesPension() {
		return aportesPension;
	}

	public void setAportesPension(BigDecimal aportesPension) {
		this.aportesPension = aportesPension;
	}

	public BigDecimal getAportesCaja() {
		return aportesCaja;
	}

	public void setAportesCaja(BigDecimal aportesCaja) {
		this.aportesCaja = aportesCaja;
	}

	public BigDecimal getAportesArl() {
		return aportesArl;
	}

	public void setAportesArl(BigDecimal aportesArl) {
		this.aportesArl = aportesArl;
	}

	public BigDecimal getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(BigDecimal totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public BigDecimal getTotalGeneralIva() {
		return totalGeneralIva;
	}

	public void setTotalGeneralIva(BigDecimal totalGeneralIva) {
		this.totalGeneralIva = totalGeneralIva;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public BigDecimal getCantidadAuxilioTransp() {
		return cantidadAuxilioTransp;
	}

	public void setCantidadAuxilioTransp(BigDecimal cantidadAuxilioTransp) {
		this.cantidadAuxilioTransp = cantidadAuxilioTransp;
	}

	public BigDecimal getCostoAuxilioTransp() {
		return costoAuxilioTransp;
	}

	public void setCostoAuxilioTransp(BigDecimal costoAuxilioTransp) {
		this.costoAuxilioTransp = costoAuxilioTransp;
	}

	public BigDecimal getCantidadAuxilioAdmon() {
		return cantidadAuxilioAdmon;
	}

	public void setCantidadAuxilioAdmon(BigDecimal cantidadAuxilioAdmon) {
		this.cantidadAuxilioAdmon = cantidadAuxilioAdmon;
	}

	public BigDecimal getCostoAuxilioAdmon() {
		return costoAuxilioAdmon;
	}

	public void setCostoAuxilioAdmon(BigDecimal costoAuxilioAdmon) {
		this.costoAuxilioAdmon = costoAuxilioAdmon;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	public String getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(String cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getCodLote() {
		return codLote;
	}

	public void setCodLote(String codLote) {
		this.codLote = codLote;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public String getCodHacienda() {
		return codHacienda;
	}

	public void setCodHacienda(String codHacienda) {
		this.codHacienda = codHacienda;
	}

	public String getNomHacienda() {
		return nomHacienda;
	}

	public void setNomHacienda(String nomHacienda) {
		this.nomHacienda = nomHacienda;
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

	public String getCodConceptoNomina() {
		return codConceptoNomina;
	}

	public void setCodConceptoNomina(String codConceptoNomina) {
		this.codConceptoNomina = codConceptoNomina;
	}

	public String getNomConceptoNomina() {
		return nomConceptoNomina;
	}

	public void setNomConceptoNomina(String nomConceptoNomina) {
		this.nomConceptoNomina = nomConceptoNomina;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public BigDecimal getFactorPrestacional() {
		return factorPrestacional;
	}

	public void setFactorPrestacional(BigDecimal factorPrestacional) {
		this.factorPrestacional = factorPrestacional;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getDevengo() {
		return devengo;
	}

	public void setDevengo(BigDecimal devengo) {
		this.devengo = devengo;
	}

	public BigDecimal getDeduccion() {
		return deduccion;
	}

	public void setDeduccion(BigDecimal deduccion) {
		this.deduccion = deduccion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public BigInteger getCompania() {
		return compania;
	}

	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public String getNomProfesion() {
		return nomProfesion;
	}

	public void setNomProfesion(String nomProfesion) {
		this.nomProfesion = nomProfesion;
	}

}
