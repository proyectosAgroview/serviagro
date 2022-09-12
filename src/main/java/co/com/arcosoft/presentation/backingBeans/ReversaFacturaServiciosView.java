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
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatFacturaServicios;
import co.com.arcosoft.modelo.DatPagosNotasClientes;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
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
public class ReversaFacturaServiciosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ReversaFacturaServiciosView.class);
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
	private List<DatFacturaServiciosDTO> data;
	private DatFacturaServiciosDTO selectedDatFacturaServicios;
	private DatFacturaServicios entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private InputNumber txtVlTotal;
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
	private List<ConsultaServiciosRealizadosMaquinariaDTO> selectedDatServRealizadosEquipo2;

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
	private List<Labor> labores;

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

	private List<String> selectedOperador;
	private List<Trabajador> operadores;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private InputText txtEstadoServicio;

	public ReversaFacturaServiciosView() {
		super();
	}

	public String action_new() {
		action_clear();
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
			Object[] condicion = { "numFactura", true, numFactura, "=", "estado", true, "A", "=" };
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

			cargarItemFactura();

		}
	}

	public void listener_limipiarPantalla() {
		try {

			txtFechaRegistro.setValue(null);
			txtNumFactura.setValue(null);
			txtPersEmprId.setValue(null);

			txtFechaRegistro.setDisabled(false);
			txtNumFactura.setDisabled(false);
			txtPersEmprId.setDisabled(false);
			data2 = null;

		} catch (Exception e) {
		}

	}

	public void actionReversarFactura() {
		try {

			String numFactura = FacesUtils.checkString(txtNumFactura);
			Object[] condicion = { "numFactura", true, numFactura, "=" };
			List<DatPagosNotasClientes> listaNotas = (numFactura != null)
					? businessDelegator2View.findByCriteriaInDatPagosNotasClientes(condicion, null, null)
					: null;
			if (listaNotas != null && listaNotas.size() > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "",
						"No se puede reversar la factura, ya que tiene Pagos y/o notas asociadas!! "));
			} else {
				businessDelegator2View.pr_borrar_factura_servicio_consolidada(numFactura);
				 businessDelegator2View
						.pr_reversar_factura_servicio_consolidada_detal(numFactura);

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se ha reversado la factura exitosamente!! "));
			}
		} catch (Exception e) {
		}

	}

	public void actionAnularFactura() {
		try {

			String numFactura = FacesUtils.checkString(txtNumFactura);
			Object[] condicion = { "numFactura", true, numFactura, "=" };
			List<DatPagosNotasClientes> listaNotas = (numFactura != null)
					? businessDelegator2View.findByCriteriaInDatPagosNotasClientes(condicion, null, null)
					: null;

			Object[] condicionFactura = { "numFactura", true, numFactura, "=" };
			List<DatFacturaServicios> listaFacturaServicio = (numFactura != null)
					? businessDelegator2View.findByCriteriaInDatFacturaServicios(condicionFactura, null, null)
					: null;

			if (listaNotas != null && listaNotas.size() > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "",
						"No se puede anular la factura, ya que tiene Pagos y/o notas asociadas!! "));

			} else {
				if (listaFacturaServicio != null && listaNotas.size() >= 0) {
					entity = listaFacturaServicio.get(0);

					Long id = entity.getDatFacturaServiciosId();

					DatFacturaServicios entityFactura = new DatFacturaServicios();
					entityFactura = businessDelegator2View.getDatFacturaServicios(id);
					Date date = new Date();
					entityFactura.setFechaAnulacion(date);
					entityFactura.setEstado("I");
					entityFactura.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

					businessDelegator2View.updateDatFacturaServicios(entityFactura);
					businessDelegator2View
							.pr_reversar_factura_servicio_consolidada_detal(numFactura);

					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
					action_clear();

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Se ha anulado la factura exitosamente!! "));
				}
			}
		} catch (Exception e) {
		}

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

	public SelectItem[] getSelectContratista() {

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

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
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

						selectNumPrefactura = new SelectItem[lista.size()];
						int i = 0;
						for (ConsultaServiciosRealizadosMaquinariaDTO consulta : lista) {
							selectNumPrefactura[i] = new SelectItem(consulta.getConsecutivoPrefactura(),
									consulta.getConsecutivoPrefactura().toString());
							i++;

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

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getDataClientePrefactura() {
		try {

			// Long compania = 1L;
			Long clienteId = FacesUtils.checkLong(txtPersEmprId);
			String prefactura = FacesUtils.checkString(txtNumPrefactura);
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
				txtRetencion.setValue(valorTotal * 0.04);
				txtCantidad.setValue(cantidad);
				txtHoras.setValue(horas);
				cadenaFactura = "0" + cadena;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataClientePrefactura;
	}

	public InputNumber getTxtVlTotal() {
		return txtVlTotal;
	}

	public void setTxtVlTotal(InputNumber txtVlTotal) {
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

	public void cargarItemFactura() {
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

	public void action_valoresSeleccionados() throws Exception {
		String cadena = "";
		Long flagZona = 1L;

		ConsultaServiciosRealizadosMaquinariaDTO zonasSeleccionadas = null;
		if (selectedDatServRealizadosEquipo2 != null && selectedDatServRealizadosEquipo2.size() > 0) {
			zonasSeleccionadas = selectedDatServRealizadosEquipo2.get(0);
			flagZona = 0L;
			for (int i = 0; i < selectedDatServRealizadosEquipo2.size(); i++) {
				zonasSeleccionadas = selectedDatServRealizadosEquipo2.get(i);
				cadena += "," + zonasSeleccionadas.getIdRegistro().toString();
			}
		}

		// cadena = "," +cadena;
		cadenaPrefactura = "0" + cadena;
		Long compania = new Long(getCompaniaIdSession());
		Long actConsPrefactura = businessDelegator2View.actualizarConsecPrefacturaCompania(compania);
		businessDelegator2View.preFecturarServicios(cadenaPrefactura);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se han actualizado las ordenes con éxito "));

		disableButtonA = "true";

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

	public InputText getTxtEstadoServicio() {
		return txtEstadoServicio;
	}

	public void setTxtEstadoServicio(InputText txtEstadoServicio) {
		this.txtEstadoServicio = txtEstadoServicio;
	}

	public void setData2(List<ConsultaServiciosRealizadosMaquinariaDTO> data2) {
		this.data2 = data2;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData2() {
		return data2;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

}
