package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.FlotaTransporte;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.FlotaTransporteDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class FlotaTransporteView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FlotaTransporteView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtKmhAsfalto;
	private InputText txtKmhTerraceria;
	private InputText txtNombre;
	private InputText txtVelocidadMaxima;
	private InputText txtVelocidadMinima;
	private InputText txtFlotaTranspId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<FlotaTransporteDTO> data;
	private FlotaTransporteDTO selectedFlotaTransporte;
	private FlotaTransporte entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public FlotaTransporteView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FlotaTransporteDTO flotaTransporteDTO = (FlotaTransporteDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(flotaTransporteDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(flotaTransporteDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(flotaTransporteDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(flotaTransporteDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(flotaTransporteDTO.getInfoAdicional2());

			if (txtKmhAsfalto == null) {
				txtKmhAsfalto = new InputText();
			}

			txtKmhAsfalto.setValue(flotaTransporteDTO.getKmhAsfalto());

			if (txtKmhTerraceria == null) {
				txtKmhTerraceria = new InputText();
			}

			txtKmhTerraceria.setValue(flotaTransporteDTO.getKmhTerraceria());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(flotaTransporteDTO.getNombre());

			if (txtVelocidadMaxima == null) {
				txtVelocidadMaxima = new InputText();
			}

			txtVelocidadMaxima.setValue(flotaTransporteDTO.getVelocidadMaxima());

			if (txtVelocidadMinima == null) {
				txtVelocidadMinima = new InputText();
			}

			txtVelocidadMinima.setValue(flotaTransporteDTO.getVelocidadMinima());

			if (txtFlotaTranspId == null) {
				txtFlotaTranspId = new InputText();
			}

			txtFlotaTranspId.setValue(flotaTransporteDTO.getFlotaTranspId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(flotaTransporteDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(flotaTransporteDTO.getFechaModificacion());

			Long flotaTranspId = FacesUtils.checkLong(txtFlotaTranspId);
			entity = businessDelegatorView.getFlotaTransporte(flotaTranspId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFlotaTransporte = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFlotaTransporte = null;
		PrimeFaces.current().resetInputs(":dialogFlotaTransporte :frm");

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

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtKmhAsfalto != null) {
			txtKmhAsfalto.setValue(null);
			txtKmhAsfalto.setDisabled(true);
		}

		if (txtKmhTerraceria != null) {
			txtKmhTerraceria.setValue(null);
			txtKmhTerraceria.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtVelocidadMaxima != null) {
			txtVelocidadMaxima.setValue(null);
			txtVelocidadMaxima.setDisabled(true);
		}

		if (txtVelocidadMinima != null) {
			txtVelocidadMinima.setValue(null);
			txtVelocidadMinima.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFlotaTranspId != null) {
			txtFlotaTranspId.setValue(null);
			txtFlotaTranspId.setDisabled(false);
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
			Long flotaTranspId = FacesUtils.checkLong(txtFlotaTranspId);
			entity = (flotaTranspId != null) ? businessDelegatorView.getFlotaTransporte(flotaTranspId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtKmhAsfalto.setDisabled(false);
			txtKmhTerraceria.setDisabled(false);
			txtNombre.setDisabled(false);
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadMinima.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFlotaTranspId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
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
			txtKmhAsfalto.setValue(entity.getKmhAsfalto());
			txtKmhAsfalto.setDisabled(false);
			txtKmhTerraceria.setValue(entity.getKmhTerraceria());
			txtKmhTerraceria.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtVelocidadMaxima.setValue(entity.getVelocidadMaxima());
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadMinima.setValue(entity.getVelocidadMinima());
			txtVelocidadMinima.setDisabled(false);
			txtFlotaTranspId.setValue(entity.getFlotaTranspId());
			txtFlotaTranspId.setDisabled(true);
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
			List<FlotaTransporte> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFlotaTransporte(condicion, null, null) : null;

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
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtKmhAsfalto.setDisabled(false);
			txtKmhTerraceria.setDisabled(false);
			txtNombre.setDisabled(false);
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadMinima.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtFlotaTranspId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
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
			txtKmhAsfalto.setValue(entity.getKmhAsfalto());
			txtKmhAsfalto.setDisabled(false);
			txtKmhTerraceria.setValue(entity.getKmhTerraceria());
			txtKmhTerraceria.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtVelocidadMaxima.setValue(entity.getVelocidadMaxima());
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadMinima.setValue(entity.getVelocidadMinima());
			txtVelocidadMinima.setDisabled(false);
			txtFlotaTranspId.setValue(entity.getFlotaTranspId());
			txtFlotaTranspId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFlotaTransporte = (FlotaTransporteDTO) (evt.getComponent().getAttributes()
				.get("selectedFlotaTransporte"));
		try {

			String codigo = selectedFlotaTransporte.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<FlotaTransporte> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInFlotaTransporte(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
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
				txtKmhAsfalto.setValue(entity.getKmhAsfalto());
				txtKmhAsfalto.setDisabled(false);
				txtKmhTerraceria.setValue(entity.getKmhTerraceria());
				txtKmhTerraceria.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtVelocidadMaxima.setValue(entity.getVelocidadMaxima());
				txtVelocidadMaxima.setDisabled(false);
				txtVelocidadMinima.setValue(entity.getVelocidadMinima());
				txtVelocidadMinima.setDisabled(false);
				txtFlotaTranspId.setValue(entity.getFlotaTranspId());
				txtFlotaTranspId.setDisabled(true);
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
			if ((selectedFlotaTransporte == null) && (entity == null)) {
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
			entity = new FlotaTransporte();
			Date date = new Date();
			// Long flotaTranspId = FacesUtils.checkLong(txtFlotaTranspId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			// entity.setFlotaTranspId(flotaTranspId);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setKmhAsfalto(FacesUtils.checkDouble(txtKmhAsfalto));
			entity.setKmhTerraceria(FacesUtils.checkDouble(txtKmhTerraceria));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setVelocidadMaxima(FacesUtils.checkDouble(txtVelocidadMaxima));
			entity.setVelocidadMinima(FacesUtils.checkDouble(txtVelocidadMinima));
			businessDelegatorView.saveFlotaTransporte(entity);
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
				Long flotaTranspId = new Long(selectedFlotaTransporte.getFlotaTranspId());
				entity = businessDelegatorView.getFlotaTransporte(flotaTranspId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setKmhAsfalto(FacesUtils.checkDouble(txtKmhAsfalto));
			entity.setKmhTerraceria(FacesUtils.checkDouble(txtKmhTerraceria));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setVelocidadMaxima(FacesUtils.checkDouble(txtVelocidadMaxima));
			entity.setVelocidadMinima(FacesUtils.checkDouble(txtVelocidadMinima));
			businessDelegatorView.updateFlotaTransporte(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedFlotaTransporte = (FlotaTransporteDTO) (evt.getComponent().getAttributes()
					.get("selectedFlotaTransporte"));

			Long flotaTranspId = new Long(selectedFlotaTransporte.getFlotaTranspId());
			entity = businessDelegatorView.getFlotaTransporte(flotaTranspId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long flotaTranspId = FacesUtils.checkLong(txtFlotaTranspId);
			entity = businessDelegatorView.getFlotaTransporte(flotaTranspId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteFlotaTransporte(entity);
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
			selectedFlotaTransporte = (FlotaTransporteDTO) (evt.getComponent().getAttributes()
					.get("selectedFlotaTransporte"));

			Long flotaTranspId = new Long(selectedFlotaTransporte.getFlotaTranspId());
			entity = businessDelegatorView.getFlotaTransporte(flotaTranspId);
			businessDelegatorView.deleteFlotaTransporte(entity);
			((Map<String, Object>) data).remove(selectedFlotaTransporte);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, Long flotaTranspId, String infoAdicional, String infoAdicional2, Double kmhAsfalto,
			Double kmhTerraceria, String nombre, Double velocidadMaxima, Double velocidadMinima) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setKmhAsfalto(FacesUtils.checkDouble(kmhAsfalto));
			entity.setKmhTerraceria(FacesUtils.checkDouble(kmhTerraceria));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setVelocidadMaxima(FacesUtils.checkDouble(velocidadMaxima));
			entity.setVelocidadMinima(FacesUtils.checkDouble(velocidadMinima));
			businessDelegatorView.updateFlotaTransporte(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FlotaTransporteView").requestRender();
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

	public InputText getTxtKmhAsfalto() {
		return txtKmhAsfalto;
	}

	public void setTxtKmhAsfalto(InputText txtKmhAsfalto) {
		this.txtKmhAsfalto = txtKmhAsfalto;
	}

	public InputText getTxtKmhTerraceria() {
		return txtKmhTerraceria;
	}

	public void setTxtKmhTerraceria(InputText txtKmhTerraceria) {
		this.txtKmhTerraceria = txtKmhTerraceria;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtVelocidadMaxima() {
		return txtVelocidadMaxima;
	}

	public void setTxtVelocidadMaxima(InputText txtVelocidadMaxima) {
		this.txtVelocidadMaxima = txtVelocidadMaxima;
	}

	public InputText getTxtVelocidadMinima() {
		return txtVelocidadMinima;
	}

	public void setTxtVelocidadMinima(InputText txtVelocidadMinima) {
		this.txtVelocidadMinima = txtVelocidadMinima;
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

	public InputText getTxtFlotaTranspId() {
		return txtFlotaTranspId;
	}

	public void setTxtFlotaTranspId(InputText txtFlotaTranspId) {
		this.txtFlotaTranspId = txtFlotaTranspId;
	}

	public LazyDataModel<FlotaTransporteDTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataFlotaTransporte();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<FlotaTransporteDTO> flotaTransporteDTO) {
		this.data = flotaTransporteDTO;
	}

	public FlotaTransporteDTO getSelectedFlotaTransporte() {
		return selectedFlotaTransporte;
	}

	public void setSelectedFlotaTransporte(FlotaTransporteDTO flotaTransporte) {
		this.selectedFlotaTransporte = flotaTransporte;
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

	private class LocalDataModelDTO extends LazyDataModel<FlotaTransporteDTO> {
		private static final long serialVersionUID = 1L;
		private List<FlotaTransporteDTO> flotaTransporteDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<FlotaTransporteDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				flotaTransporteDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberFlotaTransporte(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return flotaTransporteDTO;

		}

		@Override
		public FlotaTransporteDTO getRowData(String rowKey) {
			for (FlotaTransporteDTO flotaTransporteDTOtmp : flotaTransporteDTO) {
				if (flotaTransporteDTOtmp.getFlotaTranspId().toString().equals(rowKey))
					return flotaTransporteDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(FlotaTransporteDTO flotaTransporteDTOtmp) {
			return flotaTransporteDTOtmp.getFlotaTranspId();
		}

	}

	private List<FlotaTransporteDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageFlotaTransporte(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
