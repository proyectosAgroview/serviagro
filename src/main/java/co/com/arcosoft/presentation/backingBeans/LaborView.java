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
import org.primefaces.component.colorpicker.ColorPicker;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CuentaContable;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.LaborCcontable;
import co.com.arcosoft.modelo.LaborRecursos;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.TarifaLaborRendimiento;
import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.TipoRecursosEquipos;
import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.TipoRecursosOtros;
import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.LaborCcontableDTO;
import co.com.arcosoft.modelo.dto.LaborDTO;
import co.com.arcosoft.modelo.dto.LaborRecursosDTO;
import co.com.arcosoft.modelo.dto.TarifaLaborRendimientoDTO;
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
public class LaborView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaborView.class);
	private SelectOneMenu txtClaseLabor;
	private InputText txtCodigo;
	private ColorPicker txtColor;
	private InputText txtCompania;
	private SelectOneRadio txtDigitaLinea;
	private SelectOneMenu txtFormaPago;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtRestriCicloCosecha;
	private InputText txtRestriSecuencia;
	private SelectOneMenu txtTipoLabor;
	private InputText txtLaborId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<LaborDTO> data;
	private LaborDTO selectedLabor;
	private Labor entity;
	private TarifaLaborRendimiento entityTarifa;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	
	private SelectOneMenu txtGrpLaborId_GrpLabor;
	SelectItem[] selectGrpLabor;
	private List<GrpLabor> grpLabor;

	private SelectOneMenu txtUdadMedId_UdadMed_Plan;
	SelectItem[] selectUdadMed_Plan;
	private List<UdadMed> udadMedRecursolan;

	private SelectOneMenu txtUdadMedId_UdadMed_Pago;
	SelectItem[] selectUdadMed_Pago;
	private List<UdadMed> udadMedRecursoago;

	private SelectOneMenu txtUdadMedId_UdadMed_Prod;
	SelectItem[] selectUdadMed_Prod;
	private List<UdadMed> udadMedRecursorod;

	private InputText txtRendimientoMo;
	private InputText txtRendimientoMq;
	
	
	

	/************* tarifa ***************/

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private InputText txtRendimiento;
	private InputText txtBonificacion;
	private InputText txtTarifa;
	private InputText txtCodNivel2;
	private InputText txtCodContratista;
	private InputText txtCodUdadMed;

	private SelectOneMenu txtUdadMedId_UdadMed_Tarifa;
	SelectItem[] selectUdadMedTarifa;
	private List<UdadMed> udadMedTarifa;

	private SelectOneMenu txtContratistaId_Contratista;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private CommandButton btnAgregar;

	private List<TarifaLaborRendimientoDTO> dataTarifaRendimiento;
	private TarifaLaborRendimientoDTO selectedTarifaRendimiento;

	private LaborRecursosDTO selectedLaborRecursos;
	private List<LaborRecursosDTO> dataLaborRecursos;

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
	private int activeTapIndex = 0;


	private SelectOneMenu txtCuentaContable;
	SelectItem[] selectCuentaContable;
	private List<CuentaContable> cuentaContable;


	private InputText txtRendimientoMax;
	private InputNumber txtPagoPorArea;
	
	private InputNumber txtTarifaEstandar;
	private InputNumber txtTarifaEstandar2;
	private InputNumber txtTarifaEstandar3;
	private InputNumber txtTarifaEstandar4;
	private InputNumber txtTarifaEstandar5;
	private InputNumber txtTarifaEstandar6;
	private InputNumber txtTarifaEstandar7;
	private InputNumber txtTarifaEstandar8;
	private InputNumber txtTarifaEstandar9;
	private InputNumber txtTarifaEstandar10;
	
	private SelectOneMenu txtTipoParada;
	
	/****labores cuenta contable***/
	
	private SelectOneMenu txtCuentaContable2;
	SelectItem[] selectCuentaContable2;
	private List<CuentaContable> cuentaContable2;
	
	private List<LaborCcontableDTO> dataLaborCcontable;
	private LaborCcontableDTO selectedLaborCcontable;
	
	private  CommandButton btnAgregarLaborCcontable;
	
	private LaborCcontable entityLaborCcontable;
	
	public LaborView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedLabor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedLabor = null;
		activeTapIndex = 0;
		PrimeFaces.current().resetInputs(":frm");

		
		if (txtPagoPorArea != null) {
			txtPagoPorArea.setValue(null);
			txtPagoPorArea.setDisabled(true);
		}
		
		
		if (txtTarifaEstandar != null) {
			txtTarifaEstandar.setValue(0);
			txtTarifaEstandar.setDisabled(true);
		}
		
		if (txtTarifaEstandar2 != null) {
			txtTarifaEstandar2.setValue(0);
			txtTarifaEstandar2.setDisabled(true);
		}
		
		if (txtTarifaEstandar3 != null) {
			txtTarifaEstandar3.setValue(0);
			txtTarifaEstandar3.setDisabled(true);
		}
		
		if (txtTarifaEstandar4 != null) {
			txtTarifaEstandar4.setValue(0);
			txtTarifaEstandar4.setDisabled(true);
		}
		
		if (txtTarifaEstandar5 != null) {
			txtTarifaEstandar5.setValue(0);
			txtTarifaEstandar5.setDisabled(true);
		}
		
		if (txtTarifaEstandar6 != null) {
			txtTarifaEstandar6.setValue(0);
			txtTarifaEstandar6.setDisabled(true);
		}
		
		if (txtTarifaEstandar7 != null) {
			txtTarifaEstandar7.setValue(0);
			txtTarifaEstandar7.setDisabled(true);
		}
		
		if (txtTarifaEstandar8 != null) {
			txtTarifaEstandar8.setValue(0);
			txtTarifaEstandar8.setDisabled(true);
		}
		
		if (txtTarifaEstandar9 != null) {
			txtTarifaEstandar9.setValue(0);
			txtTarifaEstandar9.setDisabled(true);
		}
		
		if (txtTarifaEstandar10 != null) {
			txtTarifaEstandar10.setValue(0);
			txtTarifaEstandar10.setDisabled(true);
		}
		
		
		if (txtCuentaContable != null) {
			txtCuentaContable.setValue(null);
			txtCuentaContable.setDisabled(true);
		}
		
		if (txtClaseLabor != null) {
			txtClaseLabor.setValue(null);
			txtClaseLabor.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtFormaPago != null) {
			txtFormaPago.setValue(null);
			txtFormaPago.setDisabled(true);
		}

		if (txtColor != null) {
			txtColor.setValue(null);

		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtDigitaLinea != null) {
			txtDigitaLinea.setValue(null);
			txtDigitaLinea.setDisabled(true);
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

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtRestriCicloCosecha != null) {
			txtRestriCicloCosecha.setValue(null);
			txtRestriCicloCosecha.setDisabled(true);
		}

		if (txtRestriSecuencia != null) {
			txtRestriSecuencia.setValue(null);
			txtRestriSecuencia.setDisabled(true);
		}

		if (txtTipoLabor != null) {
			txtTipoLabor.setValue(null);
			txtTipoLabor.setDisabled(true);
		}

		if (txtGrpLaborId_GrpLabor != null) {
			txtGrpLaborId_GrpLabor.setValue(null);
			txtGrpLaborId_GrpLabor.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed_Plan != null) {
			txtUdadMedId_UdadMed_Plan.setValue(null);
			txtUdadMedId_UdadMed_Plan.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed_Pago != null) {
			txtUdadMedId_UdadMed_Pago.setValue(null);
			txtUdadMedId_UdadMed_Pago.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed_Prod != null) {
			txtUdadMedId_UdadMed_Prod.setValue(null);
			txtUdadMedId_UdadMed_Prod.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtLaborId != null) {
			txtLaborId.setValue(null);
			txtLaborId.setDisabled(false);
		}

		if (txtRendimientoMo != null) {
			txtRendimientoMo.setValue(null);
			txtRendimientoMo.setDisabled(true);
		}
		if (txtRendimientoMq != null) {
			txtRendimientoMq.setValue(null);
			txtRendimientoMq.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtContratistaId_Contratista != null) {
			txtContratistaId_Contratista.setValue(null);
			txtContratistaId_Contratista.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed_Tarifa != null) {
			txtUdadMedId_UdadMed_Tarifa.setValue(null);
			txtUdadMedId_UdadMed_Tarifa.setDisabled(true);
		}

		if (txtBonificacion != null) {
			txtBonificacion.setValue(null);
			txtBonificacion.setDisabled(true);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(true);
		}

		if (txtRendimiento != null) {
			txtRendimiento.setValue(null);
			txtRendimiento.setDisabled(true);
		}

		if (txtRendimientoMax != null) {
			txtRendimientoMax.setValue(null);
			txtRendimientoMax.setDisabled(true);
		}
		if (dataTarifaRendimiento != null) {
			dataTarifaRendimiento = null;
		}
		
	
		if (txtCodNivel2 != null) {
			txtCodNivel2.setValue(null);
			txtCodNivel2.setDisabled(true);
		}
		if (txtCodContratista != null) {
			txtCodContratista.setValue(null);
			txtCodContratista.setDisabled(true);
		}
		if (txtCodUdadMed != null) {
			txtCodUdadMed.setValue(null);
			txtCodUdadMed.setDisabled(true);
		}
		if (txtTarifa != null) {
			txtTarifa.setValue(null);
			txtTarifa.setDisabled(true);
		}

		


		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		/********** Labores recursos ****/
		if (dataLaborRecursos != null) {
			dataLaborRecursos = null;
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
		if (txtTrabajarConAreaPlantas != null) {
			txtTrabajarConAreaPlantas.setValue(null);
			txtTrabajarConAreaPlantas.setDisabled(true);
		}
		if (txtLaborRecursosId != null) {
			txtLaborRecursosId.setValue(null);
			txtLaborRecursosId.setDisabled(true);
		}

		/******detalle cuentas***/
		if (btnAgregarLaborCcontable != null) {
			btnAgregarLaborCcontable.setDisabled(false);
		}	
		if (dataLaborCcontable != null) {
			dataLaborCcontable = null;
		}
		if (txtCuentaContable2 != null) {
			txtCuentaContable2.setValue(null);
			txtCuentaContable2.setDisabled(true);
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

	public List<TarifaLaborRendimientoDTO> getDataRendimientoByTarifaRendimientoId() {

		if (dataTarifaRendimiento == null || dataTarifaRendimiento.size() == 0) {
			return null;
		} else {
			return dataTarifaRendimiento;
		}

	}

	public void action_agregarTarifaRendimiento() throws NumberFormatException, Exception {
		if (txtFechaInicial.getValue() != null && txtFechaFinal.getValue() != null
				&& txtUdadMedId_UdadMed_Tarifa.getValue() != null 
				&& txtTarifa.getValue() != null
				) {
		Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed_Tarifa.getValue().toString());
		UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
		String nomUdadMed = udadMed.getNombre();
		
		Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Double rendimiento = 0.0;//FacesUtils.checkDouble(txtRendimiento);
		Double tarifa = FacesUtils.checkDouble(txtTarifa);
	//	Double bonificacion = FacesUtils.checkDouble(txtBonificacion);
		Long compania = new Long(getCompaniaIdSession());
		Date fechaCreacion = new Date();
		Date fechaModificacion = new Date();
		Double rendimientoMax =0.0;//  FacesUtils.checkDouble(txtRendimientoMax);
				
				
		if (dataTarifaRendimiento == null) {
			dataTarifaRendimiento = new ArrayList<TarifaLaborRendimientoDTO>();
		}

		TarifaLaborRendimientoDTO tarifaLaborRendimientoDTO = new TarifaLaborRendimientoDTO();
		tarifaLaborRendimientoDTO.setFechaInicial(fechaInicial);
		tarifaLaborRendimientoDTO.setFechaFinal(fechaFinal);
		tarifaLaborRendimientoDTO.setRendimiento(rendimiento);
		tarifaLaborRendimientoDTO.setRendimientoMax(rendimientoMax);
		tarifaLaborRendimientoDTO.setUdadMedId(udadMed);
		tarifaLaborRendimientoDTO.setTarifa(tarifa);
		tarifaLaborRendimientoDTO.setCompania(compania);
		tarifaLaborRendimientoDTO.setFechaCreacion(fechaCreacion);
		tarifaLaborRendimientoDTO.setFechaModificacion(fechaModificacion);
		tarifaLaborRendimientoDTO.setCodUdadMed(nomUdadMed);

		
		dataTarifaRendimiento.add(tarifaLaborRendimientoDTO);

		fechaInicial = null;
		fechaFinal = null;
		rendimiento = null;
		udadMed = null;
		nomUdadMed=null;
		tarifa = null;
		compania = null;
		fechaCreacion = null;
		fechaModificacion = null;
		rendimientoMax = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final, unidad médida, cantidad, profesión, concepto y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMed_Tarifa.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMed_Tarifa.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodUdadMed.setValue(udadMed.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodContratista() {

		Long contratistaId = null;

		if (!txtContratistaId_Contratista.getValue().equals("")) {
			contratistaId = Long.parseLong(txtContratistaId_Contratista.getValue().toString());

			try {
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(contratistaId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodContratista.setValue(persEmpr.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodNivel2() {

		Long nivel2Id = null;

		if (!txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodNivel2.setValue(nivel2.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Labor> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInLabor(condicion, null, null)
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
			txtTipoParada.setDisabled(false);
			txtPagoPorArea.setDisabled(false);
			
			txtTarifaEstandar.setDisabled(false);
			txtTarifaEstandar2.setDisabled(false);
			txtTarifaEstandar3.setDisabled(false);
			txtTarifaEstandar4.setDisabled(false);
			txtTarifaEstandar5.setDisabled(false);
			txtTarifaEstandar6.setDisabled(false);
			txtTarifaEstandar7.setDisabled(false);
			txtTarifaEstandar8.setDisabled(false);
			txtTarifaEstandar9.setDisabled(false);
			txtTarifaEstandar10.setDisabled(false);
			
			txtClaseLabor.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCuentaContable.setDisabled(false);
			// txtCompania.setDisabled(false);
			// txtDigitaLinea.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtRestriCicloCosecha.setDisabled(false);
			// txtRestriSecuencia.setDisabled(false);
			txtTipoLabor.setDisabled(false);
			txtGrpLaborId_GrpLabor.setDisabled(false);
			txtUdadMedId_UdadMed_Plan.setDisabled(false);
			txtUdadMedId_UdadMed_Pago.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			// txtFormaPago.setDisabled(false);
			txtRendimientoMo.setDisabled(false);
			txtRendimientoMq.setDisabled(false);

			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);

			txtLaborId.setDisabled(false);

			btnSave.setDisabled(false);
			/********** Labores recursos ****/
			btnAgregarRecurso.setDisabled(false);
			txtUdadMedIdRecurso.setDisabled(false);
			txtTpRecursoId_TipoRecurso.setDisabled(false);
			txtNombreUmRecurso.setDisabled(false);
			txtNombreTipoRecurso.setDisabled(false);
			txtRendimientoRecurso.setDisabled(false);
			txtRecursoId.setDisabled(false);
			txtNombreRecurso.setDisabled(false);
			txtTrabajarConAreaPlantas.setDisabled(false);
			txtLaborRecursosId.setDisabled(false);

		//	txtRendimiento.setDisabled(false);
			txtTarifa.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtUdadMedId_UdadMed_Tarifa.setDisabled(false);
		//	txtRendimientoMax.setDisabled(false);
			
			btnAgregar.setDisabled(false);
			
				btnAgregarLaborCcontable.setDisabled(false);
				dataLaborCcontable = null;
				txtCuentaContable2.setDisabled(false);
			

			
		} else {
			txtTipoParada.setValue(entity.getTipoParada());
			txtTipoParada.setDisabled(false);
			
			txtPagoPorArea.setValue(entity.getPagoPorArea());
			txtPagoPorArea.setDisabled(false);
			
			txtTarifaEstandar.setValue(entity.getTarifaEstandar());
			txtTarifaEstandar.setDisabled(false);
			
			txtTarifaEstandar2.setValue(entity.getTarifaEstandar2());
			txtTarifaEstandar2.setDisabled(false);
			
			txtTarifaEstandar3.setValue(entity.getTarifaEstandar3());
			txtTarifaEstandar3.setDisabled(false);
			
			txtTarifaEstandar4.setValue(entity.getTarifaEstandar4());
			txtTarifaEstandar4.setDisabled(false);
			
			txtTarifaEstandar5.setValue(entity.getTarifaEstandar5());
			txtTarifaEstandar5.setDisabled(false);
			
			txtTarifaEstandar6.setValue(entity.getTarifaEstandar6());
			txtTarifaEstandar6.setDisabled(false);
			
			txtTarifaEstandar7.setValue(entity.getTarifaEstandar7());
			txtTarifaEstandar7.setDisabled(false);
			
			txtTarifaEstandar8.setValue(entity.getTarifaEstandar8());
			txtTarifaEstandar8.setDisabled(false);
			
			txtTarifaEstandar9.setValue(entity.getTarifaEstandar9());
			txtTarifaEstandar9.setDisabled(false);
			
			txtTarifaEstandar10.setValue(entity.getTarifaEstandar10());
			txtTarifaEstandar10.setDisabled(false);
			
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtColor.setValue(entity.getColor());
			txtCuentaContable.setValue(entity.getCuentaContable());
			txtCuentaContable.setDisabled(false);
			txtClaseLabor.setValue(entity.getClaseLabor());
			txtClaseLabor.setDisabled(false);
			
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtRestriCicloCosecha.setValue(entity.getRestriCicloCosecha());
			txtRestriCicloCosecha.setDisabled(false);
			txtTipoLabor.setValue(entity.getTipoLabor());
			txtTipoLabor.setDisabled(false);
			txtGrpLaborId_GrpLabor.setValue(entity.getGrpLabor().getGrpLaborId());
			txtGrpLaborId_GrpLabor.setDisabled(false);
			txtUdadMedId_UdadMed_Plan.setValue(entity.getUdadMedByUdadMedPlan());
			txtUdadMedId_UdadMed_Plan.setDisabled(false);
			txtUdadMedId_UdadMed_Pago.setValue(entity.getUdadMedByUdadMedPago().getUdadMedId());
			txtUdadMedId_UdadMed_Pago.setDisabled(false);
			txtUdadMedId_UdadMed_Prod.setValue(entity.getUdadMedByUdadMedProd());
			txtUdadMedId_UdadMed_Prod.setDisabled(false);
			txtLaborId.setValue(entity.getLaborId());
			txtLaborId.setDisabled(true);
			txtRendimientoMo.setValue(entity.getRendimientoMo());
			txtRendimientoMo.setDisabled(false);
			txtRendimientoMq.setValue(entity.getRendimientoMq());
			txtRendimientoMq.setDisabled(false);
			btnSave.setDisabled(false);

			Long laborId = FacesUtils.checkLong(txtLaborId);
			dataLaborRecursos = null;
			dataLaborRecursos = businessDelegatorView.getDataLaborRecursosByLabor(laborId);


			dataTarifaRendimiento = null;
			dataTarifaRendimiento = businessDelegatorView.getDataRendimientoByTarifaRendimientoId(laborId);
			
			dataLaborCcontable = null;
			dataLaborCcontable = businessDelegator2View.getDataLaborCcontableByLabor(laborId);

			
			

			btnAgregarRecurso.setDisabled(false);
			txtUdadMedIdRecurso.setDisabled(false);
			txtTpRecursoId_TipoRecurso.setDisabled(false);
			txtNombreUmRecurso.setDisabled(false);
			txtNombreTipoRecurso.setDisabled(false);
			txtRendimientoRecurso.setDisabled(false);
			txtRecursoId.setDisabled(false);
			txtNombreRecurso.setDisabled(false);
			txtTrabajarConAreaPlantas.setValue(entity.getTrabajarConAreaPlantas());
			txtTrabajarConAreaPlantas.setDisabled(false);
			txtLaborRecursosId.setDisabled(false);

			//txtRendimiento.setDisabled(false);
			txtTarifa.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtUdadMedId_UdadMed_Tarifa.setDisabled(false);
			//txtRendimientoMax.setDisabled(false);
			
			btnAgregar.setDisabled(false);
			
			btnAgregarLaborCcontable.setDisabled(false);
			dataLaborCcontable = null;
			txtCuentaContable2.setDisabled(false);
		
			
			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedLabor = (LaborDTO) (evt.getComponent().getAttributes().get("selectedLabor"));
		try {

			String codigo = selectedLabor.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Labor> lista = (codigo != null) ? businessDelegatorView.findByCriteriaInLabor(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtPagoPorArea.setValue(entity.getPagoPorArea());
				txtPagoPorArea.setDisabled(false);
				
				txtTarifaEstandar.setValue(entity.getTarifaEstandar());
				txtTarifaEstandar.setDisabled(false);
				
				txtTarifaEstandar2.setValue(entity.getTarifaEstandar2());
				txtTarifaEstandar2.setDisabled(false);
				
				txtTarifaEstandar3.setValue(entity.getTarifaEstandar3());
				txtTarifaEstandar3.setDisabled(false);
				
				txtTarifaEstandar4.setValue(entity.getTarifaEstandar4());
				txtTarifaEstandar4.setDisabled(false);
				
				txtTarifaEstandar5.setValue(entity.getTarifaEstandar5());
				txtTarifaEstandar5.setDisabled(false);
				
				txtTarifaEstandar6.setValue(entity.getTarifaEstandar6());
				txtTarifaEstandar6.setDisabled(false);
				
				txtTarifaEstandar7.setValue(entity.getTarifaEstandar7());
				txtTarifaEstandar7.setDisabled(false);
				
				txtTarifaEstandar8.setValue(entity.getTarifaEstandar8());
				txtTarifaEstandar8.setDisabled(false);
				
				txtTarifaEstandar9.setValue(entity.getTarifaEstandar9());
				txtTarifaEstandar9.setDisabled(false);
				
				txtTarifaEstandar10.setValue(entity.getTarifaEstandar10());
				txtTarifaEstandar10.setDisabled(false);
				
				txtTipoParada.setValue(entity.getTipoParada());
				txtTipoParada.setDisabled(false);
				
				txtColor.setValue(entity.getColor());
				txtTrabajarConAreaPlantas.setValue(entity.getTrabajarConAreaPlantas());
				txtTrabajarConAreaPlantas.setDisabled(false);

				txtClaseLabor.setValue(entity.getClaseLabor());
				txtClaseLabor.setDisabled(false);
				
				txtCuentaContable.setValue(entity.getCuentaContable());
				txtCuentaContable.setDisabled(false);
				
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtRestriCicloCosecha.setValue(entity.getRestriCicloCosecha());
				txtRestriCicloCosecha.setDisabled(false);
				txtTipoLabor.setValue(entity.getTipoLabor());
				txtTipoLabor.setDisabled(false);

				txtGrpLaborId_GrpLabor.setValue(entity.getGrpLabor().getGrpLaborId());
				txtGrpLaborId_GrpLabor.setDisabled(false);
				txtUdadMedId_UdadMed_Plan.setValue(entity.getUdadMedByUdadMedPlan());
				txtUdadMedId_UdadMed_Plan.setDisabled(false);
				txtUdadMedId_UdadMed_Pago.setValue(entity.getUdadMedByUdadMedPago().getUdadMedId());
				txtUdadMedId_UdadMed_Pago.setDisabled(false);
				txtUdadMedId_UdadMed_Prod.setValue(entity.getUdadMedByUdadMedProd());
				txtUdadMedId_UdadMed_Prod.setDisabled(false);
				txtLaborId.setValue(entity.getLaborId());
				txtLaborId.setDisabled(true);
				txtRendimientoMo.setValue(entity.getRendimientoMo());
				txtRendimientoMo.setDisabled(false);
				txtRendimientoMq.setValue(entity.getRendimientoMq());
				txtRendimientoMq.setDisabled(false);

				/*** sesion tarifa **/

				Long laborId = FacesUtils.checkLong(txtLaborId);
				dataLaborRecursos = null;
				dataLaborRecursos = businessDelegatorView.getDataLaborRecursosByLabor(laborId);

				dataTarifaRendimiento = null;
				dataTarifaRendimiento = businessDelegatorView.getDataRendimientoByTarifaRendimientoId(laborId);

				dataLaborCcontable = null;
				dataLaborCcontable = businessDelegator2View.getDataLaborCcontableByLabor(laborId);

				btnAgregarRecurso.setDisabled(false);
				txtUdadMedIdRecurso.setDisabled(false);
				txtTpRecursoId_TipoRecurso.setDisabled(false);
				txtNombreUmRecurso.setDisabled(false);
				txtNombreTipoRecurso.setDisabled(false);
				txtRendimientoRecurso.setDisabled(false);
				txtRecursoId.setDisabled(false);
				txtNombreRecurso.setDisabled(false);
				txtLaborRecursosId.setDisabled(false);
				
				//txtRendimiento.setDisabled(false);
			//	txtRendimientoMax.setDisabled(false);
				
				txtTarifa.setDisabled(false);
				txtFechaInicial.setDisabled(false);
				txtFechaFinal.setDisabled(false);
				txtUdadMedId_UdadMed_Tarifa.setDisabled(false);
				
				btnAgregar.setDisabled(false);
				
				btnSave.setDisabled(false);
				
				btnAgregarLaborCcontable.setDisabled(false);
				txtCuentaContable2.setDisabled(false);
				
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
			if ((selectedLabor == null) && (entity == null)) {
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
			entity = new Labor();

			// Long laborId = FacesUtils.checkLong(txtLaborId);
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setClaseLabor(FacesUtils.checkString(txtClaseLabor));
			entity.setCuentaContable(FacesUtils.checkLong(txtCuentaContable));
			
			entity.setPagoPorArea(FacesUtils.checkDouble(txtPagoPorArea));
			
			entity.setTarifaEstandar(FacesUtils.checkDouble(txtTarifaEstandar));
			entity.setTarifaEstandar2(FacesUtils.checkDouble(txtTarifaEstandar2));
			entity.setTarifaEstandar3(FacesUtils.checkDouble(txtTarifaEstandar3));
			entity.setTarifaEstandar4(FacesUtils.checkDouble(txtTarifaEstandar4));
			entity.setTarifaEstandar5(FacesUtils.checkDouble(txtTarifaEstandar5));
			entity.setTarifaEstandar6(FacesUtils.checkDouble(txtTarifaEstandar6));
			entity.setTarifaEstandar7(FacesUtils.checkDouble(txtTarifaEstandar7));
			entity.setTarifaEstandar8(FacesUtils.checkDouble(txtTarifaEstandar8));
			entity.setTarifaEstandar9(FacesUtils.checkDouble(txtTarifaEstandar9));
			entity.setTarifaEstandar10(FacesUtils.checkDouble(txtTarifaEstandar10));
		
			entity.setTipoParada(FacesUtils.checkString(txtTipoParada));
			
			
			entity.setTrabajarConAreaPlantas(FacesUtils.checkString(txtTrabajarConAreaPlantas));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setDigitaLinea(FacesUtils.checkString(txtDigitaLinea));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFormaPago("Destajo");
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setRendimientoMo(FacesUtils.checkDouble(txtRendimientoMo));
			entity.setRendimientoMq(FacesUtils.checkDouble(txtRendimientoMq));

			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setLaborId(laborId);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setRestriCicloCosecha(FacesUtils.checkLong(txtRestriCicloCosecha));
			entity.setRestriSecuencia(FacesUtils.checkLong(txtRestriSecuencia));
			entity.setTipoLabor(FacesUtils.checkString(txtTipoLabor));
			entity.setGrpLabor((FacesUtils.checkLong(txtGrpLaborId_GrpLabor) != null)
					? businessDelegatorView.getGrpLabor(FacesUtils.checkLong(txtGrpLaborId_GrpLabor)) : null);
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setUdadMedByUdadMedPlan((FacesUtils.checkLong(txtUdadMedId_UdadMed_Plan)));
			entity.setUdadMedByUdadMedPago((FacesUtils.checkLong(txtUdadMedId_UdadMed_Pago) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed_Pago)) : null);
			entity.setUdadMedByUdadMedProd((FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod)));
			businessDelegatorView.saveLabor(entity, dataTarifaRendimiento, dataLaborRecursos, dataLaborCcontable);
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
				Long laborId = new Long(selectedLabor.getLaborId());
				entity = businessDelegatorView.getLabor(laborId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setClaseLabor(FacesUtils.checkString(txtClaseLabor));
			entity.setCuentaContable(FacesUtils.checkLong(txtCuentaContable));
			entity.setPagoPorArea(FacesUtils.checkDouble(txtPagoPorArea));
			
			entity.setTarifaEstandar(FacesUtils.checkDouble(txtTarifaEstandar));
			entity.setTarifaEstandar2(FacesUtils.checkDouble(txtTarifaEstandar2));
			entity.setTarifaEstandar3(FacesUtils.checkDouble(txtTarifaEstandar3));
			entity.setTarifaEstandar4(FacesUtils.checkDouble(txtTarifaEstandar4));
			entity.setTarifaEstandar5(FacesUtils.checkDouble(txtTarifaEstandar5));
			entity.setTarifaEstandar6(FacesUtils.checkDouble(txtTarifaEstandar6));
			entity.setTarifaEstandar7(FacesUtils.checkDouble(txtTarifaEstandar7));
			entity.setTarifaEstandar8(FacesUtils.checkDouble(txtTarifaEstandar8));
			entity.setTarifaEstandar9(FacesUtils.checkDouble(txtTarifaEstandar9));
			entity.setTarifaEstandar10(FacesUtils.checkDouble(txtTarifaEstandar10));
		
			entity.setTipoParada(FacesUtils.checkString(txtTipoParada));
			
			
			entity.setTrabajarConAreaPlantas(FacesUtils.checkString(txtTrabajarConAreaPlantas));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setFormaPago("Destajo");
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setCompania(compania);
			entity.setDigitaLinea(FacesUtils.checkString(txtDigitaLinea));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(date);
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setRestriCicloCosecha(FacesUtils.checkLong(txtRestriCicloCosecha));
			entity.setRestriSecuencia(FacesUtils.checkLong(txtRestriSecuencia));
			entity.setTipoLabor(FacesUtils.checkString(txtTipoLabor));
			entity.setGrpLabor((FacesUtils.checkLong(txtGrpLaborId_GrpLabor) != null)
					? businessDelegatorView.getGrpLabor(FacesUtils.checkLong(txtGrpLaborId_GrpLabor)) : null);
			entity.setUdadMedByUdadMedPlan((FacesUtils.checkLong(txtUdadMedId_UdadMed_Plan)));
			entity.setUdadMedByUdadMedPago((FacesUtils.checkLong(txtUdadMedId_UdadMed_Pago) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed_Pago)) : null);
			entity.setUdadMedByUdadMedProd((FacesUtils.checkLong(txtUdadMedId_UdadMed_Prod)));
			entity.setRendimientoMo(FacesUtils.checkDouble(txtRendimientoMo));
			entity.setRendimientoMq(FacesUtils.checkDouble(txtRendimientoMq));

			businessDelegatorView.updateLabor(entity, dataTarifaRendimiento, dataLaborRecursos,dataLaborCcontable);
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
			selectedLabor = (LaborDTO) (evt.getComponent().getAttributes().get("selectedLabor"));

			Long laborId = new Long(selectedLabor.getLaborId());
			entity = businessDelegatorView.getLabor(laborId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long laborId = FacesUtils.checkLong(txtLaborId);
			entity = businessDelegatorView.getLabor(laborId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteLabor(entity);
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
			selectedLabor = (LaborDTO) (evt.getComponent().getAttributes().get("selectedLabor"));

			Long laborId = new Long(selectedLabor.getLaborId());
			entity = businessDelegatorView.getLabor(laborId);
			businessDelegatorView.deleteLabor(entity);
			data.remove(selectedLabor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String claseLabor, String codigo, Double color, Long compania, String digitaLinea,
			String estado, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2,
			Long laborId, String nombre, String formaPago, Long restriCicloCosecha, Long restriSecuencia,
			String tipoLabor, Long grpLaborId_GrpLabor, Long udadMedId_UdadMed_Plan, Long udadMedId_UdadMed_Pago,
			Long udadMedId_UdadMed_Prod) throws Exception {
		try {
			entity.setClaseLabor(FacesUtils.checkString(claseLabor));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setColor(FacesUtils.checkString(color));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setDigitaLinea(FacesUtils.checkString(digitaLinea));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFormaPago(FacesUtils.checkString(formaPago));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setRestriCicloCosecha(FacesUtils.checkLong(restriCicloCosecha));
			entity.setRestriSecuencia(FacesUtils.checkLong(restriSecuencia));
			entity.setTipoLabor(FacesUtils.checkString(tipoLabor));
			businessDelegatorView.updateLabor(entity, dataTarifaRendimiento, dataLaborRecursos,dataLaborCcontable);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("LaborView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String actionDeleteTarifaRendimiento(ActionEvent evt) {
		try {

			selectedTarifaRendimiento = (TarifaLaborRendimientoDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaRendimiento"));

			if (selectedTarifaRendimiento.getTarifaLaborId() == null) {
				dataTarifaRendimiento.remove(selectedTarifaRendimiento);
			} else {
				Long tarifaRendimientoId = new Long(selectedTarifaRendimiento.getTarifaLaborId());
				TarifaLaborRendimiento entity = businessDelegatorView.getTarifaLaborRendimiento(tarifaRendimientoId);
				businessDelegatorView.deleteTarifaLaborRendimiento(entity);
				dataTarifaRendimiento.remove(selectedTarifaRendimiento);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectOneMenu getTxtClaseLabor() {
		return txtClaseLabor;
	}

	public void setTxtClaseLabor(SelectOneMenu txtClaseLabor) {
		this.txtClaseLabor = txtClaseLabor;
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

	public SelectOneRadio getTxtDigitaLinea() {
		return txtDigitaLinea;
	}

	public void setTxtDigitaLinea(SelectOneRadio txtDigitaLinea) {
		this.txtDigitaLinea = txtDigitaLinea;
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

	public InputText getTxtRestriCicloCosecha() {
		return txtRestriCicloCosecha;
	}

	public void setTxtRestriCicloCosecha(InputText txtRestriCicloCosecha) {
		this.txtRestriCicloCosecha = txtRestriCicloCosecha;
	}

	public InputText getTxtRestriSecuencia() {
		return txtRestriSecuencia;
	}

	public void setTxtRestriSecuencia(InputText txtRestriSecuencia) {
		this.txtRestriSecuencia = txtRestriSecuencia;
	}

	public SelectOneMenu getTxtTipoLabor() {
		return txtTipoLabor;
	}

	public void setTxtTipoLabor(SelectOneMenu txtTipoLabor) {
		this.txtTipoLabor = txtTipoLabor;
	}

	public SelectOneMenu getTxtGrpLaborId_GrpLabor() {
		return txtGrpLaborId_GrpLabor;
	}

	public void setTxtGrpLaborId_GrpLabor(SelectOneMenu txtGrpLaborId_GrpLabor) {
		this.txtGrpLaborId_GrpLabor = txtGrpLaborId_GrpLabor;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed_Plan() {
		return txtUdadMedId_UdadMed_Plan;
	}

	public void setTxtUdadMedId_UdadMed_Plan(SelectOneMenu txtUdadMedId_UdadMed_Plan) {
		this.txtUdadMedId_UdadMed_Plan = txtUdadMedId_UdadMed_Plan;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed_Pago() {
		return txtUdadMedId_UdadMed_Pago;
	}

	public void setTxtUdadMedId_UdadMed_Pago(SelectOneMenu txtUdadMedId_UdadMed_Pago) {
		this.txtUdadMedId_UdadMed_Pago = txtUdadMedId_UdadMed_Pago;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed_Prod() {
		return txtUdadMedId_UdadMed_Prod;
	}

	public void setTxtUdadMedId_UdadMed_Prod(SelectOneMenu txtUdadMedId_UdadMed_Prod) {
		this.txtUdadMedId_UdadMed_Prod = txtUdadMedId_UdadMed_Prod;
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

	public InputText getTxtLaborId() {
		return txtLaborId;
	}

	public void setTxtLaborId(InputText txtLaborId) {
		this.txtLaborId = txtLaborId;
	}

	public List<LaborDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataLabor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<LaborDTO> laborDTO) {
		this.data = laborDTO;
	}

	public LaborDTO getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(LaborDTO labor) {
		this.selectedLabor = labor;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public InputText getTxtRendimiento() {
		return txtRendimiento;
	}

	public void setTxtRendimiento(InputText txtRendimiento) {
		this.txtRendimiento = txtRendimiento;
	}

	public InputText getTxtBonificacion() {
		return txtBonificacion;
	}

	public void setTxtBonificacion(InputText txtBonificacion) {
		this.txtBonificacion = txtBonificacion;
	}

	public SelectOneMenu getTxtFormaPago() {
		return txtFormaPago;
	}

	public void setTxtFormaPago(SelectOneMenu txtFormaPago) {
		this.txtFormaPago = txtFormaPago;
	}

	public SelectOneMenu getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(SelectOneMenu txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public InputText getTxtTarifa() {
		return txtTarifa;
	}

	public void setTxtTarifa(InputText txtTarifa) {
		this.txtTarifa = txtTarifa;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed_Tarifa() {
		return txtUdadMedId_UdadMed_Tarifa;
	}

	public void setTxtUdadMedId_UdadMed_Tarifa(SelectOneMenu txtUdadMedId_UdadMed_Tarifa) {
		this.txtUdadMedId_UdadMed_Tarifa = txtUdadMedId_UdadMed_Tarifa;
	}

	public SelectOneMenu getTxtContratistaId_Contratista() {
		return txtContratistaId_Contratista;
	}

	public void setTxtContratistaId_Contratista(SelectOneMenu txtContratistaId_Contratista) {
		this.txtContratistaId_Contratista = txtContratistaId_Contratista;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<TarifaLaborRendimientoDTO> getDataTarifaRendimiento() {
		return dataTarifaRendimiento;
	}

	public void setDataTarifaRendimiento(List<TarifaLaborRendimientoDTO> dataTarifaRendimiento) {
		this.dataTarifaRendimiento = dataTarifaRendimiento;
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

	public InputText getTxtRendimientoMo() {
		return txtRendimientoMo;
	}

	public void setTxtRendimientoMo(InputText txtRendimientoMo) {
		this.txtRendimientoMo = txtRendimientoMo;
	}

	public InputText getTxtRendimientoMq() {
		return txtRendimientoMq;
	}

	public void setTxtRendimientoMq(InputText txtRendimientoMq) {
		this.txtRendimientoMq = txtRendimientoMq;
	}

	public SelectItem[] getSelectUdadMed_Prod() {

		if (udadMedRecursorod == null || udadMedRecursorod.size() == 0) {

			udadMedRecursorod = new ArrayList<UdadMed>();

			try {

				udadMedRecursorod = businessDelegatorView.getUdadMed(); // Fin
																		// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed_Prod = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedRecursorod : lista) {
					selectUdadMed_Prod[i] = new SelectItem(udadMedRecursorod.getUdadMedId(),
							udadMedRecursorod.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed_Prod;
	}

	public void setSelectUdadMed_Prod(SelectItem[] selectUdadMed_Prod) {
		this.selectUdadMed_Prod = selectUdadMed_Prod;
	}

	public SelectItem[] getSelectUdadMed_Pago() {

		if (udadMedRecursoago == null || udadMedRecursoago.size() == 0) {

			udadMedRecursoago = new ArrayList<UdadMed>();

			try {

				udadMedRecursoago = businessDelegatorView.getUdadMed(); // Fin
																		// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed_Pago = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedRecursoago : lista) {
					selectUdadMed_Pago[i] = new SelectItem(udadMedRecursoago.getUdadMedId(),
							udadMedRecursoago.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed_Pago;
	}

	public void setSelectUdadMed_Pago(SelectItem[] selectUdadMed_Pago) {
		this.selectUdadMed_Pago = selectUdadMed_Pago;
	}

	public SelectItem[] getSelectUdadMed_Plan() {

		if (udadMedRecursolan == null || udadMedRecursolan.size() == 0) {

			udadMedRecursolan = new ArrayList<UdadMed>();

			try {

				udadMedRecursolan = businessDelegatorView.getUdadMed(); // Fin
																		// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed_Plan = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedRecursolan : lista) {
					selectUdadMed_Plan[i] = new SelectItem(udadMedRecursolan.getUdadMedId(),
							udadMedRecursolan.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed_Plan;
	}

	public void setSelectUdadMed_Plan(SelectItem[] selectUdadMed_Plan) {
		this.selectUdadMed_Plan = selectUdadMed_Plan;
	}

	public SelectItem[] getSelectUdadMedTarifa() {

		if (udadMedTarifa == null || udadMedTarifa.size() == 0) {

			udadMedTarifa = new ArrayList<UdadMed>();

			try {

				udadMedTarifa = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedTarifa = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedTarifa : lista) {
					selectUdadMedTarifa[i] = new SelectItem(udadMedTarifa.getUdadMedId(), udadMedTarifa.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedTarifa;
	}

	public void setSelectUdadMedTarifa(SelectItem[] selectUdadMedTarifa) {
		this.selectUdadMedTarifa = selectUdadMedTarifa;
	}

	public SelectItem[] getSelectGrpLabor() {

		if (grpLabor == null || grpLabor.size() == 0) {

			grpLabor = new ArrayList<GrpLabor>();

			try {

				grpLabor = businessDelegatorView.getGrpLabor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<GrpLabor> lista = businessDelegatorView.findByCriteriaInGrpLabor(condicion, null, null);
				selectGrpLabor = new SelectItem[lista.size()];

				int i = 0;
				for (GrpLabor grpLabor : lista) {
					selectGrpLabor[i] = new SelectItem(grpLabor.getGrpLaborId(),
							grpLabor.getCodigo() + " - " + grpLabor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectGrpLabor;
	}

	public void setselectGrpLabor(SelectItem[] selectGrpLabor) {
		this.selectGrpLabor = selectGrpLabor;
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

	public InputText getTxtCodNivel2() {
		return txtCodNivel2;
	}

	public void setTxtCodNivel2(InputText txtCodNivel2) {
		this.txtCodNivel2 = txtCodNivel2;
	}

	public InputText getTxtCodContratista() {
		return txtCodContratista;
	}

	public void setTxtCodContratista(InputText txtCodContratista) {
		this.txtCodContratista = txtCodContratista;
	}

	public InputText getTxtCodUdadMed() {
		return txtCodUdadMed;
	}

	public void setTxtCodUdadMed(InputText txtCodUdadMed) {
		this.txtCodUdadMed = txtCodUdadMed;
	}

	public SelectOneMenu getTxtUdadMedIdRecurso() {
		return txtUdadMedIdRecurso;
	}

	public void setTxtUdadMedIdRecurso(SelectOneMenu txtUdadMedIdRecurso) {
		this.txtUdadMedIdRecurso = txtUdadMedIdRecurso;
	}

	public SelectOneMenu getTxtTpRecursoId_TipoRecurso() {
		return txtTpRecursoId_TipoRecurso;
	}

	public void setTxtTpRecursoId_TipoRecurso(SelectOneMenu txtTpRecursoId_TipoRecurso) {
		this.txtTpRecursoId_TipoRecurso = txtTpRecursoId_TipoRecurso;
	}

	public InputText getTxtNombreUmRecurso() {
		return txtNombreUmRecurso;
	}

	public void setTxtNombreUmRecurso(InputText txtNombreUmRecurso) {
		this.txtNombreUmRecurso = txtNombreUmRecurso;
	}

	public InputText getTxtNombreTipoRecurso() {
		return txtNombreTipoRecurso;
	}

	public void setTxtNombreTipoRecurso(InputText txtNombreTipoRecurso) {
		this.txtNombreTipoRecurso = txtNombreTipoRecurso;
	}

	public InputText getTxtRendimientoRecurso() {
		return txtRendimientoRecurso;
	}

	public void setTxtRendimientoRecurso(InputText txtRendimientoRecurso) {
		this.txtRendimientoRecurso = txtRendimientoRecurso;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public SelectOneMenu getTxtTrabajarConAreaPlantas() {
		return txtTrabajarConAreaPlantas;
	}

	public void setTxtTrabajarConAreaPlantas(SelectOneMenu txtTrabajarConAreaPlantas) {
		this.txtTrabajarConAreaPlantas = txtTrabajarConAreaPlantas;
	}

	public List<LaborRecursosDTO> getDataRecursosId() {

		if (dataLaborRecursos == null || dataLaborRecursos.size() == 0) {
			return null;
		} else {
			return dataLaborRecursos;
		}

	}
	public void action_agregarLaborRecurso() throws Exception {

		if (txtUdadMedIdRecurso.getValue() != null && txtRendimientoRecurso.getValue() != null
				&& txtTpRecursoId_TipoRecurso.getValue() != null && txtTrabajarConAreaPlantas.getValue() != null) {

			// Long tipoRecurso = Long.parseLong(txtTpRecursoId.getValue()
			// .toString());
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

			if (dataLaborRecursos == null) {
				dataLaborRecursos = new ArrayList<LaborRecursosDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataLaborRecursos.size() > 0) {

				for (LaborRecursosDTO d : dataLaborRecursos) {

					if (d.getTpRecursoId_TipoRecurso().getTpRecursoId() == tipoRecurso.longValue()
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

				LaborRecursosDTO laborRecursosDTO = new LaborRecursosDTO();
				laborRecursosDTO.setUdadMedId(udadMed);
				laborRecursosDTO.setNombreUm(nomUdadMed);
				laborRecursosDTO.setTpRecursoId_TipoRecurso(tipoRecursoId);
				laborRecursosDTO.setNombreTipoRecurso(nomTipoRecurso);
				// laborRecursosDTO.setTpRecursoId_TipoRecurso(tipoRecurso);
				laborRecursosDTO.setRecursoId(recurso);
				laborRecursosDTO.setNombreRecurso(nomRecurso);
				laborRecursosDTO.setRendimientoRecurso(rendimientoRecuro);

				dataLaborRecursos.add(laborRecursosDTO);

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

			selectedLaborRecursos = (LaborRecursosDTO) (evt.getComponent().getAttributes()
					.get("selectedLaborRecursos"));

			if (selectedLaborRecursos.getLaborRecursosId() == null) {
				dataLaborRecursos.remove(selectedLaborRecursos);
			} else {
				Long laborRecursoId = new Long(selectedLaborRecursos.getLaborRecursosId());
				LaborRecursos entity = businessDelegatorView.getLaborRecursos(laborRecursoId);
				businessDelegatorView.deleteLaborRecursos(entity);
				dataLaborRecursos.remove(selectedLaborRecursos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	public String actionDeleteCcontable(ActionEvent evt) {
		try {

			selectedLaborCcontable = (LaborCcontableDTO) (evt.getComponent().getAttributes()
					.get("selectedLaborCcontable"));

			if (selectedLaborCcontable.getCcontableId() == null) {
				dataLaborCcontable.remove(selectedLaborCcontable);
			} else {
				Long id = new Long(selectedLaborCcontable.getCcontableId().getCcontableId());
				LaborCcontable entity = businessDelegator2View.getLaborCcontable(id);
				businessDelegator2View.deleteLaborCcontable(entity);
				dataLaborCcontable.remove(selectedLaborCcontable);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectItem[] getSelectUdadMedIdRecurso() {

		if (udadMedRecurso == null || udadMedRecurso.size() == 0) {

			udadMedRecurso = new ArrayList<UdadMed>();

			try {

				udadMedRecurso = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
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

			tpRecurso = new ArrayList<TipoRecurso>();

			try {

				tpRecurso = businessDelegatorView.getTipoRecurso(); // Fin
				// by
				// Criteria
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

	/*
	 * 
	 * public void obtenerIdCiuda() { DecimalFormatSymbols simbolos = new
	 * DecimalFormatSymbols(); simbolos.setDecimalSeparator('.'); String pattern
	 * = "###.####"; DecimalFormat decimalFormat = new DecimalFormat(pattern,
	 * simbolos);
	 * 
	 * // Long compania = 1L; Long idCiudad =
	 * FacesUtils.checkLong(txtCiudadId_Ciudad);
	 * 
	 * if (idCiudad != null) {
	 * 
	 * try { valorCiudad = businessDelegatorView.consultarCiudadId(idCiudad);
	 * String format = decimalFormat.format(valorCiudad);
	 * txtCiudadId_Ciudad.setValue(format);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } else { valorCiudad =
	 * null;// pieModel1.set("Sin datos", 0L);
	 * txtCiudadId_Ciudad.setValue(valorCiudad);
	 * 
	 * }
	 */

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

	public SelectOneMenu getTxtRecursoId() {
		return txtRecursoId;
	}

	public void setTxtRecursoId(SelectOneMenu txtRecursoId) {
		this.txtRecursoId = txtRecursoId;
	}

	public InputText getTxtNombreRecurso() {
		return txtNombreRecurso;
	}

	public void setTxtNombreRecurso(InputText txtNombreRecurso) {
		this.txtNombreRecurso = txtNombreRecurso;
	}

	public CommandButton getBtnAgregarRecurso() {
		return btnAgregarRecurso;
	}

	public void setBtnAgregarRecurso(CommandButton btnAgregarRecurso) {
		this.btnAgregarRecurso = btnAgregarRecurso;
	}

	public InputText getTxtLaborRecursosId() {
		return txtLaborRecursosId;
	}

	public void setTxtLaborRecursosId(InputText txtLaborRecursosId) {
		this.txtLaborRecursosId = txtLaborRecursosId;
	}

	public List<LaborRecursosDTO> getDataLaborRecursos() {
		return dataLaborRecursos;
	}

	public void setDataLaborRecursos(List<LaborRecursosDTO> dataLaborRecursos) {
		this.dataLaborRecursos = dataLaborRecursos;
	}

	/**
	 * @return the txtRendimientoMax
	 */
	public InputText getTxtRendimientoMax() {
		return txtRendimientoMax;
	}

	/**
	 * @param txtRendimientoMax the txtRendimientoMax to set
	 */
	public void setTxtRendimientoMax(InputText txtRendimientoMax) {
		this.txtRendimientoMax = txtRendimientoMax;
	}

	public SelectOneMenu getTxtCuentaContable() {
		return txtCuentaContable;
	}

	public void setTxtCuentaContable(SelectOneMenu txtCuentaContable) {
		this.txtCuentaContable = txtCuentaContable;
	}
	


	public SelectItem[] getselectCuentaContable() {

		if (cuentaContable == null || cuentaContable.size() == 0) {

		 
			try {

				cuentaContable = businessDelegatorView.getCuentaContable(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CuentaContable> lista = businessDelegatorView.findByCriteriaInCuentaContable(condicion, null, null);
				selectCuentaContable = new SelectItem[lista.size()];

				int i = 0;
				for (CuentaContable cuentaContable : lista) {
					selectCuentaContable[i] = new SelectItem(cuentaContable.getCcontableId(), cuentaContable.getCodigo() +'-'+ cuentaContable.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCuentaContable;
	}

	public void setselectCuentaContable(SelectItem[] selectCuentaContable) {
		this.selectCuentaContable = selectCuentaContable;
	}

	public InputNumber getTxtPagoPorArea() {
		return txtPagoPorArea;
	}

	public void setTxtPagoPorArea(InputNumber txtPagoPorArea) {
		this.txtPagoPorArea = txtPagoPorArea;
	}

	public InputNumber getTxtTarifaEstandar() {
		return txtTarifaEstandar;
	}

	public void setTxtTarifaEstandar(InputNumber txtTarifaEstandar) {
		this.txtTarifaEstandar = txtTarifaEstandar;
	}

	public SelectOneMenu getTxtTipoParada() {
		return txtTipoParada;
	}

	public void setTxtTipoParada(SelectOneMenu txtTipoParada) {
		this.txtTipoParada = txtTipoParada;
	}

	
	public void onCellEditLabor(CellEditEvent event) throws Exception {
		Long laborId = FacesUtils.checkLong(txtLaborId);
		
		if (laborId != null) {
		selectedTarifaRendimiento = (TarifaLaborRendimientoDTO) (event.getComponent().getAttributes().get("selectedTarifaRendimiento"));
		
		
			Long laborTarifaId = selectedTarifaRendimiento.getTarifaLaborId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			
			TipoRecurso tipoRecurso = null;
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTarifa= null;
	
				entityTarifa = businessDelegatorView.getTarifaLaborRendimiento(laborTarifaId);
	
			/*	if (columnaCell.equals("Cant. Min")) {
	
					entityTarifa.setRendimiento((Double) newValue);
				}
				
				if (columnaCell.equals("Cant. Max")) {
					
					entityTarifa.setRendimientoMax((Double) newValue);
				}*/
	
				if (columnaCell.equals("Tarifa")) {
					
					entityTarifa.setTarifa((Double) newValue);
				}

				entity = businessDelegatorView.getLabor(laborId);
				entityTarifa.setLabor(entity);
				businessDelegatorView.updateTarifaLaborRendimiento(entityTarifa);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				
				entityTarifa = null;
				selectedTarifaRendimiento = null;
				dataTarifaRendimiento = null;
				dataTarifaRendimiento = businessDelegatorView.getDataRendimientoByTarifaRendimientoId(laborId);

				
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public TarifaLaborRendimiento getEntityTarifa() {
		return entityTarifa;
	}

	public void setEntityTarifa(TarifaLaborRendimiento entityTarifa) {
		this.entityTarifa = entityTarifa;
	}



	
	public void onCellEditCcontable(CellEditEvent event) throws Exception {
		Long laborId = FacesUtils.checkLong(txtLaborId);
		
		if (laborId != null) {
		selectedLaborCcontable = (LaborCcontableDTO) (event.getComponent().getAttributes().get("selectedLaborCcontable"));
		
		
			Long laborCcontableId = selectedLaborCcontable.getLaborCcontableId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			
			LaborCcontable laborCcontable  = null;
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityLaborCcontable= null;
	
				entityLaborCcontable = businessDelegator2View.getLaborCcontable(laborCcontableId);
	
				if (columnaCell.equals("Ccontable")) {
	
					
					Long ccontableId = new Long(event.getNewValue().toString());
					CuentaContable ccontable = businessDelegatorView.getCuentaContable(ccontableId);
	
					entityLaborCcontable.setCuentaContable(ccontable);
					
				}
				
				

				entity = businessDelegatorView.getLabor(laborId);
				entityLaborCcontable.setLabor(entity);
				businessDelegator2View.updateLaborCcontable(entityLaborCcontable);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				
				entityLaborCcontable = null;
				selectedLaborCcontable = null;
				dataLaborCcontable = null;
				dataLaborCcontable = businessDelegator2View.getDataLaborCcontableByLabor(laborId);

				
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	
	
	public List<LaborCcontableDTO> getDataLaborCcontableByLabor() {

		if (dataLaborCcontable == null || dataLaborCcontable.size() == 0) {
			return null;
		} else {
			return dataLaborCcontable;
		}

	}

	public void action_agregarLaborCcontable() throws NumberFormatException, Exception {
		if (txtCuentaContable2.getValue() != null ) {
		Long cuentaContableId2 = Long.parseLong(txtCuentaContable2.getValue().toString());
		CuentaContable cuentaContable2 = businessDelegatorView.getCuentaContable(cuentaContableId2);
		String nombreCuenta = cuentaContable2.getCodigo()+" "+cuentaContable2.getNombre();
		
		
				
		if (dataLaborCcontable == null) {
			dataLaborCcontable = new ArrayList<LaborCcontableDTO>();
		}

		LaborCcontableDTO laborCcontableDTO = new LaborCcontableDTO();
		laborCcontableDTO.setCcontableId(cuentaContable2);
		laborCcontableDTO.setNombreCuenta(nombreCuenta);
		
		dataLaborCcontable.add(laborCcontableDTO);
		cuentaContableId2 = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que el campo cuenta contable tenga valores. "));
		}
	}

	public SelectOneMenu getTxtCuentaContable2() {
		return txtCuentaContable2;
	}

	public void setTxtCuentaContable2(SelectOneMenu txtCuentaContable2) {
		this.txtCuentaContable2 = txtCuentaContable2;
	}

	public List<LaborCcontableDTO> getDataLaborCcontable() {
		return dataLaborCcontable;
	}

	public void setDataLaborCcontable(List<LaborCcontableDTO> dataLaborCcontable) {
		this.dataLaborCcontable = dataLaborCcontable;
	}

	public Labor getEntity() {
		return entity;
	}

	public void setEntity(Labor entity) {
		this.entity = entity;
	}

	public LaborCcontable getEntityLaborCcontable() {
		return entityLaborCcontable;
	}

	public void setEntityLaborCcontable(LaborCcontable entityLaborCcontable) {
		this.entityLaborCcontable = entityLaborCcontable;
	}
	
	public SelectItem[] getselectCuentaContable2() {

		if (cuentaContable2 == null || cuentaContable2.size() == 0) {

		 
			try {

				cuentaContable2 = businessDelegatorView.getCuentaContable(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CuentaContable> lista = businessDelegatorView.findByCriteriaInCuentaContable(condicion, null, null);
				selectCuentaContable2 = new SelectItem[lista.size()];

				int i = 0;
				for (CuentaContable cuentaContable2 : lista) {
					selectCuentaContable2[i] = new SelectItem(cuentaContable2.getCcontableId(), cuentaContable2.getCodigo() +'-'+ cuentaContable2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCuentaContable2;
	}

	public void setselectCuentaContable2(SelectItem[] selectCuentaContable2) {
		this.selectCuentaContable2 = selectCuentaContable2;
	}

	public CommandButton getBtnAgregarLaborCcontable() {
		return btnAgregarLaborCcontable;
	}

	public void setBtnAgregarLaborCcontable(CommandButton btnAgregarLaborCcontable) {
		this.btnAgregarLaborCcontable = btnAgregarLaborCcontable;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputNumber getTxtTarifaEstandar2() {
		return txtTarifaEstandar2;
	}

	public void setTxtTarifaEstandar2(InputNumber txtTarifaEstandar2) {
		this.txtTarifaEstandar2 = txtTarifaEstandar2;
	}

	public InputNumber getTxtTarifaEstandar3() {
		return txtTarifaEstandar3;
	}

	public void setTxtTarifaEstandar3(InputNumber txtTarifaEstandar3) {
		this.txtTarifaEstandar3 = txtTarifaEstandar3;
	}

	public InputNumber getTxtTarifaEstandar4() {
		return txtTarifaEstandar4;
	}

	public void setTxtTarifaEstandar4(InputNumber txtTarifaEstandar4) {
		this.txtTarifaEstandar4 = txtTarifaEstandar4;
	}

	public InputNumber getTxtTarifaEstandar5() {
		return txtTarifaEstandar5;
	}

	public void setTxtTarifaEstandar5(InputNumber txtTarifaEstandar5) {
		this.txtTarifaEstandar5 = txtTarifaEstandar5;
	}

	public InputNumber getTxtTarifaEstandar6() {
		return txtTarifaEstandar6;
	}

	public void setTxtTarifaEstandar6(InputNumber txtTarifaEstandar6) {
		this.txtTarifaEstandar6 = txtTarifaEstandar6;
	}

	public InputNumber getTxtTarifaEstandar7() {
		return txtTarifaEstandar7;
	}

	public void setTxtTarifaEstandar7(InputNumber txtTarifaEstandar7) {
		this.txtTarifaEstandar7 = txtTarifaEstandar7;
	}

	public InputNumber getTxtTarifaEstandar8() {
		return txtTarifaEstandar8;
	}

	public void setTxtTarifaEstandar8(InputNumber txtTarifaEstandar8) {
		this.txtTarifaEstandar8 = txtTarifaEstandar8;
	}

	public InputNumber getTxtTarifaEstandar9() {
		return txtTarifaEstandar9;
	}

	public void setTxtTarifaEstandar9(InputNumber txtTarifaEstandar9) {
		this.txtTarifaEstandar9 = txtTarifaEstandar9;
	}

	public InputNumber getTxtTarifaEstandar10() {
		return txtTarifaEstandar10;
	}

	public void setTxtTarifaEstandar10(InputNumber txtTarifaEstandar10) {
		this.txtTarifaEstandar10 = txtTarifaEstandar10;
	}

	
}
