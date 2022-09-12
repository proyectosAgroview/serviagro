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
import org.primefaces.component.inputnumber.InputNumber;
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

import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
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
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosTercerosDTO;
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
public class InformeSRConsultaIngresosEgresosCentCosto implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeSRConsultaIngresosEgresosCentCosto.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<CostosIndirectosEquipoDTO> data;

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

	private List<String> selectedEtapaId;
	private List<Etapa> etapas;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";
	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	public InformeSRConsultaIngresosEgresosCentCosto() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}
	private InputText txtDocumento;
	private InputNumber txtValorTotal;
	
	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;
	
	
	
	public void consultFacturaIngresosTerceros() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long flagLabor = 1L;
		Long flagEquipo = 1L;
		
		String laboresSeleccionadas = "";
		if (selectedLabor != null && selectedLabor.size() > 0) {
			laboresSeleccionadas = selectedLabor.get(0);
			flagLabor = 0L;
			for (int i = 1; i < selectedLabor.size(); i++) {
				laboresSeleccionadas += "," + selectedLabor.get(i);
			}
		}
		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}


		Long documento = 0L;
		documento = FacesUtils.checkLong(txtDocumento);
		if(documento ==null) {
			documento = 0L;
		}
		
		Long centCost = 0L;
		centCost = FacesUtils.checkLong(txtCentCostConsulta);

		if (centCost == null) {
			centCost = 0L;
		}
	

		if (compania != null & fechaInicial !=null  & fechaFinal !=null) {
			try {

				List<FacturaServiciosConsolidadosTercerosDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoFacturacionTerceros.xlsx";

				data = businessDelegator2View.pr_listar_factura_servicios_terceros(compania, fechaInicial, fechaFinal,
						documento , centCost);
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);

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

					if (data != null) {

						cell = row.createCell(0);
						cell.setCellValue("FECHA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(1);
						cell.setCellValue("DOCUMENTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(2);
						cell.setCellValue("PROVEEDOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(3);
						cell.setCellValue("CLIENTE");
						cell.setCellStyle(style2);
						
						cell = row.createCell(4);
						cell.setCellValue("DETALLE SERVICIO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(5);
						cell.setCellValue("VR. TOTAL");
						cell.setCellStyle(style2);
						
						cell = row.createCell(6);
						cell.setCellValue("CENTRO DE COSTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(7);
						cell.setCellValue("AÑO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(8);
						cell.setCellValue("AÑO-MES");
						cell.setCellStyle(style2);
						
						cell = row.createCell(9);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						
						cell = row.createCell(10);
						cell.setCellValue("MES TEXTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(11);
						cell.setCellValue("PERIODO");
						cell.setCellStyle(style2);
						
						
						
						int pos_i = 8;

						for (FacturaServiciosConsolidadosTercerosDTO ndDTO : data) {
							
							if(ndDTO.getTipoOperacion().equals("Ingreso")) {
							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue(
									ndDTO.getFecha_registro().toString().substring(8, 10)+"/"+
									ndDTO.getFecha_registro().toString().substring(5, 7)+"/"+
									ndDTO.getFecha_registro().toString().substring(0, 4));
							
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getConsecutivo().longValue());

							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getNomProveedor());

							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNom_cliente());

							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getDetalle_factura());

							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getValor_factura().doubleValue());

							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomCentroCosto());

							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getAnio().longValue());
							
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getAnio_mes());


							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getMes().longValue());

							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getMesTexto());

							cell = row.createCell(11);
							cell.setCellValue(sdf.format(fechaInicial)+"-"+sdf.format(fechaFinal));

							
							
							pos_i++;
							}

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoFacturacionTerceros.xlsx");

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
	
	
	
	public void consulIngresosEgresosTerceros() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long flagLabor = 1L;
		Long flagEquipo = 1L;
		
		String laboresSeleccionadas = "";
		if (selectedLabor != null && selectedLabor.size() > 0) {
			laboresSeleccionadas = selectedLabor.get(0);
			flagLabor = 0L;
			for (int i = 1; i < selectedLabor.size(); i++) {
				laboresSeleccionadas += "," + selectedLabor.get(i);
			}
		}
		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}


		Long documento = 0L;
		documento = FacesUtils.checkLong(txtDocumento);
		if(documento ==null) {
			documento = 0L;
		}
		
		Long centCost = 0L;
		centCost = FacesUtils.checkLong(txtCentCostConsulta);

		if (centCost == null) {
			centCost = 0L;
		}
	

		if (compania != null & fechaInicial !=null  & fechaFinal !=null) {
			try {

				List<FacturaServiciosConsolidadosTercerosDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoIngresosEgresosTerceros.xlsx";

				data = businessDelegator2View.pr_ingresos_egresos_terceros(compania, fechaInicial, fechaFinal,
						documento , centCost);
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);

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
					
					CellStyle style5 = book.createCellStyle();
					style5.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style5.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style5.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style5.setBorderRight((CellStyle.BORDER_MEDIUM));
					style5.setBorderTop((CellStyle.BORDER_MEDIUM));
					style5.setBorderBottom((CellStyle.BORDER_MEDIUM));

					XSSFCellStyle dollarStyle2 = book.createCellStyle();
					DataFormat df3 = book.createDataFormat();
					style5.setDataFormat(df3.getFormat("dd/MM/yyyy"));

					if (data != null) {

						cell = row.createCell(0);
						cell.setCellValue("FECHA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(1);
						cell.setCellValue("DOCUMENTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(2);
						cell.setCellValue("PROVEEDOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(3);
						cell.setCellValue("CLIENTE");
						cell.setCellStyle(style2);
						
						cell = row.createCell(4);
						cell.setCellValue("DETALLE SERVICIO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(5);
						cell.setCellValue("VR. TOTAL INGRESOS");
						cell.setCellStyle(style2);
						
						cell = row.createCell(6);
						cell.setCellValue("CENTRO DE COSTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(7);
						cell.setCellValue("AÑO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(8);
						cell.setCellValue("AÑO-MES");
						cell.setCellStyle(style2);
						
						cell = row.createCell(9);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						
						cell = row.createCell(10);
						cell.setCellValue("MES TEXTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(11);
						cell.setCellValue("PERIODO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(12);
						cell.setCellValue("CONCEPTO GASTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(13);
						cell.setCellValue("UM GASTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(14);
						cell.setCellValue("TIPO MOVIMIENTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(15);
						cell.setCellValue("VR. EGRESOS");
						cell.setCellStyle(style2);
						
						cell = row.createCell(16);
						cell.setCellValue("CANTIDAD PRODUCTO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(17);
						cell.setCellValue("NUMERO FACTURA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(18);
						cell.setCellValue("OBSERVACION");
						cell.setCellStyle(style2);
						
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD LABOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(20);
						cell.setCellValue("HORAS MAQUINA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(21);
						cell.setCellValue("MAQUINA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(22);
						cell.setCellValue("CATEGORIA MAQUINA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(23);
						cell.setCellValue("MODELO MAQUINA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(24);
						cell.setCellValue("TIPO PRODUCTO");
						cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (FacturaServiciosConsolidadosTercerosDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue(
									ndDTO.getFecha_registro() );
							cell.setCellStyle(style5);
							
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getConsecutivo().longValue());

							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getNomProveedor());

							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNom_cliente());

							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getDetalle_factura());

							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getValor_factura().doubleValue());

							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomCentroCosto());

							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getAnio().longValue());
							
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getAnio_mes());


							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getMes().longValue());

							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getMesTexto());

							cell = row.createCell(11);
							cell.setCellValue(sdf.format(fechaInicial)+"-"+sdf.format(fechaFinal));

							
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getNomLabor());

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getCodUdadMed());

							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getOrigenDatos());

							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getValorEgresos().doubleValue());

							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getCantidad().doubleValue());

							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getNum_factura());


							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getObservacion());

							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantidadLabor().doubleValue());

							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getHorasTrabajadas().doubleValue());

							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getCodigoEquipo());

							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCategoriaEquipo());

							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getModeloEquipo());

							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getTipoProducto());

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoIngresosEgresosTerceros.xlsx");

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



	public List<CostosIndirectosEquipoDTO> getData() {
		return data;
	}

	public void setData(List<CostosIndirectosEquipoDTO> data) {
		this.data = data;
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

	public List<String> getSelectedEtapaId() {
		return selectedEtapaId;
	}

	public void setSelectedEtapaId(List<String> selectedEtapaId) {
		this.selectedEtapaId = selectedEtapaId;
	}

	public List<Etapa> getEtapa() {
		if (etapas == null || etapas.size() == 0) {

			try {
				etapas = businessDelegatorView.getEtapa();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return etapas;
	}

	public void setEtapa(List<Etapa> etapas) {
		this.etapas = etapas;
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

	public List<String> getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(List<String> selectedTrabajador) {
		this.selectedTrabajador = selectedTrabajador;
	}

	public List<Trabajador> getTrabajadores() {

		if (trabajador == null || trabajador.size() == 0) {

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


	public List<String> getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(List<String> selectedLabor) {
		this.selectedLabor = selectedLabor;
	}

	public List<Labor> getLabores() {
		if (labores == null || labores.size() == 0) {

			

			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion", "=" };
				labores = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
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

	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public List<PersEmpr> getContratistas() {
		if (contratistas == null || contratistas.size() == 0) {


			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="};
				contratistas = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
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

	public InputNumber getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(InputNumber txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	
	

	public InputText getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(InputText txtDocumento) {
		this.txtDocumento = txtDocumento;
	}
	
	
	
	 

	public SelectOneMenu getTxtCentCostConsulta() {
		return txtCentCostConsulta;
	}

	 
	public void setTxtCentCostConsulta(SelectOneMenu txtCentCostConsulta) {
		this.txtCentCostConsulta = txtCentCostConsulta;
	}

	public void setSelectCentCostConsulta(SelectItem[] selectCentCostConsulta) {
		this.selectCentCostConsulta = selectCentCostConsulta;
	}
	public SelectItem[] getSelectCentCostConsulta() {

		if (selectCentCostConsulta == null || selectCentCostConsulta.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCostConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCostConsulta[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCostConsulta;
	}
}
