package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaLaboratorio;
import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.DatAnaLaboratorioDet;
import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.VariableLab;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaTiqueteSinAnalisisCalidadFrutoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO;
import co.com.arcosoft.modelo.informes.dto.ListaVariablesAnaLaboratorioDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.DriverManagerDataSourceUtils;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatAnaLabCalidadFrutoPalmaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatAnaLabCalidadFrutoPalmaView.class);
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
	// private InputText txtAnaLaboratorioId_AnaLaboratorio;
	// private InputText txtNivel2Id_Nivel2;
	// private InputText txtNivel4Id_Nivel4;
	// private InputText txtTrabId_Trabajador;
	private InputText txtDatAnaLaboratorioId;
	private InputText txtVariableDia;
	private InputText txtHora0000;
	private InputText txtHora0100;
	private InputText txtHora0200;
	private InputText txtHora0300;
	private InputText txtHora0400;
	private InputText txtHora0500;
	private InputText txtHora0600;
	private InputText txtHora0700;
	private InputText txtHora0800;
	private InputText txtHora0900;
	private InputText txtHora1000;
	private InputText txtHora1100;
	private InputText txtHora1200;
	private InputText txtHora1300;
	private InputText txtHora1400;
	private InputText txtHora1500;
	private InputText txtHora1600;
	private InputText txtHora1700;
	private InputText txtHora1800;
	private InputText txtHora1900;
	private InputText txtHora2000;
	private InputText txtHora2100;
	private InputText txtHora2200;
	private InputText txtHora2300;

	private MapModel simpleModel;
	private Marker marker;
	private Calendar txtFechaAnalisis;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaAnulacion;
	private SelectOneMenu txtHoraDigitacion;
	
	private CommandButton btnSave;
	private CommandButton btnAgregar;

	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatAnaLaboratorioDTO> data;


	private List<ListaVariablesAnaLaboratorioDTO> dataVariables;
	private DatAnaLaboratorioDTO selectedDatAnaLaboratorio;
	private DatAnaLaboratorio entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;


	private InputText txtTiquete;
	
	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;
	
	SelectItem[] selectNivel4Tiquete;
	private List<Nivel4> nivel4Tiquete;
	

	private SelectOneMenu txtAnaLaboratorioId_AnaLaboratorio;
	SelectItem[] selectTipoAnalisisLaboratorio;
	private List<AnaLaboratorio> tipoAnalisis;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtFitosanidad;
	SelectItem[] selectFitosanidad;
	private List<Fitosanidad> fitosanidad;

	private InputText txtNombreFitosanidad;

	private String txtImagenSanVeg;
	private String imagenSanVeg;
	private UploadedFile file;

	private List<DatAnaLaboratorioDetDTO> dataValor;
	private DatAnaLaboratorioDetDTO selectedValor;

	private DatAnaLaboratorioDetDTO selectedValorAnalisis;

	private int activeTapIndex = 0;

	private DatAnaLaboratorioDet entityDatAnaLaboratorioDet;

	private SelectOneMenu txtVariableLabId_VariableLab;
	SelectItem[] selectVariableLab;
	private List<VariableLab> variableLab;

	private ConsultaTiqueteSinAnalisisCalidadFrutoDTO selectedTicket;
	private List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> dataTiquetes;
	private InputTextarea txtContenidoVariable;
	public DatAnaLabCalidadFrutoPalmaView() {
		super();
	}

	public String action_new() throws ParseException {
		action_clear();
		selectedDatAnaLaboratorio = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws ParseException {
		entity = null;

		selectedDatAnaLaboratorio = null;
		PrimeFaces.current().resetInputs(":dialogDatAnaLaboratorio :frm");
	
		activeTapIndex = 0;

		if (dataValor != null) {
			dataValor = null;
		}

		
		if (txtHoraDigitacion != null) {
			
			txtHoraDigitacion.setValue("06:00");
			txtHoraDigitacion.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtTiquete != null) {
			txtTiquete.setValue(null);
			txtTiquete.setDisabled(false);
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

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
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

		if (txtAnaLaboratorioId_AnaLaboratorio != null) {
			txtAnaLaboratorioId_AnaLaboratorio.setValue(null);
			txtAnaLaboratorioId_AnaLaboratorio.setDisabled(false);
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

		if (txtVariableDia != null) {
			txtVariableDia.setValue(null);
			txtVariableDia.setDisabled(false);
		}

		if (txtVariableLabId_VariableLab != null) {
			txtVariableLabId_VariableLab.setValue(null);
			txtVariableLabId_VariableLab.setDisabled(true);
		}

		if (txtHora0000 != null) {
			txtHora0000.setValue(0);
			txtHora0000.setDisabled(false);
		}

		if (txtHora0100 != null) {
			txtHora0100.setValue(0);
			txtHora0100.setDisabled(false);
		}

		if (txtHora0200 != null) {
			txtHora0200.setValue(0);
			txtHora0200.setDisabled(false);
		}

		if (txtHora0300 != null) {
			txtHora0300.setValue(0);
			txtHora0300.setDisabled(false);
		}

		if (txtHora0400 != null) {
			txtHora0400.setValue(0);
			txtHora0400.setDisabled(false);
		}

		if (txtHora0500 != null) {
			txtHora0500.setValue(0);
			txtHora0500.setDisabled(false);
		}

		if (txtHora0600 != null) {
			txtHora0600.setValue(0);
			txtHora0600.setDisabled(false);
		}

		if (txtHora0700 != null) {
			txtHora0700.setValue(0);
			txtHora0700.setDisabled(false);
		}

		if (txtHora0800 != null) {
			txtHora0800.setValue(0);
			txtHora0800.setDisabled(false);
		}

		if (txtHora0900 != null) {
			txtHora0900.setValue(0);
			txtHora0900.setDisabled(false);
		}

		if (txtHora1000 != null) {
			txtHora1000.setValue(0);
			txtHora1000.setDisabled(false);
		}

		if (txtHora1100 != null) {
			txtHora1100.setValue(0);
			txtHora1100.setDisabled(false);
		}

		if (txtHora1200 != null) {
			txtHora1200.setValue(0);
			txtHora1200.setDisabled(false);
		}

		if (txtHora1300 != null) {
			txtHora1300.setValue(0);
			txtHora1300.setDisabled(false);
		}

		if (txtHora1400 != null) {
			txtHora1400.setValue(0);
			txtHora1400.setDisabled(false);
		}

		if (txtHora1500 != null) {
			txtHora1500.setValue(0);
			txtHora1500.setDisabled(false);
		}

		if (txtHora1600 != null) {
			txtHora1600.setValue(0);
			txtHora1600.setDisabled(false);
		}

		if (txtHora1700 != null) {
			txtHora1700.setValue(0);
			txtHora1700.setDisabled(false);
		}

		if (txtHora1800 != null) {
			txtHora1800.setValue(0);
			txtHora1800.setDisabled(false);
		}

		if (txtHora1900 != null) {
			txtHora1900.setValue(0);
			txtHora1900.setDisabled(false);
		}

		if (txtHora2000 != null) {
			txtHora2000.setValue(0);
			txtHora2000.setDisabled(false);
		}

		if (txtHora2100 != null) {
			txtHora2100.setValue(0);
			txtHora2100.setDisabled(false);
		}

		if (txtHora2200 != null) {
			txtHora2200.setValue(0);
			txtHora2200.setDisabled(false);
		}

		if (txtHora2300 != null) {
			txtHora2300.setValue(0);
			txtHora2300.setDisabled(false);
		}

		if (txtDatAnaLaboratorioId != null) {
			txtDatAnaLaboratorioId.setValue(null);
			txtDatAnaLaboratorioId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		return "";
	}

	
	public String action_DigitarAnalisis(ActionEvent evt) throws ParseException {
		selectedTicket = (ConsultaTiqueteSinAnalisisCalidadFrutoDTO) (evt.getComponent().getAttributes().get("selectedTicket"));

			Long consecutivo = selectedTicket.getConsecutivo().longValue();
			
			if (dataValor != null) {
				dataValor = null;
			}

			if (txtConsecutivo != null) {
				txtConsecutivo.setValue(null);
				txtConsecutivo.setDisabled(true);
			}
			if (txtHoraDigitacion != null) {
		
				txtHoraDigitacion.setValue("06:00");
				txtHoraDigitacion.setDisabled(true);
			}
			
			txtTiquete.setValue(consecutivo);
			txtTiquete.setDisabled(true);
			
			
			if (txtNivel4Id_Nivel4 != null) {
				txtNivel4Id_Nivel4.setValue(null);
				txtNivel4Id_Nivel4.setDisabled(false);
			}



			if (txtEstado != null) {
				txtEstado.setValue("A");
				txtEstado.setDisabled(true);
			}

			
			if (txtObservacion != null) {
				txtObservacion.setValue(null);
				txtObservacion.setDisabled(false);
			}


				txtAnaLaboratorioId_AnaLaboratorio.setValue(3L);
				txtAnaLaboratorioId_AnaLaboratorio.setDisabled(false);
			
			if (txtFechaAnalisis != null) {
				Date fecha = new Date();
				if(selectedTicket.getFechaRegistro()!=null) {
					fecha = selectedTicket.getFechaRegistro();
				}
				txtFechaAnalisis.setValue(fecha);
				txtFechaAnalisis.setDisabled(false);
			}

			
			if (txtVariableDia != null) {
				txtVariableDia.setValue(null);
				txtVariableDia.setDisabled(false);
			}

			if (txtVariableLabId_VariableLab != null) {
				txtVariableLabId_VariableLab.setValue(null);
				txtVariableLabId_VariableLab.setDisabled(true);
			}

			if (txtDatAnaLaboratorioId != null) {
				txtDatAnaLaboratorioId.setValue(null);
				txtDatAnaLaboratorioId.setDisabled(false);
			}

			if (btnSave != null) {
				btnSave.setDisabled(false);
			}

			if (btnAgregar != null) {
				btnAgregar.setDisabled(false);
			}

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}

			
			/******* sesion concerniente al detalle por producto ***/
			setShowDialog(true);
		
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

	public String action_edit(ActionEvent evt) {
		selectedDatAnaLaboratorio = (DatAnaLaboratorioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatAnaLaboratorio"));

		try {

			Long consecutivo = selectedDatAnaLaboratorio.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatAnaLaboratorio> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatAnaLaboratorio(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				
				/***************************************/
				txtTiquete.setValue(entity.getNroTicket());
				txtTiquete.setDisabled(true);
				
				txtHoraDigitacion.setValue(entity.getHoraDigitacion());
				txtHoraDigitacion.setDisabled(false);
				
				
				txtNivel2Id.setValue(entity.getNivel2Id().getNivel2Id());
				txtNivel2Id.setDisabled(false);
				
				txtNivel4Id_Nivel4.setValue(entity.getNivel4Id().getNivel4Id());
				txtNivel4Id_Nivel4.setDisabled(false);
				
				txtNivel3Id.setValue(entity.getNivel3Id());
				txtNivel3Id.setDisabled(false);
				
				txtNivel1Id.setValue(entity.getNivel1Id());
				txtNivel1Id.setDisabled(false);
				
				/***************************************/
				
				 txtFechaAnalisis.setValue(entity.getFechaAnalisis());
				txtFechaAnalisis.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtAnaLaboratorioId_AnaLaboratorio.setValue(entity.getAnaLaboratorio().getAnaLabId());
				txtAnaLaboratorioId_AnaLaboratorio.setDisabled(false);

				txtDatAnaLaboratorioId.setValue(entity.getDatAnaLabId());
				txtDatAnaLaboratorioId.setDisabled(true);

				Long tipoAnalisis = entity.getAnaLaboratorio().getAnaLabId();
				dataVariables = businessDelegatorView.consultarListaVariablesAnaLaboratorio(1L, tipoAnalisis);

				dataValor = null;
				Long idDatAnaLaboratorio = FacesUtils.checkLong(txtDatAnaLaboratorioId);
				dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idDatAnaLaboratorio);

				businessDelegatorView.updateDatAnaLaboratorio(entity, dataValor, dataVariables);

				dataValor = null;
				dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idDatAnaLaboratorio);

				// calcularFormula(dataValor);

				btnSave.setDisabled(true);
				activeTapIndex = 0;
				dataVariables = null;

				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatAnaLaboratorio == null) && (entity == null)) {
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
			
			Long compania = new Long(getCompaniaIdSession());
			Date fecha = FacesUtils.checkDate(txtFechaAnalisis);
			String hora = FacesUtils.checkString(txtHoraDigitacion);
			Long idAnalisis = FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio);
			List<ListaVariablesAnaLaboratorioDTO>	analisisExiste = null;	
			
		
			entity = new DatAnaLaboratorio();

			// Long datSanVegId = FacesUtils.checkLong(txtDatAnaLaboratorioId);
	
			Date date = new Date();

			entity.setCompania(compania);
			entity.setEstado("A");

			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoDatAnalisisLaboratorio(compania)));
			entity.setFechaAnalisis(FacesUtils.checkDate(txtFechaAnalisis));
			
			entity.setHoraDigitacion(FacesUtils.checkString(txtHoraDigitacion));
			entity.setFechaAnalisis(FacesUtils.checkDate(txtFechaAnalisis));
			
			
			entity.setFechaCreacion(date);
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setAnaLaboratorio((FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio) != null)
					? businessDelegatorView.getAnaLaboratorio(FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio))
					: null);
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel4Id((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setNroTicket(FacesUtils.checkLong(txtTiquete));

			Long tipoAnalisis = FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio);
			dataVariables = businessDelegatorView.consultarListaVariablesAnaLaboratorio(compania, tipoAnalisis);

			businessDelegatorView.saveDatAnaLaboratorio(entity, dataVariables);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVEDEIMPORTACION + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoDatAnalisisLaboratorio(compania) - 1));

			Long idDatAnaLaboratorio = businessDelegatorView.consultarIdUnicoDatAnalisisLaboratorio(compania);

			dataValor = null;
			dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idDatAnaLaboratorio);

			btnSave.setDisabled(true);
		
			// action_clear2();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long idDatAnaLaboratorio = new Long(selectedDatAnaLaboratorio.getDatAnaLabId());
				entity = businessDelegatorView.getDatAnaLaboratorio(idDatAnaLaboratorio);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setEstado("A");
			entity.setCompania(compania);


			entity.setHoraDigitacion(FacesUtils.checkString(txtHoraDigitacion));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			// entity.setFechaAnalisis(FacesUtils.checkDate(txtFechaAnalisis));
			entity.setFechaModificacion(date);
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setAnaLaboratorio((FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio) != null)
					? businessDelegatorView.getAnaLaboratorio(FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio))
					: null);
			entity.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id)) : null);
			entity.setNivel4Id((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4)) : null);
			entity.setNivel1Id(FacesUtils.checkLong(txtNivel1Id));
			entity.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entity.setNroTicket(FacesUtils.checkLong(txtTiquete));
			
			businessDelegatorView.updateDatAnaLaboratorio(entity, dataValor, null);
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
			selectedDatAnaLaboratorio = (DatAnaLaboratorioDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAnaLaboratorio"));

			Long id = new Long(selectedDatAnaLaboratorio.getDatAnaLabId());
			entity = businessDelegatorView.getDatAnaLaboratorio(id);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datSanVegId = FacesUtils.checkLong(txtDatAnaLaboratorioId);
			entity = businessDelegatorView.getDatAnaLaboratorio(datSanVegId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatAnaLaboratorio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws ParseException {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatAnaLaboratorio = (DatAnaLaboratorioDTO) (evt.getComponent().getAttributes()
					.get("selectedDatAnaLaboratorio"));

			Long id = new Long(selectedDatAnaLaboratorio.getDatAnaLabId());
			entity = businessDelegatorView.getDatAnaLaboratorio(id);
			businessDelegatorView.deleteDatAnaLaboratorio(entity);
			data.remove(selectedDatAnaLaboratorio);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
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

	public SelectOneMenu getTxtAnaLaboratorioId_AnaLaboratorio() {
		return txtAnaLaboratorioId_AnaLaboratorio;
	}

	public void setTxtAnaLaboratorioId_AnaLaboratorio(SelectOneMenu txtAnaLaboratorioId_AnaLaboratorio) {
		this.txtAnaLaboratorioId_AnaLaboratorio = txtAnaLaboratorioId_AnaLaboratorio;
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

	public InputText getTxtDatAnaLaboratorioId() {
		return txtDatAnaLaboratorioId;
	}

	public void setTxtDatAnaLaboratorioId(InputText txtDatAnaLaboratorioId) {
		this.txtDatAnaLaboratorioId = txtDatAnaLaboratorioId;
	}

	public SelectItem[] getSelectTipoAnalisisLaboratorio() {

		if (tipoAnalisis == null || tipoAnalisis.size() == 0) {

			tipoAnalisis = new ArrayList<AnaLaboratorio>();

			try {

				tipoAnalisis = businessDelegatorView.getAnaLaboratorio(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<AnaLaboratorio> lista = businessDelegatorView.findByCriteriaInAnaLaboratorio(condicion, null,
						null);
				selectTipoAnalisisLaboratorio = new SelectItem[lista.size()];

				int i = 0;
				for (AnaLaboratorio tipoAnalisis : lista) {
					selectTipoAnalisisLaboratorio[i] = new SelectItem(tipoAnalisis.getAnaLabId(),
							tipoAnalisis.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoAnalisisLaboratorio;
	}

	public void setSelectTipoAnalisisLaboratorio(SelectItem[] selectTipoAnalisisLaboratorio) {
		this.selectTipoAnalisisLaboratorio = selectTipoAnalisisLaboratorio;
	}

	public List<DatAnaLaboratorioDTO> getData() {
		try {
			if (data == null) {

				data = businessDelegatorView.getDataDatAnaLaboratorioByTipoAnalisis(3L);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatAnaLaboratorioDTO> datSanVegDTO) {
		this.data = datSanVegDTO;
	}

	public DatAnaLaboratorioDTO getSelectedDatAnaLaboratorio() {
		return selectedDatAnaLaboratorio;
	}

	public void setSelectedDatAnaLaboratorio(DatAnaLaboratorioDTO datSanVeg) {
		this.selectedDatAnaLaboratorio = datSanVeg;
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
				Long id = new Long(selectedDatAnaLaboratorio.getDatAnaLabId());
				entity = businessDelegatorView.getDatAnaLaboratorio(id);
			}

			Date date = new Date();
			// entity.set(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			Long id = FacesUtils.checkLong(txtDatAnaLaboratorioId);

			dataValor = null;
			dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(id);

			businessDelegatorView.updateDatAnaLaboratorio(entity, dataValor, null);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) throws ParseException {

		action_clear();
		selectedDatAnaLaboratorio = (DatAnaLaboratorioDTO) (evt.getComponent().getAttributes()
				.get("selectedDatAnaLaboratorio"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public List<DatAnaLaboratorioDetDTO> getDatAnaLaboratorioDet1() {

		if (dataValor == null || dataValor.size() == 0) {
			return null;
		} else {
			return dataValor;
		}

	}

	public void action_agregarValores() throws Exception {

		Long variableAnalisis = Long.parseLong(txtVariableLabId_VariableLab.getValue().toString());
		VariableLab variableLab = businessDelegatorView.getVariableLab(variableAnalisis);

		String codigoVariable = variableLab.getCodigo().toString();
		Double variableDia = FacesUtils.checkDouble(txtVariableDia);
		Double hora0000 = FacesUtils.checkDouble(txtHora0000);
		Double hora0100 = FacesUtils.checkDouble(txtHora0100);
		Double hora0200 = FacesUtils.checkDouble(txtHora0200);
		Double hora0300 = FacesUtils.checkDouble(txtHora0300);
		Double hora0400 = FacesUtils.checkDouble(txtHora0400);
		Double hora0500 = FacesUtils.checkDouble(txtHora0500);
		Double hora0600 = FacesUtils.checkDouble(txtHora0600);
		Double hora0700 = FacesUtils.checkDouble(txtHora0700);
		Double hora0800 = FacesUtils.checkDouble(txtHora0800);
		Double hora0900 = FacesUtils.checkDouble(txtHora0900);
		Double hora1000 = FacesUtils.checkDouble(txtHora1000);
		Double hora1100 = FacesUtils.checkDouble(txtHora1100);
		Double hora1200 = FacesUtils.checkDouble(txtHora1200);
		Double hora1300 = FacesUtils.checkDouble(txtHora1300);
		Double hora1400 = FacesUtils.checkDouble(txtHora1400);
		Double hora1500 = FacesUtils.checkDouble(txtHora1500);
		Double hora1600 = FacesUtils.checkDouble(txtHora1600);
		Double hora1700 = FacesUtils.checkDouble(txtHora1700);
		Double hora1800 = FacesUtils.checkDouble(txtHora1800);
		Double hora1900 = FacesUtils.checkDouble(txtHora1900);
		Double hora2000 = FacesUtils.checkDouble(txtHora2000);
		Double hora2100 = FacesUtils.checkDouble(txtHora2100);
		Double hora2200 = FacesUtils.checkDouble(txtHora2200);
		Double hora2300 = FacesUtils.checkDouble(txtHora2300);

		boolean existeProducto = false;

		if (dataValor == null) {
			dataValor = new ArrayList<DatAnaLaboratorioDetDTO>();

		}

		if (dataValor.size() > 0) {

			for (DatAnaLaboratorioDetDTO d : dataValor) {

				if (d.getVariableLabId_VariableLab().getVariableLabId() == variableAnalisis.longValue()) {

					existeProducto = true;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
									"La variable de análisis:  "
											+ d.getVariableLabId_VariableLab().getCodigo().toString()
											+ " ya fue agregada a la lista, por favor seleccione otra. "));

					break;
				}
			}

		}

		if (existeProducto == false) {

			DatAnaLaboratorioDetDTO valorVar2 = new DatAnaLaboratorioDetDTO();
			valorVar2.setVariableLabId_VariableLab(variableLab);
			valorVar2.setCodigoVariable(codigoVariable);

			valorVar2.setValorVariable(variableDia);
			valorVar2.setHora0000(hora0000);
			valorVar2.setHora0100(hora0100);
			valorVar2.setHora0200(hora0200);
			valorVar2.setHora0300(hora0300);
			valorVar2.setHora0400(hora0400);
			valorVar2.setHora0500(hora0500);
			valorVar2.setHora0600(hora0600);
			valorVar2.setHora0700(hora0700);
			valorVar2.setHora0800(hora0800);
			valorVar2.setHora0900(hora0900);
			valorVar2.setHora1000(hora1000);
			valorVar2.setHora1100(hora1100);
			valorVar2.setHora1200(hora1200);
			valorVar2.setHora1300(hora1300);
			valorVar2.setHora1400(hora1400);
			valorVar2.setHora1500(hora1500);
			valorVar2.setHora1600(hora1600);
			valorVar2.setHora1700(hora1700);
			valorVar2.setHora1800(hora1800);
			valorVar2.setHora1900(hora1900);
			valorVar2.setHora2000(hora2000);
			valorVar2.setHora2100(hora2100);
			valorVar2.setHora2200(hora2200);
			valorVar2.setHora2300(hora2300);

			dataValor.add(valorVar2);

		}

		dataValor = null;
		codigoVariable = null;
		variableLab = null;
		variableAnalisis = null;
		variableDia = null;
		hora0000 = null;
		hora0100 = null;
		hora0200 = null;
		hora0300 = null;
		hora0400 = null;
		hora0500 = null;
		hora0600 = null;
		hora0700 = null;
		hora0800 = null;
		hora0900 = null;
		hora1000 = null;
		hora1100 = null;
		hora1200 = null;
		hora1300 = null;
		hora1400 = null;
		hora1500 = null;
		hora1600 = null;
		hora1700 = null;
		hora1800 = null;
		hora1900 = null;
		hora2000 = null;
		hora2100 = null;
		hora2200 = null;
		hora2300 = null;

	}

	public String actionDeleteDatAnaLaboratorioDet(ActionEvent evt) {
		try {

			selectedValor = (DatAnaLaboratorioDetDTO) (evt.getComponent().getAttributes().get("selectedValor"));

			if (selectedValor.getDatAnaLaboratorioDetId() == null) {
				dataValor.remove(selectedValor);
			} else {
				Long valorVarId = new Long(selectedValor.getDatAnaLaboratorioDetId());
				DatAnaLaboratorioDet entity = businessDelegatorView.getDatAnaLaboratorioDet(valorVarId);
				businessDelegatorView.deleteDatAnaLaboratorioDet(entity);
				dataValor.remove(selectedValor);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<DatAnaLaboratorioDetDTO> getDataValor() {
		return dataValor;
	}

	public void setDataValor(List<DatAnaLaboratorioDetDTO> dataValor) {
		this.dataValor = dataValor;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public List<ListaVariablesAnaLaboratorioDTO> getDataVariables() {
		try {
			// Long compania = 1L;

			Long compania = new Long(getCompaniaIdSession());
			Long tipoAnalisisId = FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio);
			if (compania != null) {

				dataVariables = businessDelegatorView.consultarListaVariablesAnaLaboratorio(compania, tipoAnalisisId);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataVariables;
	}

	/**
	 * @param dataVariables
	 *            the dataVariables to set
	 */
	public void setDataVariables(List<ListaVariablesAnaLaboratorioDTO> dataVariables) {
		this.dataVariables = dataVariables;
	}

	/**
	 * @return the txtVariableDia
	 */
	public InputText getTxtVariableDia() {
		return txtVariableDia;
	}

	/**
	 * @param txtVariableDia
	 *            the txtVariableDia to set
	 */
	public void setTxtVariableDia(InputText txtVariableDia) {
		this.txtVariableDia = txtVariableDia;
	}

	/**
	 * @return the txtHora0000
	 */
	public InputText getTxtHora0000() {
		return txtHora0000;
	}

	/**
	 * @param txtHora0000
	 *            the txtHora0000 to set
	 */
	public void setTxtHora0000(InputText txtHora0000) {
		this.txtHora0000 = txtHora0000;
	}

	/**
	 * @return the txtHora0100
	 */
	public InputText getTxtHora0100() {
		return txtHora0100;
	}

	/**
	 * @param txtHora0100
	 *            the txtHora0100 to set
	 */
	public void setTxtHora0100(InputText txtHora0100) {
		this.txtHora0100 = txtHora0100;
	}

	/**
	 * @return the txtHora0200
	 */
	public InputText getTxtHora0200() {
		return txtHora0200;
	}

	/**
	 * @param txtHora0200
	 *            the txtHora0200 to set
	 */
	public void setTxtHora0200(InputText txtHora0200) {
		this.txtHora0200 = txtHora0200;
	}

	/**
	 * @return the txtHora0300
	 */
	public InputText getTxtHora0300() {
		return txtHora0300;
	}

	/**
	 * @param txtHora0300
	 *            the txtHora0300 to set
	 */
	public void setTxtHora0300(InputText txtHora0300) {
		this.txtHora0300 = txtHora0300;
	}

	/**
	 * @return the txtHora0400
	 */
	public InputText getTxtHora0400() {
		return txtHora0400;
	}

	/**
	 * @param txtHora0400
	 *            the txtHora0400 to set
	 */
	public void setTxtHora0400(InputText txtHora0400) {
		this.txtHora0400 = txtHora0400;
	}

	/**
	 * @return the txtHora0500
	 */
	public InputText getTxtHora0500() {
		return txtHora0500;
	}

	/**
	 * @param txtHora0500
	 *            the txtHora0500 to set
	 */
	public void setTxtHora0500(InputText txtHora0500) {
		this.txtHora0500 = txtHora0500;
	}

	/**
	 * @return the txtHora0600
	 */
	public InputText getTxtHora0600() {
		return txtHora0600;
	}

	/**
	 * @param txtHora0600
	 *            the txtHora0600 to set
	 */
	public void setTxtHora0600(InputText txtHora0600) {
		this.txtHora0600 = txtHora0600;
	}

	/**
	 * @return the txtHora0700
	 */
	public InputText getTxtHora0700() {
		return txtHora0700;
	}

	/**
	 * @param txtHora0700
	 *            the txtHora0700 to set
	 */
	public void setTxtHora0700(InputText txtHora0700) {
		this.txtHora0700 = txtHora0700;
	}

	/**
	 * @return the txtHora0800
	 */
	public InputText getTxtHora0800() {
		return txtHora0800;
	}

	/**
	 * @param txtHora0800
	 *            the txtHora0800 to set
	 */
	public void setTxtHora0800(InputText txtHora0800) {
		this.txtHora0800 = txtHora0800;
	}

	/**
	 * @return the txtHora0900
	 */
	public InputText getTxtHora0900() {
		return txtHora0900;
	}

	/**
	 * @param txtHora0900
	 *            the txtHora0900 to set
	 */
	public void setTxtHora0900(InputText txtHora0900) {
		this.txtHora0900 = txtHora0900;
	}

	/**
	 * @return the txtHora1000
	 */
	public InputText getTxtHora1000() {
		return txtHora1000;
	}

	/**
	 * @param txtHora1000
	 *            the txtHora1000 to set
	 */
	public void setTxtHora1000(InputText txtHora1000) {
		this.txtHora1000 = txtHora1000;
	}

	/**
	 * @return the txtHora1100
	 */
	public InputText getTxtHora1100() {
		return txtHora1100;
	}

	/**
	 * @param txtHora1100
	 *            the txtHora1100 to set
	 */
	public void setTxtHora1100(InputText txtHora1100) {
		this.txtHora1100 = txtHora1100;
	}

	/**
	 * @return the txtHora1200
	 */
	public InputText getTxtHora1200() {
		return txtHora1200;
	}

	/**
	 * @param txtHora1200
	 *            the txtHora1200 to set
	 */
	public void setTxtHora1200(InputText txtHora1200) {
		this.txtHora1200 = txtHora1200;
	}

	/**
	 * @return the txtHora1300
	 */
	public InputText getTxtHora1300() {
		return txtHora1300;
	}

	/**
	 * @param txtHora1300
	 *            the txtHora1300 to set
	 */
	public void setTxtHora1300(InputText txtHora1300) {
		this.txtHora1300 = txtHora1300;
	}

	/**
	 * @return the txtHora1400
	 */
	public InputText getTxtHora1400() {
		return txtHora1400;
	}

	/**
	 * @param txtHora1400
	 *            the txtHora1400 to set
	 */
	public void setTxtHora1400(InputText txtHora1400) {
		this.txtHora1400 = txtHora1400;
	}

	/**
	 * @return the txtHora1500
	 */
	public InputText getTxtHora1500() {
		return txtHora1500;
	}

	/**
	 * @param txtHora1500
	 *            the txtHora1500 to set
	 */
	public void setTxtHora1500(InputText txtHora1500) {
		this.txtHora1500 = txtHora1500;
	}

	/**
	 * @return the txtHora1600
	 */
	public InputText getTxtHora1600() {
		return txtHora1600;
	}

	/**
	 * @param txtHora1600
	 *            the txtHora1600 to set
	 */
	public void setTxtHora1600(InputText txtHora1600) {
		this.txtHora1600 = txtHora1600;
	}

	/**
	 * @return the txtHora1700
	 */
	public InputText getTxtHora1700() {
		return txtHora1700;
	}

	/**
	 * @param txtHora1700
	 *            the txtHora1700 to set
	 */
	public void setTxtHora1700(InputText txtHora1700) {
		this.txtHora1700 = txtHora1700;
	}

	/**
	 * @return the txtHora1800
	 */
	public InputText getTxtHora1800() {
		return txtHora1800;
	}

	/**
	 * @param txtHora1800
	 *            the txtHora1800 to set
	 */
	public void setTxtHora1800(InputText txtHora1800) {
		this.txtHora1800 = txtHora1800;
	}

	/**
	 * @return the txtHora1900
	 */
	public InputText getTxtHora1900() {
		return txtHora1900;
	}

	/**
	 * @param txtHora1900
	 *            the txtHora1900 to set
	 */
	public void setTxtHora1900(InputText txtHora1900) {
		this.txtHora1900 = txtHora1900;
	}

	/**
	 * @return the txtHora2000
	 */
	public InputText getTxtHora2000() {
		return txtHora2000;
	}

	/**
	 * @param txtHora2000
	 *            the txtHora2000 to set
	 */
	public void setTxtHora2000(InputText txtHora2000) {
		this.txtHora2000 = txtHora2000;
	}

	/**
	 * @return the txtHora2100
	 */
	public InputText getTxtHora2100() {
		return txtHora2100;
	}

	/**
	 * @param txtHora2100
	 *            the txtHora2100 to set
	 */
	public void setTxtHora2100(InputText txtHora2100) {
		this.txtHora2100 = txtHora2100;
	}

	/**
	 * @return the txtHora2200
	 */
	public InputText getTxtHora2200() {
		return txtHora2200;
	}

	/**
	 * @param txtHora2200
	 *            the txtHora2200 to set
	 */
	public void setTxtHora2200(InputText txtHora2200) {
		this.txtHora2200 = txtHora2200;
	}

	/**
	 * @return the txtHora2300
	 */
	public InputText getTxtHora2300() {
		return txtHora2300;
	}

	/**
	 * @param txtHora2300
	 *            the txtHora2300 to set
	 */
	public void setTxtHora2300(InputText txtHora2300) {
		this.txtHora2300 = txtHora2300;
	}

	/**
	 * @return the entity
	 */
	public DatAnaLaboratorio getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(DatAnaLaboratorio entity) {
		this.entity = entity;
	}

	/**
	 * @return the entityDatAnaLaboratorioDet
	 */
	public DatAnaLaboratorioDet getEntityDatAnaLaboratorioDet() {
		return entityDatAnaLaboratorioDet;
	}

	/**
	 * @param entityDatAnaLaboratorioDet
	 *            the entityDatAnaLaboratorioDet to set
	 */
	public void setEntityDatAnaLaboratorioDet(DatAnaLaboratorioDet entityDatAnaLaboratorioDet) {
		this.entityDatAnaLaboratorioDet = entityDatAnaLaboratorioDet;
	}

	/**
	 * @return the txtVariableLabId_VariableLab
	 */
	public SelectOneMenu getTxtVariableLabId_VariableLab() {
		return txtVariableLabId_VariableLab;
	}

	/**
	 * @param txtVariableLabId_VariableLab
	 *            the txtVariableLabId_VariableLab to set
	 */
	public void setTxtVariableLabId_VariableLab(SelectOneMenu txtVariableLabId_VariableLab) {
		this.txtVariableLabId_VariableLab = txtVariableLabId_VariableLab;
	}

	/**
	 * @return the selectedValor
	 */
	public DatAnaLaboratorioDetDTO getSelectedValor() {
		return selectedValor;
	}

	/**
	 * @param selectedValor
	 *            the selectedValor to set
	 */
	public void setSelectedValor(DatAnaLaboratorioDetDTO selectedValor) {
		this.selectedValor = selectedValor;
	}

	/**
	 * @return the selectedValorAnalisis
	 */
	public DatAnaLaboratorioDetDTO getSelectedValorAnalisis() {
		return selectedValorAnalisis;
	}

	/**
	 * @param selectedValorAnalisis
	 *            the selectedValorAnalisis to set
	 */
	public void setSelectedValorAnalisis(DatAnaLaboratorioDetDTO selectedValorAnalisis) {
		this.selectedValorAnalisis = selectedValorAnalisis;
	}

	/**
	 * @return the selectedValorAnalisis
	 */
	

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

	/**
	 * @return the txtFoto
	 */
	public InputText getTxtFoto() {
		return txtFoto;
	}

	/**
	 * @param txtFoto the txtFoto to set
	 */
	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
	}

	/**
	 * @return the txtNivel2Id
	 */
	public SelectOneMenu getTxtNivel2Id() {
		return txtNivel2Id;
	}

	/**
	 * @param txtNivel2Id the txtNivel2Id to set
	 */
	public void setTxtNivel2Id(SelectOneMenu txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	/**
	 * @return the txtFitosanidad
	 */
	public SelectOneMenu getTxtFitosanidad() {
		return txtFitosanidad;
	}

	/**
	 * @param txtFitosanidad the txtFitosanidad to set
	 */
	public void setTxtFitosanidad(SelectOneMenu txtFitosanidad) {
		this.txtFitosanidad = txtFitosanidad;
	}

	/**
	 * @return the txtNombreFitosanidad
	 */
	public InputText getTxtNombreFitosanidad() {
		return txtNombreFitosanidad;
	}

	/**
	 * @param txtNombreFitosanidad the txtNombreFitosanidad to set
	 */
	public void setTxtNombreFitosanidad(InputText txtNombreFitosanidad) {
		this.txtNombreFitosanidad = txtNombreFitosanidad;
	}

	/**
	 * @return the txtTiquete
	 */
	public InputText getTxtTiquete() {
		return txtTiquete;
	}

	/**
	 * @param txtTiquete the txtTiquete to set
	 */
	public void setTxtTiquete(InputText txtTiquete) {
		this.txtTiquete = txtTiquete;
	}

	  
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> getDataTiquetes() {
		try {
			// Long compania = 1L;

			Long compania = new Long(getCompaniaIdSession());

			if (compania != null) {

				dataTiquetes = businessDelegatorView.consultarTiqueteSinAnalisisCalidadFruto(compania);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataTiquetes;
	}

	/**
	 * @param dataTiquetes the dataTiquetes to set
	 */
	public void setDataTiquetes(List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> dataTiquetes) {
		this.dataTiquetes = dataTiquetes;
	}

	
	
	public SelectItem[] getSelectNivel4Tiquete() {

		if (nivel4Tiquete == null || nivel4Tiquete.size() == 0) {
			try {
				Long consecutivo = 0L;
				Long idCompania = new Long(getCompaniaIdSession());
				if(txtTiquete.getValue() !=null){
					 consecutivo = selectedTicket.getConsecutivo().longValue();
					
				// Criteria
				List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> listaOrdenenTrabajo = businessDelegatorView
						.consultarTiqueteSinAnalisisCalidadDetalle(idCompania, consecutivo);
				selectNivel4Tiquete = new SelectItem[listaOrdenenTrabajo.size()];
				int i = 0;
				for (ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO consultaTiqueteSinAnalisisCalidadFrutoDetalleDTOs : listaOrdenenTrabajo) {
					selectNivel4Tiquete[i] = new SelectItem(consultaTiqueteSinAnalisisCalidadFrutoDetalleDTOs.getNivel4Id(),
							consultaTiqueteSinAnalisisCalidadFrutoDetalleDTOs.getLote()

					);
					i++;

				}
			}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4Tiquete;
	}

	public void setSelectNivel4Tiquete(SelectItem[] selectNivel4Tiquete) {
		this.selectNivel4Tiquete = selectNivel4Tiquete;
	}

	/**
	 * @return the txtHoraDigitacion
	 */
	public SelectOneMenu getTxtHoraDigitacion() {
		return txtHoraDigitacion;
	}

	/**
	 * @param txtHoraDigitacion the txtHoraDigitacion to set
	 */
	public void setTxtHoraDigitacion(SelectOneMenu txtHoraDigitacion) {
		this.txtHoraDigitacion = txtHoraDigitacion;
	}

	

	public void calcularFormula(List<DatAnaLaboratorioDetDTO> valordata) throws Exception {

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine interprete = manager.getEngineByName("js");

		Bindings scope = interprete.createBindings();
		// dataValor = null;
		// Long idDatAnaLaboratorio = datAnaLaboratorioId;
		// dataValor =
		// businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idDatAnaLaboratorio);

		ArrayList<String> formulasList = null;
		formulasList = new ArrayList<String>();

		int tamano = valordata.size();

		String valores[][] = new String[tamano][24];

		/*
		 * for (int i = 0; i < tamano; i++) {
		 * 
		 * for(int j = 0; i < 24; i++ ) {
		 * 
		 * String[i][j] valores =
		 * 
		 * }
		 * 
		 * }
		 */

		int i = 0;

		for (DatAnaLaboratorioDetDTO valor : valordata) {

			VariableLab vlab = businessDelegatorView
					.getVariableLab(valor.getVariableLabId_VariableLab().getVariableLabId());

			if (!vlab.getTipoVariable().equals("Formula")) {

				/*
				 * for(int j = 0; i < 24; i++ ) {
				 * 
				 * valores[i][j] = valor.getHora0100().toString();
				 * 
				 * }
				 */

				// scope.put(valor.getCodigoVariable(), valor.getHora0100());
				/*
				 * scope.put(valor.getCodigoVariable(), valor.getHora0200());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0300());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0400());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0500());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0600());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0700());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0800());
				 * scope.put(valor.getCodigoVariable(), valor.getHora0900());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1000());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1100());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1200());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1300());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1400());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1500());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1600());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1700());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1800());
				 * scope.put(valor.getCodigoVariable(), valor.getHora1900());
				 * scope.put(valor.getCodigoVariable(), valor.getHora2000());
				 * scope.put(valor.getCodigoVariable(), valor.getHora2100());
				 * scope.put(valor.getCodigoVariable(), valor.getHora2200());
				 * scope.put(valor.getCodigoVariable(), valor.getHora2300());
				 */

				/*
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0100());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0200());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0300());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0400());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0500());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0600());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0700());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0800());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora0900());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1000());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1100());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1200());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1300());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1400());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1500());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1600());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1700());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1800());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora1900());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora2000());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora2100());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora2200());
				 * interprete.put(valor.getCodigoVariable(), valor.getHora2300());
				 */
			}

			if (vlab.getTipoVariable().equals("Formula")) {

				formulasList.add(vlab.getFormula());
			}

			// i++;

		}

		// recorrer el array para calcular las formulas

		Iterator<String> it = formulasList.iterator();
		while (it.hasNext())
			interprete.eval(it.next(), scope);
		System.out.println(it.next());

	}


	public void onCellEditEventos(CellEditEvent evt) throws Exception {
		Long datAnaLaboratorioId = FacesUtils.checkLong(txtDatAnaLaboratorioId);
		if(datAnaLaboratorioId !=null) {
		selectedValorAnalisis = (DatAnaLaboratorioDetDTO) (evt.getComponent().getAttributes()
				.get("selectedValorAnalisis"));

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine interprete = manager.getEngineByName("js");
		Bindings scope = interprete.createBindings();

		Long valorVarId = selectedValorAnalisis.getDatAnaLaboratorioDetId().longValue();
		Long variable = selectedValorAnalisis.getVariableLabId_VariableLab().getVariableLabId().longValue();

		VariableLab vlab = businessDelegatorView.getVariableLab(variable);
		String tipoVariable = vlab.getTipoVariable();

		String columnaCell = evt.getColumn().getHeaderText();
		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityDatAnaLaboratorioDet = null;
			entityDatAnaLaboratorioDet = businessDelegatorView.getDatAnaLaboratorioDet(valorVarId);

			if (tipoVariable.equals("Digitada")) {

					if (columnaCell.equals("Valor")) {
						entityDatAnaLaboratorioDet.setValorVariable(Double.valueOf(evt.getNewValue().toString()));
					} 
				
				businessDelegatorView.updateDatAnaLaboratorioDet(entityDatAnaLaboratorioDet);

				entityDatAnaLaboratorioDet = null;
				selectedValorAnalisis = null;

				dataValor = null;
				dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(datAnaLaboratorioId);
			} 
		
		}
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));

		}
	}

	public String actionCalcularVariable(ActionEvent evt) {
		selectedValorAnalisis = (DatAnaLaboratorioDetDTO) (evt.getComponent().getAttributes()
				.get("selectedValorAnalisis"));

		try {
			
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine interprete = manager.getEngineByName("js");
			Bindings scope = interprete.createBindings();
			
			Long valorVarId = selectedValorAnalisis.getDatAnaLaboratorioDetId().longValue();
			Long variable = selectedValorAnalisis.getVariableLabId_VariableLab().getVariableLabId().longValue();
			Long idDatAnalisis = selectedValorAnalisis.getDatAnaLabId_DatAnaLaboratorio();
			
			VariableLab vlab = businessDelegatorView.getVariableLab(variable);
			String tipoVariable = vlab.getTipoVariable();
			
			//entityDatAnaLaboratorioDet = new DatAnaLaboratorioDet();
			entityDatAnaLaboratorioDet = businessDelegatorView.getDatAnaLaboratorioDet(valorVarId);
			
			if (tipoVariable.equals("Consulta_Sql")) {
				
			Date fecha = FacesUtils.checkDate(txtFechaAnalisis);
			Long idanalisis =  FacesUtils.checkLong(txtAnaLaboratorioId_AnaLaboratorio);
			Long idTransaccionLaboratorio = idDatAnalisis;
			
						String consulta = vlab.getConsultaSql();
						Double valorResultado  = 0.0;
						 String result = null;
						
						// La clase Spring con la Connection
						//JdbcTemplate jdbcTemplate = new JdbcTemplate(DriverManagerDataSourceUtils.getDatasource());
						namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DriverManagerDataSourceUtils.getDatasource());
						
						MapSqlParameterSource parameters = new MapSqlParameterSource();
					      parameters.addValue("fecha", fecha);
					      parameters.addValue("idanalisis", idanalisis);
					      parameters.addValue("idTransaccionLaboratorio", idTransaccionLaboratorio);
					      
					     // String result = new ArrayList<String>();
					      
					      ResultSetExtractor<String> extr = new ResultSetExtractor<String>() {

								@Override
								public String extractData(ResultSet rs) throws SQLException, DataAccessException {
									if (rs.next()) {
										return rs.getString(1);
									}
									return null;
								}

							};
							
							//r = jdbcTemplate.query(sql, paramMap, extr);
					     
					       
							result = namedParameterJdbcTemplate.query(consulta, parameters,extr);
					      
					    	 
					      

					       valorResultado =Double.parseDouble(result);
						//String lista = jdbcTemplate.queryForObject(consulta, namedParameters, String.class);
					
						
						
						
						// valorResultado = businessDelegatorView.consultaSql(consulta);
						
						entityDatAnaLaboratorioDet.setValorVariable(valorResultado);
				
				
				businessDelegatorView.updateDatAnaLaboratorioDet(entityDatAnaLaboratorioDet);

				
				Long compania = new Long(getCompaniaIdSession());
				Long idAnalisis = selectedValorAnalisis.getDatAnaLabId_DatAnaLaboratorio();
				

				entityDatAnaLaboratorioDet = null;
				selectedValorAnalisis = null;
				dataValor = null;
				dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idAnalisis);
			}

			
			if (tipoVariable.equals("Formula")) {

				boolean ejecutaFormula = false;

			/*	FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, 
								"La variable " + vlab.getCodigo() + " es formulada " + vlab.getFormula().toString()
										+ " con periodicidad " + vlab.getPeriocidadVariable(), ""));
			 */
				String formula = vlab.getFormula().toString();
				
				Long idAnalisis = selectedValorAnalisis.getDatAnaLabId_DatAnaLaboratorio();
				
				List<DatAnaLaboratorioDetDTO>  dataValorF = null;
				dataValorF = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idAnalisis);

				String[] variablesEncontradas = new String[dataValorF.size()];

				StringTokenizer st = new StringTokenizer(formula, " 0123456789()+-/* ");

				int i = 0;
				while (st.hasMoreTokens()) {
					variablesEncontradas[i] = st.nextToken();
					i++;
				}

				String columnaSeleccionada = "";

				List<DatAnaLaboratorioDet> lista = null;
				List<VariableLab> listaVar = null;

				for (int j = 0; j < variablesEncontradas.length; j++) {

					if (variablesEncontradas[j] != null) {

						Object[] condicionVar = { "codigo", true, variablesEncontradas[j].trim(), "=" };
						listaVar = businessDelegatorView.findByCriteriaInVariableLab(condicionVar, null, null);

						if (listaVar != null && listaVar.size() > 0) {

							Object[] condicionDet = { "variableLab", true,
									listaVar.get(0).getVariableLabId().longValue(), "=", "datAnaLaboratorio.datAnaLabId", true, idAnalisis,"=" };
							lista = businessDelegatorView.findByCriteriaInDatAnaLaboratorioDet(condicionDet, null,
									null);

							if (lista != null && lista.size() > 0) {

										ejecutaFormula = true;

										// entityDatAnaLaboratorioDet.setValorVariable(Double.valueOf(evt.getNewValue().toString()));
										scope.put(variablesEncontradas[j].trim(), lista.get(0).getValorVariable());
										columnaSeleccionada = "valorVariable";
						
							}

						}

					}

				}

				if (ejecutaFormula) {

					String resultado = "" + interprete.eval(formula, scope);
					String resultadoFormula ="0";
					if(resultado.trim().length()>12) {
						 resultadoFormula = resultado.trim().substring(0, 12);
					}else{
						resultadoFormula= resultado.trim();
					}
					Double valorFinal = Double.parseDouble(resultadoFormula);
					// calcular formula y grabar en la posición seleccionada
					double redondeado = new BigDecimal(valorFinal)
                            .setScale(3, RoundingMode.HALF_EVEN).doubleValue();
					
					entityDatAnaLaboratorioDet.setValorVariable(redondeado);
					
					businessDelegatorView.updateDatAnaLaboratorioDet(entityDatAnaLaboratorioDet);
				

					entityDatAnaLaboratorioDet = null;
					selectedValorAnalisis = null;
					dataValor = null;
					dataValor = businessDelegatorView.getDataDatAnaLaboratorioDetByAnalisis(idAnalisis);

				}

			} // else
			
				setShowDialog(true);
			
		} catch (Exception e) {
			entity = null;
			  FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps! El código SQL/Fórmula asociado a la variable tiene errores",
								"Verifique la consulta."));
	       
		}
		return "";
	}

	
	
	public String actionConsultarContenidoVariable(ActionEvent evt) {
		selectedValorAnalisis = (DatAnaLaboratorioDetDTO) (evt.getComponent().getAttributes()
				.get("selectedValorAnalisis"));

		try {
			
			Long valorVarId = selectedValorAnalisis.getDatAnaLaboratorioDetId().longValue();
			Long variable = selectedValorAnalisis.getVariableLabId_VariableLab().getVariableLabId().longValue();
			
			VariableLab vlab = businessDelegatorView.getVariableLab(variable);
			String tipoVariable = vlab.getTipoVariable();
		
			
			if (tipoVariable.equals("Consulta_Sql")) {
				txtContenidoVariable.setValue(vlab.getConsultaSql());
				txtContenidoVariable.isReadonly();
			}
			
			if (tipoVariable.equals("Formula")) {
				txtContenidoVariable.setValue(vlab.getFormula());
				txtContenidoVariable.isReadonly();
				
			} // else
			
			if (tipoVariable.equals("Digitada")) {
				txtContenidoVariable.setValue(null);
				txtContenidoVariable.isReadonly();
				
			}
			
			setShowDialog(true);
			
		} catch (Exception e) {
	
		}
		return "";
	}

	public InputTextarea getTxtContenidoVariable() {
		return txtContenidoVariable;
	}

	public void setTxtContenidoVariable(InputTextarea txtContenidoVariable) {
		this.txtContenidoVariable = txtContenidoVariable;
	}
	
	


	
}
