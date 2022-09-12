package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ProduccionLoteArcansasDTO {
	private	Date	max_fecha_apuntamiento	;
	private	String	max_fecha_pesaje	;
	private	String	cod_zona	;
	private	String	nom_zona	;
	private	String	cod_hacienda	;
	private	String	nom_hacienda	;
	private	String	cod_bloque	;
	private	String	nom_bloque	;
	private	String	cod_lote	;
	private	String	nom_lote	;
	private	String	cod_labor	;
	private	String	nom_labor	;
	private	String	nombre_udadmed	;
	private	BigDecimal	no_racimos	;
	private	BigDecimal	peso_promedio	;
	private	BigDecimal	total_racimos	;
	private	BigDecimal	peso_promedio_total_racimos	;
	private	BigDecimal	peso_total_esperado	;
	private	BigDecimal	peso_camion	;
	private	BigDecimal	diferencia_pesos	;
	private	BigDecimal	diferencia_por_racimos	;
	private	BigDecimal	peso_real_racimo_total	;
	private	BigDecimal	peso_promedio_racimo_real_lote	;
	private	BigDecimal	produccion_lote_kg	;
	private	BigDecimal	numero_remision	;
	private	BigInteger	consecutivo_produccion	;
	public Date getMax_fecha_apuntamiento() {
		return max_fecha_apuntamiento;
	}
	public void setMax_fecha_apuntamiento(Date max_fecha_apuntamiento) {
		this.max_fecha_apuntamiento = max_fecha_apuntamiento;
	}
	public String getMax_fecha_pesaje() {
		return max_fecha_pesaje;
	}
	public void setMax_fecha_pesaje(String max_fecha_pesaje) {
		this.max_fecha_pesaje = max_fecha_pesaje;
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
	public String getCod_labor() {
		return cod_labor;
	}
	public void setCod_labor(String cod_labor) {
		this.cod_labor = cod_labor;
	}
	public String getNom_labor() {
		return nom_labor;
	}
	public void setNom_labor(String nom_labor) {
		this.nom_labor = nom_labor;
	}
	public String getNombre_udadmed() {
		return nombre_udadmed;
	}
	public void setNombre_udadmed(String nombre_udadmed) {
		this.nombre_udadmed = nombre_udadmed;
	}
	public BigDecimal getNo_racimos() {
		return no_racimos;
	}
	public void setNo_racimos(BigDecimal no_racimos) {
		this.no_racimos = no_racimos;
	}
	public BigDecimal getPeso_promedio() {
		return peso_promedio;
	}
	public void setPeso_promedio(BigDecimal peso_promedio) {
		this.peso_promedio = peso_promedio;
	}
	public BigDecimal getTotal_racimos() {
		return total_racimos;
	}
	public void setTotal_racimos(BigDecimal total_racimos) {
		this.total_racimos = total_racimos;
	}
	public BigDecimal getPeso_promedio_total_racimos() {
		return peso_promedio_total_racimos;
	}
	public void setPeso_promedio_total_racimos(BigDecimal peso_promedio_total_racimos) {
		this.peso_promedio_total_racimos = peso_promedio_total_racimos;
	}
	public BigDecimal getPeso_total_esperado() {
		return peso_total_esperado;
	}
	public void setPeso_total_esperado(BigDecimal peso_total_esperado) {
		this.peso_total_esperado = peso_total_esperado;
	}
	public BigDecimal getPeso_camion() {
		return peso_camion;
	}
	public void setPeso_camion(BigDecimal peso_camion) {
		this.peso_camion = peso_camion;
	}
	public BigDecimal getDiferencia_pesos() {
		return diferencia_pesos;
	}
	public void setDiferencia_pesos(BigDecimal diferencia_pesos) {
		this.diferencia_pesos = diferencia_pesos;
	}
	public BigDecimal getDiferencia_por_racimos() {
		return diferencia_por_racimos;
	}
	public void setDiferencia_por_racimos(BigDecimal diferencia_por_racimos) {
		this.diferencia_por_racimos = diferencia_por_racimos;
	}
	public BigDecimal getPeso_real_racimo_total() {
		return peso_real_racimo_total;
	}
	public void setPeso_real_racimo_total(BigDecimal peso_real_racimo_total) {
		this.peso_real_racimo_total = peso_real_racimo_total;
	}
	public BigDecimal getPeso_promedio_racimo_real_lote() {
		return peso_promedio_racimo_real_lote;
	}
	public void setPeso_promedio_racimo_real_lote(BigDecimal peso_promedio_racimo_real_lote) {
		this.peso_promedio_racimo_real_lote = peso_promedio_racimo_real_lote;
	}
	public BigDecimal getProduccion_lote_kg() {
		return produccion_lote_kg;
	}
	public void setProduccion_lote_kg(BigDecimal produccion_lote_kg) {
		this.produccion_lote_kg = produccion_lote_kg;
	}
	public BigDecimal getNumero_remision() {
		return numero_remision;
	}
	public void setNumero_remision(BigDecimal numero_remision) {
		this.numero_remision = numero_remision;
	}
	public BigInteger getConsecutivo_produccion() {
		return consecutivo_produccion;
	}
	public void setConsecutivo_produccion(BigInteger consecutivo_produccion) {
		this.consecutivo_produccion = consecutivo_produccion;
	}
				

}
