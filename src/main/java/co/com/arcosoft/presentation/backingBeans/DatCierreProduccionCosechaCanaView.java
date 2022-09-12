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
import co.com.arcosoft.modelo.DatTransProdNivel4;
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
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
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
public class DatCierreProduccionCosechaCanaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatCierreProduccionCosechaCanaView.class);

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
	
	private InputNumber	txtCantidadCosechada		;
	private InputNumber	txtCantidadCosechadaHa		;
	private InputNumber	txtValorUnitario		;
	private InputNumber	txtIngresoBruto		;
	private InputNumber	txtIngresoBrutoHa		;
	private InputNumber	txtCostoProduccion		;
	private InputNumber	txtCostoProduccionHa		;
	private InputNumber	txtUtilidadOperacional		;
	private InputNumber	txtUtilidadOperacionalHa		;
	private InputNumber	txtAjusteLiquidacion		;
	private InputNumber	txtAjusteLiquidacionHa		;
	private InputNumber	txtBonificacion		;
	private InputNumber	txtBonificacionHa			;
	private InputNumber	txtOtrosIngresos		;
	private InputNumber	txtOtrosIngresosHa		;
	private InputNumber	txtTotalUtilidad		;
	private InputNumber	txtTotalUtilidadHa		;
	private InputNumber	txtRetenciones		;
	private InputNumber	txtRetencionesHa		;
	private InputNumber	txtDescuentos		;
	private InputNumber	txtDescuentosHa		;
	
	private InputNumber	txtUtilidadNeta		;
	private InputNumber	txtUtilidadNetaHa		;
	private InputNumber	txtRentabilidad		;
	private InputNumber	txtRendimientoAzucar		;
	private InputNumber	txtAreaLote		;

	public DatCierreProduccionCosechaCanaView() {
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
				data = businessDelegator2View.pr_costos_produccion_lote_cerrado(null,null,null,  null, null, null, null,
						null, null, null, null, null);
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
	
	public SelectOneMenu getTxtEtapa() {
		return txtEtapa;
	}

	public void setTxtEtapa(SelectOneMenu txtEtapa) {
		this.txtEtapa = txtEtapa;
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
	
	
	/**********Reportes
	 * @throws Exception 
	 * @throws NumberFormatException ****/
	
	public void consultaLiquidacionLote() throws NumberFormatException, Exception {

		// Long compania = 1L;
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = new Date();
		// fechaInicial = sdf.parse("2013-01-01");
		//fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = sdf.parse("2015-12-31");
		//fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
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
		Long etapa =0l; 
		 
	//	if(txtEtapa.getValue()!=null) {
		//	etapa = FacesUtils.checkLong(txtEtapa);
	//	}

		if (compania != null ) {
			try {
				List<CostosTotalesDTO> data = null;

				data = businessDelegator2View.pr_costos_produccion_lote_cerrado(compania, fechaInicial, fechaFinal,
						"0", 1l, idHacienda, flagFinca,"0", 1L,
						idLote, flagLote, etapa);
						
						Double	areaLote 	= 0.0 ;
						Double	cantidadcosechada	= 0.0 ;	
						Double	cantidadcosechadaha		= 0.0 ;
						Double	valorunitario		= 0.0 ;
						Double	ingresobruto		= 0.0 ;
						Double	ingresobrutoha		= 0.0 ;
						Double	costoproduccion		= 0.0 ;
						Double	costoproduccionha		= 0.0 ;
						Double	utilidadoperacional		= 0.0 ;
						Double	utilidadoperacionalha		= 0.0 ;
						Double	ajusteliquidacion		= 0.0 ;
						Double	ajusteliquidacionha		= 0.0 ;
						Double	bonificacion		= 0.0 ;
						Double	bonificacionha		= 0.0 ;
						Double	otrosingresos		= 0.0 ;
						Double	otrosingresosha		= 0.0 ;
						Double	totalutilidad		= 0.0 ;
						Double	totalutilidadha		= 0.0 ;
						Double	retenciones		= 0.0 ;
						Double	retencionesha		= 0.0 ;
						Double	descuentos		= 0.0 ;
						Double	descuentosha		= 0.0 ;
						Double	utilidadneta		= 0.0 ;
						Double	utilidadnetaha		= 0.0 ;
						Double	rentabilidad		= 0.0 ;
						Double	rendimientoazucar	= 0.0 ;	

				
					if(data!=null && data.size()>=0) {
							 for( CostosTotalesDTO data1 : data) {
								 areaLote =+data1.getArea().doubleValue();
								 cantidadcosechada	+= data1.getCantidadCos().doubleValue()	;
								 cantidadcosechadaha	+= data1.getTonHa().doubleValue()	;
								 valorunitario	+= data1.getValUnitario().doubleValue()	;
								 ingresobruto	+= data1.getIngresos().doubleValue()	;
								 ingresobrutoha	+= 	data1.getIngresosHa().doubleValue();
								 
								 costoproduccion	+= data1.getCostoDirecto().doubleValue() + data1.getCostoIndirecto().doubleValue()	;
								 costoproduccionha	+= 	costoproduccion /data1.getArea().doubleValue();
								 costoproduccionha += (double) Math.round((costoproduccionha) * 100) / 100;
								 
								 utilidadoperacional	+=  data1.getUtilidad().doubleValue()	;
								 utilidadoperacionalha	+= 	data1.getUtilidadHa().doubleValue();
								
								 ajusteliquidacion	+= 	data1.getAjustesLiq().doubleValue();
								 ajusteliquidacionha	+= ajusteliquidacion / data1.getArea().doubleValue();	
								 ajusteliquidacionha	+=  (double) Math.round((ajusteliquidacionha) * 100) / 100;
								 
								 bonificacion	+= 	data1.getAdicionales().doubleValue();
								 bonificacionha	+= 	bonificacion / data1.getArea().doubleValue();	
								 bonificacionha	+= (double) Math.round((bonificacionha) * 100) / 100;
								 
								 otrosingresos	+= 	data1.getiVarios().doubleValue();
								 otrosingresosha	+= otrosingresos / data1.getArea().doubleValue();	
								 otrosingresosha += (double) Math.round((otrosingresosha) * 100) / 100;
								 
								 totalutilidad	+= 	utilidadoperacional + ajusteliquidacion + bonificacion + otrosingresos;
								 totalutilidadha	+= 	totalutilidad / data1.getArea().doubleValue();
								 totalutilidadha	+= 	(double) Math.round((totalutilidadha) * 100) / 100;
									
								 retenciones	+=  data1.getRetenciones().doubleValue()	;
								 retencionesha	+= 	retenciones/ data1.getArea().doubleValue();
								 retencionesha	+= 	(double) Math.round((retencionesha) * 100) / 100;
								 
								 descuentos	+= 	data1.getDescuentos().doubleValue();
								 descuentosha	+= 	descuentos/ data1.getArea().doubleValue();
								 descuentosha	+= 	(double) Math.round((descuentosha) * 100) / 100;
								 
								 utilidadneta	+=  totalutilidad - retenciones- 	descuentos;
								 utilidadnetaha	+= utilidadneta/ data1.getArea().doubleValue();
								 utilidadnetaha += (double) Math.round((utilidadnetaha) * 100) / 100;
								 
								 rentabilidad	+= 	(utilidadneta/costoproduccion)*100;
								
								 rendimientoazucar	+= 	data1.getRendAzucar().doubleValue();

						        }
							 rentabilidad	= 	(double) Math.round((rentabilidad) * 100) / 100;
					txtAreaLote.setValue(areaLote);
					txtCantidadCosechada.setValue(cantidadcosechada);
					txtCantidadCosechadaHa.setValue(cantidadcosechadaha);
					txtValorUnitario.setValue(valorunitario);
					txtIngresoBruto.setValue(ingresobruto);
					txtIngresoBrutoHa.setValue(ingresobrutoha);
					txtCostoProduccion.setValue(costoproduccion);
					txtCostoProduccionHa.setValue(costoproduccionha);
					txtUtilidadOperacional.setValue(utilidadoperacional);
					txtUtilidadOperacionalHa.setValue(utilidadoperacionalha);
					txtAjusteLiquidacion.setValue(ajusteliquidacion);
					txtAjusteLiquidacionHa.setValue(ajusteliquidacionha);
					txtBonificacion.setValue(bonificacion);
					txtBonificacionHa.setValue(bonificacionha);
					txtOtrosIngresos.setValue(otrosingresos);
					txtOtrosIngresosHa.setValue(otrosingresosha);
					txtTotalUtilidad.setValue(totalutilidad);
					txtTotalUtilidadHa.setValue(totalutilidadha);
					txtRetenciones.setValue(retenciones);
					txtRetencionesHa.setValue(retencionesha);
					txtDescuentos.setValue(descuentos);
					txtDescuentosHa.setValue(descuentosha);
					txtUtilidadNeta.setValue(utilidadneta);
					txtUtilidadNetaHa.setValue(utilidadnetaha);
					txtRentabilidad.setValue(rentabilidad);
					txtRendimientoAzucar.setValue(rendimientoazucar);
					
					}else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!, No existe informacion asociada a los criterios de busqueda seleccionados " ,
								""));
						}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	public InputNumber getTxtCantidadCosechada() {
		return txtCantidadCosechada;
	}

	public void setTxtCantidadCosechada(InputNumber txtCantidadCosechada) {
		this.txtCantidadCosechada = txtCantidadCosechada;
	}

	public InputNumber getTxtCantidadCosechadaHa() {
		return txtCantidadCosechadaHa;
	}

	public void setTxtCantidadCosechadaHa(InputNumber txtCantidadCosechadaHa) {
		this.txtCantidadCosechadaHa = txtCantidadCosechadaHa;
	}

	public InputNumber getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputNumber txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputNumber getTxtIngresoBruto() {
		return txtIngresoBruto;
	}

	public void setTxtIngresoBruto(InputNumber txtIngresoBruto) {
		this.txtIngresoBruto = txtIngresoBruto;
	}

	public InputNumber getTxtIngresoBrutoHa() {
		return txtIngresoBrutoHa;
	}

	public void setTxtIngresoBrutoHa(InputNumber txtIngresoBrutoHa) {
		this.txtIngresoBrutoHa = txtIngresoBrutoHa;
	}

	public InputNumber getTxtCostoProduccion() {
		return txtCostoProduccion;
	}

	public void setTxtCostoProduccion(InputNumber txtCostoProduccion) {
		this.txtCostoProduccion = txtCostoProduccion;
	}

	public InputNumber getTxtCostoProduccionHa() {
		return txtCostoProduccionHa;
	}

	public void setTxtCostoProduccionHa(InputNumber txtCostoProduccionHa) {
		this.txtCostoProduccionHa = txtCostoProduccionHa;
	}

	public InputNumber getTxtUtilidadOperacional() {
		return txtUtilidadOperacional;
	}

	public void setTxtUtilidadOperacional(InputNumber txtUtilidadOperacional) {
		this.txtUtilidadOperacional = txtUtilidadOperacional;
	}

	public InputNumber getTxtUtilidadOperacionalHa() {
		return txtUtilidadOperacionalHa;
	}

	public void setTxtUtilidadOperacionalHa(InputNumber txtUtilidadOperacionalHa) {
		this.txtUtilidadOperacionalHa = txtUtilidadOperacionalHa;
	}

	public InputNumber getTxtAjusteLiquidacion() {
		return txtAjusteLiquidacion;
	}

	public void setTxtAjusteLiquidacion(InputNumber txtAjusteLiquidacion) {
		this.txtAjusteLiquidacion = txtAjusteLiquidacion;
	}

	public InputNumber getTxtAjusteLiquidacionHa() {
		return txtAjusteLiquidacionHa;
	}

	public void setTxtAjusteLiquidacionHa(InputNumber txtAjusteLiquidacionHa) {
		this.txtAjusteLiquidacionHa = txtAjusteLiquidacionHa;
	}

	public InputNumber getTxtBonificacion() {
		return txtBonificacion;
	}

	public void setTxtBonificacion(InputNumber txtBonificacion) {
		this.txtBonificacion = txtBonificacion;
	}

	public InputNumber getTxtBonificacionHa() {
		return txtBonificacionHa;
	}

	public void setTxtBonificacionHa(InputNumber txtBonificacionHa) {
		this.txtBonificacionHa = txtBonificacionHa;
	}

	public InputNumber getTxtOtrosIngresos() {
		return txtOtrosIngresos;
	}

	public void setTxtOtrosIngresos(InputNumber txtOtrosIngresos) {
		this.txtOtrosIngresos = txtOtrosIngresos;
	}

	public InputNumber getTxtOtrosIngresosHa() {
		return txtOtrosIngresosHa;
	}

	public void setTxtOtrosIngresosHa(InputNumber txtOtrosIngresosHa) {
		this.txtOtrosIngresosHa = txtOtrosIngresosHa;
	}

	public InputNumber getTxtTotalUtilidad() {
		return txtTotalUtilidad;
	}

	public void setTxtTotalUtilidad(InputNumber txtTotalUtilidad) {
		this.txtTotalUtilidad = txtTotalUtilidad;
	}

	public InputNumber getTxtTotalUtilidadHa() {
		return txtTotalUtilidadHa;
	}

	public void setTxtTotalUtilidadHa(InputNumber txtTotalUtilidadHa) {
		this.txtTotalUtilidadHa = txtTotalUtilidadHa;
	}

	public InputNumber getTxtRetenciones() {
		return txtRetenciones;
	}

	public void setTxtRetenciones(InputNumber txtRetenciones) {
		this.txtRetenciones = txtRetenciones;
	}

	public InputNumber getTxtRetencionesHa() {
		return txtRetencionesHa;
	}

	public void setTxtRetencionesHa(InputNumber txtRetencionesHa) {
		this.txtRetencionesHa = txtRetencionesHa;
	}

	public InputNumber getTxtDescuentos() {
		return txtDescuentos;
	}

	public void setTxtDescuentos(InputNumber txtDescuentos) {
		this.txtDescuentos = txtDescuentos;
	}

	public InputNumber getTxtDescuentosHa() {
		return txtDescuentosHa;
	}

	public void setTxtDescuentosHa(InputNumber txtDescuentosHa) {
		this.txtDescuentosHa = txtDescuentosHa;
	}

	public InputNumber getTxtUtilidadNeta() {
		return txtUtilidadNeta;
	}

	public void setTxtUtilidadNeta(InputNumber txtUtilidadNeta) {
		this.txtUtilidadNeta = txtUtilidadNeta;
	}

	public InputNumber getTxtUtilidadNetaHa() {
		return txtUtilidadNetaHa;
	}

	public void setTxtUtilidadNetaHa(InputNumber txtUtilidadNetaHa) {
		this.txtUtilidadNetaHa = txtUtilidadNetaHa;
	}

	public InputNumber getTxtRentabilidad() {
		return txtRentabilidad;
	}

	public void setTxtRentabilidad(InputNumber txtRentabilidad) {
		this.txtRentabilidad = txtRentabilidad;
	}

	public InputNumber getTxtRendimientoAzucar() {
		return txtRendimientoAzucar;
	}

	public void setTxtRendimientoAzucar(InputNumber txtRendimientoAzucar) {
		this.txtRendimientoAzucar = txtRendimientoAzucar;
	}
	
	public InputNumber getTxtAreaLote() {
		return txtAreaLote;
	}

	public void setTxtAreaLote(InputNumber txtAreaLote) {
		this.txtAreaLote = txtAreaLote;
	}
	

	public void cerrarLote() throws Exception{
		Long idHacienda = null;
		Long 	idLote = null;
		Long 	etapaCosecha = null;
		Long idRegistroProduccion = null;
		Long idCiclo =0L;
		Nivel4 entityLote = null;
		Etapa entityEtapa =null;
		Long proximaEtapa =null;
		if(txtHacienda.getValue()!=null && txtLote.getValue()!=null) {
			idHacienda = FacesUtils.checkLong(txtHacienda);
			idLote = FacesUtils.checkLong(txtLote);
			DatTransProdNivel4 entityProduccion  = null;
			Object[] condicion = { "nivel4.nivel4Id", true, idLote, "=", "estadoRegistro", true, "abierto", "=" };
			List<DatTransProdNivel4> lista = (idLote != null)
					? businessDelegatorView.findByCriteriaInDatTransProdNivel4(condicion, null, null)
					: null;

					if (lista != null && lista.size() > 0) {
						entityProduccion = lista.get(0);
						etapaCosecha=entityProduccion.getEtapaNivel4().getEtapaId();
						idRegistroProduccion = entityProduccion.getDatTransProdNivel4Id();
						idCiclo = entityProduccion.getCiclo();
						entityProduccion.setEstadoRegistro("cerrado");
						//entityDet = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
						
						Object[] condicionLote = { "nivel4Id", true, idLote, "=" };
						List<Nivel4> listaLote = (idLote != null)
								? businessDelegatorView.findByCriteriaInNivel4(condicionLote, null, null): null;
								if (listaLote != null && listaLote.size() > 0) {
									entityLote = listaLote.get(0);
									
									Long idEtapa = entityLote.getEtapa().getEtapaId();
									
									Object[] condicionEtapa = { "etapaId", true, idEtapa, "=" };
									List<Etapa> listaEtapa = (idEtapa != null)
											? businessDelegatorView.findByCriteriaInEtapa(condicionEtapa, null, null): null;
											if (listaEtapa != null && listaEtapa.size() > 0) {
												entityEtapa = listaEtapa.get(0);
												proximaEtapa = entityEtapa.getProximaEtapa();
												
												if(entityEtapa.getProximaEtapa()!=null) {
													businessDelegatorView.updateDatTransProdNivel4(entityProduccion);
													businessDelegator2View.pr_asociar_reg_produccion_costos(  idLote ,  etapaCosecha ,  idRegistroProduccion , idCiclo);
												
													
													Etapa etapaActualizar = businessDelegatorView.getEtapa(proximaEtapa);		
													entityLote.setEtapa(etapaActualizar);	
													businessDelegatorView.updateNivel4(entityLote,  null, null, null);
													
													FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
															"Upps!,El cierre de cosecha fue cerrado de forma exitosa  " ,
															""));
													
												}else {
													FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
															"Upps!, Verifique que el catálogo Etapas de cosecha, tenga asociada una etapa próxima  " ,
															""));
												}
												
											}
									
								}
					
					}else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!, No hay registros de cosecha abiertos para la Hacienda/Lote seleccionada, Verifique por favor.  " ,
								""));
					}
					
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Los campos de Hacienda / Lote deben estar seleccionados  ",
					""));
		}
		
		
		
	}


	

}
