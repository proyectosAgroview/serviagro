package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Arcosoft1
 *
 */
public class DistribuccionCostosMaquinaDTO {

	private BigInteger compania;
	private BigDecimal anio;
	private BigDecimal mes;
	private String anioMes;
	private String anioMesTexto;
	private BigDecimal costoTotal;
	private String origenDatos;
	private Date fecha;
	private	String codEquipo ;
	private	String nomEquipo ;
	
	private	BigDecimal horasHorometro ;
	private	BigDecimal ingresoTotal ;
	private	BigDecimal consolidadoIngresos ;
	private	BigDecimal porcIngresos ;
	private	BigInteger equipoId ;
	
	private BigDecimal totalCostoDistribuido;
	private BigDecimal porcentajeDistribuido;
	private String origenDatos2;
	
	private String color;
	private String maquina;
	private String conceptoInventario;
	private Date fechaServicio;
	private String observacion;
	private String color2;
	private String color3;
	private Date fechaCreacion;
	private String mesCorto;
	private String login;
	
	
	
	
	
	public String getMesCorto() {
		return mesCorto;
	}
	public String getLogin() {
		return login;
	}
	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getAnioMesTexto() {
		return anioMesTexto;
	}
	public void setAnioMesTexto(String anioMesTexto) {
		this.anioMesTexto = anioMesTexto;
	}
	public String getColor3() {
		return color3;
	}
	public void setColor3(String color3) {
		this.color3 = color3;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getConceptoInventario() {
		return conceptoInventario;
	}
	public void setConceptoInventario(String conceptoInventario) {
		this.conceptoInventario = conceptoInventario;
	}
	public Date getFechaServicio() {
		return fechaServicio;
	}
	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOrigenDatos2() {
		return origenDatos2;
	}
	public void setOrigenDatos2(String origenDatos2) {
		this.origenDatos2 = origenDatos2;
	}
	public BigDecimal getPorcentajeDistribuido() {
		return porcentajeDistribuido;
	}
	public void setPorcentajeDistribuido(BigDecimal porcentajeDistribuido) {
		this.porcentajeDistribuido = porcentajeDistribuido;
	}
	public BigDecimal getTotalCostoDistribuido() {
		return totalCostoDistribuido;
	}
	public void setTotalCostoDistribuido(BigDecimal totalCostoDistribuido) {
		this.totalCostoDistribuido = totalCostoDistribuido;
	}
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	public String getNomEquipo() {
		return nomEquipo;
	}
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}
	public BigDecimal getHorasHorometro() {
		return horasHorometro;
	}
	public void setHorasHorometro(BigDecimal horasHorometro) {
		this.horasHorometro = horasHorometro;
	}
	public BigDecimal getIngresoTotal() {
		return ingresoTotal;
	}
	public void setIngresoTotal(BigDecimal ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}
	public BigDecimal getConsolidadoIngresos() {
		return consolidadoIngresos;
	}
	public void setConsolidadoIngresos(BigDecimal consolidadoIngresos) {
		this.consolidadoIngresos = consolidadoIngresos;
	}
	public BigDecimal getPorcIngresos() {
		return porcIngresos;
	}
	public void setPorcIngresos(BigDecimal porcIngresos) {
		this.porcIngresos = porcIngresos;
	}
	public BigInteger getEquipoId() {
		return equipoId;
	}
	public void setEquipoId(BigInteger equipoId) {
		this.equipoId = equipoId;
	}
	public BigInteger getCompania() {
		return compania;
	}
	public void setCompania(BigInteger compania) {
		this.compania = compania;
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
	public String getAnioMes() {
		return anioMes;
	}
	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getOrigenDatos() {
		return origenDatos;
	}
	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

	

}
