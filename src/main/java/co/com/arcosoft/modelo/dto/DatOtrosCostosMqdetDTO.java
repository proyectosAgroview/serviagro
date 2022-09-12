package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CuentaContable;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatOtrosCostosMqdetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosMqdetDTO.class);
	private Long datOtrosCostosMqdetId;
	private String origenDatos;
	private Double porcentaje;
	private Long datOtrosCostosMqId_DatOtrosCostosMq;
	private Equipo equipoId_Equipo;
	private Tag tagId_Tag;

	private String nombreEquipo;
	private String nombreTag;
	private UdadMed udadMed;
	private Producto producto;
	private Double cantidad;
	private Double valorUnitario;
	private Double costoTotal;
	private String nombreUdadMed;
	private String nombreProducto;
	private String descripcion;
	private Labor labor;

	private String nombreLabor;
	private CuentaContable ccontable;
	private PersEmpr persEmpr;
	private String nombrePersEmpr;
	private Double horometroServicio;
	private String nroFactura;
	private Long implementoId;
	private String codImplemento;
	private Long centCostId_CentCost;
    private String 	nombreCentroCosto;
    
    
	
	public String getNombreCentroCosto() {
		return nombreCentroCosto;
	}

	public void setNombreCentroCosto(String nombreCentroCosto) {
		this.nombreCentroCosto = nombreCentroCosto;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getImplementoId() {
		return implementoId;
	}

	public String getCodImplemento() {
		return codImplemento;
	}

	public void setImplementoId(Long implementoId) {
		this.implementoId = implementoId;
	}

	public void setCodImplemento(String codImplemento) {
		this.codImplemento = codImplemento;
	}

	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}

	public CuentaContable getCcontable() {
		return ccontable;
	}

	public void setCcontable(CuentaContable ccontable) {
		this.ccontable = ccontable;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public Labor getLabor() {
		return labor;
	}

	public void setLabor(Labor labor) {
		this.labor = labor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UdadMed getUdadMed() {
		return udadMed;
	}

	public void setUdadMed(UdadMed udadMed) {
		this.udadMed = udadMed;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
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

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNombreTag() {
		return nombreTag;
	}

	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

	public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public void setTagId_Tag(Tag tagId_Tag) {
		this.tagId_Tag = tagId_Tag;
	}

	public Long getDatOtrosCostosMqdetId() {
		return datOtrosCostosMqdetId;
	}

	public void setDatOtrosCostosMqdetId(Long datOtrosCostosMqdetId) {
		this.datOtrosCostosMqdetId = datOtrosCostosMqdetId;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Long getDatOtrosCostosMqId_DatOtrosCostosMq() {
		return datOtrosCostosMqId_DatOtrosCostosMq;
	}

	public void setDatOtrosCostosMqId_DatOtrosCostosMq(Long datOtrosCostosMqId_DatOtrosCostosMq) {
		this.datOtrosCostosMqId_DatOtrosCostosMq = datOtrosCostosMqId_DatOtrosCostosMq;
	}

	public Equipo getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public Tag getTagId_Tag() {
		return tagId_Tag;
	}

	public PersEmpr getPersEmpr() {
		return persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	public String getNombrePersEmpr() {
		return nombrePersEmpr;
	}

	public void setNombrePersEmpr(String nombrePersEmpr) {
		this.nombrePersEmpr = nombrePersEmpr;
	}

	public Double getHorometroServicio() {
		return horometroServicio;
	}

	public void setHorometroServicio(Double horometroServicio) {
		this.horometroServicio = horometroServicio;
	}

	public String getNroFactura() {
		return nroFactura;
	}

}
