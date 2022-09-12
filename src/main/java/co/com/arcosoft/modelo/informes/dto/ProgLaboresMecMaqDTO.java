package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ProgLaboresMecMaqDTO {
	private BigInteger compania;
	private Date periodo_inicial;
	private BigInteger consecutivo;
	private BigInteger dat_plan_servicios_mq_id;
	private BigInteger id_programa;
	private BigInteger labor_id;
	private String cod_labor;
	private String nom_labor;
	private BigDecimal num_pases;
	private BigInteger id_supervisor;
	private String cod_supervisor;
	private String nom_supervisor;
	private BigInteger id_zona;
	private String cod_zona;
	private String nom_zona;
	private BigInteger id_cliente;
	private String cod_cliente;
	private String nom_cliente;
	private BigInteger id_finca;
	private String cod_finca;
	private String nom_finca;
	private BigInteger id_lote;
	private String nom_lote;
	private BigDecimal cantidad_plan;
	private BigDecimal cantidad_pendiente;
	private BigDecimal cantidad_programada_movil;
	private BigDecimal area_programada;
	private BigDecimal cantidad_realizada;
	private String facturado;
	private String concluido;
	private BigInteger udad_med_id;
	private String cod_udad_med;
	private String nom_udad_med;
	private BigDecimal valor_est_unitario;
	private BigDecimal valor_est_total;
	private String detalle_nota;
	private BigDecimal anio_registro;
	private BigDecimal mes;
	private String anio_mes;
	private Long usuarioDigitacion;
	private String descripcionOt;
	private String fechaEjcucion;
	private String maquina;
	private String operador;
	private String color;
	private Double porcentajeAvance;
	private BigDecimal ingresoTotal;
	private BigDecimal vlrUnitario;
	private String consecutivoPrefactura;
	private String numFactura;
	private String estadoFactura;
	private BigDecimal cantidadPresupuesto;
	private String cod_lote;
	
	
	
	
	
	
	
	public String getCod_lote() {
		return cod_lote;
	}

	public void setCod_lote(String cod_lote) {
		this.cod_lote = cod_lote;
	}

	public BigDecimal getCantidadPresupuesto() {
		return cantidadPresupuesto;
	}

	public void setCantidadPresupuesto(BigDecimal cantidadPresupuesto) {
		this.cantidadPresupuesto = cantidadPresupuesto;
	}

	public String getConsecutivoPrefactura() {
		return consecutivoPrefactura;
	}

	public void setConsecutivoPrefactura(String consecutivoPrefactura) {
		this.consecutivoPrefactura = consecutivoPrefactura;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public String getEstadoFactura() {
		return estadoFactura;
	}

	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	public BigDecimal getIngresoTotal() {
		return ingresoTotal;
	}

	public void setIngresoTotal(BigDecimal ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public Double getPorcentajeAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(Double porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFechaEjcucion() {
		return fechaEjcucion;
	}

	public void setFechaEjcucion(String fechaEjcucion) {
		this.fechaEjcucion = fechaEjcucion;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public BigDecimal getCantidad_realizada() {
		return cantidad_realizada;
	}

	public void setCantidad_realizada(BigDecimal cantidad_realizada) {
		this.cantidad_realizada = cantidad_realizada;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public String getDescripcionOt() {
		return descripcionOt;
	}

	public void setDescripcionOt(String descripcionOt) {
		this.descripcionOt = descripcionOt;
	}

	public BigInteger getCompania() {
		return compania;
	}

	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}

	public Date getPeriodo_inicial() {
		return periodo_inicial;
	}

	public void setPeriodo_inicial(Date periodo_inicial) {
		this.periodo_inicial = periodo_inicial;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public BigInteger getDat_plan_servicios_mq_id() {
		return dat_plan_servicios_mq_id;
	}

	public void setDat_plan_servicios_mq_id(BigInteger dat_plan_servicios_mq_id) {
		this.dat_plan_servicios_mq_id = dat_plan_servicios_mq_id;
	}

	public BigInteger getId_programa() {
		return id_programa;
	}

	public void setId_programa(BigInteger id_programa) {
		this.id_programa = id_programa;
	}

	public BigInteger getLabor_id() {
		return labor_id;
	}

	public void setLabor_id(BigInteger labor_id) {
		this.labor_id = labor_id;
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

	public BigDecimal getNum_pases() {
		return num_pases;
	}

	public void setNum_pases(BigDecimal num_pases) {
		this.num_pases = num_pases;
	}

	public BigInteger getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(BigInteger id_supervisor) {
		this.id_supervisor = id_supervisor;
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

	public BigInteger getId_zona() {
		return id_zona;
	}

	public void setId_zona(BigInteger id_zona) {
		this.id_zona = id_zona;
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

	public BigInteger getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(BigInteger id_cliente) {
		this.id_cliente = id_cliente;
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

	public BigInteger getId_finca() {
		return id_finca;
	}

	public void setId_finca(BigInteger id_finca) {
		this.id_finca = id_finca;
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

	public BigInteger getId_lote() {
		return id_lote;
	}

	public void setId_lote(BigInteger id_lote) {
		this.id_lote = id_lote;
	}

	public String getNom_lote() {
		return nom_lote;
	}

	public void setNom_lote(String nom_lote) {
		this.nom_lote = nom_lote;
	}

	public BigDecimal getCantidad_plan() {
		return cantidad_plan;
	}

	public void setCantidad_plan(BigDecimal cantidad_plan) {
		this.cantidad_plan = cantidad_plan;
	}

	public BigDecimal getCantidad_pendiente() {
		return cantidad_pendiente;
	}

	public void setCantidad_pendiente(BigDecimal cantidad_pendiente) {
		this.cantidad_pendiente = cantidad_pendiente;
	}

	public BigDecimal getCantidad_programada_movil() {
		return cantidad_programada_movil;
	}

	public void setCantidad_programada_movil(BigDecimal cantidad_programada_movil) {
		this.cantidad_programada_movil = cantidad_programada_movil;
	}

	public BigDecimal getArea_programada() {
		return area_programada;
	}

	public void setArea_programada(BigDecimal area_programada) {
		this.area_programada = area_programada;
	}

	public String getFacturado() {
		return facturado;
	}

	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}

	public String getConcluido() {
		return concluido;
	}

	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}

	public BigInteger getUdad_med_id() {
		return udad_med_id;
	}

	public void setUdad_med_id(BigInteger udad_med_id) {
		this.udad_med_id = udad_med_id;
	}

	public String getCod_udad_med() {
		return cod_udad_med;
	}

	public void setCod_udad_med(String cod_udad_med) {
		this.cod_udad_med = cod_udad_med;
	}

	public String getNom_udad_med() {
		return nom_udad_med;
	}

	public void setNom_udad_med(String nom_udad_med) {
		this.nom_udad_med = nom_udad_med;
	}

	public BigDecimal getValor_est_unitario() {
		return valor_est_unitario;
	}

	public void setValor_est_unitario(BigDecimal valor_est_unitario) {
		this.valor_est_unitario = valor_est_unitario;
	}

	public BigDecimal getValor_est_total() {
		return valor_est_total;
	}

	public void setValor_est_total(BigDecimal valor_est_total) {
		this.valor_est_total = valor_est_total;
	}

	public String getDetalle_nota() {
		return detalle_nota;
	}

	public void setDetalle_nota(String detalle_nota) {
		this.detalle_nota = detalle_nota;
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

	public String getAnio_mes() {
		return anio_mes;
	}

	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}

}
