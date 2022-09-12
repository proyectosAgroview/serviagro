package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaMttoDTO {
	
	private String nombreCompania;
	private Date fechaRegistro;
	private Date fechaRegistro2;
	private String codEquipo;
	private String nomEquipo;
	private String codTipoMtto;
	private String nomTipoMtto;	
	private BigInteger consecutivo;
	private String cenCosto;
	private String tallerMecanico;
	private BigDecimal horometroE;
	private BigDecimal odometroE;
	private String nomPlanRevision;
	private String nomMotivoEntradaTaller;
	private String nomAgenteCausadorParadas;
	private String duracionPrevista;
	private BigDecimal duracionReal;
	private String codSolicitante;
	private String nomSolicitante;
	private String codConductor;
	private String nomConductor;
	private String reporteTecnico;
	private String fechaTrabajoMec;
	private String mecanico;
	private String nomCeptoNomina;
	private String nomUdadMed;
	private BigDecimal cantidadMec;
	private BigDecimal tarifaMec;
	private BigDecimal costoTotalMec;
	private String almacenSalida;
	private String autoriza;
	private String producto;
	private String umProducto;
	private BigDecimal cantidad;
	private BigDecimal valorUnitario;
	private BigDecimal costoTotal;
	private BigInteger datMantenimientoEquipo;
	private String codTag;
	private String nomTag;
	private String tarea;
	private Integer anio;
	private String mesCorto;
	private String codSistemaEquipo;
	private String nomSistemaEquipo;
	private String codCompartimientoEquipo;
	private String nomCompartimientoEquipo;
	
	
	public String getNombreCompania() {
		return nombreCompania;
	}
	
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	
	public String getCodEquipo() {
		return codEquipo;
	}
	
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	
	public String getNomEquipo() {
		return nomEquipo;
	}
	
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}
	
	public String getCodTipoMtto() {
		return codTipoMtto;
	}
	
	public void setCodTipoMtto(String codTipoMtto) {
		this.codTipoMtto = codTipoMtto;
	}
	
	public String getNomTipoMtto() {
		return nomTipoMtto;
	}
	
	public void setNomTipoMtto(String nomTipoMtto) {
		this.nomTipoMtto = nomTipoMtto;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaRegistro2() {
		return fechaRegistro2;
	}

	public void setFechaRegistro2(Date fechaRegistro2) {
		this.fechaRegistro2 = fechaRegistro2;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getCenCosto() {
		return cenCosto;
	}

	public void setCenCosto(String cenCosto) {
		this.cenCosto = cenCosto;
	}

	public String getTallerMecanico() {
		return tallerMecanico;
	}

	public void setTallerMecanico(String tallerMecanico) {
		this.tallerMecanico = tallerMecanico;
	}

	public BigDecimal getHorometroE() {
		return horometroE;
	}

	public void setHorometroE(BigDecimal horometroE) {
		this.horometroE = horometroE;
	}

	public BigDecimal getOdometroE() {
		return odometroE;
	}

	public void setOdometroE(BigDecimal odometroE) {
		this.odometroE = odometroE;
	}

	public String getNomPlanRevision() {
		return nomPlanRevision;
	}

	public void setNomPlanRevision(String nomPlanRevision) {
		this.nomPlanRevision = nomPlanRevision;
	}

	public String getNomAgenteCausadorParadas() {
		return nomAgenteCausadorParadas;
	}

	public void setNomAgenteCausadorParadas(String nomAgenteCausadorParadas) {
		this.nomAgenteCausadorParadas = nomAgenteCausadorParadas;
	}

	public String getDuracionPrevista() {
		return duracionPrevista;
	}

	public void setDuracionPrevista(String duracionPrevista) {
		this.duracionPrevista = duracionPrevista;
	}

	public BigDecimal getDuracionReal() {
		return duracionReal;
	}

	public void setDuracionReal(BigDecimal duracionReal) {
		this.duracionReal = duracionReal;
	}

	public String getCodSolicitante() {
		return codSolicitante;
	}

	public void setCodSolicitante(String codSolicitante) {
		this.codSolicitante = codSolicitante;
	}

	public String getNomSolicitante() {
		return nomSolicitante;
	}

	public void setNomSolicitante(String nomSolicitante) {
		this.nomSolicitante = nomSolicitante;
	}

	public String getCodConductor() {
		return codConductor;
	}

	public void setCodConductor(String codConductor) {
		this.codConductor = codConductor;
	}

	public String getNomConductor() {
		return nomConductor;
	}

	public void setNomConductor(String nomConductor) {
		this.nomConductor = nomConductor;
	}

	public String getReporteTecnico() {
		return reporteTecnico;
	}

	public void setReporteTecnico(String reporteTecnico) {
		this.reporteTecnico = reporteTecnico;
	}

	public String getFechaTrabajoMec() {
		return fechaTrabajoMec;
	}

	public void setFechaTrabajoMec(String fechaTrabajoMec) {
		this.fechaTrabajoMec = fechaTrabajoMec;
	}

	public String getMecanico() {
		return mecanico;
	}

	public void setMecanico(String mecanico) {
		this.mecanico = mecanico;
	}

	public String getNomCeptoNomina() {
		return nomCeptoNomina;
	}

	public void setNomCeptoNomina(String nomCeptoNomina) {
		this.nomCeptoNomina = nomCeptoNomina;
	}

	public String getNomUdadMed() {
		return nomUdadMed;
	}

	public void setNomUdadMed(String nomUdadMed) {
		this.nomUdadMed = nomUdadMed;
	}

	public BigDecimal getCantidadMec() {
		return cantidadMec;
	}

	public void setCantidadMec(BigDecimal cantidadMec) {
		this.cantidadMec = cantidadMec;
	}

	public BigDecimal getTarifaMec() {
		return tarifaMec;
	}

	public void setTarifaMec(BigDecimal tarifaMec) {
		this.tarifaMec = tarifaMec;
	}

	public BigDecimal getCostoTotalMec() {
		return costoTotalMec;
	}

	public void setCostoTotalMec(BigDecimal costoTotalMec) {
		this.costoTotalMec = costoTotalMec;
	}

	public String getAlmacenSalida() {
		return almacenSalida;
	}

	public void setAlmacenSalida(String almacenSalida) {
		this.almacenSalida = almacenSalida;
	}

	public String getAutoriza() {
		return autoriza;
	}

	public void setAutoriza(String autoriza) {
		this.autoriza = autoriza;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getUmProducto() {
		return umProducto;
	}

	public void setUmProducto(String umProducto) {
		this.umProducto = umProducto;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getNomMotivoEntradaTaller() {
		return nomMotivoEntradaTaller;
	}

	public void setNomMotivoEntradaTaller(String nomMotivoEntradaTaller) {
		this.nomMotivoEntradaTaller = nomMotivoEntradaTaller;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public BigInteger getDatMantenimientoEquipo() {
		return datMantenimientoEquipo;
	}

	public void setDatMantenimientoEquipo(BigInteger datMantenimientoEquipo) {
		this.datMantenimientoEquipo = datMantenimientoEquipo;
	}

	public String getCodTag() {
		return codTag;
	}

	public void setCodTag(String codTag) {
		this.codTag = codTag;
	}

	public String getNomTag() {
		return nomTag;
	}

	public void setNomTag(String nomTag) {
		this.nomTag = nomTag;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getMesCorto() {
		return mesCorto;
	}

	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}

	public String getCodSistemaEquipo() {
		return codSistemaEquipo;
	}

	public void setCodSistemaEquipo(String codSistemaEquipo) {
		this.codSistemaEquipo = codSistemaEquipo;
	}

	public String getNomSistemaEquipo() {
		return nomSistemaEquipo;
	}

	public void setNomSistemaEquipo(String nomSistemaEquipo) {
		this.nomSistemaEquipo = nomSistemaEquipo;
	}

	public String getCodCompartimientoEquipo() {
		return codCompartimientoEquipo;
	}

	public void setCodCompartimientoEquipo(String codCompartimientoEquipo) {
		this.codCompartimientoEquipo = codCompartimientoEquipo;
	}

	public String getNomCompartimientoEquipo() {
		return nomCompartimientoEquipo;
	}

	public void setNomCompartimientoEquipo(String nomCompartimientoEquipo) {
		this.nomCompartimientoEquipo = nomCompartimientoEquipo;
	}

}
