package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class Nivel4DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel4DTO.class);
	private Double alturaPromedioPlantas;
	private String ana1;
	private Long aplicacionMadurante;
	private Double areaBruta;
	private Long variedad;
	private Double areaInutil;
	private Double areaManual;
	private Double areaMecanizada;
	private Double areaNeta;
	private Double areaOtrosCultivos;
	private Double areaReservada;
	private Double areaRestringida;
	private Long cantidadValvulasRiego;
	private String codigo;
	private Long codigoUsuarioApertura;
	private Long codigoUsuarioCierre;
	private Long compania;
	private String costosAmortizados;
	private Long edadActual;
	private Double edadUltimaCosecha;
	private Long espacioLineasSembradas;
	private String estado;
	private Date fechaAnalisisPostCosecha;
	private Date fechaAnalisisPreCosecha;
	private Date fechaAperturaCosecha;
	private Date fechaAplicacionMadurante;
	private Date fechaCierreCosecha;
	private Date fechaCorteAnterior;
	private Date fechaCreacion;
	private Date fechaEstimadaUltimoRiego;
	private Date fechaInactivo;
	private Date fechaModificacion;
	private Date fechaPrimerCorte;
	private Date fechaProximoCorte;
	private Date fechaSiembra;
	private Date fechaUltimoApunteRiego;
	private Date fechaUltimoCorte;
	private String fotoInfraestructura;
	private String generico;
	private String indiceHelada;
	private String infoAdicional;
	private String infoAdicional2;
	private Double kilmNivel4Fab;
	private Double kilmNivel4FabPav;
	private Double kilmNivel4FabTerraceria;
	private Float latitud;
	private Float longitud;
	private Long nivel4Id;
	private String nombre;
	private Long numComederosHect;
	private Double numDensidadActual;
	private Double numDensidadSiembra;
	private Double numEstimTonAnioFiscal;
	private Double numEstimTonHectPrimVez;
	private Double numEstimTonMesAnioFiscal;
	private Double numHectCosIndFab;
	private Double numHectOtroDestino;
	private Double numHectUltCosecha;
	private Long numLarvasSembradas;
	private Long numLineasSembradas;
	private Long numPlantasActuales;
	private Long numPlantasSembradas;
	private Long numPlantasSembradas2;
	private Double numRacionesCrustaceos;
	private Double numTonCosIndFab;
	private Double numTonOtroDestino;
	private Double numTonUltCosecha;
	private Double pesoPromedioNivel4;
	private Float precision;
	private String renovacion;
	private String semillero;
	private Long totalComederos;
	private Double ultDosisAplicadaMadurante;
	private Long almacenId_Almacen;
	private Long anioFiscalId_AnioFiscal;
	private Long claseTextSueloId_ClaseTextSuelo;
	private Long estClimatId_EstClimat;
	private Long estEvaporimetroId_EstEvaporimetro;
	private Long estPluvioId_EstPluvio;
	private Long etapaId_Etapa;
	private Long faseFenoId_FaseFenologica;
	private Long fliaTextSueloId_FliaTextSuelo;
	private Long grupoSuelo_GrpSuelo;
	private Long n4Mot_N4Motivo;
	private Long nivel3Id_Nivel3;
	private Long ocupacionId_Ocupacion;
	private Long ordenSuelo_OrdenSuelo;
	private Long organizId_Organizacion;
	private Long persEmprId_persEmpr;
	private Long serieSueloId_SerieSuelo;
	private Long tenenId_Tenencia;
	private Long tipoCultivoId_TipCultivo;
	private Long tipoDrenajeId_TipoDrenaje;
	private Long topografiaId_Topografia;
	private Long trabId_Trabajador;
	private Long zonAgroec_ZonAgroec;
	private Long madurante;
	private String NombreAnioFiscal;
	private String NombreEtapa;
	private Long sistemaRiego;
	private Date fechaDescanso;
	private Date fechaStart;
	private Double vacunosIniciales;
	private Double vacunosActuales;
	private String codigoAlternativo;
	private String nombreBloque;
	private Double numTonHaMesUltCosecha;
	
	
	/**
	 * @return the numTonHaMesUltCosecha
	 */
	public Double getNumTonHaMesUltCosecha() {
		return numTonHaMesUltCosecha;
	}

	/**
	 * @param numTonHaMesUltCosecha the numTonHaMesUltCosecha to set
	 */
	public void setNumTonHaMesUltCosecha(Double numTonHaMesUltCosecha) {
		this.numTonHaMesUltCosecha = numTonHaMesUltCosecha;
	}

	public String getNombreBloque() {
		return nombreBloque;
	}

	public void setNombreBloque(String nombreBloque) {
		this.nombreBloque = nombreBloque;
	}

	public String getCodigoAlternativo() {
		return codigoAlternativo;
	}

	public void setCodigoAlternativo(String codigoAlternativo) {
		this.codigoAlternativo = codigoAlternativo;
	}

	public Double getVacunosIniciales() {
		return vacunosIniciales;
	}

	public void setVacunosIniciales(Double vacunosIniciales) {
		this.vacunosIniciales = vacunosIniciales;
	}

	public Double getVacunosActuales() {
		return vacunosActuales;
	}

	public void setVacunosActuales(Double vacunosActuales) {
		this.vacunosActuales = vacunosActuales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Date getFechaStart() {
		return fechaStart;
	}

	public void setFechaStart(Date fechaStart) {
		this.fechaStart = fechaStart;
	}

	public Long getVariedad() {
		return variedad;
	}

	public void setVariedad(Long variedad) {
		this.variedad = variedad;
	}

	public Long getSistemaRiego() {
		return sistemaRiego;
	}

	public void setSistemaRiego(Long sistemaRiego) {
		this.sistemaRiego = sistemaRiego;
	}

	public Date getFechaDescanso() {
		return fechaDescanso;
	}

	public void setFechaDescanso(Date fechaDescanso) {
		this.fechaDescanso = fechaDescanso;
	}

	public Double getAlturaPromedioPlantas() {
		return alturaPromedioPlantas;
	}

	public void setAlturaPromedioPlantas(Double alturaPromedioPlantas) {
		this.alturaPromedioPlantas = alturaPromedioPlantas;
	}

	public String getAna1() {
		return ana1;
	}

	public void setAna1(String ana1) {
		this.ana1 = ana1;
	}

	public Long getAplicacionMadurante() {
		return aplicacionMadurante;
	}

	public void setAplicacionMadurante(Long aplicacionMadurante) {
		this.aplicacionMadurante = aplicacionMadurante;
	}

	public Double getAreaBruta() {
		return areaBruta;
	}

	public void setAreaBruta(Double areaBruta) {
		this.areaBruta = areaBruta;
	}

	public Double getAreaInutil() {
		return areaInutil;
	}

	public void setAreaInutil(Double areaInutil) {
		this.areaInutil = areaInutil;
	}

	public Double getAreaManual() {
		return areaManual;
	}

	public void setAreaManual(Double areaManual) {
		this.areaManual = areaManual;
	}

	public Double getAreaMecanizada() {
		return areaMecanizada;
	}

	public void setAreaMecanizada(Double areaMecanizada) {
		this.areaMecanizada = areaMecanizada;
	}

	public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}

	public Double getAreaOtrosCultivos() {
		return areaOtrosCultivos;
	}

	public void setAreaOtrosCultivos(Double areaOtrosCultivos) {
		this.areaOtrosCultivos = areaOtrosCultivos;
	}

	public Double getAreaReservada() {
		return areaReservada;
	}

	public void setAreaReservada(Double areaReservada) {
		this.areaReservada = areaReservada;
	}

	public Double getAreaRestringida() {
		return areaRestringida;
	}

	public void setAreaRestringida(Double areaRestringida) {
		this.areaRestringida = areaRestringida;
	}

	public Long getCantidadValvulasRiego() {
		return cantidadValvulasRiego;
	}

	public void setCantidadValvulasRiego(Long cantidadValvulasRiego) {
		this.cantidadValvulasRiego = cantidadValvulasRiego;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCodigoUsuarioApertura() {
		return codigoUsuarioApertura;
	}

	public void setCodigoUsuarioApertura(Long codigoUsuarioApertura) {
		this.codigoUsuarioApertura = codigoUsuarioApertura;
	}

	public Long getCodigoUsuarioCierre() {
		return codigoUsuarioCierre;
	}

	public void setCodigoUsuarioCierre(Long codigoUsuarioCierre) {
		this.codigoUsuarioCierre = codigoUsuarioCierre;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getCostosAmortizados() {
		return costosAmortizados;
	}

	public void setCostosAmortizados(String costosAmortizados) {
		this.costosAmortizados = costosAmortizados;
	}

	public Long getEdadActual() {
		return edadActual;
	}

	public void setEdadActual(Long edadActual) {
		this.edadActual = edadActual;
	}

	public Double getEdadUltimaCosecha() {
		return edadUltimaCosecha;
	}

	public void setEdadUltimaCosecha(Double edadUltimaCosecha) {
		this.edadUltimaCosecha = edadUltimaCosecha;
	}

	public Long getEspacioLineasSembradas() {
		return espacioLineasSembradas;
	}

	public void setEspacioLineasSembradas(Long espacioLineasSembradas) {
		this.espacioLineasSembradas = espacioLineasSembradas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAnalisisPostCosecha() {
		return fechaAnalisisPostCosecha;
	}

	public void setFechaAnalisisPostCosecha(Date fechaAnalisisPostCosecha) {
		this.fechaAnalisisPostCosecha = fechaAnalisisPostCosecha;
	}

	public Date getFechaAnalisisPreCosecha() {
		return fechaAnalisisPreCosecha;
	}

	public void setFechaAnalisisPreCosecha(Date fechaAnalisisPreCosecha) {
		this.fechaAnalisisPreCosecha = fechaAnalisisPreCosecha;
	}

	public Date getFechaAperturaCosecha() {
		return fechaAperturaCosecha;
	}

	public void setFechaAperturaCosecha(Date fechaAperturaCosecha) {
		this.fechaAperturaCosecha = fechaAperturaCosecha;
	}

	public Date getFechaAplicacionMadurante() {
		return fechaAplicacionMadurante;
	}

	public void setFechaAplicacionMadurante(Date fechaAplicacionMadurante) {
		this.fechaAplicacionMadurante = fechaAplicacionMadurante;
	}

	public Date getFechaCierreCosecha() {
		return fechaCierreCosecha;
	}

	public void setFechaCierreCosecha(Date fechaCierreCosecha) {
		this.fechaCierreCosecha = fechaCierreCosecha;
	}

	public Date getFechaCorteAnterior() {
		return fechaCorteAnterior;
	}

	public void setFechaCorteAnterior(Date fechaCorteAnterior) {
		this.fechaCorteAnterior = fechaCorteAnterior;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstimadaUltimoRiego() {
		return fechaEstimadaUltimoRiego;
	}

	public void setFechaEstimadaUltimoRiego(Date fechaEstimadaUltimoRiego) {
		this.fechaEstimadaUltimoRiego = fechaEstimadaUltimoRiego;
	}

	public Date getFechaInactivo() {
		return fechaInactivo;
	}

	public void setFechaInactivo(Date fechaInactivo) {
		this.fechaInactivo = fechaInactivo;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaPrimerCorte() {
		return fechaPrimerCorte;
	}

	public void setFechaPrimerCorte(Date fechaPrimerCorte) {
		this.fechaPrimerCorte = fechaPrimerCorte;
	}

	public Date getFechaProximoCorte() {
		return fechaProximoCorte;
	}

	public void setFechaProximoCorte(Date fechaProximoCorte) {
		this.fechaProximoCorte = fechaProximoCorte;
	}

	public Date getFechaSiembra() {
		return fechaSiembra;
	}

	public void setFechaSiembra(Date fechaSiembra) {
		this.fechaSiembra = fechaSiembra;
	}

	public Date getFechaUltimoApunteRiego() {
		return fechaUltimoApunteRiego;
	}

	public void setFechaUltimoApunteRiego(Date fechaUltimoApunteRiego) {
		this.fechaUltimoApunteRiego = fechaUltimoApunteRiego;
	}

	public Date getFechaUltimoCorte() {
		return fechaUltimoCorte;
	}

	public void setFechaUltimoCorte(Date fechaUltimoCorte) {
		this.fechaUltimoCorte = fechaUltimoCorte;
	}

	public String getFotoInfraestructura() {
		return fotoInfraestructura;
	}

	public void setFotoInfraestructura(String fotoInfraestructura) {
		this.fotoInfraestructura = fotoInfraestructura;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public String getIndiceHelada() {
		return indiceHelada;
	}

	public void setIndiceHelada(String indiceHelada) {
		this.indiceHelada = indiceHelada;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Double getKilmNivel4Fab() {
		return kilmNivel4Fab;
	}

	public void setKilmNivel4Fab(Double kilmNivel4Fab) {
		this.kilmNivel4Fab = kilmNivel4Fab;
	}

	public Double getKilmNivel4FabPav() {
		return kilmNivel4FabPav;
	}

	public void setKilmNivel4FabPav(Double kilmNivel4FabPav) {
		this.kilmNivel4FabPav = kilmNivel4FabPav;
	}

	public Double getKilmNivel4FabTerraceria() {
		return kilmNivel4FabTerraceria;
	}

	public void setKilmNivel4FabTerraceria(Double kilmNivel4FabTerraceria) {
		this.kilmNivel4FabTerraceria = kilmNivel4FabTerraceria;
	}

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Long getNivel4Id() {
		return nivel4Id;
	}

	public void setNivel4Id(Long nivel4Id) {
		this.nivel4Id = nivel4Id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNumComederosHect() {
		return numComederosHect;
	}

	public void setNumComederosHect(Long numComederosHect) {
		this.numComederosHect = numComederosHect;
	}

	public Double getNumDensidadActual() {
		return numDensidadActual;
	}

	public void setNumDensidadActual(Double numDensidadActual) {
		this.numDensidadActual = numDensidadActual;
	}

	public Double getNumDensidadSiembra() {
		return numDensidadSiembra;
	}

	public void setNumDensidadSiembra(Double numDensidadSiembra) {
		this.numDensidadSiembra = numDensidadSiembra;
	}

	public Double getNumEstimTonAnioFiscal() {
		return numEstimTonAnioFiscal;
	}

	public void setNumEstimTonAnioFiscal(Double numEstimTonAnioFiscal) {
		this.numEstimTonAnioFiscal = numEstimTonAnioFiscal;
	}

	public Double getNumEstimTonHectPrimVez() {
		return numEstimTonHectPrimVez;
	}

	public void setNumEstimTonHectPrimVez(Double numEstimTonHectPrimVez) {
		this.numEstimTonHectPrimVez = numEstimTonHectPrimVez;
	}

	public Double getNumEstimTonMesAnioFiscal() {
		return numEstimTonMesAnioFiscal;
	}

	public void setNumEstimTonMesAnioFiscal(Double numEstimTonMesAnioFiscal) {
		this.numEstimTonMesAnioFiscal = numEstimTonMesAnioFiscal;
	}

	public Double getNumHectCosIndFab() {
		return numHectCosIndFab;
	}

	public void setNumHectCosIndFab(Double numHectCosIndFab) {
		this.numHectCosIndFab = numHectCosIndFab;
	}

	public Double getNumHectOtroDestino() {
		return numHectOtroDestino;
	}

	public void setNumHectOtroDestino(Double numHectOtroDestino) {
		this.numHectOtroDestino = numHectOtroDestino;
	}

	public Double getNumHectUltCosecha() {
		return numHectUltCosecha;
	}

	public void setNumHectUltCosecha(Double numHectUltCosecha) {
		this.numHectUltCosecha = numHectUltCosecha;
	}

	public Long getNumLarvasSembradas() {
		return numLarvasSembradas;
	}

	public void setNumLarvasSembradas(Long numLarvasSembradas) {
		this.numLarvasSembradas = numLarvasSembradas;
	}

	public Long getNumLineasSembradas() {
		return numLineasSembradas;
	}

	public void setNumLineasSembradas(Long numLineasSembradas) {
		this.numLineasSembradas = numLineasSembradas;
	}

	public Long getNumPlantasActuales() {
		return numPlantasActuales;
	}

	public void setNumPlantasActuales(Long numPlantasActuales) {
		this.numPlantasActuales = numPlantasActuales;
	}

	public Long getNumPlantasSembradas() {
		return numPlantasSembradas;
	}

	public void setNumPlantasSembradas(Long numPlantasSembradas) {
		this.numPlantasSembradas = numPlantasSembradas;
	}

	public Long getNumPlantasSembradas2() {
		return numPlantasSembradas2;
	}

	public void setNumPlantasSembradas2(Long numPlantasSembradas2) {
		this.numPlantasSembradas2 = numPlantasSembradas2;
	}

	public Double getNumRacionesCrustaceos() {
		return numRacionesCrustaceos;
	}

	public void setNumRacionesCrustaceos(Double numRacionesCrustaceos) {
		this.numRacionesCrustaceos = numRacionesCrustaceos;
	}

	public Double getNumTonCosIndFab() {
		return numTonCosIndFab;
	}

	public void setNumTonCosIndFab(Double numTonCosIndFab) {
		this.numTonCosIndFab = numTonCosIndFab;
	}

	public Double getNumTonOtroDestino() {
		return numTonOtroDestino;
	}

	public void setNumTonOtroDestino(Double numTonOtroDestino) {
		this.numTonOtroDestino = numTonOtroDestino;
	}

	public Double getNumTonUltCosecha() {
		return numTonUltCosecha;
	}

	public void setNumTonUltCosecha(Double numTonUltCosecha) {
		this.numTonUltCosecha = numTonUltCosecha;
	}

	public Double getPesoPromedioNivel4() {
		return pesoPromedioNivel4;
	}

	public void setPesoPromedioNivel4(Double pesoPromedioNivel4) {
		this.pesoPromedioNivel4 = pesoPromedioNivel4;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public String getRenovacion() {
		return renovacion;
	}

	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

	public String getSemillero() {
		return semillero;
	}

	public void setSemillero(String semillero) {
		this.semillero = semillero;
	}

	public Long getTotalComederos() {
		return totalComederos;
	}

	public void setTotalComederos(Long totalComederos) {
		this.totalComederos = totalComederos;
	}

	public Double getUltDosisAplicadaMadurante() {
		return ultDosisAplicadaMadurante;
	}

	public void setUltDosisAplicadaMadurante(Double ultDosisAplicadaMadurante) {
		this.ultDosisAplicadaMadurante = ultDosisAplicadaMadurante;
	}

	public Long getAlmacenId_Almacen() {
		return almacenId_Almacen;
	}

	public void setAlmacenId_Almacen(Long almacenId_Almacen) {
		this.almacenId_Almacen = almacenId_Almacen;
	}

	public Long getAnioFiscalId_AnioFiscal() {
		return anioFiscalId_AnioFiscal;
	}

	public void setAnioFiscalId_AnioFiscal(Long anioFiscalId_AnioFiscal) {
		this.anioFiscalId_AnioFiscal = anioFiscalId_AnioFiscal;
	}

	public Long getClaseTextSueloId_ClaseTextSuelo() {
		return claseTextSueloId_ClaseTextSuelo;
	}

	public void setClaseTextSueloId_ClaseTextSuelo(Long claseTextSueloId_ClaseTextSuelo) {
		this.claseTextSueloId_ClaseTextSuelo = claseTextSueloId_ClaseTextSuelo;
	}

	public Long getEstClimatId_EstClimat() {
		return estClimatId_EstClimat;
	}

	public void setEstClimatId_EstClimat(Long estClimatId_EstClimat) {
		this.estClimatId_EstClimat = estClimatId_EstClimat;
	}

	public Long getEstEvaporimetroId_EstEvaporimetro() {
		return estEvaporimetroId_EstEvaporimetro;
	}

	public void setEstEvaporimetroId_EstEvaporimetro(Long estEvaporimetroId_EstEvaporimetro) {
		this.estEvaporimetroId_EstEvaporimetro = estEvaporimetroId_EstEvaporimetro;
	}

	public Long getEstPluvioId_EstPluvio() {
		return estPluvioId_EstPluvio;
	}

	public void setEstPluvioId_EstPluvio(Long estPluvioId_EstPluvio) {
		this.estPluvioId_EstPluvio = estPluvioId_EstPluvio;
	}

	public Long getEtapaId_Etapa() {
		return etapaId_Etapa;
	}

	public void setEtapaId_Etapa(Long etapaId_Etapa) {
		this.etapaId_Etapa = etapaId_Etapa;
	}

	public Long getFaseFenoId_FaseFenologica() {
		return faseFenoId_FaseFenologica;
	}

	public void setFaseFenoId_FaseFenologica(Long faseFenoId_FaseFenologica) {
		this.faseFenoId_FaseFenologica = faseFenoId_FaseFenologica;
	}

	public Long getFliaTextSueloId_FliaTextSuelo() {
		return fliaTextSueloId_FliaTextSuelo;
	}

	public void setFliaTextSueloId_FliaTextSuelo(Long fliaTextSueloId_FliaTextSuelo) {
		this.fliaTextSueloId_FliaTextSuelo = fliaTextSueloId_FliaTextSuelo;
	}

	public Long getGrupoSuelo_GrpSuelo() {
		return grupoSuelo_GrpSuelo;
	}

	public void setGrupoSuelo_GrpSuelo(Long grupoSuelo_GrpSuelo) {
		this.grupoSuelo_GrpSuelo = grupoSuelo_GrpSuelo;
	}

	public Long getN4Mot_N4Motivo() {
		return n4Mot_N4Motivo;
	}

	public void setN4Mot_N4Motivo(Long n4Mot_N4Motivo) {
		this.n4Mot_N4Motivo = n4Mot_N4Motivo;
	}

	public Long getNivel3Id_Nivel3() {
		return nivel3Id_Nivel3;
	}

	public void setNivel3Id_Nivel3(Long nivel3Id_Nivel3) {
		this.nivel3Id_Nivel3 = nivel3Id_Nivel3;
	}

	public Long getOcupacionId_Ocupacion() {
		return ocupacionId_Ocupacion;
	}

	public void setOcupacionId_Ocupacion(Long ocupacionId_Ocupacion) {
		this.ocupacionId_Ocupacion = ocupacionId_Ocupacion;
	}

	public Long getOrdenSuelo_OrdenSuelo() {
		return ordenSuelo_OrdenSuelo;
	}

	public void setOrdenSuelo_OrdenSuelo(Long ordenSuelo_OrdenSuelo) {
		this.ordenSuelo_OrdenSuelo = ordenSuelo_OrdenSuelo;
	}

	public Long getOrganizId_Organizacion() {
		return organizId_Organizacion;
	}

	public void setOrganizId_Organizacion(Long organizId_Organizacion) {
		this.organizId_Organizacion = organizId_Organizacion;
	}

	public Long getPersEmprId_persEmpr() {
		return persEmprId_persEmpr;
	}

	public void setPersEmprId_persEmpr(Long persEmprId_persEmpr) {
		this.persEmprId_persEmpr = persEmprId_persEmpr;
	}

	public Long getSerieSueloId_SerieSuelo() {
		return serieSueloId_SerieSuelo;
	}

	public void setSerieSueloId_SerieSuelo(Long serieSueloId_SerieSuelo) {
		this.serieSueloId_SerieSuelo = serieSueloId_SerieSuelo;
	}

	public Long getTenenId_Tenencia() {
		return tenenId_Tenencia;
	}

	public void setTenenId_Tenencia(Long tenenId_Tenencia) {
		this.tenenId_Tenencia = tenenId_Tenencia;
	}

	public Long getTipoCultivoId_TipCultivo() {
		return tipoCultivoId_TipCultivo;
	}

	public void setTipoCultivoId_TipCultivo(Long tipoCultivoId_TipCultivo) {
		this.tipoCultivoId_TipCultivo = tipoCultivoId_TipCultivo;
	}

	public Long getTipoDrenajeId_TipoDrenaje() {
		return tipoDrenajeId_TipoDrenaje;
	}

	public void setTipoDrenajeId_TipoDrenaje(Long tipoDrenajeId_TipoDrenaje) {
		this.tipoDrenajeId_TipoDrenaje = tipoDrenajeId_TipoDrenaje;
	}

	public Long getTopografiaId_Topografia() {
		return topografiaId_Topografia;
	}

	public void setTopografiaId_Topografia(Long topografiaId_Topografia) {
		this.topografiaId_Topografia = topografiaId_Topografia;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Long getZonAgroec_ZonAgroec() {
		return zonAgroec_ZonAgroec;
	}

	public void setZonAgroec_ZonAgroec(Long zonAgroec_ZonAgroec) {
		this.zonAgroec_ZonAgroec = zonAgroec_ZonAgroec;
	}

	public Long getMadurante() {
		return madurante;
	}

	public void setMadurante(Long madurante) {
		this.madurante = madurante;
	}

	public String getNombreAnioFiscal() {
		return NombreAnioFiscal;
	}

	public void setNombreAnioFiscal(String nombreAnioFiscal) {
		NombreAnioFiscal = nombreAnioFiscal;
	}

	public String getNombreEtapa() {
		return NombreEtapa;
	}

	public void setNombreEtapa(String nombreEtapa) {
		NombreEtapa = nombreEtapa;
	}

}
