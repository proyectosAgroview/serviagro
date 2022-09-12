package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AnalisisEnfermedadVer2DTO {

	private String fecha;
	private BigInteger anio;
	private BigInteger mes;
	private String nombreEnfermedad;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String codLote;
	private BigDecimal gradoSeveridad;
	private String evolucion;
	private BigDecimal numCenso;
	private BigDecimal linea;
	private BigDecimal planta;
	private Double latitud;
	private Double longitud;
	private String procedimiento;
	private String ubicacion;

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public BigDecimal getGradoSeveridad() {
		return gradoSeveridad;
	}

	public void setGradoSeveridad(BigDecimal gradoSeveridad) {
		this.gradoSeveridad = gradoSeveridad;
	}

	public String getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	public BigDecimal getNumCenso() {
		return numCenso;
	}

	public void setNumCenso(BigDecimal numCenso) {
		this.numCenso = numCenso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public BigInteger getAnio() {
		return anio;
	}

	public void setAnio(BigInteger anio) {
		this.anio = anio;
	}

	public BigInteger getMes() {
		return mes;
	}

	public void setMes(BigInteger mes) {
		this.mes = mes;
	}

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
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

	public BigDecimal getLinea() {
		return linea;
	}

	public void setLinea(BigDecimal linea) {
		this.linea = linea;
	}

	public BigDecimal getPlanta() {
		return planta;
	}

	public void setPlanta(BigDecimal planta) {
		this.planta = planta;
	}

	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

}
