package co.com.arcosoft.modelo.informes.dto;

import java.math.BigInteger;
import java.util.Date;

public class logServiciosMaqDTO {

	private	BigInteger	equipo_id	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private BigInteger pin;
	private BigInteger log_dat_serv_realizados_equipo_id;
	private BigInteger	compania	;
	private BigInteger	usuarioMdf	;
	private String 	loginMdf	;
	private String 	observacion	;
	private Date fechaModificacion;

	
	
	
	public void setLog_dat_serv_realizados_equipo_id(BigInteger log_dat_serv_realizados_equipo_id) {
		this.log_dat_serv_realizados_equipo_id = log_dat_serv_realizados_equipo_id;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public BigInteger getEquipo_id() {
		return equipo_id;
	}
	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
	}
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public String getNom_equipo() {
		return nom_equipo;
	}
	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}
	public BigInteger getPin() {
		return pin;
	}
	public void setPin(BigInteger pin) {
		this.pin = pin;
	}
	public BigInteger getLog_dat_serv_realizados_equipo_id() {
		return log_dat_serv_realizados_equipo_id;
	}
	public void equipo_id(BigInteger log_dat_serv_realizados_equipo_id) {
		this.log_dat_serv_realizados_equipo_id = log_dat_serv_realizados_equipo_id;
	}
	public BigInteger getCompania() {
		return compania;
	}
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}
	public BigInteger getUsuarioMdf() {
		return usuarioMdf;
	}
	public void setUsuarioMdf(BigInteger usuarioMdf) {
		this.usuarioMdf = usuarioMdf;
	}
	public String getLoginMdf() {
		return loginMdf;
	}
	public void setLoginMdf(String loginMdf) {
		this.loginMdf = loginMdf;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}
