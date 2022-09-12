package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaProvisioncesMaqDTO {

	private	BigInteger	dat_proviciones_cierre_nomina_mq_id	;
	private	BigInteger	compania	;
	private	BigDecimal	anio_registro	;
	private	BigDecimal	mes	;
	private	Date	fecha_creacion	;
	private	Date	fecha_inicial	;
	private	Date	fecha_final	;
	private	String	periodo_liquidacion	;
	private	BigInteger	trab_id	;
	private	BigInteger	cepto_nomina_id	;
	private	String	tipo_movimiento	;
	private	BigDecimal	devengos	;
	private	BigDecimal	valor_deduccion	;
	private	String	gasto	;
	private	String	usuario_digitacion	;
	private	BigDecimal	dias_laborados	;
	private	BigDecimal	total_devengo_empleado	;
	private	String	origen_datos	;
	private	String	mes_corto	;
	private	String	cod_operario	;
	private	String	nom_operario	;
	private	String	cod_concepto	;
	private	String	nom_concepto	;
	private	String	nom_compania	;
	private	String	direccion	;
	private	String	telefono	;
	private	String	rut	;
	private BigDecimal costoProvision;
	
	private String fechaRetiro;
	private String fechaAdmision;
	
	
	
	
	
	public String getFechaRetiro() {
		return fechaRetiro;
	}
	public String getFechaAdmision() {
		return fechaAdmision;
	}
	public void setFechaRetiro(String fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}
	public void setFechaAdmision(String fechaAdmision) {
		this.fechaAdmision = fechaAdmision;
	}
	public BigDecimal getCostoProvision() {
		return costoProvision;
	}
	public void setCostoProvision(BigDecimal costoProvision) {
		this.costoProvision = costoProvision;
	}
	public BigInteger getDat_proviciones_cierre_nomina_mq_id() {
		return dat_proviciones_cierre_nomina_mq_id;
	}
	public BigInteger getCompania() {
		return compania;
	}
	public BigDecimal getAnio_registro() {
		return anio_registro;
	}
	public BigDecimal getMes() {
		return mes;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public Date getFecha_inicial() {
		return fecha_inicial;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public String getPeriodo_liquidacion() {
		return periodo_liquidacion;
	}
	public BigInteger getTrab_id() {
		return trab_id;
	}
	public BigInteger getCepto_nomina_id() {
		return cepto_nomina_id;
	}
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}
	public BigDecimal getDevengos() {
		return devengos;
	}
	public BigDecimal getValor_deduccion() {
		return valor_deduccion;
	}
	public String getGasto() {
		return gasto;
	}
	public String getUsuario_digitacion() {
		return usuario_digitacion;
	}
	public BigDecimal getDias_laborados() {
		return dias_laborados;
	}
	public BigDecimal getTotal_devengo_empleado() {
		return total_devengo_empleado;
	}
	public String getOrigen_datos() {
		return origen_datos;
	}
	public String getMes_corto() {
		return mes_corto;
	}
	public String getCod_operario() {
		return cod_operario;
	}
	public String getNom_operario() {
		return nom_operario;
	}
	public String getCod_concepto() {
		return cod_concepto;
	}
	public String getNom_concepto() {
		return nom_concepto;
	}
	public String getNom_compania() {
		return nom_compania;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getRut() {
		return rut;
	}
	public void setDat_proviciones_cierre_nomina_mq_id(BigInteger dat_proviciones_cierre_nomina_mq_id) {
		this.dat_proviciones_cierre_nomina_mq_id = dat_proviciones_cierre_nomina_mq_id;
	}
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}
	public void setAnio_registro(BigDecimal anio_registro) {
		this.anio_registro = anio_registro;
	}
	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public void setFecha_inicial(Date fecha_inicial) {
		this.fecha_inicial = fecha_inicial;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public void setPeriodo_liquidacion(String periodo_liquidacion) {
		this.periodo_liquidacion = periodo_liquidacion;
	}
	public void setTrab_id(BigInteger trab_id) {
		this.trab_id = trab_id;
	}
	public void setCepto_nomina_id(BigInteger cepto_nomina_id) {
		this.cepto_nomina_id = cepto_nomina_id;
	}
	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	public void setDevengos(BigDecimal devengos) {
		this.devengos = devengos;
	}
	public void setValor_deduccion(BigDecimal valor_deduccion) {
		this.valor_deduccion = valor_deduccion;
	}
	public void setGasto(String gasto) {
		this.gasto = gasto;
	}
	public void setUsuario_digitacion(String usuario_digitacion) {
		this.usuario_digitacion = usuario_digitacion;
	}
	public void setDias_laborados(BigDecimal dias_laborados) {
		this.dias_laborados = dias_laborados;
	}
	public void setTotal_devengo_empleado(BigDecimal total_devengo_empleado) {
		this.total_devengo_empleado = total_devengo_empleado;
	}
	public void setOrigen_datos(String origen_datos) {
		this.origen_datos = origen_datos;
	}
	public void setMes_corto(String mes_corto) {
		this.mes_corto = mes_corto;
	}
	public void setCod_operario(String cod_operario) {
		this.cod_operario = cod_operario;
	}
	public void setNom_operario(String nom_operario) {
		this.nom_operario = nom_operario;
	}
	public void setCod_concepto(String cod_concepto) {
		this.cod_concepto = cod_concepto;
	}
	public void setNom_concepto(String nom_concepto) {
		this.nom_concepto = nom_concepto;
	}
	public void setNom_compania(String nom_compania) {
		this.nom_compania = nom_compania;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}

	
	
	
	
}
