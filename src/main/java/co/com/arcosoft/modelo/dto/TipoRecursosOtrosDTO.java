package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TipoRecursosOtrosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoRecursosOtrosDTO.class);
	private String codigo;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private String nombre;
	private Long tipoRecursosOtrosId;
	private Double valor;
	private ElementoCosto elemCostoId_ElementoCosto;
	private Long tpRecursoId_TipoRecurso;
	private UdadMed udadMedId_UdadMed;

	private Servicio servicioId;

	private String nombreServicio;
	private String nombreUm;
	private String nombreElemCosto;

	public Servicio getServicioId() {
		return servicioId;
	}

	public void setServicioId(Servicio servicioId) {
		this.servicioId = servicioId;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTipoRecursosOtrosId() {
		return tipoRecursosOtrosId;
	}

	public void setTipoRecursosOtrosId(Long tipoRecursosOtrosId) {
		this.tipoRecursosOtrosId = tipoRecursosOtrosId;
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
