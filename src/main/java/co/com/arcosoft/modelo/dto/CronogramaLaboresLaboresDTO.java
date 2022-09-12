package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class CronogramaLaboresLaboresDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresLaboresDTO.class);
	private Long cronogramaLaboresLaboresId;
	private Double duracion;
	private Double numeroDiasFin;
	private Double numeroDiasInicio;
	private Long cronogramaLaboresId_CronogramaLabores;
	private Labor laborId_Labor;
	private String nombreLabor;
	private Double tarifaLabor;
	private String presupuestoBaseAreaPlantas;
	private Double	enero	;
	private Double	febrero	;
	private Double	marzo	;
	private Double	abril	;
	private Double	mayo	;
	private Double	junio	;
	private Double	julio	;
	private Double	agosto	;
	private Double	septiembre	;
	private Double	octubre	;
	private Double	noviembre	;
	private Double	diciembre	;

	private Double	areaEnero	;
	private Double	areaFebrero	;
	private Double	areaMarzo	;
	private Double	areaAbril	;
	private Double	areaMayo	;
	private Double	areaJunio	;
	private Double	areaJulio	;
	private Double	areaAgosto	;
	private Double	areaSeptiembre	;
	private Double	areaOctubre	;
	private Double	areaNoviembre	;
	private Double	areaDiciembre	;

	private String	lotesEnero	;
	private String	lotesFebrero	;
	private String	lotesMarzo	;
	private String	lotesAbril	;
	private String	lotesMayo	;
	private String	lotesJunio	;
	private String	lotesJulio	;
	private String	lotesAgosto	;
	private String	lotesSeptiembre	;
	private String	lotesOctubre	;
	private String	lotesNoviembre	;
	private String	lotesDiciembre	;

	private UdadMed udadMed;
	private String nombreUdadMed;
	
	
	
	
	

	/**
	 * @return the udadMed
	 */
	public UdadMed getUdadMed() {
		return udadMed;
	}

	/**
	 * @param udadMed the udadMed to set
	 */
	public void setUdadMed(UdadMed udadMed) {
		this.udadMed = udadMed;
	}

	/**
	 * @return the nombreUdadMed
	 */
	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	/**
	 * @param nombreUdadMed the nombreUdadMed to set
	 */
	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	/**
	 * @return the enero
	 */
	public Double getEnero() {
		return enero;
	}

	/**
	 * @param enero the enero to set
	 */
	public void setEnero(Double enero) {
		this.enero = enero;
	}

	/**
	 * @return the febrero
	 */
	public Double getFebrero() {
		return febrero;
	}

	/**
	 * @param febrero the febrero to set
	 */
	public void setFebrero(Double febrero) {
		this.febrero = febrero;
	}

	/**
	 * @return the marzo
	 */
	public Double getMarzo() {
		return marzo;
	}

	/**
	 * @param marzo the marzo to set
	 */
	public void setMarzo(Double marzo) {
		this.marzo = marzo;
	}

	/**
	 * @return the abril
	 */
	public Double getAbril() {
		return abril;
	}

	/**
	 * @param abril the abril to set
	 */
	public void setAbril(Double abril) {
		this.abril = abril;
	}

	/**
	 * @return the mayo
	 */
	public Double getMayo() {
		return mayo;
	}

	/**
	 * @param mayo the mayo to set
	 */
	public void setMayo(Double mayo) {
		this.mayo = mayo;
	}

	/**
	 * @return the junio
	 */
	public Double getJunio() {
		return junio;
	}

	/**
	 * @param junio the junio to set
	 */
	public void setJunio(Double junio) {
		this.junio = junio;
	}

	/**
	 * @return the julio
	 */
	public Double getJulio() {
		return julio;
	}

	/**
	 * @param julio the julio to set
	 */
	public void setJulio(Double julio) {
		this.julio = julio;
	}

	/**
	 * @return the agosto
	 */
	public Double getAgosto() {
		return agosto;
	}

	/**
	 * @param agosto the agosto to set
	 */
	public void setAgosto(Double agosto) {
		this.agosto = agosto;
	}

	/**
	 * @return the septiembre
	 */
	public Double getSeptiembre() {
		return septiembre;
	}

	/**
	 * @param septiembre the septiembre to set
	 */
	public void setSeptiembre(Double septiembre) {
		this.septiembre = septiembre;
	}

	/**
	 * @return the octubre
	 */
	public Double getOctubre() {
		return octubre;
	}

	/**
	 * @param octubre the octubre to set
	 */
	public void setOctubre(Double octubre) {
		this.octubre = octubre;
	}

	/**
	 * @return the noviembre
	 */
	public Double getNoviembre() {
		return noviembre;
	}

	/**
	 * @param noviembre the noviembre to set
	 */
	public void setNoviembre(Double noviembre) {
		this.noviembre = noviembre;
	}

	/**
	 * @return the diciembre
	 */
	public Double getDiciembre() {
		return diciembre;
	}

	/**
	 * @param diciembre the diciembre to set
	 */
	public void setDiciembre(Double diciembre) {
		this.diciembre = diciembre;
	}

	/**
	 * @return the areaEnero
	 */
	public Double getAreaEnero() {
		return areaEnero;
	}

	/**
	 * @param areaEnero the areaEnero to set
	 */
	public void setAreaEnero(Double areaEnero) {
		this.areaEnero = areaEnero;
	}

	/**
	 * @return the areaFebrero
	 */
	public Double getAreaFebrero() {
		return areaFebrero;
	}

	/**
	 * @param areaFebrero the areaFebrero to set
	 */
	public void setAreaFebrero(Double areaFebrero) {
		this.areaFebrero = areaFebrero;
	}

	/**
	 * @return the areaMarzo
	 */
	public Double getAreaMarzo() {
		return areaMarzo;
	}

	/**
	 * @param areaMarzo the areaMarzo to set
	 */
	public void setAreaMarzo(Double areaMarzo) {
		this.areaMarzo = areaMarzo;
	}

	/**
	 * @return the areaAbril
	 */
	public Double getAreaAbril() {
		return areaAbril;
	}

	/**
	 * @param areaAbril the areaAbril to set
	 */
	public void setAreaAbril(Double areaAbril) {
		this.areaAbril = areaAbril;
	}

	/**
	 * @return the areaMayo
	 */
	public Double getAreaMayo() {
		return areaMayo;
	}

	/**
	 * @param areaMayo the areaMayo to set
	 */
	public void setAreaMayo(Double areaMayo) {
		this.areaMayo = areaMayo;
	}

	/**
	 * @return the areaJunio
	 */
	public Double getAreaJunio() {
		return areaJunio;
	}

	/**
	 * @param areaJunio the areaJunio to set
	 */
	public void setAreaJunio(Double areaJunio) {
		this.areaJunio = areaJunio;
	}

	/**
	 * @return the areaJulio
	 */
	public Double getAreaJulio() {
		return areaJulio;
	}

	/**
	 * @param areaJulio the areaJulio to set
	 */
	public void setAreaJulio(Double areaJulio) {
		this.areaJulio = areaJulio;
	}

	/**
	 * @return the areaAgosto
	 */
	public Double getAreaAgosto() {
		return areaAgosto;
	}

	/**
	 * @param areaAgosto the areaAgosto to set
	 */
	public void setAreaAgosto(Double areaAgosto) {
		this.areaAgosto = areaAgosto;
	}

	/**
	 * @return the areaSeptiembre
	 */
	public Double getAreaSeptiembre() {
		return areaSeptiembre;
	}

	/**
	 * @param areaSeptiembre the areaSeptiembre to set
	 */
	public void setAreaSeptiembre(Double areaSeptiembre) {
		this.areaSeptiembre = areaSeptiembre;
	}

	/**
	 * @return the areaOctubre
	 */
	public Double getAreaOctubre() {
		return areaOctubre;
	}

	/**
	 * @param areaOctubre the areaOctubre to set
	 */
	public void setAreaOctubre(Double areaOctubre) {
		this.areaOctubre = areaOctubre;
	}

	/**
	 * @return the areaNoviembre
	 */
	public Double getAreaNoviembre() {
		return areaNoviembre;
	}

	/**
	 * @param areaNoviembre the areaNoviembre to set
	 */
	public void setAreaNoviembre(Double areaNoviembre) {
		this.areaNoviembre = areaNoviembre;
	}

	/**
	 * @return the areaDiciembre
	 */
	public Double getAreaDiciembre() {
		return areaDiciembre;
	}

	/**
	 * @param areaDiciembre the areaDiciembre to set
	 */
	public void setAreaDiciembre(Double areaDiciembre) {
		this.areaDiciembre = areaDiciembre;
	}

	/**
	 * @return the lotesEnero
	 */
	public String getLotesEnero() {
		return lotesEnero;
	}

	/**
	 * @param lotesEnero the lotesEnero to set
	 */
	public void setLotesEnero(String lotesEnero) {
		this.lotesEnero = lotesEnero;
	}

	/**
	 * @return the lotesFebrero
	 */
	public String getLotesFebrero() {
		return lotesFebrero;
	}

	/**
	 * @param lotesFebrero the lotesFebrero to set
	 */
	public void setLotesFebrero(String lotesFebrero) {
		this.lotesFebrero = lotesFebrero;
	}

	/**
	 * @return the lotesMarzo
	 */
	public String getLotesMarzo() {
		return lotesMarzo;
	}

	/**
	 * @param lotesMarzo the lotesMarzo to set
	 */
	public void setLotesMarzo(String lotesMarzo) {
		this.lotesMarzo = lotesMarzo;
	}

	/**
	 * @return the lotesAbril
	 */
	public String getLotesAbril() {
		return lotesAbril;
	}

	/**
	 * @param lotesAbril the lotesAbril to set
	 */
	public void setLotesAbril(String lotesAbril) {
		this.lotesAbril = lotesAbril;
	}

	/**
	 * @return the lotesMayo
	 */
	public String getLotesMayo() {
		return lotesMayo;
	}

	/**
	 * @param lotesMayo the lotesMayo to set
	 */
	public void setLotesMayo(String lotesMayo) {
		this.lotesMayo = lotesMayo;
	}

	/**
	 * @return the lotesJunio
	 */
	public String getLotesJunio() {
		return lotesJunio;
	}

	/**
	 * @param lotesJunio the lotesJunio to set
	 */
	public void setLotesJunio(String lotesJunio) {
		this.lotesJunio = lotesJunio;
	}

	/**
	 * @return the lotesJulio
	 */
	public String getLotesJulio() {
		return lotesJulio;
	}

	/**
	 * @param lotesJulio the lotesJulio to set
	 */
	public void setLotesJulio(String lotesJulio) {
		this.lotesJulio = lotesJulio;
	}

	/**
	 * @return the lotesAgosto
	 */
	public String getLotesAgosto() {
		return lotesAgosto;
	}

	/**
	 * @param lotesAgosto the lotesAgosto to set
	 */
	public void setLotesAgosto(String lotesAgosto) {
		this.lotesAgosto = lotesAgosto;
	}

	/**
	 * @return the lotesSeptiembre
	 */
	public String getLotesSeptiembre() {
		return lotesSeptiembre;
	}

	/**
	 * @param lotesSeptiembre the lotesSeptiembre to set
	 */
	public void setLotesSeptiembre(String lotesSeptiembre) {
		this.lotesSeptiembre = lotesSeptiembre;
	}

	/**
	 * @return the lotesOctubre
	 */
	public String getLotesOctubre() {
		return lotesOctubre;
	}

	/**
	 * @param lotesOctubre the lotesOctubre to set
	 */
	public void setLotesOctubre(String lotesOctubre) {
		this.lotesOctubre = lotesOctubre;
	}

	/**
	 * @return the lotesNoviembre
	 */
	public String getLotesNoviembre() {
		return lotesNoviembre;
	}

	/**
	 * @param lotesNoviembre the lotesNoviembre to set
	 */
	public void setLotesNoviembre(String lotesNoviembre) {
		this.lotesNoviembre = lotesNoviembre;
	}

	/**
	 * @return the lotesDiciembre
	 */
	public String getLotesDiciembre() {
		return lotesDiciembre;
	}

	/**
	 * @param lotesDiciembre the lotesDiciembre to set
	 */
	public void setLotesDiciembre(String lotesDiciembre) {
		this.lotesDiciembre = lotesDiciembre;
	}

	/**
	 * @return the presupuestoBaseAreaPlantas
	 */
	public String getPresupuestoBaseAreaPlantas() {
		return presupuestoBaseAreaPlantas;
	}

	/**
	 * @param presupuestoBaseAreaPlantas the presupuestoBaseAreaPlantas to set
	 */
	public void setPresupuestoBaseAreaPlantas(String presupuestoBaseAreaPlantas) {
		this.presupuestoBaseAreaPlantas = presupuestoBaseAreaPlantas;
	}

	/**
	 * @return the tarifaLabor
	 */
	public Double getTarifaLabor() {
		return tarifaLabor;
	}

	/**
	 * @param tarifaLabor the tarifaLabor to set
	 */
	public void setTarifaLabor(Double tarifaLabor) {
		this.tarifaLabor = tarifaLabor;
	}

	public Long getCronogramaLaboresLaboresId() {
		return cronogramaLaboresLaboresId;
	}

	public void setCronogramaLaboresLaboresId(Long cronogramaLaboresLaboresId) {
		this.cronogramaLaboresLaboresId = cronogramaLaboresLaboresId;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public Double getNumeroDiasFin() {
		return numeroDiasFin;
	}

	public void setNumeroDiasFin(Double numeroDiasFin) {
		this.numeroDiasFin = numeroDiasFin;
	}

	public Double getNumeroDiasInicio() {
		return numeroDiasInicio;
	}

	public void setNumeroDiasInicio(Double numeroDiasInicio) {
		this.numeroDiasInicio = numeroDiasInicio;
	}

	public Long getCronogramaLaboresId_CronogramaLabores() {
		return cronogramaLaboresId_CronogramaLabores;
	}

	public void setCronogramaLaboresId_CronogramaLabores(Long cronogramaLaboresId_CronogramaLabores) {
		this.cronogramaLaboresId_CronogramaLabores = cronogramaLaboresId_CronogramaLabores;
	}

	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

}
