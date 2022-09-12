package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ProduccionAcumFincaDTO {

	private BigDecimal anio;
	private BigDecimal mes;
	private String mesCorto;
	private String codZona;
	private String codFinca;
	private String nomFinca;
	private String codBloque;
	private String nomBloque;
	private String codLote;
	private String nomLote;
	private BigDecimal area;
	private BigDecimal cantidadCosechadaTon;
	private String nomCompania;
	private String nomCliente;
	private String nomVariedad;
	private String proveedor;
	private BigDecimal tonHa;
	private BigInteger nCosechas;
	private Date fechaInicio;
	private Date fechaFin;
	private BigDecimal edad;
	private BigDecimal kilosCosechados;
	private BigDecimal valorUnitarioKilo;
	private BigDecimal ingresoTotal;
	private Date fechaProxCorte;
	private BigDecimal tchm;
	private BigDecimal rendHa;
	private BigDecimal ingresosHa;
	private BigDecimal porcKilosTonelada;
	private BigDecimal porcMateriaExtrana;
	private BigDecimal porcRendimiento;
	private BigDecimal porcSacarosa;
	private BigDecimal ingresoBruto;
	private BigDecimal valorDeduccion;


	private	Date	fSiembra	;
	private Date fCorte;
	private	BigDecimal	rendAzucar	;
	private	BigDecimal	valUnitario	;
	private	BigDecimal	adicionales	;
	private	BigDecimal	ajustesLiq	;
	private	BigDecimal	iVarios	;
	private	BigDecimal	retenciones	;
	private	BigDecimal	descuentos	;
	private	String	notas	;

	
	private	BigInteger	nivel4Id	;
	private	BigInteger	consecutivo	;
	private	String	detalle	;
	private	BigInteger	aplicado	;
	private	BigInteger	csalidas	;
	private	String	codec	;
	private String mesTexto;
	
	private String nomCorte;
	
	private BigInteger idRegistro;
	private String codUmCos;
	
	
	
	
	
	public String getCodUmCos() {
		return codUmCos;
	}

	public void setCodUmCos(String codUmCos) {
		this.codUmCos = codUmCos;
	}

	public BigInteger getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(BigInteger idRegistro) {
		this.idRegistro = idRegistro;
	}

	public BigInteger getNivel4Id() {
		return nivel4Id;
	}

	public void setNivel4Id(BigInteger nivel4Id) {
		this.nivel4Id = nivel4Id;
	}

	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public BigInteger getAplicado() {
		return aplicado;
	}

	public void setAplicado(BigInteger aplicado) {
		this.aplicado = aplicado;
	}

	public BigInteger getCsalidas() {
		return csalidas;
	}

	public void setCsalidas(BigInteger csalidas) {
		this.csalidas = csalidas;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public String getMesTexto() {
		return mesTexto;
	}

	public void setMesTexto(String mesTexto) {
		this.mesTexto = mesTexto;
	}

	public String getNomCorte() {
		return nomCorte;
	}

	public void setNomCorte(String nomCorte) {
		this.nomCorte = nomCorte;
	}

	private	BigDecimal	katc	;

	
	public Date getfSiembra() {
		return fSiembra;
	}

	public void setfSiembra(Date fSiembra) {
		this.fSiembra = fSiembra;
	}

	public Date getfCorte() {
		return fCorte;
	}

	public void setfCorte(Date fCorte) {
		this.fCorte = fCorte;
	}

	public BigDecimal getRendAzucar() {
		return rendAzucar;
	}

	public void setRendAzucar(BigDecimal rendAzucar) {
		this.rendAzucar = rendAzucar;
	}

	public BigDecimal getValUnitario() {
		return valUnitario;
	}

	public void setValUnitario(BigDecimal valUnitario) {
		this.valUnitario = valUnitario;
	}

	public BigDecimal getAdicionales() {
		return adicionales;
	}

	public void setAdicionales(BigDecimal adicionales) {
		this.adicionales = adicionales;
	}

	public BigDecimal getAjustesLiq() {
		return ajustesLiq;
	}

	public void setAjustesLiq(BigDecimal ajustesLiq) {
		this.ajustesLiq = ajustesLiq;
	}

	public BigDecimal getiVarios() {
		return iVarios;
	}

	public void setiVarios(BigDecimal iVarios) {
		this.iVarios = iVarios;
	}

	public BigDecimal getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(BigDecimal retenciones) {
		this.retenciones = retenciones;
	}

	public BigDecimal getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public BigDecimal getKatc() {
		return katc;
	}

	public void setKatc(BigDecimal katc) {
		this.katc = katc;
	}

	public BigDecimal getPorcKilosTonelada() {
		return porcKilosTonelada;
	}

	public void setPorcKilosTonelada(BigDecimal porcKilosTonelada) {
		this.porcKilosTonelada = porcKilosTonelada;
	}

	public BigDecimal getPorcMateriaExtrana() {
		return porcMateriaExtrana;
	}

	public void setPorcMateriaExtrana(BigDecimal porcMateriaExtrana) {
		this.porcMateriaExtrana = porcMateriaExtrana;
	}

	public BigDecimal getPorcRendimiento() {
		return porcRendimiento;
	}

	public void setPorcRendimiento(BigDecimal porcRendimiento) {
		this.porcRendimiento = porcRendimiento;
	}

	public BigDecimal getPorcSacarosa() {
		return porcSacarosa;
	}

	public void setPorcSacarosa(BigDecimal porcSacarosa) {
		this.porcSacarosa = porcSacarosa;
	}

	public BigDecimal getIngresoBruto() {
		return ingresoBruto;
	}

	public void setIngresoBruto(BigDecimal ingresoBruto) {
		this.ingresoBruto = ingresoBruto;
	}

	public BigDecimal getValorDeduccion() {
		return valorDeduccion;
	}

	public void setValorDeduccion(BigDecimal valorDeduccion) {
		this.valorDeduccion = valorDeduccion;
	}

	public BigDecimal getTchm() {
		return tchm;
	}

	public void setTchm(BigDecimal tchm) {
		this.tchm = tchm;
	}

	public BigDecimal getRendHa() {
		return rendHa;
	}

	public void setRendHa(BigDecimal rendHa) {
		this.rendHa = rendHa;
	}

	public BigDecimal getIngresosHa() {
		return ingresosHa;
	}

	public void setIngresosHa(BigDecimal ingresosHa) {
		this.ingresosHa = ingresosHa;
	}

	public Date getFechaProxCorte() {
		return fechaProxCorte;
	}

	public void setFechaProxCorte(Date fechaProxCorte) {
		this.fechaProxCorte = fechaProxCorte;
	}

	public BigDecimal getKilosCosechados() {
		return kilosCosechados;
	}

	public void setKilosCosechados(BigDecimal kilosCosechados) {
		this.kilosCosechados = kilosCosechados;
	}

	public BigDecimal getValorUnitarioKilo() {
		return valorUnitarioKilo;
	}

	public void setValorUnitarioKilo(BigDecimal valorUnitarioKilo) {
		this.valorUnitarioKilo = valorUnitarioKilo;
	}

	public BigDecimal getIngresoTotal() {
		return ingresoTotal;
	}

	public void setIngresoTotal(BigDecimal ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}

	public BigDecimal getEdad() {
		return edad;
	}

	public void setEdad(BigDecimal edad) {
		this.edad = edad;
	}

	public BigDecimal getTonHa() {
		return tonHa;
	}

	public void setTonHa(BigDecimal tonHa) {
		this.tonHa = tonHa;
	}

	public BigInteger getnCosechas() {
		return nCosechas;
	}

	public void setnCosechas(BigInteger nCosechas) {
		this.nCosechas = nCosechas;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNomVariedad() {
		return nomVariedad;
	}

	public void setNomVariedad(String nomVariedad) {
		this.nomVariedad = nomVariedad;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
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

	public String getMesCorto() {
		return mesCorto;
	}

	public void setMesCorto(String mesCorto) {
		this.mesCorto = mesCorto;
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

	public String getNomBloque() {
		return nomBloque;
	}

	public void setNomBloque(String nomBloque) {
		this.nomBloque = nomBloque;
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

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getCantidadCosechadaTon() {
		return cantidadCosechadaTon;
	}

	public void setCantidadCosechadaTon(BigDecimal cantidadCosechadaTon) {
		this.cantidadCosechadaTon = cantidadCosechadaTon;
	}

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

}
