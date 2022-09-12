package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class RendimientoTrabajadoresDTO {

	private String nombreCompania;
	private String codTrabajador;
	private String nombreTrabajador;
	private BigDecimal cantidadRed;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public BigDecimal getCantidadRed() {
		return cantidadRed;
	}

	public void setCantidadRed(BigDecimal cantidadRend) {
		this.cantidadRed = cantidadRend;
	}

}
