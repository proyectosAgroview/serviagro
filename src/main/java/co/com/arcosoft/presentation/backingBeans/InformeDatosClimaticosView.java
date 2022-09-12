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
import org.primefaces.model.chart.LineChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.EstClimat;
import co.com.arcosoft.modelo.informes.dto.DatosClimaticosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeDatosClimaticosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeDatosClimaticosView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private LineChartModel lineModel1;
	private boolean showDialog;

	// private List<DatosClimaticosDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<DatosClimaticosDTO> data;

	private SelectOneMenu txtEstClimatId_EstClimat;
	SelectItem[] selectEstClima;
	private List<EstClimat> estClima;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";
	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	public InformeDatosClimaticosView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public String exportToPyGExcel() {

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
		Long estClima = (FacesUtils.checkLong(txtEstClimatId_EstClimat));

		if (compania != null) {
			try {

				List<DatosClimaticosDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "DatosClimaticos.xlsx";

				data = businessDelegatorView.consultarInformeDatosClimaticos(compania, estClima, fechaInicial,
						fechaFinal);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(5);
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
						columna1.setCellValue("ESTACION");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("FECHA_LLUVIA");
						columna2.setCellStyle(style2);
						Cell columna3 = row.createCell(2);
						columna3.setCellValue("AÑO");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("MES");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("PRECIPITACION");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("TEMPERATURA_MAXIMA");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("TEMPERATURA_MEDIA");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("TEMPERATURA_MINIMA");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("TEMPERATURA_AMBIENTE");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("SENSACION_TERMICA");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("HUMEDAD_MAXIMA");
						columna11.setCellStyle(style2);
						Cell columna12 = row.createCell(11);
						columna12.setCellValue("HUMEDAD_MEDIA");
						columna12.setCellStyle(style2);
						Cell columna13 = row.createCell(12);
						columna13.setCellValue("HUMEDAD_MINIMA");
						columna13.setCellStyle(style2);
						Cell columna14 = row.createCell(13);
						columna14.setCellValue("HUMEDAD_EXTERIOR");
						columna14.setCellStyle(style2);
						Cell columna15 = row.createCell(14);
						columna15.setCellValue("HUMEDAD_INTERIOR");
						columna15.setCellStyle(style2);
						Cell columna16 = row.createCell(15);
						columna16.setCellValue("EVAPORACION");
						columna16.setCellStyle(style2);
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("EVAPOTRANSPIRACION");
						columna17.setCellStyle(style2);
						Cell columna18 = row.createCell(17);
						columna18.setCellValue("INSOLACION");
						columna18.setCellStyle(style2);
						Cell columna19 = row.createCell(18);
						columna19.setCellValue("ENERGIA_SOLAR");
						columna19.setCellStyle(style2);
						Cell columna20 = row.createCell(19);
						columna20.setCellValue("RADIACION_SOLAR");
						columna20.setCellStyle(style2);
						Cell columna21 = row.createCell(20);
						columna21.setCellValue("NUBOSIDAD");
						columna21.setCellStyle(style2);
						Cell columna22 = row.createCell(21);
						columna22.setCellValue("HORAS_SOL");
						columna22.setCellStyle(style2);
						Cell columna23 = row.createCell(22);
						columna23.setCellValue("PUNTO_ROCIO");
						columna23.setCellStyle(style2);
						Cell columna24 = row.createCell(23);
						columna24.setCellValue("VELOCIDAD_VIENTO");
						columna24.setCellStyle(style2);
						Cell columna25 = row.createCell(24);
						columna25.setCellValue("VELOCIDAD_MAXIMA");
						columna25.setCellStyle(style2);
						Cell columna26 = row.createCell(25);
						columna26.setCellValue("DIRECCION_VIENTO");
						columna26.setCellStyle(style2);
						Cell columna27 = row.createCell(26);
						columna27.setCellValue("GRADOS_DIA_CALOR");
						columna27.setCellStyle(style2);
						Cell columna28 = row.createCell(27);
						columna28.setCellValue("GRADOS_DIA_FRIO");
						columna28.setCellStyle(style2);
						Cell columna29 = row.createCell(28);
						columna29.setCellValue("HORAS_LUZ");
						columna29.setCellStyle(style2);
						Cell columna30 = row.createCell(29);
						columna30.setCellValue("OBSERVACION");
						columna30.setCellStyle(style2);

						int pos_i = 6;

						for (DatosClimaticosDTO ndDTO : data) {

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

							cell1.setCellValue(ndDTO.getNom_estacion_clima());
							cell1.setCellStyle(style3);
							cell2.setCellValue(ndDTO.getFecha_lluvia().toString().substring(0, 10));
							cell2.setCellStyle(style3);
							cell3.setCellValue(ndDTO.getAnio().doubleValue());
							cell3.setCellStyle(style3);
							cell4.setCellValue(ndDTO.getMes_corto());
							cell4.setCellStyle(style3);
							cell5.setCellValue(ndDTO.getPrecipitacion().doubleValue());
							cell5.setCellStyle(style3);
							cell6.setCellValue(ndDTO.getTemperatura_maxima().doubleValue());
							cell6.setCellStyle(style3);
							cell7.setCellValue(ndDTO.getTemperatura_media().doubleValue());
							cell7.setCellStyle(style3);
							cell8.setCellValue(ndDTO.getTemperatura_minima().doubleValue());
							cell8.setCellStyle(style3);
							cell9.setCellValue(ndDTO.getTemperatura_ambiente().doubleValue());
							cell9.setCellStyle(style3);
							cell10.setCellValue(ndDTO.getSensacion_termica().doubleValue());
							cell10.setCellStyle(style3);
							cell11.setCellValue(ndDTO.getHumedad_maxima().doubleValue());
							cell11.setCellStyle(style3);
							cell12.setCellValue(ndDTO.getHumedad_media().doubleValue());
							cell12.setCellStyle(style3);
							cell13.setCellValue(ndDTO.getHumedad_minima().doubleValue());
							cell13.setCellStyle(style3);
							cell14.setCellValue(ndDTO.getHumedad_exterior().doubleValue());
							cell14.setCellStyle(style3);
							cell15.setCellValue(ndDTO.getHumedad_interior().doubleValue());
							cell15.setCellStyle(style3);
							cell16.setCellValue(ndDTO.getEvaporacion().doubleValue());
							cell16.setCellStyle(style3);
							cell17.setCellValue(ndDTO.getEvaporacion_transpiracion().doubleValue());
							cell17.setCellStyle(style3);
							cell18.setCellValue(ndDTO.getInsolacion().doubleValue());
							cell18.setCellStyle(style3);
							cell19.setCellValue(ndDTO.getEnergia_solar().doubleValue());
							cell19.setCellStyle(style3);
							cell20.setCellValue(ndDTO.getRadiacion_solar().doubleValue());
							cell20.setCellStyle(style3);
							cell21.setCellValue(ndDTO.getNubosidad().doubleValue());
							cell21.setCellStyle(style3);
							cell22.setCellValue(ndDTO.getHoras_sol().doubleValue());
							cell22.setCellStyle(style3);
							cell23.setCellValue(ndDTO.getPunto_rocio().doubleValue());
							cell23.setCellStyle(style3);
							cell24.setCellValue(ndDTO.getVelocidad_viento().doubleValue());
							cell24.setCellStyle(style3);
							cell25.setCellValue(ndDTO.getVelocidad_maxima().doubleValue());
							cell25.setCellStyle(style3);
							cell26.setCellValue(ndDTO.getDireccion_viento().doubleValue());
							cell26.setCellStyle(style3);
							cell27.setCellValue(ndDTO.getGrados_dia_calor().doubleValue());
							cell27.setCellStyle(style3);
							cell28.setCellValue(ndDTO.getGrados_dia_frio().doubleValue());
							cell28.setCellStyle(style3);
							cell29.setCellValue(ndDTO.getHoras_luz().doubleValue());
							cell29.setCellStyle(style3);
							cell30.setCellValue(ndDTO.getObservacion());
							cell30.setCellStyle(style3);

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "DatosClimaticos.xlsx");

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

	public List<DatosClimaticosDTO> getData() {
		try {
			Long estClima = FacesUtils.checkLong(txtEstClimatId_EstClimat);
			Long compania = FacesUtils.checkLong(txtCompania);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			// fechaFinal = sdf.parse("2015-12-31");
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			if (estClima != null) {
				data = businessDelegatorView.consultarInformeDatosClimaticos(compania, estClima, fechaInicial,
						fechaFinal);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public SelectOneMenu getTxtEstClimatId_EstClimat() {
		return txtEstClimatId_EstClimat;
	}

	public void setTxtEstClimatId_EstClimat(SelectOneMenu txtEstClimatId_EstClimat) {
		this.txtEstClimatId_EstClimat = txtEstClimatId_EstClimat;
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

	public SelectItem[] getSelectEstClima() {

		if (estClima == null || estClima.size() == 0) {

			estClima = new ArrayList<EstClimat>();

			try {

				estClima = businessDelegatorView.getEstClimat(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstClimat> lista = businessDelegatorView.findByCriteriaInEstClimat(condicion, null, null);
				selectEstClima = new SelectItem[lista.size()];

				int i = 0;
				for (EstClimat clima : lista) {
					selectEstClima[i] = new SelectItem(clima.getEstClimatId(), clima.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEstClima;
	}

	public void setSelectEstClima(SelectItem[] selectEstClima) {
		this.selectEstClima = selectEstClima;
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

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public void setData(List<DatosClimaticosDTO> data) {
		this.data = data;
	}

}
