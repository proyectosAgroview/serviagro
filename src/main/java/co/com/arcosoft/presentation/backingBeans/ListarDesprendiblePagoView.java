package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.NominaDetalladaDTO;
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
public class ListarDesprendiblePagoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarDesprendiblePagoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;	

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtCantidadAcumulado;

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;

	private List<String> selectedTrabajador;
	private List<Trabajador> trabajadores;
	
	private StreamedContent file = null;	
	private String visible = "hidden";
	private String disableButton = "true";

	public ListarDesprendiblePagoView() {
		super();
	}

	public void exportToPyGExcel() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long flagTrabajador = 1L;
			String trabajadoresSeleccionados = "0";
			if (selectedTrabajador != null && selectedTrabajador.size() > 0) {
				trabajadoresSeleccionados = selectedTrabajador.get(0);
				flagTrabajador = 0L;
				for (int i = 1; i < selectedTrabajador.size(); i++) {
					trabajadoresSeleccionados += "," + selectedTrabajador.get(i);
				}
			}

			Long compania = new Long(getCompaniaIdSession());

			if (compania != null) {
				try {

					List<NominaDetalladaDTO> data = null;
					InputStream stream = null;
					String filename = " ";

					FacesContext context = FacesContext.getCurrentInstance();
					ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
							.getExternalContext().getContext();

					filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
							+ "LiquidacionNomina.xlsx";

					data = businessDelegator2View.pr_desprendible_pago_agricola(compania, fechaInicial, fechaFinal, trabajadoresSeleccionados, flagTrabajador);

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

							cell = row.createCell(0);  cell.setCellStyle(style2); cell.setCellValue("FECHA");
							cell = row.createCell(1);  cell.setCellStyle(style2); cell.setCellValue("FICHA");
							cell = row.createCell(2);  cell.setCellStyle(style2); cell.setCellValue("CEDULA");
							cell = row.createCell(3);  cell.setCellStyle(style2); cell.setCellValue("NOMBRE TRABAJADOR");
							cell = row.createCell(4);  cell.setCellStyle(style2); cell.setCellValue("EMPRESA");
							cell = row.createCell(5);  cell.setCellStyle(style2); cell.setCellValue("CODIGO CONCEPTO DE NOMINA");
							cell = row.createCell(6);  cell.setCellStyle(style2); cell.setCellValue("NOMBRE CONCEPTO DE NOMINA");
							cell = row.createCell(7);  cell.setCellStyle(style2); cell.setCellValue("CANTIDAD PAGO");
							cell = row.createCell(8);  cell.setCellStyle(style2); cell.setCellValue("DEVENGO");
							cell = row.createCell(9);  cell.setCellStyle(style2); cell.setCellValue("DEDUCCIÓN");
							cell = row.createCell(10); cell.setCellStyle(style2); cell.setCellValue("TIPO DE MOVIMIENTO");
							cell = row.createCell(11); cell.setCellStyle(style2); cell.setCellValue("COMPANIA");
							cell = row.createCell(12); cell.setCellStyle(style2); cell.setCellValue("NOMBRE COMAPNIA");
							cell = row.createCell(13); cell.setCellStyle(style2); cell.setCellValue("PROFESIÓN");

							int pos_i = 8;

							for (NominaDetalladaDTO ndDTO : data) {

								row = sheet.createRow(pos_i); 
								cell = row.createCell(0);  cell.setCellValue(
										ndDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
										ndDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
										ndDTO.getFechaRegistro().toString().substring(0, 4));
								cell = row.createCell(1);  cell.setCellValue(ndDTO.getFicha());
								cell = row.createCell(2);  cell.setCellValue(ndDTO.getCedula());
								cell = row.createCell(3);  cell.setCellValue(ndDTO.getTrabajador());
								cell = row.createCell(4);  cell.setCellValue(ndDTO.getNomEmpresa());								
								cell = row.createCell(5);  cell.setCellValue(ndDTO.getCodConceptoNomina());
								cell = row.createCell(6);  cell.setCellValue(ndDTO.getNomConceptoNomina());
								
								cell = row.createCell(7);  cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
								cell = row.createCell(8);  cell.setCellValue(ndDTO.getDevengo().doubleValue());
								cell = row.createCell(9);  cell.setCellValue(ndDTO.getDeduccion().doubleValue());
								cell = row.createCell(10); cell.setCellValue(ndDTO.getTipoMovimiento());
								cell = row.createCell(11); cell.setCellValue(ndDTO.getCompania().longValue());
								cell = row.createCell(12); cell.setCellValue(ndDTO.getNomCompania());
								cell = row.createCell(13); cell.setCellValue(ndDTO.getNomProfesion());

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

							stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext()
									.getContext()).getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

							file = new DefaultStreamedContent(stream, "application/xlsx", "LiquidacionNomina.xlsx");

							context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
									"El informe se ha generado con exito, ahora puedes Descargar el informe"));

							visible = "visible";
							disableButton = "false";

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getLoginSession() throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;

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

	public List<String> getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(List<String> selectedTrabajador) {
		this.selectedTrabajador = selectedTrabajador;
	}

	public List<Trabajador> getTrabajadores() {

		if (trabajadores == null || trabajadores.size() == 0) {

			try {
				trabajadores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public Calendar getTxtFechaIni() {
		return txtFechaIni;
	}

	public void setTxtFechaIni(Calendar txtFechaIni) {
		this.txtFechaIni = txtFechaIni;
	}

	public Calendar getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(Calendar txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public InputNumber getTxtCantidadAcumulado() {
		return txtCantidadAcumulado;
	}

	public void setTxtCantidadAcumulado(InputNumber txtCantidadAcumulado) {
		this.txtCantidadAcumulado = txtCantidadAcumulado;
	}
	
	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		if (file != null) {
			this.file = file;
		}
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
}