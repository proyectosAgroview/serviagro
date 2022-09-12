package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class HojaVidaLoteDTO {

	private String nombreCompania;
	private Integer anio;
	private Integer mes;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String loteA;
	private String codLabor;
	private String nombreLabor;
	private String codGrupoLabor;
	private String nombreGrupoLabor;

	private BigDecimal cantidadPago;
	private BigDecimal costoTotal;
	private String codUdadMedPago;

	private BigDecimal cantidadCos;
	private BigDecimal areaCos;
	private BigDecimal ingresos;
	private String codUdadMedCos;
	private String nombreElementoCosto;
	private String nombreProducto;
	private BigDecimal numeroCosechas1;
	private String fechaUltCorte;
	private BigDecimal edadUltCorte;
	private BigDecimal area;
	private BigDecimal rendimiento;
	private String variedad;
	private String productor;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
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

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getNomFinca() {
		return nomFinca;
	}

	public void setNomFinca(String nomFinca) {
		this.nomFinca = nomFinca;
	}

	public String getCodBloque() {
		return codBloque;
	}

	public void setCodBloque(String codBloque) {
		this.codBloque = codBloque;
	}

	public String getLoteA() {
		return loteA;
	}

	public void setLoteA(String loteA) {
		this.loteA = loteA;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getCodGrupoLabor() {
		return codGrupoLabor;
	}

	public void setCodGrupoLabor(String codGrupoLabor) {
		this.codGrupoLabor = codGrupoLabor;
	}

	public String getNombreGrupoLabor() {
		return nombreGrupoLabor;
	}

	public void setNombreGrupoLabor(String nombreGrupoLabor) {
		this.nombreGrupoLabor = nombreGrupoLabor;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String getCodUdadMedPago() {
		return codUdadMedPago;
	}

	public void setCodUdadMedPago(String codUdadMedPago) {
		this.codUdadMedPago = codUdadMedPago;
	}

	public BigDecimal getCantidadCos() {
		return cantidadCos;
	}

	public void setCantidadCos(BigDecimal cantidadCos) {
		this.cantidadCos = cantidadCos;
	}

	public BigDecimal getAreaCos() {
		return areaCos;
	}

	public void setAreaCos(BigDecimal areaCos) {
		this.areaCos = areaCos;
	}

	public BigDecimal getIngresos() {
		return ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public String getCodUdadMedCos() {
		return codUdadMedCos;
	}

	public void setCodUdadMedCos(String codUdadMedCos) {
		this.codUdadMedCos = codUdadMedCos;
	}

	public String getNombreElementoCosto() {
		return nombreElementoCosto;
	}

	public void setNombreElementoCosto(String nombreElementoCosto) {
		this.nombreElementoCosto = nombreElementoCosto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public BigDecimal getNumeroCosechas1() {
		return numeroCosechas1;
	}

	public void setNumeroCosechas1(BigDecimal numeroCosechas1) {
		this.numeroCosechas1 = numeroCosechas1;
	}

	public String getFechaUltCorte() {
		return fechaUltCorte;
	}

	public void setFechaUltCorte(String fechaUltCorte) {
		this.fechaUltCorte = fechaUltCorte;
	}

	public BigDecimal getEdadUltCorte() {
		return edadUltCorte;
	}

	public void setEdadUltCorte(BigDecimal edadUltCorte) {
		this.edadUltCorte = edadUltCorte;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

}
