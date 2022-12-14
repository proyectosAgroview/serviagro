package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Servicio generated by hbm2java
 */
public class Servicio implements java.io.Serializable {

	private Long servicioId;
	private String codigo;
	private String nombre;
	public Long compania;
	private Long elementoCosto;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<LaborServicio> laborServicios = new HashSet<LaborServicio>(0);
	private Set<DatServicio> datServicios = new HashSet<DatServicio>(0);
	private Set<Equipo> equipos = new HashSet<Equipo>(0);
	private Set<DatPlanLabor> datPlanLabors = new HashSet<DatPlanLabor>(0);
	private Set<DatServImplemento> datServImplementos = new HashSet<DatServImplemento>(0);
	private Set<TipoRecursosOtros> tipoRecursosOtroses = new HashSet<TipoRecursosOtros>(0);

	public Servicio() {
	}

	public Servicio(Long servicioId) {
		this.servicioId = servicioId;
	}

	public Servicio(Long servicioId, String codigo, String nombre, Long compania, String tipoMedidor,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Set<LaborServicio> laborServicios, Long elementoCosto, Set<DatServicio> datServicios, Set<Equipo> equipos,
			Set<DatPlanLabor> datPlanLabors, Set<DatServImplemento> datServImplementos,
			Set<TipoRecursosOtros> tipoRecursosOtroses) {
		this.servicioId = servicioId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.elementoCosto = elementoCosto;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.laborServicios = laborServicios;
		this.datServicios = datServicios;
		this.equipos = equipos;
		this.datPlanLabors = datPlanLabors;
		this.datServImplementos = datServImplementos;
		this.tipoRecursosOtroses = tipoRecursosOtroses;

	}

	public Set<TipoRecursosOtros> getTipoRecursosOtroses() {
		return tipoRecursosOtroses;
	}

	public void setTipoRecursosOtroses(Set<TipoRecursosOtros> tipoRecursosOtroses) {
		this.tipoRecursosOtroses = tipoRecursosOtroses;
	}

	public Long getServicioId() {
		return this.servicioId;
	}

	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
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

	public Long getElementoCosto() {
		return this.elementoCosto;
	}

	public void setElementoCosto(Long elementoCosto) {
		this.elementoCosto = elementoCosto;
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

	public Set<LaborServicio> getLaborServicios() {
		return this.laborServicios;
	}

	public void setLaborServicios(Set<LaborServicio> laborServicios) {
		this.laborServicios = laborServicios;
	}

	public Set<DatServicio> getDatServicios() {
		return this.datServicios;
	}

	public void setDatServicios(Set<DatServicio> datServicios) {
		this.datServicios = datServicios;
	}

	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Set<DatPlanLabor> getDatPlanLabors() {
		return this.datPlanLabors;
	}

	public void setDatPlanLabors(Set<DatPlanLabor> datPlanLabors) {
		this.datPlanLabors = datPlanLabors;
	}

	public Set<DatServImplemento> getDatServImplementos() {
		return this.datServImplementos;
	}

	public void setDatServImplementos(Set<DatServImplemento> datServImplementos) {
		this.datServImplementos = datServImplementos;
	}

}
