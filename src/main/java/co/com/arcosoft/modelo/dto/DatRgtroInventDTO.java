package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatRgtroInventDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatRgtroInventDTO.class);
	private Double cantidadDisponible;
	private Double cantidadReservada;
	private Double cantidadTotal;
	private Long compania;
	private Long consecutivo;
	private Long datRgtroInventId;
	private String documetoErp;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private String infoAdicional;
	private String infoAdicional2;
	private String observacionAnularReg;
	private Long usuarioDigitacion;
	private Long almacenId_Almacen;
	private Long productoId_Producto;

	public Double getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Double cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Double getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(Double cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

	public Double getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(Double cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
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

	public Long getDatRgtroInventId() {
		return datRgtroInventId;
	}

	public void setDatRgtroInventId(Long datRgtroInventId) {
		this.datRgtroInventId = datRgtroInventId;
	}

	public String getDocumetoErp() {
		return documetoErp;
	}

	public void setDocumetoErp(String documetoErp) {
		this.documetoErp = documetoErp;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	public String getObservacionAnularReg() {
		return observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getAlmacenId_Almacen() {
		return almacenId_Almacen;
	}

	public void setAlmacenId_Almacen(Long almacenId_Almacen) {
		this.almacenId_Almacen = almacenId_Almacen;
	}

	public Long getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Long productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}
}
