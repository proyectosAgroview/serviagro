package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Medidor generated by hbm2java
 */
public class Medidor implements java.io.Serializable {

	private Long medidorId;
	private String codigo;
	private String nombre;
	public Long compania;
	private String tipoMedidor;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<Equipo> equipos = new HashSet<Equipo>(0);
	private Set<DatServRealizadosEquipo> datServRealizadosEquipos = new HashSet<DatServRealizadosEquipo>(0);
    
	public Medidor() {
	}

	public Medidor(Long medidorId) {
		this.medidorId = medidorId;
	}

	public Medidor(Long medidorId, String codigo, String nombre, Long compania, String tipoMedidor,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Set<Equipo> equipos, Set<DatServRealizadosEquipo> datServRealizadosEquipos) {
		this.medidorId = medidorId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.tipoMedidor = tipoMedidor;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.equipos = equipos;
		this.datServRealizadosEquipos = datServRealizadosEquipos;
	}

	public Set<DatServRealizadosEquipo> getDatServRealizadosEquipos() {
		return datServRealizadosEquipos;
	}

	public void setDatServRealizadosEquipos(Set<DatServRealizadosEquipo> datServRealizadosEquipos) {
		this.datServRealizadosEquipos = datServRealizadosEquipos;
	}

	public Long getMedidorId() {
		return this.medidorId;
	}

	public void setMedidorId(Long medidorId) {
		this.medidorId = medidorId;
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

	public String getTipoMedidor() {
		return this.tipoMedidor;
	}

	public void setTipoMedidor(String tipoMedidor) {
		this.tipoMedidor = tipoMedidor;
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

	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

}
