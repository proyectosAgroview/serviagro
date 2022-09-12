package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class IndicadoresRiegoDTO {

	private BigDecimal areaRegada;
	private BigDecimal metrosCubicosTotales;
	private Integer anio;
	private Integer mes;
	private String anioMes;
	private String nombreCompania;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public BigDecimal getAreaRegada() {
		return areaRegada;
	}

	public void setAreaRegada(BigDecimal areaRegada) {
		this.areaRegada = areaRegada;
	}

	public BigDecimal getMetrosCubicosTotales() {
		return metrosCubicosTotales;
	}

	public void setMetrosCubicosTotales(BigDecimal metrosCubicosTotales) {
		this.metrosCubicosTotales = metrosCubicosTotales;
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
		return "IndicadoresRiego [areaRegada=" + areaRegada + ", metrosCubicosTotales=" + metrosCubicosTotales
				+ ",  anio=" + anio + ", mes=" + mes + "]";
	}

}
