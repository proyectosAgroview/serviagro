package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatAplicProdDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatAplicProdDetDTO.class);
	private Double cantidadAplicada;
	private Long compania;
	private Double costoTotal;
	private Long datProdDetId;
	private Double dosis;
	private Double valorUnit;
	private Long datAplicProdId_DatAplicProducto;
	private Producto productoId_Producto;
	private UdadMed udadMedId_UdadMed;
	private String nombreProducto;
	private String nombreUdadMed;
	private Long numeroTiquete;
	private Double pesoPromedio;
	private DatPlanLaborDet ordenTrabajo;
	private Nivel4 nivel4;
	private Nivel2 nivel2Id;
	private Labor laborId;
	
	private String nombreLabor;
	private String nombreNivel2;
	private String nombreNivel4;
	private String nombreOs;
	
	private String nombreAlmacen;
	private Almacen almacenId;
	
	
	private Double numTinas;
	
	private Long etapaId;
	private Long variedId;
private Double edad;
	
	
	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
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

	public Double getNumTinas() {
		return numTinas;
	}

	public void setNumTinas(Double numTinas) {
		this.numTinas = numTinas;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public Almacen getAlmacenId() {
		return almacenId;
	}

	public void setAlmacenId(Almacen almacenId) {
		this.almacenId = almacenId;
	}

	public Long getNumeroTiquete() {
		return numeroTiquete;
	}

	public void setNumeroTiquete(Long numeroTiquete) {
		this.numeroTiquete = numeroTiquete;
	}

	public Double getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public DatPlanLaborDet getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(DatPlanLaborDet ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public Nivel4 getNivel4() {
		return nivel4;
	}

	public void setNivel4(Nivel4 nivel4) {
		this.nivel4 = nivel4;
	}

	public Nivel2 getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Nivel2 nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Labor getLaborId() {
		return laborId;
	}

	public void setLaborId(Labor laborId) {
		this.laborId = laborId;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getNombreNivel2() {
		return nombreNivel2;
	}

	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	public String getNombreNivel4() {
		return nombreNivel4;
	}

	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	public String getNombreOs() {
		return nombreOs;
	}

	public void setNombreOs(String nombreOs) {
		this.nombreOs = nombreOs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public Double getCantidadAplicada() {
		return cantidadAplicada;
	}

	public void setCantidadAplicada(Double cantidadAplicada) {
		this.cantidadAplicada = cantidadAplicada;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDatProdDetId() {
		return datProdDetId;
	}

	public void setDatProdDetId(Long datProdDetId) {
		this.datProdDetId = datProdDetId;
	}

	public Double getDosis() {
		return dosis;
	}

	public void setDosis(Double dosis) {
		this.dosis = dosis;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Long getDatAplicProdId_DatAplicProducto() {
		return datAplicProdId_DatAplicProducto;
	}

	public void setDatAplicProdId_DatAplicProducto(Long datAplicProdId_DatAplicProducto) {
		this.datAplicProdId_DatAplicProducto = datAplicProdId_DatAplicProducto;
	}

	public Producto getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Producto productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}
}
