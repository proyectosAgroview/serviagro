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
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gisfaces.model.graphic.Graphic;
import com.gisfaces.model.graphic.GraphicsModel;
import com.gisfaces.model.graphic.PictureMarkerGraphic;
import com.gisfaces.model.map.Background;
import com.gisfaces.model.map.Coordinate;

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
import co.com.arcosoft.modelo.informes.dto.AnalisisPlagaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeAnalisisPlagaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeAnalisisPlagaView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private boolean showDialog;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<AnalisisPlagaDTO> data;

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

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	/* Mapas GMPAS */
	private MapModel advancedModel;
	private Marker marker;
	private String centerRevGeoMap;
	private double latitude;
	private double longitude;

	// Informacion del infoWindow
	private String linea = "";
	private String palma = "";
	private String nombrePlaga = "";
	private String numeroHojas = "";

	// Gisfaces
	private GraphicsModel graphicsModel;
	private String background;
	private int zoom;
	private double opacity;;
	private boolean visible;;
	private String where;
	private String kml_url;
	private String estado_kml;
	private int numeroPestana;

	private String visibilityIndex0 = "none";
	private String visibilityIndex1 = "none";

	Long companiaIdSession = 0L;
	Long companiaIdView = 0L;

	public InformeAnalisisPlagaView() {
		super();
		//inicializarConfiguracionMapa();
	}
	
	@PostConstruct
	public void init()
	{
		inicializarConfiguracionMapa();
	}

	public void inicializarConfiguracionMapa() {

		this.background = "streets";
		this.zoom = 4;
		this.opacity = 1.0;
		this.visible = true;
		this.where = "MAGNITUDE >= 2";
		this.numeroPestana = 1;
		this.latitude = 3.6374489;
		this.longitude = -76.2900103;
		this.centerRevGeoMap = latitude + "," + longitude;
		this.estado_kml = "I";
		this.kml_url = "https://sites.google.com/site/repoagroviewkml/kml_files/Lotes_HLG.kml";

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

	public void itemSelect(ItemSelectEvent event) {

		setShowDialog(true);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<SelectItem> getBackgrounds() {
		return Background.getSelectItems();
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

	public String action_consultar() throws Exception {

		companiaIdView = FacesUtils.checkLong(txtCompania);
		companiaIdSession = getCompaniaIdUserSession();

		if (companiaIdView.longValue() != companiaIdSession.longValue()) {
			cargarConfiguracionMapa(companiaIdView);

		} else {
			cargarConfiguracionMapa(companiaIdSession);
		}

		getAnalisisPlagasGisFaces();

		/*
		 * if (this.estado_kml.equals("A")) { getAnalisisPlagasGisFaces(); } else {
		 * getAnalisisPlagasGisGoogleMaps(); }
		 */

		return "";
	}

	public void cargarConfiguracionMapa(Long companiaId) throws Exception, Exception {

		Compania compania = null;
		compania = businessDelegatorView.getCompania(companiaId);

		this.estado_kml = compania.getEstadoKml().toString();

		if (this.estado_kml.equals("A")) {
			this.kml_url = compania.getUrlKml().toString();
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
		this.zoom = 4;
		this.opacity = 1.0;
		this.visible = true;
		this.where = "MAGNITUDE >= 2";
		this.centerRevGeoMap = latitude + "," + longitude;

	}

	public void getAnalisisPlagasGisFaces() throws Exception, Exception {

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
		Long flagPlaga = 1L;

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

		String plagasSeleccionadas = "";
		if (selectedFitosanidad != null && selectedFitosanidad.size() > 0) {
			plagasSeleccionadas = selectedFitosanidad.get(0);
			flagPlaga = 0L;
			for (int i = 1; i < selectedFitosanidad.size(); i++) {
				plagasSeleccionadas += "," + selectedFitosanidad.get(i);
			}
		}

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		if (companiaIdView != null) {
			compania = companiaIdView;
			cargarConfiguracionMapa(compania);
		} else {
			compania = companiaIdSession;
		}

		Long contador = 0L;
		BigDecimal lineaTmp;
		BigDecimal palmaTmp;

		String nombrePlagaTmp = "";
		BigDecimal numeroHoja;
		String icon = "";

		this.graphicsModel = new GraphicsModel();
		this.graphicsModel.setName("Informaci�n de plantas");
		List<Graphic> graphics = this.graphicsModel.getGraphics();

		try {

			data = businessDelegatorView.consultarAnalisisPlaga(compania, fechaInicial, fechaFinal, zonasSeleccionadas,
					flagZona, fincasSeleccionadas, flagFinca, bloquesSeleccionadas, flagBloque, lotesSeleccionadas,
					flagLote, plagasSeleccionadas, flagPlaga);

			if (data != null && data.size() > 0) {

				for (AnalisisPlagaDTO dataDTO : data) {

					lineaTmp = dataDTO.getLinea();
					palmaTmp = dataDTO.getPlanta();
					nombrePlagaTmp = dataDTO.getNombrePlaga().toString();
					numeroHoja = dataDTO.getNumeroHoja();
					dataDTO.setLinea(lineaTmp);
					dataDTO.setPlanta(palmaTmp);
					dataDTO.setNombrePlaga(nombrePlagaTmp);
					dataDTO.setNumeroHoja(numeroHoja);
					icon = contextPath + "/images/Market_Plaga.png";

					if (dataDTO.getLatitud() != null && dataDTO.getLongitud() != null) {

						linea = dataDTO.getLinea().toString();
						palma = dataDTO.getPlanta().toString();
						nombrePlaga = dataDTO.getNombrePlaga().toString();
						numeroHojas = dataDTO.getNumeroHoja().toString();

						graphics.add(buildGisfacesMarker(dataDTO.getLatitud().doubleValue(),
								dataDTO.getLongitud().doubleValue(), nombrePlaga, linea, palma, numeroHojas, icon));

						latitude += dataDTO.getLatitud().doubleValue();
						longitude += dataDTO.getLongitud().doubleValue();

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

	private PictureMarkerGraphic buildGisfacesMarker(double latitude, double longitude, String nombrePlanta,
			String linea, String palma, String numeroHojas, String icon) {

		PictureMarkerGraphic markerGisfaces = new PictureMarkerGraphic();
		markerGisfaces.setCoordinate(new Coordinate(latitude, longitude));
		markerGisfaces.getAttributes().put("Plaga", nombrePlanta);
		markerGisfaces.getAttributes().put("Linea", linea);
		markerGisfaces.getAttributes().put("Palma", palma);
		markerGisfaces.getAttributes().put("Número de hojas", numeroHojas);
		markerGisfaces.setImage(icon);
		markerGisfaces.setHeight(32);
		markerGisfaces.setWidth(22);

		return markerGisfaces;

	}

	/*public void getAnalisisPlagasGisGoogleMaps() throws Exception {

		// Filtros
		RequestContext rq = RequestContext.getCurrentInstance();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();
		RequestContext ctx = RequestContext.getCurrentInstance();
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
		Long flagPlaga = 1L;

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

		String plagasSeleccionadas = "";
		if (selectedFitosanidad != null && selectedFitosanidad.size() > 0) {
			plagasSeleccionadas = selectedFitosanidad.get(0);
			flagPlaga = 0L;
			for (int i = 1; i < selectedFitosanidad.size(); i++) {
				plagasSeleccionadas += "," + selectedFitosanidad.get(i);
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

		Long contador = 0L;
		BigDecimal lineaTmp;
		BigDecimal palmaTmp;

		String nombrePlagaTmp = "";
		BigDecimal numeroHoja;
		String icon = "";

		advancedModel = new DefaultMapModel();

		try {

			data = businessDelegatorView.consultarAnalisisPlaga(compania, fechaInicial, fechaFinal, zonasSeleccionadas,
					flagZona, fincasSeleccionadas, flagFinca, bloquesSeleccionadas, flagBloque, lotesSeleccionadas,
					flagLote, plagasSeleccionadas, flagPlaga);

			if (data != null && data.size() > 0) {

				for (AnalisisPlagaDTO dataDTO : data) {

					lineaTmp = dataDTO.getLinea();
					palmaTmp = dataDTO.getPlanta();
					nombrePlagaTmp = dataDTO.getNombrePlaga().toString();
					numeroHoja = dataDTO.getNumeroHoja();
					dataDTO.setLinea(lineaTmp);
					dataDTO.setPlanta(palmaTmp);
					dataDTO.setNombrePlaga(nombrePlagaTmp);
					dataDTO.setNumeroHoja(numeroHoja);
					icon = contextPath + "/images/Market_Plaga.png";

					if (dataDTO.getLatitud() != null && dataDTO.getLongitud() != null) {

						LatLng coords = new LatLng(dataDTO.getLatitud().doubleValue(),
								dataDTO.getLongitud().doubleValue());

						advancedModel.addOverlay(new Marker(coords, dataDTO.getAnio().toString(), dataDTO, icon));

						latitude += dataDTO.getLatitud().doubleValue();
						longitude += dataDTO.getLongitud().doubleValue();

						contador++;

					}

				} // for

				this.latitude = latitude / contador;
				this.longitude = longitude / contador;
				centerRevGeoMap = latitude + "," + longitude;

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
						"Lo sentimos no hay informaci�n para los filtros de busqueda seleccionados"));

				mapDefault();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();

		AnalisisPlagaDTO dataDTO = (AnalisisPlagaDTO) marker.getData();

		linea = dataDTO.getLinea().toString();
		palma = dataDTO.getPlanta().toString();
		nombrePlaga = dataDTO.getNombrePlaga().toString();
		numeroHojas = dataDTO.getNumeroHoja().toString();

	}*/

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
		if (compania == null || compania.size() == 0) {// Para que vaya solo una
			// vez a la base de
			// datos

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

	public String getLinea() {
		return linea;
	}

	public String getPalma() {
		return palma;
	}

	public String getNombrePlaga() {
		return nombrePlaga;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public void setPalma(String palma) {
		this.palma = palma;
	}

	public void setNombrePlaga(String nombrePlaga) {
		this.nombrePlaga = nombrePlaga;
	}

	public MapModel getAdvancedModel() {
		return advancedModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setAdvancedModel(MapModel advancedModel) {
		this.advancedModel = advancedModel;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public String getNumeroHojas() {
		return numeroHojas;
	}

	public void setNumeroHojas(String numeroHojas) {
		this.numeroHojas = numeroHojas;
	}

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

	public GraphicsModel getGraphicsModel() {
		return graphicsModel;
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

	public String getKml_url() {
		return kml_url;
	}

	public String getEstado_kml() {
		return estado_kml;
	}

	public int getNumeroPestana() {
		return numeroPestana;
	}

	public void setGraphicsModel(GraphicsModel graphicsModel) {
		this.graphicsModel = graphicsModel;
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

	public void setKml_url(String kml_url) {
		this.kml_url = kml_url;
	}

	public void setEstado_kml(String estado_kml) {
		this.estado_kml = estado_kml;
	}

	public void setNumeroPestana(int numeroPestana) {
		numeroPestana = numeroPestana;
	}

	public String getCenterRevGeoMap() {
		return centerRevGeoMap;
	}

	public void setCenterRevGeoMap(String centerRevGeoMap) {
		this.centerRevGeoMap = centerRevGeoMap;
	}

	public String getVisibilityIndex0() {
		return visibilityIndex0;
	}

	public void setVisibilityIndex0(String visibilityIndex0) {
		this.visibilityIndex0 = visibilityIndex0;
	}

	public String getVisibilityIndex1() {
		return visibilityIndex1;
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
