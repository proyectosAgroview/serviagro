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
public class CostoRecursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CostoRecursoDTO.class);
	private Long recursoId;
	private Long compania;
	private Date fechaInicial;
	private Date fechaFinal;
	private Long udadMedId;
	private Double valorUnitEst;
	private Long elemCostoId;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Long elemCostoId_ElementoCosto;
	private Long recursoId_Recurso;
	private Long udadMedId_UdadMed;

	public Long getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Long getUdadMedId() {
		return udadMedId;
	}

	public void setUdadMedId(Long udadMedId) {
		this.udadMedId = udadMedId;
	}

	public Double getValorUnitEst() {
		return valorUnitEst;
	}

	public void setValorUnitEst(Double valorUnitEst) {
		this.valorUnitEst = valorUnitEst;
	}

	public Long getElemCostoId() {
		return elemCostoId;
	}

	public void setElemCostoId(Long elemCostoId) {
		this.elemCostoId = elemCostoId;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Long getRecursoId_Recurso() {
		return recursoId_Recurso;
	}

	public void setRecursoId_Recurso(Long recursoId_Recurso) {
		this.recursoId_Recurso = recursoId_Recurso;
	}

	public Long getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}
}
