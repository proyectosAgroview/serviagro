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
public class DatPlanillaNominaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanillaNominaDTO.class);
	private Long NPases;
	private Long anio;
	private Double cantidadPago;
	private Double cantidadProd;
	private String cierreCostos;
	private Long compania;
	private Long consecutivo;
	private Double costoTotal;
	private String documetoErp;
	private Double edadEjecucion;
	private String estado;
	private Long etapaId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
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
	private Long planillaNominaId;
	private Float precision;
	private Long udadMedPago;
	private Long usuarioDigitacion;
	private Double valorUnitario;
	private Long variedId;
	private Long ceptoNominaId_ConceptoNomina;
	private Long contratistaId_Contratista;
	private Long eqpTrabId_EquipoTrabajo;
	private Long laborId_Labor;
	private Long nivel4Id_Nivel4;
	private Long trabId_Trabajador;
	private Long udadMedId_UdadMed;

	private String laborNombre;
	private String nivel1Nombre;
	private String nivel2Nombre;
	private String nivel3Nombre;
	private String nivel4Nombre;
	private String trabajadorCodigo;
	private String trabajadorNombre;
	private String udadMedNombre;
	private String conceptoNomiNombre;
	private String estadoTrue;
	private Long numeroTiquete;
	private Double pesoPromedio;
	private Long colorIdentificador;

	private String origenDatos;
	
	private String tipoVisita;
	private String estadoPlanilla;
	private Date fechaCierrePlanilla;
	private Date fechaReAberturaPlanilla;
	private Long usuarioCierrePlanilla;

	public String getTipoVisita() {
		return tipoVisita;
	}

	public void setTipoVisita(String tipoVisita) {
		this.tipoVisita = tipoVisita;
	}

	public String getEstadoPlanilla() {
		return estadoPlanilla;
	}

	public void setEstadoPlanilla(String estadoPlanilla) {
		this.estadoPlanilla = estadoPlanilla;
	}

	public Date getFechaCierrePlanilla() {
		return fechaCierrePlanilla;
	}

	public void setFechaCierrePlanilla(Date fechaCierrePlanilla) {
		this.fechaCierrePlanilla = fechaCierrePlanilla;
	}

	public Date getFechaReAberturaPlanilla() {
		return fechaReAberturaPlanilla;
	}

	public void setFechaReAberturaPlanilla(Date fechaReAberturaPlanilla) {
		this.fechaReAberturaPlanilla = fechaReAberturaPlanilla;
	}

	public Long getUsuarioCierrePlanilla() {
		return usuarioCierrePlanilla;
	}

	public void setUsuarioCierrePlanilla(Long usuarioCierrePlanilla) {
		this.usuarioCierrePlanilla = usuarioCierrePlanilla;
	}

	public Long getNumeroTiquete() {
		return numeroTiquete;
	}

	public void setNumeroTiquete(Long numeroTiquete) {
		this.numeroTiquete = numeroTiquete;
	}

	public Double getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public Long getColorIdentificador() {
		return colorIdentificador;
	}

	public void setColorIdentificador(Long colorIdentificador) {
		this.colorIdentificador = colorIdentificador;
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

	public String getTrabajadorCodigo() {
		return trabajadorCodigo;
	}

	public void setTrabajadorCodigo(String trabajadorCodigo) {
		this.trabajadorCodigo = trabajadorCodigo;
	}

	public String getTrabajadorNombre() {
		return trabajadorNombre;
	}

	public void setTrabajadorNombre(String trabajadorNombre) {
		this.trabajadorNombre = trabajadorNombre;
	}

	public String getUdadMedNombre() {
		return udadMedNombre;
	}

	public void setUdadMedNombre(String udadMedNombre) {
		this.udadMedNombre = udadMedNombre;
	}

	public String getConceptoNomiNombre() {
		return conceptoNomiNombre;
	}

	public void setConceptoNomiNombre(String conceptoNomiNombre) {
		this.conceptoNomiNombre = conceptoNomiNombre;
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

	public Double getCantidadProd() {
		return cantidadProd;
	}

	public void setCantidadProd(Double cantidadProd) {
		this.cantidadProd = cantidadProd;
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

	public Long getPlanillaNominaId() {
		return planillaNominaId;
	}

	public void setPlanillaNominaId(Long planillaNominaId) {
		this.planillaNominaId = planillaNominaId;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public Long getUdadMedPago() {
		return udadMedPago;
	}

	public void setUdadMedPago(Long udadMedPago) {
		this.udadMedPago = udadMedPago;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}

	public Long getCeptoNominaId_ConceptoNomina() {
		return ceptoNominaId_ConceptoNomina;
	}

	public void setCeptoNominaId_ConceptoNomina(Long ceptoNominaId_ConceptoNomina) {
		this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
	}

	public Long getContratistaId_Contratista() {
		return contratistaId_Contratista;
	}

	public void setContratistaId_Contratista(Long contratistaId_Contratista) {
		this.contratistaId_Contratista = contratistaId_Contratista;
	}

	public Long getEqpTrabId_EquipoTrabajo() {
		return eqpTrabId_EquipoTrabajo;
	}

	public void setEqpTrabId_EquipoTrabajo(Long eqpTrabId_EquipoTrabajo) {
		this.eqpTrabId_EquipoTrabajo = eqpTrabId_EquipoTrabajo;
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

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

}
