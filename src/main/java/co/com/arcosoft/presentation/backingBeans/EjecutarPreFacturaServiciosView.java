package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
import javax.servlet.http.HttpServletRequest;

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
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.DatFacturaServicios;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaLaboresDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
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
public class EjecutarPreFacturaServiciosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EjecutarPreFacturaServiciosView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputTextarea txtDetalleFactura;
	private SelectOneRadio txtEstado;
	private SelectOneMenu txtFormaPago;
	private InputText txtNumFactura;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtPersEmprIdFormulario;
	SelectItem[] selectContratistaFormulario;
	private List<PersEmpr> contratistaFormulario;

	private SelectOneMenu txtPersEmprIdConsulta;
	SelectItem[] selectPersEmprIdConsulta;
	private List<PersEmpr> persIdConsulta;

	private Spinner txtPlazo;
	private Spinner txtRetencion;
	private InputText txtUsuarioDigitacion;

	private Spinner txtValorBaseIva;

	private Spinner txtValorFactura;
	private Spinner txtValorDescuento;
	private Spinner txtValorIva;

	private Spinner txtValorDescuentoCenicana;
	private Spinner txtValorReteIca;
	private Spinner txtValorRetencionContrato;

	private Spinner txtValorDescuentoTimbre;
	private Spinner txtValorReteIva; // retencion en la fuente.

	private InputText txtDatFacturaServiciosId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaRegistro;
	private Calendar txtFechaVencimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnSaveR;
	private List<DatFacturaServiciosDTO> data;
	private DatFacturaServiciosDTO selectedDatFacturaServicios;
	private DatFacturaServicios entity;
	private DatServRealizadosEquipoDet entityServiciosDet;

	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private InputText txtVlTotal;
	private InputText txtCantidad;
	private InputText txtHoras;

	private SelectOneMenu txtNumPrefactura;
	SelectItem[] selectNumPrefactura;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> numPrefactura;

	private List<ConsultaServiciosRealizadosMaquinariaDTO> dataClientePrefactura;
	String cadenaFactura = "";
	private int activeTapIndex = 0;
	private String cadenaPrefactura = "";

	private String disableButtonA = "false";
	private String disableButton1 = "false";
	private String disableNivel1 = "true";
	private String disableNivel2 = "true";

	private List<ConsultaServiciosRealizadosMaquinariaDTO> data2;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> dataPrefactura;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> selectedDatServRealizadosEquipo2;

	private ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo3;

	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	private List<String> selectedNivel1;
	private List<Nivel1> zonas;

	private List<String> selectedNivel2;
	private List<Nivel2> fincas;

	private List<String> selectedNivel3;
	private List<Nivel3> bloques;

	private List<String> selectedNivel4;
	private List<Nivel4> lotes;

	private List<String> selectedLabor;
	private List<ListaLaboresDTO> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private List<String> selectedPropietario;
	private List<PersEmpr> propietarios;

	private List<String> selectedModelo;
	private List<ModeloEquipo> modelos;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private StreamedContent file = null;
	private String disableButton = "true";

	private String disableDesPreFactura = "true";
	private StreamedContent filePreFactura = null;

	private String visible = "hidden";

	private List<String> selectedCliente;
	private List<PersEmpr> clientes;

	private List<String> selectedNivel2Clientesmq;
	private List<Nivel2Clientesmq> nivel2Clientesmq;

	private List<String> selectedNivel4Clientesmq;
	private List<ListaNivel4ClientesmqDTO> nivel4Clientesmq;

	private List<String> selectedOperador;
	private List<Trabajador> operadores;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private SelectOneMenu txtEstadoServicio;

	private InputText txtDatServRealizadosEquipoId;
	private InputText txtEstadoFactura;
	private InputText txtHorasTotal;
	private InputText txtHorometroFinal;
	private InputText txtHorometroInicial;
	private InputText txtHorometroTotal;
	private InputText txtIngresoTotal;
	private InputText txtNivel2Id;
	private InputText txtNivel4Id;
	private InputText txtNombreNivel4;
	private InputText txtUsuarioValidacion;
	private InputText txtValorUnitario;
	private InputText txtDatServRealizadosEquipoDetId;
	private Calendar txtFechaValidacion;
	private Calendar txtHoraFinal;
	private Calendar txtHoraInicial;
	private DatServRealizadosEquipoDetDTO selectedDatServRealizadosEquipoDet;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;
	private InputText txtNombreNivel4Maq;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;

	private InputText txtProducto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTrabId;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel2ClientesId;
	SelectItem[] selectNivel2ClientesId;
	private List<Nivel2Clientesmq> nivel2ClientesId;

	private SelectOneMenu txtNivel4ClientesId;
	SelectItem[] selectNivel4ClientesId;
	private List<Nivel4Clientesmq> nivel4ClientesId;

	private Spinner txtBonificacionTrabajador;

	private SelectOneMenu txtTurno;

	private SelectOneMenu txtConceptoNominaId;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private InputText txtPin;

	private SelectOneMenu txtNumPrefacturaRev;
	private SelectOneMenu txtPersEmprIdRev;
	private Long clienteId = null;
	private String prefactura = null;
	private CommandButton btnGenerarPreFactura;

	private InputText txtConsecutivoPrefactura;

	private SelectOneMenu txtNivelConsulta2ClientesId;
	SelectItem[] selectNivelConsulta2ClientesId;
	private List<Nivel2Clientesmq> nivel2CId;

	private SelectOneMenu txtNivelConsulta4ClientesId;
	SelectItem[] selectNivelConsulta4ClientesId;
	private List<Nivel4Clientesmq> nivel4CId;
	private Double txtValorTotalSeleccion = 0.0;
	private Double txtHorasSeleccion = 0.0;
	private Double txtCantidadSeleccion = 0.0;

	private List<ConsultaServiciosRealizadosMaquinariaDTO> data3;

	private DatServRealizadosEquipoDet entityDet;

	public EjecutarPreFacturaServiciosView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatFacturaServicios = null;
		setShowDialog(true);

		return "";
	}

	public String action_new2() {
		actionReversarPreFactura();
		selectedDatFacturaServicios = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatFacturaServicios = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(false);
		}

		if (txtPersEmprIdFormulario != null) {
			txtPersEmprIdFormulario.setValue(null);
			txtPersEmprIdFormulario.setDisabled(false);
		}

		if (txtDetalleFactura != null) {
			txtDetalleFactura.setValue(null);
			txtDetalleFactura.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtFormaPago != null) {
			txtFormaPago.setValue(null);
			txtFormaPago.setDisabled(false);
		}

		if (txtNumFactura != null) {
			txtNumFactura.setValue(null);
			txtNumFactura.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(false);
		}

		if (txtPlazo != null) {
			txtPlazo.setValue(null);
			txtPlazo.setDisabled(false);
		}

		if (txtRetencion != null) {
			txtRetencion.setValue(null);
			txtRetencion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtValorBaseIva != null) {
			txtValorBaseIva.setValue(null);
			txtValorBaseIva.setDisabled(false);
		}

		if (txtValorDescuento != null) {
			txtValorDescuento.setValue(null);
			txtValorDescuento.setDisabled(false);
		}

		if (txtValorDescuentoCenicana != null) {
			txtValorDescuentoCenicana.setValue(null);
			txtValorDescuentoCenicana.setDisabled(false);
		}

		if (txtValorDescuentoTimbre != null) {
			txtValorDescuentoTimbre.setValue(null);
			txtValorDescuentoTimbre.setDisabled(false);
		}

		if (txtValorFactura != null) {
			txtValorFactura.setValue(null);
			txtValorFactura.setDisabled(false);
		}

		if (txtValorIva != null) {
			txtValorIva.setValue(null);
			txtValorIva.setDisabled(false);
		}

		if (txtValorReteIca != null) {
			txtValorReteIca.setValue(null);
			txtValorReteIca.setDisabled(false);
		}

		if (txtValorReteIva != null) {
			txtValorReteIva.setValue(null);
			txtValorReteIva.setDisabled(false);
		}

		if (txtValorRetencionContrato != null) {
			txtValorRetencionContrato.setValue(null);
			txtValorRetencionContrato.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtFechaVencimiento != null) {
			txtFechaVencimiento.setValue(null);
			txtFechaVencimiento.setDisabled(false);
		}

		if (txtDatFacturaServiciosId != null) {
			txtDatFacturaServiciosId.setValue(null);
			txtDatFacturaServiciosId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	public void listener_txtFechaAnulacion() {
		Date inputDate = (Date) txtFechaAnulacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaVencimiento() {
		Date inputDate = (Date) txtFechaVencimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void consultaDatosFactura() {
		try {

			String numFactura = FacesUtils.checkString(txtNumFactura);
			Object[] condicion = { "numFactura", true, numFactura, "=" };
			List<DatFacturaServicios> lista = (numFactura != null)
					? businessDelegator2View.findByCriteriaInDatFacturaServicios(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage("Upps! El Número de factura  digitado no existe!" + numFactura);

		} catch (Exception e) {
			entity = null;
		}
		if (entity == null) {

		} else {
			txtFechaRegistro.setValue(entity.getFechaRegistro());
			txtFechaRegistro.setDisabled(false);
			if (entity.getPersEmprId() != null) {
				txtPersEmprId.setValue(entity.getPersEmprId().getPersEmprId());
				txtPersEmprId.setDisabled(false);
			}

			obtenerFactura();

		}
	}

	public void listener_limipiarPantalla() {
		try {

			// txtFechaRegistro.setValue(null);
			txtPersEmprId.setValue(null);
			txtNumPrefactura.setValue(null);

			txtPersEmprId.setDisabled(false);
			txtNumPrefactura.setDisabled(false);
			// txtPersEmprId.setDisabled(false);
			dataClientePrefactura = null;

		} catch (Exception e) {
		}

	}

	public String actionReversarPreFactura() {
		try {

			// RequestContext.getCurrentInstance().reset(":dialogReversarServicios :frm");
			Long numPreFactura = FacesUtils.checkLong(txtNumPrefacturaRev);
			Long clienteId2 = FacesUtils.checkLong(txtPersEmprIdRev);

			Long reversa = businessDelegator2View.pr_reversar_prefactura_servicio(clienteId2, numPreFactura);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "La prefactura fue reversada exitosamente"));

		} catch (Exception e) {
		}
		return "";

	}

	public void action_saveReversarServicios() {
		try {

			// RequestContext.getCurrentInstance().reset(":dialogReversarServicios :frm");
			Long numPreFactura = FacesUtils.checkLong(txtPersEmprId);
			Long clienteId2 = FacesUtils.checkLong(txtNumPrefactura);

			txtPersEmprIdRev.setValue(numPreFactura);
			txtNumPrefacturaRev.setValue(clienteId2);
			txtPersEmprIdRev.setDisabled(true);
			txtNumPrefacturaRev.setDisabled(true);
			setShowDialog(true);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "",
					"¿Esta seguro que desea reversar la pre-factura de servicios?"));

		} catch (Exception e) {
		}

	}

	public String action_save() {
		try {
			if ((selectedDatServRealizadosEquipo3 == null) && (entityServiciosDet == null)) {
				// action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create() {
		try {
			entity = new DatFacturaServicios();

			// Long datFacturaServiciosId = FacesUtils.checkLong(txtDatFacturaServiciosId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setFechaCreacion(date);
			entity.setConsecutivo(businessDelegator2View.consec_facturacion_servicios(compania));
//            entity.setDatFacturaServiciosId(datFacturaServiciosId);
			entity.setNumPrefactura(FacesUtils.checkLong(txtNumPrefactura));

			entity.setDetalleFactura(FacesUtils.checkString(txtDetalleFactura));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
			entity.setFormaPago(FacesUtils.checkString(txtFormaPago));
			entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setPersEmprId((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);

			entity.setPlazo(FacesUtils.checkLong(txtPlazo));
			entity.setRetencion(FacesUtils.checkDouble(txtRetencion));
			entity.setValorBaseIva(FacesUtils.checkDouble(txtValorBaseIva));
			entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
			entity.setValorDescuentoCenicana(FacesUtils.checkDouble(txtValorDescuentoCenicana));
			entity.setValorDescuentoTimbre(FacesUtils.checkDouble(txtValorDescuentoTimbre));
			entity.setValorFactura(FacesUtils.checkDouble(txtValorFactura));
			Double valor_factura = FacesUtils.checkDouble(txtValorFactura);
			entity.setValorIva(FacesUtils.checkDouble(txtValorIva));
			entity.setValorReteIca(FacesUtils.checkDouble(txtValorReteIca));
			entity.setValorReteIva(FacesUtils.checkDouble(txtValorReteIva));
			entity.setValorRetencionContrato(FacesUtils.checkDouble(txtValorRetencionContrato));

			String num_factura = FacesUtils.checkString(txtNumFactura);
			Object[] condicion = { "numFactura", true, num_factura, "=" };
			List<DatFacturaServicios> lista = (num_factura != null)
					? businessDelegator2View.findByCriteriaInDatFacturaServicios(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps! El Nùmero de factura digitado ya existe!, debe modificar el valor:. ",
								num_factura.toString()));

			} else {
				if (valor_factura > 0) {
					Long actualizar_dat_servDet = businessDelegator2View
							.actualizarNumFacturaEnDatServRDet(cadenaFactura, num_factura);
					businessDelegator2View.saveDatFacturaServicios(entity);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
					action_clear();
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upps! El valor de la factura tiene que ser mayor a 0: ", ""));

				}

			}
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entityServiciosDet == null) {
				Long datServRealizadosEquipoDetId = new Long(
						selectedDatServRealizadosEquipo3.getIdRegistro().longValue());
				entityServiciosDet = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entityServiciosDet.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entityServiciosDet.setConsecutivoPrefactura(FacesUtils.checkLong(txtConsecutivoPrefactura));
			if (txtConsecutivoPrefactura.getValue() != null) {

				Long consecutivoF = FacesUtils.checkLong(txtConsecutivoPrefactura);
				if (consecutivoF > 0) {
					entityServiciosDet.setEstadoFactura("pre-facturado");
				} else {
					entityServiciosDet.setEstadoFactura("Sin facturar");
				}

			}
			/*
			 * entityServiciosDet.setPersEmpr((FacesUtils.checkLong(txtPersEmprIdFormulario)
			 * != null) ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
			 * txtPersEmprIdFormulario)) : null);
			 */
			entityServiciosDet.setNivel4ClientesId((FacesUtils.checkLong(txtNivel4ClientesId) != null)
					? businessDelegator2View.getNivel4Clientesmq(FacesUtils.checkLong(txtNivel4ClientesId))
					: null);
			/*
			 * entityServiciosDet.setNivel2ClientesId((FacesUtils.checkLong(
			 * txtNivel2ClientesId) != null) ?
			 * businessDelegatorView.getNivel2Clientesmq(FacesUtils.checkLong(
			 * txtNivel2ClientesId)) : null);
			 */

			entityServiciosDet.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));

			Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			if (valorUnit != null && cantidad != null) {

				entityServiciosDet.setIngresoTotal(valorUnit * cantidad);
			}
	

			/*
			 * entityServiciosDet.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
			 * ? businessDelegatorView.getLabor(FacesUtils.checkLong( txtLaborId_Labor)) :
			 * null);
			 * entityServiciosDet.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) !=
			 * null) ? businessDelegatorView.getUdadMed(FacesUtils.checkLong(
			 * txtUdadMedId_UdadMed)) : null);
			 */
			businessDelegatorView.updateDatServRealizadosEquipoDet(entityServiciosDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			prefacturarServicios();

			// action_clear();
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatFacturaServicios"));

			Long datFacturaServiciosId = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId());
			entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datFacturaServiciosId = FacesUtils.checkLong(txtDatFacturaServiciosId);
			entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatFacturaServicios(entity);
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
			selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatFacturaServicios"));

			Long datFacturaServiciosId = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId());
			entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
			businessDelegator2View.deleteDatFacturaServicios(entity);
			data.remove(selectedDatFacturaServicios);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datFacturaServiciosId,
			String detalleFactura, String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaRegistro,
			Date fechaVencimiento, String formaPago, String numFactura, String observacion, String observacionAnularReg,
			Long persEmprId, Long plazo, Double retencion, Long usuarioDigitacion, Double valorBaseIva,
			Double valorDescuento, Double valorDescuentoCenicana, Double valorDescuentoTimbre, Double valorFactura,
			Double valorIva, Double valorReteIca, Double valorReteIva, Double valorRetencionContrato) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDetalleFactura(FacesUtils.checkString(detalleFactura));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setFormaPago(FacesUtils.checkString(formaPago));
			entity.setNumFactura(FacesUtils.checkString(numFactura));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPersEmprId((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);

			entity.setPlazo(FacesUtils.checkLong(plazo));
			entity.setRetencion(FacesUtils.checkDouble(retencion));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorBaseIva(FacesUtils.checkDouble(valorBaseIva));
			entity.setValorDescuento(FacesUtils.checkDouble(valorDescuento));
			entity.setValorDescuentoCenicana(FacesUtils.checkDouble(valorDescuentoCenicana));
			entity.setValorDescuentoTimbre(FacesUtils.checkDouble(valorDescuentoTimbre));
			entity.setValorFactura(FacesUtils.checkDouble(valorFactura));
			entity.setValorIva(FacesUtils.checkDouble(valorIva));
			entity.setValorReteIca(FacesUtils.checkDouble(valorReteIca));
			entity.setValorReteIva(FacesUtils.checkDouble(valorReteIva));
			entity.setValorRetencionContrato(FacesUtils.checkDouble(valorRetencionContrato));
			businessDelegator2View.updateDatFacturaServicios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ReversaFacturaServiciosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public Calendar getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public InputText getTxtDatFacturaServiciosId() {
		return txtDatFacturaServiciosId;
	}

	public void setTxtDatFacturaServiciosId(InputText txtDatFacturaServiciosId) {
		this.txtDatFacturaServiciosId = txtDatFacturaServiciosId;
	}

	public List<DatFacturaServiciosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatFacturaServicios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatFacturaServiciosDTO> datFacturaServiciosDTO) {
		this.data = datFacturaServiciosDTO;
	}

	public DatFacturaServiciosDTO getSelectedDatFacturaServicios() {
		return selectedDatFacturaServicios;
	}

	public void setSelectedDatFacturaServicios(DatFacturaServiciosDTO datFacturaServicios) {
		this.selectedDatFacturaServicios = datFacturaServicios;
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

	public InputTextarea getTxtDetalleFactura() {
		return txtDetalleFactura;
	}

	public void setTxtDetalleFactura(InputTextarea txtDetalleFactura) {
		this.txtDetalleFactura = txtDetalleFactura;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneMenu getTxtFormaPago() {
		return txtFormaPago;
	}

	public void setTxtFormaPago(SelectOneMenu txtFormaPago) {
		this.txtFormaPago = txtFormaPago;
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

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public Spinner getTxtPlazo() {
		return txtPlazo;
	}

	public void setTxtPlazo(Spinner txtPlazo) {
		this.txtPlazo = txtPlazo;
	}

	public Spinner getTxtRetencion() {
		return txtRetencion;
	}

	public void setTxtRetencion(Spinner txtRetencion) {
		this.txtRetencion = txtRetencion;
	}

	public SelectOneMenu getTxtNumPrefactura() {
		return txtNumPrefactura;
	}

	public void setTxtNumPrefactura(SelectOneMenu txtNumPrefactura) {
		this.txtNumPrefactura = txtNumPrefactura;
	}

	public Spinner getTxtValorBaseIva() {
		return txtValorBaseIva;
	}

	public void setTxtValorBaseIva(Spinner txtValorBaseIva) {
		this.txtValorBaseIva = txtValorBaseIva;
	}

	public Spinner getTxtValorDescuento() {
		return txtValorDescuento;
	}

	public void setTxtValorDescuento(Spinner txtValorDescuento) {
		this.txtValorDescuento = txtValorDescuento;
	}

	public Spinner getTxtValorDescuentoCenicana() {
		return txtValorDescuentoCenicana;
	}

	public void setTxtValorDescuentoCenicana(Spinner txtValorDescuentoCenicana) {
		this.txtValorDescuentoCenicana = txtValorDescuentoCenicana;
	}

	public Spinner getTxtValorDescuentoTimbre() {
		return txtValorDescuentoTimbre;
	}

	public void setTxtValorDescuentoTimbre(Spinner txtValorDescuentoTimbre) {
		this.txtValorDescuentoTimbre = txtValorDescuentoTimbre;
	}

	public Spinner getTxtValorFactura() {
		return txtValorFactura;
	}

	public void setTxtValorFactura(Spinner txtValorFactura) {
		this.txtValorFactura = txtValorFactura;
	}

	public Spinner getTxtValorIva() {
		return txtValorIva;
	}

	public void setTxtValorIva(Spinner txtValorIva) {
		this.txtValorIva = txtValorIva;
	}

	public Spinner getTxtValorReteIca() {
		return txtValorReteIca;
	}

	public void setTxtValorReteIca(Spinner txtValorReteIca) {
		this.txtValorReteIca = txtValorReteIca;
	}

	public Spinner getTxtValorReteIva() {
		return txtValorReteIva;
	}

	public void setTxtValorReteIva(Spinner txtValorReteIva) {
		this.txtValorReteIva = txtValorReteIva;
	}

	public Spinner getTxtValorRetencionContrato() {
		return txtValorRetencionContrato;
	}

	public void setTxtValorRetencionContrato(Spinner txtValorRetencionContrato) {
		this.txtValorRetencionContrato = txtValorRetencionContrato;
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

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId().longValue());
				entity = businessDelegator2View.getDatFacturaServicios(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			String numFact = FacesUtils.checkString(txtNumFactura);
			businessDelegator2View.anularNumFacturaEnDatServRDet("0", numFact);

			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			businessDelegator2View.updateDatFacturaServicios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) throws Exception {

		action_clear();
		selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatFacturaServicios"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atras. Por favor, estar seguro."));
		return "";

	}

	public SelectItem[] getSelectPersEmprIdConsulta() {

		if (persIdConsulta == null || persIdConsulta.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectPersEmprIdConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectPersEmprIdConsulta[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPersEmprIdConsulta;
	}

	public void setSelectPersEmprIdConsulta(SelectItem[] selectPersEmprIdConsulta) {
		this.selectPersEmprIdConsulta = selectPersEmprIdConsulta;
	}

	public SelectItem[] getSelectContratista() {

		if (contratista == null || contratista.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
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

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectItem[] getSelectContratistaFormulario() {

		if (contratistaFormulario == null || contratistaFormulario.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratistaFormulario = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratistaFormulario : lista) {
					selectContratistaFormulario[i] = new SelectItem(contratistaFormulario.getPersEmprId(),
							contratistaFormulario.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratistaFormulario;
	}

	public void setSelectContratistaFormulario(SelectItem[] selectContratistaFormulario) {
		this.selectContratistaFormulario = selectContratistaFormulario;
	}

	/*** Consulta de prefacturas de prefactura por clientes ***/

	public SelectItem[] getSelectNumPrefactura() {
		if (txtPersEmprId.getValue() != null) {
			if (!txtPersEmprId.getValue().equals("")) {
				if (numPrefactura == null || numPrefactura.size() == 0) {
					try {
						Long clienteId = FacesUtils.checkLong(txtPersEmprId);

						// Criteria
						List<ConsultaServiciosRealizadosMaquinariaDTO> lista = businessDelegator2View
								.pr_consulta_prefacturas_por_cliente(clienteId);
						if (lista != null && lista.size() > 0) {
							selectNumPrefactura = new SelectItem[lista.size()];
							int i = 0;
							for (ConsultaServiciosRealizadosMaquinariaDTO consulta : lista) {
								selectNumPrefactura[i] = new SelectItem(consulta.getConsecutivoPrefactura(),
										consulta.getConsecutivoPrefactura().toString());
								i++;

							}

						}

					} catch (Exception e) {
						FacesUtils.addErrorMessage(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return selectNumPrefactura;

	}

	public void setSelectNumPrefactura(SelectItem[] selectNumPrefactura) {
		this.selectNumPrefactura = selectNumPrefactura;
	}

	public void consultaPrefactura() {
		try {

			// Long compania = 1L;
			clienteId = FacesUtils.checkLong(txtPersEmprId);
			prefactura = FacesUtils.checkString(txtNumPrefactura);
			String cadena = "";

			double valorTotal = 0;
			double horas = 0;
			double cantidad = 0;

			if (prefactura != null && clienteId != null) {
				dataClientePrefactura = businessDelegator2View.pr_cargar_serv_prefact_cliente(clienteId, prefactura);
				if (dataClientePrefactura != null) {
					for (ConsultaServiciosRealizadosMaquinariaDTO data1 : dataClientePrefactura) {
						valorTotal += data1.getCostoTotal().doubleValue();
						cantidad += data1.getCantidadPago().doubleValue();
						horas += data1.getHoras().doubleValue();
						cadena += "," + data1.getIdRegistro().toString();

					}

				}

				txtValorFactura.setValue(valorTotal);

				cadenaFactura = "0" + cadena;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public InputText getTxtVlTotal() {
		return txtVlTotal;
	}

	public void setTxtVlTotal(InputText txtVlTotal) {
		this.txtVlTotal = txtVlTotal;
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public InputText getTxtHoras() {
		return txtHoras;
	}

	public void setTxtHoras(InputText txtHoras) {
		this.txtHoras = txtHoras;
	}

	public void setDataClientePrefactura(List<ConsultaServiciosRealizadosMaquinariaDTO> dataClientePrefactura) {
		this.dataClientePrefactura = dataClientePrefactura;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public void obtenerFactura() {
		try {

			// Long compania = 1L;
			String numFactura = FacesUtils.checkString(txtNumFactura);
			double valorTotal = 0;
			double horas = 0;
			double cantidad = 0;

			if (numFactura != null) {
				data2 = businessDelegator2View.pr_consulta_factura_serv_consolidada_detal(numFactura);

				if (data2 != null) {
					for (ConsultaServiciosRealizadosMaquinariaDTO data21 : data2) {
						valorTotal += data21.getCostoTotal().doubleValue();
						cantidad += data21.getCantidadPago().doubleValue();
						horas += data21.getHoras().doubleValue();
					}
				}
			}

			txtVlTotal.setValue(valorTotal);
			// txtCantidad.setValue(horas);
			// txtHoras.setValue(cantidad);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void action_calcularunidades() throws Exception {
		Double cadena = 0.0;
		Long flagZona = 1L;

		double cantidad = 0;
		double valorTotal = 0.0;
		
		long initialTime = System.currentTimeMillis();
		
		if (selectedDatServRealizadosEquipo2 != null && selectedDatServRealizadosEquipo2.size() > 0) {

			flagZona = 0L;
			
			//long time =0;
				
			
			/*
			
			System.out.println("Procesado for.. " + " ->Tiempo: (Sg) " + time/1000);*/

			int x = selectedDatServRealizadosEquipo2.size();

			Thread hilo = new TaskFacturar(x);
			hilo.run();



		}

		//txtCantidadSeleccion = (double) Math.round(cantidad * 100) / 100;
		//txtValorTotalSeleccion = (double) Math.round(valorTotal * 100) / 100;

	}

	class TaskFacturar extends Thread {
		
		private int contador=0;
		private double cantidad = 0;
		private double valorTotal = 0.0;
		long initialTime = System.currentTimeMillis();
		
		public TaskFacturar(int contador) {
			this.contador = contador;
		}
			
		@Override
		public void run() {

			for (int a = 0; a < selectedDatServRealizadosEquipo2.size(); a++) {
				ConsultaServiciosRealizadosMaquinariaDTO datos  = selectedDatServRealizadosEquipo2.get(a);
				cantidad += datos.getCantidadPago().doubleValue();
				valorTotal += datos.getCostoTotal().doubleValue();
			}
			
			txtCantidadSeleccion = (double) Math.round(cantidad * 100) / 100;
			txtValorTotalSeleccion = (double) Math.round(valorTotal * 100) / 100;

		}
	}

	public void action_valoresSeleccionados() throws Exception {
		Long compania = new Long(getCompaniaIdSession());
		String cadena = "";
		Long flagZona = 1L;
		Long usuarioId = new Long(getUsuarioIdSession());
		Long idDetalle  = null;
		ConsultaServiciosRealizadosMaquinariaDTO zonasSeleccionadas = null;
		Long resultado =  businessDelegator2View.actualizarConsecPrefacturaCompania(compania);
		Compania companiaEnt = businessDelegatorView.getCompania(compania);
		Long numPrefactura = companiaEnt.getConsecutivoPrefactura();
		
		if (selectedDatServRealizadosEquipo2 != null && selectedDatServRealizadosEquipo2.size() > 0) {
		
				for (int a = 0; a < selectedDatServRealizadosEquipo2.size(); a++) {
					ConsultaServiciosRealizadosMaquinariaDTO datos  = selectedDatServRealizadosEquipo2.get(a);
					idDetalle = datos.getIdRegistro().longValue();
					
					DatServRealizadosEquipoDet entityDet = businessDelegatorView.getDatServRealizadosEquipoDet(idDetalle);
					if(entityDet!=null) {
						entityDet.setConsecutivoPrefactura(numPrefactura);
						entityDet.setEstadoFactura("pre-facturado");
						entityDet.setFechaPrefactura(new Date());
						entityDet.setUsuarioPrefactura(usuarioId);
						cadena += "," + idDetalle.toString();
						businessDelegatorView.updateDatServRealizadosEquipoDet(entityDet);
					}
				}
			}
		
				cadenaPrefactura = "0" + cadena;
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se han actualizado las ordenes con éxito "));

				disableButtonA = "true";
				reportePrefactura();
				cadenaPrefactura = null;
				cadena = null;
				prefacturarServiciosConsulta();
					
	}
		

	public void reportePrefactura() {
		Date fechaInicial = new Date();
		Date fechaFinal = new Date();

		if (cadenaPrefactura != null && !cadenaPrefactura.equals("")) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRPrefactura.xlsx";

				data3 = businessDelegator2View.pr_reporte_serv_prefacturados(cadenaPrefactura);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
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

					if (data3 != null) {

						cell = row.createCell(0);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("DIRECCION_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("TELEFONO_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data3) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell.setCellStyle(style);
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getNomFinca());
							cell.setCellStyle(style);
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getNomLabor());
							cell.setCellStyle(style);
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell.setCellStyle(style);
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getCodLote());
							cell.setCellStyle(style);
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell.setCellStyle(style);
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getNomCliente());
							cell.setCellStyle(style);
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getCod_operario());
							cell.setCellStyle(style);
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getNom_implemento());
							cell.setCellStyle(style);

							cell = row.createCell(14);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);
							cell.setCellStyle(style);

							cell = row.createCell(15);
							cell.setCellValue(fechaF);
							cell.setCellStyle(style);

							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getDocFactura());
							cell.setCellStyle(style);
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell.setCellStyle(style);
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getConsecutivoPrefactura().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getDireccionCliente());
							cell.setCellStyle(style);
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getTelefonoCliente());
							cell.setCellStyle(style);
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getCodCliente());
							cell.setCellStyle(style);

							pos_i++;

						}

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						filePreFactura = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoSRPrefactura.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"El informe se ha generado con exito, ahora puedes Descargar el informe"));

					} else {

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
								"No existe informacion asociada a los criterios de busqueda seleccionados "));
					}

				} catch (Exception e) {

					e.printStackTrace();

					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		visible = "visible";
		disableDesPreFactura = "false";

	}

	public String getDisableButtonA() {
		return disableButtonA;
	}

	public void setDisableButtonA(String disableButtonA) {
		this.disableButtonA = disableButtonA;
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

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getSelectedDatServRealizadosEquipo2() {

		return selectedDatServRealizadosEquipo2;
	}

	public void setSelectedDatServRealizadosEquipo2(
			List<ConsultaServiciosRealizadosMaquinariaDTO> selectedDatServRealizadosEquipo2) {
		this.selectedDatServRealizadosEquipo2 = selectedDatServRealizadosEquipo2;
	}

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public String getDisableDesPreFactura() {
		return disableDesPreFactura;
	}

	public void setDisableDesPreFactura(String disableDesPreFactura) {
		this.disableDesPreFactura = disableDesPreFactura;
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

	public SelectOneMenu getTxtEstadoServicio() {
		return txtEstadoServicio;
	}

	public void setTxtEstadoServicio(SelectOneMenu txtEstadoServicio) {
		this.txtEstadoServicio = txtEstadoServicio;
	}

	public void setData2(List<ConsultaServiciosRealizadosMaquinariaDTO> data2) {
		this.data2 = data2;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData2() {
		return data2;
	}

	public String action_edit(ActionEvent evt) {
		selectedDatServRealizadosEquipo3 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo3"));
		try {

			Long idRegistro = selectedDatServRealizadosEquipo3.getIdRegistro().longValue();
			Object[] condicion = { "datServRealizadosEquipoDetId", true, idRegistro, "=" };
			List<DatServRealizadosEquipoDet> lista = (idRegistro != null)
					? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entityServiciosDet = lista.get(0);
				if (entityServiciosDet.getConsecutivoPrefactura() != null) {
					txtConsecutivoPrefactura.setValue(entityServiciosDet.getConsecutivoPrefactura());
				} else {
					txtConsecutivoPrefactura.setValue(0);
				}
				txtConsecutivoPrefactura.setDisabled(false);

				txtCantidad.setValue(entityServiciosDet.getCantidad());
				txtCantidad.setDisabled(false);

				// txtIngresoTotal.setValue(entityServiciosDet.getIngresoTotal());
				// txtIngresoTotal.setDisabled(false);
				txtNivel2ClientesId.setValue(entityServiciosDet.getNivel2ClientesId().getNivel2ClientesmqId());
				txtNivel2ClientesId.setDisabled(true);
				if (entityServiciosDet.getNivel4ClientesId() != null) {
					txtNivel4ClientesId.setValue(entityServiciosDet.getNivel4ClientesId().getNivel4ClientesmqId());
				}
				txtNivel4ClientesId.setDisabled(false);
				txtPersEmprIdFormulario.setValue(entityServiciosDet.getPersEmpr().getPersEmprId());
				txtPersEmprIdFormulario.setDisabled(true);
				txtValorUnitario.setValue(entityServiciosDet.getValorUnitario());
				txtValorUnitario.setDisabled(false);
				txtLaborId_Labor.setValue(entityServiciosDet.getLabor().getLaborId());
				txtLaborId_Labor.setDisabled(true);
				txtUdadMedId_UdadMed.setValue(entityServiciosDet.getUdadMed().getUdadMedId());
				txtUdadMedId_UdadMed.setDisabled(true);
				txtDatServRealizadosEquipoDetId.setValue(entityServiciosDet.getDatServRealizadosEquipoDetId());
				txtDatServRealizadosEquipoDetId.setDisabled(true);
				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entityServiciosDet = null;
		}

		return "";
	}

	public DatFacturaServicios getEntity() {
		return entity;
	}

	public void setEntity(DatFacturaServicios entity) {
		this.entity = entity;
	}

	public DatServRealizadosEquipoDet getEntityServiciosDet() {
		return entityServiciosDet;
	}

	public void setEntityServiciosDet(DatServRealizadosEquipoDet entityServiciosDet) {
		this.entityServiciosDet = entityServiciosDet;
	}

	public SelectOneMenu getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(SelectOneMenu txtCultivoId_Cultivo) {
		this.txtCultivoId_Cultivo = txtCultivoId_Cultivo;
	}

	public InputText getTxtDatServRealizadosEquipoId() {
		return txtDatServRealizadosEquipoId;
	}

	public void setTxtDatServRealizadosEquipoId(InputText txtDatServRealizadosEquipoId) {
		this.txtDatServRealizadosEquipoId = txtDatServRealizadosEquipoId;
	}

	public InputText getTxtEstadoFactura() {
		return txtEstadoFactura;
	}

	public void setTxtEstadoFactura(InputText txtEstadoFactura) {
		this.txtEstadoFactura = txtEstadoFactura;
	}

	public InputText getTxtHorasTotal() {
		return txtHorasTotal;
	}

	public void setTxtHorasTotal(InputText txtHorasTotal) {
		this.txtHorasTotal = txtHorasTotal;
	}

	public InputText getTxtHorometroFinal() {
		return txtHorometroFinal;
	}

	public void setTxtHorometroFinal(InputText txtHorometroFinal) {
		this.txtHorometroFinal = txtHorometroFinal;
	}

	public InputText getTxtHorometroInicial() {
		return txtHorometroInicial;
	}

	public void setTxtHorometroInicial(InputText txtHorometroInicial) {
		this.txtHorometroInicial = txtHorometroInicial;
	}

	public InputText getTxtHorometroTotal() {
		return txtHorometroTotal;
	}

	public void setTxtHorometroTotal(InputText txtHorometroTotal) {
		this.txtHorometroTotal = txtHorometroTotal;
	}

	public InputText getTxtIngresoTotal() {
		return txtIngresoTotal;
	}

	public void setTxtIngresoTotal(InputText txtIngresoTotal) {
		this.txtIngresoTotal = txtIngresoTotal;
	}

	public InputText getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(InputText txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public InputText getTxtNivel4Id() {
		return txtNivel4Id;
	}

	public void setTxtNivel4Id(InputText txtNivel4Id) {
		this.txtNivel4Id = txtNivel4Id;
	}

	public InputText getTxtNombreNivel4() {
		return txtNombreNivel4;
	}

	public void setTxtNombreNivel4(InputText txtNombreNivel4) {
		this.txtNombreNivel4 = txtNombreNivel4;
	}

	public InputText getTxtUsuarioValidacion() {
		return txtUsuarioValidacion;
	}

	public void setTxtUsuarioValidacion(InputText txtUsuarioValidacion) {
		this.txtUsuarioValidacion = txtUsuarioValidacion;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputText getTxtDatServRealizadosEquipoDetId() {
		return txtDatServRealizadosEquipoDetId;
	}

	public void setTxtDatServRealizadosEquipoDetId(InputText txtDatServRealizadosEquipoDetId) {
		this.txtDatServRealizadosEquipoDetId = txtDatServRealizadosEquipoDetId;
	}

	public Calendar getTxtFechaValidacion() {
		return txtFechaValidacion;
	}

	public void setTxtFechaValidacion(Calendar txtFechaValidacion) {
		this.txtFechaValidacion = txtFechaValidacion;
	}

	public Calendar getTxtHoraFinal() {
		return txtHoraFinal;
	}

	public void setTxtHoraFinal(Calendar txtHoraFinal) {
		this.txtHoraFinal = txtHoraFinal;
	}

	public Calendar getTxtHoraInicial() {
		return txtHoraInicial;
	}

	public void setTxtHoraInicial(Calendar txtHoraInicial) {
		this.txtHoraInicial = txtHoraInicial;
	}

	public DatServRealizadosEquipoDetDTO getSelectedDatServRealizadosEquipoDet() {
		return selectedDatServRealizadosEquipoDet;
	}

	public void setSelectedDatServRealizadosEquipoDet(
			DatServRealizadosEquipoDetDTO selectedDatServRealizadosEquipoDet) {
		this.selectedDatServRealizadosEquipoDet = selectedDatServRealizadosEquipoDet;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public InputText getTxtNombreNivel4Maq() {
		return txtNombreNivel4Maq;
	}

	public void setTxtNombreNivel4Maq(InputText txtNombreNivel4Maq) {
		this.txtNombreNivel4Maq = txtNombreNivel4Maq;
	}

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	public InputText getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(InputText txtProducto) {
		this.txtProducto = txtProducto;
	}

	public SelectOneMenu getTxtTrabId() {
		return txtTrabId;
	}

	public void setTxtTrabId(SelectOneMenu txtTrabId) {
		this.txtTrabId = txtTrabId;
	}

	public SelectOneMenu getTxtNivel2ClientesId() {
		return txtNivel2ClientesId;
	}

	public void setTxtNivel2ClientesId(SelectOneMenu txtNivel2ClientesId) {
		this.txtNivel2ClientesId = txtNivel2ClientesId;
	}

	public SelectOneMenu getTxtNivel4ClientesId() {
		return txtNivel4ClientesId;
	}

	public void setTxtNivel4ClientesId(SelectOneMenu txtNivel4ClientesId) {
		this.txtNivel4ClientesId = txtNivel4ClientesId;
	}

	public Spinner getTxtBonificacionTrabajador() {
		return txtBonificacionTrabajador;
	}

	public void setTxtBonificacionTrabajador(Spinner txtBonificacionTrabajador) {
		this.txtBonificacionTrabajador = txtBonificacionTrabajador;
	}

	public SelectOneMenu getTxtTurno() {
		return txtTurno;
	}

	public void setTxtTurno(SelectOneMenu txtTurno) {
		this.txtTurno = txtTurno;
	}

	public SelectOneMenu getTxtConceptoNominaId() {
		return txtConceptoNominaId;
	}

	public void setTxtConceptoNominaId(SelectOneMenu txtConceptoNominaId) {
		this.txtConceptoNominaId = txtConceptoNominaId;
	}

	public InputText getTxtPin() {
		return txtPin;
	}

	public void setTxtPin(InputText txtPin) {
		this.txtPin = txtPin;
	}

	public SelectItem[] getselectNivel4ClientesId() {

		if (nivel4ClientesId == null || nivel4ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				String nivel2ClientesId = null;

				if (txtNivel2ClientesId != null && txtNivel2ClientesId.getValue() != null) {
					nivel2ClientesId = txtNivel2ClientesId.getValue().toString();

					// Criteria
					List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq = businessDelegator2View
							.listaNivel4Clientesmq(idCompania, nivel2ClientesId);

					selectNivel4ClientesId = new SelectItem[listaNivel4Clientesmq.size()];
					int i = 0;
					for (ListaNivel4ClientesmqDTO listaNivel4ClientesmqDto : listaNivel4Clientesmq) {
						selectNivel4ClientesId[i] = new SelectItem(listaNivel4ClientesmqDto.getId(),
								listaNivel4ClientesmqDto.getLote());
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ClientesId;
	}

	public void setselectNivel4ClientesId(SelectItem[] selectNivel4ClientesId) {
		this.selectNivel4ClientesId = selectNivel4ClientesId;
	}

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

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

	public void listener_calcularIngresoTotal() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
		Double cantidad = FacesUtils.checkDouble(txtCantidad);
		Double result = 0.0;
		if (valorUnitario != null && cantidad != null) {
			result = (valorUnitario * cantidad);
			String format = decimalFormat.format(result);
			txtIngresoTotal.setValue(format);
		} else {
			result = 0.0;
			txtIngresoTotal.setValue(result);
		}

	}

	public void listener_calcularCantidad() throws Exception {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Long udadMedId_UdadMed = null;
		UdadMed udadMed = null;
		if (txtUdadMedId_UdadMed.getValue() != null) {
			udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			String tipoUm = udadMed.getClasificacionUm();
			Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinal);
			Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicial);
			Double result = 0.0;

			if (tipoUm != null) {
				if (tipoUm.equals("HR")) {
					if (horometroFinal != null && horometroInicial != null) {
						result = (horometroFinal - horometroInicial);
						String format = decimalFormat.format(result);
						txtCantidad.setValue(format);
					} else {
						result = 0.0;
						txtCantidad.setValue(result);
					}

				} else {
					result = 0.0;
					txtCantidad.setValue(result);
				}
			} else {
				result = 0.0;
				txtCantidad.setValue(result);
			}

		}
	}

	public void listener_ConsultaNombreLaborMaq() {
		Long laborId = null;
		if (!txtLaborId_Labor.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				// txtNombreLaborMaq.setValue(labor.getNombre());
				txtUdadMedId_UdadMed.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public SelectItem[] getselectNivel2ClientesId() {

		if (nivel2ClientesId == null || nivel2ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprIdFormulario != null && txtPersEmprIdFormulario.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprIdFormulario.getValue().toString());

					// Criteria
					List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
							.listaNivel2Clientesmq(idCompania, persEmprId);

					selectNivel2ClientesId = new SelectItem[listaNivel2Clientesmq.size()];
					int i = 0;
					for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
						selectNivel2ClientesId[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
								listaNivel2ClientesmqDto.getHacienda());
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2ClientesId;
	}

	public void setselectNivel2ClientesId(SelectItem[] selectNivel2ClientesId) {
		this.selectNivel2ClientesId = selectNivel2ClientesId;
	}

	public void ConsultarTarifaPagoMaquinaria() throws Exception {
		// Long compania = 1L;

		Long idCompania = new Long(getCompaniaIdSession());
		Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedId_UdadMed);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));
		Long idCliente = FacesUtils.checkLong(txtPersEmprIdFormulario);
		Long idLabor = FacesUtils.checkLong(txtLaborId_Labor);

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		if (idUdadMed != null) {
			try {

				BigDecimal tarifaPagoMaquina = businessDelegatorView.consultarTarifaContratista(idCompania, idCliente,
						idLabor, 0L, idUdadMed, idFecha, 0.0, "0", 0L, 0L, "0");

				String format = decimalFormat.format(tarifaPagoMaquina);
				txtValorUnitario.setValue(format);
				if (tarifaPagoMaquina == null) {
					BigDecimal tarifaMaquinariaNoEncontrada = new BigDecimal("0");
					txtValorUnitario.setValue(tarifaMaquinariaNoEncontrada);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
		}
	}

	public SelectOneMenu getTxtPersEmprIdFormulario() {
		return txtPersEmprIdFormulario;
	}

	public void setTxtPersEmprIdFormulario(SelectOneMenu txtPersEmprIdFormulario) {
		this.txtPersEmprIdFormulario = txtPersEmprIdFormulario;
	}

	public String action_actualizarServPrefacturados() {
		try {

			if (entityServiciosDet == null) {
				Long id = new Long(selectedDatServRealizadosEquipo3.getIdRegistro().longValue());
				entityServiciosDet = businessDelegatorView.getDatServRealizadosEquipoDet(id);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entityServiciosDet.setCantidad(FacesUtils.checkDouble(txtCantidad));

			entityServiciosDet.setNivel4ClientesId((FacesUtils.checkLong(txtNivel4ClientesId) != null)
					? businessDelegator2View.getNivel4Clientesmq(FacesUtils.checkLong(txtNivel4ClientesId))
					: null);

			entityServiciosDet.setNivel2ClientesId((FacesUtils.checkLong(txtNivel2ClientesId) != null)
					? businessDelegator2View.getNivel2Clientesmq(FacesUtils.checkLong(txtNivel2ClientesId))
					: null);

			entityServiciosDet.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));

			Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			if (valorUnit != null && cantidad != null) {

				entityServiciosDet.setIngresoTotal(valorUnit * cantidad);
			}

			entityServiciosDet.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entityServiciosDet.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);

			businessDelegatorView.updateDatServRealizadosEquipoDet(entityServiciosDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectOneMenu getTxtNumPrefacturaRev() {
		return txtNumPrefacturaRev;
	}

	public void setTxtNumPrefacturaRev(SelectOneMenu txtNumPrefacturaRev) {
		this.txtNumPrefacturaRev = txtNumPrefacturaRev;
	}

	public SelectOneMenu getTxtPersEmprIdRev() {
		return txtPersEmprIdRev;
	}

	public void setTxtPersEmprIdRev(SelectOneMenu txtPersEmprIdRev) {
		this.txtPersEmprIdRev = txtPersEmprIdRev;
	}

	public CommandButton getBtnSaveR() {
		return btnSaveR;
	}

	public void setBtnSaveR(CommandButton btnSaveR) {
		this.btnSaveR = btnSaveR;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(String prefactura) {
		this.prefactura = prefactura;
	}

	public void getDescargarPrefactura() {

		// Long compania = 1L;
		Long compania = FacesUtils.checkLong(txtCompania);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = new Date();
		Date fechaFinal = new Date();
		// fechaInicial = new D
		// fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		Long clienteId = FacesUtils.checkLong(txtPersEmprId);
		String prefacturaId = FacesUtils.checkString(txtNumPrefactura);

		if (clienteId != null && prefacturaId != null) {
			try {

				List<ConsultaServiciosRealizadosMaquinariaDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoSRPrefactura.xlsx";
				data3 = businessDelegator2View.pr_cargar_serv_prefact_cliente(clienteId, prefacturaId);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
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

					if (data3 != null) {

						cell = row.createCell(0);
						cell.setCellValue("ANIO REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("COD EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("NOM EQUIPO");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM FINCA");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("NOM LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("CANTIDAD PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("COD UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("NOM UDAD MED PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("HORAS");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("NOM LOTE");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FECHA REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("HORA INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("HORA FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("HOROMETRO INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("HOROMETRO FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM PRODUCTO");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("CANTIDAD GALONES");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("COD UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("NOM UDAD MED INS");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("COSTO COMBUSTIBLE");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("HORAS EQUIPO DIA");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("INGRESO TOTAL");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("COD CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("NOM CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SELLO");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("TURNO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("COD OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(31);
						cell.setCellValue("NOM OPERARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(32);
						cell.setCellValue("COD CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(33);
						cell.setCellValue("NOM CONCEPTO NOMINA");
						cell.setCellStyle(style2);
						cell = row.createCell(34);
						cell.setCellValue("BONIFICACION TRABAJADOR");
						cell.setCellStyle(style2);
						cell = row.createCell(35);
						cell.setCellValue("COD IMPLEMENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(36);
						cell.setCellValue("NOM IMPLEMENTO");
						cell.setCellStyle(style2);

						cell = row.createCell(37);
						cell.setCellValue("P. INICIAL");
						cell.setCellStyle(style2);
						cell = row.createCell(38);
						cell.setCellValue("P. FINAL");
						cell.setCellStyle(style2);
						cell = row.createCell(39);
						cell.setCellValue("DOC. FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(40);
						cell.setCellValue("COD. LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(41);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(42);
						cell.setCellValue("ID REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(43);
						cell.setCellValue("ESTATUS REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(44);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(45);
						cell.setCellValue("DIRECCION_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(46);
						cell.setCellValue("TELEFONO_CLIENTE");
						cell.setCellStyle(style2);

						int pos_i = 8;

						for (ConsultaServiciosRealizadosMaquinariaDTO ndDTO : data3) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell.setCellStyle(style);
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getNomEquipo());
							cell.setCellStyle(style);
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCodFinca());
							cell.setCellStyle(style);
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNomFinca());
							cell.setCellStyle(style);
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getNomLabor());
							cell.setCellStyle(style);
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getCantidadPago().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell.setCellStyle(style);
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell.setCellStyle(style);
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getHoras().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getCodLote());
							cell.setCellStyle(style);
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getFechaRegistro().toString().substring(8, 10) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(5, 7) + "/"
									+ ndDTO.getFechaRegistro().toString().substring(0, 4));

							cell.setCellStyle(style);
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getHoraInicial());
							cell.setCellStyle(style);
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getHoraFinal());
							cell.setCellStyle(style);
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getHorometroInicial().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getHorometroFinal().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodProducto());
							cell.setCellStyle(style);
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomProducto());
							cell.setCellStyle(style);
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCantGalones().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getCodUdadMedIns());
							cell.setCellStyle(style);
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getNomUdadMedIns());
							cell.setCellStyle(style);
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getCostoCombustible().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getHorasEquipoDia().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getCostoTotal().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getCodCliente());
							cell.setCellStyle(style);
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getNomCliente());
							cell.setCellStyle(style);
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSello().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getTurno());
							cell.setCellStyle(style);
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getCod_operario());
							cell.setCellStyle(style);
							cell = row.createCell(31);
							cell.setCellValue(ndDTO.getNom_operario());
							cell.setCellStyle(style);
							cell = row.createCell(32);
							cell.setCellValue(ndDTO.getCod_concepto_nomina());
							cell.setCellStyle(style);
							cell = row.createCell(33);
							cell.setCellValue(ndDTO.getNom_concepto_nomina());
							cell.setCellStyle(style);
							cell = row.createCell(34);
							cell.setCellValue(ndDTO.getBonificacion_trabajador().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(35);
							cell.setCellValue(ndDTO.getCod_implemento());
							cell.setCellStyle(style);
							cell = row.createCell(36);
							cell.setCellValue(ndDTO.getNom_implemento());
							cell.setCellStyle(style);

							cell = row.createCell(37);
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String fechaI = dateFormat.format(fechaInicial);
							String fechaF = dateFormat.format(fechaFinal);
							cell.setCellValue(fechaI);
							cell.setCellStyle(style);

							cell = row.createCell(38);
							cell.setCellValue(fechaF);
							cell.setCellStyle(style);

							cell = row.createCell(39);
							cell.setCellValue(ndDTO.getDocFactura());
							cell.setCellStyle(style);
							cell = row.createCell(40);
							cell.setCellValue(ndDTO.getCodLabor());
							cell.setCellStyle(style);
							cell = row.createCell(41);
							cell.setCellValue(ndDTO.getPin().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(42);
							cell.setCellValue(ndDTO.getIdRegistro().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(43);
							cell.setCellValue(ndDTO.getEstatusRegistro());
							cell.setCellStyle(style);
							cell = row.createCell(44);
							cell.setCellValue(ndDTO.getConsecutivoPrefactura().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(45);
							cell.setCellValue(ndDTO.getDireccionCliente());
							cell.setCellStyle(style);
							cell = row.createCell(46);
							cell.setCellValue(ndDTO.getTelefonoCliente());
							cell.setCellStyle(style);

							pos_i++;

						}

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						filePreFactura = new DefaultStreamedContent(stream, "application/xlsx",
								"MttoSRPrefactura.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"El informe se ha generado con exito, ahora puedes Descargar el informe"));

					} else {

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
								"No existe informacion asociada a los criterios de busqueda seleccionados "));
					}

				} catch (Exception e) {

					e.printStackTrace();

					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		visible = "visible";
		disableDesPreFactura = "false";

	}

	public void setData3(List<ConsultaServiciosRealizadosMaquinariaDTO> data3) {
		this.data3 = data3;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public StreamedContent getFilePreFactura() {
		return filePreFactura;
	}

	public void setFilePreFactura(StreamedContent filePreFactura) {
		this.filePreFactura = filePreFactura;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public CommandButton getBtnGenerarPreFactura() {
		return btnGenerarPreFactura;
	}

	public void setBtnGenerarPreFactura(CommandButton btnGenerarPreFactura) {
		this.btnGenerarPreFactura = btnGenerarPreFactura;
	}

	public InputText getTxtConsecutivoPrefactura() {
		return txtConsecutivoPrefactura;
	}

	public void setTxtConsecutivoPrefactura(InputText txtConsecutivoPrefactura) {
		this.txtConsecutivoPrefactura = txtConsecutivoPrefactura;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getDataClientePrefactura() {
		return dataClientePrefactura;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData3() {
		return data3;
	}

	public void prefacturarServiciosConsulta() {
		try {

			Long compania = new Long(getCompaniaIdSession());
			// Long compania = 1L;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			String estadoServicio = FacesUtils.checkString(txtEstadoServicio);
			String clienteId = FacesUtils.checkString(txtPersEmprIdConsulta);
			String haciendaId = "0";
			Long flagHacienda = 1L;

			String suerteId = "0";
			Long flagSuerte = 1L;

			/*
			 * if(txtNivelConsulta2ClientesId.getValue()!=null) { haciendaId =
			 * FacesUtils.checkString(txtNivelConsulta2ClientesId); flagHacienda =0L; }
			 * 
			 * if(txtNivelConsulta4ClientesId.getValue()!=null) { suerteId =
			 * FacesUtils.checkString(txtNivelConsulta4ClientesId); flagSuerte =0L; }
			 */
			Long flagNivel2Clientesmq = 1L;
			String nivel2ClientesmqSeleccionadas = "";
			if (selectedNivel2Clientesmq != null && selectedNivel2Clientesmq.size() > 0) {
				nivel2ClientesmqSeleccionadas = selectedNivel2Clientesmq.get(0);
				flagNivel2Clientesmq = 0L;
				for (int i = 1; i < selectedNivel2Clientesmq.size(); i++) {
					nivel2ClientesmqSeleccionadas += "," + selectedNivel2Clientesmq.get(i);
				}
			}

			Long flagNivel4Clientesmq = 1L;
			String nivel4ClientesmqSeleccionadas = "";
			if (selectedNivel4Clientesmq != null && selectedNivel4Clientesmq.size() > 0) {
				nivel4ClientesmqSeleccionadas = selectedNivel4Clientesmq.get(0);
				flagNivel4Clientesmq = 0L;
				for (int i = 1; i < selectedNivel4Clientesmq.size(); i++) {
					nivel4ClientesmqSeleccionadas += "," + selectedNivel4Clientesmq.get(i);
				}
			}

			Long flagGrupoLabor = 1L;
			String grupoLaboresSeleccionadas = "";
			if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
				grupoLaboresSeleccionadas = selectedGrupoLabor.get(0);
				flagGrupoLabor = 0L;
				for (int i = 1; i < selectedGrupoLabor.size(); i++) {
					grupoLaboresSeleccionadas += "," + selectedGrupoLabor.get(i);
				}
			}

			if (compania != null && fechaInicial != null && fechaFinal != null && clienteId != null) {

				Long flagLabor = 1L;

				Long flagClientes = 1L;

				String laboresSeleccionadas = "";
				if (selectedLabor != null && selectedLabor.size() > 0) {
					laboresSeleccionadas = selectedLabor.get(0);
					flagLabor = 0L;
					for (int i = 1; i < selectedLabor.size(); i++) {
						laboresSeleccionadas += "," + selectedLabor.get(i);
					}
				}

				double valorTotal = 0;
				double horas = 0;
				double cantidad = 0;
				dataPrefactura = businessDelegator2View.pr_consulta_servrea_det(compania, estadoServicio, fechaInicial,
						fechaFinal, clienteId, 0L, nivel2ClientesmqSeleccionadas, flagNivel2Clientesmq,
						laboresSeleccionadas, flagLabor, nivel4ClientesmqSeleccionadas, flagNivel4Clientesmq, 0L,
						grupoLaboresSeleccionadas, flagGrupoLabor);			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public void prefacturarServicios() {
		try {

			Long compania = new Long(getCompaniaIdSession());
			// Long compania = 1L;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			String estadoServicio = FacesUtils.checkString(txtEstadoServicio);
			String clienteId = FacesUtils.checkString(txtPersEmprIdConsulta);
			String haciendaId = "0";
			Long flagHacienda = 1L;

			String suerteId = "0";
			Long flagSuerte = 1L;

			/*
			 * if(txtNivelConsulta2ClientesId.getValue()!=null) { haciendaId =
			 * FacesUtils.checkString(txtNivelConsulta2ClientesId); flagHacienda =0L; }
			 * 
			 * if(txtNivelConsulta4ClientesId.getValue()!=null) { suerteId =
			 * FacesUtils.checkString(txtNivelConsulta4ClientesId); flagSuerte =0L; }
			 */
			Long flagNivel2Clientesmq = 1L;
			String nivel2ClientesmqSeleccionadas = "";
			if (selectedNivel2Clientesmq != null && selectedNivel2Clientesmq.size() > 0) {
				nivel2ClientesmqSeleccionadas = selectedNivel2Clientesmq.get(0);
				flagNivel2Clientesmq = 0L;
				for (int i = 1; i < selectedNivel2Clientesmq.size(); i++) {
					nivel2ClientesmqSeleccionadas += "," + selectedNivel2Clientesmq.get(i);
				}
			}

			Long flagNivel4Clientesmq = 1L;
			String nivel4ClientesmqSeleccionadas = "";
			if (selectedNivel4Clientesmq != null && selectedNivel4Clientesmq.size() > 0) {
				nivel4ClientesmqSeleccionadas = selectedNivel4Clientesmq.get(0);
				flagNivel4Clientesmq = 0L;
				for (int i = 1; i < selectedNivel4Clientesmq.size(); i++) {
					nivel4ClientesmqSeleccionadas += "," + selectedNivel4Clientesmq.get(i);
				}
			}

			Long flagGrupoLabor = 1L;
			String grupoLaboresSeleccionadas = "";
			if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
				grupoLaboresSeleccionadas = selectedGrupoLabor.get(0);
				flagGrupoLabor = 0L;
				for (int i = 1; i < selectedGrupoLabor.size(); i++) {
					grupoLaboresSeleccionadas += "," + selectedGrupoLabor.get(i);
				}
			}

			if (compania != null && fechaInicial != null && fechaFinal != null && clienteId != null) {

				Long flagLabor = 1L;

				Long flagClientes = 1L;

				String laboresSeleccionadas = "";
				if (selectedLabor != null && selectedLabor.size() > 0) {
					laboresSeleccionadas = selectedLabor.get(0);
					flagLabor = 0L;
					for (int i = 1; i < selectedLabor.size(); i++) {
						laboresSeleccionadas += "," + selectedLabor.get(i);
					}
				}

				/*dataPrefactura = businessDelegator2View.pr_consulta_servrea_det(compania, estadoServicio, fechaInicial,
						fechaFinal, clienteId, 0L, nivel2ClientesmqSeleccionadas, flagNivel2Clientesmq,
						laboresSeleccionadas, flagLabor, nivel4ClientesmqSeleccionadas, flagNivel4Clientesmq, 0L,
						grupoLaboresSeleccionadas, flagGrupoLabor);*/
				
				Thread hilo = new ListarServiciosPrefactura(compania, estadoServicio, fechaInicial,
						fechaFinal, clienteId, 0L, nivel2ClientesmqSeleccionadas, flagNivel2Clientesmq,
						laboresSeleccionadas, flagLabor, nivel4ClientesmqSeleccionadas, flagNivel4Clientesmq, 0L,
						grupoLaboresSeleccionadas, flagGrupoLabor);
				
				hilo.run();


			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	class ListarServiciosPrefactura extends Thread {
		
		//@Override
		//@ManagedProperty(value = "#{BusinessDelegator2View}")
		//private IBusinessDelegator2View businessDelegator2View;
		
		private int contador=0;
		private double cantidad = 0;
		private double valorTotal = 0.0;
		long initialTime = System.currentTimeMillis();
		private Long compania; 
		private String estadoServicio;
		private Date fechaInicial; 
		private Date fechaFinal; 
		private String cliente;
		private Long flagCliente; 
		private String nivel2ClientesmqSeleccionadas; 
		private Long flagNivel2Clientesmq;
		private String laboresSeleccionadas;
		private Long flagLabor;
		private String nivel4ClientesmqSeleccionadas; 
		private Long flagNivel4Clientesmq;
		private Long pinId; 
		private String grupoLaboresSeleccionadas; 
		private Long flagGrupoLabor ;
		
		
		
		public ListarServiciosPrefactura(Long compania, String estadoServicio,
				Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String nivel2ClientesmqSeleccionadas, Long flagNivel2Clientesmq,
				String laboresSeleccionadas, Long flagLabor, String nivel4ClientesmqSeleccionadas, Long flagNivel4Clientesmq, Long pinId,
				String grupoLaboresSeleccionadas, Long flagGrupoLabor ) {
			this.compania = compania;
			this.estadoServicio = estadoServicio;
			this.fechaInicial = fechaInicial;
			this.fechaFinal = fechaFinal;
			this.cliente = cliente;
			this.flagCliente = flagCliente;
			this.nivel2ClientesmqSeleccionadas = nivel2ClientesmqSeleccionadas;
			this.flagNivel2Clientesmq = flagNivel2Clientesmq;
			this.nivel4ClientesmqSeleccionadas = nivel4ClientesmqSeleccionadas;
			this.flagNivel4Clientesmq = flagNivel4Clientesmq;
			this.laboresSeleccionadas = laboresSeleccionadas;
			this.flagLabor = flagLabor;
			this.pinId = pinId;
			this.grupoLaboresSeleccionadas = grupoLaboresSeleccionadas;
			this.flagGrupoLabor = flagGrupoLabor;
			
		}
			
		@Override
		public void run() {
            
			//esperarXsegundos(1);
			
			try {
				
				dataPrefactura = new ArrayList<ConsultaServiciosRealizadosMaquinariaDTO>();
				
				dataPrefactura = businessDelegator2View.pr_consulta_servrea_det(compania, estadoServicio, fechaInicial,
						fechaFinal, cliente, 0L, nivel2ClientesmqSeleccionadas, flagNivel2Clientesmq,
						laboresSeleccionadas, flagLabor, nivel4ClientesmqSeleccionadas, flagNivel4Clientesmq, 0L,
						grupoLaboresSeleccionadas, flagGrupoLabor);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		
		
		

		public int getContador() {
			return contador;
		}

		public void setContador(int contador) {
			this.contador = contador;
		}

		public long getInitialTime() {
			return initialTime;
		}

		public void setInitialTime(long initialTime) {
			this.initialTime = initialTime;
		}

		public Long getCompania() {
			return compania;
		}

		public void setCompania(Long compania) {
			this.compania = compania;
		}

		public String getEstadoServicio() {
			return estadoServicio;
		}

		public void setEstadoServicio(String estadoServicio) {
			this.estadoServicio = estadoServicio;
		}

		public Date getFechaInicial() {
			return fechaInicial;
		}

		public void setFechaInicial(Date fechaInicial) {
			this.fechaInicial = fechaInicial;
		}

		public Date getFechaFinal() {
			return fechaFinal;
		}

		public void setFechaFinal(Date fechaFinal) {
			this.fechaFinal = fechaFinal;
		}

		public String getCliente() {
			return cliente;
		}

		public void setCliente(String cliente) {
			this.cliente = cliente;
		}

		public Long getFlagCliente() {
			return flagCliente;
		}

		public void setFlagCliente(Long flagCliente) {
			this.flagCliente = flagCliente;
		}

		public String getNivel2ClientesmqSeleccionadas() {
			return nivel2ClientesmqSeleccionadas;
		}

		public void setNivel2ClientesmqSeleccionadas(String nivel2ClientesmqSeleccionadas) {
			this.nivel2ClientesmqSeleccionadas = nivel2ClientesmqSeleccionadas;
		}

		public Long getFlagNivel2Clientesmq() {
			return flagNivel2Clientesmq;
		}

		public void setFlagNivel2Clientesmq(Long flagNivel2Clientesmq) {
			this.flagNivel2Clientesmq = flagNivel2Clientesmq;
		}

		public String getLaboresSeleccionadas() {
			return laboresSeleccionadas;
		}

		public void setLaboresSeleccionadas(String laboresSeleccionadas) {
			this.laboresSeleccionadas = laboresSeleccionadas;
		}

		public Long getFlagLabor() {
			return flagLabor;
		}

		public void setFlagLabor(Long flagLabor) {
			this.flagLabor = flagLabor;
		}

		public String getNivel4ClientesmqSeleccionadas() {
			return nivel4ClientesmqSeleccionadas;
		}

		public void setNivel4ClientesmqSeleccionadas(String nivel4ClientesmqSeleccionadas) {
			this.nivel4ClientesmqSeleccionadas = nivel4ClientesmqSeleccionadas;
		}

		public Long getFlagNivel4Clientesmq() {
			return flagNivel4Clientesmq;
		}

		public void setFlagNivel4Clientesmq(Long flagNivel4Clientesmq) {
			this.flagNivel4Clientesmq = flagNivel4Clientesmq;
		}

		public Long getPinId() {
			return pinId;
		}

		public void setPinId(Long pinId) {
			this.pinId = pinId;
		}

		public String getGrupoLaboresSeleccionadas() {
			return grupoLaboresSeleccionadas;
		}

		public void setGrupoLaboresSeleccionadas(String grupoLaboresSeleccionadas) {
			this.grupoLaboresSeleccionadas = grupoLaboresSeleccionadas;
		}

		public Long getFlagGrupoLabor() {
			return flagGrupoLabor;
		}

		public void setFlagGrupoLabor(Long flagGrupoLabor) {
			this.flagGrupoLabor = flagGrupoLabor;
		}

		/*public IBusinessDelegator2View getBusinessDelegator2View() {
			return businessDelegator2View;
		}

		public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
			this.businessDelegator2View = businessDelegator2View;
		}
		*/
		
	}

	public void onCellEditEventosServicios(CellEditEvent evt) throws Exception {

		// caso 1 : la tabla transaccional no tiene valores

		selectedDatServRealizadosEquipo3 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo3"));

		Long datServRealizadosEquipoDetId = selectedDatServRealizadosEquipo3.getIdRegistro().longValue();

		String columnaCell = evt.getColumn().getHeaderText();

		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityDet = null;
			entityDet = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);

			Long idPrograma = 0L;

			if (columnaCell.equals("Cant.")) {

				entityDet.setCantidad(Double.valueOf(evt.getNewValue().toString()));
				Double cantidad = Double.valueOf(evt.getNewValue().toString());
				Double tarifa = entityDet.getValorUnitario();
				if (entityDet.getDat_plan_servicios_mqdet_id() != null) {
					idPrograma = entityDet.getDat_plan_servicios_mqdet_id().getDatPlanServiciosMqdetId();
				}

				Double ingresoTotal = cantidad * tarifa;
				entityDet.setIngresoTotal(ingresoTotal);

				Double valorUnitarioTrabajador = entityDet.getValor_unitario_trabajador();
				Double valorTotalTrabajador = cantidad * valorUnitarioTrabajador;

				entityDet.setValor_total_trabajador(valorTotalTrabajador);

			}

			if (columnaCell.equals("VR. Unitario")) {

				entityDet.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));
				Double tarifa = Double.valueOf(evt.getNewValue().toString());
				Double cantidad = entityDet.getCantidad();

				Double ingresoTotal = cantidad * tarifa;
				entityDet.setIngresoTotal(ingresoTotal);

			}

			if (columnaCell.equals("VR. Total")) {

				entityDet.setIngresoTotal(Double.valueOf(evt.getNewValue().toString()));

			}

			businessDelegatorView.updateDatServRealizadosEquipoDet(entityDet);

			if (entityDet.getLabor() != null) {
				Long laborId = entityDet.getLabor().getLaborId();
				Labor labor = businessDelegatorView.getLabor(laborId);
				if (labor.getClaseLabor() != null) {
					if (!labor.getClaseLabor().equals("Transporte")) {
						businessDelegator2View.pr_actualizar_prog_maquinaria(idPrograma);
					}
				}
			}

		}

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getDataPrefactura() {
		return dataPrefactura;
	}

	public void setDataPrefactura(List<ConsultaServiciosRealizadosMaquinariaDTO> dataPrefactura) {
		this.dataPrefactura = dataPrefactura;
	}

	public SelectItem[] getSelectNivelConsulta2ClientesId() {

		if (nivel2CId == null || nivel2CId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprIdConsulta != null && txtPersEmprIdConsulta.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprIdConsulta.getValue().toString());

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

	public SelectItem[] getSelectNivelConsulta4ClientesId() throws NumberFormatException, Exception {

		if (txtNivelConsulta2ClientesId != null && txtNivelConsulta2ClientesId.getValue() != null) {
			Long idCompania = new Long(getCompaniaIdSession());
			String nivel2ClientesId = null;

			nivel2ClientesId = txtNivelConsulta2ClientesId.getValue().toString();
			try {
				// Criteria
				List<ListaNivel4ClientesmqDTO> listaNivelConsulta4Clientesmq = businessDelegator2View
						.listaNivel4Clientesmq(idCompania, nivel2ClientesId);

				selectNivelConsulta4ClientesId = new SelectItem[listaNivelConsulta4Clientesmq.size()];
				int i = 0;
				for (ListaNivel4ClientesmqDTO listaNivelConsulta4ClientesmqDto : listaNivelConsulta4Clientesmq) {
					selectNivelConsulta4ClientesId[i] = new SelectItem(listaNivelConsulta4ClientesmqDto.getId(),
							listaNivelConsulta4ClientesmqDto.getLote());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivelConsulta4ClientesId;
	}

	public void setSelectNivelConsulta4ClientesId(SelectItem[] selectNivelConsulta4ClientesId) {
		this.selectNivelConsulta4ClientesId = selectNivelConsulta4ClientesId;
	}

	public SelectOneMenu getTxtNivelConsulta2ClientesId() {
		return txtNivelConsulta2ClientesId;
	}

	public void setTxtNivelConsulta2ClientesId(SelectOneMenu txtNivelConsulta2ClientesId) {
		this.txtNivelConsulta2ClientesId = txtNivelConsulta2ClientesId;
	}

	public SelectOneMenu getTxtNivelConsulta4ClientesId() {
		return txtNivelConsulta4ClientesId;
	}

	public void setTxtNivelConsulta4ClientesId(SelectOneMenu txtNivelConsulta4ClientesId) {
		this.txtNivelConsulta4ClientesId = txtNivelConsulta4ClientesId;
	}

	public SelectOneMenu getTxtPersEmprIdConsulta() {
		return txtPersEmprIdConsulta;
	}

	public void setTxtPersEmprIdConsulta(SelectOneMenu txtPersEmprIdConsulta) {
		this.txtPersEmprIdConsulta = txtPersEmprIdConsulta;
	}

	public List<String> getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(List<String> selectedLabor) {
		this.selectedLabor = selectedLabor;
	}

	public List<ListaLaboresDTO> getLabores() {
		try {
			Long idCompania = new Long(getCompaniaIdSession());
			String cadena = "";
		
			if (txtPersEmprIdConsulta != null && txtPersEmprIdConsulta.getValue() != null) {
				if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
					cadena = selectedGrupoLabor.get(0);
					
					for (int i = 1; i < selectedGrupoLabor.size(); i++) {
						cadena += "," + selectedGrupoLabor.get(i);
					}
					labores = businessDelegator2View.pr_lista_labores(idCompania, cadena);
			}
			}

			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return labores;
	}

	public void setLabores(List<ListaLaboresDTO> labores) {
		this.labores = labores;
	}

	public Double getTxtValorTotalSeleccion() {
		return txtValorTotalSeleccion;
	}

	public void setTxtValorTotalSeleccion(Double txtValorTotalSeleccion) {
		this.txtValorTotalSeleccion = txtValorTotalSeleccion;
	}

	public Double getTxtHorasSeleccion() {
		return txtHorasSeleccion;
	}

	public void setTxtHorasSeleccion(Double txtHorasSeleccion) {
		this.txtHorasSeleccion = txtHorasSeleccion;
	}

	public Double getTxtCantidadSeleccion() {
		return txtCantidadSeleccion;
	}

	public void setTxtCantidadSeleccion(Double txtCantidadSeleccion) {
		this.txtCantidadSeleccion = txtCantidadSeleccion;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public DatServRealizadosEquipoDet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatServRealizadosEquipoDet entityDet) {
		this.entityDet = entityDet;
	}

	public List<String> getSelectedGrupoLabor() {
		return selectedGrupoLabor;
	}

	public void setSelectedGrupoLabor(List<String> selectedGrupoLabor) {
		this.selectedGrupoLabor = selectedGrupoLabor;
	}

	public List<GrpLabor> getGrupoLabores() {

		try {
			if (txtPersEmprIdConsulta != null && txtPersEmprIdConsulta.getValue() != null) {
				grupoLabores = businessDelegatorView.getGrpLabor();
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return grupoLabores;
	}

	public void setGrupoLabores(List<GrpLabor> grupoLabores) {
		this.grupoLabores = grupoLabores;
	}

	public List<String> getSelectedNivel2Clientesmq() {
		return selectedNivel2Clientesmq;
	}

	public void setSelectedNivel2Clientesmq(List<String> selectedNivel2Clientesmq) {
		this.selectedNivel2Clientesmq = selectedNivel2Clientesmq;
	}

	public List<Nivel2Clientesmq> getNivel2Clientesmq() throws NumberFormatException, Exception {

		Long persEmprId = null;
		try {

			if (txtPersEmprIdConsulta != null && txtPersEmprIdConsulta.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmprIdConsulta.getValue().toString());
				Object[] condicion = { "estado", true, "A", "=", "persEmpr.persEmprId", true, persEmprId, "=" };
				nivel2Clientesmq = businessDelegator2View.findByCriteriaInNivel2Clientesmq(condicion, null, null);

			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return nivel2Clientesmq;
	}

	public void setNivel2Clientesmq(List<Nivel2Clientesmq> nivel2Clientesmq) {
		this.nivel2Clientesmq = nivel2Clientesmq;
	}

	public List<String> getSelectedNivel4Clientesmq() {
		return selectedNivel4Clientesmq;
	}

	public void setSelectedNivel4Clientesmq(List<String> selectedNivel4Clientesmq) {
		this.selectedNivel4Clientesmq = selectedNivel4Clientesmq;
	}

	public List<ListaNivel4ClientesmqDTO> getNivel4Clientesmq() throws NumberFormatException, Exception {
		Long idCompania = new Long(getCompaniaIdSession());
		String cadena = "";
		String cadenaFinal = "";

		try {
			if (txtPersEmprIdConsulta != null && txtPersEmprIdConsulta.getValue() != null) {
			
				if (selectedNivel2Clientesmq != null && selectedNivel2Clientesmq.size() > 0) {
					cadena = selectedNivel2Clientesmq.get(0);
					
					for (int i = 1; i < selectedNivel2Clientesmq.size(); i++) {
						cadena += "," + selectedNivel2Clientesmq.get(i);
					}
					nivel4Clientesmq = businessDelegator2View.listaNivel4Clientesmq(idCompania, cadena);
				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return nivel4Clientesmq;
	}

	public void setNivel4Clientesmq(List<ListaNivel4ClientesmqDTO> nivel4Clientesmq) {
		this.nivel4Clientesmq = nivel4Clientesmq;
	}

}
