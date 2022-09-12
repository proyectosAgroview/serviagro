package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TarifaContratistaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaContratistaDTO.class);
	private Long compania;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Double tarifa;
	private Long tarifaCtrId;
	private Labor laborId_Labor;
	private PersEmpr persEmprId_PersEmpr;
	private ConceptoNomina servicioId_Servicio;
	private UdadMed udadMedId_UdadMed;
	private Profesion profesion;
	private String codServicio;
	private String codUdadMed;
	private String codLabor;
	private String codProfesion;
	private Double edadInicial;
	private Double  edadFinal;
	private Double  pesoPromedio;
	private String  estadoIncidencia;
	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;
	private String nombreNivel2;
	private String nombreNivel4;
	private String alturaPlanta;
	
	
	
	
	
	public String getAlturaPlanta() {
		return alturaPlanta;
	}

	public void setAlturaPlanta(String alturaPlanta) {
		this.alturaPlanta = alturaPlanta;
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

	public String getNombreNivel2() {
		return nombreNivel2;
	}

	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	public String getNombreNivel4() {
		return nombreNivel4;
	}

	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	public Double getEdadInicial() {
		return edadInicial;
	}

	public void setEdadInicial(Double edadInicial) {
		this.edadInicial = edadInicial;
	}

	public Double getEdadFinal() {
		return edadFinal;
	}

	public void setEdadFinal(Double edadFinal) {
		this.edadFinal = edadFinal;
	}

	public Double getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public String getEstadoIncidencia() {
		return estadoIncidencia;
	}

	public void setEstadoIncidencia(String estadoIncidencia) {
		this.estadoIncidencia = estadoIncidencia;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getCodServicio() {
		return codServicio;
	}

	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Long getTarifaCtrId() {
		return tarifaCtrId;
	}

	public void setTarifaCtrId(Long tarifaCtrId) {
		this.tarifaCtrId = tarifaCtrId;
	}

	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor labor) {
		this.laborId_Labor = labor;
	}

	public PersEmpr getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(PersEmpr persEmpr) {
		this.persEmprId_PersEmpr = persEmpr;
	}

	public ConceptoNomina getServicioId_Servicio() {
		return servicioId_Servicio;
	}

	public void setServicioId_Servicio(ConceptoNomina servicio) {
		this.servicioId_Servicio = servicio;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMed) {
		this.udadMedId_UdadMed = udadMed;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public String getCodProfesion() {
		return codProfesion;
	}

	public void setCodProfesion(String codProfesion) {
		this.codProfesion = codProfesion;
	}

}
