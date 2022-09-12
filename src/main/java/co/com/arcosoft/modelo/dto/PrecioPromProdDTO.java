package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class PrecioPromProdDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PrecioPromProdDTO.class);
	private Almacen almacenId;
	private Double cantidadCompra;
	private Long compania;
	private ConceptoKardex conceptoKardexId;
	private Long consecutivo;
	private Double costoTotal;
	private Equipo equipoId;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Date fechaVencimiento;
	private String infoAdicional;
	private String infoAdicional2;
	private String loteCompraProducto;
	private Long numFacturaCompra;
	private Long precioProdId;
	private String registroIca;
	private String tipoMovimiento;
	private UdadMed unidadMedida;
	private Double valorUnitario;
	private PersEmpr persEmprId_PersEmpr;
	private Producto producto;
	private String codPersEmpr;
	private String codAlmacen;
	private String nombreUnidadMedida;
	private Double porcIva;
	private Double valorIva;
	private Trabajador trabajador;
	private Long datCompraProductosId;
	private Long datOtrosMovInventarioId;
	private String codProducto;
	private String codEquipo;
	private String codTrabajador;
	private String codConceptoKardex;
	private String nomTipoProducto;
	private String nomProducto;
	private DatServRealizadosEquipo datServRealizadosEquipoId;
	private Long conceptoGastoId;
	private String diferido;

	private String transportadoraFactura;
	private String transportadora_nguia;
	private Double transportadora_valor_flete;

	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;
	private String codNivel2;
	private String codNivel4;
	private String origenDatos;
	private Long etapaId;
	private Long variedId;

	private Trabajador operario_equipo_id;
	private String nomOperarioEquipo;

	private Nivel2Clientesmq nivel2_clientesmq_id;
	private Long nivel4_clientesmq_id;

	private Double horometro_abastecimiento;

	private Long usuarioDigitacion;
	private Long indicador_vuelta_medidor;

	private UbicacionesAlmacen ubicacionesAlmacen;
	private String nomUbicacionesAlmacen;
	private Long ubicacionId;
	private Long implementoId;
	private String codImplemento;
	private Long datMantenimientoEquipoId;
	private Long centCostId;
	private String nombreCentCost;

	private String referenciaFacCompra;
	private Long implementoId2;

	private Double descuentoProducto;

	public Double getDescuentoProducto() {
		return descuentoProducto;
	}

	public void setDescuentoProducto(Double descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}

	public Long getImplementoId2() {
		return implementoId2;
	}

	public void setImplementoId2(Long implementoId2) {
		this.implementoId2 = implementoId2;
	}

	public String getReferenciaFacCompra() {
		return referenciaFacCompra;
	}

	public void setReferenciaFacCompra(String referenciaFacCompra) {
		this.referenciaFacCompra = referenciaFacCompra;
	}

	public String getNombreCentCost() {
		return nombreCentCost;
	}

	public void setNombreCentCost(String nombreCentCost) {
		this.nombreCentCost = nombreCentCost;
	}

	public Long getCentCostId() {
		return centCostId;
	}

	public void setCentCostId(Long centCostId) {
		this.centCostId = centCostId;
	}

	public Long getDatMantenimientoEquipoId() {
		return datMantenimientoEquipoId;
	}

	public void setDatMantenimientoEquipoId(Long datMantenimientoEquipoId) {
		this.datMantenimientoEquipoId = datMantenimientoEquipoId;
	}

	public Long getImplementoId() {
		return implementoId;
	}

	public void setImplementoId(Long implementoId) {
		this.implementoId = implementoId;
	}

	public String getCodImplemento() {
		return codImplemento;
	}

	public void setCodImplemento(String codImplemento) {
		this.codImplemento = codImplemento;
	}

	public Long getUbicacionId() {
		return ubicacionId;
	}

	public void setUbicacionId(Long ubicacionId) {
		this.ubicacionId = ubicacionId;
	}

	public Long getIndicador_vuelta_medidor() {
		return indicador_vuelta_medidor;
	}

	public void setIndicador_vuelta_medidor(Long indicador_vuelta_medidor) {
		this.indicador_vuelta_medidor = indicador_vuelta_medidor;
	}

	public String getNomOperarioEquipo() {
		return nomOperarioEquipo;
	}

	public void setNomOperarioEquipo(String nomOperarioEquipo) {
		this.nomOperarioEquipo = nomOperarioEquipo;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getHorometro_abastecimiento() {
		return horometro_abastecimiento;
	}

	public void setHorometro_abastecimiento(Double horometro_abastecimiento) {
		this.horometro_abastecimiento = horometro_abastecimiento;
	}

	public Trabajador getOperario_equipo_id() {
		return operario_equipo_id;
	}

	public void setOperario_equipo_id(Trabajador operario_equipo_id) {
		this.operario_equipo_id = operario_equipo_id;
	}

	public Nivel2Clientesmq getNivel2_clientesmq_id() {
		return nivel2_clientesmq_id;
	}

	public void setNivel2_clientesmq_id(Nivel2Clientesmq nivel2_clientesmq_id) {
		this.nivel2_clientesmq_id = nivel2_clientesmq_id;
	}

	public Long getNivel4_clientesmq_id() {
		return nivel4_clientesmq_id;
	}

	public void setNivel4_clientesmq_id(Long nivel4_clientesmq_id) {
		this.nivel4_clientesmq_id = nivel4_clientesmq_id;
	}

	public String getTransportadoraFactura() {
		return transportadoraFactura;
	}

	public void setTransportadoraFactura(String transportadoraFactura) {
		this.transportadoraFactura = transportadoraFactura;
	}

	public String getTransportadora_nguia() {
		return transportadora_nguia;
	}

	public void setTransportadora_nguia(String transportadora_nguia) {
		this.transportadora_nguia = transportadora_nguia;
	}

	public Double getTransportadora_valor_flete() {
		return transportadora_valor_flete;
	}

	public void setTransportadora_valor_flete(Double transportadora_valor_flete) {
		this.transportadora_valor_flete = transportadora_valor_flete;
	}

	public String getDiferido() {
		return diferido;
	}

	public void setDiferido(String diferido) {
		this.diferido = diferido;
	}

	public Long getConceptoGastoId() {
		return conceptoGastoId;
	}

	public void setConceptoGastoId(Long conceptoGastoId) {
		this.conceptoGastoId = conceptoGastoId;
	}

	public DatServRealizadosEquipo getDatServRealizadosEquipoId() {
		return datServRealizadosEquipoId;
	}

	public void setDatServRealizadosEquipoId(DatServRealizadosEquipo datServRealizadosEquipoId) {
		this.datServRealizadosEquipoId = datServRealizadosEquipoId;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getNomTipoProducto() {
		return nomTipoProducto;
	}

	public void setNomTipoProducto(String nomTipoProducto) {
		this.nomTipoProducto = nomTipoProducto;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getCodConceptoKardex() {
		return codConceptoKardex;
	}

	public void setCodConceptoKardex(String codConceptoKardex) {
		this.codConceptoKardex = codConceptoKardex;
	}

	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}

	public String getCodPersEmpr() {
		return codPersEmpr;
	}

	public void setCodPersEmpr(String codPersEmpr) {
		this.codPersEmpr = codPersEmpr;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public Almacen getAlmacenId() {
		return almacenId;
	}

	public void setAlmacenId(Almacen almacenId) {
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

	public ConceptoKardex getConceptoKardexId() {
		return conceptoKardexId;
	}

	public void setConceptoKardexId(ConceptoKardex conceptoKardexId) {
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

	public Long getDatCompraProductosId() {
		return datCompraProductosId;
	}

	public void setDatCompraProductosId(Long datCompraProductosId) {
		this.datCompraProductosId = datCompraProductosId;
	}

	public Equipo getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Equipo equipoId) {
		this.equipoId = equipoId;
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

	public Long getNumFacturaCompra() {
		return numFacturaCompra;
	}

	public void setNumFacturaCompra(Long numFacturaCompra) {
		this.numFacturaCompra = numFacturaCompra;
	}

	public Long getPrecioProdId() {
		return precioProdId;
	}

	public void setPrecioProdId(Long precioProdId) {
		this.precioProdId = precioProdId;
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

	public UdadMed getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UdadMed unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public PersEmpr getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(PersEmpr persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getPorcIva() {
		return porcIva;
	}

	public void setPorcIva(Double porcIva) {
		this.porcIva = porcIva;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Long getDatOtrosMovInventarioId() {
		return datOtrosMovInventarioId;
	}

	public void setDatOtrosMovInventarioId(Long datOtrosMovInventarioId) {
		this.datOtrosMovInventarioId = datOtrosMovInventarioId;
	}

	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public String getCodNivel2() {
		return codNivel2;
	}

	public void setCodNivel2(String codNivel2) {
		this.codNivel2 = codNivel2;
	}

	public String getCodNivel4() {
		return codNivel4;
	}

	public void setCodNivel4(String codNivel4) {
		this.codNivel4 = codNivel4;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}

	public UbicacionesAlmacen getUbicacionesAlmacen() {
		return ubicacionesAlmacen;
	}

	public void setUbicacionesAlmacen(UbicacionesAlmacen ubicacionesAlmacen) {
		this.ubicacionesAlmacen = ubicacionesAlmacen;
	}

	public String getNomUbicacionesAlmacen() {
		return nomUbicacionesAlmacen;
	}

	public void setNomUbicacionesAlmacen(String nomUbicacionesAlmacen) {
		this.nomUbicacionesAlmacen = nomUbicacionesAlmacen;
	}

}
