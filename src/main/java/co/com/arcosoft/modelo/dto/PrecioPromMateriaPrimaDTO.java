package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.util.Date;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class PrecioPromMateriaPrimaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PrecioPromMateriaPrimaDTO.class);
	private Long almacenId;
	private Double cantidadCompra;
	private Long compania;
	private Long conceptoGastoId;
	private Long conceptoKardexId;
	private Long consecutivo;
	private Double costoTotal;
	private Long datCompraMateriaPrimaId;
	private Long datServRealizadosEquipoId;
	private String diferido;
	private Long equipoId;
	private Long etapaId;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Date fechaVencimiento;
	private Double horometroAbastecimiento;
	private String idInsumo;
	private String idMaquinaria;
	private String idalmacen;
	private Long indicadorVueltaMedidor;
	private String infoAdicional;
	private String infoAdicional2;
	private String loteCompraProducto;
	private Long nivel2ClientesmqId;
	private Long nivel4ClientesmqId;
	private Long numFacturaCompra;
	private Long operarioEquipoId;
	private String origenDatos;
	private Double porcIva;
	private Long precioPromMateriaPrimaId;
	private String registroIca;
	private String tipoMovimiento;
	private String transportadoraFactura;
	private String transportadoraNguia;
	private Double transportadoraValorFlete;
	private Long ubicacionAlmacen;
	private Long ubicacionesAlmacenId;
	private Long unidadMedida;
	private Long usuarioDigitacion;
	private Double valorIva;
	private Double valorUnitario;
	private Long variedId;
	private Long datOtrosMovInventarioId_DatOtrosMovInventario;
	private Long nivel2Id_Nivel2;
	private Long nivel4Id_Nivel4;
	private Long persEmprId_PersEmpr;
	private Long productoId_Producto;
	private Long trabId_Trabajador;
	
	private String nomProducto;
	private String nombreUnidadMedida;
	private String codAlmacen;
	private String codPersEmpr;
	private String codProducto;
	private String codConceptoKardex;
	private String nomUbicacionesAlmacen;

	public Long getAlmacenId() {
		return almacenId;
	}

	public void setAlmacenId(Long almacenId) {
		this.almacenId = almacenId;
	}

	public Double getCantidadCompra() {
		return cantidadCompra;
	}

	public void setCantidadCompra(Double cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getConceptoGastoId() {
		return conceptoGastoId;
	}

	public void setConceptoGastoId(Long conceptoGastoId) {
		this.conceptoGastoId = conceptoGastoId;
	}

	public Long getConceptoKardexId() {
		return conceptoKardexId;
	}

	public void setConceptoKardexId(Long conceptoKardexId) {
		this.conceptoKardexId = conceptoKardexId;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDatCompraMateriaPrimaId() {
		return datCompraMateriaPrimaId;
	}

	public void setDatCompraMateriaPrimaId(Long datCompraMateriaPrimaId) {
		this.datCompraMateriaPrimaId = datCompraMateriaPrimaId;
	}

	public Long getDatServRealizadosEquipoId() {
		return datServRealizadosEquipoId;
	}

	public void setDatServRealizadosEquipoId(Long datServRealizadosEquipoId) {
		this.datServRealizadosEquipoId = datServRealizadosEquipoId;
	}

	public String getDiferido() {
		return diferido;
	}

	public void setDiferido(String diferido) {
		this.diferido = diferido;
	}

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Double getHorometroAbastecimiento() {
		return horometroAbastecimiento;
	}

	public void setHorometroAbastecimiento(Double horometroAbastecimiento) {
		this.horometroAbastecimiento = horometroAbastecimiento;
	}

	public String getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getIdMaquinaria() {
		return idMaquinaria;
	}

	public void setIdMaquinaria(String idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}

	public String getIdalmacen() {
		return idalmacen;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public Long getIndicadorVueltaMedidor() {
		return indicadorVueltaMedidor;
	}

	public void setIndicadorVueltaMedidor(Long indicadorVueltaMedidor) {
		this.indicadorVueltaMedidor = indicadorVueltaMedidor;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getLoteCompraProducto() {
		return loteCompraProducto;
	}

	public void setLoteCompraProducto(String loteCompraProducto) {
		this.loteCompraProducto = loteCompraProducto;
	}

	public Long getNivel2ClientesmqId() {
		return nivel2ClientesmqId;
	}

	public void setNivel2ClientesmqId(Long nivel2ClientesmqId) {
		this.nivel2ClientesmqId = nivel2ClientesmqId;
	}

	public Long getNivel4ClientesmqId() {
		return nivel4ClientesmqId;
	}

	public void setNivel4ClientesmqId(Long nivel4ClientesmqId) {
		this.nivel4ClientesmqId = nivel4ClientesmqId;
	}

	public Long getNumFacturaCompra() {
		return numFacturaCompra;
	}

	public void setNumFacturaCompra(Long numFacturaCompra) {
		this.numFacturaCompra = numFacturaCompra;
	}

	public Long getOperarioEquipoId() {
		return operarioEquipoId;
	}

	public void setOperarioEquipoId(Long operarioEquipoId) {
		this.operarioEquipoId = operarioEquipoId;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Double getPorcIva() {
		return porcIva;
	}

	public void setPorcIva(Double porcIva) {
		this.porcIva = porcIva;
	}

	public Long getPrecioPromMateriaPrimaId() {
		return precioPromMateriaPrimaId;
	}

	public void setPrecioPromMateriaPrimaId(Long precioPromMateriaPrimaId) {
		this.precioPromMateriaPrimaId = precioPromMateriaPrimaId;
	}

	public String getRegistroIca() {
		return registroIca;
	}

	public void setRegistroIca(String registroIca) {
		this.registroIca = registroIca;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getTransportadoraFactura() {
		return transportadoraFactura;
	}

	public void setTransportadoraFactura(String transportadoraFactura) {
		this.transportadoraFactura = transportadoraFactura;
	}

	public String getTransportadoraNguia() {
		return transportadoraNguia;
	}

	public void setTransportadoraNguia(String transportadoraNguia) {
		this.transportadoraNguia = transportadoraNguia;
	}

	public Double getTransportadoraValorFlete() {
		return transportadoraValorFlete;
	}

	public void setTransportadoraValorFlete(Double transportadoraValorFlete) {
		this.transportadoraValorFlete = transportadoraValorFlete;
	}

	public Long getUbicacionAlmacen() {
		return ubicacionAlmacen;
	}

	public void setUbicacionAlmacen(Long ubicacionAlmacen) {
		this.ubicacionAlmacen = ubicacionAlmacen;
	}

	public Long getUbicacionesAlmacenId() {
		return ubicacionesAlmacenId;
	}

	public void setUbicacionesAlmacenId(Long ubicacionesAlmacenId) {
		this.ubicacionesAlmacenId = ubicacionesAlmacenId;
	}

	public Long getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(Long unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}

	public Long getDatOtrosMovInventarioId_DatOtrosMovInventario() {
		return datOtrosMovInventarioId_DatOtrosMovInventario;
	}

	public void setDatOtrosMovInventarioId_DatOtrosMovInventario(Long datOtrosMovInventarioId_DatOtrosMovInventario) {
		this.datOtrosMovInventarioId_DatOtrosMovInventario = datOtrosMovInventarioId_DatOtrosMovInventario;
	}

	public Long getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public void setNivel2Id_Nivel2(Long nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public Long getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Long productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getCodPersEmpr() {
		return codPersEmpr;
	}

	public void setCodPersEmpr(String codPersEmpr) {
		this.codPersEmpr = codPersEmpr;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getCodConceptoKardex() {
		return codConceptoKardex;
	}

	public void setCodConceptoKardex(String codConceptoKardex) {
		this.codConceptoKardex = codConceptoKardex;
	}

	public String getNomUbicacionesAlmacen() {
		return nomUbicacionesAlmacen;
	}

	public void setNomUbicacionesAlmacen(String nomUbicacionesAlmacen) {
		this.nomUbicacionesAlmacen = nomUbicacionesAlmacen;
	}
}
