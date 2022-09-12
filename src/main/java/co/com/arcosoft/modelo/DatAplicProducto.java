package co.com.arcosoft.modelo;

// Generated 15-sep-2015 10:09:32 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatAplicProducto generated by hbm2java
 */
public class DatAplicProducto implements java.io.Serializable {

	private Long datAplicProdId;
	private Nivel4 nivel4;
	private Labor labor;
	private Long almacen;
	private Long trabajador;
	private Long consecutivo;
	public Long compania;
	private Long anio;
	private Date fechaRegistro;
	private DatPlanLaborDet ordenTrabajo;
	private Long NPases;
	private Long nivel1Id;
	private Nivel2 nivel2Id;
	private Long nivel3Id;
	private Double edadEjecucion;
	private Long etapaId;
	private Long variedId;
	private String cierreCostos;
	private String observacion;
	private String idMobile;
	private Float latitud;
	private Float longitud;
	private Float precision;
	private Long usuarioDigitacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private String observacionAnularReg;
	private String documetoErp;
	private Date fechaAnulacion;
	private Double areaAplicada;
	private Long nroPlantas;
	private Double numTinas;
	private Long datPlanillaNominaId;
	private Set<DatAplicProdDet> datAplicProdDets = new HashSet<DatAplicProdDet>(0);
	private Set<DatAplicProdDet> datAplicProdDets_1 = new HashSet<DatAplicProdDet>(0);

	public DatAplicProducto() {
	}

	public DatAplicProducto(Long datAplicProdId) {
		this.datAplicProdId = datAplicProdId;
	}

	public DatAplicProducto(Long datAplicProdId, Nivel4 nivel4, Labor labor, Long almacen, Long trabajador,
			Long consecutivo, Long compania, Long anio, Date fechaRegistro, Long nroPlantas,
			DatPlanLaborDet ordenTrabajo, Long NPases, Long nivel1Id, DatPlanillaNomina datPlanillaNominaId,
			Nivel2 nivel2Id, Long nivel3Id, Double edadEjecucion, Long etapaId, Long variedId, String cierreCostos,
			String observacion, String idMobile, Float latitud, Float longitud, Float precision, Long usuarioDigitacion,
			String infoAdicional, Double numTinas, String infoAdicional2, Date fechaCreacion, Date fechaModificacion,
			String estado, String observacionAnularReg, String documetoErp, Set<DatAplicProdDet> datAplicProdDets,
			Double areaAplicada, Set<DatAplicProdDet> datAplicProdDets_1, Date fechaAnulacion) {
		this.datAplicProdId = datAplicProdId;
		this.nivel4 = nivel4;
		this.labor = labor;
		this.almacen = almacen;
		this.numTinas = numTinas;
		this.trabajador = trabajador;
		this.consecutivo = consecutivo;
		this.compania = compania;
		this.anio = anio;
		this.fechaRegistro = fechaRegistro;
		this.ordenTrabajo = ordenTrabajo;
		this.NPases = NPases;
		this.nivel1Id = nivel1Id;
		this.nivel2Id = nivel2Id;
		this.nivel3Id = nivel3Id;
		this.edadEjecucion = edadEjecucion;
		this.etapaId = etapaId;
		this.variedId = variedId;
		this.cierreCostos = cierreCostos;
		this.observacion = observacion;
		this.idMobile = idMobile;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precision = precision;
		this.usuarioDigitacion = usuarioDigitacion;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.observacionAnularReg = observacionAnularReg;
		this.documetoErp = documetoErp;
		this.datAplicProdDets = datAplicProdDets;
		this.datAplicProdDets_1 = datAplicProdDets_1;
		this.fechaAnulacion = fechaAnulacion;
		this.areaAplicada = areaAplicada;
	}

	public Long getNroPlantas() {
		return nroPlantas;
	}

	public void setNroPlantas(Long nroPlantas) {
		this.nroPlantas = nroPlantas;
	}

	public Long getDatPlanillaNominaId() {
		return datPlanillaNominaId;
	}

	public void setDatPlanillaNominaId(Long datPlanillaNominaId) {
		this.datPlanillaNominaId = datPlanillaNominaId;
	}

	public Long getDatAplicProdId() {
		return this.datAplicProdId;
	}

	public void setDatAplicProdId(Long datAplicProdId) {
		this.datAplicProdId = datAplicProdId;
	}

	public Nivel4 getNivel4() {
		return this.nivel4;
	}

	public void setNivel4(Nivel4 nivel4) {
		this.nivel4 = nivel4;
	}

	public Double getNumTinas() {
		return numTinas;
	}

	public void setNumTinas(Double numTinas) {
		this.numTinas = numTinas;
	}

	public Labor getLabor() {
		return this.labor;
	}

	public void setLabor(Labor labor) {
		this.labor = labor;
	}

	public Long getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(Long almacen) {
		this.almacen = almacen;
	}

	public Long getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Long trabajador) {
		this.trabajador = trabajador;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getAnio() {
		return this.anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public DatPlanLaborDet getOrdenTrabajo() {
		return this.ordenTrabajo;
	}

	public void setOrdenTrabajo(DatPlanLaborDet ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public Long getNPases() {
		return this.NPases;
	}

	public void setNPases(Long NPases) {
		this.NPases = NPases;
	}

	public Long getNivel1Id() {
		return this.nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Nivel2 getNivel2Id() {
		return this.nivel2Id;
	}

	public void setNivel2Id(Nivel2 nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Long getNivel3Id() {
		return this.nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Double getEdadEjecucion() {
		return this.edadEjecucion;
	}

	public void setEdadEjecucion(Double edadEjecucion) {
		this.edadEjecucion = edadEjecucion;
	}

	public Long getEtapaId() {
		return this.etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Long getVariedId() {
		return this.variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}

	public String getCierreCostos() {
		return this.cierreCostos;
	}

	public void setCierreCostos(String cierreCostos) {
		this.cierreCostos = cierreCostos;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getIdMobile() {
		return this.idMobile;
	}

	public void setIdMobile(String idMobile) {
		this.idMobile = idMobile;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getPrecision() {
		return this.precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public Long getUsuarioDigitacion() {
		return this.usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
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

	public String getObservacionAnularReg() {
		return this.observacionAnularReg;
	}

	public void setObservacionAnularReg(String observacionAnularReg) {
		this.observacionAnularReg = observacionAnularReg;
	}

	public String getDocumetoErp() {
		return this.documetoErp;
	}

	public void setDocumetoErp(String documetoErp) {
		this.documetoErp = documetoErp;
	}

	public Set<DatAplicProdDet> getDatAplicProdDets() {
		return this.datAplicProdDets;
	}

	public void setDatAplicProdDets(Set<DatAplicProdDet> datAplicProdDets) {
		this.datAplicProdDets = datAplicProdDets;
	}

	public Set<DatAplicProdDet> getDatAplicProdDets_1() {
		return this.datAplicProdDets_1;
	}

	public void setDatAplicProdDets_1(Set<DatAplicProdDet> datAplicProdDets_1) {
		this.datAplicProdDets_1 = datAplicProdDets_1;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Double getAreaAplicada() {
		return this.areaAplicada;
	}

	public void setAreaAplicada(Double areaAplicada) {
		this.areaAplicada = areaAplicada;
	}

}
