package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ConsultaCajaMenorDTO {

	private	Date	fecha_registro	;
	private	BigDecimal	anio	;
	private	BigDecimal	mes	;
	private	String	anio_mes	;
	private	BigInteger	consecutivo	;
	private	BigDecimal	valor	;
	private	String	detalle_nota	;
	private	String	cod_caja_menor	;
	private	String	nom_caja_menor	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	String	login	;
	private	String	estado	;
	private BigInteger datCajaMenorId;
	private String observacion;
	private String nomLabor;
	private String codProveedor;
	private String nomProveedor;
	private String numFactura;
	private String centroCosto;
	
	
	
	
	public String getNumFactura() {
		return numFactura;
	}
	public String getCentroCosto() {
		return centroCosto;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}
	public String getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}
	public String getNomProveedor() {
		return nomProveedor;
	}
	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}
	public String getNomLabor() {
		return nomLabor;
	}
	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}
	public BigInteger getDatCajaMenorId() {
		return datCajaMenorId;
	}
	public void setDatCajaMenorId(BigInteger datCajaMenorId) {
		this.datCajaMenorId = datCajaMenorId;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getFecha_registro() {
		
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
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
	public String getAnio_mes() {
		return anio_mes;
	}
	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getDetalle_nota() {
		return detalle_nota;
	}
	public void setDetalle_nota(String detalle_nota) {
		this.detalle_nota = detalle_nota;
	}
	public String getCod_caja_menor() {
		return cod_caja_menor;
	}
	public void setCod_caja_menor(String cod_caja_menor) {
		this.cod_caja_menor = cod_caja_menor;
	}
	public String getNom_caja_menor() {
		return nom_caja_menor;
	}
	public void setNom_caja_menor(String nom_caja_menor) {
		this.nom_caja_menor = nom_caja_menor;
	}
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public String getNom_equipo() {
		return nom_equipo;
	}
	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
