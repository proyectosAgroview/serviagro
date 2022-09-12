package co.com.arcosoft.modelo.informes.dto;

import java.util.Date;

public class ListaProduccionDTO {

	private Long ref;
	private Date fechaRegistro;
	private String tipoTransaccion;
	private Long consecutivo;
	private String observacion;
	private String estado;
	private String nomUsuarioDigitacion;
	private String codFinca;
	private String nomFinca;
	private String codLote;
	private String nomLote;
	private String fechaIni;
	private String fechaFin;
	private Double valorUnitario;
	private Double ingresoBruto;
	private Long id;
	private Date finCosecha;
	private String estadoRegistro;
	private String estadoEstrue2;
	private String estadoEstrue;
	private Date iniCosecha;
	
	
	public Date getIniCosecha() {
		return iniCosecha;
	}

	public void setIniCosecha(Date iniCosecha) {
		this.iniCosecha = iniCosecha;
	}

	public String getEstadoEstrue2() {
		return estadoEstrue2;
	}

	public void setEstadoEstrue2(String estadoEstrue2) {
		this.estadoEstrue2 = estadoEstrue2;
	}

	public String getEstadoEstrue() {
		return estadoEstrue;
	}

	public void setEstadoEstrue(String estadoEstrue) {
		this.estadoEstrue = estadoEstrue;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomUsuarioDigitacion() {
		return nomUsuarioDigitacion;
	}

	public void setNomUsuarioDigitacion(String nomUsuarioDigitacion) {
		this.nomUsuarioDigitacion = nomUsuarioDigitacion;
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

	public String getCodLote() {
		return codLote;
	}

	public void setCodLote(String codLote) {
		this.codLote = codLote;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getIngresoBruto() {
		return ingresoBruto;
	}

	public void setIngresoBruto(Double ingresoBruto) {
		this.ingresoBruto = ingresoBruto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFinCosecha() {
		return finCosecha;
	}

	public void setFinCosecha(Date finCosecha) {
		this.finCosecha = finCosecha;
	}

}
