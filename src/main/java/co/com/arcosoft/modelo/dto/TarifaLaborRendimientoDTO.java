package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TarifaLaborRendimientoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaLaborRendimientoDTO.class);
	private Double bonificacion;
	private Long compania;
	private PersEmpr contratistaId;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Nivel2 nivel2Id;
	private Double rendimiento;
	private Double tarifa;
	private Long tarifaLaborId;
	private UdadMed udadMedId;
	private Long laborId_Labor;

	private String codNivel2;
	private String codUdadMed;
	private String codContratista;
	private Double rendimientoMax;
	
	
	
	/**
	 * @return the rendimientoMax
	 */
	public Double getRendimientoMax() {
		return rendimientoMax;
	}

	/**
	 * @param rendimientoMax the rendimientoMax to set
	 */
	public void setRendimientoMax(Double rendimientoMax) {
		this.rendimientoMax = rendimientoMax;
	}

	public String getCodNivel2() {
		return codNivel2;
	}

	public void setCodNivel2(String codNivel2) {
		this.codNivel2 = codNivel2;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public String getCodContratista() {
		return codContratista;
	}

	public void setCodContratista(String codContratista) {
		this.codContratista = codContratista;
	}

	public Double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(Double bonificacion) {
		this.bonificacion = bonificacion;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public PersEmpr getContratistaId() {
		return contratistaId;
	}

	public void setContratistaId(PersEmpr contratistaId) {
		this.contratistaId = contratistaId;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Nivel2 getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Nivel2 nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Long getTarifaLaborId() {
		return tarifaLaborId;
	}

	public void setTarifaLaborId(Long tarifaLaborId) {
		this.tarifaLaborId = tarifaLaborId;
	}

	public UdadMed getUdadMedId() {
		return udadMedId;
	}

	public void setUdadMedId(UdadMed udadMedId) {
		this.udadMedId = udadMedId;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

}
