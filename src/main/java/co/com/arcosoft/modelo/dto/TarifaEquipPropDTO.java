package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

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
public class TarifaEquipPropDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaEquipPropDTO.class);
	private Long compania;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Double tarifa;
	private Long tarifaEquipPropId;
	private Long equipoId_Equipo;
	private UdadMed udadMedId_UdadMed;
	private Labor labor_tarifa;

	private String codLabortarifa;

	private String codUdadMed;

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Long getTarifaEquipPropId() {
		return tarifaEquipPropId;
	}

	public void setTarifaEquipPropId(Long tarifaEquipPropId) {
		this.tarifaEquipPropId = tarifaEquipPropId;
	}

	public Long getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public void setEquipoId_Equipo(Long equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}

	public Labor getLabor_tarifa() {
		return labor_tarifa;
	}

	public void setLabor_tarifa(Labor labor_tarifa) {
		this.labor_tarifa = labor_tarifa;
	}

	public String getCodLabortarifa() {
		return codLabortarifa;
	}

	public void setCodLabortarifa(String codLabortarifa) {
		this.codLabortarifa = codLabortarifa;
	}

}
