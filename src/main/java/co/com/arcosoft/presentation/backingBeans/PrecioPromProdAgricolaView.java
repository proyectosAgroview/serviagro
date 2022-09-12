package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
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
public class PrecioPromProdAgricolaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PrecioPromProdAgricolaView.class);
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

	public PrecioPromProdAgricolaView() {
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

		if (txtConceptoKardex != null) {
			txtConceptoKardex.setValue(null);
			txtConceptoKardex.setDisabled(false);
		}

		if (txtSaldo != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(false);
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
				if (entity.getTipoMovimiento().equals("SAL")) {
					txtAlmacenId.setValue(entity.getAlmacenId().getAlmacenId());
					txtAlmacenId.setDisabled(false);
					txtFechaInicial.setValue(entity.getFechaInicial());
					txtFechaInicial.setDisabled(true);
					txtInfoAdicional.setValue(entity.getInfoAdicional());
					txtInfoAdicional.setDisabled(false);
					txtValorUnitario.setValue(entity.getValorUnitario());
					txtValorUnitario.setDisabled(true);
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
					//	Long productoId = entity.getProducto().getProductoId();
					//	Producto producto = businessDelegatorView.getProducto(productoId);
					//	txtTipoProdId_TipoProducto.setValue(producto.getTipoProducto().getTipoProdId());
					//	txtTipoProdId_TipoProducto.setDisabled(true);
						txtProductoId_Producto.setValue(entity.getProducto().getProductoId());

					}
					txtProductoId_Producto.setDisabled(true);

					txtUnidadMedida.setValue(entity.getUnidadMedida().getUdadMedId());
					txtUnidadMedida.setDisabled(true);

					cantidadCompra.setValue(entity.getCantidadCompra());
					cantidadCompra.setDisabled(false);

					txtPrecioProdId.setValue(entity.getPrecioProdId());
					txtPrecioProdId.setDisabled(true);

					btnSave.setDisabled(false);

					setShowDialog(true);
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!", "únicamente puede modificar los registros de sálidas de inventario "));
					btnSave.setDisabled(true);
				}
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
			// entity.setPrecioProdId(precioProdId);
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
			
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));

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
			selectedPrecioPromProd = (PrecioPromProdDTO) (evt.getComponent().getAttributes()
					.get("selectedPrecioPromProd"));

			Long precioProdId = new Long(selectedPrecioPromProd.getPrecioProdId());
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

			if (txtAlmacenId_Almacen.getValue() != null) {
				almacenId = (FacesUtils.checkString(txtAlmacenId_Almacen));
				flagAlmacen = 0L;
			}

			if (txtProductoIdConsulta.getValue() != null) {
				productoId = (FacesUtils.checkString(txtProductoIdConsulta));
				flagProducto = 0L;
			}

			if (fechaInicial != null && fechaFinal != null) {
				dataConsulta = businessDelegator2View.pr_inventario_detalle(compania, fechaInicial, fechaFinal, "0", 1L,
						productoId, flagProducto, almacenId, flagAlmacen, "0", 1L, 0l, 0l,0l,"SUMINISTROS");
			} else {

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
		// if (txtTipoProducto.getValue() != null) {
		//
		// if (productoId == null || productoId.size() == 0) {

		Long idCompania = new Long(getCompaniaIdSession());
		// Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
		try {
			// List<CatalogProductoDTO> lista = null;
			List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania, 0L);
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
		// }

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
		// if (txtTipoProducto.getValue() != null) {
		//
		// if (productoId == null || productoId.size() == 0) {

		Long idCompania = new Long(getCompaniaIdSession());
		// Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
		try {
			// List<CatalogProductoDTO> lista = null;
			List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania, 0L);
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
		// }

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

}
