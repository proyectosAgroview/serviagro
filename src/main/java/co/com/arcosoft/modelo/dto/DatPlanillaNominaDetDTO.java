package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatPlanillaNominaDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanillaNominaDetDTO.class);
	private Double cantidadPago;
	private Double cantidadProd;
	private String cierreCostos;
	private Long compania;
	private Double costoTotal;
	private Long detPlanillaNominaId;
	private Long eqpTrabId;
	private String estado;
	private Long etapaId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String observacion;
	private Long planillaNominaId;
	private Double valorUnitario;
	private Long variedId;
	private ConceptoNomina ceptoNominaId_ConceptoNomina;
	private PersEmpr persEmprId_PersEmpr;
	private Trabajador trabId_Trabajador;
	private UdadMed udadMedIdPago;
	private Long udadMedProd;

	private String codTrabajador;
	private String codConceptoNomina;
	private String codUmPago;
	private Double cantidadDescontar;
	private String estadoIncidencia;
	private String alturaPlanta;

	private Long numeroTiquete;
	private Double pesoPromedio;
	private DatPlanLaborDet ordenTrabajo;
	private Nivel4 nivel4;
	private Nivel2 nivel2Id;
	private Labor laborId;

	private String nombreLabor;
	private String nombreNivel2;
	private String nombreNivel4;
	private String nombreOs;

	private Double edad;
	private Double horasTrabajadas;
	private Equipo equipoId;
	private String nombreEquipo;

	private String tipoServicio;
	private UdadMed udadMedMaq;
	private Double horometroInicial;
	private Double horometroFinal;
	private Double horometroTotal;
	private Double cantidadMaq;
	private Double valorTotalMaq;
	private String nomUdadMedMaq;
	private Double valorUnitarioMaq;
	
	private String tipoPersona;
	private Equipo implementoId;
	private String nombreImplemento;
	private String nombrePersEmpr;
	
	
	
	
	
	
	
	
	public PersEmpr getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(PersEmpr persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public String getNombrePersEmpr() {
		return nombrePersEmpr;
	}

	public void setNombrePersEmpr(String nombrePersEmpr) {
		this.nombrePersEmpr = nombrePersEmpr;
	}



	public Equipo getImplementoId() {
		return implementoId;
	}

	public void setImplementoId(Equipo implementoId) {
		this.implementoId = implementoId;
	}

	public String getNombreImplemento() {
		return nombreImplemento;
	}

	public void setNombreImplemento(String nombreImplemento) {
		this.nombreImplemento = nombreImplemento;
	}

	

	public Double getValorUnitarioMaq() {
		return valorUnitarioMaq;
	}

	public void setValorUnitarioMaq(Double valorUnitarioMaq) {
		this.valorUnitarioMaq = valorUnitarioMaq;
	}

	public String getNomUdadMedMaq() {
		return nomUdadMedMaq;
	}

	public void setNomUdadMedMaq(String nomUdadMedMaq) {
		this.nomUdadMedMaq = nomUdadMedMaq;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public UdadMed getUdadMedMaq() {
		return udadMedMaq;
	}

	public void setUdadMedMaq(UdadMed udadMedMaq) {
		this.udadMedMaq = udadMedMaq;
	}

	

	public Double getHorometroInicial() {
		return horometroInicial;
	}

	public void setHorometroInicial(Double horometroInicial) {
		this.horometroInicial = horometroInicial;
	}

	public Double getHorometroFinal() {
		return horometroFinal;
	}

	public void setHorometroFinal(Double horometroFinal) {
		this.horometroFinal = horometroFinal;
	}

	public Double getHorometroTotal() {
		return horometroTotal;
	}

	public void setHorometroTotal(Double horometroTotal) {
		this.horometroTotal = horometroTotal;
	}

	

	public Double getCantidadMaq() {
		return cantidadMaq;
	}

	public void setCantidadMaq(Double cantidadMaq) {
		this.cantidadMaq = cantidadMaq;
	}

	public Double getValorTotalMaq() {
		return valorTotalMaq;
	}

	public void setValorTotalMaq(Double valorTotalMaq) {
		this.valorTotalMaq = valorTotalMaq;
	}

	/**
	 * @return the nombreEquipo
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * @param nombreEquipo the nombreEquipo to set
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * @return the horasTrabajadas
	 */
	public Double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	/**
	 * @param horasTrabajadas the horasTrabajadas to set
	 */
	public void setHorasTrabajadas(Double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	/**
	 * @return the equipoId
	 */
	public Equipo getEquipoId() {
		return equipoId;
	}

	/**
	 * @param equipoId the equipoId to set
	 */
	public void setEquipoId(Equipo equipoId) {
		this.equipoId = equipoId;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}

	public Long getNumeroTiquete() {
		return numeroTiquete;
	}

	public void setNumeroTiquete(Long numeroTiquete) {
		this.numeroTiquete = numeroTiquete;
	}

	public Double getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public DatPlanLaborDet getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(DatPlanLaborDet ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public Nivel4 getNivel4() {
		return nivel4;
	}

	public void setNivel4(Nivel4 nivel4) {
		this.nivel4 = nivel4;
	}

	public Nivel2 getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Nivel2 nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Labor getLaborId() {
		return laborId;
	}

	public void setLaborId(Labor laborId) {
		this.laborId = laborId;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
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

	public String getNombreOs() {
		return nombreOs;
	}

	public void setNombreOs(String nombreOs) {
		this.nombreOs = nombreOs;
	}

	public String getAlturaPlanta() {
		return alturaPlanta;
	}

	public void setAlturaPlanta(String alturaPlanta) {
		this.alturaPlanta = alturaPlanta;
	}

	public String getEstadoIncidencia() {
		return estadoIncidencia;
	}

	public void setEstadoIncidencia(String estadoIncidencia) {
		this.estadoIncidencia = estadoIncidencia;
	}

	public Double getCantidadDescontar() {
		return cantidadDescontar;
	}

	public void setCantidadDescontar(Double cantidadDescontar) {
		this.cantidadDescontar = cantidadDescontar;
	}

	public Double getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public Double getCantidadProd() {
		return cantidadProd;
	}

	public void setCantidadProd(Double cantidadProd) {
		this.cantidadProd = cantidadProd;
	}

	public String getCierreCostos() {
		return cierreCostos;
	}

	public void setCierreCostos(String cierreCostos) {
		this.cierreCostos = cierreCostos;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDetPlanillaNominaId() {
		return detPlanillaNominaId;
	}

	public void setDetPlanillaNominaId(Long detPlanillaNominaId) {
		this.detPlanillaNominaId = detPlanillaNominaId;
	}

	public Long getEqpTrabId() {
		return eqpTrabId;
	}

	public void setEqpTrabId(Long eqpTrabId) {
		this.eqpTrabId = eqpTrabId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getPlanillaNominaId() {
		return planillaNominaId;
	}

	public void setPlanillaNominaId(Long planillaNominaId) {
		this.planillaNominaId = planillaNominaId;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
	}

	public ConceptoNomina getCeptoNominaId_ConceptoNomina() {
		return ceptoNominaId_ConceptoNomina;
	}

	public void setCeptoNominaId_ConceptoNomina(ConceptoNomina ceptoNominaId_ConceptoNomina) {
		this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
	}

	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public UdadMed getUdadMedIdPago() {
		return udadMedIdPago;
	}

	public void setUdadMedIdPago(UdadMed udadMedIdPago) {
		this.udadMedIdPago = udadMedIdPago;
	}

	public Long getUdadMedProd() {
		return udadMedProd;
	}

	public void setUdadMedProd(Long udadMedProd) {
		this.udadMedProd = udadMedProd;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getCodConceptoNomina() {
		return codConceptoNomina;
	}

	public void setCodConceptoNomina(String codConceptoNomina) {
		this.codConceptoNomina = codConceptoNomina;
	}

	public String getCodUmPago() {
		return codUmPago;
	}

	public void setCodUmPago(String codUmPago) {
		this.codUmPago = codUmPago;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

}
