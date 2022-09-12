package co.com.arcosoft.presentation.backingBeans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringJoiner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.interfaceManagerExpRegistrosMODTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InterfaceManagerExportRegAusMoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InterfaceManagerExportRegAusMoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<interfaceManagerExpRegistrosMODTO> data;

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

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;

	private List<String> selectedTrabajador;
	private List<Trabajador> trabajador;

	private List<String> selectedConceptoNomina;
	private List<ConceptoNomina> conceptoNominas;

	Date dateR = new Date();

	GregorianCalendar calendario = new GregorianCalendar();
	long anioRegistro = calendario.get(java.util.Calendar.YEAR);
	long mes = calendario.get(java.util.Calendar.MONTH);
	long dia = calendario.get(java.util.Calendar.DAY_OF_MONTH);
	long hr = calendario.get(java.util.Calendar.HOUR);
	long min = calendario.get(java.util.Calendar.MINUTE);
	
	String dateText = Long.toString(anioRegistro) + Long.toString(mes) +
			Long.toString(dia) + Long.toString(hr) + Long.toString(min) ;

	String filename = "C://ARCOSOFT/ERP/EXP_AUSENTISMOS"+dateText+".TXT";


	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";

	private StreamedContent file1 = null;
	private String disableButton1 = "true";

	private String visible1 = "hidden";
	
	
	public InterfaceManagerExportRegAusMoView() {
		super();
	}

	public String action_informe1() {

		setShowDialog(true);

		// if(data.equals(null) ){
		// System.out.println("La interface "+filename +" , no tiene datos para
		// exportar");

		// }
		if (data != null && data.size() > 0) {

			try {
				generarPlano();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"No existen datos para generar la interface INT_EXP_AUSENTISMOS_MO_MANAGER"));

		}

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

	public void generarPlano() throws IOException {

		File file = new File(filename);

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		List<interfaceManagerExpRegistrosMODTO> dto = data;

		if (dto != null && dto.size() > 0) {

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (interfaceManagerExpRegistrosMODTO liquidacionContratistaDTO : dto) {

				StringJoiner sj = new StringJoiner(",");

				sj.add(liquidacionContratistaDTO.getPlanoNomina().toString().trim());

				bw.write(sj.toString());
				bw.newLine();
			}

			bw.close();

			System.out.println("La interface " + filename + " , se ha ejecutado con éxito");

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"La interface " + filename + " , se ha generado con éxito"));

		}
	}

	public List<interfaceManagerExpRegistrosMODTO> getData() {
		try {
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

		
			Long flagContratista = 1L;
			Long flagTrabajador = 1L;
			Long flagConceptoNomina = 1L;
			
			String contratistasSeleccionadas = "";
			if (selectedContratista != null && selectedContratista.size() > 0) {
				contratistasSeleccionadas = selectedContratista.get(0);
				flagContratista = 0L;
				for (int i = 1; i < selectedContratista.size(); i++) {
					contratistasSeleccionadas += "," + selectedContratista.get(i);
				}
			}

			String trabajadorSeleccionadas = "";
			if (selectedTrabajador != null && selectedTrabajador.size() > 0) {
				trabajadorSeleccionadas = selectedTrabajador.get(0);
				flagTrabajador = 0L;
				for (int i = 1; i < selectedTrabajador.size(); i++) {
					trabajadorSeleccionadas += "," + selectedTrabajador.get(i);
				}
			}

			String conceptoNominaSeleccionadas = "";
			if (selectedConceptoNomina != null && selectedConceptoNomina.size() > 0) {
				conceptoNominaSeleccionadas = selectedConceptoNomina.get(0);
				flagConceptoNomina = 0L;
				for (int i = 1; i < selectedConceptoNomina.size(); i++) {
					conceptoNominaSeleccionadas += "," + selectedConceptoNomina.get(i);
				}
			}
			if (compania != null && fechaInicial !=null && fechaFinal !=null) {

				data = businessDelegatorView.consultaInterfaceManagerExportarAusentismosMo(compania, fechaInicial,
						fechaFinal,
						contratistasSeleccionadas, flagContratista, trabajadorSeleccionadas,
						flagTrabajador,conceptoNominaSeleccionadas,flagConceptoNomina);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	
	
	

	public String exportInterfazVer1() {

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

		// String zona = "1";
		Long flagContratista = 1L;
		Long flagTrabajador = 1L;
		Long flagConceptoNomina = 1L;
		
		
		String contratistasSeleccionadas = "";
		if (selectedContratista != null && selectedContratista.size() > 0) {
			contratistasSeleccionadas = selectedContratista.get(0);
			flagContratista = 0L;
			for (int i = 1; i < selectedContratista.size(); i++) {
				contratistasSeleccionadas += "," + selectedContratista.get(i);
			}
		}

		String trabajadorSeleccionadas = "";
		if (selectedTrabajador != null && selectedTrabajador.size() > 0) {
			trabajadorSeleccionadas = selectedTrabajador.get(0);
			flagTrabajador = 0L;
			for (int i = 1; i < selectedTrabajador.size(); i++) {
				trabajadorSeleccionadas += "," + selectedTrabajador.get(i);
			}
		}
		String conceptoNominaSeleccionadas = "";
		if (selectedConceptoNomina != null && selectedConceptoNomina.size() > 0) {
			conceptoNominaSeleccionadas = selectedConceptoNomina.get(0);
			flagConceptoNomina = 0L;
			for (int i = 1; i < selectedConceptoNomina.size(); i++) {
				conceptoNominaSeleccionadas += "," + selectedConceptoNomina.get(i);
			}
		}
		if (compania != null) {
			try {

				List<interfaceManagerExpRegistrosMODTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "interfaceManagerAusentismosMo.xlsx";

				data = businessDelegatorView.consultaInterfaceManagerExportarAusentismosMo(compania, fechaInicial, fechaFinal,
						"", 1L, trabajadorSeleccionadas,
						flagTrabajador,conceptoNominaSeleccionadas,flagConceptoNomina);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);
					XSSFCellStyle styleCurrencyFormat = null;

					XSSFRow row = sheet.createRow(0);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);

					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.TAN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					Font font = book.createFont();
					font.setColor(IndexedColors.DARK_RED.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");
					
					style2.setFont(font);

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					dollarStyle.setDataFormat(df.getFormat("$#,#0.000"));

					if (data != null) {

						cell = row.createCell(0);
						cell.setCellValue("SUBIRSN.C1");
						cell.setCellStyle(style2);

						cell = row.createCell(1);
						cell.setCellValue("TIPODOC.C4");
						cell.setCellStyle(style2);

						cell = row.createCell(2);
						cell.setCellValue("CEDULA.C15");
						cell.setCellStyle(style2);
						
						cell = row.createCell(3);
						cell.setCellValue("NOMBRE.C50");
						cell.setCellStyle(style2);
						
						cell = row.createCell(4);
						cell.setCellValue("CAUSAL");
						cell.setCellStyle(style2);

						cell = row.createCell(5);
						cell.setCellValue("LIMPIO.C50");
						cell.setCellStyle(style2);
						
						cell = row.createCell(6);
						cell.setCellValue("FECINI.C10");
						cell.setCellStyle(style2);

						cell = row.createCell(7);
						cell.setCellValue("DIAS.N10");
						cell.setCellStyle(style2);
						
						cell = row.createCell(8);
						cell.setCellValue("CANTI.N12");
						cell.setCellStyle(style2);

						cell = row.createCell(9);
						cell.setCellValue("VALOR.N12");
						cell.setCellStyle(style2);

						cell = row.createCell(10);
						cell.setCellValue("DETALLE.M4");
						cell.setCellStyle(style2);
						
						cell = row.createCell(11);
						cell.setCellValue("DIAGNOS.C6");
						cell.setCellStyle(style2);
						
						cell = row.createCell(12);
						cell.setCellValue("LIMPIO2.C10");
						cell.setCellStyle(style2);
						
						cell = row.createCell(13);
						cell.setCellValue("LIMPIO3.M4");
						cell.setCellStyle(style2);
						
						
						
						int pos_i = 1;

						
						for (interfaceManagerExpRegistrosMODTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue("S");
							cell.setCellStyle(style1);

							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getIdTipoDoc());

							cell = row.createCell(2);
							cell.setCellValue("'"+ndDTO.getCedulaEmpleado().toString());
							cell.setCellStyle(style);

							cell = row.createCell(3);
							cell.setCellValue(".");
							cell.setCellStyle(style);
							
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodConceptoNomina());

							cell = row.createCell(5);
							cell.setCellValue(0);
							cell.setCellStyle(style);
							
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getFecha_texto());

							cell = row.createCell(7);
							cell.setCellValue(0);
							cell.setCellStyle(style);
							
							cell = row.createCell(8);
							cell.setCellValue(0);
							cell.setCellStyle(style);
							
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell.setCellStyle(style1);
							
							cell = row.createCell(10);
							cell.setCellValue(".");
							cell.setCellStyle(style);
							
							cell = row.createCell(11);
							cell.setCellValue(".");
							cell.setCellStyle(style);
							
							cell = row.createCell(12);
							cell.setCellValue(".");
							cell.setCellStyle(style);
							
							cell = row.createCell(13);
							cell.setCellValue(".");
							cell.setCellStyle(style);
							


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

						file = new DefaultStreamedContent(stream, "application/xlsx", "interfaceManagerAusentismosMo.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"La interfaz se ha generado con exito, ahora puedes Descargar el archivo de la interfaz"));

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


	

	public String exportInterfazVer2() {

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

		// String zona = "1";
		Long flagContratista = 1L;
		Long flagTrabajador = 1L;
		
		String contratistasSeleccionadas = "";
		if (selectedContratista != null && selectedContratista.size() > 0) {
			contratistasSeleccionadas = selectedContratista.get(0);
			flagContratista = 0L;
			for (int i = 1; i < selectedContratista.size(); i++) {
				contratistasSeleccionadas += "," + selectedContratista.get(i);
			}
		}
		

		String trabajadorSeleccionadas = "";
		if (selectedTrabajador != null && selectedTrabajador.size() > 0) {
			trabajadorSeleccionadas = selectedTrabajador.get(0);
			flagTrabajador = 0L;
			for (int i = 1; i < selectedTrabajador.size(); i++) {
				trabajadorSeleccionadas += "," + selectedTrabajador.get(i);
			}
		}
		
		Long flagConceptoNomina = 1l;
		
		String conceptoNominaSeleccionadas = "";
		if (selectedConceptoNomina != null && selectedConceptoNomina.size() > 0) {
			conceptoNominaSeleccionadas = selectedConceptoNomina.get(0);
			flagConceptoNomina = 0L;
			for (int i = 1; i < selectedConceptoNomina.size(); i++) {
				conceptoNominaSeleccionadas += "," + selectedConceptoNomina.get(i);
			}
		}

		if (compania != null) {
			try {

				List<interfaceManagerExpRegistrosMODTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "interfaceManagerAusentismosMo.xlsx";

				data = businessDelegatorView.consultaInterfaceManagerExportarAusentismosMo(compania, fechaInicial, fechaFinal,
						"", 1L, trabajadorSeleccionadas,
						flagTrabajador, conceptoNominaSeleccionadas, flagConceptoNomina);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);
					XSSFCellStyle styleCurrencyFormat = null;

					XSSFRow row = sheet.createRow(0);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);

					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.TAN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					Font font = book.createFont();
					font.setColor(IndexedColors.DARK_RED.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");
					style2.setFont(font);

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					dollarStyle.setDataFormat(df.getFormat("$#,#0.000"));

					if (data != null) {

						cell = row.createCell(0);
						cell.setCellValue("ID_EMPRESA");
						cell.setCellStyle(style2);

						cell = row.createCell(1);
						cell.setCellValue("ID_TIPODOC");
						cell.setCellStyle(style2);

						cell = row.createCell(2);
						cell.setCellValue("CEDULAEMPLEADO");
						cell.setCellStyle(style2);

						cell = row.createCell(3);
						cell.setCellValue("CAUSAL");
						cell.setCellStyle(style2);

						cell = row.createCell(4);
						cell.setCellValue("FECHA");
						cell.setCellStyle(style2);

						cell = row.createCell(5);
						cell.setCellValue("DIAS");
						cell.setCellStyle(style2);

						cell = row.createCell(6);
						cell.setCellValue("CANTIDAD");
						cell.setCellStyle(style2);

						cell = row.createCell(7);
						cell.setCellValue("VALOR");
						cell.setCellStyle(style2);
						int pos_i = 1;

						for (interfaceManagerExpRegistrosMODTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getIdEmpresa());
							cell.setCellStyle(style1);

							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getIdTipoDoc());

							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCedulaEmpleado());
							cell.setCellStyle(style);

							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getCuentaContable());

							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getFecha_texto());

							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNumDias());

							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell.setCellStyle(style1);

							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell.setCellStyle(style1);

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

						file1 = new DefaultStreamedContent(stream, "application/xlsx", "interfaceManagerAusentismosMo.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"La interfaz se ha generado con exito, ahora puedes Descargar el archivo de la interfaz"));

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

		visible1 = "visible";
		disableButton1 = "false";
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

	public List<String> getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(List<String> selectedTrabajador) {
		this.selectedTrabajador = selectedTrabajador;
	}

	public List<Trabajador> getTrabajadores() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {
				trabajador = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return trabajador;
	}

	public void setTrabajadores(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * @return the trabajador
	 */
	public List<Trabajador> getTrabajador() {
		return trabajador;
	}

	/**
	 * @param trabajador the trabajador to set
	 */
	public void setTrabajador(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the visible
	 */
	public String getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(String visible) {
		this.visible = visible;
	}

	/**
	 * @return the file
	 */
	public StreamedContent getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(StreamedContent file) {
		this.file = file;
	}

	/**
	 * @return the disableButton
	 */
	public String getDisableButton() {
		return disableButton;
	}

	/**
	 * @param disableButton the disableButton to set
	 */
	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<interfaceManagerExpRegistrosMODTO> data) {
		this.data = data;
	}

	/**
	 * @return the file1
	 */
	public StreamedContent getFile1() {
		return file1;
	}

	/**
	 * @param file1 the file1 to set
	 */
	public void setFile1(StreamedContent file1) {
		this.file1 = file1;
	}

	/**
	 * @return the disableButton1
	 */
	public String getDisableButton1() {
		return disableButton1;
	}

	/**
	 * @param disableButton1 the disableButton1 to set
	 */
	public void setDisableButton1(String disableButton1) {
		this.disableButton1 = disableButton1;
	}

	/**
	 * @return the visible1
	 */
	public String getVisible1() {
		return visible1;
	}

	/**
	 * @param visible1 the visible1 to set
	 */
	public void setVisible1(String visible1) {
		this.visible1 = visible1;
	}
	

	public List<String> getSelectedConceptoNomina() {
		return selectedConceptoNomina;
	}

	public void setSelectedConceptoNomina(List<String> selectedConceptoNomina) {
		this.selectedConceptoNomina = selectedConceptoNomina;
	}

	public List<ConceptoNomina> getConceptoNominas() {
		if (conceptoNominas == null || conceptoNominas.size() == 0) {

			conceptoNominas = new ArrayList<ConceptoNomina>();

			try {
				conceptoNominas = businessDelegatorView.getConceptoNomina();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return conceptoNominas;
	}

	public void setConceptoNominaes(List<ConceptoNomina> conceptoNominas) {
		this.conceptoNominas = conceptoNominas;
	}


	
}
