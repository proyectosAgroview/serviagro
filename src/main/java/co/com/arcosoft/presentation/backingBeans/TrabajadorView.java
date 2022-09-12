package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.EntBanc;
import co.com.arcosoft.modelo.EquipoTrabajo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.SubTipoCotizante;
import co.com.arcosoft.modelo.TarifaDeduccion;
import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.TarifasArl;
import co.com.arcosoft.modelo.TipoCotizante;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.TarifaDeduccionDTO;
import co.com.arcosoft.modelo.dto.TarifaOtrosDevengosDTO;
import co.com.arcosoft.modelo.dto.TrabajadorDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TrabajadorView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(TrabajadorView.class);
	private InputText txtCodigo;
	private SelectOneRadio txtClaseContrato;
	private InputText txtCompania;
	private InputText txtEmail;
	private InputText txtNIdentificacion;
	private SelectOneMenu txtEstadoCivil;
	private InputText txtDireccion;
	private SelectOneRadio txtEstado;
	private InputText txtFoto;
	private SelectOneRadio txtGenero;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtPrimerApellido;
	private InputText txtPrimerNombre;
	private InputText txtSegundoApellido;
	private InputText txtSegundoNombre;
	private InputText txtTelefono;
	private InputText txtUbicacion;
	private InputText txtTrabId;
	private Calendar txtFechaAdmision;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaNacimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private LazyDataModel<TrabajadorDTO> data;
	private TrabajadorDTO selectedTrabajador;
	private Trabajador entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtContratistaId_Contratista;
	SelectItem[] selectContratista;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;

	private SelectOneMenu txtCiudadId_Ciudad;
	SelectItem[] selectCiudad;

	private SelectOneMenu txtEqpTrabId_EquipoTrabajo;
	SelectItem[] selectEquipoTrabajo;

	private SelectOneMenu txtProfId_Profesion;
	SelectItem[] selectProfesion;

	private String txtImagenTrabajador;
	private String imagenTrabajador;
	private UploadedFile file;

	/********* Deducciones ***/

	private SelectOneMenu txtCeptoNominaIdDeducciones;
	SelectItem[] selectCeptoNomina1;

	private Calendar txtFechaInicial1;
	private Calendar txtFechaFinal1;
	private InputText txtTarifaDeduccion;

	private List<TarifaDeduccionDTO> dataTarifaDeduccion;
	private TarifaDeduccionDTO selectedTarifaDeduccion;
	private InputText txtCodConceptDeduccion;

	private CommandButton btnAgregar1;

	/**** Otros devengos ****/

	private SelectOneMenu txtCeptoNominaIdDevengos;
	SelectItem[] selectCeptoNomina2;

	private Calendar txtFechaInicial2;
	private Calendar txtFechaFinal2;
	private InputText txtTarifaDevengos;
	private InputText txtCodConceptDevengo;

	private List<TarifaOtrosDevengosDTO> dataTarifaDevengos;
	private TarifaOtrosDevengosDTO selectedTarifaDevengos;

	private CommandButton btnAgregar2;

	private SelectOneMenu txtCeptoNominaAlternativo;
	SelectItem[] selectCeptoNomina3;

	private InputText txtCodConceptoAlternativo;
	private SelectOneRadio txtGeneraDomingosFestivos;
	private SelectOneRadio txtGeneraAuxilioTransp;
	private InputText txtHorasDia;
	private InputText txtHorasMes;
	private SelectOneRadio txtGeneraAuxilioAdmon;
	private int activeTapIndex = 0;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;

	private SelectOneMenu txtEntBancId_EntBanc;
	SelectItem[] selectEntBanc;

	private TarifaOtrosDevengos entityTarifaDevengos;
	private TarifaDeduccion entityTarifaDeduccion;

	private SelectOneMenu txtOrigenDatos;
	private String moduloActivo;
	private String modulo;

	private InputText txtBarrio;
	private SelectOneMenu txtTipo_vivienda;
	private InputText txtCelular;
	private SelectOneMenu txtTipo_licencia_conduccion;
	private InputText txtNumero_licencia_conduccion;
	private InputText txtNum_pasado_judicial;
	private InputText txtNum_tarjeta_profesional;
	private SelectOneMenu txtTipo_sangre;
	private InputTextarea txtNombre_eps;
	private InputTextarea txtNombre_fondo_pension;
	private InputTextarea txtNombre_fondo_cesantias;
	private InputTextarea txtNombre_arp;
	private InputTextarea txtNombre_caja_compensacion;
	private InputText txtNumero_cuenta_bancaria;
	private SelectOneMenu txtEnt_banc_id;
	private SelectOneMenu txtTipo_cuenta_bancaria;
	private InputTextarea txtNombres_conyugue;
	private Spinner txtNumero_hijos;
	private InputTextarea txtContacto_emergencia;
	private SelectOneMenu txtContacto_emergencia_parentesco;
	private SelectOneMenu txtEstudio_bachillerato;
	private InputTextarea txtEstudio_bachillerato_entidad;
	private SelectOneMenu txtEstudio_tecnico;
	private InputTextarea txtEstudio_tecnico_titulo;
	private InputTextarea txtEstudio_tecnico_entidad;
	private SelectOneMenu txtEstudio_tecnologico;
	private InputTextarea txtEstudio_tecnologico_titulo;
	private InputTextarea txtEstudio_tecnologico_entidad;
	private SelectOneMenu txtEstudio_pregrado;
	private InputTextarea txtEstudio_pregrado_titulo;
	private InputTextarea txtEstudio_pregrado_entidad;
	private SelectOneMenu txtEstudio_potsgrado;
	private InputTextarea txtEstudio_potsgrado_titulo;
	private InputTextarea txtEstudio_potsgrado_entidad;
	private SelectOneMenu txtEstudio_otros;
	private InputTextarea txtEstudio_otros_titulo;
	private InputTextarea txtEstudio_otros_entidad;
	private InputTextarea txtPecargo1_nombre;
	private SelectOneMenu txtPecargo1_parentesco;
	private Spinner txtPecargo1_edad;
	private SelectOneMenu txtPecargo1_niveleducativo;
	private InputTextarea txtPecargo2_nombre;
	private SelectOneMenu txtPecargo2_parentesco;
	private Spinner txtPecargo2_edad;
	private SelectOneMenu txtPecargo2_niveleducativo;
	private InputTextarea txtPecargo3_nombre;
	private SelectOneMenu txtPecargo3_parentesco;
	private Spinner txtPecargo3_edad;
	private SelectOneMenu txtPecargo3_niveleducativo;
	private InputTextarea txtPecargo4_nombre;
	private SelectOneMenu txtPecargo4_parentesco;
	private Spinner txtPecargo4_edad;
	private SelectOneMenu txtPecargo4_niveleducativo;
	private InputTextarea txtPecargo5_nombre;
	private SelectOneMenu txtPecargo5_parentesco;
	private Spinner txtPecargo5_edad;
	private SelectOneMenu txtPecargo5_niveleducativo;
	private InputNumber txtSalario;
	
	private SelectOneMenu txtUsuarioAsociado;
	SelectItem[] selectUsuarioId;

	private SelectOneMenu txtTipoTrabajador;
	
	/*** ***** 07-07-2020 ***** ***/
	
	private SelectOneMenu txtTipoCotizante;
	SelectItem[] selectTipoCotizante;
	
	private SelectOneMenu txtEpsActual;
	SelectItem[] selectEpsActual;
	
	private SelectOneMenu txtEpsAnterior;
	SelectItem[] selectEpsAnterior;
	
	private SelectOneMenu txtSubTipoCotizante;
	SelectItem[] selectSubTipoCotizante;
	
	private SelectOneMenu txtAfpActual;
	SelectItem[] selectAfpActual;
	
	private SelectOneMenu txtAfpAnterior;
	SelectItem[] selectAfpAnterior;
	
	private SelectOneMenu txtCajaCompensacion;
	SelectItem[] selectCajaCompensacion;
	
	private SelectOneMenu txtArl;
	SelectItem[] selectArl;
	
	private SelectOneMenu txtFondoCesantias;
	SelectItem[] selectFondoCesantias;
	
	private SelectBooleanCheckbox txtAportaEps;
	private SelectBooleanCheckbox txtEmpleadorAportaEps;	
	private Calendar txtFechaInicioEps;	
	private SelectBooleanCheckbox txtAportaAfp;	
	private Calendar txtFechaInicioAfp;
	private SelectBooleanCheckbox txtAportaCcf;
	private SelectBooleanCheckbox txtAportaArl;
	private SelectBooleanCheckbox txtAportaIcbf;
	private SelectBooleanCheckbox txtAportaSena;
	private SelectBooleanCheckbox txtAltoRiesgo;
	private InputNumber txtTarifaCajaCompensacion;
	private SelectOneMenu txtClaseTarifaArl;
	private InputNumber txtTarifaArl;
	private InputNumber txtTarifaIcbf;
	private InputNumber txtTarifaSena;
	
	private SelectOneMenu txtTarifasArlId;
	SelectItem[] selectTarifasArlId;
	
	private Calendar txtFechaRetiro;
	
	
	
	/***********************/
	public TrabajadorView() {
		super();
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();
			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			txtOrigenDatos.setValue("Modulo_TallerAgricola");
			txtOrigenDatos.setDisabled(false);
			modulo = "Mtto_Maquinaria";

		}

		if (moduloActivo.equals("admin_agricola")) {

			txtOrigenDatos.setValue("Modulo_AdminAgricola");
			txtOrigenDatos.setDisabled(false);
			modulo = "Admin_Agricola";

		}

		if (moduloActivo.equals("prod_agricola")) {

			txtOrigenDatos.setValue("Modulo_AdminAgricola");
			txtOrigenDatos.setDisabled(false);
			modulo = "Admin_Agricola";

		}

		if (moduloActivo.equals("mantenimiento_industrial")) {

			txtOrigenDatos.setValue("Modulo_MttoIndustrial");
			txtOrigenDatos.setDisabled(false);
			modulo = "Mtto_Industial";

		}
	}

	public String action_new() {
		action_clear();
		selectedTrabajador = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTrabajador = null;
		PrimeFaces.current().resetInputs(":frm");
		moduloSeleccionado();
		activeTapIndex = 0;


		if (txtTipoTrabajador != null) {
			txtTipoTrabajador.setValue(null);
			txtTipoTrabajador.setDisabled(false);
		}
		

		if (txtTarifasArlId != null) {
			txtTarifasArlId.setValue(null);
			txtTarifasArlId.setDisabled(true);
		}
		
		
		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtFechaRetiro != null) {
			txtFechaRetiro.setValue(null);
			txtFechaRetiro.setDisabled(true);
		}
		if (txtSalario != null) {
			txtSalario.setValue(null);
			txtSalario.setDisabled(true);
		}

		if (txtUsuarioAsociado != null) {
			txtUsuarioAsociado.setValue(null);
			txtUsuarioAsociado.setDisabled(true);
		}
		
		
		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setDisabled(true);
		}

		if (txtUbicacion != null) {
			txtUbicacion.setValue(null);
			txtUbicacion.setDisabled(true);
		}
		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(true);
		}
		
		if (txtNIdentificacion != null) {
			txtNIdentificacion.setValue(null);
			txtNIdentificacion.setDisabled(true);
		}
		
		if (txtEstadoCivil != null) {
			txtEstadoCivil.setValue(null);
			txtEstadoCivil.setDisabled(true);
		}

		if (txtClaseContrato != null) {
			txtClaseContrato.setValue(null);
			txtClaseContrato.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtFoto != null) {
			txtFoto.setValue(null);
			txtFoto.setDisabled(true);
		}

		if (txtGenero != null) {
			txtGenero.setValue(null);
			txtGenero.setDisabled(true);
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

		if (txtPrimerApellido != null) {
			txtPrimerApellido.setValue(null);
			txtPrimerApellido.setDisabled(true);
		}

		if (txtPrimerNombre != null) {
			txtPrimerNombre.setValue(null);
			txtPrimerNombre.setDisabled(true);
		}

		if (txtSegundoApellido != null) {
			txtSegundoApellido.setValue(null);
			txtSegundoApellido.setDisabled(true);
		}

		if (txtSegundoNombre != null) {
			txtSegundoNombre.setValue(null);
			txtSegundoNombre.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(true);
		}

		if (txtCiudadId_Ciudad != null) {
			txtCiudadId_Ciudad.setValue(null);
			txtCiudadId_Ciudad.setDisabled(true);
		}

		if (txtContratistaId_Contratista != null) {
			txtContratistaId_Contratista.setValue(null);
			txtContratistaId_Contratista.setDisabled(true);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(false);
		}

		if (txtProfId_Profesion != null) {
			txtProfId_Profesion.setValue(null);
			txtProfId_Profesion.setDisabled(true);
		}

		if (txtFechaAdmision != null) {
			txtFechaAdmision.setValue(null);
			txtFechaAdmision.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaNacimiento != null) {
			txtFechaNacimiento.setValue(null);
			txtFechaNacimiento.setDisabled(true);
		}

		if (txtTrabId != null) {
			txtTrabId.setValue(null);
			txtTrabId.setDisabled(false);
		}

		if (txtTipoCotizante != null) {
			txtTipoCotizante.setValue(null);
			txtTipoCotizante.setDisabled(true);
		}

		if (txtSubTipoCotizante != null) {
			txtSubTipoCotizante.setValue(null);
			txtSubTipoCotizante.setDisabled(true);
		}

		if (txtEpsActual != null) {
			txtEpsActual.setValue(null);
			txtEpsActual.setDisabled(true);
		}

		if (txtEpsAnterior != null) {
			txtEpsAnterior.setValue(null);
			txtEpsAnterior.setDisabled(true);
		}

		if (txtAfpActual != null) {
			txtAfpActual.setValue(null);
			txtAfpActual.setDisabled(true);
		}

		if (txtAfpAnterior != null) {
			txtAfpAnterior.setValue(null);
			txtAfpAnterior.setDisabled(true);
		}

		if (txtCajaCompensacion != null) {
			txtCajaCompensacion.setValue(null);
			txtCajaCompensacion.setDisabled(true);
		}

		if (txtArl != null) {
			txtArl.setValue(null);
			txtArl.setDisabled(true);
		}

		if (txtFondoCesantias != null) {
			txtFondoCesantias.setValue(null);
			txtFondoCesantias.setDisabled(true);
		}

		if (txtAportaEps != null) {
			txtAportaEps.setValue(null);
			txtAportaEps.setDisabled(true);
		}

		if (txtEmpleadorAportaEps != null) {
			txtEmpleadorAportaEps.setValue(null);
			txtEmpleadorAportaEps.setDisabled(true);
		}

		if (txtFechaInicioEps != null) {
			txtFechaInicioEps.setValue(null);
			txtFechaInicioEps.setDisabled(true);
		}

		if (txtAportaAfp != null) {
			txtAportaAfp.setValue(null);
			txtAportaAfp.setDisabled(true);
		}

		if (txtFechaInicioAfp != null) {
			txtFechaInicioAfp.setValue(null);
			txtFechaInicioAfp.setDisabled(true);
		}

		if (txtAportaCcf != null) {
			txtAportaCcf.setValue(null);
			txtAportaCcf.setDisabled(true);
		}

		if (txtAportaArl != null) {
			txtAportaArl.setValue(null);
			txtAportaArl.setDisabled(true);
		}

		if (txtAportaIcbf != null) {
			txtAportaIcbf.setValue(null);
			txtAportaIcbf.setDisabled(true);
		}

		if (txtAportaSena != null) {
			txtAportaSena.setValue(null);
			txtAportaSena.setDisabled(true);
		}

		if (txtAltoRiesgo != null) {
			txtAltoRiesgo.setValue(null);
			txtAltoRiesgo.setDisabled(true);
		}

		if (txtTarifaCajaCompensacion != null) {
			txtTarifaCajaCompensacion.setValue(null);
			txtTarifaCajaCompensacion.setDisabled(true);
		}

		if (txtClaseTarifaArl != null) {
			txtClaseTarifaArl.setValue(null);
			txtClaseTarifaArl.setDisabled(true);
		}

		if (txtTarifaArl != null) {
			txtTarifaArl.setValue(null);
			txtTarifaArl.setDisabled(true);
		}

		if (txtTarifaIcbf != null) {
			txtTarifaIcbf.setValue(null);
			txtTarifaIcbf.setDisabled(true);
		}

		if (txtTarifaSena != null) {
			txtTarifaSena.setValue(null);
			txtTarifaSena.setDisabled(true);
		}

		/******* deduccion *******/

		if (txtCeptoNominaIdDeducciones != null) {
			txtCeptoNominaIdDeducciones.setValue(null);
			txtCeptoNominaIdDeducciones.setDisabled(true);
		}

		if (txtFechaInicial1 != null) {
			txtFechaInicial1.setValue(null);
			txtFechaInicial1.setDisabled(true);
		}

		if (txtFechaFinal1 != null) {
			txtFechaFinal1.setValue(null);
			txtFechaFinal1.setDisabled(true);
		}

		if (txtTarifaDeduccion != null) {
			txtTarifaDeduccion.setValue(null);
			txtTarifaDeduccion.setDisabled(true);
		}

		if (btnAgregar1 != null) {
			btnAgregar1.setDisabled(true);
		}

		if (dataTarifaDeduccion != null) {
			dataTarifaDeduccion = null;
		}
		
		/*** devengos *****************/

		if (txtCeptoNominaIdDevengos != null) {
			txtCeptoNominaIdDevengos.setValue(null);
			txtCeptoNominaIdDevengos.setDisabled(true);
		}

		if (txtFechaInicial2 != null) {
			txtFechaInicial2.setValue(null);
			txtFechaInicial2.setDisabled(true);
		}

		if (txtFechaFinal2 != null) {
			txtFechaFinal2.setValue(null);
			txtFechaFinal2.setDisabled(true);
		}

		if (txtTarifaDevengos != null) {
			txtTarifaDevengos.setValue(null);
			txtTarifaDevengos.setDisabled(true);
		}

		if (txtCeptoNominaAlternativo != null) {
			txtCeptoNominaAlternativo.setValue(null);
			txtCeptoNominaAlternativo.setDisabled(true);
		}
		if (txtGeneraDomingosFestivos != null) {
			txtGeneraDomingosFestivos.setValue("A");
			txtGeneraDomingosFestivos.setDisabled(true);
		}
		if (txtGeneraAuxilioTransp != null) {
			txtGeneraAuxilioTransp.setValue("A");
			txtGeneraAuxilioTransp.setDisabled(true);
		}
		if (txtGeneraAuxilioAdmon != null) {
			txtGeneraAuxilioAdmon.setValue("A");
			txtGeneraAuxilioAdmon.setDisabled(true);
		}
		if (txtHorasDia != null) {
			txtHorasDia.setValue(0);
			txtHorasDia.setDisabled(true);
		}
		if (txtHorasMes != null) {
			txtHorasMes.setValue(0);
			txtHorasMes.setDisabled(true);
		}

		if (btnAgregar2 != null) {
			btnAgregar2.setDisabled(true);
		}

		if (dataTarifaDevengos != null) {
			dataTarifaDevengos = null;
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		if (txtBarrio != null) {
			txtBarrio.setValue(null);
			txtBarrio.setDisabled(true);
		}
		if (txtTipo_vivienda != null) {
			txtTipo_vivienda.setValue(null);
			txtTipo_vivienda.setDisabled(true);
		}
		if (txtCelular != null) {
			txtCelular.setValue(null);
			txtCelular.setDisabled(true);
		}
		if (txtTipo_licencia_conduccion != null) {
			txtTipo_licencia_conduccion.setValue(null);
			txtTipo_licencia_conduccion.setDisabled(true);
		}
		if (txtNumero_licencia_conduccion != null) {
			txtNumero_licencia_conduccion.setValue(null);
			txtNumero_licencia_conduccion.setDisabled(true);
		}
		if (txtNum_pasado_judicial != null) {
			txtNum_pasado_judicial.setValue(null);
			txtNum_pasado_judicial.setDisabled(true);
		}
		if (txtNum_tarjeta_profesional != null) {
			txtNum_tarjeta_profesional.setValue(null);
			txtNum_tarjeta_profesional.setDisabled(true);
		}
		if (txtTipo_sangre != null) {
			txtTipo_sangre.setValue(null);
			txtTipo_sangre.setDisabled(true);
		}
		if (txtNombre_eps != null) {
			txtNombre_eps.setValue(null);
			txtNombre_eps.setDisabled(true);
		}
		if (txtNombre_fondo_pension != null) {
			txtNombre_fondo_pension.setValue(null);
			txtNombre_fondo_pension.setDisabled(true);
		}
		if (txtNombre_fondo_cesantias != null) {
			txtNombre_fondo_cesantias.setValue(null);
			txtNombre_fondo_cesantias.setDisabled(true);
		}
		if (txtNombre_arp != null) {
			txtNombre_arp.setValue(null);
			txtNombre_arp.setDisabled(true);
		}
		if (txtNombre_caja_compensacion != null) {
			txtNombre_caja_compensacion.setValue(null);
			txtNombre_caja_compensacion.setDisabled(true);
		}
		if (txtNumero_cuenta_bancaria != null) {
			txtNumero_cuenta_bancaria.setValue(null);
			txtNumero_cuenta_bancaria.setDisabled(true);
		}
		if (txtEnt_banc_id != null) {
			txtEnt_banc_id.setValue(null);
			txtEnt_banc_id.setDisabled(true);
		}
		if (txtTipo_cuenta_bancaria != null) {
			txtTipo_cuenta_bancaria.setValue(null);
			txtTipo_cuenta_bancaria.setDisabled(true);
		}
		if (txtNombres_conyugue != null) {
			txtNombres_conyugue.setValue(null);
			txtNombres_conyugue.setDisabled(true);
		}
		if (txtNumero_hijos != null) {
			txtNumero_hijos.setValue(null);
			txtNumero_hijos.setDisabled(true);
		}
		if (txtContacto_emergencia != null) {
			txtContacto_emergencia.setValue(null);
			txtContacto_emergencia.setDisabled(true);
		}
		if (txtContacto_emergencia_parentesco != null) {
			txtContacto_emergencia_parentesco.setValue(null);
			txtContacto_emergencia_parentesco.setDisabled(true);
		}
		if (txtEstudio_bachillerato != null) {
			txtEstudio_bachillerato.setValue(null);
			txtEstudio_bachillerato.setDisabled(true);
		}
		if (txtEstudio_bachillerato_entidad != null) {
			txtEstudio_bachillerato_entidad.setValue(null);
			txtEstudio_bachillerato_entidad.setDisabled(true);
		}
		if (txtEstudio_tecnico != null) {
			txtEstudio_tecnico.setValue(null);
			txtEstudio_tecnico.setDisabled(true);
		}
		if (txtEstudio_tecnico_titulo != null) {
			txtEstudio_tecnico_titulo.setValue(null);
			txtEstudio_tecnico_titulo.setDisabled(true);
		}
		if (txtEstudio_tecnico_entidad != null) {
			txtEstudio_tecnico_entidad.setValue(null);
			txtEstudio_tecnico_entidad.setDisabled(true);
		}
		if (txtEstudio_tecnologico != null) {
			txtEstudio_tecnologico.setValue(null);
			txtEstudio_tecnologico.setDisabled(true);
		}
		if (txtEstudio_tecnologico_titulo != null) {
			txtEstudio_tecnologico_titulo.setValue(null);
			txtEstudio_tecnologico_titulo.setDisabled(true);
		}
		if (txtEstudio_tecnologico_entidad != null) {
			txtEstudio_tecnologico_entidad.setValue(null);
			txtEstudio_tecnologico_entidad.setDisabled(true);
		}
		if (txtEstudio_pregrado != null) {
			txtEstudio_pregrado.setValue(null);
			txtEstudio_pregrado.setDisabled(true);
		}
		if (txtEstudio_pregrado_titulo != null) {
			txtEstudio_pregrado_titulo.setValue(null);
			txtEstudio_pregrado_titulo.setDisabled(true);
		}
		if (txtEstudio_pregrado_entidad != null) {
			txtEstudio_pregrado_entidad.setValue(null);
			txtEstudio_pregrado_entidad.setDisabled(true);
		}
		if (txtEstudio_potsgrado != null) {
			txtEstudio_potsgrado.setValue(null);
			txtEstudio_potsgrado.setDisabled(true);
		}
		if (txtEstudio_potsgrado_titulo != null) {
			txtEstudio_potsgrado_titulo.setValue(null);
			txtEstudio_potsgrado_titulo.setDisabled(true);
		}
		if (txtEstudio_potsgrado_entidad != null) {
			txtEstudio_potsgrado_entidad.setValue(null);
			txtEstudio_potsgrado_entidad.setDisabled(true);
		}
		if (txtEstudio_otros != null) {
			txtEstudio_otros.setValue(null);
			txtEstudio_otros.setDisabled(true);
		}
		if (txtEstudio_otros_titulo != null) {
			txtEstudio_otros_titulo.setValue(null);
			txtEstudio_otros_titulo.setDisabled(true);
		}
		if (txtEstudio_otros_entidad != null) {
			txtEstudio_otros_entidad.setValue(null);
			txtEstudio_otros_entidad.setDisabled(true);
		}
		if (txtPecargo1_nombre != null) {
			txtPecargo1_nombre.setValue(null);
			txtPecargo1_nombre.setDisabled(true);
		}
		if (txtPecargo1_parentesco != null) {
			txtPecargo1_parentesco.setValue(null);
			txtPecargo1_parentesco.setDisabled(true);
		}
		if (txtPecargo1_edad != null) {
			txtPecargo1_edad.setValue(null);
			txtPecargo1_edad.setDisabled(true);
		}
		if (txtPecargo1_niveleducativo != null) {
			txtPecargo1_niveleducativo.setValue(null);
			txtPecargo1_niveleducativo.setDisabled(true);
		}
		if (txtPecargo2_nombre != null) {
			txtPecargo2_nombre.setValue(null);
			txtPecargo2_nombre.setDisabled(true);
		}
		if (txtPecargo2_parentesco != null) {
			txtPecargo2_parentesco.setValue(null);
			txtPecargo2_parentesco.setDisabled(true);
		}
		if (txtPecargo2_edad != null) {
			txtPecargo2_edad.setValue(null);
			txtPecargo2_edad.setDisabled(true);
		}
		if (txtPecargo2_niveleducativo != null) {
			txtPecargo2_niveleducativo.setValue(null);
			txtPecargo2_niveleducativo.setDisabled(true);
		}
		if (txtPecargo3_nombre != null) {
			txtPecargo3_nombre.setValue(null);
			txtPecargo3_nombre.setDisabled(true);
		}
		if (txtPecargo3_parentesco != null) {
			txtPecargo3_parentesco.setValue(null);
			txtPecargo3_parentesco.setDisabled(true);
		}
		if (txtPecargo3_edad != null) {
			txtPecargo3_edad.setValue(null);
			txtPecargo3_edad.setDisabled(true);
		}
		if (txtPecargo3_niveleducativo != null) {
			txtPecargo3_niveleducativo.setValue(null);
			txtPecargo3_niveleducativo.setDisabled(true);
		}
		if (txtPecargo4_nombre != null) {
			txtPecargo4_nombre.setValue(null);
			txtPecargo4_nombre.setDisabled(true);
		}
		if (txtPecargo4_parentesco != null) {
			txtPecargo4_parentesco.setValue(null);
			txtPecargo4_parentesco.setDisabled(true);
		}
		if (txtPecargo4_edad != null) {
			txtPecargo4_edad.setValue(null);
			txtPecargo4_edad.setDisabled(true);
		}
		if (txtPecargo4_niveleducativo != null) {
			txtPecargo4_niveleducativo.setValue(null);
			txtPecargo4_niveleducativo.setDisabled(true);
		}
		if (txtPecargo5_nombre != null) {
			txtPecargo5_nombre.setValue(null);
			txtPecargo5_nombre.setDisabled(true);
		}
		if (txtPecargo5_parentesco != null) {
			txtPecargo5_parentesco.setValue(null);
			txtPecargo5_parentesco.setDisabled(true);
		}
		if (txtPecargo5_edad != null) {
			txtPecargo5_edad.setValue(null);
			txtPecargo5_edad.setDisabled(true);
		}
		if (txtPecargo5_niveleducativo != null) {
			txtPecargo5_niveleducativo.setValue(null);
			txtPecargo5_niveleducativo.setDisabled(true);
		}

		return "";
	}

	public void action_agregarTarifaDeduccion() throws Exception {
		
		if (txtFechaInicial1.getValue() != null && txtFechaInicial1.getValue() != null && 
			txtCeptoNominaIdDeducciones.getValue() != null && txtTarifaDeduccion.getValue() != null) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial1));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal1));

			Long conceptoPagoId = Long.parseLong(txtCeptoNominaIdDeducciones.getValue().toString());
			ConceptoNomina conceptoPago = businessDelegatorView.getConceptoNomina(conceptoPagoId);
			String codConceptoNomina = FacesUtils.checkString(txtCodConceptDeduccion);
			String estado = "A";

			Double valorUnit = FacesUtils.checkDouble(txtTarifaDeduccion);
			Long compania = new Long(getCompaniaIdSession());
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();

			boolean existeProducto = false;
			if (dataTarifaDeduccion == null) {
				dataTarifaDeduccion = new ArrayList<TarifaDeduccionDTO>();
			}

			if (dataTarifaDeduccion.size() > 0) {

				for (TarifaDeduccionDTO d : dataTarifaDeduccion) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getConceptoNominaId().getCeptoNominaId().longValue() == conceptoPago.getCeptoNominaId().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
							"Ya  fue incluido el concepto de nómina en este rango de tiempo. Verifie el periódo y el  concepto "));

						break;
					}
				}
			}

			if (existeProducto == false) {
				TarifaDeduccionDTO tarifaDeduccionDTO = new TarifaDeduccionDTO();
				tarifaDeduccionDTO.setFechaInicial(fechaInicial);
				tarifaDeduccionDTO.setFechaFinal(fechaFinal);
				tarifaDeduccionDTO.setCodConceptoNomina(codConceptoNomina);
				tarifaDeduccionDTO.setConceptoNominaId(conceptoPago);
				tarifaDeduccionDTO.setValorDeduccion(valorUnit);
				tarifaDeduccionDTO.setCompania(compania);
				tarifaDeduccionDTO.setFechaCreacion(fechaCreacion);
				tarifaDeduccionDTO.setFechaModificacion(fechaModificacion);
				tarifaDeduccionDTO.setEstado(estado);

				dataTarifaDeduccion.add(tarifaDeduccionDTO);
			}
			
			fechaInicial = null;
			fechaFinal = null;
			conceptoPago = null;
			valorUnit = null;
			fechaCreacion = null;
			fechaModificacion = null;
			codConceptoNomina = null;
			estado = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  fecha inicial, fecha final, concepto, tarifa tengan valores. "));
		}
	}

	public void action_agregarTarifaDevengos() throws Exception {
		if (txtFechaInicial2.getValue() != null && txtFechaFinal2.getValue() != null && 
			txtCeptoNominaIdDevengos.getValue() != null && txtTarifaDevengos.getValue() != null ) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial2));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal2));

			Long conceptoPagoId = Long.parseLong(txtCeptoNominaIdDevengos.getValue().toString());
			ConceptoNomina conceptoPago = businessDelegatorView.getConceptoNomina(conceptoPagoId);
			String codConceptoNomina = conceptoPago.getCodigo();
			String estado = "A";

			Double valorUnit = FacesUtils.checkDouble(txtTarifaDevengos);
			Long compania = new Long(getCompaniaIdSession());
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();
			boolean existeProducto = false;

			String generaDomingosFestivos ="";// FacesUtils.checkString(txtGeneraDomingosFestivos);
			String generaAuxilioTransp ="";//=FacesUtils.checkString(txtGeneraAuxilioTransp);
			String generaAuxilioAdmon ="";// FacesUtils.checkString(txtGeneraAuxilioAdmon);

			Double horasDia = 0.0;//FacesUtils.checkDouble(txtHorasDia);
			Double horasMes =0.0; //FacesUtils.checkDouble(txtHorasMes);
		//	Long conceptoAlternativoId = Long.parseLong(txtCeptoNominaAlternativo.getValue().toString());
		//	ConceptoNomina conceptoAlternativo = businessDelegatorView.getConceptoNomina(conceptoAlternativoId);
		//	String codConceptoAlternativo = conceptoAlternativo.getCodigo();

			if (dataTarifaDevengos == null) {
				dataTarifaDevengos = new ArrayList<TarifaOtrosDevengosDTO>();
			}

			if (dataTarifaDevengos.size() > 0) {

				for (TarifaOtrosDevengosDTO d : dataTarifaDevengos) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getConceptoNominaId().getCeptoNominaId().longValue() == conceptoPago.getCeptoNominaId().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
							"Ya  fue incluido el concepto de nómina en este rango de tiempo. Verifie el periódo y el  concepto "));

						break;
					}
				}
			}

			if (existeProducto == false) {

				TarifaOtrosDevengosDTO tarifaOtrosDevengosDTO = new TarifaOtrosDevengosDTO();
				tarifaOtrosDevengosDTO.setFechaInicial(fechaInicial);
				tarifaOtrosDevengosDTO.setFechaFinal(fechaFinal);
				tarifaOtrosDevengosDTO.setCodConceptoNomina(codConceptoNomina);
				tarifaOtrosDevengosDTO.setConceptoNominaId(conceptoPago);
				tarifaOtrosDevengosDTO.setValorDeduccion(valorUnit);
				tarifaOtrosDevengosDTO.setCompania(compania);
				tarifaOtrosDevengosDTO.setFechaCreacion(fechaCreacion);
				tarifaOtrosDevengosDTO.setFechaModificacion(fechaModificacion);
				tarifaOtrosDevengosDTO.setEstado(estado);
				tarifaOtrosDevengosDTO.setGeneraDomingosFestivos(generaDomingosFestivos);
				tarifaOtrosDevengosDTO.setGeneraAuxilioTransp(generaAuxilioTransp);
				tarifaOtrosDevengosDTO.setHorasDia(horasDia);
				tarifaOtrosDevengosDTO.setHorasMes(horasMes);
			//	tarifaOtrosDevengosDTO.setCeptoNominaAlternativo(conceptoAlternativo);
			//	tarifaOtrosDevengosDTO.setCodConceptoAlternativo(codConceptoAlternativo);
				tarifaOtrosDevengosDTO.setGeneraAuxilioAdmon(generaAuxilioAdmon);

				dataTarifaDevengos.add(tarifaOtrosDevengosDTO);
			}
			
			fechaInicial = null;
			fechaFinal = null;
			conceptoPago = null;
			valorUnit = null;
			fechaCreacion = null;
			fechaModificacion = null;
			codConceptoNomina = null;
			estado = null;
			generaDomingosFestivos = null;
			generaAuxilioTransp = null;
			horasDia = null;
			horasMes = null;
		//	conceptoAlternativo = null;
		//	codConceptoAlternativo = null;
			generaAuxilioAdmon = null;
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  trabajador, concepto, valor total tengan valores. "));
		}
	}

	public void listener_txtCodigo() throws Exception {
		try {
			moduloSeleccionado();
			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Trabajador> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null)
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

			txtTipoTrabajador.setDisabled(false);
			txtUsuarioAsociado.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtEmail.setDisabled(false);
			txtNIdentificacion.setDisabled(false);
			txtEstadoCivil.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEstado.setDisabled(false);
			txtUbicacion.setDisabled(false);
			txtGenero.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtCentCostId_CentCost.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtContratistaId_Contratista.setDisabled(false);
			txtProfId_Profesion.setDisabled(false);
			txtFechaAdmision.setDisabled(false);
			txtClaseContrato.setDisabled(false);
			txtFechaNacimiento.setDisabled(false);
			txtSalario.setDisabled(false);
			String urlImageDefauld = "defauldImagen.png";
			txtImagenTrabajador = urlImageDefauld;
			imagenTrabajador = "default.jpg";
			
			txtTrabId.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
			txtCeptoNominaIdDeducciones.setDisabled(false);
			txtFechaInicial1.setDisabled(false);
			txtFechaFinal1.setDisabled(false);
			txtTarifaDeduccion.setDisabled(false);
			btnAgregar1.setDisabled(false);
			/***** devengos *****/
			txtCeptoNominaIdDevengos.setDisabled(false);
			txtFechaInicial2.setDisabled(false);
			txtFechaFinal2.setDisabled(false);
			txtTarifaDevengos.setDisabled(false);
		//	txtCeptoNominaAlternativo.setDisabled(false);
		//	txtGeneraDomingosFestivos.setDisabled(false);
		//	txtGeneraAuxilioTransp.setDisabled(false);
		//	txtGeneraAuxilioAdmon.setDisabled(false);
		//	txtHorasDia.setDisabled(false);
		//	txtHorasMes.setDisabled(false);
			txtOrigenDatos.setDisabled(false);
			
			txtBarrio.setDisabled(false);
			txtTipo_vivienda.setDisabled(false);
			txtCelular.setDisabled(false);
			txtTipo_licencia_conduccion.setDisabled(false);
			txtNumero_licencia_conduccion.setDisabled(false);
			txtNum_pasado_judicial.setDisabled(false);
			txtNum_tarjeta_profesional.setDisabled(false);
			txtTipo_sangre.setDisabled(false);			
			txtNombre_eps.setDisabled(false);
			txtNombre_fondo_pension.setDisabled(false);
			txtNombre_fondo_cesantias.setDisabled(false);
			txtNombre_arp.setDisabled(false);
			txtNombre_caja_compensacion.setDisabled(false);
			txtNumero_cuenta_bancaria.setDisabled(false);			
			txtEnt_banc_id.setDisabled(false);
			txtTipo_cuenta_bancaria.setDisabled(false);			
			txtNombres_conyugue.setDisabled(false);
			txtNumero_hijos.setDisabled(false);
			txtContacto_emergencia.setDisabled(false);
			txtContacto_emergencia_parentesco.setDisabled(false);
			txtEstudio_bachillerato.setDisabled(false);			
			txtEstudio_bachillerato_entidad.setDisabled(false);
			txtEstudio_tecnico.setDisabled(false);
			txtEstudio_tecnico_titulo.setDisabled(false);			
			txtEstudio_tecnico_entidad.setDisabled(false);			
			txtEstudio_tecnologico.setDisabled(false);
			txtEstudio_tecnologico_titulo.setDisabled(false);
			txtEstudio_tecnologico_entidad.setDisabled(false);
			txtEstudio_pregrado.setDisabled(false);
			txtEstudio_pregrado_titulo.setDisabled(false);			
			txtEstudio_pregrado_entidad.setDisabled(false);
			txtEstudio_potsgrado.setDisabled(false);			
			txtEstudio_potsgrado_titulo.setDisabled(false);
			txtEstudio_potsgrado_entidad.setDisabled(false);
			txtEstudio_otros.setDisabled(false);			
			txtEstudio_otros_titulo.setDisabled(false);
			txtEstudio_otros_entidad.setDisabled(false);			
			txtPecargo1_nombre.setDisabled(false);
			txtPecargo1_parentesco.setDisabled(false);
			txtPecargo1_edad.setDisabled(false);
			txtPecargo1_niveleducativo.setDisabled(false);			
			txtPecargo2_nombre.setDisabled(false);			
			txtPecargo2_parentesco.setDisabled(false);
			txtPecargo2_edad.setDisabled(false);
			txtPecargo2_niveleducativo.setDisabled(false);			
			txtPecargo3_nombre.setDisabled(false);			
			txtPecargo3_parentesco.setDisabled(false);
			txtPecargo3_edad.setDisabled(false);
			txtPecargo3_niveleducativo.setDisabled(false);			
			txtPecargo4_nombre.setDisabled(false);			
			txtPecargo4_parentesco.setDisabled(false);
			txtPecargo4_edad.setDisabled(false);
			txtPecargo4_niveleducativo.setDisabled(false);			
			txtPecargo5_nombre.setDisabled(false);			
			txtPecargo5_parentesco.setDisabled(false);
			txtPecargo5_edad.setDisabled(false);
			txtPecargo5_niveleducativo.setDisabled(false);

			txtTipoCotizante.setDisabled(false);
			txtSubTipoCotizante.setDisabled(false);
			txtEpsActual.setDisabled(false);
			txtEpsAnterior.setDisabled(false);
			txtAfpActual.setDisabled(false);
			txtAfpAnterior.setDisabled(false);
			txtCajaCompensacion.setDisabled(false);
			txtArl.setDisabled(false);
			txtFondoCesantias.setDisabled(false);
			txtAportaEps.setDisabled(false);
			txtEmpleadorAportaEps.setDisabled(false);
			txtFechaInicioEps.setDisabled(false);
			txtAportaAfp.setDisabled(false);
			txtFechaInicioAfp.setDisabled(false);
			txtAportaCcf.setDisabled(false);
			txtAportaArl.setDisabled(false);
			txtAportaIcbf.setDisabled(false);
			txtAportaSena.setDisabled(false);
			txtAltoRiesgo.setDisabled(false);
			txtTarifaCajaCompensacion.setDisabled(false);
			//txtClaseTarifaArl.setDisabled(false);
			txtTarifaArl.setDisabled(false);
			txtTarifaIcbf.setDisabled(false);
			txtTarifaSena.setDisabled(false);
			txtTarifasArlId.setDisabled(false);
			txtFechaRetiro.setDisabled(false);
			
			btnAgregar2.setDisabled(false);
			btnSave.setDisabled(false);
			
		} else {
			txtFechaRetiro.setDisabled(false);
			if(entity.getFechaRetiro()!=null) {
				txtFechaRetiro.setValue(entity.getFechaRetiro());
			}

			txtTipoTrabajador.setDisabled(false);
			if(entity.getTipo_trabajador()!=null) {
				txtTipoTrabajador.setValue(entity.getTipo_trabajador());
				
			}

			txtTarifasArlId.setDisabled(false);
			if(entity.getTarifasArlId()!=null) {
			txtTarifasArlId.setValue(entity.getTarifasArlId());
			}
			txtUsuarioAsociado.setDisabled(false);
			txtUsuarioAsociado.setValue(entity.getUsuario_asociado());
			txtSalario.setDisabled(false);
			txtSalario.setValue(entity.getSalario());
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtUbicacion.setValue(entity.getUbicacion());
			txtUbicacion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEstadoCivil.setValue(entity.getEstadoCivil());
			txtEstadoCivil.setDisabled(false);
			txtNIdentificacion.setValue(entity.getnIdentificacion());
			txtNIdentificacion.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaAdmision.setValue(entity.getFechaAdmision());
			txtFechaAdmision.setDisabled(false);
			txtClaseContrato.setValue(entity.getClaseContrato());
			txtClaseContrato.setDisabled(false);
			txtFechaNacimiento.setValue(entity.getFechaNacimiento());
			txtFechaNacimiento.setDisabled(false);
			
			imagenTrabajador = entity.getFoto();
			
			txtGenero.setValue(entity.getGenero());
			txtGenero.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtOrigenDatos.setValue(entity.getOrigenDatos());
			txtOrigenDatos.setDisabled(false);

			if (entity.getCentCost() != null) {
				txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
			}			
			txtCentCostId_CentCost.setDisabled(false);
			
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtContratistaId_Contratista.setValue(entity.getContratista().getPersEmprId());
			txtContratistaId_Contratista.setDisabled(false);
			txtProfId_Profesion.setValue(entity.getProfesion().getProfId());
			txtProfId_Profesion.setDisabled(false);
			txtTrabId.setValue(entity.getTrabId());
			txtTrabId.setDisabled(true);
			txtLaborId_Labor.setDisabled(false);
			
			txtBarrio.setValue(entity.getBarrio());
			txtBarrio.setDisabled(false);
			txtTipo_vivienda.setValue(entity.getTipo_vivienda());
			txtTipo_vivienda.setDisabled(false);
			txtCelular.setValue(entity.getCelular());
			txtCelular.setDisabled(false);
			txtTipo_licencia_conduccion.setValue(entity.getTipo_licencia_conduccion());
			txtTipo_licencia_conduccion.setDisabled(false);
			txtNumero_licencia_conduccion.setValue(entity.getNumero_licencia_conduccion());
			txtNumero_licencia_conduccion.setDisabled(false);
			txtNum_pasado_judicial.setValue(entity.getNum_pasado_judicial());
			txtNum_pasado_judicial.setDisabled(false);
			txtNum_tarjeta_profesional.setValue(entity.getNum_tarjeta_profesional());
			txtNum_tarjeta_profesional.setDisabled(false);
			txtTipo_sangre.setValue(entity.getTipo_sangre());
			txtTipo_sangre.setDisabled(false);			
			txtNombre_eps.setValue(entity.getNombre_eps());
			txtNombre_eps.setDisabled(false);
			txtNombre_fondo_pension.setValue(entity.getNombre_fondo_pension());
			txtNombre_fondo_pension.setDisabled(false);
			txtNombre_fondo_cesantias.setValue(entity.getNombre_fondo_cesantias());
			txtNombre_fondo_cesantias.setDisabled(false);
			txtNombre_arp.setValue(entity.getNombre_arp());
			txtNombre_arp.setDisabled(false);
			txtNombre_caja_compensacion.setValue(entity.getNombre_caja_compensacion());
			txtNombre_caja_compensacion.setDisabled(false);
			txtNumero_cuenta_bancaria.setValue(entity.getNumero_cuenta_bancaria());
			txtNumero_cuenta_bancaria.setDisabled(false);						
			txtEnt_banc_id.setValue(entity.getEnt_banc_id());
			txtEnt_banc_id.setDisabled(false);			
			txtTipo_cuenta_bancaria.setValue(entity.getTipo_cuenta_bancaria());
			txtTipo_cuenta_bancaria.setDisabled(false);			
			txtNombres_conyugue.setValue(entity.getNombres_conyugue());
			txtNombres_conyugue.setDisabled(false);
			txtNumero_hijos.setValue(entity.getNumero_hijos());
			txtNumero_hijos.setDisabled(false);
			txtContacto_emergencia.setValue(entity.getContacto_emergencia());
			txtContacto_emergencia.setDisabled(false);
			txtContacto_emergencia_parentesco.setValue(entity.getContacto_emergencia_parentesco());
			txtContacto_emergencia_parentesco.setDisabled(false);
			txtEstudio_bachillerato.setValue(entity.getEstudio_bachillerato());
			txtEstudio_bachillerato.setDisabled(false);			
			txtEstudio_bachillerato_entidad.setValue(entity.getEstudio_bachillerato_entidad());
			txtEstudio_bachillerato_entidad.setDisabled(false);
			txtEstudio_tecnico.setValue(entity.getEstudio_tecnico());
			txtEstudio_tecnico.setDisabled(false);
			txtEstudio_tecnico_titulo.setValue(entity.getEstudio_tecnico_titulo());
			txtEstudio_tecnico_titulo.setDisabled(false);			
			txtEstudio_tecnico_entidad.setValue(entity.getEstudio_tecnico_entidad());
			txtEstudio_tecnico_entidad.setDisabled(false);			
			txtEstudio_tecnologico.setValue(entity.getEstudio_tecnologico());
			txtEstudio_tecnologico.setDisabled(false);
			txtEstudio_tecnologico_titulo.setValue(entity.getEstudio_tecnologico_titulo());
			txtEstudio_tecnologico_titulo.setDisabled(false);
			txtEstudio_tecnologico_entidad.setValue(entity.getEstudio_tecnologico_entidad());
			txtEstudio_tecnologico_entidad.setDisabled(false);
			txtEstudio_pregrado.setValue(entity.getEstudio_pregrado());
			txtEstudio_pregrado.setDisabled(false);
			txtEstudio_pregrado_titulo.setValue(entity.getEstudio_pregrado_titulo());
			txtEstudio_pregrado_titulo.setDisabled(false);			
			txtEstudio_pregrado_entidad.setValue(entity.getEstudio_pregrado_entidad());
			txtEstudio_pregrado_entidad.setDisabled(false);
			txtEstudio_potsgrado.setValue(entity.getEstudio_potsgrado());
			txtEstudio_potsgrado.setDisabled(false);			
			txtEstudio_potsgrado_titulo.setValue(entity.getEstudio_potsgrado_titulo());
			txtEstudio_potsgrado_titulo.setDisabled(false);
			txtEstudio_potsgrado_entidad.setValue(entity.getEstudio_potsgrado_entidad());
			txtEstudio_potsgrado_entidad.setDisabled(false);
			txtEstudio_otros.setValue(entity.getEstudio_otros());
			txtEstudio_otros.setDisabled(false);			
			txtEstudio_otros_titulo.setValue(entity.getEstudio_otros_titulo());
			txtEstudio_otros_titulo.setDisabled(false);
			txtEstudio_otros_entidad.setValue(entity.getEstudio_otros_entidad());
			txtEstudio_otros_entidad.setDisabled(false);			
			txtPecargo1_nombre.setValue(entity.getPecargo1_nombre());
			txtPecargo1_nombre.setDisabled(false);
			txtPecargo1_parentesco.setValue(entity.getPecargo1_parentesco());
			txtPecargo1_parentesco.setDisabled(false);
			txtPecargo1_edad.setValue(entity.getPecargo1_edad());
			txtPecargo1_edad.setDisabled(false);
			txtPecargo1_niveleducativo.setValue(entity.getPecargo1_niveleducativo());
			txtPecargo1_niveleducativo.setDisabled(false);			
			txtPecargo2_nombre.setValue(entity.getPecargo2_nombre());
			txtPecargo2_nombre.setDisabled(false);
			txtPecargo2_parentesco.setValue(entity.getPecargo2_parentesco());
			txtPecargo2_parentesco.setDisabled(false);
			txtPecargo2_edad.setValue(entity.getPecargo2_edad());
			txtPecargo2_edad.setDisabled(false);
			txtPecargo2_niveleducativo.setValue(entity.getPecargo2_niveleducativo());
			txtPecargo2_niveleducativo.setDisabled(false);			
			txtPecargo3_nombre.setValue(entity.getPecargo3_nombre());
			txtPecargo3_nombre.setDisabled(false);
			txtPecargo3_parentesco.setValue(entity.getPecargo3_parentesco());
			txtPecargo3_parentesco.setDisabled(false);
			txtPecargo3_edad.setValue(entity.getPecargo3_edad());
			txtPecargo3_edad.setDisabled(false);
			txtPecargo3_niveleducativo.setValue(entity.getPecargo3_niveleducativo());
			txtPecargo3_niveleducativo.setDisabled(false);			
			txtPecargo4_nombre.setValue(entity.getPecargo4_nombre());
			txtPecargo4_nombre.setDisabled(false);
			txtPecargo4_parentesco.setValue(entity.getPecargo4_parentesco());
			txtPecargo4_parentesco.setDisabled(false);
			txtPecargo4_edad.setValue(entity.getPecargo4_edad());
			txtPecargo4_edad.setDisabled(false);
			txtPecargo4_niveleducativo.setValue(entity.getPecargo4_niveleducativo());
			txtPecargo4_niveleducativo.setDisabled(false);			
			txtPecargo5_nombre.setValue(entity.getPecargo5_nombre());
			txtPecargo5_nombre.setDisabled(false);
			txtPecargo5_parentesco.setValue(entity.getPecargo5_parentesco());
			txtPecargo5_parentesco.setDisabled(false);
			txtPecargo5_edad.setValue(entity.getPecargo5_edad());
			txtPecargo5_edad.setDisabled(false);
			txtPecargo5_niveleducativo.setValue(entity.getPecargo5_niveleducativo());
			txtPecargo5_niveleducativo.setDisabled(false);

			txtTipoCotizante.setValue(entity.getTipoCotizante() != null ? entity.getTipoCotizante().getTipoCotizanteId() : null);
			txtTipoCotizante.setDisabled(false);			
			txtEpsActual.setValue(entity.getEpsActual() != null ? entity.getEpsActual().getPersEmprId() : null);		
			txtEpsActual.setDisabled(false);
			txtEpsAnterior.setValue(entity.getEpsAnterior() != null ? entity.getEpsAnterior().getPersEmprId() : null);
			txtEpsAnterior.setDisabled(false);
			txtSubTipoCotizante.setValue(entity.getSubTipoCotizante() != null ? entity.getSubTipoCotizante().getSubTipoCotizanteId() : null);
			txtSubTipoCotizante.setDisabled(false);
			txtAfpActual.setValue(entity.getAfpActual() != null ? entity.getAfpActual().getPersEmprId() : null);
			txtAfpActual.setDisabled(false);
			txtAfpAnterior.setValue(entity.getAfpAnterior() != null ? entity.getAfpActual().getPersEmprId() : null);
			txtAfpAnterior.setDisabled(false);
			txtCajaCompensacion.setValue(entity.getCajaCompensacion() != null ? entity.getCajaCompensacion().getPersEmprId() : null);
			txtCajaCompensacion.setDisabled(false);
			txtArl.setValue(entity.getArl() != null ? entity.getArl().getPersEmprId() : null);
			txtArl.setDisabled(false);
			txtFondoCesantias.setValue(entity.getFondoCesantias() != null ? entity.getFondoCesantias().getPersEmprId() : null);
			txtFondoCesantias.setDisabled(false);			
			if(entity.getAportaEps()!=null) {
				txtAportaEps.setValue(entity.getAportaEps().equals("S") ? true : false);
				}
				txtAportaEps.setDisabled(false);
				
				if(entity.getEmpleadorAportaEps()!=null) {
				txtEmpleadorAportaEps.setValue(entity.getEmpleadorAportaEps().equals("S") ? true : false);
				}
				txtEmpleadorAportaEps.setDisabled(false);
				
				txtFechaInicioEps.setValue(entity.getFechaInicioEps());
				txtFechaInicioEps.setDisabled(false);

				if(entity.getAportaAfp()!=null) {
				txtAportaAfp.setValue(entity.getAportaAfp().equals("S") ? true : false);
				}
				txtAportaAfp.setDisabled(false);
				txtFechaInicioAfp.setValue(entity.getFechaInicioAfp());
				txtFechaInicioAfp.setDisabled(false);
				

				if(entity.getAportaCcf()!=null) {
				txtAportaCcf.setValue(entity.getAportaCcf().equals("S") ? true : false);
				}
				txtAportaCcf.setDisabled(false);			

				if(entity.getAportaArl()!=null) {
				txtAportaArl.setValue(entity.getAportaArl().equals("S") ? true : false);
				}
				txtAportaArl.setDisabled(false);

				if(entity.getAportaIcbf()!=null) {
				txtAportaIcbf.setValue(entity.getAportaIcbf().equals("S") ? true : false);
				}
				txtAportaIcbf.setDisabled(false);

				if(entity.getAportaSena()!=null) {
				txtAportaSena.setValue(entity.getAportaSena().equals("S") ? true : false);
				}
				txtAportaSena.setDisabled(false);

				if(entity.getAltoRiesgo()!=null) {
				txtAltoRiesgo.setValue(entity.getAltoRiesgo().equals("S") ? true : false);
				}		
				
				
			txtTarifaCajaCompensacion.setValue(entity.getTarifaCajaCompensacion());
			txtTarifaCajaCompensacion.setDisabled(false);
		//	txtClaseTarifaArl.setValue(entity.getClaseTarifaArl());
			//txtClaseTarifaArl.setDisabled(false);
			txtTarifaArl.setValue(entity.getTarifaArl());
			txtTarifaArl.setDisabled(false);
			txtTarifaIcbf.setValue(entity.getTarifaIcbf());
			txtTarifaIcbf.setDisabled(false);
			txtTarifaSena.setValue(entity.getTarifaSena());
			txtTarifaSena.setDisabled(false);

			Long trabajadorId = FacesUtils.checkLong(txtTrabId);

			/***** deduccion *****/
			txtCeptoNominaIdDeducciones.setDisabled(false);
			txtFechaInicial1.setDisabled(false);
			txtFechaFinal1.setDisabled(false);
			txtTarifaDeduccion.setDisabled(false);
			btnAgregar1.setDisabled(false);
			
			dataTarifaDeduccion = null;
			dataTarifaDeduccion = businessDelegatorView.getDataTarifaDeduccionByTrabajador(trabajadorId);
			
			/***** devengos ******/
			txtCeptoNominaIdDevengos.setDisabled(false);
			txtFechaInicial2.setDisabled(false);
			txtFechaFinal2.setDisabled(false);
			txtTarifaDevengos.setDisabled(false);
			btnAgregar2.setDisabled(false);

			dataTarifaDevengos = null;
			dataTarifaDevengos = businessDelegatorView.getDataTarifaOtrosDevengosByTrabajador(trabajadorId);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
			
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTrabajador = (TrabajadorDTO) (evt.getComponent().getAttributes().get("selectedTrabajador"));

		try {

			 Long trabId   = selectedTrabajador.getTrabId();
			Object[] condicion = { "trabId", true, trabId, "=" };
			List<Trabajador> lista = (trabId != null)
					? businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtFechaRetiro.setDisabled(false);
				if(entity.getFechaRetiro()!=null) {
					txtFechaRetiro.setValue(entity.getFechaRetiro());
				}
				
				txtOrigenDatos.setValue(entity.getOrigenDatos());
				txtOrigenDatos.setDisabled(false);

				txtTipoTrabajador.setDisabled(false);
				if(entity.getTipo_trabajador()!=null) {
					txtTipoTrabajador.setValue(entity.getTipo_trabajador());
					
				}
				txtUsuarioAsociado.setValue(null);
				txtUsuarioAsociado.setDisabled(false);
				txtUsuarioAsociado.setValue(entity.getUsuario_asociado());
						
				txtSalario.setDisabled(false);
				txtSalario.setValue(entity.getSalario());
				
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtUbicacion.setValue(entity.getUbicacion());
				txtUbicacion.setDisabled(false);
				txtEmail.setValue(entity.getEmail());
				txtEmail.setDisabled(false);
				txtDireccion.setValue(entity.getDireccion());
				txtDireccion.setDisabled(false);
				txtEstadoCivil.setValue(entity.getEstadoCivil());
				txtEstadoCivil.setDisabled(false);
				txtNIdentificacion.setValue(entity.getnIdentificacion());
				txtNIdentificacion.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				txtFechaAdmision.setValue(entity.getFechaAdmision());
				txtFechaAdmision.setDisabled(false);
				txtFechaNacimiento.setValue(entity.getFechaNacimiento());
				txtFechaNacimiento.setDisabled(false);
				
				imagenTrabajador = ((entity.getFoto() != null && !entity.getFoto().equals("")) ? entity.getFoto()
						: "default.jpg");

				txtGenero.setValue(entity.getGenero());
				txtGenero.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				
				if (entity.getCentCost() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
				}
				
				txtClaseContrato.setValue(entity.getClaseContrato());
				txtClaseContrato.setDisabled(false);
				txtCentCostId_CentCost.setDisabled(false);
				txtCiudadId_Ciudad.setValue(entity.getCiudad());
				txtCiudadId_Ciudad.setDisabled(false);
				txtContratistaId_Contratista.setValue(entity.getContratista().getPersEmprId());
				txtContratistaId_Contratista.setDisabled(false);
				txtProfId_Profesion.setValue(entity.getProfesion().getProfId());
				txtProfId_Profesion.setDisabled(false);
				txtTrabId.setValue(entity.getTrabId());
				txtTrabId.setDisabled(true);
				
				txtBarrio.setValue(entity.getBarrio());
				txtBarrio.setDisabled(false);
				txtTipo_vivienda.setValue(entity.getTipo_vivienda());
				txtTipo_vivienda.setDisabled(false);
				txtCelular.setValue(entity.getCelular());
				txtCelular.setDisabled(false);
				txtTipo_licencia_conduccion.setValue(entity.getTipo_licencia_conduccion());
				txtTipo_licencia_conduccion.setDisabled(false);
				txtNumero_licencia_conduccion.setValue(entity.getNumero_licencia_conduccion());
				txtNumero_licencia_conduccion.setDisabled(false);
				txtNum_pasado_judicial.setValue(entity.getNum_pasado_judicial());
				txtNum_pasado_judicial.setDisabled(false);
				txtNum_tarjeta_profesional.setValue(entity.getNum_tarjeta_profesional());
				txtNum_tarjeta_profesional.setDisabled(false);
				txtTipo_sangre.setValue(entity.getTipo_sangre());
				txtTipo_sangre.setDisabled(false);			
				txtNombre_eps.setValue(entity.getNombre_eps());
				txtNombre_eps.setDisabled(false);
				txtNombre_fondo_pension.setValue(entity.getNombre_fondo_pension());
				txtNombre_fondo_pension.setDisabled(false);
				txtNombre_fondo_cesantias.setValue(entity.getNombre_fondo_cesantias());
				txtNombre_fondo_cesantias.setDisabled(false);
				txtNombre_arp.setValue(entity.getNombre_arp());
				txtNombre_arp.setDisabled(false);
				txtNombre_caja_compensacion.setValue(entity.getNombre_caja_compensacion());
				txtNombre_caja_compensacion.setDisabled(false);
				txtNumero_cuenta_bancaria.setValue(entity.getNumero_cuenta_bancaria());
				txtNumero_cuenta_bancaria.setDisabled(false);						
				txtEnt_banc_id.setValue(entity.getEnt_banc_id());
				txtEnt_banc_id.setDisabled(false);			
				txtTipo_cuenta_bancaria.setValue(entity.getTipo_cuenta_bancaria());
				txtTipo_cuenta_bancaria.setDisabled(false);			
				txtNombres_conyugue.setValue(entity.getNombres_conyugue());
				txtNombres_conyugue.setDisabled(false);
				txtNumero_hijos.setValue(entity.getNumero_hijos());
				txtNumero_hijos.setDisabled(false);
				txtContacto_emergencia.setValue(entity.getContacto_emergencia());
				txtContacto_emergencia.setDisabled(false);
				txtContacto_emergencia_parentesco.setValue(entity.getContacto_emergencia_parentesco());
				txtContacto_emergencia_parentesco.setDisabled(false);
				txtEstudio_bachillerato.setValue(entity.getEstudio_bachillerato());
				txtEstudio_bachillerato.setDisabled(false);			
				txtEstudio_bachillerato_entidad.setValue(entity.getEstudio_bachillerato_entidad());
				txtEstudio_bachillerato_entidad.setDisabled(false);
				txtEstudio_tecnico.setValue(entity.getEstudio_tecnico());
				txtEstudio_tecnico.setDisabled(false);
				txtEstudio_tecnico_titulo.setValue(entity.getEstudio_tecnico_titulo());
				txtEstudio_tecnico_titulo.setDisabled(false);			
				txtEstudio_tecnico_entidad.setValue(entity.getEstudio_tecnico_entidad());
				txtEstudio_tecnico_entidad.setDisabled(false);			
				txtEstudio_tecnologico.setValue(entity.getEstudio_tecnologico());
				txtEstudio_tecnologico.setDisabled(false);
				txtEstudio_tecnologico_titulo.setValue(entity.getEstudio_tecnologico_titulo());
				txtEstudio_tecnologico_titulo.setDisabled(false);
				txtEstudio_tecnologico_entidad.setValue(entity.getEstudio_tecnologico_entidad());
				txtEstudio_tecnologico_entidad.setDisabled(false);
				txtEstudio_pregrado.setValue(entity.getEstudio_pregrado());
				txtEstudio_pregrado.setDisabled(false);
				txtEstudio_pregrado_titulo.setValue(entity.getEstudio_pregrado_titulo());
				txtEstudio_pregrado_titulo.setDisabled(false);			
				txtEstudio_pregrado_entidad.setValue(entity.getEstudio_pregrado_entidad());
				txtEstudio_pregrado_entidad.setDisabled(false);
				txtEstudio_potsgrado.setValue(entity.getEstudio_potsgrado());
				txtEstudio_potsgrado.setDisabled(false);			
				txtEstudio_potsgrado_titulo.setValue(entity.getEstudio_potsgrado_titulo());
				txtEstudio_potsgrado_titulo.setDisabled(false);
				txtEstudio_potsgrado_entidad.setValue(entity.getEstudio_potsgrado_entidad());
				txtEstudio_potsgrado_entidad.setDisabled(false);
				txtEstudio_otros.setValue(entity.getEstudio_otros());
				txtEstudio_otros.setDisabled(false);			
				txtEstudio_otros_titulo.setValue(entity.getEstudio_otros_titulo());
				txtEstudio_otros_titulo.setDisabled(false);
				txtEstudio_otros_entidad.setValue(entity.getEstudio_otros_entidad());
				txtEstudio_otros_entidad.setDisabled(false);			
				txtPecargo1_nombre.setValue(entity.getPecargo1_nombre());
				txtPecargo1_nombre.setDisabled(false);
				txtPecargo1_parentesco.setValue(entity.getPecargo1_parentesco());
				txtPecargo1_parentesco.setDisabled(false);
				txtPecargo1_edad.setValue(entity.getPecargo1_edad());
				txtPecargo1_edad.setDisabled(false);
				txtPecargo1_niveleducativo.setValue(entity.getPecargo1_niveleducativo());
				txtPecargo1_niveleducativo.setDisabled(false);			
				txtPecargo2_nombre.setValue(entity.getPecargo2_nombre());
				txtPecargo2_nombre.setDisabled(false);
				txtPecargo2_parentesco.setValue(entity.getPecargo2_parentesco());
				txtPecargo2_parentesco.setDisabled(false);
				txtPecargo2_edad.setValue(entity.getPecargo2_edad());
				txtPecargo2_edad.setDisabled(false);
				txtPecargo2_niveleducativo.setValue(entity.getPecargo2_niveleducativo());
				txtPecargo2_niveleducativo.setDisabled(false);			
				txtPecargo3_nombre.setValue(entity.getPecargo3_nombre());
				txtPecargo3_nombre.setDisabled(false);
				txtPecargo3_parentesco.setValue(entity.getPecargo3_parentesco());
				txtPecargo3_parentesco.setDisabled(false);
				txtPecargo3_edad.setValue(entity.getPecargo3_edad());
				txtPecargo3_edad.setDisabled(false);
				txtPecargo3_niveleducativo.setValue(entity.getPecargo3_niveleducativo());
				txtPecargo3_niveleducativo.setDisabled(false);			
				txtPecargo4_nombre.setValue(entity.getPecargo4_nombre());
				txtPecargo4_nombre.setDisabled(false);
				txtPecargo4_parentesco.setValue(entity.getPecargo4_parentesco());
				txtPecargo4_parentesco.setDisabled(false);
				txtPecargo4_edad.setValue(entity.getPecargo4_edad());
				txtPecargo4_edad.setDisabled(false);
				txtPecargo4_niveleducativo.setValue(entity.getPecargo4_niveleducativo());
				txtPecargo4_niveleducativo.setDisabled(false);			
				txtPecargo5_nombre.setValue(entity.getPecargo5_nombre());
				txtPecargo5_nombre.setDisabled(false);
				txtPecargo5_parentesco.setValue(entity.getPecargo5_parentesco());
				txtPecargo5_parentesco.setDisabled(false);
				txtPecargo5_edad.setValue(entity.getPecargo5_edad());
				txtPecargo5_edad.setDisabled(false);
				txtPecargo5_niveleducativo.setValue(entity.getPecargo5_niveleducativo());
				txtPecargo5_niveleducativo.setDisabled(false);

				txtTipoCotizante.setValue(entity.getTipoCotizante() != null ? entity.getTipoCotizante().getTipoCotizanteId() : null);
				txtTipoCotizante.setDisabled(false);			
				txtEpsActual.setValue(entity.getEpsActual() != null ? entity.getEpsActual().getPersEmprId() : null);		
				txtEpsActual.setDisabled(false);
				txtEpsAnterior.setValue(entity.getEpsAnterior() != null ? entity.getEpsAnterior().getPersEmprId() : null);
				txtEpsAnterior.setDisabled(false);
				txtSubTipoCotizante.setValue(entity.getSubTipoCotizante() != null ? entity.getSubTipoCotizante().getSubTipoCotizanteId() : null);
				txtSubTipoCotizante.setDisabled(false);
				txtAfpActual.setValue(entity.getAfpActual() != null ? entity.getAfpActual().getPersEmprId() : null);
				txtAfpActual.setDisabled(false);
				txtAfpAnterior.setValue(entity.getAfpAnterior() != null ? entity.getAfpActual().getPersEmprId() : null);
				txtAfpAnterior.setDisabled(false);
				txtCajaCompensacion.setValue(entity.getCajaCompensacion() != null ? entity.getCajaCompensacion().getPersEmprId() : null);
				txtCajaCompensacion.setDisabled(false);
				txtArl.setValue(entity.getArl() != null ? entity.getArl().getPersEmprId() : null);
				txtArl.setDisabled(false);
				txtFondoCesantias.setValue(entity.getFondoCesantias() != null ? entity.getFondoCesantias().getPersEmprId() : null);
				txtFondoCesantias.setDisabled(false);			
				if(entity.getAportaEps()!=null) {
				txtAportaEps.setValue(entity.getAportaEps().equals("S") ? true : false);
				}
				txtAportaEps.setDisabled(false);
				
				if(entity.getEmpleadorAportaEps()!=null) {
				txtEmpleadorAportaEps.setValue(entity.getEmpleadorAportaEps().equals("S") ? true : false);
				}
				txtEmpleadorAportaEps.setDisabled(false);
				
				txtFechaInicioEps.setValue(entity.getFechaInicioEps());
				txtFechaInicioEps.setDisabled(false);

				if(entity.getAportaAfp()!=null) {
				txtAportaAfp.setValue(entity.getAportaAfp().equals("S") ? true : false);
				}
				txtAportaAfp.setDisabled(false);
				txtFechaInicioAfp.setValue(entity.getFechaInicioAfp());
				txtFechaInicioAfp.setDisabled(false);
				

				if(entity.getAportaCcf()!=null) {
				txtAportaCcf.setValue(entity.getAportaCcf().equals("S") ? true : false);
				}
				txtAportaCcf.setDisabled(false);			

				if(entity.getAportaArl()!=null) {
				txtAportaArl.setValue(entity.getAportaArl().equals("S") ? true : false);
				}
				txtAportaArl.setDisabled(false);

				if(entity.getAportaIcbf()!=null) {
				txtAportaIcbf.setValue(entity.getAportaIcbf().equals("S") ? true : false);
				}
				txtAportaIcbf.setDisabled(false);

				if(entity.getAportaSena()!=null) {
				txtAportaSena.setValue(entity.getAportaSena().equals("S") ? true : false);
				}
				txtAportaSena.setDisabled(false);

				if(entity.getAltoRiesgo()!=null) {
				txtAltoRiesgo.setValue(entity.getAltoRiesgo().equals("S") ? true : false);
				}
				txtAltoRiesgo.setDisabled(false);			
				txtTarifaCajaCompensacion.setValue(entity.getTarifaCajaCompensacion());
				txtTarifaCajaCompensacion.setDisabled(false);
			//	txtClaseTarifaArl.setValue(entity.getClaseTarifaArl());
			//	txtClaseTarifaArl.setDisabled(false);
				txtTarifaArl.setValue(entity.getTarifaArl());
				txtTarifaArl.setDisabled(false);
				txtTarifaIcbf.setValue(entity.getTarifaIcbf());
				txtTarifaIcbf.setDisabled(false);
				txtTarifaSena.setValue(entity.getTarifaSena());
				txtTarifaSena.setDisabled(false);
				

				txtTarifasArlId.setDisabled(false);
				if(entity.getTarifasArlId()!=null) {
				txtTarifasArlId.setValue(entity.getTarifasArlId());
				}
				
				btnSave.setDisabled(false);

				Long trabajadorId = FacesUtils.checkLong(txtTrabId);

				/***** deduccion *****/
				txtCeptoNominaIdDeducciones.setDisabled(false);
				txtFechaInicial1.setDisabled(false);
				txtFechaFinal1.setDisabled(false);
				txtTarifaDeduccion.setDisabled(false);
				btnAgregar1.setDisabled(false);
				
				dataTarifaDeduccion = null;
				dataTarifaDeduccion = businessDelegatorView.getDataTarifaDeduccionByTrabajador(trabajadorId);
				
				/***** devengos *****/
				txtCeptoNominaIdDevengos.setDisabled(false);
				txtFechaInicial2.setDisabled(false);
				txtFechaFinal2.setDisabled(false);
				btnAgregar2.setDisabled(false);
				txtTarifaDevengos.setDisabled(false);

				dataTarifaDevengos = null;
				dataTarifaDevengos = businessDelegatorView.getDataTarifaOtrosDevengosByTrabajador(trabajadorId);

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
			if ((selectedTrabajador == null) && (entity == null)) {
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
			entity = new Trabajador();

			Long compania = new Long(getCompaniaIdSession());
			Date date = new Date();
			entity.setUsuario_asociado(FacesUtils.checkLong(txtUsuarioAsociado));
			entity.setOrigenDatos("Modulo_AdminAgricola");
			entity.setUbicacion(FacesUtils.checkString(txtUbicacion));
			entity.setTipo_trabajador(FacesUtils.checkString(txtTipoTrabajador));			
			entity.setClaseContrato(FacesUtils.checkString(txtClaseContrato));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setnIdentificacion(FacesUtils.checkString(txtNIdentificacion));
			entity.setEstadoCivil(FacesUtils.checkString(txtEstadoCivil));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaAdmision(FacesUtils.checkDate(txtFechaAdmision));
			entity.setFechaCreacion(date);
			entity.setFechaNacimiento(FacesUtils.checkDate(txtFechaNacimiento));
			
			entity.setSalario(FacesUtils.checkDouble(txtSalario));
			
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();
			}

			entity.setGenero(FacesUtils.checkString(txtGenero));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(txtSegundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));			
			entity.setBarrio(FacesUtils.checkString(txtBarrio));
			entity.setTipo_vivienda(FacesUtils.checkString(txtTipo_vivienda));
			entity.setCelular(FacesUtils.checkString(txtCelular));
			entity.setTipo_licencia_conduccion(FacesUtils.checkString(txtTipo_licencia_conduccion));
			entity.setNumero_licencia_conduccion(FacesUtils.checkString(txtNumero_licencia_conduccion));
			entity.setNum_pasado_judicial(FacesUtils.checkString(txtNum_pasado_judicial));
			entity.setNum_tarjeta_profesional(FacesUtils.checkString(txtNum_tarjeta_profesional));
			entity.setTipo_sangre(FacesUtils.checkString(txtTipo_sangre));
			entity.setNombre_eps(FacesUtils.checkString(txtNombre_eps));
			entity.setNombre_fondo_pension((FacesUtils.checkString(txtNombre_fondo_pension)));			
			entity.setNombre_fondo_cesantias(FacesUtils.checkString(txtNombre_fondo_cesantias));
			entity.setNombre_arp(FacesUtils.checkString(txtNombre_arp));
			entity.setNombre_caja_compensacion(FacesUtils.checkString(txtNombre_caja_compensacion));
			entity.setNumero_cuenta_bancaria(FacesUtils.checkString(txtNumero_cuenta_bancaria));			
			entity.setEnt_banc_id(FacesUtils.checkLong(txtEnt_banc_id));
			entity.setTipo_cuenta_bancaria(FacesUtils.checkString(txtTipo_cuenta_bancaria));
			entity.setNombres_conyugue(FacesUtils.checkString(txtNombres_conyugue));
			entity.setNumero_hijos(FacesUtils.checkLong(txtNumero_hijos));
			entity.setContacto_emergencia(FacesUtils.checkString(txtContacto_emergencia));
			entity.setContacto_emergencia_parentesco((FacesUtils.checkString(txtContacto_emergencia_parentesco)));			
			entity.setEstudio_bachillerato(FacesUtils.checkString(txtEstudio_bachillerato));
			entity.setEstudio_bachillerato_entidad(FacesUtils.checkString(txtEstudio_bachillerato_entidad));
			entity.setEstudio_tecnico(FacesUtils.checkString(txtEstudio_tecnico));
			entity.setEstudio_tecnico_titulo(FacesUtils.checkString(txtEstudio_tecnico_titulo));
			entity.setEstudio_tecnico_entidad(FacesUtils.checkString(txtEstudio_tecnico_entidad));
			entity.setEstudio_tecnologico(FacesUtils.checkString(txtEstudio_tecnologico));
			entity.setEstudio_tecnologico_titulo(FacesUtils.checkString(txtEstudio_tecnologico_titulo));
			entity.setEstudio_tecnologico_entidad(FacesUtils.checkString(txtEstudio_tecnologico_entidad));
			entity.setEstudio_pregrado(FacesUtils.checkString(txtEstudio_pregrado));
			entity.setEstudio_pregrado_titulo((FacesUtils.checkString(txtEstudio_pregrado_titulo)));			
			entity.setEstudio_pregrado_entidad(FacesUtils.checkString(txtEstudio_pregrado_entidad));
			entity.setEstudio_potsgrado(FacesUtils.checkString(txtEstudio_potsgrado));
			entity.setEstudio_potsgrado_titulo(FacesUtils.checkString(txtEstudio_potsgrado_titulo));
			entity.setEstudio_potsgrado_entidad(FacesUtils.checkString(txtEstudio_potsgrado_entidad));			
			entity.setEstudio_otros(FacesUtils.checkString(txtEstudio_otros));
			entity.setEstudio_otros_titulo(FacesUtils.checkString(txtEstudio_otros_titulo));
			entity.setEstudio_otros_entidad(FacesUtils.checkString(txtEstudio_otros_entidad));			
			entity.setPecargo1_nombre(FacesUtils.checkString(txtPecargo1_nombre));
			entity.setPecargo1_parentesco(FacesUtils.checkString(txtPecargo1_parentesco));
			entity.setPecargo1_edad((FacesUtils.checkLong(txtPecargo1_edad)));
			entity.setPecargo1_niveleducativo(FacesUtils.checkString(txtPecargo1_niveleducativo));			
			entity.setPecargo2_nombre(FacesUtils.checkString(txtPecargo2_nombre));
			entity.setPecargo2_parentesco(FacesUtils.checkString(txtPecargo2_parentesco));
			entity.setPecargo2_edad((FacesUtils.checkLong(txtPecargo2_edad)));
			entity.setPecargo2_niveleducativo(FacesUtils.checkString(txtPecargo2_niveleducativo));			
			entity.setPecargo3_nombre(FacesUtils.checkString(txtPecargo3_nombre));
			entity.setPecargo3_parentesco(FacesUtils.checkString(txtPecargo3_parentesco));
			entity.setPecargo3_edad((FacesUtils.checkLong(txtPecargo3_edad)));
			entity.setPecargo3_niveleducativo(FacesUtils.checkString(txtPecargo3_niveleducativo));			
			entity.setPecargo4_nombre(FacesUtils.checkString(txtPecargo4_nombre));
			entity.setPecargo4_parentesco(FacesUtils.checkString(txtPecargo4_parentesco));
			entity.setPecargo4_edad((FacesUtils.checkLong(txtPecargo4_edad)));
			entity.setPecargo4_niveleducativo(FacesUtils.checkString(txtPecargo4_niveleducativo));			
			entity.setPecargo5_nombre(FacesUtils.checkString(txtPecargo5_nombre));
			entity.setPecargo5_parentesco(FacesUtils.checkString(txtPecargo5_parentesco));
			entity.setPecargo5_edad((FacesUtils.checkLong(txtPecargo5_edad)));
			entity.setPecargo5_niveleducativo(FacesUtils.checkString(txtPecargo5_niveleducativo));
			
			entity.setAportaEps((Boolean) txtAportaEps.getValue() ? "S" : "N");
			entity.setEmpleadorAportaEps((Boolean) txtEmpleadorAportaEps.getValue() ? "S" : "N");
			entity.setFechaInicioEps(FacesUtils.checkDate(txtFechaInicioEps));
			entity.setAportaAfp((Boolean) txtAportaAfp.getValue() ? "S" : "N");
			entity.setFechaInicioAfp(FacesUtils.checkDate(txtFechaInicioAfp));
			entity.setAportaCcf((Boolean) txtAportaCcf.getValue() ? "S" : "N");
			entity.setAportaArl((Boolean) txtAportaArl.getValue() ? "S" : "N");
			entity.setAportaIcbf((Boolean) txtAportaIcbf.getValue() ? "S" : "N");
			entity.setAportaSena((Boolean) txtAportaSena.getValue() ? "S" : "N");
			entity.setAltoRiesgo((Boolean) txtAltoRiesgo.getValue() ? "S" : "N");
			entity.setTarifaCajaCompensacion(FacesUtils.checkDouble(txtTarifaCajaCompensacion));
			entity.setClaseTarifaArl(FacesUtils.checkString(txtClaseTarifaArl));
			entity.setTarifaArl(FacesUtils.checkDouble(txtTarifaArl));
			entity.setTarifaIcbf(FacesUtils.checkDouble(txtTarifaIcbf));
			entity.setTarifaSena(FacesUtils.checkDouble(txtTarifaSena));			
			
			entity.setTipoCotizante((FacesUtils.checkLong(txtTipoCotizante) != null)
					? businessDelegator2View.getTipoCotizante(FacesUtils.checkLong(txtTipoCotizante))
					: null);
			entity.setEpsActual((FacesUtils.checkLong(txtEpsActual) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtEpsActual))
					: null);
			entity.setEpsAnterior((FacesUtils.checkLong(txtEpsAnterior) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtEpsAnterior))
					: null);
			entity.setSubTipoCotizante((FacesUtils.checkLong(txtSubTipoCotizante) != null)
					? businessDelegator2View.getSubTipoCotizante(FacesUtils.checkLong(txtSubTipoCotizante))
					: null);
			entity.setAfpActual((FacesUtils.checkLong(txtAfpActual) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtAfpActual))
					: null);
			entity.setAfpAnterior((FacesUtils.checkLong(txtAfpAnterior) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtAfpAnterior))
					: null);
			entity.setCajaCompensacion((FacesUtils.checkLong(txtCajaCompensacion) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtCajaCompensacion))
					: null);
			entity.setArl((FacesUtils.checkLong(txtArl) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtArl))
					: null);
			entity.setFondoCesantias((FacesUtils.checkLong(txtFondoCesantias) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtFondoCesantias))
					: null);
			
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
					: null);
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtContratistaId_Contratista))
					: null);
			entity.setEquipoTrabajo((FacesUtils.checkLong(txtEqpTrabId_EquipoTrabajo) != null)
					? businessDelegatorView.getEquipoTrabajo(FacesUtils.checkLong(txtEqpTrabId_EquipoTrabajo))
					: null);
			entity.setProfesion((FacesUtils.checkLong(txtProfId_Profesion) != null)
					? businessDelegatorView.getProfesion(FacesUtils.checkLong(txtProfId_Profesion))
					: null);

			entity.setTarifasArlId(FacesUtils.checkLong(txtTarifasArlId));		
			entity.setFechaRetiro(FacesUtils.checkDate(txtFechaRetiro));
			businessDelegatorView.saveTrabajador(entity, dataTarifaDeduccion, dataTarifaDevengos);
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
				Long trabId = new Long(selectedTrabajador.getTrabId());
				entity = businessDelegatorView.getTrabajador(trabId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setTipo_trabajador(FacesUtils.checkString(txtTipoTrabajador));
			
			entity.setOrigenDatos("Modulo_AdminAgricola");
			entity.setUsuario_asociado(FacesUtils.checkLong(txtUsuarioAsociado));
			entity.setClaseContrato(FacesUtils.checkString(txtClaseContrato));
			entity.setUbicacion(FacesUtils.checkString(txtUbicacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setnIdentificacion(FacesUtils.checkString(txtNIdentificacion));
			entity.setEstadoCivil(FacesUtils.checkString(txtEstadoCivil));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaAdmision(FacesUtils.checkDate(txtFechaAdmision));
			entity.setFechaModificacion(date);			
			entity.setFechaNacimiento(FacesUtils.checkDate(txtFechaNacimiento));
			entity.setSalario(FacesUtils.checkDouble(txtSalario));
			if (file != null) {
				entity.setFoto(file.getFileName());
				subirImagen();
			}
			
			entity.setGenero(FacesUtils.checkString(txtGenero));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(txtSegundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));
			entity.setNombre(FacesUtils.checkString(txtNombre)); 	 
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));
			entity.setBarrio(FacesUtils.checkString(txtBarrio));
			entity.setTipo_vivienda(FacesUtils.checkString(txtTipo_vivienda));
			entity.setCelular(FacesUtils.checkString(txtCelular));
			entity.setTipo_licencia_conduccion(FacesUtils.checkString(txtTipo_licencia_conduccion));
			entity.setNumero_licencia_conduccion(FacesUtils.checkString(txtNumero_licencia_conduccion));
			entity.setNum_pasado_judicial(FacesUtils.checkString(txtNum_pasado_judicial));
			entity.setNum_tarjeta_profesional(FacesUtils.checkString(txtNum_tarjeta_profesional));
			entity.setTipo_sangre(FacesUtils.checkString(txtTipo_sangre));
			entity.setNombre_eps(FacesUtils.checkString(txtNombre_eps));
			entity.setNombre_fondo_pension((FacesUtils.checkString(txtNombre_fondo_pension)));			
			entity.setNombre_fondo_cesantias(FacesUtils.checkString(txtNombre_fondo_cesantias));
			entity.setNombre_arp(FacesUtils.checkString(txtNombre_arp));
			entity.setNombre_caja_compensacion(FacesUtils.checkString(txtNombre_caja_compensacion));
			entity.setNumero_cuenta_bancaria(FacesUtils.checkString(txtNumero_cuenta_bancaria));			
			entity.setEnt_banc_id(FacesUtils.checkLong(txtEnt_banc_id));
			entity.setTipo_cuenta_bancaria(FacesUtils.checkString(txtTipo_cuenta_bancaria));
			entity.setNombres_conyugue(FacesUtils.checkString(txtNombres_conyugue));
			entity.setNumero_hijos(FacesUtils.checkLong(txtNumero_hijos));
			entity.setContacto_emergencia(FacesUtils.checkString(txtContacto_emergencia));
			entity.setContacto_emergencia_parentesco((FacesUtils.checkString(txtContacto_emergencia_parentesco)));			
			entity.setEstudio_bachillerato(FacesUtils.checkString(txtEstudio_bachillerato));
			entity.setEstudio_bachillerato_entidad(FacesUtils.checkString(txtEstudio_bachillerato_entidad));
			entity.setEstudio_tecnico(FacesUtils.checkString(txtEstudio_tecnico));
			entity.setEstudio_tecnico_titulo(FacesUtils.checkString(txtEstudio_tecnico_titulo));
			entity.setEstudio_tecnico_entidad(FacesUtils.checkString(txtEstudio_tecnico_entidad));
			entity.setEstudio_tecnologico(FacesUtils.checkString(txtEstudio_tecnologico));
			entity.setEstudio_tecnologico_titulo(FacesUtils.checkString(txtEstudio_tecnologico_titulo));
			entity.setEstudio_tecnologico_entidad(FacesUtils.checkString(txtEstudio_tecnologico_entidad));
			entity.setEstudio_pregrado(FacesUtils.checkString(txtEstudio_pregrado));
			entity.setEstudio_pregrado_titulo((FacesUtils.checkString(txtEstudio_pregrado_titulo)));			
			entity.setEstudio_pregrado_entidad(FacesUtils.checkString(txtEstudio_pregrado_entidad));
			entity.setEstudio_potsgrado(FacesUtils.checkString(txtEstudio_potsgrado));
			entity.setEstudio_potsgrado_titulo(FacesUtils.checkString(txtEstudio_potsgrado_titulo));
			entity.setEstudio_potsgrado_entidad(FacesUtils.checkString(txtEstudio_potsgrado_entidad));			
			entity.setEstudio_otros(FacesUtils.checkString(txtEstudio_otros));
			entity.setEstudio_otros_titulo(FacesUtils.checkString(txtEstudio_otros_titulo));
			entity.setEstudio_otros_entidad(FacesUtils.checkString(txtEstudio_otros_entidad));			
			entity.setPecargo1_nombre(FacesUtils.checkString(txtPecargo1_nombre));
			entity.setPecargo1_parentesco(FacesUtils.checkString(txtPecargo1_parentesco));
			entity.setPecargo1_edad((FacesUtils.checkLong(txtPecargo1_edad)));
			entity.setPecargo1_niveleducativo(FacesUtils.checkString(txtPecargo1_niveleducativo));			
			entity.setPecargo2_nombre(FacesUtils.checkString(txtPecargo2_nombre));
			entity.setPecargo2_parentesco(FacesUtils.checkString(txtPecargo2_parentesco));
			entity.setPecargo2_edad((FacesUtils.checkLong(txtPecargo2_edad)));
			entity.setPecargo2_niveleducativo(FacesUtils.checkString(txtPecargo2_niveleducativo));			
			entity.setPecargo3_nombre(FacesUtils.checkString(txtPecargo3_nombre));
			entity.setPecargo3_parentesco(FacesUtils.checkString(txtPecargo3_parentesco));
			entity.setPecargo3_edad((FacesUtils.checkLong(txtPecargo3_edad)));
			entity.setPecargo3_niveleducativo(FacesUtils.checkString(txtPecargo3_niveleducativo));			
			entity.setPecargo4_nombre(FacesUtils.checkString(txtPecargo4_nombre));
			entity.setPecargo4_parentesco(FacesUtils.checkString(txtPecargo4_parentesco));
			entity.setPecargo4_edad((FacesUtils.checkLong(txtPecargo4_edad)));
			entity.setPecargo4_niveleducativo(FacesUtils.checkString(txtPecargo4_niveleducativo));			
			entity.setPecargo5_nombre(FacesUtils.checkString(txtPecargo5_nombre));
			entity.setPecargo5_parentesco(FacesUtils.checkString(txtPecargo5_parentesco));
			entity.setPecargo5_edad((FacesUtils.checkLong(txtPecargo5_edad)));
			entity.setPecargo5_niveleducativo(FacesUtils.checkString(txtPecargo5_niveleducativo));
			
			entity.setAportaEps((Boolean) txtAportaEps.getValue() ? "S" : "N");
			entity.setEmpleadorAportaEps((Boolean) txtEmpleadorAportaEps.getValue() ? "S" : "N");
			entity.setFechaInicioEps(FacesUtils.checkDate(txtFechaInicioEps));
			entity.setAportaAfp((Boolean) txtAportaAfp.getValue() ? "S" : "N");
			entity.setFechaInicioAfp(FacesUtils.checkDate(txtFechaInicioAfp));
			entity.setAportaCcf((Boolean) txtAportaCcf.getValue() ? "S" : "N");
			entity.setAportaArl((Boolean) txtAportaArl.getValue() ? "S" : "N");
			entity.setAportaIcbf((Boolean) txtAportaIcbf.getValue() ? "S" : "N");
			entity.setAportaSena((Boolean) txtAportaSena.getValue() ? "S" : "N");
			entity.setAltoRiesgo((Boolean) txtAltoRiesgo.getValue() ? "S" : "N");
			entity.setTarifaCajaCompensacion(FacesUtils.checkDouble(txtTarifaCajaCompensacion));
			entity.setClaseTarifaArl(FacesUtils.checkString(txtClaseTarifaArl));
			entity.setTarifaArl(FacesUtils.checkDouble(txtTarifaArl));
			entity.setTarifaIcbf(FacesUtils.checkDouble(txtTarifaIcbf));
			entity.setTarifaSena(FacesUtils.checkDouble(txtTarifaSena));			
			
			entity.setTipoCotizante((FacesUtils.checkLong(txtTipoCotizante) != null)
					? businessDelegator2View.getTipoCotizante(FacesUtils.checkLong(txtTipoCotizante))
					: null);
			entity.setEpsActual((FacesUtils.checkLong(txtEpsActual) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtEpsActual))
					: null);
			entity.setEpsAnterior((FacesUtils.checkLong(txtEpsAnterior) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtEpsAnterior))
					: null);
			entity.setSubTipoCotizante((FacesUtils.checkLong(txtSubTipoCotizante) != null)
					? businessDelegator2View.getSubTipoCotizante(FacesUtils.checkLong(txtSubTipoCotizante))
					: null);
			entity.setAfpActual((FacesUtils.checkLong(txtAfpActual) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtAfpActual))
					: null);
			entity.setAfpAnterior((FacesUtils.checkLong(txtAfpAnterior) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtAfpAnterior))
					: null);
			entity.setCajaCompensacion((FacesUtils.checkLong(txtCajaCompensacion) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtCajaCompensacion))
					: null);
			entity.setArl((FacesUtils.checkLong(txtArl) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtArl))
					: null);
			entity.setFondoCesantias((FacesUtils.checkLong(txtFondoCesantias) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtFondoCesantias))
					: null);
			
			entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
					? businessDelegatorView.getCentCost(FacesUtils.checkLong(txtCentCostId_CentCost))
					: null);
			entity.setContratista((FacesUtils.checkLong(txtContratistaId_Contratista) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtContratistaId_Contratista))
					: null);
			entity.setEquipoTrabajo((FacesUtils.checkLong(txtEqpTrabId_EquipoTrabajo) != null)
					? businessDelegatorView.getEquipoTrabajo(FacesUtils.checkLong(txtEqpTrabId_EquipoTrabajo))
					: null);
			entity.setProfesion((FacesUtils.checkLong(txtProfId_Profesion) != null)
					? businessDelegatorView.getProfesion(FacesUtils.checkLong(txtProfId_Profesion))
					: null);
			entity.setTarifasArlId(FacesUtils.checkLong(txtTarifasArlId));		
			entity.setFechaRetiro(FacesUtils.checkDate(txtFechaRetiro));
			businessDelegatorView.updateTrabajador(entity, dataTarifaDeduccion, dataTarifaDevengos);
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
			selectedTrabajador = (TrabajadorDTO) (evt.getComponent().getAttributes().get("selectedTrabajador"));

			Long trabId = new Long(selectedTrabajador.getTrabId());
			entity = businessDelegatorView.getTrabajador(trabId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long trabId = FacesUtils.checkLong(txtTrabId);
			entity = businessDelegatorView.getTrabajador(trabId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTrabajador(entity);
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
			selectedTrabajador = (TrabajadorDTO) (evt.getComponent().getAttributes().get("selectedTrabajador"));

			Long trabId = new Long(selectedTrabajador.getTrabId());
			entity = businessDelegatorView.getTrabajador(trabId);
			businessDelegatorView.deleteTrabajador(entity);
			((Map<String, Object>) data).remove(selectedTrabajador);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long compania, String email, String direccion, String estadoCivil,
			String nIdentificacion, String estado, Date fechaAdmision, Date fechaCreacion, Date fechaModificacion,
			Date fechaNacimiento, String foto, String genero, String infoAdicional, String infoAdicional2,
			String nombre, String primerApellido, String primerNombre, String segundoApellido, String segundoNombre,
			String telefono, Long trabId, Long centCostId_CentCost, Long ciudadId_Ciudad,
			Long contratistaId_Contratista, Long eqpTrabId_EquipoTrabajo, Long profId_Profesion) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setnIdentificacion(FacesUtils.checkString(nIdentificacion));
			entity.setEstadoCivil(FacesUtils.checkString(estadoCivil));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAdmision(FacesUtils.checkDate(fechaAdmision));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaNacimiento(FacesUtils.checkDate(fechaNacimiento));
			entity.setFoto(FacesUtils.checkString(foto));
			entity.setGenero(FacesUtils.checkString(genero));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPrimerApellido(FacesUtils.checkString(primerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(primerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(segundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(segundoNombre));
			entity.setTelefono(FacesUtils.checkString(telefono));
			businessDelegatorView.updateTrabajador(entity, dataTarifaDeduccion, dataTarifaDevengos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TrabajadorView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String actionDeleteTarifaDeduccion(ActionEvent evt) {
		try {

			selectedTarifaDeduccion = (TarifaDeduccionDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaDeduccion"));

			if (selectedTarifaDeduccion.getDeduccionId() == null) {
				dataTarifaDeduccion.remove(selectedTarifaDeduccion);
			} else {
				Long deduccionId = new Long(selectedTarifaDeduccion.getDeduccionId());
				TarifaDeduccion entity = businessDelegatorView.getTarifaDeduccion(deduccionId);
				businessDelegatorView.deleteTarifaDeduccion(entity);
				dataTarifaDeduccion.remove(selectedTarifaDeduccion);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteTarifaDevengos(ActionEvent evt) {
		try {

			selectedTarifaDevengos = (TarifaOtrosDevengosDTO) (evt.getComponent().getAttributes()
					.get("selectedTarifaDevengos"));

			if (selectedTarifaDevengos.getOdevengosId() == null) {
				dataTarifaDevengos.remove(selectedTarifaDevengos);
			} else {
				Long odevengosId = new Long(selectedTarifaDevengos.getOdevengosId());
				TarifaOtrosDevengos entity = businessDelegatorView.getTarifaOtrosDevengos(odevengosId);
				businessDelegatorView.deleteTarifaOtrosDevengos(entity);
				dataTarifaDevengos.remove(selectedTarifaDevengos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void onCellEditSalarios(CellEditEvent event) throws Exception {

		selectedTarifaDevengos = (TarifaOtrosDevengosDTO) (event.getComponent().getAttributes()
				.get("selectedTarifaDevengos"));

		if (selectedTarifaDevengos.getOdevengosId() != null) {

			Long tarifaDevengosId = selectedTarifaDevengos.getOdevengosId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long tarifa = FacesUtils.checkLong(txtTrabId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityTarifaDevengos = null;
				Date fechaModificacion = new Date();

				entityTarifaDevengos = businessDelegatorView.getTarifaOtrosDevengos(tarifaDevengosId);

				if (columnaCell.equals("F. Inicial")) {

					entityTarifaDevengos.setFechaInicial((Date) newValue);

				} else if (columnaCell.equals("F. Final")) {

					entityTarifaDevengos.setFechaFinal((Date) newValue);

				} else if (columnaCell.equals("Cepto. nómina")) {

					Long servicioId = new Long(event.getNewValue().toString());
					ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(servicioId);

					entityTarifaDevengos.setConceptoNominaId(conceptoNomina);

				} else if (columnaCell.equals("Tarifa")) {

					Double Deduccion = new Double(event.getNewValue().toString());

					entityTarifaDevengos.setValorDeduccion(Deduccion);

				}/* else if (columnaCell.equals("G. Dom/Fest?")) {

					entityTarifaDevengos.setGeneraDomingosFestivos((String) newValue);

				} else if (columnaCell.equals("Es Aux Transp.?")) {

					entityTarifaDevengos.setGeneraAuxilioTransp((String) newValue);

				} else if (columnaCell.equals("Cepto Alternativo")) {

					Long servicioId = new Long(event.getNewValue().toString());
					ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(servicioId);

					entityTarifaDevengos.setCeptoNominaAlternativo(conceptoNomina);

				} else if (columnaCell.equals("H(Día)")) {

					entityTarifaDevengos.setHorasDia((Double) newValue);

				} else if (columnaCell.equals("H(Mes)")) {

					entityTarifaDevengos.setHorasMes((Double) newValue);

				}*/
				entity = businessDelegatorView.getTrabajador(tarifa);
				entityTarifaDevengos.setTrabId(entity);
				entityTarifaDevengos.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTarifaOtrosDevengos(entityTarifaDevengos);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataTarifaDevengos = null;
				entityTarifaDevengos = null;
				selectedTarifaDevengos = null;
				entity = null;

				dataTarifaDevengos = businessDelegatorView.getDataTarifaOtrosDevengosByTrabajador(tarifa);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}

	public void onCellEditDeduccion(CellEditEvent event) throws Exception {

		selectedTarifaDeduccion = (TarifaDeduccionDTO) (event.getComponent().getAttributes()
				.get("selectedTarifaDeduccion"));

		if (selectedTarifaDeduccion.getDeduccionId() != null) {

			Long tarifaDeduccionId = selectedTarifaDeduccion.getDeduccionId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long trabajador = FacesUtils.checkLong(txtTrabId);

			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();

			if (newValue != null && !newValue.equals(oldValue)) {

				entityTarifaDeduccion = null;
				Date fechaModificacion = new Date();

				entityTarifaDeduccion = businessDelegatorView.getTarifaDeduccion(tarifaDeduccionId);

				if (columnaCell.equals("F. Inicial")) {

					entityTarifaDeduccion.setFechaInicial((Date) newValue);

				} else if (columnaCell.equals("F. Final")) {

					entityTarifaDeduccion.setFechaFinal((Date) newValue);

				} else if (columnaCell.equals("Cepto. nómina")) {

					Long deduccionId = new Long(event.getNewValue().toString());
					ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(deduccionId);

					entityTarifaDeduccion.setConceptoNominaId(conceptoNomina);

				} else if (columnaCell.equals("Tarifa")) {

					Double Deduccion = new Double(event.getNewValue().toString());

					entityTarifaDeduccion.setValorDeduccion(Deduccion);
				}

				entity = businessDelegatorView.getTrabajador(trabajador);
				entityTarifaDeduccion.setTrabajador(entity);
				entityTarifaDeduccion.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTarifaDeduccion(entityTarifaDeduccion);

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				dataTarifaDeduccion = null;
				entityTarifaDeduccion = null;
				selectedTarifaDeduccion = null;
				entity = null;

				dataTarifaDeduccion = businessDelegatorView.getDataTarifaDeduccionByTrabajador(trabajador);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

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

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtNIdentificacion() {
		return txtNIdentificacion;
	}

	public void setTxtNIdentificacion(InputText txtNIdentificacion) {
		this.txtNIdentificacion = txtNIdentificacion;
	}

	public SelectOneMenu getTxtEstadoCivil() {
		return txtEstadoCivil;
	}

	public void setTxtEstadoCivil(SelectOneMenu txtEstadoCivil) {
		this.txtEstadoCivil = txtEstadoCivil;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtFoto() {
		return txtFoto;
	}

	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
	}

	public SelectOneRadio getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(SelectOneRadio txtGenero) {
		this.txtGenero = txtGenero;
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

	public InputText getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	public void setTxtPrimerApellido(InputText txtPrimerApellido) {
		this.txtPrimerApellido = txtPrimerApellido;
	}

	public InputText getTxtPrimerNombre() {
		return txtPrimerNombre;
	}

	public void setTxtPrimerNombre(InputText txtPrimerNombre) {
		this.txtPrimerNombre = txtPrimerNombre;
	}

	public InputText getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	public void setTxtSegundoApellido(InputText txtSegundoApellido) {
		this.txtSegundoApellido = txtSegundoApellido;
	}

	public InputText getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	public void setTxtSegundoNombre(InputText txtSegundoNombre) {
		this.txtSegundoNombre = txtSegundoNombre;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtCiudadId_Ciudad() {
		return txtCiudadId_Ciudad;
	}

	public void setTxtCiudadId_Ciudad(SelectOneMenu txtCiudadId_Ciudad) {
		this.txtCiudadId_Ciudad = txtCiudadId_Ciudad;
	}

	public SelectOneMenu getTxtContratistaId_Contratista() {
		return txtContratistaId_Contratista;
	}

	public void setTxtContratistaId_Contratista(SelectOneMenu txtContratistaId_Contratista) {
		this.txtContratistaId_Contratista = txtContratistaId_Contratista;
	}

	public SelectOneMenu getTxtEqpTrabId_EquipoTrabajo() {
		return txtEqpTrabId_EquipoTrabajo;
	}

	public void setTxtEqpTrabId_EquipoTrabajo(SelectOneMenu txtEqpTrabId_EquipoTrabajo) {
		this.txtEqpTrabId_EquipoTrabajo = txtEqpTrabId_EquipoTrabajo;
	}

	public SelectOneMenu getTxtProfId_Profesion() {
		return txtProfId_Profesion;
	}

	public void setTxtProfId_Profesion(SelectOneMenu txtProfId_Profesion) {
		this.txtProfId_Profesion = txtProfId_Profesion;
	}

	public Calendar getTxtFechaAdmision() {
		return txtFechaAdmision;
	}

	public void setTxtFechaAdmision(Calendar txtFechaAdmision) {
		this.txtFechaAdmision = txtFechaAdmision;
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

	public Calendar getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(Calendar txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public InputText getTxtTrabId() {
		return txtTrabId;
	}

	public void setTxtTrabId(InputText txtTrabId) {
		this.txtTrabId = txtTrabId;
	}

	public LazyDataModel<TrabajadorDTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataTrabajador();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<TrabajadorDTO> trabajadorDTO) {
		this.data = trabajadorDTO;
	}

	public TrabajadorDTO getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(TrabajadorDTO trabajador) {
		this.selectedTrabajador = trabajador;
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public SelectItem[] getSelectCentCost() {

		if (selectCentCost == null || selectCentCost.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCost = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCost[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCost;
	}

	public void setSelectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getSelectCiudad() {

		if (selectCiudad == null || selectCiudad.length == 0) {

			try {
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudad = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudad : lista) {
					selectCiudad[i] = new SelectItem(ciudad.getCiudadId(), ciudad.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudad;
	}

	public void setSelectCiudad(SelectItem[] selectCiudad) {
		this.selectCiudad = selectCiudad;
	}

	public SelectItem[] getSelectContratista() {

		if (selectContratista == null || selectContratista.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratista;
	}

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectItem[] getSelectProfesion() {

		if (selectProfesion == null || selectProfesion.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Profesion> lista = businessDelegatorView.findByCriteriaInProfesion(condicion, null, null);
				selectProfesion = new SelectItem[lista.size()];

				int i = 0;
				for (Profesion profesion : lista) {
					selectProfesion[i] = new SelectItem(profesion.getProfId(), profesion.getNombre());
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

	public SelectItem[] getSelectEquipoTrabajo() {

		if (selectEquipoTrabajo == null || selectEquipoTrabajo.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<EquipoTrabajo> lista = businessDelegatorView.findByCriteriaInEquipoTrabajo(condicion, null, null);
				selectEquipoTrabajo = new SelectItem[lista.size()];

				int i = 0;
				for (EquipoTrabajo equipoTrabajo : lista) {
					selectEquipoTrabajo[i] = new SelectItem(equipoTrabajo.getEqpTrabId(), equipoTrabajo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipoTrabajo;
	}

	public void setSelectEquipoTrabajo(SelectItem[] selectEquipoTrabajo) {
		this.selectEquipoTrabajo = selectEquipoTrabajo;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;

		if (file != null) {
			this.txtImagenTrabajador = file.getFileName();
		}
	}

	public String getTxtImagenTrabajador() {
		return txtImagenTrabajador;
	}

	public void setTxtImagenTrabajador(String txtImagenTrabajador) {
		this.txtImagenTrabajador = txtImagenTrabajador;
	}

	public String getimagenTrabajador() {
		return imagenTrabajador;
	}

	public void setImagenTrabajador(String imagenTrabajador) {
		this.imagenTrabajador = imagenTrabajador;
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

			imagenTrabajador = fileName;

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

	private class LocalDataModelDTO extends LazyDataModel<TrabajadorDTO> {
		private static final long serialVersionUID = 1L;
		private List<TrabajadorDTO> trabajadorDTO;

		public LocalDataModelDTO() {
		}

		@Override
		public List<TrabajadorDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			moduloSeleccionado();
			String modulo = "Modulo_AdminAgricola";// txtOrigenDatos.getValue().toString();

			if (filters != null) {
				trabajadorDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters, modulo);
				try {
					setRowCount(businessDelegatorView.findTotalNumberTrabajador(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return trabajadorDTO;

		}

		@Override
		public TrabajadorDTO getRowData(String rowKey) {
			for (TrabajadorDTO trabajadorDTOtmp : trabajadorDTO) {
				if (trabajadorDTOtmp.getTrabId().toString().equals(rowKey))
					return trabajadorDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(TrabajadorDTO trabajadorDTOtmp) {
			return trabajadorDTOtmp.getTrabId();
		}

	}

	private List<TrabajadorDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) {
		try {
			return businessDelegatorView.getDataPageTrabajador(startRow, pageSize, sortField, sortOrder, filters,
					modulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public SelectOneRadio getTxtClaseContrato() {
		return txtClaseContrato;
	}

	public void setTxtClaseContrato(SelectOneRadio txtClaseContrato) {
		this.txtClaseContrato = txtClaseContrato;
	}

	public SelectOneMenu getTxtCeptoNominaIdDeducciones() {
		return txtCeptoNominaIdDeducciones;
	}

	public void setTxtCeptoNominaIdDeducciones(SelectOneMenu txtCeptoNominaIdDeducciones) {
		this.txtCeptoNominaIdDeducciones = txtCeptoNominaIdDeducciones;
	}

	public SelectOneMenu getTxtCeptoNominaIdDevengos() {
		return txtCeptoNominaIdDevengos;
	}

	public void setTxtCeptoNominaIdDevengos(SelectOneMenu txtCeptoNominaIdDevengos) {
		this.txtCeptoNominaIdDevengos = txtCeptoNominaIdDevengos;
	}

	public Calendar getTxtFechaInicial1() {
		return txtFechaInicial1;
	}

	public void setTxtFechaInicial1(Calendar txtFechaInicial1) {
		this.txtFechaInicial1 = txtFechaInicial1;
	}

	public Calendar getTxtFechaFinal1() {
		return txtFechaFinal1;
	}

	public void setTxtFechaFinal1(Calendar txtFechaFinal1) {
		this.txtFechaFinal1 = txtFechaFinal1;
	}

	public InputText getTxtTarifaDeduccion() {
		return txtTarifaDeduccion;
	}

	public void setTxtTarifaDeduccion(InputText txtTarifaDeduccion) {
		this.txtTarifaDeduccion = txtTarifaDeduccion;
	}

	public Calendar getTxtFechaInicial2() {
		return txtFechaInicial2;
	}

	public void setTxtFechaInicial2(Calendar txtFechaInicial2) {
		this.txtFechaInicial2 = txtFechaInicial2;
	}

	public Calendar getTxtFechaFinal2() {
		return txtFechaFinal2;
	}

	public void setTxtFechaFinal2(Calendar txtFechaFinal2) {
		this.txtFechaFinal2 = txtFechaFinal2;
	}

	public InputText getTxtTarifaDevengos() {
		return txtTarifaDevengos;
	}

	public void setTxtTarifaDevengos(InputText txtTarifaDevengos) {
		this.txtTarifaDevengos = txtTarifaDevengos;
	}

	public SelectItem[] getSelectCeptoNomina1() {

		if (selectCeptoNomina1 == null || selectCeptoNomina1.length == 0) {
		
			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
				selectCeptoNomina1 = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNomina1[i] = new SelectItem(conceptoNomina.getCeptoNominaId(), conceptoNomina.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNomina1;
	}

	public void setSelectCeptoNomina1(SelectItem[] selectCeptoNomina1) {
		this.selectCeptoNomina1 = selectCeptoNomina1;
	}

	public SelectItem[] getSelectCeptoNomina2() {

		if (selectCeptoNomina2 == null || selectCeptoNomina2.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
				selectCeptoNomina2 = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNomina2[i] = new SelectItem(conceptoNomina.getCeptoNominaId(), conceptoNomina.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNomina2;
	}

	public void setSelectCeptoNomina2(SelectItem[] selectCeptoNomina2) {
		this.selectCeptoNomina2 = selectCeptoNomina2;
	}

	public List<TarifaDeduccionDTO> getDataTarifaDeduccion() {
		return dataTarifaDeduccion;
	}

	public void setDataTarifaDeduccion(List<TarifaDeduccionDTO> dataTarifaDeduccion) {
		this.dataTarifaDeduccion = dataTarifaDeduccion;
	}

	public CommandButton getBtnAgregar1() {
		return btnAgregar1;
	}

	public void setBtnAgregar1(CommandButton btnAgregar1) {
		this.btnAgregar1 = btnAgregar1;
	}

	public List<TarifaOtrosDevengosDTO> getDataTarifaDevengos() {
		return dataTarifaDevengos;
	}

	public void setDataTarifaDevengos(List<TarifaOtrosDevengosDTO> dataTarifaDevengos) {
		this.dataTarifaDevengos = dataTarifaDevengos;
	}

	public CommandButton getBtnAgregar2() {
		return btnAgregar2;
	}

	public void setBtnAgregar2(CommandButton btnAgregar2) {
		this.btnAgregar2 = btnAgregar2;
	}

	public InputText getTxtCodConceptDeduccion() {
		return txtCodConceptDeduccion;
	}

	public void setTxtCodConceptDeduccion(InputText txtCodConceptDeduccion) {
		this.txtCodConceptDeduccion = txtCodConceptDeduccion;
	}

	public InputText getTxtCodConceptDevengo() {
		return txtCodConceptDevengo;
	}

	public void setTxtCodConceptDevengo(InputText txtCodConceptDevengo) {
		this.txtCodConceptDevengo = txtCodConceptDevengo;
	}

	public InputText getTxtUbicacion() {
		return txtUbicacion;
	}

	public void setTxtUbicacion(InputText txtUbicacion) {
		this.txtUbicacion = txtUbicacion;
	}

	public SelectOneMenu getTxtCeptoNominaAlternativo() {
		return txtCeptoNominaAlternativo;
	}

	public void setTxtCeptoNominaAlternativo(SelectOneMenu txtCeptoNominaAlternativo) {
		this.txtCeptoNominaAlternativo = txtCeptoNominaAlternativo;
	}

	public SelectOneRadio getTxtGeneraDomingosFestivos() {
		return txtGeneraDomingosFestivos;
	}

	public void setTxtGeneraDomingosFestivos(SelectOneRadio txtGeneraDomingosFestivos) {
		this.txtGeneraDomingosFestivos = txtGeneraDomingosFestivos;
	}

	public SelectOneRadio getTxtGeneraAuxilioTransp() {
		return txtGeneraAuxilioTransp;
	}

	public void setTxtGeneraAuxilioTransp(SelectOneRadio txtGeneraAuxilioTransp) {
		this.txtGeneraAuxilioTransp = txtGeneraAuxilioTransp;
	}

	public InputText getTxtHorasDia() {
		return txtHorasDia;
	}

	public void setTxtHorasDia(InputText txtHorasDia) {
		this.txtHorasDia = txtHorasDia;
	}

	public InputText getTxtHorasMes() {
		return txtHorasMes;
	}

	public void setTxtHorasMes(InputText txtHorasMes) {
		this.txtHorasMes = txtHorasMes;
	}

	public InputText getTxtCodConceptoAlternativo() {
		return txtCodConceptoAlternativo;
	}

	public void setTxtCodConceptoAlternativo(InputText txtCodConceptoAlternativo) {
		this.txtCodConceptoAlternativo = txtCodConceptoAlternativo;
	}

	public SelectItem[] getSelectCeptoNomina3() {

		if (selectCeptoNomina3 == null || selectCeptoNomina3.length == 0) {

			try {				
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
				selectCeptoNomina3 = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNomina3[i] = new SelectItem(conceptoNomina.getCeptoNominaId(), conceptoNomina.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNomina3;
	}

	public void setSelectCeptoNomina3(SelectItem[] selectCeptoNomina3) {
		this.selectCeptoNomina3 = selectCeptoNomina3;
	}

	public SelectOneRadio getTxtGeneraAuxilioAdmon() {
		return txtGeneraAuxilioAdmon;
	}

	public void setTxtGeneraAuxilioAdmon(SelectOneRadio txtGeneraAuxilioAdmon) {
		this.txtGeneraAuxilioAdmon = txtGeneraAuxilioAdmon;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
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
	
	public SelectItem[] getSelectEntBanc() {

		if (selectEntBanc == null || selectEntBanc.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<EntBanc> lista = businessDelegatorView.findByCriteriaInEntBanc(condicion, null, null);
				selectEntBanc = new SelectItem[lista.size()];

				int i = 0;
				for (EntBanc entBancId : lista) {
					selectEntBanc[i] = new SelectItem(entBancId.getEntBancId(), entBancId.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEntBanc;
	}

	public void setSelectEntBanc(SelectItem[] selectEntBanc) {
		this.selectEntBanc = selectEntBanc;
	}

	/**
	 * @return the txtLaborId_Labor
	 */
	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	/**
	 * @param txtLaborId_Labor the txtLaborId_Labor to set
	 */
	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtOrigenDatos() {
		return txtOrigenDatos;
	}

	public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
		this.txtOrigenDatos = txtOrigenDatos;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public InputText getTxtBarrio() {
		return txtBarrio;
	}

	public void setTxtBarrio(InputText txtBarrio) {
		this.txtBarrio = txtBarrio;
	}

	public SelectOneMenu getTxtTipo_vivienda() {
		return txtTipo_vivienda;
	}

	public void setTxtTipo_vivienda(SelectOneMenu txtTipo_vivienda) {
		this.txtTipo_vivienda = txtTipo_vivienda;
	}

	public InputText getTxtCelular() {
		return txtCelular;
	}

	public void setTxtCelular(InputText txtCelular) {
		this.txtCelular = txtCelular;
	}

	public SelectOneMenu getTxtTipo_licencia_conduccion() {
		return txtTipo_licencia_conduccion;
	}

	public void setTxtTipo_licencia_conduccion(SelectOneMenu txtTipo_licencia_conduccion) {
		this.txtTipo_licencia_conduccion = txtTipo_licencia_conduccion;
	}

	public InputText getTxtNumero_licencia_conduccion() {
		return txtNumero_licencia_conduccion;
	}

	public void setTxtNumero_licencia_conduccion(InputText txtNumero_licencia_conduccion) {
		this.txtNumero_licencia_conduccion = txtNumero_licencia_conduccion;
	}

	public InputText getTxtNum_pasado_judicial() {
		return txtNum_pasado_judicial;
	}

	public void setTxtNum_pasado_judicial(InputText txtNum_pasado_judicial) {
		this.txtNum_pasado_judicial = txtNum_pasado_judicial;
	}

	public InputText getTxtNum_tarjeta_profesional() {
		return txtNum_tarjeta_profesional;
	}

	public void setTxtNum_tarjeta_profesional(InputText txtNum_tarjeta_profesional) {
		this.txtNum_tarjeta_profesional = txtNum_tarjeta_profesional;
	}

	public SelectOneMenu getTxtTipo_sangre() {
		return txtTipo_sangre;
	}

	public void setTxtTipo_sangre(SelectOneMenu txtTipo_sangre) {
		this.txtTipo_sangre = txtTipo_sangre;
	}

	public InputTextarea getTxtNombre_eps() {
		return txtNombre_eps;
	}

	public void setTxtNombre_eps(InputTextarea txtNombre_eps) {
		this.txtNombre_eps = txtNombre_eps;
	}

	public InputTextarea getTxtNombre_fondo_pension() {
		return txtNombre_fondo_pension;
	}

	public void setTxtNombre_fondo_pension(InputTextarea txtNombre_fondo_pension) {
		this.txtNombre_fondo_pension = txtNombre_fondo_pension;
	}

	public InputTextarea getTxtNombre_fondo_cesantias() {
		return txtNombre_fondo_cesantias;
	}

	public void setTxtNombre_fondo_cesantias(InputTextarea txtNombre_fondo_cesantias) {
		this.txtNombre_fondo_cesantias = txtNombre_fondo_cesantias;
	}

	public InputTextarea getTxtNombre_arp() {
		return txtNombre_arp;
	}

	public void setTxtNombre_arp(InputTextarea txtNombre_arp) {
		this.txtNombre_arp = txtNombre_arp;
	}

	public InputTextarea getTxtNombre_caja_compensacion() {
		return txtNombre_caja_compensacion;
	}

	public void setTxtNombre_caja_compensacion(InputTextarea txtNombre_caja_compensacion) {
		this.txtNombre_caja_compensacion = txtNombre_caja_compensacion;
	}

	public InputText getTxtNumero_cuenta_bancaria() {
		return txtNumero_cuenta_bancaria;
	}

	public void setTxtNumero_cuenta_bancaria(InputText txtNumero_cuenta_bancaria) {
		this.txtNumero_cuenta_bancaria = txtNumero_cuenta_bancaria;
	}

	public SelectOneMenu getTxtEnt_banc_id() {
		return txtEnt_banc_id;
	}

	public void setTxtEnt_banc_id(SelectOneMenu txtEnt_banc_id) {
		this.txtEnt_banc_id = txtEnt_banc_id;
	}

	public SelectOneMenu getTxtTipo_cuenta_bancaria() {
		return txtTipo_cuenta_bancaria;
	}

	public void setTxtTipo_cuenta_bancaria(SelectOneMenu txtTipo_cuenta_bancaria) {
		this.txtTipo_cuenta_bancaria = txtTipo_cuenta_bancaria;
	}

	public InputTextarea getTxtNombres_conyugue() {
		return txtNombres_conyugue;
	}

	public void setTxtNombres_conyugue(InputTextarea txtNombres_conyugue) {
		this.txtNombres_conyugue = txtNombres_conyugue;
	}

	public Spinner getTxtNumero_hijos() {
		return txtNumero_hijos;
	}

	public void setTxtNumero_hijos(Spinner txtNumero_hijos) {
		this.txtNumero_hijos = txtNumero_hijos;
	}

	public InputTextarea getTxtContacto_emergencia() {
		return txtContacto_emergencia;
	}

	public void setTxtContacto_emergencia(InputTextarea txtContacto_emergencia) {
		this.txtContacto_emergencia = txtContacto_emergencia;
	}

	public SelectOneMenu getTxtContacto_emergencia_parentesco() {
		return txtContacto_emergencia_parentesco;
	}

	public void setTxtContacto_emergencia_parentesco(SelectOneMenu txtContacto_emergencia_parentesco) {
		this.txtContacto_emergencia_parentesco = txtContacto_emergencia_parentesco;
	}

	public SelectOneMenu getTxtEstudio_bachillerato() {
		return txtEstudio_bachillerato;
	}

	public void setTxtEstudio_bachillerato(SelectOneMenu txtEstudio_bachillerato) {
		this.txtEstudio_bachillerato = txtEstudio_bachillerato;
	}

	public InputTextarea getTxtEstudio_bachillerato_entidad() {
		return txtEstudio_bachillerato_entidad;
	}

	public void setTxtEstudio_bachillerato_entidad(InputTextarea txtEstudio_bachillerato_entidad) {
		this.txtEstudio_bachillerato_entidad = txtEstudio_bachillerato_entidad;
	}

	public SelectOneMenu getTxtEstudio_tecnico() {
		return txtEstudio_tecnico;
	}

	public void setTxtEstudio_tecnico(SelectOneMenu txtEstudio_tecnico) {
		this.txtEstudio_tecnico = txtEstudio_tecnico;
	}

	public InputTextarea getTxtEstudio_tecnico_titulo() {
		return txtEstudio_tecnico_titulo;
	}

	public void setTxtEstudio_tecnico_titulo(InputTextarea txtEstudio_tecnico_titulo) {
		this.txtEstudio_tecnico_titulo = txtEstudio_tecnico_titulo;
	}

	public InputTextarea getTxtEstudio_tecnico_entidad() {
		return txtEstudio_tecnico_entidad;
	}

	public void setTxtEstudio_tecnico_entidad(InputTextarea txtEstudio_tecnico_entidad) {
		this.txtEstudio_tecnico_entidad = txtEstudio_tecnico_entidad;
	}

	public SelectOneMenu getTxtEstudio_tecnologico() {
		return txtEstudio_tecnologico;
	}

	public void setTxtEstudio_tecnologico(SelectOneMenu txtEstudio_tecnologico) {
		this.txtEstudio_tecnologico = txtEstudio_tecnologico;
	}

	public InputTextarea getTxtEstudio_tecnologico_titulo() {
		return txtEstudio_tecnologico_titulo;
	}

	public void setTxtEstudio_tecnologico_titulo(InputTextarea txtEstudio_tecnologico_titulo) {
		this.txtEstudio_tecnologico_titulo = txtEstudio_tecnologico_titulo;
	}

	public InputTextarea getTxtEstudio_tecnologico_entidad() {
		return txtEstudio_tecnologico_entidad;
	}

	public void setTxtEstudio_tecnologico_entidad(InputTextarea txtEstudio_tecnologico_entidad) {
		this.txtEstudio_tecnologico_entidad = txtEstudio_tecnologico_entidad;
	}

	public SelectOneMenu getTxtEstudio_pregrado() {
		return txtEstudio_pregrado;
	}

	public void setTxtEstudio_pregrado(SelectOneMenu txtEstudio_pregrado) {
		this.txtEstudio_pregrado = txtEstudio_pregrado;
	}

	public InputTextarea getTxtEstudio_pregrado_titulo() {
		return txtEstudio_pregrado_titulo;
	}

	public void setTxtEstudio_pregrado_titulo(InputTextarea txtEstudio_pregrado_titulo) {
		this.txtEstudio_pregrado_titulo = txtEstudio_pregrado_titulo;
	}

	public InputTextarea getTxtEstudio_pregrado_entidad() {
		return txtEstudio_pregrado_entidad;
	}

	public void setTxtEstudio_pregrado_entidad(InputTextarea txtEstudio_pregrado_entidad) {
		this.txtEstudio_pregrado_entidad = txtEstudio_pregrado_entidad;
	}

	public SelectOneMenu getTxtEstudio_potsgrado() {
		return txtEstudio_potsgrado;
	}

	public void setTxtEstudio_potsgrado(SelectOneMenu txtEstudio_potsgrado) {
		this.txtEstudio_potsgrado = txtEstudio_potsgrado;
	}

	public InputTextarea getTxtEstudio_potsgrado_titulo() {
		return txtEstudio_potsgrado_titulo;
	}

	public void setTxtEstudio_potsgrado_titulo(InputTextarea txtEstudio_potsgrado_titulo) {
		this.txtEstudio_potsgrado_titulo = txtEstudio_potsgrado_titulo;
	}

	public InputTextarea getTxtEstudio_potsgrado_entidad() {
		return txtEstudio_potsgrado_entidad;
	}

	public void setTxtEstudio_potsgrado_entidad(InputTextarea txtEstudio_potsgrado_entidad) {
		this.txtEstudio_potsgrado_entidad = txtEstudio_potsgrado_entidad;
	}

	public SelectOneMenu getTxtEstudio_otros() {
		return txtEstudio_otros;
	}

	public void setTxtEstudio_otros(SelectOneMenu txtEstudio_otros) {
		this.txtEstudio_otros = txtEstudio_otros;
	}

	public InputTextarea getTxtEstudio_otros_titulo() {
		return txtEstudio_otros_titulo;
	}

	public void setTxtEstudio_otros_titulo(InputTextarea txtEstudio_otros_titulo) {
		this.txtEstudio_otros_titulo = txtEstudio_otros_titulo;
	}

	public InputTextarea getTxtEstudio_otros_entidad() {
		return txtEstudio_otros_entidad;
	}

	public void setTxtEstudio_otros_entidad(InputTextarea txtEstudio_otros_entidad) {
		this.txtEstudio_otros_entidad = txtEstudio_otros_entidad;
	}

	public InputTextarea getTxtPecargo1_nombre() {
		return txtPecargo1_nombre;
	}

	public void setTxtPecargo1_nombre(InputTextarea txtPecargo1_nombre) {
		this.txtPecargo1_nombre = txtPecargo1_nombre;
	}

	public SelectOneMenu getTxtPecargo1_parentesco() {
		return txtPecargo1_parentesco;
	}

	public void setTxtPecargo1_parentesco(SelectOneMenu txtPecargo1_parentesco) {
		this.txtPecargo1_parentesco = txtPecargo1_parentesco;
	}

	public Spinner getTxtPecargo1_edad() {
		return txtPecargo1_edad;
	}

	public void setTxtPecargo1_edad(Spinner txtPecargo1_edad) {
		this.txtPecargo1_edad = txtPecargo1_edad;
	}

	public SelectOneMenu getTxtPecargo1_niveleducativo() {
		return txtPecargo1_niveleducativo;
	}

	public void setTxtPecargo1_niveleducativo(SelectOneMenu txtPecargo1_niveleducativo) {
		this.txtPecargo1_niveleducativo = txtPecargo1_niveleducativo;
	}

	public InputTextarea getTxtPecargo2_nombre() {
		return txtPecargo2_nombre;
	}

	public void setTxtPecargo2_nombre(InputTextarea txtPecargo2_nombre) {
		this.txtPecargo2_nombre = txtPecargo2_nombre;
	}

	public SelectOneMenu getTxtPecargo2_parentesco() {
		return txtPecargo2_parentesco;
	}

	public void setTxtPecargo2_parentesco(SelectOneMenu txtPecargo2_parentesco) {
		this.txtPecargo2_parentesco = txtPecargo2_parentesco;
	}

	public Spinner getTxtPecargo2_edad() {
		return txtPecargo2_edad;
	}

	public void setTxtPecargo2_edad(Spinner txtPecargo2_edad) {
		this.txtPecargo2_edad = txtPecargo2_edad;
	}

	public SelectOneMenu getTxtPecargo2_niveleducativo() {
		return txtPecargo2_niveleducativo;
	}

	public void setTxtPecargo2_niveleducativo(SelectOneMenu txtPecargo2_niveleducativo) {
		this.txtPecargo2_niveleducativo = txtPecargo2_niveleducativo;
	}

	public InputTextarea getTxtPecargo3_nombre() {
		return txtPecargo3_nombre;
	}

	public void setTxtPecargo3_nombre(InputTextarea txtPecargo3_nombre) {
		this.txtPecargo3_nombre = txtPecargo3_nombre;
	}

	public SelectOneMenu getTxtPecargo3_parentesco() {
		return txtPecargo3_parentesco;
	}

	public void setTxtPecargo3_parentesco(SelectOneMenu txtPecargo3_parentesco) {
		this.txtPecargo3_parentesco = txtPecargo3_parentesco;
	}

	public Spinner getTxtPecargo3_edad() {
		return txtPecargo3_edad;
	}

	public void setTxtPecargo3_edad(Spinner txtPecargo3_edad) {
		this.txtPecargo3_edad = txtPecargo3_edad;
	}

	public SelectOneMenu getTxtPecargo3_niveleducativo() {
		return txtPecargo3_niveleducativo;
	}

	public void setTxtPecargo3_niveleducativo(SelectOneMenu txtPecargo3_niveleducativo) {
		this.txtPecargo3_niveleducativo = txtPecargo3_niveleducativo;
	}

	public InputTextarea getTxtPecargo4_nombre() {
		return txtPecargo4_nombre;
	}

	public void setTxtPecargo4_nombre(InputTextarea txtPecargo4_nombre) {
		this.txtPecargo4_nombre = txtPecargo4_nombre;
	}

	public SelectOneMenu getTxtPecargo4_parentesco() {
		return txtPecargo4_parentesco;
	}

	public void setTxtPecargo4_parentesco(SelectOneMenu txtPecargo4_parentesco) {
		this.txtPecargo4_parentesco = txtPecargo4_parentesco;
	}

	public Spinner getTxtPecargo4_edad() {
		return txtPecargo4_edad;
	}

	public void setTxtPecargo4_edad(Spinner txtPecargo4_edad) {
		this.txtPecargo4_edad = txtPecargo4_edad;
	}

	public SelectOneMenu getTxtPecargo4_niveleducativo() {
		return txtPecargo4_niveleducativo;
	}

	public void setTxtPecargo4_niveleducativo(SelectOneMenu txtPecargo4_niveleducativo) {
		this.txtPecargo4_niveleducativo = txtPecargo4_niveleducativo;
	}

	public InputTextarea getTxtPecargo5_nombre() {
		return txtPecargo5_nombre;
	}

	public void setTxtPecargo5_nombre(InputTextarea txtPecargo5_nombre) {
		this.txtPecargo5_nombre = txtPecargo5_nombre;
	}

	public SelectOneMenu getTxtPecargo5_parentesco() {
		return txtPecargo5_parentesco;
	}

	public void setTxtPecargo5_parentesco(SelectOneMenu txtPecargo5_parentesco) {
		this.txtPecargo5_parentesco = txtPecargo5_parentesco;
	}

	public Spinner getTxtPecargo5_edad() {
		return txtPecargo5_edad;
	}

	public void setTxtPecargo5_edad(Spinner txtPecargo5_edad) {
		this.txtPecargo5_edad = txtPecargo5_edad;
	}

	public SelectOneMenu getTxtPecargo5_niveleducativo() {
		return txtPecargo5_niveleducativo;
	}

	public void setTxtPecargo5_niveleducativo(SelectOneMenu txtPecargo5_niveleducativo) {
		this.txtPecargo5_niveleducativo = txtPecargo5_niveleducativo;
	}

	public SelectOneMenu getTxtEntBancId_EntBanc() {
		return txtEntBancId_EntBanc;
	}

	public void setTxtEntBancId_EntBanc(SelectOneMenu txtEntBancId_EntBanc) {
		this.txtEntBancId_EntBanc = txtEntBancId_EntBanc;
	}

	public InputNumber getTxtSalario() {
		return txtSalario;
	}

	public void setTxtSalario(InputNumber txtSalario) {
		this.txtSalario = txtSalario;
	}

	public SelectOneMenu getTxtUsuarioAsociado() {
		return txtUsuarioAsociado;
	}

	public void setTxtUsuarioAsociado(SelectOneMenu txtUsuarioAsociado) {
		this.txtUsuarioAsociado = txtUsuarioAsociado;
	}

	public SelectItem[] getSelectUsuarioId() {

		if (selectUsuarioId == null || selectUsuarioId.length == 0) {

			try {
				Object[] condicion = { "enabled", true, "true", "=" };
				List<Usuarios> lista = businessDelegatorView.findByCriteriaInUsuarios(condicion, null, null);
				selectUsuarioId = new SelectItem[lista.size()];

				int i = 0;
				for (Usuarios usuarioId : lista) {
					selectUsuarioId[i] = new SelectItem(usuarioId.getUsuarioId(), usuarioId.getLogin());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUsuarioId;
	}

	public void setSelectUsuarioId(SelectItem[] selectUsuarioId) {
		this.selectUsuarioId = selectUsuarioId;
	}

	public SelectOneMenu getTxtTipoTrabajador() {
		return txtTipoTrabajador;
	}

	public void setTxtTipoTrabajador(SelectOneMenu txtTipoTrabajador) {
		this.txtTipoTrabajador = txtTipoTrabajador;
	}

	public SelectOneMenu getTxtTipoCotizante() {
		return txtTipoCotizante;
	}

	public void setTxtTipoCotizante(SelectOneMenu txtTipoCotizante) {
		this.txtTipoCotizante = txtTipoCotizante;
	}

	public SelectItem[] getSelectTipoCotizante() {

		if (selectTipoCotizante == null || selectTipoCotizante.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoCotizante> lista = businessDelegator2View.findByCriteriaInTipoCotizante(condicion, null, null);
				selectTipoCotizante = new SelectItem[lista.size()];

				int i = 0;
				for (TipoCotizante tc : lista) {
					selectTipoCotizante[i] = new SelectItem(tc.getTipoCotizanteId(), tc.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoCotizante;
	}

	public void setSelectTipoCotizante(SelectItem[] selectTipoCotizante) {
		this.selectTipoCotizante = selectTipoCotizante;
	}

	public SelectOneMenu getTxtEpsActual() {
		return txtEpsActual;
	}

	public void setTxtEpsActual(SelectOneMenu txtEpsActual) {
		this.txtEpsActual = txtEpsActual;
	}

	public SelectItem[] getSelectEpsActual() {

		if (selectEpsActual == null || selectEpsActual.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectEpsActual = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectEpsActual[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEpsActual;
	}

	public void setSelectEpsActual(SelectItem[] selectEpsActual) {
		this.selectEpsActual = selectEpsActual;
	}

	public SelectOneMenu getTxtEpsAnterior() {
		return txtEpsAnterior;
	}

	public void setTxtEpsAnterior(SelectOneMenu txtEpsAnterior) {
		this.txtEpsAnterior = txtEpsAnterior;
	}

	public SelectItem[] getSelectEpsAnterior() {

		if (selectEpsAnterior == null || selectEpsAnterior.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectEpsAnterior = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectEpsAnterior[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEpsAnterior;
	}

	public void setSelectEpsAnterior(SelectItem[] selectEpsAnterior) {
		this.selectEpsAnterior = selectEpsAnterior;
	}

	public SelectOneMenu getTxtSubTipoCotizante() {
		return txtSubTipoCotizante;
	}

	public void setTxtSubTipoCotizante(SelectOneMenu txtSubTipoCotizante) {
		this.txtSubTipoCotizante = txtSubTipoCotizante;
	}

	public SelectItem[] getSelectSubTipoCotizante() {

		if (selectSubTipoCotizante == null || selectSubTipoCotizante.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<SubTipoCotizante> lista = businessDelegator2View.findByCriteriaInSubTipoCotizante(condicion, null, null);
				selectSubTipoCotizante = new SelectItem[lista.size()];

				int i = 0;
				for (SubTipoCotizante tc : lista) {
					selectSubTipoCotizante[i] = new SelectItem(tc.getSubTipoCotizanteId(), tc.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSubTipoCotizante;
	}

	public void setSelectSubTipoCotizante(SelectItem[] selectSubTipoCotizante) {
		this.selectSubTipoCotizante = selectSubTipoCotizante;
	}

	public SelectOneMenu getTxtAfpActual() {
		return txtAfpActual;
	}

	public void setTxtAfpActual(SelectOneMenu txtAfpActual) {
		this.txtAfpActual = txtAfpActual;
	}

	public SelectItem[] getSelectAfpActual() {

		if (selectAfpActual == null || selectAfpActual.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectAfpActual = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectAfpActual[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAfpActual;
	}

	public void setSelectAfpActual(SelectItem[] selectAfpActual) {
		this.selectAfpActual = selectAfpActual;
	}

	public SelectOneMenu getTxtAfpAnterior() {
		return txtAfpAnterior;
	}

	public void setTxtAfpAnterior(SelectOneMenu txtAfpAnterior) {
		this.txtAfpAnterior = txtAfpAnterior;
	}

	public SelectItem[] getSelectAfpAnterior() {

		if (selectAfpAnterior == null || selectAfpAnterior.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectAfpAnterior = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectAfpAnterior[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAfpAnterior;
	}

	public void setSelectAfpAnterior(SelectItem[] selectAfpAnterior) {
		this.selectAfpAnterior = selectAfpAnterior;
	}

	public SelectOneMenu getTxtCajaCompensacion() {
		return txtCajaCompensacion;
	}

	public void setTxtCajaCompensacion(SelectOneMenu txtCajaCompensacion) {
		this.txtCajaCompensacion = txtCajaCompensacion;
	}

	public SelectItem[] getSelectCajaCompensacion() {

		if (selectCajaCompensacion == null || selectCajaCompensacion.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectCajaCompensacion = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectCajaCompensacion[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCajaCompensacion;
	}

	public void setSelectCajaCompensacion(SelectItem[] selectCajaCompensacion) {
		this.selectCajaCompensacion = selectCajaCompensacion;
	}

	public SelectOneMenu getTxtArl() {
		return txtArl;
	}

	public void setTxtArl(SelectOneMenu txtArl) {
		this.txtArl = txtArl;
	}

	public SelectItem[] getSelectArl() {

		if (selectArl == null || selectArl.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectArl = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectArl[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectArl;
	}

	public void setSelectArl(SelectItem[] selectArl) {
		this.selectArl = selectArl;
	}

	public SelectOneMenu getTxtFondoCesantias() {
		return txtFondoCesantias;
	}

	public void setTxtFondoCesantias(SelectOneMenu txtFondoCesantias) {
		this.txtFondoCesantias = txtFondoCesantias;
	}

	public SelectItem[] getSelectFondoCesantias() {

		if (selectFondoCesantias == null || selectFondoCesantias.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "esArlEpsPension", true, "S", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectFondoCesantias = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr persEmpr : lista) {
					selectFondoCesantias[i] = new SelectItem(persEmpr.getPersEmprId(), persEmpr.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectFondoCesantias;
	}

	public void setSelectFondoCesantias(SelectItem[] selectFondoCesantias) {
		this.selectFondoCesantias = selectFondoCesantias;
	}

	public SelectBooleanCheckbox getTxtAportaEps() {
		return txtAportaEps;
	}

	public void setTxtAportaEps(SelectBooleanCheckbox txtAportaEps) {
		this.txtAportaEps = txtAportaEps;
	}

	public SelectBooleanCheckbox getTxtEmpleadorAportaEps() {
		return txtEmpleadorAportaEps;
	}

	public void setTxtEmpleadorAportaEps(SelectBooleanCheckbox txtEmpleadorAportaEps) {
		this.txtEmpleadorAportaEps = txtEmpleadorAportaEps;
	}

	public Calendar getTxtFechaInicioEps() {
		return txtFechaInicioEps;
	}

	public void setTxtFechaInicioEps(Calendar txtFechaInicioEps) {
		this.txtFechaInicioEps = txtFechaInicioEps;
	}

	public SelectBooleanCheckbox getTxtAportaAfp() {
		return txtAportaAfp;
	}

	public void setTxtAportaAfp(SelectBooleanCheckbox txtAportaAfp) {
		this.txtAportaAfp = txtAportaAfp;
	}

	public Calendar getTxtFechaInicioAfp() {
		return txtFechaInicioAfp;
	}

	public void setTxtFechaInicioAfp(Calendar txtFechaInicioAfp) {
		this.txtFechaInicioAfp = txtFechaInicioAfp;
	}

	public SelectBooleanCheckbox getTxtAportaCcf() {
		return txtAportaCcf;
	}

	public void setTxtAportaCcf(SelectBooleanCheckbox txtAportaCcf) {
		this.txtAportaCcf = txtAportaCcf;
	}

	public SelectBooleanCheckbox getTxtAportaArl() {
		return txtAportaArl;
	}

	public void setTxtAportaArl(SelectBooleanCheckbox txtAportaArl) {
		this.txtAportaArl = txtAportaArl;
	}

	public SelectBooleanCheckbox getTxtAportaIcbf() {
		return txtAportaIcbf;
	}

	public void setTxtAportaIcbf(SelectBooleanCheckbox txtAportaIcbf) {
		this.txtAportaIcbf = txtAportaIcbf;
	}

	public SelectBooleanCheckbox getTxtAportaSena() {
		return txtAportaSena;
	}

	public void setTxtAportaSena(SelectBooleanCheckbox txtAportaSena) {
		this.txtAportaSena = txtAportaSena;
	}

	public SelectBooleanCheckbox getTxtAltoRiesgo() {
		return txtAltoRiesgo;
	}

	public void setTxtAltoRiesgo(SelectBooleanCheckbox txtAltoRiesgo) {
		this.txtAltoRiesgo = txtAltoRiesgo;
	}

	public InputNumber getTxtTarifaCajaCompensacion() {
		return txtTarifaCajaCompensacion;
	}

	public void setTxtTarifaCajaCompensacion(InputNumber txtTarifaCajaCompensacion) {
		this.txtTarifaCajaCompensacion = txtTarifaCajaCompensacion;
	}

	public SelectOneMenu getTxtClaseTarifaArl() {
		return txtClaseTarifaArl;
	}

	public void setTxtClaseTarifaArl(SelectOneMenu txtClaseTarifaArl) {
		this.txtClaseTarifaArl = txtClaseTarifaArl;
	}

	public InputNumber getTxtTarifaArl() {
		return txtTarifaArl;
	}

	public void setTxtTarifaArl(InputNumber txtTarifaArl) {
		this.txtTarifaArl = txtTarifaArl;
	}

	public InputNumber getTxtTarifaIcbf() {
		return txtTarifaIcbf;
	}

	public void setTxtTarifaIcbf(InputNumber txtTarifaIcbf) {
		this.txtTarifaIcbf = txtTarifaIcbf;
	}

	public InputNumber getTxtTarifaSena() {
		return txtTarifaSena;
	}

	public void setTxtTarifaSena(InputNumber txtTarifaSena) {
		this.txtTarifaSena = txtTarifaSena;
		
		
		
	}

	public SelectOneMenu getTxtTarifasArlId() {
		return txtTarifasArlId;
	}

	public void setTxtTarifasArlId(SelectOneMenu txtTarifasArlId) {
		this.txtTarifasArlId = txtTarifasArlId;
	}
	
	public SelectItem[] getSelectTarifasArlId() {

		if (selectTarifasArlId == null || selectTarifasArlId.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<TarifasArl> lista = businessDelegator2View.findByCriteriaInTarifasArl(condicion, null, null);
				selectTarifasArlId = new SelectItem[lista.size()];

				int i = 0;
				for (TarifasArl tarifasArl : lista) {
					selectTarifasArlId[i] = new SelectItem(tarifasArl.getTarifasArlId(), tarifasArl.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTarifasArlId;
	}

	public void setSelectTarifasArlId(SelectItem[] selectTarifasArlId) {
		this.selectTarifasArlId = selectTarifasArlId;
	}

	public Calendar getTxtFechaRetiro() {
		return txtFechaRetiro;
	}

	public void setTxtFechaRetiro(Calendar txtFechaRetiro) {
		this.txtFechaRetiro = txtFechaRetiro;
	}
	
	
}