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
import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.CostosInsumosDetalladoDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ListarInsumosAgricolasView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ListarInsumosAgricolasView.class);
	private InputText txtConsecutivo;
	private Calendar txtFechaRegistro;
	private InputText txtCantidadAplicada;
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
	
	private CostosInsumosDetalladoDTO selectDetalleInsumos;
	private List<CostosInsumosDetalladoDTO> dataDetalleInsumos;
	private DatAplicProdDet entityDet;

	private SelectOneMenu txtAlmacenId;
	SelectItem[] selectAlmacen;

	private SelectOneMenu txtProducto;
	SelectItem[] selectProducto;

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

	public ListarInsumosAgricolasView() {
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

		if (txtCantidadAplicada != null) {
			txtCantidadAplicada.setValue(0);
			txtCantidadAplicada.setDisabled(false);
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

		if (txtUdadMedPago != null) {
			txtUdadMedPago.setValue(null);
			txtUdadMedPago.setDisabled(false);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(0);
			txtValorUnitario.setDisabled(false);
		}

		if (txtAlmacenId != null) {
			txtAlmacenId.setValue(null);
			txtAlmacenId.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(true);
		}

		if (txtProducto != null) {
			txtProducto.setValue(null);
			txtProducto.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}
		
		return "";
	}

	public String actionDeleteDatAplicProdDet(ActionEvent evt) {
		try {
			selectDetalleInsumos = (CostosInsumosDetalladoDTO) (evt.getComponent().getAttributes()
					.get("selectDetalleInsumos"));
			
			DatAplicProdDet entityDet = new DatAplicProdDet();
			Long datProdDetId = new Long(selectDetalleInsumos.getIdInsumos().longValue());
			entityDet = businessDelegatorView.getDatAplicProdDet(datProdDetId);
			businessDelegatorView.deleteDatAplicProdDet(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			listarInsumosAgricolas();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_editInsumos(ActionEvent evt) {
		selectDetalleInsumos = (CostosInsumosDetalladoDTO) (evt.getComponent().getAttributes()
				.get("selectDetalleInsumos"));

		try {
			Long datAplicProdDetId = selectDetalleInsumos.getIdInsumos().longValue();
			Object[] condicion = { "datProdDetId", true, datAplicProdDetId, "=" };
			List<DatAplicProdDet> lista = (datAplicProdDetId != null)
					? businessDelegatorView.findByCriteriaInDatAplicProdDet(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {

				entityDet = lista.get(0);

				txtConsecutivo.setValue(selectDetalleInsumos.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtFechaRegistro.setValue(selectDetalleInsumos.getFecha());
				txtFechaRegistro.setDisabled(true);

				txtCantidadAplicada.setValue(entityDet.getCantidadAplicada());
				txtCantidadAplicada.setDisabled(false);
				txtValorUnitario.setValue(entityDet.getValorUnit());
				txtValorUnitario.setDisabled(false);

				txtAlmacenId.setValue(entityDet.getAlmacenId().getAlmacenId());
				txtAlmacenId.setDisabled(false);

				txtProducto.setValue(entityDet.getProducto().getProductoId());
				txtProducto.setDisabled(false);

				txtUdadMedPago.setValue(entityDet.getUdadMed().getUdadMedId());
				txtUdadMedPago.setDisabled(false);

				txtNivel2Id.setDisabled(false);
				txtNivel2Id.setValue(entityDet.getNivel2Id().getNivel2Id());

				txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel4Id_Nivel4.setValue(entityDet.getNivel4().getNivel4Id());

				if (entityDet.getNivel4() != null) {
					Nivel4 nivel4 = businessDelegatorView.getNivel4(entityDet.getNivel4().getNivel4Id());
					Long idNivel3 = nivel4.getNivel3().getNivel3Id();
					txtNivel3Id.setValue(idNivel3);
				}
				txtNivel3Id.setDisabled(false);

				txtLaborId_Labor.setDisabled(false);
				txtLaborId_Labor.setValue(entityDet.getLaborId().getLaborId());

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

	public void listarInsumosAgricolas() {
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

				dataDetalleInsumos = businessDelegatorView.consultarInformeCostosInsumosDetallado(compania, fechaInicial, fechaFinal,
						"0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, numeroPlanilla);

			} else if (compania != null && fechaInicial == null && fechaFinal == null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				dataDetalleInsumos = businessDelegatorView.consultarInformeCostosInsumosDetallado(compania, fechaInicial, fechaFinal,
						"0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, "0", 1L, numeroPlanilla);

			}

			double totalUnidades = 0;
			double totalCosto = 0;
			if (dataDetalleInsumos != null && dataDetalleInsumos.size() >= 0) {
				for (CostosInsumosDetalladoDTO data1 : dataDetalleInsumos) {
					totalUnidades += data1.getCantidadAplicada().doubleValue();
					totalCosto += data1.getCostoTotal().doubleValue();
				}
			}

			txtValorTotalAcumulado.setValue(totalCosto);
			txtCantidadAcumulado.setValue(totalUnidades);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String action_ActualizarInsumos() {
		try {

			if (entityDet == null) {
				Long datProdDetId = new Long(selectDetalleInsumos.getIdInsumos().longValue());
				entityDet = businessDelegatorView.getDatAplicProdDet(datProdDetId);
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
			entityDet.setAlmacenId((FacesUtils.checkLong(txtAlmacenId) != null)
					? businessDelegatorView.getAlmacen(FacesUtils.checkLong(txtAlmacenId))
					: null);
			entityDet.setProducto((FacesUtils.checkLong(txtProducto) != null)
					? businessDelegatorView.getProducto(FacesUtils.checkLong(txtProducto))
					: null);
			entityDet.setUdadMed((FacesUtils.checkLong(txtUdadMedPago) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedPago))
					: null);

			entityDet.setCantidadAplicada(FacesUtils.checkDouble(txtCantidadAplicada));
			entityDet.setValorUnit(FacesUtils.checkDouble(txtValorUnitario));
			
			Double cantidad = FacesUtils.checkDouble(txtCantidadAplicada);
			Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
			Double costoTotal = cantidad * valorUnitario;
			costoTotal = (double) Math.round((costoTotal) * 10) / 10;

			entityDet.setCostoTotal(costoTotal);

			businessDelegatorView.updateDatAplicProdDet(entityDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			action_clear();
			listarInsumosAgricolas();

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
					txtCantidadAplicada.setValue(entity1.getCantidadPlanId());
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

	public SelectItem[] getSelectAlmacen() {

		if (selectAlmacen == null || selectAlmacen.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(), almacen.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	public void setSelectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public SelectItem[] getSelectProducto() {

		if (selectProducto == null || selectProducto.length == 0) {
			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProducto = new SelectItem[lista.size()];

				int i = 0;
				for (Producto producto : lista) {
					selectProducto[i] = new SelectItem(producto.getProductoId(), producto.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProducto;
	}

	public void setSelectProducto(SelectItem[] selectProducto) {
		this.selectProducto = selectProducto;
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

	public List<CostosInsumosDetalladoDTO> getDataDetalleInsumos() {
		return dataDetalleInsumos;
	}

	public void setDataDetalleInsumos(List<CostosInsumosDetalladoDTO> dataDetalleInsumos) {
		this.dataDetalleInsumos = dataDetalleInsumos;
	}

	public InputText getTxtCantidadAplicada() {
		return txtCantidadAplicada;
	}

	public void setTxtCantidadAplicada(InputText txtCantidadAplicada) {
		this.txtCantidadAplicada = txtCantidadAplicada;
	}

	public SelectOneMenu getTxtAlmacenId() {
		return txtAlmacenId;
	}

	public void setTxtAlmacenId(SelectOneMenu txtAlmacenId) {
		this.txtAlmacenId = txtAlmacenId;
	}

	public SelectOneMenu getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(SelectOneMenu txtProducto) {
		this.txtProducto = txtProducto;
	}
}