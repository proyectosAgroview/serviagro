package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
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

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputnumber.InputNumber;
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
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
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
public class InformeSolicitudesMttoEquipoView  implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeSolicitudesMttoEquipoView .class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	
	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<SolicitudesMttoEquipoDTO> data;

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
	
	private List<String> selectedTipoMtto;
	private List<TipoMantenimiento> tipoMtto;

	private InputNumber txtValorTotalAcumulado;
	
	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";

	public InformeSolicitudesMttoEquipoView () {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public void exportToPyGExcel() throws NumberFormatException, Exception {

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
		Long flagPropietario = 1L;
		Long flagModeloEquipo = 1L;
		Long flagEquipo = 1L;
		Long flagTipoMtto = 1L;

	
		String propietariosSeleccionadas = "";
		if (selectedPropietario != null && selectedPropietario.size() > 0) {
			propietariosSeleccionadas = selectedPropietario.get(0);
			flagPropietario = 0L;
			for (int i = 1; i < selectedPropietario.size(); i++) {
				propietariosSeleccionadas += "," + selectedPropietario.get(i);
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

		String tipoMttoSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			tipoMttoSeleccionadas = selectedEquipo.get(0);
			flagTipoMtto = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				tipoMttoSeleccionadas += "," + selectedEquipo.get(i);
			}
		}

		if (compania != null && fechaInicial!=null && fechaFinal !=null) {
			try {

				List<SolicitudesMttoEquipoDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "SolicitudesMttoEquipos.xlsx";

				data = businessDelegatorView.consultarInformeSolciitudesMttoDet(compania, fechaInicial, fechaFinal,
						propietariosSeleccionadas, flagPropietario,  equiposSeleccionadas, flagEquipo,
						tipoMttoSeleccionadas,	flagTipoMtto, 0L);
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);
					
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

					if (data != null) {
						cell = row.createCell(	0	);	cell.setCellValue("Fecha_entrada_taller"); cell.setCellStyle(style2);
						cell = row.createCell(	1	);	cell.setCellValue("Fecha_salida_taller"); cell.setCellStyle(style2);
						cell = row.createCell(	2	);	cell.setCellValue("Consecutivo"); cell.setCellStyle(style2);
						cell = row.createCell(	3	);	cell.setCellValue("Cod_equipo"); cell.setCellStyle(style2);
						cell = row.createCell(	4	);	cell.setCellValue("Nom_equipo"); cell.setCellStyle(style2);
						cell = row.createCell(	5	);	cell.setCellValue("Centro_costo"); cell.setCellStyle(style2);
						cell = row.createCell(	6	);	cell.setCellValue("Taller"); cell.setCellStyle(style2);
						cell = row.createCell(	7	);	cell.setCellValue("Horometro_entrada"); cell.setCellStyle(style2);
						cell = row.createCell(	8	);	cell.setCellValue("Odomentro_entrada"); cell.setCellStyle(style2);
						cell = row.createCell(	9	);	cell.setCellValue("Tipo_mantenimiento"); cell.setCellStyle(style2);
						cell = row.createCell(	10	);	cell.setCellValue("Plan_revision"); cell.setCellStyle(style2);
						cell = row.createCell(	11	);	cell.setCellValue("Motivo_entrda_taller"); cell.setCellStyle(style2);
						cell = row.createCell(	12	);	cell.setCellValue("Agente_causador"); cell.setCellStyle(style2);
						cell = row.createCell(	13	);	cell.setCellValue("Duracion_prevista_mtto_hh"); cell.setCellStyle(style2);
						cell = row.createCell(	14	);	cell.setCellValue("Duracion_real_hh"); cell.setCellStyle(style2);
						cell = row.createCell(	15	);	cell.setCellValue("Cod_solicitante"); cell.setCellStyle(style2);
						cell = row.createCell(	16	);	cell.setCellValue("Solicitante"); cell.setCellStyle(style2);
						cell = row.createCell(	17	);	cell.setCellValue("Cod_conductor"); cell.setCellStyle(style2);
						cell = row.createCell(	18	);	cell.setCellValue("Conductor"); cell.setCellStyle(style2);
						cell = row.createCell(	19	);	cell.setCellValue("Reporte_tecnico"); cell.setCellStyle(style2);
						cell = row.createCell(	20	);	cell.setCellValue("Fecha_trabajo_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	21	);	cell.setCellValue("Mecanicos"); cell.setCellStyle(style2);
						cell = row.createCell(	22	);	cell.setCellValue("Concepto_nomina"); cell.setCellStyle(style2);
						cell = row.createCell(	23	);	cell.setCellValue("Unidad_medida"); cell.setCellStyle(style2);
						cell = row.createCell(	24	);	cell.setCellValue("Cantidad_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	25	);	cell.setCellValue("Tarifa_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	26	);	cell.setCellValue("Costo_total_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	27	);	cell.setCellValue("Almacen_salida"); cell.setCellStyle(style2);
						cell = row.createCell(	28	);	cell.setCellValue("Autoriza"); cell.setCellStyle(style2);
						cell = row.createCell(	29	);	cell.setCellValue("Producto"); cell.setCellStyle(style2);
						cell = row.createCell(	30	);	cell.setCellValue("Um_producto"); cell.setCellStyle(style2);
						cell = row.createCell(	31	);	cell.setCellValue("Cantidad"); cell.setCellStyle(style2);
						cell = row.createCell(	32	);	cell.setCellValue("Valor_unitario"); cell.setCellStyle(style2);
						cell = row.createCell(	33	);	cell.setCellValue("Costo_total"); cell.setCellStyle(style2);
						cell = row.createCell(	34	);	cell.setCellValue("Dat_mantenimiento_equipo_id"); cell.setCellStyle(style2);
						cell = row.createCell(	35	);	cell.setCellValue("CodTag"); cell.setCellStyle(style2);
						cell = row.createCell(	36	);	cell.setCellValue("NombreTag"); cell.setCellStyle(style2);
						cell = row.createCell(	37	);	cell.setCellValue("Tarea"); cell.setCellStyle(style2);
						cell = row.createCell(	38	);	cell.setCellValue("Año"); cell.setCellStyle(style2);
						cell = row.createCell(	39	);	cell.setCellValue("MesCorto"); cell.setCellStyle(style2);
						cell = row.createCell(	40	);	cell.setCellValue("Solicitud"); cell.setCellStyle(style2);
						cell = row.createCell(	41	);	cell.setCellValue("Tipo personal"); cell.setCellStyle(style2);
						cell = row.createCell(	42	);	cell.setCellValue("Sistema"); cell.setCellStyle(style2);
						cell = row.createCell(	43	);	cell.setCellValue("Compartimiento"); cell.setCellStyle(style2);
						cell = row.createCell(	44	);	cell.setCellValue("Responsable mtto"); cell.setCellStyle(style2);
						cell = row.createCell(	45	);	cell.setCellValue("Hor/Odo entrada"); cell.setCellStyle(style2);
						
						cell = row.createCell(	46	);	cell.setCellValue("num_documento_compra"); cell.setCellStyle(style2);
						cell = row.createCell(	47	);	cell.setCellValue("nom_proveedor_compra"); cell.setCellStyle(style2);
						cell = row.createCell(	48	);	cell.setCellValue("num_factura_compra"); cell.setCellStyle(style2);
						cell = row.createCell(	49	);	cell.setCellValue("fecha_compra"); cell.setCellStyle(style2);
						cell = row.createCell(	50	);	cell.setCellValue("estadoOt"); cell.setCellStyle(style2);
						cell = row.createCell(	51	);	cell.setCellValue("Hor/Km de diferencia entre mttos"); cell.setCellStyle(style2);
						
						
						int pos_i = 8;

						for (SolicitudesMttoEquipoDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getFecha_entrada_taller().toString().substring(0,10));
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getFecha_salida_taller().toString().substring(0,10));
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getConsecutivo().doubleValue());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getCod_equipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getNom_equipo());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getCentro_costo());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getTaller());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getHorometro_entrada().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getOdomentro_entrada().doubleValue());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getTipo_mantenimiento());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getPlan_revision());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getMotivo_entrda_taller());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getAgente_causador());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getDuracion_prevista_mtto_hh());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getDuracion_real_hh().doubleValue());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getCod_solicitante());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getSolicitante());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCod_conductor());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getConductor());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getReporte_tecnico());
							cell = row.createCell(20);
							if(ndDTO.getFecha_trabajo_mec().equals(" ")){
								cell.setCellValue(ndDTO.getFecha_trabajo_mec());
									
							}else{
								cell.setCellValue(ndDTO.getFecha_trabajo_mec().substring(0,10));
									
							}
							
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getMecanicos());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getConcepto_nomina());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getUnidad_medida());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getCantidad_mec().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getTarifa_mec().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCosto_total_mec().doubleValue());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getAlmacen_salida());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getAutoriza());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getProducto());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getUm_producto());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getCantidad().doubleValue());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getValor_unitario().doubleValue());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getCosto_total().doubleValue());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getDat_mantenimiento_equipo_id().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCodTag());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNombreTag());
							
							cell = row.createCell(37);
							cell.setCellValue(ndDTO.getTarea());
							cell = row.createCell(38);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getMesCorto());

							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getDescripcionSolicitud());

							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getNomSistema());

							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getNomComprotamiento());

							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getTipoPersonal());

							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getResponsableMtto());

							
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getHoro_odo_entrada().doubleValue());

							cell = row.createCell(46);
							cell.setCellValue(ndDTO.getNumDocumentoCompra().longValue());

							cell = row.createCell(47);
							cell.setCellValue(ndDTO.getNomProveedorCompra());

							cell = row.createCell(48);
							cell.setCellValue(ndDTO.getNumFacturaCompra().longValue());
						
							cell = row.createCell(49);
							cell.setCellValue(ndDTO.getFechaCompra());

							cell = row.createCell(50);
							cell.setCellValue(ndDTO.getEstadoOt());

							cell = row.createCell(51);
							cell.setCellValue(ndDTO.getHor_dif_mtto().doubleValue());

							pos_i++;

						}

						

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;
								
						File salida = new File(rutaDescarga);
						
						FileOutputStream os = new FileOutputStream(new File(rutaDescarga+excelSalida.getName()));
						
						//FileOutputStream os = new FileOutputStream(salida);

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						file = new DefaultStreamedContent(stream, "application/xlsx", "SolicitudesMttoEquipos.xlsx");

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

	
	
	
	public void hojaVidaMaquina() throws Exception {

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
		Long flagEquipo = 1L;

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro =null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);
       fechaFinalDateRegistro = sdf.parse(fsalida);

		GregorianCalendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date); // Configuramos la fecha que se
		calendar.add(GregorianCalendar.DAY_OF_YEAR, 365); 
		
		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}
		
		if(fechaInicial==null) {
			fechaInicial = fechaFinalDateRegistro;
		}
		if(fechaFinal ==null) {
			fechaFinal = calendar.getTime();
		}
		
		if (compania != null && fechaInicial!=null && fechaFinal !=null) {
				data = null;
				Double costoTotal =0.0;
				data = businessDelegator2View.pr_hoja_vida_maquina(compania, fechaInicial, fechaFinal,
						 equiposSeleccionadas, flagEquipo);
				if(data!=null && data.size()>0) {
					for(SolicitudesMttoEquipoDTO data1 : data) {
						costoTotal+= data1.getTotalCostosMaquina().doubleValue();
					}
				}
				txtValorTotalAcumulado.setValue(costoTotal);
				txtValorTotalAcumulado.setReadonly(true);
		}
	}

	
	public void hojaVidaMaquinaExcel() throws NumberFormatException, Exception {

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
		Long flagEquipo = 1L;

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro =null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);
       fechaFinalDateRegistro = sdf.parse(fsalida);

		GregorianCalendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date); // Configuramos la fecha que se
		calendar.add(GregorianCalendar.DAY_OF_YEAR, 365); 
		
		String equiposSeleccionadas = "";
		if (selectedEquipo != null && selectedEquipo.size() > 0) {
			equiposSeleccionadas = selectedEquipo.get(0);
			flagEquipo = 0L;
			for (int i = 1; i < selectedEquipo.size(); i++) {
				equiposSeleccionadas += "," + selectedEquipo.get(i);
			}
		}
		
		if(fechaInicial==null) {
			fechaInicial = fechaFinalDateRegistro;
		}
		if(fechaFinal ==null) {
			fechaFinal = calendar.getTime();
		}
		
		

		if (compania != null && fechaInicial!=null && fechaFinal !=null) {
			try {

				List<SolicitudesMttoEquipoDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoHojaVidaMaquina.xlsx";

				data = businessDelegator2View.pr_hoja_vida_maquina(compania, fechaInicial, fechaFinal,
						 equiposSeleccionadas, flagEquipo);
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);
					
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

					if (data != null) {
						cell = row.createCell(	0	);	cell.setCellValue("Fecha_entrada_taller"); cell.setCellStyle(style2);
						cell = row.createCell(	1	);	cell.setCellValue("Fecha_salida_taller"); cell.setCellStyle(style2);
						cell = row.createCell(	2	);	cell.setCellValue("Consecutivo"); cell.setCellStyle(style2);
						cell = row.createCell(	3	);	cell.setCellValue("Cod_equipo"); cell.setCellStyle(style2);
						cell = row.createCell(	4	);	cell.setCellValue("Nom_equipo"); cell.setCellStyle(style2);
						cell = row.createCell(	5	);	cell.setCellValue("Centro_costo"); cell.setCellStyle(style2);
						cell = row.createCell(	6	);	cell.setCellValue("Taller"); cell.setCellStyle(style2);
						cell = row.createCell(	7	);	cell.setCellValue("Horometro_entrada"); cell.setCellStyle(style2);
						cell = row.createCell(	8	);	cell.setCellValue("Odomentro_entrada"); cell.setCellStyle(style2);
						cell = row.createCell(	9	);	cell.setCellValue("Tipo_mantenimiento"); cell.setCellStyle(style2);
						cell = row.createCell(	10	);	cell.setCellValue("Plan_revision"); cell.setCellStyle(style2);
						cell = row.createCell(	11	);	cell.setCellValue("Motivo_entrda_taller"); cell.setCellStyle(style2);
						cell = row.createCell(	12	);	cell.setCellValue("Agente_causador"); cell.setCellStyle(style2);
						cell = row.createCell(	13	);	cell.setCellValue("Duracion_prevista_mtto_hh"); cell.setCellStyle(style2);
						cell = row.createCell(	14	);	cell.setCellValue("Duracion_real_hh"); cell.setCellStyle(style2);
						cell = row.createCell(	15	);	cell.setCellValue("Cod_solicitante"); cell.setCellStyle(style2);
						cell = row.createCell(	16	);	cell.setCellValue("Solicitante"); cell.setCellStyle(style2);
						cell = row.createCell(	17	);	cell.setCellValue("Cod_conductor"); cell.setCellStyle(style2);
						cell = row.createCell(	18	);	cell.setCellValue("Conductor"); cell.setCellStyle(style2);
						cell = row.createCell(	19	);	cell.setCellValue("Reporte_tecnico"); cell.setCellStyle(style2);
						cell = row.createCell(	20	);	cell.setCellValue("Fecha_trabajo_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	21	);	cell.setCellValue("Mecanicos"); cell.setCellStyle(style2);
						cell = row.createCell(	22	);	cell.setCellValue("Concepto_nomina"); cell.setCellStyle(style2);
						cell = row.createCell(	23	);	cell.setCellValue("Unidad_medida"); cell.setCellStyle(style2);
						cell = row.createCell(	24	);	cell.setCellValue("Cantidad_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	25	);	cell.setCellValue("Tarifa_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	26	);	cell.setCellValue("Costo_total_mec"); cell.setCellStyle(style2);
						cell = row.createCell(	27	);	cell.setCellValue("Almacen_salida"); cell.setCellStyle(style2);
						cell = row.createCell(	28	);	cell.setCellValue("Autoriza"); cell.setCellStyle(style2);
						cell = row.createCell(	29	);	cell.setCellValue("Producto"); cell.setCellStyle(style2);
						cell = row.createCell(	30	);	cell.setCellValue("Um_producto"); cell.setCellStyle(style2);
						cell = row.createCell(	31	);	cell.setCellValue("Cantidad"); cell.setCellStyle(style2);
						cell = row.createCell(	32	);	cell.setCellValue("Valor_unitario"); cell.setCellStyle(style2);
						cell = row.createCell(	33	);	cell.setCellValue("Costo_total"); cell.setCellStyle(style2);
						cell = row.createCell(	34	);	cell.setCellValue("Dat_mantenimiento_equipo_id"); cell.setCellStyle(style2);
						cell = row.createCell(	35	);	cell.setCellValue("CodTag"); cell.setCellStyle(style2);
						cell = row.createCell(	36	);	cell.setCellValue("NombreTag"); cell.setCellStyle(style2);
						cell = row.createCell(	37	);	cell.setCellValue("Tarea"); cell.setCellStyle(style2);
						cell = row.createCell(	38	);	cell.setCellValue("Año"); cell.setCellStyle(style2);
						cell = row.createCell(	39	);	cell.setCellValue("MesCorto"); cell.setCellStyle(style2);
						cell = row.createCell(	40	);	cell.setCellValue("Solicitud"); cell.setCellStyle(style2);
						cell = row.createCell(	41	);	cell.setCellValue("Tipo personal"); cell.setCellStyle(style2);
						cell = row.createCell(	42	);	cell.setCellValue("Sistema"); cell.setCellStyle(style2);
						cell = row.createCell(	43	);	cell.setCellValue("Compartimiento"); cell.setCellStyle(style2);
						cell = row.createCell(	44	);	cell.setCellValue("Responsable mtto"); cell.setCellStyle(style2);
						cell = row.createCell(	45	);	cell.setCellValue("Hor/Odo entrada"); cell.setCellStyle(style2);
						cell = row.createCell(	46	);	cell.setCellValue("Valor gastos"); cell.setCellStyle(style2);
						cell = row.createCell(	47	);	cell.setCellValue("Total costos máquina"); cell.setCellStyle(style2);
						cell = row.createCell(	48	);	cell.setCellValue("Origen datos"); cell.setCellStyle(style2);
						cell = row.createCell(	49	);	cell.setCellValue("Categoria"); cell.setCellStyle(style2);
						cell = row.createCell(	50	);	cell.setCellValue("Tipo Producto"); cell.setCellStyle(style2);
						
						int pos_i = 8;

						for (SolicitudesMttoEquipoDTO ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getFecha_entrada_taller());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getFecha_salida_taller());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getConsecutivo().doubleValue());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getCod_equipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getNom_equipo());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getCentro_costo());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getTaller());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getHorometro_entrada().doubleValue());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getOdomentro_entrada().doubleValue());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getTipo_mantenimiento());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getPlan_revision());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getMotivo_entrda_taller());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getAgente_causador());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getDuracion_prevista_mtto_hh());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getDuracion_real_hh().doubleValue());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getCod_solicitante());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getSolicitante());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCod_conductor());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getConductor());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getReporte_tecnico());
							cell = row.createCell(20);
							if(ndDTO.getFecha_trabajo_mec().equals(" ")){
								cell.setCellValue(ndDTO.getFecha_trabajo_mec());
									
							}else{
								cell.setCellValue(ndDTO.getFecha_trabajo_mec().substring(0,10));
									
							}
							
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getMecanicos());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getConcepto_nomina());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getUnidad_medida());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getCantidad_mec().doubleValue());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getTarifa_mec().doubleValue());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCosto_total_mec().doubleValue());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getAlmacen_salida());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getAutoriza());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getProducto());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getUm_producto());
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getCantidad().doubleValue());
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getValor_unitario().doubleValue());
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getCosto_total().doubleValue());
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getDat_mantenimiento_equipo_id().doubleValue());
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCodTag());
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNombreTag());
							
							cell = row.createCell(37);
							cell.setCellValue(ndDTO.getTarea());
							cell = row.createCell(38);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getMesCorto());

							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getDescripcionSolicitud());
							
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getTipoPersonal());
							
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getNomSistema());

							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getNomComprotamiento());

						
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getResponsableMtto());

							
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getHoro_odo_entrada().doubleValue());

							cell = row.createCell(46);
							cell.setCellValue(ndDTO.getCostoTotalGastos().doubleValue());

							cell = row.createCell(47);
							cell.setCellValue(ndDTO.getTotalCostosMaquina().doubleValue());

							cell = row.createCell(48);
							cell.setCellValue(ndDTO.getOrigenDatos());

							cell = row.createCell(49);
							cell.setCellValue(ndDTO.getCategoriaEquipo());

							cell = row.createCell(50);
							cell.setCellValue(ndDTO.getNomTipoProducto());

							pos_i++;

						}

						

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;
								
						File salida = new File(rutaDescarga);
						
						FileOutputStream os = new FileOutputStream(new File(rutaDescarga+excelSalida.getName()));
						
						//FileOutputStream os = new FileOutputStream(salida);

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoHojaVidaMaquina.xlsx");

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

	

	public List<SolicitudesMttoEquipoDTO> getData() {
		return data;
	}

	public void setData(List<SolicitudesMttoEquipoDTO> data) {
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

	public List<String> getSelectedTipoMtto() {
		return selectedTipoMtto;
	}

	public void setSelectedTipoMtto(List<String> selectedTipoMtto) {
		this.selectedTipoMtto = selectedTipoMtto;
	}

	public List<TipoMantenimiento> getTipoMtto() {
		if (tipoMtto == null || tipoMtto.size() == 0) {

				try {
				tipoMtto = businessDelegatorView.getTipoMantenimiento();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return tipoMtto;
	}

	public void setTipoMantenimiento(List<TipoMantenimiento> tipoMtto) {
		this.tipoMtto = tipoMtto;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
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


}
