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
import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.dto.TarifaOtrosDevengosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TarifaOtrosDevengosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaOtrosDevengosView.class);
	private InputText txtCompania;
	private InputText txtConceptoNominaId;
	private InputText txtEstado;
	private InputText txtTrabId;
	private InputText txtValorDeduccion;
	private InputText txtOdevengosId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TarifaOtrosDevengosDTO> data;
	private TarifaOtrosDevengosDTO selectedTarifaOtrosDevengos;
	private TarifaOtrosDevengos entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TarifaOtrosDevengosView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TarifaOtrosDevengosDTO tarifaOtrosDevengosDTO = (TarifaOtrosDevengosDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tarifaOtrosDevengosDTO.getCompania());

			if (txtConceptoNominaId == null) {
				txtConceptoNominaId = new InputText();
			}

			txtConceptoNominaId.setValue(tarifaOtrosDevengosDTO.getConceptoNominaId());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(tarifaOtrosDevengosDTO.getEstado());

			if (txtTrabId == null) {
				txtTrabId = new InputText();
			}

			txtTrabId.setValue(tarifaOtrosDevengosDTO.getTrabId());

			if (txtValorDeduccion == null) {
				txtValorDeduccion = new InputText();
			}

			txtValorDeduccion.setValue(tarifaOtrosDevengosDTO.getValorDeduccion());

			if (txtOdevengosId == null) {
				txtOdevengosId = new InputText();
			}

			txtOdevengosId.setValue(tarifaOtrosDevengosDTO.getOdevengosId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tarifaOtrosDevengosDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(tarifaOtrosDevengosDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(tarifaOtrosDevengosDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tarifaOtrosDevengosDTO.getFechaModificacion());

			Long odevengosId = FacesUtils.checkLong(txtOdevengosId);
			entity = businessDelegatorView.getTarifaOtrosDevengos(odevengosId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTarifaOtrosDevengos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTarifaOtrosDevengos = null;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConceptoNominaId != null) {
			txtConceptoNominaId.setValue(null);
			txtConceptoNominaId.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtTrabId != null) {
			txtTrabId.setValue(null);
			txtTrabId.setDisabled(true);
		}

		if (txtValorDeduccion != null) {
			txtValorDeduccion.setValue(null);
			txtValorDeduccion.setDisabled(true);
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

		if (txtOdevengosId != null) {
			txtOdevengosId.setValue(null);
			txtOdevengosId.setDisabled(false);
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
			Long odevengosId = FacesUtils.checkLong(txtOdevengosId);
			entity = (odevengosId != null) ? businessDelegatorView.getTarifaOtrosDevengos(odevengosId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtConceptoNominaId.setDisabled(false);
			txtEstado.setDisabled(false);
			txtTrabId.setDisabled(false);
			txtValorDeduccion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtOdevengosId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtConceptoNominaId.setValue(entity.getConceptoNominaId());
			txtConceptoNominaId.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtTrabId.setValue(entity.getTrabId());
			txtTrabId.setDisabled(false);
			txtValorDeduccion.setValue(entity.getValorDeduccion());
			txtValorDeduccion.setDisabled(false);
			txtOdevengosId.setValue(entity.getOdevengosId());
			txtOdevengosId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTarifaOtrosDevengos = (TarifaOtrosDevengosDTO) (evt.getComponent().getAttributes()
				.get("selectedTarifaOtrosDevengos"));
		txtCompania.setValue(selectedTarifaOtrosDevengos.getCompania());
		txtCompania.setDisabled(false);
		txtConceptoNominaId.setValue(selectedTarifaOtrosDevengos.getConceptoNominaId());
		txtConceptoNominaId.setDisabled(false);
		txtEstado.setValue(selectedTarifaOtrosDevengos.getEstado());
		txtEstado.setDisabled(false);
		txtFechaCreacion.setValue(selectedTarifaOtrosDevengos.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedTarifaOtrosDevengos.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedTarifaOtrosDevengos.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedTarifaOtrosDevengos.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtTrabId.setValue(selectedTarifaOtrosDevengos.getTrabId());
		txtTrabId.setDisabled(false);
		txtValorDeduccion.setValue(selectedTarifaOtrosDevengos.getValorDeduccion());
		txtValorDeduccion.setDisabled(false);
		txtOdevengosId.setValue(selectedTarifaOtrosDevengos.getOdevengosId());
		txtOdevengosId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTarifaOtrosDevengos == null) && (entity == null)) {
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
			entity = new TarifaOtrosDevengos();

			Long odevengosId = FacesUtils.checkLong(txtOdevengosId);

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setOdevengosId(odevengosId);
			entity.setValorDeduccion(FacesUtils.checkDouble(txtValorDeduccion));
			businessDelegatorView.saveTarifaOtrosDevengos(entity);
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
				Long odevengosId = new Long(selectedTarifaOtrosDevengos.getOdevengosId());
				entity = businessDelegatorView.getTarifaOtrosDevengos(odevengosId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValorDeduccion(FacesUtils.checkDouble(txtValorDeduccion));
			businessDelegatorView.updateTarifaOtrosDevengos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTarifaOtrosDevengos = (TarifaOtrosDevengosDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaOtrosDevengos"));

			Long odevengosId = new Long(selectedTarifaOtrosDevengos.getOdevengosId());
			entity = businessDelegatorView.getTarifaOtrosDevengos(odevengosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long odevengosId = FacesUtils.checkLong(txtOdevengosId);
			entity = businessDelegatorView.getTarifaOtrosDevengos(odevengosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTarifaOtrosDevengos(entity);
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
			selectedTarifaOtrosDevengos = (TarifaOtrosDevengosDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaOtrosDevengos"));

			Long odevengosId = new Long(selectedTarifaOtrosDevengos.getOdevengosId());
			entity = businessDelegatorView.getTarifaOtrosDevengos(odevengosId);
			businessDelegatorView.deleteTarifaOtrosDevengos(entity);
			data.remove(selectedTarifaOtrosDevengos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long conceptoNominaId, String estado, Date fechaCreacion,
			Date fechaFinal, Date fechaInicial, Date fechaModificacion, Long odevengosId, Long trabId,
			Double valorDeduccion) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setValorDeduccion(FacesUtils.checkDouble(valorDeduccion));
			businessDelegatorView.updateTarifaOtrosDevengos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TarifaOtrosDevengosView").requestRender();
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

	public InputText getTxtConceptoNominaId() {
		return txtConceptoNominaId;
	}

	public void setTxtConceptoNominaId(InputText txtConceptoNominaId) {
		this.txtConceptoNominaId = txtConceptoNominaId;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtTrabId() {
		return txtTrabId;
	}

	public void setTxtTrabId(InputText txtTrabId) {
		this.txtTrabId = txtTrabId;
	}

	public InputText getTxtValorDeduccion() {
		return txtValorDeduccion;
	}

	public void setTxtValorDeduccion(InputText txtValorDeduccion) {
		this.txtValorDeduccion = txtValorDeduccion;
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

	public InputText getTxtOdevengosId() {
		return txtOdevengosId;
	}

	public void setTxtOdevengosId(InputText txtOdevengosId) {
		this.txtOdevengosId = txtOdevengosId;
	}

	public List<TarifaOtrosDevengosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTarifaOtrosDevengos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TarifaOtrosDevengosDTO> tarifaOtrosDevengosDTO) {
		this.data = tarifaOtrosDevengosDTO;
	}

	public TarifaOtrosDevengosDTO getSelectedTarifaOtrosDevengos() {
		return selectedTarifaOtrosDevengos;
	}

	public void setSelectedTarifaOtrosDevengos(TarifaOtrosDevengosDTO tarifaOtrosDevengos) {
		this.selectedTarifaOtrosDevengos = tarifaOtrosDevengos;
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
