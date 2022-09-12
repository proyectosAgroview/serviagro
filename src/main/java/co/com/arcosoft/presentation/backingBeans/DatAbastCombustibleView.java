package co.com.arcosoft.presentation.backingBeans;

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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.BombaAbastecimiento;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatAbastCombustible;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoAbastecimiento;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.TurnoCampo;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatAbastCombustibleDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatAbastCombustibleView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatAbastCombustibleView.class);
	private InputText txtCantidad;
	private InputText txtCierreOt;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtCostoTotal;
	private SelectOneRadio txtEstado;
	private InputText txtMedidor;
	private Spinner txtNumeroPlanillaFisica;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtDatAbastCombustibleId;
	private InputText txtUsuarioDigitacion;
	private InputText txtValorUnitario;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCierreOt;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaReaperturaOt;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatAbastCombustibleDTO> data;
	private DatAbastCombustibleDTO selectedDatAbastCombustible;
	private DatAbastCombustible entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private Double result = 0.0;

	private SelectOneMenu txtTurnoCampoId;
	SelectItem[] selectTurnoCampoId;
	private List<TurnoCampo> turnoCampoId;

	private SelectOneMenu txtBombaAbastecimientoId_BombaAbastecimiento;
	SelectItem[] selectBombaAbastecimientoId;
	private List<BombaAbastecimiento> bombaAbastecimientoId;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCostId;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipoId;
	private List<Equipo> equipoId;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTipoAbastecimientoId_TipoAbastecimiento;
	SelectItem[] selectTipoAbastecimientoId;
	private List<TipoAbastecimiento> tipoAbastecimientoId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMedId;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtConductor;
	SelectItem[] selectConductor;
	private List<Trabajador> conductor;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private InputText txtVidaActual;
	
	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;


	public DatAbastCombustibleView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatAbastCombustibleDTO datAbastCombustibleDTO = (DatAbastCombustibleDTO) e.getObject();

			if (txtCantidad == null) {
				txtCantidad = new InputText();
			}

			txtCantidad.setValue(datAbastCombustibleDTO.getCantidad());

			if (txtCierreOt == null) {
				txtCierreOt = new InputText();
			}

			txtCierreOt.setValue(datAbastCombustibleDTO.getCierreOt());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datAbastCombustibleDTO.getCompania());

			if (txtConductor == null) {
				txtConductor = new SelectOneMenu();
			}

			txtConductor.setValue(datAbastCombustibleDTO.getConductor());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datAbastCombustibleDTO.getConsecutivo());

			if (txtCostoTotal == null) {
				txtCostoTotal = new InputText();
			}

			txtCostoTotal.setValue(datAbastCombustibleDTO.getCostoTotal());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datAbastCombustibleDTO.getEstado());

			if (txtMedidor == null) {
				txtMedidor = new InputText();
			}

			txtMedidor.setValue(datAbastCombustibleDTO.getMedidor());

			if (txtNumeroPlanillaFisica == null) {
				txtNumeroPlanillaFisica = new Spinner();
			}

			txtNumeroPlanillaFisica.setValue(datAbastCombustibleDTO.getNumeroPlanillaFisica());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datAbastCombustibleDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datAbastCombustibleDTO.getObservacionAnularReg());

			if (txtTurnoCampoId == null) {
				txtTurnoCampoId = new SelectOneMenu();
			}

			txtTurnoCampoId.setValue(datAbastCombustibleDTO.getTurnoCampoId());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datAbastCombustibleDTO.getUsuarioDigitacion());

			if (txtValorUnitario == null) {
				txtValorUnitario = new InputText();
			}

			txtValorUnitario.setValue(datAbastCombustibleDTO.getValorUnitario());

			if (txtBombaAbastecimientoId_BombaAbastecimiento == null) {
				txtBombaAbastecimientoId_BombaAbastecimiento = new SelectOneMenu();
			}

			txtBombaAbastecimientoId_BombaAbastecimiento
					.setValue(datAbastCombustibleDTO.getBombaAbastecimientoId_BombaAbastecimiento());

			if (txtCentCostId_CentCost == null) {
				txtCentCostId_CentCost = new SelectOneMenu();
			}

			txtCentCostId_CentCost.setValue(datAbastCombustibleDTO.getCentCostId_CentCost());

			if (txtEquipoId_Equipo == null) {
				txtEquipoId_Equipo = new SelectOneMenu();
			}

			txtEquipoId_Equipo.setValue(datAbastCombustibleDTO.getEquipoId_Equipo());

			if (txtProductoId_Producto == null) {
				txtProductoId_Producto = new SelectOneMenu();
			}

			txtProductoId_Producto.setValue(datAbastCombustibleDTO.getProductoId_Producto());

			if (txtTipoAbastecimientoId_TipoAbastecimiento == null) {
				txtTipoAbastecimientoId_TipoAbastecimiento = new SelectOneMenu();
			}

			txtTipoAbastecimientoId_TipoAbastecimiento
					.setValue(datAbastCombustibleDTO.getTipoAbastecimientoId_TipoAbastecimiento());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(datAbastCombustibleDTO.getTrabId_Trabajador());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new SelectOneMenu();
			}

			txtUdadMedId_UdadMed.setValue(datAbastCombustibleDTO.getUdadMedId_UdadMed());

			if (txtDatAbastCombustibleId == null) {
				txtDatAbastCombustibleId = new InputText();
			}

			txtDatAbastCombustibleId.setValue(datAbastCombustibleDTO.getDatAbastCombustibleId());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datAbastCombustibleDTO.getFechaAnulacion());

			if (txtFechaCierreOt == null) {
				txtFechaCierreOt = new Calendar();
			}

			txtFechaCierreOt.setValue(datAbastCombustibleDTO.getFechaCierreOt());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datAbastCombustibleDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datAbastCombustibleDTO.getFechaModificacion());

			if (txtFechaReaperturaOt == null) {
				txtFechaReaperturaOt = new Calendar();
			}

			txtFechaReaperturaOt.setValue(datAbastCombustibleDTO.getFechaReaperturaOt());

			if (txtFechaRegistro == null) {
				txtFechaRegistro = new Calendar();
			}

			txtFechaRegistro.setValue(datAbastCombustibleDTO.getFechaRegistro());

			Long datAbastCombustibleId = FacesUtils.checkLong(txtDatAbastCombustibleId);
			entity = businessDelegatorView.getDatAbastCombustible(datAbastCombustibleId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatAbastCombustible = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatAbastCombustible = null;

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(false);
		}

		if (txtCierreOt != null) {
			txtCierreOt.setValue(null);
			txtCierreOt.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtConductor != null) {
			txtConductor.setValue(null);
			txtConductor.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(null);
			txtCostoTotal.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtMedidor != null) {
			txtMedidor.setValue(null);
			txtMedidor.setDisabled(true);
		}

		if (txtNumeroPlanillaFisica != null) {
			txtNumeroPlanillaFisica.setValue(null);
			txtNumeroPlanillaFisica.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtTurnoCampoId != null) {
			txtTurnoCampoId.setValue(null);
			txtTurnoCampoId.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(false);
		}

		if (txtBombaAbastecimientoId_BombaAbastecimiento != null) {
			txtBombaAbastecimientoId_BombaAbastecimiento.setValue(null);
			txtBombaAbastecimientoId_BombaAbastecimiento.setDisabled(false);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}

		if (txtTipoAbastecimientoId_TipoAbastecimiento != null) {
			txtTipoAbastecimientoId_TipoAbastecimiento.setValue(null);
			txtTipoAbastecimientoId_TipoAbastecimiento.setDisabled(false);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCierreOt != null) {
			txtFechaCierreOt.setValue(null);
			txtFechaCierreOt.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaReaperturaOt != null) {
			txtFechaReaperturaOt.setValue(null);
			txtFechaReaperturaOt.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtVidaActual != null) {
			txtVidaActual.setValue(null);
			txtVidaActual.setDisabled(true);
		}

		if (txtDatAbastCombustibleId != null) {
			txtDatAbastCombustibleId.setValue(null);
			txtDatAbastCombustibleId.setDisabled(false);
		}

		if (txtAlmacenId_Almacen != null) {
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	public void listener_calcularCostoTotal() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
		Double cantidadAplicada = FacesUtils.checkDouble(txtCantidad);

		if (valorUnit != null && cantidadAplicada != null) {
			result = (valorUnit * cantidadAplicada);
			String format = decimalFormat.format(result);
			txtCostoTotal.setValue(format);
		} else {
			result = 0.0;
			txtCostoTotal.setValue(result);
		}

	}

	public void listener_txtFechaAnulacion() {
		Date inputDate = (Date) txtFechaAnulacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCierreOt() {
		Date inputDate = (Date) txtFechaCierreOt.getValue();
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

	public void listener_txtFechaReaperturaOt() {
		Date inputDate = (Date) txtFechaReaperturaOt.getValue();
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

	

	public void ConsultarPrecioPromProductoDet() throws Exception {
		// Long compania = 1L;

		Long idCompania = new Long(getCompaniaIdSession());
		Long idProducto = FacesUtils.checkLong(txtProductoId_Producto);
		Long idAlmacen = FacesUtils.checkLong(txtAlmacenId_Almacen);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedId_UdadMed);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		if (idUdadMed != null) {
			try {

				Double valorUnitario = businessDelegatorView.consultarPrecioPromProducto(idProducto, idAlmacen, idCompania,
						idFecha);
				String format = decimalFormat.format(valorUnitario);
				txtValorUnitario.setValue(format);
				if (valorUnitario == null) {
					BigDecimal tarifaInsumosNoEncontrada = new BigDecimal("0");
					txtValorUnitario.setValue(tarifaInsumosNoEncontrada);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatAbastCombustible = (DatAbastCombustibleDTO) (evt.getComponent().getAttributes()
				.get("selectedDatAbastCombustible"));
		try {

			Long consecutivo = selectedDatAbastCombustible.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatAbastCombustible> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatAbastCombustible(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCantidad.setValue(entity.getCantidad());
				txtCantidad.setDisabled(false);
				txtConductor.setValue(entity.getConductor());
				txtConductor.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtCostoTotal.setValue(entity.getCostoTotal());
				txtCostoTotal.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				//txtMedidor.setValue(entity.getMedidor());
				//txtMedidor.setDisabled(false);
				txtNumeroPlanillaFisica.setValue(entity.getNumeroPlanillaFisica());
				txtNumeroPlanillaFisica.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtTurnoCampoId.setValue(entity.getTurnoCampoId());
				txtTurnoCampoId.setDisabled(false);
				txtValorUnitario.setValue(entity.getValorUnitario());
				txtValorUnitario.setDisabled(false);
				
				if(entity.getBombaAbastecimiento()!=null){
				txtBombaAbastecimientoId_BombaAbastecimiento
						.setValue(entity.getBombaAbastecimiento().getBombaAbastecimientoId());
				}
				txtBombaAbastecimientoId_BombaAbastecimiento.setDisabled(false);
				//txtCentCostId_CentCost.setValue(selectedDatAbastCombustible.getCentCostId_CentCost());
			//	txtCentCostId_CentCost.setDisabled(false);
				txtEquipoId_Equipo.setValue(selectedDatAbastCombustible.getEquipoId_Equipo());
				txtEquipoId_Equipo.setDisabled(false);
				txtProductoId_Producto.setValue(selectedDatAbastCombustible.getProductoId_Producto());
				txtProductoId_Producto.setDisabled(false);
				
				if(entity.getTipoAbastecimiento()!=null){
					txtTipoAbastecimientoId_TipoAbastecimiento
							.setValue(entity.getTipoAbastecimiento().getTipoAbastecimientoId());
				}
				txtTipoAbastecimientoId_TipoAbastecimiento.setDisabled(false);
				txtTrabId_Trabajador.setValue(selectedDatAbastCombustible.getTrabId_Trabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtUdadMedId_UdadMed.setValue(selectedDatAbastCombustible.getUdadMedId_UdadMed());
				txtUdadMedId_UdadMed.setDisabled(false);
				txtDatAbastCombustibleId.setValue(entity.getDatAbastCombustibleId());
				txtDatAbastCombustibleId.setDisabled(true);
				txtAlmacenId_Almacen.setValue(entity.getAlmacenId());
				txtAlmacenId_Almacen.setDisabled(false);
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
			if ((selectedDatAbastCombustible == null) && (entity == null)) {
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
			entity = new DatAbastCombustible();

			// Long datAbastCombustibleId =
			// FacesUtils.checkLong(txtDatAbastCombustibleId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			//entity.setCierreOt(FacesUtils.checkString(txtCierreOt));
			entity.setCompania(compania);
			entity.setConductor(FacesUtils.checkDouble(txtConductor));
			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoAbastecimientoCombustible(compania)));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			// entity.setDatAbastCombustibleId(datAbastCombustibleId);
			entity.setEstado("A");
			//entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			//entity.setFechaCierreOt(FacesUtils.checkDate(txtFechaCierreOt));
			entity.setFechaCreacion(date);
			//entity.setFechaReaperturaOt(FacesUtils.checkDate(txtFechaReaperturaOt));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setMedidor(FacesUtils.checkDouble(txtMedidor));
			entity.setNumeroPlanillaFisica(FacesUtils.checkLong(txtNumeroPlanillaFisica));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			//fentity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setTurnoCampoId(FacesUtils.checkLong(txtTurnoCampoId));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId_Almacen));
			entity.setBombaAbastecimiento(
					(FacesUtils.checkLong(txtBombaAbastecimientoId_BombaAbastecimiento) != null) ? businessDelegatorView
							.getBombaAbastecimiento(FacesUtils.checkLong(txtBombaAbastecimientoId_BombaAbastecimiento))
							: null);
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost)) : null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo)) : null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setTipoAbastecimiento(
					(FacesUtils.checkLong(txtTipoAbastecimientoId_TipoAbastecimiento) != null) ? businessDelegatorView
							.getTipoAbastecimiento(FacesUtils.checkLong(txtTipoAbastecimientoId_TipoAbastecimiento))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.saveDatAbastCombustible(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoAbastecimientoCombustible(compania) - 1));
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
				Long datAbastCombustibleId = new Long(selectedDatAbastCombustible.getDatAbastCombustibleId());
				entity = businessDelegatorView.getDatAbastCombustible(datAbastCombustibleId);
			}
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			//entity.setCierreOt(FacesUtils.checkString(txtCierreOt));
			entity.setConductor(FacesUtils.checkDouble(txtConductor));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			//entity.setEstado(FacesUtils.checkString(txtEstado));
			//entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			//entity.setFechaCierreOt(FacesUtils.checkDate(txtFechaCierreOt));
			entity.setFechaModificacion(date);
		//	entity.setFechaReaperturaOt(FacesUtils.checkDate(txtFechaReaperturaOt));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setMedidor(FacesUtils.checkDouble(txtMedidor));
			entity.setNumeroPlanillaFisica(FacesUtils.checkLong(txtNumeroPlanillaFisica));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			//entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setTurnoCampoId(FacesUtils.checkLong(txtTurnoCampoId));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setAlmacenId(FacesUtils.checkLong(txtAlmacenId_Almacen));
			
			entity.setBombaAbastecimiento(
					(FacesUtils.checkLong(txtBombaAbastecimientoId_BombaAbastecimiento) != null) ? businessDelegatorView
							.getBombaAbastecimiento(FacesUtils.checkLong(txtBombaAbastecimientoId_BombaAbastecimiento))
							: null);
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost)) : null);
			entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo)) : null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto)) : null);
			entity.setTipoAbastecimiento(
					(FacesUtils.checkLong(txtTipoAbastecimientoId_TipoAbastecimiento) != null) ? businessDelegatorView
							.getTipoAbastecimiento(FacesUtils.checkLong(txtTipoAbastecimientoId_TipoAbastecimiento))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.updateDatAbastCombustible(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatAbastCombustible.getDatAbastCombustibleId());
				entity = businessDelegatorView.getDatAbastCombustible(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatAbastCombustible(entity);
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
		selectedDatAbastCombustible = (DatAbastCombustibleDTO) (evt.getComponent().getAttributes()
				.get("selectedDatAbastCombustible"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatAbastCombustible = (DatAbastCombustibleDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAbastCombustible"));

			Long datAbastCombustibleId = new Long(selectedDatAbastCombustible.getDatAbastCombustibleId());
			entity = businessDelegatorView.getDatAbastCombustible(datAbastCombustibleId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datAbastCombustibleId = FacesUtils.checkLong(txtDatAbastCombustibleId);
			entity = businessDelegatorView.getDatAbastCombustible(datAbastCombustibleId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatAbastCombustible(entity);
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
			selectedDatAbastCombustible = (DatAbastCombustibleDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAbastCombustible"));

			Long datAbastCombustibleId = new Long(selectedDatAbastCombustible.getDatAbastCombustibleId());
			entity = businessDelegatorView.getDatAbastCombustible(datAbastCombustibleId);
			businessDelegatorView.deleteDatAbastCombustible(entity);
			data.remove(selectedDatAbastCombustible);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidad, String cierreOt, Long compania, Double conductor,
			Long consecutivo, Double costoTotal, Long datAbastCombustibleId, String estado, Date fechaAnulacion,
			Date fechaCierreOt, Date fechaCreacion, Date fechaModificacion, Date fechaReaperturaOt, Date fechaRegistro,
			Double medidor, Long numeroPlanillaFisica, String observacion, String observacionAnularReg,
			Long turnoCampoId, Long usuarioDigitacion, Double valorUnitario,
			Long bombaAbastecimientoId_BombaAbastecimiento, Long centCostId_CentCost, Long equipoId_Equipo,
			Long productoId_Producto, Long tipoAbastecimientoId_TipoAbastecimiento, Long trabId_Trabajador,
			Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setCantidad(FacesUtils.checkDouble(cantidad));
			entity.setCierreOt(FacesUtils.checkString(cierreOt));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConductor(FacesUtils.checkDouble(conductor));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setCostoTotal(FacesUtils.checkDouble(costoTotal));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(fechaCierreOt));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaReaperturaOt(FacesUtils.checkDate(fechaReaperturaOt));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setMedidor(FacesUtils.checkDouble(medidor));
			entity.setNumeroPlanillaFisica(FacesUtils.checkLong(numeroPlanillaFisica));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setTurnoCampoId(FacesUtils.checkLong(turnoCampoId));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updateDatAbastCombustible(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatAbastCombustibleView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}


	public SelectItem[] getSelectProductoId() {
		if (productoId == null || productoId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				
				// Criteria
				List<CatalogProductoDTO> listaProductos= businessDelegatorView
						.consultarCatalogoProductosMtto(idCompania);
				selectProductoId = new SelectItem[listaProductos.size()];
				int i = 0;
				for (CatalogProductoDTO listaDTO : listaProductos) {
					selectProductoId[i] = new SelectItem(listaDTO.getProductoId().longValue(),
							listaDTO.getNombre()
					);
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return selectProductoId;
	}




	public void listener_ConsultaConductor() {

		Long idEquipo = null;
		if (txtEquipoId_Equipo.getValue() != null) {
			if (!txtEquipoId_Equipo.getValue().equals("")) {
				idEquipo = Long.parseLong(txtEquipoId_Equipo.getValue().toString());

				try {
					Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
					/* valNPass = datPlanLabor.getNPases(); */
					txtConductor.setValue(equipo.getTrabajador());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}

	}

	
	public void listener_ConsultaCodUdadMed() {

		Long idProducto = null;
		if (txtProductoId_Producto.getValue() != null) {
			if (!txtProductoId_Producto.getValue().equals("")) {
				idProducto = Long.parseLong(txtProductoId_Producto.getValue().toString());

				try {
					Producto producto = businessDelegatorView.getProducto(idProducto);
					/* valNPass = datPlanLabor.getNPases(); */
					txtUdadMedId_UdadMed.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}

	}

	public void setSelectProductoId(SelectItem[] selectProductoId) {
		this.selectProductoId = selectProductoId;
	}

	public SelectItem[] getSelectUdadMedId() {
		
		Producto prod = null;
		Long prodId = FacesUtils.checkLong(txtProductoId_Producto);

		if (prodId != null && !prodId.toString().isEmpty()) {

			try {
				
				prod= businessDelegatorView.getProducto(prodId);

				Object[] condicion = { "estado", true, "A", "=", "udadMedId",true,prod.getUdadMedByUdadMedProd().getUdadMedId(), "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedId = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedId[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedId;
	}

	public void setSelectUdadMedId(SelectItem[] selectUdadMedId) {
		this.selectUdadMedId = selectUdadMedId;
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
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

	public SelectItem[] getselectConductor() {

		if (conductor == null || conductor.size() == 0) {

			conductor = new ArrayList<Trabajador>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectConductor = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador Conductor : lista) {
					selectConductor[i] = new SelectItem(Conductor.getTrabId(), Conductor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConductor;
	}

	public void setselectConductor(SelectItem[] selectConductor) {
		this.selectConductor = selectConductor;
	}
	
	public void listener_validarMedidor() {

		Long equipoId_equipo = null;
		equipoId_equipo = FacesUtils.checkLong(txtEquipoId_Equipo);

		if (equipoId_equipo != null && !equipoId_equipo.toString().isEmpty()) {

			Equipo equipo = null;
			try {
				equipo = businessDelegatorView.getEquipo(equipoId_equipo);

				if (equipo.getMedidor() != null) {

					Medidor medidor = null;
					medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());

					if (medidor != null) {

						if (medidor.getTipoMedidor().equals("Horómetro")) {

							txtVidaActual.setValue(
									(equipo.getHorometroActual() != null) ? equipo.getHorometroActual() : null);
							txtMedidor.setDisabled(false);

						} else if (medidor.getTipoMedidor().equals("Odómetro")) {

							txtVidaActual
									.setValue((equipo.getOdometroActual() != null) ? equipo.getOdometroActual() : null);
							txtMedidor.setDisabled(false);

						} else if (medidor.getTipoMedidor().equals("Averiado")) {

							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_WARN, "Lo sentimos!",
									"El medidor de la maquinaria/equipo se encuentra averiado, por lo tando no podrás abastecer de combustible."));

							txtVidaActual.setDisabled(true);
							txtMedidor.setDisabled(true);
							txtVidaActual.setValue(null);
							txtMedidor.setValue(null);
							btnSave.setDisabled(true);

						}
					}
				} else {

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Lo sentimos!", "Debes asignar un medidor a la maquinaria/equipo antes de abastecer"));

					txtVidaActual.setDisabled(true);
					txtVidaActual.setValue(null);
					txtMedidor.setValue(null);
					txtMedidor.setDisabled(true);
					btnSave.setDisabled(true);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public SelectItem[] getselectEquipoId() {

		if (equipoId == null || equipoId.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true,"Modulo_TallerAgricola","="};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipoId = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipoId[i] = new SelectItem(equipo.getEquipoId(), equipo.getNombre());
					i++;

				}


			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipoId;
	}

	public void setselectEquipoId(SelectItem[] selectEquipoId) {
		this.selectEquipoId = selectEquipoId;
	}

	public SelectItem[] getselectCentCostId() {

		if (centCostId == null || centCostId.size() == 0) {

			centCostId = new ArrayList<CentCost>();

			try {

				centCostId = businessDelegatorView.getCentCost(); // Fin by
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

	public SelectItem[] getselectTurnoCampoId() {

		if (turnoCampoId == null || turnoCampoId.size() == 0) {

			turnoCampoId = new ArrayList<TurnoCampo>();

			try {

				turnoCampoId = businessDelegatorView.getTurnoCampo(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TurnoCampo> lista = businessDelegatorView.findByCriteriaInTurnoCampo(condicion, null, null);
				selectTurnoCampoId = new SelectItem[lista.size()];

				int i = 0;
				for (TurnoCampo turnoCampoId : lista) {
					selectTurnoCampoId[i] = new SelectItem(turnoCampoId.getTurnoCampoId(), turnoCampoId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTurnoCampoId;
	}

	public void setselectTurnoCampoId(SelectItem[] selectTurnoCampoId) {
		this.selectTurnoCampoId = selectTurnoCampoId;
	}

	public SelectItem[] getselectBombaAbastecimientoId() {

		if (bombaAbastecimientoId == null || bombaAbastecimientoId.size() == 0) {

			bombaAbastecimientoId = new ArrayList<BombaAbastecimiento>();

			try {

				bombaAbastecimientoId = businessDelegatorView.getBombaAbastecimiento(); // Fin
																						// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<BombaAbastecimiento> lista = businessDelegatorView.findByCriteriaInBombaAbastecimiento(condicion,
						null, null);
				selectBombaAbastecimientoId = new SelectItem[lista.size()];

				int i = 0;
				for (BombaAbastecimiento bombaAbastecimientoId : lista) {
					selectBombaAbastecimientoId[i] = new SelectItem(bombaAbastecimientoId.getBombaAbastecimientoId(),
							bombaAbastecimientoId.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectBombaAbastecimientoId;
	}

	public void setselectBombaAbastecimientoId(SelectItem[] selectBombaAbastecimientoId) {
		this.selectBombaAbastecimientoId = selectBombaAbastecimientoId;
	}

	public SelectItem[] getselectTipoAbastecimientoId() {

		if (tipoAbastecimientoId == null || tipoAbastecimientoId.size() == 0) {

			tipoAbastecimientoId = new ArrayList<TipoAbastecimiento>();

			try {

				tipoAbastecimientoId = businessDelegatorView.getTipoAbastecimiento(); // Fin
																						// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoAbastecimiento> lista = businessDelegatorView.findByCriteriaInTipoAbastecimiento(condicion,
						null, null);
				selectTipoAbastecimientoId = new SelectItem[lista.size()];

				int i = 0;
				for (TipoAbastecimiento tipoAbastecimientoId : lista) {
					selectTipoAbastecimientoId[i] = new SelectItem(tipoAbastecimientoId.getTipoAbastecimientoId(),
							tipoAbastecimientoId.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoAbastecimientoId;
	}

	
	public void setselectTipoAbastecimientoId(SelectItem[] selectTipoAbastecimientoId) {
		this.selectTipoAbastecimientoId = selectTipoAbastecimientoId;
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
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

	public SelectOneMenu getTxtConductor() {
		return txtConductor;
	}

	public void setTxtConductor(SelectOneMenu txtConductor) {
		this.txtConductor = txtConductor;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public InputText getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputText txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtMedidor() {
		return txtMedidor;
	}

	public void setTxtMedidor(InputText txtMedidor) {
		this.txtMedidor = txtMedidor;
	}

	public Spinner getTxtNumeroPlanillaFisica() {
		return txtNumeroPlanillaFisica;
	}

	public void setTxtNumeroPlanillaFisica(Spinner txtNumeroPlanillaFisica) {
		this.txtNumeroPlanillaFisica = txtNumeroPlanillaFisica;
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

	public SelectOneMenu getTxtTurnoCampoId() {
		return txtTurnoCampoId;
	}

	public void setTxtTurnoCampoId(SelectOneMenu txtTurnoCampoId) {
		this.txtTurnoCampoId = txtTurnoCampoId;
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

	public SelectOneMenu getTxtBombaAbastecimientoId_BombaAbastecimiento() {
		return txtBombaAbastecimientoId_BombaAbastecimiento;
	}

	public void setTxtBombaAbastecimientoId_BombaAbastecimiento(
			SelectOneMenu txtBombaAbastecimientoId_BombaAbastecimiento) {
		this.txtBombaAbastecimientoId_BombaAbastecimiento = txtBombaAbastecimientoId_BombaAbastecimiento;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public SelectOneMenu getTxtTipoAbastecimientoId_TipoAbastecimiento() {
		return txtTipoAbastecimientoId_TipoAbastecimiento;
	}

	public void setTxtTipoAbastecimientoId_TipoAbastecimiento(
			SelectOneMenu txtTipoAbastecimientoId_TipoAbastecimiento) {
		this.txtTipoAbastecimientoId_TipoAbastecimiento = txtTipoAbastecimientoId_TipoAbastecimiento;
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

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public Calendar getTxtFechaCierreOt() {
		return txtFechaCierreOt;
	}

	public void setTxtFechaCierreOt(Calendar txtFechaCierreOt) {
		this.txtFechaCierreOt = txtFechaCierreOt;
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

	public Calendar getTxtFechaReaperturaOt() {
		return txtFechaReaperturaOt;
	}

	public void setTxtFechaReaperturaOt(Calendar txtFechaReaperturaOt) {
		this.txtFechaReaperturaOt = txtFechaReaperturaOt;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public InputText getTxtDatAbastCombustibleId() {
		return txtDatAbastCombustibleId;
	}

	public void setTxtDatAbastCombustibleId(InputText txtDatAbastCombustibleId) {
		this.txtDatAbastCombustibleId = txtDatAbastCombustibleId;
	}

	public List<DatAbastCombustibleDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatAbastCombustible();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatAbastCombustibleDTO> datAbastCombustibleDTO) {
		this.data = datAbastCombustibleDTO;
	}

	public DatAbastCombustibleDTO getSelectedDatAbastCombustible() {
		return selectedDatAbastCombustible;
	}

	public void setSelectedDatAbastCombustible(DatAbastCombustibleDTO datAbastCombustible) {
		this.selectedDatAbastCombustible = datAbastCombustible;
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

	public InputText getTxtVidaActual() {
		return txtVidaActual;
	}

	public void setTxtVidaActual(InputText txtVidaActual) {
		this.txtVidaActual = txtVidaActual;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}


	public SelectItem[] getselectAlmacen() {

		if (almacen == null || almacen.size() == 0) {

			almacen = new ArrayList<Almacen>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(), almacen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	public void setselectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public List<TurnoCampo> getTurnoCampoId() {
		return turnoCampoId;
	}

	public void setTurnoCampoId(List<TurnoCampo> turnoCampoId) {
		this.turnoCampoId = turnoCampoId;
	}

	public List<UdadMed> getUdadMed() {
		return udadMed;
	}

	public void setUdadMed(List<UdadMed> udadMed) {
		this.udadMed = udadMed;
	}

	public List<Trabajador> getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}
	
	
}
