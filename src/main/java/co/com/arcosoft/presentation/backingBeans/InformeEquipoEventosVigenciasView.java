package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.dto.EquipoEventoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformeEquipoEventosVigenciasView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeEquipoEventosVigenciasView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private boolean showDialog;

	private List<EquipoEventoDTO> data;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> selectEquipo;
	private List<Equipo> equipos;

	public InformeEquipoEventosVigenciasView() {
		super();
	}

	public String action_consultar() {

		eventosEquipos();
		setShowDialog(true);
		return "";

	}

	public void eventosEquipos() {

		Long compania = FacesUtils.checkLong(txtCompania);

		String equipoSeleccionados = " ";
		if (selectEquipo != null && selectEquipo.size() > 0) {
			equipoSeleccionados = selectEquipo.get(0);
			for (int i = 1; i < selectEquipo.size(); i++) {
				equipoSeleccionados = selectEquipo.get(i);
			}
		}

		if (compania != null) {

			Long equipoId = new Long(equipoSeleccionados);

			data = null;
			try {
				data = businessDelegatorView.getDataEquipoEventoByEquipoIdCompaniaId(equipoId, compania);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public List<EquipoEventoDTO> getData() {

		if (data == null || data.size() == 0) {
			return null;
		} else {
			return data;
		}

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

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
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

	public List<String> getSelectEquipo() {
		return selectEquipo;
	}

	public void setSelectEquipo(List<String> selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public List<Equipo> getEquipos() {

		if (equipos == null || equipos.size() == 0) {

			equipos = new ArrayList<Equipo>();

			try {
				equipos = businessDelegatorView.getEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

}
