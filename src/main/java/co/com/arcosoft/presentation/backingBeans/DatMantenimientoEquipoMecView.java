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
import co.com.arcosoft.modelo.DatMantenimientoEquipoMec;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatMantenimientoEquipoMecView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoMecView.class);
	private InputText txtCantidad;
	private InputText txtCostoTotal;
	private InputText txtValorUnitario;
	private InputText txtCeptoNominaId_ConceptoNomina;
	private InputText txtDatMantenimientoEquipoId_DatMantenimientoEquipo;
	private InputText txtTrabId_Trabajador;
	private InputText txtUdadMedId_UdadMed;
	private InputText txtDatMantenimientoEquipoMecId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatMantenimientoEquipoMecDTO> data;
	private DatMantenimientoEquipoMecDTO selectedDatMantenimientoEquipoMec;
	private DatMantenimientoEquipoMec entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatMantenimientoEquipoMecView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatMantenimientoEquipoMecDTO datMantenimientoEquipoMecDTO = (DatMantenimientoEquipoMecDTO) e.getObject();

			if (txtCantidad == null) {
				txtCantidad = new InputText();
			}

			txtCantidad.setValue(datMantenimientoEquipoMecDTO.getCantidad());

			if (txtCostoTotal == null) {
				txtCostoTotal = new InputText();
			}

			txtCostoTotal.setValue(datMantenimientoEquipoMecDTO.getCostoTotal());

			if (txtValorUnitario == null) {
				txtValorUnitario = new InputText();
			}

			txtValorUnitario.setValue(datMantenimientoEquipoMecDTO.getValorUnitario());

			if (txtCeptoNominaId_ConceptoNomina == null) {
				txtCeptoNominaId_ConceptoNomina = new InputText();
			}

			txtCeptoNominaId_ConceptoNomina.setValue(datMantenimientoEquipoMecDTO.getCeptoNominaId_ConceptoNomina());

			if (txtDatMantenimientoEquipoId_DatMantenimientoEquipo == null) {
				txtDatMantenimientoEquipoId_DatMantenimientoEquipo = new InputText();
			}

			txtDatMantenimientoEquipoId_DatMantenimientoEquipo
					.setValue(datMantenimientoEquipoMecDTO.getDatMantenimientoEquipoId_DatMantenimientoEquipo());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new InputText();
			}

			txtTrabId_Trabajador.setValue(datMantenimientoEquipoMecDTO.getTrabId_Trabajador());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new InputText();
			}

			txtUdadMedId_UdadMed.setValue(datMantenimientoEquipoMecDTO.getUdadMedId_UdadMed());

			if (txtDatMantenimientoEquipoMecId == null) {
				txtDatMantenimientoEquipoMecId = new InputText();
			}

			txtDatMantenimientoEquipoMecId.setValue(datMantenimientoEquipoMecDTO.getDatMantenimientoEquipoMecId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datMantenimientoEquipoMecDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datMantenimientoEquipoMecDTO.getFechaModificacion());

			if (txtFechaRegistro == null) {
				txtFechaRegistro = new Calendar();
			}

			txtFechaRegistro.setValue(datMantenimientoEquipoMecDTO.getFechaRegistro());

			Long datMantenimientoEquipoMecId = FacesUtils.checkLong(txtDatMantenimientoEquipoMecId);
			entity = businessDelegatorView.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatMantenimientoEquipoMec = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatMantenimientoEquipoMec = null;

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(true);
		}

		if (txtCostoTotal != null) {
			txtCostoTotal.setValue(null);
			txtCostoTotal.setDisabled(true);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(true);
		}

		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(true);
		}

		if (txtDatMantenimientoEquipoId_DatMantenimientoEquipo != null) {
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setValue(null);
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(true);
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

		if (txtDatMantenimientoEquipoMecId != null) {
			txtDatMantenimientoEquipoMecId.setValue(null);
			txtDatMantenimientoEquipoMecId.setDisabled(false);
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

	public void listener_txtId() {
		try {
			Long datMantenimientoEquipoMecId = FacesUtils.checkLong(txtDatMantenimientoEquipoMecId);
			entity = (datMantenimientoEquipoMecId != null)
					? businessDelegatorView.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCantidad.setDisabled(false);
			txtCostoTotal.setDisabled(false);
			txtValorUnitario.setDisabled(false);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaRegistro.setDisabled(false);
			txtDatMantenimientoEquipoMecId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidad.setValue(entity.getCantidad());
			txtCantidad.setDisabled(false);
			txtCostoTotal.setValue(entity.getCostoTotal());
			txtCostoTotal.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaRegistro.setValue(entity.getFechaRegistro());
			txtFechaRegistro.setDisabled(false);
			txtValorUnitario.setValue(entity.getValorUnitario());
			txtValorUnitario.setDisabled(false);
			txtCeptoNominaId_ConceptoNomina.setValue(entity.getConceptoNomina().getCeptoNominaId());
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo
					.setValue(entity.getDatMantenimientoEquipo().getDatMantenimientoEquipoId());
			txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
			txtTrabId_Trabajador.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtDatMantenimientoEquipoMecId.setValue(entity.getDatMantenimientoEquipoMecId());
			txtDatMantenimientoEquipoMecId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatMantenimientoEquipoMec = (DatMantenimientoEquipoMecDTO) (evt.getComponent().getAttributes()
				.get("selectedDatMantenimientoEquipoMec"));
		txtCantidad.setValue(selectedDatMantenimientoEquipoMec.getCantidad());
		txtCantidad.setDisabled(false);
		txtCostoTotal.setValue(selectedDatMantenimientoEquipoMec.getCostoTotal());
		txtCostoTotal.setDisabled(false);
		txtFechaCreacion.setValue(selectedDatMantenimientoEquipoMec.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDatMantenimientoEquipoMec.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaRegistro.setValue(selectedDatMantenimientoEquipoMec.getFechaRegistro());
		txtFechaRegistro.setDisabled(false);
		txtValorUnitario.setValue(selectedDatMantenimientoEquipoMec.getValorUnitario());
		txtValorUnitario.setDisabled(false);
		txtCeptoNominaId_ConceptoNomina.setValue(selectedDatMantenimientoEquipoMec.getCeptoNominaId_ConceptoNomina());
		txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		txtDatMantenimientoEquipoId_DatMantenimientoEquipo
				.setValue(selectedDatMantenimientoEquipoMec.getDatMantenimientoEquipoId_DatMantenimientoEquipo());
		txtDatMantenimientoEquipoId_DatMantenimientoEquipo.setDisabled(false);
		txtTrabId_Trabajador.setValue(selectedDatMantenimientoEquipoMec.getTrabId_Trabajador());
		txtTrabId_Trabajador.setDisabled(false);
		txtUdadMedId_UdadMed.setValue(selectedDatMantenimientoEquipoMec.getUdadMedId_UdadMed());
		txtUdadMedId_UdadMed.setDisabled(false);
		txtDatMantenimientoEquipoMecId.setValue(selectedDatMantenimientoEquipoMec.getDatMantenimientoEquipoMecId());
		txtDatMantenimientoEquipoMecId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatMantenimientoEquipoMec == null) && (entity == null)) {
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
			entity = new DatMantenimientoEquipoMec();

			Long datMantenimientoEquipoMecId = FacesUtils.checkLong(txtDatMantenimientoEquipoMecId);

			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			entity.setDatMantenimientoEquipoMecId(datMantenimientoEquipoMecId);
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina))
					: null);
			entity.setDatMantenimientoEquipo(
					(FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo) != null)
							? businessDelegatorView.getDatMantenimientoEquipo(
									FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.saveDatMantenimientoEquipoMec(entity);
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
				Long datMantenimientoEquipoMecId = new Long(
						selectedDatMantenimientoEquipoMec.getDatMantenimientoEquipoMecId());
				entity = businessDelegatorView.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);
			}

			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setCostoTotal(FacesUtils.checkDouble(txtCostoTotal));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina))
					: null);
			entity.setDatMantenimientoEquipo(
					(FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo) != null)
							? businessDelegatorView.getDatMantenimientoEquipo(
									FacesUtils.checkLong(txtDatMantenimientoEquipoId_DatMantenimientoEquipo))
							: null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			businessDelegatorView.updateDatMantenimientoEquipoMec(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatMantenimientoEquipoMec = (DatMantenimientoEquipoMecDTO) (evt.getComponent().getAttributes()
					.get("selectedDatMantenimientoEquipoMec"));

			Long datMantenimientoEquipoMecId = new Long(
					selectedDatMantenimientoEquipoMec.getDatMantenimientoEquipoMecId());
			entity = businessDelegatorView.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datMantenimientoEquipoMecId = FacesUtils.checkLong(txtDatMantenimientoEquipoMecId);
			entity = businessDelegatorView.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatMantenimientoEquipoMec(entity);
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
			selectedDatMantenimientoEquipoMec = (DatMantenimientoEquipoMecDTO) (evt.getComponent().getAttributes()
					.get("selectedDatMantenimientoEquipoMec"));

			Long datMantenimientoEquipoMecId = new Long(
					selectedDatMantenimientoEquipoMec.getDatMantenimientoEquipoMecId());
			entity = businessDelegatorView.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);
			businessDelegatorView.deleteDatMantenimientoEquipoMec(entity);
			data.remove(selectedDatMantenimientoEquipoMec);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidad, Double costoTotal, Long datMantenimientoEquipoMecId,
			Date fechaCreacion, Date fechaModificacion, Date fechaRegistro, Double valorUnitario,
			Long ceptoNominaId_ConceptoNomina, Long datMantenimientoEquipoId_DatMantenimientoEquipo,
			Long trabId_Trabajador, Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setCantidad(FacesUtils.checkDouble(cantidad));
			entity.setCostoTotal(FacesUtils.checkDouble(costoTotal));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updateDatMantenimientoEquipoMec(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatMantenimientoEquipoMecView").requestRender();
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

	public InputText getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputText txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputText getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(InputText txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public InputText getTxtDatMantenimientoEquipoId_DatMantenimientoEquipo() {
		return txtDatMantenimientoEquipoId_DatMantenimientoEquipo;
	}

	public void setTxtDatMantenimientoEquipoId_DatMantenimientoEquipo(
			InputText txtDatMantenimientoEquipoId_DatMantenimientoEquipo) {
		this.txtDatMantenimientoEquipoId_DatMantenimientoEquipo = txtDatMantenimientoEquipoId_DatMantenimientoEquipo;
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

	public InputText getTxtDatMantenimientoEquipoMecId() {
		return txtDatMantenimientoEquipoMecId;
	}

	public void setTxtDatMantenimientoEquipoMecId(InputText txtDatMantenimientoEquipoMecId) {
		this.txtDatMantenimientoEquipoMecId = txtDatMantenimientoEquipoMecId;
	}

	public List<DatMantenimientoEquipoMecDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatMantenimientoEquipoMec();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatMantenimientoEquipoMecDTO> datMantenimientoEquipoMecDTO) {
		this.data = datMantenimientoEquipoMecDTO;
	}

	public DatMantenimientoEquipoMecDTO getSelectedDatMantenimientoEquipoMec() {
		return selectedDatMantenimientoEquipoMec;
	}

	public void setSelectedDatMantenimientoEquipoMec(DatMantenimientoEquipoMecDTO datMantenimientoEquipoMec) {
		this.selectedDatMantenimientoEquipoMec = datMantenimientoEquipoMec;
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
}
