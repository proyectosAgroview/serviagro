package co.com.arcosoft.modelo;

// Generated 05-ago-2015 14:10:19 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tenencia generated by hbm2java
 */
public class Tenencia implements java.io.Serializable {

	private Long tenenId;
	private GrpTenen grpTenen;
	private String codigo;
	private String nombre;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	public Long compania;
	private Set<Nivel4> nivel4s = new HashSet<Nivel4>(0);
    private Set<GrpLaborTenCencos> grpLaborTenCencoses = new HashSet<GrpLaborTenCencos>(0);

	public Tenencia() {
	}

	public Tenencia(Long tenenId) {
		this.tenenId = tenenId;
	}

	public Tenencia(Long tenenId, GrpTenen grpTenen, String codigo, String nombre, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, Long compania,
			Set<Nivel4> nivel4s,Set<GrpLaborTenCencos> grpLaborTenCencoses ) {
		this.tenenId = tenenId;
		this.grpTenen = grpTenen;
		this.codigo = codigo;
		this.nombre = nombre;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.compania = compania;
		this.nivel4s = nivel4s;
		this.grpLaborTenCencoses = grpLaborTenCencoses;
	}

	
	public Set<GrpLaborTenCencos> getGrpLaborTenCencoses() {
		return grpLaborTenCencoses;
	}

	public void setGrpLaborTenCencoses(Set<GrpLaborTenCencos> grpLaborTenCencoses) {
		this.grpLaborTenCencoses = grpLaborTenCencoses;
	}

	public Long getTenenId() {
		return this.tenenId;
	}

	public void setTenenId(Long tenenId) {
		this.tenenId = tenenId;
	}

	public GrpTenen getGrpTenen() {
		return this.grpTenen;
	}

	public void setGrpTenen(GrpTenen grpTenen) {
		this.grpTenen = grpTenen;
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

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Set<Nivel4> getNivel4s() {
		return this.nivel4s;
	}

	public void setNivel4s(Set<Nivel4> nivel4s) {
		this.nivel4s = nivel4s;
	}

}
