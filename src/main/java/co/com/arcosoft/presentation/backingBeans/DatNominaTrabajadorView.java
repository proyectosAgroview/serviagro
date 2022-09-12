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
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatNominaTrabajador;
import co.com.arcosoft.modelo.DatNominaTrabajadorDet;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDTO;
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
public class DatNominaTrabajadorView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatNominaTrabajadorId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatNominaTrabajadorDTO> data;
	private DatNominaTrabajadorDTO selectedDatNominaTrabajador;
	private DatNominaTrabajador entity;
	private boolean showDialog;
	private DatNominaTrabajadorDet entityDet;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	/*** Detalle trabajadores ***/

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private CommandButton btnAgregar;

	private List<DatNominaTrabajadorDetDTO> dataNominaTrabajador;
	private DatNominaTrabajadorDetDTO selectedNominaTrabajadorDet;

	private InputText txtTrabajadorNombre;
	private InputText txtConceptoNombre;

	private InputNumber txtValorTotal;
	/******************************/
	private int activeTapIndex = 0;
	
	private InputNumber txtValorDeduccion;
	private SelectOneMenu txtTipoMovimiento;
	/******************************/	

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputNumber txtPlanilla;
	
	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtValorTotalAcumuladoDeduccion;

	public DatNominaTrabajadorView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatNominaTrabajador = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatNominaTrabajador = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
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

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(false);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtDatNominaTrabajadorId != null) {
			txtDatNominaTrabajadorId.setValue(null);
			txtDatNominaTrabajadorId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		/************ + Detalle trabajadores ****/

		if (txtTrabId_Trabajador != null) {
			txtTrabId_Trabajador.setValue(null);
			txtTrabId_Trabajador.setDisabled(false);
		}

		if (txtTrabajadorNombre != null) {
			txtTrabajadorNombre.setValue(null);
			txtTrabajadorNombre.setDisabled(false);
		}
		if (txtCeptoNominaId_ConceptoNomina != null) {
			txtCeptoNominaId_ConceptoNomina.setValue(null);
			txtCeptoNominaId_ConceptoNomina.setDisabled(false);
		}

		if (txtConceptoNombre != null) {
			txtConceptoNombre.setValue(null);
			txtConceptoNombre.setDisabled(false);
		}
		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(false);
		}
		
		if (txtTipoMovimiento != null) {
			txtTipoMovimiento.setValue(null);
			txtTipoMovimiento.setDisabled(false);
		}
		if (txtValorDeduccion != null) {
			txtValorDeduccion.setValue(null);
			txtValorDeduccion.setDisabled(false);
		}
		if (txtValorTotalAcumulado != null) {
			txtValorTotalAcumulado.setValue(null);
			txtValorTotalAcumulado.setDisabled(false);
		}
		
		if (txtValorTotalAcumuladoDeduccion != null) {
			txtValorTotalAcumuladoDeduccion.setValue(null);
			txtValorTotalAcumuladoDeduccion.setDisabled(false);
		}
		
		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (dataNominaTrabajador != null) {
			dataNominaTrabajador = null;
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

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
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
		selectedDatNominaTrabajador = (DatNominaTrabajadorDTO) (evt.getComponent().getAttributes()
				.get("selectedDatNominaTrabajador"));

		try {

			Long consecutivo = selectedDatNominaTrabajador.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatNominaTrabajador> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatNominaTrabajador(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(selectedDatNominaTrabajador.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaFinal.setValue(selectedDatNominaTrabajador.getFechaFinal());
				txtFechaFinal.setDisabled(false);
				txtFechaInicial.setValue(selectedDatNominaTrabajador.getFechaInicial());
				txtFechaInicial.setDisabled(false);
				txtObservacion.setValue(selectedDatNominaTrabajador.getObservacion());
				txtObservacion.setDisabled(false);
				txtDatNominaTrabajadorId.setValue(selectedDatNominaTrabajador.getDatNominaTrabajadorId());
				txtDatNominaTrabajadorId.setDisabled(true);
				btnSave.setDisabled(false);

				txtTrabId_Trabajador.setDisabled(false);
				//txtConceptoNombre.setDisabled(false);
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				txtValorTotal.setDisabled(false);
				btnAgregar.setDisabled(false);

				txtTipoMovimiento.setDisabled(false);
				txtValorDeduccion.setDisabled(false);

				
				Long id = FacesUtils.checkLong(txtDatNominaTrabajadorId);

				dataNominaTrabajador = null;
				dataNominaTrabajador = businessDelegatorView.getDataDatNominaTrabajadorDetByNomina(id);

				   double subTotalValorTotal = 0;
					double impuestos = 0;
					double valorTotalDevengo = 0;
					double valorTotalDeduccion = 0;
					if(dataNominaTrabajador!=null && dataNominaTrabajador.size()>=0) {
					 for( DatNominaTrabajadorDetDTO data1 : dataNominaTrabajador) {
				         if(data1.getValorTotal()!=null) {  
				        	 valorTotalDevengo += data1.getValorTotal().doubleValue();
				         } 
				         if(data1.getValorDeduccion()!=null) {  
				        	 valorTotalDeduccion += data1.getValorDeduccion().doubleValue();
				         } 
				         
				        
				        }
					}
			       txtValorTotalAcumulado.setValue(valorTotalDevengo);
					txtValorTotalAcumulado.setDisabled(false);
					
					txtValorTotalAcumuladoDeduccion.setValue(valorTotalDeduccion);
					txtValorTotalAcumuladoDeduccion.setDisabled(false);
				
					
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
			if ((selectedDatNominaTrabajador == null) && (entity == null)) {
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
			entity = new DatNominaTrabajador();

			// Long datNominaTrabajadorId =
			// FacesUtils.checkLong(txtDatNominaTrabajadorId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);

			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoConsolidadoNomina(compania)));

			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.saveDatNominaTrabajador(entity, dataNominaTrabajador);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED
					+ (businessDelegatorView.consultarConsecutivoConsolidadoNomina(compania) - 1));
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
				Long datNominaTrabajadorId = new Long(selectedDatNominaTrabajador.getDatNominaTrabajadorId());
				entity = businessDelegatorView.getDatNominaTrabajador(datNominaTrabajadorId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatNominaTrabajador(entity, dataNominaTrabajador);
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
			selectedDatNominaTrabajador = (DatNominaTrabajadorDTO) (evt.getComponent().getAttributes()
					.get("selectedDatNominaTrabajador"));

			Long datNominaTrabajadorId = new Long(selectedDatNominaTrabajador.getDatNominaTrabajadorId());
			entity = businessDelegatorView.getDatNominaTrabajador(datNominaTrabajadorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datNominaTrabajadorId = FacesUtils.checkLong(txtDatNominaTrabajadorId);
			entity = businessDelegatorView.getDatNominaTrabajador(datNominaTrabajadorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatNominaTrabajador(entity);
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
			selectedDatNominaTrabajador = (DatNominaTrabajadorDTO) (evt.getComponent().getAttributes()
					.get("selectedDatNominaTrabajador"));

			Long datNominaTrabajadorId = new Long(selectedDatNominaTrabajador.getDatNominaTrabajadorId());
			entity = businessDelegatorView.getDatNominaTrabajador(datNominaTrabajadorId);
			businessDelegatorView.deleteDatNominaTrabajador(entity);
			data.remove(selectedDatNominaTrabajador);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datNominaTrabajadorId, String estado,
			Date fechaAnulacion, Date fechaCreacion, Date fechaFinal, Date fechaInicial, Date fechaModificacion,
			String infoAdicional, String infoAdicional2, String observacion, String observacionAnularReg,
			Long usuarioDigitacion) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatNominaTrabajador(entity, dataNominaTrabajador);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatNominaTrabajadorView").requestRender();
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

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
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

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtDatNominaTrabajadorId() {
		return txtDatNominaTrabajadorId;
	}

	public void setTxtDatNominaTrabajadorId(InputText txtDatNominaTrabajadorId) {
		this.txtDatNominaTrabajadorId = txtDatNominaTrabajadorId;
	}

	/*public List<DatNominaTrabajadorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatNominaTrabajador();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatNominaTrabajadorDTO> datNominaTrabajadorDTO) {
		this.data = datNominaTrabajadorDTO;
	}*/
	
	public List<DatNominaTrabajadorDTO> getData() {
		return data;
	}

	public void setData(List<DatNominaTrabajadorDTO> datNominaTrabajadorDTO) {
		this.data = datNominaTrabajadorDTO;
	}

	public DatNominaTrabajadorDTO getSelectedDatNominaTrabajador() {
		return selectedDatNominaTrabajador;
	}

	public void setSelectedDatNominaTrabajador(DatNominaTrabajadorDTO datNominaTrabajador) {
		this.selectedDatNominaTrabajador = datNominaTrabajador;
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

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}

	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<DatNominaTrabajadorDetDTO> getDataNominaTrabajador() {
		return dataNominaTrabajador;
	}

	public void setDataNominaTrabajador(List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) {
		this.dataNominaTrabajador = dataNominaTrabajador;
	}

	public InputText getTxtTrabajadorNombre() {
		return txtTrabajadorNombre;
	}

	public void setTxtTrabajadorNombre(InputText txtTrabajadorNombre) {
		this.txtTrabajadorNombre = txtTrabajadorNombre;
	}

	public InputText getTxtConceptoNombre() {
		return txtConceptoNombre;
	}

	public void setTxtConceptoNombre(InputText txtConceptoNombre) {
		this.txtConceptoNombre = txtConceptoNombre;
	}

	public InputNumber getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(InputNumber txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public SelectItem[] getSelectCeptoNominaId() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

		
			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setselectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {
			try {

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

	public List<DatNominaTrabajadorDetDTO> getDataPlanillaNominaDet1() {

		if (dataNominaTrabajador == null || dataNominaTrabajador.size() == 0) {
			return null;
		} else {
			return dataNominaTrabajador;
		}

	}

	public void action_agregarPlanilla() throws Exception {

		if (txtTrabId_Trabajador.getValue() != null && txtCeptoNominaId_ConceptoNomina.getValue() != null
				) {

			Long trabajadorId = Long.parseLong(txtTrabId_Trabajador.getValue().toString());
			Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

			Long conceptoNominaId = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());
			ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);

			String codTrabajador = trabajador.getNombre();
			String codConceptoNomina = conceptoNomina.getNombre();
			Double costoTotal = FacesUtils.checkDouble(txtValorTotal);

			Double valorDeduccion = 0.0;
			if(txtValorDeduccion.getValue()!=null) {
				valorDeduccion = FacesUtils.checkDouble(txtValorDeduccion);
			}
			
			String tipoMovimiento  = FacesUtils.checkString(txtTipoMovimiento);
			
			
			boolean existeProducto = false;

			if (dataNominaTrabajador == null) {
				dataNominaTrabajador = new ArrayList<DatNominaTrabajadorDetDTO>();

			}

			if (dataNominaTrabajador.size() > 0) {

				for (DatNominaTrabajadorDetDTO d : dataNominaTrabajador) {

					if (d.getTrabId_Trabajador().getTrabId().longValue() == trabajador.getTrabId().longValue()
							&& d.getCeptoNominaId_ConceptoNomina().getCeptoNominaId().longValue() == conceptoNomina
									.getCeptoNominaId().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"El trabajador " + d.getTrabId_Trabajador().getCodigo().toString()
												+ d.getCeptoNominaId_ConceptoNomina().getNombre().toString()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				DatNominaTrabajadorDetDTO datNominaTrabajadorDetDTO = new DatNominaTrabajadorDetDTO();
				datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
				datNominaTrabajadorDetDTO.setCeptoNominaId_ConceptoNomina(conceptoNomina);
				datNominaTrabajadorDetDTO.setNombreTrabajador(codTrabajador);
				datNominaTrabajadorDetDTO.setNombreConceptoNomina(codConceptoNomina);
				datNominaTrabajadorDetDTO.setValorTotal(costoTotal);
				datNominaTrabajadorDetDTO.setValorDeduccion(valorDeduccion);
				datNominaTrabajadorDetDTO.setTipoMovimiento(tipoMovimiento);
			
				dataNominaTrabajador.add(datNominaTrabajadorDetDTO);

			}

			trabajador = null;
			conceptoNomina = null;
			codTrabajador = null;
			codConceptoNomina = null;
			costoTotal = null;
			tipoMovimiento =null;
			valorDeduccion =null;
			limpiar_pantalla();
			// dataDetProductos = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  trabajador, concepto, valor total tengan valores. "));
		}
	}

	public String actionDeleteDatNominaTrabajadorDet(ActionEvent evt) {
		try {

			selectedNominaTrabajadorDet = (DatNominaTrabajadorDetDTO) (evt.getComponent().getAttributes()
					.get("selectedNominaTrabajadorDet"));

			if (selectedNominaTrabajadorDet.getDatNominaTrabajadorDetId() == null) {
				dataNominaTrabajador.remove(selectedNominaTrabajadorDet);
			} else {
				Long detPlanillaNominaDetId = new Long(selectedNominaTrabajadorDet.getDatNominaTrabajadorDetId());
				DatNominaTrabajadorDet entity = businessDelegatorView.getDatNominaTrabajadorDet(detPlanillaNominaDetId);
				businessDelegatorView.deleteDatNominaTrabajadorDet(entity);
				dataNominaTrabajador.remove(selectedNominaTrabajadorDet);
				
				   double subTotalValorTotal = 0;
					double impuestos = 0;
					double valorTotalDevengo = 0;
					double valorTotalDeduccion = 0;
					if(dataNominaTrabajador!=null && dataNominaTrabajador.size()>=0) {
					 for( DatNominaTrabajadorDetDTO data1 : dataNominaTrabajador) {
							 if(data1.getValorTotal()!=null) {  
					        	 valorTotalDevengo += data1.getValorTotal().doubleValue();
					         } 
					         if(data1.getValorDeduccion()!=null) {  
					        	 valorTotalDeduccion += data1.getValorDeduccion().doubleValue();
					         } 
				         
				        }
					}
			       txtValorTotalAcumulado.setValue(valorTotalDevengo);
					txtValorTotalAcumulado.setDisabled(false);
					
					txtValorTotalAcumuladoDeduccion.setValue(valorTotalDeduccion);
					txtValorTotalAcumuladoDeduccion.setDisabled(false);
				

			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void listener_ConsultaCodTrabajador() {

		Long idTrabajador = null;
		if (FacesUtils.checkLong(txtTrabId_Trabajador) != null) {
			if (!txtTrabId_Trabajador.getValue().equals("")) {
				idTrabajador = Long.parseLong(txtTrabId_Trabajador.getValue().toString());

				try {
					Trabajador trabajador = businessDelegatorView.getTrabajador(idTrabajador);
					/* valNPass = datPlanLabor.getNPases(); */
					txtTrabajadorNombre.setValue(trabajador.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}
	}

	public void listener_ConsultaCodConceptoNomina() {

		Long idConcepto = null;
		if (FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null) {
			if (!txtCeptoNominaId_ConceptoNomina.getValue().equals("")) {
				idConcepto = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());

				try {
					ConceptoNomina concepto = businessDelegatorView.getConceptoNomina(idConcepto);
					/* valNPass = datPlanLabor.getNPases(); */
					txtConceptoNombre.setValue(concepto.getCodigo());

				} catch (Exception e) {
					FacesUtils.addErrorMessage(e.getMessage());
				}

			}
		}

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
				Long id = new Long(selectedDatNominaTrabajador.getDatNominaTrabajadorId());
				entity = businessDelegatorView.getDatNominaTrabajador(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatNominaTrabajador(entity, dataNominaTrabajador);
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
		selectedDatNominaTrabajador = (DatNominaTrabajadorDTO) (evt.getComponent().getAttributes()
				.get("selectedDatNominaTrabajador"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}
	
	public void listarNominaTrabajador() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Long compania = new Long(getCompaniaIdSession());
			Long planilla = FacesUtils.checkLong(txtPlanilla);
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			
			if (planilla == null) {
				planilla = 0L;
			}

			if (compania != null && fechaInicial != null && fechaFinal != null) {
				data = businessDelegator2View.pr_lista_dat_nomina_trabajador(compania, fechaInicial, fechaFinal, planilla);

			} else if (compania != null && fechaInicial == null && fechaFinal == null && planilla != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data = businessDelegator2View.pr_lista_dat_nomina_trabajador(compania, fechaInicial, fechaFinal, planilla);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputNumber getTxtValorDeduccion() {
		return txtValorDeduccion;
	}

	public void setTxtValorDeduccion(InputNumber txtValorDeduccion) {
		this.txtValorDeduccion = txtValorDeduccion;
	}

	public SelectOneMenu getTxtTipoMovimiento() {
		return txtTipoMovimiento;
	}

	public void setTxtTipoMovimiento(SelectOneMenu txtTipoMovimiento) {
		this.txtTipoMovimiento = txtTipoMovimiento;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public InputNumber getTxtValorTotalAcumuladoDeduccion() {
		return txtValorTotalAcumuladoDeduccion;
	}

	public void setTxtValorTotalAcumuladoDeduccion(InputNumber txtValorTotalAcumuladoDeduccion) {
		this.txtValorTotalAcumuladoDeduccion = txtValorTotalAcumuladoDeduccion;
	}
	
	public void limpiar_pantalla() {
		txtValorTotal.setValue(null);
		txtValorDeduccion.setValue(null);
		txtTipoMovimiento.setValue(null);
		txtCeptoNominaId_ConceptoNomina.setValue(null);
	}

	

	public void onCellEditEventos(CellEditEvent evt) throws Exception {
		
		// caso 1 : la tabla transaccional no tiene valores
		Long datNominaTrabajadormq = FacesUtils.checkLong(txtDatNominaTrabajadorId);
		if(datNominaTrabajadormq !=null) {
		selectedNominaTrabajadorDet = (DatNominaTrabajadorDetDTO) (evt.getComponent().getAttributes()
				.get("selectedNominaTrabajadorDet"));
		if(selectedNominaTrabajadorDet.getDatNominaTrabajadorDetId() !=null) {
		Long datNominaTrabajadormqdetId = selectedNominaTrabajadorDet.getDatNominaTrabajadorDetId().longValue();
		
		
		String columnaCell = evt.getColumn().getHeaderText();

		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityDet = null;
			entityDet = businessDelegatorView.getDatNominaTrabajadorDet(datNominaTrabajadormqdetId);

		
			if (columnaCell.equals("VR. Devengo")) {

				entityDet.setValorTotal(Double.valueOf(evt.getNewValue().toString()));

			}
			

			if (columnaCell.equals("VR. Deducción")) {

				entityDet.setValorDeduccion(Double.valueOf(evt.getNewValue().toString()));

			}
			
			
			entity =  businessDelegatorView.getDatNominaTrabajador(datNominaTrabajadormq);
			entityDet.setDatNominaTrabajador(entity);
			businessDelegatorView.updateDatNominaTrabajadorDet(entityDet);
			
		//	entity = null;
		
			selectedNominaTrabajadorDet = null;
			entityDet = null;
			
			dataNominaTrabajador = null;
			dataNominaTrabajador = businessDelegatorView.getDataDatNominaTrabajadorDetByNomina(datNominaTrabajadormq);
		}
		
		}
	}else {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
				"Para poder modificar la información, primero los datos deben estar grabados. "));

	}
		
	}

	public DatNominaTrabajador getEntity() {
		return entity;
	}

	public void setEntity(DatNominaTrabajador entity) {
		this.entity = entity;
	}

	public DatNominaTrabajadorDet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatNominaTrabajadorDet entityDet) {
		this.entityDet = entityDet;
	}


	
	public void listener_TipoMovimiento() {

		String tipoMovimiento = "";
		if (txtTipoMovimiento.getValue() != null) {
			if (!txtTipoMovimiento.getValue().equals("")) {
				tipoMovimiento = txtTipoMovimiento.getValue().toString();

				if(tipoMovimiento.equals("Devengo")) {
					txtValorTotal.setDisabled(false);
					txtValorDeduccion.setDisabled(true);
				}
				if(tipoMovimiento.equals("Deduccion")){
					txtValorTotal.setDisabled(true);
					txtValorDeduccion.setDisabled(false);
				}

			}
		}
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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

	public InputNumber getTxtPlanilla() {
		return txtPlanilla;
	}

	public void setTxtPlanilla(InputNumber txtPlanilla) {
		this.txtPlanilla = txtPlanilla;
	}

	

}
