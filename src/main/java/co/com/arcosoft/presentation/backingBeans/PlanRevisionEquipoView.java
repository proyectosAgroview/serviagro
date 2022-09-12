package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.PlanRevisionEquipoActiv;
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.PlanRevisionEquipoRecursos;
import co.com.arcosoft.modelo.PlanRevisionProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.TipoRecursosEquipos;
import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.TipoRecursosOtros;
import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoRecursosDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionProdDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.ExportarPlanRevisionDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoRecursosDTO;
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
public class PlanRevisionEquipoView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoView.class);
	private InputText txtCodigo;
	// private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputText txtNombre;
	private SelectOneMenu txtTipoPlan;
	private InputTextarea txtObservacion;
	private InputText txtPlanRevisionEquipoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PlanRevisionEquipoDTO> data;
	private PlanRevisionEquipoDTO selectedPlanRevisionEquipo;
	private PlanRevisionEquipo entity;
	private boolean showDialog;
	private int activeTapIndex = 0;

	private Calendar txtFechaUltimoServicio;
	private InputText txtHorasUltimoServicio;
	private InputText txtKmUltimoServicio;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	/*** detalle equipo ***/
	private List<PlanRevisionEquipoDetDTO> dataDetEquipo;
	private PlanRevisionEquipoDetDTO selectedPlanRevisionEquipoDet;

	private SelectOneMenu txtEquipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private InputText txtAlertaMin;
	private InputText txtAlertaMax;
	private InputText txtPeriocidadDias;
	private InputText txtPeriocidadHora;
	private InputText txtPeriocidadKm;
	private InputText txtNombreEquipo;
	private CommandButton btnAgregarEquipo;

	private PlanRevisionEquipoDet entityPlanRevisionEquipoDet;

	/*** detalle actividad **/
	private List<PlanRevisionEquipoActivDTO> dataDetActividad;
	private PlanRevisionEquipoActivDTO selectedPlanRevisionAct;

	private InputText txtCodigoAct;
	private InputText txtNombreAct;
	private Spinner txtSecuenciaAct;
	private Calendar txtDuracionAct;

	private SelectOneMenu txtPlanLabor;
	SelectItem[] selectPlanLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtTipoProcedimiento;

	private CommandButton btnAgregarAct;
	private SelectOneMenu txtOrigenDatos;

	private SelectOneMenu txtCompartimientosEquipoId_CompartimientosEquipo;
	SelectItem[] selectCompartimientosEquipo;
	private List<CompartimientosEquipo> compartimiento;

	private SelectOneMenu txtSistemasEquipoId_SistemasEquipo;
	SelectItem[] selectSistemasEquipo;
	private List<SistemasEquipo> sistema;

	private InputText txtNombreSistema;
	private InputText txtNombreCompartimiento;

	private String moduloActivo;
	private String origendatos;

	private PlanRevisionEquipoActiv entityPlanRevisionEquipoActiv;

	/********** Labores recursos ****/
	private SelectOneMenu txtUdadMedIdRecurso;
	SelectItem[] selectUdadMedIdRecurso;
	private List<UdadMed> udadMedRecurso;

	private SelectOneMenu txtTpRecursoId_TipoRecurso;
	SelectItem[] selectTpRecursoId;
	private List<TipoRecurso> tpRecurso;

	private InputText txtNombreUmRecurso;
	private InputText txtNombreTipoRecurso;

	private InputText txtRendimientoRecurso;

	private SelectOneMenu txtRecursoId;
	SelectItem[] selectRecurso;
	private List<ListadoRecursosDTO> recurso;
	private InputText txtLaborRecursosId;

	private InputText txtNombreRecurso;

	private SelectOneMenu txtTrabajarConAreaPlantas;
	private CommandButton btnAgregarRecurso;

	private PlanRevisionEquipoRecursosDTO selectedPlanRevisionEquipoRecursos;
	private List<PlanRevisionEquipoRecursosDTO> dataPlanRevisionEquipoRecursos;
	private PlanRevisionEquipoRecursos entityPlanRevisionEquipoRecursos;

	private PlanRevisionProdDTO selectedPlanRevisionProd;
	private List<PlanRevisionProdDTO> dataPlanRevisionProd;
	private PlanRevisionProd entityPlanRevisionProd;

	private SelectOneMenu txtProducto;
	SelectItem[] selectProducto;
	private List<Producto> producto;

	private SelectOneMenu txtUdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private InputNumber txtCantidad;
	private CommandButton btnAgregarProducto;

	private SelectOneMenu txtMedidor;
	SelectItem[] selectMedidor;
	private List<Medidor> medidor;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	/* Filtros consulta */

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> selectedPlanRevision;
	private List<PlanRevisionEquipo> planRevision;
	private StreamedContent file = null;
	private String path;
	
	private InputTextarea txtObservacionDet;

	public PlanRevisionEquipoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PlanRevisionEquipoDTO planRevisionEquipoDTO = (PlanRevisionEquipoDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(planRevisionEquipoDTO.getCodigo());

			/*
			 * if (txtCompania == null) { txtCompania = new InputText(); }
			 */

			txtCompania.setValue(planRevisionEquipoDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(planRevisionEquipoDTO.getEstado());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(planRevisionEquipoDTO.getNombre());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(planRevisionEquipoDTO.getObservacion());

			if (txtPlanRevisionEquipoId == null) {
				txtPlanRevisionEquipoId = new InputText();
			}

			txtPlanRevisionEquipoId.setValue(planRevisionEquipoDTO.getPlanRevisionEquipoId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(planRevisionEquipoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(planRevisionEquipoDTO.getFechaModificacion());

			Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);
			entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();

			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			origendatos = "Modulo_TallerAgricola";

		} else {

			origendatos = "Modulo_MttoIndustrial";

		}
	}

	public String action_new() {
		action_clear();
		selectedPlanRevisionEquipo = null;
		PrimeFaces.current().resetInputs(":dialogPlanRevisionEquipo :frm");

		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPlanRevisionEquipo = null;
		moduloSeleccionado();
		activeTapIndex = 0;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}
	
		if (txtObservacionDet != null) {
			txtObservacionDet.setValue(null);
			txtObservacionDet.setDisabled(true);
		}
		
		if (txtMedidor != null) {
			txtMedidor.setValue(null);
			txtMedidor.setDisabled(true);
		}

		if (txtSistemasEquipoId_SistemasEquipo != null) {
			txtSistemasEquipoId_SistemasEquipo.setValue(null);
			txtSistemasEquipoId_SistemasEquipo.setDisabled(true);
		}

		if (txtCompartimientosEquipoId_CompartimientosEquipo != null) {
			txtCompartimientosEquipoId_CompartimientosEquipo.setValue(null);
			txtCompartimientosEquipoId_CompartimientosEquipo.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtTipoPlan != null) {
			txtTipoPlan.setValue(null);
			txtTipoPlan.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtPlanRevisionEquipoId != null) {
			txtPlanRevisionEquipoId.setValue(null);
			txtPlanRevisionEquipoId.setDisabled(true);
		}

		if (txtFechaUltimoServicio != null) {
			txtFechaUltimoServicio.setValue(null);
			txtFechaUltimoServicio.setDisabled(true);
		}

		if (txtHorasUltimoServicio != null) {
			txtHorasUltimoServicio.setValue(null);
			txtHorasUltimoServicio.setDisabled(true);
		}

		if (txtKmUltimoServicio != null) {
			txtKmUltimoServicio.setValue(null);
			txtKmUltimoServicio.setDisabled(true);
		}

		if (dataDetEquipo != null) {
			dataDetEquipo = null;
		}

		if (dataDetActividad != null) {
			dataDetActividad = null;
		}

		if (dataPlanRevisionProd != null) {
			dataPlanRevisionProd = null;
		}

		if (txtEquipo != null) {
			txtEquipo.setValue(null);
			txtEquipo.setDisabled(true);
		}

		if (txtPeriocidadDias != null) {
			txtPeriocidadDias.setValue(0);
			txtPeriocidadDias.setDisabled(true);
		}
		if (txtPeriocidadHora != null) {
			txtPeriocidadHora.setValue(0);
			txtPeriocidadHora.setDisabled(true);
		}
		if (txtPeriocidadKm != null) {
			txtPeriocidadKm.setValue(0);
			txtPeriocidadKm.setDisabled(true);
		}

		if (txtAlertaMin != null) {
			txtAlertaMin.setValue(0);
			txtAlertaMin.setDisabled(true);
		}

		/*
		 * if (txtAlertaMax != null) { txtAlertaMax.setValue(0);
		 * txtAlertaMax.setDisabled(true); }
		 */

		if (txtNombreEquipo != null) {
			txtNombreEquipo.setValue(null);
			txtNombreEquipo.setDisabled(true);
		}
		if (btnAgregarEquipo != null) {
			btnAgregarEquipo.setDisabled(true);
		}
		/*** detalle actividad **/

		if (txtCodigoAct != null) {
			txtCodigoAct.setValue(null);
			txtCodigoAct.setDisabled(true);
		}

		if (txtPlanLabor != null) {
			txtPlanLabor.setValue(null);
			txtPlanLabor.setDisabled(false);
		}

		if (txtSecuenciaAct != null) {
			txtSecuenciaAct.setValue(null);
			txtSecuenciaAct.setDisabled(true);
		}
		if (txtDuracionAct != null) {
			txtDuracionAct.setValue(null);
			txtDuracionAct.setDisabled(true);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(true);
		}
		if (btnAgregarAct != null) {
			btnAgregarAct.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		if (txtTipoProcedimiento != null) {
			txtTipoProcedimiento.setValue(null);
			txtTipoProcedimiento.setDisabled(false);
		}

		if (txtNombreSistema != null) {
			txtNombreSistema.setValue(null);
			txtNombreSistema.setDisabled(true);
		}

		if (txtNombreCompartimiento != null) {
			txtNombreCompartimiento.setValue(null);
			txtNombreCompartimiento.setDisabled(true);
		}

		/********** Labores recursos ****/
		if (dataPlanRevisionEquipoRecursos != null) {
			dataPlanRevisionEquipoRecursos = null;
		}
		if (btnAgregarRecurso != null) {
			btnAgregarRecurso.setDisabled(false);
		}

		if (txtUdadMedIdRecurso != null) {
			txtUdadMedIdRecurso.setValue(null);
			txtUdadMedIdRecurso.setDisabled(true);
		}
		if (txtTpRecursoId_TipoRecurso != null) {
			txtTpRecursoId_TipoRecurso.setValue(null);
			txtTpRecursoId_TipoRecurso.setDisabled(true);
		}
		if (txtNombreUmRecurso != null) {
			txtNombreUmRecurso.setValue(null);
			txtNombreUmRecurso.setDisabled(true);
		}
		if (txtNombreTipoRecurso != null) {
			txtNombreTipoRecurso.setValue(null);
			txtNombreTipoRecurso.setDisabled(true);
		}
		if (txtRendimientoRecurso != null) {
			txtRendimientoRecurso.setValue(null);
			txtRendimientoRecurso.setDisabled(true);
		}
		if (txtRecursoId != null) {
			txtRecursoId.setValue(null);
			txtRecursoId.setDisabled(true);
		}
		if (txtNombreRecurso != null) {
			txtNombreRecurso.setValue(null);
			txtNombreRecurso.setDisabled(true);
		}

		if (txtLaborRecursosId != null) {
			txtLaborRecursosId.setValue(null);
			txtLaborRecursosId.setDisabled(true);
		}
		if (txtProducto != null) {
			txtProducto.setValue(null);
			txtProducto.setDisabled(true);
		}
		if (txtUdadMed != null) {
			txtUdadMed.setValue(null);
			txtUdadMed.setDisabled(true);
		}
		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(true);
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

	public void listener_txtFechaUltimoServicio() {
		Date inputDate = (Date) txtFechaUltimoServicio.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDet1() {

		if (dataDetEquipo == null || dataDetEquipo.size() == 0) {
			return null;
		} else {
			return dataDetEquipo;
		}

	}

	public void listener_ConsultaCodSistema() {

		Long id = null;

		if (FacesUtils.checkLong(txtSistemasEquipoId_SistemasEquipo) != null) {

			if (!txtSistemasEquipoId_SistemasEquipo.getValue().equals("")) {

				id = Long.parseLong(txtSistemasEquipoId_SistemasEquipo.getValue().toString());

				try {
					SistemasEquipo l = businessDelegatorView.getSistemasEquipo(id);
					txtNombreSistema.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodSCompartimiento() {

		Long id = null;

		if (FacesUtils.checkLong(txtCompartimientosEquipoId_CompartimientosEquipo) != null) {

			if (!txtCompartimientosEquipoId_CompartimientosEquipo.getValue().equals(" ")) {

				id = Long.parseLong(txtCompartimientosEquipoId_CompartimientosEquipo.getValue().toString());

				try {
					CompartimientosEquipo l = businessDelegatorView.getCompartimientosEquipo(id);
					txtNombreCompartimiento.setValue(l.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void action_agregarEquiposDet() throws Exception {

		String equipos = "";

		Double periocidadKm = FacesUtils.checkDouble(txtPeriocidadKm);
		Double periocidadHora = FacesUtils.checkDouble(txtPeriocidadHora);
		Double periocidadDias = FacesUtils.checkDouble(txtPeriocidadDias);
		String observacionDet = FacesUtils.checkString(txtObservacionDet);
		Long sistemaId = null;
		Long compartimientoId = null;
		Long equipoId = null;
		SistemasEquipo sistemas = null;
		CompartimientosEquipo compartimientos = null;
		Equipo equipo = null;
		Date fecha_ultimo_servicio = null;
		Double horasUltimoServicio = null;
		Double kmUltimoServicio = null;
		Double alertaMin = null;

		String codCompartimiento = "";
		String codsistema = "";
		String codEquipo = "";
		alertaMin = FacesUtils.checkDouble(txtAlertaMin);

		if (alertaMin != null) {

			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				for (int i = 0; i < selectedEquipo.size(); i++) {
					equipos = selectedEquipo.get(i);

					if (txtFechaUltimoServicio.getValue() != null) {
						fecha_ultimo_servicio = FacesUtils.checkDate(txtFechaUltimoServicio);
					}

					if (txtHorasUltimoServicio.getValue() != null) {
						horasUltimoServicio = FacesUtils.checkDouble(txtHorasUltimoServicio);
					}

					if (txtKmUltimoServicio.getValue() != null) {
						kmUltimoServicio = FacesUtils.checkDouble(txtKmUltimoServicio);
					}

					if (txtSistemasEquipoId_SistemasEquipo.getValue() != null) {
						sistemaId = Long.parseLong(txtSistemasEquipoId_SistemasEquipo.getValue().toString());
						sistemas = businessDelegatorView.getSistemasEquipo(sistemaId);
						codsistema = sistemas.getNombre();
					}
					if (txtCompartimientosEquipoId_CompartimientosEquipo.getValue() != null) {
						compartimientoId = Long
								.parseLong(txtCompartimientosEquipoId_CompartimientosEquipo.getValue().toString());
						compartimientos = businessDelegatorView.getCompartimientosEquipo(compartimientoId);
						codCompartimiento = compartimientos.getNombre();
					}

					equipoId = Long.parseLong(equipos);
					equipo = businessDelegatorView.getEquipo(equipoId);
					codEquipo = equipo.getNombre();

					boolean existeProducto = false;

					if (dataDetEquipo == null) {
						dataDetEquipo = new ArrayList<PlanRevisionEquipoDetDTO>();

					}

					if (dataDetEquipo.size() > 0) {

						for (PlanRevisionEquipoDetDTO d : dataDetEquipo) {

							if (d.getEquipo().getEquipoId().longValue() == equipo.getEquipoId().longValue()) {

								existeProducto = true;

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
												"El equipo " + d.getEquipo().getEquipoId().longValue()
														+ " ya fue agregado a la lista, por favor seleccione otro. "));

								break;
							}
						}

					}

					if (existeProducto == false) {
						PlanRevisionEquipoDetDTO planRevisionEquipoDetDTO2 = new PlanRevisionEquipoDetDTO();
						planRevisionEquipoDetDTO2.setEquipo(equipo);
						planRevisionEquipoDetDTO2.setNombreEquipo(codEquipo);
						planRevisionEquipoDetDTO2.setPeriocidadDias(periocidadDias);
						planRevisionEquipoDetDTO2.setPeriocidadHora(periocidadHora);
						planRevisionEquipoDetDTO2.setPeriocidadKm(periocidadKm);
						planRevisionEquipoDetDTO2.setSistemasEquipo(sistemas);
						planRevisionEquipoDetDTO2.setCompartimientosEquipo(compartimientos);
						planRevisionEquipoDetDTO2.setNombreSistema(codsistema);
						planRevisionEquipoDetDTO2.setNombreCompartimiento(codCompartimiento);
						planRevisionEquipoDetDTO2.setAlertaMin(alertaMin);
						planRevisionEquipoDetDTO2.setFechaUltimoServicio(fecha_ultimo_servicio);
						planRevisionEquipoDetDTO2.setHorasUltimoServicio(horasUltimoServicio);
						planRevisionEquipoDetDTO2.setKmUltimoServicio(kmUltimoServicio);
						planRevisionEquipoDetDTO2.setObservacion(observacionDet);
						dataDetEquipo.add(planRevisionEquipoDetDTO2);
					}
				}
			} else { // if alertaMin

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"Por favor seleccionar al menos un equipo/máquina "));

			}

			equipo = null;
			codEquipo = null;
			periocidadDias = null;
			periocidadHora = null;
			periocidadKm = null;
			sistemaId = null;
			compartimientoId = null;
			codsistema = null;
			codCompartimiento = null;
			alertaMin = null;
			fecha_ultimo_servicio = null;
			horasUltimoServicio = null;
			kmUltimoServicio = null;
			observacionDet=null;
			equipos =null;
			selectEquipo=null;

		} else { // if alertaMin

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Por favor digitar alertar mantenimiento a partir de? "));

		}

	}

	public void listener_ConsultaMedidor() throws Exception {

		Long medidorId = null;

		if (txtMedidor.getValue() != null) {
			medidorId = FacesUtils.checkLong(txtMedidor);
			Medidor medidor = businessDelegatorView.getMedidor(medidorId);

			if (medidor != null) {

				if (medidor.getTipoMedidor().equals("horometro")) {

					txtPeriocidadHora.setDisabled(false);
					txtPeriocidadDias.setDisabled(true);
					txtPeriocidadKm.setDisabled(true);

				} else if (medidor.getTipoMedidor().equals("dias")) {

					txtPeriocidadHora.setDisabled(true);
					txtPeriocidadDias.setDisabled(false);
					txtPeriocidadKm.setDisabled(true);

				} else if (medidor.getTipoMedidor().equals("odometro")) {

					txtPeriocidadHora.setDisabled(true);
					txtPeriocidadDias.setDisabled(true);
					txtPeriocidadKm.setDisabled(false);

				} else if (medidor.getTipoMedidor().equals("averiado")) {

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss!", "El medidor de la maquinaria/equipo se encuentra averiado"));

					txtPeriocidadHora.setDisabled(true);
					txtPeriocidadHora.setValue(null);
					txtPeriocidadDias.setDisabled(true);
					txtPeriocidadDias.setValue(null);
					txtPeriocidadKm.setDisabled(true);
					txtPeriocidadKm.setValue(null);

				} else {

					txtPeriocidadHora.setDisabled(true);
					txtPeriocidadDias.setDisabled(false);
					txtPeriocidadKm.setDisabled(true);
				}
			}
		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!", "No se ha seleccionado un medidor "));

			txtPeriocidadHora.setDisabled(true);
			txtPeriocidadHora.setValue(null);
			txtPeriocidadDias.setDisabled(true);
			txtPeriocidadDias.setValue(null);
			txtPeriocidadKm.setDisabled(true);
			txtPeriocidadKm.setValue(null);

		}
	}

	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionAct() {

		if (dataDetActividad == null || dataDetActividad.size() == 0) {
			return null;
		} else {
			return dataDetActividad;
		}

	}

	public void action_agregarActividad() throws Exception {

		Long secuenciaAct = FacesUtils.checkLong(txtSecuenciaAct);
		Date duracionAct = FacesUtils.checkDate(txtDuracionAct);

		Long planLaborId = FacesUtils.checkLong(txtPlanLabor);
		Labor labor = businessDelegatorView.getLabor(planLaborId);

		boolean existe = false;

		if (dataDetActividad == null) {
			dataDetActividad = new ArrayList<PlanRevisionEquipoActivDTO>();

		}

		if (dataDetActividad.size() > 0) {

			for (PlanRevisionEquipoActivDTO d : dataDetActividad) {

				if (d.getLaborId().getLaborId().longValue() == labor.getLaborId().longValue()) {

					existe = true;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
									"El código de actividad " + d.getLaborId_Labor().longValue()
											+ " ya fue agregado a la lista, por favor seleccione otro. "));

					break;
				}
			}

		}

		if (existe == false) {

			PlanRevisionEquipoActivDTO planRevisionEquipoActivDTO2 = new PlanRevisionEquipoActivDTO();
			planRevisionEquipoActivDTO2.setLaborId(labor);
			planRevisionEquipoActivDTO2.setSecuencia(secuenciaAct);
			planRevisionEquipoActivDTO2.setDuracion(duracionAct);
			dataDetActividad.add(planRevisionEquipoActivDTO2);

		}

		equipo = null;
		secuenciaAct = null;
		duracionAct = null;
		labor = null;
		planLaborId = null;

	}

	public void listener_txtCodigo() throws Exception {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<PlanRevisionEquipo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInPlanRevisionEquipo(condicion, null, null)
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
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
			txtNombre.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtPlanRevisionEquipoId.setDisabled(true);
			txtEquipo.setDisabled(false);
			txtAlertaMin.setDisabled(false);
			txtFechaUltimoServicio.setDisabled(false);
			txtKmUltimoServicio.setDisabled(false);
			txtHorasUltimoServicio.setDisabled(false);
			txtSistemasEquipoId_SistemasEquipo.setDisabled(false);
			txtCompartimientosEquipoId_CompartimientosEquipo.setDisabled(false);
			// txtAlertaMax.setDisabled(false);
			txtPeriocidadDias.setDisabled(false);
			txtPeriocidadHora.setDisabled(false);
			txtPeriocidadKm.setDisabled(false);
			// txtNombreEquipo.setDisabled(false);
			btnAgregarEquipo.setDisabled(false);
			txtPlanLabor.setDisabled(false);
			txtSecuenciaAct.setDisabled(false);
			txtDuracionAct.setDisabled(false);
			txtTipoPlan.setDisabled(false);
			btnAgregarAct.setDisabled(false);
			txtTipoProcedimiento.setDisabled(false);
			btnSave.setDisabled(false);
			// txtNombreSistema.setDisabled(false);
			// txtNombreCompartimiento.setDisabled(false);
			txtUdadMedIdRecurso.setDisabled(false);
			txtTpRecursoId_TipoRecurso.setDisabled(false);
			txtNombreUmRecurso.setDisabled(false);
			txtRendimientoRecurso.setDisabled(false);
			txtRecursoId.setDisabled(false);
			txtNombreRecurso.setDisabled(false);
			btnAgregarRecurso.setDisabled(false);

			txtProducto.setDisabled(false);
			txtUdadMed.setDisabled(false);
			txtCantidad.setDisabled(false);

			txtObservacionDet.setDisabled(false);
			txtMedidor.setDisabled(false);

		} else {
			txtTipoProcedimiento.setValue(entity.getTipoProcedimiento());
			txtTipoProcedimiento.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtTipoPlan.setValue(entity.getTipoPlan());
			txtTipoPlan.setDisabled(false);
			txtPlanRevisionEquipoId.setValue(entity.getPlanRevisionEquipoId());
			txtPlanRevisionEquipoId.setDisabled(true);
			// txtNombreSistema.setDisabled(false);
			// txtNombreCompartimiento.setDisabled(false);
			if (entity.getMedidorId() != null) {
				txtMedidor.setValue(entity.getMedidorId().getMedidorId());
			}

			txtMedidor.setDisabled(false);

			/******* sesion concerniente al detalle ***/
			Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);
			dataDetEquipo = null;
			dataDetEquipo = businessDelegatorView.getDataPlanRevisionEquipoDetByEquipo(planRevisionEquipoId);

			dataDetActividad = null;
			dataDetActividad = businessDelegatorView.getDataPlanRevisionEquipoActivByEquipo(planRevisionEquipoId);

			dataPlanRevisionProd = null;
			dataPlanRevisionProd = businessDelegator2View.getDataPlanRevisionProdByPlanRevision(planRevisionEquipoId);

			txtEquipo.setDisabled(false);
			txtPeriocidadDias.setDisabled(false);
			txtPeriocidadHora.setDisabled(false);
			txtPeriocidadKm.setDisabled(false);
			txtAlertaMin.setDisabled(false);
			txtFechaUltimoServicio.setDisabled(false);
			txtKmUltimoServicio.setDisabled(false);
			txtHorasUltimoServicio.setDisabled(false);
			txtSistemasEquipoId_SistemasEquipo.setDisabled(false);
			txtCompartimientosEquipoId_CompartimientosEquipo.setDisabled(false);
			// txtAlertaMax.setDisabled(false);
			// txtNombreEquipo.setDisabled(false);
			btnAgregarEquipo.setDisabled(false);
			txtPlanLabor.setDisabled(false);
			txtSecuenciaAct.setDisabled(false);
			txtDuracionAct.setDisabled(false);
			btnAgregarAct.setDisabled(false);
			txtUdadMedIdRecurso.setDisabled(false);
			txtTpRecursoId_TipoRecurso.setDisabled(false);
			txtNombreUmRecurso.setDisabled(false);
			txtRendimientoRecurso.setDisabled(false);
			txtRecursoId.setDisabled(false);
			txtNombreRecurso.setDisabled(false);
			btnAgregarRecurso.setDisabled(false);

			txtObservacionDet.setDisabled(false);
			txtProducto.setDisabled(false);
			txtUdadMed.setDisabled(false);
			txtCantidad.setDisabled(false);

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPlanRevisionEquipo = (PlanRevisionEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionEquipo"));

		PrimeFaces.current().resetInputs(":dialogPlanRevisionEquipo :frm");

		moduloSeleccionado();

		try {

			Long  planRevisionEquipoId = selectedPlanRevisionEquipo.getPlanRevisionEquipoId();
			Object[] condicion = { "planRevisionEquipoId", true, planRevisionEquipoId, "=" };
			List<PlanRevisionEquipo> lista = (planRevisionEquipoId != null)
					? businessDelegatorView.findByCriteriaInPlanRevisionEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtTipoProcedimiento.setValue(entity.getTipoProcedimiento());
				txtTipoProcedimiento.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPlanRevisionEquipoId.setValue(entity.getPlanRevisionEquipoId());
				txtPlanRevisionEquipoId.setDisabled(true);
				txtTipoPlan.setValue(entity.getTipoPlan());
				txtTipoPlan.setDisabled(false);
				if (entity.getMedidorId() != null) {
					txtMedidor.setValue(entity.getMedidorId().getMedidorId());
				}

				txtMedidor.setDisabled(false);

			 
				dataDetEquipo = null;
				dataDetEquipo = businessDelegatorView.getDataPlanRevisionEquipoDetByEquipo(planRevisionEquipoId);

				dataDetActividad = null;
				dataDetActividad = businessDelegatorView.getDataPlanRevisionEquipoActivByEquipo(planRevisionEquipoId);

				dataPlanRevisionEquipoRecursos = null;
				dataPlanRevisionEquipoRecursos = businessDelegatorView
						.getDataPlanRevisionEquipoRecursosByRecursos(planRevisionEquipoId);

				dataPlanRevisionProd = null;
				dataPlanRevisionProd = businessDelegator2View
						.getDataPlanRevisionProdByPlanRevision(planRevisionEquipoId);

				txtAlertaMin.setDisabled(false);
				// txtAlertaMax.setDisabled(false);
			//	txtEquipo.setDisabled(false);
				txtPeriocidadDias.setDisabled(false);
				txtPeriocidadHora.setDisabled(false);
				txtPeriocidadKm.setDisabled(false);
				btnAgregarEquipo.setDisabled(false);
				txtPlanLabor.setDisabled(false);
				txtSecuenciaAct.setDisabled(false);
				txtDuracionAct.setDisabled(false);
				txtSistemasEquipoId_SistemasEquipo.setDisabled(false);
				txtCompartimientosEquipoId_CompartimientosEquipo.setDisabled(false);
				btnAgregarAct.setDisabled(false);

				txtUdadMedIdRecurso.setDisabled(false);
				txtTpRecursoId_TipoRecurso.setDisabled(false);
				txtNombreUmRecurso.setDisabled(false);
				txtRendimientoRecurso.setDisabled(false);
				txtRecursoId.setDisabled(false);
				txtNombreRecurso.setDisabled(false);
				btnAgregarRecurso.setDisabled(false);

				txtProducto.setDisabled(false);
				txtUdadMed.setDisabled(false);
				txtCantidad.setDisabled(false);
				txtObservacionDet.setDisabled(false);
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
			if ((selectedPlanRevisionEquipo == null) && (entity == null)) {
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

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;

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
			entity = new PlanRevisionEquipo();

			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				entity.setOrigenDatos("Modulo_TallerAgricola");
			} else {
				entity.setOrigenDatos("Modulo_MttoIndustrial");
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));

			entity.setTipoProcedimiento(FacesUtils.checkString(txtTipoProcedimiento));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setTipoPlan(FacesUtils.checkString(txtTipoPlan));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));

			entity.setMedidorId((FacesUtils.checkLong(txtMedidor) != null)
					? businessDelegatorView.getMedidor(FacesUtils.checkLong(txtMedidor))
					: null);

			businessDelegatorView.savePlanRevisionEquipo(entity, dataDetEquipo, dataDetActividad,
					dataPlanRevisionEquipoRecursos, dataPlanRevisionProd);
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
				Long planRevisionEquipoId = new Long(selectedPlanRevisionEquipo.getPlanRevisionEquipoId());
				entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			if (moduloActivo.equals("mantenimiento_maquinaria")) {
				entity.setOrigenDatos("Modulo_TallerAgricola");
			} else {
				entity.setOrigenDatos("Modulo_MttoIndustrial");
			}
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setTipoProcedimiento(FacesUtils.checkString(txtTipoProcedimiento));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setTipoPlan(FacesUtils.checkString(txtTipoPlan));
			entity.setFechaModificacion(date);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));

			entity.setMedidorId((FacesUtils.checkLong(txtMedidor) != null)
					? businessDelegatorView.getMedidor(FacesUtils.checkLong(txtMedidor))
					: null);

			businessDelegatorView.updatePlanRevisionEquipo(entity, dataDetEquipo, dataDetActividad,
					dataPlanRevisionEquipoRecursos, dataPlanRevisionProd);
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
			selectedPlanRevisionEquipo = (PlanRevisionEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipo"));

			Long planRevisionEquipoId = new Long(selectedPlanRevisionEquipo.getPlanRevisionEquipoId());
			entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);
			entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deletePlanRevisionEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String actionDeleteDatPlanRevisionEquipoDet(ActionEvent evt) {
		try {

			selectedPlanRevisionEquipoDet = (PlanRevisionEquipoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipoDet"));

			if (selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId() == null) {
				dataDetEquipo.remove(selectedPlanRevisionEquipoDet);
			} else {
				Long planRevisionEquipoDetId = new Long(selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId());
				PlanRevisionEquipoDet entity = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);
				businessDelegatorView.deletePlanRevisionEquipoDet(entity);
				dataDetEquipo.remove(selectedPlanRevisionEquipoDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteDatPlanRevisionAct(ActionEvent evt) {
		try {

			selectedPlanRevisionAct = (PlanRevisionEquipoActivDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionAct"));

			if (selectedPlanRevisionAct.getPlanRevisionEquipoActivId() == null) {
				dataDetActividad.remove(selectedPlanRevisionAct);
			} else {
				Long planRevisionActId = new Long(selectedPlanRevisionAct.getPlanRevisionEquipoActivId());
				PlanRevisionEquipoActiv entity = businessDelegatorView.getPlanRevisionEquipoActiv(planRevisionActId);
				businessDelegatorView.deletePlanRevisionEquipoActiv(entity);
				dataDetActividad.remove(selectedPlanRevisionAct);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedPlanRevisionEquipo = (PlanRevisionEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipo"));

			Long planRevisionEquipoId = new Long(selectedPlanRevisionEquipo.getPlanRevisionEquipoId());
			entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
			businessDelegatorView.deletePlanRevisionEquipo(entity);
			data.remove(selectedPlanRevisionEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String nombre, String observacion, Long planRevisionEquipoId, String tipoPlan)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setTipoPlan(FacesUtils.checkString(tipoPlan));
			businessDelegatorView.updatePlanRevisionEquipo(entity, dataDetEquipo, dataDetActividad,
					dataPlanRevisionEquipoRecursos, dataPlanRevisionProd);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public void action_agregarProducto() throws Exception {

		if (txtProducto.getValue() != null && txtUdadMed.getValue() != null) {

			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			Producto producto = null;
			UdadMed udadMed = null;

			String nombreProducto = "";
			String nombreUdadMed = "";

			if (txtProducto.getValue() != null) {
				Long productoId = Long.parseLong(txtProducto.getValue().toString());
				producto = businessDelegatorView.getProducto(productoId);
				nombreProducto = producto.getNombre();
			}

			if (txtUdadMed.getValue() != null) {
				Long udadMedId = Long.parseLong(txtUdadMed.getValue().toString());
				udadMed = businessDelegatorView.getUdadMed(udadMedId);
				nombreUdadMed = udadMed.getNombre();
			}

			if (dataPlanRevisionProd == null) {
				dataPlanRevisionProd = new ArrayList<PlanRevisionProdDTO>();
			}

			PlanRevisionProdDTO PlanRevisionProdDTO = new PlanRevisionProdDTO();
			PlanRevisionProdDTO.setCantidad(cantidad);
			PlanRevisionProdDTO.setNombreProducto(nombreProducto);
			PlanRevisionProdDTO.setNombreUdadMed(nombreUdadMed);
			PlanRevisionProdDTO.setProductoId_Producto(producto);
			PlanRevisionProdDTO.setUdadMedId_UdadMed(udadMed);

			dataPlanRevisionProd.add(PlanRevisionProdDTO);

			cantidad = null;
			nombreProducto = null;
			nombreUdadMed = null;
			producto = null;
			udadMed = null;

		} else {

			FacesUtils.addInfoMessage("Verifique los campos de producto y unidad de medida");
		}

	}

	public void onCellEditActividad(CellEditEvent evt) throws Exception {

		selectedPlanRevisionAct = (PlanRevisionEquipoActivDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionAct"));

		if (selectedPlanRevisionAct.getPlanRevisionEquipoActivId() != null) {

			Long planRevisionEquipoActivId = selectedPlanRevisionAct.getPlanRevisionEquipoActivId().longValue();
			String columnaCell = evt.getColumn().getHeaderText();
			Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityPlanRevisionEquipoActiv = null;
				entityPlanRevisionEquipoActiv = businessDelegatorView
						.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);

				if (columnaCell.equals("Tarea")) {

					Long laborId = new Long(evt.getNewValue().toString());
					Labor labor = businessDelegatorView.getLabor(laborId);

					entityPlanRevisionEquipoActiv.setLabor(labor);

				} else if (columnaCell.equals("Secuencia")) {

					entityPlanRevisionEquipoActiv.setSecuencia((Long) newValue);

				} else if (columnaCell.equals("Duración")) {

					entityPlanRevisionEquipoActiv.setDuracion((Date) newValue);
				}

				entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
				entityPlanRevisionEquipoActiv.setPlanRevisionEquipo(entity);
				businessDelegatorView.updatePlanRevisionEquipoActiv(entityPlanRevisionEquipoActiv);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataDetActividad = null;
				selectedPlanRevisionAct = null;
				entityPlanRevisionEquipoActiv = null;

				dataDetActividad = businessDelegatorView.getDataPlanRevisionEquipoActivByEquipo(planRevisionEquipoId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditEquipos(CellEditEvent evt) throws Exception {

		selectedPlanRevisionEquipoDet = (PlanRevisionEquipoDetDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionEquipoDet"));

		if (selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId() != null) {

			Long planRevisionEquipoDetId = selectedPlanRevisionEquipoDet.getPlanRevisionEquipoDetId().longValue();
			String columnaCell = evt.getColumn().getHeaderText();
			Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityPlanRevisionEquipoDet = null;
				entityPlanRevisionEquipoDet = businessDelegatorView.getPlanRevisionEquipoDet(planRevisionEquipoDetId);

				if (columnaCell.equals("Equipo")) {

					Long equipoId = new Long(evt.getNewValue().toString());
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);

					entityPlanRevisionEquipoDet.setEquipo(equipo);

				} else if (columnaCell.equals("Sistema")) {

					Long sistemasEquipoId = new Long(evt.getNewValue().toString());
					SistemasEquipo sistemasEquipo = businessDelegatorView.getSistemasEquipo(sistemasEquipoId);

					entityPlanRevisionEquipoDet.setSistemasEquipo(sistemasEquipo);

				} else if (columnaCell.equals("Compartimiento")) {

					Long compartimientosEquipoId = new Long(evt.getNewValue().toString());
					CompartimientosEquipo compartimientosEquipo = businessDelegatorView
							.getCompartimientosEquipo(compartimientosEquipoId);

					entityPlanRevisionEquipoDet.setCompartimientosEquipo(compartimientosEquipo);

				} else if (columnaCell.equals("P.(Horas)")) {

					entityPlanRevisionEquipoDet.setPeriocidadHora((Double) newValue);

				} else if (columnaCell.equals("P.(Km)")) {

					entityPlanRevisionEquipoDet.setPeriocidadKm((Double) newValue);

				} else if (columnaCell.equals("Alertar Mmto")) {

					entityPlanRevisionEquipoDet.setAlertaMin((Double) newValue);

				} else if (columnaCell.equals("Fecha Ult. Serv.")) {

					entityPlanRevisionEquipoDet.setFechaUltimoServicio((Date) newValue);

				} else if (columnaCell.equals("Hrs Ult. Serv.")) {

					entityPlanRevisionEquipoDet.setHorasUltimoServicio((Double) newValue);

				} else if (columnaCell.equals("Kms Ult. Serv.")) {

					entityPlanRevisionEquipoDet.setKmUltimoServicio((Double) newValue);
				}

				entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
				entityPlanRevisionEquipoDet.setPlanRevisionEquipo(entity);
				businessDelegatorView.updatePlanRevisionEquipoDet(entityPlanRevisionEquipoDet);

					dataDetEquipo = null;
				selectedPlanRevisionEquipoDet = null;
				entityPlanRevisionEquipoDet = null;

				dataDetEquipo = businessDelegatorView.getDataPlanRevisionEquipoDetByEquipo(planRevisionEquipoId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditPresupuesto(CellEditEvent evt) throws Exception {

		selectedPlanRevisionEquipoRecursos = (PlanRevisionEquipoRecursosDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionEquipoRecursos"));

		if (selectedPlanRevisionEquipoRecursos.getPlanRevisionEquipoRecursosId() != null) {

			Long planRevisionEquipoRecursosId = selectedPlanRevisionEquipoRecursos.getPlanRevisionEquipoRecursosId()
					.longValue();
			String columnaCell = evt.getColumn().getHeaderText();
			Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityPlanRevisionEquipoRecursos = null;
				entityPlanRevisionEquipoRecursos = businessDelegatorView
						.getPlanRevisionEquipoRecursos(planRevisionEquipoRecursosId);

				if (columnaCell.equals("Cantidad")) {

					entityPlanRevisionEquipoRecursos.setRendimientoRecurso((Double) newValue);

				}

				entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
				entityPlanRevisionEquipoRecursos.setPlanRevisionEquipo(entity);
				businessDelegatorView.updatePlanRevisionEquipoRecursos(entityPlanRevisionEquipoRecursos);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				entity = null;
				dataPlanRevisionEquipoRecursos = null;
				selectedPlanRevisionEquipoRecursos = null;
				entityPlanRevisionEquipoRecursos = null;

				dataPlanRevisionEquipoRecursos = businessDelegatorView
						.getDataPlanRevisionEquipoRecursosByRecursos(planRevisionEquipoId);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
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

	public InputText getTxtPlanRevisionEquipoId() {
		return txtPlanRevisionEquipoId;
	}

	public void setTxtPlanRevisionEquipoId(InputText txtPlanRevisionEquipoId) {
		this.txtPlanRevisionEquipoId = txtPlanRevisionEquipoId;
	}

	public void exportarPlanRevision() throws Exception {

		moduloSeleccionado();
		String modulo = origendatos;
		Long idCompania = new Long(getCompaniaIdSession());

		Long flagPlanRevision = 0L;

		String planSeleccionados = "";
		if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
			planSeleccionados = selectedPlanRevision.get(0);
			flagPlanRevision = 1L;
			for (int i = 1; i < selectedPlanRevision.size(); i++) {
				planSeleccionados += "," + selectedPlanRevision.get(i);
			}
		}

		List<ExportarPlanRevisionDTO> data = null;
		InputStream stream = null;
		String filename = " ";

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
				.getContext();

		Date fechaCreacion = new Date();

		filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
				+ "MttoListaPlanRevisionMtto.xlsx";

		data = businessDelegator2View.exportarPlanRevisionExcel(idCompania, modulo, flagPlanRevision,
				planSeleccionados);

		try {

			File excelSalida = new File(filename);
			FileInputStream fis = new FileInputStream(excelSalida);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);

			XSSFRow row = sheet.createRow(1);
			XSSFCell cell = null;

			sheet.setForceFormulaRecalculation(true);
			CellStyle style = book.createCellStyle();
			style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((CellStyle.BORDER_MEDIUM));
			style.setBorderRight((CellStyle.BORDER_MEDIUM));
			style.setBorderTop((CellStyle.BORDER_MEDIUM));
			style.setBorderBottom((CellStyle.BORDER_MEDIUM));

			CellStyle style1 = book.createCellStyle();
			style1.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
			style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style1.setBorderLeft((CellStyle.BORDER_MEDIUM));
			style1.setBorderRight((CellStyle.BORDER_MEDIUM));
			style1.setBorderTop((CellStyle.BORDER_MEDIUM));
			style1.setBorderBottom((CellStyle.BORDER_MEDIUM));

			// Encabezado

			CellStyle style2 = book.createCellStyle();
			style2.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
			style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style2.setAlignment(CellStyle.ALIGN_CENTER);
			style2.setBorderLeft((CellStyle.BORDER_MEDIUM));
			style2.setBorderRight((CellStyle.BORDER_MEDIUM));
			style2.setBorderTop((CellStyle.BORDER_MEDIUM));
			style2.setBorderBottom((CellStyle.BORDER_MEDIUM));

			style2.setAlignment(CellStyle.ALIGN_CENTER);

			Font font = book.createFont();
			font.setColor(IndexedColors.WHITE.getIndex());
			font.setFontHeightInPoints((short) 11);
			font.setBold(true);
			font.setFontName("Calibri");

			style2.setFont(font);

			CellStyle style3 = book.createCellStyle();
			style3.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style3.setBorderLeft((CellStyle.BORDER_MEDIUM));
			style3.setBorderRight((CellStyle.BORDER_MEDIUM));
			style3.setBorderTop((CellStyle.BORDER_MEDIUM));
			style3.setBorderBottom((CellStyle.BORDER_MEDIUM));

			XSSFCellStyle dollarStyle = book.createCellStyle();
			DataFormat df = book.createDataFormat();
			style3.setDataFormat(df.getFormat("#,##0.000"));

			if (data != null) {

				cell = row.createCell(0);
				cell.setCellValue("Plan Revisión ID");
				cell.setCellStyle(style2);
				cell = row.createCell(1);
				cell.setCellValue("Código Plan");
				cell.setCellStyle(style2);
				cell = row.createCell(2);
				cell.setCellValue("Nombre Plan");
				cell.setCellStyle(style2);
				cell = row.createCell(3);
				cell.setCellValue("Equipo ID");
				cell.setCellStyle(style2);
				cell = row.createCell(4);
				cell.setCellValue("Código Equipo");
				cell.setCellStyle(style2);
				cell = row.createCell(5);
				cell.setCellValue("Nombre Equipo");
				cell.setCellStyle(style2);
				cell = row.createCell(6);
				cell.setCellValue("Sistema ID");
				cell.setCellStyle(style2);
				cell = row.createCell(7);
				cell.setCellValue("Nombre Sistema");
				cell.setCellStyle(style2);
				cell = row.createCell(8);
				cell.setCellValue("Compartimiento ID");
				cell.setCellStyle(style2);
				cell = row.createCell(9);
				cell.setCellValue("Nombre Compartimiento");
				cell.setCellStyle(style2);
				cell = row.createCell(10);
				cell.setCellValue("Código Tag");
				cell.setCellStyle(style2);
				cell = row.createCell(11);
				cell.setCellValue("Nombre Tag");
				cell.setCellStyle(style2);
				cell = row.createCell(12);
				cell.setCellValue("Periodicidad");
				cell.setCellStyle(style2);
				cell = row.createCell(13);
				cell.setCellValue("Hrs/Kms Ultimo Servicio");
				cell.setCellStyle(style2);
				cell = row.createCell(14);
				cell.setCellValue("Tipo Medidor");
				cell.setCellStyle(style2);
				cell = row.createCell(15);
				cell.setCellValue("Alertar");
				cell.setCellStyle(style2);
				cell = row.createCell(16);
				cell.setCellValue("Tareas Mmto");
				cell.setCellStyle(style2);
				cell = row.createCell(17);
				cell.setCellValue("Secuencia");
				cell.setCellStyle(style2);
				cell = row.createCell(18);
				cell.setCellValue("Duración");
				cell.setCellStyle(style2);

				int pos_i = 2;

				for (ExportarPlanRevisionDTO ndDTO : data) {

					row = sheet.createRow(pos_i);

					cell = row.createCell(0);
					cell.setCellValue(ndDTO.getPlan_revision_equipo_id().toString());
					cell.setCellStyle(style);
					cell = row.createCell(1);
					cell.setCellValue(ndDTO.getCod_plan_revision());
					cell.setCellStyle(style);
					cell = row.createCell(2);
					cell.setCellValue(ndDTO.getNombre_plan_revision());
					cell.setCellStyle(style);
					cell = row.createCell(3);
					cell.setCellValue(ndDTO.getEquipo_id().toString());
					cell.setCellStyle(style);
					cell = row.createCell(4);
					cell.setCellValue(ndDTO.getCod_equipo());
					cell.setCellStyle(style);
					cell = row.createCell(5);
					cell.setCellValue(ndDTO.getNom_equipo());
					cell.setCellStyle(style);
					cell = row.createCell(6);
					cell.setCellValue(ndDTO.getSistemas_equipo_id().toString());
					cell.setCellStyle(style);
					cell = row.createCell(7);
					cell.setCellValue(ndDTO.getNombre_sistema_equipo());
					cell.setCellStyle(style);
					cell = row.createCell(8);
					cell.setCellValue(ndDTO.getCompartimientos_equipo_id().toString());
					cell.setCellStyle(style);
					cell = row.createCell(9);
					cell.setCellValue(ndDTO.getNombre_compartimiento_equipo());
					cell.setCellStyle(style);
					cell = row.createCell(10);
					cell.setCellValue(ndDTO.getCodigo_tag());
					cell.setCellStyle(style);
					cell = row.createCell(11);
					cell.setCellValue(ndDTO.getNombre_tag());
					cell.setCellStyle(style);
					cell = row.createCell(12);
					cell.setCellValue(ndDTO.getPeriocidad().toString());
					cell.setCellStyle(style);
					cell = row.createCell(13);
					cell.setCellValue(ndDTO.getHoras_km_ultimo_servicio().toString());
					cell.setCellStyle(style);
					cell = row.createCell(14);
					cell.setCellValue(ndDTO.getTipo_medidor());
					cell.setCellStyle(style);
					cell = row.createCell(15);
					cell.setCellValue(ndDTO.getAlerta_min().toString());
					cell.setCellStyle(style);
					cell = row.createCell(16);
					cell.setCellValue(ndDTO.getActividades());
					cell.setCellStyle(style);
					cell = row.createCell(17);
					cell.setCellValue(ndDTO.getSecuencia().toString());
					cell.setCellStyle(style);
					cell = row.createCell(18);
					cell.setCellValue(ndDTO.getDuracion());
					cell.setCellStyle(style);

					pos_i++;

				}

				String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes" + File.separator;

				FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

				book.write(os);
				System.out.println("Writing on Excel file Finished ...");

				os.close();
				book.close();
				fis.close();

				/*
				 * stream = ((ServletContext)
				 * FacesContext.getCurrentInstance().getExternalContext().getContext())
				 * .getResourceAsStream("/tmp_reportes/" + excelSalida.getName());
				 */

				// file = new DefaultStreamedContent(stream, "application/xlsx",
				// "MttoListaPlanRevisionMtto.xlsx");

				path = rutaDescarga + excelSalida.getName();

				abrirFichero(path);

				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
						"El informe se ha generado con exito."));

			} else {

				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
						"No existe informacion asociada a los criterios de busqueda seleccionados "));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void abrirFichero(String ruta) {
		try {
			File archivo = new File(ruta);
			FacesContext context = FacesContext.getCurrentInstance();
			FileInputStream fis = new FileInputStream(archivo);
			int longitud;

			longitud = fis.available();

			byte[] datos = new byte[longitud];
			int read = 0;

			if (!context.getResponseComplete()) {
				String fileName = archivo.getName();
				String contentType = "application/octet-stream";

				HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

				response.setContentType(contentType);

				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

				ServletOutputStream out = response.getOutputStream();

				while ((read = fis.read(datos)) != -1) {
					out.write(datos, 0, read);
				}

				out.flush();
				out.close();
				context.responseComplete();
			}

			fis.read(datos);
			fis.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void listarPlanRevision() {

		try {

			moduloSeleccionado();
			String modulo = origendatos;

			Long flagPlanRevision = 0L;

			String planSeleccionados = "";
			if (selectedPlanRevision != null && selectedPlanRevision.size() > 0) {
				planSeleccionados = selectedPlanRevision.get(0);
				flagPlanRevision = 1L;
				for (int i = 1; i < selectedPlanRevision.size(); i++) {
					planSeleccionados += "," + selectedPlanRevision.get(i);
				}
			}

			data = businessDelegatorView.getDataPlanRevisionEquipo(modulo, flagPlanRevision, planSeleccionados);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<PlanRevisionEquipoDTO> getData() {
		return data;
	}

	public void setData(List<PlanRevisionEquipoDTO> planRevisionEquipoDTO) {
		this.data = planRevisionEquipoDTO;
	}

	public PlanRevisionEquipoDTO getSelectedPlanRevisionEquipo() {
		return selectedPlanRevisionEquipo;
	}

	public void setSelectedPlanRevisionEquipo(PlanRevisionEquipoDTO planRevisionEquipo) {
		this.selectedPlanRevisionEquipo = planRevisionEquipo;
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

	public SelectItem[] getselectPlanLaborId() {

		String tipoLabor = null;

		if (laborId == null || laborId.size() == 0) {

			try {

				moduloSeleccionado();
				String modulo = origendatos;
				tipoLabor = modulo;

				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, tipoLabor, "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectPlanLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborId : lista) {
					selectPlanLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPlanLaborId;
	}

	public void setselectPlnLaborId(SelectItem[] selectPlanLaborId) {

		this.selectPlanLaborId = selectPlanLaborId;
	}

	public void onCellEditProd(CellEditEvent evt) throws Exception {

		selectedPlanRevisionProd = (PlanRevisionProdDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanRevisionProd"));

		Long planRevisionProdId = selectedPlanRevisionProd.getPlanRevisionProdId().longValue();
		String columnaCell = evt.getColumn().getHeaderText();
		Long planRevisionEquipoId = FacesUtils.checkLong(txtPlanRevisionEquipoId);

		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityPlanRevisionProd = null;
			entityPlanRevisionProd = businessDelegator2View.getPlanRevisionProd(planRevisionProdId);

			if (columnaCell.equals("Producto")) {

				Long productoId = new Long(evt.getNewValue().toString());
				Producto producto = businessDelegatorView.getProducto(productoId);

				entityPlanRevisionProd.setProducto(producto);

			} else if (columnaCell.equals("Unidad de medida")) {

				Long udadMedId = new Long(evt.getNewValue().toString());
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);

				entityPlanRevisionProd.setUdadMed(udadMed);

			} else if (columnaCell.equals("Cantidad")) {

				entityPlanRevisionProd.setCantidad((Double) newValue);
			}

			entity = businessDelegatorView.getPlanRevisionEquipo(planRevisionEquipoId);
			entityPlanRevisionProd.setPlanRevisionEquipoId(entity);
			businessDelegator2View.updatePlanRevisionProd(entityPlanRevisionProd);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataPlanRevisionProd = null;
			selectedPlanRevisionProd = null;
			entityPlanRevisionProd = null;

			dataPlanRevisionProd = businessDelegator2View.getDataPlanRevisionProdByPlanRevision(planRevisionEquipoId);

		}
	}

	public SelectItem[] getselectEquipo() {
		if (origendatos != null) {
			if (equipo == null || equipo.size() == 0) {
				try {
					Long idCompania = new Long(getCompaniaIdSession());
					String modulo = origendatos;
					// Criteria
					List<CatalogoEquiposDTO> listaEquipos = businessDelegatorView.consultarCatalogoEquipos(idCompania,
							modulo);
					selectEquipo = new SelectItem[listaEquipos.size()];
					int i = 0;
					for (CatalogoEquiposDTO listaEquiposDTO : listaEquipos) {
						selectEquipo[i] = new SelectItem(listaEquiposDTO.getEquipoId().longValue(),
								listaEquiposDTO.getNom_equipo()

						);
						i++;
					}
				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return selectEquipo;
	}

	public void setselectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public List<PlanRevisionEquipoDetDTO> getDataDetEquipo() {
		return dataDetEquipo;
	}

	public void setDataDetEquipo(List<PlanRevisionEquipoDetDTO> dataDetEquipo) {
		this.dataDetEquipo = dataDetEquipo;
	}

	public SelectOneMenu getTxtEquipo() {
		return txtEquipo;
	}

	public void setTxtEquipo(SelectOneMenu txtEquipo) {
		this.txtEquipo = txtEquipo;
	}

	public InputText getTxtPeriocidadDias() {
		return txtPeriocidadDias;
	}

	public void setTxtPeriocidadDias(InputText txtPeriocidadDias) {
		this.txtPeriocidadDias = txtPeriocidadDias;
	}

	public InputText getTxtPeriocidadHora() {
		return txtPeriocidadHora;
	}

	public void setTxtPeriocidadHora(InputText txtPeriocidadHora) {
		this.txtPeriocidadHora = txtPeriocidadHora;
	}

	public InputText getTxtPeriocidadKm() {
		return txtPeriocidadKm;
	}

	public void setTxtPeriocidadKm(InputText txtPeriocidadKm) {
		this.txtPeriocidadKm = txtPeriocidadKm;
	}

	public InputText getTxtNombreEquipo() {
		return txtNombreEquipo;
	}

	public void setTxtNombreEquipo(InputText txtNombreEquipo) {
		this.txtNombreEquipo = txtNombreEquipo;
	}

	public List<PlanRevisionEquipoActivDTO> getDataDetActividad() {
		return dataDetActividad;
	}

	public void setDataDetActividad(List<PlanRevisionEquipoActivDTO> dataDetActividad) {
		this.dataDetActividad = dataDetActividad;
	}

	public InputText getTxtCodigoAct() {
		return txtCodigoAct;
	}

	public void setTxtCodigoAct(InputText txtCodigoAct) {
		this.txtCodigoAct = txtCodigoAct;
	}

	public InputText getTxtNombreAct() {
		return txtNombreAct;
	}

	public void setTxtNombreAct(InputText txtNombreAct) {
		this.txtNombreAct = txtNombreAct;
	}

	public Spinner getTxtSecuenciaAct() {
		return txtSecuenciaAct;
	}

	public void setTxtSecuenciaAct(Spinner txtSecuenciaAct) {
		this.txtSecuenciaAct = txtSecuenciaAct;
	}

	public Calendar getTxtDuracionAct() {
		return txtDuracionAct;
	}

	public void setTxtDuracionAct(Calendar txtDuracionAct) {
		this.txtDuracionAct = txtDuracionAct;
	}

	public CommandButton getBtnAgregarEquipo() {
		return btnAgregarEquipo;
	}

	public void setBtnAgregarEquipo(CommandButton btnAgregarEquipo) {
		this.btnAgregarEquipo = btnAgregarEquipo;
	}

	public CommandButton getBtnAgregarAct() {
		return btnAgregarAct;
	}

	public void setBtnAgregarAct(CommandButton btnAgregarAct) {
		this.btnAgregarAct = btnAgregarAct;
	}

	public SelectOneMenu getTxtTipoPlan() {
		return txtTipoPlan;
	}

	public void setTxtTipoPlan(SelectOneMenu txtTipoPlan) {
		this.txtTipoPlan = txtTipoPlan;
	}

	public SelectOneMenu getTxtPlanLabor() {
		return txtPlanLabor;
	}

	public void setTxtPlanLabor(SelectOneMenu txtPlanLabor) {
		this.txtPlanLabor = txtPlanLabor;
	}

	public SelectOneMenu getTxtTipoProcedimiento() {
		return txtTipoProcedimiento;
	}

	public void setTxtTipoProcedimiento(SelectOneMenu txtTipoProcedimiento) {
		this.txtTipoProcedimiento = txtTipoProcedimiento;
	}

	public SelectItem[] getselectSistemasEquipo() {

		if (sistema == null || sistema.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemasEquipo> lista = businessDelegatorView.findByCriteriaInSistemasEquipo(condicion, null,
						null);
				selectSistemasEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (SistemasEquipo sistema : lista) {
					selectSistemasEquipo[i] = new SelectItem(sistema.getSistemasEquipoId(), sistema.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSistemasEquipo;
	}

	public void setselectSistemasEquipo(SelectItem[] selectSistemasEquipo) {
		this.selectSistemasEquipo = selectSistemasEquipo;
	}

	public SelectItem[] getselectCompartimientosEquipo() {

		if (compartimiento == null || compartimiento.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<CompartimientosEquipo> lista = businessDelegatorView
						.findByCriteriaInCompartimientosEquipo(condicion, null, null);
				selectCompartimientosEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CompartimientosEquipo compartimiento : lista) {
					selectCompartimientosEquipo[i] = new SelectItem(compartimiento.getCompartimientosEquipoId(),
							compartimiento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCompartimientosEquipo;
	}

	public void setselectCompartimientosEquipo(SelectItem[] selectCompartimientosEquipo) {
		this.selectCompartimientosEquipo = selectCompartimientosEquipo;
	}

	/**
	 * @return the txtCompartimientosEquipoId_CompartimientosEquipo
	 */
	public SelectOneMenu getTxtCompartimientosEquipoId_CompartimientosEquipo() {
		return txtCompartimientosEquipoId_CompartimientosEquipo;
	}

	/**
	 * @param txtCompartimientosEquipoId_CompartimientosEquipo the
	 *                                                         txtCompartimientosEquipoId_CompartimientosEquipo
	 *                                                         to set
	 */
	public void setTxtCompartimientosEquipoId_CompartimientosEquipo(
			SelectOneMenu txtCompartimientosEquipoId_CompartimientosEquipo) {
		this.txtCompartimientosEquipoId_CompartimientosEquipo = txtCompartimientosEquipoId_CompartimientosEquipo;
	}

	/**
	 * @return the txtSistemasEquipoId_SistemasEquipo
	 */
	public SelectOneMenu getTxtSistemasEquipoId_SistemasEquipo() {
		return txtSistemasEquipoId_SistemasEquipo;
	}

	/**
	 * @param txtSistemasEquipoId_SistemasEquipo the
	 *                                           txtSistemasEquipoId_SistemasEquipo
	 *                                           to set
	 */
	public void setTxtSistemasEquipoId_SistemasEquipo(SelectOneMenu txtSistemasEquipoId_SistemasEquipo) {
		this.txtSistemasEquipoId_SistemasEquipo = txtSistemasEquipoId_SistemasEquipo;
	}

	public InputText getTxtNombreSistema() {
		return txtNombreSistema;
	}

	public void setTxtNombreSistema(InputText txtNombreSistema) {
		this.txtNombreSistema = txtNombreSistema;
	}

	public InputText getTxtNombreCompartimiento() {
		return txtNombreCompartimiento;
	}

	public void setTxtNombreCompartimiento(InputText txtNombreCompartimiento) {
		this.txtNombreCompartimiento = txtNombreCompartimiento;
	}

	public String getOrigendatos() {
		return origendatos;
	}

	public void setOrigendatos(String origendatos) {
		this.origendatos = origendatos;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public List<PlanRevisionEquipoRecursosDTO> getDataRecursosId() {

		if (dataPlanRevisionEquipoRecursos == null || dataPlanRevisionEquipoRecursos.size() == 0) {
			return null;
		} else {
			return dataPlanRevisionEquipoRecursos;
		}
	}

	public void action_agregarRecurso() throws Exception {

		if (txtUdadMedIdRecurso.getValue() != null && txtRendimientoRecurso.getValue() != null
				&& txtTpRecursoId_TipoRecurso.getValue() != null && txtRecursoId.getValue() != null) {

			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedIdRecurso.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

			Long tipoRecurso = Long.parseLong(txtTpRecursoId_TipoRecurso.getValue().toString());
			TipoRecurso tipoRecursoId = businessDelegatorView.getTipoRecurso(tipoRecurso);

			Long recurso = Long.parseLong(txtRecursoId.getValue().toString());

			String nomUdadMed = FacesUtils.checkString(txtNombreUmRecurso);
			String nomTipoRecurso = FacesUtils.checkString(txtNombreTipoRecurso);
			String nomRecurso = FacesUtils.checkString(txtNombreRecurso);

			Double rendimientoRecuro = FacesUtils.checkDouble(txtRendimientoRecurso);

			boolean existeProducto = false;

			if (dataPlanRevisionEquipoRecursos == null) {
				dataPlanRevisionEquipoRecursos = new ArrayList<PlanRevisionEquipoRecursosDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataPlanRevisionEquipoRecursos.size() > 0) {

				for (PlanRevisionEquipoRecursosDTO d : dataPlanRevisionEquipoRecursos) {

					if (d.getTpRecursoId().getTpRecursoId() == tipoRecurso.longValue()
							&& d.getRecursoId().longValue() == recurso.longValue()
							&& d.getUdadMedId().getUdadMedId().longValue() == udadMed.getUdadMedId().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Ya éxiste el recursoo " + "Verifie la unidad de médida. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				PlanRevisionEquipoRecursosDTO equipoRecursosDTO = new PlanRevisionEquipoRecursosDTO();
				equipoRecursosDTO.setUdadMedId(udadMed);
				equipoRecursosDTO.setNombreUm(nomUdadMed);
				equipoRecursosDTO.setTpRecursoId(tipoRecursoId);
				equipoRecursosDTO.setNombreTipoRecurso(nomTipoRecurso);
				// equipoRecursosDTO.setTpRecursoId_TipoRecurso(tipoRecurso);
				equipoRecursosDTO.setRecursoId(recurso);
				equipoRecursosDTO.setNombreRecurso(nomRecurso);
				equipoRecursosDTO.setRendimientoRecurso(rendimientoRecuro);

				dataPlanRevisionEquipoRecursos.add(equipoRecursosDTO);

			}
			udadMed = null;
			nomUdadMed = null;
			tipoRecursoId = null;
			nomTipoRecurso = null;
			recurso = null;
			nomRecurso = null;
			rendimientoRecuro = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos de tipo de recurso,  recurso, unidad de mèdida y rendimeinto tengan valores. "));
		}
	}

	public void listener_ConsultaCodRecurso() {

		Long recursoId = null;
		Long tpRecursoId = null;

		if (!txtRecursoId.getValue().equals("") && !txtTpRecursoId_TipoRecurso.getValue().equals("")) {
			tpRecursoId = Long.parseLong(txtTpRecursoId_TipoRecurso.getValue().toString());
			recursoId = Long.parseLong(txtRecursoId.getValue().toString());

			try {

				TipoRecurso tpRecurso = businessDelegatorView.getTipoRecurso(tpRecursoId);
				if (tpRecurso.getClaseRecurso().equals("Profesiones/Cargos")) {

					TipoRecursosProfesion recurso = businessDelegatorView.getTipoRecursosProfesion(recursoId);
					Long profId = recurso.getProfesion().getProfId();
					Profesion prof = businessDelegatorView.getProfesion(profId);
					txtNombreRecurso.setValue(prof.getNombre());

				}
				if (tpRecurso.getClaseRecurso().equals("Productos")) {

					TipoRecursosInsumos recurso = businessDelegatorView.getTipoRecursosInsumos(recursoId);
					Long prodId = recurso.getProducto().getProductoId();
					Producto prod = businessDelegatorView.getProducto(prodId);

					txtNombreRecurso.setValue(prod.getNombre());

				}
				if (tpRecurso.getClaseRecurso().equals("Categoria de equipos")) {

					TipoRecursosEquipos recurso = businessDelegatorView.getTipoRecursosEquipos(recursoId);

					Long categoriaId = recurso.getCategoriaEquipo().getCategEquipId();
					CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);

					txtNombreRecurso.setValue(categoria.getNombre());

				}
				if (tpRecurso.getClaseRecurso().equals("Otros")) {

					TipoRecursosOtros recurso = businessDelegatorView.getTipoRecursosOtros(recursoId);

					Long servicioId = recurso.getServicioId().getServicioId();
					Servicio servicio = businessDelegatorView.getServicio(servicioId);

					txtNombreRecurso.setValue(servicio.getNombre());

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMedRecurso() {

		Long udadMedId = null;

		if (!txtUdadMedIdRecurso.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedIdRecurso.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNombreUmRecurso.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodTipoRecurso() {

		Long codTipoRecursoId = null;
		Long recursoId = null;

		if (!txtTpRecursoId_TipoRecurso.getValue().equals("")) {
			codTipoRecursoId = Long.parseLong(txtTpRecursoId_TipoRecurso.getValue().toString());

			try {
				TipoRecurso tpRecurso = businessDelegatorView.getTipoRecurso(codTipoRecursoId);
				txtNombreTipoRecurso.setValue(tpRecurso.getNombre());

				if (txtRecursoId.getValue() != null) {
					recursoId = Long.parseLong(txtRecursoId.getValue().toString());
					if (tpRecurso.getClaseRecurso().equals("Profesiones/Cargos")) {

						TipoRecursosProfesion recurso = businessDelegatorView.getTipoRecursosProfesion(recursoId);
						Long profId = recurso.getProfesion().getProfId();
						Profesion prof = businessDelegatorView.getProfesion(profId);
						txtNombreRecurso.setValue(prof.getNombre());

					}
					if (tpRecurso.getClaseRecurso().equals("Productos")) {

						TipoRecursosInsumos recurso = businessDelegatorView.getTipoRecursosInsumos(recursoId);
						Long prodId = recurso.getProducto().getProductoId();
						Producto prod = businessDelegatorView.getProducto(prodId);

						txtNombreRecurso.setValue(prod.getNombre());

					}
					if (tpRecurso.getClaseRecurso().equals("Categoria de equipos")) {

						TipoRecursosEquipos recurso = businessDelegatorView.getTipoRecursosEquipos(recursoId);

						Long categoriaId = recurso.getCategoriaEquipo().getCategEquipId();
						CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);

						txtNombreRecurso.setValue(categoria.getNombre());

					}
					if (tpRecurso.getClaseRecurso().equals("Otros")) {

						TipoRecursosOtros recurso = businessDelegatorView.getTipoRecursosOtros(recursoId);

						Long servicioId = recurso.getServicioId().getServicioId();
						Servicio servicio = businessDelegatorView.getServicio(servicioId);

						txtNombreRecurso.setValue(servicio.getNombre());
					}
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}

	}

	public String actionDeleteLaborRecursos(ActionEvent evt) {
		try {

			selectedPlanRevisionEquipoRecursos = (PlanRevisionEquipoRecursosDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionEquipoRecursos"));

			if (selectedPlanRevisionEquipoRecursos.getPlanRevisionEquipoRecursosId() == null) {
				dataPlanRevisionEquipoRecursos.remove(selectedPlanRevisionEquipoRecursos);
			} else {
				Long RecursoId = new Long(selectedPlanRevisionEquipoRecursos.getPlanRevisionEquipoRecursosId());
				PlanRevisionEquipoRecursos entity = businessDelegatorView.getPlanRevisionEquipoRecursos(RecursoId);
				businessDelegatorView.deletePlanRevisionEquipoRecursos(entity);
				dataPlanRevisionEquipoRecursos.remove(selectedPlanRevisionEquipoRecursos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteLaborProducto(ActionEvent evt) {
		try {

			selectedPlanRevisionProd = (PlanRevisionProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanRevisionProd"));

			if (selectedPlanRevisionProd.getPlanRevisionProdId() == null) {
				dataPlanRevisionProd.remove(selectedPlanRevisionProd);
			} else {
				Long RecursoId = new Long(selectedPlanRevisionProd.getPlanRevisionProdId());
				PlanRevisionProd entity = businessDelegator2View.getPlanRevisionProd(RecursoId);
				businessDelegator2View.deletePlanRevisionProd(entity);
				dataPlanRevisionProd.remove(selectedPlanRevisionProd);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectItem[] getSelectUdadMedIdRecurso() {

		if (udadMedRecurso == null || udadMedRecurso.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedIdRecurso = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedIdRecurso[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedIdRecurso;
	}

	public void setSelectUdadMedIdRecurso(SelectItem[] selectUdadMedIdRecurso) {
		this.selectUdadMedIdRecurso = selectUdadMedIdRecurso;
	}

	public SelectItem[] getSelectTpRecursoId() {

		if (tpRecurso == null || tpRecurso.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoRecurso> lista = businessDelegatorView.findByCriteriaInTipoRecurso(condicion, null, null);
				selectTpRecursoId = new SelectItem[lista.size()];

				int i = 0;
				for (TipoRecurso elementoCosto : lista) {
					selectTpRecursoId[i] = new SelectItem(elementoCosto.getTpRecursoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTpRecursoId;
	}

	public void setSelectTpRecursoId(SelectItem[] selectTpRecursoId) {
		this.selectTpRecursoId = selectTpRecursoId;
	}

	public SelectItem[] getSelectRecurso() {

		if (recurso == null || recurso.size() == 0) {
			try {
				Long idTipoRecurso = FacesUtils.checkLong(txtTpRecursoId_TipoRecurso);
				// Criteria
				if (idTipoRecurso != null) {

					List<ListadoRecursosDTO> listaRecursos = businessDelegatorView
							.consultaListadoRecursos(idTipoRecurso);
					selectRecurso = new SelectItem[listaRecursos.size()];
					int i = 0;
					for (ListadoRecursosDTO consulta : listaRecursos) {
						selectRecurso[i] = new SelectItem(consulta.getRecursoId(), consulta.getNombreRecurso());
						i++;
					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectRecurso;
	}

	public void setSelectRecurso(SelectItem[] selectRecurso) {
		this.selectRecurso = selectRecurso;
	}

	public SelectItem[] getSelectProducto() {

		if (producto == null || producto.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProducto = new SelectItem[lista.size()];

				int i = 0;
				for (Producto producto : lista) {
					selectProducto[i] = new SelectItem(producto.getProductoId(), producto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProducto;
	}

	public void setSelectProducto(SelectItem[] selectProducto) {
		this.selectProducto = selectProducto;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			try {

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

	/**
	 * @return the txtUdadMedIdRecurso
	 */
	public SelectOneMenu getTxtUdadMedIdRecurso() {
		return txtUdadMedIdRecurso;
	}

	/**
	 * @param txtUdadMedIdRecurso the txtUdadMedIdRecurso to set
	 */
	public void setTxtUdadMedIdRecurso(SelectOneMenu txtUdadMedIdRecurso) {
		this.txtUdadMedIdRecurso = txtUdadMedIdRecurso;
	}

	/**
	 * @return the udadMedRecurso
	 */
	public List<UdadMed> getUdadMedRecurso() {
		return udadMedRecurso;
	}

	/**
	 * @param udadMedRecurso the udadMedRecurso to set
	 */
	public void setUdadMedRecurso(List<UdadMed> udadMedRecurso) {
		this.udadMedRecurso = udadMedRecurso;
	}

	/**
	 * @return the txtTpRecursoId_TipoRecurso
	 */
	public SelectOneMenu getTxtTpRecursoId_TipoRecurso() {
		return txtTpRecursoId_TipoRecurso;
	}

	/**
	 * @param txtTpRecursoId_TipoRecurso the txtTpRecursoId_TipoRecurso to set
	 */
	public void setTxtTpRecursoId_TipoRecurso(SelectOneMenu txtTpRecursoId_TipoRecurso) {
		this.txtTpRecursoId_TipoRecurso = txtTpRecursoId_TipoRecurso;
	}

	/**
	 * @return the txtNombreUmRecurso
	 */
	public InputText getTxtNombreUmRecurso() {
		return txtNombreUmRecurso;
	}

	/**
	 * @param txtNombreUmRecurso the txtNombreUmRecurso to set
	 */
	public void setTxtNombreUmRecurso(InputText txtNombreUmRecurso) {
		this.txtNombreUmRecurso = txtNombreUmRecurso;
	}

	/**
	 * @return the txtNombreTipoRecurso
	 */
	public InputText getTxtNombreTipoRecurso() {
		return txtNombreTipoRecurso;
	}

	/**
	 * @param txtNombreTipoRecurso the txtNombreTipoRecurso to set
	 */
	public void setTxtNombreTipoRecurso(InputText txtNombreTipoRecurso) {
		this.txtNombreTipoRecurso = txtNombreTipoRecurso;
	}

	/**
	 * @return the txtRendimientoRecurso
	 */
	public InputText getTxtRendimientoRecurso() {
		return txtRendimientoRecurso;
	}

	/**
	 * @param txtRendimientoRecurso the txtRendimientoRecurso to set
	 */
	public void setTxtRendimientoRecurso(InputText txtRendimientoRecurso) {
		this.txtRendimientoRecurso = txtRendimientoRecurso;
	}

	/**
	 * @return the txtRecursoId
	 */
	public SelectOneMenu getTxtRecursoId() {
		return txtRecursoId;
	}

	/**
	 * @param txtRecursoId the txtRecursoId to set
	 */
	public void setTxtRecursoId(SelectOneMenu txtRecursoId) {
		this.txtRecursoId = txtRecursoId;
	}

	/**
	 * @return the txtLaborRecursosId
	 */
	public InputText getTxtLaborRecursosId() {
		return txtLaborRecursosId;
	}

	/**
	 * @param txtLaborRecursosId the txtLaborRecursosId to set
	 */
	public void setTxtLaborRecursosId(InputText txtLaborRecursosId) {
		this.txtLaborRecursosId = txtLaborRecursosId;
	}

	/**
	 * @return the txtNombreRecurso
	 */
	public InputText getTxtNombreRecurso() {
		return txtNombreRecurso;
	}

	/**
	 * @param txtNombreRecurso the txtNombreRecurso to set
	 */
	public void setTxtNombreRecurso(InputText txtNombreRecurso) {
		this.txtNombreRecurso = txtNombreRecurso;
	}

	/**
	 * @return the txtTrabajarConAreaPlantas
	 */
	public SelectOneMenu getTxtTrabajarConAreaPlantas() {
		return txtTrabajarConAreaPlantas;
	}

	/**
	 * @param txtTrabajarConAreaPlantas the txtTrabajarConAreaPlantas to set
	 */
	public void setTxtTrabajarConAreaPlantas(SelectOneMenu txtTrabajarConAreaPlantas) {
		this.txtTrabajarConAreaPlantas = txtTrabajarConAreaPlantas;
	}

	/**
	 * @return the btnAgregarRecurso
	 */
	public CommandButton getBtnAgregarRecurso() {
		return btnAgregarRecurso;
	}

	/**
	 * @param btnAgregarRecurso the btnAgregarRecurso to set
	 */
	public void setBtnAgregarRecurso(CommandButton btnAgregarRecurso) {
		this.btnAgregarRecurso = btnAgregarRecurso;
	}

	/**
	 * @return the dataPlanRevisionEquipoRecursos
	 */
	public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursos() {
		return dataPlanRevisionEquipoRecursos;
	}

	/**
	 * @param dataPlanRevisionEquipoRecursos the dataPlanRevisionEquipoRecursos to
	 *                                       set
	 */
	public void setDataPlanRevisionEquipoRecursos(List<PlanRevisionEquipoRecursosDTO> dataPlanRevisionEquipoRecursos) {
		this.dataPlanRevisionEquipoRecursos = dataPlanRevisionEquipoRecursos;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public SelectOneMenu getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(SelectOneMenu txtProducto) {
		this.txtProducto = txtProducto;
	}

	public SelectOneMenu getTxtUdadMed() {
		return txtUdadMed;
	}

	public void setTxtUdadMed(SelectOneMenu txtUdadMed) {
		this.txtUdadMed = txtUdadMed;
	}

	public InputNumber getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputNumber txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public CommandButton getBtnAgregarProducto() {
		return btnAgregarProducto;
	}

	public void setBtnAgregarProducto(CommandButton btnAgregarProducto) {
		this.btnAgregarProducto = btnAgregarProducto;
	}

	public List<PlanRevisionProdDTO> getDataPlanRevisionProd() {
		return dataPlanRevisionProd;
	}

	public void setDataPlanRevisionProd(List<PlanRevisionProdDTO> dataPlanRevisionProd) {
		this.dataPlanRevisionProd = dataPlanRevisionProd;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectItem[] getSelectMedidor() {

		if (medidor == null || medidor.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Medidor> lista = businessDelegatorView.findByCriteriaInMedidor(condicion, null, null);
				selectMedidor = new SelectItem[lista.size()];

				int i = 0;
				for (Medidor medidor : lista) {
					selectMedidor[i] = new SelectItem(medidor.getMedidorId(), medidor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMedidor;
	}

	public void setSelectMedidor(SelectItem[] selectMedidor) {
		this.selectMedidor = selectMedidor;
	}

	public SelectOneMenu getTxtMedidor() {
		return txtMedidor;
	}

	public void setTxtMedidor(SelectOneMenu txtMedidor) {
		this.txtMedidor = txtMedidor;
	}

	public InputText getTxtAlertaMin() {
		return txtAlertaMin;
	}

	public void setTxtAlertaMin(InputText txtAlertaMin) {
		this.txtAlertaMin = txtAlertaMin;
	}

	public InputText getTxtAlertaMax() {
		return txtAlertaMax;
	}

	public void setTxtAlertaMax(InputText txtAlertaMax) {
		this.txtAlertaMax = txtAlertaMax;
	}

	public Calendar getTxtFechaUltimoServicio() {
		return txtFechaUltimoServicio;
	}

	public void setTxtFechaUltimoServicio(Calendar txtFechaUltimoServicio) {
		this.txtFechaUltimoServicio = txtFechaUltimoServicio;
	}

	public InputText getTxtHorasUltimoServicio() {
		return txtHorasUltimoServicio;
	}

	public void setTxtHorasUltimoServicio(InputText txtHorasUltimoServicio) {
		this.txtHorasUltimoServicio = txtHorasUltimoServicio;
	}

	public InputText getTxtKmUltimoServicio() {
		return txtKmUltimoServicio;
	}

	public void setTxtKmUltimoServicio(InputText txtKmUltimoServicio) {
		this.txtKmUltimoServicio = txtKmUltimoServicio;
	}

	// Filtros Consulta

	public SelectItem[] getSelectCompania() {

		if (compania == null || compania.size() == 0) {

			try {

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

	public List<PlanRevisionEquipo> getPlanRevision() {

		if (planRevision == null || planRevision.size() == 0) {

			try {

				moduloSeleccionado();
				String modulo = origendatos;

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, modulo, "=" };
				planRevision = businessDelegatorView.findByCriteriaInPlanRevisionEquipo(condicion, null, null);

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return planRevision;
	}

	public void setPlanRevision(List<PlanRevisionEquipo> planRevision) {
		this.planRevision = planRevision;
	}

	public List<String> getSelectedPlanRevision() {
		return selectedPlanRevision;
	}

	public void setSelectedPlanRevision(List<String> selectedPlanRevision) {
		this.selectedPlanRevision = selectedPlanRevision;
	}

	public StreamedContent getdFile() throws IOException {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void listener_ConsultaUmProducto() {

		Long productoId = null;
		Long idUbicacion = null;
		if (txtProducto.getValue() != null) {
			productoId = Long.parseLong(txtProducto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				if (producto.getUdadMedByUdadMedProd() != null) {
					txtUdadMed.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public List<String> getSelectedEquipo() {
		selectedEquipo = null;
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (origendatos != null) {

			if (equipos == null || equipos.size() == 0) {
				String modulo = origendatos;

				try {
					Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, modulo, "=" };
					equipos = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public InputTextarea getTxtObservacionDet() {
		return txtObservacionDet;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public void setTxtObservacionDet(InputTextarea txtObservacionDet) {
		this.txtObservacionDet = txtObservacionDet;
	}
	
	

}