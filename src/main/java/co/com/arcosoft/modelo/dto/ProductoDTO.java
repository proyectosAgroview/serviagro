package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.UbicacionesAlmacen;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class ProductoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProductoDTO.class);
	private String codigo;
	private Long compania;
	private String esGranel;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String flujoMovimiento;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private String observacion;
	private Long productoId;
	private Long almacenId_Almacen;
	private Long centCostId_CentCost;
	private Long claseToxicId_ClaseToxicologica;
	private Long elemCostoId_ElementoCosto;
	private Long tipoProdId_TipoProducto;
	private Long udadMedId_UdadMed_Prod;
	private Long udadMedId_UdadMed_Cosecha;

	private String codTipoProducto;
	private String nomTipoProducto;
	private Double saldoMinimo;
    private Double saldoMaximo;
    private String requiereSellos;	
    private UbicacionesAlmacen ubicacionesAlmacenId;   
    
    private Long usuarioDigitacion;
    private String esFormula;
    
    
	public String getEsFormula() {
		return esFormula;
	}

	public void setEsFormula(String esFormula) {
		this.esFormula = esFormula;
	}

	/**
	 * @return the saldoMinimo
	 */
	public Double getSaldoMinimo() {
		return saldoMinimo;
	}

	/**
	 * @param saldoMinimo the saldoMinimo to set
	 */
	public void setSaldoMinimo(Double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	/**
	 * @return the saldoMaximo
	 */
	public Double getSaldoMaximo() {
		return saldoMaximo;
	}

	/**
	 * @param saldoMaximo the saldoMaximo to set
	 */
	public void setSaldoMaximo(Double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}

	/**
	 * @return the codTipoProducto
	 */
	public String getCodTipoProducto() {
		return codTipoProducto;
	}

	/**
	 * @param codTipoProducto the codTipoProducto to set
	 */
	public void setCodTipoProducto(String codTipoProducto) {
		this.codTipoProducto = codTipoProducto;
	}

	/**
	 * @return the nomTipoProducto
	 */
	public String getNomTipoProducto() {
		return nomTipoProducto;
	}

	/**
	 * @param nomTipoProducto the nomTipoProducto to set
	 */
	public void setNomTipoProducto(String nomTipoProducto) {
		this.nomTipoProducto = nomTipoProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getEsGranel() {
		return esGranel;
	}

	public void setEsGranel(String esGranel) {
		this.esGranel = esGranel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getFlujoMovimiento() {
		return flujoMovimiento;
	}

	public void setFlujoMovimiento(String flujoMovimiento) {
		this.flujoMovimiento = flujoMovimiento;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getAlmacenId_Almacen() {
		return almacenId_Almacen;
	}

	public void setAlmacenId_Almacen(Long almacenId_Almacen) {
		this.almacenId_Almacen = almacenId_Almacen;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getClaseToxicId_ClaseToxicologica() {
		return claseToxicId_ClaseToxicologica;
	}

	public void setClaseToxicId_ClaseToxicologica(Long claseToxicId_ClaseToxicologica) {
		this.claseToxicId_ClaseToxicologica = claseToxicId_ClaseToxicologica;
	}

	public Long getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Long getTipoProdId_TipoProducto() {
		return tipoProdId_TipoProducto;
	}

	public void setTipoProdId_TipoProducto(Long tipoProdId_TipoProducto) {
		this.tipoProdId_TipoProducto = tipoProdId_TipoProducto;
	}

	public Long getUdadMedId_UdadMed_Prod() {
		return udadMedId_UdadMed_Prod;
	}

	public void setUdadMedId_UdadMed_Prod(Long udadMedId_UdadMed_Prod) {
		this.udadMedId_UdadMed_Prod = udadMedId_UdadMed_Prod;
	}

	public Long getUdadMedId_UdadMed_Cosecha() {
		return udadMedId_UdadMed_Cosecha;
	}

	public void setUdadMedId_UdadMed_Cosecha(Long udadMedId_UdadMed_Cosecha) {
		this.udadMedId_UdadMed_Cosecha = udadMedId_UdadMed_Cosecha;
	}

	public String getRequiereSellos() {
		return requiereSellos;
	}

	public void setRequiereSellos(String requiereSellos) {
		this.requiereSellos = requiereSellos;
	}

	public UbicacionesAlmacen getUbicacionesAlmacenId() {
		return ubicacionesAlmacenId;
	}

	public void setUbicacionesAlmacenId(UbicacionesAlmacen ubicacionesAlmacenId) {
		this.ubicacionesAlmacenId = ubicacionesAlmacenId;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

}
