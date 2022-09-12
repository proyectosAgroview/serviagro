package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.ServletContext;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.CultivoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CultivoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CultivoView.class);
	private SelectOneRadio txtAnalisisLaboratorio;
	private SelectOneRadio txtAplicaPolinizado;
	private SelectOneRadio txtCalcularArea;
	private SelectOneRadio txtCalcularEdad;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtControlProduccion;
	private SelectOneRadio txtControlSemillero;
	private SelectOneRadio txtEsAcuicultura;
	private SelectOneRadio txtEsMineria;
	private SelectOneRadio txtEsPecuaria;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtLogoCultivo;
	private SelectOneRadio txtModeloPlanificacionCosecha;
	private SelectOneRadio txtMostrarEdad;
	private InputText txtNombre;
	private InputText txtCultivoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CultivoDTO> data;
	private CultivoDTO selectedCultivo;
	private Cultivo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneRadio txtControlPlanta;
	private String txtImagenCultivo;
	private String imagenCultivo;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectItemUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtUdadMedId_UdadMed1;
	SelectItem[] selectItemUdadMed1;
	private List<UdadMed> udadMed1;

	// private UploadedFile txtLogoCultivo;
	private UploadedFile file;
	private int activeTapIndex = 0;

	public CultivoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CultivoDTO cultivoDTO = (CultivoDTO) e.getObject();

			if (txtAnalisisLaboratorio == null) {
				txtAnalisisLaboratorio = new SelectOneRadio();
			}

			txtAnalisisLaboratorio.setValue(cultivoDTO.getAnalisisLaboratorio());

			if (txtAplicaPolinizado == null) {
				txtAplicaPolinizado = new SelectOneRadio();
			}

			txtAplicaPolinizado.setValue(cultivoDTO.getAplicaPolinizado());

			if (txtCalcularArea == null) {
				txtCalcularArea = new SelectOneRadio();
			}

			txtCalcularArea.setValue(cultivoDTO.getCalcularArea());

			if (txtCalcularEdad == null) {
				txtCalcularEdad = new SelectOneRadio();
			}

			txtCalcularEdad.setValue(cultivoDTO.getCalcularEdad());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(cultivoDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(cultivoDTO.getCompania());

			if (txtControlPlanta == null) {
				txtControlPlanta = new SelectOneRadio();
			}

			txtControlPlanta.setValue(cultivoDTO.getControlPlanta());

			if (txtControlProduccion == null) {
				txtControlProduccion = new SelectOneRadio();
			}

			txtControlProduccion.setValue(cultivoDTO.getControlProduccion());

			if (txtControlSemillero == null) {
				txtControlSemillero = new SelectOneRadio();
			}

			txtControlSemillero.setValue(cultivoDTO.getControlSemillero());

			if (txtEsAcuicultura == null) {
				txtEsAcuicultura = new SelectOneRadio();
			}

			txtEsAcuicultura.setValue(cultivoDTO.getEsAcuicultura());

			if (txtEsMineria == null) {
				txtEsMineria = new SelectOneRadio();
			}

			txtEsMineria.setValue(cultivoDTO.getEsMineria());

			if (txtEsPecuaria == null) {
				txtEsPecuaria = new SelectOneRadio();
			}

			txtEsPecuaria.setValue(cultivoDTO.getEsPecuaria());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(cultivoDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(cultivoDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(cultivoDTO.getInfoAdicional2());

			if (txtLogoCultivo == null) {
				txtLogoCultivo = new InputText();
			}

			txtLogoCultivo.setValue(cultivoDTO.getLogoCultivo());

			if (txtModeloPlanificacionCosecha == null) {
				txtModeloPlanificacionCosecha = new SelectOneRadio();
			}

			txtModeloPlanificacionCosecha.setValue(cultivoDTO.getModeloPlanificacionCosecha());

			if (txtMostrarEdad == null) {
				txtMostrarEdad = new SelectOneRadio();
			}

			txtMostrarEdad.setValue(cultivoDTO.getMostrarEdad());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(cultivoDTO.getNombre());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new SelectOneMenu();
			}

			txtUdadMedId_UdadMed.setValue(cultivoDTO.getUdadMedId_UdadMed());

			if (txtUdadMedId_UdadMed1 == null) {
				txtUdadMedId_UdadMed1 = new SelectOneMenu();
			}

			txtUdadMedId_UdadMed1.setValue(cultivoDTO.getUdadMedId_UdadMed1());

			if (txtCultivoId == null) {
				txtCultivoId = new InputText();
			}

			txtCultivoId.setValue(cultivoDTO.getCultivoId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(cultivoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(cultivoDTO.getFechaModificacion());

			Long cultivoId = FacesUtils.checkLong(txtCultivoId);
			entity = businessDelegatorView.getCultivo(cultivoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCultivo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCultivo = null;
		file = null;
		PrimeFaces.current().resetInputs(":dialogCultivo :frm");
		activeTapIndex = 0;

		if (txtAnalisisLaboratorio != null) {
			txtAnalisisLaboratorio.setValue(null);
			txtAnalisisLaboratorio.setDisabled(true);
		}

		if (txtAplicaPolinizado != null) {
			txtAplicaPolinizado.setValue("n");
			txtAplicaPolinizado.setDisabled(true);
		}

		if (txtCalcularArea != null) {
			txtCalcularArea.setValue("d");
			txtCalcularArea.setDisabled(true);
		}

		if (txtCalcularEdad != null) {
			txtCalcularEdad.setValue("2");
			txtCalcularEdad.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtControlPlanta != null) {
			txtControlPlanta.setValue(null);
			txtControlPlanta.setDisabled(true);
		}

		if (txtControlProduccion != null) {
			txtControlProduccion.setValue("r");
			txtControlProduccion.setDisabled(true);
		}

		if (txtControlSemillero != null) {
			txtControlSemillero.setValue("n");
			txtControlSemillero.setDisabled(true);
		}

		if (txtEsAcuicultura != null) {
			txtEsAcuicultura.setValue("n");
			txtEsAcuicultura.setDisabled(true);
		}

		if (txtEsMineria != null) {
			txtEsMineria.setValue("n");
			txtEsMineria.setDisabled(true);
		}

		if (txtEsPecuaria != null) {
			txtEsPecuaria.setValue("n");
			txtEsPecuaria.setDisabled(true);
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

		if (txtLogoCultivo != null) {
			txtLogoCultivo.setValue(null);
			txtLogoCultivo.setDisabled(true);
		}

		if (txtModeloPlanificacionCosecha != null) {
			txtModeloPlanificacionCosecha.setValue("p");
			txtModeloPlanificacionCosecha.setDisabled(true);
		}

		if (txtMostrarEdad != null) {
			txtMostrarEdad.setValue("m");
			txtMostrarEdad.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
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

		if (txtCultivoId != null) {
			txtCultivoId.setValue(null);
			txtCultivoId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		imagenCultivo = "default.jpg";

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
			Long cultivoId = FacesUtils.checkLong(txtCultivoId);
			entity = (cultivoId != null) ? businessDelegatorView.getCultivo(cultivoId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtAnalisisLaboratorio.setDisabled(false);
			txtAplicaPolinizado.setDisabled(false);
			txtCalcularArea.setDisabled(false);
			txtCalcularEdad.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCompania.setDisabled(false);
			txtControlPlanta.setDisabled(false);
			txtControlProduccion.setDisabled(false);
			txtControlSemillero.setDisabled(false);
			txtEsAcuicultura.setDisabled(false);
			txtEsMineria.setDisabled(false);
			txtEsPecuaria.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtLogoCultivo.setDisabled(false);
			txtModeloPlanificacionCosecha.setDisabled(false);
			txtMostrarEdad.setDisabled(false);
			txtNombre.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtCultivoId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAnalisisLaboratorio.setValue(entity.getAnalisisLaboratorio());
			txtAnalisisLaboratorio.setDisabled(false);
			txtAplicaPolinizado.setValue(entity.getAplicaPolinizado());
			txtAplicaPolinizado.setDisabled(false);
			txtCalcularArea.setValue(entity.getCalcularArea());
			txtCalcularArea.setDisabled(false);
			txtCalcularEdad.setValue(entity.getCalcularEdad());
			txtCalcularEdad.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtControlPlanta.setValue(entity.getControlPlanta());
			txtControlPlanta.setDisabled(false);
			txtControlProduccion.setValue(entity.getControlProduccion());
			txtControlProduccion.setDisabled(false);
			txtControlSemillero.setValue(entity.getControlSemillero());
			txtControlSemillero.setDisabled(false);
			txtEsAcuicultura.setValue(entity.getEsAcuicultura());
			txtEsAcuicultura.setDisabled(false);
			txtEsMineria.setValue(entity.getEsMineria());
			txtEsMineria.setDisabled(false);
			txtEsPecuaria.setValue(entity.getEsPecuaria());
			txtEsPecuaria.setDisabled(false);
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
			txtLogoCultivo.setValue(entity.getLogoCultivo());
			txtLogoCultivo.setDisabled(false);
			txtModeloPlanificacionCosecha.setValue(entity.getModeloPlanificacionCosecha());
			txtModeloPlanificacionCosecha.setDisabled(false);
			txtMostrarEdad.setValue(entity.getMostrarEdad());
			txtMostrarEdad.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMedByUdadMedId().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtCultivoId.setValue(entity.getCultivoId());
			txtCultivoId.setDisabled(true);
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
			List<Cultivo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCultivo(condicion, null, null) : null;

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
			txtAnalisisLaboratorio.setDisabled(false);
			txtAplicaPolinizado.setDisabled(false);
			txtCalcularArea.setDisabled(false);
			txtCalcularEdad.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtControlPlanta.setDisabled(false);
			txtControlProduccion.setDisabled(false);
			txtControlSemillero.setDisabled(false);
			txtEsAcuicultura.setDisabled(false);
			txtEsMineria.setDisabled(false);
			txtEsPecuaria.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);

			String urlImageDefauld = "defauldImagen.png";
			txtImagenCultivo = urlImageDefauld;
			imagenCultivo = "default.jpg";

			txtModeloPlanificacionCosecha.setDisabled(false);
			txtMostrarEdad.setDisabled(false);
			txtNombre.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtUdadMedId_UdadMed1.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtCultivoId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAnalisisLaboratorio.setValue(entity.getAnalisisLaboratorio());
			txtAnalisisLaboratorio.setDisabled(false);
			txtAplicaPolinizado.setValue(entity.getAplicaPolinizado());
			txtAplicaPolinizado.setDisabled(false);
			txtCalcularArea.setValue(entity.getCalcularArea());
			txtCalcularArea.setDisabled(false);
			txtCalcularEdad.setValue(entity.getCalcularEdad());
			txtCalcularEdad.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtControlPlanta.setValue(entity.getControlPlanta());
			txtControlPlanta.setDisabled(false);
			txtControlProduccion.setValue(entity.getControlProduccion());
			txtControlProduccion.setDisabled(false);
			txtControlSemillero.setValue(entity.getControlSemillero());
			txtControlSemillero.setDisabled(false);
			txtEsAcuicultura.setValue(entity.getEsAcuicultura());
			txtEsAcuicultura.setDisabled(false);
			txtEsMineria.setValue(entity.getEsMineria());
			txtEsMineria.setDisabled(false);
			txtEsPecuaria.setValue(entity.getEsPecuaria());
			txtEsPecuaria.setDisabled(false);
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
			// txtLogoCultivo.setValue(entity.getLogoCultivo());
			// txtLogoCultivo.setDisabled(false);

			imagenCultivo = entity.getLogoCultivo();

			txtModeloPlanificacionCosecha.setValue(entity.getModeloPlanificacionCosecha());
			txtModeloPlanificacionCosecha.setDisabled(false);
			txtMostrarEdad.setValue(entity.getMostrarEdad());
			txtMostrarEdad.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMedByUdadMedId().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);
			txtUdadMedId_UdadMed1.setValue(entity.getUdadMedByUdadMedId1().getUdadMedId());
			txtUdadMedId_UdadMed1.setDisabled(false);
			txtCultivoId.setValue(entity.getCultivoId());
			txtCultivoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCultivo = (CultivoDTO) (evt.getComponent().getAttributes().get("selectedCultivo"));

		try {

			String codigo = selectedCultivo.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Cultivo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCultivo(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtAnalisisLaboratorio.setValue(entity.getAnalisisLaboratorio());
				txtAnalisisLaboratorio.setDisabled(false);
				txtAplicaPolinizado.setValue(entity.getAplicaPolinizado());
				txtAplicaPolinizado.setDisabled(false);
				txtCalcularArea.setValue(entity.getCalcularArea());
				txtCalcularArea.setDisabled(false);
				txtCalcularEdad.setValue(entity.getCalcularEdad());
				txtCalcularEdad.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(selectedCultivo.getCompania());
				// txtCompania.setDisabled(false);
				txtControlPlanta.setValue(entity.getControlPlanta());
				txtControlPlanta.setDisabled(false);
				txtControlProduccion.setValue(entity.getControlProduccion());
				txtControlProduccion.setDisabled(false);
				txtControlSemillero.setValue(entity.getControlSemillero());
				txtControlSemillero.setDisabled(false);
				txtEsAcuicultura.setValue(entity.getEsAcuicultura());
				txtEsAcuicultura.setDisabled(false);
				txtEsMineria.setValue(entity.getEsMineria());
				txtEsMineria.setDisabled(false);
				txtEsPecuaria.setValue(entity.getEsPecuaria());
				txtEsPecuaria.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(selectedCultivo.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedCultivo.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				// String urlImageDefauld = "defauldImagen.png";
				// txtImagenCultivo = entity.getLogoCultivo();

				imagenCultivo = ((entity.getLogoCultivo() != null && !entity.getLogoCultivo().equals(""))
						? entity.getLogoCultivo() : "default.jpg");

				// txtLogoCultivo.setValue(entity.getLogoCultivo());
				// txtLogoCultivo.setDisabled(false);
				txtModeloPlanificacionCosecha.setValue(entity.getModeloPlanificacionCosecha());
				txtModeloPlanificacionCosecha.setDisabled(false);
				txtMostrarEdad.setValue(entity.getMostrarEdad());
				txtMostrarEdad.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				if (entity.getUdadMedByUdadMedId() != null) {
					txtUdadMedId_UdadMed.setValue(entity.getUdadMedByUdadMedId().getUdadMedId());
				}
				txtUdadMedId_UdadMed.setDisabled(false);

				if (entity.getUdadMedByUdadMedId1() != null) {
					txtUdadMedId_UdadMed1.setValue(entity.getUdadMedByUdadMedId1().getUdadMedId());
				}
				txtUdadMedId_UdadMed1.setDisabled(false);
				txtCultivoId.setValue(selectedCultivo.getCultivoId());
				txtCultivoId.setDisabled(true);
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
			if ((selectedCultivo == null) && (entity == null)) {
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
			entity = new Cultivo();

			// Long cultivoId = FacesUtils.checkLong(txtCultivoId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();

			entity.setAnalisisLaboratorio(FacesUtils.checkString(txtAnalisisLaboratorio));
			entity.setAplicaPolinizado(FacesUtils.checkString(txtAplicaPolinizado));
			entity.setCalcularArea(FacesUtils.checkString(txtCalcularArea));
			entity.setCalcularEdad(FacesUtils.checkString(txtCalcularEdad));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setControlPlanta(FacesUtils.checkString(txtControlPlanta));
			entity.setControlProduccion(FacesUtils.checkString(txtControlProduccion));
			entity.setControlSemillero(FacesUtils.checkString(txtControlSemillero));
			// entity.setCultivoId(cultivoId);
			entity.setEsAcuicultura(FacesUtils.checkString(txtEsAcuicultura));
			entity.setEsMineria(FacesUtils.checkString(txtEsMineria));
			entity.setEsPecuaria(FacesUtils.checkString(txtEsPecuaria));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			/*
			 * entity.setFechaModificacion(FacesUtils.checkDate(
			 * txtFechaModificacion));
			 */
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));

			if (file != null) {
				entity.setLogoCultivo(file.getFileName());
				subirImagen();

			}

			entity.setModeloPlanificacionCosecha(FacesUtils.checkString(txtModeloPlanificacionCosecha));
			entity.setMostrarEdad(FacesUtils.checkString(txtMostrarEdad));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUdadMedByUdadMedId((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			entity.setUdadMedByUdadMedId1((FacesUtils.checkLong(txtUdadMedId_UdadMed1) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed1)) : null);
			businessDelegatorView.saveCultivo(entity);

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
				Long cultivoId = new Long(selectedCultivo.getCultivoId());
				entity = businessDelegatorView.getCultivo(cultivoId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());

			entity.setAnalisisLaboratorio(FacesUtils.checkString(txtAnalisisLaboratorio));
			entity.setAplicaPolinizado(FacesUtils.checkString(txtAplicaPolinizado));
			entity.setCalcularArea(FacesUtils.checkString(txtCalcularArea));
			entity.setCalcularEdad(FacesUtils.checkString(txtCalcularEdad));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setControlPlanta(FacesUtils.checkString(txtControlPlanta));
			entity.setControlProduccion(FacesUtils.checkString(txtControlProduccion));
			entity.setControlSemillero(FacesUtils.checkString(txtControlSemillero));
			entity.setEsAcuicultura(FacesUtils.checkString(txtEsAcuicultura));
			entity.setEsMineria(FacesUtils.checkString(txtEsMineria));
			entity.setEsPecuaria(FacesUtils.checkString(txtEsPecuaria));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));

			if (file != null) {
				entity.setLogoCultivo(file.getFileName());
				subirImagen();

			}

			entity.setModeloPlanificacionCosecha(FacesUtils.checkString(txtModeloPlanificacionCosecha));
			entity.setMostrarEdad(FacesUtils.checkString(txtMostrarEdad));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUdadMedByUdadMedId((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed)) : null);
			entity.setUdadMedByUdadMedId1((FacesUtils.checkLong(txtUdadMedId_UdadMed1) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed1)) : null);
			businessDelegatorView.updateCultivo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCultivo = (CultivoDTO) (evt.getComponent().getAttributes().get("selectedCultivo"));

			Long cultivoId = new Long(selectedCultivo.getCultivoId());
			entity = businessDelegatorView.getCultivo(cultivoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long cultivoId = FacesUtils.checkLong(txtCultivoId);
			entity = businessDelegatorView.getCultivo(cultivoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCultivo(entity);
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
			selectedCultivo = (CultivoDTO) (evt.getComponent().getAttributes().get("selectedCultivo"));

			Long cultivoId = new Long(selectedCultivo.getCultivoId());
			entity = businessDelegatorView.getCultivo(cultivoId);
			businessDelegatorView.deleteCultivo(entity);
			data.remove(selectedCultivo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String analisisLaboratorio, String aplicaPolinizado, String calcularArea,
			String calcularEdad, String codigo, Long compania, String controlPlanta, String controlProduccion,
			String controlSemillero, Long cultivoId, String esAcuicultura, String esMineria, String esPecuaria,
			String estado, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2,
			String logoCultivo, String modeloPlanificacionCosecha, String mostrarEdad, String nombre,
			Long udadMedId_UdadMed, Long udadMedId_UdadMed0) throws Exception {
		try {
			entity.setAnalisisLaboratorio(FacesUtils.checkString(analisisLaboratorio));
			entity.setAplicaPolinizado(FacesUtils.checkString(aplicaPolinizado));
			entity.setCalcularArea(FacesUtils.checkString(calcularArea));
			entity.setCalcularEdad(FacesUtils.checkString(calcularEdad));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setControlPlanta(FacesUtils.checkString(controlPlanta));
			entity.setControlProduccion(FacesUtils.checkString(controlProduccion));
			entity.setControlSemillero(FacesUtils.checkString(controlSemillero));
			entity.setEsAcuicultura(FacesUtils.checkString(esAcuicultura));
			entity.setEsMineria(FacesUtils.checkString(esMineria));
			entity.setEsPecuaria(FacesUtils.checkString(esPecuaria));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLogoCultivo(FacesUtils.checkString(logoCultivo));
			entity.setModeloPlanificacionCosecha(FacesUtils.checkString(modeloPlanificacionCosecha));
			entity.setMostrarEdad(FacesUtils.checkString(mostrarEdad));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateCultivo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CultivoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneRadio getTxtAnalisisLaboratorio() {
		return txtAnalisisLaboratorio;
	}

	public void setTxtAnalisisLaboratorio(SelectOneRadio txtAnalisisLaboratorio) {
		this.txtAnalisisLaboratorio = txtAnalisisLaboratorio;
	}

	public SelectOneRadio getTxtAplicaPolinizado() {
		return txtAplicaPolinizado;
	}

	public void setTxtAplicaPolinizado(SelectOneRadio txtAplicaPolinizado) {
		this.txtAplicaPolinizado = txtAplicaPolinizado;
	}

	public SelectOneRadio getTxtCalcularArea() {
		return txtCalcularArea;
	}

	public void setTxtCalcularArea(SelectOneRadio txtCalcularArea) {
		this.txtCalcularArea = txtCalcularArea;
	}

	public SelectOneRadio getTxtCalcularEdad() {
		return txtCalcularEdad;
	}

	public void setTxtCalcularEdad(SelectOneRadio txtCalcularEdad) {
		this.txtCalcularEdad = txtCalcularEdad;
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

	public SelectOneRadio getTxtControlPlanta() {
		return txtControlPlanta;
	}

	public void setTxtControlPlanta(SelectOneRadio txtControlPlanta) {
		this.txtControlPlanta = txtControlPlanta;
	}

	public SelectOneRadio getTxtControlProduccion() {
		return txtControlProduccion;
	}

	public void setTxtControlProduccion(SelectOneRadio txtControlProduccion) {
		this.txtControlProduccion = txtControlProduccion;
	}

	public SelectOneRadio getTxtControlSemillero() {
		return txtControlSemillero;
	}

	public void setTxtControlSemillero(SelectOneRadio txtControlSemillero) {
		this.txtControlSemillero = txtControlSemillero;
	}

	public SelectOneRadio getTxtEsAcuicultura() {
		return txtEsAcuicultura;
	}

	public void setTxtEsAcuicultura(SelectOneRadio txtEsAcuicultura) {
		this.txtEsAcuicultura = txtEsAcuicultura;
	}

	public SelectOneRadio getTxtEsMineria() {
		return txtEsMineria;
	}

	public void setTxtEsMineria(SelectOneRadio txtEsMineria) {
		this.txtEsMineria = txtEsMineria;
	}

	public SelectOneRadio getTxtEsPecuaria() {
		return txtEsPecuaria;
	}

	public void setTxtEsPecuaria(SelectOneRadio txtEsPecuaria) {
		this.txtEsPecuaria = txtEsPecuaria;
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

	public InputText getTxtLogoCultivo() {
		return txtLogoCultivo;
	}

	public void setTxtLogoCultivo(InputText txtLogoCultivo) {
		this.txtLogoCultivo = txtLogoCultivo;
	}

	public SelectOneRadio getTxtModeloPlanificacionCosecha() {
		return txtModeloPlanificacionCosecha;
	}

	public void setTxtModeloPlanificacionCosecha(SelectOneRadio txtModeloPlanificacionCosecha) {
		this.txtModeloPlanificacionCosecha = txtModeloPlanificacionCosecha;
	}

	public SelectOneRadio getTxtMostrarEdad() {
		return txtMostrarEdad;
	}

	public void setTxtMostrarEdad(SelectOneRadio txtMostrarEdad) {
		this.txtMostrarEdad = txtMostrarEdad;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
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

	public InputText getTxtCultivoId() {
		return txtCultivoId;
	}

	public void setTxtCultivoId(InputText txtCultivoId) {
		this.txtCultivoId = txtCultivoId;
	}

	public List<CultivoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCultivo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CultivoDTO> cultivoDTO) {
		this.data = cultivoDTO;
	}

	public CultivoDTO getSelectedCultivo() {
		return selectedCultivo;
	}

	public void setSelectedCultivo(CultivoDTO cultivo) {
		this.selectedCultivo = cultivo;
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

	public SelectItem[] getselectItemUdadMed1() {

		if (udadMed1 == null || udadMed1.size() == 0) {

			udadMed1 = new ArrayList<UdadMed>();

			try {

				udadMed1 = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectItemUdadMed1 = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed um1 : lista) {
					selectItemUdadMed1[i] = new SelectItem(um1.getUdadMedId(), um1.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return selectItemUdadMed1;
	}

	public void setselectItemUdadMed1(SelectItem[] selectItemUdadMed1) {
		this.selectItemUdadMed1 = selectItemUdadMed1;
	}

	public SelectItem[] getSelectItemUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			udadMed = new ArrayList<UdadMed>();

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectItemUdadMed = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed um : lista) {
					selectItemUdadMed[i] = new SelectItem(um.getUdadMedId(), um.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemUdadMed;
	}

	public void setSelectItemUdadMed(SelectItem[] selectItemUdadMed) {
		this.selectItemUdadMed = selectItemUdadMed;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed1() {
		return txtUdadMedId_UdadMed1;
	}

	public void setTxtUdadMedId_UdadMed1(SelectOneMenu txtUdadMedId_UdadMed1) {
		this.txtUdadMedId_UdadMed1 = txtUdadMedId_UdadMed1;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		if (file != null) {
			this.txtImagenCultivo = file.getFileName();
		}
	}

	public String getTxtImagenCultivo() {
		return txtImagenCultivo;
	}

	public void setTxtImagenCultivo(String txtImagenCultivo) {
		this.txtImagenCultivo = txtImagenCultivo;
	}

	public String getImagenCultivo() {
		return imagenCultivo;
	}

	public void setImagenCultivo(String imagenCultivo) {
		this.imagenCultivo = imagenCultivo;
	}

	public void subirImagen() {

		ServletContext servletContext;
		String fileName = file.getFileName();

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

			String path = servletContext.getRealPath("");

			// UploadedFile file = event.getFile();
			inputStream = file.getInputstream();
			// fileName = file.getFileName();
			outputStream = new FileOutputStream(new File(path + "imagenes_subidas/" + fileName));

			int read = 0;
			byte[] bytes = new byte[100000];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			imagenCultivo = fileName;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

}
