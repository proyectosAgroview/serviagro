package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsolidadoNominaDTO {

	private Date fechaInicial;
	private Date fechaFinal;
	private String nombreCompania;
	private String codTrabajador;
	private String nomTrabajador;
	private String codConcepto;
	private String nomConcepto;
	private BigDecimal valorTotalLote;

	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String codLote;
	private String nomLote;
	private String origenDatos;
	private BigInteger id;
	private String rut;
	private String telefonoCompania;
	private String direccionCompania;
	private BigDecimal devengo;
	private BigDecimal deduccion;

	private String nomProfesion;
	
	private String tipoMovimiento;
	
	private String observacion;
	private BigDecimal anio;
	private BigDecimal mes;
	
	
	
	
	
	

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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getNomProfesion() {
		return nomProfesion;
	}

	public void setNomProfesion(String nomProfesion) {
		this.nomProfesion = nomProfesion;
	}

	public BigInteger getId() {
		return id;
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

	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelefonoCompania() {
		return telefonoCompania;
	}

	public void setTelefonoCompania(String telefonoCompania) {
		this.telefonoCompania = telefonoCompania;
	}

	public String getDireccionCompania() {
		return direccionCompania;
	}

	public void setDireccionCompania(String direccionCompania) {
		this.direccionCompania = direccionCompania;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getNomTrabajador() {
		return nomTrabajador;
	}

	public void setNomTrabajador(String nomTrabajador) {
		this.nomTrabajador = nomTrabajador;
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

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getCodConcepto() {
		return codConcepto;
	}

	public void setCodConcepto(String codConcepto) {
		this.codConcepto = codConcepto;
	}

	public String getNomConcepto() {
		return nomConcepto;
	}

	public void setNomConcepto(String nomConcepto) {
		this.nomConcepto = nomConcepto;
	}

	public BigDecimal getValorTotalLote() {
		return valorTotalLote;
	}

	public void setValorTotalLote(BigDecimal valorTotalLote) {
		this.valorTotalLote = valorTotalLote;
	}

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getNomFinca() {
		return nomFinca;
	}

	public void setNomFinca(String nomFinca) {
		this.nomFinca = nomFinca;
	}

	public String getCodBloque() {
		return codBloque;
	}

	public void setCodBloque(String codBloque) {
		this.codBloque = codBloque;
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

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

}
