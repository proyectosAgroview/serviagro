package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatClimat;
import co.com.arcosoft.modelo.EstClimat;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatClimatDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatClimatView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatClimatView.class);
	private InputText txtCompania;
	private InputText txtDireccionViento;
	private InputText txtEnergiaSolar;
	private InputText txtEstado;
	private InputText txtEvaporacion;
	private InputText txtEvaporacionTranspiracion;
	private InputText txtGradosDiaCalor;
	private InputText txtGradosDiaFrio;
	private InputText txtHumedadMaxima;
	private InputText txtHorasLuz;
	private InputText txtHorasSol;
	private InputText txtHumedadExterior;
	private InputText txtHumedadInterior;
	private InputText txtHumedadMedia;
	private InputText txtHumedadMinima;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtobservacion;
	private InputTextarea txtobservacionAnularReg;
	private InputText txtInsolacion;
	private InputText txtNubosidad;
	private InputText txtPrecipitacion;
	private InputText txtPuntoRocio;
	private InputText txtRadiacionSolar;
	private InputText txtSensacionTermica;
	private InputText txtTemperaturaAmbiente;
	private InputText txtTemperaturaMaxima;
	private InputText txtTemperaturaMedia;
	private InputText txtTemperaturaMinima;
	private InputText txtVelocidadMaxima;
	private InputText txtVelocidadViento;
	private InputText txtDatsClimatoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaLluvia;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaAnulacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<DatClimatDTO> data;
	private DatClimatDTO selectedDatClimat;
	private DatClimat entity;
	private boolean showDialog;

	// Select Estaciones Climatologicas
	private SelectOneMenu txtEstClimatId_EstClimat;
	SelectItem[] selectEstClima;
	private List<EstClimat> estClima;

	private double result;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DatClimatView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DatClimatDTO datClimatDTO = (DatClimatDTO) e.getObject();

			txtCompania.setValue(datClimatDTO.getCompania());

			if (txtDireccionViento == null) {
				txtDireccionViento = new InputText();
			}

			txtDireccionViento.setValue(datClimatDTO.getDireccionViento());

			if (txtEnergiaSolar == null) {
				txtEnergiaSolar = new InputText();
			}

			txtEnergiaSolar.setValue(datClimatDTO.getEnergiaSolar());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(datClimatDTO.getEstado());

			if (txtEvaporacion == null) {
				txtEvaporacion = new InputText();
			}

			txtEvaporacion.setValue(datClimatDTO.getEvaporacion());

			if (txtEvaporacionTranspiracion == null) {
				txtEvaporacionTranspiracion = new InputText();
			}

			txtEvaporacionTranspiracion.setValue(datClimatDTO.getEvaporacionTranspiracion());

			if (txtGradosDiaCalor == null) {
				txtGradosDiaCalor = new InputText();
			}

			txtGradosDiaCalor.setValue(datClimatDTO.getGradosDiaCalor());

			if (txtGradosDiaFrio == null) {
				txtGradosDiaFrio = new InputText();
			}

			txtGradosDiaFrio.setValue(datClimatDTO.getGradosDiaFrio());

			if (txtHumedadMaxima == null) {
				txtHumedadMaxima = new InputText();
			}

			txtHumedadMaxima.setValue(datClimatDTO.getHemedadMaxima());

			if (txtHorasLuz == null) {
				txtHorasLuz = new InputText();
			}

			txtHorasLuz.setValue(datClimatDTO.getHorasLuz());

			if (txtHorasSol == null) {
				txtHorasSol = new InputText();
			}

			txtHorasSol.setValue(datClimatDTO.getHorasSol());

			if (txtHumedadExterior == null) {
				txtHumedadExterior = new InputText();
			}

			txtHumedadExterior.setValue(datClimatDTO.getHumedadExterior());

			if (txtHumedadInterior == null) {
				txtHumedadInterior = new InputText();
			}

			txtHumedadInterior.setValue(datClimatDTO.getHumedadInterior());

			if (txtHumedadMedia == null) {
				txtHumedadMedia = new InputText();
			}

			txtHumedadMedia.setValue(datClimatDTO.getHumedadMedia());

			if (txtHumedadMinima == null) {
				txtHumedadMinima = new InputText();
			}

			txtHumedadMinima.setValue(datClimatDTO.getHumedadMinima());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(datClimatDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(datClimatDTO.getInfoAdicional2());

			if (txtInsolacion == null) {
				txtInsolacion = new InputText();
			}

			txtInsolacion.setValue(datClimatDTO.getInsolacion());

			if (txtNubosidad == null) {
				txtNubosidad = new InputText();
			}

			txtNubosidad.setValue(datClimatDTO.getNubosidad());

			if (txtPrecipitacion == null) {
				txtPrecipitacion = new InputText();
			}

			txtPrecipitacion.setValue(datClimatDTO.getPrecipitacion());

			if (txtobservacion == null) {
				txtobservacion = new InputTextarea();
			}

			txtobservacion.setValue(datClimatDTO.getObservacion());

			if (txtobservacionAnularReg == null) {
				txtobservacionAnularReg = new InputTextarea();
			}

			txtobservacionAnularReg.setValue(datClimatDTO.getObservacionAnularReg());

			if (txtPrecipitacion == null) {
				txtPrecipitacion = new InputText();
			}

			if (txtPuntoRocio == null) {
				txtPuntoRocio = new InputText();
			}

			txtPuntoRocio.setValue(datClimatDTO.getPuntoRocio());

			if (txtRadiacionSolar == null) {
				txtRadiacionSolar = new InputText();
			}

			txtRadiacionSolar.setValue(datClimatDTO.getRadiacionSolar());

			if (txtSensacionTermica == null) {
				txtSensacionTermica = new InputText();
			}

			txtSensacionTermica.setValue(datClimatDTO.getSensacionTermica());

			if (txtTemperaturaAmbiente == null) {
				txtTemperaturaAmbiente = new InputText();
			}

			txtTemperaturaAmbiente.setValue(datClimatDTO.getTemperaturaAmbiente());

			if (txtTemperaturaMaxima == null) {
				txtTemperaturaMaxima = new InputText();
			}

			txtTemperaturaMaxima.setValue(datClimatDTO.getTemperaturaMaxima());

			if (txtTemperaturaMedia == null) {
				txtTemperaturaMedia = new InputText();
			}

			txtTemperaturaMedia.setValue(datClimatDTO.getTemperaturaMedia());

			if (txtTemperaturaMinima == null) {
				txtTemperaturaMinima = new InputText();
			}

			txtTemperaturaMinima.setValue(datClimatDTO.getTemperaturaMinima());

			if (txtVelocidadMaxima == null) {
				txtVelocidadMaxima = new InputText();
			}

			txtVelocidadMaxima.setValue(datClimatDTO.getVelocidadMaxima());

			if (txtVelocidadViento == null) {
				txtVelocidadViento = new InputText();
			}

			txtVelocidadViento.setValue(datClimatDTO.getVelocidadViento());

			if (txtEstClimatId_EstClimat == null) {
				txtEstClimatId_EstClimat = new SelectOneMenu();
			}

			txtEstClimatId_EstClimat.setValue(datClimatDTO.getEstClimatId_EstClimat());

			if (txtDatsClimatoId == null) {
				txtDatsClimatoId = new InputText();
			}

			txtDatsClimatoId.setValue(datClimatDTO.getDatsClimatoId());

			if (txtFechaAnulacion == null) {
				txtFechaAnulacion = new Calendar();
			}

			txtFechaAnulacion.setValue(datClimatDTO.getFechaAnulacion());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(datClimatDTO.getFechaCreacion());

			if (txtFechaLluvia == null) {
				txtFechaLluvia = new Calendar();
			}

			txtFechaLluvia.setValue(datClimatDTO.getFechaLluvia());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(datClimatDTO.getFechaModificacion());

			Long datsClimatoId = FacesUtils.checkLong(txtDatsClimatoId);
			entity = businessDelegatorView.getDatClimat(datsClimatoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDatClimat = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatClimat = null;
		PrimeFaces.current().resetInputs(":dialogDatClimat :frm");
		PrimeFaces.current().resetInputs(":dialogAnularReg :formDialogAnularReg");

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtDireccionViento != null) {
			txtDireccionViento.setValue(null);
			txtDireccionViento.setDisabled(false);
		}

		if (txtEnergiaSolar != null) {
			txtEnergiaSolar.setValue(null);
			txtEnergiaSolar.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtEvaporacion != null) {
			txtEvaporacion.setValue(null);
			txtEvaporacion.setDisabled(false);
		}

		if (txtEvaporacionTranspiracion != null) {
			txtEvaporacionTranspiracion.setValue(null);
			txtEvaporacionTranspiracion.setDisabled(false);
		}

		if (txtGradosDiaCalor != null) {
			txtGradosDiaCalor.setValue(null);
			txtGradosDiaCalor.setDisabled(false);
		}

		if (txtGradosDiaFrio != null) {
			txtGradosDiaFrio.setValue(null);
			txtGradosDiaFrio.setDisabled(false);
		}

		if (txtHumedadMaxima != null) {
			txtHumedadMaxima.setValue(null);
			txtHumedadMaxima.setDisabled(false);
		}

		if (txtHorasLuz != null) {
			txtHorasLuz.setValue(null);
			txtHorasLuz.setDisabled(false);
		}

		if (txtHorasSol != null) {
			txtHorasSol.setValue(null);
			txtHorasSol.setDisabled(false);
		}

		if (txtHumedadExterior != null) {
			txtHumedadExterior.setValue(null);
			txtHumedadExterior.setDisabled(false);
		}

		if (txtHumedadInterior != null) {
			txtHumedadInterior.setValue(null);
			txtHumedadInterior.setDisabled(false);
		}

		if (txtHumedadMedia != null) {
			txtHumedadMedia.setValue(null);
			txtHumedadMedia.setDisabled(false);
		}

		if (txtHumedadMinima != null) {
			txtHumedadMinima.setValue(null);
			txtHumedadMinima.setDisabled(false);
		}

		if (txtInsolacion != null) {
			txtInsolacion.setValue(null);
			txtInsolacion.setDisabled(false);
		}

		if (txtNubosidad != null) {
			txtNubosidad.setValue(null);
			txtNubosidad.setDisabled(false);
		}

		if (txtobservacion != null) {
			txtobservacion.setValue(null);
			txtobservacion.setDisabled(false);
		}

		if (txtobservacionAnularReg != null) {
			txtobservacionAnularReg.setValue(null);
			txtobservacionAnularReg.setDisabled(false);
		}

		if (txtPrecipitacion != null) {
			txtPrecipitacion.setValue(null);
			txtPrecipitacion.setDisabled(false);
		}

		if (txtPuntoRocio != null) {
			txtPuntoRocio.setValue(null);
			txtPuntoRocio.setDisabled(false);
		}

		if (txtRadiacionSolar != null) {
			txtRadiacionSolar.setValue(null);
			txtRadiacionSolar.setDisabled(false);
		}

		if (txtSensacionTermica != null) {
			txtSensacionTermica.setValue(null);
			txtSensacionTermica.setDisabled(false);
		}

		if (txtTemperaturaAmbiente != null) {
			txtTemperaturaAmbiente.setValue(null);
			txtTemperaturaAmbiente.setDisabled(false);
		}

		if (txtTemperaturaMaxima != null) {
			txtTemperaturaMaxima.setValue(null);
			txtTemperaturaMaxima.setDisabled(false);
		}

		if (txtTemperaturaMedia != null) {
			txtTemperaturaMedia.setValue(null);
			txtTemperaturaMedia.setDisabled(true);
		}

		if (txtTemperaturaMinima != null) {
			txtTemperaturaMinima.setValue(null);
			txtTemperaturaMinima.setDisabled(false);
		}

		if (txtVelocidadMaxima != null) {
			txtVelocidadMaxima.setValue(null);
			txtVelocidadMaxima.setDisabled(false);
		}

		if (txtVelocidadViento != null) {
			txtVelocidadViento.setValue(null);
			txtVelocidadViento.setDisabled(false);
		}

		if (txtEstClimatId_EstClimat != null) {
			txtEstClimatId_EstClimat.setValue(null);
			txtEstClimatId_EstClimat.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaLluvia != null) {
			txtFechaLluvia.setValue(null);
			txtFechaLluvia.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtDatsClimatoId != null) {
			txtDatsClimatoId.setValue(null);
			txtDatsClimatoId.setDisabled(false);
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

	public void listener_txtFechaLluvia() {
		Date inputDate = (Date) txtFechaLluvia.getValue();
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

	public void listener_calculartempMedia() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double tempMinima = FacesUtils.checkDouble(getTxtTemperaturaMinima());
		Double tempMaxima = FacesUtils.checkDouble(getTxtTemperaturaMaxima());

		if (tempMinima != null && tempMaxima != null) {
			result = (tempMinima + tempMaxima) / 2;
			String format = decimalFormat.format(result);
			txtTemperaturaMedia.setValue(format);
		} else {
			result = 0;
			txtTemperaturaMedia.setValue(result);
		}

	}

	public void listener_txtId() {
		try {
			Long datsClimatoId = FacesUtils.checkLong(txtDatsClimatoId);
			entity = (datsClimatoId != null) ? businessDelegatorView.getDatClimat(datsClimatoId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {

			txtCompania.setDisabled(false);
			txtDireccionViento.setDisabled(false);
			txtEnergiaSolar.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEvaporacion.setDisabled(false);
			txtEvaporacionTranspiracion.setDisabled(false);
			txtGradosDiaCalor.setDisabled(false);
			txtGradosDiaFrio.setDisabled(false);
			txtHumedadMaxima.setDisabled(false);
			txtHorasLuz.setDisabled(false);
			txtHorasSol.setDisabled(false);
			txtHumedadExterior.setDisabled(false);
			txtHumedadInterior.setDisabled(false);
			txtHumedadMedia.setDisabled(false);
			txtHumedadMinima.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtInsolacion.setDisabled(false);
			txtNubosidad.setDisabled(false);
			txtPrecipitacion.setDisabled(false);
			txtPuntoRocio.setDisabled(false);
			txtRadiacionSolar.setDisabled(false);
			txtSensacionTermica.setDisabled(false);
			txtTemperaturaAmbiente.setDisabled(false);
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setDisabled(false);
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadViento.setDisabled(false);
			txtEstClimatId_EstClimat.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaLluvia.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtDatsClimatoId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {

			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtDireccionViento.setValue(entity.getDireccionViento());
			txtDireccionViento.setDisabled(false);
			txtEnergiaSolar.setValue(entity.getEnergiaSolar());
			txtEnergiaSolar.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEvaporacion.setValue(entity.getEvaporacion());
			txtEvaporacion.setDisabled(false);
			txtEvaporacionTranspiracion.setValue(entity.getEvaporacionTranspiracion());
			txtEvaporacionTranspiracion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaLluvia.setValue(entity.getFechaLluvia());
			txtFechaLluvia.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtGradosDiaCalor.setValue(entity.getGradosDiaCalor());
			txtGradosDiaCalor.setDisabled(false);
			txtGradosDiaFrio.setValue(entity.getGradosDiaFrio());
			txtGradosDiaFrio.setDisabled(false);
			txtHumedadMaxima.setValue(entity.getHumedadMaxima());
			txtHumedadMaxima.setDisabled(false);
			txtHorasLuz.setValue(entity.getHorasLuz());
			txtHorasLuz.setDisabled(false);
			txtHorasSol.setValue(entity.getHorasSol());
			txtHorasSol.setDisabled(false);
			txtHumedadExterior.setValue(entity.getHumedadExterior());
			txtHumedadExterior.setDisabled(false);
			txtHumedadInterior.setValue(entity.getHumedadInterior());
			txtHumedadInterior.setDisabled(false);
			txtHumedadMedia.setValue(entity.getHumedadMedia());
			txtHumedadMedia.setDisabled(false);
			txtHumedadMinima.setValue(entity.getHumedadMinima());
			txtHumedadMinima.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtInsolacion.setValue(entity.getInsolacion());
			txtInsolacion.setDisabled(false);
			txtNubosidad.setValue(entity.getNubosidad());
			txtNubosidad.setDisabled(false);
			txtPrecipitacion.setValue(entity.getPrecipitacion());
			txtPrecipitacion.setDisabled(false);
			txtPuntoRocio.setValue(entity.getPuntoRocio());
			txtPuntoRocio.setDisabled(false);
			txtRadiacionSolar.setValue(entity.getRadiacionSolar());
			txtRadiacionSolar.setDisabled(false);
			txtSensacionTermica.setValue(entity.getSensacionTermica());
			txtSensacionTermica.setDisabled(false);
			txtTemperaturaAmbiente.setValue(entity.getTemperaturaAmbiente());
			txtTemperaturaAmbiente.setDisabled(false);
			txtTemperaturaMaxima.setValue(entity.getTemperaturaMaxima());
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setValue(entity.getTemperaturaMedia());
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setValue(entity.getTemperaturaMinima());
			txtTemperaturaMinima.setDisabled(false);
			txtVelocidadMaxima.setValue(entity.getVelocidadMaxima());
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadViento.setValue(entity.getVelocidadViento());
			txtVelocidadViento.setDisabled(false);
			txtEstClimatId_EstClimat.setValue(entity.getEstClimat().getEstClimatId());
			txtEstClimatId_EstClimat.setDisabled(false);
			txtDatsClimatoId.setValue(entity.getDatsClimatoId());
			txtDatsClimatoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatClimat = (DatClimatDTO) (evt.getComponent().getAttributes().get("selectedDatClimat"));

		try {

			Long datClimatId = new Long(selectedDatClimat.getDatsClimatoId());
			entity = businessDelegatorView.getDatClimat(datClimatId);

			// txtCodigo.setValue(selectedDatClimat.getCodigo());
			// txtCodigo.setDisabled(false);
			// txtCompania.setValue(selectedDatClimat.getCompania());
			// txtCompania.setDisabled(false);
			txtDireccionViento.setValue(entity.getDireccionViento());
			txtDireccionViento.setDisabled(false);
			txtEnergiaSolar.setValue(entity.getEnergiaSolar());
			txtEnergiaSolar.setDisabled(false);
			// txtEstado.setValue(selectedDatClimat.getEstado());
			// txtEstado.setDisabled(false);
			txtEvaporacion.setValue(entity.getEvaporacion());
			txtEvaporacion.setDisabled(false);
			txtEvaporacionTranspiracion.setValue(entity.getEvaporacionTranspiracion());
			txtEvaporacionTranspiracion.setDisabled(false);
			// txtFechaCreacion.setValue(selectedDatClimat.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			txtFechaLluvia.setValue(entity.getFechaLluvia());
			txtFechaLluvia.setDisabled(false);
			// txtFechaModificacion.setValue(selectedDatClimat.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtGradosDiaCalor.setValue(entity.getGradosDiaCalor());
			txtGradosDiaCalor.setDisabled(false);
			txtGradosDiaFrio.setValue(entity.getGradosDiaFrio());
			txtGradosDiaFrio.setDisabled(false);
			txtHumedadMaxima.setValue(entity.getHumedadMaxima());
			txtHumedadMaxima.setDisabled(false);
			txtHorasLuz.setValue(entity.getHorasLuz());
			txtHorasLuz.setDisabled(false);
			txtHorasSol.setValue(entity.getHorasSol());
			txtHorasSol.setDisabled(false);
			txtHumedadExterior.setValue(entity.getHumedadExterior());
			txtHumedadExterior.setDisabled(false);
			txtHumedadInterior.setValue(entity.getHumedadInterior());
			txtHumedadInterior.setDisabled(false);
			txtHumedadMedia.setValue(entity.getHumedadMedia());
			txtHumedadMedia.setDisabled(false);
			txtHumedadMinima.setValue(entity.getHumedadMinima());
			txtHumedadMinima.setDisabled(false);
			txtInsolacion.setValue(entity.getInsolacion());
			txtInsolacion.setDisabled(false);
			txtNubosidad.setValue(entity.getNubosidad());
			txtNubosidad.setDisabled(false);
			txtPrecipitacion.setValue(entity.getPrecipitacion());
			txtPrecipitacion.setDisabled(false);
			txtPuntoRocio.setValue(entity.getPuntoRocio());
			txtPuntoRocio.setDisabled(false);
			txtRadiacionSolar.setValue(entity.getRadiacionSolar());
			txtRadiacionSolar.setDisabled(false);
			txtSensacionTermica.setValue(entity.getSensacionTermica());
			txtSensacionTermica.setDisabled(false);
			txtTemperaturaAmbiente.setValue(entity.getTemperaturaAmbiente());
			txtTemperaturaAmbiente.setDisabled(false);
			txtTemperaturaMaxima.setValue(entity.getTemperaturaMaxima());
			txtTemperaturaMaxima.setDisabled(false);
			txtTemperaturaMedia.setValue(entity.getTemperaturaMedia());
			txtTemperaturaMedia.setDisabled(false);
			txtTemperaturaMinima.setValue(entity.getTemperaturaMinima());
			txtTemperaturaMinima.setDisabled(false);
			txtVelocidadMaxima.setValue(entity.getVelocidadMaxima());
			txtVelocidadMaxima.setDisabled(false);
			txtVelocidadViento.setValue(entity.getVelocidadViento());
			txtVelocidadViento.setDisabled(false);
			txtEstClimatId_EstClimat.setValue(entity.getEstClimat().getEstClimatId());
			txtEstClimatId_EstClimat.setDisabled(false);
			txtDatsClimatoId.setValue(selectedDatClimat.getDatsClimatoId());
			txtDatsClimatoId.setDisabled(true);
			btnSave.setDisabled(false);
			setShowDialog(true);

		} catch (Exception e) {
			entity = null;
		}
		return "";

	}

	public String action_save() {
		try {
			if ((selectedDatClimat == null) && (entity == null)) {
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
			entity = new DatClimat();
			Date date = new Date();

			// Long datsClimatoId = FacesUtils.checkLong(txtDatsClimatoId);

			// entity.setCodigo(FacesUtils.checkString(txtCodigo));
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			// entity.setDatsClimatoId(datsClimatoId);
			entity.setDireccionViento(FacesUtils.checkDouble(txtDireccionViento));
			entity.setEnergiaSolar(FacesUtils.checkDouble(txtEnergiaSolar));
			String estado = "A";
			entity.setEstado(estado);
			entity.setEvaporacion(FacesUtils.checkDouble(txtEvaporacion));
			entity.setEvaporacionTranspiracion(FacesUtils.checkDouble(txtEvaporacionTranspiracion));
			// entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaLluvia(FacesUtils.checkDate(txtFechaLluvia));
			entity.setFechaModificacion(date);
			entity.setGradosDiaCalor(FacesUtils.checkDouble(txtGradosDiaCalor));
			entity.setGradosDiaFrio(FacesUtils.checkDouble(txtGradosDiaFrio));
			entity.setHumedadMaxima(FacesUtils.checkDouble(txtHumedadMaxima));
			entity.setHorasLuz(FacesUtils.checkDouble(txtHorasLuz));
			entity.setHorasSol(FacesUtils.checkDouble(txtHorasSol));
			entity.setHumedadExterior(FacesUtils.checkDouble(txtHumedadExterior));
			entity.setHumedadInterior(FacesUtils.checkDouble(txtHumedadInterior));
			entity.setHumedadMedia(FacesUtils.checkDouble(txtHumedadMedia));
			entity.setHumedadMinima(FacesUtils.checkDouble(txtHumedadMinima));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setInsolacion(FacesUtils.checkDouble(txtInsolacion));
			entity.setNubosidad(FacesUtils.checkDouble(txtNubosidad));
			entity.setObservacion(FacesUtils.checkString(txtobservacion));
			/*
			 * entity.setObservacionAnularReg(FacesUtils.checkString(
			 * txtobservacionAnularReg));
			 */
			entity.setPrecipitacion(FacesUtils.checkDouble(txtPrecipitacion));
			entity.setPuntoRocio(FacesUtils.checkDouble(txtPuntoRocio));
			entity.setRadiacionSolar(FacesUtils.checkDouble(txtRadiacionSolar));
			entity.setSensacionTermica(FacesUtils.checkDouble(txtSensacionTermica));
			entity.setTemperaturaAmbiente(FacesUtils.checkDouble(txtTemperaturaAmbiente));
			entity.setTemperaturaMaxima(FacesUtils.checkDouble(txtTemperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkDouble(txtTemperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkDouble(txtTemperaturaMinima));
			entity.setVelocidadMaxima(FacesUtils.checkDouble(txtVelocidadMaxima));
			entity.setVelocidadViento(FacesUtils.checkDouble(txtVelocidadViento));
			entity.setEstClimat((FacesUtils.checkLong(txtEstClimatId_EstClimat) != null)
					? businessDelegatorView.getEstClimat(FacesUtils.checkLong(txtEstClimatId_EstClimat)) : null);
			businessDelegatorView.saveDatClimat(entity);
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
				Long datsClimatoId = new Long(selectedDatClimat.getDatsClimatoId());
				entity = businessDelegatorView.getDatClimat(datsClimatoId);
			}

			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			entity.setDireccionViento(FacesUtils.checkDouble(txtDireccionViento));
			entity.setEnergiaSolar(FacesUtils.checkDouble(txtEnergiaSolar));
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEvaporacion(FacesUtils.checkDouble(txtEvaporacion));
			entity.setEvaporacionTranspiracion(FacesUtils.checkDouble(txtEvaporacionTranspiracion));
			// entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(entity.getFechaCreacion());
			entity.setFechaLluvia(FacesUtils.checkDate(txtFechaLluvia));
			entity.setFechaModificacion(date);
			entity.setGradosDiaCalor(FacesUtils.checkDouble(txtGradosDiaCalor));
			entity.setGradosDiaFrio(FacesUtils.checkDouble(txtGradosDiaFrio));
			entity.setHumedadMaxima(FacesUtils.checkDouble(txtHumedadMaxima));
			entity.setHorasLuz(FacesUtils.checkDouble(txtHorasLuz));
			entity.setHorasSol(FacesUtils.checkDouble(txtHorasSol));
			entity.setHumedadExterior(FacesUtils.checkDouble(txtHumedadExterior));
			entity.setHumedadInterior(FacesUtils.checkDouble(txtHumedadInterior));
			entity.setHumedadMedia(FacesUtils.checkDouble(txtHumedadMedia));
			entity.setHumedadMinima(FacesUtils.checkDouble(txtHumedadMinima));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setInsolacion(FacesUtils.checkDouble(txtInsolacion));
			entity.setNubosidad(FacesUtils.checkDouble(txtNubosidad));
			entity.setObservacion(FacesUtils.checkString(txtobservacion));
			/*
			 * entity.setObservacionAnularReg(FacesUtils.checkString(
			 * txtobservacionAnularReg));
			 */
			entity.setPrecipitacion(FacesUtils.checkDouble(txtPrecipitacion));
			entity.setPuntoRocio(FacesUtils.checkDouble(txtPuntoRocio));
			entity.setRadiacionSolar(FacesUtils.checkDouble(txtRadiacionSolar));
			entity.setSensacionTermica(FacesUtils.checkDouble(txtSensacionTermica));
			entity.setTemperaturaAmbiente(FacesUtils.checkDouble(txtTemperaturaAmbiente));
			entity.setTemperaturaMaxima(FacesUtils.checkDouble(txtTemperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkDouble(txtTemperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkDouble(txtTemperaturaMinima));
			entity.setVelocidadMaxima(FacesUtils.checkDouble(txtVelocidadMaxima));
			entity.setVelocidadViento(FacesUtils.checkDouble(txtVelocidadViento));
			entity.setEstClimat((FacesUtils.checkLong(txtEstClimatId_EstClimat) != null)
					? businessDelegatorView.getEstClimat(FacesUtils.checkLong(txtEstClimatId_EstClimat)) : null);
			businessDelegatorView.updateDatClimat(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long datsClimatoId = new Long(selectedDatClimat.getDatsClimatoId());
				entity = businessDelegatorView.getDatClimat(datsClimatoId);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtobservacionAnularReg));
			businessDelegatorView.updateDatClimat(entity);
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
		selectedDatClimat = (DatClimatDTO) (evt.getComponent().getAttributes().get("selectedDatClimat"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatClimat = (DatClimatDTO) (evt.getComponent().getAttributes().get("selectedDatClimat"));

			Long datsClimatoId = new Long(selectedDatClimat.getDatsClimatoId());
			entity = businessDelegatorView.getDatClimat(datsClimatoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datsClimatoId = FacesUtils.checkLong(txtDatsClimatoId);
			entity = businessDelegatorView.getDatClimat(datsClimatoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatClimat(entity);
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
			selectedDatClimat = (DatClimatDTO) (evt.getComponent().getAttributes().get("selectedDatClimat"));

			Long datsClimatoId = new Long(selectedDatClimat.getDatsClimatoId());
			entity = businessDelegatorView.getDatClimat(datsClimatoId);
			businessDelegatorView.deleteDatClimat(entity);
			((Map<String, Object>) data).remove(selectedDatClimat);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long datsClimatoId, Double direccionViento, Double energiaSolar,
			String estado, Double evaporacion, Double evaporacionTranspiracion, Date fechaAnulacion, Date fechaCreacion,
			Date fechaLluvia, Date fechaModificacion, Double gradosDiaCalor, Double gradosDiaFrio, Double hemedadMaxima,
			Double horasLuz, Double horasSol, Double humedadExterior, Double humedadInterior, Double humedadMedia,
			Double humedadMinima, String infoAdicional, String infoAdicional2, Double insolacion, Double nubosidad,
			String observacion, String observacionAnularReg, Double precipitacion, Double puntoRocio,
			Double radiacionSolar, Double sensacionTermica, Double temperaturaAmbiente, Double temperaturaMaxima,
			Double temperaturaMedia, Double temperaturaMinima, Double velocidadMaxima, Double velocidadViento,
			Long estClimatId_EstClimat) throws Exception {
		try {

			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setDireccionViento(FacesUtils.checkDouble(direccionViento));
			entity.setEnergiaSolar(FacesUtils.checkDouble(energiaSolar));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEvaporacion(FacesUtils.checkDouble(evaporacion));
			entity.setEvaporacionTranspiracion(FacesUtils.checkDouble(evaporacionTranspiracion));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaLluvia(FacesUtils.checkDate(fechaLluvia));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setGradosDiaCalor(FacesUtils.checkDouble(gradosDiaCalor));
			entity.setGradosDiaFrio(FacesUtils.checkDouble(gradosDiaFrio));
			entity.setHumedadMaxima(FacesUtils.checkDouble(hemedadMaxima));
			entity.setHorasLuz(FacesUtils.checkDouble(horasLuz));
			entity.setHorasSol(FacesUtils.checkDouble(horasSol));
			entity.setHumedadExterior(FacesUtils.checkDouble(humedadExterior));
			entity.setHumedadInterior(FacesUtils.checkDouble(humedadInterior));
			entity.setHumedadMedia(FacesUtils.checkDouble(humedadMedia));
			entity.setHumedadMinima(FacesUtils.checkDouble(humedadMinima));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setInsolacion(FacesUtils.checkDouble(insolacion));
			entity.setNubosidad(FacesUtils.checkDouble(nubosidad));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPrecipitacion(FacesUtils.checkDouble(precipitacion));
			entity.setPuntoRocio(FacesUtils.checkDouble(puntoRocio));
			entity.setRadiacionSolar(FacesUtils.checkDouble(radiacionSolar));
			entity.setSensacionTermica(FacesUtils.checkDouble(sensacionTermica));
			entity.setTemperaturaAmbiente(FacesUtils.checkDouble(temperaturaAmbiente));
			entity.setTemperaturaMaxima(FacesUtils.checkDouble(temperaturaMaxima));
			entity.setTemperaturaMedia(FacesUtils.checkDouble(temperaturaMedia));
			entity.setTemperaturaMinima(FacesUtils.checkDouble(temperaturaMinima));
			entity.setVelocidadMaxima(FacesUtils.checkDouble(velocidadMaxima));
			entity.setVelocidadViento(FacesUtils.checkDouble(velocidadViento));
			businessDelegatorView.updateDatClimat(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatClimatView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtDireccionViento() {
		return txtDireccionViento;
	}

	public void setTxtDireccionViento(InputText txtDireccionViento) {
		this.txtDireccionViento = txtDireccionViento;
	}

	public InputText getTxtEnergiaSolar() {
		return txtEnergiaSolar;
	}

	public void setTxtEnergiaSolar(InputText txtEnergiaSolar) {
		this.txtEnergiaSolar = txtEnergiaSolar;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEvaporacion() {
		return txtEvaporacion;
	}

	public void setTxtEvaporacion(InputText txtEvaporacion) {
		this.txtEvaporacion = txtEvaporacion;
	}

	public InputText getTxtEvaporacionTranspiracion() {
		return txtEvaporacionTranspiracion;
	}

	public void setTxtEvaporacionTranspiracion(InputText txtEvaporacionTranspiracion) {
		this.txtEvaporacionTranspiracion = txtEvaporacionTranspiracion;
	}

	public InputText getTxtGradosDiaCalor() {
		return txtGradosDiaCalor;
	}

	public void setTxtGradosDiaCalor(InputText txtGradosDiaCalor) {
		this.txtGradosDiaCalor = txtGradosDiaCalor;
	}

	public InputText getTxtGradosDiaFrio() {
		return txtGradosDiaFrio;
	}

	public void setTxtGradosDiaFrio(InputText txtGradosDiaFrio) {
		this.txtGradosDiaFrio = txtGradosDiaFrio;
	}

	public InputText gettxtHumedadMaxima() {
		return txtHumedadMaxima;
	}

	public void settxtHumedadMaxima(InputText txtHumedadMaxima) {
		this.txtHumedadMaxima = txtHumedadMaxima;
	}

	public InputText getTxtHorasLuz() {
		return txtHorasLuz;
	}

	public void setTxtHorasLuz(InputText txtHorasLuz) {
		this.txtHorasLuz = txtHorasLuz;
	}

	public InputText getTxtHorasSol() {
		return txtHorasSol;
	}

	public void setTxtHorasSol(InputText txtHorasSol) {
		this.txtHorasSol = txtHorasSol;
	}

	public InputText getTxtHumedadExterior() {
		return txtHumedadExterior;
	}

	public void setTxtHumedadExterior(InputText txtHumedadExterior) {
		this.txtHumedadExterior = txtHumedadExterior;
	}

	public InputText getTxtHumedadInterior() {
		return txtHumedadInterior;
	}

	public void setTxtHumedadInterior(InputText txtHumedadInterior) {
		this.txtHumedadInterior = txtHumedadInterior;
	}

	public InputText getTxtHumedadMedia() {
		return txtHumedadMedia;
	}

	public void setTxtHumedadMedia(InputText txtHumedadMedia) {
		this.txtHumedadMedia = txtHumedadMedia;
	}

	public InputText getTxtHumedadMinima() {
		return txtHumedadMinima;
	}

	public void setTxtHumedadMinima(InputText txtHumedadMinima) {
		this.txtHumedadMinima = txtHumedadMinima;
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

	public InputText getTxtInsolacion() {
		return txtInsolacion;
	}

	public void setTxtInsolacion(InputText txtInsolacion) {
		this.txtInsolacion = txtInsolacion;
	}

	public InputText getTxtNubosidad() {
		return txtNubosidad;
	}

	public void setTxtNubosidad(InputText txtNubosidad) {
		this.txtNubosidad = txtNubosidad;
	}

	public InputText getTxtPrecipitacion() {
		return txtPrecipitacion;
	}

	public void setTxtPrecipitacion(InputText txtPrecipitacion) {
		this.txtPrecipitacion = txtPrecipitacion;
	}

	public InputText getTxtPuntoRocio() {
		return txtPuntoRocio;
	}

	public void setTxtPuntoRocio(InputText txtPuntoRocio) {
		this.txtPuntoRocio = txtPuntoRocio;
	}

	public InputText getTxtRadiacionSolar() {
		return txtRadiacionSolar;
	}

	public void setTxtRadiacionSolar(InputText txtRadiacionSolar) {
		this.txtRadiacionSolar = txtRadiacionSolar;
	}

	public InputText getTxtSensacionTermica() {
		return txtSensacionTermica;
	}

	public void setTxtSensacionTermica(InputText txtSensacionTermica) {
		this.txtSensacionTermica = txtSensacionTermica;
	}

	public InputText getTxtTemperaturaAmbiente() {
		return txtTemperaturaAmbiente;
	}

	public void setTxtTemperaturaAmbiente(InputText txtTemperaturaAmbiente) {
		this.txtTemperaturaAmbiente = txtTemperaturaAmbiente;
	}

	public InputText getTxtTemperaturaMaxima() {
		return txtTemperaturaMaxima;
	}

	public void setTxtTemperaturaMaxima(InputText txtTemperaturaMaxima) {
		this.txtTemperaturaMaxima = txtTemperaturaMaxima;
	}

	public InputText getTxtTemperaturaMedia() {
		return txtTemperaturaMedia;
	}

	public void setTxtTemperaturaMedia(InputText txtTemperaturaMedia) {
		this.txtTemperaturaMedia = txtTemperaturaMedia;
	}

	public InputText getTxtTemperaturaMinima() {
		return txtTemperaturaMinima;
	}

	public void setTxtTemperaturaMinima(InputText txtTemperaturaMinima) {
		this.txtTemperaturaMinima = txtTemperaturaMinima;
	}

	public InputText getTxtVelocidadMaxima() {
		return txtVelocidadMaxima;
	}

	public void setTxtVelocidadMaxima(InputText txtVelocidadMaxima) {
		this.txtVelocidadMaxima = txtVelocidadMaxima;
	}

	public InputText getTxtVelocidadViento() {
		return txtVelocidadViento;
	}

	public void setTxtVelocidadViento(InputText txtVelocidadViento) {
		this.txtVelocidadViento = txtVelocidadViento;
	}

	public SelectOneMenu getTxtEstClimatId_EstClimat() {
		return txtEstClimatId_EstClimat;
	}

	public void setTxtEstClimatId_EstClimat(SelectOneMenu txtEstClimatId_EstClimat) {
		this.txtEstClimatId_EstClimat = txtEstClimatId_EstClimat;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaLluvia() {
		return txtFechaLluvia;
	}

	public void setTxtFechaLluvia(Calendar txtFechaLluvia) {
		this.txtFechaLluvia = txtFechaLluvia;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtDatsClimatoId() {
		return txtDatsClimatoId;
	}

	public void setTxtDatsClimatoId(InputText txtDatsClimatoId) {
		this.txtDatsClimatoId = txtDatsClimatoId;
	}

	public LazyDataModel<DatClimatDTO> getData() {
		try {
			if (data == null) {
				data = new LocalDataModelDTO();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<DatClimatDTO> datClimatDTO) {
		this.data = datClimatDTO;
	}

	public DatClimatDTO getSelectedDatClimat() {
		return selectedDatClimat;
	}

	public void setSelectedDatClimat(DatClimatDTO datClimat) {
		this.selectedDatClimat = datClimat;
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

	public SelectItem[] getSelectEstClima() {

		if (estClima == null || estClima.size() == 0) {

			estClima = new ArrayList<EstClimat>();

			try {

				estClima = businessDelegatorView.getEstClimat(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EstClimat> lista = businessDelegatorView.findByCriteriaInEstClimat(condicion, null, null);
				selectEstClima = new SelectItem[lista.size()];

				int i = 0;
				for (EstClimat clima : lista) {
					selectEstClima[i] = new SelectItem(clima.getEstClimatId(), clima.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEstClima;
	}

	public void setSelectEstClima(SelectItem[] selectEstClima) {
		this.selectEstClima = selectEstClima;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public InputTextarea getTxtobservacion() {
		return txtobservacion;
	}

	public void setTxtobservacion(InputTextarea txtobservacion) {
		this.txtobservacion = txtobservacion;
	}

	public InputTextarea getTxtobservacionAnularReg() {
		return txtobservacionAnularReg;
	}

	public void setTxtobservacionAnularReg(InputTextarea txtobservacionAnularReg) {
		this.txtobservacionAnularReg = txtobservacionAnularReg;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	private class LocalDataModelDTO extends LazyDataModel<DatClimatDTO> {
		private static final long serialVersionUID = 1L;
		private List<DatClimatDTO> datClimatDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<DatClimatDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				datClimatDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberClima(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return datClimatDTO;

		}

		@Override
		public DatClimatDTO getRowData(String rowKey) {
			for (DatClimatDTO datClimatDTOtmp : datClimatDTO) {
				if (datClimatDTOtmp.getDatsClimatoId().toString().equals(rowKey))
					return datClimatDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(DatClimatDTO datClimatDTOtmp) {
			return datClimatDTOtmp.getDatsClimatoId();
		}

	}

	private List<DatClimatDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageClima(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
