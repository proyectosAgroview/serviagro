package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
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

import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.DistribucionAreaVariedadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformesView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformesView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private PieChartModel pieModel1;
	private boolean showDialog;

	private List<DistribucionAreaVariedadDTO> data;

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	public InformesView() {
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

		Long cultivoId = FacesUtils.checkLong(txtCultivoId_Cultivo);
		// Long variedadId = FacesUtils.checkLong();

		String variedadesSeleccionadas = "";
		if (selectedVariedades != null && selectedVariedades.size() > 0) {
			variedadesSeleccionadas = selectedVariedades.get(0);
			for (int i = 1; i < selectedVariedades.size(); i++) {
				variedadesSeleccionadas += "," + selectedVariedades.get(i);
			}
		}

		ChartSeries series = new ChartSeries();
		series.setLabel("Variedad");
		pieModel1.setTitle("Distribucción Área por variedad");
		pieModel1.setLegendPosition("ne");
		pieModel1.setShowDataLabels(true);

		if (cultivoId != null) {
			try {
				List<DistribucionAreaVariedadDTO> data = businessDelegatorView
						.consultarInformeDistribucionAreaVariedad(cultivoId, variedadesSeleccionadas);

				if (data == null || data.isEmpty()) {
					pieModel1.set("Sin datos", 0L);
					series.set("Sin datos", 0L);
					// pieModel1.addSeries(series);
					return;
				}

				for (DistribucionAreaVariedadDTO distribucionAreaVariedadDTO : data) {
					pieModel1.set(distribucionAreaVariedadDTO.getVariedad(),
							distribucionAreaVariedadDTO.getPorcentajeArea());
					series.set(distribucionAreaVariedadDTO.getVariedad(),
							distribucionAreaVariedadDTO.getPorcentajeArea());
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

	public List<DistribucionAreaVariedadDTO> getData() {
		try {

			Long cultivoId = FacesUtils.checkLong(txtCultivoId_Cultivo);
			// Long variedadId = FacesUtils.checkLong();

			String variedadesSeleccionadas = "";
			if (selectedVariedades != null && selectedVariedades.size() > 0) {
				variedadesSeleccionadas = selectedVariedades.get(0);
				for (int i = 1; i < selectedVariedades.size(); i++) {
					variedadesSeleccionadas += "," + selectedVariedades.get(i);
				}
			}

			if (cultivoId != null) {

				data = businessDelegatorView.consultarInformeDistribucionAreaVariedad(cultivoId,
						variedadesSeleccionadas);

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

}
