package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.StreamedContent;
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.ConsolidadoNominaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class interfaceCalculoDominicalesFestivosNominaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(interfaceCalculoDominicalesFestivosNominaView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsolidadoNominaDTO> data;

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

	private List<String> selectedEtapaId;
	private List<Etapa> etapas;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "false";

	private String visible = "hidden";
	private Spinner txtAnio;
	private Spinner txtMes;
	

	
	
	public interfaceCalculoDominicalesFestivosNominaView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	
	public Long calculoDominicalesFestivos() {
		try {
			// Long compania = 1L;
			Long compania = FacesUtils.checkLong(txtCompania);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//	SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			Long anio = null;
			Long mes = null;
			fechaInicial = FacesUtils.checkDate(txtFechaInicial);
			fechaFinal = FacesUtils.checkDate(txtFechaFinal);
			Long borrarNomina = null;
			Long insertNomina = null;
			// fechaInicial = sdf.parse("2013-01-01");
		//	fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			// fechaFinal = sdf.parse("2015-12-31");
		//	fechaFinal = (FacesUtils.checkDate(txtFechaFinal));		

			Long flagContratista = 1L;
			Long flagTrabajador = 1L;

			
			String contratistasSeleccionadas = "0";
			if (selectedContratista != null && selectedContratista.size() > 0) {
				contratistasSeleccionadas = selectedContratista.get(0);
				flagContratista = 0L;
				for (int i = 1; i < selectedContratista.size(); i++) {
					contratistasSeleccionadas += "," + selectedContratista.get(i);
				}
			}

			String trabajadorSeleccionadas = "0";
			if (selectedTrabajador != null && selectedTrabajador.size() > 0) {
				trabajadorSeleccionadas = selectedTrabajador.get(0);
				flagTrabajador = 0L;
				for (int i = 1; i < selectedTrabajador.size(); i++) {
					trabajadorSeleccionadas += "," + selectedTrabajador.get(i);
				}
			}

			
			if (compania != null && fechaInicial !=null && fechaFinal !=null) {
				
				
				java.util.Date hoy = new Date();
				GregorianCalendar calendario = new GregorianCalendar();
				GregorianCalendar calendario2 = new GregorianCalendar();
				
		  		// se extrae de la fecha  fechaFinOt2 el dia - mes - a??o
				calendario.setTime(fechaInicial);
				int dia = calendario.get(java.util.Calendar.DAY_OF_MONTH);
				int mesi = calendario.get(java.util.Calendar.MONTH);
				int ano = calendario.get(java.util.Calendar.YEAR);
				calendario.set(ano, mesi, dia);
				java.sql.Date fechai = new java.sql.Date(calendario.getTimeInMillis());
				
				calendario2.setTime(fechaFinal);
				int diaf = calendario2.get(java.util.Calendar.DAY_OF_MONTH);
				int mesf = calendario2.get(java.util.Calendar.MONTH);
				int anof = calendario2.get(java.util.Calendar.YEAR);
				
				calendario.set(anof, mesf, diaf);
				java.sql.Date fechaf = new java.sql.Date(calendario2.getTimeInMillis());

				long dias = 1L;
				String diasFalntantes = "";
				
			    long diffDays = ((fechaf.getTime() - fechai.getTime())/(24 * 60 * 60 * 1000))+1;
			    if(diffDays == 7) {
					borrarNomina  = businessDelegatorView.borrarCalculoDominicalesFestivosNomina(compania, fechaInicial, fechaFinal);
					 
					insertNomina = businessDelegatorView.calculoDominicalesFestivosNomina
							(compania, fechaInicial, fechaFinal, contratistasSeleccionadas, flagContratista, trabajadorSeleccionadas, flagTrabajador); 
	
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
							"La interfaz de distribuci??n del costo de la n??mina en los lotes fue ejecutada con ??xito. ",
							""));
					
					disableButton="true";
			    }else{
			    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"El per??odo seleccionado debe comprender 7 d??as (El rango debe ser equivalente a una semana del a??o). ",
							""));
					
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"La interfaz esta fallando, v??lidar que existan n??minas cargadas para el periodo seleccionado ",
					""));

		}

		return 1L;
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

	public List<ConsolidadoNominaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.consultarConsolidadoNomina(1L, null, null, null, null, null, null);
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

	public List<String> getSelectedEtapaId() {
		return selectedEtapaId;
	}

	public void setSelectedEtapaId(List<String> selectedEtapaId) {
		this.selectedEtapaId = selectedEtapaId;
	}

	public List<Etapa> getEtapa() {
		if (etapas == null || etapas.size() == 0) {
 

			try {
				etapas = businessDelegatorView.getEtapa();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return etapas;
	}

	public void setEtapa(List<Etapa> etapas) {
		this.etapas = etapas;
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

	public List<String> getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(List<String> selectedTrabajador) {
		this.selectedTrabajador = selectedTrabajador;
	}

	public List<Trabajador> getTrabajadores() {

		if (trabajador == null || trabajador.size() == 0) {
 

			try {
				trabajador = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return trabajador;
	}

	public void setTrabajadores(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
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

	/**
	 * @return the txtAnio
	 */
	public Spinner getTxtAnio() {
		return txtAnio;
	}

	/**
	 * @param txtAnio the txtAnio to set
	 */
	public void setTxtAnio(Spinner txtAnio) {
		this.txtAnio = txtAnio;
	}

	/**
	 * @return the txtMes
	 */
	public Spinner getTxtMes() {
		return txtMes;
	}

	/**
	 * @param txtMes the txtMes to set
	 */
	public void setTxtMes(Spinner txtMes) {
		this.txtMes = txtMes;
	}
	
	

}
