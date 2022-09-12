package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatPlanLaborDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanLaborDTO.class);
	private Long NPases;
	private Long anio;
	private Double cantidadPlan;
	private String cierreOt;
	private Long compania;
	private Double costoTotalEstimado;
	private Double edadPlanificacion;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String idMobile;
	private String infoAdicional;
	private String infoAdicional2;
	private Float latitud;
	private Float longitud;
	private Long nivel1Id;
	private Long nivel2Id;
	private Long nivel3Id;
	private String observacion;
	private String observacionAnularReg;
	private Long ordenTrabajo;
	private Date periodoFinal;
	private Date periodoInicial;
	private Long planLaborId;
	private Float precision;
	private Long usuarioDigitacion;
	private Long contratistaId_Contratista;
	private Long laborId_Labor;
	private Long nivel4Id_Nivel4;
	private Long servicioId_Servicio;
	private Long trabId_Trabajador;
	private Long udadMedId_UdadMed;
	private String laborNombre;
	private String nivel1Nombre;
	private String nivel2Nombre;
	private String nivel3Nombre;
	private String nivel4Nombre;
	private String udadMedNombre;
	private String estadoTrue;
	private String estadoTrue2;
	private String tituloCierreOt;
	private String iconCierreOt;
	private String estadoOrdenTrabajoVencida;
	
	private String codLabor;
	private String codUdadMed;
	private String nomUsuarioDigitacion;
	private String nomTrabajador;
	
	private long diasAtarsoOt;

	public String getLaborNombre() {
		return laborNombre;
	}

	public void setLaborNombre(String laborNombre) {
		this.laborNombre = laborNombre;
	}

	public String getNivel1Nombre() {
		return nivel1Nombre;
	}

	public void setNivel1Nombre(String nivel1Nombre) {
		this.nivel1Nombre = nivel1Nombre;
	}

	public String getNivel2Nombre() {
		return nivel2Nombre;
	}

	public void setNivel2Nombre(String nivel2Nombre) {
		this.nivel2Nombre = nivel2Nombre;
	}

	public String getNivel3Nombre() {
		return nivel3Nombre;
	}

	public void setNivel3Nombre(String nivel3Nombre) {
		this.nivel3Nombre = nivel3Nombre;
	}

	public String getNivel4Nombre() {
		return nivel4Nombre;
	}

	public void setNivel4Nombre(String nivel4Nombre) {
		this.nivel4Nombre = nivel4Nombre;
	}

	public String getUdadMedNombre() {
		return udadMedNombre;
	}

	public void setUdadMedNombre(String udadMedNombre) {
		this.udadMedNombre = udadMedNombre;
	}

	public Long getNPases() {
		return NPases;
	}

	public void setNPases(Long NPases) {
		this.NPases = NPases;
	}

	public Long getAnio() {
		return anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public Double getCantidadPlan() {
		return cantidadPlan;
	}

	public void setCantidadPlan(Double cantidadPlan) {
		this.cantidadPlan = cantidadPlan;
	}

	public String getCierreOt() {
		return cierreOt;
	}

	public void setCierreOt(String cierreOt) {
		this.cierreOt = cierreOt;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getCostoTotalEstimado() {
		return costoTotalEstimado;
	}

	public void setCostoTotalEstimado(Double costoTotalEstimado) {
		this.costoTotalEstimado = costoTotalEstimado;
	}

	public Double getEdadPlanificacion() {
		return edadPlanificacion;
	}

	public void setEdadPlanificacion(Double edadPlanificacion) {
		this.edadPlanificacion = edadPlanificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getIdMobile() {
		return idMobile;
	}

	public void setIdMobile(String idMobile) {
		this.idMobile = idMobile;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Long getNivel1Id() {
		return nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Long getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Long nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Long getNivel3Id() {
		return nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacionAnularReg() {
		return observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public Long getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(Long ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Long getPlanLaborId() {
		return planLaborId;
	}

	public void setPlanLaborId(Long planLaborId) {
		this.planLaborId = planLaborId;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getContratistaId_Contratista() {
		return contratistaId_Contratista;
	}

	public void setContratistaId_Contratista(Long contratistaId_Contratista) {
		this.contratistaId_Contratista = contratistaId_Contratista;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getServicioId_Servicio() {
		return servicioId_Servicio;
	}

	public void setServicioId_Servicio(Long servicioId_Servicio) {
		this.servicioId_Servicio = servicioId_Servicio;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Long getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}

	public String getEstadoOrdenTrabajoVencida() {
		return estadoOrdenTrabajoVencida;
	}

	public void setEstadoOrdenTrabajoVencida(String estadoOrdenTrabajoVencida) {
		this.estadoOrdenTrabajoVencida = estadoOrdenTrabajoVencida;
	}

	public long getDiasAtarsoOt() {
		return diasAtarsoOt;
	}

	public void setDiasAtarsoOt(long diasAtarsoOt) {
		this.diasAtarsoOt = diasAtarsoOt;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public String getTituloCierreOt() {
		return tituloCierreOt;
	}

	public void setTituloCierreOt(String tituloCierreOt) {
		this.tituloCierreOt = tituloCierreOt;
	}

	public String getIconCierreOt() {
		return iconCierreOt;
	}

	public void setIconCierreOt(String iconCierreOt) {
		this.iconCierreOt = iconCierreOt;
	}

	public String getEstadoTrue2() {
		return estadoTrue2;
	}

	public void setEstadoTrue2(String estadoTrue2) {
		this.estadoTrue2 = estadoTrue2;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public String getNomUsuarioDigitacion() {
		return nomUsuarioDigitacion;
	}

	public void setNomUsuarioDigitacion(String nomUsuarioDigitacion) {
		this.nomUsuarioDigitacion = nomUsuarioDigitacion;
	}

	public String getNomTrabajador() {
		return nomTrabajador;
	}

	public void setNomTrabajador(String nomTrabajador) {
		this.nomTrabajador = nomTrabajador;
	}

}
