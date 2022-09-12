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
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.DatOtrosCostosMq;
import co.com.arcosoft.modelo.DatOtrosCostosMqdet;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
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
public class DatOtrosCostosMqView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosMqView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	// private SelectOneMenu txtEquipoId;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	// private InputText txtInfraId;
	private InputText txtNumFactura;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private SelectOneMenu txtReglaDistribuccion;
	private InputText txtSerieFactura;
	private SelectOneMenu txtTipoTransaccion;
	private InputText txtUsuarioDigitacion;
	private Spinner txtValorTotal;
	// private InputText txtCentCostId_CentCost;
	// private InputText txtElemCostoId_ElementoCosto;
	// private InputText txtLaborId_Labor;
	// private InputText txtPersEmprId_PersEmpr;
	private InputText txtDatOtrosCostosMqId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;

	private DatOtrosCostosMqDTO selectedDatOtrosCostos;
	private CostosIndirectosEquipoDTO selectedDatOtrosCostos2;
	private DatOtrosCostosMq entity;
	private DatOtrosCostosMqdet entityDet;

	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private Calendar txtFechaInicial;

	private SelectOneMenu txtInfraId;
	SelectItem[] selectInfraestructura;

	private SelectOneMenu txtEquipoId;
	SelectItem[] selectEquipo;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;

	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;

	/** detalle nivel4 */

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;

	private InputText txtNivel4Nombre;
	private InputText txtNivel2Nombre;
	private InputText txtNombreProducto;
	private InputText txtNombreUdadMed;

	private InputText txtNombreEquipo;
	private Spinner txtPorcentaje;
	private SelectOneMenu txtOrigenDatos;

	private CommandButton btnAgregar;

	private List<DatOtrosCostosMqdetDTO> dataMqdet;

	private DatOtrosCostosMqdetDTO selectedDatOtrosCostosMqdet;

	private InputNumber txtCantidad;
	private InputNumber txtCostoTotal;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;

	private SelectOneMenu txtUdadMedIdProducto;
	SelectItem[] selectUdadMedProducto;
	private List<UdadMed> udadMedProducto;
	private InputText txtValorUnit;

	private InputTextarea txtDescripcion;
	/*****/

	private int activeTapIndex = 0;
	private String moduloActivo;

	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectCategoriaEquipo;

	private List<DatOtrosCostosMqDTO> data;

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectPersEmpr;
	
	private SelectOneMenu txtPersEmprConsulta;
	SelectItem[] selectPersEmprConsulta;

	private InputNumber txtHorometroServicio;

	private List<ListaEquiposCategoriaDTO> dataEquiposCategoriaDTO;
	private List<CostosIndirectosEquipoDTO> data2;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputNumber txtValorTotalAcumulado;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;
	
	private InputText txtDocumento;
	private InputText txtDocumentoFactura;
	
	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;
	private List<PersEmpr> contratistas;
	SelectItem[] selectCentCostEdit;

	public DatOtrosCostosMqView() {
		super();
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Object contextPath = peticion.getContextPath();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();

			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			txtOrigenDatos.setValue("Modulo_TallerAgricola");
			txtOrigenDatos.setDisabled(false);

		} else {

			txtOrigenDatos.setValue("Modulo_MttoIndustrial");
			txtOrigenDatos.setDisabled(false);

		}
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String action_new() throws NumberFormatException, Exception {
		action_clear();
		selectedDatOtrosCostos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws NumberFormatException, Exception {
		entity = null;
		selectedDatOtrosCostos = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;
		moduloSeleccionado();
		
		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}
		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}
		if (txtValorTotalAcumulado != null) {
			txtValorTotalAcumulado.setValue(null);
			txtValorTotalAcumulado.setDisabled(false);
		}
		if (txtConsecutivo != null) {
			Long compania = new Long(getCompaniaIdSession());
			txtConsecutivo.setValue(businessDelegatorView.consultarConsecutivoOtrosCostosMq(compania));
			txtConsecutivo.setDisabled(true);
		}

		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
		}

		if (txtEquipoId != null) {
			txtEquipoId.setValue(null);
			txtEquipoId.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
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

		if (txtInfraId != null) {
			txtInfraId.setValue(null);
			txtInfraId.setDisabled(false);
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

		if (txtReglaDistribuccion != null) {
			txtReglaDistribuccion.setValue(null);
			txtReglaDistribuccion.setDisabled(false);
		}

		if (txtSerieFactura != null) {
			txtSerieFactura.setValue(null);
			txtSerieFactura.setDisabled(false);
		}

		if (txtTipoTransaccion != null) {
			txtTipoTransaccion.setValue(null);
			txtTipoTransaccion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(false);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
		}
		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(false);
		}
		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			Date date = new Date();
			txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtDatOtrosCostosMqId != null) {
			txtDatOtrosCostosMqId.setValue(null);
			txtDatOtrosCostosMqId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(false);
		}

		/************ + Detalle otros costos nivel4 ****/

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}
		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtNivel2Nombre != null) {
			txtNivel2Nombre.setValue(null);
			txtNivel2Nombre.setDisabled(false);
		}
		if (txtNivel4Nombre != null) {
			txtNivel4Nombre.setValue(null);
			txtNivel4Nombre.setDisabled(false);
		}

		if (txtNombreEquipo != null) {
			txtNombreEquipo.setValue(null);
			txtNombreEquipo.setDisabled(false);
		}
		if (txtPorcentaje != null) {
			txtPorcentaje.setValue(null);
			txtPorcentaje.setDisabled(false);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(false);
		}

		if (txtCantidad != null) {
			txtCantidad.setValue(1);
			txtCantidad.setDisabled(false);
		}

		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(0);
			txtCostoTotal.setDisabled(false);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}
		if (txtUdadMedIdProducto != null) {
			txtUdadMedIdProducto.setValue(null);
			txtUdadMedIdProducto.setDisabled(false);
		}
		if (txtValorUnit != null) {
			txtValorUnit.setValue(null);
			txtValorUnit.setDisabled(false);
		}

		if (txtNombreProducto != null) {
			txtNombreProducto.setValue(null);
			txtNombreProducto.setDisabled(false);
		}

		if (txtNombreUdadMed != null) {
			txtNombreUdadMed.setValue(null);
			txtNombreUdadMed.setDisabled(false);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (dataMqdet != null) {
			dataMqdet = null;

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

		selectedDatOtrosCostos2 = (CostosIndirectosEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosCostos2"));
		try {

			Long datOtrosCostosMqId = selectedDatOtrosCostos2.getOtrosCostosMqId().longValue();
			Object[] condicion = { "datOtrosCostosMqId", true, datOtrosCostosMqId, "=" };
			List<DatOtrosCostosMq> lista = (datOtrosCostosMqId != null)
					? businessDelegatorView.findByCriteriaInDatOtrosCostosMq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtOrigenDatos.setDisabled(false);
				txtOrigenDatos.setValue(entity.getOrigenDatos());

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				// txtFechaInicial.setValue(entity.getFechaInicial());
				// txtFechaInicial.setDisabled(false);

				// txtEquipoId.setValue(selectedDatOtrosCostos.getEquipoId());
				// txtEquipoId.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				txtNumFactura.setValue(entity.getNumFactura());
				txtNumFactura.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				// txtSerieFactura.setValue(selectedDatOtrosCostos.getSerieFactura());
				// txtSerieFactura.setDisabled(false);
				// txtValorTotal.setValue(entity.getValorTotal());
				// txtValorTotal.setDisabled(false);
			
				 txtCentCostId_CentCost.setDisabled(false);
				// txtElemCostoId_ElementoCosto.setValue(selectedDatOtrosCostos.getElemCostoId_ElementoCosto());
				// txtElemCostoId_ElementoCosto.setDisabled(false);

				txtDatOtrosCostosMqId.setValue(entity.getDatOtrosCostosMqId());
				txtDatOtrosCostosMqId.setDisabled(true);
				btnSave.setDisabled(false);

				txtTipoTransaccion.setValue(entity.getTipoTransaccion());
				txtTipoTransaccion.setDisabled(false);

				Long id = FacesUtils.checkLong(txtDatOtrosCostosMqId);

				dataMqdet = null;
				dataMqdet = businessDelegatorView.getDataDatOtrosCostosMqdetByMaquinaria(id);
				double subTotalValorTotal = 0;
				double impuestos = 0;
				double valorTotal = 0;
				if (dataMqdet != null && dataMqdet.size() >= 0) {
					for (DatOtrosCostosMqdetDTO data1 : dataMqdet) {
						subTotalValorTotal += (data1.getCostoTotal().doubleValue());

						valorTotal += data1.getCostoTotal().doubleValue();
					}
				}
				txtValorTotalAcumulado.setValue(valorTotal);
				txtValorTotalAcumulado.setDisabled(false);

				 txtPersEmprId.setValue(null);
				 txtPersEmprId.setDisabled(false);
				// txtEquipoId.setDisabled(false);
				txtLaborId_Labor.setDisabled(false);
				txtImplemento.setDisabled(false);
				txtCantidad.setDisabled(false);
				txtCostoTotal.setDisabled(false);

				btnAgregar.setDisabled(false);

				activeTapIndex = 0;

				setShowDialog(true);
			}

		} catch (

		Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatOtrosCostos == null) && (entity == null)) {
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
			entity = new DatOtrosCostosMq();

			// Long datOtrosCostosMqId =
			// FacesUtils.checkLong(txtDatOtrosCostosMqId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setTipoGasto("gasto_operacion_maquina");
			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			// entity.setDatOtrosCostosMqId(datOtrosCostosMqId);
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));

			entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setReglaDistribuccion(FacesUtils.checkString(txtReglaDistribuccion));
			entity.setSerieFactura(FacesUtils.checkString(txtSerieFactura));
			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
			// entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			// entity.setValorTotal(FacesUtils.checkDouble(txtCostoTotal));
	//		entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
		//			? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
		//			: null);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto) != null)
					? businessDelegatorView.getElementoCosto(FacesUtils.checkLong(txtElemCostoId_ElementoCosto))
					: null);
			// entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
			// ? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) :
			// null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);

			entity.setCategoria((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo) != null)
					? businessDelegatorView.getCategoriaEquipo(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo))
					: null);

			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 30);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -900);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				String tipoTransaccion = "";
				if (txtTipoTransaccion.getValue() != null) {
					tipoTransaccion = txtTipoTransaccion.getValue().toString();
					if (tipoTransaccion.equals("distri_categorias")) {
						Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
						if (categoria != null) {
							dataEquiposCategoriaDTO = businessDelegator2View.pr_lista_equipo(categoria);
							if (dataEquiposCategoriaDTO != null && dataEquiposCategoriaDTO.size() > 0) {
								// businessDelegatorView.saveDatOtrosCostosMqVer2(entity,
								// dataEquiposCategoriaDTO);
								businessDelegatorView.saveDatOtrosCostosMq(entity, dataMqdet, null);
								Long idOtrosCostosMq = businessDelegator2View
										.pr_max_id_unico_dat_otros_costos_mq(compania);
								Long recalculoOtrosCostosMq = businessDelegator2View
										.pr_recalcular_otros_costosmq(idOtrosCostosMq);

								FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
								action_clear();
							} else {
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Upps! La categoría que ha seleccionado para distribuir los productos no tiene máquinas asociadas, la información no sera grabada ",
										""));
							}
						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
											"Verifique que el campo categoría tenga datos. "));
						}
					}
					if (tipoTransaccion.equals("distri_equipos_informados")) {
						if (dataMqdet != null) {
							businessDelegatorView.saveDatOtrosCostosMq(entity, dataMqdet, null);
							// Long idOtrosCostosMq =
							// businessDelegatorView.pr_max_id_unico_dat_otros_costos_mq(compania) ;
							// Long recalculoOtrosCostosMq =
							// businessDelegatorView.pr_recalcular_otros_costosmq(idOtrosCostosMq) ;
							FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
							action_clear();
						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
											"Falta seleccionar la maquinaría asociada al gasto de operación "));
							selectedDatOtrosCostos = null;
							entity = null;
						}
					}

				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

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
				Long datOtrosCostosMqId = new Long(selectedDatOtrosCostos.getDatOtrosCostosMqId());
				entity = businessDelegatorView.getDatOtrosCostosMq(datOtrosCostosMqId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setTipoGasto("gasto_operacion_maquina");
			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));

			entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setReglaDistribuccion(FacesUtils.checkString(txtReglaDistribuccion));
			entity.setSerieFactura(FacesUtils.checkString(txtSerieFactura));
			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
			// entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			// entity.setValorTotal(FacesUtils.checkDouble(txtCostoTotal));
		//	entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
		////			? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
			//		: null);
			entity.setElementoCosto((FacesUtils.checkLong(txtElemCostoId_ElementoCosto) != null)
					? businessDelegatorView.getElementoCosto(FacesUtils.checkLong(txtElemCostoId_ElementoCosto))
					: null);
			// entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
			// ? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor)) :
			// null);
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);
			entity.setCategoria((FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo) != null)
					? businessDelegatorView.getCategoriaEquipo(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo))
					: null);
			Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);

			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 30);
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());

			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -900);
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

			if (fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {

				String tipoTransaccion = "";
				if (txtTipoTransaccion.getValue() != null) {
					tipoTransaccion = txtTipoTransaccion.getValue().toString();
					if (tipoTransaccion.equals("distri_categorias")) {
						Long id = FacesUtils.checkLong(txtDatOtrosCostosMqId);
						businessDelegator2View.pr_borrar_maq_otros_costosmq(id);
						Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
						if (categoria != null) {
							dataEquiposCategoriaDTO = businessDelegator2View.pr_lista_equipo(categoria);
							if (dataEquiposCategoriaDTO != null && dataEquiposCategoriaDTO.size() > 0) {
								businessDelegatorView.updateDatOtrosCostosMq(entity, dataMqdet, null);
								// businessDelegatorView.updateDatOtrosCostosMqVer2(entity,
								// dataEquiposCategoriaDTO);
								// Long idOtrosCostosMq = FacesUtils.checkLong(txtDatOtrosCostosMqId); ;
								// Long recalculoOtrosCostosMq =
								// businessDelegatorView.pr_recalcular_otros_costosmq(idOtrosCostosMq) ;
								FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
								action_clear();
							} else {
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Upps! La categoría que ha seleccionado para distribuir los productos no tiene máquinas asociadas, la información no sera grabada ",
										""));
							}
						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN,
											"Upps! Verifique que el campo categoría tenga datos.", " "));

						}
					}
					if (tipoTransaccion.equals("distri_equipos_informados")) {
						if (dataMqdet != null) {
							businessDelegatorView.updateDatOtrosCostosMq(entity, dataMqdet, null);
							// Long idOtrosCostosMq = FacesUtils.checkLong(txtDatOtrosCostosMqId); ;
							// Long recalculoOtrosCostosMq =
							// businessDelegatorView.pr_recalcular_otros_costosmq(idOtrosCostosMq) ;
							FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
							action_clear();
						} else {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_WARN,
											"Upps! Falta seleccionar la maquinaría asociada al gasto de operación",
											""));

						}
					}

				}

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "", ""));

			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatOtrosCostos = (DatOtrosCostosMqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostos"));

			Long datOtrosCostosMqId = new Long(selectedDatOtrosCostos.getDatOtrosCostosMqId());
			entity = businessDelegatorView.getDatOtrosCostosMq(datOtrosCostosMqId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datOtrosCostosMqId = FacesUtils.checkLong(txtDatOtrosCostosMqId);
			entity = businessDelegatorView.getDatOtrosCostosMq(datOtrosCostosMqId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatOtrosCostosMq(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws NumberFormatException, Exception {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatOtrosCostos = (DatOtrosCostosMqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostos"));

			Long datOtrosCostosMqId = new Long(selectedDatOtrosCostos.getDatOtrosCostosMqId());
			entity = businessDelegatorView.getDatOtrosCostosMq(datOtrosCostosMqId);
			businessDelegatorView.deleteDatOtrosCostosMq(entity);
			data.remove(selectedDatOtrosCostos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datOtrosCostosMqId, Long equipoId,
			String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, Date fechaRegistro,
			String infoAdicional, String infoAdicional2, Long infraId, String numFactura, String observacion,
			String observacionAnularReg, String reglaDistribuccion, String serieFactura, String tipoTransaccion,
			Long usuarioDigitacion, Double valorTotal, Long centCostId_CentCost, Long elemCostoId_ElementoCosto,
			Long laborId_Labor, Long persEmprId_PersEmpr) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNumFactura(FacesUtils.checkString(numFactura));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setReglaDistribuccion(FacesUtils.checkString(reglaDistribuccion));
			entity.setSerieFactura(FacesUtils.checkString(serieFactura));
			entity.setTipoTransaccion(FacesUtils.checkString(tipoTransaccion));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorTotal(FacesUtils.checkDouble(valorTotal));
			businessDelegatorView.updateDatOtrosCostosMq(entity, dataMqdet, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatOtrosCostosMqView").requestRender();
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

	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
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

	public SelectOneMenu getTxtReglaDistribuccion() {
		return txtReglaDistribuccion;
	}

	public void setTxtReglaDistribuccion(SelectOneMenu txtReglaDistribuccion) {
		this.txtReglaDistribuccion = txtReglaDistribuccion;
	}

	public InputText getTxtSerieFactura() {
		return txtSerieFactura;
	}

	public void setTxtSerieFactura(InputText txtSerieFactura) {
		this.txtSerieFactura = txtSerieFactura;
	}

	public SelectOneMenu getTxtTipoTransaccion() {
		return txtTipoTransaccion;
	}

	public void setTxtTipoTransaccion(SelectOneMenu txtTipoTransaccion) {
		this.txtTipoTransaccion = txtTipoTransaccion;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public Spinner getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(Spinner txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public SelectOneMenu getTxtInfraId() {
		return txtInfraId;
	}

	public void setTxtInfraId(SelectOneMenu txtInfraId) {
		this.txtInfraId = txtInfraId;
	}

	public SelectOneMenu getTxtEquipoId() {
		return txtEquipoId;
	}

	public void setTxtEquipoId(SelectOneMenu txtEquipoId) {
		this.txtEquipoId = txtEquipoId;
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

	public InputText getTxtDatOtrosCostosMqId() {
		return txtDatOtrosCostosMqId;
	}

	public void setTxtDatOtrosCostosMqId(InputText txtDatOtrosCostosMqId) {
		this.txtDatOtrosCostosMqId = txtDatOtrosCostosMqId;
	}

	public List<DatOtrosCostosMqDTO> getData() {
		try {
			if (data == null) {
				moduloSeleccionado();
				String modulo = txtOrigenDatos.getValue().toString();
				data = businessDelegatorView.getDataDatOtrosCostosMq();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatOtrosCostosMqDTO> datOtrosCostosDTO) {
		this.data = datOtrosCostosDTO;
	}

	public DatOtrosCostosMqDTO getSelectedDatOtrosCostosMq() {
		return selectedDatOtrosCostos;
	}

	public void setSelectedDatOtrosCostosMq(DatOtrosCostosMqDTO datOtrosCostos) {
		this.selectedDatOtrosCostos = datOtrosCostos;
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

	public SelectOneMenu getTxtNivel1Id() {
		return txtNivel1Id;
	}

	public void setTxtNivel1Id(SelectOneMenu txtNivel1Id) {
		this.txtNivel1Id = txtNivel1Id;
	}

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
	}

	public SelectOneMenu getTxtNivel2Id_Nivel2() {
		return txtNivel2Id_Nivel2;
	}

	public void setTxtNivel2Id_Nivel2(SelectOneMenu txtNivel2Id_Nivel2) {
		this.txtNivel2Id_Nivel2 = txtNivel2Id_Nivel2;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public InputText getTxtNivel4Nombre() {
		return txtNivel4Nombre;
	}

	public void setTxtNivel4Nombre(InputText txtNivel4Nombre) {
		this.txtNivel4Nombre = txtNivel4Nombre;
	}

	public InputText getTxtNivel2Nombre() {
		return txtNivel2Nombre;
	}

	public void setTxtNivel2Nombre(InputText txtNivel2Nombre) {
		this.txtNivel2Nombre = txtNivel2Nombre;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<DatOtrosCostosMqdetDTO> getDataNivel4() {
		return dataMqdet;
	}

	public void setDataNivel4(List<DatOtrosCostosMqdetDTO> dataMqdet) {
		this.dataMqdet = dataMqdet;
	}

	/**************** DETALLE DE AGREGAR PANTALLA ****/

	public List<DatOtrosCostosMqdetDTO> getDatOtrosCostosMqdet1() {

		if (dataMqdet == null || dataMqdet.size() == 0) {
			return null;
		} else {
			return dataMqdet;
		}

	}

	public void action_agregarDatOtrosCostosMqdet() throws Exception {
		if (txtLaborId_Labor.getValue() != null && txtCostoTotal.getValue() != null && txtCantidad.getValue() != null
				&& txtPersEmprId.getValue() != null) {
			String equipos = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				for (int i = 0; i < selectedEquipo.size(); i++) {
					equipos = selectedEquipo.get(i);

					Double totalMaquinas = (double) selectedEquipo.size();

					Long equipoId = Long.parseLong(equipos);
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);
					String nombreEquipo = equipo.getCodigo();

					String nombreLabor = "";
					Long laborId = null;
					Labor labor = null;
					if (txtLaborId_Labor.getValue() != null) {
						laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
						labor = businessDelegatorView.getLabor(laborId);
						nombreLabor = labor.getNombre();
					}

					String nombrePersEmpr = "";
					Long persEmprId = null;
					PersEmpr persEmpr = null;
					if (txtPersEmprId.getValue() != null) {
						persEmprId = Long.parseLong(txtPersEmprId.getValue().toString());
						persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
						nombrePersEmpr = persEmpr.getNombre();
					}

					String nombreImplemento = "";
					Long implementoId = null;
					Equipo implemento = null;
					if (txtImplemento.getValue() != null) {
						implementoId = Long.parseLong(txtImplemento.getValue().toString());
						implemento = businessDelegatorView.getEquipo(implementoId);
						nombreImplemento =  implemento.getCodigo() +"-"+implemento.getNombre();
					}
					String descripcion = FacesUtils.checkString(txtObservacion);
					Double horometroServicio = FacesUtils.checkDouble(txtHorometroServicio);
					Double cantidad = FacesUtils.checkDouble(txtCantidad);

					Double costoTotal = FacesUtils.checkDouble(txtCostoTotal);
					Double costoTotalFinal = (double) Math.round((costoTotal / totalMaquinas) * 100) / 100;

					String nroFactura = FacesUtils.checkString(txtNumFactura);
					Long centCostId = null;
					CentCost centCost = null;
					String nombreCentCost = "";
					if (txtCentCostId_CentCost.getValue() != null) {
						centCostId = FacesUtils.checkLong(txtCentCostId_CentCost);
						centCost = businessDelegatorView.getCentCost(centCostId);
						nombreCentCost = centCost.getNombre();
					}
					if (dataMqdet == null) {
						dataMqdet = new ArrayList<DatOtrosCostosMqdetDTO>();
					}

					DatOtrosCostosMqdetDTO datOtrosCostosDDTO = new DatOtrosCostosMqdetDTO();
					datOtrosCostosDDTO.setEquipoId_Equipo(equipo);
					datOtrosCostosDDTO.setNombreEquipo(nombreEquipo);
					datOtrosCostosDDTO.setCantidad(cantidad);
					datOtrosCostosDDTO.setCostoTotal(costoTotalFinal);
					datOtrosCostosDDTO.setValorUnitario(costoTotalFinal);
					datOtrosCostosDDTO.setDescripcion(descripcion);
					datOtrosCostosDDTO.setLabor(labor);
					datOtrosCostosDDTO.setNombreLabor(nombreLabor);
					datOtrosCostosDDTO.setPersEmpr(persEmpr);
					datOtrosCostosDDTO.setNombrePersEmpr(nombrePersEmpr);
					datOtrosCostosDDTO.setHorometroServicio(horometroServicio);
					datOtrosCostosDDTO.setNroFactura(nroFactura);
					
					datOtrosCostosDDTO.setCodImplemento(nombreImplemento);
					datOtrosCostosDDTO.setImplementoId(implementoId);
					datOtrosCostosDDTO.setCentCostId_CentCost(centCostId);
					datOtrosCostosDDTO.setNombreCentroCosto(nombreCentCost);
					dataMqdet.add(datOtrosCostosDDTO);
					nombreLabor = null;
					labor = null;
					nombreEquipo = null;
					equipo = null;
					descripcion = null;
					cantidad = null;
					costoTotal = null;
					costoTotalFinal = null;
					nroFactura = null;
					nombrePersEmpr = null;
					persEmprId = null;
					persEmpr = null;
				}
			}

			double valorTotal = 0;
			if (dataMqdet != null && dataMqdet.size() > 0) {
				for (DatOtrosCostosMqdetDTO data1 : dataMqdet) {
					valorTotal += data1.getCostoTotal().doubleValue();
				}
			}

			txtValorTotalAcumulado.setValue(valorTotal);
			limpiar_pantalla();

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos máquinaria, gasto, y valor total tengan valores. "));

		}
	}

	public void listener_ConsultaUmProducto() {

		Long productoId = null;

		if (!txtProductoId_Producto.getValue().equals("")) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtUdadMedIdProducto.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				txtNombreProducto.setValue(producto.getNombre());
				Long udadMedId = Long.parseLong(txtUdadMedIdProducto.getValue().toString());

				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNombreUdadMed.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;
		if (FacesUtils.checkLong(txtUdadMedIdProducto) != null) {
			if (!txtUdadMedIdProducto.getValue().equals("")) {
				udadMedId = Long.parseLong(txtUdadMedIdProducto.getValue().toString());

				try {
					UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
					/* valNPass = datPlanLabor.getNPases(); */
					txtNombreUdadMed.setValue(udadMed.getNombre());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}
			}
		}

	}

	public void listener_calcularCostoTotal() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
		Double cantidad = FacesUtils.checkDouble(txtCantidad);
		Double result = 0.0;
		if (valorUnit != null && cantidad != null) {
			result = (valorUnit * cantidad);
			String format = decimalFormat.format(result);
			txtCostoTotal.setValue(format);
		} else {
			result = 0.0;
			txtCostoTotal.setValue(result);
		}

	}

	public void listener_ConsultaEquipo() {

		Long equipoId = null;

		if (!txtEquipoId.getValue().equals("")) {
			equipoId = Long.parseLong(txtEquipoId.getValue().toString());

			try {
				Equipo equipo = businessDelegatorView.getEquipo(equipoId);
				txtNombreEquipo.setValue(equipo.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_TipoDistribuccion() {

		String tipoDistri = FacesUtils.checkString(txtTipoTransaccion);

		if (tipoDistri != null) {
			if (tipoDistri.equals("distri_equipos_informados")) {
				txtCategEquipId_CategoriaEquipo.setDisabled(true);
				txtEquipoId.setDisabled(false);
				txtImplemento.setDisabled(false);
				btnAgregar.setDisabled(false);

			}
			if (tipoDistri.equals("distri_categorias")) {
				txtCategEquipId_CategoriaEquipo.setDisabled(false);
				txtEquipoId.setDisabled(true);
				txtImplemento.setDisabled(true);
				btnAgregar.setDisabled(true);
			}
		}
		if (tipoDistri.equals("")) {
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
			txtEquipoId.setDisabled(false);
			txtImplemento.setDisabled(false);
		}
	}

	/******** sesion de usuarios **/
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
				Long id = new Long(selectedDatOtrosCostos.getDatOtrosCostosMqId());
				entity = businessDelegatorView.getDatOtrosCostosMq(id);
			}

			Long id = FacesUtils.checkLong(txtDatOtrosCostosMqId);

			dataMqdet = null;
			dataMqdet = businessDelegatorView.getDataDatOtrosCostosMqdetByMaquinaria(id);

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatOtrosCostosMq(entity, dataMqdet, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) throws NumberFormatException, Exception {

		action_clear();
		selectedDatOtrosCostos = (DatOtrosCostosMqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosCostos"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String actionDeleteOtrosCostosMqdet(ActionEvent evt) {
		try {

			selectedDatOtrosCostosMqdet = (DatOtrosCostosMqdetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostosMqdet"));

			if (selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId() == null) {
				dataMqdet.remove(selectedDatOtrosCostosMqdet);
			} else {
				Long datOtrosCostosNivel4Id = new Long(selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId());
				DatOtrosCostosMqdet entity = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosNivel4Id);
				businessDelegatorView.deleteDatOtrosCostosMqdet(entity);
				dataMqdet.remove(selectedDatOtrosCostosMqdet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectItem[] getSelectCentCost() {

		if (selectCentCost == null || selectCentCost.length == 0) {

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

	public void setSelectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getSelectElementoCosto() {

		if (selectElementoCosto == null || selectElementoCosto.length == 0) {

			try {
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

	public void setSelectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
	}

	public SelectItem[] getSelectContratista() {

		if (selectContratista == null || selectContratista.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="							
						, "tipoEmpresa", true, "4", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"  };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre()+"-"+contratista.getCodigo());
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

	public SelectItem[] getSelectLaborId() {

		if (selectLaborId == null || selectLaborId.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion", "=" };
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

	public void setSelectLaborId(SelectItem[] selectLaborId) {
		this.selectLaborId = selectLaborId;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtNombreEquipo() {
		return txtNombreEquipo;
	}

	public void setTxtNombreEquipo(InputText txtNombreEquipo) {
		this.txtNombreEquipo = txtNombreEquipo;
	}

	public Spinner getTxtPorcentaje() {
		return txtPorcentaje;
	}

	public void setTxtPorcentaje(Spinner txtPorcentaje) {
		this.txtPorcentaje = txtPorcentaje;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public List<DatOtrosCostosMqdetDTO> getDataMqdet() {
		return dataMqdet;
	}

	public void setDataMqdet(List<DatOtrosCostosMqdetDTO> dataMqdet) {
		this.dataMqdet = dataMqdet;
	}

	public InputText getTxtNombreProducto() {
		return txtNombreProducto;
	}

	public void setTxtNombreProducto(InputText txtNombreProducto) {
		this.txtNombreProducto = txtNombreProducto;
	}

	public InputText getTxtNombreUdadMed() {
		return txtNombreUdadMed;
	}

	public void setTxtNombreUdadMed(InputText txtNombreUdadMed) {
		this.txtNombreUdadMed = txtNombreUdadMed;
	}

	public InputNumber getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputNumber txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public InputNumber getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputNumber txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public SelectOneMenu getTxtUdadMedIdProducto() {
		return txtUdadMedIdProducto;
	}

	public void setTxtUdadMedIdProducto(SelectOneMenu txtUdadMedIdProducto) {
		this.txtUdadMedIdProducto = txtUdadMedIdProducto;
	}

	public List<UdadMed> getUdadMedProducto() {
		return udadMedProducto;
	}

	public void setUdadMedProducto(List<UdadMed> udadMedProducto) {
		this.udadMedProducto = udadMedProducto;
	}

	public InputText getTxtValorUnit() {
		return txtValorUnit;
	}

	public void setTxtValorUnit(InputText txtValorUnit) {
		this.txtValorUnit = txtValorUnit;
	}

	public SelectItem[] getSelectProductoId() {

		if (selectProductoId == null || selectProductoId.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoId = new SelectItem[lista.size()];

				int i = 0;
				for (Producto productoId : lista) {
					selectProductoId[i] = new SelectItem(productoId.getProductoId(), productoId.getNombre());
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

	public SelectItem[] getSelectUdadMedProducto() {

		if (selectUdadMedProducto == null || selectUdadMedProducto.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedProducto = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedProducto[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedProducto;
	}

	public void setSelectUdadMedProducto(SelectItem[] selectUdadMedProducto) {
		this.selectUdadMedProducto = selectUdadMedProducto;
	}

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public SelectItem[] getSelectCategoriaEquipo() {

		if (selectCategoriaEquipo == null || selectCategoriaEquipo.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<CategoriaEquipo> lista = businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null,
						null);
				selectCategoriaEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CategoriaEquipo categoriaEquipo : lista) {
					selectCategoriaEquipo[i] = new SelectItem(categoriaEquipo.getCategEquipId(),
							categoriaEquipo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCategoriaEquipo;
	}

	public void setSelectCategoriaEquipo(SelectItem[] selectCategoriaEquipo) {
		this.selectCategoriaEquipo = selectCategoriaEquipo;
	}

	public SelectOneMenu getTxtCategEquipId_CategoriaEquipo() {
		return txtCategEquipId_CategoriaEquipo;
	}

	public void setTxtCategEquipId_CategoriaEquipo(SelectOneMenu txtCategEquipId_CategoriaEquipo) {
		this.txtCategEquipId_CategoriaEquipo = txtCategEquipId_CategoriaEquipo;
	}

	public List<ListaEquiposCategoriaDTO> getDataEquiposCategoriaDTO() {
		return dataEquiposCategoriaDTO;
	}

	public void setDataEquiposCategoriaDTO(List<ListaEquiposCategoriaDTO> dataEquiposCategoriaDTO) {
		this.dataEquiposCategoriaDTO = dataEquiposCategoriaDTO;
	}

	public void listarOtrosCostosMq() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			String tipogasto = "gasto_operacion_maquina";
		
			Long compania = new Long(getCompaniaIdSession());
			
			Long documento = 0L;
			documento = FacesUtils.checkLong(txtDocumento);

			if (documento == null) {
				documento = 0L;
			}
			
			Long centCost = 0L;
			centCost = FacesUtils.checkLong(txtCentCostConsulta);

			if (centCost == null) {
				centCost = 0L;
			}
			Long flagContratista = 0L;
			flagContratista = FacesUtils.checkLong(txtPersEmprConsulta);

			if (flagContratista == null) {
				flagContratista = 0L;
			}
			
			String documentof = "0";
			documentof = FacesUtils.checkString(txtDocumentoFactura);

			if (documentof == null) {
				documentof = "0";
			}
			
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_otrosmq(compania, fechaInicial, fechaFinal, tipogasto,documento, centCost,flagContratista, documentof);
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
						"No existen datos asociados a la consulta "));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<CostosIndirectosEquipoDTO> getData2() {
		return data2;
	}

	public void setData2(List<CostosIndirectosEquipoDTO> data2) {
		this.data2 = data2;
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

	public SelectItem[] getSelectEquipo() {

		if (selectEquipo == null || selectEquipo.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",

						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"
					};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(),
							equipo.getCodigo() + "-" + equipo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipo;
	}

	public void setSelectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public void limpiar_pantalla() {
		txtObservacion.setValue(null);
		equipos = null;
		selectEquipo = null;
		txtPersEmprId.setValue(null);
		txtCantidad.setValue(1);
		txtCostoTotal.setValue(null);
		txtLaborId_Labor.setValue(null);
		txtHorometroServicio.setValue(null);
		txtImplemento.setValue(null);
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		Long datOtrosCostosMq = FacesUtils.checkLong(txtDatOtrosCostosMqId);
		if (datOtrosCostosMq != null) {
			selectedDatOtrosCostosMqdet = (DatOtrosCostosMqdetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostosMqdet"));
			if (selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId() != null) {
				Long datOtrosCostosMqdetId = selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId().longValue();

				String columnaCell = evt.getColumn().getHeaderText();
				Object newValue = evt.getNewValue();

				if (newValue != null) {

					entityDet = null;
					entityDet = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);

					if (columnaCell.equals("Maq")) {

						Long maqId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(maqId);

						entityDet.setEquipo(e);

					}if (columnaCell.equals("CeCos")) {

						Long ceCosId = new Long(evt.getNewValue().toString());
						CentCost centCost = businessDelegatorView.getCentCost(ceCosId);

						entityDet.setCentCost(centCost);

					} else if (columnaCell.equals("VR. Total")) {

						entityDet.setCostoTotal(Double.valueOf(evt.getNewValue().toString()));

					} else if (columnaCell.equals("Gasto")) {

						Long laborId = new Long(evt.getNewValue().toString());
						Labor e = businessDelegatorView.getLabor(laborId);

						entityDet.setLabor(e);

					} else if (columnaCell.equals("Detalle")) {

						entityDet.setDescripcion(String.valueOf(evt.getNewValue().toString()));

					} else if (columnaCell.equals("Prov.")) {

						Long persEmprId = new Long(evt.getNewValue().toString());
						PersEmpr e = businessDelegatorView.getPersEmpr(persEmprId);

						entityDet.setPersEmpr(e);

					} else if (columnaCell.equals("Horometro")) {

						entityDet.setHorometroServicio(Double.valueOf(evt.getNewValue().toString()));
					}else if (columnaCell.equals("Implemento")) {

						Long impId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(impId);

						entityDet.setImplementoId(e);

					} 

					entity = businessDelegatorView.getDatOtrosCostosMq(datOtrosCostosMq);
					entityDet.setDatOtrosCostosMq(entity);
					businessDelegatorView.updateDatOtrosCostosMqdet(entityDet);

					selectedDatOtrosCostosMqdet = null;
					entityDet = null;
					dataMqdet = null;

					dataMqdet = businessDelegatorView.getDataDatOtrosCostosMqdetByMaquinaria(datOtrosCostosMq);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));
		}

	}

	public DatOtrosCostosMq getEntity() {
		return entity;
	}

	public void setEntity(DatOtrosCostosMq entity) {
		this.entity = entity;
	}

	public DatOtrosCostosMqdet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatOtrosCostosMqdet entityDet) {
		this.entityDet = entityDet;
	}

	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatOtrosCostos2 = (CostosIndirectosEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatOtrosCostos2"));
		try {

			Long datOtrosCostosMqId = selectedDatOtrosCostos2.getOtrosCostosMqId().longValue();
			Object[] condicion = { "datOtrosCostosMqId", true, datOtrosCostosMqId, "=" };
			List<DatOtrosCostosMq> lista = (datOtrosCostosMqId != null)
					? businessDelegatorView.findByCriteriaInDatOtrosCostosMq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {
						Long borrarDetalle = businessDelegator2View
								.pr_borrar_dat_otros_costos_mq_detalle(datOtrosCostosMqId);
						Long borrarDistribuccion = businessDelegator2View
								.pr_borrar_equipos_otros_costosmqdistr(datOtrosCostosMqId);
						Long borrarGeneral = businessDelegator2View.pr_borrar_dat_otros_costos_mq(datOtrosCostosMqId);

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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public SelectItem[] getSelectPersEmpr() {

		if (selectPersEmpr == null || selectPersEmpr.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="
						, "tipoEmpresa", true, "4", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"  };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectPersEmpr = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectPersEmpr[i] = new SelectItem(contratista.getPersEmprId(), contratista.getCodigo() +"-"+contratista.getNombre());
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

	public InputNumber getTxtHorometroServicio() {
		return txtHorometroServicio;
	}

	public void setTxtHorometroServicio(InputNumber txtHorometroServicio) {
		this.txtHorometroServicio = txtHorometroServicio;
	}

	public List<String> getSelectedEquipo() {
		selectedEquipo = null;
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, 
						"Modulo_TallerAgricola", "=" ,
						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"		
				};
				equipos = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);

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


	public SelectItem[] getSelectImplemento() {

		if (implemento == null || implemento.size() == 0) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" ,
					 
						"categoriaEquipo.funcion", true, "Tractor", "<>",
						"categoriaEquipo.funcion", true, "Motobomba/Electrogeno", "<>",
									};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo Implemento : lista) {
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(),Implemento.getCodigo()+"-"+ Implemento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectImplemento;
	}

	public void setSelectImplemento(SelectItem[] selectImplemento) {
		this.selectImplemento = selectImplemento;
	}

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	public SelectOneMenu getTxtCentCostConsulta() {
		return txtCentCostConsulta;
	}

	 
	public void setTxtCentCostConsulta(SelectOneMenu txtCentCostConsulta) {
		this.txtCentCostConsulta = txtCentCostConsulta;
	}

	public void setSelectCentCostConsulta(SelectItem[] selectCentCostConsulta) {
		this.selectCentCostConsulta = selectCentCostConsulta;
	}
	public SelectItem[] getSelectCentCostConsulta() {

		if (selectCentCostConsulta == null || selectCentCostConsulta.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCostConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCostConsulta[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCostConsulta;
	}

	public InputText getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(InputText txtDocumento) {
		this.txtDocumento = txtDocumento;
	}
 
	public InputText getTxtDocumentoFactura() {
		return txtDocumentoFactura;
	}

	public void setTxtDocumentoFactura(InputText txtDocumentoFactura) {
		this.txtDocumentoFactura = txtDocumentoFactura;
	}

	public void validarExistenciaFactura() throws Exception {
		Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
		String  numFactura = FacesUtils.checkString(txtNumFactura);
		
		Object[] condicion = { "nroFactura", true, numFactura, "=", "persEmpr.persEmprId", true, persEmprId, "="  };
		List<DatOtrosCostosMqdet> lista = (persEmprId != null)
				? businessDelegatorView.findByCriteriaInDatOtrosCostosMqdet(condicion, null, null)
				: null;

		if (lista != null && lista.size() > 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Upps!, La factura registrada ya se encuentra en el sistema, válide por favor",""));
		}
	}
	
	public List<PersEmpr> getContratistas() throws Exception {
		if (contratistas == null || contratistas.size() == 0) {

			Object[] condicion = { "estado", true, "A", "="							
					, "tipoEmpresa", true, "4", "<>" 
					, "tipoEmpresa", true, "3", "<>"
					, "tipoEmpresa", true, "5", "<>"  };

			try {
				contratistas = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return contratistas;
	}

	public void setContratistas(List<PersEmpr> contratistas) {
		this.contratistas = contratistas;
	}

	public SelectItem[] getSelectPersEmprConsulta() {

		if (selectPersEmprConsulta == null || selectPersEmprConsulta.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="							
						, "tipoEmpresa", true, "4", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"};
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectPersEmprConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectPersEmprConsulta[i] = new SelectItem(contratista.getPersEmprId(), contratista.getCodigo() +"-"+contratista.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPersEmprConsulta;
	}

 
	
	public SelectOneMenu getTxtPersEmprConsulta() {
		return txtPersEmprConsulta;
	}

	public void setTxtPersEmprConsulta(SelectOneMenu txtPersEmprConsulta) {
		this.txtPersEmprConsulta = txtPersEmprConsulta;
	}

	public void setSelectPersEmprConsulta(SelectItem[] selectPersEmprConsulta) {
		this.selectPersEmprConsulta = selectPersEmprConsulta;
	}

 

	public SelectItem[] getSelectCentCostEdit() {

		if (selectCentCostEdit == null || selectCentCostEdit.length == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCostEdit = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCostEdit[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCostEdit;
	}

	public void setSelectCentCostEdit(SelectItem[] selectCentCostEdit) {
		this.selectCentCostEdit = selectCentCostEdit;
	}

}
