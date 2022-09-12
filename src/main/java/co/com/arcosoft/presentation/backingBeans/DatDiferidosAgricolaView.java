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
import co.com.arcosoft.modelo.DatDiferidosAgricola;
import co.com.arcosoft.modelo.DatDiferidosAgricolaDet;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDetDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasAgricolasDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCostosDiferidosDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
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
public class DatDiferidosAgricolaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatDiferidosAgricolaView.class);
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
	private List<DatDiferidosAgricolaDTO> data;
	private DatDiferidosAgricolaDTO selectedDatDiferidos;
	private DatDiferidosAgricola entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	/*
	 * private SelectOneMenu txtEquipoId; SelectItem[] selectEquipo; private
	 * List<Equipo> equipo;
	 */

	private int activeTapIndex = 0;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private CommandButton btnAgregar;

	private List<ConsultaCostosDiferidosDTO> data2;

	private InputNumber txtValorTotalAcumulado;

	private DatDiferidosAgricolaDetDTO selectedDatDiferidosDet;
	private DatDiferidosAgricolaDet entityDet;
	private ConsultaCostosDiferidosDTO selectedDatDiferidos2;

	/** Detalle ***/
	private List<DatDiferidosAgricolaDetDTO> dataDet;
	private List<DatDiferidosCuotasAgricolasDTO> dataCuotas;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputText txtNumeroFactura;

	private SelectOneMenu txtTipoTransaccion;
	
	private List<ListaNivel4DTO> dataNivel4DTO;
	private List<ListaEquiposCategoriaDTO> dataEquiposCategoriaDTO;

	public DatDiferidosAgricolaView() {
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

		if (txtTipoTransaccion != null) {
			txtTipoTransaccion.setValue(null);
			txtTipoTransaccion.setDisabled(false);
		}

		if (txtAnioAplicacion != null) {
			txtAnioAplicacion.setValue(null);
			txtAnioAplicacion.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtNumeroFactura != null) {
			txtNumeroFactura.setValue(null);
			txtNumeroFactura.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			Long compania = new Long(getCompaniaIdSession());
			txtConsecutivo.setValue(businessDelegator2View.consultarConsecutivoDatDiferidosAgricola(compania));
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
		
		if (selectedDatDiferidos2 != null) {
			selectedDatDiferidos2 = null;			
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

			Long datDiferidosId = selectedDatDiferidos2.getDatDiferidosAgricolaId().longValue();
			Object[] condicion = { "datDiferidosAgricolaId", true, datDiferidosId, "=" };
			List<DatDiferidosAgricola> lista = (datDiferidosId != null)
					? businessDelegator2View.findByCriteriaInDatDiferidosAgricola(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);

				txtTipoTransaccion.setValue(entity.getTipoTransaccion());

				txtNumeroFactura.setValue(entity.getNumeroFactura());
				txtNumeroFactura.setDisabled(false);
				txtDetalleNota.setValue(entity.getDetalleNota());
				txtDetalleNota.setDisabled(false);
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				
				if (entity.getLabor() != null) {
					txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
				}				 

				txtLaborId_Labor.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtPeriodos.setValue(entity.getPeriodos());
				txtPeriodos.setDisabled(false);
				txtValorInicial.setValue(entity.getValorInicial());
				txtValorInicial.setDisabled(false);
				txtDatDiferidosId.setValue(entity.getDatDiferidosAgricolaId());
				txtDatDiferidosId.setDisabled(true);
				btnSave.setDisabled(false);
				txtTipoTransaccion.setValue(entity.getTipoTransaccion());
				txtTipoTransaccion.setDisabled(false);

				String tipoDistri = entity.getTipoTransaccion();

				if (tipoDistri != null) {

					if (tipoDistri.equals("distri_multiples_lotes")) {
						txtNivel2Id_Nivel2.setDisabled(true);
						txtNivel4Id_Nivel4.setDisabled(false);

					}
					if (tipoDistri.equals("distri_hacienda")) {
						txtNivel2Id_Nivel2.setDisabled(false);
						txtNivel4Id_Nivel4.setDisabled(true);

					}

					if (tipoDistri.equals("")) {
						txtNivel2Id_Nivel2.setDisabled(false);
						txtNivel4Id_Nivel4.setDisabled(false);
					}
				}

				Long id = FacesUtils.checkLong(txtDatDiferidosId);
				
				dataDet = null;
				dataDet = businessDelegator2View.getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(id);
				
				dataCuotas = null;
				dataCuotas = businessDelegator2View.getDataDatDiferidosCuotasAgricolasByDatDiferidosAgricola(id);

				
				double valorTotal = 0;
				if(dataCuotas!=null && dataCuotas.size()>=0) {
				 for( DatDiferidosCuotasAgricolasDTO data1 : dataCuotas) {
			        
			        	valorTotal += data1.getValorCuota().doubleValue();
			        }
				}
				
				txtValorTotalAcumulado.setValue(valorTotal);
				txtValorTotalAcumulado.setDisabled(false);

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
			if ((selectedDatDiferidos2 == null) && (entity == null)) {
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
			entity = new DatDiferidosAgricola();

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);
			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
			entity.setAnioAplicacion(FacesUtils.checkLong(txtAnioAplicacion));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setNumeroFactura(FacesUtils.checkString(txtNumeroFactura));
			entity.setDetalleAplicacion(FacesUtils.checkString(txtDetalleAplicacion));
			entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaCreacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
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

			String tipoTransaccion = "";
			if (txtTipoTransaccion.getValue() != null) {
				
				tipoTransaccion = txtTipoTransaccion.getValue().toString();
				
				if (tipoTransaccion.equals("distri_hacienda")) {
					
					String nivel2Id = FacesUtils.checkString(txtNivel2Id_Nivel2);
					
					if (nivel2Id != null) {
						
						dataNivel4DTO = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
						
						if (dataNivel4DTO != null && dataNivel4DTO.size() > 0) {
							
							businessDelegator2View.saveDatDiferidosAgricolaVer2(entity, dataNivel4DTO, dataCuotas);
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
				
				if (tipoTransaccion.equals("distri_multiples_lotes")) {
					
					if (dataDet != null) {
						businessDelegator2View.saveDatDiferidosAgricola(entity, dataDet, dataCuotas);
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
				Long datDiferidosId = new Long(selectedDatDiferidos.getDatDiferidosAgricolaId());
				entity = businessDelegator2View.getDatDiferidosAgricola(datDiferidosId);
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
			
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);

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
			
			String tipoTransaccion = "";			
			if (txtTipoTransaccion.getValue() != null) {
				
				tipoTransaccion = txtTipoTransaccion.getValue().toString();
				
				if (tipoTransaccion.equals("distri_hacienda")) {
					
					String nivel2Id = FacesUtils.checkString(txtNivel2Id_Nivel2);
					
					if (nivel2Id != null) {

						dataNivel4DTO = businessDelegatorView.consultarListaNivel4(compania, nivel2Id);
						
						if (dataNivel4DTO != null && dataNivel4DTO.size() > 0) {

							Long datDiferidosId = FacesUtils.checkLong(txtDatDiferidosId);
							
							Long borrarDiferidosDet = businessDelegator2View.pr_borrar_dat_diferidos_agricola_det(datDiferidosId);
							businessDelegator2View.updateDatDiferidosAgricolaVer2(entity, dataNivel4DTO, dataCuotas);
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

				if (tipoTransaccion.equals("distri_multiples_lotes")) {
					
					if (dataDet != null) {

						businessDelegator2View.updateDatDiferidosAgricola(entity, dataDet, dataCuotas);
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
			selectedDatDiferidos = (DatDiferidosAgricolaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatDiferidos"));

			Long datDiferidosId = new Long(selectedDatDiferidos.getDatDiferidosAgricolaId());
			entity = businessDelegator2View.getDatDiferidosAgricola(datDiferidosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datDiferidosId = FacesUtils.checkLong(txtDatDiferidosId);
			entity = businessDelegator2View.getDatDiferidosAgricola(datDiferidosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatDiferidosAgricola(entity);
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
			selectedDatDiferidos = (DatDiferidosAgricolaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatDiferidos"));

			Long datDiferidosId = new Long(selectedDatDiferidos.getDatDiferidosAgricolaId());
			entity = businessDelegator2View.getDatDiferidosAgricola(datDiferidosId);
			businessDelegator2View.deleteDatDiferidosAgricola(entity);
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
		
			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
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
			businessDelegator2View.updateDatDiferidosAgricola(entity, null, null);
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

	public List<DatDiferidosAgricolaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatDiferidosAgricola();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatDiferidosAgricolaDTO> DatDiferidosAgricolaDTO) {
		this.data = DatDiferidosAgricolaDTO;
	}

	public DatDiferidosAgricolaDTO getSelectedDatDiferidos() {
		return selectedDatDiferidos;
	}

	public void setSelectedDatDiferidos(DatDiferidosAgricolaDTO datDiferidos) {
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

	public DatDiferidosAgricolaDetDTO getSelectedDatDiferidosDet() {
		return selectedDatDiferidosDet;
	}

	public void setSelectedDatDiferidosDet(DatDiferidosAgricolaDetDTO selectedDatDiferidosDet) {
		this.selectedDatDiferidosDet = selectedDatDiferidosDet;
	}

	public DatDiferidosAgricolaDet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatDiferidosAgricolaDet entityDet) {
		this.entityDet = entityDet;
	}

	public ConsultaCostosDiferidosDTO getSelectedDatDiferidos2() {
		return selectedDatDiferidos2;
	}

	public void setSelectedDatDiferidos2(ConsultaCostosDiferidosDTO selectedDatDiferidos2) {
		this.selectedDatDiferidos2 = selectedDatDiferidos2;
	}

	public List<DatDiferidosAgricolaDetDTO> getDataDet() {
		return dataDet;
	}

	public void setDataDet(List<DatDiferidosAgricolaDetDTO> dataDet) {
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

	public String actionDeleteDatDiferidosDet(ActionEvent evt) {
		try {

			selectedDatDiferidosDet = (DatDiferidosAgricolaDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatDiferidosDet"));

			if (selectedDatDiferidosDet.getDatDiferidosAgricolaDetId() == null) {
				dataDet.remove(selectedDatDiferidosDet);
			} else {
				Long datDiferidosDetId = new Long(selectedDatDiferidosDet.getDatDiferidosAgricolaDetId());
				DatDiferidosAgricolaDet entity = businessDelegator2View.getDatDiferidosAgricolaDet(datDiferidosDetId);
				businessDelegator2View.deleteDatDiferidosAgricolaDet(entity);
				dataDet.remove(selectedDatDiferidosDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		Long datDiferidos = FacesUtils.checkLong(txtDatDiferidosId);
		if (datDiferidos != null) {
			selectedDatDiferidosDet = (DatDiferidosAgricolaDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatDiferidosDet"));
			if (selectedDatDiferidosDet.getDatDiferidosAgricolaDetId() != null) {
				Long datDiferidosDetId = selectedDatDiferidosDet.getDatDiferidosAgricolaDetId().longValue();

				String columnaCell = evt.getColumn().getHeaderText();

				Object oldValue = evt.getOldValue();
				Object newValue = evt.getNewValue();

				if (newValue != null) {

					entityDet = null;
					entityDet = businessDelegator2View.getDatDiferidosAgricolaDet(datDiferidosDetId);

					if (columnaCell.equals("Suerte")) {

						Long nivel4Id = new Long(evt.getNewValue().toString());
						Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);

						entityDet.setNivel4(nivel4);
					}

					entity = businessDelegator2View.getDatDiferidosAgricola(datDiferidos);
					entityDet.setDatDiferidosAgricola(entity);
					businessDelegator2View.updateDatDiferidosAgricolaDet(entityDet);

					selectedDatDiferidosDet = null;
					entityDet = null;

					dataDet = null;
					dataDet = businessDelegator2View.getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(datDiferidos);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));

		}

	}

	public List<DatDiferidosAgricolaDetDTO> getDatDiferidosDet1() {

		if (dataDet == null || dataDet.size() == 0) {
			return null;
		} else {
			return dataDet;
		}

	}

	public void action_agregarDatDiferidosDet() throws Exception {
		if (txtNivel4Id_Nivel4.getValue() != null) {

			Long nivel4Id = null;
			Nivel4 nivel4 = null;
			String codigoNivel4 = null;
			Long etapaId = null;
			Long variedId = null;
			Double areaNeta = null;
			
			if (txtNivel4Id_Nivel4.getValue() != null) {
				nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
				nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				codigoNivel4 = nivel4.getCodigo();
				Etapa etapa = nivel4.getEtapa();
				variedId = nivel4.getVariedad();
				areaNeta = nivel4.getAreaNeta();
				if (etapa != null) {
					etapaId = etapa.getEtapaId();
				}
			}

			if (dataDet == null) {
				dataDet = new ArrayList<DatDiferidosAgricolaDetDTO>();
			}

			DatDiferidosAgricolaDetDTO dto = new DatDiferidosAgricolaDetDTO();

			dto.setNivel4Id_Nivel4(nivel4);
			dto.setCodigoNivel4(codigoNivel4);
			dto.setEtapaId(etapaId);
			dto.setVariedadId(variedId);
			dto.setAreaNeta(areaNeta);

			dataDet.add(dto);

			codigoNivel4 = null;
			nivel4 = null;
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!, Falta registrar y agregar el detalle  "
							+ "Verifique que los campos " + "Maquinaria, labor, valor " + "" + "tengan valores. ", ""));
		}
		
		limpiar_pantalla();
	}

	public void limpiar_pantalla() {

		txtNivel4Id_Nivel4.setValue(null);
	}

	public void listarDiferidos() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));

			Long compania = new Long(getCompaniaIdSession());
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_dat_diferidos_agricola(compania, fechaInicial, fechaFinal);
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

			Long datDiferidosId = selectedDatDiferidos2.getDatDiferidosAgricolaId().longValue();
			Object[] condicion = { "datDiferidosAgricolaId", true, datDiferidosId, "=" };
			List<DatDiferidosAgricola> lista = (datDiferidosId != null)
					? businessDelegator2View.findByCriteriaInDatDiferidosAgricola(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {

						Long borrarDetalle = businessDelegator2View.pr_borrar_dat_diferidos_agricola_det(datDiferidosId);
						Long borrarCuotas = businessDelegator2View.pr_borrar_dat_diferidos_cuotas_agricola(datDiferidosId);
						Long borrarGeneral = businessDelegator2View.pr_borrar_dat_diferidos_agricola(datDiferidosId);

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

	public InputText getTxtNumeroFactura() {
		return txtNumeroFactura;
	}

	public void setTxtNumeroFactura(InputText txtNumeroFactura) {
		this.txtNumeroFactura = txtNumeroFactura;
	}

	public void listener_TipoDistribuccion() {

		String tipoDistri = FacesUtils.checkString(txtTipoTransaccion);

		if (tipoDistri != null) {

			if (tipoDistri.equals("distri_hacienda")) {
				txtNivel2Id_Nivel2.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(true);
				txtNivel4Id_Nivel4.setValue(null);

			} if (tipoDistri.equals("distri_multiples_lotes")) {
				txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel2Id_Nivel2.setDisabled(true);
				txtNivel2Id_Nivel2.setValue(null);
				
			} if (tipoDistri.equals("")) {
				txtNivel4Id_Nivel4.setDisabled(false);
				txtNivel2Id_Nivel2.setDisabled(false);
				txtNivel2Id_Nivel2.setValue(null);
				txtNivel4Id_Nivel4.setValue(null);
			}
		}
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

	public SelectItem[] getSelectNivel4() {

		if (nivel4 == null || nivel4.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4 : lista) {
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(), nivel4.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4;
	}

	public void setSelectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}
	
	public SelectItem[] getSelectNivel2() {

		if (nivel2 == null || nivel2.size() == 0) {

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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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

	public List<Nivel4> getNivel4() {
		return nivel4;
	}

	public void setNivel4(List<Nivel4> nivel4) {
		this.nivel4 = nivel4;
	}

	public List<ListaNivel4DTO> getDataNivel4DTO() {
		return dataNivel4DTO;
	}

	public void setDataNivel4DTO(List<ListaNivel4DTO> dataNivel4DTO) {
		this.dataNivel4DTO = dataNivel4DTO;
	}

	public List<DatDiferidosCuotasAgricolasDTO> getDataCuotas() {
		return dataCuotas;
	}

	public void setDataCuotas(List<DatDiferidosCuotasAgricolasDTO> dataCuotas) {
		this.dataCuotas = dataCuotas;
	}

}
