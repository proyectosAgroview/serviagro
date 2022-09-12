package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ProgramacionLaboresMaqDTO {
	private	BigDecimal	anio_registro	;
	private	BigDecimal	mes	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	cod_finca	;
	private	String	nom_finca	;
	private	String	nom_labor	;
	private	BigDecimal	cantidad_plan	;
	private	BigDecimal	cantidad_realizada	;
	private	BigDecimal	cantidad_pendiente	;
	private	String	concluido	;
	private	String	facturado	;
	private	String	cod_um_plan	;
	private	String	nom_um_plan	;
	private	String	nom_lote	;
	private	Date	periodo_inicial	;
	private	BigDecimal	valor_unitario	;
	private	BigDecimal	valor_est_total	;
	private	String	cod_cliente	;
	private	String	nom_cliente	;
	private	String	cod_supervisor	;
	private	String	nom_supervisor	;
	private	String	cod_labor	;
	private	BigInteger	consecutivo	;
	private	BigInteger	dat_plan_servicios_mqdet_id	;
	private	BigInteger	dat_plan_servicios_mq_id	;
	private	BigInteger	equipo_id	;
	private	String	cod_zona	;
	private	String	nom_zona;
	private BigDecimal cantRegistros;
	private String detalleNota;
	private String tipo_mov;
	private String nom_operario;
	private String fecha_realizado;
	
	private BigInteger dat_plan_servicios_mqdet_ejec;
	private String tipoProyecto;
	
	
	private String estadoFactura;
	private BigInteger consecutivoPrefactura;
	private String numFactura;
	
	
	private	String	equipo_id2	;
	private String consecutivoPrefactura2;
	private String numFactura2;
	private BigDecimal cantidadPresupuesto;
	private BigDecimal ingresoTotal;
	private BigDecimal horometroInicial;
	private BigDecimal horometroFinal;
	private BigDecimal horasTotal;
	
	private BigDecimal horasEstiamdas;
	private String nombreCentroCosto;
	
	
	
	
	
	
	
	public String getNombreCentroCosto() {
		return nombreCentroCosto;
	}
	public void setNombreCentroCosto(String nombreCentroCosto) {
		this.nombreCentroCosto = nombreCentroCosto;
	}
	public BigDecimal getHorasEstiamdas() {
		return horasEstiamdas;
	}
	public void setHorasEstiamdas(BigDecimal horasEstiamdas) {
		this.horasEstiamdas = horasEstiamdas;
	}
	public BigDecimal getHorometroInicial() {
		return horometroInicial;
	}
	public void setHorometroInicial(BigDecimal horometroInicial) {
		this.horometroInicial = horometroInicial;
	}
	public BigDecimal getHorometroFinal() {
		return horometroFinal;
	}
	public void setHorometroFinal(BigDecimal horometroFinal) {
		this.horometroFinal = horometroFinal;
	}

	public BigDecimal getHorasTotal() {
		return horasTotal;
	}
	public void setHorasTotal(BigDecimal horasTotal) {
		this.horasTotal = horasTotal;
	}
	public BigDecimal getIngresoTotal() {
		return ingresoTotal;
	}
	public void setIngresoTotal(BigDecimal ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}
	public BigDecimal getCantidadPresupuesto() {
		return cantidadPresupuesto;
	}
	public void setCantidadPresupuesto(BigDecimal cantidadPresupuesto) {
		this.cantidadPresupuesto = cantidadPresupuesto;
	}
	public String getConsecutivoPrefactura2() {
		return consecutivoPrefactura2;
	}
	public void setConsecutivoPrefactura2(String consecutivoPrefactura2) {
		this.consecutivoPrefactura2 = consecutivoPrefactura2;
	}
	public String getNumFactura2() {
		return numFactura2;
	}
	public void setNumFactura2(String numFactura2) {
		this.numFactura2 = numFactura2;
	}
	public String getEquipo_id2() {
		return equipo_id2;
	}
	public void setEquipo_id2(String equipo_id2) {
		this.equipo_id2 = equipo_id2;
	}
	public String getEstadoFactura() {
		return estadoFactura;
	}
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	public BigInteger getConsecutivoPrefactura() {
		return consecutivoPrefactura;
	}
	public void setConsecutivoPrefactura(BigInteger consecutivoPrefactura) {
		this.consecutivoPrefactura = consecutivoPrefactura;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getTipoProyecto() {
		return tipoProyecto;
	}
	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}
	public BigInteger getDat_plan_servicios_mqdet_ejec() {
		return dat_plan_servicios_mqdet_ejec;
	}
	public void setDat_plan_servicios_mqdet_ejec(BigInteger dat_plan_servicios_mqdet_ejec) {
		this.dat_plan_servicios_mqdet_ejec = dat_plan_servicios_mqdet_ejec;
	}
	public String getFecha_realizado() {
		return fecha_realizado;
	}
	public void setFecha_realizado(String fecha_realizado) {
		this.fecha_realizado = fecha_realizado;
	}
	public String getNom_operario() {
		return nom_operario;
	}
	public void setNom_operario(String nom_operario) {
		this.nom_operario = nom_operario;
	}
	public String getTipo_mov() {
		return tipo_mov;
	}
	public void setTipo_mov(String tipo_mov) {
		this.tipo_mov = tipo_mov;
	}
	public String getDetalleNota() {
		return detalleNota;
	}
	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
	}
	public BigDecimal getCantRegistros() {
		return cantRegistros;
	}
	public void setCantRegistros(BigDecimal cantRegistros) {
		this.cantRegistros = cantRegistros;
	}
	public BigDecimal getAnio_registro() {
		return anio_registro;
	}
	public void setAnio_registro(BigDecimal anio_registro) {
		this.anio_registro = anio_registro;
	}
	public BigDecimal getMes() {
		return mes;
	}
	public void setMes(BigDecimal mes) {
		this.mes = mes;
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
	public String getCod_finca() {
		return cod_finca;
	}
	public void setCod_finca(String cod_finca) {
		this.cod_finca = cod_finca;
	}
	public String getNom_finca() {
		return nom_finca;
	}
	public void setNom_finca(String nom_finca) {
		this.nom_finca = nom_finca;
	}
	public String getNom_labor() {
		return nom_labor;
	}
	public void setNom_labor(String nom_labor) {
		this.nom_labor = nom_labor;
	}
	public BigDecimal getCantidad_plan() {
		return cantidad_plan;
	}
	public void setCantidad_plan(BigDecimal cantidad_plan) {
		this.cantidad_plan = cantidad_plan;
	}
	public BigDecimal getCantidad_realizada() {
		return cantidad_realizada;
	}
	public void setCantidad_realizada(BigDecimal cantidad_realizada) {
		this.cantidad_realizada = cantidad_realizada;
	}
	public BigDecimal getCantidad_pendiente() {
		return cantidad_pendiente;
	}
	public void setCantidad_pendiente(BigDecimal cantidad_pendiente) {
		this.cantidad_pendiente = cantidad_pendiente;
	}
	public String getConcluido() {
		return concluido;
	}
	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}
	public String getFacturado() {
		return facturado;
	}
	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}
	public String getCod_um_plan() {
		return cod_um_plan;
	}
	public void setCod_um_plan(String cod_um_plan) {
		this.cod_um_plan = cod_um_plan;
	}
	public String getNom_um_plan() {
		return nom_um_plan;
	}
	public void setNom_um_plan(String nom_um_plan) {
		this.nom_um_plan = nom_um_plan;
	}
	public String getNom_lote() {
		return nom_lote;
	}
	public void setNom_lote(String nom_lote) {
		this.nom_lote = nom_lote;
	}
	public Date getPeriodo_inicial() {
		return periodo_inicial;
	}
	public void setPeriodo_inicial(Date periodo_inicial) {
		this.periodo_inicial = periodo_inicial;
	}
	public BigDecimal getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public BigDecimal getValor_est_total() {
		return valor_est_total;
	}
	public void setValor_est_total(BigDecimal valor_est_total) {
		this.valor_est_total = valor_est_total;
	}
	public String getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public String getCod_supervisor() {
		return cod_supervisor;
	}
	public void setCod_supervisor(String cod_supervisor) {
		this.cod_supervisor = cod_supervisor;
	}
	public String getNom_supervisor() {
		return nom_supervisor;
	}
	public void setNom_supervisor(String nom_supervisor) {
		this.nom_supervisor = nom_supervisor;
	}
	public String getCod_labor() {
		return cod_labor;
	}
	public void setCod_labor(String cod_labor) {
		this.cod_labor = cod_labor;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	public BigInteger getDat_plan_servicios_mqdet_id() {
		return dat_plan_servicios_mqdet_id;
	}
	public void setDat_plan_servicios_mqdet_id(BigInteger dat_plan_servicios_mqdet_id) {
		this.dat_plan_servicios_mqdet_id = dat_plan_servicios_mqdet_id;
	}
	public BigInteger getDat_plan_servicios_mq_id() {
		return dat_plan_servicios_mq_id;
	}
	public void setDat_plan_servicios_mq_id(BigInteger dat_plan_servicios_mq_id) {
		this.dat_plan_servicios_mq_id = dat_plan_servicios_mq_id;
	}
	public BigInteger getEquipo_id() {
		return equipo_id;
	}
	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
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
	
	

}
