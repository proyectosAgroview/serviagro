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
import co.com.arcosoft.modelo.TarifaContratista;
import co.com.arcosoft.modelo.dto.TarifaContratistaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TarifaContratistaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TarifaContratistaView.class);
	private InputText txtCompania;
	private InputText txtTarifa;
	private InputText txtLaborId_Labor;
	private InputText txtPersEmprId_PersEmpr;
	private InputText txtServicioId_Servicio;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtTarifaCtrId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TarifaContratistaDTO> data;
	private TarifaContratistaDTO selectedTarifaContratista;
	private TarifaContratista entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TarifaContratistaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TarifaContratistaDTO tarifaContratistaDTO = (TarifaContratistaDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tarifaContratistaDTO.getCompania());

			if (txtTarifa == null) {
				txtTarifa = new InputText();
			}

			txtTarifa.setValue(tarifaContratistaDTO.getTarifa());

			if (txtLaborId_Labor == null) {
				txtLaborId_Labor = new InputText();
			}

			txtLaborId_Labor.setValue(tarifaContratistaDTO.getLaborId_Labor());

			if (txtPersEmprId_PersEmpr == null) {
				txtPersEmprId_PersEmpr = new InputText();
			}

			txtPersEmprId_PersEmpr.setValue(tarifaContratistaDTO.getPersEmprId_PersEmpr());

			if (txtServicioId_Servicio == null) {
				txtServicioId_Servicio = new InputText();
			}

			txtServicioId_Servicio.setValue(tarifaContratistaDTO.getServicioId_Servicio());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(tarifaContratistaDTO.getUdadMedId_UdadMed());

			if (txtTarifaCtrId == null) {
				txtTarifaCtrId = new InputText();
			}

			txtTarifaCtrId.setValue(tarifaContratistaDTO.getTarifaCtrId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tarifaContratistaDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(tarifaContratistaDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(tarifaContratistaDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tarifaContratistaDTO.getFechaModificacion());

			Long tarifaCtrId = FacesUtils.checkLong(txtTarifaCtrId);
			entity = businessDelegatorView.getTarifaContratista(tarifaCtrId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTarifaContratista = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTarifaContratista = null;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtTarifa != null) {
			txtTarifa.setValue(null);
			txtTarifa.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
		}

		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(true);
		}

		if (txtServicioId_Servicio != null) {
			txtServicioId_Servicio.setValue(null);
			txtServicioId_Servicio.setDisabled(true);
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

		if (txtTarifaCtrId != null) {
			txtTarifaCtrId.setValue(null);
			txtTarifaCtrId.setDisabled(false);
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
			Long tarifaCtrId = FacesUtils.checkLong(txtTarifaCtrId);
			entity = (tarifaCtrId != null) ? businessDelegatorView.getTarifaContratista(tarifaCtrId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtTarifa.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtPersEmprId_PersEmpr.setDisabled(false);
			txtServicioId_Servicio.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtTarifaCtrId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
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
			txtLaborId_Labor.setValue(entity.getLabor());
			txtLaborId_Labor.setDisabled(false);
			txtPersEmprId_PersEmpr.setValue(entity.getPersEmpr());
			txtPersEmprId_PersEmpr.setDisabled(false);
			txtServicioId_Servicio.setValue(entity.getServicio());
			txtServicioId_Servicio.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtTarifaCtrId.setValue(entity.getTarifaCtrId());
			txtTarifaCtrId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTarifaContratista = (TarifaContratistaDTO) (evt.getComponent().getAttributes()
				.get("selectedTarifaContratista"));
		txtCompania.setValue(selectedTarifaContratista.getCompania());
		txtCompania.setDisabled(false);
		txtFechaCreacion.setValue(selectedTarifaContratista.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedTarifaContratista.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedTarifaContratista.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedTarifaContratista.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtTarifa.setValue(selectedTarifaContratista.getTarifa());
		txtTarifa.setDisabled(false);
		txtLaborId_Labor.setValue(selectedTarifaContratista.getLaborId_Labor());
		txtLaborId_Labor.setDisabled(false);
		txtPersEmprId_PersEmpr.setValue(selectedTarifaContratista.getPersEmprId_PersEmpr());
		txtPersEmprId_PersEmpr.setDisabled(false);
		txtServicioId_Servicio.setValue(selectedTarifaContratista.getServicioId_Servicio());
		txtServicioId_Servicio.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedTarifaContratista.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtTarifaCtrId.setValue(selectedTarifaContratista.getTarifaCtrId());
		txtTarifaCtrId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTarifaContratista == null) && (entity == null)) {
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
			entity = new TarifaContratista();

			Long tarifaCtrId = FacesUtils.checkLong(txtTarifaCtrId);

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setTarifaCtrId(tarifaCtrId);
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr)) : null);
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtServicioId_Servicio)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			businessDelegatorView.saveTarifaContratista(entity);
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
				Long tarifaCtrId = new Long(selectedTarifaContratista.getTarifaCtrId());
				entity = businessDelegatorView.getTarifaContratista(tarifaCtrId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(txtTarifa));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr)) : null);
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtServicioId_Servicio)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			businessDelegatorView.updateTarifaContratista(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedTarifaContratista = (TarifaContratistaDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaContratista"));

			Long tarifaCtrId = new Long(selectedTarifaContratista.getTarifaCtrId());
			entity = businessDelegatorView.getTarifaContratista(tarifaCtrId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long tarifaCtrId = FacesUtils.checkLong(txtTarifaCtrId);
			entity = businessDelegatorView.getTarifaContratista(tarifaCtrId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTarifaContratista(entity);
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
			selectedTarifaContratista = (TarifaContratistaDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaContratista"));

			Long tarifaCtrId = new Long(selectedTarifaContratista.getTarifaCtrId());
			entity = businessDelegatorView.getTarifaContratista(tarifaCtrId);
			businessDelegatorView.deleteTarifaContratista(entity);
			data.remove(selectedTarifaContratista);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Double tarifa, Long tarifaCtrId, Long laborId_Labor, Long persEmprId_PersEmpr,
			Long servicioId_Servicio, Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setTarifa(FacesUtils.checkDouble(tarifa));
			businessDelegatorView.updateTarifaContratista(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TarifaContratistaView").requestRender();
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

	public InputText getTxtTarifa() {
		return txtTarifa;
	}

	public void setTxtTarifa(InputText txtTarifa) {
		this.txtTarifa = txtTarifa;
	}

	public InputText getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(InputText txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public InputText getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(InputText txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}

	public InputText getTxtServicioId_Servicio() {
		return txtServicioId_Servicio;
	}

	public void setTxtServicioId_Servicio(InputText txtServicioId_Servicio) {
		this.txtServicioId_Servicio = txtServicioId_Servicio;
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

	public InputText getTxtTarifaCtrId() {
		return txtTarifaCtrId;
	}

	public void setTxtTarifaCtrId(InputText txtTarifaCtrId) {
		this.txtTarifaCtrId = txtTarifaCtrId;
	}

	public List<TarifaContratistaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTarifaContratista();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TarifaContratistaDTO> tarifaContratistaDTO) {
		this.data = tarifaContratistaDTO;
	}

	public TarifaContratistaDTO getSelectedTarifaContratista() {
		return selectedTarifaContratista;
	}

	public void setSelectedTarifaContratista(TarifaContratistaDTO tarifaContratista) {
		this.selectedTarifaContratista = tarifaContratista;
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
