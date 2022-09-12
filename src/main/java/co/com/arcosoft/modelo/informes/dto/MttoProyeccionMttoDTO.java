package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MttoProyeccionMttoDTO {

	private	BigInteger	id_programa	;
	private	BigInteger	plan_revision_equipo_id	;
	private	String	nombre_plan_revision	;
	private	BigInteger	medidor_id	;
	private	String	nombre_medidor	;
	private	String	tipo_medidor	;
	private	BigInteger	equipo_id	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	BigInteger	cent_cost_id	;
	private	String	centro_costo	;
	private	BigInteger	tag_id	;
	private	String	nombretag	;
	private	BigInteger	sistemas_equipo_id	;
	private	String	nombre_sistema_equipo	;
	private	BigInteger	compartimientos_equipo_id	;
	private	String	nombre_compartimiento_equipo	;
	private	BigDecimal	periocidad_hora	;
	private	BigDecimal	horas_dia_estandar	;
	private	BigDecimal	horometro_inicial	;
	private	BigDecimal	horas_prox_mtto	;
	private	Date	fecha_prox_mtto	;
	private	String	cod_tp_recurso	;
	private	String	nom_tp_recurso	;
	private	String	cod_recurso	;
	private	String	nom_recursos	;
	private	String	um_recurso	;
	private	String	nom_elem_costo_recurso	;
	private	String	fecha_costo_inicial_rec	;
	private	String	fecha_costo_final_rec	;
	private	BigDecimal	disponibilidad_dia_rec	;
	private	BigDecimal	disponibilidad_total_rec	;
	private	BigDecimal	valor_recurso	;
	private String mes;
	private Integer anio;
	
	
	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
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
	 * @return the id_programa
	 */
	public BigInteger getId_programa() {
		return id_programa;
	}
	/**
	 * @param id_programa the id_programa to set
	 */
	public void setId_programa(BigInteger id_programa) {
		this.id_programa = id_programa;
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
	 * @return the medidor_id
	 */
	public BigInteger getMedidor_id() {
		return medidor_id;
	}
	/**
	 * @param medidor_id the medidor_id to set
	 */
	public void setMedidor_id(BigInteger medidor_id) {
		this.medidor_id = medidor_id;
	}
	/**
	 * @return the nombre_medidor
	 */
	public String getNombre_medidor() {
		return nombre_medidor;
	}
	/**
	 * @param nombre_medidor the nombre_medidor to set
	 */
	public void setNombre_medidor(String nombre_medidor) {
		this.nombre_medidor = nombre_medidor;
	}
	/**
	 * @return the tipo_medidor
	 */
	public String getTipo_medidor() {
		return tipo_medidor;
	}
	/**
	 * @param tipo_medidor the tipo_medidor to set
	 */
	public void setTipo_medidor(String tipo_medidor) {
		this.tipo_medidor = tipo_medidor;
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
	 * @return the cent_cost_id
	 */
	public BigInteger getCent_cost_id() {
		return cent_cost_id;
	}
	/**
	 * @param cent_cost_id the cent_cost_id to set
	 */
	public void setCent_cost_id(BigInteger cent_cost_id) {
		this.cent_cost_id = cent_cost_id;
	}
	/**
	 * @return the centro_costo
	 */
	public String getCentro_costo() {
		return centro_costo;
	}
	/**
	 * @param centro_costo the centro_costo to set
	 */
	public void setCentro_costo(String centro_costo) {
		this.centro_costo = centro_costo;
	}
	/**
	 * @return the tag_id
	 */
	public BigInteger getTag_id() {
		return tag_id;
	}
	/**
	 * @param tag_id the tag_id to set
	 */
	public void setTag_id(BigInteger tag_id) {
		this.tag_id = tag_id;
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
	 * @return the sistemas_equipo_id
	 */
	public BigInteger getSistemas_equipo_id() {
		return sistemas_equipo_id;
	}
	/**
	 * @param sistemas_equipo_id the sistemas_equipo_id to set
	 */
	public void setSistemas_equipo_id(BigInteger sistemas_equipo_id) {
		this.sistemas_equipo_id = sistemas_equipo_id;
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
	 * @return the compartimientos_equipo_id
	 */
	public BigInteger getCompartimientos_equipo_id() {
		return compartimientos_equipo_id;
	}
	/**
	 * @param compartimientos_equipo_id the compartimientos_equipo_id to set
	 */
	public void setCompartimientos_equipo_id(BigInteger compartimientos_equipo_id) {
		this.compartimientos_equipo_id = compartimientos_equipo_id;
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
	/**
	 * @return the periocidad_hora
	 */
	public BigDecimal getPeriocidad_hora() {
		return periocidad_hora;
	}
	/**
	 * @param periocidad_hora the periocidad_hora to set
	 */
	public void setPeriocidad_hora(BigDecimal periocidad_hora) {
		this.periocidad_hora = periocidad_hora;
	}
	/**
	 * @return the horas_dia_estandar
	 */
	public BigDecimal getHoras_dia_estandar() {
		return horas_dia_estandar;
	}
	/**
	 * @param horas_dia_estandar the horas_dia_estandar to set
	 */
	public void setHoras_dia_estandar(BigDecimal horas_dia_estandar) {
		this.horas_dia_estandar = horas_dia_estandar;
	}
	/**
	 * @return the horometro_inicial
	 */
	public BigDecimal getHorometro_inicial() {
		return horometro_inicial;
	}
	/**
	 * @param horometro_inicial the horometro_inicial to set
	 */
	public void setHorometro_inicial(BigDecimal horometro_inicial) {
		this.horometro_inicial = horometro_inicial;
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
	 * @return the cod_tp_recurso
	 */
	public String getCod_tp_recurso() {
		return cod_tp_recurso;
	}
	/**
	 * @param cod_tp_recurso the cod_tp_recurso to set
	 */
	public void setCod_tp_recurso(String cod_tp_recurso) {
		this.cod_tp_recurso = cod_tp_recurso;
	}
	/**
	 * @return the nom_tp_recurso
	 */
	public String getNom_tp_recurso() {
		return nom_tp_recurso;
	}
	/**
	 * @param nom_tp_recurso the nom_tp_recurso to set
	 */
	public void setNom_tp_recurso(String nom_tp_recurso) {
		this.nom_tp_recurso = nom_tp_recurso;
	}
	/**
	 * @return the cod_recurso
	 */
	public String getCod_recurso() {
		return cod_recurso;
	}
	/**
	 * @param cod_recurso the cod_recurso to set
	 */
	public void setCod_recurso(String cod_recurso) {
		this.cod_recurso = cod_recurso;
	}
	/**
	 * @return the nom_recursos
	 */
	public String getNom_recursos() {
		return nom_recursos;
	}
	/**
	 * @param nom_recursos the nom_recursos to set
	 */
	public void setNom_recursos(String nom_recursos) {
		this.nom_recursos = nom_recursos;
	}
	/**
	 * @return the um_recurso
	 */
	public String getUm_recurso() {
		return um_recurso;
	}
	/**
	 * @param um_recurso the um_recurso to set
	 */
	public void setUm_recurso(String um_recurso) {
		this.um_recurso = um_recurso;
	}
	/**
	 * @return the nom_elem_costo_recurso
	 */
	public String getNom_elem_costo_recurso() {
		return nom_elem_costo_recurso;
	}
	/**
	 * @param nom_elem_costo_recurso the nom_elem_costo_recurso to set
	 */
	public void setNom_elem_costo_recurso(String nom_elem_costo_recurso) {
		this.nom_elem_costo_recurso = nom_elem_costo_recurso;
	}
	/**
	 * @return the fecha_costo_inicial_rec
	 */
	public String getFecha_costo_inicial_rec() {
		return fecha_costo_inicial_rec;
	}
	/**
	 * @param fecha_costo_inicial_rec the fecha_costo_inicial_rec to set
	 */
	public void setFecha_costo_inicial_rec(String fecha_costo_inicial_rec) {
		this.fecha_costo_inicial_rec = fecha_costo_inicial_rec;
	}
	/**
	 * @return the fecha_costo_final_rec
	 */
	public String getFecha_costo_final_rec() {
		return fecha_costo_final_rec;
	}
	/**
	 * @param fecha_costo_final_rec the fecha_costo_final_rec to set
	 */
	public void setFecha_costo_final_rec(String fecha_costo_final_rec) {
		this.fecha_costo_final_rec = fecha_costo_final_rec;
	}
	/**
	 * @return the disponibilidad_dia_rec
	 */
	public BigDecimal getDisponibilidad_dia_rec() {
		return disponibilidad_dia_rec;
	}
	/**
	 * @param disponibilidad_dia_rec the disponibilidad_dia_rec to set
	 */
	public void setDisponibilidad_dia_rec(BigDecimal disponibilidad_dia_rec) {
		this.disponibilidad_dia_rec = disponibilidad_dia_rec;
	}
	/**
	 * @return the disponibilidad_total_rec
	 */
	public BigDecimal getDisponibilidad_total_rec() {
		return disponibilidad_total_rec;
	}
	/**
	 * @param disponibilidad_total_rec the disponibilidad_total_rec to set
	 */
	public void setDisponibilidad_total_rec(BigDecimal disponibilidad_total_rec) {
		this.disponibilidad_total_rec = disponibilidad_total_rec;
	}
	/**
	 * @return the valor_recurso
	 */
	public BigDecimal getValor_recurso() {
		return valor_recurso;
	}
	/**
	 * @param valor_recurso the valor_recurso to set
	 */
	public void setValor_recurso(BigDecimal valor_recurso) {
		this.valor_recurso = valor_recurso;
	}

	
}
