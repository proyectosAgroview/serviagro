package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.Nivel3DTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class Nivel3View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel3View.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtPrecision;
	
	private InputText txtNombre;
	// private InputText txtNivel2Id_Nivel2;
	// private InputText txtTrabId_Trabajador;
	private InputText txtNivel3Id;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	// private List<Nivel3DTO> data;
	private LazyDataModel<Nivel3DTO> data;
	private Nivel3DTO selectedNivel3;
	private Nivel3 entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private InputText txtCodigoAlternativo;

	private MapModel simpleModel;

	private Marker marker;
	private int activeTapIndex = 0;

	public Nivel3View() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			Nivel3DTO nivel3DTO = (Nivel3DTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(nivel3DTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(nivel3DTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(nivel3DTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(nivel3DTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(nivel3DTO.getInfoAdicional2());

			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(nivel3DTO.getLatitud());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(nivel3DTO.getLongitud());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(nivel3DTO.getNombre());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(nivel3DTO.getPrecision());

			if (txtNivel2Id_Nivel2 == null) {
				txtNivel2Id_Nivel2 = new SelectOneMenu();
			}

			txtNivel2Id_Nivel2.setValue(nivel3DTO.getNivel2Id_Nivel2());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(nivel3DTO.getTrabId_Trabajador());

			if (txtNivel3Id == null) {
				txtNivel3Id = new InputText();
			}

			txtNivel3Id.setValue(nivel3DTO.getNivel3Id());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(nivel3DTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(nivel3DTO.getFechaModificacion());

			Long nivel3Id = FacesUtils.checkLong(txtNivel3Id);
			entity = businessDelegatorView.getNivel3(nivel3Id);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedNivel3 = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedNivel3 = null;
		PrimeFaces.current().resetInputs(":dialogNivel3 :frm");
		activeTapIndex = 0;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtCodigoAlternativo != null) {
			txtCodigoAlternativo.setValue(null);
			txtCodigoAlternativo.setDisabled(true);
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

		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(true);
		}


		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
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

	public MapModel getSimpleModel() {

		simpleModel = new DefaultMapModel();
		LatLng coord1 = new LatLng(3.6374489, -76.2900103);

		if ((Float) txtLatitud.getValue() != null && (Float) txtLongitud.getValue() != null) {
			// Shared coordinates
			coord1 = new LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
			// Basic marker
			simpleModel.addOverlay(new Marker(coord1, (String) txtNombre.getValue()));
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
			Long nivel3Id = FacesUtils.checkLong(txtNivel3Id);
			entity = (nivel3Id != null) ? businessDelegatorView.getNivel3(nivel3Id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setDisabled(false);
			txtLongitud.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtNivel2Id_Nivel2.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtNivel3Id.setDisabled(false);
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
			txtLatitud.setValue(entity.getLatitud());
			txtLatitud.setDisabled(false);
			txtLongitud.setValue(entity.getLongitud());
			txtLongitud.setDisabled(false);
			txtPrecision.setValue(entity.getPrecision());
			txtPrecision.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			
			txtNivel2Id_Nivel2.setValue(entity.getNivel2().getNivel2Id());
			txtNivel2Id_Nivel2.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(true);
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
			List<Nivel3> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInNivel3(condicion, null, null)
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
			txtCodigoAlternativo.setDisabled(false);

			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setDisabled(false);
			txtLongitud.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtNivel2Id_Nivel2.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
			txtCodigoAlternativo.setDisabled(false);

			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setValue(entity.getLatitud());
			txtLatitud.setDisabled(false);
			txtLongitud.setValue(entity.getLongitud());
			txtLongitud.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtPrecision.setValue(entity.getPrecision());
			txtPrecision.setDisabled(false);
			txtNivel2Id_Nivel2.setValue(entity.getNivel2().getNivel2Id());
			txtNivel2Id_Nivel2.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedNivel3 = (Nivel3DTO) (evt.getComponent().getAttributes().get("selectedNivel3"));
		try {

			String codigo = selectedNivel3.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Nivel3> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInNivel3(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
				txtCodigoAlternativo.setDisabled(false);

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
				txtLatitud.setValue(entity.getLatitud());
				txtLatitud.setDisabled(false);
				txtLongitud.setValue(entity.getLongitud());
				txtLongitud.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtPrecision.setValue(entity.getPrecision());
				txtPrecision.setDisabled(false);
				txtNivel2Id_Nivel2.setValue(entity.getNivel2().getNivel2Id());
				txtNivel2Id_Nivel2.setDisabled(false);
				txtTrabId_Trabajador.setValue(entity.getTrabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtNivel3Id.setValue(entity.getNivel3Id());
				txtNivel3Id.setDisabled(true);
				btnSave.setDisabled(false);
				activeTapIndex = 0;
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedNivel3 == null) && (entity == null)) {
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
			entity = new Nivel3();

			// Long nivel3Id = FacesUtils.checkLong(txtNivel3Id);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));

			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			
			// entity.setNivel3Id(nivel3Id);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNivel2((FacesUtils.checkLong(txtNivel2Id_Nivel2) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id_Nivel2)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			businessDelegatorView.saveNivel3(entity);
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
				Long nivel3Id = new Long(selectedNivel3.getNivel3Id());
				entity = businessDelegatorView.getNivel3(nivel3Id);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));

			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setNivel2((FacesUtils.checkLong(txtNivel2Id_Nivel2) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id_Nivel2)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			businessDelegatorView.updateNivel3(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedNivel3 = (Nivel3DTO) (evt.getComponent().getAttributes().get("selectedNivel3"));

			Long nivel3Id = new Long(selectedNivel3.getNivel3Id());
			entity = businessDelegatorView.getNivel3(nivel3Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long nivel3Id = FacesUtils.checkLong(txtNivel3Id);
			entity = businessDelegatorView.getNivel3(nivel3Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteNivel3(entity);
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
			selectedNivel3 = (Nivel3DTO) (evt.getComponent().getAttributes().get("selectedNivel3"));

			Long nivel3Id = new Long(selectedNivel3.getNivel3Id());
			entity = businessDelegatorView.getNivel3(nivel3Id);
			businessDelegatorView.deleteNivel3(entity);
			((Map<String, Object>) data).remove(selectedNivel3);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, String latitud, String longitud,
			Long nivel3Id, String nombre, String precision, Long nivel2Id_Nivel2, Long trabId_Trabajador)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			businessDelegatorView.updateNivel3(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("Nivel3View").requestRender();
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

	public InputText getTxtCodigoAlternativo() {
		return txtCodigoAlternativo;
	}

	public void setTxtCodigoAlternativo(InputText txtCodigoAlternativo) {
		this.txtCodigoAlternativo = txtCodigoAlternativo;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public SelectOneMenu getTxtNivel2Id_Nivel2() {
		return txtNivel2Id_Nivel2;
	}

	public void setTxtNivel2Id_Nivel2(SelectOneMenu txtNivel2Id_Nivel2) {
		this.txtNivel2Id_Nivel2 = txtNivel2Id_Nivel2;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
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

	public InputText getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(InputText txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
	}

	public LazyDataModel<Nivel3DTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataNivel3();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<Nivel3DTO> nivel3DTO) {
		this.data = nivel3DTO;
	}

	public Nivel3DTO getSelectedNivel3() {
		return selectedNivel3;
	}

	public void setSelectedNivel3(Nivel3DTO nivel3) {
		this.selectedNivel3 = nivel3;
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

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				trabajador = businessDelegatorView.getTrabajador(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "profesion.funciones", true, "Supervisor", "="

				};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajador[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajador;
	}

	public void setselectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getselectNivel2() {

		if (nivel2 == null || nivel2.size() == 0) {

			nivel2 = new ArrayList<Nivel2>();

			try {

				nivel2 = businessDelegatorView.getNivel2(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2 : lista) {
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2;
	}

	public void setselectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	private class LocalDataModelDTO extends LazyDataModel<Nivel3DTO> {
		private static final long serialVersionUID = 1L;
		private List<Nivel3DTO> nivel3DTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<Nivel3DTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				nivel3DTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberNivel3(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return nivel3DTO;

		}

		@Override
		public Nivel3DTO getRowData(String rowKey) {
			for (Nivel3DTO nivel3DTOtmp : nivel3DTO) {
				if (nivel3DTOtmp.getNivel3Id().toString().equals(rowKey))
					return nivel3DTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(Nivel3DTO nivel3DTOtmp) {
			return nivel3DTOtmp.getNivel3Id();
		}

	}

	private List<Nivel3DTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageNivel3(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

}
