package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ReporteMttoFatllasEquipoDTO {

	private	Date	fecha_entrada_taller	;
	private	Date	fecha_salida_taller	;
	private	BigInteger	consecutivo	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	centro_costo	;
	private	String	taller	;
	private	BigDecimal	horometro_entrada	;
	private	BigDecimal	odomentro_entrada	;
	private	String	tipo_mantenimiento	;
	private	String	plan_revision	;
	private	String	motivo_entrda_taller	;
	private	String	agente_causador	;
	private	String	duracion_prevista_mtto_hh	;
	private	BigDecimal	duracion_real_hh	;
	private	String	cod_solicitante	;
	private	String	solicitante	;
	private	String	cod_conductor	;
	private	String	conductor	;
	private	String	reporte_tecnico	;
	private	String	fecha_trabajo_mec	;
	private	String	mecanicos	;
	private	String	concepto_nomina	;
	private	String	unidad_medida	;
	private	BigDecimal	cantidad_mec	;
	private	BigDecimal	tarifa_mec	;
	private	BigDecimal	costo_total_mec	;
	private	String	almacen_salida	;
	private	String	autoriza	;
	private	String	producto	;
	private	String	um_producto	;
	private	BigDecimal	cantidad	;
	private	BigDecimal	valor_unitario	;
	private	BigDecimal	costo_total	;
	private	BigInteger	dat_mantenimiento_equipo_id	;
	private 	String	codTag	;
	private	String 	nombreTag	;
	private String tarea;
	private BigInteger anio;
	private String mesCorto;
	
	
	
	
	public BigInteger getAnio() {
		return anio;
	}
	public void setAnio(BigInteger anio) {
		this.anio = anio;
	}
	public String getMesCorto() {
		return mesCorto;
	}
	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public Date getFecha_entrada_taller() {
		return fecha_entrada_taller;
	}
	public void setFecha_entrada_taller(Date fecha_entrada_taller) {
		this.fecha_entrada_taller = fecha_entrada_taller;
	}
	public Date getFecha_salida_taller() {
		return fecha_salida_taller;
	}
	public void setFecha_salida_taller(Date fecha_salida_taller) {
		this.fecha_salida_taller = fecha_salida_taller;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
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
	public String getCentro_costo() {
		return centro_costo;
	}
	public void setCentro_costo(String centro_costo) {
		this.centro_costo = centro_costo;
	}
	public String getTaller() {
		return taller;
	}
	public void setTaller(String taller) {
		this.taller = taller;
	}
	public BigDecimal getHorometro_entrada() {
		return horometro_entrada;
	}
	public void setHorometro_entrada(BigDecimal horometro_entrada) {
		this.horometro_entrada = horometro_entrada;
	}
	public BigDecimal getOdomentro_entrada() {
		return odomentro_entrada;
	}
	public void setOdomentro_entrada(BigDecimal odomentro_entrada) {
		this.odomentro_entrada = odomentro_entrada;
	}
	public String getTipo_mantenimiento() {
		return tipo_mantenimiento;
	}
	public void setTipo_mantenimiento(String tipo_mantenimiento) {
		this.tipo_mantenimiento = tipo_mantenimiento;
	}
	public String getPlan_revision() {
		return plan_revision;
	}
	public void setPlan_revision(String plan_revision) {
		this.plan_revision = plan_revision;
	}
	public String getMotivo_entrda_taller() {
		return motivo_entrda_taller;
	}
	public void setMotivo_entrda_taller(String motivo_entrda_taller) {
		this.motivo_entrda_taller = motivo_entrda_taller;
	}
	public String getAgente_causador() {
		return agente_causador;
	}
	public void setAgente_causador(String agente_causador) {
		this.agente_causador = agente_causador;
	}
	public String getDuracion_prevista_mtto_hh() {
		return duracion_prevista_mtto_hh;
	}
	public void setDuracion_prevista_mtto_hh(String duracion_prevista_mtto_hh) {
		this.duracion_prevista_mtto_hh = duracion_prevista_mtto_hh;
	}
	public BigDecimal getDuracion_real_hh() {
		return duracion_real_hh;
	}
	public void setDuracion_real_hh(BigDecimal duracion_real_hh) {
		this.duracion_real_hh = duracion_real_hh;
	}
	public String getCod_solicitante() {
		return cod_solicitante;
	}
	public void setCod_solicitante(String cod_solicitante) {
		this.cod_solicitante = cod_solicitante;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getCod_conductor() {
		return cod_conductor;
	}
	public void setCod_conductor(String cod_conductor) {
		this.cod_conductor = cod_conductor;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	public String getReporte_tecnico() {
		return reporte_tecnico;
	}
	public void setReporte_tecnico(String reporte_tecnico) {
		this.reporte_tecnico = reporte_tecnico;
	}
	public String getFecha_trabajo_mec() {
		return fecha_trabajo_mec;
	}
	public void setFecha_trabajo_mec(String fecha_trabajo_mec) {
		this.fecha_trabajo_mec = fecha_trabajo_mec;
	}
	public String getMecanicos() {
		return mecanicos;
	}
	public void setMecanicos(String mecanicos) {
		this.mecanicos = mecanicos;
	}
	public String getConcepto_nomina() {
		return concepto_nomina;
	}
	public void setConcepto_nomina(String concepto_nomina) {
		this.concepto_nomina = concepto_nomina;
	}
	public String getUnidad_medida() {
		return unidad_medida;
	}
	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}
	public BigDecimal getCantidad_mec() {
		return cantidad_mec;
	}
	public void setCantidad_mec(BigDecimal cantidad_mec) {
		this.cantidad_mec = cantidad_mec;
	}
	public BigDecimal getTarifa_mec() {
		return tarifa_mec;
	}
	public void setTarifa_mec(BigDecimal tarifa_mec) {
		this.tarifa_mec = tarifa_mec;
	}
	public BigDecimal getCosto_total_mec() {
		return costo_total_mec;
	}
	public void setCosto_total_mec(BigDecimal costo_total_mec) {
		this.costo_total_mec = costo_total_mec;
	}
	public String getAlmacen_salida() {
		return almacen_salida;
	}
	public void setAlmacen_salida(String almacen_salida) {
		this.almacen_salida = almacen_salida;
	}
	public String getAutoriza() {
		return autoriza;
	}
	public void setAutoriza(String autoriza) {
		this.autoriza = autoriza;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getUm_producto() {
		return um_producto;
	}
	public void setUm_producto(String um_producto) {
		this.um_producto = um_producto;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public BigDecimal getCosto_total() {
		return costo_total;
	}
	public void setCosto_total(BigDecimal costo_total) {
		this.costo_total = costo_total;
	}
	public BigInteger getDat_mantenimiento_equipo_id() {
		return dat_mantenimiento_equipo_id;
	}
	public void setDat_mantenimiento_equipo_id(BigInteger dat_mantenimiento_equipo_id) {
		this.dat_mantenimiento_equipo_id = dat_mantenimiento_equipo_id;
	}
	public String getCodTag() {
		return codTag;
	}
	public void setCodTag(String codTag) {
		this.codTag = codTag;
	}
	public String getNombreTag() {
		return nombreTag;
	}
	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

	

}
