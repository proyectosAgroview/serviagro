package co.com.arcosoft.presentation.backingBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;

import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean(name = "treeEventsView")
@SessionScoped
public class EventsView implements Serializable {

	private static final long serialVersionUID = 1L;
	private TreeNode root;
	private TreeNode selectedNode;
	private String url = "";
	private String modulo = "";
	private String onActiveIdleSession = "off";
	private String tituloModulo;
	private String auth;

	/*** Autocompletar ***/

	private String txt8;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty("#{menuService}")
	private MenuService service;

	@PostConstruct
	public void init() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Map<String, String> params = ctx.getExternalContext().getRequestParameterMap();
		Object contextPath = peticion.getContextPath();

		Cookie[] cookies = peticion.getCookies();

		if(params != null){
		if (params.get("modulo") != null & params.get("modulo").length() > 0 ) {

			Cookie cookie = new Cookie("modulo", params.get("modulo"));
			cookie.setPath(contextPath.toString());
			cookie.setMaxAge(-1);
			respuest.addCookie(cookie);

			this.modulo = cookie.getValue();

		} else {

			/*for (Cookie cookie2 : cookies) {
				if ((cookie2.getName()).equals("modulo")) {
					this.modulo = cookie2.getValue();

				}
			}*/

			try {
				//url = "/XHTML/Reportes/mantenimientoMaquinaria/consultaListaProximoMttoListDataTable.xhtml";
				ctx.getExternalContext().redirect(contextPath + "/XHTML/tmp_inicio.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
		if (this.modulo != null) {

			root = service.createMenus(this.modulo);
			this.setTituloModulo(service.getTituloModulo());

		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			Object ctxPath = origRequest.getContextPath();

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(ctxPath + "/XHTML/tmp_inicio.xhtml");

				context.getExternalContext().getSessionMap().remove("menuService");
				context.getExternalContext().getSessionMap().remove("treeEventsView");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void onItemSelect(SelectEvent event) throws Exception {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Item Selected", event.getObject().toString()));

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		String node = event.getObject().toString();
		String url = "";

		if (modulo.equals("tecno_agricola")) {
			url = eventosMenuTecnoAgricola(node);
		}

		if (modulo.equals("info_agricola")) {
			url = eventosMenuInfoAgricola(node);
		}

		if (modulo.equals("admin_agricola")) {
			url = eventosMenuAdminAgricola(node);
		}

		if (modulo.equals("prod_agricola")) {
			url = eventosMenuProduccionAgricola(node);
		}

		if (modulo.equals("mantenimiento_maquinaria")) {
			url = eventosMenuMantenimientoMaquinaria(node);
		}

		if (modulo.equals("mantenimiento_industrial")) {
			url = eventosMenuMantenimientoIndustrial(node);
		}

		if (modulo.equals("sgu")) {
			url = eventosMenuSgu(node);
		}

		FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + url);

	}

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void setService(MenuService service) {
		this.service = service;
	}

	public void onNodeExpand(NodeExpandEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Expanded",
				event.getTreeNode().getData().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onNodeCollapse(NodeCollapseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Collapsed",
				event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onNodeSelect(NodeSelectEvent event) {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		String node = event.getTreeNode().getData().toString();

		if (modulo.equals("tecno_agricola")) {
			url = eventosMenuTecnoAgricola(node);
		}

		if (modulo.equals("info_agricola")) {
			url = eventosMenuInfoAgricola(node);
		}

		if (modulo.equals("admin_agricola")) {
			url = eventosMenuAdminAgricola(node);
		}

		if (modulo.equals("prod_agricola")) {
			url = eventosMenuProduccionAgricola(node);
		}

		if (modulo.equals("mantenimiento_maquinaria")) {
			url = eventosMenuMantenimientoMaquinaria(node);
		}
		if (modulo.equals("mantenimiento_industrial")) {
			url = eventosMenuMantenimientoIndustrial(node);
		}
		if (modulo.equals("sgu")) {
			url = eventosMenuSgu(node);
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		root.setExpanded(true);
		root.setSelected(true);
		service.expandir(selectedNode);

	}

	private String eventosMenuSgu(String node) {

		if (node.equals("Usuarios"))
			url = "/XHTML/sgu/usuariosListDataTable.xhtml";
		if (node.equals("Grupos"))
			url = "/XHTML/sgu/groupsListDataTable.xhtml";
		if (node.equals("Contenidos del menu"))
			url = "/XHTML/sgu/Configuraciones/itemsMenuListDataTable.xhtml";
		if (node.equals("Compañia"))
			url = "/XHTML/sgu/companiaListDataTable.xhtml";
		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";

		return url;

	}

	public List<String> completeText(String query) {

		List<String> results = businessDelegatorView.consultarItemsPorModulo(this.modulo);
		List<String> filtro = new ArrayList<String>();

		if (results != null && results.size() > 0) {
			for (int i = 0; i < results.size(); i++) {
				String skin = results.get(i);
				if (skin.toLowerCase().contains(query)) {
					filtro.add(skin);
				}
			}
		}

		return filtro;
	}

	public String eventosMenuTecnoAgricola(String node) {

		/* eventos de catalogos */

		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		if (node.equals("Fitosanidad"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/fitosanidadListDataTable.xhtml";
		if (node.equals("Fases fenologicas"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/faseFenologicaListDataTable.xhtml";
		if (node.equals("Análisis"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/anaSanVegListDataTable.xhtml";
		if (node.equals("Variables"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/variableListDataTable.xhtml";
		if (node.equals("Pluviómetros"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/estPluvioListDataTable.xhtml";
		if (node.equals("Evaporímetros"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/estEvaporimetroListDataTable.xhtml";
		if (node.equals("Estación climatológica"))
			url = "/XHTML/TecnoAgricola/sanidadVegetal/estClimatListDataTable.xhtml";

		/* Pantallas Transaccionales */

		if (node.equals("Registros pluviometricos"))
			url = "/XHTML/TecnoAgricola/transacciones/datPluvioListDataTable.xhtml";
		if (node.equals("Registros de evaporación"))
			url = "/XHTML/TecnoAgricola/transacciones/datEvaporimetroListDataTable.xhtml"; // falta
		if (node.equals("Registros climáticos"))
			url = "/XHTML/TecnoAgricola/transacciones/datClimatListDataTable.xhtml";
		if (node.equals("Registros de análisis fitosanidades"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegListDataTable.xhtml";
		if (node.equals("Registros de análisis de diatrea"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegDiatreaTable.xhtml";
		if (node.equals("Registros de análisis de suelo"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegAnaSueloListDataTable.xhtml";


		if (node.equals("Análisis de plagas"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegPlagasPalma3.xhtml";
		
		if (node.equals("Análisis de enfermedades"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegEnfermedadesPalma3.xhtml";
		
		if (node.equals("Censo de productividad por lote"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegCensoPalmaListDataTable.xhtml";
		
		if (node.equals("Análisis de polinización"))
			url = "/XHTML/TecnoAgricola/transacciones/datSanVegPolinizacionPalma.xhtml";
		
		// Reportes de tecnología agricola
		if (node.equals("Precipitación día a día"))
			url = "/XHTML/Reportes/tecnoAgricola/informePluviometria.xhtml";
		if (node.equals("Precipitación(mm) 5 años"))
			url = "/XHTML/Reportes/tecnoAgricola/informePrecipitacionAnios.xhtml";
		if (node.equals("Evaporación día a día"))
			url = "/XHTML/Reportes/tecnoAgricola/informeDatosEvaporimetros.xhtml";
		if (node.equals("Datos climatologicos"))
			url = "/XHTML/Reportes/tecnoAgricola/informeDatosClimaticos.xhtml";
		if (node.equals("Temp. mínima vs Temp. máxima"))
			url = "/XHTML/Reportes/tecnoAgricola/informeTemperaturaClima.xhtml";

	//	if (node.equals("Análisis de enfermedades"))
		//	url = "/XHTML/Reportes/tecnoAgricola/informeAnalisisEnfermedad.xhtml";
		if (node.equals("Casos Vs incidencia acumulada por enfermedad"))
			url = "/XHTML/Reportes/tecnoAgricola/informeIncidenciaEnfermedad.xhtml";
	//	if (node.equals("Análisis de plagas"))
	//		url = "/XHTML/Reportes/tecnoAgricola/informeAnalisisPlaga.xhtml";

	//	if (node.equals("Análisis de plagas"))
	//		url = "/XHTML/Reportes/tecnoAgricola/informeAnalisisPlaga.xhtml";

		if (node.equals("Análisis de diatraea"))
			url = "/XHTML/Reportes/tecnoAgricola/informeAnalisisDiatraea.xhtml";

		if (node.equals("Cuadro de precipitación(mm) dia/mes"))
			url = "/XHTML/Reportes/tecnoAgricola/informeCuadroPrecipitacionDiaria.xhtml";

		if (node.equals("Reporte de Plagas"))
			url = "/XHTML/Reportes/tecnoAgricola/informeAnalisisPlagaVer2.xhtml";

		if (node.equals("Reporte de Enfermedades"))
			url = "/XHTML/Reportes/tecnoAgricola/informeAnalisisEnfermedadVer2.xhtml";

		if (node.equals("Reporte de censo de prod. por lote"))
			url = "/XHTML/Reportes/tecnoAgricola/informeCensoProductividadLote.xhtml";
		
		if (node.equals("Mapa de Plagas"))
			url = "/XHTML/Reportes/tecnoAgricola/informeMapaAnalisisPlaga.xhtml";

		if (node.equals("Mapa de Enfermedades"))
			url = "/XHTML/Reportes/tecnoAgricola/informeMapaAnalisisEnfermedad.xhtml";


		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";

		return url;

	}

	public String eventosMenuInfoAgricola(String node) {

		// <ui:composition template="/XHTML/tmp_modulo.xhtml">

		/* eventos de catalogos */

		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		/* DATOS PRIMARIOS */

		if (node.equals("Compañía"))
			url = "/XHTML/InfoAgricola/datosPrimarios/companiaListDataTable.xhtml";
		if (node.equals("Unidad de medida"))
			url = "/XHTML/InfoAgricola/datosPrimarios/udadMedListDataTable.xhtml";
		if (node.equals("Cultivo"))
			url = "/XHTML/InfoAgricola/datosPrimarios/cultivoListDataTable.xhtml";
		if (node.equals("Año fiscal"))
			url = "/XHTML/InfoAgricola/datosPrimarios/anioFiscalListDataTable.xhtml";
		if (node.equals("Calendario"))
			url = "/XHTML/InfoAgricola/datosPrimarios/calendarioListDataTable.xhtml";
		if (node.equals("Tipos de días"))
			url = "/XHTML/InfoAgricola/datosPrimarios/tipoDiaListDataTable.xhtml";
		if (node.equals("Moneda"))
			url = "/XHTML/InfoAgricola/datosPrimarios/monedaListDataTable.xhtml";
		if (node.equals("Periodos de pago"))
			url = "/XHTML/InfoAgricola/datosPrimarios/semanaListDataTable.xhtml";

		/* ADMINISTRACION -> GENERALIDADES */

		if (node.equals("País"))
			url = "/XHTML/InfoAgricola/administracion/paisListDataTable.xhtml";
		if (node.equals("Estado"))
			url = "/XHTML/InfoAgricola/administracion/estadoListDataTable.xhtml";
		if (node.equals("Ciudad"))
			url = "/XHTML/InfoAgricola/administracion/ciudadListDataTable.xhtml";
		if (node.equals("Vereda"))
			url = "/XHTML/InfoAgricola/administracion/veredaListDataTable.xhtml";
		if (node.equals("Bancos"))
			url = "/XHTML/InfoAgricola/administracion/entBancListDataTable.xhtml";
		if (node.equals("Contactos bancarios"))
			url = "/XHTML/InfoAgricola/administracion/contBancoListDataTable.xhtml";
		if (node.equals("Tipos de proveedor"))
			url = "/XHTML/InfoAgricola/administracion/tipProveeListDataTable.xhtml";
		if (node.equals("Empresas"))
			url = "/XHTML/InfoAgricola/administracion/persEmprListDataTable.xhtml";
		if (node.equals("Grupo de tenencia"))
			url = "/XHTML/InfoAgricola/administracion/grpTenenListDataTable.xhtml";
		if (node.equals("Tenencia"))
			url = "/XHTML/InfoAgricola/administracion/tenenciaListDataTable.xhtml";
		if (node.equals("Tipos cultivo"))
			url = "/XHTML/InfoAgricola/administracion/tipCultivoListDataTable.xhtml";
		if (node.equals("Zona geográfica"))
			url = "/XHTML/InfoAgricola/administracion/zonaGeograficaListDataTable.xhtml";
		if (node.equals("Zona agroecológica"))
			url = "/XHTML/InfoAgricola/administracion/zonAgroecListDataTable.xhtml";
		if (node.equals("Ocupación"))
			url = "/XHTML/InfoAgricola/administracion/ocupacionListDataTable.xhtml";
		if (node.equals("Organización"))
			url = "/XHTML/InfoAgricola/administracion/organizacionListDataTable.xhtml";
		if (node.equals("Variedad"))
			url = "/XHTML/InfoAgricola/administracion/variedadListDataTable.xhtml";
		if (node.equals("Etapa del cultivo"))
			url = "/XHTML/InfoAgricola/administracion/etapaListDataTable.xhtml";
		if (node.equals("Restricción de quema"))
			url = "/XHTML/InfoAgricola/administracion/restrQuemaListDataTable.xhtml";
		if (node.equals("Restricción de madurante"))
			url = "/XHTML/InfoAgricola/administracion/restrMaduranteListDataTable.xhtml";
		if (node.equals("Niveles de fertilidad"))
			url = "/XHTML/InfoAgricola/administracion/nivelFertilidadListDataTable.xhtml";
		if (node.equals("Dificultad de acceso"))
			url = "/XHTML/InfoAgricola/administracion/dificultadAccesoListDataTable.xhtml";
		if (node.equals("Distancia de siembra"))
			url = "/XHTML/InfoAgricola/administracion/distSiembraListDataTable.xhtml";
		if (node.equals("Grupos de suelos"))
			url = "/XHTML/InfoAgricola/administracion/grpSueloListDataTable.xhtml";
		// if (node.equals("Lara Edad"))
		// url = "/XHTML/laraEdadListDataTable.xhtml";
		if (node.equals("Series de suelos"))
			url = "/XHTML/InfoAgricola/administracion/serieSueloListDataTable.xhtml";
		if (node.equals("Orden de suelos"))
			url = "/XHTML/InfoAgricola/administracion/ordenSueloListDataTable.xhtml";
		if (node.equals("Familia de texturas"))
			url = "/XHTML/InfoAgricola/administracion/fliaTextSueloListDataTable.xhtml";
		if (node.equals("Clases de texturas"))
			url = "/XHTML/InfoAgricola/administracion/claseTextSueloListDataTable.xhtml";
		if (node.equals("Motivos de unión/división nivel 4"))
			url = "/XHTML/InfoAgricola/administracion/n4MotivoListDataTable.xhtml";
		if (node.equals("Motivos de erradicación de plantas"))
			url = "/XHTML/InfoAgricola/administracion/motElimListDataTable.xhtml";
		if (node.equals("Larvas"))
			url = "/XHTML/InfoAgricola/administracion/larvasListDataTable.xhtml";
		if (node.equals("Tipos de drenaje"))
			url = "/XHTML/InfoAgricola/administracion/tipoDrenajeListDataTable.xhtml";
		if (node.equals("Topografías"))
			url = "/XHTML/InfoAgricola/administracion/topografiaListDataTable.xhtml";

		// <ui:composition template="/XHTML/tmp_modulo.xhtml">

		/* ESTRUCTURA DE CAMPOS */

		if (node.equals("Zona"))
			url = "/XHTML/InfoAgricola/estructuraSiembra/nivel1ListDataTable.xhtml";
		if (node.equals("Hacienda"))
			url = "/XHTML/InfoAgricola/estructuraSiembra/nivel2ListDataTable.xhtml";
		if (node.equals("Bloque"))
			url = "/XHTML/InfoAgricola/estructuraSiembra/nivel3ListDataTable.xhtml";
		if (node.equals("Lote"))
			url = "/XHTML/InfoAgricola/estructuraSiembra/nivel4ListDataTable.xhtml";
		if (node.equals("Estructura de siembra"))
			url = "/XHTML/InfoAgricola/estructuraSiembra/estructSiembListDataTable.xhtml";

		// Reportes de Informacion Agricola

		if (node.equals("Distribución área por cultivo"))
			url = "/XHTML/Reportes/infoAgricola/informeAreaCultivo.xhtml";

		if (node.equals("Distribución área por variedad"))
			url = "/XHTML/Reportes/infoAgricola/informeAreaVariedad.xhtml";

		if (node.equals("Prontuario de Lotes"))
			url = "/XHTML/Reportes/infoAgricola/informeProntuarioLotes.xhtml";

		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";

		return url;

	}

	public String eventosMenuAdminAgricola(String node) {

		/*
		 * Catalogos de administracion agricola
		 * 
		 * <ui:composition template="/XHTML/tmp_inicio.xhtml">
		 */

		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		if (node.equals("Tipos de proveedor"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/tipProveeListDataTable.xhtml";
		if (node.equals("Empresas"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/persEmprListDataTable.xhtml";

		if (node.equals("Unidad de medida"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/udadMedListDataTable.xhtml";
		if (node.equals("Factores de conversión"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/factorConversionListDataTable.xhtml";
		if (node.equals("Equipos de trabajo"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/equipoTrabajoListDataTable.xhtml";
		if (node.equals("Profesiones/Cargos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/profesionListDataTable.xhtml";
		if (node.equals("Trabajadores"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/trabajadorListDataTable.xhtml";
		if (node.equals("Fabricantes"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/fabricanteEquipoListDataTable.xhtml";
		if (node.equals("Categorías"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/categoriaEquipoListDataTable.xhtml";
		if (node.equals("Modelos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/modeloEquipoListDataTable.xhtml";
		if (node.equals("Flotas de transporte"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/flotaTransporteListDataTable.xhtml";
		if (node.equals("Medidores"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/medidorListDataTable.xhtml";
		if (node.equals("Número de ejes"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/numeroEjeListDataTable.xhtml";
		if (node.equals("Equipos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/equipoListDataTable.xhtml";
		if (node.equals("Tipos de productos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/tipoProductoListDataTable.xhtml";
		if (node.equals("Ingrediente activo"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/ingredienteActivoListDataTable.xhtml";
		if (node.equals("Clases toxicológicas"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/claseToxicologicaListDataTable.xhtml";
		if (node.equals("Almacén"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/almacenListDataTable.xhtml";
		if (node.equals("Empaques"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/empaqueListDataTable.xhtml";
		if (node.equals("Producto"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/productoListDataTable.xhtml";
		if (node.equals("Producto - Ingre. Activo"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/ingrActivProdListDataTable.xhtml";
		if (node.equals("Producto - Madurantes"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/maduranteProductoListDataTable.xhtml";
		if (node.equals("Producto - Precio promedio"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/precioPromProdListDataTable.xhtml";
		if (node.equals("Producto - Empaques"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/empaqueProductoListDataTable.xhtml";
		if (node.equals("Otros recursos/Servicios"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/servicioListDataTable.xhtml";
		if (node.equals("Tipos de infraestructuras"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/tipoInfraestructuraListDataTable.xhtml";
		if (node.equals("Infraestructuras"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/infraestructuraListDataTable.xhtml";
		if (node.equals("Sistemas de riego"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/sistemaRiegoListDataTable.xhtml";

		if (node.equals("Configuración de recursos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/tipoRecursoListDataTable.xhtml";
		if (node.equals("Recurso"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/recursoListDataTable.xhtml";
		if (node.equals("Costos por recurso"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/costoRecursoListDataTable.xhtml";
		if (node.equals("Grupos de labores"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/grpLaborListDataTable.xhtml";
		if (node.equals("Labor"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/laborListDataTable.xhtml";
		if (node.equals("Labores relacionadas"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/laborAsociadaListDataTable.xhtml";
		if (node.equals("Labor - Cuenta contable"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/laborCcontableListDataTable.xhtml";
		if (node.equals("Labor - Servicios"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/laborServicioListDataTable.xhtml";
		if (node.equals("Conceptos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/conceptoNominaListDataTable.xhtml";
		if (node.equals("Límites por concepto"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/limiteCeptoNominaListDataTable.xhtml";
		if (node.equals("CeCos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/centCostListDataTable.xhtml";
		if (node.equals("CeCos - Grp. Labores - Tenencia"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/grpLaborTenCencosListDataTable.xhtml";
		if (node.equals("Cuentas contables"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/cuentaContableListDataTable.xhtml";
		if (node.equals("Elementos de costos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/elementoCostoListDataTable.xhtml";
		if (node.equals("Turnos de campo"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/turnoCampoListDataTable.xhtml";

		if (node.equals("Tipos de recursos"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/tipoRecursoListDataTable.xhtml";

		if (node.equals("Cronograma de labores"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/cronogramaLaboresLabores.xhtml";
		
		if (node.equals("Cronograma de labores express"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/cronogramaLaboresExpresV2.xhtml";
		

		if (node.equals("Plan anual de labores por Hacienda"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/cronogramaLaboresPorLaborMes.xhtml";
		
		
		if (node.equals("Colores identificadores"))
			url = "/XHTML/AdminAgricola/planificacionEjecucion/colorIdentProduccionListDataTable.xhtml";

		/*
		 * Transaccionales de administracion agricola
		 * 
		 * <ui:composition template="/XHTML/tmp_inicio.xhtml">
		 */

		if (node.equals("Proyección de labores a realizar por Hda/Lote"))
			url = "/XHTML/AdminAgricola/transacciones/planificacion/proyeccionLaboresARealizar.xhtml";

		
		if (node.equals("Programador operativo de labores"))
			url = "/XHTML/AdminAgricola/transacciones/planificacion/datPlanLaborListDataTable.xhtml";

		if (node.equals("Programador de labores"))
			url = "/XHTML/AdminAgricola/transacciones/planificacion/datPlanLaborListDataTable.xhtml";

		
		if (node.equals("Autorización de labores a ejecutar"))
			url = "/XHTML/AdminAgricola/transacciones/planificacion/datPlanLaborAprobacion.xhtml";

		if (node.equals("Ejecución de labores con (O.T)"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionLaboresPlanificaVer2.xhtml";

		if (node.equals("Ejecución de labores(Sin O.T)"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionLaboresNoPlanificaVer2.xhtml";

		if (node.equals("Ejecución de labores Unificada"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionLaboresUnificadaVer3.xhtml";

		if (node.equals("Ejecución de labores con insumos"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionInsumos.xhtml";

		
		if (node.equals("Otros costos"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/OtrosCostos.xhtml";

		if (node.equals("Consolidación de nóminas"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datNominaTrabajadorDetListDataTable.xhtml";

		if (node.equals("Registro de entradas a almacén"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/precioPromProdListDataTable.xhtml";

		/*
		 * Ejecución de labores trapiches. if (node.equals("Ejecución de labores")) url
		 * =
		 * "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionLaboresCaListDataTable.xhtml";
		 * 
		 */
		/*
		 * Ejecución labores palma if (node.equals("Ejecución de labores")) url =
		 * "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionLaboresPaListDataTable.xhtml";
		 * 
		 */

		/*
		 * if (node.equals("Polinización")) url =
		 * "/XHTML/AdminAgricola/transacciones/ejecucion/datPolinizacionListDataTable.xhtml";
		 * 
		 */

		/*
		 * if (node.equals("Programador de labores")) url =
		 * "/XHTML/AdminAgricola/transacciones/planificacion/programaLaboresAccesoListDataTable.xhtml";
		 * if (node.equals("Ejecución de labores")) url =
		 * "/XHTML/AdminAgricola/transacciones/ejecucion/datEjecucionLaboresAccesoListDataTable.xhtml";
		 */

		if (node.equals("Recursos asociados"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/planAsignarRecursoListDataTable.xhtml";
		if (node.equals("Registros de nómina"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datPlanillaNominaListDataTable.xhtml";

		if (node.equals("Registros de servicios"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datServicioListDataTable.xhtml";
		if (node.equals("Control de Stock"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datRgtroInventListDataTable.xhtml";
		if (node.equals("Entrega de herramientas"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datHerramientaListDataTable.xhtml";
		if (node.equals("Aplicación de productos"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datAplicProductoListDataTable.xhtml";
		if (node.equals("Registros de riegos"))
			url = "/XHTML/AdminAgricola/transacciones/ejecucion/datRiegoListDataTable.xhtml";

		// Reportes de administracion agricola

		if (node.equals("Presupuesto de labores por hacienda"))
			url = "/XHTML/Reportes/adminAgricola/informePresupuestoPorHacienda.xhtml";

		
		if (node.equals("Proyección de labores por lote"))
			url = "/XHTML/Reportes/adminAgricola/informeProyeccionLaboresLote.xhtml";

		if (node.equals("Presupuesto de labores express"))
			url = "/XHTML/Reportes/adminAgricola/informePresupuestoExpres.xhtml";
		
		if (node.equals("Presupuesto de labores detallado"))
			url = "/XHTML/Reportes/adminAgricola/informePresupuestoDetallado.xhtml";
		/*
		 * if (node.equals("Labores programadas vs realizadas")) url =
		 * "/XHTML/Reportes/adminAgricola/informeProgramaVsRealizado2.xhtml";
		 */

		if (node.equals("Reporte de labores programadas"))
			url = "/XHTML/Reportes/adminAgricola/informeProgramacionLabores.xhtml";

		if (node.equals("Programación de siembras y cosechas"))
			url = "/XHTML/Reportes/adminAgricola/informeProgramaSiembraCosecha.xhtml";
		if (node.equals("Estado de las (O.T)"))
			url = "/XHTML/Reportes/adminAgricola/informeEstadoOrdenTrabajo.xhtml";

		if (node.equals("Costos por compañía mes a mes"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosFinca.xhtml";
		if (node.equals("Costos Vs Ingresos por compañía mes a mes"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosVsIngresosCompania.xhtml";
		if (node.equals("Costos por grupo de labor"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosGrupoLabor.xhtml";
		if (node.equals("Costos por elemento de costos"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosElementoCostos.xhtml";
		if (node.equals("Costos de insumos agricolas"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosInsumos.xhtml";
		if (node.equals("Detalle de insumos aplicados"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosInsumosDetallado.xhtml";

		if (node.equals("Costos de servicios contratados"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosServiciosContratados.xhtml";
		if (node.equals("Informe costos detallado"))
			url = "/XHTML/Reportes/adminAgricola/informeCostosTotales.xhtml";
		
		if (node.equals("Informe hoja de vida lote"))
			url = "/XHTML/Reportes/adminAgricola/informeHojaVidaLote.xhtml";
		
		if (node.equals("Informe PyG por lote"))
			url = "/XHTML/Reportes/adminAgricola/informePyG.xhtml";
		if (node.equals("Liquidación de contratistas"))
			url = "/XHTML/Reportes/adminAgricola/informeLiquidacionContratista.xhtml";
		if (node.equals("Nómina por conceptos"))
			url = "/XHTML/Reportes/adminAgricola/informeNomina.xhtml";

		if (node.equals("Actividades por trabajador"))
			url = "/XHTML/Reportes/adminAgricola/informeActividadesTrabajadorResumen.xhtml";

		if (node.equals("Actividades por trabajador - detalle"))
			url = "/XHTML/Reportes/adminAgricola/informeActividadesTrabajador.xhtml";

		if (node.equals("Rendimiento de trabajadores"))
			url = "/XHTML/Reportes/adminAgricola/informeRendimientoTrabajadores.xhtml";
		if (node.equals("Rendimiento de equipos"))
			url = "/XHTML/Reportes/adminAgricola/informeRendimientoEquipos.xhtml";
		if (node.equals("Horas equipos detalle"))
			url = "/XHTML/Reportes/adminAgricola/informeHorasMaquinaDetallado.xhtml";

		if (node.equals("Indicadores de Riegos"))
			url = "/XHTML/Reportes/adminAgricola/informeIndicadoresRiego.xhtml";

		if (node.equals("Variación precio de insumos"))
			url = "/XHTML/Reportes/adminAgricola/informeVariacionPrecioInsumos.xhtml";

		if (node.equals("Consulta de Stock por almacén"))
			url = "/XHTML/Reportes/adminAgricola/informeConsultaStockAlmacen.xhtml";

		if (node.equals("Salidas de productos por almacén - lote"))
			url = "/XHTML/Reportes/adminAgricola/informeSalidaInsumosLoteAlmacen.xhtml";

		if (node.equals("Reporte de labores manuales"))
			url = "/XHTML/Reportes/adminAgricola/informeNominaDetallada.xhtml";

		if (node.equals("Insumos aplicados(Excel)"))
			url = "/XHTML/Reportes/adminAgricola/informeInsumosAgricolasExcel.xhtml";

		if (node.equals("Otros costos indirectos distribuidos"))
			url = "/XHTML/Reportes/adminAgricola/informeOtrosCostosIndirectos.xhtml";
		if (node.equals("Consolidado de nómina(otros devengos)"))
			url = "/XHTML/Reportes/adminAgricola/informeConsolidadoNominaExcel.xhtml";

		if (node.equals("Disponibilidad hídrica"))
			url = "/XHTML/Reportes/adminAgricola/informeRiegoDetalladoExcel.xhtml";
		if (node.equals("Labores realizadas por Maquinaria/Equipo"))
			url = "/XHTML/Reportes/adminAgricola/informeMaquinariaDetalladaExcel.xhtml";
		
		/************Interfaces***/

		if (node.equals("Exportar novedades de Mano de obra (Manager)"))
			url = "/XHTML/ERP/Nomina/interfaceManagerExportRegMo.xhtml";
		
		if (node.equals("Exportar ausentismos de Mano de obra (Manager)"))
			url = "/XHTML/ERP/Nomina/interfaceManagerExportRegAusMo.xhtml";
		
		if (node.equals("Distri. de costos de nómina en los lotes"))
			url = "/XHTML/ERP/Nomina/interfaceDistribuccionCostosNominaLotes.xhtml";
		
		if (node.equals("Distri. de costos de Mtto de Maquinaria en los lotes"))
			url = "/XHTML/ERP/Maquinaria/interfaceDistribuccionCostosMaquinariaLotes.xhtml";
		
		if (node.equals("Cálculo de dominicales y festivos de la semana"))
			url = "/XHTML/ERP/Nomina/interfaceCalculoDominicalesFestivos.xhtml";
		
		if (node.equals("Importación de catalogo (Manager)"))
			url = "/XHTML/ERP/Catalogos/interfaceCatalogosManager.xhtml";
		
		
		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";

		return url;
	}

	public String eventosMenuProduccionAgricola(String node) {

		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		if (node.equals("Mot. estimativas de cosecha"))
			url = "/XHTML/ProdAgricola/produccionVentas/motEstimListDataTable.xhtml";
		if (node.equals("Frentes de cosecha"))
			url = "/XHTML/ProdAgricola/produccionVentas/frenteCosListDataTable.xhtml";
		if (node.equals("Tipos de cosecha"))
			url = "/XHTML/ProdAgricola/produccionVentas/modalidadCosechaListDataTable.xhtml";
		if (node.equals("Tipos clientes"))
			url = "/XHTML/ProdAgricola/produccionVentas/tipoClienteListDataTable.xhtml";
		if (node.equals("Transportadoras"))
			url = "/XHTML/ProdAgricola/produccionVentas/transportadoraListDataTable.xhtml";
		
		if (node.equals("Empresas"))
			url = "/XHTML/ProdAgricola/produccionVentas/persEmprListDataTable.xhtml";

		if (node.equals("Unidad de medida"))
			url = "/XHTML/ProdAgricola/produccionVentas/udadMedListDataTable.xhtml";
		if (node.equals("Profesiones/Cargos"))
			url = "/XHTML/ProdAgricola/produccionVentas/profesionListDataTable.xhtml";
		if (node.equals("Trabajadores"))
			url = "/XHTML/ProdAgricola/produccionVentas/trabajadorListDataTable.xhtml";
		if (node.equals("Fabricantes"))
			url = "/XHTML/ProdAgricola/produccionVentas/fabricanteEquipoListDataTable.xhtml";
		if (node.equals("Categorías"))
			url = "/XHTML/ProdAgricola/produccionVentas/categoriaEquipoListDataTable.xhtml";
		if (node.equals("Modelos"))
			url = "/XHTML/ProdAgricola/produccionVentas/modeloEquipoListDataTable.xhtml";
		if (node.equals("Medidores"))
			url = "/XHTML/ProdAgricola/produccionVentas/medidorListDataTable.xhtml";
		if (node.equals("Número de ejes"))
			url = "/XHTML/ProdAgricola/produccionVentas/numeroEjeListDataTable.xhtml";
		if (node.equals("Equipos"))
			url = "/XHTML/ProdAgricola/produccionVentas/equipoListDataTable.xhtml";
		if (node.equals("Tipos de productos"))
			url = "/XHTML/ProdAgricola/produccionVentas/tipoProductoListDataTable.xhtml";
		if (node.equals("Clases toxicológicas"))
			url = "/XHTML/ProdAgricola/produccionVentas/claseToxicologicaListDataTable.xhtml";
		if (node.equals("Almacén"))
			url = "/XHTML/ProdAgricola/produccionVentas/almacenListDataTable.xhtml";
		if (node.equals("Empaques"))
			url = "/XHTML/ProdAgricola/produccionVentas/empaqueListDataTable.xhtml";
		if (node.equals("Producto"))
			url = "/XHTML/ProdAgricola/produccionVentas/productoListDataTable.xhtml";
		if (node.equals("Grupos de labores"))
			url = "/XHTML/ProdAgricola/produccionVentas/grpLaborListDataTable.xhtml";
		if (node.equals("Labor"))
			url = "/XHTML/ProdAgricola/produccionVentas/laborListDataTable.xhtml";
		if (node.equals("Conceptos"))
			url = "/XHTML/ProdAgricola/produccionVentas/conceptoNominaListDataTable.xhtml";
		if (node.equals("CeCos"))
			url = "/XHTML/ProdAgricola/produccionVentas/centCostListDataTable.xhtml";
		if (node.equals("Elementos de costos"))
			url = "/XHTML/ProdAgricola/produccionVentas/elementoCostoListDataTable.xhtml";
		if (node.equals("Cuentas contables"))
			url = "/XHTML/ProdAgricola/produccionVentas/cuentaContableListDataTable.xhtml";
		if (node.equals("Variables de análisis"))
			url = "/XHTML/ProdAgricola/produccionVentas/variableLabListDataTable.xhtml";
		if (node.equals("Grupos de análisis"))
			url = "/XHTML/ProdAgricola/produccionVentas/anaLaboratorioListDataTable.xhtml";

		
		/**********+transacciones***/
		if (node.equals("Estimativas de cosecha"))
			url = "/XHTML/ProdAgricola/transacciones/datEstimCosechaListDataTable.xhtml";
		if (node.equals("Registros de producción"))
			url = "/XHTML/ProdAgricola/transacciones/datTransProdListDataTable.xhtml";

		/************Báscula*****/

		if (node.equals("Balanzas"))
			url = "/XHTML/ProdAgricola/Configuraciones/basculaListDataTable.xhtml";

		if (node.equals("Creación del Tiquete de pesaje"))
			url = "/XHTML/ProdAgricola/transacciones/datBascula.xhtml";

		//if (node.equals("Registros de peso bruto"))
			//url = "/XHTML/ProdAgricola/transacciones/datBasculaPesajeBruto.xhtml";

		//if (node.equals("Registros de peso tara"))
			//url = "/XHTML/ProdAgricola/transacciones/datBasculaPesajeTara.xhtml";

		if (node.equals("Corrección de tiquetes"))
			url = "/XHTML/ProdAgricola/transacciones/datBasculaCorreccion.xhtml";
		
		if (node.equals("Evaluación de calidad del fruto"))
			url = "/XHTML/ProdAgricola/transacciones/datAnaCalidadFruto.xhtml";
		
		if (node.equals("Edición - Evaluación de calidad del fruto"))
			url = "/XHTML/ProdAgricola/transacciones/datAnaCalidadFrutoEdicion.xhtml";
		

		
		if (node.equals("Consulta de tiquetes"))
			url = "/XHTML/ProdAgricola/transacciones/datBasculaConsultaTiquetes.xhtml";

		/****************************************************/
		if (node.equals("Análisis de laboratorio"))
			url = "/XHTML/ProdAgricola/transacciones/datAnaLaboratorioListDataTable.xhtml";
		if (node.equals("Análisis de post-cosecha"))
			url = "/XHTML/ProdAgricola/transacciones/datAnaTransProdListDataTable.xhtml";
		if (node.equals("Producto"))
			url = "/XHTML/ProdAgricola/produccionVentas/productoListDataTable.xhtml";

		// Reportes de producción agricola

		if (node.equals("Programa de Cosecha"))
			url = "/XHTML/Reportes/prodAgricola/informeProgramaCosecha.xhtml";
		if (node.equals("Producción por Lote"))
			url = "/XHTML/Reportes/prodAgricola/informeMateriaPrimaLote.xhtml";
		
		/*
		 * if (node.equals("Producción por Lote - Det")) url =
		 * "/XHTML/Reportes/prodAgricola/informeProduccionPesoPromLote.xhtml";
		 */
		if (node.equals("Toneladas vs toneladas/Ha"))
			url = "/XHTML/Reportes/prodAgricola/informeDatosProduccion.xhtml";
		if (node.equals("Toneladas vs rendimiento"))
			url = "/XHTML/Reportes/prodAgricola/informeToneladasVsRendimiento.xhtml";
		if (node.equals("Toneladas vs toneladas/Ha/Mes"))
			url = "/XHTML/Reportes/prodAgricola/informeToneladasVsToneladasHaMes.xhtml";
		if (node.equals("Producción(Ton) 5 años"))
			url = "/XHTML/Reportes/prodAgricola/informeProduccionAnios.xhtml";
		if (node.equals("Producción(Ton) Vs precipitación(mm)"))
			url = "/XHTML/Reportes/prodAgricola/informeProduccionVsLluvia.xhtml";

		if (node.equals("Toneladas despachadas producto"))
			url = "/XHTML/Reportes/prodAgricola/informeDespachoProducto.xhtml";
		if (node.equals("Toneladas despachadas cliente"))
			url = "/XHTML/Reportes/prodAgricola/informeDespachoProductoCliente.xhtml";
		if (node.equals("Variación precio fruta"))
			url = "/XHTML/Reportes/prodAgricola/informeVariacionPrecioFruta.xhtml";

		if (node.equals("Toneladas por número de cosechas"))
			url = "/XHTML/Reportes/prodAgricola/informeProduccionCortes.xhtml";

		if (node.equals("Producción por Hacienda(Finca)"))
			url = "/XHTML/Reportes/prodAgricola/informeProduccionAcumFinca.xhtml";

		if (node.equals("Producción por Hacienda(Finca)"))
			url = "/XHTML/Reportes/prodAgricola/informeProduccionAcumFinca.xhtml";

		if (node.equals("Producción por Lote(Detallado)"))
			url = "/XHTML/Reportes/prodAgricola/informeProduccionLoteDetallado.xhtml";

		if (node.equals("Movimientos de materia prima"))
			url = "/XHTML/Reportes/prodAgricola/informeConsolidadoProduccion.xhtml";
		if (node.equals("Despachos realizados"))
			url = "/XHTML/Reportes/prodAgricola/informeConsolidadoDespachos.xhtml";
		if (node.equals("Movimientos de balanza"))
			url = "/XHTML/Reportes/prodAgricola/informeMBascula.xhtml";
		if (node.equals("Log de balanza"))
			url = "/XHTML/Reportes/prodAgricola/logBascula.xhtml";
		
		if (node.equals("Consulta análisis de proceso industrial"))
			url = "/XHTML/Reportes/prodAgricola/informeAnalisisProcesoIndustrial.xhtml";
		
		
		
		
		
		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";

		return url;

	}

	public String eventosMenuMantenimientoMaquinaria(String node) {

		/*
		 * Catalogos de MANTENIMIENTO DE MAQUINARIA
		 * 
		 * <ui:composition template="/XHTML/tmp_inicio.xhtml">
		 */

		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		if (node.equals("Tipos de proveedor"))
			url = "/XHTML/MantenimientoMaquinaria/tipProveeListDataTable.xhtml";
		if (node.equals("Empresas"))
			url = "/XHTML/MantenimientoMaquinaria/persEmprListDataTable.xhtml";

		if (node.equals("Unidad de medida"))
			url = "/XHTML/MantenimientoMaquinaria/udadMedListDataTable.xhtml";
		if (node.equals("Factores de conversión"))
			url = "/XHTML/MantenimientoMaquinaria/factorConversionListDataTable.xhtml";

		if (node.equals("Profesiones/Cargos"))
			url = "/XHTML/MantenimientoMaquinaria/profesionMtto.xhtml";
		if (node.equals("Trabajadores"))
			url = "/XHTML/MantenimientoMaquinaria/trabajadorListDataTable.xhtml";

		if (node.equals("Fabricantes"))
			url = "/XHTML/MantenimientoMaquinaria/fabricanteEquipoListDataTable.xhtml";
		if (node.equals("Categorías"))
			url = "/XHTML/MantenimientoMaquinaria/categoriaEquipoListDataTable.xhtml";
		if (node.equals("Modelos"))
			url = "/XHTML/MantenimientoMaquinaria/modeloEquipoListDataTable.xhtml";
		if (node.equals("Flotas de transporte"))
			url = "/XHTML/MantenimientoMaquinaria/flotaTransporteListDataTable.xhtml";
		if (node.equals("Medidores"))
			url = "/XHTML/MantenimientoMaquinaria/medidorListDataTable.xhtml";
		if (node.equals("Número de ejes"))
			url = "/XHTML/MantenimientoMaquinaria/numeroEjeListDataTable.xhtml";
		if (node.equals("Maquinaria"))
			url = "/XHTML/MantenimientoMaquinaria/equipoListDataTable.xhtml";
		if (node.equals("Sistemas por equipo"))
			url = "/XHTML/MantenimientoMaquinaria/sistemasEquipoListDataTable.xhtml";
		if (node.equals("Compartimientos por equipo"))
			url = "/XHTML/MantenimientoMaquinaria/compartimientosEquipoListDataTable.xhtml";

		if (node.equals("Tipos de productos"))
			url = "/XHTML/MantenimientoMaquinaria/tipoProductoListDataTable.xhtml";
		if (node.equals("Clases toxicológicas"))
			url = "/XHTML/MantenimientoMaquinaria/claseToxicologicaListDataTable.xhtml";
		if (node.equals("Almacén"))
			url = "/XHTML/MantenimientoMaquinaria/almacenListDataTable.xhtml";
		if (node.equals("Producto"))
			url = "/XHTML/MantenimientoMaquinaria/productoListDataTable.xhtml";

		if (node.equals("Conceptos"))
			url = "/XHTML/MantenimientoMaquinaria/conceptoNominaListDataTable.xhtml";
		if (node.equals("CeCos"))
			url = "/XHTML/MantenimientoMaquinaria/centCostListDataTable.xhtml";
		if (node.equals("Cuentas contables"))
			url = "/XHTML/MantenimientoMaquinaria/cuentaContableListDataTable.xhtml";
		if (node.equals("Elementos de costos"))
			url = "/XHTML/MantenimientoMaquinaria/elementoCostoListDataTable.xhtml";
		if (node.equals("Turnos de campo"))
			url = "/XHTML/MantenimientoMaquinaria/turnoCampoListDataTable.xhtml";

		if (node.equals("Zonas de Fábrica"))
			url = "/XHTML/MantenimientoMaquinaria/zonasFabrica.xhtml";
		if (node.equals("Departamentos"))
			url = "/XHTML/MantenimientoMaquinaria/areaTrabajoListDataTable.xhtml";
		if (node.equals("Nivel de Prioridad"))
			url = "/XHTML/MantenimientoMaquinaria/nivelPrioridadListDataTable.xhtml";
		if (node.equals("Taller mécanico"))
			url = "/XHTML/MantenimientoMaquinaria/tallerMecanicoListDataTable.xhtml";
		if (node.equals("Agente causador de paradas"))
			url = "/XHTML/MantenimientoMaquinaria/agenteCausadorParadaListDataTable.xhtml";
		if (node.equals("Tipos de fallas"))
			url = "/XHTML/MantenimientoMaquinaria/motivosEntradaTallerListDataTable.xhtml";
		if (node.equals("Tipo de mantenimiento (mmto)"))
			url = "/XHTML/MantenimientoMaquinaria/tipoMantenimientoListDataTable.xhtml";
		if (node.equals("Planes de revisón"))
			url = "/XHTML/MantenimientoMaquinaria/planRevisionEquipoListDataTable.xhtml";
		if (node.equals("Tipos de abastecimiento"))
			url = "/XHTML/MantenimientoMaquinaria/tipoAbastecimientoListDataTable.xhtml";
		if (node.equals("Bombas de abastecimiento"))
			url = "/XHTML/MantenimientoMaquinaria/bombaAbastecimientoListDataTable.xhtml";

		if (node.equals("Eventos"))
			url = "/XHTML/MantenimientoMaquinaria/eventosListDataTable.xhtml";

		if (node.equals("Turnos del taller"))
			url = "/XHTML/MantenimientoMaquinaria/turnoCampoListDataTable.xhtml";

		if (node.equals("Grupos de labores"))
			url = "/XHTML/MantenimientoMaquinaria/grpLaborListDataTable.xhtml";
		if (node.equals("Labor"))
			url = "/XHTML/MantenimientoMaquinaria/laborListDataTable.xhtml";

		if (node.equals("Estado de eventos"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/InformeEquipoEventosVigencias.xhtml";

		/*
		 * Transaccionales de administracion agricola
		 * 
		 * <ui:composition template="/XHTML/tmp_inicio.xhtml">
		 */

		if (node.equals("Solicitud de Mtto de maquinaria"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datSolicitudesMttoListDataTable.xhtml";

		if (node.equals("Salidas de combustible"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datAbastCombustibleListDataTable.xhtml";

		if (node.equals("Mantenimiento de maquinaria"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datMantenimientoEquipoListDataTable.xhtml";

		if (node.equals("Consulta de documentos por pagar"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datConsultaEventosPorPagar.xhtml";

		if (node.equals("Otros costos"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datOtrosCostosMq.xhtml";

		if (node.equals("Registro de horas diarias"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datHorasTrabajoEquipoListDataTable.xhtml";

		if (node.equals("Servicios realizados"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datServRealizadosEquipoListDataTable.xhtml";

		if (node.equals("Registro de Check-list"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datCheckListEquipoListDataTable.xhtml";

		if (node.equals("Registro de fallas"))
			url = "/XHTML/MantenimientoMaquinaria/transacciones/datReporteFallasListDataTable.xhtml";

		
		// Reportes 
		
		if (node.equals("Consulta Info Maquinaria"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeConsultaMttoListDataTable.xhtml";
		
		if (node.equals("Consulta Info Stock Maquinaria"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeConsultaMttoStockListDataTable.xhtml";
		
		if (node.equals("Consultar próximos Mttos"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/consultaListaProximoMttoListDataTable.xhtml";

		if (node.equals("Consulta de Stock por almacén"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeConsultaStockAlmacenEquipo.xhtml";

		if (node.equals("Mantenimientos realizados a equipos"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeSolicitudesMttoDet.xhtml";

		if (node.equals("Otros costos de  Mtto"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeOtrosCostosIndirectosMq.xhtml";

		if (node.equals("Consulta de Fallas por equipos"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/MttoReporteFallasEquipos.xhtml";

		if (node.equals("Horas trabajadas por equipos"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/MttoReporteHorasTrabajadasEquipos.xhtml";

		if (node.equals("Consulta salidas de combustible"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/MttoReporteSalidaCombustibleEquipos.xhtml";

		if (node.equals("Consulta Plan de Fabrica"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informePlanDeFabrica.xhtml";

		if (node.equals("Consulta de checkList por equipos"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeCheckListEquipo.xhtml";

		if (node.equals("Proyección de Mtto"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeProyeccionMtto.xhtml";

		if (node.equals("Servicios realizados con maquinaria"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/informeServiciosRealizadosMaquinariaDetalladaExcel.xhtml";

		
		
		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";
		
			
		return url;

	}

	public String eventosMenuMantenimientoIndustrial(String node) {

		if (node.equals("Glosario de terminos"))
			url = "/XHTML/glosario.xhtml";

		if (node.equals("Tipos de proveedor"))
			url = "/XHTML/MantenimientoIndustrial/tipProveeListDataTable.xhtml";
		if (node.equals("Empresas"))
			url = "/XHTML/MantenimientoIndustrial/persEmprListDataTable.xhtml";

		if (node.equals("Unidad de medida"))
			url = "/XHTML/MantenimientoIndustrial/udadMedListDataTable.xhtml";
		if (node.equals("Factores de conversión"))
			url = "/XHTML/MantenimientoIndustrial/factorConversionListDataTable.xhtml";

		if (node.equals("Profesiones/Cargos"))
			url = "/XHTML/MantenimientoIndustrial/profesionMtto.xhtml";
		if (node.equals("Trabajadores"))
			url = "/XHTML/MantenimientoIndustrial/trabajadorListDataTable.xhtml";

		if (node.equals("Fabricantes"))
			url = "/XHTML/MantenimientoIndustrial/fabricanteEquipoListDataTable.xhtml";
		if (node.equals("Categorías"))
			url = "/XHTML/MantenimientoIndustrial/categoriaEquipoListDataTable.xhtml";
		if (node.equals("Modelos"))
			url = "/XHTML/MantenimientoIndustrial/modeloEquipoListDataTable.xhtml";
		if (node.equals("Flotas de transporte"))
			url = "/XHTML/MantenimientoIndustrial/flotaTransporteListDataTable.xhtml";
		if (node.equals("Medidores"))
			url = "/XHTML/MantenimientoIndustrial/medidorListDataTable.xhtml";
		if (node.equals("Número de ejes"))
			url = "/XHTML/MantenimientoIndustrial/numeroEjeListDataTable.xhtml";
		if (node.equals("Equipos"))
			url = "/XHTML/MantenimientoIndustrial/equipoListDataTable.xhtml";
		if (node.equals("Sistemas por equipo"))
			url = "/XHTML/MantenimientoIndustrial/sistemasEquipoListDataTable.xhtml";
		if (node.equals("Compartimientos por equipo"))
			url = "/XHTML/MantenimientoIndustrial/compartimientosEquipoListDataTable.xhtml";

		if (node.equals("Tipos de productos"))
			url = "/XHTML/MantenimientoIndustrial/tipoProductoListDataTable.xhtml";
		if (node.equals("Clases toxicológicas"))
			url = "/XHTML/MantenimientoIndustrial/claseToxicologicaListDataTable.xhtml";
		if (node.equals("Almacén"))
			url = "/XHTML/MantenimientoIndustrial/almacenListDataTable.xhtml";
		if (node.equals("Producto"))
			url = "/XHTML/MantenimientoIndustrial/productoListDataTable.xhtml";

		if (node.equals("Conceptos"))
			url = "/XHTML/MantenimientoIndustrial/conceptoNominaListDataTable.xhtml";
		if (node.equals("CeCos"))
			url = "/XHTML/MantenimientoIndustrial/centCostListDataTable.xhtml";
		if (node.equals("Cuentas contables"))
			url = "/XHTML/MantenimientoIndustrial/cuentaContableListDataTable.xhtml";
		if (node.equals("Elementos de costos"))
			url = "/XHTML/MantenimientoIndustrial/elementoCostoListDataTable.xhtml";
		if (node.equals("Turnos de campo"))
			url = "/XHTML/MantenimientoIndustrial/turnoCampoListDataTable.xhtml";

		if (node.equals("Zonas de Fábrica"))
			url = "/XHTML/MantenimientoIndustrial/zonasFabrica.xhtml";
		if (node.equals("Departamento"))
			url = "/XHTML/MantenimientoIndustrial/areaTrabajoListDataTable.xhtml";
		if (node.equals("Nivel de Prioridad"))
			url = "/XHTML/MantenimientoIndustrial/nivelPrioridadListDataTable.xhtml";
		if (node.equals("Taller mécanico"))
			url = "/XHTML/MantenimientoIndustrial/tallerMecanicoListDataTable.xhtml";
		if (node.equals("Agente causador de paradas"))
			url = "/XHTML/MantenimientoIndustrial/agenteCausadorParadaListDataTable.xhtml";
		if (node.equals("Tipos de fallas"))
			url = "/XHTML/MantenimientoIndustrial/motivosEntradaTallerListDataTable.xhtml";
		if (node.equals("Tipo de mantenimiento (mmto)"))
			url = "/XHTML/MantenimientoIndustrial/tipoMantenimientoListDataTable.xhtml";
		if (node.equals("Planes de revisón"))
			url = "/XHTML/MantenimientoIndustrial/planRevisionEquipoListDataTable.xhtml";
		if (node.equals("Tipos de abastecimiento"))
			url = "/XHTML/MantenimientoIndustrial/tipoAbastecimientoListDataTable.xhtml";
		if (node.equals("Bombas de abastecimiento"))
			url = "/XHTML/MantenimientoIndustrial/bombaAbastecimientoListDataTable.xhtml";

		if (node.equals("Eventos"))
			url = "/XHTML/MantenimientoIndustrial/eventosListDataTable.xhtml";

		if (node.equals("Turnos del taller"))
			url = "/XHTML/MantenimientoIndustrial/turnoCampoListDataTable.xhtml";

		if (node.equals("Grupos de labores"))
			url = "/XHTML/MantenimientoIndustrial/grpLaborListDataTable.xhtml";
		if (node.equals("Labor"))
			url = "/XHTML/MantenimientoIndustrial/laborListDataTable.xhtml";

		if (node.equals("Estado de eventos"))
			url = "/XHTML/Reportes/MantenimientoIndustrial/InformeEquipoEventosVigencias.xhtml";

		if (node.equals("TAG'S"))
			url = "/XHTML/MantenimientoIndustrial/tagListDataTable.xhtml";

		if (node.equals("Variables de análisis"))
			url = "/XHTML/MantenimientoIndustrial/variableLabListDataTable.xhtml";

		if (node.equals("Grupos de análisis"))
			url = "/XHTML/MantenimientoIndustrial/anaLaboratorioListDataTable.xhtml";


		
		
		/*
		 * Transaccionales
		 */

		if (node.equals("Solicitud de Mtto de equipo"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datSolicitudesMttoListDataTable.xhtml";

		if (node.equals("Salidas de combustible"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datAbastCombustibleListDataTable.xhtml";

		if (node.equals("Mantenimiento de equipos"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datMantenimientoEquipoListDataTable.xhtml";

		if (node.equals("Consulta de documentos por pagar"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datConsultaEventosPorPagar.xhtml";

		if (node.equals("Otros costos por equipo"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datOtrosCostosMq.xhtml";

		if (node.equals("Registro de horas diarias por equipo"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datHorasTrabajoEquipoListDataTable.xhtml";

		//if (node.equals("Servicios realizados por equipo"))
			//url = "/XHTML/MantenimientoIndustrial/transacciones/datServRealizadosEquipoListDataTable.xhtml";

		if (node.equals("Registro de Check-list por equipo"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datCheckListEquipoListDataTable.xhtml";

		if (node.equals("Registro de fallas por equipo"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datReporteFallasListDataTable.xhtml";

		if (node.equals("Plan anual de fábrica"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datPlanAnualFabricaListDataTable.xhtml";

		if (node.equals("Registro de paradas en fábrica"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datParadasFabricaListDataTable.xhtml";

		if (node.equals("Digitación de análisis"))
			url = "/XHTML/MantenimientoIndustrial/transacciones/datAnaLaboratorioListDataTable.xhtml";
		
		// Reportes 
		if (node.equals("Consultar próximos Mttos"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/consultaListaProximoMttoListDataTable.xhtml";

		if (node.equals("Consulta de Stock por almacén"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informeConsultaStockAlmacenEquipo.xhtml";

		if (node.equals("Mttos realizados por equipo"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informeSolicitudesMttoDet.xhtml";

		if (node.equals("Otros costos de  Mtto de equipos"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informeOtrosCostosIndirectosMq.xhtml";

		if (node.equals("Consulta de fallas de equipos"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/MttoReporteFallasEquipos.xhtml";

		if (node.equals("Horas trabajadas de equipos"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/MttoReporteHorasTrabajadasEquipos.xhtml";

		if (node.equals("Consulta Salidas de combustible"))
			url = "/XHTML/Reportes/mantenimientoMaquinaria/MttoReporteSalidaCombustibleEquipos.xhtml";

		if (node.equals("Consulta plan anual de fábrica"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informePlanDeFabrica.xhtml";

		if (node.equals("CheckList por equipo"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informeCheckListEquipo.xhtml";

		if (node.equals("Proyección de Mtto"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informeProyeccionMtto.xhtml";
		
		if (node.equals("Consulta análisis de proceso industrial"))
			url = "/XHTML/Reportes/mantenimientoIndustrial/informeAnalisisProcesoIndustrial.xhtml";



		if (url.equals(""))
			url = "/XHTML/tmp_modulo.xhtml";

		return url;

	}

	public void onNodeUnselect(NodeUnselectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unselected",
				event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void deleteNode() {
		selectedNode.getChildren().clear();
		selectedNode.getParent().getChildren().remove(selectedNode);
		selectedNode.setParent(null);

		selectedNode = null;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getTituloModulo() {
		return tituloModulo;
	}

	public void setTituloModulo(String tituloModulo) {
		this.tituloModulo = tituloModulo;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getOnActiveIdleSession() {
		return onActiveIdleSession;
	}

	public void setOnActiveIdleSession(String onActiveIdleSession) {
		this.onActiveIdleSession = onActiveIdleSession;
	}

	public String getTxt8() {
		return txt8;
	}

	public void setTxt8(String txt8) {
		this.txt8 = txt8;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}
