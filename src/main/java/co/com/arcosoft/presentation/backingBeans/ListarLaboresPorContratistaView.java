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

import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.NominaDetalladaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ListarLaboresPorContratistaView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarLaboresPorContratistaView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private List<NominaDetalladaDTO> dataDetalle;
	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtCantidadAcumulado;

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;
	
	private StreamedContent file = null;	
	private String visible = "hidden";
	private String disableButton = "true";

	public ListarLaboresPorContratistaView() {
		super();
	}

	public void listarPlanillaNominaDetallada() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long flagLabor = 1L;
			String laboresSeleccionadas = "0";
			if (selectedLabor != null && selectedLabor.size() > 0) {
				laboresSeleccionadas = selectedLabor.get(0);
				flagLabor = 0L;
				for (int i = 1; i < selectedLabor.size(); i++) {
					laboresSeleccionadas += "," + selectedLabor.get(i);
				}
			}

			Long flagContratista = 1L;
			String contratistasSeleccionados = "0";
			if (selectedContratista != null && selectedContratista.size() > 0) {
				contratistasSeleccionados = selectedContratista.get(0);
				flagContratista = 0L;
				for (int i = 1; i < selectedContratista.size(); i++) {
					contratistasSeleccionados += "," + selectedContratista.get(i);
				}
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && fechaInicial != null && fechaFinal != null) {

				dataDetalle = businessDelegatorView.consultarInformeNominaDetallada(compania, fechaInicial, fechaFinal,
					"0", 1L, "0", 1L, "0", 1L, "0", 1L, laboresSeleccionadas, flagLabor, "0", 1L, "0", 1L, "0", 1L, 
					contratistasSeleccionados, flagContratista, "0", 1L, "0", 0L, 1L, "0", "MANO DE OBRA", "Contratistas");
			}

			double totalUnidades = 0;
			double totalCosto = 0;
			if (dataDetalle != null && dataDetalle.size() >= 0) {
				for (NominaDetalladaDTO data1 : dataDetalle) {
					totalUnidades += data1.getCantidadPago().doubleValue();
					totalCosto += data1.getValorTotal().doubleValue();
				}
			}

			txtValorTotalAcumulado.setValue(totalCosto);
			txtCantidadAcumulado.setValue(totalUnidades);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportToPyGExcel() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long flagLabor = 1L;
			String laboresSeleccionadas = "0";
			if (selectedLabor != null && selectedLabor.size() > 0) {
				laboresSeleccionadas = selectedLabor.get(0);
				flagLabor = 0L;
				for (int i = 1; i < selectedLabor.size(); i++) {
					laboresSeleccionadas += "," + selectedLabor.get(i);
				}
			}

			Long flagContratista = 1L;
			String contratistasSeleccionados = "0";
			if (selectedContratista != null && selectedContratista.size() > 0) {
				contratistasSeleccionados = selectedContratista.get(0);
				flagContratista = 0L;
				for (int i = 1; i < selectedContratista.size(); i++) {
					contratistasSeleccionados += "," + selectedContratista.get(i);
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
							+ "LaboresPorContratista.xlsx";

					data = businessDelegatorView.consultarInformeNominaDetallada(compania, fechaInicial, fechaFinal,
						"0", 1L, "0", 1L, "0", 1L, "0", 1L, laboresSeleccionadas, flagLabor, "0", 1L, "0", 1L, "0", 1L, 
						contratistasSeleccionados, flagContratista, "0", 1L, "0", 0L, 1L, "0","MANO DE OBRA", "Contratistas");

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
							cell = row.createCell(1);  cell.setCellStyle(style2); cell.setCellValue("LABOR");
							cell = row.createCell(2);  cell.setCellStyle(style2); cell.setCellValue("UNIDAD DE MEDIDA");
							cell = row.createCell(3);  cell.setCellStyle(style2); cell.setCellValue("HORAS");
							cell = row.createCell(4);  cell.setCellStyle(style2); cell.setCellValue("CODIGO CONCEPTO DE NOMINA");
							cell = row.createCell(5);  cell.setCellStyle(style2); cell.setCellValue("NOMBRE CONCEPTO DE NOMINA");
							cell = row.createCell(6);  cell.setCellStyle(style2); cell.setCellValue("VR. UNITARIO");
							cell = row.createCell(7);  cell.setCellStyle(style2); cell.setCellValue("SUBTOTAL");
							cell = row.createCell(8);  cell.setCellStyle(style2); cell.setCellValue("HACIENDA");
							cell = row.createCell(9);  cell.setCellStyle(style2); cell.setCellValue("LOTE");
							cell = row.createCell(10); cell.setCellStyle(style2); cell.setCellValue("FICHA");
							cell = row.createCell(11); cell.setCellStyle(style2); cell.setCellValue("CODIGO EMPRESA");
							cell = row.createCell(12); cell.setCellStyle(style2); cell.setCellValue("NOMBRE EMPRESA");
							cell = row.createCell(13); cell.setCellStyle(style2); cell.setCellValue("CONSECUTIVO");
							cell = row.createCell(14); cell.setCellStyle(style2); cell.setCellValue("ID");

							int pos_i = 8;

							for (NominaDetalladaDTO ndDTO : data) {

								row = sheet.createRow(pos_i); 
								cell = row.createCell(0);  cell.setCellValue(
										ndDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
										ndDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
										ndDTO.getFechaRegistro().toString().substring(0, 4));
								cell = row.createCell(1);  cell.setCellValue(ndDTO.getNomLabor());
								cell = row.createCell(2);  cell.setCellValue(ndDTO.getUnidadPago());
								cell = row.createCell(3);  cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
								cell = row.createCell(4);  cell.setCellValue(ndDTO.getCodConceptoNomina());
								cell = row.createCell(5);  cell.setCellValue(ndDTO.getNomConceptoNomina());
								cell = row.createCell(6);  cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
								cell = row.createCell(7);  cell.setCellValue(ndDTO.getValorTotal().doubleValue());
								cell = row.createCell(8);  cell.setCellValue(ndDTO.getNomHacienda());
								cell = row.createCell(9);  cell.setCellValue(ndDTO.getNomLote());
								cell = row.createCell(10); cell.setCellValue(ndDTO.getFicha());
								cell = row.createCell(11); cell.setCellValue(ndDTO.getCod_empresa());
								cell = row.createCell(12); cell.setCellValue(ndDTO.getNomEmpresa());
								cell = row.createCell(13); cell.setCellValue(ndDTO.getConsecutivo().longValue());
								cell = row.createCell(14); cell.setCellValue(ndDTO.getDetPlanillaNominaId().longValue());

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

							file = new DefaultStreamedContent(stream, "application/xlsx", "LaboresPorContratista.xlsx");

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

	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public List<PersEmpr> getContratistas() {

		if (contratistas == null || contratistas.size() == 0) {

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

	public List<NominaDetalladaDTO> getDataDetalle() {
		return dataDetalle;
	}

	public void setDataDetalle(List<NominaDetalladaDTO> dataDetalle) {
		this.dataDetalle = dataDetalle;
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
}