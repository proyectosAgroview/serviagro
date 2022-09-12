package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MttoCheckListEquipoDTO {
	private	Date	fecha_registro	;
	private	BigInteger	consecutivo	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	nom_medidor	;
	private	BigDecimal	horometro_entrada	;
	private	BigDecimal	odomentro_entrada	;
	private	String	cod_supervisor_mtto	;
	private	String	nom_supervisor_mtto	;
	private	String	observacion	;
	private	BigInteger	dat_check_list_equipo_id	;
	private	String	codtag	;
	private	String	nombretag	;
	private	Integer	anio	;
	private	String	mes_corto	;
	private	String	cod_sistemas_equipo	;
	private	String	nom_sistemas_equipo	;
	private	String	cod_compartimiento_equipo	;
	private	String	nom_compartimiento_equipo	;
	private	String	condicion_limpieza	;
	private	String	condicion_ruido	;
	private	String	condicion_soldadura	;
	private	String	condicion_conexiones	;
	private	String	condicion_vibracion	;
	private	String	condicion_estado_general	;
	private	String	condicion_pintura	;
	private	String	condicion_lubricantes	;
	/**
	 * @return the fecha_registro
	 */
	public Date getFecha_registro() {
		return fecha_registro;
	}
	/**
	 * @param fecha_registro the fecha_registro to set
	 */
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	/**
	 * @return the consecutivo
	 */
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	/**
	 * @return the cod_equipo
	 */
	public String getCod_equipo() {
		return cod_equipo;
	}
	/**
	 * @param cod_equipo the cod_equipo to set
	 */
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
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
	 * @return the nom_medidor
	 */
	public String getNom_medidor() {
		return nom_medidor;
	}
	/**
	 * @param nom_medidor the nom_medidor to set
	 */
	public void setNom_medidor(String nom_medidor) {
		this.nom_medidor = nom_medidor;
	}
	/**
	 * @return the horometro_entrada
	 */
	public BigDecimal getHorometro_entrada() {
		return horometro_entrada;
	}
	/**
	 * @param horometro_entrada the horometro_entrada to set
	 */
	public void setHorometro_entrada(BigDecimal horometro_entrada) {
		this.horometro_entrada = horometro_entrada;
	}
	/**
	 * @return the odomentro_entrada
	 */
	public BigDecimal getOdomentro_entrada() {
		return odomentro_entrada;
	}
	/**
	 * @param odomentro_entrada the odomentro_entrada to set
	 */
	public void setOdomentro_entrada(BigDecimal odomentro_entrada) {
		this.odomentro_entrada = odomentro_entrada;
	}
	/**
	 * @return the cod_supervisor_mtto
	 */
	public String getCod_supervisor_mtto() {
		return cod_supervisor_mtto;
	}
	/**
	 * @param cod_supervisor_mtto the cod_supervisor_mtto to set
	 */
	public void setCod_supervisor_mtto(String cod_supervisor_mtto) {
		this.cod_supervisor_mtto = cod_supervisor_mtto;
	}
	/**
	 * @return the nom_supervisor_mtto
	 */
	public String getNom_supervisor_mtto() {
		return nom_supervisor_mtto;
	}
	/**
	 * @param nom_supervisor_mtto the nom_supervisor_mtto to set
	 */
	public void setNom_supervisor_mtto(String nom_supervisor_mtto) {
		this.nom_supervisor_mtto = nom_supervisor_mtto;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the dat_check_list_equipo_id
	 */
	public BigInteger getDat_check_list_equipo_id() {
		return dat_check_list_equipo_id;
	}
	/**
	 * @param dat_check_list_equipo_id the dat_check_list_equipo_id to set
	 */
	public void setDat_check_list_equipo_id(BigInteger dat_check_list_equipo_id) {
		this.dat_check_list_equipo_id = dat_check_list_equipo_id;
	}
	/**
	 * @return the codtag
	 */
	public String getCodtag() {
		return codtag;
	}
	/**
	 * @param codtag the codtag to set
	 */
	public void setCodtag(String codtag) {
		this.codtag = codtag;
	}
	/**
	 * @return the nombretag
	 */
	public String getNombretag() {
		return nombretag;
	}
	/**
	 * @param nombretag the nombretag to set
	 */
	public void setNombretag(String nombretag) {
		this.nombretag = nombretag;
	}
	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}
	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	/**
	 * @return the mes_corto
	 */
	public String getMes_corto() {
		return mes_corto;
	}
	/**
	 * @param mes_corto the mes_corto to set
	 */
	public void setMes_corto(String mes_corto) {
		this.mes_corto = mes_corto;
	}
	/**
	 * @return the cod_sistemas_equipo
	 */
	public String getCod_sistemas_equipo() {
		return cod_sistemas_equipo;
	}
	/**
	 * @param cod_sistemas_equipo the cod_sistemas_equipo to set
	 */
	public void setCod_sistemas_equipo(String cod_sistemas_equipo) {
		this.cod_sistemas_equipo = cod_sistemas_equipo;
	}
	/**
	 * @return the nom_sistemas_equipo
	 */
	public String getNom_sistemas_equipo() {
		return nom_sistemas_equipo;
	}
	/**
	 * @param nom_sistemas_equipo the nom_sistemas_equipo to set
	 */
	public void setNom_sistemas_equipo(String nom_sistemas_equipo) {
		this.nom_sistemas_equipo = nom_sistemas_equipo;
	}
	/**
	 * @return the cod_compartimiento_equipo
	 */
	public String getCod_compartimiento_equipo() {
		return cod_compartimiento_equipo;
	}
	/**
	 * @param cod_compartimiento_equipo the cod_compartimiento_equipo to set
	 */
	public void setCod_compartimiento_equipo(String cod_compartimiento_equipo) {
		this.cod_compartimiento_equipo = cod_compartimiento_equipo;
	}
	/**
	 * @return the nom_compartimiento_equipo
	 */
	public String getNom_compartimiento_equipo() {
		return nom_compartimiento_equipo;
	}
	/**
	 * @param nom_compartimiento_equipo the nom_compartimiento_equipo to set
	 */
	public void setNom_compartimiento_equipo(String nom_compartimiento_equipo) {
		this.nom_compartimiento_equipo = nom_compartimiento_equipo;
	}
	/**
	 * @return the condicion_limpieza
	 */
	public String getCondicion_limpieza() {
		return condicion_limpieza;
	}
	/**
	 * @param condicion_limpieza the condicion_limpieza to set
	 */
	public void setCondicion_limpieza(String condicion_limpieza) {
		this.condicion_limpieza = condicion_limpieza;
	}
	/**
	 * @return the condicion_ruido
	 */
	public String getCondicion_ruido() {
		return condicion_ruido;
	}
	/**
	 * @param condicion_ruido the condicion_ruido to set
	 */
	public void setCondicion_ruido(String condicion_ruido) {
		this.condicion_ruido = condicion_ruido;
	}
	/**
	 * @return the condicion_soldadura
	 */
	public String getCondicion_soldadura() {
		return condicion_soldadura;
	}
	/**
	 * @param condicion_soldadura the condicion_soldadura to set
	 */
	public void setCondicion_soldadura(String condicion_soldadura) {
		this.condicion_soldadura = condicion_soldadura;
	}
	/**
	 * @return the condicion_conexiones
	 */
	public String getCondicion_conexiones() {
		return condicion_conexiones;
	}
	/**
	 * @param condicion_conexiones the condicion_conexiones to set
	 */
	public void setCondicion_conexiones(String condicion_conexiones) {
		this.condicion_conexiones = condicion_conexiones;
	}
	/**
	 * @return the condicion_vibracion
	 */
	public String getCondicion_vibracion() {
		return condicion_vibracion;
	}
	/**
	 * @param condicion_vibracion the condicion_vibracion to set
	 */
	public void setCondicion_vibracion(String condicion_vibracion) {
		this.condicion_vibracion = condicion_vibracion;
	}
	/**
	 * @return the condicion_estado_general
	 */
	public String getCondicion_estado_general() {
		return condicion_estado_general;
	}
	/**
	 * @param condicion_estado_general the condicion_estado_general to set
	 */
	public void setCondicion_estado_general(String condicion_estado_general) {
		this.condicion_estado_general = condicion_estado_general;
	}
	/**
	 * @return the condicion_pintura
	 */
	public String getCondicion_pintura() {
		return condicion_pintura;
	}
	/**
	 * @param condicion_pintura the condicion_pintura to set
	 */
	public void setCondicion_pintura(String condicion_pintura) {
		this.condicion_pintura = condicion_pintura;
	}
	/**
	 * @return the condicion_lubricantes
	 */
	public String getCondicion_lubricantes() {
		return condicion_lubricantes;
	}
	/**
	 * @param condicion_lubricantes the condicion_lubricantes to set
	 */
	public void setCondicion_lubricantes(String condicion_lubricantes) {
		this.condicion_lubricantes = condicion_lubricantes;
	}

	
	
}
