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
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.FrenteCos;
import co.com.arcosoft.modelo.GrpTenen;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.TarifaEquipProp;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Vereda;
import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.dto.Nivel2ClientesmqDTO;
import co.com.arcosoft.modelo.dto.PersEmprDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ProntuarioLotesDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class Nivel2ClientesmqView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel2ClientesmqView.class);
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
	private InputText txtNivel2ClientesmqId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<Nivel2ClientesmqDTO> data;
	
	// private List<Nivel2ClientesmqDTO> data;
	private Nivel2ClientesmqDTO selectedNivel2Clientesmq;
	private Nivel2Clientesmq entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

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

	/*** Pestaña participacion ***/

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectPersEmpr;
	private List<PersEmpr> persempr;

	private InputText txtPorcentajeParticipacion;
	private InputText txtCodProveedor;

	private CommandButton btnAgregar;
	private int activeTapIndex = 0;

	private SelectOneMenu txtEstPluvioId_EstPluvio;
	SelectItem[] selectEstPluvio;
	private List<EstPluvio> estPluvio;
	
	private SelectOneMenu txtCliente;
	SelectItem[] selectCliente;
	private List<PersEmpr> cliente;

	private SelectOneMenu txtNivelConsulta2ClientesId;
	SelectItem[] selectNivelConsulta2ClientesId;
	private List<Nivel2Clientesmq> nivel2ConsultaClientesId;

	private List<ProntuarioLotesDTO> data2;
	private ProntuarioLotesDTO selectedProntuario;

	public Nivel2ClientesmqView() {
		super();
	}

	public String action_new() {
		action_clear();
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedNivel2Clientesmq = null;
		
		PrimeFaces.current().resetInputs(":dialogNivel2Clientesmq :frm");
		activeTapIndex = 0;

		if (txtBarrio != null) {
			txtBarrio.setValue(null);
			txtBarrio.setDisabled(false);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCodigoAlternativo != null) {
			txtCodigoAlternativo.setValue(null);
			txtCodigoAlternativo.setDisabled(false);
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
			txtEstPluvioId_EstPluvio.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(false);
		}

		if (txtDistanciaOficina != null) {
			txtDistanciaOficina.setValue(null);
			txtDistanciaOficina.setDisabled(false);
		}

		if (txtDistanciaPlanta != null) {
			txtDistanciaPlanta.setValue(null);
			txtDistanciaPlanta.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
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

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtPbx != null) {
			txtPbx.setValue(null);
			txtPbx.setDisabled(false);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(false);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(false);
		}

		if (txtTipoPropiedad != null) {
			txtTipoPropiedad.setValue(null);
			txtTipoPropiedad.setDisabled(false);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtCiudadId_Ciudad != null) {
			txtCiudadId_Ciudad.setValue(null);
			txtCiudadId_Ciudad.setDisabled(false);
		}

		if (txtFrtCosId_FrenteCos != null) {
			txtFrtCosId_FrenteCos.setValue(null);
			txtFrtCosId_FrenteCos.setDisabled(false);
		}

		if (txtGrpTenId_GrpTenen != null) {
			txtGrpTenId_GrpTenen.setValue(null);
			txtGrpTenId_GrpTenen.setDisabled(false);
		}

		if (txtNivel1Id_Nivel1 != null) {
			txtNivel1Id_Nivel1.setValue(null);
			txtNivel1Id_Nivel1.setDisabled(false);
		}

		if (txtProveId_Proveedor != null) {
			txtProveId_Proveedor.setValue(null);
			txtProveId_Proveedor.setDisabled(false);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtZonaGeograficaId_ZonaGeografica != null) {
			txtZonaGeograficaId_ZonaGeografica.setValue(null);
			txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(false);
		}

		if (txtPorcentajeParticipacion != null) {
			txtPorcentajeParticipacion.setValue(null);
			txtPorcentajeParticipacion.setDisabled(false);
		}

		if (txtNivel2ClientesmqId != null) {
			txtNivel2ClientesmqId.setValue(null);
			txtNivel2ClientesmqId.setDisabled(false);
		}


		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
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


	public void listarHaciendas() {
		try {
			
			Long compania = new Long(getCompaniaIdSession());
			// Long compania = 1L;
		
			String clienteId = "0";
			Long flagClientes = 1L;
			String haciendaId ="0";
			Long flagHacienda = 1L;
			
			
			
			if(txtCliente.getValue()!=null) {
				clienteId = FacesUtils.checkString(txtCliente);
				flagClientes =0L;
			}
			
			if(txtNivelConsulta2ClientesId.getValue()!=null) {
				haciendaId = FacesUtils.checkString(txtNivelConsulta2ClientesId);
				flagHacienda =0L;
			}
		
			
			
			if(compania != null &&  clienteId !=null){
					data2 = businessDelegator2View.pr_prontuario_haciendas_maquinaria(compania,  
						haciendaId, flagHacienda,  
						clienteId, flagClientes);
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	

	
	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Nivel2Clientesmq> lista = (codigo != null) ? businessDelegator2View.findByCriteriaInNivel2Clientesmq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Codigo digitado no existe!, si deseas puedes crear un nuevo registro con el codigo: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}
		if (entity == null) {
			txtCodigoAlternativo.setDisabled(false);

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
			txtPbx.setDisabled(false);
			txtPrecision.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTipoPropiedad.setDisabled(false);
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtProveId_Proveedor.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);

			txtNivel2ClientesmqId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
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
			txtPrecision.setValue(entity.getPrecision1());
			txtPrecision.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTipoPropiedad.setValue(entity.getTipoPropiedad());
			txtTipoPropiedad.setDisabled(false);
			txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setValue(entity.getCiudad().getCiudadId());
			txtCiudadId_Ciudad.setDisabled(false);
			txtProveId_Proveedor.setValue(entity.getPersEmpr().getPersEmprId());
			txtProveId_Proveedor.setDisabled(false);
			txtNivel2ClientesmqId.setValue(entity.getNivel2ClientesmqId());

			/*** sesion % participacion ***/


			txtNivel2ClientesmqId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	
	
	public String action_edit(ActionEvent evt) {
		selectedProntuario = (ProntuarioLotesDTO) (evt.getComponent().getAttributes().get("selectedProntuario"));


		PrimeFaces.current().resetInputs(":dialogNivel2Clientesmq :frm");

		try {

			Long nivel2ClientesmqId = selectedProntuario.getNivel2ClientesMqId().longValue();
			Object[] condicion = { "nivel2ClientesmqId", true, nivel2ClientesmqId, "=" };
			List<Nivel2Clientesmq> lista = (nivel2ClientesmqId != null) ? businessDelegator2View.findByCriteriaInNivel2Clientesmq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtBarrio.setValue(entity.getBarrio());
				txtBarrio.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtVereda.setValue(entity.getVereda());
				txtVereda.setDisabled(false);
				txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
				txtCodigoAlternativo.setDisabled(false);

				// txtCompania.setValue(selectedNivel2Clientesmq.getCompania());
				// txtCompania.setDisabled(false);
				txtDireccion.setValue(entity.getDireccion());
				txtDireccion.setDisabled(false);
				txtDistanciaOficina.setValue(entity.getDistanciaOficina());
				txtDistanciaOficina.setDisabled(false);
				txtDistanciaPlanta.setValue(entity.getDistanciaPlanta());
				txtDistanciaPlanta.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedNivel2Clientesmq.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedNivel2Clientesmq.getFechaModificacion());
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
				txtPrecision.setValue(entity.getPrecision1());
				txtPrecision.setDisabled(false);
				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				txtTipoPropiedad.setValue(entity.getTipoPropiedad());
				txtTipoPropiedad.setDisabled(false);
				if(entity.getCentCost()!=null) {
					txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
				}
				
				
				txtCentCostId_CentCost.setDisabled(false);
				if(entity.getCiudad()!=null) {
				txtCiudadId_Ciudad.setValue(entity.getCiudad().getCiudadId());
				}
				txtCiudadId_Ciudad.setDisabled(false);
				if(entity.getPersEmpr()!=null) {
					txtProveId_Proveedor.setValue(entity.getPersEmpr().getPersEmprId());
				}
				txtProveId_Proveedor.setDisabled(false);
					
				
				txtNivel2ClientesmqId.setValue(entity.getNivel2ClientesmqId());
				txtNivel2ClientesmqId.setDisabled(true);

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
			if ((selectedNivel2Clientesmq == null) && (entity == null)) {
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
			entity = new Nivel2Clientesmq();
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			// Long nivel2Id = FacesUtils.checkLong(txtNivel2ClientesmqId);
			String estado = "A";
			entity.setBarrio(FacesUtils.checkString(txtBarrio));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));

			entity.setVereda(FacesUtils.checkLong(txtVereda));
			entity.setCompania(compania);
			entity.setCodigoAlternativo(FacesUtils.checkString(txtCodigoAlternativo));

			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setDistanciaOficina(FacesUtils.checkDouble(txtDistanciaOficina));
			entity.setDistanciaPlanta(FacesUtils.checkDouble(txtDistanciaPlanta));
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			// entity.setNivel2ClientesmqId(nivel2Id);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			entity.setPrecision1(FacesUtils.checkFloat(txtPrecision));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setTipoPropiedad(FacesUtils.checkString(txtTipoPropiedad));
			
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_Ciudad)) : null);
			
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost)) : null);
			
			entity.setPersEmpr((FacesUtils.checkLong(txtProveId_Proveedor) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtProveId_Proveedor)) : null);
			
			String codigoNivel2 ="";
            Long persemprid = null;
            codigoNivel2 = FacesUtils.checkString(txtCodigo);
            persemprid=  FacesUtils.checkLong(txtProveId_Proveedor);
            
           String codNivel2C =  businessDelegator2View.busquedaNivel2Clientes(codigoNivel2, persemprid);
          
            	if(codNivel2C.equals(" ") || codNivel2C.equals("")){
            		businessDelegator2View.saveNivel2Clientesmq(entity);
                FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
                	
            }else{
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
    					"El código de Hacienda que esta intentando crear ya existe en la base de datos"));
            }
            
			
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
				Long nivel2Id = new Long(selectedNivel2Clientesmq.getNivel2ClientesmqId());
				entity = businessDelegator2View.getNivel2Clientesmq(nivel2Id);
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
			entity.setPrecision1(FacesUtils.checkFloat(txtPrecision));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setTipoPropiedad(FacesUtils.checkString(txtTipoPropiedad));
			
			
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad) != null)
					? businessDelegatorView.getCiudad(FacesUtils.checkLong(txtCiudadId_Ciudad)) : null);
			
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost)) : null);
			
			entity.setPersEmpr((FacesUtils.checkLong(txtProveId_Proveedor) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtProveId_Proveedor)) : null);
			
			businessDelegator2View.updateNivel2Clientesmq(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedNivel2Clientesmq = (Nivel2ClientesmqDTO) (evt.getComponent().getAttributes().get("selectedNivel2Clientesmq"));

			Long nivel2Id = new Long(selectedNivel2Clientesmq.getNivel2ClientesmqId());
			entity = businessDelegator2View.getNivel2Clientesmq(nivel2Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long nivel2Id = FacesUtils.checkLong(txtNivel2ClientesmqId);
			entity = businessDelegator2View.getNivel2Clientesmq(nivel2Id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteNivel2Clientesmq(entity);
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
			selectedNivel2Clientesmq = (Nivel2ClientesmqDTO) (evt.getComponent().getAttributes().get("selectedNivel2Clientesmq"));

			Long nivel2Id = new Long(selectedNivel2Clientesmq.getNivel2ClientesmqId());
			entity = businessDelegator2View.getNivel2Clientesmq(nivel2Id);
			businessDelegator2View.deleteNivel2Clientesmq(entity);
			((Map<String, Object>) data).remove(selectedNivel2Clientesmq);
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
			entity.setPrecision1(FacesUtils.checkFloat(precision));
			entity.setTelefono(FacesUtils.checkString(telefono));
			entity.setTipoPropiedad(FacesUtils.checkString(tipoPropiedad));
			businessDelegator2View.updateNivel2Clientesmq(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("Nivel2ClientesmqView").requestRender();
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

	public InputText getTxtNivel2ClientesmqId() {
		return txtNivel2ClientesmqId;
	}

	public void setTxtNivel2ClientesmqId(InputText txtNivel2ClientesmqId) {
		this.txtNivel2ClientesmqId = txtNivel2ClientesmqId;
	}

	
	public LazyDataModel<Nivel2ClientesmqDTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataPersEmpr();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<Nivel2ClientesmqDTO> nivel2ClientesmqDTO) {
		this.data = nivel2ClientesmqDTO;
	}
	
	private class LocalDataModelDTO extends LazyDataModel<Nivel2ClientesmqDTO> {
		private static final long serialVersionUID = 1L;
		private List<Nivel2ClientesmqDTO> nivel2ClientesmqDTO;

	 
		@Override
		public List<Nivel2ClientesmqDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				nivel2ClientesmqDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberEmpresa(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return nivel2ClientesmqDTO;

		}

		@Override
		public Nivel2ClientesmqDTO getRowData(String rowKey) {
			for (Nivel2ClientesmqDTO nivel2ClientesmqDTOtmp : nivel2ClientesmqDTO) {
				if (nivel2ClientesmqDTOtmp.getNivel2ClientesmqId().toString().equals(rowKey))
					return nivel2ClientesmqDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(Nivel2ClientesmqDTO nivel2ClientesmqDTOtmp) {
			return nivel2ClientesmqDTOtmp.getNivel2ClientesmqId();
		}

	}
	
	private List<Nivel2ClientesmqDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegator2View.getDataPageNivel2Clientesmq(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public Nivel2ClientesmqDTO getSelectedNivel2Clientesmq() {
		return selectedNivel2Clientesmq;
	}

	public void setSelectedNivel2Clientesmq(Nivel2ClientesmqDTO nivel2) {
		this.selectedNivel2Clientesmq = nivel2;
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

			try {

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

			try {

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

			try {

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

		
			try {

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

		
			try {
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

			
			try {

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

	public SelectItem[] getSelectProveedor() {

		if (proveedor == null || proveedor.size() == 0) {

			
			try {

					// Criteria
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
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

	public void setSelectProveedor(SelectItem[] selectProveedor) {
		this.selectProveedor = selectProveedor;
	}

	public SelectItem[] getselectZonaGeografica() {

		if (zonaGeografica == null || zonaGeografica.size() == 0) {

			try {

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

	

			try {

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

			try {

				
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
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
	
	
	public SelectItem[] getselectCliente() {

		if (cliente == null || cliente.size() == 0) {

			 

			try {

				
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectCliente = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr cliente : lista) {
					selectCliente[i] = new SelectItem(cliente.getPersEmprId(), cliente.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCliente;
	}

	public void setselectCliente(SelectItem[] selectCliente) {
		this.selectCliente = selectCliente;
	}
	
	public SelectItem[] getSelectNivelConsulta2ClientesId() {

		if (nivel2ConsultaClientesId == null || nivel2ConsultaClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtCliente != null && txtCliente.getValue() != null) {
					persEmprId = Long.parseLong(txtCliente.getValue().toString());

					// Criteria
					List<ListaNivel2ClientesmqDTO> listaNivelConsulta2Clientesmq = businessDelegator2View
							.listaNivel2Clientesmq(idCompania, persEmprId);

					selectNivelConsulta2ClientesId = new SelectItem[listaNivelConsulta2Clientesmq.size()];
					int i = 0;
					for (ListaNivel2ClientesmqDTO listaNivelConsulta2ClientesmqDto : listaNivelConsulta2Clientesmq) {
						selectNivelConsulta2ClientesId[i] = new SelectItem(listaNivelConsulta2ClientesmqDto.getId(),
								listaNivelConsulta2ClientesmqDto.getHacienda());
						i++;

					}
				}else {
								List<ListaNivel2ClientesmqDTO> listaNivelConsulta2Clientesmq = businessDelegator2View
										.listaNivel2Clientesmq(idCompania, 0L);
			
								selectNivelConsulta2ClientesId = new SelectItem[listaNivelConsulta2Clientesmq.size()];
								int i = 0;
								for (ListaNivel2ClientesmqDTO listaNivelConsulta2ClientesmqDto : listaNivelConsulta2Clientesmq) {
									selectNivelConsulta2ClientesId[i] = new SelectItem(listaNivelConsulta2ClientesmqDto.getId(),
											listaNivelConsulta2ClientesmqDto.getHacienda()+"  ("+ listaNivelConsulta2ClientesmqDto.getCod_cliente()+"  )"  );
									i++;
			
								}
						}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivelConsulta2ClientesId;
	}

	public void setSelectNivelConsulta2ClientesId(SelectItem[] selectNivelConsulta2ClientesId) {
		this.selectNivelConsulta2ClientesId = selectNivelConsulta2ClientesId;
	}

	public SelectOneMenu getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(SelectOneMenu txtCliente) {
		this.txtCliente = txtCliente;
	}

	public SelectOneMenu getTxtNivelConsulta2ClientesId() {
		return txtNivelConsulta2ClientesId;
	}

	public void setTxtNivelConsulta2ClientesId(SelectOneMenu txtNivelConsulta2ClientesId) {
		this.txtNivelConsulta2ClientesId = txtNivelConsulta2ClientesId;
	}

	public List<ProntuarioLotesDTO> getData2() {
		return data2;
	}

	public void setData2(List<ProntuarioLotesDTO> data2) {
		this.data2 = data2;
	}

	public ProntuarioLotesDTO getSelectedProntuario() {
		return selectedProntuario;
	}

	public void setSelectedProntuario(ProntuarioLotesDTO selectedProntuario) {
		this.selectedProntuario = selectedProntuario;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
	
}
