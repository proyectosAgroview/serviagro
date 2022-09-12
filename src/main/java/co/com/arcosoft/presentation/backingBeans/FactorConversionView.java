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
import co.com.arcosoft.modelo.FactorConversion;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.FactorConversionDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class FactorConversionView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FactorConversionView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputText txtFactorConversion;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	// private SelectOneMenu txtUdadMedByUnadMedOrigenId;
	// private SelectOneMenu txtUdadMedByUndadMedDestId;
	private InputText txtFactorConversionId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FactorConversionDTO> data;
	private FactorConversionDTO selectedFactorConversion;
	private FactorConversion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtUdadMedByUnadMedOrigenId;
	SelectItem[] selectUdadMedOrigen;
	private List<UdadMed> udadMedOrigen;

	private SelectOneMenu txtUdadMedByUndadMedDestId;
	SelectItem[] selectUdadMedDest;
	private List<UdadMed> udadMedDest;

	public FactorConversionView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FactorConversionDTO factorConversionDTO = (FactorConversionDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(factorConversionDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(factorConversionDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(factorConversionDTO.getEstado());

			if (txtFactorConversion == null) {
				txtFactorConversion = new InputText();
			}

			txtFactorConversion.setValue(factorConversionDTO.getFactorConversion());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(factorConversionDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(factorConversionDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(factorConversionDTO.getNombre());

			if (txtUdadMedByUnadMedOrigenId == null) {
				txtUdadMedByUnadMedOrigenId = new SelectOneMenu();
			}

			txtUdadMedByUnadMedOrigenId.setValue(factorConversionDTO.getUdadMedByUnadMedOrigenId());

			if (txtUdadMedByUndadMedDestId == null) {
				txtUdadMedByUndadMedDestId = new SelectOneMenu();
			}

			txtUdadMedByUndadMedDestId.setValue(factorConversionDTO.getUdadMedByUndadMedDestId());

			if (txtFactorConversionId == null) {
				txtFactorConversionId = new InputText();
			}

			txtFactorConversionId.setValue(factorConversionDTO.getFactorConversionId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(factorConversionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(factorConversionDTO.getFechaModificacion());

			Long factorConversionId = FacesUtils.checkLong(txtFactorConversionId);
			entity = businessDelegatorView.getFactorConversion(factorConversionId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFactorConversion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFactorConversion = null;
		PrimeFaces.current().resetInputs(":dialogFactorConversion :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFactorConversion != null) {
			txtFactorConversion.setValue(null);
			txtFactorConversion.setDisabled(true);
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

		if (txtUdadMedByUnadMedOrigenId != null) {
			txtUdadMedByUnadMedOrigenId.setValue(null);
			txtUdadMedByUnadMedOrigenId.setDisabled(true);
		}

		if (txtUdadMedByUndadMedDestId != null) {
			txtUdadMedByUndadMedDestId.setValue(null);
			txtUdadMedByUndadMedDestId.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFactorConversionId != null) {
			txtFactorConversionId.setValue(null);
			txtFactorConversionId.setDisabled(false);
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
			Long factorConversionId = FacesUtils.checkLong(txtFactorConversionId);
			entity = (factorConversionId != null) ? businessDelegatorView.getFactorConversion(factorConversionId)
					: null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtFactorConversion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtUdadMedByUnadMedOrigenId.setDisabled(false);
			txtUdadMedByUndadMedDestId.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFactorConversionId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFactorConversion.setValue(entity.getFactorConversion());
			txtFactorConversion.setDisabled(false);
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
			txtUdadMedByUnadMedOrigenId.setValue(entity.getUdadMedByUnadMedOrigenId().getUdadMedId());
			txtUdadMedByUnadMedOrigenId.setDisabled(false);
			txtUdadMedByUndadMedDestId.setValue(entity.getUdadMedByUndadMedDestId().getUdadMedId());
			txtUdadMedByUndadMedDestId.setDisabled(false);
			txtFactorConversionId.setValue(entity.getFactorConversionId());
			txtFactorConversionId.setDisabled(true);
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
			List<FactorConversion> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFactorConversion(condicion, null, null) : null;

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
			txtFactorConversion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtUdadMedByUnadMedOrigenId.setDisabled(false);
			txtUdadMedByUndadMedDestId.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtFactorConversionId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFactorConversion.setValue(entity.getFactorConversion());
			txtFactorConversion.setDisabled(false);
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
			txtUdadMedByUnadMedOrigenId.setValue(entity.getUdadMedByUnadMedOrigenId().getUdadMedId());
			txtUdadMedByUnadMedOrigenId.setDisabled(false);
			txtUdadMedByUndadMedDestId.setValue(entity.getUdadMedByUndadMedDestId().getUdadMedId());
			txtUdadMedByUndadMedDestId.setDisabled(false);
			txtFactorConversionId.setValue(entity.getFactorConversionId());
			txtFactorConversionId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFactorConversion = (FactorConversionDTO) (evt.getComponent().getAttributes()
				.get("selectedFactorConversion"));
		try {

			String codigo = selectedFactorConversion.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<FactorConversion> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFactorConversion(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtFactorConversion.setValue(entity.getFactorConversion());
				txtFactorConversion.setDisabled(false);
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
				txtUdadMedByUnadMedOrigenId.setValue(selectedFactorConversion.getUdadMedByUnadMedOrigenId());
				txtUdadMedByUnadMedOrigenId.setDisabled(false);
				txtUdadMedByUndadMedDestId.setValue(selectedFactorConversion.getUdadMedByUndadMedDestId());
				txtUdadMedByUndadMedDestId.setDisabled(false);
				txtFactorConversionId.setValue(entity.getFactorConversionId());
				txtFactorConversionId.setDisabled(true);
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
			if ((selectedFactorConversion == null) && (entity == null)) {
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

	public String getUsuarioIdSession() throws Exception {

		String usuarioId = null;

		Object[] condicion = { "login", true, getLoginSession(), "=" };
		List<Usuarios> u = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);

		if (u != null) {
			for (Usuarios usuarios : u) {
				usuarioId = usuarios.getUsuarioId().toString();
			}
		}

		return usuarioId;
	}

	public String action_create() {
		try {
			entity = new FactorConversion();

			// Long factorConversionId = FacesUtils
			// .checkLong(txtFactorConversionId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFactorConversion(FacesUtils.checkDouble(txtFactorConversion));
			// entity.setFactorConversionId(factorConversionId);
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUdadMedByUnadMedOrigenId((FacesUtils.checkLong(txtUdadMedByUnadMedOrigenId) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedByUnadMedOrigenId)) : null);
			entity.setUdadMedByUndadMedDestId((FacesUtils.checkLong(txtUdadMedByUndadMedDestId) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedByUndadMedDestId)) : null);
			businessDelegatorView.saveFactorConversion(entity);
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
				Long factorConversionId = new Long(selectedFactorConversion.getFactorConversionId());
				entity = businessDelegatorView.getFactorConversion(factorConversionId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFactorConversion(FacesUtils.checkDouble(txtFactorConversion));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUdadMedByUnadMedOrigenId((FacesUtils.checkLong(txtUdadMedByUnadMedOrigenId) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedByUnadMedOrigenId)) : null);
			entity.setUdadMedByUndadMedDestId((FacesUtils.checkLong(txtUdadMedByUndadMedDestId) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedByUndadMedDestId)) : null);
			businessDelegatorView.updateFactorConversion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedFactorConversion = (FactorConversionDTO) (evt.getComponent().getAttributes()
					.get("selectedFactorConversion"));

			Long factorConversionId = new Long(selectedFactorConversion.getFactorConversionId());
			entity = businessDelegatorView.getFactorConversion(factorConversionId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long factorConversionId = FacesUtils.checkLong(txtFactorConversionId);
			entity = businessDelegatorView.getFactorConversion(factorConversionId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteFactorConversion(entity);
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
			selectedFactorConversion = (FactorConversionDTO) (evt.getComponent().getAttributes()
					.get("selectedFactorConversion"));

			Long factorConversionId = new Long(selectedFactorConversion.getFactorConversionId());
			entity = businessDelegatorView.getFactorConversion(factorConversionId);
			businessDelegatorView.deleteFactorConversion(entity);
			data.remove(selectedFactorConversion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Double factorConversion,
			Long factorConversionId, Date fechaCreacion, Date fechaModificacion, String infoAdicional,
			String infoAdicional2, String nombre, Long udadMedId_UdadMed, Long udadMedId_UdadMed0) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFactorConversion(FacesUtils.checkDouble(factorConversion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateFactorConversion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FactorConversionView").requestRender();
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

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtFactorConversion() {
		return txtFactorConversion;
	}

	public void setTxtFactorConversion(InputText txtFactorConversion) {
		this.txtFactorConversion = txtFactorConversion;
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

	public SelectOneMenu getTxtUdadMedByUnadMedOrigenId() {
		return txtUdadMedByUnadMedOrigenId;
	}

	public void setTxtUdadMedByUnadMedOrigenId(SelectOneMenu txtUdadMedByUnadMedOrigenId) {
		this.txtUdadMedByUnadMedOrigenId = txtUdadMedByUnadMedOrigenId;
	}

	public SelectOneMenu getTxtUdadMedByUndadMedDestId() {
		return txtUdadMedByUndadMedDestId;
	}

	public void setTxtUdadMedByUndadMedDestId(SelectOneMenu txtUdadMedByUndadMedDestId) {
		this.txtUdadMedByUndadMedDestId = txtUdadMedByUndadMedDestId;
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

	public InputText getTxtFactorConversionId() {
		return txtFactorConversionId;
	}

	public void setTxtFactorConversionId(InputText txtFactorConversionId) {
		this.txtFactorConversionId = txtFactorConversionId;
	}

	public List<FactorConversionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFactorConversion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FactorConversionDTO> factorConversionDTO) {
		this.data = factorConversionDTO;
	}

	public FactorConversionDTO getSelectedFactorConversion() {
		return selectedFactorConversion;
	}

	public void setSelectedFactorConversion(FactorConversionDTO factorConversion) {
		this.selectedFactorConversion = factorConversion;
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

	public SelectItem[] getSelectUdadMedDest() {

		if (udadMedDest == null || udadMedDest.size() == 0) {

			udadMedDest = new ArrayList<UdadMed>();

			try {

				udadMedDest = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedDest = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedDest : lista) {
					selectUdadMedDest[i] = new SelectItem(udadMedDest.getUdadMedId(), udadMedDest.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedDest;
	}

	public void setSelectUdadMedDest(SelectItem[] SelectUdadMedDest) {
		this.selectUdadMedDest = SelectUdadMedDest;
	}

	public SelectItem[] getSelectUdadMedOrigen() {

		if (udadMedOrigen == null || udadMedOrigen.size() == 0) {

			udadMedOrigen = new ArrayList<UdadMed>();

			try {

				udadMedOrigen = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedOrigen = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedOrigen : lista) {
					selectUdadMedOrigen[i] = new SelectItem(udadMedOrigen.getUdadMedId(), udadMedOrigen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedOrigen;
	}

	public void setSelectUdadMedOrigen(SelectItem[] SelectUdadMedOrigen) {
		this.selectUdadMedOrigen = SelectUdadMedOrigen;
	}

}
