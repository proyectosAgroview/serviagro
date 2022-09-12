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
public class InformeInventarioDocumentoKardexMpView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeInventarioDocumentoKardexMpView.class);

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
	
	private InputText txtDocumentoFactura;
	
	public InformeInventarioDocumentoKardexMpView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	
	
	public void consultaDocumentoKardex() throws NumberFormatException, Exception {

		 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");

					
		Long documentoKardex = 0L;
		 documentoKardex = FacesUtils.checkLong(txtDocumentoKardex);
		 
		 if(documentoKardex ==null){
			 documentoKardex = 0L;
			}

			Long factura = 0L;
			factura = FacesUtils.checkLong(txtDocumentoFactura);
			 
			 if(factura ==null){
				 factura = 0L;
				}
			 
		Long compania = new Long(getCompaniaIdSession());
		String conceptoKardex = FacesUtils.checkString(txtConceptoKardex);
		 
		Long flagContratista = 1L;
		Long flagProducto =1L;
		Long flagConceptoKardex = 1L;
		Long flagAlmacen = 1L;
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro =null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		 fechaFinalDateRegistro = sdf.parse(fsalida);

		
		GregorianCalendar calendar = new GregorianCalendar();
		 Date date = new Date();
			
		calendar.setTime(date); // Configuramos la fecha que se
											// recibe
		calendar.add(GregorianCalendar.DAY_OF_YEAR, 365); 
		
	
    
		if (compania != null && documentoKardex !=null && conceptoKardex !=null) {
			try {
				List<ConsultaCompraProductosDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoInventarioDocumentoKardexMp.xlsx";

				data = businessDelegator2View.pr_inventario_detalle_materia_prima( compania,  fechaFinalDateRegistro,  calendar.getTime(),
						"0",  1L, "0",  1L, "0",  1L, conceptoKardex, 0L, documentoKardex, factura);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);
					XSSFRow row = sheet.createRow(7);
					
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

					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));

					if (data != null) {

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
						columna23.setCellValue("FACTURA");
						columna23.setCellStyle(style2);
						
						Cell columna24 = row.createCell(23);
						columna24.setCellValue("TRANSPORTADORA");
						columna24.setCellStyle(style2);
						
						
						Cell columna25 = row.createCell(24);
						columna25.setCellValue("GUIA");
						columna25.setCellStyle(style2);
						
						
						Cell columna26 = row.createCell(25);
						columna26.setCellValue("FLETE");
						columna26.setCellStyle(style2);
						
						Cell columna27 = row.createCell(26);
						columna27.setCellValue("HACIENDA");
						columna27.setCellStyle(style2);
						
						Cell columna28 = row.createCell(27);
						columna28.setCellValue("SUERTE");
						columna28.setCellStyle(style2);
						
						Cell columna29 = row.createCell(28);
						columna29.setCellValue("HOROMETRO ABASTECIMIENTO");
						columna29.setCellStyle(style2);
						
						Cell columna30 = row.createCell(29);
						columna30.setCellValue("UBICACION");
						columna30.setCellStyle(style2);
						
						
					
						
						
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
							
							cell23.setCellValue(costosTotalesDTO.getNum_factura().doubleValue());
							cell23.setCellStyle(style);
							
							
							cell24.setCellValue(costosTotalesDTO.getTransportadora());
							cell24.setCellStyle(style);
							
							cell25.setCellValue(costosTotalesDTO.getnGuia());
							cell25.setCellStyle(style);
							
							cell26.setCellValue(costosTotalesDTO.getFlete().doubleValue());
							cell26.setCellStyle(style);
							
							cell27.setCellValue(costosTotalesDTO.getCodHacienda());
							cell27.setCellStyle(style);
							
							cell28.setCellValue(costosTotalesDTO.getCodSuerte());
							cell28.setCellStyle(style);
							
							cell29.setCellValue(costosTotalesDTO.getHorometroAbastecimiento().doubleValue());
							cell29.setCellStyle(style);
							
							cell30.setCellValue(costosTotalesDTO.getCodUbicacionAlmacen());
							cell30.setCellStyle(style);
							
						//	cell20.setCellValue(d1);
							//cell21.setCellValue(d2);

							pos_i++;

						}

					//	int numFilas = data.size() + 1;

					//	for (int i = 0; i < numFilas; i++) {
					//		sheet.autoSizeColumn(i);
					//	}

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoInventarioDocumentoKardexMp.xlsx");

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
		try {
			if (data == null) {
				data = businessDelegator2View.pr_compra_productos(null, null, null, null, null, null );
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

	public List<String> getSelectedEtapaId() {
		return selectedEtapaId;
	}

	public void setSelectedEtapaId(List<String> selectedEtapaId) {
		this.selectedEtapaId = selectedEtapaId;
	}

	public List<Etapa> getEtapa() {
		if (etapas == null || etapas.size() == 0) {

			etapas = new ArrayList<Etapa>();

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
			Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="};
			
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

			almacenes = new ArrayList<Almacen>();

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

			conceptoKardexs = new ArrayList<ConceptoKardex>();

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

				conceptoKardex = businessDelegator2View.getConceptoKardex(); // Fin
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

	public void setData(List<ConsultaCompraProductosDTO> data) {
		this.data = data;
	}

	public InputText getTxtDocumentoFactura() {
		return txtDocumentoFactura;
	}

	public void setTxtDocumentoFactura(InputText txtDocumentoFactura) {
		this.txtDocumentoFactura = txtDocumentoFactura;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
	
	
	
}
