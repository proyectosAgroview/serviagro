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
import co.com.arcosoft.modelo.LaraEdad;
import co.com.arcosoft.modelo.dto.LaraEdadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class LaraEdadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaraEdadView.class);
	private InputText txtCompania;
	private InputText txtEdadFinal;
	private InputText txtEdadInicial;
	private InputText txtEstado;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional1;
	private InputText txtValorLaraEdad;
	private InputText txtGrupoSuelo_GrpSuelo;
	private InputText txtLaraEdadId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<LaraEdadDTO> data;
	private LaraEdadDTO selectedLaraEdad;
	private LaraEdad entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public LaraEdadView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			LaraEdadDTO laraEdadDTO = (LaraEdadDTO) e.getObject();

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(laraEdadDTO.getCompania());

			if (txtEdadFinal == null) {
				txtEdadFinal = new InputText();
			}

			txtEdadFinal.setValue(laraEdadDTO.getEdadFinal());

			if (txtEdadInicial == null) {
				txtEdadInicial = new InputText();
			}

			txtEdadInicial.setValue(laraEdadDTO.getEdadInicial());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(laraEdadDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputText();
			}

			txtInfoAdicional.setValue(laraEdadDTO.getInfoAdicional());

			if (txtInfoAdicional1 == null) {
				txtInfoAdicional1 = new InputText();
			}

			txtInfoAdicional1.setValue(laraEdadDTO.getInfoAdicional1());

			if (txtValorLaraEdad == null) {
				txtValorLaraEdad = new InputText();
			}

			txtValorLaraEdad.setValue(laraEdadDTO.getValorLaraEdad());

			if (txtGrupoSuelo_GrpSuelo == null) {
				txtGrupoSuelo_GrpSuelo = new InputText();
			}

			txtGrupoSuelo_GrpSuelo.setValue(laraEdadDTO.getGrupoSuelo_GrpSuelo());

			if (txtLaraEdadId == null) {
				txtLaraEdadId = new InputText();
			}

			txtLaraEdadId.setValue(laraEdadDTO.getLaraEdadId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(laraEdadDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(laraEdadDTO.getFechaModificacion());

			Long laraEdadId = FacesUtils.checkLong(txtLaraEdadId);
			entity = businessDelegatorView.getLaraEdad(laraEdadId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedLaraEdad = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedLaraEdad = null;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEdadFinal != null) {
			txtEdadFinal.setValue(null);
			txtEdadFinal.setDisabled(true);
		}

		if (txtEdadInicial != null) {
			txtEdadInicial.setValue(null);
			txtEdadInicial.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional1 != null) {
			txtInfoAdicional1.setValue(null);
			txtInfoAdicional1.setDisabled(true);
		}

		if (txtValorLaraEdad != null) {
			txtValorLaraEdad.setValue(null);
			txtValorLaraEdad.setDisabled(true);
		}

		if (txtGrupoSuelo_GrpSuelo != null) {
			txtGrupoSuelo_GrpSuelo.setValue(null);
			txtGrupoSuelo_GrpSuelo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtLaraEdadId != null) {
			txtLaraEdadId.setValue(null);
			txtLaraEdadId.setDisabled(false);
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
			Long laraEdadId = FacesUtils.checkLong(txtLaraEdadId);
			entity = (laraEdadId != null) ? businessDelegatorView.getLaraEdad(laraEdadId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCompania.setDisabled(false);
			txtEdadFinal.setDisabled(false);
			txtEdadInicial.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional1.setDisabled(false);
			txtValorLaraEdad.setDisabled(false);
			txtGrupoSuelo_GrpSuelo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtLaraEdadId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEdadFinal.setValue(entity.getEdadFinal());
			txtEdadFinal.setDisabled(false);
			txtEdadInicial.setValue(entity.getEdadInicial());
			txtEdadInicial.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional1.setValue(entity.getInfoAdicional1());
			txtInfoAdicional1.setDisabled(false);
			txtValorLaraEdad.setValue(entity.getValorLaraEdad());
			txtValorLaraEdad.setDisabled(false);
			txtGrupoSuelo_GrpSuelo.setValue(entity.getGrpSuelo().getGrupoSuelo());
			txtGrupoSuelo_GrpSuelo.setDisabled(false);
			txtLaraEdadId.setValue(entity.getLaraEdadId());
			txtLaraEdadId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedLaraEdad = (LaraEdadDTO) (evt.getComponent().getAttributes().get("selectedLaraEdad"));
		txtCompania.setValue(selectedLaraEdad.getCompania());
		txtCompania.setDisabled(false);
		txtEdadFinal.setValue(selectedLaraEdad.getEdadFinal());
		txtEdadFinal.setDisabled(false);
		txtEdadInicial.setValue(selectedLaraEdad.getEdadInicial());
		txtEdadInicial.setDisabled(false);
		txtEstado.setValue(selectedLaraEdad.getEstado());
		txtEstado.setDisabled(false);
		txtFechaCreacion.setValue(selectedLaraEdad.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedLaraEdad.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtInfoAdicional.setValue(selectedLaraEdad.getInfoAdicional());
		txtInfoAdicional.setDisabled(false);
		txtInfoAdicional1.setValue(selectedLaraEdad.getInfoAdicional1());
		txtInfoAdicional1.setDisabled(false);
		txtValorLaraEdad.setValue(selectedLaraEdad.getValorLaraEdad());
		txtValorLaraEdad.setDisabled(false);
		txtGrupoSuelo_GrpSuelo.setValue(selectedLaraEdad.getGrupoSuelo_GrpSuelo());
		txtGrupoSuelo_GrpSuelo.setDisabled(false);
		txtLaraEdadId.setValue(selectedLaraEdad.getLaraEdadId());
		txtLaraEdadId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedLaraEdad == null) && (entity == null)) {
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
			entity = new LaraEdad();

			Long laraEdadId = FacesUtils.checkLong(txtLaraEdadId);

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEdadFinal(FacesUtils.checkDouble(txtEdadFinal));
			entity.setEdadInicial(FacesUtils.checkDouble(txtEdadInicial));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional1(FacesUtils.checkString(txtInfoAdicional1));
			entity.setLaraEdadId(laraEdadId);
			entity.setValorLaraEdad(FacesUtils.checkDouble(txtValorLaraEdad));
			entity.setGrpSuelo((FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo) != null)
					? businessDelegatorView.getGrpSuelo(FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo)) : null);
			businessDelegatorView.saveLaraEdad(entity);
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
				Long laraEdadId = new Long(selectedLaraEdad.getLaraEdadId());
				entity = businessDelegatorView.getLaraEdad(laraEdadId);
			}

			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setEdadFinal(FacesUtils.checkDouble(txtEdadFinal));
			entity.setEdadInicial(FacesUtils.checkDouble(txtEdadInicial));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional1(FacesUtils.checkString(txtInfoAdicional1));
			entity.setValorLaraEdad(FacesUtils.checkDouble(txtValorLaraEdad));
			entity.setGrpSuelo((FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo) != null)
					? businessDelegatorView.getGrpSuelo(FacesUtils.checkLong(txtGrupoSuelo_GrpSuelo)) : null);
			businessDelegatorView.updateLaraEdad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedLaraEdad = (LaraEdadDTO) (evt.getComponent().getAttributes().get("selectedLaraEdad"));

			Long laraEdadId = new Long(selectedLaraEdad.getLaraEdadId());
			entity = businessDelegatorView.getLaraEdad(laraEdadId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long laraEdadId = FacesUtils.checkLong(txtLaraEdadId);
			entity = businessDelegatorView.getLaraEdad(laraEdadId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteLaraEdad(entity);
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
			selectedLaraEdad = (LaraEdadDTO) (evt.getComponent().getAttributes().get("selectedLaraEdad"));

			Long laraEdadId = new Long(selectedLaraEdad.getLaraEdadId());
			entity = businessDelegatorView.getLaraEdad(laraEdadId);
			businessDelegatorView.deleteLaraEdad(entity);
			data.remove(selectedLaraEdad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Double edadFinal, Double edadInicial, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional1, Long laraEdadId,
			Double valorLaraEdad, Long grupoSuelo_GrpSuelo) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEdadFinal(FacesUtils.checkDouble(edadFinal));
			entity.setEdadInicial(FacesUtils.checkDouble(edadInicial));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional1(FacesUtils.checkString(infoAdicional1));
			entity.setValorLaraEdad(FacesUtils.checkDouble(valorLaraEdad));
			businessDelegatorView.updateLaraEdad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("LaraEdadView").requestRender();
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

	public InputText getTxtEdadFinal() {
		return txtEdadFinal;
	}

	public void setTxtEdadFinal(InputText txtEdadFinal) {
		this.txtEdadFinal = txtEdadFinal;
	}

	public InputText getTxtEdadInicial() {
		return txtEdadInicial;
	}

	public void setTxtEdadInicial(InputText txtEdadInicial) {
		this.txtEdadInicial = txtEdadInicial;
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

	public InputText getTxtInfoAdicional1() {
		return txtInfoAdicional1;
	}

	public void setTxtInfoAdicional1(InputText txtInfoAdicional1) {
		this.txtInfoAdicional1 = txtInfoAdicional1;
	}

	public InputText getTxtValorLaraEdad() {
		return txtValorLaraEdad;
	}

	public void setTxtValorLaraEdad(InputText txtValorLaraEdad) {
		this.txtValorLaraEdad = txtValorLaraEdad;
	}

	public InputText getTxtGrupoSuelo_GrpSuelo() {
		return txtGrupoSuelo_GrpSuelo;
	}

	public void setTxtGrupoSuelo_GrpSuelo(InputText txtGrupoSuelo_GrpSuelo) {
		this.txtGrupoSuelo_GrpSuelo = txtGrupoSuelo_GrpSuelo;
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

	public InputText getTxtLaraEdadId() {
		return txtLaraEdadId;
	}

	public void setTxtLaraEdadId(InputText txtLaraEdadId) {
		this.txtLaraEdadId = txtLaraEdadId;
	}

	public List<LaraEdadDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataLaraEdad();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<LaraEdadDTO> laraEdadDTO) {
		this.data = laraEdadDTO;
	}

	public LaraEdadDTO getSelectedLaraEdad() {
		return selectedLaraEdad;
	}

	public void setSelectedLaraEdad(LaraEdadDTO laraEdad) {
		this.selectedLaraEdad = laraEdad;
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
