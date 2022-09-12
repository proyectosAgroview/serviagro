package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class TiquetesBasculaProduccionInformeDTO {
	private BigInteger dat_trans_prod_id;
	private BigInteger consecutivo;
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
	private BigDecimal acidez;
	private BigDecimal humedad;
	private BigDecimal impurezas;
	private BigDecimal variable4;
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
	private String nombreCompania;
	private String nitCompania;
	private String telefonoCompania;
	private String direccionCompania;
	private String ciudadCompania;
	private String zona;
	private String finca;
	private String bloque;
	private String variedad;
	private BigDecimal pesoPromedio;
	private BigDecimal produccionLote;
	private BigDecimal areaCosechada;
	private BigDecimal mes;
	private String mesCorto;
	private BigDecimal anio;
	private String proveedor;
	private BigDecimal costoTotal;

	private	String	tenencia	;
	private	String	categ_equipo	;
	private	String	reg_despacho	;
	private	String	estado_almacenado	;
	private	 BigDecimal	tiempo_espera_hr	;
	private	 BigDecimal	tiempo_descargue_hr	;
	private	 BigDecimal	tiempo_total_hr	;
	private	BigInteger	num_consecutivo_analisis	;
	private	 BigDecimal	descuento_impurezas	;
	private	 BigDecimal	descuento_rac_podrido	;
	private	 BigDecimal	racimos_maduros	;
	private	 BigDecimal	racimos_verdes	;
	private	 BigDecimal	racimos_sobremaduros	;
	private	 BigDecimal	racimos_podridos	;
	private	 BigDecimal	racimos_pend_largo	;
	private	 BigDecimal	racimos_mal_formados	;
	private	 BigDecimal	rango_impurezas	;
	private	 BigDecimal	ra_demotispa	;
	private	 BigDecimal	porc_racimos	;
	private String usuarioAnalisis;
	
	private Date fechaCorta;
	private  String sucursal;
	private BigDecimal valorUnitario;
	private String codUm;
	private String plano;
	private String vendedor;
	private String iva;
	
	private BigInteger consecutivo_peso_neto;
	private Date fecha_vehiculo_porteria;
	
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public Date getFechaCorta() {
		return fechaCorta;
	}

	public void setFechaCorta(Date fechaCorta) {
		this.fechaCorta = fechaCorta;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getCodUm() {
		return codUm;
	}

	public void setCodUm(String codUm) {
		this.codUm = codUm;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getUsuarioAnalisis() {
		return usuarioAnalisis;
	}

	public void setUsuarioAnalisis(String usuarioAnalisis) {
		this.usuarioAnalisis = usuarioAnalisis;
	}

	public String getTenencia() {
		return tenencia;
	}

	public void setTenencia(String tenencia) {
		this.tenencia = tenencia;
	}

	public String getCateg_equipo() {
		return categ_equipo;
	}

	public void setCateg_equipo(String categ_equipo) {
		this.categ_equipo = categ_equipo;
	}

	public String getReg_despacho() {
		return reg_despacho;
	}

	public void setReg_despacho(String reg_despacho) {
		this.reg_despacho = reg_despacho;
	}

	public String getEstado_almacenado() {
		return estado_almacenado;
	}

	public void setEstado_almacenado(String estado_almacenado) {
		this.estado_almacenado = estado_almacenado;
	}

	public BigDecimal getTiempo_espera_hr() {
		return tiempo_espera_hr;
	}

	public void setTiempo_espera_hr(BigDecimal tiempo_espera_hr) {
		this.tiempo_espera_hr = tiempo_espera_hr;
	}

	public BigDecimal getTiempo_descargue_hr() {
		return tiempo_descargue_hr;
	}

	public void setTiempo_descargue_hr(BigDecimal tiempo_descargue_hr) {
		this.tiempo_descargue_hr = tiempo_descargue_hr;
	}

	public BigDecimal getTiempo_total_hr() {
		return tiempo_total_hr;
	}

	public void setTiempo_total_hr(BigDecimal tiempo_total_hr) {
		this.tiempo_total_hr = tiempo_total_hr;
	}

	public BigInteger getNum_consecutivo_analisis() {
		return num_consecutivo_analisis;
	}

	public void setNum_consecutivo_analisis(BigInteger num_consecutivo_analisis) {
		this.num_consecutivo_analisis = num_consecutivo_analisis;
	}

	public BigDecimal getDescuento_impurezas() {
		return descuento_impurezas;
	}

	public void setDescuento_impurezas(BigDecimal descuento_impurezas) {
		this.descuento_impurezas = descuento_impurezas;
	}

	public BigDecimal getDescuento_rac_podrido() {
		return descuento_rac_podrido;
	}

	public void setDescuento_rac_podrido(BigDecimal descuento_rac_podrido) {
		this.descuento_rac_podrido = descuento_rac_podrido;
	}

	public BigDecimal getRacimos_maduros() {
		return racimos_maduros;
	}

	public void setRacimos_maduros(BigDecimal racimos_maduros) {
		this.racimos_maduros = racimos_maduros;
	}

	public BigDecimal getRacimos_verdes() {
		return racimos_verdes;
	}

	public void setRacimos_verdes(BigDecimal racimos_verdes) {
		this.racimos_verdes = racimos_verdes;
	}

	public BigDecimal getRacimos_sobremaduros() {
		return racimos_sobremaduros;
	}

	public void setRacimos_sobremaduros(BigDecimal racimos_sobremaduros) {
		this.racimos_sobremaduros = racimos_sobremaduros;
	}

	public BigDecimal getRacimos_podridos() {
		return racimos_podridos;
	}

	public void setRacimos_podridos(BigDecimal racimos_podridos) {
		this.racimos_podridos = racimos_podridos;
	}

	public BigDecimal getRacimos_pend_largo() {
		return racimos_pend_largo;
	}

	public void setRacimos_pend_largo(BigDecimal racimos_pend_largo) {
		this.racimos_pend_largo = racimos_pend_largo;
	}

	public BigDecimal getRacimos_mal_formados() {
		return racimos_mal_formados;
	}

	public void setRacimos_mal_formados(BigDecimal racimos_mal_formados) {
		this.racimos_mal_formados = racimos_mal_formados;
	}

	public BigDecimal getRango_impurezas() {
		return rango_impurezas;
	}

	public void setRango_impurezas(BigDecimal rango_impurezas) {
		this.rango_impurezas = rango_impurezas;
	}

	public BigDecimal getRa_demotispa() {
		return ra_demotispa;
	}

	public void setRa_demotispa(BigDecimal ra_demotispa) {
		this.ra_demotispa = ra_demotispa;
	}

	public BigDecimal getPorc_racimos() {
		return porc_racimos;
	}

	public void setPorc_racimos(BigDecimal porc_racimos) {
		this.porc_racimos = porc_racimos;
	}

	/**
	 * @return the proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the costoTotal
	 */
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	/**
	 * @param costoTotal the costoTotal to set
	 */
	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public BigDecimal getAreaCosechada() {
		return areaCosechada;
	}

	public void setAreaCosechada(BigDecimal areaCosechada) {
		this.areaCosechada = areaCosechada;
	}

	public String getMesCorto() {
		return mesCorto;
	}

	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}


	private String fechaImpresion;

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getFinca() {
		return finca;
	}

	public void setFinca(String finca) {
		this.finca = finca;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public BigDecimal getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(BigDecimal pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public BigDecimal getProduccionLote() {
		return produccionLote;
	}

	public void setProduccionLote(BigDecimal produccionLote) {
		this.produccionLote = produccionLote;
	}

	public String getFechaImpresion() {
		return fechaImpresion;
	}

	public void setFechaImpresion(String fechaImpresion) {
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
	 * @return the mes
	 */
	public BigDecimal getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	/**
	 * @return the anio
	 */
	public BigDecimal getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(BigDecimal anio) {
		this.anio = anio;
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

	public BigInteger getCompania() {
		return compania;
	}

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

	public BigDecimal getAcidez() {
		return acidez;
	}

	public void setAcidez(BigDecimal acidez) {
		this.acidez = acidez;
	}

	public BigDecimal getHumedad() {
		return humedad;
	}

	public void setHumedad(BigDecimal humedad) {
		this.humedad = humedad;
	}

	public BigDecimal getImpurezas() {
		return impurezas;
	}

	public void setImpurezas(BigDecimal impurezas) {
		this.impurezas = impurezas;
	}

	public BigDecimal getVariable4() {
		return variable4;
	}

	public void setVariable4(BigDecimal variable4) {
		this.variable4 = variable4;
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

	/**
	 * @return the fecha_registro
	 */
	public Date getFecha_registro() {
		return fecha_registro;
	}

	/**
	 * @param fecha_registro the fecha_registro to set
	 */
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	/**
	 * @return the fecha_entrada
	 */
	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	/**
	 * @param fecha_entrada the fecha_entrada to set
	 */
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	/**
	 * @return the fecha_salida
	 */
	public Date getFecha_salida() {
		return fecha_salida;
	}

	/**
	 * @param fecha_salida the fecha_salida to set
	 */
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	/**
	 * @return the fecha_peso_bruto
	 */
	public Date getFecha_peso_bruto() {
		return fecha_peso_bruto;
	}

	/**
	 * @param fecha_peso_bruto the fecha_peso_bruto to set
	 */
	public void setFecha_peso_bruto(Date fecha_peso_bruto) {
		this.fecha_peso_bruto = fecha_peso_bruto;
	}

	/**
	 * @return the fecha_tara
	 */
	public Date getFecha_tara() {
		return fecha_tara;
	}

	/**
	 * @param fecha_tara the fecha_tara to set
	 */
	public void setFecha_tara(Date fecha_tara) {
		this.fecha_tara = fecha_tara;
	}

	/**
	 * @return the fecha_peso_neto
	 */
	public Date getFecha_peso_neto() {
		return fecha_peso_neto;
	}

	/**
	 * @param fecha_peso_neto the fecha_peso_neto to set
	 */
	public void setFecha_peso_neto(Date fecha_peso_neto) {
		this.fecha_peso_neto = fecha_peso_neto;
	}

	/**
	 * @return the fecha_anulacion
	 */
	public Date getFecha_anulacion() {
		return fecha_anulacion;
	}

	/**
	 * @param fecha_anulacion the fecha_anulacion to set
	 */
	public void setFecha_anulacion(Date fecha_anulacion) {
		this.fecha_anulacion = fecha_anulacion;
	}

	public BigInteger getConsecutivo_peso_neto() {
		return consecutivo_peso_neto;
	}

	public void setConsecutivo_peso_neto(BigInteger consecutivo_peso_neto) {
		this.consecutivo_peso_neto = consecutivo_peso_neto;
	}

	public Date getFecha_vehiculo_porteria() {
		return fecha_vehiculo_porteria;
	}

	public void setFecha_vehiculo_porteria(Date fecha_vehiculo_porteria) {
		this.fecha_vehiculo_porteria = fecha_vehiculo_porteria;
	}

	
}
