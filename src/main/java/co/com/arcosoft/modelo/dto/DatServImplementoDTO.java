package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatServImplementoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatServImplementoDTO.class);
	private Long compania;
	private Double costoTotalImplemento;
	private Long datServImpleId;
	private Double tarifaImplemento;
	private Long datServicioId_DatServicio;
	private Long equipoId_Equipo;
	private Long servicioId_Servicio;

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getCostoTotalImplemento() {
		return costoTotalImplemento;
	}

	public void setCostoTotalImplemento(Double costoTotalImplemento) {
		this.costoTotalImplemento = costoTotalImplemento;
	}

	public Long getDatServImpleId() {
		return datServImpleId;
	}

	public void setDatServImpleId(Long datServImpleId) {
		this.datServImpleId = datServImpleId;
	}

	public Double getTarifaImplemento() {
		return tarifaImplemento;
	}

	public void setTarifaImplemento(Double tarifaImplemento) {
		this.tarifaImplemento = tarifaImplemento;
	}

	public Long getDatServicioId_DatServicio() {
		return datServicioId_DatServicio;
	}

	public void setDatServicioId_DatServicio(Long datServicioId_DatServicio) {
		this.datServicioId_DatServicio = datServicioId_DatServicio;
	}

	public Long getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public void setEquipoId_Equipo(Long equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public Long getServicioId_Servicio() {
		return servicioId_Servicio;
	}

	public void setServicioId_Servicio(Long servicioId_Servicio) {
		this.servicioId_Servicio = servicioId_Servicio;
	}
}
