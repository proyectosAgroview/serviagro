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
import co.com.arcosoft.modelo.ValorVar;
import co.com.arcosoft.modelo.dto.ValorVarDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ValorVarView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ValorVarView.class);
	private InputText txtValor;
	private InputText txtDatSanVegId_DatSanVeg;
	private InputText txtVariableId_Variable;
	private InputText txtValorVarId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ValorVarDTO> data;
	private ValorVarDTO selectedValorVar;
	private ValorVar entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ValorVarView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ValorVarDTO valorVarDTO = (ValorVarDTO) e.getObject();

			if (txtValor == null) {
				txtValor = new InputText();
			}

			txtValor.setValue(valorVarDTO.getValor());

			if (txtDatSanVegId_DatSanVeg == null) {
				txtDatSanVegId_DatSanVeg = new InputText();
			}

			txtDatSanVegId_DatSanVeg.setValue(valorVarDTO.getDatSanVegId_DatSanVeg());

			if (txtVariableId_Variable == null) {
				txtVariableId_Variable = new InputText();
			}

			txtVariableId_Variable.setValue(valorVarDTO.getVariableId_Variable());

			if (txtValorVarId == null) {
				txtValorVarId = new InputText();
			}

			txtValorVarId.setValue(valorVarDTO.getValorVarId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(valorVarDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(valorVarDTO.getFechaModificacion());

			Long valorVarId = FacesUtils.checkLong(txtValorVarId);
			entity = businessDelegatorView.getValorVar(valorVarId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedValorVar = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedValorVar = null;

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(true);
		}

		if (txtDatSanVegId_DatSanVeg != null) {
			txtDatSanVegId_DatSanVeg.setValue(null);
			txtDatSanVegId_DatSanVeg.setDisabled(true);
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

		if (txtValorVarId != null) {
			txtValorVarId.setValue(null);
			txtValorVarId.setDisabled(false);
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
			Long valorVarId = FacesUtils.checkLong(txtValorVarId);
			entity = (valorVarId != null) ? businessDelegatorView.getValorVar(valorVarId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtValor.setDisabled(false);
			txtDatSanVegId_DatSanVeg.setDisabled(false);
			txtVariableId_Variable.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtValorVarId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtValor.setValue(entity.getValor());
			txtValor.setDisabled(false);
			txtDatSanVegId_DatSanVeg.setValue(entity.getDatSanVeg().getDatSanVegId());
			txtDatSanVegId_DatSanVeg.setDisabled(false);
			txtVariableId_Variable.setValue(entity.getVariable().getVariableId());
			txtVariableId_Variable.setDisabled(false);
			txtValorVarId.setValue(entity.getValorVarId());
			txtValorVarId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedValorVar = (ValorVarDTO) (evt.getComponent().getAttributes().get("selectedValorVar"));
		txtFechaCreacion.setValue(selectedValorVar.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedValorVar.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtValor.setValue(selectedValorVar.getValor());
		txtValor.setDisabled(false);
		txtDatSanVegId_DatSanVeg.setValue(selectedValorVar.getDatSanVegId_DatSanVeg());
		txtDatSanVegId_DatSanVeg.setDisabled(false);
		txtVariableId_Variable.setValue(selectedValorVar.getVariableId_Variable());
		txtVariableId_Variable.setDisabled(false);
		txtValorVarId.setValue(selectedValorVar.getValorVarId());
		txtValorVarId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedValorVar == null) && (entity == null)) {
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
			entity = new ValorVar();

			Long valorVarId = FacesUtils.checkLong(txtValorVarId);

			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValor(FacesUtils.checkString(txtValor));
			entity.setValorVarId(valorVarId);
			entity.setDatSanVeg((FacesUtils.checkLong(txtDatSanVegId_DatSanVeg) != null)
					? businessDelegatorView.getDatSanVeg(FacesUtils.checkLong(txtDatSanVegId_DatSanVeg)) : null);
			entity.setVariable((FacesUtils.checkLong(txtVariableId_Variable) != null)
					? businessDelegatorView.getVariable(FacesUtils.checkLong(txtVariableId_Variable)) : null);
			businessDelegatorView.saveValorVar(entity);
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
				Long valorVarId = new Long(selectedValorVar.getValorVarId());
				entity = businessDelegatorView.getValorVar(valorVarId);
			}

			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setValor(FacesUtils.checkString(txtValor));
			entity.setDatSanVeg((FacesUtils.checkLong(txtDatSanVegId_DatSanVeg) != null)
					? businessDelegatorView.getDatSanVeg(FacesUtils.checkLong(txtDatSanVegId_DatSanVeg)) : null);
			entity.setVariable((FacesUtils.checkLong(txtVariableId_Variable) != null)
					? businessDelegatorView.getVariable(FacesUtils.checkLong(txtVariableId_Variable)) : null);
			businessDelegatorView.updateValorVar(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedValorVar = (ValorVarDTO) (evt.getComponent().getAttributes().get("selectedValorVar"));

			Long valorVarId = new Long(selectedValorVar.getValorVarId());
			entity = businessDelegatorView.getValorVar(valorVarId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long valorVarId = FacesUtils.checkLong(txtValorVarId);
			entity = businessDelegatorView.getValorVar(valorVarId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteValorVar(entity);
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
			selectedValorVar = (ValorVarDTO) (evt.getComponent().getAttributes().get("selectedValorVar"));

			Long valorVarId = new Long(selectedValorVar.getValorVarId());
			entity = businessDelegatorView.getValorVar(valorVarId);
			businessDelegatorView.deleteValorVar(entity);
			data.remove(selectedValorVar);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Date fechaCreacion, Date fechaModificacion, String valor, Long valorVarId,
			Long datSanVegId_DatSanVeg, Long variableId_Variable) throws Exception {
		try {
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setValor(FacesUtils.checkString(valor));
			businessDelegatorView.updateValorVar(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ValorVarView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
	}

	public InputText getTxtDatSanVegId_DatSanVeg() {
		return txtDatSanVegId_DatSanVeg;
	}

	public void setTxtDatSanVegId_DatSanVeg(InputText txtDatSanVegId_DatSanVeg) {
		this.txtDatSanVegId_DatSanVeg = txtDatSanVegId_DatSanVeg;
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

	public InputText getTxtValorVarId() {
		return txtValorVarId;
	}

	public void setTxtValorVarId(InputText txtValorVarId) {
		this.txtValorVarId = txtValorVarId;
	}

	public List<ValorVarDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataValorVar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ValorVarDTO> valorVarDTO) {
		this.data = valorVarDTO;
	}

	public ValorVarDTO getSelectedValorVar() {
		return selectedValorVar;
	}

	public void setSelectedValorVar(ValorVarDTO valorVar) {
		this.selectedValorVar = valorVar;
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
