package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaEventosPorPagarDTO {

	private BigInteger compania;
	private BigInteger equipoId;
	private String codigoEquipo;
	private String nombreEquipo;
	private BigInteger idPropietario;
	private String propietario;
	private BigInteger idEvento;
	private String nombreEvento;
	private String elementoCosto;
	private BigInteger idEquipoEvento;
	private Date fechaInicial;
	private Date fechaFinal;
	private Date fechaPago;
	private BigInteger idProveedor;
	private String nombreProveedor;
	private String registraPago;
	private String observacion;
	private BigDecimal valorEvento;
	
	public BigInteger getIdEquipoEvento() {
		return idEquipoEvento;
	}
	public void setIdEquipoEvento(BigInteger idEquipoEvento) {
		this.idEquipoEvento = idEquipoEvento;
	}
	public BigInteger getCompania() {
		return compania;
	}
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}
	public BigInteger getEquipoId() {
		return equipoId;
	}
	public void setEquipoId(BigInteger equipoId) {
		this.equipoId = equipoId;
	}
	public String getCodigoEquipo() {
		return codigoEquipo;
	}
	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public BigInteger getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(BigInteger idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public BigInteger getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(BigInteger idEvento) {
		this.idEvento = idEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getElementoCosto() {
		return elementoCosto;
	}
	public void setElementoCosto(String elementoCosto) {
		this.elementoCosto = elementoCosto;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public BigInteger getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(BigInteger idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getRegistraPago() {
		return registraPago;
	}
	public void setRegistraPago(String registraPago) {
		this.registraPago = registraPago;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public BigDecimal getValorEvento() {
		return valorEvento;
	}
	public void setValorEvento(BigDecimal valorEvento) {
		this.valorEvento = valorEvento;
	}
	
	
}
