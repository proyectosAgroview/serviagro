package co.com.arcosoft.modelo;
// Generated 23-jul-2017 14:00:29 by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * Nivel4Hvida generated by hbm2java
 */
public class Nivel4Hvida  implements java.io.Serializable {


     private Long nivel4HvidaId;
     private String codigo;
     private Long nivel3Id;
     private Long faseFenoId;
     private Long anioFiscalId;
     private Long tenenId;
     private Long almacenId;
     private Long grupoSuelo;
     private Long etapaId;
     private Long organizId;
     private Long fliaTextSueloId;
     private Long claseTextSueloId;
     private Long ordenSuelo;
     private Long serieSueloId;
     private Long zonAgroec;
     private Long n4Mot;
     private Long ocupacionId;
     private Long estClimatId;
     private Long compania;
     private String nombre;
     private Double areaBruta;
     private Double areaMecanizada;
     private Double areaManual;
     private Double areaInutil;
     private Double areaOtrosCultivos;
     private Double areaReservada;
     private Double areaRestringida;
     private Double areaNeta;
     private Date fechaSiembra;
     private Date fechaPrimerCorte;
     private Date fechaUltimoCorte;
     private Date fechaCorteAnterior;
     private Date fechaAnalisisPostCosecha;
     private Date fechaAplicacionMadurante;
     private Date fechaProximoCorte;
     private Date fechaUltimoApunteRiego;
     private Date fechaEstimadaUltimoRiego;
     private Double numEstimTonHectPrimVez;
     private Double numEstimTonAnioFiscal;
     private Double numEstimTonMesAnioFiscal;
     private Double numHectUltCosecha;
     private Double numTonUltCosecha;
     private Double numHectCosIndFab;
     private Double numTonCosIndFab;
     private Double numHectOtroDestino;
     private Double edadActual;
     private Double edadUltimaCosecha;
     private String indiceHelada;
     private Double kilmNivel4Fab;
     private Double kilmNivel4FabPav;
     private Double kilmNivel4FabTerraceria;
     private Integer aplicacionMadurante;
     private Double ultDosisAplicadaMadurante;
     private String longitud;
     private String latitud;
     private String precision1;
     private Long numComederosHect;
     private Long totalComederos;
     private Long numLarvasSembradas;
     private Double numRacionesCrustaceos;
     private String renovacion;
     private String semillero;
     private Date fechaInactivo;
     private Long numPlantasSembradas;
     private Long numPlantasActuales;
     private Double numDensidadSiembra;
     private Double alturaPromedioPlantas;
     private Double pesoPromedioNivel4;
     private Long cantidadValvulasRiego;
     private Long numLineasSembradas;
     private Long numPlantasSembradas2;
     private Long espacioLineasSembradas;
     private String generico;
     private String costosAmortizados;
     private Date fechaCierreCosecha;
     private Date fechaAperturaCosecha;
     private String fotoInfraestructura;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String ana1;
     private String infoAdicional;
     private String infoAdicional2;
     private String estado;
     private Long estPluvioId;
     private Long tipoDrenajeId;
     private Long topografiaId;
     private Long persEmprId;
     private Long codigoUsuarioApertura;
     private Long codigoUsuarioCierre;
     private Long trabId;
     private Long tipoCultivoId;
     private Double numTonOtroDestino;
     private Double numDensidadActual;
     private Long estEvaporimetroId;
     private Long madurante;
     private Date fechaAnalisisPreCosecha;
     private Double variable1;
     private Double variable2;
     private Double variable3;
     private Double variable4;
     private Double variable5;

    public Nivel4Hvida() {
    }

    public Nivel4Hvida(String codigo, Long nivel3Id, Long faseFenoId, Long anioFiscalId, Long tenenId, Long almacenId, Long grupoSuelo, Long etapaId, Long organizId, Long fliaTextSueloId, Long claseTextSueloId, Long ordenSuelo, Long serieSueloId, Long zonAgroec, Long n4Mot, Long ocupacionId, Long estClimatId, Long compania, String nombre, Double areaBruta, Double areaMecanizada, Double areaManual, Double areaInutil, Double areaOtrosCultivos, Double areaReservada, Double areaRestringida, Double areaNeta, Date fechaSiembra, Date fechaPrimerCorte, Date fechaUltimoCorte, Date fechaCorteAnterior, Date fechaAnalisisPostCosecha, Date fechaAplicacionMadurante, Date fechaProximoCorte, Date fechaUltimoApunteRiego, Date fechaEstimadaUltimoRiego, Double numEstimTonHectPrimVez, Double numEstimTonAnioFiscal, Double numEstimTonMesAnioFiscal, Double numHectUltCosecha, Double numTonUltCosecha, Double numHectCosIndFab, Double numTonCosIndFab, Double numHectOtroDestino, Double edadActual, Double edadUltimaCosecha, String indiceHelada, Double kilmNivel4Fab, Double kilmNivel4FabPav, Double kilmNivel4FabTerraceria, Integer aplicacionMadurante, Double ultDosisAplicadaMadurante, String longitud, String latitud, String precision1, Long numComederosHect, Long totalComederos, Long numLarvasSembradas, Double numRacionesCrustaceos, String renovacion, String semillero, Date fechaInactivo, Long numPlantasSembradas, Long numPlantasActuales, Double numDensidadSiembra, Double alturaPromedioPlantas, Double pesoPromedioNivel4, Long cantidadValvulasRiego, Long numLineasSembradas, Long numPlantasSembradas2, Long espacioLineasSembradas, String generico, String costosAmortizados, Date fechaCierreCosecha, Date fechaAperturaCosecha, String fotoInfraestructura, Date fechaCreacion, Date fechaModificacion, String ana1, String infoAdicional, String infoAdicional2, String estado, Long estPluvioId, Long tipoDrenajeId, Long topografiaId, Long persEmprId, Long codigoUsuarioApertura, Long codigoUsuarioCierre, Long trabId, Long tipoCultivoId, Double numTonOtroDestino, Double numDensidadActual, Long estEvaporimetroId, Long madurante, Date fechaAnalisisPreCosecha, Double variable1, Double variable2, Double variable3, Double variable4, Double variable5) {
       this.codigo = codigo;
       this.nivel3Id = nivel3Id;
       this.faseFenoId = faseFenoId;
       this.anioFiscalId = anioFiscalId;
       this.tenenId = tenenId;
       this.almacenId = almacenId;
       this.grupoSuelo = grupoSuelo;
       this.etapaId = etapaId;
       this.organizId = organizId;
       this.fliaTextSueloId = fliaTextSueloId;
       this.claseTextSueloId = claseTextSueloId;
       this.ordenSuelo = ordenSuelo;
       this.serieSueloId = serieSueloId;
       this.zonAgroec = zonAgroec;
       this.n4Mot = n4Mot;
       this.ocupacionId = ocupacionId;
       this.estClimatId = estClimatId;
       this.compania = compania;
       this.nombre = nombre;
       this.areaBruta = areaBruta;
       this.areaMecanizada = areaMecanizada;
       this.areaManual = areaManual;
       this.areaInutil = areaInutil;
       this.areaOtrosCultivos = areaOtrosCultivos;
       this.areaReservada = areaReservada;
       this.areaRestringida = areaRestringida;
       this.areaNeta = areaNeta;
       this.fechaSiembra = fechaSiembra;
       this.fechaPrimerCorte = fechaPrimerCorte;
       this.fechaUltimoCorte = fechaUltimoCorte;
       this.fechaCorteAnterior = fechaCorteAnterior;
       this.fechaAnalisisPostCosecha = fechaAnalisisPostCosecha;
       this.fechaAplicacionMadurante = fechaAplicacionMadurante;
       this.fechaProximoCorte = fechaProximoCorte;
       this.fechaUltimoApunteRiego = fechaUltimoApunteRiego;
       this.fechaEstimadaUltimoRiego = fechaEstimadaUltimoRiego;
       this.numEstimTonHectPrimVez = numEstimTonHectPrimVez;
       this.numEstimTonAnioFiscal = numEstimTonAnioFiscal;
       this.numEstimTonMesAnioFiscal = numEstimTonMesAnioFiscal;
       this.numHectUltCosecha = numHectUltCosecha;
       this.numTonUltCosecha = numTonUltCosecha;
       this.numHectCosIndFab = numHectCosIndFab;
       this.numTonCosIndFab = numTonCosIndFab;
       this.numHectOtroDestino = numHectOtroDestino;
       this.edadActual = edadActual;
       this.edadUltimaCosecha = edadUltimaCosecha;
       this.indiceHelada = indiceHelada;
       this.kilmNivel4Fab = kilmNivel4Fab;
       this.kilmNivel4FabPav = kilmNivel4FabPav;
       this.kilmNivel4FabTerraceria = kilmNivel4FabTerraceria;
       this.aplicacionMadurante = aplicacionMadurante;
       this.ultDosisAplicadaMadurante = ultDosisAplicadaMadurante;
       this.longitud = longitud;
       this.latitud = latitud;
       this.precision1 = precision1;
       this.numComederosHect = numComederosHect;
       this.totalComederos = totalComederos;
       this.numLarvasSembradas = numLarvasSembradas;
       this.numRacionesCrustaceos = numRacionesCrustaceos;
       this.renovacion = renovacion;
       this.semillero = semillero;
       this.fechaInactivo = fechaInactivo;
       this.numPlantasSembradas = numPlantasSembradas;
       this.numPlantasActuales = numPlantasActuales;
       this.numDensidadSiembra = numDensidadSiembra;
       this.alturaPromedioPlantas = alturaPromedioPlantas;
       this.pesoPromedioNivel4 = pesoPromedioNivel4;
       this.cantidadValvulasRiego = cantidadValvulasRiego;
       this.numLineasSembradas = numLineasSembradas;
       this.numPlantasSembradas2 = numPlantasSembradas2;
       this.espacioLineasSembradas = espacioLineasSembradas;
       this.generico = generico;
       this.costosAmortizados = costosAmortizados;
       this.fechaCierreCosecha = fechaCierreCosecha;
       this.fechaAperturaCosecha = fechaAperturaCosecha;
       this.fotoInfraestructura = fotoInfraestructura;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.ana1 = ana1;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.estado = estado;
       this.estPluvioId = estPluvioId;
       this.tipoDrenajeId = tipoDrenajeId;
       this.topografiaId = topografiaId;
       this.persEmprId = persEmprId;
       this.codigoUsuarioApertura = codigoUsuarioApertura;
       this.codigoUsuarioCierre = codigoUsuarioCierre;
       this.trabId = trabId;
       this.tipoCultivoId = tipoCultivoId;
       this.numTonOtroDestino = numTonOtroDestino;
       this.numDensidadActual = numDensidadActual;
       this.estEvaporimetroId = estEvaporimetroId;
       this.madurante = madurante;
       this.fechaAnalisisPreCosecha = fechaAnalisisPreCosecha;
       this.variable1 = variable1;
       this.variable2 = variable2;
       this.variable3 = variable3;
       this.variable4 = variable4;
       this.variable5 = variable5;
    }
   
    public Long getNivel4HvidaId() {
        return this.nivel4HvidaId;
    }
    
    public void setNivel4HvidaId(Long nivel4HvidaId) {
        this.nivel4HvidaId = nivel4HvidaId;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Long getNivel3Id() {
        return this.nivel3Id;
    }
    
    public void setNivel3Id(Long nivel3Id) {
        this.nivel3Id = nivel3Id;
    }
    public Long getFaseFenoId() {
        return this.faseFenoId;
    }
    
    public void setFaseFenoId(Long faseFenoId) {
        this.faseFenoId = faseFenoId;
    }
    public Long getAnioFiscalId() {
        return this.anioFiscalId;
    }
    
    public void setAnioFiscalId(Long anioFiscalId) {
        this.anioFiscalId = anioFiscalId;
    }
    public Long getTenenId() {
        return this.tenenId;
    }
    
    public void setTenenId(Long tenenId) {
        this.tenenId = tenenId;
    }
    public Long getAlmacenId() {
        return this.almacenId;
    }
    
    public void setAlmacenId(Long almacenId) {
        this.almacenId = almacenId;
    }
    public Long getGrupoSuelo() {
        return this.grupoSuelo;
    }
    
    public void setGrupoSuelo(Long grupoSuelo) {
        this.grupoSuelo = grupoSuelo;
    }
    public Long getEtapaId() {
        return this.etapaId;
    }
    
    public void setEtapaId(Long etapaId) {
        this.etapaId = etapaId;
    }
    public Long getOrganizId() {
        return this.organizId;
    }
    
    public void setOrganizId(Long organizId) {
        this.organizId = organizId;
    }
    public Long getFliaTextSueloId() {
        return this.fliaTextSueloId;
    }
    
    public void setFliaTextSueloId(Long fliaTextSueloId) {
        this.fliaTextSueloId = fliaTextSueloId;
    }
    public Long getClaseTextSueloId() {
        return this.claseTextSueloId;
    }
    
    public void setClaseTextSueloId(Long claseTextSueloId) {
        this.claseTextSueloId = claseTextSueloId;
    }
    public Long getOrdenSuelo() {
        return this.ordenSuelo;
    }
    
    public void setOrdenSuelo(Long ordenSuelo) {
        this.ordenSuelo = ordenSuelo;
    }
    public Long getSerieSueloId() {
        return this.serieSueloId;
    }
    
    public void setSerieSueloId(Long serieSueloId) {
        this.serieSueloId = serieSueloId;
    }
    public Long getZonAgroec() {
        return this.zonAgroec;
    }
    
    public void setZonAgroec(Long zonAgroec) {
        this.zonAgroec = zonAgroec;
    }
    public Long getN4Mot() {
        return this.n4Mot;
    }
    
    public void setN4Mot(Long n4Mot) {
        this.n4Mot = n4Mot;
    }
    public Long getOcupacionId() {
        return this.ocupacionId;
    }
    
    public void setOcupacionId(Long ocupacionId) {
        this.ocupacionId = ocupacionId;
    }
    public Long getEstClimatId() {
        return this.estClimatId;
    }
    
    public void setEstClimatId(Long estClimatId) {
        this.estClimatId = estClimatId;
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
    public Date getFechaSiembra() {
        return this.fechaSiembra;
    }
    
    public void setFechaSiembra(Date fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }
    public Date getFechaPrimerCorte() {
        return this.fechaPrimerCorte;
    }
    
    public void setFechaPrimerCorte(Date fechaPrimerCorte) {
        this.fechaPrimerCorte = fechaPrimerCorte;
    }
    public Date getFechaUltimoCorte() {
        return this.fechaUltimoCorte;
    }
    
    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }
    public Date getFechaCorteAnterior() {
        return this.fechaCorteAnterior;
    }
    
    public void setFechaCorteAnterior(Date fechaCorteAnterior) {
        this.fechaCorteAnterior = fechaCorteAnterior;
    }
    public Date getFechaAnalisisPostCosecha() {
        return this.fechaAnalisisPostCosecha;
    }
    
    public void setFechaAnalisisPostCosecha(Date fechaAnalisisPostCosecha) {
        this.fechaAnalisisPostCosecha = fechaAnalisisPostCosecha;
    }
    public Date getFechaAplicacionMadurante() {
        return this.fechaAplicacionMadurante;
    }
    
    public void setFechaAplicacionMadurante(Date fechaAplicacionMadurante) {
        this.fechaAplicacionMadurante = fechaAplicacionMadurante;
    }
    public Date getFechaProximoCorte() {
        return this.fechaProximoCorte;
    }
    
    public void setFechaProximoCorte(Date fechaProximoCorte) {
        this.fechaProximoCorte = fechaProximoCorte;
    }
    public Date getFechaUltimoApunteRiego() {
        return this.fechaUltimoApunteRiego;
    }
    
    public void setFechaUltimoApunteRiego(Date fechaUltimoApunteRiego) {
        this.fechaUltimoApunteRiego = fechaUltimoApunteRiego;
    }
    public Date getFechaEstimadaUltimoRiego() {
        return this.fechaEstimadaUltimoRiego;
    }
    
    public void setFechaEstimadaUltimoRiego(Date fechaEstimadaUltimoRiego) {
        this.fechaEstimadaUltimoRiego = fechaEstimadaUltimoRiego;
    }
    public Double getNumEstimTonHectPrimVez() {
        return this.numEstimTonHectPrimVez;
    }
    
    public void setNumEstimTonHectPrimVez(Double numEstimTonHectPrimVez) {
        this.numEstimTonHectPrimVez = numEstimTonHectPrimVez;
    }
    public Double getNumEstimTonAnioFiscal() {
        return this.numEstimTonAnioFiscal;
    }
    
    public void setNumEstimTonAnioFiscal(Double numEstimTonAnioFiscal) {
        this.numEstimTonAnioFiscal = numEstimTonAnioFiscal;
    }
    public Double getNumEstimTonMesAnioFiscal() {
        return this.numEstimTonMesAnioFiscal;
    }
    
    public void setNumEstimTonMesAnioFiscal(Double numEstimTonMesAnioFiscal) {
        this.numEstimTonMesAnioFiscal = numEstimTonMesAnioFiscal;
    }
    public Double getNumHectUltCosecha() {
        return this.numHectUltCosecha;
    }
    
    public void setNumHectUltCosecha(Double numHectUltCosecha) {
        this.numHectUltCosecha = numHectUltCosecha;
    }
    public Double getNumTonUltCosecha() {
        return this.numTonUltCosecha;
    }
    
    public void setNumTonUltCosecha(Double numTonUltCosecha) {
        this.numTonUltCosecha = numTonUltCosecha;
    }
    public Double getNumHectCosIndFab() {
        return this.numHectCosIndFab;
    }
    
    public void setNumHectCosIndFab(Double numHectCosIndFab) {
        this.numHectCosIndFab = numHectCosIndFab;
    }
    public Double getNumTonCosIndFab() {
        return this.numTonCosIndFab;
    }
    
    public void setNumTonCosIndFab(Double numTonCosIndFab) {
        this.numTonCosIndFab = numTonCosIndFab;
    }
    public Double getNumHectOtroDestino() {
        return this.numHectOtroDestino;
    }
    
    public void setNumHectOtroDestino(Double numHectOtroDestino) {
        this.numHectOtroDestino = numHectOtroDestino;
    }
    public Double getEdadActual() {
        return this.edadActual;
    }
    
    public void setEdadActual(Double edadActual) {
        this.edadActual = edadActual;
    }
    public Double getEdadUltimaCosecha() {
        return this.edadUltimaCosecha;
    }
    
    public void setEdadUltimaCosecha(Double edadUltimaCosecha) {
        this.edadUltimaCosecha = edadUltimaCosecha;
    }
    public String getIndiceHelada() {
        return this.indiceHelada;
    }
    
    public void setIndiceHelada(String indiceHelada) {
        this.indiceHelada = indiceHelada;
    }
    public Double getKilmNivel4Fab() {
        return this.kilmNivel4Fab;
    }
    
    public void setKilmNivel4Fab(Double kilmNivel4Fab) {
        this.kilmNivel4Fab = kilmNivel4Fab;
    }
    public Double getKilmNivel4FabPav() {
        return this.kilmNivel4FabPav;
    }
    
    public void setKilmNivel4FabPav(Double kilmNivel4FabPav) {
        this.kilmNivel4FabPav = kilmNivel4FabPav;
    }
    public Double getKilmNivel4FabTerraceria() {
        return this.kilmNivel4FabTerraceria;
    }
    
    public void setKilmNivel4FabTerraceria(Double kilmNivel4FabTerraceria) {
        this.kilmNivel4FabTerraceria = kilmNivel4FabTerraceria;
    }
    public Integer getAplicacionMadurante() {
        return this.aplicacionMadurante;
    }
    
    public void setAplicacionMadurante(Integer aplicacionMadurante) {
        this.aplicacionMadurante = aplicacionMadurante;
    }
    public Double getUltDosisAplicadaMadurante() {
        return this.ultDosisAplicadaMadurante;
    }
    
    public void setUltDosisAplicadaMadurante(Double ultDosisAplicadaMadurante) {
        this.ultDosisAplicadaMadurante = ultDosisAplicadaMadurante;
    }
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getPrecision1() {
        return this.precision1;
    }
    
    public void setPrecision1(String precision1) {
        this.precision1 = precision1;
    }
    public Long getNumComederosHect() {
        return this.numComederosHect;
    }
    
    public void setNumComederosHect(Long numComederosHect) {
        this.numComederosHect = numComederosHect;
    }
    public Long getTotalComederos() {
        return this.totalComederos;
    }
    
    public void setTotalComederos(Long totalComederos) {
        this.totalComederos = totalComederos;
    }
    public Long getNumLarvasSembradas() {
        return this.numLarvasSembradas;
    }
    
    public void setNumLarvasSembradas(Long numLarvasSembradas) {
        this.numLarvasSembradas = numLarvasSembradas;
    }
    public Double getNumRacionesCrustaceos() {
        return this.numRacionesCrustaceos;
    }
    
    public void setNumRacionesCrustaceos(Double numRacionesCrustaceos) {
        this.numRacionesCrustaceos = numRacionesCrustaceos;
    }
    public String getRenovacion() {
        return this.renovacion;
    }
    
    public void setRenovacion(String renovacion) {
        this.renovacion = renovacion;
    }
    public String getSemillero() {
        return this.semillero;
    }
    
    public void setSemillero(String semillero) {
        this.semillero = semillero;
    }
    public Date getFechaInactivo() {
        return this.fechaInactivo;
    }
    
    public void setFechaInactivo(Date fechaInactivo) {
        this.fechaInactivo = fechaInactivo;
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
    public Double getAlturaPromedioPlantas() {
        return this.alturaPromedioPlantas;
    }
    
    public void setAlturaPromedioPlantas(Double alturaPromedioPlantas) {
        this.alturaPromedioPlantas = alturaPromedioPlantas;
    }
    public Double getPesoPromedioNivel4() {
        return this.pesoPromedioNivel4;
    }
    
    public void setPesoPromedioNivel4(Double pesoPromedioNivel4) {
        this.pesoPromedioNivel4 = pesoPromedioNivel4;
    }
    public Long getCantidadValvulasRiego() {
        return this.cantidadValvulasRiego;
    }
    
    public void setCantidadValvulasRiego(Long cantidadValvulasRiego) {
        this.cantidadValvulasRiego = cantidadValvulasRiego;
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
    public Long getEspacioLineasSembradas() {
        return this.espacioLineasSembradas;
    }
    
    public void setEspacioLineasSembradas(Long espacioLineasSembradas) {
        this.espacioLineasSembradas = espacioLineasSembradas;
    }
    public String getGenerico() {
        return this.generico;
    }
    
    public void setGenerico(String generico) {
        this.generico = generico;
    }
    public String getCostosAmortizados() {
        return this.costosAmortizados;
    }
    
    public void setCostosAmortizados(String costosAmortizados) {
        this.costosAmortizados = costosAmortizados;
    }
    public Date getFechaCierreCosecha() {
        return this.fechaCierreCosecha;
    }
    
    public void setFechaCierreCosecha(Date fechaCierreCosecha) {
        this.fechaCierreCosecha = fechaCierreCosecha;
    }
    public Date getFechaAperturaCosecha() {
        return this.fechaAperturaCosecha;
    }
    
    public void setFechaAperturaCosecha(Date fechaAperturaCosecha) {
        this.fechaAperturaCosecha = fechaAperturaCosecha;
    }
    public String getFotoInfraestructura() {
        return this.fotoInfraestructura;
    }
    
    public void setFotoInfraestructura(String fotoInfraestructura) {
        this.fotoInfraestructura = fotoInfraestructura;
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
    public String getAna1() {
        return this.ana1;
    }
    
    public void setAna1(String ana1) {
        this.ana1 = ana1;
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
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getEstPluvioId() {
        return this.estPluvioId;
    }
    
    public void setEstPluvioId(Long estPluvioId) {
        this.estPluvioId = estPluvioId;
    }
    public Long getTipoDrenajeId() {
        return this.tipoDrenajeId;
    }
    
    public void setTipoDrenajeId(Long tipoDrenajeId) {
        this.tipoDrenajeId = tipoDrenajeId;
    }
    public Long getTopografiaId() {
        return this.topografiaId;
    }
    
    public void setTopografiaId(Long topografiaId) {
        this.topografiaId = topografiaId;
    }
    public Long getPersEmprId() {
        return this.persEmprId;
    }
    
    public void setPersEmprId(Long persEmprId) {
        this.persEmprId = persEmprId;
    }
    public Long getCodigoUsuarioApertura() {
        return this.codigoUsuarioApertura;
    }
    
    public void setCodigoUsuarioApertura(Long codigoUsuarioApertura) {
        this.codigoUsuarioApertura = codigoUsuarioApertura;
    }
    public Long getCodigoUsuarioCierre() {
        return this.codigoUsuarioCierre;
    }
    
    public void setCodigoUsuarioCierre(Long codigoUsuarioCierre) {
        this.codigoUsuarioCierre = codigoUsuarioCierre;
    }
    public Long getTrabId() {
        return this.trabId;
    }
    
    public void setTrabId(Long trabId) {
        this.trabId = trabId;
    }
    public Long getTipoCultivoId() {
        return this.tipoCultivoId;
    }
    
    public void setTipoCultivoId(Long tipoCultivoId) {
        this.tipoCultivoId = tipoCultivoId;
    }
    public Double getNumTonOtroDestino() {
        return this.numTonOtroDestino;
    }
    
    public void setNumTonOtroDestino(Double numTonOtroDestino) {
        this.numTonOtroDestino = numTonOtroDestino;
    }
    public Double getNumDensidadActual() {
        return this.numDensidadActual;
    }
    
    public void setNumDensidadActual(Double numDensidadActual) {
        this.numDensidadActual = numDensidadActual;
    }
    public Long getEstEvaporimetroId() {
        return this.estEvaporimetroId;
    }
    
    public void setEstEvaporimetroId(Long estEvaporimetroId) {
        this.estEvaporimetroId = estEvaporimetroId;
    }
    public Long getMadurante() {
        return this.madurante;
    }
    
    public void setMadurante(Long madurante) {
        this.madurante = madurante;
    }
    public Date getFechaAnalisisPreCosecha() {
        return this.fechaAnalisisPreCosecha;
    }
    
    public void setFechaAnalisisPreCosecha(Date fechaAnalisisPreCosecha) {
        this.fechaAnalisisPreCosecha = fechaAnalisisPreCosecha;
    }
    public Double getVariable1() {
        return this.variable1;
    }
    
    public void setVariable1(Double variable1) {
        this.variable1 = variable1;
    }
    public Double getVariable2() {
        return this.variable2;
    }
    
    public void setVariable2(Double variable2) {
        this.variable2 = variable2;
    }
    public Double getVariable3() {
        return this.variable3;
    }
    
    public void setVariable3(Double variable3) {
        this.variable3 = variable3;
    }
    public Double getVariable4() {
        return this.variable4;
    }
    
    public void setVariable4(Double variable4) {
        this.variable4 = variable4;
    }
    public Double getVariable5() {
        return this.variable5;
    }
    
    public void setVariable5(Double variable5) {
        this.variable5 = variable5;
    }




}


