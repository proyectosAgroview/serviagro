package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatNominaTrabajadorMqdetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorMqdetDTO.class);
    private Double cantidad;
    private ConceptoNomina ceptoNominaId;
    private Long datNominaTrabajadorMqdetId;
    private UdadMed udadMedId;
    private Double valorTotal;
    private Long datNominaTrabajadorMqId_DatNominaTrabajadorMq;
    private Trabajador trabId_Trabajador;
    private String nombreTrabajador;
    private String nombreUdadMed;
    private String nombreConceptoNomina;
    
    private Long equipoId;
    private String codEquipo;
    private Double valorDeduccion;
    private String detalleNota;
    private String tipoMovimiento;
    private Date fechaInicialVac;
    private Date fechaFinalVac;
	private Long centCostId_CentCost;
	private String nombreCentroCosto;
	
	
	
    
    
	public String getNombreCentroCosto() {
		return nombreCentroCosto;
	}
	public void setNombreCentroCosto(String nombreCentroCosto) {
		this.nombreCentroCosto = nombreCentroCosto;
	}
	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}
	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}
	public Date getFechaInicialVac() {
		return fechaInicialVac;
	}
	public Date getFechaFinalVac() {
		return fechaFinalVac;
	}
	public void setFechaInicialVac(Date fechaInicialVac) {
		this.fechaInicialVac = fechaInicialVac;
	}
	public void setFechaFinalVac(Date fechaFinalVac) {
		this.fechaFinalVac = fechaFinalVac;
	}
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	public Long getEquipoId() {
		return equipoId;
	}
	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}
	public Double getValorDeduccion() {
		return valorDeduccion;
	}
	public void setValorDeduccion(Double valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}
	public String getDetalleNota() {
		return detalleNota;
	}
	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}
	public String getNombreUdadMed() {
		return nombreUdadMed;
	}
	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}
	public String getNombreConceptoNomina() {
		return nombreConceptoNomina;
	}
	public void setNombreConceptoNomina(String nombreConceptoNomina) {
		this.nombreConceptoNomina = nombreConceptoNomina;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public ConceptoNomina getCeptoNominaId() {
		return ceptoNominaId;
	}
	public void setCeptoNominaId(ConceptoNomina ceptoNominaId) {
		this.ceptoNominaId = ceptoNominaId;
	}
	public Long getDatNominaTrabajadorMqdetId() {
		return datNominaTrabajadorMqdetId;
	}
	public void setDatNominaTrabajadorMqdetId(Long datNominaTrabajadorMqdetId) {
		this.datNominaTrabajadorMqdetId = datNominaTrabajadorMqdetId;
	}
	public UdadMed getUdadMedId() {
		return udadMedId;
	}
	public void setUdadMedId(UdadMed udadMedId) {
		this.udadMedId = udadMedId;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Long getDatNominaTrabajadorMqId_DatNominaTrabajadorMq() {
		return datNominaTrabajadorMqId_DatNominaTrabajadorMq;
	}
	public void setDatNominaTrabajadorMqId_DatNominaTrabajadorMq(Long datNominaTrabajadorMqId_DatNominaTrabajadorMq) {
		this.datNominaTrabajadorMqId_DatNominaTrabajadorMq = datNominaTrabajadorMqId_DatNominaTrabajadorMq;
	}
	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}
	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}



}
