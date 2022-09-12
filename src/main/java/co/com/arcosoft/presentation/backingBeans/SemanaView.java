package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnioFiscal;
import co.com.arcosoft.modelo.Semana;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.SemanaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class SemanaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(SemanaView.class);
	private InputText txtCodigo;
	private SelectOneRadio txtEstado;
	// private InputText txtAnioFiscalId_AnioFiscal;
	// private InputText txtTipDiaId_TipoDia;
	private InputText txtSemanaId;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<SemanaDTO> data;
	private SemanaDTO selectedSemana;
	private Semana entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	// Select Año fiscal
	private SelectOneMenu txtAnioFiscalId_AnioFiscal;
	SelectItem[] selectAnioFiscal;
	private List<AnioFiscal> anioFiscal;

	public SemanaView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedSemana = null;
		setShowDialog(true);
		PrimeFaces.current().resetInputs(":dialogSemana :frm");

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedSemana = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtAnioFiscalId_AnioFiscal != null) {
			txtAnioFiscalId_AnioFiscal.setValue(null);
			txtAnioFiscalId_AnioFiscal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}
		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtSemanaId != null) {
			txtSemanaId.setValue(null);
			txtSemanaId.setDisabled(false);
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

	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Semana> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInSemana(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtAnioFiscalId_AnioFiscal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);

			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);

			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtAnioFiscalId_AnioFiscal.setValue(entity.getAnioFiscal().getAnioFiscalId());
			txtAnioFiscalId_AnioFiscal.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);

			txtSemanaId.setValue(entity.getSemanaId());
			txtSemanaId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedSemana = (SemanaDTO) (evt.getComponent().getAttributes().get("selectedSemana"));
		try {

			String codigo = selectedSemana.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Semana> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInSemana(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtFechaInicial.setValue(entity.getFechaInicial());
				txtFechaInicial.setDisabled(false);
				txtFechaFinal.setValue(entity.getFechaFinal());
				txtFechaFinal.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaModificacion.setValue(selectedSemana.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtAnioFiscalId_AnioFiscal.setValue(entity.getAnioFiscal().getAnioFiscalId());
				txtAnioFiscalId_AnioFiscal.setDisabled(false);
				txtSemanaId.setValue(entity.getSemanaId());
				txtSemanaId.setDisabled(true);
				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedSemana == null) && (entity == null)) {
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

		/*
		 * FacesContext.getCurrentInstance(); fc.addMessage(null, new
		 * FacesMessage("Autenticacion", "Nombre de usuario: "
		 * +login+" Password: "+passWord + " Id "+ user.getUsuarioId()+
		 * " Compania: ") );
		 */

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

	public String action_create() {
		try {
			entity = new Semana();

			// Long calendarId = FacesUtils.checkLong(txtSemanaId);
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			String estado = "A";
			entity.setCompania(compania);
			// entity.setSemanaId(calendarId);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));

			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setAnioFiscal((FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal) != null)
					? businessDelegatorView.getAnioFiscal(FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal)) : null);
			businessDelegatorView.saveSemana(entity);
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
				Long calendarId = new Long(selectedSemana.getSemanaId());
				entity = businessDelegatorView.getSemana(calendarId);
			}
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setAnioFiscal((FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal) != null)
					? businessDelegatorView.getAnioFiscal(FacesUtils.checkLong(txtAnioFiscalId_AnioFiscal)) : null);
			businessDelegatorView.updateSemana(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedSemana = (SemanaDTO) (evt.getComponent().getAttributes().get("selectedSemana"));

			Long calendarId = new Long(selectedSemana.getSemanaId());
			entity = businessDelegatorView.getSemana(calendarId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long calendarId = FacesUtils.checkLong(txtSemanaId);
			entity = businessDelegatorView.getSemana(calendarId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteSemana(entity);
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
			selectedSemana = (SemanaDTO) (evt.getComponent().getAttributes().get("selectedSemana"));

			Long calendarId = new Long(selectedSemana.getSemanaId());
			entity = businessDelegatorView.getSemana(calendarId);
			businessDelegatorView.deleteSemana(entity);
			data.remove(selectedSemana);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long calendarId, String codigo, Date dia, String estado, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, Long anioFiscalId_AnioFiscal,
			Date fechaInicial, Date fechaFinal, Long tipDiaId_TipoDia) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));

			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			businessDelegatorView.updateSemana(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("SemanaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneMenu getTxtAnioFiscalId_AnioFiscal() {
		return txtAnioFiscalId_AnioFiscal;
	}

	public void setTxtAnioFiscalId_AnioFiscal(SelectOneMenu txtAnioFiscalId_AnioFiscal) {
		this.txtAnioFiscalId_AnioFiscal = txtAnioFiscalId_AnioFiscal;
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

	public InputText getTxtSemanaId() {
		return txtSemanaId;
	}

	public void setTxtSemanaId(InputText txtSemanaId) {
		this.txtSemanaId = txtSemanaId;
	}

	public List<SemanaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataSemana();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<SemanaDTO> semanaDTO) {
		this.data = semanaDTO;
	}

	public SemanaDTO getSelectedSemana() {
		return selectedSemana;
	}

	public void setSelectedSemana(SemanaDTO semana) {
		this.selectedSemana = semana;
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

	public SelectItem[] getSelectAnioFiscal() {

		if (anioFiscal == null || anioFiscal.size() == 0) {

			anioFiscal = new ArrayList<AnioFiscal>();

			try {

				anioFiscal = businessDelegatorView.getAnioFiscal(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<AnioFiscal> lista = businessDelegatorView.findByCriteriaInAnioFiscal(condicion, null, null);
				selectAnioFiscal = new SelectItem[lista.size()];

				int i = 0;
				for (AnioFiscal anioFiscal : lista) {
					selectAnioFiscal[i] = new SelectItem(anioFiscal.getAnioFiscalId(), anioFiscal.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAnioFiscal;
	}

	public void setSelectAnioFiscal(SelectItem[] selectAnioFiscal) {
		this.selectAnioFiscal = selectAnioFiscal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

}
