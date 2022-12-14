package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * MotivoCierreOt generated by hbm2java
 */
public class MotivoCierreOt implements java.io.Serializable {

	private Long motCierreOtId;
	private String codigo;
	private String nombre;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;

	public MotivoCierreOt() {
	}

	public MotivoCierreOt(Long motCierreOtId) {
		this.motCierreOtId = motCierreOtId;
	}

	public MotivoCierreOt(Long motCierreOtId, String codigo, String nombre, String infoAdicional, String infoAdicional2,
			Date fechaCreacion, Date fechaModificacion, String estado) {
		this.motCierreOtId = motCierreOtId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Long getMotCierreOtId() {
		return this.motCierreOtId;
	}

	public void setMotCierreOtId(Long motCierreOtId) {
		this.motCierreOtId = motCierreOtId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
