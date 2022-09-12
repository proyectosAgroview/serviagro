package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MttoReporteFallasEquipoDTO {

	private	Date	fecha_registro	;
	private	BigInteger	consecutivo	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	nom_medidor	;
	private	BigDecimal	horometro_entrada	;
	private	BigDecimal	odomentro_entrada	;
	private	String	motivo_entrda_taller	;
	private	String	agente_causador	;
	private	String	cod_operario_maquina	;
	private	String	nom_operario_maquina	;
	private	String	cod_supervisor_mtto	;
	private	String	nom_supervisor_mtto	;
	private	String	descripcion_falla	;
	private	String	hora_inicial_parada	;
	private	String	hora_final_parada	;
	private	BigDecimal	duracion_real_hh	;
	private	BigInteger	dat_reporte_fallas_id	;
	private	String	codtag	;
	private	String	nombretag	;
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
	 * @return the motivo_entrda_taller
	 */
	public String getMotivo_entrda_taller() {
		return motivo_entrda_taller;
	}
	/**
	 * @param motivo_entrda_taller the motivo_entrda_taller to set
	 */
	public void setMotivo_entrda_taller(String motivo_entrda_taller) {
		this.motivo_entrda_taller = motivo_entrda_taller;
	}
	/**
	 * @return the agente_causador
	 */
	public String getAgente_causador() {
		return agente_causador;
	}
	/**
	 * @param agente_causador the agente_causador to set
	 */
	public void setAgente_causador(String agente_causador) {
		this.agente_causador = agente_causador;
	}
	/**
	 * @return the cod_operario_maquina
	 */
	public String getCod_operario_maquina() {
		return cod_operario_maquina;
	}
	/**
	 * @param cod_operario_maquina the cod_operario_maquina to set
	 */
	public void setCod_operario_maquina(String cod_operario_maquina) {
		this.cod_operario_maquina = cod_operario_maquina;
	}
	/**
	 * @return the nom_operario_maquina
	 */
	public String getNom_operario_maquina() {
		return nom_operario_maquina;
	}
	/**
	 * @param nom_operario_maquina the nom_operario_maquina to set
	 */
	public void setNom_operario_maquina(String nom_operario_maquina) {
		this.nom_operario_maquina = nom_operario_maquina;
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
	 * @return the descripcion_falla
	 */
	public String getDescripcion_falla() {
		return descripcion_falla;
	}
	/**
	 * @param descripcion_falla the descripcion_falla to set
	 */
	public void setDescripcion_falla(String descripcion_falla) {
		this.descripcion_falla = descripcion_falla;
	}
	/**
	 * @return the hora_inicial_parada
	 */
	public String getHora_inicial_parada() {
		return hora_inicial_parada;
	}
	/**
	 * @param hora_inicial_parada the hora_inicial_parada to set
	 */
	public void setHora_inicial_parada(String hora_inicial_parada) {
		this.hora_inicial_parada = hora_inicial_parada;
	}
	/**
	 * @return the hora_final_parada
	 */
	public String getHora_final_parada() {
		return hora_final_parada;
	}
	/**
	 * @param hora_final_parada the hora_final_parada to set
	 */
	public void setHora_final_parada(String hora_final_parada) {
		this.hora_final_parada = hora_final_parada;
	}
	/**
	 * @return the duracion_real_hh
	 */
	public BigDecimal getDuracion_real_hh() {
		return duracion_real_hh;
	}
	/**
	 * @param duracion_real_hh the duracion_real_hh to set
	 */
	public void setDuracion_real_hh(BigDecimal duracion_real_hh) {
		this.duracion_real_hh = duracion_real_hh;
	}
	/**
	 * @return the dat_reporte_fallas_id
	 */
	public BigInteger getDat_reporte_fallas_id() {
		return dat_reporte_fallas_id;
	}
	/**
	 * @param dat_reporte_fallas_id the dat_reporte_fallas_id to set
	 */
	public void setDat_reporte_fallas_id(BigInteger dat_reporte_fallas_id) {
		this.dat_reporte_fallas_id = dat_reporte_fallas_id;
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

	
}
