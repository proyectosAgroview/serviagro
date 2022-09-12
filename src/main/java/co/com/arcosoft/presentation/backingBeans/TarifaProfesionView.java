package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TarifaProfesion;
import co.com.arcosoft.modelo.dto.TarifaProfesionDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TarifaProfesionView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaProfesionView.class);
	private InputText txtCompania;
	private InputText txtContratistaId;
	private InputText txtTarifa;
	private InputText txtCeptoNominaId_ConceptoNomina;
	private InputText txtProfId_Profesion;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtTarifaProfId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TarifaProfesionDTO> data;
	private TarifaProfesionDTO selectedTarifaProfesion;
	private TarifaProfesion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TarifaProfesionView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TarifaProfesionDTO tarifaProfesionDTO = (TarifaProfesionDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tarifaProfesionDTO.getCompania());

			if (txtContratistaId == null) {
				txtContratistaId = new InputText();
			}

			txtContratistaId.setValue(tarifaProfesionDTO.getContratistaId());

			if (txtTarifa == null) {
				txtTarifa = new InputText();
			}

			txtTarifa.setValue(tarifaProfesionDTO.getTarifa());

			if (txtCeptoNominaId_ConceptoNomina == null) {
				txtCeptoNominaId_ConceptoNomina = new InputText();
			}

			txtCeptoNominaId_ConceptoNomina.setValue(tarifaProfesionDTO.getCeptoNominaId_ConceptoNomina());

			if (txtProfId_Profesion == null) {
				txtProfId_Profesion = new InputText();
			}

			txtProfId_Profesion.setValue(tarifaProfesionDTO.getProfId_Profesion());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(tarifaProfesionDTO.getUdadMedId_UdadMed());

			if (txtTarifaProfId == null) {
				txtTarifaProfId = new InputText();
			}

			txtTarifaProfId.setValue(tarifaProfesionDTO.getTarifaProfId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tarifaProfesionDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(tarifaProfesionDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(tarifaProfesionDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tarifaProfesionDTO.getFechaModificacion());

			Long tarifaProfId = FacesUtils.checkLong(txtTarifaProfId);
			entity = businessDelegatorView.getTarifaProfesion(tarifaProfId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTarifaProfesion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTarifaProfesion = null;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtContratistaId != null) {
			txtContratistaId.setValue(null);
			txtContratistaId.setDisabled(true);
		}

		if (txtTarifa != null) {
			txtTarifa.setValue(null);
			txtTarifa.setDisabled(true);
		}

		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(true);
		}

		if (txtProfId_Profesion != null) {
			txtProfId_Profesion.setValue(null);
			txtProfId_Profesion.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtTarifaProfId != null) {
			txtTarifaProfId.setValue(null);
			txtTarifaProfId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long tarifaProfId = FacesUtils.checkLong(txtTarifaProfId);
			entity = (tarifaProfId != null) ? businessDelegatorView.getTarifaProfesion(tarifaProfId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtContratistaId.setDisabled(false);
			txtTarifa.setDisabled(false);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
			txtProfId_Profesion.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtTarifaProfId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtContratistaId.setValue(entity.getContratistaId());
			txtContratistaId.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtTarifa.setValue(entity.getTarifa());
			txtTarifa.setDisabled(false);
			txtCeptoNominaId_ConceptoNomina.setValue(entity.getConceptoNomina());
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
			txtProfId_Profesion.setValue(entity.getProfesion().getProfId());
			txtProfId_Profesion.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtTarifaProfId.setValue(entity.getTarifaProfId());
			txtTarifaProfId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTarifaProfesion = (TarifaProfesionDTO) (evt.getComponent().getAttributes()
				.get("selectedTarifaProfesion"));
		txtCompania.setValue(selectedTarifaProfesion.getCompania());
		txtCompania.setDisabled(false);
		txtContratistaId.setValue(selectedTarifaProfesion.getContratistaId());
		txtContratistaId.setDisabled(false);
		txtFechaCreacion.setValue(selectedTarifaProfesion.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedTarifaProfesion.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedTarifaProfesion.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedTarifaProfesion.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtTarifa.setValue(selectedTarifaProfesion.getTarifa());
		txtTarifa.setDisabled(false);
		txtCeptoNominaId_ConceptoNomina.setValue(selectedTarifaProfesion.getCeptoNominaId_ConceptoNomina());
		txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		txtProfId_Profesion.setValue(selectedTarifaProfesion.getProfId_Profesion());
		txtProfId_Profesion.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedTarifaProfesion.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtTarifaProfId.setValue(selectedTarifaProfesion.getTarifaProfId());
		txtTarifaProfId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTarifaProfesion == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new TarifaProfesion();

			Long tarifaProfId = FacesUtils.checkLong(txtTarifaProfId);

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setContratistaId((FacesUtils.checkLong(txtContratistaId) != null)
					? businessDelegatorView.getPersEmpr((FacesUtils.checkLong(txtContratistaId))) : null);
			entity.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina))
					: null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setTarifaProfId(tarifaProfId);
			entity.setProfesion((FacesUtils.checkLong(txtProfId_Profesion) != null)
					? businessDelegatorView.getProfesion(FacesUtils.checkLong(txtProfId_Profesion)) : null);
			businessDelegatorView.saveTarifaProfesion(entity);
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
				Long tarifaProfId = new Long(selectedTarifaProfesion.getTarifaProfId());
				entity = businessDelegatorView.getTarifaProfesion(tarifaProfId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setContratistaId((FacesUtils.checkLong(txtContratistaId) != null)
					? businessDelegatorView.getPersEmpr((FacesUtils.checkLong(txtContratistaId))) : null);
			entity.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina))
					: null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setProfesion((FacesUtils.checkLong(txtProfId_Profesion) != null)
					? businessDelegatorView.getProfesion(FacesUtils.checkLong(txtProfId_Profesion)) : null);
			businessDelegatorView.updateTarifaProfesion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTarifaProfesion = (TarifaProfesionDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaProfesion"));

			Long tarifaProfId = new Long(selectedTarifaProfesion.getTarifaProfId());
			entity = businessDelegatorView.getTarifaProfesion(tarifaProfId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long tarifaProfId = FacesUtils.checkLong(txtTarifaProfId);
			entity = businessDelegatorView.getTarifaProfesion(tarifaProfId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTarifaProfesion(entity);
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
			selectedTarifaProfesion = (TarifaProfesionDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaProfesion"));

			Long tarifaProfId = new Long(selectedTarifaProfesion.getTarifaProfId());
			entity = businessDelegatorView.getTarifaProfesion(tarifaProfId);
			businessDelegatorView.deleteTarifaProfesion(entity);
			data.remove(selectedTarifaProfesion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long contratistaId, Date fechaCreacion, Date fechaFinal,
			Date fechaInicial, Date fechaModificacion, Double tarifa, Long tarifaProfId,
			Long ceptoNominaId_ConceptoNomina, Long profId_Profesion, Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(tarifa));
			businessDelegatorView.updateTarifaProfesion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TarifaProfesionView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtContratistaId() {
		return txtContratistaId;
	}

	public void setTxtContratistaId(InputText txtContratistaId) {
		this.txtContratistaId = txtContratistaId;
	}

	public InputText getTxtTarifa() {
		return txtTarifa;
	}

	public void setTxtTarifa(InputText txtTarifa) {
		this.txtTarifa = txtTarifa;
	}

	public InputText getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(InputText txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public InputText getTxtProfId_Profesion() {
		return txtProfId_Profesion;
	}

	public void setTxtProfId_Profesion(InputText txtProfId_Profesion) {
		this.txtProfId_Profesion = txtProfId_Profesion;
	}

	public InputText getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(InputText txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtTarifaProfId() {
		return txtTarifaProfId;
	}

	public void setTxtTarifaProfId(InputText txtTarifaProfId) {
		this.txtTarifaProfId = txtTarifaProfId;
	}

	public List<TarifaProfesionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTarifaProfesion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TarifaProfesionDTO> tarifaProfesionDTO) {
		this.data = tarifaProfesionDTO;
	}

	public TarifaProfesionDTO getSelectedTarifaProfesion() {
		return selectedTarifaProfesion;
	}

	public void setSelectedTarifaProfesion(TarifaProfesionDTO tarifaProfesion) {
		this.selectedTarifaProfesion = tarifaProfesion;
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
}
