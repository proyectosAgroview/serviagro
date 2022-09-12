package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class ProgramaRiegosDTO {

	private String nombreCompania;
	private Integer anio;
	private Integer mes;
	private String fecha;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String codLote;
	private String codLabor;
	private String nombreLabor;
	private String nomInfraestructura;
	private String nomSistemaRiego;
	private BigDecimal areaRegada;
	private BigDecimal horasRiego;
	private BigDecimal caudalLote;
	private BigDecimal m3h;
	private BigDecimal m3Totales;
	private String nomLote;

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public String getCodLote() {
		return codLote;
	}

	public void setCodLote(String codLote) {
		this.codLote = codLote;
	}

	public String getNomInfraestructura() {
		return nomInfraestructura;
	}

	public void setNomInfraestructura(String nomInfraestructura) {
		this.nomInfraestructura = nomInfraestructura;
	}

	public String getNomSistemaRiego() {
		return nomSistemaRiego;
	}

	public void setNomSistemaRiego(String nomSistemaRiego) {
		this.nomSistemaRiego = nomSistemaRiego;
	}

	public BigDecimal getAreaRegada() {
		return areaRegada;
	}

	public void setAreaRegada(BigDecimal areaRegada) {
		this.areaRegada = areaRegada;
	}

	public BigDecimal getHorasRiego() {
		return horasRiego;
	}

	public void setHorasRiego(BigDecimal horasRiego) {
		this.horasRiego = horasRiego;
	}

	public BigDecimal getCaudalLote() {
		return caudalLote;
	}

	public void setCaudalLote(BigDecimal caudalLote) {
		this.caudalLote = caudalLote;
	}

	public BigDecimal getM3h() {
		return m3h;
	}

	public void setM3h(BigDecimal m3h) {
		this.m3h = m3h;
	}

	public BigDecimal getM3Totales() {
		return m3Totales;
	}

	public void setM3Totales(BigDecimal m3Totales) {
		this.m3Totales = m3Totales;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

}
