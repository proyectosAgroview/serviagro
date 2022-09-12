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
import co.com.arcosoft.modelo.Bascula;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.BasculaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class BasculaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BasculaView.class);
	private SelectOneMenu txtBitDatos;
	private SelectOneMenu txtBitParada;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private SelectOneMenu txtParidad;

	private SelectOneMenu txtPuertoCom;
	String[] selectedPortNames;
	// String[] portNames;
	private List<String> portNames;

	private SelectOneMenu txtTipoLectura;
	private SelectOneMenu txtVelocidad;
	private InputText txtFormatoCadena;
	private InputText txtSubcadena;
	private InputText txtIntervaloLectura;
	private InputText txtIniciolectura;
	private InputText txtFinlectura;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private InputText txtBasculaId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnProbar;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<BasculaDTO> data;
	private BasculaDTO selectedBascula;
	private Bascula entity;
	private boolean showDialog;

	private static String formatoCadena;
	private static String subCadena;
	private static int caracterIniciaLectura;
	private static boolean bRegresaCadenaCompleta = false;
	private static SerialPort serialPort;
	private StringBuilder inputBuffer = null;
	private boolean portOpened = false;
	private String campoRequeridoManual = "false";
	private String campoRequeridoAutomatico = "false";
	private String ocultaCampoManual = "none";
	private String ocultaCampoAutomatico = "none";

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public BasculaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			BasculaDTO basculaDTO = (BasculaDTO) e.getObject();

			if (txtBitDatos == null) {
				txtBitDatos = new SelectOneMenu();
			}

			txtBitDatos.setValue(basculaDTO.getBitDatos());

			if (txtBitParada == null) {
				txtBitParada = new SelectOneMenu();
			}

			txtBitParada.setValue(basculaDTO.getBitParada());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(basculaDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(basculaDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(basculaDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(basculaDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(basculaDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(basculaDTO.getNombre());

			if (txtParidad == null) {
				txtParidad = new SelectOneMenu();
			}

			txtParidad.setValue(basculaDTO.getParidad());

			if (txtPuertoCom == null) {
				txtPuertoCom = new SelectOneMenu();
			}

			txtPuertoCom.setValue(basculaDTO.getPuertoCom());

			if (txtTipoLectura == null) {
				txtTipoLectura = new SelectOneMenu();
			}

			txtTipoLectura.setValue(basculaDTO.getTipoLectura());

			if (txtVelocidad == null) {
				txtVelocidad = new SelectOneMenu();
			}

			txtVelocidad.setValue(basculaDTO.getVelocidad());

			if (txtUdadMedId_UdadMed == null) {
				txtUdadMedId_UdadMed = new SelectOneMenu();
			}

			txtUdadMedId_UdadMed.setValue(basculaDTO.getUdadMedId_UdadMed());

			if (txtBasculaId == null) {
				txtBasculaId = new InputText();
			}

			txtBasculaId.setValue(basculaDTO.getBasculaId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(basculaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(basculaDTO.getFechaModificacion());

			Long basculaId = FacesUtils.checkLong(txtBasculaId);
			entity = businessDelegatorView.getBascula(basculaId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedBascula = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedBascula = null;
		PrimeFaces.current().resetInputs(":dialogBascula :frm");
			
		campoRequeridoManual = "true";
		campoRequeridoAutomatico = "false";
		ocultaCampoManual = "none";
		ocultaCampoAutomatico = "none";

		if (txtIniciolectura != null) {
			txtIniciolectura.setValue(null);
			txtIniciolectura.setDisabled(true);
		}

		if (txtFinlectura != null) {
			txtFinlectura.setValue(null);
			txtFinlectura.setDisabled(true);
		}

		if (txtBitDatos != null) {
			txtBitDatos.setValue(null);
			txtBitDatos.setDisabled(true);
		}

		if (txtBitParada != null) {
			txtBitParada.setValue(null);
			txtBitParada.setDisabled(true);
		}

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

		if (txtParidad != null) {
			txtParidad.setValue(null);
			txtParidad.setDisabled(true);
		}

		if (txtPuertoCom != null) {
			txtPuertoCom.setValue(null);
			txtPuertoCom.setDisabled(true);
		}

		if (txtTipoLectura != null) {
			txtTipoLectura.setValue(null);
			txtTipoLectura.setDisabled(true);
		}

		if (txtVelocidad != null) {
			txtVelocidad.setValue(null);
			txtVelocidad.setDisabled(true);
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

		if (txtBasculaId != null) {
			txtBasculaId.setValue(null);
			txtBasculaId.setDisabled(false);
		}

		if (txtFormatoCadena != null) {
			txtFormatoCadena.setValue("SIN DEFINIR");
			txtFormatoCadena.setDisabled(true);
		}

		if (txtSubcadena != null) {
			txtSubcadena.setValue("SIN DEFINIR");
			txtSubcadena.setDisabled(true);
		}

		if (txtIntervaloLectura != null) {
			txtIntervaloLectura.setValue(0L);
			txtIntervaloLectura.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}
		
		if (btnProbar != null) {
			btnProbar.setDisabled(true);
		}
		
		//listener_activarBotonProbarPruerto();

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
	
	public String listener_probarConexionBascula() {

		String nombrePuerto = null;
		int baudios = 0;
		int paridad = 0;
		int dataBits = 0;
		int bitsDeParada = 0;
		String formato_cadena = null;
		String sub_cadena = null;

		nombrePuerto = FacesUtils.checkString(txtPuertoCom);
		baudios = FacesUtils.checkInteger(txtVelocidad);
		paridad = FacesUtils.checkInteger(txtParidad);
		bitsDeParada = FacesUtils.checkInteger(txtBitDatos);
		formato_cadena = FacesUtils.checkString(txtFormatoCadena);
		sub_cadena = FacesUtils.checkString(txtSubcadena);
		

		serialPort = new SerialPort(nombrePuerto);

		try {

			serialPort.openPort();
			serialPort.setParams(baudios, dataBits, bitsDeParada, paridad);
			// writing string to port
			serialPort.writeString(formato_cadena);


			try {
	            if (this.serialPort.isOpened()) {
	                serialPort.closePort();
	            }
	        } catch (SerialPortException e) {
	        	
	        	FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!", "El puerto no puede ser abierto: " + e));
	            
	        }
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Genial!", " La prueba de conexión es exitosa.. "));

		} catch (SerialPortException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!", " Respuesta: " + e));
			e.printStackTrace();
		} // Open serial port
		
		return "";

	}

	public void listener_txtCodigo() {
		try {
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Bascula> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInBascula(condicion, null, null)
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
			txtBitDatos.setDisabled(false);
			txtBitParada.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtParidad.setDisabled(false);
			txtPuertoCom.setDisabled(false);
			txtTipoLectura.setDisabled(false);
			txtVelocidad.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtBasculaId.setDisabled(false);
			txtFormatoCadena.setDisabled(false);
			txtSubcadena.setDisabled(false);
			txtIntervaloLectura.setDisabled(true);
			txtIniciolectura.setDisabled(false);
			txtFinlectura.setDisabled(false);
			btnSave.setDisabled(false);
			btnProbar.setDisabled(true);
		} else {
			txtBitDatos.setValue(entity.getBitDatos());
			txtBitDatos.setDisabled(false);
			txtBitParada.setValue(entity.getBitParada());
			txtBitParada.setDisabled(false);
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
			txtParidad.setValue(entity.getParidad());
			txtParidad.setDisabled(false);
			txtPuertoCom.setValue(entity.getPuertoCom());
			txtPuertoCom.setDisabled(false);
			txtTipoLectura.setValue(entity.getTipoLectura());
			txtTipoLectura.setDisabled(false);
			
			String tipo = entity.getTipoLectura().toString();
			
			activarBotones(tipo);
			
			txtVelocidad.setValue(entity.getVelocidad());
			txtVelocidad.setDisabled(false);
			txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
			txtUdadMedId_UdadMed.setDisabled(false);

			txtFormatoCadena.setValue(entity.getFormatoCadena());
			txtFormatoCadena.setDisabled(false);
			txtSubcadena.setValue(entity.getSubcadena());
			txtSubcadena.setDisabled(false);
			txtIntervaloLectura.setValue(entity.getIntervaloLectura());
			txtIntervaloLectura.setDisabled(true);

			txtIniciolectura.setValue(entity.getIniciolectura());
			txtIniciolectura.setDisabled(false);

			txtFinlectura.setValue(entity.getFinlectura());
			txtFinlectura.setDisabled(true);

			txtBasculaId.setValue(entity.getBasculaId());
			txtBasculaId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedBascula = (BasculaDTO) (evt.getComponent().getAttributes().get("selectedBascula"));
		try {

			String codigo = selectedBascula.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Bascula> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInBascula(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtBitDatos.setValue(selectedBascula.getBitDatos());
				txtBitDatos.setDisabled(false);
				txtBitParada.setValue(selectedBascula.getBitParada());
				txtBitParada.setDisabled(false);
				txtCodigo.setValue(selectedBascula.getCodigo());
				txtCodigo.setDisabled(false);
				txtEstado.setValue(selectedBascula.getEstado());
				txtEstado.setDisabled(false);
				txtInfoAdicional.setValue(selectedBascula.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(selectedBascula.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(selectedBascula.getNombre());
				txtNombre.setDisabled(false);
				txtParidad.setValue(selectedBascula.getParidad());
				txtParidad.setDisabled(false);
				txtPuertoCom.setValue(selectedBascula.getPuertoCom());
				txtPuertoCom.setDisabled(false);
				txtTipoLectura.setValue(selectedBascula.getTipoLectura());
				txtTipoLectura.setDisabled(false);
				activarBotones(selectedBascula.getTipoLectura());
				txtVelocidad.setValue(selectedBascula.getVelocidad());
				txtVelocidad.setDisabled(false);
				txtUdadMedId_UdadMed.setValue(selectedBascula.getUdadMedId_UdadMed());
				txtUdadMedId_UdadMed.setDisabled(false);
				txtFormatoCadena.setValue(entity.getFormatoCadena());
				txtFormatoCadena.setDisabled(false);
				txtSubcadena.setValue(entity.getSubcadena());
				txtSubcadena.setDisabled(false);
				txtIntervaloLectura.setValue(entity.getIntervaloLectura());
				txtIntervaloLectura.setDisabled(true);
				txtIniciolectura.setValue(entity.getIniciolectura());
				txtIniciolectura.setDisabled(false);
				txtFinlectura.setValue(entity.getFinlectura());
				txtFinlectura.setDisabled(false);
				txtBasculaId.setValue(selectedBascula.getBasculaId());
				txtBasculaId.setDisabled(true);
				btnSave.setDisabled(false);
				
				//listener_activarBotonProbarPruerto();
				
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedBascula == null) && (entity == null)) {
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
			entity = new Bascula();

			Long usuarioDig = new Long(getUsuarioIdSession());
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setEstado(estado);
			entity.setFechaCreacion(date);

			entity.setUsuarioDigitacion(usuarioDig);
			entity.setBitDatos(FacesUtils.checkString(txtBitDatos));
			entity.setBitParada(FacesUtils.checkDouble(txtBitParada));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));

			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setParidad(FacesUtils.checkString(txtParidad));
			entity.setPuertoCom(FacesUtils.checkString(txtPuertoCom));
			entity.setTipoLectura(FacesUtils.checkString(txtTipoLectura));
			entity.setVelocidad(FacesUtils.checkLong(txtVelocidad));
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);

			entity.setFormatoCadena(FacesUtils.checkString(txtFormatoCadena));
			entity.setSubcadena(FacesUtils.checkString(txtSubcadena));
			entity.setIntervaloLectura(FacesUtils.checkLong(txtIntervaloLectura));

			entity.setIniciolectura(FacesUtils.checkLong(txtIniciolectura));
			entity.setFinlectura(FacesUtils.checkLong(txtFinlectura));

			businessDelegatorView.saveBascula(entity);
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
				Long basculaId = new Long(selectedBascula.getBasculaId());
				entity = businessDelegatorView.getBascula(basculaId);
			}

			Long usuarioDig = new Long(getUsuarioIdSession());
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setCompania(compania);
			entity.setFechaCreacion(date);
			entity.setUsuarioDigitacion(usuarioDig);
			entity.setBitDatos(FacesUtils.checkString(txtBitDatos));
			entity.setBitParada(FacesUtils.checkDouble(txtBitParada));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setParidad(FacesUtils.checkString(txtParidad));
			entity.setPuertoCom(FacesUtils.checkString(txtPuertoCom));
			entity.setTipoLectura(FacesUtils.checkString(txtTipoLectura));
			entity.setVelocidad(FacesUtils.checkLong(txtVelocidad));
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);
			entity.setFormatoCadena(FacesUtils.checkString(txtFormatoCadena));
			entity.setSubcadena(FacesUtils.checkString(txtSubcadena));
			entity.setIntervaloLectura(FacesUtils.checkLong(txtIntervaloLectura));
			entity.setIniciolectura(FacesUtils.checkLong(txtIniciolectura));
			entity.setFinlectura(FacesUtils.checkLong(txtFinlectura));
			businessDelegatorView.updateBascula(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedBascula = (BasculaDTO) (evt.getComponent().getAttributes().get("selectedBascula"));

			Long basculaId = new Long(selectedBascula.getBasculaId());
			entity = businessDelegatorView.getBascula(basculaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long basculaId = FacesUtils.checkLong(txtBasculaId);
			entity = businessDelegatorView.getBascula(basculaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteBascula(entity);
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
			selectedBascula = (BasculaDTO) (evt.getComponent().getAttributes().get("selectedBascula"));

			Long basculaId = new Long(selectedBascula.getBasculaId());
			entity = businessDelegatorView.getBascula(basculaId);
			businessDelegatorView.deleteBascula(entity);
			data.remove(selectedBascula);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long basculaId, String bitDatos, Double bitParada, String codigo, Long compania,
			String estado, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2,
			String nombre, String paridad, String puertoCom, String tipoLectura, Long velocidad, Long udadMedId_UdadMed)
			throws Exception {
		try {
			entity.setBitDatos(FacesUtils.checkString(bitDatos));
			entity.setBitParada(FacesUtils.checkDouble(bitParada));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setParidad(FacesUtils.checkString(paridad));
			entity.setPuertoCom(FacesUtils.checkString(puertoCom));
			entity.setTipoLectura(FacesUtils.checkString(tipoLectura));
			entity.setVelocidad(FacesUtils.checkLong(velocidad));
			businessDelegatorView.updateBascula(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("BasculaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtBitParada() {
		return txtBitParada;
	}

	public void setTxtBitParada(SelectOneMenu txtBitParada) {
		this.txtBitParada = txtBitParada;
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

	public InputText getTxtBasculaId() {
		return txtBasculaId;
	}

	public void setTxtBasculaId(InputText txtBasculaId) {
		this.txtBasculaId = txtBasculaId;
	}

	public SelectOneMenu getTxtBitDatos() {
		return txtBitDatos;
	}

	public void setTxtBitDatos(SelectOneMenu txtBitDatos) {
		this.txtBitDatos = txtBitDatos;
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

	public SelectOneMenu getTxtParidad() {
		return txtParidad;
	}

	public void setTxtParidad(SelectOneMenu txtParidad) {
		this.txtParidad = txtParidad;
	}

	public SelectOneMenu getTxtPuertoCom() {
		return txtPuertoCom;
	}

	public void setTxtPuertoCom(SelectOneMenu txtPuertoCom) {
		this.txtPuertoCom = txtPuertoCom;
	}

	public SelectOneMenu getTxtTipoLectura() {
		return txtTipoLectura;
	}

	public void setTxtTipoLectura(SelectOneMenu txtTipoLectura) {
		this.txtTipoLectura = txtTipoLectura;
	}

	public SelectOneMenu getTxtVelocidad() {
		return txtVelocidad;
	}

	public void setTxtVelocidad(SelectOneMenu txtVelocidad) {
		this.txtVelocidad = txtVelocidad;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public List<UdadMed> getUdadMed() {
		return udadMed;
	}

	public void setUdadMed(List<UdadMed> udadMed) {
		this.udadMed = udadMed;
	}

	public Bascula getEntity() {
		return entity;
	}

	public void setEntity(Bascula entity) {
		this.entity = entity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public List<BasculaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataBascula();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<BasculaDTO> basculaDTO) {
		this.data = basculaDTO;
	}

	public BasculaDTO getSelectedBascula() {
		return selectedBascula;
	}

	public void setSelectedBascula(BasculaDTO bascula) {
		this.selectedBascula = bascula;
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

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			udadMed = new ArrayList<UdadMed>();

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMed[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed;
	}

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public InputText getTxtFormatoCadena() {
		return txtFormatoCadena;
	}

	public void setTxtFormatoCadena(InputText txtFormatoCadena) {
		this.txtFormatoCadena = txtFormatoCadena;
	}

	public InputText getTxtSubcadena() {
		return txtSubcadena;
	}

	public void setTxtSubcadena(InputText txtSubcadena) {
		this.txtSubcadena = txtSubcadena;
	}

	public InputText getTxtIntervaloLectura() {
		return txtIntervaloLectura;
	}

	public void setTxtIntervaloLectura(InputText txtIntervaloLectura) {
		this.txtIntervaloLectura = txtIntervaloLectura;
	}

	public InputText getTxtIniciolectura() {
		return txtIniciolectura;
	}

	public void setTxtIniciolectura(InputText txtIniciolectura) {
		this.txtIniciolectura = txtIniciolectura;
	}

	public InputText getTxtFinlectura() {
		return txtFinlectura;
	}

	public void setTxtFinlectura(InputText txtFinlectura) {
		this.txtFinlectura = txtFinlectura;
	}

	public static String getFormatoCadena() {
		return formatoCadena;
	}

	public static void setFormatoCadena(String formatoCadena) {
		BasculaView.formatoCadena = formatoCadena;
	}

	public static String getSubCadena() {
		return subCadena;
	}

	public static void setSubCadena(String subCadena) {
		BasculaView.subCadena = subCadena;
	}

	public static int getCaracterIniciaLectura() {
		return caracterIniciaLectura;
	}

	public static void setCaracterIniciaLectura(int caracterIniciaLectura) {
		BasculaView.caracterIniciaLectura = caracterIniciaLectura;
	}

	public static boolean isbRegresaCadenaCompleta() {
		return bRegresaCadenaCompleta;
	}

	public static void setbRegresaCadenaCompleta(boolean bRegresaCadenaCompleta) {
		BasculaView.bRegresaCadenaCompleta = bRegresaCadenaCompleta;
	}

	public static SerialPort getSerialPort() {
		return serialPort;
	}

	public static void setSerialPort(SerialPort serialPort) {
		BasculaView.serialPort = serialPort;
	}

	public StringBuilder getInputBuffer() {
		return inputBuffer;
	}

	public void setInputBuffer(StringBuilder inputBuffer) {
		this.inputBuffer = inputBuffer;
	}

	public boolean isPortOpened() {
		return portOpened;
	}

	public void setPortOpened(boolean portOpened) {
		this.portOpened = portOpened;
	}
	
	public void activarBotones(String tipo){
		
		btnProbar.setDisabled(false);
		
		//String tipoLectura = FacesUtils.checkString(txtTipoLectura);
		
		if(tipo.equals("Automatica")) {
			
			btnProbar.setDisabled(false);
			campoRequeridoManual = "false";
			campoRequeridoAutomatico = "true";
			ocultaCampoManual = "none";
			ocultaCampoAutomatico = "block";
			
		}else {
			campoRequeridoManual = "true";
			campoRequeridoAutomatico = "false";
			ocultaCampoManual = "none";
			ocultaCampoAutomatico = "none";
			btnProbar.setDisabled(true);
		}

		
	}
	
	public void listener_activarBotones(){
		
		btnProbar.setDisabled(false);
		
		String tipoLectura = FacesUtils.checkString(txtTipoLectura);
		
		if(tipoLectura.equals("Automatica")) {
			
			btnProbar.setDisabled(false);
			campoRequeridoManual = "false";
			campoRequeridoAutomatico = "true";
			ocultaCampoManual = "none";
			ocultaCampoAutomatico = "block";
			
		}else {
			campoRequeridoManual = "true";
			campoRequeridoAutomatico = "false";
			ocultaCampoManual = "none";
			ocultaCampoAutomatico = "none";
			btnProbar.setDisabled(true);
		}

		
	}
	
	public void listener_activarBotonProbarPruerto() {
		
		//btnProbar.setDisabled(false);

		if (SerialPortList.getPortNames() != null) {
			//btnProbar.setDisabled(true);
		}else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Lo sentimos!", " Lo sentimos no hay puertos serial detectados.. "));
			//btnProbar.setDisabled(false);
		}
		
	}

	public String[] getSelectedPortNames() {

		if (SerialPortList.getPortNames() != null) {

			selectedPortNames = SerialPortList.getPortNames();

			if (selectedPortNames == null || selectedPortNames.length == 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Lo sentimos!", " Lo sentimos no hay puertos serial detectados.. "));
			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Lo sentimos!", " Lo sentimos no hay puertos serial detectados.. "));
		}

		return selectedPortNames;
	}

	public void setSelectedPortNames(String[] selectedPortNames) {
		this.selectedPortNames = selectedPortNames;
	}

	public List<String> getPortNames() {
		return portNames;
	}

	public void setPortNames(List<String> portNames) {
		this.portNames = portNames;
	}

	public CommandButton getBtnProbar() {
		return btnProbar;
	}

	public void setBtnProbar(CommandButton btnProbar) {
		this.btnProbar = btnProbar;
	}

	public String getCampoRequeridoManual() {
		return campoRequeridoManual;
	}

	public void setCampoRequeridoManual(String campoRequeridoManual) {
		this.campoRequeridoManual = campoRequeridoManual;
	}

	public String getCampoRequeridoAutomatico() {
		return campoRequeridoAutomatico;
	}

	public void setCampoRequeridoAutomatico(String campoRequeridoAutomatico) {
		this.campoRequeridoAutomatico = campoRequeridoAutomatico;
	}

	public String getOcultaCampoManual() {
		return ocultaCampoManual;
	}

	public void setOcultaCampoManual(String ocultaCampoManual) {
		this.ocultaCampoManual = ocultaCampoManual;
	}

	public String getOcultaCampoAutomatico() {
		return ocultaCampoAutomatico;
	}

	public void setOcultaCampoAutomatico(String ocultaCampoAutomatico) {
		this.ocultaCampoAutomatico = ocultaCampoAutomatico;
	}
	
	


}
