package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Arcosoft1
 *
 */
public class HorasMaquinaDetalladoDTO {

	private Integer anio;
	private Integer mes;
	private String codEquipo;
	private String nomEquipo;
	private String codPropietario;
	private String nomPropietario;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String codLote;
	private String nomLabor;
	private BigDecimal cantidadPago;
	private String codUdadMed;
	private BigDecimal valorUnitario;
	private BigDecimal costoTotal;
	private BigDecimal horas;
	private String nomLote;
	private Date fechaRegistro;
	private String horaInicial;
	private String horaFinal;
	private BigDecimal horometroInicial;
	private BigDecimal horometroFinal;
	private String codProducto;
	private String nomProducto;
	private BigDecimal cantGalones;
	private String codUdadMedIns;
	private String nomUdadMedIns;
	private BigDecimal costoCombustible;
	private BigDecimal area;
	private String codCliente;
	private String nomCliente;
	private BigInteger datServicioDetId;
	private BigInteger consecutivo;
	private String origenDatos;
	
	
	
	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	/**
	 * @return the codCliente
	 */
	public String getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente the codCliente to set
	 */
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	/**
	 * @return the nomCliente
	 */
	public String getNomCliente() {
		return nomCliente;
	}

	/**
	 * @param nomCliente the nomCliente to set
	 */
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
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

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public BigDecimal getCantGalones() {
		return cantGalones;
	}

	public void setCantGalones(BigDecimal cantGalones) {
		this.cantGalones = cantGalones;
	}

	public String getCodUdadMedIns() {
		return codUdadMedIns;
	}

	public void setCodUdadMedIns(String codUdadMedIns) {
		this.codUdadMedIns = codUdadMedIns;
	}

	public String getNomUdadMedIns() {
		return nomUdadMedIns;
	}

	public void setNomUdadMedIns(String nomUdadMedIns) {
		this.nomUdadMedIns = nomUdadMedIns;
	}

	public BigDecimal getCostoCombustible() {
		return costoCombustible;
	}

	public void setCostoCombustible(BigDecimal costoCombustible) {
		this.costoCombustible = costoCombustible;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public String getCodPropietario() {
		return codPropietario;
	}

	public void setCodPropietario(String codPropietario) {
		this.codPropietario = codPropietario;
	}

	public String getNomPropietario() {
		return nomPropietario;
	}

	public void setNomPropietario(String nomPropietario) {
		this.nomPropietario = nomPropietario;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public BigDecimal getHoras() {
		return horas;
	}

	public void setHoras(BigDecimal horas) {
		this.horas = horas;
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

	public String getCodLote() {
		return codLote;
	}

	public void setCodLote(String codLote) {
		this.codLote = codLote;
	}

	public String getNomLabor() {
		return nomLabor;
	}

	public void setNomLabor(String nomLabor) {
		this.nomLabor = nomLabor;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public BigInteger getDatServicioDetId() {
		return datServicioDetId;
	}

	public void setDatServicioDetId(BigInteger datServicioDetId) {
		this.datServicioDetId = datServicioDetId;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

}
