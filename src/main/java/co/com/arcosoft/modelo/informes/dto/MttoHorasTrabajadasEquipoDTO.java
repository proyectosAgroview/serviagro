package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MttoHorasTrabajadasEquipoDTO {

	private	Date	fecha_registro	;
	private	BigInteger	consecutivo	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	nom_medidor	;
	private	BigDecimal	horometro_registrado	;
	private	BigDecimal	odomentro_registrado	;
	private	BigInteger	dat_horas_trabajo_equipo_id	;
	private	Integer	anio	;
	private	String	mes_corto	;
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
	 * @return the horometro_registrado
	 */
	public BigDecimal getHorometro_registrado() {
		return horometro_registrado;
	}
	/**
	 * @param horometro_registrado the horometro_registrado to set
	 */
	public void setHorometro_registrado(BigDecimal horometro_registrado) {
		this.horometro_registrado = horometro_registrado;
	}
	/**
	 * @return the odomentro_registrado
	 */
	public BigDecimal getOdomentro_registrado() {
		return odomentro_registrado;
	}
	/**
	 * @param odomentro_registrado the odomentro_registrado to set
	 */
	public void setOdomentro_registrado(BigDecimal odomentro_registrado) {
		this.odomentro_registrado = odomentro_registrado;
	}
	/**
	 * @return the dat_horas_trabajo_equipo_id
	 */
	public BigInteger getDat_horas_trabajo_equipo_id() {
		return dat_horas_trabajo_equipo_id;
	}
	/**
	 * @param dat_horas_trabajo_equipo_id the dat_horas_trabajo_equipo_id to set
	 */
	public void setDat_horas_trabajo_equipo_id(BigInteger dat_horas_trabajo_equipo_id) {
		this.dat_horas_trabajo_equipo_id = dat_horas_trabajo_equipo_id;
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

}
