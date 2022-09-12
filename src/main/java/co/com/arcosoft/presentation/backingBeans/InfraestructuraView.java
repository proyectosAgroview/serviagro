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
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.TarifaInfraestructura;
import co.com.arcosoft.modelo.TipoInfraestructura;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.InfraestructuraDTO;
import co.com.arcosoft.modelo.dto.TarifaInfraestructuraDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InfraestructuraView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InfraestructuraView.class);
	private SelectOneMenu txtAbastecimiento;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtNombre;
	private InputText txtFoto;
	private InputText txtPrecision;
	// private InputText txtTipoInfraId_TipoInfraestructura;
	private InputText txtInfraId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<InfraestructuraDTO> data;
	private InfraestructuraDTO selectedInfraestructura;
	private Infraestructura entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtTipoInfraId_TipoInfraestructura;
	SelectItem[] selectTipoInfraestructura;
	private List<TipoInfraestructura> tipoInfraestructura;

	private String txtImagenInfraestructura;
	private String imagenInfraestructura;
	private UploadedFile file;
	private MapModel simpleModel;

	private Marker marker;

	/*** Pestaña tarifa infraestructura */

	private InputText txtTarInfraId;
	private InputText txtInfraId_Infraestructura;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private InputText txtValor;
	private CommandButton btnAgregar;

	private List<TarifaInfraestructuraDTO> dataTarifaInfraestructura;
	private TarifaInfraestructuraDTO selectedTarifaInfraestructura;
	private TarifaInfraestructura entityTarifa;

	public InfraestructuraView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			InfraestructuraDTO infraestructuraDTO = (InfraestructuraDTO) e.getObject();

			if (txtAbastecimiento == null) {
				txtAbastecimiento = new SelectOneMenu();
			}

			txtAbastecimiento.setValue(infraestructuraDTO.getAbastecimiento());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(infraestructuraDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(infraestructuraDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(infraestructuraDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(infraestructuraDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(infraestructuraDTO.getInfoAdicional2());

			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(infraestructuraDTO.getLatitud());

			if (txtFoto == null) {
				txtFoto = new InputText();
			}

			txtFoto.setValue(infraestructuraDTO.getFoto());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(infraestructuraDTO.getLongitud());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(infraestructuraDTO.getNombre());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(infraestructuraDTO.getPrecision());

			if (txtTipoInfraId_TipoInfraestructura == null) {
				txtTipoInfraId_TipoInfraestructura = new SelectOneMenu();
			}

			txtTipoInfraId_TipoInfraestructura.setValue(infraestructuraDTO.getTipoInfraId_TipoInfraestructura());

			if (txtInfraId == null) {
				txtInfraId = new InputText();
			}

			txtInfraId.setValue(infraestructuraDTO.getInfraId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(infraestructuraDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(infraestructuraDTO.getFechaModificacion());

			Long infraId = FacesUtils.checkLong(txtInfraId);
			entity = businessDelegatorView.getInfraestructura(infraId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public void onCellEdit(CellEditEvent event) throws Exception {

		selectedTarifaInfraestructura = (TarifaInfraestructuraDTO) (event.getComponent().getAttributes()
				.get("selectedTarifaId"));

		Long tarifaId = selectedTarifaInfraestructura.getTarInfraId().longValue();
		String columnaCell = event.getColumn().getHeaderText();
		Long infraId = FacesUtils.checkLong(txtInfraId);

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityTarifa = null;
			Date fechaModificacion = new Date();

			entityTarifa = businessDelegatorView.getTarifaInfraestructura(tarifaId);

			if (columnaCell.equals("Fecha inicial")) {

				entityTarifa.setFechaInicial((Date) newValue);

			} else if (columnaCell.equals("Fecha final")) {

				entityTarifa.setFechaFinal((Date) newValue);

			} else if (columnaCell.equals("Valor")) {

				Double valor = new Double(event.getNewValue().toString());

				entityTarifa.setValor(valor);

			}

			entity = businessDelegatorView.getInfraestructura(infraId);
			entityTarifa.setInfraestructura(entity);
			entityTarifa.setFechaModificacion(fechaModificacion);
			businessDelegatorView.updateTarifaInfraestructura(entityTarifa);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataTarifaInfraestructura = null;
			entity = null;
			entityTarifa = null;
			selectedTarifaInfraestructura = null;

			dataTarifaInfraestructura = businessDelegatorView.getDataInfraestructuraByTarifaId(infraId);

		}

	}

	public String action_new() {
		action_clear();
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedInfraestructura = null;
		dataTarifaInfraestructura = null;
		PrimeFaces.current().resetInputs(":dialogInfraestructura :frm");

		if (txtAbastecimiento != null) {
			txtAbastecimiento.setValue(null);
			txtAbastecimiento.setDisabled(true);
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

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtFoto != null) {
			txtFoto.setValue(null);
			txtFoto.setDisabled(true);
		}

		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtTipoInfraId_TipoInfraestructura != null) {
			txtTipoInfraId_TipoInfraestructura.setValue(null);
			txtTipoInfraId_TipoInfraestructura.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtInfraId != null) {
			txtInfraId.setValue(null);
			txtInfraId.setDisabled(false);
		}

		/* Pestaña tarifa */

		if (txtTarInfraId != null) {
			txtTarInfraId.setValue(null);
			txtTarInfraId.setDisabled(true);
		}

		if (txtInfraId_Infraestructura != null) {
			txtInfraId_Infraestructura.setValue(null);
			txtInfraId_Infraestructura.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(true);
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
			Long infraId = FacesUtils.checkLong(txtInfraId);
			entity = (infraId != null) ? businessDelegatorView.getInfraestructura(infraId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtAbastecimiento.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setDisabled(false);
			txtLongitud.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtTipoInfraId_TipoInfraestructura.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtInfraId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAbastecimiento.setValue(entity.getAbastecimiento());
			txtAbastecimiento.setDisabled(false);
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
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtPrecision.setValue(entity.getPrecision());
			txtPrecision.setDisabled(false);
			txtTipoInfraId_TipoInfraestructura.setValue(entity.getTipoInfraestructura().getTipoInfraId());
			txtTipoInfraId_TipoInfraestructura.setDisabled(false);
			txtInfraId.setValue(entity.getInfraId());
			txtInfraId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Infraestructura> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInInfraestructura(condicion, null, null) : null;

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
			txtAbastecimiento.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setDisabled(false);
			txtLongitud.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtTipoInfraId_TipoInfraestructura.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
		/*	String urlImageDefauld = "defauldImagen.png";
			txtImagenInfraestructura = urlImageDefauld;
			imagenInfraestructura = "default.jpg";
*/
			/** Tarifa **/

			txtInfraId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAbastecimiento.setValue(entity.getAbastecimiento());
			txtAbastecimiento.setDisabled(false);
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
	//		imagenInfraestructura = entity.getFoto();
			txtLatitud.setValue(entity.getLatitud());
			txtLatitud.setDisabled(false);
			txtLongitud.setValue(entity.getLongitud());
			txtLongitud.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtPrecision.setValue(entity.getPrecision());
			txtPrecision.setDisabled(false);
			txtTipoInfraId_TipoInfraestructura.setValue(entity.getTipoInfraestructura().getTipoInfraId());
			txtTipoInfraId_TipoInfraestructura.setDisabled(false);
			txtInfraId.setValue(entity.getInfraId());

	/*		Long infraId = FacesUtils.checkLong(txtInfraId);
			dataTarifaInfraestructura = null;
			dataTarifaInfraestructura = businessDelegatorView.getDataInfraestructuraByTarifaId(infraId);
*/
			txtInfraId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedInfraestructura = (InfraestructuraDTO) (evt.getComponent().getAttributes()
 				.get("selectedInfraestructura"));
		try {

			String codigo = selectedInfraestructura.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Infraestructura> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInInfraestructura(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtAbastecimiento.setValue(entity.getAbastecimiento());
				txtAbastecimiento.setDisabled(false);
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
			//	imagenInfraestructura = ((entity.getFoto() != null && !entity.getFoto().equals("")) ? entity.getFoto()
				///		: "default.jpg");
				txtLatitud.setValue(entity.getLatitud());
				txtLatitud.setDisabled(false);
				txtLongitud.setValue(entity.getLongitud());
				txtLongitud.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtPrecision.setValue(entity.getPrecision());
				txtPrecision.setDisabled(false);
				txtTipoInfraId_TipoInfraestructura
						.setValue(selectedInfraestructura.getTipoInfraId_TipoInfraestructura());
				txtTipoInfraId_TipoInfraestructura.setDisabled(false);
				txtInfraId.setValue(entity.getInfraId());
				txtInfraId.setDisabled(true);

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
			if ((selectedInfraestructura == null) && (entity == null)) {
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
			entity = new Infraestructura();
			Date date = new Date();
			// Long infraId = FacesUtils.checkLong(txtInfraId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setAbastecimiento(FacesUtils.checkString(txtAbastecimiento));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setInfraId(infraId);
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}

			entity.setTipoInfraestructura(
					(FacesUtils.checkLong(txtTipoInfraId_TipoInfraestructura) != null) ? businessDelegatorView
							.getTipoInfraestructura(FacesUtils.checkLong(txtTipoInfraId_TipoInfraestructura)) : null);

			businessDelegatorView.saveInfraestructura(entity, dataTarifaInfraestructura);
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
				Long infraId = new Long(selectedInfraestructura.getInfraId());
				entity = businessDelegatorView.getInfraestructura(infraId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setAbastecimiento(FacesUtils.checkString(txtAbastecimiento));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}
			entity.setTipoInfraestructura(
					(FacesUtils.checkLong(txtTipoInfraId_TipoInfraestructura) != null) ? businessDelegatorView
							.getTipoInfraestructura(FacesUtils.checkLong(txtTipoInfraId_TipoInfraestructura)) : null);
			businessDelegatorView.updateInfraestructura(entity, dataTarifaInfraestructura);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedInfraestructura = (InfraestructuraDTO) (evt.getComponent().getAttributes()
					.get("selectedInfraestructura"));

			Long infraId = new Long(selectedInfraestructura.getInfraId());
			entity = businessDelegatorView.getInfraestructura(infraId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long infraId = FacesUtils.checkLong(txtInfraId);
			entity = businessDelegatorView.getInfraestructura(infraId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteInfraestructura(entity);
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
			selectedInfraestructura = (InfraestructuraDTO) (evt.getComponent().getAttributes()
					.get("selectedInfraestructura"));

			Long infraId = new Long(selectedInfraestructura.getInfraId());
			entity = businessDelegatorView.getInfraestructura(infraId);
			businessDelegatorView.deleteInfraestructura(entity);
			data.remove(selectedInfraestructura);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String abastecimiento, String codigo, Long compania, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, Long infraId,
			String latitud, String longitud, String nombre, String precision, String foto,
			Long tipoInfraId_TipoInfraestructura) throws Exception {
		try {
			entity.setAbastecimiento(FacesUtils.checkString(abastecimiento));
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
			entity.setFoto(FacesUtils.checkString(foto));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			businessDelegatorView.updateInfraestructura(entity, dataTarifaInfraestructura);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("InfraestructuraView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public void action_agregarTarifa() {
		if (txtFechaInicial.getValue() != null && txtFechaFinal.getValue() != null && txtValor.getValue() != null

		) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();
			Double valor = FacesUtils.checkDouble(txtValor);

			if (dataTarifaInfraestructura == null) {
				dataTarifaInfraestructura = new ArrayList<TarifaInfraestructuraDTO>();
			}

			TarifaInfraestructuraDTO tarifaInfraestructuraDTO = new TarifaInfraestructuraDTO();
			tarifaInfraestructuraDTO.setFechaInicial(fechaInicial);
			tarifaInfraestructuraDTO.setFechaFinal(fechaFinal);
			tarifaInfraestructuraDTO.setValor(valor);
			tarifaInfraestructuraDTO.setFechaCreacion(fechaCreacion);
			tarifaInfraestructuraDTO.setFechaModificacion(fechaModificacion);

			dataTarifaInfraestructura.add(tarifaInfraestructuraDTO);

			fechaInicial = null;
			fechaFinal = null;
			fechaCreacion = null;
			fechaModificacion = null;
			valor = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial y final, labor,   tarifa tengan valores. "));
		}
	}

	public String actionDeleteTarifa(ActionEvent evt) {

		try {

			selectedTarifaInfraestructura = (TarifaInfraestructuraDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifa"));

			if (selectedTarifaInfraestructura.getTarInfraId() == null) {
				dataTarifaInfraestructura.remove(selectedTarifaInfraestructura);
			} else {
				Long tarifaId = new Long(selectedTarifaInfraestructura.getTarInfraId());
				TarifaInfraestructura entity = businessDelegatorView.getTarifaInfraestructura(tarifaId);
				businessDelegatorView.deleteTarifaInfraestructura(entity);
				dataTarifaInfraestructura.remove(selectedTarifaInfraestructura);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public SelectOneMenu getTxtAbastecimiento() {
		return txtAbastecimiento;
	}

	public void setTxtAbastecimiento(SelectOneMenu txtAbastecimiento) {
		this.txtAbastecimiento = txtAbastecimiento;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtFoto() {
		return txtFoto;
	}

	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
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

	public SelectOneMenu getTxtTipoInfraId_TipoInfraestructura() {
		return txtTipoInfraId_TipoInfraestructura;
	}

	public void setTxtTipoInfraId_TipoInfraestructura(SelectOneMenu txtTipoInfraId_TipoInfraestructura) {
		this.txtTipoInfraId_TipoInfraestructura = txtTipoInfraId_TipoInfraestructura;
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

	public InputText getTxtInfraId() {
		return txtInfraId;
	}

	public void setTxtInfraId(InputText txtInfraId) {
		this.txtInfraId = txtInfraId;
	}

	public List<InfraestructuraDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataInfraestructura();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<InfraestructuraDTO> infraestructuraDTO) {
		this.data = infraestructuraDTO;
	}

	public InfraestructuraDTO getSelectedInfraestructura() {
		return selectedInfraestructura;
	}

	public void setSelectedInfraestructura(InfraestructuraDTO infraestructura) {
		this.selectedInfraestructura = infraestructura;
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

	public SelectItem[] getSelectTipoInfraestructura() {

		if (tipoInfraestructura == null || tipoInfraestructura.size() == 0) {

			tipoInfraestructura = new ArrayList<TipoInfraestructura>();

			try {

				tipoInfraestructura = businessDelegatorView.getTipoInfraestructura(); // Fin
																						// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoInfraestructura> lista = businessDelegatorView.findByCriteriaInTipoInfraestructura(condicion,
						null, null);
				selectTipoInfraestructura = new SelectItem[lista.size()];

				int i = 0;
				for (TipoInfraestructura tipoInfraestructura : lista) {
					selectTipoInfraestructura[i] = new SelectItem(tipoInfraestructura.getTipoInfraId(),
							tipoInfraestructura.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoInfraestructura;
	}

	public void setSelectTipoInfraestructura(SelectItem[] selectTipoInfraestructura) {
		this.selectTipoInfraestructura = selectTipoInfraestructura;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		if (file != null) {
			this.txtImagenInfraestructura = file.getFileName();
		}
	}

	public String getTxtImagenInfraestructura() {
		return txtImagenInfraestructura;
	}

	public void setTxtImagenInfraestructura(String txtImagenInfraestructura) {
		this.txtImagenInfraestructura = txtImagenInfraestructura;
	}

	public String getimagenInfraestructura() {
		return imagenInfraestructura;
	}

	public void setImagenInfraestructura(String imagenInfraestructura) {
		this.imagenInfraestructura = imagenInfraestructura;
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

			imagenInfraestructura = fileName;

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

	public InputText getTxtTarInfraId() {
		return txtTarInfraId;
	}

	public InputText getTxtInfraId_Infraestructura() {
		return txtInfraId_Infraestructura;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public InputText getTxtValor() {
		return txtValor;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setTxtTarInfraId(InputText txtTarInfraId) {
		this.txtTarInfraId = txtTarInfraId;
	}

	public void setTxtInfraId_Infraestructura(InputText txtInfraId_Infraestructura) {
		this.txtInfraId_Infraestructura = txtInfraId_Infraestructura;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<TarifaInfraestructuraDTO> getDataTarifaInfraestructura() {

		if (dataTarifaInfraestructura == null || dataTarifaInfraestructura.size() == 0) {

			return null;

		} else {

			return dataTarifaInfraestructura;

		}

	}

	public TarifaInfraestructuraDTO getSelectedTarifaInfraestructura() {
		return selectedTarifaInfraestructura;
	}

	public void setDataTarifaInfraestructura(List<TarifaInfraestructuraDTO> dataTarifaInfraestructura) {
		this.dataTarifaInfraestructura = dataTarifaInfraestructura;
	}

	public void setSelectedTarifaInfraestructura(TarifaInfraestructuraDTO selectedTarifaInfraestructura) {
		this.selectedTarifaInfraestructura = selectedTarifaInfraestructura;
	}
	
	

}
