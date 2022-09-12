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

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.informes.dto.ListaLaboresDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgLaboresMecMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresMaqDTO;
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
public class InformeSRMaqProgramacionLaboresView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeSRMaqProgramacionLaboresView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;

	// private List<ProntuarioLotesDTO> data;
	private SelectOneMenu txtEstadoServicio;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	
	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private List<ProgramacionLaboresMaqDTO> data;
	private List<ProgramacionLaboresMaqDTO> data2;
	private List<ProgramacionLaboresMaqDTO> data3;

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

	
	private StreamedContent file = null;
	private String disableButton = "true";

	private String disableDesPreFactura = "true";
	private StreamedContent filePreFactura = null;
	
	private String visible = "hidden";


	private List<String> selectedCliente;
	private List<PersEmpr> clientes;

	private List<String> selectedNivel2Clientesmq;
	private List<Nivel2Clientesmq> nivel2Clientesmq;
	
	private List<String> selectedOperador;
	private List<Trabajador> operadores;
	
	private InputText txtVlTotal;
	private InputText txtCantidad;
	private InputText txtHoras;
	
	private String disableButtonA = "false";
	private String disableButton1 = "false";
	private String disableNivel1 = "true";
	private String disableNivel2 = "true";
	String cadenaPrefactura ="";
	
	private List<String> selectedZonaGeografica;
	private List<ZonaGeografica> zonageograficas;

	
	private ProgramacionLaboresMaqDTO selectedDatServRealizadosEquipo;
	private List<ProgramacionLaboresMaqDTO> selectedDatServRealizadosEquipo2;
	
	/*****************campos detalle***/
	private SelectOneMenu	txtPersEmprConsulta;
	SelectItem[] selectContratistaConsulta;
	private List<PersEmpr> contratistaConsulta;
	
	private SelectOneMenu txtNivel2ClientesConsulta;
	SelectItem[] selectNivel2ClientesConsulta;
	private List<Nivel2Clientesmq> nivel2ClientesConsulta;
	
	private SelectOneMenu txtSupervisorConsulta;
	SelectItem[] selectSupervisorConsulta;
	private List<Trabajador> supervisor;
	
	
	private SelectOneMenu txtZonaConsulta;
	SelectItem[] selectZonaConsulta;
	private List<ZonaGeografica> zonaConsulta;
	
	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;
	
	private InputText txtConsecutivoConsulta;
	public InformeSRMaqProgramacionLaboresView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public String programaLaboresMaquinaria() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);
		

		Long flagLabor = 1L;
		Long flagUnidadMedida = 1L;
		Long flagGrupoLabor = 1L;

		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;
		Long flagZonaGeografica = 1L;


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


		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		String operadorSeleccionadas = "";
		if (selectedOperador != null && selectedOperador.size() > 0) {
			operadorSeleccionadas = selectedOperador.get(0);
			flagOperador = 0L;
			for (int i = 1; i < selectedOperador.size(); i++) {
				operadorSeleccionadas += "," + selectedOperador.get(i);
			}
		}
		
		String nivel2ClientesmqSeleccionadas = "";
		if (selectedNivel2Clientesmq != null && selectedNivel2Clientesmq.size() > 0) {
			nivel2ClientesmqSeleccionadas = selectedNivel2Clientesmq.get(0);
			flagNivel2Clientesmq = 0L;
			for (int i = 1; i < selectedNivel2Clientesmq.size(); i++) {
				nivel2ClientesmqSeleccionadas += "," + selectedNivel2Clientesmq.get(i);
			}
		}
		
		String clientesSeleccionadas = "";
		if (selectedCliente != null && selectedCliente.size() > 0) {
			clientesSeleccionadas = selectedCliente.get(0);
			flagClientes = 0L;
			for (int i = 1; i < selectedCliente.size(); i++) {
				clientesSeleccionadas += "," + selectedCliente.get(i);
			}
		}
		
		String zonageograficasSeleccionadas = "";
		if (selectedZonaGeografica != null && selectedZonaGeografica.size() > 0) {
			zonageograficasSeleccionadas = selectedZonaGeografica.get(0);
			flagZonaGeografica = 0L;
			for (int i = 1; i < selectedZonaGeografica.size(); i++) {
				zonageograficasSeleccionadas += "," + selectedZonaGeografica.get(i);
			}
		}
		
		
		
		if (compania != null) {
			try {

				List<ProgramacionLaboresMaqDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRMaqProgramaLabores.xlsx";

				data = businessDelegator2View.pr_consulta_prog_labormq(compania, fechaInicial, fechaFinal, 
						clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas, flagNivel2Clientesmq,
						operadorSeleccionadas, flagOperador, 
						laboresSeleccionadas, flagLabor, unidadesMedidaSeleccionadas, 
						flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor, equiposSeleccionadas, flagEquipo, 
						zonageograficasSeleccionadas,flagZonaGeografica);
				
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
						
						cell = row.createCell(0	);	cell.setCellValue(	"ANIO_REGISTRO"	);	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue(	"MES"	);	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue(	"COD_EQUIPO"	);	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue(	"NOM_EQUIPO"	);	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue(	"COD_FINCA"	);	cell.setCellStyle(style2);
						cell = row.createCell(5	);	cell.setCellValue(	"NOM_FINCA"	);	cell.setCellStyle(style2);
						cell = row.createCell(6	);	cell.setCellValue(	"NOM_LABOR"	);	cell.setCellStyle(style2);
						cell = row.createCell(7	);	cell.setCellValue(	"CANTIDAD_PLAN"	);	cell.setCellStyle(style2);
						cell = row.createCell(8	);	cell.setCellValue(	"CANTIDAD_REALIZADA"	);	cell.setCellStyle(style2);
						cell = row.createCell(9	);	cell.setCellValue(	"CANTIDAD_PENDIENTE"	);	cell.setCellStyle(style2);
						cell = row.createCell(10	);	cell.setCellValue(	"CONCLUIDO"	);	cell.setCellStyle(style2);
						cell = row.createCell(11	);	cell.setCellValue(	"FACTURADO"	);	cell.setCellStyle(style2);
						cell = row.createCell(12	);	cell.setCellValue(	"COD_UM_PLAN"	);	cell.setCellStyle(style2);
						cell = row.createCell(13	);	cell.setCellValue(	"NOM_UM_PLAN"	);	cell.setCellStyle(style2);
						cell = row.createCell(14	);	cell.setCellValue(	"NOM_LOTE"	);	cell.setCellStyle(style2);
						cell = row.createCell(15	);	cell.setCellValue(	"FECHA"	);	cell.setCellStyle(style2);
						cell = row.createCell(16	);	cell.setCellValue(	"VALOR_UNITARIO"	);	cell.setCellStyle(style2);
						cell = row.createCell(17	);	cell.setCellValue(	"VALOR_EST_TOTAL"	);	cell.setCellStyle(style2);
						cell = row.createCell(18	);	cell.setCellValue(	"COD_CLIENTE"	);	cell.setCellStyle(style2);
						cell = row.createCell(19	);	cell.setCellValue(	"NOM_CLIENTE"	);	cell.setCellStyle(style2);
						cell = row.createCell(20	);	cell.setCellValue(	"COD_SUPERVISOR"	);	cell.setCellStyle(style2);
						cell = row.createCell(21	);	cell.setCellValue(	"NOM_SUPERVISOR"	);	cell.setCellStyle(style2);
						cell = row.createCell(22	);	cell.setCellValue(	"COD_LABOR"	);	cell.setCellStyle(style2);
						cell = row.createCell(23	);	cell.setCellValue(	"CONSECUTIVO"	);	cell.setCellStyle(style2);
						cell = row.createCell(24	);	cell.setCellValue(	"DAT_PLAN_SERVICIOS_MQDET_ID"	);	cell.setCellStyle(style2);
						cell = row.createCell(25	);	cell.setCellValue(	"DAT_PLAN_SERVICIOS_MQ_ID"	);	cell.setCellStyle(style2);
						cell = row.createCell(26	);	cell.setCellValue(	"EQUIPO_ID"	);	cell.setCellStyle(style2);
						cell = row.createCell(27	);	cell.setCellValue(	"COD_ZONA"	);	cell.setCellStyle(style2);
						cell = row.createCell(28	);	cell.setCellValue(	"NOM_ZONA"	);	cell.setCellStyle(style2);
						cell = row.createCell(29	);	cell.setCellValue(	"OBSERVACION"	);	cell.setCellStyle(style2);
						cell = row.createCell(30	);	cell.setCellValue(	"FECHA REALIZADO"	);	cell.setCellStyle(style2);
						cell = row.createCell(31	);	cell.setCellValue(	"OPERARIO"	);	cell.setCellStyle(style2);
						cell = row.createCell(32	);	cell.setCellValue(	"ESTADO FACTURA"	);	cell.setCellStyle(style2);
						cell = row.createCell(33	);	cell.setCellValue(	"CONSEC. PREFACTURA"	);	cell.setCellStyle(style2);
						cell = row.createCell(34	);	cell.setCellValue(	"NUM. FACTURA"	);	cell.setCellStyle(style2);
						cell = row.createCell(35	);	cell.setCellValue(	"CENTRO COSTO"	);	cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (ProgramacionLaboresMaqDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							
							cell = row.createCell(0		);	cell.setCellValue(	ndDTO.getAnio_registro().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(1		);	cell.setCellValue(	ndDTO.getMes().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(2		);	cell.setCellValue(	ndDTO.getCod_equipo());	cell.setCellStyle(style);	
							cell = row.createCell(3		);	cell.setCellValue(	ndDTO.getNom_equipo());	cell.setCellStyle(style);	
							cell = row.createCell(4		);	cell.setCellValue(	ndDTO.getCod_finca());	cell.setCellStyle(style);	
							cell = row.createCell(5		);	cell.setCellValue(	ndDTO.getNom_finca());	cell.setCellStyle(style);	
							cell = row.createCell(6		);	cell.setCellValue(	ndDTO.getNom_labor());	cell.setCellStyle(style);	
							cell = row.createCell(7		);	cell.setCellValue(	ndDTO.getCantidad_plan().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(8		);	cell.setCellValue(	ndDTO.getCantidad_realizada().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(9		);	cell.setCellValue(	ndDTO.getCantidad_pendiente().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(10		);	cell.setCellValue(	ndDTO.getConcluido());	cell.setCellStyle(style);	
							cell = row.createCell(11		);	cell.setCellValue(	ndDTO.getFacturado());	cell.setCellStyle(style);	
							cell = row.createCell(12		);	cell.setCellValue(	ndDTO.getCod_um_plan());	cell.setCellStyle(style);	
							cell = row.createCell(13		);	cell.setCellValue(	ndDTO.getNom_um_plan());	cell.setCellStyle(style);	
							cell = row.createCell(14		);	cell.setCellValue(	ndDTO.getNom_lote());	cell.setCellStyle(style);	
							cell = row.createCell(15		);	

							cell.setCellValue(
									ndDTO.getPeriodo_inicial().toString().substring(8, 10)+"/"+
									ndDTO.getPeriodo_inicial().toString().substring(5, 7)+"/"+
									ndDTO.getPeriodo_inicial().toString().substring(0, 4));
							cell.setCellStyle(style);	
							
							cell = row.createCell(16		);	cell.setCellValue(	ndDTO.getValor_unitario().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(17		);	cell.setCellValue(	ndDTO.getValor_est_total().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(18		);	cell.setCellValue(	ndDTO.getCod_cliente());	cell.setCellStyle(style);	
							cell = row.createCell(19		);	cell.setCellValue(	ndDTO.getNom_cliente());	cell.setCellStyle(style);	
							cell = row.createCell(20		);	cell.setCellValue(	ndDTO.getCod_supervisor());	cell.setCellStyle(style);	
							cell = row.createCell(21		);	cell.setCellValue(	ndDTO.getNom_supervisor());	cell.setCellStyle(style);	
							cell = row.createCell(22		);	cell.setCellValue(	ndDTO.getCod_labor());	cell.setCellStyle(style);	
							cell = row.createCell(23		);	cell.setCellValue(	ndDTO.getConsecutivo().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(24		);	cell.setCellValue(	ndDTO.getDat_plan_servicios_mqdet_id().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(25		);	cell.setCellValue(	ndDTO.getDat_plan_servicios_mq_id().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(26		);	cell.setCellValue(	ndDTO.getEquipo_id2());	cell.setCellStyle(style);	
							cell = row.createCell(27		);	cell.setCellValue(	ndDTO.getCod_zona());	cell.setCellStyle(style);	
							cell = row.createCell(28		);	cell.setCellValue(	ndDTO.getNom_zona());	cell.setCellStyle(style);	
							cell = row.createCell(29		);	cell.setCellValue(	ndDTO.getDetalleNota());	cell.setCellStyle(style);	
							cell = row.createCell(30		);	
							
							if(ndDTO.getFecha_realizado().equals("")) {
								cell.setCellValue(ndDTO.getFecha_realizado());
							}else {
								cell.setCellValue(
										ndDTO.getFecha_realizado().toString().substring(8, 10)+"/"+
										ndDTO.getFecha_realizado().toString().substring(5, 7)+"/"+
										ndDTO.getFecha_realizado().toString().substring(0, 4));
							}
							cell.setCellStyle(style);	
							cell = row.createCell(31		);	cell.setCellValue(	ndDTO.getNom_operario());	cell.setCellStyle(style);	
							cell = row.createCell(32		);	cell.setCellValue(	ndDTO.getEstadoFactura());	cell.setCellStyle(style);
							cell = row.createCell(33		);	cell.setCellValue(	ndDTO.getConsecutivoPrefactura2());	cell.setCellStyle(style);
							cell = row.createCell(34		);	cell.setCellValue(	ndDTO.getNumFactura2());	cell.setCellStyle(style);
							cell = row.createCell(35		);	cell.setCellValue(	ndDTO.getNombreCentroCosto());	cell.setCellStyle(style);
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoSRMaqProgramaLabores.xlsx");

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


	

	public String programaLaboresMaquinariaPorCliente() throws NumberFormatException, Exception {

		 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			
			Long compania = new Long(getCompaniaIdSession());
			Long flagLabor = 1L;
			Long flagGrupoLabor = 1L;
		
			String supervisor ="0";
			Long flagSupervisor =1L;
			if(txtSupervisorConsulta.getValue()!=null) {
				supervisor =txtSupervisorConsulta.getValue().toString();
				flagSupervisor =0L;
			}
			
			
			String zona ="0";
			Long flagZona =1L;
			if(txtZonaConsulta.getValue()!=null) {
				zona =txtZonaConsulta.getValue().toString();
				flagZona =0L;
			}
			
			

			String cliente ="0";
			Long flagCliente =1L;
			if(txtPersEmprConsulta.getValue()!=null) {
				cliente =txtPersEmprConsulta.getValue().toString();
				flagCliente =0L;
			}
			
			

			String nivel2Mq ="0";
			Long flagNivel2Mq =1L;
			if(txtNivel2ClientesConsulta.getValue()!=null) {
				nivel2Mq =txtNivel2ClientesConsulta.getValue().toString();
				flagNivel2Mq =0L;
			}
			
			Long consecutivo = FacesUtils.checkLong(txtConsecutivoConsulta);
			if(consecutivo ==null) {
				consecutivo =0L;
			}
			
			String laboresSeleccionadas = "";
			if (selectedLabor != null && selectedLabor.size() > 0) {
				laboresSeleccionadas = selectedLabor.get(0);
				flagLabor = 0L;
				for (int i = 1; i < selectedLabor.size(); i++) {
					laboresSeleccionadas += "," + selectedLabor.get(i);
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

		
			if (fechaInicial != null && fechaFinal != null) {
			try {

				List<ProgLaboresMecMaqDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoProgramaLaboresPorCliente.xlsx";

				data = businessDelegator2View.pr_lista_prog_maquinaria( compania,  fechaInicial, fechaFinal,supervisor,  flagSupervisor,
						zona,flagZona, cliente,flagCliente,nivel2Mq,flagNivel2Mq,consecutivo,
						laboresSeleccionadas,flagLabor, grupoLaboresSeleccionadas,flagGrupoLabor,"0",0.0
						);
				
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
						
						cell = row.createCell(0	);	cell.setCellValue(	"Id Programa"	);	cell.setCellStyle(style2);
						cell = row.createCell(1	);	cell.setCellValue(	"Consec"	);	cell.setCellStyle(style2);
						cell = row.createCell(2	);	cell.setCellValue(	"Supervisor"	);	cell.setCellStyle(style2);
						cell = row.createCell(3	);	cell.setCellValue(	"Zona"	);	cell.setCellStyle(style2);
						cell = row.createCell(4	);	cell.setCellValue(	"Cliente"	);	cell.setCellStyle(style2);
						cell = row.createCell(5	);	cell.setCellValue(	"Hacienda"	);	cell.setCellStyle(style2);
						cell = row.createCell(6	);	cell.setCellValue(	"Ste"	);	cell.setCellStyle(style2);
						cell = row.createCell(7	);	cell.setCellValue(	"Labor"	);	cell.setCellStyle(style2);
						cell = row.createCell(8	);	cell.setCellValue(	"U.M"	);	cell.setCellStyle(style2);
						cell = row.createCell(9	);	cell.setCellValue(	"Cant. Plan"	);	cell.setCellStyle(style2);
						cell = row.createCell(10	);	cell.setCellValue(	"Cant. Realizada"	);	cell.setCellStyle(style2);
						cell = row.createCell(11	);	cell.setCellValue(	"Cant. Pendiente"	);	cell.setCellStyle(style2);
						cell = row.createCell(12	);	cell.setCellValue(	"%Avance"	);	cell.setCellStyle(style2);
						cell = row.createCell(13	);	cell.setCellValue(	"Vlr. Unitario"	);	cell.setCellStyle(style2);
						cell = row.createCell(14	);	cell.setCellValue(	"Valor Total"	);	cell.setCellStyle(style2);
						cell = row.createCell(15	);	cell.setCellValue(	"Fecha"	);	cell.setCellStyle(style2);
						cell = row.createCell(16	);	cell.setCellValue(	"Concluido?"	);	cell.setCellStyle(style2);
						cell = row.createCell(17	);	cell.setCellValue(	"Observación"	);	cell.setCellStyle(style2);
						cell = row.createCell(18	);	cell.setCellValue(	"Estado servicio"	);	cell.setCellStyle(style2);
						cell = row.createCell(19	);	cell.setCellValue(	"Num. Prefactura"	);	cell.setCellStyle(style2);
						cell = row.createCell(20	);	cell.setCellValue(	"Num. Factura"	);	cell.setCellStyle(style2);
						
						
						int pos_i = 8;

						for (ProgLaboresMecMaqDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							
							cell = row.createCell(0		);	cell.setCellValue(	ndDTO.getId_programa().longValue());	cell.setCellStyle(style);	
							cell = row.createCell(1		);	cell.setCellValue(	ndDTO.getConsecutivo().longValue());	cell.setCellStyle(style);	
							cell = row.createCell(2		);	cell.setCellValue(	ndDTO.getNom_supervisor());	cell.setCellStyle(style);	
							cell = row.createCell(3		);	cell.setCellValue(	ndDTO.getNom_zona());	cell.setCellStyle(style);	
							cell = row.createCell(4		);	cell.setCellValue(	ndDTO.getNom_cliente());	cell.setCellStyle(style);	
							cell = row.createCell(5		);	cell.setCellValue(	ndDTO.getNom_finca());	cell.setCellStyle(style);	
							cell = row.createCell(6		);	cell.setCellValue(	ndDTO.getNom_lote());	cell.setCellStyle(style);	
							cell = row.createCell(7		);	cell.setCellValue(	ndDTO.getNom_labor());	cell.setCellStyle(style);	
							cell = row.createCell(8		);	cell.setCellValue(	ndDTO.getCod_udad_med());	cell.setCellStyle(style);	
							cell = row.createCell(9		);	cell.setCellValue(	ndDTO.getCantidad_plan().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(10		);	cell.setCellValue(	ndDTO.getCantidad_realizada().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(11		);	cell.setCellValue(	ndDTO.getCantidad_pendiente().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(12	);	cell.setCellValue(	ndDTO.getPorcentajeAvance().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(13		);	cell.setCellValue(	ndDTO.getVlrUnitario().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(14		);	cell.setCellValue(	ndDTO.getIngresoTotal().doubleValue());	cell.setCellStyle(style);	
							cell = row.createCell(15		);	cell.setCellValue(	ndDTO.getPeriodo_inicial());	cell.setCellStyle(style);	
							cell = row.createCell(16		);	cell.setCellValue(	ndDTO.getConcluido());	cell.setCellStyle(style);	
							cell = row.createCell(17		);	cell.setCellValue(	ndDTO.getDetalle_nota());	cell.setCellStyle(style);	

							cell = row.createCell(18		);	cell.setCellValue(	ndDTO.getEstadoFactura());	cell.setCellStyle(style);	
							cell = row.createCell(19		);	cell.setCellValue(	ndDTO.getConsecutivoPrefactura());	cell.setCellStyle(style);	
							cell = row.createCell(20		);	cell.setCellValue(	ndDTO.getNumFactura());	cell.setCellStyle(style);	

							
							
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoProgramaLaboresPorCliente.xlsx");

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


	
	
	

	public String consultarAvanceProyectos() throws NumberFormatException, Exception {

		 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			
			Long compania = new Long(getCompaniaIdSession());
			Long flagLabor = 1L;
			Long flagGrupoLabor = 1L;
			
			Long flagUnidadMedida = 1L;
			Long flagEquipo = 1L;
			Long flagNivel2Clientesmq = 1L;
			Long flagOperador = 1L;
			Long flagClientes = 1L;
			Long flagZonaGeografica = 1L;

			
			String cliente ="0";
			Long flagCliente =1L;
			if(txtPersEmprConsulta.getValue()!=null) {
				cliente =txtPersEmprConsulta.getValue().toString();
				flagCliente =0L;
			}
			
			

			String nivel2Mq ="0";
			Long flagNivel2Mq =1L;
			if(txtNivel2ClientesConsulta.getValue()!=null) {
				nivel2Mq =txtNivel2ClientesConsulta.getValue().toString();
				flagNivel2Mq =0L;
			}
			
			
			
			String laborId ="0";
			
			if(txtLaborId_Labor.getValue()!=null) {
				laborId =txtLaborId_Labor.getValue().toString();
				flagLabor =0L;
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


			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += "," + selectedEquipo.get(i);
				}
			}

			String operadorSeleccionadas = "";
			if (selectedOperador != null && selectedOperador.size() > 0) {
				operadorSeleccionadas = selectedOperador.get(0);
				flagOperador = 0L;
				for (int i = 1; i < selectedOperador.size(); i++) {
					operadorSeleccionadas += "," + selectedOperador.get(i);
				}
			}
			
			String nivel2ClientesmqSeleccionadas = "";
			if (selectedNivel2Clientesmq != null && selectedNivel2Clientesmq.size() > 0) {
				nivel2ClientesmqSeleccionadas = selectedNivel2Clientesmq.get(0);
				flagNivel2Clientesmq = 0L;
				for (int i = 1; i < selectedNivel2Clientesmq.size(); i++) {
					nivel2ClientesmqSeleccionadas += "," + selectedNivel2Clientesmq.get(i);
				}
			}
			
			String clientesSeleccionadas = "";
			if (selectedCliente != null && selectedCliente.size() > 0) {
				clientesSeleccionadas = selectedCliente.get(0);
				flagClientes = 0L;
				for (int i = 1; i < selectedCliente.size(); i++) {
					clientesSeleccionadas += "," + selectedCliente.get(i);
				}
			}
			
			String zonageograficasSeleccionadas = "";
			if (selectedZonaGeografica != null && selectedZonaGeografica.size() > 0) {
				zonageograficasSeleccionadas = selectedZonaGeografica.get(0);
				flagZonaGeografica = 0L;
				for (int i = 1; i < selectedZonaGeografica.size(); i++) {
					zonageograficasSeleccionadas += "," + selectedZonaGeografica.get(i);
				}
			}
			
			

		
			

			if (compania != null && fechaInicial !=null &&  fechaFinal !=null) {
				try {

					List<ProgramacionLaboresMaqDTO> data = null;
					InputStream stream = null;
					String filename = " ";

					FacesContext context = FacesContext.getCurrentInstance();
					HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
					Object contextPath = origRequest.getContextPath();

					ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
							.getContext();

					Date fechaCreacion = new Date();

					filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
							+ "MttoAvanceProgramaMaq.xlsx";

					data = businessDelegator2View.pr_avance_proyectos_maq(compania, fechaInicial, fechaFinal, 
							cliente, flagCliente, nivel2Mq, flagNivel2Mq,
							operadorSeleccionadas, flagOperador, 
							laborId, flagLabor, unidadesMedidaSeleccionadas, 
							flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor, equiposSeleccionadas, flagEquipo, 
							zonageograficasSeleccionadas,flagZonaGeografica);
					
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
							
							cell = row.createCell(0	);	cell.setCellValue(	"ANIO_REGISTRO"	);	cell.setCellStyle(style2);
							cell = row.createCell(1	);	cell.setCellValue(	"MES"	);	cell.setCellStyle(style2);
							cell = row.createCell(2	);	cell.setCellValue(	"COD_EQUIPO"	);	cell.setCellStyle(style2);
							cell = row.createCell(3	);	cell.setCellValue(	"NOM_EQUIPO"	);	cell.setCellStyle(style2);
							cell = row.createCell(4	);	cell.setCellValue(	"COD_FINCA"	);	cell.setCellStyle(style2);
							cell = row.createCell(5	);	cell.setCellValue(	"NOM_FINCA"	);	cell.setCellStyle(style2);
							cell = row.createCell(6	);	cell.setCellValue(	"NOM_LABOR"	);	cell.setCellStyle(style2);
							cell = row.createCell(7	);	cell.setCellValue(	"CANTIDAD_PLAN"	);	cell.setCellStyle(style2);
							cell = row.createCell(8	);	cell.setCellValue(	"CANTIDAD_REALIZADA"	);	cell.setCellStyle(style2);
							cell = row.createCell(9	);	cell.setCellValue(	"CANTIDAD_PENDIENTE"	);	cell.setCellStyle(style2);
							cell = row.createCell(10	);	cell.setCellValue(	"CONCLUIDO"	);	cell.setCellStyle(style2);
							cell = row.createCell(11	);	cell.setCellValue(	"FACTURADO"	);	cell.setCellStyle(style2);
							cell = row.createCell(12	);	cell.setCellValue(	"COD_UM_PLAN"	);	cell.setCellStyle(style2);
							cell = row.createCell(13	);	cell.setCellValue(	"NOM_UM_PLAN"	);	cell.setCellStyle(style2);
							cell = row.createCell(14	);	cell.setCellValue(	"NOM_LOTE"	);	cell.setCellStyle(style2);
							cell = row.createCell(15	);	cell.setCellValue(	"FECHA"	);	cell.setCellStyle(style2);
							cell = row.createCell(16	);	cell.setCellValue(	"VALOR_UNITARIO"	);	cell.setCellStyle(style2);
							cell = row.createCell(17	);	cell.setCellValue(	"VALOR_EST_TOTAL"	);	cell.setCellStyle(style2);
							cell = row.createCell(18	);	cell.setCellValue(	"COD_CLIENTE"	);	cell.setCellStyle(style2);
							cell = row.createCell(19	);	cell.setCellValue(	"NOM_CLIENTE"	);	cell.setCellStyle(style2);
							cell = row.createCell(20	);	cell.setCellValue(	"COD_SUPERVISOR"	);	cell.setCellStyle(style2);
							cell = row.createCell(21	);	cell.setCellValue(	"NOM_SUPERVISOR"	);	cell.setCellStyle(style2);
							cell = row.createCell(22	);	cell.setCellValue(	"COD_LABOR"	);	cell.setCellStyle(style2);
							cell = row.createCell(23	);	cell.setCellValue(	"CONSECUTIVO"	);	cell.setCellStyle(style2);
							cell = row.createCell(24	);	cell.setCellValue(	"DAT_PLAN_SERVICIOS_MQDET_ID"	);	cell.setCellStyle(style2);
							cell = row.createCell(25	);	cell.setCellValue(	"DAT_PLAN_SERVICIOS_MQ_ID"	);	cell.setCellStyle(style2);
							cell = row.createCell(26	);	cell.setCellValue(	"EQUIPO_ID"	);	cell.setCellStyle(style2);
							cell = row.createCell(27	);	cell.setCellValue(	"COD_ZONA"	);	cell.setCellStyle(style2);
							cell = row.createCell(28	);	cell.setCellValue(	"NOM_ZONA"	);	cell.setCellStyle(style2);
							cell = row.createCell(29	);	cell.setCellValue(	"OBSERVACION"	);	cell.setCellStyle(style2);
							cell = row.createCell(30	);	cell.setCellValue(	"FECHA REALIZADO"	);	cell.setCellStyle(style2);
							cell = row.createCell(31	);	cell.setCellValue(	"OPERARIO"	);	cell.setCellStyle(style2);
							cell = row.createCell(32	);	cell.setCellValue(	"ESTADO FACTURA"	);	cell.setCellStyle(style2);
							cell = row.createCell(33	);	cell.setCellValue(	"CONSEC. PREFACTURA"	);	cell.setCellStyle(style2);
							cell = row.createCell(34	);	cell.setCellValue(	"NUM. FACTURA"	);	cell.setCellStyle(style2);
							cell = row.createCell(35	);	cell.setCellValue(	"CANTIDAD PRESUPUESTO"	);	cell.setCellStyle(style2);
							cell = row.createCell(36	);	cell.setCellValue(	"INGRESO EJECUCION"	);	cell.setCellStyle(style2);
							cell = row.createCell(37	);	cell.setCellValue(	"HOROMETRO INICIAL"	);	cell.setCellStyle(style2);
							cell = row.createCell(38	);	cell.setCellValue(	"HOROMETRO FINAL"	);	cell.setCellStyle(style2);
							cell = row.createCell(39	);	cell.setCellValue(	"TOTAL HORAS"	);	cell.setCellStyle(style2);
							cell = row.createCell(40	);	cell.setCellValue(	"HORAS ESTIMADAS"	);	cell.setCellStyle(style2);
							
							
							
							int pos_i = 8;

							for (ProgramacionLaboresMaqDTO ndDTO : data) {

								row = sheet.createRow(pos_i);
								
								cell = row.createCell(0		);	cell.setCellValue(	ndDTO.getAnio_registro().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(1		);	cell.setCellValue(	ndDTO.getMes().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(2		);	cell.setCellValue(	ndDTO.getCod_equipo());	cell.setCellStyle(style);	
								cell = row.createCell(3		);	cell.setCellValue(	ndDTO.getNom_equipo());	cell.setCellStyle(style);	
								cell = row.createCell(4		);	cell.setCellValue(	ndDTO.getCod_finca());	cell.setCellStyle(style);	
								cell = row.createCell(5		);	cell.setCellValue(	ndDTO.getNom_finca());	cell.setCellStyle(style);	
								cell = row.createCell(6		);	cell.setCellValue(	ndDTO.getNom_labor());	cell.setCellStyle(style);	
								cell = row.createCell(7		);	cell.setCellValue(	ndDTO.getCantidad_plan().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(8		);	cell.setCellValue(	ndDTO.getCantidad_realizada().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(9		);	cell.setCellValue(	ndDTO.getCantidad_pendiente().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(10		);	cell.setCellValue(	ndDTO.getConcluido());	cell.setCellStyle(style);	
								cell = row.createCell(11		);	cell.setCellValue(	ndDTO.getFacturado());	cell.setCellStyle(style);	
								cell = row.createCell(12		);	cell.setCellValue(	ndDTO.getCod_um_plan());	cell.setCellStyle(style);	
								cell = row.createCell(13		);	cell.setCellValue(	ndDTO.getNom_um_plan());	cell.setCellStyle(style);	
								cell = row.createCell(14		);	cell.setCellValue(	ndDTO.getNom_lote());	cell.setCellStyle(style);	
								cell = row.createCell(15		);	

								cell.setCellValue(
										ndDTO.getPeriodo_inicial().toString().substring(8, 10)+"/"+
										ndDTO.getPeriodo_inicial().toString().substring(5, 7)+"/"+
										ndDTO.getPeriodo_inicial().toString().substring(0, 4));
								cell.setCellStyle(style);	
								
								cell = row.createCell(16		);	cell.setCellValue(	ndDTO.getValor_unitario().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(17		);	cell.setCellValue(	ndDTO.getValor_est_total().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(18		);	cell.setCellValue(	ndDTO.getCod_cliente());	cell.setCellStyle(style);	
								cell = row.createCell(19		);	cell.setCellValue(	ndDTO.getNom_cliente());	cell.setCellStyle(style);	
								cell = row.createCell(20		);	cell.setCellValue(	ndDTO.getCod_supervisor());	cell.setCellStyle(style);	
								cell = row.createCell(21		);	cell.setCellValue(	ndDTO.getNom_supervisor());	cell.setCellStyle(style);	
								cell = row.createCell(22		);	cell.setCellValue(	ndDTO.getCod_labor());	cell.setCellStyle(style);	
								cell = row.createCell(23		);	cell.setCellValue(	ndDTO.getConsecutivo().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(24		);	cell.setCellValue(	ndDTO.getDat_plan_servicios_mqdet_id().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(25		);	cell.setCellValue(	ndDTO.getDat_plan_servicios_mq_id().doubleValue());	cell.setCellStyle(style);	
								cell = row.createCell(26		);	cell.setCellValue(	ndDTO.getEquipo_id2());	cell.setCellStyle(style);	
								cell = row.createCell(27		);	cell.setCellValue(	ndDTO.getCod_zona());	cell.setCellStyle(style);	
								cell = row.createCell(28		);	cell.setCellValue(	ndDTO.getNom_zona());	cell.setCellStyle(style);	
								cell = row.createCell(29		);	cell.setCellValue(	ndDTO.getDetalleNota());	cell.setCellStyle(style);	
								cell = row.createCell(30		);	
								
								if(ndDTO.getFecha_realizado().equals("")) {
									cell.setCellValue(ndDTO.getFecha_realizado());
								}else {
									cell.setCellValue(
											ndDTO.getFecha_realizado().toString().substring(8, 10)+"/"+
											ndDTO.getFecha_realizado().toString().substring(5, 7)+"/"+
											ndDTO.getFecha_realizado().toString().substring(0, 4));
								}
								cell.setCellStyle(style);	
								cell = row.createCell(31		);	cell.setCellValue(	ndDTO.getNom_operario());	cell.setCellStyle(style);	
								cell = row.createCell(32		);	cell.setCellValue(	ndDTO.getEstadoFactura());	cell.setCellStyle(style);
								cell = row.createCell(33		);	cell.setCellValue(	ndDTO.getConsecutivoPrefactura2());	cell.setCellStyle(style);
								cell = row.createCell(34		);	cell.setCellValue(	ndDTO.getNumFactura2());	cell.setCellStyle(style);
								cell = row.createCell(35		);	cell.setCellValue(	ndDTO.getCantidadPresupuesto().doubleValue());	cell.setCellStyle(style);
								cell = row.createCell(36		);	cell.setCellValue(	ndDTO.getIngresoTotal().doubleValue());	cell.setCellStyle(style);
								
								cell = row.createCell(37		);	cell.setCellValue(	ndDTO.getHorometroInicial().doubleValue());	cell.setCellStyle(style);
								cell = row.createCell(38		);	cell.setCellValue(	ndDTO.getHorometroFinal().doubleValue());	cell.setCellStyle(style);
								cell = row.createCell(39		);	cell.setCellValue(	ndDTO.getHorasTotal().doubleValue());	cell.setCellStyle(style);
								cell = row.createCell(40);	cell.setCellValue(	ndDTO.getHorasEstiamdas().doubleValue());	cell.setCellStyle(style);
								
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

							file = new DefaultStreamedContent(stream, "application/xlsx", "MttoAvanceProgramaMaq.xlsx");

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
	
	
	public List<String> getSelectedNivel2Clientesmq() {
		return selectedNivel2Clientesmq;
	}

	public void setSelectedNivel2Clientesmq(List<String> selectedNivel2Clientesmq) {
		this.selectedNivel2Clientesmq = selectedNivel2Clientesmq;
	}

	public List<Nivel2Clientesmq> getNivel2Clientesmq() {

		if (nivel2Clientesmq == null || nivel2Clientesmq.size() == 0) {

			try {
				nivel2Clientesmq = businessDelegator2View.getNivel2Clientesmq();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return nivel2Clientesmq;
	}

	public void setNivel2Clientesmq(List<Nivel2Clientesmq> nivel2Clientesmq) {
		this.nivel2Clientesmq = nivel2Clientesmq;
	}


	
	public List<String> getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(List<String> selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public List<PersEmpr> getClientes() {

		if (clientes == null || clientes.size() == 0) {

			
			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "4", "=" };
				clientes = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return clientes;
	}

	public void setClientes(List<PersEmpr> clientes) {
		this.clientes = clientes;
	}


	public List<String> getSelectedZonaGeografica() {
		return selectedZonaGeografica;
	}

	public void setSelectedZonaGeografica(List<String> selectedZonaGeografica) {
		this.selectedZonaGeografica = selectedZonaGeografica;
	}
	
	public List<ZonaGeografica> getZonageograficas() {

		if (zonageograficas == null || zonageograficas.size() == 0) {

			
			try {
				zonageograficas = businessDelegatorView.getZonaGeografica();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return zonageograficas;
	}

	public void setZonageograficas(List<ZonaGeografica> zonageograficas) {
		this.zonageograficas = zonageograficas;
	}

	
	public List<String> getSelectedOperador() {
		return selectedOperador;
	}

	public void setSelectedOperador(List<String> selectedOperador) {
		this.selectedOperador = selectedOperador;
	}

	public List<Trabajador> getOperadores() {

		if (operadores == null || operadores.size() == 0) {

			
			try {
				operadores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return operadores;
	}

	public void setOperadores(List<Trabajador> operadores) {
		this.operadores = operadores;
	}
	
	public SelectOneMenu getTxtEstadoServicio() {
		return txtEstadoServicio;
	}

	public void setTxtEstadoServicio(SelectOneMenu txtEstadoServicio) {
		this.txtEstadoServicio = txtEstadoServicio;
	}

	public InputText getTxtVlTotal() {
		return txtVlTotal;
	}

	public void setTxtVlTotal(InputText txtVlTotal) {
		this.txtVlTotal = txtVlTotal;
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public InputText getTxtHoras() {
		return txtHoras;
	}

	public void setTxtHoras(InputText txtHoras) {
		this.txtHoras = txtHoras;
	}

	

	public ProgramacionLaboresMaqDTO getSelectedDatServRealizadosEquipo() {
		return selectedDatServRealizadosEquipo;
	}

	public void setSelectedDatServRealizadosEquipo(
			ProgramacionLaboresMaqDTO selectedDatServRealizadosEquipo) {
		this.selectedDatServRealizadosEquipo = selectedDatServRealizadosEquipo;
	}

	public String getDisableButton1() {
		return disableButton1;
	}

	public void setDisableButton1(String disableButton1) {
		this.disableButton1 = disableButton1;
	}

	public String getDisableNivel1() {
		return disableNivel1;
	}

	public void setDisableNivel1(String disableNivel1) {
		this.disableNivel1 = disableNivel1;
	}

	public String getDisableNivel2() {
		return disableNivel2;
	}

	public void setDisableNivel2(String disableNivel2) {
		this.disableNivel2 = disableNivel2;
	}

	public String getDisableButtonA() {
		return disableButtonA;
	}

	public void setDisableButtonA(String disableButtonA) {
		this.disableButtonA = disableButtonA;
	}	   
	
	

	public List<ProgramacionLaboresMaqDTO> getSelectedDatServRealizadosEquipo2() {
		return selectedDatServRealizadosEquipo2;
	}

	public void setSelectedDatServRealizadosEquipo2(
			List<ProgramacionLaboresMaqDTO> selectedDatServRealizadosEquipo2) {
		this.selectedDatServRealizadosEquipo2 = selectedDatServRealizadosEquipo2;
	}


	public void setData2(List<ProgramacionLaboresMaqDTO> data2) {
		this.data2 = data2;
	}

	public void setData(List<ProgramacionLaboresMaqDTO> data) {
		this.data = data;
	}

	public String getCadenaPrefactura() {
		return cadenaPrefactura;
	}

	public void setCadenaPrefactura(String cadenaPrefactura) {
		this.cadenaPrefactura = cadenaPrefactura;
	}

	public String getDisableDesPreFactura() {
		return disableDesPreFactura;
	}

	public void setDisableDesPreFactura(String disableDesPreFactura) {
		this.disableDesPreFactura = disableDesPreFactura;
	}

	public StreamedContent getFilePreFactura() {
		return filePreFactura;
	}

	public void setFilePreFactura(StreamedContent filePreFactura) {
		this.filePreFactura = filePreFactura;
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



	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			 

			try {

				
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", 
						"tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"
						, "tipoEmpresa", true, "6", "<>" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratista;
	}

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public void setData3(List<ProgramacionLaboresMaqDTO> data3) {
		this.data3 = data3;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneMenu getTxtPersEmprConsulta() {
		return txtPersEmprConsulta;
	}

	public void setTxtPersEmprConsulta(SelectOneMenu txtPersEmprConsulta) {
		this.txtPersEmprConsulta = txtPersEmprConsulta;
	}

	public SelectOneMenu getTxtNivel2ClientesConsulta() {
		return txtNivel2ClientesConsulta;
	}

	public void setTxtNivel2ClientesConsulta(SelectOneMenu txtNivel2ClientesConsulta) {
		this.txtNivel2ClientesConsulta = txtNivel2ClientesConsulta;
	}

	public SelectOneMenu getTxtSupervisorConsulta() {
		return txtSupervisorConsulta;
	}

	public void setTxtSupervisorConsulta(SelectOneMenu txtSupervisorConsulta) {
		this.txtSupervisorConsulta = txtSupervisorConsulta;
	}

	public SelectOneMenu getTxtZonaConsulta() {
		return txtZonaConsulta;
	}

	public void setTxtZonaConsulta(SelectOneMenu txtZonaConsulta) {
		this.txtZonaConsulta = txtZonaConsulta;
	}

	public InputText getTxtConsecutivoConsulta() {
		return txtConsecutivoConsulta;
	}

	public void setTxtConsecutivoConsulta(InputText txtConsecutivoConsulta) {
		this.txtConsecutivoConsulta = txtConsecutivoConsulta;
	}


public SelectItem[] getSelectContratistaConsulta() {

	if (contratistaConsulta == null || contratistaConsulta.size() == 0) {

		try {

			Object[] condicion = { "estado", true, "A", "=", 
					"tipoEmpresa", true, "2", "<>" 
					, "tipoEmpresa", true, "3", "<>"
					, "tipoEmpresa", true, "5", "<>"
					, "tipoEmpresa", true, "6", "<>" };
			List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			selectContratistaConsulta = new SelectItem[lista.size()];

			int i = 0;
			for (PersEmpr contratistaConsulta : lista) {
				selectContratistaConsulta[i] = new SelectItem(contratistaConsulta.getPersEmprId(), contratistaConsulta.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectContratistaConsulta;
}

public void setSelectContratistaConsulta(SelectItem[] selectContratistaConsulta) {
	this.selectContratistaConsulta = selectContratistaConsulta;
}

public SelectItem[] getSelectNivel2ClientesConsulta() {

	if (nivel2ClientesConsulta == null || nivel2ClientesConsulta.size() == 0) {
		try {
			Long ConsultaCompania = new Long(getCompaniaIdSession());
			Long persEmprConsulta = null;

			if (txtPersEmprConsulta != null && txtPersEmprConsulta.getValue() != null) {
				persEmprConsulta = Long.parseLong(txtPersEmprConsulta.getValue().toString());

				// Criteria
				List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
						.listaNivel2Clientesmq(ConsultaCompania, persEmprConsulta);

				selectNivel2ClientesConsulta = new SelectItem[listaNivel2Clientesmq.size()];
				int i = 0;
				for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
					selectNivel2ClientesConsulta[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
							listaNivel2ClientesmqDto.getHacienda());
					i++;

				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectNivel2ClientesConsulta;
}

public void setSelectNivel2ClientesConsulta(SelectItem[] selectNivel2ClientesConsulta) {
	this.selectNivel2ClientesConsulta = selectNivel2ClientesConsulta;
}



public SelectItem[] getSelectSupervisorConsulta() {

	if (supervisor == null || supervisor.size() == 0) {

		try {

		
			Object[] condicion = { "estado", true, "A", "="};
			List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
			selectSupervisorConsulta = new SelectItem[lista.size()];

			int i = 0;
			for (Trabajador trabajador : lista) {
				selectSupervisorConsulta[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectSupervisorConsulta;
}

public void setSelectSupervisorConsulta(SelectItem[] selectSupervisorConsulta) {
	this.selectSupervisorConsulta = selectSupervisorConsulta;
}


public SelectItem[] getSelectZonaConsulta() {

	if (zonaConsulta == null || zonaConsulta.size() == 0) {

		try {
			Object[] condicion = { "estado", true, "A", "=" };
			List<ZonaGeografica> lista = businessDelegatorView.findByCriteriaInZonaGeografica(condicion, null,
					null);
			selectZonaConsulta = new SelectItem[lista.size()];

			int i = 0;
			for (ZonaGeografica zonaConsulta : lista) {
				selectZonaConsulta[i] = new SelectItem(zonaConsulta.getZonaGeograficaId(),
						zonaConsulta.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectZonaConsulta;
}

public void setSelectZonaConsulta(SelectItem[] selectZonaConsulta) {
	this.selectZonaConsulta = selectZonaConsulta;
}



public SelectItem[] getSelectLaborId() {

	if (laborId == null || laborId.size() == 0) {

		try {
			Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion",
			"<>" };
			List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
			selectLaborId = new SelectItem[lista.size()];

			int i = 0;
			for (Labor laborId : lista) {
				selectLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectLaborId;
}

public void setselectLaborId(SelectItem[] selectLaborId) {

	this.selectLaborId = selectLaborId;
}

public SelectOneMenu getTxtLaborId_Labor() {
	return txtLaborId_Labor;
}

public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
	this.txtLaborId_Labor = txtLaborId_Labor;
}



public void setSelectLaborId(SelectItem[] selectLaborId) {
	this.selectLaborId = selectLaborId;
}



}
