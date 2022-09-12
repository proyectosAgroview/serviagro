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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.colorpicker.ColorPicker;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ColorIdentProduccion;
import co.com.arcosoft.modelo.dto.ColorIdentProduccionDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ColorIdentProduccionView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ColorIdentProduccionView.class);
	private InputText txtCodigo;
	private ColorPicker txtColor;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private Spinner txtOrdenIdentificacion;
	private InputText txtColorIdentProdId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ColorIdentProduccionDTO> data;
	private ColorIdentProduccionDTO selectedColorIdentProduccion;
	private ColorIdentProduccion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ColorIdentProduccionView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ColorIdentProduccionDTO colorIdentProduccionDTO = (ColorIdentProduccionDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(colorIdentProduccionDTO.getCodigo());

			if (txtColor == null) {
				txtColor = new ColorPicker();
			}

			txtColor.setValue(colorIdentProduccionDTO.getColor());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(colorIdentProduccionDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(colorIdentProduccionDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(colorIdentProduccionDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(colorIdentProduccionDTO.getNombre());

			if (txtOrdenIdentificacion == null) {
				txtOrdenIdentificacion = new Spinner();
			}

			txtOrdenIdentificacion.setValue(colorIdentProduccionDTO.getOrdenIdentificacion());

			if (txtColorIdentProdId == null) {
				txtColorIdentProdId = new InputText();
			}

			txtColorIdentProdId.setValue(colorIdentProduccionDTO.getColorIdentProdId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(colorIdentProduccionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(colorIdentProduccionDTO.getFechaModificacion());

			Long colorIdentProdId = FacesUtils.checkLong(txtColorIdentProdId);
			entity = businessDelegatorView.getColorIdentProduccion(colorIdentProdId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedColorIdentProduccion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedColorIdentProduccion = null;
		PrimeFaces.current().resetInputs(":dialogColorIdentProduccion :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtColor != null) {
			txtColor.setValue(null);
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

		if (txtOrdenIdentificacion != null) {
			txtOrdenIdentificacion.setValue(null);
			txtOrdenIdentificacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtColorIdentProdId != null) {
			txtColorIdentProdId.setValue(null);
			txtColorIdentProdId.setDisabled(true);

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

	public void listener_txtCodigo() {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<ColorIdentProduccion> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInColorIdentProduccion(condicion, null, null) : null;

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
			txtCodigo.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOrdenIdentificacion.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtColor.setValue(entity.getColor());
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOrdenIdentificacion.setValue(entity.getOrdenIdentificacion());
			txtOrdenIdentificacion.setDisabled(false);
			txtColorIdentProdId.setValue(entity.getColorIdentProdId());
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedColorIdentProduccion = (ColorIdentProduccionDTO) (evt.getComponent().getAttributes()
				.get("selectedColorIdentProduccion"));
		try {

			String codigo = selectedColorIdentProduccion.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<ColorIdentProduccion> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInColorIdentProduccion(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtColor.setValue(entity.getColor());
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtOrdenIdentificacion.setValue(entity.getOrdenIdentificacion());
				txtOrdenIdentificacion.setDisabled(false);
				txtColorIdentProdId.setValue(entity.getColorIdentProdId());
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
			if ((selectedColorIdentProduccion == null) && (entity == null)) {
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
			entity = new ColorIdentProduccion();
			Date date = new Date();
			// Long colorIdentProdId =
			// FacesUtils.checkLong(txtColorIdentProdId);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setColor(FacesUtils.checkString(txtColor));
			// entity.setColorIdentProdId(colorIdentProdId);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOrdenIdentificacion(FacesUtils.checkLong(txtOrdenIdentificacion));
			businessDelegatorView.saveColorIdentProduccion(entity);
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
				Long colorIdentProdId = new Long(selectedColorIdentProduccion.getColorIdentProdId());
				entity = businessDelegatorView.getColorIdentProduccion(colorIdentProdId);
			}
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOrdenIdentificacion(FacesUtils.checkLong(txtOrdenIdentificacion));
			businessDelegatorView.updateColorIdentProduccion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedColorIdentProduccion = (ColorIdentProduccionDTO) (evt.getComponent().getAttributes()
					.get("selectedColorIdentProduccion"));

			Long colorIdentProdId = new Long(selectedColorIdentProduccion.getColorIdentProdId());
			entity = businessDelegatorView.getColorIdentProduccion(colorIdentProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long colorIdentProdId = FacesUtils.checkLong(txtColorIdentProdId);
			entity = businessDelegatorView.getColorIdentProduccion(colorIdentProdId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteColorIdentProduccion(entity);
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
			selectedColorIdentProduccion = (ColorIdentProduccionDTO) (evt.getComponent().getAttributes()
					.get("selectedColorIdentProduccion"));

			Long colorIdentProdId = new Long(selectedColorIdentProduccion.getColorIdentProdId());
			entity = businessDelegatorView.getColorIdentProduccion(colorIdentProdId);
			businessDelegatorView.deleteColorIdentProduccion(entity);
			data.remove(selectedColorIdentProduccion);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String color, Long colorIdentProdId, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre,
			Long ordenIdentificacion) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setColor(FacesUtils.checkString(color));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOrdenIdentificacion(FacesUtils.checkLong(ordenIdentificacion));
			businessDelegatorView.updateColorIdentProduccion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ColorIdentProduccionView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
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

	public List<ColorIdentProduccionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataColorIdentProduccion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ColorIdentProduccionDTO> colorIdentProduccionDTO) {
		this.data = colorIdentProduccionDTO;
	}

	public ColorIdentProduccionDTO getSelectedColorIdentProduccion() {
		return selectedColorIdentProduccion;
	}

	public void setSelectedColorIdentProduccion(ColorIdentProduccionDTO colorIdentProduccion) {
		this.selectedColorIdentProduccion = colorIdentProduccion;
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

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	public void setTxtOrdenIdentificacion(Spinner txtOrdenIdentificacion) {
		this.txtOrdenIdentificacion = txtOrdenIdentificacion;
	}

	public void setTxtColorIdentProdId(InputText txtColorIdentProdId) {
		this.txtColorIdentProdId = txtColorIdentProdId;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	public Spinner getTxtOrdenIdentificacion() {
		return txtOrdenIdentificacion;
	}

	public InputText getTxtColorIdentProdId() {
		return txtColorIdentProdId;
	}

}
