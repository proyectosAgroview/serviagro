package co.com.arcosoft.modelo;

// Generated 05-ago-2015 14:10:19 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cultivo generated by hbm2java
 */
public class Cultivo implements java.io.Serializable {

	private Long cultivoId;
	private UdadMed udadMedByUdadMedId;
	private UdadMed udadMedByUdadMedId1;
	private String codigo;
	private String nombre;
	private String logoCultivo;
	private String calcularEdad;
	private String mostrarEdad;
	private String controlPlanta;
	private String calcularArea;
	private String aplicaPolinizado;
	private String analisisLaboratorio;
	private String controlProduccion;
	private String controlSemillero;
	private String modeloPlanificacionCosecha;
	private String esPecuaria;
	private String esAcuicultura;
	private String esMineria;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<FaseFenologica> faseFenologicas = new HashSet<FaseFenologica>(0);
	private Set<CultivoFitosanidad> cultivoFitosanidads = new HashSet<CultivoFitosanidad>(0);
	private Set<AnaCultivo> anaCultivos = new HashSet<AnaCultivo>(0);
	private Set<TipCultivo> tipCultivos = new HashSet<TipCultivo>(0);
	private Set<Etapa> etapas = new HashSet<Etapa>(0);
	private Set<Variedad> variedads = new HashSet<Variedad>(0);
	private Set<DistSiembra> distSiembras = new HashSet<DistSiembra>(0);
	 private Set<AnaLabCultivo> anaLabCultivos = new HashSet<AnaLabCultivo>(0);
     private Set<MaduranteProducto> maduranteProductos = new HashSet<MaduranteProducto>(0);

	 
	public Cultivo() {
	}

	public Cultivo(Long cultivoId) {
		this.cultivoId = cultivoId;
	}

	public Cultivo(Long cultivoId, UdadMed udadMedByUdadMedId, UdadMed udadMedByUdadMedId1, String codigo,
			String nombre, String logoCultivo, String calcularEdad, String mostrarEdad, String controlPlanta,
			String calcularArea, String aplicaPolinizado, String analisisLaboratorio, String controlProduccion,
			String controlSemillero, String modeloPlanificacionCosecha, String esPecuaria, String esAcuicultura,
			String esMineria, Long compania, String infoAdicional, String infoAdicional2, Date fechaCreacion,
			Date fechaModificacion, String estado, Set<FaseFenologica> faseFenologicas,
			Set<CultivoFitosanidad> cultivoFitosanidads, Set<AnaCultivo> anaCultivos, Set<TipCultivo> tipCultivos,
			Set<Etapa> etapas, Set<Variedad> variedads, Set<DistSiembra> distSiembras, 
			Set<AnaLabCultivo> anaLabCultivos, Set<MaduranteProducto> maduranteProductos) {
		this.cultivoId = cultivoId;
		this.udadMedByUdadMedId = udadMedByUdadMedId;
		this.udadMedByUdadMedId1 = udadMedByUdadMedId1;
		this.codigo = codigo;
		this.nombre = nombre;
		this.logoCultivo = logoCultivo;
		this.calcularEdad = calcularEdad;
		this.mostrarEdad = mostrarEdad;
		this.controlPlanta = controlPlanta;
		this.calcularArea = calcularArea;
		this.aplicaPolinizado = aplicaPolinizado;
		this.analisisLaboratorio = analisisLaboratorio;
		this.controlProduccion = controlProduccion;
		this.controlSemillero = controlSemillero;
		this.modeloPlanificacionCosecha = modeloPlanificacionCosecha;
		this.esPecuaria = esPecuaria;
		this.esAcuicultura = esAcuicultura;
		this.esMineria = esMineria;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.faseFenologicas = faseFenologicas;
		this.cultivoFitosanidads = cultivoFitosanidads;
		this.anaCultivos = anaCultivos;
		this.tipCultivos = tipCultivos;
		this.etapas = etapas;
		this.variedads = variedads;
		this.distSiembras = distSiembras;		
		this.anaLabCultivos = anaLabCultivos;
		this.maduranteProductos = maduranteProductos ;
	
	}
	
	

	public Set<MaduranteProducto> getMaduranteProductos() {
		return maduranteProductos;
	}

	public void setMaduranteProductos(Set<MaduranteProducto> maduranteProductos) {
		this.maduranteProductos = maduranteProductos;
	}

	public Set<AnaLabCultivo> getAnaLabCultivos() {
		return anaLabCultivos;
	}

	public void setAnaLabCultivos(Set<AnaLabCultivo> anaLabCultivos) {
		this.anaLabCultivos = anaLabCultivos;
	}

	public Set<DistSiembra> getDistSiembras() {
		return distSiembras;
	}

	public void setDistSiembras(Set<DistSiembra> distSiembras) {
		this.distSiembras = distSiembras;
	}

	public Long getCultivoId() {
		return this.cultivoId;
	}

	public void setCultivoId(Long cultivoId) {
		this.cultivoId = cultivoId;
	}

	public UdadMed getUdadMedByUdadMedId() {
		return this.udadMedByUdadMedId;
	}

	public void setUdadMedByUdadMedId(UdadMed udadMedByUdadMedId) {
		this.udadMedByUdadMedId = udadMedByUdadMedId;
	}

	public UdadMed getUdadMedByUdadMedId1() {
		return this.udadMedByUdadMedId1;
	}

	public void setUdadMedByUdadMedId1(UdadMed udadMedByUdadMedId1) {
		this.udadMedByUdadMedId1 = udadMedByUdadMedId1;
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

	public String getLogoCultivo() {
		return this.logoCultivo;
	}

	public void setLogoCultivo(String logoCultivo) {
		this.logoCultivo = logoCultivo;
	}

	public String getCalcularEdad() {
		return this.calcularEdad;
	}

	public void setCalcularEdad(String calcularEdad) {
		this.calcularEdad = calcularEdad;
	}

	public String getMostrarEdad() {
		return this.mostrarEdad;
	}

	public void setMostrarEdad(String mostrarEdad) {
		this.mostrarEdad = mostrarEdad;
	}

	public String getControlPlanta() {
		return this.controlPlanta;
	}

	public void setControlPlanta(String controlPlanta) {
		this.controlPlanta = controlPlanta;
	}

	public String getCalcularArea() {
		return this.calcularArea;
	}

	public void setCalcularArea(String calcularArea) {
		this.calcularArea = calcularArea;
	}

	public String getAplicaPolinizado() {
		return this.aplicaPolinizado;
	}

	public void setAplicaPolinizado(String aplicaPolinizado) {
		this.aplicaPolinizado = aplicaPolinizado;
	}

	public String getAnalisisLaboratorio() {
		return this.analisisLaboratorio;
	}

	public void setAnalisisLaboratorio(String analisisLaboratorio) {
		this.analisisLaboratorio = analisisLaboratorio;
	}

	public String getControlProduccion() {
		return this.controlProduccion;
	}

	public void setControlProduccion(String controlProduccion) {
		this.controlProduccion = controlProduccion;
	}

	public String getControlSemillero() {
		return this.controlSemillero;
	}

	public void setControlSemillero(String controlSemillero) {
		this.controlSemillero = controlSemillero;
	}

	public String getModeloPlanificacionCosecha() {
		return this.modeloPlanificacionCosecha;
	}

	public void setModeloPlanificacionCosecha(String modeloPlanificacionCosecha) {
		this.modeloPlanificacionCosecha = modeloPlanificacionCosecha;
	}

	public String getEsPecuaria() {
		return this.esPecuaria;
	}

	public void setEsPecuaria(String esPecuaria) {
		this.esPecuaria = esPecuaria;
	}

	public String getEsAcuicultura() {
		return this.esAcuicultura;
	}

	public void setEsAcuicultura(String esAcuicultura) {
		this.esAcuicultura = esAcuicultura;
	}

	public String getEsMineria() {
		return this.esMineria;
	}

	public void setEsMineria(String esMineria) {
		this.esMineria = esMineria;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Set<FaseFenologica> getFaseFenologicas() {
		return this.faseFenologicas;
	}

	public void setFaseFenologicas(Set<FaseFenologica> faseFenologicas) {
		this.faseFenologicas = faseFenologicas;
	}

	public Set<CultivoFitosanidad> getCultivoFitosanidads() {
		return this.cultivoFitosanidads;
	}

	public void setCultivoFitosanidads(Set<CultivoFitosanidad> cultivoFitosanidads) {
		this.cultivoFitosanidads = cultivoFitosanidads;
	}

	public Set<AnaCultivo> getAnaCultivos() {
		return this.anaCultivos;
	}

	public void setAnaCultivos(Set<AnaCultivo> anaCultivos) {
		this.anaCultivos = anaCultivos;
	}

	public Set<TipCultivo> getTipCultivos() {
		return this.tipCultivos;
	}

	public void setTipCultivos(Set<TipCultivo> tipCultivos) {
		this.tipCultivos = tipCultivos;
	}

	public Set<Etapa> getEtapas() {
		return this.etapas;
	}

	public void setEtapas(Set<Etapa> etapas) {
		this.etapas = etapas;
	}

	public Set<Variedad> getVariedads() {
		return this.variedads;
	}

	public void setVariedads(Set<Variedad> variedads) {
		this.variedads = variedads;
	}

}
