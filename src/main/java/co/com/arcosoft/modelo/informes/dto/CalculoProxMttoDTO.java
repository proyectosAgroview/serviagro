package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CalculoProxMttoDTO {

	private	BigInteger	equipo_id	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	BigInteger	plan_revision_equipo_id	;
	private	String	cod_plan_revision	;
	private	String	nombre_plan_revision	;
	private	Date	fecha_prox_mtto	;
	private	BigDecimal	horas_prox_mtto	;
	private	BigDecimal	km_prox_mtto	;
	private	BigInteger	plan_revision_equipo_det_id	;
	/**
	 * @return the equipo_id
	 */
	public BigInteger getEquipo_id() {
		return equipo_id;
	}
	/**
	 * @param equipo_id the equipo_id to set
	 */
	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
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
	 * @return the plan_revision_equipo_id
	 */
	public BigInteger getPlan_revision_equipo_id() {
		return plan_revision_equipo_id;
	}
	/**
	 * @param plan_revision_equipo_id the plan_revision_equipo_id to set
	 */
	public void setPlan_revision_equipo_id(BigInteger plan_revision_equipo_id) {
		this.plan_revision_equipo_id = plan_revision_equipo_id;
	}
	/**
	 * @return the cod_plan_revision
	 */
	public String getCod_plan_revision() {
		return cod_plan_revision;
	}
	/**
	 * @param cod_plan_revision the cod_plan_revision to set
	 */
	public void setCod_plan_revision(String cod_plan_revision) {
		this.cod_plan_revision = cod_plan_revision;
	}
	/**
	 * @return the nombre_plan_revision
	 */
	public String getNombre_plan_revision() {
		return nombre_plan_revision;
	}
	/**
	 * @param nombre_plan_revision the nombre_plan_revision to set
	 */
	public void setNombre_plan_revision(String nombre_plan_revision) {
		this.nombre_plan_revision = nombre_plan_revision;
	}
	/**
	 * @return the fecha_prox_mtto
	 */
	public Date getFecha_prox_mtto() {
		return fecha_prox_mtto;
	}
	/**
	 * @param fecha_prox_mtto the fecha_prox_mtto to set
	 */
	public void setFecha_prox_mtto(Date fecha_prox_mtto) {
		this.fecha_prox_mtto = fecha_prox_mtto;
	}
	/**
	 * @return the horas_prox_mtto
	 */
	public BigDecimal getHoras_prox_mtto() {
		return horas_prox_mtto;
	}
	/**
	 * @param horas_prox_mtto the horas_prox_mtto to set
	 */
	public void setHoras_prox_mtto(BigDecimal horas_prox_mtto) {
		this.horas_prox_mtto = horas_prox_mtto;
	}
	/**
	 * @return the km_prox_mtto
	 */
	public BigDecimal getKm_prox_mtto() {
		return km_prox_mtto;
	}
	/**
	 * @param km_prox_mtto the km_prox_mtto to set
	 */
	public void setKm_prox_mtto(BigDecimal km_prox_mtto) {
		this.km_prox_mtto = km_prox_mtto;
	}
	public BigInteger getPlan_revision_equipo_det_id() {
		return plan_revision_equipo_det_id;
	}
	public void setPlan_revision_equipo_det_id(BigInteger plan_revision_equipo_det_id) {
		this.plan_revision_equipo_det_id = plan_revision_equipo_det_id;
	}
	
		
}
