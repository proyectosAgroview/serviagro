package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TipoRecursosInsumosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoRecursosInsumosDTO.class);
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Long tipoRecursosInsumosId;
	private Double valor;
	private ElementoCosto elemCostoId_ElementoCosto;
	private Producto productoId_Producto;
	private Long tpRecursoId_TipoRecurso;
	private UdadMed udadMedId_UdadMed;

	private String nombreUm;
	private String nombreProducto;
	private String nombreElemCosto;

	public String getNombreUm() {
		return nombreUm;
	}

	public void setNombreUm(String nombreUm) {
		this.nombreUm = nombreUm;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreElemCosto() {
		return nombreElemCosto;
	}

	public void setNombreElemCosto(String nombreElemCosto) {
		this.nombreElemCosto = nombreElemCosto;
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

	public Long getTipoRecursosInsumosId() {
		return tipoRecursosInsumosId;
	}

	public void setTipoRecursosInsumosId(Long tipoRecursosInsumosId) {
		this.tipoRecursosInsumosId = tipoRecursosInsumosId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ElementoCosto getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(ElementoCosto elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Producto getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Producto productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}

	public Long getTpRecursoId_TipoRecurso() {
		return tpRecursoId_TipoRecurso;
	}

	public void setTpRecursoId_TipoRecurso(Long tpRecursoId_TipoRecurso) {
		this.tpRecursoId_TipoRecurso = tpRecursoId_TipoRecurso;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}
}
