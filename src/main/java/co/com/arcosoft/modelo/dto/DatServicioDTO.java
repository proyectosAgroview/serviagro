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
public class DatServicioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatServicioDTO.class);
	private Long NPases;
	private Long anio;
	private Double cantidadPago;
	private String cierreCostos;
	private Long compania;
	private Long consecutivo;
	private Double costoTotal;
	private Long datServicioId;
	private String documetoErp;
	private Double edadEjecucion;
	private String estado;
	private Long etapaId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private Date fechaAnulacion;
	private Date horaFinal;
	private Date horaInicial;
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
	private Float precision;
	private String tiempoInactivo;
	private Double totalHoras;
	private Long usuarioDigitacion;
	private Double valorUnit;
	private Long variedId;
	private Long contratistaId_Contratista;
	private Long equipoId_Equipo;
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
	private String contratistaNombre;
	private String contratistaCodigo;
	private String servicioNombre;
	private String estadoTrue;
	private Long datPlanillaNominaId;

	private String requiereMaquinaria;

	public String getRequiereMaquinaria() {
		return requiereMaquinaria;
	}

	public void setRequiereMaquinaria(String requiereMaquinaria) {
		this.requiereMaquinaria = requiereMaquinaria;
	}

	public Long getDatPlanillaNominaId() {
		return datPlanillaNominaId;
	}

	public void setDatPlanillaNominaId(Long datPlanillaNominaId) {
		this.datPlanillaNominaId = datPlanillaNominaId;
	}

	public String getServicioNombre() {
		return servicioNombre;
	}

	public void setServicioNombre(String servicioNombre) {
		this.servicioNombre = servicioNombre;
	}

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

	public String getContratistaNombre() {
		return contratistaNombre;
	}

	public void setContratistaNombre(String contratistaNombre) {
		this.contratistaNombre = contratistaNombre;
	}

	public String getContratistaCodigo() {
		return contratistaCodigo;
	}

	public void setContratistaCodigo(String contratistaCodigo) {
		this.contratistaCodigo = contratistaCodigo;
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

	public Double getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getCierreCostos() {
		return cierreCostos;
	}

	public void setCierreCostos(String cierreCostos) {
		this.cierreCostos = cierreCostos;
	}

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

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDatServicioId() {
		return datServicioId;
	}

	public void setDatServicioId(Long datServicioId) {
		this.datServicioId = datServicioId;
	}

	public String getDocumetoErp() {
		return documetoErp;
	}

	public void setDocumetoErp(String documetoErp) {
		this.documetoErp = documetoErp;
	}

	public Double getEdadEjecucion() {
		return edadEjecucion;
	}

	public void setEdadEjecucion(Double edadEjecucion) {
		this.edadEjecucion = edadEjecucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
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

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
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

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public String getTiempoInactivo() {
		return tiempoInactivo;
	}

	public void setTiempoInactivo(String tiempoInactivo) {
		this.tiempoInactivo = tiempoInactivo;
	}

	public Double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Double totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}

	public Long getContratistaId_Contratista() {
		return contratistaId_Contratista;
	}

	public void setContratistaId_Contratista(Long contratistaId_Contratista) {
		this.contratistaId_Contratista = contratistaId_Contratista;
	}

	public Long getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public void setEquipoId_Equipo(Long equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
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

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

}
