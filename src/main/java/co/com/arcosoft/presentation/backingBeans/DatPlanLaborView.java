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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code. google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatPlanLaborView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanLaborView.class);
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
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtOrdenTrabajo;
	private InputText txtPrecision;
	private InputText txtUsuarioDigitacion;
	private InputText txtPlanLaborId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtPeriodoFinal;
	private Calendar txtPeriodoInicial;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatPlanLaborDTO> data;
	private DatPlanLaborDTO selectedDatPlanLabor;
	
	private DatPlanLabor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

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

	/*************** detalle plan labor ***/
	
	private List<DatPlanLaborDetDTO> dataPlanLaborDet;
	private DatPlanLaborDetDTO selectedDataPlanLaborDet;
	private InputText txtCodNivel2;
	private InputText txtCodNivel4;
	private InputText txtCodUdadMed;

	private CommandButton btnAgregar;
	
	private DatPlanLaborDet entityDatPlanLaborDet;
	
	SelectItem[] selectNivel2Edit;
	private List<Nivel2> nivel2Edit;
	
	SelectItem[] selectNivel4Edit;
	private List<Nivel4> nivel4Edit;

	/***************************************/

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

	/************ reporte****/
	
	private SelectOneMenu txtCompania1;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	
	private List<ProgramacionLaboresDTO> data2;
	private List<ProgramacionLaboresDTO> selectedDatPlanLabor2;	

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private List<String> selectedNivel1;
	private List<Nivel1> zonas;

	private List<String> selectedNivel2;
	private List<Nivel2> fincas;

	private List<String> selectedNivel3;
	private List<Nivel3> bloques;

	private List<String> selectedNivel4;
	private List<Nivel4> lotes;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private String disableButton = "false";
	private String disableButton1 = "false";
	private String disableNivel1 = "true";
	private String disableNivel2 = "true";
	
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputNumber txtPlanilla;

	public String action_informe1() {
	
		setShowDialog(true);
		return "";
	}

	
	public DatPlanLaborView() {
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
			txtNPases.setDisabled(false);
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
			txtCostoTotalEstimado.setDisabled(false);
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
			txtContratistaId_Contratista.setDisabled(false);
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
			txtServicioId_Servicio.setDisabled(false);
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

		if (txtCodNivel2 != null) {
			txtCodNivel2.setValue(null);
			txtCodNivel2.setDisabled(false);
		}
		if (txtCodNivel4 != null) {
			txtCodNivel4.setValue(null);
			txtCodNivel4.setDisabled(false);
		}

		if (txtCodUdadMed != null) {
			txtCodUdadMed.setValue(null);
			txtCodUdadMed.setDisabled(false);
		}

		if (dataPlanLaborDet != null) {
			dataPlanLaborDet = null;

		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
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
				txtUdadMedId_UdadMed.setValue(labor.getUdadMedByUdadMedPlan());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_CarguePlantasHaLote() {

		Long udadMedId = null;
		Long nivel4Id = null;
		Long nivel2Id = null;
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');

		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Double result = 0.0;

		if (txtUdadMedId_UdadMed.getValue()!=null && txtNivel4Id_Nivel4.getValue() !=null
				&& txtNivel2Id.getValue()!=null) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);

				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

				if (udadMed.getClasificacionUm() != null) {
					if (udadMed.getClasificacionUm().equals("Ha")) {
						result = nivel4.getAreaNeta().doubleValue();
						String format = decimalFormat.format(result);
						txtCantidadPlan.setValue(format);
					}
					if (udadMed.getClasificacionUm().equals("Plantas")
							|| udadMed.getClasificacionUm().equals("Palmas")) {
						result = nivel4.getNumPlantasActuales().doubleValue();
						String format = decimalFormat.format(result);
						txtCantidadPlan.setValue(format);
					}
					if(!udadMed.getClasificacionUm().equals("Plantas") &&  !udadMed.getClasificacionUm().equals("Ha")){
						result = 0.0;
						String format = decimalFormat.format(result);
						txtCantidadPlan.setValue(format);
						
					}
						
				}else{
					result = 0.0;
					String format = decimalFormat.format(result);
					txtCantidadPlan.setValue(format);
				
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
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

				txtNPases.setValue(entity.getNPases());
				txtNPases.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtOrdenTrabajo.setValue(entity.getOrdenTrabajo());
				txtOrdenTrabajo.setDisabled(true);
				txtPeriodoFinal.setValue(entity.getPeriodoFinal());
				txtPeriodoFinal.setDisabled(false);
				txtPeriodoInicial.setValue(entity.getPeriodoInicial());
				txtPeriodoInicial.setDisabled(false);
				txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
				txtLaborId_Labor.setDisabled(false);

				txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
				txtUdadMedId_UdadMed.setDisabled(false);

				txtTrabId_Trabajador.setValue(entity.getTrabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtPlanLaborId.setValue(entity.getPlanLaborId());
				txtPlanLaborId.setDisabled(true);

				btnSave.setDisabled(false);

				/******* sesion concerniente al detalle planificacion ***/
				txtNivel1Id.setDisabled(false);
				txtNivel2Id.setDisabled(false);
				txtNivel3Id.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);

				txtCantidadPlan.setDisabled(false);

				Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
				dataPlanLaborDet = null;
				dataPlanLaborDet = businessDelegatorView.getDataDatPlanLaborDetByPlan(planLaborId);

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
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			entity.setNPases(FacesUtils.checkLong(txtNPases));
			entity.setCantidadPlan(FacesUtils.checkDouble(txtCantidadPlan));
			String cierre = "A";
			entity.setCierreOt(cierre);
			entity.setCompania(compania);
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(txtCostoTotalEstimado));
			String estado = "A";
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(FacesUtils.checkDate(txtPeriodoInicial));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			
			entity.setAnio((new Long(anioRegistro)));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));			
			entity.setOrdenTrabajo((businessDelegatorView.consultarConsecutivoDatPlanLabor(compania)));
			entity.setUsuarioDigitacion(usuarioId);
			
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista)));
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);
			
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio)));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			entity.setOrdenTrabajo((businessDelegatorView.consultarConsecutivoDatPlanLabor(compania)));

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
			entity.setNPases(FacesUtils.checkLong(txtNPases));
			entity.setCantidadPlan(FacesUtils.checkDouble(txtCantidadPlan));
			entity.setCompania(compania);
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(txtCostoTotalEstimado));
			entity.setFechaModificacion(date);
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOrdenTrabajo(FacesUtils.checkLong(txtOrdenTrabajo));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(FacesUtils.checkDate(txtPeriodoInicial));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			
			entity.setAnio((new Long(anioRegistro)));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista)));
			
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)					
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) : null);
			
			entity.setServicio((FacesUtils.checkLong(txtServicioId_Servicio)));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);

			businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();
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

				dataPlanLaborDet = null;
				dataPlanLaborDet = businessDelegatorView.getDataDatPlanLaborDetByPlan(planLaborId);

				businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYCLOSEOT);
				action_clear();
				data = null;

			} else {

				Date date = new Date();
				entity.setFechaReaperturaOt(date);
				entity.setCierreOt("A");
				dataPlanLaborDet = null;
				dataPlanLaborDet = businessDelegatorView.getDataDatPlanLaborDetByPlan(planLaborId);

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
			Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
			dataPlanLaborDet = null;
			dataPlanLaborDet = businessDelegatorView.getDataDatPlanLaborDetByPlan(planLaborId);

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatPlanLabor(entity, dataPlanLaborDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
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
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}
	
	public void onCellEditPlanLabor(CellEditEvent event) throws Exception {

		selectedDataPlanLaborDet = (DatPlanLaborDetDTO) (event.getComponent().getAttributes()
				.get("selectedDataPlanLaborDet"));
		
		if (selectedDataPlanLaborDet.getPlanLaborDetId() != null) {

			Long planLaborDetId = selectedDataPlanLaborDet.getPlanLaborDetId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long planLaborId = FacesUtils.checkLong(txtPlanLaborId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityDatPlanLaborDet = null;
	
				entityDatPlanLaborDet = businessDelegatorView.getDatPlanLaborDet(planLaborDetId);
	
				if (columnaCell.equals("Hacienda")) {
	
					Long nivel2 = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2);
	
					entityDatPlanLaborDet.setNivel2(Nivel2);
	
				} else if (columnaCell.equals("Lote")) {
	
					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);
	
					entityDatPlanLaborDet.setNivel4(Nivel4);
					
				} else if (columnaCell.equals("Cantidad Plan")) {
	
					entityDatPlanLaborDet.setCantidadPlan((Double) newValue);
	
				}
	
				entity = businessDelegatorView.getDatPlanLabor(planLaborId);
				entityDatPlanLaborDet.setDatPlanLabor(entity);
				businessDelegatorView.updateDatPlanLaborDet(entityDatPlanLaborDet);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataPlanLaborDet = null;
				entityDatPlanLaborDet = null;
				selectedDataPlanLaborDet = null;
				entity = null;
	
				dataPlanLaborDet = businessDelegatorView.getDataDatPlanLaborDetByPlan(planLaborId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}
		

	}
	


	public void listarPlanLabor() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Long compania = new Long(getCompaniaIdSession());
			Long planilla = FacesUtils.checkLong(txtPlanilla);
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			
			if (planilla == null) {
				planilla = 0L;
			}

			if (compania != null && fechaInicial != null && fechaFinal != null) {
				
				data = businessDelegator2View.pr_lista_plan_labor(compania, fechaInicial, fechaFinal, planilla);

			} else if (compania != null && fechaInicial == null && fechaFinal == null && planilla != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data = businessDelegator2View.pr_lista_plan_labor(compania, fechaInicial, fechaFinal, planilla);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

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
	
	public List<DatPlanLaborDTO> getData() {
		return data;
	}

	public void setData(List<DatPlanLaborDTO> datPlanLaborDTO) {
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

				nivel1 = businessDelegatorView.getNivel1(); 
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

			

			try {

				trabajador = businessDelegatorView.getTrabajador(); 
				Object[] condicion = { "estado", true, "A", "="
						, "profesion.funciones", true, "Asistente técnico", "<>"
						, "profesion.funciones", true, "Otros", "<>"
						, "profesion.funciones", true, "Administrativo", "<>"

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

				laborId = businessDelegatorView.getLabor(); 
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

				udadMed = businessDelegatorView.getUdadMed(); 
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

				contratista = businessDelegatorView.getPersEmpr(); 
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
	
	public SelectItem[] getSelectNivel2Edit() {

		if (nivel2Edit == null || nivel2Edit.size() == 0) {

			nivel2Edit = new ArrayList<Nivel2>();
			
			try {

				nivel2Edit = businessDelegatorView.getNivel2(); 
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Edit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Edit : lista) {
					selectNivel2Edit[i] = new SelectItem(nivel2Edit.getNivel2Id(), nivel2Edit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Edit;
	}


	public void setSelectNivel2Edit(SelectItem[] selectNivel2Edit) {

		this.selectNivel2Edit = selectNivel2Edit;
	}
	
	public SelectItem[] getSelectNivel4Edit() {

		if (nivel4Edit == null || nivel4Edit.size() == 0) {

			nivel4Edit = new ArrayList<Nivel4>();
			
			try {

				nivel4Edit = businessDelegatorView.getNivel4();
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4Edit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4Edit : lista) {
					selectNivel4Edit[i] = new SelectItem(nivel4Edit.getNivel4Id(), nivel4Edit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4Edit;
	}
	
	public void setSelectNivel4Edit(SelectItem[] selectNivel4Edit) {
		this.selectNivel4Edit = selectNivel4Edit;
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

	public List<DatPlanLaborDetDTO> getDataPlanLaborDet() {
		return dataPlanLaborDet;
	}

	public void setDataPlanLaborDet(List<DatPlanLaborDetDTO> dataPlanLaborDet) {
		this.dataPlanLaborDet = dataPlanLaborDet;
	}

	public InputText getTxtCodNivel2() {
		return txtCodNivel2;
	}

	public void setTxtCodNivel2(InputText txtCodNivel2) {
		this.txtCodNivel2 = txtCodNivel2;
	}

	public InputText getTxtCodNivel4() {
		return txtCodNivel4;
	}

	public void setTxtCodNivel4(InputText txtCodNivel4) {
		this.txtCodNivel4 = txtCodNivel4;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	/********* detalle plan labor ****/

	public void action_agregarPlanLaborDet() throws Exception {

		if (txtUdadMedId_UdadMed.getValue() != null && txtNivel4Id_Nivel4.getValue() != null
				&& txtNivel2Id.getValue() != null && txtCantidadPlan.getValue() != null ) {

			Long nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

			Long nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
			Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
			
			Double edadPlanificacion = businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(txtPeriodoInicial),
					FacesUtils.checkLong(txtNivel4Id_Nivel4));

			String codNivel2 = nivel2.getNombre();
			String codNivel4 = nivel4.getNombre();

			Double cantidadPlan = FacesUtils.checkDouble(txtCantidadPlan);

			boolean existeProducto = false;

			if (dataPlanLaborDet == null) {
				dataPlanLaborDet = new ArrayList<DatPlanLaborDetDTO>();

			}

			if (dataPlanLaborDet.size() > 0) {

				for (DatPlanLaborDetDTO d : dataPlanLaborDet) {

					if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4.getNivel4Id().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"El lote " + d.getNivel4Id_Nivel4().getCodigo().toString()
												+ d.getNivel4Id_Nivel4().getNombre().toString()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				DatPlanLaborDetDTO datPlanLaborDetDTO2 = new DatPlanLaborDetDTO();
				
				datPlanLaborDetDTO2.setCantidadPlan(cantidadPlan);
				datPlanLaborDetDTO2.setNivel2Id_Nivel2(nivel2);
				datPlanLaborDetDTO2.setNivel2Nombre(codNivel2);
				datPlanLaborDetDTO2.setNivel4Id_Nivel4(nivel4);
				datPlanLaborDetDTO2.setNivel4Nombre(codNivel4);
				datPlanLaborDetDTO2.setEdadPlanificacion(edadPlanificacion);

				dataPlanLaborDet.add(datPlanLaborDetDTO2);
			}
			
			nivel2 = null;
			nivel4 = null;
			nivel2Id = null;
			nivel4Id = null;
			codNivel2 = null;
			codNivel4 = null;
			cantidadPlan = null;
			edadPlanificacion = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  finca, lote, cantidad planificada tengan valores. "));
		}

	}

	public String actionDeleteDatPlanLaborDet(ActionEvent evt) {
		try {

			selectedDataPlanLaborDet = (DatPlanLaborDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDataPlanLaborDet"));

			if (selectedDataPlanLaborDet.getPlanLaborDetId() == null) {
				dataPlanLaborDet.remove(selectedDataPlanLaborDet);
			} else {
				Long planLaborDetId = new Long(selectedDataPlanLaborDet.getPlanLaborDetId());
				DatPlanLaborDet entity = businessDelegatorView.getDatPlanLaborDet(planLaborDetId);
				businessDelegatorView.deleteDatPlanLaborDet(entity);
				dataPlanLaborDet.remove(selectedDataPlanLaborDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	/**********************************/

	public void itemSelect(ItemSelectEvent event) {

		setShowDialog(true);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	
	public List<ProgramacionLaboresDTO> getData2() throws Exception {
		try {
			
			Long compania = new Long(getCompaniaIdSession());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			
			Long flagZona = 1L;
			Long flagFinca = 1L;
			Long flagBloque = 1L;
			Long flagLote = 1L;
			Long flagLabor = 1L;
			Long flagGrupoLabor = 1L;

			String zonasSeleccionadas = "";
			if (selectedNivel1 != null && selectedNivel1.size() > 0) {				
				zonasSeleccionadas = selectedNivel1.get(0);
				flagZona = 0L;
				for (int i = 1; i < selectedNivel1.size(); i++) {
					zonasSeleccionadas += "," + selectedNivel1.get(i);
				}
			} else {
				zonasSeleccionadas = "0";
			}

			String fincasSeleccionadas = "";
			if (selectedNivel2 != null && selectedNivel2.size() > 0) {
				fincasSeleccionadas = selectedNivel2.get(0);
				flagFinca = 0L;
				for (int i = 1; i < selectedNivel2.size(); i++) {
					fincasSeleccionadas += "," + selectedNivel2.get(i);
				}
			} else {
				fincasSeleccionadas = "0";
			}

			String bloquesSeleccionadas = "";
			if (selectedNivel3 != null && selectedNivel3.size() > 0) {				
				bloquesSeleccionadas = selectedNivel3.get(0);
				flagBloque = 0L;
				for (int i = 1; i < selectedNivel3.size(); i++) {
					bloquesSeleccionadas += "," + selectedNivel3.get(i);
				}
			} else {
				bloquesSeleccionadas = "0";
			}

			String lotesSeleccionadas = "";
			if (selectedNivel4 != null && selectedNivel4.size() > 0) {				
				lotesSeleccionadas = selectedNivel4.get(0);
				flagLote = 0L;
				for (int i = 1; i < selectedNivel4.size(); i++) {
					lotesSeleccionadas += "," + selectedNivel4.get(i);
				}
			} else {
				lotesSeleccionadas = "0";
			}

			String laboresSeleccionadas = "";
			if (selectedLabor != null && selectedLabor.size() > 0) {				
				laboresSeleccionadas = selectedLabor.get(0);
				flagLabor = 0L;
				for (int i = 1; i < selectedLabor.size(); i++) {
					laboresSeleccionadas += "," + selectedLabor.get(i);
				}
			} else {
				laboresSeleccionadas = "0";
			}

			String grupoLaboresSeleccionadas = "";
			if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {				
				grupoLaboresSeleccionadas = selectedGrupoLabor.get(0);
				flagGrupoLabor = 0L;
				for (int i = 1; i < selectedGrupoLabor.size(); i++) {
					grupoLaboresSeleccionadas += "," + selectedGrupoLabor.get(i);
				}
			} else {
				grupoLaboresSeleccionadas = "0";
			}
			
			if(txtFechaInicial.getValue() !=null && txtFechaFinal.getValue() !=null )
			data2 = businessDelegatorView.consultarInformeProgramacionLabores(compania, fechaInicial, fechaFinal,
					zonasSeleccionadas, flagZona, fincasSeleccionadas, flagFinca, bloquesSeleccionadas, flagBloque,
					lotesSeleccionadas, flagLote, laboresSeleccionadas, flagLabor, grupoLaboresSeleccionadas,
					flagGrupoLabor, "", 1L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Long usuarioId = new Long(getUsuarioIdSession());
		Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
		if(usuario.getNivelAutorizacion1() != null){
			if(usuario.getNivelAutorizacion1().equals("SI")	){
				disableNivel1 = "false";
			}
		
		}
		
		if(usuario.getNivelAutorizacion2() != null){
			if(usuario.getNivelAutorizacion2().equals("SI")	){
				disableNivel2 = "false";
			}
		}
		return data2;
	}

	/**
	 * @return the txtCompania1
	 */
	public SelectOneMenu getTxtCompania1() {
		return txtCompania1;
	}

	/**
	 * @param txtCompania1 the txtCompania1 to set
	 */
	public void setTxtCompania1(SelectOneMenu txtCompania1) {
		this.txtCompania1 = txtCompania1;
	}

	/**
	 * @return the txtFechaInicial
	 */
	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	/**
	 * @param txtFechaInicial the txtFechaInicial to set
	 */
	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	/**
	 * @return the txtFechaFinal
	 */
	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	/**
	 * @param txtFechaFinal the txtFechaFinal to set
	 */
	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}


	public SelectItem[] getSelectCompania() {
		if (compania == null || compania.size() == 0) {

			try {

				compania = businessDelegatorView.getCompania();
				Object[] condicion = { "estado", true, "A", "=" };
				List<Compania> lista = businessDelegatorView.findByCriteriaInCompania(condicion, null, null);
				selectCompania = new SelectItem[lista.size()];

				int i = 0;
				for (Compania compania : lista) {
					selectCompania[i] = new SelectItem(compania.getCompaniaId(), compania.getNombre());
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


	

	/**
	 * @return the selectedDatPlanLabor2
	 */
	public List<ProgramacionLaboresDTO> getSelectedDatPlanLabor2() {
		return selectedDatPlanLabor2;
	}


	/**
	 * @param selectedDatPlanLabor2 the selectedDatPlanLabor2 to set
	 */
	public void setSelectedDatPlanLabor2(List<ProgramacionLaboresDTO> selectedDatPlanLabor2) {
		this.selectedDatPlanLabor2 = selectedDatPlanLabor2;
	}


	/**
	 * @param data2 the data2 to set
	 */
	public void setData2(List<ProgramacionLaboresDTO> data2) {
		this.data2 = data2;
	}

	
	public void action_valoresSeleccionados() throws Exception {
		String cadena = "";
		Long flagZona=1L;


		ProgramacionLaboresDTO zonasSeleccionadas = null;
		if (selectedDatPlanLabor2 != null && selectedDatPlanLabor2.size() > 0) {
			zonasSeleccionadas = selectedDatPlanLabor2.get(0);
			flagZona = 0L;
			for (int i = 0; i < selectedDatPlanLabor2.size(); i++) {
				zonasSeleccionadas =  selectedDatPlanLabor2.get(i);
				cadena += "," + zonasSeleccionadas.getOrdenTrabajo().toString();
			}
		}
	
	cadena = "0"+cadena;
		
	businessDelegatorView.aprobarOrdenesServicioNivel1(cadena);
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
			"Se han actualizado las ordenes con éxito "));
	disableButton = "true";
	
	}

	public void action_valoresSeleccionados2() throws Exception {
		String cadena = "";
		Long flagZona=1L;


		ProgramacionLaboresDTO zonasSeleccionadas = null;
		if (selectedDatPlanLabor2 != null && selectedDatPlanLabor2.size() > 0) {
			zonasSeleccionadas = selectedDatPlanLabor2.get(0);
			flagZona = 0L;
			for (int i = 0; i < selectedDatPlanLabor2.size(); i++) {
				zonasSeleccionadas =  selectedDatPlanLabor2.get(i);
				cadena += "," + zonasSeleccionadas.getOrdenTrabajo().toString();
			}
		}
	
	cadena = '0'+cadena;
		
	businessDelegatorView.aprobarOrdenesServicioNivel2(cadena);
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
			"Se han actualizado las ordenes con éxito "));
	disableButton = "true";
	
	}

	public List<String> getSelectedVariedades() {
		return selectedVariedades;
	}

	public void setSelectedVariedades(List<String> selectedVariedades) {
		this.selectedVariedades = selectedVariedades;
	}

	public List<Variedad> getVariedades() {

		if (variedades == null || variedades.size() == 0) {

			variedades = new ArrayList<Variedad>();

			try {
				variedades = businessDelegatorView.getVariedad();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return variedades;
	}

	public void setVariedades(List<Variedad> variedades) {
		this.variedades = variedades;
	}

	public List<String> getSelectedNivel2() {
		return selectedNivel2;
	}

	public void setSelectedNivel2(List<String> selectedNivel2) {
		this.selectedNivel2 = selectedNivel2;
	}

	public List<Nivel2> getFincas() {

		if (fincas == null || fincas.size() == 0) {

			fincas = new ArrayList<Nivel2>();

			try {
				fincas = businessDelegatorView.getNivel2();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return fincas;
	}

	public void setFincas(List<Nivel2> fincas) {
		this.fincas = fincas;
	}

	public List<String> getSelectedNivel3() {
		return selectedNivel3;
	}

	public void setSelectedNivel3(List<String> selectedNivel3) {
		this.selectedNivel3 = selectedNivel3;
	}

	public List<Nivel3> getBloques() {
		if (bloques == null || bloques.size() == 0) {

			bloques = new ArrayList<Nivel3>();

			try {
				bloques = businessDelegatorView.getNivel3();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return bloques;
	}

	public void setBloques(List<Nivel3> bloques) {
		this.bloques = bloques;
	}

	public List<String> getSelectedNivel4() {
		return selectedNivel4;
	}

	public void setSelectedNivel4(List<String> selectedNivel4) {
		this.selectedNivel4 = selectedNivel4;
	}

	public List<Nivel4> getLotes() {

		if (lotes == null || lotes.size() == 0) {

			lotes = new ArrayList<Nivel4>();

			try {
				lotes = businessDelegatorView.getNivel4();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return lotes;
	}

	public void setLotes(List<Nivel4> lotes) {
		this.lotes = lotes;
	}

	public List<String> getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(List<String> selectedLabor) {
		this.selectedLabor = selectedLabor;
	}

	public List<Labor> getLabores() {
		if (labores == null || labores.size() == 0) {

			labores = new ArrayList<Labor>();

			try {
				labores = businessDelegatorView.getLabor();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return labores;
	}

	public void setLabores(List<Labor> labores) {
		this.labores = labores;
	}

	public List<String> getSelectedGrupoLabor() {
		return selectedGrupoLabor;
	}

	public void setSelectedGrupoLabor(List<String> selectedGrupoLabor) {
		this.selectedGrupoLabor = selectedGrupoLabor;
	}

	public List<GrpLabor> getGrupoLabores() {
		if (grupoLabores == null || grupoLabores.size() == 0) {

			grupoLabores = new ArrayList<GrpLabor>();

			try {
				grupoLabores = businessDelegatorView.getGrpLabor();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return grupoLabores;
	}

	public void setGrupoLabores(List<GrpLabor> grupoLabores) {
		this.grupoLabores = grupoLabores;
	}

	public List<String> getSelectedTenencia() {
		return selectedTenencia;
	}

	public void setSelectedTenencia(List<String> selectedTenencia) {
		this.selectedTenencia = selectedTenencia;
	}

	public List<Tenencia> getTenencias() {
		if (tenencias == null || tenencias.size() == 0) {

			tenencias = new ArrayList<Tenencia>();

			try {
				tenencias = businessDelegatorView.getTenencia();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return tenencias;
	}

	public void setTenencias(List<Tenencia> tenencias) {
		this.tenencias = tenencias;
	}

	public List<String> getSelectedUdadMed() {
		return selectedUdadMed;
	}

	public void setSelectedUdadMed(List<String> selectedUdadMed) {
		this.selectedUdadMed = selectedUdadMed;
	}

	public List<UdadMed> getUnidadesMedida() {
		if (unidadesMedida == null || unidadesMedida.size() == 0) {

			unidadesMedida = new ArrayList<UdadMed>();

			try {
				unidadesMedida = businessDelegatorView.getUdadMed();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return unidadesMedida;
	}

	public void setUnidadesMedida(List<UdadMed> unidadesMedida) {
		this.unidadesMedida = unidadesMedida;
	}


	public List<String> getSelectedNivel1() {
		return selectedNivel1;
	}

	public void setSelectedNivel1(List<String> selectedNivel1) {
		this.selectedNivel1 = selectedNivel1;
	}

	public List<Nivel1> getZonas() {
		if (zonas == null || zonas.size() == 0) {

			zonas = new ArrayList<Nivel1>();

			try {
				zonas = businessDelegatorView.getNivel1();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return zonas;
	}

	public void setZonas(List<Nivel1> zonas) {
		this.zonas = zonas;
	}

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public String getDisableButton1() {
		return disableButton1;
	}

	public void setDisableButton1(String disableButton1) {
		this.disableButton1 = disableButton1;
	}

	public String getDisableNivel1() {
		return disableNivel1;
	}

	public void setDisableNivel1(String disableNivel1) {
		this.disableNivel1 = disableNivel1;
	}

	public String getDisableNivel2() {
		return disableNivel2;
	}

	public void setDisableNivel2(String disableNivel2) {
		this.disableNivel2 = disableNivel2;
	}


	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}


	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}


	public Calendar getTxtFechaIni() {
		return txtFechaIni;
	}


	public void setTxtFechaIni(Calendar txtFechaIni) {
		this.txtFechaIni = txtFechaIni;
	}


	public Calendar getTxtFechaFin() {
		return txtFechaFin;
	}


	public void setTxtFechaFin(Calendar txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}


	public InputNumber getTxtPlanilla() {
		return txtPlanilla;
	}


	public void setTxtPlanilla(InputNumber txtPlanilla) {
		this.txtPlanilla = txtPlanilla;
	}
}
