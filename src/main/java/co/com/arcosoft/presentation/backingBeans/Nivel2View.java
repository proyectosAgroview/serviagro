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
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.FrenteCos;
import co.com.arcosoft.modelo.GrpTenen;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Persempr;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Vereda;
import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.dto.Nivel2DTO;
import co.com.arcosoft.modelo.dto.Nivel2PersemprDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class Nivel2View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel2View.class);
	private InputText txtBarrio;
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtDireccion;
	private InputText txtDistanciaOficina;
	private InputText txtDistanciaPlanta;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtNombre;
	private InputTextarea txtObservacion;
	private InputText txtPbx;
	private InputText txtPrecision;
	private InputText txtTelefono;
	private InputText txtCodigoAlternativo;

	private InputText txtPesoPromedio;
	private SelectOneMenu txtTipoPropiedad;
	/*
	 * private SelectOneMenu txtCentCostId_CentCost; private SelectOneMenu
	 * txtCiudadId_Ciudad; private SelectOneMenu txtFrtCosId_FrenteCos; private
	 * SelectOneMenu txtGrpTenId_GrpTenen; private SelectOneMenu
	 * txtNivel1Id_Nivel1; private SelectOneMenu txtProveId_Proveedor; private
	 * SelectOneMenu txtTrabId_Trabajador; private SelectOneMenu
	 * txtZonaGeograficaId_ZonaGeografica;
	 */
	private InputText txtNivel2Id;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<Nivel2DTO> data;
	// private List<Nivel2DTO> data;
	private Nivel2DTO selectedNivel2;
	private Nivel2 entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private SelectOneMenu txtCiudadId_Ciudad;
	SelectItem[] selectCiudad;
	private List<Ciudad> ciudad;

	private SelectOneMenu txtVereda;
	SelectItem[] selectVereda;
	private List<Vereda> vereda;

	private SelectOneMenu txtFrtCosId_FrenteCos;
	SelectItem[] selectFrenteCos;
	private List<FrenteCos> frenteCos;

	private SelectOneMenu txtGrpTenId_GrpTenen;
	SelectItem[] selectGrpTenen;
	private List<GrpTenen> grpTenen;

	private SelectOneMenu txtNivel1Id_Nivel1;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtProveId_Proveedor;
	SelectItem[] selectProveedor;
	private List<PersEmpr> proveedor;

	private SelectOneMenu txtZonaGeograficaId_ZonaGeografica;
	SelectItem[] selectZonaGeografica;
	private List<ZonaGeografica> zonaGeografica;

	private MapModel simpleModel;

	private Marker marker;

	/*** Pestaña participación ***/

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectPersEmpr;
	private List<PersEmpr> persempr;

	private InputText txtPorcentajeParticipacion;
	private List<Nivel2PersemprDTO> dataNivel2PersEmpr;
	private Nivel2PersemprDTO selectedNivel2PersEmpr;
	private InputText txtCodProveedor;

	private Nivel2Persempr entity2;
	private CommandButton btnAgregar;
	private int activeTapIndex = 0;

	private SelectOneMenu txtEstPluvioId_EstPluvio;
	SelectItem[] selectEstPluvio;
	private List<EstPluvio> estPluvio;
	private Nivel3 entityNivel3;
	public Nivel2View() {
		super();
	}


	public void onCellEdit(CellEditEvent event) throws Exception {

		selectedNivel2PersEmpr = (Nivel2PersemprDTO) (event.getComponent().getAttributes().get("selectedNivel2Id"));
		
		if (selectedNivel2PersEmpr.getId() != null) {

			Long nivel2PersEmprId = selectedNivel2PersEmpr.getId();
			String columnaCell = event.getColumn().getHeaderText();
			Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entity2 = null;
				entity2 = businessDelegatorView.getNivel2Persempr(nivel2PersEmprId);
	
				if (columnaCell.equals("Proveedor")) {
	
					Long id = new Long(event.getNewValue().toString());
					PersEmpr proveedor2 = businessDelegatorView.getPersEmpr(id);
					entity2.setProveedorParticipacion(proveedor2);
	
				} else if (columnaCell.equals("% Participación")) {
	
					Double porcentaje = new Double(event.getNewValue().toString());
					entity2.setProcentajeParticipacion(porcentaje);
	
				}
	
				entity = businessDelegatorView.getNivel2(nivel2Id);
				entity2.setNivel2(entity);
				businessDelegatorView.updateNivel2Persempr(entity2);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public String action_new() {
		action_clear();
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedNivel2 = null;
		PrimeFaces.current().resetInputs(":dialogNivel2 :frm");
		dataNivel2PersEmpr = null;
		selectedNivel2PersEmpr = null;
		activeTapIndex = 0;

		if (txtBarrio != null) {
			txtBarrio.setValue(null);
			txtBarrio.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCodigoAlternativo != null) {
			txtCodigoAlternativo.setValue(null);
			txtCodigoAlternativo.setDisabled(true);
		}

		if (txtVereda != null) {
			txtVereda.setValue(null);
			txtVereda.setDisabled(false);
		}

		if (txtPesoPromedio != null) {
			txtPesoPromedio.setValue(null);
			txtPesoPromedio.setDisabled(false);
		}


		if (txtEstPluvioId_EstPluvio != null) {
			txtEstPluvioId_EstPluvio.setValue(null);
			txtEstPluvioId_EstPluvio.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(true);
		}

		if (txtDistanciaOficina != null) {
			txtDistanciaOficina.setValue(null);
			txtDistanciaOficina.setDisabled(true);
		}

		if (txtDistanciaPlanta != null) {
			txtDistanciaPlanta.setValue(null);
			txtDistanciaPlanta.setDisabled(true);
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

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtPbx != null) {
			txtPbx.setValue(null);
			txtPbx.setDisabled(true);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtTipoPropiedad != null) {
			txtTipoPropiedad.setValue(null);
			txtTipoPropiedad.setDisabled(true);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(true);
		}

		if (txtCiudadId_Ciudad != null) {
			txtCiudadId_Ciudad.setValue(null);
			txtCiudadId_Ciudad.setDisabled(true);
		}

		if (txtFrtCosId_FrenteCos != null) {
			txtFrtCosId_FrenteCos.setValue(null);
			txtFrtCosId_FrenteCos.setDisabled(true);
		}

		if (txtGrpTenId_GrpTenen != null) {
			txtGrpTenId_GrpTenen.setValue(null);
			txtGrpTenId_GrpTenen.setDisabled(true);
		}

		if (txtNivel1Id_Nivel1 != null) {
			txtNivel1Id_Nivel1.setValue(null);
			txtNivel1Id_Nivel1.setDisabled(true);
		}

		if (txtProveId_Proveedor != null) {
			txtProveId_Proveedor.setValue(null);
			txtProveId_Proveedor.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
		}

		if (txtZonaGeograficaId_ZonaGeografica != null) {
			txtZonaGeograficaId_ZonaGeografica.setValue(null);
			txtZonaGeograficaId_ZonaGeografica.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(true);
		}

		if (txtPorcentajeParticipacion != null) {
			txtPorcentajeParticipacion.setValue(null);
			txtPorcentajeParticipacion.setDisabled(true);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(false);
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

	/*
	 * public MapModel getSimpleModel() {
	 * 
	 * simpleModel = new DefaultMapModel(); LatLng coord1 = new
	 * LatLng(3.6374489,-76.2900103);
	 * 
	 * if ((Float) txtLatitud.getValue() != null && (Float)
	 * txtLongitud.getValue() != null ){ //Shared coordinates coord1 = new
	 * LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
	 * //Basic marker simpleModel.addOverlay(new Marker(coord1, (String)
	 * txtNombre.getValue())); }else { //Shared coordinates coord1 = new
	 * LatLng(3, 79); //Basic marker simpleModel.addOverlay(new Marker(coord1,
	 * "SIN DEFINIR")); }
	 * 
	 * return simpleModel; }
	 * 
	 * public void onMarkerSelect(OverlaySelectEvent event) { marker = (Marker)
	 * event.getOverlay();
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected",
	 * marker.getTitle())); }
	 * 
	 * public Marker getMarker() { return marker; }
	 */
	public void listener_txtId() {
		try {
			Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
			entity = (nivel2Id != null) ? businessDelegatorView.getNivel2(nivel2Id) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtBarrio.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCodigoAlternativo.setDisabled(false);

			txtCompania.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtDistanciaOficina.setDisabled(false);
			txtDistanciaPlanta.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setDisabled(false);
			txtLongitud.setDisabled(false);
			txtNombre.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtPbx.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTipoPropiedad.setDisabled(false);
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtFrtCosId_FrenteCos.setDisabled(false);
			txtGrpTenId_GrpTenen.setDisabled(false);
			txtNivel1Id_Nivel1.setDisabled(false);
			txtProveId_Proveedor.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
			txtCodigoAlternativo.setDisabled(false);

			txtBarrio.setValue(entity.getBarrio());
			txtBarrio.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtDistanciaOficina.setValue(entity.getDistanciaOficina());
			txtDistanciaOficina.setDisabled(false);
			txtDistanciaPlanta.setValue(entity.getDistanciaPlanta());
			txtDistanciaPlanta.setDisabled(false);
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
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtPbx.setValue(entity.getPbx());
			txtPbx.setDisabled(false);
			txtPrecision.setValue(entity.getPrecision());
			txtPrecision.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTipoPropiedad.setValue(entity.getTipoPropiedad());
			txtTipoPropiedad.setDisabled(false);
			txtCentCostId_CentCost.setValue(entity.getCentCost());
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtFrtCosId_FrenteCos.setValue(entity.getFrenteCos());
			txtFrtCosId_FrenteCos.setDisabled(false);
			txtGrpTenId_GrpTenen.setValue(entity.getGrpTenen());
			txtGrpTenId_GrpTenen.setDisabled(false);
			txtNivel1Id_Nivel1.setValue(entity.getNivel1().getNivel1Id());
			txtNivel1Id_Nivel1.setDisabled(false);
			txtProveId_Proveedor.setValue(entity.getProveedor());
			txtProveId_Proveedor.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtZonaGeograficaId_ZonaGeografica.setValue(entity.getZonaGeografica());
			txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id());
			txtNivel2Id.setDisabled(true);
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
			List<Nivel2> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInNivel2(condicion, null, null)
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
			txtCodigoAlternativo.setDisabled(false);
			txtEstPluvioId_EstPluvio.setDisabled(false);

			txtBarrio.setDisabled(false);
			txtVereda.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtDistanciaOficina.setDisabled(false);
			txtDistanciaPlanta.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLatitud.setDisabled(false);
			txtLongitud.setDisabled(false);
			txtNombre.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtPesoPromedio.setDisabled(false);
			txtPbx.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTipoPropiedad.setDisabled(false);
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtNivel1Id_Nivel1.setDisabled(false);
			txtProveId_Proveedor.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
			txtPorcentajeParticipacion.setDisabled(false);
			txtPersEmprId.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);

			txtNivel2Id.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstPluvioId_EstPluvio.setValue(entity.getPluvioId().getEstPluvioId());
			txtEstPluvioId_EstPluvio.setDisabled(false);
			txtBarrio.setValue(entity.getBarrio());
			txtBarrio.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
			txtCodigoAlternativo.setDisabled(false);

			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtPesoPromedio.setValue(entity.getPesoPromedio());
			txtPesoPromedio.setDisabled(false);
			txtDistanciaOficina.setValue(entity.getDistanciaOficina());
			txtDistanciaOficina.setDisabled(false);
			txtDistanciaPlanta.setValue(entity.getDistanciaPlanta());
			txtDistanciaPlanta.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtVereda.setValue(entity.getVereda());
			txtVereda.setDisabled(false);
			// if (entity.getLatitud() != null && entity.getLongitud() != null
			// ){
			/*
			 * }else { latitud1 =0; longitud1 =0; }
			 */

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
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtPbx.setValue(entity.getPbx());
			txtPbx.setDisabled(false);
			txtPrecision.setValue(entity.getPrecision());
			txtPrecision.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTipoPropiedad.setValue(entity.getTipoPropiedad());
			txtTipoPropiedad.setDisabled(false);
			txtCentCostId_CentCost.setValue(entity.getCentCost());
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtNivel1Id_Nivel1.setValue(entity.getNivel1().getNivel1Id());
			txtNivel1Id_Nivel1.setDisabled(false);
			txtProveId_Proveedor.setValue(entity.getProveedor().getPersEmprId());
			txtProveId_Proveedor.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtZonaGeograficaId_ZonaGeografica.setValue(entity.getZonaGeografica());
			txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id());

			/*** sesion % participacion ***/

			txtPorcentajeParticipacion.setDisabled(false);
			txtPersEmprId.setDisabled(false);

			dataNivel2PersEmpr = null;
			dataNivel2PersEmpr = businessDelegatorView.getDataNivel2PersemprById(entity.getNivel2Id().longValue());

			txtNivel2Id.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedNivel2 = (Nivel2DTO) (evt.getComponent().getAttributes().get("selectedNivel2"));

		PrimeFaces.current().resetInputs(":dialogNivel2 :frm");

		try {

			String codigo = selectedNivel2.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Nivel2> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInNivel2(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtEstPluvioId_EstPluvio.setValue(selectedNivel2.getPluvioId());
				txtEstPluvioId_EstPluvio.setDisabled(false);
				txtBarrio.setValue(entity.getBarrio());
				txtBarrio.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtVereda.setValue(entity.getVereda());
				txtVereda.setDisabled(false);
				txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
				txtCodigoAlternativo.setDisabled(false);

				// txtCompania.setValue(selectedNivel2.getCompania());
				// txtCompania.setDisabled(false);
				txtDireccion.setValue(entity.getDireccion());
				txtDireccion.setDisabled(false);
				txtDistanciaOficina.setValue(entity.getDistanciaOficina());
				txtDistanciaOficina.setDisabled(false);
				txtDistanciaPlanta.setValue(entity.getDistanciaPlanta());
				txtDistanciaPlanta.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtPesoPromedio.setValue(entity.getPesoPromedio());
				txtPesoPromedio.setDisabled(false);
				// txtFechaCreacion.setValue(selectedNivel2.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedNivel2.getFechaModificacion());
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
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPbx.setValue(entity.getPbx());
				txtPbx.setDisabled(false);
				txtPrecision.setValue(entity.getPrecision());
				txtPrecision.setDisabled(false);
				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				txtTipoPropiedad.setValue(entity.getTipoPropiedad());
				txtTipoPropiedad.setDisabled(false);
				txtCentCostId_CentCost.setValue(entity.getCentCost());
				txtCentCostId_CentCost.setDisabled(false);
				txtCiudadId_Ciudad.setValue(entity.getCiudad());
				txtCiudadId_Ciudad.setDisabled(false);
				txtNivel1Id_Nivel1.setValue(entity.getNivel1().getNivel1Id());
				txtNivel1Id_Nivel1.setDisabled(false);
				txtProveId_Proveedor.setValue(entity.getProveedor().getPersEmprId());
				txtProveId_Proveedor.setDisabled(false);
				txtTrabId_Trabajador.setValue(entity.getTrabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtZonaGeograficaId_ZonaGeografica.setValue(entity.getZonaGeografica());
				txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
				txtNivel2Id.setValue(entity.getNivel2Id());
				txtNivel2Id.setDisabled(true);

				/*** sesion % participacion ***/

				txtPorcentajeParticipacion.setDisabled(false);
				txtPersEmprId.setDisabled(false);

				dataNivel2PersEmpr = null;
				dataNivel2PersEmpr = businessDelegatorView.getDataNivel2PersemprById(entity.getNivel2Id().longValue());

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
			if ((selectedNivel2 == null) && (entity == null)) {
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
			entity = new Nivel2();
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			// Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
			entityNivel3 = new Nivel3();
			
			// Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
			
			entity.setPesoPromedio(FacesUtils.checkDouble(txtPesoPromedio));
			entity.setBarrio(FacesUtils.checkString(txtBarrio));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));

			entity.setVereda(FacesUtils.checkLong(txtVereda));
			entity.setCompania(compania);
			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));

			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setDistanciaOficina(FacesUtils.checkDouble(txtDistanciaOficina));
			entity.setDistanciaPlanta(FacesUtils.checkDouble(txtDistanciaPlanta));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			// entity.setNivel2Id(nivel2Id);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setTipoPropiedad(FacesUtils.checkString(txtTipoPropiedad));
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost)));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));
			entity.setFrenteCos((FacesUtils.checkLong(txtFrtCosId_FrenteCos)));
			entity.setGrpTenen((FacesUtils.checkLong(txtGrpTenId_GrpTenen)));
			entity.setPluvioId((FacesUtils.checkLong(txtEstPluvioId_EstPluvio) != null)
					? businessDelegatorView.getEstPluvio(FacesUtils.checkLong(txtEstPluvioId_EstPluvio)) : null);
			
			entity.setNivel1((FacesUtils.checkLong(txtNivel1Id_Nivel1) != null)
					? businessDelegatorView.getNivel1(FacesUtils.checkLong(txtNivel1Id_Nivel1)) : null);
			entity.setProveedor((FacesUtils.checkLong(txtProveId_Proveedor) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtProveId_Proveedor)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setZonaGeografica((FacesUtils.checkLong(txtZonaGeograficaId_ZonaGeografica)));
			businessDelegatorView.saveNivel2(entity, dataNivel2PersEmpr);
			
			
			Long nivel2Id = entity.getNivel2Id();//businessDelegatorView.consultaMaximoIdNivel2(compania);
			if(nivel2Id != null){
				entityNivel3.setCompania(compania);
				entityNivel3.setCodigo(FacesUtils.checkString(txtCodigo));
				entityNivel3.setEstado(FacesUtils.checkString(txtEstado));
				entityNivel3.setFechaCreacion(date);
				entityNivel3.setNombre(FacesUtils.checkString(txtNombre));
				entityNivel3.setNivel2(businessDelegatorView.getNivel2(nivel2Id));
				businessDelegatorView.saveNivel3(entityNivel3);
			}
			
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
				Long nivel2Id = new Long(selectedNivel2.getNivel2Id());
				entity = businessDelegatorView.getNivel2(nivel2Id);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setBarrio(FacesUtils.checkString(txtBarrio));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));

			entity.setCompania(compania);
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setDistanciaOficina(FacesUtils.checkDouble(txtDistanciaOficina));
			entity.setVereda(FacesUtils.checkLong(txtVereda));
			entity.setPesoPromedio(FacesUtils.checkDouble(txtPesoPromedio));
			entity.setDistanciaPlanta(FacesUtils.checkDouble(txtDistanciaPlanta));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setTipoPropiedad(FacesUtils.checkString(txtTipoPropiedad));
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost)));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));
			entity.setFrenteCos((FacesUtils.checkLong(txtFrtCosId_FrenteCos)));
			entity.setGrpTenen((FacesUtils.checkLong(txtGrpTenId_GrpTenen)));
			entity.setPluvioId((FacesUtils.checkLong(txtEstPluvioId_EstPluvio) != null)
					? businessDelegatorView.getEstPluvio(FacesUtils.checkLong(txtEstPluvioId_EstPluvio)) : null);
			
			entity.setNivel1((FacesUtils.checkLong(txtNivel1Id_Nivel1) != null)
					? businessDelegatorView.getNivel1(FacesUtils.checkLong(txtNivel1Id_Nivel1)) : null);
			entity.setProveedor((FacesUtils.checkLong(txtProveId_Proveedor) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtProveId_Proveedor)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setZonaGeografica((FacesUtils.checkLong(txtZonaGeograficaId_ZonaGeografica)));
			businessDelegatorView.updateNivel2(entity, dataNivel2PersEmpr);
			Long nivel2Id = entity.getNivel2Id();
			Object[] condicion = { "nivel2.nivel2Id", true, nivel2Id, "=" };
			List<Nivel3> listaNivel3 = (nivel2Id != null) ? businessDelegatorView.findByCriteriaInNivel3(condicion, null, null)
					: null;

			if (listaNivel3 != null && listaNivel3.size() > 0) {
				entityNivel3 = listaNivel3.get(0);
				entityNivel3.setCompania(compania);
				entityNivel3.setCodigo(FacesUtils.checkString(txtCodigo));
				entityNivel3.setEstado(FacesUtils.checkString(txtEstado));
				entityNivel3.setFechaModificacion(date);
				entityNivel3.setNombre(FacesUtils.checkString(txtNombre));
				entityNivel3.setNivel2(businessDelegatorView.getNivel2(nivel2Id));
				businessDelegatorView.updateNivel3(entityNivel3);
			}else{
				 		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!",
								"No se puedo realizar la actualización de los datos en la Colonia. "));
			}
			
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedNivel2 = (Nivel2DTO) (evt.getComponent().getAttributes().get("selectedNivel2"));

			Long nivel2Id = new Long(selectedNivel2.getNivel2Id());
			entity = businessDelegatorView.getNivel2(nivel2Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
			entity = businessDelegatorView.getNivel2(nivel2Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteNivel2(entity);
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
			selectedNivel2 = (Nivel2DTO) (evt.getComponent().getAttributes().get("selectedNivel2"));

			Long nivel2Id = new Long(selectedNivel2.getNivel2Id());
			entity = businessDelegatorView.getNivel2(nivel2Id);
			businessDelegatorView.deleteNivel2(entity);
			((Map<String, Object>) data).remove(selectedNivel2);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String barrio, String codigo, Long compania, String direccion,
			Double distanciaOficina, Double distanciaPlanta, String estado, Date fechaCreacion, Date fechaModificacion,
			String infoAdicional, String infoAdicional2, String latitud, String longitud, Long nivel2Id, String nombre,
			String observacion, String pbx, String precision, String telefono, String tipoPropiedad,
			Long centCostId_CentCost, Long ciudadId_Ciudad, Long frtCosId_FrenteCos, Long grpTenId_GrpTenen,
			Double precioPromedio, Long nivel1Id_Nivel1, Long proveId_Proveedor, Long vereda, Long trabId_Trabajador,
			Long zonaGeograficaId_ZonaGeografica) throws Exception {
		try {
			entity.setBarrio(FacesUtils.checkString(barrio));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setDistanciaOficina(FacesUtils.checkDouble(distanciaOficina));
			entity.setVereda(FacesUtils.checkLong(vereda));

			entity.setPesoPromedio(FacesUtils.checkDouble(precioPromedio));
			entity.setDistanciaPlanta(FacesUtils.checkDouble(distanciaPlanta));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setPbx(FacesUtils.checkString(pbx));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			entity.setTelefono(FacesUtils.checkString(telefono));
			entity.setTipoPropiedad(FacesUtils.checkString(tipoPropiedad));
			businessDelegatorView.updateNivel2(entity, dataNivel2PersEmpr);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("Nivel2View").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtBarrio() {
		return txtBarrio;
	}

	public void setTxtBarrio(InputText txtBarrio) {
		this.txtBarrio = txtBarrio;
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

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtDistanciaOficina() {
		return txtDistanciaOficina;
	}

	public void setTxtDistanciaOficina(InputText txtDistanciaOficina) {
		this.txtDistanciaOficina = txtDistanciaOficina;
	}

	public InputText getTxtDistanciaPlanta() {
		return txtDistanciaPlanta;
	}

	public void setTxtDistanciaPlanta(InputText txtDistanciaPlanta) {
		this.txtDistanciaPlanta = txtDistanciaPlanta;
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

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputText getTxtPbx() {
		return txtPbx;
	}

	public void setTxtPbx(InputText txtPbx) {
		this.txtPbx = txtPbx;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public SelectOneMenu getTxtTipoPropiedad() {
		return txtTipoPropiedad;
	}

	public void setTxtTipoPropiedad(SelectOneMenu txtTipoPropiedad) {
		this.txtTipoPropiedad = txtTipoPropiedad;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtCiudadId_Ciudad() {
		return txtCiudadId_Ciudad;
	}

	public void setTxtCiudadId_Ciudad(SelectOneMenu txtCiudadId_Ciudad) {
		this.txtCiudadId_Ciudad = txtCiudadId_Ciudad;
	}

	public SelectOneMenu getTxtFrtCosId_FrenteCos() {
		return txtFrtCosId_FrenteCos;
	}

	public void setTxtFrtCosId_FrenteCos(SelectOneMenu txtFrtCosId_FrenteCos) {
		this.txtFrtCosId_FrenteCos = txtFrtCosId_FrenteCos;
	}

	public SelectOneMenu getTxtGrpTenId_GrpTenen() {
		return txtGrpTenId_GrpTenen;
	}

	public void setTxtGrpTenId_GrpTenen(SelectOneMenu txtGrpTenId_GrpTenen) {
		this.txtGrpTenId_GrpTenen = txtGrpTenId_GrpTenen;
	}

	public SelectOneMenu getTxtNivel1Id_Nivel1() {
		return txtNivel1Id_Nivel1;
	}

	public void setTxtNivel1Id_Nivel1(SelectOneMenu txtNivel1Id_Nivel1) {
		this.txtNivel1Id_Nivel1 = txtNivel1Id_Nivel1;
	}

	public SelectOneMenu getTxtProveId_Proveedor() {
		return txtProveId_Proveedor;
	}

	public void setTxtProveId_Proveedor(SelectOneMenu txtProveId_Proveedor) {
		this.txtProveId_Proveedor = txtProveId_Proveedor;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectOneMenu getTxtZonaGeograficaId_ZonaGeografica() {
		return txtZonaGeograficaId_ZonaGeografica;
	}

	public void setTxtZonaGeograficaId_ZonaGeografica(SelectOneMenu txtZonaGeograficaId_ZonaGeografica) {
		this.txtZonaGeograficaId_ZonaGeografica = txtZonaGeograficaId_ZonaGeografica;
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

	public InputText getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(InputText txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public LazyDataModel<Nivel2DTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<Nivel2DTO> nivel2DTO) {
		this.data = nivel2DTO;
	}

	public Nivel2DTO getSelectedNivel2() {
		return selectedNivel2;
	}

	public void setSelectedNivel2(Nivel2DTO nivel2) {
		this.selectedNivel2 = nivel2;
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

	public SelectItem[] getselectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			centCost = new ArrayList<CentCost>();

			try {

				centCost = businessDelegatorView.getCentCost(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCost = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCost[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCost;
	}

	public void setselectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getselectCiudad() {

		if (ciudad == null || ciudad.size() == 0) {

			ciudad = new ArrayList<Ciudad>();

			try {

				ciudad = businessDelegatorView.getCiudad(); // Fin by
				// Criteria
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudad = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudad : lista) {
					selectCiudad[i] = new SelectItem(ciudad.getCiudadId(), ciudad.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudad;
	}

	public void setselectCiudad(SelectItem[] selectCiudad) {
		this.selectCiudad = selectCiudad;
	}

	public SelectItem[] getselectFrenteCos() {

		if (frenteCos == null || frenteCos.size() == 0) {

			frenteCos = new ArrayList<FrenteCos>();

			try {

				frenteCos = businessDelegatorView.getFrenteCos(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<FrenteCos> lista = businessDelegatorView.findByCriteriaInFrenteCos(condicion, null, null);
				selectFrenteCos = new SelectItem[lista.size()];

				int i = 0;
				for (FrenteCos frenteCos : lista) {
					selectFrenteCos[i] = new SelectItem(frenteCos.getFrtCosId(), frenteCos.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFrenteCos;
	}

	public void setselectFrenteCos(SelectItem[] selectFrenteCos) {
		this.selectFrenteCos = selectFrenteCos;
	}

	public SelectItem[] getselectGrpTenen() {

		if (grpTenen == null || grpTenen.size() == 0) {

			grpTenen = new ArrayList<GrpTenen>();

			try {

				grpTenen = businessDelegatorView.getGrpTenen(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<GrpTenen> lista = businessDelegatorView.findByCriteriaInGrpTenen(condicion, null, null);
				selectGrpTenen = new SelectItem[lista.size()];

				int i = 0;
				for (GrpTenen grpTenen : lista) {
					selectGrpTenen[i] = new SelectItem(grpTenen.getGrpTenId(), grpTenen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectGrpTenen;
	}

	public void setselectGrpTenen(SelectItem[] selectGrpTenen) {
		this.selectGrpTenen = selectGrpTenen;
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

	public SelectItem[] getselectProveedor() {

		if (proveedor == null || proveedor.size() == 0) {

			proveedor = new ArrayList<PersEmpr>();

			try {

				proveedor = businessDelegatorView.getPersEmpr(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectProveedor = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr proveedor : lista) {
					selectProveedor[i] = new SelectItem(proveedor.getPersEmprId(), proveedor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProveedor;
	}

	public void setselectProveedor(SelectItem[] selectProveedor) {
		this.selectProveedor = selectProveedor;
	}

	public SelectItem[] getselectZonaGeografica() {

		if (zonaGeografica == null || zonaGeografica.size() == 0) {

			zonaGeografica = new ArrayList<ZonaGeografica>();

			try {

				zonaGeografica = businessDelegatorView.getZonaGeografica(); // Fin
																			// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ZonaGeografica> lista = businessDelegatorView.findByCriteriaInZonaGeografica(condicion, null,
						null);
				selectZonaGeografica = new SelectItem[lista.size()];

				int i = 0;
				for (ZonaGeografica zonaGeografica : lista) {
					selectZonaGeografica[i] = new SelectItem(zonaGeografica.getZonaGeograficaId(),
							zonaGeografica.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectZonaGeografica;
	}

	public void setselectZonaGeografica(SelectItem[] selectZonaGeografica) {
		this.selectZonaGeografica = selectZonaGeografica;
	}

	private class LocalDataModelDTO extends LazyDataModel<Nivel2DTO> {
		private static final long serialVersionUID = 1L;
		private List<Nivel2DTO> nivel2DTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<Nivel2DTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				nivel2DTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberNivel2(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return nivel2DTO;

		}

		@Override
		public Nivel2DTO getRowData(String rowKey) {
			for (Nivel2DTO nivel2DTOtmp : nivel2DTO) {
				if (nivel2DTOtmp.getNivel2Id().toString().equals(rowKey))
					return nivel2DTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(Nivel2DTO nivel2DTOtmp) {
			return nivel2DTOtmp.getNivel2Id();
		}

	}

	private List<Nivel2DTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageNivel2(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public InputText getTxtPesoPromedio() {
		return txtPesoPromedio;
	}

	public void setTxtPesoPromedio(InputText txtPesoPromedio) {
		this.txtPesoPromedio = txtPesoPromedio;
	}

	public SelectOneMenu getTxtVereda() {
		return txtVereda;
	}

	public void setTxtVereda(SelectOneMenu txtVereda) {
		this.txtVereda = txtVereda;
	}

	public SelectItem[] getselectVereda() {

		if (vereda == null || vereda.size() == 0) {

			vereda = new ArrayList<Vereda>();

			try {

				vereda = businessDelegatorView.getVereda(); // Fin
															// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Vereda> lista = businessDelegatorView.findByCriteriaInVereda(condicion, null, null);
				selectVereda = new SelectItem[lista.size()];

				int i = 0;
				for (Vereda Vereda : lista) {
					selectVereda[i] = new SelectItem(Vereda.getVeredaId(), Vereda.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectVereda;
	}

	public SelectItem[] getSelectPersEmpr() {

		if (persempr == null || persempr.size() == 0) {

			persempr = new ArrayList<PersEmpr>();

			try {

				persempr = businessDelegatorView.getPersEmpr();

				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectPersEmpr = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr p : lista) {
					selectPersEmpr[i] = new SelectItem(p.getPersEmprId(), p.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPersEmpr;
	}

	public void action_agregarParticipacion() throws Exception {
		if (txtPersEmprId.getValue() != null && txtPorcentajeParticipacion.getValue() != null) {
			Long nivel2Id = FacesUtils.checkLong(txtNivel2Id);
			Long proveedorId = Long.parseLong(txtPersEmprId.getValue().toString());

			Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
			PersEmpr proveedor3 = businessDelegatorView.getPersEmpr(proveedorId);
			Double porcentaje = FacesUtils.checkDouble(txtPorcentajeParticipacion);

			if (dataNivel2PersEmpr == null || dataNivel2PersEmpr.size() == 0) {
				dataNivel2PersEmpr = new ArrayList<Nivel2PersemprDTO>();
			}

			Nivel2PersemprDTO nivel2PersemprDTO = new Nivel2PersemprDTO();
			nivel2PersemprDTO.setProveedorParticipacion(proveedor3);
			nivel2PersemprDTO.setNivel2Id_Nivel2(nivel2);
			nivel2PersemprDTO.setProcentajeParticipacion(porcentaje);
			dataNivel2PersEmpr.add(nivel2PersemprDTO);

			nivel2 = null;
			proveedor3 = null;
			proveedorId = null;
			porcentaje = null;
			proveedorId = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos proveedor y porcentaje de participación tengan valores. "));
		}
	}

	public String actionDeleteNivel2PersEmpr(ActionEvent evt) {
		try {

			selectedNivel2PersEmpr = (Nivel2PersemprDTO) (evt.getComponent().getAttributes().get("selectedNivel2Id"));

			if (selectedNivel2PersEmpr.getId() == null) {
				dataNivel2PersEmpr.remove(selectedNivel2PersEmpr);
			} else {
				Long id = new Long(selectedNivel2PersEmpr.getId());
				Nivel2Persempr entity = businessDelegatorView.getNivel2Persempr(id);
				businessDelegatorView.deleteNivel2Persempr(entity);
				dataNivel2PersEmpr.remove(selectedNivel2PersEmpr);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void setSelectPersEmpr(SelectItem[] selectPersEmpr) {
		this.selectPersEmpr = selectPersEmpr;
	}

	public void setselectVereda(SelectItem[] selectVereda) {
		this.selectVereda = selectVereda;
	}

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public InputText getTxtPorcentajeParticipacion() {
		return txtPorcentajeParticipacion;
	}

	public void setTxtPorcentajeParticipacion(InputText txtPorcentajeParticipacion) {
		this.txtPorcentajeParticipacion = txtPorcentajeParticipacion;
	}

	public List<Nivel2PersemprDTO> getDataNivel2PersEmpr() {

		if (dataNivel2PersEmpr == null || dataNivel2PersEmpr.size() == 0) {
			return null;
		} else {
			return dataNivel2PersEmpr;
		}
	}

	public void setDataNivel2PersEmpr(List<Nivel2PersemprDTO> dataNivel2PersEmpr) {
		this.dataNivel2PersEmpr = dataNivel2PersEmpr;
	}

	public void listener_ConsultaCodProveedor() {

		Long proveedorId = null;

		if (!txtPersEmprId.getValue().equals("")) {
			proveedorId = Long.parseLong(txtPersEmprId.getValue().toString());

			try {
				PersEmpr proveedor = businessDelegatorView.getPersEmpr(proveedorId);
				txtCodProveedor.setValue(proveedor.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public InputText getTxtCodProveedor() {
		return txtCodProveedor;
	}

	public void setTxtCodProveedor(InputText txtCodProveedor) {
		this.txtCodProveedor = txtCodProveedor;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public InputText getTxtCodigoAlternativo() {
		return txtCodigoAlternativo;
	}

	public void setTxtCodigoAlternativo(InputText txtCodigoAlternativo) {
		this.txtCodigoAlternativo = txtCodigoAlternativo;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}


	/**
	 * @return the txtEstPluvioId_EstPluvio
	 */
	public SelectOneMenu getTxtEstPluvioId_EstPluvio() {
		return txtEstPluvioId_EstPluvio;
	}


	/**
	 * @param txtEstPluvioId_EstPluvio the txtEstPluvioId_EstPluvio to set
	 */
	public void setTxtEstPluvioId_EstPluvio(SelectOneMenu txtEstPluvioId_EstPluvio) {
		this.txtEstPluvioId_EstPluvio = txtEstPluvioId_EstPluvio;
	}

	public SelectItem[] getSelectEstPluvio() {

		if (estPluvio == null || estPluvio.size() == 0) {

			estPluvio = new ArrayList<EstPluvio>();

			try {

				estPluvio = businessDelegatorView.getEstPluvio(); // Fin by
																	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstPluvio> lista = businessDelegatorView.findByCriteriaInEstPluvio(condicion, null, null);
				selectEstPluvio = new SelectItem[lista.size()];

				int i = 0;
				for (EstPluvio pluvio : lista) {
					selectEstPluvio[i] = new SelectItem(pluvio.getEstPluvioId(), pluvio.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEstPluvio;
	}

	public void setSelectEstPluvio(SelectItem[] selectEstPluvio) {
		this.selectEstPluvio = selectEstPluvio;
	}

	
}
