package co.com.arcosoft.presentation.backingBeans;

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
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
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
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class proyeccionLaboresARealizarView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(proyeccionLaboresARealizarView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private ProyeccionLaboresLoteDTO entityReport;
	SelectItem[] selectProyeccionLaboresLote;
	
	private List<ProyeccionLaboresLoteDTO> data;
	
	List<ProyeccionLaboresLoteDTO> selectedDatPlanLabor;
	
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

	private ScheduleModel eventModel;

	private ScheduleModel lazyEventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();
	private String disableNivel1 = "true";
	private String disableButton = "false";
	
	public proyeccionLaboresARealizarView() {
		super();
	}

	public String action_informe1() {
		// RequestContext.getCurrentInstance().reset(":frm:dialog :frm");
		setShowDialog(true);
		return "";
	}

	public BarChartModel getbarModel1() throws NumberFormatException, Exception {

		createbarModel1();

		return barModel1;
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

	private void createbarModel1() throws NumberFormatException, Exception {
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
			flagTenencia = 0L;
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

		barModel1 = new BarChartModel();
		barModel1.setLegendPosition("w");

		// barModel1.setTitle("Distribucion Area Variedad");

		ChartSeries series = new ChartSeries();
		series.setLabel("Lote");
		barModel1.setTitle("Área por lotes agrícolas");
		barModel1.setLegendPosition("ne");

		List<ProyeccionLaboresLoteDTO> data;
		try {

			data = businessDelegatorView.consultarInformeProyeccionLaboresLote(compania, fechaInicial, fechaFinal,
					cultivosSeleccionadas, flagCultivo, zonasSeleccionadas, flagZona, fincasSeleccionadas, flagFinca,
					bloquesSeleccionadas, flagBloque, lotesSeleccionadas, flagLote, laboresSeleccionadas, flagLabor,
					unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas, flagGrupoLabor,
					tenenciasSeleccionadas, flagTenencia, cronogramaLaboresSeleccionadas, flagCronogramaLabores);

			if (data == null || data.isEmpty()) {
				// pieModel1.set("Sin datos", 0L);
				series.set("Sin datos", 0L);
				barModel1.addSeries(series);
				return;
			}

			for (ProyeccionLaboresLoteDTO ProyeccionLaboresLoteDTO : data) {
				// barModel1.set(distribucionAreaVariedadDTO.getVariedad(),
				// distribucionAreaVariedadDTO.getArea());
				series.set(ProyeccionLaboresLoteDTO.getDescripcion(), ProyeccionLaboresLoteDTO.getDuracion());
				// series.setLabel(Integer.toString(ProntuarioLotesDTO.getAnio()));
			}

			barModel1.addSeries(series);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public List<ProyeccionLaboresLoteDTO> getData() {
		try {

//			eventModel = new DefaultScheduleModel();
			
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
				flagTenencia = 0L;
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

			if (compania != null && fechaInicial != null && fechaFinal != null) {
				List<ProyeccionLaboresLoteDTO> d1 = businessDelegatorView.consultarInformeProyeccionLaboresLote(compania, fechaInicial, fechaFinal,
						cultivosSeleccionadas, flagCultivo, zonasSeleccionadas, flagZona, fincasSeleccionadas,
						flagFinca, bloquesSeleccionadas, flagBloque, lotesSeleccionadas, flagLote, laboresSeleccionadas,
						flagLabor, unidadesMedidaSeleccionadas, flagUnidadMedida, grupoLaboresSeleccionadas,
						flagGrupoLabor, tenenciasSeleccionadas, flagTenencia, cronogramaLaboresSeleccionadas,
						flagCronogramaLabores);
				if(d1 !=null){
					data = d1;
					disableNivel1 = "false";
				}else{data = null;
				}
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	/*****************************/

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);

		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/***************************/
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

	public List<String> getselectedCronogramaLabores() {
		return selectedCronogramaLabores;
	}

	public void setselectedCronogramaLabores(List<String> selectedCronogramaLabores) {
		this.selectedCronogramaLabores = selectedCronogramaLabores;
	}

	public List<CronogramaLabores> getCronogramasLabores() {
		if (cronogramasLabores == null || cronogramasLabores.size() == 0) {

			cronogramasLabores = new ArrayList<CronogramaLabores>();

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

	public List<String> getSelectCultivo() {
		return selectCultivo;
	}

	public void setSelectCultivo(List<String> selectCultivo) {
		this.selectCultivo = selectCultivo;
	}

	public List<Cultivo> getCultivos() {

		if (cultivos == null || cultivos.size() == 0) {

			cultivos = new ArrayList<Cultivo>();

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

	public List<String> getSelectSupervisor() {
		return selectSupervisor;
	}

	public void setSelectSupervisor(List<String> selectSupervisor) {
		this.selectSupervisor = selectSupervisor;
	}

	public List<Trabajador> getsupervisores() {

		if (supervisores == null || supervisores.size() == 0) {

			supervisores = new ArrayList<Trabajador>();

			try {
				supervisores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return supervisores;
	}

	public void setsupervisores(List<Trabajador> supervisores) {
		this.supervisores = supervisores;
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

	public ProyeccionLaboresLoteDTO getEntityReport() {
		return entityReport;
	}

	public void setEntityReport(ProyeccionLaboresLoteDTO entityReport) {
		this.entityReport = entityReport;
	}

	/**
	 * @return the selectProyeccionLaboresLote
	 */
	public SelectItem[] getSelectProyeccionLaboresLote() {
		return selectProyeccionLaboresLote;
	}

	/**
	 * @param selectProyeccionLaboresLote the selectProyeccionLaboresLote to set
	 */
	public void setSelectProyeccionLaboresLote(SelectItem[] selectProyeccionLaboresLote) {
		this.selectProyeccionLaboresLote = selectProyeccionLaboresLote;
	}

	/**
	 * @return the selectedCronogramaLabores
	 */
	public List<String> getSelectedCronogramaLabores() {
		return selectedCronogramaLabores;
	}

	/**
	 * @param selectedCronogramaLabores the selectedCronogramaLabores to set
	 */
	public void setSelectedCronogramaLabores(List<String> selectedCronogramaLabores) {
		this.selectedCronogramaLabores = selectedCronogramaLabores;
	}

	/**
	 * @return the selectedDatPlanLabor
	 */
	public List<ProyeccionLaboresLoteDTO> getSelectedDatPlanLabor() {
		return selectedDatPlanLabor;
	}

	/**
	 * @param selectedDatPlanLabor the selectedDatPlanLabor to set
	 */
	public void setSelectedDatPlanLabor(List<ProyeccionLaboresLoteDTO> selectedDatPlanLabor) {
		this.selectedDatPlanLabor = selectedDatPlanLabor;
	}

	/**
	 * @return the disableNivel1
	 */
	public String getDisableNivel1() {
		return disableNivel1;
	}

	/**
	 * @param disableNivel1 the disableNivel1 to set
	 */
	public void setDisableNivel1(String disableNivel1) {
		this.disableNivel1 = disableNivel1;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<ProyeccionLaboresLoteDTO> data) {
		this.data = data;
	}

	/**
	 * @return the disableButton
	 */
	public String getDisableButton() {
		return disableButton;
	}

	/**
	 * @param disableButton the disableButton to set
	 */
	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}
	
	


	
	public void action_valoresSeleccionados() throws Exception {
		String a ="";
		String cadena = "";
		Long flagZona=1L;


		ProyeccionLaboresLoteDTO zonasSeleccionadas = null;
		if (selectedDatPlanLabor != null && selectedDatPlanLabor.size() > 0) {
			zonasSeleccionadas = selectedDatPlanLabor.get(0);
			flagZona = 0L;
			for (int i = 0; i < selectedDatPlanLabor.size(); i++) {
				zonasSeleccionadas =  selectedDatPlanLabor.get(i);
				cadena += "," + zonasSeleccionadas.getCod_lote().toString();
			}
		}
	
	cadena = '0'+cadena;
		
	businessDelegatorView.aprobarOrdenesServicioNivel1(cadena);
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
			"Se han actualizado las ordenes con éxito "));
	disableButton = "true";
	
	}
	


	
}
