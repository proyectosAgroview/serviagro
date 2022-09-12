package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

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
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatNominaTrabajadorMq;
import co.com.arcosoft.modelo.DatNominaTrabajadorMqdet;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqdetDTO;
import co.com.arcosoft.modelo.informes.dto.ImportarNominaEmpAdmonDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.DriverManagerDataSourceUtils;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatNominaTrabajadorMqView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorMqView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatNominaTrabajadorMqId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatNominaTrabajadorMqDTO> data;
	private DatNominaTrabajadorMqDTO selectedDatNominaTrabajadorMq;
	private DatNominaTrabajadorMq entity;
	private boolean showDialog;
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

	private SelectOneMenu txtUdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private Spinner txtCantidad;

	private CommandButton btnAgregar;

	private List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador;
	private DatNominaTrabajadorMqdetDTO selectedNominaTrabajadorMqdet;

	private InputText txtTrabajadorNombre;
	private InputText txtConceptoNombre;

	private InputNumber txtValorTotal;
	private InputNumber txtValorDeduccion;
	private SelectOneMenu txtTipoMovimiento;
	/******************************/
	private int activeTapIndex = 0;

	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtValorTotalAcumuladoDeduccion;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private InputTextarea txtDetalleNota;

	private DatNominaTrabajadorMqdet entityDet;

	private SelectOneMenu txtTipoNomina;

	private Calendar txtFechaInicialVac;
	private Calendar txtFechaFinalVac;
	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	SelectItem[] selectCentCostEdit;

	public DatNominaTrabajadorMqView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatNominaTrabajadorMq = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatNominaTrabajadorMq = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtTipoNomina != null) {
			txtTipoNomina.setValue(null);
			txtTipoNomina.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtDetalleNota != null) {
			txtDetalleNota.setValue(null);
			txtDetalleNota.setDisabled(false);
		}

		if (txtEquipoId_Equipo != null) {
			txtEquipoId_Equipo.setValue(null);
			txtEquipoId_Equipo.setDisabled(false);
		}
		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(false);
		}
		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}
		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(false);
		}

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(false);
		}

		if (txtUdadMed != null) {
			txtUdadMed.setValue(null);
			txtUdadMed.setDisabled(false);
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

		if (txtFechaFinalVac != null) {
			txtFechaFinalVac.setValue(null);
			txtFechaFinalVac.setDisabled(true);
		}

		if (txtFechaInicialVac != null) {
			txtFechaInicialVac.setValue(null);
			txtFechaInicialVac.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtDatNominaTrabajadorMqId != null) {
			txtDatNominaTrabajadorMqId.setValue(null);
			txtDatNominaTrabajadorMqId.setDisabled(false);
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

	public void listenerVacaciones() throws Exception {
		if (txtCeptoNominaId_ConceptoNomina.getValue() != null) {
			txtFechaInicialVac.setDisabled(true);
			txtFechaFinalVac.setDisabled(true);
			Long conceptoId = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);
			ConceptoNomina concepto = businessDelegatorView.getConceptoNomina(conceptoId);
			String tipoConcepto = concepto.getTipoConcepto();
			if (tipoConcepto != null) {
				if (tipoConcepto.equals("vacaciones")) {
					txtFechaInicialVac.setDisabled(false);
					txtFechaFinalVac.setDisabled(false);
				}
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDatNominaTrabajadorMq = (DatNominaTrabajadorMqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatNominaTrabajadorMq"));

		try {

			Long id = selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId();
			Object[] condicion = { "datNominaTrabajadorMqId", true, id, "=" };
			List<DatNominaTrabajadorMq> lista = (id != null)
					? businessDelegatorView.findByCriteriaInDatNominaTrabajadorMq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);

				txtTipoNomina.setValue(entity.getTipoNomina());
				txtTipoNomina.setDisabled(true);

				txtFechaFinal.setValue(entity.getFechaFinal());
				txtFechaFinal.setDisabled(false);
				txtFechaInicial.setValue(entity.getFechaInicial());
				txtFechaInicial.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtDatNominaTrabajadorMqId.setValue(entity.getDatNominaTrabajadorMqId());
				txtDatNominaTrabajadorMqId.setDisabled(true);
				btnSave.setDisabled(false);

				txtTrabId_Trabajador.setDisabled(false);

				txtCeptoNominaId_ConceptoNomina.setDisabled(false);
				txtValorTotal.setDisabled(false);
				// txtCantidad.setDisabled(false);
				txtDetalleNota.setDisabled(false);
				txtTipoMovimiento.setDisabled(false);
				txtValorDeduccion.setDisabled(false);
				txtEquipoId_Equipo.setDisabled(false);
				btnAgregar.setDisabled(false);

				txtFechaFinalVac.setDisabled(true);
				txtFechaInicialVac.setDisabled(true);

				// Long id = FacesUtils.checkLong(txtDatNominaTrabajadorMqId);

				dataNominaTrabajador = null;
				dataNominaTrabajador = businessDelegator2View.getDataDatNominaTrabajadorMqdetByNomina(id);

				double subTotalValorTotal = 0;
				double impuestos = 0;
				double valorTotalDevengo = 0;
				double valorTotalDeduccion = 0;
				if (dataNominaTrabajador != null && dataNominaTrabajador.size() >= 0) {
					for (DatNominaTrabajadorMqdetDTO data1 : dataNominaTrabajador) {
						valorTotalDevengo += data1.getValorTotal().doubleValue();
						valorTotalDeduccion += data1.getValorDeduccion().doubleValue();
					}
				}
				txtValorTotalAcumulado.setValue(valorTotalDevengo);
				txtValorTotalAcumulado.setDisabled(false);

				txtValorTotalAcumuladoDeduccion.setValue(valorTotalDeduccion);
				txtValorTotalAcumuladoDeduccion.setDisabled(false);
				activeTapIndex = 0;

				txtCentCostId_CentCost.setDisabled(false);

				setShowDialog(true);

			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_cerrar_nomina(ActionEvent evt) {
		selectedDatNominaTrabajadorMq = (DatNominaTrabajadorMqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatNominaTrabajadorMq"));
		try {

			Long id = selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId();
			Object[] condicion = { "datNominaTrabajadorMqId", true, id, "=" };
			List<DatNominaTrabajadorMq> lista = (id != null)
					? businessDelegatorView.findByCriteriaInDatNominaTrabajadorMq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				Long usuarioId = new Long(getUsuarioIdSession());
				Date fechaInicial = selectedDatNominaTrabajadorMq.getFechaInicial();
				Date fechaFinal = selectedDatNominaTrabajadorMq.getFechaFinal();
				String tipoNomina = selectedDatNominaTrabajadorMq.getTipoNomina();
				Long compania = selectedDatNominaTrabajadorMq.getCompania();

				if (compania != null && fechaInicial != null && fechaFinal != null && tipoNomina != null) {
					entity.setEstadoNomina("CERRADA");
					businessDelegator2View.pr_cierre_nomina_destajo_maquinaria(compania, fechaInicial, fechaFinal,
							tipoNomina, usuarioId);
					businessDelegatorView.updateDatNominaTrabajadorMq(entity, null);

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"La nónina " + tipoNomina + " fue cerrada correctamente", "Upps!"));

				}
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatNominaTrabajadorMq == null) && (entity == null)) {
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
			entity = new DatNominaTrabajadorMq();

			// Long datNominaTrabajadorId =
			// FacesUtils.checkLong(txtDatNominaTrabajadorMqId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);
			entity.setTipoNomina(FacesUtils.checkString(txtTipoNomina));
			entity.setConsecutivo((businessDelegator2View.consultarConsecutivoConsolidadoNominamq(compania)));
			entity.setEstadoNomina("ABIERTA");
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.saveDatNominaTrabajadorMq(entity, dataNominaTrabajador);
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
				Long datNominaTrabajadorId = new Long(selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId());
				entity = businessDelegatorView.getDatNominaTrabajadorMq(datNominaTrabajadorId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setTipoNomina(FacesUtils.checkString(txtTipoNomina));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatNominaTrabajadorMq(entity, dataNominaTrabajador);
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
			selectedDatNominaTrabajadorMq = (DatNominaTrabajadorMqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatNominaTrabajadorMq"));

			Long datNominaTrabajadorId = new Long(selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId());
			entity = businessDelegatorView.getDatNominaTrabajadorMq(datNominaTrabajadorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datNominaTrabajadorId = FacesUtils.checkLong(txtDatNominaTrabajadorMqId);
			entity = businessDelegatorView.getDatNominaTrabajadorMq(datNominaTrabajadorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatNominaTrabajadorMq(entity);
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
			selectedDatNominaTrabajadorMq = (DatNominaTrabajadorMqDTO) (evt.getComponent().getAttributes()
					.get("selectedDatNominaTrabajadorMq"));

			Long datNominaTrabajadorId = new Long(selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId());
			entity = businessDelegatorView.getDatNominaTrabajadorMq(datNominaTrabajadorId);
			businessDelegatorView.deleteDatNominaTrabajadorMq(entity);
			data.remove(selectedDatNominaTrabajadorMq);
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
			businessDelegatorView.updateDatNominaTrabajadorMq(entity, dataNominaTrabajador);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatNominaTrabajadorMqView").requestRender();
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

	public InputText getTxtDatNominaTrabajadorMqId() {
		return txtDatNominaTrabajadorMqId;
	}

	public void setTxtDatNominaTrabajadorMqId(InputText txtDatNominaTrabajadorMqId) {
		this.txtDatNominaTrabajadorMqId = txtDatNominaTrabajadorMqId;
	}

	public List<DatNominaTrabajadorMqDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatNominaTrabajadorMq();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatNominaTrabajadorMqDTO> datNominaTrabajadorDTO) {
		this.data = datNominaTrabajadorDTO;
	}

	public DatNominaTrabajadorMqDTO getSelectedDatNominaTrabajadorMq() {
		return selectedDatNominaTrabajadorMq;
	}

	public void setSelectedDatNominaTrabajadorMq(DatNominaTrabajadorMqDTO datNominaTrabajador) {
		this.selectedDatNominaTrabajadorMq = datNominaTrabajador;
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

	public List<DatNominaTrabajadorMqdetDTO> getDataNominaTrabajador() {
		return dataNominaTrabajador;
	}

	public void setDataNominaTrabajador(List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador) {
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
				String tipoNomina = "";
				if (txtTipoNomina.getValue() != null) {
					if (!txtTipoNomina.getValue().equals("")) {
						tipoNomina = txtTipoNomina.getValue().toString();

						Object[] condicion = { "estado", true, "A", "=", "tipo_trabajador", true, tipoNomina, "=" };
						List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null,
								null);
						selectTrabajador = new SelectItem[lista.size()];

						int i = 0;
						for (Trabajador trabajador : lista) {
							selectTrabajador[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
							i++;
						}
					}
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

	public List<DatNominaTrabajadorMqdetDTO> getDataPlanillaNominaDet1() {

		if (dataNominaTrabajador == null || dataNominaTrabajador.size() == 0) {
			return null;
		} else {
			return dataNominaTrabajador;
		}

	}

	public void action_agregarPlanilla() throws Exception {

		if (txtTrabId_Trabajador.getValue() != null && txtCeptoNominaId_ConceptoNomina.getValue() != null
				&& txtTipoMovimiento.getValue() != null && txtCentCostId_CentCost.getValue() != null) {

			Long trabajadorId = Long.parseLong(txtTrabId_Trabajador.getValue().toString());
			Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

			Long conceptoNominaId = Long.parseLong(txtCeptoNominaId_ConceptoNomina.getValue().toString());
			ConceptoNomina conceptoNomina = businessDelegatorView.getConceptoNomina(conceptoNominaId);

			Long equipoId = null;
			String codEquipo = "";
			Equipo equipo = null;
			if (txtEquipoId_Equipo.getValue() != null) {
				equipoId = Long.parseLong(txtEquipoId_Equipo.getValue().toString());
				equipo = businessDelegatorView.getEquipo(equipoId);
				codEquipo = equipo.getCodigo();
			}

			Date fechaIniVac = FacesUtils.checkDate(txtFechaInicialVac);
			Date fechaFinVac = FacesUtils.checkDate(txtFechaFinalVac);

			String detalleNota = FacesUtils.checkString(txtDetalleNota);

			String codTrabajador = trabajador.getNombre();
			String codConceptoNomina = conceptoNomina.getNombre();

			Double costoTotal = 0.0;
			if (txtValorTotal.getValue() != null) {
				costoTotal = FacesUtils.checkDouble(txtValorTotal);
			}

			Double valorDeduccion = 0.0;
			if (txtValorDeduccion.getValue() != null) {
				valorDeduccion = FacesUtils.checkDouble(txtValorDeduccion);
			}

			String tipoMovimiento = FacesUtils.checkString(txtTipoMovimiento);

			Double cantidad = 0.0;// FacesUtils.checkDouble(txtCantidad);
			Long centCostId = null;
			CentCost centCost = null;
			String nombreCentCost = "";
			if (txtCentCostId_CentCost.getValue() != null) {
				centCostId = FacesUtils.checkLong(txtCentCostId_CentCost);
				centCost = businessDelegatorView.getCentCost(centCostId);
				nombreCentCost = centCost.getNombre();
			}

			/*
			 * Long udadMedId = null; UdadMed udadMed = null; String nombreUdadMed = null;
			 * 
			 * if(txtUdadMed.getValue() !=null){ udadMedId =
			 * Long.parseLong(txtUdadMed.getValue().toString()); udadMed =
			 * businessDelegatorView.getUdadMed(udadMedId); nombreUdadMed =
			 * udadMed.getNombre(); }
			 */
			boolean existeProducto = false;

			if (dataNominaTrabajador == null) {
				dataNominaTrabajador = new ArrayList<DatNominaTrabajadorMqdetDTO>();

			}

			DatNominaTrabajadorMqdetDTO datNominaTrabajadorDetDTO = new DatNominaTrabajadorMqdetDTO();
			datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
			datNominaTrabajadorDetDTO.setCeptoNominaId(conceptoNomina);
			datNominaTrabajadorDetDTO.setNombreTrabajador(codTrabajador);
			datNominaTrabajadorDetDTO.setNombreConceptoNomina(codConceptoNomina);
			datNominaTrabajadorDetDTO.setValorTotal(costoTotal);
			datNominaTrabajadorDetDTO.setCantidad(cantidad);
			datNominaTrabajadorDetDTO.setValorDeduccion(valorDeduccion);
			datNominaTrabajadorDetDTO.setTipoMovimiento(tipoMovimiento);
			datNominaTrabajadorDetDTO.setEquipoId(equipoId);
			datNominaTrabajadorDetDTO.setCodEquipo(codEquipo);
			datNominaTrabajadorDetDTO.setDetalleNota(detalleNota);
			datNominaTrabajadorDetDTO.setFechaFinalVac(fechaFinVac);
			datNominaTrabajadorDetDTO.setFechaInicialVac(fechaIniVac);
			datNominaTrabajadorDetDTO.setCentCostId_CentCost(centCostId);
			datNominaTrabajadorDetDTO.setNombreCentroCosto(nombreCentCost);
			dataNominaTrabajador.add(datNominaTrabajadorDetDTO);
			double subTotalValorTotal = 0;
			double impuestos = 0;
			double valorTotalDevengo = 0;
			double valorTotalDeduccion = 0;
			for (DatNominaTrabajadorMqdetDTO data1 : dataNominaTrabajador) {
				valorTotalDevengo += data1.getValorTotal().doubleValue();
				valorTotalDeduccion += data1.getValorDeduccion().doubleValue();
			}
			txtValorTotalAcumulado.setValue(valorTotalDevengo);
			txtValorTotalAcumuladoDeduccion.setValue(valorTotalDeduccion);

			detalleNota = null;
			codEquipo = null;
			equipoId = null;
			trabajador = null;
			conceptoNomina = null;
			codTrabajador = null;
			codConceptoNomina = null;
			costoTotal = null;
			tipoMovimiento = null;
			valorDeduccion = null;
			// udadMedId = null;
			// nombreUdadMed = null;
			cantidad = null;
			fechaFinVac = null;
			fechaIniVac = null;
			// dataDetProductos = null;
			limpiar_pantalla();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  trabajador, concepto, tipo movimiento tengan valores. "));
		}
	}

	public void listener_TipoNomina() throws Exception {
		Long compania = new Long(getCompaniaIdSession());
		Date fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
		Date fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
		String tipoNomina = "";
		if (txtTipoNomina.getValue() != null) {
			if (!txtTipoNomina.getValue().equals("")) {
				tipoNomina = txtTipoNomina.getValue().toString();

				if (tipoNomina.equals("Operativo")) {
					txtTipoNomina.setDisabled(true);

					List<ImportarNominaEmpAdmonDTO> dataAdmon = null;
					if (fechaInicial != null && fechaFinal != null) {
						dataAdmon = businessDelegator2View.pr_nomina_empleados_administrativos(compania, fechaInicial,
								fechaFinal, "Operativo");
						if (dataAdmon != null && dataAdmon.size() > 0) {
							for (int a = 0; a < dataAdmon.size(); a++) {

								ImportarNominaEmpAdmonDTO datos = dataAdmon.get(a);
								Long trabajadorId = datos.getIdTrabajador().longValue();
								Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

								Long conceptoNominaId = datos.getIdConceptoNomina().longValue();
								ConceptoNomina conceptoNomina = businessDelegatorView
										.getConceptoNomina(conceptoNominaId);
								String codTrabajador = trabajador.getNombre();
								String codConceptoNomina = conceptoNomina.getNombre();
								Double costoTotal = datos.getDevengo().doubleValue();
								Double valorDeduccion = datos.getDescuentos().doubleValue();
								String tipoMovimiento = datos.getTipoMovimiento();
								Double cantidad = 0.0;// FacesUtils.checkDouble(txtCantidad);
								String notas = datos.getNotas();
								Long idCentCost = null;
								String nombreCentCost = "";
								if (datos.getIdCentCost() != null) {
									idCentCost = datos.getIdCentCost().longValue();
									CentCost centCost = businessDelegatorView.getCentCost(idCentCost);
									nombreCentCost = centCost.getNombre();
								}
								
								Long idEquipo = null;
								String codEquipo = "";
								Equipo equipo = null;
								if (datos.getIdEquipo() != null && datos.getIdEquipo().longValue() != 0L) {
									idEquipo = datos.getIdEquipo().longValue();
									 equipo = businessDelegatorView.getEquipo(idEquipo);
									codEquipo = equipo.getCodigo();
								}
								
								
								if (dataNominaTrabajador == null) {
									dataNominaTrabajador = new ArrayList<DatNominaTrabajadorMqdetDTO>();

								}
								DatNominaTrabajadorMqdetDTO datNominaTrabajadorDetDTO = new DatNominaTrabajadorMqdetDTO();
								datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
								datNominaTrabajadorDetDTO.setCeptoNominaId(conceptoNomina);
								datNominaTrabajadorDetDTO.setNombreTrabajador(codTrabajador);
								datNominaTrabajadorDetDTO.setNombreConceptoNomina(codConceptoNomina);
								datNominaTrabajadorDetDTO.setValorTotal(costoTotal);
								datNominaTrabajadorDetDTO.setCantidad(cantidad);
								datNominaTrabajadorDetDTO.setValorDeduccion(valorDeduccion);
								datNominaTrabajadorDetDTO.setTipoMovimiento(tipoMovimiento);
								datNominaTrabajadorDetDTO.setDetalleNota(notas);
								datNominaTrabajadorDetDTO.setCentCostId_CentCost(idCentCost);
								datNominaTrabajadorDetDTO.setNombreCentroCosto(nombreCentCost);
								datNominaTrabajadorDetDTO.setCodEquipo(codEquipo);
								datNominaTrabajadorDetDTO.setEquipoId(idEquipo);
								
								dataNominaTrabajador.add(datNominaTrabajadorDetDTO);
								trabajador = null;
								conceptoNomina = null;
								codTrabajador = null;
								codConceptoNomina = null;
								costoTotal = null;
								tipoMovimiento = null;
								valorDeduccion = null;
								// udadMedId = null;
								// nombreUdadMed = null;
								cantidad = null;
								// dataDetProductos = null;
							}
							double subTotalValorTotal = 0;
							double impuestos = 0;
							double valorTotalDevengo = 0;
							double valorTotalDeduccion = 0;

							for (DatNominaTrabajadorMqdetDTO data1 : dataNominaTrabajador) {
								valorTotalDevengo += data1.getValorTotal().doubleValue();
								valorTotalDeduccion += data1.getValorDeduccion().doubleValue();
							}
							txtValorTotalAcumulado.setValue(valorTotalDevengo);
							txtValorTotalAcumuladoDeduccion.setValue(valorTotalDeduccion);

						}
						limpiar_pantalla();
						txtTipoNomina.setDisabled(true);
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Verifique que los campos fecha inicial y fecha final esten llenos "));
					}

				}
				if (tipoNomina.equals("Administrativo")) {
					txtEquipoId_Equipo.setDisabled(true);

					List<ImportarNominaEmpAdmonDTO> dataAdmon = null;
					if (fechaInicial != null && fechaFinal != null) {
						dataAdmon = businessDelegator2View.pr_nomina_empleados_administrativos(compania, fechaInicial,
								fechaFinal, "Administrativo");
						if (dataAdmon != null && dataAdmon.size() > 0) {
							for (int a = 0; a < dataAdmon.size(); a++) {

								ImportarNominaEmpAdmonDTO datos = dataAdmon.get(a);
								Long trabajadorId = datos.getIdTrabajador().longValue();
								Trabajador trabajador = businessDelegatorView.getTrabajador(trabajadorId);

								Long conceptoNominaId = datos.getIdConceptoNomina().longValue();
								ConceptoNomina conceptoNomina = businessDelegatorView
										.getConceptoNomina(conceptoNominaId);
								String codTrabajador = trabajador.getNombre();
								String codConceptoNomina = conceptoNomina.getNombre();
								Double costoTotal = datos.getDevengo().doubleValue();
								Double valorDeduccion = datos.getDescuentos().doubleValue();
								String tipoMovimiento = datos.getTipoMovimiento();
								Double cantidad = 0.0;// FacesUtils.checkDouble(txtCantidad);
								String notas = datos.getNotas();
								Long idCentCost = null;
								String nombreCentCost = "";
								if (datos.getIdCentCost() != null) {
									idCentCost = datos.getIdCentCost().longValue();
									CentCost centCost = businessDelegatorView.getCentCost(idCentCost);
									nombreCentCost = centCost.getNombre();
								}
								if (dataNominaTrabajador == null) {
									dataNominaTrabajador = new ArrayList<DatNominaTrabajadorMqdetDTO>();

								}
								DatNominaTrabajadorMqdetDTO datNominaTrabajadorDetDTO = new DatNominaTrabajadorMqdetDTO();
								datNominaTrabajadorDetDTO.setTrabId_Trabajador(trabajador);
								datNominaTrabajadorDetDTO.setCeptoNominaId(conceptoNomina);
								datNominaTrabajadorDetDTO.setNombreTrabajador(codTrabajador);
								datNominaTrabajadorDetDTO.setNombreConceptoNomina(codConceptoNomina);
								datNominaTrabajadorDetDTO.setValorTotal(costoTotal);
								datNominaTrabajadorDetDTO.setCantidad(cantidad);
								datNominaTrabajadorDetDTO.setValorDeduccion(valorDeduccion);
								datNominaTrabajadorDetDTO.setTipoMovimiento(tipoMovimiento);
								datNominaTrabajadorDetDTO.setDetalleNota(notas);
								datNominaTrabajadorDetDTO.setCentCostId_CentCost(idCentCost);
								datNominaTrabajadorDetDTO.setNombreCentroCosto(nombreCentCost);

								dataNominaTrabajador.add(datNominaTrabajadorDetDTO);
								trabajador = null;
								conceptoNomina = null;
								codTrabajador = null;
								codConceptoNomina = null;
								costoTotal = null;
								tipoMovimiento = null;
								valorDeduccion = null;
								// udadMedId = null;
								// nombreUdadMed = null;
								cantidad = null;
								// dataDetProductos = null;
							}
							double subTotalValorTotal = 0;
							double impuestos = 0;
							double valorTotalDevengo = 0;
							double valorTotalDeduccion = 0;

							for (DatNominaTrabajadorMqdetDTO data1 : dataNominaTrabajador) {
								valorTotalDevengo += data1.getValorTotal().doubleValue();
								valorTotalDeduccion += data1.getValorDeduccion().doubleValue();
							}
							txtValorTotalAcumulado.setValue(valorTotalDevengo);
							txtValorTotalAcumuladoDeduccion.setValue(valorTotalDeduccion);

						}
						limpiar_pantalla();
						txtTipoNomina.setDisabled(true);
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Verifique que los campos fecha inicial y fecha final esten llenos "));
					}
				}
			}

		}

	}

	public String actionDeleteDatNominaTrabajadorMqdet(ActionEvent evt) {
		try {

			selectedNominaTrabajadorMqdet = (DatNominaTrabajadorMqdetDTO) (evt.getComponent().getAttributes()
					.get("selectedNominaTrabajadorMqdet"));

			if (selectedNominaTrabajadorMqdet.getDatNominaTrabajadorMqdetId() == null) {
				dataNominaTrabajador.remove(selectedNominaTrabajadorMqdet);
			} else {
				Long detPlanillaNominaDetId = new Long(selectedNominaTrabajadorMqdet.getDatNominaTrabajadorMqdetId());
				DatNominaTrabajadorMqdet entity = businessDelegatorView
						.getDatNominaTrabajadorMqdet(detPlanillaNominaDetId);
				businessDelegatorView.deleteDatNominaTrabajadorMqdet(entity);
				dataNominaTrabajador.remove(selectedNominaTrabajadorMqdet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void listener_TipoMovimiento() {

		String tipoMovimiento = "";
		if (txtTipoMovimiento.getValue() != null) {
			if (!txtTipoMovimiento.getValue().equals("")) {
				tipoMovimiento = txtTipoMovimiento.getValue().toString();

				if (tipoMovimiento.equals("Devengo")) {
					txtValorTotal.setDisabled(false);
					txtEquipoId_Equipo.setDisabled(false);
					txtValorDeduccion.setDisabled(true);
				}
				if (tipoMovimiento.equals("Deduccion")) {
					txtValorTotal.setDisabled(true);
					txtEquipoId_Equipo.setDisabled(true);
					txtValorDeduccion.setDisabled(false);
				}

			}
		}
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
				Long id = new Long(selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId());
				entity = businessDelegatorView.getDatNominaTrabajadorMq(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatNominaTrabajadorMq(entity, dataNominaTrabajador);
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
		selectedDatNominaTrabajadorMq = (DatNominaTrabajadorMqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatNominaTrabajadorMq"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the txtUdadMed
	 */
	public SelectOneMenu getTxtUdadMed() {
		return txtUdadMed;
	}

	/**
	 * @param txtUdadMed the txtUdadMed to set
	 */
	public void setTxtUdadMed(SelectOneMenu txtUdadMed) {
		this.txtUdadMed = txtUdadMed;
	}

	/**
	 * @return the txtCantidad
	 */
	public Spinner getTxtCantidad() {
		return txtCantidad;
	}

	/**
	 * @param txtCantidad the txtCantidad to set
	 */
	public void setTxtCantidad(Spinner txtCantidad) {
		this.txtCantidad = txtCantidad;
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

	public void setselectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public InputNumber getTxtValorDeduccion() {
		return txtValorDeduccion;
	}

	public void setTxtValorDeduccion(InputNumber txtValorDeduccion) {
		this.txtValorDeduccion = txtValorDeduccion;
	}

	public InputNumber getTxtValorTotalAcumuladoDeduccion() {
		return txtValorTotalAcumuladoDeduccion;
	}

	public void setTxtValorTotalAcumuladoDeduccion(InputNumber txtValorTotalAcumuladoDeduccion) {
		this.txtValorTotalAcumuladoDeduccion = txtValorTotalAcumuladoDeduccion;
	}

	public void setTxtValorTotal(InputNumber txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public SelectOneMenu getTxtTipoMovimiento() {
		return txtTipoMovimiento;
	}

	public void setTxtTipoMovimiento(SelectOneMenu txtTipoMovimiento) {
		this.txtTipoMovimiento = txtTipoMovimiento;
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		// caso 1 : la tabla transaccional no tiene valores
		Long datNominaTrabajadormq = FacesUtils.checkLong(txtDatNominaTrabajadorMqId);
		if (datNominaTrabajadormq != null) {
			selectedNominaTrabajadorMqdet = (DatNominaTrabajadorMqdetDTO) (evt.getComponent().getAttributes()
					.get("selectedNominaTrabajadorMqdet"));
			if (selectedNominaTrabajadorMqdet.getDatNominaTrabajadorMqdetId() != null) {
				Long datNominaTrabajadormqdetId = selectedNominaTrabajadorMqdet.getDatNominaTrabajadorMqdetId()
						.longValue();

				String columnaCell = evt.getColumn().getHeaderText();

				Object oldValue = evt.getOldValue();
				Object newValue = evt.getNewValue();

				if (newValue != null) {

					entityDet = null;
					entityDet = businessDelegatorView.getDatNominaTrabajadorMqdet(datNominaTrabajadormqdetId);

					if (columnaCell.equals("VR. Devengo")) {

						entityDet.setValorTotal(Double.valueOf(evt.getNewValue().toString()));

					}
					if (columnaCell.equals("CeCos")) {

						Long ceCosId = new Long(evt.getNewValue().toString());
						CentCost centCost = businessDelegatorView.getCentCost(ceCosId);

						entityDet.setCentCost(centCost);

					}
					if (columnaCell.equals("Maq")) {

						Long maqId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(maqId);

						entityDet.setEquipoId(e);

					}

					if (columnaCell.equals("VR. Deducción")) {

						entityDet.setValorDeduccion(Double.valueOf(evt.getNewValue().toString()));

					}

					if (columnaCell.equals("Observación")) {

						entityDet.setDetalleNota(evt.getNewValue().toString());

					}

					if (columnaCell.equals("F. Ini. Vac")) {
						entityDet.setFechaInicialVac((Date) newValue);

					}

					if (columnaCell.equals("F. Fin. Vac")) {
						entityDet.setFechaFinalVac((Date) newValue);

					}

					entity = businessDelegatorView.getDatNominaTrabajadorMq(datNominaTrabajadormq);
					entityDet.setDatNominaTrabajadorMq(entity);
					businessDelegatorView.updateDatNominaTrabajadorMqdet(entityDet);

					// entity = null;

					selectedNominaTrabajadorMqdet = null;
					entityDet = null;

					dataNominaTrabajador = null;
					dataNominaTrabajador = businessDelegator2View
							.getDataDatNominaTrabajadorMqdetByNomina(datNominaTrabajadormq);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));

		}

	}

	public DatNominaTrabajadorMq getEntity() {
		return entity;
	}

	public void setEntity(DatNominaTrabajadorMq entity) {
		this.entity = entity;
	}

	public DatNominaTrabajadorMqdet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatNominaTrabajadorMqdet entityDet) {
		this.entityDet = entityDet;
	}

	public void limpiar_pantalla() {

		txtValorTotal.setValue(null);
		txtValorDeduccion.setValue(null);
		txtTipoMovimiento.setValue(null);
		txtCeptoNominaId_ConceptoNomina.setValue(null);
		txtEquipoId_Equipo.setValue(null);
		txtDetalleNota.setValue(null);
		txtFechaFinalVac.setValue(null);
		txtFechaInicialVac.setValue(null);
	}

	public Calendar getTxtFechaInicialVac() {
		return txtFechaInicialVac;
	}

	public Calendar getTxtFechaFinalVac() {
		return txtFechaFinalVac;
	}

	public void setTxtFechaInicialVac(Calendar txtFechaInicialVac) {
		this.txtFechaInicialVac = txtFechaInicialVac;
	}

	public void setTxtFechaFinalVac(Calendar txtFechaFinalVac) {
		this.txtFechaFinalVac = txtFechaFinalVac;
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

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputTextarea getTxtDetalleNota() {
		return txtDetalleNota;
	}

	public void setTxtDetalleNota(InputTextarea txtDetalleNota) {
		this.txtDetalleNota = txtDetalleNota;
	}

	public SelectOneMenu getTxtTipoNomina() {
		return txtTipoNomina;
	}

	public void setTxtTipoNomina(SelectOneMenu txtTipoNomina) {
		this.txtTipoNomina = txtTipoNomina;
	}

	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatNominaTrabajadorMq = (DatNominaTrabajadorMqDTO) (evt.getComponent().getAttributes()
				.get("selectedDatNominaTrabajadorMq"));

		try {

			Long id = selectedDatNominaTrabajadorMq.getDatNominaTrabajadorMqId();
			Object[] condicion = { "datNominaTrabajadorMqId", true, id, "=" };
			List<DatNominaTrabajadorMq> lista = (id != null)
					? businessDelegatorView.findByCriteriaInDatNominaTrabajadorMq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Object[] condicionEliminarDetalle = { "datNominaTrabajadorMq.datNominaTrabajadorMqId", true, id, "=" };
				List<DatNominaTrabajadorMqdet> listaDetalle = (id != null)
						? businessDelegatorView.findByCriteriaInDatNominaTrabajadorMqdet(condicionEliminarDetalle, null,
								null)
						: null;
				if (listaDetalle != null && listaDetalle.size() > 0) {
					for (DatNominaTrabajadorMqdet entidad : listaDetalle) {
						businessDelegatorView.deleteDatNominaTrabajadorMqdet(entidad);
					}

					Object[] condicionEliminarPpal = { "datNominaTrabajadorMqId", true, id, "=" };
					List<DatNominaTrabajadorMq> listaPpal = (id != null)
							? businessDelegatorView.findByCriteriaInDatNominaTrabajadorMq(condicionEliminarPpal, null,
									null)
							: null;
					if (listaPpal != null && listaPpal.size() > 0) {
						DatNominaTrabajadorMq entidadPpal = listaPpal.get(0);
						businessDelegatorView.deleteDatNominaTrabajadorMq(entidadPpal);
					}

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Proceso exitoso!", "El movimiento de incentivo fue eliminado exitosamente!!!"));
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existen datos para ser borrados", "Upps!"));
			}

		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public SelectItem[] getSelectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			try {

				// Criteria
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

	public void setselectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getSelectCentCostEdit() {

		if (selectCentCostEdit == null || selectCentCostEdit.length == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCostEdit = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCostEdit[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCostEdit;
	}

	public void setSelectCentCostEdit(SelectItem[] selectCentCostEdit) {
		this.selectCentCostEdit = selectCentCostEdit;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

}
