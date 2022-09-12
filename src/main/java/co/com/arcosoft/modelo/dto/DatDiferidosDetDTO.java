package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Equipo;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatDiferidosDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatDiferidosDetDTO.class);
	private Long datDiferidosDetId;
	private Equipo equipoId;
	private Double valorFactura;
	private Long datDiferidosId_DatDiferidos;
	private String codEquipo;
	private Long implementoId;
	private String codImplemento;

	public Long getImplementoId() {
		return implementoId;
	}

	public String getCodImplemento() {
		return codImplemento;
	}

	public void setImplementoId(Long implementoId) {
		this.implementoId = implementoId;
	}

	public void setCodImplemento(String codImplemento) {
		this.codImplemento = codImplemento;
	}

	public Long getDatDiferidosDetId() {
		return datDiferidosDetId;
	}

	public void setDatDiferidosDetId(Long datDiferidosDetId) {
		this.datDiferidosDetId = datDiferidosDetId;
	}

	public Equipo getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Equipo equipoId) {
		this.equipoId = equipoId;
	}

	public Double getValorFactura() {
		return valorFactura;
	}

	public void setValorFactura(Double valorFactura) {
		this.valorFactura = valorFactura;
	}

	public Long getDatDiferidosId_DatDiferidos() {
		return datDiferidosId_DatDiferidos;
	}

	public void setDatDiferidosId_DatDiferidos(Long datDiferidosId_DatDiferidos) {
		this.datDiferidosId_DatDiferidos = datDiferidosId_DatDiferidos;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

}
