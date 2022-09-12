package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Empaque;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatTransProdDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdDetDTO.class);
	private Double areaCosechada;
	private Double cantidadReal;
	private Double cantidadSolicitada;
	private Long compania;
	private Long consecutivo;
	private Long datTransProdDetId;
	private String documetoErp;
	private Double valorTotal;
	private Double valorUnitario;
	private Ciudad ciudadId_Ciudad;
	private PersEmpr clienteId_Cliente;
	private Long datTransProdId_DatTransProd;
	private Empaque empaqueId_Empaque;
	private Producto productoId_Producto;
	private UdadMed udadMedId_UdadMed;
	private Double rendimiento;
	private String certificacionAceite;

	private String nombreCliente;
	private String nombreCiudad;
	private String codigoEmpaque;
	private String nombreProducto;
	private String nombreUdadeMed;

	private Double valorDeduccion;
	private Double valorNeto;

	private Double cantidadKilosLiq;

	public Double getCantidadKilosLiq() {
		return cantidadKilosLiq;
	}

	public void setCantidadKilosLiq(Double cantidadKilosLiq) {
		this.cantidadKilosLiq = cantidadKilosLiq;
	}

	public Double getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public Double getValorNeto() {
		return valorNeto;
	}

	public void setValorNeto(Double valorNeto) {
		this.valorNeto = valorNeto;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getCodigoEmpaque() {
		return codigoEmpaque;
	}

	public void setCodigoEmpaque(String codigoEmpaque) {
		this.codigoEmpaque = codigoEmpaque;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreUdadeMed() {
		return nombreUdadeMed;
	}

	public void setNombreUdadeMed(String nombreUdadeMed) {
		this.nombreUdadeMed = nombreUdadeMed;
	}

	public Double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Double getAreaCosechada() {
		return areaCosechada;
	}

	public void setAreaCosechada(Double areaCosechada) {
		this.areaCosechada = areaCosechada;
	}

	public Double getCantidadReal() {
		return cantidadReal;
	}

	public void setCantidadReal(Double cantidadReal) {
		this.cantidadReal = cantidadReal;
	}

	public Double getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Double cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getDatTransProdDetId() {
		return datTransProdDetId;
	}

	public void setDatTransProdDetId(Long datTransProdDetId) {
		this.datTransProdDetId = datTransProdDetId;
	}

	public String getDocumetoErp() {
		return documetoErp;
	}

	public void setDocumetoErp(String documetoErp) {
		this.documetoErp = documetoErp;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Ciudad getCiudadId_Ciudad() {
		return ciudadId_Ciudad;
	}

	public void setCiudadId_Ciudad(Ciudad ciudadId_Ciudad) {
		this.ciudadId_Ciudad = ciudadId_Ciudad;
	}

	public PersEmpr getClienteId_Cliente() {
		return clienteId_Cliente;
	}

	public void setClienteId_Cliente(PersEmpr clienteId_Cliente) {
		this.clienteId_Cliente = clienteId_Cliente;
	}

	public Long getDatTransProdId_DatTransProd() {
		return datTransProdId_DatTransProd;
	}

	public void setDatTransProdId_DatTransProd(Long datTransProdId_DatTransProd) {
		this.datTransProdId_DatTransProd = datTransProdId_DatTransProd;
	}

	public Empaque getEmpaqueId_Empaque() {
		return empaqueId_Empaque;
	}

	public void setEmpaqueId_Empaque(Empaque empaqueId_Empaque) {
		this.empaqueId_Empaque = empaqueId_Empaque;
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

	public String getCertificacionAceite() {
		return certificacionAceite;
	}

	public void setCertificacionAceite(String certificacionAceite) {
		this.certificacionAceite = certificacionAceite;
	}
}
