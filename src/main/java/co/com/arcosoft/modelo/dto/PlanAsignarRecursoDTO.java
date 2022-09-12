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
public class PlanAsignarRecursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PlanAsignarRecursoDTO.class);
	private Long planLaborId;
	private Long compania;
	private Long tpRecursoId;
	private Long recursoId;
	private Long udadMedRecurso;
	private Double rendimiento;
	private Double cantidad;
	private Double valorUnitEst;
	private Double costoTotalEstimado;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String documetoErp;
	private Long planLaborId_DatPlanLabor;
	private Long recursoId_Recurso;
	private Long tpRecursoId_TipoRecurso;
	private Long udadMedId_UdadMed;

	public Long getPlanLaborId() {
		return planLaborId;
	}

	public void setPlanLaborId(Long planLaborId) {
		this.planLaborId = planLaborId;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getTpRecursoId() {
		return tpRecursoId;
	}

	public void setTpRecursoId(Long tpRecursoId) {
		this.tpRecursoId = tpRecursoId;
	}

	public Long getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
	}

	public Long getUdadMedRecurso() {
		return udadMedRecurso;
	}

	public void setUdadMedRecurso(Long udadMedRecurso) {
		this.udadMedRecurso = udadMedRecurso;
	}

	public Double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorUnitEst() {
		return valorUnitEst;
	}

	public void setValorUnitEst(Double valorUnitEst) {
		this.valorUnitEst = valorUnitEst;
	}

	public Double getCostoTotalEstimado() {
		return costoTotalEstimado;
	}

	public void setCostoTotalEstimado(Double costoTotalEstimado) {
		this.costoTotalEstimado = costoTotalEstimado;
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

	public String getDocumetoErp() {
		return documetoErp;
	}

	public void setDocumetoErp(String documetoErp) {
		this.documetoErp = documetoErp;
	}

	public Long getPlanLaborId_DatPlanLabor() {
		return planLaborId_DatPlanLabor;
	}

	public void setPlanLaborId_DatPlanLabor(Long planLaborId_DatPlanLabor) {
		this.planLaborId_DatPlanLabor = planLaborId_DatPlanLabor;
	}

	public Long getRecursoId_Recurso() {
		return recursoId_Recurso;
	}

	public void setRecursoId_Recurso(Long recursoId_Recurso) {
		this.recursoId_Recurso = recursoId_Recurso;
	}

	public Long getTpRecursoId_TipoRecurso() {
		return tpRecursoId_TipoRecurso;
	}

	public void setTpRecursoId_TipoRecurso(Long tpRecursoId_TipoRecurso) {
		this.tpRecursoId_TipoRecurso = tpRecursoId_TipoRecurso;
	}

	public Long getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}
}
