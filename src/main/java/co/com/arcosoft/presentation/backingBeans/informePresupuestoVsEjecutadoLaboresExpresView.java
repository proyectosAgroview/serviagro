package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import co.com.arcosoft.modelo.CronogramaLabores;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.ProyeccionLaboresLoteDTO;
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
public class informePresupuestoVsEjecutadoLaboresExpresView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(informePresupuestoVsEjecutadoLaboresExpresView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ProyeccionLaboresLoteDTO> data;

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private List<String> selectCultivo;
	private List<Cultivo> cultivos;

	private List<String> selectSupervisor;
	private List<Trabajador> supervisores;

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

	private List<String> selectedCronogramaLabores;
	private List<CronogramaLabores> cronogramasLabores;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "true";
	private String visible = "hidden";
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	

	public informePresupuestoVsEjecutadoLaboresExpresView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public String exportToPyGExcel() throws NumberFormatException, Exception {

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

		// String zona = "1";
		String finca = "1";
		String bloque = "5";
		String lote = "20";
		String labor = "586";
		String unidadMedida = "30";
		String grupoLabor = "6";
		String tenencia = "2";
		Long flagZona = 1L;
		Long flagFinca = 1L;
		Long flagBloque = 1L;
		Long flagLote = 1L;
		Long flagLabor = 1L;
		Long flagUnidadMedida = 1L;
		Long flagGrupoLabor = 1L;
		Long flagTenencia = 1L;
		Long flagNumeroCosechas = 1L;
		Long flagCronogramaLabores = 1L;
		Long flagCultivo = 1L;

		String zonasSeleccionadas = "";
		if (selectedNivel1 != null && selectedNivel1.size() > 0) {
			zonasSeleccionadas = selectedNivel1.get(0);
			flagZona = 0L;
			for (int i = 1; i < selectedNivel1.size(); i++) {
				zonasSeleccionadas += "," + selectedNivel1.get(i);
			}
		}

		String fincasSeleccionadas = "";
		if (selectedNivel2 != null && selectedNivel2.size() > 0) {
			fincasSeleccionadas = selectedNivel2.get(0);
			flagFinca = 0L;
			for (int i = 1; i < selectedNivel2.size(); i++) {
				fincasSeleccionadas += "," + selectedNivel2.get(i);
			}
		}

		String bloquesSeleccionadas = "";
		if (selectedNivel3 != null && selectedNivel3.size() > 0) {
			bloquesSeleccionadas = selectedNivel3.get(0);
			flagBloque = 0L;
			for (int i = 1; i < selectedNivel3.size(); i++) {
				bloquesSeleccionadas += "," + selectedNivel3.get(i);
			}
		}

		String lotesSeleccionadas = "";
		if (selectedNivel4 != null && selectedNivel4.size() > 0) {
			lotesSeleccionadas = selectedNivel4.get(0);
			flagLote = 0L;
			for (int i = 1; i < selectedNivel4.size(); i++) {
				lotesSeleccionadas += "," + selectedNivel4.get(i);
			}
		}

		String laboresSeleccionadas = "";
		if (selectedLabor != null && selectedLabor.size() > 0) {
			laboresSeleccionadas = selectedLabor.get(0);
			flagLabor = 0L;
			for (int i = 1; i < selectedLabor.size(); i++) {
				laboresSeleccionadas += "," + selectedLabor.get(i);
			}
		}

		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}

		String grupoLaboresSeleccionadas = "";
		if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
			grupoLaboresSeleccionadas = selectedGrupoLabor.get(0);
			flagGrupoLabor = 0L;
			for (int i = 1; i < selectedGrupoLabor.size(); i++) {
				grupoLaboresSeleccionadas += "," + selectedGrupoLabor.get(i);
			}
		}

		String tenenciasSeleccionadas = "";
		if (selectedTenencia != null && selectedTenencia.size() > 0) {
			tenenciasSeleccionadas = selectedTenencia.get(0);
			flagTenencia = 1L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String cronogramaLaboresSeleccionadas = "";
		if (selectedCronogramaLabores != null && selectedCronogramaLabores.size() > 0) {
			cronogramaLaboresSeleccionadas = selectedCronogramaLabores.get(0);
			flagCronogramaLabores = 0L;
			for (int i = 1; i < selectedCronogramaLabores.size(); i++) {
				cronogramaLaboresSeleccionadas += "," + selectedCronogramaLabores.get(i);
			}
		}

		String cultivosSeleccionadas = "";
		if (selectCultivo != null && selectCultivo.size() > 0) {
			cultivosSeleccionadas = selectCultivo.get(0);
			flagCultivo = 0L;
			for (int i = 1; i < selectCultivo.size(); i++) {
				cultivosSeleccionadas += "," + selectCultivo.get(i);
			}
		}

		if (compania != null) {
			try {
				List<ProyeccionLaboresLoteDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "presupuestoVsEjecutadoExpres.xlsx";

				data = businessDelegator2View.pr_presupuesto_vs_ejecutado(compania, fechaInicial,
						fechaFinal, "0", 1l, zonasSeleccionadas, flagZona,
						fincasSeleccionadas, flagFinca, bloquesSeleccionadas, flagBloque, lotesSeleccionadas, flagLote,
						laboresSeleccionadas, flagLabor, "0", 1l,
						grupoLaboresSeleccionadas, flagGrupoLabor, "0", 1l,
						cronogramaLaboresSeleccionadas, flagCronogramaLabores);

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

						Cell columna1 = row.createCell(0);
						columna1.setCellValue("LABOR");
						columna1.setCellStyle(style2);
						Cell columna2 = row.createCell(1);
						columna2.setCellValue("COD_ZONA");
						columna2.setCellStyle(style2);
						Cell columna3 = row.createCell(2);
						columna3.setCellValue("NOM_ZONA");
						columna3.setCellStyle(style2);
						Cell columna4 = row.createCell(3);
						columna4.setCellValue("COD_HACIENDA");
						columna4.setCellStyle(style2);
						Cell columna5 = row.createCell(4);
						columna5.setCellValue("NOM_HACIENDA");
						columna5.setCellStyle(style2);
						Cell columna6 = row.createCell(5);
						columna6.setCellValue("COD_BLOQUE");
						columna6.setCellStyle(style2);
						Cell columna7 = row.createCell(6);
						columna7.setCellValue("NOM_BLOQUE");
						columna7.setCellStyle(style2);
						Cell columna8 = row.createCell(7);
						columna8.setCellValue("COD_LOTE");
						columna8.setCellStyle(style2);
						Cell columna9 = row.createCell(8);
						columna9.setCellValue("NOM_LOTE");
						columna9.setCellStyle(style2);
						Cell columna10 = row.createCell(9);
						columna10.setCellValue("NOM_VARIEDAD");
						columna10.setCellStyle(style2);
						Cell columna11 = row.createCell(10);
						columna11.setCellValue("NOM_ETAPA");
						columna11.setCellStyle(style2);
						Cell columna12 = row.createCell(11);
						columna12.setCellValue("AREA_NETA");
						columna12.setCellStyle(style2);
						Cell columna13 = row.createCell(12);
						columna13.setCellValue("NUMERO_PLANTAS");
						columna13.setCellStyle(style2);
						Cell columna14 = row.createCell(13);
						columna14.setCellValue("TRABAJAR_CON_AREA_PLANTAS");
						columna14.setCellStyle(style2);
						Cell columna15 = row.createCell(14);
						columna15.setCellValue("TARIFA");
						columna15.setCellStyle(style2);
						Cell columna16 = row.createCell(15);
						columna16.setCellValue("VALOR_PRESUPUESTADO");
						columna16.setCellStyle(style2);
						Cell columna17 = row.createCell(16);
						columna17.setCellValue("A??O-MES");
						columna17.setCellStyle(style2);
						Cell columna18 = row.createCell(17);
						columna18.setCellValue("FECHA INICIAL");
						columna18.setCellStyle(style2);
						Cell columna19 = row.createCell(18);
						columna19.setCellValue("FECHA FINAL");
						columna19.setCellStyle(style2);
						Cell columna20 = row.createCell(19);
						columna20.setCellValue("DURACI??N");
						columna20.setCellStyle(style2);
						Cell columna21 = row.createCell(20);
						columna21.setCellValue("NOMBRE DE SECUENCIA");
						columna21.setCellStyle(style2);
						Cell columna22 = row.createCell(21);
						columna22.setCellValue("ORIGEN");
						columna22.setCellStyle(style2);
						
						Cell columna23 = row.createCell(22);
						columna23.setCellValue("VALOR_EJECUTADO");
						columna23.setCellStyle(style2);
						
						Cell columna24 = row.createCell(23);
						columna24.setCellValue("GRUPO LABOR");
						columna24.setCellStyle(style2);
						
						
						int pos_i = 6;

						for (ProyeccionLaboresLoteDTO proyeccionLaboresLoteDTO : data) {

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

							cell1.setCellValue(proyeccionLaboresLoteDTO.getNombreLabor());
							cell1.setCellStyle(style);
							cell2.setCellValue(proyeccionLaboresLoteDTO.getCod_zona());
							cell2.setCellStyle(style);
							cell3.setCellValue(proyeccionLaboresLoteDTO.getNom_zona());
							cell3.setCellStyle(style);
							cell4.setCellValue(proyeccionLaboresLoteDTO.getCod_hacienda());
							cell4.setCellStyle(style);
							cell5.setCellValue(proyeccionLaboresLoteDTO.getNom_hacienda());
							cell5.setCellStyle(style);
							cell6.setCellValue(proyeccionLaboresLoteDTO.getCod_bloque());
							cell6.setCellStyle(style);
							cell7.setCellValue(proyeccionLaboresLoteDTO.getNom_bloque());
							cell7.setCellStyle(style);
							cell8.setCellValue(proyeccionLaboresLoteDTO.getCod_lote());
							cell8.setCellStyle(style);
							cell9.setCellValue(proyeccionLaboresLoteDTO.getNom_lote());
							cell9.setCellStyle(style);
							cell10.setCellValue(proyeccionLaboresLoteDTO.getNom_variedad());
							cell10.setCellStyle(style);
							cell11.setCellValue(proyeccionLaboresLoteDTO.getNom_etapa());
							cell11.setCellStyle(style);
							cell12.setCellValue(proyeccionLaboresLoteDTO.getArea_neta().doubleValue());
							cell12.setCellStyle(style);
							cell13.setCellValue(proyeccionLaboresLoteDTO.getNumero_plantas().doubleValue());
							cell13.setCellStyle(style);
							cell14.setCellValue(proyeccionLaboresLoteDTO.getTrabajar_con_area_plantas());
							cell14.setCellStyle(style);
							cell15.setCellValue(proyeccionLaboresLoteDTO.getValor_unit_recurso().doubleValue());
							cell15.setCellStyle(style);
							cell16.setCellValue(proyeccionLaboresLoteDTO.getValor_presupuestado().doubleValue());
							cell16.setCellStyle(style);
							cell17.setCellValue(proyeccionLaboresLoteDTO.getAnio_mes());
							cell17.setCellStyle(style);

							cell18.setCellValue(proyeccionLaboresLoteDTO.getFechaInicial().toString().substring(0, 10));
							cell18.setCellStyle(style);
							cell19.setCellValue(proyeccionLaboresLoteDTO.getFechaFinal().toString().substring(0, 10));
							cell19.setCellStyle(style);
							cell20.setCellValue(proyeccionLaboresLoteDTO.getDuracion().doubleValue());
							cell20.setCellStyle(style);
							cell21.setCellValue(proyeccionLaboresLoteDTO.getNombreSecuencia());
							cell21.setCellStyle(style);
							cell22.setCellValue(proyeccionLaboresLoteDTO.getOrigen());
							cell22.setCellStyle(style);
							cell23.setCellValue(proyeccionLaboresLoteDTO.getValor_ejecutado().doubleValue());
							cell23.setCellStyle(style);
							cell24.setCellValue(proyeccionLaboresLoteDTO.getNombreGrupoLabor());
							cell24.setCellStyle(style);

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "presupuestoVsEjecutadoExpres.xlsx");

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

	public List<ProyeccionLaboresLoteDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.consultarInformeProyeccionLaboresLoteDet(1L, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
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

	public List<String> getSelectCultivo() {
		return selectCultivo;
	}

	public void setSelectCultivo(List<String> selectCultivo) {
		this.selectCultivo = selectCultivo;
	}

	public List<Cultivo> getCultivos() {

		if (cultivos == null || cultivos.size() == 0) {


			try {
				cultivos = businessDelegatorView.getCultivo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return cultivos;
	}

	public void setCultivos(List<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}

	public List<String> getselectedCronogramaLabores() {
		return selectedCronogramaLabores;
	}

	public void setselectedCronogramaLabores(List<String> selectedCronogramaLabores) {
		this.selectedCronogramaLabores = selectedCronogramaLabores;
	}

	public List<CronogramaLabores> getCronogramasLabores() {
		if (cronogramasLabores == null || cronogramasLabores.size() == 0) {


			try {
				cronogramasLabores = businessDelegatorView.getCronogramaLabores();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return cronogramasLabores;
	}

	public void setcronogramasLabores(List<CronogramaLabores> cronogramasLabores) {
		this.cronogramasLabores = cronogramasLabores;
	}
	
	public String getLoginSession() throws Exception {

		FacesContext fc = FacesContext.getCurrentInstance();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
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
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(
				condicion, null, null);

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
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(
				condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				usuarioId = usuarios.getUsuarioId().toString();
			}
		}

		return usuarioId;
	}

}
