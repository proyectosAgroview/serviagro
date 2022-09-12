package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatPlanLaborDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanLaborDetDTO.class);
	private Double cantidadPlan;
	private Double costoTotalEstimado;
	private Double edadPlanificacion;
	private Long planLaborDetId;
	private Long udadMedPlan;
	private Long planLaborId_DatPlanLabor;
	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;
	private String Nivel2Nombre;
	private String Nivel4Nombre;
	private String UdadMedNombre;

	public String getUdadMedNombre() {
		return UdadMedNombre;
	}

	public void setUdadMedNombre(String udadMedNombre) {
		UdadMedNombre = udadMedNombre;
	}

	public String getNivel2Nombre() {
		return Nivel2Nombre;
	}

	public void setNivel2Nombre(String nivel2Nombre) {
		Nivel2Nombre = nivel2Nombre;
	}

	public String getNivel4Nombre() {
		return Nivel4Nombre;
	}

	public void setNivel4Nombre(String nivel4Nombre) {
		Nivel4Nombre = nivel4Nombre;
	}

	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Double getCantidadPlan() {
		return cantidadPlan;
	}

	public void setCantidadPlan(Double cantidadPlan) {
		this.cantidadPlan = cantidadPlan;
	}

	public Double getCostoTotalEstimado() {
		return costoTotalEstimado;
	}

	public void setCostoTotalEstimado(Double costoTotalEstimado) {
		this.costoTotalEstimado = costoTotalEstimado;
	}

	public Double getEdadPlanificacion() {
		return edadPlanificacion;
	}

	public void setEdadPlanificacion(Double edadPlanificacion) {
		this.edadPlanificacion = edadPlanificacion;
	}

	public Long getPlanLaborDetId() {
		return planLaborDetId;
	}

	public void setPlanLaborDetId(Long planLaborDetId) {
		this.planLaborDetId = planLaborDetId;
	}

	public Long getUdadMedPlan() {
		return udadMedPlan;
	}

	public void setUdadMedPlan(Long udadMedPlan) {
		this.udadMedPlan = udadMedPlan;
	}

	public Long getPlanLaborId_DatPlanLabor() {
		return planLaborId_DatPlanLabor;
	}

	public void setPlanLaborId_DatPlanLabor(Long planLaborId_DatPlanLabor) {
		this.planLaborId_DatPlanLabor = planLaborId_DatPlanLabor;
	}

}
