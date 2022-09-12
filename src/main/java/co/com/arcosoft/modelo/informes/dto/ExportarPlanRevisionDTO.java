package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ExportarPlanRevisionDTO {
	
	private	BigInteger	plan_revision_equipo_id	;
	private	String	cod_plan_revision	;
	private	String	nombre_plan_revision	;
	private	BigInteger	equipo_id	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	BigInteger	sistemas_equipo_id	;
	private	String	nombre_sistema_equipo	;
	private	BigInteger	compartimientos_equipo_id	;
	private	String	nombre_compartimiento_equipo	;
	private	String	codigo_tag	;
	private	String	nombre_tag	;
	private	BigDecimal	periocidad	;
	private	BigDecimal	horas_km_ultimo_servicio	;
	private	String	tipo_medidor	;
	private	BigDecimal	alerta_min	;
	private	String	actividades	;
	private	BigDecimal	secuencia	;
	private	String	duracion	;
	
	
	public BigInteger getPlan_revision_equipo_id() {
		return plan_revision_equipo_id;
	}
	public void setPlan_revision_equipo_id(BigInteger plan_revision_equipo_id) {
		this.plan_revision_equipo_id = plan_revision_equipo_id;
	}
	public String getCod_plan_revision() {
		return cod_plan_revision;
	}
	public void setCod_plan_revision(String cod_plan_revision) {
		this.cod_plan_revision = cod_plan_revision;
	}
	public String getNombre_plan_revision() {
		return nombre_plan_revision;
	}
	public void setNombre_plan_revision(String nombre_plan_revision) {
		this.nombre_plan_revision = nombre_plan_revision;
	}
	public BigInteger getEquipo_id() {
		return equipo_id;
	}
	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
	}
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public String getNom_equipo() {
		return nom_equipo;
	}
	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}
	public BigInteger getSistemas_equipo_id() {
		return sistemas_equipo_id;
	}
	public void setSistemas_equipo_id(BigInteger sistemas_equipo_id) {
		this.sistemas_equipo_id = sistemas_equipo_id;
	}
	public String getNombre_sistema_equipo() {
		return nombre_sistema_equipo;
	}
	public void setNombre_sistema_equipo(String nombre_sistema_equipo) {
		this.nombre_sistema_equipo = nombre_sistema_equipo;
	}
	public BigInteger getCompartimientos_equipo_id() {
		return compartimientos_equipo_id;
	}
	public void setCompartimientos_equipo_id(BigInteger compartimientos_equipo_id) {
		this.compartimientos_equipo_id = compartimientos_equipo_id;
	}
	public String getNombre_compartimiento_equipo() {
		return nombre_compartimiento_equipo;
	}
	public void setNombre_compartimiento_equipo(String nombre_compartimiento_equipo) {
		this.nombre_compartimiento_equipo = nombre_compartimiento_equipo;
	}
	public String getCodigo_tag() {
		return codigo_tag;
	}
	public void setCodigo_tag(String codigo_tag) {
		this.codigo_tag = codigo_tag;
	}
	public String getNombre_tag() {
		return nombre_tag;
	}
	public void setNombre_tag(String nombre_tag) {
		this.nombre_tag = nombre_tag;
	}
	public BigDecimal getPeriocidad() {
		return periocidad;
	}
	public void setPeriocidad(BigDecimal periocidad) {
		this.periocidad = periocidad;
	}
	public BigDecimal getHoras_km_ultimo_servicio() {
		return horas_km_ultimo_servicio;
	}
	public void setHoras_km_ultimo_servicio(BigDecimal horas_km_ultimo_servicio) {
		this.horas_km_ultimo_servicio = horas_km_ultimo_servicio;
	}
	public String getTipo_medidor() {
		return tipo_medidor;
	}
	public void setTipo_medidor(String tipo_medidor) {
		this.tipo_medidor = tipo_medidor;
	}
	public BigDecimal getAlerta_min() {
		return alerta_min;
	}
	public void setAlerta_min(BigDecimal alerta_min) {
		this.alerta_min = alerta_min;
	}
	public String getActividades() {
		return actividades;
	}
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
	public BigDecimal getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	

}
