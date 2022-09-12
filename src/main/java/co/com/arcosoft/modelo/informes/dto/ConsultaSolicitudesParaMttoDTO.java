package co.com.arcosoft.modelo.informes.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.TallerMecanico;

public class ConsultaSolicitudesParaMttoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ConsultaSolicitudesParaMttoDTO.class);

	private BigInteger compania;
	private BigInteger dat_solicitudes_mtto_id;
	private Date fecha_registro;
	private BigInteger consecutivo;
	private BigInteger trab_solicitante_id;
	private String nom_trabajador;
	private BigInteger zonas_fabrica_id;
	private String nom_zona;
	private BigInteger tipo_mantenimiento_id;
	private String nom_tipo_mtto;
	private BigInteger area_trabajo_id;
	private String nom_area_trabajo;
	private BigInteger tag_id;
	private String nom_tag;
	private BigInteger taller_id;
	private String nom_taller_mecanico;
	private BigInteger equipo_id;
	private String nom_equipo;
	private BigInteger nivel_prioridad_id;
	private String nom_nivel_prioridad;
	private String descripcion_solicitud;
	private String observaciones;
	private String estado;
	
	private String estadoTrue;
	private Date fechaCierre;
    private String cierreSolicitud;
	private String estadoTrue2;
	private String tituloCierre;
	private String iconCierre;
	private String estadoSolicitudVencida;
	private long diasAtarso;
	
	/* DTO DatSolicitud */
    //private Long compania;
    //private Long consecutivo;
    private Long datSolicitudesMttoId;
    private String descripcionSolicitud;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private String observacionAnularReg;
    private String requiereParadaFabrica;
    private Long areaTrabajoId_AreaTrabajo;
    private Long equipoId_Equipo;
    private Long nivelPrioridadId_NivelPrioridad;
    private Long tagId_Tag;
    private Long tipoMantenimientoId_TipoMantenimiento;
    private Long trabId_Trabajador;
    private Long zonasFabricaId_ZonasFabrica;
    private TallerMecanico tallerId;
    private String origenDatos;


	/**
	 * @return the compania
	 */
	public BigInteger getCompania() {
		return compania;
	}

	/**
	 * @param compania
	 *            the compania to set
	 */
	public void setCompania(BigInteger compania) {
		this.compania = compania;
	}

	/**
	 * @return the dat_solicitudes_mtto_id
	 */
	public BigInteger getDat_solicitudes_mtto_id() {
		return dat_solicitudes_mtto_id;
	}

	/**
	 * @param dat_solicitudes_mtto_id
	 *            the dat_solicitudes_mtto_id to set
	 */
	public void setDat_solicitudes_mtto_id(BigInteger dat_solicitudes_mtto_id) {
		this.dat_solicitudes_mtto_id = dat_solicitudes_mtto_id;
	}

	/**
	 * @return the fecha_registro
	 */
	public Date getFecha_registro() {
		return fecha_registro;
	}

	/**
	 * @param fecha_registro
	 *            the fecha_registro to set
	 */
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	/**
	 * @return the consecutivo
	 */
	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo
	 *            the consecutivo to set
	 */
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	/**
	 * @return the trab_solicitante_id
	 */
	public BigInteger getTrab_solicitante_id() {
		return trab_solicitante_id;
	}

	/**
	 * @param trab_solicitante_id
	 *            the trab_solicitante_id to set
	 */
	public void setTrab_solicitante_id(BigInteger trab_solicitante_id) {
		this.trab_solicitante_id = trab_solicitante_id;
	}

	/**
	 * @return the nom_trabajador
	 */
	public String getNom_trabajador() {
		return nom_trabajador;
	}

	/**
	 * @param nom_trabajador
	 *            the nom_trabajador to set
	 */
	public void setNom_trabajador(String nom_trabajador) {
		this.nom_trabajador = nom_trabajador;
	}

	/**
	 * @return the zonas_fabrica_id
	 */
	public BigInteger getZonas_fabrica_id() {
		return zonas_fabrica_id;
	}

	/**
	 * @param zonas_fabrica_id
	 *            the zonas_fabrica_id to set
	 */
	public void setZonas_fabrica_id(BigInteger zonas_fabrica_id) {
		this.zonas_fabrica_id = zonas_fabrica_id;
	}

	/**
	 * @return the nom_zona
	 */
	public String getNom_zona() {
		return nom_zona;
	}

	/**
	 * @param nom_zona
	 *            the nom_zona to set
	 */
	public void setNom_zona(String nom_zona) {
		this.nom_zona = nom_zona;
	}

	/**
	 * @return the tipo_mantenimiento_id
	 */
	public BigInteger getTipo_mantenimiento_id() {
		return tipo_mantenimiento_id;
	}

	/**
	 * @param tipo_mantenimiento_id
	 *            the tipo_mantenimiento_id to set
	 */
	public void setTipo_mantenimiento_id(BigInteger tipo_mantenimiento_id) {
		this.tipo_mantenimiento_id = tipo_mantenimiento_id;
	}

	/**
	 * @return the nom_tipo_mtto
	 */
	public String getNom_tipo_mtto() {
		return nom_tipo_mtto;
	}

	/**
	 * @param nom_tipo_mtto
	 *            the nom_tipo_mtto to set
	 */
	public void setNom_tipo_mtto(String nom_tipo_mtto) {
		this.nom_tipo_mtto = nom_tipo_mtto;
	}

	/**
	 * @return the area_trabajo_id
	 */
	public BigInteger getArea_trabajo_id() {
		return area_trabajo_id;
	}

	/**
	 * @param area_trabajo_id
	 *            the area_trabajo_id to set
	 */
	public void setArea_trabajo_id(BigInteger area_trabajo_id) {
		this.area_trabajo_id = area_trabajo_id;
	}

	/**
	 * @return the nom_area_trabajo
	 */
	public String getNom_area_trabajo() {
		return nom_area_trabajo;
	}

	/**
	 * @param nom_area_trabajo
	 *            the nom_area_trabajo to set
	 */
	public void setNom_area_trabajo(String nom_area_trabajo) {
		this.nom_area_trabajo = nom_area_trabajo;
	}

	/**
	 * @return the tag_id
	 */
	public BigInteger getTag_id() {
		return tag_id;
	}

	/**
	 * @param tag_id
	 *            the tag_id to set
	 */
	public void setTag_id(BigInteger tag_id) {
		this.tag_id = tag_id;
	}

	/**
	 * @return the nom_tag
	 */
	public String getNom_tag() {
		return nom_tag;
	}

	/**
	 * @param nom_tag
	 *            the nom_tag to set
	 */
	public void setNom_tag(String nom_tag) {
		this.nom_tag = nom_tag;
	}

	/**
	 * @return the taller_id
	 */
	public BigInteger getTaller_id() {
		return taller_id;
	}

	/**
	 * @param taller_id
	 *            the taller_id to set
	 */
	public void setTaller_id(BigInteger taller_id) {
		this.taller_id = taller_id;
	}

	/**
	 * @return the nom_taller_mecanico
	 */
	public String getNom_taller_mecanico() {
		return nom_taller_mecanico;
	}

	/**
	 * @param nom_taller_mecanico
	 *            the nom_taller_mecanico to set
	 */
	public void setNom_taller_mecanico(String nom_taller_mecanico) {
		this.nom_taller_mecanico = nom_taller_mecanico;
	}

	/**
	 * @return the equipo_id
	 */
	public BigInteger getEquipo_id() {
		return equipo_id;
	}

	/**
	 * @param equipo_id
	 *            the equipo_id to set
	 */
	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
	}

	/**
	 * @return the nom_equipo
	 */
	public String getNom_equipo() {
		return nom_equipo;
	}

	/**
	 * @param nom_equipo
	 *            the nom_equipo to set
	 */
	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}

	/**
	 * @return the nivel_prioridad_id
	 */
	public BigInteger getNivel_prioridad_id() {
		return nivel_prioridad_id;
	}

	/**
	 * @param nivel_prioridad_id
	 *            the nivel_prioridad_id to set
	 */
	public void setNivel_prioridad_id(BigInteger nivel_prioridad_id) {
		this.nivel_prioridad_id = nivel_prioridad_id;
	}

	/**
	 * @return the nom_nivel_prioridad
	 */
	public String getNom_nivel_prioridad() {
		return nom_nivel_prioridad;
	}

	/**
	 * @param nom_nivel_prioridad
	 *            the nom_nivel_prioridad to set
	 */
	public void setNom_nivel_prioridad(String nom_nivel_prioridad) {
		this.nom_nivel_prioridad = nom_nivel_prioridad;
	}

	/**
	 * @return the descripcion_solicitud
	 */
	public String getDescripcion_solicitud() {
		return descripcion_solicitud;
	}

	/**
	 * @param descripcion_solicitud
	 *            the descripcion_solicitud to set
	 */
	public void setDescripcion_solicitud(String descripcion_solicitud) {
		this.descripcion_solicitud = descripcion_solicitud;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public Long getDatSolicitudesMttoId() {
		return datSolicitudesMttoId;
	}

	public void setDatSolicitudesMttoId(Long datSolicitudesMttoId) {
		this.datSolicitudesMttoId = datSolicitudesMttoId;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacionAnularReg() {
		return observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public String getRequiereParadaFabrica() {
		return requiereParadaFabrica;
	}

	public void setRequiereParadaFabrica(String requiereParadaFabrica) {
		this.requiereParadaFabrica = requiereParadaFabrica;
	}

	public Long getAreaTrabajoId_AreaTrabajo() {
		return areaTrabajoId_AreaTrabajo;
	}

	public void setAreaTrabajoId_AreaTrabajo(Long areaTrabajoId_AreaTrabajo) {
		this.areaTrabajoId_AreaTrabajo = areaTrabajoId_AreaTrabajo;
	}

	public Long getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public void setEquipoId_Equipo(Long equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public Long getNivelPrioridadId_NivelPrioridad() {
		return nivelPrioridadId_NivelPrioridad;
	}

	public void setNivelPrioridadId_NivelPrioridad(Long nivelPrioridadId_NivelPrioridad) {
		this.nivelPrioridadId_NivelPrioridad = nivelPrioridadId_NivelPrioridad;
	}

	public Long getTagId_Tag() {
		return tagId_Tag;
	}

	public void setTagId_Tag(Long tagId_Tag) {
		this.tagId_Tag = tagId_Tag;
	}

	public Long getTipoMantenimientoId_TipoMantenimiento() {
		return tipoMantenimientoId_TipoMantenimiento;
	}

	public void setTipoMantenimientoId_TipoMantenimiento(Long tipoMantenimientoId_TipoMantenimiento) {
		this.tipoMantenimientoId_TipoMantenimiento = tipoMantenimientoId_TipoMantenimiento;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Long getZonasFabricaId_ZonasFabrica() {
		return zonasFabricaId_ZonasFabrica;
	}

	public void setZonasFabricaId_ZonasFabrica(Long zonasFabricaId_ZonasFabrica) {
		this.zonasFabricaId_ZonasFabrica = zonasFabricaId_ZonasFabrica;
	}

	public TallerMecanico getTallerId() {
		return tallerId;
	}

	public void setTallerId(TallerMecanico tallerId) {
		this.tallerId = tallerId;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getCierreSolicitud() {
		return cierreSolicitud;
	}

	public void setCierreSolicitud(String cierreSolicitud) {
		this.cierreSolicitud = cierreSolicitud;
	}

	public String getEstadoTrue2() {
		return estadoTrue2;
	}

	public void setEstadoTrue2(String estadoTrue2) {
		this.estadoTrue2 = estadoTrue2;
	}

	public String getTituloCierre() {
		return tituloCierre;
	}

	public void setTituloCierre(String tituloCierre) {
		this.tituloCierre = tituloCierre;
	}

	public String getIconCierre() {
		return iconCierre;
	}

	public void setIconCierre(String iconCierre) {
		this.iconCierre = iconCierre;
	}

	public String getEstadoSolicitudVencida() {
		return estadoSolicitudVencida;
	}

	public void setEstadoSolicitudVencida(String estadoSolicitudVencida) {
		this.estadoSolicitudVencida = estadoSolicitudVencida;
	}

	public long getDiasAtarso() {
		return diasAtarso;
	}

	public void setDiasAtarso(long diasAtarso) {
		this.diasAtarso = diasAtarso;
	}

	/*public void setCompania(Long compania) {
		this.compania = compania;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}*/
	
	

}
