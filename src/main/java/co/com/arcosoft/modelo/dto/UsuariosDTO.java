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
public class UsuariosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UsuariosDTO.class);
	private String contrasena;
	private String enabled;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String login;
	private String nombre;
	private Long usuarioId;
	public Long companiaId_Compania;
	private String nombreCompania;
	private String permisosMovil;
	private String usa_planificacion;
	private String nivelAutorizacion1;
	private String nivelAutorizacion2;
	
	private String nivelAcceso;
	
	
	

	public String getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(String nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	/**
	 * @return the nivelAutorizacion1
	 */
	public String getNivelAutorizacion1() {
		return nivelAutorizacion1;
	}

	/**
	 * @param nivelAutorizacion1 the nivelAutorizacion1 to set
	 */
	public void setNivelAutorizacion1(String nivelAutorizacion1) {
		this.nivelAutorizacion1 = nivelAutorizacion1;
	}

	/**
	 * @return the nivelAutorizacion2
	 */
	public String getNivelAutorizacion2() {
		return nivelAutorizacion2;
	}

	/**
	 * @param nivelAutorizacion2 the nivelAutorizacion2 to set
	 */
	public void setNivelAutorizacion2(String nivelAutorizacion2) {
		this.nivelAutorizacion2 = nivelAutorizacion2;
	}

	public String getUsa_planificacion() {
		return usa_planificacion;
	}

	public void setUsa_planificacion(String usa_planificacion) {
		this.usa_planificacion = usa_planificacion;
	}

	/**
	 * @return the permisosMovil
	 */
	public String getPermisosMovil() {
		return permisosMovil;
	}

	/**
	 * @param permisosMovil the permisosMovil to set
	 */
	public void setPermisosMovil(String permisosMovil) {
		this.permisosMovil = permisosMovil;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getCompaniaId_Compania() {
		return companiaId_Compania;
	}

	public void setCompaniaId_Compania(Long companiaId_Compania) {
		this.companiaId_Compania = companiaId_Compania;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

}
