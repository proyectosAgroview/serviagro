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
public class FlotaTransporteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FlotaTransporteDTO.class);
	private String codigo;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long flotaTranspId;
	private String infoAdicional;
	private String infoAdicional2;
	private Double kmhAsfalto;
	private Double kmhTerraceria;
	private String nombre;
	private Double velocidadMaxima;
	private Double velocidadMinima;

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

	public Long getFlotaTranspId() {
		return flotaTranspId;
	}

	public void setFlotaTranspId(Long flotaTranspId) {
		this.flotaTranspId = flotaTranspId;
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

	public Double getKmhAsfalto() {
		return kmhAsfalto;
	}

	public void setKmhAsfalto(Double kmhAsfalto) {
		this.kmhAsfalto = kmhAsfalto;
	}

	public Double getKmhTerraceria() {
		return kmhTerraceria;
	}

	public void setKmhTerraceria(Double kmhTerraceria) {
		this.kmhTerraceria = kmhTerraceria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Double getVelocidadMinima() {
		return velocidadMinima;
	}

	public void setVelocidadMinima(Double velocidadMinima) {
		this.velocidadMinima = velocidadMinima;
	}
}
