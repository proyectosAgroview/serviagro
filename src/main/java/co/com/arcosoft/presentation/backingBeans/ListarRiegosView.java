package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.SistemaRiego;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.TurnoCampo;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.DisponibilidadHidricaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ListarRiegosView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarRiegosView.class);
	private InputText txtConsecutivo;
	private Calendar txtFechaRegistro;
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
	
	private InputNumber txtNumeroRiegos;
	private InputNumber txtTotalAreaRegada;
	private InputNumber txtCaudalNivel4;
	private InputNumber txtHorometroInicalR;
	private InputNumber txtHorometroFinalR;
	private InputNumber txtVolTotalNivel4;
	
	//Calculo interno de las horas totales
	
	private DisponibilidadHidricaDTO selectDetalleRiegos;
	private List<DisponibilidadHidricaDTO> dataDetalleRiegos;
	private DatRiego entityDet;

	private SelectOneMenu txtTrabajador;
	SelectItem[] selectTrabajador;
	
	private SelectOneMenu txtTurnoCampo;
	SelectItem[] selectTurnoCampo;
	
	private SelectOneMenu txtSistemaRiego;
	SelectItem[] selectSistemaRiego;

	private SelectOneMenu txtInfraestructura;
	SelectItem[] selectInfraestructura;

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

	public ListarRiegosView() {
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

		if (txtOrdenTrabajo != null) {
			txtOrdenTrabajo.setValue(null);
			txtOrdenTrabajo.setDisabled(false);
		}

		if (txtTrabajador != null) {
			txtTrabajador.setValue(null);
			txtTrabajador.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtTurnoCampo != null) {
			txtTurnoCampo.setValue(null);
			txtTurnoCampo.setDisabled(false);
		}

		if (txtSistemaRiego != null) {
			txtSistemaRiego.setValue(null);
			txtSistemaRiego.setDisabled(false);
		}

		if (txtInfraestructura != null) {
			txtInfraestructura.setValue(null);
			txtInfraestructura.setDisabled(false);
		}

		if (txtNumeroRiegos != null) {
			txtNumeroRiegos.setValue(null);
			txtNumeroRiegos.setDisabled(false);
		}

		if (txtTotalAreaRegada != null) {
			txtTotalAreaRegada.setValue(null);
			txtTotalAreaRegada.setDisabled(false);
		}

		if (txtCaudalNivel4 != null) {
			txtCaudalNivel4.setValue(null);
			txtCaudalNivel4.setDisabled(false);
		}

		if (txtHorometroInicalR != null) {
			txtHorometroInicalR.setValue(null);
			txtHorometroInicalR.setDisabled(false);
		}

		if (txtHorometroFinalR != null) {
			txtHorometroFinalR.setValue(null);
			txtHorometroFinalR.setDisabled(false);
		}

		if (txtVolTotalNivel4 != null) {
			txtVolTotalNivel4.setValue(null);
			txtVolTotalNivel4.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}
		
		return "";
	}

	public String actionDeleteDatRiego(ActionEvent evt) {
		try {
			selectDetalleRiegos = (DisponibilidadHidricaDTO) (evt.getComponent().getAttributes()
					.get("selectDetalleRiegos"));
			
			DatRiego entityDet = new DatRiego();
			Long datRiegoId = new Long(selectDetalleRiegos.getDatRiegoId().longValue());
			entityDet = businessDelegatorView.getDatRiego(datRiegoId);
			businessDelegatorView.deleteDatRiego(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			listarRiegosAgricolas();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_editRiegos(ActionEvent evt) {
		selectDetalleRiegos = (DisponibilidadHidricaDTO) (evt.getComponent().getAttributes()
				.get("selectDetalleRiegos"));

		try {
			Long datRiegoId = selectDetalleRiegos.getDatRiegoId().longValue();
			Object[] condicion = { "datRiegoId", true, datRiegoId, "=" };
			List<DatRiego> lista = (datRiegoId != null)
					? businessDelegatorView.findByCriteriaInDatRiego(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {

				entityDet = lista.get(0);

				txtConsecutivo.setValue(selectDetalleRiegos.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(selectDetalleRiegos.getFecha());
				txtFechaRegistro.setDisabled(true);
				
				txtNumeroRiegos.setValue(entityDet.getNumeroRiegos());
				txtNumeroRiegos.setDisabled(false);				
				txtTotalAreaRegada.setValue(entityDet.getTotalAreaRegada());
				txtTotalAreaRegada.setDisabled(false);				
				txtCaudalNivel4.setValue(entityDet.getCaudalNivel4());
				txtCaudalNivel4.setDisabled(false);				
				txtHorometroInicalR.setValue(entityDet.getHorometroInicial());
				txtHorometroInicalR.setDisabled(false);				
				txtHorometroFinalR.setValue(entityDet.getHorometroFinal());
				txtHorometroFinalR.setDisabled(false);				
				txtVolTotalNivel4.setValue(entityDet.getVolTotalNivel4());
				txtVolTotalNivel4.setDisabled(false);

				txtTurnoCampo.setValue(entityDet.getTurnoCampo().getTurnoCampoId());
				txtTurnoCampo.setDisabled(false);
				txtTrabajador.setValue(entityDet.getTrabajador().getTrabId());
				txtTrabajador.setDisabled(false);				
				txtSistemaRiego.setValue(entityDet.getSistemaRiego().getSistemaRiegoId());
				txtSistemaRiego.setDisabled(false);
				txtInfraestructura.setValue(entityDet.getInfraestructura().getInfraId());
				txtInfraestructura.setDisabled(false);
				txtNivel2Id.setValue(entityDet.getNivel2Id().getNivel2Id());
				txtNivel2Id.setDisabled(false);
				txtNivel4Id_Nivel4.setValue(entityDet.getNivel4().getNivel4Id());
				txtNivel4Id_Nivel4.setDisabled(false);

				if (entityDet.getNivel4() != null) {
					Nivel4 nivel4 = businessDelegatorView.getNivel4(entityDet.getNivel4().getNivel4Id());
					Long idNivel3 = nivel4.getNivel3().getNivel3Id();
					txtNivel3Id.setValue(idNivel3);
				}
				txtNivel3Id.setDisabled(false);

				txtLaborId_Labor.setValue(entityDet.getLabor().getLaborId());
				txtLaborId_Labor.setDisabled(false);

				txtOrdenTrabajo.setDisabled(false);
				if (entityDet.getOrdenTrabajo() != null) {
					txtOrdenTrabajo.setValue(entityDet.getOrdenTrabajo().getPlanLaborDetId());
				}

				btnSave.setDisabled(false);
				setShowDialog(true);
			}

		} catch (Exception e) {
			entityDet = null;
		}
		return "";
	}

	public void listarRiegosAgricolas() {
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

				dataDetalleRiegos = businessDelegatorView.consultarInformeDisponibilidadHidrica(compania, fechaInicial, fechaFinal,
						"0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, numeroPlanilla);

			} else if (compania != null && fechaInicial == null && fechaFinal == null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				dataDetalleRiegos = businessDelegatorView.consultarInformeDisponibilidadHidrica(compania, fechaInicial, fechaFinal,
						"0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, numeroPlanilla);
			}

			double totalUnidades = 0;
			double totalCosto = 0;
			if (dataDetalleRiegos != null && dataDetalleRiegos.size() >= 0) {
				for (DisponibilidadHidricaDTO data1 : dataDetalleRiegos) {
					totalUnidades += data1.getAreaRegada().doubleValue();
					totalCosto += data1.getTotalHorometro().doubleValue();
				}
			}

			txtValorTotalAcumulado.setValue(totalCosto);
			txtCantidadAcumulado.setValue(totalUnidades);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String action_ActualizarRiegos() {
		try {

			if (entityDet == null) {
				Long datRiegoId = new Long(selectDetalleRiegos.getDatRiegoId().longValue());
				entityDet = businessDelegatorView.getDatRiego(datRiegoId);
			}

			entityDet.setNivel2Id((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id))
					: null);
			entityDet.setOrdenTrabajo((FacesUtils.checkLong(txtOrdenTrabajo) != null)
					? businessDelegatorView.getDatPlanLaborDet(FacesUtils.checkLong(txtOrdenTrabajo))
					: null);
			entityDet.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entityDet.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4))
					: null);			
			entityDet.setTrabajador((FacesUtils.checkLong(txtTrabajador) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabajador))
					: null);			
			entityDet.setTurnoCampo((FacesUtils.checkLong(txtTurnoCampo) != null)
					? businessDelegatorView.getTurnoCampo(FacesUtils.checkLong(txtTurnoCampo))
					: null);
			entityDet.setSistemaRiego((FacesUtils.checkLong(txtSistemaRiego) != null)
					? businessDelegatorView.getSistemaRiego(FacesUtils.checkLong(txtSistemaRiego))
					: null);
			entityDet.setInfraestructura((FacesUtils.checkLong(txtInfraestructura) != null)
					? businessDelegatorView.getInfraestructura(FacesUtils.checkLong(txtInfraestructura))
					: null);

			entityDet.setNumeroRiegos(FacesUtils.checkDouble(txtNumeroRiegos));
			entityDet.setTotalAreaRegada(FacesUtils.checkDouble(txtTotalAreaRegada));
			entityDet.setCaudalNivel4(FacesUtils.checkDouble(txtCaudalNivel4));
			entityDet.setHorometroInicial(FacesUtils.checkDouble(txtHorometroInicalR));
			entityDet.setHorometroFinal(FacesUtils.checkDouble(txtHorometroFinalR));
			entityDet.setVolTotalNivel4(FacesUtils.checkDouble(txtVolTotalNivel4));
			
			Double horInicial = FacesUtils.checkDouble(txtHorometroInicalR);
			Double horFinal = FacesUtils.checkDouble(txtHorometroFinalR);
			Double horTotal = horFinal * horInicial;
			horTotal = (double) Math.round((horTotal) * 10) / 10;

			entityDet.setHoraTotalNivel4(horTotal);

			businessDelegatorView.updateDatRiego(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			action_clear();
			listarRiegosAgricolas();

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
					
					Nivel4 nivel4 = businessDelegatorView.getNivel4(entity1.getNivel4Id().longValue());
					txtTotalAreaRegada.setValue(nivel4.getAreaNeta());
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

	public SelectItem[] getSelectTurnoCampo() {

		if (selectTurnoCampo == null || selectTurnoCampo.length == 0) {
			
			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<TurnoCampo> lista = businessDelegatorView.findByCriteriaInTurnoCampo(condicion, null, null);
				selectTurnoCampo = new SelectItem[lista.size()];

				int i = 0;
				for (TurnoCampo turnoCampo : lista) {
					selectTurnoCampo[i] = new SelectItem(turnoCampo.getTurnoCampoId(), turnoCampo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTurnoCampo;
	}

	public void setSelectTurnoCampo(SelectItem[] selectTurnoCampo) {
		this.selectTurnoCampo = selectTurnoCampo;
	}

	public SelectItem[] getSelectSistemaRiego() {

		if (selectSistemaRiego == null || selectSistemaRiego.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<SistemaRiego> lista = businessDelegatorView.findByCriteriaInSistemaRiego(condicion, null, null);
				selectSistemaRiego = new SelectItem[lista.size()];

				int i = 0;
				for (SistemaRiego sistemaRiego : lista) {
					selectSistemaRiego[i] = new SelectItem(sistemaRiego.getSistemaRiegoId(), sistemaRiego.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSistemaRiego;
	}

	public void setSelectSistemaRiego(SelectItem[] selectSistemaRiego) {
		this.selectSistemaRiego = selectSistemaRiego;
	}

	public SelectItem[] getSelectInfraestructura() {

		if (selectInfraestructura == null || selectInfraestructura.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Infraestructura> lista = businessDelegatorView.findByCriteriaInInfraestructura(condicion, null, null);
				selectInfraestructura = new SelectItem[lista.size()];

				int i = 0;
				for (Infraestructura infraestructura : lista) {
					selectInfraestructura[i] = new SelectItem(infraestructura.getInfraId(), infraestructura.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectInfraestructura;
	}

	public void setSelectInfraestructura(SelectItem[] selectInfraestructura) {
		this.selectInfraestructura = selectInfraestructura;
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

	public List<DisponibilidadHidricaDTO> getDataDetalleRiegos() {
		return dataDetalleRiegos;
	}

	public void setDataDetalleRiegos(List<DisponibilidadHidricaDTO> dataDetalleRiegos) {
		this.dataDetalleRiegos = dataDetalleRiegos;
	}

	public InputNumber getTxtNumeroRiegos() {
		return txtNumeroRiegos;
	}

	public void setTxtNumeroRiegos(InputNumber txtNumeroRiegos) {
		this.txtNumeroRiegos = txtNumeroRiegos;
	}

	public InputNumber getTxtTotalAreaRegada() {
		return txtTotalAreaRegada;
	}

	public void setTxtTotalAreaRegada(InputNumber txtTotalAreaRegada) {
		this.txtTotalAreaRegada = txtTotalAreaRegada;
	}

	public InputNumber getTxtCaudalNivel4() {
		return txtCaudalNivel4;
	}

	public void setTxtCaudalNivel4(InputNumber txtCaudalNivel4) {
		this.txtCaudalNivel4 = txtCaudalNivel4;
	}

	public InputNumber getTxtHorometroInicalR() {
		return txtHorometroInicalR;
	}

	public void setTxtHorometroInicalR(InputNumber txtHorometroInicalR) {
		this.txtHorometroInicalR = txtHorometroInicalR;
	}

	public InputNumber getTxtHorometroFinalR() {
		return txtHorometroFinalR;
	}

	public void setTxtHorometroFinalR(InputNumber txtHorometroFinalR) {
		this.txtHorometroFinalR = txtHorometroFinalR;
	}

	public InputNumber getTxtVolTotalNivel4() {
		return txtVolTotalNivel4;
	}

	public void setTxtVolTotalNivel4(InputNumber txtVolTotalNivel4) {
		this.txtVolTotalNivel4 = txtVolTotalNivel4;
	}

	public SelectOneMenu getTxtTrabajador() {
		return txtTrabajador;
	}

	public void setTxtTrabajador(SelectOneMenu txtTrabajador) {
		this.txtTrabajador = txtTrabajador;
	}

	public SelectOneMenu getTxtTurnoCampo() {
		return txtTurnoCampo;
	}

	public void setTxtTurnoCampo(SelectOneMenu txtTurnoCampo) {
		this.txtTurnoCampo = txtTurnoCampo;
	}

	public SelectOneMenu getTxtSistemaRiego() {
		return txtSistemaRiego;
	}

	public void setTxtSistemaRiego(SelectOneMenu txtSistemaRiego) {
		this.txtSistemaRiego = txtSistemaRiego;
	}

	public SelectOneMenu getTxtInfraestructura() {
		return txtInfraestructura;
	}

	public void setTxtInfraestructura(SelectOneMenu txtInfraestructura) {
		this.txtInfraestructura = txtInfraestructura;
	}
}