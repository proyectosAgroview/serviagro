package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Etapa generated by hbm2java
 */
public class Etapa implements java.io.Serializable {

	private Long etapaId;
	private Cultivo cultivo;
	private String codigo;
	private String nombre;
	public Long compania;
	private Long proximaEtapa;
	private Long numeroCosechas;
	private String tipoCosecha;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<Nivel4> nivel4s = new HashSet<Nivel4>(0);

	public Etapa() {
	}

	public Etapa(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Etapa(Long etapaId, Cultivo cultivo, String codigo, String nombre, Long compania, Long proximaEtapa,
			Long numeroCosechas, String tipoCosecha, String infoAdicional, String infoAdicional2, Date fechaCreacion,
			Date fechaModificacion, String estado, Set<Nivel4> nivel4s) {
		this.etapaId = etapaId;
		this.cultivo = cultivo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.compania = compania;
		this.proximaEtapa = proximaEtapa;
		this.numeroCosechas = numeroCosechas;
		this.tipoCosecha = tipoCosecha;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.nivel4s = nivel4s;
	}

	public Long getEtapaId() {
		return this.etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Cultivo getCultivo() {
		return this.cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getProximaEtapa() {
		return this.proximaEtapa;
	}

	public void setProximaEtapa(Long proximaEtapa) {
		this.proximaEtapa = proximaEtapa;
	}

	public Long getNumeroCosechas() {
		return this.numeroCosechas;
	}

	public void setNumeroCosechas(Long numeroCosechas) {
		this.numeroCosechas = numeroCosechas;
	}

	public String getTipoCosecha() {
		return this.tipoCosecha;
	}

	public void setTipoCosecha(String tipoCosecha) {
		this.tipoCosecha = tipoCosecha;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Nivel4> getNivel4s() {
		return this.nivel4s;
	}

	public void setNivel4s(Set<Nivel4> nivel4s) {
		this.nivel4s = nivel4s;
	}

}