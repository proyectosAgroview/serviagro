package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.AnioFiscal;
import co.com.arcosoft.modelo.ClaseTextSuelo;
import co.com.arcosoft.modelo.DistSiembra;
import co.com.arcosoft.modelo.EstClimat;
import co.com.arcosoft.modelo.EstEvaporimetro;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.FaseFenologica;
import co.com.arcosoft.modelo.FliaTextSuelo;
import co.com.arcosoft.modelo.GrpSuelo;
import co.com.arcosoft.modelo.N4Motivo;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Ocupacion;
import co.com.arcosoft.modelo.OrdenSuelo;
import co.com.arcosoft.modelo.Organizacion;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.RestrMadurante;
import co.com.arcosoft.modelo.RestrQuema;
import co.com.arcosoft.modelo.SerieSuelo;
import co.com.arcosoft.modelo.SistemaRiego;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.TipCultivo;
import co.com.arcosoft.modelo.TipoDrenaje;
import co.com.arcosoft.modelo.Topografia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.VariedadNivel4;
import co.com.arcosoft.modelo.ZonAgroec;
import co.com.arcosoft.modelo.dto.Nivel4DTO;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class Nivel4View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel4View.class);
	private InputText txtAlturaPromedioPlantas;
	private InputText txtAna1;
	private SelectOneRadio txtAplicacionMadurante;
	private InputText txtAreaBruta;
	private InputText txtAreaInutil;
	private InputText txtAreaManual;
	private InputText txtAreaMecanizada;
	private InputText txtAreaNeta;
	private InputText txtAreaOtrosCultivos;
	private InputText txtAreaReservada;
	private InputText txtAreaRestringida;
	private InputText txtCantidadValvulasRiego;
	private InputText txtCodigo;
	private InputText txtCodigoUsuarioApertura;
	private InputText txtCodigoUsuarioCierre;
	private InputText txtCompania;
	private SelectOneRadio txtCostosAmortizados;
	private InputText txtEdadActual;
	private InputText txtEdadUltimaCosecha;
	private SelectOneRadio txtEstado;
	private InputText txtFotoInfraestructura;
	private SelectOneRadio txtGenerico;
	private SelectOneRadio txtIndiceHelada;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtKilmNivel4Fab;
	private InputText txtKilmNivel4FabPav;
	private InputText txtKilmNivel4FabTerraceria;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtNombre;
	private InputText txtNumComederosHect;
	private InputText txtNumDensidadActual;
	private InputText txtNumDensidadSiembra;
	private InputText txtNumEstimTonAnioFiscal;
	private InputText txtNumEstimTonHectPrimVez;
	private InputText txtNumEstimTonMesAnioFiscal;
	private InputText txtNumHectCosIndFab;
	private InputText txtNumHectOtroDestino;
	private InputText txtNumHectUltCosecha;
	private InputText txtNumLarvasSembradas;
	private InputText txtNumLineasSembradas;
	private InputText txtNumPlantasActuales;
	private InputText txtNumPlantasSembradas;
	private InputText txtNumPlantasSembradas2;
	private InputText txtNumRacionesCrustaceos;
	private InputText txtNumTonCosIndFab;
	private InputText txtNumTonOtroDestino;
	private InputText txtMadurante;
	private InputText txtNumTonUltCosecha;
	private InputText txtPesoPromedioNivel4;
	private InputText txtPrecision;
	private SelectOneRadio txtRenovacion;
	private SelectOneRadio txtSemillero;
	private InputText txtTotalComederos;
	private InputText txtUltDosisAplicadaMadurante;
	private InputText txtNivel4Id;
	private Calendar txtFechaDescanso;
	private Calendar txtFechaAnalisisPreCosecha;
	private Calendar txtFechaAnalisisPostCosecha;
	private Calendar txtFechaAperturaCosecha;
	private Calendar txtFechaAplicacionMadurante;
	private Calendar txtFechaCierreCosecha;
	private Calendar txtFechaCorteAnterior;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaEstimadaUltimoRiego;
	private Calendar txtFechaInactivo;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaPrimerCorte;
	private Calendar txtFechaProximoCorte;
	private Calendar txtFechaSiembra;
	private Calendar txtFechaUltimoApunteRiego;
	private Calendar txtFechaUltimoCorte;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<Nivel4DTO> data;
	private Nivel4DTO selectedNivel4;
	private Nivel4 entity;
	private boolean showDialog;
	private Calendar txtFechaStart;
	private InputText txtCodigoAlternativo;

	// Select txtNivel3Id_Nivel3
	private SelectOneMenu txtNivel3Id_Nivel3;
	SelectItem[] selectItemNivel3;
	private List<Nivel3> nivel3;

	// select txtAnioFiscalId_AnioFiscal
	private SelectOneMenu txtAnioFiscalId_AnioFiscal;
	SelectItem[] selectItemAnioFiscal;
	private List<AnioFiscal> aniofiscal;

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectItemAlmacen;
	private List<Almacen> almacen;

	private SelectOneMenu txtVariedadId;
	SelectItem[] selectVariedadId;
	private List<Variedad> variedadId;

	private SelectOneMenu txtEspacioLineasSembradas;
	SelectItem[] selectDistanciaSiembra;
	private List<DistSiembra> espacioLineasSembradas;

	private SelectOneMenu txtPersEmprId_persEmpr;
	SelectItem[] selectItemPersEmpr;
	private List<PersEmpr> persEmpr;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectItemTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtTenenId_Tenencia;
	SelectItem[] selectItemTenencia;
	private List<Tenencia> tenencia;

	private SelectOneMenu txtEtapaId_Etapa;
	SelectItem[] selectItemEtapa;
	private List<Etapa> etapa;

	private SelectOneMenu txtGrupoSuelo_GrpSuelo;
	SelectItem[] selectItemGrupoSuelo;
	private List<GrpSuelo> suelo;

	private SelectOneMenu txtSerieSueloId_SerieSuelo;
	SelectItem[] selectItemSerieSuelo;
	private List<SerieSuelo> ssuelo;

	private SelectOneMenu txtOrdenSuelo_OrdenSuelo;
	SelectItem[] selectItemOrdenSuelo;
	private List<OrdenSuelo> osuelo;

	private SelectOneMenu txtFliaTextSueloId_FliaTextSuelo;
	SelectItem[] selectItemFliaTexSuelo;
	private List<FliaTextSuelo> ftsuelo;

	private SelectOneMenu txtClaseTextSueloId_ClaseTextSuelo;
	SelectItem[] selectItemClaseTexSuelo;
	private List<ClaseTextSuelo> ctsuelo;

	private SelectOneMenu txtFaseFenoId_FaseFenologica;
	SelectItem[] selectItemFaseFenologica;
	private List<FaseFenologica> ffenologica;

	private SelectOneMenu txtTipoCultivoId_TipCultivo;
	SelectItem[] selectItemTipoCultivo;
	private List<TipCultivo> tcultivo;

	private SelectOneMenu txtOcupacionId_Ocupacion;
	SelectItem[] selectItemOcupacion;
	private List<Ocupacion> ocupacion;

	private SelectOneMenu txtOrganizId_Organizacion;
	SelectItem[] selectItemOrganizacion;
	private List<Organizacion> organizacion;

	private SelectOneMenu txtTopografiaId_Topografia;
	SelectItem[] selectItemTopografia;
	private List<Topografia> topografia;

	private SelectOneMenu txtN4Mot_N4Motivo;
	SelectItem[] selectItemN4Motivo;
	private List<N4Motivo> n4motivo;

	private SelectOneMenu txtZonAgroec_ZonAgroec;
	SelectItem[] selectItemZonAgroec;
	private List<ZonAgroec> zagroec;

	private SelectOneMenu txtEstClimatId_EstClimat;
	SelectItem[] selectItemEstClimat;
	private List<EstClimat> estclimat;

	private SelectOneMenu txtEstEvaporimetroId_EstEvaporimetro;
	SelectItem[] selectItemEstEvaporimetro;
	private List<EstEvaporimetro> estEvaporimetro;

	private SelectOneMenu txtEstPluvioId_EstPluvio;
	SelectItem[] selectItemEstPluvio;
	private List<EstPluvio> estPluvio;

	private SelectOneMenu txtSistemaRiegoId_SistemaRiego;
	SelectItem[] selectSistemaRiego;
	private List<SistemaRiego> sistemaRiego;

	private SelectOneMenu txtTipoDrenajeId_TipoDrenaje;
	SelectItem[] selectItemTipoDrenaje;
	private List<TipoDrenaje> tipoDrenaje;

	private List<String> restriccionDeQuema;
	private List<RestrQuema> selectItemRestriccionQuema;

	private List<String> restriccionDeMadurante;
	private List<RestrMadurante> selectItemRestriccionMadurante;

	/* VariedadNivel4 del cultivo */

	private SelectOneMenu txtVaiedadId_VariedadId;
	SelectItem[] selectItemVariedad;
	private List<Variedad> variedad;

	private List<VariedadNivel4DTO> dataVariedad;
	private VariedadNivel4DTO selectedVariedad;
	private InputText txtPorcentajeArea;
	private CommandButton btnAgregar;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private MapModel simpleModel;

	private Marker marker;

	private InputText txtNombreVariedad;

	private InputText txtVacunosIniciales;
	private InputText txtVacunosActuales;
	private int activeTapIndex = 0;

	private InputText txtNumTonHaUltCosecha;
	private InputText txtNumTonHaMesUltCosecha;
	
	public Nivel4View() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			Nivel4DTO nivel4DTO = (Nivel4DTO) e.getObject();

			if (txtAlturaPromedioPlantas == null) {
				txtAlturaPromedioPlantas = new InputText();
			}

			txtAlturaPromedioPlantas.setValue(nivel4DTO.getAlturaPromedioPlantas());

			if (txtAna1 == null) {
				txtAna1 = new InputText();
			}

			txtAna1.setValue(nivel4DTO.getAna1());

			if (txtAplicacionMadurante == null) {
				txtAplicacionMadurante = new SelectOneRadio();
			}

			txtAplicacionMadurante.setValue(nivel4DTO.getAplicacionMadurante());

			if (txtFechaDescanso == null) {
				txtFechaDescanso = new Calendar();
			}

			txtFechaDescanso.setValue(nivel4DTO.getFechaDescanso());

			if (txtSistemaRiegoId_SistemaRiego == null) {
				txtSistemaRiegoId_SistemaRiego = new SelectOneMenu();
			}

			txtSistemaRiegoId_SistemaRiego.setValue(nivel4DTO.getSistemaRiego());

			if (txtAreaBruta == null) {
				txtAreaBruta = new InputText();
			}

			txtAreaBruta.setValue(nivel4DTO.getAreaBruta());

			if (txtVariedadId == null) {
				txtVariedadId = new SelectOneMenu();
			}

			txtVariedadId.setValue(nivel4DTO.getVariedad());

			if (txtAreaInutil == null) {
				txtAreaInutil = new InputText();
			}

			txtAreaInutil.setValue(nivel4DTO.getAreaInutil());

			if (txtAreaManual == null) {
				txtAreaManual = new InputText();
			}

			txtAreaManual.setValue(nivel4DTO.getAreaManual());

			if (txtAreaMecanizada == null) {
				txtAreaMecanizada = new InputText();
			}

			txtAreaMecanizada.setValue(nivel4DTO.getAreaMecanizada());

			if (txtAreaNeta == null) {
				txtAreaNeta = new InputText();
			}

			txtAreaNeta.setValue(nivel4DTO.getAreaNeta());

			if (txtAreaOtrosCultivos == null) {
				txtAreaOtrosCultivos = new InputText();
			}

			txtAreaOtrosCultivos.setValue(nivel4DTO.getAreaOtrosCultivos());

			if (txtAreaReservada == null) {
				txtAreaReservada = new InputText();
			}

			txtAreaReservada.setValue(nivel4DTO.getAreaReservada());

			if (txtAreaRestringida == null) {
				txtAreaRestringida = new InputText();
			}

			txtAreaRestringida.setValue(nivel4DTO.getAreaRestringida());

			if (txtCantidadValvulasRiego == null) {
				txtCantidadValvulasRiego = new InputText();
			}

			txtCantidadValvulasRiego.setValue(nivel4DTO.getCantidadValvulasRiego());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(nivel4DTO.getCodigo());

			if (txtCodigoUsuarioApertura == null) {
				txtCodigoUsuarioApertura = new InputText();
			}

			txtCodigoUsuarioApertura.setValue(nivel4DTO.getCodigoUsuarioApertura());

			if (txtCodigoUsuarioCierre == null) {
				txtCodigoUsuarioCierre = new InputText();
			}

			txtCodigoUsuarioCierre.setValue(nivel4DTO.getCodigoUsuarioCierre());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(nivel4DTO.getCompania());

			if (txtCostosAmortizados == null) {
				txtCostosAmortizados = new SelectOneRadio();
			}

			txtCostosAmortizados.setValue(nivel4DTO.getCostosAmortizados());

			if (txtEdadActual == null) {
				txtEdadActual = new InputText();
			}

			txtEdadActual.setValue(nivel4DTO.getEdadActual());

			if (txtEdadUltimaCosecha == null) {
				txtEdadUltimaCosecha = new InputText();
			}

			txtEdadUltimaCosecha.setValue(nivel4DTO.getEdadUltimaCosecha());

			if (txtEspacioLineasSembradas == null) {
				txtEspacioLineasSembradas = new SelectOneMenu();
			}

			txtEspacioLineasSembradas.setValue(nivel4DTO.getEspacioLineasSembradas());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(nivel4DTO.getEstado());

			if (txtFechaAnalisisPreCosecha == null) {
				txtFechaAnalisisPreCosecha = new Calendar();
			}

			txtFechaAnalisisPreCosecha.setValue(nivel4DTO.getFechaAnalisisPreCosecha());

			if (txtFotoInfraestructura == null) {
				txtFotoInfraestructura = new InputText();
			}

			txtFotoInfraestructura.setValue(nivel4DTO.getFotoInfraestructura());

			if (txtGenerico == null) {
				txtGenerico = new SelectOneRadio();
			}

			txtGenerico.setValue(nivel4DTO.getGenerico());

			if (txtIndiceHelada == null) {
				txtIndiceHelada = new SelectOneRadio();
			}

			txtIndiceHelada.setValue(nivel4DTO.getIndiceHelada());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(nivel4DTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(nivel4DTO.getInfoAdicional2());

			if (txtKilmNivel4Fab == null) {
				txtKilmNivel4Fab = new InputText();
			}

			txtKilmNivel4Fab.setValue(nivel4DTO.getKilmNivel4Fab());

			if (txtKilmNivel4FabPav == null) {
				txtKilmNivel4FabPav = new InputText();
			}

			txtKilmNivel4FabPav.setValue(nivel4DTO.getKilmNivel4FabPav());

			if (txtKilmNivel4FabTerraceria == null) {
				txtKilmNivel4FabTerraceria = new InputText();
			}

			txtKilmNivel4FabTerraceria.setValue(nivel4DTO.getKilmNivel4FabTerraceria());

			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(nivel4DTO.getLatitud());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(nivel4DTO.getLongitud());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(nivel4DTO.getNombre());

			if (txtNumComederosHect == null) {
				txtNumComederosHect = new InputText();
			}

			txtNumComederosHect.setValue(nivel4DTO.getNumComederosHect());

			if (txtNumDensidadActual == null) {
				txtNumDensidadActual = new InputText();
			}

			txtNumDensidadActual.setValue(nivel4DTO.getNumDensidadActual());

			if (txtNumDensidadSiembra == null) {
				txtNumDensidadSiembra = new InputText();
			}

			txtNumDensidadSiembra.setValue(nivel4DTO.getNumDensidadSiembra());

			if (txtNumEstimTonAnioFiscal == null) {
				txtNumEstimTonAnioFiscal = new InputText();
			}

			txtNumEstimTonAnioFiscal.setValue(nivel4DTO.getNumEstimTonAnioFiscal());

			if (txtNumEstimTonHectPrimVez == null) {
				txtNumEstimTonHectPrimVez = new InputText();
			}

			txtNumEstimTonHectPrimVez.setValue(nivel4DTO.getNumEstimTonHectPrimVez());

			if (txtNumEstimTonMesAnioFiscal == null) {
				txtNumEstimTonMesAnioFiscal = new InputText();
			}

			txtNumEstimTonMesAnioFiscal.setValue(nivel4DTO.getNumEstimTonMesAnioFiscal());

			if (txtNumHectCosIndFab == null) {
				txtNumHectCosIndFab = new InputText();
			}

			txtNumHectCosIndFab.setValue(nivel4DTO.getNumHectCosIndFab());

			if (txtNumHectOtroDestino == null) {
				txtNumHectOtroDestino = new InputText();
			}

			txtNumHectOtroDestino.setValue(nivel4DTO.getNumHectOtroDestino());

			if (txtNumHectUltCosecha == null) {
				txtNumHectUltCosecha = new InputText();
			}

			txtNumHectUltCosecha.setValue(nivel4DTO.getNumHectUltCosecha());

			if (txtNumLarvasSembradas == null) {
				txtNumLarvasSembradas = new InputText();
			}

			txtNumLarvasSembradas.setValue(nivel4DTO.getNumLarvasSembradas());

			if (txtNumLineasSembradas == null) {
				txtNumLineasSembradas = new InputText();
			}

			txtNumLineasSembradas.setValue(nivel4DTO.getNumLineasSembradas());

			if (txtNumPlantasActuales == null) {
				txtNumPlantasActuales = new InputText();
			}

			txtNumPlantasActuales.setValue(nivel4DTO.getNumPlantasActuales());

			if (txtNumPlantasSembradas == null) {
				txtNumPlantasSembradas = new InputText();
			}

			txtNumPlantasSembradas.setValue(nivel4DTO.getNumPlantasSembradas());

			if (txtNumPlantasSembradas2 == null) {
				txtNumPlantasSembradas2 = new InputText();
			}

			txtNumPlantasSembradas2.setValue(nivel4DTO.getNumPlantasSembradas2());

			if (txtNumRacionesCrustaceos == null) {
				txtNumRacionesCrustaceos = new InputText();
			}

			txtNumRacionesCrustaceos.setValue(nivel4DTO.getNumRacionesCrustaceos());

			if (txtNumTonCosIndFab == null) {
				txtNumTonCosIndFab = new InputText();
			}

			txtNumTonCosIndFab.setValue(nivel4DTO.getNumTonCosIndFab());

			if (txtNumTonOtroDestino == null) {
				txtNumTonOtroDestino = new InputText();
			}

			txtNumTonOtroDestino.setValue(nivel4DTO.getNumTonOtroDestino());

			if (txtNumTonUltCosecha == null) {
				txtNumTonUltCosecha = new InputText();
			}

			txtNumTonUltCosecha.setValue(nivel4DTO.getNumTonUltCosecha());

			if (txtPesoPromedioNivel4 == null) {
				txtPesoPromedioNivel4 = new InputText();
			}

			txtPesoPromedioNivel4.setValue(nivel4DTO.getPesoPromedioNivel4());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(nivel4DTO.getPrecision());

			if (txtRenovacion == null) {
				txtRenovacion = new SelectOneRadio();
			}

			txtRenovacion.setValue(nivel4DTO.getRenovacion());

			if (txtSemillero == null) {
				txtSemillero = new SelectOneRadio();
			}

			txtSemillero.setValue(nivel4DTO.getSemillero());

			if (txtTotalComederos == null) {
				txtTotalComederos = new InputText();
			}

			txtTotalComederos.setValue(nivel4DTO.getTotalComederos());

			if (txtUltDosisAplicadaMadurante == null) {
				txtUltDosisAplicadaMadurante = new InputText();
			}

			txtUltDosisAplicadaMadurante.setValue(nivel4DTO.getUltDosisAplicadaMadurante());

			if (txtAlmacenId_Almacen == null) {
				txtAlmacenId_Almacen = new SelectOneMenu();
			}

			txtAlmacenId_Almacen.setValue(nivel4DTO.getAlmacenId_Almacen());

			if (txtAnioFiscalId_AnioFiscal == null) {
				txtAnioFiscalId_AnioFiscal = new SelectOneMenu();
			}

			txtAnioFiscalId_AnioFiscal.setValue(nivel4DTO.getAnioFiscalId_AnioFiscal());

			if (txtClaseTextSueloId_ClaseTextSuelo == null) {
				txtClaseTextSueloId_ClaseTextSuelo = new SelectOneMenu();
			}

			txtClaseTextSueloId_ClaseTextSuelo.setValue(nivel4DTO.getClaseTextSueloId_ClaseTextSuelo());

			if (txtEstClimatId_EstClimat == null) {
				txtEstClimatId_EstClimat = new SelectOneMenu();
			}

			txtEstClimatId_EstClimat.setValue(nivel4DTO.getEstClimatId_EstClimat());

			if (txtEstEvaporimetroId_EstEvaporimetro == null) {
				txtEstEvaporimetroId_EstEvaporimetro = new SelectOneMenu();
			}

			txtEstEvaporimetroId_EstEvaporimetro.setValue(nivel4DTO.getEstEvaporimetroId_EstEvaporimetro());

			if (txtEstPluvioId_EstPluvio == null) {
				txtEstPluvioId_EstPluvio = new SelectOneMenu();
			}

			txtEstPluvioId_EstPluvio.setValue(nivel4DTO.getEstPluvioId_EstPluvio());

			if (txtEtapaId_Etapa == null) {
				txtEtapaId_Etapa = new SelectOneMenu();
			}

			txtEtapaId_Etapa.setValue(nivel4DTO.getEtapaId_Etapa());

			if (txtFaseFenoId_FaseFenologica == null) {
				txtFaseFenoId_FaseFenologica = new SelectOneMenu();
			}

			txtFaseFenoId_FaseFenologica.setValue(nivel4DTO.getFaseFenoId_FaseFenologica());

			if (txtFliaTextSueloId_FliaTextSuelo == null) {
				txtFliaTextSueloId_FliaTextSuelo = new SelectOneMenu();
			}

			txtFliaTextSueloId_FliaTextSuelo.setValue(nivel4DTO.getFliaTextSueloId_FliaTextSuelo());

			if (txtGrupoSuelo_GrpSuelo == null) {
				txtGrupoSuelo_GrpSuelo = new SelectOneMenu();
			}

			txtGrupoSuelo_GrpSuelo.setValue(nivel4DTO.getGrupoSuelo_GrpSuelo());

			if (txtN4Mot_N4Motivo == null) {
				txtN4Mot_N4Motivo = new SelectOneMenu();
			}

			txtN4Mot_N4Motivo.setValue(nivel4DTO.getN4Mot_N4Motivo());

			if (txtNivel3Id_Nivel3 == null) {
				txtNivel3Id_Nivel3 = new SelectOneMenu();
			}

			txtNivel3Id_Nivel3.setValue(nivel4DTO.getNivel3Id_Nivel3());

			if (txtOcupacionId_Ocupacion == null) {
				txtOcupacionId_Ocupacion = new SelectOneMenu();
			}

			txtOcupacionId_Ocupacion.setValue(nivel4DTO.getOcupacionId_Ocupacion());

			if (txtOrdenSuelo_OrdenSuelo == null) {
				txtOrdenSuelo_OrdenSuelo = new SelectOneMenu();
			}

			txtOrdenSuelo_OrdenSuelo.setValue(nivel4DTO.getOrdenSuelo_OrdenSuelo());

			if (txtOrganizId_Organizacion == null) {
				txtOrganizId_Organizacion = new SelectOneMenu();
			}

			txtOrganizId_Organizacion.setValue(nivel4DTO.getOrganizId_Organizacion());

			if (txtPersEmprId_persEmpr == null) {
				txtPersEmprId_persEmpr = new SelectOneMenu();
			}

			txtPersEmprId_persEmpr.setValue(nivel4DTO.getPersEmprId_persEmpr());

			if (txtSerieSueloId_SerieSuelo == null) {
				txtSerieSueloId_SerieSuelo = new SelectOneMenu();
			}

			txtSerieSueloId_SerieSuelo.setValue(nivel4DTO.getSerieSueloId_SerieSuelo());

			if (txtTenenId_Tenencia == null) {
				txtTenenId_Tenencia = new SelectOneMenu();
			}

			txtTenenId_Tenencia.setValue(nivel4DTO.getTenenId_Tenencia());

			if (txtTipoCultivoId_TipCultivo == null) {
				txtTipoCultivoId_TipCultivo = new SelectOneMenu();
			}

			txtTipoCultivoId_TipCultivo.setValue(nivel4DTO.getTipoCultivoId_TipCultivo());

			if (txtTipoDrenajeId_TipoDrenaje == null) {
				txtTipoDrenajeId_TipoDrenaje = new SelectOneMenu();
			}

			txtTipoDrenajeId_TipoDrenaje.setValue(nivel4DTO.getTipoDrenajeId_TipoDrenaje());

			if (txtTopografiaId_Topografia == null) {
				txtTopografiaId_Topografia = new SelectOneMenu();
			}

			txtTopografiaId_Topografia.setValue(nivel4DTO.getTopografiaId_Topografia());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(nivel4DTO.getTrabId_Trabajador());

			if (txtZonAgroec_ZonAgroec == null) {
				txtZonAgroec_ZonAgroec = new SelectOneMenu();
			}

			txtZonAgroec_ZonAgroec.setValue(nivel4DTO.getZonAgroec_ZonAgroec());

			if (txtNivel4Id == null) {
				txtNivel4Id = new InputText();
			}

			txtNivel4Id.setValue(nivel4DTO.getNivel4Id());

			if (txtFechaAnalisisPostCosecha == null) {
				txtFechaAnalisisPostCosecha = new Calendar();
			}

			txtFechaAnalisisPostCosecha.setValue(nivel4DTO.getFechaAnalisisPostCosecha());

			if (txtFechaAperturaCosecha == null) {
				txtFechaAperturaCosecha = new Calendar();
			}

			txtFechaAperturaCosecha.setValue(nivel4DTO.getFechaAperturaCosecha());

			if (txtFechaAplicacionMadurante == null) {
				txtFechaAplicacionMadurante = new Calendar();
			}

			txtFechaAplicacionMadurante.setValue(nivel4DTO.getFechaAplicacionMadurante());

			if (txtFechaCierreCosecha == null) {
				txtFechaCierreCosecha = new Calendar();
			}

			txtFechaCierreCosecha.setValue(nivel4DTO.getFechaCierreCosecha());

			if (txtFechaCorteAnterior == null) {
				txtFechaCorteAnterior = new Calendar();
			}

			txtFechaCorteAnterior.setValue(nivel4DTO.getFechaCorteAnterior());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(nivel4DTO.getFechaCreacion());

			if (txtFechaEstimadaUltimoRiego == null) {
				txtFechaEstimadaUltimoRiego = new Calendar();
			}

			txtFechaEstimadaUltimoRiego.setValue(nivel4DTO.getFechaEstimadaUltimoRiego());

			if (txtFechaInactivo == null) {
				txtFechaInactivo = new Calendar();
			}

			txtFechaInactivo.setValue(nivel4DTO.getFechaInactivo());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(nivel4DTO.getFechaModificacion());

			if (txtFechaPrimerCorte == null) {
				txtFechaPrimerCorte = new Calendar();
			}

			txtFechaPrimerCorte.setValue(nivel4DTO.getFechaPrimerCorte());

			if (txtFechaProximoCorte == null) {
				txtFechaProximoCorte = new Calendar();
			}

			txtFechaProximoCorte.setValue(nivel4DTO.getFechaProximoCorte());

			if (txtFechaSiembra == null) {
				txtFechaSiembra = new Calendar();
			}

			txtFechaSiembra.setValue(nivel4DTO.getFechaSiembra());

			if (txtFechaUltimoApunteRiego == null) {
				txtFechaUltimoApunteRiego = new Calendar();
			}

			txtFechaUltimoApunteRiego.setValue(nivel4DTO.getFechaUltimoApunteRiego());

			if (txtFechaUltimoCorte == null) {
				txtFechaUltimoCorte = new Calendar();
			}

			txtFechaUltimoCorte.setValue(nivel4DTO.getFechaUltimoCorte());

			Long nivel4Id = FacesUtils.checkLong(txtNivel4Id);
			entity = businessDelegatorView.getNivel4(nivel4Id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedNivel4 = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedNivel4 = null;
		restriccionDeQuema = null;
		restriccionDeMadurante = null;
		dataVariedad = null;
		PrimeFaces.current().resetInputs(":dialogNivel4 :frm");
		activeTapIndex = 0;

		if (txtAlturaPromedioPlantas != null) {
			txtAlturaPromedioPlantas.setValue(null);
			txtAlturaPromedioPlantas.setDisabled(true);
		}

		
		
		/*
		 * if (txtNombreVariedad != null) { txtNombreVariedad.setValue(null);
		 * txtNombreVariedad.setDisabled(true);}
		 */

		if (txtCodigoAlternativo != null) {
			txtCodigoAlternativo.setValue(null);
			txtCodigoAlternativo.setDisabled(true);
		}

		if (txtVariedadId != null) {
			txtVariedadId.setValue(null);
			txtVariedadId.setDisabled(true);
		}
		if (txtAna1 != null) {
			txtAna1.setValue(null);
			txtAna1.setDisabled(true);
		}

		if (txtAplicacionMadurante != null) {
			txtAplicacionMadurante.setValue(null);
			txtAplicacionMadurante.setDisabled(true);
		}

		if (txtSistemaRiegoId_SistemaRiego != null) {
			txtSistemaRiegoId_SistemaRiego.setValue(null);
			txtSistemaRiegoId_SistemaRiego.setDisabled(true);
		}

		if (txtFechaDescanso != null) {
			txtFechaDescanso.setValue(null);
			txtFechaDescanso.setDisabled(true);
		}

		if (txtAreaBruta != null) {
			txtAreaBruta.setValue(0.0);
			txtAreaBruta.setDisabled(true);
		}

		if (txtAreaInutil != null) {
			txtAreaInutil.setValue(0.0);
			txtAreaInutil.setDisabled(true);
		}

		if (txtAreaManual != null) {
			txtAreaManual.setValue(0.0);
			txtAreaManual.setDisabled(true);
		}

		if (txtAreaMecanizada != null) {
			txtAreaMecanizada.setValue(0.0);
			txtAreaMecanizada.setDisabled(true);
		}

		if (txtAreaNeta != null) {
			txtAreaNeta.setValue(0.0);
			txtAreaNeta.setDisabled(false);
		}

		if (txtAreaOtrosCultivos != null) {
			txtAreaOtrosCultivos.setValue(0.0);
			txtAreaOtrosCultivos.setDisabled(true);
		}

		if (txtAreaReservada != null) {
			txtAreaReservada.setValue(0.0);
			txtAreaReservada.setDisabled(true);
		}

		if (txtAreaRestringida != null) {
			txtAreaRestringida.setValue(0.0);
			txtAreaRestringida.setDisabled(true);
		}

		if (txtCantidadValvulasRiego != null) {
			txtCantidadValvulasRiego.setValue(null);
			txtCantidadValvulasRiego.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCodigoUsuarioApertura != null) {
			txtCodigoUsuarioApertura.setValue(null);
			txtCodigoUsuarioApertura.setDisabled(true);
		}

		if (txtCodigoUsuarioCierre != null) {
			txtCodigoUsuarioCierre.setValue(null);
			txtCodigoUsuarioCierre.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtCostosAmortizados != null) {
			txtCostosAmortizados.setValue(null);
			txtCostosAmortizados.setDisabled(true);
		}

		if (txtEdadActual != null) {
			txtEdadActual.setValue(null);
			txtEdadActual.setDisabled(true);
		}

		if (txtEdadUltimaCosecha != null) {
			txtEdadUltimaCosecha.setValue(null);
			txtEdadUltimaCosecha.setDisabled(true);
		}

		if (txtEspacioLineasSembradas != null) {
			txtEspacioLineasSembradas.setValue(null);
			txtEspacioLineasSembradas.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFechaAnalisisPreCosecha != null) {
			txtFechaAnalisisPreCosecha.setValue(null);
			txtFechaAnalisisPreCosecha.setDisabled(true);
		}

		if (txtFotoInfraestructura != null) {
			txtFotoInfraestructura.setValue(null);
			txtFotoInfraestructura.setDisabled(true);
		}

		if (txtGenerico != null) {
			txtGenerico.setValue(null);
			txtGenerico.setDisabled(true);
		}

		if (txtIndiceHelada != null) {
			txtIndiceHelada.setValue(null);
			txtIndiceHelada.setDisabled(true);
		}

		if (txtKilmNivel4Fab != null) {
			txtKilmNivel4Fab.setValue(null);
			txtKilmNivel4Fab.setDisabled(true);
		}

		if (txtKilmNivel4FabPav != null) {
			txtKilmNivel4FabPav.setValue(null);
			txtKilmNivel4FabPav.setDisabled(true);
		}

		if (txtKilmNivel4FabTerraceria != null) {
			txtKilmNivel4FabTerraceria.setValue(null);
			txtKilmNivel4FabTerraceria.setDisabled(true);
		}

		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtNumComederosHect != null) {
			txtNumComederosHect.setValue(0);
			txtNumComederosHect.setDisabled(true);
		}

		if (txtNumDensidadActual != null) {
			txtNumDensidadActual.setValue(0);
			txtNumDensidadActual.setDisabled(true);
		}

		if (txtNumDensidadSiembra != null) {
			txtNumDensidadSiembra.setValue(0);
			txtNumDensidadSiembra.setDisabled(true);
		}

		if (txtMadurante != null) {
			txtMadurante.setValue(null);
			txtMadurante.setDisabled(true);
		}

		if (txtNumEstimTonAnioFiscal != null) {
			txtNumEstimTonAnioFiscal.setValue(0);
			txtNumEstimTonAnioFiscal.setDisabled(true);
		}

		if (txtNumEstimTonHectPrimVez != null) {
			txtNumEstimTonHectPrimVez.setValue(0);
			txtNumEstimTonHectPrimVez.setDisabled(true);
		}

		if (txtNumEstimTonMesAnioFiscal != null) {
			txtNumEstimTonMesAnioFiscal.setValue(0);
			txtNumEstimTonMesAnioFiscal.setDisabled(true);
		}

		if (txtNumHectCosIndFab != null) {
			txtNumHectCosIndFab.setValue(0);
			txtNumHectCosIndFab.setDisabled(true);
		}

		if (txtNumHectOtroDestino != null) {
			txtNumHectOtroDestino.setValue(0);
			txtNumHectOtroDestino.setDisabled(true);
		}

		if (txtNumHectUltCosecha != null) {
			txtNumHectUltCosecha.setValue(0);
			txtNumHectUltCosecha.setDisabled(true);
		}

		if (txtNumLarvasSembradas != null) {
			txtNumLarvasSembradas.setValue(0);
			txtNumLarvasSembradas.setDisabled(true);
		}

		if (txtNumLineasSembradas != null) {
			txtNumLineasSembradas.setValue(0);
			txtNumLineasSembradas.setDisabled(true);
		}

		if (txtNumPlantasActuales != null) {
			txtNumPlantasActuales.setValue(0);
			txtNumPlantasActuales.setDisabled(true);
		}

		if (txtNumPlantasSembradas != null) {
			txtNumPlantasSembradas.setValue(0);
			txtNumPlantasSembradas.setDisabled(true);
		}

		if (txtNumPlantasSembradas2 != null) {
			txtNumPlantasSembradas2.setValue(0);
			txtNumPlantasSembradas2.setDisabled(true);
		}

		if (txtNumRacionesCrustaceos != null) {
			txtNumRacionesCrustaceos.setValue(0);
			txtNumRacionesCrustaceos.setDisabled(true);
		}

		if (txtNumTonCosIndFab != null) {
			txtNumTonCosIndFab.setValue(0);
			txtNumTonCosIndFab.setDisabled(true);
		}

		if (txtNumTonOtroDestino != null) {
			txtNumTonOtroDestino.setValue(0);
			txtNumTonOtroDestino.setDisabled(true);
		}

		if (txtNumTonUltCosecha != null) {
			txtNumTonUltCosecha.setValue(0);
			txtNumTonUltCosecha.setDisabled(true);
		}

		if (txtPesoPromedioNivel4 != null) {
			txtPesoPromedioNivel4.setValue(0);
			txtPesoPromedioNivel4.setDisabled(true);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtRenovacion != null) {
			txtRenovacion.setValue(null);
			txtRenovacion.setDisabled(true);
		}

		if (txtSemillero != null) {
			txtSemillero.setValue(null);
			txtSemillero.setDisabled(true);
		}

		if (txtTotalComederos != null) {
			txtTotalComederos.setValue(0);
			txtTotalComederos.setDisabled(true);
		}

		if (txtUltDosisAplicadaMadurante != null) {
			txtUltDosisAplicadaMadurante.setValue(null);
			txtUltDosisAplicadaMadurante.setDisabled(true);
		}

		if (txtAlmacenId_Almacen != null) {
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(true);
		}

		/*
		 * if (txtAnioFiscalId_AnioFiscal != null) {
		 * txtAnioFiscalId_AnioFiscal.setValue(null);
		 * txtAnioFiscalId_AnioFiscal.setDisabled(true); }
		 */
		if (txtClaseTextSueloId_ClaseTextSuelo != null) {
			txtClaseTextSueloId_ClaseTextSuelo.setValue(null);
			txtClaseTextSueloId_ClaseTextSuelo.setDisabled(true);
		}

		if (txtEstClimatId_EstClimat != null) {
			txtEstClimatId_EstClimat.setValue(null);
			txtEstClimatId_EstClimat.setDisabled(true);
		}

		if (txtEstEvaporimetroId_EstEvaporimetro != null) {
			txtEstEvaporimetroId_EstEvaporimetro.setValue(null);
			txtEstEvaporimetroId_EstEvaporimetro.setDisabled(true);
		}

		if (txtEstPluvioId_EstPluvio != null) {
			txtEstPluvioId_EstPluvio.setValue(null);
			txtEstPluvioId_EstPluvio.setDisabled(true);
		}

		if (txtEtapaId_Etapa != null) {
			txtEtapaId_Etapa.setValue(null);
			txtEtapaId_Etapa.setDisabled(true);
		}

		if (txtFaseFenoId_FaseFenologica != null) {
			txtFaseFenoId_FaseFenologica.setValue(null);
			txtFaseFenoId_FaseFenologica.setDisabled(true);
		}

		if (txtFliaTextSueloId_FliaTextSuelo != null) {
			txtFliaTextSueloId_FliaTextSuelo.setValue(null);
			txtFliaTextSueloId_FliaTextSuelo.setDisabled(true);
		}

		if (txtGrupoSuelo_GrpSuelo != null) {
			txtGrupoSuelo_GrpSuelo.setValue(null);
			txtGrupoSuelo_GrpSuelo.setDisabled(true);
		}

		if (txtN4Mot_N4Motivo != null) {
			txtN4Mot_N4Motivo.setValue(null);
			txtN4Mot_N4Motivo.setDisabled(true);
		}

		if (txtNivel3Id_Nivel3 != null) {
			txtNivel3Id_Nivel3.setValue(null);
			txtNivel3Id_Nivel3.setDisabled(true);
		}

		if (txtOcupacionId_Ocupacion != null) {
			txtOcupacionId_Ocupacion.setValue(null);
			txtOcupacionId_Ocupacion.setDisabled(true);
		}

		if (txtOrdenSuelo_OrdenSuelo != null) {
			txtOrdenSuelo_OrdenSuelo.setValue(null);
			txtOrdenSuelo_OrdenSuelo.setDisabled(true);
		}

		if (txtOrganizId_Organizacion != null) {
			txtOrganizId_Organizacion.setValue(null);
			txtOrganizId_Organizacion.setDisabled(true);
		}
		/*
		 * if (txtPersEmprId_persEmpr != null) {
		 * txtPersEmprId_persEmpr.setValue(null);
		 * txtPersEmprId_persEmpr.setDisabled(true); }
		 */
		if (txtSerieSueloId_SerieSuelo != null) {
			txtSerieSueloId_SerieSuelo.setValue(null);
			txtSerieSueloId_SerieSuelo.setDisabled(true);
		}

		if (txtTenenId_Tenencia != null) {
			txtTenenId_Tenencia.setValue(null);
			txtTenenId_Tenencia.setDisabled(true);
		}

		if (txtTipoCultivoId_TipCultivo != null) {
			txtTipoCultivoId_TipCultivo.setValue(null);
			txtTipoCultivoId_TipCultivo.setDisabled(true);
		}

		if (txtTipoDrenajeId_TipoDrenaje != null) {
			txtTipoDrenajeId_TipoDrenaje.setValue(null);
			txtTipoDrenajeId_TipoDrenaje.setDisabled(true);
		}

		if (txtTopografiaId_Topografia != null) {
			txtTopografiaId_Topografia.setValue(null);
			txtTopografiaId_Topografia.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
		}

		if (txtZonAgroec_ZonAgroec != null) {
			txtZonAgroec_ZonAgroec.setValue(null);
			txtZonAgroec_ZonAgroec.setDisabled(true);
		}

		if (txtFechaAnalisisPostCosecha != null) {
			txtFechaAnalisisPostCosecha.setValue(null);
			txtFechaAnalisisPostCosecha.setDisabled(true);
		}

		if (txtFechaAperturaCosecha != null) {
			txtFechaAperturaCosecha.setValue(null);
			txtFechaAperturaCosecha.setDisabled(true);
		}

		if (txtFechaAplicacionMadurante != null) {
			txtFechaAplicacionMadurante.setValue(null);
			txtFechaAplicacionMadurante.setDisabled(true);
		}

		if (txtFechaCierreCosecha != null) {
			txtFechaCierreCosecha.setValue(null);
			txtFechaCierreCosecha.setDisabled(true);
		}

		if (txtFechaCorteAnterior != null) {
			txtFechaCorteAnterior.setValue(null);
			txtFechaCorteAnterior.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaEstimadaUltimoRiego != null) {
			txtFechaEstimadaUltimoRiego.setValue(null);
			txtFechaEstimadaUltimoRiego.setDisabled(true);
		}

		if (txtFechaInactivo != null) {
			txtFechaInactivo.setValue(null);
			txtFechaInactivo.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaPrimerCorte != null) {
			txtFechaPrimerCorte.setValue(null);
			txtFechaPrimerCorte.setDisabled(true);
		}

		if (txtFechaProximoCorte != null) {
			txtFechaProximoCorte.setValue(null);
			txtFechaProximoCorte.setDisabled(true);
		}

		if (txtFechaSiembra != null) {
			txtFechaSiembra.setValue(null);
			txtFechaSiembra.setDisabled(true);
		}

		if (txtFechaUltimoApunteRiego != null) {
			txtFechaUltimoApunteRiego.setValue(null);
			txtFechaUltimoApunteRiego.setDisabled(true);
		}

		if (txtFechaUltimoCorte != null) {
			txtFechaUltimoCorte.setValue(null);
			txtFechaUltimoCorte.setDisabled(true);
		}

		if (txtNivel4Id != null) {
			txtNivel4Id.setValue(null);
			txtNivel4Id.setDisabled(false);
		}

		if (txtPorcentajeArea != null) {
			txtPorcentajeArea.setValue(null);
			txtPorcentajeArea.setDisabled(false);
		}

		if (txtVaiedadId_VariedadId != null) {
			txtVaiedadId_VariedadId.setValue(null);
			txtVaiedadId_VariedadId.setDisabled(true);

		}

		if (txtFechaStart != null) {
			txtFechaStart.setValue(null);
			txtFechaStart.setDisabled(true);
		}

		if (txtVacunosActuales != null) {
			txtVacunosActuales.setValue(0);
			txtVacunosActuales.setDisabled(true);
		}

		if (txtVacunosIniciales != null) {
			txtVacunosIniciales.setValue(0);
			txtVacunosIniciales.setDisabled(true);
		}

		if (txtNumTonHaUltCosecha != null) {
			txtNumTonHaUltCosecha.setValue(0);
			txtNumTonHaUltCosecha.setDisabled(true);
		}

		if (txtNumTonHaMesUltCosecha != null) {
			txtNumTonHaMesUltCosecha.setValue(0);
			txtNumTonHaMesUltCosecha.setDisabled(true);
		}

		
		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaAnalisisPreCosecha() {
		Date inputDate = (Date) txtFechaAnalisisPreCosecha.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaAnalisisPostCosecha() {
		Date inputDate = (Date) txtFechaAnalisisPostCosecha.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaAperturaCosecha() {
		Date inputDate = (Date) txtFechaAperturaCosecha.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaAplicacionMadurante() {
		Date inputDate = (Date) txtFechaAplicacionMadurante.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCierreCosecha() {
		Date inputDate = (Date) txtFechaCierreCosecha.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCorteAnterior() {
		Date inputDate = (Date) txtFechaCorteAnterior.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaEstimadaUltimoRiego() {
		Date inputDate = (Date) txtFechaEstimadaUltimoRiego.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInactivo() {
		Date inputDate = (Date) txtFechaInactivo.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaPrimerCorte() {
		Date inputDate = (Date) txtFechaPrimerCorte.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaProximoCorte() {
		Date inputDate = (Date) txtFechaProximoCorte.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaSiembra() {
		Date inputDate = (Date) txtFechaSiembra.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaUltimoApunteRiego() {
		Date inputDate = (Date) txtFechaUltimoApunteRiego.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaUltimoCorte() {
		Date inputDate = (Date) txtFechaUltimoCorte.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	/*
	 * public MapModel getSimpleModel() {
	 * 
	 * simpleModel = new DefaultMapModel(); LatLng coord1 = new
	 * LatLng(3.6374489,-76.2900103);
	 * 
	 * if ((Float) txtLatitud.getValue() != null && (Float)
	 * txtLongitud.getValue() != null ){ //Shared coordinates coord1 = new
	 * LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
	 * //Basic marker simpleModel.addOverlay(new Marker(coord1, (String)
	 * txtNombre.getValue())); }else { //Shared coordinates coord1 = new
	 * LatLng(3, 79); //Basic marker simpleModel.addOverlay(new Marker(coord1,
	 * "SIN DEFINIR")); }
	 * 
	 * return simpleModel; }
	 * 
	 * public void onMarkerSelect(OverlaySelectEvent event) { marker = (Marker)
	 * event.getOverlay();
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected",
	 * marker.getTitle())); }
	 * 
	 * public Marker getMarker() { return marker; }
	 */

	public void listener_ConsultaNombreVariedad() {

		Long variedadId = null;

		if (!txtVaiedadId_VariedadId.getValue().equals("")) {
			variedadId = Long.parseLong(txtVaiedadId_VariedadId.getValue().toString());

			try {
				Variedad variedad = businessDelegatorView.getVariedad(variedadId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNombreVariedad.setValue(variedad.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Nivel4> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInNivel4(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {

			txtVacunosActuales.setDisabled(false);
			txtNumDensidadActual.setDisabled(false);

			// txtVacunosActuales.setDisabled(false);
			txtCodigoAlternativo.setDisabled(false);

			// txtPorcentajeArea.setDisabled(false);
			txtVariedadId.setDisabled(false);
			// txtVaiedadId_VariedadId.setDisabled(false);
			txtAreaNeta.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtEdadActual.setDisabled(true);
			txtEspacioLineasSembradas.setDisabled(false);
			txtEstado.setDisabled(false);
			txtGenerico.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNumEstimTonAnioFiscal.setDisabled(false);
			txtRenovacion.setDisabled(false);
			txtEtapaId_Etapa.setDisabled(false);
			txtNumPlantasActuales.setDisabled(false);

			// txtGrupoSuelo_GrpSuelo.setDisabled(false);
			txtNivel3Id_Nivel3.setDisabled(false);
			// txtOrganizId_Organizacion.setDisabled(false);
			// txtPersEmprId_persEmpr.setDisabled(false);
			// txtTenenId_Tenencia.setDisabled(false);
			// txtTipoCultivoId_TipCultivo.setDisabled(false);
			// txtTopografiaId_Topografia.setDisabled(false);
			// txtTrabId_Trabajador.setDisabled(false);
			// txtZonAgroec_ZonAgroec.setDisabled(false);
			// txtFechaAperturaCosecha.setDisabled(false);
			// txtFechaCierreCosecha.setDisabled(false);
			txtFechaInactivo.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtFechaSiembra.setDisabled(false);
			txtFechaUltimoCorte.setDisabled(false);
			txtNivel4Id.setDisabled(false);
			// txtNombreVariedad.setDisabled(false);
			//txtFechaStart.setDisabled(false);
			txtNumTonHaUltCosecha.setDisabled(false);
			txtNumTonHaMesUltCosecha.setDisabled(false);
			
			txtFechaCorteAnterior.setDisabled(false);
			 txtEdadUltimaCosecha.setDisabled(false);
			 txtNumTonUltCosecha.setDisabled(false);
	
				txtZonAgroec_ZonAgroec.setDisabled(false);
				
			btnSave.setDisabled(false);
		} else {
			txtZonAgroec_ZonAgroec.setValue(entity.getZonAgroec());
			txtZonAgroec_ZonAgroec.setDisabled(false);
			
			txtNumTonHaUltCosecha.setValue(entity.getNumTonUltCosechaPorHa());
			txtNumTonHaMesUltCosecha.setValue(entity.getNumTonHaMesUltCosecha());
			
			txtNumTonHaUltCosecha.setDisabled(false);
			txtNumTonHaMesUltCosecha.setDisabled(false);
			
			txtFechaCorteAnterior.setDisabled(false);
			txtEdadUltimaCosecha.setDisabled(false);
			txtNumTonUltCosecha.setDisabled(false);
			
			txtFechaCorteAnterior.setValue(entity.getFechaCorteAnterior());
			 txtEdadUltimaCosecha.setValue(entity.getEdadUltimaCosecha());
			 txtNumTonUltCosecha.setValue(entity.getNumTonUltCosecha());
			 
			 
			txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
			txtCodigoAlternativo.setDisabled(false);
			//txtFechaStart.setValue(entity.getFechaStart());
			//txtFechaStart.setDisabled(false);
			txtAreaNeta.setValue(entity.getAreaNeta());
			txtAreaNeta.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtNumPlantasActuales.setValue(entity.getNumPlantasActuales());
			txtNumPlantasActuales.setDisabled(false);

			txtFechaUltimoCorte.setValue(entity.getFechaUltimoCorte());
			txtFechaUltimoCorte.setDisabled(false);
			txtFechaSiembra.setValue(entity.getFechaSiembra());
			txtFechaSiembra.setDisabled(false);

			Date date = new Date();
			txtEdadActual.setValue(businessDelegatorView.calcularEdadLote(date, entity.getNivel4Id().longValue()));

			txtEdadActual.setDisabled(true);
			txtEspacioLineasSembradas.setValue(entity.getEspacioLineasSembradas());
			txtEspacioLineasSembradas.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			/*
			 * txtFechaCreacion.setValue(selectedNivel4.getFechaCreacion());
			 * txtFechaCreacion.setDisabled(false);
			 */
			txtFechaInactivo.setValue(entity.getFechaInactivo());
			txtFechaInactivo.setDisabled(false);
			/*
			 * txtFechaModificacion.setValue(selectedNivel4.
			 * getFechaModificacion()); txtFechaModificacion.setDisabled(false);
			 */
			txtGenerico.setValue(entity.getGenerico());
			txtGenerico.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumEstimTonAnioFiscal.setValue(entity.getNumEstimTonAnioFiscal());
			txtNumEstimTonAnioFiscal.setDisabled(false);
			txtRenovacion.setValue(entity.getRenovacion());
			txtRenovacion.setDisabled(false);

			txtVariedadId.setValue(entity.getVariedad());
			txtVariedadId.setDisabled(false);

			if (entity.getEtapa() != null) {
				txtEtapaId_Etapa.setValue(entity.getEtapa().getEtapaId());
			} else {
				txtEtapaId_Etapa.setValue("");
			}

			txtEtapaId_Etapa.setDisabled(false);

			if (entity.getNivel3() != null) {
				txtNivel3Id_Nivel3.setValue(entity.getNivel3().getNivel3Id());
			} else {
				txtNivel3Id_Nivel3.setValue("");
			}
			txtNivel3Id_Nivel3.setDisabled(false);

			txtNivel4Id.setValue(entity.getNivel4Id());
			// txtNivel4Id.setDisabled(true);
			// txtNombreVariedad.setDisabled(false);

			txtVacunosActuales.setValue(entity.getVacunosActuales());
			txtVacunosActuales.setDisabled(false);
			txtNumDensidadActual.setValue(entity.getNumDensidadActual());
			txtNumDensidadActual.setDisabled(false);

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedNivel4 = (Nivel4DTO) (evt.getComponent().getAttributes().get("selectedNivel4"));

		try {

			String Nivel4Codigo = selectedNivel4.getCodigo();
			Object[] condicion = { "codigo", true, Nivel4Codigo, "=" };
			List<Nivel4> lista = (Nivel4Codigo != null)
					? businessDelegatorView.findByCriteriaInNivel4(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			
				txtNumTonHaUltCosecha.setValue(entity.getNumTonUltCosechaPorHa());
				txtNumTonHaMesUltCosecha.setValue(entity.getNumTonHaMesUltCosecha());
				
				txtNumTonHaUltCosecha.setDisabled(false);
				txtNumTonHaMesUltCosecha.setDisabled(false);
				
				txtFechaCorteAnterior.setDisabled(false);
				txtEdadUltimaCosecha.setDisabled(false);
				txtNumTonUltCosecha.setDisabled(false);
				
				txtFechaCorteAnterior.setValue(entity.getFechaCorteAnterior());
				 txtEdadUltimaCosecha.setValue(entity.getEdadUltimaCosecha());
				 txtNumTonUltCosecha.setValue(entity.getNumTonUltCosecha());
				 
				txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
				txtCodigoAlternativo.setDisabled(false);

				txtZonAgroec_ZonAgroec.setValue(entity.getZonAgroec());
				txtZonAgroec_ZonAgroec.setDisabled(false);

				txtAreaNeta.setValue(entity.getAreaNeta());
				txtAreaNeta.setDisabled(false);

				txtNumPlantasActuales.setValue(entity.getNumPlantasActuales());
				txtNumPlantasActuales.setDisabled(false);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtFechaUltimoCorte.setValue(entity.getFechaUltimoCorte());
				txtFechaUltimoCorte.setDisabled(false);
				txtFechaSiembra.setValue(entity.getFechaSiembra());
				txtFechaSiembra.setDisabled(false);

				Date date = new Date();
				txtEdadActual.setValue(businessDelegatorView.calcularEdadLote(date, entity.getNivel4Id().longValue()));

				txtEdadActual.setDisabled(true);

				txtEspacioLineasSembradas.setValue(entity.getEspacioLineasSembradas());
				txtEspacioLineasSembradas.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtFechaInactivo.setValue(entity.getFechaInactivo());
				txtFechaInactivo.setDisabled(false);
				txtGenerico.setValue(entity.getGenerico());
				txtGenerico.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtNumEstimTonAnioFiscal.setValue(entity.getNumEstimTonAnioFiscal());
				txtNumEstimTonAnioFiscal.setDisabled(false);
				txtRenovacion.setValue(entity.getRenovacion());
				txtRenovacion.setDisabled(false);
				txtEtapaId_Etapa.setValue(selectedNivel4.getEtapaId_Etapa());
				txtEtapaId_Etapa.setDisabled(false);
				// txtGrupoSuelo_GrpSuelo.setValue(selectedNivel4
				// .getGrupoSuelo_GrpSuelo());
				// txtGrupoSuelo_GrpSuelo.setDisabled(false);
				txtNivel3Id_Nivel3.setValue(selectedNivel4.getNivel3Id_Nivel3());
				txtNivel3Id_Nivel3.setDisabled(false);
				// txtOrganizId_Organizacion.setValue(selectedNivel4
				// .getOrganizId_Organizacion());
				// txtOrganizId_Organizacion.setDisabled(false);
				// txtTenenId_Tenencia.setValue(selectedNivel4
				// .getTenenId_Tenencia());
				// txtTenenId_Tenencia.setDisabled(false);
				// txtTipoCultivoId_TipCultivo.setValue(selectedNivel4
				// .getTipoCultivoId_TipCultivo());
				// txtTipoCultivoId_TipCultivo.setDisabled(false);
				// txtTopografiaId_Topografia.setValue(selectedNivel4
				// .getTopografiaId_Topografia());
				// txtTopografiaId_Topografia.setDisabled(false);
				txtVariedadId.setValue(entity.getVariedad());
				txtVariedadId.setDisabled(false);

				txtNivel4Id.setValue(entity.getNivel4Id());

				btnSave.setDisabled(false);

				txtVacunosActuales.setValue(entity.getVacunosActuales());
				txtVacunosActuales.setDisabled(false);
				txtNumDensidadActual.setValue(entity.getNumDensidadActual());
				txtNumDensidadActual.setDisabled(false);

				activeTapIndex = 0;
				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedNivel4 == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String getLoginSession() throws Exception {

		FacesContext fc = FacesContext.getCurrentInstance();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;
		String passWord = null;

		if (auth != null) {

			login = auth.getName();

		} else {

			throw new Exception("No user logged in ");

		}

		return login;
	}

	public String getCompaniaIdSession() throws Exception {

		String compania = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				compania = usuarios.getCompania().getCompaniaId().toString();
			}
		}

		return compania;
	}

	public String action_create() {
		try {
			entity = new Nivel4();

			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			
			 entity.setFechaCorteAnterior(FacesUtils.checkDate(txtFechaCorteAnterior));
			 entity.setNumTonUltCosechaPorHa(FacesUtils.checkDouble(txtNumTonHaUltCosecha));
			 entity.setNumTonHaMesUltCosecha(FacesUtils.checkDouble(txtNumTonHaMesUltCosecha));
			 entity.setEdadUltimaCosecha(FacesUtils.checkDouble(txtEdadUltimaCosecha));
			 entity.setNumTonUltCosecha(FacesUtils.checkDouble(txtNumTonUltCosecha));
			 
			entity.setVariedad(FacesUtils.checkLong(txtVariedadId));
			entity.setFechaDescanso(FacesUtils.checkDate(txtFechaDescanso));
			entity.setFechaStart(FacesUtils.checkDate(txtFechaStart));
			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));

			entity.setVacunosActuales(FacesUtils.checkDouble(txtVacunosActuales));
			entity.setVacunosIniciales(FacesUtils.checkDouble(txtVacunosIniciales));

			entity.setSistemaRiego(FacesUtils.checkLong(txtSistemaRiegoId_SistemaRiego));

			entity.setAlturaPromedioPlantas(FacesUtils.checkDouble(txtAlturaPromedioPlantas));
			entity.setAna1(FacesUtils.checkString(txtAna1));
			entity.setAplicacionMadurante(FacesUtils.checkLong(txtAplicacionMadurante));
			entity.setAreaBruta(FacesUtils.checkDouble(txtAreaBruta));
			entity.setAreaInutil(FacesUtils.checkDouble(txtAreaInutil));
			entity.setAreaManual(FacesUtils.checkDouble(txtAreaManual));
			entity.setAreaMecanizada(FacesUtils.checkDouble(txtAreaMecanizada));
			entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
			entity.setAreaOtrosCultivos(FacesUtils.checkDouble(txtAreaOtrosCultivos));
			entity.setAreaReservada(FacesUtils.checkDouble(txtAreaReservada));
			entity.setAreaRestringida(FacesUtils.checkDouble(txtAreaRestringida));
			entity.setCantidadValvulasRiego(FacesUtils.checkLong(txtCantidadValvulasRiego));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			// entity.setCodigoUsuarioApertura(FacesUtils
			// .checkLong(txtCodigoUsuarioApertura));
			// entity.setCodigoUsuarioCierre(FacesUtils
			// .checkLong(txtCodigoUsuarioCierre));
			entity.setCompania(compania);
			entity.setCostosAmortizados(FacesUtils.checkString(txtCostosAmortizados));

			entity.setEdadUltimaCosecha(FacesUtils.checkDouble(txtEdadUltimaCosecha));
			entity.setEspacioLineasSembradas(FacesUtils.checkLong(txtEspacioLineasSembradas));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaAnalisisPostCosecha(FacesUtils.checkDate(txtFechaAnalisisPostCosecha));
			entity.setFechaAnalisisPreCosecha(FacesUtils.checkDate(txtFechaAnalisisPreCosecha));
			entity.setFechaAperturaCosecha(FacesUtils.checkDate(txtFechaAperturaCosecha));
			entity.setFechaAplicacionMadurante(FacesUtils.checkDate(txtFechaAplicacionMadurante));
			entity.setFechaCierreCosecha(FacesUtils.checkDate(txtFechaCierreCosecha));
			entity.setFechaCorteAnterior(FacesUtils.checkDate(txtFechaCorteAnterior));
			entity.setFechaCreacion(date);
			entity.setFechaEstimadaUltimoRiego(FacesUtils.checkDate(txtFechaEstimadaUltimoRiego));
			entity.setFechaInactivo(FacesUtils.checkDate(txtFechaInactivo));
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setFechaPrimerCorte(FacesUtils.checkDate(txtFechaPrimerCorte));
			entity.setFechaProximoCorte(FacesUtils.checkDate(txtFechaProximoCorte));

			if (FacesUtils.checkDate(txtFechaSiembra) == null) {
				int anoSiembra = 1970;
				int mesSiembra = 01;
				int diaSiembra = 01;
				GregorianCalendar calendario1 = new GregorianCalendar();
				calendario1.set(anoSiembra, mesSiembra - 1, diaSiembra);
				entity.setFechaSiembra(calendario1.getTime());

			} else {
				entity.setFechaSiembra(FacesUtils.checkDate(txtFechaSiembra));
			}

			entity.setFechaUltimoApunteRiego(FacesUtils.checkDate(txtFechaUltimoApunteRiego));

			if (FacesUtils.checkDate(txtFechaUltimoCorte) == null) {
				int anoCorte = 1970;
				int mesCorte = 01;
				int diaCorte = 01;
				GregorianCalendar calendario2 = new GregorianCalendar();
				calendario2.set(anoCorte, mesCorte - 1, diaCorte);
				entity.setFechaUltimoCorte(calendario2.getTime());

			} else {
				entity.setFechaUltimoCorte(FacesUtils.checkDate(txtFechaUltimoCorte));
			}

			// entity.setEdadActual(listener_calcularEdadActual(FacesUtils
			// .checkDate(txtFechaUltimoCorte)));
			// entity.setFotoInfraestructura(FacesUtils
			// .checkString(txtFotoInfraestructura));
			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));

			entity.setGenerico(FacesUtils.checkString(txtGenerico));
			entity.setIndiceHelada(FacesUtils.checkString(txtIndiceHelada));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setKilmNivel4Fab(FacesUtils.checkDouble(txtKilmNivel4Fab));
			entity.setKilmNivel4FabPav(FacesUtils.checkDouble(txtKilmNivel4FabPav));
			entity.setKilmNivel4FabTerraceria(FacesUtils.checkDouble(txtKilmNivel4FabTerraceria));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			// entity.setNivel4Id(nivel4Id);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumComederosHect(FacesUtils.checkLong(txtNumComederosHect));
			entity.setNumDensidadActual(FacesUtils.checkDouble(txtNumDensidadActual));
			entity.setNumDensidadSiembra(FacesUtils.checkDouble(txtNumDensidadSiembra));
			entity.setNumEstimTonAnioFiscal(FacesUtils.checkDouble(txtNumEstimTonAnioFiscal));
			
			
			if(txtNumEstimTonAnioFiscal.getValue() != null && txtAreaNeta.getValue() !=null ){
				Double area = FacesUtils.checkDouble(txtAreaNeta) ;
				Double ton  = FacesUtils.checkDouble(txtNumEstimTonAnioFiscal) ;
				Double tch =   ton/area;
				entity.setNumEstimTonHectPrimVez(tch);
			}
			
			
			
			
			entity.setNumEstimTonMesAnioFiscal(FacesUtils.checkDouble(txtNumEstimTonMesAnioFiscal));
			entity.setNumHectCosIndFab(FacesUtils.checkDouble(txtNumHectCosIndFab));
			entity.setNumHectOtroDestino(FacesUtils.checkDouble(txtNumHectOtroDestino));
			entity.setNumHectUltCosecha(FacesUtils.checkDouble(txtNumHectUltCosecha));
			entity.setNumLarvasSembradas(FacesUtils.checkLong(txtNumLarvasSembradas));
			entity.setNumLineasSembradas(FacesUtils.checkLong(txtNumLineasSembradas));
			entity.setNumPlantasActuales(FacesUtils.checkLong(txtNumPlantasActuales));
			entity.setNumPlantasSembradas(FacesUtils.checkLong(txtNumPlantasSembradas));
			entity.setNumPlantasSembradas2(FacesUtils.checkLong(txtNumPlantasSembradas2));
			entity.setNumRacionesCrustaceos(FacesUtils.checkDouble(txtNumRacionesCrustaceos));
			entity.setNumTonCosIndFab(FacesUtils.checkDouble(txtNumTonCosIndFab));
			entity.setNumTonOtroDestino(FacesUtils.checkDouble(txtNumTonOtroDestino));
			entity.setNumTonUltCosecha(FacesUtils.checkDouble(txtNumTonUltCosecha));
			entity.setPesoPromedioNivel4(FacesUtils.checkDouble(txtPesoPromedioNivel4));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setRenovacion(FacesUtils.checkString(txtRenovacion));
			entity.setSemillero(FacesUtils.checkString(txtSemillero));
			entity.setTotalComederos(FacesUtils.checkLong(txtTotalComederos));
			entity.setUltDosisAplicadaMadurante(FacesUtils.checkDouble(txtUltDosisAplicadaMadurante));
			entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen)) : null);
			entity.setAnioFiscal((FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal) != null)
					? businessDelegatorView.getAnioFiscal(FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal)) : null);
//			entity.setClaseTextSuelo((FacesUtils.checkLong(txtClaseTextSueloId_ClaseTextSuelo) != null)
//					? businessDelegatorView.getClaseTextSuelo(FacesUtils.checkLong(txtClaseTextSueloId_ClaseTextSuelo))
//					: null);
			entity.setEstClimat((FacesUtils.checkLong(txtEstClimatId_EstClimat) != null)
					? businessDelegatorView.getEstClimat(FacesUtils.checkLong(txtEstClimatId_EstClimat)) : null);
			entity.setEstEvaporimetro(
					(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro) != null) ? businessDelegatorView
							.getEstEvaporimetro(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro)) : null);
			entity.setEstPluvio((FacesUtils.checkLong(txtEstPluvioId_EstPluvio) != null)
					? businessDelegatorView.getEstPluvio(FacesUtils.checkLong(txtEstPluvioId_EstPluvio)) : null);
			entity.setEtapa((FacesUtils.checkLong(txtEtapaId_Etapa) != null)
					? businessDelegatorView.getEtapa(FacesUtils.checkLong(txtEtapaId_Etapa)) : null);
			entity.setFaseFenologica((FacesUtils.checkLong(txtFaseFenoId_FaseFenologica) != null)
					? businessDelegatorView.getFaseFenologica(FacesUtils.checkLong(txtFaseFenoId_FaseFenologica))
					: null);
			entity.setFliaTextSuelo((FacesUtils.checkLong(txtFliaTextSueloId_FliaTextSuelo) != null)
					? businessDelegatorView.getFliaTextSuelo(FacesUtils.checkLong(txtFliaTextSueloId_FliaTextSuelo))
					: null);
			entity.setGrpSuelo((FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo) != null)
					? businessDelegatorView.getGrpSuelo(FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo)) : null);
			entity.setN4Motivo((FacesUtils.checkLong(txtN4Mot_N4Motivo) != null)
					? businessDelegatorView.getN4Motivo(FacesUtils.checkLong(txtN4Mot_N4Motivo)) : null);
			entity.setNivel3((FacesUtils.checkLong(txtNivel3Id_Nivel3) != null)
					? businessDelegatorView.getNivel3(FacesUtils.checkLong(txtNivel3Id_Nivel3)) : null);
			entity.setOcupacion((FacesUtils.checkLong(txtOcupacionId_Ocupacion) != null)
					? businessDelegatorView.getOcupacion(FacesUtils.checkLong(txtOcupacionId_Ocupacion)) : null);
			entity.setOrdenSuelo((FacesUtils.checkLong(txtOrdenSuelo_OrdenSuelo) != null)
					? businessDelegatorView.getOrdenSuelo(FacesUtils.checkLong(txtOrdenSuelo_OrdenSuelo)) : null);
			entity.setOrganizacion((FacesUtils.checkLong(txtOrganizId_Organizacion) != null)
					? businessDelegatorView.getOrganizacion(FacesUtils.checkLong(txtOrganizId_Organizacion)) : null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_persEmpr)));
			entity.setSerieSuelo((FacesUtils.checkLong(txtSerieSueloId_SerieSuelo) != null)
					? businessDelegatorView.getSerieSuelo(FacesUtils.checkLong(txtSerieSueloId_SerieSuelo)) : null);
			entity.setTenencia((FacesUtils.checkLong(txtTenenId_Tenencia) != null)
					? businessDelegatorView.getTenencia(FacesUtils.checkLong(txtTenenId_Tenencia)) : null);
			entity.setTipCultivo((FacesUtils.checkLong(txtTipoCultivoId_TipCultivo) != null)
					? businessDelegatorView.getTipCultivo(FacesUtils.checkLong(txtTipoCultivoId_TipCultivo)) : null);
			entity.setTipoDrenaje((FacesUtils.checkLong(txtTipoDrenajeId_TipoDrenaje) != null)
					? businessDelegatorView.getTipoDrenaje(FacesUtils.checkLong(txtTipoDrenajeId_TipoDrenaje)) : null);
			entity.setTopografia((FacesUtils.checkLong(txtTopografiaId_Topografia) != null)
					? businessDelegatorView.getTopografia(FacesUtils.checkLong(txtTopografiaId_Topografia)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setZonAgroec((FacesUtils.checkLong(txtZonAgroec_ZonAgroec) != null)
					? businessDelegatorView.getZonAgroec(FacesUtils.checkLong(txtZonAgroec_ZonAgroec)) : null);
			businessDelegatorView.saveNivel4(entity, restriccionDeQuema, restriccionDeMadurante, dataVariedad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long nivel4Id = new Long(selectedNivel4.getNivel4Id());
				entity = businessDelegatorView.getNivel4(nivel4Id);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			 entity.setFechaCorteAnterior(FacesUtils.checkDate(txtFechaCorteAnterior));
			 entity.setNumTonUltCosechaPorHa(FacesUtils.checkDouble(txtNumTonHaUltCosecha));
			 entity.setNumTonHaMesUltCosecha(FacesUtils.checkDouble(txtNumTonHaMesUltCosecha));
			 entity.setEdadUltimaCosecha(FacesUtils.checkDouble(txtEdadUltimaCosecha));
			
			entity.setVariedad(FacesUtils.checkLong(txtVariedadId));
			entity.setFechaDescanso(FacesUtils.checkDate(txtFechaDescanso));
			entity.setSistemaRiego(FacesUtils.checkLong(txtSistemaRiegoId_SistemaRiego));
			entity.setFechaStart(FacesUtils.checkDate(txtFechaStart));
			entity.setVacunosActuales(FacesUtils.checkDouble(txtVacunosActuales));
			entity.setVacunosIniciales(FacesUtils.checkDouble(txtVacunosIniciales));

			entity.setAlturaPromedioPlantas(FacesUtils.checkDouble(txtAlturaPromedioPlantas));
			entity.setAna1(FacesUtils.checkString(txtAna1));
			entity.setAplicacionMadurante(FacesUtils.checkLong(txtAplicacionMadurante));
			entity.setAreaBruta(FacesUtils.checkDouble(txtAreaBruta));
			entity.setAreaInutil(FacesUtils.checkDouble(txtAreaInutil));
			entity.setAreaManual(FacesUtils.checkDouble(txtAreaManual));
			entity.setAreaMecanizada(FacesUtils.checkDouble(txtAreaMecanizada));
			entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
			entity.setAreaOtrosCultivos(FacesUtils.checkDouble(txtAreaOtrosCultivos));
			entity.setAreaReservada(FacesUtils.checkDouble(txtAreaReservada));
			entity.setAreaRestringida(FacesUtils.checkDouble(txtAreaRestringida));
			entity.setCantidadValvulasRiego(FacesUtils.checkLong(txtCantidadValvulasRiego));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			// entity.setCodigoUsuarioApertura(FacesUtils
			// .checkLong(txtCodigoUsuarioApertura));
			// entity.setCodigoUsuarioCierre(FacesUtils
			// .checkLong(txtCodigoUsuarioCierre));
			entity.setCompania(compania);
			entity.setCostosAmortizados(FacesUtils.checkString(txtCostosAmortizados));

			// entity.setEdadActual(FacesUtils.checkLong(txtEdadActual));

			entity.setEdadUltimaCosecha(FacesUtils.checkDouble(txtEdadUltimaCosecha));
			entity.setEspacioLineasSembradas(FacesUtils.checkLong(txtEspacioLineasSembradas));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaAnalisisPostCosecha(FacesUtils.checkDate(txtFechaAnalisisPostCosecha));
			entity.setFechaAnalisisPreCosecha(FacesUtils.checkDate(txtFechaAnalisisPreCosecha));
			entity.setFechaAperturaCosecha(FacesUtils.checkDate(txtFechaAperturaCosecha));
			entity.setFechaAplicacionMadurante(FacesUtils.checkDate(txtFechaAplicacionMadurante));
			entity.setFechaCierreCosecha(FacesUtils.checkDate(txtFechaCierreCosecha));
			entity.setFechaCorteAnterior(FacesUtils.checkDate(txtFechaCorteAnterior));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaEstimadaUltimoRiego(FacesUtils.checkDate(txtFechaEstimadaUltimoRiego));
			entity.setFechaInactivo(FacesUtils.checkDate(txtFechaInactivo));
			entity.setFechaModificacion(date);
			entity.setFechaPrimerCorte(FacesUtils.checkDate(txtFechaPrimerCorte));
			entity.setFechaProximoCorte(FacesUtils.checkDate(txtFechaProximoCorte));
			entity.setFechaSiembra(FacesUtils.checkDate(txtFechaSiembra));
			entity.setFechaUltimoApunteRiego(FacesUtils.checkDate(txtFechaUltimoApunteRiego));
			entity.setFechaUltimoCorte(FacesUtils.checkDate(txtFechaUltimoCorte));
			entity.setFotoInfraestructura(FacesUtils.checkString(txtFotoInfraestructura));
			entity.setGenerico(FacesUtils.checkString(txtGenerico));
			entity.setIndiceHelada(FacesUtils.checkString(txtIndiceHelada));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setKilmNivel4Fab(FacesUtils.checkDouble(txtKilmNivel4Fab));
			entity.setKilmNivel4FabPav(FacesUtils.checkDouble(txtKilmNivel4FabPav));
			entity.setKilmNivel4FabTerraceria(FacesUtils.checkDouble(txtKilmNivel4FabTerraceria));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumComederosHect(FacesUtils.checkLong(txtNumComederosHect));
			entity.setNumDensidadActual(FacesUtils.checkDouble(txtNumDensidadActual));
			entity.setNumDensidadSiembra(FacesUtils.checkDouble(txtNumDensidadSiembra));
			entity.setNumEstimTonAnioFiscal(FacesUtils.checkDouble(txtNumEstimTonAnioFiscal));
			
			if(txtNumEstimTonAnioFiscal.getValue() != null && txtAreaNeta.getValue() !=null ){
				Double area = FacesUtils.checkDouble(txtAreaNeta) ;
				Double ton  = FacesUtils.checkDouble(txtNumEstimTonAnioFiscal) ;
				Double tch =   ton/area;
				entity.setNumEstimTonHectPrimVez(tch);
			}
			
			
			
			entity.setNumEstimTonMesAnioFiscal(FacesUtils.checkDouble(txtNumEstimTonMesAnioFiscal));
			entity.setNumHectCosIndFab(FacesUtils.checkDouble(txtNumHectCosIndFab));
			entity.setNumHectOtroDestino(FacesUtils.checkDouble(txtNumHectOtroDestino));
			entity.setNumHectUltCosecha(FacesUtils.checkDouble(txtNumHectUltCosecha));
			entity.setNumLarvasSembradas(FacesUtils.checkLong(txtNumLarvasSembradas));
			entity.setNumLineasSembradas(FacesUtils.checkLong(txtNumLineasSembradas));
			entity.setNumPlantasActuales(FacesUtils.checkLong(txtNumPlantasActuales));
			entity.setNumPlantasSembradas(FacesUtils.checkLong(txtNumPlantasSembradas));
			entity.setNumPlantasSembradas2(FacesUtils.checkLong(txtNumPlantasSembradas2));
			entity.setNumRacionesCrustaceos(FacesUtils.checkDouble(txtNumRacionesCrustaceos));
			entity.setNumTonCosIndFab(FacesUtils.checkDouble(txtNumTonCosIndFab));
			entity.setNumTonOtroDestino(FacesUtils.checkDouble(txtNumTonOtroDestino));
			entity.setNumTonUltCosecha(FacesUtils.checkDouble(txtNumTonUltCosecha));
			entity.setPesoPromedioNivel4(FacesUtils.checkDouble(txtPesoPromedioNivel4));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setRenovacion(FacesUtils.checkString(txtRenovacion));
			entity.setSemillero(FacesUtils.checkString(txtSemillero));
			entity.setTotalComederos(FacesUtils.checkLong(txtTotalComederos));
			entity.setUltDosisAplicadaMadurante(FacesUtils.checkDouble(txtUltDosisAplicadaMadurante));
			entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen)) : null);
			entity.setAnioFiscal((FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal) != null)
					? businessDelegatorView.getAnioFiscal(FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal)) : null);
//			entity.setClaseTextSuelo((FacesUtils.checkLong(txtClaseTextSueloId_ClaseTextSuelo) != null)
//					? businessDelegatorView.getClaseTextSuelo(FacesUtils.checkLong(txtClaseTextSueloId_ClaseTextSuelo))
//					: null);
			entity.setEstClimat((FacesUtils.checkLong(txtEstClimatId_EstClimat) != null)
					? businessDelegatorView.getEstClimat(FacesUtils.checkLong(txtEstClimatId_EstClimat)) : null);
			entity.setEstEvaporimetro(
					(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro) != null) ? businessDelegatorView
							.getEstEvaporimetro(FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro)) : null);
			entity.setEstPluvio((FacesUtils.checkLong(txtEstPluvioId_EstPluvio) != null)
					? businessDelegatorView.getEstPluvio(FacesUtils.checkLong(txtEstPluvioId_EstPluvio)) : null);
			entity.setEtapa((FacesUtils.checkLong(txtEtapaId_Etapa) != null)
					? businessDelegatorView.getEtapa(FacesUtils.checkLong(txtEtapaId_Etapa)) : null);
			entity.setFaseFenologica((FacesUtils.checkLong(txtFaseFenoId_FaseFenologica) != null)
					? businessDelegatorView.getFaseFenologica(FacesUtils.checkLong(txtFaseFenoId_FaseFenologica))
					: null);
			entity.setFliaTextSuelo((FacesUtils.checkLong(txtFliaTextSueloId_FliaTextSuelo) != null)
					? businessDelegatorView.getFliaTextSuelo(FacesUtils.checkLong(txtFliaTextSueloId_FliaTextSuelo))
					: null);
			entity.setGrpSuelo((FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo) != null)
					? businessDelegatorView.getGrpSuelo(FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo)) : null);
			entity.setN4Motivo((FacesUtils.checkLong(txtN4Mot_N4Motivo) != null)
					? businessDelegatorView.getN4Motivo(FacesUtils.checkLong(txtN4Mot_N4Motivo)) : null);
			entity.setNivel3((FacesUtils.checkLong(txtNivel3Id_Nivel3) != null)
					? businessDelegatorView.getNivel3(FacesUtils.checkLong(txtNivel3Id_Nivel3)) : null);
			entity.setOcupacion((FacesUtils.checkLong(txtOcupacionId_Ocupacion) != null)
					? businessDelegatorView.getOcupacion(FacesUtils.checkLong(txtOcupacionId_Ocupacion)) : null);
			entity.setOrdenSuelo((FacesUtils.checkLong(txtOrdenSuelo_OrdenSuelo) != null)
					? businessDelegatorView.getOrdenSuelo(FacesUtils.checkLong(txtOrdenSuelo_OrdenSuelo)) : null);
			entity.setOrganizacion((FacesUtils.checkLong(txtOrganizId_Organizacion) != null)
					? businessDelegatorView.getOrganizacion(FacesUtils.checkLong(txtOrganizId_Organizacion)) : null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_persEmpr)));
			entity.setSerieSuelo((FacesUtils.checkLong(txtSerieSueloId_SerieSuelo) != null)
					? businessDelegatorView.getSerieSuelo(FacesUtils.checkLong(txtSerieSueloId_SerieSuelo)) : null);
			entity.setTenencia((FacesUtils.checkLong(txtTenenId_Tenencia) != null)
					? businessDelegatorView.getTenencia(FacesUtils.checkLong(txtTenenId_Tenencia)) : null);
			entity.setTipCultivo((FacesUtils.checkLong(txtTipoCultivoId_TipCultivo) != null)
					? businessDelegatorView.getTipCultivo(FacesUtils.checkLong(txtTipoCultivoId_TipCultivo)) : null);
			entity.setTipoDrenaje((FacesUtils.checkLong(txtTipoDrenajeId_TipoDrenaje) != null)
					? businessDelegatorView.getTipoDrenaje(FacesUtils.checkLong(txtTipoDrenajeId_TipoDrenaje)) : null);
			entity.setTopografia((FacesUtils.checkLong(txtTopografiaId_Topografia) != null)
					? businessDelegatorView.getTopografia(FacesUtils.checkLong(txtTopografiaId_Topografia)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setZonAgroec((FacesUtils.checkLong(txtZonAgroec_ZonAgroec) != null)
					? businessDelegatorView.getZonAgroec(FacesUtils.checkLong(txtZonAgroec_ZonAgroec)) : null);
			businessDelegatorView.updateNivel4(entity, restriccionDeQuema, restriccionDeMadurante, dataVariedad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedNivel4 = (Nivel4DTO) (evt.getComponent().getAttributes().get("selectedNivel4"));

			Long nivel4Id = new Long(selectedNivel4.getNivel4Id());
			entity = businessDelegatorView.getNivel4(nivel4Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long nivel4Id = FacesUtils.checkLong(txtNivel4Id);
			entity = businessDelegatorView.getNivel4(nivel4Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteNivel4(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedNivel4 = (Nivel4DTO) (evt.getComponent().getAttributes().get("selectedNivel4"));

			Long nivel4Id = new Long(selectedNivel4.getNivel4Id());
			entity = businessDelegatorView.getNivel4(nivel4Id);
			businessDelegatorView.deleteNivel4(entity);
			((Map<String, Object>) data).remove(selectedNivel4);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double alturaPromedioPlantas, String ana1, Long aplicacionMadurante,
			Double areaBruta, Double areaInutil, Double areaManual, Double areaMecanizada, Double areaNeta,
			Double areaOtrosCultivos, Double areaReservada, Double areaRestringida, Long cantidadValvulasRiego,
			String codigo, Long codigoUsuarioApertura, Long codigoUsuarioCierre, Long compania,
			String costosAmortizados, Long edadActual, Double edadUltimaCosecha, Double espacioLineasSembradas,
			String estado, Date fechaAnalisisPostCosecha, String fechaAnalisisPreCosecha, Date fechaAperturaCosecha,
			Date fechaAplicacionMadurante, Date fechaCierreCosecha, Date fechaCorteAnterior, Date fechaCreacion,
			Date fechaEstimadaUltimoRiego, Date fechaInactivo, Date fechaModificacion, Date fechaPrimerCorte,
			Date fechaProximoCorte, Date fechaSiembra, Date fechaUltimoApunteRiego, Date fechaUltimoCorte,
			String fotoInfraestructura, String generico, String indiceHelada, String infoAdicional,
			String infoAdicional2, Double kilmNivel4Fab, Double kilmNivel4FabPav, Double kilmNivel4FabTerraceria,
			String latitud, String longitud, Long nivel4Id, String nombre, Long numComederosHect,
			Double numDensidadActual, Double numDensidadSiembra, Double numEstimTonAnioFiscal,
			Double numEstimTonHectPrimVez, Double numEstimTonMesAnioFiscal, Double numHectCosIndFab,
			Double numHectOtroDestino, Double numHectUltCosecha, Long numLarvasSembradas, Long numLineasSembradas,
			Long numPlantasActuales, Long numPlantasSembradas, Long numPlantasSembradas2, Double numRacionesCrustaceos,
			Double numTonCosIndFab, Double numTonOtroDestino, Double numTonUltCosecha, Double pesoPromedioNivel4,
			String precision, String renovacion, String semillero, Long totalComederos,
			Double ultDosisAplicadaMadurante, Long almacenId_Almacen, Long anioFiscalId_AnioFiscal,
			Long claseTextSueloId_ClaseTextSuelo, Long estClimatId_EstClimat, Long estEvaporimetroId_EstEvaporimetro,
			Long estPluvioId_EstPluvio, Long etapaId_Etapa, Long faseFenoId_FaseFenologica,
			Long fliaTextSueloId_FliaTextSuelo, Long grupoSuelo_GrpSuelo, Long n4Mot_N4Motivo, Long nivel3Id_Nivel3,
			Long ocupacionId_Ocupacion, Long ordenSuelo_OrdenSuelo, Long organizId_Organizacion, Long proveId_Proveedor,
			Long serieSueloId_SerieSuelo, Long tenenId_Tenencia, Long tipoCultivoId_TipCultivo,
			Long tipoDrenajeId_TipoDrenaje, Long topografiaId_Topografia, Long sistemaRiego, Date fechaDescanso,
			Long trabId_Trabajador, Long zonAgroec_ZonAgroec) throws Exception {
		try {
			entity.setAlturaPromedioPlantas(FacesUtils.checkDouble(alturaPromedioPlantas));
			entity.setAna1(FacesUtils.checkString(ana1));
			entity.setFechaDescanso(FacesUtils.checkDate(fechaDescanso));
			entity.setSistemaRiego(FacesUtils.checkLong(sistemaRiego));

			entity.setAplicacionMadurante(FacesUtils.checkLong(aplicacionMadurante));
			entity.setAreaBruta(FacesUtils.checkDouble(areaBruta));
			entity.setAreaInutil(FacesUtils.checkDouble(areaInutil));
			entity.setAreaManual(FacesUtils.checkDouble(areaManual));
			entity.setAreaMecanizada(FacesUtils.checkDouble(areaMecanizada));
			entity.setAreaNeta(FacesUtils.checkDouble(areaNeta));
			entity.setAreaOtrosCultivos(FacesUtils.checkDouble(areaOtrosCultivos));
			entity.setAreaReservada(FacesUtils.checkDouble(areaReservada));
			entity.setAreaRestringida(FacesUtils.checkDouble(areaRestringida));
			entity.setCantidadValvulasRiego(FacesUtils.checkLong(cantidadValvulasRiego));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCodigoUsuarioApertura(FacesUtils.checkLong(codigoUsuarioApertura));
			entity.setCodigoUsuarioCierre(FacesUtils.checkLong(codigoUsuarioCierre));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setCostosAmortizados(FacesUtils.checkString(costosAmortizados));
			entity.setEdadActual(FacesUtils.checkDouble(edadActual));
			entity.setEdadUltimaCosecha(FacesUtils.checkDouble(edadUltimaCosecha));
			entity.setEspacioLineasSembradas(FacesUtils.checkLong(espacioLineasSembradas));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnalisisPostCosecha(FacesUtils.checkDate(fechaAnalisisPostCosecha));
			entity.setFechaAnalisisPreCosecha(FacesUtils.checkDate(fechaAnalisisPreCosecha));
			entity.setFechaAperturaCosecha(FacesUtils.checkDate(fechaAperturaCosecha));
			entity.setFechaAplicacionMadurante(FacesUtils.checkDate(fechaAplicacionMadurante));
			entity.setFechaCierreCosecha(FacesUtils.checkDate(fechaCierreCosecha));
			entity.setFechaCorteAnterior(FacesUtils.checkDate(fechaCorteAnterior));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaEstimadaUltimoRiego(FacesUtils.checkDate(fechaEstimadaUltimoRiego));
			entity.setFechaInactivo(FacesUtils.checkDate(fechaInactivo));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaPrimerCorte(FacesUtils.checkDate(fechaPrimerCorte));
			entity.setFechaProximoCorte(FacesUtils.checkDate(fechaProximoCorte));
			entity.setFechaSiembra(FacesUtils.checkDate(fechaSiembra));
			entity.setFechaUltimoApunteRiego(FacesUtils.checkDate(fechaUltimoApunteRiego));
			entity.setFechaUltimoCorte(FacesUtils.checkDate(fechaUltimoCorte));
			entity.setFotoInfraestructura(FacesUtils.checkString(fotoInfraestructura));
			entity.setGenerico(FacesUtils.checkString(generico));
			entity.setIndiceHelada(FacesUtils.checkString(indiceHelada));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setKilmNivel4Fab(FacesUtils.checkDouble(kilmNivel4Fab));
			entity.setKilmNivel4FabPav(FacesUtils.checkDouble(kilmNivel4FabPav));
			entity.setKilmNivel4FabTerraceria(FacesUtils.checkDouble(kilmNivel4FabTerraceria));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setNumComederosHect(FacesUtils.checkLong(numComederosHect));
			entity.setNumDensidadActual(FacesUtils.checkDouble(numDensidadActual));
			entity.setNumDensidadSiembra(FacesUtils.checkDouble(numDensidadSiembra));
			entity.setNumEstimTonAnioFiscal(FacesUtils.checkDouble(numEstimTonAnioFiscal));
			entity.setNumEstimTonHectPrimVez(FacesUtils.checkDouble(numEstimTonHectPrimVez));
			entity.setNumEstimTonMesAnioFiscal(FacesUtils.checkDouble(numEstimTonMesAnioFiscal));
			entity.setNumHectCosIndFab(FacesUtils.checkDouble(numHectCosIndFab));
			entity.setNumHectOtroDestino(FacesUtils.checkDouble(numHectOtroDestino));
			entity.setNumHectUltCosecha(FacesUtils.checkDouble(numHectUltCosecha));
			entity.setNumLarvasSembradas(FacesUtils.checkLong(numLarvasSembradas));
			entity.setNumLineasSembradas(FacesUtils.checkLong(numLineasSembradas));
			entity.setNumPlantasActuales(FacesUtils.checkLong(numPlantasActuales));
			entity.setNumPlantasSembradas(FacesUtils.checkLong(numPlantasSembradas));
			entity.setNumPlantasSembradas2(FacesUtils.checkLong(numPlantasSembradas2));
			entity.setNumRacionesCrustaceos(FacesUtils.checkDouble(numRacionesCrustaceos));
			entity.setNumTonCosIndFab(FacesUtils.checkDouble(numTonCosIndFab));
			entity.setNumTonOtroDestino(FacesUtils.checkDouble(numTonOtroDestino));
			entity.setNumTonUltCosecha(FacesUtils.checkDouble(numTonUltCosecha));
			entity.setPesoPromedioNivel4(FacesUtils.checkDouble(pesoPromedioNivel4));
			entity.setPrecision(FacesUtils.checkFloat(precision));

			entity.setRenovacion(FacesUtils.checkString(renovacion));
			entity.setSemillero(FacesUtils.checkString(semillero));
			entity.setTotalComederos(FacesUtils.checkLong(totalComederos));
			entity.setUltDosisAplicadaMadurante(FacesUtils.checkDouble(ultDosisAplicadaMadurante));
			businessDelegatorView.updateNivel4(entity, restriccionDeQuema, restriccionDeMadurante, dataVariedad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("Nivel4View").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAlturaPromedioPlantas() {
		return txtAlturaPromedioPlantas;
	}

	public void setTxtAlturaPromedioPlantas(InputText txtAlturaPromedioPlantas) {
		this.txtAlturaPromedioPlantas = txtAlturaPromedioPlantas;
	}

	public InputText getTxtAna1() {
		return txtAna1;
	}

	public void setTxtAna1(InputText txtAna1) {
		this.txtAna1 = txtAna1;
	}

	public SelectOneRadio getTxtAplicacionMadurante() {
		return txtAplicacionMadurante;
	}

	public void setTxtAplicacionMadurante(SelectOneRadio txtAplicacionMadurante) {
		this.txtAplicacionMadurante = txtAplicacionMadurante;
	}

	public InputText getTxtAreaBruta() {
		return txtAreaBruta;
	}

	public void setTxtAreaBruta(InputText txtAreaBruta) {
		this.txtAreaBruta = txtAreaBruta;
	}

	public InputText getTxtAreaInutil() {
		return txtAreaInutil;
	}

	public void setTxtAreaInutil(InputText txtAreaInutil) {
		this.txtAreaInutil = txtAreaInutil;
	}

	public InputText getTxtAreaManual() {
		return txtAreaManual;
	}

	public void setTxtAreaManual(InputText txtAreaManual) {
		this.txtAreaManual = txtAreaManual;
	}

	public InputText getTxtAreaMecanizada() {
		return txtAreaMecanizada;
	}

	public void setTxtAreaMecanizada(InputText txtAreaMecanizada) {
		this.txtAreaMecanizada = txtAreaMecanizada;
	}

	public InputText getTxtAreaNeta() {
		return txtAreaNeta;
	}

	public void setTxtAreaNeta(InputText txtAreaNeta) {
		this.txtAreaNeta = txtAreaNeta;
	}

	public InputText getTxtAreaOtrosCultivos() {
		return txtAreaOtrosCultivos;
	}

	public void setTxtAreaOtrosCultivos(InputText txtAreaOtrosCultivos) {
		this.txtAreaOtrosCultivos = txtAreaOtrosCultivos;
	}

	public InputText getTxtAreaReservada() {
		return txtAreaReservada;
	}

	public void setTxtAreaReservada(InputText txtAreaReservada) {
		this.txtAreaReservada = txtAreaReservada;
	}

	public InputText getTxtAreaRestringida() {
		return txtAreaRestringida;
	}

	public void setTxtAreaRestringida(InputText txtAreaRestringida) {
		this.txtAreaRestringida = txtAreaRestringida;
	}

	public InputText getTxtCantidadValvulasRiego() {
		return txtCantidadValvulasRiego;
	}

	public void setTxtCantidadValvulasRiego(InputText txtCantidadValvulasRiego) {
		this.txtCantidadValvulasRiego = txtCantidadValvulasRiego;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCodigoUsuarioApertura() {
		return txtCodigoUsuarioApertura;
	}

	public void setTxtCodigoUsuarioApertura(InputText txtCodigoUsuarioApertura) {
		this.txtCodigoUsuarioApertura = txtCodigoUsuarioApertura;
	}

	public InputText getTxtCodigoUsuarioCierre() {
		return txtCodigoUsuarioCierre;
	}

	public void setTxtCodigoUsuarioCierre(InputText txtCodigoUsuarioCierre) {
		this.txtCodigoUsuarioCierre = txtCodigoUsuarioCierre;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectOneRadio getTxtCostosAmortizados() {
		return txtCostosAmortizados;
	}

	public void setTxtCostosAmortizados(SelectOneRadio txtCostosAmortizados) {
		this.txtCostosAmortizados = txtCostosAmortizados;
	}

	public InputText getTxtEdadActual() {
		return txtEdadActual;
	}

	public void setTxtEdadActual(InputText txtEdadActual) {
		this.txtEdadActual = txtEdadActual;
	}

	public InputText getTxtEdadUltimaCosecha() {
		return txtEdadUltimaCosecha;
	}

	public void setTxtEdadUltimaCosecha(InputText txtEdadUltimaCosecha) {
		this.txtEdadUltimaCosecha = txtEdadUltimaCosecha;
	}

	public SelectOneMenu getTxtEspacioLineasSembradas() {
		return txtEspacioLineasSembradas;
	}

	public void setTxtEspacioLineasSembradas(SelectOneMenu txtEspacioLineasSembradas) {
		this.txtEspacioLineasSembradas = txtEspacioLineasSembradas;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public Calendar getTxtFechaAnalisisPreCosecha() {
		return txtFechaAnalisisPreCosecha;
	}

	public void setTxtFechaAnalisisPreCosecha(Calendar txtFechaAnalisisPreCosecha) {
		this.txtFechaAnalisisPreCosecha = txtFechaAnalisisPreCosecha;
	}

	public InputText getTxtFotoInfraestructura() {
		return txtFotoInfraestructura;
	}

	public void setTxtFotoInfraestructura(InputText txtFotoInfraestructura) {
		this.txtFotoInfraestructura = txtFotoInfraestructura;
	}

	public SelectOneRadio getTxtGenerico() {
		return txtGenerico;
	}

	public void setTxtGenerico(SelectOneRadio txtGenerico) {
		this.txtGenerico = txtGenerico;
	}

	public SelectOneRadio getTxtIndiceHelada() {
		return txtIndiceHelada;
	}

	public void setTxtIndiceHelada(SelectOneRadio txtIndiceHelada) {
		this.txtIndiceHelada = txtIndiceHelada;
	}

	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public InputText getTxtKilmNivel4Fab() {
		return txtKilmNivel4Fab;
	}

	public void setTxtKilmNivel4Fab(InputText txtKilmNivel4Fab) {
		this.txtKilmNivel4Fab = txtKilmNivel4Fab;
	}

	public InputText getTxtKilmNivel4FabPav() {
		return txtKilmNivel4FabPav;
	}

	public void setTxtKilmNivel4FabPav(InputText txtKilmNivel4FabPav) {
		this.txtKilmNivel4FabPav = txtKilmNivel4FabPav;
	}

	public InputText getTxtKilmNivel4FabTerraceria() {
		return txtKilmNivel4FabTerraceria;
	}

	public void setTxtKilmNivel4FabTerraceria(InputText txtKilmNivel4FabTerraceria) {
		this.txtKilmNivel4FabTerraceria = txtKilmNivel4FabTerraceria;
	}

	public InputText getTxtLatitud() {
		return txtLatitud;
	}

	public void setTxtLatitud(InputText txtLatitud) {
		this.txtLatitud = txtLatitud;
	}

	public InputText getTxtLongitud() {
		return txtLongitud;
	}

	public void setTxtLongitud(InputText txtLongitud) {
		this.txtLongitud = txtLongitud;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtNumComederosHect() {
		return txtNumComederosHect;
	}

	public void setTxtNumComederosHect(InputText txtNumComederosHect) {
		this.txtNumComederosHect = txtNumComederosHect;
	}

	public InputText getTxtNumDensidadActual() {
		return txtNumDensidadActual;
	}

	public void setTxtNumDensidadActual(InputText txtNumDensidadActual) {
		this.txtNumDensidadActual = txtNumDensidadActual;
	}

	public InputText getTxtNumDensidadSiembra() {
		return txtNumDensidadSiembra;
	}

	public void setTxtNumDensidadSiembra(InputText txtNumDensidadSiembra) {
		this.txtNumDensidadSiembra = txtNumDensidadSiembra;
	}

	public InputText getTxtNumEstimTonAnioFiscal() {
		return txtNumEstimTonAnioFiscal;
	}

	public void setTxtNumEstimTonAnioFiscal(InputText txtNumEstimTonAnioFiscal) {
		this.txtNumEstimTonAnioFiscal = txtNumEstimTonAnioFiscal;
	}

	public InputText getTxtNumEstimTonHectPrimVez() {
		return txtNumEstimTonHectPrimVez;
	}

	public void setTxtNumEstimTonHectPrimVez(InputText txtNumEstimTonHectPrimVez) {
		this.txtNumEstimTonHectPrimVez = txtNumEstimTonHectPrimVez;
	}

	public InputText getTxtNumEstimTonMesAnioFiscal() {
		return txtNumEstimTonMesAnioFiscal;
	}

	public void setTxtNumEstimTonMesAnioFiscal(InputText txtNumEstimTonMesAnioFiscal) {
		this.txtNumEstimTonMesAnioFiscal = txtNumEstimTonMesAnioFiscal;
	}

	public InputText getTxtNumHectCosIndFab() {
		return txtNumHectCosIndFab;
	}

	public void setTxtNumHectCosIndFab(InputText txtNumHectCosIndFab) {
		this.txtNumHectCosIndFab = txtNumHectCosIndFab;
	}

	public InputText getTxtNumHectOtroDestino() {
		return txtNumHectOtroDestino;
	}

	public void setTxtNumHectOtroDestino(InputText txtNumHectOtroDestino) {
		this.txtNumHectOtroDestino = txtNumHectOtroDestino;
	}

	public InputText getTxtNumHectUltCosecha() {
		return txtNumHectUltCosecha;
	}

	public void setTxtNumHectUltCosecha(InputText txtNumHectUltCosecha) {
		this.txtNumHectUltCosecha = txtNumHectUltCosecha;
	}

	public InputText getTxtNumLarvasSembradas() {
		return txtNumLarvasSembradas;
	}

	public void setTxtNumLarvasSembradas(InputText txtNumLarvasSembradas) {
		this.txtNumLarvasSembradas = txtNumLarvasSembradas;
	}

	public InputText getTxtNumLineasSembradas() {
		return txtNumLineasSembradas;
	}

	public void setTxtNumLineasSembradas(InputText txtNumLineasSembradas) {
		this.txtNumLineasSembradas = txtNumLineasSembradas;
	}

	public InputText getTxtNumPlantasActuales() {
		return txtNumPlantasActuales;
	}

	public void setTxtNumPlantasActuales(InputText txtNumPlantasActuales) {
		this.txtNumPlantasActuales = txtNumPlantasActuales;
	}

	public InputText getTxtNumPlantasSembradas() {
		return txtNumPlantasSembradas;
	}

	public void setTxtNumPlantasSembradas(InputText txtNumPlantasSembradas) {
		this.txtNumPlantasSembradas = txtNumPlantasSembradas;
	}

	public InputText getTxtNumPlantasSembradas2() {
		return txtNumPlantasSembradas2;
	}

	public void setTxtNumPlantasSembradas2(InputText txtNumPlantasSembradas2) {
		this.txtNumPlantasSembradas2 = txtNumPlantasSembradas2;
	}

	public InputText getTxtNumRacionesCrustaceos() {
		return txtNumRacionesCrustaceos;
	}

	public void setTxtNumRacionesCrustaceos(InputText txtNumRacionesCrustaceos) {
		this.txtNumRacionesCrustaceos = txtNumRacionesCrustaceos;
	}

	public InputText getTxtNumTonCosIndFab() {
		return txtNumTonCosIndFab;
	}

	public void setTxtNumTonCosIndFab(InputText txtNumTonCosIndFab) {
		this.txtNumTonCosIndFab = txtNumTonCosIndFab;
	}

	public InputText getTxtNumTonOtroDestino() {
		return txtNumTonOtroDestino;
	}

	public void setTxtNumTonOtroDestino(InputText txtNumTonOtroDestino) {
		this.txtNumTonOtroDestino = txtNumTonOtroDestino;
	}

	public InputText getTxtNumTonUltCosecha() {
		return txtNumTonUltCosecha;
	}

	public void setTxtNumTonUltCosecha(InputText txtNumTonUltCosecha) {
		this.txtNumTonUltCosecha = txtNumTonUltCosecha;
	}

	public InputText getTxtPesoPromedioNivel4() {
		return txtPesoPromedioNivel4;
	}

	public void setTxtPesoPromedioNivel4(InputText txtPesoPromedioNivel4) {
		this.txtPesoPromedioNivel4 = txtPesoPromedioNivel4;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public SelectOneRadio getTxtRenovacion() {
		return txtRenovacion;
	}

	public void setTxtRenovacion(SelectOneRadio txtRenovacion) {
		this.txtRenovacion = txtRenovacion;
	}

	public SelectOneRadio getTxtSemillero() {
		return txtSemillero;
	}

	public void setTxtSemillero(SelectOneRadio txtSemillero) {
		this.txtSemillero = txtSemillero;
	}

	public InputText getTxtTotalComederos() {
		return txtTotalComederos;
	}

	public void setTxtTotalComederos(InputText txtTotalComederos) {
		this.txtTotalComederos = txtTotalComederos;
	}

	public InputText getTxtUltDosisAplicadaMadurante() {
		return txtUltDosisAplicadaMadurante;
	}

	public void setTxtUltDosisAplicadaMadurante(InputText txtUltDosisAplicadaMadurante) {
		this.txtUltDosisAplicadaMadurante = txtUltDosisAplicadaMadurante;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}

	public SelectOneMenu getTxtAnioFiscalId_AnioFiscal() {
		return txtAnioFiscalId_AnioFiscal;
	}

	public void setTxtAnioFiscalId_AnioFiscal(SelectOneMenu txtAnioFiscalId_AnioFiscal) {
		this.txtAnioFiscalId_AnioFiscal = txtAnioFiscalId_AnioFiscal;
	}

	public SelectOneMenu getTxtClaseTextSueloId_ClaseTextSuelo() {
		return txtClaseTextSueloId_ClaseTextSuelo;
	}

	public void setTxtClaseTextSueloId_ClaseTextSuelo(SelectOneMenu txtClaseTextSueloId_ClaseTextSuelo) {
		this.txtClaseTextSueloId_ClaseTextSuelo = txtClaseTextSueloId_ClaseTextSuelo;
	}

	public SelectOneMenu getTxtEstClimatId_EstClimat() {
		return txtEstClimatId_EstClimat;
	}

	public void setTxtEstClimatId_EstClimat(SelectOneMenu txtEstClimatId_EstClimat) {
		this.txtEstClimatId_EstClimat = txtEstClimatId_EstClimat;
	}

	public SelectOneMenu getTxtEstEvaporimetroId_EstEvaporimetro() {
		return txtEstEvaporimetroId_EstEvaporimetro;
	}

	public void setTxtEstEvaporimetroId_EstEvaporimetro(SelectOneMenu txtEstEvaporimetroId_EstEvaporimetro) {
		this.txtEstEvaporimetroId_EstEvaporimetro = txtEstEvaporimetroId_EstEvaporimetro;
	}

	public SelectOneMenu getTxtEstPluvioId_EstPluvio() {
		return txtEstPluvioId_EstPluvio;
	}

	public void setTxtEstPluvioId_EstPluvio(SelectOneMenu txtEstPluvioId_EstPluvio) {
		this.txtEstPluvioId_EstPluvio = txtEstPluvioId_EstPluvio;
	}

	public SelectOneMenu getTxtEtapaId_Etapa() {
		return txtEtapaId_Etapa;
	}

	public void setTxtEtapaId_Etapa(SelectOneMenu txtEtapaId_Etapa) {
		this.txtEtapaId_Etapa = txtEtapaId_Etapa;
	}

	public SelectOneMenu getTxtFaseFenoId_FaseFenologica() {
		return txtFaseFenoId_FaseFenologica;
	}

	public void setTxtFaseFenoId_FaseFenologica(SelectOneMenu txtFaseFenoId_FaseFenologica) {
		this.txtFaseFenoId_FaseFenologica = txtFaseFenoId_FaseFenologica;
	}

	public SelectOneMenu getTxtFliaTextSueloId_FliaTextSuelo() {
		return txtFliaTextSueloId_FliaTextSuelo;
	}

	public void setTxtFliaTextSueloId_FliaTextSuelo(SelectOneMenu txtFliaTextSueloId_FliaTextSuelo) {
		this.txtFliaTextSueloId_FliaTextSuelo = txtFliaTextSueloId_FliaTextSuelo;
	}

	public SelectOneMenu getTxtGrupoSuelo_GrpSuelo() {
		return txtGrupoSuelo_GrpSuelo;
	}

	public void setTxtGrupoSuelo_GrpSuelo(SelectOneMenu txtGrupoSuelo_GrpSuelo) {
		this.txtGrupoSuelo_GrpSuelo = txtGrupoSuelo_GrpSuelo;
	}

	public SelectOneMenu getTxtN4Mot_N4Motivo() {
		return txtN4Mot_N4Motivo;
	}

	public void setTxtN4Mot_N4Motivo(SelectOneMenu txtN4Mot_N4Motivo) {
		this.txtN4Mot_N4Motivo = txtN4Mot_N4Motivo;
	}

	public SelectOneMenu getTxtNivel3Id_Nivel3() {
		return txtNivel3Id_Nivel3;
	}

	public void setTxtNivel3Id_Nivel3(SelectOneMenu txtNivel3Id_Nivel3) {
		this.txtNivel3Id_Nivel3 = txtNivel3Id_Nivel3;
	}

	public SelectOneMenu getTxtOcupacionId_Ocupacion() {
		return txtOcupacionId_Ocupacion;
	}

	public void setTxtOcupacionId_Ocupacion(SelectOneMenu txtOcupacionId_Ocupacion) {
		this.txtOcupacionId_Ocupacion = txtOcupacionId_Ocupacion;
	}

	public SelectOneMenu getTxtOrdenSuelo_OrdenSuelo() {
		return txtOrdenSuelo_OrdenSuelo;
	}

	public void setTxtOrdenSuelo_OrdenSuelo(SelectOneMenu txtOrdenSuelo_OrdenSuelo) {
		this.txtOrdenSuelo_OrdenSuelo = txtOrdenSuelo_OrdenSuelo;
	}

	public SelectOneMenu getTxtOrganizId_Organizacion() {
		return txtOrganizId_Organizacion;
	}

	public void setTxtOrganizId_Organizacion(SelectOneMenu txtOrganizId_Organizacion) {
		this.txtOrganizId_Organizacion = txtOrganizId_Organizacion;
	}

	public SelectOneMenu gettxtPersEmprId_persEmpr() {
		return txtPersEmprId_persEmpr;
	}

	public void settxtPersEmprId_persEmpr(SelectOneMenu txtPersEmprId_persEmpr) {
		this.txtPersEmprId_persEmpr = txtPersEmprId_persEmpr;
	}

	public SelectOneMenu getTxtSerieSueloId_SerieSuelo() {
		return txtSerieSueloId_SerieSuelo;
	}

	public void setTxtSerieSueloId_SerieSuelo(SelectOneMenu txtSerieSueloId_SerieSuelo) {
		this.txtSerieSueloId_SerieSuelo = txtSerieSueloId_SerieSuelo;
	}

	public SelectOneMenu getTxtTenenId_Tenencia() {
		return txtTenenId_Tenencia;
	}

	public void setTxtTenenId_Tenencia(SelectOneMenu txtTenenId_Tenencia) {
		this.txtTenenId_Tenencia = txtTenenId_Tenencia;
	}

	public SelectOneMenu getTxtTipoCultivoId_TipCultivo() {
		return txtTipoCultivoId_TipCultivo;
	}

	public void setTxtTipoCultivoId_TipCultivo(SelectOneMenu txtTipoCultivoId_TipCultivo) {
		this.txtTipoCultivoId_TipCultivo = txtTipoCultivoId_TipCultivo;
	}

	public SelectOneMenu getTxtTipoDrenajeId_TipoDrenaje() {
		return txtTipoDrenajeId_TipoDrenaje;
	}

	public void setTxtTipoDrenajeId_TipoDrenaje(SelectOneMenu txtTipoDrenajeId_TipoDrenaje) {
		this.txtTipoDrenajeId_TipoDrenaje = txtTipoDrenajeId_TipoDrenaje;
	}

	public SelectOneMenu getTxtTopografiaId_Topografia() {
		return txtTopografiaId_Topografia;
	}

	public void setTxtTopografiaId_Topografia(SelectOneMenu txtTopografiaId_Topografia) {
		this.txtTopografiaId_Topografia = txtTopografiaId_Topografia;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectOneMenu getTxtZonAgroec_ZonAgroec() {
		return txtZonAgroec_ZonAgroec;
	}

	public void setTxtZonAgroec_ZonAgroec(SelectOneMenu txtZonAgroec_ZonAgroec) {
		this.txtZonAgroec_ZonAgroec = txtZonAgroec_ZonAgroec;
	}

	public Calendar getTxtFechaAnalisisPostCosecha() {
		return txtFechaAnalisisPostCosecha;
	}

	public void setTxtFechaAnalisisPostCosecha(Calendar txtFechaAnalisisPostCosecha) {
		this.txtFechaAnalisisPostCosecha = txtFechaAnalisisPostCosecha;
	}

	public Calendar getTxtFechaAperturaCosecha() {
		return txtFechaAperturaCosecha;
	}

	public void setTxtFechaAperturaCosecha(Calendar txtFechaAperturaCosecha) {
		this.txtFechaAperturaCosecha = txtFechaAperturaCosecha;
	}

	public Calendar getTxtFechaAplicacionMadurante() {
		return txtFechaAplicacionMadurante;
	}

	public void setTxtFechaAplicacionMadurante(Calendar txtFechaAplicacionMadurante) {
		this.txtFechaAplicacionMadurante = txtFechaAplicacionMadurante;
	}

	public Calendar getTxtFechaCierreCosecha() {
		return txtFechaCierreCosecha;
	}

	public void setTxtFechaCierreCosecha(Calendar txtFechaCierreCosecha) {
		this.txtFechaCierreCosecha = txtFechaCierreCosecha;
	}

	public Calendar getTxtFechaCorteAnterior() {
		return txtFechaCorteAnterior;
	}

	public void setTxtFechaCorteAnterior(Calendar txtFechaCorteAnterior) {
		this.txtFechaCorteAnterior = txtFechaCorteAnterior;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaEstimadaUltimoRiego() {
		return txtFechaEstimadaUltimoRiego;
	}

	public void setTxtFechaEstimadaUltimoRiego(Calendar txtFechaEstimadaUltimoRiego) {
		this.txtFechaEstimadaUltimoRiego = txtFechaEstimadaUltimoRiego;
	}

	public Calendar getTxtFechaInactivo() {
		return txtFechaInactivo;
	}

	public void setTxtFechaInactivo(Calendar txtFechaInactivo) {
		this.txtFechaInactivo = txtFechaInactivo;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaPrimerCorte() {
		return txtFechaPrimerCorte;
	}

	public void setTxtFechaPrimerCorte(Calendar txtFechaPrimerCorte) {
		this.txtFechaPrimerCorte = txtFechaPrimerCorte;
	}

	public Calendar getTxtFechaProximoCorte() {
		return txtFechaProximoCorte;
	}

	public void setTxtFechaProximoCorte(Calendar txtFechaProximoCorte) {
		this.txtFechaProximoCorte = txtFechaProximoCorte;
	}

	public Calendar getTxtFechaSiembra() {
		return txtFechaSiembra;
	}

	public void setTxtFechaSiembra(Calendar txtFechaSiembra) {
		this.txtFechaSiembra = txtFechaSiembra;
	}

	public Calendar getTxtFechaUltimoApunteRiego() {
		return txtFechaUltimoApunteRiego;
	}

	public void setTxtFechaUltimoApunteRiego(Calendar txtFechaUltimoApunteRiego) {
		this.txtFechaUltimoApunteRiego = txtFechaUltimoApunteRiego;
	}

	public Calendar getTxtFechaUltimoCorte() {
		return txtFechaUltimoCorte;
	}

	public void setTxtFechaUltimoCorte(Calendar txtFechaUltimoCorte) {
		this.txtFechaUltimoCorte = txtFechaUltimoCorte;
	}

	public InputText getTxtNivel4Id() {
		return txtNivel4Id;
	}

	public void setTxtNivel4Id(InputText txtNivel4Id) {
		this.txtNivel4Id = txtNivel4Id;
	}

	public LazyDataModel<Nivel4DTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataNivel4();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<Nivel4DTO> nivel4DTO) {
		this.data = nivel4DTO;
	}

	public Nivel4DTO getSelectedNivel4() {
		return selectedNivel4;
	}

	public void setSelectedNivel4(Nivel4DTO nivel4) {
		this.selectedNivel4 = nivel4;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public InputText getTxtMadurante() {
		return txtMadurante;
	}

	public void setTxtMadurante(InputText txtMadurante) {
		this.txtMadurante = txtMadurante;
	}

	public SelectItem[] getSelectItemNivel3() {

		if (nivel3 == null || nivel3.size() == 0) {

			nivel3 = new ArrayList<Nivel3>();

			try {

				nivel3 = businessDelegatorView.getNivel3(); // Fin
															// by
															// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel3> lista = businessDelegatorView.findByCriteriaInNivel3(condicion, null, null);
				selectItemNivel3 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel3 n3 : lista) {
					selectItemNivel3[i] = new SelectItem(n3.getNivel3Id(), n3.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemNivel3;
	}

	public void setSelectItemNivel3(SelectItem[] selectItemNivel3) {
		this.selectItemNivel3 = selectItemNivel3;
	}

	public SelectItem[] getSelectItemAnioFiscal() {

		if (aniofiscal == null || aniofiscal.size() == 0) {

			aniofiscal = new ArrayList<AnioFiscal>();

			try {

				aniofiscal = businessDelegatorView.getAnioFiscal(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<AnioFiscal> lista = businessDelegatorView.findByCriteriaInAnioFiscal(condicion, null, null);
				selectItemAnioFiscal = new SelectItem[lista.size()];

				int i = 0;
				for (AnioFiscal af : lista) {
					selectItemAnioFiscal[i] = new SelectItem(af.getAnioFiscalId(), af.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemAnioFiscal;
	}

	public void setSelectItemAnioFiscal(SelectItem[] selectItemAnioFiscal) {
		this.selectItemAnioFiscal = selectItemAnioFiscal;
	}

	public SelectItem[] getSelectItemAlmacen() {

		if (almacen == null || almacen.size() == 0) {

			almacen = new ArrayList<Almacen>();

			try {

				almacen = businessDelegatorView.getAlmacen(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectItemAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen al : lista) {
					selectItemAlmacen[i] = new SelectItem(al.getAlmacenId(), al.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemAlmacen;
	}

	public void setSelectItemAlmacen(SelectItem[] selectItemAlmacen) {
		this.selectItemAlmacen = selectItemAlmacen;
	}

	public SelectItem[] getSelectItemPersEmpr() {

		if (persEmpr == null || persEmpr.size() == 0) {

			persEmpr = new ArrayList<PersEmpr>();

			try {

				persEmpr = businessDelegatorView.getPersEmpr(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectItemPersEmpr = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr pd : lista) {
					selectItemPersEmpr[i] = new SelectItem(pd.getPersEmprId(), pd.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemPersEmpr;
	}

	public void setSelectItemPersEmpr(SelectItem[] selectItemPersEmpr) {
		this.selectItemPersEmpr = selectItemPersEmpr;
	}

	public SelectItem[] getSelectItemTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				trabajador = businessDelegatorView.getTrabajador(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=", "profesion.funciones", true, "Supervisor", "="

				};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectItemTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador t : lista) {
					selectItemTrabajador[i] = new SelectItem(t.getTrabId(), t.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemTrabajador;
	}

	public void setSelectItemTrabajador(SelectItem[] selectItemTrabajador) {
		this.selectItemTrabajador = selectItemTrabajador;
	}

	public SelectItem[] getSelectItemTenencia() {

		if (tenencia == null || tenencia.size() == 0) {

			tenencia = new ArrayList<Tenencia>();

			try {

				tenencia = businessDelegatorView.getTenencia(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Tenencia> lista = businessDelegatorView.findByCriteriaInTenencia(condicion, null, null);
				selectItemTenencia = new SelectItem[lista.size()];

				int i = 0;
				for (Tenencia tci : lista) {
					selectItemTenencia[i] = new SelectItem(tci.getTenenId(), tci.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemTenencia;
	}

	public void setSelectItemTenencia(SelectItem[] selectItemTenencia) {
		this.selectItemTenencia = selectItemTenencia;
	}

	public SelectItem[] getSelectItemEtapa() {

		if (etapa == null || etapa.size() == 0) {

			etapa = new ArrayList<Etapa>();

			try {

				etapa = businessDelegatorView.getEtapa(); // Fin
															// by
															// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Etapa> lista = businessDelegatorView.findByCriteriaInEtapa(condicion, null, null);
				selectItemEtapa = new SelectItem[lista.size()];

				int i = 0;
				for (Etapa et : lista) {
					selectItemEtapa[i] = new SelectItem(et.getEtapaId(), et.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemEtapa;
	}

	public void setSelectItemEtapa(SelectItem[] selectItemEtapa) {
		this.selectItemEtapa = selectItemEtapa;
	}

	public SelectItem[] getSelectItemGrupoSuelo() {

		if (suelo == null || suelo.size() == 0) {

			suelo = new ArrayList<GrpSuelo>();

			try {

				suelo = businessDelegatorView.getGrpSuelo(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<GrpSuelo> lista = businessDelegatorView.findByCriteriaInGrpSuelo(condicion, null, null);
				selectItemGrupoSuelo = new SelectItem[lista.size()];

				int i = 0;
				for (GrpSuelo gs : lista) {
					selectItemGrupoSuelo[i] = new SelectItem(gs.getGrupoSuelo(), gs.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemGrupoSuelo;
	}

	public void setSelectItemGrupoSuelo(SelectItem[] selectItemGrupoSuelo) {
		this.selectItemGrupoSuelo = selectItemGrupoSuelo;
	}

	public SelectItem[] getSelectItemSerieSuelo() {

		if (ssuelo == null || ssuelo.size() == 0) {

			ssuelo = new ArrayList<SerieSuelo>();

			try {

				ssuelo = businessDelegatorView.getSerieSuelo(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<SerieSuelo> lista = businessDelegatorView.findByCriteriaInSerieSuelo(condicion, null, null);
				selectItemSerieSuelo = new SelectItem[lista.size()];

				int i = 0;
				for (SerieSuelo ss : lista) {
					selectItemSerieSuelo[i] = new SelectItem(ss.getSerieSueloId(), ss.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemSerieSuelo;
	}

	public void setSelectItemSerieSuelo(SelectItem[] selectItemSerieSuelo) {
		this.selectItemSerieSuelo = selectItemSerieSuelo;
	}

	public SelectItem[] getSelectItemOrdenSuelo() {

		if (osuelo == null || osuelo.size() == 0) {

			osuelo = new ArrayList<OrdenSuelo>();

			try {

				osuelo = businessDelegatorView.getOrdenSuelo(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<OrdenSuelo> lista = businessDelegatorView.findByCriteriaInOrdenSuelo(condicion, null, null);
				selectItemOrdenSuelo = new SelectItem[lista.size()];

				int i = 0;
				for (OrdenSuelo os : lista) {
					selectItemOrdenSuelo[i] = new SelectItem(os.getOrdenSuelo(), os.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemOrdenSuelo;
	}

	public void setSelectItemOrdenSuelo(SelectItem[] selectItemOrdenSuelo) {
		this.selectItemOrdenSuelo = selectItemOrdenSuelo;
	}

	public SelectItem[] getSelectItemFliaTexSuelo() {

		if (ftsuelo == null || ftsuelo.size() == 0) {

			ftsuelo = new ArrayList<FliaTextSuelo>();

			try {

				ftsuelo = businessDelegatorView.getFliaTextSuelo(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FliaTextSuelo> lista = businessDelegatorView.findByCriteriaInFliaTextSuelo(condicion, null, null);
				selectItemFliaTexSuelo = new SelectItem[lista.size()];

				int i = 0;
				for (FliaTextSuelo fts : lista) {
					selectItemFliaTexSuelo[i] = new SelectItem(fts.getFliaTextSueloId(), fts.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemFliaTexSuelo;
	}

	public void setSelectItemFliaTexSuelo(SelectItem[] selectItemFliaTexSuelo) {
		this.selectItemFliaTexSuelo = selectItemFliaTexSuelo;
	}

//	public SelectItem[] getSelectItemClaseTexSuelo() {
//
//		if (ctsuelo == null || ctsuelo.size() == 0) {
//
//			ctsuelo = new ArrayList<ClaseTextSuelo>();
//
//			try {
//
//				ctsuelo = businessDelegatorView.getClaseTextSuelo(); // Fin
//																		// by
//																		// Criteria
//				Object[] condicion = { "estado", true, "A", "=" };
//				List<ClaseTextSuelo> lista = businessDelegatorView.findByCriteriaInClaseTextSuelo(condicion, null,
//						null);
//				selectItemClaseTexSuelo = new SelectItem[lista.size()];
//
//				int i = 0;
//				for (ClaseTextSuelo cts : lista) {
//					selectItemClaseTexSuelo[i] = new SelectItem(cts.getClaseTextSueloId(), cts.getNombre());
//					i++;
//				}
//
//			} catch (Exception e) {
//				FacesUtils.addErrorMessage(e.getMessage());
//				e.printStackTrace();
//			}
//
//		}
//
//		return selectItemClaseTexSuelo;
//	}
//
//	public void setSelectItemClaseTexSuelo(SelectItem[] selectItemClaseTexSuelo) {
//		this.selectItemClaseTexSuelo = selectItemClaseTexSuelo;
//	}

	public SelectItem[] getSelectItemFaseFenologica() {

		if (ffenologica == null || ffenologica.size() == 0) {

			ffenologica = new ArrayList<FaseFenologica>();

			try {

				ffenologica = businessDelegatorView.getFaseFenologica(); // Fin
																			// by
																			// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FaseFenologica> lista = businessDelegatorView.findByCriteriaInFaseFenologica(condicion, null,
						null);
				selectItemFaseFenologica = new SelectItem[lista.size()];

				int i = 0;
				for (FaseFenologica ff : lista) {
					selectItemFaseFenologica[i] = new SelectItem(ff.getFaseFenoId(), ff.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemFaseFenologica;
	}

	public void setSelectItemFaseFenologica(SelectItem[] selectItemFaseFenologica) {
		this.selectItemFaseFenologica = selectItemFaseFenologica;
	}

	public SelectItem[] getSelectItemTipoCultivo() {

		if (tcultivo == null || tcultivo.size() == 0) {

			tcultivo = new ArrayList<TipCultivo>();

			try {

				tcultivo = businessDelegatorView.getTipCultivo(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipCultivo> lista = businessDelegatorView.findByCriteriaInTipCultivo(condicion, null, null);
				selectItemTipoCultivo = new SelectItem[lista.size()];

				int i = 0;
				for (TipCultivo tc : lista) {
					selectItemTipoCultivo[i] = new SelectItem(tc.getTipoCultivoId(), tc.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemTipoCultivo;
	}

	public void setSelectItemTipoCultivo(SelectItem[] selectItemTipoCultivo) {
		this.selectItemTipoCultivo = selectItemTipoCultivo;
	}

	public SelectItem[] getSelectItemOcupacion() {

		if (ocupacion == null || ocupacion.size() == 0) {

			ocupacion = new ArrayList<Ocupacion>();

			try {

				ocupacion = businessDelegatorView.getOcupacion(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Ocupacion> lista = businessDelegatorView.findByCriteriaInOcupacion(condicion, null, null);
				selectItemOcupacion = new SelectItem[lista.size()];

				int i = 0;
				for (Ocupacion op : lista) {
					selectItemOcupacion[i] = new SelectItem(op.getOcupacionId(), op.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemOcupacion;
	}

	public void setSelectItemOcupacion(SelectItem[] selectItemOcupacion) {
		this.selectItemOcupacion = selectItemOcupacion;
	}

	public SelectItem[] getSelectItemOrganizacion() {

		if (organizacion == null || organizacion.size() == 0) {

			organizacion = new ArrayList<Organizacion>();

			try {

				organizacion = businessDelegatorView.getOrganizacion(); // Fin
																		// by
																		// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Organizacion> lista = businessDelegatorView.findByCriteriaInOrganizacion(condicion, null, null);
				selectItemOrganizacion = new SelectItem[lista.size()];

				int i = 0;
				for (Organizacion og : lista) {
					selectItemOrganizacion[i] = new SelectItem(og.getOrganizId(), og.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemOrganizacion;
	}

	public void setSelectItemOrganizacion(SelectItem[] selectItemOrganizacion) {
		this.selectItemOrganizacion = selectItemOrganizacion;
	}

//	public SelectItem[] getSelectItemTopografia() {
//
//		if (topografia == null || topografia.size() == 0) {
//
//			topografia = new ArrayList<Topografia>();
//
//			try {
//
//				topografia = businessDelegatorView.getTopografia(); // Fin
//																	// by
//																	// Criteria
//				Object[] condicion = { "estado", true, "A", "=" };
//				List<Topografia> lista = businessDelegatorView.findByCriteriaInTopografia(condicion, null, null);
//				selectItemTopografia = new SelectItem[lista.size()];
//
//				int i = 0;
//				for (Topografia tp : lista) {
//					selectItemTopografia[i] = new SelectItem(tp.getTopografiaId(), tp.getNombre());
//					i++;
//				}
//
//			} catch (Exception e) {
//				FacesUtils.addErrorMessage(e.getMessage());
//				e.printStackTrace();
//			}
//
//		}
//
//		return selectItemTopografia;
//	}
//
//	public void setSelectItemTopografia(SelectItem[] selectItemTopografia) {
//		this.selectItemTopografia = selectItemTopografia;
//	}

	public SelectItem[] getSelectItemN4Motivo() {

		if (n4motivo == null || n4motivo.size() == 0) {

			n4motivo = new ArrayList<N4Motivo>();

			try {

				n4motivo = businessDelegatorView.getN4Motivo(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<N4Motivo> lista = businessDelegatorView.findByCriteriaInN4Motivo(condicion, null, null);
				selectItemN4Motivo = new SelectItem[lista.size()];

				int i = 0;
				for (N4Motivo n4m : lista) {
					selectItemN4Motivo[i] = new SelectItem(n4m.getN4Mot(), n4m.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemN4Motivo;
	}

	public void setSelectItemN4Motivo(SelectItem[] selectItemN4Motivo) {
		this.selectItemN4Motivo = selectItemN4Motivo;
	}

	public SelectItem[] getSelectItemZonAgroec() {

		if (zagroec == null || zagroec.size() == 0) {

			zagroec = new ArrayList<ZonAgroec>();

			try {

				zagroec = businessDelegatorView.getZonAgroec(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ZonAgroec> lista = businessDelegatorView.findByCriteriaInZonAgroec(condicion, null, null);
				selectItemZonAgroec = new SelectItem[lista.size()];

				int i = 0;
				for (ZonAgroec z : lista) {
					selectItemZonAgroec[i] = new SelectItem(z.getZonAgroec(), z.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemZonAgroec;
	}

	public void setSelectItemZonAgroec(SelectItem[] selectItemZonAgroec) {
		this.selectItemZonAgroec = selectItemZonAgroec;
	}

	public SelectItem[] getSelectItemEstClimat() {

		if (estclimat == null || estclimat.size() == 0) {

			estclimat = new ArrayList<EstClimat>();

			try {

				estclimat = businessDelegatorView.getEstClimat(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstClimat> lista = businessDelegatorView.findByCriteriaInEstClimat(condicion, null, null);
				selectItemEstClimat = new SelectItem[lista.size()];

				int i = 0;
				for (EstClimat clim : lista) {
					selectItemEstClimat[i] = new SelectItem(clim.getEstClimatId(), clim.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemEstClimat;
	}

	public void setSelectItemEstClimat(SelectItem[] selectItemEstClimat) {
		this.selectItemEstClimat = selectItemEstClimat;
	}

	public SelectItem[] getSelectItemEstEvaporimetro() {

		if (estEvaporimetro == null || estEvaporimetro.size() == 0) {

			estEvaporimetro = new ArrayList<EstEvaporimetro>();

			try {

				estEvaporimetro = businessDelegatorView.getEstEvaporimetro(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstEvaporimetro> lista = businessDelegatorView.findByCriteriaInEstEvaporimetro(condicion, null,
						null);
				selectItemEstEvaporimetro = new SelectItem[lista.size()];

				int i = 0;
				for (EstEvaporimetro eva : lista) {
					selectItemEstEvaporimetro[i] = new SelectItem(eva.getEstEvaporimetroId(), eva.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemEstEvaporimetro;
	}

	public void setSelectItemEstEvaporimetro(SelectItem[] selectItemEstEvaporimetro) {
		this.selectItemEstEvaporimetro = selectItemEstEvaporimetro;
	}

	public SelectItem[] getSelectItemEstPluvio() {

		if (estPluvio == null || estPluvio.size() == 0) {

			estPluvio = new ArrayList<EstPluvio>();

			try {

				estPluvio = businessDelegatorView.getEstPluvio(); // Fin
																	// by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstPluvio> lista = businessDelegatorView.findByCriteriaInEstPluvio(condicion, null, null);
				selectItemEstPluvio = new SelectItem[lista.size()];

				int i = 0;
				for (EstPluvio plu : lista) {
					selectItemEstPluvio[i] = new SelectItem(plu.getEstPluvioId(), plu.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemEstPluvio;
	}

	public void setSelectItemEstPluvio(SelectItem[] selectItemEstPluvio) {
		this.selectItemEstPluvio = selectItemEstPluvio;
	}

	public SelectItem[] getSelectItemTipoDrenaje() {

		if (tipoDrenaje == null || tipoDrenaje.size() == 0) {

			tipoDrenaje = new ArrayList<TipoDrenaje>();

			try {

				tipoDrenaje = businessDelegatorView.getTipoDrenaje(); // Fin
																		// by
																		// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoDrenaje> lista = businessDelegatorView.findByCriteriaInTipoDrenaje(condicion, null, null);
				selectItemTipoDrenaje = new SelectItem[lista.size()];

				int i = 0;
				for (TipoDrenaje tdre : lista) {
					selectItemTipoDrenaje[i] = new SelectItem(tdre.getTipoDrenajeId(), tdre.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemTipoDrenaje;
	}

	public void setSelectItemTipoDrenaje(SelectItem[] selectItemTipoDrenaje) {
		this.selectItemTipoDrenaje = selectItemTipoDrenaje;
	}

	public List<String> getRestriccionDeQuema() {
		return restriccionDeQuema;
	}

	public void setRestriccionDeQuema(List<String> restriccionDeQuema) {
		this.restriccionDeQuema = restriccionDeQuema;
	}
/*
	public List<RestrQuema> getSelectItemRestriccionQuema() {

		if (selectItemRestriccionQuema == null || selectItemRestriccionQuema.size() == 0) {

			selectItemRestriccionQuema = new ArrayList<RestrQuema>();

			try {
				selectItemRestriccionQuema = businessDelegatorView.getRestrQuema();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemRestriccionQuema;
	}
*/
	public void setSelectItemRestriccionQuema(List<RestrQuema> selectItemRestriccionQuema) {
		this.selectItemRestriccionQuema = selectItemRestriccionQuema;
	}

	public List<String> getRestriccionDeMadurante() {
		return restriccionDeMadurante;
	}

	public void setRestriccionDeMadurante(List<String> restriccionDeMadurante) {
		this.restriccionDeMadurante = restriccionDeMadurante;
	}
/*
	public List<RestrMadurante> getSelectItemRestriccionMadurante() {

		if (selectItemRestriccionMadurante == null || selectItemRestriccionMadurante.size() == 0) {

			selectItemRestriccionMadurante = new ArrayList<RestrMadurante>();

			try {
				selectItemRestriccionMadurante = businessDelegatorView.getRestrMadurante();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemRestriccionMadurante;
	}*/

	public void setSelectItemRestriccionMadurante(List<RestrMadurante> selectItemRestriccionMadurante) {
		this.selectItemRestriccionMadurante = selectItemRestriccionMadurante;
	}

	public SelectItem[] getSelectItemVariedad() {

		if (variedad == null || variedad.size() == 0) {

			variedad = new ArrayList<Variedad>();

			try {

				variedad = businessDelegatorView.getVariedad(); // Fin
																// by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Variedad> lista = businessDelegatorView.findByCriteriaInVariedad(condicion, null, null);
				selectItemVariedad = new SelectItem[lista.size()];

				int i = 0;
				for (Variedad v : lista) {
					selectItemVariedad[i] = new SelectItem(v.getVariedId(), v.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemVariedad;
	}

	public void setSelectItemVariedad(SelectItem[] selectItemVariedad) {
		this.selectItemVariedad = selectItemVariedad;
	}

	public SelectOneMenu getTxtVaiedadId_VariedadId() {
		return txtVaiedadId_VariedadId;
	}

	public void setTxtVaiedadId_VariedadId(SelectOneMenu txtVaiedadId_VariedadId) {
		this.txtVaiedadId_VariedadId = txtVaiedadId_VariedadId;
	}

	public InputText getTxtPorcentajeArea() {
		return txtPorcentajeArea;
	}

	public void setTxtPorcentajeArea(InputText txtPorcentajeArea) {
		this.txtPorcentajeArea = txtPorcentajeArea;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<VariedadNivel4DTO> getDataVariedad() {

		if (dataVariedad == null || dataVariedad.size() == 0) {
			return null;
		} else {
			return dataVariedad;
		}

	}

	public void setDataVariedad(List<VariedadNivel4DTO> dataVariedad) {
		this.dataVariedad = dataVariedad;
	}

	public String actionDeleteVariedadNivel4(ActionEvent evt) {
		try {
			selectedVariedad = (VariedadNivel4DTO) (evt.getComponent().getAttributes().get("selectedVariedad"));

			if (selectedVariedad.getVariedadNivel4Id() == null) {
				dataVariedad.remove(selectedVariedad);
			} else {
				Long variedadNivel4Id = new Long(selectedVariedad.getVariedadNivel4Id());
				VariedadNivel4 entity = businessDelegatorView.getVariedadNivel4(variedadNivel4Id);
				businessDelegatorView.deleteVariedadNivel4(entity);
				dataVariedad.remove(selectedVariedad);
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_agregarVariedadNivel4() throws Exception {
		Long nivel4Id = Long.parseLong(txtNivel4Id.getValue().toString());
		Long variedadId = Long.parseLong(txtVaiedadId_VariedadId.getValue().toString());
		Variedad variedad = businessDelegatorView.getVariedad(variedadId);
		String nombreVariedad = FacesUtils.checkString(txtNombreVariedad);

		Double porcentaje = FacesUtils.checkDouble(txtPorcentajeArea);

		boolean existeProducto = false;

		if (dataVariedad == null || dataVariedad.size() == 0) {
			dataVariedad = new ArrayList<VariedadNivel4DTO>();
		}

		if (dataVariedad.size() > 0) {

			for (VariedadNivel4DTO v : dataVariedad) {

				if (v.getVariedId_Variedad().getVariedId().longValue() == variedadId.longValue()) {

					existeProducto = true;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
									"La Varided " + v.getVariedadNivel4Id()
											+ " ya fue agregado a la lista, por favor seleccione otro. "));

					break;

				}
			}
		}

		if (existeProducto == false) {

			VariedadNivel4DTO variedadNivel4DTO = new VariedadNivel4DTO();
			variedadNivel4DTO.setVariedId_Variedad(variedad);
			variedadNivel4DTO.setNombreVariedad(nombreVariedad);
			variedadNivel4DTO.setPorcentajeArea(porcentaje);
			variedadNivel4DTO.setNivel4Id_Nivel4(nivel4Id);
			dataVariedad.add(variedadNivel4DTO);

		}

		variedad = null;
		porcentaje = null;
		nivel4Id = null;
		nombreVariedad = null;
	}

	public Long consultarFaseFenologicaId() {
		// Long compania = 1L;
		Date fechaDescanso = FacesUtils.checkDate(txtFechaDescanso);
		Long idFase = 0L;
		String nombreFase = "";
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		if (fechaDescanso != null) {
			try {

				idFase = businessDelegatorView.consultarFaseFenologicaId(fechaDescanso);
				String format = decimalFormat.format(idFase);
				txtFaseFenoId_FaseFenologica.setValue(format);

				if (idFase == null) {
					return null;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
		}
		return idFase;
	}

	public String consultarFaseFenologica() {
		// Long compania = 1L;
		Date fechaDescanso = FacesUtils.checkDate(txtFechaDescanso);
		Long faseFenologica = FacesUtils.checkLong(txtFaseFenoId_FaseFenologica);
		Long idFase = 0L;
		String nombreFase = "";
		if (fechaDescanso != null && faseFenologica != null && faseFenologica != 0) {
			try {

				nombreFase = businessDelegatorView.consultarFaseFenologica(faseFenologica, fechaDescanso);
				if (nombreFase == null || nombreFase.isEmpty()) {
					return "No se encontro un rango definido";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
		}
		return nombreFase;
	}

	public void listener_calcularAreaNeta() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Double areaBruta = 0.0;
		Double areaInutil = 0.0;
		Double areaOtrosCultivos = 0.0;
		Double areaReservada = 0.0;
		Double areaRestringida = 0.0;

		if (FacesUtils.checkDouble(getTxtAreaBruta()) != null) {
			areaBruta = FacesUtils.checkDouble(getTxtAreaBruta());

		}
		if (FacesUtils.checkDouble(getTxtAreaInutil()) != null) {
			areaInutil = FacesUtils.checkDouble(getTxtAreaInutil());

		}
		if (FacesUtils.checkDouble(getTxtAreaOtrosCultivos()) != null) {
			areaOtrosCultivos = FacesUtils.checkDouble(getTxtAreaOtrosCultivos());

		}
		if (FacesUtils.checkDouble(getTxtAreaReservada()) != null) {
			areaReservada = FacesUtils.checkDouble(getTxtAreaReservada());

		}

		if (FacesUtils.checkDouble(getTxtAreaRestringida()) != null) {
			areaRestringida = FacesUtils.checkDouble(getTxtAreaRestringida());
		}
		Double areaneta = areaBruta - (areaInutil + areaOtrosCultivos + areaReservada + areaRestringida);
		String format = decimalFormat.format(areaneta);
		txtAreaNeta.setValue(format);
	}

	private class LocalDataModelDTO extends LazyDataModel<Nivel4DTO> {
		private static final long serialVersionUID = 1L;
		private List<Nivel4DTO> nivel4DTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<Nivel4DTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				nivel4DTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberNivel4(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return nivel4DTO;

		}

		@Override
		public Nivel4DTO getRowData(String rowKey) {
			for (Nivel4DTO nivel4DTOtmp : nivel4DTO) {
				if (nivel4DTOtmp.getNivel4Id().toString().equals(rowKey))
					return nivel4DTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(Nivel4DTO nivel4DTOtmp) {
			return nivel4DTOtmp.getNivel4Id();
		}

	}

	private List<Nivel4DTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageNivel4(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SelectItem[] getSelectDistanciaSiembra() {

		if (espacioLineasSembradas == null || espacioLineasSembradas.size() == 0) {

			espacioLineasSembradas = new ArrayList<DistSiembra>();

			try {

				espacioLineasSembradas = businessDelegatorView.getDistSiembra(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<DistSiembra> lista = businessDelegatorView.findByCriteriaInDistSiembra(condicion, null, null);
				selectDistanciaSiembra = new SelectItem[lista.size()];

				int i = 0;
				for (DistSiembra eva : lista) {
					selectDistanciaSiembra[i] = new SelectItem(eva.getDistSiembraId(), eva.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectDistanciaSiembra;
	}

	public void setSelectDistanciaSiembra(SelectItem[] selectDistanciaSiembra) {
		this.selectDistanciaSiembra = selectDistanciaSiembra;
	}

	public InputText getTxtNombreVariedad() {
		return txtNombreVariedad;
	}

	public void setTxtNombreVariedad(InputText txtNombreVariedad) {
		this.txtNombreVariedad = txtNombreVariedad;
	}

	public Calendar getTxtFechaDescanso() {
		return txtFechaDescanso;
	}

	public void setTxtFechaDescanso(Calendar txtFechaDescanso) {
		this.txtFechaDescanso = txtFechaDescanso;
	}

	public SelectOneMenu getTxtSistemaRiegoId_SistemaRiego() {
		return txtSistemaRiegoId_SistemaRiego;
	}

	public void setTxtSistemaRiegoId_SistemaRiego(SelectOneMenu txtSistemaRiegoId_SistemaRiego) {
		this.txtSistemaRiegoId_SistemaRiego = txtSistemaRiegoId_SistemaRiego;
	}

	public SelectItem[] getselectSistemaRiego() {

		if (sistemaRiego == null || sistemaRiego.size() == 0) {

			sistemaRiego = new ArrayList<SistemaRiego>();

			try {

				sistemaRiego = businessDelegatorView.getSistemaRiego(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemaRiego> lista = businessDelegatorView.findByCriteriaInSistemaRiego(condicion, null, null);
				selectSistemaRiego = new SelectItem[lista.size()];

				int i = 0;
				for (SistemaRiego sistemaRiego : lista) {
					selectSistemaRiego[i] = new SelectItem(sistemaRiego.getSistemaRiegoId(), sistemaRiego.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSistemaRiego;
	}

	public void setSelectSistemaRiego(SelectItem[] selectSistemaRiego) {
		this.selectSistemaRiego = selectSistemaRiego;
	}

	public SelectOneMenu getTxtVariedadId() {
		return txtVariedadId;
	}

	public void setTxtVariedadId(SelectOneMenu txtVariedadId) {
		this.txtVariedadId = txtVariedadId;
	}

	public SelectItem[] getselectVariedadId() {

		if (variedadId == null || variedadId.size() == 0) {

			variedadId = new ArrayList<Variedad>();

			try {

				variedadId = businessDelegatorView.getVariedad(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Variedad> lista = businessDelegatorView.findByCriteriaInVariedad(condicion, null, null);
				selectVariedadId = new SelectItem[lista.size()];

				int i = 0;
				for (Variedad VariedadId : lista) {
					selectVariedadId[i] = new SelectItem(VariedadId.getVariedId(), VariedadId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectVariedadId;
	}

	public void setSelectVariedadId(SelectItem[] selectVariedadId) {
		this.selectVariedadId = selectVariedadId;
	}

	public Calendar getTxtFechaStart() {
		return txtFechaStart;
	}

	public void setTxtFechaStart(Calendar txtFechaStart) {
		this.txtFechaStart = txtFechaStart;
	}

	public InputText getTxtVacunosIniciales() {
		return txtVacunosIniciales;
	}

	public void setTxtVacunosIniciales(InputText txtVacunosIniciales) {
		this.txtVacunosIniciales = txtVacunosIniciales;
	}

	public InputText getTxtVacunosActuales() {
		return txtVacunosActuales;
	}

	public void setTxtVacunosActuales(InputText txtVacunosActuales) {
		this.txtVacunosActuales = txtVacunosActuales;
	}

	public InputText getTxtCodigoAlternativo() {
		return txtCodigoAlternativo;
	}

	public void setTxtCodigoAlternativo(InputText txtCodigoAlternativo) {
		this.txtCodigoAlternativo = txtCodigoAlternativo;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the txtNumTonHaUltCosecha
	 */
	public InputText getTxtNumTonHaUltCosecha() {
		return txtNumTonHaUltCosecha;
	}

	/**
	 * @param txtNumTonHaUltCosecha the txtNumTonHaUltCosecha to set
	 */
	public void setTxtNumTonHaUltCosecha(InputText txtNumTonHaUltCosecha) {
		this.txtNumTonHaUltCosecha = txtNumTonHaUltCosecha;
	}

	/**
	 * @return the txtNumTonHaMesUltCosecha
	 */
	public InputText getTxtNumTonHaMesUltCosecha() {
		return txtNumTonHaMesUltCosecha;
	}

	/**
	 * @param txtNumTonHaMesUltCosecha the txtNumTonHaMesUltCosecha to set
	 */
	public void setTxtNumTonHaMesUltCosecha(InputText txtNumTonHaMesUltCosecha) {
		this.txtNumTonHaMesUltCosecha = txtNumTonHaMesUltCosecha;
	}

	public SelectOneMenu getTxtPersEmprId_persEmpr() {
		return txtPersEmprId_persEmpr;
	}

	public void setTxtPersEmprId_persEmpr(SelectOneMenu txtPersEmprId_persEmpr) {
		this.txtPersEmprId_persEmpr = txtPersEmprId_persEmpr;
	}

	
}
