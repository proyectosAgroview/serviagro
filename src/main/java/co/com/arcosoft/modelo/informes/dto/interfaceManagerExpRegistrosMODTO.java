package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class interfaceManagerExpRegistrosMODTO {

	private String planoNomina;
	private String idEmpresa;
	private String idTipoDoc;
	private String cedulaEmpleado;
	private String nomEmpleado;
	private Date fechaRegistro;
	private String codConceptoNomina;
	private String nomConceptoNomina;
	private BigDecimal cantidadPago;
	private BigDecimal costoTotal;
	private String fecha_texto;
	private String numDias;
	private String cuentaContable;
	
	
	
	
	
	/**
	 * @return the idEmpresa
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}


	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	/**
	 * @return the idTipoDoc
	 */
	public String getIdTipoDoc() {
		return idTipoDoc;
	}


	/**
	 * @param idTipoDoc the idTipoDoc to set
	 */
	public void setIdTipoDoc(String idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}


	/**
	 * @return the cedulaEmpleado
	 */
	public String getCedulaEmpleado() {
		return cedulaEmpleado;
	}


	/**
	 * @param cedulaEmpleado the cedulaEmpleado to set
	 */
	public void setCedulaEmpleado(String cedulaEmpleado) {
		this.cedulaEmpleado = cedulaEmpleado;
	}


	/**
	 * @return the nomEmpleado
	 */
	public String getNomEmpleado() {
		return nomEmpleado;
	}


	/**
	 * @param nomEmpleado the nomEmpleado to set
	 */
	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}


	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	/**
	 * @return the codConceptoNomina
	 */
	public String getCodConceptoNomina() {
		return codConceptoNomina;
	}


	/**
	 * @param codConceptoNomina the codConceptoNomina to set
	 */
	public void setCodConceptoNomina(String codConceptoNomina) {
		this.codConceptoNomina = codConceptoNomina;
	}


	/**
	 * @return the nomConceptoNomina
	 */
	public String getNomConceptoNomina() {
		return nomConceptoNomina;
	}


	/**
	 * @param nomConceptoNomina the nomConceptoNomina to set
	 */
	public void setNomConceptoNomina(String nomConceptoNomina) {
		this.nomConceptoNomina = nomConceptoNomina;
	}


	/**
	 * @return the cantidadPago
	 */
	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}


	/**
	 * @param cantidadPago the cantidadPago to set
	 */
	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}


	/**
	 * @return the costoTotal
	 */
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}


	/**
	 * @param costoTotal the costoTotal to set
	 */
	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}


	/**
	 * @return the fecha_texto
	 */
	public String getFecha_texto() {
		return fecha_texto;
	}


	/**
	 * @param fecha_texto the fecha_texto to set
	 */
	public void setFecha_texto(String fecha_texto) {
		this.fecha_texto = fecha_texto;
	}


	/**
	 * @return the numDias
	 */
	public String getNumDias() {
		return numDias;
	}


	/**
	 * @param numDias the numDias to set
	 */
	public void setNumDias(String numDias) {
		this.numDias = numDias;
	}


	/**
	 * @return the cuentaContable
	 */
	public String getCuentaContable() {
		return cuentaContable;
	}


	/**
	 * @param cuentaContable the cuentaContable to set
	 */
	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}


	public String getPlanoNomina() {
		return planoNomina;
	}

	
	public void setPlanoNomina(String planoNomina) {
		this.planoNomina = planoNomina;
	}

}
