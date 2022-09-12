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
public class DiviPolitDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DiviPolitDTO.class);
	private String codigo;
	private Long divPolId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private Long divPolId_DiviPolit;
	private Long tipoDivisionId_TipDivi;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getDivPolId() {
		return divPolId;
	}

	public void setDivPolId(Long divPolId) {
		this.divPolId = divPolId;
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

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getDivPolId_DiviPolit() {
		return divPolId_DiviPolit;
	}

	public void setDivPolId_DiviPolit(Long divPolId_DiviPolit) {
		this.divPolId_DiviPolit = divPolId_DiviPolit;
	}

	public Long getTipoDivisionId_TipDivi() {
		return tipoDivisionId_TipDivi;
	}

	public void setTipoDivisionId_TipDivi(Long tipoDivisionId_TipDivi) {
		this.tipoDivisionId_TipDivi = tipoDivisionId_TipDivi;
	}
}
