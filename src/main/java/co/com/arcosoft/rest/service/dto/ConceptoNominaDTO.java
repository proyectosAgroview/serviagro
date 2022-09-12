package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class ConceptoNominaDTO {

	private Long ceptoNominaId;
	private String codigo;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private Long elemCostoId_ElementoCosto;
	private Double factorPrestacional;
	private String excluyeInteface;
	private String excluyeDominical;
	private String excluyeAuxilio;
	private String excluyeAdmon;

	public String getExcluyeAdmon() {
		return excluyeAdmon;
	}

	public void setExcluyeAdmon(String excluyeAdmon) {
		this.excluyeAdmon = excluyeAdmon;
	}

	public String getExcluyeInteface() {
		return excluyeInteface;
	}

	public void setExcluyeInteface(String excluyeInteface) {
		this.excluyeInteface = excluyeInteface;
	}

	public String getExcluyeDominical() {
		return excluyeDominical;
	}

	public void setExcluyeDominical(String excluyeDominical) {
		this.excluyeDominical = excluyeDominical;
	}

	public String getExcluyeAuxilio() {
		return excluyeAuxilio;
	}

	public void setExcluyeAuxilio(String excluyeAuxilio) {
		this.excluyeAuxilio = excluyeAuxilio;
	}

	public Double getFactorPrestacional() {
		return factorPrestacional;
	}

	public void setFactorPrestacional(Double factorPrestacional) {
		this.factorPrestacional = factorPrestacional;
	}

	public Long getCeptoNominaId() {
		return ceptoNominaId;
	}

	public void setCeptoNominaId(Long ceptoNominaId) {
		this.ceptoNominaId = ceptoNominaId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}
}
