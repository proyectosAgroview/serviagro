package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatProgramaRiegoDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatProgramaRiegoDetDTO.class);
	private Double areaRegada;
	private Double caudalNivel4;
	private Long datProgramaRiegoDetId;
	private Double edadPrograma;
	private Date fechaEstimadaRiego;
	private Double horasEstimadas;
	private Long datProgramaRiegoId_DatProgramaRiego;
	private Infraestructura infraId_Infraestructura;
	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;

	private String nilve2Nombre;
	private String nivel4Nombre;
	private String infraeEstructuraNombre;

	public String getNilve2Nombre() {
		return nilve2Nombre;
	}

	public void setNilve2Nombre(String nilve2Nombre) {
		this.nilve2Nombre = nilve2Nombre;
	}

	public String getNivel4Nombre() {
		return nivel4Nombre;
	}

	public void setNivel4Nombre(String nivel4Nombre) {
		this.nivel4Nombre = nivel4Nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Double getAreaRegada() {
		return areaRegada;
	}

	public void setAreaRegada(Double areaRegada) {
		this.areaRegada = areaRegada;
	}

	public Double getCaudalNivel4() {
		return caudalNivel4;
	}

	public void setCaudalNivel4(Double caudalNivel4) {
		this.caudalNivel4 = caudalNivel4;
	}

	public Long getDatProgramaRiegoDetId() {
		return datProgramaRiegoDetId;
	}

	public void setDatProgramaRiegoDetId(Long datProgramaRiegoDetId) {
		this.datProgramaRiegoDetId = datProgramaRiegoDetId;
	}

	public Double getEdadPrograma() {
		return edadPrograma;
	}

	public void setEdadPrograma(Double edadPrograma) {
		this.edadPrograma = edadPrograma;
	}

	public Date getFechaEstimadaRiego() {
		return fechaEstimadaRiego;
	}

	public void setFechaEstimadaRiego(Date fechaEstimadaRiego) {
		this.fechaEstimadaRiego = fechaEstimadaRiego;
	}

	public Double getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(Double horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public Long getDatProgramaRiegoId_DatProgramaRiego() {
		return datProgramaRiegoId_DatProgramaRiego;
	}

	public void setDatProgramaRiegoId_DatProgramaRiego(Long datProgramaRiegoId_DatProgramaRiego) {
		this.datProgramaRiegoId_DatProgramaRiego = datProgramaRiegoId_DatProgramaRiego;
	}

	public Infraestructura getInfraId_Infraestructura() {
		return infraId_Infraestructura;
	}

	public void setInfraId_Infraestructura(Infraestructura infraId_Infraestructura) {
		this.infraId_Infraestructura = infraId_Infraestructura;
	}

	public String getInfraeEstructuraNombre() {
		return infraeEstructuraNombre;
	}

	public void setInfraeEstructuraNombre(String infraeEstructuraNombre) {
		this.infraeEstructuraNombre = infraeEstructuraNombre;
	}

	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

}
