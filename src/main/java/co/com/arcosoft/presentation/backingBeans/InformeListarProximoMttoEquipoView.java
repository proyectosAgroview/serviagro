package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class InformeListarProximoMttoEquipoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InformeListarProximoMttoEquipoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
	private boolean showDialog;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ListadoProximosMttoEquiposDTO> data;

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

	private List<String> selectedPlanRevision;
	private List<PlanRevisionEquipo> planRevision;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";
	private String moduloActivo;
	private String origendatos;
	private SelectOneMenu txtEstadoPlan;
	

	public InformeListarProximoMttoEquipoView() {
		super();
	}

	public String action_informe() {
		moduloSeleccionado();
		setShowDialog(true);
		return "";
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();

			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			origendatos = "Modulo_TallerAgricola";

		} else {

			origendatos = "Modulo_MttoIndustrial";

		}
	}

	public void consultarProxMtto() {
		try {

			Long compania = new Long(getCompaniaIdSession());
			Long flagEquipo = 1L;
			Long flagPlanRevision = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = String.valueOf( selectedEquipo.get(0));
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += " , " + selectedEquipo.get(i);
				}
			}

			String planSeleccionados = "";
			if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
				planSeleccionados = selectedPlanRevision.get(0);
				flagPlanRevision = 0L;
				for (int i = 1; i < selectedPlanRevision.size(); i++) {
					planSeleccionados += "," + selectedPlanRevision.get(i);
				}
			}

			if (compania != null) {

				data = businessDelegatorView.consultarListaProximosMttoEquipos(compania, equiposSeleccionadas,
						flagEquipo, planSeleccionados, flagPlanRevision, "Modulo_TallerAgricola");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	
	public void consultarProxMttoIndustrial() {
		try {

			Long compania = new Long(getCompaniaIdSession());
			Long flagEquipo = 1L;
			Long flagPlanRevision = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = String.valueOf(selectedEquipo.get(0)) ;
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += " , " + selectedEquipo.get(i);
				}
			}

			String planSeleccionados = "";
			if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
				planSeleccionados = selectedPlanRevision.get(0);
				flagPlanRevision = 0L;
				for (int i = 1; i < selectedPlanRevision.size(); i++) {
					planSeleccionados += "," + selectedPlanRevision.get(i);
				}
			}

			if (compania != null) {

				data = businessDelegatorView.consultarListaProximosMttoEquipos(compania, equiposSeleccionadas,
						flagEquipo, planSeleccionados, flagPlanRevision, "Modulo_MttoIndustrial");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public String exportProyeccionMtto() throws NumberFormatException, Exception {
		
		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;
		Long flagPlanRevision = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += " , " + selectedEquipo.get(i);
			}
		}

		String planSeleccionados = "";
		if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
			planSeleccionados = selectedPlanRevision.get(0);
			flagPlanRevision = 0L;
			for (int i = 1; i < selectedPlanRevision.size(); i++) {
				planSeleccionados += "," + selectedPlanRevision.get(i);
			}
		}

		if (compania != null) {
			try {

				List<ListadoProximosMttoEquiposDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRListaProxMtto.xlsx";

				data = businessDelegatorView.consultarListaProximosMttoEquipos(compania, equiposSeleccionadas,
						flagEquipo, planSeleccionados, flagPlanRevision, "Modulo_TallerAgricola");

				
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

					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));
					
					
					String fechaI = "";
					String fechaF = "";
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

					if (data != null) {
						
						cell = row.createCell(0	);	cell.setCellValue(	"Equipo/Maquinaria"	);	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue(	"Plan Revisión"	);	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue(	"Periocidad (Hr/Km)"	);	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue(	"Fecha Ult. Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue(	"Hr/Km Ult. Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(5	);	cell.setCellValue(	"Hr/Km Actual"	);	cell.setCellStyle(style2);
						cell = row.createCell(6	);	cell.setCellValue(	"Hr/Km faltantes para Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(7	);	cell.setCellValue(	"Horas Próximo Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(8	);	cell.setCellValue(	"Km Próximo Mtto"	);	cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (ListadoProximosMttoEquiposDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							
							cell = row.createCell(0		);	cell.setCellValue(	ndDTO.getCod_equipo() +"-"+ndDTO.getNom_equipo());	cell.setCellStyle(style);	
							cell = row.createCell(1		);	cell.setCellValue(	ndDTO.getNombre_plan_revision());	cell.setCellStyle(style);	
							cell = row.createCell(2		);	cell.setCellValue(	ndDTO.getPeriocidad().doubleValue());	cell.setCellStyle(style);	
							fechaI = dateFormat.format(ndDTO.getFecha_ultimo_servicio());
							cell = row.createCell(3		);	cell.setCellValue(	fechaI);	cell.setCellStyle(style);	
							
							cell = row.createCell(4		);	cell.setCellValue(	ndDTO.getHorasUltMantenimiento().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(5		);	cell.setCellValue(	ndDTO.getHoro_odo_actual().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(6		);	cell.setCellValue(	ndDTO.getHor_odo_para_prox_mtto().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(7		);	cell.setCellValue(	ndDTO.getHoras_prox_mtto().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(8		);	cell.setCellValue(	ndDTO.getKm_prox_mtto().doubleValue());	cell.setCellStyle(style);	

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoSRListaProxMtto.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso, El informe se ha generado con exito, ahora puedes Descargar el informe",
								""));

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
	
	public String exportProyeccionMttoIndustrial() throws NumberFormatException, Exception {
		
		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;
		Long flagPlanRevision = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += " , " + selectedEquipo.get(i);
			}
		}

		String planSeleccionados = "";
		if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
			planSeleccionados = selectedPlanRevision.get(0);
			flagPlanRevision = 0L;
			for (int i = 1; i < selectedPlanRevision.size(); i++) {
				planSeleccionados += "," + selectedPlanRevision.get(i);
			}
		}

		if (compania != null) {
			try {

				List<ListadoProximosMttoEquiposDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRListaProxMtto.xlsx";

				data = businessDelegatorView.consultarListaProximosMttoEquipos(compania, equiposSeleccionadas,
						flagEquipo, planSeleccionados, flagPlanRevision, "Modulo_MttoIndustrial");

				
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

					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));

					String fechaI = "";
					String fechaF = "";
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					
					if (data != null) {
						
						cell = row.createCell(0	);	cell.setCellValue(	"Equipo/Maquinaria"	);	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue(	"Plan Revisión"	);	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue(	"Periocidad (Hr/Km)"	);	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue(	"Fecha Ult. Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue(	"Hr/Km Ult. Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(5	);	cell.setCellValue(	"Hr/Km Actual"	);	cell.setCellStyle(style2);
						cell = row.createCell(6	);	cell.setCellValue(	"Hr/Km faltantes para Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(7	);	cell.setCellValue(	"Horas Próximo Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(8	);	cell.setCellValue(	"Km Próximo Mtto"	);	cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (ListadoProximosMttoEquiposDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							
							cell = row.createCell(0		);	cell.setCellValue(	ndDTO.getCod_equipo() +"-"+ndDTO.getNom_equipo());	cell.setCellStyle(style);	
							cell = row.createCell(1		);	cell.setCellValue(	ndDTO.getNombre_plan_revision());	cell.setCellStyle(style);	
							cell = row.createCell(2		);	cell.setCellValue(	ndDTO.getPeriocidad().doubleValue());	cell.setCellStyle(style);	
							fechaI = dateFormat.format(ndDTO.getFecha_ultimo_servicio());
							cell = row.createCell(3		);	cell.setCellValue(	fechaI);	cell.setCellStyle(style);	
							cell = row.createCell(4		);	cell.setCellValue(	ndDTO.getHorasUltMantenimiento().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(5		);	cell.setCellValue(	ndDTO.getHoro_odo_actual().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(6		);	cell.setCellValue(	ndDTO.getHor_odo_para_prox_mtto().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(7		);	cell.setCellValue(	ndDTO.getHoras_prox_mtto().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(8		);	cell.setCellValue(	ndDTO.getKm_prox_mtto().doubleValue());	cell.setCellStyle(style);	

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoSRListaProxMtto.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso, El informe se ha generado con exito, ahora puedes Descargar el informe",
								""));
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

	
	public void consultarProxMttoPorVencer() {
		try {

			Long compania = new Long(getCompaniaIdSession());
			Long flagEquipo = 1L;
			Long flagPlanRevision = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = String.valueOf( selectedEquipo.get(0));
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += " , " + selectedEquipo.get(i);
				}
			}

			String planSeleccionados = "";
			if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
				planSeleccionados = selectedPlanRevision.get(0);
				flagPlanRevision = 0L;
				for (int i = 1; i < selectedPlanRevision.size(); i++) {
					planSeleccionados += "," + selectedPlanRevision.get(i);
				}
			}
			String estadoPlan ="0";
			if(txtEstadoPlan.getValue()!=null) {
				estadoPlan = FacesUtils.checkString(txtEstadoPlan);   
			}
			

			if (compania != null) {

				data = businessDelegator2View.consultarListaProximosMttoEquiposPorVencer(compania, equiposSeleccionadas,
						flagEquipo, planSeleccionados, flagPlanRevision, "Modulo_TallerAgricola", estadoPlan);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	

	public String exportProyeccionMttoPorVencer() throws NumberFormatException, Exception {
		
		Long compania = new Long(getCompaniaIdSession());
		Long flagEquipo = 1L;
		Long flagPlanRevision = 1L;

		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += " , " + selectedEquipo.get(i);
			}
		}

		String planSeleccionados = "";
		if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
			planSeleccionados = selectedPlanRevision.get(0);
			flagPlanRevision = 0L;
			for (int i = 1; i < selectedPlanRevision.size(); i++) {
				planSeleccionados += "," + selectedPlanRevision.get(i);
			}
		}
		String estadoPlan ="0";
		if(txtEstadoPlan.getValue()!=null) {
			estadoPlan = FacesUtils.checkString(txtEstadoPlan);   
		}
		

		if (compania != null) {
			try {

				List<ListadoProximosMttoEquiposDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRListaProxMtto.xlsx";

				data = businessDelegator2View.consultarListaProximosMttoEquiposPorVencer(compania, equiposSeleccionadas,
						flagEquipo, planSeleccionados, flagPlanRevision, "Modulo_TallerAgricola",estadoPlan);

				
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

					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));
					String fechaI = "";
					String fechaF = "";
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					

					if (data != null) {
						
						cell = row.createCell(0	);	cell.setCellValue(	"Equipo/Maquinaria"	);	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue(	"Plan Revisión"	);	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue(	"Periocidad (Hr/Km)"	);	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue(	"Fecha Ult. Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue(	"Hr/Km Ult. Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(5	);	cell.setCellValue(	"Hr/Km Actual"	);	cell.setCellStyle(style2);
						cell = row.createCell(6	);	cell.setCellValue(	"Hr/Km faltantes para Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(7	);	cell.setCellValue(	"Horas Próximo Mtto"	);	cell.setCellStyle(style2);
						cell = row.createCell(8	);	cell.setCellValue(	"Km Próximo Mtto"	);	cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (ListadoProximosMttoEquiposDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							
							cell = row.createCell(0		);	cell.setCellValue(	ndDTO.getCod_equipo() +"-"+ndDTO.getNom_equipo());	cell.setCellStyle(style);	
							cell = row.createCell(1		);	cell.setCellValue(	ndDTO.getNombre_plan_revision());	cell.setCellStyle(style);	
						
							cell = row.createCell(2		);	cell.setCellValue(	ndDTO.getPeriocidad().doubleValue());	cell.setCellStyle(style);	
							fechaI = dateFormat.format(ndDTO.getFecha_ultimo_servicio());
							cell = row.createCell(3		);	cell.setCellValue(	fechaI);	cell.setCellStyle(style);	
							cell = row.createCell(4		);	cell.setCellValue(	ndDTO.getHorasUltMantenimiento().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(5		);	cell.setCellValue(	ndDTO.getHoro_odo_actual().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(6		);	cell.setCellValue(	ndDTO.getHor_odo_para_prox_mtto().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(7		);	cell.setCellValue(	ndDTO.getHoras_prox_mtto().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(8		);	cell.setCellValue(	ndDTO.getKm_prox_mtto().doubleValue());	cell.setCellStyle(style);	

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoSRListaProxMtto.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso, El informe se ha generado con exito, ahora puedes Descargar el informe",
								""));

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
	
	
	public List<ListadoProximosMttoEquiposDTO> getData() {
		return data;
	}

	public void setData(List<ListadoProximosMttoEquiposDTO> data) {
		this.data = data;
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

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectItem[] getSelectCompania() {
		if (compania == null || compania.size() == 0) {

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

	public List<PlanRevisionEquipo> getPlanRevision() {

		if (planRevision == null || planRevision.size() == 0) {
			
			try {
				planRevision = businessDelegatorView.getPlanRevisionEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return planRevision;
	}

	public void setPlanRevision(List<PlanRevisionEquipo> planRevision) {
		this.planRevision = planRevision;
	}

	public List<String> getSelectedPlanRevision() {
		return selectedPlanRevision;
	}

	public void setSelectedPlanRevision(List<String> selectedPlanRevision) {
		this.selectedPlanRevision = selectedPlanRevision;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String getOrigendatos() {
		return origendatos;
	}

	public void setOrigendatos(String origendatos) {
		this.origendatos = origendatos;
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

	public SelectOneMenu getTxtEstadoPlan() {
		return txtEstadoPlan;
	}

	public void setTxtEstadoPlan(SelectOneMenu txtEstadoPlan) {
		this.txtEstadoPlan = txtEstadoPlan;
	}
	
	
}