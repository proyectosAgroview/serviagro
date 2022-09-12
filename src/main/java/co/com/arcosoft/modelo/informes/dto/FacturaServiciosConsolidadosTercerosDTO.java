package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class FacturaServiciosConsolidadosTercerosDTO {

	private BigInteger dat_factura_servicios_id;
	private BigInteger consecutivo;
	private String num_factura;
	private BigInteger pers_empr_id;
	private String cod_cliente;
	private String nom_cliente;
	private BigInteger compania;
	private Date fecha_registro;
	private BigDecimal anio;
	private BigDecimal mes;
	private String anio_mes;
	private String fecha_vencimiento;
	private String forma_pago;
	private BigInteger plazo;
	private BigDecimal valor_factura;
	private BigDecimal retefuente_4porc;
	private BigDecimal valor_iva;
	private BigDecimal retefuente_1porc;
	private BigDecimal valor_descuento_cenicana;
	private BigDecimal valor_rete_ica;
	private BigDecimal valor_retencion_contrato;
	private BigDecimal valor_descuento;
	private BigDecimal valor_base_iva;
	private BigDecimal valor_descuento_timbre;
	private String detalle_factura;
	private String usuario_digitacion;
	private String fecha_creacion;
	private String estado;
	private String observacion_anular_reg;
	private String fecha_anulacion;
	private String observacion;
	private BigInteger num_prefactura;
	private String fecha_modificacion;
	private String detalle_nota_credito;
	private BigDecimal valor_credito;
	private BigDecimal valor_debito;
	private String forma_pago_nota;
	private String fecha_vencimiento_nota;
	private String vencimiento_cartera;
	private String codLabor;
	private String nomLabor;
	private String codUdadMed;
	private String nomUdadMed;
	private BigDecimal totales;
	private BigDecimal cantidad;
	private BigDecimal valorUnitario;
	private String direccionCliente;
	private String telefonoCliente;
	private String codEquipo;
	private String pin;
	private String hacienda;
	private String suerte;
	private String concepto;

	private String codProveedor;
	private String nomProveedor;
	private BigInteger clienteId;
	private String nomCentroCosto;

	private BigDecimal valorEgresos;

	private String origenDatos;
	private String mesTexto;
	
	private String tipoOperacion;
	private String tipoProducto;
	private String codigoEquipo;
	private String modeloEquipo;
	private String categoriaEquipo;
	private BigDecimal cantidadLabor;
	private BigDecimal horasTrabajadas;
	
	
	

	public String getTipoProducto() {
		return tipoProducto;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public String getModeloEquipo() {
		return modeloEquipo;
	}

	public String getCategoriaEquipo() {
		return categoriaEquipo;
	}

	public BigDecimal getCantidadLabor() {
		return cantidadLabor;
	}

	public BigDecimal getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public void setModeloEquipo(String modeloEquipo) {
		this.modeloEquipo = modeloEquipo;
	}

	public void setCategoriaEquipo(String categoriaEquipo) {
		this.categoriaEquipo = categoriaEquipo;
	}

	public void setCantidadLabor(BigDecimal cantidadLabor) {
		this.cantidadLabor = cantidadLabor;
	}

	public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getMesTexto() {
		return mesTexto;
	}

	public void setMesTexto(String mesTexto) {
		this.mesTexto = mesTexto;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public BigDecimal getValorEgresos() {
		return valorEgresos;
	}

	public void setValorEgresos(BigDecimal valorEgresos) {
		this.valorEgresos = valorEgresos;
	}

	public BigInteger getClienteId() {
		return clienteId;
	}

	public void setClienteId(BigInteger clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomCentroCosto() {
		return nomCentroCosto;
	}

	public void setNomCentroCosto(String nomCentroCosto) {
		this.nomCentroCosto = nomCentroCosto;
	}

	public String getCodProveedor() {
		return codProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getHacienda() {
		return hacienda;
	}

	public void setHacienda(String hacienda) {
		this.hacienda = hacienda;
	}

	public String getSuerte() {
		return suerte;
	}

	public void setSuerte(String suerte) {
		this.suerte = suerte;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getTotales() {
		return totales;
	}

	public void setTotales(BigDecimal totales) {
		this.totales = totales;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getNomLabor() {
		return nomLabor;
	}

	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public String getNomUdadMed() {
		return nomUdadMed;
	}

	public void setNomUdadMed(String nomUdadMed) {
		this.nomUdadMed = nomUdadMed;
	}

	public String getVencimiento_cartera() {
		return vencimiento_cartera;
	}

	public void setVencimiento_cartera(String vencimiento_cartera) {
		this.vencimiento_cartera = vencimiento_cartera;
	}

	public BigInteger getDat_factura_servicios_id() {

		return dat_factura_servicios_id;
	}

	public void setDat_factura_servicios_id(BigInteger dat_factura_servicios_id) {
		this.dat_factura_servicios_id = dat_factura_servicios_id;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}

	public BigInteger getPers_empr_id() {
		return pers_empr_id;
	}

	public void setPers_empr_id(BigInteger pers_empr_id) {
		this.pers_empr_id = pers_empr_id;
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

	public BigInteger getCompania() {
		return compania;
	}

	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
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

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	public BigInteger getPlazo() {
		return plazo;
	}

	public void setPlazo(BigInteger plazo) {
		this.plazo = plazo;
	}

	public BigDecimal getValor_factura() {
		return valor_factura;
	}

	public void setValor_factura(BigDecimal valor_factura) {
		this.valor_factura = valor_factura;
	}

	public BigDecimal getRetefuente_4porc() {
		return retefuente_4porc;
	}

	public void setRetefuente_4porc(BigDecimal retefuente_4porc) {
		this.retefuente_4porc = retefuente_4porc;
	}

	public BigDecimal getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(BigDecimal valor_iva) {
		this.valor_iva = valor_iva;
	}

	public BigDecimal getRetefuente_1porc() {
		return retefuente_1porc;
	}

	public void setRetefuente_1porc(BigDecimal retefuente_1porc) {
		this.retefuente_1porc = retefuente_1porc;
	}

	public BigDecimal getValor_descuento_cenicana() {
		return valor_descuento_cenicana;
	}

	public void setValor_descuento_cenicana(BigDecimal valor_descuento_cenicana) {
		this.valor_descuento_cenicana = valor_descuento_cenicana;
	}

	public BigDecimal getValor_rete_ica() {
		return valor_rete_ica;
	}

	public void setValor_rete_ica(BigDecimal valor_rete_ica) {
		this.valor_rete_ica = valor_rete_ica;
	}

	public BigDecimal getValor_retencion_contrato() {
		return valor_retencion_contrato;
	}

	public void setValor_retencion_contrato(BigDecimal valor_retencion_contrato) {
		this.valor_retencion_contrato = valor_retencion_contrato;
	}

	public BigDecimal getValor_descuento() {
		return valor_descuento;
	}

	public void setValor_descuento(BigDecimal valor_descuento) {
		this.valor_descuento = valor_descuento;
	}

	public BigDecimal getValor_base_iva() {
		return valor_base_iva;
	}

	public void setValor_base_iva(BigDecimal valor_base_iva) {
		this.valor_base_iva = valor_base_iva;
	}

	public BigDecimal getValor_descuento_timbre() {
		return valor_descuento_timbre;
	}

	public void setValor_descuento_timbre(BigDecimal valor_descuento_timbre) {
		this.valor_descuento_timbre = valor_descuento_timbre;
	}

	public String getDetalle_factura() {
		return detalle_factura;
	}

	public void setDetalle_factura(String detalle_factura) {
		this.detalle_factura = detalle_factura;
	}

	public String getUsuario_digitacion() {
		return usuario_digitacion;
	}

	public void setUsuario_digitacion(String usuario_digitacion) {
		this.usuario_digitacion = usuario_digitacion;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion_anular_reg() {
		return observacion_anular_reg;
	}

	public void setObservacion_anular_reg(String observacion_anular_reg) {
		this.observacion_anular_reg = observacion_anular_reg;
	}

	public String getFecha_anulacion() {
		return fecha_anulacion;
	}

	public void setFecha_anulacion(String fecha_anulacion) {
		this.fecha_anulacion = fecha_anulacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigInteger getNum_prefactura() {
		return num_prefactura;
	}

	public void setNum_prefactura(BigInteger num_prefactura) {
		this.num_prefactura = num_prefactura;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getDetalle_nota_credito() {
		return detalle_nota_credito;
	}

	public void setDetalle_nota_credito(String detalle_nota_credito) {
		this.detalle_nota_credito = detalle_nota_credito;
	}

	public BigDecimal getValor_credito() {
		return valor_credito;
	}

	public void setValor_credito(BigDecimal valor_credito) {
		this.valor_credito = valor_credito;
	}

	public BigDecimal getValor_debito() {
		return valor_debito;
	}

	public void setValor_debito(BigDecimal valor_debito) {
		this.valor_debito = valor_debito;
	}

	public String getForma_pago_nota() {
		return forma_pago_nota;
	}

	public void setForma_pago_nota(String forma_pago_nota) {
		this.forma_pago_nota = forma_pago_nota;
	}

	public String getFecha_vencimiento_nota() {
		return fecha_vencimiento_nota;
	}

	public void setFecha_vencimiento_nota(String fecha_vencimiento_nota) {
		this.fecha_vencimiento_nota = fecha_vencimiento_nota;
	}

}
