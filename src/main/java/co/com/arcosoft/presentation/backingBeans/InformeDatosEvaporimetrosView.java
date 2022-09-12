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

import co.com.arcosoft.modelo.EstEvaporimetro;
import co.com.arcosoft.modelo.informes.dto.DatosEvaporimetrosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeDatosEvaporimetrosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeDatosEvaporimetrosView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private LineChartModel lineModel1;
	private boolean showDialog;

	// private List<DatosEvaporimetrosDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<DatosEvaporimetrosDTO> data;

	private SelectOneMenu txtEstEvaporimetroId_EstEvaporimetro;
	SelectItem[] selectEvaporimetro;
	private List<EstEvaporimetro> estEvaporimetros;

	public InformeDatosEvaporimetrosView() {
		super();
	}

	public String action_informe1() {
		return "";
	}

	public LineChartModel getLineModel1() {

		createLineModel1();

		return lineModel1;
	}

	private void createLineModel1() {
		// Long compania = 1L;
		Long estEvaporimetros = FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		// fechaFinal = sdf.parse("2015-12-31");
		fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		lineModel1 = new LineChartModel();
		lineModel1.setTitle("Evaporación día a día");
		lineModel1.setLegendPosition("ne");
		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		lineModel1.setShowPointLabels(true);
		lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Días"));
		yAxis.setLabel("Evaporación");
		yAxis = lineModel1.getAxis(AxisType.X);
		yAxis.setTickAngle(-50);
		yAxis.setMin(0);
		yAxis.setMax(20);
		LineChartSeries series = new LineChartSeries();
		series.setLabel("Día");

		if (estEvaporimetros != null) {
			List<DatosEvaporimetrosDTO> data;
			try {

				data = businessDelegatorView.consultarInformeDatosEvaporimetros(estEvaporimetros, fechaInicial,
						fechaFinal);

				if (data == null || data.isEmpty()) {
					// pieModel1.set("Sin datos", 0L);
					series.set("Sin datos", 0L);
					lineModel1.addSeries(series);
					return;
				}

				for (DatosEvaporimetrosDTO datosEvaporimetrosDTO : data) {
					// barModel1.set(distribucionAreaVariedadDTO.getVariedad(),
					// distribucionAreaVariedadDTO.getArea());
					series.set(datosEvaporimetrosDTO.getFechaCorta(), datosEvaporimetrosDTO.getEvaporacion());
					// series.setLabel(Integer.toString(DatosEvaporimetrosDTO.getAnio()));
				}

				lineModel1.addSeries(series);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
			series.set("Sin datos", 0L);
			lineModel1.addSeries(series);
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

	public List<DatosEvaporimetrosDTO> getData() {
		try {
			Long estEvaporimetros = FacesUtils.checkLong(txtEstEvaporimetroId_EstEvaporimetro);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			// fechaFinal = sdf.parse("2015-12-31");
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			if (estEvaporimetros != null) {

				data = businessDelegatorView.consultarInformeDatosEvaporimetros(estEvaporimetros, fechaInicial,
						fechaFinal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public SelectOneMenu getTxtEstEvaporimetroId_EstEvaporimetro() {
		return txtEstEvaporimetroId_EstEvaporimetro;
	}

	public void setTxtEstEvaporimetroId_EstEvaporimetro(SelectOneMenu txtEstEvaporimetroId_EstEvaporimetro) {
		this.txtEstEvaporimetroId_EstEvaporimetro = txtEstEvaporimetroId_EstEvaporimetro;
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

	public SelectItem[] getSelectEvaporimetro() {

		if (estEvaporimetros == null || estEvaporimetros.size() == 0) {

			estEvaporimetros = new ArrayList<EstEvaporimetro>();

			try {

				estEvaporimetros = businessDelegatorView.getEstEvaporimetro(); // Fin
																				// by
																				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstEvaporimetro> lista = businessDelegatorView.findByCriteriaInEstEvaporimetro(condicion, null,
						null);
				selectEvaporimetro = new SelectItem[lista.size()];

				int i = 0;
				for (EstEvaporimetro eva : lista) {
					selectEvaporimetro[i] = new SelectItem(eva.getEstEvaporimetroId(), eva.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEvaporimetro;
	}

	public void setEvaporimetro(SelectItem[] selectEvaporimetro) {
		this.selectEvaporimetro = selectEvaporimetro;
	}

}
