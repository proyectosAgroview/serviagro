package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaOtrosMovimientosInventarioDTO {
	private BigInteger precioProdid;
	private BigInteger documentoKardex;
	private	Date	fecha_registro	;
	private	BigInteger	consecutivo	;
	private	BigInteger	num_factura	;
	private	BigDecimal	anio	;
	private	BigDecimal	mes	;
	private	String	anio_mes	;
	private	String	cod_proveedor	;
	private	String	nom_proveedor	;
	private	BigDecimal	valor_factura	;
	private	BigDecimal	valor_iva	;
	private	BigDecimal	valor_descuento	;
	private	String	detalle_nota	;
	private	String	tipo_moneda	;
	private	BigDecimal	tasa_conversion_trm	;
	private	String	estado	;
	private	String	cod_producto	;
	private	String	nom_producto	;
	private	BigDecimal	valor_unitario	;
	private	BigDecimal	cantidad_compra	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	cod_udad_med	;
	private	String	nom_udad_med	;
	private	String	cod_almacen	;
	private	String	nom_almacen	;
	private	String	cod_concepto_kardex	;
	private	String	nom_concepto_kardex	;
	private	String	tipo_movimiento	;
	private String cod_trabajador;
	private String nom_trabajador;
	private BigDecimal costoTotal;
	private String tipoDoc;
	private String codSucursal;
	private BigInteger dat_otros_mov_inventario_id;
	
	
	
	
	
	public BigInteger getDat_otros_mov_inventario_id() {
		return dat_otros_mov_inventario_id;
	}
	public void setDat_otros_mov_inventario_id(BigInteger dat_otros_mov_inventario_id) {
		this.dat_otros_mov_inventario_id = dat_otros_mov_inventario_id;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getCodSucursal() {
		return codSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}
	public BigInteger getDocumentoKardex() {
		return documentoKardex;
	}
	public void setDocumentoKardex(BigInteger documentoKardex) {
		this.documentoKardex = documentoKardex;
	}
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}
	public BigInteger getPrecioProdid() {
		return precioProdid;
	}
	public void setPrecioProdid(BigInteger precioProdid) {
		this.precioProdid = precioProdid;
	}
	public String getCod_trabajador() {
		return cod_trabajador;
	}
	public void setCod_trabajador(String cod_trabajador) {
		this.cod_trabajador = cod_trabajador;
	}
	public String getNom_trabajador() {
		return nom_trabajador;
	}
	public void setNom_trabajador(String nom_trabajador) {
		this.nom_trabajador = nom_trabajador;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
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
	public String getCod_proveedor() {
		return cod_proveedor;
	}
	public void setCod_proveedor(String cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}
	public String getNom_proveedor() {
		return nom_proveedor;
	}
	public void setNom_proveedor(String nom_proveedor) {
		this.nom_proveedor = nom_proveedor;
	}
	public BigDecimal getValor_factura() {
		return valor_factura;
	}
	public void setValor_factura(BigDecimal valor_factura) {
		this.valor_factura = valor_factura;
	}
	public BigDecimal getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(BigDecimal valor_iva) {
		this.valor_iva = valor_iva;
	}
	public BigDecimal getValor_descuento() {
		return valor_descuento;
	}
	public void setValor_descuento(BigDecimal valor_descuento) {
		this.valor_descuento = valor_descuento;
	}
	public String getDetalle_nota() {
		return detalle_nota;
	}
	public void setDetalle_nota(String detalle_nota) {
		this.detalle_nota = detalle_nota;
	}
	public String getTipo_moneda() {
		return tipo_moneda;
	}
	public void setTipo_moneda(String tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}
	public BigDecimal getTasa_conversion_trm() {
		return tasa_conversion_trm;
	}
	public void setTasa_conversion_trm(BigDecimal tasa_conversion_trm) {
		this.tasa_conversion_trm = tasa_conversion_trm;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}
	public String getNom_producto() {
		return nom_producto;
	}
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	public BigDecimal getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public BigDecimal getCantidad_compra() {
		return cantidad_compra;
	}
	public void setCantidad_compra(BigDecimal cantidad_compra) {
		this.cantidad_compra = cantidad_compra;
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
	public String getCod_almacen() {
		return cod_almacen;
	}
	public void setCod_almacen(String cod_almacen) {
		this.cod_almacen = cod_almacen;
	}
	public String getNom_almacen() {
		return nom_almacen;
	}
	public void setNom_almacen(String nom_almacen) {
		this.nom_almacen = nom_almacen;
	}
	public String getCod_concepto_kardex() {
		return cod_concepto_kardex;
	}
	public void setCod_concepto_kardex(String cod_concepto_kardex) {
		this.cod_concepto_kardex = cod_concepto_kardex;
	}
	public String getNom_concepto_kardex() {
		return nom_concepto_kardex;
	}
	public void setNom_concepto_kardex(String nom_concepto_kardex) {
		this.nom_concepto_kardex = nom_concepto_kardex;
	}
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}
	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

		
	
}
