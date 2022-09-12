package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputnumber.InputNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.DisponibilidadHidricaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ListarLaboresPorRiegoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarLaboresPorRiegoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private List<DisponibilidadHidricaDTO> dataDetalle;
	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtCantidadAcumulado;

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;

	private List<String> selectedHacienda;
	private List<Nivel2> haciendas;

	private List<String> selectedLote;
	private List<Nivel4> lotes;

	private List<String> selectedLabor;
	private List<Labor> labores;

	public ListarLaboresPorRiegoView() {
		super();
	}

	public void listarPlanillaNominaDetallada() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long flagLabor = 1L;
			String laboresSeleccionadas = "0";
			if (selectedLabor != null && selectedLabor.size() > 0) {
				laboresSeleccionadas = selectedLabor.get(0);
				flagLabor = 0L;
				for (int i = 1; i < selectedLabor.size(); i++) {
					laboresSeleccionadas += "," + selectedLabor.get(i);
				}
			}

			Long flagHacienda = 1L;
			String haciendasSeleccionadas = "0";
			if (selectedHacienda != null && selectedHacienda.size() > 0) {
				haciendasSeleccionadas = selectedHacienda.get(0);
				flagHacienda = 0L;
				for (int i = 1; i < selectedHacienda.size(); i++) {
					haciendasSeleccionadas += "," + selectedHacienda.get(i);
				}
			}

			Long flagLote = 1L;
			String lotesSeleccionados = "0";
			if (selectedLote != null && selectedLote.size() > 0) {
				lotesSeleccionados = selectedLote.get(0);
				flagLote = 0L;
				for (int i = 1; i < selectedLote.size(); i++) {
					lotesSeleccionados += "," + selectedLote.get(i);
				}
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && fechaInicial != null && fechaFinal != null) {

				dataDetalle = businessDelegatorView.consultarInformeDisponibilidadHidrica(compania, fechaInicial, fechaFinal,
					"0", 1L, haciendasSeleccionadas, flagHacienda, "0", 1L, lotesSeleccionados, flagLote, laboresSeleccionadas,
					flagLabor, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, 0L);
			}

			double totalUnidades = 0;
			if (dataDetalle != null && dataDetalle.size() >= 0) {
				for (DisponibilidadHidricaDTO data1 : dataDetalle) {
					totalUnidades += data1.getAreaRegada().doubleValue();
				}
			}

			txtCantidadAcumulado.setValue(totalUnidades);

		} catch (Exception e) {
			e.printStackTrace();
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

	public List<String> getSelectedHacienda() {
		return selectedHacienda;
	}

	public void setSelectedHacienda(List<String> selectedHacienda) {
		this.selectedHacienda = selectedHacienda;
	}

	public List<Nivel2> getHaciendas() {

		if (haciendas == null || haciendas.size() == 0) {

			try {
				haciendas = businessDelegatorView.getNivel2();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return haciendas;
	}

	public void setHaciendas(List<Nivel2> haciendas) {
		this.haciendas = haciendas;
	}

	public List<String> getSelectedLote() {
		return selectedLote;
	}

	public void setSelectedLote(List<String> selectedLote) {
		this.selectedLote = selectedLote;
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

	public List<DisponibilidadHidricaDTO> getDataDetalle() {
		return dataDetalle;
	}

	public void setDataDetalle(List<DisponibilidadHidricaDTO> dataDetalle) {
		this.dataDetalle = dataDetalle;
	}
}