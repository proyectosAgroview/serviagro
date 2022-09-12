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
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.MttoCheckListEquipoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeMttoCheckListEquipoView  implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeMttoCheckListEquipoView .class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<MttoCheckListEquipoDTO> data;

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


	private StreamedContent file = null;
	private String disableButton = "true";

	private String visible = "hidden";

	public InformeMttoCheckListEquipoView () {
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

		if (compania != null) {
			try {

				List<MttoCheckListEquipoDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoCheckListEquipos.xlsx";

				data = businessDelegatorView.consultarInformeCheckListEquipo(compania, fechaInicial, fechaFinal,
						propietariosSeleccionadas, flagPropietario,  equiposSeleccionadas, flagEquipo);
				
				
				 
				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					style2.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style2.setBorderRight((CellStyle.BORDER_MEDIUM));
					style2.setBorderTop((CellStyle.BORDER_MEDIUM));
					style2.setBorderBottom((CellStyle.BORDER_MEDIUM));

					style2.setAlignment(CellStyle.ALIGN_CENTER);

					sheet.setForceFormulaRecalculation(true);

					if (data != null) {
						cell = row.createCell(	0	);	cell.setCellValue("fecha_registro");  cell.setCellStyle(style2);
						cell = row.createCell(	1	);	cell.setCellValue("consecutivo");  cell.setCellStyle(style2);
						cell = row.createCell(	2	);	cell.setCellValue("Cod_equipo");  cell.setCellStyle(style2);
						cell = row.createCell(	3	);	cell.setCellValue("nom_equipo");  cell.setCellStyle(style2);
						cell = row.createCell(	4	);	cell.setCellValue("nom_medidor");  cell.setCellStyle(style2);
						cell = row.createCell(	5	);	cell.setCellValue("horometro_entrada");  cell.setCellStyle(style2);
						cell = row.createCell(	6	);	cell.setCellValue("odomentro_entrada");  cell.setCellStyle(style2);
						cell = row.createCell(	7	);	cell.setCellValue("cod_supervisor_mtto");  cell.setCellStyle(style2);
						cell = row.createCell(	8	);	cell.setCellValue("nom_supervisor_mtto");  cell.setCellStyle(style2);
						cell = row.createCell(	9	);	cell.setCellValue("observacion");  cell.setCellStyle(style2);
						cell = row.createCell(	10	);	cell.setCellValue("dat_check_list_equipo_id");  cell.setCellStyle(style2);
						cell = row.createCell(	11	);	cell.setCellValue("codtag");  cell.setCellStyle(style2);
						cell = row.createCell(	12	);	cell.setCellValue("nombretag");  cell.setCellStyle(style2);
						cell = row.createCell(	13	);	cell.setCellValue("añio");  cell.setCellStyle(style2);
						cell = row.createCell(	14	);	cell.setCellValue("mes_corto");  cell.setCellStyle(style2);
						cell = row.createCell(	15	);	cell.setCellValue("cod_sistemas_equipo");  cell.setCellStyle(style2);
						cell = row.createCell(	16	);	cell.setCellValue("nom_sistemas_equipo");  cell.setCellStyle(style2);
						cell = row.createCell(	17	);	cell.setCellValue("cod_compartimiento_equipo");  cell.setCellStyle(style2);
						cell = row.createCell(	18	);	cell.setCellValue("nom_compartimiento_equipo");  cell.setCellStyle(style2);
						cell = row.createCell(	19	);	cell.setCellValue("condicion_limpieza");  cell.setCellStyle(style2);
						cell = row.createCell(	20	);	cell.setCellValue("condicion_ruido");  cell.setCellStyle(style2);
						cell = row.createCell(	21	);	cell.setCellValue("condicion_soldadura");  cell.setCellStyle(style2);
						cell = row.createCell(	22	);	cell.setCellValue("condicion_conexiones");  cell.setCellStyle(style2);
						cell = row.createCell(	23	);	cell.setCellValue("condicion_vibracion");  cell.setCellStyle(style2);
						cell = row.createCell(	24	);	cell.setCellValue("condicion_estado_general");  cell.setCellStyle(style2);
						cell = row.createCell(	25	);	cell.setCellValue("condicion_pintura");  cell.setCellStyle(style2);
						cell = row.createCell(	26	);	cell.setCellValue("condicion_lubricantes");  cell.setCellStyle(style2);
						
						int pos_i = 8;

						for ( MttoCheckListEquipoDTO  ndDTO : data) {

							row = sheet.createRow(pos_i);

							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getFecha_registro().toString().substring(0,10));
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getConsecutivo().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCod_equipo());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNom_equipo());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getHorometro_entrada().doubleValue());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getOdomentro_entrada().doubleValue());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getCod_supervisor_mtto());
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getNom_supervisor_mtto());
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getObservacion());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getDat_check_list_equipo_id().intValue());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getCodtag());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getNombretag());
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getAnio());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getMes_corto());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getCod_sistemas_equipo());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getNom_sistemas_equipo());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getCod_compartimiento_equipo());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getNom_compartimiento_equipo());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getCondicion_limpieza());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCondicion_ruido());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCondicion_soldadura());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getCondicion_conexiones());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCondicion_vibracion());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getCondicion_estado_general());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getCondicion_pintura());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCondicion_pintura());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCondicion_lubricantes());
							

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "MttoCheckListEquipos.xlsx");

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

	public List<MttoCheckListEquipoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.consultarInformeCheckListEquipo(null, null, null, null, null, null, null);
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

	public List<String> getSelectedPropietario() {
		return selectedPropietario;
	}

	public void setSelectedPropietario(List<String> selectedPropietario) {
		this.selectedPropietario = selectedPropietario;
	}

	public List<PersEmpr> getPropietarios() {
		if (propietarios == null || propietarios.size() == 0) {

			propietarios = new ArrayList<PersEmpr>();

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

			modelos = new ArrayList<ModeloEquipo>();

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

			equipos = new ArrayList<Equipo>();

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

	public List<String> getSelectedTipoMtto() {
		return selectedTipoMtto;
	}

	public void setSelectedTipoMtto(List<String> selectedTipoMtto) {
		this.selectedTipoMtto = selectedTipoMtto;
	}

	public List<TipoMantenimiento> getTipoMtto() {
		if (tipoMtto == null || tipoMtto.size() == 0) {

			tipoMtto = new ArrayList<TipoMantenimiento>();

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

}
