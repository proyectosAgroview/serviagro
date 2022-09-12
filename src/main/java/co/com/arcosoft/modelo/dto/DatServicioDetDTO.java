package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatServicioDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatServicioDetDTO.class);
	private Double cantidadPago;
	private Double cantidadProd;
	private Long compania;
	private Double costoTotal;
	private Long datServicioDetId;
	private Long datServicioId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date horaFinal;
	private Date horaInicial;
	private Double tiempoInactivo;
	private Double totalHoras;
	private Double valorUnit;
	private Equipo equipoId_Equipo;
	private Long persEmprId_PersEmpr;
	private UdadMed udadMedPago;
	private Long udadMedProd;
	private String codigoEquipo;
	private String codigoUmPago;
	private Double horometroInicial;
	private Double horometroFinal;
	
	private DatPlanLaborDet ordenTrabajo;
	private Nivel4 nivel4;
	private Nivel2 nivel2Id;
	private Labor laborId;
	
	private String nombreLabor;
	private String nombreNivel2;
	private String nombreNivel4;
	private String nombreOs;
	private Long etapaId;
	private Long variedId;
	
	
	private Double edad;
	
	
	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Long getVariedId() {
		return variedId;
	}

	public void setVariedId(Long variedId) {
		this.variedId = variedId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
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

	public Long getDatServicioDetId() {
		return datServicioDetId;
	}

	public void setDatServicioDetId(Long datServicioDetId) {
		this.datServicioDetId = datServicioDetId;
	}

	public Long getDatServicioId() {
		return datServicioId;
	}

	public void setDatServicioId(Long datServicioId) {
		this.datServicioId = datServicioId;
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

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Double getTiempoInactivo() {
		return tiempoInactivo;
	}

	public void setTiempoInactivo(Double tiempoInactivo) {
		this.tiempoInactivo = tiempoInactivo;
	}

	public Double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Double totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Long getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public UdadMed getUdadMedPago() {
		return udadMedPago;
	}

	public void setUdadMedPago(UdadMed udadMedPago) {
		this.udadMedPago = udadMedPago;
	}

	public Long getUdadMedProd() {
		return udadMedProd;
	}

	public void setUdadMedProd(Long udadMedProd) {
		this.udadMedProd = udadMedProd;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public String getCodigoUmPago() {
		return codigoUmPago;
	}

	public void setCodigoUmPago(String codigoUmPago) {
		this.codigoUmPago = codigoUmPago;
	}

	public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public Equipo getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public Double getHorometroInicial() {
		return horometroInicial;
	}

	public Double getHorometroFinal() {
		return horometroFinal;
	}

	public void setHorometroInicial(Double horometroInicial) {
		this.horometroInicial = horometroInicial;
	}

	public void setHorometroFinal(Double horometroFinal) {
		this.horometroFinal = horometroFinal;
	}

}
