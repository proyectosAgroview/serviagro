package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
import org.primefaces.component.inputtext.InputText;
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

import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
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
public class InformeSRControlProductividadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeSRControlProductividadView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	
	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsultaServiciosRealizadosMaquinariaDTO> data;

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

	private List<String> selectedPropietario;
	private List<PersEmpr> propietarios;

	private List<String> selectedModelo;
	private List<ModeloEquipo> modelos;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;
	
	private List<String> selectedEquipoGrLabor;
	private List<Equipo> equiposGrLabor;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";


	private List<String> selectedCliente;
	private List<PersEmpr> clientes;

	private List<String> selectedNivel2Clientesmq;
	private List<Nivel2Clientesmq> nivel2Clientesmq;
	
	private List<String> selectedOperador;
	private List<Trabajador> operadores;

	private SelectOneMenu txtEstadoServicio;
	private InputText txtMetaProductividad;
	
	private SelectOneMenu txtModeloEquipoId_ModeloEquipo;
	SelectItem[] selectModeloEquipo;
	private List<ModeloEquipo> modeloEquipo;

	private List<String> selectedCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipos;
	
	private SelectOneMenu txtGrpLaborId_GrpLabor;
	SelectItem[] selectGrpLabor;
	private List<GrpLabor> grpLabor;

	public InformeSRControlProductividadView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public void controlProductividad() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);
		
		// String zona = "1";
		
		Long flagEquipo = 1L;
		
		Long flagOperador = 1L;
		Long flagClientes = 1L;
		String fini= sdf.format(fechaInicial);
		String ffin = sdf.format(fechaFinal);

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		String operadorSeleccionadas = "";
		if (selectedOperador != null && selectedOperador.size() > 0) {
			operadorSeleccionadas = selectedOperador.get(0);
			flagOperador = 0L;
			for (int i = 1; i < selectedOperador.size(); i++) {
				operadorSeleccionadas += "," + selectedOperador.get(i);
			}
		}
		
		
		
		String clientesSeleccionadas = "";
		if (selectedCliente != null && selectedCliente.size() > 0) {
			clientesSeleccionadas = selectedCliente.get(0);
			flagClientes = 0L;
			for (int i = 1; i < selectedCliente.size(); i++) {
				clientesSeleccionadas += "," + selectedCliente.get(i);
			}
		}
		
		
		
		if (compania != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "mttoSRProductividadOperario.xlsx";
				
				data = businessDelegator2View.pr_control_productividad_operario(compania,  fechaInicial, fechaFinal, 
							operadorSeleccionadas, flagOperador,"0",1L);
				
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
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
					style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
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
						
						cell = row.createCell(0	);	cell.setCellValue("ANIO REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue("MES");	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue("FECHA REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue("COD OPERARIO");	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue("NOM OPERARIO");	cell.setCellStyle(style2);
						cell = row.createCell(5	);	cell.setCellValue("COD CONCEPTO NOMINA");	cell.setCellStyle(style2);
						cell = row.createCell(6	);	cell.setCellValue("NOM CONCEPTO NOMINA");	cell.setCellStyle(style2);
						cell = row.createCell(7	);	cell.setCellValue("TURNO");	cell.setCellStyle(style2);
						
						cell = row.createCell(8	);	cell.setCellValue("DOCUMENTO PIN");	cell.setCellStyle(style2);
						cell = row.createCell(9	);	cell.setCellValue("ID REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(10);	cell.setCellValue("ESTADO EN EL DÍA");	cell.setCellStyle(style2);
						cell = row.createCell(11);	cell.setCellValue("N_REGISTROS");	cell.setCellStyle(style2);
						
						cell = row.createCell(12);	cell.setCellValue("F. INICIAL");	cell.setCellStyle(style2);
						
						cell = row.createCell(13);	cell.setCellValue("F. FINAL");	cell.setCellStyle(style2);
						cell = row.createCell(14);	cell.setCellValue("COD. MAQUINA");	cell.setCellStyle(style2);
						cell = row.createCell(15);	cell.setCellValue("MAQUINA");	cell.setCellStyle(style2);
						cell = row.createCell(16);	cell.setCellValue("TIEMPO");	cell.setCellStyle(style2);
						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0	);	cell.setCellValue(ndDTO.getAnio().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(1	);	cell.setCellValue(ndDTO.getMes().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(2	);	
							cell.setCellValue(
									ndDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
									ndDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
									ndDTO.getFechaRegistro().toString().substring(0, 4));
							cell.setCellStyle(style);
							
							cell = row.createCell(3	);	cell.setCellValue(ndDTO.getCod_operario());	cell.setCellStyle(style);
							cell = row.createCell(4	);	cell.setCellValue(ndDTO.getNom_operario());	cell.setCellStyle(style);
							cell = row.createCell(5	);	cell.setCellValue(ndDTO.getCod_concepto_nomina());	cell.setCellStyle(style);
							cell = row.createCell(6	);	cell.setCellValue(ndDTO.getNom_concepto_nomina());	cell.setCellStyle(style);
							cell = row.createCell(7	);	cell.setCellValue(ndDTO.getTurno());	cell.setCellStyle(style);
							cell = row.createCell(8	);	cell.setCellValue(ndDTO.getConsecutivo().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(9	);	cell.setCellValue(ndDTO.getDat_serv_realizados_equipo_id().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(10	);	cell.setCellValue(ndDTO.getTipoTiempo());	cell.setCellStyle(style);
							cell = row.createCell(11	);	cell.setCellValue(1l);	cell.setCellStyle(style);
							
							cell = row.createCell(12	);	
							cell.setCellValue(fini);
							cell.setCellStyle(style);
							
							cell = row.createCell(13	);	
							cell.setCellValue(ffin);
							cell.setCellStyle(style);
							
							cell = row.createCell(14	);	cell.setCellValue(ndDTO.getCodEquipo());	cell.setCellStyle(style);
							cell = row.createCell(15);	cell.setCellValue(ndDTO.getNomEquipo());	cell.setCellStyle(style);
							cell = row.createCell(16);	cell.setCellValue(ndDTO.getTiempo());	cell.setCellStyle(style);
							
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "mttoSRProductividadOperario.xlsx");

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
		
	}



	public void controlProductividadMaquina() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		// Long compania = 1L;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		
		
		// String zona = "1";
		
		Long flagEquipo = 1L;
		
		Long flagOperador = 1L;
		Long flagClientes = 1L;
		String fini= sdf.format(fechaInicial);
		String ffin = sdf.format(fechaFinal);
		Long flagEquipoCategoriaEquipos = 1l;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		String operadorSeleccionadas = "";
		if (selectedOperador != null && selectedOperador.size() > 0) {
			operadorSeleccionadas = selectedOperador.get(0);
			flagOperador = 0L;
			for (int i = 1; i < selectedOperador.size(); i++) {
				operadorSeleccionadas += "," + selectedOperador.get(i);
			}
		}
		
		
		
		String clientesSeleccionadas = "";
		if (selectedCliente != null && selectedCliente.size() > 0) {
			clientesSeleccionadas = selectedCliente.get(0);
			flagClientes = 0L;
			for (int i = 1; i < selectedCliente.size(); i++) {
				clientesSeleccionadas += "," + selectedCliente.get(i);
			}
		}
		
		String categoriaEquiposSeleccionadas = "";
		if (selectedCategoriaEquipo != null && selectedCategoriaEquipo.size() > 0) {
			categoriaEquiposSeleccionadas = selectedCategoriaEquipo.get(0);
			flagEquipoCategoriaEquipos = 0L;
			for (int i = 1; i < selectedCategoriaEquipo.size(); i++) {
				categoriaEquiposSeleccionadas += "," + selectedCategoriaEquipo.get(i);
			}
		}
		Long modelo = 0l;
		if(txtModeloEquipoId_ModeloEquipo.getValue()!=null) {
			 modelo = FacesUtils.checkLong(txtModeloEquipoId_ModeloEquipo);
		}
	
		
			if(compania != null && fechaInicial != null && fechaFinal != null){
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "mttoSRProductividadMaquina.xlsx";
				
				data = businessDelegator2View.pr_control_productividad_maquinaria(compania,  fechaInicial, fechaFinal, 
						"0",1L ,equiposSeleccionadas,flagEquipo,  categoriaEquiposSeleccionadas,  flagEquipoCategoriaEquipos,  modelo);
				
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
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
					style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
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
						
						cell = row.createCell(0	);	cell.setCellValue("ANIO REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue("MES");	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue("FECHA REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue("COD OPERARIO");	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue("NOM OPERARIO");	cell.setCellStyle(style2);
						
						cell = row.createCell(5);	cell.setCellValue("ESTADO EN EL DÍA");	cell.setCellStyle(style2);
						cell = row.createCell(6);	cell.setCellValue("N_REGISTROS");	cell.setCellStyle(style2);
						
						cell = row.createCell(7);	cell.setCellValue("F. INICIAL");	cell.setCellStyle(style2);
						
						cell = row.createCell(8);	cell.setCellValue("F. FINAL");	cell.setCellStyle(style2);
						cell = row.createCell(9);	cell.setCellValue("COD. MAQUINA");	cell.setCellStyle(style2);
						cell = row.createCell(10);	cell.setCellValue("MAQUINA");	cell.setCellStyle(style2);
						cell = row.createCell(11);	cell.setCellValue("TIEMPO");	cell.setCellStyle(style2);
						cell = row.createCell(12);	cell.setCellValue("DIA");	cell.setCellStyle(style2);
						cell = row.createCell(13);	cell.setCellValue("EVENTO");	cell.setCellStyle(style2);
						cell = row.createCell(14);	cell.setCellValue("LABOR");	cell.setCellStyle(style2);
						cell = row.createCell(15);	cell.setCellValue("CATEGORIA");	cell.setCellStyle(style2);
						cell = row.createCell(16);	cell.setCellValue("MODELO");	cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0	);	cell.setCellValue(ndDTO.getAnio().longValue());	cell.setCellStyle(style);
							cell = row.createCell(1	);	cell.setCellValue(ndDTO.getMes().longValue());	cell.setCellStyle(style);
							cell = row.createCell(2	);	
							cell.setCellValue(
									ndDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
									ndDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
									ndDTO.getFechaRegistro().toString().substring(0, 4));
							cell.setCellStyle(style);
							
							cell = row.createCell(3	);	cell.setCellValue(ndDTO.getCod_operario());	cell.setCellStyle(style);
							cell = row.createCell(4	);	cell.setCellValue(ndDTO.getNom_operario());	cell.setCellStyle(style);
							cell = row.createCell(5	);	cell.setCellValue(ndDTO.getTipoTiempo());	cell.setCellStyle(style);
							cell = row.createCell(6);	cell.setCellValue(1l);	cell.setCellStyle(style);
							
							cell = row.createCell(7	);	
							cell.setCellValue(fini);
							cell.setCellStyle(style);
							
							cell = row.createCell(8	);	
							cell.setCellValue(ffin);
							cell.setCellStyle(style);
							
							cell = row.createCell(9	);	cell.setCellValue(ndDTO.getCodEquipo());	cell.setCellStyle(style);
							cell = row.createCell(10);	cell.setCellValue(ndDTO.getNomEquipo());	cell.setCellStyle(style);
							cell = row.createCell(11);	cell.setCellValue(ndDTO.getTiempo());	cell.setCellStyle(style);
							cell = row.createCell(12);	cell.setCellValue(ndDTO.getDia().longValue());	cell.setCellStyle(style);
							cell = row.createCell(13);	
							if(ndDTO.getTipoTiempo().equals("Productividad")) {
								cell.setCellValue(1);	
							}
							if(ndDTO.getTipoTiempo().equals("Parado en taller")	) {
								cell.setCellValue(2);	
							}
							if(	ndDTO.getTipoTiempo().equals("Parado por lluvia")
									|| ndDTO.getTipoTiempo().equals("Parado por humedad")) {
								cell.setCellValue(3);	
							}
							if(ndDTO.getTipoTiempo().equals("Parado dia sin Labor")) {
								cell.setCellValue(4);	
							}
							cell.setCellStyle(style);
							
							cell = row.createCell(14);	cell.setCellValue(ndDTO.getNomLabor());	cell.setCellStyle(style);
							cell = row.createCell(15);	cell.setCellValue(ndDTO.getCategoriaEquipo());	cell.setCellStyle(style);
							cell = row.createCell(16);	cell.setCellValue(ndDTO.getModeloEquipo());	cell.setCellStyle(style);
							
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "mttoSRProductividadMaquina.xlsx");

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
		
	}


	

	public void controlProductividadMaquinaGrLabor() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		// Long compania = 1L;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Double meta = FacesUtils.checkDouble(txtMetaProductividad);
		
		Long grupoLabor = FacesUtils.checkLong(txtGrpLaborId_GrpLabor);
		if(meta ==null) {
			meta = 0.6;
		}else {
			meta=	meta/100.0;
		}
		
		// String zona = "1";
		
		Long flagEquipo = 1L;
		
		Long flagOperador = 1L;
		Long flagClientes = 1L;
		String fini= sdf.format(fechaInicial);
		String ffin = sdf.format(fechaFinal);

		String equiposSeleccionadas = "";
		if (selectedEquipoGrLabor != null && selectedEquipoGrLabor.size() > 0) {
			equiposSeleccionadas = selectedEquipoGrLabor.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipoGrLabor.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipoGrLabor.get(i);
			}
		}

		
		if (compania != null && fechaInicial!=null && fechaFinal !=null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "mttoRdtoMaquinaConcepto.xlsx";
				
				data = businessDelegator2View.pr_control_productividad_maquina_grlabor(compania,  fechaInicial, fechaFinal, 
						equiposSeleccionadas,flagEquipo,  grupoLabor);
				
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
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
					style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
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
						
						cell = row.createCell(0	);	cell.setCellValue("ANIO REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue("MES");	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue("FECHA REGISTRO");	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue("COD OPERARIO");	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue("NOM OPERARIO");	cell.setCellStyle(style2);
						
						cell = row.createCell(5);	cell.setCellValue("ESTADO EN EL DÍA");	cell.setCellStyle(style2);
						cell = row.createCell(6);	cell.setCellValue("N_REGISTROS");	cell.setCellStyle(style2);
						
						cell = row.createCell(7);	cell.setCellValue("F. INICIAL");	cell.setCellStyle(style2);
						
						cell = row.createCell(8);	cell.setCellValue("F. FINAL");	cell.setCellStyle(style2);
						cell = row.createCell(9);	cell.setCellValue("COD. MAQUINA");	cell.setCellStyle(style2);
						cell = row.createCell(10);	cell.setCellValue("MAQUINA");	cell.setCellStyle(style2);
						cell = row.createCell(11);	cell.setCellValue("TIEMPO");	cell.setCellStyle(style2);
						cell = row.createCell(12);	cell.setCellValue("DIA");	cell.setCellStyle(style2);
						cell = row.createCell(13);	cell.setCellValue("CONCEPTO");	cell.setCellStyle(style2);
					
						cell = row.createCell(14);	cell.setCellValue("TIEMPO PRODUCTIVO");	cell.setCellStyle(style2);
						cell = row.createCell(15);	cell.setCellValue("TIEMPO TRANSPORTE");	cell.setCellStyle(style2);
						cell = row.createCell(16);	cell.setCellValue("TIEMPO IMPRODUCTIVO");	cell.setCellStyle(style2);
						cell = row.createCell(17);	cell.setCellValue("HORAS ESTANDAR POR DIA");	cell.setCellStyle(style2);
						cell = row.createCell(18);	cell.setCellValue("TURNO");	cell.setCellStyle(style2);
						cell = row.createCell(19);	cell.setCellValue("DIAS IMPRODUCTIVOS DOMINGOS");	cell.setCellStyle(style2);
						cell = row.createCell(20);	cell.setCellValue("DIAS IMPRODUCTIVOS OTROS");	cell.setCellStyle(style2);
						cell = row.createCell(21);	cell.setCellValue("DIAS PRODUCTIVOS");	cell.setCellStyle(style2);
						cell = row.createCell(22);	cell.setCellValue("META PRODUCTIVIDAD");	cell.setCellStyle(style2);
						cell = row.createCell(23);	cell.setCellValue("HORAS OTRAS LABORES");	cell.setCellStyle(style2);
						
						
						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0	);	cell.setCellValue(ndDTO.getAnio().longValue());	cell.setCellStyle(style);
							cell = row.createCell(1	);	cell.setCellValue(ndDTO.getMes().longValue());	cell.setCellStyle(style);
							cell = row.createCell(2	);	
							cell.setCellValue(
									ndDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
									ndDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
									ndDTO.getFechaRegistro().toString().substring(0, 4));
							cell.setCellStyle(style);
							
							cell = row.createCell(3	);	cell.setCellValue(ndDTO.getCod_operario());	cell.setCellStyle(style);
							cell = row.createCell(4	);	cell.setCellValue(ndDTO.getNom_operario());	cell.setCellStyle(style);
							cell = row.createCell(5	);	cell.setCellValue(ndDTO.getTipoTiempo());	cell.setCellStyle(style);
							cell = row.createCell(6);	cell.setCellValue(ndDTO.getNumeroRegistros().doubleValue());	cell.setCellStyle(style);
							
							cell = row.createCell(7	);	
							cell.setCellValue(fini);
							cell.setCellStyle(style);
							
							cell = row.createCell(8	);	
							cell.setCellValue(ffin);
							cell.setCellStyle(style);
							
							cell = row.createCell(9	);	cell.setCellValue(ndDTO.getCodEquipo());	cell.setCellStyle(style);
							cell = row.createCell(10);	cell.setCellValue(ndDTO.getNomEquipo());	cell.setCellStyle(style);
							cell = row.createCell(11);	cell.setCellValue(ndDTO.getTiempo());	cell.setCellStyle(style);
							cell = row.createCell(12);	cell.setCellValue(ndDTO.getDia().longValue());	cell.setCellStyle(style);
							
							cell = row.createCell(13);	cell.setCellValue(ndDTO.getNomGrupoGasto());	cell.setCellStyle(style);
							cell = row.createCell(14);	cell.setCellValue(ndDTO.getHorasTotales().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(15);	cell.setCellValue(ndDTO.getHorasTransporte().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(16);	cell.setCellValue(ndDTO.getHorasImproductivas().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(17);	cell.setCellValue(ndDTO.getHorasEstandar().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(18);	cell.setCellValue(ndDTO.getTurnoNumero().longValue());	cell.setCellStyle(style);
							
							cell = row.createCell(19);	cell.setCellValue(ndDTO.getDiasImproductivoDomingos().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(20);	cell.setCellValue(ndDTO.getDiasImproductivoOtros().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(21);	cell.setCellValue(ndDTO.getDiasProductivos().doubleValue());	cell.setCellStyle(style);
							cell = row.createCell(22);	cell.setCellValue(meta);	cell.setCellStyle(style);
							cell = row.createCell(23);	cell.setCellValue(ndDTO.getHorasOtrasLabores().doubleValue());	cell.setCellStyle(style);
							
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "mttoRdtoMaquinaConcepto.xlsx");

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
		
	}


	public StreamedContent getFile() {

		return file;
	}

	public void setFile(StreamedContent file) {

		if (file != null) {
			this.file = file;
		}
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

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.consultaLiqServRealizadosEquipoOperario(null, null, null, null, null, null,
						null);
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

	public List<String> getSelectedVariedades() {
		return selectedVariedades;
	}

	public void setSelectedVariedades(List<String> selectedVariedades) {
		this.selectedVariedades = selectedVariedades;
	}

	public List<Variedad> getVariedades() {

		if (variedades == null || variedades.size() == 0) {

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

	public List<String> getSelectedPropietario() {
		return selectedPropietario;
	}

	public void setSelectedPropietario(List<String> selectedPropietario) {
		this.selectedPropietario = selectedPropietario;
	}

	public List<PersEmpr> getPropietarios() {
		if (propietarios == null || propietarios.size() == 0) {

			try {
				propietarios = businessDelegatorView.getPersEmpr();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return propietarios;
	}

	public void setPropietarios(List<PersEmpr> propietarios) {
		this.propietarios = propietarios;
	}

	public List<String> getSelectedModelo() {
		return selectedModelo;
	}

	public void setSelectedModelo(List<String> selectedModelo) {
		this.selectedModelo = selectedModelo;
	}

	public List<ModeloEquipo> getModelos() {
		if (modelos == null || modelos.size() == 0) {

			
			try {
				modelos = businessDelegatorView.getModeloEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return modelos;
	}

	public void setModelos(List<ModeloEquipo> modelos) {
		this.modelos = modelos;
	}

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			
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

	

	public List<String> getSelectedEquipoGrLabor() {
		return selectedEquipoGrLabor;
	}

	public void setSelectedEquipoGrLabor(List<String> selectedEquipoGrLabor) {
		this.selectedEquipoGrLabor = selectedEquipoGrLabor;
	}

	public List<Equipo> getEquiposGrLabor() {
		if (equiposGrLabor == null || equiposGrLabor.size() == 0) {

			
			try {
					Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						
						"categoriaEquipo.funcion", true, "Tractor", "="
						
				};
					equiposGrLabor= businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return equiposGrLabor;
	}

	public void setEquiposGrLabor(List<Equipo> equiposGrLabor) {
		this.equiposGrLabor = equiposGrLabor;
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

			try {

			
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

		
			try {

			
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
	
	
	public List<String> getSelectedNivel2Clientesmq() {
		return selectedNivel2Clientesmq;
	}

	public void setSelectedNivel2Clientesmq(List<String> selectedNivel2Clientesmq) {
		this.selectedNivel2Clientesmq = selectedNivel2Clientesmq;
	}

	public List<Nivel2Clientesmq> getNivel2Clientesmq() {

		if (nivel2Clientesmq == null || nivel2Clientesmq.size() == 0) {

			
			try {
				nivel2Clientesmq = businessDelegator2View.getNivel2Clientesmq();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return nivel2Clientesmq;
	}

	public void setNivel2Clientesmq(List<Nivel2Clientesmq> nivel2Clientesmq) {
		this.nivel2Clientesmq = nivel2Clientesmq;
	}


	
	public List<String> getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(List<String> selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public List<PersEmpr> getClientes() {

		if (clientes == null || clientes.size() == 0) {

		
			try {
				clientes = businessDelegatorView.getPersEmpr();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return clientes;
	}

	public void setClientes(List<PersEmpr> clientes) {
		this.clientes = clientes;
	}


	
	public List<String> getSelectedOperador() {
		return selectedOperador;
	}

	public void setSelectedOperador(List<String> selectedOperador) {
		this.selectedOperador = selectedOperador;
	}

	public List<Trabajador> getOperadores() {

		if (operadores == null || operadores.size() == 0) {

			try {
				operadores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return operadores;
	}

	public void setOperadores(List<Trabajador> operadores) {
		this.operadores = operadores;
	}

	public SelectOneMenu getTxtEstadoServicio() {
		return txtEstadoServicio;
	}

	public void setTxtEstadoServicio(SelectOneMenu txtEstadoServicio) {
		this.txtEstadoServicio = txtEstadoServicio;
	}

	public void setData(List<ConsultaServiciosRealizadosMaquinariaDTO> data) {
		this.data = data;
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputText getTxtMetaProductividad() {
		return txtMetaProductividad;
	}

	public void setTxtMetaProductividad(InputText txtMetaProductividad) {
		this.txtMetaProductividad = txtMetaProductividad;
	}


	public SelectItem[] getSelectModeloEquipo() {

		if (modeloEquipo == null || modeloEquipo.size() == 0) {

			
			try {

					// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ModeloEquipo> lista = businessDelegatorView.findByCriteriaInModeloEquipo(condicion, null, null);
				selectModeloEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (ModeloEquipo modeloEquipo : lista) {
					selectModeloEquipo[i] = new SelectItem(modeloEquipo.getModeloEquipoId(), modeloEquipo.getCodigo());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectModeloEquipo;
	}

	public void setselectModeloEquipo(SelectItem[] selectModeloEquipo) {
		this.selectModeloEquipo = selectModeloEquipo;
	}

	public SelectOneMenu getTxtModeloEquipoId_ModeloEquipo() {
		return txtModeloEquipoId_ModeloEquipo;
	}

	public void setTxtModeloEquipoId_ModeloEquipo(SelectOneMenu txtModeloEquipoId_ModeloEquipo) {
		this.txtModeloEquipoId_ModeloEquipo = txtModeloEquipoId_ModeloEquipo;
	}

	public List<String> getSelectedCategoriaEquipo() {
		return selectedCategoriaEquipo;
	}

	public void setSelectedCategoriaEquipo(List<String> selectedCategoriaEquipo) {
		this.selectedCategoriaEquipo = selectedCategoriaEquipo;
	}

	public List<CategoriaEquipo> getCategoriaEquipos() {

		if (categoriaEquipos == null || categoriaEquipos.size() == 0) {

			try {
				categoriaEquipos = businessDelegatorView.getCategoriaEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return categoriaEquipos;
	}

	public void setCategoriaEquipos(List<CategoriaEquipo> categoriaEquipos) {
		this.categoriaEquipos = categoriaEquipos;
	}
	

	public SelectItem[] getSelectGrpLabor() {

		if (grpLabor == null || grpLabor.size() == 0) {

			
			try {

				grpLabor = businessDelegatorView.getGrpLabor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "grpLaborId", true, "62", ">" };
				List<GrpLabor> lista = businessDelegatorView.findByCriteriaInGrpLabor(condicion, null, null);
				selectGrpLabor = new SelectItem[lista.size()];

				int i = 0;
				for (GrpLabor grpLabor : lista) {
					selectGrpLabor[i] = new SelectItem(grpLabor.getGrpLaborId(),
							grpLabor.getCodigo() + " - " + grpLabor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectGrpLabor;
	}

	public void setselectGrpLabor(SelectItem[] selectGrpLabor) {
		this.selectGrpLabor = selectGrpLabor;
	}

	public SelectOneMenu getTxtGrpLaborId_GrpLabor() {
		return txtGrpLaborId_GrpLabor;
	}

	public void setTxtGrpLaborId_GrpLabor(SelectOneMenu txtGrpLaborId_GrpLabor) {
		this.txtGrpLaborId_GrpLabor = txtGrpLaborId_GrpLabor;
	}
	
}
