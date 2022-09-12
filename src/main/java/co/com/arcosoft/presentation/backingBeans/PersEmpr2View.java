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
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.EntBanc;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.TarifaContratista;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.PersEmprDTO;
import co.com.arcosoft.modelo.dto.TarifaContratistaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PersEmpr2View implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PersEmpr2View.class);
	private InputText txtApartadoPostal;
	private InputText txtCodigo;
	private InputText txtCodigoPostal;
	private InputText txtCompania;
	private InputText txtDireccion;
	private InputText txtEmail;
	private SelectOneRadio txtEstado;
	private SelectOneRadio txtEstadoCivil;
	private InputText txtIdentificacion;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtNumeroCuenta;
	private InputText txtPbx;
	private InputText txtRepresentanteLegal;
	private InputText txtSitioWeb;
	private InputText txtTelefono;
	private InputText txtTelefono2;
	private SelectOneRadio txtTipoEmpresa;
	private SelectOneRadio txtTipoIdentificacion;
	private SelectOneRadio txtTipoPersona;
	private InputText txtPersEmprId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<PersEmprDTO> data;
	private PersEmprDTO selectedPersEmpr;
	private PersEmpr entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectOneMenu txtCiudadId_Ciudad;
	SelectItem[] selectItemCiudad;
	private List<Ciudad> ciudad;

	private SelectOneMenu txtEntBancId_EntBanc;
	SelectItem[] selectItemEntBanc;
	private List<EntBanc> entBanc;

	private SelectOneMenu txtProfId_Profesion;
	SelectItem[] selectItemProfesion;
	private List<Profesion> profesion;

	/**********************/
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private SelectOneMenu txtServicioId_Servicio;
	SelectItem[] selectServicioId;
	private List<ConceptoNomina> servicioId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private List<TarifaContratistaDTO> dataTarifaContratista;
	private TarifaContratistaDTO selectedTarifaContratista;

	private InputText txtCodLabor;
	private InputText txtCodServicio;
	private InputText txtCodUdadMed;

	private InputText txtCodContrato;
	private Calendar txtFechaInicialContrato;
	private Calendar txtFechaFinContrato;
	private InputText txtMontoContrato;
	private InputText txtMontoLiquidado;
	private InputText txtSaldo;
	private InputTextarea txtDescripcionContrato;

	/*********************/
	public PersEmpr2View() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PersEmprDTO persEmprDTO = (PersEmprDTO) e.getObject();

			if (txtApartadoPostal == null) {
				txtApartadoPostal = new InputText();
			}

			txtApartadoPostal.setValue(persEmprDTO.getApartadoPostal());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(persEmprDTO.getCodigo());

			if (txtCodigoPostal == null) {
				txtCodigoPostal = new InputText();
			}

			txtCodigoPostal.setValue(persEmprDTO.getCodigoPostal());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(persEmprDTO.getCompania());

			if (txtDireccion == null) {
				txtDireccion = new InputText();
			}

			txtDireccion.setValue(persEmprDTO.getDireccion());

			if (txtEmail == null) {
				txtEmail = new InputText();
			}

			txtEmail.setValue(persEmprDTO.getEmail());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(persEmprDTO.getEstado());

			if (txtEstadoCivil == null) {
				txtEstadoCivil = new SelectOneRadio();
			}

			txtEstadoCivil.setValue(persEmprDTO.getEstadoCivil());

			if (txtIdentificacion == null) {
				txtIdentificacion = new InputText();
			}

			txtIdentificacion.setValue(persEmprDTO.getIdentificacion());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(persEmprDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(persEmprDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(persEmprDTO.getNombre());

			if (txtNumeroCuenta == null) {
				txtNumeroCuenta = new InputText();
			}

			txtNumeroCuenta.setValue(persEmprDTO.getNumeroCuenta());

			if (txtPbx == null) {
				txtPbx = new InputText();
			}

			txtPbx.setValue(persEmprDTO.getPbx());

			if (txtRepresentanteLegal == null) {
				txtRepresentanteLegal = new InputText();
			}

			txtRepresentanteLegal.setValue(persEmprDTO.getRepresentanteLegal());

			if (txtSitioWeb == null) {
				txtSitioWeb = new InputText();
			}

			txtSitioWeb.setValue(persEmprDTO.getSitioWeb());

			if (txtTelefono == null) {
				txtTelefono = new InputText();
			}

			txtTelefono.setValue(persEmprDTO.getTelefono());

			if (txtTelefono2 == null) {
				txtTelefono2 = new InputText();
			}

			txtTelefono2.setValue(persEmprDTO.getTelefono2());

			if (txtTipoEmpresa == null) {
				txtTipoEmpresa = new SelectOneRadio();
			}

			txtTipoEmpresa.setValue(persEmprDTO.getTipoEmpresa());

			if (txtTipoIdentificacion == null) {
				txtTipoIdentificacion = new SelectOneRadio();
			}

			txtTipoIdentificacion.setValue(persEmprDTO.getTipoIdentificacion());

			if (txtTipoPersona == null) {
				txtTipoPersona = new SelectOneRadio();
			}

			txtTipoPersona.setValue(persEmprDTO.getTipoPersona());

			if (txtCiudadId_Ciudad == null) {
				txtCiudadId_Ciudad = new SelectOneMenu();
			}

			txtCiudadId_Ciudad.setValue(persEmprDTO.getCiudadId_Ciudad());

			if (txtEntBancId_EntBanc == null) {
				txtEntBancId_EntBanc = new SelectOneMenu();
			}

			txtEntBancId_EntBanc.setValue(persEmprDTO.getEntBancId_EntBanc());

			if (txtProfId_Profesion == null) {
				txtProfId_Profesion = new SelectOneMenu();
			}

			txtProfId_Profesion.setValue(persEmprDTO.getProfId_Profesion());

			if (txtPersEmprId == null) {
				txtPersEmprId = new InputText();
			}

			txtPersEmprId.setValue(persEmprDTO.getPersEmprId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(persEmprDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(persEmprDTO.getFechaModificacion());

			Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
			entity = businessDelegatorView.getPersEmpr(persEmprId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPersEmpr = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPersEmpr = null;
		PrimeFaces.current().resetInputs(":dialogPersEmpr :frm");

		if (txtApartadoPostal != null) {
			txtApartadoPostal.setValue(null);
			txtApartadoPostal.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCodLabor != null) {
			txtCodLabor.setValue(null);
			txtCodLabor.setDisabled(false);
		}

		if (txtCodServicio != null) {
			txtCodServicio.setValue(null);
			txtCodServicio.setDisabled(false);
		}

		if (txtCodUdadMed != null) {
			txtCodUdadMed.setValue(null);
			txtCodUdadMed.setDisabled(false);
		}

		if (txtCodigoPostal != null) {
			txtCodigoPostal.setValue(null);
			txtCodigoPostal.setDisabled(true);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(true);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtEstadoCivil != null) {
			txtEstadoCivil.setValue(null);
			txtEstadoCivil.setDisabled(true);
		}

		if (txtIdentificacion != null) {
			txtIdentificacion.setValue(null);
			txtIdentificacion.setDisabled(true);
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

		if (dataTarifaContratista != null) {
			dataTarifaContratista = null;
		}
		if (txtNumeroCuenta != null) {
			txtNumeroCuenta.setValue(null);
			txtNumeroCuenta.setDisabled(true);
		}

		if (txtPbx != null) {
			txtPbx.setValue(null);
			txtPbx.setDisabled(true);
		}

		if (txtRepresentanteLegal != null) {
			txtRepresentanteLegal.setValue(null);
			txtRepresentanteLegal.setDisabled(true);
		}

		if (txtSitioWeb != null) {
			txtSitioWeb.setValue(null);
			txtSitioWeb.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtTelefono2 != null) {
			txtTelefono2.setValue(null);
			txtTelefono2.setDisabled(true);
		}

		if (txtTipoEmpresa != null) {
			txtTipoEmpresa.setValue(null);
			txtTipoEmpresa.setDisabled(true);
		}

		if (txtTipoIdentificacion != null) {
			txtTipoIdentificacion.setValue(null);
			txtTipoIdentificacion.setDisabled(true);
		}

		if (txtTipoPersona != null) {
			txtTipoPersona.setValue(null);
			txtTipoPersona.setDisabled(true);
		}

		if (txtCiudadId_Ciudad != null) {
			txtCiudadId_Ciudad.setValue(null);
			txtCiudadId_Ciudad.setDisabled(true);
		}

		if (txtEntBancId_EntBanc != null) {
			txtEntBancId_EntBanc.setValue(null);
			txtEntBancId_EntBanc.setDisabled(true);
		}

		if (txtProfId_Profesion != null) {
			txtProfId_Profesion.setValue(null);
			txtProfId_Profesion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(false);
		}

		if (txtValorUnit != null) {
			txtValorUnit.setValue(null);
			txtValorUnit.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtServicioId_Servicio != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (txtServicioId_Servicio != null) {
			txtServicioId_Servicio.setValue(null);
			txtServicioId_Servicio.setDisabled(true);
		}

		if (txtCodContrato != null) {
			txtCodContrato.setValue(null);
			txtCodContrato.setDisabled(true);
		}

		if (txtFechaInicialContrato != null) {
			txtFechaInicialContrato.setValue(null);
			txtFechaInicialContrato.setDisabled(true);
		}

		if (txtFechaFinContrato != null) {
			txtFechaFinContrato.setValue(null);
			txtFechaFinContrato.setDisabled(true);
		}

		if (txtMontoContrato != null) {
			txtMontoContrato.setValue(null);
			txtMontoContrato.setDisabled(true);
		}

		if (txtMontoLiquidado != null) {
			txtMontoLiquidado.setValue(null);
			txtMontoLiquidado.setDisabled(true);
		}
		if (txtSaldo != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(true);
		}

		if (txtDescripcionContrato != null) {
			txtDescripcionContrato.setValue(null);
			txtDescripcionContrato.setDisabled(true);
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
			Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
			entity = (persEmprId != null) ? businessDelegatorView.getPersEmpr(persEmprId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtApartadoPostal.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCodigoPostal.setDisabled(false);
			txtCompania.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEstadoCivil.setDisabled(false);
			txtIdentificacion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNumeroCuenta.setDisabled(false);
			txtPbx.setDisabled(false);
			txtRepresentanteLegal.setDisabled(false);
			txtSitioWeb.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTelefono2.setDisabled(false);
			txtTipoEmpresa.setDisabled(false);
			txtTipoIdentificacion.setDisabled(false);
			txtTipoPersona.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtEntBancId_EntBanc.setDisabled(false);
			txtProfId_Profesion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtPersEmprId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtApartadoPostal.setValue(entity.getApartadoPostal());
			txtApartadoPostal.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCodigoPostal.setValue(entity.getCodigoPostal());
			txtCodigoPostal.setDisabled(false);
			txtCompania.setValue(entity.getCompania());
			txtCompania.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEstadoCivil.setValue(entity.getEstadoCivil());
			txtEstadoCivil.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtIdentificacion.setValue(entity.getIdentificacion());
			txtIdentificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumeroCuenta.setValue(entity.getNumeroCuenta());
			txtNumeroCuenta.setDisabled(false);
			txtPbx.setValue(entity.getPbx());
			txtPbx.setDisabled(false);
			txtRepresentanteLegal.setValue(entity.getRepresentanteLegal());
			txtRepresentanteLegal.setDisabled(false);
			txtSitioWeb.setValue(entity.getSitioWeb());
			txtSitioWeb.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTelefono2.setValue(entity.getTelefono2());
			txtTelefono2.setDisabled(false);
			txtTipoEmpresa.setValue(entity.getTipoEmpresa());
			txtTipoEmpresa.setDisabled(false);
			txtTipoIdentificacion.setValue(entity.getTipoIdentificacion());
			txtTipoIdentificacion.setDisabled(false);
			txtTipoPersona.setValue(entity.getTipoPersona());
			txtTipoPersona.setDisabled(false);
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtEntBancId_EntBanc.setValue(entity.getEntBanc());
			txtEntBancId_EntBanc.setDisabled(false);
			txtProfId_Profesion.setValue(entity.getProfesion());
			txtProfId_Profesion.setDisabled(false);
			txtPersEmprId.setValue(entity.getPersEmprId());
			txtPersEmprId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public List<TarifaContratistaDTO> getDataContratistaByTarifaContratistaId() {

		if (dataTarifaContratista == null || dataTarifaContratista.size() == 0) {
			return null;
		} else {
			return dataTarifaContratista;
		}

	}

	public void action_agregarTarifaContratista() throws Exception {

		Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

		Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
		Labor labor = businessDelegatorView.getLabor(laborId);
		Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
		UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

		Long servicioId = Long.parseLong(txtServicioId_Servicio.getValue().toString());
		ConceptoNomina servicio = businessDelegatorView.getConceptoNomina(servicioId);

		String codLabor = FacesUtils.checkString(txtCodLabor);
		String codServicio = FacesUtils.checkString(txtCodServicio);
		String codUdadMed = FacesUtils.checkString(txtCodUdadMed);
		Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
		Date fechaCreacion = new Date();
		Date fechaModificacion = new Date();
		Long compania = new Long(getCompaniaIdSession());

		if (dataTarifaContratista == null) {
			dataTarifaContratista = new ArrayList<TarifaContratistaDTO>();
		}

		// if(dataTarifaContratista.size() > 0){

		TarifaContratistaDTO tarifaContratistaDTO = new TarifaContratistaDTO();
		tarifaContratistaDTO.setFechaInicial(fechaInicial);
		tarifaContratistaDTO.setFechaFinal(fechaFinal);
		tarifaContratistaDTO.setLaborId_Labor(labor);
		tarifaContratistaDTO.setServicioId_Servicio(servicio);
		tarifaContratistaDTO.setUdadMedId_UdadMed(udadMed);
		tarifaContratistaDTO.setTarifa(valorUnit);
		tarifaContratistaDTO.setCodLabor(codLabor);
		tarifaContratistaDTO.setCodServicio(codServicio);
		tarifaContratistaDTO.setCodUdadMed(codUdadMed);
		tarifaContratistaDTO.setCompania(compania);
		tarifaContratistaDTO.setFechaCreacion(fechaCreacion);
		tarifaContratistaDTO.setFechaModificacion(fechaModificacion);

		dataTarifaContratista.add(tarifaContratistaDTO);
		fechaInicial = null;
		fechaFinal = null;
		labor = null;
		servicio = null;
		udadMed = null;
		valorUnit = null;
		codLabor = null;
		codServicio = null;
		codUdadMed = null;
	}

	public void listener_ConsultaCodUdadMed() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMed.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodUdadMed.setValue(udadMed.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodLabor() {

		Long laborId = null;

		if (!txtLaborId_Labor.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());

			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodLabor.setValue(labor.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodServicio() {

		Long servicioId = null;

		if (!txtServicioId_Servicio.getValue().equals("")) {
			servicioId = Long.parseLong(txtServicioId_Servicio.getValue().toString());

			try {
				ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(servicioId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodServicio.setValue(conceptoNomina.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	@Autowired
	public void listener_calcularSaldo() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Double result = 0.0;
		Double valorContrato = FacesUtils.checkDouble(txtMontoContrato);
		Double valorLiquidado = FacesUtils.checkDouble(txtMontoLiquidado);

		if (valorContrato != null && valorLiquidado != null) {
			result = (valorContrato - valorLiquidado);
			String format = decimalFormat.format(result);
			txtSaldo.setValue(format);
		} else {
			result = 0.0;
			txtSaldo.setValue(result);
		}

	}

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<PersEmpr> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null) : null;

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
			txtApartadoPostal.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCodigoPostal.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEstadoCivil.setDisabled(false);
			txtIdentificacion.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtNumeroCuenta.setDisabled(false);
			txtPbx.setDisabled(false);
			txtRepresentanteLegal.setDisabled(false);
			txtSitioWeb.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtTelefono2.setDisabled(false);
			txtTipoEmpresa.setDisabled(false);
			txtTipoIdentificacion.setDisabled(false);
			txtTipoPersona.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtEntBancId_EntBanc.setDisabled(false);
			txtProfId_Profesion.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtPersEmprId.setDisabled(false);
			/*** sesion tarifa ***/
			txtValorUnit.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtServicioId_Servicio.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtCodLabor.setDisabled(false);
			txtCodServicio.setDisabled(false);
			txtCodUdadMed.setDisabled(false);
			txtCodContrato.setDisabled(false);
			txtFechaInicialContrato.setDisabled(false);
			txtFechaFinContrato.setDisabled(false);
			txtMontoContrato.setDisabled(false);
			txtMontoLiquidado.setDisabled(false);
			txtSaldo.setDisabled(false);
			txtDescripcionContrato.setDisabled(false);

			btnAgregar.setDisabled(false);

			btnSave.setDisabled(false);
		} else {
			txtApartadoPostal.setValue(entity.getApartadoPostal());
			txtApartadoPostal.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCodigoPostal.setValue(entity.getCodigoPostal());
			txtCodigoPostal.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEstadoCivil.setValue(entity.getEstadoCivil());
			txtEstadoCivil.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtIdentificacion.setValue(entity.getIdentificacion());
			txtIdentificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtNumeroCuenta.setValue(entity.getNumeroCuenta());
			txtNumeroCuenta.setDisabled(false);
			txtPbx.setValue(entity.getPbx());
			txtPbx.setDisabled(false);
			txtRepresentanteLegal.setValue(entity.getRepresentanteLegal());
			txtRepresentanteLegal.setDisabled(false);
			txtSitioWeb.setValue(entity.getSitioWeb());
			txtSitioWeb.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtTelefono2.setValue(entity.getTelefono2());
			txtTelefono2.setDisabled(false);
			txtTipoEmpresa.setValue(entity.getTipoEmpresa());
			txtTipoEmpresa.setDisabled(false);
			txtTipoIdentificacion.setValue(entity.getTipoIdentificacion());
			txtTipoIdentificacion.setDisabled(false);
			txtTipoPersona.setValue(entity.getTipoPersona());
			txtTipoPersona.setDisabled(false);
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtEntBancId_EntBanc.setValue(entity.getEntBanc());
			txtEntBancId_EntBanc.setDisabled(false);
			txtProfId_Profesion.setValue(entity.getProfesion());
			txtProfId_Profesion.setDisabled(false);
			txtPersEmprId.setValue(entity.getPersEmprId());
			txtPersEmprId.setDisabled(true);

			txtCodContrato.setDisabled(false);
			txtFechaInicialContrato.setDisabled(false);
			txtFechaFinContrato.setDisabled(false);
			txtMontoContrato.setDisabled(false);
			txtMontoLiquidado.setDisabled(false);
			txtSaldo.setDisabled(false);
			txtDescripcionContrato.setDisabled(false);

			/*** sesion tarifa ***/
			txtValorUnit.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtServicioId_Servicio.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtCodLabor.setDisabled(false);
			txtCodServicio.setDisabled(false);
			txtCodUdadMed.setDisabled(false);
			btnAgregar.setDisabled(false);

			Long contratistaId = FacesUtils.checkLong(txtPersEmprId);
			dataTarifaContratista = null;
			dataTarifaContratista = businessDelegatorView.getDataContratistaByTarifaContratistaId(contratistaId);

			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPersEmpr = (PersEmprDTO) (evt.getComponent().getAttributes().get("selectedPersEmpr"));

		try {

			String codigo = selectedPersEmpr.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<PersEmpr> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtApartadoPostal.setValue(entity.getApartadoPostal());
				txtApartadoPostal.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtCodigoPostal.setValue(entity.getCodigoPostal());
				txtCodigoPostal.setDisabled(false);
				// txtCompania.setValue(selectedPersEmpr.getCompania());
				// txtCompania.setDisabled(false);
				txtDireccion.setValue(entity.getDireccion());
				txtDireccion.setDisabled(false);
				txtEmail.setValue(entity.getEmail());
				txtEmail.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtEstadoCivil.setValue(entity.getEstadoCivil());
				txtEstadoCivil.setDisabled(false);
				// txtFechaCreacion.setValue(selectedPersEmpr.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(selectedPersEmpr.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtIdentificacion.setValue(entity.getIdentificacion());
				txtIdentificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtNumeroCuenta.setValue(entity.getNumeroCuenta());
				txtNumeroCuenta.setDisabled(false);
				txtPbx.setValue(selectedPersEmpr.getPbx());
				txtPbx.setDisabled(false);
				txtRepresentanteLegal.setValue(entity.getRepresentanteLegal());
				txtRepresentanteLegal.setDisabled(false);
				txtSitioWeb.setValue(entity.getSitioWeb());
				txtSitioWeb.setDisabled(false);
				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				txtTelefono2.setValue(entity.getTelefono2());
				txtTelefono2.setDisabled(false);
				txtTipoEmpresa.setValue(entity.getTipoEmpresa());
				txtTipoEmpresa.setDisabled(false);
				txtTipoIdentificacion.setValue(entity.getTipoIdentificacion());
				txtTipoIdentificacion.setDisabled(false);
				txtTipoPersona.setValue(entity.getTipoPersona());
				txtTipoPersona.setDisabled(false);
				txtCiudadId_Ciudad.setValue(entity.getCiudad());
				txtCiudadId_Ciudad.setDisabled(false);
				txtEntBancId_EntBanc.setValue(entity.getEntBanc());
				txtEntBancId_EntBanc.setDisabled(false);
				txtProfId_Profesion.setValue(entity.getProfesion());
				txtProfId_Profesion.setDisabled(false);
				txtPersEmprId.setValue(entity.getPersEmprId());
				txtPersEmprId.setDisabled(true);
				/*** sesion tarifa ***/

				Long contratistaId = FacesUtils.checkLong(txtPersEmprId);
				dataTarifaContratista = null;
				dataTarifaContratista = businessDelegatorView.getDataContratistaByTarifaContratistaId(contratistaId);

				txtValorUnit.setDisabled(false);
				txtFechaInicial.setDisabled(false);
				txtFechaFinal.setDisabled(false);
				txtLaborId_Labor.setDisabled(false);
				txtServicioId_Servicio.setDisabled(false);
				txtUdadMedId_UdadMed.setDisabled(false);
				txtCodLabor.setDisabled(false);
				txtCodServicio.setDisabled(false);
				txtCodUdadMed.setDisabled(false);

				txtCodContrato.setDisabled(false);
				txtFechaInicialContrato.setDisabled(false);
				txtFechaFinContrato.setDisabled(false);
				txtMontoContrato.setDisabled(false);
				txtMontoLiquidado.setDisabled(false);
				txtSaldo.setDisabled(false);
				txtDescripcionContrato.setDisabled(false);

				btnAgregar.setDisabled(false);
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
			if ((selectedPersEmpr == null) && (entity == null)) {
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
			entity = new PersEmpr();

			// Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();

			entity.setApartadoPostal(FacesUtils.checkString(txtApartadoPostal));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoPostal(FacesUtils.checkString(txtCodigoPostal));
			entity.setCompania(compania);
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoCivil(FacesUtils.checkString(txtEstadoCivil));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(date);
			entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumeroCuenta(FacesUtils.checkString(txtNumeroCuenta));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			// entity.setPersEmprId(persEmprId);
			entity.setRepresentanteLegal(FacesUtils.checkString(txtRepresentanteLegal));
			entity.setSitioWeb(FacesUtils.checkString(txtSitioWeb));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setTipoEmpresa(FacesUtils.checkString(txtTipoEmpresa));
			entity.setTipoIdentificacion(FacesUtils.checkString(txtTipoIdentificacion));
			entity.setTipoPersona(FacesUtils.checkString(txtTipoPersona));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));
			entity.setEntBanc((FacesUtils.checkLong(txtEntBancId_EntBanc)));
			entity.setProfesion((FacesUtils.checkLong(txtProfId_Profesion)));
			businessDelegatorView.savePersEmpr(entity, dataTarifaContratista);
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
				Long persEmprId = new Long(selectedPersEmpr.getPersEmprId());
				entity = businessDelegatorView.getPersEmpr(persEmprId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();

			entity.setApartadoPostal(FacesUtils.checkString(txtApartadoPostal));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoPostal(FacesUtils.checkString(txtCodigoPostal));
			entity.setCompania(compania);
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoCivil(FacesUtils.checkString(txtEstadoCivil));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNumeroCuenta(FacesUtils.checkString(txtNumeroCuenta));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			entity.setRepresentanteLegal(FacesUtils.checkString(txtRepresentanteLegal));
			entity.setSitioWeb(FacesUtils.checkString(txtSitioWeb));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setTipoEmpresa(FacesUtils.checkString(txtTipoEmpresa));
			entity.setTipoIdentificacion(FacesUtils.checkString(txtTipoIdentificacion));
			entity.setTipoPersona(FacesUtils.checkString(txtTipoPersona));
			entity.setCiudad(FacesUtils.checkLong(txtCiudadId_Ciudad));
			entity.setEntBanc((FacesUtils.checkLong(txtEntBancId_EntBanc)));
			entity.setProfesion((FacesUtils.checkLong(txtProfId_Profesion)));
			businessDelegatorView.updatePersEmpr(entity, dataTarifaContratista);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedPersEmpr = (PersEmprDTO) (evt.getComponent().getAttributes().get("selectedPersEmpr"));

			Long persEmprId = new Long(selectedPersEmpr.getPersEmprId());
			entity = businessDelegatorView.getPersEmpr(persEmprId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
			entity = businessDelegatorView.getPersEmpr(persEmprId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deletePersEmpr(entity);
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
			selectedPersEmpr = (PersEmprDTO) (evt.getComponent().getAttributes().get("selectedPersEmpr"));

			Long persEmprId = new Long(selectedPersEmpr.getPersEmprId());
			entity = businessDelegatorView.getPersEmpr(persEmprId);
			businessDelegatorView.deletePersEmpr(entity);
			((Map<String, Object>) data).remove(selectedPersEmpr);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String apartadoPostal, String codigo, String codigoPostal, Long compania,
			String direccion, String email, String estado, String estadoCivil, Date fechaCreacion,
			Date fechaModificacion, String identificacion, String infoAdicional, String infoAdicional2, String nombre,
			String numeroCuenta, String pbx, Long persEmprId, String representanteLegal, String sitioWeb,
			String telefono, String telefono2, String tipoEmpresa, String tipoIdentificacion, String tipoPersona,
			Long ciudadId_Ciudad, Long entBancId_EntBanc, Long profId_Profesion) throws Exception {
		try {
			entity.setApartadoPostal(FacesUtils.checkString(apartadoPostal));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCodigoPostal(FacesUtils.checkString(codigoPostal));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEstadoCivil(FacesUtils.checkString(estadoCivil));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setIdentificacion(FacesUtils.checkString(identificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setNumeroCuenta(FacesUtils.checkString(numeroCuenta));
			entity.setPbx(FacesUtils.checkString(pbx));
			entity.setRepresentanteLegal(FacesUtils.checkString(representanteLegal));
			entity.setSitioWeb(FacesUtils.checkString(sitioWeb));
			entity.setTelefono(FacesUtils.checkString(telefono));
			entity.setTelefono2(FacesUtils.checkString(telefono2));
			entity.setTipoEmpresa(FacesUtils.checkString(tipoEmpresa));
			entity.setTipoIdentificacion(FacesUtils.checkString(tipoIdentificacion));
			entity.setTipoPersona(FacesUtils.checkString(tipoPersona));
			businessDelegatorView.updatePersEmpr(entity, dataTarifaContratista);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PersEmprView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String actionDeleteTarifaContratista(ActionEvent evt) {
		try {

			selectedTarifaContratista = (TarifaContratistaDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaContratista"));

			if (selectedTarifaContratista.getTarifaCtrId() == null) {
				dataTarifaContratista.remove(selectedTarifaContratista);
			} else {
				Long contratistaId = new Long(selectedTarifaContratista.getTarifaCtrId());
				TarifaContratista entity = businessDelegatorView.getTarifaContratista(contratistaId);
				businessDelegatorView.deleteTarifaContratista(entity);
				dataTarifaContratista.remove(selectedTarifaContratista);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public InputText getTxtApartadoPostal() {
		return txtApartadoPostal;
	}

	public void setTxtApartadoPostal(InputText txtApartadoPostal) {
		this.txtApartadoPostal = txtApartadoPostal;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCodigoPostal() {
		return txtCodigoPostal;
	}

	public void setTxtCodigoPostal(InputText txtCodigoPostal) {
		this.txtCodigoPostal = txtCodigoPostal;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
	}

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public SelectOneRadio getTxtEstadoCivil() {
		return txtEstadoCivil;
	}

	public void setTxtEstadoCivil(SelectOneRadio txtEstadoCivil) {
		this.txtEstadoCivil = txtEstadoCivil;
	}

	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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

	public InputText getTxtNumeroCuenta() {
		return txtNumeroCuenta;
	}

	public void setTxtNumeroCuenta(InputText txtNumeroCuenta) {
		this.txtNumeroCuenta = txtNumeroCuenta;
	}

	public InputText getTxtPbx() {
		return txtPbx;
	}

	public void setTxtPbx(InputText txtPbx) {
		this.txtPbx = txtPbx;
	}

	public InputText getTxtRepresentanteLegal() {
		return txtRepresentanteLegal;
	}

	public void setTxtRepresentanteLegal(InputText txtRepresentanteLegal) {
		this.txtRepresentanteLegal = txtRepresentanteLegal;
	}

	public InputText getTxtSitioWeb() {
		return txtSitioWeb;
	}

	public void setTxtSitioWeb(InputText txtSitioWeb) {
		this.txtSitioWeb = txtSitioWeb;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public InputText getTxtTelefono2() {
		return txtTelefono2;
	}

	public void setTxtTelefono2(InputText txtTelefono2) {
		this.txtTelefono2 = txtTelefono2;
	}

	public SelectOneRadio getTxtTipoEmpresa() {
		return txtTipoEmpresa;
	}

	public void setTxtTipoEmpresa(SelectOneRadio txtTipoEmpresa) {
		this.txtTipoEmpresa = txtTipoEmpresa;
	}

	public SelectOneRadio getTxtTipoIdentificacion() {
		return txtTipoIdentificacion;
	}

	public void setTxtTipoIdentificacion(SelectOneRadio txtTipoIdentificacion) {
		this.txtTipoIdentificacion = txtTipoIdentificacion;
	}

	public SelectOneRadio getTxtTipoPersona() {
		return txtTipoPersona;
	}

	public void setTxtTipoPersona(SelectOneRadio txtTipoPersona) {
		this.txtTipoPersona = txtTipoPersona;
	}

	public SelectOneMenu getTxtCiudadId_Ciudad() {
		return txtCiudadId_Ciudad;
	}

	public void setTxtCiudadId_Ciudad(SelectOneMenu txtCiudadId_Ciudad) {
		this.txtCiudadId_Ciudad = txtCiudadId_Ciudad;
	}

	public SelectOneMenu getTxtEntBancId_EntBanc() {
		return txtEntBancId_EntBanc;
	}

	public void setTxtEntBancId_EntBanc(SelectOneMenu txtEntBancId_EntBanc) {
		this.txtEntBancId_EntBanc = txtEntBancId_EntBanc;
	}

	public SelectOneMenu getTxtProfId_Profesion() {
		return txtProfId_Profesion;
	}

	public void setTxtProfId_Profesion(SelectOneMenu txtProfId_Profesion) {
		this.txtProfId_Profesion = txtProfId_Profesion;
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

	public InputText getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(InputText txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public List<TarifaContratistaDTO> getDataTarifaContratista() {
		return dataTarifaContratista;
	}

	public void setDataTarifaContratista(List<TarifaContratistaDTO> dataTarifaContratista) {
		this.dataTarifaContratista = dataTarifaContratista;
	}

	public LazyDataModel<PersEmprDTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataPersEmpr();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<PersEmprDTO> persEmprDTO) {
		this.data = persEmprDTO;
	}

	public PersEmprDTO getSelectedPersEmpr() {
		return selectedPersEmpr;
	}

	public void setSelectedPersEmpr(PersEmprDTO persEmpr) {
		this.selectedPersEmpr = persEmpr;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public SelectOneMenu getTxtServicioId_Servicio() {
		return txtServicioId_Servicio;
	}

	public void setTxtServicioId_Servicio(SelectOneMenu txtServicioId_Servicio) {
		this.txtServicioId_Servicio = txtServicioId_Servicio;
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

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public InputText getTxtValorUnit() {
		return txtValorUnit;
	}

	public void setTxtValorUnit(InputText txtValorUnit) {
		this.txtValorUnit = txtValorUnit;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
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

	public SelectItem[] getSelectItemCiudad() {

		if (ciudad == null || ciudad.size() == 0) {

			ciudad = new ArrayList<Ciudad>();

			try {

				ciudad = businessDelegatorView.getCiudad(); // Fin by
				// Criteria
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectItemCiudad = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad c : lista) {
					selectItemCiudad[i] = new SelectItem(c.getCiudadId(), c.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return selectItemCiudad;
	}

	public void setSelectItemCiudad(SelectItem[] selectItemCiudad) {
		this.selectItemCiudad = selectItemCiudad;
	}

	public SelectItem[] getSelectItemEntBanc() {

		if (entBanc == null || entBanc.size() == 0) {

			entBanc = new ArrayList<EntBanc>();

			try {

				entBanc = businessDelegatorView.getEntBanc(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<EntBanc> lista = businessDelegatorView.findByCriteriaInEntBanc(condicion, null, null);
				selectItemEntBanc = new SelectItem[lista.size()];

				int i = 0;
				for (EntBanc e : lista) {
					selectItemEntBanc[i] = new SelectItem(e.getEntBancId(), e.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemEntBanc;
	}

	public void setSelectItemEntBanc(SelectItem[] selectItemEntBanc) {
		this.selectItemEntBanc = selectItemEntBanc;
	}

	public SelectItem[] getSelectItemProfesion() {

		if (profesion == null || profesion.size() == 0) {

			profesion = new ArrayList<Profesion>();

			try {

				profesion = businessDelegatorView.getProfesion(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Profesion> lista = businessDelegatorView.findByCriteriaInProfesion(condicion, null, null);
				selectItemProfesion = new SelectItem[lista.size()];

				int i = 0;
				for (Profesion p : lista) {
					selectItemProfesion[i] = new SelectItem(p.getProfId(), p.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemProfesion;
	}

	public void setSelectItemProfesion(SelectItem[] selectItemProfesion) {
		this.selectItemProfesion = selectItemProfesion;
	}

	private class LocalDataModelDTO extends LazyDataModel<PersEmprDTO> {
		private static final long serialVersionUID = 1L;
		private List<PersEmprDTO> persEmprDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<PersEmprDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				persEmprDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberEmpresa(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return persEmprDTO;

		}

		@Override
		public PersEmprDTO getRowData(String rowKey) {
			for (PersEmprDTO persEmprDTOtmp : persEmprDTO) {
				if (persEmprDTOtmp.getPersEmprId().toString().equals(rowKey))
					return persEmprDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(PersEmprDTO persEmprDTOtmp) {
			return persEmprDTOtmp.getPersEmprId();
		}

	}

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			laborId = new ArrayList<Labor>();

			try {

				laborId = businessDelegatorView.getLabor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborId : lista) {
					selectLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborId;
	}

	public void setselectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getSelectServicioId() {

		if (servicioId == null || servicioId.size() == 0) {

			servicioId = new ArrayList<ConceptoNomina>();

			try {

				servicioId = businessDelegatorView.getConceptoNomina(); // Fin
																		// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectServicioId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina servicioId : lista) {
					selectServicioId[i] = new SelectItem(servicioId.getCeptoNominaId(), servicioId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectServicioId;
	}

	public void setSelectServicioId(SelectItem[] selectServicioId) {

		this.selectServicioId = selectServicioId;
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

	private List<PersEmprDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegatorView.getDataPageEmpresa(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public InputText getTxtCodLabor() {
		return txtCodLabor;
	}

	public void setTxtCodLabor(InputText txtCodLabor) {
		this.txtCodLabor = txtCodLabor;
	}

	public InputText getTxtCodServicio() {
		return txtCodServicio;
	}

	public void setTxtCodServicio(InputText txtCodServicio) {
		this.txtCodServicio = txtCodServicio;
	}

	public InputText getTxtCodUdadMed() {
		return txtCodUdadMed;
	}

	public void setTxtCodUdadMed(InputText txtCodUdadMed) {
		this.txtCodUdadMed = txtCodUdadMed;
	}

	public InputText getTxtCodContrato() {
		return txtCodContrato;
	}

	public void setTxtCodContrato(InputText txtCodContrato) {
		this.txtCodContrato = txtCodContrato;
	}

	public Calendar getTxtFechaInicialContrato() {
		return txtFechaInicialContrato;
	}

	public void setTxtFechaInicialContrato(Calendar txtFechaInicialContrato) {
		this.txtFechaInicialContrato = txtFechaInicialContrato;
	}

	public Calendar getTxtFechaFinContrato() {
		return txtFechaFinContrato;
	}

	public void setTxtFechaFinContrato(Calendar txtFechaFinContrato) {
		this.txtFechaFinContrato = txtFechaFinContrato;
	}

	public InputText getTxtMontoContrato() {
		return txtMontoContrato;
	}

	public void setTxtMontoContrato(InputText txtMontoContrato) {
		this.txtMontoContrato = txtMontoContrato;
	}

	public InputText getTxtMontoLiquidado() {
		return txtMontoLiquidado;
	}

	public void setTxtMontoLiquidado(InputText txtMontoLiquidado) {
		this.txtMontoLiquidado = txtMontoLiquidado;
	}

	public InputText getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(InputText txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public InputTextarea getTxtDescripcionContrato() {
		return txtDescripcionContrato;
	}

	public void setTxtDescripcionContrato(InputTextarea txtDescripcionContrato) {
		this.txtDescripcionContrato = txtDescripcionContrato;
	}

}
