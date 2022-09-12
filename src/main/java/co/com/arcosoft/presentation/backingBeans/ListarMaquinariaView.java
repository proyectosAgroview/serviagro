package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.HorasMaquinaDetalladoDTO;
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
public class ListarMaquinariaView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarMaquinariaView.class);
	private InputText txtConsecutivo;
	private Calendar txtFechaRegistro;
	private InputTextarea txtObservacion;
	private InputText txtCantidadPago;
	private InputText txtValorUnitario;
	private CommandButton btnSave;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;	
	private boolean showDialog;
	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtCantidadAcumulado;
	private SelectOneMenu txtTipoDistribucion;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputText txtPlanilla;
	
	private InputNumber txtHorometroInicial;
	private InputNumber txtHorometroFinal;
	
	private HorasMaquinaDetalladoDTO selectDetalleServicio;
	private List<HorasMaquinaDetalladoDTO> dataDetalleServicio;
	private DatPlanillaNominaDet entityDet;

	private SelectOneMenu txtEquipo;
	SelectItem[] selectEquipo;

	private SelectOneMenu txtUdadMedPago;
	SelectItem[] selectUdadMedPago;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;

	private SelectOneMenu txtOrdenTrabajo;
	SelectItem[] selectOrdenTrabajo;
	
	private List<String> selectedTrabajador;
	private List<Trabajador> trabajadores;
	
	private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
	SelectItem[] selectCeptoNominaId;

	private SelectOneMenu txtTrabId_Trabajador;
	SelectItem[] selectTrabajador;
	
	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;

	public ListarMaquinariaView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		PrimeFaces.current().resetInputs(":dialogDatPlanillaNomina :frm");
		
		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtCantidadPago != null) {
			txtCantidadPago.setValue(0);
			txtCantidadPago.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			Date data = new Date();
			txtFechaRegistro.setValue(data);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtOrdenTrabajo != null) {
			txtOrdenTrabajo.setValue(null);
			txtOrdenTrabajo.setDisabled(false);
		}

		if (txtUdadMedPago != null) {
			txtUdadMedPago.setValue(null);
			txtUdadMedPago.setDisabled(false);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(0);
			txtValorUnitario.setDisabled(false);
		}

		if (txtEquipo != null) {
			txtEquipo.setValue(null);
			txtEquipo.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (txtHorometroInicial != null) {
			txtHorometroInicial.setValue(null);
			txtHorometroInicial.setDisabled(false);
		}

		if (txtHorometroFinal != null) {
			txtHorometroFinal.setValue(null);
			txtHorometroFinal.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}
		
		return "";
	}

	

	public String action_editMaquinaria(ActionEvent evt) {
		selectDetalleServicio = (HorasMaquinaDetalladoDTO) (evt.getComponent().getAttributes().get("selectDetalleServicio"));

		try {
			Long datPlanillaNominaDetId = selectDetalleServicio.getDatServicioDetId().longValue();
			Object[] condicion = { "detPlanillaNominaId", true, datPlanillaNominaDetId, "=" };
			List<DatPlanillaNominaDet> lista = (datPlanillaNominaDetId != null)
					? businessDelegatorView.findByCriteriaInDatPlanillaNominaDet(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {

				entityDet = lista.get(0);

				txtConsecutivo.setValue(selectDetalleServicio.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(selectDetalleServicio.getFechaRegistro());
				txtFechaRegistro.setDisabled(true);

				txtCantidadPago.setValue(entityDet.getCantidadPago());
				txtCantidadPago.setDisabled(false);

				txtValorUnitario.setValue(entityDet.getValorUnitario());
				txtValorUnitario.setDisabled(false);
				
				txtHorometroInicial.setValue(entityDet.getHorometroInicial());
				txtHorometroInicial.setDisabled(false);
				
				txtHorometroFinal.setValue(entityDet.getHorometroFinal());
				txtHorometroFinal.setDisabled(false);
				if(entityDet.getEquipoId()!=null) {
					txtEquipo.setValue(entityDet.getEquipoId().getEquipoId());
				}
				
				
				txtEquipo.setDisabled(false);
				
				if(entityDet.getImplementoId()!=null) {
					txtImplemento.setValue(entityDet.getImplementoId().getEquipoId());
				}
				txtImplemento.setDisabled(false);
				
				
				if (entityDet.getConceptoNomina() != null) {
					txtCeptoNominaId_ConceptoNomina.setValue(entityDet.getConceptoNomina().getCeptoNominaId());
				}
				txtCeptoNominaId_ConceptoNomina.setDisabled(false);	
				
				if (entityDet.getTrabajador() != null) {
					txtTrabId_Trabajador.setValue(entityDet.getTrabajador().getTrabId());
				}
				txtTrabId_Trabajador.setDisabled(false);
				

				txtUdadMedPago.setValue(entityDet.getUdadMedByUdadMedPago().getUdadMedId());
				txtUdadMedPago.setDisabled(false);

				txtNivel2Id.setValue(entityDet.getNivel2Id().getNivel2Id());
				txtNivel2Id.setDisabled(false);

				txtNivel4Id_Nivel4.setValue(entityDet.getNivel4().getNivel4Id());
				txtNivel4Id_Nivel4.setDisabled(false);

			/*	if (entityDet.getNivel4() != null) {
					Nivel4 nivel4 = businessDelegatorView.getNivel4(entityDet.getNivel4().getNivel4Id());
					Long idNivel3 = nivel4.getNivel3().getNivel3Id();
					txtNivel3Id.setValue(idNivel3);
				}
				txtNivel3Id.setDisabled(false);*/

				txtLaborId_Labor.setValue(entityDet.getLaborId().getLaborId());
				txtLaborId_Labor.setDisabled(false);

				if (entityDet.getOrdenTrabajo() != null) {
					txtOrdenTrabajo.setValue(entityDet.getOrdenTrabajo().getPlanLaborDetId());
				}
				txtOrdenTrabajo.setDisabled(false);

				btnSave.setDisabled(false);
				setShowDialog(true);
			}

		} catch (Exception e) {
			entityDet = null;
		}
		return "";
	}

	public void listarMaquinaria() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long numeroPlanilla = FacesUtils.checkLong(txtPlanilla);
			if (numeroPlanilla == null) {
				numeroPlanilla = 0L;
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && fechaInicial != null && fechaFinal != null) {

				dataDetalleServicio = businessDelegatorView.consultarInformeHorasMaquinaDetallado(compania, 
						fechaInicial, fechaFinal, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0",
						1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, numeroPlanilla);

			} else if (compania != null && fechaInicial == null && fechaFinal == null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				dataDetalleServicio = businessDelegatorView.consultarInformeHorasMaquinaDetallado(compania, 
						fechaInicial, fechaFinal, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0",
						1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, numeroPlanilla);
			}

			double totalUnidades = 0;
			double totalCosto = 0;
			if (dataDetalleServicio != null && dataDetalleServicio.size() >= 0) {
				for (HorasMaquinaDetalladoDTO data1 : dataDetalleServicio) {
					totalUnidades += data1.getCantidadPago().doubleValue();
					totalCosto += data1.getCostoTotal().doubleValue();
				}
			}

			txtValorTotalAcumulado.setValue(totalCosto);
			txtCantidadAcumulado.setValue(totalUnidades);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String action_ActualizarDetalle() {
		try {

			if (entityDet == null) {
				Long DatPlanillaNominaDetId = new Long(selectDetalleServicio.getDatServicioDetId().longValue());
				entityDet = businessDelegatorView.getDatPlanillaNominaDet(DatPlanillaNominaDetId);
			}

			entityDet.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id))
					: null);
			entityDet.setOrdenTrabajo((FacesUtils.checkLong(txtOrdenTrabajo) != null)
					? businessDelegatorView.getDatPlanLaborDet(FacesUtils.checkLong(txtOrdenTrabajo))
					: null);
			entityDet.setLaborId((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entityDet.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4))
					: null);
			entityDet.setEquipoId((FacesUtils.checkLong(txtEquipo) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipo))
					: null);
			entityDet.setUdadMedByUdadMedPago((FacesUtils.checkLong(txtUdadMedPago) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedPago))
					: null);

			entityDet.setCantidadPago(FacesUtils.checkDouble(txtCantidadPago));
			entityDet.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			
			Double cantidad = FacesUtils.checkDouble(txtCantidadPago);
			Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
			Double costoTotal = cantidad * valorUnitario;
			costoTotal = (double) Math.round((costoTotal) * 10) / 10;

			entityDet.setCostoTotal(costoTotal);
			
			entityDet.setHorometroInicial(FacesUtils.checkDouble(txtHorometroInicial));
			entityDet.setHorometroFinal(FacesUtils.checkDouble(txtHorometroFinal));
			
			Double horaIni = FacesUtils.checkDouble(txtHorometroInicial);
			Double horaFin = FacesUtils.checkDouble(txtHorometroFinal);
			Double horasTotales = horaFin - horaIni;
			horasTotales = (double) Math.round((horasTotales) * 10) / 10;
			
			entityDet.setHorometroTotal(horasTotales);
			entityDet.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId_Trabajador))
					: null);
			entityDet.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina))
					: null);

			businessDelegatorView.updateDatPlanillaNominaDet(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			action_clear();
			listarMaquinaria();

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

	public void listener_ConsultaOrdenTrabajo() {

		Long planLaborDetId = null;
		if (txtOrdenTrabajo.getValue() != null) {
			planLaborDetId = Long.parseLong(txtOrdenTrabajo.getValue().toString());
			try {

				Long idCompania = new Long(getCompaniaIdSession());

				List<ConsultaOrdenTrabajoDesDTO> dataU = businessDelegatorView
						.consultarOrdenTrabajoEjecucionLabores(idCompania, planLaborDetId);

				if (dataU != null && dataU.size() > 0) {
					ConsultaOrdenTrabajoDesDTO entity1 = dataU.get(0);
					txtLaborId_Labor.setValue(entity1.getLaborId().longValue());
					txtNivel2Id.setValue(entity1.getNivel2Id().longValue());
					txtNivel3Id.setValue(entity1.getNivel3Id().longValue());
					txtNivel4Id_Nivel4.setValue(entity1.getNivel4Id().longValue());
					txtNivel4Id_Nivel4.setDisabled(false);
					txtTipoDistribucion.setDisabled(true);
					txtTipoDistribucion.setValue("lote");

					txtUdadMedPago.setValue(entity1.getUmId().longValue());
					txtCantidadPago.setValue(entity1.getCantidadPlanId());

				}
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaNombreLaborMo() {
		Long laborId = null;
		if (!txtLaborId_Labor.getValue().equals("")) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				if (labor.getUdadMedByUdadMedPago().getUdadMedId() != null) {
					txtUdadMedPago.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public SelectItem[] getSelectEquipo() {

		if (selectEquipo == null || selectEquipo.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(), equipo.getNombre());
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

	public SelectItem[] getSelectUdadMedPago() {

		if (selectUdadMedPago == null || selectUdadMedPago.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedPago = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMedPago : lista) {
					selectUdadMedPago[i] = new SelectItem(udadMedPago.getUdadMedId(), udadMedPago.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedPago;
	}

	public void setSelectUdadMedPago(SelectItem[] selectUdadMedPago) {
		this.selectUdadMedPago = selectUdadMedPago;
	}

	public SelectItem[] getSelectNivel2() {

		if (selectNivel2 == null || selectNivel2.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2 : lista) {
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2;
	}

	public void setSelectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	public SelectItem[] getSelectNivel3() {

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
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(),
							nivel4.getNombre() + '-' + "Área: " + nivel4.getAreaNeta().toString());
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

	public SelectItem[] getSelectOrdenTrabajo() {

		if (selectOrdenTrabajo == null || selectOrdenTrabajo.length == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Compania compania = businessDelegatorView.getCompania(idCompania);
				List<ConsultaOrdenTrabajoDesDTO> listaOrdenenTrabajo = null;
				
				if (compania.getNivelAutorizaLabor() != null) {
					if (compania.getNivelAutorizaLabor().equals("SI")) {
						listaOrdenenTrabajo = businessDelegatorView.consultarOrdenTrabajoDesAprobacion(idCompania);
					} else {
						listaOrdenenTrabajo = businessDelegatorView.consultarOrdenTrabajoDes(idCompania);
					}
				}
				
				if (listaOrdenenTrabajo != null) {
					selectOrdenTrabajo = new SelectItem[listaOrdenenTrabajo.size()];

					int i = 0;
					for (ConsultaOrdenTrabajoDesDTO consultaOrdenTrabajoDesDTO : listaOrdenenTrabajo) {
						selectOrdenTrabajo[i] = new SelectItem(consultaOrdenTrabajoDesDTO.getPlanLaborId(),
								consultaOrdenTrabajoDesDTO.getDescripcion());
						i++;
					}
				}
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectOrdenTrabajo;
	}

	public void setSelectOrdenTrabajo(SelectItem[] selectOrdenTrabajo) {
		this.selectOrdenTrabajo = selectOrdenTrabajo;
	}

	public List<String> getSelectedTrabajador() {
		return selectedTrabajador;
	}

	public void setSelectedTrabajador(List<String> selectedTrabajador) {
		this.selectedTrabajador = selectedTrabajador;
	}

	public List<Trabajador> getTrabajadores() {

		if (trabajadores == null || trabajadores.size() == 0) {

			try {
				trabajadores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return trabajadores;
	}

	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public InputText getTxtConsecutivo() {
		return txtConsecutivo;
	}

	public void setTxtConsecutivo(InputText txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputText getTxtCantidadPago() {
		return txtCantidadPago;
	}

	public void setTxtCantidadPago(InputText txtCantidadPago) {
		this.txtCantidadPago = txtCantidadPago;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public InputNumber getTxtCantidadAcumulado() {
		return txtCantidadAcumulado;
	}

	public void setTxtCantidadAcumulado(InputNumber txtCantidadAcumulado) {
		this.txtCantidadAcumulado = txtCantidadAcumulado;
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

	public InputText getTxtPlanilla() {
		return txtPlanilla;
	}

	public void setTxtPlanilla(InputText txtPlanilla) {
		this.txtPlanilla = txtPlanilla;
	}

	public SelectOneMenu getTxtUdadMedPago() {
		return txtUdadMedPago;
	}

	public void setTxtUdadMedPago(SelectOneMenu txtUdadMedPago) {
		this.txtUdadMedPago = txtUdadMedPago;
	}

	public SelectOneMenu getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(SelectOneMenu txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
	}

	public SelectOneMenu getTxtNivel4Id_Nivel4() {
		return txtNivel4Id_Nivel4;
	}

	public void setTxtNivel4Id_Nivel4(SelectOneMenu txtNivel4Id_Nivel4) {
		this.txtNivel4Id_Nivel4 = txtNivel4Id_Nivel4;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtOrdenTrabajo() {
		return txtOrdenTrabajo;
	}

	public void setTxtOrdenTrabajo(SelectOneMenu txtOrdenTrabajo) {
		this.txtOrdenTrabajo = txtOrdenTrabajo;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public SelectOneMenu getTxtTipoDistribucion() {
		return txtTipoDistribucion;
	}

	public void setTxtTipoDistribucion(SelectOneMenu txtTipoDistribucion) {
		this.txtTipoDistribucion = txtTipoDistribucion;
	}

	public InputNumber getTxtHorometroInicial() {
		return txtHorometroInicial;
	}

	public void setTxtHorometroInicial(InputNumber txtHorometroInicial) {
		this.txtHorometroInicial = txtHorometroInicial;
	}

	public InputNumber getTxtHorometroFinal() {
		return txtHorometroFinal;
	}

	public void setTxtHorometroFinal(InputNumber txtHorometroFinal) {
		this.txtHorometroFinal = txtHorometroFinal;
	}

	public List<HorasMaquinaDetalladoDTO> getDataDetalleServicio() {
		return dataDetalleServicio;
	}

	public void setDataDetalleServicio(List<HorasMaquinaDetalladoDTO> dataDetalleServicio) {
		this.dataDetalleServicio = dataDetalleServicio;
	}

	public SelectOneMenu getTxtEquipo() {
		return txtEquipo;
	}

	public void setTxtEquipo(SelectOneMenu txtEquipo) {
		this.txtEquipo = txtEquipo;
	}
	

	public void ConsultarSalario() throws Exception {

		Long trabId = Long.parseLong(txtTrabId_Trabajador.getValue().toString());
		Long idCeptoNomina = FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina);

		Trabajador trabajador = businessDelegatorView.getTrabajador(trabId);
		ConceptoNomina concepto = businessDelegatorView.getConceptoNomina(idCeptoNomina);
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Date fecharegistro = FacesUtils.checkDate(txtFechaRegistro);
		Double tarifa = 0.0;
		Double valorSalario =0.0;
		Double factorPrestacional =1.0;
		if(concepto.getFactorPrestacional()!=null) {
			factorPrestacional= concepto.getFactorPrestacional();
		}
		if(trabajador.getSalario()==null) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine interprete = manager.getEngineByName("js");
		Bindings scope = interprete.createBindings();
		String result = null;
		String consulta = "select valor_deduccion from tarifa_otros_devengos where :fecha between fecha_inicial and fecha_final and trab_id = :trabid and \r\n"
				+ "concepto_nomina_id = :ceptoid";

		// La clase Spring con la Connection
		// JdbcTemplate jdbcTemplate = new
		// JdbcTemplate(DriverManagerDataSourceUtils.getDatasource());
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DriverManagerDataSourceUtils.getDatasource());

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("trabid", trabId);
		parameters.addValue("ceptoid", idCeptoNomina);
		parameters.addValue("fecha", fecharegistro);

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

		result = namedParameterJdbcTemplate.query(consulta, parameters, extr);
		if (result == null) {
			tarifa = 0.0;
		} else {
			tarifa = Double.parseDouble(result);
		}

		String format = decimalFormat.format(tarifa);
		
		txtValorUnitario.setValue(format);
		}else {
			valorSalario=trabajador.getSalario();
			tarifa = (valorSalario/240) *factorPrestacional;
			tarifa = (double) Math.round((tarifa) * 100) / 100;
			txtValorUnitario.setValue(tarifa);
		}

	}

	


	public SelectItem[] getSelectCeptoNominaId() {

		if (selectCeptoNominaId == null || selectCeptoNominaId.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
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

	public void setSelectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

	public SelectItem[] getSelectTrabajador() {

		if (selectTrabajador == null || selectTrabajador.length == 0) {
			try {

				Object[] condicion = { "estado", true, "A", "=" };
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

	public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
		return txtCeptoNominaId_ConceptoNomina;
	}

	public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
		this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
	}

	public SelectOneMenu getTxtTrabId_Trabajador() {
		return txtTrabId_Trabajador;
	}

	public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
		this.txtTrabId_Trabajador = txtTrabId_Trabajador;
	}
	public void limpiarConceptoNomina() {
		txtCeptoNominaId_ConceptoNomina.setValue(null);
	}
	

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	public SelectItem[] getSelectImplemento() {

		if (implemento == null || implemento.size() == 0) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" 
						, "categoriaEquipo.funcion", true, "Implemento", "="
									};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo Implemento : lista) {
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(), Implemento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectImplemento;
	}

	public void setSelectImplemento(SelectItem[] selectImplemento) {
		this.selectImplemento = selectImplemento;
	}
}