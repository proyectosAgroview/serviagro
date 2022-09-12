package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaDespachosInformeDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class informeTBasculaDespachosConsolidadoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(informeTBasculaDespachosConsolidadoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;

	private List<TiquetesBasculaDespachosInformeDTO> data;

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

	private List<String> selectedModCosecha;
	private List<ModalidadCosecha> modCosechas;

	private List<String> selectedEtapaCos;
	private List<Etapa> noCosechas;

	private List<String> selectedProducto;
	private List<Producto> productos;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;
	

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;


	
	
	/************consulta de tiquetes***/
	private List<String> selectedEquipo;
	private List<Equipo> equipos;


	private List<String> selectedTiquete;
	private List<DatTransProd> tiquetes;
	
	private SelectOneMenu selectedTipoTransaccion;
	
	private SelectOneMenu selectedEstadoTiquete;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	
	
	/*****************************************/
	private StreamedContent file = null;
	private String disableButton = "true";
	
	private String visible = "hidden";

	public informeTBasculaDespachosConsolidadoView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public String exportToPyGExcel() {

		// Long compania = 1L;
		

		// Long compania = 1L;
		Long compania = FacesUtils.checkLong(txtCompania);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long flagTipoTransaccion = 1L;
		Long flagEquipo = 1L;
		Long flagTiquete = 1L;
		Long flagEstadoTiquete = 1L;
		Long flagCliente = 1L;
		
		String estadoSeleccionado = (FacesUtils.checkString(selectedTipoTransaccion));
		String tipoTransaccion = (FacesUtils.checkString(selectedEstadoTiquete));
		
		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}
		
		
		String tiquetesSeleccionados = "";
		if (selectedTiquete != null && selectedTiquete.size() > 0) {
			tiquetesSeleccionados = selectedTiquete.get(0);
			flagTiquete = 0L;
			for (int i = 1; i < selectedTiquete.size(); i++) {
				tiquetesSeleccionados += "," + selectedTiquete.get(i);
			}
		}
		
		String contratistasSeleccionadas = "";
		if (selectedContratista != null && selectedContratista.size() > 0) {
			contratistasSeleccionadas = selectedContratista.get(0);
			flagCliente = 0L;
			for (int i = 1; i < selectedContratista.size(); i++) {
				contratistasSeleccionadas += "," + selectedContratista.get(i);
			}
		}
		
		if (compania != null && fechaInicial !=null && fechaFinal !=null) {
			try {

				List<TiquetesBasculaDespachosInformeDTO> data=null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();


				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "ConsolidadoDespachos.xlsx";

				data = businessDelegatorView.consultarTiqueteBasculaDespachosInforme(compania, fechaInicial, fechaFinal, 
								equiposSeleccionadas, flagEquipo, tiquetesSeleccionados, flagTiquete,contratistasSeleccionadas, flagCliente);

				try {
					
					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);

					sheet.setForceFormulaRecalculation(true);
					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style1.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style1.setBorderRight((CellStyle.BORDER_MEDIUM));
					style1.setBorderTop((CellStyle.BORDER_MEDIUM));
					style1.setBorderBottom((CellStyle.BORDER_MEDIUM));

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					style2.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style2.setBorderRight((CellStyle.BORDER_MEDIUM));
					style2.setBorderTop((CellStyle.BORDER_MEDIUM));
					style2.setBorderBottom((CellStyle.BORDER_MEDIUM));

					style2.setAlignment(CellStyle.ALIGN_CENTER);

					Font font = book.createFont();
					font.setColor(IndexedColors.WHITE.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");

					style2.setFont(font);

					CellStyle style3 = book.createCellStyle();
					style3.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style3.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style3.setBorderRight((CellStyle.BORDER_MEDIUM));
					style3.setBorderTop((CellStyle.BORDER_MEDIUM));
					style3.setBorderBottom((CellStyle.BORDER_MEDIUM));

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));


					if (data != null) {
						// int numColumnas = 3;
						// construyendo las columnas de excel
						
						Cell columna1 	=	row.createCell(0	);	columna1	.setCellValue(	"DAT_TRANS_PROD_ID"	);
						Cell columna2	=	row.createCell(1	);	columna2	.setCellValue(	"TIQ. BASCULA"	);
						Cell columna3	=	row.createCell(2	);	columna3	.setCellValue(	"FECHA_REGISTRO"	);
						Cell columna4	=	row.createCell(3	);	columna4	.setCellValue(	"TIPO_TRANSACCION"	);
						Cell columna5	=	row.createCell(4	);	columna5	.setCellValue(	"EQUIPO"	);
						Cell columna6	=	row.createCell(5	);	columna6	.setCellValue(	"FECHA_ENTRADA"	);
						Cell columna7	=	row.createCell(6	);	columna7	.setCellValue(	"FECHA_SALIDA"	);
						Cell columna8	=	row.createCell(7	);	columna8	.setCellValue(	"PESO_BRUTO"	);
						Cell columna9	=	row.createCell(8	);	columna9	.setCellValue(	"PESO_TARA"	);
						Cell columna10	=	row.createCell(9	);	columna10	.setCellValue(	"PESO_NETO"	);
						Cell columna11	=	row.createCell(10	);	columna11	.setCellValue(	"DESTINO_PRODUCCION"	);
						Cell columna12	=	row.createCell(11	);	columna12	.setCellValue(	"COMPANIA"	);
						Cell columna13	=	row.createCell(12	);	columna13	.setCellValue(	"TRANSPORTADORA"	);
						Cell columna14	=	row.createCell(13	);	columna14	.setCellValue(	"CONDUCTOR"	);
						Cell columna15	=	row.createCell(14	);	columna15	.setCellValue(	"OBSERVACION"	);
						Cell columna16	=	row.createCell(15	);	columna16	.setCellValue(	"ESTADO"	);
						Cell columna17	=	row.createCell(16	);	columna17	.setCellValue(	"OBSERVACION_ANULAR_REG"	);
						Cell columna18	=	row.createCell(17	);	columna18	.setCellValue(	"VAGON1"	);
						Cell columna19	=	row.createCell(18	);	columna19	.setCellValue(	"VAGON2"	);
						Cell columna20	=	row.createCell(19	);	columna20	.setCellValue(	"VAGON3"	);
						Cell columna21	=	row.createCell(20	);	columna21	.setCellValue(	"FECHA_PESO_BRUTO"	);
						Cell columna22	=	row.createCell(21	);	columna22	.setCellValue(	"FECHA_TARA"	);
						Cell columna23	=	row.createCell(22	);	columna23	.setCellValue(	"FECHA_PESO_NETO"	);
						Cell columna24	=	row.createCell(23	);	columna24	.setCellValue(	"NUMERO_SELLOS"	);
						Cell columna25	=	row.createCell(24	);	columna25	.setCellValue(	"BASCULA_TARA"	);
						Cell columna26	=	row.createCell(25	);	columna26	.setCellValue(	"BASCULA_PESO_BRUTO"	);
						Cell columna27	=	row.createCell(26	);	columna27	.setCellValue(	"USUARIO_PESO_TARA"	);
						Cell columna28	=	row.createCell(27	);	columna28	.setCellValue(	"USUARIO_PESO_BRUTO"	);
						Cell columna29	=	row.createCell(28	);	columna29	.setCellValue(	"ACIDEZ"	);
						Cell columna30	=	row.createCell(29	);	columna30	.setCellValue(	"HUMEDAD"	);
						Cell columna31	=	row.createCell(30	);	columna31	.setCellValue(	"IMPUREZAS"	);
						Cell columna32	=	row.createCell(31	);	columna32	.setCellValue(	"TEMPERATURA °C"	);
						Cell columna33	=	row.createCell(32	);	columna33	.setCellValue(	"VARIABLE5"	);
						Cell columna34	=	row.createCell(33	);	columna34	.setCellValue(	"VARIABLE6"	);
						Cell columna35	=	row.createCell(34	);	columna35	.setCellValue(	"VARIABLE7"	);
						Cell columna36	=	row.createCell(35	);	columna36	.setCellValue(	"VARIABLE8"	);
						Cell columna37	=	row.createCell(36	);	columna37	.setCellValue(	"VARIABLE9"	);
						Cell columna38	=	row.createCell(37	);	columna38	.setCellValue(	"VARIABLE10"	);
						Cell columna39	=	row.createCell(38	);	columna39	.setCellValue(	"OBSERVACION_ANALISIS"	);
						Cell columna40	=	row.createCell(39	);	columna40	.setCellValue(	"FECHA_ANULACION"	);
						Cell columna41	=	row.createCell(40	);	columna41	.setCellValue(	"CLIENTE"	);
						Cell columna42	=	row.createCell(41	);	columna42	.setCellValue(	"NOMBRECOMPANIA"	);
						Cell columna43	=	row.createCell(42	);	columna43	.setCellValue(	"NITCOMPANIA"	);
						Cell columna44	=	row.createCell(43	);	columna44	.setCellValue(	"TELEFONOCOMPANIA"	);
						Cell columna45	=	row.createCell(44	);	columna45	.setCellValue(	"DIRECCIONCOMPANIA"	);
						Cell columna46	=	row.createCell(45	);	columna46	.setCellValue(	"CIUDADCOMPANIA"	);
						Cell columna47	=	row.createCell(46	);	columna47	.setCellValue(	"PRODUCTO"	);
						Cell columna48	=	row.createCell(47	);	columna48	.setCellValue(	"UNIDADMEDIDAPRODUCTO"	);
						Cell columna49	=	row.createCell(48	);	columna49	.setCellValue(	"CIUDADCLIENTE"	);
						Cell columna50	=	row.createCell(49	);	columna50	.setCellValue(	"CANTIDADREQUERIDA"	);
						Cell columna51	=	row.createCell(50	);	columna51	.setCellValue(	"MES"	);
						Cell columna52	=	row.createCell(51	);	columna52	.setCellValue(	"MES_CORTO"	);
						Cell columna53	=	row.createCell(52	);	columna53	.setCellValue(	"AÑO"	);
						Cell columna54	=	row.createCell(53	);	columna54	.setCellValue(	"FACTURA"	);
						Cell columna55	=	row.createCell(54	);	columna55	.setCellValue(	"NO. PEDIDO"	);
						Cell columna56	=	row.createCell(55	);	columna56	.setCellValue(	"REG. DESPACHO"	);
						Cell columna57	=	row.createCell(56	);	columna57	.setCellValue(	"DOCUMENTO INTERNO DE PESAJE"	);
						Cell columna58	=	row.createCell(57	);	columna58	.setCellValue(	"FECHA EN PORTERIA"	);
						
						columna1.setCellStyle(style2);
						columna2.setCellStyle(style2);
						columna3.setCellStyle(style2);
						columna4.setCellStyle(style2);
						columna5.setCellStyle(style2);
						columna6.setCellStyle(style2);
						columna7.setCellStyle(style2);
						columna8.setCellStyle(style2);
						columna9.setCellStyle(style2);
						columna10.setCellStyle(style2);
						columna11.setCellStyle(style2);
						columna12.setCellStyle(style2);
						columna13.setCellStyle(style2);
						columna14.setCellStyle(style2);
						columna15.setCellStyle(style2);
						columna16.setCellStyle(style2);
						columna17.setCellStyle(style2);
						columna18.setCellStyle(style2);
						columna19.setCellStyle(style2);
						columna20.setCellStyle(style2);
						columna21.setCellStyle(style2);
						columna22.setCellStyle(style2);
						columna23.setCellStyle(style2);
						columna24.setCellStyle(style2);
						columna25.setCellStyle(style2);
						columna26.setCellStyle(style2);
						columna27.setCellStyle(style2);
						columna28.setCellStyle(style2);
						columna29.setCellStyle(style2);
						columna30.setCellStyle(style2);
						columna31.setCellStyle(style2);
						columna32.setCellStyle(style2);
						columna33.setCellStyle(style2);
						columna34.setCellStyle(style2);
						columna35.setCellStyle(style2);
						columna36.setCellStyle(style2);
						columna37.setCellStyle(style2);
						columna38.setCellStyle(style2);
						columna39.setCellStyle(style2);
						columna40.setCellStyle(style2);
						columna41.setCellStyle(style2);
						columna42.setCellStyle(style2);
						columna43.setCellStyle(style2);
						columna44.setCellStyle(style2);
						columna45.setCellStyle(style2);
						columna46.setCellStyle(style2);
						columna47.setCellStyle(style2);
						columna48.setCellStyle(style2);
						columna49.setCellStyle(style2);
						columna50.setCellStyle(style2);
						columna51.setCellStyle(style2);
						columna52.setCellStyle(style2);
						columna53.setCellStyle(style2);
						columna54.setCellStyle(style2);
						columna55.setCellStyle(style2);
						columna56.setCellStyle(style2);
						columna57.setCellStyle(style2);
						columna58.setCellStyle(style2);
						
						int pos_i = 5;

						for(TiquetesBasculaDespachosInformeDTO ndDTO: data){

							row = sheet.createRow(pos_i);
							
							Cell cell1 	=	row.createCell(0	);	cell1	.setCellValue(ndDTO.getDat_trans_prod_id().doubleValue());
							Cell cell2	=	row.createCell(1	);	cell2	.setCellValue(ndDTO.getConsecutivo().doubleValue());
							Cell cell3	=	row.createCell(2	);	cell3	.setCellValue(ndDTO.getFecha_registro().toString().substring(0, 10));							
							Cell cell4	=	row.createCell(3	);	cell4	.setCellValue(ndDTO.getTipo_transaccion());
							Cell cell5	=	row.createCell(4	);	cell5	.setCellValue(ndDTO.getEquipo());
							Cell cell6	=	row.createCell(5	);	cell6	.setCellValue(ndDTO.getFecha_entrada().toString().substring(0, 10));
							Cell cell7	=	row.createCell(6	);	cell7	.setCellValue(ndDTO.getFecha_salida().toString().substring(0, 10));
							Cell cell8	=	row.createCell(7	);	cell8	.setCellValue(ndDTO.getPeso_bruto().doubleValue());
							Cell cell9	=	row.createCell(8	);	cell9	.setCellValue(ndDTO.getPeso_tara().doubleValue());
							Cell cell10	=	row.createCell(9	);	cell10	.setCellValue(ndDTO.getPeso_neto().doubleValue());
							Cell cell11	=	row.createCell(10	);	cell11	.setCellValue(ndDTO.getDestino_produccion());
							Cell cell12	=	row.createCell(11	);	cell12	.setCellValue(ndDTO.getCompania().doubleValue());
							Cell cell13	=	row.createCell(12	);	cell13	.setCellValue(ndDTO.getTransportadora());
							Cell cell14	=	row.createCell(13	);	cell14	.setCellValue(ndDTO.getConductor());
							Cell cell15	=	row.createCell(14	);	cell15	.setCellValue(ndDTO.getObservacion());
							Cell cell16	=	row.createCell(15	);	cell16	.setCellValue(ndDTO.getEstado());
							Cell cell17	=	row.createCell(16	);	cell17	.setCellValue(ndDTO.getObservacion_anular_reg());
							Cell cell18	=	row.createCell(17	);	cell18	.setCellValue(ndDTO.getVagon1());
							Cell cell19	=	row.createCell(18	);	cell19	.setCellValue(ndDTO.getVagon2());
							Cell cell20	=	row.createCell(19	);	cell20	.setCellValue(ndDTO.getVagon3());
							Cell cell21	=	row.createCell(20	);	cell21	.setCellValue(ndDTO.getFecha_peso_bruto().toString().substring(0, 10));
							Cell cell22	=	row.createCell(21	);	cell22	.setCellValue(ndDTO.getFecha_tara().toString().substring(0, 10));
							Cell cell23	=	row.createCell(22	);	cell23	.setCellValue(ndDTO.getFecha_peso_neto().toString().substring(0, 10));
							Cell cell24	=	row.createCell(23	);	cell24	.setCellValue(ndDTO.getNumero_sellos());
							Cell cell25	=	row.createCell(24	);	cell25	.setCellValue(ndDTO.getBascula_tara());
							Cell cell26	=	row.createCell(25	);	cell26	.setCellValue(ndDTO.getBascula_peso_bruto());
							Cell cell27	=	row.createCell(26	);	cell27	.setCellValue(ndDTO.getUsuario_peso_tara());
							Cell cell28	=	row.createCell(27	);	cell28	.setCellValue(ndDTO.getUsuario_peso_bruto());
							Cell cell29	=	row.createCell(28	);	cell29	.setCellValue(ndDTO.getAcidez().doubleValue());
							Cell cell30	=	row.createCell(29	);	cell30	.setCellValue(ndDTO.getHumedad().doubleValue());
							Cell cell31	=	row.createCell(30	);	cell31	.setCellValue(ndDTO.getImpurezas().doubleValue());
							Cell cell32	=	row.createCell(31	);	cell32	.setCellValue(ndDTO.getVariable4().doubleValue());
							Cell cell33	=	row.createCell(32	);	cell33	.setCellValue(ndDTO.getVariable5().doubleValue());
							Cell cell34	=	row.createCell(33	);	cell34	.setCellValue(ndDTO.getVariable6().doubleValue());
							Cell cell35	=	row.createCell(34	);	cell35	.setCellValue(ndDTO.getVariable7().doubleValue());
							Cell cell36	=	row.createCell(35	);	cell36	.setCellValue(ndDTO.getVariable8().doubleValue());
							Cell cell37	=	row.createCell(36	);	cell37	.setCellValue(ndDTO.getVariable9().doubleValue());
							Cell cell38	=	row.createCell(37	);	cell38	.setCellValue(ndDTO.getVariable10().doubleValue());
							Cell cell39	=	row.createCell(38	);	cell39	.setCellValue(ndDTO.getObservacion_analisis());
							Cell cell40	=	row.createCell(39	);	cell40	.setCellValue(ndDTO.getFecha_anulacion());
							Cell cell41	=	row.createCell(40	);	cell41	.setCellValue(ndDTO.getCliente());
							Cell cell42	=	row.createCell(41	);	cell42	.setCellValue(ndDTO.getNombreCompania());
							Cell cell43	=	row.createCell(42	);	cell43	.setCellValue(ndDTO.getNitCompania());
							Cell cell44	=	row.createCell(43	);	cell44	.setCellValue(ndDTO.getTelefonoCompania());
							Cell cell45	=	row.createCell(44	);	cell45	.setCellValue(ndDTO.getDireccionCompania());
							Cell cell46	=	row.createCell(45	);	cell46	.setCellValue(ndDTO.getCiudadCompania());
							Cell cell47	=	row.createCell(46	);	cell47	.setCellValue(ndDTO.getProducto());
							Cell cell48	=	row.createCell(47	);	cell48	.setCellValue(ndDTO.getUnidadMedidaProducto());
							Cell cell49	=	row.createCell(48	);	cell49	.setCellValue(ndDTO.getCiudadCliente());
							Cell cell50	=	row.createCell(49	);	cell50	.setCellValue(ndDTO.getCantidadRequerida().doubleValue());							
							Cell cell51	=	row.createCell(50	);	cell51	.setCellValue(ndDTO.getMes().doubleValue());
							Cell cell52	=	row.createCell(51	);	cell52	.setCellValue(ndDTO.getMesCorto());
							Cell cell53	=	row.createCell(52	);	cell53	.setCellValue(ndDTO.getAnio().doubleValue());
							Cell cell54	=	row.createCell(53	);	cell54	.setCellValue(ndDTO.getNoFactura());
							Cell cell55	=	row.createCell(54	);	cell55	.setCellValue(ndDTO.getNoPedido());
							Cell cell56	=	row.createCell(55	);	cell56	.setCellValue(ndDTO.getNoRegistroDespacho());
							Cell cell57	=	row.createCell(56	);	cell57	.setCellValue(ndDTO.getConsecutivo_peso_neto().longValue());
							Cell cell58	=	row.createCell(57	);	cell58	.setCellValue(ndDTO.getFecha_vehiculo_porteria().toString().substring(0, 10));
							
							
							pos_i++;

						}



						String  rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes" + File.separator;


						FileOutputStream os = new FileOutputStream(new File(rutaDescarga+excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext()
								.getContext()).getResourceAsStream("/tmp_reportes/"+excelSalida.getName());

						file = new DefaultStreamedContent(stream, "application/xlsx", "ConsolidadoDespachos.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"El informe se ha generado con exito, ahora puedes Descargar el informe"));

					} else {

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
								"No existe informacion asociada a los criterios de busqueda seleccionados "));
					}

				} catch (Exception e) {

					e.printStackTrace();

					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		visible = "visible";
		disableButton = "false";
		return "";
	}

	public void itemSelect(ItemSelectEvent event) {

		setShowDialog(true);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Item selected", "Item Index: " + event.getItemIndex()
						+ ", Series Index:" + event.getSeriesIndex());

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

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<TiquetesBasculaDespachosInformeDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.consultarTiqueteBasculaDespachosInforme
						(1L, null,
						 null, null, null, null,
						null, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

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
				List<Compania> lista = businessDelegatorView
						.findByCriteriaInCompania(condicion, null, null);
				selectCompania = new SelectItem[lista.size()];

				int i = 0;
				for (Compania compania : lista) {
					selectCompania[i] = new SelectItem(
							compania.getCompaniaId(), compania.getNombre());
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
				List<Cultivo> lista = businessDelegatorView
						.findByCriteriaInCultivo(condicion, null, null);
				selectCultivo = new SelectItem[lista.size()];

				int i = 0;
				for (Cultivo cultivo : lista) {
					selectCultivo[i] = new SelectItem(cultivo.getCultivoId(),
							cultivo.getNombre());
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

	public StreamedContent getFile() {
		
		  return file;
	}

	public void setFile(StreamedContent file) {
	  
	  if(file != null){
		this.file = file;
	  }	
	}

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}
	public List<String> getSelectedModCosecha() {
		return selectedModCosecha;
	}

	public void setSelectedModCosecha(List<String> selectedModCosecha) {
		this.selectedModCosecha = selectedModCosecha;
	}

	public List<ModalidadCosecha> getModCosechas() {
		if (modCosechas == null || modCosechas.size() == 0) {

			modCosechas = new ArrayList<ModalidadCosecha>();

			try {
				modCosechas = businessDelegatorView.getModalidadCosecha();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return modCosechas;
	}

	public void setModCosechas(List<ModalidadCosecha> modCosechas) {
		this.modCosechas = modCosechas;
	}

	public List<String> getSelectedEtapaCos() {
		return selectedEtapaCos;
	}

	public void setSelectedEtapaCos(List<String> selectedEtapaCos) {
		this.selectedEtapaCos = selectedEtapaCos;
	}

	public List<Etapa> getNoCosechas() {
		if (noCosechas == null || noCosechas.size() == 0) {

			noCosechas = new ArrayList<Etapa>();

			try {
				noCosechas = businessDelegatorView.getEtapa();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return noCosechas;
	}

	public void setNoCosechas(List<Etapa> noCosechas) {
		this.noCosechas = noCosechas;
	}

	public List<String> getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(List<String> selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public List<Producto> getProductos() {
		if (productos == null || productos.size() == 0) {

			productos = new ArrayList<Producto>();

			try {
				productos = businessDelegatorView.getProducto();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public List<PersEmpr> getContratistas() {
		if (contratistas == null || contratistas.size() == 0) {

			contratistas = new ArrayList<PersEmpr>();

			try {
				contratistas = businessDelegatorView.getPersEmpr();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return contratistas;
	}

	public void setContratistas(List<PersEmpr> contratistas) {
		this.contratistas = contratistas;
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


	

	public List<DatTransProd> getTiquetes() {
		if (tiquetes == null || tiquetes.size() == 0) {

			tiquetes = new ArrayList<DatTransProd>();

			try {
				tiquetes = businessDelegatorView.getDatTransProd();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return tiquetes;

	}

	public void setTiquetes(List<DatTransProd> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			equipos = new ArrayList<Equipo>();

			try {
				equipos = businessDelegatorView.getEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}


		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<String> getSelectedTiquete() {
		return selectedTiquete;
	}

	public void setSelectedTiquete(List<String> selectedTiquete) {
		this.selectedTiquete = selectedTiquete;
	}

	public SelectOneMenu getSelectedTipoTransaccion() {
		return selectedTipoTransaccion;
	}

	public void setSelectedTipoTransaccion(SelectOneMenu selectedTipoTransaccion) {
		this.selectedTipoTransaccion = selectedTipoTransaccion;
	}

	public SelectOneMenu getSelectedEstadoTiquete() {
		return selectedEstadoTiquete;
	}

	public void setSelectedEstadoTiquete(SelectOneMenu selectedEstadoTiquete) {
		this.selectedEstadoTiquete = selectedEstadoTiquete;
	}



}
