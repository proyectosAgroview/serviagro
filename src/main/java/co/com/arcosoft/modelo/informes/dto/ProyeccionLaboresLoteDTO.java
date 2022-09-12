package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProyeccionLaboresLoteDTO {

	private String nombreCompania;
	private String nombreSecuencia;
	private String nombreLabor;
	private String descripcion;
	private Date fechaInicial;
	private Date fechaFinal;
	private BigDecimal Duracion;

	private String cod_labor;
	private String cod_zona;
	private String nom_zona;
	private String cod_hacienda;
	private String nom_hacienda;
	private String cod_bloque;
	private String nom_bloque;
	private String cod_lote;
	private String nom_lote;
	private String nom_variedad;
	private String nom_etapa;
	private BigDecimal area_neta;
	private BigDecimal numero_plantas;
	private String trabajar_con_area_plantas;
	private String cod_tp_recurso;
	private String nom_tp_recurso;
	private String cod_recurso;
	private String nom_recursos;
	private String um_recurso;
	private String nom_elem_costo;
	private Date fi_tarifa;
	private Date ff_tarifa;
	private BigDecimal disponibilidad_dia;
	private BigDecimal disponibilidad_total;
	private BigDecimal valor_unit_recurso;
	private BigDecimal rendimiento_recurso;
	private BigDecimal cantidad_presupuestada;
	private BigDecimal valor_presupuestado;
	private String anio_mes;
	private String codUdadMed;
	private String nomUdadMed;
	private String nombreGrupoLabor;
	private String origen;
	private BigDecimal valor_ejecutado;
	
	
	
	public BigDecimal getValor_ejecutado() {
		return valor_ejecutado;
	}

	public void setValor_ejecutado(BigDecimal valor_ejecutado) {
		this.valor_ejecutado = valor_ejecutado;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the nombreGrupoLabor
	 */
	public String getNombreGrupoLabor() {
		return nombreGrupoLabor;
	}

	/**
	 * @param nombreGrupoLabor the nombreGrupoLabor to set
	 */
	public void setNombreGrupoLabor(String nombreGrupoLabor) {
		this.nombreGrupoLabor = nombreGrupoLabor;
	}

	/**
	 * @return the codUdadMed
	 */
	public String getCodUdadMed() {
		return codUdadMed;
	}

	/**
	 * @param codUdadMed the codUdadMed to set
	 */
	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	/**
	 * @return the nomUdadMed
	 */
	public String getNomUdadMed() {
		return nomUdadMed;
	}

	/**
	 * @param nomUdadMed the nomUdadMed to set
	 */
	public void setNomUdadMed(String nomUdadMed) {
		this.nomUdadMed = nomUdadMed;
	}

	public String getAnio_mes() {
		return anio_mes;
	}

	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}

	public String getCod_labor() {
		return cod_labor;
	}

	public void setCod_labor(String cod_labor) {
		this.cod_labor = cod_labor;
	}

	public String getCod_zona() {
		return cod_zona;
	}

	public void setCod_zona(String cod_zona) {
		this.cod_zona = cod_zona;
	}

	public String getNom_zona() {
		return nom_zona;
	}

	public void setNom_zona(String nom_zona) {
		this.nom_zona = nom_zona;
	}

	public String getCod_hacienda() {
		return cod_hacienda;
	}

	public void setCod_hacienda(String cod_hacienda) {
		this.cod_hacienda = cod_hacienda;
	}

	public String getNom_hacienda() {
		return nom_hacienda;
	}

	public void setNom_hacienda(String nom_hacienda) {
		this.nom_hacienda = nom_hacienda;
	}

	public String getCod_bloque() {
		return cod_bloque;
	}

	public void setCod_bloque(String cod_bloque) {
		this.cod_bloque = cod_bloque;
	}

	public String getNom_bloque() {
		return nom_bloque;
	}

	public void setNom_bloque(String nom_bloque) {
		this.nom_bloque = nom_bloque;
	}

	public String getCod_lote() {
		return cod_lote;
	}

	public void setCod_lote(String cod_lote) {
		this.cod_lote = cod_lote;
	}

	public String getNom_lote() {
		return nom_lote;
	}

	public void setNom_lote(String nom_lote) {
		this.nom_lote = nom_lote;
	}

	public String getNom_variedad() {
		return nom_variedad;
	}

	public void setNom_variedad(String nom_variedad) {
		this.nom_variedad = nom_variedad;
	}

	public String getNom_etapa() {
		return nom_etapa;
	}

	public void setNom_etapa(String nom_etapa) {
		this.nom_etapa = nom_etapa;
	}

	public BigDecimal getArea_neta() {
		return area_neta;
	}

	public void setArea_neta(BigDecimal area_neta) {
		this.area_neta = area_neta;
	}

	public BigDecimal getNumero_plantas() {
		return numero_plantas;
	}

	public void setNumero_plantas(BigDecimal numero_plantas) {
		this.numero_plantas = numero_plantas;
	}

	public String getTrabajar_con_area_plantas() {
		return trabajar_con_area_plantas;
	}

	public void setTrabajar_con_area_plantas(String trabajar_con_area_plantas) {
		this.trabajar_con_area_plantas = trabajar_con_area_plantas;
	}

	public String getCod_tp_recurso() {
		return cod_tp_recurso;
	}

	public void setCod_tp_recurso(String cod_tp_recurso) {
		this.cod_tp_recurso = cod_tp_recurso;
	}

	public String getNom_tp_recurso() {
		return nom_tp_recurso;
	}

	public void setNom_tp_recurso(String nom_tp_recurso) {
		this.nom_tp_recurso = nom_tp_recurso;
	}

	public String getCod_recurso() {
		return cod_recurso;
	}

	public void setCod_recurso(String cod_recurso) {
		this.cod_recurso = cod_recurso;
	}

	public String getNom_recursos() {
		return nom_recursos;
	}

	public void setNom_recursos(String nom_recursos) {
		this.nom_recursos = nom_recursos;
	}

	public String getUm_recurso() {
		return um_recurso;
	}

	public void setUm_recurso(String um_recurso) {
		this.um_recurso = um_recurso;
	}

	public String getNom_elem_costo() {
		return nom_elem_costo;
	}

	public void setNom_elem_costo(String nom_elem_costo) {
		this.nom_elem_costo = nom_elem_costo;
	}

	public Date getFi_tarifa() {
		return fi_tarifa;
	}

	public void setFi_tarifa(Date fi_tarifa) {
		this.fi_tarifa = fi_tarifa;
	}

	public Date getFf_tarifa() {
		return ff_tarifa;
	}

	public void setFf_tarifa(Date ff_tarifa) {
		this.ff_tarifa = ff_tarifa;
	}

	public BigDecimal getDisponibilidad_dia() {
		return disponibilidad_dia;
	}

	public void setDisponibilidad_dia(BigDecimal disponibilidad_dia) {
		this.disponibilidad_dia = disponibilidad_dia;
	}

	public BigDecimal getDisponibilidad_total() {
		return disponibilidad_total;
	}

	public void setDisponibilidad_total(BigDecimal disponibilidad_total) {
		this.disponibilidad_total = disponibilidad_total;
	}

	public BigDecimal getValor_unit_recurso() {
		return valor_unit_recurso;
	}

	public void setValor_unit_recurso(BigDecimal valor_unit_recurso) {
		this.valor_unit_recurso = valor_unit_recurso;
	}

	public BigDecimal getRendimiento_recurso() {
		return rendimiento_recurso;
	}

	public void setRendimiento_recurso(BigDecimal rendimiento_recurso) {
		this.rendimiento_recurso = rendimiento_recurso;
	}

	public BigDecimal getCantidad_presupuestada() {
		return cantidad_presupuestada;
	}

	public void setCantidad_presupuestada(BigDecimal cantidad_presupuestada) {
		this.cantidad_presupuestada = cantidad_presupuestada;
	}

	public BigDecimal getValor_presupuestado() {
		return valor_presupuestado;
	}

	public void setValor_presupuestado(BigDecimal valor_presupuestado) {
		this.valor_presupuestado = valor_presupuestado;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getNombreSecuencia() {
		return nombreSecuencia;
	}

	public void setNombreSecuencia(String nombreSecuencia) {
		this.nombreSecuencia = nombreSecuencia;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public BigDecimal getDuracion() {
		return Duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		Duracion = duracion;
	}

}
