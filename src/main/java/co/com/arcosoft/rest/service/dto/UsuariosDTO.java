package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class UsuariosDTO {

	private Long usuarioId;
	private Long compania;
	private String login;
	private String contrasena;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String enabled;
	private String permisosMovil;
	private String usa_planificacion;
	/*private Long trabajadorId;
	
	
	

	public Long getTrabajadorId() {
		return trabajadorId;
	}

	public void setTrabajadorId(Long trabajadorId) {
		this.trabajadorId = trabajadorId;
	}
*/
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

	public UsuariosDTO() {
	}

	public Long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
