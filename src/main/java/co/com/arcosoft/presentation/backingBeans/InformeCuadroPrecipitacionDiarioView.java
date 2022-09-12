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
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.CuadroPrecipitacionDiariaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeCuadroPrecipitacionDiarioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeCuadroPrecipitacionDiarioView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	
	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicialAcumulada;
	private Calendar txtFechaFinalAcumulada;

	private List<CuadroPrecipitacionDiariaDTO> data;

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	private List<String> selectedEstPluvio;
	private List<EstPluvio> estPluvios;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";

	public InformeCuadroPrecipitacionDiarioView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
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

	public String exportToPyGExcel() {

		// Long compania = 1L;
		Long compania = FacesUtils.checkLong(txtCompania);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		Date fechaInicialAcumulada = null;
		Date fechaFinalAcumulada = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		fechaInicialAcumulada = (FacesUtils.checkDate(txtFechaInicialAcumulada));
		fechaFinalAcumulada = (FacesUtils.checkDate(txtFechaFinalAcumulada));

		Long flagEstPluvio = 1L;

		String pluviosSeleccionadas = "";
		if (selectedEstPluvio != null && selectedEstPluvio.size() > 0) {
			pluviosSeleccionadas = selectedEstPluvio.get(0);
			flagEstPluvio = 0L;
			for (int i = 1; i < selectedEstPluvio.size(); i++) {
				pluviosSeleccionadas += "," + selectedEstPluvio.get(i);
			}
		}

		if (compania != null) {
			try {

				List<CuadroPrecipitacionDiariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "CuadroPrecipitacion.xlsx";

				data = businessDelegatorView.consultarInformeCuandroPrecipitacionDiario(compania, fechaInicial,
						fechaFinal, fechaInicialAcumulada, fechaFinalAcumulada, pluviosSeleccionadas, flagEstPluvio);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(0);
					XSSFCell cell = null;

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
					style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
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

						Cell columna1 = row.createCell(0);
						columna1.setCellValue("COD. PLUVIOMETRO");
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("PLUVIOMETRO");
						Cell columna3 = row.createCell(2);
						columna3.setCellValue("DIA1");
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("DIA2");
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("DIA3");
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("DIA4");
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("DIA5");
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("DIA6");
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("DIA7");
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("DIA8");
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("DIA9");
						Cell columna12 = row.createCell(11);
						columna12.setCellValue("DIA10");
						Cell columna13 = row.createCell(12);
						columna13.setCellValue("DIA11");
						Cell columna14 = row.createCell(13);
						columna14.setCellValue("DIA12");
						Cell columna15 = row.createCell(14);
						columna15.setCellValue("DIA13");
						Cell columna16 = row.createCell(15);
						columna16.setCellValue("DIA14");
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("DIA15");
						Cell columna18 = row.createCell(17);
						columna18.setCellValue("DIA16");
						Cell columna19 = row.createCell(18);
						columna19.setCellValue("DIA17");
						Cell columna20 = row.createCell(19);
						columna20.setCellValue("DIA18");
						Cell columna21 = row.createCell(20);
						columna21.setCellValue("DIA19");
						Cell columna22 = row.createCell(21);
						columna22.setCellValue("DIA20");
						Cell columna23 = row.createCell(22);
						columna23.setCellValue("DIA21");
						Cell columna24 = row.createCell(23);
						columna24.setCellValue("DIA22");
						Cell columna25 = row.createCell(24);
						columna25.setCellValue("DIA23");
						Cell columna26 = row.createCell(25);
						columna26.setCellValue("DIA24");
						Cell columna27 = row.createCell(26);
						columna27.setCellValue("DIA25");
						Cell columna28 = row.createCell(27);
						columna28.setCellValue("DIA26");
						Cell columna29 = row.createCell(28);
						columna29.setCellValue("DIA27");
						Cell columna30 = row.createCell(29);
						columna30.setCellValue("DIA28");
						Cell columna31 = row.createCell(30);
						columna31.setCellValue("DIA29");
						Cell columna32 = row.createCell(31);
						columna32.setCellValue("DIA30");
						Cell columna33 = row.createCell(32);
						columna33.setCellValue("DIA31");
						Cell columna34 = row.createCell(33);
						columna34.setCellValue("ENERO");
						Cell columna35 = row.createCell(34);
						columna35.setCellValue("FEBRERO");
						Cell columna36 = row.createCell(35);
						columna36.setCellValue("MARZO");
						Cell columna37 = row.createCell(36);
						columna37.setCellValue("ABRIL");
						Cell columna38 = row.createCell(37);
						columna38.setCellValue("MAYO");
						Cell columna39 = row.createCell(38);
						columna39.setCellValue("JUNIO");
						Cell columna40 = row.createCell(39);
						columna40.setCellValue("JULIO");
						Cell columna41 = row.createCell(40);
						columna41.setCellValue("AGOSTO");
						Cell columna42 = row.createCell(41);
						columna42.setCellValue("SEPTIEMBRE");
						Cell columna43 = row.createCell(42);
						columna43.setCellValue("OCTUBRE");
						Cell columna44 = row.createCell(43);
						columna44.setCellValue("NOVIEMBRE");
						Cell columna45 = row.createCell(44);
						columna45.setCellValue("DICIEMBRE");
						Cell columna46 = row.createCell(45);
						columna46.setCellValue("Acumulado mes");
						Cell columna47 = row.createCell(46);
						columna47.setCellValue("Acumulado año");

						int pos_i = 1;

						for (CuadroPrecipitacionDiariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							Cell cell1 = row.createCell(0);
							Cell cell2 = row.createCell(1);
							Cell cell3 = row.createCell(2);
							Cell cell4 = row.createCell(3);
							Cell cell5 = row.createCell(4);
							Cell cell6 = row.createCell(5);
							Cell cell7 = row.createCell(6);
							Cell cell8 = row.createCell(7);
							Cell cell9 = row.createCell(8);
							Cell cell10 = row.createCell(9);
							Cell cell11 = row.createCell(10);
							Cell cell12 = row.createCell(11);
							Cell cell13 = row.createCell(12);
							Cell cell14 = row.createCell(13);
							Cell cell15 = row.createCell(14);
							Cell cell16 = row.createCell(15);
							Cell cell17 = row.createCell(16);
							Cell cell18 = row.createCell(17);
							Cell cell19 = row.createCell(18);
							Cell cell20 = row.createCell(19);
							Cell cell21 = row.createCell(20);
							Cell cell22 = row.createCell(21);
							Cell cell23 = row.createCell(22);
							Cell cell24 = row.createCell(23);
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
							Cell cell33 = row.createCell(32);
							Cell cell34 = row.createCell(33);
							Cell cell35 = row.createCell(34);
							Cell cell36 = row.createCell(35);
							Cell cell37 = row.createCell(36);
							Cell cell38 = row.createCell(37);
							Cell cell39 = row.createCell(38);
							Cell cell40 = row.createCell(39);
							Cell cell41 = row.createCell(40);
							Cell cell42 = row.createCell(41);
							Cell cell43 = row.createCell(42);
							Cell cell44 = row.createCell(43);
							Cell cell45 = row.createCell(44);
							Cell cell46 = row.createCell(45);
							Cell cell47 = row.createCell(46);

							cell1.setCellValue(ndDTO.getCodPluvio());
							cell2.setCellValue(ndDTO.getNomPluvio());
							cell3.setCellValue(ndDTO.getDia1().doubleValue());
							cell4.setCellValue(ndDTO.getDia2().doubleValue());
							cell5.setCellValue(ndDTO.getDia3().doubleValue());
							cell6.setCellValue(ndDTO.getDia4().doubleValue());
							cell7.setCellValue(ndDTO.getDia5().doubleValue());
							cell8.setCellValue(ndDTO.getDia6().doubleValue());
							cell9.setCellValue(ndDTO.getDia7().doubleValue());
							cell10.setCellValue(ndDTO.getDia8().doubleValue());
							cell11.setCellValue(ndDTO.getDia9().doubleValue());
							cell12.setCellValue(ndDTO.getDia10().doubleValue());
							cell13.setCellValue(ndDTO.getDia11().doubleValue());
							cell14.setCellValue(ndDTO.getDia12().doubleValue());
							cell15.setCellValue(ndDTO.getDia13().doubleValue());
							cell16.setCellValue(ndDTO.getDia14().doubleValue());
							cell17.setCellValue(ndDTO.getDia15().doubleValue());
							cell18.setCellValue(ndDTO.getDia16().doubleValue());
							cell19.setCellValue(ndDTO.getDia17().doubleValue());
							cell20.setCellValue(ndDTO.getDia18().doubleValue());
							cell21.setCellValue(ndDTO.getDia19().doubleValue());
							cell22.setCellValue(ndDTO.getDia20().doubleValue());
							cell23.setCellValue(ndDTO.getDia21().doubleValue());
							cell24.setCellValue(ndDTO.getDia22().doubleValue());
							cell25.setCellValue(ndDTO.getDia23().doubleValue());
							cell26.setCellValue(ndDTO.getDia24().doubleValue());
							cell27.setCellValue(ndDTO.getDia25().doubleValue());
							cell28.setCellValue(ndDTO.getDia26().doubleValue());
							cell29.setCellValue(ndDTO.getDia27().doubleValue());
							cell30.setCellValue(ndDTO.getDia28().doubleValue());
							cell31.setCellValue(ndDTO.getDia29().doubleValue());
							cell32.setCellValue(ndDTO.getDia30().doubleValue());
							cell33.setCellValue(ndDTO.getDia31().doubleValue());
							cell34.setCellValue(ndDTO.getEnero().doubleValue());
							cell35.setCellValue(ndDTO.getFebrero().doubleValue());
							cell36.setCellValue(ndDTO.getMarzo().doubleValue());
							cell37.setCellValue(ndDTO.getAbril().doubleValue());
							cell38.setCellValue(ndDTO.getMayo().doubleValue());
							cell39.setCellValue(ndDTO.getJunio().doubleValue());
							cell40.setCellValue(ndDTO.getJulio().doubleValue());
							cell41.setCellValue(ndDTO.getAgosto().doubleValue());
							cell42.setCellValue(ndDTO.getSeptiembre().doubleValue());
							cell43.setCellValue(ndDTO.getOctubre().doubleValue());
							cell44.setCellValue(ndDTO.getNoviembre().doubleValue());
							cell45.setCellValue(ndDTO.getDiciembre().doubleValue());
							cell46.setCellValue(ndDTO.getTotalDias().doubleValue());
							cell47.setCellValue(ndDTO.getTotalMes().doubleValue());

							pos_i++;

						}

						int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						file = new DefaultStreamedContent(stream, "application/xlsx", "CuadroPrecipitacion.xlsx");

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

	
	

	public String comportamientoLluvias() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		Date fechaInicialAcumulada = null;
		Date fechaFinalAcumulada = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		fechaInicialAcumulada = (FacesUtils.checkDate(txtFechaInicialAcumulada));
		fechaFinalAcumulada = (FacesUtils.checkDate(txtFechaFinalAcumulada));

		Long flagEstPluvio = 1L;

		String pluviosSeleccionadas = "";
		if (selectedEstPluvio != null && selectedEstPluvio.size() > 0) {
			pluviosSeleccionadas = selectedEstPluvio.get(0);
			flagEstPluvio = 0L;
			for (int i = 1; i < selectedEstPluvio.size(); i++) {
				pluviosSeleccionadas += "," + selectedEstPluvio.get(i);
			}
		}

		if (compania != null) {
			try {

				List<CuadroPrecipitacionDiariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "ComportamientoLluvias.xlsx";

				data = businessDelegator2View.pr_comportamiento_lluvias(compania, fechaInicial,
						fechaFinal, pluviosSeleccionadas, flagEstPluvio);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(0);
					XSSFCell cell = null;

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
					style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
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

						Cell columna1 = row.createCell(0);
						columna1.setCellValue("COD. PLUVIOMETRO");
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("PLUVIOMETRO");
						Cell columna3 = row.createCell(2);
						columna3.setCellValue("FECHA");
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("AÑO");
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("MES");
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("MES CORTO");
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("PRECIPITACION(mm)");
						

						int pos_i = 1;

						for (CuadroPrecipitacionDiariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							Cell cell1 = row.createCell(0);
							Cell cell2 = row.createCell(1);
							Cell cell3 = row.createCell(2);
							Cell cell4 = row.createCell(3);
							Cell cell5 = row.createCell(4);
							Cell cell6 = row.createCell(5);
							Cell cell7 = row.createCell(6);
							
							

							cell1.setCellValue(ndDTO.getCodPluvio());
							cell2.setCellValue(ndDTO.getNomPluvio());
							cell3.setCellValue(ndDTO.getFecha());
							cell4.setCellValue(ndDTO.getAnio().doubleValue());
							cell5.setCellValue(ndDTO.getMes().doubleValue());
							cell6.setCellValue(ndDTO.getMesCorto());
							cell7.setCellValue(ndDTO.getPrecipitacion().doubleValue());


							pos_i++;

						}

						

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						file = new DefaultStreamedContent(stream, "application/xlsx", "ComportamientoLluvias.xlsx");

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

	public List<String> getSelectedEstPluvio() {
		return selectedEstPluvio;
	}

	public void setSelectedEstPluvio(List<String> selectedEstPluvio) {
		this.selectedEstPluvio = selectedEstPluvio;
	}

	public List<EstPluvio> getEstPluvios() {
		if (estPluvios == null || estPluvios.size() == 0) {

			estPluvios = new ArrayList<EstPluvio>();

			try {
				estPluvios = businessDelegatorView.getEstPluvio();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return estPluvios;
	}

	public void setEstPluvios(List<EstPluvio> estPluvios) {
		this.estPluvios = estPluvios;
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

	public Calendar getTxtFechaInicialAcumulada() {
		return txtFechaInicialAcumulada;
	}

	public void setTxtFechaInicialAcumulada(Calendar txtFechaInicialAcumulada) {
		this.txtFechaInicialAcumulada = txtFechaInicialAcumulada;
	}

	public Calendar getTxtFechaFinalAcumulada() {
		return txtFechaFinalAcumulada;
	}

	public void setTxtFechaFinalAcumulada(Calendar txtFechaFinalAcumulada) {
		this.txtFechaFinalAcumulada = txtFechaFinalAcumulada;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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

	public String getUsuarioIdSession() throws Exception {

		String usuarioId = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				usuarioId = usuarios.getUsuarioId().toString();
			}
		}

		return usuarioId;
	}
}
