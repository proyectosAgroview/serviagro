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
import javax.faces.model.SelectItem;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
//import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.DistribucionAreaCultivoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeDistribucionAreaCultivoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeDistribucionAreaCultivoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private PieChartModel pieModel1;
	private boolean showDialog;

	private List<DistribucionAreaCultivoDTO> data;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private List<String> selectCultivo;
	private List<Cultivo> cultivos;

	private List<String> selectedNivel1;
	private List<Nivel1> zonas;

	private List<String> selectedNivel2;
	private List<Nivel2> fincas;

	private List<String> selectedNivel3;
	private List<Nivel3> bloques;

	private List<String> selectedNivel4;
	private List<Nivel4> lotes;

	public InformeDistribucionAreaCultivoView() {
		super();
	}

	public String action_informe1() {
		return "";
	}

	public PieChartModel getPieModel1() {

		createPieModel1();

		return pieModel1;
	}

	private void createPieModel1() {

		pieModel1 = new PieChartModel();
		pieModel1.setLegendPosition("w");
		pieModel1.setSliceMargin(4);

		// pieModel1.setTitle("Distribucion Area Variedad");
		// Long variedadId = FacesUtils.checkLong();

		Long compania = FacesUtils.checkLong(txtCompania);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		// fechaFinal = sdf.parse("2015-12-31");

		// String zona = "1";
		Long flagZona = 1L;
		Long flagFinca = 1L;
		Long flagBloque = 1L;
		Long flagLote = 1L;
		Long flagCultivo = 1L;
		Long flagVariedad = 1L;

		String cultivosSeleccionadas = "";
		if (selectCultivo != null && selectCultivo.size() > 0) {
			cultivosSeleccionadas = selectCultivo.get(0);
			flagCultivo = 0L;
			for (int i = 1; i < selectCultivo.size(); i++) {
				cultivosSeleccionadas += "," + selectCultivo.get(i);
			}
		}

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

		String variedadesSeleccionadas = "";
		if (selectedVariedades != null && selectedVariedades.size() > 0) {
			variedadesSeleccionadas = selectedVariedades.get(0);
			flagVariedad = 0L;
			for (int i = 1; i < selectedVariedades.size(); i++) {
				variedadesSeleccionadas += "," + selectedVariedades.get(i);
			}
		}

		ChartSeries series = new ChartSeries();
		series.setLabel("Cultivo");
		pieModel1.setTitle("Distribucción Área por cultivo");
		pieModel1.setLegendPosition("ne");
		pieModel1.setShowDataLabels(true);

		if (compania != null) {
			try {
				List<DistribucionAreaCultivoDTO> data = businessDelegatorView.consultarInformeDistribuccionAreaCultivo(
						compania, cultivosSeleccionadas, flagCultivo, zonasSeleccionadas, flagZona, fincasSeleccionadas,
						flagFinca, bloquesSeleccionadas, flagBloque, lotesSeleccionadas, flagLote,
						variedadesSeleccionadas, flagVariedad);

				if (data == null || data.isEmpty()) {
					pieModel1.set("Sin datos", 0L);
					series.set("Sin datos", 0L);
					// pieModel1.addSeries(series);
					return;
				}

				for (DistribucionAreaCultivoDTO DistribucionAreaCultivoDTO : data) {
					pieModel1.set(DistribucionAreaCultivoDTO.getCultivo(),
							DistribucionAreaCultivoDTO.getPorcentajeArea());
					series.set(DistribucionAreaCultivoDTO.getCultivo(), DistribucionAreaCultivoDTO.getPorcentajeArea());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// pieModel1.addSeries(series);

		} else {
			pieModel1.set("Sin datos", 0L);
			series.set("Sin datos", 0L);
			// pieModel1.addSeries(series);
		}
	}

	public List<DistribucionAreaCultivoDTO> getData() {
		try {

			Long compania = FacesUtils.checkLong(txtCompania);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			// fechaFinal = sdf.parse("2015-12-31");

			// String zona = "1";
			Long flagZona = 1L;
			Long flagFinca = 1L;
			Long flagBloque = 1L;
			Long flagLote = 1L;
			Long flagCultivo = 1L;
			Long flagVariedad = 1L;

			String cultivosSeleccionadas = "";
			if (selectCultivo != null && selectCultivo.size() > 0) {
				cultivosSeleccionadas = selectCultivo.get(0);
				flagCultivo = 0L;
				for (int i = 1; i < selectCultivo.size(); i++) {
					cultivosSeleccionadas += "," + selectCultivo.get(i);
				}
			}

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

			String variedadesSeleccionadas = "";
			if (selectedVariedades != null && selectedVariedades.size() > 0) {
				variedadesSeleccionadas = selectedVariedades.get(0);
				flagVariedad = 0L;
				for (int i = 1; i < selectedVariedades.size(); i++) {
					variedadesSeleccionadas += "," + selectedVariedades.get(i);
				}
			}

			if (compania != null) {

				data = businessDelegatorView.consultarInformeDistribuccionAreaCultivo(compania, cultivosSeleccionadas,
						flagCultivo, zonasSeleccionadas, flagZona, fincasSeleccionadas, flagFinca, bloquesSeleccionadas,
						flagBloque, lotesSeleccionadas, flagLote, variedadesSeleccionadas, flagVariedad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
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

	public SelectItem[] getSelectCompania() {

		if (compania == null || compania.size() == 0) {

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

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

}
