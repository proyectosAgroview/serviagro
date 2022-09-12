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
import co.com.arcosoft.modelo.TarifaDeduccion;
import co.com.arcosoft.modelo.dto.TarifaDeduccionDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TarifaDeduccionView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaDeduccionView.class);
	private InputText txtCompania;
	private InputText txtConceptoNominaId;
	private InputText txtEstado;
	private InputText txtValorDeduccion;
	private InputText txtTrabId_Trabajador;
	private InputText txtDeduccionId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TarifaDeduccionDTO> data;
	private TarifaDeduccionDTO selectedTarifaDeduccion;
	private TarifaDeduccion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TarifaDeduccionView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TarifaDeduccionDTO tarifaDeduccionDTO = (TarifaDeduccionDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tarifaDeduccionDTO.getCompania());

			if (txtConceptoNominaId == null) {
				txtConceptoNominaId = new InputText();
			}

			txtConceptoNominaId.setValue(tarifaDeduccionDTO.getConceptoNominaId());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(tarifaDeduccionDTO.getEstado());

			if (txtValorDeduccion == null) {
				txtValorDeduccion = new InputText();
			}

			txtValorDeduccion.setValue(tarifaDeduccionDTO.getValorDeduccion());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new InputText();
			}

			txtTrabId_Trabajador.setValue(tarifaDeduccionDTO.getTrabId_Trabajador());

			if (txtDeduccionId == null) {
				txtDeduccionId = new InputText();
			}

			txtDeduccionId.setValue(tarifaDeduccionDTO.getDeduccionId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tarifaDeduccionDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(tarifaDeduccionDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(tarifaDeduccionDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tarifaDeduccionDTO.getFechaModificacion());

			Long deduccionId = FacesUtils.checkLong(txtDeduccionId);
			entity = businessDelegatorView.getTarifaDeduccion(deduccionId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTarifaDeduccion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTarifaDeduccion = null;

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

		if (txtValorDeduccion != null) {
			txtValorDeduccion.setValue(null);
			txtValorDeduccion.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
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

		if (txtDeduccionId != null) {
			txtDeduccionId.setValue(null);
			txtDeduccionId.setDisabled(false);
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
			Long deduccionId = FacesUtils.checkLong(txtDeduccionId);
			entity = (deduccionId != null) ? businessDelegatorView.getTarifaDeduccion(deduccionId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtConceptoNominaId.setDisabled(false);
			txtEstado.setDisabled(false);
			txtValorDeduccion.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtDeduccionId.setDisabled(false);
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
			txtValorDeduccion.setValue(entity.getValorDeduccion());
			txtValorDeduccion.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
			txtTrabId_Trabajador.setDisabled(false);
			txtDeduccionId.setValue(entity.getDeduccionId());
			txtDeduccionId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTarifaDeduccion = (TarifaDeduccionDTO) (evt.getComponent().getAttributes()
				.get("selectedTarifaDeduccion"));
		txtCompania.setValue(selectedTarifaDeduccion.getCompania());
		txtCompania.setDisabled(false);
		txtConceptoNominaId.setValue(selectedTarifaDeduccion.getConceptoNominaId());
		txtConceptoNominaId.setDisabled(false);
		txtEstado.setValue(selectedTarifaDeduccion.getEstado());
		txtEstado.setDisabled(false);
		txtFechaCreacion.setValue(selectedTarifaDeduccion.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedTarifaDeduccion.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedTarifaDeduccion.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedTarifaDeduccion.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtValorDeduccion.setValue(selectedTarifaDeduccion.getValorDeduccion());
		txtValorDeduccion.setDisabled(false);
		txtTrabId_Trabajador.setValue(selectedTarifaDeduccion.getTrabId_Trabajador());
		txtTrabId_Trabajador.setDisabled(false);
		txtDeduccionId.setValue(selectedTarifaDeduccion.getDeduccionId());
		txtDeduccionId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTarifaDeduccion == null) && (entity == null)) {
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
			entity = new TarifaDeduccion();

			Long deduccionId = FacesUtils.checkLong(txtDeduccionId);

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setDeduccionId(deduccionId);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValorDeduccion(FacesUtils.checkDouble(txtValorDeduccion));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			businessDelegatorView.saveTarifaDeduccion(entity);
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
				Long deduccionId = new Long(selectedTarifaDeduccion.getDeduccionId());
				entity = businessDelegatorView.getTarifaDeduccion(deduccionId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValorDeduccion(FacesUtils.checkDouble(txtValorDeduccion));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			businessDelegatorView.updateTarifaDeduccion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTarifaDeduccion = (TarifaDeduccionDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaDeduccion"));

			Long deduccionId = new Long(selectedTarifaDeduccion.getDeduccionId());
			entity = businessDelegatorView.getTarifaDeduccion(deduccionId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long deduccionId = FacesUtils.checkLong(txtDeduccionId);
			entity = businessDelegatorView.getTarifaDeduccion(deduccionId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTarifaDeduccion(entity);
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
			selectedTarifaDeduccion = (TarifaDeduccionDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaDeduccion"));

			Long deduccionId = new Long(selectedTarifaDeduccion.getDeduccionId());
			entity = businessDelegatorView.getTarifaDeduccion(deduccionId);
			businessDelegatorView.deleteTarifaDeduccion(entity);
			data.remove(selectedTarifaDeduccion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long conceptoNominaId, Long deduccionId, String estado,
			Date fechaCreacion, Date fechaFinal, Date fechaInicial, Date fechaModificacion, Double valorDeduccion,
			Long trabId_Trabajador) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setValorDeduccion(FacesUtils.checkDouble(valorDeduccion));
			businessDelegatorView.updateTarifaDeduccion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TarifaDeduccionView").requestRender();
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

	public InputText getTxtValorDeduccion() {
		return txtValorDeduccion;
	}

	public void setTxtValorDeduccion(InputText txtValorDeduccion) {
		this.txtValorDeduccion = txtValorDeduccion;
	}

	public InputText getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(InputText txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
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

	public InputText getTxtDeduccionId() {
		return txtDeduccionId;
	}

	public void setTxtDeduccionId(InputText txtDeduccionId) {
		this.txtDeduccionId = txtDeduccionId;
	}

	public List<TarifaDeduccionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTarifaDeduccion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TarifaDeduccionDTO> tarifaDeduccionDTO) {
		this.data = tarifaDeduccionDTO;
	}

	public TarifaDeduccionDTO getSelectedTarifaDeduccion() {
		return selectedTarifaDeduccion;
	}

	public void setSelectedTarifaDeduccion(TarifaDeduccionDTO tarifaDeduccion) {
		this.selectedTarifaDeduccion = tarifaDeduccion;
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
