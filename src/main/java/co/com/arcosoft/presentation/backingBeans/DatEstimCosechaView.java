package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatEstimCosecha;
import co.com.arcosoft.modelo.MotEstim;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatEstimCosechaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatEstimCosechaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatEstimCosechaView.class);
	private InputText txtAnioFiscalNivel4;
	private InputText txtAreaNeta;
	private InputText txtConsecutivo;

	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtPrecision;
	private InputText txtCantidadTotalEst;
	private InputText txtCompania;
	private InputText txtEdadNivel4;
	private SelectOneRadio txtEstado;
	private InputText txtEtapaNivel4;
	private InputText txtFaseFenoNivel4;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtMobileId;
	// private InputText txtNivel1Id;
	// private InputText txtNivel2Id;
	// private InputText txtNivel3Id;
	// private InputText txtNivel4Id;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtThEstimado;
	private InputText txtUsuarioDigitacion;
	private InputText txtVariedNivel4;
	// private InputText txtMotEstimId_MotEstim;
	private InputText txtDatEstimCosechaId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaMuestra;
	private Calendar txtFechaAnulacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatEstimCosechaDTO> data;
	private DatEstimCosechaDTO selectedDatEstimCosecha;
	private DatEstimCosecha entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private double result;

	private SelectOneMenu txtMotEstimId_MotEstim;
	SelectItem[] selectMotEstim;
	private List<MotEstim> motEstim;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel4Id;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private MapModel simpleModel;
	private Long consecutivo;
	private Marker marker;
	@Resource
	private SessionFactory sessionFactory;
	Long numConsecutivo = 0L;
	Long numConsec = 0l;

	public DatEstimCosechaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatEstimCosechaDTO datEstimCosechaDTO = (DatEstimCosechaDTO) e.getObject();

			if (txtAnioFiscalNivel4 == null) {
				txtAnioFiscalNivel4 = new InputText();
			}

			txtAnioFiscalNivel4.setValue(datEstimCosechaDTO.getAnioFiscalNivel4());

			if (txtAreaNeta == null) {
				txtAreaNeta = new InputText();
			}

			txtAreaNeta.setValue(datEstimCosechaDTO.getAreaNeta());

			if (txtCantidadTotalEst == null) {
				txtCantidadTotalEst = new InputText();
			}

			txtCantidadTotalEst.setValue(datEstimCosechaDTO.getCantidadTotalEst());

			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(datEstimCosechaDTO.getLatitud());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(datEstimCosechaDTO.getLongitud());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(datEstimCosechaDTO.getPrecision());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datEstimCosechaDTO.getCompania());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(datEstimCosechaDTO.getTrabajador());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datEstimCosechaDTO.getConsecutivo());

			if (txtEdadNivel4 == null) {
				txtEdadNivel4 = new InputText();
			}

			txtEdadNivel4.setValue(datEstimCosechaDTO.getEdadNivel4());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datEstimCosechaDTO.getEstado());

			if (txtEtapaNivel4 == null) {
				txtEtapaNivel4 = new InputText();
			}

			txtEtapaNivel4.setValue(datEstimCosechaDTO.getEtapaNivel4());

			if (txtFaseFenoNivel4 == null) {
				txtFaseFenoNivel4 = new InputText();
			}

			txtFaseFenoNivel4.setValue(datEstimCosechaDTO.getFaseFenoNivel4());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(datEstimCosechaDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(datEstimCosechaDTO.getInfoAdicional2());

			if (txtMobileId == null) {
				txtMobileId = new InputText();
			}

			txtMobileId.setValue(datEstimCosechaDTO.getMobileId());

			if (txtNivel1Id == null) {
				txtNivel1Id = new SelectOneMenu();
			}

			txtNivel1Id.setValue(datEstimCosechaDTO.getNivel1Id());

			if (txtNivel2Id == null) {
				txtNivel2Id = new SelectOneMenu();
			}

			txtNivel2Id.setValue(datEstimCosechaDTO.getNivel2Id());

			if (txtNivel3Id == null) {
				txtNivel3Id = new SelectOneMenu();
			}

			txtNivel3Id.setValue(datEstimCosechaDTO.getNivel3Id());

			if (txtNivel4Id == null) {
				txtNivel4Id = new SelectOneMenu();
			}

			txtNivel4Id.setValue(datEstimCosechaDTO.getNivel4Id());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datEstimCosechaDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datEstimCosechaDTO.getObservacionAnularReg());

			if (txtThEstimado == null) {
				txtThEstimado = new InputText();
			}

			txtThEstimado.setValue(datEstimCosechaDTO.getThEstimado());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datEstimCosechaDTO.getUsuarioDigitacion());

			if (txtVariedNivel4 == null) {
				txtVariedNivel4 = new InputText();
			}

			txtVariedNivel4.setValue(datEstimCosechaDTO.getVariedNivel4());

			if (txtMotEstimId_MotEstim == null) {
				txtMotEstimId_MotEstim = new SelectOneMenu();
			}

			txtMotEstimId_MotEstim.setValue(datEstimCosechaDTO.getMotEstimId_MotEstim());

			if (txtDatEstimCosechaId == null) {
				txtDatEstimCosechaId = new InputText();
			}

			txtDatEstimCosechaId.setValue(datEstimCosechaDTO.getDatEstimCosechaId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datEstimCosechaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datEstimCosechaDTO.getFechaModificacion());

			if (txtFechaMuestra == null) {
				txtFechaMuestra = new Calendar();
			}

			txtFechaMuestra.setValue(datEstimCosechaDTO.getFechaMuestra());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datEstimCosechaDTO.getFechaAnulacion());

			Long datEstimCosechaId = FacesUtils.checkLong(txtDatEstimCosechaId);
			entity = businessDelegatorView.getDatEstimCosecha(datEstimCosechaId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() throws Exception {
		action_clear();

		selectedDatEstimCosecha = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws Exception {
		entity = null;
		selectedDatEstimCosecha = null;
		PrimeFaces.current().resetInputs(":dialogDatEstimCosecha :frm");

		if (txtAnioFiscalNivel4 != null) {
			txtAnioFiscalNivel4.setValue(null);
			txtAnioFiscalNivel4.setDisabled(true);
		}

		if (txtAreaNeta != null) {
			txtAreaNeta.setValue(null);
			txtAreaNeta.setDisabled(false);
		}
		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(true);
		}
		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtCantidadTotalEst != null) {
			txtCantidadTotalEst.setValue(null);
			txtCantidadTotalEst.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtEdadNivel4 != null) {
			txtEdadNivel4.setValue(null);
			txtEdadNivel4.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtEtapaNivel4 != null) {
			txtEtapaNivel4.setValue(null);
			txtEtapaNivel4.setDisabled(true);
		}

		if (txtFaseFenoNivel4 != null) {
			txtFaseFenoNivel4.setValue(null);
			txtFaseFenoNivel4.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtMobileId != null) {
			txtMobileId.setValue(null);
			txtMobileId.setDisabled(true);
		}

		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtNivel4Id != null) {
			txtNivel4Id.setValue(null);
			txtNivel4Id.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtThEstimado != null) {
			txtThEstimado.setValue(null);
			txtThEstimado.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtVariedNivel4 != null) {
			txtVariedNivel4.setValue(null);
			txtVariedNivel4.setDisabled(true);
		}

		if (txtMotEstimId_MotEstim != null) {
			txtMotEstimId_MotEstim.setValue(null);
			txtMotEstimId_MotEstim.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaMuestra != null) {
			txtFechaMuestra.setValue(null);
			txtFechaMuestra.setDisabled(false);
		}

		if (txtDatEstimCosechaId != null) {
			txtDatEstimCosechaId.setValue(null);
			txtDatEstimCosechaId.setDisabled(true);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
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

	public void listener_txtFechaMuestra() {
		Date inputDate = (Date) txtFechaMuestra.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	/*
	 * public MapModel getSimpleModel() {
	 * 
	 * simpleModel = new DefaultMapModel(); LatLng coord1 = new
	 * LatLng(3.6374489,-76.2900103);
	 * 
	 * 
	 * 
	 * if ((Float) txtLatitud.getValue() != null && (Float)
	 * txtLongitud.getValue() != null ){ //Shared coordinates coord1 = new
	 * LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
	 * //Basic marker simpleModel.addOverlay(new Marker(coord1, "Muestra"));
	 * }else { //Shared coordinates coord1 = new LatLng(3, 79); //Basic marker
	 * simpleModel.addOverlay(new Marker(coord1, "SIN DEFINIR")); }
	 * 
	 * return simpleModel; }
	 * 
	 * public void onMarkerSelect(OverlaySelectEvent event) { marker = (Marker)
	 * event.getOverlay();
	 * 
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected",
	 * marker.getTitle())); }
	 * 
	 * public Marker getMarker() { return marker; }
	 */

	public void listener_txtId() {
		try {
			Long datEstimCosechaId = FacesUtils.checkLong(txtDatEstimCosechaId);
			entity = (datEstimCosechaId != null) ? businessDelegatorView.getDatEstimCosecha(datEstimCosechaId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtConsecutivo.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			txtAnioFiscalNivel4.setDisabled(false);
			txtAreaNeta.setDisabled(false);
			txtCantidadTotalEst.setDisabled(false);
			txtCompania.setDisabled(false);
			txtEdadNivel4.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEtapaNivel4.setDisabled(false);
			txtFaseFenoNivel4.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtMobileId.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtNivel4Id.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setDisabled(false);
			txtThEstimado.setDisabled(false);
			txtUsuarioDigitacion.setDisabled(false);
			txtVariedNivel4.setDisabled(false);
			txtMotEstimId_MotEstim.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaMuestra.setDisabled(false);
			txtDatEstimCosechaId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtConsecutivo.setValue(entity.getConsecutivo());
			txtConsecutivo.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
			txtTrabId_Trabajador.setDisabled(false);
			txtAnioFiscalNivel4.setValue(entity.getAnioFiscalNivel4());
			txtAnioFiscalNivel4.setDisabled(false);
			txtAreaNeta.setValue(entity.getAreaNeta());
			txtAreaNeta.setDisabled(false);
			txtCantidadTotalEst.setValue(entity.getCantidadTotalEst());
			txtCantidadTotalEst.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtEdadNivel4.setValue(entity.getEdadNivel4());
			txtEdadNivel4.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEtapaNivel4.setValue(entity.getEtapaNivel4());
			txtEtapaNivel4.setDisabled(false);
			txtFaseFenoNivel4.setValue(entity.getFaseFenoNivel4());
			txtFaseFenoNivel4.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaMuestra.setValue(entity.getFechaMuestra());
			txtFechaMuestra.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtMobileId.setValue(entity.getMobileId());
			txtMobileId.setDisabled(false);
			txtNivel1Id.setValue(entity.getNivel1Id());
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id().getNivel2Id());
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(false);
			txtNivel4Id.setValue(entity.getNivel4Id().getNivel4Id());
			txtNivel4Id.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtObservacionAnularReg.setValue(entity.getObservacionAnularReg());
			txtObservacionAnularReg.setDisabled(false);
			txtThEstimado.setValue(entity.getThEstimado());
			txtThEstimado.setDisabled(false);
			txtUsuarioDigitacion.setValue(entity.getUsuarioDigitacion());
			txtUsuarioDigitacion.setDisabled(false);
			txtVariedNivel4.setValue(entity.getVariedNivel4());
			txtVariedNivel4.setDisabled(false);
			txtMotEstimId_MotEstim.setValue(entity.getMotEstim().getMotEstimId());
			txtMotEstimId_MotEstim.setDisabled(false);
			txtDatEstimCosechaId.setValue(entity.getDatEstimCosechaId());
			txtDatEstimCosechaId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public void listener_calcularCantidadTotalEst() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double areaNeta = FacesUtils.checkDouble(getTxtAreaNeta());
		Double thEstimado = FacesUtils.checkDouble(getTxtThEstimado());

		if (areaNeta != null && thEstimado != null) {
			result = (thEstimado * areaNeta);
			String format = decimalFormat.format(result);
			txtCantidadTotalEst.setValue(format);
		} else {
			result = 0;
			txtCantidadTotalEst.setValue(result);
		}

	}

	public void listener_txtConsecutivo() {
		try {
			Long consecutivo = FacesUtils.checkLong(txtConsecutivo);
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatEstimCosecha> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatEstimCosecha(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ consecutivo);
		} catch (Exception e) {
			entity = null;
		}
		if (entity == null) {
			txtConsecutivo.setDisabled(false);
			txtTrabId_Trabajador.setDisabled(false);
			// txtAnioFiscalNivel4.setDisabled(false);
			txtAreaNeta.setDisabled(false);
			txtCantidadTotalEst.setDisabled(true);
			// txtCompania.setDisabled(false);
			// txtEdadNivel4.setDisabled(false);
			txtEstado.setDisabled(false);
			// txtEtapaNivel4.setDisabled(false);
			// txtFaseFenoNivel4.setDisabled(false);
			// txtInfoAdicional.setDisabled(false);
			// txtInfoAdicional2.setDisabled(false);
			// txtMobileId.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtNivel4Id.setDisabled(false);
			txtObservacion.setDisabled(false);
			// txtObservacionAnularReg.setDisabled(false);
			txtThEstimado.setDisabled(false);
			// txtUsuarioDigitacion.setDisabled(false);
			// txtVariedNivel4.setDisabled(false);
			txtMotEstimId_MotEstim.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtFechaMuestra.setDisabled(false);
			txtDatEstimCosechaId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtConsecutivo.setValue(entity.getConsecutivo());
			txtConsecutivo.setDisabled(false);
			txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
			txtTrabId_Trabajador.setDisabled(false);
			// txtAnioFiscalNivel4.setValue(entity.getAnioFiscalNivel4());
			// txtAnioFiscalNivel4.setDisabled(false);
			txtAreaNeta.setValue(entity.getAreaNeta());
			txtAreaNeta.setDisabled(false);
			txtCantidadTotalEst.setValue(entity.getCantidadTotalEst());
			txtCantidadTotalEst.setDisabled(true);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			// txtEdadNivel4.setValue(entity.getEdadNivel4());
			// txtEdadNivel4.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtEtapaNivel4.setValue(entity.getEtapaNivel4());
			// txtEtapaNivel4.setDisabled(false);
			// txtFaseFenoNivel4.setValue(entity.getFaseFenoNivel4());
			// txtFaseFenoNivel4.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtFechaMuestra.setValue(entity.getFechaMuestra());
			txtFechaMuestra.setDisabled(false);
			// txtInfoAdicional.setValue(entity.getInfoAdicional());
			// txtInfoAdicional.setDisabled(false);
			// txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			// txtInfoAdicional2.setDisabled(false);
			// txtMobileId.setValue(entity.getMobileId());
			// txtMobileId.setDisabled(false);
			txtNivel1Id.setValue(entity.getNivel1Id());
			txtNivel1Id.setDisabled(false);
			txtNivel2Id.setValue(entity.getNivel2Id().getNivel2Id());
			txtNivel2Id.setDisabled(false);
			txtNivel3Id.setValue(entity.getNivel3Id());
			txtNivel3Id.setDisabled(false);
			txtNivel4Id.setValue(entity.getNivel4Id().getNivel4Id());
			txtNivel4Id.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			// txtObservacionAnularReg.setValue(entity.getObservacionAnularReg());
			// txtObservacionAnularReg.setDisabled(false);
			txtThEstimado.setValue(entity.getThEstimado());
			txtThEstimado.setDisabled(false);
			// txtUsuarioDigitacion.setValue(entity.getUsuarioDigitacion());
			// txtUsuarioDigitacion.setDisabled(false);
			// txtVariedNivel4.setValue(entity.getVariedNivel4());
			// txtVariedNivel4.setDisabled(false);
			txtMotEstimId_MotEstim.setValue(entity.getMotEstim().getMotEstimId());
			txtMotEstimId_MotEstim.setDisabled(false);
			txtDatEstimCosechaId.setValue(entity.getDatEstimCosechaId());
			txtDatEstimCosechaId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatEstimCosecha = (DatEstimCosechaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatEstimCosecha"));

		try {

			Long consecutivo = selectedDatEstimCosecha.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatEstimCosecha> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatEstimCosecha(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				// txtAnioFiscalNivel4.setValue(selectedDatEstimCosecha
				// .getAnioFiscalNivel4());
				// txtAnioFiscalNivel4.setDisabled(false);
				txtAreaNeta.setValue(entity.getAreaNeta());
				txtAreaNeta.setDisabled(false);
				txtCantidadTotalEst.setValue(entity.getCantidadTotalEst());
				txtCantidadTotalEst.setDisabled(true);
				// txtCompania.setValue(selectedDatEstimCosecha.getCompania());
				// txtCompania.setDisabled(false);
				// txtEdadNivel4.setValue(selectedDatEstimCosecha.getEdadNivel4());
				// txtEdadNivel4.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtEtapaNivel4.setValue(selectedDatEstimCosecha.getEtapaNivel4());
				// txtEtapaNivel4.setDisabled(false);
				// txtFaseFenoNivel4.setValue(selectedDatEstimCosecha.getFaseFenoNivel4());
				// txtFaseFenoNivel4.setDisabled(false);
				// txtFechaCreacion.setValue(selectedDatEstimCosecha.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedDatEstimCosecha
				// .getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtFechaMuestra.setValue(entity.getFechaMuestra());
				txtFechaMuestra.setDisabled(false);
				// txtInfoAdicional.setValue(selectedDatEstimCosecha.getInfoAdicional());
				// txtInfoAdicional.setDisabled(false);
				// txtInfoAdicional2.setValue(selectedDatEstimCosecha.getInfoAdicional2());
				// txtInfoAdicional2.setDisabled(false);
				// txtMobileId.setValue(selectedDatEstimCosecha.getMobileId());
				// txtMobileId.setDisabled(false);
				txtNivel1Id.setValue(entity.getNivel1Id());
				txtNivel1Id.setDisabled(false);
				txtNivel2Id.setValue(entity.getNivel2Id().getNivel2Id());
				txtNivel2Id.setDisabled(false);
				txtNivel3Id.setValue(entity.getNivel3Id());
				txtNivel3Id.setDisabled(false);
				txtNivel4Id.setValue(entity.getNivel4Id().getNivel4Id());
				txtNivel4Id.setDisabled(false);
				txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
				txtTrabId_Trabajador.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				// txtObservacionAnularReg.setValue(selectedDatEstimCosecha
				// .getObservacionAnularReg());
				// txtObservacionAnularReg.setDisabled(false);
				txtThEstimado.setValue(entity.getThEstimado());
				txtThEstimado.setDisabled(false);
				// txtUsuarioDigitacion.setValue(selectedDatEstimCosecha
				// .getUsuarioDigitacion());
				// txtUsuarioDigitacion.setDisabled(false);
				// txtVariedNivel4.setValue(selectedDatEstimCosecha.getVariedNivel4());
				// txtVariedNivel4.setDisabled(false);
				txtMotEstimId_MotEstim.setValue(entity.getMotEstim().getMotEstimId());
				txtMotEstimId_MotEstim.setDisabled(false);
				txtDatEstimCosechaId.setValue(entity.getDatEstimCosechaId());
				txtDatEstimCosechaId.setDisabled(true);
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
			if ((selectedDatEstimCosecha == null) && (entity == null)) {
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
			entity = new DatEstimCosecha();

			// Long datEstimCosechaId =
			// FacesUtils.checkLong(txtDatEstimCosechaId);

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoDatEstimCosecha(compania)));
			// entity.setAnioFiscalNivel4(FacesUtils
			// .checkLong(txtAnioFiscalNivel4));
			entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
			entity.setCantidadTotalEst(FacesUtils.checkDouble(txtCantidadTotalEst));
			entity.setCompania(compania);
			// entity.setDatEstimCosechaId(datEstimCosechaId);
			// entity.setEdadNivel4(FacesUtils.checkDouble(txtEdadNivel4));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setEtapaNivel4(FacesUtils.checkLong(txtEtapaNivel4));
			// entity.setFaseFenoNivel4(FacesUtils.checkLong(txtFaseFenoNivel4));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setFechaMuestra(FacesUtils.checkDate(txtFechaMuestra));
			// entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			// entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setMobileId(FacesUtils.checkString(txtMobileId));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			// entity.setObservacionAnularReg(FacesUtils
			// .checkString(txtObservacionAnularReg));
			entity.setThEstimado(FacesUtils.checkDouble(txtThEstimado));
			entity.setUsuarioDigitacion(usuarioId);
			// entity.setVariedNivel4(FacesUtils.checkLong(txtVariedNivel4));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel4Id((FacesUtils.checkLong(txtNivel4Id) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id)) : null);
			entity.setMotEstim((FacesUtils.checkLong(txtMotEstimId_MotEstim) != null)
					? businessDelegatorView.getMotEstim(FacesUtils.checkLong(txtMotEstimId_MotEstim)) : null);
			Long nivel4Id = Long.parseLong(txtNivel4Id.getValue().toString());
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
			entity.setEtapaNivel4(nivel4.getEtapa().getEtapaId());

			entity.setEdadNivel4((businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(txtFechaMuestra),
					FacesUtils.checkLong(txtNivel4Id))));

			businessDelegatorView.saveDatEstimCosecha(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoDatEstimCosecha(compania) - 1));

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
				Long datEstimCosechaId = new Long(selectedDatEstimCosecha.getDatEstimCosechaId());
				entity = businessDelegatorView.getDatEstimCosecha(datEstimCosechaId);
			}

			Date date = new Date();

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			// entity.setAnioFiscalNivel4(FacesUtils
			// .checkLong(txtAnioFiscalNivel4));
			entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
			entity.setCantidadTotalEst(FacesUtils.checkDouble(txtCantidadTotalEst));
			entity.setCompania(compania);
			// entity.setEdadNivel4(FacesUtils.checkDouble(txtEdadNivel4));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setEtapaNivel4(FacesUtils.checkLong(txtEtapaNivel4));
			// entity.setFaseFenoNivel4(FacesUtils.checkLong(txtFaseFenoNivel4));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setFechaMuestra(FacesUtils.checkDate(txtFechaMuestra));
			// entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			// entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setMobileId(FacesUtils.checkString(txtMobileId));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			// entity.setObservacionAnularReg(FacesUtils
			// .checkString(txtObservacionAnularReg));
			entity.setThEstimado(FacesUtils.checkDouble(txtThEstimado));
			entity.setUsuarioDigitacion(usuarioId);
			// entity.setVariedNivel4(FacesUtils.checkLong(txtVariedNivel4));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador)) : null);
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel4Id((FacesUtils.checkLong(txtNivel4Id) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id)) : null);

			entity.setMotEstim((FacesUtils.checkLong(txtMotEstimId_MotEstim) != null)
					? businessDelegatorView.getMotEstim(FacesUtils.checkLong(txtMotEstimId_MotEstim)) : null);
			/*
			 * Long nivel4Id = Long.parseLong(txtNivel4Id.getValue()
			 * .toString()); Nivel4 nivel4 =
			 * businessDelegatorView.getNivel4(nivel4Id);
			 * entity.setEtapaNivel4(nivel4.getEtapa().getEtapaId()); Date
			 * fechaCorte = nivel4.getFechaUltimoCorte(); Date fechaSiembra =
			 * nivel4.getFechaSiembra(); Date registro =
			 * entity.getFechaMuestra(); Cultivo cultivo =
			 * nivel4.getEtapa().getCultivo();
			 * 
			 * double edad = listener_calcularEdadActual(fechaCorte,
			 * fechaSiembra, cultivo, registro); entity.setEdadNivel4(edad);
			 */
			entity.setEdadNivel4((businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(txtFechaMuestra),
					FacesUtils.checkLong(txtNivel4Id))));

			businessDelegatorView.updateDatEstimCosecha(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatEstimCosecha = (DatEstimCosechaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatEstimCosecha"));

			Long datEstimCosechaId = new Long(selectedDatEstimCosecha.getDatEstimCosechaId());
			entity = businessDelegatorView.getDatEstimCosecha(datEstimCosechaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datEstimCosechaId = FacesUtils.checkLong(txtDatEstimCosechaId);
			entity = businessDelegatorView.getDatEstimCosecha(datEstimCosechaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatEstimCosecha(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws Exception {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatEstimCosecha = (DatEstimCosechaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatEstimCosecha"));

			Long datEstimCosechaId = new Long(selectedDatEstimCosecha.getDatEstimCosechaId());
			entity = businessDelegatorView.getDatEstimCosecha(datEstimCosechaId);
			businessDelegatorView.deleteDatEstimCosecha(entity);
			((Map<String, Object>) data).remove(selectedDatEstimCosecha);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anioFiscalNivel4, Double areaNeta, Double cantidadTotalEst, Long compania,
			Long datEstimCosechaId, Double edadNivel4, String estado, Long etapaNivel4, Long consecutivo,
			Long faseFenoNivel4, Date fechaCreacion, Date fechaModificacion, Date fechaMuestra, String infoAdicional,
			String infoAdicional2, String mobileId, Long nivel1Id, Long nivel2Id, Long nivel3Id, Long nivel4Id,
			String observacion, String observacionAnularReg, Double thEstimado, float latitud, float longitud,
			float precision, Long usuarioDigitacion, Long variedNivel4, Long motEstimId_MotEstim) throws Exception {
		try {
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setAnioFiscalNivel4(FacesUtils.checkLong(anioFiscalNivel4));
			entity.setAreaNeta(FacesUtils.checkDouble(areaNeta));
			entity.setCantidadTotalEst(FacesUtils.checkDouble(cantidadTotalEst));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEdadNivel4(FacesUtils.checkDouble(edadNivel4));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEtapaNivel4(FacesUtils.checkLong(etapaNivel4));
			entity.setFaseFenoNivel4(FacesUtils.checkLong(faseFenoNivel4));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaMuestra(FacesUtils.checkDate(fechaMuestra));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setMobileId(FacesUtils.checkString(mobileId));
			entity.setNivel1Id(FacesUtils.checkLong(nivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(nivel3Id));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setThEstimado(FacesUtils.checkDouble(thEstimado));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setVariedNivel4(FacesUtils.checkLong(variedNivel4));
			businessDelegatorView.updateDatEstimCosecha(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatEstimCosechaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtLatitud() {
		return txtLatitud;
	}

	public void setTxtLatitud(InputText txtLatitud) {
		this.txtLatitud = txtLatitud;
	}

	public InputText getTxtLongitud() {
		return txtLongitud;
	}

	public void setTxtLongitud(InputText txtLongitud) {
		this.txtLongitud = txtLongitud;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public InputText getTxtAnioFiscalNivel4() {
		return txtAnioFiscalNivel4;
	}

	public void setTxtAnioFiscalNivel4(InputText txtAnioFiscalNivel4) {
		this.txtAnioFiscalNivel4 = txtAnioFiscalNivel4;
	}

	public InputText getTxtAreaNeta() {
		return txtAreaNeta;
	}

	public void setTxtAreaNeta(InputText txtAreaNeta) {
		this.txtAreaNeta = txtAreaNeta;
	}

	public InputText getTxtCantidadTotalEst() {
		return txtCantidadTotalEst;
	}

	public void setTxtCantidadTotalEst(InputText txtCantidadTotalEst) {
		this.txtCantidadTotalEst = txtCantidadTotalEst;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtEdadNivel4() {
		return txtEdadNivel4;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public void setTxtEdadNivel4(InputText txtEdadNivel4) {
		this.txtEdadNivel4 = txtEdadNivel4;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEtapaNivel4() {
		return txtEtapaNivel4;
	}

	public void setTxtEtapaNivel4(InputText txtEtapaNivel4) {
		this.txtEtapaNivel4 = txtEtapaNivel4;
	}

	public InputText getTxtFaseFenoNivel4() {
		return txtFaseFenoNivel4;
	}

	public void setTxtFaseFenoNivel4(InputText txtFaseFenoNivel4) {
		this.txtFaseFenoNivel4 = txtFaseFenoNivel4;
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

	public InputText getTxtMobileId() {
		return txtMobileId;
	}

	public void setTxtMobileId(InputText txtMobileId) {
		this.txtMobileId = txtMobileId;
	}

	public SelectOneMenu getTxtNivel1Id() {
		return txtNivel1Id;
	}

	public void setTxtNivel1Id(SelectOneMenu txtNivel1Id) {
		this.txtNivel1Id = txtNivel1Id;
	}

	public SelectOneMenu getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(SelectOneMenu txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
	}

	public SelectOneMenu getTxtNivel4Id() {
		return txtNivel4Id;
	}

	public void setTxtNivel4Id(SelectOneMenu txtNivel4Id) {
		this.txtNivel4Id = txtNivel4Id;
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

	public InputText getTxtThEstimado() {
		return txtThEstimado;
	}

	public void setTxtThEstimado(InputText txtThEstimado) {
		this.txtThEstimado = txtThEstimado;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputText getTxtVariedNivel4() {
		return txtVariedNivel4;
	}

	public void setTxtVariedNivel4(InputText txtVariedNivel4) {
		this.txtVariedNivel4 = txtVariedNivel4;
	}

	public SelectOneMenu getTxtMotEstimId_MotEstim() {
		return txtMotEstimId_MotEstim;
	}

	public void setTxtMotEstimId_MotEstim(SelectOneMenu txtMotEstimId_MotEstim) {
		this.txtMotEstimId_MotEstim = txtMotEstimId_MotEstim;
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

	public Calendar getTxtFechaMuestra() {
		return txtFechaMuestra;
	}

	public void setTxtFechaMuestra(Calendar txtFechaMuestra) {
		this.txtFechaMuestra = txtFechaMuestra;
	}

	public InputText getTxtDatEstimCosechaId() {
		return txtDatEstimCosechaId;
	}

	public void setTxtDatEstimCosechaId(InputText txtDatEstimCosechaId) {
		this.txtDatEstimCosechaId = txtDatEstimCosechaId;
	}

	public LazyDataModel<DatEstimCosechaDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatEstimCosechaDTO> datEstimCosechaDTO) {
		this.data = datEstimCosechaDTO;
	}

	public DatEstimCosechaDTO getSelectedDatEstimCosecha() {
		return selectedDatEstimCosecha;
	}

	public void setSelectedDatEstimCosecha(DatEstimCosechaDTO datEstimCosecha) {
		this.selectedDatEstimCosecha = datEstimCosecha;
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

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public SelectItem[] getselectMotEstim() {

		if (motEstim == null || motEstim.size() == 0) {

			motEstim = new ArrayList<MotEstim>();

			try {

				motEstim = businessDelegatorView.getMotEstim(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<MotEstim> lista = businessDelegatorView.findByCriteriaInMotEstim(condicion, null, null);
				selectMotEstim = new SelectItem[lista.size()];

				int i = 0;
				for (MotEstim motEstim : lista) {
					selectMotEstim[i] = new SelectItem(motEstim.getMotEstimId(), motEstim.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMotEstim;
	}

	public void setselectMotEstim(SelectItem[] selectMotEstim) {
		this.selectMotEstim = selectMotEstim;
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

		if (txtNivel2Id != null && txtNivel2Id.getValue() != null && !txtNivel2Id.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id.getValue().toString());

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

	public Double listener_calcularEdadActual(Date fechaultimocorte, Date fechaSiembra, Cultivo cultivo,
			Date fechaEjecucion) throws Exception {

		// entity.Etapa.Cultivo
		// Dia = d, Mes = m, Año = a
		String mostrarEdad = cultivo.getMostrarEdad();
		// 1- Solo con la fecha de siembra
		// 2- Contemplar la fecha de Siembra y Ult. Cosecha
		String calcularEdad = cultivo.getCalcularEdad();

		int diaSiembra, mesSiembra, anoSiembra = 0;
		int diaCosecha, mesCosecha, anoCosecha = 0;

		GregorianCalendar calendario = new GregorianCalendar();
		int anoActual = calendario.get(java.util.Calendar.YEAR);

		// java.util.Date fechaEjecucion = new Date();
		GregorianCalendar calendario3 = new GregorianCalendar();
		calendario3.setTime(fechaEjecucion);
		int diaHoy = calendario3.get(java.util.Calendar.DAY_OF_MONTH);
		int mesHoy = calendario3.get(java.util.Calendar.MONTH);
		int anoHoy = calendario3.get(java.util.Calendar.YEAR);

		calendario3.set(anoHoy, mesHoy, diaHoy);
		java.sql.Date ejecucionFecha = new java.sql.Date(calendario3.getTimeInMillis());

		// Fecha Siembra
		GregorianCalendar calendario1 = new GregorianCalendar();
		// java.sql.Date siembraFecha = (java.sql.Date) new Date();

		if (fechaSiembra != null) {

			calendario1.setTime(fechaSiembra);

			diaSiembra = calendario1.get(java.util.Calendar.DAY_OF_MONTH);
			mesSiembra = calendario1.get(java.util.Calendar.MONTH);
			anoSiembra = calendario1.get(java.util.Calendar.YEAR);

			calendario1.set(anoSiembra, mesSiembra, diaSiembra);
			// java.sql.Date siembraFecha = new
			// java.sql.Date(calendario1.getTimeInMillis());
		} else {

			anoSiembra = 1970;
			mesSiembra = 01;
			diaSiembra = 01;

			calendario1.set(anoSiembra, mesSiembra - 1, diaSiembra);
			fechaSiembra = calendario1.getTime();

		}

		// Fecha Ultima Cosecha
		GregorianCalendar calendario2 = new GregorianCalendar();
		java.sql.Date cosechaFecha;

		if (fechaultimocorte != null) {

			calendario2.setTime(fechaSiembra);

			diaCosecha = calendario2.get(java.util.Calendar.DAY_OF_MONTH);
			mesCosecha = calendario2.get(java.util.Calendar.MONTH);
			anoCosecha = calendario2.get(java.util.Calendar.YEAR);

			calendario2.set(anoCosecha, mesCosecha, diaCosecha);
			// cosechaFecha = new java.sql.Date(calendario2.getTimeInMillis());

		} else {

			diaCosecha = 1970;
			mesCosecha = 01;
			diaCosecha = 01;
			calendario2.set(anoCosecha, mesCosecha - 1, diaCosecha);
			fechaultimocorte = calendario2.getTime();
		}

		double edadactual = 0.0;

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.##";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		java.sql.Date siembraFecha = new java.sql.Date(calendario1.getTimeInMillis());
		cosechaFecha = new java.sql.Date(calendario2.getTimeInMillis());

		if (calcularEdad.equals("1")) {
			if (mostrarEdad.equals("d")) {
				if (siembraFecha != null) {
					long diffDays = (ejecucionFecha.getTime() - siembraFecha.getTime());
					edadactual = diffDays / (24 * 60 * 60 * 1000);
				}
			} else if (mostrarEdad.equals("m")) {
				if (fechaSiembra != null) {
					long diffMonths = (ejecucionFecha.getTime() - siembraFecha.getTime()) / (24 * 60 * 60 * 1000);
					edadactual = Double.parseDouble(decimalFormat.format(diffMonths / 30.45));
				}

			} else if (mostrarEdad.equals("a")) {
				if (fechaSiembra != null) {
					long ddifYear = (anoActual - anoSiembra);
					edadactual = ddifYear;
				}
			}
		}

		if (calcularEdad.equals("2")) {
			if (cosechaFecha.getTime() > siembraFecha.getTime()) {
				if (mostrarEdad.equals("d")) {
					long diffDays = (ejecucionFecha.getTime() - cosechaFecha.getTime());
					edadactual = diffDays / (24 * 60 * 60 * 1000);
				} else if (mostrarEdad.equals("m")) {
					long diffMonths = (ejecucionFecha.getTime() - cosechaFecha.getTime()) / (24 * 60 * 60 * 1000);
					edadactual = Double.parseDouble(decimalFormat.format(diffMonths / 30.45));
					// edadactual = (long) Math.round(diffMonths/30.45);
				} else if (mostrarEdad.equals("a")) {
					long ddifYear = (anoActual - anoCosecha);
					edadactual = ddifYear;
				}

			} else {
				if (mostrarEdad.equals("d")) {
					if (siembraFecha != null) {
						long diffDays = (ejecucionFecha.getTime() - siembraFecha.getTime());
						edadactual = diffDays / (24 * 60 * 60 * 1000);
					}
				} else if (mostrarEdad.equals("m")) {
					if (fechaSiembra != null) {
						long diffMonths = (ejecucionFecha.getTime() - siembraFecha.getTime()) / (24 * 60 * 60 * 1000);
						edadactual = Double.parseDouble(decimalFormat.format(diffMonths / 30.45));
						// edadactual = (long) Math.round(diffMonths/30.45);
					}

				} else if (mostrarEdad.equals("a")) {
					if (fechaSiembra != null) {
						long ddifYear = (anoActual - anoSiembra);
						edadactual = ddifYear;
					}
				}
			}

		}

		return edadactual;

	}

	private class LocalDataModelDTO extends LazyDataModel<DatEstimCosechaDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatEstimCosechaDTO> datEstimCosechaDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatEstimCosechaDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datEstimCosechaDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberDatEstimCosecha(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datEstimCosechaDTO;

		}

		@Override
		public DatEstimCosechaDTO getRowData(String rowKey) {
			for (DatEstimCosechaDTO datEstimCosechaDTOtmp : datEstimCosechaDTO) {
				if (datEstimCosechaDTOtmp.getDatEstimCosechaId().toString().equals(rowKey))
					return datEstimCosechaDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatEstimCosechaDTO datEstimCosechaDTOtmp) {
			return datEstimCosechaDTOtmp.getDatEstimCosechaId();
		}

	}

	private List<DatEstimCosechaDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageDatEstimCosecha(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatEstimCosecha.getDatEstimCosechaId());
				entity = businessDelegatorView.getDatEstimCosecha(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatEstimCosecha(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) throws Exception {

		action_clear();
		selectedDatEstimCosecha = (DatEstimCosechaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatEstimCosecha"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

}
