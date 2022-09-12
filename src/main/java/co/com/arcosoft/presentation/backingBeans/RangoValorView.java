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
import co.com.arcosoft.modelo.RangoValor;
import co.com.arcosoft.modelo.dto.RangoValorDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RangoValorView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RangoValorView.class);
	private InputText txtClasificacion;
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtEstado;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional2;
	private InputText txtValorFinal;
	private InputText txtValorInicial;
	private InputText txtVariableId_Variable;
	private InputText txtRangoValorId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RangoValorDTO> data;
	private RangoValorDTO selectedRangoValor;
	private RangoValor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RangoValorView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RangoValorDTO rangoValorDTO = (RangoValorDTO) e.getObject();

			if (txtClasificacion == null) {
				txtClasificacion = new InputText();
			}

			txtClasificacion.setValue(rangoValorDTO.getClasificacion());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(rangoValorDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(rangoValorDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(rangoValorDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputText();
			}

			txtInfoAdicional.setValue(rangoValorDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputText();
			}

			txtInfoAdicional2.setValue(rangoValorDTO.getInfoAdicional2());

			if (txtValorFinal == null) {
				txtValorFinal = new InputText();
			}

			txtValorFinal.setValue(rangoValorDTO.getValorFinal());

			if (txtValorInicial == null) {
				txtValorInicial = new InputText();
			}

			txtValorInicial.setValue(rangoValorDTO.getValorInicial());

			if (txtVariableId_Variable == null) {
				txtVariableId_Variable = new InputText();
			}

			txtVariableId_Variable.setValue(rangoValorDTO.getVariableId_Variable());

			if (txtRangoValorId == null) {
				txtRangoValorId = new InputText();
			}

			txtRangoValorId.setValue(rangoValorDTO.getRangoValorId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(rangoValorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(rangoValorDTO.getFechaModificacion());

			Long rangoValorId = FacesUtils.checkLong(txtRangoValorId);
			entity = businessDelegatorView.getRangoValor(rangoValorId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRangoValor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRangoValor = null;

		if (txtClasificacion != null) {
			txtClasificacion.setValue(null);
			txtClasificacion.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtValorFinal != null) {
			txtValorFinal.setValue(null);
			txtValorFinal.setDisabled(true);
		}

		if (txtValorInicial != null) {
			txtValorInicial.setValue(null);
			txtValorInicial.setDisabled(true);
		}

		if (txtVariableId_Variable != null) {
			txtVariableId_Variable.setValue(null);
			txtVariableId_Variable.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtRangoValorId != null) {
			txtRangoValorId.setValue(null);
			txtRangoValorId.setDisabled(false);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long rangoValorId = FacesUtils.checkLong(txtRangoValorId);
			entity = (rangoValorId != null) ? businessDelegatorView.getRangoValor(rangoValorId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtClasificacion.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtValorFinal.setDisabled(false);
			txtValorInicial.setDisabled(false);
			txtVariableId_Variable.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtRangoValorId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtClasificacion.setValue(entity.getClasificacion());
			txtClasificacion.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtValorFinal.setValue(entity.getValorFinal());
			txtValorFinal.setDisabled(false);
			txtValorInicial.setValue(entity.getValorInicial());
			txtValorInicial.setDisabled(false);
			txtVariableId_Variable.setValue(entity.getVariable().getVariableId());
			txtVariableId_Variable.setDisabled(false);
			txtRangoValorId.setValue(entity.getRangoValorId());
			txtRangoValorId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRangoValor = (RangoValorDTO) (evt.getComponent().getAttributes().get("selectedRangoValor"));
		txtClasificacion.setValue(selectedRangoValor.getClasificacion());
		txtClasificacion.setDisabled(false);
		txtCodigo.setValue(selectedRangoValor.getCodigo());
		txtCodigo.setDisabled(false);
		txtCompania.setValue(selectedRangoValor.getCompania());
		txtCompania.setDisabled(false);
		txtEstado.setValue(selectedRangoValor.getEstado());
		txtEstado.setDisabled(false);
		txtFechaCreacion.setValue(selectedRangoValor.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRangoValor.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtInfoAdicional.setValue(selectedRangoValor.getInfoAdicional());
		txtInfoAdicional.setDisabled(false);
		txtInfoAdicional2.setValue(selectedRangoValor.getInfoAdicional2());
		txtInfoAdicional2.setDisabled(false);
		txtValorFinal.setValue(selectedRangoValor.getValorFinal());
		txtValorFinal.setDisabled(false);
		txtValorInicial.setValue(selectedRangoValor.getValorInicial());
		txtValorInicial.setDisabled(false);
		txtVariableId_Variable.setValue(selectedRangoValor.getVariableId_Variable());
		txtVariableId_Variable.setDisabled(false);
		txtRangoValorId.setValue(selectedRangoValor.getRangoValorId());
		txtRangoValorId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRangoValor == null) && (entity == null)) {
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
			entity = new RangoValor();

			Long rangoValorId = FacesUtils.checkLong(txtRangoValorId);

			entity.setClasificacion(FacesUtils.checkString(txtClasificacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setRangoValorId(rangoValorId);
			entity.setValorFinal(FacesUtils.checkDouble(txtValorFinal));
			entity.setValorInicial(FacesUtils.checkDouble(txtValorInicial));
			entity.setVariable((FacesUtils.checkLong(txtVariableId_Variable) != null)
					? businessDelegatorView.getVariable(FacesUtils.checkLong(txtVariableId_Variable)) : null);
			businessDelegatorView.saveRangoValor(entity);
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
				Long rangoValorId = new Long(selectedRangoValor.getRangoValorId());
				entity = businessDelegatorView.getRangoValor(rangoValorId);
			}

			entity.setClasificacion(FacesUtils.checkString(txtClasificacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setValorFinal(FacesUtils.checkDouble(txtValorFinal));
			entity.setValorInicial(FacesUtils.checkDouble(txtValorInicial));
			entity.setVariable((FacesUtils.checkLong(txtVariableId_Variable) != null)
					? businessDelegatorView.getVariable(FacesUtils.checkLong(txtVariableId_Variable)) : null);
			businessDelegatorView.updateRangoValor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedRangoValor = (RangoValorDTO) (evt.getComponent().getAttributes().get("selectedRangoValor"));

			Long rangoValorId = new Long(selectedRangoValor.getRangoValorId());
			entity = businessDelegatorView.getRangoValor(rangoValorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long rangoValorId = FacesUtils.checkLong(txtRangoValorId);
			entity = businessDelegatorView.getRangoValor(rangoValorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteRangoValor(entity);
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
			selectedRangoValor = (RangoValorDTO) (evt.getComponent().getAttributes().get("selectedRangoValor"));

			Long rangoValorId = new Long(selectedRangoValor.getRangoValorId());
			entity = businessDelegatorView.getRangoValor(rangoValorId);
			businessDelegatorView.deleteRangoValor(entity);
			data.remove(selectedRangoValor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String clasificacion, String codigo, Long compania, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, Long rangoValorId,
			Long valorFinal, Long valorInicial, Long variableId_Variable) throws Exception {
		try {
			entity.setClasificacion(FacesUtils.checkString(clasificacion));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setValorFinal(FacesUtils.checkDouble(valorFinal));
			entity.setValorInicial(FacesUtils.checkDouble(valorInicial));
			businessDelegatorView.updateRangoValor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RangoValorView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtClasificacion() {
		return txtClasificacion;
	}

	public void setTxtClasificacion(InputText txtClasificacion) {
		this.txtClasificacion = txtClasificacion;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputText txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public InputText getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public void setTxtInfoAdicional2(InputText txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public InputText getTxtValorFinal() {
		return txtValorFinal;
	}

	public void setTxtValorFinal(InputText txtValorFinal) {
		this.txtValorFinal = txtValorFinal;
	}

	public InputText getTxtValorInicial() {
		return txtValorInicial;
	}

	public void setTxtValorInicial(InputText txtValorInicial) {
		this.txtValorInicial = txtValorInicial;
	}

	public InputText getTxtVariableId_Variable() {
		return txtVariableId_Variable;
	}

	public void setTxtVariableId_Variable(InputText txtVariableId_Variable) {
		this.txtVariableId_Variable = txtVariableId_Variable;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtRangoValorId() {
		return txtRangoValorId;
	}

	public void setTxtRangoValorId(InputText txtRangoValorId) {
		this.txtRangoValorId = txtRangoValorId;
	}

	public List<RangoValorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRangoValor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RangoValorDTO> rangoValorDTO) {
		this.data = rangoValorDTO;
	}

	public RangoValorDTO getSelectedRangoValor() {
		return selectedRangoValor;
	}

	public void setSelectedRangoValor(RangoValorDTO rangoValor) {
		this.selectedRangoValor = rangoValor;
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
