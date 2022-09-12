package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.SistemaRiego;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.TurnoCampo;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatRiegoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatRiegoDTO.class);
	private Long NPases;
	private Long anio;
	private Double areaRegada;
	private Double caudalInfraestructura;
	private Double caudalNivel4;
	private String cierreCostos;
	private Long compania;
	private Long consecutivo;
	private Double costoTotal;
	private Long datRiegoId;
	private Double edadEjecucion;
	private String estado;
	private Long etapaId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private Date horaFinInfra;
	private Date horaFinNivel4;
	private Date horaIniInfra;
	private Date horaIniNivel4;
	private Double horaTotalInfra;
	private Double horaTotalNivel4;
	private String idMobile;
	private String infoAdicional;
	private String infoAdicional2;
	private Float latitud;
	private Float longitud;
	private Long nivel1Id;
	private Nivel2 nivel2Id;
	private Long nivel3Id;
	private String observacion;
	private String observacionAnularReg;
	private DatPlanLaborDet ordenTrabajo;
	private Float precision;
	private Long usuarioDigitacion;
	private Double valorUnit;
	private Long variedId;
	private Double volM3Infra;
	private Double volM3Nivel4;
	private Double volTotalInfra;
	private Double volTotalNivel4;
	private Infraestructura infraId_Infraestructura;
	private Labor laborId_Labor;
	private Nivel4 nivel4Id_Nivel4;
	private SistemaRiego sistemaRiegoId_SistemaRiego;
	private Trabajador trabId_Trabajador;

	private String laborNombre;
	private String nivel1Nombre;
	private String nivel2Nombre;
	private String nivel3Nombre;
	private String nivel4Nombre;
	private String sistemaRieNombre;
	private String trabajadorCodigo;
	private String trabajadorNombre;
	
	private String estadoTrue;
	private Long datPlanillaNominaId;
	private String nombreInfraestructura;
	private TurnoCampo turnoCampoId;
	
	private Double kwhIncial;
	private Double kwhFinal;
	private Double surcosLargos;
	private Double surcosCortos;
	private Double totalAreaRegada;
	private Double totalHorometro;
	
	private Double numeroRiegos;
	private Double horometroInicial;
	private Double horometroFinal;
	
	private String codigoTurnoCampo;
	
	
	
	
	
	
	
	public String getCodigoTurnoCampo() {
		return codigoTurnoCampo;
	}
	public void setCodigoTurnoCampo(String codigoTurnoCampo) {
		this.codigoTurnoCampo = codigoTurnoCampo;
	}
	public Double getHorometroInicial() {
		return horometroInicial;
	}
	public void setHorometroInicial(Double horometroInicial) {
		this.horometroInicial = horometroInicial;
	}
	public Double getHorometroFinal() {
		return horometroFinal;
	}
	public void setHorometroFinal(Double horometroFinal) {
		this.horometroFinal = horometroFinal;
	}
	public Double getKwhIncial() {
		return kwhIncial;
	}
	public void setKwhIncial(Double kwhIncial) {
		this.kwhIncial = kwhIncial;
	}
	public Double getKwhFinal() {
		return kwhFinal;
	}
	public void setKwhFinal(Double kwhFinal) {
		this.kwhFinal = kwhFinal;
	}
	public Double getSurcosLargos() {
		return surcosLargos;
	}
	public void setSurcosLargos(Double surcosLargos) {
		this.surcosLargos = surcosLargos;
	}
	public Double getSurcosCortos() {
		return surcosCortos;
	}
	public void setSurcosCortos(Double surcosCortos) {
		this.surcosCortos = surcosCortos;
	}
	public Double getTotalAreaRegada() {
		return totalAreaRegada;
	}
	public void setTotalAreaRegada(Double totalAreaRegada) {
		this.totalAreaRegada = totalAreaRegada;
	}
	public Double getTotalHorometro() {
		return totalHorometro;
	}
	public void setTotalHorometro(Double totalHorometro) {
		this.totalHorometro = totalHorometro;
	}
	
	public Double getNumeroRiegos() {
		return numeroRiegos;
	}
	public void setNumeroRiegos(Double numeroRiegos) {
		this.numeroRiegos = numeroRiegos;
	}
	public Long getNPases() {
		return NPases;
	}
	public void setNPases(Long nPases) {
		NPases = nPases;
	}
	public Long getAnio() {
		return anio;
	}
	public void setAnio(Long anio) {
		this.anio = anio;
	}
	public Double getAreaRegada() {
		return areaRegada;
	}
	public void setAreaRegada(Double areaRegada) {
		this.areaRegada = areaRegada;
	}
	public Double getCaudalInfraestructura() {
		return caudalInfraestructura;
	}
	public void setCaudalInfraestructura(Double caudalInfraestructura) {
		this.caudalInfraestructura = caudalInfraestructura;
	}
	public Double getCaudalNivel4() {
		return caudalNivel4;
	}
	public void setCaudalNivel4(Double caudalNivel4) {
		this.caudalNivel4 = caudalNivel4;
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
	public Long getDatRiegoId() {
		return datRiegoId;
	}
	public void setDatRiegoId(Long datRiegoId) {
		this.datRiegoId = datRiegoId;
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
	public Date getHoraFinInfra() {
		return horaFinInfra;
	}
	public void setHoraFinInfra(Date horaFinInfra) {
		this.horaFinInfra = horaFinInfra;
	}
	public Date getHoraFinNivel4() {
		return horaFinNivel4;
	}
	public void setHoraFinNivel4(Date horaFinNivel4) {
		this.horaFinNivel4 = horaFinNivel4;
	}
	public Date getHoraIniInfra() {
		return horaIniInfra;
	}
	public void setHoraIniInfra(Date horaIniInfra) {
		this.horaIniInfra = horaIniInfra;
	}
	public Date getHoraIniNivel4() {
		return horaIniNivel4;
	}
	public void setHoraIniNivel4(Date horaIniNivel4) {
		this.horaIniNivel4 = horaIniNivel4;
	}
	public Double getHoraTotalInfra() {
		return horaTotalInfra;
	}
	public void setHoraTotalInfra(Double horaTotalInfra) {
		this.horaTotalInfra = horaTotalInfra;
	}
	public Double getHoraTotalNivel4() {
		return horaTotalNivel4;
	}
	public void setHoraTotalNivel4(Double horaTotalNivel4) {
		this.horaTotalNivel4 = horaTotalNivel4;
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
	public Nivel2 getNivel2Id() {
		return nivel2Id;
	}
	public void setNivel2Id(Nivel2 nivel2Id) {
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
	public DatPlanLaborDet getOrdenTrabajo() {
		return ordenTrabajo;
	}
	public void setOrdenTrabajo(DatPlanLaborDet ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
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
	public Double getVolM3Infra() {
		return volM3Infra;
	}
	public void setVolM3Infra(Double volM3Infra) {
		this.volM3Infra = volM3Infra;
	}
	public Double getVolM3Nivel4() {
		return volM3Nivel4;
	}
	public void setVolM3Nivel4(Double volM3Nivel4) {
		this.volM3Nivel4 = volM3Nivel4;
	}
	public Double getVolTotalInfra() {
		return volTotalInfra;
	}
	public void setVolTotalInfra(Double volTotalInfra) {
		this.volTotalInfra = volTotalInfra;
	}
	public Double getVolTotalNivel4() {
		return volTotalNivel4;
	}
	public void setVolTotalNivel4(Double volTotalNivel4) {
		this.volTotalNivel4 = volTotalNivel4;
	}
	public Infraestructura getInfraId_Infraestructura() {
		return infraId_Infraestructura;
	}
	public void setInfraId_Infraestructura(Infraestructura infraId_Infraestructura) {
		this.infraId_Infraestructura = infraId_Infraestructura;
	}
	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}
	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}
	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}
	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}
	public SistemaRiego getSistemaRiegoId_SistemaRiego() {
		return sistemaRiegoId_SistemaRiego;
	}
	public void setSistemaRiegoId_SistemaRiego(SistemaRiego sistemaRiegoId_SistemaRiego) {
		this.sistemaRiegoId_SistemaRiego = sistemaRiegoId_SistemaRiego;
	}
	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}
	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
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
	public String getSistemaRieNombre() {
		return sistemaRieNombre;
	}
	public void setSistemaRieNombre(String sistemaRieNombre) {
		this.sistemaRieNombre = sistemaRieNombre;
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
	public String getEstadoTrue() {
		return estadoTrue;
	}
	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}
	public Long getDatPlanillaNominaId() {
		return datPlanillaNominaId;
	}
	public void setDatPlanillaNominaId(Long datPlanillaNominaId) {
		this.datPlanillaNominaId = datPlanillaNominaId;
	}
	public String getNombreInfraestructura() {
		return nombreInfraestructura;
	}
	public void setNombreInfraestructura(String nombreInfraestructura) {
		this.nombreInfraestructura = nombreInfraestructura;
	}
	public TurnoCampo getTurnoCampoId() {
		return turnoCampoId;
	}
	public void setTurnoCampoId(TurnoCampo turnoCampoId) {
		this.turnoCampoId = turnoCampoId;
	}
	
	
	
}
