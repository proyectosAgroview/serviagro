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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.dto.DatHerramientaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatHerramientaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(DatHerramientaView.class);
	private InputText txtCantidadEntregada;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtEstado;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional2;
	private InputText txtObservacion;
	private InputText txtObservacionAnularReg;
	private InputText txtTipoRegistro;
	private InputText txtUsuarioDigitacion;
	private InputText txtAlmacenId_Almacen;
	private InputText txtProductoId_Producto;
	private InputText txtTrabId_Trabajador;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtDatHerramientaId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatHerramientaDTO> data;
	private DatHerramientaDTO selectedDatHerramienta;
	private DatHerramienta entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatHerramientaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatHerramientaDTO datHerramientaDTO = (DatHerramientaDTO) e
					.getObject();

			if (txtCantidadEntregada == null) {
				txtCantidadEntregada = new InputText();
			}

			txtCantidadEntregada.setValue(datHerramientaDTO
					.getCantidadEntregada());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datHerramientaDTO.getCompania());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datHerramientaDTO.getConsecutivo());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(datHerramientaDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputText();
			}

			txtInfoAdicional.setValue(datHerramientaDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputText();
			}

			txtInfoAdicional2.setValue(datHerramientaDTO.getInfoAdicional2());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(datHerramientaDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputText();
			}

			txtObservacionAnularReg.setValue(datHerramientaDTO
					.getObservacionAnularReg());

			if (txtTipoRegistro == null) {
				txtTipoRegistro = new InputText();
			}

			txtTipoRegistro.setValue(datHerramientaDTO.getTipoRegistro());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datHerramientaDTO
					.getUsuarioDigitacion());

			if (txtAlmacenId_Almacen == null) {
				txtAlmacenId_Almacen = new InputText();
			}

			txtAlmacenId_Almacen.setValue(datHerramientaDTO
					.getAlmacenId_Almacen());

			if (txtProductoId_Producto == null) {
				txtProductoId_Producto = new InputText();
			}

			txtProductoId_Producto.setValue(datHerramientaDTO
					.getProductoId_Producto());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new InputText();
			}

			txtTrabId_Trabajador.setValue(datHerramientaDTO
					.getTrabId_Trabajador());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(datHerramientaDTO
					.getUdadMedId_UdadMed());

			if (txtDatHerramientaId == null) {
				txtDatHerramientaId = new InputText();
			}

			txtDatHerramientaId.setValue(datHerramientaDTO
					.getDatHerramientaId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datHerramientaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datHerramientaDTO
					.getFechaModificacion());

			if (txtFechaRegistro == null) {
				txtFechaRegistro = new Calendar();
			}

			txtFechaRegistro.setValue(datHerramientaDTO.getFechaRegistro());

			Long datHerramientaId = FacesUtils.checkLong(txtDatHerramientaId);
			entity = businessDelegatorView.getDatHerramienta(datHerramientaId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatHerramienta = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatHerramienta = null;

		if (txtCantidadEntregada != null) {
			txtCantidadEntregada.setValue(null);
			txtCantidadEntregada.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
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

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(true);
		}

		if (txtTipoRegistro != null) {
			txtTipoRegistro.setValue(null);
			txtTipoRegistro.setDisabled(true);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtAlmacenId_Almacen != null) {
			txtAlmacenId_Almacen.setValue(null);
			txtAlmacenId_Almacen.setDisabled(true);
		}

		if (txtProductoId_Producto != null) {
			txtProductoId_Producto.setValue(null);
			txtProductoId_Producto.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
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
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(true);
		}

		if (txtDatHerramientaId != null) {
			txtDatHerramientaId.setValue(null);
			txtDatHerramientaId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long datHerramientaId = FacesUtils.checkLong(txtDatHerramientaId);
			entity = (datHerramientaId != null) ? businessDelegatorView
					.getDatHerramienta(datHerramientaId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCantidadEntregada.setDisabled(false);
			txtCompania.setDisabled(false);
			txtConsecutivo.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setDisabled(false);
			txtTipoRegistro.setDisabled(false);
			txtUsuarioDigitacion.setDisabled(false);
			txtAlmacenId_Almacen.setDisabled(false);
			txtProductoId_Producto.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaRegistro.setDisabled(false);
			txtDatHerramientaId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadEntregada.setValue(entity.getCantidadEntregada());
			txtCantidadEntregada.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtConsecutivo.setValue(entity.getConsecutivo());
			txtConsecutivo.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaRegistro.setValue(entity.getFechaRegistro());
			txtFechaRegistro.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setValue(entity.getObservacionAnularReg());
			txtObservacionAnularReg.setDisabled(false);
			txtTipoRegistro.setValue(entity.getTipoRegistro());
			txtTipoRegistro.setDisabled(false);
			txtUsuarioDigitacion.setValue(entity.getUsuarioDigitacion());
			txtUsuarioDigitacion.setDisabled(false);
			txtAlmacenId_Almacen.setValue(entity.getAlmacen().getAlmacenId());
			txtAlmacenId_Almacen.setDisabled(false);
			txtProductoId_Producto.setValue(entity.getProducto()
					.getProductoId());
			txtProductoId_Producto.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatHerramientaId.setValue(entity.getDatHerramientaId());
			txtDatHerramientaId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatHerramienta = (DatHerramientaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatHerramienta"));
		txtCantidadEntregada.setValue(selectedDatHerramienta
				.getCantidadEntregada());
		txtCantidadEntregada.setDisabled(false);
		txtCompania.setValue(selectedDatHerramienta.getCompania());
		txtCompania.setDisabled(false);
		txtConsecutivo.setValue(selectedDatHerramienta.getConsecutivo());
		txtConsecutivo.setDisabled(false);
		txtEstado.setValue(selectedDatHerramienta.getEstado());
		txtEstado.setDisabled(false);
		txtFechaCreacion.setValue(selectedDatHerramienta.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDatHerramienta
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaRegistro.setValue(selectedDatHerramienta.getFechaRegistro());
		txtFechaRegistro.setDisabled(false);
		txtInfoAdicional.setValue(selectedDatHerramienta.getInfoAdicional());
		txtInfoAdicional.setDisabled(false);
		txtInfoAdicional2.setValue(selectedDatHerramienta.getInfoAdicional2());
		txtInfoAdicional2.setDisabled(false);
		txtObservacion.setValue(selectedDatHerramienta.getObservacion());
		txtObservacion.setDisabled(false);
		txtObservacionAnularReg.setValue(selectedDatHerramienta
				.getObservacionAnularReg());
		txtObservacionAnularReg.setDisabled(false);
		txtTipoRegistro.setValue(selectedDatHerramienta.getTipoRegistro());
		txtTipoRegistro.setDisabled(false);
		txtUsuarioDigitacion.setValue(selectedDatHerramienta
				.getUsuarioDigitacion());
		txtUsuarioDigitacion.setDisabled(false);
		txtAlmacenId_Almacen.setValue(selectedDatHerramienta
				.getAlmacenId_Almacen());
		txtAlmacenId_Almacen.setDisabled(false);
		txtProductoId_Producto.setValue(selectedDatHerramienta
				.getProductoId_Producto());
		txtProductoId_Producto.setDisabled(false);
		txtTrabId_Trabajador.setValue(selectedDatHerramienta
				.getTrabId_Trabajador());
		txtTrabId_Trabajador.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedDatHerramienta
				.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtDatHerramientaId.setValue(selectedDatHerramienta
				.getDatHerramientaId());
		txtDatHerramientaId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatHerramienta == null) && (entity == null)) {
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
			entity = new DatHerramienta();

			Long datHerramientaId = FacesUtils.checkLong(txtDatHerramientaId);

			entity.setCantidadEntregada(FacesUtils
					.checkDouble(txtCantidadEntregada));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDatHerramientaId(datHerramientaId);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils
					.checkString(txtObservacionAnularReg));
			entity.setTipoRegistro(FacesUtils.checkString(txtTipoRegistro));
			entity.setUsuarioDigitacion(FacesUtils
					.checkLong(txtUsuarioDigitacion));
			entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null) ? businessDelegatorView
					.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen))
					: null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null) ? businessDelegatorView
					.getProducto(FacesUtils.checkLong(txtProductoId_Producto))
					: null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null) ? businessDelegatorView
					.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador))
					: null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null) ? businessDelegatorView
					.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);
			businessDelegatorView.saveDatHerramienta(entity);
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
				Long datHerramientaId = new Long(
						selectedDatHerramienta.getDatHerramientaId());
				entity = businessDelegatorView
						.getDatHerramienta(datHerramientaId);
			}

			entity.setCantidadEntregada(FacesUtils
					.checkDouble(txtCantidadEntregada));
			entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils
					.checkString(txtObservacionAnularReg));
			entity.setTipoRegistro(FacesUtils.checkString(txtTipoRegistro));
			entity.setUsuarioDigitacion(FacesUtils
					.checkLong(txtUsuarioDigitacion));
			entity.setAlmacen((FacesUtils.checkLong(txtAlmacenId_Almacen) != null) ? businessDelegatorView
					.getAlmacen(FacesUtils.checkLong(txtAlmacenId_Almacen))
					: null);
			entity.setProducto((FacesUtils.checkLong(txtProductoId_Producto) != null) ? businessDelegatorView
					.getProducto(FacesUtils.checkLong(txtProductoId_Producto))
					: null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null) ? businessDelegatorView
					.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador))
					: null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null) ? businessDelegatorView
					.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);
			businessDelegatorView.updateDatHerramienta(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatHerramienta = (DatHerramientaDTO) (evt.getComponent()
					.getAttributes().get("selectedDatHerramienta"));

			Long datHerramientaId = new Long(
					selectedDatHerramienta.getDatHerramientaId());
			entity = businessDelegatorView.getDatHerramienta(datHerramientaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datHerramientaId = FacesUtils.checkLong(txtDatHerramientaId);
			entity = businessDelegatorView.getDatHerramienta(datHerramientaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatHerramienta(entity);
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
			selectedDatHerramienta = (DatHerramientaDTO) (evt.getComponent()
					.getAttributes().get("selectedDatHerramienta"));

			Long datHerramientaId = new Long(
					selectedDatHerramienta.getDatHerramientaId());
			entity = businessDelegatorView.getDatHerramienta(datHerramientaId);
			businessDelegatorView.deleteDatHerramienta(entity);
			data.remove(selectedDatHerramienta);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidadEntregada, Long compania,
			Long consecutivo, Long datHerramientaId, String estado,
			Date fechaCreacion, Date fechaModificacion, Date fechaRegistro,
			String infoAdicional, String infoAdicional2, String observacion,
			String observacionAnularReg, String tipoRegistro,
			Long usuarioDigitacion, Long almacenId_Almacen,
			Long productoId_Producto, Long trabId_Trabajador,
			Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setCantidadEntregada(FacesUtils
					.checkDouble(cantidadEntregada));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils
					.checkString(observacionAnularReg));
			entity.setTipoRegistro(FacesUtils.checkString(tipoRegistro));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatHerramienta(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatHerramientaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidadEntregada() {
		return txtCantidadEntregada;
	}

	public void setTxtCantidadEntregada(InputText txtCantidadEntregada) {
		this.txtCantidadEntregada = txtCantidadEntregada;
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

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public void setTxtInfoAdicional(InputText txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public InputText getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public void setTxtInfoAdicional2(InputText txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public InputText getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputText txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputText getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputText txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtTipoRegistro() {
		return txtTipoRegistro;
	}

	public void setTxtTipoRegistro(InputText txtTipoRegistro) {
		this.txtTipoRegistro = txtTipoRegistro;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputText getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(InputText txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}

	public InputText getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(InputText txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public InputText getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(InputText txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public InputText getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(InputText txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
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

	public InputText getTxtDatHerramientaId() {
		return txtDatHerramientaId;
	}

	public void setTxtDatHerramientaId(InputText txtDatHerramientaId) {
		this.txtDatHerramientaId = txtDatHerramientaId;
	}

	public List<DatHerramientaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatHerramienta();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatHerramientaDTO> datHerramientaDTO) {
		this.data = datHerramientaDTO;
	}

	public DatHerramientaDTO getSelectedDatHerramienta() {
		return selectedDatHerramienta;
	}

	public void setSelectedDatHerramienta(DatHerramientaDTO datHerramienta) {
		this.selectedDatHerramienta = datHerramienta;
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

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}
}
