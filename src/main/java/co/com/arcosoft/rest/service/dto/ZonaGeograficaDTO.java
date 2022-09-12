package co.com.arcosoft.rest.service.dto;

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
public class ZonaGeograficaDTO  {

	private String codigo;
	private String nombre;
	private Long zonaGeograficaId;
	private Long compania;
	
	
	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getZonaGeograficaId() {
		return zonaGeograficaId;
	}

	public void setZonaGeograficaId(Long zonaGeograficaId) {
		this.zonaGeograficaId = zonaGeograficaId;
	}

	
	
}
