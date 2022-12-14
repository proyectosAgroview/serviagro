package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * FactorConversion generated by hbm2java
 */
public class FactorConversion implements java.io.Serializable {

	private Long factorConversionId;
	private UdadMed udadMedByUndadMedDestId;
	private UdadMed udadMedByUnadMedOrigenId;
	private String codigo;
	private String nombre;
	public Long compania;
	private Double factorConversion;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;

	public FactorConversion() {
	}

	public FactorConversion(Long factorConversionId) {
		this.factorConversionId = factorConversionId;
	}

	public FactorConversion(Long factorConversionId, UdadMed udadMedByUndadMedDestId, UdadMed udadMedByUnadMedOrigenId,
			String codigo, String nombre, Long compania, Double factorConversion, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado) {
		this.factorConversionId = factorConversionId;
		this.udadMedByUndadMedDestId = udadMedByUndadMedDestId;
		this.udadMedByUnadMedOrigenId = udadMedByUnadMedOrigenId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.factorConversion = factorConversion;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Long getFactorConversionId() {
		return this.factorConversionId;
	}

	public void setFactorConversionId(Long factorConversionId) {
		this.factorConversionId = factorConversionId;
	}

	public UdadMed getUdadMedByUndadMedDestId() {
		return this.udadMedByUndadMedDestId;
	}

	public void setUdadMedByUndadMedDestId(UdadMed udadMedByUndadMedDestId) {
		this.udadMedByUndadMedDestId = udadMedByUndadMedDestId;
	}

	public UdadMed getUdadMedByUnadMedOrigenId() {
		return this.udadMedByUnadMedOrigenId;
	}

	public void setUdadMedByUnadMedOrigenId(UdadMed udadMedByUnadMedOrigenId) {
		this.udadMedByUnadMedOrigenId = udadMedByUnadMedOrigenId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getFactorConversion() {
		return this.factorConversion;
	}

	public void setFactorConversion(Double factorConversion) {
		this.factorConversion = factorConversion;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
