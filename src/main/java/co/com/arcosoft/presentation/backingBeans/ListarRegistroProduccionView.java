package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.DatTransProdNivel4;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaProduccionDTO;
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
public class ListarRegistroProduccionView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarRegistroProduccionView.class);
	private InputText txtConsecutivo;
	private Calendar txtFechaIniCosecha;
	private Calendar txtFechaFinCosecha;

	private SelectOneMenu txtNivel2Id;
	SelectItem[] selectNivel2;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;

	private List<String> selectedHacienda;
	private List<Nivel2> haciendas;

	private List<String> selectedLote;
	private List<Nivel4> lotes;

	private InputText txtCantidadCosechada;
	private InputText txtKilogramosAzucarToneladas;
	private InputText txtValorKilogramosAzucar;
	private InputText txtValorUnitarioCosecha;
	private InputNumber txtIngresoBruto;
	private InputText txtPorcRendimiento;

	private InputNumber txtAjusteLiquidacion;
	private InputNumber txtBonificion;
	private InputNumber txtOtrosIngresos;
	private InputNumber txtRetenciones;
	private InputNumber txtDescuentos;
	
	private InputNumber txtEdadNivel4;
	private SelectOneRadio txtFinCosecha;

	private InputNumber txtPlanilla;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	
	private InputText txtAreaCosechada;
	private SelectOneMenu txtEtapaNivel4;
	SelectItem[] selectItemEtapa;
	private List<Etapa> etapa;

	private SelectOneMenu txtVariedNivel4;
	SelectItem[] selectItemVariedad;
	private List<Variedad> variedad;
	
	private ListaProduccionDTO selectDetalle;
	private List<ListaProduccionDTO> dataDetalle;
	private DatTransProdNivel4 entityDet;
	private CommandButton btnSave;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	private boolean showDialog;
	
	
	
	SelectItem[] selectLote;

	public ListarRegistroProduccionView() {
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
		if (txtAreaCosechada != null) {
			txtAreaCosechada.setValue(null);
			txtAreaCosechada.setDisabled(false);
		}
		if (txtVariedNivel4 != null) {
			txtVariedNivel4.setValue(null);
			txtVariedNivel4.setDisabled(false);
		}
		if (txtEtapaNivel4 != null) {
			txtEtapaNivel4.setValue(null);
			txtEtapaNivel4.setDisabled(false);
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
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (txtFechaIniCosecha != null) {
			txtFechaIniCosecha.setValue(null);
			txtFechaIniCosecha.setDisabled(false);
		}

		if (txtFechaFinCosecha != null) {
			txtFechaFinCosecha.setValue(null);
			txtFechaFinCosecha.setDisabled(false);
		}

		if (txtCantidadCosechada != null) {
			txtCantidadCosechada.setValue(null);
			txtCantidadCosechada.setDisabled(false);
		}

		if (txtKilogramosAzucarToneladas != null) {
			txtKilogramosAzucarToneladas.setValue(null);
			txtKilogramosAzucarToneladas.setDisabled(false);
		}

		if (txtValorKilogramosAzucar != null) {
			txtValorKilogramosAzucar.setValue(null);
			txtValorKilogramosAzucar.setDisabled(false);
		}

		if (txtValorUnitarioCosecha != null) {
			txtValorUnitarioCosecha.setValue(null);
			txtValorUnitarioCosecha.setDisabled(false);
		}

		if (txtIngresoBruto != null) {
			txtIngresoBruto.setValue(null);
			txtIngresoBruto.setDisabled(false);
		}

		if (txtPorcRendimiento != null) {
			txtPorcRendimiento.setValue(null);
			txtPorcRendimiento.setDisabled(false);
		}

		if (txtAjusteLiquidacion != null) {
			txtAjusteLiquidacion.setValue(null);
			txtAjusteLiquidacion.setDisabled(false);
		}

		if (txtBonificion != null) {
			txtBonificion.setValue(null);
			txtBonificion.setDisabled(false);
		}

		if (txtOtrosIngresos != null) {
			txtOtrosIngresos.setValue(null);
			txtOtrosIngresos.setDisabled(false);
		}

		if (txtRetenciones != null) {
			txtRetenciones.setValue(null);
			txtRetenciones.setDisabled(false);
		}

		if (txtDescuentos != null) {
			txtDescuentos.setValue(null);
			txtDescuentos.setDisabled(false);
		}

		if (txtEdadNivel4 != null) {
			txtEdadNivel4.setValue(null);
			txtEdadNivel4.setDisabled(false);
		}

		if (txtFinCosecha != null) {
			txtFinCosecha.setValue(null);
			txtFinCosecha.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		return "";
	}

	public String actionDeleteDatTransProdN4(ActionEvent evt) {
		try {
			selectDetalle = (ListaProduccionDTO) (evt.getComponent().getAttributes().get("selectDetalle"));

			DatTransProdNivel4 entityDet = new DatTransProdNivel4();
			Long datTransProdNivel4Id = new Long(selectDetalle.getRef());
			entityDet = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
			businessDelegatorView.deleteDatTransProdNivel4(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			listarProduccion();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_editNivel4(ActionEvent evt) {
		selectDetalle = (ListaProduccionDTO) (evt.getComponent().getAttributes().get("selectDetalle"));

		try {
			Long datTransProdNivel4Id = selectDetalle.getRef().longValue();
			Object[] condicion = { "datTransProdNivel4Id", true, datTransProdNivel4Id, "=" };
			List<DatTransProdNivel4> lista = (datTransProdNivel4Id != null)
					? businessDelegatorView.findByCriteriaInDatTransProdNivel4(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {

				entityDet = lista.get(0);

				txtConsecutivo.setValue(selectDetalle.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaIniCosecha.setValue(selectDetalle.getFechaRegistro());
				txtFechaIniCosecha.setDisabled(false);
				txtFechaFinCosecha.setValue(selectDetalle.getFinCosecha());
				txtFechaFinCosecha.setDisabled(false);
				txtCantidadCosechada.setValue(entityDet.getCantidadCosechada());
				txtCantidadCosechada.setDisabled(false);
				txtKilogramosAzucarToneladas.setValue(entityDet.getKilogramosAzucarTonelada());
				txtKilogramosAzucarToneladas.setDisabled(false);
				txtValorKilogramosAzucar.setValue(entityDet.getValorKilogramosAzucar());
				txtValorKilogramosAzucar.setDisabled(false);
				txtValorUnitarioCosecha.setValue(entityDet.getValorUnitario());
				txtValorUnitarioCosecha.setDisabled(false);
				txtIngresoBruto.setValue(entityDet.getIngresoBruto());
				txtIngresoBruto.setDisabled(false);
				txtPorcRendimiento.setValue(entityDet.getPorcRendimiento());
				txtPorcRendimiento.setDisabled(false);
				txtAjusteLiquidacion.setValue(entityDet.getAjusteLiquidacion());
				txtAjusteLiquidacion.setDisabled(false);
				txtBonificion.setValue(entityDet.getBonificacion());
				txtBonificion.setDisabled(false);
				txtOtrosIngresos.setValue(entityDet.getOtrosIngresos());
				txtOtrosIngresos.setDisabled(false);
				txtRetenciones.setValue(entityDet.getRetenciones());
				txtRetenciones.setDisabled(false);
				txtDescuentos.setValue(entityDet.getDescuentos());
				txtDescuentos.setDisabled(false);
				txtFinCosecha.setValue(entityDet.getFinCosecha());
				txtFinCosecha.setDisabled(false);
				txtEdadNivel4.setValue(entityDet.getEdadNivel4());
				txtEdadNivel4.setDisabled(false);
				
				txtAreaCosechada.setValue(entityDet.getAreaCosechada());
				txtAreaCosechada.setDisabled(false);
				if(entityDet.getVariedNivel4()!=null) {
					txtVariedNivel4.setValue(entityDet.getVariedNivel4().getVariedId());
				
				}
				txtVariedNivel4.setDisabled(false);
				if(entityDet.getEtapaNivel4()!=null) {
					txtEtapaNivel4.setValue(entityDet.getEtapaNivel4().getEtapaId());
				}
				txtEtapaNivel4.setDisabled(false);
				

				txtNivel2Id.setValue(entityDet.getNivel2().getNivel2Id());
				txtNivel2Id.setDisabled(false);

				txtNivel4Id_Nivel4.setValue(entityDet.getNivel4().getNivel4Id());
				txtNivel4Id_Nivel4.setDisabled(false);

			/*	if (entityDet.getNivel4() != null) {
					Nivel4 nivel4 = businessDelegatorView.getNivel4(entityDet.getNivel4().getNivel4Id());
					Long idNivel3 = nivel4.getNivel3().getNivel3Id();
					txtNivel3Id.setValue(idNivel3);
				}
				txtNivel3Id.setDisabled(false);
			 	*/
				btnSave.setDisabled(false);
				setShowDialog(true);
			}

		} catch (Exception e) {
			entityDet = null;
		}
		return "";
	}

	public void listarProduccion() {
		try {

			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			Long planilla = FacesUtils.checkLong(txtPlanilla);

			if (planilla == null) {
				planilla = 0L;
			}

			Long flagHacienda = 1L;
			String haciendasSeleccionadas = "0";
			if (selectedHacienda != null && selectedHacienda.size() > 0) {
				haciendasSeleccionadas = selectedHacienda.get(0);
				flagHacienda = 0L;
				for (int i = 1; i < selectedHacienda.size(); i++) {
					haciendasSeleccionadas += "," + selectedHacienda.get(i);
				}
			}

			Long flagLote = 1L;
			String lotesSeleccionados = "0";
			if (selectedLote != null && selectedLote.size() > 0) {
				lotesSeleccionados = selectedLote.get(0);
				flagLote = 0L;
				for (int i = 1; i < selectedLote.size(); i++) {
					lotesSeleccionados += "," + selectedLote.get(i);
				}
			}

			Long compania = new Long(getCompaniaIdSession());
			if (compania != null && fechaInicial != null && fechaFinal != null) {

				dataDetalle = businessDelegator2View.pr_listar_reg_produccion(compania, fechaInicial, fechaFinal,
						planilla, haciendasSeleccionadas, flagHacienda, lotesSeleccionados, flagLote);

			} else if (compania != null && fechaInicial == null && fechaFinal == null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				dataDetalle = businessDelegator2View.pr_listar_reg_produccion(compania, fechaInicial, fechaFinal,
						planilla, haciendasSeleccionadas, flagHacienda, lotesSeleccionados, flagLote);
			}

			/*double totalUnidades = 0; double totalCosto = 0; if (dataDetalle != null &&
			dataDetalle.size() >= 0) { for (GastosProduccionDTO data1 : dataDetalle) {
			totalUnidades += data1.getIngresoBruto().doubleValue(); totalCosto +=
			data1.getValorUnitario().doubleValue(); } }
			  
			txtValorTotalAcumulado.setValue(totalCosto);
			txtCantidadAcumulado.setValue(totalUnidades);*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String action_reabrirCosecha(ActionEvent evt) {
		selectDetalle = (ListaProduccionDTO) (evt.getComponent().getAttributes().get("selectDetalle"));

		try {
			Long datTransProdNivel4Id = selectDetalle.getRef().longValue();
			Object[] condicion = { "datTransProdNivel4Id", true, datTransProdNivel4Id, "=" };
			List<DatTransProdNivel4> lista = (datTransProdNivel4Id != null)
					? businessDelegatorView.findByCriteriaInDatTransProdNivel4(condicion, null, null)
					: null;
					Long idHacienda = null;
					Long 	idLote = null;
					Long 	etapaCosecha = null;
					Long idRegistroProduccion = null;
					Long idCiclo =0L;
					Nivel4 entityLote = null;
					Etapa entityEtapa =null;
					Long etapaAnterior =null;
			if (lista != null && lista.size() > 0) {

				entityDet = lista.get(0);
				
				//	etapaCosecha=entityProduccion.getEtapaNivel4().getEtapaId();
					idRegistroProduccion = entityDet.getDatTransProdNivel4Id();
					idCiclo = entityDet.getCiclo();
					idLote = entityDet.getNivel4().getNivel4Id();
					entityDet.setEstadoRegistro("abierto");
					//entityDet = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
					
					Object[] condicionLote = { "nivel4Id", true, idLote, "=" };
					List<Nivel4> listaLote = (idLote != null)
							? businessDelegatorView.findByCriteriaInNivel4(condicionLote, null, null): null;
							if (listaLote != null && listaLote.size() > 0) {
								entityLote = listaLote.get(0);
								
								Long idEtapa = entityLote.getEtapa().getEtapaId();
								
								Object[] condicionEtapa = { "proximaEtapa", true, idEtapa, "=" };
								List<Etapa> listaEtapa = (idEtapa != null)
										? businessDelegatorView.findByCriteriaInEtapa(condicionEtapa, null, null): null;
										if (listaEtapa != null && listaEtapa.size() > 0) {
											entityEtapa = listaEtapa.get(0);
											etapaAnterior = entityEtapa.getEtapaId();
											
											businessDelegatorView.updateDatTransProdNivel4(entityDet);
											businessDelegator2View.pr_reabrir_cosecha_costos(  idLote ,  etapaCosecha ,  idRegistroProduccion , idCiclo);
											
											Etapa etapaActualizar = businessDelegatorView.getEtapa(etapaAnterior);		
											entityLote.setEtapa(etapaActualizar);	
											businessDelegatorView.updateNivel4(entityLote,  null, null, null);
											
											FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
													"Upps!,El lote fue re-abierto  de forma exitosa  " ,
													""));
										}else {
											FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
													"Upps!, Verifique que el catálogo Etapas de cosecha, tenga asociada una etapa anterior  " ,
													""));
										}
								
							}
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!, No hay registros de cosecha abiertos para la Hacienda/Lote seleccionada, Verifique por favor.  " ,
							""));
				}
				
			setShowDialog(false);

		} catch (Exception e) {
			entityDet = null;
		}
		return "";
	}
	

	public String action_ActualizarDetalle() {
		try {

			if (entityDet == null) {
				Long datTransProdNivel4Id = new Long(selectDetalle.getRef().longValue());
				entityDet = businessDelegatorView.getDatTransProdNivel4(datTransProdNivel4Id);
			}

			entityDet.setNivel2((FacesUtils.checkLong(txtNivel2Id) != null)
					? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2Id))
					: null);			
			entityDet.setNivel4((FacesUtils.checkLong(txtNivel4Id_Nivel4) != null)
					? businessDelegatorView.getNivel4(FacesUtils.checkLong(txtNivel4Id_Nivel4))
					: null);

			entityDet.setVariedNivel4((FacesUtils.checkLong(txtVariedNivel4) != null)
					? businessDelegatorView.getVariedad(FacesUtils.checkLong(txtVariedNivel4))
					: null);	
			entityDet.setEtapaNivel4((FacesUtils.checkLong(txtEtapaNivel4) != null)
					? businessDelegatorView.getEtapa(FacesUtils.checkLong(txtEtapaNivel4))
					: null);
			
			entityDet.setNivel3Id(FacesUtils.checkLong(txtNivel3Id));
			entityDet.setCantidadCosechada(FacesUtils.checkDouble(txtCantidadCosechada));
			entityDet.setKilogramosAzucarTonelada(FacesUtils.checkDouble(txtKilogramosAzucarToneladas));
			entityDet.setValorKilogramosAzucar(FacesUtils.checkDouble(txtValorKilogramosAzucar));
			entityDet.setValorUnitario(FacesUtils.checkDouble(txtValorUnitarioCosecha));
			entityDet.setIngresoBruto(FacesUtils.checkDouble(txtIngresoBruto));			
			entityDet.setPorcRendimiento(FacesUtils.checkDouble(txtPorcRendimiento));			
			entityDet.setAjusteLiquidacion(FacesUtils.checkDouble(txtAjusteLiquidacion));
			entityDet.setBonificacion(FacesUtils.checkDouble(txtBonificion));
			entityDet.setOtrosIngresos(FacesUtils.checkDouble(txtOtrosIngresos));
			entityDet.setRetenciones(FacesUtils.checkDouble(txtRetenciones));
			entityDet.setDescuentos(FacesUtils.checkDouble(txtDescuentos));
			entityDet.setEdadNivel4(FacesUtils.checkDouble(txtEdadNivel4));
			entityDet.setFinCosecha(FacesUtils.checkString(txtFinCosecha));
			entityDet.setAreaCosechada(FacesUtils.checkDouble(txtAreaCosechada));
			
			businessDelegatorView.updateDatTransProdNivel4(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			action_clear();
			listarProduccion();

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
	
	public void calcular_valor_unitario() {
		
		if (txtKilogramosAzucarToneladas != null && txtKilogramosAzucarToneladas.getValue() != null
				&& txtValorKilogramosAzucar != null && txtValorKilogramosAzucar.getValue() != null) {
			
			Double valorKilAzucar = (Double) txtValorKilogramosAzucar.getValue();
			Double kilToneladasAzucar = (Double) txtKilogramosAzucarToneladas.getValue();
			
			Double valorUnitario = 0.0;
			
			if (valorKilAzucar > 0 && kilToneladasAzucar > 0) {
			
				valorUnitario = (valorKilAzucar * kilToneladasAzucar);
			
			}
			
			txtValorUnitarioCosecha.setValue(valorUnitario);	
			calcular_ingreso_bruto();
		}
	}
	
	public void calcular_ingreso_bruto() {
		
		if (txtValorUnitarioCosecha != null && txtValorUnitarioCosecha.getValue() != null
				&& txtCantidadCosechada != null && txtCantidadCosechada.getValue() != null) {
			
			Double cantidadCosechada = (Double) txtCantidadCosechada.getValue();
			Double valorUnitario = (Double) txtValorUnitarioCosecha.getValue();
			
			Double ingresoBruto = 0.0;
			
			if (cantidadCosechada > 0 && valorUnitario > 0) {
			
				ingresoBruto = (cantidadCosechada * valorUnitario);
			
			}
			
			txtIngresoBruto.setValue(ingresoBruto);			
		}
	}

	public List<String> getSelectedHacienda() {
		return selectedHacienda;
	}

	public void setSelectedHacienda(List<String> selectedHacienda) {
		this.selectedHacienda = selectedHacienda;
	}

	public List<Nivel2> getHaciendas() {

		if (haciendas == null || haciendas.size() == 0) {

			try {
				haciendas = businessDelegatorView.getNivel2();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return haciendas;
	}

	public void setHaciendas(List<Nivel2> haciendas) {
		this.haciendas = haciendas;
	}

	public List<String> getSelectedLote() {
		return selectedLote;
	}

	public void setSelectedLote(List<String> selectedLote) {
		this.selectedLote = selectedLote;
	}

	public List<Nivel4> getLotes() {

		if (lotes == null || lotes.size() == 0) {

			try {
				lotes = businessDelegatorView.getNivel4();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return lotes;
	}

	public void setLotes(List<Nivel4> lotes) {
		this.lotes = lotes;
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
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

	public Calendar getTxtFechaIniCosecha() {
		return txtFechaIniCosecha;
	}

	public void setTxtFechaIniCosecha(Calendar txtFechaIniCosecha) {
		this.txtFechaIniCosecha = txtFechaIniCosecha;
	}

	public Calendar getTxtFechaFinCosecha() {
		return txtFechaFinCosecha;
	}

	public void setTxtFechaFinCosecha(Calendar txtFechaFinCosecha) {
		this.txtFechaFinCosecha = txtFechaFinCosecha;
	}

	public InputText getTxtCantidadCosechada() {
		return txtCantidadCosechada;
	}

	public void setTxtCantidadCosechada(InputText txtCantidadCosechada) {
		this.txtCantidadCosechada = txtCantidadCosechada;
	}

	public InputText getTxtKilogramosAzucarToneladas() {
		return txtKilogramosAzucarToneladas;
	}

	public void setTxtKilogramosAzucarToneladas(InputText txtKilogramosAzucarToneladas) {
		this.txtKilogramosAzucarToneladas = txtKilogramosAzucarToneladas;
	}

	public InputText getTxtValorKilogramosAzucar() {
		return txtValorKilogramosAzucar;
	}

	public void setTxtValorKilogramosAzucar(InputText txtValorKilogramosAzucar) {
		this.txtValorKilogramosAzucar = txtValorKilogramosAzucar;
	}

	public InputText getTxtValorUnitarioCosecha() {
		return txtValorUnitarioCosecha;
	}

	public void setTxtValorUnitarioCosecha(InputText txtValorUnitarioCosecha) {
		this.txtValorUnitarioCosecha = txtValorUnitarioCosecha;
	}

	public InputNumber getTxtIngresoBruto() {
		return txtIngresoBruto;
	}

	public void setTxtIngresoBruto(InputNumber txtIngresoBruto) {
		this.txtIngresoBruto = txtIngresoBruto;
	}

	public InputText getTxtPorcRendimiento() {
		return txtPorcRendimiento;
	}

	public void setTxtPorcRendimiento(InputText txtPorcRendimiento) {
		this.txtPorcRendimiento = txtPorcRendimiento;
	}

	public InputNumber getTxtAjusteLiquidacion() {
		return txtAjusteLiquidacion;
	}

	public void setTxtAjusteLiquidacion(InputNumber txtAjusteLiquidacion) {
		this.txtAjusteLiquidacion = txtAjusteLiquidacion;
	}

	public InputNumber getTxtBonificion() {
		return txtBonificion;
	}

	public void setTxtBonificion(InputNumber txtBonificion) {
		this.txtBonificion = txtBonificion;
	}

	public InputNumber getTxtOtrosIngresos() {
		return txtOtrosIngresos;
	}

	public void setTxtOtrosIngresos(InputNumber txtOtrosIngresos) {
		this.txtOtrosIngresos = txtOtrosIngresos;
	}

	public InputNumber getTxtRetenciones() {
		return txtRetenciones;
	}

	public void setTxtRetenciones(InputNumber txtRetenciones) {
		this.txtRetenciones = txtRetenciones;
	}

	public InputNumber getTxtDescuentos() {
		return txtDescuentos;
	}

	public void setTxtDescuentos(InputNumber txtDescuentos) {
		this.txtDescuentos = txtDescuentos;
	}

	public List<ListaProduccionDTO> getDataDetalle() {
		return dataDetalle;
	}

	public void setDataDetalle(List<ListaProduccionDTO> dataDetalle) {
		this.dataDetalle = dataDetalle;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputNumber getTxtEdadNivel4() {
		return txtEdadNivel4;
	}

	public void setTxtEdadNivel4(InputNumber txtEdadNivel4) {
		this.txtEdadNivel4 = txtEdadNivel4;
	}

	public SelectOneRadio getTxtFinCosecha() {
		return txtFinCosecha;
	}

	public void setTxtFinCosecha(SelectOneRadio txtFinCosecha) {
		this.txtFinCosecha = txtFinCosecha;
	}

	public InputText getTxtAreaCosechada() {
		return txtAreaCosechada;
	}

	public void setTxtAreaCosechada(InputText txtAreaCosechada) {
		this.txtAreaCosechada = txtAreaCosechada;
	}

	public SelectOneMenu getTxtEtapaNivel4() {
		return txtEtapaNivel4;
	}

	public void setTxtEtapaNivel4(SelectOneMenu txtEtapaNivel4) {
		this.txtEtapaNivel4 = txtEtapaNivel4;
	}

	public SelectOneMenu getTxtVariedNivel4() {
		return txtVariedNivel4;
	}

	public void setTxtVariedNivel4(SelectOneMenu txtVariedNivel4) {
		this.txtVariedNivel4 = txtVariedNivel4;
	}
	
	public SelectItem[] getSelectItemEtapa() {

		if (etapa == null || etapa.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Etapa> lista = businessDelegatorView.findByCriteriaInEtapa(condicion, null, null);
				selectItemEtapa = new SelectItem[lista.size()];

				int i = 0;
				for (Etapa et : lista) {
					selectItemEtapa[i] = new SelectItem(et.getEtapaId(), et.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemEtapa;
	}

	public void setSelectItemEtapa(SelectItem[] selectItemEtapa) {
		this.selectItemEtapa = selectItemEtapa;
	}
	
	public SelectItem[] getSelectItemVariedad() {

		if (variedad == null || variedad.size() == 0) {


			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Variedad> lista = businessDelegatorView.findByCriteriaInVariedad(condicion, null, null);
				selectItemVariedad = new SelectItem[lista.size()];

				int i = 0;
				for (Variedad v : lista) {
					selectItemVariedad[i] = new SelectItem(v.getVariedId(), v.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectItemVariedad;
	}

	public void setSelectItemVariedad(SelectItem[] selectItemVariedad) {
		this.selectItemVariedad = selectItemVariedad;
	}
	

	public void listener_ConsultaAreaNivel4Cosecha() {

		Long nivel4Id = null;

		if (!txtNivel4Id_Nivel4.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());

			try {
				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				txtAreaCosechada.setValue(nivel4.getAreaNeta());
				txtEtapaNivel4.setValue(nivel4.getEtapa().getEtapaId());
				txtVariedNivel4.setValue(nivel4.getVariedad());
				Date fechaCosecha = FacesUtils.checkDate(txtFechaFinCosecha);
				Double edad = businessDelegatorView.calcularEdadLote(fechaCosecha, nivel4Id);
				txtEdadNivel4.setValue(edad);
				Long companiaId = new Long(getCompaniaIdSession());
				Compania compania = businessDelegatorView.getCompania(companiaId);
				
				Double AzTc = 0.0;//compania.getKilosAzucarTc();
				Double valorKgAzucar = 0.0;//compania.getValorKgAzucar();
				txtKilogramosAzucarToneladas.setValue(AzTc);
				txtValorKilogramosAzucar.setValue(valorKgAzucar);
				txtValorUnitarioCosecha.setValue(AzTc*valorKgAzucar);
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}
	
	public SelectItem[] getSelectLote() {
		
		if (txtNivel2Id != null && txtNivel2Id.getValue() != null) {
	
			try {

				Long compania = new Long(getCompaniaIdSession());
				String nivel2Id = FacesUtils.checkString(txtNivel2Id);				
				List<ListaNivel4DTO> lista = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
				selectLote = new SelectItem[lista.size()];

				int i = 0;
				for (ListaNivel4DTO nivel4 : lista) {
					selectLote[i] = new SelectItem(nivel4.getNivel4_id(), nivel4.getNom_nivel4());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLote;
	}

public void setSelectLote(SelectItem[] selectLote) {
	this.selectLote = selectLote;
}
	
}