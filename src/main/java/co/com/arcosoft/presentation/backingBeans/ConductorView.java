package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.ServletContext;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Conductor;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.ConductorDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ConductorView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ConductorView.class);
	private InputText txtNIdentidad;
	private InputText txtNLicencia;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputText txtFoto;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtPrimerApellido;
	private InputText txtPrimerNombre;
	private InputText txtSegundoApellido;
	private InputText txtSegundoNombre;
	private InputMask txtTelefono;
	// private InputText txtCiudadId_CiudadExpId;
	// private InputText txtCiudadId_CiudadExpLic;
	private InputText txtConductorId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ConductorDTO> data;
	private ConductorDTO selectedConductor;
	private Conductor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtCiudadId_CiudadExpId;
	SelectItem[] selectCiudadExpId;
	private List<Ciudad> ciudadExpId;

	private SelectOneMenu txtCiudadId_CiudadExpLic;
	SelectItem[] selectCiudadExpLic;
	private List<Ciudad> ciudadExpLic;

	private String txtImagenConductor;
	private String imagenConductor;
	private UploadedFile file;

	public ConductorView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ConductorDTO conductorDTO = (ConductorDTO) e.getObject();

			if (txtNIdentidad == null) {
				txtNIdentidad = new InputText();
			}

			txtNIdentidad.setValue(conductorDTO.getNIdentidad());

			if (txtNLicencia == null) {
				txtNLicencia = new InputText();
			}

			txtNLicencia.setValue(conductorDTO.getNLicencia());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(conductorDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(conductorDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(conductorDTO.getEstado());

			if (txtFoto == null) {
				txtFoto = new InputText();
			}

			txtFoto.setValue(conductorDTO.getFoto());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(conductorDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(conductorDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(conductorDTO.getNombre());

			if (txtPrimerApellido == null) {
				txtPrimerApellido = new InputText();
			}

			txtPrimerApellido.setValue(conductorDTO.getPrimerApellido());

			if (txtPrimerNombre == null) {
				txtPrimerNombre = new InputText();
			}

			txtPrimerNombre.setValue(conductorDTO.getPrimerNombre());

			if (txtSegundoApellido == null) {
				txtSegundoApellido = new InputText();
			}

			txtSegundoApellido.setValue(conductorDTO.getSegundoApellido());

			if (txtSegundoNombre == null) {
				txtSegundoNombre = new InputText();
			}

			txtSegundoNombre.setValue(conductorDTO.getSegundoNombre());

			if (txtTelefono == null) {
				txtTelefono = new InputMask();
			}

			txtTelefono.setValue(conductorDTO.getTelefono());

			if (txtCiudadId_CiudadExpId == null) {
				txtCiudadId_CiudadExpId = new SelectOneMenu();
			}

			txtCiudadId_CiudadExpId.setValue(conductorDTO.getCiudadId_Ciudad());

			if (txtCiudadId_CiudadExpLic == null) {
				txtCiudadId_CiudadExpLic = new SelectOneMenu();
			}

			txtCiudadId_CiudadExpLic.setValue(conductorDTO.getCiudadId_Ciudad1());

			if (txtConductorId == null) {
				txtConductorId = new InputText();
			}

			txtConductorId.setValue(conductorDTO.getConductorId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(conductorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(conductorDTO.getFechaModificacion());

			Long conductorId = FacesUtils.checkLong(txtConductorId);
			entity = businessDelegatorView.getConductor(conductorId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedConductor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedConductor = null;
		PrimeFaces.current().resetInputs(":dialogConductor :frm");

		if (txtNIdentidad != null) {
			txtNIdentidad.setValue(null);
			txtNIdentidad.setDisabled(true);
		}

		if (txtNLicencia != null) {
			txtNLicencia.setValue(null);
			txtNLicencia.setDisabled(true);
		}

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

		if (txtFoto != null) {
			txtFoto.setValue(null);
			txtFoto.setDisabled(true);
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

		if (txtPrimerApellido != null) {
			txtPrimerApellido.setValue(null);
			txtPrimerApellido.setDisabled(true);
		}

		if (txtPrimerNombre != null) {
			txtPrimerNombre.setValue(null);
			txtPrimerNombre.setDisabled(true);
		}

		if (txtSegundoApellido != null) {
			txtSegundoApellido.setValue(null);
			txtSegundoApellido.setDisabled(true);
		}

		if (txtSegundoNombre != null) {
			txtSegundoNombre.setValue(null);
			txtSegundoNombre.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtCiudadId_CiudadExpId != null) {
			txtCiudadId_CiudadExpId.setValue(null);
			txtCiudadId_CiudadExpId.setDisabled(true);
		}

		if (txtCiudadId_CiudadExpLic != null) {
			txtCiudadId_CiudadExpLic.setValue(null);
			txtCiudadId_CiudadExpLic.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtConductorId != null) {
			txtConductorId.setValue(null);
			txtConductorId.setDisabled(false);
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
			Long conductorId = FacesUtils.checkLong(txtConductorId);
			entity = (conductorId != null) ? businessDelegatorView.getConductor(conductorId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtNIdentidad.setDisabled(false);
			txtNLicencia.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtFoto.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPrimerApellido.setDisabled(false);
			txtPrimerNombre.setDisabled(false);
			txtSegundoApellido.setDisabled(false);
			txtSegundoNombre.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtCiudadId_CiudadExpId.setDisabled(false);
			txtCiudadId_CiudadExpLic.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtConductorId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtNIdentidad.setValue(entity.getNIdentidad());
			txtNIdentidad.setDisabled(false);
			txtNLicencia.setValue(entity.getNLicencia());
			txtNLicencia.setDisabled(false);
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
			txtFoto.setValue(entity.getFoto());
			txtFoto.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtPrimerApellido.setValue(entity.getPrimerApellido());
			txtPrimerApellido.setDisabled(false);
			txtPrimerNombre.setValue(entity.getPrimerNombre());
			txtPrimerNombre.setDisabled(false);
			txtSegundoApellido.setValue(entity.getSegundoApellido());
			txtSegundoApellido.setDisabled(false);
			txtSegundoNombre.setValue(entity.getSegundoNombre());
			txtSegundoNombre.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtCiudadId_CiudadExpId.setValue(entity.getCiudadByCiudadExpId().getCiudadId());
			txtCiudadId_CiudadExpId.setDisabled(false);
			txtCiudadId_CiudadExpLic.setValue(entity.getCiudadByCiudadExpLic().getCiudadId());
			txtCiudadId_CiudadExpLic.setDisabled(false);
			txtConductorId.setValue(entity.getConductorId());
			txtConductorId.setDisabled(true);
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
			List<Conductor> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInConductor(condicion, null, null) : null;

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
			txtNIdentidad.setDisabled(false);
			txtNLicencia.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			// txtFoto.setDisabled(false);
			String urlImageDefauld = "defauldImagen.png";
			txtImagenConductor = urlImageDefauld;
			imagenConductor = "default.jpg";

			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			// txtNombre.setDisabled(false);
			txtPrimerApellido.setDisabled(false);
			txtPrimerNombre.setDisabled(false);
			txtSegundoApellido.setDisabled(false);
			txtSegundoNombre.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtCiudadId_CiudadExpId.setDisabled(false);
			txtCiudadId_CiudadExpLic.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtConductorId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtNIdentidad.setValue(entity.getNIdentidad());
			txtNIdentidad.setDisabled(false);
			txtNLicencia.setValue(entity.getNLicencia());
			txtNLicencia.setDisabled(false);
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
			// txtFoto.setValue(entity.getFoto());
			// txtFoto.setDisabled(false);
			imagenConductor = entity.getFoto();
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			// txtNombre.setValue(entity.getNombre());
			// txtNombre.setDisabled(false);
			txtPrimerApellido.setValue(entity.getPrimerApellido());
			txtPrimerApellido.setDisabled(false);
			txtPrimerNombre.setValue(entity.getPrimerNombre());
			txtPrimerNombre.setDisabled(false);
			txtSegundoApellido.setValue(entity.getSegundoApellido());
			txtSegundoApellido.setDisabled(false);
			txtSegundoNombre.setValue(entity.getSegundoNombre());
			txtSegundoNombre.setDisabled(false);

			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtCiudadId_CiudadExpId.setValue(entity.getCiudadByCiudadExpId().getCiudadId());
			txtCiudadId_CiudadExpId.setDisabled(false);
			txtCiudadId_CiudadExpLic.setValue(entity.getCiudadByCiudadExpLic().getCiudadId());
			txtCiudadId_CiudadExpLic.setDisabled(false);
			txtConductorId.setValue(entity.getConductorId());
			txtConductorId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedConductor = (ConductorDTO) (evt.getComponent().getAttributes().get("selectedConductor"));

		try {

			String codigo = selectedConductor.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Conductor> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInConductor(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtNIdentidad.setValue(entity.getNIdentidad());
				txtNIdentidad.setDisabled(false);
				txtNLicencia.setValue(entity.getNLicencia());
				txtNLicencia.setDisabled(false);
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
				// txtFoto.setValue(entity.getFoto());
				// txtFoto.setDisabled(false);
				imagenConductor = ((entity.getFoto() != null && !entity.getFoto().equals("")) ? entity.getFoto()
						: "default.jpg");

				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				// txtNombre.setValue(entity.getNombre());
				// txtNombre.setDisabled(false);

				txtPrimerApellido.setValue(entity.getPrimerApellido());
				txtPrimerApellido.setDisabled(false);
				txtPrimerNombre.setValue(entity.getPrimerNombre());
				txtPrimerNombre.setDisabled(false);
				txtSegundoApellido.setValue(entity.getSegundoApellido());
				txtSegundoApellido.setDisabled(false);
				txtSegundoNombre.setValue(entity.getSegundoNombre());
				txtSegundoNombre.setDisabled(false);

				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				txtCiudadId_CiudadExpId.setValue(selectedConductor.getCiudadId_Ciudad());
				txtCiudadId_CiudadExpId.setDisabled(false);
				txtCiudadId_CiudadExpLic.setValue(selectedConductor.getCiudadId_Ciudad1());
				txtCiudadId_CiudadExpLic.setDisabled(false);
				txtConductorId.setValue(entity.getConductorId());
				txtConductorId.setDisabled(true);
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
			if ((selectedConductor == null) && (entity == null)) {
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
			entity = new Conductor();

			// Long conductorId = FacesUtils.checkLong(txtConductorId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			String segundoNombre;
			String segundoApellido;
			entity.setNIdentidad(FacesUtils.checkString(txtNIdentidad));
			entity.setNLicencia(FacesUtils.checkString(txtNLicencia));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			// entity.setConductorId(conductorId);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			// entity.setFoto(FacesUtils.checkString(txtFoto));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(txtSegundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));

			segundoNombre = entity.getSegundoNombre();
			segundoApellido = entity.getSegundoApellido();

			if (segundoNombre != null) {
				segundoNombre = entity.getSegundoNombre();
			} else
				segundoNombre = " ";

			if (segundoApellido != null) {
				segundoApellido = entity.getSegundoApellido();
				;
			} else
				segundoApellido = " ";

			entity.setNombre(entity.getPrimerNombre() + ' ' + segundoNombre + ' ' + entity.getPrimerApellido() + ' '
					+ segundoApellido);

			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setCiudadByCiudadExpId((FacesUtils.checkLong(txtCiudadId_CiudadExpId) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_CiudadExpId)) : null);
			entity.setCiudadByCiudadExpLic((FacesUtils.checkLong(txtCiudadId_CiudadExpLic) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_CiudadExpLic)) : null);
			businessDelegatorView.saveConductor(entity);
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
				Long conductorId = new Long(selectedConductor.getConductorId());
				entity = businessDelegatorView.getConductor(conductorId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			String segundoNombre;
			String segundoApellido;

			entity.setNIdentidad(FacesUtils.checkString(txtNIdentidad));
			entity.setNLicencia(FacesUtils.checkString(txtNLicencia));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			// entity.setFoto(FacesUtils.checkString(txtFoto));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}

			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(txtSegundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));

			segundoNombre = entity.getSegundoNombre();
			segundoApellido = entity.getSegundoApellido();

			if (segundoNombre != null) {
				segundoNombre = entity.getSegundoNombre();
			} else
				segundoNombre = " ";

			if (segundoApellido != null) {
				segundoApellido = entity.getSegundoApellido();
				;
			} else
				segundoApellido = " ";

			entity.setNombre(entity.getPrimerNombre() + ' ' + segundoNombre + ' ' + entity.getPrimerApellido() + ' '
					+ segundoApellido);

			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setCiudadByCiudadExpId((FacesUtils.checkLong(txtCiudadId_CiudadExpId) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_CiudadExpId)) : null);
			entity.setCiudadByCiudadExpLic((FacesUtils.checkLong(txtCiudadId_CiudadExpLic) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_CiudadExpLic)) : null);
			businessDelegatorView.updateConductor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedConductor = (ConductorDTO) (evt.getComponent().getAttributes().get("selectedConductor"));

			Long conductorId = new Long(selectedConductor.getConductorId());
			entity = businessDelegatorView.getConductor(conductorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long conductorId = FacesUtils.checkLong(txtConductorId);
			entity = businessDelegatorView.getConductor(conductorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteConductor(entity);
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
			selectedConductor = (ConductorDTO) (evt.getComponent().getAttributes().get("selectedConductor"));

			Long conductorId = new Long(selectedConductor.getConductorId());
			entity = businessDelegatorView.getConductor(conductorId);
			businessDelegatorView.deleteConductor(entity);
			data.remove(selectedConductor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String NIdentidad, String NLicencia, String codigo, Long compania,
			Long conductorId, String estado, Date fechaCreacion, Date fechaModificacion, String foto,
			String infoAdicional, String infoAdicional2, String nombre, String primerApellido, String primerNombre,
			String segundoApellido, String segundoNombre, String telefono, Long ciudadId_Ciudad, Long ciudadId_Ciudad0)
			throws Exception {
		try {
			entity.setNIdentidad(FacesUtils.checkString(NIdentidad));
			entity.setNLicencia(FacesUtils.checkString(NLicencia));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFoto(FacesUtils.checkString(foto));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPrimerApellido(FacesUtils.checkString(primerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(primerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(segundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(segundoNombre));
			entity.setTelefono(FacesUtils.checkString(telefono));
			businessDelegatorView.updateConductor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ConductorView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtNIdentidad() {
		return txtNIdentidad;
	}

	public void setTxtNIdentidad(InputText txtNIdentidad) {
		this.txtNIdentidad = txtNIdentidad;
	}

	public InputText getTxtNLicencia() {
		return txtNLicencia;
	}

	public void setTxtNLicencia(InputText txtNLicencia) {
		this.txtNLicencia = txtNLicencia;
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

	public InputText getTxtFoto() {
		return txtFoto;
	}

	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
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

	public InputText getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	public void setTxtPrimerApellido(InputText txtPrimerApellido) {
		this.txtPrimerApellido = txtPrimerApellido;
	}

	public InputText getTxtPrimerNombre() {
		return txtPrimerNombre;
	}

	public void setTxtPrimerNombre(InputText txtPrimerNombre) {
		this.txtPrimerNombre = txtPrimerNombre;
	}

	public InputText getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	public void setTxtSegundoApellido(InputText txtSegundoApellido) {
		this.txtSegundoApellido = txtSegundoApellido;
	}

	public InputText getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	public void setTxtSegundoNombre(InputText txtSegundoNombre) {
		this.txtSegundoNombre = txtSegundoNombre;
	}

	public InputMask getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputMask txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public SelectOneMenu getTxtCiudadId_CiudadExpId() {
		return txtCiudadId_CiudadExpId;
	}

	public void setTxtCiudadId_CiudadExpId(SelectOneMenu txtCiudadId_CiudadExpId) {
		this.txtCiudadId_CiudadExpId = txtCiudadId_CiudadExpId;
	}

	public SelectOneMenu getTxtCiudadId_CiudadExpLic() {
		return txtCiudadId_CiudadExpLic;
	}

	public void setTxtCiudadId_CiudadExpLic(SelectOneMenu txtCiudadId_CiudadExpLic) {
		this.txtCiudadId_CiudadExpLic = txtCiudadId_CiudadExpLic;
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

	public InputText getTxtConductorId() {
		return txtConductorId;
	}

	public void setTxtConductorId(InputText txtConductorId) {
		this.txtConductorId = txtConductorId;
	}

	public List<ConductorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataConductor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ConductorDTO> conductorDTO) {
		this.data = conductorDTO;
	}

	public ConductorDTO getSelectedConductor() {
		return selectedConductor;
	}

	public void setSelectedConductor(ConductorDTO conductor) {
		this.selectedConductor = conductor;
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

	public SelectItem[] getselectCiudadExpId() {

		if (ciudadExpId == null || ciudadExpId.size() == 0) {

			ciudadExpId = new ArrayList<Ciudad>();

			try {

				ciudadExpId = businessDelegatorView.getCiudad(); // Fin by
				// Criteria
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudadExpId = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudadExpId : lista) {
					selectCiudadExpId[i] = new SelectItem(ciudadExpId.getCiudadId(), ciudadExpId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudadExpId;
	}

	public void setselectCiudadExpId(SelectItem[] selectCiudadExpId) {
		this.selectCiudadExpId = selectCiudadExpId;
	}

	public SelectItem[] getselectCiudadExpLic() {

		if (ciudadExpLic == null || ciudadExpLic.size() == 0) {

			ciudadExpLic = new ArrayList<Ciudad>();

			try {

				ciudadExpLic = businessDelegatorView.getCiudad(); // Fin by
				// Criteria
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudadExpLic = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudadExpLic : lista) {
					selectCiudadExpLic[i] = new SelectItem(ciudadExpLic.getCiudadId(), ciudadExpLic.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudadExpLic;
	}

	public void setselectCiudadExpLic(SelectItem[] selectCiudadExpLic) {
		this.selectCiudadExpLic = selectCiudadExpLic;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		this.txtImagenConductor = file.getFileName();
	}

	public String getTxtImagenConductor() {
		return txtImagenConductor;
	}

	public void setTxtImagenConductor(String txtImagenConductor) {
		this.txtImagenConductor = txtImagenConductor;
	}

	public String getImagenConductor() {
		return imagenConductor;
	}

	public void setImagenConductor(String imagenConductor) {
		this.imagenConductor = imagenConductor;
	}

	public void subirImagen() {

		ServletContext servletContext;
		String fileName = file.getFileName();

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

			String path = servletContext.getRealPath("");

			// UploadedFile file = event.getFile();
			inputStream = file.getInputstream();
			// fileName = file.getFileName();
			outputStream = new FileOutputStream(new File(path + "imagenes_subidas/" + fileName));

			int read = 0;
			byte[] bytes = new byte[100000];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			imagenConductor = fileName;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}

}
