package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TipoRecursosProfesionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoRecursosProfesionDTO.class);
	private Double disponibilidadDia;
	private Double disponibilidadTotal;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Long tipoRecursosProfesionId;
	private Double valor;
	private ElementoCosto elemCostoId_ElementoCosto;
	private Profesion profId_Profesion;
	private Long tpRecursoId_TipoRecurso;
	private UdadMed udadMedId_UdadMed;

	private String nombreUm;
	private String nombreElemCosto;

	private String nombreProfesion;

	public String getNombreUm() {
		return nombreUm;
	}

	public void setNombreUm(String nombreUm) {
		this.nombreUm = nombreUm;
	}

	public String getNombreElemCosto() {
		return nombreElemCosto;
	}

	public void setNombreElemCosto(String nombreElemCosto) {
		this.nombreElemCosto = nombreElemCosto;
	}

	public String getNombreProfesion() {
		return nombreProfesion;
	}

	public void setNombreProfesion(String nombreProfesion) {
		this.nombreProfesion = nombreProfesion;
	}

	public Double getDisponibilidadDia() {
		return disponibilidadDia;
	}

	public void setDisponibilidadDia(Double disponibilidadDia) {
		this.disponibilidadDia = disponibilidadDia;
	}

	public Double getDisponibilidadTotal() {
		return disponibilidadTotal;
	}

	public void setDisponibilidadTotal(Double disponibilidadTotal) {
		this.disponibilidadTotal = disponibilidadTotal;
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

	public Long getTipoRecursosProfesionId() {
		return tipoRecursosProfesionId;
	}

	public void setTipoRecursosProfesionId(Long tipoRecursosProfesionId) {
		this.tipoRecursosProfesionId = tipoRecursosProfesionId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ElementoCosto getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(ElementoCosto elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Profesion getProfId_Profesion() {
		return profId_Profesion;
	}

	public void setProfId_Profesion(Profesion profId_Profesion) {
		this.profId_Profesion = profId_Profesion;
	}

	public Long getTpRecursoId_TipoRecurso() {
		return tpRecursoId_TipoRecurso;
	}

	public void setTpRecursoId_TipoRecurso(Long tpRecursoId_TipoRecurso) {
		this.tpRecursoId_TipoRecurso = tpRecursoId_TipoRecurso;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}
}
