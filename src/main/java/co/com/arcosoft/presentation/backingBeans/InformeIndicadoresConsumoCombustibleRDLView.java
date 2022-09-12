package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
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

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
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
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
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
public class InformeIndicadoresConsumoCombustibleRDLView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeIndicadoresConsumoCombustibleRDLView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsultaCompraProductosDTO> data;
	
	private List<ConsultaCompraProductosDTO> dataMaq;
	private List<ConsultaCompraProductosDTO> dataMaqLabor;
	private List<ConsultaCompraProductosDTO> dataLabor;
	private List<ConsultaCompraProductosDTO> dataHda;

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

	private StreamedContent file2 = null;
	private String disableButton2 = "true";

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

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private InputNumber txtTotalHoras;
	private InputNumber txtTotalGalones;
	private InputNumber txtGlnHoras;
	private InputNumber txtGlnHorasEstandar;
	private String colorGalonesHora;
	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipo;

 
	
	public InformeIndicadoresConsumoCombustibleRDLView() {
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

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());

		Long flagContratista = 1L;
		Long flagProducto = 1L;
		Long flagConceptoKardex = 1L;
		Long flagAlmacen = 1L;

		String contratistasSeleccionadas = "";
		if (selectedContratista != null && selectedContratista.size() > 0) {
			contratistasSeleccionadas = selectedContratista.get(0);
			flagContratista = 0L;
			for (int i = 1; i < selectedContratista.size(); i++) {
				contratistasSeleccionadas += "," + selectedContratista.get(i);
			}
		}

		String productoId = "";
		String tipoProductoId = "";
		if (txtProductoId_Producto.getValue() != null) {
			productoId = txtProductoId_Producto.getValue().toString();
			flagProducto = 0L;
		}

		String almacenesSeleccionadas = "";
		if (selectedAlmacen != null && selectedAlmacen.size() > 0) {
			almacenesSeleccionadas = selectedAlmacen.get(0);
			flagAlmacen = 0L;
			for (int i = 1; i < selectedAlmacen.size(); i++) {
				almacenesSeleccionadas += "," + selectedAlmacen.get(i);
			}
		}

		String conceptoKardexSeleccionadas = "";
		if (selectedConceptoKardex != null && selectedConceptoKardex.size() > 0) {
			conceptoKardexSeleccionadas = selectedConceptoKardex.get(0);
			flagConceptoKardex = 0L;
			for (int i = 1; i < selectedConceptoKardex.size(); i++) {
				conceptoKardexSeleccionadas += "," + selectedConceptoKardex.get(i);
			}
		}
		if (compania != null) {
			try {
				List<ConsultaCompraProductosDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoInventarioDetalle.xlsx";

				data = businessDelegator2View.pr_inventario_detalle(compania, fechaInicial, fechaFinal, "0", 1L,
						productoId, flagProducto, almacenesSeleccionadas, flagAlmacen, conceptoKardexSeleccionadas,
						flagConceptoKardex, 0l, 0l,0l,"SUMINISTROS");

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
						columna1.setCellValue("FECHA");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("CONSECUTIVO");
						columna2.setCellStyle(style2);

						Cell columna3 = row.createCell(2);
						columna3.setCellValue("AÑO");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("MES");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("AÑO-MES");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("COD. PROVEEDOR");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("PROVEEDOR");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("COD. PRODUCTO");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("PRODUCTO");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("VALOR UNITARIO PROD");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("CANTIDAD");
						columna11.setCellStyle(style2);

						Cell columna12 = row.createCell(11);
						columna12.setCellValue("COD. UM PRODUCTO");
						columna12.setCellStyle(style2);

						Cell columna13 = row.createCell(12);
						columna13.setCellValue("UM PRODUCTO");
						columna13.setCellStyle(style2);

						Cell columna14 = row.createCell(13);
						columna14.setCellValue("COD. MAQUINA");
						columna14.setCellStyle(style2);

						Cell columna15 = row.createCell(14);
						columna15.setCellValue("MAQUINA");
						columna15.setCellStyle(style2);

						Cell columna16 = row.createCell(15);
						columna16.setCellValue("COD. ALMACEN");
						columna16.setCellStyle(style2);
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("ALMACEN");
						columna17.setCellStyle(style2);

						Cell columna18 = row.createCell(17);
						columna18.setCellValue("COD. CONCEPTO KARDEX");
						columna18.setCellStyle(style2);
						Cell columna19 = row.createCell(18);
						columna19.setCellValue("CONCEPTO KARDEX");
						columna19.setCellStyle(style2);

						Cell columna20 = row.createCell(19);
						columna20.setCellValue("TIPO MOVIMIENTO");
						columna20.setCellStyle(style2);

						Cell columna21 = row.createCell(20);
						columna21.setCellValue("VALOR TOTAL");
						columna21.setCellStyle(style2);

						Cell columna22 = row.createCell(21);
						columna22.setCellValue("DOCUMENTO KARDEX");
						columna22.setCellStyle(style2);

						Cell columna23 = row.createCell(22);
						columna23.setCellValue("HACIENDA");
						columna23.setCellStyle(style2);

						Cell columna24 = row.createCell(23);
						columna24.setCellValue("SUERTE");
						columna24.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaCompraProductosDTO costosTotalesDTO : data) {

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

							cell1.setCellValue(costosTotalesDTO.getFecha_registro().toString().substring(0, 10));
							cell1.setCellStyle(style);
							cell2.setCellValue(costosTotalesDTO.getPrecioProdid().doubleValue());
							cell2.setCellStyle(style);

							cell3.setCellValue(costosTotalesDTO.getAnio().doubleValue());
							cell3.setCellStyle(style);
							cell4.setCellValue(costosTotalesDTO.getMes().doubleValue());
							cell4.setCellStyle(style);
							cell5.setCellValue(costosTotalesDTO.getAnio_mes());
							cell5.setCellStyle(style);
							cell6.setCellValue(costosTotalesDTO.getCod_proveedor());
							cell6.setCellStyle(style);
							cell7.setCellValue(costosTotalesDTO.getNom_proveedor());
							cell7.setCellStyle(style);

							cell8.setCellValue(costosTotalesDTO.getCod_producto());
							cell8.setCellStyle(style);
							cell9.setCellValue(costosTotalesDTO.getNom_producto());
							cell9.setCellStyle(style);
							cell10.setCellValue(costosTotalesDTO.getValor_unitario().doubleValue());
							cell10.setCellStyle(style);
							cell11.setCellValue(costosTotalesDTO.getCantidad_compra().doubleValue());
							cell11.setCellStyle(style);
							cell12.setCellValue(costosTotalesDTO.getCod_udad_med());
							cell12.setCellStyle(style);
							cell13.setCellValue(costosTotalesDTO.getNom_udad_med());
							cell13.setCellStyle(style);
							cell14.setCellValue(costosTotalesDTO.getCod_equipo());
							cell14.setCellStyle(style);
							cell15.setCellValue(costosTotalesDTO.getNom_equipo());
							cell15.setCellStyle(style);
							cell16.setCellValue(costosTotalesDTO.getCod_almacen());
							cell16.setCellStyle(style);
							cell17.setCellValue(costosTotalesDTO.getNom_almacen());
							cell17.setCellStyle(style);

							cell18.setCellValue(costosTotalesDTO.getCod_concepto_kardex());
							cell18.setCellStyle(style);

							cell19.setCellValue(costosTotalesDTO.getNom_concepto_kardex());
							cell19.setCellStyle(style);

							cell20.setCellValue(costosTotalesDTO.getTipo_movimiento());
							cell20.setCellStyle(style);

							cell21.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell21.setCellStyle(style);

							cell22.setCellValue(costosTotalesDTO.getDocumentoKardex().doubleValue());
							cell22.setCellStyle(style);

							cell23.setCellValue(costosTotalesDTO.getCodHacienda());
							cell23.setCellStyle(style);

							cell24.setCellValue(costosTotalesDTO.getCodSuerte());
							cell24.setCellStyle(style);

							// cell20.setCellValue(d1);
							// cell21.setCellValue(d2);

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoInventarioDetalle.xlsx");

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

	

	public List<ConsultaCompraProductosDTO> getData() {
		return data;
	}
	

	public void setData(List<ConsultaCompraProductosDTO> data) {
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

			contratistas = new ArrayList<PersEmpr>();
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
				// by
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

	public StreamedContent getFile2() {
		return file2;
	}

	public void setFile2(StreamedContent file2) {
		this.file2 = file2;
	}

	public String getDisableButton2() {
		return disableButton2;
	}

	public void setDisableButton2(String disableButton2) {
		this.disableButton2 = disableButton2;
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

	public void inventarioMes() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());

		Long flagContratista = 1L;
		Long flagProducto = 1L;
		Long flagConceptoKardex = 1L;
		Long flagAlmacen = 1L;

		String contratistasSeleccionadas = "";
		if (selectedContratista != null && selectedContratista.size() > 0) {
			contratistasSeleccionadas = selectedContratista.get(0);
			flagContratista = 0L;
			for (int i = 1; i < selectedContratista.size(); i++) {
				contratistasSeleccionadas += "," + selectedContratista.get(i);
			}
		}

		String productoId = "";
		String tipoProductoId = "";
		if (txtProductoId_Producto.getValue() != null) {
			productoId = txtProductoId_Producto.getValue().toString();
			flagProducto = 0L;
		}

		String almacenesSeleccionadas = "";
		if (selectedAlmacen != null && selectedAlmacen.size() > 0) {
			almacenesSeleccionadas = selectedAlmacen.get(0);
			flagAlmacen = 0L;
			for (int i = 1; i < selectedAlmacen.size(); i++) {
				almacenesSeleccionadas += "," + selectedAlmacen.get(i);
			}
		}

		String conceptoKardexSeleccionadas = "";
		if (selectedConceptoKardex != null && selectedConceptoKardex.size() > 0) {
			conceptoKardexSeleccionadas = selectedConceptoKardex.get(0);
			flagConceptoKardex = 0L;
			for (int i = 1; i < selectedConceptoKardex.size(); i++) {
				conceptoKardexSeleccionadas += "," + selectedConceptoKardex.get(i);
			}
		}
		if (compania != null) {
			try {
				List<ConsultaCompraProductosDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoInventarioMes.xlsx";

				data = businessDelegator2View.pr_inventario_detalle(compania, fechaInicial, fechaFinal, "0", 1L,
						productoId, flagProducto, almacenesSeleccionadas, flagAlmacen, conceptoKardexSeleccionadas,
						flagConceptoKardex, 0l, 0l,0l,"SUMINISTROS");

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
						columna1.setCellValue("FECHA");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("CONSECUTIVO");
						columna2.setCellStyle(style2);

						Cell columna3 = row.createCell(2);
						columna3.setCellValue("AÑO");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("MES");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("AÑO-MES");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("COD. PROVEEDOR");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("PROVEEDOR");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("COD. PRODUCTO");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("PRODUCTO");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("VALOR UNITARIO PROD");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("CANTIDAD");
						columna11.setCellStyle(style2);

						Cell columna12 = row.createCell(11);
						columna12.setCellValue("COD. UM PRODUCTO");
						columna12.setCellStyle(style2);

						Cell columna13 = row.createCell(12);
						columna13.setCellValue("UM PRODUCTO");
						columna13.setCellStyle(style2);

						Cell columna14 = row.createCell(13);
						columna14.setCellValue("COD. MAQUINA");
						columna14.setCellStyle(style2);

						Cell columna15 = row.createCell(14);
						columna15.setCellValue("MAQUINA");
						columna15.setCellStyle(style2);

						Cell columna16 = row.createCell(15);
						columna16.setCellValue("COD. ALMACEN");
						columna16.setCellStyle(style2);
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("ALMACEN");
						columna17.setCellStyle(style2);

						Cell columna18 = row.createCell(17);
						columna18.setCellValue("COD. CONCEPTO KARDEX");
						columna18.setCellStyle(style2);
						Cell columna19 = row.createCell(18);
						columna19.setCellValue("CONCEPTO KARDEX");
						columna19.setCellStyle(style2);

						Cell columna20 = row.createCell(19);
						columna20.setCellValue("TIPO MOVIMIENTO");
						columna20.setCellStyle(style2);

						Cell columna21 = row.createCell(20);
						columna21.setCellValue("VALOR TOTAL");
						columna21.setCellStyle(style2);

						Cell columna22 = row.createCell(21);
						columna22.setCellValue("DOCUMENTO KARDEX");
						columna22.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaCompraProductosDTO costosTotalesDTO : data) {

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

							cell1.setCellValue(costosTotalesDTO.getFecha_registro().toString().substring(0, 10));
							cell1.setCellStyle(style);
							cell2.setCellValue(costosTotalesDTO.getPrecioProdid().doubleValue());
							cell2.setCellStyle(style);

							cell3.setCellValue(costosTotalesDTO.getAnio().doubleValue());
							cell3.setCellStyle(style);
							cell4.setCellValue(costosTotalesDTO.getMes().doubleValue());
							cell4.setCellStyle(style);
							cell5.setCellValue(costosTotalesDTO.getAnio_mes());
							cell5.setCellStyle(style);
							cell6.setCellValue(costosTotalesDTO.getCod_proveedor());
							cell6.setCellStyle(style);
							cell7.setCellValue(costosTotalesDTO.getNom_proveedor());
							cell7.setCellStyle(style);

							cell8.setCellValue(costosTotalesDTO.getCod_producto());
							cell8.setCellStyle(style);
							cell9.setCellValue(costosTotalesDTO.getNom_producto());
							cell9.setCellStyle(style);
							cell10.setCellValue(costosTotalesDTO.getValor_unitario().doubleValue());
							cell10.setCellStyle(style);
							cell11.setCellValue(costosTotalesDTO.getCantidad_compra().doubleValue());
							cell11.setCellStyle(style);
							cell12.setCellValue(costosTotalesDTO.getCod_udad_med());
							cell12.setCellStyle(style);
							cell13.setCellValue(costosTotalesDTO.getNom_udad_med());
							cell13.setCellStyle(style);
							cell14.setCellValue(costosTotalesDTO.getCod_equipo());
							cell14.setCellStyle(style);
							cell15.setCellValue(costosTotalesDTO.getNom_equipo());
							cell15.setCellStyle(style);
							cell16.setCellValue(costosTotalesDTO.getCod_almacen());
							cell16.setCellStyle(style);
							cell17.setCellValue(costosTotalesDTO.getNom_almacen());
							cell17.setCellStyle(style);

							cell18.setCellValue(costosTotalesDTO.getCod_concepto_kardex());
							cell18.setCellStyle(style);

							cell19.setCellValue(costosTotalesDTO.getNom_concepto_kardex());
							cell19.setCellStyle(style);

							cell20.setCellValue(costosTotalesDTO.getTipo_movimiento());
							cell20.setCellStyle(style);

							cell21.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell21.setCellStyle(style);

							cell22.setCellValue(costosTotalesDTO.getDocumentoKardex().doubleValue());
							cell22.setCellStyle(style);

							// cell20.setCellValue(d1);
							// cell21.setCellValue(d2);

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoInventarioMes.xlsx");

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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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
				Object[] condicion = { "estado", true, "A", "=", "categoriaEquipo.funcion", true, "Tractor", "=" };
				equipos = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);

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

	public void consumoAcpmRdl() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;
		Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		FacesContext context = FacesContext.getCurrentInstance();
		
		Double horas = 0.0;
		Double glnHoras= 0.0;
		Double combustible =0.0;
		Double cantidadRegistros =0.0;
		Double galonesHoraEstandar =0.0;
		
		if (compania != null & fechaInicial !=null & fechaFinal !=null) {
			try {
				data = null;

				data = businessDelegator2View.pr_consumo_combustible_rdl(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo,categoria);

				if (data == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
							"No existe informacion asociada a los criterios de busqueda seleccionados "));
				}else {
					
					for( ConsultaCompraProductosDTO data1 : data) {
						horas += (data1.getHoras().doubleValue()) ;
						combustible += (data1.getCantidad_compra().doubleValue()) ;
						cantidadRegistros +=1;
						galonesHoraEstandar +=data1.getGlHorasEstandar().doubleValue();
						//glnHoras += (data1.getGlHoras().doubleValue()) ;
			        	
			        }
					txtTotalHoras.setValue(horas);
					txtTotalGalones.setValue(combustible);
					glnHoras =  combustible /horas;
					glnHoras = (double) Math.round((glnHoras) * 1000) / 1000;
					
					Double glHrEstandar = galonesHoraEstandar /cantidadRegistros;
					glHrEstandar = (double) Math.round((glHrEstandar) * 1000) / 1000;
					txtGlnHorasEstandar.setValue(glHrEstandar);
					
					txtGlnHoras.setValue(glnHoras);
					
					String color= "#17b55e";
					colorGalonesHora =color ;
					if (glHrEstandar.doubleValue() >0 &&  glnHoras.doubleValue()  > glHrEstandar.doubleValue()  ) {
						color = "#F85B5B";
						colorGalonesHora = color;
					} else {
						color = "#17b55e";
						colorGalonesHora=color;
					}
					
					
					
				}
				
				

			} catch (Exception e) {

				e.printStackTrace();
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));

			}

		}

	}

	public InputNumber getTxtTotalHoras() {
		return txtTotalHoras;
	}

	public void setTxtTotalHoras(InputNumber txtTotalHoras) {
		this.txtTotalHoras = txtTotalHoras;
	}

	public InputNumber getTxtTotalGalones() {
		return txtTotalGalones;
	}

	public void setTxtTotalGalones(InputNumber txtTotalGalones) {
		this.txtTotalGalones = txtTotalGalones;
	}

	public InputNumber getTxtGlnHoras() {
		return txtGlnHoras;
	}

	public void setTxtGlnHoras(InputNumber txtGlnHoras) {
		this.txtGlnHoras = txtGlnHoras;
	}

	public InputNumber getTxtGlnHorasEstandar() {
		return txtGlnHorasEstandar;
	}

	public void setTxtGlnHorasEstandar(InputNumber txtGlnHorasEstandar) {
		this.txtGlnHorasEstandar = txtGlnHorasEstandar;
	}

	public String getColorGalonesHora() {
		return colorGalonesHora;
	}

	public void setColorGalonesHora(String colorGalonesHora) {
		this.colorGalonesHora = colorGalonesHora;
	}
	
	

	public void exportConsumoCombustibleRDL() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}
		
		
		if (compania != null & fechaInicial !=null & fechaFinal !=null) {
			try {
				List<ConsultaCompraProductosDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoConsumoAcpmMaquinaRdl.xlsx";

				data = businessDelegator2View.pr_consumo_combustible_rdl(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo, categoria);

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

						Cell 	columna1	=	row.createCell(	0	);	columna1.setCellValue("PRECIO_PROD_ID");	columna1	.setCellStyle(style2);
						Cell 	columna2	=	row.createCell(	1	);	columna2.setCellValue("FECHA_INICIAL");	columna2	.setCellStyle(style2);
						Cell 	columna3	=	row.createCell(	2	);	columna3.setCellValue("ANIO");	columna3	.setCellStyle(style2);
						Cell 	columna4	=	row.createCell(	3	);	columna4.setCellValue("MES");	columna4	.setCellStyle(style2);
						Cell 	columna5	=	row.createCell(	4	);	columna5.setCellValue("ANIO_MES");	columna5	.setCellStyle(style2);
						Cell 	columna6	=	row.createCell(	5	);	columna6.setCellValue("NUM_FACTURA_COMPRA");	columna6	.setCellStyle(style2);
						Cell 	columna7	=	row.createCell(	6	);	columna7.setCellValue("COD_PROVEEDOR");	columna7	.setCellStyle(style2);
						Cell 	columna8	=	row.createCell(	7	);	columna8.setCellValue("NOM_PROVEEDOR");	columna8	.setCellStyle(style2);
						Cell 	columna9	=	row.createCell(	8	);	columna9.setCellValue("COD_PRODUCTO");	columna9	.setCellStyle(style2);
						Cell 	columna10	=	row.createCell(	9	);	columna10.setCellValue("NOM_PRODUCTO");	columna10	.setCellStyle(style2);
						Cell 	columna11	=	row.createCell(	10	);	columna11.setCellValue("VALOR_UNITARIO");	columna11	.setCellStyle(style2);
						Cell 	columna12	=	row.createCell(	11	);	columna12.setCellValue("COMBUSTIBLE");	columna12	.setCellStyle(style2);
						Cell 	columna13	=	row.createCell(	12	);	columna13.setCellValue("COD_EQUIPO");	columna13	.setCellStyle(style2);
						Cell 	columna14	=	row.createCell(	13	);	columna14.setCellValue("NOM_EQUIPO");	columna14	.setCellStyle(style2);
						Cell 	columna15	=	row.createCell(	14	);	columna15.setCellValue("COD_UDAD_MED");	columna15	.setCellStyle(style2);
						Cell 	columna16	=	row.createCell(	15	);	columna16.setCellValue("NOM_UDAD_MED");	columna16	.setCellStyle(style2);
						Cell 	columna17	=	row.createCell(	16	);	columna17.setCellValue("COD_ALMACEN");	columna17	.setCellStyle(style2);
						Cell 	columna18	=	row.createCell(	17	);	columna18.setCellValue("NOM_ALMACEN");	columna18	.setCellStyle(style2);
						Cell 	columna19	=	row.createCell(	18	);	columna19.setCellValue("COD_CONCEPTO_KARDEX");	columna19	.setCellStyle(style2);
						Cell 	columna20	=	row.createCell(	19	);	columna20.setCellValue("NOM_CONCEPTO_KARDEX");	columna20	.setCellStyle(style2);
						Cell 	columna21	=	row.createCell(	20	);	columna21.setCellValue("TIPO_MOVIMIENTO");	columna21	.setCellStyle(style2);
						Cell 	columna22	=	row.createCell(	21	);	columna22.setCellValue("COD_TRABAJADOR");	columna22	.setCellStyle(style2);
						Cell 	columna23	=	row.createCell(	22	);	columna23.setCellValue("NOM_TRABAJADOR");	columna23	.setCellStyle(style2);
						Cell 	columna24	=	row.createCell(	23	);	columna24.setCellValue("COSTO_TOTAL");	columna24	.setCellStyle(style2);
						Cell 	columna25	=	row.createCell(	24	);	columna25.setCellValue("CONSEC_KARDEX");	columna25	.setCellStyle(style2);
						Cell 	columna26	=	row.createCell(	25	);	columna26.setCellValue("CONSECUTIVO_PIN");	columna26	.setCellStyle(style2);
						Cell 	columna27	=	row.createCell(	26	);	columna27.setCellValue("CONSECUTIVO_RDL");	columna27	.setCellStyle(style2);
						Cell 	columna28	=	row.createCell(	27	);	columna28.setCellValue("HOROMETRO_ABASTECIMIENTO");	columna28	.setCellStyle(style2);
						Cell 	columna29	=	row.createCell(	28	);	columna29.setCellValue("HOROMETRO_ABASTECIMIENTO_ANTERIOR");	columna29	.setCellStyle(style2);
						Cell 	columna30	=	row.createCell(	29	);	columna30.setCellValue("HORAS");	columna30	.setCellStyle(style2);
						Cell 	columna31	=	row.createCell(	30	);	columna31.setCellValue("GL_HORA");	columna31	.setCellStyle(style2);
						Cell 	columna32	=	row.createCell(	31	);	columna32.setCellValue("CONSUMO_GL_HORA_ESTANDAR");	columna32	.setCellStyle(style2);
						Cell 	columna33	=	row.createCell(	32	);	columna33.setCellValue("P. INICIAL");	columna33	.setCellStyle(style2);
						Cell 	columna34	=	row.createCell(	33	);	columna34.setCellValue("P. FINAL");	columna34	.setCellStyle(style2);
						Cell 	columna35	=	row.createCell(	34	);	columna35.setCellValue("COD. LABOR");	columna35	.setCellStyle(style2);
						Cell 	columna36	=	row.createCell(	35	);	columna36.setCellValue("NOM. LABOR");	columna36	.setCellStyle(style2);
						Cell 	columna37	=	row.createCell(	36	);	columna37.setCellValue("HACIENDA");	columna37	.setCellStyle(style2);
						Cell 	columna38	=	row.createCell(	37	);	columna38.setCellValue("OPERARIO");	columna38	.setCellStyle(style2);
						

						int pos_i = 8;

						for (ConsultaCompraProductosDTO costosTotalesDTO : data) {

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
							

							
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							
						//	cell.setCellValue(fechaI);
							
							
																
									cell1.setCellValue(costosTotalesDTO.getPrecioProdid().longValue());cell1.setCellStyle(style);
									
									//String fechaRegistro = dateFormat.format(costosTotalesDTO.getFecha_registro());
								
									
									cell2.setCellValue(costosTotalesDTO.getFecha_registro());cell2.setCellStyle(style);
									cell3.setCellValue(costosTotalesDTO.getAnio().longValue());cell3.setCellStyle(style);
									cell4.setCellValue(costosTotalesDTO.getMes().longValue());cell4.setCellStyle(style);
									cell5.setCellValue(costosTotalesDTO.getAnio_mes());cell5.setCellStyle(style);
									cell6.setCellValue(costosTotalesDTO.getNum_factura().longValue());cell6.setCellStyle(style);
									cell7.setCellValue(costosTotalesDTO.getCod_proveedor());cell7.setCellStyle(style);
									cell8.setCellValue(costosTotalesDTO.getNom_proveedor());cell8.setCellStyle(style);
									cell9.setCellValue(costosTotalesDTO.getCod_producto());cell9.setCellStyle(style);
									cell10.setCellValue(costosTotalesDTO.getNom_producto());cell10.setCellStyle(style);
									cell11.setCellValue(costosTotalesDTO.getValor_unitario().doubleValue());cell11.setCellStyle(style);
									cell12.setCellValue(costosTotalesDTO.getCantidad_compra().doubleValue());cell12.setCellStyle(style);
									cell13.setCellValue(costosTotalesDTO.getCod_equipo());cell13.setCellStyle(style);
									cell14.setCellValue(costosTotalesDTO.getNom_equipo());cell14.setCellStyle(style);
									cell15.setCellValue(costosTotalesDTO.getCod_udad_med());cell15.setCellStyle(style);
									cell16.setCellValue(costosTotalesDTO.getNom_udad_med());cell16.setCellStyle(style);
									cell17.setCellValue(costosTotalesDTO.getCod_almacen());cell17.setCellStyle(style);
									cell18.setCellValue(costosTotalesDTO.getNom_almacen());cell18.setCellStyle(style);
									cell19.setCellValue(costosTotalesDTO.getCod_concepto_kardex());cell19.setCellStyle(style);
									cell20.setCellValue(costosTotalesDTO.getNom_concepto_kardex());cell20.setCellStyle(style);
									cell21.setCellValue(costosTotalesDTO.getTipo_movimiento());cell21.setCellStyle(style);
									cell22.setCellValue(costosTotalesDTO.getCod_trabajador());cell22.setCellStyle(style);
									cell23.setCellValue(costosTotalesDTO.getNom_trabajador());cell23.setCellStyle(style);
									cell24.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());cell24.setCellStyle(style);
									cell25.setCellValue(0);cell25.setCellStyle(style);
									cell26.setCellValue(costosTotalesDTO.getConsecutivoPin().longValue());cell26.setCellStyle(style);
									cell27.setCellValue(costosTotalesDTO.getConsecutivoRdl().longValue());cell27.setCellStyle(style);
									cell28.setCellValue(costosTotalesDTO.getHorometroAbastecimiento().doubleValue());cell28.setCellStyle(style);
									cell29.setCellValue(costosTotalesDTO.getHorometroAbastecimientoAnterior().doubleValue());cell29.setCellStyle(style);
									cell30.setCellValue(costosTotalesDTO.getHoras().doubleValue());cell30.setCellStyle(style);
									cell31.setCellValue(costosTotalesDTO.getGlHoras().doubleValue());cell31.setCellStyle(style);
									cell32.setCellValue(costosTotalesDTO.getGlHorasEstandar().doubleValue());cell32.setCellStyle(style);
									
									String fechaI = dateFormat.format(fechaInicial);
									String fechaF = dateFormat.format(fechaFinal);
									cell33.setCellValue(fechaI); cell33.setCellStyle(style);
									cell34.setCellValue(fechaF); cell34.setCellStyle(style);
									cell35.setCellValue(costosTotalesDTO.getCodLabor());cell35.setCellStyle(style);
									cell36.setCellValue(costosTotalesDTO.getNomLabor());cell36.setCellStyle(style);
									cell37.setCellValue(costosTotalesDTO.getNomHacienda());cell37.setCellStyle(style);
									cell38.setCellValue(costosTotalesDTO.getNomOperarioMaquina());cell38.setCellStyle(style);
									
									
								
							// cell20.setCellValue(d1);
							// cell21.setCellValue(d2);

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoConsumoAcpmMaquinaRdl.xlsx");

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

	
	
	public void pr_consumo_combustible_rdl_resumen_maq() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		FacesContext context = FacesContext.getCurrentInstance();
		
		Double horas = 0.0;
		Double glnHoras= 0.0;
		Double combustible =0.0;
		Double cantidadRegistros =0.0;
		Double galonesHoraEstandar =0.0;
		
		if (compania != null) {
			try {
				dataMaq = null;

				dataMaq = businessDelegator2View.pr_consumo_combustible_rdl_resumen_maq(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo);

				if (dataMaq == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
							"No existe informacion asociada a los criterios de busqueda seleccionados "));
				}else {
					
					for( ConsultaCompraProductosDTO data1 : dataMaq) {
						horas += (data1.getHoras().doubleValue()) ;
						combustible += (data1.getCantidad_compra().doubleValue()) ;
						cantidadRegistros +=1;
						galonesHoraEstandar +=data1.getGlHorasEstandar().doubleValue();
						//glnHoras += (data1.getGlHoras().doubleValue()) ;
			        	
			        }
					txtTotalHoras.setValue(horas);
					txtTotalGalones.setValue(combustible);
					glnHoras =  combustible /horas;
					glnHoras = (double) Math.round((glnHoras) * 1000) / 1000;
					
					Double glHrEstandar = galonesHoraEstandar /cantidadRegistros;
					glHrEstandar = (double) Math.round((glHrEstandar) * 1000) / 1000;
					txtGlnHorasEstandar.setValue(glHrEstandar);
					
					txtGlnHoras.setValue(glnHoras);
					
					String color= "#17b55e";
					colorGalonesHora =color ;
					if (glHrEstandar.doubleValue() >0 &&  glnHoras.doubleValue()  > glHrEstandar.doubleValue()  ) {
						color = "#F85B5B";
						colorGalonesHora = color;
					} else {
						color = "#17b55e";
						colorGalonesHora=color;
					}
					
					
					
				}
				
				

			} catch (Exception e) {

				e.printStackTrace();
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));

			}

		}

	}
	
	public void pr_consumo_combustible_rdl_resumen_maq_labor() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		FacesContext context = FacesContext.getCurrentInstance();
		
		Double horas = 0.0;
		Double glnHoras= 0.0;
		Double combustible =0.0;
		Double cantidadRegistros =0.0;
		Double galonesHoraEstandar =0.0;
		
		if (compania != null) {
			try {
				dataMaqLabor = null;

				dataMaqLabor = businessDelegator2View.pr_consumo_combustible_rdl_resumen_maq_labor(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo);

				if (dataMaqLabor == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
							"No existe informacion asociada a los criterios de busqueda seleccionados "));
				}else {
					
					for( ConsultaCompraProductosDTO data1 : dataMaqLabor) {
						horas += (data1.getHoras().doubleValue()) ;
						combustible += (data1.getCantidad_compra().doubleValue()) ;
						cantidadRegistros +=1;
						galonesHoraEstandar +=data1.getGlHorasEstandar().doubleValue();
						//glnHoras += (data1.getGlHoras().doubleValue()) ;
			        	
			        }
					txtTotalHoras.setValue(horas);
					txtTotalGalones.setValue(combustible);
					glnHoras =  combustible /horas;
					glnHoras = (double) Math.round((glnHoras) * 1000) / 1000;
					
					Double glHrEstandar = galonesHoraEstandar /cantidadRegistros;
					glHrEstandar = (double) Math.round((glHrEstandar) * 1000) / 1000;
					txtGlnHorasEstandar.setValue(glHrEstandar);
					
					txtGlnHoras.setValue(glnHoras);
					
					String color= "#17b55e";
					colorGalonesHora =color ;
					if (glHrEstandar.doubleValue() >0 &&  glnHoras.doubleValue()  > glHrEstandar.doubleValue()  ) {
						color = "#F85B5B";
						colorGalonesHora = color;
					} else {
						color = "#17b55e";
						colorGalonesHora=color;
					}
					
					
					
				}
				
				

			} catch (Exception e) {

				e.printStackTrace();
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));

			}

		}

	}

	
	public void pr_consumo_combustible_rdl_resumen_labor() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		FacesContext context = FacesContext.getCurrentInstance();
		
		Double horas = 0.0;
		Double glnHoras= 0.0;
		Double combustible =0.0;
		Double cantidadRegistros =0.0;
		Double galonesHoraEstandar =0.0;
		
		if (compania != null) {
			try {
				dataLabor = null;

				dataLabor = businessDelegator2View.pr_consumo_combustible_rdl_resumen_labor(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo);

				if (dataLabor == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
							"No existe informacion asociada a los criterios de busqueda seleccionados "));
				}else {
					
					for( ConsultaCompraProductosDTO data1 : dataLabor) {
						horas += (data1.getHoras().doubleValue()) ;
						combustible += (data1.getCantidad_compra().doubleValue()) ;
						cantidadRegistros +=1;
						galonesHoraEstandar +=data1.getGlHorasEstandar().doubleValue();
						//glnHoras += (data1.getGlHoras().doubleValue()) ;
			        	
			        }
					txtTotalHoras.setValue(horas);
					txtTotalGalones.setValue(combustible);
					glnHoras =  combustible /horas;
					glnHoras = (double) Math.round((glnHoras) * 1000) / 1000;
					
					Double glHrEstandar = galonesHoraEstandar /cantidadRegistros;
					glHrEstandar = (double) Math.round((glHrEstandar) * 1000) / 1000;
					txtGlnHorasEstandar.setValue(glHrEstandar);
					
					txtGlnHoras.setValue(glnHoras);
					
					String color= "#17b55e";
					colorGalonesHora =color ;
					if (glHrEstandar.doubleValue() >0 &&  glnHoras.doubleValue()  > glHrEstandar.doubleValue()  ) {
						color = "#F85B5B";
						colorGalonesHora = color;
					} else {
						color = "#17b55e";
						colorGalonesHora=color;
					}
					
					
					
				}
				
				

			} catch (Exception e) {

				e.printStackTrace();
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));

			}

		}

	}
	
	
	public void pr_consumo_combustible_rdl_resumen_hda() throws NumberFormatException, Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;

		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

		GregorianCalendar calendario1 = new GregorianCalendar();
		calendario1.setTime(fechaInicial);
		Date d1 = calendario1.getTime();

		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		FacesContext context = FacesContext.getCurrentInstance();
		
		Double horas = 0.0;
		Double glnHoras= 0.0;
		Double combustible =0.0;
		Double cantidadRegistros =0.0;
		Double galonesHoraEstandar =0.0;
		
		if (compania != null) {
			try {
				dataHda = null;

				dataHda = businessDelegator2View.pr_consumo_combustible_rdl_resumen_hda(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo);

				if (dataHda == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
							"No existe informacion asociada a los criterios de busqueda seleccionados "));
				}else {
					
					for( ConsultaCompraProductosDTO data1 : dataHda) {
						horas += (data1.getHoras().doubleValue()) ;
						combustible += (data1.getCantidad_compra().doubleValue()) ;
						cantidadRegistros +=1;
						galonesHoraEstandar +=data1.getGlHorasEstandar().doubleValue();
						//glnHoras += (data1.getGlHoras().doubleValue()) ;
			        	
			        }
					txtTotalHoras.setValue(horas);
					txtTotalGalones.setValue(combustible);
					glnHoras =  combustible /horas;
					glnHoras = (double) Math.round((glnHoras) * 1000) / 1000;
					
					Double glHrEstandar = galonesHoraEstandar /cantidadRegistros;
					glHrEstandar = (double) Math.round((glHrEstandar) * 1000) / 1000;
					txtGlnHorasEstandar.setValue(glHrEstandar);
					
					txtGlnHoras.setValue(glnHoras);
					
					String color= "#17b55e";
					colorGalonesHora =color ;
					if (glHrEstandar.doubleValue() >0 &&  glnHoras.doubleValue()  > glHrEstandar.doubleValue()  ) {
						color = "#F85B5B";
						colorGalonesHora = color;
					} else {
						color = "#17b55e";
						colorGalonesHora=color;
					}
					
					
					
				}
				
				

			} catch (Exception e) {

				e.printStackTrace();
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));

			}

		}

	}
	
	
	
	
	public List<ConsultaCompraProductosDTO> getDataMaq() {
		return dataMaq;
	}

	public void setDataMaq(List<ConsultaCompraProductosDTO> dataMaq) {
		this.dataMaq = dataMaq;
	}

	public List<ConsultaCompraProductosDTO> getDataMaqLabor() {
		return dataMaqLabor;
	}

	public void setDataMaqLabor(List<ConsultaCompraProductosDTO> dataMaqLabor) {
		this.dataMaqLabor = dataMaqLabor;
	}

	public List<ConsultaCompraProductosDTO> getDataLabor() {
		return dataLabor;
	}

	public void setDataLabor(List<ConsultaCompraProductosDTO> dataLabor) {
		this.dataLabor = dataLabor;
	}

	public List<ConsultaCompraProductosDTO> getDataHda() {
		return dataHda;
	}

	public void setDataHda(List<ConsultaCompraProductosDTO> dataHda) {
		this.dataHda = dataHda;
	}
	

	public SelectItem[] getselectCategoriaEquipo() {

		if (categoriaEquipo == null || categoriaEquipo.size() == 0) {

		
			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CategoriaEquipo> lista = businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null,
						null);
				selectCategoriaEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CategoriaEquipo categoriaEquipo : lista) {
					selectCategoriaEquipo[i] = new SelectItem(categoriaEquipo.getCategEquipId(),
							categoriaEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCategoriaEquipo;
	}

	public void setselectCategoriaEquipo(SelectItem[] selectCategoriaEquipo) {
		this.selectCategoriaEquipo = selectCategoriaEquipo;
	}
	

}
