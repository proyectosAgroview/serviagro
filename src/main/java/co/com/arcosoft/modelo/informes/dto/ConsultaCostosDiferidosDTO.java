package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaCostosDiferidosDTO {
	private BigInteger consecutivo;
	private Date fecha_registro;
	private BigInteger num_factura;
	private BigDecimal anio;
	private BigDecimal mes;
	private String anio_mes;
	private BigDecimal valor_inicial;
	private BigDecimal valor_cuota;
	private BigDecimal valor_saldo;
	private BigInteger periodos;
	private BigInteger np_reset;
	private String detalle_nota;
	private BigDecimal anio_aplicacion;
	private BigDecimal mes_aplicacion;
	private String detalle_aplicacion;
	private String estado;
	private String observacion;
	private String cod_equipo;
	private String nom_equipo;
	private BigInteger datDiferidosId;
	private BigInteger datDiferidosAgricolaId;
	private String numeroFactura;
	private Date fecha_diferido;
	private String codGasto;
	private String nomGasto;
	private String codProveedor;
	private String nomProveedor;
	

	public String getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getCodGasto() {
		return codGasto;
	}

	public void setCodGasto(String codGasto) {
		this.codGasto = codGasto;
	}

	public String getNomGasto() {
		return nomGasto;
	}

	public void setNomGasto(String nomGasto) {
		this.nomGasto = nomGasto;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFecha_diferido() {
		return fecha_diferido;
	}

	public void setFecha_diferido(Date fecha_diferido) {
		this.fecha_diferido = fecha_diferido;
	}

	public BigInteger getDatDiferidosId() {
		return datDiferidosId;
	}

	public void setDatDiferidosId(BigInteger datDiferidosId) {
		this.datDiferidosId = datDiferidosId;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public BigInteger getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(BigInteger num_factura) {
		this.num_factura = num_factura;
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

	public String getAnio_mes() {
		return anio_mes;
	}

	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}

	public BigDecimal getValor_inicial() {
		return valor_inicial;
	}

	public void setValor_inicial(BigDecimal valor_inicial) {
		this.valor_inicial = valor_inicial;
	}

	public BigDecimal getValor_cuota() {
		return valor_cuota;
	}

	public void setValor_cuota(BigDecimal valor_cuota) {
		this.valor_cuota = valor_cuota;
	}

	public BigDecimal getValor_saldo() {
		return valor_saldo;
	}

	public void setValor_saldo(BigDecimal valor_saldo) {
		this.valor_saldo = valor_saldo;
	}

	public BigInteger getPeriodos() {
		return periodos;
	}

	public void setPeriodos(BigInteger periodos) {
		this.periodos = periodos;
	}

	public BigInteger getNp_reset() {
		return np_reset;
	}

	public void setNp_reset(BigInteger np_reset) {
		this.np_reset = np_reset;
	}

	public String getDetalle_nota() {
		return detalle_nota;
	}

	public void setDetalle_nota(String detalle_nota) {
		this.detalle_nota = detalle_nota;
	}

	public BigDecimal getAnio_aplicacion() {
		return anio_aplicacion;
	}

	public void setAnio_aplicacion(BigDecimal anio_aplicacion) {
		this.anio_aplicacion = anio_aplicacion;
	}

	public BigDecimal getMes_aplicacion() {
		return mes_aplicacion;
	}

	public void setMes_aplicacion(BigDecimal mes_aplicacion) {
		this.mes_aplicacion = mes_aplicacion;
	}

	public String getDetalle_aplicacion() {
		return detalle_aplicacion;
	}

	public void setDetalle_aplicacion(String detalle_aplicacion) {
		this.detalle_aplicacion = detalle_aplicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public BigInteger getDatDiferidosAgricolaId() {
		return datDiferidosAgricolaId;
	}

	public void setDatDiferidosAgricolaId(BigInteger datDiferidosAgricolaId) {
		this.datDiferidosAgricolaId = datDiferidosAgricolaId;
	}

}
