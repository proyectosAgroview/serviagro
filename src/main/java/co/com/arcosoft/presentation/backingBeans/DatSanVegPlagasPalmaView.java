package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaSanVeg;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatSanVegDTO;
import co.com.arcosoft.modelo.dto.ValorVarDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatSanVegPlagasPalmaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatSanVegPlagasPalmaView.class);
	private InputText txtAnioFiscalNivel4;
	private InputText txtAreaBruta;
	private InputText txtAreaNeta;
	private InputText txtCompania;
	private InputText txtFoto;
	private InputText txtConsecutivo;
	private InputText txtEdadNivel4;
	private SelectOneRadio txtEstado;
	private InputText txtEtapaNivel4;
	private InputText txtFaseFenoNivel4;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional2;
	private InputText txtMobileId;
	// private InputText txtNivel1Id;
	// private InputText txtNivel3Id;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtPrecision;
	private InputText txtNumPlantasActuales;
	private InputText txtNumPlantasSembradas;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;
	private InputText txtVariedNivel4;
	// private InputText txtAnaSanVegId_AnaSanVeg;
	// private InputText txtNivel2Id_Nivel2;
	// private InputText txtNivel4Id_Nivel4;
	// private InputText txtTrabId_Trabajador;
	private InputText txtDatSanVegId;
	private SelectOneMenu txtVariable1;
	private Spinner txtVariable2;
	private Spinner txtVariable3;
	private Spinner txtVariable4;
	private Spinner txtVariable5;
	private Spinner txtVariable6;
	private Spinner txtVariable7;
	private Spinner txtVariable8;
	private InputText txtVariable9;
	private InputText txtVariable10;
	private InputText txtVariable11;
	private InputText txtVariable12;
	private InputText txtVariable13;
	private InputText txtVariable14;
	private InputText txtVariable15;
	private InputText txtVariable16;
	private InputText txtVariable17;
	private InputText txtVariable18;
	private InputText txtVariable19;
	private InputText txtVariable20;
	private InputText txtVariable21;
	private InputText txtVariable22;
	private InputText txtVariable23;
	private InputText txtVariable24;
	private InputText txtVariable25;
	private InputText txtVariable26;
	private InputText txtVariable27;
	private InputText txtVariable28;
	private InputText txtVariable29;
	private InputText txtVariable30;
	// private S txtVariableText1 ;
	private SelectOneMenu txtVariableText2;
	private SelectOneMenu txtVariableText3;
	private InputText txtVariableText4;
	private InputText txtVariableText5;
	private InputText txtVariableText6;
	private InputText txtVariableText7;
	private InputText txtVariableText8;
	private InputText txtVariableText9;
	private InputText txtVariableText10;
	private InputText txtVariableText11;
	private InputText txtVariableText12;
	private InputText txtVariableText13;
	private InputText txtVariableText14;
	private InputText txtVariableText15;
	private InputText txtVariableText16;
	private InputText txtVariableText17;
	private InputText txtVariableText18;
	private InputText txtVariableText19;
	private InputText txtVariableText20;
	private InputText txtVariableText21;
	private InputText txtVariableText22;
	private InputText txtVariableText23;
	private InputText txtVariableText24;
	private InputText txtVariableText25;
	private InputText txtVariableText26;
	private InputText txtVariableText27;
	private InputText txtVariableText28;
	private InputText txtVariableText29;
	private InputText txtVariableText30;

	private MapModel simpleModel;
	private Marker marker;
	private Calendar txtFechaAnalisis;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaAnulacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatSanVegDTO> data;
	private DatSanVegDTO selectedDatSanVeg;
	private DatSanVeg entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtNivel1Id;

	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;

	private SelectOneMenu txtAnaSanVegId_AnaSanVeg;
	SelectItem[] selectTipoAnalisis;
	private List<AnaSanVeg> tipoAnalisis;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtVariableText1;
	SelectItem[] selectFitosanidad;
	private List<Fitosanidad> fitosanidad;

	private String txtImagenSanVeg;
	private String imagenSanVeg;
	private UploadedFile file;

	private List<ValorVarDTO> dataValor;
	private ValorVarDTO selectedValor;
	private int activeTapIndex = 0;

	public DatSanVegPlagasPalmaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatSanVegDTO datSanVegDTO = (DatSanVegDTO) e.getObject();

			if (txtAnioFiscalNivel4 == null) {
				txtAnioFiscalNivel4 = new InputText();
			}

			txtAnioFiscalNivel4.setValue(datSanVegDTO.getAnioFiscalNivel4());

			if (txtAreaBruta == null) {
				txtAreaBruta = new InputText();
			}

			txtAreaBruta.setValue(datSanVegDTO.getAreaBruta());

			if (txtAreaNeta == null) {
				txtAreaNeta = new InputText();
			}

			txtAreaNeta.setValue(datSanVegDTO.getAreaNeta());

			if (txtFoto == null) {
				txtFoto = new InputText();
			}

			txtFoto.setValue(datSanVegDTO.getFoto());
			if (txtLatitud == null) {
				txtLatitud = new InputText();
			}

			txtLatitud.setValue(datSanVegDTO.getLatitud());

			if (txtLongitud == null) {
				txtLongitud = new InputText();
			}

			txtLongitud.setValue(datSanVegDTO.getLongitud());

			if (txtPrecision == null) {
				txtPrecision = new InputText();
			}

			txtPrecision.setValue(datSanVegDTO.getPrecision());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(datSanVegDTO.getCompania());

			if (txtConsecutivo == null) {
				txtConsecutivo = new InputText();
			}

			txtConsecutivo.setValue(datSanVegDTO.getConsecutivo());

			if (txtEdadNivel4 == null) {
				txtEdadNivel4 = new InputText();
			}

			txtEdadNivel4.setValue(datSanVegDTO.getEdadNivel4());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(datSanVegDTO.getEstado());

			if (txtEtapaNivel4 == null) {
				txtEtapaNivel4 = new InputText();
			}

			txtEtapaNivel4.setValue(datSanVegDTO.getEtapaNivel4());

			if (txtFaseFenoNivel4 == null) {
				txtFaseFenoNivel4 = new InputText();
			}

			txtFaseFenoNivel4.setValue(datSanVegDTO.getFaseFenoNivel4());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputText();
			}

			txtInfoAdicional.setValue(datSanVegDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputText();
			}

			txtInfoAdicional2.setValue(datSanVegDTO.getInfoAdicional2());

			if (txtMobileId == null) {
				txtMobileId = new InputText();
			}

			txtMobileId.setValue(datSanVegDTO.getMobileId());

			if (txtNivel1Id == null) {
				txtNivel1Id = new SelectOneMenu();
			}

			txtNivel1Id.setValue(datSanVegDTO.getNivel1Id());

			if (txtNivel3Id == null) {
				txtNivel3Id = new SelectOneMenu();
			}

			txtNivel3Id.setValue(datSanVegDTO.getNivel3Id());

			if (txtNumPlantasActuales == null) {
				txtNumPlantasActuales = new InputText();
			}

			txtNumPlantasActuales.setValue(datSanVegDTO.getNumPlantasActuales());

			if (txtNumPlantasSembradas == null) {
				txtNumPlantasSembradas = new InputText();
			}

			txtNumPlantasSembradas.setValue(datSanVegDTO.getNumPlantasSembradas());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(datSanVegDTO.getObservacion());

			if (txtObservacionAnularReg == null) {
				txtObservacionAnularReg = new InputTextarea();
			}

			txtObservacionAnularReg.setValue(datSanVegDTO.getObservacionAnularReg());

			if (txtUsuarioDigitacion == null) {
				txtUsuarioDigitacion = new InputText();
			}

			txtUsuarioDigitacion.setValue(datSanVegDTO.getUsuarioDigitacion());

			if (txtVariedNivel4 == null) {
				txtVariedNivel4 = new InputText();
			}

			txtVariedNivel4.setValue(datSanVegDTO.getVariedNivel4());

			if (txtAnaSanVegId_AnaSanVeg == null) {
				txtAnaSanVegId_AnaSanVeg = new SelectOneMenu();
			}

			txtAnaSanVegId_AnaSanVeg.setValue(datSanVegDTO.getAnaSanVegId_AnaSanVeg());

			if (txtNivel2Id_Nivel2 == null) {
				txtNivel2Id_Nivel2 = new SelectOneMenu();
			}

			txtNivel2Id_Nivel2.setValue(datSanVegDTO.getNivel2Id_Nivel2());

			if (txtNivel4Id_Nivel4 == null) {
				txtNivel4Id_Nivel4 = new SelectOneMenu();
			}

			txtNivel4Id_Nivel4.setValue(datSanVegDTO.getNivel4Id_Nivel4());

			if (txtTrabId_Trabajador == null) {
				txtTrabId_Trabajador = new SelectOneMenu();
			}

			txtTrabId_Trabajador.setValue(datSanVegDTO.getTrabId_Trabajador());

			if (txtDatSanVegId == null) {
				txtDatSanVegId = new InputText();
			}

			txtDatSanVegId.setValue(datSanVegDTO.getDatSanVegId());

			if (txtFechaAnalisis == null) {
				txtFechaAnalisis = new Calendar();
			}

			txtFechaAnalisis.setValue(datSanVegDTO.getFechaAnalisis());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datSanVegDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datSanVegDTO.getFechaModificacion());

			if (txtVariable1 == null) {
				txtVariable1 = new SelectOneMenu();
			}

			txtVariable1.setValue(datSanVegDTO.getVariable1());

			if (txtVariable2 == null) {
				txtVariable2 = new Spinner();
			}

			txtVariable2.setValue(datSanVegDTO.getVariable2());

			if (txtVariable3 == null) {
				txtVariable3 = new Spinner();
			}

			txtVariable3.setValue(datSanVegDTO.getVariable3());

			if (txtVariable4 == null) {
				txtVariable4 = new Spinner();
			}

			txtVariable4.setValue(datSanVegDTO.getVariable4());

			if (txtVariable5 == null) {
				txtVariable5 = new Spinner();
			}

			txtVariable5.setValue(datSanVegDTO.getVariable5());

			if (txtVariable6 == null) {
				txtVariable6 = new Spinner();
			}

			txtVariable6.setValue(datSanVegDTO.getVariable6());

			if (txtVariableText1 == null) {
				txtVariableText1 = new SelectOneMenu();
			}

			txtVariableText1.setValue(datSanVegDTO.getVariableText1());

			if (txtVariableText2 == null) {
				txtVariableText2 = new SelectOneMenu();
			}

			txtVariableText2.setValue(datSanVegDTO.getVariableText2());

			if (txtVariableText3 == null) {
				txtVariableText3 = new SelectOneMenu();
			}

			txtVariableText3.setValue(datSanVegDTO.getVariableText3());

			if (txtVariableText4 == null) {
				txtVariableText4 = new InputText();
			}

			txtVariableText4.setValue(datSanVegDTO.getVariableText4());

			if (txtVariableText5 == null) {
				txtVariableText5 = new InputText();
			}

			txtVariableText5.setValue(datSanVegDTO.getVariableText5());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datSanVegDTO.getFechaAnulacion());

			Long datSanVegId = FacesUtils.checkLong(txtDatSanVegId);
			entity = businessDelegatorView.getDatSanVeg(datSanVegId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatSanVeg = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;

		selectedDatSanVeg = null;
		PrimeFaces.current().resetInputs(":dialogDatSanVeg :frm");
		activeTapIndex = 0;

		if (txtAnioFiscalNivel4 != null) {
			txtAnioFiscalNivel4.setValue(null);
			txtAnioFiscalNivel4.setDisabled(true);
		}

		if (dataValor != null) {
			dataValor = null;
		}

		if (txtAreaBruta != null) {
			txtAreaBruta.setValue(null);
			txtAreaBruta.setDisabled(true);
		}

		if (txtAreaNeta != null) {
			txtAreaNeta.setValue(null);
			txtAreaNeta.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEdadNivel4 != null) {
			txtEdadNivel4.setValue(null);
			txtEdadNivel4.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFoto != null) {
			txtFoto.setValue(null);
			txtFoto.setDisabled(false);
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
		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(false);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(false);
		}
		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(false);
		}

		if (txtMobileId != null) {
			txtMobileId.setValue(null);
			txtMobileId.setDisabled(true);
		}

		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtNumPlantasActuales != null) {
			txtNumPlantasActuales.setValue(null);
			txtNumPlantasActuales.setDisabled(true);
		}

		if (txtNumPlantasSembradas != null) {
			txtNumPlantasSembradas.setValue(null);
			txtNumPlantasSembradas.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtVariedNivel4 != null) {
			txtVariedNivel4.setValue(null);
			txtVariedNivel4.setDisabled(true);
		}

		if (txtAnaSanVegId_AnaSanVeg != null) {
			txtAnaSanVegId_AnaSanVeg.setValue(2L);
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
		}

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtFechaAnalisis != null) {
			txtFechaAnalisis.setValue(null);
			txtFechaAnalisis.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtVariable1 != null) {
			txtVariable1.setValue(null);
			txtVariable1.setDisabled(false);
		}

		if (txtVariable2 != null) {
			txtVariable2.setValue(null);
			txtVariable2.setDisabled(false);
		}

		if (txtVariable3 != null) {
			txtVariable3.setValue(null);
			txtVariable3.setDisabled(false);
		}

		if (txtVariable4 != null) {
			txtVariable4.setValue(null);
			txtVariable4.setDisabled(false);
		}

		if (txtVariable5 != null) {
			txtVariable5.setValue(null);
			txtVariable5.setDisabled(false);
		}

		if (txtVariable6 != null) {
			txtVariable6.setValue(null);
			txtVariable6.setDisabled(false);
		}

		if (txtVariable7 != null) {
			txtVariable7.setValue(null);
			txtVariable7.setDisabled(false);
		}

		if (txtVariable8 != null) {
			txtVariable8.setValue(null);
			txtVariable8.setDisabled(false);
		}

		if (txtVariableText1 != null) {
			txtVariableText1.setValue(null);
			txtVariableText1.setDisabled(false);
		}

		if (txtVariableText2 != null) {
			txtVariableText2.setValue(null);
			txtVariableText2.setDisabled(false);
		}

		if (txtVariableText3 != null) {
			txtVariableText3.setValue(null);
			txtVariableText3.setDisabled(false);
		}

		if (txtVariable10 != null) {
			txtVariable10.setValue(null);
			txtVariable10.setDisabled(false);
		}
		if (txtVariable11 != null) {
			txtVariable11.setValue(null);
			txtVariable11.setDisabled(false);
		}
		if (txtVariable12 != null) {
			txtVariable12.setValue(null);
			txtVariable12.setDisabled(false);
		}
		if (txtVariable13 != null) {
			txtVariable13.setValue(null);
			txtVariable13.setDisabled(false);
		}
		if (txtVariable14 != null) {
			txtVariable14.setValue(null);
			txtVariable14.setDisabled(false);
		}
		if (txtVariable15 != null) {
			txtVariable15.setValue(null);
			txtVariable15.setDisabled(false);
		}
		if (txtVariable16 != null) {
			txtVariable16.setValue(null);
			txtVariable16.setDisabled(false);
		}
		if (txtVariable17 != null) {
			txtVariable17.setValue(null);
			txtVariable17.setDisabled(false);
		}

		if (txtVariableText4 != null) {
			txtVariableText4.setValue(null);
			txtVariableText4.setDisabled(false);
		}
		if (txtVariableText5 != null) {
			txtVariableText5.setValue(null);
			txtVariableText5.setDisabled(false);
		}
		if (txtVariableText6 != null) {
			txtVariableText6.setValue(null);
			txtVariableText6.setDisabled(false);
		}
		if (txtVariableText7 != null) {
			txtVariableText7.setValue(null);
			txtVariableText7.setDisabled(false);
		}

		if (txtDatSanVegId != null) {
			txtDatSanVegId.setValue(null);
			txtDatSanVegId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	public void listener_txtFechaAnalisis() {
		Date inputDate = (Date) txtFechaAnalisis.getValue();
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
	/*
	 * public MapModel getSimpleModel() throws Exception {
	 * 
	 * simpleModel = new DefaultMapModel(); LatLng coord1 = new
	 * LatLng(3.6374489,-76.2900103);
	 * 
	 * 
	 * if ((Float) txtLatitud.getValue() != null && (Float)
	 * txtLongitud.getValue() != null ){ //Shared coordinates coord1 = new
	 * LatLng((Float) txtLatitud.getValue(), (Float) txtLongitud.getValue());
	 * //Basic marker simpleModel.addOverlay(new Marker(coord1, "Casos" ));
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
	 * 
	 */

	public String action_edit(ActionEvent evt) {
		selectedDatSanVeg = (DatSanVegDTO) (evt.getComponent().getAttributes().get("selectedDatSanVeg"));

		try {

			Long consecutivo = selectedDatSanVeg.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatSanVeg> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatSanVeg(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				// txtAnioFiscalNivel4.setValue(selectedDatSanVeg.getAnioFiscalNivel4());
				// txtAnioFiscalNivel4.setDisabled(false);
				// txtAreaBruta.setValue(selectedDatSanVeg.getAreaBruta());
				// txtAreaBruta.setDisabled(false);
				// txtAreaNeta.setValue(selectedDatSanVeg.getAreaNeta());
				// txtAreaNeta.setDisabled(false);
				// txtCompania.setValue(selectedDatSanVeg.getCompania());
				// txtCompania.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				// txtEdadNivel4.setValue(selectedDatSanVeg.getEdadNivel4());
				// txtEdadNivel4.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtLatitud.setValue(entity.getLatitud());
				txtLatitud.setDisabled(false);
				txtLongitud.setValue(entity.getLongitud());
				txtLongitud.setDisabled(false);
				txtPrecision.setValue(entity.getPrecision1());
				txtPrecision.setDisabled(false);
				imagenSanVeg = ((entity.getFoto() != null && !entity.getFoto().equals("")) ? entity.getFoto()
						: "default.jpg");

				// txtEtapaNivel4.setValue(selectedDatSanVeg.getEtapaNivel4());
				// txtEtapaNivel4.setDisabled(false);
				// txtFaseFenoNivel4.setValue(selectedDatSanVeg.getFaseFenoNivel4());
				// txtFaseFenoNivel4.setDisabled(false);
				txtFechaAnalisis.setValue(entity.getFechaAnalisis());
				txtFechaAnalisis.setDisabled(false);
				// txtFechaCreacion.setValue(selectedDatSanVeg.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedDatSanVeg.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				// txtInfoAdicional.setValue(selectedDatSanVeg.getInfoAdicional());
				// txtInfoAdicional.setDisabled(false);
				// txtInfoAdicional2.setValue(selectedDatSanVeg.getInfoAdicional2());
				// txtInfoAdicional2.setDisabled(false);
				// txtMobileId.setValue(selectedDatSanVeg.getMobileId());
				// txtMobileId.setDisabled(false);
				txtNivel1Id.setValue(entity.getNivel1Id());
				txtNivel1Id.setDisabled(false);
				txtNivel3Id.setValue(entity.getNivel3Id());
				txtNivel3Id.setDisabled(false);
				// txtNumPlantasActuales.setValue(selectedDatSanVeg
				// .getNumPlantasActuales());
				// txtNumPlantasActuales.setDisabled(false);
				// txtNumPlantasSembradas.setValue(selectedDatSanVeg
				// .getNumPlantasSembradas());
				// txtNumPlantasSembradas.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				// txtObservacionAnularReg.setValue(selectedDatSanVeg
				// .getObservacionAnularReg());
				// txtObservacionAnularReg.setDisabled(false);
				// txtUsuarioDigitacion.setValue(selectedDatSanVeg.getUsuarioDigitacion());
				// txtUsuarioDigitacion.setDisabled(false);
				// txtVariedNivel4.setValue(selectedDatSanVeg.getVariedNivel4());
				// txtVariedNivel4.setDisabled(false);
				txtAnaSanVegId_AnaSanVeg.setValue(entity.getAnaSanVeg().getAnaSanVegId());
				txtAnaSanVegId_AnaSanVeg.setDisabled(false);
				txtNivel2Id_Nivel2.setValue(entity.getNivel2().getNivel2Id());
				txtNivel2Id_Nivel2.setDisabled(false);
				txtNivel4Id_Nivel4.setValue(entity.getNivel4().getNivel4Id());
				txtNivel4Id_Nivel4.setDisabled(false);
				txtTrabId_Trabajador.setValue(entity.getTrabajador());
				txtTrabId_Trabajador.setDisabled(false);
				txtVariable2.setDisabled(false);
				txtVariable2.setValue(entity.getVariable2());
				txtVariable4.setDisabled(false);
				txtVariable4.setValue(entity.getVariable4());
				txtVariable7.setDisabled(false);
				txtVariable7.setValue(entity.getVariable7());
				txtVariable8.setDisabled(false);
				txtVariable8.setValue(entity.getVariable8());

				txtVariableText1.setDisabled(false);
				txtVariableText1.setValue(entity.getVariableText1());

				txtDatSanVegId.setValue(entity.getDatSanVegId());
				txtDatSanVegId.setDisabled(true);
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
			if ((selectedDatSanVeg == null) && (entity == null)) {
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
			entity = new DatSanVeg();

			// Long datSanVegId = FacesUtils.checkLong(txtDatSanVegId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(FacesUtils.checkDate(txtFechaAnalisis));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnioFiscalNivel4(new Long(anioRegistro));

			// entity.setAnioFiscalNivel4(FacesUtils
			// .checkLong(txtAnioFiscalNivel4));
			// entity.setAreaBruta(FacesUtils.checkDouble(txtAreaBruta));
			// entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
			entity.setCompania(compania);
			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoDatSanVeg(compania)));
			// entity.setDatSanVegId(datSanVegId);
			// entity.setEdadNivel4(FacesUtils.checkDouble(txtEdadNivel4));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setEtapaNivel4(FacesUtils.checkLong(txtEtapaNivel4));
			// entity.setFaseFenoNivel4(FacesUtils.checkLong(txtFaseFenoNivel4));
			entity.setFechaAnalisis(FacesUtils.checkDate(txtFechaAnalisis));
			entity.setFechaCreacion(date);
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();
			}

			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			// entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			// entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setMobileId(FacesUtils.checkString(txtMobileId));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			// entity.setNumPlantasActuales(FacesUtils
			// .checkLong(txtNumPlantasActuales));
			// entity.setNumPlantasSembradas(FacesUtils
			// .checkLong(txtNumPlantasSembradas));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			// entity.setUsuarioDigitacion(FacesUtils
			// .checkLong(txtUsuarioDigitacion));
			// entity.setVariedNivel4(FacesUtils.checkLong(txtVariedNivel4));
			entity.setLatitud(FacesUtils.checkDouble(txtLatitud));
			entity.setLongitud(FacesUtils.checkDouble(txtLongitud));
			entity.setPrecision1(FacesUtils.checkDouble(txtPrecision));
			entity.setAnaSanVeg((FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg) != null)
					? businessDelegatorView.getAnaSanVeg(FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg)) : null);
			entity.setNivel2((FacesUtils.checkLong(txtNivel2Id_Nivel2) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id_Nivel2)) : null);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));
			entity.setVariable1(FacesUtils.checkDouble(txtVariable1));
			entity.setVariable2(FacesUtils.checkDouble(txtVariable2));
			entity.setVariable3(FacesUtils.checkDouble(txtVariable3));
			entity.setVariable4(FacesUtils.checkDouble(txtVariable4));
			entity.setVariable5(FacesUtils.checkDouble(txtVariable5));
			entity.setVariable6(FacesUtils.checkDouble(txtVariable6));
			entity.setVariable7(FacesUtils.checkDouble(txtVariable7));
			entity.setVariable8(FacesUtils.checkDouble(txtVariable8));

			entity.setVariableText1(FacesUtils.checkString(txtVariableText1));
			entity.setVariableText2(FacesUtils.checkString(txtVariableText2));
			entity.setVariableText3(FacesUtils.checkString(txtVariableText3));
			entity.setVariableText4(FacesUtils.checkString(txtVariableText4));
			entity.setVariableText5(FacesUtils.checkString(txtVariableText5));

			Long nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

			/*
			 * Date fechaCorte = nivel4.getFechaUltimoCorte(); Date fechaSiembra
			 * = nivel4.getFechaSiembra(); Date registro =
			 * entity.getFechaAnalisis(); Cultivo cultivo =
			 * nivel4.getEtapa().getCultivo();
			 * 
			 * double edad = listener_calcularEdadActual(fechaCorte,
			 * fechaSiembra, cultivo, registro); entity.setEdadNivel4(edad);/*
			 * entity.setAreaBruta(nivel4.getAreaBruta());
			 * entity.setAreaNeta(nivel4.getAreaNeta());
			 * entity.setEtapaNivel4(nivel4.getEtapa().getEtapaId());
			 * entity.setNumPlantasActuales(nivel4.getNumPlantasActuales());
			 * entity.setNumPlantasSembradas(nivel4.getNumPlantasSembradas());
			 */ entity.setEdadNivel4((businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(getTxtFechaAnalisis()),
					FacesUtils.checkLong(txtNivel4Id_Nivel4))));

			businessDelegatorView.saveDatSanVeg(entity, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoDatSanVeg(compania) - 1));
			action_clear2();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long datSanVegId = new Long(selectedDatSanVeg.getDatSanVegId());
				entity = businessDelegatorView.getDatSanVeg(datSanVegId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(FacesUtils.checkDate(txtFechaAnalisis));
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnioFiscalNivel4(new Long(anioRegistro));

			// entity.setAnioFiscalNivel4(FacesUtils
			// .checkLong(txtAnioFiscalNivel4));
			// entity.setAreaBruta(FacesUtils.checkDouble(txtAreaBruta));
			// entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
			// entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			// entity.setEdadNivel4(FacesUtils.checkDouble(txtEdadNivel4));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setEtapaNivel4(FacesUtils.checkLong(txtEtapaNivel4));
			// entity.setFaseFenoNivel4(FacesUtils.checkLong(txtFaseFenoNivel4));
			entity.setFechaAnalisis(FacesUtils.checkDate(txtFechaAnalisis));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();

			}

			// entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			// entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			// entity.setMobileId(FacesUtils.checkString(txtMobileId));
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			// entity.setNumPlantasActuales(FacesUtils
			// .checkLong(txtNumPlantasActuales));
			// entity.setNumPlantasSembradas(FacesUtils
			// .checkLong(txtNumPlantasSembradas));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			// entity.setUsuarioDigitacion(FacesUtils
			// .checkLong(txtUsuarioDigitacion));
			// entity.setVariedNivel4(FacesUtils.checkLong(txtVariedNivel4));
			entity.setLatitud(FacesUtils.checkDouble(txtLatitud));
			entity.setLongitud(FacesUtils.checkDouble(txtLongitud));
			entity.setPrecision1(FacesUtils.checkDouble(txtPrecision));
			entity.setAnaSanVeg((FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg) != null)
					? businessDelegatorView.getAnaSanVeg(FacesUtils.checkLong(txtAnaSanVegId_AnaSanVeg)) : null);
			entity.setNivel2((FacesUtils.checkLong(txtNivel2Id_Nivel2) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id_Nivel2)) : null);
			entity.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador)));

			entity.setVariable1(FacesUtils.checkDouble(txtVariable1));
			entity.setVariable2(FacesUtils.checkDouble(txtVariable2));
			entity.setVariable3(FacesUtils.checkDouble(txtVariable3));
			entity.setVariable4(FacesUtils.checkDouble(txtVariable4));
			entity.setVariable5(FacesUtils.checkDouble(txtVariable5));
			entity.setVariable6(FacesUtils.checkDouble(txtVariable6));
			entity.setVariable7(FacesUtils.checkDouble(txtVariable7));
			entity.setVariable8(FacesUtils.checkDouble(txtVariable8));

			entity.setVariableText1(FacesUtils.checkString(txtVariableText1));
			entity.setVariableText2(FacesUtils.checkString(txtVariableText2));
			entity.setVariableText3(FacesUtils.checkString(txtVariableText3));

			Long nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

			/*
			 * Date fechaCorte = nivel4.getFechaUltimoCorte(); Date fechaSiembra
			 * = nivel4.getFechaSiembra(); Date registro =
			 * entity.getFechaAnalisis(); Cultivo cultivo =
			 * nivel4.getEtapa().getCultivo();
			 * 
			 * double edad = listener_calcularEdadActual(fechaCorte,
			 * fechaSiembra, cultivo, registro); entity.setEdadNivel4(edad);
			 */
			entity.setAreaBruta(nivel4.getAreaBruta());
			entity.setAreaNeta(nivel4.getAreaNeta());
			entity.setEtapaNivel4(nivel4.getEtapa().getEtapaId());
			entity.setNumPlantasActuales(nivel4.getNumPlantasActuales());
			entity.setNumPlantasSembradas(nivel4.getNumPlantasSembradas());
			entity.setEdadNivel4((businessDelegatorView.calcularEdadLote(FacesUtils.checkDate(getTxtFechaAnalisis()),
					FacesUtils.checkLong(txtNivel4Id_Nivel4))));

			businessDelegatorView.updateDatSanVeg(entity, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
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

			FacesUtils.addInfoMessage(
					"Upps! para calcular la edad actual solo con la fecha de siembra, debe de registrar la fecha de siembra en la pestaña Datos de Siembra y Superficie");
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

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatSanVeg = (DatSanVegDTO) (evt.getComponent().getAttributes().get("selectedDatSanVeg"));

			Long datSanVegId = new Long(selectedDatSanVeg.getDatSanVegId());
			entity = businessDelegatorView.getDatSanVeg(datSanVegId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datSanVegId = FacesUtils.checkLong(txtDatSanVegId);
			entity = businessDelegatorView.getDatSanVeg(datSanVegId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatSanVeg(entity);
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
			selectedDatSanVeg = (DatSanVegDTO) (evt.getComponent().getAttributes().get("selectedDatSanVeg"));

			Long datSanVegId = new Long(selectedDatSanVeg.getDatSanVegId());
			entity = businessDelegatorView.getDatSanVeg(datSanVegId);
			businessDelegatorView.deleteDatSanVeg(entity);
			data.remove(selectedDatSanVeg);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anioFiscalNivel4, Double areaBruta, Double areaNeta, Long compania,
			Long consecutivo, Long datSanVegId, Double edadNivel4, String estado, Long etapaNivel4, Long faseFenoNivel4,
			Date fechaAnalisis, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2,
			String mobileId, Long nivel1Id, Long nivel3Id, Long numPlantasActuales, Long numPlantasSembradas,
			String observacion, String observacionAnularReg, Long usuarioDigitacion, Long variedNivel4,
			Long anaSanVegId_AnaSanVeg, Long nivel2Id_Nivel2, Long nivel4Id_Nivel4, Long trabId_Trabajador,
			float latitud, float longitud, float precision, Double variable1, Double variable2, Double variable3,
			Double variable4, Double variable5, String variableText1, String variableText2, String variableText3,
			String variableText4, String variableText5, Double variable6

	) throws Exception {
		try {
			entity.setAnioFiscalNivel4(FacesUtils.checkLong(anioFiscalNivel4));
			entity.setAreaBruta(FacesUtils.checkDouble(areaBruta));
			entity.setAreaNeta(FacesUtils.checkDouble(areaNeta));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEdadNivel4(FacesUtils.checkDouble(edadNivel4));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEtapaNivel4(FacesUtils.checkLong(etapaNivel4));
			entity.setLatitud(FacesUtils.checkDouble(latitud));
			entity.setLongitud(FacesUtils.checkDouble(longitud));
			entity.setPrecision1(FacesUtils.checkDouble(precision));
			entity.setFaseFenoNivel4(FacesUtils.checkLong(faseFenoNivel4));
			entity.setFechaAnalisis(FacesUtils.checkDate(fechaAnalisis));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setMobileId(FacesUtils.checkString(mobileId));
			entity.setNivel1Id(FacesUtils.checkLong(nivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(nivel3Id));
			entity.setNumPlantasActuales(FacesUtils.checkLong(numPlantasActuales));
			entity.setNumPlantasSembradas(FacesUtils.checkLong(numPlantasSembradas));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setVariedNivel4(FacesUtils.checkLong(variedNivel4));

			entity.setVariable1(FacesUtils.checkDouble(txtVariable1));
			entity.setVariable2(FacesUtils.checkDouble(txtVariable2));
			entity.setVariable3(FacesUtils.checkDouble(txtVariable3));
			entity.setVariable4(FacesUtils.checkDouble(txtVariable4));
			entity.setVariable5(FacesUtils.checkDouble(txtVariable5));
			entity.setVariable6(FacesUtils.checkDouble(txtVariable6));
			entity.setVariableText1(FacesUtils.checkString(txtVariableText1));
			entity.setVariableText2(FacesUtils.checkString(txtVariableText2));
			entity.setVariableText3(FacesUtils.checkString(txtVariableText3));
			entity.setVariableText4(FacesUtils.checkString(txtVariableText4));
			entity.setVariableText5(FacesUtils.checkString(txtVariableText5));

			businessDelegatorView.updateDatSanVeg(entity, null);

			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatSanVegView").requestRender();
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

	public InputText getTxtAreaBruta() {
		return txtAreaBruta;
	}

	public void setTxtAreaBruta(InputText txtAreaBruta) {
		this.txtAreaBruta = txtAreaBruta;
	}

	public InputText getTxtAreaNeta() {
		return txtAreaNeta;
	}

	public void setTxtAreaNeta(InputText txtAreaNeta) {
		this.txtAreaNeta = txtAreaNeta;
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

	public InputText getTxtEdadNivel4() {
		return txtEdadNivel4;
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

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
	}

	public InputText getTxtNumPlantasActuales() {
		return txtNumPlantasActuales;
	}

	public void setTxtNumPlantasActuales(InputText txtNumPlantasActuales) {
		this.txtNumPlantasActuales = txtNumPlantasActuales;
	}

	public InputText getTxtNumPlantasSembradas() {
		return txtNumPlantasSembradas;
	}

	public void setTxtNumPlantasSembradas(InputText txtNumPlantasSembradas) {
		this.txtNumPlantasSembradas = txtNumPlantasSembradas;
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

	public SelectOneMenu getTxtAnaSanVegId_AnaSanVeg() {
		return txtAnaSanVegId_AnaSanVeg;
	}

	public void setTxtAnaSanVegId_AnaSanVeg(SelectOneMenu txtAnaSanVegId_AnaSanVeg) {
		this.txtAnaSanVegId_AnaSanVeg = txtAnaSanVegId_AnaSanVeg;
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

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public Calendar getTxtFechaAnalisis() {
		return txtFechaAnalisis;
	}

	public void setTxtFechaAnalisis(Calendar txtFechaAnalisis) {
		this.txtFechaAnalisis = txtFechaAnalisis;
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

	public InputText getTxtDatSanVegId() {
		return txtDatSanVegId;
	}

	public void setTxtDatSanVegId(InputText txtDatSanVegId) {
		this.txtDatSanVegId = txtDatSanVegId;
	}

	public SelectOneMenu getTxtVariable1() {
		return txtVariable1;
	}

	public void setTxtVariable1(SelectOneMenu txtVariable1) {
		this.txtVariable1 = txtVariable1;
	}

	public Spinner getTxtVariable2() {
		return txtVariable2;
	}

	public void setTxtVariable2(Spinner txtVariable2) {
		this.txtVariable2 = txtVariable2;
	}

	public Spinner getTxtVariable3() {
		return txtVariable3;
	}

	public void setTxtVariable3(Spinner txtVariable3) {
		this.txtVariable3 = txtVariable3;
	}

	public Spinner getTxtVariable4() {
		return txtVariable4;
	}

	public void setTxtVariable4(Spinner txtVariable4) {
		this.txtVariable4 = txtVariable4;
	}

	public Spinner getTxtVariable5() {
		return txtVariable5;
	}

	public void setTxtVariable5(Spinner txtVariable5) {
		this.txtVariable5 = txtVariable5;
	}

	public Spinner getTxtVariable6() {
		return txtVariable6;
	}

	public void setTxtVariable6(Spinner txtVariable6) {
		this.txtVariable6 = txtVariable6;
	}

	public Spinner getTxtVariable7() {
		return txtVariable7;
	}

	public void setTxtVariable7(Spinner txtVariable7) {
		this.txtVariable7 = txtVariable7;
	}

	public Spinner getTxtVariable8() {
		return txtVariable8;
	}

	public void setTxtVariable8(Spinner txtVariable8) {
		this.txtVariable8 = txtVariable8;
	}

	public InputText getTxtVariable9() {
		return txtVariable9;
	}

	public void setTxtVariable9(InputText txtVariable9) {
		this.txtVariable9 = txtVariable9;
	}

	public InputText getTxtVariable10() {
		return txtVariable10;
	}

	public void setTxtVariable10(InputText txtVariable10) {
		this.txtVariable10 = txtVariable10;
	}

	public InputText getTxtVariable11() {
		return txtVariable11;
	}

	public void setTxtVariable11(InputText txtVariable11) {
		this.txtVariable11 = txtVariable11;
	}

	public InputText getTxtVariable12() {
		return txtVariable12;
	}

	public void setTxtVariable12(InputText txtVariable12) {
		this.txtVariable12 = txtVariable12;
	}

	public InputText getTxtVariable13() {
		return txtVariable13;
	}

	public void setTxtVariable13(InputText txtVariable13) {
		this.txtVariable13 = txtVariable13;
	}

	public InputText getTxtVariable14() {
		return txtVariable14;
	}

	public void setTxtVariable14(InputText txtVariable14) {
		this.txtVariable14 = txtVariable14;
	}

	public InputText getTxtVariable15() {
		return txtVariable15;
	}

	public void setTxtVariable15(InputText txtVariable15) {
		this.txtVariable15 = txtVariable15;
	}

	public InputText getTxtVariable16() {
		return txtVariable16;
	}

	public void setTxtVariable16(InputText txtVariable16) {
		this.txtVariable16 = txtVariable16;
	}

	public InputText getTxtVariable17() {
		return txtVariable17;
	}

	public void setTxtVariable17(InputText txtVariable17) {
		this.txtVariable17 = txtVariable17;
	}

	public InputText getTxtVariable18() {
		return txtVariable18;
	}

	public void setTxtVariable18(InputText txtVariable18) {
		this.txtVariable18 = txtVariable18;
	}

	public InputText getTxtVariable19() {
		return txtVariable19;
	}

	public void setTxtVariable19(InputText txtVariable19) {
		this.txtVariable19 = txtVariable19;
	}

	public InputText getTxtVariable20() {
		return txtVariable20;
	}

	public void setTxtVariable20(InputText txtVariable20) {
		this.txtVariable20 = txtVariable20;
	}

	public InputText getTxtVariable21() {
		return txtVariable21;
	}

	public void setTxtVariable21(InputText txtVariable21) {
		this.txtVariable21 = txtVariable21;
	}

	public InputText getTxtVariable22() {
		return txtVariable22;
	}

	public void setTxtVariable22(InputText txtVariable22) {
		this.txtVariable22 = txtVariable22;
	}

	public InputText getTxtVariable23() {
		return txtVariable23;
	}

	public void setTxtVariable23(InputText txtVariable23) {
		this.txtVariable23 = txtVariable23;
	}

	public InputText getTxtVariable24() {
		return txtVariable24;
	}

	public void setTxtVariable24(InputText txtVariable24) {
		this.txtVariable24 = txtVariable24;
	}

	public InputText getTxtVariable25() {
		return txtVariable25;
	}

	public void setTxtVariable25(InputText txtVariable25) {
		this.txtVariable25 = txtVariable25;
	}

	public InputText getTxtVariable26() {
		return txtVariable26;
	}

	public void setTxtVariable26(InputText txtVariable26) {
		this.txtVariable26 = txtVariable26;
	}

	public InputText getTxtVariable27() {
		return txtVariable27;
	}

	public void setTxtVariable27(InputText txtVariable27) {
		this.txtVariable27 = txtVariable27;
	}

	public InputText getTxtVariable28() {
		return txtVariable28;
	}

	public void setTxtVariable28(InputText txtVariable28) {
		this.txtVariable28 = txtVariable28;
	}

	public InputText getTxtVariable29() {
		return txtVariable29;
	}

	public void setTxtVariable29(InputText txtVariable29) {
		this.txtVariable29 = txtVariable29;
	}

	public InputText getTxtVariable30() {
		return txtVariable30;
	}

	public void setTxtVariable30(InputText txtVariable30) {
		this.txtVariable30 = txtVariable30;
	}

	public SelectOneMenu getTxtVariableText1() {
		return txtVariableText1;
	}

	public void setTxtVariableText1(SelectOneMenu txtVariableText1) {
		this.txtVariableText1 = txtVariableText1;
	}

	public SelectOneMenu getTxtVariableText2() {
		return txtVariableText2;
	}

	public void setTxtVariableText2(SelectOneMenu txtVariableText2) {
		this.txtVariableText2 = txtVariableText2;
	}

	public SelectOneMenu getTxtVariableText3() {
		return txtVariableText3;
	}

	public void setTxtVariableText3(SelectOneMenu txtVariableText3) {
		this.txtVariableText3 = txtVariableText3;
	}

	public InputText getTxtVariableText4() {
		return txtVariableText4;
	}

	public void setTxtVariableText4(InputText txtVariableText4) {
		this.txtVariableText4 = txtVariableText4;
	}

	public InputText getTxtVariableText5() {
		return txtVariableText5;
	}

	public void setTxtVariableText5(InputText txtVariableText5) {
		this.txtVariableText5 = txtVariableText5;
	}

	public InputText getTxtVariableText6() {
		return txtVariableText6;
	}

	public void setTxtVariableText6(InputText txtVariableText6) {
		this.txtVariableText6 = txtVariableText6;
	}

	public InputText getTxtVariableText7() {
		return txtVariableText7;
	}

	public void setTxtVariableText7(InputText txtVariableText7) {
		this.txtVariableText7 = txtVariableText7;
	}

	public InputText getTxtVariableText8() {
		return txtVariableText8;
	}

	public void setTxtVariableText8(InputText txtVariableText8) {
		this.txtVariableText8 = txtVariableText8;
	}

	public InputText getTxtVariableText9() {
		return txtVariableText9;
	}

	public void setTxtVariableText9(InputText txtVariableText9) {
		this.txtVariableText9 = txtVariableText9;
	}

	public InputText getTxtVariableText10() {
		return txtVariableText10;
	}

	public void setTxtVariableText10(InputText txtVariableText10) {
		this.txtVariableText10 = txtVariableText10;
	}

	public InputText getTxtVariableText11() {
		return txtVariableText11;
	}

	public void setTxtVariableText11(InputText txtVariableText11) {
		this.txtVariableText11 = txtVariableText11;
	}

	public InputText getTxtVariableText12() {
		return txtVariableText12;
	}

	public void setTxtVariableText12(InputText txtVariableText12) {
		this.txtVariableText12 = txtVariableText12;
	}

	public InputText getTxtVariableText13() {
		return txtVariableText13;
	}

	public void setTxtVariableText13(InputText txtVariableText13) {
		this.txtVariableText13 = txtVariableText13;
	}

	public InputText getTxtVariableText14() {
		return txtVariableText14;
	}

	public void setTxtVariableText14(InputText txtVariableText14) {
		this.txtVariableText14 = txtVariableText14;
	}

	public InputText getTxtVariableText15() {
		return txtVariableText15;
	}

	public void setTxtVariableText15(InputText txtVariableText15) {
		this.txtVariableText15 = txtVariableText15;
	}

	public InputText getTxtVariableText16() {
		return txtVariableText16;
	}

	public void setTxtVariableText16(InputText txtVariableText16) {
		this.txtVariableText16 = txtVariableText16;
	}

	public InputText getTxtVariableText17() {
		return txtVariableText17;
	}

	public void setTxtVariableText17(InputText txtVariableText17) {
		this.txtVariableText17 = txtVariableText17;
	}

	public InputText getTxtVariableText18() {
		return txtVariableText18;
	}

	public void setTxtVariableText18(InputText txtVariableText18) {
		this.txtVariableText18 = txtVariableText18;
	}

	public InputText getTxtVariableText19() {
		return txtVariableText19;
	}

	public void setTxtVariableText19(InputText txtVariableText19) {
		this.txtVariableText19 = txtVariableText19;
	}

	public InputText getTxtVariableText20() {
		return txtVariableText20;
	}

	public void setTxtVariableText20(InputText txtVariableText20) {
		this.txtVariableText20 = txtVariableText20;
	}

	public InputText getTxtVariableText21() {
		return txtVariableText21;
	}

	public void setTxtVariableText21(InputText txtVariableText21) {
		this.txtVariableText21 = txtVariableText21;
	}

	public InputText getTxtVariableText22() {
		return txtVariableText22;
	}

	public void setTxtVariableText22(InputText txtVariableText22) {
		this.txtVariableText22 = txtVariableText22;
	}

	public InputText getTxtVariableText23() {
		return txtVariableText23;
	}

	public void setTxtVariableText23(InputText txtVariableText23) {
		this.txtVariableText23 = txtVariableText23;
	}

	public InputText getTxtVariableText24() {
		return txtVariableText24;
	}

	public void setTxtVariableText24(InputText txtVariableText24) {
		this.txtVariableText24 = txtVariableText24;
	}

	public InputText getTxtVariableText25() {
		return txtVariableText25;
	}

	public void setTxtVariableText25(InputText txtVariableText25) {
		this.txtVariableText25 = txtVariableText25;
	}

	public InputText getTxtVariableText26() {
		return txtVariableText26;
	}

	public void setTxtVariableText26(InputText txtVariableText26) {
		this.txtVariableText26 = txtVariableText26;
	}

	public InputText getTxtVariableText27() {
		return txtVariableText27;
	}

	public void setTxtVariableText27(InputText txtVariableText27) {
		this.txtVariableText27 = txtVariableText27;
	}

	public InputText getTxtVariableText28() {
		return txtVariableText28;
	}

	public void setTxtVariableText28(InputText txtVariableText28) {
		this.txtVariableText28 = txtVariableText28;
	}

	public InputText getTxtVariableText29() {
		return txtVariableText29;
	}

	public void setTxtVariableText29(InputText txtVariableText29) {
		this.txtVariableText29 = txtVariableText29;
	}

	public InputText getTxtVariableText30() {
		return txtVariableText30;
	}

	public void setTxtVariableText30(InputText txtVariableText30) {
		this.txtVariableText30 = txtVariableText30;
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

		new ArrayList<Nivel2>();

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

		new ArrayList<Nivel3>();

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
		new ArrayList<Nivel4>();

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

	public SelectItem[] getSelectTipoAnalisis() {

		if (tipoAnalisis == null || tipoAnalisis.size() == 0) {

			tipoAnalisis = new ArrayList<AnaSanVeg>();

			try {

				tipoAnalisis = businessDelegatorView.getAnaSanVeg(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "anaSanVegId", true, 2, ">=", "anaSanVegId", true, 3,
						"<=" };
				List<AnaSanVeg> lista = businessDelegatorView.findByCriteriaInAnaSanVeg(condicion, null, null);
				selectTipoAnalisis = new SelectItem[lista.size()];

				int i = 0;
				for (AnaSanVeg tipoAnalisis : lista) {
					selectTipoAnalisis[i] = new SelectItem(tipoAnalisis.getAnaSanVegId(), tipoAnalisis.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoAnalisis;
	}

	public void setSelectTipoAnalisis(SelectItem[] selectTipoAnalisis) {
		this.selectTipoAnalisis = selectTipoAnalisis;
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				trabajador = businessDelegatorView.getTrabajador(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "="

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

	public SelectItem[] getSelectFitosanidad() {

		if (fitosanidad == null || fitosanidad.size() == 0) {

			fitosanidad = new ArrayList<Fitosanidad>();

			try {

				fitosanidad = businessDelegatorView.getFitosanidad(); // Fin by
				// Criteria

				Object[] condicion = { "estado", true, "A", "=", "claseFitosanidad", true, "PLAGA", "=" };

				List<Fitosanidad> lista = businessDelegatorView.findByCriteriaInFitosanidad(condicion, null, null);
				selectFitosanidad = new SelectItem[lista.size()];

				int i = 0;
				for (Fitosanidad fitosanidad : lista) {

					selectFitosanidad[i] = new SelectItem(fitosanidad.getFitosanidadId(), fitosanidad.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFitosanidad;
	}

	public void setSelectFitosanidad(SelectItem[] selectFitosanidad) {
		this.selectFitosanidad = selectFitosanidad;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;

		if (file != null) {
			this.txtImagenSanVeg = file.getFileName();
		}
	}

	public InputText getTxtFoto() {
		return txtFoto;
	}

	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
	}

	public String getTxtImagenSanVeg() {
		return txtImagenSanVeg;
	}

	public void setTxtImagenSanVeg(String txtImagenSanVeg) {
		this.txtImagenSanVeg = txtImagenSanVeg;
	}

	public String getImagenSanVeg() {
		return imagenSanVeg;
	}

	public void setImagenSanVeg(String imagenSanVeg) {
		this.imagenSanVeg = imagenSanVeg;
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

			imagenSanVeg = fileName;

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

	public List<DatSanVegDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatSanVeg(2L);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatSanVegDTO> datSanVegDTO) {
		this.data = datSanVegDTO;
	}

	public DatSanVegDTO getSelectedDatSanVeg() {
		return selectedDatSanVeg;
	}

	public void setSelectedDatSanVeg(DatSanVegDTO datSanVeg) {
		this.selectedDatSanVeg = datSanVeg;
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

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatSanVeg.getDatSanVegId());
				entity = businessDelegatorView.getDatSanVeg(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatSanVeg(entity, null);
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
		selectedDatSanVeg = (DatSanVegDTO) (evt.getComponent().getAttributes().get("selectedDatSanVeg"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_clear2() {
		entity = null;

		selectedDatSanVeg = null;
		PrimeFaces.current().resetInputs(":dialogDatSanVeg :frm");

		if (txtAnioFiscalNivel4 != null) {
			txtAnioFiscalNivel4.setValue(null);
			txtAnioFiscalNivel4.setDisabled(true);
		}

		if (txtAreaBruta != null) {
			txtAreaBruta.setValue(null);
			txtAreaBruta.setDisabled(true);
		}

		if (txtAreaNeta != null) {
			txtAreaNeta.setValue(null);
			txtAreaNeta.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEdadNivel4 != null) {
			txtEdadNivel4.setValue(null);
			txtEdadNivel4.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFoto != null) {
			txtFoto.setValue(null);
			txtFoto.setDisabled(false);
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
		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(false);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(false);
		}
		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(false);
		}

		if (txtMobileId != null) {
			txtMobileId.setValue(null);
			txtMobileId.setDisabled(true);
		}

		if (txtNumPlantasActuales != null) {
			txtNumPlantasActuales.setValue(null);
			txtNumPlantasActuales.setDisabled(true);
		}

		if (txtNumPlantasSembradas != null) {
			txtNumPlantasSembradas.setValue(null);
			txtNumPlantasSembradas.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtVariedNivel4 != null) {
			txtVariedNivel4.setValue(null);
			txtVariedNivel4.setDisabled(true);
		}

		if (txtAnaSanVegId_AnaSanVeg != null) {
			txtAnaSanVegId_AnaSanVeg.setValue(null);
			txtAnaSanVegId_AnaSanVeg.setDisabled(false);
		}

		if (txtFechaAnalisis != null) {
			txtFechaAnalisis.setValue(null);
			txtFechaAnalisis.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtVariable1 != null) {
			txtVariable1.setValue(null);
			txtVariable1.setDisabled(false);
		}

		if (txtVariable2 != null) {
			txtVariable2.setValue(null);
			txtVariable2.setDisabled(false);
		}

		if (txtVariable3 != null) {
			txtVariable3.setValue(null);
			txtVariable3.setDisabled(false);
		}

		if (txtVariable4 != null) {
			txtVariable4.setValue(null);
			txtVariable4.setDisabled(false);
		}

		if (txtVariable5 != null) {
			txtVariable5.setValue(null);
			txtVariable5.setDisabled(false);
		}

		if (txtVariable6 != null) {
			txtVariable6.setValue(null);
			txtVariable6.setDisabled(false);
		}

		if (txtVariable7 != null) {
			txtVariable7.setValue(null);
			txtVariable7.setDisabled(false);
		}

		if (txtVariable8 != null) {
			txtVariable8.setValue(null);
			txtVariable8.setDisabled(false);
		}

		if (txtVariableText1 != null) {
			txtVariableText1.setValue(null);
			txtVariableText1.setDisabled(false);
		}

		if (txtVariableText2 != null) {
			txtVariableText2.setValue(null);
			txtVariableText2.setDisabled(false);
		}

		if (txtVariableText3 != null) {
			txtVariableText3.setValue(null);
			txtVariableText3.setDisabled(false);
		}

		if (txtVariableText4 != null) {
			txtVariableText4.setValue(null);
			txtVariableText4.setDisabled(false);
		}

		if (txtVariableText5 != null) {
			txtVariableText5.setValue(null);
			txtVariableText5.setDisabled(false);
		}

		if (txtDatSanVegId != null) {
			txtDatSanVegId.setValue(null);
			txtDatSanVegId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

}
