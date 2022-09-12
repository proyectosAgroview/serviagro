package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "menuService")
@ApplicationScoped
public class MenuService implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tituloModulo;

	public TreeNode createMenus(String modulo) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		TreeNode root = null;

		if (modulo.equals("tecno_agricola")) {
			setTituloModulo("Tecnología Agrícola");
			root = crearTecnoAgricola();
		} else if (modulo.equals("info_agricola")) {
			setTituloModulo("Información Agrícola");
			root = crearInfoAgricola();
		} else if (modulo.equals("admin_agricola")) {
			setTituloModulo("Administración Agrícola");
			root = crearAdminAgricola();
		} else if (modulo.equals("prod_agricola")) {
			setTituloModulo("Producción Agrícola");
			root = crearProdAgricola();
		} else if (modulo.equals("mantenimiento_maquinaria")) {
			setTituloModulo("Mantenimiento de Maquinaria");
			root = crearMantenimientoMaquinaria();
		} else if (modulo.equals("sgu")) {
			setTituloModulo("Gestión de Usuarios");
			root = crearSgu();
		} else if (modulo.equals("mantenimiento_industrial")) {
			setTituloModulo("Mantenimiento industrial");
			root = crearMantenimientoIndustrial();
		}

		return root;

	}

	private TreeNode crearSgu() {

		TreeNode root6 = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);

		TreeNode catalogo61 = new DefaultTreeNode(new Menu("Configuraciones", "-", "Folder"), root6);

		TreeNode cm = new DefaultTreeNode("document", new Menu("Contenidos del menu", "-", "Word Document"), catalogo61);

		TreeNode gt = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"), catalogo61);
		

		TreeNode catalogo6 = new DefaultTreeNode(new Menu("SGU", "-", "Folder"), root6);

		TreeNode usr = new DefaultTreeNode("document", new Menu("Usuarios", "-", "Word Document"), catalogo6);

		TreeNode gp = new DefaultTreeNode("document", new Menu("Grupos", "-", "Word Document"), catalogo6);
		
		TreeNode comp = new DefaultTreeNode("document", new Menu("Compañia", "-", "Word Document"), catalogo6);

		return root6;
	}

	@SuppressWarnings("unused")
	public TreeNode crearTecnoAgricola() {

		TreeNode root = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);
		TreeNode catalogo11 = new DefaultTreeNode(new Menu("Ayuda", "-", "Folder"), root);

		TreeNode gta = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"),
				catalogo11);

		TreeNode catalogo = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), root);

		/* Catalogos de Sanidad Vegetal */
		TreeNode saniveg = new DefaultTreeNode(new Menu("Sanidad vegetal", "-", "Folder"), catalogo);
		TreeNode fitosanidad = new DefaultTreeNode("document", new Menu("Fitosanidad", "-", "Word Document"), saniveg);
		TreeNode fasefenologicas = new DefaultTreeNode("document", new Menu("Fases fenologicas", "-", "Word Document"),
				saniveg);

		/// TreeNode anasani = new DefaultTreeNode(new Menu("Análisis de
		/// sanidad",
		// "-", "Folder"), saniveg);
		// TreeNode analisis = new DefaultTreeNode("document", new Menu(
		// "Análisis", "-", "Word Document"), anasani);
		// TreeNode variables = new DefaultTreeNode("document", new Menu(
		// "Variables", "-", "Word Document"), anasani);

		TreeNode estpluviometrica = new DefaultTreeNode("document", new Menu("Pluviómetros", "-", "Word Document"),
				saniveg);
		TreeNode estevaporimetro = new DefaultTreeNode("document", new Menu("Evaporímetros", "-", "Word Document"),
				saniveg);
		TreeNode estclima = new DefaultTreeNode("document", new Menu("Estación climatológica", "-", "Word Document"),
				saniveg);

		/* Pantallas Transaccionales */

		TreeNode datos = new DefaultTreeNode(new Menu("Transacciones", "-", "Folder"), root);
		TreeNode clima = new DefaultTreeNode(new Menu("Clima", "-", "Folder"), datos);
		TreeNode regprecipitacion = new DefaultTreeNode("document",
				new Menu("Registros pluviometricos", "-", "Word Document"), clima);
		// TreeNode regevaporacion = new DefaultTreeNode("document", new Menu(
		// "Registros de evaporación", "-", "Word Document"), clima);
		TreeNode regclima = new DefaultTreeNode("document", new Menu("Registros climáticos", "-", "Word Document"),
				clima);
		TreeNode transaniveg = new DefaultTreeNode(new Menu("Sanidad vegetal", "-", "Folder"), datos);
		// TreeNode datsanveg = new DefaultTreeNode("document", new Menu(
		// "Registros de análisis fitosanidades", "-", "Word Document"),
		// transaniveg);
		TreeNode datsanvegd = new DefaultTreeNode("document",
				new Menu("Registros de análisis de diatrea", "-", "Word Document"), transaniveg);
		TreeNode datsanvega = new DefaultTreeNode("document",
				new Menu("Registros de análisis de suelo", "-", "Word Document"), transaniveg);

		TreeNode anpla = new DefaultTreeNode("document", new Menu("Análisis de plagas", "-", "Word Document"), transaniveg);
		TreeNode anenf = new DefaultTreeNode("document", new Menu("Análisis de enfermedades", "-", "Word Document"), transaniveg);
		TreeNode cpl = new DefaultTreeNode("document", new Menu("Censo de productividad por lote", "-", "Word Document"), transaniveg);
		TreeNode cpv = new DefaultTreeNode("document", new Menu("Análisis de polinización", "-", "Word Document"), transaniveg);

		/**** Reportes ****/
		TreeNode datos1 = new DefaultTreeNode(new Menu("Reportes", "-", "Folder"), root);

		TreeNode clim = new DefaultTreeNode(new Menu("Clima", "-", "Folder"), datos1);
		// TreeNode pdd = new DefaultTreeNode("document", new Menu(
		// "Precipitación día a día", "-", "Word Document"), clim);
		TreeNode pddd = new DefaultTreeNode("document",
				new Menu("Cuadro de precipitación(mm) dia/mes", "-", "Word Document"), clim);

		// TreeNode cpr = new DefaultTreeNode("document", new Menu(
		// "Precipitación(mm) 5 años", "-", "Word Document"), clim);
		// TreeNode edd = new DefaultTreeNode("document", new Menu(
		// "Evaporación día a día", "-", "Word Document"), clim);
		TreeNode dc = new DefaultTreeNode("document", new Menu("Datos climatologicos", "-", "Word Document"), clim);
		// TreeNode temp = new DefaultTreeNode("document", new Menu(
		// "Temp. mínima vs Temp. máxima", "-", "Word Document"), clim);

		TreeNode sanv = new DefaultTreeNode(new Menu("Sanidad vegetal", "-", "Folder"), datos1);

		// TreeNode aenf = new DefaultTreeNode("document", new Menu(
		// "Análisis de enfermedades", "-", "Word Document"), fit);
		// TreeNode inenf = new DefaultTreeNode("document", new Menu(
		// "Casos Vs incidencia acumulada por enfermedad", "-", "Word
		// Document"), fit);
		// TreeNode anpla = new DefaultTreeNode("document", new Menu(
		// "Análisis de plagas", "-", "Word Document"), fit);
		TreeNode andia = new DefaultTreeNode("document", new Menu("Análisis de diatraea", "-", "Word Document"), sanv);
		TreeNode anPlag = new DefaultTreeNode("document", new Menu("Reporte de Plagas", "-", "Word Document"), sanv);
		TreeNode anEnf = new DefaultTreeNode("document", new Menu("Reporte de Enfermedades", "-", "Word Document"), sanv);
		
		TreeNode maPlag = new DefaultTreeNode("document", new Menu("Mapa de Plagas", "-", "Word Document"), sanv);
		TreeNode maEnf = new DefaultTreeNode("document", new Menu("Mapa de Enfermedades", "-", "Word Document"), sanv);
		
		TreeNode cenProd = new DefaultTreeNode("document", new Menu("Reporte de censo de prod. por lote", "-", "Word Document"), sanv);
		
		return root;

	}

	@SuppressWarnings("unused")
	public TreeNode crearInfoAgricola() {

		TreeNode root2 = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);
		TreeNode catalogo21 = new DefaultTreeNode(new Menu("Ayuda", "-", "Folder"), root2);

		TreeNode gta = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"),
				catalogo21);

		TreeNode catalogo2 = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), root2);
		TreeNode agronomia = new DefaultTreeNode(new Menu("Agronomía", "-", "Folder"), catalogo2);
		TreeNode datprimario = new DefaultTreeNode(new Menu("Datos primarios", "-", "Folder"), agronomia);
		TreeNode undm = new DefaultTreeNode("document", new Menu("Unidad de medida", "-", "Word Document"), datprimario);
		TreeNode compania = new DefaultTreeNode("document", new Menu("Compañía", "-", "Word Document"), datprimario);
		TreeNode bancos = new DefaultTreeNode("document", new Menu("Bancos", "-", "Word Document"), datprimario);

		TreeNode cultivo = new DefaultTreeNode("document", new Menu("Cultivo", "-", "Word Document"), datprimario);
		TreeNode anofiscal = new DefaultTreeNode("document", new Menu("Año fiscal", "-", "Word Document"), datprimario);
		TreeNode calendario = new DefaultTreeNode("document", new Menu("Calendario", "-", "Word Document"),
				datprimario);
		TreeNode dst = new DefaultTreeNode("document", new Menu("Tipos de días", "-", "Word Document"), datprimario);
		TreeNode moneda = new DefaultTreeNode("document", new Menu("Moneda", "-", "Word Document"), datprimario);

		TreeNode semana = new DefaultTreeNode("document", new Menu("Periodos de pago", "-", "Word Document"),
				datprimario);

		TreeNode admin = new DefaultTreeNode(new Menu("Administración", "-", "Folder"), agronomia);
		// TreeNode generalidades = new DefaultTreeNode(new
		// Menu("Generalidades",
		// "-", "Folder"), admin);
		TreeNode empresas = new DefaultTreeNode("document", new Menu("Empresas", "-", "Word Document"), admin);

		TreeNode divipoli = new DefaultTreeNode(new Menu("División política", "-", "Folder"), admin);
		TreeNode pais = new DefaultTreeNode("document", new Menu("País", "-", "Word Document"), divipoli);
		TreeNode estado = new DefaultTreeNode("document", new Menu("Estado", "-", "Word Document"), divipoli);
		TreeNode ciudad = new DefaultTreeNode("document", new Menu("Ciudad", "-", "Word Document"), divipoli);
		TreeNode ver = new DefaultTreeNode("document", new Menu("Vereda", "-", "Word Document"), divipoli);

		// TreeNode banc = new DefaultTreeNode(new Menu("Entidades Bancarias",
		// "-", "Folder"), admin);
		// TreeNode conbanc = new DefaultTreeNode("document", new Menu(
		// "Contactos bancarios", "-", "Word Document"), banc);

		// TreeNode tiposproveedor = new DefaultTreeNode("document", new Menu(
		// "Tipos de proveedor", "-", "Word Document"), generalidades);

		TreeNode propiedad = new DefaultTreeNode(new Menu("Propiedades del cultivo", "-", "Folder"), admin);
		// TreeNode tenecias = new DefaultTreeNode(new Menu("Tenencias", "-",
		// "Folder"), propiedad);

		// TreeNode gt = new DefaultTreeNode("document", new Menu(
		// "Grupo de tenencia", "-", "Word Document"), tenecias);
		// TreeNode tenen = new DefaultTreeNode("document", new Menu("Tenencia",
		// "-", "Word Document"), tenecias);
		// TreeNode tc = new DefaultTreeNode("document", new Menu("Tipos
		// cultivo",
		// "-", "Word Document"), propiedad);
		TreeNode zg = new DefaultTreeNode("document", new Menu("Zona geográfica", "-", "Word Document"), propiedad);
		TreeNode za = new DefaultTreeNode("document", new Menu("Zona agroecológica", "-", "Word Document"), propiedad);
		// TreeNode op = new DefaultTreeNode("document", new Menu("Ocupación",
		// "-", "Word Document"), propiedad);
		// TreeNode og = new DefaultTreeNode("document", new
		// Menu("Organización",
		// "-", "Word Document"), propiedad);
		TreeNode variedad = new DefaultTreeNode("document", new Menu("Variedad", "-", "Word Document"), propiedad);
		TreeNode etapacultivo = new DefaultTreeNode("document", new Menu("Etapa del cultivo", "-", "Word Document"),
				propiedad);
		// TreeNode rq = new DefaultTreeNode("document", new Menu(
		// "Restricción de quema", "-", "Word Document"), propiedad);
		// TreeNode rm = new DefaultTreeNode("document", new Menu(
		// "Restricción de madurante", "-", "Word Document"), propiedad);
		// TreeNode nf = new DefaultTreeNode("document", new Menu(
		// "Niveles de fertilidad", "-", "Word Document"), propiedad);
		// TreeNode df = new DefaultTreeNode("document", new Menu(
		// "Dificultad de acceso", "-", "Word Document"), propiedad);
		TreeNode ds = new DefaultTreeNode("document", new Menu("Distancia de siembra", "-", "Word Document"),
				propiedad);

		// TreeNode suelos = new DefaultTreeNode(
		// new Menu("Suelos", "-", "Folder"), propiedad);
		// TreeNode gs = new DefaultTreeNode("document", new Menu(
		// "Grupos de suelos", "-", "Word Document"), suelos);
		/*
		 * TreeNode ld = new DefaultTreeNode("document", new Menu("Lara Edad",
		 * "-", "Word Document"), suelos);
		 */
		// TreeNode ss = new DefaultTreeNode("document", new Menu(
		// "Series de suelos", "-", "Word Document"), suelos);
		// TreeNode os = new DefaultTreeNode("document", new Menu(
		// "Orden de suelos", "-", "Word Document"), suelos);

		// TreeNode texturas = new DefaultTreeNode(new Menu("Texturas", "-",
		// "Folder"), propiedad);
		// TreeNode ft = new DefaultTreeNode("document", new Menu(
		// "Familia de texturas", "-", "Word Document"), texturas);
		// TreeNode ct = new DefaultTreeNode("document", new Menu(
		// "Clases de texturas", "-", "Word Document"), texturas);

		// TreeNode mn4 = new DefaultTreeNode("document", new Menu(
		// "Motivos de unión/división nivel 4", "-", "Word Document"),
		// propiedad);
		// TreeNode mep = new DefaultTreeNode("document", new Menu(
		// "Motivos de erradicación de plantas", "-", "Word Document"),
		// propiedad);
		// TreeNode cl = new DefaultTreeNode("document", new Menu("Larvas", "-",
		// "Word Document"), propiedad);
		// TreeNode td = new DefaultTreeNode("document", new Menu(
		// "Tipos de drenaje", "-", "Word Document"), propiedad);
		// TreeNode tgs = new DefaultTreeNode("document", new
		// Menu("Topografías",
		// "-", "Word Document"), propiedad);

		TreeNode estructuraCampos = new DefaultTreeNode(new Menu("Estructura de Campos", "-", "Folder"), catalogo2);
		TreeNode nivel1 = new DefaultTreeNode("document", new Menu("Zona", "-", "Word Document"), estructuraCampos);
		TreeNode nivel2 = new DefaultTreeNode("document", new Menu("Hacienda", "-", "Word Document"), estructuraCampos);
		TreeNode nivel3 = new DefaultTreeNode("document", new Menu("Bloque", "-", "Word Document"), estructuraCampos);
		TreeNode nivel4 = new DefaultTreeNode("document", new Menu("Lote", "-", "Word Document"), estructuraCampos);
		// TreeNode es = new DefaultTreeNode("document", new Menu(
		// "Estructura de siembra", "-", "Word Document"),
		// estructuraCampos);

		/**** Reportes ****/
		TreeNode datos = new DefaultTreeNode(new Menu("Reportes", "-", "Folder"), root2);

		TreeNode prl = new DefaultTreeNode("document", new Menu("Prontuario de Lotes", "-", "Word Document"), datos);

		return root2;
	}

	@SuppressWarnings("unused")
	public TreeNode crearAdminAgricola() {

		TreeNode root3 = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);
		TreeNode catalogo33 = new DefaultTreeNode(new Menu("Ayuda", "-", "Folder"), root3);

		TreeNode gta = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"),
				catalogo33);

		TreeNode catalogo3 = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), root3);

		// TreeNode plan = new DefaultTreeNode(new Menu(
		// " y Ejecución", "-", "Folder"), catalogo3);
		TreeNode und = new DefaultTreeNode(new Menu("Unidades de medida", "-", "Folder"), catalogo3);
		TreeNode undm = new DefaultTreeNode("document", new Menu("Unidad de medida", "-", "Word Document"), und);
		TreeNode factorconver = new DefaultTreeNode("document",
				new Menu("Factores de conversión", "-", "Word Document"), und);

		// TreeNode er = new DefaultTreeNode(new Menu("Proveedores/Empresas",
		// "-",
		// "Folder"), catalogo3);
		// TreeNode tiposproveedor = new DefaultTreeNode("document", new Menu(
		// "Tipos de proveedor", "-", "Word Document"), er);
		TreeNode empresas = new DefaultTreeNode("document", new Menu("Empresas", "-", "Word Document"), catalogo3);
		TreeNode costos = new DefaultTreeNode(new Menu("Costos", "-", "Folder"), catalogo3);
		TreeNode ccontable = new DefaultTreeNode("document", new Menu("Cuentas contables", "-", "Word Document"),
				costos);
		TreeNode ceptonomi = new DefaultTreeNode("document", new Menu("Conceptos", "-", "Word Document"), costos);
		TreeNode cecos = new DefaultTreeNode("document", new Menu("CeCos", "-", "Word Document"), costos);
		TreeNode elemcos = new DefaultTreeNode("document", new Menu("Elementos de costos", "-", "Word Document"),
				costos);

		TreeNode mo = new DefaultTreeNode(new Menu("Mano de obra", "-", "Folder"), catalogo3);
		TreeNode profesion = new DefaultTreeNode("document", new Menu("Profesiones/Cargos", "-", "Word Document"), mo);
		TreeNode trabajador = new DefaultTreeNode("document", new Menu("Trabajadores", "-", "Word Document"), mo);
		// TreeNode equipostrab = new DefaultTreeNode("document", new Menu(
		// "Equipos de trabajo", "-", "Word Document"), mo);

		TreeNode maq = new DefaultTreeNode(new Menu("Maquinaria y equipos", "-", "Folder"), catalogo3);
		TreeNode fabricante = new DefaultTreeNode("document", new Menu("Fabricantes", "-", "Word Document"), maq);
		TreeNode categoria = new DefaultTreeNode("document", new Menu("Categorías", "-", "Word Document"), maq);
		TreeNode modelo = new DefaultTreeNode("document", new Menu("Modelos", "-", "Word Document"), maq);
		//TreeNode flotatransp = new DefaultTreeNode("document", new Menu("Flotas de transporte", "-", "Word Document"),
			//	maq);
		TreeNode medidor = new DefaultTreeNode("document", new Menu("Medidores", "-", "Word Document"), maq);
		TreeNode numeje = new DefaultTreeNode("document", new Menu("Número de ejes", "-", "Word Document"), maq);
		TreeNode equipo = new DefaultTreeNode("document", new Menu("Equipos", "-", "Word Document"), maq);

		TreeNode prod = new DefaultTreeNode(new Menu("Productos y servicios", "-", "Folder"), catalogo3);
		TreeNode almacen = new DefaultTreeNode("document", new Menu("Almacén", "-", "Word Document"), prod);
		TreeNode tipoprod = new DefaultTreeNode("document", new Menu("Tipos de productos", "-", "Word Document"), prod);
		// TreeNode ingrediente = new DefaultTreeNode("document", new Menu(
		// "Ingrediente activo", "-", "Word Document"), prod);
		TreeNode clasetoxi = new DefaultTreeNode("document", new Menu("Clases toxicológicas", "-", "Word Document"),
				prod);
		TreeNode emp = new DefaultTreeNode("document", new Menu("Empaques", "-", "Word Document"), prod);
		TreeNode producto = new DefaultTreeNode("document", new Menu("Producto", "-", "Word Document"), prod);

		TreeNode riego = new DefaultTreeNode(new Menu("Riegos", "-", "Folder"), catalogo3);
		TreeNode tipoinfra = new DefaultTreeNode("document",
				new Menu("Tipos de infraestructuras", "-", "Word Document"), riego);
		TreeNode infraes = new DefaultTreeNode("document", new Menu("Infraestructuras", "-", "Word Document"), riego);
		TreeNode sistrie = new DefaultTreeNode("document", new Menu("Sistemas de riego", "-", "Word Document"), riego);

		TreeNode cromg = new DefaultTreeNode(new Menu("Presupuesto de labores", "-", "Folder"), catalogo3);

		TreeNode cromPl = new DefaultTreeNode("document", new Menu("Plan anual de labores por Hacienda", "-", "Word Document"),
				cromg);
		
		TreeNode cromEx = new DefaultTreeNode("document", new Menu("Cronograma de labores express", "-", "Word Document"),
				cromg);
		
		TreeNode serv = new DefaultTreeNode("document", new Menu("Otros recursos/Servicios", "-", "Word Document"),
				cromg);

		TreeNode tpr = new DefaultTreeNode("document", new Menu("Configuración de recursos", "-", "Word Document"),
				cromg);
		
		TreeNode cromL = new DefaultTreeNode("document", new Menu("Cronograma de labores", "-", "Word Document"),
				cromg);


		TreeNode lab = new DefaultTreeNode(new Menu("Labores", "-", "Folder"), catalogo3);
		TreeNode grplab = new DefaultTreeNode("document", new Menu("Grupos de labores", "-", "Word Document"), lab);
		TreeNode labor = new DefaultTreeNode("document", new Menu("Labor", "-", "Word Document"), lab);

		TreeNode turno = new DefaultTreeNode(new Menu("Turnos", "-", "Folder"), catalogo3);
		TreeNode turncamp = new DefaultTreeNode("document", new Menu("Turnos de campo", "-", "Word Document"), turno);

		TreeNode idprod = new DefaultTreeNode(new Menu("Identificadores de producción", "-", "Folder"), catalogo3);
		TreeNode idprodc = new DefaultTreeNode("document", new Menu("Colores identificadores", "-", "Word Document"),
				idprod);

		/* Transaccionales */

		TreeNode datos3 = new DefaultTreeNode(new Menu("Transacciones", "-", "Folder"), root3);
		/*
		 * TreeNode planificacion = new DefaultTreeNode(new
		 * Menu("Planificación", "-", "Folder"), datos3); TreeNode plabores =
		 * new DefaultTreeNode("document", new Menu( "Programador de labores",
		 * "-", "Word Document"), datos3);
		 * 
		 * /*TreeNode plabores2 = new DefaultTreeNode("document", new Menu(
		 * "Programa(V2) de labores", "-", "Word Document"), planificacion); /*
		 * TreeNode plaborec = new DefaultTreeNode("document", new Menu(
		 * "Recursos asociados", "-", "Word Document"), planificacion); TreeNode
		 * ot = new DefaultTreeNode("document", new Menu(
		 * "Cierre de orden de trabajo(OT)", "-", "Word Document"),
		 * planificacion);
		 */
		/*
		 * TreeNode ejecucion = new DefaultTreeNode(new Menu("Ejecución", "-",
		 * "Folder"), datos3);
		 */
		TreeNode proybores =
				  new DefaultTreeNode("document", new Menu( "Proyección de labores a realizar por Hda/Lote",
				  "-", "Word Document"), datos3);

		TreeNode plabores =
				  new DefaultTreeNode("document", new Menu( "Programador operativo de labores",
				  "-", "Word Document"), datos3);

		TreeNode plabApro =
				  new DefaultTreeNode("document", new Menu( "Autorización de labores a ejecutar",
				  "-", "Word Document"), datos3);
		
		TreeNode ejecLab = new DefaultTreeNode("document", new Menu("Ejecución de labores con (O.T)", "-", "Word Document"),
		datos3);

		TreeNode ejecLabNoPlan = new DefaultTreeNode("document", new Menu("Ejecución de labores(Sin O.T)", "-", "Word Document"),
				datos3);
		TreeNode ejecLabUni = new DefaultTreeNode("document", new Menu("Ejecución de labores Unificada", "-", "Word Document"),
				datos3);
		TreeNode ejecins = new DefaultTreeNode("document", new Menu("Ejecución de labores con insumos", "-", "Word Document"),
				datos3);

		TreeNode nTrabajador = new DefaultTreeNode("document",
				new Menu("Consolidación de nóminas", "-", "Word Document"), datos3);

		
		TreeNode rem = new DefaultTreeNode("document", new Menu("Registro de entradas a almacén", "-", "Word Document"), datos3);

		TreeNode ocostos = new DefaultTreeNode("document", new Menu("Otros costos", "-", "Word Document"), datos3);

		/*
		 * TreeNode ejecPol = new DefaultTreeNode("document", new Menu(
		 * "Polinización", "-", "Word Document"), datos3);
		 */

		/*
		 * TreeNode ejecLab2 = new DefaultTreeNode("document", new Menu(
		 * "Ejecución(V2) de labores", "-", "Word Document"), ejecucion);
		 * 
		 * TreeNode report = new DefaultTreeNode(new Menu("Reportes", "-",
		 * "Folder"), root3); TreeNode lprore = new DefaultTreeNode("document",
		 * new Menu( "Labores programadas vs realizadas", "-", "Word Document"),
		 * report); TreeNode lcos = new DefaultTreeNode("document", new Menu(
		 * "Programación de cosecha", "-", "Word Document"), report);
		 * 
		 * /* TreeNode regnom = new DefaultTreeNode("document", new Menu(
		 * "Registros de nómina", "-", "Word Document"), ejecucion); TreeNode
		 * regserv = new DefaultTreeNode("document", new Menu(
		 * "Registros de servicios", "-", "Word Document"), ejecucion); /*
		 * TreeNode inventarios = new DefaultTreeNode(new Menu("Inventarios",
		 * "-", "Folder"), ejecucion); TreeNode cstoke = new
		 * DefaultTreeNode("document", new Menu( "Control de Stock", "-",
		 * "Word Document"), inventarios); TreeNode entherra = new
		 * DefaultTreeNode("document", new Menu( "Entrega de herramientas", "-",
		 * "Word Document"), inventarios);
		 *
		 * TreeNode salprod = new DefaultTreeNode("document", new Menu(
		 * "Aplicación de productos", "-", "Word Document"), ejecucion);
		 * TreeNode regejec = new DefaultTreeNode("document", new Menu(
		 * "Registros de riegos", "-", "Word Document"), ejecucion);
		 */

		// TreeNode plaboresr = new DefaultTreeNode("document", new Menu(
		// "Programación de riegos", "-", "Word Document"), datos3);

		/**** Reportes ****/
		TreeNode datos4 = new DefaultTreeNode(new Menu("Reportes", "-", "Folder"), root3);
		/**** Administración agricola ***/


		
		TreeNode planf = new DefaultTreeNode(new Menu("Presupuesto", "-", "Folder"), datos4);
		
		TreeNode prh = new DefaultTreeNode("document",
				new Menu("Presupuesto de labores por hacienda", "-", "Word Document"), planf);

		TreeNode pll = new DefaultTreeNode("document", new Menu("Proyección de labores por lote", "-", "Word Document"),
				planf);
		
		TreeNode prex = new DefaultTreeNode("document",
				new Menu("Presupuesto de labores express", "-", "Word Document"), planf);

		TreeNode prd = new DefaultTreeNode("document",
				new Menu("Presupuesto de labores detallado", "-", "Word Document"), planf);

		
		 TreeNode pld = new DefaultTreeNode("document", new Menu(
		 "Reporte de labores programadas", "-", "Word Document"), datos4); 
		 
		/* TreeNode  plr = new DefaultTreeNode("document", new Menu(
		  "Labores programadas vs realizadas", "-", "Word Document"), datos4);
		 /* TreeNode psc = new DefaultTreeNode("document", new Menu(
		 * "Programación de siembras y cosechas", "-", "Word Document"), planf);
		  TreeNode eot = new DefaultTreeNode("document", new Menu(
		  "Estado de las (O.T)", "-", "Word Document"), datos4);*/
		 
		 
		TreeNode eject = new DefaultTreeNode(new Menu("Ejecución", "-", "Folder"), datos4);

		TreeNode mos = new DefaultTreeNode(new Menu("Mano de obra/Servicios", "-", "Folder"), eject);
		/*
		 * TreeNode act = new DefaultTreeNode("document", new Menu(
		 * "Actividades por trabajador", "-", "Word Document"), mos); TreeNode
		 * actr = new DefaultTreeNode("document", new Menu(
		 * "Actividades por trabajador - detalle", "-", "Word Document"), mos);
		 * /* TreeNode nom = new DefaultTreeNode("document", new Menu(
		 * "Nómina por conceptos", "-", "Word Document"), mos);
		 */
		TreeNode nomdet = new DefaultTreeNode("document", new Menu("Reporte de labores manuales", "-", "Word Document"), mos);

		TreeNode conI = new DefaultTreeNode("document",
				new Menu("Consolidado de nómina(otros devengos)", "-", "Word Document"), mos);

		/*
		 * TreeNode liqc = new DefaultTreeNode("document", new Menu(
		 * "Liquidación de contratistas", "-", "Word Document"), mos);
		 */
		TreeNode ins = new DefaultTreeNode(new Menu("Insumos", "-", "Folder"), eject);
		/*
		 * TreeNode cia = new DefaultTreeNode("document", new Menu(
		 * "Variación precio de insumos", "-", "Word Document"), ins);
		 */
		TreeNode stock = new DefaultTreeNode("document",
				new Menu("Consulta de Stock por almacén", "-", "Word Document"), ins);
		

		TreeNode spa = new DefaultTreeNode("document", 
				new Menu("Salidas de productos por almacén - lote", "-", "Word Document"),
				ins);
		
		/*
		 * TreeNode stockss = new DefaultTreeNode("document", new Menu(
		 * "Salidas de productos por almacén - lote", "-", "Word Document"),
		 * ins); TreeNode cias = new DefaultTreeNode("document", new Menu(
		 * "Costos de insumos agricolas", "-", "Word Document"), ins); TreeNode
		 * diac = new DefaultTreeNode("document", new Menu(
		 * "Detalle de insumos aplicados", "-", "Word Document"), ins);
		 */
		TreeNode diac2 = new DefaultTreeNode("document", new Menu("Insumos aplicados(Excel)", "-", "Word Document"),
				ins);
		

		TreeNode maqQ = new DefaultTreeNode(new Menu("Maquinaria", "-", "Folder"), eject);
		/*
		 * TreeNode rmad = new DefaultTreeNode("document", new Menu(
		 * "Horas equipos detalle", "-", "Word Document"), maqQ);
		 */
		TreeNode rmmad = new DefaultTreeNode("document",
				new Menu("Labores realizadas por Maquinaria/Equipo", "-", "Word Document"), maqQ);

		TreeNode consi = new DefaultTreeNode(new Menu("Otros costos indirectos", "-", "Folder"), eject);
		TreeNode ots = new DefaultTreeNode("document",
				new Menu("Otros costos indirectos distribuidos", "-", "Word Document"), consi);

		TreeNode cons = new DefaultTreeNode(new Menu("Costos", "-", "Folder"), eject);
		/*
		 * TreeNode ccm = new DefaultTreeNode("document", new Menu(
		 * "Costos por compañía mes a mes", "-", "Word Document"), cons);
		 * TreeNode cvsi = new DefaultTreeNode("document", new Menu(
		 * "Costos Vs Ingresos por compañía mes a mes", "-", "Word Document"),
		 * cons); TreeNode cgl = new DefaultTreeNode("document", new Menu(
		 * "Costos por grupo de labor", "-", "Word Document"), cons); TreeNode
		 * celc = new DefaultTreeNode("document", new Menu(
		 * "Costos por elemento de costos", "-", "Word Document"), cons);
		 * TreeNode csc = new DefaultTreeNode("document", new Menu(
		 * "Costos de servicios contratados", "-", "Word Document"), cons);
		 */

		TreeNode ctd = new DefaultTreeNode("document", new Menu("Informe costos detallado", "-", "Word Document"),
				cons);
		TreeNode hvl = new DefaultTreeNode("document", new Menu("Informe hoja de vida lote", "-", "Word Document"),
				cons);
		/*
		 * TreeNode pyg = new DefaultTreeNode("document", new Menu(
		 * "Informe PyG por lote", "-", "Word Document"), cons);
		 */
		TreeNode irie = new DefaultTreeNode(new Menu("Riegos", "-", "Folder"), datos4);
		TreeNode dhi = new DefaultTreeNode("document", new Menu("Disponibilidad hídrica", "-", "Word Document"), irie);

		/*
		 * TreeNode ine = new DefaultTreeNode(new Menu(
		 * "Indicadores de eficiencia", "-", "Folder"), datos4); TreeNode rto =
		 * new DefaultTreeNode("document", new Menu(
		 * "Rendimiento de trabajadores", "-", "Word Document"), ine); TreeNode
		 * rma = new DefaultTreeNode("document", new Menu(
		 * "Rendimiento de equipos", "-", "Word Document"), ine); TreeNode inr =
		 * new DefaultTreeNode("document", new Menu( "Indicadores de Riegos",
		 * "-", "Word Document"), ine);
		 */
		

		TreeNode datos5 = new DefaultTreeNode(new Menu("Interfaces", "-", "Folder"), root3);
		
		TreeNode ct = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), datos5);
		
		 TreeNode ipr =  new DefaultTreeNode("document", new Menu(
				 "Importación de catalogo (Manager)", "-", "Word Document"), ct); 
		
		TreeNode tr = new DefaultTreeNode(new Menu("Transacciones", "-", "Folder"), datos5);
		
		 TreeNode cdfes =  new DefaultTreeNode("document", new Menu(
				 "Cálculo de dominicales y festivos de la semana", "-", "Word Document"), tr); 
		
		TreeNode inmmo =  new DefaultTreeNode("document", new Menu(
		 "Exportar novedades de Mano de obra (Manager)", "-",  "Word Document"), tr); 
		
		
		 TreeNode inexmmo =  new DefaultTreeNode("document", new Menu(
				 "Exportar ausentismos de Mano de obra (Manager)", "-", "Word Document"), tr); 
	
		 TreeNode d1 =  new DefaultTreeNode("document", new Menu(
				 "Distri. de costos de nómina en los lotes", "-", "Word Document"), tr); 
	
		 TreeNode d2 =  new DefaultTreeNode("document", new Menu(
				 "Distri. de costos de Mtto de Maquinaria en los lotes", "-", "Word Document"), tr); 
		 
		 
	
		 
		return root3;
	}

	@SuppressWarnings("unused")
	public TreeNode crearMantenimientoMaquinaria() {

		TreeNode root7 = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);
		TreeNode catalogo33 = new DefaultTreeNode(new Menu("Ayuda", "-", "Folder"), root7);

		TreeNode gta = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"),
				catalogo33);

		TreeNode catalogoM3 = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), root7);

		TreeNode und = new DefaultTreeNode(new Menu("Unidades de medida", "-", "Folder"), catalogoM3);
		TreeNode undm = new DefaultTreeNode("document", new Menu("Unidad de medida", "-", "Word Document"), und);
		TreeNode factorconver = new DefaultTreeNode("document",
				new Menu("Factores de conversión", "-", "Word Document"), und);

		TreeNode er = new DefaultTreeNode(new Menu("Proveedores/Empresas", "-", "Folder"), catalogoM3);
		TreeNode tiposproveedor = new DefaultTreeNode("document", new Menu("Tipos de proveedor", "-", "Word Document"),
				er);
		TreeNode empresas = new DefaultTreeNode("document", new Menu("Empresas", "-", "Word Document"), er);

		TreeNode mo = new DefaultTreeNode(new Menu("Mano de obra", "-", "Folder"), catalogoM3);
		TreeNode profesion = new DefaultTreeNode("document", new Menu("Profesiones/Cargos", "-", "Word Document"), mo);
		TreeNode trabajador = new DefaultTreeNode("document", new Menu("Trabajadores", "-", "Word Document"), mo);

		TreeNode maq = new DefaultTreeNode(new Menu("Maquinaria y equipos", "-", "Folder"), catalogoM3);
		TreeNode fabricante = new DefaultTreeNode("document", new Menu("Fabricantes", "-", "Word Document"), maq);
		TreeNode categoria = new DefaultTreeNode("document", new Menu("Categorías", "-", "Word Document"), maq);
		TreeNode modelo = new DefaultTreeNode("document", new Menu("Modelos", "-", "Word Document"), maq);
	//	TreeNode flotatransp = new DefaultTreeNode("document", new Menu("Flotas de transporte", "-", "Word Document"),
		//		maq);
		TreeNode medidor = new DefaultTreeNode("document", new Menu("Medidores", "-", "Word Document"), maq);
		TreeNode numeje = new DefaultTreeNode("document", new Menu("Número de ejes", "-", "Word Document"), maq);
		TreeNode equipo = new DefaultTreeNode("document", new Menu("Maquinaria", "-", "Word Document"), maq);
		TreeNode sequipo = new DefaultTreeNode("document", new Menu("Sistemas por equipo", "-", "Word Document"), maq);
		TreeNode cequipo = new DefaultTreeNode("document", new Menu("Compartimientos por equipo", "-", "Word Document"), maq);

		
		TreeNode prod = new DefaultTreeNode(new Menu("Productos y servicios", "-", "Folder"), catalogoM3);
		TreeNode almacen = new DefaultTreeNode("document", new Menu("Almacén", "-", "Word Document"), prod);
		TreeNode tipoprod = new DefaultTreeNode("document", new Menu("Tipos de productos", "-", "Word Document"), prod);
		TreeNode clasetoxi = new DefaultTreeNode("document", new Menu("Clases toxicológicas", "-", "Word Document"),
				prod);
		TreeNode producto = new DefaultTreeNode("document", new Menu("Producto", "-", "Word Document"), prod);

		TreeNode lab = new DefaultTreeNode(new Menu("Labores", "-", "Folder"), catalogoM3);
		TreeNode grplab = new DefaultTreeNode("document", new Menu("Grupos de labores", "-", "Word Document"), lab);
		TreeNode labor = new DefaultTreeNode("document", new Menu("Labor", "-", "Word Document"), lab);

		
		TreeNode mmto = new DefaultTreeNode(new Menu("Mantenimiento", "-", "Folder"), catalogoM3);
	//	TreeNode at = new DefaultTreeNode("document", new Menu("Departamentos", "-", "Word Document"), mmto);
		TreeNode np2 = new DefaultTreeNode("document", new Menu("Nivel de Prioridad", "-", "Word Document"), mmto);

				TreeNode tm = new DefaultTreeNode("document", new Menu("Taller mécanico", "-", "Word Document"), mmto);
		TreeNode agc = new DefaultTreeNode("document", new Menu("Agente causador de paradas", "-", "Word Document"),
				mmto);
		TreeNode mte = new DefaultTreeNode("document", new Menu("Tipos de fallas", "-", "Word Document"),
				mmto);
		TreeNode tmmto = new DefaultTreeNode("document", new Menu("Tipo de mantenimiento (mmto)", "-", "Word Document"),
				mmto);
		TreeNode planr = new DefaultTreeNode("document", new Menu("Planes de revisón", "-", "Word Document"), mmto);
		//Zonas de Fábrica
		//TreeNode zf= new DefaultTreeNode("document", new Menu("Zonas de Fábrica", "-", "Word Document"), mmto);

		TreeNode abc = new DefaultTreeNode(new Menu("Abastecimiento", "-", "Folder"), catalogoM3);
		TreeNode tab = new DefaultTreeNode("document", new Menu("Tipos de abastecimiento", "-", "Word Document"), abc);
		TreeNode bom = new DefaultTreeNode("document", new Menu("Bombas de abastecimiento", "-", "Word Document"), abc);

		TreeNode doc = new DefaultTreeNode(new Menu("Documentación", "-", "Folder"), catalogoM3);
		TreeNode even = new DefaultTreeNode("document", new Menu("Eventos", "-", "Word Document"), doc);

		TreeNode costos = new DefaultTreeNode(new Menu("Costos", "-", "Folder"), catalogoM3);
		TreeNode ccontable = new DefaultTreeNode("document", new Menu("Cuentas contables", "-", "Word Document"),
				costos);
		TreeNode elemcos = new DefaultTreeNode("document", new Menu("Elementos de costos", "-", "Word Document"),
				costos);
		TreeNode cecos = new DefaultTreeNode("document", new Menu("CeCos", "-", "Word Document"), costos);
		TreeNode ceptonomi = new DefaultTreeNode("document", new Menu("Conceptos", "-", "Word Document"), costos);
		
		TreeNode turno = new DefaultTreeNode(new Menu("Turnos", "-", "Folder"), catalogoM3);
		TreeNode turncamp = new DefaultTreeNode("document", new Menu("Turnos del taller", "-", "Word Document"), turno);

		/* Transaccionales */

		TreeNode datos3 = new DefaultTreeNode(new Menu("Transacciones", "-", "Folder"), root7);
		/*
		 * TreeNode planificacion = new DefaultTreeNode(new
		 * Menu("Planificación", "-", "Folder"), datos3);
		 */
		
		//Solicitud de Mtto de equipo/maquinaria
		

		TreeNode smem = new DefaultTreeNode("document", new Menu("Solicitud de Mtto de maquinaria", "-", "Word Document"),
				datos3);
		
		TreeNode mmt = new DefaultTreeNode("document", new Menu("Mantenimiento de maquinaria", "-", "Word Document"),
				datos3);
		
		TreeNode abast = new DefaultTreeNode("document", new Menu("Salidas de combustible", "-", "Word Document"),
				datos3);
		TreeNode rhd = new DefaultTreeNode("document", new Menu("Registro de horas diarias", "-", "Word Document"),
				datos3);
		
		TreeNode chek = new DefaultTreeNode("document", new Menu("Registro de Check-list", "-", "Word Document"),
				datos3);
		TreeNode rfe = new DefaultTreeNode("document", new Menu("Registro de fallas", "-", "Word Document"),
				datos3);


		TreeNode dpa = new DefaultTreeNode("document", new Menu("Consulta de documentos por pagar", "-", "Word Document"),
				datos3);
		TreeNode oce = new DefaultTreeNode("document", new Menu("Otros costos", "-", "Word Document"),
				datos3);
		TreeNode sre = new DefaultTreeNode("document", new Menu("Servicios realizados", "-", "Word Document"),
				datos3);

		/**** Reportes ****/
		TreeNode datos4 = new DefaultTreeNode(new Menu("Reportes", "-", "Folder"), root7);
		
		// Proyección de Mtto de equipo/Maquinaria
		TreeNode pyeMtto = new DefaultTreeNode("document",	new Menu("Proyección de Mtto", "-", "Word Document"), datos4);
		
		TreeNode ConsMtto = new DefaultTreeNode("document",	new Menu("Consulta Info Maquinaria", "-", "Word Document"), datos4);
		
		TreeNode ConsStockMtto = new DefaultTreeNode("document",	new Menu("Consulta Info Stock Maquinaria", "-", "Word Document"), datos4);
				
		TreeNode cpmttos = new DefaultTreeNode("document",
				new Menu("Consultar próximos Mttos", "-", "Word Document"), datos4);

		TreeNode stockss = new DefaultTreeNode("document",
				new Menu("Consulta de Stock por almacén", "-", "Word Document"), datos4);

		TreeNode solMtto = new DefaultTreeNode("document",
				new Menu("Mantenimientos realizados a equipos", "-", "Word Document"), datos4);
		

		TreeNode otrosMtto = new DefaultTreeNode("document",
				new Menu("Otros costos de  Mtto", "-", "Word Document"), datos4);

		TreeNode fallassMtto = new DefaultTreeNode("document",
				new Menu("Consulta de Fallas por equipos", "-", "Word Document"), datos4);
		
		TreeNode horasMtto = new DefaultTreeNode("document",
				new Menu("Horas trabajadas por equipos", "-", "Word Document"), datos4);
		
		TreeNode scMtto = new DefaultTreeNode("document",
				new Menu("Consulta salidas de combustible", "-", "Word Document"), datos4);
		
		TreeNode serMtto = new DefaultTreeNode("document",
				new Menu("Servicios realizados con maquinaria", "-", "Word Document"), datos4);
		
		//TreeNode pfMtto = new DefaultTreeNode("document",
		//		new Menu("Consulta Plan de Fabrica", "-", "Word Document"), datos4);
		// CheckList Equipo
		TreeNode chMtto = new DefaultTreeNode("document",
				new Menu("Consulta de checkList por equipos", "-", "Word Document"), datos4);
		
		
		return root7;
	}

	@SuppressWarnings("unused")
	public TreeNode crearMantenimientoIndustrial() {

		TreeNode root7 = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);
		TreeNode catalogo33 = new DefaultTreeNode(new Menu("Ayuda", "-", "Folder"), root7);

		TreeNode gta = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"),
				catalogo33);

		TreeNode catalogoM3 = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), root7);

		TreeNode und = new DefaultTreeNode(new Menu("Unidades de medida", "-", "Folder"), catalogoM3);
		TreeNode undm = new DefaultTreeNode("document", new Menu("Unidad de medida", "-", "Word Document"), und);
		TreeNode factorconver = new DefaultTreeNode("document",
				new Menu("Factores de conversión", "-", "Word Document"), und);

		TreeNode er = new DefaultTreeNode(new Menu("Proveedores/Empresas", "-", "Folder"), catalogoM3);
		TreeNode tiposproveedor = new DefaultTreeNode("document", new Menu("Tipos de proveedor", "-", "Word Document"),
				er);
		TreeNode empresas = new DefaultTreeNode("document", new Menu("Empresas", "-", "Word Document"), er);

		TreeNode mo = new DefaultTreeNode(new Menu("Mano de obra", "-", "Folder"), catalogoM3);
		TreeNode profesion = new DefaultTreeNode("document", new Menu("Profesiones/Cargos", "-", "Word Document"), mo);
		TreeNode trabajador = new DefaultTreeNode("document", new Menu("Trabajadores", "-", "Word Document"), mo);

		TreeNode maq = new DefaultTreeNode(new Menu("Maquinaria y equipos", "-", "Folder"), catalogoM3);
		TreeNode fabricante = new DefaultTreeNode("document", new Menu("Fabricantes", "-", "Word Document"), maq);
		TreeNode categoria = new DefaultTreeNode("document", new Menu("Categorías", "-", "Word Document"), maq);
		TreeNode modelo = new DefaultTreeNode("document", new Menu("Modelos", "-", "Word Document"), maq);
		//TreeNode flotatransp = new DefaultTreeNode("document", new Menu("Flotas de transporte", "-", "Word Document"),
		//		maq);
		TreeNode medidor = new DefaultTreeNode("document", new Menu("Medidores", "-", "Word Document"), maq);
		//TreeNode numeje = new DefaultTreeNode("document", new Menu("Número de ejes", "-", "Word Document"), maq);
		
		TreeNode numeje = new DefaultTreeNode("document", new Menu("TAG'S", "-", "Word Document"), maq);
		
		TreeNode equipo = new DefaultTreeNode("document", new Menu("Equipos", "-", "Word Document"), maq);
		TreeNode sequipo = new DefaultTreeNode("document", new Menu("Sistemas por equipo", "-", "Word Document"), maq);
		TreeNode cequipo = new DefaultTreeNode("document", new Menu("Compartimientos por equipo", "-", "Word Document"), maq);

		
		TreeNode prod = new DefaultTreeNode(new Menu("Productos y servicios", "-", "Folder"), catalogoM3);
		TreeNode almacen = new DefaultTreeNode("document", new Menu("Almacén", "-", "Word Document"), prod);
		TreeNode tipoprod = new DefaultTreeNode("document", new Menu("Tipos de productos", "-", "Word Document"), prod);
		//TreeNode clasetoxi = new DefaultTreeNode("document", new Menu("Clases toxicológicas", "-", "Word Document"),
		//		prod);
		TreeNode producto = new DefaultTreeNode("document", new Menu("Producto", "-", "Word Document"), prod);

		TreeNode lab = new DefaultTreeNode(new Menu("Labores", "-", "Folder"), catalogoM3);
		TreeNode grplab = new DefaultTreeNode("document", new Menu("Grupos de labores", "-", "Word Document"), lab);
		TreeNode labor = new DefaultTreeNode("document", new Menu("Labor", "-", "Word Document"), lab);

		
		TreeNode mmto = new DefaultTreeNode(new Menu("Mantenimiento", "-", "Folder"), catalogoM3);
		//Zonas de Fábrica
		//TreeNode zf= new DefaultTreeNode("document", new Menu("Zonas de Fábrica", "-", "Word Document"), mmto);
		TreeNode at = new DefaultTreeNode("document", new Menu("Departamento", "-", "Word Document"), mmto);

		TreeNode np2 = new DefaultTreeNode("document", new Menu("Nivel de Prioridad", "-", "Word Document"), mmto);

		//TreeNode tm = new DefaultTreeNode("document", new Menu("Taller mécanico", "-", "Word Document"), mmto);
		TreeNode agc = new DefaultTreeNode("document", new Menu("Agente causador de paradas", "-", "Word Document"),
				mmto);
		TreeNode mte = new DefaultTreeNode("document", new Menu("Tipos de fallas", "-", "Word Document"),
				mmto);
		TreeNode tmmto = new DefaultTreeNode("document", new Menu("Tipo de mantenimiento (mmto)", "-", "Word Document"),
				mmto);
		TreeNode planr = new DefaultTreeNode("document", new Menu("Planes de revisón", "-", "Word Document"), mmto);

		//TreeNode abc = new DefaultTreeNode(new Menu("Abastecimiento", "-", "Folder"), catalogoM3);
		//TreeNode tab = new DefaultTreeNode("document", new Menu("Tipos de abastecimiento", "-", "Word Document"), abc);
		//TreeNode bom = new DefaultTreeNode("document", new Menu("Bombas de abastecimiento", "-", "Word Document"), abc);

		TreeNode doc = new DefaultTreeNode(new Menu("Documentación", "-", "Folder"), catalogoM3);
		TreeNode even = new DefaultTreeNode("document", new Menu("Eventos", "-", "Word Document"), doc);

		TreeNode costos = new DefaultTreeNode(new Menu("Costos", "-", "Folder"), catalogoM3);
		TreeNode ccontable = new DefaultTreeNode("document", new Menu("Cuentas contables", "-", "Word Document"),
				costos);
		TreeNode elemcos = new DefaultTreeNode("document", new Menu("Elementos de costos", "-", "Word Document"),
				costos);
		TreeNode cecos = new DefaultTreeNode("document", new Menu("CeCos", "-", "Word Document"), costos);

		TreeNode ceptonomi = new DefaultTreeNode("document", new Menu("Conceptos", "-", "Word Document"), costos);
		
		TreeNode turno = new DefaultTreeNode(new Menu("Turnos", "-", "Folder"), catalogoM3);
		TreeNode turncamp = new DefaultTreeNode("document", new Menu("Turnos del taller", "-", "Word Document"), turno);

		TreeNode pInds = new DefaultTreeNode(new Menu("Análisis del proceso industrial", "-", "Folder"), catalogoM3);
		TreeNode pIndus1 = new DefaultTreeNode("document", new Menu("Variables de análisis", "-", "Word Document"), pInds);
		TreeNode pIndus2 = new DefaultTreeNode("document", new Menu("Grupos de análisis", "-", "Word Document"), pInds);
		
		/* Transaccionales */

		TreeNode datos3 = new DefaultTreeNode(new Menu("Transacciones", "-", "Folder"), root7);
		/*
		 * TreeNode planificacion = new DefaultTreeNode(new
		 * Menu("Planificación", "-", "Folder"), datos3);
		 */
		
		//Solicitud de Mtto de equipo/maquinaria
		

		TreeNode smem = new DefaultTreeNode("document", new Menu("Solicitud de Mtto de equipo", "-", "Word Document"),
				datos3);

		TreeNode mmt = new DefaultTreeNode("document", new Menu("Mantenimiento de equipos", "-", "Word Document"),
				datos3);		
		//TreeNode abast = new DefaultTreeNode("document", new Menu("Salidas de combustible", "-", "Word Document"),
		//		datos3);
		TreeNode rhd = new DefaultTreeNode("document", new Menu("Registro de horas diarias por equipo", "-", "Word Document"),
				datos3);
		
		TreeNode chek = new DefaultTreeNode("document", new Menu("Registro de Check-list por equipo", "-", "Word Document"),
				datos3);
		TreeNode rfe = new DefaultTreeNode("document", new Menu("Registro de fallas por equipo", "-", "Word Document"),
				datos3);

		TreeNode dpa = new DefaultTreeNode("document", new Menu("Consulta de documentos por pagar", "-", "Word Document"),
				datos3);
		TreeNode oce = new DefaultTreeNode("document", new Menu("Otros costos por equipo", "-", "Word Document"),
				datos3);
		//TreeNode sre = new DefaultTreeNode("document", new Menu("Servicios realizados por equipo", "-", "Word Document"),
		//		datos3);

		TreeNode paf = new DefaultTreeNode("document", new Menu("Plan anual de fábrica", "-", "Word Document"),
				datos3);

		TreeNode paradaf = new DefaultTreeNode("document", new Menu("Registro de paradas en fábrica", "-", "Word Document"),
				datos3);
		TreeNode dana = new DefaultTreeNode("document", new Menu("Digitación de análisis", "-", "Word Document"),
				datos3);
		
		/**** Reportes ****/
		TreeNode datos4 = new DefaultTreeNode(new Menu("Reportes", "-", "Folder"), root7);

		TreeNode pfMtto = new DefaultTreeNode("document",
				new Menu("Consulta plan anual de fábrica", "-", "Word Document"), datos4);

		TreeNode cpf = new DefaultTreeNode("document",
				new Menu("Consulta paros en fábrica", "-", "Word Document"), datos4);

				
		TreeNode cpmttos = new DefaultTreeNode("document",
				new Menu("Consultar próximos Mttos", "-", "Word Document"), datos4);
		
		TreeNode pyeMtto = new DefaultTreeNode("document",
				new Menu("Proyección de Mtto", "-", "Word Document"), datos4);

		TreeNode horasMtto = new DefaultTreeNode("document",
				new Menu("Horas trabajadas de equipos", "-", "Word Document"), datos4);
		
		TreeNode stockss = new DefaultTreeNode("document",
				new Menu("Consulta de Stock por almacén", "-", "Word Document"), datos4);

		TreeNode solMtto = new DefaultTreeNode("document",
				new Menu("Mttos realizados por equipo", "-", "Word Document"), datos4);

		TreeNode otrosMtto = new DefaultTreeNode("document",
				new Menu("Otros costos de  Mtto de equipos", "-", "Word Document"), datos4);

		TreeNode fallassMtto = new DefaultTreeNode("document",
				new Menu("Consulta de fallas de equipos", "-", "Word Document"), datos4);
		
		
		//TreeNode scMtto = new DefaultTreeNode("document",
		//		new Menu("Conuslta Salidas de combustible", "-", "Word Document"), datos4);
		

		TreeNode chMtto = new DefaultTreeNode("document",
				new Menu("CheckList por equipo", "-", "Word Document"), datos4);

		TreeNode b6 = new DefaultTreeNode("document",
				new Menu("Consulta análisis de proceso industrial", "-", "Word Document"), datos4);
		
		
		return root7;
	}

	@SuppressWarnings("unused")
	public TreeNode crearProdAgricola() {

		TreeNode root4 = new DefaultTreeNode(new Menu("Files", "-", "Folder"), null);
		TreeNode catalogo44 = new DefaultTreeNode(new Menu("Ayuda", "-", "Folder"), root4);

		TreeNode gta = new DefaultTreeNode("document", new Menu("Glosario de terminos", "-", "Word Document"),
				catalogo44);
		
		TreeNode catalogoc = new DefaultTreeNode(new Menu("Configuraciones", "-", "Folder"), root4);
		TreeNode r0 = new DefaultTreeNode("document",
				new Menu("Balanzas", "-", "Word Document"), catalogoc);
		
		
		TreeNode catalogo4 = new DefaultTreeNode(new Menu("Catalogos", "-", "Folder"), root4);
		
		TreeNode undm = new DefaultTreeNode("document", new Menu("Unidad de medida", "-", "Word Document"), catalogo4);
		
		TreeNode empresas = new DefaultTreeNode("document", new Menu("Empresas", "-", "Word Document"), catalogo4);
		TreeNode costos = new DefaultTreeNode(new Menu("Costos", "-", "Folder"), catalogo4);
		TreeNode ccontable = new DefaultTreeNode("document", new Menu("Cuentas contables", "-", "Word Document"),
				costos);
		TreeNode elemcos = new DefaultTreeNode("document", new Menu("Elementos de costos", "-", "Word Document"),
				costos);
		TreeNode cecos = new DefaultTreeNode("document", new Menu("CeCos", "-", "Word Document"), costos);
		
		TreeNode ceptonomi = new DefaultTreeNode("document", new Menu("Conceptos", "-", "Word Document"), costos);
		
		TreeNode mo = new DefaultTreeNode(new Menu("Mano de obra", "-", "Folder"), catalogo4);
		TreeNode profesion = new DefaultTreeNode("document", new Menu("Profesiones/Cargos", "-", "Word Document"), mo);
		TreeNode trabajador = new DefaultTreeNode("document", new Menu("Trabajadores", "-", "Word Document"), mo);
		// TreeNode equipostrab = new DefaultTreeNode("document", new Menu(
		// "Equipos de trabajo", "-", "Word Document"), mo);

		TreeNode maq = new DefaultTreeNode(new Menu("Maquinaria y equipos", "-", "Folder"), catalogo4);
		TreeNode fabricante = new DefaultTreeNode("document", new Menu("Fabricantes", "-", "Word Document"), maq);
		TreeNode categoria = new DefaultTreeNode("document", new Menu("Categorías", "-", "Word Document"), maq);
		TreeNode modelo = new DefaultTreeNode("document", new Menu("Modelos", "-", "Word Document"), maq);
		//TreeNode flotatransp = new DefaultTreeNode("document", new Menu("Flotas de transporte", "-", "Word Document"),
			//	maq);
		TreeNode medidor = new DefaultTreeNode("document", new Menu("Medidores", "-", "Word Document"), maq);
		TreeNode numeje = new DefaultTreeNode("document", new Menu("Número de ejes", "-", "Word Document"), maq);
		TreeNode equipo = new DefaultTreeNode("document", new Menu("Equipos", "-", "Word Document"), maq);

		TreeNode prod = new DefaultTreeNode(new Menu("Productos y servicios", "-", "Folder"), catalogo4);
		TreeNode almacen = new DefaultTreeNode("document", new Menu("Almacén", "-", "Word Document"), prod);
		TreeNode tipoprod = new DefaultTreeNode("document", new Menu("Tipos de productos", "-", "Word Document"), prod);
		// TreeNode ingrediente = new DefaultTreeNode("document", new Menu(
		// "Ingrediente activo", "-", "Word Document"), prod);
		TreeNode clasetoxi = new DefaultTreeNode("document", new Menu("Clases toxicológicas", "-", "Word Document"),
				prod);
		TreeNode emp = new DefaultTreeNode("document", new Menu("Empaques", "-", "Word Document"), prod);
		TreeNode producto = new DefaultTreeNode("document", new Menu("Producto", "-", "Word Document"), prod);

		
		TreeNode lab = new DefaultTreeNode(new Menu("Labores", "-", "Folder"), catalogo4);
		TreeNode grplab = new DefaultTreeNode("document", new Menu("Grupos de labores", "-", "Word Document"), lab);
		TreeNode labor = new DefaultTreeNode("document", new Menu("Labor", "-", "Word Document"), lab);

		
		TreeNode prodventas = new DefaultTreeNode(new Menu("Producción/Ventas", "-", "Folder"), catalogo4);
		
		 TreeNode estcosecha = new DefaultTreeNode("document", new Menu(
		 "Mot. estimativas de cosecha", "-", "Word Document"), prodventas);
		 TreeNode frencosecha = new DefaultTreeNode("document", new Menu(
		 "Frentes de cosecha", "-", "Word Document"), prodventas);
		TreeNode modalidcos = new DefaultTreeNode("document", new Menu("Tipos de cosecha", "-", "Word Document"), prodventas);
		TreeNode trasp = new DefaultTreeNode("document", new Menu("Transportadoras", "-", "Word Document"), prodventas);
		
		TreeNode pInds = new DefaultTreeNode(new Menu("Análisis del proceso industrial", "-", "Folder"), catalogo4);
		TreeNode pIndus1 = new DefaultTreeNode("document", new Menu("Variables de análisis", "-", "Word Document"), pInds);
		TreeNode pIndus2 = new DefaultTreeNode("document", new Menu("Grupos de análisis", "-", "Word Document"), pInds);

		TreeNode datos4 = new DefaultTreeNode(new Menu("Transacciones", "-", "Folder"), root4);
		/*
		 * TreeNode reganalab = new DefaultTreeNode("document", new Menu(
		 * "Análisis de laboratorio", "-", "Word Document"), datos4);
		 */
		// TreeNode regestcosecha = new DefaultTreeNode("document", new Menu(
		// "Estimativas de cosecha", "-", "Word Document"), datos4);
		TreeNode regprodrecven = new DefaultTreeNode("document",
				new Menu("Registros de producción", "-", "Word Document"), datos4);

		TreeNode datos41 = new DefaultTreeNode(new Menu("Báscula", "-", "Folder"), datos4);
		
		
		TreeNode r1 = new DefaultTreeNode("document",
				new Menu("Creación del Tiquete de pesaje", "-", "Word Document"), datos41);
//		TreeNode r2 = new DefaultTreeNode("document",
//				new Menu("Registros de peso bruto", "-", "Word Document"), datos41);
//		TreeNode r3 = new DefaultTreeNode("document",
//				new Menu("Registros de peso tara", "-", "Word Document"), datos41);
		TreeNode r4 = new DefaultTreeNode("document",
				new Menu("Corrección de tiquetes", "-", "Word Document"), datos41);
		
		TreeNode r5 = new DefaultTreeNode("document",
				new Menu("Evaluación de calidad del fruto", "-", "Word Document"), datos41);
		
		TreeNode r6 = new DefaultTreeNode("document",
				new Menu("Edición - Evaluación de calidad del fruto", "-", "Word Document"), datos41);
		
		//TreeNode r5 = new DefaultTreeNode("document",
		//		new Menu("Consulta de tiquetes", "-", "Word Document"), datos41);

		/*
		 * TreeNode reganacalidad = new DefaultTreeNode("document", new Menu(
		 * "Análisis de post-cosecha", "-", "Word Document"), datos4);
		 */
		/**** Reportes ****/
		TreeNode datos5 = new DefaultTreeNode(new Menu("Reportes", "-", "Folder"), root4);

		TreeNode mat = new DefaultTreeNode(new Menu("Producción", "-", "Folder"), datos5);
		TreeNode mplcl = new DefaultTreeNode("document",
				new Menu("Producción por Lote(Detallado)", "-", "Word Document"), mat);
		
		TreeNode b1 = new DefaultTreeNode(new Menu("Báscula", "-", "Folder"), datos5);
		TreeNode b2 = new DefaultTreeNode("document",
				new Menu("Movimientos de materia prima", "-", "Word Document"), b1);
		TreeNode b3 = new DefaultTreeNode("document",
				new Menu("Despachos realizados", "-", "Word Document"), b1);
		TreeNode b4 = new DefaultTreeNode("document",
				new Menu("Movimientos de balanza", "-", "Word Document"), b1);
		
		TreeNode b5 = new DefaultTreeNode("document",
				new Menu("Log de balanza", "-", "Word Document"), datos41);
		
		TreeNode b6 = new DefaultTreeNode("document",
				new Menu("Consulta análisis de proceso industrial", "-", "Word Document"), datos41);
		
		/* 
		 * TreeNode prc = new DefaultTreeNode("document", new Menu(
		 * "Programa de Cosecha", "-", "Word Document"), mat); /*TreeNode mpl =
		 * new DefaultTreeNode("document", new Menu( "Producción por Lote", "-",
		 * "Word Document"), mat); TreeNode mplc = new
		 * DefaultTreeNode("document", new Menu(
		 * "Producción por Hacienda(Finca)", "-", "Word Document"), mat);
		 * /*TreeNode pldd = new DefaultTreeNode("document", new Menu(
		 * 
		 * "Producción por Lote - Det", "-", "Word Document"), mat);
		 * 
		 * TreeNode dpr = new DefaultTreeNode("document", new Menu(
		 * "Toneladas vs toneladas/Ha", "-", "Word Document"), mat); TreeNode
		 * trto = new DefaultTreeNode("document", new Menu(
		 * "Toneladas vs rendimiento", "-", "Word Document"), mat); TreeNode
		 * tthm = new DefaultTreeNode("document", new Menu(
		 * "Toneladas vs toneladas/Ha/Mes", "-", "Word Document"), mat);
		 * TreeNode tthn = new DefaultTreeNode("document", new Menu(
		 * "Toneladas por número de cosechas", "-", "Word Document"), mat);
		 * 
		 * TreeNode prcin = new DefaultTreeNode("document", new Menu(
		 * "Producción(Ton) 5 años", "-", "Word Document"), mat); TreeNode prpr
		 * = new DefaultTreeNode("document", new Menu(
		 * "Producción(Ton) Vs precipitación(mm)", "-", "Word Document"), mat);
		 * 
		 * TreeNode mvr = new DefaultTreeNode("document", new Menu(
		 * "Movimiento de vagones", "-", "Word Document"), mat);
		 * 
		 * TreeNode prv = new DefaultTreeNode(new Menu("Despacho de productos",
		 * "-", "Folder"), datos5); TreeNode vfru = new
		 * DefaultTreeNode("document", new Menu( "Variación precio fruta", "-",
		 * "Word Document"), prv); TreeNode ptdp = new
		 * DefaultTreeNode("document", new Menu(
		 * "Toneladas despachadas producto", "-", "Word Document"), prv);
		 * TreeNode prdc = new DefaultTreeNode("document", new Menu(
		 * "Toneladas despachadas cliente", "-", "Word Document"), prv);
		 * 
		 */
		return root4;

	}

	public void expandir(TreeNode nodo) {

		if (nodo.getParent() != null) {
			nodo.setExpanded(true);
			expandir(nodo.getParent());
		}

	}

	public String getTituloModulo() {
		return tituloModulo;
	}

	public void setTituloModulo(String tituloModulo) {
		this.tituloModulo = tituloModulo;
	}
}