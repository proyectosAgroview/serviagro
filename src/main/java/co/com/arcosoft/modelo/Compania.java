package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compania generated by hbm2java
 */
@SuppressWarnings("serial")
public class Compania implements java.io.Serializable {

	private Long companiaId;
	private Long entBanc;
	private Long ciudad;
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String pbx;
	private String rut;
	private Float longitud;
	private Float latitud;
	private Float precision;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private String estadoKml;
	private String urlKml;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);
	private String nivelAutorizaLabor;
	private Long consecutivoEntradas;
	private Long consecutivoSalidas;
	private Long consecutivoFacturaCali;
	private String email;
	private String desFiscal;
	private String subtitulo;
	private String prefijo;
	private String resolucion;
	private String imprimeFactura;
	private Long codigoGastoCmb;
	private Long codigoGastoNomina;
	private Long consecutivoCajaMenor;
	private Long consecutivoGastos;
	private Long consecutivoTraslados;
	private Long consecutivoOrdCompras;
	private String codigoEntredas;
	private Long consecutivoFacturaRozo;
	private Long anioCurso;
	private Long consecutivoCotizacion;
	private Double auxilioMovilizacion;
	private Long consecutivoGastosoperacion;
	private Long consecutivoPrefactura;
	private Long conceptoAuxTransporte;
	private Long kardexEntradaEstandar;
	private Long kardexSalidaEstandar;
	private Long productoCombustibleId;

	private Double valorUvt;
	private Double salarioMinimoLegal;
	private Double topeSmlAuxTransporte;
	private Double rentasExentasUvt;
	private Double porcMinContribucion;
	private Double ipc;
	private Double auxilioTransporte;
	private Double porcRentasExternas;
	private Double porcLey1527;
	private Double tarifaIvaRetenido;
	private Double porcProvisionCesantias;
	private Double porcProvisionPrimas;
	private Double porcProvisionVacaciones;
	private Double porcProvisionInteresesCesantias;
	private Double porcAporteEpsEmpleador;
	private Double porcAporteAfpAltoRiesgoEmpleador;
	private Double porcAporteIcbfEmpleador;
	private Double porcAporteAfpEmpleador;
	private Double porcAporteCcfEmpleador;
	private Double porcAporteSenaEmpleador;
	private Double minimoSmlAporteSenaIcbf;
	private String aportesNominaLiquidan;
	private Double topeSmlCotizarEps;
	private Double topeSmlCotizarAfp;
	private Double topeSmlCotizarArl;
	private Double minimoSmlAportaFSP;
	private String auxilioTransporteLiquidan;
	private Double porcAporteEpsTrabajador;
	private Double porcAporteAfpTrabajador;
	private Double porcAporteFspTrabajador;
	private Double  devengoMinimoDiario;
	
	
	
	public Compania() {
	}

	public Compania(Long companiaId) {
		this.companiaId = companiaId;
	}

	public Compania(Long companiaId, Long entBanc, Long ciudad, String codigo, String nombre, String direccion,
			String telefono, String pbx, String rut, Float longitud, Float latitud, Float precision,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			String estadoKml, String urlKml, Set<Usuarios> usuarioses, String nivelAutorizaLabor,
			Long consecutivoEntradas, Long consecutivoSalidas, Long consecutivoFacturaCali, String email,
			String desFiscal, String subtitulo, String prefijo, String resolucion, String imprimeFactura,
			Long codigoGastoCmb, Long codigoGastoNomina, Long consecutivoCajaMenor, Long consecutivoGastos,
			Long consecutivoTraslados, Long consecutivoOrdCompras, String codigoEntredas, Long consecutivoFacturaRozo,
			Long anioCurso, Long consecutivoCotizacion, Double auxilioMovilizacion, Long consecutivoGastosoperacion,
			Long consecutivoPrefactura, Long conceptoAuxTransporte, Long kardexEntradaEstandar,
			Long kardexSalidaEstandar, Long productoCombustibleId, Double devengoMinimoDiario) {
		this.companiaId = companiaId;
		this.entBanc = entBanc;
		this.ciudad = ciudad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pbx = pbx;
		this.rut = rut;
		this.longitud = longitud;
		this.latitud = latitud;
		this.precision = precision;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.estadoKml = estadoKml;
		this.urlKml = urlKml;
		this.usuarioses = usuarioses;
		this.nivelAutorizaLabor = nivelAutorizaLabor;
		this.consecutivoEntradas = consecutivoEntradas;
		this.consecutivoSalidas = consecutivoSalidas;
		this.consecutivoFacturaCali = consecutivoFacturaCali;
		this.email = email;
		this.desFiscal = desFiscal;
		this.subtitulo = subtitulo;
		this.prefijo = prefijo;
		this.resolucion = resolucion;
		this.imprimeFactura = imprimeFactura;
		this.codigoGastoCmb = codigoGastoCmb;
		this.codigoGastoNomina = codigoGastoNomina;
		this.consecutivoCajaMenor = consecutivoCajaMenor;
		this.consecutivoGastos = consecutivoGastos;
		this.consecutivoTraslados = consecutivoTraslados;
		this.consecutivoOrdCompras = consecutivoOrdCompras;
		this.codigoEntredas = codigoEntredas;
		this.consecutivoFacturaRozo = consecutivoFacturaRozo;
		this.anioCurso = anioCurso;
		this.consecutivoCotizacion = consecutivoCotizacion;
		this.auxilioMovilizacion = auxilioMovilizacion;
		this.consecutivoGastosoperacion = consecutivoGastosoperacion;
		this.consecutivoPrefactura = consecutivoPrefactura;
		this.conceptoAuxTransporte = conceptoAuxTransporte;
		this.kardexEntradaEstandar = kardexEntradaEstandar;
		this.kardexSalidaEstandar = kardexSalidaEstandar;
		this.productoCombustibleId = productoCombustibleId;
		this.devengoMinimoDiario=devengoMinimoDiario;
	}
	
	

	public Double getDevengoMinimoDiario() {
		return devengoMinimoDiario;
	}

	public void setDevengoMinimoDiario(Double devengoMinimoDiario) {
		this.devengoMinimoDiario = devengoMinimoDiario;
	}

	public Long getProductoCombustibleId() {
		return productoCombustibleId;
	}

	public void setProductoCombustibleId(Long productoCombustibleId) {
		this.productoCombustibleId = productoCombustibleId;
	}

	public Long getKardexEntradaEstandar() {
		return kardexEntradaEstandar;
	}

	public void setKardexEntradaEstandar(Long kardexEntradaEstandar) {
		this.kardexEntradaEstandar = kardexEntradaEstandar;
	}

	public Long getKardexSalidaEstandar() {
		return kardexSalidaEstandar;
	}

	public void setKardexSalidaEstandar(Long kardexSalidaEstandar) {
		this.kardexSalidaEstandar = kardexSalidaEstandar;
	}

	public Long getConceptoAuxTransporte() {
		return conceptoAuxTransporte;
	}

	public void setConceptoAuxTransporte(Long conceptoAuxTransporte) {
		this.conceptoAuxTransporte = conceptoAuxTransporte;
	}

	public Long getConsecutivoEntradas() {
		return consecutivoEntradas;
	}

	public void setConsecutivoEntradas(Long consecutivoEntradas) {
		this.consecutivoEntradas = consecutivoEntradas;
	}

	public Long getConsecutivoSalidas() {
		return consecutivoSalidas;
	}

	public void setConsecutivoSalidas(Long consecutivoSalidas) {
		this.consecutivoSalidas = consecutivoSalidas;
	}

	public Long getConsecutivoFacturaCali() {
		return consecutivoFacturaCali;
	}

	public void setConsecutivoFacturaCali(Long consecutivoFacturaCali) {
		this.consecutivoFacturaCali = consecutivoFacturaCali;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesFiscal() {
		return desFiscal;
	}

	public void setDesFiscal(String desFiscal) {
		this.desFiscal = desFiscal;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getImprimeFactura() {
		return imprimeFactura;
	}

	public void setImprimeFactura(String imprimeFactura) {
		this.imprimeFactura = imprimeFactura;
	}

	public Long getCodigoGastoCmb() {
		return codigoGastoCmb;
	}

	public void setCodigoGastoCmb(Long codigoGastoCmb) {
		this.codigoGastoCmb = codigoGastoCmb;
	}

	public Long getCodigoGastoNomina() {
		return codigoGastoNomina;
	}

	public void setCodigoGastoNomina(Long codigoGastoNomina) {
		this.codigoGastoNomina = codigoGastoNomina;
	}

	public Long getConsecutivoCajaMenor() {
		return consecutivoCajaMenor;
	}

	public void setConsecutivoCajaMenor(Long consecutivoCajaMenor) {
		this.consecutivoCajaMenor = consecutivoCajaMenor;
	}

	public Long getConsecutivoGastos() {
		return consecutivoGastos;
	}

	public void setConsecutivoGastos(Long consecutivoGastos) {
		this.consecutivoGastos = consecutivoGastos;
	}

	public Long getConsecutivoTraslados() {
		return consecutivoTraslados;
	}

	public void setConsecutivoTraslados(Long consecutivoTraslados) {
		this.consecutivoTraslados = consecutivoTraslados;
	}

	public Long getConsecutivoOrdCompras() {
		return consecutivoOrdCompras;
	}

	public void setConsecutivoOrdCompras(Long consecutivoOrdCompras) {
		this.consecutivoOrdCompras = consecutivoOrdCompras;
	}

	public String getCodigoEntredas() {
		return codigoEntredas;
	}

	public void setCodigoEntredas(String codigoEntredas) {
		this.codigoEntredas = codigoEntredas;
	}

	public Long getConsecutivoFacturaRozo() {
		return consecutivoFacturaRozo;
	}

	public void setConsecutivoFacturaRozo(Long consecutivoFacturaRozo) {
		this.consecutivoFacturaRozo = consecutivoFacturaRozo;
	}

	public Long getAnioCurso() {
		return anioCurso;
	}

	public void setAnioCurso(Long anioCurso) {
		this.anioCurso = anioCurso;
	}

	public Long getConsecutivoCotizacion() {
		return consecutivoCotizacion;
	}

	public void setConsecutivoCotizacion(Long consecutivoCotizacion) {
		this.consecutivoCotizacion = consecutivoCotizacion;
	}

	public Double getAuxilioMovilizacion() {
		return auxilioMovilizacion;
	}

	public void setAuxilioMovilizacion(Double auxilioMovilizacion) {
		this.auxilioMovilizacion = auxilioMovilizacion;
	}

	public Long getConsecutivoGastosoperacion() {
		return consecutivoGastosoperacion;
	}

	public void setConsecutivoGastosoperacion(Long consecutivoGastosoperacion) {
		this.consecutivoGastosoperacion = consecutivoGastosoperacion;
	}

	public Long getConsecutivoPrefactura() {
		return consecutivoPrefactura;
	}

	public void setConsecutivoPrefactura(Long consecutivoPrefactura) {
		this.consecutivoPrefactura = consecutivoPrefactura;
	}

	/**
	 * @return the nivelAutorizaLabor
	 */
	public String getNivelAutorizaLabor() {
		return nivelAutorizaLabor;
	}

	/**
	 * @param nivelAutorizaLabor the nivelAutorizaLabor to set
	 */
	public void setNivelAutorizaLabor(String nivelAutorizaLabor) {
		this.nivelAutorizaLabor = nivelAutorizaLabor;
	}

	public Set<Usuarios> getUsuarioses() {
		return usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

	public Long getCompaniaId() {
		return this.companiaId;
	}

	public void setCompaniaId(Long companiaId) {
		this.companiaId = companiaId;
	}

	public Long getEntBanc() {
		return this.entBanc;
	}

	public void setEntBanc(Long entBanc) {
		this.entBanc = entBanc;
	}

	public Long getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Long ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPbx() {
		return this.pbx;
	}

	public void setPbx(String pbx) {
		this.pbx = pbx;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoKml() {
		return estadoKml;
	}

	public void setEstadoKml(String estadoKml) {
		this.estadoKml = estadoKml;
	}

	public String getUrlKml() {
		return urlKml;
	}

	public void setUrlKml(String urlKml) {
		this.urlKml = urlKml;
	}

	public Double getValorUvt() {
		return valorUvt;
	}

	public void setValorUvt(Double valorUvt) {
		this.valorUvt = valorUvt;
	}

	public Double getSalarioMinimoLegal() {
		return salarioMinimoLegal;
	}

	public void setSalarioMinimoLegal(Double salarioMinimoLegal) {
		this.salarioMinimoLegal = salarioMinimoLegal;
	}

	public Double getTopeSmlAuxTransporte() {
		return topeSmlAuxTransporte;
	}

	public void setTopeSmlAuxTransporte(Double topeSmlAuxTransporte) {
		this.topeSmlAuxTransporte = topeSmlAuxTransporte;
	}

	public Double getRentasExentasUvt() {
		return rentasExentasUvt;
	}

	public void setRentasExentasUvt(Double rentasExentasUvt) {
		this.rentasExentasUvt = rentasExentasUvt;
	}

	public Double getPorcMinContribucion() {
		return porcMinContribucion;
	}

	public void setPorcMinContribucion(Double porcMinContribucion) {
		this.porcMinContribucion = porcMinContribucion;
	}

	public Double getIpc() {
		return ipc;
	}

	public void setIpc(Double ipc) {
		this.ipc = ipc;
	}

	public Double getAuxilioTransporte() {
		return auxilioTransporte;
	}

	public void setAuxilioTransporte(Double auxilioTransporte) {
		this.auxilioTransporte = auxilioTransporte;
	}

	public Double getPorcRentasExternas() {
		return porcRentasExternas;
	}

	public void setPorcRentasExternas(Double porcRentasExternas) {
		this.porcRentasExternas = porcRentasExternas;
	}

	public Double getPorcLey1527() {
		return porcLey1527;
	}

	public void setPorcLey1527(Double porcLey1527) {
		this.porcLey1527 = porcLey1527;
	}

	public Double getTarifaIvaRetenido() {
		return tarifaIvaRetenido;
	}

	public void setTarifaIvaRetenido(Double tarifaIvaRetenido) {
		this.tarifaIvaRetenido = tarifaIvaRetenido;
	}

	public Double getPorcProvisionCesantias() {
		return porcProvisionCesantias;
	}

	public void setPorcProvisionCesantias(Double porcProvisionCesantias) {
		this.porcProvisionCesantias = porcProvisionCesantias;
	}

	public Double getPorcProvisionPrimas() {
		return porcProvisionPrimas;
	}

	public void setPorcProvisionPrimas(Double porcProvisionPrimas) {
		this.porcProvisionPrimas = porcProvisionPrimas;
	}

	public Double getPorcProvisionVacaciones() {
		return porcProvisionVacaciones;
	}

	public void setPorcProvisionVacaciones(Double porcProvisionVacaciones) {
		this.porcProvisionVacaciones = porcProvisionVacaciones;
	}

	public Double getPorcProvisionInteresesCesantias() {
		return porcProvisionInteresesCesantias;
	}

	public void setPorcProvisionInteresesCesantias(Double porcProvisionInteresesCesantias) {
		this.porcProvisionInteresesCesantias = porcProvisionInteresesCesantias;
	}

	public Double getPorcAporteEpsEmpleador() {
		return porcAporteEpsEmpleador;
	}

	public void setPorcAporteEpsEmpleador(Double porcAporteEpsEmpleador) {
		this.porcAporteEpsEmpleador = porcAporteEpsEmpleador;
	}

	public Double getPorcAporteAfpAltoRiesgoEmpleador() {
		return porcAporteAfpAltoRiesgoEmpleador;
	}

	public void setPorcAporteAfpAltoRiesgoEmpleador(Double porcAporteAfpAltoRiesgoEmpleador) {
		this.porcAporteAfpAltoRiesgoEmpleador = porcAporteAfpAltoRiesgoEmpleador;
	}

	public Double getPorcAporteIcbfEmpleador() {
		return porcAporteIcbfEmpleador;
	}

	public void setPorcAporteIcbfEmpleador(Double porcAporteIcbfEmpleador) {
		this.porcAporteIcbfEmpleador = porcAporteIcbfEmpleador;
	}

	public Double getPorcAporteAfpEmpleador() {
		return porcAporteAfpEmpleador;
	}

	public void setPorcAporteAfpEmpleador(Double porcAporteAfpEmpleador) {
		this.porcAporteAfpEmpleador = porcAporteAfpEmpleador;
	}

	public Double getPorcAporteCcfEmpleador() {
		return porcAporteCcfEmpleador;
	}

	public void setPorcAporteCcfEmpleador(Double porcAporteCcfEmpleador) {
		this.porcAporteCcfEmpleador = porcAporteCcfEmpleador;
	}

	public Double getPorcAporteSenaEmpleador() {
		return porcAporteSenaEmpleador;
	}

	public void setPorcAporteSenaEmpleador(Double porcAporteSenaEmpleador) {
		this.porcAporteSenaEmpleador = porcAporteSenaEmpleador;
	}

	public Double getMinimoSmlAporteSenaIcbf() {
		return minimoSmlAporteSenaIcbf;
	}

	public void setMinimoSmlAporteSenaIcbf(Double minimoSmlAporteSenaIcbf) {
		this.minimoSmlAporteSenaIcbf = minimoSmlAporteSenaIcbf;
	}

	public String getAportesNominaLiquidan() {
		return aportesNominaLiquidan;
	}

	public void setAportesNominaLiquidan(String aportesNominaLiquidan) {
		this.aportesNominaLiquidan = aportesNominaLiquidan;
	}

	public Double getTopeSmlCotizarEps() {
		return topeSmlCotizarEps;
	}

	public void setTopeSmlCotizarEps(Double topeSmlCotizarEps) {
		this.topeSmlCotizarEps = topeSmlCotizarEps;
	}

	public Double getTopeSmlCotizarAfp() {
		return topeSmlCotizarAfp;
	}

	public void setTopeSmlCotizarAfp(Double topeSmlCotizarAfp) {
		this.topeSmlCotizarAfp = topeSmlCotizarAfp;
	}

	public Double getTopeSmlCotizarArl() {
		return topeSmlCotizarArl;
	}

	public void setTopeSmlCotizarArl(Double topeSmlCotizarArl) {
		this.topeSmlCotizarArl = topeSmlCotizarArl;
	}

	public String getAuxilioTransporteLiquidan() {
		return auxilioTransporteLiquidan;
	}

	public void setAuxilioTransporteLiquidan(String auxilioTransporteLiquidan) {
		this.auxilioTransporteLiquidan = auxilioTransporteLiquidan;
	}

	public Double getPorcAporteEpsTrabajador() {
		return porcAporteEpsTrabajador;
	}

	public void setPorcAporteEpsTrabajador(Double porcAporteEpsTrabajador) {
		this.porcAporteEpsTrabajador = porcAporteEpsTrabajador;
	}

	public Double getPorcAporteAfpTrabajador() {
		return porcAporteAfpTrabajador;
	}

	public void setPorcAporteAfpTrabajador(Double porcAporteAfpTrabajador) {
		this.porcAporteAfpTrabajador = porcAporteAfpTrabajador;
	}

	public Double getPorcAporteFspTrabajador() {
		return porcAporteFspTrabajador;
	}

	public void setPorcAporteFspTrabajador(Double porcAporteFspTrabajador) {
		this.porcAporteFspTrabajador = porcAporteFspTrabajador;
	}

	public Double getMinimoSmlAportaFSP() {
		return minimoSmlAportaFSP;
	}

	public void setMinimoSmlAportaFSP(Double minimoSmlAportaFSP) {
		this.minimoSmlAportaFSP = minimoSmlAportaFSP;
	}
}