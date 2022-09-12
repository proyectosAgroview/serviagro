package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
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
public class PrecioPromProdImportacionMovilMaqView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PrecioPromProdImportacionMovilMaqView.class);
	private InputText txtCompania;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PrecioPromProdDTO> data;
	private List<ConsultaCompraProductosDTO> dataConsulta;
	private PrecioPromProdDTO selectedPrecioPromProd;
	private ConsultaCompraProductosDTO selectedPrecioPromProd2;
	private List<ConsultaCompraProductosDTO>selectedPrecioPromProd3;
	
	private PrecioPromProd entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	/** Campos de pantalla de precios por producto **/

	private Calendar fechaVencimiento;

	private SelectOneMenu txtUnidadMedida;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private InputText cantidadCompra;
	private InputText loteCompraProducto;
	private InputText registroIca;

	private SelectOneMenu txtPersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private InputText txtValorUnitario;
	private InputText txtPrecioProdId;

	private int activeTapIndex = 0;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTipoProdId_TipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	private InputText txtSaldo;
	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;
	private List<ConceptoKardex> conceptoKardex;

	private InputText txtConsecutivo;

	private SelectOneMenu txtAlmacenId;
	SelectItem[] selectAlmacen2;
	private List<Almacen> almacen2;
	/************** filtros ***/

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;

	private SelectOneMenu txtTipoProductoConsulta;
	SelectItem[] selectTipoProductoConsulta;
	private List<TipoProducto> tipoProductoConsulta;

	private SelectOneMenu txtProductoIdConsulta;
	SelectItem[] selectProductoIdConsulta;
	private List<Producto> productoIdConsulta;

	private Calendar txtFechaInicialConsulta;
	private Calendar txtFechaFinalConsulta;
	
	private InputText txtOrigenDatos;
	private   InputText txtHorometroAbastecimiento;
	
	private SelectOneMenu txtTipoMovimiento;

	private SelectOneMenu txtTipoMovimientoConsulta;

	private SelectOneMenu txtUsuarioAsociado;
	SelectItem[] selectUsuarioId;
	private List<Usuarios> usuarioId;
	
	
	private InputNumber txtTotalHoras;
	private InputNumber txtTotalGalones;
	private InputNumber txtGlnHoras;
	private InputNumber txtGlnHorasEstandar;
	private String colorGalonesHora;
	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	
	private SelectOneMenu txtDatServRealizadosEquipoId;
	SelectItem[] selectDatServRealizadosEquipo;
	private List<DatServRealizadosEquipo> servRealizadosEquipo;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;
	
	
	private SelectOneMenu txtDatMantenimientoEquipoId;
	SelectItem[] selectDatMantenimientoEquipoId;
	
	private List<String> selectedOrdenMtto;
	private List<SolicitudesMttoEquipoDTO> ordenMtto;
 

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;
	
	private SelectOneMenu txtUbicacionesAlmacen;
	SelectItem[] selectUbAlmacen;
	
	public PrecioPromProdImportacionMovilMaqView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedPrecioPromProd = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPrecioPromProd = null;
		activeTapIndex = 0;
		PrimeFaces.current().resetInputs(":frm");

		if (txtAlmacenId != null) {
			txtAlmacenId.setValue(null);
			txtAlmacenId.setDisabled(false);
		}
		
		
		
		if (txtHorometroAbastecimiento != null) {
			txtHorometroAbastecimiento.setValue(null);
			txtHorometroAbastecimiento.setDisabled(false);
		}
		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}
		if (txtUbicacionesAlmacen != null) {
			txtUbicacionesAlmacen.setValue(null);
			txtUbicacionesAlmacen.setDisabled(false);
		}

		if (txtConceptoKardex != null) {
			txtConceptoKardex.setValue(null);
			txtConceptoKardex.setDisabled(false);
		}

		if (txtSaldo != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(false);
		}
		if (txtDatMantenimientoEquipoId != null) {
			txtDatMantenimientoEquipoId.setValue(null);
			txtDatMantenimientoEquipoId.setDisabled(false);
		}
		
		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(false);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(false);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(false);
		}

		if (txtFechaInicial != null) {
			Date date = new Date();
			txtFechaInicial.setValue(date);
			txtFechaInicial.setDisabled(false);
		}
		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}
		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtPrecioProdId != null) {
			txtPrecioProdId.setValue(null);
			txtPrecioProdId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		if (txtTipoProdId_TipoProducto != null) {
			txtTipoProdId_TipoProducto.setValue(null);
			txtTipoProdId_TipoProducto.setDisabled(false);
		}

		// if (txtUdadMedId_UdadMed_Cosecha != null) {
		// txtUdadMedId_UdadMed_Cosecha.setValue(null);
		// txtUdadMedId_UdadMed_Cosecha.setDisabled(false);
		// }

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (fechaVencimiento != null) {
			fechaVencimiento.setValue(null);
			fechaVencimiento.setDisabled(false);
		}

		if (txtUnidadMedida != null) {
			txtUnidadMedida.setValue(null);
			txtUnidadMedida.setDisabled(false);
		}

		if (cantidadCompra != null) {
			cantidadCompra.setValue(null);
			cantidadCompra.setDisabled(false);
		}

		if (loteCompraProducto != null) {
			loteCompraProducto.setValue(null);
			loteCompraProducto.setDisabled(false);
		}
		
		if (txtTipoMovimiento != null) {
			txtTipoMovimiento.setValue(null);
			txtTipoMovimiento.setDisabled(false);
		}

		if (registroIca != null) {
			registroIca.setValue(null);
			registroIca.setDisabled(false);
		}

		if (txtPersEmpr != null) {
			txtPersEmpr.setValue(null);
			txtPersEmpr.setDisabled(false);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
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

	public String action_edit(ActionEvent evt) {
		selectedPrecioPromProd2 = (ConsultaCompraProductosDTO) (evt.getComponent().getAttributes()
				.get("selectedPrecioPromProd2"));
		try {

			Long precioProdId = selectedPrecioPromProd2.getPrecioProdid().longValue();
			Object[] condicion = { "precioProdId", true, precioProdId, "=" };
			List<PrecioPromProd> lista = (precioProdId != null)
					? businessDelegatorView.findByCriteriaInPrecioPromProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			
					txtAlmacenId.setValue(entity.getAlmacenId().getAlmacenId());
					txtAlmacenId.setDisabled(false);
					
					
					txtHorometroAbastecimiento.setValue(entity.getHorometro_abastecimiento());
					txtHorometroAbastecimiento.setDisabled(false);
					
					if(entity.getEquipoId()!=null) {
						txtEquipoId_Equipo.setValue(entity.getEquipoId().getEquipoId());
							
					}
					txtEquipoId_Equipo.setDisabled(false);
					txtUbicacionesAlmacen.setValue(null);
					if (entity.getUbicacionesAlmacen() != null) {
						txtUbicacionesAlmacen.setValue(entity.getUbicacionesAlmacen().getUbicacionesAlmacenId());

					}
					txtUbicacionesAlmacen.setDisabled(false);
					txtCentCostId_CentCost.setValue(null);
					if(entity.getCentCostId()!=null) {
					 txtCentCostId_CentCost.setValue(entity.getCentCostId());
					 txtCentCostId_CentCost.setDisabled(false);
					}
					
					txtImplemento.setValue(null);
					if (entity.getImplementoId() != null) {
					txtImplemento.setValue(entity.getImplementoId().getEquipoId());
					txtImplemento.setDisabled(false);
					}
				 
					if(entity.getDatServRealizadosEquipoId()!=null) {
						txtDatServRealizadosEquipoId.setValue(entity.getDatServRealizadosEquipoId().getDatServRealizadosEquipoId());
							
					}
					txtDatServRealizadosEquipoId.setDisabled(false);
					
					
					txtTipoMovimiento.setValue(entity.getTipoMovimiento());
					txtTipoMovimiento.setDisabled(false);
					
					txtFechaInicial.setValue(entity.getFechaInicial());
					txtFechaInicial.setDisabled(false);
					txtInfoAdicional.setValue(entity.getInfoAdicional());
					txtInfoAdicional.setDisabled(false);
					txtValorUnitario.setValue(entity.getValorUnitario());
					txtValorUnitario.setDisabled(false);
					if (entity.getConceptoKardexId() != null) {
						txtConceptoKardex.setValue(entity.getConceptoKardexId().getConceptoKardexId());

					}
					txtConceptoKardex.setDisabled(false);
					if (txtSaldo != null) {
						txtSaldo.setValue(null);
						txtSaldo.setDisabled(true);
					}

					if (entity.getConsecutivo() != null) {
						txtConsecutivo.setValue(entity.getConsecutivo());
					}
					txtConsecutivo.setDisabled(true);

					if (entity.getProducto() != null) {
						Long productoId = entity.getProducto().getProductoId();
						Producto producto = businessDelegatorView.getProducto(productoId);
						txtTipoProdId_TipoProducto.setValue(producto.getTipoProducto().getTipoProdId());
						txtTipoProdId_TipoProducto.setDisabled(true);
						txtProductoId_Producto.setValue(entity.getProducto().getProductoId());

					}
					txtProductoId_Producto.setDisabled(true);

					txtUnidadMedida.setValue(entity.getUnidadMedida().getUdadMedId());
					txtUnidadMedida.setDisabled(true);

					cantidadCompra.setValue(entity.getCantidadCompra());
					cantidadCompra.setDisabled(false);

					txtPrecioProdId.setValue(entity.getPrecioProdId());
					txtPrecioProdId.setDisabled(true);
					
					
					txtDatMantenimientoEquipoId.setValue(null);
					if(entity.getDatMantenimientoEquipoId()!=null) {
						txtDatMantenimientoEquipoId.setValue(entity.getDatMantenimientoEquipoId());
					}
					txtDatMantenimientoEquipoId.setDisabled(false);


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
			if ((selectedPrecioPromProd == null) && (entity == null)) {
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
			entity = new PrecioPromProd();

			// Long precioProdId = FacesUtils.checkLong(txtPrecioProdId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new  Long(getUsuarioIdSession());
			Date date = new Date();
			entity.setCompania(compania);
			entity.setFechaCreacion(date);
			entity.setAlmacenId((FacesUtils.checkLong(txtAlmacenId) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId))
					: null);
			entity.setUnidadMedida((FacesUtils.checkLong(txtUnidadMedida) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUnidadMedida))
					: null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);

			entity.setLoteCompraProducto(FacesUtils.checkString(loteCompraProducto));
			entity.setRegistroIca(FacesUtils.checkString(registroIca));
			entity.setCantidadCompra(FacesUtils.checkDouble(cantidadCompra));

			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));

			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));

			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto))
					: null);

			entity.setConceptoKardexId((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setCostoTotal(FacesUtils.checkDouble(txtValorUnitario) * FacesUtils.checkDouble(cantidadCompra));
			
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));

			entity.setHorometro_abastecimiento(FacesUtils.checkDouble(txtHorometroAbastecimiento));
			
			entity.setTipoMovimiento(FacesUtils.checkString(txtTipoMovimiento));
			
			
			entity.setDatServRealizadosEquipoId((FacesUtils.checkLong(txtDatServRealizadosEquipoId) != null)
					? businessDelegatorView.getDatServRealizadosEquipo(FacesUtils.checkLong(txtDatServRealizadosEquipoId))
					: null);
			
			entity.setEquipoId((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			
			entity.setDatMantenimientoEquipoId(FacesUtils.checkLong(txtDatMantenimientoEquipoId));
			
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));
			
			entity.setImplementoId((FacesUtils.checkLong(txtImplemento) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtImplemento))
					: null);
			entity.setUbicacionesAlmacen((FacesUtils.checkLong(txtUbicacionesAlmacen) != null)
					? businessDelegator2View.getUbicacionesAlmacen(FacesUtils.checkLong(txtUbicacionesAlmacen))
					: null);
			businessDelegatorView.savePrecioPromProd(entity);
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
				Long precioProdId = new Long(selectedPrecioPromProd.getPrecioProdId());
				entity = businessDelegatorView.getPrecioPromProd(precioProdId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			Long usuarioId = new  Long(getUsuarioIdSession());
			entity.setCompania(compania);
			entity.setFechaModificacion(date);
			
			entity.setAlmacenId((FacesUtils.checkLong(txtAlmacenId) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId))
					: null);
			entity.setUnidadMedida((FacesUtils.checkLong(txtUnidadMedida) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUnidadMedida))
					: null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmpr))
					: null);

			entity.setLoteCompraProducto(FacesUtils.checkString(loteCompraProducto));
			entity.setRegistroIca(FacesUtils.checkString(registroIca));
			entity.setCantidadCompra(FacesUtils.checkDouble(cantidadCompra));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setUsuarioDigitacion(usuarioId);
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProductoId_Producto))
					: null);
			entity.setConceptoKardexId((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setCostoTotal(FacesUtils.checkDouble(txtValorUnitario) * FacesUtils.checkDouble(cantidadCompra));
			
			entity.setHorometro_abastecimiento(FacesUtils.checkDouble(txtHorometroAbastecimiento));
			entity.setTipoMovimiento(FacesUtils.checkString(txtTipoMovimiento));
			entity.setOrigenDatos("Modulo_TallerAgricola");
			
			entity.setDatServRealizadosEquipoId((FacesUtils.checkLong(txtDatServRealizadosEquipoId) != null)
					? businessDelegatorView.getDatServRealizadosEquipo(FacesUtils.checkLong(txtDatServRealizadosEquipoId))
					: null);
			entity.setEquipoId((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId_Equipo))
					: null);
			entity.setDatMantenimientoEquipoId(FacesUtils.checkLong(txtDatMantenimientoEquipoId));
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));
			
			entity.setImplementoId((FacesUtils.checkLong(txtImplemento) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtImplemento))
					: null);
			entity.setUbicacionesAlmacen((FacesUtils.checkLong(txtUbicacionesAlmacen) != null)
					? businessDelegator2View.getUbicacionesAlmacen(FacesUtils.checkLong(txtUbicacionesAlmacen))
					: null);
			businessDelegatorView.updatePrecioPromProd(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedPrecioPromProd2 = (ConsultaCompraProductosDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioPromProd2"));

			Long precioProdId = selectedPrecioPromProd2.getPrecioProdid().longValue();
			entity = businessDelegatorView.getPrecioPromProd(precioProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long precioProdId = FacesUtils.checkLong(txtPrecioProdId);
			entity = businessDelegatorView.getPrecioPromProd(precioProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deletePrecioPromProd(entity);
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
			selectedPrecioPromProd = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioPromProd"));

			Long precioProdId = new Long(selectedPrecioPromProd.getPrecioProdId());
			entity = businessDelegatorView.getPrecioPromProd(precioProdId);
			businessDelegatorView.deletePrecioPromProd(entity);
			data.remove(selectedPrecioPromProd);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long almacenId, Long compania, Date fechaCreacion, Date fechaFinal,
			Date fechaInicial, Date fechaModificacion, String infoAdicional, String infoAdicional2, Long precioProdId,
			Double valorUnitario, Long productoId_Producto) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updatePrecioPromProd(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PrecioPromProdView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtAlmacenId() {
		return txtAlmacenId;
	}

	public void setTxtAlmacenId(SelectOneMenu txtAlmacenId) {
		this.txtAlmacenId = txtAlmacenId;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
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

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtPrecioProdId() {
		return txtPrecioProdId;
	}

	public void setTxtPrecioProdId(InputText txtPrecioProdId) {
		this.txtPrecioProdId = txtPrecioProdId;
	}

	public List<PrecioPromProdDTO> getData() {
		try {
			if (data == null) {
				Double cantidad = 0.0;
				data = businessDelegatorView.getDataPrecioPromProd(cantidad);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PrecioPromProdDTO> precioPromProdDTO) {
		this.data = precioPromProdDTO;
	}

	public PrecioPromProdDTO getSelectedPrecioPromProd() {
		return selectedPrecioPromProd;
	}

	public void setSelectedPrecioPromProd(PrecioPromProdDTO precioPromProd) {
		this.selectedPrecioPromProd = precioPromProd;
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

	public SelectItem[] getSelectTipoProducto() {

		if (tipoProducto == null || tipoProducto.size() == 0) {
			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProducto = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto : lista) {
					selectTipoProducto[i] = new SelectItem(tipoProducto.getTipoProdId(),
							tipoProducto.getCodigo() + " - " + tipoProducto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProducto;
	}

	public void setSelectTipoProducto(SelectItem[] selectTipoProducto) {
		this.selectTipoProducto = selectTipoProducto;
	}

	public SelectItem[] getselectAlmacen2() {

		if (almacen2 == null || almacen2.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(), almacen2.getCodigo());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen2;
	}

	public void setselectAlmacen2(SelectItem[] selectAlmacen2) {
		this.selectAlmacen2 = selectAlmacen2;
	}

	/**
	 * @return the fechaVencimiento
	 */
	public Calendar getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Calendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * @return the txtUnidadMedida
	 */
	public SelectOneMenu getTxtUnidadMedida() {
		return txtUnidadMedida;
	}

	/**
	 * @param txtUnidadMedida the txtUnidadMedida to set
	 */
	public void setTxtUnidadMedida(SelectOneMenu txtUnidadMedida) {
		this.txtUnidadMedida = txtUnidadMedida;
	}

	/**
	 * @return the udadMed
	 */
	public List<UdadMed> getUdadMed() {
		return udadMed;
	}

	/**
	 * @param udadMed the udadMed to set
	 */
	public void setUdadMed(List<UdadMed> udadMed) {
		this.udadMed = udadMed;
	}

	/**
	 * @return the cantidadCompra
	 */
	public InputText getCantidadCompra() {
		return cantidadCompra;
	}

	/**
	 * @param cantidadCompra the cantidadCompra to set
	 */
	public void setCantidadCompra(InputText cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	/**
	 * @return the loteCompraProducto
	 */
	public InputText getLoteCompraProducto() {
		return loteCompraProducto;
	}

	/**
	 * @param loteCompraProducto the loteCompraProducto to set
	 */
	public void setLoteCompraProducto(InputText loteCompraProducto) {
		this.loteCompraProducto = loteCompraProducto;
	}

	/**
	 * @return the registroIca
	 */
	public InputText getRegistroIca() {
		return registroIca;
	}

	/**
	 * @param registroIca the registroIca to set
	 */
	public void setRegistroIca(InputText registroIca) {
		this.registroIca = registroIca;
	}

	/**
	 * @return the txtPersEmpr
	 */
	public SelectOneMenu getTxtPersEmpr() {
		return txtPersEmpr;
	}

	/**
	 * @param txtPersEmpr the txtPersEmpr to set
	 */
	public void setTxtPersEmpr(SelectOneMenu txtPersEmpr) {
		this.txtPersEmpr = txtPersEmpr;
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
	 * @return the txtTipoProdId_TipoProducto
	 */
	public SelectOneMenu getTxtTipoProdId_TipoProducto() {
		return txtTipoProdId_TipoProducto;
	}

	/**
	 * @param txtTipoProdId_TipoProducto the txtTipoProdId_TipoProducto to set
	 */
	public void setTxtTipoProdId_TipoProducto(SelectOneMenu txtTipoProdId_TipoProducto) {
		this.txtTipoProdId_TipoProducto = txtTipoProdId_TipoProducto;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "=" };
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

	public void listener_ConsultaUmProducto() {

		Long productoId = null;

		if (!txtProductoId_Producto.getValue().equals("")) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtUnidadMedida.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public SelectItem[] getSelectConceptoKardex() {

		if (conceptoKardex == null || conceptoKardex.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectConceptoKardex[i] = new SelectItem(conceptoKardex.getConceptoKardexId(),
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex;
	}

	public void setSelectConceptoKardex(SelectItem[] selectConceptoKardex) {
		this.selectConceptoKardex = selectConceptoKardex;
	}

	public InputText getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(InputText txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public SelectOneMenu getTxtConceptoKardex() {
		return txtConceptoKardex;
	}

	public void setTxtConceptoKardex(SelectOneMenu txtConceptoKardex) {
		this.txtConceptoKardex = txtConceptoKardex;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}
	

	public void action_valoresSeleccionados() throws Exception {
		String cadena = "";
		Long flagid=1L;
		String cadenaImportacion ="";
		
		ConsultaCompraProductosDTO idsSeleccionadas = null;
		if (selectedPrecioPromProd3 != null && selectedPrecioPromProd3.size() > 0) {
			idsSeleccionadas = selectedPrecioPromProd3.get(0);
			flagid = 0L;
			for (int i = 0; i < selectedPrecioPromProd3.size(); i++) {
				idsSeleccionadas =  selectedPrecioPromProd3.get(i);
				cadena += ","+ idsSeleccionadas.getPrecioProdid().toString();
			}
		}
	
		//cadena = "," +cadena;
		cadenaImportacion = "0"+cadena;	
		Long compania = new Long(getCompaniaIdSession());
		
		String tipomovimiento ="";
		if(txtTipoMovimientoConsulta.getValue()!=null) {
			tipomovimiento=FacesUtils.checkString(txtTipoMovimientoConsulta);
		}
		
		businessDelegator2View.pr_importar_salidas_movil_enproceso(cadenaImportacion,tipomovimiento);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Se han actualizado las ordenes con éxito "));
		

		//disableButtonA = "true";
	
		cadenaImportacion = null;
		cadena =null;
		consultaInventario();
	
	}
	

	public void consultaInventario() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicialConsulta));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinalConsulta));
			Long compania = new Long(getCompaniaIdSession());
			
			String almacenId = "0";
			String productoId = "0";
			Long flagAlmacen = 1L;
			Long flagProducto = 1L;
			Long usuario =0L;
			if (txtUsuarioAsociado.getValue() != null) {
				usuario = (FacesUtils.checkLong(txtUsuarioAsociado));
				
			}

			
			if (txtAlmacenId_Almacen.getValue() != null) {
				almacenId = (FacesUtils.checkString(txtAlmacenId_Almacen));
				flagAlmacen = 0L;
			}

			if (txtProductoIdConsulta.getValue() != null) {
				productoId = (FacesUtils.checkString(txtProductoIdConsulta));
				flagProducto = 0L;
			}
			Long flagEquipo = 1L;

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += "," + selectedEquipo.get(i);
				}
			}
			String tipomovimiento ="";
			if(txtTipoMovimientoConsulta.getValue()!=null) {
				tipomovimiento=FacesUtils.checkString(txtTipoMovimientoConsulta);
			}
			
			
			FacesContext context = FacesContext.getCurrentInstance();
			
			Double horas = 0.0;
			Double glnHoras= 0.0;
			Double combustible =0.0;
			Double cantidadRegistros =0.0;
			Double galonesHoraEstandar =0.0;
			
			if (fechaInicial != null && fechaFinal != null && tipomovimiento!=null) {
				dataConsulta = businessDelegator2View.pr_inventario_detalle_importacion_movil(compania, fechaInicial, fechaFinal, "0", 1L,
						productoId, flagProducto, almacenId, flagAlmacen, "0", 1L, 0l, 0l,usuario,	 equiposSeleccionadas,  flagEquipo,tipomovimiento);
				
				if (dataConsulta == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
							"No existe informacion asociada a los criterios de busqueda seleccionados "));
				}else {
					
					for( ConsultaCompraProductosDTO data1 : dataConsulta) {
						horas += (data1.getHoras().doubleValue()) ;
						combustible += (data1.getCantidad_compra().doubleValue()) ;
						cantidadRegistros +=1;
						galonesHoraEstandar +=data1.getGlHorasEstandar().doubleValue();
						//glnHoras += (data1.getGlHoras().doubleValue()) ;
			        	
			        }
					txtTotalHoras.setValue(horas);
					txtTotalGalones.setValue(combustible);
					glnHoras =  combustible /horas;
					glnHoras = (double) Math.round((glnHoras) * 1000) / 1000;
					
					Double glHrEstandar = galonesHoraEstandar /cantidadRegistros;
					glHrEstandar = (double) Math.round((glHrEstandar) * 1000) / 1000;
					txtGlnHorasEstandar.setValue(glHrEstandar);
					
					txtGlnHoras.setValue(glnHoras);
					
					String color= "#17b55e";
					colorGalonesHora =color ;
					if (glHrEstandar.doubleValue() >0 &&  glnHoras.doubleValue()  > glHrEstandar.doubleValue()  ) {
						color = "#F85B5B";
						colorGalonesHora = color;
					} else {
						color = "#17b55e";
						colorGalonesHora=color;
					}
					
					
					
				}
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
						"Verifique que los campos fecha inicial, fecha final y tipo movimiento tengan valores "));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SelectItem[] getSelectAlmacen() {

		if (almacen == null || almacen.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(),
							almacen.getCodigo() + " - " + almacen.getCodigo() + "-" + almacen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	public void setSelectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}

	public SelectItem[] getSelectTipoProductoConsulta() {

		if (tipoProductoConsulta == null || tipoProductoConsulta.size() == 0) {

			// tipoProducto = new ArrayList<TipoProducto>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProductoConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto : lista) {
					selectTipoProductoConsulta[i] = new SelectItem(tipoProducto.getTipoProdId(),
							tipoProducto.getCodigo() + " - " + tipoProducto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProductoConsulta;
	}

	public void setSelectTipoProductoConsulta(SelectItem[] selectTipoProductoConsulta) {
		this.selectTipoProductoConsulta = selectTipoProductoConsulta;
	}

	public SelectItem[] getSelectAlmacen2() {

		if (almacen2 == null || almacen2.size() == 0) {

			try {

				// almacen2 = businessDelegatorView.getAlmacen(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen2 = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen2 : lista) {
					selectAlmacen2[i] = new SelectItem(almacen2.getAlmacenId(),
							almacen2.getCodigo() + " - " + almacen2.getCodigo());
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

	public SelectItem[] getSelectProductoIdConsulta() throws NumberFormatException, Exception {
	if (txtTipoProductoConsulta.getValue() != null) {
		
	  //if (productoId == null || productoId.size() == 0) {

		Long idCompania = new Long(getCompaniaIdSession());
		Long tipoProducto = FacesUtils.checkLong(txtTipoProductoConsulta);
		try {
			// List<CatalogProductoDTO> lista = null;
			List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania, tipoProducto);
			selectProductoIdConsulta = new SelectItem[lista.size()];
			/*
			 * int i = 0; for (CatalogProductoDTO catalogProductoDTO : lista) {
			 * selectProductoIdConsulta[i] = new
			 * SelectItem(catalogProductoDTO.getProductoIdConsulta().longValue(),
			 * catalogProductoDTO.getCodigo()+"-"+ catalogProductoDTO.getNombre()
			 * 
			 * ); i++;
			 * 
			 * }
			 */
			for (int j = 0; j < lista.size(); j++) {
				selectProductoIdConsulta[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
						lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	 }

		return selectProductoIdConsulta;
	}

	public void setSelectProductoIdConsulta(SelectItem[] selectProductoIdConsulta) {
		this.selectProductoIdConsulta = selectProductoIdConsulta;
	}

	public void setTxtProductoIdConsulta(SelectOneMenu txtProductoIdConsulta) {
		this.txtProductoIdConsulta = txtProductoIdConsulta;
	}

	public void setTxtTipoProductoConsulta(SelectOneMenu txtTipoProductoConsulta) {
		this.txtTipoProductoConsulta = txtTipoProductoConsulta;
	}

	public SelectOneMenu getTxtTipoProductoConsulta() {
		return txtTipoProductoConsulta;
	}

	public SelectOneMenu getTxtProductoIdConsulta() {
		return txtProductoIdConsulta;
	}

	public ConsultaCompraProductosDTO getSelectedPrecioPromProd2() {
		return selectedPrecioPromProd2;
	}

	public void setSelectedPrecioPromProd2(ConsultaCompraProductosDTO selectedPrecioPromProd2) {
		this.selectedPrecioPromProd2 = selectedPrecioPromProd2;
	}

	public Calendar getTxtFechaInicialConsulta() {
		return txtFechaInicialConsulta;
	}

	public void setTxtFechaInicialConsulta(Calendar txtFechaInicialConsulta) {
		this.txtFechaInicialConsulta = txtFechaInicialConsulta;
	}

	public Calendar getTxtFechaFinalConsulta() {
		return txtFechaFinalConsulta;
	}

	public void setTxtFechaFinalConsulta(Calendar txtFechaFinalConsulta) {
		this.txtFechaFinalConsulta = txtFechaFinalConsulta;
	}

	public void setDataConsulta(List<ConsultaCompraProductosDTO> dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public List<ConsultaCompraProductosDTO> getDataConsulta() {
		return dataConsulta;
	}

	public SelectItem[] getSelectProductoId() throws NumberFormatException, Exception {
		 if (txtTipoProdId_TipoProducto.getValue() != null) {
		
		// if (productoId == null || productoId.size() == 0) {

		Long idCompania = new Long(getCompaniaIdSession());
		 Long tipoProducto = FacesUtils.checkLong(txtTipoProdId_TipoProducto);
		try {
			// List<CatalogProductoDTO> lista = null;
			List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania, tipoProducto);
			selectProductoId = new SelectItem[lista.size()];
			/*
			 * int i = 0; for (CatalogProductoDTO catalogProductoDTO : lista) {
			 * selectProductoId[i] = new
			 * SelectItem(catalogProductoDTO.getProductoId().longValue(),
			 * catalogProductoDTO.getCodigo()+"-"+ catalogProductoDTO.getNombre()
			 * 
			 * ); i++;
			 * 
			 * }
			 */

			for (int j = 0; j < lista.size(); j++) {
				selectProductoId[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
						lista.get(j).getCodigo() + "-" + lista.get(j).getNombre());
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputText getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(InputText txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public InputText getTxtHorometroAbastecimiento() {
		return txtHorometroAbastecimiento;
	}

	public void setTxtHorometroAbastecimiento(InputText txtHorometroAbastecimiento) {
		this.txtHorometroAbastecimiento = txtHorometroAbastecimiento;
	}

	public SelectOneMenu getTxtTipoMovimiento() {
		return txtTipoMovimiento;
	}

	public void setTxtTipoMovimiento(SelectOneMenu txtTipoMovimiento) {
		this.txtTipoMovimiento = txtTipoMovimiento;
	}
	

	public SelectItem[] getSelectUsuarioId() {

		if (usuarioId == null || usuarioId.size() == 0) {

			try {
				Object[] condicion = { "enabled", true, "true", "=" };
				List<Usuarios> lista = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);
				selectUsuarioId = new SelectItem[lista.size()];

				int i = 0;
				for (Usuarios usuarioId : lista) {
					selectUsuarioId[i] = new SelectItem(usuarioId.getUsuarioId(), usuarioId.getLogin());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUsuarioId;
	}

	public void setSelectUsuarioId(SelectItem[] selectUsuarioId) {

		this.selectUsuarioId = selectUsuarioId;
	}

	public SelectOneMenu getTxtUsuarioAsociado() {
		return txtUsuarioAsociado;
	}

	public void setTxtUsuarioAsociado(SelectOneMenu txtUsuarioAsociado) {
		this.txtUsuarioAsociado = txtUsuarioAsociado;
	}

	public List<ConsultaCompraProductosDTO> getSelectedPrecioPromProd3() {
		return selectedPrecioPromProd3;
	}

	public void setSelectedPrecioPromProd3(List<ConsultaCompraProductosDTO> selectedPrecioPromProd3) {
		this.selectedPrecioPromProd3 = selectedPrecioPromProd3;
	}

	public InputNumber getTxtTotalHoras() {
		return txtTotalHoras;
	}

	public void setTxtTotalHoras(InputNumber txtTotalHoras) {
		this.txtTotalHoras = txtTotalHoras;
	}

	public InputNumber getTxtTotalGalones() {
		return txtTotalGalones;
	}

	public void setTxtTotalGalones(InputNumber txtTotalGalones) {
		this.txtTotalGalones = txtTotalGalones;
	}

	public InputNumber getTxtGlnHoras() {
		return txtGlnHoras;
	}

	public void setTxtGlnHoras(InputNumber txtGlnHoras) {
		this.txtGlnHoras = txtGlnHoras;
	}

	public InputNumber getTxtGlnHorasEstandar() {
		return txtGlnHorasEstandar;
	}

	public void setTxtGlnHorasEstandar(InputNumber txtGlnHorasEstandar) {
		this.txtGlnHorasEstandar = txtGlnHorasEstandar;
	}

	public String getColorGalonesHora() {
		return colorGalonesHora;
	}

	public void setColorGalonesHora(String colorGalonesHora) {
		this.colorGalonesHora = colorGalonesHora;
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
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",

						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"};
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

	public SelectOneMenu getTxtDatServRealizadosEquipoId() {
		return txtDatServRealizadosEquipoId;
	}
	

	public void setTxtDatServRealizadosEquipoId(SelectOneMenu txtDatServRealizadosEquipoId) {
		this.txtDatServRealizadosEquipoId = txtDatServRealizadosEquipoId;
	}

	

	public SelectItem[] getSelectDatServRealizadosEquipo() {


			try {
			

				List<ConsultaServiciosRealizadosMaquinariaDTO> lista = null;
			
				Long compania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat anio = new SimpleDateFormat("yyyy");
				Date fechaInicial = null;
				Date fechaFinal = null;
				fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
				
				GregorianCalendar calendarInicial = new GregorianCalendar();
				GregorianCalendar calendarFinal = new GregorianCalendar();
				
				if(fechaInicial!=null) {
				calendarInicial.setTime(fechaInicial); // Configuramos la fecha que se
				calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -15); 

				calendarFinal.setTime(fechaInicial); // Configuramos la fecha que se
				calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 15); 
				
				String equipoId = FacesUtils.checkString(txtEquipoId_Equipo);
				
				
				lista = businessDelegator2View.consultaServRealizadosMq(compania, calendarInicial.getTime(), calendarFinal.getTime(),
							equipoId, 0L);
				
				if (lista != null) {
					selectDatServRealizadosEquipo = new SelectItem[lista.size()];

					int i = 0;
					for (ConsultaServiciosRealizadosMaquinariaDTO consultaServiciosRealizadosMaquinariaDTO : lista) {
						selectDatServRealizadosEquipo[i] = new SelectItem(consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id().longValue(),
								consultaServiciosRealizadosMaquinariaDTO.getCodEquipo() +" *RDL* "
										+consultaServiciosRealizadosMaquinariaDTO.getConsecutivoRdl() +" *Consec* "+consultaServiciosRealizadosMaquinariaDTO.getConsecutivo()

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
	

	public SelectItem[] getselectEquipo() {

		if (equipo == null || equipo.size() == 0) {

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

	public void setselectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtTipoMovimientoConsulta() {
		return txtTipoMovimientoConsulta;
	}

	public void setTxtTipoMovimientoConsulta(SelectOneMenu txtTipoMovimientoConsulta) {
		this.txtTipoMovimientoConsulta = txtTipoMovimientoConsulta;
	}


	public SelectItem[] getSelectDatMantenimientoEquipoId() {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				
				GregorianCalendar calendario4 = new GregorianCalendar();
				calendario4.add(GregorianCalendar.DAY_OF_YEAR, -600);
				java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());
				String equipoId = FacesUtils.checkString(txtEquipoId_Equipo);
				
				
				Date fechaFinalDateRegistro =null;
				Date fechaOriginalFinal = foriginal.parse("2100-12-31");
				String fsalidaFinal = sdf.format(fechaOriginalFinal);
				fechaFinalDateRegistro = sdf.parse(fsalidaFinal);		
				
				Long idRegistro = 0L;
				
				
				List<SolicitudesMttoEquipoDTO> listaMtto = null;
				listaMtto = businessDelegator2View.pr_formato_impresion_ot(idCompania, fechaMinimaPermitida, fechaFinalDateRegistro, 
						"0", 1L, equipoId, 0L, "0", 1L, idRegistro);
				
				if (listaMtto != null) {
					selectDatMantenimientoEquipoId = new SelectItem[listaMtto.size()];

					int i = 0;
					for (SolicitudesMttoEquipoDTO solicitudesMttoEquipoDTO : listaMtto) {
						selectDatMantenimientoEquipoId[i] = new SelectItem(solicitudesMttoEquipoDTO.getDat_mantenimiento_equipo_id().longValue(),
								"Ot: "+solicitudesMttoEquipoDTO.getConsecutivo().toString()+" - Maq: "+solicitudesMttoEquipoDTO.getCod_equipo()
								+" - Mtto: "+solicitudesMttoEquipoDTO.getPlan_revision()
						);
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		return selectDatMantenimientoEquipoId;
	}

	public void setSelectDatMantenimientoEquipoId(SelectItem[] selectDatMantenimientoEquipoId) {
		this.selectDatMantenimientoEquipoId = selectDatMantenimientoEquipoId;
	}	
	
public List<String> getSelectedOrdenMtto() {
		
		return selectedOrdenMtto;
	}

	public void setSelectedOrdenMtto(List<String> selectedOrdenMtto) {
		this.selectedOrdenMtto = selectedOrdenMtto;
	}


	public List<SolicitudesMttoEquipoDTO> getOrdenMtto() {

		if (ordenMtto == null || ordenMtto.size() == 0) {
			
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				
				GregorianCalendar calendario4 = new GregorianCalendar();
				calendario4.add(GregorianCalendar.DAY_OF_YEAR, -600);
				java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());

				
				Date fechaFinalDateRegistro =null;
				Date fechaOriginalFinal = foriginal.parse("2100-12-31");
				String fsalidaFinal = sdf.format(fechaOriginalFinal);
				fechaFinalDateRegistro = sdf.parse(fsalidaFinal);		
				
				Long idRegistro = 0L;
				ordenMtto = null;
				ordenMtto = businessDelegator2View.pr_ot_plan_revision(idCompania, fechaMinimaPermitida, fechaFinalDateRegistro, 
						 "0", 1L, idRegistro);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return ordenMtto;
	}

	public void setOrdenMtto(List<SolicitudesMttoEquipoDTO> ordenMtto) {
		this.ordenMtto = ordenMtto;
	}

	public SelectOneMenu getTxtDatMantenimientoEquipoId() {
		return txtDatMantenimientoEquipoId;
	}

	public void setTxtDatMantenimientoEquipoId(SelectOneMenu txtDatMantenimientoEquipoId) {
		this.txtDatMantenimientoEquipoId = txtDatMantenimientoEquipoId;
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

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	public SelectItem[] getSelectImplemento() {

		if (implemento == null || implemento.size() == 0) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Implemento", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo Implemento : lista) {
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(),
							Implemento.getCodigo() + "-" + Implemento.getNombre());
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

	public SelectOneMenu getTxtUbicacionesAlmacen() {
		return txtUbicacionesAlmacen;
	}

	public void setTxtUbicacionesAlmacen(SelectOneMenu txtUbicacionesAlmacen) {
		this.txtUbicacionesAlmacen = txtUbicacionesAlmacen;
	}


	public SelectItem[] getSelectUbAlmacen() {

		if (selectUbAlmacen == null || selectUbAlmacen.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UbicacionesAlmacen> lista = businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion,
						null, null);
				selectUbAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (UbicacionesAlmacen ubicacionesAlmacen : lista) {
					selectUbAlmacen[i] = new SelectItem(ubicacionesAlmacen.getUbicacionesAlmacenId(),
							ubicacionesAlmacen.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUbAlmacen;
	}

	public void setSelectUbAlmacen(SelectItem[] selectUbAlmacen) {
		this.selectUbAlmacen = selectUbAlmacen;
	}
}
