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
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
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
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.CostosTotalesDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
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
public class informeCostosAgricolasParte2View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(informeCostosAgricolasParte2View.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<CostosTotalesDTO> data;

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

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedEtapaId;
	private List<Etapa> etapas;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;
	
	private SelectOneMenu txtEtapa;
	SelectItem[] selectEtapa;
	private List<Etapa> etapa;

	private StreamedContent file = null;
	private String disableButton = "true";
	private String visible = "hidden";
	
	private SelectOneMenu txtHacienda;
	SelectItem[] selectHacienda;
	
	private SelectOneMenu txtLote;
	SelectItem[] selectLote;
	
	private InputNumber txtDiasLabor;
	
	private InputNumber txtTCHEstimado;
	private InputNumber txtValorUnitarioTonelada;

	public informeCostosAgricolasParte2View() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
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

	public List<CostosTotalesDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.consultarInformeCostosTotales(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null);
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
	

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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
	
	public SelectItem[] getSelectEtapa() {

		if (txtLote != null && txtLote.getValue() != null) {
		try {

			
				Long compania = new Long(getCompaniaIdSession());
				Long nivel4Id = FacesUtils.checkLong(txtLote);				
				List<ListaNivel4DTO> lista = businessDelegator2View.pr_lista_etapas_lotes_cosechados(compania, nivel4Id);
				selectEtapa = new SelectItem[lista.size()];
	
				int i = 0;
				for (ListaNivel4DTO nivel4 : lista) {
					selectEtapa[i] = new SelectItem(nivel4.getEtapaId(), nivel4.getNomEtapa());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEtapa;
	}

	public void setSelectEtapa(SelectItem[] selectEtapa) {
		this.selectEtapa = selectEtapa;
	}
	public void setselectEtapa(SelectItem[] selectEtapa) {
		this.selectEtapa = selectEtapa;
	}
	
	public SelectOneMenu getTxtEtapa() {
		return txtEtapa;
	}

	public void setTxtEtapa(SelectOneMenu txtEtapa) {
		this.txtEtapa = txtEtapa;
	}


	public SelectItem[] getSelectHacienda() {

		if (selectHacienda == null || selectHacienda.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectHacienda = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2 : lista) {
					selectHacienda[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectHacienda;
	}

	public void setSelectHacienda(SelectItem[] selectHacienda) {
		this.selectHacienda = selectHacienda;
	}

	public SelectItem[] getSelectLote() {
		
		if (txtHacienda != null && txtHacienda.getValue() != null) {
	
			try {

				Long compania = new Long(getCompaniaIdSession());
				String nivel2Id = FacesUtils.checkString(txtHacienda);				
				List<ListaNivel4DTO> lista = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
				selectLote = new SelectItem[lista.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : lista) {
					selectLote[i] = new SelectItem(nivel4.getNivel4_id(), nivel4.getNom_nivel4());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLote;
	}

	public void setSelectLote(SelectItem[] selectLote) {
		this.selectLote = selectLote;
	}
	
	
	
	public SelectOneMenu getTxtHacienda() {
		return txtHacienda;
	}

	public void setTxtHacienda(SelectOneMenu txtHacienda) {
		this.txtHacienda = txtHacienda;
	}

	public SelectOneMenu getTxtLote() {
		return txtLote;
	}

	public void setTxtLote(SelectOneMenu txtLote) {
		this.txtLote = txtLote;
	}
	
	

	public InputNumber getTxtDiasLabor() {
		return txtDiasLabor;
	}

	public void setTxtDiasLabor(InputNumber txtDiasLabor) {
		this.txtDiasLabor = txtDiasLabor;
	}

	/**********Reportes
	 * @throws Exception 
	 * @throws NumberFormatException ****/
	
	public void costosGastosPorHacienda() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caCostosGastosPorHacienda.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor, 0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
													
							


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
						//	Cell cell32 = row.createCell(31);
					//		Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
											costosTotalesDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
											costosTotalesDTO.getFechaRegistro().toString().substring(0, 4));
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caCostosGastosPorHacienda.xlsx");

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

	
	public void costosPorCultivo() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caCostosPorCultivo.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_resumen_lote(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1	=	row.createCell(0		);	columna1.setCellValue("IDLOTE");	columna1.setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDFINCA");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("CODLOTE");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("VALOR");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("CORTES");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("NOM_FINCA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("NOM_LOTE");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("NOM_VARIEDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("NOM_CORTE");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("AREA_LOTE");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("P.INICIAL");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("P.FINAL");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("EDAD (MES)");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("EDAD (DIAS)");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("AREA FINCA");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("TON. ULTC");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("TCH. ULTC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("VLR. TONELADA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("RANGO EDAD DIAS");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("F. SIEMBRA");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("F. ULT. COSECHA");	columna21.setCellStyle(style2);


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
						//	Cell cell32 = row.createCell(31);
					//		Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell2.setCellValue(costosTotalesDTO.getCodFinca());
							cell3.setCellValue(costosTotalesDTO.getCodLote());
							cell4.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell5.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell6.setCellValue(costosTotalesDTO.getNomFinca());
							cell7.setCellValue(costosTotalesDTO.getLoteA());
							cell8.setCellValue(costosTotalesDTO.getVariedad());
							cell9.setCellValue(costosTotalesDTO.getNomCorte());
							cell10.setCellValue(costosTotalesDTO.getArea().doubleValue());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell11.setCellValue(fechaI);
							
							cell12.setCellValue(fechaF);
							
							
							cell13.setCellValue(costosTotalesDTO.getEdadHoy());

							cell14.setCellValue(costosTotalesDTO.getEdadHoyDias().doubleValue());
							cell15.setCellValue(costosTotalesDTO.getAreaFinca().doubleValue());
							cell16.setCellValue(costosTotalesDTO.getCantidadCos().doubleValue());
							cell17.setCellValue(costosTotalesDTO.getTonHa().doubleValue());
							cell18.setCellValue(costosTotalesDTO.getValUnitario().doubleValue());
							cell19.setCellValue(costosTotalesDTO.getRangoEdadDias());
							cell20.setCellValue(costosTotalesDTO.getfSiembra());
							cell21.setCellValue(costosTotalesDTO.getfCorte());

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caCostosPorCultivo.xlsx");

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

	
	public void distribuccionCostosEdad() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
		}
		
		
		
		Double  tchEstimado =0.0; 
		 
		if(txtTCHEstimado.getValue()!=null) {
			tchEstimado = FacesUtils.checkDouble(txtTCHEstimado);
		}
		
		Double  valorUnitarioTonelada =0.0; 
		 
		if(txtValorUnitarioTonelada.getValue()!=null) {
			valorUnitarioTonelada = FacesUtils.checkDouble(txtValorUnitarioTonelada);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caDistribuccionCostosEdad.xlsx";


				data = businessDelegator2View.pr_costo_parcial_resumen_lote(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1	=	row.createCell(0		);	columna1.setCellValue("IDLOTE");	columna1.setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDFINCA");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("CODLOTE");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("VALOR");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("CORTES");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("NOM_FINCA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("NOM_LOTE");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("NOM_VARIEDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("NOM_CORTE");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("AREA_LOTE");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("P.INICIAL");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("P.FINAL");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("EDAD (MES)");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("EDAD (DIAS)");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("AREA FINCA");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("TON. ULTC");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("TCH. ULTC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("VLR. TONELADA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("RANGO EDAD DIAS");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("F. SIEMBRA");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("F. ULT. COSECHA");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("INGRESO PROYECTADO");	columna22.setCellStyle(style2);

						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
						//	Cell cell32 = row.createCell(31);
					//		Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell2.setCellValue(costosTotalesDTO.getCodFinca());
							cell3.setCellValue(costosTotalesDTO.getCodLote());
							cell4.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell5.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell6.setCellValue(costosTotalesDTO.getNomFinca());
							cell7.setCellValue(costosTotalesDTO.getLoteA());
							cell8.setCellValue(costosTotalesDTO.getVariedad());
							cell9.setCellValue(costosTotalesDTO.getNomCorte());
							cell10.setCellValue(costosTotalesDTO.getArea().doubleValue());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell11.setCellValue(fechaI);
							
							cell12.setCellValue(fechaF);
							
							
							cell13.setCellValue(costosTotalesDTO.getEdadHoy());

							cell14.setCellValue(costosTotalesDTO.getEdadHoyDias().doubleValue());
							cell15.setCellValue(costosTotalesDTO.getAreaFinca().doubleValue());
							if(costosTotalesDTO.getCantidadCos().doubleValue()==0) {
								cell16.setCellValue(tchEstimado*costosTotalesDTO.getArea().doubleValue());
							}else {
								cell16.setCellValue(costosTotalesDTO.getCantidadCos().doubleValue());
							}
							
							
							if(costosTotalesDTO.getCantidadCos().doubleValue()==0) {
							
								cell17.setCellValue(tchEstimado);
							}else {
								cell17.setCellValue(costosTotalesDTO.getTonHa().doubleValue());
							}
							
							if(costosTotalesDTO.getCantidadCos().doubleValue()==0) {
								
								cell18.setCellValue(valorUnitarioTonelada);
							}else {
								cell18.setCellValue(costosTotalesDTO.getValUnitario().doubleValue());
							}
							
							
							
							
							cell19.setCellValue(costosTotalesDTO.getRangoEdadDias());
							cell20.setCellValue(costosTotalesDTO.getfSiembra());
							cell21.setCellValue(costosTotalesDTO.getfCorte());
							if(costosTotalesDTO.getCantidadCos().doubleValue()==0) {
								Double ingresoProyectado = valorUnitarioTonelada *tchEstimado*costosTotalesDTO.getArea().doubleValue();
								ingresoProyectado = (double) Math.round((ingresoProyectado) * 1000) / 1000;
								
								cell22.setCellValue(ingresoProyectado);
							}else {
								Double ingresoProyectado = costosTotalesDTO.getValUnitario().doubleValue() * costosTotalesDTO.getCantidadCos().doubleValue();
								ingresoProyectado = (double) Math.round((ingresoProyectado) * 1000) / 1000;
								
								cell22.setCellValue(ingresoProyectado);

							}
							
							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caDistribuccionCostosEdad.xlsx");

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

	
	public void resumenContableCostos() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caResumenContableCostos.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
						Cell	columna32	=	row.createCell(31		);	columna32.setCellValue("COSTO/HA");	columna32.setCellStyle(style2);
						Cell	columna33	=	row.createCell(32		);	columna33.setCellValue("COSTO DIRECTO");	columna33.setCellStyle(style2);
						Cell	columna34	=	row.createCell(33		);	columna34.setCellValue("COSTO INDIRECTO");	columna34.setCellStyle(style2);
						Cell	columna35	=	row.createCell(34		);	columna35.setCellValue("EDAD (MES)");	columna35.setCellStyle(style2);
						Cell	columna36	=	row.createCell(35		);	columna36.setCellValue("EDAD (DIAS)");	columna36.setCellStyle(style2);	
						Cell	columna37	=	row.createCell(36		);	columna37.setCellValue("F. SIEMBRA");	columna37.setCellStyle(style2);
						Cell	columna38	=	row.createCell(37		);	columna38.setCellValue("F. ULT. COSECHA");	columna38.setCellStyle(style2);	
					
						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
						    Cell cell32 = row.createCell(31);
							Cell cell33 = row.createCell(32);
							Cell cell34 = row.createCell(33);
							Cell cell35 = row.createCell(34);
							Cell cell36 = row.createCell(35);
							Cell cell37 = row.createCell(36);
							Cell cell38 = row.createCell(37);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
											costosTotalesDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
											costosTotalesDTO.getFechaRegistro().toString().substring(0, 4));
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							Double costoHa = costosTotalesDTO.getCostoTotal().doubleValue() / costosTotalesDTO.getArea().doubleValue();
							costoHa=(double) Math.round((costoHa) * 1000) / 1000;
							cell32.setCellValue(costoHa);
							
							cell33.setCellValue(costosTotalesDTO.getCostoDirecto().doubleValue());
							cell34.setCellValue(costosTotalesDTO.getCostoIndirecto().doubleValue());
							
							cell35.setCellValue(costosTotalesDTO.getEdadHoy().doubleValue());
							cell36.setCellValue(costosTotalesDTO.getEdadHoy().doubleValue() * 30.45);
							cell37.setCellValue(costosTotalesDTO.getfSiembra());
							cell38.setCellValue(costosTotalesDTO.getfCorte());


							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caResumenContableCostos.xlsx");

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

	
	public void auxiliarContableCostosLote() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		Long diasLabor = 0l;// FacesUtils.checkLong(txtDiasLabor);
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  ) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caAuxiliarContableCostosLote.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,diasLabor);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
						Cell	columna32	=	row.createCell(31		);	columna32.setCellValue("COSTO/HA");	columna32.setCellStyle(style2);
												
							


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
					//		Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro());
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							Double costoHa = costosTotalesDTO.getCostoTotal().doubleValue() / costosTotalesDTO.getArea().doubleValue();
							costoHa=(double) Math.round((costoHa) * 1000) / 1000;
							cell32.setCellValue(costoHa);
							

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caAuxiliarContableCostosLote.xlsx");

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


	
	public void costosAnualesHacienda() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		Long diasLabor = 0l;// FacesUtils.checkLong(txtDiasLabor);
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  ) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caCostosAnualesHacienda.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,diasLabor);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
						Cell	columna32	=	row.createCell(31		);	columna32.setCellValue("AREA FINCA");	columna32.setCellStyle(style2);
						Cell	columna33	=	row.createCell(32		);	columna33.setCellValue("COSTO/HA");	columna33.setCellStyle(style2);
													
							


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
							Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro().toString().substring(8, 10)+"/"+
											costosTotalesDTO.getFechaRegistro().toString().substring(5, 7)+"/"+
											costosTotalesDTO.getFechaRegistro().toString().substring(0, 4));
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							cell32.setCellValue(costosTotalesDTO.getAreaFinca().doubleValue());
							Double costoHa = costosTotalesDTO.getCostoTotal().doubleValue() / costosTotalesDTO.getAreaFinca().doubleValue();
							costoHa=(double) Math.round((costoHa) * 1000) / 1000;
							cell33.setCellValue(costoHa);
							

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caCostosAnualesHacienda.xlsx");

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

	public void cronologicoDeLabores() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caCronologicoDeLabores.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
						Cell	columna32	=	row.createCell(31		);	columna32.setCellValue("COSTO/HA");	columna32.setCellStyle(style2);
						Cell	columna33	=	row.createCell(32		);	columna33.setCellValue("DIAS LABOR");	columna33.setCellStyle(style2);						
							


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
						Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro());
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							Double costoHa = costosTotalesDTO.getCostoTotal().doubleValue() / costosTotalesDTO.getArea().doubleValue();
							costoHa=(double) Math.round((costoHa) * 1000) / 1000;
							cell32.setCellValue(costoHa);
							cell33.setCellValue(costosTotalesDTO.getDiasTranscurridosLabor().doubleValue());
							

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caCronologicoDeLabores.xlsx");

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

	

	public void insumosAplicadosLote() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caInsumosAplicadosLote.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
						Cell	columna32	=	row.createCell(31		);	columna32.setCellValue("COSTO/HA");	columna32.setCellStyle(style2);
						Cell	columna33	=	row.createCell(32		);	columna33.setCellValue("DIAS LABOR");	columna33.setCellStyle(style2);						
							


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
						Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro());
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							Double costoHa = costosTotalesDTO.getCostoTotal().doubleValue() / costosTotalesDTO.getArea().doubleValue();
							costoHa=(double) Math.round((costoHa) * 1000) / 1000;
							cell32.setCellValue(costoHa);
							cell33.setCellValue(costosTotalesDTO.getDiasTranscurridosLabor().doubleValue());
							

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caInsumosAplicadosLote.xlsx");

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

	

	public void insumosAplicadosHacienda() throws NumberFormatException, Exception {

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
		
		Long etapa =0l; 
		 
		if(txtEtapa.getValue()!=null) {
			etapa = FacesUtils.checkLong(txtEtapa);
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
		Long flagNumeroCosechas = 1L;
		
		String idHacienda =""; 
		String idLote = ""; 
		
		if(txtHacienda.getValue()!=null) {
			idHacienda = FacesUtils.checkString(txtHacienda);
			flagFinca =0L;
		}
		if(txtLote.getValue()!=null) {
			idLote = FacesUtils.checkString(txtLote);
			flagLote =0L;
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

		/*

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
		
		String unidadesMedidaSeleccionadas = "";
		if (selectedUdadMed != null && selectedUdadMed.size() > 0) {
			unidadesMedidaSeleccionadas = selectedUdadMed.get(0);
			flagUnidadMedida = 0L;
			for (int i = 1; i < selectedUdadMed.size(); i++) {
				unidadesMedidaSeleccionadas += "," + selectedUdadMed.get(i);
			}
		}
		
		String numeroCosechasSeleccionadas = "";
		if (selectedEtapaId != null && selectedEtapaId.size() > 0) {
			numeroCosechasSeleccionadas = selectedEtapaId.get(0);
			flagNumeroCosechas = 0L;
			for (int i = 1; i < selectedEtapaId.size(); i++) {
				numeroCosechasSeleccionadas += "," + selectedEtapaId.get(i);
			}
		}
*/
		
	
		

		if (compania != null  && fechaFinal !=null) {
			try {
				List<CostosTotalesDTO> data = null;

				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "caInsumosAplicadosHacienda.xlsx";

			
				data = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,
						"0", flagZona, idHacienda, flagFinca, "0", flagBloque,
						idLote, flagLote, laboresSeleccionadas, flagLabor,  0l,
						grupoLaboresSeleccionadas, flagGrupoLabor,0l);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(4);
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
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

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

						Cell	columna1 	=	row.createCell(0		);	columna1 .setCellValue("IDREGISTRO");	columna1 .setCellStyle(style2);
						Cell	columna2	=	row.createCell(1		);	columna2.setCellValue("IDLOTE");	columna2.setCellStyle(style2);
						Cell	columna3	=	row.createCell(2		);	columna3.setCellValue("IDFINCA");	columna3.setCellStyle(style2);
						Cell	columna4	=	row.createCell(3		);	columna4.setCellValue("CODLOTE");	columna4.setCellStyle(style2);
						Cell	columna5	=	row.createCell(4		);	columna5.setCellValue("IDLABOR");	columna5.setCellStyle(style2);
						Cell	columna6	=	row.createCell(5		);	columna6.setCellValue("FECHA");	columna6.setCellStyle(style2);
						Cell	columna7	=	row.createCell(6		);	columna7.setCellValue("IDINSUMO");	columna7.setCellStyle(style2);
						Cell	columna8	=	row.createCell(7		);	columna8.setCellValue("CANTIDAD");	columna8.setCellStyle(style2);
						Cell	columna9	=	row.createCell(8		);	columna9.setCellValue("VALOR");	columna9.setCellStyle(style2);
						Cell	columna10	=	row.createCell(9		);	columna10.setCellValue("UNDMEDIDA");	columna10.setCellStyle(style2);
						Cell	columna11	=	row.createCell(10		);	columna11.setCellValue("TIPOCOSTO");	columna11.setCellStyle(style2);
						Cell	columna12	=	row.createCell(11		);	columna12.setCellValue("NUMERODOC");	columna12.setCellStyle(style2);
						Cell	columna13	=	row.createCell(12		);	columna13.setCellValue("DETALLE");	columna13.setCellStyle(style2);
						Cell	columna14	=	row.createCell(13		);	columna14.setCellValue("APLICADO");	columna14.setCellStyle(style2);
						Cell	columna15	=	row.createCell(14		);	columna15.setCellValue("CSALIDAS");	columna15.setCellStyle(style2);
						Cell	columna16	=	row.createCell(15		);	columna16.setCellValue("CORTES");	columna16.setCellStyle(style2);
						Cell	columna17	=	row.createCell(16		);	columna17.setCellValue("CODEC");	columna17.setCellStyle(style2);
						Cell	columna18	=	row.createCell(17		);	columna18.setCellValue("NOM_FINCA");	columna18.setCellStyle(style2);
						Cell	columna19	=	row.createCell(18		);	columna19.setCellValue("NOM_LOTE");	columna19.setCellStyle(style2);
						Cell	columna20	=	row.createCell(19		);	columna20.setCellValue("NOM_LABOR");	columna20.setCellStyle(style2);
						Cell	columna21	=	row.createCell(20		);	columna21.setCellValue("COD_GRUPO_LABOR");	columna21.setCellStyle(style2);
						Cell	columna22	=	row.createCell(21		);	columna22.setCellValue("NOM_GRUPO_LABOR");	columna22.setCellStyle(style2);
						Cell	columna23	=	row.createCell(22		);	columna23.setCellValue("NOM_VARIEDAD");	columna23.setCellStyle(style2);
						Cell	columna24	=	row.createCell(23		);	columna24.setCellValue("NOM_CORTE");	columna24.setCellStyle(style2);
						Cell	columna25	=	row.createCell(24		);	columna25.setCellValue("AREA_LOTE");	columna25.setCellStyle(style2);
						Cell	columna26	=	row.createCell(25		);	columna26.setCellValue("NOM_PRODUCTO");	columna26.setCellStyle(style2);
						Cell	columna27	=	row.createCell(26		);	columna27.setCellValue("ANIO");	columna27.setCellStyle(style2);
						Cell	columna28	=	row.createCell(27		);	columna28.setCellValue("MES");	columna28.setCellStyle(style2);
						Cell	columna29	=	row.createCell(28		);	columna29.setCellValue("MES_CORTO");	columna29.setCellStyle(style2);
						Cell	columna30	=	row.createCell(29		);	columna30.setCellValue("P.INICIAL");	columna30.setCellStyle(style2);
						Cell	columna31	=	row.createCell(30		);	columna31.setCellValue("P.FINAL");	columna31.setCellStyle(style2);
						Cell	columna32	=	row.createCell(31		);	columna32.setCellValue("AREA FINCA");	columna32.setCellStyle(style2);
						Cell	columna33	=	row.createCell(32		);	columna33.setCellValue("COSTO/HA");	columna33.setCellStyle(style2);
							


						int pos_i = 5;

						for (CostosTotalesDTO costosTotalesDTO : data) {

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
							Cell cell25 = row.createCell(24);
							Cell cell26 = row.createCell(25);
							Cell cell27 = row.createCell(26);
							Cell cell28 = row.createCell(27);
							Cell cell29 = row.createCell(28);
							Cell cell30 = row.createCell(29);
							Cell cell31 = row.createCell(30);
							Cell cell32 = row.createCell(31);
						    Cell cell33 = row.createCell(32);

							cell1.setCellValue(costosTotalesDTO.getIdDetalle().longValue());
							cell2.setCellValue(costosTotalesDTO.getNivel4Id().longValue());
							cell3.setCellValue(costosTotalesDTO.getCodFinca());
							cell4.setCellValue(costosTotalesDTO.getCodLote());
							cell5.setCellValue(costosTotalesDTO.getCodLabor());
							cell6.setCellValue(
									costosTotalesDTO.getFechaRegistro());
									
							
							cell7.setCellValue(costosTotalesDTO.getCodProducto());
							cell8.setCellValue(costosTotalesDTO.getCantidadPago().doubleValue());
							cell9.setCellValue(costosTotalesDTO.getCostoTotal().doubleValue());
							cell10.setCellValue(costosTotalesDTO.getCodUdadMedPago());
							cell11.setCellValue(costosTotalesDTO.getOrigenDatos());
							cell12.setCellValue(costosTotalesDTO.getConsecutivo().longValue());
							cell13.setCellValue(costosTotalesDTO.getDetalle());
							cell14.setCellValue(costosTotalesDTO.getAplicado().longValue());
							cell15.setCellValue(costosTotalesDTO.getCsalidas().longValue());
							cell16.setCellValue(costosTotalesDTO.getNumeroCosechas1().longValue());
							cell17.setCellValue(costosTotalesDTO.getCodec());
							cell18.setCellValue(costosTotalesDTO.getNomFinca());
							cell19.setCellValue(costosTotalesDTO.getLoteA());
							cell20.setCellValue(costosTotalesDTO.getNombreLabor());
							cell21.setCellValue(costosTotalesDTO.getCodGrupoLabor());
							cell22.setCellValue(costosTotalesDTO.getNombreGrupoLabor());
							cell23.setCellValue(costosTotalesDTO.getVariedad());
							cell24.setCellValue(costosTotalesDTO.getNomCorte());
							cell25.setCellValue(costosTotalesDTO.getArea().doubleValue());
							cell26.setCellValue(costosTotalesDTO.getNombreProducto());
							cell27.setCellValue(costosTotalesDTO.getAnio().longValue());
							cell28.setCellValue(costosTotalesDTO.getMes().longValue());
							cell29.setCellValue(costosTotalesDTO.getMesTexto());
							
							String fechaI = "";
							String fechaF = "";
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							if(fechaInicial!=null && fechaFinal!=null) {
							 fechaI = dateFormat.format(fechaInicial);
							 fechaF = dateFormat.format(fechaFinal);
							
							}
							cell30.setCellValue(fechaI);
							
							cell31.setCellValue(fechaF);
							
							cell32.setCellValue(costosTotalesDTO.getAreaFinca().doubleValue());
							
							Double costoHa = costosTotalesDTO.getCostoTotal().doubleValue() / costosTotalesDTO.getAreaFinca().doubleValue();
							costoHa=(double) Math.round((costoHa) * 1000) / 1000;
							cell33.setCellValue(costoHa);
							
							

							pos_i++;

						}

						/*int numFilas = data.size() + 1;

						for (int i = 0; i < numFilas; i++) {
							sheet.autoSizeColumn(i);
						}*/

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

						file = new DefaultStreamedContent(stream, "application/xlsx", "caInsumosAplicadosHacienda.xlsx");

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

	
	public InputNumber getTxtTCHEstimado() {
		return txtTCHEstimado;
	}

	public void setTxtTCHEstimado(InputNumber txtTCHEstimado) {
		this.txtTCHEstimado = txtTCHEstimado;
	}

	public InputNumber getTxtValorUnitarioTonelada() {
		return txtValorUnitarioTonelada;
	}

	public void setTxtValorUnitarioTonelada(InputNumber txtValorUnitarioTonelada) {
		this.txtValorUnitarioTonelada = txtValorUnitarioTonelada;
	}
	
	
	
	
	
}
