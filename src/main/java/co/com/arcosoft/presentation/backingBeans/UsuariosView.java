package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
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
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.GroupMembers;
import co.com.arcosoft.modelo.Groups;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.UsuariosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuariosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UsuariosView.class);
	private InputText txtContrasena;
	private String contrasena;
	private String contrasenaEdit;
	private SelectOneRadio txtEnabled;
	private InputText txtLogin;
	private InputText txtNombre;
	private InputText txtUsuarioId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<UsuariosDTO> data;
	private UsuariosDTO selectedUsuarios;
	private Usuarios entity;
	private boolean showDialog;

	private SelectOneMenu txtCompaniaId_Compania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> grpUser;
	private List<Groups> selectedItemGrpUser;

	private SelectOneMenu txtPermisosMovil;
	private List<String> selectePermisos;
	private List<String> modulosMovil;
	private SelectOneMenu txtNivelAutorizacion1;
	private SelectOneMenu txtNivelAutorizacion2;
	private SelectOneMenu txtNivelAcceso;
	
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public UsuariosView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			UsuariosDTO usuariosDTO = (UsuariosDTO) e.getObject();

			if (txtContrasena == null) {
				txtContrasena = new InputText();
			}

			txtContrasena.setValue(usuariosDTO.getContrasena());

			if (txtEnabled == null) {
				txtEnabled = new SelectOneRadio();
			}

			txtEnabled.setValue(usuariosDTO.getEnabled());

			if (txtLogin == null) {
				txtLogin = new InputText();
			}

			txtLogin.setValue(usuariosDTO.getLogin());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(usuariosDTO.getNombre());

			if (txtCompaniaId_Compania == null) {
				txtCompaniaId_Compania = new SelectOneMenu();
			}

			txtCompaniaId_Compania.setValue(usuariosDTO.getCompaniaId_Compania());

			if (txtUsuarioId == null) {
				txtUsuarioId = new InputText();
			}

			txtUsuarioId.setValue(usuariosDTO.getUsuarioId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(usuariosDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(usuariosDTO.getFechaModificacion());

			Long usuarioId = FacesUtils.checkLong(txtUsuarioId);
			entity = businessDelegatorView.getUsuarios(usuarioId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedUsuarios = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedUsuarios = null;
		grpUser = null;
		PrimeFaces.current().resetInputs(":dialogUsuarios :frm");

		contrasena = "";

		/*
		 * if (txtContrasena != null) { txtContrasena.setValue(null);
		 * txtContrasena.setDisabled(true); }
		 */

		if (txtEnabled != null) {
			txtEnabled.setValue("true");
			txtEnabled.setDisabled(true);
		}

		if (txtLogin != null) {
			txtLogin.setValue(null);
			txtLogin.setDisabled(false);
		}
		
		if (txtNivelAcceso != null) {
			txtNivelAcceso.setValue(null);
			txtNivelAcceso.setDisabled(false);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}
	
		if (txtNivelAutorizacion1 != null) {
			txtNivelAutorizacion1.setValue(null);
			txtNivelAutorizacion1.setDisabled(true);
		}
		if (txtNivelAutorizacion2 != null) {
			txtNivelAutorizacion2.setValue(null);
			txtNivelAutorizacion2.setDisabled(true);
		}
	
		
		
		if (txtPermisosMovil != null) {
			txtPermisosMovil.setValue(null);
			txtPermisosMovil.setDisabled(true);
		}

		if (txtCompaniaId_Compania != null) {
			txtCompaniaId_Compania.setValue(null);
			txtCompaniaId_Compania.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtUsuarioId != null) {
			txtUsuarioId.setValue(null);
			txtUsuarioId.setDisabled(false);
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

			String login = FacesUtils.checkString(txtLogin).toUpperCase();
			Object[] condicion = { "login", true, login, "=" };
			List<Usuarios> lista = (login != null)
					? businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				FacesUtils.addErrorMessage("Lo sentimos el login digitado " + login + " no esta disponible! ");

			} else {
				FacesUtils.addInfoMessage(
						"El login digitado esta disponible!, si deseas puedes crear un nuevo registro con el login: "
								+ login);
			}

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtContrasena.setDisabled(false);
			txtEnabled.setDisabled(false);
			txtLogin.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNivelAcceso.setDisabled(false);
			txtCompaniaId_Compania.setDisabled(false);
		//	txtNivelAutorizacion1.setDisabled(false);
			//txtNivelAutorizacion2.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtUsuarioId.setDisabled(false);
			// txtPermisosMovil.setDisabled(false);

			btnSave.setDisabled(false);
		} else {

			entity = null;
			PrimeFaces.current().resetInputs(":dialogUsuarios :frm");
			/*
			 * txtContrasena.setValue(entity.getContrasena());
			 * txtContrasena.setDisabled(false); txtEnabled.setValue(entity.getEnabled());
			 * txtEnabled.setDisabled(false);
			 * //txtFechaCreacion.setValue(entity.getFechaCreacion());
			 * //txtFechaCreacion.setDisabled(false);
			 * //txtFechaModificacion.setValue(entity.getFechaModificacion());
			 * //txtFechaModificacion.setDisabled(false);
			 * txtLogin.setValue(entity.getLogin()); txtLogin.setDisabled(false);
			 * txtNombre.setValue(entity.getNombre()); txtNombre.setDisabled(false);
			 * txtCompaniaId_Compania.setValue(entity.getCompania(). getCompaniaId());
			 * txtCompaniaId_Compania.setDisabled(false);
			 * txtUsuarioId.setValue(entity.getUsuarioId());
			 * txtUsuarioId.setDisabled(false); btnSave.setDisabled(false);
			 * 
			 * if (btnDelete != null) { btnDelete.setDisabled(false); }
			 */
		}
	}

	public String action_edit(ActionEvent evt) throws Exception {
		selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes().get("selectedUsuarios"));

		//RequestContext.getCurrentInstance().reset(":dialogUsuarios :frm");

		try {

			String login = selectedUsuarios.getLogin().toString().toUpperCase();
			Object[] condicion = { "login", true, login, "=" };
			List<Usuarios> lista = (login != null)
					? businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				contrasenaEdit = entity.getContrasena().toString();
				contrasena = entity.getContrasena().toString();
				// txtContrasena.setDisabled(false);
				txtEnabled.setValue(selectedUsuarios.getEnabled());
				txtEnabled.setDisabled(false);
				// txtFechaCreacion.setValue(selectedUsuarios.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedUsuarios.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtLogin.setValue(entity.getLogin());
				txtLogin.setDisabled(false);
			
				txtNivelAcceso.setValue(entity.getNivelAcceso());
				txtNivelAcceso.setDisabled(false);
				
			//	txtNivelAutorizacion1.setValue(entity.getNivelAutorizacion1());
			//	txtNivelAutorizacion1.setDisabled(false);
			//	txtNivelAutorizacion1.setValue(entity.getNivelAutorizacion1());
			//	txtNivelAutorizacion2.setDisabled(false);
				
				// txtPermisosMovil.setValue(entity.getPermisosMovil());
				// txtPermisosMovil.setDisabled(false);

				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtCompaniaId_Compania.setValue(entity.getCompania().getCompaniaId());
				txtCompaniaId_Compania.setDisabled(false);
				txtUsuarioId.setValue(entity.getUsuarioId());
				txtUsuarioId.setDisabled(true);

				Object[] condicion2 = { "usuarios.usuarioId", false, selectedUsuarios.getUsuarioId().longValue(), "=" };

				List<GroupMembers> gm = businessDelegatorView.findByCriteriaInGroupMembers(condicion2, null, null);

				if (gm != null && gm.size() > 0) {

					Object[] grouspMembers = gm.toArray();
					grpUser = new ArrayList<String>();

					for (int i = 0; i < grouspMembers.length; i++) {

						GroupMembers groupMembers = (GroupMembers) grouspMembers[i];
						grpUser.add(groupMembers.getGroups().getId().toString());

					}
				}

			//txtPermisosMovil.setDisabled(false);
				if(entity.getPermisosMovil() !=null){
				String aux_cadena = entity.getPermisosMovil();
				String[] tmp = new String[aux_cadena.length() - 1];

				StringTokenizer st = new StringTokenizer(aux_cadena, ", ");

				selectePermisos = new ArrayList<String>();

				int i = 0;
				while (st.hasMoreTokens()) {
					tmp[i] = st.nextToken();
					selectePermisos.add(tmp[i]);
					i++;
				}
				String cadena = ""; List<String> aux1= selectePermisos; for (int j = 0; j <
						 aux1.size(); j++) { cadena +=aux1.get(j)+","; }
				
				}

				
				
				

				btnSave.setDisabled(false);
				setShowDialog(true);

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());

		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedUsuarios == null) && (entity == null)) {
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

	public String passwordEncoderGenerator(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		return hashedPassword;
	}

	public String action_create() {
		try {
			entity = new Usuarios();
			Date date = new Date();

			String cadena = "";
			if(selectePermisos!=null) {
			List<String> aux1 = selectePermisos;
			for (int i = 0; i < aux1.size(); i++) {
				cadena += aux1.get(i) + ",";
			}
			}

			entity.setNivelAutorizacion1(FacesUtils.checkString(txtNivelAutorizacion1));
			entity.setNivelAutorizacion2(FacesUtils.checkString(txtNivelAutorizacion2));
			entity.setNivelAcceso(FacesUtils.checkString(txtNivelAcceso));
			
			entity.setContrasena(passwordEncoderGenerator(contrasena));
			entity.setEnabled(FacesUtils.checkString(txtEnabled));
			entity.setFechaCreacion(date);
			entity.setLogin(FacesUtils.checkString(txtLogin));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPermisosMovil(cadena);
			// entity.setUsuarioId(usuarioId);
			entity.setCompania((FacesUtils.checkLong(txtCompaniaId_Compania) != null)
					? businessDelegatorView.getCompania(FacesUtils.checkLong(txtCompaniaId_Compania))
					: null);
			businessDelegatorView.saveUsuarios(entity, grpUser);
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
				Long usuarioId = new Long(selectedUsuarios.getUsuarioId());
				entity = businessDelegatorView.getUsuarios(usuarioId);
			}

			String cadena = "";
			if(selectePermisos!=null) {
			List<String> aux1 = selectePermisos;
			for (int i = 0; i < aux1.size(); i++) {
				cadena += aux1.get(i) + ",";
			}
			}

			String nuevaContrasena = contrasena;
			Date date = new Date();

			// "$2a$
			// if (bcryptEncoder.matches(contrasena, entity.getContrasena().toString())) {
			if (nuevaContrasena.substring(0, 4).equals(contrasenaEdit.substring(0, 4))) {

				entity.setNivelAutorizacion1(FacesUtils.checkString(txtNivelAutorizacion1));
				entity.setNivelAutorizacion2(FacesUtils.checkString(txtNivelAutorizacion2));
				entity.setNivelAcceso(FacesUtils.checkString(txtNivelAcceso));
					
				entity.setContrasena(entity.getContrasena().toString());
				entity.setEnabled(FacesUtils.checkString(txtEnabled));
				entity.setFechaModificacion(date);
				entity.setPermisosMovil(cadena);
				entity.setLogin(FacesUtils.checkString(txtLogin));
				entity.setNombre(FacesUtils.checkString(txtNombre));
				entity.setCompania((FacesUtils.checkLong(txtCompaniaId_Compania) != null)
						? businessDelegatorView.getCompania(FacesUtils.checkLong(txtCompaniaId_Compania))
						: null);
				businessDelegatorView.updateUsuarios(entity, grpUser);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			} else {
				
				entity.setNivelAutorizacion1(FacesUtils.checkString(txtNivelAutorizacion1));
				entity.setNivelAutorizacion2(FacesUtils.checkString(txtNivelAutorizacion2));
				
				entity.setContrasena(passwordEncoderGenerator(nuevaContrasena));
				entity.setEnabled(FacesUtils.checkString(txtEnabled));
				// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
				entity.setFechaModificacion(date);
		//		entity.setPermisosMovil(cadena);
				entity.setLogin(FacesUtils.checkString(txtLogin));
				entity.setNombre(FacesUtils.checkString(txtNombre));
				entity.setCompania((FacesUtils.checkLong(txtCompaniaId_Compania) != null)
						? businessDelegatorView.getCompania(FacesUtils.checkLong(txtCompaniaId_Compania))
						: null);
				businessDelegatorView.updateUsuarios(entity, grpUser);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				
				

				/*if (BCrypt.checkpw(nuevaContrasena, contrasenaEdit)) {

					entity.setContrasena(entity.getContrasena().toString());
					entity.setPermisosMovil(cadena);
					entity.setEnabled(FacesUtils.checkString(txtEnabled));
					// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
					entity.setFechaModificacion(date);
					entity.setLogin(FacesUtils.checkString(txtLogin));
					entity.setNombre(FacesUtils.checkString(txtNombre));
					entity.setCompania((FacesUtils.checkLong(txtCompaniaId_Compania) != null)
							? businessDelegatorView.getCompania(FacesUtils.checkLong(txtCompaniaId_Compania))
							: null);

					businessDelegatorView.updateUsuarios(entity, grpUser);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

				} else {

					entity.setContrasena(passwordEncoderGenerator(nuevaContrasena));
					entity.setEnabled(FacesUtils.checkString(txtEnabled));
					// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
					entity.setFechaModificacion(date);
					entity.setPermisosMovil(cadena);
					entity.setLogin(FacesUtils.checkString(txtLogin));
					entity.setNombre(FacesUtils.checkString(txtNombre));
					entity.setCompania((FacesUtils.checkLong(txtCompaniaId_Compania) != null)
							? businessDelegatorView.getCompania(FacesUtils.checkLong(txtCompaniaId_Compania))
							: null);
					businessDelegatorView.updateUsuarios(entity, grpUser);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

				}*/

			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}



	public void listener_txtIdActualizarClave() {

		try {

			String login = FacesUtils.checkString(txtLogin).toUpperCase();
			Object[] condicion = { "login", true, login, "=" };
			List<Usuarios> lista = (login != null)
					? businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				FacesUtils.addInfoMessage("Puede proceder a modificar la clave de su usuario " + login );

			} else {
				FacesUtils.addErrorMessage(
						"El login digitado NO existe, si deseas puedes crear un nuevo registro con el login: "
								+ login);
			}

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtContrasena.setDisabled(false);
	//		txtEnabled.setDisabled(false);
			txtLogin.setDisabled(false);
		//	txtNombre.setDisabled(false);
		//	txtCompaniaId_Compania.setDisabled(false);
		//	txtNivelAutorizacion1.setDisabled(false);
		//	txtNivelAutorizacion2.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtUsuarioId.setDisabled(false);
			// txtPermisosMovil.setDisabled(false);

			btnSave.setDisabled(true);
		} else {

			contrasenaEdit = entity.getContrasena().toString();
			contrasena = entity.getContrasena().toString();
			txtUsuarioId.setValue(entity.getUsuarioId());
			txtUsuarioId.setDisabled(true);
			txtLogin.setValue(entity.getLogin());
			txtLogin.setDisabled(false);

			btnSave.setDisabled(false);
		}
	}

	
	public String action_modifyActualizarClave() {
		try {
			if (entity == null) {
				Long usuarioId = new Long(selectedUsuarios.getUsuarioId());
				entity = businessDelegatorView.getUsuarios(usuarioId);
			}

			String nuevaContrasena = contrasena;
			
			if (nuevaContrasena.substring(0, 4).equals(contrasenaEdit.substring(0, 4))) {

				entity.setContrasena(entity.getContrasena().toString());
				businessDelegatorView.updateUsuarios(entity, grpUser);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			} else {
				
				entity.setContrasena(passwordEncoderGenerator(nuevaContrasena));
				businessDelegatorView.updateUsuarios(entity, grpUser);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				
				
			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes().get("selectedUsuarios"));

			Long usuarioId = new Long(selectedUsuarios.getUsuarioId());
			entity = businessDelegatorView.getUsuarios(usuarioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long usuarioId = FacesUtils.checkLong(txtUsuarioId);
			entity = businessDelegatorView.getUsuarios(usuarioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteUsuarios(entity);
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
			selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes().get("selectedUsuarios"));

			Long usuarioId = new Long(selectedUsuarios.getUsuarioId());
			entity = businessDelegatorView.getUsuarios(usuarioId);
			businessDelegatorView.deleteUsuarios(entity);
			data.remove(selectedUsuarios);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String contrasena, String enabled, Date fechaCreacion, Date fechaModificacion,
			String login, String nombre, Long usuarioId, Long companiaId_Compania) throws Exception {
		try {
			entity.setContrasena(contrasena);
			entity.setEnabled(FacesUtils.checkString(enabled));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setLogin(FacesUtils.checkString(login));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateUsuarios(entity, grpUser);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("UsuariosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(InputText txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public SelectOneRadio getTxtEnabled() {
		return txtEnabled;
	}

	public void setTxtEnabled(SelectOneRadio txtEnabled) {
		this.txtEnabled = txtEnabled;
	}

	public InputText getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(InputText txtLogin) {
		this.txtLogin = txtLogin;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public SelectOneMenu getTxtCompaniaId_Compania() {
		return txtCompaniaId_Compania;
	}

	public void setTxtCompaniaId_Compania(SelectOneMenu txtCompaniaId_Compania) {
		this.txtCompaniaId_Compania = txtCompaniaId_Compania;
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

	public InputText getTxtUsuarioId() {
		return txtUsuarioId;
	}

	public void setTxtUsuarioId(InputText txtUsuarioId) {
		this.txtUsuarioId = txtUsuarioId;
	}

	public List<UsuariosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataUsuarios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<UsuariosDTO> usuariosDTO) {
		this.data = usuariosDTO;
	}

	public UsuariosDTO getSelectedUsuarios() {
		return selectedUsuarios;
	}

	public void setSelectedUsuarios(UsuariosDTO usuarios) {
		this.selectedUsuarios = usuarios;
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

	public List<String> getGrpUser() {
		return grpUser;
	}

	public List<Groups> getSelectedItemGrpUser() {

		if (selectedItemGrpUser == null || selectedItemGrpUser.size() == 0) {

			selectedItemGrpUser = new ArrayList<Groups>();

			try {
				selectedItemGrpUser = businessDelegatorView.getGroups();

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectedItemGrpUser;
	}

	public void setGrpUser(List<String> grpUser) {
		this.grpUser = grpUser;
	}

	public void setSelectedItemGrpUser(List<Groups> selectedItemGrpUser) {
		this.selectedItemGrpUser = selectedItemGrpUser;
	}

	public SelectItem[] getSelectCompania() {

		if (compania == null || compania.size() == 0) {

			compania = new ArrayList<Compania>();

			try {

				// compania = businessDelegatorView.getCompania();
				Object[] condicion = { "estado", true, "A", "=" };
				List<Compania> lista = businessDelegatorView.findByCriteriaInCompania(condicion, null, null);

				selectCompania = new SelectItem[lista.size()];

				int i = 0;
				for (Compania c : lista) {
					selectCompania[i] = new SelectItem(c.getCompaniaId(), c.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectCompania;
	}

	public void setSelectCompania(SelectItem[] selectCompania) {
		this.selectCompania = selectCompania;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the txtPermisosMovil
	 */
	public SelectOneMenu getTxtPermisosMovil() {
		return txtPermisosMovil;
	}

	/**
	 * @param txtPermisosMovil
	 *            the txtPermisosMovil to set
	 */
	public void setTxtPermisosMovil(SelectOneMenu txtPermisosMovil) {
		this.txtPermisosMovil = txtPermisosMovil;
	}

	public List<String> getSelectePermisos() {
		return selectePermisos;
	}

	public void setSelectePermisos(List<String> selectePermisos) {
		this.selectePermisos = selectePermisos;
	}

	public List<String> getModulosMovil() {

		modulosMovil = new ArrayList<String>();
		modulosMovil.add("Todos");
		modulosMovil.add("London");
		modulosMovil.add("Paris");
		modulosMovil.add("Istanbul");
		modulosMovil.add("Berlin");
		modulosMovil.add("Barcelona");
		modulosMovil.add("Rome");
		modulosMovil.add("Brasilia");
		modulosMovil.add("Amsterdam");

		return modulosMovil;
	}

	public void setModulosMovil(List<String> modulosMovil) {
		this.modulosMovil = modulosMovil;
	}

	public String getContrasenaEdit() {
		return contrasenaEdit;
	}

	public void setContrasenaEdit(String contrasenaEdit) {
		this.contrasenaEdit = contrasenaEdit;
	}

	/**
	 * @return the txtNivelAutorizacion1
	 */
	public SelectOneMenu getTxtNivelAutorizacion1() {
		return txtNivelAutorizacion1;
	}

	/**
	 * @param txtNivelAutorizacion1 the txtNivelAutorizacion1 to set
	 */
	public void setTxtNivelAutorizacion1(SelectOneMenu txtNivelAutorizacion1) {
		this.txtNivelAutorizacion1 = txtNivelAutorizacion1;
	}

	/**
	 * @return the txtNivelAutorizacion2
	 */
	public SelectOneMenu getTxtNivelAutorizacion2() {
		return txtNivelAutorizacion2;
	}

	/**
	 * @param txtNivelAutorizacion2 the txtNivelAutorizacion2 to set
	 */
	public void setTxtNivelAutorizacion2(SelectOneMenu txtNivelAutorizacion2) {
		this.txtNivelAutorizacion2 = txtNivelAutorizacion2;
	}

	public SelectOneMenu getTxtNivelAcceso() {
		return txtNivelAcceso;
	}

	public void setTxtNivelAcceso(SelectOneMenu txtNivelAcceso) {
		this.txtNivelAcceso = txtNivelAcceso;
	}
	
	

}
