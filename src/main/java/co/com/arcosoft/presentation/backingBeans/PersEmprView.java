package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
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
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.EntBanc;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
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
public class PersEmprView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PersEmprView.class);
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

	private SelectOneMenu txtEntBancId_EntBanc;
	SelectItem[] selectItemEntBanc;

	private SelectOneMenu txtProfId_Profesion;
	SelectItem[] selectItemProfesion;
	
	SelectItem[] selectNivel2Edit;
	
	SelectItem[] selectNivel4Edit;

	/**********************/
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private SelectOneMenu txtServicioId_Servicio;
	SelectItem[] selectServicioId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;

	private InputText txtValorUnit;
	private CommandButton btnAgregar;

	private List<TarifaContratistaDTO> dataTarifaContratista;
	private TarifaContratistaDTO selectedTarifaContratista;
	
	private TarifaContratista entityTarifaContratista;

	private InputText txtCodLabor;
	private InputText txtCodServicio;
	private InputText txtCodUdadMed;

	private InputText txtCodProfesion;
	private SelectOneMenu txtProfId_Profesion1;
	SelectItem[] selectProfesion;

	private InputText txtEdadInicial;
	private InputText txtEdadFinal;
	private InputText txtPesoPromedio;
	private SelectOneMenu txtEstadoIncidencia;
	private SelectOneMenu txtAlturaPlanta;
	
	private int activeTapIndex = 0;

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;

	private InputText txtNivel4Nombre;
	private InputText txtNivel2Nombre;
	private Spinner txtPorcentajePagoFruto;
	private SelectOneMenu txtTablaPrecios;
	
	private SelectOneRadio txtEsArlEpsPension;
	
	/*********************/
	public PersEmprView() {
		super();
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
		activeTapIndex = 0;

		if (txtPorcentajePagoFruto != null) {
			txtPorcentajePagoFruto.setValue(null);
			txtPorcentajePagoFruto.setDisabled(true);
		}
		
		if (txtApartadoPostal != null) {
			txtApartadoPostal.setValue(null);
			txtApartadoPostal.setDisabled(true);
		}
		
		if (txtTablaPrecios != null) {
			txtTablaPrecios.setValue(null);
			txtTablaPrecios.setDisabled(true);
		}		

		if (txtAlturaPlanta != null) {
			txtAlturaPlanta.setValue(null);
			txtAlturaPlanta.setDisabled(true);
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
			txtServicioId_Servicio.setValue(null);
			txtServicioId_Servicio.setDisabled(true);
		}

		if (txtCodProfesion != null) {
			txtCodProfesion.setValue(null);
			txtCodProfesion.setDisabled(true);
		}

		if (txtProfId_Profesion1 != null) {
			txtProfId_Profesion1.setValue(null);
			txtProfId_Profesion1.setDisabled(true);
		}

		if (txtEdadInicial != null) {
			txtEdadInicial.setValue(null);
			txtEdadInicial.setDisabled(true);
		}
		
		if (txtEdadFinal != null) {
			txtEdadFinal.setValue(null);
			txtEdadFinal.setDisabled(true);
		}
		
		if (txtEstadoIncidencia != null) {
			txtEstadoIncidencia.setValue(null);
			txtEstadoIncidencia.setDisabled(true);
		}
		
		if (txtPesoPromedio != null) {
			txtPesoPromedio.setValue(null);
			txtPesoPromedio.setDisabled(true);
		}
		
		if (txtEsArlEpsPension != null) {
			txtEsArlEpsPension.setValue(null);
			txtEsArlEpsPension.setDisabled(true);
		}
		
		/************ + Detalle otros costos nivel4 ****/

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(true);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}
		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(true);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(true);
		}

		if (txtNivel2Nombre != null) {
			txtNivel2Nombre.setValue(null);
			txtNivel2Nombre.setDisabled(true);
		}
		if (txtNivel4Nombre != null) {
			txtNivel4Nombre.setValue(null);
			txtNivel4Nombre.setDisabled(true);
		}

		
		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void action_agregarTarifaContratista() throws Exception {
		if (txtFechaInicial.getValue() != null && txtFechaFinal.getValue() != null
				&& txtLaborId_Labor.getValue() != null && txtUdadMedId_UdadMed.getValue() != null
				&& txtServicioId_Servicio.getValue() != null && txtValorUnit.getValue() != null
				) {
			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			Labor labor = businessDelegatorView.getLabor(laborId);
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);

			Long servicioId = Long.parseLong(txtServicioId_Servicio.getValue().toString());
			ConceptoNomina servicio = businessDelegatorView.getConceptoNomina(servicioId);

//			Long profesionId = Long.parseLong(txtProfId_Profesion1.getValue().toString());
	//		Profesion profesion = businessDelegatorView.getProfesion(profesionId);

			String codLabor = labor.getCodigo();
			String codServicio =  servicio.getCodigo();
			String codUdadMed =  udadMed.getCodigo();
		//	String codProfesion = FacesUtils.checkString(txtCodProfesion);
			
			Double valorUnit = FacesUtils.checkDouble(txtValorUnit);
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();
			Long compania = new Long(getCompaniaIdSession());

			Double edadInicial = FacesUtils.checkDouble(txtEdadInicial);
			Double edadFinal = FacesUtils.checkDouble(txtEdadFinal);
			//Double pesoPromedio = FacesUtils.checkDouble(txtPesoPromedio);
			String estadoIncidencia = FacesUtils.checkString(txtEstadoIncidencia);
			String alturaPlanta =   FacesUtils.checkString(txtAlturaPlanta);
			Long nivel2= null;
			Long nivel4 = null;
			String nombreNivel2="";
			String nombreNivel4 ="";
			Nivel2 nivel2Id = null;
			Nivel4 nivel4Id =null;
			
			if (txtNivel2Id_Nivel2.getValue() != null && txtNivel4Id_Nivel4.getValue() != null) {

				 nivel2 = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());
				 nivel2Id = businessDelegatorView.getNivel2(nivel2);

				 nivel4 = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
				 nivel4Id = businessDelegatorView.getNivel4(nivel4);

				 nombreNivel2 = nivel2Id.getCodigo();
				 nombreNivel4 = nivel4Id.getCodigo();
			}
			
			boolean existeProducto = false;

			if (dataTarifaContratista == null) {
				dataTarifaContratista = new ArrayList<TarifaContratistaDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataTarifaContratista.size() > 0) {

				for (TarifaContratistaDTO d : dataTarifaContratista) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getLaborId_Labor().getLaborId().longValue() == labor.getLaborId().longValue()
							//&& d.getProfesion().getProfId().longValue() == profesion.getProfId().longValue()
							&& d.getUdadMedId_UdadMed().getUdadMedId().longValue() == udadMed.getUdadMedId().longValue()
							&& d.getServicioId_Servicio().getCeptoNominaId().longValue() == servicio.getCeptoNominaId()
									.longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Ya éxiste una tarifa para esta labor en este rango de tiempo "
										+ "Verifie el periódo, labor, concepto, unidad de médida "));

						break;
					}
				}

			}

			if (existeProducto == false) {

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
			//	tarifaContratistaDTO.setCodProfesion(codProfesion);
			//	tarifaContratistaDTO.setProfesion(profesion);
				
				tarifaContratistaDTO.setCompania(compania);
				tarifaContratistaDTO.setFechaCreacion(fechaCreacion);
				tarifaContratistaDTO.setFechaModificacion(fechaModificacion);
				
				tarifaContratistaDTO.setEdadInicial(edadInicial);
				tarifaContratistaDTO.setEdadFinal(edadFinal);
			//	tarifaContratistaDTO.setPesoPromedio(pesoPromedio);
				tarifaContratistaDTO.setEstadoIncidencia(estadoIncidencia);
				tarifaContratistaDTO.setAlturaPlanta(alturaPlanta);
				
				tarifaContratistaDTO.setNivel2Id_Nivel2(nivel2Id);
				tarifaContratistaDTO.setNombreNivel2(nombreNivel2);
				tarifaContratistaDTO.setNivel4Id_Nivel4(nivel4Id);
				tarifaContratistaDTO.setNombreNivel4(nombreNivel4);
			
				dataTarifaContratista.add(tarifaContratistaDTO);

			}
			nivel2Id = null;
			nombreNivel2 = null;
			nivel4Id = null;
			nombreNivel4 = null;
			fechaInicial = null;
			fechaFinal = null;
			labor = null;
			servicio = null;
			udadMed = null;
			valorUnit = null;
			codLabor = null;
			codServicio = null;
			codUdadMed = null;
			//codProfesion = null;
			//profesion = null;
			edadInicial = null;
			edadFinal = null;
			//pesoPromedio = null;
			estadoIncidencia = null;
			alturaPlanta = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final, labor, profesión, concepto y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodProfesion() {

		Long profesionId = null;

		if (!txtProfId_Profesion1.getValue().equals("")) {
			profesionId = Long.parseLong(txtProfId_Profesion1.getValue().toString());

			try {
				Profesion profesion = businessDelegatorView.getProfesion(profesionId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtCodProfesion.setValue(profesion.getCodigo());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

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
				txtNivel4Nombre.setValue(nivel4.getNombre());
				txtNivel2Nombre.setValue(nivel2.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

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
			txtTablaPrecios.setDisabled(false);
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
			txtEsArlEpsPension.setDisabled(false);
			/*** sesion tarifa ***/
			txtValorUnit.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtServicioId_Servicio.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
		//	txtCodLabor.setDisabled(false);
		//	txtCodServicio.setDisabled(false);
		//	txtCodUdadMed.setDisabled(false);
			//txtCodProfesion.setDisabled(false);
			//txtProfId_Profesion1.setDisabled(false);
			btnAgregar.setDisabled(false);

			txtEdadInicial.setDisabled(false);
			txtEdadFinal.setDisabled(false);
			//txtPesoPromedio.setDisabled(false);
			txtEstadoIncidencia.setDisabled(false);
			txtAlturaPlanta.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id_Nivel2.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
		//	txtNivel2Nombre.setDisabled(false);;
		//	txtNivel4Nombre.setDisabled(false);
			txtPorcentajePagoFruto.setDisabled(false);
			
			btnSave.setDisabled(false);
		} else {
			txtPorcentajePagoFruto.setValue(entity.getPorcentajePagoFruto());
			txtPorcentajePagoFruto.setDisabled(false);

			txtTablaPrecios.setValue(entity.getTablaPrecios());
			txtTablaPrecios.setDisabled(false);
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
			txtEsArlEpsPension.setValue(entity.getEsArlEpsPension());
			txtEsArlEpsPension.setDisabled(false);
			txtPersEmprId.setValue(entity.getPersEmprId());
			txtPersEmprId.setDisabled(true);
			/*** sesion tarifa ***/
			txtValorUnit.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtServicioId_Servicio.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
		//	txtCodLabor.setDisabled(false);
		//	txtCodServicio.setDisabled(false);
		//	txtCodUdadMed.setDisabled(false);
			//txtCodProfesion.setDisabled(false);
			//txtProfId_Profesion1.setDisabled(false);
			btnAgregar.setDisabled(false);

			txtEdadInicial.setDisabled(false);
			txtEdadFinal.setDisabled(false);
			//txtPesoPromedio.setDisabled(false);
			txtEstadoIncidencia.setDisabled(false);
			txtAlturaPlanta.setDisabled(false);
			txtNivel1Id.setDisabled(false);
			txtNivel2Id_Nivel2.setDisabled(false);
			txtNivel3Id.setDisabled(false);
			txtNivel4Id_Nivel4.setDisabled(false);
		//	txtNivel2Nombre.setDisabled(false);;
		//	txtNivel4Nombre.setDisabled(false);
			
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
				txtPorcentajePagoFruto.setValue(entity.getPorcentajePagoFruto());
				txtPorcentajePagoFruto.setDisabled(false);
				txtTablaPrecios.setValue(entity.getTablaPrecios());
				txtTablaPrecios.setDisabled(false);
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
				txtEsArlEpsPension.setValue(entity.getEsArlEpsPension());
				txtEsArlEpsPension.setDisabled(false);
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
			//	txtCodLabor.setDisabled(false);
			//	txtCodServicio.setDisabled(false);
			//	txtCodUdadMed.setDisabled(false);
				//txtCodProfesion.setDisabled(false);
				//txtProfId_Profesion1.setDisabled(false);
				
				
				txtEdadInicial.setDisabled(false);
				txtEdadFinal.setDisabled(false);
			//	txtPesoPromedio.setDisabled(false);
				txtEstadoIncidencia.setDisabled(false);
				txtAlturaPlanta.setDisabled(false);
				txtNivel1Id.setDisabled(false);
				txtNivel2Id_Nivel2.setDisabled(false);
				txtNivel3Id.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);
			//	txtNivel2Nombre.setDisabled(false);;
			//	txtNivel4Nombre.setDisabled(false);
				
				btnAgregar.setDisabled(false);
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

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = null;

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
			entity.setEsArlEpsPension(FacesUtils.checkString(txtEsArlEpsPension));
			entity.setTablaPrecios(FacesUtils.checkString(txtTablaPrecios));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoPostal(FacesUtils.checkString(txtCodigoPostal));
			entity.setCompania(compania);
			entity.setPorcentajePagoFruto(FacesUtils.checkDouble(txtPorcentajePagoFruto));
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
			entity.setPorcentajePagoFruto(FacesUtils.checkDouble(txtPorcentajePagoFruto));
			entity.setEsArlEpsPension(FacesUtils.checkString(txtEsArlEpsPension));
			entity.setTablaPrecios(FacesUtils.checkString(txtTablaPrecios));
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
			action_clear();
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

	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
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

		if (selectItemCiudad == null || selectItemCiudad.length == 0) {

			try {
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

		if (selectItemEntBanc == null || selectItemEntBanc.length == 0) {

			try {
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

		if (selectItemProfesion == null || selectItemProfesion.length == 0) {

			try {
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

	public SelectItem[] getSelectLaborId() {

		if (selectLaborId == null || selectLaborId.length == 0) {

			try {
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

	public void setSelectLaborId(SelectItem[] selectLaborId) {
		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getSelectServicioId() {

		if (selectServicioId == null || selectServicioId.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
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

		if (selectUdadMed == null || selectUdadMed.length == 0) {

			try {
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
	
	public void onCellEdit(CellEditEvent event) throws Exception {

		selectedTarifaContratista = (TarifaContratistaDTO) (event.getComponent().getAttributes()
				.get("selectedTarifaContratista"));
		
		if (selectedTarifaContratista.getTarifaCtrId() != null) {

			Long TarifaCtrId = selectedTarifaContratista.getTarifaCtrId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
			
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTarifaContratista = null;
				Date fechaModificacion = new Date();
	
				entityTarifaContratista = businessDelegatorView.getTarifaContratista(TarifaCtrId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityTarifaContratista.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityTarifaContratista.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Labor")) {
	
					Long LaborId = new Long(event.getNewValue().toString());
					Labor labor = businessDelegatorView.getLabor(LaborId);
	
					entityTarifaContratista.setLabor(labor);
	
				} else if (columnaCell.equals("Concepto")) {
	
					Long servicioId = new Long(event.getNewValue().toString());
					ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(servicioId);
	
					entityTarifaContratista.setServicio(conceptoNomina);
					
				} else if (columnaCell.equals("U.M")) {
	
					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);
	
					entityTarifaContratista.setUdadMed(udadMed);
					
				} else if (columnaCell.equals("Edad Ini")) {
	
					entityTarifaContratista.setEdadInicial((Double) newValue);
	
				} else if (columnaCell.equals("Edad Fin")) {
	
					entityTarifaContratista.setEdadFinal((Double) newValue);
	
				} else if (columnaCell.equals("Estado")) {
	
					entityTarifaContratista.setEstadoIncidencia((String) newValue);
	
				} else if (columnaCell.equals("Altura mata")) {
	
					entityTarifaContratista.setAlturaPlanta((String) newValue);
	
				} else if (columnaCell.equals("Hda")) {
	
					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);
	
					entityTarifaContratista.setNivel2(Nivel2);
	
				}  else if (columnaCell.equals("Lote")) {
	
					Long nivel4Id = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4Id);
	
					entityTarifaContratista.setNivel4(Nivel4);
	
				} else if (columnaCell.equals("Tarifa")) {
	
					Double tarifa = new Double(event.getNewValue().toString());
	
					entityTarifaContratista.setTarifa(tarifa);
				}
	
				entity = businessDelegatorView.getPersEmpr(persEmprId);
				entityTarifaContratista.setPersEmpr(entity);
				entityTarifaContratista.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTarifaContratista(entityTarifaContratista);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataTarifaContratista = null;
				entityTarifaContratista = null;
				selectedTarifaContratista = null;
				entity = null;
	
				dataTarifaContratista = businessDelegatorView.getDataContratistaByTarifaContratistaId(persEmprId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}
	
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

	public SelectItem[] getSelectProfesion() {

		if (selectProfesion == null || selectProfesion.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Profesion> lista = businessDelegatorView.findByCriteriaInProfesion(condicion, null, null);
				selectProfesion = new SelectItem[lista.size()];

				int i = 0;
				for (Profesion profesion1 : lista) {
					selectProfesion[i] = new SelectItem(profesion1.getProfId(), profesion1.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProfesion;
	}

	public void setSelectProfesion(SelectItem[] selectProfesion) {
		this.selectProfesion = selectProfesion;
	}

	public InputText getTxtCodProfesion() {
		return txtCodProfesion;
	}

	public void setTxtCodProfesion(InputText txtCodProfesion) {
		this.txtCodProfesion = txtCodProfesion;
	}

	public SelectOneMenu getTxtProfId_Profesion1() {
		return txtProfId_Profesion1;
	}

	public void setTxtProfId_Profesion1(SelectOneMenu txtProfId_Profesion1) {
		this.txtProfId_Profesion1 = txtProfId_Profesion1;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtEdadInicial() {
		return txtEdadInicial;
	}

	public void setTxtEdadInicial(InputText txtEdadInicial) {
		this.txtEdadInicial = txtEdadInicial;
	}

	public InputText getTxtEdadFinal() {
		return txtEdadFinal;
	}

	public void setTxtEdadFinal(InputText txtEdadFinal) {
		this.txtEdadFinal = txtEdadFinal;
	}

	public InputText getTxtPesoPromedio() {
		return txtPesoPromedio;
	}

	public void setTxtPesoPromedio(InputText txtPesoPromedio) {
		this.txtPesoPromedio = txtPesoPromedio;
	}

	public SelectOneMenu getTxtEstadoIncidencia() {
		return txtEstadoIncidencia;
	}

	public void setTxtEstadoIncidencia(SelectOneMenu txtEstadoIncidencia) {
		this.txtEstadoIncidencia = txtEstadoIncidencia;
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
	

	public SelectItem[] getSelectNivel1() {

		if (selectNivel1 == null || selectNivel1.length == 0) {

			try {
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

	public void setSelectNivel1(SelectItem[] selectNivel1) {
		this.selectNivel1 = selectNivel1;
	}

	public SelectItem[] getSelectNivel2() {

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

	public void setSelectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	public SelectItem[] getSelectNivel3() {

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

	public void setSelectNivel3(SelectItem[] selectNivel3) {
		this.selectNivel3 = selectNivel3;
	}

	public SelectItem[] getSelectNivel4() {

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

	public void setSelectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}

	public SelectOneMenu getTxtAlturaPlanta() {
		return txtAlturaPlanta;
	}

	public void setTxtAlturaPlanta(SelectOneMenu txtAlturaPlanta) {
		this.txtAlturaPlanta = txtAlturaPlanta;
	}

	/**
	 * @return the txtPorcentajePagoFruto
	 */
	public Spinner getTxtPorcentajePagoFruto() {
		return txtPorcentajePagoFruto;
	}

	/**
	 * @param txtPorcentajePagoFruto the txtPorcentajePagoFruto to set
	 */
	public void setTxtPorcentajePagoFruto(Spinner txtPorcentajePagoFruto) {
		this.txtPorcentajePagoFruto = txtPorcentajePagoFruto;
	}
	
	public SelectItem[] getSelectNivel2Edit() {

		if (selectNivel2Edit == null || selectNivel2Edit.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Edit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Edit : lista) {
					selectNivel2Edit[i] = new SelectItem(nivel2Edit.getNivel2Id(), nivel2Edit.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Edit;
	}


	public void setSelectNivel2Edit(SelectItem[] selectNivel2Edit) {
		this.selectNivel2Edit = selectNivel2Edit;
	}
	
	public SelectItem[] getSelectNivel4Edit() {

		if (selectNivel4Edit == null || selectNivel4Edit.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4Edit = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4Edit : lista) {
					selectNivel4Edit[i] = new SelectItem(nivel4Edit.getNivel4Id(), nivel4Edit.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4Edit;
	}


	public void setSelectNivel4Edit(SelectItem[] selectNivel4Edit) {
		this.selectNivel4Edit = selectNivel4Edit;
	}

	public SelectOneMenu getTxtTablaPrecios() {
		return txtTablaPrecios;
	}

	public void setTxtTablaPrecios(SelectOneMenu txtTablaPrecios) {
		this.txtTablaPrecios = txtTablaPrecios;
	}

	public SelectOneRadio getTxtEsArlEpsPension() {
		return txtEsArlEpsPension;
	}

	public void setTxtEsArlEpsPension(SelectOneRadio txtEsArlEpsPension) {
		this.txtEsArlEpsPension = txtEsArlEpsPension;
	}
}