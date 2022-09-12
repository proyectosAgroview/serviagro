package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.DatPlanServiciosMq;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatPlanServiciosMqdetEjec;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.dto.Nivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOtrosMovimientosInventarioDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaLaboresDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgLaboresMecMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresMaqDTO;
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
public class DatPlanServiciosMqView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqView.class);
	private InputText txtNPases;
	private InputText txtAnio;
	private InputText txtCierreOt;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputNumber txtCostoTotalEstimado;
	private InputNumber txtValorUnitario;
	private InputText txtEstado;
	private InputText txtIdMobile;
	private InputText txtInfoAdicional;
	private InputText txtInfoAdicional2;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtNivelAutorizacion1;
	private InputText txtNivelAutorizacion2;
	private InputText txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtPrecision1;
	private InputText txtUsuarioDigitacion;

	private InputText txtDatPlanServiciosMqId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCierreOt;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaReaperturaOt;
	private Calendar txtPeriodoFinal;
	private Calendar txtPeriodoInicial;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatPlanServiciosMqDTO> data;
	private List<ProgramacionLaboresMaqDTO> dataSaldoArea; 
	private DatPlanServiciosMqDTO selectedDatPlanServiciosMq;
	private DatPlanServiciosMq entity;
	private DatPlanServiciosMqdetEjec entityAvance;
	private DatPlanServiciosMqdet entityPlanServiciosMqdet;
	
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtZonaGeograficaId_ZonaGeografica;
	SelectItem[] selectZonaGeografica;
	private List<ZonaGeografica> zonaGeografica;

	private int activeTapIndex = 0;

	private CommandButton btnAgregarMaquinaria;

	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel2ClientesId;
	SelectItem[] selectNivel2ClientesId;
	private List<Nivel2Clientesmq> nivel2ClientesId;

	SelectItem[] selectNivel2ClientesIdEdit;
	private List<Nivel2Clientesmq> nivel2ClientesIdEdit;
	
	private InputText txtNivel4ClientesId;
	private SelectOneMenu txtNivel4ClientesIdEdicion;
	private InputText txtNivel4ClientesIdEdicion2;
	
	SelectItem[] selectNivel4ClientesId;
	private List<Nivel4Clientesmq> nivel4ClientesId;

	SelectItem[] selectNivel4ClientesIdEdit;
	private List<Nivel4ClientesmqDTO> nivel4ClientesIdEdit;
	
	private InputTextarea txtDetalleNota;
	private SelectOneMenu txtConcluido;
	private InputNumber txtCantidad;
	private InputNumber txtCantidadRealizada;
	private InputNumber txtCantidadPendiente;
	
	private SelectOneRadio txtFacturado;

	private List<DatPlanServiciosMqdetDTO> dataPlanServDet;
	private DatPlanServiciosMqdetDTO selectedPlanDatServDet;
	
	
	private List<ProgramacionLaboresMaqDTO>  data2;
	private ProgramacionLaboresMaqDTO selectedDatPlanServiciosMq2;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	
	private SelectOneMenu txtSupervisorConsulta;
	SelectItem[] selectSupervisorConsulta;
	private List<Trabajador> supervisor;
	
	
	private SelectOneMenu txtZonaConsulta;
	SelectItem[] selectZonaConsulta;
	private List<ZonaGeografica> zonaConsulta;
	
	
	private SelectOneMenu txtOperarioAvance;
	SelectItem[] selectOperario;
	private List<Trabajador> operario;
	
	private Spinner txtNumPases;
	
	
	/*** reportando el avance realizado***/
	private Calendar txtFechaAvance;
	
	private SelectOneMenu txtEquipoIdAvance;
	SelectItem[] selectEquipoAvance;
	private List<Equipo> equipoAvance;
	
	private InputNumber txtSaldoArea;
	
	private CommandButton btnGrabarAvance;
	
	private Long txtDatPlanServiciosMqdetId;
	private Long txtDatPlanServiciosMqId2;
	
	private ProgramacionLaboresMaqDTO selectedDatPlanServiciosMqdetEjec;
	
	private SelectOneMenu txtTipoProyecto;
	private InputNumber txtAreaProgramada;
	
	private InputNumber txtCantidadPresupuesto;
	
	private SelectOneMenu txtTipoProyectoFiltro;
	
	/*****************campos detalle***/
	private SelectOneMenu	txtPersEmprConsulta;
	SelectItem[] selectContratistaConsulta;
	private List<PersEmpr> contratistaConsulta;
	
	private SelectOneMenu txtNivel2ClientesConsulta;
	SelectItem[] selectNivel2ClientesConsulta;
	private List<Nivel2Clientesmq> nivel2ClientesConsulta;

	
	private InputText txtTipoProyectoInforme;
	private InputText txtSupervisorInforme;
	private InputText txtZonaInforme;
	private InputText txtDatPlanServiciosMqDetId;
	private List<ProgLaboresMecMaqDTO>  data3;
	private ProgLaboresMecMaqDTO selectedDatPlanServiciosMq3;
	private List<ProgLaboresMecMaqDTO> selectedDatPlanServiciosMq4;
	
	
	private InputText txtConsecutivoConsulta;
	private CommandButton btnSaveDetalle;
	
	private List<String> selectedLabor;
	private List<ListaLaboresDTO> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;
	private String disableButtonA = "false";
	
	
	private SelectOneMenu txtConcluidoConsulta;
	private InputText txtPorcentajeAvance;
	
	public DatPlanServiciosMqView() {
		super();
	}

	public String action_new() throws Exception {
		action_clear();
		selectedDatPlanServiciosMq = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws Exception {
		entity = null;
		selectedDatPlanServiciosMq = null;
		PrimeFaces.current().resetInputs(":frm");
		
		
		if (txtNPases != null) {
			txtNPases.setValue(null);
			txtNPases.setDisabled(false);
		}
		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(false);
		}
		
		if (txtAreaProgramada != null) {
			txtAreaProgramada.setValue(null);
			txtAreaProgramada.setDisabled(false);
		}
		

		if (txtCantidadPresupuesto != null) {
			txtCantidadPresupuesto.setValue(null);
			txtCantidadPresupuesto.setDisabled(true);
		}
		
		if (txtNivel4ClientesIdEdicion != null) {
			txtNivel4ClientesIdEdicion.setValue(null);
			txtNivel4ClientesIdEdicion.setDisabled(true);
		}
		
		if (txtNivel4ClientesIdEdicion2 != null) {
			txtNivel4ClientesIdEdicion2.setValue(null);
			txtNivel4ClientesIdEdicion2.setDisabled(true);
		}
		
		
		if (txtTipoProyecto != null) {
			txtTipoProyecto.setValue(null);
			txtTipoProyecto.setDisabled(false);
		}

		if (dataPlanServDet != null) {
			dataPlanServDet = null;

		}

		if (txtOperarioAvance != null) {
			txtOperarioAvance.setValue(null);
			txtOperarioAvance.setDisabled(false);
		}

		
		if (txtAnio != null) {
			txtAnio.setValue(null);
			txtAnio.setDisabled(false);
		}

		if (txtCierreOt != null) {
			txtCierreOt.setValue(null);
			txtCierreOt.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}
		if (txtConsecutivo != null) {
			Long compania = new Long(getCompaniaIdSession());
			txtConsecutivo.setValue(businessDelegator2View.consec_plan_serv_mq(compania));
			txtConsecutivo.setDisabled(true);
		}
		

		if (txtCostoTotalEstimado != null) {
			txtCostoTotalEstimado.setValue(null);
			txtCostoTotalEstimado.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(false);
		}

		if (txtIdMobile != null) {
			txtIdMobile.setValue(null);
			txtIdMobile.setDisabled(false);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
		}

		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(false);
		}

		if (txtLatitud != null) {
			txtLatitud.setValue(null);
			txtLatitud.setDisabled(false);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue(null);
			txtLongitud.setDisabled(false);
		}

		if (txtNivelAutorizacion1 != null) {
			txtNivelAutorizacion1.setValue(null);
			txtNivelAutorizacion1.setDisabled(false);
		}

		if (txtNivelAutorizacion2 != null) {
			txtNivelAutorizacion2.setValue(null);
			txtNivelAutorizacion2.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtPrecision1 != null) {
			txtPrecision1.setValue(null);
			txtPrecision1.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtZonaGeograficaId_ZonaGeografica != null) {
			txtZonaGeograficaId_ZonaGeografica.setValue(null);
			txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCierreOt != null) {
			txtFechaCierreOt.setValue(null);
			txtFechaCierreOt.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaReaperturaOt != null) {
			txtFechaReaperturaOt.setValue(null);
			txtFechaReaperturaOt.setDisabled(false);
		}

		if (txtPeriodoFinal != null) {
			txtPeriodoFinal.setValue(null);
			txtPeriodoFinal.setDisabled(false);
		}

		if (txtPeriodoInicial != null) {
			//Date date = new Date();
			txtPeriodoInicial.setValue(null);
			txtPeriodoInicial.setDisabled(false);
		}

		if (txtDatPlanServiciosMqId != null) {
			txtDatPlanServiciosMqId.setValue(null);
			txtDatPlanServiciosMqId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnSaveDetalle != null) {
			btnSaveDetalle.setDisabled(false);
		}
		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}
		
		
		
		if (txtNivel4ClientesId != null) {
			txtNivel4ClientesId.setValue(null);
			txtNivel4ClientesId.setDisabled(false);
		}

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(false);
		}
		
		if (txtConcluido != null) {
			txtConcluido.setValue(null);
			txtConcluido.setDisabled(false);
		}
		if (txtDetalleNota != null) {
			txtDetalleNota.setValue(null);
			txtDetalleNota.setDisabled(false);
		}
		if (txtNivel2ClientesId != null) {
			txtNivel2ClientesId.setValue(null);
			txtNivel2ClientesId.setDisabled(false);
		}
		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
		}
		
		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(false);
		}
		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}
		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}
		
		if (txtFacturado != null) {
			txtFacturado.setValue(null);
			txtFacturado.setDisabled(false);
		}
		
		if (txtPersEmprConsulta != null) {
			txtPersEmprConsulta.setValue(null);
			txtPersEmprConsulta.setDisabled(false);
		}
		if (txtNivel2ClientesConsulta != null) {
			txtNivel2ClientesConsulta.setValue(null);
			txtNivel2ClientesConsulta.setDisabled(false);
		}
		if (txtTipoProyectoInforme != null) {
			txtTipoProyectoInforme.setValue(null);
			txtTipoProyectoInforme.setDisabled(false);
		}
		if (txtSupervisorInforme != null) {
			txtSupervisorInforme.setValue(null);
			txtSupervisorInforme.setDisabled(false);
		}
		if (txtZonaInforme != null) {
			txtZonaInforme.setValue(null);
			txtZonaInforme.setDisabled(false);
		}
		if (txtDatPlanServiciosMqDetId != null) {
			txtDatPlanServiciosMqDetId.setValue(null);
			txtDatPlanServiciosMqDetId.setDisabled(false);
		}
		return "";
	}
	
	
	public void listener_txtFechaAnulacion() {
		Date inputDate = (Date) txtFechaAnulacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCierreOt() {
		Date inputDate = (Date) txtFechaCierreOt.getValue();
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

	public void listener_txtFechaReaperturaOt() {
		Date inputDate = (Date) txtFechaReaperturaOt.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtPeriodoFinal() {
		Date inputDate = (Date) txtPeriodoFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtPeriodoInicial() {
		Date inputDate = (Date) txtPeriodoInicial.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public String action_edit(ActionEvent evt) {
        selectedDatPlanServiciosMq2 = (ProgramacionLaboresMaqDTO) (evt.getComponent()
                                                                 .getAttributes().get("selectedDatPlanServiciosMq2"));
           try {

      		Long id = selectedDatPlanServiciosMq2.getDat_plan_servicios_mq_id().longValue();
      		Object[] condicion = { "datPlanServiciosMqId", true, id, "=" };
      		List<DatPlanServiciosMq> lista = (id != null)
      				? businessDelegator2View.findByCriteriaInDatPlanServiciosMq(condicion, null, null) : null;

      		if (lista != null && lista.size() > 0) {
      			entity = lista.get(0);
	                                                        				
	        txtConsecutivo.setValue(entity.getConsecutivo());
	        txtConsecutivo.setDisabled(true);
	        
	        txtTipoProyecto.setValue(entity.getTipoProyecto());
	        txtTipoProyecto.setDisabled(false);
	        
	        txtPeriodoInicial.setValue(entity.getPeriodoInicial());
	        txtPeriodoInicial.setDisabled(false);
	        txtTrabId_Trabajador.setValue(entity.getTrabajador().getTrabId());
	        txtTrabId_Trabajador.setDisabled(false);
	        txtZonaGeograficaId_ZonaGeografica.setValue(entity.getZonaGeografica().getZonaGeograficaId());
	        txtZonaGeograficaId_ZonaGeografica.setDisabled(false);
	       

	        if(entity.getPersEmpr() !=null) {
	        	 txtPersEmprId_PersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
	        }


//	        if(entity.getNivel2Clientesmq() !=null) {
	//        	  txtNivel2ClientesId.setValue(entity.getNivel2Clientesmq().getNivel2ClientesmqId());
	  //      }
	        txtNivel2ClientesId.setDisabled(false);
	        txtPersEmprId_PersEmpr.setDisabled(false);
	       
	        
	        
	        txtDatPlanServiciosMqId.setValue(entity.getDatPlanServiciosMqId());
	        txtDatPlanServiciosMqId.setDisabled(false);
	        
	        
	        
	    	Long datPlanServiciosMqId = FacesUtils.checkLong(txtDatPlanServiciosMqId);
			dataPlanServDet = null;
			dataPlanServDet = businessDelegator2View.getDataDatPlanServiciosMqdetByPlan( datPlanServiciosMqId );
			
			txtNivel4ClientesId.setDisabled(false);
			txtCantidad.setDisabled(false);
			//txtCostoTotalEstimado.setDisabled(false);
			txtCantidadPresupuesto.setDisabled(false);
			
			txtValorUnitario.setValue(0.0);
			txtValorUnitario.setDisabled(false);
		
			
		//	txtConcluido.setDisabled(false);
			txtDetalleNota.setDisabled(false);
	//		txtNivel2ClientesId.setDisabled(false);
//			txtPersEmprId_PersEmpr.setDisabled(false);
			txtUdadMedId_UdadMed.setDisabled(false);
			txtLaborId_Labor.setDisabled(false);
	//		txtEquipoId_Equipo.setDisabled(false);
			btnAgregarMaquinaria.setDisabled(false);
		//	txtFacturado.setDisabled(false);
		//	txtCantidadRealizada.setDisabled(false);
			txtOperarioAvance.setDisabled(false);
	      
			String tipoProyecto ="";
			if(txtTipoProyecto.getValue()!=null) {
				tipoProyecto =txtTipoProyecto.getValue().toString();
				if(tipoProyecto.equals("Topografico")) {
					txtAreaProgramada.setDisabled(false);
				}else {
					txtAreaProgramada.setDisabled(true);
					txtAreaProgramada.setValue(0);		
					}
			}
				
		
			
			txtNumPases.setDisabled(false);
	        btnSave.setDisabled(false);
			setShowDialog(true);

				activeTapIndex = 0;
		
			}
		} catch (Exception e) {
			entity = null;
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

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatPlanServiciosMq.getDatPlanServiciosMqId().longValue());
				entity = businessDelegator2View.getDatPlanServiciosMq(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			Long datServId = FacesUtils.checkLong(txtDatPlanServiciosMqId);
			dataPlanServDet = null;
			// dataPlanServDet =
			// businessDelegatorView.getDataDatServRealizadosEquipoDetByServ(datServId);

			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			// businessDelegatorView.updateDatServRealizadosEquipo(entity, dataPlanServDet,
			// null);
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
		selectedDatPlanServiciosMq = (DatPlanServiciosMqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanServiciosMq"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atras. Por favor, estar seguro."));
		return "";

	}

	public String action_save() {
		try {
			if ((selectedDatPlanServiciosMq == null) && (entity == null)) {
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
			entity = new DatPlanServiciosMq();

			// Long datPlanServiciosMqId = FacesUtils.checkLong(txtDatPlanServiciosMqId);

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setNPases(FacesUtils.checkInteger(txtNPases));
			entity.setAnio(FacesUtils.checkInteger(txtAnio));
			entity.setCierreOt(FacesUtils.checkString(txtCierreOt));

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(txtCostoTotalEstimado));
			entity.setTipoProyecto(FacesUtils.checkString(txtTipoProyecto));

			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(txtFechaCierreOt));
			entity.setFechaCreacion(date);
			entity.setFechaReaperturaOt(FacesUtils.checkDate(txtFechaReaperturaOt));
			entity.setIdMobile(FacesUtils.checkString(txtIdMobile));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkDouble(txtLatitud));
			entity.setLongitud(FacesUtils.checkDouble(txtLongitud));
			entity.setNivelAutorizacion1(FacesUtils.checkString(txtNivelAutorizacion1));
			entity.setNivelAutorizacion2(FacesUtils.checkString(txtNivelAutorizacion2));
			//entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
			entity.setPrecision1(FacesUtils.checkDouble(txtPrecision1));
			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador))
					: null);
			entity.setZonaGeografica((FacesUtils.checkLong(txtZonaGeograficaId_ZonaGeografica) != null)
					? businessDelegatorView.getZonaGeografica(FacesUtils.checkLong(txtZonaGeograficaId_ZonaGeografica))
					: null);
		
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);
			entity.setNivel2Clientesmq((FacesUtils.checkLong(txtNivel2ClientesId) != null)
					? businessDelegator2View.getNivel2Clientesmq(FacesUtils.checkLong(txtNivel2ClientesId))
					: null);
			Date fechaRegistro = FacesUtils.checkDate(txtPeriodoInicial);
			
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 365);  
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());
			
			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());
			

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);  
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());
			
			if(fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {
				
		
			businessDelegator2View.saveDatPlanServiciosMq(entity,dataPlanServDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
			

			}else {
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "",
						""));
						
						entity =null;
			
				}


		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long datPlanServiciosMqId = new Long(selectedDatPlanServiciosMq.getDatPlanServiciosMqId());
				entity = businessDelegator2View.getDatPlanServiciosMq(datPlanServiciosMqId);
			}
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setNPases(FacesUtils.checkInteger(txtNPases));
			entity.setAnio(FacesUtils.checkInteger(txtAnio));
			entity.setCierreOt(FacesUtils.checkString(txtCierreOt));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(txtCostoTotalEstimado));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(txtFechaCierreOt));
			entity.setFechaModificacion(date);
			entity.setFechaReaperturaOt(FacesUtils.checkDate(txtFechaReaperturaOt));
			entity.setIdMobile(FacesUtils.checkString(txtIdMobile));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkDouble(txtLatitud));
			entity.setLongitud(FacesUtils.checkDouble(txtLongitud));
			entity.setNivelAutorizacion1(FacesUtils.checkString(txtNivelAutorizacion1));
			entity.setNivelAutorizacion2(FacesUtils.checkString(txtNivelAutorizacion2));
			//entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setPeriodoFinal(FacesUtils.checkDate(txtPeriodoFinal));
			entity.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
			entity.setPrecision1(FacesUtils.checkDouble(txtPrecision1));
			entity.setTipoProyecto(FacesUtils.checkString(txtTipoProyecto));

			entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador))
					: null);
			entity.setZonaGeografica((FacesUtils.checkLong(txtZonaGeograficaId_ZonaGeografica) != null)
					? businessDelegatorView.getZonaGeografica(FacesUtils.checkLong(txtZonaGeograficaId_ZonaGeografica))
					: null);
			
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);
			entity.setNivel2Clientesmq((FacesUtils.checkLong(txtNivel2ClientesId) != null)
					? businessDelegator2View.getNivel2Clientesmq(FacesUtils.checkLong(txtNivel2ClientesId))
					: null);
			Date fechaRegistro = FacesUtils.checkDate(txtPeriodoInicial);
			
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 365);  
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());
			
			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());
			

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -60);  
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());
			
			if(fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {
				businessDelegator2View.updateDatPlanServiciosMq(entity,dataPlanServDet);
				FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
				action_clear();

			}else {
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Upps!, La fecha del registro esta por fuera del rango permitido " + "",
						""));
				
				}


		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatPlanServiciosMq = (DatPlanServiciosMqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanServiciosMq"));

			Long datPlanServiciosMqId = new Long(selectedDatPlanServiciosMq.getDatPlanServiciosMqId());
			entity = businessDelegator2View.getDatPlanServiciosMq(datPlanServiciosMqId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datPlanServiciosMqId = FacesUtils.checkLong(txtDatPlanServiciosMqId);
			entity = businessDelegator2View.getDatPlanServiciosMq(datPlanServiciosMqId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatPlanServiciosMq(entity);
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
			selectedDatPlanServiciosMq = (DatPlanServiciosMqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanServiciosMq"));

			Long datPlanServiciosMqId = new Long(selectedDatPlanServiciosMq.getDatPlanServiciosMqId());
			entity = businessDelegator2View.getDatPlanServiciosMq(datPlanServiciosMqId);
			businessDelegator2View.deleteDatPlanServiciosMq(entity);
			data.remove(selectedDatPlanServiciosMq);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Integer NPases, Integer anio, String cierreOt, Long compania, Long consecutivo,
			Double costoTotalEstimado, Long datPlanServiciosMqId, String estado, Date fechaAnulacion,
			Date fechaCierreOt, Date fechaCreacion, Date fechaModificacion, Date fechaReaperturaOt, String idMobile,
			String infoAdicional, String infoAdicional2, Double latitud, Double longitud, String nivelAutorizacion1,
			String nivelAutorizacion2, String observacion, String observacionAnularReg, Date periodoFinal,
			Date periodoInicial, Double precision1, Long usuarioDigitacion, Long trabId_Trabajador,
			Long zonaGeograficaId_ZonaGeografica) throws Exception {
		try {
			entity.setNPases(FacesUtils.checkInteger(NPases));
			entity.setAnio(FacesUtils.checkInteger(anio));
			entity.setCierreOt(FacesUtils.checkString(cierreOt));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setCostoTotalEstimado(FacesUtils.checkDouble(costoTotalEstimado));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCierreOt(FacesUtils.checkDate(fechaCierreOt));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaReaperturaOt(FacesUtils.checkDate(fechaReaperturaOt));
			entity.setIdMobile(FacesUtils.checkString(idMobile));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkDouble(latitud));
			entity.setLongitud(FacesUtils.checkDouble(longitud));
			entity.setNivelAutorizacion1(FacesUtils.checkString(nivelAutorizacion1));
			entity.setNivelAutorizacion2(FacesUtils.checkString(nivelAutorizacion2));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPeriodoFinal(FacesUtils.checkDate(periodoFinal));
			entity.setPeriodoInicial(FacesUtils.checkDate(periodoInicial));
			entity.setPrecision1(FacesUtils.checkDouble(precision1));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegator2View.updateDatPlanServiciosMq(entity,dataPlanServDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatPlanServiciosMqView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtNPases() {
		return txtNPases;
	}

	public void setTxtNPases(InputText txtNPases) {
		this.txtNPases = txtNPases;
	}

	public InputText getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(InputText txtAnio) {
		this.txtAnio = txtAnio;
	}

	public InputText getTxtCierreOt() {
		return txtCierreOt;
	}

	public void setTxtCierreOt(InputText txtCierreOt) {
		this.txtCierreOt = txtCierreOt;
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

	public InputNumber getTxtCostoTotalEstimado() {
		return txtCostoTotalEstimado;
	}

	public void setTxtCostoTotalEstimado(InputNumber txtCostoTotalEstimado) {
		this.txtCostoTotalEstimado = txtCostoTotalEstimado;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtIdMobile() {
		return txtIdMobile;
	}

	public void setTxtIdMobile(InputText txtIdMobile) {
		this.txtIdMobile = txtIdMobile;
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

	public InputText getTxtNivelAutorizacion1() {
		return txtNivelAutorizacion1;
	}

	public void setTxtNivelAutorizacion1(InputText txtNivelAutorizacion1) {
		this.txtNivelAutorizacion1 = txtNivelAutorizacion1;
	}

	public InputText getTxtNivelAutorizacion2() {
		return txtNivelAutorizacion2;
	}

	public void setTxtNivelAutorizacion2(InputText txtNivelAutorizacion2) {
		this.txtNivelAutorizacion2 = txtNivelAutorizacion2;
	}

	public InputText getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputText txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputTextarea getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtPrecision1() {
		return txtPrecision1;
	}

	public void setTxtPrecision1(InputText txtPrecision1) {
		this.txtPrecision1 = txtPrecision1;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public SelectOneMenu getTxtZonaGeograficaId_ZonaGeografica() {
		return txtZonaGeograficaId_ZonaGeografica;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public Calendar getTxtFechaAnulacion() {
		return txtFechaAnulacion;
	}

	public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
		this.txtFechaAnulacion = txtFechaAnulacion;
	}

	public Calendar getTxtFechaCierreOt() {
		return txtFechaCierreOt;
	}

	public void setTxtFechaCierreOt(Calendar txtFechaCierreOt) {
		this.txtFechaCierreOt = txtFechaCierreOt;
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

	public Calendar getTxtFechaReaperturaOt() {
		return txtFechaReaperturaOt;
	}

	public void setTxtFechaReaperturaOt(Calendar txtFechaReaperturaOt) {
		this.txtFechaReaperturaOt = txtFechaReaperturaOt;
	}

	public Calendar getTxtPeriodoFinal() {
		return txtPeriodoFinal;
	}

	public void setTxtPeriodoFinal(Calendar txtPeriodoFinal) {
		this.txtPeriodoFinal = txtPeriodoFinal;
	}

	public Calendar getTxtPeriodoInicial() {
		return txtPeriodoInicial;
	}

	public void setTxtPeriodoInicial(Calendar txtPeriodoInicial) {
		this.txtPeriodoInicial = txtPeriodoInicial;
	}

	public InputText getTxtDatPlanServiciosMqId() {
		return txtDatPlanServiciosMqId;
	}

	public void setTxtDatPlanServiciosMqId(InputText txtDatPlanServiciosMqId) {
		this.txtDatPlanServiciosMqId = txtDatPlanServiciosMqId;
	}

	public List<DatPlanServiciosMqDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatPlanServiciosMq();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatPlanServiciosMqDTO> datPlanServiciosMqDTO) {
		this.data = datPlanServiciosMqDTO;
	}

	public DatPlanServiciosMqDTO getSelectedDatPlanServiciosMq() {
		return selectedDatPlanServiciosMq;
	}

	public void setSelectedDatPlanServiciosMq(DatPlanServiciosMqDTO datPlanServiciosMq) {
		this.selectedDatPlanServiciosMq = datPlanServiciosMq;
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

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Motobomba/Electrogeno", "<>", "categoriaEquipo.funcion", true,
						"Implemento", "<>", "categoriaEquipo.funcion", true, "Remolques/Vagones", "<>",
						"categoriaEquipo.funcion", true, "Herramienta", "<>", "categoriaEquipo.funcion", true, "Otros",
						"<>"

				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(),
							equipo.getCodigo() + "-" + equipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipo;
	}

	public void setSelectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}


	public SelectItem[] getSelectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			try {

			
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

	public void setSelectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getSelectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion",
						"<>" };
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

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

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

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public SelectItem[] getSelectZonaGeografica() {

		if (zonaGeografica == null || zonaGeografica.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ZonaGeografica> lista = businessDelegatorView.findByCriteriaInZonaGeografica(condicion, null,
						null);
				selectZonaGeografica = new SelectItem[lista.size()];

				int i = 0;
				for (ZonaGeografica zonaGeografica : lista) {
					selectZonaGeografica[i] = new SelectItem(zonaGeografica.getZonaGeograficaId(),
							zonaGeografica.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectZonaGeografica;
	}

	public void setSelectZonaGeografica(SelectItem[] selectZonaGeografica) {
		this.selectZonaGeografica = selectZonaGeografica;
	}


	public SelectItem[] getSelectContratista() {

		if (contratista == null || contratista.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
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
	
	public SelectItem[] getSelectNivel2ClientesId() {

		if (nivel2ClientesId == null || nivel2ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprId_PersEmpr != null && txtPersEmprId_PersEmpr.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());

					// Criteria
					List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
							.listaNivel2Clientesmq(idCompania, persEmprId);

					selectNivel2ClientesId = new SelectItem[listaNivel2Clientesmq.size()];
					int i = 0;
					for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
						selectNivel2ClientesId[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
								listaNivel2ClientesmqDto.getHacienda());
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2ClientesId;
	}

	public void setSelectNivel2ClientesId(SelectItem[] selectNivel2ClientesId) {
		this.selectNivel2ClientesId = selectNivel2ClientesId;
	}

	

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}

	public SelectOneMenu getTxtNivel2ClientesId() {
		return txtNivel2ClientesId;
	}

	public void setTxtNivel2ClientesId(SelectOneMenu txtNivel2ClientesId) {
		this.txtNivel2ClientesId = txtNivel2ClientesId;
	}

	public InputText getTxtNivel4ClientesId() {
		return txtNivel4ClientesId;
	}

	public void setTxtNivel4ClientesId(InputText txtNivel4ClientesId) {
		this.txtNivel4ClientesId = txtNivel4ClientesId;
	}

	public InputTextarea getTxtDetalleNota() {
		return txtDetalleNota;
	}

	public void setTxtDetalleNota(InputTextarea txtDetalleNota) {
		this.txtDetalleNota = txtDetalleNota;
	}

	public SelectOneMenu getTxtConcluido() {
		return txtConcluido;
	}

	public void setTxtConcluido(SelectOneMenu txtConcluido) {
		this.txtConcluido = txtConcluido;
	}

	public InputNumber getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputNumber txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public void setTxtZonaGeograficaId_ZonaGeografica(SelectOneMenu txtZonaGeograficaId_ZonaGeografica) {
		this.txtZonaGeograficaId_ZonaGeografica = txtZonaGeograficaId_ZonaGeografica;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectItem[] getSelectNivel4ClientesId() throws NumberFormatException, Exception {

		if (txtNivel2ClientesId != null && txtNivel2ClientesId.getValue() != null) {
			Long idCompania = new Long(getCompaniaIdSession());
			String nivel2ClientesId = null;

			nivel2ClientesId = txtNivel2ClientesId.getValue().toString();
			try {
				// Criteria
				List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq = businessDelegator2View
						.listaNivel4Clientesmq(idCompania, nivel2ClientesId);

				selectNivel4ClientesId = new SelectItem[listaNivel4Clientesmq.size()];
				int i = 0;
				for (ListaNivel4ClientesmqDTO listaNivel4ClientesmqDto : listaNivel4Clientesmq) {
					selectNivel4ClientesId[i] = new SelectItem(listaNivel4ClientesmqDto.getId(),
							listaNivel4ClientesmqDto.getLote());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4ClientesId;
	}

	public void setSelectNivel4ClientesId(SelectItem[] selectNivel4ClientesId) {
		this.selectNivel4ClientesId = selectNivel4ClientesId;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public CommandButton getBtnAgregarMaquinaria() {
		return btnAgregarMaquinaria;
	}

	public void setBtnAgregarMaquinaria(CommandButton btnAgregarMaquinaria) {
		this.btnAgregarMaquinaria = btnAgregarMaquinaria;
	}

	public List<DatPlanServiciosMqdetDTO> getDataPlanServDet() {
		return dataPlanServDet;
	}

	public void setDataPlanServDet(List<DatPlanServiciosMqdetDTO> dataPlanServDet) {
		this.dataPlanServDet = dataPlanServDet;
	}

	public DatPlanServiciosMqdetDTO getSelectedPlanDatServDet() {
		return selectedPlanDatServDet;
	}

	public void setSelectedPlanDatServDet(DatPlanServiciosMqdetDTO selectedPlanDatServDet) {
		this.selectedPlanDatServDet = selectedPlanDatServDet;
	}

	public String actionDeleteDatPlanServiciosMqDet(ActionEvent evt) {
		try {

			selectedPlanDatServDet = (DatPlanServiciosMqdetDTO) (evt.getComponent().getAttributes()
					.get("selectedPlanDatServDet"));
			
		
				if (selectedPlanDatServDet.getDatPlanServiciosMqdetId() == null) {
					dataPlanServDet.remove(selectedPlanDatServDet);
				} else {
					Long datServicioId = new Long(selectedPlanDatServDet.getDatPlanServiciosMqdetId());
					
					Object[] condicion = { "datPlanServiciosMqdet.datPlanServiciosMqdetId", true, datServicioId, "=" };
					List<DatPlanServiciosMqdetEjec> listaNotas = (datServicioId != null)
							? businessDelegator2View.findByCriteriaInDatPlanServiciosMqdetEjec(condicion, null, null) : null;
					if (listaNotas != null && listaNotas.size() > 0) {
			        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "",
								"No se puede borrar la planificación, ya que tiene avances realizados!! "));
					}else {
						DatPlanServiciosMqdet entity = businessDelegatorView.getDatPlanServiciosMqdet(datServicioId);
						businessDelegatorView.deleteDatPlanServiciosMqdet(entity);
						dataPlanServDet.remove(selectedPlanDatServDet);
					
						
					}
					
				}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}


	public String actionDeleteMovimiento(ActionEvent evt) {
		 selectedDatPlanServiciosMq2 = (ProgramacionLaboresMaqDTO) (evt.getComponent()
                 .getAttributes().get("selectedDatPlanServiciosMq2"));
			try {
			
			Long id = selectedDatPlanServiciosMq2.getDat_plan_servicios_mq_id().longValue();
			Object[] condicion = { "datPlanServiciosMqId", true, id, "=" };
			List<DatPlanServiciosMq> lista = (id != null)
			? businessDelegator2View.findByCriteriaInDatPlanServiciosMq(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {
						businessDelegator2View.pr_act_prog_dat_serv_realizados_equipo_det(id);
						businessDelegator2View.pr_borrar_dat_plan_servicios_mqdet(id);
					    businessDelegator2View.pr_borrar_dat_plan_servicios_mq(id);
					    
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Proceso exitoso!", "El movimiento de programación de labores fue eliminado exitosamente!!!"));

					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!",
								"Para poder eliminar el movimiento de programación de labores debe tener permisos de administrador "));

					}
				}
				setShowDialog(true);

				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	
	public String actionDeleteDatPlanServiciosMqDetEjec(ActionEvent evt) {
		try {

			selectedDatPlanServiciosMqdetEjec = (ProgramacionLaboresMaqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanServiciosMqdetEjec"));
			
		
				if (selectedDatPlanServiciosMqdetEjec.getDat_plan_servicios_mqdet_ejec() == null) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "",
							"No hay nada para eliminar!! "));
				} else {
					Long idEjec = selectedDatPlanServiciosMqdetEjec.getDat_plan_servicios_mqdet_ejec().longValue();
					if(idEjec.equals(0)) {
						
					}else {
						Long borrar= businessDelegator2View.pr_borrar_dat_plan_servicios_mqdet_ejec(idEjec);
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Registro eliminado exitosamente!! "));
					}

				
				}
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	public List<DatPlanServiciosMqdetDTO> getDatPlanServiciosMqdetDTO() {

		if (dataPlanServDet == null || dataPlanServDet.size() == 0) {
			return null;
		} else {
			return dataPlanServDet;
		}

	}

	public void action_agregarServicio() throws Exception {
		
		String codNivel4Clientes = FacesUtils.checkString(txtNivel4ClientesId);		
		
		if (txtUdadMedId_UdadMed.getValue() != null && txtLaborId_Labor.getValue() != null
				&& txtPeriodoInicial.getValue() != null //&& txtEquipoId_Equipo.getValue() != null
				&& txtCantidad.getValue() != null && txtPersEmprId_PersEmpr.getValue() != null
				&& txtNivel2ClientesId.getValue() != null && codNivel4Clientes !=null && !codNivel4Clientes.equals("")
				) {

			Long compania = new Long(getCompaniaIdSession());
			Long numPases = FacesUtils.checkLong(txtNumPases);
			Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			Labor labor = businessDelegatorView.getLabor(laborId);
			String nombreLabor = labor.getNombre();
			
			String concluido = "NO";
			Date periodoInicial = FacesUtils.checkDate(txtPeriodoInicial);
		//	if (txtConcluido.getValue() != null) {
		//		concluido = txtConcluido.getValue().toString();
		//	}
		//	String facturado = "NO";
		//	if (txtFacturado.getValue() != null) {
		//		facturado = txtFacturado.getValue().toString();
		//	}
			String detalleNota = "";
			if (txtDetalleNota.getValue() != null) {
				detalleNota = txtDetalleNota.getValue().toString();
			}
	/*		Long equipoId = null;
			Equipo equipo = null;
			String codEquipo = "";
			if (txtEquipoId_Equipo.getValue() != null) {
				equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
				equipo = businessDelegatorView.getEquipo(equipoId);
				codEquipo = equipo.getCodigo();
			}

			
			Long operarioId = null;
			Trabajador operario = null;
			String codOperario = "";
			if (txtOperarioAvance.getValue() != null) {
				operarioId = Long.parseLong(txtOperarioAvance.getValue().toString());
				operario = businessDelegatorView.getTrabajador(operarioId);
				codOperario = operario.getNombre();
			}*/
			Long clientesId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());
			PersEmpr persEmpr = businessDelegatorView.getPersEmpr(clientesId);
			String nomCliente = persEmpr.getNombre();

			Long nivel2ClientesId = Long.parseLong(txtNivel2ClientesId.getValue().toString());
			Nivel2Clientesmq nivel2Clientes = businessDelegator2View.getNivel2Clientesmq(nivel2ClientesId);
			String codNivel2Clientes = nivel2Clientes.getNombre();

			Long nivel4ClientesId = null;
			Nivel4Clientesmq nivel4Clientes = null;
			codNivel4Clientes = FacesUtils.checkString(txtNivel4ClientesId);
			
			if ( codNivel4Clientes!=null && !codNivel4Clientes.equals("")	) {
				
				Object[] condicion = { "codigo", true, codNivel4Clientes, "=", "nivel2Clientesmq.nivel2ClientesmqId", true, nivel2ClientesId, "="  };
				List<Nivel4Clientesmq> nivel4ClientesConsulta = businessDelegator2View.findByCriteriaInNivel4Clientesmq(condicion, null, null);	
				
				if (nivel4ClientesConsulta == null || nivel4ClientesConsulta.size()==0 ) {
						nivel4Clientes= new Nivel4Clientesmq();
					Date date = new Date();
					
					nivel4Clientes.setNivel2Clientesmq(nivel2Clientes);
					nivel4Clientes.setCodigo(codNivel4Clientes);
					nivel4Clientes.setNombre(codNivel4Clientes);
					nivel4Clientes.setCompania(compania);
					nivel4Clientes.setEstado("A");
					nivel4Clientes.setAreaNeta(0.0);
					nivel4Clientes.setFechaCreacion(date);
					
					businessDelegator2View.saveNivel4Clientesmq(nivel4Clientes);
		
				} else {
					nivel4Clientes = nivel4ClientesConsulta.get(0);
					codNivel4Clientes = nivel4Clientes.getCodigo();
				}				
			}

			// String codNivel4Clientes = txtNombreNivel4Maq.getValue().toString();
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			String nomUdadPagoMaquinaria = udadMed.getNombre();
			
			Double areaProgramada =0.0;
			areaProgramada = FacesUtils.checkDouble(txtAreaProgramada);	
			
			
			if(udadMed.getClasificacionUm()!=null) {
				if(udadMed.getClasificacionUm().equals("Ha")) {
					 areaProgramada = FacesUtils.checkDouble(txtCantidad);	
				}
			}
				
			
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario); 
			Double costoEstimado=0.0;
			if(cantidad!=null && valorUnitario!=null ) {
				costoEstimado = cantidad*valorUnitario;
			}
			
			
			
			if(numPases!=null) {
				cantidad = cantidad * numPases;
			}else {
				numPases=1L;
			
			}
			
			Double cantidadPresupuesto = FacesUtils.checkDouble(txtCantidadPresupuesto); 
			if(cantidadPresupuesto==null) {
				cantidadPresupuesto = 0.0;
			}
			
		//	Double cantidadRealizada = FacesUtils.checkDouble(txtCantidadRealizada);
			Double cantidadPendiente = 0.0;
		//	if(cantidad !=null && cantidadRealizada !=null ) {
		//		cantidadPendiente = cantidad-cantidadRealizada;
		//	}
			boolean existeProducto = false;

			if (dataPlanServDet == null) {
				dataPlanServDet = new ArrayList<DatPlanServiciosMqdetDTO>();
			}

			

				DatPlanServiciosMqdetDTO datServicioDetDTO2 = new DatPlanServiciosMqdetDTO();

				datServicioDetDTO2.setValorEstUnitario(valorUnitario);
				datServicioDetDTO2.setValorEstTotal(costoEstimado);
				datServicioDetDTO2.setUdadMedId_UdadMed(udadMed);
				datServicioDetDTO2.setNombreUdadMed(nomUdadPagoMaquinaria);

			//	datServicioDetDTO2.setEquipoId_Equipo(equipo);
			//	datServicioDetDTO2.setCodigoEquipo(codEquipo);
				
			//	datServicioDetDTO2.setOperario(operario);
			//	datServicioDetDTO2.setCodOperario(codOperario);
				
				datServicioDetDTO2.setConcluido(concluido);
				datServicioDetDTO2.setDetalleNota(detalleNota);
				
				datServicioDetDTO2.setCantidadPendiente(cantidad);
			//	datServicioDetDTO2.setCantidadRealizada(cantidadRealizada);
			//	datServicioDetDTO2.setFacturado(facturado);
				datServicioDetDTO2.setAreaProgramada(areaProgramada);
				datServicioDetDTO2.setCantidadPlan(cantidad);
				datServicioDetDTO2.setPeriodoInicial(periodoInicial);
				datServicioDetDTO2.setLaborId_Labor(labor);
				datServicioDetDTO2.setNombreLabor(nombreLabor);
				// datServicioDetDTO2.setNombreNivel4(codNivel4Clientes);
				datServicioDetDTO2.setNivel4ClientesmqId(nivel4Clientes);
				datServicioDetDTO2.setCodigoLote(codNivel4Clientes);
				datServicioDetDTO2.setPersEmprId_PersEmpr(persEmpr);
				datServicioDetDTO2.setNombreCliente(nomCliente);
				datServicioDetDTO2.setNivel2ClientesmqId_Nivel2Clientesmq(nivel2Clientes);
				datServicioDetDTO2.setNombreHacienda(codNivel2Clientes);
				datServicioDetDTO2.setNumPases(numPases);
				datServicioDetDTO2.setCantidadPresupuesto(cantidadPresupuesto);
				dataPlanServDet.add(datServicioDetDTO2);
				costoEstimado=null;
				cantidadPresupuesto=null;
			numPases = null;
	//		codOperario = null;
		//	operario =null;
			codNivel4Clientes = null;
			udadMed = null;
			cantidad = null;
			nomUdadPagoMaquinaria = null;
		//	equipo = null;
			concluido = null;
			detalleNota = null;
			nombreLabor = null;
			codNivel4Clientes = null;
			persEmpr = null;
			nomCliente = null;
			nivel2Clientes = null;
			codNivel2Clientes = null;
			limpiar_pantalla();

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  de maquinaria, labor, unidad de médida, hórometro inicial y final, cantidad, "
							+ "cliente, hacienda, trabajador, turno, concepto tengan valores"));
		}

	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		Long datPlanServiciosMq = FacesUtils.checkLong(txtDatPlanServiciosMqId);
		
		if(datPlanServiciosMq !=null) {
			
		
		selectedPlanDatServDet = (DatPlanServiciosMqdetDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanDatServDet"));
		if(selectedPlanDatServDet.getDatPlanServiciosMqdetId()!=null) {
		Long datPlanServiciosMqdetId = selectedPlanDatServDet.getDatPlanServiciosMqdetId().longValue();
		
		String columnaCell = evt.getColumn().getHeaderText();

		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityPlanServiciosMqdet = null;
			entityPlanServiciosMqdet = businessDelegatorView.getDatPlanServiciosMqdet(datPlanServiciosMqdetId);
/*
			if (columnaCell.equals("Maq.")) {

				Long maqId = new Long(evt.getNewValue().toString());
				Equipo e = businessDelegatorView.getEquipo(maqId);

				entityPlanServiciosMqdet.setEquipo(e);

			}


			if (columnaCell.equals("Cliente")) {

				Long clienteId = new Long(evt.getNewValue().toString());
				PersEmpr e = businessDelegatorView.getPersEmpr(clienteId);

				entityPlanServiciosMqdet.setPersEmpr(e);

			}*/
			if (columnaCell.equals("Hda")) {

				Long n2mq = new Long(evt.getNewValue().toString());
				Nivel2Clientesmq e = businessDelegator2View.getNivel2Clientesmq(n2mq);

				entityPlanServiciosMqdet.setNivel2Clientesmq(e);

			}
			
			
		
			if (columnaCell.equals("Ste")) {

				Long ste = new Long(evt.getNewValue().toString());
				Nivel4Clientesmq e = businessDelegator2View.getNivel4Clientesmq(ste);

				entityPlanServiciosMqdet.setNivel4ClientesmqId(e);

			}

			if (columnaCell.equals("Labor")) {

				Long laborId = new Long(evt.getNewValue().toString());
				Labor e = businessDelegatorView.getLabor(laborId);

				entityPlanServiciosMqdet.setLabor(e);

			}
			if (columnaCell.equals("Pases")) {

				
				entityPlanServiciosMqdet.setNumPases(Long.valueOf(evt.getNewValue().toString()));
				

			}
			
			if (columnaCell.equals("U.M")) {

				Long umId = new Long(evt.getNewValue().toString());
				UdadMed e = businessDelegatorView.getUdadMed(umId);

				entityPlanServiciosMqdet.setUdadMed(e);

			}
			
			if (columnaCell.equals("Cant. Presupuesto")) {

				entityPlanServiciosMqdet.setCantidadPresupuesto(Double.valueOf(evt.getNewValue().toString()));
				
			}
			
			
			if (columnaCell.equals("Cant. Realizada")) {

				entityPlanServiciosMqdet.setCantidadRealizada(Double.valueOf(evt.getNewValue().toString()));
				
			}
			
			if (columnaCell.equals("Cant. Plan")) {

				entityPlanServiciosMqdet.setCantidadPlan(Double.valueOf(evt.getNewValue().toString()));
				Double cantidad = Double.valueOf(evt.getNewValue().toString());
				Double tarifa = entityPlanServiciosMqdet.getValorEstUnitario();
				
				Double ingresoTotal = cantidad * tarifa;
				entityPlanServiciosMqdet.setValorEstTotal(ingresoTotal);
				
				
			}
			
			if (columnaCell.equals("Cant. Pendiente")) {

				entityPlanServiciosMqdet.setCantidadPendiente(Double.valueOf(evt.getNewValue().toString()));
			
			}
			if (columnaCell.equals("Área prog.")) {
									
				entityPlanServiciosMqdet.setAreaProgramada(Double.valueOf(evt.getNewValue().toString()));

			}
			if (columnaCell.equals("VR. Unitario")) {
				
				entityPlanServiciosMqdet.setValorEstUnitario(Double.valueOf(evt.getNewValue().toString()));
				
				Double tarifa = Double.valueOf(evt.getNewValue().toString());
				Double cantidad = entityPlanServiciosMqdet.getCantidadPlan();
				
				Double ingresoTotal = cantidad * tarifa;
				entityPlanServiciosMqdet.setValorEstTotal(ingresoTotal);
				

			}
			if (columnaCell.equals("VR. TOTAL")) {
				
				entityPlanServiciosMqdet.setValorEstTotal(Double.valueOf(evt.getNewValue().toString()));
				

			}
		
			if (columnaCell.equals("Finalizado?")) {

				entityPlanServiciosMqdet.setConcluido(evt.getNewValue().toString());

			}
			if (columnaCell.equals("Fecha plan")) {

				entityPlanServiciosMqdet.setPeriodoInicial((Date) newValue);

			}
		
			entity =  businessDelegator2View.getDatPlanServiciosMq(datPlanServiciosMq);
			entityPlanServiciosMqdet.setDatPlanServiciosMq(entity);
			businessDelegatorView.updateDatPlanServiciosMqdet(entityPlanServiciosMqdet);
			
			Long idPrograma = datPlanServiciosMqdetId;
			Object[] condicion = { "dat_plan_servicios_mqdet_id.datPlanServiciosMqdetId", true, idPrograma, "=" };
			List<DatServRealizadosEquipoDet> lista = (idPrograma != null)
			? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicion, null, null) : null;
			if (lista != null && lista.size() > 0) {
				for (int a = 0; a < lista.size(); a++) {
					
					
					Date idFecha =     FacesUtils.checkDate(txtPeriodoInicial);
					Double valorUnitarioTrabajador =0.0;
					
					Long idCompania = new Long(getCompaniaIdSession());
					
					
					if(entityPlanServiciosMqdet.getLabor()!=null && idFecha!=null && 
							entityPlanServiciosMqdet.getNivel2Clientesmq() !=null &&
						entityPlanServiciosMqdet.getNivel4ClientesmqId() !=null &&
						entityPlanServiciosMqdet.getUdadMed() !=null 
							) {
						
						Long idUdadMed = entityPlanServiciosMqdet.getUdadMed().getUdadMedId();
						Long idLabor = entityPlanServiciosMqdet.getLabor().getLaborId();
						
				
						DatServRealizadosEquipoDet entityDet  = lista.get(a);
						Double cantidad = entityDet.getCantidad();
						
						entityDet.setLabor(entityPlanServiciosMqdet.getLabor());
						entityDet.setUdadMed(entityPlanServiciosMqdet.getUdadMed());
						entityDet.setNivel2ClientesId(entityPlanServiciosMqdet.getNivel2Clientesmq());
						entityDet.setNivel4ClientesId(entityPlanServiciosMqdet.getNivel4ClientesmqId());
						
						 valorUnitarioTrabajador = businessDelegatorView.consultarTarifaLaborRendimientoBase
											(idCompania, 0L, idLabor, 0L, idUdadMed, idFecha).doubleValue();
								
						entityDet.setValor_unitario_trabajador(valorUnitarioTrabajador);
						Double valorTotalTrabajador = cantidad*valorUnitarioTrabajador;
						entityDet.setValor_total_trabajador(valorTotalTrabajador);
						
						businessDelegatorView.updateDatServRealizadosEquipoDet(entityDet); 
				}
			}
			
			}
			dataPlanServDet = null;
			selectedPlanDatServDet = null;
			entityPlanServiciosMqdet = null;
			
			
			dataPlanServDet = businessDelegator2View.getDataDatPlanServiciosMqdetByPlan( datPlanServiciosMq );
			
			
			
			}
		}
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Debe primero guardar, para poder modificar la información de la grilla."));
	
		}
	}

	public DatPlanServiciosMqdet getEntityPlanServiciosMqdet() {
		return entityPlanServiciosMqdet;
	}

	public void setEntityPlanServiciosMqdet(DatPlanServiciosMqdet entityPlanServiciosMqdet) {
		this.entityPlanServiciosMqdet = entityPlanServiciosMqdet;
	}

	public SelectItem[] getSelectNivel2ClientesIdEdit() {

		if (nivel2ClientesId == null || nivel2ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprId_PersEmpr != null && txtPersEmprId_PersEmpr.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());

					// Criteria
					List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
							.listaNivel2Clientesmq(idCompania, persEmprId);

					selectNivel2ClientesIdEdit = new SelectItem[listaNivel2Clientesmq.size()];
					int i = 0;
					for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
						selectNivel2ClientesIdEdit[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
								listaNivel2ClientesmqDto.getHacienda());
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2ClientesIdEdit;
	}

	
	public void setSelectNivel2ClientesIdEdit(SelectItem[] selectNivel2ClientesIdEdit) {
		this.selectNivel2ClientesIdEdit = selectNivel2ClientesIdEdit;
	}
	

	public SelectItem[] getSelectNivel4ClientesIdEdit() throws NumberFormatException, Exception {
		Long idCompania = new Long(getCompaniaIdSession());
			try {
				// Criteria
				List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq = businessDelegator2View
						.listaNivel4Clientesmq(idCompania, "0");

				selectNivel4ClientesIdEdit = new SelectItem[listaNivel4Clientesmq.size()];
				int i = 0;
				for (ListaNivel4ClientesmqDTO listaNivel4ClientesmqDto : listaNivel4Clientesmq) {
					selectNivel4ClientesIdEdit[i] = new SelectItem(listaNivel4ClientesmqDto.getId(),
							listaNivel4ClientesmqDto.getLote() +"  Hda: " +listaNivel4ClientesmqDto.getNom_hda() );
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		

		return selectNivel4ClientesIdEdit;
	}

	public void setSelectNivel4ClientesIdEdit(SelectItem[] selectNivel4ClientesIdEdit) {
		this.selectNivel4ClientesIdEdit = selectNivel4ClientesIdEdit;
	}

	public InputNumber getTxtCantidadRealizada() {
		return txtCantidadRealizada;
	}

	public void setTxtCantidadRealizada(InputNumber txtCantidadRealizada) {
		this.txtCantidadRealizada = txtCantidadRealizada;
	}

	public InputNumber getTxtCantidadPendiente() {
		return txtCantidadPendiente;
	}

	public void setTxtCantidadPendiente(InputNumber txtCantidadPendiente) {
		this.txtCantidadPendiente = txtCantidadPendiente;
	}

	public SelectOneRadio getTxtFacturado() {
		return txtFacturado;
	}

	public void setTxtFacturado(SelectOneRadio txtFacturado) {
		this.txtFacturado = txtFacturado;
	}
	
	public void listarProgramacionLabores() {
		try {
			 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			
			Long compania = new Long(getCompaniaIdSession());
			
			String supervisor ="0";
			Long flagSupervisor =1L;
			if(txtSupervisorConsulta.getValue()!=null) {
				supervisor =txtSupervisorConsulta.getValue().toString();
				flagSupervisor =0L;
			}
			
			
			String zona ="0";
			Long flagZona =1L;
			if(txtZonaConsulta.getValue()!=null) {
				zona =txtZonaConsulta.getValue().toString();
				flagZona =0L;
			}
			
			
			String tipoProyecto ="";
			 tipoProyecto = txtTipoProyectoFiltro.getValue().toString();
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_planesmq( compania,  fechaInicial, fechaFinal,supervisor,  flagSupervisor,
						zona,flagZona, tipoProyecto
						);
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public DatPlanServiciosMq getEntity() {
		return entity;
	}

	public void setEntity(DatPlanServiciosMq entity) {
		this.entity = entity;
	}

	public List<ProgramacionLaboresMaqDTO> getData2() {
		return data2;
	}

	public void setData2(List<ProgramacionLaboresMaqDTO> data2) {
		this.data2 = data2;
	}

	public Calendar getTxtFechaIni() {
		return txtFechaIni;
	}

	public void setTxtFechaIni(Calendar txtFechaIni) {
		this.txtFechaIni = txtFechaIni;
	}

	public Calendar getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(Calendar txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}

	public SelectOneMenu getTxtSupervisorConsulta() {
		return txtSupervisorConsulta;
	}

	public void setTxtSupervisorConsulta(SelectOneMenu txtSupervisorConsulta) {
		this.txtSupervisorConsulta = txtSupervisorConsulta;
	}



public SelectOneMenu getTxtOperarioAvance() {
		return txtOperarioAvance;
	}

	public void setTxtOperarioAvance(SelectOneMenu txtOperarioAvance) {
		this.txtOperarioAvance = txtOperarioAvance;
	}

public void limpiar_pantalla() {
		
	txtUdadMedId_UdadMed.setValue(null);
	txtLaborId_Labor.setValue(null) ;
	txtValorUnitario.setValue(null);
	//txtEquipoId_Equipo.setValue(null) ;
	txtCantidad.setValue(null) ;
//	txtPersEmprId_PersEmpr.setValue(null); 
	txtNivel4ClientesId.setValue(null) ;
//	txtNivel2ClientesId.setValue(null) ;
 //   txtOperarioAvance.setValue(null) ;
	txtLaborId_Labor.setValue(null);
	txtDetalleNota.setValue(null);
//	txtCantidadRealizada.setValue(null) ;
//	txtConcluido.setValue(null);
	//txtFacturado.setValue(null);
	
	
	
	}
	



public void listener_ConsultaNombreLaborMaq() {
	Long laborId = null;
	Double valorUnit = 0.0;
	if (txtLaborId_Labor.getValue() != null) {
		laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
		try {
			Labor labor = businessDelegatorView.getLabor(laborId);
			// txtNombreLaborMaq.setValue(labor.getNombre());
			if (labor.getUdadMedByUdadMedPago() != null) {
				txtUdadMedId_UdadMed.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
			}
			
			if(txtPersEmprId_PersEmpr.getValue()!=null) {
				Long clientesId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(clientesId);

				String tablaPrecios = "";
				tablaPrecios = persEmpr.getTablaPrecios();

				if (tablaPrecios.equals("1")) {
					valorUnit = labor.getTarifaEstandar();
				}
				if (tablaPrecios.equals("2")) {
					valorUnit = labor.getTarifaEstandar2();
				}
				if (tablaPrecios.equals("3")) {
					valorUnit = labor.getTarifaEstandar3();
				}
				if (tablaPrecios.equals("4")) {
					valorUnit = labor.getTarifaEstandar4();
				}
				if (tablaPrecios.equals("5")) {
					valorUnit = labor.getTarifaEstandar5();
				}
				if (tablaPrecios.equals("6")) {
					valorUnit = labor.getTarifaEstandar6();
				}
				if (tablaPrecios.equals("7")) {
					valorUnit = labor.getTarifaEstandar7();
				}
				if (tablaPrecios.equals("8")) {
					valorUnit = labor.getTarifaEstandar8();
				}
				if (tablaPrecios.equals("9")) {
					valorUnit = labor.getTarifaEstandar9();
				}
				if (tablaPrecios.equals("10")) {
					valorUnit = labor.getTarifaEstandar10();
				}
				
				txtValorUnitario.setValue(valorUnit);
			}

			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
}

public SelectItem[] getSelectOperario() {

	if (operario == null || operario.size() == 0) {

		try {

		
			Object[] condicion = { "estado", true, "A", "="};
			List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
			selectOperario = new SelectItem[lista.size()];

			int i = 0;
			for (Trabajador trabajador : lista) {
				selectOperario[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectOperario;
}

public void setSelectOperario(SelectItem[] selectOperario) {
	this.selectOperario = selectOperario;
}

public SelectItem[] getSelectSupervisorConsulta() {

	if (supervisor == null || supervisor.size() == 0) {

		try {

		
			Object[] condicion = { "estado", true, "A", "="};
			List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
			selectSupervisorConsulta = new SelectItem[lista.size()];

			int i = 0;
			for (Trabajador trabajador : lista) {
				selectSupervisorConsulta[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectSupervisorConsulta;
}

public void setSelectSupervisorConsulta(SelectItem[] selectSupervisorConsulta) {
	this.selectSupervisorConsulta = selectSupervisorConsulta;
}

public Spinner getTxtNumPases() {
	return txtNumPases;
}

public void setTxtNumPases(Spinner txtNumPases) {
	this.txtNumPases = txtNumPases;
}

/****** REGISTRO AVANCE***/



public SelectItem[] getSelectEquipoAvance() {

	if (equipoAvance == null || equipoAvance.size() == 0) {

		try {

			Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
					"categoriaEquipo.funcion", true, "Motobomba/Electrogeno", "<>", "categoriaEquipo.funcion", true,
					"Implemento", "<>", "categoriaEquipo.funcion", true, "Remolques/Vagones", "<>",
					"categoriaEquipo.funcion", true, "Herramienta", "<>", "categoriaEquipo.funcion", true, "Otros",
					"<>"

			};
			List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
			selectEquipoAvance = new SelectItem[lista.size()];

			int i = 0;
			for (Equipo equipo : lista) {
				selectEquipoAvance[i] = new SelectItem(equipo.getEquipoId(),
						equipo.getCodigo() + "-" + equipo.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectEquipoAvance;
}

public Calendar getTxtFechaAvance() {
	return txtFechaAvance;
}

public void setTxtFechaAvance(Calendar txtFechaAvance) {
	this.txtFechaAvance = txtFechaAvance;
}

public SelectOneMenu getTxtEquipoIdAvance() {
	return txtEquipoIdAvance;
}

public void setTxtEquipoIdAvance(SelectOneMenu txtEquipoIdAvance) {
	this.txtEquipoIdAvance = txtEquipoIdAvance;
}

public void setSelectEquipoAvance(SelectItem[] selectEquipoAvance) {
	this.selectEquipoAvance = selectEquipoAvance;
}

public String  action_RegistrarAvance(ActionEvent evt) {
	try {

		PrimeFaces.current().resetInputs(":frm");
		
		Long datPlanServiciosMq = FacesUtils.checkLong(txtDatPlanServiciosMqId);
		
		if(datPlanServiciosMq !=null) {
			
		selectedPlanDatServDet = (DatPlanServiciosMqdetDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanDatServDet"));

		if(selectedPlanDatServDet.getDatPlanServiciosMqdetId()!=null) {
			
					Date data = new Date();
					txtFechaAvance.setValue(data);
					txtFechaAvance.setDisabled(false);
					
					
					txtEquipoIdAvance.setDisabled(false);
					txtCantidadRealizada.setDisabled(false);
					txtOperarioAvance.setDisabled(false);
					
				txtDatPlanServiciosMqdetId= selectedPlanDatServDet.getDatPlanServiciosMqdetId();
				txtDatPlanServiciosMqId2 = selectedPlanDatServDet.getDatPlanServiciosMqId_DatPlanServiciosMq().longValue();
			}
		
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Primero debe guardar el plan, para posteriormente registrar su ejecucuión."));
			txtFechaAvance.setDisabled(true);
			txtEquipoIdAvance.setDisabled(true);
			txtCantidadRealizada.setDisabled(true);
			txtOperarioAvance.setDisabled(true);
			
	
		}

		setShowDialog(true);
	} catch (Exception e) {
		FacesUtils.addErrorMessage(e.getMessage());
	}

	return "";
}



public DatPlanServiciosMqdetEjec getEntityAvance() {
	return entityAvance;
}

public void setEntityAvance(DatPlanServiciosMqdetEjec entityAvance) {
	this.entityAvance = entityAvance;
}

/*
 * if(areaAcumulada<=cantidadPlaneada) {
					businessDelegatorView.saveDatPlanServiciosMqdetEjec(entityAvance);
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
				    limpiar_avance();
				}
			else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!",
						"La cantidad ejecutada supera la cantidad planeada."));

			}
 */

public void limpiar_avance() {
	txtOperarioAvance.setValue(null);
	txtCantidadRealizada.setValue(null);
	txtFechaAvance.setValue(null) ;
	txtEquipoIdAvance.setValue(null) ;

	}



public InputNumber getTxtSaldoArea() {
	return txtSaldoArea;
}

public void setTxtSaldoArea(InputNumber txtSaldoArea) {
	this.txtSaldoArea = txtSaldoArea;
}

public String  action_ConsultarAvance(ActionEvent evt) {
	try {
		Long datPlanServiciosMq = FacesUtils.checkLong(txtDatPlanServiciosMqId);
		
		if(datPlanServiciosMq !=null) 	{
			
		selectedPlanDatServDet = (DatPlanServiciosMqdetDTO) (evt.getComponent().getAttributes()
				.get("selectedPlanDatServDet"));

		if(selectedPlanDatServDet.getDatPlanServiciosMqdetId()!=null) 	{
			Long datPlanServiciosMqdetId = selectedPlanDatServDet.getDatPlanServiciosMqdetId().longValue();
		
				
					String cadena = "";
								
					double valorTotal = 0;
				    double horas = 0;
				    double cantidad = 0;
				       
					if(datPlanServiciosMqdetId != null  ){
					dataSaldoArea = businessDelegator2View.pr_consulta_estatus_plan_maquinas(datPlanServiciosMqdetId);			
				       if(dataSaldoArea !=null){
				        for( ProgramacionLaboresMaqDTO data1 : dataSaldoArea) { 
				        	valorTotal += data1.getCantidad_plan().doubleValue();
				        }
				 
					}
					
					txtSaldoArea.setValue(valorTotal);
					}
	
				}
		
	  }else {
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Debe primero guardar, para poder consultar las unidades pendientes de la labor planificacda"));
	  }
	} catch (Exception e) {
		e.printStackTrace();
	}

	return "";
}



public String  action_ConsultarAvance2(ActionEvent evt) {
	try {
	
			
			selectedDatPlanServiciosMq3 = (ProgLaboresMecMaqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanServiciosMq3"));

		if(selectedDatPlanServiciosMq3.getId_programa()!=null) 	{
			Long datPlanServiciosMqdetId = selectedDatPlanServiciosMq3.getId_programa().longValue();
		
				
					String cadena = "";
								
					double valorTotal = 0;
				    double horas = 0;
				    double cantidad = 0;
				       
					if(datPlanServiciosMqdetId != null  ){
					dataSaldoArea = businessDelegator2View.pr_consulta_estatus_plan_maquinas(datPlanServiciosMqdetId);			
				       if(dataSaldoArea !=null){
				        for( ProgramacionLaboresMaqDTO data1 : dataSaldoArea) { 
				        	valorTotal += data1.getCantidad_plan().doubleValue();
				        }
				 
					}
					
					txtSaldoArea.setValue(valorTotal);
					}
	
				}
		setShowDialog(true);
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	return "";
}

public List<ProgramacionLaboresMaqDTO> getDataSaldoArea() {
	return dataSaldoArea;
}

public void setDataSaldoArea(List<ProgramacionLaboresMaqDTO> dataSaldoArea) {
	this.dataSaldoArea = dataSaldoArea;
}

public CommandButton getBtnGrabarAvance() {
	return btnGrabarAvance;
}

public void setBtnGrabarAvance(CommandButton btnGrabarAvance) {
	this.btnGrabarAvance = btnGrabarAvance;
}


public String  action_GrabarAvance() {
	try {
		
			Long datPlanServiciosMqdetId = txtDatPlanServiciosMqdetId ;
			Long datPlanServiciosMq = txtDatPlanServiciosMqId2 ;
		
			entityAvance = new DatPlanServiciosMqdetEjec();

			// Long datPlanServiciosMqId = FacesUtils.checkLong(txtDatPlanServiciosMqId);

			entityAvance.setCantidadRealizada(FacesUtils.checkDouble(txtCantidadRealizada)) ;
			entityAvance.setFechaRegistro(FacesUtils.checkDate(txtFechaAvance)) ;
			entityAvance.setEquipo((FacesUtils.checkLong(txtEquipoIdAvance) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoIdAvance))
					: null);
			
			entityAvance.setOperario((FacesUtils.checkLong(txtOperarioAvance) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtOperarioAvance))
					: null);
			
			entityAvance.setDatPlanServiciosMqdet((datPlanServiciosMqdetId != null)
					? businessDelegatorView.getDatPlanServiciosMqdet(datPlanServiciosMqdetId)
					: null);
			
			Double areaAnteriorReportada = businessDelegator2View.pr_consulta_estatus_area_plan_maquinas(datPlanServiciosMqdetId);
			Double areaReportada = FacesUtils.checkDouble(txtCantidadRealizada);
			Double  areaAcumulada=  areaAnteriorReportada + areaReportada;
			Double cantidadPlaneada = selectedPlanDatServDet.getCantidadPlan();
			Double cantidadPendiente = cantidadPlaneada - areaAcumulada;
			
			businessDelegator2View.saveDatPlanServiciosMqdetEjec(entityAvance);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			
			entityPlanServiciosMqdet = null;
			entityPlanServiciosMqdet = businessDelegatorView.getDatPlanServiciosMqdet(datPlanServiciosMqdetId);
			entityPlanServiciosMqdet.setCantidadRealizada(areaAcumulada);
			entityPlanServiciosMqdet.setCantidadPendiente(cantidadPendiente);
			if(cantidadPlaneada <=areaAcumulada) {
				entityPlanServiciosMqdet.setConcluido("SI");
				
			}
			
			businessDelegatorView.updateDatPlanServiciosMqdet(entityPlanServiciosMqdet);
			
		//	dataPlanServDet = null;
		//	selectedPlanDatServDet = null;
			entityPlanServiciosMqdet = null;
			dataPlanServDet = businessDelegator2View.getDataDatPlanServiciosMqdetByPlan( datPlanServiciosMq );
			
			limpiar_avance();
			
			
		
		
	} catch (Exception e) {
		FacesUtils.addErrorMessage(e.getMessage());
	}

	return "";
}

public Long getTxtDatPlanServiciosMqdetId() {
	return txtDatPlanServiciosMqdetId;
}

public void setTxtDatPlanServiciosMqdetId(Long txtDatPlanServiciosMqdetId) {
	this.txtDatPlanServiciosMqdetId = txtDatPlanServiciosMqdetId;
}


public SelectItem[] getSelectZonaConsulta() {

	if (zonaConsulta == null || zonaConsulta.size() == 0) {

		try {
			Object[] condicion = { "estado", true, "A", "=" };
			List<ZonaGeografica> lista = businessDelegatorView.findByCriteriaInZonaGeografica(condicion, null,
					null);
			selectZonaConsulta = new SelectItem[lista.size()];

			int i = 0;
			for (ZonaGeografica zonaConsulta : lista) {
				selectZonaConsulta[i] = new SelectItem(zonaConsulta.getZonaGeograficaId(),
						zonaConsulta.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectZonaConsulta;
}

public void setSelectZonaConsulta(SelectItem[] selectZonaConsulta) {
	this.selectZonaConsulta = selectZonaConsulta;
}

public SelectOneMenu getTxtZonaConsulta() {
	return txtZonaConsulta;
}

public void setTxtZonaConsulta(SelectOneMenu txtZonaConsulta) {
	this.txtZonaConsulta = txtZonaConsulta;
}

public ProgramacionLaboresMaqDTO getSelectedDatPlanServiciosMqdetEjec() {
	return selectedDatPlanServiciosMqdetEjec;
}

public void setSelectedDatPlanServiciosMqdetEjec(ProgramacionLaboresMaqDTO selectedDatPlanServiciosMqdetEjec) {
	this.selectedDatPlanServiciosMqdetEjec = selectedDatPlanServiciosMqdetEjec;
}

public InputNumber getTxtAreaProgramada() {
	return txtAreaProgramada;
}

public void setTxtAreaProgramada(InputNumber txtAreaProgramada) {
	this.txtAreaProgramada = txtAreaProgramada;
}

public SelectOneMenu getTxtTipoProyecto() {
	return txtTipoProyecto;
}

public void setTxtTipoProyecto(SelectOneMenu txtTipoProyecto) {
	this.txtTipoProyecto = txtTipoProyecto;
}

public SelectOneMenu getTxtTipoProyectoFiltro() {
	return txtTipoProyectoFiltro;
}

public void setTxtTipoProyectoFiltro(SelectOneMenu txtTipoProyectoFiltro) {
	this.txtTipoProyectoFiltro = txtTipoProyectoFiltro;
}


public void consultaTipoProyecto() {

	String tipoProyecto ="";
		if(txtTipoProyecto.getValue()!=null) {
			tipoProyecto =txtTipoProyecto.getValue().toString();
			if(tipoProyecto.equals("NIVELACION")) {
				txtCantidadPresupuesto.setDisabled(false);
			
			}else {
				txtCantidadPresupuesto.setDisabled(true);
				txtCantidadPresupuesto.setValue(0);			}
		}	
			
		
	
}

public IBusinessDelegator2View getBusinessDelegator2View() {
	return businessDelegator2View;
}

public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
	this.businessDelegator2View = businessDelegator2View;
}

public Long getTxtDatPlanServiciosMqId2() {
	return txtDatPlanServiciosMqId2;
}

public void setTxtDatPlanServiciosMqId2(Long txtDatPlanServiciosMqId2) {
	this.txtDatPlanServiciosMqId2 = txtDatPlanServiciosMqId2;
}

public InputNumber getTxtCantidadPresupuesto() {
	return txtCantidadPresupuesto;
}

public void setTxtCantidadPresupuesto(InputNumber txtCantidadPresupuesto) {
	this.txtCantidadPresupuesto = txtCantidadPresupuesto;
}

public InputNumber getTxtValorUnitario() {
	return txtValorUnitario;
}

public void setTxtValorUnitario(InputNumber txtValorUnitario) {
	this.txtValorUnitario = txtValorUnitario;
}

public SelectOneMenu getTxtPersEmprConsulta() {
	return txtPersEmprConsulta;
}

public void setTxtPersEmprConsulta(SelectOneMenu txtPersEmprConsulta) {
	this.txtPersEmprConsulta = txtPersEmprConsulta;
}

public SelectOneMenu getTxtNivel2ClientesConsulta() {
	return txtNivel2ClientesConsulta;
}

public void setTxtNivel2ClientesConsulta(SelectOneMenu txtNivel2ClientesConsulta) {
	this.txtNivel2ClientesConsulta = txtNivel2ClientesConsulta;
}

public InputText getTxtTipoProyectoInforme() {
	return txtTipoProyectoInforme;
}

public void setTxtTipoProyectoInforme(InputText txtTipoProyectoInforme) {
	this.txtTipoProyectoInforme = txtTipoProyectoInforme;
}

public InputText getTxtSupervisorInforme() {
	return txtSupervisorInforme;
}

public void setTxtSupervisorInforme(InputText txtSupervisorInforme) {
	this.txtSupervisorInforme = txtSupervisorInforme;
}

public InputText getTxtZonaInforme() {
	return txtZonaInforme;
}

public void setTxtZonaInforme(InputText txtZonaInforme) {
	this.txtZonaInforme = txtZonaInforme;
}

public InputText getTxtDatPlanServiciosMqDetId() {
	return txtDatPlanServiciosMqDetId;
}

public void setTxtDatPlanServiciosMqDetId(InputText txtDatPlanServiciosMqDetId) {
	this.txtDatPlanServiciosMqDetId = txtDatPlanServiciosMqDetId;
}

/********************************** Detalle *****************/

public void listarProgramacionLaboresDetalle() {
	try {
		 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaIni));
		fechaFinal = (FacesUtils.checkDate(txtFechaFin));
		
		Long compania = new Long(getCompaniaIdSession());
		Long flagLabor = 1L;
		Long flagGrupoLabor = 1L;
	
		String supervisor ="0";
		Long flagSupervisor =1L;
		if(txtSupervisorConsulta.getValue()!=null) {
			supervisor =txtSupervisorConsulta.getValue().toString();
			flagSupervisor =0L;
		}
		
		
		String zona ="0";
		Long flagZona =1L;
		if(txtZonaConsulta.getValue()!=null) {
			zona =txtZonaConsulta.getValue().toString();
			flagZona =0L;
		}
		
		

		String cliente ="0";
		Long flagCliente =1L;
		if(txtPersEmprConsulta.getValue()!=null) {
			cliente =txtPersEmprConsulta.getValue().toString();
			flagCliente =0L;
		}
		
		

		String nivel2Mq ="0";
		Long flagNivel2Mq =1L;
		if(txtNivel2ClientesConsulta.getValue()!=null) {
			nivel2Mq =txtNivel2ClientesConsulta.getValue().toString();
			flagNivel2Mq =0L;
		}
		
		Long consecutivo = FacesUtils.checkLong(txtConsecutivoConsulta);
		if(consecutivo ==null) {
			consecutivo =0L;
		}
		
		String laboresSeleccionadas = "";
		if (selectedLabor != null && selectedLabor.size() > 0) {
			laboresSeleccionadas = selectedLabor.get(0);
			flagLabor = 0L;
			for (int i = 1; i < selectedLabor.size(); i++) {
				laboresSeleccionadas += "," + selectedLabor.get(i);
			}
		}
		

		String grupoLaboresSeleccionadas = "";
		if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
			grupoLaboresSeleccionadas = selectedGrupoLabor.get(0);
			flagGrupoLabor = 0L;
			for (int i = 1; i < selectedGrupoLabor.size(); i++) {
				grupoLaboresSeleccionadas += "," + selectedGrupoLabor.get(i);
			}
		}

	
		if (fechaInicial != null && fechaFinal != null) {
			data3 = businessDelegator2View.pr_lista_prog_maquinaria( compania,  fechaInicial, fechaFinal,supervisor,  flagSupervisor,
					zona,flagZona, cliente,flagCliente,nivel2Mq,flagNivel2Mq,consecutivo,laboresSeleccionadas,flagLabor, grupoLaboresSeleccionadas,flagGrupoLabor,
					"0",0.0
					);
		} else {
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	
}
public String action_editDetalle(ActionEvent evt) {
    selectedDatPlanServiciosMq3 = (ProgLaboresMecMaqDTO) (evt.getComponent()
                                                             .getAttributes().get("selectedDatPlanServiciosMq3"));
       try {

  		Long id = selectedDatPlanServiciosMq3.getId_programa().longValue();
  		Object[] condicion = { "datPlanServiciosMqdetId", true, id, "=" };
  		List<DatPlanServiciosMqdet> lista = (id != null)
  				? businessDelegator2View.findByCriteriaInDatPlanServiciosMqdet(condicion, null, null) : null;

  		if (lista != null && lista.size() > 0) {
  		
  		
  			
  		entityPlanServiciosMqdet = lista.get(0);
                                                        				
        txtConsecutivo.setValue(selectedDatPlanServiciosMq3.getConsecutivo().longValue());
        txtConsecutivo.setDisabled(true);
        
        
        txtPeriodoInicial.setValue(selectedDatPlanServiciosMq3.getPeriodo_inicial());
        txtPeriodoInicial.setDisabled(false);
        
        txtSupervisorInforme.setValue(selectedDatPlanServiciosMq3.getNom_supervisor());
        txtSupervisorInforme.setDisabled(false);
        
        txtZonaInforme.setValue(selectedDatPlanServiciosMq3.getNom_zona());
        txtZonaInforme.setDisabled(false);
        
        txtDatPlanServiciosMqDetId.setValue(entityPlanServiciosMqdet.getDatPlanServiciosMqdetId());
        txtDatPlanServiciosMqDetId.setDisabled(false);

        if(entityPlanServiciosMqdet.getPersEmpr() !=null) {
        	 txtPersEmprId_PersEmpr.setValue(entityPlanServiciosMqdet.getPersEmpr().getPersEmprId());
        }
        txtPersEmprId_PersEmpr.setDisabled(false);
        
        txtDatPlanServiciosMqId.setValue(selectedDatPlanServiciosMq3.getDat_plan_servicios_mq_id());
        txtDatPlanServiciosMqId.setDisabled(false);
        
        if(entityPlanServiciosMqdet.getNivel2Clientesmq()!=null) {
        txtNivel2ClientesId.setValue(entityPlanServiciosMqdet.getNivel2Clientesmq().getNivel2ClientesmqId());
        }
        txtNivel2ClientesId.setDisabled(false);
        
        
    //    if(entityPlanServiciosMqdet.getNivel4ClientesmqId()!=null) {
     //   	txtNivel4ClientesIdEdicion.setValue(entityPlanServiciosMqdet.getNivel4ClientesmqId().getNivel4ClientesmqId());
    //   }
    //    txtNivel4ClientesIdEdicion.setDisabled(false);
        
        if(entityPlanServiciosMqdet.getNivel4ClientesmqId()!=null) {
        	txtNivel4ClientesIdEdicion2.setValue(selectedDatPlanServiciosMq3.getCod_lote());
        }
        txtNivel4ClientesIdEdicion2.setDisabled(false);
		
        txtCantidad.setValue(entityPlanServiciosMqdet.getCantidadPlan());
		txtCantidad.setDisabled(false);
		//txtCostoTotalEstimado.setDisabled(false);
		txtCantidadPresupuesto.setValue(entityPlanServiciosMqdet.getCantidadPresupuesto());
		txtCantidadPresupuesto.setDisabled(false);
		
		txtCantidadPendiente.setValue(entityPlanServiciosMqdet.getCantidadPendiente());
		txtCantidadPendiente.setDisabled(false);
		
		txtCantidadRealizada.setValue(entityPlanServiciosMqdet.getCantidadRealizada());
		txtCantidadRealizada.setDisabled(false);
		
		
		
		txtValorUnitario.setValue(entityPlanServiciosMqdet.getValorEstUnitario());
		txtValorUnitario.setDisabled(false);
		
		txtCostoTotalEstimado.setValue(entityPlanServiciosMqdet.getValorEstTotal());
		txtCostoTotalEstimado.setDisabled(false);
		
		txtAreaProgramada.setValue(entityPlanServiciosMqdet.getAreaProgramada());
		txtAreaProgramada.setDisabled(false);
		
		
		txtDetalleNota.setValue(entityPlanServiciosMqdet.getDetalleNota());
		txtDetalleNota.setDisabled(false);
		
		 if(entityPlanServiciosMqdet.getUdadMed()!=null) {
			 txtUdadMedId_UdadMed.setValue(entityPlanServiciosMqdet.getUdadMed().getUdadMedId());
	        }
		txtUdadMedId_UdadMed.setDisabled(false);
		
		 if(entityPlanServiciosMqdet.getLabor()!=null) {
			 txtLaborId_Labor.setValue(entityPlanServiciosMqdet.getLabor().getLaborId());
	        }
		txtLaborId_Labor.setDisabled(false);
		
		 if(entityPlanServiciosMqdet.getConcluido()!=null) {
			 txtConcluido.setValue(entityPlanServiciosMqdet.getConcluido());
	        }
		 txtConcluido.setDisabled(false);
		
		txtNumPases.setValue(entityPlanServiciosMqdet.getNumPases());
		txtNumPases.setDisabled(false);

		btnSaveDetalle.setDisabled(false);
		
		setShowDialog(true);

			
		}
	} catch (Exception e) {
		entityPlanServiciosMqdet = null;
	}
	return "";
	}

public List<ProgLaboresMecMaqDTO> getData3() {
	return data3;
}

public void setData3(List<ProgLaboresMecMaqDTO> data3) {
	this.data3 = data3;
}

public InputText getTxtConsecutivoConsulta() {
	return txtConsecutivoConsulta;
}

public void setTxtConsecutivoConsulta(InputText txtConsecutivoConsulta) {
	this.txtConsecutivoConsulta = txtConsecutivoConsulta;
}





public String actionDeleteMovimiento2(ActionEvent evt) {
	 selectedDatPlanServiciosMq3 = (ProgLaboresMecMaqDTO) (evt.getComponent()
             .getAttributes().get("selectedDatPlanServiciosMq3"));
		try {
		
		Long idPrograma = selectedDatPlanServiciosMq3.getId_programa().longValue();
		Object[] condicion = { "datPlanServiciosMqdetId", true, idPrograma, "=" };
		List<DatPlanServiciosMqdet> lista = (idPrograma != null)
		? businessDelegator2View.findByCriteriaInDatPlanServiciosMqdet(condicion, null, null) : null;

		if (lista != null && lista.size() > 0) {
			entityPlanServiciosMqdet = lista.get(0);

			Long usuarioId = new Long(getUsuarioIdSession());
			Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

			if (usuario.getNivelAcceso() != null) {
				if (usuario.getNivelAcceso().equals("TOTAL")) {
					
				DatPlanServiciosMqdet entity = businessDelegatorView.getDatPlanServiciosMqdet(idPrograma);
				
				Object[] condicionDatServicioDet = { "dat_plan_servicios_mqdet_id.datPlanServiciosMqdetId", true, idPrograma, "=" };
				List<DatServRealizadosEquipoDet> listaServicioDet = (idPrograma != null)
				? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicionDatServicioDet, null, null) : null;
				if (listaServicioDet != null && listaServicioDet.size() > 0) {
					for (int a = 0; a < listaServicioDet.size(); a++) {
						DatServRealizadosEquipoDet entityDet  = listaServicioDet.get(a);
						entityDet.setDat_plan_servicios_mqdet_id(null);		
						businessDelegatorView.updateDatServRealizadosEquipoDet(entityDet); 
					}
				}
				
				businessDelegator2View.deleteDatPlanServiciosMqdet(entity);
				
				
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Proceso exitoso!", "El movimiento de programación de labores fue eliminado exitosamente!!!"));
					
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!",
							"Para poder eliminar el movimiento de programación de labores debe tener permisos de administrador "));

				}
			}
			setShowDialog(true);

			activeTapIndex = 0;

		}
	} catch (Exception e) {
		entity = null;
	}

	return "";
}

public ProgramacionLaboresMaqDTO getSelectedDatPlanServiciosMq2() {
	return selectedDatPlanServiciosMq2;
}

public void setSelectedDatPlanServiciosMq2(ProgramacionLaboresMaqDTO selectedDatPlanServiciosMq2) {
	this.selectedDatPlanServiciosMq2 = selectedDatPlanServiciosMq2;
}

public ProgLaboresMecMaqDTO getSelectedDatPlanServiciosMq3() {
	return selectedDatPlanServiciosMq3;
}

public void setSelectedDatPlanServiciosMq3(ProgLaboresMecMaqDTO selectedDatPlanServiciosMq3) {
	this.selectedDatPlanServiciosMq3 = selectedDatPlanServiciosMq3;
}

public CommandButton getBtnSaveDetalle() {
	return btnSaveDetalle;
}

public void setBtnSaveDetalle(CommandButton btnSaveDetalle) {
	this.btnSaveDetalle = btnSaveDetalle;
}



public SelectItem[] getSelectContratistaConsulta() {

	if (contratistaConsulta == null || contratistaConsulta.size() == 0) {

		try {

			Object[] condicion = { "estado", true, "A", "=", 
					"tipoEmpresa", true, "2", "<>" 
					, "tipoEmpresa", true, "3", "<>"
					, "tipoEmpresa", true, "5", "<>"
					, "tipoEmpresa", true, "6", "<>" };
			List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			selectContratistaConsulta = new SelectItem[lista.size()];

			int i = 0;
			for (PersEmpr contratistaConsulta : lista) {
				selectContratistaConsulta[i] = new SelectItem(contratistaConsulta.getPersEmprId(), contratistaConsulta.getNombre());
				i++;

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectContratistaConsulta;
}

public void setSelectContratistaConsulta(SelectItem[] selectContratistaConsulta) {
	this.selectContratistaConsulta = selectContratistaConsulta;
}

public SelectItem[] getSelectNivel2ClientesConsulta() {

	if (nivel2ClientesConsulta == null || nivel2ClientesConsulta.size() == 0) {
		try {
			Long ConsultaCompania = new Long(getCompaniaIdSession());
			Long persEmprConsulta = null;

			if (txtPersEmprConsulta != null && txtPersEmprConsulta.getValue() != null) {
				persEmprConsulta = Long.parseLong(txtPersEmprConsulta.getValue().toString());

				// Criteria
				List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
						.listaNivel2Clientesmq(ConsultaCompania, persEmprConsulta);

				selectNivel2ClientesConsulta = new SelectItem[listaNivel2Clientesmq.size()];
				int i = 0;
				for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
					selectNivel2ClientesConsulta[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
							listaNivel2ClientesmqDto.getHacienda());
					i++;

				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	return selectNivel2ClientesConsulta;
}

public void setSelectNivel2ClientesConsulta(SelectItem[] selectNivel2ClientesConsulta) {
	this.selectNivel2ClientesConsulta = selectNivel2ClientesConsulta;
}


public String action_actualizar_detalle() {
    try {
    	
        if (entityPlanServiciosMqdet == null) {
            Long datPlanServiciosMqdetId = new Long(selectedDatPlanServiciosMq3.getId_programa().longValue());
            entityPlanServiciosMqdet = businessDelegator2View.getDatPlanServiciosMqdet(datPlanServiciosMqdetId);
        }
    	Long compania = new Long(getCompaniaIdSession());
        entityPlanServiciosMqdet.setCantidadPlan(FacesUtils.checkDouble(txtCantidad));
       
        entityPlanServiciosMqdet.setCantidadPresupuesto(FacesUtils.checkDouble(txtCantidadPresupuesto));
        entityPlanServiciosMqdet.setCantidadRealizada(FacesUtils.checkDouble(txtCantidadRealizada));
        entityPlanServiciosMqdet.setAreaProgramada(FacesUtils.checkDouble(txtAreaProgramada));
        Double cantidadPendiente=0.0;
        Double cantidadRealizada =FacesUtils.checkDouble(txtCantidadRealizada);
        Double cantidadPlan =FacesUtils.checkDouble(txtCantidad);
        if(cantidadRealizada!=null && cantidadPlan!=null) {
        	cantidadPendiente=cantidadPlan-cantidadRealizada;
        }
        
        entityPlanServiciosMqdet.setCantidadPendiente(cantidadPendiente);
        
        entityPlanServiciosMqdet.setConcluido(FacesUtils.checkString(txtConcluido));
        entityPlanServiciosMqdet.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
        entityPlanServiciosMqdet.setNivel2Clientesmq((FacesUtils.checkLong(
                txtNivel2ClientesId) != null)
            ? businessDelegator2View.getNivel2Clientesmq(
                FacesUtils.checkLong(txtNivel2ClientesId))
            : null);
        
        Long nivel4ClientesId = null;
		Nivel4Clientesmq nivel4Clientes = null;
		String codNivel4Clientes = FacesUtils.checkString(txtNivel4ClientesIdEdicion2);
		Long nivel2ClientesId = FacesUtils.checkLong(txtNivel2ClientesId);
		Nivel2Clientesmq nivel2Clientes =businessDelegator2View.getNivel2Clientesmq(nivel2ClientesId);
		
		if ( codNivel4Clientes!=null && !codNivel4Clientes.equals("")	) {
			
			Object[] condicion = { "codigo", true, codNivel4Clientes, "=", "nivel2Clientesmq.nivel2ClientesmqId", true, nivel2ClientesId, "="  };
			List<Nivel4Clientesmq> nivel4ClientesConsulta = businessDelegator2View.findByCriteriaInNivel4Clientesmq(condicion, null, null);	
			
			if (nivel4ClientesConsulta == null || nivel4ClientesConsulta.size()==0 ) {
				nivel4Clientes= new Nivel4Clientesmq();
				Date date = new Date();
				
				nivel4Clientes.setNivel2Clientesmq(nivel2Clientes);
				nivel4Clientes.setCodigo(codNivel4Clientes);
				nivel4Clientes.setNombre(codNivel4Clientes);
				nivel4Clientes.setCompania(compania);
				nivel4Clientes.setEstado("A");
				nivel4Clientes.setAreaNeta(0.0);
				nivel4Clientes.setFechaCreacion(date);
				
				businessDelegator2View.saveNivel4Clientesmq(nivel4Clientes);
	
			} else {
				nivel4Clientes = nivel4ClientesConsulta.get(0);
				codNivel4Clientes = nivel4Clientes.getCodigo();
			}				
		}
        
        
        entityPlanServiciosMqdet.setNivel4ClientesmqId(nivel4Clientes);
        
        
        entityPlanServiciosMqdet.setValorEstUnitario(FacesUtils.checkDouble(
                txtValorUnitario));
        Double valorUnitario =FacesUtils.checkDouble(txtValorUnitario);
        Double costoEstimado =0.0;
        if(cantidadPlan!=null && valorUnitario!=null) {
        	costoEstimado = cantidadPlan*valorUnitario;
        }
        entityPlanServiciosMqdet.setPeriodoInicial(FacesUtils.checkDate(txtPeriodoInicial));
        //entityPlanServiciosMqdet.setNivel4mqTexto(FacesUtils.checkString(txtNivel4mqTexto));
        entityPlanServiciosMqdet.setValorEstTotal(costoEstimado);
        
       entityPlanServiciosMqdet.setDatPlanServiciosMq((FacesUtils.checkLong(
                txtDatPlanServiciosMqId) != null)
            ? businessDelegator2View.getDatPlanServiciosMq(
                FacesUtils.checkLong(
                		txtDatPlanServiciosMqId)) : null);
        entityPlanServiciosMqdet.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
            ? businessDelegatorView.getLabor(FacesUtils.checkLong(
                    txtLaborId_Labor)) : null);
   
        entityPlanServiciosMqdet.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
            ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
                    txtPersEmprId_PersEmpr)) : null);
        entityPlanServiciosMqdet.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
            ? businessDelegatorView.getUdadMed(FacesUtils.checkLong(
                    txtUdadMedId_UdadMed)) : null);
        
        businessDelegator2View.updateDatPlanServiciosMqdet(entityPlanServiciosMqdet);
        
    	Long idPrograma = selectedDatPlanServiciosMq3.getId_programa().longValue();
		Object[] condicion = { "dat_plan_servicios_mqdet_id.datPlanServiciosMqdetId", true, idPrograma, "=" };
		List<DatServRealizadosEquipoDet> lista = (idPrograma != null)
		? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicion, null, null) : null;
		if (lista != null && lista.size() > 0) {
			for (int a = 0; a < lista.size(); a++) {
				DatServRealizadosEquipoDet entityDet  = lista.get(a);
				
				entityDet.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
			            ? businessDelegatorView.getLabor(FacesUtils.checkLong(
			                    txtLaborId_Labor)) : null);
				
				entityDet.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
			             ? businessDelegatorView.getUdadMed(FacesUtils.checkLong(
			                     txtUdadMedId_UdadMed)) : null);
				
				entityDet.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
			            ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
			                    txtPersEmprId_PersEmpr)) : null);
		        
				entityDet.setNivel2ClientesId((FacesUtils.checkLong(
			                txtNivel2ClientesId) != null)
			            ? businessDelegator2View.getNivel2Clientesmq(
			                FacesUtils.checkLong(txtNivel2ClientesId))
			            : null);
				
				
				entityDet.setNivel4ClientesId(nivel4Clientes);
				
			
				
				Date idFecha =     FacesUtils.checkDate(txtPeriodoInicial);
				Double valorUnitarioTrabajador =0.0;
				Double cantidad = entityDet.getCantidad();
				Long idCompania = new Long(getCompaniaIdSession());
				Long idUdadMed = FacesUtils.checkLong(txtUdadMedId_UdadMed);
				
				Long idLabor = FacesUtils.checkLong(txtLaborId_Labor) ;
						if(idUdadMed!=null &&idLabor!=null && idFecha!=null) {
							 valorUnitarioTrabajador = businessDelegatorView.consultarTarifaLaborRendimientoBase
									(idCompania, 0L, idLabor, 0L, idUdadMed, idFecha).doubleValue();
						}
				entityDet.setValor_unitario_trabajador(valorUnitarioTrabajador);
				Double valorTotalTrabajador = cantidad*valorUnitarioTrabajador;
				entityDet.setValor_total_trabajador(valorTotalTrabajador);
				
				businessDelegatorView.updateDatServRealizadosEquipoDet(entityDet); 
			}
		}
		
		
        FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
    } catch (Exception e) {
        data = null;
        FacesUtils.addErrorMessage(e.getMessage());
    }

    return "";
}

public SelectOneMenu getTxtNivel4ClientesIdEdicion() {
	return txtNivel4ClientesIdEdicion;
}

public void setTxtNivel4ClientesIdEdicion(SelectOneMenu txtNivel4ClientesIdEdicion) {
	this.txtNivel4ClientesIdEdicion = txtNivel4ClientesIdEdicion;
}




public List<String> getSelectedLabor() {
	return selectedLabor;
}

public void setSelectedLabor(List<String> selectedLabor) {
	this.selectedLabor = selectedLabor;
}

public List<ListaLaboresDTO> getLabores() {
	try {
		Long idCompania = new Long(getCompaniaIdSession());
		String cadena = "";
	
			if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
				cadena = selectedGrupoLabor.get(0);
				
				for (int i = 1; i < selectedGrupoLabor.size(); i++) {
					cadena += "," + selectedGrupoLabor.get(i);
				}
				labores = businessDelegator2View.pr_lista_labores(idCompania, cadena);
		
		}

		
	} catch (Exception e) {
		FacesUtils.addErrorMessage(e.getMessage());
		e.printStackTrace();
	}

	return labores;
}

public void setLabores(List<ListaLaboresDTO> labores) {
	this.labores = labores;
}
public List<String> getSelectedGrupoLabor() {
	return selectedGrupoLabor;
}

public void setSelectedGrupoLabor(List<String> selectedGrupoLabor) {
	this.selectedGrupoLabor = selectedGrupoLabor;
}

public List<GrpLabor> getGrupoLabores() {
	if (grupoLabores == null || grupoLabores.size() == 0) {

		try {
			grupoLabores = businessDelegatorView.getGrpLabor();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

	}
	return grupoLabores;
}

public void setGrupoLabores(List<GrpLabor> grupoLabores) {
	this.grupoLabores = grupoLabores;
}

public InputText getTxtNivel4ClientesIdEdicion2() {
	return txtNivel4ClientesIdEdicion2;
}

public void setTxtNivel4ClientesIdEdicion2(InputText txtNivel4ClientesIdEdicion2) {
	this.txtNivel4ClientesIdEdicion2 = txtNivel4ClientesIdEdicion2;
}



/********************************** Cierre programa de labores *****************/

public void listarProgramacionLaboresParaCierre() {
	try {
		 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		// fechaInicial = sdf.parse("2013-01-01");
		fechaInicial = (FacesUtils.checkDate(txtFechaIni));
		fechaFinal = (FacesUtils.checkDate(txtFechaFin));
		
		Long compania = new Long(getCompaniaIdSession());
		Long flagLabor = 1L;
		Long flagGrupoLabor = 1L;
	

		String concluido = FacesUtils.checkString(txtConcluidoConsulta);
		Double porcAvance =FacesUtils.checkDouble(txtPorcentajeAvance); 
		
		String supervisor ="0";
		Long flagSupervisor =1L;
		if(txtSupervisorConsulta.getValue()!=null) {
			supervisor =txtSupervisorConsulta.getValue().toString();
			flagSupervisor =0L;
		}
		
		
		String zona ="0";
		Long flagZona =1L;
		if(txtZonaConsulta.getValue()!=null) {
			zona =txtZonaConsulta.getValue().toString();
			flagZona =0L;
		}
		
		

		String cliente ="0";
		Long flagCliente =1L;
		if(txtPersEmprConsulta.getValue()!=null) {
			cliente =txtPersEmprConsulta.getValue().toString();
			flagCliente =0L;
		}
		
		

		String nivel2Mq ="0";
		Long flagNivel2Mq =1L;
		if(txtNivel2ClientesConsulta.getValue()!=null) {
			nivel2Mq =txtNivel2ClientesConsulta.getValue().toString();
			flagNivel2Mq =0L;
		}
		
		Long consecutivo = FacesUtils.checkLong(txtConsecutivoConsulta);
		if(consecutivo ==null) {
			consecutivo =0L;
		}
		
		String laboresSeleccionadas = "";
		if (selectedLabor != null && selectedLabor.size() > 0) {
			laboresSeleccionadas = selectedLabor.get(0);
			flagLabor = 0L;
			for (int i = 1; i < selectedLabor.size(); i++) {
				laboresSeleccionadas += "," + selectedLabor.get(i);
			}
		}
		

		String grupoLaboresSeleccionadas = "";
		if (selectedGrupoLabor != null && selectedGrupoLabor.size() > 0) {
			grupoLaboresSeleccionadas = selectedGrupoLabor.get(0);
			flagGrupoLabor = 0L;
			for (int i = 1; i < selectedGrupoLabor.size(); i++) {
				grupoLaboresSeleccionadas += "," + selectedGrupoLabor.get(i);
			}
		}

	
		if (fechaInicial != null && fechaFinal != null) {
			data3 = businessDelegator2View.pr_lista_prog_maquinaria( compania,  fechaInicial, fechaFinal,supervisor,  flagSupervisor,
					zona,flagZona, cliente,flagCliente,nivel2Mq,flagNivel2Mq,consecutivo,laboresSeleccionadas,flagLabor, grupoLaboresSeleccionadas,flagGrupoLabor
					,concluido, porcAvance);
		} else {
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	
}

public List<ProgLaboresMecMaqDTO> getSelectedDatPlanServiciosMq4() {
	return selectedDatPlanServiciosMq4;
}

public void setSelectedDatPlanServiciosMq4(List<ProgLaboresMecMaqDTO> selectedDatPlanServiciosMq4) {
	this.selectedDatPlanServiciosMq4 = selectedDatPlanServiciosMq4;
}




public void action_valoresSeleccionados() throws Exception {
	Long compania = new Long(getCompaniaIdSession());
	String cadena = "";
	Long flagZona = 1L;
	Long usuarioId = new Long(getUsuarioIdSession());
	Long idDetalle  = null;
	 
	 
	
	if (selectedDatPlanServiciosMq4 != null && selectedDatPlanServiciosMq4.size() > 0) {
	
			for (int a = 0; a < selectedDatPlanServiciosMq4.size(); a++) {
				ProgLaboresMecMaqDTO datos  = selectedDatPlanServiciosMq4.get(a);
				idDetalle = datos.getId_programa().longValue();
				
				DatPlanServiciosMqdet entityDet = businessDelegatorView.getDatPlanServiciosMqdet(idDetalle);
				if(entityDet!=null) {
					entityDet.setConcluido("SI");
					//entityDet.setCantidadPendiente(0.0);
				//	Double cantidadPlan = entityDet.getCantidadPlan();
				//	entityDet.setCantidadRealizada(cantidadPlan);
				
					cadena += "," + idDetalle.toString();
					businessDelegatorView.updateDatPlanServiciosMqdet(entityDet);
				}
			}
		}
	
		 
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se han actualizado las ordenes con éxito "));

			disableButtonA = "true";
			cadena = null;
		 
				
}

public String getDisableButtonA() {
	return disableButtonA;
}

public void setDisableButtonA(String disableButtonA) {
	this.disableButtonA = disableButtonA;
}

public SelectOneMenu getTxtConcluidoConsulta() {
	return txtConcluidoConsulta;
}

public void setTxtConcluidoConsulta(SelectOneMenu txtConcluidoConsulta) {
	this.txtConcluidoConsulta = txtConcluidoConsulta;
}

public InputText getTxtPorcentajeAvance() {
	return txtPorcentajeAvance;
}

public void setTxtPorcentajeAvance(InputText txtPorcentajeAvance) {
	this.txtPorcentajeAvance = txtPorcentajeAvance;
}
	



}
