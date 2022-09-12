package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.LimiteCeptoNomina;
import co.com.arcosoft.modelo.LimiteCeptoNominaId;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.LimiteCeptoNominaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class LimiteCeptoNominaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LimiteCeptoNominaView.class);
	// private InputText txtCeptoNominaId_ConceptoNomina;
	// private InputText txtUdadMedId_UdadMed;
	// private InputText txtCeptoNominaId;
	// private InputText txtUdadMedId;
	private InputText txtCompania;
	private InputText txtCantidadPermitida;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<LimiteCeptoNominaDTO> data;
	private LimiteCeptoNominaDTO selectedLimiteCeptoNomina;
	private LimiteCeptoNomina entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtCeptoNominaId;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private SelectOneMenu txtUdadMedId;
	SelectItem[] selectUdadMedId;
	private List<UdadMed> udadMedId;

	public LimiteCeptoNominaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			LimiteCeptoNominaDTO limiteCeptoNominaDTO = (LimiteCeptoNominaDTO) e.getObject();

			if (txtCeptoNominaId == null) {
				txtCeptoNominaId = new SelectOneMenu();
			}

			txtCeptoNominaId.setValue(limiteCeptoNominaDTO.getCeptoNominaId());

			if (txtUdadMedId == null) {
				txtUdadMedId = new SelectOneMenu();
			}

			txtUdadMedId.setValue(limiteCeptoNominaDTO.getUdadMedId());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(limiteCeptoNominaDTO.getCompania());

			if (txtCantidadPermitida == null) {
				txtCantidadPermitida = new InputText();
			}

			txtCantidadPermitida.setValue(limiteCeptoNominaDTO.getCantidadPermitida());

			LimiteCeptoNominaId id = new LimiteCeptoNominaId();
			id.setCeptoNominaId((((txtCeptoNominaId.getValue()) == null) || (txtCeptoNominaId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtCeptoNominaId));
			id.setUdadMedId((((txtUdadMedId.getValue()) == null) || (txtUdadMedId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtUdadMedId));
			id.setCompania((((txtCompania.getValue()) == null) || (txtCompania.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCompania));
			id.setCantidadPermitida(
					(((txtCantidadPermitida.getValue()) == null) || (txtCantidadPermitida.getValue()).equals("")) ? null
							: FacesUtils.checkDouble(txtCantidadPermitida));
			entity = businessDelegatorView.getLimiteCeptoNomina(id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedLimiteCeptoNomina = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedLimiteCeptoNomina = null;

		if (txtCeptoNominaId != null) {
			txtCeptoNominaId.setValue(null);
			txtCeptoNominaId.setDisabled(false);
		}

		if (txtUdadMedId != null) {
			txtUdadMedId.setValue(null);
			txtUdadMedId.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtCantidadPermitida != null) {
			txtCantidadPermitida.setValue(null);
			txtCantidadPermitida.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtId() {
		try {
			LimiteCeptoNominaId id = new LimiteCeptoNominaId();
			id.setCeptoNominaId((((txtCeptoNominaId.getValue()) == null) || (txtCeptoNominaId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtCeptoNominaId));
			id.setUdadMedId((((txtUdadMedId.getValue()) == null) || (txtUdadMedId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtUdadMedId));
			id.setCompania((((txtCompania.getValue()) == null) || (txtCompania.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCompania));
			id.setCantidadPermitida(
					(((txtCantidadPermitida.getValue()) == null) || (txtCantidadPermitida.getValue()).equals("")) ? null
							: FacesUtils.checkDouble(txtCantidadPermitida));
			entity = (id != null) ? businessDelegatorView.getLimiteCeptoNomina(id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {

			txtCeptoNominaId.setDisabled(false);
			txtUdadMedId.setDisabled(false);
			txtCompania.setDisabled(false);
			txtCantidadPermitida.setDisabled(false);
			btnSave.setDisabled(false);
		} else {

			txtCeptoNominaId.setValue(entity.getId().getCeptoNominaId());
			txtCeptoNominaId.setDisabled(true);
			txtUdadMedId.setValue(entity.getId().getUdadMedId());
			txtUdadMedId.setDisabled(true);
			txtCompania.setValue(entity.getId().getCompania());
			txtCompania.setDisabled(true);
			txtCantidadPermitida.setValue(entity.getId().getCantidadPermitida());
			txtCantidadPermitida.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedLimiteCeptoNomina = (LimiteCeptoNominaDTO) (evt.getComponent().getAttributes()
				.get("selectedLimiteCeptoNomina"));

		txtCeptoNominaId.setValue(selectedLimiteCeptoNomina.getCeptoNominaId());
		txtCeptoNominaId.setDisabled(true);
		txtUdadMedId.setValue(selectedLimiteCeptoNomina.getUdadMedId());
		txtUdadMedId.setDisabled(true);
		txtCompania.setValue(selectedLimiteCeptoNomina.getCompania());
		txtCompania.setDisabled(true);
		txtCantidadPermitida.setValue(selectedLimiteCeptoNomina.getCantidadPermitida());
		txtCantidadPermitida.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedLimiteCeptoNomina == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
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

	public String action_create() {
		try {
			entity = new LimiteCeptoNomina();
			Long compania = new Long(getCompaniaIdSession());
			LimiteCeptoNominaId id = new LimiteCeptoNominaId();
			id.setCeptoNominaId((((txtCeptoNominaId.getValue()) == null) || (txtCeptoNominaId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtCeptoNominaId));
			id.setUdadMedId((((txtUdadMedId.getValue()) == null) || (txtUdadMedId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtUdadMedId));
			id.setCompania(compania);
			id.setCantidadPermitida(
					(((txtCantidadPermitida.getValue()) == null) || (txtCantidadPermitida.getValue()).equals("")) ? null
							: FacesUtils.checkDouble(txtCantidadPermitida));

			entity.setId(id);
			entity.setConceptoNomina(businessDelegatorView.getConceptoNomina(entity.getId().getCeptoNominaId()));
			entity.setUdadMed(businessDelegatorView.getUdadMed(entity.getId().getUdadMedId()));
			businessDelegatorView.saveLimiteCeptoNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long compania = new Long(getCompaniaIdSession());
				LimiteCeptoNominaId id = new LimiteCeptoNominaId();
				id.setCeptoNominaId(selectedLimiteCeptoNomina.getCeptoNominaId());
				id.setUdadMedId(selectedLimiteCeptoNomina.getUdadMedId());
				id.setCompania(compania);
				id.setCantidadPermitida(selectedLimiteCeptoNomina.getCantidadPermitida());
				entity = businessDelegatorView.getLimiteCeptoNomina(id);
			}

			businessDelegatorView.updateLimiteCeptoNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedLimiteCeptoNomina = (LimiteCeptoNominaDTO) (evt.getComponent().getAttributes()
					.get("selectedLimiteCeptoNomina"));

			LimiteCeptoNominaId id = new LimiteCeptoNominaId();
			id.setCeptoNominaId(selectedLimiteCeptoNomina.getCeptoNominaId());
			id.setUdadMedId(selectedLimiteCeptoNomina.getUdadMedId());
			id.setCompania(selectedLimiteCeptoNomina.getCompania());
			id.setCantidadPermitida(selectedLimiteCeptoNomina.getCantidadPermitida());
			entity = businessDelegatorView.getLimiteCeptoNomina(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			LimiteCeptoNominaId id = new LimiteCeptoNominaId();
			id.setCeptoNominaId((((txtCeptoNominaId.getValue()) == null) || (txtCeptoNominaId.getValue()).equals(""))
					? null : FacesUtils.checkLong(txtCeptoNominaId));
			id.setUdadMedId((((txtUdadMedId.getValue()) == null) || (txtUdadMedId.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtUdadMedId));
			id.setCompania((((txtCompania.getValue()) == null) || (txtCompania.getValue()).equals("")) ? null
					: FacesUtils.checkLong(txtCompania));
			id.setCantidadPermitida(
					(((txtCantidadPermitida.getValue()) == null) || (txtCantidadPermitida.getValue()).equals("")) ? null
							: FacesUtils.checkDouble(txtCantidadPermitida));
			entity = businessDelegatorView.getLimiteCeptoNomina(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteLimiteCeptoNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedLimiteCeptoNomina = (LimiteCeptoNominaDTO) (evt.getComponent().getAttributes()
					.get("selectedLimiteCeptoNomina"));

			LimiteCeptoNominaId id = new LimiteCeptoNominaId();
			id.setCeptoNominaId(selectedLimiteCeptoNomina.getCeptoNominaId());
			id.setUdadMedId(selectedLimiteCeptoNomina.getUdadMedId());
			id.setCompania(selectedLimiteCeptoNomina.getCompania());
			id.setCantidadPermitida(selectedLimiteCeptoNomina.getCantidadPermitida());
			entity = businessDelegatorView.getLimiteCeptoNomina(id);
			businessDelegatorView.deleteLimiteCeptoNomina(entity);
			data.remove(selectedLimiteCeptoNomina);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ceptoNominaId, Long udadMedId, Long compania, Double cantidadPermitida,
			Long ceptoNominaId_ConceptoNomina, Long udadMedId_UdadMed) throws Exception {
		try {
			businessDelegatorView.updateLimiteCeptoNomina(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("LimiteCeptoNominaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtCeptoNominaId() {
		return txtCeptoNominaId;
	}

	public void setTxtCeptoNominaId(SelectOneMenu txtCeptoNominaId) {
		this.txtCeptoNominaId = txtCeptoNominaId;
	}

	public SelectOneMenu getTxtUdadMedId() {
		return txtUdadMedId;
	}

	public void setTxtUdadMedId(SelectOneMenu txtUdadMedId) {
		this.txtUdadMedId = txtUdadMedId;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtCantidadPermitida() {
		return txtCantidadPermitida;
	}

	public void setTxtCantidadPermitida(InputText txtCantidadPermitida) {
		this.txtCantidadPermitida = txtCantidadPermitida;
	}

	public List<LimiteCeptoNominaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataLimiteCeptoNomina();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<LimiteCeptoNominaDTO> limiteCeptoNominaDTO) {
		this.data = limiteCeptoNominaDTO;
	}

	public LimiteCeptoNominaDTO getSelectedLimiteCeptoNomina() {
		return selectedLimiteCeptoNomina;
	}

	public void setSelectedLimiteCeptoNomina(LimiteCeptoNominaDTO limiteCeptoNomina) {
		this.selectedLimiteCeptoNomina = limiteCeptoNomina;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public SelectItem[] getSelectUdadMedId() {

		if (udadMedId == null || udadMedId.size() == 0) {

			udadMedId = new ArrayList<UdadMed>();

			try {

				udadMedId = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedId = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedId : lista) {
					selectUdadMedId[i] = new SelectItem(udadMedId.getUdadMedId(), udadMedId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedId;
	}

	public void setSelectUdadMedId(SelectItem[] selectUdadMedId) {
		this.selectUdadMedId = selectUdadMedId;
	}

	public SelectItem[] getSelectCeptoNominaId() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

			conceptoNomina = new ArrayList<ConceptoNomina>();

			try {

				udadMedId = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setSelectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

}
