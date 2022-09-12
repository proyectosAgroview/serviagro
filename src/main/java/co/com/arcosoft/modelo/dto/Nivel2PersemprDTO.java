package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.PersEmpr;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class Nivel2PersemprDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel2PersemprDTO.class);
	private Long id;
	private Double procentajeParticipacion;
	private Nivel2 nivel2Id_Nivel2;
	private PersEmpr proveedorParticipacion;
	private Long proveedorParticipacionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getProcentajeParticipacion() {
		return procentajeParticipacion;
	}

	public void setProcentajeParticipacion(Double procentajeParticipacion) {
		this.procentajeParticipacion = procentajeParticipacion;
	}

	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public PersEmpr getProveedorParticipacion() {
		return proveedorParticipacion;
	}

	public Long getProveedorParticipacionId() {
		return proveedorParticipacionId;
	}

	public void setProveedorParticipacion(PersEmpr proveedorParticipacion) {
		this.proveedorParticipacion = proveedorParticipacion;
	}

	public void setProveedorParticipacionId(Long proveedorParticipacionId) {
		this.proveedorParticipacionId = proveedorParticipacionId;
	}

}
