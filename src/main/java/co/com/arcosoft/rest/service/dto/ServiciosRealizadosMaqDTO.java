package co.com.arcosoft.rest.service.dto;


import java.util.Date;

public class ServiciosRealizadosMaqDTO {
	private	Long	compania	;
	private	Date	fecha_registro	;
	private	Long	dat_serv_realizados_equipo_id	;
	private	Long	dat_serv_realizados_equipo_det_id	;
	private	Long	consecutivo	;
	private	String	estado_factura	;
	private	Long	pers_empr_id	;
	private	String	cod_cliente	;
	private	Long	nivel2_clientesmq_id	;
	private	String	cod_finca	;
	private	Long	nivel4_clientesmq_id	;
	private	String	cod_lote	;
	private	Long	labor_id	;
	private	String	cod_labor	;
	private	Long	equipo_id	;
	private	String	cod_equipo	;
	private	Double	cantidad_pago	;
	private	Long	udad_med_id	;
	private	String	cod_udad_med_pago	;
	private	Double	horometro_inicial	;
	private	Double	horometro_final	;
	private	Double	horas_total	;
	private	Double	valor_unitario	;
	private	Double	ingreso_total	;
	private	Long	trab_id	;
	private	String	cod_operario	;
	private	Long	id_implemento	;
	private	String	cod_implemento	;
	private	Long	num_factura	;
	private	String	turno	;
	private	Long	concepto_nomina_id	;
	private	String	cod_concepto_nomina	;
	private	Long	usuario_digitacion	;
	private	Long	dat_plan_servicios_mqdet_id	;
	private	Double	valor_unitario_trabajador	;
	private	Double	valor_total_trabajador	;
	private Double area_lote ;
	private Double cantidadProgramada;
	private String observacion;
	private String reportarNovedadParada;
	private String tipoMtto;
	private Double horometroMtto;
	 
	
	
 
	public Double getHorometroMtto() {
		return horometroMtto;
	}
	public void setHorometroMtto(Double horometroMtto) {
		this.horometroMtto = horometroMtto;
	}
	public String getTipoMtto() {
		return tipoMtto;
	}
	public void setTipoMtto(String tipoMtto) {
		this.tipoMtto = tipoMtto;
	}
	public String getReportarNovedadParada() {
		return reportarNovedadParada;
	}
	public void setReportarNovedadParada(String reportarNovedadParada) {
		this.reportarNovedadParada = reportarNovedadParada;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Long getCompania() {
		return compania;
	}
	public void setCompania(Long compania) {
		this.compania = compania;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Long getDat_serv_realizados_equipo_id() {
		return dat_serv_realizados_equipo_id;
	}
	public void setDat_serv_realizados_equipo_id(Long dat_serv_realizados_equipo_id) {
		this.dat_serv_realizados_equipo_id = dat_serv_realizados_equipo_id;
	}
	public Long getDat_serv_realizados_equipo_det_id() {
		return dat_serv_realizados_equipo_det_id;
	}
	public void setDat_serv_realizados_equipo_det_id(Long dat_serv_realizados_equipo_det_id) {
		this.dat_serv_realizados_equipo_det_id = dat_serv_realizados_equipo_det_id;
	}
	public Long getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}
	public String getEstado_factura() {
		return estado_factura;
	}
	public void setEstado_factura(String estado_factura) {
		this.estado_factura = estado_factura;
	}
	public Long getPers_empr_id() {
		return pers_empr_id;
	}
	public void setPers_empr_id(Long pers_empr_id) {
		this.pers_empr_id = pers_empr_id;
	}
	public String getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public Long getNivel2_clientesmq_id() {
		return nivel2_clientesmq_id;
	}
	public void setNivel2_clientesmq_id(Long nivel2_clientesmq_id) {
		this.nivel2_clientesmq_id = nivel2_clientesmq_id;
	}
	public String getCod_finca() {
		return cod_finca;
	}
	public void setCod_finca(String cod_finca) {
		this.cod_finca = cod_finca;
	}
	public Long getNivel4_clientesmq_id() {
		return nivel4_clientesmq_id;
	}
	public void setNivel4_clientesmq_id(Long nivel4_clientesmq_id) {
		this.nivel4_clientesmq_id = nivel4_clientesmq_id;
	}
	public String getCod_lote() {
		return cod_lote;
	}
	public void setCod_lote(String cod_lote) {
		this.cod_lote = cod_lote;
	}
	public Long getLabor_id() {
		return labor_id;
	}
	public void setLabor_id(Long labor_id) {
		this.labor_id = labor_id;
	}
	public String getCod_labor() {
		return cod_labor;
	}
	public void setCod_labor(String cod_labor) {
		this.cod_labor = cod_labor;
	}
	public Long getEquipo_id() {
		return equipo_id;
	}
	public void setEquipo_id(Long equipo_id) {
		this.equipo_id = equipo_id;
	}
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public Double getCantidad_pago() {
		return cantidad_pago;
	}
	public void setCantidad_pago(Double cantidad_pago) {
		this.cantidad_pago = cantidad_pago;
	}
	public Long getUdad_med_id() {
		return udad_med_id;
	}
	public void setUdad_med_id(Long udad_med_id) {
		this.udad_med_id = udad_med_id;
	}
	public String getCod_udad_med_pago() {
		return cod_udad_med_pago;
	}
	public void setCod_udad_med_pago(String cod_udad_med_pago) {
		this.cod_udad_med_pago = cod_udad_med_pago;
	}
	public Double getHorometro_inicial() {
		return horometro_inicial;
	}
	public void setHorometro_inicial(Double horometro_inicial) {
		this.horometro_inicial = horometro_inicial;
	}
	public Double getHorometro_final() {
		return horometro_final;
	}
	public void setHorometro_final(Double horometro_final) {
		this.horometro_final = horometro_final;
	}
	public Double getHoras_total() {
		return horas_total;
	}
	public void setHoras_total(Double horas_total) {
		this.horas_total = horas_total;
	}
	public Double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public Double getIngreso_total() {
		return ingreso_total;
	}
	public void setIngreso_total(Double ingreso_total) {
		this.ingreso_total = ingreso_total;
	}
	public Long getTrab_id() {
		return trab_id;
	}
	public void setTrab_id(Long trab_id) {
		this.trab_id = trab_id;
	}
	public String getCod_operario() {
		return cod_operario;
	}
	public void setCod_operario(String cod_operario) {
		this.cod_operario = cod_operario;
	}
	public Long getId_implemento() {
		return id_implemento;
	}
	public void setId_implemento(Long id_implemento) {
		this.id_implemento = id_implemento;
	}
	public String getCod_implemento() {
		return cod_implemento;
	}
	public void setCod_implemento(String cod_implemento) {
		this.cod_implemento = cod_implemento;
	}
	public Long getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(Long num_factura) {
		this.num_factura = num_factura;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Long getConcepto_nomina_id() {
		return concepto_nomina_id;
	}
	public void setConcepto_nomina_id(Long concepto_nomina_id) {
		this.concepto_nomina_id = concepto_nomina_id;
	}
	public String getCod_concepto_nomina() {
		return cod_concepto_nomina;
	}
	public void setCod_concepto_nomina(String cod_concepto_nomina) {
		this.cod_concepto_nomina = cod_concepto_nomina;
	}
	public Long getUsuario_digitacion() {
		return usuario_digitacion;
	}
	public void setUsuario_digitacion(Long usuario_digitacion) {
		this.usuario_digitacion = usuario_digitacion;
	}
	public Long getDat_plan_servicios_mqdet_id() {
		return dat_plan_servicios_mqdet_id;
	}
	public void setDat_plan_servicios_mqdet_id(Long dat_plan_servicios_mqdet_id) {
		this.dat_plan_servicios_mqdet_id = dat_plan_servicios_mqdet_id;
	}
	public Double getValor_unitario_trabajador() {
		return valor_unitario_trabajador;
	}
	public void setValor_unitario_trabajador(Double valor_unitario_trabajador) {
		this.valor_unitario_trabajador = valor_unitario_trabajador;
	}
	public Double getValor_total_trabajador() {
		return valor_total_trabajador;
	}
	public void setValor_total_trabajador(Double valor_total_trabajador) {
		this.valor_total_trabajador = valor_total_trabajador;
	}
	public Double getArea_lote() {
		return area_lote;
	}
	public void setArea_lote(Double area_lote) {
		this.area_lote = area_lote;
	}
	public Double getCantidadProgramada() {
		return cantidadProgramada;
	}
	public void setCantidadProgramada(Double cantidadProgramada) {
		this.cantidadProgramada = cantidadProgramada;
	}

	
	
	

}
