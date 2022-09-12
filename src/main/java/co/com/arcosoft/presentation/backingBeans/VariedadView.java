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
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.VariedadDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VariedadView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VariedadView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private InputText txtEdadCosecha;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtPeso;
	private InputTextarea txtColor;
	private InputTextarea txtDiametro;
	private InputTextarea txtForma;
	private InputTextarea txtLimpieza;
	private InputTextarea txtRecepcion;
	private InputTextarea txtCondicionesRechazo;
	private InputText txtNombre;
	private SelectOneRadio txtTipoMaduracion;
	// private InputText txtCultivoId_Cultivo;
	private InputText txtVariedId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<VariedadDTO> data;
	private VariedadDTO selectedVariedad;
	private Variedad entity;
	private boolean showDialog;

	// Select Cultivos
	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	private double result;
	private int activeTapIndex = 0;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public VariedadView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			VariedadDTO variedadDTO = (VariedadDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(variedadDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(variedadDTO.getCompania());

			if (txtEdadCosecha == null) {
				txtEdadCosecha = new InputText();
			}

			txtEdadCosecha.setValue(variedadDTO.getEdadCosecha());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(variedadDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(variedadDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(variedadDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(variedadDTO.getNombre());

			if (txtTipoMaduracion == null) {
				txtTipoMaduracion = new SelectOneRadio();
			}

			txtTipoMaduracion.setValue(variedadDTO.getTipoMaduracion());

			if (txtCultivoId_Cultivo == null) {
				txtCultivoId_Cultivo = new SelectOneMenu();
			}

			txtCultivoId_Cultivo.setValue(variedadDTO.getCultivoId_Cultivo());

			if (txtVariedId == null) {
				txtVariedId = new InputText();
			}

			txtVariedId.setValue(variedadDTO.getVariedId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(variedadDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(variedadDTO.getFechaModificacion());

			Long variedId = FacesUtils.checkLong(txtVariedId);
			entity = businessDelegatorView.getVariedad(variedId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedVariedad = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedVariedad = null;
		PrimeFaces.current().resetInputs(":dialogVariedad :frm");
		activeTapIndex = 0;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtPeso != null) {
			txtPeso.setValue(null);
			txtPeso.setDisabled(true);
		}

		if (txtColor != null) {
			txtColor.setValue(null);
			txtColor.setDisabled(true);
		}

		if (txtForma != null) {
			txtForma.setValue(null);
			txtForma.setDisabled(true);
		}

		if (txtDiametro != null) {
			txtDiametro.setValue(null);
			txtDiametro.setDisabled(true);
		}

		if (txtLimpieza != null) {
			txtLimpieza.setValue(null);
			txtLimpieza.setDisabled(true);
		}

		if (txtRecepcion != null) {
			txtRecepcion.setValue(null);
			txtRecepcion.setDisabled(true);
		}

		if (txtCondicionesRechazo != null) {
			txtCondicionesRechazo.setValue(null);
			txtCondicionesRechazo.setDisabled(true);
		}

		if (txtEdadCosecha != null) {
			txtEdadCosecha.setValue(null);
			txtEdadCosecha.setDisabled(true);
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

		if (txtTipoMaduracion != null) {
			txtTipoMaduracion.setValue(null);
			txtTipoMaduracion.setDisabled(true);
		}

		if (txtCultivoId_Cultivo != null) {
			txtCultivoId_Cultivo.setValue(null);
			txtCultivoId_Cultivo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtVariedId != null) {
			txtVariedId.setValue(null);
			txtVariedId.setDisabled(false);
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

	public void listener_txtId() {
		try {
			Long variedId = FacesUtils.checkLong(txtVariedId);
			entity = (variedId != null) ? businessDelegatorView.getVariedad(variedId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEdadCosecha.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtTipoMaduracion.setDisabled(false);
			txtCultivoId_Cultivo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtVariedId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEdadCosecha.setValue(entity.getEdadCosecha());
			txtEdadCosecha.setDisabled(false);
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
			txtTipoMaduracion.setValue(entity.getTipoMaduracion());
			txtTipoMaduracion.setDisabled(false);
			txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			txtVariedId.setValue(entity.getVariedId());
			txtVariedId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Variedad> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVariedad(condicion, null, null) : null;

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
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			// txtEdadCosecha.setValue(entity.getEdadCosecha());
			txtEdadCosecha.setDisabled(false);
			// txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			// txtTipoMaduracion.setValue(entity.getTipoMaduracion());
			txtTipoMaduracion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPeso.setDisabled(false);
			txtColor.setDisabled(false);
			txtForma.setDisabled(false);
			txtDiametro.setDisabled(false);
			txtLimpieza.setDisabled(false);
			txtRecepcion.setDisabled(false);
			txtCondicionesRechazo.setDisabled(false);

			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			btnSave.setDisabled(false);
		} else {

			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtPeso.setValue(entity.getPeso());
			txtPeso.setDisabled(false);
			txtColor.setValue(entity.getColor());
			txtColor.setDisabled(false);
			txtForma.setValue(entity.getForma());
			txtForma.setDisabled(false);
			txtDiametro.setValue(entity.getDiametro());
			txtDiametro.setDisabled(false);
			txtLimpieza.setValue(entity.getLimpieza());
			txtLimpieza.setDisabled(false);
			txtRecepcion.setValue(entity.getRecepcion());
			txtRecepcion.setDisabled(false);
			txtCondicionesRechazo.setValue(entity.getCondicionesRechazo());
			txtCondicionesRechazo.setDisabled(false);

			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEdadCosecha.setValue(entity.getEdadCosecha());
			txtEdadCosecha.setDisabled(false);
			txtCultivoId_Cultivo.setValue(entity.getCultivo().getCultivoId());
			txtCultivoId_Cultivo.setDisabled(false);
			txtTipoMaduracion.setValue(entity.getTipoMaduracion());
			txtTipoMaduracion.setDisabled(false);
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
			txtVariedId.setValue(entity.getVariedId());
			txtVariedId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedVariedad = (VariedadDTO) (evt.getComponent().getAttributes().get("selectedVariedad"));
		try {

			String codigo = selectedVariedad.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Variedad> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVariedad(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				selectedVariedad = (VariedadDTO) (evt.getComponent().getAttributes().get("selectedVariedad"));
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(selectedVariedad.getCompania());
				// txtCompania.setDisabled(false);
				txtEdadCosecha.setValue(entity.getEdadCosecha());
				txtEdadCosecha.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtPeso.setValue(entity.getPeso());
				txtPeso.setDisabled(false);
				txtColor.setValue(entity.getColor());
				txtColor.setDisabled(false);
				txtForma.setValue(entity.getForma());
				txtForma.setDisabled(false);
				txtDiametro.setValue(entity.getDiametro());
				txtDiametro.setDisabled(false);
				txtLimpieza.setValue(entity.getLimpieza());
				txtLimpieza.setDisabled(false);
				txtRecepcion.setValue(entity.getRecepcion());
				txtRecepcion.setDisabled(false);
				txtCondicionesRechazo.setValue(entity.getCondicionesRechazo());
				txtCondicionesRechazo.setDisabled(false);

				// txtFechaCreacion.setValue(selectedVariedad.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedVariedad.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtTipoMaduracion.setValue(entity.getTipoMaduracion());
				txtTipoMaduracion.setDisabled(false);
				txtCultivoId_Cultivo.setValue(selectedVariedad.getCultivoId_Cultivo());
				txtCultivoId_Cultivo.setDisabled(false);
				txtVariedId.setValue(entity.getVariedId());
				txtVariedId.setDisabled(true);
				btnSave.setDisabled(false);
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
			if ((selectedVariedad == null) && (entity == null)) {
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
			entity = new Variedad();
			Date date = new Date();
			// Long variedId = FacesUtils.checkLong(txtVariedId);
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEdadCosecha(FacesUtils.checkDouble(txtEdadCosecha));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setPeso(FacesUtils.checkString(txtPeso));
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setDiametro(FacesUtils.checkString(txtDiametro));
			entity.setForma(FacesUtils.checkString(txtForma));
			entity.setLimpieza(FacesUtils.checkString(txtLimpieza));
			entity.setCondicionesRechazo(FacesUtils.checkString(txtCondicionesRechazo));
			entity.setRecepcion(FacesUtils.checkString(txtRecepcion));

			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTipoMaduracion(FacesUtils.checkString(txtTipoMaduracion));
			// entity.setVariedId(variedId);
			entity.setCultivo((FacesUtils.checkLong(txtCultivoId_Cultivo) != null)
					? businessDelegatorView.getCultivo(FacesUtils.checkLong(txtCultivoId_Cultivo)) : null);
			businessDelegatorView.saveVariedad(entity);
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
				Long variedId = new Long(selectedVariedad.getVariedId());
				entity = businessDelegatorView.getVariedad(variedId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setPeso(FacesUtils.checkString(txtPeso));
			entity.setColor(FacesUtils.checkString(txtColor));
			entity.setDiametro(FacesUtils.checkString(txtDiametro));
			entity.setForma(FacesUtils.checkString(txtForma));
			entity.setLimpieza(FacesUtils.checkString(txtLimpieza));
			entity.setCondicionesRechazo(FacesUtils.checkString(txtCondicionesRechazo));
			entity.setRecepcion(FacesUtils.checkString(txtRecepcion));

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEdadCosecha(FacesUtils.checkDouble(txtEdadCosecha));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTipoMaduracion(FacesUtils.checkString(txtTipoMaduracion));
			entity.setCultivo((FacesUtils.checkLong(txtCultivoId_Cultivo) != null)
					? businessDelegatorView.getCultivo(FacesUtils.checkLong(txtCultivoId_Cultivo)) : null);
			businessDelegatorView.updateVariedad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedVariedad = (VariedadDTO) (evt.getComponent().getAttributes().get("selectedVariedad"));

			Long variedId = new Long(selectedVariedad.getVariedId());
			entity = businessDelegatorView.getVariedad(variedId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long variedId = FacesUtils.checkLong(txtVariedId);
			entity = businessDelegatorView.getVariedad(variedId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteVariedad(entity);
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
			selectedVariedad = (VariedadDTO) (evt.getComponent().getAttributes().get("selectedVariedad"));

			Long variedId = new Long(selectedVariedad.getVariedId());
			entity = businessDelegatorView.getVariedad(variedId);
			businessDelegatorView.deleteVariedad(entity);
			data.remove(selectedVariedad);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, Double edadCosecha, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre,
			String tipoMaduracion, Long variedId, Long cultivoId_Cultivo) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEdadCosecha(FacesUtils.checkDouble(edadCosecha));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setTipoMaduracion(FacesUtils.checkString(tipoMaduracion));
			businessDelegatorView.updateVariedad(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("VariedadView").requestRender();
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

	public InputText getTxtEdadCosecha() {
		return txtEdadCosecha;
	}

	public void setTxtEdadCosecha(InputText txtEdadCosecha) {
		this.txtEdadCosecha = txtEdadCosecha;
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

	public SelectOneRadio getTxtTipoMaduracion() {
		return txtTipoMaduracion;
	}

	public void setTxtTipoMaduracion(SelectOneRadio txtTipoMaduracion) {
		this.txtTipoMaduracion = txtTipoMaduracion;
	}

	public SelectOneMenu getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(SelectOneMenu txtCultivoId_Cultivo) {
		this.txtCultivoId_Cultivo = txtCultivoId_Cultivo;
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

	public InputText getTxtVariedId() {
		return txtVariedId;
	}

	public void setTxtVariedId(InputText txtVariedId) {
		this.txtVariedId = txtVariedId;
	}

	public List<VariedadDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVariedad();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<VariedadDTO> variedadDTO) {
		this.data = variedadDTO;
	}

	public VariedadDTO getSelectedVariedad() {
		return selectedVariedad;
	}

	public void setSelectedVariedad(VariedadDTO variedad) {
		this.selectedVariedad = variedad;
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

	public SelectItem[] getSelectCultivo() {

		if (cultivo == null || cultivo.size() == 0) {

			cultivo = new ArrayList<Cultivo>();

			try {

				cultivo = businessDelegatorView.getCultivo(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Cultivo> lista = businessDelegatorView.findByCriteriaInCultivo(condicion, null, null);
				selectCultivo = new SelectItem[lista.size()];

				int i = 0;
				for (Cultivo cultivo : lista) {
					selectCultivo[i] = new SelectItem(cultivo.getCultivoId(), cultivo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCultivo;
	}

	public void setSelectCultivo(SelectItem[] selectCultivo) {
		this.selectCultivo = selectCultivo;
	}

	public InputTextarea getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(InputTextarea txtPeso) {
		this.txtPeso = txtPeso;
	}

	public InputTextarea getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(InputTextarea txtColor) {
		this.txtColor = txtColor;
	}

	public InputTextarea getTxtDiametro() {
		return txtDiametro;
	}

	public void setTxtDiametro(InputTextarea txtDiametro) {
		this.txtDiametro = txtDiametro;
	}

	public InputTextarea getTxtForma() {
		return txtForma;
	}

	public void setTxtForma(InputTextarea txtForma) {
		this.txtForma = txtForma;
	}

	public InputTextarea getTxtLimpieza() {
		return txtLimpieza;
	}

	public void setTxtLimpieza(InputTextarea txtLimpieza) {
		this.txtLimpieza = txtLimpieza;
	}

	public InputTextarea getTxtRecepcion() {
		return txtRecepcion;
	}

	public void setTxtRecepcion(InputTextarea txtRecepcion) {
		this.txtRecepcion = txtRecepcion;
	}

	public InputTextarea getTxtCondicionesRechazo() {
		return txtCondicionesRechazo;
	}

	public void setTxtCondicionesRechazo(InputTextarea txtCondicionesRechazo) {
		this.txtCondicionesRechazo = txtCondicionesRechazo;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

}
