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
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.FaseFenologica;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.FaseFenologicaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class FaseFenologicaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FaseFenologicaView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtEdadFinal;
	private InputText txtEdadInicial;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtFaseFenoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FaseFenologicaDTO> data;
	private FaseFenologicaDTO selectedFaseFenologica;
	private FaseFenologica entity;
	private boolean showDialog;

	// Select cultivios
	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivos;
	private List<Cultivo> cultivos;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public FaseFenologicaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FaseFenologicaDTO faseFenologicaDTO = (FaseFenologicaDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(faseFenologicaDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(faseFenologicaDTO.getCompania());

			if (txtEdadFinal == null) {
				txtEdadFinal = new InputText();
			}

			txtEdadFinal.setValue(faseFenologicaDTO.getEdadFinal());

			if (txtEdadInicial == null) {
				txtEdadInicial = new InputText();
			}

			txtEdadInicial.setValue(faseFenologicaDTO.getEdadInicial());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(faseFenologicaDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(faseFenologicaDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(faseFenologicaDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(faseFenologicaDTO.getNombre());

			if (txtCultivoId_Cultivo == null) {
				txtCultivoId_Cultivo = new SelectOneMenu();
			}

			txtCultivoId_Cultivo.setValue(faseFenologicaDTO.getCultivoId_Cultivo());

			if (txtFaseFenoId == null) {
				txtFaseFenoId = new InputText();
			}

			txtFaseFenoId.setValue(faseFenologicaDTO.getFaseFenoId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(faseFenologicaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(faseFenologicaDTO.getFechaModificacion());

			Long faseFenoId = FacesUtils.checkLong(txtFaseFenoId);
			entity = businessDelegatorView.getFaseFenologica(faseFenoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFaseFenologica = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFaseFenologica = null;
		PrimeFaces.current().resetInputs(":dialogFaseFenologica :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

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

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
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

		if (txtFaseFenoId != null) {
			txtFaseFenoId.setValue(null);
			txtFaseFenoId.setDisabled(false);
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
			Long faseFenoId = FacesUtils.checkLong(txtFaseFenoId);
			entity = (faseFenoId != null) ? businessDelegatorView.getFaseFenologica(faseFenoId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEdadFinal.setDisabled(false);
			txtEdadInicial.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtCultivoId_Cultivo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFaseFenoId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
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
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			txtFaseFenoId.setValue(entity.getFaseFenoId());
			txtFaseFenoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<FaseFenologica> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFaseFenologica(condicion, null, null) : null;

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
			txtEdadFinal.setDisabled(false);
			txtEdadInicial.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtCultivoId_Cultivo.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtFaseFenoId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEdadFinal.setValue(entity.getEdadFinal());
			txtEdadFinal.setDisabled(false);
			txtEdadInicial.setValue(entity.getEdadInicial());
			txtEdadInicial.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			txtFaseFenoId.setValue(entity.getFaseFenoId());
			txtFaseFenoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFaseFenologica = (FaseFenologicaDTO) (evt.getComponent().getAttributes().get("selectedFaseFenologica"));
		try {

			String codigo = selectedFaseFenologica.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<FaseFenologica> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFaseFenologica(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtEdadFinal.setValue(entity.getEdadFinal());
				txtEdadFinal.setDisabled(false);
				txtEdadInicial.setValue(entity.getEdadInicial());
				txtEdadInicial.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(entity.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(entity.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtCultivoId_Cultivo.setValue(selectedFaseFenologica.getCultivoId_Cultivo());
				txtCultivoId_Cultivo.setDisabled(false);
				txtFaseFenoId.setValue(entity.getFaseFenoId());
				txtFaseFenoId.setDisabled(true);
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
			if ((selectedFaseFenologica == null) && (entity == null)) {
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
			entity = new FaseFenologica();
			Long compania = new Long(getCompaniaIdSession());

			// Long faseFenoId = FacesUtils.checkLong(txtFaseFenoId);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEdadFinal(FacesUtils.checkLong(txtEdadFinal));
			entity.setEdadInicial(FacesUtils.checkLong(txtEdadInicial));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFaseFenoId(faseFenoId);
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setCultivo((FacesUtils.checkLong(txtCultivoId_Cultivo) != null)
					? businessDelegatorView.getCultivo(FacesUtils.checkLong(txtCultivoId_Cultivo)) : null);
			businessDelegatorView.saveFaseFenologica(entity);
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
				Long faseFenoId = new Long(selectedFaseFenologica.getFaseFenoId());
				entity = businessDelegatorView.getFaseFenologica(faseFenoId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEdadFinal(FacesUtils.checkLong(txtEdadFinal));
			entity.setEdadInicial(FacesUtils.checkLong(txtEdadInicial));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// /
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setCultivo((FacesUtils.checkLong(txtCultivoId_Cultivo) != null)
					? businessDelegatorView.getCultivo(FacesUtils.checkLong(txtCultivoId_Cultivo)) : null);
			businessDelegatorView.updateFaseFenologica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedFaseFenologica = (FaseFenologicaDTO) (evt.getComponent().getAttributes()
					.get("selectedFaseFenologica"));

			Long faseFenoId = new Long(selectedFaseFenologica.getFaseFenoId());
			entity = businessDelegatorView.getFaseFenologica(faseFenoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long faseFenoId = FacesUtils.checkLong(txtFaseFenoId);
			entity = businessDelegatorView.getFaseFenologica(faseFenoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteFaseFenologica(entity);
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
			selectedFaseFenologica = (FaseFenologicaDTO) (evt.getComponent().getAttributes()
					.get("selectedFaseFenologica"));

			Long faseFenoId = new Long(selectedFaseFenologica.getFaseFenoId());
			entity = businessDelegatorView.getFaseFenologica(faseFenoId);
			businessDelegatorView.deleteFaseFenologica(entity);
			data.remove(selectedFaseFenologica);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, Long edadFinal, Long edadInicial, String estado,
			Long faseFenoId, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2,
			String nombre, Long cultivoId_Cultivo) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEdadFinal(FacesUtils.checkLong(edadFinal));
			entity.setEdadInicial(FacesUtils.checkLong(edadInicial));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateFaseFenologica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FaseFenologicaView").requestRender();
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

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public SelectOneMenu getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(SelectOneMenu txtCultivoId_Cultivo) {
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

	public InputText getTxtFaseFenoId() {
		return txtFaseFenoId;
	}

	public void setTxtFaseFenoId(InputText txtFaseFenoId) {
		this.txtFaseFenoId = txtFaseFenoId;
	}

	public List<FaseFenologicaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFaseFenologica();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FaseFenologicaDTO> faseFenologicaDTO) {
		this.data = faseFenologicaDTO;
	}

	public FaseFenologicaDTO getSelectedFaseFenologica() {
		return selectedFaseFenologica;
	}

	public void setSelectedFaseFenologica(FaseFenologicaDTO faseFenologica) {
		this.selectedFaseFenologica = faseFenologica;
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

	public SelectItem[] getSelectCultivos() {
		if (cultivos == null || cultivos.size() == 0) {

			cultivos = new ArrayList<Cultivo>();

			try {

				cultivos = businessDelegatorView.getCultivo(); // Fin by
																// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Cultivo> lista = businessDelegatorView.findByCriteriaInCultivo(condicion, null, null);
				selectCultivos = new SelectItem[lista.size()];

				int i = 0;
				for (Cultivo cul : lista) {
					selectCultivos[i] = new SelectItem(cul.getCultivoId(), cul.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCultivos;
	}

	public void setSelectCultivos(SelectItem[] selectCultivos) {
		this.selectCultivos = selectCultivos;
	}

}
