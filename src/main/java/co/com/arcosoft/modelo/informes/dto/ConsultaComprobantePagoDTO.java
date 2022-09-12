package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Arcosoft1
 *
 */
public class ConsultaComprobantePagoDTO {
	
	private BigDecimal anio;
	private BigDecimal mes;
	private String codEquipo;
	private String nomEquipo;
	private	String	cod_operario;
	private	String	nom_operario;
	private	String	cod_concepto_nomina;
	private	String	nom_concepto_nomina;

	private String estadoTrue;
	private BigInteger equipoId;
	private  BigDecimal devengo;
  
    private String periodoLiquidacion;
    private  String  nom_profesion;
    private BigDecimal descuentos;
    private String tipoMovimiento;
    
    
    private	BigInteger	compania	;
  
    private	String	anio_mes	;
    private	Date	fecha_registro	;
    private	BigDecimal	cantidad_pago	;
    private	BigDecimal	horas_horometro	;
    private	String	turno	;
    private	BigInteger	trab_id	;
    private	BigDecimal	valor_unitario_trabajador	;
    private	String	cod_labor	;
    private	String	nom_labor	;
    private	String	cod_hacienda	;
    private	String	nom_hacienda	;
    private	String	cod_lote	;
   
    private String unidadMedida;
    private BigInteger consecutivo;
    private BigInteger consecutivoRdl;
    
    private String nomCentroCosto;
    
    
    
    
    
	public String getNomCentroCosto() {
		return nomCentroCosto;
	}
	public void setNomCentroCosto(String nomCentroCosto) {
		this.nomCentroCosto = nomCentroCosto;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	public BigInteger getConsecutivoRdl() {
		return consecutivoRdl;
	}
	public void setConsecutivoRdl(BigInteger consecutivoRdl) {
		this.consecutivoRdl = consecutivoRdl;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public BigInteger getCompania() {
		return compania;
	}
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}
	public String getAnio_mes() {
		return anio_mes;
	}
	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public BigDecimal getCantidad_pago() {
		return cantidad_pago;
	}
	public void setCantidad_pago(BigDecimal cantidad_pago) {
		this.cantidad_pago = cantidad_pago;
	}
	public BigDecimal getHoras_horometro() {
		return horas_horometro;
	}
	public void setHoras_horometro(BigDecimal horas_horometro) {
		this.horas_horometro = horas_horometro;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public BigInteger getTrab_id() {
		return trab_id;
	}
	public void setTrab_id(BigInteger trab_id) {
		this.trab_id = trab_id;
	}
	public BigDecimal getValor_unitario_trabajador() {
		return valor_unitario_trabajador;
	}
	public void setValor_unitario_trabajador(BigDecimal valor_unitario_trabajador) {
		this.valor_unitario_trabajador = valor_unitario_trabajador;
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
	public String getCod_lote() {
		return cod_lote;
	}
	public void setCod_lote(String cod_lote) {
		this.cod_lote = cod_lote;
	}
	public BigDecimal getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public BigDecimal getAnio() {
		return anio;
	}
	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}
	public BigDecimal getMes() {
		return mes;
	}
	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	public String getNomEquipo() {
		return nomEquipo;
	}
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}
	public String getCod_operario() {
		return cod_operario;
	}
	public void setCod_operario(String cod_operario) {
		this.cod_operario = cod_operario;
	}
	public String getNom_operario() {
		return nom_operario;
	}
	public void setNom_operario(String nom_operario) {
		this.nom_operario = nom_operario;
	}
	public String getCod_concepto_nomina() {
		return cod_concepto_nomina;
	}
	public void setCod_concepto_nomina(String cod_concepto_nomina) {
		this.cod_concepto_nomina = cod_concepto_nomina;
	}
	public String getNom_concepto_nomina() {
		return nom_concepto_nomina;
	}
	public void setNom_concepto_nomina(String nom_concepto_nomina) {
		this.nom_concepto_nomina = nom_concepto_nomina;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}
	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}
	public BigInteger getEquipoId() {
		return equipoId;
	}
	public void setEquipoId(BigInteger equipoId) {
		this.equipoId = equipoId;
	}
	public BigDecimal getDevengo() {
		return devengo;
	}
	public void setDevengo(BigDecimal devengo) {
		this.devengo = devengo;
	}
	
	public String getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}
	public void setPeriodoLiquidacion(String periodoLiquidacion) {
		this.periodoLiquidacion = periodoLiquidacion;
	}
	public String getNom_profesion() {
		return nom_profesion;
	}
	public void setNom_profesion(String nom_profesion) {
		this.nom_profesion = nom_profesion;
	}
    
    
    

}
