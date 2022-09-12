package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * GrpLabor generated by hbm2java
 */
public class GrpLabor implements java.io.Serializable {

	private Long grpLaborId;
	private String codigo;
	private String nombre;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<GrpLaborTenCencos> grpLaborTenCencoses = new HashSet<GrpLaborTenCencos>(0);
	private Set<Labor> labors = new HashSet<Labor>(0);

	public GrpLabor() {
	}

	public GrpLabor(Long grpLaborId) {
		this.grpLaborId = grpLaborId;
	}

	public GrpLabor(Long grpLaborId, String codigo, String nombre, Long compania, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Set<GrpLaborTenCencos> grpLaborTenCencoses, Set<Labor> labors) {
		this.grpLaborId = grpLaborId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.grpLaborTenCencoses = grpLaborTenCencoses;
		this.labors = labors;
	}

	public Long getGrpLaborId() {
		return this.grpLaborId;
	}

	public void setGrpLaborId(Long grpLaborId) {
		this.grpLaborId = grpLaborId;
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

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Set<GrpLaborTenCencos> getGrpLaborTenCencoses() {
		return this.grpLaborTenCencoses;
	}

	public void setGrpLaborTenCencoses(Set<GrpLaborTenCencos> grpLaborTenCencoses) {
		this.grpLaborTenCencoses = grpLaborTenCencoses;
	}

	public Set<Labor> getLabors() {
		return this.labors;
	}

	public void setLabors(Set<Labor> labors) {
		this.labors = labors;
	}

}