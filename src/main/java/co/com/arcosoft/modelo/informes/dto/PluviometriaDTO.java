package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PluviometriaDTO {

	private BigDecimal precipitacion;
	private Date fecha;
	private Integer anio;
	private Integer mes;
	private String fechaCorta;
	private Integer dia;
	private String nombrePluvio;
	private BigDecimal precipitacion_acum;

	public BigDecimal getPrecipitacion_acum() {
		return precipitacion_acum;
	}

	public void setPrecipitacion_acum(BigDecimal precipitacion_acum) {
		this.precipitacion_acum = precipitacion_acum;
	}

	public String getNombrePluvio() {
		return nombrePluvio;
	}

	public void setNombrePluvio(String nombrePluvio) {
		this.nombrePluvio = nombrePluvio;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getFechaCorta() {
		return fechaCorta;
	}

	public void setFechaCorta(String fechaCorta) {
		this.fechaCorta = fechaCorta;
	}

	public BigDecimal getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(BigDecimal precipitacion) {
		this.precipitacion = precipitacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Pluviometria [precipitacion=" + precipitacion + ", fecha=" + fecha + ", anio=" + anio + ", mes=" + mes
				+ "]";
	}

}
