package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.TallerMecanico;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatSolicitudesMttoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatSolicitudesMttoDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datSolicitudesMttoId;
    private String descripcionSolicitud;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private String observacionAnularReg;
    private String observaciones;
    private String requiereParadaFabrica;
    private Long areaTrabajoId_AreaTrabajo;
    private Long equipoId_Equipo;
    private Long nivelPrioridadId_NivelPrioridad;
    private Long tagId_Tag;
    private Long tipoMantenimientoId_TipoMantenimiento;
    private Long trabId_Trabajador;
    private Long zonasFabricaId_ZonasFabrica;
    private String estadoTrue;
    private TallerMecanico tallerId;
    private String origenDatos;

    /* filtros */
	private BigInteger dat_solicitudes_mtto_id;
	private Date fecha_registro;
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
    

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public void setNivelPrioridadId_NivelPrioridad(
        Long nivelPrioridadId_NivelPrioridad) {
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

    public void setTipoMantenimientoId_TipoMantenimiento(
        Long tipoMantenimientoId_TipoMantenimiento) {
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

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
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

	public BigInteger getDat_solicitudes_mtto_id() {
		return dat_solicitudes_mtto_id;
	}

	public void setDat_solicitudes_mtto_id(BigInteger dat_solicitudes_mtto_id) {
		this.dat_solicitudes_mtto_id = dat_solicitudes_mtto_id;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public BigInteger getTrab_solicitante_id() {
		return trab_solicitante_id;
	}

	public void setTrab_solicitante_id(BigInteger trab_solicitante_id) {
		this.trab_solicitante_id = trab_solicitante_id;
	}

	public String getNom_trabajador() {
		return nom_trabajador;
	}

	public void setNom_trabajador(String nom_trabajador) {
		this.nom_trabajador = nom_trabajador;
	}

	public BigInteger getZonas_fabrica_id() {
		return zonas_fabrica_id;
	}

	public void setZonas_fabrica_id(BigInteger zonas_fabrica_id) {
		this.zonas_fabrica_id = zonas_fabrica_id;
	}

	public String getNom_zona() {
		return nom_zona;
	}

	public void setNom_zona(String nom_zona) {
		this.nom_zona = nom_zona;
	}

	public BigInteger getTipo_mantenimiento_id() {
		return tipo_mantenimiento_id;
	}

	public void setTipo_mantenimiento_id(BigInteger tipo_mantenimiento_id) {
		this.tipo_mantenimiento_id = tipo_mantenimiento_id;
	}

	public String getNom_tipo_mtto() {
		return nom_tipo_mtto;
	}

	public void setNom_tipo_mtto(String nom_tipo_mtto) {
		this.nom_tipo_mtto = nom_tipo_mtto;
	}

	public BigInteger getArea_trabajo_id() {
		return area_trabajo_id;
	}

	public void setArea_trabajo_id(BigInteger area_trabajo_id) {
		this.area_trabajo_id = area_trabajo_id;
	}

	public String getNom_area_trabajo() {
		return nom_area_trabajo;
	}

	public void setNom_area_trabajo(String nom_area_trabajo) {
		this.nom_area_trabajo = nom_area_trabajo;
	}

	public BigInteger getTag_id() {
		return tag_id;
	}

	public void setTag_id(BigInteger tag_id) {
		this.tag_id = tag_id;
	}

	public String getNom_tag() {
		return nom_tag;
	}

	public void setNom_tag(String nom_tag) {
		this.nom_tag = nom_tag;
	}

	public BigInteger getTaller_id() {
		return taller_id;
	}

	public void setTaller_id(BigInteger taller_id) {
		this.taller_id = taller_id;
	}

	public String getNom_taller_mecanico() {
		return nom_taller_mecanico;
	}

	public void setNom_taller_mecanico(String nom_taller_mecanico) {
		this.nom_taller_mecanico = nom_taller_mecanico;
	}

	public BigInteger getEquipo_id() {
		return equipo_id;
	}

	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
	}

	public String getNom_equipo() {
		return nom_equipo;
	}

	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}

	public BigInteger getNivel_prioridad_id() {
		return nivel_prioridad_id;
	}

	public void setNivel_prioridad_id(BigInteger nivel_prioridad_id) {
		this.nivel_prioridad_id = nivel_prioridad_id;
	}

	public String getNom_nivel_prioridad() {
		return nom_nivel_prioridad;
	}

	public void setNom_nivel_prioridad(String nom_nivel_prioridad) {
		this.nom_nivel_prioridad = nom_nivel_prioridad;
	}

	public String getDescripcion_solicitud() {
		return descripcion_solicitud;
	}

	public void setDescripcion_solicitud(String descripcion_solicitud) {
		this.descripcion_solicitud = descripcion_solicitud;
	}
	
	
    
    
}
