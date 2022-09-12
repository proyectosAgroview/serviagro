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
import co.com.arcosoft.modelo.ListValor;
import co.com.arcosoft.modelo.dto.ListValorDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ListValorView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ListValorView.class);
	private InputText txtClasificacion;
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional2;
	private InputText txtValorAlfaNumerico;
	private InputText txtValorNumerico;
	private InputText txtVariableId_Variable;
	private InputText txtListValorId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ListValorDTO> data;
	private ListValorDTO selectedListValor;
	private ListValor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ListValorView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ListValorDTO listValorDTO = (ListValorDTO) e.getObject();

			if (txtClasificacion == null) {
				txtClasificacion = new InputText();
			}

			txtClasificacion.setValue(listValorDTO.getClasificacion());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(listValorDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(listValorDTO.getCompania());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputText();
			}

			txtInfoAdicional.setValue(listValorDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputText();
			}

			txtInfoAdicional2.setValue(listValorDTO.getInfoAdicional2());

			if (txtValorAlfaNumerico == null) {
				txtValorAlfaNumerico = new InputText();
			}

			txtValorAlfaNumerico.setValue(listValorDTO.getValorAlfaNumerico());

			if (txtValorNumerico == null) {
				txtValorNumerico = new InputText();
			}

			txtValorNumerico.setValue(listValorDTO.getValorNumerico());

			if (txtVariableId_Variable == null) {
				txtVariableId_Variable = new InputText();
			}

			txtVariableId_Variable.setValue(listValorDTO.getVariableId_Variable());

			if (txtListValorId == null) {
				txtListValorId = new InputText();
			}

			txtListValorId.setValue(listValorDTO.getListValorId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(listValorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(listValorDTO.getFechaModificacion());

			Long listValorId = FacesUtils.checkLong(txtListValorId);
			entity = businessDelegatorView.getListValor(listValorId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedListValor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedListValor = null;

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

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtValorAlfaNumerico != null) {
			txtValorAlfaNumerico.setValue(null);
			txtValorAlfaNumerico.setDisabled(true);
		}

		if (txtValorNumerico != null) {
			txtValorNumerico.setValue(null);
			txtValorNumerico.setDisabled(true);
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

		if (txtListValorId != null) {
			txtListValorId.setValue(null);
			txtListValorId.setDisabled(false);
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
			Long listValorId = FacesUtils.checkLong(txtListValorId);
			entity = (listValorId != null) ? businessDelegatorView.getListValor(listValorId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtClasificacion.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtValorAlfaNumerico.setDisabled(false);
			txtValorNumerico.setDisabled(false);
			txtVariableId_Variable.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtListValorId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtClasificacion.setValue(entity.getClasificacion());
			txtClasificacion.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtValorAlfaNumerico.setValue(entity.getValorAlfaNumerico());
			txtValorAlfaNumerico.setDisabled(false);
			txtValorNumerico.setValue(entity.getValorNumerico());
			txtValorNumerico.setDisabled(false);
			txtVariableId_Variable.setValue(entity.getVariable().getVariableId());
			txtVariableId_Variable.setDisabled(false);
			txtListValorId.setValue(entity.getListValorId());
			txtListValorId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedListValor = (ListValorDTO) (evt.getComponent().getAttributes().get("selectedListValor"));
		txtClasificacion.setValue(selectedListValor.getClasificacion());
		txtClasificacion.setDisabled(false);
		txtCodigo.setValue(selectedListValor.getCodigo());
		txtCodigo.setDisabled(false);
		txtCompania.setValue(selectedListValor.getCompania());
		txtCompania.setDisabled(false);
		txtFechaCreacion.setValue(selectedListValor.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedListValor.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtInfoAdicional.setValue(selectedListValor.getInfoAdicional());
		txtInfoAdicional.setDisabled(false);
		txtInfoAdicional2.setValue(selectedListValor.getInfoAdicional2());
		txtInfoAdicional2.setDisabled(false);
		txtValorAlfaNumerico.setValue(selectedListValor.getValorAlfaNumerico());
		txtValorAlfaNumerico.setDisabled(false);
		txtValorNumerico.setValue(selectedListValor.getValorNumerico());
		txtValorNumerico.setDisabled(false);
		txtVariableId_Variable.setValue(selectedListValor.getVariableId_Variable());
		txtVariableId_Variable.setDisabled(false);
		txtListValorId.setValue(selectedListValor.getListValorId());
		txtListValorId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedListValor == null) && (entity == null)) {
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
			entity = new ListValor();

			Long listValorId = FacesUtils.checkLong(txtListValorId);

			entity.setClasificacion(FacesUtils.checkString(txtClasificacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setListValorId(listValorId);
			entity.setValorAlfaNumerico(FacesUtils.checkString(txtValorAlfaNumerico));
			entity.setValorNumerico(FacesUtils.checkLong(txtValorNumerico));
			entity.setVariable((FacesUtils.checkLong(txtVariableId_Variable) != null)
					? businessDelegatorView.getVariable(FacesUtils.checkLong(txtVariableId_Variable)) : null);
			businessDelegatorView.saveListValor(entity);
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
				Long listValorId = new Long(selectedListValor.getListValorId());
				entity = businessDelegatorView.getListValor(listValorId);
			}

			entity.setClasificacion(FacesUtils.checkString(txtClasificacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setValorAlfaNumerico(FacesUtils.checkString(txtValorAlfaNumerico));
			entity.setValorNumerico(FacesUtils.checkLong(txtValorNumerico));
			entity.setVariable((FacesUtils.checkLong(txtVariableId_Variable) != null)
					? businessDelegatorView.getVariable(FacesUtils.checkLong(txtVariableId_Variable)) : null);
			businessDelegatorView.updateListValor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedListValor = (ListValorDTO) (evt.getComponent().getAttributes().get("selectedListValor"));

			Long listValorId = new Long(selectedListValor.getListValorId());
			entity = businessDelegatorView.getListValor(listValorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long listValorId = FacesUtils.checkLong(txtListValorId);
			entity = businessDelegatorView.getListValor(listValorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteListValor(entity);
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
			selectedListValor = (ListValorDTO) (evt.getComponent().getAttributes().get("selectedListValor"));

			Long listValorId = new Long(selectedListValor.getListValorId());
			entity = businessDelegatorView.getListValor(listValorId);
			businessDelegatorView.deleteListValor(entity);
			data.remove(selectedListValor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String clasificacion, String codigo, Long compania, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, Long listValorId,
			String valorAlfaNumerico, Long valorNumerico, Long variableId_Variable) throws Exception {
		try {
			entity.setClasificacion(FacesUtils.checkString(clasificacion));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));

			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setValorAlfaNumerico(FacesUtils.checkString(valorAlfaNumerico));
			entity.setValorNumerico(FacesUtils.checkLong(valorNumerico));
			businessDelegatorView.updateListValor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ListValorView").requestRender();
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

	public InputText getTxtValorAlfaNumerico() {
		return txtValorAlfaNumerico;
	}

	public void setTxtValorAlfaNumerico(InputText txtValorAlfaNumerico) {
		this.txtValorAlfaNumerico = txtValorAlfaNumerico;
	}

	public InputText getTxtValorNumerico() {
		return txtValorNumerico;
	}

	public void setTxtValorNumerico(InputText txtValorNumerico) {
		this.txtValorNumerico = txtValorNumerico;
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

	public InputText getTxtListValorId() {
		return txtListValorId;
	}

	public void setTxtListValorId(InputText txtListValorId) {
		this.txtListValorId = txtListValorId;
	}

	public List<ListValorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataListValor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ListValorDTO> listValorDTO) {
		this.data = listValorDTO;
	}

	public ListValorDTO getSelectedListValor() {
		return selectedListValor;
	}

	public void setSelectedListValor(ListValorDTO listValor) {
		this.selectedListValor = listValor;
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
