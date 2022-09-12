package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DatosEvaporimetrosDTO {

	private BigDecimal evaporacion;
	private Date fecha;
	private Integer anio;
	private Integer mes;
	private String fechaCorta;
	private String nombreEvaporimetro;

	public String getNombreEvaporimetro() {
		return nombreEvaporimetro;
	}

	public void setNombreEvaporimetro(String nombreEvaporimetro) {
		this.nombreEvaporimetro = nombreEvaporimetro;
	}

	public String getFechaCorta() {
		return fechaCorta;
	}

	public void setFechaCorta(String fechaCorta) {
		this.fechaCorta = fechaCorta;
	}

	public BigDecimal getEvaporacion() {
		return evaporacion;
	}

	public void setEvaporacion(BigDecimal evaporacion) {
		this.evaporacion = evaporacion;
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
		return "DatosEvaporimetros [evaporacion=" + evaporacion + ", fecha=" + fecha + ", anio=" + anio + ", mes=" + mes
				+ "]";
	}

}
