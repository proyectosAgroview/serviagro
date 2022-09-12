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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.PlanRevisionEquipoActiv;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PlanRevisionEquipoActivView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoActivView.class);
	private InputText txtCodigo;
	private InputText txtNombre;
	private InputText txtSecuencia;
	private Calendar txtDuracion;

	private InputText txtPlanRevisionEquipoId_PlanRevisionEquipo;
	private InputText txtPlanRevisionEquipoActivId;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PlanRevisionEquipoActivDTO> data;
	private PlanRevisionEquipoActivDTO selectedPlanRevisionEquipoActiv;
	private PlanRevisionEquipoActiv entity;
	private boolean showDialog;
	private String moduloActivo;
	private String origendatos;
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public PlanRevisionEquipoActivView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PlanRevisionEquipoActivDTO planRevisionEquipoActivDTO = (PlanRevisionEquipoActivDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(planRevisionEquipoActivDTO.getCodigo());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(planRevisionEquipoActivDTO.getNombre());

			if (txtSecuencia == null) {
				txtSecuencia = new InputText();
			}

			txtSecuencia.setValue(planRevisionEquipoActivDTO.getSecuencia());

			if (txtPlanRevisionEquipoId_PlanRevisionEquipo == null) {
				txtPlanRevisionEquipoId_PlanRevisionEquipo = new InputText();
			}

			txtPlanRevisionEquipoId_PlanRevisionEquipo
					.setValue(planRevisionEquipoActivDTO.getPlanRevisionEquipoId_PlanRevisionEquipo());

			if (txtPlanRevisionEquipoActivId == null) {
				txtPlanRevisionEquipoActivId = new InputText();
			}

			txtPlanRevisionEquipoActivId.setValue(planRevisionEquipoActivDTO.getPlanRevisionEquipoActivId());

			if (txtDuracion == null) {
				txtDuracion = new Calendar();
			}

			txtDuracion.setValue(planRevisionEquipoActivDTO.getDuracion());

			Long planRevisionEquipoActivId = FacesUtils.checkLong(txtPlanRevisionEquipoActivId);
			entity = businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Object contextPath = peticion.getContextPath();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();

			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			origendatos = "Modulo_TallerAgricola";

		} else {

			origendatos = "Modulo_MttoIndustrial";

		}
	}
	
	
	
	public String action_new() {
		action_clear();
		selectedPlanRevisionEquipoActiv = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPlanRevisionEquipoActiv = null;
		moduloSeleccionado();

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtSecuencia != null) {
			txtSecuencia.setValue(null);
			txtSecuencia.setDisabled(true);
		}

		if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null) {
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(null);
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(true);
		}

		if (txtDuracion != null) {
			txtDuracion.setValue(null);
			txtDuracion.setDisabled(true);
		}

		if (txtPlanRevisionEquipoActivId != null) {
			txtPlanRevisionEquipoActivId.setValue(null);
			txtPlanRevisionEquipoActivId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtDuracion() {
		Date inputDate = (Date) txtDuracion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long planRevisionEquipoActivId = FacesUtils.checkLong(txtPlanRevisionEquipoActivId);
			entity = (planRevisionEquipoActivId != null)
					? businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionEquipoActivId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtNombre.setDisabled(false);
			txtSecuencia.setDisabled(false);
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
			txtDuracion.setDisabled(false);
			txtPlanRevisionEquipoActivId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDuracion.setValue(entity.getDuracion());
			txtDuracion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtSecuencia.setValue(entity.getSecuencia());
			txtSecuencia.setDisabled(false);
			txtPlanRevisionEquipoId_PlanRevisionEquipo
					.setValue(entity.getPlanRevisionEquipo().getPlanRevisionEquipoId());
			txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
			txtPlanRevisionEquipoActivId.setValue(entity.getPlanRevisionEquipoActivId());
			txtPlanRevisionEquipoActivId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPlanRevisionEquipoActiv = (PlanRevisionEquipoActivDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionEquipoActiv"));
		txtCodigo.setValue(selectedPlanRevisionEquipoActiv.getCodigo());
		txtCodigo.setDisabled(false);
		txtDuracion.setValue(selectedPlanRevisionEquipoActiv.getDuracion());
		txtDuracion.setDisabled(false);
		txtNombre.setValue(selectedPlanRevisionEquipoActiv.getNombre());
		txtNombre.setDisabled(false);
		txtSecuencia.setValue(selectedPlanRevisionEquipoActiv.getSecuencia());
		txtSecuencia.setDisabled(false);
		txtPlanRevisionEquipoId_PlanRevisionEquipo
				.setValue(selectedPlanRevisionEquipoActiv.getPlanRevisionEquipoId_PlanRevisionEquipo());
		txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
		txtPlanRevisionEquipoActivId.setValue(selectedPlanRevisionEquipoActiv.getPlanRevisionEquipoActivId());
		txtPlanRevisionEquipoActivId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPlanRevisionEquipoActiv == null) && (entity == null)) {
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
			entity = new PlanRevisionEquipoActiv();

			Long planRevisionEquipoActivId = FacesUtils.checkLong(txtPlanRevisionEquipoActivId);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDuracion(FacesUtils.checkDate(txtDuracion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPlanRevisionEquipoActivId(planRevisionEquipoActivId);
			entity.setSecuencia(FacesUtils.checkLong(txtSecuencia));
			entity.setPlanRevisionEquipo(
					(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo) != null) ? businessDelegatorView
							.getPlanRevisionEquipo(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo))
							: null);
			businessDelegatorView.savePlanRevisionEquipoActiv(entity);
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
				Long planRevisionEquipoActivId = new Long(
						selectedPlanRevisionEquipoActiv.getPlanRevisionEquipoActivId());
				entity = businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDuracion(FacesUtils.checkDate(txtDuracion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setSecuencia(FacesUtils.checkLong(txtSecuencia));
			entity.setPlanRevisionEquipo(
					(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo) != null) ? businessDelegatorView
							.getPlanRevisionEquipo(FacesUtils.checkLong(txtPlanRevisionEquipoId_PlanRevisionEquipo))
							: null);
			businessDelegatorView.updatePlanRevisionEquipoActiv(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedPlanRevisionEquipoActiv = (PlanRevisionEquipoActivDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipoActiv"));

			Long planRevisionEquipoActivId = new Long(selectedPlanRevisionEquipoActiv.getPlanRevisionEquipoActivId());
			entity = businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long planRevisionEquipoActivId = FacesUtils.checkLong(txtPlanRevisionEquipoActivId);
			entity = businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deletePlanRevisionEquipoActiv(entity);
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
			selectedPlanRevisionEquipoActiv = (PlanRevisionEquipoActivDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipoActiv"));

			Long planRevisionEquipoActivId = new Long(selectedPlanRevisionEquipoActiv.getPlanRevisionEquipoActivId());
			entity = businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);
			businessDelegatorView.deletePlanRevisionEquipoActiv(entity);
			data.remove(selectedPlanRevisionEquipoActiv);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Date duracion, String nombre, Long planRevisionEquipoActivId,
			Long secuencia, Long planRevisionEquipoId_PlanRevisionEquipo) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDuracion(FacesUtils.checkDate(duracion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setSecuencia(FacesUtils.checkLong(secuencia));
			businessDelegatorView.updatePlanRevisionEquipoActiv(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PlanRevisionEquipoActivView").requestRender();
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtSecuencia() {
		return txtSecuencia;
	}

	public void setTxtSecuencia(InputText txtSecuencia) {
		this.txtSecuencia = txtSecuencia;
	}

	public InputText getTxtPlanRevisionEquipoId_PlanRevisionEquipo() {
		return txtPlanRevisionEquipoId_PlanRevisionEquipo;
	}

	public void setTxtPlanRevisionEquipoId_PlanRevisionEquipo(InputText txtPlanRevisionEquipoId_PlanRevisionEquipo) {
		this.txtPlanRevisionEquipoId_PlanRevisionEquipo = txtPlanRevisionEquipoId_PlanRevisionEquipo;
	}

	public Calendar getTxtDuracion() {
		return txtDuracion;
	}

	public void setTxtDuracion(Calendar txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public InputText getTxtPlanRevisionEquipoActivId() {
		return txtPlanRevisionEquipoActivId;
	}

	public void setTxtPlanRevisionEquipoActivId(InputText txtPlanRevisionEquipoActivId) {
		this.txtPlanRevisionEquipoActivId = txtPlanRevisionEquipoActivId;
	}

	public List<PlanRevisionEquipoActivDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPlanRevisionEquipoActiv();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PlanRevisionEquipoActivDTO> planRevisionEquipoActivDTO) {
		this.data = planRevisionEquipoActivDTO;
	}

	public PlanRevisionEquipoActivDTO getSelectedPlanRevisionEquipoActiv() {
		return selectedPlanRevisionEquipoActiv;
	}

	public void setSelectedPlanRevisionEquipoActiv(PlanRevisionEquipoActivDTO planRevisionEquipoActiv) {
		this.selectedPlanRevisionEquipoActiv = planRevisionEquipoActiv;
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

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String getOrigendatos() {
		return origendatos;
	}

	public void setOrigendatos(String origendatos) {
		this.origendatos = origendatos;
	}
}
