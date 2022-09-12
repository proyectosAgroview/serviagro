package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Arcosoft1
 *
 */
public class ConsultaServiciosRealizadosMaquinariaDTO {
	private String nomCompania;
	private BigInteger dat_serv_realizados_equipo_id;
	private BigInteger consecutivo;
	private String anio_mes;
	private String estado;
	private String login;
	private String fecha_creacion;
	private String fecha_modificacion;
	private String origen_datos;
	private BigDecimal anio;
	private BigDecimal mes;
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
	private String nomUdadMed;
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
	private BigDecimal horasEquipoDia;
	private BigDecimal sello;
	private String turno;
	private String cod_operario;
	private String nom_operario;
	private String cod_concepto_nomina;
	private String nom_concepto_nomina;
	private BigDecimal bonificacion_trabajador;
	private String cod_implemento;
	private String nom_implemento;
	private BigDecimal valorDia;
	private String estadoTrue;
	private String docFactura;
	private String codLabor;
	private BigInteger pin;
	private BigInteger idRegistro;
	private String estatusRegistro;
	private BigInteger equipoId;
	private BigInteger consecutivoPrefactura;
	private String direccionCliente;
	private String telefonoCliente;
	private String codAlmacen;
	private String nomAlmacen;
	private String puedeEditarPin;
	private Date fechaFactura;
	private String detalleFactura;
	private Double horasTotales;
	private BigDecimal devengo;
	private BigDecimal salario;
	private BigDecimal auxilio_productividad;
	private String periodoLiquidacion;
	private BigDecimal diasLaborados;
	private String nom_profesion;
	private BigDecimal npines_maquina;
	private BigDecimal auxilio_transporte;

	private String tipoTiempo;
	private String tiempo;
	private String estatusFactura;

	private BigDecimal cantidad_pago;
	private BigDecimal ingresoTotal;
	private BigDecimal combustible;
	private BigDecimal glnHr;
	private BigDecimal areaHr;
	private BigDecimal glnArea;
	private BigDecimal costoHr;
	private BigDecimal costoArea;
	private BigDecimal ingresosHr;
	private BigDecimal ingresosArea;
	private BigDecimal utilidad;

	private String conceptoGasto;
	private String codGrupoGasto;
	private String nomGrupoGasto;
	private BigDecimal subTotalCostoMaquina;
	private BigDecimal porcentajeCosto;

	private String listaPines;

	private BigDecimal kilometros;
	private BigDecimal km_gln;
	private BigDecimal costo_km;
	private BigDecimal costo_combustible;
	private BigDecimal costo_cmb_gln;
	private BigDecimal costo_cmb_km;
	private BigDecimal costo_cmb_hr;
	private String fechaDigitacion;
	private String fechaPreFactura;

	private BigDecimal ndiasFPin_FDigitacion;
	private BigDecimal ndiasFPin_FPreFactura;
	private BigDecimal ndiasFPin_FFactura;
	private String fechaFacturaStatus;

	private String anioMesPin;

	private BigDecimal dia;
	private BigDecimal horasTransporte;
	private BigDecimal horasImproductivas;
	private Double turnoNumero;

	private BigDecimal horasEstandar;

	private BigDecimal diasImproductivoDomingos;
	private BigDecimal diasImproductivoOtros;
	private BigDecimal diasProductivos;
	private BigDecimal numeroRegistros;
	private String mesTexto;

	private String fechaUltServicio;
	private String modeloEquipo;
	private String categoriaEquipo;

	private BigDecimal ingresoAnioAnterior;
	private BigDecimal ingresoAnioActual;
	private BigDecimal ingresoSimilado;
	private BigDecimal horasOtrasLabores;

	private String nomCiudad;
	private BigInteger consecutivoRdl;

	private BigDecimal valor_unitario_trabajador;
	private BigDecimal valor_total_trabajador;
	private BigInteger idProgramacion;

	private BigDecimal glHoraPromDia;

	private String reportar_novedadparada;
	private String tipo_mtto_texto;
	private BigDecimal horometro_mtto;
	private String observacion;
	private String nombreCentCosto;

	private String nomZonaGeografica;
	private BigDecimal horometroTanqueo;
	private BigDecimal precioProdId;
	private BigDecimal horometroTanqueoAnterior;
	private BigDecimal horasTanqueo;
	
	
	
	public String getNomZonaGeografica() {
		return nomZonaGeografica;
	}

	public BigDecimal getHorometroTanqueo() {
		return horometroTanqueo;
	}

	public BigDecimal getPrecioProdId() {
		return precioProdId;
	}

	public BigDecimal getHorometroTanqueoAnterior() {
		return horometroTanqueoAnterior;
	}

	public BigDecimal getHorasTanqueo() {
		return horasTanqueo;
	}

	public void setNomZonaGeografica(String nomZonaGeografica) {
		this.nomZonaGeografica = nomZonaGeografica;
	}

	public void setHorometroTanqueo(BigDecimal horometroTanqueo) {
		this.horometroTanqueo = horometroTanqueo;
	}

	public void setPrecioProdId(BigDecimal precioProdId) {
		this.precioProdId = precioProdId;
	}

	public void setHorometroTanqueoAnterior(BigDecimal horometroTanqueoAnterior) {
		this.horometroTanqueoAnterior = horometroTanqueoAnterior;
	}

	public void setHorasTanqueo(BigDecimal horasTanqueo) {
		this.horasTanqueo = horasTanqueo;
	}

	public String getNombreCentCosto() {
		return nombreCentCosto;
	}

	public void setNombreCentCosto(String nombreCentCosto) {
		this.nombreCentCosto = nombreCentCosto;
	}

	public String getReportar_novedadparada() {
		return reportar_novedadparada;
	}

	public String getTipo_mtto_texto() {
		return tipo_mtto_texto;
	}

	public BigDecimal getHorometro_mtto() {
		return horometro_mtto;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setReportar_novedadparada(String reportar_novedadparada) {
		this.reportar_novedadparada = reportar_novedadparada;
	}

	public void setTipo_mtto_texto(String tipo_mtto_texto) {
		this.tipo_mtto_texto = tipo_mtto_texto;
	}

	public void setHorometro_mtto(BigDecimal horometro_mtto) {
		this.horometro_mtto = horometro_mtto;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getGlHoraPromDia() {
		return glHoraPromDia;
	}

	public void setGlHoraPromDia(BigDecimal glHoraPromDia) {
		this.glHoraPromDia = glHoraPromDia;
	}

	public BigInteger getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(BigInteger idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public BigDecimal getValor_unitario_trabajador() {
		return valor_unitario_trabajador;
	}

	public BigDecimal getValor_total_trabajador() {
		return valor_total_trabajador;
	}

	public void setValor_unitario_trabajador(BigDecimal valor_unitario_trabajador) {
		this.valor_unitario_trabajador = valor_unitario_trabajador;
	}

	public void setValor_total_trabajador(BigDecimal valor_total_trabajador) {
		this.valor_total_trabajador = valor_total_trabajador;
	}

	public BigInteger getConsecutivoRdl() {
		return consecutivoRdl;
	}

	public void setConsecutivoRdl(BigInteger consecutivoRdl) {
		this.consecutivoRdl = consecutivoRdl;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public BigDecimal getHorasOtrasLabores() {
		return horasOtrasLabores;
	}

	public void setHorasOtrasLabores(BigDecimal horasOtrasLabores) {
		this.horasOtrasLabores = horasOtrasLabores;
	}

	public BigDecimal getIngresoAnioAnterior() {
		return ingresoAnioAnterior;
	}

	public void setIngresoAnioAnterior(BigDecimal ingresoAnioAnterior) {
		this.ingresoAnioAnterior = ingresoAnioAnterior;
	}

	public BigDecimal getIngresoAnioActual() {
		return ingresoAnioActual;
	}

	public void setIngresoAnioActual(BigDecimal ingresoAnioActual) {
		this.ingresoAnioActual = ingresoAnioActual;
	}

	public BigDecimal getIngresoSimilado() {
		return ingresoSimilado;
	}

	public void setIngresoSimilado(BigDecimal ingresoSimilado) {
		this.ingresoSimilado = ingresoSimilado;
	}

	public String getModeloEquipo() {
		return modeloEquipo;
	}

	public void setModeloEquipo(String modeloEquipo) {
		this.modeloEquipo = modeloEquipo;
	}

	public String getCategoriaEquipo() {
		return categoriaEquipo;
	}

	public void setCategoriaEquipo(String categoriaEquipo) {
		this.categoriaEquipo = categoriaEquipo;
	}

	public String getFechaUltServicio() {
		return fechaUltServicio;
	}

	public void setFechaUltServicio(String fechaUltServicio) {
		this.fechaUltServicio = fechaUltServicio;
	}

	public String getMesTexto() {
		return mesTexto;
	}

	public void setMesTexto(String mesTexto) {
		this.mesTexto = mesTexto;
	}

	public BigDecimal getNumeroRegistros() {
		return numeroRegistros;
	}

	public void setNumeroRegistros(BigDecimal numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}

	public BigDecimal getDiasImproductivoDomingos() {
		return diasImproductivoDomingos;
	}

	public void setDiasImproductivoDomingos(BigDecimal diasImproductivoDomingos) {
		this.diasImproductivoDomingos = diasImproductivoDomingos;
	}

	public BigDecimal getDiasImproductivoOtros() {
		return diasImproductivoOtros;
	}

	public void setDiasImproductivoOtros(BigDecimal diasImproductivoOtros) {
		this.diasImproductivoOtros = diasImproductivoOtros;
	}

	public BigDecimal getDiasProductivos() {
		return diasProductivos;
	}

	public void setDiasProductivos(BigDecimal diasProductivos) {
		this.diasProductivos = diasProductivos;
	}

	public BigDecimal getHorasEstandar() {
		return horasEstandar;
	}

	public void setHorasEstandar(BigDecimal horasEstandar) {
		this.horasEstandar = horasEstandar;
	}

	public BigDecimal getHorasTransporte() {
		return horasTransporte;
	}

	public void setHorasTransporte(BigDecimal horasTransporte) {
		this.horasTransporte = horasTransporte;
	}

	public BigDecimal getHorasImproductivas() {
		return horasImproductivas;
	}

	public void setHorasImproductivas(BigDecimal horasImproductivas) {
		this.horasImproductivas = horasImproductivas;
	}

	public Double getTurnoNumero() {
		return turnoNumero;
	}

	public void setTurnoNumero(Double turnoNumero) {
		this.turnoNumero = turnoNumero;
	}

	public BigDecimal getDia() {
		return dia;
	}

	public void setDia(BigDecimal dia) {
		this.dia = dia;
	}

	public String getAnioMesPin() {
		return anioMesPin;
	}

	public void setAnioMesPin(String anioMesPin) {
		this.anioMesPin = anioMesPin;
	}

	public String getFechaFacturaStatus() {
		return fechaFacturaStatus;
	}

	public void setFechaFacturaStatus(String fechaFacturaStatus) {
		this.fechaFacturaStatus = fechaFacturaStatus;
	}

	public String getFechaDigitacion() {
		return fechaDigitacion;
	}

	public void setFechaDigitacion(String fechaDigitacion) {
		this.fechaDigitacion = fechaDigitacion;
	}

	public String getFechaPreFactura() {
		return fechaPreFactura;
	}

	public void setFechaPreFactura(String fechaPreFactura) {
		this.fechaPreFactura = fechaPreFactura;
	}

	public BigDecimal getNdiasFPin_FDigitacion() {
		return ndiasFPin_FDigitacion;
	}

	public void setNdiasFPin_FDigitacion(BigDecimal ndiasFPin_FDigitacion) {
		this.ndiasFPin_FDigitacion = ndiasFPin_FDigitacion;
	}

	public BigDecimal getNdiasFPin_FPreFactura() {
		return ndiasFPin_FPreFactura;
	}

	public void setNdiasFPin_FPreFactura(BigDecimal ndiasFPin_FPreFactura) {
		this.ndiasFPin_FPreFactura = ndiasFPin_FPreFactura;
	}

	public BigDecimal getNdiasFPin_FFactura() {
		return ndiasFPin_FFactura;
	}

	public void setNdiasFPin_FFactura(BigDecimal ndiasFPin_FFactura) {
		this.ndiasFPin_FFactura = ndiasFPin_FFactura;
	}

	public BigDecimal getCosto_combustible() {
		return costo_combustible;
	}

	public void setCosto_combustible(BigDecimal costo_combustible) {
		this.costo_combustible = costo_combustible;
	}

	public BigDecimal getCosto_cmb_gln() {
		return costo_cmb_gln;
	}

	public void setCosto_cmb_gln(BigDecimal costo_cmb_gln) {
		this.costo_cmb_gln = costo_cmb_gln;
	}

	public BigDecimal getCosto_cmb_km() {
		return costo_cmb_km;
	}

	public void setCosto_cmb_km(BigDecimal costo_cmb_km) {
		this.costo_cmb_km = costo_cmb_km;
	}

	public BigDecimal getCosto_cmb_hr() {
		return costo_cmb_hr;
	}

	public void setCosto_cmb_hr(BigDecimal costo_cmb_hr) {
		this.costo_cmb_hr = costo_cmb_hr;
	}

	public BigDecimal getKm_gln() {
		return km_gln;
	}

	public void setKm_gln(BigDecimal km_gln) {
		this.km_gln = km_gln;
	}

	public BigDecimal getKilometros() {
		return kilometros;
	}

	public void setKilometros(BigDecimal kilometros) {
		this.kilometros = kilometros;
	}

	public BigDecimal getCosto_km() {
		return costo_km;
	}

	public void setCosto_km(BigDecimal costo_km) {
		this.costo_km = costo_km;
	}

	public String getListaPines() {
		return listaPines;
	}

	public void setListaPines(String listaPines) {
		this.listaPines = listaPines;
	}

	public BigDecimal getPorcentajeCosto() {
		return porcentajeCosto;
	}

	public void setPorcentajeCosto(BigDecimal porcentajeCosto) {
		this.porcentajeCosto = porcentajeCosto;
	}

	public BigDecimal getSubTotalCostoMaquina() {
		return subTotalCostoMaquina;
	}

	public void setSubTotalCostoMaquina(BigDecimal subTotalCostoMaquina) {
		this.subTotalCostoMaquina = subTotalCostoMaquina;
	}

	public String getConceptoGasto() {
		return conceptoGasto;
	}

	public void setConceptoGasto(String conceptoGasto) {
		this.conceptoGasto = conceptoGasto;
	}

	public String getCodGrupoGasto() {
		return codGrupoGasto;
	}

	public void setCodGrupoGasto(String codGrupoGasto) {
		this.codGrupoGasto = codGrupoGasto;
	}

	public String getNomGrupoGasto() {
		return nomGrupoGasto;
	}

	public void setNomGrupoGasto(String nomGrupoGasto) {
		this.nomGrupoGasto = nomGrupoGasto;
	}

	public BigDecimal getCantidad_pago() {
		return cantidad_pago;
	}

	public void setCantidad_pago(BigDecimal cantidad_pago) {
		this.cantidad_pago = cantidad_pago;
	}

	public BigDecimal getIngresoTotal() {
		return ingresoTotal;
	}

	public void setIngresoTotal(BigDecimal ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}

	public BigDecimal getCombustible() {
		return combustible;
	}

	public void setCombustible(BigDecimal combustible) {
		this.combustible = combustible;
	}

	public BigDecimal getGlnHr() {
		return glnHr;
	}

	public void setGlnHr(BigDecimal glnHr) {
		this.glnHr = glnHr;
	}

	public BigDecimal getAreaHr() {
		return areaHr;
	}

	public void setAreaHr(BigDecimal areaHr) {
		this.areaHr = areaHr;
	}

	public BigDecimal getGlnArea() {
		return glnArea;
	}

	public void setGlnArea(BigDecimal glnArea) {
		this.glnArea = glnArea;
	}

	public BigDecimal getCostoHr() {
		return costoHr;
	}

	public void setCostoHr(BigDecimal costoHr) {
		this.costoHr = costoHr;
	}

	public BigDecimal getCostoArea() {
		return costoArea;
	}

	public void setCostoArea(BigDecimal costoArea) {
		this.costoArea = costoArea;
	}

	public BigDecimal getIngresosHr() {
		return ingresosHr;
	}

	public void setIngresosHr(BigDecimal ingresosHr) {
		this.ingresosHr = ingresosHr;
	}

	public BigDecimal getIngresosArea() {
		return ingresosArea;
	}

	public void setIngresosArea(BigDecimal ingresosArea) {
		this.ingresosArea = ingresosArea;
	}

	public BigDecimal getUtilidad() {
		return utilidad;
	}

	public void setUtilidad(BigDecimal utilidad) {
		this.utilidad = utilidad;
	}

	public String getEstatusFactura() {
		return estatusFactura;
	}

	public void setEstatusFactura(String estatusFactura) {
		this.estatusFactura = estatusFactura;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getTipoTiempo() {
		return tipoTiempo;
	}

	public void setTipoTiempo(String tipoTiempo) {
		this.tipoTiempo = tipoTiempo;
	}

	public BigDecimal getAuxilio_transporte() {
		return auxilio_transporte;
	}

	public void setAuxilio_transporte(BigDecimal auxilio_transporte) {
		this.auxilio_transporte = auxilio_transporte;
	}

	public BigDecimal getNpines_maquina() {
		return npines_maquina;
	}

	public void setNpines_maquina(BigDecimal npines_maquina) {
		this.npines_maquina = npines_maquina;
	}

	public BigDecimal getDiasLaborados() {
		return diasLaborados;
	}

	public void setDiasLaborados(BigDecimal diasLaborados) {
		this.diasLaborados = diasLaborados;
	}

	public String getNom_profesion() {
		return nom_profesion;
	}

	public void setNom_profesion(String nom_profesion) {
		this.nom_profesion = nom_profesion;
	}

	public BigDecimal getDevengo() {
		return devengo;
	}

	public void setDevengo(BigDecimal devengo) {
		this.devengo = devengo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getAuxilio_productividad() {
		return auxilio_productividad;
	}

	public void setAuxilio_productividad(BigDecimal auxilio_productividad) {
		this.auxilio_productividad = auxilio_productividad;
	}

	public String getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}

	public void setPeriodoLiquidacion(String periodoLiquidacion) {
		this.periodoLiquidacion = periodoLiquidacion;
	}

	public Double getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(Double horasTotales) {
		this.horasTotales = horasTotales;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public String getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(String detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public String getPuedeEditarPin() {
		return puedeEditarPin;
	}

	public void setPuedeEditarPin(String puedeEditarPin) {
		this.puedeEditarPin = puedeEditarPin;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getNomAlmacen() {
		return nomAlmacen;
	}

	public void setNomAlmacen(String nomAlmacen) {
		this.nomAlmacen = nomAlmacen;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public BigInteger getConsecutivoPrefactura() {
		return consecutivoPrefactura;
	}

	public void setConsecutivoPrefactura(BigInteger consecutivoPrefactura) {
		this.consecutivoPrefactura = consecutivoPrefactura;
	}

	public BigInteger getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(BigInteger equipoId) {
		this.equipoId = equipoId;
	}

	public String getDocFactura() {
		return docFactura;
	}

	public void setDocFactura(String docFactura) {
		this.docFactura = docFactura;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public BigInteger getPin() {
		return pin;
	}

	public void setPin(BigInteger pin) {
		this.pin = pin;
	}

	public BigInteger getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(BigInteger idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getEstatusRegistro() {
		return estatusRegistro;
	}

	public void setEstatusRegistro(String estatusRegistro) {
		this.estatusRegistro = estatusRegistro;
	}

	/**
	 * @return the estadoTrue
	 */
	public String getEstadoTrue() {
		return estadoTrue;
	}

	/**
	 * @param estadoTrue the estadoTrue to set
	 */
	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	/**
	 * @return the valorDia
	 */
	public BigDecimal getValorDia() {
		return valorDia;
	}

	/**
	 * @param valorDia the valorDia to set
	 */
	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}

	/**
	 * @return the nomUdadMed
	 */
	public String getNomUdadMed() {
		return nomUdadMed;
	}

	/**
	 * @param nomUdadMed the nomUdadMed to set
	 */
	public void setNomUdadMed(String nomUdadMed) {
		this.nomUdadMed = nomUdadMed;
	}

	/**
	 * @return the horasEquipoDia
	 */
	public BigDecimal getHorasEquipoDia() {
		return horasEquipoDia;
	}

	/**
	 * @param horasEquipoDia the horasEquipoDia to set
	 */
	public void setHorasEquipoDia(BigDecimal horasEquipoDia) {
		this.horasEquipoDia = horasEquipoDia;
	}

	/**
	 * @return the sello
	 */
	public BigDecimal getSello() {
		return sello;
	}

	/**
	 * @param sello the sello to set
	 */
	public void setSello(BigDecimal sello) {
		this.sello = sello;
	}

	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}

	/**
	 * @return the cod_operario
	 */
	public String getCod_operario() {
		return cod_operario;
	}

	/**
	 * @param cod_operario the cod_operario to set
	 */
	public void setCod_operario(String cod_operario) {
		this.cod_operario = cod_operario;
	}

	/**
	 * @return the nom_operario
	 */
	public String getNom_operario() {
		return nom_operario;
	}

	/**
	 * @param nom_operario the nom_operario to set
	 */
	public void setNom_operario(String nom_operario) {
		this.nom_operario = nom_operario;
	}

	/**
	 * @return the cod_concepto_nomina
	 */
	public String getCod_concepto_nomina() {
		return cod_concepto_nomina;
	}

	/**
	 * @param cod_concepto_nomina the cod_concepto_nomina to set
	 */
	public void setCod_concepto_nomina(String cod_concepto_nomina) {
		this.cod_concepto_nomina = cod_concepto_nomina;
	}

	/**
	 * @return the nom_concepto_nomina
	 */
	public String getNom_concepto_nomina() {
		return nom_concepto_nomina;
	}

	/**
	 * @param nom_concepto_nomina the nom_concepto_nomina to set
	 */
	public void setNom_concepto_nomina(String nom_concepto_nomina) {
		this.nom_concepto_nomina = nom_concepto_nomina;
	}

	/**
	 * @return the bonificacion_trabajador
	 */
	public BigDecimal getBonificacion_trabajador() {
		return bonificacion_trabajador;
	}

	/**
	 * @param bonificacion_trabajador the bonificacion_trabajador to set
	 */
	public void setBonificacion_trabajador(BigDecimal bonificacion_trabajador) {
		this.bonificacion_trabajador = bonificacion_trabajador;
	}

	/**
	 * @return the cod_implemento
	 */
	public String getCod_implemento() {
		return cod_implemento;
	}

	/**
	 * @param cod_implemento the cod_implemento to set
	 */
	public void setCod_implemento(String cod_implemento) {
		this.cod_implemento = cod_implemento;
	}

	/**
	 * @return the nom_implemento
	 */
	public String getNom_implemento() {
		return nom_implemento;
	}

	/**
	 * @param nom_implemento the nom_implemento to set
	 */
	public void setNom_implemento(String nom_implemento) {
		this.nom_implemento = nom_implemento;
	}

	/**
	 * @return the dat_serv_realizados_equipo_id
	 */
	public BigInteger getDat_serv_realizados_equipo_id() {
		return dat_serv_realizados_equipo_id;
	}

	/**
	 * @param dat_serv_realizados_equipo_id the dat_serv_realizados_equipo_id to set
	 */
	public void setDat_serv_realizados_equipo_id(BigInteger dat_serv_realizados_equipo_id) {
		this.dat_serv_realizados_equipo_id = dat_serv_realizados_equipo_id;
	}

	/**
	 * @return the consecutivo
	 */
	public BigInteger getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}

	/**
	 * @return the anio_mes
	 */
	public String getAnio_mes() {
		return anio_mes;
	}

	/**
	 * @param anio_mes the anio_mes to set
	 */
	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the fecha_creacion
	 */
	public String getFecha_creacion() {
		return fecha_creacion;
	}

	/**
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * @return the fecha_modificacion
	 */
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	/**
	 * @param fecha_modificacion the fecha_modificacion to set
	 */
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	/**
	 * @return the origen_datos
	 */
	public String getOrigen_datos() {
		return origen_datos;
	}

	/**
	 * @param origen_datos the origen_datos to set
	 */
	public void setOrigen_datos(String origen_datos) {
		this.origen_datos = origen_datos;
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

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

}
