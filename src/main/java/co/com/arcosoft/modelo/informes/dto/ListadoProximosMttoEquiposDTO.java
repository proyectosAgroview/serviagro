package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ListadoProximosMttoEquiposDTO {

	private	BigInteger	equipo_id	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	BigInteger	plan_revision_equipo_id	;
	private	String	cod_plan_revision	;
	private	String	nombre_plan_revision	;
	
	private	String	nombre_sistema_equipo	;
	private	String	nombre_compartimiento_equipo	;
	
	private	Date	fecha_prox_mtto	;
	private	BigDecimal	horas_prox_mtto	;
	private	BigDecimal	km_prox_mtto	;
	private BigDecimal periocidad;
	private BigDecimal horasUltMantenimiento;
	private BigDecimal horo_odo_actual;
	private BigDecimal hor_odo_para_prox_mtto;
	private String colorEvento;
	
	private String tipo_medidor;
	private String alerta;
	private String anim_alerta;
	
	private BigInteger sistemas_equipo_id;
	private BigInteger compartimientos_equipos_id;	
	private Date fecha_ult_mtto;
	
	private BigDecimal hor_odo_prox_mtto;
	private Date fecha_ultimo_servicio;
	
	private String estadoPlan;
	
	
	
	
	public String getEstadoPlan() {
		return estadoPlan;
	}
	public void setEstadoPlan(String estadoPlan) {
		this.estadoPlan = estadoPlan;
	}
	public Date getFecha_ultimo_servicio() {
		return fecha_ultimo_servicio;
	}
	public void setFecha_ultimo_servicio(Date fecha_ultimo_servicio) {
		this.fecha_ultimo_servicio = fecha_ultimo_servicio;
	}
	public BigDecimal getHor_odo_prox_mtto() {
		return hor_odo_prox_mtto;
	}
	public void setHor_odo_prox_mtto(BigDecimal hor_odo_prox_mtto) {
		this.hor_odo_prox_mtto = hor_odo_prox_mtto;
	}
	public Date getFecha_ult_mtto() {
		return fecha_ult_mtto;
	}
	public void setFecha_ult_mtto(Date fecha_ult_mtto) {
		this.fecha_ult_mtto = fecha_ult_mtto;
	}
	public String getColorEvento() {
		return colorEvento;
	}
	public void setColorEvento(String colorEvento) {
		this.colorEvento = colorEvento;
	}
	public BigDecimal getHor_odo_para_prox_mtto() {
		return hor_odo_para_prox_mtto;
	}
	public void setHor_odo_para_prox_mtto(BigDecimal hor_odo_para_prox_mtto) {
		this.hor_odo_para_prox_mtto = hor_odo_para_prox_mtto;
	}
	public BigDecimal getHoro_odo_actual() {
		return horo_odo_actual;
	}
	public void setHoro_odo_actual(BigDecimal horo_odo_actual) {
		this.horo_odo_actual = horo_odo_actual;
	}
	public BigDecimal getHorasUltMantenimiento() {
		return horasUltMantenimiento;
	}
	public void setHorasUltMantenimiento(BigDecimal horasUltMantenimiento) {
		this.horasUltMantenimiento = horasUltMantenimiento;
	}
	public BigDecimal getPeriocidad() {
		return periocidad;
	}
	public void setPeriocidad(BigDecimal periocidad) {
		this.periocidad = periocidad;
	}
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
	/**
	 * @return the nombre_sistema_equipo
	 */
	public String getNombre_sistema_equipo() {
		return nombre_sistema_equipo;
	}
	/**
	 * @param nombre_sistema_equipo the nombre_sistema_equipo to set
	 */
	public void setNombre_sistema_equipo(String nombre_sistema_equipo) {
		this.nombre_sistema_equipo = nombre_sistema_equipo;
	}
	/**
	 * @return the nombre_compartimiento_equipo
	 */
	public String getNombre_compartimiento_equipo() {
		return nombre_compartimiento_equipo;
	}
	/**
	 * @param nombre_compartimiento_equipo the nombre_compartimiento_equipo to set
	 */
	public void setNombre_compartimiento_equipo(String nombre_compartimiento_equipo) {
		this.nombre_compartimiento_equipo = nombre_compartimiento_equipo;
	}
	public String getTipo_medidor() {
		return tipo_medidor;
	}
	public void setTipo_medidor(String tipo_medidor) {
		this.tipo_medidor = tipo_medidor;
	}
	public BigInteger getSistemas_equipo_id() {
		return sistemas_equipo_id;
	}
	public void setSistemas_equipo_id(BigInteger sistemas_equipo_id) {
		this.sistemas_equipo_id = sistemas_equipo_id;
	}
	public BigInteger getCompartimientos_equipos_id() {
		return compartimientos_equipos_id;
	}
	public void setCompartimientos_equipos_id(BigInteger compartimientos_equipos_id) {
		this.compartimientos_equipos_id = compartimientos_equipos_id;
	}
	public String getAlerta() {
		return alerta;
	}
	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}
	public String getAnim_alerta() {
		return anim_alerta;
	}
	public void setAnim_alerta(String anim_alerta) {
		this.anim_alerta = anim_alerta;
	}
	
	
		
}
