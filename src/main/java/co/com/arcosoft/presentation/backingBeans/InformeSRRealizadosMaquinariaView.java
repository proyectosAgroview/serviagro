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

import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
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
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
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
public class InformeSRRealizadosMaquinariaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeSRRealizadosMaquinariaView.class);

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

	private List<ConsultaServiciosRealizadosMaquinariaDTO> data;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> data2;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> data3;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> dataLaborImplemento;
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
	String cadenaPrefactura = "";
	private InputText txtPin;
	private InputText txtConsecutivoRdl;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;
	private ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> selectedDatServRealizadosEquipo2;

	public InformeSRRealizadosMaquinariaView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public void serviciosRealizadosMaquinaria() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRMaquinariaDet.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0L);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("GL/HORA PROMEDIO");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("ID PROGRAMACION");
						cell.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getGlHoraPromDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getIdProgramacion().longValue());
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoSRMaquinariaDet.xlsx");

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

	public void laboresMecanizadas() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoLaboresMecanizadas.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0L);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("HORAS EQUIPO DIA");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(46);
						cell.setCellValue("ZONA GEOGRAFICA");
						cell.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getHorasEquipoDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoPrefactura().doubleValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());

							cell = row.createCell(46);
							cell.setCellValue(ndDTO.getNomZonaGeografica());

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoLaboresMecanizadas.xlsx");

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

	public ConsultaServiciosRealizadosMaquinariaDTO getSelectedDatServRealizadosEquipo() {
		return selectedDatServRealizadosEquipo;
	}

	public void setSelectedDatServRealizadosEquipo(
			ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo) {
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

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getSelectedDatServRealizadosEquipo2() {
		return selectedDatServRealizadosEquipo2;
	}

	public void setSelectedDatServRealizadosEquipo2(
			List<ConsultaServiciosRealizadosMaquinariaDTO> selectedDatServRealizadosEquipo2) {
		this.selectedDatServRealizadosEquipo2 = selectedDatServRealizadosEquipo2;
	}

	public void setData2(List<ConsultaServiciosRealizadosMaquinariaDTO> data2) {
		this.data2 = data2;
	}

	public void setData(List<ConsultaServiciosRealizadosMaquinariaDTO> data) {
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
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "4", "=" };
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

	public void setData3(List<ConsultaServiciosRealizadosMaquinariaDTO> data3) {
		this.data3 = data3;
	}

	public void setDataLaborImplemento(List<ConsultaServiciosRealizadosMaquinariaDTO> dataLaborImplemento) {
		this.dataLaborImplemento = dataLaborImplemento;
	}

	public InputText getTxtPin() {
		return txtPin;
	}

	public void setTxtPin(InputText txtPin) {
		this.txtPin = txtPin;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData() {
		return data;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData2() {
		return data2;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData3() {
		return data3;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getDataLaborImplemento() {
		return dataLaborImplemento;
	}

	public void estadisticaCliente() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoEstadisticaCliente.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0L);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("HORAS EQUIPO DIA");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);
						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getHorasEquipoDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoPrefactura().doubleValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoEstadisticaCliente.xlsx");

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

	public void estadisticaServicio() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoEstadisticaServicio.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0L);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("HORAS EQUIPO DIA");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getHorasEquipoDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoPrefactura().doubleValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());
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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoEstadisticaServicio.xlsx");

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

	public InputText getTxtConsecutivoRdl() {
		return txtConsecutivoRdl;
	}

	public void setTxtConsecutivoRdl(InputText txtConsecutivoRdl) {
		this.txtConsecutivoRdl = txtConsecutivoRdl;
	}

	public void consultaServRealizadosEquipoDetCombustible() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRMaquinariaCombustibleOperario.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDetCombustible(compania, estadoServicio,
						fechaInicial, fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("GL/HORA PROMEDIO");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("ID PROGRAMACION");
						cell.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getGlHoraPromDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getIdProgramacion().longValue());
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

						file = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoSRMaquinariaCombustibleOperario.xlsx");

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

	public void novedadesRdl() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoMaqNovedadesRDL.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0L);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("GL/HORA PROMEDIO");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("ID PROGRAMACION");
						cell.setCellStyle(style2);

						cell = row.createCell(46);
						cell.setCellValue("OBSERVACION");
						cell.setCellStyle(style2);
						cell = row.createCell(47);
						cell.setCellValue("PARADA POR MTTO");
						cell.setCellStyle(style2);
						cell = row.createCell(48);
						cell.setCellValue("TIPO MTTO");
						cell.setCellStyle(style2);
						cell = row.createCell(49);
						cell.setCellValue("HORMETRO MTTO");
						cell.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getGlHoraPromDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getIdProgramacion().longValue());

							cell = row.createCell(46);
							cell.setCellValue(ndDTO.getObservacion());
							cell = row.createCell(47);
							cell.setCellValue(ndDTO.getReportar_novedadparada());
							cell = row.createCell(48);
							cell.setCellValue(ndDTO.getTipo_mtto_texto());
							cell = row.createCell(49);
							cell.setCellValue(ndDTO.getHorometro_mtto().doubleValue());

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoMaqNovedadesRDL.xlsx");

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

	public SelectItem[] getSelectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCost = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCost[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCost;
	}

	public void setselectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public void serviciosRealizadosMaquinariaCentroCosto() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);

		Long centCostId = 0L;
		if (txtCentCostId_CentCost.getValue() != null) {
			centCostId = FacesUtils.checkLong(txtCentCostId_CentCost);
		}
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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRMaquinariaCentroCosto.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, centCostId);

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

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("GL/HORA PROMEDIO");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("CONSECUTIVO RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("ID PROGRAMACION");
						cell.setCellStyle(style2);
						cell = row.createCell(46);
						cell.setCellValue("CENTRO DE COSTO");
						cell.setCellStyle(style2);
						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getGlHoraPromDia().doubleValue());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoRdl().longValue());
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getIdProgramacion().longValue());
							cell = row.createCell(46);
							cell.setCellValue(ndDTO.getNombreCentCosto());
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

						file = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoSRMaquinariaCentroCosto.xlsx");

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

	public void rendimientoLaboresMecanizadas() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);


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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRRendimientoLaboresMecanizadas.xlsx";

				data = businessDelegator2View.pr_consulta_serv_realizados_equipo_det_combustible2(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(0);
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
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("MES CORTO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("Rendimiento");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);

						cell = row.createCell(14);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(25);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("ID REGISTRO DETALLE");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("ID PROGRAMACION");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("CENTRO DE COSTO");
						cell.setCellStyle(style2);
					
						cell = row.createCell(34);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						
						cell = row.createCell(35);
						cell.setCellValue("GRUPO LABOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(36);
						cell.setCellValue("ZONA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(37);
						cell.setCellValue("ID REG. COMBUSTIBLE");
						cell.setCellStyle(style2);
						
						cell = row.createCell(38);
						cell.setCellValue("HOROMETRO TANQUEO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(39);
						cell.setCellValue("HOROMETRO TANQUEO ANTERIOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(40);
						cell.setCellValue("HORAS TANQUEO");
						cell.setCellStyle(style2);
						
						int pos_i = 1;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							String mesTexto = "";
							if (ndDTO.getMes().longValue() == 1l) {
								 mesTexto = "01-Enero";
							}
							if (ndDTO.getMes().longValue() == 2l) {
								 mesTexto = "02-Febrero";
							}
							if (ndDTO.getMes().longValue() == 3l) {
								 mesTexto = "03-Marzo";
							}
							if (ndDTO.getMes().longValue() == 4l) {
								 mesTexto = "04-Abril";
							}
							if (ndDTO.getMes().longValue() == 5l) {
								 mesTexto = "05-Mayo";
							}
							if (ndDTO.getMes().longValue() == 6l) {
								 mesTexto = "06-Junio";
							}
							if (ndDTO.getMes().longValue() == 7l) {
								 mesTexto = "07-Julio";
							}
							if (ndDTO.getMes().longValue() == 8l) {
								 mesTexto = "08-Agosto";
							}
							if (ndDTO.getMes().longValue() == 9l) {
								 mesTexto = "09-Septiembre";
							}
							if (ndDTO.getMes().longValue() == 10l) {
								 mesTexto = "10-Octubre";
							}
							if (ndDTO.getMes().longValue() == 11l) {
								 mesTexto = "11-Noviembre";
							}
							if (ndDTO.getMes().longValue() == 12l) {
								 mesTexto = "12-Diciembre";
							}
							cell.setCellValue(mesTexto);

							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(9);
							 
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							Double rendimiento =0.0;
							if(ndDTO.getHoras()!=null && ndDTO.getCantidadPago()!=null && ndDTO.getHoras().doubleValue()>0.0 ) {
								rendimiento=  (double) Math.round(( ndDTO.getCantidadPago().doubleValue()/ndDTO.getHoras().doubleValue()) * 1000) / 1000;
							}
							cell.setCellValue(rendimiento);
							
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getFechaRegistro());
							cell.setCellStyle(style5);
 
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							
							
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomCliente());
							
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getTurno());
							
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getNom_operario());
							
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(25);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(26);
							cell.setCellValue(fechaF);

							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getIdProgramacion().longValue());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNombreCentCosto());
							
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getNomGrupoGasto());
							
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNomZonaGeografica());
							
							cell = row.createCell(37);
							cell.setCellValue(ndDTO.getPrecioProdId().longValue());
							
							cell = row.createCell(38);
							cell.setCellValue(ndDTO.getHorometroTanqueo().doubleValue());
							
							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getHorometroTanqueoAnterior().doubleValue());
							
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getHorasTanqueo().doubleValue());
							
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

						file = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoSRRendimientoLaboresMecanizadas.xlsx");

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
	
	public void ingresosMaquinas() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String estadoServicio = FacesUtils.checkString(txtEstadoServicio);


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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagNivel2Clientesmq = 1L;
		Long flagOperador = 1L;
		Long flagClientes = 1L;

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
			flagTenencia = 0L;
			for (int i = 1; i < selectedTenencia.size(); i++) {
				tenenciasSeleccionadas += "," + selectedTenencia.get(i);
			}
		}

		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
			}
		}

		String modelosSeleccionadas = "";
		if (selectedModelo != null && selectedModelo.size() > 0) {
			modelosSeleccionadas = selectedModelo.get(0);
			flagModeloEquipo = 0L;
			for (int i = 1; i < selectedModelo.size(); i++) {
				modelosSeleccionadas += "," + selectedModelo.get(i);
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

		if (compania != null && fechaInicial != null && fechaFinal != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRIngresoLaboresMecanizadas.xlsx";

				data = businessDelegator2View.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial,
						fechaFinal, clientesSeleccionadas, flagClientes, nivel2ClientesmqSeleccionadas,
						flagNivel2Clientesmq, operadorSeleccionadas, flagOperador, laboresSeleccionadas, flagLabor,
						unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
						equiposSeleccionadas, flagEquipo, 0L, 0L, 0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(0);
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
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("MES CORTO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("Rendimiento");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);

						cell = row.createCell(14);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("TIPO DE HORA");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(25);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("RDL");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("ID REGISTRO DETALLE");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("ID PROGRAMACION");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("CENTRO DE COSTO");
						cell.setCellStyle(style2);
					
						cell = row.createCell(34);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						
						cell = row.createCell(35);
						cell.setCellValue("GRUPO LABOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(36);
						cell.setCellValue("ZONA");
						cell.setCellStyle(style2);
						
						cell = row.createCell(37);
						cell.setCellValue("ID REG. COMBUSTIBLE");
						cell.setCellStyle(style2);
						
						cell = row.createCell(38);
						cell.setCellValue("HOROMETRO TANQUEO");
						cell.setCellStyle(style2);
						
						cell = row.createCell(39);
						cell.setCellValue("HOROMETRO TANQUEO ANTERIOR");
						cell.setCellStyle(style2);
						
						cell = row.createCell(40);
						cell.setCellValue("HORAS TANQUEO");
						cell.setCellStyle(style2);
						
						int pos_i = 1;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(2);
							String mesTexto = "";
							if (ndDTO.getMes().longValue() == 1l) {
								 mesTexto = "01-Enero";
							}
							if (ndDTO.getMes().longValue() == 2l) {
								 mesTexto = "02-Febrero";
							}
							if (ndDTO.getMes().longValue() == 3l) {
								 mesTexto = "03-Marzo";
							}
							if (ndDTO.getMes().longValue() == 4l) {
								 mesTexto = "04-Abril";
							}
							if (ndDTO.getMes().longValue() == 5l) {
								 mesTexto = "05-Mayo";
							}
							if (ndDTO.getMes().longValue() == 6l) {
								 mesTexto = "06-Junio";
							}
							if (ndDTO.getMes().longValue() == 7l) {
								 mesTexto = "07-Julio";
							}
							if (ndDTO.getMes().longValue() == 8l) {
								 mesTexto = "08-Agosto";
							}
							if (ndDTO.getMes().longValue() == 9l) {
								 mesTexto = "09-Septiembre";
							}
							if (ndDTO.getMes().longValue() == 10l) {
								 mesTexto = "10-Octubre";
							}
							if (ndDTO.getMes().longValue() == 11l) {
								 mesTexto = "11-Noviembre";
							}
							if (ndDTO.getMes().longValue() == 12l) {
								 mesTexto = "12-Diciembre";
							}
							cell.setCellValue(mesTexto);

							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getCodFinca());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomFinca());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell = row.createCell(9);
							 
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell = row.createCell(11);
							Double rendimiento =0.0;
							if(ndDTO.getHoras()!=null && ndDTO.getCantidadPago()!=null && ndDTO.getHoras().doubleValue()>0.0 ) {
								rendimiento=  (double) Math.round(( ndDTO.getCantidadPago().doubleValue()/ndDTO.getHoras().doubleValue()) * 1000) / 1000;
							}
							cell.setCellValue(rendimiento);
							
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getCodLote());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getFechaRegistro());
							cell.setCellStyle(style5);
 
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							
							
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomCliente());
							
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getTurno());
							
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getNom_operario());
							
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							if(ndDTO.getNomGrupoGasto().equals("TRASLADOS DE MAQUINARIA")) {
								cell.setCellValue("IMPRODUCTIVA");
							}else {
								cell.setCellValue("PRODUCTIVA");
							}
							
							
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getNom_implemento());

							cell = row.createCell(25);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);

							cell = row.createCell(26);
							cell.setCellValue(fechaF);

							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getDocFactura());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getIdProgramacion().longValue());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNombreCentCosto());
							
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getNomGrupoGasto());
							
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNomZonaGeografica());
							
							cell = row.createCell(37);
							cell.setCellValue(ndDTO.getPrecioProdId().longValue());
							
							cell = row.createCell(38);
							cell.setCellValue(ndDTO.getHorometroTanqueo().doubleValue());
							
							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getHorometroTanqueoAnterior().doubleValue());
							
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getHorasTanqueo().doubleValue());
							
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

						file = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoSRIngresoLaboresMecanizadas.xlsx");

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
