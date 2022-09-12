package co.com.arcosoft.modelo;
// Generated 27-feb-2017 16:59:46 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatOtrosCostos generated by hbm2java
 */
public class DatOtrosCostos implements java.io.Serializable {

	private Long datOtrosCostosId;
	private ElementoCosto elementoCosto;
	private CentCost centCost;
	private Labor labor;
	private PersEmpr persEmpr;
	private Date fechaRegistro;
	private Long consecutivo;
	private String tipoTransaccion;
	private Long compania;
	private Long equipoId;
	private Long infraId;
	private String numFactura;
	private String serieFactura;
	private Double valorTotal;
	private String reglaDistribuccion;
	private String observacion;
	private Long usuarioDigitacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private String observacionAnularReg;
	private Date fechaAnulacion;
	

	private Set<DatOtrosCostosNivel4> datOtrosCostosNivel4s = new HashSet<DatOtrosCostosNivel4>(0);
	private Date fechaInicial;
	private Nivel2 nivel2Indicador;
	
	public DatOtrosCostos() {
	}

	public DatOtrosCostos(Long datOtrosCostosId) {
		this.datOtrosCostosId = datOtrosCostosId;
	}

	public DatOtrosCostos(Long datOtrosCostosId, ElementoCosto elementoCosto, CentCost centCost, Labor labor,
			PersEmpr persEmpr, Date fechaRegistro, Long consecutivo, String tipoTransaccion, Long compania,
			Long equipoId, Long infraId, String numFactura, String serieFactura, Double valorTotal,
			String reglaDistribuccion, String observacion, Long usuarioDigitacion, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			String observacionAnularReg, Date fechaAnulacion, Set<DatOtrosCostosNivel4> datOtrosCostosNivel4s,
			Date fechaInicial, Nivel2  nivel2Indicador) {
		this.datOtrosCostosId = datOtrosCostosId;
		this.elementoCosto = elementoCosto;
		this.centCost = centCost;
		this.labor = labor;
		this.persEmpr = persEmpr;
		this.fechaRegistro = fechaRegistro;
		this.consecutivo = consecutivo;
		this.tipoTransaccion = tipoTransaccion;
		this.compania = compania;
		this.equipoId = equipoId;
		this.infraId = infraId;
		this.numFactura = numFactura;
		this.serieFactura = serieFactura;
		this.valorTotal = valorTotal;
		this.reglaDistribuccion = reglaDistribuccion;
		this.observacion = observacion;
		this.usuarioDigitacion = usuarioDigitacion;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.observacionAnularReg = observacionAnularReg;
		this.fechaAnulacion = fechaAnulacion;
		this.datOtrosCostosNivel4s = datOtrosCostosNivel4s;
		this.fechaInicial = fechaInicial;
		this.nivel2Indicador=nivel2Indicador;
	}

	
	/**
	 * @return the nivel2Indicador
	 */
	public Nivel2 getNivel2Indicador() {
		return nivel2Indicador;
	}

	/**
	 * @param nivel2Indicador the nivel2Indicador to set
	 */
	public void setNivel2Indicador(Nivel2 nivel2Indicador) {
		this.nivel2Indicador = nivel2Indicador;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Long getDatOtrosCostosId() {
		return this.datOtrosCostosId;
	}

	public void setDatOtrosCostosId(Long datOtrosCostosId) {
		this.datOtrosCostosId = datOtrosCostosId;
	}

	public ElementoCosto getElementoCosto() {
		return this.elementoCosto;
	}

	public void setElementoCosto(ElementoCosto elementoCosto) {
		this.elementoCosto = elementoCosto;
	}

	public CentCost getCentCost() {
		return this.centCost;
	}

	public void setCentCost(CentCost centCost) {
		this.centCost = centCost;
	}

	public Labor getLabor() {
		return this.labor;
	}

	public void setLabor(Labor labor) {
		this.labor = labor;
	}

	public PersEmpr getPersEmpr() {
		return this.persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getEquipoId() {
		return this.equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}

	public Long getInfraId() {
		return this.infraId;
	}

	public void setInfraId(Long infraId) {
		this.infraId = infraId;
	}

	public String getNumFactura() {
		return this.numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public String getSerieFactura() {
		return this.serieFactura;
	}

	public void setSerieFactura(String serieFactura) {
		this.serieFactura = serieFactura;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getReglaDistribuccion() {
		return this.reglaDistribuccion;
	}

	public void setReglaDistribuccion(String reglaDistribuccion) {
		this.reglaDistribuccion = reglaDistribuccion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Set<DatOtrosCostosNivel4> getDatOtrosCostosNivel4s() {
		return this.datOtrosCostosNivel4s;
	}

	public void setDatOtrosCostosNivel4s(Set<DatOtrosCostosNivel4> datOtrosCostosNivel4s) {
		this.datOtrosCostosNivel4s = datOtrosCostosNivel4s;
	}

}