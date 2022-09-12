package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class Nivel4DTO {

	private Long nivel4Id;
	private Long nivel3;
	private Long nivel2;
	private Long nivel1;
	private Long almacen;
	private String codigo;
	public Long compania;
	private String nombre;
	private Double areaBruta;
	private Double areaMecanizada;
	private Double areaManual;
	private Double areaInutil;
	private Double areaOtrosCultivos;
	private Double areaReservada;
	private Double areaRestringida;
	private Double areaNeta;
	private Float longitud;
	private Float latitud;
	private Float precision;
	private Long numPlantasSembradas;
	private Long numPlantasActuales;
	private Double numDensidadSiembra;
	private Long numLineasSembradas;
	private Long numPlantasSembradas2;
	private Long anioFiscal;
	private String estado;
	private Date fechaStart;

	public Nivel4DTO() {
	}
	
	public Long getNivel1() {
		return nivel1;
	}

	public void setNivel1(Long nivel1) {
		this.nivel1 = nivel1;
	}



	public Date getFechaStart() {
		return fechaStart;
	}

	public void setFechaStart(Date fechaStart) {
		this.fechaStart = fechaStart;
	}

	public Long getNivel4Id() {
		return this.nivel4Id;
	}

	public void setNivel4Id(Long nivel4Id) {
		this.nivel4Id = nivel4Id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getAreaBruta() {
		return this.areaBruta;
	}

	public void setAreaBruta(Double areaBruta) {
		this.areaBruta = areaBruta;
	}

	public Double getAreaMecanizada() {
		return this.areaMecanizada;
	}

	public void setAreaMecanizada(Double areaMecanizada) {
		this.areaMecanizada = areaMecanizada;
	}

	public Double getAreaManual() {
		return this.areaManual;
	}

	public void setAreaManual(Double areaManual) {
		this.areaManual = areaManual;
	}

	public Double getAreaInutil() {
		return this.areaInutil;
	}

	public void setAreaInutil(Double areaInutil) {
		this.areaInutil = areaInutil;
	}

	public Double getAreaOtrosCultivos() {
		return this.areaOtrosCultivos;
	}

	public void setAreaOtrosCultivos(Double areaOtrosCultivos) {
		this.areaOtrosCultivos = areaOtrosCultivos;
	}

	public Double getAreaReservada() {
		return this.areaReservada;
	}

	public void setAreaReservada(Double areaReservada) {
		this.areaReservada = areaReservada;
	}

	public Double getAreaRestringida() {
		return this.areaRestringida;
	}

	public void setAreaRestringida(Double areaRestringida) {
		this.areaRestringida = areaRestringida;
	}

	public Double getAreaNeta() {
		return this.areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getPrecision() {
		return this.precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public Long getNumPlantasSembradas() {
		return this.numPlantasSembradas;
	}

	public void setNumPlantasSembradas(Long numPlantasSembradas) {
		this.numPlantasSembradas = numPlantasSembradas;
	}

	public Long getNumPlantasActuales() {
		return this.numPlantasActuales;
	}

	public void setNumPlantasActuales(Long numPlantasActuales) {
		this.numPlantasActuales = numPlantasActuales;
	}

	public Double getNumDensidadSiembra() {
		return this.numDensidadSiembra;
	}

	public void setNumDensidadSiembra(Double numDensidadSiembra) {
		this.numDensidadSiembra = numDensidadSiembra;
	}

	public Long getNumLineasSembradas() {
		return this.numLineasSembradas;
	}

	public void setNumLineasSembradas(Long numLineasSembradas) {
		this.numLineasSembradas = numLineasSembradas;
	}

	public Long getNumPlantasSembradas2() {
		return this.numPlantasSembradas2;
	}

	public void setNumPlantasSembradas2(Long numPlantasSembradas2) {
		this.numPlantasSembradas2 = numPlantasSembradas2;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getNivel3() {
		return nivel3;
	}

	public Long getAlmacen() {
		return almacen;
	}

	public void setNivel3(Long nivel3) {
		this.nivel3 = nivel3;
	}

	public void setAlmacen(Long almacen) {
		this.almacen = almacen;
	}

	public Long getNivel2() {
		return nivel2;
	}

	public void setNivel2(Long nivel2) {
		this.nivel2 = nivel2;
	}

	public Long getAnioFiscal() {
		return anioFiscal;
	}

	public void setAnioFiscal(Long anioFiscal) {
		this.anioFiscal = anioFiscal;
	}

}
