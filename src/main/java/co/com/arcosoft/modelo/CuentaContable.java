package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CuentaContable generated by hbm2java
 */
public class CuentaContable implements java.io.Serializable {

	private Long ccontableId;
	private String codigo;
	private String nombre;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<LaborCcontable> laborCcontables = new HashSet<LaborCcontable>(0);

	public CuentaContable() {
	}

	public CuentaContable(Long ccontableId) {
		this.ccontableId = ccontableId;
	}

	public CuentaContable(Long ccontableId, String codigo, String nombre, Long compania, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Set<LaborCcontable> laborCcontables) {
		this.ccontableId = ccontableId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.laborCcontables = laborCcontables;
	}

	public Long getCcontableId() {
		return this.ccontableId;
	}

	public void setCcontableId(Long ccontableId) {
		this.ccontableId = ccontableId;
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

	public Set<LaborCcontable> getLaborCcontables() {
		return this.laborCcontables;
	}

	public void setLaborCcontables(Set<LaborCcontable> laborCcontables) {
		this.laborCcontables = laborCcontables;
	}

}
