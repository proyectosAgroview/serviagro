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
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatDiferidos;
import co.com.arcosoft.modelo.DatDiferidosDet;
import co.com.arcosoft.modelo.DatOtrosCostosMqdet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDetDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCostosDiferidosDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
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
public class DatDiferidosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatDiferidosView.class);
	private InputText txtAnioAplicacion;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtDetalleAplicacion;
	private InputTextarea txtDetalleNota;
	private InputText txtEstado;
	private InputText txtMesAplicacion;
	private InputText txtNpReset;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;
	private SelectOneMenu txtPeriodos;
	private InputText txtUsuarioDigitacion;
	private InputNumber txtValorCuota;
	private InputNumber txtValorInicial;
	private InputNumber txtValorSaldo;
	private InputText txtDatDiferidosId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatDiferidosDTO> data;
	private DatDiferidosDTO selectedDatDiferidos;
	private DatDiferidos entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtEquipoId;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private int activeTapIndex = 0;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private CommandButton btnAgregar;

	private List<ConsultaCostosDiferidosDTO> data2;

	private InputNumber txtValorTotalAcumulado;

	private DatDiferidosDetDTO selectedDatDiferidosDet;

	private DatDiferidosDet entityDet;

	private ConsultaCostosDiferidosDTO selectedDatDiferidos2;

	/** Detalle ***/
	private List<DatDiferidosDetDTO> dataDet;
	private List<DatDiferidosCuotasDTO> dataCuotas;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputText txtNumeroFactura;

	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipo;

	private SelectOneMenu txtTipoTransaccion;

	private List<ListaEquiposCategoriaDTO> dataEquiposCategoriaDTO;

	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	
	private SelectOneMenu txtPersEmprConsulta;
	SelectItem[] selectPersEmprConsulta;
	
	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;

	private InputText txtDocumento;
	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;
	private List<String> selectedContratista;
 
	private List<PersEmpr> contratistas;
	private InputText txtDocumentoFactura;
	
	public DatDiferidosView() {
		super();
	}

	public String action_new() throws NumberFormatException, Exception {
		action_clear();
		selectedDatDiferidos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws NumberFormatException, Exception {
		entity = null;
		selectedDatDiferidos = null;
		PrimeFaces.current().resetInputs(":frm");
		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}
		if (txtTipoTransaccion != null) {
			txtTipoTransaccion.setValue(null);
			txtTipoTransaccion.setDisabled(false);
		}

		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(false);
		}
		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
		}

		if (txtAnioAplicacion != null) {
			txtAnioAplicacion.setValue(null);
			txtAnioAplicacion.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}
		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtNumeroFactura != null) {
			txtNumeroFactura.setValue(null);
			txtNumeroFactura.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			Long compania = new Long(getCompaniaIdSession());
			txtConsecutivo.setValue(businessDelegator2View.consultarConsecutivoDatDiferidos(compania));
			txtConsecutivo.setDisabled(true);
		}

		if (txtDetalleAplicacion != null) {
			txtDetalleAplicacion.setValue(null);
			txtDetalleAplicacion.setDisabled(false);
		}

		if (dataDet != null) {
			dataDet = null;
		}
		if (dataCuotas != null) {
			dataCuotas = null;
		}

		if (txtValorTotalAcumulado != null) {
			txtValorTotalAcumulado.setValue(null);
			txtValorTotalAcumulado.setDisabled(false);
		}

		if (txtDetalleNota != null) {
			txtDetalleNota.setValue(null);
			txtDetalleNota.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtMesAplicacion != null) {
			txtMesAplicacion.setValue(null);
			txtMesAplicacion.setDisabled(false);
		}

		if (txtNpReset != null) {
			txtNpReset.setValue(null);
			txtNpReset.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtPeriodos != null) {
			txtPeriodos.setValue(null);
			txtPeriodos.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtValorCuota != null) {
			txtValorCuota.setValue(null);
			txtValorCuota.setDisabled(false);
		}

		if (txtValorInicial != null) {
			txtValorInicial.setValue(null);
			txtValorInicial.setDisabled(false);
		}

		if (txtValorSaldo != null) {
			txtValorSaldo.setValue(null);
			txtValorSaldo.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtDatDiferidosId != null) {
			txtDatDiferidosId.setValue(null);
			txtDatDiferidosId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public String action_edit(ActionEvent evt) {
		selectedDatDiferidos2 = (ConsultaCostosDiferidosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatDiferidos2"));
		try {

			Long datDiferidosId = selectedDatDiferidos2.getDatDiferidosId().longValue();
			Object[] condicion = { "datDiferidosId", true, datDiferidosId, "=" };
			List<DatDiferidos> lista = (datDiferidosId != null)
					? businessDelegator2View.findByCriteriaInDatDiferidos(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);

				txtTipoTransaccion.setValue(entity.getTipoTransaccion());
				txtCategEquipId_CategoriaEquipo.setValue(entity.getCategEquipId());
				if (entity.getPersEmpr() != null) {
					txtPersEmprId_PersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
				}

				txtPersEmprId_PersEmpr.setDisabled(false);

				txtCentCostId_CentCost.setValue(null);
				if (entity.getCentCostId() != null) {
					txtCentCostId_CentCost.setValue(entity.getCentCostId());
				}
				txtCentCostId_CentCost.setDisabled(false);

				txtNumeroFactura.setValue(entity.getNumeroFactura());
				txtNumeroFactura.setDisabled(false);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				if (entity.getLaborId() != null) {
					txtLaborId_Labor.setValue(entity.getLaborId().getLaborId());
				}

				txtLaborId_Labor.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPeriodos.setValue(entity.getPeriodos());
				txtPeriodos.setDisabled(false);
				// txtValorCuota.setValue(entity.getValorCuota());
				/// txtValorCuota.setDisabled(false);
				txtValorInicial.setValue(entity.getValorInicial());
				txtValorInicial.setDisabled(false);
				// --txtValorSaldo.setValue(entity.getValorSaldo());
				// txtValorSaldo.setDisabled(false);
				txtDatDiferidosId.setValue(entity.getDatDiferidosId());
				txtDatDiferidosId.setDisabled(true);
				btnSave.setDisabled(false);

				txtTipoTransaccion.setValue(entity.getTipoTransaccion());
				txtTipoTransaccion.setDisabled(false);

				String tipoDistri = entity.getTipoTransaccion();

				if (tipoDistri != null) {

					if (tipoDistri.equals("distri_multiples_equipos")) {
						txtCategEquipId_CategoriaEquipo.setDisabled(true);
					//	txtEquipoId.setDisabled(false);

					}
					if (tipoDistri.equals("distri_categorias")) {
						txtCategEquipId_CategoriaEquipo.setDisabled(false);
					//	txtEquipoId.setDisabled(true);

					}

					if (tipoDistri.equals("")) {
						txtCategEquipId_CategoriaEquipo.setDisabled(false);
					//	txtEquipoId.setDisabled(false);
					}
				}

				Long id = FacesUtils.checkLong(txtDatDiferidosId);

				dataDet = null;
				dataDet = businessDelegator2View.getDataDatDiferidosDetByDiferidos(id);

				dataCuotas = null;
				dataCuotas = businessDelegator2View.getDataDatDiferidosCuotasByCuotas(id);

				double valorTotal = 0;
				if (dataCuotas != null && dataCuotas.size() >= 0) {
					for (DatDiferidosCuotasDTO data1 : dataCuotas) {

						valorTotal += data1.getValorCuota().doubleValue();
					}
				}
				txtValorTotalAcumulado.setValue(valorTotal);
				txtValorTotalAcumulado.setDisabled(false);
				txtImplemento.setDisabled(false);
				//txtEquipoId.setDisabled(false);

				btnAgregar.setDisabled(false);

				activeTapIndex = 0;
				setShowDialog(true);

			}
		} catch (

		Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatDiferidos == null) && (entity == null)) {
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

	/******** sesion de usuarios **/
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

	public String action_create() {
		try {
			entity = new DatDiferidos();

			// Long datDiferidosId = FacesUtils.checkLong(txtDatDiferidosId);

			// Long datDiferidosId = FacesUtils.checkLong(txtDatDiferidosId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);

			entity.setCategEquipId(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo));

			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));

			entity.setAnioAplicacion(FacesUtils.checkLong(txtAnioAplicacion));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setNumeroFactura(FacesUtils.checkString(txtNumeroFactura));

			entity.setDetalleAplicacion(FacesUtils.checkString(txtDetalleAplicacion));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));

			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);

			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setLaborId((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);

			entity.setMesAplicacion(FacesUtils.checkLong(txtMesAplicacion));
			entity.setNpReset(FacesUtils.checkLong(txtNpReset));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setPeriodos(FacesUtils.checkLong(txtPeriodos));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(txtUsuarioDigitacion));
			entity.setValorCuota(FacesUtils.checkDouble(txtValorCuota));
			entity.setValorInicial(FacesUtils.checkDouble(txtValorInicial));
			entity.setValorSaldo(FacesUtils.checkDouble(txtValorSaldo));
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));

			String tipoTransaccion = "";
			if (txtTipoTransaccion.getValue() != null) {
				tipoTransaccion = txtTipoTransaccion.getValue().toString();
				if (tipoTransaccion.equals("distri_categorias")) {
					Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
					if (categoria != null) {
						dataEquiposCategoriaDTO = businessDelegator2View.pr_lista_equipo(categoria);
						if (dataEquiposCategoriaDTO != null && dataEquiposCategoriaDTO.size() > 0) {
							businessDelegator2View.saveDatDiferidosVer2(entity, dataEquiposCategoriaDTO, dataCuotas);

							// businessDelegatorView.saveDatDiferidosVer2(entity, dataEquiposCategoriaDTO);
							// Long idOtrosCostosMq =
							// businessDelegatorView.pr_max_id_unico_dat_otros_costos_mq(compania) ;
							// Long recalculoOtrosCostosMq =
							// businessDelegatorView.pr_recalcular_otros_costosmq(idOtrosCostosMq) ;

							FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
							action_clear();
						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Upps! La categoría que ha seleccionado para distribuir los productos no tiene máquinas asociadas, la información no sera grabada ",
									""));
							selectedDatDiferidos = null;
							entity = null;

						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Verifique que el campo categoría tenga datos. "));
						selectedDatDiferidos = null;
						entity = null;
					}
				}
				if (tipoTransaccion.equals("distri_multiples_equipos")) {
					if (dataDet != null) {
						businessDelegator2View.saveDatDiferidos(entity, dataDet, dataCuotas);
						// Long idOtrosCostosMq =
						// businessDelegatorView.pr_max_id_unico_dat_otros_costos_mq(compania) ;
						// Long recalculoOtrosCostosMq =
						// businessDelegatorView.pr_recalcular_otros_costosmq(idOtrosCostosMq) ;
						FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
						action_clear();
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Falta seleccionar la maquinaría asociada al gasto de operación "));

					}
				}

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
				Long datDiferidosId = new Long(selectedDatDiferidos.getDatDiferidosId());
				entity = businessDelegator2View.getDatDiferidos(datDiferidosId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaModificacion(date);
			entity.setNumeroFactura(FacesUtils.checkString(txtNumeroFactura));

			entity.setAnioAplicacion(FacesUtils.checkLong(txtAnioAplicacion));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setDetalleAplicacion(FacesUtils.checkString(txtDetalleAplicacion));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setLaborId((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setCategEquipId(FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo));

			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));

			entity.setMesAplicacion(FacesUtils.checkLong(txtMesAplicacion));
			entity.setNpReset(FacesUtils.checkLong(txtNpReset));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setPeriodos(FacesUtils.checkLong(txtPeriodos));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(txtUsuarioDigitacion));
			entity.setValorCuota(FacesUtils.checkDouble(txtValorCuota));
			entity.setValorInicial(FacesUtils.checkDouble(txtValorInicial));
			entity.setValorSaldo(FacesUtils.checkDouble(txtValorSaldo));
			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId_PersEmpr))
					: null);
			entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));
			Long datDiferidosId = FacesUtils.checkLong(txtDatDiferidosId);
			Long borrarCuotas = businessDelegator2View.pr_borrar_dat_diferidos_cuotas(datDiferidosId);
			dataCuotas = null;

			String tipoTransaccion = "";
			if (txtTipoTransaccion.getValue() != null) {
				tipoTransaccion = txtTipoTransaccion.getValue().toString();
				if (tipoTransaccion.equals("distri_categorias")) {

					// businessDelegatorView.pr_borrar_maq_otros_costosmq(id);
					Long categoria = FacesUtils.checkLong(txtCategEquipId_CategoriaEquipo);
					if (categoria != null) {

						dataEquiposCategoriaDTO = businessDelegator2View.pr_lista_equipo(categoria);
						if (dataEquiposCategoriaDTO != null && dataEquiposCategoriaDTO.size() > 0) {
							Long borrarDiferidosDet = businessDelegator2View
									.pr_borrar_dat_diferidos_det(datDiferidosId);
							businessDelegator2View.updateDatDiferidosVer2(entity, dataEquiposCategoriaDTO, dataCuotas);
							FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
							action_clear();
						} else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Upps! La categoría que ha seleccionado para distribuir los productos no tiene máquinas asociadas, la información no sera grabada ",
									""));
						}
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps! Verifique que el campo categoría tenga datos.", " "));

					}
				}
				if (tipoTransaccion.equals("distri_multiples_equipos")) {
					if (dataDet != null) {
						businessDelegator2View.updateDatDiferidos(entity, dataDet, dataCuotas);
						// Long idOtrosCostosMq = FacesUtils.checkLong(txtDatDiferidosId); ;
						// Long recalculoOtrosCostosMq =
						// businessDelegatorView.pr_recalcular_otros_costosmq(idOtrosCostosMq) ;
						FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
						action_clear();
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps! Falta seleccionar la maquinaría asociada al gasto de operación", ""));

					}
				}

			}

		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatDiferidos = (DatDiferidosDTO) (evt.getComponent().getAttributes().get("selectedDatDiferidos"));

			Long datDiferidosId = new Long(selectedDatDiferidos.getDatDiferidosId());
			entity = businessDelegator2View.getDatDiferidos(datDiferidosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datDiferidosId = FacesUtils.checkLong(txtDatDiferidosId);
			entity = businessDelegator2View.getDatDiferidos(datDiferidosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatDiferidos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws NumberFormatException, Exception {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatDiferidos = (DatDiferidosDTO) (evt.getComponent().getAttributes().get("selectedDatDiferidos"));

			Long datDiferidosId = new Long(selectedDatDiferidos.getDatDiferidosId());
			entity = businessDelegator2View.getDatDiferidos(datDiferidosId);
			businessDelegator2View.deleteDatDiferidos(entity);
			data.remove(selectedDatDiferidos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anioAplicacion, Long compania, Long consecutivo, Long datDiferidosId,
			String detalleAplicacion, String detalleNota, String estado, Date fechaAnulacion, Date fechaCreacion,
			Date fechaModificacion, Date fechaRegistro, Long laborId, Long mesAplicacion, Long npReset,
			String observacion, String observacionAnularReg, Long periodos, Long usuarioDigitacion, Double valorCuota,
			Double valorInicial, Double valorSaldo) throws Exception {
		try {
			entity.setAnioAplicacion(FacesUtils.checkLong(anioAplicacion));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDetalleAplicacion(FacesUtils.checkString(detalleAplicacion));
			entity.setDetalleNota(FacesUtils.checkString(detalleNota));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));

			entity.setLaborId((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);

			entity.setMesAplicacion(FacesUtils.checkLong(mesAplicacion));
			entity.setNpReset(FacesUtils.checkLong(npReset));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPeriodos(FacesUtils.checkLong(periodos));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorCuota(FacesUtils.checkDouble(valorCuota));
			entity.setValorInicial(FacesUtils.checkDouble(valorInicial));
			entity.setValorSaldo(FacesUtils.checkDouble(valorSaldo));
			businessDelegator2View.updateDatDiferidos(entity, dataDet, dataCuotas);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatDiferidosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAnioAplicacion() {
		return txtAnioAplicacion;
	}

	public void setTxtAnioAplicacion(InputText txtAnioAplicacion) {
		this.txtAnioAplicacion = txtAnioAplicacion;
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

	public InputText getTxtDetalleAplicacion() {
		return txtDetalleAplicacion;
	}

	public void setTxtDetalleAplicacion(InputText txtDetalleAplicacion) {
		this.txtDetalleAplicacion = txtDetalleAplicacion;
	}

	public InputTextarea getTxtDetalleNota() {
		return txtDetalleNota;
	}

	public void setTxtDetalleNota(InputTextarea txtDetalleNota) {
		this.txtDetalleNota = txtDetalleNota;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtMesAplicacion() {
		return txtMesAplicacion;
	}

	public void setTxtMesAplicacion(InputText txtMesAplicacion) {
		this.txtMesAplicacion = txtMesAplicacion;
	}

	public InputText getTxtNpReset() {
		return txtNpReset;
	}

	public void setTxtNpReset(InputText txtNpReset) {
		this.txtNpReset = txtNpReset;
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

	public SelectOneMenu getTxtPeriodos() {
		return txtPeriodos;
	}

	public void setTxtPeriodos(SelectOneMenu txtPeriodos) {
		this.txtPeriodos = txtPeriodos;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public InputNumber getTxtValorCuota() {
		return txtValorCuota;
	}

	public void setTxtValorCuota(InputNumber txtValorCuota) {
		this.txtValorCuota = txtValorCuota;
	}

	public InputNumber getTxtValorInicial() {
		return txtValorInicial;
	}

	public void setTxtValorInicial(InputNumber txtValorInicial) {
		this.txtValorInicial = txtValorInicial;
	}

	public InputNumber getTxtValorSaldo() {
		return txtValorSaldo;
	}

	public void setTxtValorSaldo(InputNumber txtValorSaldo) {
		this.txtValorSaldo = txtValorSaldo;
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

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public InputText getTxtDatDiferidosId() {
		return txtDatDiferidosId;
	}

	public void setTxtDatDiferidosId(InputText txtDatDiferidosId) {
		this.txtDatDiferidosId = txtDatDiferidosId;
	}

	public List<DatDiferidosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatDiferidos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatDiferidosDTO> datDiferidosDTO) {
		this.data = datDiferidosDTO;
	}

	public DatDiferidosDTO getSelectedDatDiferidos() {
		return selectedDatDiferidos;
	}

	public void setSelectedDatDiferidos(DatDiferidosDTO datDiferidos) {
		this.selectedDatDiferidos = datDiferidos;
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

	public DatDiferidos getEntity() {
		return entity;
	}

	public void setEntity(DatDiferidos entity) {
		this.entity = entity;
	}

	public SelectOneMenu getTxtEquipoId() {
		return txtEquipoId;
	}

	public void setTxtEquipoId(SelectOneMenu txtEquipoId) {
		this.txtEquipoId = txtEquipoId;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<ConsultaCostosDiferidosDTO> getData2() {
		return data2;
	}

	public void setData2(List<ConsultaCostosDiferidosDTO> data2) {
		this.data2 = data2;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public DatDiferidosDetDTO getSelectedDatDiferidosDet() {
		return selectedDatDiferidosDet;
	}

	public void setSelectedDatDiferidosDet(DatDiferidosDetDTO selectedDatDiferidosDet) {
		this.selectedDatDiferidosDet = selectedDatDiferidosDet;
	}

	public DatDiferidosDet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatDiferidosDet entityDet) {
		this.entityDet = entityDet;
	}

	public ConsultaCostosDiferidosDTO getSelectedDatDiferidos2() {
		return selectedDatDiferidos2;
	}

	public void setSelectedDatDiferidos2(ConsultaCostosDiferidosDTO selectedDatDiferidos2) {
		this.selectedDatDiferidos2 = selectedDatDiferidos2;
	}

	public List<DatDiferidosDetDTO> getDataDet() {
		return dataDet;
	}

	public void setDataDet(List<DatDiferidosDetDTO> dataDet) {
		this.dataDet = dataDet;
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

	public SelectItem[] getSelectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {

				laborId = businessDelegatorView.getLabor(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion", "=" };
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

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "="

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

	public String actionDeleteDatDiferidosDet(ActionEvent evt) {
		try {

			selectedDatDiferidosDet = (DatDiferidosDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatDiferidosDet"));

			if (selectedDatDiferidosDet.getDatDiferidosDetId() == null) {
				dataDet.remove(selectedDatDiferidosDet);
			} else {
				Long datDiferidosDetId = new Long(selectedDatDiferidosDet.getDatDiferidosDetId());
				DatDiferidosDet entity = businessDelegator2View.getDatDiferidosDet(datDiferidosDetId);
				businessDelegator2View.deleteDatDiferidosDet(entity);
				dataDet.remove(selectedDatDiferidosDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		// caso 1 : la tabla transaccional no tiene valores
		Long datDiferidos = FacesUtils.checkLong(txtDatDiferidosId);
		if (datDiferidos != null) {
			selectedDatDiferidosDet = (DatDiferidosDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatDiferidosDet"));
			if (selectedDatDiferidosDet.getDatDiferidosDetId() != null) {
				Long datDiferidosDetId = selectedDatDiferidosDet.getDatDiferidosDetId().longValue();

				String columnaCell = evt.getColumn().getHeaderText();

				Object oldValue = evt.getOldValue();
				Object newValue = evt.getNewValue();

				if (newValue != null) {

					entityDet = null;
					entityDet = businessDelegator2View.getDatDiferidosDet(datDiferidosDetId);

					if (columnaCell.equals("Maq")) {

						Long maqId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(maqId);

						entityDet.setEquipoId(e);

					}

					entity = businessDelegator2View.getDatDiferidos(datDiferidos);
					entityDet.setDatDiferidos(entity);
					businessDelegator2View.updateDatDiferidosDet(entityDet);

					// entity = null;

					selectedDatDiferidosDet = null;
					entityDet = null;

					dataDet = null;
					dataDet = businessDelegator2View.getDataDatDiferidosDetByDiferidos(datDiferidos);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));

		}

	}

	public List<DatDiferidosDetDTO> getDatDiferidosDet1() {

		if (dataDet == null || dataDet.size() == 0) {
			return null;
		} else {
			return dataDet;
		}

	}

	public void action_agregarDatDiferidosDet() throws Exception {
	

			String equipos = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				for (int i = 0; i < selectedEquipo.size(); i++) {
					equipos = selectedEquipo.get(i);

					Double totalMaquinas = (double) selectedEquipo.size();

					Long equipoId = Long.parseLong(equipos);
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);
					String nombreEquipo = equipo.getCodigo();
					String nombreImplemento = "";
					Long implementoId = null;
					Equipo implemento = null;
					if (txtImplemento.getValue() != null) {
						implementoId = Long.parseLong(txtImplemento.getValue().toString());
						implemento = businessDelegatorView.getEquipo(implementoId);
						nombreImplemento =  implemento.getCodigo() +"-"+implemento.getNombre();
					}
					boolean existeProducto = false;

					if (dataDet == null) {
						dataDet = new ArrayList<DatDiferidosDetDTO>();
					}

					DatDiferidosDetDTO dto = new DatDiferidosDetDTO();

					dto.setEquipoId(equipo);
					dto.setCodEquipo(nombreEquipo);
					dto.setCodImplemento(nombreImplemento);
					dto.setImplementoId(implementoId);

					double subTotalValorTotal = 0;
					double impuestos = 0;
					double valorTotal = 0;

					dataDet.add(dto);

					nombreEquipo = null;

				}
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!, Falta registrar y agregar el detalle  "
							+ "Verifique que los campos " + "Maquinaria, labor, valor " + "" + "tengan valores. ", ""));
		}
		limpiar_pantalla();
	}

	public void limpiar_pantalla() {
		equipos = null;
		selectEquipo = null;
	}

	public void listarDiferidos() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long compania = new Long(getCompaniaIdSession());
			Long documento = 0L;
			documento = FacesUtils.checkLong(txtDocumento);

			if (documento == null) {
				documento = 0L;
			}

			Long centCost = 0L;
			centCost = FacesUtils.checkLong(txtCentCostConsulta);

			if (centCost == null) {
				centCost = 0L;
			}
			
			Long flagContratista = 0L;
			flagContratista = FacesUtils.checkLong(txtPersEmprConsulta);

			if (flagContratista == null) {
				flagContratista = 0L;
			}
			
			String numfactura = "0";
			numfactura = FacesUtils.checkString(txtDocumentoFactura);

			if (numfactura == null) {
				numfactura = "0";
			}
  
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_dat_diferidos(compania, fechaInicial, fechaFinal, documento,
						centCost,flagContratista,numfactura);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatDiferidos2 = (ConsultaCostosDiferidosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatDiferidos2"));
		try {

			Long datDiferidosId = selectedDatDiferidos2.getDatDiferidosId().longValue();
			Object[] condicion = { "datDiferidosId", true, datDiferidosId, "=" };
			List<DatDiferidos> lista = (datDiferidosId != null)
					? businessDelegator2View.findByCriteriaInDatDiferidos(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {

						Long borrarCuotas = businessDelegator2View.pr_borrar_dat_diferidos_cuotas(datDiferidosId);
						Long borrarDetalle = businessDelegator2View.pr_borrar_dat_diferidos_det(datDiferidosId);
						Long borrarGeneral = businessDelegator2View.pr_borrar_dat_diferidos(datDiferidosId);

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Proceso exitoso!", "El movimiento de compra fue eliminado exitosamente!!!"));

					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Upps!",
								"Para poder eliminar el movimiento de compra debe tener permisos de administrador "));

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

	public List<DatDiferidosCuotasDTO> getDataCuotas() {
		return dataCuotas;
	}

	public void setDataCuotas(List<DatDiferidosCuotasDTO> dataCuotas) {
		this.dataCuotas = dataCuotas;
	}

	public InputText getTxtNumeroFactura() {
		return txtNumeroFactura;
	}

	public void setTxtNumeroFactura(InputText txtNumeroFactura) {
		this.txtNumeroFactura = txtNumeroFactura;
	}

	public void listener_TipoDistribuccion() {

		String tipoDistri = FacesUtils.checkString(txtTipoTransaccion);

		if (tipoDistri != null) {

			if (tipoDistri.equals("distri_multiples_equipos")) {
				txtCategEquipId_CategoriaEquipo.setDisabled(true);
			//	txtEquipoId.setDisabled(false);
				txtCategEquipId_CategoriaEquipo.setValue(null);

			}
			if (tipoDistri.equals("distri_categorias")) {
				txtCategEquipId_CategoriaEquipo.setDisabled(false);
			//	txtEquipoId.setDisabled(true);
			//	txtEquipoId.setValue(null);
			}

			if (tipoDistri.equals("")) {
				txtCategEquipId_CategoriaEquipo.setDisabled(false);
			//	txtEquipoId.setDisabled(false);
			//	txtEquipoId.setValue(null);
				txtCategEquipId_CategoriaEquipo.setValue(null);
			}
		}
	}

	public SelectOneMenu getTxtCategEquipId_CategoriaEquipo() {
		return txtCategEquipId_CategoriaEquipo;
	}

	public void setTxtCategEquipId_CategoriaEquipo(SelectOneMenu txtCategEquipId_CategoriaEquipo) {
		this.txtCategEquipId_CategoriaEquipo = txtCategEquipId_CategoriaEquipo;
	}

	public SelectOneMenu getTxtTipoTransaccion() {
		return txtTipoTransaccion;
	}

	public void setTxtTipoTransaccion(SelectOneMenu txtTipoTransaccion) {
		this.txtTipoTransaccion = txtTipoTransaccion;
	}

	public List<ListaEquiposCategoriaDTO> getDataEquiposCategoriaDTO() {
		return dataEquiposCategoriaDTO;
	}

	public void setDataEquiposCategoriaDTO(List<ListaEquiposCategoriaDTO> dataEquiposCategoriaDTO) {
		this.dataEquiposCategoriaDTO = dataEquiposCategoriaDTO;
	}

	public SelectItem[] getSelectCategoriaEquipo() {

		if (categoriaEquipo == null || categoriaEquipo.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CategoriaEquipo> lista = businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null,
						null);
				selectCategoriaEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CategoriaEquipo categoriaEquipo : lista) {
					selectCategoriaEquipo[i] = new SelectItem(categoriaEquipo.getCategEquipId(),
							categoriaEquipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCategoriaEquipo;
	}

	public void setSelectCategoriaEquipo(SelectItem[] selectCategoriaEquipo) {
		this.selectCategoriaEquipo = selectCategoriaEquipo;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectItem[] getSelectContratista() {

		if (selectContratista == null || selectContratista.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="							
						, "tipoEmpresa", true, "4", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"};
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getCodigo() +"-"+contratista.getNombre());
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

	
	public SelectItem[] getSelectPersEmprConsulta() {

		if (selectPersEmprConsulta == null || selectPersEmprConsulta.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="							
						, "tipoEmpresa", true, "4", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"};
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectPersEmprConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectPersEmprConsulta[i] = new SelectItem(contratista.getPersEmprId(), contratista.getCodigo() +"-"+contratista.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPersEmprConsulta;
	}

 
	
	public SelectOneMenu getTxtPersEmprConsulta() {
		return txtPersEmprConsulta;
	}

	public void setTxtPersEmprConsulta(SelectOneMenu txtPersEmprConsulta) {
		this.txtPersEmprConsulta = txtPersEmprConsulta;
	}

	public void setSelectPersEmprConsulta(SelectItem[] selectPersEmprConsulta) {
		this.selectPersEmprConsulta = selectPersEmprConsulta;
	}

	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
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

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtCentCostConsulta() {
		return txtCentCostConsulta;
	}

	public void setTxtCentCostConsulta(SelectOneMenu txtCentCostConsulta) {
		this.txtCentCostConsulta = txtCentCostConsulta;
	}

	public void setSelectCentCostConsulta(SelectItem[] selectCentCostConsulta) {
		this.selectCentCostConsulta = selectCentCostConsulta;
	}

	public SelectItem[] getSelectCentCostConsulta() {

		if (selectCentCostConsulta == null || selectCentCostConsulta.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCostConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCostConsulta[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCostConsulta;
	}

	public InputText getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(InputText txtDocumento) {
		this.txtDocumento = txtDocumento;
	}

	public List<String> getSelectedEquipo() {
		selectedEquipo = null;
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=" };
				equipos = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
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
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(),Implemento.getCodigo()+"-"+ Implemento.getNombre());
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

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}
	public List<PersEmpr> getContratistas() throws Exception {
		if (contratistas == null || contratistas.size() == 0) {

			Object[] condicion = { "estado", true, "A", "="							
					, "tipoEmpresa", true, "4", "<>" 
					, "tipoEmpresa", true, "3", "<>"
					, "tipoEmpresa", true, "5", "<>"  };

			try {
				contratistas = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return contratistas;
	}

	public void setContratistas(List<PersEmpr> contratistas) {
		this.contratistas = contratistas;
	}

	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public InputText getTxtDocumentoFactura() {
		return txtDocumentoFactura;
	}

	public void setTxtDocumentoFactura(InputText txtDocumentoFactura) {
		this.txtDocumentoFactura = txtDocumentoFactura;
	}
	
	public void validarExistenciaFactura() throws Exception {
		Long persEmprId = FacesUtils.checkLong(txtPersEmprId_PersEmpr);
		String numFactura = FacesUtils.checkString(txtNumeroFactura);
		
		Object[] condicion = { "numeroFactura", true, numFactura, "=", "persEmpr.persEmprId", true, persEmprId, "="  };
		List<DatDiferidos> lista = (persEmprId != null)
				? businessDelegator2View.findByCriteriaInDatDiferidos(condicion, null, null)
				: null;

		if (lista != null && lista.size() > 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Upps!, La factura registrada ya se encuentra en el sistema, válide por favor",""));
		}
	}
}
