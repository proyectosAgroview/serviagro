package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
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
import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProgramaLaboresView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaLaboresView.class);
	private Spinner txtNPases;
	private InputText txtAnio;
	private InputText txtCantidadPlan;
	private InputText txtCierreOt;
	private InputText txtCompania;
	private InputText txtCostoTotalEstimado;
	private InputText txtEdadPlanificacion;
	private SelectOneRadio txtEstado;

	private InputText txtIdMobile;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtLatitud;
	private InputText txtLongitud;
	// private SelectOneMenu txtNivel1Id;
	// private SelectOneMenu txtNivel2Id;
	// private SelectOneMenu txtNivel3Id;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtOrdenTrabajo;
	private InputText txtPrecision;
	private InputText txtUsuarioDigitacion;
	// private SelectOneMenu txtContratistaId_Contratista;
	// private SelectOneMenu txtLaborId_Labor;
	// private SelectOneMenu txtNivel4Id_Nivel4;
	// private SelectOneMenu txtServicioId_Servicio;
	// private SelectOneMenu txtTrabId_Trabajador;
	// private SelectOneMenu txtUdadMedId_UdadMed;
	private InputText txtPlanLaborId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtPeriodoFinal;
	private Calendar txtPeriodoInicial;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatPlanLaborDTO> data;
	private DatPlanLaborDTO selectedDatPlanLabor;
	private DatPlanLabor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private SelectOneMenu txtServicioId_Servicio;
	SelectItem[] selectServicioId;
	private List<Servicio> servicioId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtContratistaId_Contratista;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private DatPlanLabor SelectedPlanLabor;

	private Long nivel1Consulta;
	private MapModel simpleModel;

	private Marker marker;

	private String hacienda = "";
	private String lote = "";
	private String labor = "";
	private String supervisor = "";
	private String fechaInicioPlan = "";
	private String fechaFinPlan = "";
	private Long duracionDiasPlan = 0L;
	private Long duracionDiasReal = 0L;
	private int apuntamientosNomina = 0;
	private double costosNomina = 0;
	private int apuntamientosRiegos = 0;
	private int apuntamientosServicios = 0;
	private double costosServicios = 0;
	private int apuntamientosProductos = 0;
	private double costosProductos = 0;
	private double costosRiegos = 0;
	private double total = 0;
	private Long codigoOT;
	private String url = "";

	private String eventoFechaIni = "";
	private String eventoFechaFin = "";

	private String fechaIni = "";
	private String fechaFin = "";
	private String descripcion = "";
	private String titulo = "";
	private String localizacion = "";
	private List<DatPlanLaborDetDTO> dataPlanLaborDet;
	private DatPlanLaborDetDTO selectedDataPlanLaborDet;

	public ProgramaLaboresView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatPlanLaborDTO datPlanLaborDTO = (DatPlanLaborDTO) e.getObject();

			if (txtNPases == null) {
				txtNPases = new Spinner();
			}

			txtNPases.setValue(datPlanLaborDTO.getNPases());

			if (txtAnio == null) {
				txtAnio = new InputText();
			}

			txtAnio.setValue(datPlanLaborDTO.getAnio());

			if (txtCantidadPlan == null) {
				txtCantidadPlan = new InputText();
			}

			txtCantidadPlan.setValue(datPlanLaborDTO.getCantidadPlan());

			if (txtCierreOt == null) {
				txtCierreOt = new InputText();
			}

			txtCierreOt.setValue(datPlanLaborDTO.getCierreOt());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datPlanLaborDTO.getCompania());

			if (txtCostoTotalEstimado == null) {
				txtCostoTotalEstimado = new InputText();
			}

			txtCostoTotalEstimado.setValue(datPlanLaborDTO.getCostoTotalEstimado());

			if (txtEdadPlanificacion == null) {
				txtEdadPlanificacion = new InputText();
			}

			txtEdadPlanificacion.setValue(datPlanLaborDTO.getEdadPlanificacion());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datPlanLaborDTO.getEstado());

			if (txtIdMobile == null) {
				txtIdMobile = new InputText();
			}

			txtIdMobile.setValue(datPlanLaborDTO.getIdMobile());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(datPlanLaborDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(datPlanLaborDTO.getInfoAdicional2());

			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(datPlanLaborDTO.getLatitud());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(datPlanLaborDTO.getLongitud());

			if (txtNivel1Id == null) {
				txtNivel1Id = new SelectOneMenu();
			}

			txtNivel1Id.setValue(datPlanLaborDTO.getNivel1Id());

			if (txtNivel2Id == null) {
				txtNivel2Id = new SelectOneMenu();
			}

			txtNivel2Id.setValue(datPlanLaborDTO.getNivel2Id());

			if (txtNivel3Id == null) {
				txtNivel3Id = new SelectOneMenu();
			}

			txtNivel3Id.setValue(datPlanLaborDTO.getNivel3Id());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datPlanLaborDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datPlanLaborDTO.getObservacionAnularReg());

			if (txtOrdenTrabajo == null) {
				txtOrdenTrabajo = new InputText();
			}

			txtOrdenTrabajo.setValue(datPlanLaborDTO.getOrdenTrabajo());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(datPlanLaborDTO.getPrecision());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datPlanLaborDTO.getUsuarioDigitacion());

			if (txtContratistaId_Contratista == null) {
				txtContratistaId_Contratista = new SelectOneMenu();
			}

			txtContratistaId_Contratista.setValue(datPlanLaborDTO.getContratistaId_Contratista());

			if (txtLaborId_Labor == null) {
				txtLaborId_Labor = new SelectOneMenu();
			}

			txtLaborId_Labor.setValue(datPlanLaborDTO.getLaborId_Labor());

			if (txtNivel4Id_Nivel4 == null) {
				txtNivel4Id_Nivel4 = new SelectOneMenu();
			}

			txtNivel4Id_Nivel4.setValue(datPlanLaborDTO.getNivel4Id_Nivel4());

			if (txtServicioId_Servicio == null) {
				txtServicioId_Servicio = new SelectOneMenu();
			}

			txtServicioId_Servicio.setValue(datPlanLaborDTO.getServicioId_Servicio());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(datPlanLaborDTO.getTrabId_Trabajador());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new SelectOneMenu();
			}

			txtUdadMedId_UdadMed.setValue(datPlanLaborDTO.getUdadMedId_UdadMed());

			if (txtPlanLaborId == null) {
				txtPlanLaborId = new InputText();
			}

			txtPlanLaborId.setValue(datPlanLaborDTO.getPlanLaborId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datPlanLaborDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datPlanLaborDTO.getFechaModificacion());

			if (txtPeriodoFinal == null) {
				txtPeriodoFinal = new Calendar();
			}

			txtPeriodoFinal.setValue(datPlanLaborDTO.getPeriodoFinal());

			if (txtPeriodoInicial == null) {
				txtPeriodoInicial = new Calendar();
			}

			txtPeriodoInicial.setValue(datPlanLaborDTO.getPeriodoInicial());

			Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
			entity = businessDelegatorView.getDatPlanLabor(planLaborId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatPlanLabor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatPlanLabor = null;
		PrimeFaces.current().resetInputs(":dialogDatPlanLabor :frm");

		if (txtOrdenTrabajo != null) {
			txtOrdenTrabajo.setValue(null);
			txtOrdenTrabajo.setDisabled(true);
		}

		if (txtNPases != null) {
			txtNPases.setValue(1);
			txtNPases.setDisabled(true);
		}

		if (txtAnio != null) {
			txtAnio.setValue(null);
			txtAnio.setDisabled(true);
		}

		if (txtCantidadPlan != null) {
			txtCantidadPlan.setValue(null);
			txtCantidadPlan.setDisabled(false);
		}

		if (txtCierreOt != null) {
			txtCierreOt.setValue(null);
			txtCierreOt.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtCostoTotalEstimado != null) {
			txtCostoTotalEstimado.setValue(null);
			txtCostoTotalEstimado.setDisabled(true);
		}

		if (txtEdadPlanificacion != null) {
			txtEdadPlanificacion.setValue(null);
			txtEdadPlanificacion.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtIdMobile != null) {
			txtIdMobile.setValue(null);
			txtIdMobile.setDisabled(true);
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
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(true);
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

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtContratistaId_Contratista != null) {
			txtContratistaId_Contratista.setValue(null);
			txtContratistaId_Contratista.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}

		if (txtServicioId_Servicio != null) {
			txtServicioId_Servicio.setValue(null);
			txtServicioId_Servicio.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtPeriodoFinal != null) {
			txtPeriodoFinal.setValue(null);
			txtPeriodoFinal.setDisabled(false);
		}

		if (txtPeriodoInicial != null) {
			txtPeriodoInicial.setValue(null);
			txtPeriodoInicial.setDisabled(false);
		}

		if (txtPlanLaborId != null) {
			txtPlanLaborId.setValue(null);
			txtPlanLaborId.setDisabled(false);
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

	public void listener_txtPeriodoFinal() {
		Date inputDate = (Date) txtPeriodoFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtPeriodoInicial() {
		Date inputDate = (Date) txtPeriodoInicial.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_ConsultaUmLabor() {

		Long laborId = null;

		if (!txtLaborId_Labor.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());

			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtUdadMedId_UdadMed.setValue(labor.getUdadMedByUdadMedPlan());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	/*
	 * 
	 * public MapModel getSimpleModel() {
	 * 
	 * simpleModel = new DefaultMapModel(); LatLng coord1 = new
	 * LatLng(3.6374489,-76.2900103);
	 * 
	 * if ((Float) txtLatitud.getValue() != null && (Float)
	 * txtLongitud.getValue() != null ){ //Shared coordinates coord1 = new
	 * LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
	 * //Basic marker simpleModel.addOverlay(new Marker(coord1,
	 * "Captura en campo")); }else { //Shared coordinates coord1 = new LatLng(3,
	 * 79); //Basic marker simpleModel.addOverlay(new Marker(coord1,
	 * "Captura en campo")); }
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
			Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
			Object[] condicion = { "planLaborId", true, planLaborId, "=" };
			List<DatPlanLabor> lista = (planLaborId != null)
					? businessDelegatorView.findByCriteriaInDatPlanLabor(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ planLaborId);
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtNPases.setDisabled(false);
			// txtAnio.setDisabled(false);
			txtCantidadPlan.setDisabled(false);
			// txtCierreOt.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtCostoTotalEstimado.setDisabled(false);
			// txtEdadPlanificacion.setDisabled(false);
			txtEstado.setDisabled(false);
			// txtFechaReferencia.setDisabled(false);
			// txtIdMobile.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			// txtLatitud.setDisabled(false);
			// txtLongitud.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setDisabled(false);
			txtOrdenTrabajo.setDisabled(false);
			// txtPrecision.setDisabled(false);
			// txtUsuarioDigitacion.setDisabled(false);
			txtContratistaId_Contratista.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
			// txtServicioId_Servicio.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtPeriodoFinal.setDisabled(false);
			txtPeriodoInicial.setDisabled(false);
			txtPlanLaborId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtNPases.setValue(entity.getNPases());
			txtNPases.setDisabled(false);
			// txtAnio.setValue(entity.getAnio());
			// txtAnio.setDisabled(false);
			txtCantidadPlan.setValue(entity.getCantidadPlan());
			txtCantidadPlan.setDisabled(false);
			// txtCierreOt.setValue(entity.getCierreOt());
			// txtCierreOt.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtCostoTotalEstimado.setValue(entity.getCostoTotalEstimado());
			txtCostoTotalEstimado.setDisabled(false);
			// txtEdadPlanificacion.setValue(entity.getEdadPlanificacion());
			// txtEdadPlanificacion.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			// txtFechaReferencia.setValue(entity.getFechaReferencia());
			// txtFechaReferencia.setDisabled(false);
			// txtIdMobile.setValue(entity.getIdMobile());
			// txtIdMobile.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			// txtLatitud.setValue(entity.getLatitud());
			// txtLatitud.setDisabled(false);
			// txtLongitud.setValue(entity.getLongitud());
			// txtLongitud.setDisabled(false);
			txtNivel1Id.setValue(entity.getNivel1Id());
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id());
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setValue(entity.getObservacionAnularReg());
			txtObservacionAnularReg.setDisabled(false);
			txtOrdenTrabajo.setValue(entity.getOrdenTrabajo());
			txtOrdenTrabajo.setDisabled(false);
			txtPeriodoFinal.setValue(entity.getPeriodoFinal());
			txtPeriodoFinal.setDisabled(false);
			txtPeriodoInicial.setValue(entity.getPeriodoInicial());
			txtPeriodoInicial.setDisabled(false);
			// txtPrecision.setValue(entity.getPrecision());
			// txtPrecision.setDisabled(false);
			// txtUsuarioDigitacion.setValue(entity.getUsuarioDigitacion());
			// txtUsuarioDigitacion.setDisabled(false);
			txtContratistaId_Contratista.setValue(entity.getContratista());
			txtContratistaId_Contratista.setDisabled(false);
			txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
			txtLaborId_Labor.setDisabled(false);
			txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
			txtNivel4Id_Nivel4.setDisabled(false);
			// txtServicioId_Servicio.setValue(entity.getServicio());
			// txtServicioId_Servicio.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtPlanLaborId.setValue(entity.getPlanLaborId());
			txtPlanLaborId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtOrdenTrabajo() {
		try {

			Long ordenTrabajo = FacesUtils.checkLong(txtOrdenTrabajo);
			Object[] condicion = { "ordenTrabajo", true, ordenTrabajo, "=" };
			List<DatPlanLabor> lista = (ordenTrabajo != null)
					? businessDelegatorView.findByCriteriaInDatPlanLabor(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ ordenTrabajo);
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {

			txtOrdenTrabajo.setDisabled(false);
			txtNPases.setDisabled(false);
			// txtAnio.setDisabled(false);
			txtCantidadPlan.setDisabled(false);
			// txtCierreOt.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtCostoTotalEstimado.setDisabled(false);
			// txtEdadPlanificacion.setDisabled(false);
			// txtEstado.setDisabled(false);
			// txtFechaReferencia.setDisabled(false);
			// txtIdMobile.setDisabled(false);
			// txtInfoAdicional.setDisabled(false);
			// txtInfoAdicional2.setDisabled(false);
			// txtLatitud.setDisabled(false);
			// txtLongitud.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtObservacion.setDisabled(false);
			// txtObservacionAnularReg.setDisabled(false);
			// txtPrecision.setDisabled(false);
			// txtUsuarioDigitacion.setDisabled(false);
			txtContratistaId_Contratista.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
			// txtServicioId_Servicio.setDisabled(false);
			// txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtPeriodoFinal.setDisabled(false);
			txtPeriodoInicial.setDisabled(false);
			txtPlanLaborId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtOrdenTrabajo.setValue(entity.getOrdenTrabajo());
			txtOrdenTrabajo.setDisabled(false);
			txtNPases.setValue(entity.getNPases());
			txtNPases.setDisabled(false);
			// txtAnio.setValue(entity.getAnio());
			// txtAnio.setDisabled(false);
			txtCantidadPlan.setValue(entity.getCantidadPlan());
			txtCantidadPlan.setDisabled(false);
			// txtCierreOt.setValue(entity.getCierreOt());
			// txtCierreOt.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtCostoTotalEstimado.setValue(entity.getCostoTotalEstimado());
			txtCostoTotalEstimado.setDisabled(false);
			// txtEdadPlanificacion.setValue(entity.getEdadPlanificacion());
			// txtEdadPlanificacion.setDisabled(false);
			// txtEstado.setValue(entity.getEstado());
			// txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			// txtFechaReferencia.setValue(entity.getFechaReferencia());
			// txtFechaReferencia.setDisabled(false);
			// txtIdMobile.setValue(entity.getIdMobile());
			// txtIdMobile.setDisabled(false);
			// txtInfoAdicional.setValue(entity.getInfoAdicional());
			// txtInfoAdicional.setDisabled(false);
			// txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			// txtInfoAdicional2.setDisabled(false);
			// txtLatitud.setValue(entity.getLatitud());
			// txtLatitud.setDisabled(false);
			// txtLongitud.setValue(entity.getLongitud());
			// txtLongitud.setDisabled(false);
			txtNivel1Id.setValue(entity.getNivel1Id());
			txtNivel1Id.setDisabled(false);
			// nivel1Consulta = (entity.getNivel1Id());
			txtNivel2Id.setValue(entity.getNivel2Id().getNivel2Id());
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			// txtObservacionAnularReg.setValue(entity.getObservacionAnularReg());
			// txtObservacionAnularReg.setDisabled(false);
			txtPeriodoFinal.setValue(entity.getPeriodoFinal());
			txtPeriodoFinal.setDisabled(false);
			txtPeriodoInicial.setValue(entity.getPeriodoInicial());
			txtPeriodoInicial.setDisabled(false);
			// txtPrecision.setValue(entity.getPrecision());
			// txtPrecision.setDisabled(false);
			// txtUsuarioDigitacion.setValue(entity.getUsuarioDigitacion());
			// txtUsuarioDigitacion.setDisabled(false);
			txtContratistaId_Contratista.setValue(entity.getContratista());
			txtContratistaId_Contratista.setDisabled(false);
			txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
			txtLaborId_Labor.setDisabled(false);
			txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
			txtNivel4Id_Nivel4.setDisabled(false);
			// txtServicioId_Servicio.setValue(entity.getServicio());
			// txtServicioId_Servicio.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador());
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtPlanLaborId.setValue(entity.getPlanLaborId());
			txtPlanLaborId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {

		selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));

		try {

			Long ordenTrabajo = selectedDatPlanLabor.getOrdenTrabajo();
			Object[] condicion = { "ordenTrabajo", true, ordenTrabajo, "=" };
			List<DatPlanLabor> lista = (ordenTrabajo != null)
					? businessDelegatorView.findByCriteriaInDatPlanLabor(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				// txtNPases.setValue(entity.getNPases());
				// txtNPases.setDisabled(false);
				// txtAnio.setValue(selectedDatPlanLabor.getAnio());
				// txtAnio.setDisabled(false);
				txtCantidadPlan.setValue(entity.getCantidadPlan());
				txtCantidadPlan.setDisabled(false);
				// txtCierreOt.setValue(selectedDatPlanLabor.getCierreOt());
				// txtCierreOt.setDisabled(false);
				// txtCompania.setValue(selectedDatPlanLabor.getCompania());
				// txtCompania.setDisabled(false);
				// txtCostoTotalEstimado.setValue(entity.getCostoTotalEstimado());
				// txtCostoTotalEstimado.setDisabled(false);
				// txtEdadPlanificacion.setValue(selectedDatPlanLabor
				// .getEdadPlanificacion());
				// txtEdadPlanificacion.setDisabled(false);
				// txtEstado.setValue(entity.getEstado());
				// txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedDatPlanLabor.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedDatPlanLabor
				// .getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				// txtFechaReferencia.setValue(selectedDatPlanLabor.getFechaReferencia());
				// txtFechaReferencia.setDisabled(false);
				// txtIdMobile.setValue(selectedDatPlanLabor.getIdMobile());
				// txtIdMobile.setDisabled(false);
				txtInfoAdicional.setValue(selectedDatPlanLabor.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(selectedDatPlanLabor.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				// txtLatitud.setValue(selectedDatPlanLabor.getLatitud());
				// txtLatitud.setDisabled(false);
				// txtLongitud.setValue(selectedDatPlanLabor.getLongitud());
				// txtLongitud.setDisabled(false);
				txtNivel1Id.setValue(entity.getNivel1Id());
				txtNivel1Id.setDisabled(false);
				txtNivel2Id.setValue(entity.getNivel2Id().getNivel2Id());
				txtNivel2Id.setDisabled(false);
				txtNivel3Id.setValue(entity.getNivel3Id());
				txtNivel3Id.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				// txtObservacionAnularReg.setValue(selectedDatPlanLabor
				// .getObservacionAnularReg());
				// txtObservacionAnularReg.setDisabled(false);
				txtOrdenTrabajo.setValue(entity.getOrdenTrabajo());
				txtOrdenTrabajo.setDisabled(false);
				txtPeriodoFinal.setValue(entity.getPeriodoFinal());
				txtPeriodoFinal.setDisabled(false);
				txtPeriodoInicial.setValue(entity.getPeriodoInicial());
				txtPeriodoInicial.setDisabled(false);
				// txtPrecision.setValue(selectedDatPlanLabor.getPrecision());
				// txtPrecision.setDisabled(false);
				// txtUsuarioDigitacion.setValue(selectedDatPlanLabor
				// .getUsuarioDigitacion());
				// txtUsuarioDigitacion.setDisabled(false);
				// txtContratistaId_Contratista.setValue(entity
				// .getContratista());
				// txtContratistaId_Contratista.setDisabled(false);
				txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
				txtLaborId_Labor.setDisabled(false);
				txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
				txtNivel4Id_Nivel4.setDisabled(false);
				// txtServicioId_Servicio.setValue(entity
				// .getServicio());
				// txtServicioId_Servicio.setDisabled(false);
				txtTrabId_Trabajador.setValue(entity.getTrabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
				txtUdadMedId_UdadMed.setDisabled(false);
				txtPlanLaborId.setValue(entity.getPlanLaborId());
				txtPlanLaborId.setDisabled(true);
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
			if ((selectedDatPlanLabor == null) && (entity == null)) {
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
			entity = new DatPlanLabor();
			// Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			entity.setNPases(1L);
			// entity.setAnio(FacesUtils.checkLong(txtAnio));
			entity.setCantidadPlan(FacesUtils.checkDouble(txtCantidadPlan));
			String cierre = "A";
			entity.setCierreOt(cierre);
			entity.setCompania(compania);
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(txtCostoTotalEstimado));
			// entity.setEdadPlanificacion(FacesUtils
			// .checkDouble(txtEdadPlanificacion));
			String estado = "A";
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(FacesUtils.checkDate(txtPeriodoInicial));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnio((new Long(anioRegistro)));
			// entity.setIdMobile(FacesUtils.checkString(txtIdMobile));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			// entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			// entity.setObservacionAnularReg(FacesUtils
			// .checkString(txtObservacionAnularReg));
			entity.setOrdenTrabajo((businessDelegatorView.consultarConsecutivoDatPlanLabor(compania)));

			// entity.setPlanLaborId(planLaborId);
			// entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista)));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio)));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.saveDatPlanLabor(entity, dataPlanLaborDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + " " + "Orden de trabajo: "
					+ (businessDelegatorView.consultarConsecutivoDatPlanLabor(compania) - 1));
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
				Long planLaborId = new Long(selectedDatPlanLabor.getPlanLaborId());
				entity = businessDelegatorView.getDatPlanLabor(planLaborId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			entity.setNPases(1L);
			// entity.setAnio(FacesUtils.checkLong(txtAnio));
			entity.setCantidadPlan(FacesUtils.checkDouble(txtCantidadPlan));
			// entity.setCierreOt(FacesUtils.checkString(txtCierreOt));
			entity.setCompania(compania);
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(txtCostoTotalEstimado));
			// entity.setEdadPlanificacion(FacesUtils
			// .checkDouble(txtEdadPlanificacion));
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);

			// entity.setIdMobile(FacesUtils.checkString(txtIdMobile));
			// entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			// entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			// entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			// entity.setObservacionAnularReg(FacesUtils
			// .checkString(txtObservacionAnularReg));
			entity.setOrdenTrabajo(FacesUtils.checkLong(txtOrdenTrabajo));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(FacesUtils.checkDate(txtPeriodoInicial));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnio((new Long(anioRegistro)));
			//
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista)));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio)));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_cierreReaperturaOt(ActionEvent evt) {

		selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));

		try {

			Long planLaborId = new Long(selectedDatPlanLabor.getPlanLaborId());
			entity = businessDelegatorView.getDatPlanLabor(planLaborId);

			if (entity.getCierreOt().equals("A")) {

				Date date = new Date();
				entity.setFechaCierreOt(date);
				entity.setCierreOt("C");
				businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYCLOSEOT);
				action_clear();
				data = null;

			} else {

				Date date = new Date();
				entity.setFechaReaperturaOt(date);
				entity.setCierreOt("A");
				businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYOPENOT);
				action_clear();
				data = null;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatPlanLabor.getPlanLaborId());
				entity = businessDelegatorView.getDatPlanLabor(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		action_clear();
		selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));

			Long planLaborId = new Long(selectedDatPlanLabor.getPlanLaborId());
			entity = businessDelegatorView.getDatPlanLabor(planLaborId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
			entity = businessDelegatorView.getDatPlanLabor(planLaborId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatPlanLabor(entity);
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
			selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));

			Long planLaborId = new Long(selectedDatPlanLabor.getPlanLaborId());
			entity = businessDelegatorView.getDatPlanLabor(planLaborId);
			businessDelegatorView.deleteDatPlanLabor(entity);
			((Map<String, Object>) data).remove(selectedDatPlanLabor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long NPases, Long anio, Double cantidadPlan, String cierreOt, Long compania,
			Double costoTotalEstimado, Double edadPlanificacion, String estado, Date fechaCreacion,
			Date fechaModificacion, Long fechaReferencia, String idMobile, String infoAdicional, String infoAdicional2,
			String latitud, String longitud, Long nivel1Id, Long nivel2Id, Long nivel3Id, String observacion,
			String observacionAnularReg, Long ordenTrabajo, Date periodoFinal, Date periodoInicial, Long planLaborId,
			String precision, Long usuarioDigitacion, Long contratistaId_Contratista, Long laborId_Labor,
			Long nivel4Id_Nivel4, Long servicioId_Servicio, Long trabId_Trabajador, Long udadMedId_UdadMed)
			throws Exception {
		try {
			entity.setNPases(FacesUtils.checkLong(NPases));
			entity.setAnio(FacesUtils.checkLong(anio));
			entity.setCantidadPlan(FacesUtils.checkDouble(cantidadPlan));
			entity.setCierreOt(FacesUtils.checkString(cierreOt));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(costoTotalEstimado));
			entity.setEdadPlanificacion(FacesUtils.checkDouble(edadPlanificacion));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));

			entity.setIdMobile(FacesUtils.checkString(idMobile));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setNivel1Id(FacesUtils.checkLong(nivel1Id));
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel3Id(FacesUtils.checkLong(nivel3Id));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setOrdenTrabajo(FacesUtils.checkLong(ordenTrabajo));
			entity.setPeriodoFinal(FacesUtils.checkDate(periodoFinal));
			entity.setPeriodoInicial(FacesUtils.checkDate(periodoInicial));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatPlanLaborView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public Spinner getTxtNPases() {
		return txtNPases;
	}

	public void setTxtNPases(Spinner txtNPases) {
		this.txtNPases = txtNPases;
	}

	public InputText getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(InputText txtAnio) {
		this.txtAnio = txtAnio;
	}

	public InputText getTxtCantidadPlan() {
		return txtCantidadPlan;
	}

	public void setTxtCantidadPlan(InputText txtCantidadPlan) {
		this.txtCantidadPlan = txtCantidadPlan;
	}

	public InputText getTxtCierreOt() {
		return txtCierreOt;
	}

	public void setTxtCierreOt(InputText txtCierreOt) {
		this.txtCierreOt = txtCierreOt;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtCostoTotalEstimado() {
		return txtCostoTotalEstimado;
	}

	public void setTxtCostoTotalEstimado(InputText txtCostoTotalEstimado) {
		this.txtCostoTotalEstimado = txtCostoTotalEstimado;
	}

	public InputText getTxtEdadPlanificacion() {
		return txtEdadPlanificacion;
	}

	public void setTxtEdadPlanificacion(InputText txtEdadPlanificacion) {
		this.txtEdadPlanificacion = txtEdadPlanificacion;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtIdMobile() {
		return txtIdMobile;
	}

	public void setTxtIdMobile(InputText txtIdMobile) {
		this.txtIdMobile = txtIdMobile;
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

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtOrdenTrabajo() {
		return txtOrdenTrabajo;
	}

	public void setTxtOrdenTrabajo(InputText txtOrdenTrabajo) {
		this.txtOrdenTrabajo = txtOrdenTrabajo;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public SelectOneMenu getTxtContratistaId_Contratista() {
		return txtContratistaId_Contratista;
	}

	public void setTxtContratistaId_Contratista(SelectOneMenu txtContratistaId_Contratista) {
		this.txtContratistaId_Contratista = txtContratistaId_Contratista;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public SelectOneMenu getTxtServicioId_Servicio() {
		return txtServicioId_Servicio;
	}

	public void setTxtServicioId_Servicio(SelectOneMenu txtServicioId_Servicio) {
		this.txtServicioId_Servicio = txtServicioId_Servicio;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
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

	public Calendar getTxtPeriodoFinal() {
		return txtPeriodoFinal;
	}

	public void setTxtPeriodoFinal(Calendar txtPeriodoFinal) {
		this.txtPeriodoFinal = txtPeriodoFinal;
	}

	public Calendar getTxtPeriodoInicial() {
		return txtPeriodoInicial;
	}

	public void setTxtPeriodoInicial(Calendar txtPeriodoInicial) {
		this.txtPeriodoInicial = txtPeriodoInicial;
	}

	public InputText getTxtPlanLaborId() {
		return txtPlanLaborId;
	}

	public void setTxtPlanLaborId(InputText txtPlanLaborId) {
		this.txtPlanLaborId = txtPlanLaborId;
	}

	public LazyDataModel<DatPlanLaborDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatPlanLaborDTO> datPlanLaborDTO) {
		this.data = datPlanLaborDTO;
	}

	public DatPlanLaborDTO getSelectedDatPlanLabor() {
		return selectedDatPlanLabor;
	}

	public void setSelectedDatPlanLabor(DatPlanLaborDTO datPlanLabor) {
		this.selectedDatPlanLabor = datPlanLabor;
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

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			laborId = new ArrayList<Labor>();

			try {

				laborId = businessDelegatorView.getLabor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborId : lista) {
					selectLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborId;
	}

	public void setselectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			udadMed = new ArrayList<UdadMed>();

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMed[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed;
	}

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			contratista = new ArrayList<PersEmpr>();

			try {

				contratista = businessDelegatorView.getPersEmpr(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratista;
	}

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	private class LocalDataModelDTO extends LazyDataModel<DatPlanLaborDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatPlanLaborDTO> datPlanLaborDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatPlanLaborDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datPlanLaborDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberPlanLabor(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datPlanLaborDTO;

		}

		@Override
		public DatPlanLaborDTO getRowData(String rowKey) {
			for (DatPlanLaborDTO datPlanLaborDTOtmp : datPlanLaborDTO) {
				if (datPlanLaborDTOtmp.getPlanLaborId().toString().equals(rowKey))
					return datPlanLaborDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatPlanLaborDTO datPlanLaborDTOtmp) {
			return datPlanLaborDTOtmp.getPlanLaborId();
		}

	}

	private List<DatPlanLaborDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPagePlanLabor(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Notificaciones
	 * 
	 * @throws Exception
	 */

	public String listener_notificacion() throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		java.util.Date hoy = new Date();
		GregorianCalendar calendario = new GregorianCalendar();
		GregorianCalendar calendario1 = new GregorianCalendar();

		calendario.setTime(hoy);
		int diaHoy = calendario.get(java.util.Calendar.DAY_OF_MONTH);
		int mesHoy = calendario.get(java.util.Calendar.MONTH);
		int anoHoy = calendario.get(java.util.Calendar.YEAR);

		calendario.set(anoHoy, mesHoy, diaHoy);
		java.sql.Date fechaHoy = new java.sql.Date(calendario.getTimeInMillis());

		int i = 0;

		/* Configuracion de la notificacion */

		String tag = "";
		String img = "";
		String texto = "";
		String url = "";
		String sonido = "";

		Object[] condicion = { "estado", true, "A", "=", "cierreOt", true, "A", "=" };

		List<DatPlanLabor> ot = businessDelegatorView.findByCriteriaInDatPlanLabor(condicion, null, null);

		if (ot.size() > 0) {

			for (DatPlanLabor datPlanLabor : ot) {

				calendario1.setTime(datPlanLabor.getPeriodoFinal());
				int dia = calendario1.get(java.util.Calendar.DAY_OF_MONTH);
				int mes = calendario1.get(java.util.Calendar.MONTH);
				int ano = calendario1.get(java.util.Calendar.YEAR);
				calendario1.set(ano, mes, dia);
				java.sql.Date fecha = new java.sql.Date(calendario1.getTimeInMillis());

				if (fechaHoy.getTime() > fecha.getTime()) {

					i = i + 1;

				}
			}
		}

		tag = "notificacion_01";
		img = contextPath + "/images/agroview.png";
		texto = "Al Hoy " + fechaHoy + " Existen " + "(" + i + ")" + " ordenes de trabajo con atraso";
		url = contextPath + "/XHTML/tmp_inicio.xhtml";
		sonido = contextPath + "/images/notificacion_windows_10.mp3";

		/*
		 * contextNotifi.addCallbackParam("texto", texto);
		 * contextNotifi.addCallbackParam("tag", tag);
		 * contextNotifi.addCallbackParam("img", img);
		 * contextNotifi.addCallbackParam("url", url);
		 * contextNotifi.addCallbackParam("sonido", sonido);
		 */

		/*
		 * Genera JSON notify/
		 */
		/*
		 * ServletContext servletContext; servletContext = (ServletContext)
		 * FacesContext.getCurrentInstance() .getExternalContext().getContext();
		 * 
		 * String path = servletContext.getRealPath("");
		 * 
		 * 
		 * Date fecha = new Date();
		 * 
		 * Map<String, String> data = new HashMap<String, String>();
		 * 
		 * data.put("body",texto); data.put("tag", tag); data.put("img", img);
		 * data.put("url", url); data.put("sonido", sonido);
		 * 
		 * JSONObject obj = new JSONObject(); obj.putAll(data);
		 * 
		 * try { FileWriter file = new
		 * FileWriter(path+"notificaciones/"+"notify_otAtrazada.json");
		 * //FileWriter file = new FileWriter("E://"+"notify_otAtrazada.json");
		 * file.write(obj.toJSONString()); //file.write(jsonObj.toJSONString());
		 * file.flush(); file.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

		return "";
	}

	public String action_addEventoGoogleCalendar(ActionEvent evt) throws Exception {

		selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyMMdd");

		fechaIni = dmyFormat.format(selectedDatPlanLabor.getPeriodoInicial());
		fechaFin = dmyFormat.format(selectedDatPlanLabor.getPeriodoFinal());

		titulo = "AgroView: Programación de la O.T " + selectedDatPlanLabor.getOrdenTrabajo();
		descripcion = "Hacienda: " + selectedDatPlanLabor.getNivel2Nombre().toString() + " Lote: "
				+ selectedDatPlanLabor.getNivel4Nombre().toString() + " Labor: "
				+ selectedDatPlanLabor.getLaborNombre().toString() + " Orden de Trabajo: "
				+ selectedDatPlanLabor.getOrdenTrabajo();

		localizacion = "Hacienda: " + selectedDatPlanLabor.getNivel2Nombre().toString() + " Lote: "
				+ selectedDatPlanLabor.getNivel4Nombre().toString();

		url = "http://www.google.com/calendar/event?action=TEMPLATE&text=" + titulo + "&details=" + descripcion
				+ "&dates=" + fechaIni + "/" + fechaFin + "&location=" + localizacion;
		
		PrimeFaces.current().ajax().addCallbackParam("url", url);

		clearEventos();

		return "";

	}

	public String action_addEventoOutLookCalendar(ActionEvent evt) throws Exception {

		selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyMMdd");

		fechaIni = dmyFormat.format(selectedDatPlanLabor.getPeriodoInicial());
		fechaFin = dmyFormat.format(selectedDatPlanLabor.getPeriodoFinal());

		titulo = "AgroView: Programación de la O.T " + selectedDatPlanLabor.getOrdenTrabajo();
		descripcion = "Hacienda: " + selectedDatPlanLabor.getNivel2Nombre().toString() + " Lote: "
				+ selectedDatPlanLabor.getNivel4Nombre().toString() + " Labor: "
				+ selectedDatPlanLabor.getLaborNombre().toString() + " Orden de Trabajo: "
				+ selectedDatPlanLabor.getOrdenTrabajo();

		localizacion = "Hacienda: " + selectedDatPlanLabor.getNivel2Nombre().toString() + " Lote: "
				+ selectedDatPlanLabor.getNivel4Nombre().toString();

		url = "http://calendar.live.com/calendar/calendar.aspx?rru=addevent&summary=" + titulo + "&description="
				+ descripcion + "&dtstart=" + fechaIni + "&dtend=" + fechaFin + "&location=" + localizacion;

		// http://calendar.live.com/calendar/calendar.aspx?rru=addevent&summary="+titulo+"&description="+descripcion+"&dtstart="+fechaIni+"&dtend="+fechaFin+"&location="+localizacion;

		PrimeFaces.current().ajax().addCallbackParam("urlOutLook", url);

		clearEventos();

		return "";

	}

	/*
	 * public String getGraficarGanttPlanLabor() throws Exception{
	 * 
	 * RequestContext reqCtx = RequestContext.getCurrentInstance();
	 * GregorianCalendar calendarioPeriodoFin = new GregorianCalendar();
	 * GregorianCalendar calendarioPeriodoInicial = new GregorianCalendar();
	 * DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
	 * simbolos.setDecimalSeparator('.'); String pattern = "###.##";
	 * DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
	 * String ordenTrabajoTmp = ""; String nombreLabor = ""; Long duracion = 0L;
	 * Long duracionTotal = 0L; Long idOrdenTrabajo = 0L;
	 * 
	 * Object[] condicion = { "estado", true, "A", "=", "cierreOt",true, "A",
	 * "="};
	 * 
	 * List<DatPlanLabor> ordenTrabajo=
	 * businessDelegatorView.findByCriteriaInDatPlanLabor(condicion, null,null);
	 * 
	 * if(ordenTrabajo != null && ordenTrabajo.size() >0){
	 * 
	 * for (DatPlanLabor datPlanLabor : ordenTrabajo) {
	 * 
	 * //id plan labor idOrdenTrabajo = datPlanLabor.getPlanLaborId();
	 * 
	 * //Orden de trabajo ordenTrabajoTmp =
	 * datPlanLabor.getOrdenTrabajo().toString();
	 * 
	 * // Periodo Inicial
	 * calendarioPeriodoInicial.setTime(datPlanLabor.getPeriodoInicial()); int
	 * diaI = calendarioPeriodoInicial.get(java.util.Calendar.DAY_OF_MONTH); int
	 * mesI = calendarioPeriodoInicial.get(java.util.Calendar.MONTH); int anoI =
	 * calendarioPeriodoInicial.get(java.util.Calendar.YEAR);
	 * calendarioPeriodoInicial.set(anoI, mesI, diaI); java.sql.Date
	 * fechaPeriodoInicial = new
	 * java.sql.Date(calendarioPeriodoInicial.getTimeInMillis());
	 * 
	 * // Periodo Final
	 * calendarioPeriodoFin.setTime(datPlanLabor.getPeriodoFinal()); int diaF =
	 * calendarioPeriodoFin.get(java.util.Calendar.DAY_OF_MONTH); int mesF =
	 * calendarioPeriodoFin.get(java.util.Calendar.MONTH); int anoF =
	 * calendarioPeriodoFin.get(java.util.Calendar.YEAR);
	 * calendarioPeriodoFin.set(anoF, mesF, diaF); java.sql.Date
	 * fechaPeriodoFinal = new
	 * java.sql.Date(calendarioPeriodoFin.getTimeInMillis());
	 * 
	 * // Duración SimpleDateFormat dmyFormat = new
	 * SimpleDateFormat("dd-MM-yyyy"); fechaInicioPlan =
	 * dmyFormat.format(fechaPeriodoInicial); fechaFinPlan =
	 * dmyFormat.format(fechaPeriodoFinal);
	 * 
	 * // Calculamos los dias del Plan duracion = (fechaPeriodoFinal.getTime() -
	 * fechaPeriodoInicial.getTime())/(24 * 60 * 60 * 1000);
	 * 
	 * duracionTotal +=duracion;
	 * 
	 * // Nombre de la labor Labor laborPlan =
	 * businessDelegatorView.getLabor(datPlanLabor.getLabor().getLaborId());
	 * nombreLabor = laborPlan.getNombre().toString();
	 * 
	 * //pasamos los parametros a JavaScript reqCtx.addCallbackParam("id",
	 * idOrdenTrabajo); reqCtx.addCallbackParam("ordenTrabajo",
	 * ordenTrabajoTmp); reqCtx.addCallbackParam("tarea", nombreLabor);
	 * reqCtx.addCallbackParam("inicio", fechaInicioPlan);
	 * reqCtx.addCallbackParam("Final", fechaFinPlan);
	 * reqCtx.addCallbackParam("duracion", duracion);
	 * reqCtx.addCallbackParam("duracionTotal", duracionTotal);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * reqCtx.execute("PF('dlg').show();");
	 * 
	 * return "";
	 * 
	 * }
	 */

	public String action_detallePlanLabor(ActionEvent evt) {

		selectedDatPlanLabor = (DatPlanLaborDTO) (evt.getComponent().getAttributes().get("selectedDatPlanLabor"));

		clearDetallPlan();

		try {

			Long planLaborId = new Long(selectedDatPlanLabor.getPlanLaborId());
			entity = businessDelegatorView.getDatPlanLabor(planLaborId);

			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.##";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			if (entity.getCierreOt().equals("A")) {

				java.util.Date hoy = new Date();
				GregorianCalendar calendarioPeriodoFin = new GregorianCalendar();
				GregorianCalendar calendarioPeriodoInicial = new GregorianCalendar();
				GregorianCalendar calendarioFechaHoy = new GregorianCalendar();

				codigoOT = entity.getOrdenTrabajo().longValue();

				Nivel2 nivel2 = businessDelegatorView.getNivel2(entity.getNivel2Id().getNivel2Id());
				hacienda = nivel2.getNombre().toString();
				Nivel4 nivel4 = businessDelegatorView.getNivel4(entity.getNivel4().getNivel4Id());
				lote = nivel4.getNombre().toString();
				Labor laborPlan = businessDelegatorView.getLabor(entity.getLabor().getLaborId());
				labor = laborPlan.getNombre().toString();
				Trabajador supervisor1 = null;
				if (entity.getTrabajador() != null) {
					supervisor1 = businessDelegatorView.getTrabajador(entity.getTrabajador().longValue());
					if (supervisor1 != null) {
						supervisor = supervisor1.getNombre().toString();
					} else {
						supervisor = "";
					}
				}

				/* procesando las fechas */

				// Periodo Inicial

				calendarioPeriodoInicial.setTime(entity.getPeriodoInicial());
				int diaI = calendarioPeriodoInicial.get(java.util.Calendar.DAY_OF_MONTH);
				int mesI = calendarioPeriodoInicial.get(java.util.Calendar.MONTH);
				int anoI = calendarioPeriodoInicial.get(java.util.Calendar.YEAR);
				calendarioPeriodoInicial.set(anoI, mesI, diaI);
				java.sql.Date fechaPeriodoInicial = new java.sql.Date(calendarioPeriodoInicial.getTimeInMillis());

				// Periodo Final

				calendarioPeriodoFin.setTime(entity.getPeriodoFinal());
				int diaF = calendarioPeriodoFin.get(java.util.Calendar.DAY_OF_MONTH);
				int mesF = calendarioPeriodoFin.get(java.util.Calendar.MONTH);
				int anoF = calendarioPeriodoFin.get(java.util.Calendar.YEAR);
				calendarioPeriodoFin.set(anoF, mesF, diaF);
				java.sql.Date fechaPeriodoFinal = new java.sql.Date(calendarioPeriodoFin.getTimeInMillis());

				// Fecha Actual

				calendarioFechaHoy.setTime(hoy);
				int diaHoy = calendarioFechaHoy.get(java.util.Calendar.DAY_OF_MONTH);
				int mesHoy = calendarioFechaHoy.get(java.util.Calendar.MONTH);
				int anoHoy = calendarioFechaHoy.get(java.util.Calendar.YEAR);

				calendarioFechaHoy.set(anoHoy, mesHoy, diaHoy);
				java.sql.Date fechaHoy = new java.sql.Date(calendarioFechaHoy.getTimeInMillis());

				SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

				fechaInicioPlan = dmyFormat.format(fechaPeriodoInicial);
				fechaFinPlan = dmyFormat.format(fechaPeriodoFinal);

				// Calculamos los dias del Plan

				duracionDiasPlan = (fechaPeriodoFinal.getTime() - fechaPeriodoInicial.getTime())
						/ (24 * 60 * 60 * 1000);

				// Calculamos los dias Reales

				duracionDiasReal = (fechaHoy.getTime() - fechaPeriodoInicial.getTime()) / (24 * 60 * 60 * 1000);

				// Planilla de Nomina

				Object[] condicionNomina = { "estado", true, "A", "=", "ordenTrabajo.planLaborId", false,
						entity.getPlanLaborId().longValue(), "=" };

				List<DatPlanillaNomina> nomina = businessDelegatorView
						.findByCriteriaInDatPlanillaNomina(condicionNomina, null, null);

				if (nomina.size() > 0 && nomina != null) {
					for (DatPlanillaNomina datPlanillaNomina : nomina) {
						apuntamientosNomina = apuntamientosNomina + 1;
						costosNomina += Double
								.parseDouble(decimalFormat.format(datPlanillaNomina.getCostoTotal().doubleValue()));

					}

				}

				// Servicios

				Object[] condicionSerivio = { "estado", true, "A", "=", "ordenTrabajo.planLaborId", false,
						entity.getPlanLaborId().longValue(), "=" };

				List<DatServicio> serivicio = businessDelegatorView.findByCriteriaInDatServicio(condicionSerivio, null,
						null);

				if (serivicio.size() > 0 && serivicio != null) {

					for (DatServicio datServicio : serivicio) {
						apuntamientosServicios = apuntamientosServicios + 1;
						costosServicios += Double
								.parseDouble(decimalFormat.format(datServicio.getCostoTotal().doubleValue()));

					}

				}

				// Riegos

				Object[] condicionRiego = { "estado", true, "A", "=", "ordenTrabajo.planLaborId", false,
						entity.getPlanLaborId().longValue(), "=" };

				List<DatRiego> riego = businessDelegatorView.findByCriteriaInDatRiego(condicionRiego, null, null);

				if (riego.size() > 0 && riego != null) {
					for (DatRiego datRiego : riego) {
						apuntamientosRiegos = apuntamientosRiegos + 1;
						costosRiegos += Double
								.parseDouble(decimalFormat.format(datRiego.getCostoTotal().doubleValue()));

					}

				}

				// Productos

				Object[] condicionProductos = { "estado", true, "A", "=", "ordenTrabajo.planLaborId", false,
						entity.getPlanLaborId().longValue(), "=" };

				List<DatAplicProducto> producto = businessDelegatorView
						.findByCriteriaInDatAplicProducto(condicionProductos, null, null);

				DatAplicProdDet detalle = null;

				if (producto.size() > 0 && producto != null) {

					for (DatAplicProducto datAplicProducto : producto) {
						apuntamientosProductos = apuntamientosProductos + 1;
						detalle = businessDelegatorView
								.getDatAplicProdDet(datAplicProducto.getDatAplicProdId().longValue());

						costosProductos += Double
								.parseDouble(decimalFormat.format(detalle.getCostoTotal().doubleValue()));

					}

				}

				total = costosNomina + costosServicios + costosRiegos + costosProductos;

				setShowDialog(true);

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public void clearEventos() {

		selectedDatPlanLabor = null;
		fechaIni = "";
		fechaFin = "";
		descripcion = "";
		titulo = "";
		localizacion = "";
		url = "";

	}

	public void clearDetallPlan() {

		hacienda = "";
		lote = "";
		labor = "";
		supervisor = "";
		fechaInicioPlan = "";
		fechaFinPlan = "";
		duracionDiasPlan = 0L;
		duracionDiasReal = 0L;
		apuntamientosNomina = 0;
		costosNomina = 0;
		apuntamientosRiegos = 0;
		apuntamientosServicios = 0;
		costosServicios = 0;
		apuntamientosProductos = 0;
		costosProductos = 0;
		costosRiegos = 0;
		codigoOT = 0L;

	}

	public DatPlanLabor getSelectedPlanLabor() {
		return SelectedPlanLabor;
	}

	public void setSelectedPlanLabor(DatPlanLabor selectedPlanLabor) {
		SelectedPlanLabor = selectedPlanLabor;
	}

	public String getHacienda() {
		return hacienda;
	}

	public void setHacienda(String hacienda) {
		this.hacienda = hacienda;
	}

	public String getLote() {
		return lote;
	}

	public String getLabor() {
		return labor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public String getFechaInicioPlan() {
		return fechaInicioPlan;
	}

	public String getFechaFinPlan() {
		return fechaFinPlan;
	}

	public Long getDuracionDiasPlan() {
		return duracionDiasPlan;
	}

	public Long getDuracionDiasReal() {
		return duracionDiasReal;
	}

	public int getApuntamientosNomina() {
		return apuntamientosNomina;
	}

	public double getCostosNomina() {
		return costosNomina;
	}

	public int getApuntamientosRiegos() {
		return apuntamientosRiegos;
	}

	public int getApuntamientosServicios() {
		return apuntamientosServicios;
	}

	public double getCostosServicios() {
		return costosServicios;
	}

	public int getApuntamientosProductos() {
		return apuntamientosProductos;
	}

	public double getCostosProductos() {
		return costosProductos;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setLabor(String labor) {
		this.labor = labor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public void setFechaInicioPlan(String fechaInicioPlan) {
		this.fechaInicioPlan = fechaInicioPlan;
	}

	public void setFechaFinPlan(String fechaFinPlan) {
		this.fechaFinPlan = fechaFinPlan;
	}

	public void setDuracionDiasPlan(Long duracionDiasPlan) {
		this.duracionDiasPlan = duracionDiasPlan;
	}

	public void setDuracionDiasReal(Long duracionDiasReal) {
		this.duracionDiasReal = duracionDiasReal;
	}

	public void setApuntamientosNomina(int apuntamientosNomina) {
		this.apuntamientosNomina = apuntamientosNomina;
	}

	public void setCostosNomina(int costosNomina) {
		this.costosNomina = costosNomina;
	}

	public void setApuntamientosRiegos(int apuntamientosRiegos) {
		this.apuntamientosRiegos = apuntamientosRiegos;
	}

	public void setApuntamientosServicios(int apuntamientosServicios) {
		this.apuntamientosServicios = apuntamientosServicios;
	}

	public void setCostosServicios(int costosServicios) {
		this.costosServicios = costosServicios;
	}

	public void setApuntamientosProductos(int apuntamientosProductos) {
		this.apuntamientosProductos = apuntamientosProductos;
	}

	public void setCostosProductos(double costosProductos) {
		this.costosProductos = costosProductos;
	}

	public double getCostosRiegos() {
		return costosRiegos;
	}

	public void setCostosRiegos(int costosRiegos) {
		this.costosRiegos = costosRiegos;
	}

	public Long getCodigoOT() {
		return codigoOT;
	}

	public void setCodigoOT(Long codigoOT) {
		this.codigoOT = codigoOT;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEventoFechaIni() {
		return eventoFechaIni;
	}

	public String getEventoFechaFin() {
		return eventoFechaFin;
	}

	public void setEventoFechaIni(String eventoFechaIni) {
		this.eventoFechaIni = eventoFechaIni;
	}

	public void setEventoFechaFin(String eventoFechaFin) {
		this.eventoFechaFin = eventoFechaFin;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFechaIni() {
		return fechaIni;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

}
