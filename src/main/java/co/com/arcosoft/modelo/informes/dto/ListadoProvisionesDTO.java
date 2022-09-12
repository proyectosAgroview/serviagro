package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ListadoProvisionesDTO {

	private BigInteger datProvisionesCierreNominaId;
	private Date fechaRegistro;
	private BigDecimal devengos;
	private String periodoLiquidacion;
	private BigDecimal valorDeduccion;
	private String nomTrabajador;
	private String nomCeptoNomina;
	private String nomLabor;
	private String loginUsuario;

	public BigInteger getDatProvisionesCierreNominaId() {
		return datProvisionesCierreNominaId;
	}

	public void setDatProvisionesCierreNominaId(BigInteger datProvisionesCierreNominaId) {
		this.datProvisionesCierreNominaId = datProvisionesCierreNominaId;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public BigDecimal getDevengos() {
		return devengos;
	}

	public void setDevengos(BigDecimal devengos) {
		this.devengos = devengos;
	}

	public String getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}

	public void setPeriodoLiquidacion(String periodoLiquidacion) {
		this.periodoLiquidacion = periodoLiquidacion;
	}

	public BigDecimal getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(BigDecimal valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public String getNomTrabajador() {
		return nomTrabajador;
	}

	public void setNomTrabajador(String nomTrabajador) {
		this.nomTrabajador = nomTrabajador;
	}

	public String getNomCeptoNomina() {
		return nomCeptoNomina;
	}

	public void setNomCeptoNomina(String nomCeptoNomina) {
		this.nomCeptoNomina = nomCeptoNomina;
	}

	public String getNomLabor() {
		return nomLabor;
	}

	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
}