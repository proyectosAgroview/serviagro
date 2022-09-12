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
import org.primefaces.component.colorpicker.ColorPicker;
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
import co.com.arcosoft.modelo.Conductor;
import co.com.arcosoft.modelo.FabricanteEquipo;
import co.com.arcosoft.modelo.NumeroEje;
import co.com.arcosoft.modelo.Transportadora;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.VehiculosTransp;
import co.com.arcosoft.modelo.dto.VehiculosTranspDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VehiculosTranspView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VehiculosTranspView.class);
	private InputText txtCodigo;
	private ColorPicker txtColor;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputText txtFoto;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputMask txtPlaca;
	// private InputText txtConductorId_Conductor;
	// private InputText txtFabricEquipId_FabricanteEquipo;
	// private InputText txtNumEjeId_NumeroEje;
	// private InputText txtTranspId_Transportadora;
	private InputText txtVehiTranspId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<VehiculosTranspDTO> data;
	private VehiculosTranspDTO selectedVehiculosTransp;
	private VehiculosTransp entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtConductorId_Conductor;
	SelectItem[] selectConductor;
	private List<Conductor> conductor;

	private SelectOneMenu txtFabricEquipId_FabricanteEquipo;
	SelectItem[] selectFabricanteEquipo;
	private List<FabricanteEquipo> fabricanteEquipo;

	private SelectOneMenu txtTranspId_Transportadora;
	SelectItem[] selectTransportadora;
	private List<Transportadora> transportadora;

	private SelectOneMenu txtNumEjeId_NumeroEje;
	SelectItem[] selectNumeroEje;
	private List<NumeroEje> numeroEje;

	private String txtImagenVehiculo;
	private String imagenVehiculo;
	private UploadedFile file;

	public VehiculosTranspView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			VehiculosTranspDTO vehiculosTranspDTO = (VehiculosTranspDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(vehiculosTranspDTO.getCodigo());

			if (txtColor == null) {
				txtColor = new ColorPicker();
			}

			txtColor.setValue(vehiculosTranspDTO.getColor());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(vehiculosTranspDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(vehiculosTranspDTO.getEstado());

			if (txtFoto == null) {
				txtFoto = new InputText();
			}

			txtFoto.setValue(vehiculosTranspDTO.getFoto());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(vehiculosTranspDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(vehiculosTranspDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(vehiculosTranspDTO.getNombre());

			if (txtPlaca == null) {
				txtPlaca = new InputMask();
			}

			txtPlaca.setValue(vehiculosTranspDTO.getPlaca());

			if (txtConductorId_Conductor == null) {
				txtConductorId_Conductor = new SelectOneMenu();
			}

			txtConductorId_Conductor.setValue(vehiculosTranspDTO.getConductorId_Conductor());

			if (txtFabricEquipId_FabricanteEquipo == null) {
				txtFabricEquipId_FabricanteEquipo = new SelectOneMenu();
			}

			txtFabricEquipId_FabricanteEquipo.setValue(vehiculosTranspDTO.getFabricEquipId_FabricanteEquipo());

			if (txtNumEjeId_NumeroEje == null) {
				txtNumEjeId_NumeroEje = new SelectOneMenu();
			}

			txtNumEjeId_NumeroEje.setValue(vehiculosTranspDTO.getNumEjeId_NumeroEje());

			if (txtTranspId_Transportadora == null) {
				txtTranspId_Transportadora = new SelectOneMenu();
			}

			txtTranspId_Transportadora.setValue(vehiculosTranspDTO.getTranspId_Transportadora());

			if (txtVehiTranspId == null) {
				txtVehiTranspId = new InputText();
			}

			txtVehiTranspId.setValue(vehiculosTranspDTO.getVehiTranspId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(vehiculosTranspDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(vehiculosTranspDTO.getFechaModificacion());

			Long vehiTranspId = FacesUtils.checkLong(txtVehiTranspId);
			entity = businessDelegatorView.getVehiculosTransp(vehiTranspId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedVehiculosTransp = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedVehiculosTransp = null;
		PrimeFaces.current().resetInputs(":dialogVehiculosTransp :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtColor != null) {
			txtColor.setValue(null);

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

		if (txtPlaca != null) {
			txtPlaca.setValue(null);
			txtPlaca.setDisabled(true);
		}

		if (txtConductorId_Conductor != null) {
			txtConductorId_Conductor.setValue(null);
			txtConductorId_Conductor.setDisabled(true);
		}

		if (txtFabricEquipId_FabricanteEquipo != null) {
			txtFabricEquipId_FabricanteEquipo.setValue(null);
			txtFabricEquipId_FabricanteEquipo.setDisabled(true);
		}

		if (txtNumEjeId_NumeroEje != null) {
			txtNumEjeId_NumeroEje.setValue(null);
			txtNumEjeId_NumeroEje.setDisabled(true);
		}

		if (txtTranspId_Transportadora != null) {
			txtTranspId_Transportadora.setValue(null);
			txtTranspId_Transportadora.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtVehiTranspId != null) {
			txtVehiTranspId.setValue(null);
			txtVehiTranspId.setDisabled(false);
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
			Long vehiTranspId = FacesUtils.checkLong(txtVehiTranspId);
			entity = (vehiTranspId != null) ? businessDelegatorView.getVehiculosTransp(vehiTranspId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);

			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtFoto.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPlaca.setDisabled(false);
			txtConductorId_Conductor.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtNumEjeId_NumeroEje.setDisabled(false);
			txtTranspId_Transportadora.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtVehiTranspId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtColor.setValue(entity.getColor());

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
			txtPlaca.setValue(entity.getPlaca());
			txtPlaca.setDisabled(false);
			txtConductorId_Conductor.setValue(entity.getConductor().getConductorId());
			txtConductorId_Conductor.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setValue(entity.getFabricanteEquipo().getFabricEquipId());
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtNumEjeId_NumeroEje.setValue(entity.getNumeroEje().getNumEjeId());
			txtNumEjeId_NumeroEje.setDisabled(false);
			txtTranspId_Transportadora.setValue(entity.getTransportadora().getTranspId());
			txtTranspId_Transportadora.setDisabled(false);
			txtVehiTranspId.setValue(entity.getVehiTranspId());
			txtVehiTranspId.setDisabled(true);
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
			List<VehiculosTransp> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVehiculosTransp(condicion, null, null) : null;

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
			// txtFoto.setDisabled(false);
			String urlImageDefauld = "defauldImagen.png";
			txtImagenVehiculo = urlImageDefauld;
			imagenVehiculo = "default.jpg";

			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPlaca.setDisabled(false);
			txtConductorId_Conductor.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtNumEjeId_NumeroEje.setDisabled(false);
			txtTranspId_Transportadora.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtVehiTranspId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtColor.setValue(entity.getColor());

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
			imagenVehiculo = entity.getFoto();
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtPlaca.setValue(entity.getPlaca());
			txtPlaca.setDisabled(false);
			txtConductorId_Conductor.setValue(entity.getConductor().getConductorId());
			txtConductorId_Conductor.setDisabled(false);
			txtFabricEquipId_FabricanteEquipo.setValue(entity.getFabricanteEquipo().getFabricEquipId());
			txtFabricEquipId_FabricanteEquipo.setDisabled(false);
			txtNumEjeId_NumeroEje.setValue(entity.getNumeroEje().getNumEjeId());
			txtNumEjeId_NumeroEje.setDisabled(false);
			txtTranspId_Transportadora.setValue(entity.getTransportadora().getTranspId());
			txtTranspId_Transportadora.setDisabled(false);
			txtVehiTranspId.setValue(entity.getVehiTranspId());
			txtVehiTranspId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedVehiculosTransp = (VehiculosTranspDTO) (evt.getComponent().getAttributes()
				.get("selectedVehiculosTransp"));
		try {

			String codigo = selectedVehiculosTransp.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<VehiculosTransp> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVehiculosTransp(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtColor.setValue(entity.getColor());

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

				imagenVehiculo = ((entity.getFoto() != null && !entity.getFoto().equals("")) ? entity.getFoto()
						: "default.jpg");

				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtPlaca.setValue(entity.getPlaca());
				txtPlaca.setDisabled(false);
				txtConductorId_Conductor.setValue(selectedVehiculosTransp.getConductorId_Conductor());
				txtConductorId_Conductor.setDisabled(false);
				txtFabricEquipId_FabricanteEquipo.setValue(selectedVehiculosTransp.getFabricEquipId_FabricanteEquipo());
				txtFabricEquipId_FabricanteEquipo.setDisabled(false);
				txtNumEjeId_NumeroEje.setValue(selectedVehiculosTransp.getNumEjeId_NumeroEje());
				txtNumEjeId_NumeroEje.setDisabled(false);
				txtTranspId_Transportadora.setValue(selectedVehiculosTransp.getTranspId_Transportadora());
				txtTranspId_Transportadora.setDisabled(false);
				txtVehiTranspId.setValue(entity.getVehiTranspId());
				txtVehiTranspId.setDisabled(true);
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
			if ((selectedVehiculosTransp == null) && (entity == null)) {
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
			entity = new VehiculosTransp();

			// Long vehiTranspId = FacesUtils.checkLong(txtVehiTranspId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setCompania(compania);
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
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPlaca(FacesUtils.checkString(txtPlaca));
			// entity.setVehiTranspId(vehiTranspId);
			entity.setConductor((FacesUtils.checkLong(txtConductorId_Conductor) != null)
					? businessDelegatorView.getConductor(FacesUtils.checkLong(txtConductorId_Conductor)) : null);
			entity.setFabricanteEquipo((FacesUtils.checkLong(txtFabricEquipId_FabricanteEquipo) != null)
					? businessDelegatorView.getFabricanteEquipo(FacesUtils.checkLong(txtFabricEquipId_FabricanteEquipo))
					: null);
			entity.setNumeroEje((FacesUtils.checkLong(txtNumEjeId_NumeroEje) != null)
					? businessDelegatorView.getNumeroEje(FacesUtils.checkLong(txtNumEjeId_NumeroEje)) : null);
			entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora) != null)
					? businessDelegatorView.getTransportadora(FacesUtils.checkLong(txtTranspId_Transportadora)) : null);
			businessDelegatorView.saveVehiculosTransp(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
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

	public String action_modify() {
		try {
			if (entity == null) {
				Long vehiTranspId = new Long(selectedVehiculosTransp.getVehiTranspId());
				entity = businessDelegatorView.getVehiculosTransp(vehiTranspId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setColor(FacesUtils.checkString(txtColor));
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
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPlaca(FacesUtils.checkString(txtPlaca));
			entity.setConductor((FacesUtils.checkLong(txtConductorId_Conductor) != null)
					? businessDelegatorView.getConductor(FacesUtils.checkLong(txtConductorId_Conductor)) : null);
			entity.setFabricanteEquipo((FacesUtils.checkLong(txtFabricEquipId_FabricanteEquipo) != null)
					? businessDelegatorView.getFabricanteEquipo(FacesUtils.checkLong(txtFabricEquipId_FabricanteEquipo))
					: null);
			entity.setNumeroEje((FacesUtils.checkLong(txtNumEjeId_NumeroEje) != null)
					? businessDelegatorView.getNumeroEje(FacesUtils.checkLong(txtNumEjeId_NumeroEje)) : null);
			entity.setTransportadora((FacesUtils.checkLong(txtTranspId_Transportadora) != null)
					? businessDelegatorView.getTransportadora(FacesUtils.checkLong(txtTranspId_Transportadora)) : null);
			businessDelegatorView.updateVehiculosTransp(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedVehiculosTransp = (VehiculosTranspDTO) (evt.getComponent().getAttributes()
					.get("selectedVehiculosTransp"));

			Long vehiTranspId = new Long(selectedVehiculosTransp.getVehiTranspId());
			entity = businessDelegatorView.getVehiculosTransp(vehiTranspId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long vehiTranspId = FacesUtils.checkLong(txtVehiTranspId);
			entity = businessDelegatorView.getVehiculosTransp(vehiTranspId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteVehiculosTransp(entity);
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
			selectedVehiculosTransp = (VehiculosTranspDTO) (evt.getComponent().getAttributes()
					.get("selectedVehiculosTransp"));

			Long vehiTranspId = new Long(selectedVehiculosTransp.getVehiTranspId());
			entity = businessDelegatorView.getVehiculosTransp(vehiTranspId);
			businessDelegatorView.deleteVehiculosTransp(entity);
			data.remove(selectedVehiculosTransp);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String color, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String foto, String infoAdicional, String infoAdicional2, String nombre,
			String placa, Long vehiTranspId, Long conductorId_Conductor, Long fabricEquipId_FabricanteEquipo,
			Long numEjeId_NumeroEje, Long transpId_Transportadora) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setColor(FacesUtils.checkString(color));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFoto(FacesUtils.checkString(foto));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPlaca(FacesUtils.checkString(placa));
			businessDelegatorView.updateVehiculosTransp(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("VehiculosTranspView").requestRender();
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

	public ColorPicker getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(ColorPicker txtColor) {
		this.txtColor = txtColor;
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

	public InputMask getTxtPlaca() {
		return txtPlaca;
	}

	public void setTxtPlaca(InputMask txtPlaca) {
		this.txtPlaca = txtPlaca;
	}

	public SelectOneMenu getTxtConductorId_Conductor() {
		return txtConductorId_Conductor;
	}

	public void setTxtConductorId_Conductor(SelectOneMenu txtConductorId_Conductor) {
		this.txtConductorId_Conductor = txtConductorId_Conductor;
	}

	public SelectOneMenu getTxtFabricEquipId_FabricanteEquipo() {
		return txtFabricEquipId_FabricanteEquipo;
	}

	public void setTxtFabricEquipId_FabricanteEquipo(SelectOneMenu txtFabricEquipId_FabricanteEquipo) {
		this.txtFabricEquipId_FabricanteEquipo = txtFabricEquipId_FabricanteEquipo;
	}

	public SelectOneMenu getTxtNumEjeId_NumeroEje() {
		return txtNumEjeId_NumeroEje;
	}

	public void setTxtNumEjeId_NumeroEje(SelectOneMenu txtNumEjeId_NumeroEje) {
		this.txtNumEjeId_NumeroEje = txtNumEjeId_NumeroEje;
	}

	public SelectOneMenu getTxtTranspId_Transportadora() {
		return txtTranspId_Transportadora;
	}

	public void setTxtTranspId_Transportadora(SelectOneMenu txtTranspId_Transportadora) {
		this.txtTranspId_Transportadora = txtTranspId_Transportadora;
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

	public InputText getTxtVehiTranspId() {
		return txtVehiTranspId;
	}

	public void setTxtVehiTranspId(InputText txtVehiTranspId) {
		this.txtVehiTranspId = txtVehiTranspId;
	}

	public List<VehiculosTranspDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVehiculosTransp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<VehiculosTranspDTO> vehiculosTranspDTO) {
		this.data = vehiculosTranspDTO;
	}

	public VehiculosTranspDTO getSelectedVehiculosTransp() {
		return selectedVehiculosTransp;
	}

	public void setSelectedVehiculosTransp(VehiculosTranspDTO vehiculosTransp) {
		this.selectedVehiculosTransp = vehiculosTransp;
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		if (file != null) {
			this.txtImagenVehiculo = file.getFileName();
		}
	}

	public String getTxtImagenVehiculo() {
		return txtImagenVehiculo;
	}

	public void setTxtImagenVehiculo(String txtImagenVehiculo) {
		this.txtImagenVehiculo = txtImagenVehiculo;
	}

	public String getImagenVehiculo() {
		return imagenVehiculo;
	}

	public void setImagenVehiculo(String imagenVehiculo) {
		this.imagenVehiculo = imagenVehiculo;
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

			imagenVehiculo = fileName;

		} catch (IOException e) {

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

	public SelectItem[] getselectNumeroEje() {

		if (numeroEje == null || numeroEje.size() == 0) {

			numeroEje = new ArrayList<NumeroEje>();

			try {

				numeroEje = businessDelegatorView.getNumeroEje(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<NumeroEje> lista = businessDelegatorView.findByCriteriaInNumeroEje(condicion, null, null);
				selectNumeroEje = new SelectItem[lista.size()];

				int i = 0;
				for (NumeroEje numeroEje : lista) {
					selectNumeroEje[i] = new SelectItem(numeroEje.getNumEjeId(), numeroEje.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNumeroEje;
	}

	public void setselectNumeroEje(SelectItem[] selectNumeroEje) {
		this.selectNumeroEje = selectNumeroEje;
	}

	public SelectItem[] getselectFabricanteEquipo() {

		if (fabricanteEquipo == null || fabricanteEquipo.size() == 0) {

			fabricanteEquipo = new ArrayList<FabricanteEquipo>();

			try {

				fabricanteEquipo = businessDelegatorView.getFabricanteEquipo(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FabricanteEquipo> lista = businessDelegatorView.findByCriteriaInFabricanteEquipo(condicion, null,
						null);
				selectFabricanteEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (FabricanteEquipo fabricanteEquipo : lista) {
					selectFabricanteEquipo[i] = new SelectItem(fabricanteEquipo.getFabricEquipId(),
							fabricanteEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFabricanteEquipo;
	}

	public void setselectFabricanteEquipo(SelectItem[] selectFabricanteEquipo) {
		this.selectFabricanteEquipo = selectFabricanteEquipo;
	}

	public SelectItem[] getselectTransportadora() {

		if (transportadora == null || transportadora.size() == 0) {

			transportadora = new ArrayList<Transportadora>();

			try {

				transportadora = businessDelegatorView.getTransportadora(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Transportadora> lista = businessDelegatorView.findByCriteriaInTransportadora(condicion, null,
						null);
				selectTransportadora = new SelectItem[lista.size()];

				int i = 0;
				for (Transportadora transportadora : lista) {
					selectTransportadora[i] = new SelectItem(transportadora.getTranspId(), transportadora.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTransportadora;
	}

	public void setselectTransportadora(SelectItem[] selectTransportadora) {
		this.selectTransportadora = selectTransportadora;
	}

	public SelectItem[] getselectConductor() {

		if (conductor == null || conductor.size() == 0) {

			conductor = new ArrayList<Conductor>();

			try {

				conductor = businessDelegatorView.getConductor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Conductor> lista = businessDelegatorView.findByCriteriaInConductor(condicion, null, null);
				selectConductor = new SelectItem[lista.size()];

				int i = 0;
				for (Conductor conductor : lista) {
					selectConductor[i] = new SelectItem(conductor.getConductorId(), conductor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConductor;
	}

	public void setselectConductor(SelectItem[] selectConductor) {
		this.selectConductor = selectConductor;
	}

}
