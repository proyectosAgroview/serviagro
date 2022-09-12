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
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CronogramaLabores;
import co.com.arcosoft.modelo.CronogramaLaboresLabores;
import co.com.arcosoft.modelo.CronogramaLaboresNivel4;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.CronogramaLaboresDTO;
import co.com.arcosoft.modelo.dto.CronogramaLaboresLaboresDTO;
import co.com.arcosoft.modelo.dto.CronogramaLaboresNivel4DTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CronogramaLaboresExpresView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresExpresView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtCronogramaLaboresId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnAgregarCronogramaLaboresNivel4;
	private CommandButton btnAgregarCronogramaLaboresLabores;

	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CronogramaLaboresDTO> data;
	private CronogramaLaboresDTO selectedCronogramaLabores;
	private CronogramaLabores entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private Calendar txtPeriodoInicial;
	private Calendar txtPeriodoFinal;
	
	/************* sesiones adicionales ****/

	private List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores;
	private CronogramaLaboresLaboresDTO selectedCronogramaLaboresLabores;

	private List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4;
	private CronogramaLaboresNivel4DTO selectedCronogramaLaboresNivel4;
	
	private CronogramaLaboresLabores entityCronogramaLaboresLabores;
	private CronogramaLaboresNivel4 entityCronogramaLaboresNivel4;

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

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private InputText txtCronogramaLaboresLaboresId;
	private InputText txtCronogramaLaboresNivel4Id;

	private InputText txtDuracion;
	private Spinner txtNumeroDiasInicial;
	private Spinner txtNumeroDiasFin;

	private InputText txtNombreLabor;
	private InputText txtNombreNivel4;
	private InputText txtNombreNivel2;
	private InputText txtAreaNeta;
	private InputText txtNumeroPlantas;
	private int activeTapIndex = 0;
	
	private Spinner txtTarifaLabor;
	private SelectOneMenu txtPresupuestoBaseAreasPlantas;
	private SelectOneRadio txtEsExpres;
	
	SelectItem[] selectNivel2Edit;
	private List<Nivel2> nivel2Edit;
	
	SelectItem[] selectNivel4Edit;
	private List<Nivel4> nivel4Edit;
	
	private Calendar txtFechaStart;
	
	public CronogramaLaboresExpresView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CronogramaLaboresDTO cronogramaLaboresDTO = (CronogramaLaboresDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(cronogramaLaboresDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(cronogramaLaboresDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(cronogramaLaboresDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(cronogramaLaboresDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(cronogramaLaboresDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(cronogramaLaboresDTO.getNombre());

			if (txtCronogramaLaboresId == null) {
				txtCronogramaLaboresId = new InputText();
			}

			txtCronogramaLaboresId.setValue(cronogramaLaboresDTO.getCronogramaLaboresId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(cronogramaLaboresDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(cronogramaLaboresDTO.getFechaModificacion());

			Long cronogramaLaboresId = FacesUtils.checkLong(txtCronogramaLaboresId);
			entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCronogramaLabores = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCronogramaLabores = null;
		PrimeFaces.current().resetInputs(":dialogCronogramaLabores :frm");
		activeTapIndex = 0;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (dataCronogramaLaboresLabores != null) {
			dataCronogramaLaboresLabores = null;
		}

		if (dataCronogramaLaboresNivel4 != null) {
			dataCronogramaLaboresNivel4 = null;
		}

		if (txtFechaStart != null) {
			txtFechaStart.setValue(null);
			txtFechaStart.setDisabled(false);
		}

		
		if (txtTarifaLabor != null) {
			txtTarifaLabor.setValue(null);
			txtTarifaLabor.setDisabled(false);
		}
		
		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(true);
		}
		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(true);
		}
		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(true);
		}
		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}
		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
		}
		if (txtDuracion != null) {
			txtDuracion.setValue(null);
			txtDuracion.setDisabled(true);
		}

		if (txtNumeroDiasInicial != null) {
			txtNumeroDiasInicial.setValue(null);
			txtNumeroDiasInicial.setDisabled(true);
		}

		if (txtNumeroDiasFin != null) {
			txtNumeroDiasFin.setValue(null);
			txtNumeroDiasFin.setDisabled(true);
		}
		if (txtNombreLabor != null) {
			txtNombreLabor.setValue(null);
			txtNombreLabor.setDisabled(true);
		}
		if (txtNombreNivel2 != null) {
			txtNombreNivel2.setValue(null);
			txtNombreNivel2.setDisabled(true);
		}
		if (txtNombreNivel4 != null) {
			txtNombreNivel4.setValue(null);
			txtNombreNivel4.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}
		
		if (txtEsExpres != null) {
			txtEsExpres.setValue("SI");
			txtEsExpres.setDisabled(true);
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

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtCronogramaLaboresId != null) {
			txtCronogramaLaboresId.setValue(null);
			txtCronogramaLaboresId.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}
		if (btnAgregarCronogramaLaboresNivel4 != null) {
			btnAgregarCronogramaLaboresNivel4.setDisabled(true);
		}
		if (btnAgregarCronogramaLaboresLabores != null) {
			btnAgregarCronogramaLaboresLabores.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		if (txtAreaNeta != null) {
			txtAreaNeta.setValue(null);
			txtAreaNeta.setDisabled(true);
		}
		if (txtNumeroPlantas != null) {
			txtNumeroPlantas.setValue(null);
			txtNumeroPlantas.setDisabled(true);
		}
		if (txtPresupuestoBaseAreasPlantas != null) {
			txtPresupuestoBaseAreasPlantas.setValue(null);
			txtPresupuestoBaseAreasPlantas.setDisabled(true);
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

	public void listener_txtCodigo() throws Exception {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<CronogramaLabores> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCronogramaLabores(condicion, null, null) : null;

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
			txtNivel1Id.setDisabled(false);
			
			txtPeriodoInicial.setDisabled(false);
			txtPeriodoFinal.setDisabled(false);
			txtTarifaLabor.setDisabled(false);
			txtPresupuestoBaseAreasPlantas.setDisabled(false);
			txtEsExpres.setDisabled(false);	
			txtFechaStart.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			// txtCronogramaLaboresLaboresId.setDisabled(true);
			// txtCronogramaLaboresNivel4Id.setDisabled(true);
			txtNumeroDiasInicial.setDisabled(false);
			txtNumeroDiasFin.setDisabled(false);
			txtNombreLabor.setDisabled(false);
			txtNombreNivel2.setDisabled(false);
			txtNombreNivel4.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtCronogramaLaboresId.setDisabled(true);
			btnAgregarCronogramaLaboresNivel4.setDisabled(false);
			btnAgregarCronogramaLaboresLabores.setDisabled(false);
			txtAreaNeta.setDisabled(false);
			txtNumeroPlantas.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			
			txtPeriodoInicial.setValue(entity.getPeriodoInicial());
			txtPeriodoInicial.setDisabled(false);
			
			txtPeriodoFinal.setValue(entity.getPeriodoFinal());
			txtPeriodoFinal.setDisabled(false);
			txtEsExpres.setValue(entity.getEsExpres());
			txtEsExpres.setDisabled(false);
			
			
			
			
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
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
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtCronogramaLaboresId.setValue(entity.getCronogramaLaboresId());
			txtCronogramaLaboresId.setDisabled(false);

			Long cronogramaLaboresId = FacesUtils.checkLong(txtCronogramaLaboresId);

			dataCronogramaLaboresLabores = null;
			dataCronogramaLaboresLabores = businessDelegatorView
					.getDataCronogramaLaboresLaboresByCronograma(cronogramaLaboresId);

			dataCronogramaLaboresNivel4 = null;
			dataCronogramaLaboresNivel4 = businessDelegatorView
					.getDataCronogramaLaboresNivel4ByCronograma(cronogramaLaboresId);

			txtNombreLabor.setDisabled(false);
			txtNombreNivel2.setDisabled(false);
			txtNombreNivel4.setDisabled(false);

			if (txtNivel1Id != null) {
				txtNivel1Id.setValue(null);
				txtNivel1Id.setDisabled(false);
			}
			txtNivel2Id.setDisabled(false);

			if (txtNivel3Id != null) {
				txtNivel3Id.setValue(null);
				txtNivel3Id.setDisabled(false);
			}
			txtNivel4Id_Nivel4.setDisabled(false);

			txtLaborId_Labor.setDisabled(false);

			if (txtCronogramaLaboresLaboresId != null) {
				txtCronogramaLaboresLaboresId.setValue(null);
				txtCronogramaLaboresLaboresId.setDisabled(false);
			}
			if (txtCronogramaLaboresNivel4Id != null) {
				txtCronogramaLaboresNivel4Id.setValue(null);
				txtCronogramaLaboresNivel4Id.setDisabled(false);
			}

			txtNumeroDiasInicial.setValue(0);
			txtNumeroDiasInicial.setDisabled(false);
			txtNumeroDiasFin.setValue(0);
			txtNumeroDiasFin.setDisabled(false);

			btnAgregarCronogramaLaboresLabores.setDisabled(false);
			btnAgregarCronogramaLaboresNivel4.setDisabled(false);

			txtAreaNeta.setValue(0);
			txtAreaNeta.setDisabled(false);

			txtNumeroPlantas.setValue(0);
			txtNumeroPlantas.setDisabled(false);

			txtTarifaLabor.setValue(0);
			txtTarifaLabor.setDisabled(false);
			txtFechaStart.setDisabled(false);
			
			txtPresupuestoBaseAreasPlantas.setDisabled(false);
			
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public List<CronogramaLaboresLaboresDTO> getCronogramaLaboresLaboress() {

		if (dataCronogramaLaboresLabores == null || dataCronogramaLaboresLabores.size() == 0) {
			return null;
		} else {
			return dataCronogramaLaboresLabores;
		}

	}

	public void action_agregarCronogramaLaboresLabores() throws Exception {
		if (txtLaborId_Labor.getValue() != null && txtNumeroDiasInicial.getValue() != null
				&& txtNumeroDiasFin.getValue() != null &&  txtPresupuestoBaseAreasPlantas.getValue() !=null) {

			Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			Labor labor = businessDelegatorView.getLabor(laborId);
			String nombreLabor = FacesUtils.checkString(txtNombreLabor);
			// Double duracion = FacesUtils.checkDouble(txtDuracion);
			Double numeroDiasIniciales = FacesUtils.checkDouble(txtNumeroDiasInicial);
			Double numeroDiasFinales = FacesUtils.checkDouble(txtNumeroDiasFin);
			Double tarifaLabor = FacesUtils.checkDouble(txtTarifaLabor);
			String presupuestoBaseAreasPlantas = FacesUtils.checkString(txtPresupuestoBaseAreasPlantas);
			
			boolean existeProducto = false;

			if (dataCronogramaLaboresLabores == null) {
				dataCronogramaLaboresLabores = new ArrayList<CronogramaLaboresLaboresDTO>();

			}

			if (dataCronogramaLaboresLabores.size() > 0) {

				for (CronogramaLaboresLaboresDTO d : dataCronogramaLaboresLabores) {

					if (d.getLaborId_Labor().getLaborId().longValue() == labor.getLaborId().longValue()
							&& d.getNumeroDiasInicio() == numeroDiasIniciales) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"La labor " + d.getLaborId_Labor().getLaborId().longValue()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				CronogramaLaboresLaboresDTO cronogramaLaboresLaboresDTO = new CronogramaLaboresLaboresDTO();
				cronogramaLaboresLaboresDTO.setLaborId_Labor(labor);
				cronogramaLaboresLaboresDTO.setNombreLabor(nombreLabor);
				// cronogramaLaboresLaboresDTO.setDuracion(duracion);
				cronogramaLaboresLaboresDTO.setNumeroDiasInicio(numeroDiasIniciales);
				cronogramaLaboresLaboresDTO.setNumeroDiasFin(numeroDiasFinales);
				cronogramaLaboresLaboresDTO.setTarifaLabor(tarifaLabor);
				cronogramaLaboresLaboresDTO.setPresupuestoBaseAreaPlantas(presupuestoBaseAreasPlantas);
				
				dataCronogramaLaboresLabores.add(cronogramaLaboresLaboresDTO);

			}

			labor = null;
			nombreLabor = null;
			// duracion = null;
			numeroDiasIniciales = null;
			numeroDiasFinales = null;
			tarifaLabor = null;
			presupuestoBaseAreasPlantas = null;
			// dataDetProductos = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos labor, días de inicio y fin de la labor tengan valores. "));
		}
	}

	public void listener_ConsultaNombreLabor() {

		Long laborId = null;

		if (!txtLaborId_Labor.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());

			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNombreLabor.setValue(labor.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public List<CronogramaLaboresNivel4DTO> getCronogramaLaboresNivel4s() {

		if (dataCronogramaLaboresNivel4 == null || dataCronogramaLaboresNivel4.size() == 0) {
			return null;
		} else {
			return dataCronogramaLaboresNivel4;
		}

	}

	public void action_agregarCronogramaLaboresNivel4() throws Exception {
		if (txtNivel2Id.getValue() != null && txtNivel4Id_Nivel4.getValue() != null && txtAreaNeta.getValue() != null) {

			Long nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());
			Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

			Long nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

			String nombreNivel4 = FacesUtils.checkString(txtNombreNivel4);
			String nombreNivel2 = FacesUtils.checkString(txtNombreNivel2);

			Double areaNeta = FacesUtils.checkDouble(txtAreaNeta);
			Double numeroPlantas = FacesUtils.checkDouble(txtNumeroPlantas);
			Date fechaStart = FacesUtils.checkDate(txtFechaStart);
			
			boolean existeProducto = false;

			if (dataCronogramaLaboresNivel4 == null) {
				dataCronogramaLaboresNivel4 = new ArrayList<CronogramaLaboresNivel4DTO>();

			}

			if (dataCronogramaLaboresNivel4.size() > 0) {

				for (CronogramaLaboresNivel4DTO d : dataCronogramaLaboresNivel4) {

					if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4.getNivel4Id().longValue()
							&& d.getNivel2Id().getNivel2Id().longValue() == nivel2.getNivel2Id().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"El lote " + d.getNivel4Id_Nivel4().getNivel4Id().longValue()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				CronogramaLaboresNivel4DTO cronogramaLaboresNivel4DTO = new CronogramaLaboresNivel4DTO();
				cronogramaLaboresNivel4DTO.setNivel4Id_Nivel4(nivel4);
				cronogramaLaboresNivel4DTO.setNombreNivel4(nombreNivel4);
				cronogramaLaboresNivel4DTO.setNivel2Id(nivel2);
				cronogramaLaboresNivel4DTO.setNombreNivel2(nombreNivel2);
				cronogramaLaboresNivel4DTO.setAreaNeta(areaNeta);
				cronogramaLaboresNivel4DTO.setNumeroPlantas(numeroPlantas);
				cronogramaLaboresNivel4DTO.setFechaStart(fechaStart);
				
				dataCronogramaLaboresNivel4.add(cronogramaLaboresNivel4DTO);

			}

			nivel4 = null;
			nombreNivel4 = null;
			nombreNivel2 = null;
			nivel2 = null;
			numeroPlantas = null;
			areaNeta = null;
			fechaStart = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos Hacienda/Finca,  lote, área tengan valores. "));
		}

	}

	public void listener_ConsultaNombreNivel4() {

		Long nivel4Id = null;
		Long nivel2Id = null;

		if (!txtNivel4Id_Nivel4.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNombreNivel4.setValue(nivel4.getNombre());
				txtAreaNeta.setValue(nivel4.getAreaNeta());
				txtNumeroPlantas.setValue(nivel4.getNumPlantasActuales());

				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel2.setValue(nivel2.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaNombreNivel2() {

		Long nivel2Id = null;

		if (!txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNombreNivel2.setValue(nivel2.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public String action_edit(ActionEvent evt) throws Exception {
		selectedCronogramaLabores = (CronogramaLaboresDTO) (evt.getComponent().getAttributes()
				.get("selectedCronogramaLabores"));

		try {

			String codigo = selectedCronogramaLabores.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<CronogramaLabores> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCronogramaLabores(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtPeriodoInicial.setValue(entity.getPeriodoInicial());
				txtPeriodoInicial.setDisabled(false);
				
				txtPeriodoFinal.setValue(entity.getPeriodoFinal());
				txtPeriodoFinal.setDisabled(false);
				txtEsExpres.setValue(entity.getEsExpres());
				txtEsExpres.setDisabled(false);
				
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedCronogramaLabores.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedCronogramaLabores.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtCronogramaLaboresId.setValue(entity.getCronogramaLaboresId());
				txtCronogramaLaboresId.setDisabled(false);

				Long cronogramaLaboresId = FacesUtils.checkLong(txtCronogramaLaboresId);

				dataCronogramaLaboresLabores = null;
				dataCronogramaLaboresLabores = businessDelegatorView
						.getDataCronogramaLaboresLaboresByCronograma(cronogramaLaboresId);

				dataCronogramaLaboresNivel4 = null;
				dataCronogramaLaboresNivel4 = businessDelegatorView
						.getDataCronogramaLaboresNivel4ByCronograma(cronogramaLaboresId);

				txtNombreLabor.setDisabled(false);
				txtNombreNivel2.setDisabled(false);
				txtNombreNivel4.setDisabled(false);

				txtNivel1Id.setDisabled(false);
				txtNivel2Id.setDisabled(false);

				txtNivel3Id.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);
				txtAreaNeta.setValue(0);
				txtAreaNeta.setDisabled(false);

				txtNumeroPlantas.setValue(0);
				txtNumeroPlantas.setDisabled(false);

				txtLaborId_Labor.setDisabled(false);

				if (txtCronogramaLaboresLaboresId != null) {
					txtCronogramaLaboresLaboresId.setValue(null);
					txtCronogramaLaboresLaboresId.setDisabled(false);
				}
				if (txtCronogramaLaboresNivel4Id != null) {
					txtCronogramaLaboresNivel4Id.setValue(null);
					txtCronogramaLaboresNivel4Id.setDisabled(false);
				}

				txtNumeroDiasInicial.setValue(0);
				txtNumeroDiasInicial.setDisabled(false);
				txtNumeroDiasFin.setValue(0);
				txtNumeroDiasFin.setDisabled(false);

				txtTarifaLabor.setDisabled(false);
				txtPresupuestoBaseAreasPlantas.setDisabled(false);
				
				txtFechaStart.setDisabled(false);
				btnAgregarCronogramaLaboresNivel4.setDisabled(false);
				btnAgregarCronogramaLaboresLabores.setDisabled(false);

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
			if ((selectedCronogramaLabores == null) && (entity == null)) {
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
			entity = new CronogramaLabores();
			// Long datAplicProdId = FacesUtils.checkLong(txtDatAplicProdId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			// Long cronogramaLaboresId =
			// FacesUtils.checkLong(txtCronogramaLaboresId);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			// entity.setCronogramaLaboresId(cronogramaLaboresId);
			
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			String estado ="A";
			String esExpres = "SI";
			entity.setEstado(estado);
			entity.setEsExpres(esExpres);
			entity.setFechaCreacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			businessDelegatorView.saveCronogramaLabores(entity, dataCronogramaLaboresLabores,
					dataCronogramaLaboresNivel4);
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
				Long cronogramaLaboresId = new Long(selectedCronogramaLabores.getCronogramaLaboresId());
				entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);
			}
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			entity.setEsExpres(FacesUtils.checkString(txtEsExpres));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			businessDelegatorView.updateCronogramaLabores(entity, dataCronogramaLaboresLabores,
					dataCronogramaLaboresNivel4);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteCronogramaLaboresLabores(ActionEvent evt) {
		try {
			selectedCronogramaLaboresLabores = (CronogramaLaboresLaboresDTO) (evt.getComponent().getAttributes()
					.get("selectedCronogramaLaboresLabores"));

			if (selectedCronogramaLaboresLabores.getCronogramaLaboresLaboresId() == null) {
				dataCronogramaLaboresLabores.remove(selectedCronogramaLaboresLabores);
			} else {
				Long cronogramaLaboresLaboresId = new Long(
						selectedCronogramaLaboresLabores.getCronogramaLaboresLaboresId());
				CronogramaLaboresLabores entity = businessDelegatorView
						.getCronogramaLaboresLabores(cronogramaLaboresLaboresId);
				businessDelegatorView.deleteCronogramaLaboresLabores(entity);
				dataCronogramaLaboresLabores.remove(selectedCronogramaLaboresLabores);

			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteCronogramaLaboresNivel4(ActionEvent evt) {
		try {

			selectedCronogramaLaboresNivel4 = (CronogramaLaboresNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedCronogramaLaboresNivel4"));

			if (selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id() == null) {
				dataCronogramaLaboresNivel4.remove(selectedCronogramaLaboresNivel4);
			} else {
				Long cronogramaLaboresNivel4Id = new Long(
						selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id());
				CronogramaLaboresNivel4 entity = businessDelegatorView
						.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
				businessDelegatorView.deleteCronogramaLaboresNivel4(entity);
				dataCronogramaLaboresNivel4.remove(selectedCronogramaLaboresNivel4);
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCronogramaLabores = (CronogramaLaboresDTO) (evt.getComponent().getAttributes()
					.get("selectedCronogramaLabores"));

			Long cronogramaLaboresId = new Long(selectedCronogramaLabores.getCronogramaLaboresId());
			entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long cronogramaLaboresId = FacesUtils.checkLong(txtCronogramaLaboresId);
			entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCronogramaLabores(entity);
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
			selectedCronogramaLabores = (CronogramaLaboresDTO) (evt.getComponent().getAttributes()
					.get("selectedCronogramaLabores"));

			Long cronogramaLaboresId = new Long(selectedCronogramaLabores.getCronogramaLaboresId());
			entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);
			businessDelegatorView.deleteCronogramaLabores(entity);
			data.remove(selectedCronogramaLabores);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, Long cronogramaLaboresId, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateCronogramaLabores(entity, dataCronogramaLaboresLabores,
					dataCronogramaLaboresNivel4);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CronogramaLaboresView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}
	
	
	public void onCellEditLabor(CellEditEvent event) throws Exception {

		selectedCronogramaLaboresLabores = (CronogramaLaboresLaboresDTO) (event.getComponent().getAttributes()
				.get("selectedCronogramaLaboresLabores"));
		
		if (selectedCronogramaLaboresLabores.getCronogramaLaboresLaboresId() != null) {

			Long cronogramaLaboresLabooresId = selectedCronogramaLaboresLabores.getCronogramaLaboresLaboresId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long cronogramaLaboresId = FacesUtils.checkLong(txtCronogramaLaboresId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityCronogramaLaboresLabores = null;
	
				entityCronogramaLaboresLabores = businessDelegatorView.getCronogramaLaboresLabores(cronogramaLaboresLabooresId);
	
				if (columnaCell.equals("Labor")) {
	
					Long LaborId = new Long(event.getNewValue().toString());
					Labor labor = businessDelegatorView.getLabor(LaborId);
	
					entityCronogramaLaboresLabores.setLabor(labor);
	
				} else if (columnaCell.equals("P. Básado en")) {
	
					entityCronogramaLaboresLabores.setPresupuestoBaseAreaPlantas((String) newValue);
	
				} else if (columnaCell.equals("Precio Est")) {
	
					Double tarifa = new Double(event.getNewValue().toString());
	
					entityCronogramaLaboresLabores.setTarifaLabor(tarifa);
	
				} else if (columnaCell.equals("#Días inicial")) {
	
					entityCronogramaLaboresLabores.setNumeroDiasInicio((Double) newValue);
	
				} else if (columnaCell.equals("#Días final")) {
	
					entityCronogramaLaboresLabores.setNumeroDiasFin((Double) newValue);
	
				}
	
				entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);
				entityCronogramaLaboresLabores.setCronogramaLabores(entity);
				businessDelegatorView.updateCronogramaLaboresLabores(entityCronogramaLaboresLabores);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataCronogramaLaboresLabores = null;
				entityCronogramaLaboresLabores = null;
				selectedCronogramaLaboresLabores = null;
				entity = null;
	
				dataCronogramaLaboresLabores = businessDelegatorView.getDataCronogramaLaboresLaboresByCronograma(cronogramaLaboresId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}
		
	}
	
	public void onCellEditLote(CellEditEvent event) throws Exception {

		selectedCronogramaLaboresNivel4 = (CronogramaLaboresNivel4DTO) (event.getComponent().getAttributes()
				.get("selectedCronogramaLaboresNivel4"));
		
		if (selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id() != null) {
		
			Long cronogramaLaboresNivel4Id = selectedCronogramaLaboresNivel4.getCronogramaLaboresNivel4Id().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long cronogramaLaboresId = FacesUtils.checkLong(txtCronogramaLaboresId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityCronogramaLaboresNivel4 = null;
	
				entityCronogramaLaboresNivel4 = businessDelegatorView.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
	
				
				if (columnaCell.equals("Fecha")) {
	
					entityCronogramaLaboresNivel4.setFechaStart((Date) newValue);
					
				} else if (columnaCell.equals("Hacienda")) {
	
					Long Nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(Nivel2Id);
		
					entityCronogramaLaboresNivel4.setNivel2Id(Nivel2);
					
				} else if (columnaCell.equals("Lote")) {
	
					Long Nivel4Id = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(Nivel4Id);
		
					entityCronogramaLaboresNivel4.setNivel4(Nivel4);
					
				} else if (columnaCell.equals("Área(Ha)")) {
	
					entityCronogramaLaboresNivel4.setAreaNeta((Double) newValue);
					
				} else if (columnaCell.equals("Plantas")) {
	
					entityCronogramaLaboresNivel4.setNumeroPlantas((Double) newValue);
					
				}
				
				entity = businessDelegatorView.getCronogramaLabores(cronogramaLaboresId);
				entityCronogramaLaboresNivel4.setCronogramaLabores(entity);
				businessDelegatorView.updateCronogramaLaboresNivel4(entityCronogramaLaboresNivel4);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataCronogramaLaboresNivel4 = null;
				entityCronogramaLaboresNivel4 = null;
				selectedCronogramaLaboresNivel4 = null;
				entity = null;
	
				dataCronogramaLaboresNivel4 = businessDelegatorView.getDataCronogramaLaboresNivel4ByCronograma(cronogramaLaboresId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}
		
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
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

	public InputText getTxtCronogramaLaboresId() {
		return txtCronogramaLaboresId;
	}

	public void setTxtCronogramaLaboresId(InputText txtCronogramaLaboresId) {
		this.txtCronogramaLaboresId = txtCronogramaLaboresId;
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

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public InputText getTxtCronogramaLaboresLaboresId() {
		return txtCronogramaLaboresLaboresId;
	}

	public void setTxtCronogramaLaboresLaboresId(InputText txtCronogramaLaboresLaboresId) {
		this.txtCronogramaLaboresLaboresId = txtCronogramaLaboresLaboresId;
	}

	public InputText getTxtCronogramaLaboresNivel4Id() {
		return txtCronogramaLaboresNivel4Id;
	}

	public void setTxtCronogramaLaboresNivel4Id(InputText txtCronogramaLaboresNivel4Id) {
		this.txtCronogramaLaboresNivel4Id = txtCronogramaLaboresNivel4Id;
	}

	public InputText getTxtDuracion() {
		return txtDuracion;
	}

	public void setTxtDuracion(InputText txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public Spinner getTxtNumeroDiasInicial() {
		return txtNumeroDiasInicial;
	}

	public void setTxtNumeroDiasInicial(Spinner txtNumeroDiasInicial) {
		this.txtNumeroDiasInicial = txtNumeroDiasInicial;
	}

	public Spinner getTxtNumeroDiasFin() {
		return txtNumeroDiasFin;
	}

	public void setTxtNumeroDiasFin(Spinner txtNumeroDiasFin) {
		this.txtNumeroDiasFin = txtNumeroDiasFin;
	}

	public List<CronogramaLaboresDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCronogramaLabores();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CronogramaLaboresDTO> cronogramaLaboresDTO) {
		this.data = cronogramaLaboresDTO;
	}

	public CronogramaLaboresDTO getSelectedCronogramaLabores() {
		return selectedCronogramaLabores;
	}

	public void setSelectedCronogramaLabores(CronogramaLaboresDTO cronogramaLabores) {
		this.selectedCronogramaLabores = cronogramaLabores;
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

	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLabores() {
		return dataCronogramaLaboresLabores;
	}

	public void setDataCronogramaLaboresLabores(List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores) {
		this.dataCronogramaLaboresLabores = dataCronogramaLaboresLabores;
	}

	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4() {
		return dataCronogramaLaboresNivel4;
	}

	public void setDataCronogramaLaboresNivel4(List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) {
		this.dataCronogramaLaboresNivel4 = dataCronogramaLaboresNivel4;
	}

	public CommandButton getBtnAgregarCronogramaLaboresNivel4() {
		return btnAgregarCronogramaLaboresNivel4;
	}

	public void setBtnAgregarCronogramaLaboresNivel4(CommandButton btnAgregarCronogramaLaboresNivel4) {
		this.btnAgregarCronogramaLaboresNivel4 = btnAgregarCronogramaLaboresNivel4;
	}

	public CommandButton getBtnAgregarCronogramaLaboresLabores() {
		return btnAgregarCronogramaLaboresLabores;
	}

	public void setBtnAgregarCronogramaLaboresLabores(CommandButton btnAgregarCronogramaLaboresLabores) {
		this.btnAgregarCronogramaLaboresLabores = btnAgregarCronogramaLaboresLabores;
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

	public InputText getTxtNombreLabor() {
		return txtNombreLabor;
	}

	public void setTxtNombreLabor(InputText txtNombreLabor) {
		this.txtNombreLabor = txtNombreLabor;
	}

	public InputText getTxtNombreNivel4() {
		return txtNombreNivel4;
	}

	public void setTxtNombreNivel4(InputText txtNombreNivel4) {
		this.txtNombreNivel4 = txtNombreNivel4;
	}

	public InputText getTxtNombreNivel2() {
		return txtNombreNivel2;
	}

	public void setTxtNombreNivel2(InputText txtNombreNivel2) {
		this.txtNombreNivel2 = txtNombreNivel2;
	}

	public CronogramaLaboresLaboresDTO getSelectedCronogramaLaboresLabores2() {
		return selectedCronogramaLaboresLabores;
	}

	public void setSelectedCronogramaLaboresLabores(CronogramaLaboresLaboresDTO selectedCronogramaLaboresLabores) {
		this.selectedCronogramaLaboresLabores = selectedCronogramaLaboresLabores;
	}

	public CronogramaLaboresNivel4DTO getSelectedCronogramaLaboresNivel4() {
		return selectedCronogramaLaboresNivel4;
	}

	public void setSelectedCronogramaLaboresNivel4(CronogramaLaboresNivel4DTO selectedCronogramaLaboresNivel4) {
		this.selectedCronogramaLaboresNivel4 = selectedCronogramaLaboresNivel4;
	}

	public InputText getTxtAreaNeta() {
		return txtAreaNeta;
	}

	public void setTxtAreaNeta(InputText txtAreaNeta) {
		this.txtAreaNeta = txtAreaNeta;
	}

	public InputText getTxtNumeroPlantas() {
		return txtNumeroPlantas;
	}

	public void setTxtNumeroPlantas(InputText txtNumeroPlantas) {
		this.txtNumeroPlantas = txtNumeroPlantas;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the txtPeriodoInicial
	 */
	public Calendar getTxtPeriodoInicial() {
		return txtPeriodoInicial;
	}

	/**
	 * @param txtPeriodoInicial the txtPeriodoInicial to set
	 */
	public void setTxtPeriodoInicial(Calendar txtPeriodoInicial) {
		this.txtPeriodoInicial = txtPeriodoInicial;
	}

	/**
	 * @return the txtPeriodoFinal
	 */
	public Calendar getTxtPeriodoFinal() {
		return txtPeriodoFinal;
	}

	/**
	 * @param txtPeriodoFinal the txtPeriodoFinal to set
	 */
	public void setTxtPeriodoFinal(Calendar txtPeriodoFinal) {
		this.txtPeriodoFinal = txtPeriodoFinal;
	}

	/**
	 * @return the txtTarifaLabor
	 */
	public Spinner getTxtTarifaLabor() {
		return txtTarifaLabor;
	}

	/**
	 * @param txtTarifaLabor the txtTarifaLabor to set
	 */
	public void setTxtTarifaLabor(Spinner txtTarifaLabor) {
		this.txtTarifaLabor = txtTarifaLabor;
	}

	/**
	 * @return the txtPresupuestoBaseAreasPlantas
	 */
	public SelectOneMenu getTxtPresupuestoBaseAreasPlantas() {
		return txtPresupuestoBaseAreasPlantas;
	}

	/**
	 * @param txtPresupuestoBaseAreasPlantas the txtPresupuestoBaseAreasPlantas to set
	 */
	public void setTxtPresupuestoBaseAreasPlantas(SelectOneMenu txtPresupuestoBaseAreasPlantas) {
		this.txtPresupuestoBaseAreasPlantas = txtPresupuestoBaseAreasPlantas;
	}

	/**
	 * @return the txtEsExpres
	 */
	public SelectOneRadio getTxtEsExpres() {
		return txtEsExpres;
	}

	/**
	 * @param txtEsExpres the txtEsExpres to set
	 */
	public void setTxtEsExpres(SelectOneRadio txtEsExpres) {
		this.txtEsExpres = txtEsExpres;
	}

	/**
	 * @return the txtFechaStart
	 */
	public Calendar getTxtFechaStart() {
		return txtFechaStart;
	}

	/**
	 * @param txtFechaStart the txtFechaStart to set
	 */
	public void setTxtFechaStart(Calendar txtFechaStart) {
		this.txtFechaStart = txtFechaStart;
	}
	
	public SelectItem[] getSelectNivel2Edit() {

		if (nivel2Edit == null || nivel2Edit.size() == 0) {


			try {

				nivel2Edit = businessDelegatorView.getNivel2(); // Fin by
				// Criteria
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


}


