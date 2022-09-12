package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DisponibilidadHidricaDTO {

	private String nombreCompania;
	private Integer anio;
	private Integer mes;
	private Date fecha;
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
	private BigDecimal totalAreaRegada;
	private String horaRiegoIni;
	private String horaRiegoFin;
	private BigDecimal totalHorometro;
	private BigDecimal kwhInicial;
	private BigDecimal kwhFinal;
	private BigDecimal surcosLargos;
	private BigDecimal surcosCortos;
	private BigDecimal numeroRiegos;
	private BigDecimal areaNeta;
	private String mesCorto;
	private BigInteger datRiegoId;
	private BigInteger consecutivo;
	private BigDecimal horometroInicial;
	private BigDecimal horometroFinal;
	
	public BigDecimal getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(BigDecimal areaNeta) {
		this.areaNeta = areaNeta;
	}

	public String getMesCorto() {
		return mesCorto;
	}

	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
	}

	public BigDecimal getTotalAreaRegada() {
		return totalAreaRegada;
	}

	public void setTotalAreaRegada(BigDecimal totalAreaRegada) {
		this.totalAreaRegada = totalAreaRegada;
	}

	public String getHoraRiegoIni() {
		return horaRiegoIni;
	}

	public void setHoraRiegoIni(String horaRiegoIni) {
		this.horaRiegoIni = horaRiegoIni;
	}

	public String getHoraRiegoFin() {
		return horaRiegoFin;
	}

	public void setHoraRiegoFin(String horaRiegoFin) {
		this.horaRiegoFin = horaRiegoFin;
	}

	public BigDecimal getTotalHorometro() {
		return totalHorometro;
	}

	public void setTotalHorometro(BigDecimal totalHorometro) {
		this.totalHorometro = totalHorometro;
	}

	public BigDecimal getKwhInicial() {
		return kwhInicial;
	}

	public void setKwhInicial(BigDecimal kwhInicial) {
		this.kwhInicial = kwhInicial;
	}

	public BigDecimal getKwhFinal() {
		return kwhFinal;
	}

	public void setKwhFinal(BigDecimal kwhFinal) {
		this.kwhFinal = kwhFinal;
	}

	public BigDecimal getSurcosLargos() {
		return surcosLargos;
	}

	public void setSurcosLargos(BigDecimal surcosLargos) {
		this.surcosLargos = surcosLargos;
	}

	public BigDecimal getSurcosCortos() {
		return surcosCortos;
	}

	public void setSurcosCortos(BigDecimal surcosCortos) {
		this.surcosCortos = surcosCortos;
	}

	public BigDecimal getNumeroRiegos() {
		return numeroRiegos;
	}

	public void setNumeroRiegos(BigDecimal numeroRiegos) {
		this.numeroRiegos = numeroRiegos;
	}

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	public BigInteger getDatRiegoId() {
		return datRiegoId;
	}

	public void setDatRiegoId(BigInteger datRiegoId) {
		this.datRiegoId = datRiegoId;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public BigDecimal getHorometroInicial() {
		return horometroInicial;
	}

	public void setHorometroInicial(BigDecimal horometroInicial) {
		this.horometroInicial = horometroInicial;
	}

	public BigDecimal getHorometroFinal() {
		return horometroFinal;
	}

	public void setHorometroFinal(BigDecimal horometroFinal) {
		this.horometroFinal = horometroFinal;
	}

}
