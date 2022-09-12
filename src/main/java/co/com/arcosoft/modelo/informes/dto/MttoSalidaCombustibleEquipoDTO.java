package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MttoSalidaCombustibleEquipoDTO {

	private	Date	fecha_registro	;
	private	BigInteger	consecutivo	;
	private	BigInteger	numero_planilla_fisica	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	nom_medidor	;
	private	BigDecimal	horometro_entrada	;
	private	BigDecimal	odomentro_entrada	;
	private	String	nom_tipo_abastecimiento	;
	private	String	nom_bomba_abastecimiento	;
	private	String	cod_almacen	;
	private	String	nom_almacen	;
	private	String	cod_despachador	;
	private	String	nom_despachador	;
	private	String	cod_conductor	;
	private	String	nom_conductor	;
	private	String	cod_producto	;
	private	String	nom_producto	;
	private	String	cod_um_producto	;
	private	String	nom_um_producto	;
	private	BigDecimal	cantidad	;
	private	BigDecimal	valor_unitario	;
	private	BigDecimal	costo_total	;
	private	String	observacion	;
	private	BigInteger	dat_abast_combustible_id	;
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
	 * @return the numero_planilla_fisica
	 */
	public BigInteger getNumero_planilla_fisica() {
		return numero_planilla_fisica;
	}
	/**
	 * @param numero_planilla_fisica the numero_planilla_fisica to set
	 */
	public void setNumero_planilla_fisica(BigInteger numero_planilla_fisica) {
		this.numero_planilla_fisica = numero_planilla_fisica;
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
	 * @return the nom_tipo_abastecimiento
	 */
	public String getNom_tipo_abastecimiento() {
		return nom_tipo_abastecimiento;
	}
	/**
	 * @param nom_tipo_abastecimiento the nom_tipo_abastecimiento to set
	 */
	public void setNom_tipo_abastecimiento(String nom_tipo_abastecimiento) {
		this.nom_tipo_abastecimiento = nom_tipo_abastecimiento;
	}
	/**
	 * @return the nom_bomba_abastecimiento
	 */
	public String getNom_bomba_abastecimiento() {
		return nom_bomba_abastecimiento;
	}
	/**
	 * @param nom_bomba_abastecimiento the nom_bomba_abastecimiento to set
	 */
	public void setNom_bomba_abastecimiento(String nom_bomba_abastecimiento) {
		this.nom_bomba_abastecimiento = nom_bomba_abastecimiento;
	}
	/**
	 * @return the cod_almacen
	 */
	public String getCod_almacen() {
		return cod_almacen;
	}
	/**
	 * @param cod_almacen the cod_almacen to set
	 */
	public void setCod_almacen(String cod_almacen) {
		this.cod_almacen = cod_almacen;
	}
	/**
	 * @return the nom_almacen
	 */
	public String getNom_almacen() {
		return nom_almacen;
	}
	/**
	 * @param nom_almacen the nom_almacen to set
	 */
	public void setNom_almacen(String nom_almacen) {
		this.nom_almacen = nom_almacen;
	}
	/**
	 * @return the cod_despachador
	 */
	public String getCod_despachador() {
		return cod_despachador;
	}
	/**
	 * @param cod_despachador the cod_despachador to set
	 */
	public void setCod_despachador(String cod_despachador) {
		this.cod_despachador = cod_despachador;
	}
	/**
	 * @return the nom_despachador
	 */
	public String getNom_despachador() {
		return nom_despachador;
	}
	/**
	 * @param nom_despachador the nom_despachador to set
	 */
	public void setNom_despachador(String nom_despachador) {
		this.nom_despachador = nom_despachador;
	}
	/**
	 * @return the cod_conductor
	 */
	public String getCod_conductor() {
		return cod_conductor;
	}
	/**
	 * @param cod_conductor the cod_conductor to set
	 */
	public void setCod_conductor(String cod_conductor) {
		this.cod_conductor = cod_conductor;
	}
	/**
	 * @return the nom_conductor
	 */
	public String getNom_conductor() {
		return nom_conductor;
	}
	/**
	 * @param nom_conductor the nom_conductor to set
	 */
	public void setNom_conductor(String nom_conductor) {
		this.nom_conductor = nom_conductor;
	}
	/**
	 * @return the cod_producto
	 */
	public String getCod_producto() {
		return cod_producto;
	}
	/**
	 * @param cod_producto the cod_producto to set
	 */
	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}
	/**
	 * @return the nom_producto
	 */
	public String getNom_producto() {
		return nom_producto;
	}
	/**
	 * @param nom_producto the nom_producto to set
	 */
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	/**
	 * @return the cod_um_producto
	 */
	public String getCod_um_producto() {
		return cod_um_producto;
	}
	/**
	 * @param cod_um_producto the cod_um_producto to set
	 */
	public void setCod_um_producto(String cod_um_producto) {
		this.cod_um_producto = cod_um_producto;
	}
	/**
	 * @return the nom_um_producto
	 */
	public String getNom_um_producto() {
		return nom_um_producto;
	}
	/**
	 * @param nom_um_producto the nom_um_producto to set
	 */
	public void setNom_um_producto(String nom_um_producto) {
		this.nom_um_producto = nom_um_producto;
	}
	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the valor_unitario
	 */
	public BigDecimal getValor_unitario() {
		return valor_unitario;
	}
	/**
	 * @param valor_unitario the valor_unitario to set
	 */
	public void setValor_unitario(BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	/**
	 * @return the costo_total
	 */
	public BigDecimal getCosto_total() {
		return costo_total;
	}
	/**
	 * @param costo_total the costo_total to set
	 */
	public void setCosto_total(BigDecimal costo_total) {
		this.costo_total = costo_total;
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
	 * @return the dat_abast_combustible_id
	 */
	public BigInteger getDat_abast_combustible_id() {
		return dat_abast_combustible_id;
	}
	/**
	 * @param dat_abast_combustible_id the dat_abast_combustible_id to set
	 */
	public void setDat_abast_combustible_id(BigInteger dat_abast_combustible_id) {
		this.dat_abast_combustible_id = dat_abast_combustible_id;
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
