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
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.EstructSiemb;
import co.com.arcosoft.modelo.MotElim;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.EstructSiembDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EstructSiembView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EstructSiembView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtEliminada;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	// private InputText txtNivel1Id;
	// private InputText txtNivel2Id;
	// private InputText txtNivel3Id;
	// private InputText txtMotElimId_MotElim;
	// private InputText txtNivel4Id_Nivel4;
	private InputText txtEstrSiembId;
	private Spinner txtLinea;
	private Spinner txtPlanta;
	private InputText txtPrecision;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EstructSiembDTO> data;
	private EstructSiembDTO selectedEstructSiemb;
	private EstructSiemb entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private MapModel simpleModel;

	private Marker marker;

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtMotElimId_MotElim;
	SelectItem[] selectMotElimId;
	private List<MotElim> motElim;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	public EstructSiembView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			EstructSiembDTO estructSiembDTO = (EstructSiembDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(estructSiembDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(estructSiembDTO.getCompania());

			if (txtEliminada == null) {
				txtEliminada = new InputText();
			}

			txtEliminada.setValue(estructSiembDTO.getEliminada());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(estructSiembDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(estructSiembDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(estructSiembDTO.getLatitud());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(estructSiembDTO.getLongitud());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(estructSiembDTO.getPrecision());

			if (txtLinea == null) {
				txtLinea = new Spinner();
			}

			txtLinea.setValue(estructSiembDTO.getLinea());

			if (txtPlanta == null) {
				txtPlanta = new Spinner();
			}

			txtPlanta.setValue(estructSiembDTO.getPlanta());

			txtInfoAdicional2.setValue(estructSiembDTO.getInfoAdicional2());

			if (txtNivel1Id == null) {
				txtNivel1Id = new SelectOneMenu();
			}

			txtNivel1Id.setValue(estructSiembDTO.getNivel1Id());

			if (txtNivel2Id == null) {
				txtNivel2Id = new SelectOneMenu();
			}

			txtNivel2Id.setValue(estructSiembDTO.getNivel2Id());

			if (txtNivel3Id == null) {
				txtNivel3Id = new SelectOneMenu();
			}

			txtNivel3Id.setValue(estructSiembDTO.getNivel3Id());

			if (txtMotElimId_MotElim == null) {
				txtMotElimId_MotElim = new SelectOneMenu();
			}

			txtMotElimId_MotElim.setValue(estructSiembDTO.getMotElimId_MotElim());

			if (txtNivel4Id_Nivel4 == null) {
				txtNivel4Id_Nivel4 = new SelectOneMenu();
			}

			txtNivel4Id_Nivel4.setValue(estructSiembDTO.getNivel4Id_Nivel4());

			if (txtEstrSiembId == null) {
				txtEstrSiembId = new InputText();
			}

			txtEstrSiembId.setValue(estructSiembDTO.getEstrSiembId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(estructSiembDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(estructSiembDTO.getFechaModificacion());

			Long estrSiembId = FacesUtils.checkLong(txtEstrSiembId);
			entity = businessDelegatorView.getEstructSiemb(estrSiembId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedEstructSiemb = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedEstructSiemb = null;
		PrimeFaces.current().resetInputs(":dialogEstructSiemb :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEliminada != null) {
			txtEliminada.setValue(null);
			txtEliminada.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(false);
		}

		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(false);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(false);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(false);
		}
		if (txtLinea != null) {
			txtLinea.setValue(null);
			txtLinea.setDisabled(false);
		}

		if (txtPlanta != null) {
			txtPlanta.setValue(null);
			txtPlanta.setDisabled(false);
		}

		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtMotElimId_MotElim != null) {
			txtMotElimId_MotElim.setValue(null);
			txtMotElimId_MotElim.setDisabled(true);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtEstrSiembId != null) {
			txtEstrSiembId.setValue(null);
			txtEstrSiembId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
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

	public MapModel getSimpleModel() {

		simpleModel = new DefaultMapModel();
		LatLng coord1 = new LatLng(3.6374489, -76.2900103);

		if ((Float) txtLatitud.getValue() != null && (Float) txtLongitud.getValue() != null) {
			// Shared coordinates
			coord1 = new LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
			// Basic marker
			simpleModel.addOverlay(new Marker(coord1, (String) txtCodigo.getValue()));
		} else {
			// Shared coordinates
			coord1 = new LatLng(3, 79);
			// Basic marker
			simpleModel.addOverlay(new Marker(coord1, "SIN DEFINIR"));
		}

		return simpleModel;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
	}

	public Marker getMarker() {
		return marker;
	}

	public void listener_txtId() {
		try {
			Long estrSiembId = FacesUtils.checkLong(txtEstrSiembId);
			entity = (estrSiembId != null) ? businessDelegatorView.getEstructSiemb(estrSiembId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEliminada.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtMotElimId_MotElim.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtEstrSiembId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEliminada.setValue(entity.getEliminada());
			txtEliminada.setDisabled(false);
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
			txtNivel1Id.setValue(entity.getNivel1Id());
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id());
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(false);
			txtMotElimId_MotElim.setValue(entity.getMotElim());
			txtMotElimId_MotElim.setDisabled(false);
			txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
			txtNivel4Id_Nivel4.setDisabled(false);
			txtEstrSiembId.setValue(entity.getEstrSiembId());
			txtEstrSiembId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedEstructSiemb = (EstructSiembDTO) (evt.getComponent().getAttributes().get("selectedEstructSiemb"));
		try {

			String codigo = selectedEstructSiemb.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<EstructSiemb> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInEstructSiemb(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				// txtCodigo.setValue(entity.getCodigo());
				// txtCodigo.setDisabled(true);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				// txtEliminada.setValue(entity.getEliminada());
				// txtEliminada.setDisabled(true);
				txtLatitud.setValue(entity.getLatitud());
				txtLatitud.setDisabled(false);
				txtLongitud.setValue(entity.getLongitud());
				txtLongitud.setDisabled(false);
				txtPrecision.setValue(entity.getPrecision());
				txtPrecision.setDisabled(false);
				txtLinea.setValue(entity.getLinea());
				txtLinea.setDisabled(false);
				txtPlanta.setValue(entity.getPlanta());
				txtPlanta.setDisabled(false);
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
				txtNivel1Id.setValue(entity.getNivel1Id());
				txtNivel1Id.setDisabled(false);
				txtNivel2Id.setValue(entity.getNivel2Id());
				txtNivel2Id.setDisabled(false);
				txtNivel3Id.setValue(entity.getNivel3Id());
				txtNivel3Id.setDisabled(false);
				// txtMotElimId_MotElim.setValue(selectedEstructSiemb
				// .getMotElimId_MotElim());
				// txtMotElimId_MotElim.setDisabled(true);
				txtNivel4Id_Nivel4.setValue(selectedEstructSiemb.getNivel4Id_Nivel4());
				txtNivel4Id_Nivel4.setDisabled(false);
				txtEstrSiembId.setValue(entity.getEstrSiembId());
				txtEstrSiembId.setDisabled(true);
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
			if ((selectedEstructSiemb == null) && (entity == null)) {
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
			entity = new EstructSiemb();

			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setCompania(compania);
			entity.setEliminada(FacesUtils.checkLong(txtEliminada));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setLinea(FacesUtils.checkLong(txtLinea));
			entity.setPlanta(FacesUtils.checkLong(txtPlanta));
			entity.setCodigo(FacesUtils.checkString(txtLinea) + '-' + FacesUtils.checkString(txtPlanta));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel2Id(FacesUtils.checkLong(txtNivel2Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setMotElim((FacesUtils.checkLong(txtMotElimId_MotElim)));
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			businessDelegatorView.saveEstructSiemb(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	private String to_string(Long linea) {
		return null;
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long estrSiembId = new Long(selectedEstructSiemb.getEstrSiembId());
				entity = businessDelegatorView.getEstructSiemb(estrSiembId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			entity.setEliminada(FacesUtils.checkLong(txtEliminada));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setLinea(FacesUtils.checkLong(txtLinea));
			entity.setPlanta(FacesUtils.checkLong(txtPlanta));
			entity.setCodigo(FacesUtils.checkString(txtLinea) + '-' + FacesUtils.checkString(txtPlanta));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel2Id(FacesUtils.checkLong(txtNivel2Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setMotElim((FacesUtils.checkLong(txtMotElimId_MotElim)));
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			businessDelegatorView.updateEstructSiemb(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedEstructSiemb = (EstructSiembDTO) (evt.getComponent().getAttributes().get("selectedEstructSiemb"));

			Long estrSiembId = new Long(selectedEstructSiemb.getEstrSiembId());
			entity = businessDelegatorView.getEstructSiemb(estrSiembId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long estrSiembId = FacesUtils.checkLong(txtEstrSiembId);
			entity = businessDelegatorView.getEstructSiemb(estrSiembId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteEstructSiemb(entity);
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
			selectedEstructSiemb = (EstructSiembDTO) (evt.getComponent().getAttributes().get("selectedEstructSiemb"));

			Long estrSiembId = new Long(selectedEstructSiemb.getEstrSiembId());
			entity = businessDelegatorView.getEstructSiemb(estrSiembId);
			businessDelegatorView.deleteEstructSiemb(entity);
			data.remove(selectedEstructSiemb);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, Long eliminada, String estado, Long estrSiembId,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, Long nivel1Id,
			Long nivel2Id, Long nivel3Id, Long motElimId_MotElim, Long nivel4Id_Nivel4, Long linea, Long planta,
			Float latitud, Float longitud, Float precision) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEliminada(FacesUtils.checkLong(eliminada));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			entity.setLinea(FacesUtils.checkLong(linea));
			entity.setPlanta(FacesUtils.checkLong(planta));
			entity.setNivel1Id(FacesUtils.checkLong(nivel1Id));
			entity.setNivel2Id(FacesUtils.checkLong(nivel2Id));
			entity.setNivel3Id(FacesUtils.checkLong(nivel3Id));
			businessDelegatorView.updateEstructSiemb(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("EstructSiembView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public Spinner getTxtLinea() {
		return txtLinea;
	}

	public void setTxtLinea(Spinner txtLinea) {
		this.txtLinea = txtLinea;
	}

	public Spinner getTxtPlanta() {
		return txtPlanta;
	}

	public void setTxtPlanta(Spinner txtPlanta) {
		this.txtPlanta = txtPlanta;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public InputText getTxtLatitud() {
		return txtLatitud;
	}

	public void setTxtLatitud(InputText txtLatitud) {
		this.txtLatitud = txtLatitud;
	}

	public InputText getTxtLongitud() {
		return txtLongitud;
	}

	public void setTxtLongitud(InputText txtLongitud) {
		this.txtLongitud = txtLongitud;
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

	public InputText getTxtEliminada() {
		return txtEliminada;
	}

	public void setTxtEliminada(InputText txtEliminada) {
		this.txtEliminada = txtEliminada;
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

	public SelectOneMenu getTxtNivel1Id() {
		return txtNivel1Id;
	}

	public void setTxtNivel1Id(SelectOneMenu txtNivel1Id) {
		this.txtNivel1Id = txtNivel1Id;
	}

	public SelectOneMenu getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(SelectOneMenu txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
	}

	public SelectOneMenu getTxtMotElimId_MotElim() {
		return txtMotElimId_MotElim;
	}

	public void setTxtMotElimId_MotElim(SelectOneMenu txtMotElimId_MotElim) {
		this.txtMotElimId_MotElim = txtMotElimId_MotElim;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
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

	public InputText getTxtEstrSiembId() {
		return txtEstrSiembId;
	}

	public void setTxtEstrSiembId(InputText txtEstrSiembId) {
		this.txtEstrSiembId = txtEstrSiembId;
	}

	public List<EstructSiembDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataEstructSiemb();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<EstructSiembDTO> estructSiembDTO) {
		this.data = estructSiembDTO;
	}

	public EstructSiembDTO getSelectedEstructSiemb() {
		return selectedEstructSiemb;
	}

	public void setSelectedEstructSiemb(EstructSiembDTO estructSiemb) {
		this.selectedEstructSiemb = estructSiemb;
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

	public SelectItem[] getselectNivel1() {

		if (nivel1 == null || nivel1.size() == 0) {

			nivel1 = new ArrayList<Nivel1>();

			try {

				nivel1 = businessDelegatorView.getNivel1(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel1> lista = businessDelegatorView.findByCriteriaInNivel1(condicion, null, null);
				selectNivel1 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel1 nivel1 : lista) {
					selectNivel1[i] = new SelectItem(nivel1.getNivel1Id(), nivel1.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel1;
	}

	public void setselectNivel1(SelectItem[] selectNivel1) {
		this.selectNivel1 = selectNivel1;
	}

	public SelectItem[] getselectNivel2() {

		nivel2 = new ArrayList<Nivel2>();

		Long nivel1Id = null;

		if (txtNivel1Id != null && txtNivel1Id.getValue() != null && !txtNivel1Id.getValue().equals("")) {
			nivel1Id = Long.parseLong(txtNivel1Id.getValue().toString());

			try {
				Nivel1 nivel1 = businessDelegatorView.getNivel1(nivel1Id);
				Object[] niveles2 = nivel1.getNivel2s().toArray();

				selectNivel2 = new SelectItem[niveles2.length];

				int i = 0;
				for (Object object : niveles2) {
					Nivel2 nivel2 = (Nivel2) object;
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel2;
	}

	public void setselectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	public SelectItem[] getselectNivel3() {

		nivel3 = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2Id != null && txtNivel2Id.getValue() != null && !txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3 = nivel2.getNivel3s().toArray();

				selectNivel3 = new SelectItem[niveles3.length];

				int i = 0;
				for (Object object : niveles3) {
					Nivel3 nivel3 = (Nivel3) object;
					selectNivel3[i] = new SelectItem(nivel3.getNivel3Id(), nivel3.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3;
	}

	public void setselectNivel3(SelectItem[] selectNivel3) {
		this.selectNivel3 = selectNivel3;
	}

	public SelectItem[] getselectNivel4() {
		nivel4 = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3Id != null && txtNivel3Id.getValue() != null && !txtNivel3Id.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3Id.getValue().toString());

			try {
				Nivel3 nivel3 = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4 = nivel3.getNivel4s().toArray();

				selectNivel4 = new SelectItem[niveles4.length];

				int i = 0;
				for (Object object : niveles4) {
					Nivel4 nivel4 = (Nivel4) object;
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(), nivel4.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4;
	}

	public void setselectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}

	public SelectItem[] getselectMotElimId() {

		if (motElim == null || motElim.size() == 0) {

			motElim = new ArrayList<MotElim>();

			try {

				motElim = businessDelegatorView.getMotElim(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<MotElim> lista = businessDelegatorView.findByCriteriaInMotElim(condicion, null, null);
				selectMotElimId = new SelectItem[lista.size()];

				int i = 0;
				for (MotElim motElimId : lista) {
					selectMotElimId[i] = new SelectItem(motElimId.getMotElimId(), motElimId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMotElimId;
	}

	public void setselectMotElimId(SelectItem[] selectMotElimId) {

		this.selectMotElimId = selectMotElimId;
	}

}
