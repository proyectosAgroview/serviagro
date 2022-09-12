package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatProvicionesCierreNominaMqDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatProvicionesCierreNominaMqDTO.class);
    private Long anioRegistro;
    private Long compania;
    private Long datProvicionesCierreNominaMqId;
    private Double devengos;
    private Date fechaCreacion;
    private Date fechaFinal;
    private Date fechaInicial;
    private Date fechaModificacion;
    private Long gastoId;
    private Long mes;
    private String periodoLiquidacion;
    private String tipoMovimiento;
    private Long usuarioDigitacion;
    private Double valorDeduccion;
    private Long ceptoNominaId_ConceptoNomina;
    private Long trabId_Trabajador;
	private Long centCostId;
	
	
    public Long getCentCostId() {
		return centCostId;
	}

	public void setCentCostId(Long centCostId) {
		this.centCostId = centCostId;
	}

	public Long getAnioRegistro() {
        return anioRegistro;
    }

    public void setAnioRegistro(Long anioRegistro) {
        this.anioRegistro = anioRegistro;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getDatProvicionesCierreNominaMqId() {
        return datProvicionesCierreNominaMqId;
    }

    public void setDatProvicionesCierreNominaMqId(
        Long datProvicionesCierreNominaMqId) {
        this.datProvicionesCierreNominaMqId = datProvicionesCierreNominaMqId;
    }

    public Double getDevengos() {
        return devengos;
    }

    public void setDevengos(Double devengos) {
        this.devengos = devengos;
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

    public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Long getGastoId() {
        return gastoId;
    }

    public void setGastoId(Long gastoId) {
        this.gastoId = gastoId;
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public String getPeriodoLiquidacion() {
        return periodoLiquidacion;
    }

    public void setPeriodoLiquidacion(String periodoLiquidacion) {
        this.periodoLiquidacion = periodoLiquidacion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getValorDeduccion() {
        return valorDeduccion;
    }

    public void setValorDeduccion(Double valorDeduccion) {
        this.valorDeduccion = valorDeduccion;
    }

    public Long getCeptoNominaId_ConceptoNomina() {
        return ceptoNominaId_ConceptoNomina;
    }

    public void setCeptoNominaId_ConceptoNomina(
        Long ceptoNominaId_ConceptoNomina) {
        this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
    }

    public Long getTrabId_Trabajador() {
        return trabId_Trabajador;
    }

    public void setTrabId_Trabajador(Long trabId_Trabajador) {
        this.trabId_Trabajador = trabId_Trabajador;
    }
}
