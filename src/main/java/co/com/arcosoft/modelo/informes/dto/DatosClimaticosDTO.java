package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DatosClimaticosDTO {

	private String cod_estacion_clima;
	private String nom_estacion_clima;
	private Date fecha_lluvia;
	private BigInteger anio;
	private BigInteger mes;
	private String mes_corto;
	private BigDecimal precipitacion;
	private BigDecimal temperatura_maxima;
	private BigDecimal temperatura_media;
	private BigDecimal temperatura_minima;
	private BigDecimal temperatura_ambiente;
	private BigDecimal sensacion_termica;
	private BigDecimal humedad_maxima;
	private BigDecimal humedad_media;
	private BigDecimal humedad_minima;
	private BigDecimal humedad_exterior;
	private BigDecimal humedad_interior;
	private BigDecimal evaporacion;
	private BigDecimal evaporacion_transpiracion;
	private BigDecimal insolacion;
	private BigDecimal energia_solar;
	private BigDecimal radiacion_solar;
	private BigDecimal nubosidad;
	private BigDecimal horas_sol;
	private BigDecimal punto_rocio;
	private BigDecimal velocidad_viento;
	private BigDecimal velocidad_maxima;
	private BigDecimal direccion_viento;
	private BigDecimal grados_dia_calor;
	private BigDecimal grados_dia_frio;
	private BigDecimal horas_luz;
	private String observacion;

	public String getCod_estacion_clima() {
		return cod_estacion_clima;
	}

	public void setCod_estacion_clima(String cod_estacion_clima) {
		this.cod_estacion_clima = cod_estacion_clima;
	}

	public String getNom_estacion_clima() {
		return nom_estacion_clima;
	}

	public void setNom_estacion_clima(String nom_estacion_clima) {
		this.nom_estacion_clima = nom_estacion_clima;
	}

	public Date getFecha_lluvia() {
		return fecha_lluvia;
	}

	public void setFecha_lluvia(Date fecha_lluvia) {
		this.fecha_lluvia = fecha_lluvia;
	}

	public BigInteger getAnio() {
		return anio;
	}

	public void setAnio(BigInteger anio) {
		this.anio = anio;
	}

	public BigInteger getMes() {
		return mes;
	}

	public void setMes(BigInteger mes) {
		this.mes = mes;
	}

	public String getMes_corto() {
		return mes_corto;
	}

	public void setMes_corto(String mes_corto) {
		this.mes_corto = mes_corto;
	}

	public BigDecimal getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(BigDecimal precipitacion) {
		this.precipitacion = precipitacion;
	}

	public BigDecimal getTemperatura_maxima() {
		return temperatura_maxima;
	}

	public void setTemperatura_maxima(BigDecimal temperatura_maxima) {
		this.temperatura_maxima = temperatura_maxima;
	}

	public BigDecimal getTemperatura_media() {
		return temperatura_media;
	}

	public void setTemperatura_media(BigDecimal temperatura_media) {
		this.temperatura_media = temperatura_media;
	}

	public BigDecimal getTemperatura_minima() {
		return temperatura_minima;
	}

	public void setTemperatura_minima(BigDecimal temperatura_minima) {
		this.temperatura_minima = temperatura_minima;
	}

	public BigDecimal getTemperatura_ambiente() {
		return temperatura_ambiente;
	}

	public void setTemperatura_ambiente(BigDecimal temperatura_ambiente) {
		this.temperatura_ambiente = temperatura_ambiente;
	}

	public BigDecimal getSensacion_termica() {
		return sensacion_termica;
	}

	public void setSensacion_termica(BigDecimal sensacion_termica) {
		this.sensacion_termica = sensacion_termica;
	}

	public BigDecimal getHumedad_maxima() {
		return humedad_maxima;
	}

	public void setHumedad_maxima(BigDecimal humedad_maxima) {
		this.humedad_maxima = humedad_maxima;
	}

	public BigDecimal getHumedad_media() {
		return humedad_media;
	}

	public void setHumedad_media(BigDecimal humedad_media) {
		this.humedad_media = humedad_media;
	}

	public BigDecimal getHumedad_minima() {
		return humedad_minima;
	}

	public void setHumedad_minima(BigDecimal humedad_minima) {
		this.humedad_minima = humedad_minima;
	}

	public BigDecimal getHumedad_exterior() {
		return humedad_exterior;
	}

	public void setHumedad_exterior(BigDecimal humedad_exterior) {
		this.humedad_exterior = humedad_exterior;
	}

	public BigDecimal getHumedad_interior() {
		return humedad_interior;
	}

	public void setHumedad_interior(BigDecimal humedad_interior) {
		this.humedad_interior = humedad_interior;
	}

	public BigDecimal getEvaporacion() {
		return evaporacion;
	}

	public void setEvaporacion(BigDecimal evaporacion) {
		this.evaporacion = evaporacion;
	}

	public BigDecimal getEvaporacion_transpiracion() {
		return evaporacion_transpiracion;
	}

	public void setEvaporacion_transpiracion(BigDecimal evaporacion_transpiracion) {
		this.evaporacion_transpiracion = evaporacion_transpiracion;
	}

	public BigDecimal getInsolacion() {
		return insolacion;
	}

	public void setInsolacion(BigDecimal insolacion) {
		this.insolacion = insolacion;
	}

	public BigDecimal getEnergia_solar() {
		return energia_solar;
	}

	public void setEnergia_solar(BigDecimal energia_solar) {
		this.energia_solar = energia_solar;
	}

	public BigDecimal getRadiacion_solar() {
		return radiacion_solar;
	}

	public void setRadiacion_solar(BigDecimal radiacion_solar) {
		this.radiacion_solar = radiacion_solar;
	}

	public BigDecimal getNubosidad() {
		return nubosidad;
	}

	public void setNubosidad(BigDecimal nubosidad) {
		this.nubosidad = nubosidad;
	}

	public BigDecimal getHoras_sol() {
		return horas_sol;
	}

	public void setHoras_sol(BigDecimal horas_sol) {
		this.horas_sol = horas_sol;
	}

	public BigDecimal getPunto_rocio() {
		return punto_rocio;
	}

	public void setPunto_rocio(BigDecimal punto_rocio) {
		this.punto_rocio = punto_rocio;
	}

	public BigDecimal getVelocidad_viento() {
		return velocidad_viento;
	}

	public void setVelocidad_viento(BigDecimal velocidad_viento) {
		this.velocidad_viento = velocidad_viento;
	}

	public BigDecimal getVelocidad_maxima() {
		return velocidad_maxima;
	}

	public void setVelocidad_maxima(BigDecimal velocidad_maxima) {
		this.velocidad_maxima = velocidad_maxima;
	}

	public BigDecimal getDireccion_viento() {
		return direccion_viento;
	}

	public void setDireccion_viento(BigDecimal direccion_viento) {
		this.direccion_viento = direccion_viento;
	}

	public BigDecimal getGrados_dia_calor() {
		return grados_dia_calor;
	}

	public void setGrados_dia_calor(BigDecimal grados_dia_calor) {
		this.grados_dia_calor = grados_dia_calor;
	}

	public BigDecimal getGrados_dia_frio() {
		return grados_dia_frio;
	}

	public void setGrados_dia_frio(BigDecimal grados_dia_frio) {
		this.grados_dia_frio = grados_dia_frio;
	}

	public BigDecimal getHoras_luz() {
		return horas_luz;
	}

	public void setHoras_luz(BigDecimal horas_luz) {
		this.horas_luz = horas_luz;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
