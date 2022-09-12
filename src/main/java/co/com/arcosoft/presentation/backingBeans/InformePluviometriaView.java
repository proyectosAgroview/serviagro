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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.informes.dto.PluviometriaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformePluviometriaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformePluviometriaView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private LineChartModel lineModel1;
	private boolean showDialog;

	// private List<PluviometriaDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<PluviometriaDTO> data;

	// Select Estaciones Pluviometricas
	private SelectOneMenu txtEstPluvioId_EstPluvio;
	SelectItem[] selectEstPluvio;
	private List<EstPluvio> estPluvio;

	public InformePluviometriaView() {
		super();
	}

	public String action_informe1() {
		return "";
	}

	public LineChartModel getlineModel1() {

		createlineModel1();

		return lineModel1;
	}

	private void createlineModel1() {
		Long compania = 1L;
		Long estClima = FacesUtils.checkLong(txtEstPluvioId_EstPluvio);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		lineModel1 = new LineChartModel();
		lineModel1.setTitle("Precipitación día a día");
		lineModel1.setLegendPosition("ne");
		Axis yAxis = lineModel1.getAxis(AxisType.Y);

		// yAxis.setMin(0);
		// yAxis.setMax(30);

		// barModel1.setTitle("Distribucion Area Variedad");
		lineModel1.setShowPointLabels(true);
		lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Días"));
		yAxis.setLabel("Precipitación");
		yAxis = lineModel1.getAxis(AxisType.X);
		yAxis.setTickAngle(-50);
		yAxis.setMin(0);
		yAxis.setMax(30);

		LineChartSeries series = new LineChartSeries();
		series.setLabel("Precipitación(Día)");
		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Precipitación(Mes)");

		if (estClima != null) {
			List<PluviometriaDTO> data;
			try {

				data = businessDelegatorView.consultarInformePluviometria(estClima, fechaInicial, fechaFinal);

				if (data == null || data.isEmpty()) {
					// pieModel1.set("Sin datos", 0L);
					series.set("Sin datos", 0L);
					lineModel1.addSeries(series);
					series2.set("Sin datos", 0L);
					lineModel1.addSeries(series2);
					return;
				}

				for (PluviometriaDTO pluviometriaDTO : data) {
					// barModel1.set(distribucionAreaVariedadDTO.getVariedad(),
					// distribucionAreaVariedadDTO.getArea());
					series.set(pluviometriaDTO.getFechaCorta(), pluviometriaDTO.getPrecipitacion());
					series2.set(pluviometriaDTO.getFechaCorta(), pluviometriaDTO.getPrecipitacion_acum());
					// series.setLabel(Integer.toString(PluviometriaDTO.getAnio()));
				}

				lineModel1.addSeries(series);
				lineModel1.addSeries(series2);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
			series.set("Sin datos", 0L);
			lineModel1.addSeries(series);
			series2.set("Sin datos", 0L);
			lineModel1.addSeries(series2);

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

	public List<PluviometriaDTO> getData() {
		try {
			Long compania = 1L;
			Long estClima = FacesUtils.checkLong(txtEstPluvioId_EstPluvio);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			// fechaFinal = sdf.parse("2015-12-31");
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			if (estClima != null) {

				data = businessDelegatorView.consultarInformePluviometria(estClima, fechaInicial, fechaFinal);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public SelectOneMenu getTxtEstPluvioId_EstPluvio() {
		return txtEstPluvioId_EstPluvio;
	}

	public void setTxtEstPluvioId_EstPluvio(SelectOneMenu txtEstPluvioId_EstPluvio) {
		this.txtEstPluvioId_EstPluvio = txtEstPluvioId_EstPluvio;
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

	public SelectItem[] getSelectEstPluvio() {

		if (estPluvio == null || estPluvio.size() == 0) {

			estPluvio = new ArrayList<EstPluvio>();

			try {

				estPluvio = businessDelegatorView.getEstPluvio(); // Fin by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstPluvio> lista = businessDelegatorView.findByCriteriaInEstPluvio(condicion, null, null);
				selectEstPluvio = new SelectItem[lista.size()];

				int i = 0;
				for (EstPluvio pluvio : lista) {
					selectEstPluvio[i] = new SelectItem(pluvio.getEstPluvioId(), pluvio.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEstPluvio;
	}

	public void setSelectEstPluvio(SelectItem[] selectEstPluvio) {
		this.selectEstPluvio = selectEstPluvio;
	}

}
