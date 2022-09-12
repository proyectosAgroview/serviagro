package co.com.arcosoft.modelo.informes.dto;

import java.math.BigInteger;
import java.util.Date;

public class ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO {

	private BigInteger id;
	private BigInteger consecutivo;
	private String equipo;
	private String tipoTransaccion;
	private Date fechaRegistro;
	private BigInteger nivel4Id;
	private String lote;
	private String proveedor;
	
	private BigInteger proveedorId;
	
	
	public BigInteger getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(BigInteger proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the nivel4Id
	 */
	public BigInteger getNivel4Id() {
		return nivel4Id;
	}

	/**
	 * @param nivel4Id the nivel4Id to set
	 */
	public void setNivel4Id(BigInteger nivel4Id) {
		this.nivel4Id = nivel4Id;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
