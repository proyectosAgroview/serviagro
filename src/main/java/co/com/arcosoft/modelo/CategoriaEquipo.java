package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CategoriaEquipo generated by hbm2java
 */
public class CategoriaEquipo implements java.io.Serializable {

	private Long categEquipId;
	private String codigo;
	private String nombre;
	public Long compania;
	private Double taraMin;
	private Double taraMax;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<ModeloEquipo> modeloEquipos = new HashSet<ModeloEquipo>(0);
	private Set<Equipo> equipos = new HashSet<Equipo>(0);
	private Set<TipoRecursosEquipos> tipoRecursosEquiposes = new HashSet<TipoRecursosEquipos>(0);
	private String funcion;
	private Double rangoDifHorometro;

    private ConceptoKardex conceptoKardexId;
	
	public CategoriaEquipo() {
	}

	public CategoriaEquipo(Long categEquipId) {
		this.categEquipId = categEquipId;
	}

	public CategoriaEquipo(Long categEquipId, String codigo, String nombre, Long compania, Double taraMin,
			Double taraMax, String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion,
			String estado, Set<ModeloEquipo> modeloEquipos, Set<Equipo> equipos,
			Set<TipoRecursosEquipos> tipoRecursosEquiposes, String funcion, Double rangoDifHorometro, ConceptoKardex conceptoKardexId) {
		this.categEquipId = categEquipId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.taraMin = taraMin;
		this.taraMax = taraMax;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.modeloEquipos = modeloEquipos;
		this.equipos = equipos;
		this.tipoRecursosEquiposes = tipoRecursosEquiposes;
		this.funcion = funcion;
		this.rangoDifHorometro=rangoDifHorometro;
		this.conceptoKardexId=conceptoKardexId;
	}
	

	
	public ConceptoKardex getConceptoKardexId() {
		return conceptoKardexId;
	}

	public void setConceptoKardexId(ConceptoKardex conceptoKardexId) {
		this.conceptoKardexId = conceptoKardexId;
	}

	public Double getRangoDifHorometro() {
		return rangoDifHorometro;
	}

	public void setRangoDifHorometro(Double rangoDifHorometro) {
		this.rangoDifHorometro = rangoDifHorometro;
	}

	/**
	 * @return the funcion
	 */
	public String getFuncion() {
		return funcion;
	}

	/**
	 * @param funcion the funcion to set
	 */
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public Set<TipoRecursosEquipos> getTipoRecursosEquiposes() {
		return tipoRecursosEquiposes;
	}

	public void setTipoRecursosEquiposes(Set<TipoRecursosEquipos> tipoRecursosEquiposes) {
		this.tipoRecursosEquiposes = tipoRecursosEquiposes;
	}

	public Long getCategEquipId() {
		return this.categEquipId;
	}

	public void setCategEquipId(Long categEquipId) {
		this.categEquipId = categEquipId;
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

	public Double getTaraMin() {
		return this.taraMin;
	}

	public void setTaraMin(Double taraMin) {
		this.taraMin = taraMin;
	}

	public Double getTaraMax() {
		return this.taraMax;
	}

	public void setTaraMax(Double taraMax) {
		this.taraMax = taraMax;
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

	public Set<ModeloEquipo> getModeloEquipos() {
		return this.modeloEquipos;
	}

	public void setModeloEquipos(Set<ModeloEquipo> modeloEquipos) {
		this.modeloEquipos = modeloEquipos;
	}

	public Set<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

}
