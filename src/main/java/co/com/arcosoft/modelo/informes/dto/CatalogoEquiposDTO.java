package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


public class CatalogoEquiposDTO {

	private BigInteger equipoId;
	private String cod_equipo;
	private String nom_equipo;
	private String origen_datos;
	private String codEvento;
	private String nomEvento;
	
	private Date fecha_inicial_evento;
	private Date fecha_final_evento;
	private BigDecimal dias_notificacion;
	private BigDecimal dias_vencimiento;
	private String estatus_vencimiento;
	
	private String codigoCategoriaEquipo;
	private String nombreCategoriaEquipo;
	private String colorEvento;
	
	
	
	public String getColorEvento() {
		return colorEvento;
	}
	public void setColorEvento(String colorEvento) {
		this.colorEvento = colorEvento;
	}
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public String getCodigoCategoriaEquipo() {
		return codigoCategoriaEquipo;
	}
	public void setCodigoCategoriaEquipo(String codigoCategoriaEquipo) {
		this.codigoCategoriaEquipo = codigoCategoriaEquipo;
	}
	public String getNombreCategoriaEquipo() {
		return nombreCategoriaEquipo;
	}
	public void setNombreCategoriaEquipo(String nombreCategoriaEquipo) {
		this.nombreCategoriaEquipo = nombreCategoriaEquipo;
	}
	public String getCodEvento() {
		return codEvento;
	}
	public void setCodEvento(String codEvento) {
		this.codEvento = codEvento;
	}
	public String getNomEvento() {
		return nomEvento;
	}
	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}
	public Date getFecha_inicial_evento() {
		return fecha_inicial_evento;
	}
	public void setFecha_inicial_evento(Date fecha_inicial_evento) {
		this.fecha_inicial_evento = fecha_inicial_evento;
	}
	public Date getFecha_final_evento() {
		return fecha_final_evento;
	}
	public void setFecha_final_evento(Date fecha_final_evento) {
		this.fecha_final_evento = fecha_final_evento;
	}
	public BigDecimal getDias_notificacion() {
		return dias_notificacion;
	}
	public void setDias_notificacion(BigDecimal dias_notificacion) {
		this.dias_notificacion = dias_notificacion;
	}
	public BigDecimal getDias_vencimiento() {
		return dias_vencimiento;
	}
	public void setDias_vencimiento(BigDecimal dias_vencimiento) {
		this.dias_vencimiento = dias_vencimiento;
	}
	public String getEstatus_vencimiento() {
		return estatus_vencimiento;
	}
	public void setEstatus_vencimiento(String estatus_vencimiento) {
		this.estatus_vencimiento = estatus_vencimiento;
	}
	
	/**
	 * @return the equipoId
	 */
	public BigInteger getEquipoId() {
		return equipoId;
	}
	/**
	 * @param equipoId the equipoId to set
	 */
	public void setEquipoId(BigInteger equipoId) {
		this.equipoId = equipoId;
	}
	/**
	 * @return the nom_equipo
	 */
	public String getNom_equipo() {
		return nom_equipo;
	}
	/**
	 * @param nom_equipo the nom_equipo to set
	 */
	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}
	/**
	 * @return the origen_datos
	 */
	public String getOrigen_datos() {
		return origen_datos;
	}
	/**
	 * @param origen_datos the origen_datos to set
	 */
	public void setOrigen_datos(String origen_datos) {
		this.origen_datos = origen_datos;
	}

	
}
