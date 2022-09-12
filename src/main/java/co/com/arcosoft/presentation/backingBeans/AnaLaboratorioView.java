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
import co.com.arcosoft.modelo.AnaLaboratorio;
import co.com.arcosoft.modelo.AnaLaboratorioVariable;
import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.VariableLab;
import co.com.arcosoft.modelo.dto.AnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.AnaLaboratorioVariableDTO;
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
public class AnaLaboratorioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(AnaLaboratorioView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtFormula;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private Spinner txtNumeroDecimales;
	private SelectOneMenu txtPeriocidadVariable;
	private SelectOneMenu txtTipoDato;
	private SelectOneMenu txtTipoDeAcumulado;
	private SelectOneMenu txtTipoVariable;
	private InputText txtValorMaximo;
	private InputText txtValorMinimo;
	private InputText txtAnaLabId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private InputText txtOrden;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<AnaLaboratorioDTO> data;
	private AnaLaboratorioDTO selectedAnaLaboratorio;
	private AnaLaboratorio entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private AnaLaboratorioVariableDTO selectedAnaLaboratorioVariable;

	private List<AnaLaboratorioVariableDTO> dataVariablesLab;
	private SelectOneMenu txtVariableLabId_VariableLab;
	SelectItem[] selectVariableLab;
	private List<VariableLab> variableLab;

	private SelectOneMenu txtFrecuenciaDigitacion;
	private Calendar txtHoraInicialDigitacion;

	private int activeTapIndex = 0;
	private CommandButton btnAgregar;
	private AnaLaboratorioVariable entityAnaLaboratorioVariable;
	private SelectOneMenu txtTipoAnalisis;

	public AnaLaboratorioView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedAnaLaboratorio = null;
		setShowDialog(true);
		activeTapIndex = 0;

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedAnaLaboratorio = null;
		PrimeFaces.current().resetInputs(":frm");
		
		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (dataVariablesLab != null) {
			dataVariablesLab = null;
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtTipoAnalisis != null) {
			txtTipoAnalisis.setValue(null);
			txtTipoAnalisis.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtOrden != null) {
			txtOrden.setValue(1);
			txtOrden.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtVariableLabId_VariableLab != null) {
			txtVariableLabId_VariableLab.setValue(null);
			txtVariableLabId_VariableLab.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtAnaLabId != null) {
			txtAnaLabId.setValue(null);
			txtAnaLabId.setDisabled(true);
		}

		if (txtAnaLabId != null) {
			txtAnaLabId.setValue(null);
			txtAnaLabId.setDisabled(true);
		}

		if (txtFrecuenciaDigitacion != null) {
			txtFrecuenciaDigitacion.setValue(null);
			txtFrecuenciaDigitacion.setDisabled(true);
		}

		if (txtHoraInicialDigitacion != null) {
			txtHoraInicialDigitacion.setValue(null);
			txtHoraInicialDigitacion.setDisabled(true);
		}
		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
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

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<AnaLaboratorio> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInAnaLaboratorio(condicion, null, null)
					: null;

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
			txtOrden.setValue(1);
			txtOrden.setDisabled(false);
			txtAnaLabId.setDisabled(false);
			txtVariableLabId_VariableLab.setDisabled(false);
			txtNombre.setDisabled(false);
			txtFrecuenciaDigitacion.setDisabled(false);
			txtHoraInicialDigitacion.setDisabled(false);

			txtTipoAnalisis.setDisabled(false);

			btnSave.setDisabled(false);
			btnAgregar.setDisabled(false);
			activeTapIndex = 0;

		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtAnaLabId.setValue(entity.getAnaLabId());
			txtAnaLabId.setDisabled(true);
			txtFrecuenciaDigitacion.setValue(entity.getFrecuenciaDigitacion());
			txtFrecuenciaDigitacion.setDisabled(false);
			txtHoraInicialDigitacion.setValue(entity.getHoraInicialDigitacion());
			txtHoraInicialDigitacion.setDisabled(false);

			txtTipoAnalisis.setValue(entity.getTipoAnalisis());
			txtTipoAnalisis.setDisabled(false);

			Long anaLaboratorioId = null;
			anaLaboratorioId = FacesUtils.checkLong(txtAnaLabId);

			dataVariablesLab = null;
			dataVariablesLab = businessDelegatorView.getDataAnaLaboratorioVariableByVariable(anaLaboratorioId);

			txtVariableLabId_VariableLab.setDisabled(false);

			txtOrden.setValue(1);
			txtOrden.setDisabled(false);

			btnSave.setDisabled(false);
			btnAgregar.setDisabled(false);

			activeTapIndex = 0;

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedAnaLaboratorio = (AnaLaboratorioDTO) (evt.getComponent().getAttributes().get("selectedAnaLaboratorio"));
		try {

			String codigo = selectedAnaLaboratorio.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<AnaLaboratorio> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInAnaLaboratorio(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtAnaLabId.setValue(entity.getAnaLabId());
				txtAnaLabId.setDisabled(true);

				txtFrecuenciaDigitacion.setValue(entity.getFrecuenciaDigitacion());
				txtFrecuenciaDigitacion.setDisabled(false);
				// txtHoraInicialDigitacion.setValue(entity.getHoraInicialDigitacion());
				// txtHoraInicialDigitacion.setDisabled(false);
				txtTipoAnalisis.setValue(entity.getTipoAnalisis());
				txtTipoAnalisis.setDisabled(false);

				Long anaLaboratorioId = null;
				anaLaboratorioId = FacesUtils.checkLong(txtAnaLabId);

				dataVariablesLab = null;
				dataVariablesLab = businessDelegatorView.getDataAnaLaboratorioVariableByVariable(anaLaboratorioId);

				txtVariableLabId_VariableLab.setDisabled(false);
				txtOrden.setValue(1);
				txtOrden.setDisabled(false);

				btnSave.setDisabled(false);
				btnAgregar.setDisabled(false);

				activeTapIndex = 0;
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedAnaLaboratorio == null) && (entity == null)) {
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
			entity = new AnaLaboratorio();

			// Long anaLaboratorioId = FacesUtils.checkLong(txtAnaLabId);

			Date date = new Date();
			// Long variedId = FacesUtils.checkLong(txtVariedId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setEstado("A");
			entity.setCompania(compania);
			entity.setFechaCreacion(date);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));

			entity.setTipoAnalisis(FacesUtils.checkString(txtTipoAnalisis));

			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date hora = null;
			hora = dateFormat.parse("01/01/1970 06:00");
			entity.setHoraInicialDigitacion(hora);
			entity.setFrecuenciaDigitacion(FacesUtils.checkString(txtFrecuenciaDigitacion));

			businessDelegatorView.saveAnaLaboratorio(entity, dataVariablesLab);
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
				Long anaLaboratorioId = new Long(selectedAnaLaboratorio.getAnaLabId());
				entity = businessDelegatorView.getAnaLaboratorio(anaLaboratorioId);
			}

			Date date = new Date();
			// Long variedId = FacesUtils.checkLong(txtVariedId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setEstado("A");
			entity.setCompania(compania);
			entity.setFechaModificacion(date);
			entity.setTipoAnalisis(FacesUtils.checkString(txtTipoAnalisis));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date hora = null;
			hora = dateFormat.parse("01/01/1970 06:00");
			entity.setHoraInicialDigitacion(hora);
			entity.setHoraInicialDigitacion(hora);
			entity.setFrecuenciaDigitacion(FacesUtils.checkString(txtFrecuenciaDigitacion));

			businessDelegatorView.updateAnaLaboratorio(entity, dataVariablesLab);
			action_clear();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedAnaLaboratorio = (AnaLaboratorioDTO) (evt.getComponent().getAttributes()
					.get("selectedAnaLaboratorio"));

			Long anaLaboratorioId = new Long(selectedAnaLaboratorio.getAnaLabId());
			entity = businessDelegatorView.getAnaLaboratorio(anaLaboratorioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long anaLaboratorioId = FacesUtils.checkLong(txtAnaLabId);
			entity = businessDelegatorView.getAnaLaboratorio(anaLaboratorioId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteAnaLaboratorio(entity);
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
			selectedAnaLaboratorio = (AnaLaboratorioDTO) (evt.getComponent().getAttributes()
					.get("selectedAnaLaboratorio"));

			Long anaLaboratorioId = new Long(selectedAnaLaboratorio.getAnaLabId());
			entity = businessDelegatorView.getAnaLaboratorio(anaLaboratorioId);
			businessDelegatorView.deleteAnaLaboratorio(entity);
			data.remove(selectedAnaLaboratorio);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String formula, String infoAdicional, String infoAdicional2, String nombre,
			Integer numeroDecimales, String periocidadVariable, String tipoDato, String tipoDeAcumulado,
			String tipoVariable, Double valorMaximo, Double valorMinimo, Long anaLaboratorioId) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateAnaLaboratorio(entity, dataVariablesLab);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("AnaLaboratorioView").requestRender();
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

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	/**
	 * @return the txtEstado
	 */
	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	/**
	 * @param txtEstado the txtEstado to set
	 */
	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	/**
	 * @return the txtFormula
	 */
	public InputTextarea getTxtFormula() {
		return txtFormula;
	}

	/**
	 * @param txtFormula the txtFormula to set
	 */
	public void setTxtFormula(InputTextarea txtFormula) {
		this.txtFormula = txtFormula;
	}

	/**
	 * @return the txtInfoAdicional
	 */
	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	/**
	 * @param txtInfoAdicional the txtInfoAdicional to set
	 */
	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	/**
	 * @return the txtInfoAdicional2
	 */
	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	/**
	 * @param txtInfoAdicional2 the txtInfoAdicional2 to set
	 */
	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	/**
	 * @return the txtNombre
	 */
	public InputText getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @param txtNombre the txtNombre to set
	 */
	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * @return the txtNumeroDecimales
	 */
	public Spinner getTxtNumeroDecimales() {
		return txtNumeroDecimales;
	}

	/**
	 * @param txtNumeroDecimales the txtNumeroDecimales to set
	 */
	public void setTxtNumeroDecimales(Spinner txtNumeroDecimales) {
		this.txtNumeroDecimales = txtNumeroDecimales;
	}

	/**
	 * @return the txtPeriocidadVariable
	 */
	public SelectOneMenu getTxtPeriocidadVariable() {
		return txtPeriocidadVariable;
	}

	/**
	 * @param txtPeriocidadVariable the txtPeriocidadVariable to set
	 */
	public void setTxtPeriocidadVariable(SelectOneMenu txtPeriocidadVariable) {
		this.txtPeriocidadVariable = txtPeriocidadVariable;
	}

	/**
	 * @return the txtTipoDato
	 */
	public SelectOneMenu getTxtTipoDato() {
		return txtTipoDato;
	}

	/**
	 * @param txtTipoDato the txtTipoDato to set
	 */
	public void setTxtTipoDato(SelectOneMenu txtTipoDato) {
		this.txtTipoDato = txtTipoDato;
	}

	/**
	 * @return the txtTipoDeAcumulado
	 */
	public SelectOneMenu getTxtTipoDeAcumulado() {
		return txtTipoDeAcumulado;
	}

	/**
	 * @param txtTipoDeAcumulado the txtTipoDeAcumulado to set
	 */
	public void setTxtTipoDeAcumulado(SelectOneMenu txtTipoDeAcumulado) {
		this.txtTipoDeAcumulado = txtTipoDeAcumulado;
	}

	/**
	 * @return the txtTipoVariable
	 */
	public SelectOneMenu getTxtTipoVariable() {
		return txtTipoVariable;
	}

	/**
	 * @param txtTipoVariable the txtTipoVariable to set
	 */
	public void setTxtTipoVariable(SelectOneMenu txtTipoVariable) {
		this.txtTipoVariable = txtTipoVariable;
	}

	/**
	 * @return the txtOrden
	 */
	public InputText getTxtOrden() {
		return txtOrden;
	}

	/**
	 * @param txtOrden the txtOrden to set
	 */
	public void setTxtOrden(InputText txtOrden) {
		this.txtOrden = txtOrden;
	}

	/**
	 * @return the entity
	 */
	public AnaLaboratorio getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(AnaLaboratorio entity) {
		this.entity = entity;
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

	public InputText getTxtValorMaximo() {
		return txtValorMaximo;
	}

	public void setTxtValorMaximo(InputText txtValorMaximo) {
		this.txtValorMaximo = txtValorMaximo;
	}

	public InputText getTxtValorMinimo() {
		return txtValorMinimo;
	}

	public void setTxtValorMinimo(InputText txtValorMinimo) {
		this.txtValorMinimo = txtValorMinimo;
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

	public InputText getTxtAnaLabId() {
		return txtAnaLabId;
	}

	public void setTxtAnaLabId(InputText txtAnaLabId) {
		this.txtAnaLabId = txtAnaLabId;
	}

	public List<AnaLaboratorioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataAnaLaboratorio();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<AnaLaboratorioDTO> anaLaboratorioDTO) {
		this.data = anaLaboratorioDTO;
	}

	public AnaLaboratorioDTO getSelectedAnaLaboratorio() {
		return selectedAnaLaboratorio;
	}

	public void setSelectedAnaLaboratorio(AnaLaboratorioDTO anaLaboratorio) {
		this.selectedAnaLaboratorio = anaLaboratorio;
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

	public void listener_tipoDato() {

		if (txtTipoDato.getValue() != null && txtTipoDato.getValue().equals("Decimal")) {

			txtValorMaximo.setDisabled(false);
			txtValorMinimo.setDisabled(false);
			txtNumeroDecimales.setDisabled(false);
			txtTipoDeAcumulado.setDisabled(false);
		}
	}

	public void listener_tipoVariable() {

		if (txtTipoVariable.getValue() != null && txtTipoVariable.getValue().equals("Formula")) {

			txtFormula.setDisabled(false);
		}
		if (txtTipoVariable.getValue() != null && txtTipoVariable.getValue().equals("Digitada")) {

			txtFormula.setDisabled(true);
		}
	}

	public String actionDeleteVariableLab(ActionEvent evt) {

		try {

			selectedAnaLaboratorioVariable = (AnaLaboratorioVariableDTO) (evt.getComponent().getAttributes()
					.get("selectedAnaLaboratorioVariable"));

			if (selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId() == null) {
				dataVariablesLab.remove(selectedAnaLaboratorioVariable);
			} else {
				Long anaLaboratorioVariableId = new Long(selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId());
				AnaLaboratorioVariable entity = businessDelegatorView
						.getAnaLaboratorioVariable(anaLaboratorioVariableId);
				businessDelegatorView.deleteAnaLaboratorioVariable(entity);
				dataVariablesLab.remove(selectedAnaLaboratorioVariable);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public List<AnaLaboratorioVariableDTO> getAnaLaboratorioVariableId() {

		if (dataVariablesLab == null || dataVariablesLab.size() == 0) {
			return null;
		} else {
			return dataVariablesLab;
		}

	}

	public void action_agregarVariablesLab() throws Exception {

		if (txtVariableLabId_VariableLab.getValue() != null && txtOrden.getValue() != null) {

			// Long tipoRecurso = Long.parseLong(txtTpRecursoId.getValue()
			// .toString());
			Long variableLabId = Long.parseLong(txtVariableLabId_VariableLab.getValue().toString());
			VariableLab variableLab = businessDelegatorView.getVariableLab(variableLabId);
			String codigoVariable = variableLab.getCodigo();

			Long ordenDigitacion = Long.parseLong(txtOrden.getValue().toString());

			boolean existeProducto = false;

			if (dataVariablesLab == null) {
				dataVariablesLab = new ArrayList<AnaLaboratorioVariableDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataVariablesLab.size() > 0) {

				for (AnaLaboratorioVariableDTO d : dataVariablesLab) {

					if (d.getOrdenDigitacion().longValue() == ordenDigitacion.longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upps! Ya éxiste el orden de digitación número " + ordenDigitacion.toString(),
										" " + "Verifie nuevamente. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				AnaLaboratorioVariableDTO anaLaboratorioVariableDTO = new AnaLaboratorioVariableDTO();

				if (variableLab.getPeriocidadVariable() != null) {
					if (variableLab.getPeriocidadVariable().equals(FacesUtils.checkString(txtFrecuenciaDigitacion))) {
						anaLaboratorioVariableDTO.setVariableLabId_VariableLab(variableLab);
						anaLaboratorioVariableDTO.setCodigoVariable(codigoVariable);
						anaLaboratorioVariableDTO.setOrdenDigitacion(ordenDigitacion);
						dataVariablesLab.add(anaLaboratorioVariableDTO);

					} else {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Upps! La frecuencia de la variable no coincide con la definida en el análisis",
										" " + "Verifique en el cátalogo de variables. "));

					}
				}

			}
			variableLab = null;
			codigoVariable = null;
			ordenDigitacion = null;
			variableLabId = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Upps! Verifique que los campos de tipo de recurso,  recurso, unidad de mèdida y rendimeinto tengan valores. ",
					""));
		}
	}

	/**
	 * @return the selectedAnaLaboratorioVariable
	 */
	public AnaLaboratorioVariableDTO getSelectedAnaLaboratorioVariable() {
		return selectedAnaLaboratorioVariable;
	}

	/**
	 * @param selectedAnaLaboratorioVariable the selectedAnaLaboratorioVariable to
	 *                                       set
	 */
	public void setSelectedAnaLaboratorioVariable(AnaLaboratorioVariableDTO selectedAnaLaboratorioVariable) {
		this.selectedAnaLaboratorioVariable = selectedAnaLaboratorioVariable;
	}

	/**
	 * @return the dataVariablesLab
	 */
	public List<AnaLaboratorioVariableDTO> getDataVariablesLab() {
		return dataVariablesLab;
	}

	/**
	 * @param dataVariablesLab the dataVariablesLab to set
	 */
	public void setDataVariablesLab(List<AnaLaboratorioVariableDTO> dataVariablesLab) {
		this.dataVariablesLab = dataVariablesLab;
	}

	/**
	 * @return the txtVariableLabId_VariableLab
	 */
	public SelectOneMenu getTxtVariableLabId_VariableLab() {
		return txtVariableLabId_VariableLab;
	}

	/**
	 * @param txtVariableLabId_VariableLab the txtVariableLabId_VariableLab to set
	 */
	public void setTxtVariableLabId_VariableLab(SelectOneMenu txtVariableLabId_VariableLab) {
		this.txtVariableLabId_VariableLab = txtVariableLabId_VariableLab;
	}

	/**
	 * @return the txtFrecuenciaDigitacion
	 */
	public SelectOneMenu getTxtFrecuenciaDigitacion() {
		return txtFrecuenciaDigitacion;
	}

	/**
	 * @param txtFrecuenciaDigitacion the txtFrecuenciaDigitacion to set
	 */
	public void setTxtFrecuenciaDigitacion(SelectOneMenu txtFrecuenciaDigitacion) {
		this.txtFrecuenciaDigitacion = txtFrecuenciaDigitacion;
	}

	/**
	 * @return the txtHoraInicialDigitacion
	 */
	public Calendar getTxtHoraInicialDigitacion() {
		return txtHoraInicialDigitacion;
	}

	/**
	 * @param txtHoraInicialDigitacion the txtHoraInicialDigitacion to set
	 */
	public void setTxtHoraInicialDigitacion(Calendar txtHoraInicialDigitacion) {
		this.txtHoraInicialDigitacion = txtHoraInicialDigitacion;
	}

	/**
	 * @return the btnAgregar
	 */
	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	/**
	 * @param btnAgregar the btnAgregar to set
	 */
	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public SelectItem[] getselectVariableLab() {

		if (variableLab == null || variableLab.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<VariableLab> lista = businessDelegatorView.findByCriteriaInVariableLab(condicion, null, null);
				selectVariableLab = new SelectItem[lista.size()];

				int i = 0;
				for (VariableLab variableLab : lista) {
					selectVariableLab[i] = new SelectItem(variableLab.getVariableLabId(), variableLab.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectVariableLab;
	}

	public void setselectVariableLab(SelectItem[] selectVariableLab) {
		this.selectVariableLab = selectVariableLab;
	}

	public void onCellEdit(CellEditEvent evt) throws Exception {

		selectedAnaLaboratorioVariable = (AnaLaboratorioVariableDTO) (evt.getComponent().getAttributes()
				.get("selectedAnaLaboratorioVariable"));

		Long anaLaboratorioVariableId = selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId();
		Long anaLaboratorioId = FacesUtils.checkLong(txtAnaLabId);
		String columnaCell = evt.getColumn().getHeaderText();

		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityAnaLaboratorioVariable = null;
			entityAnaLaboratorioVariable = businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId);

			if (columnaCell.equals("Variable")) {

				Long variableLabId = new Long(evt.getNewValue().toString());
				VariableLab variableLab = businessDelegatorView.getVariableLab(variableLabId);

				entityAnaLaboratorioVariable.setVariableLab(variableLab);

			} else if (columnaCell.equals("Orden")) {

				entityAnaLaboratorioVariable.setOrdenDigitacion((Long) newValue);

			}

			entity = businessDelegatorView.getAnaLaboratorio(anaLaboratorioId);
			entityAnaLaboratorioVariable.setAnaLaboratorio(entity);
			businessDelegatorView.updateAnaLaboratorioVariable(entityAnaLaboratorioVariable);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataVariablesLab = null;
			selectedAnaLaboratorioVariable = null;
			entityAnaLaboratorioVariable = null;

			dataVariablesLab = businessDelegatorView.getDataAnaLaboratorioVariableByVariable(anaLaboratorioId);

		}

	}

	public SelectOneMenu getTxtTipoAnalisis() {
		return txtTipoAnalisis;
	}

	public void setTxtTipoAnalisis(SelectOneMenu txtTipoAnalisis) {
		this.txtTipoAnalisis = txtTipoAnalisis;
	}

	public String actionDeleteMovimientos(ActionEvent evt) {
		selectedAnaLaboratorio = (AnaLaboratorioDTO) (evt.getComponent().getAttributes().get("selectedAnaLaboratorio"));

		try {

			Long anaLabId = selectedAnaLaboratorio.getAnaLabId().longValue();
			Object[] condicion1 = { "anaLaboratorio.anaLabId", true, anaLabId, "=" };
			List<DatAnaLaboratorio> lista2 = (anaLabId != null)
					? businessDelegatorView.findByCriteriaInDatAnaLaboratorio(condicion1, null, null)
					: null;

			if (lista2 != null && lista2.size() > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"El análisis que esta intentando eliminar ya tiene digitaciones!", "Verifique por favor!!!"));
			} else {

				//Long iD = selectedAnaLaboratorio.getAnaLabId().longValue();
				Object[] condicion = { "anaLabId", true, anaLabId, "=" };
				List<AnaLaboratorio> lista = (anaLabId != null)
						? businessDelegatorView.findByCriteriaInAnaLaboratorio(condicion, null, null)
						: null;

				if (lista != null && lista.size() > 0) {
					entity = lista.get(0);

					Long borrarDetalle = businessDelegator2View.pr_borrar_analisis_lab_detalle(anaLabId);
					Long borrarCompra = businessDelegator2View.pr_borrar_analisis_lab(anaLabId);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Proceso exitoso!", "El análisis  fue eliminado exitosamente!!!"));

				
				}

			}
			setShowDialog(true);

			activeTapIndex = 0;
			getData();

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

}