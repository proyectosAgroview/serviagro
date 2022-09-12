
package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.DatOtrosCostosMq;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaProgLaboresMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgLaboresMecMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresMaqDTO;
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
public class DatServRealizadosEquipoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatServRealizadosEquipoView.class);
	private InputText txtCantidad;
	private InputText txtConsecutivo;
	private InputText txtEstado;
	private InputText txtIngresoTotal;
	private Spinner txtNumFactura;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private SelectOneMenu txtOrigenDatos;
	private InputText txtSerieFactura;
	private InputText txtUsuarioDigitacion;
	private InputText txtValorUnitario;

	private InputText txtDatServRealizadosEquipoId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatServRealizadosEquipoDTO> data;
	private DatServRealizadosEquipoDTO selectedDatServRealizadosEquipo;

	private List<ConsultaServiciosRealizadosMaquinariaDTO> data2;
	private ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo2;

	private DatServRealizadosEquipo entity;
	private DatCtrlMaqPines entityControlPin;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

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

	private int activeTapIndex = 0;

	private List<DatServRealizadosEquipoDetDTO> dataServDet;
	private DatServRealizadosEquipoDetDTO selectedDatServDet;

	private List<PrecioPromProdDTO> dataDetPrecioProductos;
	private PrecioPromProdDTO selectedataDetPrecioProductos;

	private Calendar txtHoraFinalMaquinaria;
	private Calendar txtHoraInicialMaquinaria;

	private InputText txtTotalHorasMaquinaria;

	private InputText txtHorometroInicalMq;
	private InputText txtHorometroFinalMq;
	private InputText txtTotalHorometro;

	private SelectOneMenu txtNivel1IdMaq;
	SelectItem[] selectNivel1Maq;
	private List<Nivel1> nivel1Maq;

	private SelectOneMenu txtNivel2IdMaq;
	SelectItem[] selectNivel2Maq;
	private List<Nivel2> nivel2Maq;

	private SelectOneMenu txtNivel3IdMaq;
	SelectItem[] selectNivel3Maq;
	private List<Nivel3> nivel3Maq;

	private SelectOneMenu txtNivel4Id_Nivel4Maq;
	SelectItem[] selectNivel4Maq;
	private List<Nivel4> nivel4Maq;

	private InputText txtNombreNivel2Maq;
	private InputText txtNombreNivel4Maq;
	private InputText txtNombreLaborMaq;
	private InputText txtNombreUdadMed;

	private CommandButton btnAgregarMaquinaria;

	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;

	private InputText txtProducto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTrabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel2ClientesId;
	SelectItem[] selectNivel2ClientesId;
	private List<Nivel2Clientesmq> nivel2ClientesId;

	private InputText txtNivel4ClientesId;
	SelectItem[] selectNivel4ClientesId;
	private List<Nivel4Clientesmq> nivel4ClientesId;

	private Spinner txtCantidadCombustible;
	private Spinner txtSello;
	private Spinner txtBonificacionTrabajador;

	private SelectOneMenu txtTurno;

	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private InputText txtAlmacenId;
	private Long idProducto;
	private Long idAlmacen;
	private Long idUdadMed;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private InputNumber txtAuxilioTransporte;

	private String cambioItemPin;

	private LogDatServRealizadosEquipo entityLog;

	private SelectOneMenu txtDobleTanqueo;

	private SelectOneMenu txtAlmacenId_Almacen2;
	SelectItem[] selectAlmacen2;
	private List<Almacen> almacen2;

	private InputText txtHorometroAbastecimiento;

	private InputText txtInfoAdicionalCombustible;

	private DatServRealizadosEquipoDet entityDet;

	private PrecioPromProd entityPrecioProd;

	SelectItem[] selectDatServRealizadosEquipo;

	SelectItem[] selectDatPlanServicioMaq;
	private List<DatPlanServiciosMqdet> datPlanServicioMaq;

	private SelectOneMenu txtIdProgramacion;
	SelectItem[] selectDatPlanServicioMaqRegistro;
	private SelectOneMenu txtEstadoFactura;
	
	public DatServRealizadosEquipoView() {
		super();
	}

	public String action_new() throws Exception {
		action_clear();
		selectedDatServRealizadosEquipo = null;

		setShowDialog(true);

		return "";
	}

	public String action_clear() throws Exception {
		entity = null;
		selectedDatServRealizadosEquipo = null;
		PrimeFaces.current().resetInputs(":frm");

		if (txtCantidad != null) {
			txtCantidad.setValue(0);
			txtCantidad.setDisabled(false);
		}
		if (txtIdProgramacion != null) {
			txtIdProgramacion.setValue(null);
			txtIdProgramacion.setDisabled(false);
		}

		if (txtInfoAdicionalCombustible != null) {
			txtInfoAdicionalCombustible.setValue(null);
			txtInfoAdicionalCombustible.setDisabled(false);
		}

		if (txtHorometroAbastecimiento != null) {
			txtHorometroAbastecimiento.setValue(0);
			txtHorometroAbastecimiento.setDisabled(false);
		}

		if (txtAlmacenId_Almacen2 != null) {
			txtAlmacenId_Almacen2.setValue(null);
			txtAlmacenId_Almacen2.setDisabled(false);
		}

		if (txtDobleTanqueo != null) {
			txtDobleTanqueo.setValue("NO");
			txtDobleTanqueo.setDisabled(false);
		}
		if (txtEstadoFactura != null) {
			txtEstadoFactura.setValue(null);
			txtEstadoFactura.setDisabled(false);
		}

		if (txtAuxilioTransporte != null) {
			txtAuxilioTransporte.setValue(0);
			txtAuxilioTransporte.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (dataServDet != null) {
			dataServDet = null;
		}
		if (dataDetPrecioProductos != null) {
			dataDetPrecioProductos = null;
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtIngresoTotal != null) {
			txtIngresoTotal.setValue(null);
			txtIngresoTotal.setDisabled(false);
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

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(false);
		}

		if (txtSerieFactura != null) {
			txtSerieFactura.setValue(null);
			txtSerieFactura.setDisabled(true);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(0);
			txtValorUnitario.setDisabled(false);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaRegistro != null) {
			Date date = new Date();
			// txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtDatServRealizadosEquipoId != null) {
			txtDatServRealizadosEquipoId.setValue(null);
			txtDatServRealizadosEquipoId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		if (txtHoraFinalMaquinaria != null) {
			txtHoraFinalMaquinaria.setValue(null);
			txtHoraFinalMaquinaria.setDisabled(false);
		}
		if (txtHoraInicialMaquinaria != null) {
			txtHoraInicialMaquinaria.setValue(null);
			txtHoraInicialMaquinaria.setDisabled(false);
		}

		if (txtTotalHorasMaquinaria != null) {
			txtTotalHorasMaquinaria.setValue(0);
			txtTotalHorasMaquinaria.setDisabled(false);
		}

		if (txtNombreUdadMed != null) {
			txtNombreUdadMed.setValue(null);
			txtNombreUdadMed.setDisabled(false);
		}

		if (btnAgregarMaquinaria != null) {
			btnAgregarMaquinaria.setDisabled(false);
		}

		if (txtHorometroInicalMq != null) {
			txtHorometroInicalMq.setValue(null);
			txtHorometroInicalMq.setDisabled(false);
		}

		if (txtHorometroFinalMq != null) {
			txtHorometroFinalMq.setValue(null);
			txtHorometroFinalMq.setDisabled(false);
		}

		if (txtTotalHorometro != null) {
			txtTotalHorometro.setValue(null);
			txtTotalHorometro.setDisabled(false);
		}

		if (txtNivel1IdMaq != null) {
			txtNivel1IdMaq.setValue(null);
			txtNivel1IdMaq.setDisabled(false);
		}

		if (txtNivel2IdMaq != null) {
			txtNivel2IdMaq.setValue(null);
			txtNivel2IdMaq.setDisabled(false);
		}

		if (txtNivel3IdMaq != null) {
			txtNivel3IdMaq.setValue(null);
			txtNivel3IdMaq.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4Maq != null) {
			txtNivel4Id_Nivel4Maq.setValue(null);
			txtNivel4Id_Nivel4Maq.setDisabled(false);
		}

		if (txtNombreNivel2Maq != null) {
			txtNombreNivel2Maq.setValue(null);
			txtNombreNivel2Maq.setDisabled(false);
		}

		if (txtNombreNivel4Maq != null) {
			txtNombreNivel4Maq.setValue(null);
			txtNombreNivel4Maq.setDisabled(false);
		}

		if (txtNombreLaborMaq != null) {
			txtNombreLaborMaq.setValue(null);
			txtNombreLaborMaq.setDisabled(false);
		}

		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}

		if (txtProducto != null) {
			txtProducto.setValue(null);
			txtProducto.setDisabled(false);
		}

		if (txtTrabajador != null) {
			txtTrabajador.setValue(null);
			txtTrabajador.setDisabled(false);
		}
		if (txtNivel2ClientesId != null) {
			txtNivel2ClientesId.setValue(null);
			txtNivel2ClientesId.setDisabled(false);
		}

		if (txtCantidadCombustible != null) {
			txtCantidadCombustible.setValue(null);
			txtCantidadCombustible.setDisabled(false);
		}

		if (txtSello != null) {
			txtSello.setValue(null);
			txtSello.setDisabled(false);
		}

		if (txtBonificacionTrabajador != null) {
			txtBonificacionTrabajador.setValue(null);
			txtBonificacionTrabajador.setDisabled(false);
		}

		if (txtTurno != null) {
			txtTurno.setValue(null);
			txtTurno.setDisabled(false);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
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

	public String action_edit(ActionEvent evt) {
		selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo2"));
		try {

			Long idRegistro = selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id().longValue();
			Object[] condicion = { "datServRealizadosEquipoId", true, idRegistro, "=" };
			List<DatServRealizadosEquipo> lista = (idRegistro != null)
					? businessDelegatorView.findByCriteriaInDatServRealizadosEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtAlmacenId_Almacen2.setDisabled(false);
				txtHorometroAbastecimiento.setDisabled(false);
				txtValorUnitario.setDisabled(false);
				txtValorUnitario.setValue(0);

				txtIdProgramacion.setDisabled(false);

				// txtCantidad.setValue(entity.getCantidad());
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtEstadoFactura.setDisabled(false);

				// txtDobleTanqueo.setValue(entity.getDobleTanqueo());
				// txtDobleTanqueo.setDisabled(true);

				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				// txtIngresoTotal.setValue(entity.getIngresoTotal());
				// txtIngresoTotal.setDisabled(false);
				// txtNumFactura.setValue(entity.getNumFactura());
				// txtNumFactura.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtOrigenDatos.setValue(entity.getOrigenDatos());
				txtOrigenDatos.setDisabled(false);
				// txtValorUnitario.setValue(entity.getValorUnitario());
				// txtValorUnitario.setDisabled(false);
				 
				txtCentCostId_CentCost.setValue(null);
				if(entity.getCentCost()!=null) {
				 txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
				 txtCentCostId_CentCost.setDisabled(false);
				}
				 // txtElemCostoId_ElementoCosto.setValue(selectedDatServRealizadosEquipo.getElemCostoId_ElementoCosto());
				// txtElemCostoId_ElementoCosto.setDisabled(false);
				txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
				txtEquipoId_Equipo.setDisabled(false);

				// txtProducto.setValue(selectedDatServRealizadosEquipo.getProductoId());
				// txtProducto.setDisabled(false);
				// txtCantidadCombustible.setValue(entity.getCantidadCombustible());
				txtCantidadCombustible.setDisabled(false);
				// txtSello.setValue(entity.getSello());
				// txtSello.setDisabled(false);

				// txtLaborId_Labor.setValue(selectedDatServRealizadosEquipo.getLaborId_Labor());
				// txtLaborId_Labor.setDisabled(false);
				// txtPersEmprId_PersEmpr.setValue(selectedDatServRealizadosEquipo.getPersEmprId_PersEmpr());
				// txtPersEmprId_PersEmpr.setDisabled(false);
				// txtUdadMedId_UdadMed.setValue(selectedDatServRealizadosEquipo.getUdadMedId_UdadMed());
				// txtUdadMedId_UdadMed.setDisabled(false);
				txtDatServRealizadosEquipoId.setValue(entity.getDatServRealizadosEquipoId());
				txtDatServRealizadosEquipoId.setDisabled(true);
				btnSave.setDisabled(false);

				Long datServId = FacesUtils.checkLong(txtDatServRealizadosEquipoId);
				dataServDet = null;
				dataServDet = businessDelegatorView.getDataDatServRealizadosEquipoDetByServ(datServId);

				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View.getDataProductosByServRealizados(datServId);

				// txtIngresoTotal.setDisabled(false);
				// txtValorUnitario.setDisabled(false);
				txtLaborId_Labor.setDisabled(false);
				txtUdadMedId_UdadMed.setDisabled(false);
				// txtHoraFinalMaquinaria.setDisabled(false);
				// txtHoraInicialMaquinaria.setDisabled(false);
				// txtTotalHorasMaquinaria.setDisabled(false);
				// txtNombreUdadMed.setDisabled(false);
				txtHorometroInicalMq.setDisabled(true);
				txtHorometroFinalMq.setDisabled(false);
				// txtTotalHorometro.setDisabled(false);
				// txtNivel1IdMaq.setDisabled(false);
				// txtNivel2IdMaq.setDisabled(false);
				// txtNivel3IdMaq.setDisabled(false);
				// txtNombreNivel2Maq.setDisabled(false);
				// txtNombreNivel4Maq.setDisabled(false);
				// txtNombreLaborMaq.setDisabled(false);
				txtCantidad.setDisabled(false);

				txtPersEmprId_PersEmpr.setDisabled(false);
				txtImplemento.setDisabled(false);

				txtInfoAdicionalCombustible.setDisabled(false);

				GregorianCalendar cHoy = new GregorianCalendar();
				java.util.Date fechaReg = FacesUtils.checkDate(txtFechaRegistro);

				cHoy.setTime(fechaReg);
				int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
				int mesHoy = cHoy.get(java.util.Calendar.MONTH);
				int anoHoy = cHoy.get(java.util.Calendar.YEAR);
				cHoy.set(anoHoy, mesHoy, diaHoy);
				java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

				Long idcompania = new Long(getCompaniaIdSession());
				Long equipoId = entity.getEquipo().getEquipoId();

				if (equipoId != null && !equipoId.toString().isEmpty()) {
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);

					/*
					 * if(equipo.getTrabajador() !=null){
					 * txtTrabajador.setValue(equipo.getTrabajador()); }else{
					 * 
					 * FacesContext.getCurrentInstance().addMessage(null, new
					 * FacesMessage(FacesMessage.SEVERITY_ERROR,
					 * "Upps!, La maquina no tiene un operario por defecto en el catalogo de maquinaria  "
					 * , "")); }
					 */

					if (equipo.getMedidor() != null) {

						Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());

						if (medidor != null) {
							Long idMedidor = medidor.getMedidorId();

							if (medidor.getTipoMedidor().equals("horometro")) {

								BigDecimal valor = businessDelegatorView.consultarHorometroActual(fechaHoy, equipoId,
										idMedidor, idcompania);

								txtHorometroInicalMq.setValue(valor.floatValue());

							}

							if (medidor.getTipoMedidor().equals("odometro")) {

								BigDecimal valor = businessDelegatorView.consultarOdometroActual(fechaHoy, equipoId,
										idMedidor, idcompania);

								txtHorometroInicalMq.setValue(valor.floatValue());

							}

							if (medidor.getTipoMedidor().equals("averiado")) {

								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
												"El medidor de la maquinaria/equipo se encuentra averiado"));

							}

						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
											"No se ha asignado un medidor a la maquinaria/equipo"));
						}

						if (equipo.getProductoId() != null) {
							Long productoId = equipo.getProductoId();
							Producto producto = businessDelegatorView.getProducto(productoId);
							idProducto = productoId;

							idAlmacen = FacesUtils.checkLong(txtAlmacenId_Almacen2);
							idUdadMed = producto.getUdadMedByUdadMedProd().getUdadMedId();

						} else {
							txtCantidadCombustible.setDisabled(true);
							txtHorometroAbastecimiento.setDisabled(true);

							// txtSello.setDisabled(true);
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									"Upss! No se ha configurado el producto de tipo combustible en el catalogo de maquinaria/equipo",
									""));
						}
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss! Primero debe seleccionar la fecha del registro, y luego debe seleccionar el equipo",
							""));
				}

				txtTrabajador.setDisabled(false);
				txtNivel2ClientesId.setDisabled(false);
				// txtBonificacionTrabajador.setDisabled(false);
				txtTurno.setDisabled(false);
				// txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				// txtAuxilioTransporte.setDisabled(false);
				btnAgregarMaquinaria.setDisabled(false);

				setShowDialog(true);

			}

		} catch (Exception e) {
			entity = null;
		}
		return "";
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
			Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinalMq);
			Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicalMq);
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

	public void ConsultarTarifaPagoMaquinaria() throws Exception {
		// Long compania = 1L;

		Long idCompania = new Long(getCompaniaIdSession());
		Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedId_UdadMed);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));
		Long idCliente = FacesUtils.checkLong(txtPersEmprId_PersEmpr);
		Long idLabor = FacesUtils.checkLong(txtLaborId_Labor);
		Double tarifaLabor = 0.0;

		if (txtLaborId_Labor.getValue() != null) {
			Labor labor = businessDelegatorView.getLabor(idLabor);
			if (labor.getTarifaEstandar() != null) {
				tarifaLabor = labor.getTarifaEstandar();
			} else {
				tarifaLabor = 0.0;
			}

		}

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
					txtValorUnitario.setValue(tarifaLabor);
				}

				if (tarifaPagoMaquina.equals(0)) {
					txtValorUnitario.setValue(tarifaLabor);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// pieModel1.set("Sin datos", 0L);
		}
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
				Long id = new Long(selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id().longValue());
				entity = businessDelegatorView.getDatServRealizadosEquipo(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			Long datServId = FacesUtils.checkLong(txtDatServRealizadosEquipoId);
			dataServDet = null;
			dataServDet = businessDelegatorView.getDataDatServRealizadosEquipoDetByServ(datServId);

			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			businessDelegatorView.updateDatServRealizadosEquipo(entity, dataServDet, null);
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
		selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo2"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atras. Por favor, estar seguro."));
		return "";

	}

	public String action_save() {
		try {
			if ((selectedDatServRealizadosEquipo == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new DatServRealizadosEquipo();
			entityLog = new LogDatServRealizadosEquipo();
			// Long datServRealizadosEquipoId =
			// FacesUtils.checkLong(txtDatServRealizadosEquipoId);

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);

			// entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDobleTanqueo(FacesUtils.checkString(txtDobleTanqueo));

			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			// entity.setIngresoTotal(FacesUtils.checkDouble(txtIngresoTotal));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setSerieFactura(FacesUtils.checkString(txtSerieFactura));

			entity.setPuedeEditarPin("No");

			// entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
					: null);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto) != null)
					? businessDelegatorView.getElementoCosto(FacesUtils.checkLong(txtElemCostoId_ElementoCosto))
					: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);

			Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);

			Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
			Long indicadorMedidor = 0L;
			if (equipo.getIndicador_vuelta_medidor() != null) {
				indicadorMedidor = equipo.getIndicador_vuelta_medidor();
			}
			entity.setIndicador_vuelta_medidor(indicadorMedidor);

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaMinPermitida = null;
			Date fechaOriginal = foriginal.parse("2000-01-01");
			String fsalida = sdf.format(fechaOriginal);

			fechaMinPermitida = sdf.parse(fsalida);
			GregorianCalendar calendario3 = new GregorianCalendar();
			calendario3.setTime(fechaMinPermitida);
			java.sql.Date fechaMinima = new java.sql.Date(calendario3.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinima.before(fechaPin)) {
				// if (dataServDet != null && dataServDet.size() > 0) {
				businessDelegatorView.saveDatServRealizadosEquipo(entity, dataServDet, dataDetPrecioProductos);

				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);

				Long idmaq = FacesUtils.checkLong(txtEquipoId_Equipo);
				Long consecutivoPin = FacesUtils.checkLong(txtConsecutivo);

				Long actualizaCtrPin = businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq,
						consecutivoPin);

				if (dataServDet != null && dataServDet.size() > 0) {
					for (int a = 0; a < dataServDet.size(); a++) {
						DatServRealizadosEquipoDetDTO dataDetalle = dataServDet.get(a);
						Long idPrograma = 0L;
						if (dataDetalle.getDat_plan_servicios_mqdet_id() != null) {
							Labor labor = businessDelegatorView.getLabor(dataDetalle.getLaborId_Labor().getLaborId());
							if (labor.getClaseLabor() != null) {
								if (!labor.getClaseLabor().equals("Transporte")) {
									idPrograma = dataDetalle.getDat_plan_servicios_mqdet_id()
											.getDatPlanServiciosMqdetId();
									businessDelegator2View.pr_actualizar_prog_maquinaria(idPrograma);
								}
							}

						}
					}
				}

				entityLog.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
				entityLog.setCompania(compania);

				entityLog.setUsuarioModificacion(usuarioId);
				entityLog.setEquipoId((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
						? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
						: null);

				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				entityLog.setFecha(date);

				Long consecutivo = (FacesUtils.checkLong(txtConsecutivo));
				String codusuario = usuario.getLogin();

				entityLog.setObservacion(
						"El Pin:" + "  " + consecutivo.toString() + " Fue creado por el usuario: " + codusuario);

				businessDelegator2View.saveLogDatServRealizadosEquipo(entityLog);

				// Long idDatServRealizado = entity.getDatServRealizadosEquipoId();
				// dataServDet = null;
				// dataServDet =
				// businessDelegatorView.getDataDatServRealizadosEquipoDetByServ(idDatServRealizado);
				action_clear();
				// }

				// else {
				// FacesContext.getCurrentInstance().addMessage(null, new
				// FacesMessage(FacesMessage.SEVERITY_ERROR,
				// "Upps!, Falta registrar y agregar el detalle del servicio " + "Verifique que
				// los campos "
				// + "Clientes, hda, operario, implemento, labor, unidad de medida, hOrometro
				// inicial, "
				// + "hOrometro final" + "tengan valores. ",
				// ""));
				// }
			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del pin esta por fuera del rango permitido " + "", ""));
				selectedDatServRealizadosEquipo = null;
				entity = null;

			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long datServRealizadosEquipoId = new Long(
						selectedDatServRealizadosEquipo.getDatServRealizadosEquipoId());
				entity = businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
			}
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setDobleTanqueo(FacesUtils.checkString(txtDobleTanqueo));
			// entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			// entity.setIngresoTotal(FacesUtils.checkDouble(txtIngresoTotal));
			entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setSerieFactura(FacesUtils.checkString(txtSerieFactura));
			// entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
					: null);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto) != null)
					? businessDelegatorView.getElementoCosto(FacesUtils.checkLong(txtElemCostoId_ElementoCosto))
					: null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			// entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
			// ?
			// businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
			// : null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);
			entity.setPuedeEditarPin("No");

			Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);

			Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
			Long indicadorMedidor = 0L;
			if (equipo.getIndicador_vuelta_medidor() != null) {
				indicadorMedidor = equipo.getIndicador_vuelta_medidor();
			}
			entity.setIndicador_vuelta_medidor(indicadorMedidor);

			// entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) !=
			// null)
			// ?
			// businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
			// : null);
			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaMinPermitida = null;
			Date fechaOriginal = foriginal.parse("2000-01-01");
			String fsalida = sdf.format(fechaOriginal);

			fechaMinPermitida = sdf.parse(fsalida);
			GregorianCalendar calendario3 = new GregorianCalendar();
			calendario3.setTime(fechaMinPermitida);
			java.sql.Date fechaMinima = new java.sql.Date(calendario3.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinima.before(fechaPin)) {
				// if (dataServDet != null && dataServDet.size() > 0) {
				businessDelegatorView.updateDatServRealizadosEquipo(entity, dataServDet, dataDetPrecioProductos);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				Long idmaq = FacesUtils.checkLong(txtEquipoId_Equipo);
				Long consecutivoPin = FacesUtils.checkLong(txtConsecutivo);

				if (idmaq != null) {
					Object[] condicionCtrlPines = { "equipo.equipoId", true, idmaq, "=" };
					List<DatCtrlMaqPines> listaCtrlPines = (idmaq != null)
							? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicionCtrlPines, null, null)
							: null;
					if (listaCtrlPines != null && listaCtrlPines.size() > 0) {
						DatCtrlMaqPines datCtrlMaqPines = listaCtrlPines.get(0);

						Long consecutivoInicial = datCtrlMaqPines.getConsecutivoPin();
						if (consecutivoInicial >= consecutivoPin) {
							businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoInicial);
						} else {
							businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoPin);
						}

					}
				}

				if (dataServDet != null && dataServDet.size() > 0) {
					for (int a = 0; a < dataServDet.size(); a++) {
						DatServRealizadosEquipoDetDTO dataDetalle = dataServDet.get(a);
						Long idPrograma = 0L;
						if (dataDetalle.getDat_plan_servicios_mqdet_id() != null) {
							Labor labor = businessDelegatorView.getLabor(dataDetalle.getLaborId_Labor().getLaborId());
							if (labor.getClaseLabor() != null) {
								if (!labor.getClaseLabor().equals("Transporte")) {
									idPrograma = dataDetalle.getDat_plan_servicios_mqdet_id()
											.getDatPlanServiciosMqdetId();
									businessDelegator2View.pr_actualizar_prog_maquinaria(idPrograma);
								}
							}

						}
					}
				}

				// Long idDatServRealizado = entity.getDatServRealizadosEquipoId();
				// dataServDet = null;
				/// dataServDet =
				// businessDelegatorView.getDataDatServRealizadosEquipoDetByServ(idDatServRealizado);

				action_clear();
				/*
				 * } else { FacesContext.getCurrentInstance().addMessage(null, new
				 * FacesMessage(FacesMessage.SEVERITY_ERROR,
				 * "Upps!, Falta registrar y agregar el detalle del servicio " +
				 * "Verifique que los campos " +
				 * "Clientes, hda, operario, implemento, labor,  unidad de mÃ©dida, horometro inicial, "
				 * + "horometro final" + "tengan valores. ", "")); }
				 */

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del pin esta por fuera del rango permitido" + "", ""));
				selectedDatServRealizadosEquipo = null;
				entity = null;

			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatServRealizadosEquipo = (DatServRealizadosEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatServRealizadosEquipo"));

			Long datServRealizadosEquipoId = new Long(selectedDatServRealizadosEquipo.getDatServRealizadosEquipoId());
			entity = businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datServRealizadosEquipoId = FacesUtils.checkLong(txtDatServRealizadosEquipoId);
			entity = businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatServRealizadosEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws Exception {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatServRealizadosEquipo = (DatServRealizadosEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatServRealizadosEquipo"));

			Long datServRealizadosEquipoId = new Long(selectedDatServRealizadosEquipo.getDatServRealizadosEquipoId());
			entity = businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
			businessDelegatorView.deleteDatServRealizadosEquipo(entity);
			data.remove(selectedDatServRealizadosEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidad, Long compania, Long consecutivo, Long datServRealizadosEquipoId,
			String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, Date fechaRegistro,
			Double ingresoTotal, String numFactura, String observacion, String observacionAnularReg, String origenDatos,
			Long persEmprId, String serieFactura, Long usuarioDigitacion, Double valorUnitario,
			Long centCostId_CentCost, Long elemCostoId_ElementoCosto, Long equipoId_Equipo, Long laborId_Labor,
			Long persEmprId_PersEmpr, Long udadMedId_UdadMed) throws Exception {
		try {
			// entity.setCantidad(FacesUtils.checkDouble(cantidad));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			// entity.setIngresoTotal(FacesUtils.checkDouble(ingresoTotal));
			entity.setNumFactura(FacesUtils.checkLong(numFactura));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
			entity.setSerieFactura(FacesUtils.checkString(serieFactura));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			// entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updateDatServRealizadosEquipo(entity, dataServDet, dataDetPrecioProductos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatServRealizadosEquipoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtIngresoTotal() {
		return txtIngresoTotal;
	}

	public void setTxtIngresoTotal(InputText txtIngresoTotal) {
		this.txtIngresoTotal = txtIngresoTotal;
	}

	public Spinner getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(Spinner txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public InputText getTxtSerieFactura() {
		return txtSerieFactura;
	}

	public void setTxtSerieFactura(InputText txtSerieFactura) {
		this.txtSerieFactura = txtSerieFactura;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
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

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public InputText getTxtDatServRealizadosEquipoId() {
		return txtDatServRealizadosEquipoId;
	}

	public void setTxtDatServRealizadosEquipoId(InputText txtDatServRealizadosEquipoId) {
		this.txtDatServRealizadosEquipoId = txtDatServRealizadosEquipoId;
	}

	public List<DatServRealizadosEquipoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatServRealizadosEquipo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatServRealizadosEquipoDTO> datServRealizadosEquipoDTO) {
		this.data = datServRealizadosEquipoDTO;
	}

	public void listarPines() {
		try {

			// Long compania = 1L;
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Long flagEquipo = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += "," + selectedEquipo.get(i);
				}
			}
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.consultaServRealizadosMq(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo);
			} else {
				/*
				 * SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); SimpleDateFormat
				 * foriginal = new SimpleDateFormat("yyyy-MM-dd"); Date fechaFinalDateRegistro
				 * =null; Date fechaOriginal = foriginal.parse("1970-01-01"); String fsalida =
				 * sdf.format(fechaOriginal);
				 * 
				 * fechaFinalDateRegistro = sdf.parse(fsalida); Date date = new Date(); data2 =
				 * businessDelegatorView.consultaServRealizadosMq(compania,
				 * fechaFinalDateRegistro, date, equiposSeleccionadas, flagEquipo);
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData2() {
		return data2;
	}

	/**
	 * @param data2 the data2 to set
	 */
	public void setData2(List<ConsultaServiciosRealizadosMaquinariaDTO> data2) {
		this.data2 = data2;
	}

	public DatServRealizadosEquipoDTO getSelectedDatServRealizadosEquipo() {
		return selectedDatServRealizadosEquipo;
	}

	public void setSelectedDatServRealizadosEquipo(DatServRealizadosEquipoDTO datServRealizadosEquipo) {
		this.selectedDatServRealizadosEquipo = datServRealizadosEquipo;
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

	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(),
							equipo.getCodigo() + " - " + equipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipo;
	}

	public SelectItem[] getselectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			try {

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

	public SelectItem[] getselectElementoCosto() {

		if (elementoCosto == null || elementoCosto.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectElementoCosto = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectElementoCosto[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectElementoCosto;
	}

	public void setselectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
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

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {
			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion",
						"<>" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborId : lista) {
					selectLaborId[i] = new SelectItem(laborId.getLaborId(),
							laborId.getCodigo() + '-' + laborId.getNombre());
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

	public void actualizar_horometro_inicial() {
		Double horometroFin = FacesUtils.checkDouble(txtHorometroFinalMq);
		txtHorometroInicalMq.setValue(horometroFin.floatValue());
		txtHorometroInicalMq.setDisabled(true);
		txtHorometroFinalMq.setValue(null);
		// txtSello.setValue(0);
		txtCantidadCombustible.setValue(0);
		txtHorometroAbastecimiento.setValue(0);
		// txtAuxilioTransporte.setValue(0);
	}

	public List<DatServRealizadosEquipoDetDTO> getDatServRealizadosEquipoDet1() {

		if (dataServDet == null || dataServDet.size() == 0) {
			return null;
		} else {
			return dataServDet;
		}

	}

	public List<PrecioPromProdDTO> getDetPrecioProductos() {

		if (dataDetPrecioProductos == null || dataDetPrecioProductos.size() == 0) {
			return null;
		} else {
			return dataDetPrecioProductos;
		}

	}

	public void action_agregarServicio() throws Exception {

		String codNivel4Clientes = FacesUtils.checkString(txtNivel4ClientesId);

		if (txtUdadMedId_UdadMed.getValue() != null && txtLaborId_Labor.getValue() != null  && txtEstadoFactura.getValue() != null
				&& txtFechaRegistro.getValue() != null && txtCantidad.getValue() != null
				&& txtHorometroInicalMq.getValue() != null && txtHorometroFinalMq.getValue() != null
				&& txtTrabajador.getValue() != null && txtPersEmprId_PersEmpr.getValue() != null
				&& txtNivel2ClientesId.getValue() != null // && txtCeptoNominaId_ConceptoNomina.getValue() != null
				&& txtTurno.getValue() != null && codNivel4Clientes != null && !codNivel4Clientes.equals("")) {

			Long compania = new Long(getCompaniaIdSession());
			Double saldoProducto = 0.0;
			// Long nivel2Id =
			// Long.parseLong(txtNivel2IdMaq.getValue().toString());
			// Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

			// Long nivel4Id =
			// Long.parseLong(txtNivel4Id_Nivel4Maq.getValue().toString());
			// Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

			Long indicador_vuelta_medidor = 0l;

			Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			Labor labor = businessDelegatorView.getLabor(laborId);
			String nombreLabor = labor.getNombre();

			Long clientesId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());
			PersEmpr persEmpr = businessDelegatorView.getPersEmpr(clientesId);
			String nomCliente = persEmpr.getNombre();

			Long conceptoId = 1L;// Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());
			ConceptoNomina concepto = businessDelegatorView.getConceptoNomina(conceptoId);
			String nomConcepto = concepto.getNombre();

			Long implementoId = null;
			String codImplemento = "";
			Equipo implemento = null;
			if (txtImplemento.getValue() != null) {
				implementoId = Long.parseLong(txtImplemento.getValue().toString());
				implemento = businessDelegatorView.getEquipo(implementoId);
				codImplemento = implemento.getCodigo();
			}
			Long trabajadorId = Long.parseLong(txtTrabajador.getValue().toString());
			Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);
			String codTrabajador = trabajador.getNombre();

			Long nivel2ClientesId = Long.parseLong(txtNivel2ClientesId.getValue().toString());
			Nivel2Clientesmq nivel2Clientes = businessDelegator2View.getNivel2Clientesmq(nivel2ClientesId);
			String codNivel2Clientes = nivel2Clientes.getNombre();

			Long nivel4ClientesId = null;
			Nivel4Clientesmq nivel4Clientes = null;
			codNivel4Clientes = FacesUtils.checkString(txtNivel4ClientesId);

			Long idProgramacion = null;
			DatPlanServiciosMqdet datPlanServiciosMqdet = null;
			if (txtIdProgramacion.getValue() != null) {
				idProgramacion = Long.parseLong(txtIdProgramacion.getValue().toString());
				datPlanServiciosMqdet = businessDelegator2View.getDatPlanServiciosMqdet(idProgramacion);
			}

			if (codNivel4Clientes != null && !codNivel4Clientes.equals("")) {

				Object[] condicion = { "codigo", true, codNivel4Clientes, "=", "nivel2Clientesmq.nivel2ClientesmqId",
						true, nivel2ClientesId, "=" };
				List<Nivel4Clientesmq> nivel4ClientesConsulta = businessDelegator2View
						.findByCriteriaInNivel4Clientesmq(condicion, null, null);

				if (nivel4ClientesConsulta == null || nivel4ClientesConsulta.size() == 0) {
					nivel4Clientes = new Nivel4Clientesmq();
					Date date = new Date();

					nivel4Clientes.setNivel2Clientesmq(nivel2Clientes);
					nivel4Clientes.setCodigo(codNivel4Clientes);
					nivel4Clientes.setNombre(codNivel4Clientes);
					nivel4Clientes.setCompania(compania);
					nivel4Clientes.setEstado("A");
					nivel4Clientes.setAreaNeta(0.0);
					nivel4Clientes.setFechaCreacion(date);

					businessDelegator2View.saveNivel4Clientesmq(nivel4Clientes);

				} else {
					nivel4Clientes = nivel4ClientesConsulta.get(0);
					codNivel4Clientes = nivel4Clientes.getCodigo();
				}
			}

			// String codNivel4Clientes = txtNombreNivel4Maq.getValue().toString();
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			String nomUdadPagoMaquinaria = udadMed.getNombre();

			Date horaInicial = null;// FacesUtils.checkDate(txtHoraInicialMaquinaria);
			Date horaFinal = null; // FacesUtils.checkDate(txtHoraFinalMaquinaria);

			Double horometroIni = 0.0;
			if (txtHorometroInicalMq.getValue() != null) {
				horometroIni = FacesUtils.checkDouble(txtHorometroInicalMq);
			}

			Double horometroFin = 0.0;
			if (txtHorometroFinalMq.getValue() != null) {
				horometroFin = FacesUtils.checkDouble(txtHorometroFinalMq);
			}
			Double calculoHorasHorometro = 0.0;
			if (horometroIni != null && horometroFin != null) {
				calculoHorasHorometro = horometroFin - horometroIni;
			}

			Producto producto = businessDelegatorView.getProducto(idProducto);
			String nomProducto = producto.getNombre();
			Long almacenId = 0L;
			if (txtAlmacenId_Almacen2.getValue() != null) {
				almacenId = FacesUtils.checkLong(txtAlmacenId_Almacen2);
			}

			Almacen almacen = businessDelegatorView.getAlmacen(almacenId);
			String codAlmacen = almacen.getCodigo();
			ConceptoKardex conceptoKardex = businessDelegator2View.getConceptoKardex(8L);

			Double cantidadCombustible = FacesUtils.checkDouble(txtCantidadCombustible);
			Double horometroAbastecimiento = FacesUtils.checkDouble(txtHorometroAbastecimiento);
			/*
			 * String dobleTanqueo = ""; dobleTanqueo =
			 * FacesUtils.checkString(txtDobleTanqueo);
			 * 
			 * if (dobleTanqueo.equals("SI")) { cantidadCombustible = cantidadCombustible *
			 * 2.0; }
			 */
			
			Long centCostId =null;
			CentCost centCost = null;
			String nombreCentCost ="";
			if(txtCentCostId_CentCost.getValue()!=null) {
				centCostId = FacesUtils.checkLong(txtCentCostId_CentCost);
				centCost = businessDelegatorView.getCentCost(centCostId);
				nombreCentCost = centCost.getNombre();
			}
			
			Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));

			Double costoUnitCombustible = 0.0;
			Double costoCombustible = 0.0;

			if (idFecha != null && idUdadMed != null && compania != null && almacenId != null && idProducto != null) {

				costoUnitCombustible = businessDelegatorView.consultarPrecioPromProducto(idProducto, almacenId,
						compania, idFecha);
				if (costoUnitCombustible != null) {
					costoCombustible = costoUnitCombustible.doubleValue() * cantidadCombustible;
				}

				saldoProducto = businessDelegator2View.pr_saldo_prom_producto(idProducto, almacenId, compania)
						.doubleValue();
			}

			UdadMed udadMedCombustible = businessDelegatorView.getUdadMed(idUdadMed);
			// Almacen almacenCombustible = businessDelegatorView.getAlmacen(almacenId);
			// falta trear el calculo del costo del combustible
			Long sello = 0L;// ;FacesUtils.checkLong(txtSello);

			GregorianCalendar cHoy = new GregorianCalendar();
			java.util.Date fechaReg = FacesUtils.checkDate(txtFechaRegistro);

			cHoy.setTime(fechaReg);
			int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
			int mesHoy = cHoy.get(java.util.Calendar.MONTH);
			int anoHoy = cHoy.get(java.util.Calendar.YEAR);
			cHoy.set(anoHoy, mesHoy, diaHoy);
			java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

			Long idcompania = new Long(getCompaniaIdSession());
			Long equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);

			Equipo equipo = null;
			BigDecimal valor = null;
			Double maxDifHorometro = 0.0;
			if (equipoId != null && !equipoId.toString().isEmpty()) {
				equipo = businessDelegatorView.getEquipo(equipoId);
				if (equipo.getIndicador_vuelta_medidor() != null) {
					indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
				}
				Long categid = equipo.getCategoriaEquipo().getCategEquipId();

				CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categid);

				if (categoria.getRangoDifHorometro() != null) {
					maxDifHorometro = categoria.getRangoDifHorometro();
				}

				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());

					if (medidor != null) {
						Long idMedidor = medidor.getMedidorId();

						if (medidor.getTipoMedidor().equals("horometro")) {

							valor = businessDelegatorView.consultarHorometroActual(fechaHoy, equipoId, idMedidor,
									idcompania);

							// txtHorometroInicalMq.setValue(valor);

						}

						if (medidor.getTipoMedidor().equals("odometro")) {

							valor = businessDelegatorView.consultarOdometroActual(fechaHoy, equipoId, idMedidor,
									idcompania);

							// txtHorometroInicalMq.setValue(valor);

						}

						if (medidor.getTipoMedidor().equals("averiado")) {

							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
											"El medidor de la maquinaria/equipo se encuentra averiado"));

						}

					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));
					}

				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Upss! Primero debe seleccionar la fecha del registro, y luego debe seleccionar el equipo",
						""));
			}

			if (saldoProducto >= cantidadCombustible) {

				if (horometroIni != null && valor != null) {
					if (horometroIni >= valor.doubleValue()) {

						if (horometroIni != null && horometroFin != null) {
							if (horometroIni <= horometroFin.doubleValue()) {

								if (calculoHorasHorometro <= maxDifHorometro) {

									Double cantidad = FacesUtils.checkDouble(txtCantidad);

									String tipoUm = udadMed.getClasificacionUm();
									Double totalHorometro = 0.0;
									Double totalHoras = 0.0;

									Double result = 0.0;

									totalHorometro = FacesUtils.checkDouble(txtHorometroFinalMq)
											- FacesUtils.checkDouble(txtHorometroInicalMq);
									totalHoras = FacesUtils.checkDouble(txtHorometroFinalMq)
											- FacesUtils.checkDouble(txtHorometroInicalMq);

									Double tarifaLabor = 0.0;
									Double valorUnit = 0.0;
									Double subValorUnit = 0.0;
									Double valorUnitarioTrabajador = 0.0;
									Double valorTotalTrabajador = 0.0;

									/**
									 * if(labor.getTarifaEstandar()!=null) { tarifaLabor =
									 * labor.getTarifaEstandar(); }else { tarifaLabor = 0.0; }
									 * 
									 * BigDecimal tarifaPagoMaquina =
									 * businessDelegatorView.consultarTarifaContratista(idcompania, clientesId,
									 * laborId, 0L, udadMedId_UdadMed, idFecha, 0.0, "0", 0L, 0L, "0");
									 * 
									 * subValorUnit = tarifaPagoMaquina.doubleValue();
									 * 
									 * 
									 * if (subValorUnit.doubleValue()>=0 && subValorUnit.doubleValue()<=0.1 ) {
									 * valorUnit = tarifaLabor; }else { valorUnit = subValorUnit.doubleValue(); }
									 * 
									 **/

									valorUnit = FacesUtils.checkDouble(txtValorUnitario);
									if (valorUnit == null || valorUnit == 0) {

										String tablaPrecios = "";
										tablaPrecios = persEmpr.getTablaPrecios();

										if (tablaPrecios.equals("1")) {
											valorUnit = labor.getTarifaEstandar();
										}
										if (tablaPrecios.equals("2")) {
											valorUnit = labor.getTarifaEstandar2();
										}
										if (tablaPrecios.equals("3")) {
											valorUnit = labor.getTarifaEstandar3();
										}
										if (tablaPrecios.equals("4")) {
											valorUnit = labor.getTarifaEstandar4();
										}
										if (tablaPrecios.equals("5")) {
											valorUnit = labor.getTarifaEstandar5();
										}
										if (tablaPrecios.equals("6")) {
											valorUnit = labor.getTarifaEstandar6();
										}
										if (tablaPrecios.equals("7")) {
											valorUnit = labor.getTarifaEstandar7();
										}
										if (tablaPrecios.equals("8")) {
											valorUnit = labor.getTarifaEstandar8();
										}
										if (tablaPrecios.equals("9")) {
											valorUnit = labor.getTarifaEstandar9();
										}
										if (tablaPrecios.equals("10")) {
											valorUnit = labor.getTarifaEstandar10();
										}

									}

									// Double ingresoTotal = FacesUtils.checkDouble(txtIngresoTotal);
									Double ingresoTotal = valorUnit * cantidad;
									// String nombreLabor = FacesUtils.checkString(txtNombreLaborMaq);
									// String nombreNivel2 = FacesUtils.checkString(txtNombreNivel2Maq);
									// String nombreNivel4 = FacesUtils.checkString(txtNombreNivel4Maq);

									// sujeto a revision del cliente
									// BigDecimal bonif = businessDelegatorView.consultarAdicionalManoObra(compania,
									// laborId, udadMedId_UdadMed,
									// fecha, cantidad);
									// Double bonificacionTrabajador = bonif.doubleValue() *cantidad;
									Double bonificacionTrabajador = 0.0;
									String turno = FacesUtils.checkString(txtTurno);

									Double auxilioTransporte = 0.0;
									// if(txtAuxilioTransporte.getValue()!=null) {
									// auxilioTransporte = FacesUtils.checkDouble(txtAuxilioTransporte);
									// }

									valorUnitarioTrabajador = businessDelegatorView.consultarTarifaLaborRendimientoBase(
											compania, 0L, laborId, 0L, udadMedId_UdadMed, idFecha).doubleValue();

									if (cantidad == 0) {
										valorTotalTrabajador = valorUnitarioTrabajador;
									} else {
										valorTotalTrabajador = valorUnitarioTrabajador * cantidad;
									}

									String estadoFacura = FacesUtils.checkString(txtEstadoFactura);

									String infoAdicionalCombustible = FacesUtils
											.checkString(txtInfoAdicionalCombustible);

									boolean existeProducto = false;

									if (dataServDet == null) {
										dataServDet = new ArrayList<DatServRealizadosEquipoDetDTO>();
									}
									if (dataDetPrecioProductos == null) {
										dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
									}
									if (dataServDet.size() > 0) {

										for (DatServRealizadosEquipoDetDTO d : dataServDet) {

											/*
											 * if (d.getPersEmpr().getPersEmprId().longValue() ==
											 * persEmpr.getPersEmprId() .longValue() &&
											 * d.getLaborId_Labor().getLaborId().longValue() == labor
											 * .getLaborId().longValue() &&
											 * d.getUdadMedId_UdadMed().getUdadMedId().longValue() == udadMed
											 * .getUdadMedId().longValue() &&
											 * d.getNivel2ClientesId().getNivel2ClientesmqId() .longValue() ==
											 * nivel2Clientes.getNivel2ClientesmqId() .longValue() // &&
											 * d.getNivel4ClientesId().getNivel4ClientesmqId().longValue() == //
											 * nivel4Clientes // .getNivel4ClientesmqId().longValue()
											 * 
											 * && d.getHorometroInicial() == horometroIni && d.getTurno().equals(turno))
											 * {
											 * 
											 * existeProducto = true;
											 * 
											 * FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
											 * FacesMessage.SEVERITY_WARN, "Upps!",
											 * "La Labor/Cliente/Hda/Lote/Unidad de médida " +
											 * d.getLaborId_Labor().getNombre() + " " +
											 * d.getNivel2ClientesId().getNombre() + " " + d.getNombreNivel4() +
											 * " ya fue agregado a la lista, por favor seleccione otro. "));
											 * 
											 * break; }
											 */

											if (d.getHorometroFinal() > horometroIni) {

												existeProducto = true;

												FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
														FacesMessage.SEVERITY_WARN, "Upps!",
														"Verificar que el horómetro / odometro digitado sea mayor al horómetro anteriormente agregado a la lista "));

												break;
											}

										}

									}

									if (existeProducto == false) {

										DatServRealizadosEquipoDetDTO datServicioDetDTO2 = new DatServRealizadosEquipoDetDTO();

										datServicioDetDTO2.setUdadMedId_UdadMed(udadMed);
										datServicioDetDTO2.setNombreUdadMed(nomUdadPagoMaquinaria);
										datServicioDetDTO2.setHoraInicial(horaInicial);
										datServicioDetDTO2.setHoraFinal(horaFinal);
										datServicioDetDTO2.setEstadoFactura(estadoFacura);

										datServicioDetDTO2.setHorometroInicial(horometroIni);
										datServicioDetDTO2.setHorometroFinal(horometroFin);
										datServicioDetDTO2.setCantidad(cantidad);
										datServicioDetDTO2.setHorasTotal(totalHoras);
										datServicioDetDTO2.setHorometroTotal(totalHorometro);
										datServicioDetDTO2.setValorUnitario(valorUnit);
										datServicioDetDTO2.setIngresoTotal(ingresoTotal);

										// datServicioDetDTO2.setNivel2(nivel2);
										// datServicioDetDTO2.setNivel4(nivel4);
										datServicioDetDTO2.setLaborId_Labor(labor);
										datServicioDetDTO2.setNombreLabor(nombreLabor);

										// datServicioDetDTO2.setNombreNivel2(nombreNivel2);
										datServicioDetDTO2.setNombreNivel4(codNivel4Clientes);
										datServicioDetDTO2.setNivel4ClientesId(nivel4Clientes);

										datServicioDetDTO2.setPersEmpr(persEmpr);
										datServicioDetDTO2.setNomCliente(nomCliente);
										datServicioDetDTO2.setImplemento(implemento);
										datServicioDetDTO2.setCodImplemento(codImplemento);
										datServicioDetDTO2.setTrabajador(trabajador);
										datServicioDetDTO2.setCodTrabajador(codTrabajador);
										datServicioDetDTO2.setNivel2ClientesId(nivel2Clientes);
										datServicioDetDTO2.setNomNivel2ClientesId(codNivel2Clientes);
										datServicioDetDTO2.setConceptoNominaId(concepto);
										datServicioDetDTO2.setNomConceptoNomina(nomConcepto);
										datServicioDetDTO2.setTurno(turno);

										datServicioDetDTO2.setBonificacionTrabajador(bonificacionTrabajador);
										datServicioDetDTO2.setCantidadCombustible(cantidadCombustible);
										datServicioDetDTO2.setCostoCombustible(costoCombustible);
										datServicioDetDTO2.setAlmacenId(almacen);
										datServicioDetDTO2.setProductoId(producto);
										datServicioDetDTO2.setAuxilioTransporte(auxilioTransporte);
										datServicioDetDTO2.setValor_unitario_trabajador(valorUnitarioTrabajador);
										datServicioDetDTO2.setValor_total_trabajador(valorTotalTrabajador);
										datServicioDetDTO2.setDat_plan_servicios_mqdet_id(datPlanServiciosMqdet);
										datServicioDetDTO2.setIdProgramaMaqDet(idProgramacion);
										datServicioDetDTO2.setCantidadTrabajador(cantidad);
										datServicioDetDTO2.setUnidadMedidaTrabajador(udadMedId_UdadMed);

										dataServDet.add(datServicioDetDTO2);

										PrecioPromProdDTO dataDetPrecioProductos2 = new PrecioPromProdDTO();
										dataDetPrecioProductos2.setFechaInicial(idFecha);
										dataDetPrecioProductos2.setProducto(producto);
										dataDetPrecioProductos2.setNomProducto(nomProducto);
										dataDetPrecioProductos2.setCodAlmacen(codAlmacen);

										dataDetPrecioProductos2.setCantidadCompra(cantidadCombustible);
										dataDetPrecioProductos2.setUnidadMedida(udadMedCombustible);
										dataDetPrecioProductos2.setAlmacenId(almacen);
										dataDetPrecioProductos2.setValorUnitario(costoUnitCombustible.doubleValue());
										dataDetPrecioProductos2.setCompania(compania);
										Date date = new Date();
										dataDetPrecioProductos2.setFechaCreacion(date);

										dataDetPrecioProductos2.setConceptoKardexId(conceptoKardex);
										dataDetPrecioProductos2.setTipoMovimiento("SAL");

										dataDetPrecioProductos2.setCostoTotal(costoCombustible);
										dataDetPrecioProductos2.setEquipoId(equipo);
										dataDetPrecioProductos2.setEquipoId(equipo);
										dataDetPrecioProductos2.setHorometro_abastecimiento(horometroAbastecimiento);
										dataDetPrecioProductos2.setInfoAdicional(infoAdicionalCombustible);
										dataDetPrecioProductos2.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
										dataDetPrecioProductos2.setCentCostId(centCostId);
										dataDetPrecioProductos2.setNombreCentCost(nombreCentCost);
										dataDetPrecioProductos.add(dataDetPrecioProductos2);

									}
									infoAdicionalCombustible = null;

									codAlmacen = null;
									codAlmacen = null;
									auxilioTransporte = null;
									cantidadCombustible = null;
									costoCombustible = null;
									costoUnitCombustible = null;
									almacen = null;
									producto = null;
									concepto = null;
									nomConcepto = null;
									udadMed = null;
									cantidad = null;
									nomUdadPagoMaquinaria = null;
									horaInicial = null;
									horaFinal = null;
									totalHoras = null;
									valorUnit = null;
									ingresoTotal = null;
									totalHorometro = null;
									// dataDetProductos = null;
									// nivel2Id = null;
									// nivel4Id = null;
									nombreLabor = null;
									codNivel4Clientes = null;
									// nivel4Clientes = null;
									horometroIni = null;

									persEmpr = null;
									nomCliente = null;
									implemento = null;
									codImplemento = null;
									trabajador = null;
									codTrabajador = null;
									nivel2Clientes = null;
									codNivel2Clientes = null;
									bonificacionTrabajador = null;
									turno = null;
									horometroIni = null;
									horometroFin = null;
									actualizar_horometro_inicial();
								} else {
									FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
											FacesMessage.SEVERITY_ERROR, "Upps!",
											"La diferencia entre el hórometro inicial y el final esta fuera del rango, "
													+ "verifique en el maestro de categorías del equipos."));

								}
							} else {
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
										FacesMessage.SEVERITY_ERROR, "Upps!",
										"Verifique el campo horómetro final, ya que este valor no puede ser menor  al horómetro inicial digitado."));

							}
						}

					} else {

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!",
								"Verifique el campo horómetro inicial, ya que este valor no puede ser  inferior al horometro anterior."));

					}
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Upps! No hay saldo en la bodega para el  combustible utlizado", " "));
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  de maquinaria, labor, unidad de médida, hórometro inicial y final, cantidad, "
							+ "cliente, hacienda, suerte, trabajador, turno, concepto tengan valores"));
		}

	}

	public void listener_ConsultaProgramacion() throws Exception {
		Long idProgramacion = Long.parseLong(txtIdProgramacion.getValue().toString());
		DatPlanServiciosMqdet datPlanServiciosMqdet = null;
		if (idProgramacion != null) {
			idProgramacion = Long.parseLong(txtIdProgramacion.getValue().toString());
			datPlanServiciosMqdet = businessDelegator2View.getDatPlanServiciosMqdet(idProgramacion);
			try {
				txtPersEmprId_PersEmpr.setValue(datPlanServiciosMqdet.getPersEmpr().getPersEmprId());
				txtNivel2ClientesId.setValue(datPlanServiciosMqdet.getNivel2Clientesmq().getNivel2ClientesmqId());
				Nivel4Clientesmq nivel4Clientesmq = businessDelegator2View
						.getNivel4Clientesmq(datPlanServiciosMqdet.getNivel4ClientesmqId().getNivel4ClientesmqId());
				txtNivel4ClientesId.setValue(nivel4Clientesmq.getCodigo());
				txtLaborId_Labor.setValue(datPlanServiciosMqdet.getLabor().getLaborId());
				txtUdadMedId_UdadMed.setValue(datPlanServiciosMqdet.getUdadMed().getUdadMedId());
				txtCantidad.setValue(datPlanServiciosMqdet.getCantidadPendiente());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreNivel2_Nivel4Maq() {
		Long nivel4Id = null;
		Long nivel2Id = null;
		if (!txtNivel4Id_Nivel4Maq.getValue().equals("") && !txtNivel2IdMaq.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4Maq.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2IdMaq.getValue().toString());
			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				txtNombreNivel4Maq.setValue(nivel4.getNombre());
				txtNombreNivel2Maq.setValue(nivel2.getNombre());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreLaborMaq() {
		Long laborId = null;
		Double valorUnit = 0.0;
		if (txtLaborId_Labor.getValue() != null) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				// txtNombreLaborMaq.setValue(labor.getNombre());
				if (labor.getUdadMedByUdadMedPago() != null) {
					txtUdadMedId_UdadMed.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
				}

				if (txtPersEmprId_PersEmpr.getValue() != null) {
					Long clientesId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());
					PersEmpr persEmpr = businessDelegatorView.getPersEmpr(clientesId);

					String tablaPrecios = "";
					tablaPrecios = persEmpr.getTablaPrecios();

					if (tablaPrecios.equals("1")) {
						valorUnit = labor.getTarifaEstandar();
					}
					if (tablaPrecios.equals("2")) {
						valorUnit = labor.getTarifaEstandar2();
					}
					if (tablaPrecios.equals("3")) {
						valorUnit = labor.getTarifaEstandar3();
					}
					if (tablaPrecios.equals("4")) {
						valorUnit = labor.getTarifaEstandar4();
					}
					if (tablaPrecios.equals("5")) {
						valorUnit = labor.getTarifaEstandar5();
					}
					if (tablaPrecios.equals("6")) {
						valorUnit = labor.getTarifaEstandar6();
					}
					if (tablaPrecios.equals("7")) {
						valorUnit = labor.getTarifaEstandar7();
					}
					if (tablaPrecios.equals("8")) {
						valorUnit = labor.getTarifaEstandar8();
					}
					if (tablaPrecios.equals("9")) {
						valorUnit = labor.getTarifaEstandar9();
					}
					if (tablaPrecios.equals("10")) {
						valorUnit = labor.getTarifaEstandar10();
					}

					txtValorUnitario.setValue(valorUnit);
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public String actionDeleteDatServRealizadosEquipoDet(ActionEvent evt) {
		try {

			selectedDatServDet = (DatServRealizadosEquipoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatServDet"));

			if (selectedDatServDet.getDatServRealizadosEquipoDetId() == null) {
				dataServDet.remove(selectedDatServDet);
			} else {
				Long datServicioId = new Long(selectedDatServDet.getDatServRealizadosEquipoDetId());
				DatServRealizadosEquipoDet entity = businessDelegatorView.getDatServRealizadosEquipoDet(datServicioId);
				businessDelegatorView.deleteDatServRealizadosEquipoDet(entity);
				dataServDet.remove(selectedDatServDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void listener_ConsultaNomUmMaquinaria() {

		Long idCodUmMaquinaria = null;
		if (FacesUtils.checkLong(txtUdadMedId_UdadMed) != null) {
			if (!txtUdadMedId_UdadMed.getValue().equals("")) {
				idCodUmMaquinaria = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());

				try {
					UdadMed udadMed = businessDelegatorView.getUdadMed(idCodUmMaquinaria);
					/* valNPass = datPlanLabor.getNPases(); */
					txtNombreUdadMed.setValue(udadMed.getNombre());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	/**
	 * @return the activeTapIndex
	 */
	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	/**
	 * @param activeTapIndex the activeTapIndex to set
	 */
	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the dataServDet
	 */
	public List<DatServRealizadosEquipoDetDTO> getDataServDet() {
		return dataServDet;
	}

	/**
	 * @param dataServDet the dataServDet to set
	 */
	public void setDataServDet(List<DatServRealizadosEquipoDetDTO> dataServDet) {
		this.dataServDet = dataServDet;
	}

	/**
	 * @return the txtHoraFinalMaquinaria
	 */
	public Calendar getTxtHoraFinalMaquinaria() {
		return txtHoraFinalMaquinaria;
	}

	/**
	 * @param txtHoraFinalMaquinaria the txtHoraFinalMaquinaria to set
	 */
	public void setTxtHoraFinalMaquinaria(Calendar txtHoraFinalMaquinaria) {
		this.txtHoraFinalMaquinaria = txtHoraFinalMaquinaria;
	}

	/**
	 * @return the txtHoraInicialMaquinaria
	 */
	public Calendar getTxtHoraInicialMaquinaria() {
		return txtHoraInicialMaquinaria;
	}

	/**
	 * @param txtHoraInicialMaquinaria the txtHoraInicialMaquinaria to set
	 */
	public void setTxtHoraInicialMaquinaria(Calendar txtHoraInicialMaquinaria) {
		this.txtHoraInicialMaquinaria = txtHoraInicialMaquinaria;
	}

	/**
	 * @return the txtTotalHorasMaquinaria
	 */
	public InputText getTxtTotalHorasMaquinaria() {
		return txtTotalHorasMaquinaria;
	}

	/**
	 * @param txtTotalHorasMaquinaria the txtTotalHorasMaquinaria to set
	 */
	public void setTxtTotalHorasMaquinaria(InputText txtTotalHorasMaquinaria) {
		this.txtTotalHorasMaquinaria = txtTotalHorasMaquinaria;
	}

	/**
	 * @return the txtHorometroInicalMq
	 */
	public InputText getTxtHorometroInicalMq() {
		return txtHorometroInicalMq;
	}

	/**
	 * @param txtHorometroInicalMq the txtHorometroInicalMq to set
	 */
	public void setTxtHorometroInicalMq(InputText txtHorometroInicalMq) {
		this.txtHorometroInicalMq = txtHorometroInicalMq;
	}

	/**
	 * @return the txtHorometroFinalMq
	 */
	public InputText getTxtHorometroFinalMq() {
		return txtHorometroFinalMq;
	}

	/**
	 * @param txtHorometroFinalMq the txtHorometroFinalMq to set
	 */
	public void setTxtHorometroFinalMq(InputText txtHorometroFinalMq) {
		this.txtHorometroFinalMq = txtHorometroFinalMq;
	}

	/**
	 * @return the txtTotalHorometro
	 */
	public InputText getTxtTotalHorometro() {
		return txtTotalHorometro;
	}

	/**
	 * @param txtTotalHorometro the txtTotalHorometro to set
	 */
	public void setTxtTotalHorometro(InputText txtTotalHorometro) {
		this.txtTotalHorometro = txtTotalHorometro;
	}

	/**
	 * @return the txtNivel1IdMaq
	 */
	public SelectOneMenu getTxtNivel1IdMaq() {
		return txtNivel1IdMaq;
	}

	/**
	 * @param txtNivel1IdMaq the txtNivel1IdMaq to set
	 */
	public void setTxtNivel1IdMaq(SelectOneMenu txtNivel1IdMaq) {
		this.txtNivel1IdMaq = txtNivel1IdMaq;
	}

	/**
	 * @return the txtNivel2IdMaq
	 */
	public SelectOneMenu getTxtNivel2IdMaq() {
		return txtNivel2IdMaq;
	}

	/**
	 * @param txtNivel2IdMaq the txtNivel2IdMaq to set
	 */
	public void setTxtNivel2IdMaq(SelectOneMenu txtNivel2IdMaq) {
		this.txtNivel2IdMaq = txtNivel2IdMaq;
	}

	/**
	 * @return the txtNivel3IdMaq
	 */
	public SelectOneMenu getTxtNivel3IdMaq() {
		return txtNivel3IdMaq;
	}

	/**
	 * @param txtNivel3IdMaq the txtNivel3IdMaq to set
	 */
	public void setTxtNivel3IdMaq(SelectOneMenu txtNivel3IdMaq) {
		this.txtNivel3IdMaq = txtNivel3IdMaq;
	}

	/**
	 * @return the txtNivel4Id_Nivel4Maq
	 */
	public SelectOneMenu getTxtNivel4Id_Nivel4Maq() {
		return txtNivel4Id_Nivel4Maq;
	}

	/**
	 * @param txtNivel4Id_Nivel4Maq the txtNivel4Id_Nivel4Maq to set
	 */
	public void setTxtNivel4Id_Nivel4Maq(SelectOneMenu txtNivel4Id_Nivel4Maq) {
		this.txtNivel4Id_Nivel4Maq = txtNivel4Id_Nivel4Maq;
	}

	/**
	 * @return the txtNombreNivel2Maq
	 */
	public InputText getTxtNombreNivel2Maq() {
		return txtNombreNivel2Maq;
	}

	/**
	 * @param txtNombreNivel2Maq the txtNombreNivel2Maq to set
	 */
	public void setTxtNombreNivel2Maq(InputText txtNombreNivel2Maq) {
		this.txtNombreNivel2Maq = txtNombreNivel2Maq;
	}

	/**
	 * @return the txtNombreNivel4Maq
	 */
	public InputText getTxtNombreNivel4Maq() {
		return txtNombreNivel4Maq;
	}

	/**
	 * @param txtNombreNivel4Maq the txtNombreNivel4Maq to set
	 */
	public void setTxtNombreNivel4Maq(InputText txtNombreNivel4Maq) {
		this.txtNombreNivel4Maq = txtNombreNivel4Maq;
	}

	/**
	 * @return the txtNombreLaborMaq
	 */
	public InputText getTxtNombreLaborMaq() {
		return txtNombreLaborMaq;
	}

	/**
	 * @param txtNombreLaborMaq the txtNombreLaborMaq to set
	 */
	public void setTxtNombreLaborMaq(InputText txtNombreLaborMaq) {
		this.txtNombreLaborMaq = txtNombreLaborMaq;
	}

	/**
	 * @return the txtNombreUdadMed
	 */
	public InputText getTxtNombreUdadMed() {
		return txtNombreUdadMed;
	}

	/**
	 * @param txtNombreUdadMed the txtNombreUdadMed to set
	 */
	public void setTxtNombreUdadMed(InputText txtNombreUdadMed) {
		this.txtNombreUdadMed = txtNombreUdadMed;
	}

	/**
	 * @return the btnAgregarMaquinaria
	 */
	public CommandButton getBtnAgregarMaquinaria() {
		return btnAgregarMaquinaria;
	}

	/**
	 * @param btnAgregarMaquinaria the btnAgregarMaquinaria to set
	 */
	public void setBtnAgregarMaquinaria(CommandButton btnAgregarMaquinaria) {
		this.btnAgregarMaquinaria = btnAgregarMaquinaria;
	}

	public SelectItem[] getselectImplemento() {

		if (implemento == null || implemento.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Implemento", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo implemento : lista) {
					selectImplemento[i] = new SelectItem(implemento.getEquipoId(),
							implemento.getCodigo() + "-" + implemento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectImplemento;
	}

	public void setselectImplemento(SelectItem[] selectImplemento) {
		this.selectImplemento = selectImplemento;
	}

	public SelectItem[] getSelectProductoId() {
		if (productoId == null || productoId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				// Criteria
				List<CatalogProductoDTO> listaProductos = businessDelegatorView
						.consultarCatalogoProductosAgricolas(idCompania);
				selectProductoId = new SelectItem[listaProductos.size()];
				int i = 0;
				for (CatalogProductoDTO listaDTO : listaProductos) {
					selectProductoId[i] = new SelectItem(listaDTO.getProductoId().longValue(), listaDTO.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoId;
	}

	public void setSelectProductoId(SelectItem[] selectProductoId) {
		this.selectProductoId = selectProductoId;
	}

	public SelectItem[] getSelectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "estado", true, "A", "=" };
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

	public void setSelectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getSelectNivel2ClientesId() {

		if (nivel2ClientesId == null || nivel2ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprId_PersEmpr != null && txtPersEmprId_PersEmpr.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());

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

	public void setSelectNivel2ClientesId(SelectItem[] selectNivel2ClientesId) {
		this.selectNivel2ClientesId = selectNivel2ClientesId;
	}

	public SelectItem[] getSelectCeptoNominaId() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setselectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

	/**
	 * @return the txtImplemento
	 */
	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	/**
	 * @param txtImplemento the txtImplemento to set
	 */
	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	/**
	 * @return the txtProducto
	 */
	public InputText getTxtProducto() {
		return txtProducto;
	}

	/**
	 * @param txtProducto the txtProducto to set
	 */
	public void setTxtProducto(InputText txtProducto) {
		this.txtProducto = txtProducto;
	}

	/**
	 * @return the txtTrabajador
	 */
	public SelectOneMenu getTxtTrabajador() {
		return txtTrabajador;
	}

	/**
	 * @param txtTrabajador the txtTrabajador to set
	 */
	public void setTxtTrabajador(SelectOneMenu txtTrabajador) {
		this.txtTrabajador = txtTrabajador;
	}

	/**
	 * @return the txtNivel2ClientesId
	 */
	public SelectOneMenu getTxtNivel2ClientesId() {
		return txtNivel2ClientesId;
	}

	/**
	 * @param txtNivel2ClientesId the txtNivel2ClientesId to set
	 */
	public void setTxtNivel2ClientesId(SelectOneMenu txtNivel2ClientesId) {
		this.txtNivel2ClientesId = txtNivel2ClientesId;
	}

	/**
	 * @return the txtCantidadCombustible
	 */
	public Spinner getTxtCantidadCombustible() {
		return txtCantidadCombustible;
	}

	/**
	 * @param txtCantidadCombustible the txtCantidadCombustible to set
	 */
	public void setTxtCantidadCombustible(Spinner txtCantidadCombustible) {
		this.txtCantidadCombustible = txtCantidadCombustible;
	}

	/**
	 * @return the txtSello
	 */
	public Spinner getTxtSello() {
		return txtSello;
	}

	/**
	 * @param txtSello the txtSello to set
	 */
	public void setTxtSello(Spinner txtSello) {
		this.txtSello = txtSello;
	}

	/**
	 * @return the txtBonificacionTrabajador
	 */
	public Spinner getTxtBonificacionTrabajador() {
		return txtBonificacionTrabajador;
	}

	/**
	 * @param txtBonificacionTrabajador the txtBonificacionTrabajador to set
	 */
	public void setTxtBonificacionTrabajador(Spinner txtBonificacionTrabajador) {
		this.txtBonificacionTrabajador = txtBonificacionTrabajador;
	}

	/**
	 * @return the txtTurno
	 */
	public SelectOneMenu getTxtTurno() {
		return txtTurno;
	}

	/**
	 * @param txtTurno the txtTurno to set
	 */
	public void setTxtTurno(SelectOneMenu txtTurno) {
		this.txtTurno = txtTurno;
	}

	/**
	 * @return the txtCeptoNominaId_ConceptoNomina
	 */
	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	/**
	 * @param txtCeptoNominaId_ConceptoNomina the txtCeptoNominaId_ConceptoNomina to
	 *                                        set
	 */
	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public void action_selectMedidorEquipo() throws Exception {

		if (txtFechaRegistro.getValue() != null) {
			Long equipoId = null;
			equipoId = FacesUtils.checkLong(txtEquipoId_Equipo);
			Long compania = new Long(getCompaniaIdSession());
			if (equipoId != null) {
				txtConsecutivo.setValue(businessDelegatorView.consultarConsecutivoServRealizados(compania, equipoId));
			}
			
			
			
			GregorianCalendar cHoy = new GregorianCalendar();
			java.util.Date fechaReg = FacesUtils.checkDate(txtFechaRegistro);

			cHoy.setTime(fechaReg);
			int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
			int mesHoy = cHoy.get(java.util.Calendar.MONTH);
			int anoHoy = cHoy.get(java.util.Calendar.YEAR);
			cHoy.set(anoHoy, mesHoy, diaHoy);
			java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());

			if (equipoId != null && !equipoId.toString().isEmpty()) {

				Equipo equipo = businessDelegatorView.getEquipo(equipoId);
				if (equipo.getTrabajador() != null) {
					txtTrabajador.setValue(equipo.getTrabajador());
				}
				
				if (equipo.getCentCost() != null) {
					txtCentCostId_CentCost.setValue(equipo.getCentCost());
				}
				
				
				if (equipo.getMedidor() != null) {

					Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());

					if (medidor != null) {
						Long idMedidor = medidor.getMedidorId();

						if (medidor.getTipoMedidor().equals("horometro")) {

							BigDecimal valor = businessDelegatorView.consultarHorometroActual(fechaHoy, equipoId,
									idMedidor, compania);

							txtHorometroInicalMq.setValue(valor.floatValue());

						}

						if (medidor.getTipoMedidor().equals("odometro")) {

							BigDecimal valor = businessDelegatorView.consultarOdometroActual(fechaHoy, equipoId,
									idMedidor, compania);

							txtHorometroInicalMq.setValue(valor.floatValue());

						}

						if (medidor.getTipoMedidor().equals("averiado")) {

							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upss!",
											"El medidor de la maquinaria/equipo se encuentra averiado"));

						}
					}
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss!", "No se ha asignado un medidor a la maquinaria/equipo"));
				}

				if (equipo.getProductoId() != null) {

					Long productoId = equipo.getProductoId();
					Producto producto = businessDelegatorView.getProducto(productoId);
					idProducto = productoId;

					idAlmacen = FacesUtils.checkLong(txtAlmacenId_Almacen2);
					idUdadMed = producto.getUdadMedByUdadMedProd().getUdadMedId();

				} else {
					txtAlmacenId_Almacen2.setDisabled(true);
					txtCantidadCombustible.setDisabled(true);
					txtHorometroAbastecimiento.setDisabled(true);

					// txtSello.setDisabled(true);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Upss! No se ha configurado el producto de tipo combustible en el catalogo de maquinaria/equipo",
							""));
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Upss! Primero debe seleccionar la fecha del registro, y luego debe seleccionar el equipo", ""));
		}
	}

	/**
	 * @return the txtAlmacenId
	 */
	public InputText getTxtAlmacenId() {
		return txtAlmacenId;
	}

	/**
	 * @param txtAlmacenId the txtAlmacenId to set
	 */
	public void setTxtAlmacenId(InputText txtAlmacenId) {
		this.txtAlmacenId = txtAlmacenId;
	}

	/**
	 * @return the idProducto
	 */
	public Long getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the idAlmacen
	 */
	public Long getIdAlmacen() {
		return idAlmacen;
	}

	/**
	 * @param idAlmacen the idAlmacen to set
	 */
	public void setIdAlmacen(Long idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			try {
				equipos = businessDelegatorView.getEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
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

	/**
	 * @return the selectedDatServRealizadosEquipo2
	 */
	public ConsultaServiciosRealizadosMaquinariaDTO getSelectedDatServRealizadosEquipo2() {
		return selectedDatServRealizadosEquipo2;
	}

	/**
	 * @param selectedDatServRealizadosEquipo2 the selectedDatServRealizadosEquipo2
	 *                                         to set
	 */
	public void setSelectedDatServRealizadosEquipo2(
			ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo2) {
		this.selectedDatServRealizadosEquipo2 = selectedDatServRealizadosEquipo2;
	}

	public InputText getTxtNivel4ClientesId() {
		return txtNivel4ClientesId;
	}

	public void setTxtNivel4ClientesId(InputText txtNivel4ClientesId) {
		this.txtNivel4ClientesId = txtNivel4ClientesId;
	}

	public SelectItem[] getSelectNivel4ClientesId() throws NumberFormatException, Exception {

		if (txtNivel2ClientesId != null && txtNivel2ClientesId.getValue() != null) {
			Long idCompania = new Long(getCompaniaIdSession());
			String nivel2ClientesId = null;

			nivel2ClientesId = txtNivel2ClientesId.getValue().toString();
			try {
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

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ClientesId;
	}

	public void setSelectNivel4ClientesId(SelectItem[] selectNivel4ClientesId) {
		this.selectNivel4ClientesId = selectNivel4ClientesId;
	}

	public List<PrecioPromProdDTO> getDataDetPrecioProductos() {
		return dataDetPrecioProductos;
	}

	public void setDataDetPrecioProductos(List<PrecioPromProdDTO> dataDetPrecioProductos) {
		this.dataDetPrecioProductos = dataDetPrecioProductos;
	}

	public InputNumber getTxtAuxilioTransporte() {
		return txtAuxilioTransporte;
	}

	public void setTxtAuxilioTransporte(InputNumber txtAuxilioTransporte) {
		this.txtAuxilioTransporte = txtAuxilioTransporte;
	}

	public String action_editFecha(ActionEvent evt) {
		selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo2"));
		try {

			Long idRegistro = selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id().longValue();
			Object[] condicion = { "datServRealizadosEquipoId", true, idRegistro, "=" };
			List<DatServRealizadosEquipo> lista = (idRegistro != null)
					? businessDelegatorView.findByCriteriaInDatServRealizadosEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtNumFactura.setValue(entity.getNumFactura());
				txtNumFactura.setDisabled(true);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);

				txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
				txtEquipoId_Equipo.setDisabled(true);

				txtDatServRealizadosEquipoId.setValue(entity.getDatServRealizadosEquipoId());
				txtDatServRealizadosEquipoId.setDisabled(true);
				btnSave.setDisabled(false);

				setShowDialog(true);

			}

		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_modificarFecha() {
		try {
			if (entity == null) {
				Long datServRealizadosEquipoId = new Long(
						selectedDatServRealizadosEquipo.getDatServRealizadosEquipoId());
				entity = businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
			}
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setPuedeEditarPin("No");

			businessDelegatorView.updateDatServRealizadosEquipo(entity, null, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public DatServRealizadosEquipo getEntity() {
		return entity;
	}

	public void setEntity(DatServRealizadosEquipo entity) {
		this.entity = entity;
	}

	public LogDatServRealizadosEquipo getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(LogDatServRealizadosEquipo entityLog) {
		this.entityLog = entityLog;
	}

	public DatCtrlMaqPines getEntityControlPin() {
		return entityControlPin;
	}

	public void setEntityControlPin(DatCtrlMaqPines entityControlPin) {
		this.entityControlPin = entityControlPin;
	}

	public String getCambioItemPin() {
		return cambioItemPin;
	}

	public void setCambioItemPin(String cambioItemPin) {
		this.cambioItemPin = cambioItemPin;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneMenu getTxtDobleTanqueo() {
		return txtDobleTanqueo;
	}

	public void setTxtDobleTanqueo(SelectOneMenu txtDobleTanqueo) {
		this.txtDobleTanqueo = txtDobleTanqueo;
	}

	public SelectItem[] getSelectAlmacen2() {

		if (almacen2 == null || almacen2.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(),
							almacen2.getCodigo() + " - " + almacen2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen2;
	}

	public void setSelectAlmacen2(SelectItem[] selectAlmacen2) {
		this.selectAlmacen2 = selectAlmacen2;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen2() {
		return txtAlmacenId_Almacen2;
	}

	public void setTxtAlmacenId_Almacen2(SelectOneMenu txtAlmacenId_Almacen2) {
		this.txtAlmacenId_Almacen2 = txtAlmacenId_Almacen2;
	}

	public InputText getTxtHorometroAbastecimiento() {
		return txtHorometroAbastecimiento;
	}

	public void setTxtHorometroAbastecimiento(InputText txtHorometroAbastecimiento) {
		this.txtHorometroAbastecimiento = txtHorometroAbastecimiento;
	}

	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo2"));
		try {

			Long idDatServicioEquipo = selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id().longValue();
			Object[] condicion = { "datServRealizadosEquipoId", true, idDatServicioEquipo, "=" };
			List<DatServRealizadosEquipo> lista = (idDatServicioEquipo != null)
					? businessDelegatorView.findByCriteriaInDatServRealizadosEquipo(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {
						Long borrarDetalle = businessDelegator2View
								.pr_borrar_dat_servicio_equipo_det(idDatServicioEquipo);
						Long borrarSalidasProductos = businessDelegator2View
								.pr_borrar_serv_producto(idDatServicioEquipo);
						Long borrarGeneral = businessDelegator2View.pr_borrar_dat_servicio_equipo(idDatServicioEquipo);
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Proceso exitoso!", "El movimiento de compra fue eliminado exitosamente!!!"));

					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!",
								"Para poder eliminar el movimiento de compra debe tener permisos de administrador "));

					}
				}
				setShowDialog(true);

				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String actionDeleteDatServRealizadosEquipoProducto(ActionEvent evt) {
		try {

			selectedataDetPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedataDetPrecioProductos"));

			if (selectedataDetPrecioProductos.getDatServRealizadosEquipoId() == null) {
				dataDetPrecioProductos.remove(selectedataDetPrecioProductos);
			} else {
				Long precioPromId = new Long(selectedataDetPrecioProductos.getPrecioProdId());
				PrecioPromProd entity = businessDelegatorView.getPrecioPromProd(precioPromId);
				businessDelegatorView.deletePrecioPromProd(entity);
				dataDetPrecioProductos.remove(selectedataDetPrecioProductos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public InputText getTxtInfoAdicionalCombustible() {
		return txtInfoAdicionalCombustible;
	}

	public void setTxtInfoAdicionalCombustible(InputText txtInfoAdicionalCombustible) {
		this.txtInfoAdicionalCombustible = txtInfoAdicionalCombustible;
	}

	public void onCellEditEventosServicios(CellEditEvent evt) throws Exception {

		// caso 1 : la tabla transaccional no tiene valores
		Long datServRealizadosEquipoId = FacesUtils.checkLong(txtDatServRealizadosEquipoId);
		if (datServRealizadosEquipoId != null) {
			selectedDatServDet = (DatServRealizadosEquipoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatServDet"));
			if (selectedDatServDet.getDatServRealizadosEquipoDetId() != null) {
				Long datServRealizadosEquipoDetId = selectedDatServDet.getDatServRealizadosEquipoDetId().longValue();

				String columnaCell = evt.getColumn().getHeaderText();

				Object oldValue = evt.getOldValue();
				Object newValue = evt.getNewValue();

				if (newValue != null) {

					entityDet = null;
					entityDet = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);

					/**
					 * if (columnaCell.equals("Maq")) {
					 * 
					 * Long maqId = new Long(evt.getNewValue().toString()); Equipo e =
					 * businessDelegatorView.getEquipo(maqId);
					 * 
					 * entityDet.setEquipo(e);
					 * 
					 * }
					 **/

					if (columnaCell.equals("HrInic")) {

						entityDet.setHorometroInicial(Double.valueOf(evt.getNewValue().toString()));

						Double horInicial = Double.valueOf(evt.getNewValue().toString());

						Double horFinal = entityDet.getHorometroFinal();
						Double horasTotal = horFinal - horInicial;

						entityDet.setHorometroTotal(horasTotal);
						entityDet.setHorasTotal(horasTotal);

					}

					if (columnaCell.equals("HrFin")) {

						entityDet.setHorometroFinal(Double.valueOf(evt.getNewValue().toString()));

						Double horFinal = Double.valueOf(evt.getNewValue().toString());

						Double horInicial = entityDet.getHorometroInicial();
						Double horasTotal = horFinal - horInicial;

						entityDet.setHorometroTotal(horasTotal);
						entityDet.setHorasTotal(horasTotal);

					}

					if (columnaCell.equals("Total horas")) {

						entityDet.setHorasTotal(Double.valueOf(evt.getNewValue().toString()));
						entityDet.setHorometroTotal(Double.valueOf(evt.getNewValue().toString()));

					}

					if (columnaCell.equals("Cantidad")) {

						entityDet.setCantidad(Double.valueOf(evt.getNewValue().toString()));
						Double cantidad = Double.valueOf(evt.getNewValue().toString());
						Double tarifa = entityDet.getValorUnitario();

						Double ingresoTotal = cantidad * tarifa;
						entityDet.setIngresoTotal(ingresoTotal);

						Double valorUnitarioTrabajador = entityDet.getValor_unitario_trabajador();
						Double valorTotalTrabajador = cantidad * valorUnitarioTrabajador;

						entityDet.setValor_total_trabajador(valorTotalTrabajador);
					}

					if (columnaCell.equals("Tarifa($)")) {

						entityDet.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));
						Double tarifa = Double.valueOf(evt.getNewValue().toString());
						Double cantidad = entityDet.getCantidad();

						Double ingresoTotal = cantidad * tarifa;
						entityDet.setIngresoTotal(ingresoTotal);

					}

					if (columnaCell.equals("VLR. Total($)")) {

						entityDet.setIngresoTotal(Double.valueOf(evt.getNewValue().toString()));

					}

					if (columnaCell.equals("Turno")) {

						entityDet.setTurno(evt.getNewValue().toString());

					}
					if (columnaCell.equals("Obs")) {

						entityDet.setObservacion(evt.getNewValue().toString());

					}
					if (columnaCell.equals("¿En mtto?: SI/NO")) {

						entityDet.setReportarNovedadParada(evt.getNewValue().toString());

					}

					if (columnaCell.equals("Tipo Mtto")) {

						entityDet.setTipoMttoTexto(evt.getNewValue().toString());

					}

					if (columnaCell.equals("Hór. Mtto")) {
						entityDet.setHorometroMtto(Double.valueOf(evt.getNewValue().toString()));

					}

					else if (columnaCell.equals("Id Planilla")) {

						Long datServRealizadosEquipoId2 = new Long(evt.getNewValue().toString());
						DatServRealizadosEquipo datServRealizadosEquipo = businessDelegatorView
								.getDatServRealizadosEquipo(datServRealizadosEquipoId2);
						if (datServRealizadosEquipo != null) {
							entityDet.setDatServRealizadosEquipoId(datServRealizadosEquipo);
						}
					}

					else if (columnaCell.equals("Id Programa")) {

						Long datPlanServicioMaq = new Long(evt.getNewValue().toString());
						DatPlanServiciosMqdet e = businessDelegatorView.getDatPlanServiciosMqdet(datPlanServicioMaq);

						entityDet.setDat_plan_servicios_mqdet_id(e);
						if (e.getLabor() != null) {
							entityDet.setLabor(e.getLabor());
							Double valorUnitarioTrabajador = 0.0;
							Double cantidad = entityDet.getCantidad();
							if (e.getUdadMed() != null && e.getLabor() != null && txtFechaRegistro.getValue() != null) {
								Long idCompania = new Long(getCompaniaIdSession());
								Long idUdadMed = e.getUdadMed().getUdadMedId();
								Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));
								Long idLabor = e.getLabor().getLaborId();

								valorUnitarioTrabajador = businessDelegatorView.consultarTarifaLaborRendimientoBase(
										idCompania, 0L, idLabor, 0L, idUdadMed, idFecha).doubleValue();
							}

							entityDet.setValor_unitario_trabajador(valorUnitarioTrabajador);
							Double valorTotalTrabajador = cantidad * valorUnitarioTrabajador;
							entityDet.setValor_total_trabajador(valorTotalTrabajador);

						}
						if (e.getPersEmpr() != null) {
							entityDet.setPersEmpr(e.getPersEmpr());
						}

						if (e.getNivel2Clientesmq() != null) {
							entityDet.setNivel2ClientesId(e.getNivel2Clientesmq());
						}

						if (e.getNivel4ClientesmqId() != null) {
							entityDet.setNivel4ClientesId(e.getNivel4ClientesmqId());
						}

					}

					// entity =
					// businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
					// entityDet.setDatServRealizadosEquipoId(entity);
					businessDelegatorView.updateDatServRealizadosEquipoDet(entityDet);

					Long idmaq = FacesUtils.checkLong(txtEquipoId_Equipo);
					Long consecutivoPin = FacesUtils.checkLong(txtConsecutivo);

					if (idmaq != null) {
						Object[] condicionCtrlPines = { "equipo.equipoId", true, idmaq, "=" };
						List<DatCtrlMaqPines> listaCtrlPines = (idmaq != null)
								? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicionCtrlPines, null, null)
								: null;
						if (listaCtrlPines != null && listaCtrlPines.size() > 0) {
							DatCtrlMaqPines datCtrlMaqPines = listaCtrlPines.get(0);

							Long consecutivoInicial = datCtrlMaqPines.getConsecutivoPin();
							if (consecutivoInicial >= consecutivoPin) {
								businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoInicial);
							} else {
								businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoPin);
							}

						}
					}

					/**** actualizo la programación ***/

					if (entityDet.getLabor() != null) {
						Long laborId = entityDet.getLabor().getLaborId();
						Labor labor = businessDelegatorView.getLabor(laborId);
						if (labor.getClaseLabor() != null) {
							if (!labor.getClaseLabor().equals("Transporte")) {
								Long idPrograma = 0L;
								if (entityDet.getDat_plan_servicios_mqdet_id() != null) {
									idPrograma = entityDet.getDat_plan_servicios_mqdet_id()
											.getDatPlanServiciosMqdetId();
									businessDelegator2View.pr_actualizar_prog_maquinaria(idPrograma);

								}
							}
						}
					}
					// entity = null;

					selectedDatServDet = null;
					entityDet = null;

					dataServDet = null;
					dataServDet = businessDelegatorView
							.getDataDatServRealizadosEquipoDetByServ(datServRealizadosEquipoId);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));

		}

	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {
		Long datServRealizadosEquipoId = FacesUtils.checkLong(txtDatServRealizadosEquipoId);
		if (datServRealizadosEquipoId != null) {

			selectedataDetPrecioProductos = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedataDetPrecioProductos"));

			Long precioProdId = selectedataDetPrecioProductos.getPrecioProdId().longValue();

			String columnaCell = evt.getColumn().getHeaderText();

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null) {

				entityPrecioProd = null;
				entityPrecioProd = businessDelegatorView.getPrecioPromProd(precioProdId);

				if (columnaCell.equals("Fecha")) {

					entityPrecioProd.setFechaInicial((Date) newValue);

				}
				if (columnaCell.equals("Almacen")) {

					Long almacenId = new Long(evt.getNewValue().toString());
					Almacen e = businessDelegatorView.getAlmacen(almacenId);

					entityPrecioProd.setAlmacenId(e);

				}
				if (columnaCell.equals("Producto")) {

					Long productoId = new Long(evt.getNewValue().toString());
					Producto e = businessDelegatorView.getProducto(productoId);

					entityPrecioProd.setProducto(e);

				}

				if (columnaCell.equals("Cantidad")) {

					entityPrecioProd.setCantidadCompra(Double.valueOf(evt.getNewValue().toString()));

					Double cantidad = Double.valueOf(evt.getNewValue().toString());
					Double tarifa = entityPrecioProd.getValorUnitario();

					Double costoTotal = cantidad * tarifa;
					entityPrecioProd.setCostoTotal(costoTotal);

				}
				if (columnaCell.equals("Hórometro abast.")) {

					entityPrecioProd.setHorometro_abastecimiento(Double.valueOf(evt.getNewValue().toString()));

				}
				if (columnaCell.equals("VL. Unitario($)")) {

					entityPrecioProd.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));
					Double tarifa = Double.valueOf(evt.getNewValue().toString());
					Double cantidad = entityPrecioProd.getCantidadCompra();

					Double costoTotal = cantidad * tarifa;
					entityPrecioProd.setCostoTotal(costoTotal);
				}

				if (columnaCell.equals("VLR. Total($)")) {

					entityPrecioProd.setCostoTotal(Double.valueOf(evt.getNewValue().toString()));

				}

				if (columnaCell.equals("InfoAdicional")) {

					entityPrecioProd.setInfoAdicional(evt.getNewValue().toString());

				}

				entity = businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
				entityPrecioProd.setDatServRealizadosEquipoId(entity);
				businessDelegatorView.updatePrecioPromProd(entityPrecioProd);

				selectedataDetPrecioProductos = null;
				entityPrecioProd = null;

				dataDetPrecioProductos = null;
				dataDetPrecioProductos = businessDelegator2View
						.getDataProductosByServRealizados(datServRealizadosEquipoId);

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"Para poder modificar la información, primero los datos deben estar grabados. "));
			}
		}

	}

	public DatServRealizadosEquipoDet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatServRealizadosEquipoDet entityDet) {
		this.entityDet = entityDet;
	}

	public PrecioPromProd getEntityPrecioProd() {
		return entityPrecioProd;
	}

	public void setEntityPrecioProd(PrecioPromProd entityPrecioProd) {
		this.entityPrecioProd = entityPrecioProd;
	}

	public SelectItem[] getSelectDatPlanServicioMaq() {

		try {

			List<ConsultaProgLaboresMaqDTO> lista = null;

			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");

			Long flagEquipo = 1L;
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);

			GregorianCalendar calendarInicial = new GregorianCalendar();
			calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -120);

			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();

			Date fechaInicial = null;
			Date fechaFinal = null;

			GregorianCalendar calendarFinal = new GregorianCalendar();

			calendarFinal.setTime(date); // Configuramos la fecha que se
			calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 1);

			lista = businessDelegator2View.pr_consulta_lista_prog_maquinaria(compania, calendarInicial.getTime(),
					calendarFinal.getTime());

			if (lista != null) {
				selectDatPlanServicioMaq = new SelectItem[lista.size()];

				int i = 0;
				for (ConsultaProgLaboresMaqDTO dto : lista) {
					selectDatPlanServicioMaq[i] = new SelectItem(dto.getId_programa().longValue(),
							dto.getId_programa() + " *Labor* " + dto.getNom_labor() + " *Hda* " + dto.getNom_finca()
									+ " *Ste* " + dto.getNom_lote()

					);
					i++;

				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatPlanServicioMaq;
	}

	public void setSelectDatPlanServicioMaq(SelectItem[] selectDatPlanServicioMaq) {
		this.selectDatPlanServicioMaq = selectDatPlanServicioMaq;
	}

	public SelectItem[] getSelectDatServRealizadosEquipo() {

		try {

			List<ConsultaServiciosRealizadosMaquinariaDTO> lista = null;

			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));

			GregorianCalendar calendarInicial = new GregorianCalendar();
			GregorianCalendar calendarFinal = new GregorianCalendar();

			if (fechaInicial != null) {
				calendarInicial.setTime(fechaInicial); // Configuramos la fecha que se
				calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -5);

				calendarFinal.setTime(fechaInicial); // Configuramos la fecha que se
				calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 5);

				String equipoId = FacesUtils.checkString(txtEquipoId_Equipo);

				lista = businessDelegator2View.consultaServRealizadosMq(compania, calendarInicial.getTime(),
						calendarFinal.getTime(), equipoId, 0L);

				if (lista != null) {
					selectDatServRealizadosEquipo = new SelectItem[lista.size()];

					int i = 0;
					for (ConsultaServiciosRealizadosMaquinariaDTO consultaServiciosRealizadosMaquinariaDTO : lista) {
						selectDatServRealizadosEquipo[i] = new SelectItem(
								consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id().longValue(),
								consultaServiciosRealizadosMaquinariaDTO.getCodEquipo() + " *ID* "
										+ consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id()
										+ " *Fecha* "
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(8, 10)
										+ "/"
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(5, 7)
										+ "/"
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(0, 4)
										+ " *Consec* " + consultaServiciosRealizadosMaquinariaDTO.getConsecutivo()

						);
						i++;

					}
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatServRealizadosEquipo;
	}

	public void setSelectDatServRealizadosEquipo(SelectItem[] selectDatServRealizadosEquipo) {
		this.selectDatServRealizadosEquipo = selectDatServRealizadosEquipo;
	}

	public SelectOneMenu getTxtIdProgramacion() {
		return txtIdProgramacion;
	}

	public void setTxtIdProgramacion(SelectOneMenu txtIdProgramacion) {
		this.txtIdProgramacion = txtIdProgramacion;
	}

	public void listener_CalculoCantidadM3() {
		try {
			Long laborId = null;
			Double valorUnit = 0.0;
			Double rendimiento = 0.0;
			Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicalMq);
			Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinalMq);
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			Double horas = 0.0;
			if (txtLaborId_Labor.getValue() != null) {
				laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());

				Labor labor = businessDelegatorView.getLabor(laborId);
				// txtNombreLaborMaq.setValue(labor.getNombre());
				if (labor.getRendimientoMq() == null) {

					txtCantidad.setValue(cantidad);
				} else {
					if (labor.getRendimientoMq() > 0) {
						rendimiento = labor.getRendimientoMq();
						horas = horometroFinal - horometroInicial;
						cantidad = horas * rendimiento;
						txtCantidad.setValue(cantidad);
					}
				}

			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public SelectItem[] getSelectDatPlanServicioMaqRegistro() {

		try {

			List<ConsultaProgLaboresMaqDTO> lista = null;

			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");

			Long flagEquipo = 1L;
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);
			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();

			Date fechaInicial = null;
			Date fechaFinal = null;

			GregorianCalendar calendarInicial = new GregorianCalendar();
			calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -90);

			GregorianCalendar calendarFinal = new GregorianCalendar();

			calendarFinal.setTime(date); // Configuramos la fecha que se
			calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 1);

			lista = businessDelegator2View.pr_consulta_lista_prog_maquinaria(compania, calendarInicial.getTime(),
					calendarFinal.getTime());

			if (lista != null) {
				selectDatPlanServicioMaqRegistro = new SelectItem[lista.size()];

				int i = 0;
				for (ConsultaProgLaboresMaqDTO dto : lista) {
					selectDatPlanServicioMaqRegistro[i] = new SelectItem(dto.getId_programa().longValue(),
							dto.getId_programa() + " *Labor* " + dto.getNom_labor() + " *Hda* " + dto.getNom_finca()
									+ " *Ste* " + dto.getNom_lote()

					);
					i++;

				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatPlanServicioMaqRegistro;
	}

	public void setSelectDatPlanServicioMaqRegistro(SelectItem[] selectDatPlanServicioMaqRegistro) {
		this.selectDatPlanServicioMaqRegistro = selectDatPlanServicioMaqRegistro;
	}

	public SelectOneMenu getTxtEstadoFactura() {
		return txtEstadoFactura;
	}

	public void setTxtEstadoFactura(SelectOneMenu txtEstadoFactura) {
		this.txtEstadoFactura = txtEstadoFactura;
	}

}
