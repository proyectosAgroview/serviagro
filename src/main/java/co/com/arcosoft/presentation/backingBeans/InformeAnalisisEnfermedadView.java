package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.map.MapModel;
//import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gisfaces.model.graphic.Graphic;
import com.gisfaces.model.graphic.GraphicsModel;
import com.gisfaces.model.graphic.PictureMarkerGraphic;
import com.gisfaces.model.map.Background;
import com.gisfaces.model.map.Coordinate;
import com.jsf2leaf.model.Circle;
import com.jsf2leaf.model.LatLong;
import com.jsf2leaf.model.Layer;
import com.jsf2leaf.model.Map;
import com.jsf2leaf.model.Marker;
import com.jsf2leaf.model.Polyline;
import com.jsf2leaf.model.Pulse;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.AnalisisEnfermedadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class InformeAnalisisEnfermedadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeAnalisisEnfermedadView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<AnalisisEnfermedadDTO> analisisEnfermedad;

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	private List<String> selectedNivel1;
	private List<Nivel1> zonas;

	private List<String> selectedNivel2;
	private List<Nivel2> fincas;

	private List<String> selectedNivel3;
	private List<Nivel3> bloques;

	private List<String> selectedNivel4;
	private List<Nivel4> lotes;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private List<String> selectedFitosanidad;
	private List<Fitosanidad> fitosanidades;

	/* Mapas GMPAS */
	private MapModel advancedModel;
	//private Marker marker;
	private String centerRevGeoMap;

	private double latitude;
	private double longitude;
	private String latitudeTmp;
	private String longitudeTmp;

	// Informacion del infoWindow
	private String linea = "";
	private String palma = "";
	private String nombreEnfermedad = "";
	BigDecimal gradoSeveridad;
	String evolucion = "";

	// Gisfaces
	private GraphicsModel graphicsModel;
	private String background;
	private int zoom;
	private double opacity;
	private boolean visible;
	private String where;
	private String kml_url;
	private String estado_kml;

	private String visibilityIndex0 = "none";
	private String visibilityIndex1 = "none";
	
	Long companiaIdSession = 0L;
	Long companiaIdView = 0L;


	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;
	
	private Map springfieldMap = new Map();
	


	public Map getSpringfieldMap() {
		return springfieldMap;
	}

	public void setSpringfieldMap(Map springfieldMap) {
		this.springfieldMap = springfieldMap;
	}

	public InformeAnalisisEnfermedadView() {
		super();
		//inicializarConfiguracionMapa();
	}
	
	public void inicializarConfiguracionMapa() {

		this.background = "streets";
		this.zoom = 4;
		this.opacity = 1.0;
		this.visible = true;
		this.where = "MAGNITUDE >= 2";
		this.latitude = 3.6374489;
		this.longitude = -76.2900103;
		this.centerRevGeoMap = latitude + "," + longitude;
		this.estado_kml = "I";
		this.kml_url = "https://sites.google.com/site/repoagroviewkml/kml_files/Lotes_HLG.kml";
	}
	
	
	@PostConstruct
	public void init()
	{
		inicializarConfiguracionMapa();
	}
	
	
	public void leafConfiguracionesMap() {
		
		//Configure Map
				springfieldMap.setWidth("350px").setHeight("250px").setCenter(new LatLong("42.111707","-72.541008")).setZoom(13);
		                springfieldMap.setAttribution("JSF2Leaf | Your business");
		                springfieldMap.setMiniMap(true);
		                springfieldMap.setMiniMapWidth(100);
		                springfieldMap.setMiniMapHeight(66);
		                springfieldMap.setMiniMapPosition("bottomright");

		                

				//Places Layer
				Layer placesLayer = (new Layer()).setLabel("Places");
				placesLayer.addMarker(new Marker(new LatLong("42.120000","-72.540000"),"<b>Krusty Burger</b><br>Phone: 555-5555"));
				placesLayer.addMarker(new Marker(new LatLong("42.114556","-72.526309"),"<b>Elementary School</b><br>Skinner&#39;s Phone: 555-5555"));
				placesLayer.addMarker(new Marker(new LatLong("42.120286","-72.547488"),"<b>Hospital</b><br>Dr. Hibbert lol", new Pulse(true, 10, "#ff0000")));
				springfieldMap.addLayer(placesLayer);
				
				//Cluster Layer
				Layer clusterLayer = (new Layer()).setLabel("Cluster").setClusterEnabled(true);
				for(double lat=42; lat<43; lat+=0.0001)	//10k markers !
					clusterLayer.addMarker(new Marker(new LatLong(""+lat,"-72.547488"),lat+" -72.547488"));
				springfieldMap.addLayer(clusterLayer);
				
				//Polyline and Circle Layer
				Layer polycircleLayer = (new Layer()).setLabel("Polyline/Circle");
				polycircleLayer.addPolyline((new Polyline()).addPoint(new LatLong("42.114556","-72.526309")).addPoint(new LatLong("42.120000","-72.540000")).addPoint(new LatLong("42.120286","-72.547488")));
				polycircleLayer.addCircle((new Circle()).setPosition(new LatLong("42.111707","-72.541008")));
				springfieldMap.addLayer(polycircleLayer);
		
		
		
	}

	public List<SelectItem> getBackgrounds() {
		return Background.getSelectItems();
	}

	public void itemSelect(ItemSelectEvent event) {

		setShowDialog(true);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public String getLoginUserSession() throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;

		if (auth != null) {

			login = auth.getName();

		} else {

			throw new Exception("No user logged in ");

		}

		return login;
	}

	public Long getCompaniaIdUserSession() throws Exception {

		Long compania = null;
		Object[] condicion = { "login", true, getLoginUserSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			compania = u.get(0).getCompania().getCompaniaId();
		}

		return compania;
	}

	public void inicializarConfiguracionesCompania() throws Exception {

		Compania compania = null;
		Long companiaId = null;

		Object[] condicion = { "login", true, getLoginUserSession(), "=" };
		List<Usuarios> u = null;
		try {
			u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (u != null) {
			companiaId = u.get(0).getCompania().getCompaniaId();
		}

		try {
			compania = businessDelegatorView.getCompania(companiaId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.estado_kml = compania.getEstadoKml().toString();
		this.kml_url = compania.getUrlKml().toString();

		if (this.estado_kml.equals("A")) {
			visibilityIndex0 = "block";
			visibilityIndex1 = "none";
		} else {
  			visibilityIndex0 = "none";
			visibilityIndex1 = "block";
			this.kml_url = "https://sites.google.com/site/repoagroviewkml/kml_files/Lotes_HLG.kml";
		}

		if (compania.getLatitud() !=null && compania.getLongitud() != null) {

			if (compania.getLatitud() != 0.0 && compania.getLongitud() != 0.0) {
	
				this.latitude = compania.getLatitud();
				this.longitude = compania.getLongitud();
	
			} else {
	
				this.latitude = 3.6374489;
				this.longitude = -76.2900103;
			}
			
		}else{
			
			
			this.latitude = 3.6374489;
			this.longitude = -76.2900103;
			
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
					"Lo sentimos no hay información de latitude y longitud en la compañia seleccionada."));
			
		}

		this.background = "streets";
		this.zoom = 10;
		this.opacity = 1.0;
		this.visible = true;
		this.where = "MAGNITUDE >= 2";
		this.centerRevGeoMap = latitude + "," + longitude;
		//this.kml_url = "https://sites.google.com/site/repoagroviewkml/kml_files/Lotes_HLG.kml";

	}

	public void cargarConfiguracionMapa(Long companiaId) throws Exception, Exception {

		Compania compania = null;
		compania = businessDelegatorView.getCompania(companiaId);

		this.estado_kml = compania.getEstadoKml().toString();
		
		if (this.estado_kml.equals("A")) {

			this.kml_url = compania.getUrlKml().toString();
			
			this.visibilityIndex0 = "block";
			this.visibilityIndex1 = "none";

		}

		/*if (this.estado_kml.equals("A")) {

			this.kml_url = compania.getUrlKml().toString();
			
			this.visibilityIndex0 = "block";
			this.visibilityIndex1 = "none";

		} else {
			
			this.visibilityIndex0 = "block";
			this.visibilityIndex1 = "none";
			//this.kml_url = "https://sites.google.com/site/repoagroviewkml/kml_files/Lotes_HLG.kml";
		}*/

		if (compania.getLatitud() !=null && compania.getLongitud() != null) {

			if (compania.getLatitud() != 0.0 && compania.getLongitud() != 0.0) {
	
				this.latitude = compania.getLatitud();
				this.longitude = compania.getLongitud();
	
			} else {
	
				this.latitude = 3.6374489;
				this.longitude = -76.2900103;
			}
			
		}else{
			
			
			this.latitude = 3.6374489;
			this.longitude = -76.2900103;
			
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
					"Lo sentimos no hay información de latitude y longitud en la compañia seleccionada."));
			
		}

		this.background = "streets";
		this.zoom = 10;
		this.opacity = 1.0;
		this.visible = true;
		this.where = "MAGNITUDE >= 2";
		this.centerRevGeoMap = latitude + "," + longitude;
		
	}

	public String action_consultar() throws Exception {

		companiaIdView = FacesUtils.checkLong(txtCompania);
		companiaIdSession = getCompaniaIdUserSession();

		if (companiaIdView != null && companiaIdView.longValue() != companiaIdSession.longValue()) {
			cargarConfiguracionMapa(companiaIdView);

		} else {
			cargarConfiguracionMapa(companiaIdSession);
		}
		
		getAnalisisEnfermedadesGisFaces();

		return "";
	}

	public void getAnalisisEnfermedadesGisFaces() throws Exception, Exception {
	
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		Long compania = 0L;
		Long flagZona = 1L;
		Long flagFinca = 1L;
		Long flagBloque = 1L;
		Long flagLote = 1L;
		Long flagEnfermedad = 1L;

		String zonasSeleccionadas = "";
		if (selectedNivel1 != null && selectedNivel1.size() > 0) {
			zonasSeleccionadas = selectedNivel1.get(0);
			flagZona = 0L;
			for (int i = 1; i < selectedNivel1.size(); i++) {
				zonasSeleccionadas += "," + selectedNivel1.get(i);
			}
		}

		String fincasSeleccionadas = "";
		if (selectedNivel2 != null && selectedNivel2.size() > 0) {
			fincasSeleccionadas = selectedNivel2.get(0);
			flagFinca = 0L;
			for (int i = 1; i < selectedNivel2.size(); i++) {
				fincasSeleccionadas += "," + selectedNivel2.get(i);
			}
		}

		String bloquesSeleccionadas = "";
		if (selectedNivel3 != null && selectedNivel3.size() > 0) {
			bloquesSeleccionadas = selectedNivel3.get(0);
			flagBloque = 0L;
			for (int i = 1; i < selectedNivel3.size(); i++) {
				bloquesSeleccionadas += "," + selectedNivel3.get(i);
			}
		}

		String lotesSeleccionadas = "";
		if (selectedNivel4 != null && selectedNivel4.size() > 0) {
			lotesSeleccionadas = selectedNivel4.get(0);
			flagLote = 0L;
			for (int i = 1; i < selectedNivel4.size(); i++) {
				lotesSeleccionadas += "," + selectedNivel4.get(i);
			}
		}

		String enfermedadesSeleccionadas = "";
		if (selectedFitosanidad != null && selectedFitosanidad.size() > 0) {
			enfermedadesSeleccionadas = selectedFitosanidad.get(0);
			flagEnfermedad = 0L;
			for (int i = 1; i < selectedFitosanidad.size(); i++) {
				enfermedadesSeleccionadas += "," + selectedFitosanidad.get(i);
			}
		}

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		if(companiaIdView !=null) {
			compania = companiaIdView;
			cargarConfiguracionMapa(compania);
		}else {
			compania = companiaIdSession;
		}

		Long contador = 0L;
		BigDecimal lineaTmp;
		BigDecimal palmaTmp;
		BigDecimal gradoSeveridadTmp;
		String evolucionTmp = "";

		String nombreEnfermedadTmp = "";
		String icon = "";

		this.graphicsModel = new GraphicsModel();
		this.graphicsModel.setName("Información de plantas");
		List<Graphic> graphics = this.graphicsModel.getGraphics();

		try {

			analisisEnfermedad = businessDelegatorView.consultarAnalisisEnfermedad(compania, fechaInicial, fechaFinal,
					zonasSeleccionadas, flagZona, fincasSeleccionadas, flagFinca, bloquesSeleccionadas, flagBloque,
					lotesSeleccionadas, flagLote, enfermedadesSeleccionadas, flagEnfermedad);

			if (analisisEnfermedad != null && analisisEnfermedad.size() > 0) {

				for (AnalisisEnfermedadDTO analisisEnfermedadDTO : analisisEnfermedad) {

					if (analisisEnfermedadDTO.getEvolucion() != null) {

						lineaTmp = analisisEnfermedadDTO.getLinea();
						palmaTmp = analisisEnfermedadDTO.getPlanta();
						nombreEnfermedadTmp = analisisEnfermedadDTO.getNombreEnfermedad().toString();

						evolucionTmp = analisisEnfermedadDTO.getEvolucion().toString();
						gradoSeveridadTmp = analisisEnfermedadDTO.getGradoSeveridad();

						analisisEnfermedadDTO.setEvolucion(evolucionTmp);
						analisisEnfermedadDTO.setGradoSeveridad(gradoSeveridadTmp);

						analisisEnfermedadDTO.setLinea(lineaTmp);
						analisisEnfermedadDTO.setPlanta(palmaTmp);
						analisisEnfermedadDTO.setNombreEnfermedad(nombreEnfermedadTmp);

						icon = contextPath + "/images/Market_Tratamientos.png";

					} else {

						lineaTmp = analisisEnfermedadDTO.getLinea();
						palmaTmp = analisisEnfermedadDTO.getPlanta();
						nombreEnfermedadTmp = analisisEnfermedadDTO.getNombreEnfermedad().toString();

						analisisEnfermedadDTO.setLinea(lineaTmp);
						analisisEnfermedadDTO.setPlanta(palmaTmp);
						analisisEnfermedadDTO.setNombreEnfermedad(nombreEnfermedadTmp);

						icon = contextPath + "/images/Market_Enfermedad.png";
					}

					if (analisisEnfermedadDTO.getLatitud() != null && analisisEnfermedadDTO.getLongitud() != null) {

						// informacion del maker

						linea = analisisEnfermedadDTO.getLinea().toString();
						palma = analisisEnfermedadDTO.getPlanta().toString();
						nombreEnfermedad = analisisEnfermedadDTO.getNombreEnfermedad().toString();
						evolucion = analisisEnfermedadDTO.getEvolucion().toString();
						gradoSeveridad = analisisEnfermedadDTO.getGradoSeveridad();

						graphics.add(buildGisfacesMarker(analisisEnfermedadDTO.getLatitud(),
								analisisEnfermedadDTO.getLongitud(), nombreEnfermedad, linea, palma, evolucion,
								gradoSeveridad, icon));

						latitude += analisisEnfermedadDTO.getLatitud();
						longitude += analisisEnfermedadDTO.getLongitud();

						contador++;
					}
				} // for

				this.latitude = latitude / contador;
				this.longitude = longitude / contador;

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
						"Lo sentimos no hay información para los filtros de busqueda seleccionados"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private PictureMarkerGraphic buildGisfacesMarker(double latitude, double longitude, String nombreEnfermedad, String linea,
			String palma, String evolucion, BigDecimal gradoSeveridad, String icon) {

		PictureMarkerGraphic markerGisfaces = new PictureMarkerGraphic();
		markerGisfaces.setCoordinate(new Coordinate(latitude, longitude));
		markerGisfaces.getAttributes().put("Enfermedad", nombreEnfermedad);
		markerGisfaces.getAttributes().put("Linea", linea);
		markerGisfaces.getAttributes().put("Palma", palma);
		markerGisfaces.getAttributes().put("Evolución", evolucion);
		markerGisfaces.getAttributes().put("Grado severidad", gradoSeveridad);
		markerGisfaces.setImage(icon);
		markerGisfaces.setHeight(32);
		markerGisfaces.setWidth(22);
		markerGisfaces.setDraggable(true);

		return markerGisfaces;

	}

	/*public void getAnalisisEnfermedadesGisGoogleMaps() throws Exception {

		// Filtros
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		Long compania = 0L;
		Long companiaSession = 0L;
		Long flagZona = 1L;
		Long flagFinca = 1L;
		Long flagBloque = 1L;
		Long flagLote = 1L;
		Long flagEnfermedad = 1L;

		String zonasSeleccionadas = "";
		if (selectedNivel1 != null && selectedNivel1.size() > 0) {
			zonasSeleccionadas = selectedNivel1.get(0);
			flagZona = 0L;
			for (int i = 1; i < selectedNivel1.size(); i++) {
				zonasSeleccionadas += "," + selectedNivel1.get(i);
			}
		}

		String fincasSeleccionadas = "";
		if (selectedNivel2 != null && selectedNivel2.size() > 0) {
			fincasSeleccionadas = selectedNivel2.get(0);
			flagFinca = 0L;
			for (int i = 1; i < selectedNivel2.size(); i++) {
				fincasSeleccionadas += "," + selectedNivel2.get(i);
			}
		}

		String bloquesSeleccionadas = "";
		if (selectedNivel3 != null && selectedNivel3.size() > 0) {
			bloquesSeleccionadas = selectedNivel3.get(0);
			flagBloque = 0L;
			for (int i = 1; i < selectedNivel3.size(); i++) {
				bloquesSeleccionadas += "," + selectedNivel3.get(i);
			}
		}

		String lotesSeleccionadas = "";
		if (selectedNivel4 != null && selectedNivel4.size() > 0) {
			lotesSeleccionadas = selectedNivel4.get(0);
			flagLote = 0L;
			for (int i = 1; i < selectedNivel4.size(); i++) {
				lotesSeleccionadas += "," + selectedNivel4.get(i);
			}
		}

		String enfermedadesSeleccionadas = "";
		if (selectedFitosanidad != null && selectedFitosanidad.size() > 0) {
			enfermedadesSeleccionadas = selectedFitosanidad.get(0);
			flagEnfermedad = 0L;
			for (int i = 1; i < selectedFitosanidad.size(); i++) {
				enfermedadesSeleccionadas += "," + selectedFitosanidad.get(i);
			}
		}

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		compania = FacesUtils.checkLong(txtCompania);
		companiaSession = getCompaniaIdUserSession();

		if (compania.longValue() != companiaSession.longValue()) {

			compania = FacesUtils.checkLong(txtCompania);
			cargarConfiguracionMapa(compania);

		} else {

			compania = companiaSession;
		}

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();
		advancedModel = new DefaultMapModel();
		Long contador = 0L;
		BigDecimal lineaTmp;
		BigDecimal palmaTmp;
		BigDecimal gradoSeveridadTmp;
		String evolucionTmp = "";

		String nombreEnfermedadTmp = "";
		String icon = "";

		try {

			analisisEnfermedad = businessDelegatorView.consultarAnalisisEnfermedad(compania, fechaInicial, fechaFinal,
					zonasSeleccionadas, flagZona, fincasSeleccionadas, flagFinca, bloquesSeleccionadas, flagBloque,
					lotesSeleccionadas, flagLote, enfermedadesSeleccionadas, flagEnfermedad);

			if (analisisEnfermedad != null && analisisEnfermedad.size() > 0) {

				for (AnalisisEnfermedadDTO analisisEnfermedadDTO : analisisEnfermedad) {

					if (analisisEnfermedadDTO.getEvolucion() != null) {

						lineaTmp = analisisEnfermedadDTO.getLinea();
						palmaTmp = analisisEnfermedadDTO.getPlanta();
						nombreEnfermedadTmp = analisisEnfermedadDTO.getNombreEnfermedad().toString();

						evolucionTmp = analisisEnfermedadDTO.getEvolucion().toString();
						gradoSeveridadTmp = analisisEnfermedadDTO.getGradoSeveridad();

						analisisEnfermedadDTO.setEvolucion(evolucionTmp);
						analisisEnfermedadDTO.setGradoSeveridad(gradoSeveridadTmp);

						analisisEnfermedadDTO.setLinea(lineaTmp);
						analisisEnfermedadDTO.setPlanta(palmaTmp);
						analisisEnfermedadDTO.setNombreEnfermedad(nombreEnfermedadTmp);

						icon = contextPath + "/images/Market_Tratamientos.png";

					} else {

						lineaTmp = analisisEnfermedadDTO.getLinea();
						palmaTmp = analisisEnfermedadDTO.getPlanta();
						nombreEnfermedadTmp = analisisEnfermedadDTO.getNombreEnfermedad().toString();

						analisisEnfermedadDTO.setLinea(lineaTmp);
						analisisEnfermedadDTO.setPlanta(palmaTmp);
						analisisEnfermedadDTO.setNombreEnfermedad(nombreEnfermedadTmp);

						icon = contextPath + "/images/Market_Enfermedad.png";
					}

					if (analisisEnfermedadDTO.getLatitud() != null && analisisEnfermedadDTO.getLongitud() != null) {
						LatLng coords = new LatLng(analisisEnfermedadDTO.getLatitud().doubleValue(),
								analisisEnfermedadDTO.getLongitud().doubleValue());

						advancedModel.addOverlay(new Marker(coords, analisisEnfermedadDTO.getAnio().toString(),
								analisisEnfermedadDTO, icon));

						latitude += analisisEnfermedadDTO.getLatitud().doubleValue();
						longitude += analisisEnfermedadDTO.getLongitud().doubleValue();
						contador++;

					}

				} // for

				latitude = latitude / contador;
				longitude = longitude / contador;
				centerRevGeoMap = latitude + "," + longitude;

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
						"Lo sentimos no hay información para los filtros de busqueda seleccionados"));

				mapDefault();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
		AnalisisEnfermedadDTO analisisEnfermedadDTO = (AnalisisEnfermedadDTO) marker.getData();

		linea = analisisEnfermedadDTO.getLinea().toString();
		palma = analisisEnfermedadDTO.getPlanta().toString();
		nombreEnfermedad = analisisEnfermedadDTO.getNombreEnfermedad().toString();

		evolucion = analisisEnfermedadDTO.getEvolucion().toString();
		gradoSeveridad = analisisEnfermedadDTO.getGradoSeveridad();

	}*/

	public MapModel getAdvancedModel() {

		return advancedModel;
	}

	/*public void mapDefault() {
		advancedModel = new DefaultMapModel();
		LatLng coord = new LatLng(3.6374489, -76.2900103);
		centerRevGeoMap = coord.getLat() + "," + coord.getLng();
		advancedModel.addOverlay(new Marker(coord, "Empresa"));
	}*/
	
	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public List<String> getSelectedVariedades() {
		return selectedVariedades;
	}

	public void setSelectedVariedades(List<String> selectedVariedades) {
		this.selectedVariedades = selectedVariedades;
	}

	public List<Variedad> getVariedades() {

		if (variedades == null || variedades.size() == 0) {

			variedades = new ArrayList<Variedad>();

			try {
				variedades = businessDelegatorView.getVariedad();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return variedades;
	}

	public void setVariedades(List<Variedad> variedades) {
		this.variedades = variedades;
	}

	public List<String> getSelectedNivel1() {
		return selectedNivel1;
	}

	public void setSelectedNivel1(List<String> selectedNivel1) {
		this.selectedNivel1 = selectedNivel1;
	}

	public List<Nivel1> getZonas() {
		if (zonas == null || zonas.size() == 0) {

			zonas = new ArrayList<Nivel1>();

			try {
				zonas = businessDelegatorView.getNivel1();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return zonas;
	}

	public void setZonas(List<Nivel1> zonas) {
		this.zonas = zonas;
	}

	public List<String> getSelectedNivel2() {
		return selectedNivel2;
	}

	public void setSelectedNivel2(List<String> selectedNivel2) {
		this.selectedNivel2 = selectedNivel2;
	}

	public List<Nivel2> getFincas() {

		if (fincas == null || fincas.size() == 0) {

			fincas = new ArrayList<Nivel2>();

			try {
				fincas = businessDelegatorView.getNivel2();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return fincas;
	}

	public void setFincas(List<Nivel2> fincas) {
		this.fincas = fincas;
	}

	public List<String> getSelectedNivel3() {
		return selectedNivel3;
	}

	public void setSelectedNivel3(List<String> selectedNivel3) {
		this.selectedNivel3 = selectedNivel3;
	}

	public List<Nivel3> getBloques() {
		if (bloques == null || bloques.size() == 0) {

			bloques = new ArrayList<Nivel3>();

			try {
				bloques = businessDelegatorView.getNivel3();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return bloques;
	}

	public void setBloques(List<Nivel3> bloques) {
		this.bloques = bloques;
	}

	public List<String> getSelectedNivel4() {
		return selectedNivel4;
	}

	public void setSelectedNivel4(List<String> selectedNivel4) {
		this.selectedNivel4 = selectedNivel4;
	}

	public List<Nivel4> getLotes() {

		if (lotes == null || lotes.size() == 0) {

			lotes = new ArrayList<Nivel4>();

			try {
				lotes = businessDelegatorView.getNivel4();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return lotes;
	}

	public void setLotes(List<Nivel4> lotes) {
		this.lotes = lotes;
	}

	public List<String> getSelectedFitosanidad() {
		return selectedFitosanidad;
	}

	public void setSelectedFitosanidad(List<String> selectedFitosanidad) {
		this.selectedFitosanidad = selectedFitosanidad;
	}

	public List<Fitosanidad> getFitosanidades() {
		if (fitosanidades == null || fitosanidades.size() == 0) {

			fitosanidades = new ArrayList<Fitosanidad>();

			try {
				fitosanidades = businessDelegatorView.getFitosanidad();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return fitosanidades;
	}

	public void setFitosanidades(List<Fitosanidad> fitosanidades) {
		this.fitosanidades = fitosanidades;
	}

	public List<String> getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(List<String> selectedLabor) {
		this.selectedLabor = selectedLabor;
	}

	public List<Labor> getLabores() {
		if (labores == null || labores.size() == 0) {

			labores = new ArrayList<Labor>();

			try {
				labores = businessDelegatorView.getLabor();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return labores;
	}

	public void setLabores(List<Labor> labores) {
		this.labores = labores;
	}

	public List<String> getSelectedGrupoLabor() {
		return selectedGrupoLabor;
	}

	public void setSelectedGrupoLabor(List<String> selectedGrupoLabor) {
		this.selectedGrupoLabor = selectedGrupoLabor;
	}

	public List<GrpLabor> getGrupoLabores() {
		if (grupoLabores == null || grupoLabores.size() == 0) {

			grupoLabores = new ArrayList<GrpLabor>();

			try {
				grupoLabores = businessDelegatorView.getGrpLabor();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return grupoLabores;
	}

	public void setGrupoLabores(List<GrpLabor> grupoLabores) {
		this.grupoLabores = grupoLabores;
	}

	public List<String> getSelectedTenencia() {
		return selectedTenencia;
	}

	public void setSelectedTenencia(List<String> selectedTenencia) {
		this.selectedTenencia = selectedTenencia;
	}

	public List<Tenencia> getTenencias() {
		if (tenencias == null || tenencias.size() == 0) {

			tenencias = new ArrayList<Tenencia>();

			try {
				tenencias = businessDelegatorView.getTenencia();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return tenencias;
	}

	public void setTenencias(List<Tenencia> tenencias) {
		this.tenencias = tenencias;
	}

	public List<String> getSelectedUdadMed() {
		return selectedUdadMed;
	}

	public void setSelectedUdadMed(List<String> selectedUdadMed) {
		this.selectedUdadMed = selectedUdadMed;
	}

	public List<UdadMed> getUnidadesMedida() {
		if (unidadesMedida == null || unidadesMedida.size() == 0) {

			unidadesMedida = new ArrayList<UdadMed>();

			try {
				unidadesMedida = businessDelegatorView.getUdadMed();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return unidadesMedida;
	}

	public void setUnidadesMedida(List<UdadMed> unidadesMedida) {
		this.unidadesMedida = unidadesMedida;
	}

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectItem[] getSelectCompania() {
		if (compania == null || compania.size() == 0) {

			compania = new ArrayList<Compania>();

			try {

				compania = businessDelegatorView.getCompania();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Compania> lista = businessDelegatorView.findByCriteriaInCompania(condicion, null, null);
				selectCompania = new SelectItem[lista.size()];

				int i = 0;
				for (Compania compania : lista) {
					selectCompania[i] = new SelectItem(compania.getCompaniaId(), compania.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCompania;
	}

	public void setSelectCompania(SelectItem[] selectCompania) {
		this.selectCompania = selectCompania;
	}

	public SelectOneMenu getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(SelectOneMenu txtCultivoId_Cultivo) {
		this.txtCultivoId_Cultivo = txtCultivoId_Cultivo;
	}

	public SelectItem[] getSelectCultivo() {

		if (cultivo == null || cultivo.size() == 0) {// Para que vaya solo una
			// vez a la base de
			// datos

			cultivo = new ArrayList<Cultivo>();

			try {

				cultivo = businessDelegatorView.getCultivo();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Cultivo> lista = businessDelegatorView.findByCriteriaInCultivo(condicion, null, null);
				selectCultivo = new SelectItem[lista.size()];

				int i = 0;
				for (Cultivo cultivo : lista) {
					selectCultivo[i] = new SelectItem(cultivo.getCultivoId(), cultivo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCultivo;
	}

	public void setSelectCultivo(SelectItem[] selectCultivo) {
		this.selectCultivo = selectCultivo;
	}

	/*public Marker getMarker() {
		return marker;
	}*/

	public void setAdvancedModel(MapModel advancedModel) {
		this.advancedModel = advancedModel;
	}

	/*public void setMarker(Marker marker) {
		this.marker = marker;
	}*/

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLinea() {
		return linea;
	}

	public String getPalma() {
		return palma;
	}

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public void setPalma(String palma) {
		this.palma = palma;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	public BigDecimal getGradoSeveridad() {
		return gradoSeveridad;
	}

	public String getEvolucion() {
		return evolucion;
	}

	public void setGradoSeveridad(BigDecimal gradoSeveridad) {
		this.gradoSeveridad = gradoSeveridad;
	}

	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	public List<AnalisisEnfermedadDTO> getAnalisisEnfermedad() {
		return analisisEnfermedad;
	}

	public void setAnalisisEnfermedad(List<AnalisisEnfermedadDTO> analisisEnfermedad) {
		this.analisisEnfermedad = analisisEnfermedad;
	}

	public GraphicsModel getGraphicsModel() {

		return graphicsModel;

	}

	public void setGraphicsModel(GraphicsModel graphicsModel) {

		this.graphicsModel = graphicsModel;
	}

	public List<Cultivo> getCultivo() {
		return cultivo;
	}

	public String getBackground() {
		return background;
	}

	public int getZoom() {
		return zoom;
	}

	public double getOpacity() {
		return opacity;
	}

	public boolean isVisible() {
		return visible;
	}

	public String getWhere() {
		return where;
	}

	public void setCultivo(List<Cultivo> cultivo) {
		this.cultivo = cultivo;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getLatitudeTmp() {
		return latitudeTmp;
	}

	public String getLongitudeTmp() {
		return longitudeTmp;
	}

	public void setLatitudeTmp(String latitudeTmp) {
		this.latitudeTmp = latitudeTmp;
	}

	public void setLongitudeTmp(String longitudeTmp) {
		this.longitudeTmp = longitudeTmp;
	}

	public String getKml_url() {
		return kml_url;
	}

	public void setKml_url(String kml_url) {
		this.kml_url = kml_url;
	}

	public String getCenterRevGeoMap() {
		return centerRevGeoMap;
	}

	public void setCenterRevGeoMap(String centerRevGeoMap) {
		this.centerRevGeoMap = centerRevGeoMap;
	}

	public String getEstado_kml() {
		return estado_kml;
	}

	public void setEstado_kml(String estado_kml) {
		this.estado_kml = estado_kml;
	}

	public String getVisibilityIndex0() {
		return visibilityIndex0;
	}

	public String getVisibilityIndex1() {
		return visibilityIndex1;
	}

	public void setVisibilityIndex0(String visibilityIndex0) {
		this.visibilityIndex0 = visibilityIndex0;
	}

	public void setVisibilityIndex1(String visibilityIndex1) {
		this.visibilityIndex1 = visibilityIndex1;
	}

	public Long getCompaniaIdSession() {
		return companiaIdSession;
	}

	public void setCompaniaIdSession(Long companiaIdSession) {
		this.companiaIdSession = companiaIdSession;
	}

	public Long getCompaniaIdView() {
		return companiaIdView;
	}

	public void setCompaniaIdView(Long companiaIdView) {
		this.companiaIdView = companiaIdView;
	}
	
	

}
