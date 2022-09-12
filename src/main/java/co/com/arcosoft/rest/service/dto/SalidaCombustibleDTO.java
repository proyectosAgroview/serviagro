package co.com.arcosoft.rest.service.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class SalidaCombustibleDTO {
    private Long compania;
	private Date fechaInicial;
    private Long almacenId;
    private String codAlmacen;
    private Long trabajador;
    private String codTrabajador;
    private Long equipoId; 
    private String codEquipo;
    private Long operario_equipo_id;
    private String cod_operario_equipo;
    private Double cantidadCompra;
    private Double  horometroAbastecimiento; 
    private Long conceptoKardexId;
    private Long consecutivo;
    private Double valorUnitario;
    private Double costoTotal;
    private Date fechaCreacion;
    private Long usuarioDigitacion;
    private Date fechaModificacion;
    private Long nivel2_clientesmq_id;
    private Long  nivel4_clientesmq_id;
    private String cod_nivel2_nivel2_clientesmq;
    private String cod_nivel4_nivel2_clientesmq ;
    private Long precioProdId;
    private String tipoMovimiento;
    private Long unidadMedida;
    private Long persEmprId_PersEmpr;
    private Long producto;
    private String nomProducto;
    private String codProducto;
    private String codPersEmpr;
    private Double porcIva;
    private Double valorIva;
    private Long datCompraProductosId;
    private Long datOtrosMovInventarioId;
    private Long datServRealizadosEquipoId;
    private String codConceptoKardex;
    private String nomTipoProducto;
    private Long conceptoGastoId;
    private String diferido;
    private String observacion;
    

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
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Long getAlmacenId() {
		return almacenId;
	}
	public void setAlmacenId(Long almacenId) {
		this.almacenId = almacenId;
	}
	public String getCodAlmacen() {
		return codAlmacen;
	}
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}
	public Long getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Long trabajador) {
		this.trabajador = trabajador;
	}
	public String getCodTrabajador() {
		return codTrabajador;
	}
	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}
	public Long getEquipoId() {
		return equipoId;
	}
	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	public Long getOperario_equipo_id() {
		return operario_equipo_id;
	}
	public void setOperario_equipo_id(Long operario_equipo_id) {
		this.operario_equipo_id = operario_equipo_id;
	}
	public String getCod_operario_equipo() {
		return cod_operario_equipo;
	}
	public void setCod_operario_equipo(String cod_operario_equipo) {
		this.cod_operario_equipo = cod_operario_equipo;
	}
	public Double getCantidadCompra() {
		return cantidadCompra;
	}
	public void setCantidadCompra(Double cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}
	public Double getHorometroAbastecimiento() {
		return horometroAbastecimiento;
	}
	public void setHorometroAbastecimiento(Double horometroAbastecimiento) {
		this.horometroAbastecimiento = horometroAbastecimiento;
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
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}
	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Long getNivel2_clientesmq_id() {
		return nivel2_clientesmq_id;
	}
	public void setNivel2_clientesmq_id(Long nivel2_clientesmq_id) {
		this.nivel2_clientesmq_id = nivel2_clientesmq_id;
	}
	public Long getNivel4_clientesmq_id() {
		return nivel4_clientesmq_id;
	}
	public void setNivel4_clientesmq_id(Long nivel4_clientesmq_id) {
		this.nivel4_clientesmq_id = nivel4_clientesmq_id;
	}
	public String getCod_nivel2_nivel2_clientesmq() {
		return cod_nivel2_nivel2_clientesmq;
	}
	public void setCod_nivel2_nivel2_clientesmq(String cod_nivel2_nivel2_clientesmq) {
		this.cod_nivel2_nivel2_clientesmq = cod_nivel2_nivel2_clientesmq;
	}
	public String getCod_nivel4_nivel2_clientesmq() {
		return cod_nivel4_nivel2_clientesmq;
	}
	public void setCod_nivel4_nivel2_clientesmq(String cod_nivel4_nivel2_clientesmq) {
		this.cod_nivel4_nivel2_clientesmq = cod_nivel4_nivel2_clientesmq;
	}
	public Long getPrecioProdId() {
		return precioProdId;
	}
	public void setPrecioProdId(Long precioProdId) {
		this.precioProdId = precioProdId;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Long getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(Long unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Long getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}
	public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}
	public Long getProducto() {
		return producto;
	}
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public String getCodPersEmpr() {
		return codPersEmpr;
	}
	public void setCodPersEmpr(String codPersEmpr) {
		this.codPersEmpr = codPersEmpr;
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
	public Long getDatCompraProductosId() {
		return datCompraProductosId;
	}
	public void setDatCompraProductosId(Long datCompraProductosId) {
		this.datCompraProductosId = datCompraProductosId;
	}
	public Long getDatOtrosMovInventarioId() {
		return datOtrosMovInventarioId;
	}
	public void setDatOtrosMovInventarioId(Long datOtrosMovInventarioId) {
		this.datOtrosMovInventarioId = datOtrosMovInventarioId;
	}
	public Long getDatServRealizadosEquipoId() {
		return datServRealizadosEquipoId;
	}
	public void setDatServRealizadosEquipoId(Long datServRealizadosEquipoId) {
		this.datServRealizadosEquipoId = datServRealizadosEquipoId;
	}
	public String getCodConceptoKardex() {
		return codConceptoKardex;
	}
	public void setCodConceptoKardex(String codConceptoKardex) {
		this.codConceptoKardex = codConceptoKardex;
	}
	public String getNomTipoProducto() {
		return nomTipoProducto;
	}
	public void setNomTipoProducto(String nomTipoProducto) {
		this.nomTipoProducto = nomTipoProducto;
	}
	public Long getConceptoGastoId() {
		return conceptoGastoId;
	}
	public void setConceptoGastoId(Long conceptoGastoId) {
		this.conceptoGastoId = conceptoGastoId;
	}
	public String getDiferido() {
		return diferido;
	}
	public void setDiferido(String diferido) {
		this.diferido = diferido;
	}
   
    
    
   
    
}
