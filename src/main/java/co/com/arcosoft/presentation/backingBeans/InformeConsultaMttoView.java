package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.informes.dto.ConsultaMttoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped

public class InformeConsultaMttoView {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeConsultaMttoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsultaMttoDTO> data;
	
	private List<ConsultaMttoDTO> data2;

	private List<String> selectedEquipo;
	private List<Equipo> equipo;

	private List<String> selectedPropietarioEquipo;
	private List<PersEmpr> propietarioEquipo;

	private List<String> selectedTipoMtto;
	private List<TipoMantenimiento> tipoMtto;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "true";
	private String visible = "hidden";

	public InformeConsultaMttoView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		
		return "";
	}

	public String exportToPyGExcel() {

		Long compania = FacesUtils.checkLong(txtCompania);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		String equipo = "1";
		String propietarioEquipo = "1";
		String tipoMtto = "20";
		Long flagEquipo = 1L;
		Long flagPropietarioEquipo = 1L;
		Long flagTipoMtto = 1L;

		String equiposSeleccionados = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionados = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionados += "," + selectedEquipo.get(i);
			}
		}

		String pEquiposSeleccionados = "";
		if (selectedPropietarioEquipo != null && selectedPropietarioEquipo.size() > 0) {
			pEquiposSeleccionados = selectedPropietarioEquipo.get(0);
			flagPropietarioEquipo = 0L;
			for (int i = 1; i < selectedPropietarioEquipo.size(); i++) {
				pEquiposSeleccionados += "," + selectedPropietarioEquipo.get(i);
			}
		}

		String tMttoSeleccionados = "";
		if (selectedTipoMtto != null && selectedTipoMtto.size() > 0) {
			tMttoSeleccionados = selectedTipoMtto.get(0);
			flagTipoMtto = 0L;
			for (int i = 1; i < selectedTipoMtto.size(); i++) {
				tMttoSeleccionados += "," + selectedTipoMtto.get(i);
			}
		}

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {
				List<ConsultaMttoDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "ConsultarMttos.xlsx";

				data = businessDelegatorView.consultarMttoMaquinaria(compania, fechaInicial, fechaFinal, pEquiposSeleccionados,
						flagPropietarioEquipo, equiposSeleccionados, flagEquipo, tMttoSeleccionados, flagTipoMtto);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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

						Cell columna1 = row.createCell(0);
						columna1.setCellValue("COMPAÑIA");
						columna1.setCellStyle(style2);

						Cell columna2 = row.createCell(1);
						columna2.setCellValue("FECHA ENTRADA TALLER");
						columna2.setCellStyle(style2);

						Cell columna3 = row.createCell(2);
						columna3.setCellValue("FECHA SALIDA TALLER");
						columna3.setCellStyle(style2);
						
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("CONSECUTIVO");
						columna4.setCellStyle(style2);
						
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("CODIGO EQUIPO");
						columna5.setCellStyle(style2);

						Cell columna6 = row.createCell(5);
						columna6.setCellValue("NOMBRE EQUIPO");
						columna6.setCellStyle(style2);

						Cell columna7 = row.createCell(6);
						columna7.setCellValue("CENTRO DE COSTO");
						columna7.setCellStyle(style2);
						
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("TALLER MECANICO");
						columna8.setCellStyle(style2);
						
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("HOROMETRO");
						columna9.setCellStyle(style2);

						Cell columna10 = row.createCell(9);
						columna10.setCellValue("ODOMETRO");
						columna10.setCellStyle(style2);

						Cell columna11 = row.createCell(10);
						columna11.setCellValue("TIPO DE MATENIMIENTO");
						columna11.setCellStyle(style2);
						
						Cell columna12 = row.createCell(11);
						columna12.setCellValue("PLAN DE REVISIÓN");
						columna12.setCellStyle(style2);
						
						Cell columna13 = row.createCell(12);
						columna13.setCellValue("MOTIVO ENTRADA TALLER");
						columna13.setCellStyle(style2);

						Cell columna14 = row.createCell(13);
						columna14.setCellValue("CAUSA DE PARADA");
						columna14.setCellStyle(style2);

						Cell columna15 = row.createCell(14);
						columna15.setCellValue("DURACION PREVISTA");
						columna15.setCellStyle(style2);
						
						Cell columna16 = row.createCell(15);
						columna16.setCellValue("DURACION REAL");
						columna16.setCellStyle(style2);
						
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("CODIGO SOLICITANTE");
						columna17.setCellStyle(style2);

						Cell columna18 = row.createCell(17);
						columna18.setCellValue("NOMBRE SOLICITANTE");
						columna18.setCellStyle(style2);

						Cell columna19 = row.createCell(18);
						columna19.setCellValue("CODIGO CONDUCTOR");
						columna19.setCellStyle(style2);
						
						Cell columna20 = row.createCell(19);
						columna20.setCellValue("NOMBRE CONDUCTOR");
						columna20.setCellStyle(style2);
						
						Cell columna21 = row.createCell(20);
						columna21.setCellValue("REPORTE TECNICO");
						columna21.setCellStyle(style2);

						Cell columna22 = row.createCell(21);
						columna22.setCellValue("FECHA DE TRABAJO MECANICO");
						columna22.setCellStyle(style2);

						Cell columna23 = row.createCell(22);
						columna23.setCellValue("MECANICO");
						columna23.setCellStyle(style2);
						
						Cell columna24 = row.createCell(23);
						columna24.setCellValue("CONCEPTO DE NOMINA");
						columna24.setCellStyle(style2);
						
						Cell columna25 = row.createCell(24);
						columna25.setCellValue("UNIDAD DE MEDIDA");
						columna25.setCellStyle(style2);

						Cell columna26 = row.createCell(25);
						columna26.setCellValue("CANTIDAD MECANICO");
						columna26.setCellStyle(style2);

						Cell columna27 = row.createCell(26);
						columna27.setCellValue("TARIFA MECANICO");
						columna27.setCellStyle(style2);
						
						Cell columna28 = row.createCell(27);
						columna28.setCellValue("COSTO TOTAL MECANICO");
						columna28.setCellStyle(style2);
						
						Cell columna29 = row.createCell(28);
						columna29.setCellValue("SALIDA ALMACEN");
						columna29.setCellStyle(style2);

						Cell columna30 = row.createCell(29);
						columna30.setCellValue("AUTORIZA");
						columna30.setCellStyle(style2);

						Cell columna31 = row.createCell(30);
						columna31.setCellValue("PRODUCTO");
						columna31.setCellStyle(style2);
						
						Cell columna32 = row.createCell(31);
						columna32.setCellValue("UNIDAD M. PRODUCTO");
						columna32.setCellStyle(style2);
						
						Cell columna33 = row.createCell(32);
						columna33.setCellValue("CANTIDAD");
						columna33.setCellStyle(style2);

						Cell columna34 = row.createCell(33);
						columna34.setCellValue("VALOR UNITARIO");
						columna34.setCellStyle(style2);

						Cell columna35 = row.createCell(34);
						columna35.setCellValue("COSTO TOTAL");
						columna35.setCellStyle(style2);
						
						Cell columna36 = row.createCell(35);
						columna36.setCellValue("MANTENIMIENTO EQUIPO ID");
						columna36.setCellStyle(style2);
						
						Cell columna37 = row.createCell(36);
						columna37.setCellValue("CODIGO TAG");
						columna37.setCellStyle(style2);

						Cell columna38 = row.createCell(37);
						columna38.setCellValue("NOMBRE TAG");
						columna38.setCellStyle(style2);

						Cell columna39 = row.createCell(38);
						columna39.setCellValue("TAREA");
						columna39.setCellStyle(style2);
						
						Cell columna40 = row.createCell(39);
						columna40.setCellValue("AÑO");
						columna40.setCellStyle(style2);
						
						Cell columna41 = row.createCell(40);
						columna41.setCellValue("MES");
						columna41.setCellStyle(style2);
						
						Cell columna42 = row.createCell(41);
						columna42.setCellValue("CODIGO SISTEMA");
						columna42.setCellStyle(style2);
						
						Cell columna43 = row.createCell(42);
						columna43.setCellValue("NOMBRE SISTEMA");
						columna43.setCellStyle(style2);
						
						Cell columna44 = row.createCell(43);
						columna44.setCellValue("CODIGO COMPARTIMIENTO");
						columna44.setCellStyle(style2);
						
						Cell columna45 = row.createCell(44);
						columna45.setCellValue("NOMBRE COMPARTIMIENTO");
						columna45.setCellStyle(style2);

						int pos_i = 5;

						for (ConsultaMttoDTO consultaMttoDTO : data) {

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

							cell1.setCellValue(consultaMttoDTO.getNombreCompania());
							cell2.setCellValue(consultaMttoDTO.getFechaRegistro());
							cell3.setCellValue(consultaMttoDTO.getFechaRegistro2());
							cell4.setCellValue(consultaMttoDTO.getConsecutivo().doubleValue());
							cell5.setCellValue(consultaMttoDTO.getCodEquipo());
							cell6.setCellValue(consultaMttoDTO.getNomEquipo());
							cell7.setCellValue(consultaMttoDTO.getCenCosto());
							cell8.setCellValue(consultaMttoDTO.getTallerMecanico());
							cell9.setCellValue(consultaMttoDTO.getHorometroE().doubleValue());
							cell10.setCellValue(consultaMttoDTO.getOdometroE().doubleValue());
							cell11.setCellValue(consultaMttoDTO.getNomTipoMtto());
							cell12.setCellValue(consultaMttoDTO.getNomPlanRevision());
							cell13.setCellValue(consultaMttoDTO.getNomMotivoEntradaTaller());
							cell14.setCellValue(consultaMttoDTO.getNomAgenteCausadorParadas());
							cell15.setCellValue(consultaMttoDTO.getDuracionPrevista());
							cell16.setCellValue(consultaMttoDTO.getDuracionReal().doubleValue());
							cell17.setCellValue(consultaMttoDTO.getCodSolicitante());
							cell18.setCellValue(consultaMttoDTO.getNomSolicitante());
							cell19.setCellValue(consultaMttoDTO.getCodConductor());
							cell20.setCellValue(consultaMttoDTO.getNomConductor());
							cell21.setCellValue(consultaMttoDTO.getReporteTecnico());
							cell22.setCellValue(consultaMttoDTO.getFechaTrabajoMec());
							cell23.setCellValue(consultaMttoDTO.getMecanico());
							cell24.setCellValue(consultaMttoDTO.getNomCeptoNomina());
							cell25.setCellValue(consultaMttoDTO.getNomUdadMed());
							cell26.setCellValue(consultaMttoDTO.getCantidadMec().doubleValue());
							cell27.setCellValue(consultaMttoDTO.getTarifaMec().doubleValue());
							cell28.setCellValue(consultaMttoDTO.getCostoTotalMec().doubleValue());
							cell29.setCellValue(consultaMttoDTO.getAlmacenSalida());
							cell30.setCellValue(consultaMttoDTO.getAutoriza());
							cell31.setCellValue(consultaMttoDTO.getProducto());
							cell32.setCellValue(consultaMttoDTO.getUmProducto());
							cell33.setCellValue(consultaMttoDTO.getCantidad().doubleValue());
							cell34.setCellValue(consultaMttoDTO.getValorUnitario().doubleValue());
							cell35.setCellValue(consultaMttoDTO.getCostoTotal().doubleValue());
							cell36.setCellValue(consultaMttoDTO.getDatMantenimientoEquipo().doubleValue());
							cell37.setCellValue(consultaMttoDTO.getCodTag());
							cell38.setCellValue(consultaMttoDTO.getNomTag());
							cell39.setCellValue(consultaMttoDTO.getTarea());
							cell40.setCellValue(consultaMttoDTO.getAnio());
							cell41.setCellValue(consultaMttoDTO.getMesCorto());
							cell42.setCellValue(consultaMttoDTO.getCodSistemaEquipo());
							cell43.setCellValue(consultaMttoDTO.getNomSistemaEquipo());
							cell44.setCellValue(consultaMttoDTO.getCodCompartimientoEquipo());
							cell45.setCellValue(consultaMttoDTO.getNomCompartimientoEquipo());
														

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "ConsultarMttos.xlsx");

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

	public List<ConsultaMttoDTO> getData() {
		try {
			Long compania = FacesUtils.checkLong(txtCompania);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Long flagEquipo = 1L;
			Long flagPropietarioEquipo = 1L;
			Long flagTipoMtto = 1L;

			String equiposSeleccionados = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionados = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionados += "," + selectedEquipo.get(i);
				}
			}

			String pEquiposSeleccionados = "";
			if (selectedPropietarioEquipo != null && selectedPropietarioEquipo.size() > 0) {
				pEquiposSeleccionados = selectedPropietarioEquipo.get(0);
				flagPropietarioEquipo = 0L;
				for (int i = 1; i < selectedPropietarioEquipo.size(); i++) {
					pEquiposSeleccionados += "," + selectedPropietarioEquipo.get(i);
				}
			}

			String tMttoSeleccionados = "";
			if (selectedTipoMtto != null && selectedTipoMtto.size() > 0) {
				tMttoSeleccionados = selectedTipoMtto.get(0);
				flagTipoMtto = 0L;
				for (int i = 1; i < selectedTipoMtto.size(); i++) {
					tMttoSeleccionados += "," + selectedTipoMtto.get(i);
				}
			}

			if (compania != null) {

				data = businessDelegatorView.consultarMttoMaquinaria(compania, fechaInicial, fechaFinal, equiposSeleccionados, flagEquipo,
						pEquiposSeleccionados, flagPropietarioEquipo, tMttoSeleccionados, flagTipoMtto);

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
	
	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}
	
	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipo() {
		if (equipo == null || equipo.size() == 0) {

			equipo = new ArrayList<Equipo>();

			try {
				equipo = businessDelegatorView.getEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	
	}
		public List<String> getSelectedPropietarioEquipo() {
		return selectedPropietarioEquipo;
	}

	public void setSelectedPropietarioEquipo(List<String> selectedPropietarioEquipo) {
		this.selectedPropietarioEquipo = selectedPropietarioEquipo;
	}

	public List<PersEmpr> getPropietarioEquipo() {

		if (propietarioEquipo == null || propietarioEquipo.size() == 0) {

			propietarioEquipo = new ArrayList<PersEmpr>();

			try {
				propietarioEquipo = businessDelegatorView.getPersEmpr();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return propietarioEquipo;
	}

	public void setPropietarioEquipo(List<PersEmpr> propietarioEquipo) {
		this.propietarioEquipo = propietarioEquipo;
	
	}
		public List<String> getSelectedTipoMtto() {
		return selectedTipoMtto;
	}

	public void setSelectedTipoMtto(List<String> selectedTipoMtto) {
		this.selectedTipoMtto = selectedTipoMtto;
	}

	public List<TipoMantenimiento> getTipoMtto() {
		if (tipoMtto == null || tipoMtto.size() == 0) {

			tipoMtto = new ArrayList<TipoMantenimiento>();

			try {
				tipoMtto = businessDelegatorView.getTipoMantenimiento();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return tipoMtto;
	}

	public void setTipoMtto(List<TipoMantenimiento> tipoMtto) {
		this.tipoMtto = tipoMtto;
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

	public StreamedContent getFile() {

		return file;
	}

	public void setFile(StreamedContent file) {

		if (file != null) {
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

}
