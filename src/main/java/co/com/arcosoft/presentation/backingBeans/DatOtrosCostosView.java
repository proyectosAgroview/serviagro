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
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.CuentaContable;
import co.com.arcosoft.modelo.DatOtrosCostos;
import co.com.arcosoft.modelo.DatOtrosCostosDetalle;
import co.com.arcosoft.modelo.DatOtrosCostosNivel4;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDetalleDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
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
public class DatOtrosCostosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputTextarea txtObservacionAnularReg;
	private SelectOneMenu txtReglaDistribuccion;
	private InputText txtSerieFactura;
	private SelectOneMenu txtTipoTransaccion;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatOtrosCostosId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatOtrosCostosDTO> data;
	private DatOtrosCostosDTO selectedDatOtrosCostos;
	private DatOtrosCostos entity;
	private DatOtrosCostosNivel4 entityOtrosCostsNivel4;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private Calendar txtFechaInicial;

	private SelectOneMenu txtInfraId;
	SelectItem[] selectInfraestructura;
	private List<Infraestructura> infraestructura;

	private SelectOneMenu txtEquipoId;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputNumber txtPlanilla;

	/** detalle nivel4 */

	private SelectOneMenu txtNivel1Id;
	SelectItem[] selectNivel1;
	private List<Nivel1> nivel1;

	private SelectOneMenu txtNivel3Id;
	SelectItem[] selectNivel3;
	private List<Nivel3> nivel3;

	private SelectOneMenu txtNivel2Id_Nivel2;
	SelectItem[] selectNivel2;
	private List<Nivel2> nivel2;
	
	SelectItem[] selectNivel2Edit;
	private List<Nivel2> nivel2Edit;
	
	SelectItem[] selectNivel4Edit;
	private List<Nivel4> nivel4Edit;
	
	private SelectOneMenu txtNivel2IdIndicador;
	SelectItem[] selectNivel2Indicador;
	private List<Nivel2> nivel2Indicador;

	private SelectOneMenu txtNivel4Id_Nivel4;
	SelectItem[] selectNivel4;
	private List<Nivel4> nivel4;

	private InputText txtNivel4Nombre;
	private InputText txtNivel2Nombre;

	private CommandButton btnAgregar;

	private List<DatOtrosCostosNivel4DTO> dataNivel4;
	private DatOtrosCostosNivel4DTO selectedDatOtrosCostosNivel4;
	private List<ListaNivel4DTO> dataLotes;
	
	/*** Detalle otros costos ***/

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtCuentaContable;
	SelectItem[] selectCuentaContable;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;

	private InputText txtNumFactura;
	private Spinner txtValorTotal;
	private InputTextarea txtObservacion;
	
	private List<DatOtrosCostosDetalleDTO> dataDetalle;
	private DatOtrosCostosDetalleDTO selectedDatOtrosCostosDet;
	private DatOtrosCostosDetalle entityDetalle;

	private CommandButton btnAgregarDetalle;
	
	
	private List<String> selectedNivel2;
	private List<Nivel2> fincas;

	private SelectOneMenu txtTipoDistri;
	
	/*****/

	private int activeTapIndex = 0;
	private String moduloActivo;

	public DatOtrosCostosView() {
		super();
	}
	
	public String action_new() {
		action_clear();
		selectedDatOtrosCostos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatOtrosCostos = null;
		PrimeFaces.current().resetInputs(":dialogDatOtrosCostos :frm");
		activeTapIndex = 0;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEquipoId != null) {
			txtEquipoId.setValue(null);
			txtEquipoId.setDisabled(false);
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

		if (txtInfraId != null) {
			txtInfraId.setValue(null);
			txtInfraId.setDisabled(false);
		}

		if (txtNumFactura != null) {
			txtNumFactura.setValue(null);
			txtNumFactura.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtReglaDistribuccion != null) {
			txtReglaDistribuccion.setValue(null);
			txtReglaDistribuccion.setDisabled(false);
		}

		if (txtSerieFactura != null) {
			txtSerieFactura.setValue(null);
			txtSerieFactura.setDisabled(false);
		}

		if (txtTipoTransaccion != null) {
			txtTipoTransaccion.setValue(null);
			txtTipoTransaccion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(false);
		}

		if (txtCuentaContable != null) {
			txtCuentaContable.setValue(null);
			txtCuentaContable.setDisabled(false);
		}

		if (txtElemCostoId_ElementoCosto != null) {
			txtElemCostoId_ElementoCosto.setValue(null);
			txtElemCostoId_ElementoCosto.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
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

		if (txtDatOtrosCostosId != null) {
			txtDatOtrosCostosId.setValue(null);
			txtDatOtrosCostosId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(false);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(false);
		}

		/************ + Detalle otros costos nivel4 ****/

		if (txtNivel2Id_Nivel2 != null) {
			txtNivel2Id_Nivel2.setValue(null);
			txtNivel2Id_Nivel2.setDisabled(false);
		}

		if (txtNivel4Id_Nivel4 != null) {
			txtNivel4Id_Nivel4.setValue(null);
			txtNivel4Id_Nivel4.setDisabled(false);
		}
		if (txtNivel1Id != null) {
			txtNivel1Id.setValue(null);
			txtNivel1Id.setDisabled(false);
		}

		if (txtNivel3Id != null) {
			txtNivel3Id.setValue(null);
			txtNivel3Id.setDisabled(false);
		}

		if (txtNivel2Nombre != null) {
			txtNivel2Nombre.setValue(null);
			txtNivel2Nombre.setDisabled(false);
		}
		if (txtNivel4Nombre != null) {
			txtNivel4Nombre.setValue(null);
			txtNivel4Nombre.setDisabled(false);
		}
		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}

		if (dataNivel4 != null) {
			dataNivel4 = null;
		}

		if (dataDetalle != null) {
			dataDetalle = null;
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

		selectedDatOtrosCostos = (DatOtrosCostosDTO) (evt.getComponent().getAttributes().get("selectedDatOtrosCostos"));
		try {

			Long consecutivo = selectedDatOtrosCostos.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatOtrosCostos> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatOtrosCostos(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
			//	txtFechaInicial.setValue(entity.getFechaInicial());
			//	txtFechaInicial.setDisabled(false);

				// txtEquipoId.setValue(selectedDatOtrosCostos.getEquipoId());
				// txtEquipoId.setDisabled(false);
				
				
				
				
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				// txtSerieFactura.setValue(selectedDatOtrosCostos.getSerieFactura());
				// txtSerieFactura.setDisabled(false);
				txtValorTotal.setValue(entity.getValorTotal());
				txtValorTotal.setDisabled(false);
				txtDatOtrosCostosId.setValue(selectedDatOtrosCostos.getDatOtrosCostosId());
				txtDatOtrosCostosId.setDisabled(true);
				btnSave.setDisabled(false);
			//	txtInfraId.setValue(entity.getInfraId());

				txtTipoTransaccion.setValue(entity.getTipoTransaccion());
			
				String tipoTransaccion = "";
				if (!txtTipoTransaccion.getValue().equals("")) {
					tipoTransaccion = (txtTipoTransaccion.getValue().toString());

					if (!txtTipoTransaccion.getValue().equals("")) {
						tipoTransaccion = (txtTipoTransaccion.getValue().toString());
						if (tipoTransaccion.equals("distri_todos_lotes_hacienda")) {
							txtNivel1Id.setDisabled(true);
							txtNivel2Id_Nivel2.setDisabled(true);
							txtNivel3Id.setDisabled(true);
							txtNivel4Id_Nivel4.setDisabled(true);
							btnAgregar.setDisabled(true);
						//	txtInfraId.setDisabled(true);
							txtNivel2IdIndicador.setDisabled(false);
							txtTipoTransaccion.setDisabled(false);
							if(entity.getNivel2Indicador()!=null) {
								txtNivel2IdIndicador.setValue(entity.getNivel2Indicador().getNivel2Id());
							}
							
							
							 
						}
						if (tipoTransaccion.equals("distri_lotes_informados")) {
							txtTipoTransaccion.setDisabled(false);
							txtNivel1Id.setDisabled(false);
							txtNivel2Id_Nivel2.setDisabled(false);
							txtNivel3Id.setDisabled(false);
							txtNivel4Id_Nivel4.setDisabled(false);
							btnAgregar.setDisabled(false);
						//	txtInfraId.setDisabled(true);
							txtNivel2IdIndicador.setDisabled(true);
						}
						

						
						
						if (tipoTransaccion.equals("distri_todos_lotes")) {
							txtTipoTransaccion.setDisabled(false);
							txtNivel1Id.setDisabled(true);
							txtNivel2Id_Nivel2.setDisabled(true);
							txtNivel3Id.setDisabled(true);
							txtNivel4Id_Nivel4.setDisabled(true);
							btnAgregar.setDisabled(true);
						//	txtInfraId.setDisabled(true);
							txtNivel2IdIndicador.setDisabled(true);

						}
						if (tipoTransaccion.equals("distri_multiples_fincas")) {
							txtTipoTransaccion.setDisabled(true);
							txtNivel1Id.setDisabled(true);
							txtNivel2Id_Nivel2.setDisabled(true);
							txtNivel3Id.setDisabled(true);
							txtNivel4Id_Nivel4.setDisabled(true);
							btnAgregar.setDisabled(true);
							//txtInfraId.setDisabled(true);
							txtNivel2IdIndicador.setDisabled(true);

						}
						
					}
				}

				Long id = FacesUtils.checkLong(txtDatOtrosCostosId);

				dataNivel4 = null;
				dataNivel4 = businessDelegatorView.getDataDatOtrosCostosNivel4ByNivel4(id);
				
				dataDetalle = null;
				dataDetalle = businessDelegator2View.getDataDatOtrosCostosDetalleByOtrosCostos(id);
				
			//	txtElemCostoId_ElementoCosto.setDisabled(false);
				txtLaborId_Labor.setDisabled(false);
				txtPersEmprId_PersEmpr.setDisabled(false);
				txtNumFactura.setDisabled(false);
				txtObservacion.setDisabled(false);
				txtCuentaContable.setDisabled(false);

				activeTapIndex = 0;

				setShowDialog(true);

			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	
	
	public String action_editMultiplesFincas(ActionEvent evt) {

		selectedDatOtrosCostos = (DatOtrosCostosDTO) (evt.getComponent().getAttributes().get("selectedDatOtrosCostos"));
		try {

			Long consecutivo = selectedDatOtrosCostos.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatOtrosCostos> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatOtrosCostos(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
			//	txtFechaInicial.setValue(entity.getFechaInicial());
			//	txtFechaInicial.setDisabled(false);

				// txtEquipoId.setValue(selectedDatOtrosCostos.getEquipoId());
				// txtEquipoId.setDisabled(false);
				
				
				
				
				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);
				// txtSerieFactura.setValue(selectedDatOtrosCostos.getSerieFactura());
				// txtSerieFactura.setDisabled(false);
				txtValorTotal.setValue(entity.getValorTotal());
				txtValorTotal.setDisabled(false);
				txtDatOtrosCostosId.setValue(selectedDatOtrosCostos.getDatOtrosCostosId());
				txtDatOtrosCostosId.setDisabled(true);
				btnSave.setDisabled(false);
			//	txtInfraId.setValue(entity.getInfraId());

				txtTipoTransaccion.setValue(entity.getTipoTransaccion());
			
				String tipoTransaccion = "";
				if (!txtTipoTransaccion.getValue().equals("")) {
					tipoTransaccion = (txtTipoTransaccion.getValue().toString());

					if (!txtTipoTransaccion.getValue().equals("")) {
						tipoTransaccion = (txtTipoTransaccion.getValue().toString());
						if (tipoTransaccion.equals("distri_todos_lotes_hacienda")) {
							txtNivel1Id.setDisabled(true);
							txtNivel2Id_Nivel2.setDisabled(true);
							txtNivel3Id.setDisabled(true);
							txtNivel4Id_Nivel4.setDisabled(true);
							btnAgregar.setDisabled(true);
						//	txtInfraId.setDisabled(true);
						//	txtNivel2IdIndicador.setDisabled(false);
							txtTipoTransaccion.setDisabled(false);
						//	if(entity.getNivel2Indicador()!=null) {
						//		txtNivel2IdIndicador.setValue(entity.getNivel2Indicador().getNivel2Id());
						//	}
							
							
							 
						}
						if (tipoTransaccion.equals("distri_lotes_informados")) {
							txtTipoTransaccion.setDisabled(false);
							txtNivel1Id.setDisabled(false);
							txtNivel2Id_Nivel2.setDisabled(false);
							txtNivel3Id.setDisabled(false);
							txtNivel4Id_Nivel4.setDisabled(false);
							btnAgregar.setDisabled(false);
						//	txtInfraId.setDisabled(true);
						//	txtNivel2IdIndicador.setDisabled(true);
						}
						

						
						
						if (tipoTransaccion.equals("distri_todos_lotes")) {
							txtTipoTransaccion.setDisabled(false);
							txtNivel1Id.setDisabled(true);
							txtNivel2Id_Nivel2.setDisabled(true);
							txtNivel3Id.setDisabled(true);
							txtNivel4Id_Nivel4.setDisabled(true);
							btnAgregar.setDisabled(true);
						//	txtInfraId.setDisabled(true);
							//txtNivel2IdIndicador.setDisabled(true);

						}
						if (tipoTransaccion.equals("distri_multiples_fincas")) {
							txtTipoTransaccion.setDisabled(true);
							txtNivel1Id.setDisabled(true);
							txtNivel2Id_Nivel2.setDisabled(true);
							txtNivel3Id.setDisabled(true);
							txtNivel4Id_Nivel4.setDisabled(true);
							btnAgregar.setDisabled(true);
							//txtInfraId.setDisabled(true);
						//	txtNivel2IdIndicador.setDisabled(true);

						}
						
					}
				}

				Long id = FacesUtils.checkLong(txtDatOtrosCostosId);

				dataNivel4 = null;
				dataNivel4 = businessDelegatorView.getDataDatOtrosCostosNivel4ByNivel4(id);
				
				dataDetalle = null;
				dataDetalle = businessDelegator2View.getDataDatOtrosCostosDetalleByOtrosCostos(id);
				
			//	txtElemCostoId_ElementoCosto.setDisabled(false);
				txtLaborId_Labor.setDisabled(false);
				txtPersEmprId_PersEmpr.setDisabled(false);
				txtNumFactura.setDisabled(false);
				txtObservacion.setDisabled(false);
				txtCuentaContable.setDisabled(false);

				activeTapIndex = 0;

				setShowDialog(true);

			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}
	public void listener_VerificarTipoTransaccion() {

		String tipoTransaccion = "";

		if (!txtTipoTransaccion.getValue().equals("")) {
			tipoTransaccion = (txtTipoTransaccion.getValue().toString());
			if (tipoTransaccion.equals("distri_todos_lotes_hacienda")) {
				txtNivel1Id.setDisabled(true);
				txtNivel2Id_Nivel2.setDisabled(true);
				txtNivel3Id.setDisabled(true);
				txtNivel4Id_Nivel4.setDisabled(true);
				btnAgregar.setDisabled(true);
			//	txtInfraId.setDisabled(true);
				txtNivel2IdIndicador.setDisabled(false);
				selectedNivel2 =null;
				

			}
			if (tipoTransaccion.equals("distri_lotes_informados")) {
				txtNivel1Id.setDisabled(false);
				txtNivel2Id_Nivel2.setDisabled(false);
				txtNivel3Id.setDisabled(false);
				txtNivel4Id_Nivel4.setDisabled(false);
				btnAgregar.setDisabled(false);
				//txtInfraId.setDisabled(true);
				txtNivel2IdIndicador.setDisabled(true);
				selectedNivel2 =null;
			}
			
			if (tipoTransaccion.equals("distri_todos_lotes")) {
				txtNivel1Id.setDisabled(true);
				txtNivel2Id_Nivel2.setDisabled(true);
				txtNivel3Id.setDisabled(true);
				txtNivel4Id_Nivel4.setDisabled(true);
				btnAgregar.setDisabled(true);
				//txtInfraId.setDisabled(true);
				txtNivel2IdIndicador.setDisabled(true);
				selectedNivel2 =null;

			}
			if (tipoTransaccion.equals("distri_multiples_fincas")) {
				txtNivel1Id.setDisabled(true);
				txtNivel2Id_Nivel2.setDisabled(true);
				txtNivel3Id.setDisabled(true);
				txtNivel4Id_Nivel4.setDisabled(true);
				btnAgregar.setDisabled(true);
				//txtInfraId.setDisabled(true);
				txtNivel2IdIndicador.setDisabled(true);

			}
			
			
		}
	}

	public String action_save() {
		try {
			if ((selectedDatOtrosCostos == null) && (entity == null)) {
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
			entity = new DatOtrosCostos();

			// Long datOtrosCostosId =
			// FacesUtils.checkLong(txtDatOtrosCostosId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);

			entity.setConsecutivo((businessDelegatorView.consultarConsecutivoOtrosCostos(compania)));
			// entity.setDatOtrosCostosId(datOtrosCostosId);
			entity.setEquipoId(FacesUtils.checkLong(txtEquipoId));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaRegistro));

			String tipoTransaccion = "";
			if (!txtTipoTransaccion.getValue().equals("")) {
				tipoTransaccion = (txtTipoTransaccion.getValue().toString());				
				if (tipoTransaccion.equals("distri_todos_lotes_hacienda")) {
					if (txtNivel2IdIndicador.getValue() != null) {
						entity.setNivel2Indicador((FacesUtils.checkLong(txtNivel2IdIndicador) != null)
								? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2IdIndicador)) : null);
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!, Verifique que el campo Hacienda tenga valores.", ""));
					}
				}
			}

			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setReglaDistribuccion(FacesUtils.checkString(txtReglaDistribuccion));
			entity.setSerieFactura(FacesUtils.checkString(txtSerieFactura));
			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
			
			if (txtTipoTransaccion.getValue() != null) {
				tipoTransaccion = txtTipoTransaccion.getValue().toString();
				if (tipoTransaccion.equals("distri_todos_lotes_hacienda") &&  txtNivel2IdIndicador.getValue()!=null){
					String idNivel2 = FacesUtils.checkString(txtNivel2IdIndicador) ;
					dataLotes = businessDelegatorView.consultarListaNivel4(compania, idNivel2);
					businessDelegatorView.saveDatOtrosCostosVer2(entity, dataLotes, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + " Número consecutivo: "
							+ (businessDelegatorView.consultarConsecutivoOtrosCostos(compania) - 1));
					action_clear();
				}
				
				if (tipoTransaccion.equals("distri_todos_lotes")){
					//Long idNivel2 = FacesUtils.checkLong(txtNivel2IdIndicador) ;
					dataLotes = businessDelegatorView.consultarListaNivel4(compania, "0");
					businessDelegatorView.saveDatOtrosCostosVer2(entity, dataLotes, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + " Número consecutivo: "
							+ (businessDelegatorView.consultarConsecutivoOtrosCostos(compania) - 1));
					action_clear();
				}
				
				if (tipoTransaccion.equals("distri_lotes_informados")) {
					businessDelegatorView.saveDatOtrosCostos(entity, dataNivel4, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + " Número consecutivo: "
							+ (businessDelegatorView.consultarConsecutivoOtrosCostos(compania) - 1));
					action_clear();
				}
				
				if (tipoTransaccion.equals("distri_multiples_fincas") &&  (selectedNivel2 != null && selectedNivel2.size() > 0)){
					String fincasSeleccionadas = "";
					fincasSeleccionadas = selectedNivel2.get(0);
					for (int i = 1; i < selectedNivel2.size(); i++) {
						fincasSeleccionadas += "," + selectedNivel2.get(i);
					}
					
				//	fincasSeleccionadas = fincasSeleccionadas ;
					dataLotes = businessDelegatorView.consultarListaNivel4(compania, fincasSeleccionadas);
					businessDelegatorView.saveDatOtrosCostosVer2(entity, dataLotes, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + " Número consecutivo: "
							+ (businessDelegatorView.consultarConsecutivoOtrosCostos(compania) - 1));
					action_clear();
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
				Long datOtrosCostosId = new Long(selectedDatOtrosCostos.getDatOtrosCostosId());
				entity = businessDelegatorView.getDatOtrosCostos(datOtrosCostosId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);

			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setEquipoId(FacesUtils.checkLong(txtEquipoId));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaRegistro));

			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setReglaDistribuccion(FacesUtils.checkString(txtReglaDistribuccion));
			entity.setSerieFactura(FacesUtils.checkString(txtSerieFactura));
			entity.setTipoTransaccion(FacesUtils.checkString(txtTipoTransaccion));
			
			String tipoTransaccion = "";
				if (!txtTipoTransaccion.getValue().equals("")) {
				tipoTransaccion = (txtTipoTransaccion.getValue().toString());
				if (tipoTransaccion.equals("distri_todos_lotes_hacienda")) {
					if (txtNivel2IdIndicador.getValue() != null) {
						entity.setNivel2Indicador((FacesUtils.checkLong(txtNivel2IdIndicador) != null)
								? businessDelegatorView.getNivel2(FacesUtils.checkLong(txtNivel2IdIndicador)) : null);
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!, Verifique que el campo  Hacienda  tenga valores.", ""));
					}
				}
			}
				Long datOtrosCostosId = entity.getDatOtrosCostosId();
			if (txtTipoTransaccion.getValue() !=null) {
				tipoTransaccion = txtTipoTransaccion.getValue().toString();
				if(tipoTransaccion.equals("distri_todos_lotes_hacienda") &&  txtNivel2IdIndicador.getValue()!=null){
					String idNivel2 = FacesUtils.checkString(txtNivel2IdIndicador) ;
					dataLotes = businessDelegatorView.consultarListaNivel4(compania, idNivel2);
					Long borrarNiveles = businessDelegatorView.borrarNivel4OtrosCostos(datOtrosCostosId);
					businessDelegatorView.updateDatOtrosCostosVer2(entity, dataLotes, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
					action_clear();
				}
				
				if (tipoTransaccion.equals("distri_todos_lotes")){
					//Long idNivel2 = FacesUtils.checkLong(txtNivel2IdIndicador) ;
					dataLotes = businessDelegatorView.consultarListaNivel4(compania, "0");
					Long borrarNiveles = businessDelegatorView.borrarNivel4OtrosCostos(datOtrosCostosId);
					businessDelegatorView.updateDatOtrosCostosVer2(entity, dataLotes, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + " Número consecutivo: "
							+ (businessDelegatorView.consultarConsecutivoOtrosCostos(compania) - 1));
					action_clear();
				}
				
				if(tipoTransaccion.equals("distri_lotes_informados")){
					businessDelegatorView.updateDatOtrosCostos(entity, dataNivel4, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
					action_clear();
				}
				
				if (tipoTransaccion.equals("distri_multiples_fincas") ){
					businessDelegatorView.updateDatOtrosCostos(entity, dataNivel4, dataDetalle);
					
					FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
					action_clear();
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
			selectedDatOtrosCostos = (DatOtrosCostosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostos"));

			Long datOtrosCostosId = new Long(selectedDatOtrosCostos.getDatOtrosCostosId());
			entity = businessDelegatorView.getDatOtrosCostos(datOtrosCostosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datOtrosCostosId = FacesUtils.checkLong(txtDatOtrosCostosId);
			entity = businessDelegatorView.getDatOtrosCostos(datOtrosCostosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatOtrosCostos(entity);
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
			selectedDatOtrosCostos = (DatOtrosCostosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostos"));

			Long datOtrosCostosId = new Long(selectedDatOtrosCostos.getDatOtrosCostosId());
			entity = businessDelegatorView.getDatOtrosCostos(datOtrosCostosId);
			businessDelegatorView.deleteDatOtrosCostos(entity);
			data.remove(selectedDatOtrosCostos);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datOtrosCostosId, Long equipoId,
			String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, Date fechaRegistro,
			String infoAdicional, String infoAdicional2, Long infraId, String numFactura, String observacion,
			String observacionAnularReg, String reglaDistribuccion, String serieFactura, String tipoTransaccion,
			Long usuarioDigitacion, Double valorTotal, Long centCostId_CentCost, Long elemCostoId_ElementoCosto,
			Long laborId_Labor, Long persEmprId_PersEmpr) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEquipoId(FacesUtils.checkLong(equipoId));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setInfraId(FacesUtils.checkLong(infraId));
			entity.setNumFactura(FacesUtils.checkString(numFactura));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setReglaDistribuccion(FacesUtils.checkString(reglaDistribuccion));
			entity.setSerieFactura(FacesUtils.checkString(serieFactura));
			entity.setTipoTransaccion(FacesUtils.checkString(tipoTransaccion));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorTotal(FacesUtils.checkDouble(valorTotal));
			businessDelegatorView.updateDatOtrosCostos(entity, dataNivel4, dataDetalle);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatOtrosCostosView").requestRender();
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

	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
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

	public SelectOneMenu getTxtReglaDistribuccion() {
		return txtReglaDistribuccion;
	}

	public void setTxtReglaDistribuccion(SelectOneMenu txtReglaDistribuccion) {
		this.txtReglaDistribuccion = txtReglaDistribuccion;
	}

	public InputText getTxtSerieFactura() {
		return txtSerieFactura;
	}

	public void setTxtSerieFactura(InputText txtSerieFactura) {
		this.txtSerieFactura = txtSerieFactura;
	}

	public SelectOneMenu getTxtTipoTransaccion() {
		return txtTipoTransaccion;
	}

	public void setTxtTipoTransaccion(SelectOneMenu txtTipoTransaccion) {
		this.txtTipoTransaccion = txtTipoTransaccion;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public Spinner getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(Spinner txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public SelectOneMenu getTxtInfraId() {
		return txtInfraId;
	}

	public void setTxtInfraId(SelectOneMenu txtInfraId) {
		this.txtInfraId = txtInfraId;
	}

	public SelectOneMenu getTxtEquipoId() {
		return txtEquipoId;
	}

	public void setTxtEquipoId(SelectOneMenu txtEquipoId) {
		this.txtEquipoId = txtEquipoId;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
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

	public InputText getTxtDatOtrosCostosId() {
		return txtDatOtrosCostosId;
	}

	public void setTxtDatOtrosCostosId(InputText txtDatOtrosCostosId) {
		this.txtDatOtrosCostosId = txtDatOtrosCostosId;
	}

	/*public List<DatOtrosCostosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatOtrosCostos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatOtrosCostosDTO> datOtrosCostosDTO) {
		this.data = datOtrosCostosDTO;
	}*/
	
	public List<DatOtrosCostosDTO> getData() {
		return data;
	}

	public void setData(List<DatOtrosCostosDTO> datOtrosCostosDTO) {
		this.data = datOtrosCostosDTO;
	}

	public DatOtrosCostosDTO getSelectedDatOtrosCostos() {
		return selectedDatOtrosCostos;
	}

	public void setSelectedDatOtrosCostos(DatOtrosCostosDTO datOtrosCostos) {
		this.selectedDatOtrosCostos = datOtrosCostos;
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

	public SelectOneMenu getTxtNivel1Id() {
		return txtNivel1Id;
	}

	public void setTxtNivel1Id(SelectOneMenu txtNivel1Id) {
		this.txtNivel1Id = txtNivel1Id;
	}

	public SelectOneMenu getTxtNivel3Id() {
		return txtNivel3Id;
	}

	public void setTxtNivel3Id(SelectOneMenu txtNivel3Id) {
		this.txtNivel3Id = txtNivel3Id;
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

	public InputText getTxtNivel4Nombre() {
		return txtNivel4Nombre;
	}

	public void setTxtNivel4Nombre(InputText txtNivel4Nombre) {
		this.txtNivel4Nombre = txtNivel4Nombre;
	}

	public InputText getTxtNivel2Nombre() {
		return txtNivel2Nombre;
	}

	public void setTxtNivel2Nombre(InputText txtNivel2Nombre) {
		this.txtNivel2Nombre = txtNivel2Nombre;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public List<DatOtrosCostosNivel4DTO> getDataNivel4() {
		return dataNivel4;
	}

	public void setDataNivel4(List<DatOtrosCostosNivel4DTO> dataNivel4) {
		this.dataNivel4 = dataNivel4;
	}

	/**************** DETALLE DE AGREGAR PANTALLA ****/

	public List<DatOtrosCostosNivel4DTO> getDatOtrosCostosNivel41() {

		if (dataNivel4 == null || dataNivel4.size() == 0) {
			return null;
		} else {
			return dataNivel4;
		}

	}

	public void action_agregarDatOtrosCostosNivel4() throws Exception {

		if (txtNivel2Id_Nivel2.getValue() != null && txtNivel4Id_Nivel4.getValue() != null) {

			Long nivel2 = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());
			Nivel2 nivel2Id = businessDelegatorView.getNivel2(nivel2);

			Long nivel4 = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			Nivel4 nivel4Id = businessDelegatorView.getNivel4(nivel4);
			
			Etapa etapa = nivel4Id.getEtapa();
			Long etapaId = etapa.getEtapaId();
			Long variedId = nivel4Id.getVariedad();

			String nombreNivel2 = FacesUtils.checkString(txtNivel2Nombre);
			String nombreNivel4 = FacesUtils.checkString(txtNivel4Nombre);
			Double areaNivel4 = nivel4Id.getAreaNeta();
			boolean existeProducto = false;

			if (dataNivel4 == null) {
				dataNivel4 = new ArrayList<DatOtrosCostosNivel4DTO>();
			}

			if (dataNivel4.size() > 0) {

				for (DatOtrosCostosNivel4DTO d : dataNivel4) {

					if (d.getNivel4Id_Nivel4().getNivel4Id().longValue() == nivel4Id.getNivel4Id().longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"El Lote " + d.getNivel4Id_Nivel4().getCodigo().toString()
												+ " ya fue agregado a la lista, por favor seleccione otro. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				DatOtrosCostosNivel4DTO datOtrosCostosNivel4DTO = new DatOtrosCostosNivel4DTO();

				datOtrosCostosNivel4DTO.setNivel2Id_Nivel2(nivel2Id);
				datOtrosCostosNivel4DTO.setNombreNivel2(nombreNivel2);
				datOtrosCostosNivel4DTO.setNivel4Id_Nivel4(nivel4Id);
				datOtrosCostosNivel4DTO.setNombreNivel4(nombreNivel4);
				datOtrosCostosNivel4DTO.setAreaNivel4(areaNivel4);
				datOtrosCostosNivel4DTO.setEtapaId(etapaId);
				datOtrosCostosNivel4DTO.setVariedId(variedId);

				dataNivel4.add(datOtrosCostosNivel4DTO);
			}
			nivel2 = null;
			nivel2Id = null;
			nombreNivel2 = null;
			nivel4 = null;
			nivel4Id = null;
			nombreNivel4 = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  finca, lote   tengan valores. "));
		}
	}

	public void action_agregarDatOtrosCostosDetalle() throws Exception {

		if (txtLaborId_Labor.getValue() != null && txtValorTotal.getValue() != null) {

			Long laborId = FacesUtils.checkLong(txtLaborId_Labor);
			Labor labor = businessDelegatorView.getLabor(laborId);
			String nombreLabor = labor.getNombre();
			
			String numFactura = FacesUtils.checkString(txtNumFactura);

			Long persEmprId = FacesUtils.checkLong(txtPersEmprId_PersEmpr);
			PersEmpr persEmpr = null;
			if (persEmprId != null) {
				persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
			}
			
			Double valorTotal = FacesUtils.checkDouble(txtValorTotal);
			
			Long elemCostoId = FacesUtils.checkLong(txtElemCostoId_ElementoCosto);
			ElementoCosto elementoCosto = null;
			String nombreElementoCosto = "";
			if (elemCostoId != null) {
				elementoCosto = businessDelegatorView.getElementoCosto(elemCostoId);
				nombreElementoCosto = elementoCosto.getNombre();
			}
			
			String observacion = FacesUtils.checkString(txtObservacion);
			
			Long ccontableId = null;
			CuentaContable cuentaContable = null;
			if (txtCuentaContable.getValue() != null) {
				ccontableId= FacesUtils.checkLong(txtCuentaContable);
				cuentaContable = businessDelegatorView.getCuentaContable(ccontableId);
			}

			if (dataDetalle == null) {
				dataDetalle = new ArrayList<DatOtrosCostosDetalleDTO>();
			}

			DatOtrosCostosDetalleDTO datOtrosCostosDetalleDTO = new DatOtrosCostosDetalleDTO();

			datOtrosCostosDetalleDTO.setLaborId_Labor(labor);
			datOtrosCostosDetalleDTO.setNombreLabor(nombreLabor);
			datOtrosCostosDetalleDTO.setPersEmprId_PersEmpr(persEmpr);
			datOtrosCostosDetalleDTO.setElemCostoId_ElementoCosto(elementoCosto);
			datOtrosCostosDetalleDTO.setNombreElementoCosto(nombreElementoCosto);
			datOtrosCostosDetalleDTO.setCcontableId(ccontableId);
			datOtrosCostosDetalleDTO.setNumFactura(numFactura);
			datOtrosCostosDetalleDTO.setValorTotal(valorTotal);
			datOtrosCostosDetalleDTO.setObservacion(observacion);

			dataDetalle.add(datOtrosCostosDetalleDTO);
			
			laborId = null;
			labor = null;
			numFactura = null;
			persEmprId = null;
			persEmpr = null;
			valorTotal = null;
			elemCostoId = null;
			elementoCosto = null;
			observacion = null;
			ccontableId = null;
			cuentaContable = null;
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos  finca, lote   tengan valores. "));
		}
	}

	public void listener_ConsultaNivel4() {

		Long nivel4Id = null;
		Long nivel2Id = null;

		if (!txtNivel4Id_Nivel4.getValue().equals("") && !txtNivel2Id_Nivel2.getValue().equals("")) {
			nivel4Id = Long.parseLong(txtNivel4Id_Nivel4.getValue().toString());
			nivel2Id = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());

			try {
				Nivel2 nivel2 = businessDelegatorView.getNivel2(nivel2Id);

				Nivel4 nivel4 = businessDelegatorView.getNivel4(nivel4Id);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNivel4Nombre.setValue(nivel4.getNombre());
				txtNivel2Nombre.setValue(nivel2.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

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

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatOtrosCostos.getDatOtrosCostosId());
				entity = businessDelegatorView.getDatOtrosCostos(id);
			}

			Long id = FacesUtils.checkLong(txtDatOtrosCostosId);

			dataNivel4 = null;
			dataNivel4 = businessDelegatorView.getDataDatOtrosCostosNivel4ByNivel4(id);

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatOtrosCostos(entity, dataNivel4, dataDetalle);
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
		selectedDatOtrosCostos = (DatOtrosCostosDTO) (evt.getComponent().getAttributes().get("selectedDatOtrosCostos"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String actionDeleteOtrosCostosNivel4(ActionEvent evt) {
		try {

			selectedDatOtrosCostosNivel4 = (DatOtrosCostosNivel4DTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostosNivel4"));

			if (selectedDatOtrosCostosNivel4.getDatOtrosCostosNivel4Id() == null) {
				dataNivel4.remove(selectedDatOtrosCostosNivel4);
			} else {
				Long datOtrosCostosNivel4Id = new Long(selectedDatOtrosCostosNivel4.getDatOtrosCostosNivel4Id());
				DatOtrosCostosNivel4 entity = businessDelegatorView.getDatOtrosCostosNivel4(datOtrosCostosNivel4Id);
				businessDelegatorView.deleteDatOtrosCostosNivel4(entity);
				dataNivel4.remove(selectedDatOtrosCostosNivel4);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteOtrosCostosDet(ActionEvent evt) {
		try {

			selectedDatOtrosCostosDet = (DatOtrosCostosDetalleDTO) (evt.getComponent().getAttributes()
					.get("selectedDatOtrosCostosDet"));

			if (selectedDatOtrosCostosDet.getDatOtrosCostosDetId() == null) {
				dataDetalle.remove(selectedDatOtrosCostosDet);
			} else {
				Long datOtrosCostosDetId = new Long(selectedDatOtrosCostosDet.getDatOtrosCostosDetId());
				DatOtrosCostosDetalle entity = businessDelegator2View.getDatOtrosCostosDetalle(datOtrosCostosDetId);
				businessDelegator2View.deleteDatOtrosCostosDetalle(entity);
				dataNivel4.remove(selectedDatOtrosCostosNivel4);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	public void onCellEditOtrosCostos(CellEditEvent event) throws Exception {

		selectedDatOtrosCostosNivel4 = (DatOtrosCostosNivel4DTO) (event.getComponent().getAttributes()
				.get("selectedDatOtrosCostosNivel4"));
		
		if (selectedDatOtrosCostosNivel4.getDatOtrosCostosNivel4Id() != null) {

			Long datOtrosCostosNivel4Id = selectedDatOtrosCostosNivel4.getDatOtrosCostosNivel4Id().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long otrosCostos = FacesUtils.checkLong(txtDatOtrosCostosId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityOtrosCostsNivel4 = null;
	
				entityOtrosCostsNivel4 = businessDelegatorView.getDatOtrosCostosNivel4(datOtrosCostosNivel4Id);
	
				if (columnaCell.equals("Hacienda")) {
	
					Long nivel2Id = new Long(event.getNewValue().toString());
					Nivel2 Nivel2 = businessDelegatorView.getNivel2(nivel2Id);
	
					entityOtrosCostsNivel4.setNivel2(Nivel2);
	
				} else if (columnaCell.equals("Lote")) {
	
					Long nivel4 = new Long(event.getNewValue().toString());
					Nivel4 Nivel4 = businessDelegatorView.getNivel4(nivel4);
	
					entityOtrosCostsNivel4.setNivel4(Nivel4);
				} 
	
				entity = businessDelegatorView.getDatOtrosCostos(otrosCostos);
				entityOtrosCostsNivel4.setDatOtrosCostos(entity);
				businessDelegatorView.updateDatOtrosCostosNivel4(entityOtrosCostsNivel4);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataNivel4 = null;
				entityOtrosCostsNivel4 = null;
				selectedDatOtrosCostosNivel4 = null;
				entity = null;
	
				dataNivel4 = businessDelegatorView.getDataDatOtrosCostosNivel4ByNivel4(otrosCostos);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}		

	}
	
	public void onCellEditOtrosCostosDet(CellEditEvent event) throws Exception {

		selectedDatOtrosCostosDet = (DatOtrosCostosDetalleDTO) (event.getComponent().getAttributes()
				.get("selectedDatOtrosCostosDet"));

		Long datOtrosCostosDetId = selectedDatOtrosCostosDet.getDatOtrosCostosDetId().longValue();
		String columnaCell = event.getColumn().getHeaderText();
		Long otrosCostos = FacesUtils.checkLong(txtDatOtrosCostosId);

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityDetalle = null;
			entityDetalle = businessDelegator2View.getDatOtrosCostosDetalle(datOtrosCostosDetId);

			if (columnaCell.equals("Factura")) {
				
				entityDetalle.setNumFactura((String) newValue);

			} else if (columnaCell.equals("Gasto")) {

				Long laborId = new Long(event.getNewValue().toString());
				Labor labor = businessDelegatorView.getLabor(laborId);

				entityDetalle.setLabor(labor);

			}/* else if (columnaCell.equals("Elemento de costo")) {

				Long elemCostoId = new Long(event.getNewValue().toString());
				ElementoCosto elementoCosto = businessDelegatorView.getElementoCosto(elemCostoId);

				entityDetalle.setElementoCosto(elementoCosto);
				
			} */else if (columnaCell.equals("Valor")) {
				
				entityDetalle.setValorTotal((Double) newValue);

			} else if (columnaCell.equals("Observación")) {
				
				entityDetalle.setObservacion((String) newValue);
			}

			entity = businessDelegatorView.getDatOtrosCostos(otrosCostos);
			entityDetalle.setDatOtrosCostos(entity);
			businessDelegator2View.updateDatOtrosCostosDetalle(entityDetalle);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataDetalle = null;
			entityDetalle = null;
			selectedDatOtrosCostosDet = null;
			entity = null;

			dataDetalle = businessDelegator2View.getDataDatOtrosCostosDetalleByOtrosCostos(otrosCostos);

		}
	}
	
	public void listarOtrosCostos() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Long compania = new Long(getCompaniaIdSession());
			Long planilla = FacesUtils.checkLong(txtPlanilla);
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			String tipoDistri = FacesUtils.checkString(txtTipoDistri);
			
			if (planilla == null) {
				planilla = 0L;
			}

			if (compania != null && fechaInicial != null && fechaFinal != null) {
				
				data = businessDelegator2View.pr_listar_otros_costos(compania, fechaInicial, fechaFinal, planilla, tipoDistri);

			} else if (compania != null && fechaInicial == null && fechaFinal == null && planilla != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data = businessDelegator2View.pr_listar_otros_costos(compania, fechaInicial, fechaFinal, planilla, tipoDistri);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void listarOtrosCostosMultiplesHaciendas() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Long compania = new Long(getCompaniaIdSession());
			Long planilla = FacesUtils.checkLong(txtPlanilla);
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
			String tipoDistri = FacesUtils.checkString(txtTipoDistri);
			
			
			if (planilla == null) {
				planilla = 0L;
			}

			if (compania != null && fechaInicial != null && fechaFinal != null) {
				
				data = businessDelegator2View.pr_listar_otros_costos(compania, fechaInicial, fechaFinal, planilla, tipoDistri);

			} else if (compania != null && fechaInicial == null && fechaFinal == null && planilla != null) {

				SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicial = foriginal.parse("1970-01-01");
				fechaFinal = new Date();

				data = businessDelegator2View.pr_listar_otros_costos(compania, fechaInicial, fechaFinal, planilla, tipoDistri);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SelectItem[] getselectNivel1() {

		if (nivel1 == null || nivel1.size() == 0) {

		

			try {

				nivel1 = businessDelegatorView.getNivel1(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel1> lista = businessDelegatorView.findByCriteriaInNivel1(condicion, null, null);
				selectNivel1 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel1 nivel1 : lista) {
					selectNivel1[i] = new SelectItem(nivel1.getNivel1Id(), nivel1.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel1;
	}

	public void setselectNivel1(SelectItem[] selectNivel1) {
		this.selectNivel1 = selectNivel1;
	}

	public SelectItem[] getselectNivel2() {

		nivel2 = new ArrayList<Nivel2>();

		Long nivel1Id = null;

		if (txtNivel1Id != null && txtNivel1Id.getValue() != null && !txtNivel1Id.getValue().equals("")) {
			nivel1Id = Long.parseLong(txtNivel1Id.getValue().toString());

			try {
				Nivel1 nivel1 = businessDelegatorView.getNivel1(nivel1Id);
				Object[] niveles2 = nivel1.getNivel2s().toArray();

				selectNivel2 = new SelectItem[niveles2.length];

				int i = 0;
				for (Object object : niveles2) {
					Nivel2 nivel2 = (Nivel2) object;
					selectNivel2[i] = new SelectItem(nivel2.getNivel2Id(), nivel2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel2;
	}

	public void setselectNivel2(SelectItem[] selectNivel2) {
		this.selectNivel2 = selectNivel2;
	}

	public SelectItem[] getselectNivel3() {

		nivel3 = new ArrayList<Nivel3>();

		Long nivel2Id = null;

		if (txtNivel2Id_Nivel2 != null && txtNivel2Id_Nivel2.getValue() != null
				&& !txtNivel2Id_Nivel2.getValue().equals("")) {
			nivel2Id = Long.parseLong(txtNivel2Id_Nivel2.getValue().toString());

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

	public void setselectNivel3(SelectItem[] selectNivel3) {
		this.selectNivel3 = selectNivel3;
	}

	public SelectItem[] getselectNivel4() {
		nivel4 = new ArrayList<Nivel4>();

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
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(), nivel4.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
		return selectNivel4;
	}

	public void setselectNivel4(SelectItem[] selectNivel4) {
		this.selectNivel4 = selectNivel4;
	}
	
	public SelectItem[] getselectNivel2Edit() {

		if (nivel2 == null || nivel2.size() == 0) {

			nivel2 = new ArrayList<Nivel2>();

			try {

				nivel2 = businessDelegatorView.getNivel2(); // Fin by
				// Criteria
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

	public void setselectNivel2Edit(SelectItem[] selectNivel2Edit) {
		this.selectNivel2Edit = selectNivel2Edit;
	}
	
	public SelectItem[] getselectNivel4Edit() {

		if (nivel4 == null || nivel4.size() == 0) {

			nivel4 = new ArrayList<Nivel4>();

			try {

				nivel4 = businessDelegatorView.getNivel4(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel4> lista = businessDelegatorView.findByCriteriaInNivel4(condicion, null, null);
				selectNivel4 = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel4 nivel4 : lista) {
					selectNivel4[i] = new SelectItem(nivel4.getNivel4Id(),
							nivel4.getNombre() + '-' + "Área: " + nivel4.getAreaNeta().toString());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel4;
	}

	public void setselectNivel4Edit(SelectItem[] selectNivel4Edit) {
		this.selectNivel4Edit = selectNivel4Edit;
	}

	public SelectItem[] getselectInfraestructura() {

		if (infraestructura == null || infraestructura.size() == 0) {

			infraestructura = new ArrayList<Infraestructura>();

			try {

				infraestructura = businessDelegatorView.getInfraestructura(); // Fin
																				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Infraestructura> lista = businessDelegatorView.findByCriteriaInInfraestructura(condicion, null,
						null);
				selectInfraestructura = new SelectItem[lista.size()];

				int i = 0;
				for (Infraestructura infraestructura : lista) {
					selectInfraestructura[i] = new SelectItem(infraestructura.getInfraId(),
							infraestructura.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectInfraestructura;
	}

	public void setselectInfraestructura(SelectItem[] selectInfraestructura) {
		this.selectInfraestructura = selectInfraestructura;
	}

	public SelectItem[] getselectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			centCost = new ArrayList<CentCost>();

			try {

				centCost = businessDelegatorView.getCentCost(); // Fin by
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

	public SelectItem[] getselectElementoCosto() {

		if (elementoCosto == null || elementoCosto.size() == 0) {

			elementoCosto = new ArrayList<ElementoCosto>();

			try {

				elementoCosto = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectElementoCosto = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectElementoCosto[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectElementoCosto;
	}

	public void setselectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			
			try {

				
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="  };
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

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public SelectItem[] getSelectCuentaContable() {

		if (selectCuentaContable == null || selectCuentaContable.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<CuentaContable> lista = businessDelegatorView.findByCriteriaInCuentaContable(condicion, null, null);
				selectCuentaContable = new SelectItem[lista.size()];

				int i = 0;
				for (CuentaContable cuentaContable : lista) {
					selectCuentaContable[i] = new SelectItem(cuentaContable.getCcontableId(), cuentaContable.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCuentaContable;
	}

	public void setSelectCuentaContable(SelectItem[] selectCuentaContable) {
		this.selectCuentaContable = selectCuentaContable;
	}

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "gastos_agricolas", "=" };
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

	public void setselectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getselectEquipo() {

		if (equipo == null || equipo.size() == 0) {

		
			try {

				// Criteria
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

	public void setselectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

	/**
	 * @return the dataLotes
	 */
	public List<ListaNivel4DTO> getDataLotes() {
		return dataLotes;
	}

	/**
	 * @param dataLotes the dataLotes to set
	 */
	public void setDataLotes(List<ListaNivel4DTO> dataLotes) {
		this.dataLotes = dataLotes;
	}
	
	

	public SelectItem[] getselectNivel2Indicador() {

		if (nivel2Indicador == null || nivel2Indicador.size() == 0) {

			

			try {

				nivel2Indicador = businessDelegatorView.getNivel2(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Nivel2> lista = businessDelegatorView.findByCriteriaInNivel2(condicion, null, null);
				selectNivel2Indicador = new SelectItem[lista.size()];

				int i = 0;
				for (Nivel2 nivel2Indicador : lista) {
					selectNivel2Indicador[i] = new SelectItem(nivel2Indicador.getNivel2Id(), nivel2Indicador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2Indicador;
	}

	public void setselectNivel2Indicador(SelectItem[] selectNivel2Indicador) {
		this.selectNivel2Indicador = selectNivel2Indicador;
	}

	/**
	 * @return the txtNivel2IdIndicador
	 */
	public SelectOneMenu getTxtNivel2IdIndicador() {
		return txtNivel2IdIndicador;
	}

	/**
	 * @param txtNivel2IdIndicador the txtNivel2IdIndicador to set
	 */
	public void setTxtNivel2IdIndicador(SelectOneMenu txtNivel2IdIndicador) {
		this.txtNivel2IdIndicador = txtNivel2IdIndicador;
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

	public SelectOneMenu getTxtCuentaContable() {
		return txtCuentaContable;
	}

	public void setTxtCuentaContable(SelectOneMenu txtCuentaContable) {
		this.txtCuentaContable = txtCuentaContable;
	}

	public List<DatOtrosCostosDetalleDTO> getDataDetalle() {
		return dataDetalle;
	}

	public void setDataDetalle(List<DatOtrosCostosDetalleDTO> dataDetalle) {
		this.dataDetalle = dataDetalle;
	}

	public CommandButton getBtnAgregarDetalle() {
		return btnAgregarDetalle;
	}

	public void setBtnAgregarDetalle(CommandButton btnAgregarDetalle) {
		this.btnAgregarDetalle = btnAgregarDetalle;
	}

	public List<String> getSelectedNivel2() {
		return selectedNivel2;
	}

	public void setSelectedNivel2(List<String> selectedNivel2) {
		this.selectedNivel2 = selectedNivel2;
	}

	public List<Nivel2> getFincas() {

		if (fincas == null || fincas.size() == 0) {

			

			try {
				fincas = businessDelegatorView.getNivel2();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return fincas;
	}

	public void setFincas(List<Nivel2> fincas) {
		this.fincas = fincas;
	}

	public SelectOneMenu getTxtTipoDistri() {
		return txtTipoDistri;
	}

	public void setTxtTipoDistri(SelectOneMenu txtTipoDistri) {
		this.txtTipoDistri = txtTipoDistri;
	}
	

}
