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
public class LaraEdadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaraEdadDTO.class);
	private Long compania;
	private Double edadFinal;
	private Double edadInicial;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional1;
	private Long laraEdadId;
	private Double valorLaraEdad;
	private Long grupoSuelo_GrpSuelo;

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getEdadFinal() {
		return edadFinal;
	}

	public void setEdadFinal(Double edadFinal) {
		this.edadFinal = edadFinal;
	}

	public Double getEdadInicial() {
		return edadInicial;
	}

	public void setEdadInicial(Double edadInicial) {
		this.edadInicial = edadInicial;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional1() {
		return infoAdicional1;
	}

	public void setInfoAdicional1(String infoAdicional1) {
		this.infoAdicional1 = infoAdicional1;
	}

	public Long getLaraEdadId() {
		return laraEdadId;
	}

	public void setLaraEdadId(Long laraEdadId) {
		this.laraEdadId = laraEdadId;
	}

	public Double getValorLaraEdad() {
		return valorLaraEdad;
	}

	public void setValorLaraEdad(Double valorLaraEdad) {
		this.valorLaraEdad = valorLaraEdad;
	}

	public Long getGrupoSuelo_GrpSuelo() {
		return grupoSuelo_GrpSuelo;
	}

	public void setGrupoSuelo_GrpSuelo(Long grupoSuelo_GrpSuelo) {
		this.grupoSuelo_GrpSuelo = grupoSuelo_GrpSuelo;
	}
}
