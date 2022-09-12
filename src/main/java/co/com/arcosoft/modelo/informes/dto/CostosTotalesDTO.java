package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CostosTotalesDTO {
	private String nombreCompania;
	private BigDecimal anio;
	private BigDecimal mes;
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
	private BigInteger numeroCosechas1;
	private String fechaUltCorte;
	private BigDecimal edadUltCorte;
	private BigDecimal area;
	private BigDecimal rendimiento;
	private String variedad;
	private String equipo;
	private String codTrabajador;
	private String trabajador;
	private String codConcepto;
	private String nombreConcepto;
	private BigDecimal cantidadMo;
	private BigDecimal costoMo;
	private String codUdadMedMo;
	private BigDecimal cantidadIns;
	private BigDecimal costoIns;
	private String codUdadMedIns;
	private String sistemaRiego;
	private String infraestructura;
	private BigDecimal areaRegada;
	private BigDecimal horasRiego;
	private BigDecimal m3Totales;
	private Date fechaRegistro;
	
	private String elementoCostosMes;
	private BigDecimal costoMoIndirectos;
	private BigDecimal costoSobreArea;
	
	private String codProducto;
	private String origenDatos;
	private BigInteger id;
	private BigInteger idDetalle;
	private BigDecimal valorUnitario;
	private String nomZona;
	private String nomBloque;
	private String codLote;
	
	private BigDecimal cantHa;
	private Double dias;
	
	private	BigInteger	nivel4Id	;
	private	BigInteger	consecutivo	;
	private	String	detalle	;
	private	BigInteger	aplicado	;
	private	BigInteger	csalidas	;
	private	String	codec	;
	private String mesTexto;
	
	private String nomCorte;
	/***campos asociados a produccion **/
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

	
	private	BigDecimal	katc	;
	private String tipoCosto;
	
	private BigDecimal costoIndirecto ;
	private BigDecimal costoDirecto;
	private BigDecimal utilidad;
	private BigDecimal tonHa;
	private BigDecimal tonHaEdad;
	private BigDecimal ingresosHa;
	private BigDecimal utilidadHa;
	private BigDecimal costo_sobre_vlUnitTonelada;
	
	private Double edadHoy;
	private BigDecimal diasTranscurridosLabor;
	private Double edadHoyDias;
	
	private BigDecimal porcentajeCosto;
	private BigDecimal sumatoriaCostoTotalLote;
	private BigDecimal areaFinca;
	private String rangoEdadDias;
	
	
	
	
 
	

	public String getRangoEdadDias() {
		return rangoEdadDias;
	}

	public void setRangoEdadDias(String rangoEdadDias) {
		this.rangoEdadDias = rangoEdadDias;
	}

	public Double getEdadHoyDias() {
		return edadHoyDias;
	}

	public void setEdadHoyDias(Double edadHoyDias) {
		this.edadHoyDias = edadHoyDias;
	}

	public BigDecimal getAreaFinca() {
		return areaFinca;
	}

	public void setAreaFinca(BigDecimal areaFinca) {
		this.areaFinca = areaFinca;
	}

	public BigDecimal getPorcentajeCosto() {
		return porcentajeCosto;
	}

	public void setPorcentajeCosto(BigDecimal porcentajeCosto) {
		this.porcentajeCosto = porcentajeCosto;
	}

	public BigDecimal getSumatoriaCostoTotalLote() {
		return sumatoriaCostoTotalLote;
	}

	public void setSumatoriaCostoTotalLote(BigDecimal sumatoriaCostoTotalLote) {
		this.sumatoriaCostoTotalLote = sumatoriaCostoTotalLote;
	}

	public Double getEdadHoy() {
		return edadHoy;
	}

	public void setEdadHoy(Double edadHoy) {
		this.edadHoy = edadHoy;
	}

	public BigDecimal getDiasTranscurridosLabor() {
		return diasTranscurridosLabor;
	}

	public void setDiasTranscurridosLabor(BigDecimal diasTranscurridosLabor) {
		this.diasTranscurridosLabor = diasTranscurridosLabor;
	}

	public BigDecimal getCosto_sobre_vlUnitTonelada() {
		return costo_sobre_vlUnitTonelada;
	}

	public void setCosto_sobre_vlUnitTonelada(BigDecimal costo_sobre_vlUnitTonelada) {
		this.costo_sobre_vlUnitTonelada = costo_sobre_vlUnitTonelada;
	}

	public BigDecimal getCostoIndirecto() {
		return costoIndirecto;
	}

	public void setCostoIndirecto(BigDecimal costoIndirecto) {
		this.costoIndirecto = costoIndirecto;
	}

	public BigDecimal getCostoDirecto() {
		return costoDirecto;
	}

	public void setCostoDirecto(BigDecimal costoDirecto) {
		this.costoDirecto = costoDirecto;
	}

	public BigDecimal getUtilidad() {
		return utilidad;
	}

	public void setUtilidad(BigDecimal utilidad) {
		this.utilidad = utilidad;
	}

	public BigDecimal getTonHa() {
		return tonHa;
	}

	public void setTonHa(BigDecimal tonHa) {
		this.tonHa = tonHa;
	}

	public BigDecimal getTonHaEdad() {
		return tonHaEdad;
	}

	public void setTonHaEdad(BigDecimal tonHaEdad) {
		this.tonHaEdad = tonHaEdad;
	}

	public BigDecimal getIngresosHa() {
		return ingresosHa;
	}

	public void setIngresosHa(BigDecimal ingresosHa) {
		this.ingresosHa = ingresosHa;
	}

	public BigDecimal getUtilidadHa() {
		return utilidadHa;
	}

	public void setUtilidadHa(BigDecimal utilidadHa) {
		this.utilidadHa = utilidadHa;
	}

	public String getTipoCosto() {
	return tipoCosto;
}

public void setTipoCosto(String tipoCosto) {
	this.tipoCosto = tipoCosto;
}

	public Date getfCorte() {
		return fCorte;
	}

	public void setfCorte(Date fCorte) {
		this.fCorte = fCorte;
	}

	public Date getfSiembra() {
		return fSiembra;
	}

	public void setfSiembra(Date fSiembra) {
		this.fSiembra = fSiembra;
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

	public String getNomCorte() {
		return nomCorte;
	}

	public void setNomCorte(String nomCorte) {
		this.nomCorte = nomCorte;
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

	public BigDecimal getCostoMoIndirectos() {
		return costoMoIndirectos;
	}

	public void setCostoMoIndirectos(BigDecimal costoMoIndirectos) {
		this.costoMoIndirectos = costoMoIndirectos;
	}


	public String getElementoCostosMes() {
		return elementoCostosMes;
	}

	public void setElementoCostosMes(String elementoCostosMes) {
		this.elementoCostosMes = elementoCostosMes;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public BigDecimal getCantidadMo() {
		return cantidadMo;
	}

	public void setCantidadMo(BigDecimal cantidadMo) {
		this.cantidadMo = cantidadMo;
	}

	public BigDecimal getCostoMo() {
		return costoMo;
	}

	public void setCostoMo(BigDecimal costoMo) {
		this.costoMo = costoMo;
	}

	public String getCodUdadMedMo() {
		return codUdadMedMo;
	}

	public void setCodUdadMedMo(String codUdadMedMo) {
		this.codUdadMedMo = codUdadMedMo;
	}

	public BigDecimal getCantidadIns() {
		return cantidadIns;
	}

	public void setCantidadIns(BigDecimal cantidadIns) {
		this.cantidadIns = cantidadIns;
	}

	public BigDecimal getCostoIns() {
		return costoIns;
	}

	public void setCostoIns(BigDecimal costoIns) {
		this.costoIns = costoIns;
	}

	public String getCodUdadMedIns() {
		return codUdadMedIns;
	}

	public void setCodUdadMedIns(String codUdadMedIns) {
		this.codUdadMedIns = codUdadMedIns;
	}

	public String getSistemaRiego() {
		return sistemaRiego;
	}

	public void setSistemaRiego(String sistemaRiego) {
		this.sistemaRiego = sistemaRiego;
	}

	public String getInfraestructura() {
		return infraestructura;
	}

	public void setInfraestructura(String infraestructura) {
		this.infraestructura = infraestructura;
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

	public BigDecimal getM3Totales() {
		return m3Totales;
	}

	public void setM3Totales(BigDecimal m3Totales) {
		this.m3Totales = m3Totales;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	public String getCodConcepto() {
		return codConcepto;
	}

	public void setCodConcepto(String codConcepto) {
		this.codConcepto = codConcepto;
	}

	public String getNombreConcepto() {
		return nombreConcepto;
	}

	public void setNombreConcepto(String nombreConcepto) {
		this.nombreConcepto = nombreConcepto;
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

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
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

	public BigInteger getNumeroCosechas1() {
		return numeroCosechas1;
	}

	public void setNumeroCosechas1(BigInteger numeroCosechas1) {
		this.numeroCosechas1 = numeroCosechas1;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
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

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
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

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(BigInteger idDetalle) {
		this.idDetalle = idDetalle;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getNomZona() {
		return nomZona;
	}

	public void setNomZona(String nomZona) {
		this.nomZona = nomZona;
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

	public BigDecimal getCostoSobreArea() {
		return costoSobreArea;
	}

	public void setCostoSobreArea(BigDecimal costoSobreArea) {
		this.costoSobreArea = costoSobreArea;
	}

	public BigDecimal getCantHa() {
		return cantHa;
	}

	public void setCantHa(BigDecimal cantHa) {
		this.cantHa = cantHa;
	}

	public Double getDias() {
		return dias;
	}

	public void setDias(Double dias) {
		this.dias = dias;
	}

}
