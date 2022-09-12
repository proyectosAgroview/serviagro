package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Variedad;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class VariedadNivel4DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VariedadNivel4DTO.class);
	private Double porcentajeArea;
	private Long variedadNivel4Id;
	private Long nivel4Id_Nivel4;
	private Variedad variedId_Variedad;
	private String nombreVariedad;

	public String getNombreVariedad() {
		return nombreVariedad;
	}

	public void setNombreVariedad(String nombreVariedad) {
		this.nombreVariedad = nombreVariedad;
	}

	public Double getPorcentajeArea() {
		return porcentajeArea;
	}

	public void setPorcentajeArea(Double porcentajeArea) {
		this.porcentajeArea = porcentajeArea;
	}

	public Long getVariedadNivel4Id() {
		return variedadNivel4Id;
	}

	public void setVariedadNivel4Id(Long variedadNivel4Id) {
		this.variedadNivel4Id = variedadNivel4Id;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Variedad getVariedId_Variedad() {
		return variedId_Variedad;
	}

	public void setVariedId_Variedad(Variedad variedId_Variedad) {
		this.variedId_Variedad = variedId_Variedad;
	}
}
