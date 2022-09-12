package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class TiquetesBasculaImprimirProdDTO {
	private BigInteger dat_trans_prod_id;
	private BigInteger consecutivo;
	private Long consecutivo_peso_neto;
	private Date fecha_registro;
	private String tipo_transaccion;
	private String equipo;
	private Date fecha_entrada;
	private Date fecha_salida;
	private BigDecimal peso_bruto;
	private BigDecimal peso_tara;
	private BigDecimal peso_neto;
	private String destino_produccion;
	private BigInteger compania;
	private String transportadora;
	private String conductor;
	private String observacion;
	private String estado;
	private String observacion_anular_reg;
	private String vagon1;
	private String vagon2;
	private String vagon3;
	private Date fecha_peso_bruto;
	private Date fecha_tara;
	private Date fecha_peso_neto;
	private String numero_sellos;
	private String bascula_tara;
	private String bascula_peso_bruto;
	private String usuario_peso_tara;
	private String usuario_peso_bruto;
	
	private String campo_acidez;
	private String campo_humedad;
	private String campo_impurezas;
	private String campo_origen;
	private String campo_destino;
	private String campo_proveedor_cliente;
	private String campo_ciudad_cliente;
	private String campo_temperatura;
	private String campo_sellos;
	private String ciudad_cliente;
	
	private String acidez;
	private String humedad;
	private String impurezas;
	private String temperatura;
	private BigDecimal variable5;
	private BigDecimal variable6;
	private BigDecimal variable7;
	private BigDecimal variable8;
	private BigDecimal variable9;
	private BigDecimal variable10;
	private String observacion_analisis;
	private Date fecha_anulacion;
	private String estadoTrue;
	private String lote;
	private String producto;
	private String cod_producto;
	private String placa_equipo;
	
	private String origen;
	private String no_documento;
	private String destino;
	private String observaciones;

	private String nombreCompania;
	private String nitCompania;
	private String telefonoCompania;
	private String direccionCompania;
	private String ciudadCompania;
	private String nom_cliente;
	private String cod_cliente;
	private String usuario_digitacion;

	private Date fechaImpresion;

	private String tipoPesaje;
	
	
	
	/**
	 * @return the tipoPesaje
	 */
	public String getTipoPesaje() {
		return tipoPesaje;
	}

	/**
	 * @param tipoPesaje the tipoPesaje to set
	 */
	public void setTipoPesaje(String tipoPesaje) {
		this.tipoPesaje = tipoPesaje;
	}

	public Date getFechaImpresion() {
		return fechaImpresion;
	}

	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getNitCompania() {
		return nitCompania;
	}

	public void setNitCompania(String nitCompania) {
		this.nitCompania = nitCompania;
	}

	public String getTelefonoCompania() {
		return telefonoCompania;
	}

	public void setTelefonoCompania(String telefonoCompania) {
		this.telefonoCompania = telefonoCompania;
	}

	public String getDireccionCompania() {
		return direccionCompania;
	}

	public void setDireccionCompania(String direccionCompania) {
		this.direccionCompania = direccionCompania;
	}

	public String getCiudadCompania() {
		return ciudadCompania;
	}

	public void setCiudadCompania(String ciudadCompania) {
		this.ciudadCompania = ciudadCompania;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getTipo_transaccion() {
		return tipo_transaccion;
	}

	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public BigDecimal getPeso_bruto() {
		return peso_bruto;
	}

	public void setPeso_bruto(BigDecimal peso_bruto) {
		this.peso_bruto = peso_bruto;
	}

	public BigDecimal getPeso_tara() {
		return peso_tara;
	}

	public void setPeso_tara(BigDecimal peso_tara) {
		this.peso_tara = peso_tara;
	}

	public BigDecimal getPeso_neto() {
		return peso_neto;
	}

	public void setPeso_neto(BigDecimal peso_neto) {
		this.peso_neto = peso_neto;
	}

	public String getDestino_produccion() {
		return destino_produccion;
	}

	public void setDestino_produccion(String destino_produccion) {
		this.destino_produccion = destino_produccion;
	}


	
	/**
	 * @return the dat_trans_prod_id
	 */
	public BigInteger getDat_trans_prod_id() {
		return dat_trans_prod_id;
	}

	/**
	 * @param dat_trans_prod_id the dat_trans_prod_id to set
	 */
	public void setDat_trans_prod_id(BigInteger dat_trans_prod_id) {
		this.dat_trans_prod_id = dat_trans_prod_id;
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
	 * @return the compania
	 */
	public BigInteger getCompania() {
		return compania;
	}

	/**
	 * @param compania the compania to set
	 */
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public String getVagon1() {
		return vagon1;
	}

	public void setVagon1(String vagon1) {
		this.vagon1 = vagon1;
	}

	public String getVagon2() {
		return vagon2;
	}

	public void setVagon2(String vagon2) {
		this.vagon2 = vagon2;
	}

	public String getVagon3() {
		return vagon3;
	}

	public void setVagon3(String vagon3) {
		this.vagon3 = vagon3;
	}

	public Date getFecha_peso_bruto() {
		return fecha_peso_bruto;
	}

	public void setFecha_peso_bruto(Date fecha_peso_bruto) {
		this.fecha_peso_bruto = fecha_peso_bruto;
	}

	public Date getFecha_tara() {
		return fecha_tara;
	}

	public void setFecha_tara(Date fecha_tara) {
		this.fecha_tara = fecha_tara;
	}

	public Date getFecha_peso_neto() {
		return fecha_peso_neto;
	}

	public void setFecha_peso_neto(Date fecha_peso_neto) {
		this.fecha_peso_neto = fecha_peso_neto;
	}

	public String getNumero_sellos() {
		return numero_sellos;
	}

	public void setNumero_sellos(String numero_sellos) {
		this.numero_sellos = numero_sellos;
	}

	public String getBascula_tara() {
		return bascula_tara;
	}

	public void setBascula_tara(String bascula_tara) {
		this.bascula_tara = bascula_tara;
	}

	public String getBascula_peso_bruto() {
		return bascula_peso_bruto;
	}

	public void setBascula_peso_bruto(String bascula_peso_bruto) {
		this.bascula_peso_bruto = bascula_peso_bruto;
	}

	public String getUsuario_peso_tara() {
		return usuario_peso_tara;
	}

	public void setUsuario_peso_tara(String usuario_peso_tara) {
		this.usuario_peso_tara = usuario_peso_tara;
	}

	public String getUsuario_peso_bruto() {
		return usuario_peso_bruto;
	}

	public void setUsuario_peso_bruto(String usuario_peso_bruto) {
		this.usuario_peso_bruto = usuario_peso_bruto;
	}

	public String getAcidez() {
		return acidez;
	}

	public void setAcidez(String acidez) {
		this.acidez = acidez;
	}

	public String getHumedad() {
		return humedad;
	}

	public void setHumedad(String humedad) {
		this.humedad = humedad;
	}

	public String getImpurezas() {
		return impurezas;
	}

	public void setImpurezas(String impurezas) {
		this.impurezas = impurezas;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public BigDecimal getVariable5() {
		return variable5;
	}

	public void setVariable5(BigDecimal variable5) {
		this.variable5 = variable5;
	}

	public BigDecimal getVariable6() {
		return variable6;
	}

	public void setVariable6(BigDecimal variable6) {
		this.variable6 = variable6;
	}

	public BigDecimal getVariable7() {
		return variable7;
	}

	public void setVariable7(BigDecimal variable7) {
		this.variable7 = variable7;
	}

	public BigDecimal getVariable8() {
		return variable8;
	}

	public void setVariable8(BigDecimal variable8) {
		this.variable8 = variable8;
	}

	public BigDecimal getVariable9() {
		return variable9;
	}

	public void setVariable9(BigDecimal variable9) {
		this.variable9 = variable9;
	}

	public BigDecimal getVariable10() {
		return variable10;
	}

	public void setVariable10(BigDecimal variable10) {
		this.variable10 = variable10;
	}

	public String getObservacion_analisis() {
		return observacion_analisis;
	}

	public void setObservacion_analisis(String observacion_analisis) {
		this.observacion_analisis = observacion_analisis;
	}

	public Date getFecha_anulacion() {
		return fecha_anulacion;
	}

	public void setFecha_anulacion(Date fecha_anulacion) {
		this.fecha_anulacion = fecha_anulacion;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getPlaca_equipo() {
		return placa_equipo;
	}

	public void setPlaca_equipo(String placa_equipo) {
		this.placa_equipo = placa_equipo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getNo_documento() {
		return no_documento;
	}

	public void setNo_documento(String no_documento) {
		this.no_documento = no_documento;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getUsuario_digitacion() {
		return usuario_digitacion;
	}

	public void setUsuario_digitacion(String usuario_digitacion) {
		this.usuario_digitacion = usuario_digitacion;
	}

	public String getCampo_acidez() {
		return campo_acidez;
	}

	public void setCampo_acidez(String campo_acidez) {
		this.campo_acidez = campo_acidez;
	}

	public String getCampo_humedad() {
		return campo_humedad;
	}

	public void setCampo_humedad(String campo_humedad) {
		this.campo_humedad = campo_humedad;
	}

	public String getCampo_impurezas() {
		return campo_impurezas;
	}

	public void setCampo_impurezas(String campo_impurezas) {
		this.campo_impurezas = campo_impurezas;
	}

	public String getCampo_origen() {
		return campo_origen;
	}

	public void setCampo_origen(String campo_origen) {
		this.campo_origen = campo_origen;
	}

	public String getCampo_destino() {
		return campo_destino;
	}

	public void setCampo_destino(String campo_destino) {
		this.campo_destino = campo_destino;
	}

	public String getCampo_proveedor_cliente() {
		return campo_proveedor_cliente;
	}

	public void setCampo_proveedor_cliente(String campo_proveedor_cliente) {
		this.campo_proveedor_cliente = campo_proveedor_cliente;
	}

	public String getCampo_ciudad_cliente() {
		return campo_ciudad_cliente;
	}

	public void setCampo_ciudad_cliente(String campo_ciudad_cliente) {
		this.campo_ciudad_cliente = campo_ciudad_cliente;
	}

	public String getCiudad_cliente() {
		return ciudad_cliente;
	}

	public void setCiudad_cliente(String ciudad_cliente) {
		this.ciudad_cliente = ciudad_cliente;
	}

	public String getCampo_temperatura() {
		return campo_temperatura;
	}

	public void setCampo_temperatura(String campo_temperatura) {
		this.campo_temperatura = campo_temperatura;
	}

	public String getCampo_sellos() {
		return campo_sellos;
	}

	public void setCampo_sellos(String campo_sellos) {
		this.campo_sellos = campo_sellos;
	}

	public Long getConsecutivo_peso_neto() {
		return consecutivo_peso_neto;
	}

	public void setConsecutivo_peso_neto(Long consecutivo_peso_neto) {
		this.consecutivo_peso_neto = consecutivo_peso_neto;
	}

}
