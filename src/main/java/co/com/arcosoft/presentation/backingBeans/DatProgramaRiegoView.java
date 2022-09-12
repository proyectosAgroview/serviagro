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
import co.com.arcosoft.modelo.DatProgramaRiego;
import co.com.arcosoft.modelo.DatProgramaRiegoDet;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDTO;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatProgramaRiegoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatProgramaRiegoView.class);
	private Spinner txtAnio;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional2;
	private SelectOneMenu txtMes;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatProgramaRiegoId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatProgramaRiegoDTO> data;
	private DatProgramaRiegoDTO selectedDatProgramaRiego;
	private DatProgramaRiego entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	/** detalle riego */

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private InputText txtNivel4Nombre;
	private InputText txtNivel2Nombre;

	private SelectOneMenu txtInfraId_Infraestructura;
	SelectItem[] selectInfraestructura;
	private List<Infraestructura> infraestructura;

	private InputText txtInfraestructuraNombre;
	private InputText txtAreaRegada;
	private InputText txtCaudalNivel4;
	private InputText txtEdadPrograma;
	private InputText txtHorasEstimadas;

	private Calendar txtFechaEstimadaRiego;

	private CommandButton btnAgregar;

	private List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet;
	private DatProgramaRiegoDetDTO selectedDatProgramaRiegoDet;
	private int activeTapIndex = 0;

	/*****/

	public DatProgramaRiegoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatProgramaRiegoDTO datProgramaRiegoDTO = (DatProgramaRiegoDTO) e.getObject();

			if (txtAnio == null) {
				txtAnio = new Spinner();
			}

			txtAnio.setValue(datProgramaRiegoDTO.getAnio());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datProgramaRiegoDTO.getCompania());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datProgramaRiegoDTO.getConsecutivo());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datProgramaRiegoDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputText();
			}

			txtInfoAdicional.setValue(datProgramaRiegoDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputText();
			}

			txtInfoAdicional2.setValue(datProgramaRiegoDTO.getInfoAdicional2());

			if (txtMes == null) {
				txtMes = new SelectOneMenu();
			}

			txtMes.setValue(datProgramaRiegoDTO.getMes());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datProgramaRiegoDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datProgramaRiegoDTO.getObservacionAnularReg());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datProgramaRiegoDTO.getUsuarioDigitacion());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(datProgramaRiegoDTO.getTrabId_Trabajador());

			if (txtDatProgramaRiegoId == null) {
				txtDatProgramaRiegoId = new InputText();
			}

			txtDatProgramaRiegoId.setValue(datProgramaRiegoDTO.getDatProgramaRiegoId());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datProgramaRiegoDTO.getFechaAnulacion());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datProgramaRiegoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datProgramaRiegoDTO.getFechaModificacion());

			Long datProgramaRiegoId = FacesUtils.checkLong(txtDatProgramaRiegoId);
			entity = businessDelegatorView.getDatProgramaRiego(datProgramaRiegoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatProgramaRiego = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatProgramaRiego = null;
		PrimeFaces.current().resetInputs(":dialogDatProgramaRiego :frm");
		activeTapIndex = 0;

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtAnio != null) {
			txtAnio.setValue(null);
			txtAnio.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
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

		if (txtMes != null) {
			txtMes.setValue(null);
			txtMes.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
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

		if (txtDatProgramaRiegoId != null) {
			txtDatProgramaRiegoId.setValue(null);
			txtDatProgramaRiegoId.setDisabled(false);
		}

		if (txtAreaRegada != null) {
			txtAreaRegada.setValue(null);
			txtAreaRegada.setDisabled(false);
		}

		if (txtCaudalNivel4 != null) {
			txtCaudalNivel4.setValue(null);
			txtCaudalNivel4.setDisabled(false);
		}

		if (txtEdadPrograma != null) {
			txtEdadPrograma.setValue(null);
			txtEdadPrograma.setDisabled(false);
		}

		if (txtHorasEstimadas != null) {
			txtHorasEstimadas.setValue(null);
			txtHorasEstimadas.setDisabled(false);
		}

		if (dataProgramaRiegoDet != null) {
			dataProgramaRiegoDet = null;

		}

		if (txtInfraId_Infraestructura != null) {
			txtInfraId_Infraestructura.setValue(null);
			txtInfraId_Infraestructura.setDisabled(false);
		}

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}

		if (txtFechaEstimadaRiego != null) {
			txtFechaEstimadaRiego.setValue(null);
			txtFechaEstimadaRiego.setDisabled(false);
		}
		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtInfraestructuraNombre != null) {
			txtInfraestructuraNombre.setValue(null);
			txtInfraestructuraNombre.setDisabled(false);
		}
		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
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

	public String action_edit(ActionEvent evt) throws Exception {
		selectedDatProgramaRiego = (DatProgramaRiegoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatProgramaRiego"));

		try {

			Long consecutivo = selectedDatProgramaRiego.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatProgramaRiego> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatProgramaRiego(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtAnio.setValue(entity.getAnio());
				txtAnio.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(false);
				txtMes.setValue(entity.getMes());
				txtMes.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtTrabId_Trabajador.setValue(selectedDatProgramaRiego.getTrabId_Trabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtDatProgramaRiegoId.setValue(entity.getDatProgramaRiegoId());
				txtDatProgramaRiegoId.setDisabled(true);

				txtAreaRegada.setDisabled(false);
				txtCaudalNivel4.setDisabled(false);
				txtHorasEstimadas.setDisabled(false);
				txtInfraId_Infraestructura.setDisabled(false);
				txtNivel2Id_Nivel2.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);
				txtFechaEstimadaRiego.setDisabled(false);
				txtNivel1Id.setDisabled(false);
				txtNivel3Id.setDisabled(false);
				btnAgregar.setDisabled(false);

				Long datProgramaRiegoId = FacesUtils.checkLong(txtDatProgramaRiegoId);

				dataProgramaRiegoDet = null;
				dataProgramaRiegoDet = businessDelegatorView.getDataDatProgramaRiegoDetByPrograma(datProgramaRiegoId);

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
			if ((selectedDatProgramaRiego == null) && (entity == null)) {
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
			entity = new DatProgramaRiego();

			// Long datProgramaRiegoId =
			// FacesUtils.checkLong(txtDatProgramaRiegoId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);

			entity.setAnio(FacesUtils.checkLong(txtAnio));
			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoProgramRiego(compania)));
			entity.setEstado(estado);
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setMes(FacesUtils.checkString(txtMes));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			businessDelegatorView.saveDatProgramaRiego(entity, dataProgramaRiegoDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoProgramRiego(compania) - 1));
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
				Long datProgramaRiegoId = new Long(selectedDatProgramaRiego.getDatProgramaRiegoId());
				entity = businessDelegatorView.getDatProgramaRiego(datProgramaRiegoId);
			}
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaModificacion(date);

			entity.setAnio(FacesUtils.checkLong(txtAnio));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setMes(FacesUtils.checkString(txtMes));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			businessDelegatorView.updateDatProgramaRiego(entity, dataProgramaRiegoDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			action_clear();
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatProgramaRiego = (DatProgramaRiegoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatProgramaRiego"));

			Long datProgramaRiegoId = new Long(selectedDatProgramaRiego.getDatProgramaRiegoId());
			entity = businessDelegatorView.getDatProgramaRiego(datProgramaRiegoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datProgramaRiegoId = FacesUtils.checkLong(txtDatProgramaRiegoId);
			entity = businessDelegatorView.getDatProgramaRiego(datProgramaRiegoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatProgramaRiego(entity);
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
			selectedDatProgramaRiego = (DatProgramaRiegoDTO) (evt.getComponent().getAttributes()
					.get("selectedDatProgramaRiego"));

			Long datProgramaRiegoId = new Long(selectedDatProgramaRiego.getDatProgramaRiegoId());
			entity = businessDelegatorView.getDatProgramaRiego(datProgramaRiegoId);
			businessDelegatorView.deleteDatProgramaRiego(entity);
			data.remove(selectedDatProgramaRiego);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anio, Long compania, Long consecutivo, Long datProgramaRiegoId,
			String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, String infoAdicional,
			String infoAdicional2, String mes, String observacion, String observacionAnularReg, Long usuarioDigitacion,
			Long trabId_Trabajador) throws Exception {
		try {
			entity.setAnio(FacesUtils.checkLong(anio));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setMes(FacesUtils.checkString(mes));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatProgramaRiego(entity, dataProgramaRiegoDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatProgramaRiegoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public Spinner getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(Spinner txtAnio) {
		this.txtAnio = txtAnio;
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

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
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

	public InputText getTxtDatProgramaRiegoId() {
		return txtDatProgramaRiegoId;
	}

	public void setTxtDatProgramaRiegoId(InputText txtDatProgramaRiegoId) {
		this.txtDatProgramaRiegoId = txtDatProgramaRiegoId;
	}

	public List<DatProgramaRiegoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatProgramaRiego();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatProgramaRiegoDTO> datProgramaRiegoDTO) {
		this.data = datProgramaRiegoDTO;
	}

	public DatProgramaRiegoDTO getSelectedDatProgramaRiego() {
		return selectedDatProgramaRiego;
	}

	public void setSelectedDatProgramaRiego(DatProgramaRiegoDTO datProgramaRiego) {
		this.selectedDatProgramaRiego = datProgramaRiego;
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

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneMenu getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(SelectOneMenu txtMes) {
		this.txtMes = txtMes;
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

	public SelectOneMenu getTxtInfraId_Infraestructura() {
		return txtInfraId_Infraestructura;
	}

	public void setTxtInfraId_Infraestructura(SelectOneMenu txtInfraId_Infraestructura) {
		this.txtInfraId_Infraestructura = txtInfraId_Infraestructura;
	}

	public InputText getTxtAreaRegada() {
		return txtAreaRegada;
	}

	public void setTxtAreaRegada(InputText txtAreaRegada) {
		this.txtAreaRegada = txtAreaRegada;
	}

	public InputText getTxtCaudalNivel4() {
		return txtCaudalNivel4;
	}

	public void setTxtCaudalNivel4(InputText txtCaudalNivel4) {
		this.txtCaudalNivel4 = txtCaudalNivel4;
	}

	public InputText getTxtEdadPrograma() {
		return txtEdadPrograma;
	}

	public void setTxtEdadPrograma(InputText txtEdadPrograma) {
		this.txtEdadPrograma = txtEdadPrograma;
	}

	public InputText getTxtHorasEstimadas() {
		return txtHorasEstimadas;
	}

	public void setTxtHorasEstimadas(InputText txtHorasEstimadas) {
		this.txtHorasEstimadas = txtHorasEstimadas;
	}

	public Calendar getTxtFechaEstimadaRiego() {
		return txtFechaEstimadaRiego;
	}

	public void setTxtFechaEstimadaRiego(Calendar txtFechaEstimadaRiego) {
		this.txtFechaEstimadaRiego = txtFechaEstimadaRiego;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<DatProgramaRiegoDetDTO> getDataProgramaRiegoDet() {
		return dataProgramaRiegoDet;
	}

	public void setDataProgramaRiegoDet(List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet) {
		this.dataProgramaRiegoDet = dataProgramaRiegoDet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public SelectItem[] getselectNivel1() {

		if (nivel1 == null || nivel1.size() == 0) {

			nivel1 = new ArrayList<Nivel1>();

			try {

				nivel1 = businessDelegatorView.getNivel1(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel1> lista = businessDelegatorView.findByCriteriaInNivel1(condicion, null, null);
				selectNivel1 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel1 nivel1 : lista) {
					selectNivel1[i] = new SelectItem(nivel1.getNivel1Id(), nivel1.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel1;
	}

	public void setselectNivel1(SelectItem[] selectNivel1) {
		this.selectNivel1 = selectNivel1;
	}

	public SelectItem[] getselectNivel2() {

		nivel2 = new ArrayList<Nivel2>();

		Long nivel1Id = null;

		if (txtNivel1Id != null && txtNivel1Id.getValue() != null && !txtNivel1Id.getValue().equals("")) {
			nivel1Id = Long.parseLong(txtNivel1Id.getValue().toString());

			try {
				Nivel1 nivel1 = businessDelegatorView.getNivel1(nivel1Id);
				Object[] niveles2 = nivel1.getNivel2s().toArray();

				selectNivel2 = new SelectItem[niveles2.length];

				int i = 0;
				for (Object object : niveles2) {
					Nivel2 nivel2 = (Nivel2) object;
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel2;
	}

	public void setselectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	public SelectItem[] getselectNivel3() {

		nivel3 = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2Id_Nivel2 != null && txtNivel2Id_Nivel2.getValue() != null
				&& !txtNivel2Id_Nivel2.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);
				Object[] niveles3 = nivel2.getNivel3s().toArray();

				selectNivel3 = new SelectItem[niveles3.length];

				int i = 0;
				for (Object object : niveles3) {
					Nivel3 nivel3 = (Nivel3) object;
					selectNivel3[i] = new SelectItem(nivel3.getNivel3Id(), nivel3.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel3;
	}

	public void setselectNivel3(SelectItem[] selectNivel3) {
		this.selectNivel3 = selectNivel3;
	}

	public SelectItem[] getselectNivel4() {
		nivel4 = new ArrayList<Nivel4>();

		Long nivel3Id = null;

		if (txtNivel3Id != null && txtNivel3Id.getValue() != null && !txtNivel3Id.getValue().equals("")) {
			nivel3Id = Long.parseLong(txtNivel3Id.getValue().toString());

			try {
				Nivel3 nivel3 = businessDelegatorView.getNivel3(nivel3Id);
				Object[] niveles4 = nivel3.getNivel4s().toArray();

				selectNivel4 = new SelectItem[niveles4.length];

				int i = 0;
				for (Object object : niveles4) {
					Nivel4 nivel4 = (Nivel4) object;
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(), nivel4.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4;
	}

	public void setselectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				trabajador = businessDelegatorView.getTrabajador(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "profesion.funciones", true, "Supervisor", "="

				};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajador[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajador;
	}

	public void setselectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getselectInfraestructura() {

		if (infraestructura == null || infraestructura.size() == 0) {

			infraestructura = new ArrayList<Infraestructura>();

			try {

				infraestructura = businessDelegatorView.getInfraestructura(); // Fin
																				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Infraestructura> lista = businessDelegatorView.findByCriteriaInInfraestructura(condicion, null,
						null);
				selectInfraestructura = new SelectItem[lista.size()];

				int i = 0;
				for (Infraestructura infraestructura : lista) {
					selectInfraestructura[i] = new SelectItem(infraestructura.getInfraId(),
							infraestructura.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectInfraestructura;
	}

	public void setselectInfraestructura(SelectItem[] selectInfraestructura) {
		this.selectInfraestructura = selectInfraestructura;
	}

	/**************** DETALLE DE AGREGAR PANTALLA ****/

	public List<DatProgramaRiegoDetDTO> getDatProgramaRiegoDet1() {

		if (dataProgramaRiegoDet == null || dataProgramaRiegoDet.size() == 0) {
			return null;
		} else {
			return dataProgramaRiegoDet;
		}

	}

	public void action_agregarProgramaRiego() throws Exception {

		Long nivel2 = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());
		Nivel2 nivel2Id = businessDelegatorView.getNivel2(nivel2);

		Long nivel4 = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
		Nivel4 nivel4Id = businessDelegatorView.getNivel4(nivel4);

		Long infraestructura = Long.parseLong(txtInfraId_Infraestructura.getValue().toString());
		Infraestructura infraestructuraId = businessDelegatorView.getInfraestructura(infraestructura);

		String nombreNivel2 = FacesUtils.checkString(txtNivel2Nombre);
		String nombreNivel4 = FacesUtils.checkString(txtNivel4Nombre);
		String nombreInfraestructura = FacesUtils.checkString(txtInfraestructuraNombre);

		// String indicadorDistribuccion
		// =FacesUtils.checkString(txtIndicadorDistribuccion);
		// Double pesoPromedio =FacesUtils.checkDouble(txtPesoPromedio);
		// Double cantidadRacimos =FacesUtils.checkDouble(txtCantidadRacimos);

		Double areaRegada = FacesUtils.checkDouble(txtAreaRegada);
		Double caudalNivel4 = FacesUtils.checkDouble(txtCaudalNivel4);
		Date fechaEstimadaRiego = FacesUtils.checkDate(txtFechaEstimadaRiego);
		Double horaEstimadas = FacesUtils.checkDouble(txtHorasEstimadas);

		Double edadNivel4 = ((businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(txtFechaEstimadaRiego),
				FacesUtils.checkLong(txtNivel4Id_Nivel4))));

		boolean existeProducto = false;

		if (dataProgramaRiegoDet == null) {
			dataProgramaRiegoDet = new ArrayList<DatProgramaRiegoDetDTO>();
		}

		if (dataProgramaRiegoDet.size() > 0) {

			for (DatProgramaRiegoDetDTO d : dataProgramaRiegoDet) {

				if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4Id.getNivel4Id().longValue()) {

					existeProducto = true;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
									"El Lote " + d.getNivel4Id_Nivel4().getNivel4Id().longValue()
											+ " ya fue agregado a la lista, por favor seleccione otro. "));

					break;
				}
			}

		}

		if (existeProducto == false) {

			DatProgramaRiegoDetDTO datProgramaRiegoDTO = new DatProgramaRiegoDetDTO();

			datProgramaRiegoDTO.setNivel2Id_Nivel2(nivel2Id);
			datProgramaRiegoDTO.setNilve2Nombre(nombreNivel2);
			datProgramaRiegoDTO.setNivel4Id_Nivel4(nivel4Id);
			datProgramaRiegoDTO.setNivel4Nombre(nombreNivel4);
			datProgramaRiegoDTO.setEdadPrograma(edadNivel4);

			datProgramaRiegoDTO.setAreaRegada(areaRegada);
			datProgramaRiegoDTO.setCaudalNivel4(caudalNivel4);
			datProgramaRiegoDTO.setEdadPrograma(edadNivel4);
			datProgramaRiegoDTO.setFechaEstimadaRiego(fechaEstimadaRiego);
			datProgramaRiegoDTO.setHorasEstimadas(horaEstimadas);
			datProgramaRiegoDTO.setInfraeEstructuraNombre(nombreInfraestructura);
			datProgramaRiegoDTO.setInfraId_Infraestructura(infraestructuraId);

			dataProgramaRiegoDet.add(datProgramaRiegoDTO);
		}
		nivel2 = null;
		nivel2Id = null;
		nombreNivel2 = null;
		nivel4 = null;
		nivel4Id = null;
		nombreNivel4 = null;
		areaRegada = null;
		caudalNivel4 = null;
		edadNivel4 = null;
		fechaEstimadaRiego = null;
		horaEstimadas = null;
		infraestructura = null;
		infraestructuraId = null;
		nombreInfraestructura = null;
	}

	public void listener_ConsultaNivel4() {

		Long nivel4Id = null;
		Long nivel2Id = null;

		if (!txtNivel4Id_Nivel4.getValue().equals("") && !txtNivel2Id_Nivel2.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				/* valNPass = datPlanLabor.getNPases(); */
				txtAreaRegada.setValue(nivel4.getAreaNeta());
				txtNivel4Nombre.setValue(nivel4.getNombre());
				txtNivel2Nombre.setValue(nivel2.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaInfraestructura() {

		Long infraId = null;

		if (!txtInfraId_Infraestructura.getValue().equals("")) {
			infraId = Long.parseLong(txtInfraId_Infraestructura.getValue().toString());

			try {
				Infraestructura infra = businessDelegatorView.getInfraestructura(infraId);

				txtInfraestructuraNombre.setValue(infra.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

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
				Long id = new Long(selectedDatProgramaRiego.getDatProgramaRiegoId());
				entity = businessDelegatorView.getDatProgramaRiego(id);
			}

			Long datProgramaRiegoId = FacesUtils.checkLong(txtDatProgramaRiegoId);

			dataProgramaRiegoDet = null;
			dataProgramaRiegoDet = businessDelegatorView.getDataDatProgramaRiegoDetByPrograma(datProgramaRiegoId);

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatProgramaRiego(entity, dataProgramaRiegoDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		action_clear();
		selectedDatProgramaRiego = (DatProgramaRiegoDTO) (evt.getComponent().getAttributes()
				.get("selectedDatProgramaRiego"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String actionDeleteProgramaRiegoDet(ActionEvent evt) {
		try {

			selectedDatProgramaRiegoDet = (DatProgramaRiegoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatProgramaRiegoDet"));

			if (selectedDatProgramaRiegoDet.getDatProgramaRiegoDetId() == null) {
				dataProgramaRiegoDet.remove(selectedDatProgramaRiegoDet);
			} else {
				Long datProgramaRiegoDetId = new Long(selectedDatProgramaRiegoDet.getDatProgramaRiegoDetId());
				DatProgramaRiegoDet entity = businessDelegatorView.getDatProgramaRiegoDet(datProgramaRiegoDetId);
				businessDelegatorView.deleteDatProgramaRiegoDet(entity);
				dataProgramaRiegoDet.remove(selectedDatProgramaRiegoDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
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

	public InputText getTxtInfraestructuraNombre() {
		return txtInfraestructuraNombre;
	}

	public void setTxtInfraestructuraNombre(InputText txtInfraestructuraNombre) {
		this.txtInfraestructuraNombre = txtInfraestructuraNombre;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

}
