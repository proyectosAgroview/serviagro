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
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaSanVeg;
import co.com.arcosoft.modelo.ListValor;
import co.com.arcosoft.modelo.RangoValor;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variable;
import co.com.arcosoft.modelo.dto.ListValorDTO;
import co.com.arcosoft.modelo.dto.RangoValorDTO;
import co.com.arcosoft.modelo.dto.VariableDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VariableView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VariableView.class);
	private InputText txtCodigo;
	private InputText txtCodigoValor;// codigo del valor posible de la variable
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtNombreValor;// nombre del valor posible de la variable
	private InputText txtValorNumerico;// nombre del valor numerico posible de
										// la variable
	private InputText txtValorAlfanumerico;// nombre del valor numerico posible
											// de la variable
	private Spinner txtNumeroDecimales;
	private InputText txtOrden;
	private Spinner txtTiempoDigitacion;
	private InputText txtTipoDato;
	private InputText txtValorMaximo;
	private InputText txtValorMinimo;
	private InputText txtVariableId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnAgregar;// Boton para agregar valores posibles a
										// las variables
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<VariableDTO> data;
	private VariableDTO selectedVariable;
	private Variable entity;
	private String tipoDato;
	private SelectOneMenu selectTipoDato;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	// Sliders
	private int number1;
	private Double valorMin = 0.0;
	private Double valorMax = 100.0;

	// Select Estaciones Climatologicas
	private SelectOneMenu txtAnaSanVegId_AnaSanVeg;
	SelectItem[] selectAnalisis;
	private List<AnaSanVeg> analisis;

	private int number6 = 30;
	private int number7 = 80;

	private List<ListValorDTO> dataValores;
	private ListValorDTO selectedListValor;

	// Nuevos campos para rango valor
	private InputText txtCodigoRango;
	private InputText txtClasificacion;
	private InputText txtValorFinal;
	private InputText txtValorInicial;
	private List<RangoValorDTO> dataRango;
	private RangoValorDTO selectedRangoValor;
	private CommandButton btnAgregarRango;// Boton para agregar rango de valores
											// a las variables

	public VariableView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			VariableDTO variableDTO = (VariableDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(variableDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(variableDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(variableDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(variableDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(variableDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(variableDTO.getNombre());

			if (txtNumeroDecimales == null) {
				txtNumeroDecimales = new Spinner();
			}

			txtNumeroDecimales.setValue(variableDTO.getNumeroDecimales());

			if (txtOrden == null) {
				txtOrden = new InputText();
			}

			txtOrden.setValue(variableDTO.getOrden());

			if (txtTiempoDigitacion == null) {
				txtTiempoDigitacion = new Spinner();
			}

			txtTiempoDigitacion.setValue(variableDTO.getTiempoDigitacion());

			if (txtTipoDato == null) {
				txtTipoDato = new InputText();
			}

			txtTipoDato.setValue(variableDTO.getTipoDato());

			if (txtValorMaximo == null) {
				txtValorMaximo = new InputText();
			}

			txtValorMaximo.setValue(variableDTO.getValorMaximo());

			if (txtValorMinimo == null) {
				txtValorMinimo = new InputText();
			}

			txtValorMinimo.setValue(variableDTO.getValorMinimo());

			if (txtAnaSanVegId_AnaSanVeg == null) {
				txtAnaSanVegId_AnaSanVeg = new SelectOneMenu();
			}

			txtAnaSanVegId_AnaSanVeg.setValue(variableDTO.getAnaSanVegId_AnaSanVeg());

			if (txtVariableId == null) {
				txtVariableId = new InputText();
			}

			txtVariableId.setValue(variableDTO.getVariableId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(variableDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(variableDTO.getFechaModificacion());

			Long variableId = FacesUtils.checkLong(txtVariableId);
			entity = businessDelegatorView.getVariable(variableId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedVariable = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedVariable = null;
		PrimeFaces.current().resetInputs(":dialogVariable :frm");
		listener_tipoDato();

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
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

		if (txtNumeroDecimales != null) {
			txtNumeroDecimales.setValue(null);
			txtNumeroDecimales.setDisabled(true);
		}

		if (txtOrden != null) {
			txtOrden.setValue(null);
			txtOrden.setDisabled(true);
		}

		if (txtTiempoDigitacion != null) {
			txtTiempoDigitacion.setValue(null);
			txtTiempoDigitacion.setDisabled(true);
		}

		if (txtTipoDato != null) {
			txtTipoDato.setValue(null);
			txtTipoDato.setDisabled(true);
		}

		if (selectTipoDato != null) {
			selectTipoDato.setValue(null);
			selectTipoDato.setDisabled(true);
		}

		if (txtValorMaximo != null) {
			txtValorMaximo.setValue(null);
			txtValorMaximo.setDisabled(true);
		}

		if (txtValorMinimo != null) {
			txtValorMinimo.setValue(null);
			txtValorMinimo.setDisabled(true);
		}

		if (txtAnaSanVegId_AnaSanVeg != null) {
			txtAnaSanVegId_AnaSanVeg.setValue(null);
			txtAnaSanVegId_AnaSanVeg.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtVariableId != null) {
			txtVariableId.setValue(null);
			txtVariableId.setDisabled(false);
		}

		if (txtValorAlfanumerico != null) {
			txtValorAlfanumerico.setValue(null);
			txtValorAlfanumerico.setDisabled(true);
		}

		if (txtValorNumerico != null) {
			txtValorNumerico.setValue(null);
			txtValorNumerico.setDisabled(true);
		}

		if (txtClasificacion != null) {
			txtClasificacion.setValue(null);
			txtClasificacion.setDisabled(true);
		}

		if (txtValorInicial != null) {
			txtValorInicial.setValue(null);
			txtValorInicial.setDisabled(true);
		}

		if (txtValorFinal != null) {
			txtValorFinal.setValue(null);
			txtValorFinal.setDisabled(true);
		}

		if (txtNombreValor != null) {
			txtNombreValor.setValue(null);
			txtNombreValor.setDisabled(true);
		}

		if (txtCodigoValor != null) {
			txtCodigoValor.setValue(null);
			txtCodigoValor.setDisabled(true);
		}

		if (txtCodigoRango != null) {
			txtCodigoRango.setValue(null);
			txtCodigoRango.setDisabled(true);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(true);
		}

		if (btnAgregarRango != null) {
			btnAgregarRango.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		dataValores = null;
		dataRango = null;

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

	public void listener_txtId() {
		try {
			Long variableId = FacesUtils.checkLong(txtVariableId);
			entity = (variableId != null) ? businessDelegatorView.getVariable(variableId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNumeroDecimales.setDisabled(false);
			txtOrden.setDisabled(false);
			txtTiempoDigitacion.setDisabled(false);
			txtTipoDato.setDisabled(false);
			txtValorMaximo.setDisabled(false);
			txtValorMinimo.setDisabled(false);
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtVariableId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumeroDecimales.setValue(entity.getNumeroDecimales());
			txtNumeroDecimales.setDisabled(false);
			txtOrden.setValue(entity.getOrden());
			txtOrden.setDisabled(false);
			txtTiempoDigitacion.setValue(entity.getTiempoDigitacion());
			txtTiempoDigitacion.setDisabled(false);
			txtTipoDato.setValue(entity.getTipoDato());
			txtTipoDato.setDisabled(false);
			txtValorMaximo.setValue(entity.getValorMaximo());
			txtValorMaximo.setDisabled(false);
			txtValorMinimo.setValue(entity.getValorMinimo());
			txtValorMinimo.setDisabled(false);
			txtAnaSanVegId_AnaSanVeg.setValue(entity.getAnaSanVeg().getAnaSanVegId());
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
			txtVariableId.setValue(entity.getVariableId());
			txtVariableId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_tipoDato() {

		if (selectTipoDato != null && selectTipoDato.getValue() != null
				&& selectTipoDato.getValue().equals("Decimal")) {

			txtCodigoValor.setDisabled(false);
			txtNombreValor.setDisabled(false);
			txtValorMaximo.setDisabled(false);
			txtValorMinimo.setDisabled(false);
			txtNumeroDecimales.setDisabled(false);
			txtValorAlfanumerico.setDisabled(true);
			txtValorNumerico.setDisabled(false);
			btnAgregar.setDisabled(false);
			btnAgregarRango.setDisabled(false);
		}

		if (selectTipoDato != null && selectTipoDato.getValue() != null && selectTipoDato.getValue().equals("Texto")
				|| selectTipoDato != null && selectTipoDato.getValue() != null
						&& selectTipoDato.getValue().equals("Fecha")) {

			txtCodigoValor.setDisabled(false);
			txtNombreValor.setDisabled(false);
			txtValorMaximo.setDisabled(true);
			txtValorMinimo.setDisabled(true);
			txtNumeroDecimales.setDisabled(true);
			txtValorAlfanumerico.setDisabled(false);
			txtValorNumerico.setDisabled(true);
			btnAgregar.setDisabled(false);
			btnAgregarRango.setDisabled(false);
		}

		if (selectTipoDato != null && selectTipoDato.getValue() != null
				&& selectTipoDato.getValue().equals("Ninguno")) {

			txtCodigoValor.setDisabled(true);
			txtNombreValor.setDisabled(true);
			txtValorMaximo.setDisabled(true);
			txtValorMinimo.setDisabled(true);
			txtNumeroDecimales.setDisabled(true);
			txtValorAlfanumerico.setDisabled(true);
			txtValorNumerico.setDisabled(true);
			btnAgregar.setDisabled(true);
			btnAgregarRango.setDisabled(true);
		}

	}

	public void listener_txtCodigo() throws Exception {

		try {

			String variableCodigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, variableCodigo, "=" };
			List<Variable> lista = (variableCodigo != null)
					? businessDelegatorView.findByCriteriaInVariable(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ variableCodigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			// txtNumeroDecimales.setDisabled(false);
			txtOrden.setDisabled(false);
			txtTiempoDigitacion.setDisabled(false);
			selectTipoDato.setDisabled(false);
			txtValorMaximo.setDisabled(true);
			txtValorMinimo.setDisabled(true);
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			// txtVariableId.setDisabled(false);
			txtCodigoRango.setDisabled(false);
			txtCodigoValor.setDisabled(true);
			txtClasificacion.setDisabled(false);
			txtNombreValor.setDisabled(true);
			txtValorFinal.setDisabled(false);
			txtValorInicial.setDisabled(false);

			txtValorAlfanumerico.setDisabled(true);
			txtValorNumerico.setDisabled(true);

			btnAgregar.setDisabled(true);
			btnAgregarRango.setDisabled(true);
			btnSave.setDisabled(false);

			listener_tipoDato();
		} else {

			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumeroDecimales.setValue(entity.getNumeroDecimales());
			// txtNumeroDecimales.setDisabled(false);
			txtOrden.setValue(entity.getOrden());
			txtOrden.setDisabled(false);
			txtTiempoDigitacion.setValue(entity.getTiempoDigitacion());
			txtTiempoDigitacion.setDisabled(false);
			selectTipoDato.setValue(entity.getTipoDato());
			selectTipoDato.setDisabled(false);
			txtValorMaximo.setValue(entity.getValorMaximo());
			txtValorMaximo.setDisabled(true);
			txtValorMinimo.setValue(entity.getValorMinimo());
			txtValorMinimo.setDisabled(true);

			txtCodigoRango.setDisabled(false);
			txtCodigoValor.setDisabled(false);
			txtClasificacion.setDisabled(false);
			txtNombreValor.setDisabled(false);
			txtValorFinal.setDisabled(false);
			txtValorInicial.setDisabled(false);
			btnAgregar.setDisabled(false);
			btnAgregarRango.setDisabled(false);
			// txtValorAlfanumerico.setDisabled(true);
			// txtValorNumerico.setDisabled(true);

			txtAnaSanVegId_AnaSanVeg.setValue(entity.getAnaSanVeg().getAnaSanVegId());
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
			txtVariableId.setValue(entity.getVariableId());
			txtVariableId.setDisabled(true);
			Long variableId = FacesUtils.checkLong(txtVariableId);
			dataValores = null;
			dataRango = null;
			dataValores = businessDelegatorView.getDataValoresByVariableId(variableId);
			dataRango = businessDelegatorView.getDataRangoByVariableId(variableId);

			btnSave.setDisabled(false);
			listener_tipoDato();

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}

	}

	public String action_edit(ActionEvent evt) {
		selectedVariable = (VariableDTO) (evt.getComponent().getAttributes().get("selectedVariable"));

		try {

			String codigo = selectedVariable.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Variable> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVariable(condicion, null, null) : null;

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
				txtNumeroDecimales.setValue(entity.getNumeroDecimales());
				txtNumeroDecimales.setDisabled(false);
				txtOrden.setValue(entity.getOrden());
				txtOrden.setDisabled(false);
				txtTiempoDigitacion.setValue(entity.getTiempoDigitacion());
				txtTiempoDigitacion.setDisabled(false);
				selectTipoDato.setValue(entity.getTipoDato());
				selectTipoDato.setDisabled(false);
				txtValorMaximo.setValue(entity.getValorMaximo());
				txtValorMaximo.setDisabled(false);
				txtValorMinimo.setValue(entity.getValorMinimo());
				txtValorMinimo.setDisabled(false);
				txtAnaSanVegId_AnaSanVeg.setValue(selectedVariable.getAnaSanVegId_AnaSanVeg());
				txtAnaSanVegId_AnaSanVeg.setDisabled(false);
				txtVariableId.setValue(entity.getVariableId());
				txtVariableId.setDisabled(false);
				Long variableId = FacesUtils.checkLong(txtVariableId);
				dataValores = null;
				dataRango = null;
				dataValores = businessDelegatorView.getDataValoresByVariableId(variableId);
				dataRango = businessDelegatorView.getDataRangoByVariableId(variableId);
				listener_tipoDato();
				txtCodigoRango.setDisabled(false);
				txtCodigoValor.setDisabled(false);
				txtClasificacion.setDisabled(false);
				txtNombreValor.setDisabled(false);
				txtValorFinal.setDisabled(false);
				txtValorInicial.setDisabled(false);
				btnAgregar.setDisabled(false);
				btnAgregarRango.setDisabled(false);
				btnSave.setDisabled(false);
				setShowDialog(true);
			}

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";

	}

	public String action_save() {
		try {

			if ((selectedVariable == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new Variable();

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumeroDecimales(FacesUtils.checkLong(txtNumeroDecimales));
			entity.setOrden(FacesUtils.checkLong(txtOrden));
			entity.setTiempoDigitacion(FacesUtils.checkLong(txtTiempoDigitacion));
			entity.setTipoDato(FacesUtils.checkString(selectTipoDato));
			entity.setValorMaximo(FacesUtils.checkDouble(txtValorMaximo));
			entity.setValorMinimo(FacesUtils.checkDouble(txtValorMinimo));
			// entity.setVariableId(variableId);
			entity.setAnaSanVeg((FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg) != null)
					? businessDelegatorView.getAnaSanVeg(FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg)) : null);
			businessDelegatorView.saveVariable(entity, dataValores, dataRango);
			listener_tipoDato();
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
				Long variableId = new Long(selectedVariable.getVariableId());
				entity = businessDelegatorView.getVariable(variableId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumeroDecimales(FacesUtils.checkLong(txtNumeroDecimales));
			entity.setOrden(FacesUtils.checkLong(txtOrden));
			entity.setTiempoDigitacion(FacesUtils.checkLong(txtTiempoDigitacion));
			entity.setTipoDato(FacesUtils.checkString(selectTipoDato));
			entity.setValorMaximo(FacesUtils.checkDouble(txtValorMaximo));
			entity.setValorMinimo(FacesUtils.checkDouble(txtValorMinimo));
			entity.setAnaSanVeg((FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg) != null)
					? businessDelegatorView.getAnaSanVeg(FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg)) : null);
			businessDelegatorView.updateVariable(entity, dataValores, dataRango);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedVariable = (VariableDTO) (evt.getComponent().getAttributes().get("selectedVariable"));

			Long variableId = new Long(selectedVariable.getVariableId());
			entity = businessDelegatorView.getVariable(variableId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long variableId = FacesUtils.checkLong(txtVariableId);
			entity = businessDelegatorView.getVariable(variableId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteVariable(entity);
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
			selectedVariable = (VariableDTO) (evt.getComponent().getAttributes().get("selectedVariable"));

			Long variableId = new Long(selectedVariable.getVariableId());
			entity = businessDelegatorView.getVariable(variableId);
			businessDelegatorView.deleteVariable(entity);
			data.remove(selectedVariable);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String estado, Date fechaCreacion,
			Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre, Long numeroDecimales,
			Long orden, Long tiempoDigitacion, String tipoDato, Double valorMaximo, Double valorMinimo, Long variableId,
			Long anaSanVegId_AnaSanVeg) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setNumeroDecimales(FacesUtils.checkLong(numeroDecimales));
			entity.setOrden(FacesUtils.checkLong(orden));
			entity.setTiempoDigitacion(FacesUtils.checkLong(tiempoDigitacion));
			entity.setTipoDato(FacesUtils.checkString(tipoDato));
			entity.setValorMaximo(FacesUtils.checkDouble(valorMaximo));
			entity.setValorMinimo(FacesUtils.checkDouble(valorMinimo));
			// businessDelegatorView.updateVariable(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("VariableView").requestRender();
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public Spinner getTxtNumeroDecimales() {
		return txtNumeroDecimales;
	}

	public void setTxtNumeroDecimales(Spinner txtNumeroDecimales) {
		this.txtNumeroDecimales = txtNumeroDecimales;
	}

	public InputText getTxtOrden() {
		return txtOrden;
	}

	public void setTxtOrden(InputText txtOrden) {
		this.txtOrden = txtOrden;
	}

	public Spinner getTxtTiempoDigitacion() {
		return txtTiempoDigitacion;
	}

	public void setTxtTiempoDigitacion(Spinner txtTiempoDigitacion) {
		this.txtTiempoDigitacion = txtTiempoDigitacion;
	}

	public InputText getTxtTipoDato() {
		return txtTipoDato;
	}

	public void setTxtTipoDato(InputText txtTipoDato) {
		this.txtTipoDato = txtTipoDato;
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

	public SelectOneMenu getTxtAnaSanVegId_AnaSanVeg() {
		return txtAnaSanVegId_AnaSanVeg;
	}

	public void setTxtAnaSanVegId_AnaSanVeg(SelectOneMenu txtAnaSanVegId_AnaSanVeg) {
		this.txtAnaSanVegId_AnaSanVeg = txtAnaSanVegId_AnaSanVeg;
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

	public InputText getTxtVariableId() {
		return txtVariableId;
	}

	public void setTxtVariableId(InputText txtVariableId) {
		this.txtVariableId = txtVariableId;
	}

	public List<VariableDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVariable();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<VariableDTO> variableDTO) {
		this.data = variableDTO;
	}

	public VariableDTO getSelectedVariable() {
		return selectedVariable;
	}

	public void setSelectedVariable(VariableDTO variable) {
		this.selectedVariable = variable;
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

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public SelectOneMenu getSelectTipoDato() {
		return selectTipoDato;
	}

	public void setSelectTipoDato(SelectOneMenu selectTipoDato) {
		this.selectTipoDato = selectTipoDato;
	}

	public SelectItem[] getSelectAnalisis() {

		if (analisis == null || analisis.size() == 0) {

			analisis = new ArrayList<AnaSanVeg>();

			try {

				analisis = businessDelegatorView.getAnaSanVeg(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<AnaSanVeg> lista = businessDelegatorView.findByCriteriaInAnaSanVeg(condicion, null, null);
				selectAnalisis = new SelectItem[lista.size()];

				int i = 0;
				for (AnaSanVeg ana : lista) {
					selectAnalisis[i] = new SelectItem(ana.getAnaSanVegId(), ana.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAnalisis;
	}

	public void setSelectAnalisis(SelectItem[] selectAnalisis) {
		this.selectAnalisis = selectAnalisis;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public Double getValorMin() {
		return valorMin;
	}

	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
	}

	public Double getValorMax() {
		return valorMax;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

	public int getNumber6() {
		return number6;
	}

	public void setNumber6(int number6) {
		this.number6 = number6;
	}

	public int getNumber7() {
		return number7;
	}

	public void setNumber7(int number7) {
		this.number7 = number7;
	}

	public InputText getTxtCodigoValor() {
		return txtCodigoValor;
	}

	public void setTxtCodigoValor(InputText txtCodigoValor) {
		this.txtCodigoValor = txtCodigoValor;
	}

	public InputText getTxtNombreValor() {
		return txtNombreValor;
	}

	public void setTxtNombreValor(InputText txtNombreValor) {
		this.txtNombreValor = txtNombreValor;
	}

	public InputText getTxtValorNumerico() {
		return txtValorNumerico;
	}

	public void setTxtValorNumerico(InputText txtValorNumerico) {
		this.txtValorNumerico = txtValorNumerico;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<ListValorDTO> getDataValores() {

		if (dataValores == null || dataValores.size() == 0) {
			return null;
		} else {
			return dataValores;
		}

	}

	public void setDataRango(List<RangoValorDTO> dataRango) {
		this.dataRango = dataRango;
	}

	public List<RangoValorDTO> getDataRango() {

		if (dataRango == null || dataRango.size() == 0) {
			return null;
		} else {
			return dataRango;
		}

	}

	public InputText getTxtValorAlfanumerico() {
		return txtValorAlfanumerico;
	}

	public void setTxtValorAlfanumerico(InputText txtValorAlfanumerico) {
		this.txtValorAlfanumerico = txtValorAlfanumerico;
	}

	public void action_agregarValoresPosibles() {

		String codigo = (String) txtCodigoValor.getValue();
		String nombre = (String) txtNombreValor.getValue();
		Long valorNumerico = FacesUtils.checkLong(txtValorNumerico);
		String valorAlfanumerico = (String) txtValorAlfanumerico.getValue();

		ListValorDTO listValorDTO = new ListValorDTO();

		listValorDTO.setCodigo(codigo);
		listValorDTO.setClasificacion(nombre);
		listValorDTO.setValorAlfaNumerico(valorAlfanumerico);
		listValorDTO.setValorNumerico(valorNumerico);

		if (dataValores == null) {
			dataValores = new ArrayList<ListValorDTO>();
		}

		dataValores.add(listValorDTO);

	}

	public void action_agregarRango() {

		String codigo = (String) txtCodigoRango.getValue();
		String clasificacion = (String) txtClasificacion.getValue();
		double valorInicial = FacesUtils.checkDouble(txtValorInicial);
		double valorFinal = FacesUtils.checkDouble(txtValorFinal);

		RangoValorDTO rangoValorDTO = new RangoValorDTO();

		rangoValorDTO.setCodigo(codigo);
		rangoValorDTO.setClasificacion(clasificacion);
		rangoValorDTO.setValorInicial(valorInicial);
		rangoValorDTO.setValorFinal(valorFinal);

		if (dataRango == null) {
			dataRango = new ArrayList<RangoValorDTO>();
		}

		dataRango.add(rangoValorDTO);

	}

	public void rowEventEditValorListener(RowEditEvent e) {

		try {

			ListValorDTO listValorDTO = (ListValorDTO) e.getObject();

			if (txtCodigoValor == null) {
				txtCodigoValor = new InputText();
			}

			txtCodigoValor.setValue(listValorDTO.getCodigo());

			if (txtNombreValor == null) {
				txtNombreValor = new InputText();
			}

			txtNombreValor.setValue(listValorDTO.getClasificacion());

			if (txtValorNumerico == null) {
				txtValorNumerico = new InputText();

			}

			txtValorNumerico.setValue(listValorDTO.getValorNumerico());

			if (txtValorAlfanumerico == null) {
				txtValorAlfanumerico = new InputText();
			}

			txtValorAlfanumerico.setValue(listValorDTO.getValorAlfaNumerico());

			dataValores = new ArrayList<ListValorDTO>();
			dataValores.add(listValorDTO);

		} catch (Exception ex) {
		}

	}

	public void onRowCancelValor(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Edit Cancelled", ((ListValorDTO) event.getObject()).getCodigo());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowEditRango(RowEditEvent event) {

	}

	public void onRowCancelRango(RowEditEvent event) {

	}

	public String actionDeleteListaValor(ActionEvent evt) {
		try {

			selectedListValor = (ListValorDTO) (evt.getComponent().getAttributes().get("selectedListValor"));

			if (selectedListValor.getListValorId() == null) {
				dataValores.remove(selectedListValor);
			} else {
				Long listValorId = new Long(selectedListValor.getListValorId());
				ListValor entity = businessDelegatorView.getListValor(listValorId);
				businessDelegatorView.deleteListValor(entity);
				dataValores.remove(selectedListValor);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteRangoValor(ActionEvent evt) {
		try {

			selectedRangoValor = (RangoValorDTO) (evt.getComponent().getAttributes().get("selectedRangoValor"));

			if (selectedRangoValor.getRangoValorId() == null) {
				dataRango.remove(selectedRangoValor);
			} else {
				Long rangoValorId = new Long(selectedRangoValor.getRangoValorId());
				RangoValor entity = businessDelegatorView.getRangoValor(rangoValorId);
				businessDelegatorView.deleteRangoValor(entity);
				dataRango.remove(selectedRangoValor);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public InputText getTxtCodigoRango() {
		return txtCodigoRango;
	}

	public void setTxtCodigoRango(InputText txtCodigoRango) {
		this.txtCodigoRango = txtCodigoRango;
	}

	public InputText getTxtClasificacion() {
		return txtClasificacion;
	}

	public void setTxtClasificacion(InputText txtClasificacion) {
		this.txtClasificacion = txtClasificacion;
	}

	public InputText getTxtValorFinal() {
		return txtValorFinal;
	}

	public void setTxtValorFinal(InputText txtValorFinal) {
		this.txtValorFinal = txtValorFinal;
	}

	public InputText getTxtValorInicial() {
		return txtValorInicial;
	}

	public void setTxtValorInicial(InputText txtValorInicial) {
		this.txtValorInicial = txtValorInicial;
	}

	public CommandButton getBtnAgregarRango() {
		return btnAgregarRango;
	}

	public void setBtnAgregarRango(CommandButton btnAgregarRango) {
		this.btnAgregarRango = btnAgregarRango;
	}

}
