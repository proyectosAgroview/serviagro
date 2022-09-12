package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatTransProdTrabajadoresDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdTrabajadoresDTO.class);
	private Double cantidadDescontar;
	private Double cantidadPago;
	private Double cantidadProd;
	private ConceptoNomina ceptoNominaId;
	private String cierreCostos;
	private Long contratistaId;
	private Double costoTotal;
	private Long datTransProdTrabajadoresId;
	private String estado;
	private Long etapaId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Double malla1;
	private Double malla2;
	private Double malla3;
	private Double malla4;
	private String observacion;
	private Double pesoPromedio;
	private Long udadMedProd;
	private Double valorUnitario;
	private Long variedId;
	private Long datTransProdId_DatTransProd;
	private Labor laborId_Labor;
	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;
	private Trabajador trabId_Trabajador;
	private UdadMed udadMedId_UdadMed;
	
	private String codigoTrabajador;
	private String codigoConceptoNomina;
	private String codigoUdadMed;
	private String codigoLabor;
	private String codigoNivel2;
	private String codigoNivel4;
	
	
	
	/**
	 * @return the codigoTrabajador
	 */
	public String getCodigoTrabajador() {
		return codigoTrabajador;
	}
	/**
	 * @param codigoTrabajador the codigoTrabajador to set
	 */
	public void setCodigoTrabajador(String codigoTrabajador) {
		this.codigoTrabajador = codigoTrabajador;
	}
	/**
	 * @return the codigoConceptoNomina
	 */
	public String getCodigoConceptoNomina() {
		return codigoConceptoNomina;
	}
	/**
	 * @param codigoConceptoNomina the codigoConceptoNomina to set
	 */
	public void setCodigoConceptoNomina(String codigoConceptoNomina) {
		this.codigoConceptoNomina = codigoConceptoNomina;
	}
	/**
	 * @return the codigoUdadMed
	 */
	public String getCodigoUdadMed() {
		return codigoUdadMed;
	}
	/**
	 * @param codigoUdadMed the codigoUdadMed to set
	 */
	public void setCodigoUdadMed(String codigoUdadMed) {
		this.codigoUdadMed = codigoUdadMed;
	}
	/**
	 * @return the codigoLabor
	 */
	public String getCodigoLabor() {
		return codigoLabor;
	}
	/**
	 * @param codigoLabor the codigoLabor to set
	 */
	public void setCodigoLabor(String codigoLabor) {
		this.codigoLabor = codigoLabor;
	}
	/**
	 * @return the codigoNivel2
	 */
	public String getCodigoNivel2() {
		return codigoNivel2;
	}
	/**
	 * @param codigoNivel2 the codigoNivel2 to set
	 */
	public void setCodigoNivel2(String codigoNivel2) {
		this.codigoNivel2 = codigoNivel2;
	}
	/**
	 * @return the codigoNivel4
	 */
	public String getCodigoNivel4() {
		return codigoNivel4;
	}
	/**
	 * @param codigoNivel4 the codigoNivel4 to set
	 */
	public void setCodigoNivel4(String codigoNivel4) {
		this.codigoNivel4 = codigoNivel4;
	}
	/**
	 * @return the cantidadDescontar
	 */
	public Double getCantidadDescontar() {
		return cantidadDescontar;
	}
	/**
	 * @param cantidadDescontar the cantidadDescontar to set
	 */
	public void setCantidadDescontar(Double cantidadDescontar) {
		this.cantidadDescontar = cantidadDescontar;
	}
	/**
	 * @return the cantidadPago
	 */
	public Double getCantidadPago() {
		return cantidadPago;
	}
	/**
	 * @param cantidadPago the cantidadPago to set
	 */
	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}
	/**
	 * @return the cantidadProd
	 */
	public Double getCantidadProd() {
		return cantidadProd;
	}
	/**
	 * @param cantidadProd the cantidadProd to set
	 */
	public void setCantidadProd(Double cantidadProd) {
		this.cantidadProd = cantidadProd;
	}
	/**
	 * @return the ceptoNominaId
	 */
	public ConceptoNomina getCeptoNominaId() {
		return ceptoNominaId;
	}
	/**
	 * @param ceptoNominaId the ceptoNominaId to set
	 */
	public void setCeptoNominaId(ConceptoNomina ceptoNominaId) {
		this.ceptoNominaId = ceptoNominaId;
	}
	/**
	 * @return the cierreCostos
	 */
	public String getCierreCostos() {
		return cierreCostos;
	}
	/**
	 * @param cierreCostos the cierreCostos to set
	 */
	public void setCierreCostos(String cierreCostos) {
		this.cierreCostos = cierreCostos;
	}
	/**
	 * @return the contratistaId
	 */
	public Long getContratistaId() {
		return contratistaId;
	}
	/**
	 * @param contratistaId the contratistaId to set
	 */
	public void setContratistaId(Long contratistaId) {
		this.contratistaId = contratistaId;
	}
	/**
	 * @return the costoTotal
	 */
	public Double getCostoTotal() {
		return costoTotal;
	}
	/**
	 * @param costoTotal the costoTotal to set
	 */
	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}
	/**
	 * @return the datTransProdTrabajadoresId
	 */
	public Long getDatTransProdTrabajadoresId() {
		return datTransProdTrabajadoresId;
	}
	/**
	 * @param datTransProdTrabajadoresId the datTransProdTrabajadoresId to set
	 */
	public void setDatTransProdTrabajadoresId(Long datTransProdTrabajadoresId) {
		this.datTransProdTrabajadoresId = datTransProdTrabajadoresId;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the etapaId
	 */
	public Long getEtapaId() {
		return etapaId;
	}
	/**
	 * @param etapaId the etapaId to set
	 */
	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the malla1
	 */
	public Double getMalla1() {
		return malla1;
	}
	/**
	 * @param malla1 the malla1 to set
	 */
	public void setMalla1(Double malla1) {
		this.malla1 = malla1;
	}
	/**
	 * @return the malla2
	 */
	public Double getMalla2() {
		return malla2;
	}
	/**
	 * @param malla2 the malla2 to set
	 */
	public void setMalla2(Double malla2) {
		this.malla2 = malla2;
	}
	/**
	 * @return the malla3
	 */
	public Double getMalla3() {
		return malla3;
	}
	/**
	 * @param malla3 the malla3 to set
	 */
	public void setMalla3(Double malla3) {
		this.malla3 = malla3;
	}
	/**
	 * @return the malla4
	 */
	public Double getMalla4() {
		return malla4;
	}
	/**
	 * @param malla4 the malla4 to set
	 */
	public void setMalla4(Double malla4) {
		this.malla4 = malla4;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the pesoPromedio
	 */
	public Double getPesoPromedio() {
		return pesoPromedio;
	}
	/**
	 * @param pesoPromedio the pesoPromedio to set
	 */
	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}
	/**
	 * @return the udadMedProd
	 */
	public Long getUdadMedProd() {
		return udadMedProd;
	}
	/**
	 * @param udadMedProd the udadMedProd to set
	 */
	public void setUdadMedProd(Long udadMedProd) {
		this.udadMedProd = udadMedProd;
	}
	/**
	 * @return the valorUnitario
	 */
	public Double getValorUnitario() {
		return valorUnitario;
	}
	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	/**
	 * @return the variedId
	 */
	public Long getVariedId() {
		return variedId;
	}
	/**
	 * @param variedId the variedId to set
	 */
	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}
	/**
	 * @return the datTransProdId_DatTransProd
	 */
	public Long getDatTransProdId_DatTransProd() {
		return datTransProdId_DatTransProd;
	}
	/**
	 * @param datTransProdId_DatTransProd the datTransProdId_DatTransProd to set
	 */
	public void setDatTransProdId_DatTransProd(Long datTransProdId_DatTransProd) {
		this.datTransProdId_DatTransProd = datTransProdId_DatTransProd;
	}
	/**
	 * @return the laborId_Labor
	 */
	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}
	/**
	 * @param laborId_Labor the laborId_Labor to set
	 */
	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}
	/**
	 * @return the nivel2Id_Nivel2
	 */
	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}
	/**
	 * @param nivel2Id_Nivel2 the nivel2Id_Nivel2 to set
	 */
	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}
	/**
	 * @return the nivel4Id_Nivel4
	 */
	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}
	/**
	 * @param nivel4Id_Nivel4 the nivel4Id_Nivel4 to set
	 */
	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}
	/**
	 * @return the trabId_Trabajador
	 */
	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}
	/**
	 * @param trabId_Trabajador the trabId_Trabajador to set
	 */
	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}
	/**
	 * @return the udadMedId_UdadMed
	 */
	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}
	/**
	 * @param udadMedId_UdadMed the udadMedId_UdadMed to set
	 */
	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}


}
