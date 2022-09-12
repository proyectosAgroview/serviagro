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
public class EstructSiembDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EstructSiembDTO.class);
	private String codigo;
	private Long compania;
	private Long eliminada;
	private String estado;
	private Long estrSiembId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Long nivel1Id;
	private Long nivel2Id;
	private Long nivel3Id;
	private Long motElimId_MotElim;
	private Long nivel4Id_Nivel4;
	private Long linea;
	private Long planta;
	private Float latitud;
	private Float longitud;
	private Float precision;

	public Long getLinea() {
		return linea;
	}

	public void setLinea(Long linea) {
		this.linea = linea;
	}

	public Long getPlanta() {
		return planta;
	}

	public void setPlanta(Long planta) {
		this.planta = planta;
	}

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getEliminada() {
		return eliminada;
	}

	public void setEliminada(Long eliminada) {
		this.eliminada = eliminada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEstrSiembId() {
		return estrSiembId;
	}

	public void setEstrSiembId(Long estrSiembId) {
		this.estrSiembId = estrSiembId;
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

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Long getNivel1Id() {
		return nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Long getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Long nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Long getNivel3Id() {
		return nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Long getMotElimId_MotElim() {
		return motElimId_MotElim;
	}

	public void setMotElimId_MotElim(Long motElimId_MotElim) {
		this.motElimId_MotElim = motElimId_MotElim;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}
}
