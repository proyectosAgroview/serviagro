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

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.presentation.businessDelegate.BusinessDelegatorView;
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
public class InformeInventarioSRLMaqSaldoBodegasView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeInventarioSRLMaqSaldoBodegasView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsultaStockMaquinariaDTO> data;

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

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedEtapaId;
	private List<Etapa> etapas;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "true";

	private List<String> selectedProducto;
	private List<Producto> productos;

	private String visible = "hidden";
	private InputText txtDocumento;

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;

	private List<String> selectedTipoProducto;
	private List<TipoProducto> tipoProductos;

	private List<String> selectedAlmacen;
	private List<Almacen> almacenes;

	private List<String> selectedConceptoKardex;
	private List<ConceptoKardex> conceptoKardexs;
	private InputText txtDocumentoKardex;

	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;
	private List<ConceptoKardex> conceptoKardex;

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	public InformeInventarioSRLMaqSaldoBodegasView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public void exportToPyGExcel() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		// fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// String f1 = txtFechaInicial.getValue().toString();

		// GregorianCalendar calendario1 = new GregorianCalendar();
		// calendario1.setTime(fechaInicial);
		// Date d1 = calendario1.getTime();
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		// GregorianCalendar calendario2 = new GregorianCalendar();
		// calendario2.setTime(fechaFinal);
		// Date d2 = calendario2.getTime();

		// String zona = "1";

		String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen);
		Long compania = new Long(getCompaniaIdSession());

		Long flagContratista = 1L;
		Long flagProducto = 1L;
		Long flagConceptoKardex = 1L;
		Long flagAlmacen = 1L;

		// Long compania = new Long(getCompaniaIdSession());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		// Date fechaInicial = null;
		// Date fechaFinal = null;
		// fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Long flagEquipo = 1L;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();
		Long flagTipoProducto = 1L;

		String almacenesSeleccionadas = "";
		if (selectedAlmacen != null && selectedAlmacen.size() > 0) {
			almacenesSeleccionadas = selectedAlmacen.get(0);
			flagAlmacen = 0L;
			for (int i = 1; i < selectedAlmacen.size(); i++) {
				almacenesSeleccionadas += "," + selectedAlmacen.get(i);
			}
		}

		String tiposProductoSeleccionadas = "";
		if (selectedTipoProducto != null && selectedTipoProducto.size() > 0) {
			tiposProductoSeleccionadas = selectedTipoProducto.get(0);
			flagTipoProducto = 0L;
			for (int i = 1; i < selectedTipoProducto.size(); i++) {
				tiposProductoSeleccionadas += "," + selectedTipoProducto.get(i);
			}
		}
		if (compania != null) {
			try {
				List<ConsultaStockMaquinariaDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoInventarioSaldoBodega.xlsx";

				data = businessDelegator2View.pr_inventario_saldo_bodega(compania, fechaFinalDateRegistro, fechaFinal,
						almacenId, 0L, tiposProductoSeleccionadas, flagTipoProducto);

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
						Cell columna1 = row.createCell(0);
						columna1.setCellValue("FECHA ENTRADA");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("FECHA SALIDA");
						columna2.setCellStyle(style2);

						Cell columna3 = row.createCell(2);
						columna3.setCellValue("COD. TIPO PRODUCTO");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("TIPO PRODUCTO");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("COD. PRODUCTO");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("PRODUCTO");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("CANT_ENTRADA");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("CANT_SALIDA");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("SALDO");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("VALOR_UNITARIO");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("COSTO_TOTAL");
						columna11.setCellStyle(style2);

						Cell columna12 = row.createCell(11);
						columna12.setCellValue("UM PRODUCTO");
						columna12.setCellStyle(style2);

						Cell columna13 = row.createCell(12);
						columna13.setCellValue("COD. ALMACEN");
						columna13.setCellStyle(style2);

						Cell columna14 = row.createCell(13);
						columna14.setCellValue("ALMACEN");
						columna14.setCellStyle(style2);

						Cell columna15 = row.createCell(14);
						columna15.setCellValue("REFERENCIA");
						columna15.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaStockMaquinariaDTO costosTotalesDTO : data) {

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

							if (costosTotalesDTO.getFechaEntrada().equals("")) {
								cell1.setCellValue("");
								cell1.setCellStyle(style);
							} else {
								cell1.setCellValue(costosTotalesDTO.getFechaEntrada().toString().substring(8, 10) + "/"
										+ costosTotalesDTO.getFechaEntrada().toString().substring(5, 7) + "/"
										+ costosTotalesDTO.getFechaEntrada().toString().substring(0, 4));
								cell1.setCellStyle(style);
							}

							if (costosTotalesDTO.getFechaSalida().equals("")) {
								cell2.setCellValue("");
								cell2.setCellStyle(style);
							} else {
								cell2.setCellValue(costosTotalesDTO.getFechaSalida().toString().substring(8, 10) + "/"
										+ costosTotalesDTO.getFechaSalida().toString().substring(5, 7) + "/"
										+ costosTotalesDTO.getFechaSalida().toString().substring(0, 4));
								cell2.setCellStyle(style);
							}

							cell3.setCellValue(costosTotalesDTO.getCodProducto());
							cell3.setCellStyle(style);
							cell4.setCellValue(costosTotalesDTO.getNomTipoProducto());
							cell4.setCellStyle(style);
							cell5.setCellValue(costosTotalesDTO.getCodProducto());
							cell5.setCellStyle(style);
							cell6.setCellValue(costosTotalesDTO.getNomProducto());
							cell6.setCellStyle(style);

							cell7.setCellValue(costosTotalesDTO.getCantidadIngresada().doubleValue());
							cell7.setCellStyle(style);
							cell8.setCellValue(costosTotalesDTO.getCantidadSalida().doubleValue());
							cell8.setCellStyle(style);

							cell9.setCellValue(costosTotalesDTO.getCantidadDisponible().doubleValue());
							cell9.setCellStyle(style);
							cell10.setCellValue(costosTotalesDTO.getV_unitario().doubleValue());
							cell10.setCellStyle(style);
							cell11.setCellValue(costosTotalesDTO.getCosto_total().doubleValue());
							cell11.setCellStyle(style);
							cell12.setCellValue(costosTotalesDTO.getNombreUdadMed());
							cell12.setCellStyle(style);
							cell13.setCellValue(costosTotalesDTO.getCodAlmacen());
							cell13.setCellStyle(style);
							cell14.setCellValue(costosTotalesDTO.getAlmacen());
							cell14.setCellStyle(style);
							cell15.setCellValue(costosTotalesDTO.getReferencia());
							cell15.setCellStyle(style);

							pos_i++;

						}

						// int numFilas = data.size() + 1;

						// for (int i = 0; i < numFilas; i++) {
						// sheet.autoSizeColumn(i);
						// }

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoInventarioSaldoBodega.xlsx");

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

	public void rotacionProducto() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		// fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// String f1 = txtFechaInicial.getValue().toString();

		// GregorianCalendar calendario1 = new GregorianCalendar();
		// calendario1.setTime(fechaInicial);
		// Date d1 = calendario1.getTime();
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		// GregorianCalendar calendario2 = new GregorianCalendar();
		// calendario2.setTime(fechaFinal);
		// Date d2 = calendario2.getTime();

		// String zona = "1";

		String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen);
		Long compania = new Long(getCompaniaIdSession());

		Long flagContratista = 1L;
		Long flagProducto = 1L;
		Long flagConceptoKardex = 1L;
		Long flagAlmacen = 1L;
		Long flagTipoProducto = 1L;
		// Long compania = new Long(getCompaniaIdSession());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		// Date fechaInicial = null;
		// Date fechaFinal = null;
		// fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Long flagEquipo = 1L;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();

		String almacenesSeleccionadas = "";
		if (selectedAlmacen != null && selectedAlmacen.size() > 0) {
			almacenesSeleccionadas = selectedAlmacen.get(0);
			flagAlmacen = 0L;
			for (int i = 1; i < selectedAlmacen.size(); i++) {
				almacenesSeleccionadas += "," + selectedAlmacen.get(i);
			}
		}
		String tiposProductoSeleccionadas = "";
		if (selectedTipoProducto != null && selectedTipoProducto.size() > 0) {
			tiposProductoSeleccionadas = selectedTipoProducto.get(0);
			flagTipoProducto = 0L;
			for (int i = 1; i < selectedTipoProducto.size(); i++) {
				tiposProductoSeleccionadas += "," + selectedTipoProducto.get(i);
			}
		}

		if (compania != null) {
			try {
				List<ConsultaStockMaquinariaDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoInventarioRotacionProducto.xlsx";

				data = businessDelegator2View.pr_inventario_saldo_bodega(compania, fechaFinalDateRegistro, fechaFinal,
						almacenId, 0L, tiposProductoSeleccionadas, flagTipoProducto);

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
						Cell columna1 = row.createCell(0);
						columna1.setCellValue("FECHA ENTRADA");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("FECHA SALIDA");
						columna2.setCellStyle(style2);

						Cell columna3 = row.createCell(2);
						columna3.setCellValue("COD. TIPO PRODUCTO");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("TIPO PRODUCTO");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("COD. PRODUCTO");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("PRODUCTO");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("CANT_ENTRADA");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("CANT_SALIDA");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("SALDO");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("VALOR_UNITARIO");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("COSTO_TOTAL");
						columna11.setCellStyle(style2);

						Cell columna12 = row.createCell(11);
						columna12.setCellValue("UM PRODUCTO");
						columna12.setCellStyle(style2);

						Cell columna13 = row.createCell(12);
						columna13.setCellValue("COD. ALMACEN");
						columna13.setCellStyle(style2);

						Cell columna14 = row.createCell(13);
						columna14.setCellValue("ALMACEN");
						columna14.setCellStyle(style2);

						Cell columna15 = row.createCell(14);
						columna15.setCellValue("REFERENCIA");
						columna15.setCellStyle(style2);

						Cell columna16 = row.createCell(15);
						columna16.setCellValue("NDIAS CONSUMO PRODUCTO");
						columna16.setCellStyle(style2);

						Cell columna17 = row.createCell(16);
						columna17.setCellValue("NDIAS ULT. COMPRA PRODUCTO");
						columna17.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaStockMaquinariaDTO costosTotalesDTO : data) {

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

							if (costosTotalesDTO.getFechaEntrada().equals("")) {
								cell1.setCellValue("");
								cell1.setCellStyle(style);
							} else {
								cell1.setCellValue(costosTotalesDTO.getFechaEntrada().toString().substring(8, 10) + "/"
										+ costosTotalesDTO.getFechaEntrada().toString().substring(5, 7) + "/"
										+ costosTotalesDTO.getFechaEntrada().toString().substring(0, 4));
								cell1.setCellStyle(style);
							}

							if (costosTotalesDTO.getFechaSalida().equals("")) {
								cell2.setCellValue("");
								cell2.setCellStyle(style);
							} else {
								cell2.setCellValue(costosTotalesDTO.getFechaSalida().toString().substring(8, 10) + "/"
										+ costosTotalesDTO.getFechaSalida().toString().substring(5, 7) + "/"
										+ costosTotalesDTO.getFechaSalida().toString().substring(0, 4));
								cell2.setCellStyle(style);
							}

							cell3.setCellValue(costosTotalesDTO.getCodProducto());
							cell3.setCellStyle(style);
							cell4.setCellValue(costosTotalesDTO.getNomTipoProducto());
							cell4.setCellStyle(style);
							cell5.setCellValue(costosTotalesDTO.getCodProducto());
							cell5.setCellStyle(style);
							cell6.setCellValue(costosTotalesDTO.getNomProducto());
							cell6.setCellStyle(style);

							cell7.setCellValue(costosTotalesDTO.getCantidadIngresada().doubleValue());
							cell7.setCellStyle(style);
							cell8.setCellValue(costosTotalesDTO.getCantidadSalida().doubleValue());
							cell8.setCellStyle(style);

							cell9.setCellValue(costosTotalesDTO.getCantidadDisponible().doubleValue());
							cell9.setCellStyle(style);
							cell10.setCellValue(costosTotalesDTO.getV_unitario().doubleValue());
							cell10.setCellStyle(style);
							cell11.setCellValue(costosTotalesDTO.getCosto_total().doubleValue());
							cell11.setCellStyle(style);
							cell12.setCellValue(costosTotalesDTO.getNombreUdadMed());
							cell12.setCellStyle(style);
							cell13.setCellValue(costosTotalesDTO.getCodAlmacen());
							cell13.setCellStyle(style);
							cell14.setCellValue(costosTotalesDTO.getAlmacen());
							cell14.setCellStyle(style);
							cell15.setCellValue(costosTotalesDTO.getReferencia());
							cell15.setCellStyle(style);
							cell16.setCellValue(costosTotalesDTO.getNdias_para_consumir_producto().doubleValue());
							cell16.setCellStyle(style);
							cell17.setCellValue(costosTotalesDTO.getNdias_ultima_compra_producto().doubleValue());
							cell17.setCellStyle(style);

							pos_i++;

						}

						// int numFilas = data.size() + 1;

						// for (int i = 0; i < numFilas; i++) {
						// sheet.autoSizeColumn(i);
						// }

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

						file = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoInventarioRotacionProducto.xlsx");

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

	public List<ConsultaStockMaquinariaDTO> getData() {
		return data;
	}

	public void setData(List<ConsultaStockMaquinariaDTO> data) {
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

	public List<String> getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(List<String> selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public List<Producto> getProductos() {
		if (productos == null || productos.size() == 0) {

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

	public InputText getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(InputText txtDocumento) {
		this.txtDocumento = txtDocumento;
	}

	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public List<PersEmpr> getContratistas() throws Exception {
		if (contratistas == null || contratistas.size() == 0) {

			Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "=" };

			try {
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

	public List<String> getSelectedAlmacen() {
		return selectedAlmacen;
	}

	public void setSelectedAlmacen(List<String> selectedAlmacen) {
		this.selectedAlmacen = selectedAlmacen;
	}

	public List<Almacen> getAlmacenes() {
		if (almacenes == null || almacenes.size() == 0) {

			try {
				almacenes = businessDelegatorView.getAlmacen();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return almacenes;
	}

	public void setAlmacenes(List<Almacen> almacenes) {
		this.almacenes = almacenes;
	}

	public List<String> getSelectedConceptoKardex() {
		return selectedConceptoKardex;
	}

	public void setSelectedConceptoKardex(List<String> selectedConceptoKardex) {
		this.selectedConceptoKardex = selectedConceptoKardex;
	}

	public List<ConceptoKardex> getConceptoKardexs() {
		if (conceptoKardexs == null || conceptoKardexs.size() == 0) {

			try {
				conceptoKardexs = businessDelegator2View.getConceptoKardex();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return conceptoKardexs;
	}

	public void setConceptoKardexs(List<ConceptoKardex> conceptoKardexs) {
		this.conceptoKardexs = conceptoKardexs;
	}

	public InputText getTxtDocumentoKardex() {
		return txtDocumentoKardex;
	}

	public void setTxtDocumentoKardex(InputText txtDocumentoKardex) {
		this.txtDocumentoKardex = txtDocumentoKardex;
	}

	public SelectItem[] getSelectConceptoKardex() {

		if (conceptoKardex == null || conceptoKardex.size() == 0) {

			try {
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectConceptoKardex[i] = new SelectItem(conceptoKardex.getConceptoKardexId(),
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex;
	}

	public void setSelectConceptoKardex(SelectItem[] selectConceptoKardex) {
		this.selectConceptoKardex = selectConceptoKardex;
	}

	public SelectOneMenu getTxtConceptoKardex() {
		return txtConceptoKardex;
	}

	public void setTxtConceptoKardex(SelectOneMenu txtConceptoKardex) {
		this.txtConceptoKardex = txtConceptoKardex;
	}

	public SelectItem[] getSelectAlmacen() {

		if (almacen == null || almacen.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(),
							almacen.getCodigo() + " - " + almacen.getCodigo() + "-" + almacen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	public void setSelectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}

	public SelectItem[] getSelectTipoProducto() {

		if (tipoProducto == null || tipoProducto.size() == 0) {

			// tipoProducto = new ArrayList<TipoProducto>();

			try {

				// tipoProducto = businessDelegatorView.getTipoProducto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProducto = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto : lista) {
					selectTipoProducto[i] = new SelectItem(tipoProducto.getTipoProdId(),
							tipoProducto.getCodigo() + " - " + tipoProducto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProducto;
	}

	public void setSelectTipoProducto(SelectItem[] selectTipoProducto) {
		this.selectTipoProducto = selectTipoProducto;
	}

	public SelectItem[] getSelectProductoId() throws NumberFormatException, Exception {
		if (txtTipoProducto.getValue() != null) {
			//
			// if (productoId == null || productoId.size() == 0) {

			Long idCompania = new Long(getCompaniaIdSession());
			Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
			try {
				// List<CatalogProductoDTO> lista = null;
				List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania,
						tipoProducto);
				selectProductoId = new SelectItem[lista.size()];
				/*
				 * int i = 0; for (CatalogProductoDTO catalogProductoDTO : lista) {
				 * selectProductoId[i] = new
				 * SelectItem(catalogProductoDTO.getProductoId().longValue(),
				 * catalogProductoDTO.getCodigo()+"-"+ catalogProductoDTO.getNombre()
				 * 
				 * ); i++;
				 * 
				 * }
				 */

				for (int j = 0; j < lista.size(); j++) {
					selectProductoId[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
							lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoId;
	}

	public void setSelectProductoId(SelectItem[] selectProductoId) {
		this.selectProductoId = selectProductoId;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public SelectOneMenu getTxtTipoProducto() {
		return txtTipoProducto;
	}

	public void setTxtTipoProducto(SelectOneMenu txtTipoProducto) {
		this.txtTipoProducto = txtTipoProducto;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public List<String> getSelectedTipoProducto() {
		return selectedTipoProducto;
	}

	public void setSelectedTipoProducto(List<String> selectedTipoProducto) {
		this.selectedTipoProducto = selectedTipoProducto;
	}

	public List<TipoProducto> getTipoProductos() {
		if (tipoProductos == null || tipoProductos.size() == 0) {

			try {
				tipoProductos = businessDelegatorView.getTipoProducto();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return tipoProductos;
	}

	public void setTipoProductos(List<TipoProducto> tipoProductos) {
		this.tipoProductos = tipoProductos;
	}

	public void recalcular_precio_productos() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");

		Date fechaInicial = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		Date fechaFinal = null;
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();
		Long almacenId = FacesUtils.checkLong(txtAlmacenId_Almacen);
		Long flagAlmacen = 1L;
		Long flagTipoProducto = 1L;
		String almacenesSeleccionadas = "";
		if (selectedAlmacen != null && selectedAlmacen.size() > 0) {
			almacenesSeleccionadas = selectedAlmacen.get(0);
			flagAlmacen = 0L;
			for (int i = 1; i < selectedAlmacen.size(); i++) {
				almacenesSeleccionadas += "," + selectedAlmacen.get(i);
			}
		}
		String tiposProductoSeleccionadas = "";
		if (selectedTipoProducto != null && selectedTipoProducto.size() > 0) {
			tiposProductoSeleccionadas = selectedTipoProducto.get(0);
			flagTipoProducto = 0L;
			for (int i = 1; i < selectedTipoProducto.size(); i++) {
				tiposProductoSeleccionadas += "," + selectedTipoProducto.get(i);
			}
		}

		String fechaInicialFiltro = sdf2.format(fechaInicial);
		String fechaIFinalFiltro = sdf2.format(fechaFinal);

		GregorianCalendar calendarioInicial = new GregorianCalendar();
		calendarioInicial.setTime(FacesUtils.checkDate(txtFechaInicial));
		long anioRegistroInicial = calendarioInicial.get(java.util.Calendar.YEAR);
		long mesInicial = calendarioInicial.get(java.util.Calendar.MONTH) + 1;
		String anioMesInicial = anioRegistroInicial + "-" + mesInicial;

		GregorianCalendar calendarioFinal = new GregorianCalendar();
		calendarioFinal.setTime(FacesUtils.checkDate(txtFechaFinal));
		long anioRegistroFinal = calendarioFinal.get(java.util.Calendar.YEAR);
		long mesFinal = calendarioFinal.get(java.util.Calendar.MONTH) + 1;
		String anioMesFinal = anioRegistroFinal + "-" + mesFinal;

		if (anioMesInicial.equals(anioMesFinal)) {

			List<ConsultaStockMaquinariaDTO> data = null;
			data = businessDelegator2View.pr_inventario_recalculo_precio_entrada_producto(compania, fechaFinalDateRegistro, fechaFinal,
					almacenId, 0l);
			Long almacenproducto = null;
			Long productoId = null;
			Double valorUnitario = null;

			if (data != null) {
				for (ConsultaStockMaquinariaDTO datos1 : data) {
					almacenproducto = datos1.getIdAlmacen().longValue();
					productoId = datos1.getIdProducto().longValue();
					valorUnitario = datos1.getV_unitario().doubleValue();
					PrecioPromProd precioPromProd = null;
					DatMantenimientoEquipoProd datMantenimientoEquipoProd = null;
					
					Object[] condicion = { "almacenId.almacenId", true, almacenId, "=", "producto.productoId", true,
							productoId, "=", 
							"fechaInicial", true, fechaInicialFiltro, ">=",
							"fechaInicial", true, fechaIFinalFiltro, "<=", "tipoMovimiento", true, "ENT", "<>" };
					List<PrecioPromProd> lista = (productoId != null)
							? businessDelegatorView.findByCriteriaInPrecioPromProd(condicion, null, null)
							: null;

					if (lista != null && lista.size() > 0) {
						for (int a = 0; a < lista.size(); a++) {
							precioPromProd = lista.get(a);
							Double cantidad = precioPromProd.getCantidadCompra();
							Double costoTotal = (double) Math.round((cantidad * valorUnitario) * 1000) / 1000;

							precioPromProd.setValorUnitario(valorUnitario);
							precioPromProd.setCostoTotal(costoTotal);
							businessDelegatorView.updatePrecioPromProd(precioPromProd);
						}
						
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Suministros: Los precios de las salidas de productos fueron re-calculados exitosamente.  ", ""));
					}
					

					Object[] condicionMtto = { "almacenId.almacenId", true, almacenId, "=", "producto.productoId", true,
							productoId, "=", 
							"fechaRegistro", true, fechaInicialFiltro, ">=",
							"fechaRegistro", true, fechaIFinalFiltro, "<="};
					List<DatMantenimientoEquipoProd> listaMtto = (productoId != null)
							? businessDelegatorView.findByCriteriaInDatMantenimientoEquipoProd(condicionMtto, null, null)
							: null;

					if (listaMtto != null && listaMtto.size() > 0) {
						for (int a = 0; a < listaMtto.size(); a++) {
							datMantenimientoEquipoProd = listaMtto.get(a);
							Double cantidad = datMantenimientoEquipoProd.getCantidad();
							Double costoTotal = (double) Math.round((cantidad * valorUnitario) * 1000) / 1000;

							datMantenimientoEquipoProd.setValorUnitario(valorUnitario);
							datMantenimientoEquipoProd.setCostoTotal(costoTotal);
							businessDelegatorView.updateDatMantenimientoEquipoProd(datMantenimientoEquipoProd);
						}
						
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Mtto: Los precios de las salidas de productos fueron re-calculados exitosamente.  ", ""));
					}
					
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"No existe informacion asociada a los criterios de busqueda seleccionados. ", ""));

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"El intervalo de fechas seleccionadas no puede superar el rango de un mes, vuelva a intentarlo!! ",
					""));
		}
	}
	
	
	public void exportInventarioBodegaUbicacion() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		// fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// String f1 = txtFechaInicial.getValue().toString();

		// GregorianCalendar calendario1 = new GregorianCalendar();
		// calendario1.setTime(fechaInicial);
		// Date d1 = calendario1.getTime();
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		// GregorianCalendar calendario2 = new GregorianCalendar();
		// calendario2.setTime(fechaFinal);
		// Date d2 = calendario2.getTime();

		// String zona = "1";

		String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen);
		Long compania = new Long(getCompaniaIdSession());

		Long flagContratista = 1L;
		Long flagProducto = 1L;
		Long flagConceptoKardex = 1L;
		Long flagAlmacen = 1L;

		// Long compania = new Long(getCompaniaIdSession());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		// Date fechaInicial = null;
		// Date fechaFinal = null;
		// fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Long flagEquipo = 1L;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();
		Long flagTipoProducto = 1L;

		String almacenesSeleccionadas = "";
		if (selectedAlmacen != null && selectedAlmacen.size() > 0) {
			almacenesSeleccionadas = selectedAlmacen.get(0);
			flagAlmacen = 0L;
			for (int i = 1; i < selectedAlmacen.size(); i++) {
				almacenesSeleccionadas += "," + selectedAlmacen.get(i);
			}
		}

		String tiposProductoSeleccionadas = "";
		if (selectedTipoProducto != null && selectedTipoProducto.size() > 0) {
			tiposProductoSeleccionadas = selectedTipoProducto.get(0);
			flagTipoProducto = 0L;
			for (int i = 1; i < selectedTipoProducto.size(); i++) {
				tiposProductoSeleccionadas += "," + selectedTipoProducto.get(i);
			}
		}
		if (compania != null) {
			try {
				List<ConsultaStockMaquinariaDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoInventarioSaldoBodegaUbicacion.xlsx";

				data = businessDelegator2View.pr_inventario_saldo_bodega_ubicacion(compania, fechaFinalDateRegistro, fechaFinal,
						almacenId, 0L, tiposProductoSeleccionadas, flagTipoProducto);

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
						Cell columna1 = row.createCell(0);
						columna1.setCellValue("FECHA ENTRADA");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("FECHA SALIDA");
						columna2.setCellStyle(style2);

						Cell columna3 = row.createCell(2);
						columna3.setCellValue("COD. TIPO PRODUCTO");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("TIPO PRODUCTO");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("COD. PRODUCTO");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("PRODUCTO");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("CANT_ENTRADA");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("CANT_SALIDA");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("SALDO");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("VALOR_UNITARIO");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("COSTO_TOTAL");
						columna11.setCellStyle(style2);

						Cell columna12 = row.createCell(11);
						columna12.setCellValue("UM PRODUCTO");
						columna12.setCellStyle(style2);

						Cell columna13 = row.createCell(12);
						columna13.setCellValue("COD. ALMACEN");
						columna13.setCellStyle(style2);

						Cell columna14 = row.createCell(13);
						columna14.setCellValue("ALMACEN");
						columna14.setCellStyle(style2);

						Cell columna15 = row.createCell(14);
						columna15.setCellValue("REFERENCIA");
						columna15.setCellStyle(style2);

						Cell columna16 = row.createCell(15);
						columna16.setCellValue("UBICACIÓN");
						columna16.setCellStyle(style2);

						
						int pos_i = 8;

						for (ConsultaStockMaquinariaDTO costosTotalesDTO : data) {

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
							

							if (costosTotalesDTO.getFechaEntrada().equals("")) {
								cell1.setCellValue("");
								cell1.setCellStyle(style);
							} else {
								cell1.setCellValue(costosTotalesDTO.getFechaEntrada().toString().substring(8, 10) + "/"
										+ costosTotalesDTO.getFechaEntrada().toString().substring(5, 7) + "/"
										+ costosTotalesDTO.getFechaEntrada().toString().substring(0, 4));
								cell1.setCellStyle(style);
							}

							if (costosTotalesDTO.getFechaSalida().equals("")) {
								cell2.setCellValue("");
								cell2.setCellStyle(style);
							} else {
								cell2.setCellValue(costosTotalesDTO.getFechaSalida().toString().substring(8, 10) + "/"
										+ costosTotalesDTO.getFechaSalida().toString().substring(5, 7) + "/"
										+ costosTotalesDTO.getFechaSalida().toString().substring(0, 4));
								cell2.setCellStyle(style);
							}

							cell3.setCellValue(costosTotalesDTO.getCodProducto());
							cell3.setCellStyle(style);
							cell4.setCellValue(costosTotalesDTO.getNomTipoProducto());
							cell4.setCellStyle(style);
							cell5.setCellValue(costosTotalesDTO.getCodProducto());
							cell5.setCellStyle(style);
							cell6.setCellValue(costosTotalesDTO.getNomProducto());
							cell6.setCellStyle(style);

							cell7.setCellValue(costosTotalesDTO.getCantidadIngresada().doubleValue());
							cell7.setCellStyle(style);
							cell8.setCellValue(costosTotalesDTO.getCantidadSalida().doubleValue());
							cell8.setCellStyle(style);

							cell9.setCellValue(costosTotalesDTO.getCantidadDisponible().doubleValue());
							cell9.setCellStyle(style);
							cell10.setCellValue(costosTotalesDTO.getV_unitario().doubleValue());
							cell10.setCellStyle(style);
							cell11.setCellValue(costosTotalesDTO.getCosto_total().doubleValue());
							cell11.setCellStyle(style);
							cell12.setCellValue(costosTotalesDTO.getNombreUdadMed());
							cell12.setCellStyle(style);
							cell13.setCellValue(costosTotalesDTO.getCodAlmacen());
							cell13.setCellStyle(style);
							cell14.setCellValue(costosTotalesDTO.getAlmacen());
							cell14.setCellStyle(style);
							cell15.setCellValue(costosTotalesDTO.getReferencia());
							cell15.setCellStyle(style);
							
							cell16.setCellValue(costosTotalesDTO.getNombreUbicacion());
							cell16.setCellStyle(style);

							pos_i++;

						}

						// int numFilas = data.size() + 1;

						// for (int i = 0; i < numFilas; i++) {
						// sheet.autoSizeColumn(i);
						// }

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoInventarioSaldoBodegaUbicacion.xlsx");

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

}
