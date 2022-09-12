package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Arcosoft1
 *
 */
public class ConsultaRegistrosUsuariosDTO {
	private String nomCompania;
	private	String	anio_mes;
	private	String	login;
	private	Date	fecha_creacion;
	private	String	origen_datos;
	private BigDecimal anio;
	private BigDecimal mes;
	private BigDecimal cantidadRegistros;
	
	public String getNomCompania() {
		return nomCompania;
	}
	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}
	public String getAnio_mes() {
		return anio_mes;
	}
	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getOrigen_datos() {
		return origen_datos;
	}
	public void setOrigen_datos(String origen_datos) {
		this.origen_datos = origen_datos;
	}
	public BigDecimal getAnio() {
		return anio;
	}
	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}
	public BigDecimal getMes() {
		return mes;
	}
	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}
	public BigDecimal getCantidadRegistros() {
		return cantidadRegistros;
	}
	public void setCantidadRegistros(BigDecimal cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}
	
	

}
