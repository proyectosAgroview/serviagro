package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CostosIndirectosEquipoDTO {

	private Date fecha;
	private String tipoTransaccion;
	private String codProveedor;
	private String nomProveedor;
	private String numFactura;
	private String observacion;
	private String nombreCompania;
	private String nomLabor;
	private String nomElementoCosto;
	private String origenDatos;
	private String nomEquipo;
	private String codEquipo;
	private String nomProducto;
	private String nomUdadMed;
	private BigDecimal cantidad;
	private BigDecimal valorUnit;
	private BigDecimal costoTotal;
	private String descripcion;
	private String estado;
	private BigInteger consecutivo;
	private BigInteger otrosCostosMqId;
	private String codLabor;
	private String anioMes;
	private BigDecimal anio;
	private BigDecimal mes;
	private String llaveImportacion;
	
	private BigDecimal horometroServicio;
	
	private BigInteger id;
	
	private String nomCentroCosto;
	
	
	
	
	
	
	public String getNomCentroCosto() {
		return nomCentroCosto;
	}
	public void setNomCentroCosto(String nomCentroCosto) {
		this.nomCentroCosto = nomCentroCosto;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigDecimal getHorometroServicio() {
		return horometroServicio;
	}
	public void setHorometroServicio(BigDecimal horometroServicio) {
		this.horometroServicio = horometroServicio;
	}
	public String getLlaveImportacion() {
		return llaveImportacion;
	}
	public void setLlaveImportacion(String llaveImportacion) {
		this.llaveImportacion = llaveImportacion;
	}
	public String getCodLabor() {
		return codLabor;
	}
	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}
	public String getAnioMes() {
		return anioMes;
	}
	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}
	public BigDecimal getAnio() {
		return anio;
	}
	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}
	public BigDecimal getMes() {
		return mes;
	}
	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	public BigInteger getOtrosCostosMqId() {
		return otrosCostosMqId;
	}
	public void setOtrosCostosMqId(BigInteger otrosCostosMqId) {
		this.otrosCostosMqId = otrosCostosMqId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}
	public String getNomProveedor() {
		return nomProveedor;
	}
	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getNomLabor() {
		return nomLabor;
	}
	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}
	public String getNomElementoCosto() {
		return nomElementoCosto;
	}
	public void setNomElementoCosto(String nomElementoCosto) {
		this.nomElementoCosto = nomElementoCosto;
	}
	public String getOrigenDatos() {
		return origenDatos;
	}
	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}
	public String getNomEquipo() {
		return nomEquipo;
	}
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public String getNomUdadMed() {
		return nomUdadMed;
	}
	public void setNomUdadMed(String nomUdadMed) {
		this.nomUdadMed = nomUdadMed;
	}
	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the valorUnit
	 */
	public BigDecimal getValorUnit() {
		return valorUnit;
	}
	/**
	 * @param valorUnit the valorUnit to set
	 */
	public void setValorUnit(BigDecimal valorUnit) {
		this.valorUnit = valorUnit;
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
	
	
}
