package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.CostosTotalesDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ProduccionAcumFincaDTO;
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
public class informeIdFichasDeCostoCultivoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(informeIdFichasDeCostoCultivoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
	private List<CostosTotalesDTO> dataDetalle;
	private List<ProduccionAcumFincaDTO> dataCosecha;
	
	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtCantidadAcumulado;
	private InputNumber txtCostoAreaAcumulado;
	private InputNumber txtRendimientoAcumulado;

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	
	private GrpLabor selectGrpLabor;
	private List<GrpLabor> grpLabor;
	
	private SelectOneMenu txtHacienda;
	SelectItem[] selectHacienda;
	
	private SelectOneMenu txtLote;
	SelectItem[] selectLote;
	
	private InputText txtTipoFicha;
	
	private InputText txtVariedad;
	private InputText txtAreaLote;
	private InputText txtFechaSiembra;
	private InputText txtFechaUltimoCorte;
	private InputText txtNumCortes;
	private InputText txtEdadCultivo;
	
	private InputNumber txtValorTotalLote;
	private InputNumber  txtCostoHaLote;
	private InputNumber  txtPorcentajeCosto;
	
	private CommandButton btnCosechas;	
	private boolean showDialog;

	public informeIdFichasDeCostoCultivoView() {
		super();
	}

	public void fichaTecnicaCultivo() {
		try {		
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			
			Long flagGrpLabor = 0L;
			String grpLaboresSeleccionadas = selectGrpLabor.getGrpLaborId().toString();

			Long flagHacienda = 1L;
			String haciendasSeleccionadas = "0";
			if (txtHacienda != null && txtHacienda.getValue() != null) {
				haciendasSeleccionadas = FacesUtils.checkString(txtHacienda);
				flagHacienda = 0L;
			}

			Long flagLote = 1L;
			String lotesSeleccionados = "0";
			if (txtLote != null && txtLote.getValue() != null) {
				lotesSeleccionados = FacesUtils.checkString(txtLote);
				flagLote = 0L;
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && grpLaboresSeleccionadas != "0") {

				dataDetalle = businessDelegator2View.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal,						
					"0", 1L, haciendasSeleccionadas, flagHacienda, "0", 1L, lotesSeleccionados, flagLote, "0", 1L, 0L, grpLaboresSeleccionadas, 
					flagGrpLabor,0L);
			}
			
			double totalCosto = 0;
			
			
			
			if (dataDetalle != null && dataDetalle.size() >= 0) {
				for (CostosTotalesDTO data1 : dataDetalle) {
					totalCosto += data1.getCostoTotal().doubleValue();
				
				}
			}
			
			txtValorTotalAcumulado.setValue(totalCosto);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void fichaEconomicaCultivo() {
		try {		
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			
			Long flagGrpLabor = 0L;
			String grpLaboresSeleccionadas = selectGrpLabor.getGrpLaborId().toString();

			Long flagHacienda = 1L;
			String haciendasSeleccionadas = "0";
			if (txtHacienda != null && txtHacienda.getValue() != null) {
				haciendasSeleccionadas = FacesUtils.checkString(txtHacienda);
				flagHacienda = 0L;
			}

			Long flagLote = 1L;
			String lotesSeleccionados = "0";
			if (txtLote != null && txtLote.getValue() != null) {
				lotesSeleccionados = FacesUtils.checkString(txtLote);
				flagLote = 0L;
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && grpLaboresSeleccionadas != "0") {

				dataDetalle = businessDelegator2View.pr_costo_parcial_resumen_labor(compania, fechaInicial, fechaFinal,						
					"0", 1L, haciendasSeleccionadas, flagHacienda, "0", 1L, lotesSeleccionados, flagLote, "0", 1L, 0L, grpLaboresSeleccionadas, 
					flagGrpLabor);
			}
			
			
				
				double totalCosto = 0;
				double cantidadPago = 0;
				double costoSobreArea = 0;
				double porcCosto = 0 ;
				double costoHaLote =0;
				double areaLote =0;
				double costoTotalLote=0;
				
				if (dataDetalle != null && dataDetalle.size() >= 0) {
					for (CostosTotalesDTO data1 : dataDetalle) {
						totalCosto += data1.getCostoTotal().doubleValue();
					//	cantidadPago += data1.getCantidadPago().doubleValue();
						costoSobreArea += data1.getCostoSobreArea().doubleValue();
						porcCosto += data1.getPorcentajeCosto().doubleValue();
						costoTotalLote = data1.getSumatoriaCostoTotalLote().doubleValue();
						areaLote= data1.getArea().doubleValue();
					}
				}
				if(areaLote>0) {
					costoHaLote =costoTotalLote/areaLote;
					costoHaLote = (double) Math.round((costoHaLote) * 100) / 100;

				}
				txtValorTotalLote.setValue(costoTotalLote);
				txtCostoHaLote.setValue(costoHaLote);
				txtValorTotalAcumulado.setValue(totalCosto);
				//txtCantidadAcumulado.setValue(cantidadPago);
				txtCostoAreaAcumulado.setValue(costoSobreArea);
				txtPorcentajeCosto.setValue(porcCosto);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public void consultaCosecha() throws Exception {
		
		if (txtHacienda.getValue() != null && txtLote.getValue() != null) {

			Long flagHacienda = 1L;
			String haciendasSeleccionadas = "0";
			if (txtHacienda != null && txtHacienda.getValue() != null) {
				haciendasSeleccionadas = FacesUtils.checkString(txtHacienda);
				flagHacienda = 0L;
			}

			Long flagLote = 1L;
			String lotesSeleccionados = "0";
			if (txtLote != null && txtLote.getValue() != null) {
				lotesSeleccionados = FacesUtils.checkString(txtLote);
				flagLote = 0L;
			}
			
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicial = foriginal.parse("1970-01-01");
			Date fechaFinal = foriginal.parse("2100-01-01");
			
			dataCosecha = businessDelegator2View.pr_produccion_lote_cerrado(compania, fechaInicial, fechaFinal, "0", 1L, haciendasSeleccionadas, 
				flagHacienda, "0", 1L, lotesSeleccionados, flagLote,  0L);
			
			setShowDialog(true);
			
		} else {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Para consultar las cosechas debe de llenar los campos:"
					+ "Hacienda y Lote"));
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
	
	public void consultaN4() throws Exception {
		
		Date fechaInicial = (FacesUtils.checkDate(txtFechaIni));
		Date fechaFinal = (FacesUtils.checkDate(txtFechaFin));
		
		if ( txtHacienda.getValue() != null
				&& txtLote.getValue() != null) {
			 
			Long nivel4Id = FacesUtils.checkLong(txtLote);
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
			Variedad variedad = null;
			Etapa etapa = null;
			
			if (nivel4 != null) {
				
				variedad = businessDelegatorView.getVariedad(nivel4.getVariedad());
				etapa = businessDelegatorView.getEtapa(nivel4.getEtapa().getEtapaId());
				
				if(variedad != null) {
					txtVariedad.setValue(variedad.getNombre());
				}				
				txtAreaLote.setValue(nivel4.getAreaNeta());
				txtFechaSiembra.setValue(nivel4.getFechaSiembra());
				txtFechaUltimoCorte.setValue(nivel4.getFechaUltimoCorte());
				if (etapa != null) {
					txtNumCortes.setValue(etapa.getNumeroCosechas());
				}
				Date date = new Date();
				Double edadLoteHoy =  businessDelegatorView.calcularEdadLote(date, nivel4Id);
				txtEdadCultivo.setValue(edadLoteHoy);
				
				dataDetalle = null;	
				
			}
		}
	}
	
	public void resetPantalla() throws Exception {				
		dataDetalle = null;
	}

	public SelectOneMenu getTxtHacienda() {
		return txtHacienda;
	}

	public void setTxtHacienda(SelectOneMenu txtHacienda) {
		this.txtHacienda = txtHacienda;
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

	public SelectOneMenu getTxtLote() {
		return txtLote;
	}

	public void setTxtLote(SelectOneMenu txtLote) {
		this.txtLote = txtLote;
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

	public List<CostosTotalesDTO> getDataDetalle() {
		return dataDetalle;
	}

	public void setDataDetalle(List<CostosTotalesDTO> dataDetalle) {
		this.dataDetalle = dataDetalle;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputText getTxtVariedad() {
		return txtVariedad;
	}

	public void setTxtVariedad(InputText txtVariedad) {
		this.txtVariedad = txtVariedad;
	}

	public InputText getTxtAreaLote() {
		return txtAreaLote;
	}

	public void setTxtAreaLote(InputText txtAreaLote) {
		this.txtAreaLote = txtAreaLote;
	}

	public InputText getTxtFechaSiembra() {
		return txtFechaSiembra;
	}

	public void setTxtFechaSiembra(InputText txtFechaSiembra) {
		this.txtFechaSiembra = txtFechaSiembra;
	}

	public InputText getTxtFechaUltimoCorte() {
		return txtFechaUltimoCorte;
	}

	public void setTxtFechaUltimoCorte(InputText txtFechaUltimoCorte) {
		this.txtFechaUltimoCorte = txtFechaUltimoCorte;
	}

	public InputText getTxtNumCortes() {
		return txtNumCortes;
	}

	public void setTxtNumCortes(InputText txtNumCortes) {
		this.txtNumCortes = txtNumCortes;
	}

	public InputText getTxtEdadCultivo() {
		return txtEdadCultivo;
	}

	public void setTxtEdadCultivo(InputText txtEdadCultivo) {
		this.txtEdadCultivo = txtEdadCultivo;
	}

	public List<ProduccionAcumFincaDTO> getDataCosecha() {
		return dataCosecha;
	}

	public void setDataCosecha(List<ProduccionAcumFincaDTO> dataCosecha) {
		this.dataCosecha = dataCosecha;
	}

	public CommandButton getBtnCosechas() {
		return btnCosechas;
	}

	public void setBtnCosechas(CommandButton btnCosechas) {
		this.btnCosechas = btnCosechas;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public List<GrpLabor> getGrpLabor() {
		
		if (grpLabor == null || grpLabor.size() <= 0) {
			
			try {				
				grpLabor = businessDelegatorView.getGrpLabor();
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return grpLabor;
	}

	public void setGrpLabor(List<GrpLabor> grpLabor) {
		this.grpLabor = grpLabor;
	}

	public GrpLabor getSelectGrpLabor() {
		return selectGrpLabor;
	}

	public void setSelectGrpLabor(GrpLabor selectGrpLabor) {
		this.selectGrpLabor = selectGrpLabor;
	}

	public InputText getTxtTipoFicha() {
		return txtTipoFicha;
	}

	public void setTxtTipoFicha(InputText txtTipoFicha) {
		this.txtTipoFicha = txtTipoFicha;
	}

	public InputNumber getTxtCostoAreaAcumulado() {
		return txtCostoAreaAcumulado;
	}

	public void setTxtCostoAreaAcumulado(InputNumber txtCostoAreaAcumulado) {
		this.txtCostoAreaAcumulado = txtCostoAreaAcumulado;
	}

	public InputNumber getTxtRendimientoAcumulado() {
		return txtRendimientoAcumulado;
	}

	public void setTxtRendimientoAcumulado(InputNumber txtRendimientoAcumulado) {
		this.txtRendimientoAcumulado = txtRendimientoAcumulado;
	}

	public InputNumber getTxtValorTotalLote() {
		return txtValorTotalLote;
	}

	public void setTxtValorTotalLote(InputNumber txtValorTotalLote) {
		this.txtValorTotalLote = txtValorTotalLote;
	}

	public InputNumber getTxtCostoHaLote() {
		return txtCostoHaLote;
	}

	public void setTxtCostoHaLote(InputNumber txtCostoHaLote) {
		this.txtCostoHaLote = txtCostoHaLote;
	}

	public InputNumber getTxtPorcentajeCosto() {
		return txtPorcentajeCosto;
	}

	public void setTxtPorcentajeCosto(InputNumber txtPorcentajeCosto) {
		this.txtPorcentajeCosto = txtPorcentajeCosto;
	}
	
	
}