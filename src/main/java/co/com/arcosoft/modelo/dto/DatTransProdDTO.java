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
public class DatTransProdDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdDTO.class);
	private Long anioFiscalNivel4;
	private Long compania;
	private Long consecutivo;
	private Long consecutivoPesoNeto;
	private Long datTransProdId;
	private String destinoProduccion;
	private Double edadNivel4;
	private String estado;
	private Long etapaNivel4;
	private Long faseFenoNivel4;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaRegistro;
	private String infoAdicional;
	private String infoAdicional2;
	private String mobileId;
	private Long nivel1Id;
	private Long nivel2Id;
	private Long nivel3Id;
	private String observacion;
	private String observacionAnularReg;
	private String tipoTransaccion;
	private Long usuarioDigitacion;
	private Long variedNivel4;
	private Long empresaCompradora;
	private Long conductorId_Conductor;
	private Long frtCosId_FrenteCos;
	private Long modalidadCosId_ModalidadCosecha;
	private Long nivel4Id_Nivel4;
	private Long proveId_Proveedor;
	private Long transpId_Transportadora;
	private Long vehiTranspId_VehiculosTransp;
	private String estadoTrue;
	private Date fechaAnulacion;
	private Date fechaEstadoVehiculo;
	private String vagon1;
	private String vagon2;
	private String vagon3;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Date fechaPesoBruto;
	private Date fechaTara;
	private Date fechaPesoNeto;
	private String numeroSellos;
	private Long basculaTara;
	private Long basculaPesoBruto;
	private Long usuarioPesoTara;
	private Long usuarioPesoBruto;
	private Double pesoBruto;
	private Double pesoTara;
	private Double pesoNeto;
	private Double variable1;
	private Double variable2;
	private Double variable3;
	private Double variable4;
	private Double variable5;
	private Double variable6;
	private Double variable7;
	private Double variable8;
	private Double variable9;
	private Double variable10;
	private String observacionAnalisis;
	private String observacion2;
	private String observacion3;
	private Double valorUnitario;
	private Double valorTotal;
	private Double valorDeduccion;
	private Double valorNeto;
	private Double cantidadKilosLiq;
	private Date fechaInicial;
	private String sello1;
	private String sello2;
	private String sello3;
	private String sello4;
	private String sello5;
	private String sello6;
	private String sello7;
	private String sello8;
	private String sello9;
	private String sello10;
	private String tipoPesajeBruto;
	private String tipoPesajeTara;
	private String noDocumento;
	private String origen;
	private String nombrePeso;
	private String nombrePeso2;
	private String nomUsuarioDigitacion;
	private String variableTexto1;
	

	public String getVariableTexto1() {
		return variableTexto1;
	}

	public void setVariableTexto1(String variableTexto1) {
		this.variableTexto1 = variableTexto1;
	}

	/**
	 * @return the tipoPesajeBruto
	 */
	public String getTipoPesajeBruto() {
		return tipoPesajeBruto;
	}

	/**
	 * @param tipoPesajeBruto the tipoPesajeBruto to set
	 */
	public void setTipoPesajeBruto(String tipoPesajeBruto) {
		this.tipoPesajeBruto = tipoPesajeBruto;
	}

	/**
	 * @return the tipoPesajeTara
	 */
	public String getTipoPesajeTara() {
		return tipoPesajeTara;
	}

	/**
	 * @param tipoPesajeTara the tipoPesajeTara to set
	 */
	public void setTipoPesajeTara(String tipoPesajeTara) {
		this.tipoPesajeTara = tipoPesajeTara;
	}

	public String getSello1() {
		return sello1;
	}

	public void setSello1(String sello1) {
		this.sello1 = sello1;
	}

	public String getSello2() {
		return sello2;
	}

	public void setSello2(String sello2) {
		this.sello2 = sello2;
	}

	public String getSello3() {
		return sello3;
	}

	public void setSello3(String sello3) {
		this.sello3 = sello3;
	}

	public String getSello4() {
		return sello4;
	}

	public void setSello4(String sello4) {
		this.sello4 = sello4;
	}

	public String getSello5() {
		return sello5;
	}

	public void setSello5(String sello5) {
		this.sello5 = sello5;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public Double getValorNeto() {
		return valorNeto;
	}

	public void setValorNeto(Double valorNeto) {
		this.valorNeto = valorNeto;
	}

	public Double getCantidadKilosLiq() {
		return cantidadKilosLiq;
	}

	public void setCantidadKilosLiq(Double cantidadKilosLiq) {
		this.cantidadKilosLiq = cantidadKilosLiq;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getObservacionAnalisis() {
		return observacionAnalisis;
	}

	public void setObservacionAnalisis(String observacionAnalisis) {
		this.observacionAnalisis = observacionAnalisis;
	}

	public String getVagon1() {
		return vagon1;
	}

	public void setVagon1(String vagon1) {
		this.vagon1 = vagon1;
	}

	public String getVagon2() {
		return vagon2;
	}

	public void setVagon2(String vagon2) {
		this.vagon2 = vagon2;
	}

	public String getVagon3() {
		return vagon3;
	}

	public void setVagon3(String vagon3) {
		this.vagon3 = vagon3;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaPesoBruto() {
		return fechaPesoBruto;
	}

	public void setFechaPesoBruto(Date fechaPesoBruto) {
		this.fechaPesoBruto = fechaPesoBruto;
	}

	public Date getFechaTara() {
		return fechaTara;
	}

	public void setFechaTara(Date fechaTara) {
		this.fechaTara = fechaTara;
	}

	public Date getFechaPesoNeto() {
		return fechaPesoNeto;
	}

	public void setFechaPesoNeto(Date fechaPesoNeto) {
		this.fechaPesoNeto = fechaPesoNeto;
	}

	public String getNumeroSellos() {
		return numeroSellos;
	}

	public void setNumeroSellos(String numeroSellos) {
		this.numeroSellos = numeroSellos;
	}

	public Long getBasculaTara() {
		return basculaTara;
	}

	public void setBasculaTara(Long basculaTara) {
		this.basculaTara = basculaTara;
	}

	public Long getBasculaPesoBruto() {
		return basculaPesoBruto;
	}

	public void setBasculaPesoBruto(Long basculaPesoBruto) {
		this.basculaPesoBruto = basculaPesoBruto;
	}

	public Long getUsuarioPesoTara() {
		return usuarioPesoTara;
	}

	public void setUsuarioPesoTara(Long usuarioPesoTara) {
		this.usuarioPesoTara = usuarioPesoTara;
	}

	public Long getUsuarioPesoBruto() {
		return usuarioPesoBruto;
	}

	public void setUsuarioPesoBruto(Long usuarioPesoBruto) {
		this.usuarioPesoBruto = usuarioPesoBruto;
	}

	public Double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Double getPesoTara() {
		return pesoTara;
	}

	public void setPesoTara(Double pesoTara) {
		this.pesoTara = pesoTara;
	}

	public Double getPesoNeto() {
		return pesoNeto;
	}

	public void setPesoNeto(Double pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public Double getVariable1() {
		return variable1;
	}

	public void setVariable1(Double variable1) {
		this.variable1 = variable1;
	}

	public Double getVariable2() {
		return variable2;
	}

	public void setVariable2(Double variable2) {
		this.variable2 = variable2;
	}

	public Double getVariable3() {
		return variable3;
	}

	public void setVariable3(Double variable3) {
		this.variable3 = variable3;
	}

	public Double getVariable4() {
		return variable4;
	}

	public void setVariable4(Double variable4) {
		this.variable4 = variable4;
	}

	public Double getVariable5() {
		return variable5;
	}

	public void setVariable5(Double variable5) {
		this.variable5 = variable5;
	}

	public Double getVariable6() {
		return variable6;
	}

	public void setVariable6(Double variable6) {
		this.variable6 = variable6;
	}

	public Double getVariable7() {
		return variable7;
	}

	public void setVariable7(Double variable7) {
		this.variable7 = variable7;
	}

	public Double getVariable8() {
		return variable8;
	}

	public void setVariable8(Double variable8) {
		this.variable8 = variable8;
	}

	public Double getVariable9() {
		return variable9;
	}

	public void setVariable9(Double variable9) {
		this.variable9 = variable9;
	}

	public Double getVariable10() {
		return variable10;
	}

	public void setVariable10(Double variable10) {
		this.variable10 = variable10;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Long getAnioFiscalNivel4() {
		return anioFiscalNivel4;
	}

	public void setAnioFiscalNivel4(Long anioFiscalNivel4) {
		this.anioFiscalNivel4 = anioFiscalNivel4;
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

	public Long getDatTransProdId() {
		return datTransProdId;
	}

	public void setDatTransProdId(Long datTransProdId) {
		this.datTransProdId = datTransProdId;
	}

	public String getDestinoProduccion() {
		return destinoProduccion;
	}

	public void setDestinoProduccion(String destinoProduccion) {
		this.destinoProduccion = destinoProduccion;
	}

	public Double getEdadNivel4() {
		return edadNivel4;
	}

	public void setEdadNivel4(Double edadNivel4) {
		this.edadNivel4 = edadNivel4;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEtapaNivel4() {
		return etapaNivel4;
	}

	public void setEtapaNivel4(Long etapaNivel4) {
		this.etapaNivel4 = etapaNivel4;
	}

	public Long getFaseFenoNivel4() {
		return faseFenoNivel4;
	}

	public void setFaseFenoNivel4(Long faseFenoNivel4) {
		this.faseFenoNivel4 = faseFenoNivel4;
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

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
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

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Long getVariedNivel4() {
		return variedNivel4;
	}

	public void setVariedNivel4(Long variedNivel4) {
		this.variedNivel4 = variedNivel4;
	}

	public Long getEmpresaCompradora() {
		return empresaCompradora;
	}

	public void setEmpresaCompradora(Long empresaCompradora) {
		this.empresaCompradora = empresaCompradora;
	}

	public Long getConductorId_Conductor() {
		return conductorId_Conductor;
	}

	public void setConductorId_Conductor(Long conductorId_Conductor) {
		this.conductorId_Conductor = conductorId_Conductor;
	}

	public Long getFrtCosId_FrenteCos() {
		return frtCosId_FrenteCos;
	}

	public void setFrtCosId_FrenteCos(Long frtCosId_FrenteCos) {
		this.frtCosId_FrenteCos = frtCosId_FrenteCos;
	}

	public Long getModalidadCosId_ModalidadCosecha() {
		return modalidadCosId_ModalidadCosecha;
	}

	public void setModalidadCosId_ModalidadCosecha(Long modalidadCosId_ModalidadCosecha) {
		this.modalidadCosId_ModalidadCosecha = modalidadCosId_ModalidadCosecha;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getProveId_Proveedor() {
		return proveId_Proveedor;
	}

	public void setProveId_Proveedor(Long proveId_Proveedor) {
		this.proveId_Proveedor = proveId_Proveedor;
	}

	public Long getTranspId_Transportadora() {
		return transpId_Transportadora;
	}

	public void setTranspId_Transportadora(Long transpId_Transportadora) {
		this.transpId_Transportadora = transpId_Transportadora;
	}

	public Long getVehiTranspId_VehiculosTransp() {
		return vehiTranspId_VehiculosTransp;
	}

	public void setVehiTranspId_VehiculosTransp(Long vehiTranspId_VehiculosTransp) {
		this.vehiTranspId_VehiculosTransp = vehiTranspId_VehiculosTransp;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public String getObservacion2() {
		return observacion2;
	}

	public void setObservacion2(String observacion2) {
		this.observacion2 = observacion2;
	}

	public String getObservacion3() {
		return observacion3;
	}

	public void setObservacion3(String observacion3) {
		this.observacion3 = observacion3;
	}

	public String getNoDocumento() {
		return noDocumento;
	}

	public void setNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getSello6() {
		return sello6;
	}

	public void setSello6(String sello6) {
		this.sello6 = sello6;
	}

	public String getSello7() {
		return sello7;
	}

	public void setSello7(String sello7) {
		this.sello7 = sello7;
	}

	public String getSello8() {
		return sello8;
	}

	public void setSello8(String sello8) {
		this.sello8 = sello8;
	}

	public String getSello9() {
		return sello9;
	}

	public void setSello9(String sello9) {
		this.sello9 = sello9;
	}

	public String getSello10() {
		return sello10;
	}

	public void setSello10(String sello10) {
		this.sello10 = sello10;
	}

	public String getNombrePeso() {
		return nombrePeso;
	}

	public void setNombrePeso(String nombrePeso) {
		this.nombrePeso = nombrePeso;
	}

	public String getNombrePeso2() {
		return nombrePeso2;
	}

	public void setNombrePeso2(String nombrePeso2) {
		this.nombrePeso2 = nombrePeso2;
	}

	public Long getConsecutivoPesoNeto() {
		return consecutivoPesoNeto;
	}

	public void setConsecutivoPesoNeto(Long consecutivoPesoNeto) {
		this.consecutivoPesoNeto = consecutivoPesoNeto;
	}

	public Date getFechaEstadoVehiculo() {
		return fechaEstadoVehiculo;
	}

	public void setFechaEstadoVehiculo(Date fechaEstadoVehiculo) {
		this.fechaEstadoVehiculo = fechaEstadoVehiculo;
	}

	public String getNomUsuarioDigitacion() {
		return nomUsuarioDigitacion;
	}

	public void setNomUsuarioDigitacion(String nomUsuarioDigitacion) {
		this.nomUsuarioDigitacion = nomUsuarioDigitacion;
	}
}
