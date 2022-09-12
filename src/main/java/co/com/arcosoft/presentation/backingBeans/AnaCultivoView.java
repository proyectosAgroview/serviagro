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
import co.com.arcosoft.modelo.AnaCultivo;
import co.com.arcosoft.modelo.dto.AnaCultivoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class AnaCultivoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(AnaCultivoView.class);
	private InputText txtCompania;
	private InputText txtAnaSanVegId_AnaSanVeg;
	private InputText txtCultivoId_Cultivo;
	private InputText txtAnaCultId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<AnaCultivoDTO> data;
	private AnaCultivoDTO selectedAnaCultivo;
	private AnaCultivo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AnaCultivoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			AnaCultivoDTO anaCultivoDTO = (AnaCultivoDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(anaCultivoDTO.getCompania());

			if (txtAnaSanVegId_AnaSanVeg == null) {
				txtAnaSanVegId_AnaSanVeg = new InputText();
			}

			txtAnaSanVegId_AnaSanVeg.setValue(anaCultivoDTO.getAnaSanVegId_AnaSanVeg());

			if (txtCultivoId_Cultivo == null) {
				txtCultivoId_Cultivo = new InputText();
			}

			txtCultivoId_Cultivo.setValue(anaCultivoDTO.getCultivoId_Cultivo());

			if (txtAnaCultId == null) {
				txtAnaCultId = new InputText();
			}

			txtAnaCultId.setValue(anaCultivoDTO.getAnaCultId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(anaCultivoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(anaCultivoDTO.getFechaModificacion());

			Long anaCultId = FacesUtils.checkLong(txtAnaCultId);
			entity = businessDelegatorView.getAnaCultivo(anaCultId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedAnaCultivo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedAnaCultivo = null;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtAnaSanVegId_AnaSanVeg != null) {
			txtAnaSanVegId_AnaSanVeg.setValue(null);
			txtAnaSanVegId_AnaSanVeg.setDisabled(true);
		}

		if (txtCultivoId_Cultivo != null) {
			txtCultivoId_Cultivo.setValue(null);
			txtCultivoId_Cultivo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtAnaCultId != null) {
			txtAnaCultId.setValue(null);
			txtAnaCultId.setDisabled(false);
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
			Long anaCultId = FacesUtils.checkLong(txtAnaCultId);
			entity = (anaCultId != null) ? businessDelegatorView.getAnaCultivo(anaCultId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
			txtCultivoId_Cultivo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtAnaCultId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtAnaSanVegId_AnaSanVeg.setValue(entity.getAnaSanVeg().getAnaSanVegId());
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
			txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			txtAnaCultId.setValue(entity.getAnaCultId());
			txtAnaCultId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedAnaCultivo = (AnaCultivoDTO) (evt.getComponent().getAttributes().get("selectedAnaCultivo"));
		txtCompania.setValue(selectedAnaCultivo.getCompania());
		txtCompania.setDisabled(false);
		txtFechaCreacion.setValue(selectedAnaCultivo.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedAnaCultivo.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtAnaSanVegId_AnaSanVeg.setValue(selectedAnaCultivo.getAnaSanVegId_AnaSanVeg());
		txtAnaSanVegId_AnaSanVeg.setDisabled(false);
		txtCultivoId_Cultivo.setValue(selectedAnaCultivo.getCultivoId_Cultivo());
		txtCultivoId_Cultivo.setDisabled(false);
		txtAnaCultId.setValue(selectedAnaCultivo.getAnaCultId());
		txtAnaCultId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedAnaCultivo == null) && (entity == null)) {
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
			entity = new AnaCultivo();

			Long anaCultId = FacesUtils.checkLong(txtAnaCultId);

			entity.setAnaCultId(anaCultId);
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setAnaSanVeg((FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg) != null)
					? businessDelegatorView.getAnaSanVeg(FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg)) : null);
			entity.setCultivo((FacesUtils.checkLong(txtCultivoId_Cultivo) != null)
					? businessDelegatorView.getCultivo(FacesUtils.checkLong(txtCultivoId_Cultivo)) : null);
			businessDelegatorView.saveAnaCultivo(entity);
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
				Long anaCultId = new Long(selectedAnaCultivo.getAnaCultId());
				entity = businessDelegatorView.getAnaCultivo(anaCultId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setAnaSanVeg((FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg) != null)
					? businessDelegatorView.getAnaSanVeg(FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg)) : null);
			entity.setCultivo((FacesUtils.checkLong(txtCultivoId_Cultivo) != null)
					? businessDelegatorView.getCultivo(FacesUtils.checkLong(txtCultivoId_Cultivo)) : null);
			businessDelegatorView.updateAnaCultivo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedAnaCultivo = (AnaCultivoDTO) (evt.getComponent().getAttributes().get("selectedAnaCultivo"));

			Long anaCultId = new Long(selectedAnaCultivo.getAnaCultId());
			entity = businessDelegatorView.getAnaCultivo(anaCultId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long anaCultId = FacesUtils.checkLong(txtAnaCultId);
			entity = businessDelegatorView.getAnaCultivo(anaCultId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteAnaCultivo(entity);
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
			selectedAnaCultivo = (AnaCultivoDTO) (evt.getComponent().getAttributes().get("selectedAnaCultivo"));

			Long anaCultId = new Long(selectedAnaCultivo.getAnaCultId());
			entity = businessDelegatorView.getAnaCultivo(anaCultId);
			businessDelegatorView.deleteAnaCultivo(entity);
			data.remove(selectedAnaCultivo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anaCultId, Long compania, Date fechaCreacion, Date fechaModificacion,
			Long anaSanVegId_AnaSanVeg, Long cultivoId_Cultivo) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			businessDelegatorView.updateAnaCultivo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("AnaCultivoView").requestRender();
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

	public InputText getTxtAnaSanVegId_AnaSanVeg() {
		return txtAnaSanVegId_AnaSanVeg;
	}

	public void setTxtAnaSanVegId_AnaSanVeg(InputText txtAnaSanVegId_AnaSanVeg) {
		this.txtAnaSanVegId_AnaSanVeg = txtAnaSanVegId_AnaSanVeg;
	}

	public InputText getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(InputText txtCultivoId_Cultivo) {
		this.txtCultivoId_Cultivo = txtCultivoId_Cultivo;
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

	public InputText getTxtAnaCultId() {
		return txtAnaCultId;
	}

	public void setTxtAnaCultId(InputText txtAnaCultId) {
		this.txtAnaCultId = txtAnaCultId;
	}

	public List<AnaCultivoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataAnaCultivo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<AnaCultivoDTO> anaCultivoDTO) {
		this.data = anaCultivoDTO;
	}

	public AnaCultivoDTO getSelectedAnaCultivo() {
		return selectedAnaCultivo;
	}

	public void setSelectedAnaCultivo(AnaCultivoDTO anaCultivo) {
		this.selectedAnaCultivo = anaCultivo;
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
