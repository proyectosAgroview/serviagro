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
public class FitosanidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FitosanidadDTO.class);
	private String claseFitosanidad;
	private String codigo;
	private Long compania;
	private Long fitosanidadId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private String nombreCientifico;
	private String tipoFitosanidad;
	private String cultivos;
	private String controlInsectos;

	

	/**
	 * @return the controlInsectos
	 */
	public String getControlInsectos() {
		return controlInsectos;
	}

	/**
	 * @param controlInsectos the controlInsectos to set
	 */
	public void setControlInsectos(String controlInsectos) {
		this.controlInsectos = controlInsectos;
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

	public String getClaseFitosanidad() {
		return claseFitosanidad;
	}

	public void setClaseFitosanidad(String claseFitosanidad) {
		this.claseFitosanidad = claseFitosanidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getFitosanidadId() {
		return fitosanidadId;
	}

	public void setFitosanidadId(Long fitosanidadId) {
		this.fitosanidadId = fitosanidadId;
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

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getTipoFitosanidad() {
		return tipoFitosanidad;
	}

	public void setTipoFitosanidad(String tipoFitosanidad) {
		this.tipoFitosanidad = tipoFitosanidad;
	}

	public String getCultivos() {
		return cultivos;
	}

	public void setCultivos(String cultivos) {
		this.cultivos = cultivos;
	}

}
