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
import co.com.arcosoft.modelo.CajaMenor;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatCajaMenor;
import co.com.arcosoft.modelo.DatCajaMenorDet;
import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatCajaMenorDTO;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCajaMenorDTO;
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
public class DatCajaMenorView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatCajaMenorView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputText txtEstado;
	private InputText txtObservacion;
	private InputText txtObservacionAnularReg;
	private InputText txtUsuarioDigitacion;

	private InputText txtDatCajaMenorId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaRegistro;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatCajaMenorDTO> data;
	private DatCajaMenorDTO selectedDatCajaMenor;
	private DatCajaMenor entity;
	private DatCajaMenorDet entityDet;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	private List<DatCajaMenorDetDTO> dataCajaMenor;
	private DatCajaMenorDetDTO selectedDatCajaMenordet;

	private int activeTapIndex = 0;

	private SelectOneMenu txtCajaMenorId_CajaMenor;
	SelectItem[] selectCajaMenor;
	private List<CajaMenor> cajaMenor;

	private SelectOneMenu txtEquipoId;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private InputTextarea txtDetalleNota;
	private InputNumber txtValor;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private CommandButton btnAgregar;

	private List<ConsultaCajaMenorDTO> data2;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
	private InputNumber txtValorTotalAcumulado;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;
	/************** ++++DETALLE **/

	private ConsultaCajaMenorDTO selectedDatCajaMenor2;
	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	SelectItem[] selectContratistaEdit;
	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;

	private InputText txtDocumento;
	private SelectOneMenu txtCentCostConsulta;
	SelectItem[] selectCentCostConsulta;
	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;

	private InputText txtNumFactura;
	private List<PersEmpr> contratistas;
	SelectItem[] selectCentCostEdit;
	public DatCajaMenorView() {
		super();
	}

	public String action_new() throws Exception {
		action_clear();
		selectedDatCajaMenor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws Exception {
		entity = null;
		selectedDatCajaMenor = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;
		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}
		if (txtNumFactura != null) {
			txtNumFactura.setValue(null);
			txtNumFactura.setDisabled(false);
		}

		if (txtPersEmprId_PersEmpr != null) {
			txtPersEmprId_PersEmpr.setValue(null);
			txtPersEmprId_PersEmpr.setDisabled(false);
		}

		if (dataCajaMenor != null) {
			dataCajaMenor = null;
		}

		if (txtValorTotalAcumulado != null) {
			txtValorTotalAcumulado.setValue(null);
			txtValorTotalAcumulado.setDisabled(false);
		}
		if (txtConsecutivo != null) {
			Long compania = new Long(getCompaniaIdSession());
			txtConsecutivo.setValue(businessDelegator2View.consultarConsecutivoCajaMenor(compania));
			txtConsecutivo.setDisabled(true);
		}
		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(false);
		}
		if (txtDetalleNota != null) {
			txtDetalleNota.setValue(null);
			txtDetalleNota.setDisabled(false);
		}
		if (txtCentCostId_CentCost != null) {
			txtCentCostId_CentCost.setValue(null);
			txtCentCostId_CentCost.setDisabled(false);
		}

		if (txtEquipoId != null) {
			txtEquipoId.setValue(null);
			txtEquipoId.setDisabled(false);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(false);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(true);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(true);
		}

		if (txtCajaMenorId_CajaMenor != null) {
			txtCajaMenorId_CajaMenor.setValue(null);
			txtCajaMenorId_CajaMenor.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaRegistro != null) {
			Date date = new Date();
			txtFechaRegistro.setValue(date);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtDatCajaMenorId != null) {
			txtDatCajaMenorId.setValue(null);
			txtDatCajaMenorId.setDisabled(false);
		}

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnAgregar != null) {
			btnAgregar.setDisabled(false);
		}
		if (btnDelete != null) {
			btnDelete.setDisabled(true);
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
		selectedDatCajaMenor2 = (ConsultaCajaMenorDTO) (evt.getComponent().getAttributes()
				.get("selectedDatCajaMenor2"));
		try {

			Long datCajaMenorId = selectedDatCajaMenor2.getDatCajaMenorId().longValue();
			Object[] condicion = { "datCajaMenorId", true, datCajaMenorId, "=" };
			List<DatCajaMenor> lista = (datCajaMenorId != null)
					? businessDelegator2View.findByCriteriaInDatCajaMenor(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtPersEmprId_PersEmpr.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);

				txtFechaRegistro.setValue(entity.getFechaRegistro());
				txtFechaRegistro.setDisabled(false);

				txtCajaMenorId_CajaMenor.setValue(entity.getCajaMenor().getCajaMenorId());
				txtCajaMenorId_CajaMenor.setDisabled(false);
				txtDatCajaMenorId.setValue(entity.getDatCajaMenorId());
				txtDatCajaMenorId.setDisabled(true);

			  
				txtCentCostId_CentCost.setDisabled(false);

				Long id = FacesUtils.checkLong(txtDatCajaMenorId);

				dataCajaMenor = null;
				dataCajaMenor = businessDelegator2View.getDataDatCajaMenorDetByCaja(id);

				double subTotalValorTotal = 0;
				double impuestos = 0;
				double valorTotal = 0;
				if (dataCajaMenor != null && dataCajaMenor.size() >= 0) {
					for (DatCajaMenorDetDTO data1 : dataCajaMenor) {
						subTotalValorTotal += (data1.getValor().doubleValue());

						valorTotal += data1.getValor().doubleValue();
					}
				}
				txtValorTotalAcumulado.setValue(valorTotal);
				txtValorTotalAcumulado.setDisabled(false);

				txtLaborId_Labor.setDisabled(false);

				txtDetalleNota.setDisabled(false);
				txtValor.setDisabled(false);
				txtImplemento.setValue(null);
				txtImplemento.setDisabled(false);
				btnSave.setDisabled(false);

				btnAgregar.setDisabled(false);

				activeTapIndex = 0;
				if (txtNumFactura != null) {
					txtNumFactura.setValue(null);
					txtNumFactura.setDisabled(false);
				}

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
			if ((selectedDatCajaMenor == null) && (entity == null)) {
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
			entity = new DatCajaMenor();

			// Long datCajaMenorId = FacesUtils.checkLong(txtDatCajaMenorId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);

			// entity.setCompania(FacesUtils.checkLong(txtCompania));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			// entity.setDatCajaMenorId(datCajaMenorId);
			// entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
		//	entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			// entity.setUsuarioDigitacion(FacesUtils.checkLong(
			// txtUsuarioDigitacion));
			entity.setCajaMenor((FacesUtils.checkLong(txtCajaMenorId_CajaMenor) != null)
					? businessDelegator2View.getCajaMenor(FacesUtils.checkLong(txtCajaMenorId_CajaMenor))
					: null);

			businessDelegator2View.saveDatCajaMenor(entity, dataCajaMenor);
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
				Long datCajaMenorId = new Long(selectedDatCajaMenor.getDatCajaMenorId());
				entity = businessDelegator2View.getDatCajaMenor(datCajaMenorId);
			}
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			// entity.setFechaCreacion(date);
		//	entity.setCentCostId(FacesUtils.checkLong(txtCentCostId_CentCost));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(txtUsuarioDigitacion));
			entity.setCajaMenor((FacesUtils.checkLong(txtCajaMenorId_CajaMenor) != null)
					? businessDelegator2View.getCajaMenor(FacesUtils.checkLong(txtCajaMenorId_CajaMenor))
					: null);
			businessDelegator2View.updateDatCajaMenor(entity, dataCajaMenor);
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
			selectedDatCajaMenor = (DatCajaMenorDTO) (evt.getComponent().getAttributes().get("selectedDatCajaMenor"));

			Long datCajaMenorId = new Long(selectedDatCajaMenor.getDatCajaMenorId());
			entity = businessDelegator2View.getDatCajaMenor(datCajaMenorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datCajaMenorId = FacesUtils.checkLong(txtDatCajaMenorId);
			entity = businessDelegator2View.getDatCajaMenor(datCajaMenorId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatCajaMenor(entity);
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
			selectedDatCajaMenor = (DatCajaMenorDTO) (evt.getComponent().getAttributes().get("selectedDatCajaMenor"));

			Long datCajaMenorId = new Long(selectedDatCajaMenor.getDatCajaMenorId());
			entity = businessDelegator2View.getDatCajaMenor(datCajaMenorId);
			businessDelegator2View.deleteDatCajaMenor(entity);
			data.remove(selectedDatCajaMenor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datCajaMenorId, String estado,
			Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, Date fechaRegistro, String observacion,
			String observacionAnularReg, Long usuarioDigitacion, Long cajaMenorId_CajaMenor) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegator2View.updateDatCajaMenor(entity, dataCajaMenor);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatCajaMenorView").requestRender();
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

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputText txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputText getTxtObservacionAnularReg() {
		return txtObservacionAnularReg;
	}

	public void setTxtObservacionAnularReg(InputText txtObservacionAnularReg) {
		this.txtObservacionAnularReg = txtObservacionAnularReg;
	}

	public InputText getTxtUsuarioDigitacion() {
		return txtUsuarioDigitacion;
	}

	public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
		this.txtUsuarioDigitacion = txtUsuarioDigitacion;
	}

	public SelectOneMenu getTxtCajaMenorId_CajaMenor() {
		return txtCajaMenorId_CajaMenor;
	}

	public void setTxtCajaMenorId_CajaMenor(SelectOneMenu txtCajaMenorId_CajaMenor) {
		this.txtCajaMenorId_CajaMenor = txtCajaMenorId_CajaMenor;
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

	public InputText getTxtDatCajaMenorId() {
		return txtDatCajaMenorId;
	}

	public void setTxtDatCajaMenorId(InputText txtDatCajaMenorId) {
		this.txtDatCajaMenorId = txtDatCajaMenorId;
	}

	public List<DatCajaMenorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatCajaMenor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatCajaMenorDTO> datCajaMenorDTO) {
		this.data = datCajaMenorDTO;
	}

	public DatCajaMenorDTO getSelectedDatCajaMenor() {
		return selectedDatCajaMenor;
	}

	public void setSelectedDatCajaMenor(DatCajaMenorDTO datCajaMenor) {
		this.selectedDatCajaMenor = datCajaMenor;
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

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",

						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"


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

	public SelectItem[] getSelectCajaMenor() {

		if (cajaMenor == null || cajaMenor.size() == 0) {

			try {

				cajaMenor = businessDelegator2View.getCajaMenor(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CajaMenor> lista = businessDelegator2View.findByCriteriaInCajaMenor(condicion, null, null);
				selectCajaMenor = new SelectItem[lista.size()];

				int i = 0;
				for (CajaMenor cajaMenor : lista) {
					selectCajaMenor[i] = new SelectItem(cajaMenor.getCajaMenorId(),
							cajaMenor.getCodigo() + '-' + cajaMenor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCajaMenor;
	}

	public void setSelectCajaMenor(SelectItem[] selectCajaMenor) {
		this.selectCajaMenor = selectCajaMenor;
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

	public List<DatCajaMenorDetDTO> getDataCajaMenor() {
		return dataCajaMenor;
	}

	public void setDataCajaMenor(List<DatCajaMenorDetDTO> dataCajaMenor) {
		this.dataCajaMenor = dataCajaMenor;
	}

	public SelectOneMenu getTxtEquipoId() {
		return txtEquipoId;
	}

	public void setTxtEquipoId(SelectOneMenu txtEquipoId) {
		this.txtEquipoId = txtEquipoId;
	}

	public InputTextarea getTxtDetalleNota() {
		return txtDetalleNota;
	}

	public void setTxtDetalleNota(InputTextarea txtDetalleNota) {
		this.txtDetalleNota = txtDetalleNota;
	}

	public InputNumber getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputNumber txtValor) {
		this.txtValor = txtValor;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public List<DatCajaMenorDetDTO> getDatCajaMenorDet1() {

		if (dataCajaMenor == null || dataCajaMenor.size() == 0) {
			return null;
		} else {
			return dataCajaMenor;
		}

	}

	public void action_agregarDatCajaMenordet() throws Exception {
		String numFactura = FacesUtils.checkString(txtNumFactura);
		if (  txtCentCostId_CentCost.getValue() != null && txtLaborId_Labor.getValue() != null && txtValor.getValue() != null && numFactura!=null) {
			String equipos = "";
			double subTotalValorTotal = 0;
			double impuestos = 0;
			double valorTotal = 0;
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				for (int i = 0; i < selectedEquipo.size(); i++) {
					equipos = selectedEquipo.get(i);

					Double totalMaquinas = (double) selectedEquipo.size();

					Long equipoId = Long.parseLong(equipos);
					Equipo equipo = businessDelegatorView.getEquipo(equipoId);
					String codigoEquipo = equipo.getCodigo();

					Long laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
					Labor labor = businessDelegatorView.getLabor(laborId);
					String nombreLabor = labor.getNombre();

					Double valor = 0.0;
					valor = FacesUtils.checkDouble(txtValor);
					Double valorFinal = (double) Math.round((valor / totalMaquinas) * 100) / 100;

					String detalleNota = txtDetalleNota.getValue().toString();

					Long persEmprId = null;
					PersEmpr persEmpr = null;
					String nomProveedor = "";
					if (txtPersEmprId_PersEmpr.getValue() != null) {
						persEmprId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());
						persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
						nomProveedor = persEmpr.getNombre();
					}
					
				 

					String nombreImplemento = "";
					Long implementoId = null;
					Equipo implemento = null;
					if (txtImplemento.getValue() != null) {
						implementoId = Long.parseLong(txtImplemento.getValue().toString());
						implemento = businessDelegatorView.getEquipo(implementoId);
						nombreImplemento = implemento.getCodigo() + "-" + implemento.getNombre();
					}
					Long centCostId = null;
					CentCost centCost = null;
					String nombreCentCost = "";
					if (txtCentCostId_CentCost.getValue() != null) {
						centCostId = FacesUtils.checkLong(txtCentCostId_CentCost);
						centCost = businessDelegatorView.getCentCost(centCostId);
						nombreCentCost = centCost.getNombre();
					}

					boolean existeProducto = false;

					if (dataCajaMenor == null) {
						dataCajaMenor = new ArrayList<DatCajaMenorDetDTO>();
					}

					DatCajaMenorDetDTO caja = new DatCajaMenorDetDTO();

					caja.setEquipoId_Equipo(equipo);
					caja.setCodigoEquipo(codigoEquipo);
					caja.setLaborId_Labor(labor);
					caja.setNombreLabor(nombreLabor);
					caja.setPersEmpr(persEmpr);
					caja.setNomProveedor(nomProveedor);

					caja.setValor(valorFinal);
					caja.setDetalleNota(detalleNota);
					caja.setNumFactura(numFactura);
					caja.setCodImplemento(nombreImplemento);
					caja.setImplementoId(implementoId);
					caja.setCentCostId_CentCost(centCostId);
					caja.setNombreCentroCosto(nombreCentCost);
					dataCajaMenor.add(caja);
					codigoEquipo = null;
					persEmpr = null;
					nomProveedor = null;
				}
			}

			if(dataCajaMenor!=null && dataCajaMenor.size()>0) {
			for (DatCajaMenorDetDTO data1 : dataCajaMenor) {
				subTotalValorTotal += (data1.getValor().doubleValue());

				valorTotal += data1.getValor().doubleValue();
			}
			}

			txtValorTotalAcumulado.setValue(valorTotal);

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!, Falta registrar y agregar el detalle  "
							+ "Verifique que los campos " + "Maquinaria, labor, valor, num. factura " + "" + "tengan valores. ", ""));
		}
		limpiar_pantalla();
	}

	public String actionDeleteDatCajaMenorDet(ActionEvent evt) {
		try {

			selectedDatCajaMenordet = (DatCajaMenorDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatCajaMenordet"));

			if (selectedDatCajaMenordet.getDatCajaMenordetId() == null) {
				dataCajaMenor.remove(selectedDatCajaMenordet);
			} else {
				Long datCajaMenorDetId = new Long(selectedDatCajaMenordet.getDatCajaMenordetId());
				DatCajaMenorDet entity = businessDelegator2View.getDatCajaMenorDet(datCajaMenorDetId);
				businessDelegator2View.deleteDatCajaMenorDet(entity);
				dataCajaMenor.remove(selectedDatCajaMenordet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public DatCajaMenor getEntity() {
		return entity;
	}

	public void setEntity(DatCajaMenor entity) {
		this.entity = entity;
	}

	public DatCajaMenorDetDTO getSelectedDatCajaMenordet() {
		return selectedDatCajaMenordet;
	}

	public void setSelectedDatCajaMenordet(DatCajaMenorDetDTO selectedDatCajaMenordet) {
		this.selectedDatCajaMenordet = selectedDatCajaMenordet;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public void listarCajaMenor() {
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

			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_cajamenor(compania, fechaInicial, fechaFinal, documento,
						centCost);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ConsultaCajaMenorDTO> getData2() {
		return data2;
	}

	public void setData2(List<ConsultaCajaMenorDTO> data2) {
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

	public void limpiar_pantalla() {

		txtCajaMenorId_CajaMenor.setValue(null);
		txtDetalleNota.setValue(null);
		equipos = null;
		selectEquipo = null;
		txtNumFactura.setValue(null);
		txtValor.setValue(null);

		txtLaborId_Labor.setValue(null);
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		// caso 1 : la tabla transaccional no tiene valores
		Long datCajaMenor = FacesUtils.checkLong(txtDatCajaMenorId);
		if (datCajaMenor != null) {
			selectedDatCajaMenordet = (DatCajaMenorDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatCajaMenordet"));
			if (selectedDatCajaMenordet.getDatCajaMenordetId() != null) {
				Long cajaMenorDetId = selectedDatCajaMenordet.getDatCajaMenordetId().longValue();

				String columnaCell = evt.getColumn().getHeaderText();

				Object oldValue = evt.getOldValue();
				Object newValue = evt.getNewValue();

				if (newValue != null) {

					entityDet = null;
					entityDet = businessDelegator2View.getDatCajaMenorDet(cajaMenorDetId);

					if (columnaCell.equals("Maq")) {

						Long maqId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(maqId);

						entityDet.setEquipo(e);

					}if (columnaCell.equals("CeCos")) {

						Long ceCosId = new Long(evt.getNewValue().toString());
						CentCost centCost = businessDelegatorView.getCentCost(ceCosId);

						entityDet.setCentCost(centCost);

					}

					if (columnaCell.equals("Valor")) {

						entityDet.setValor(Double.valueOf(evt.getNewValue().toString()));

					}
					if (columnaCell.equals("Factura")) {

						entityDet.setNumFactura((evt.getNewValue().toString()));

					}

					if (columnaCell.equals("Gasto")) {

						Long laborId = new Long(evt.getNewValue().toString());
						Labor e = businessDelegatorView.getLabor(laborId);

						entityDet.setLabor(e);

					}

					if (columnaCell.equals("Proveedor")) {

						Long idProveedor = new Long(evt.getNewValue().toString());
						PersEmpr persEmpr = businessDelegatorView.getPersEmpr(idProveedor);

						entityDet.setPersEmpr(persEmpr);
					}

					if (columnaCell.equals("Detalle")) {

						entityDet.setDetalleNota(String.valueOf(evt.getNewValue().toString()));

					} else if (columnaCell.equals("Implemento")) {

						Long impId = new Long(evt.getNewValue().toString());
						Equipo e = businessDelegatorView.getEquipo(impId);

						entityDet.setImplementoId(e);

					}

					entity = businessDelegator2View.getDatCajaMenor(datCajaMenor);
					entityDet.setDatCajaMenor(entity);
					businessDelegator2View.updateDatCajaMenorDet(entityDet);

					// entity = null;

					selectedDatCajaMenordet = null;
					entityDet = null;

					dataCajaMenor = null;
					dataCajaMenor = businessDelegator2View.getDataDatCajaMenorDetByCaja(datCajaMenor);
				}

			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Para poder modificar la información, primero los datos deben estar grabados. "));

		}

	}

	public DatCajaMenorDet getEntityDet() {
		return entityDet;
	}

	public void setEntityDet(DatCajaMenorDet entityDet) {
		this.entityDet = entityDet;
	}

	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatCajaMenor2 = (ConsultaCajaMenorDTO) (evt.getComponent().getAttributes()
				.get("selectedDatCajaMenor2"));
		try {

			Long datCajaMenorId = selectedDatCajaMenor2.getDatCajaMenorId().longValue();
			Object[] condicion = { "datCajaMenorId", true, datCajaMenorId, "=" };
			List<DatCajaMenor> lista = (datCajaMenorId != null)
					? businessDelegator2View.findByCriteriaInDatCajaMenor(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

				if (usuario.getNivelAcceso() != null) {
					if (usuario.getNivelAcceso().equals("TOTAL")) {
						Long borrarDetalle = businessDelegator2View.pr_borrar_dat_caja_menor_detalle(datCajaMenorId);
						Long borrarGeneral = businessDelegator2View.pr_borrar_dat_caja_menor(datCajaMenorId);
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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

	public SelectItem[] getSelectContratista() {

		if (selectContratista == null || selectContratista.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="							
						, "tipoEmpresa", true, "4", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>"  };
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

	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}

	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}

	public SelectItem[] getSelectContratistaEdit() {

		if (selectContratistaEdit == null || selectContratistaEdit.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "=" };
				List<PersEmpr> listaEdit = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratistaEdit = new SelectItem[listaEdit.size()];

				int i = 0;
				for (PersEmpr contratistaEdit : listaEdit) {
					selectContratistaEdit[i] = new SelectItem(contratistaEdit.getPersEmprId(),
							contratistaEdit.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratistaEdit;
	}

	public void setSelectContratistaEdit(SelectItem[] selectContratistaEdit) {
		this.selectContratistaEdit = selectContratistaEdit;
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

	public SelectItem[] getSelectImplemento() {

		if (implemento == null || implemento.size() == 0) {
			try {
				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Tractor", "<>",
						"categoriaEquipo.funcion", true, "Motobomba/Electrogeno", "<>",
				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo Implemento : lista) {
					selectImplemento[i] = new SelectItem(Implemento.getEquipoId(),
							Implemento.getCodigo() + "-" + Implemento.getNombre());
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
	
	
	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
	}

	public void validarExistenciaFactura() throws Exception {
		Long persEmprId = FacesUtils.checkLong(txtPersEmprId_PersEmpr);
		String numFactura = FacesUtils.checkString(txtNumFactura);
		
		Object[] condicion = { "numFactura", true, numFactura, "=", "persEmpr.persEmprId", true, persEmprId, "="  };
		List<DatCajaMenorDet> lista = (persEmprId != null)
				? businessDelegator2View.findByCriteriaInDatCajaMenorDet(condicion, null, null)
				: null;

		if (lista != null && lista.size() > 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Upps!, La factura registrada ya se encuentra en el sistema, válide por favor",""));
		}
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

}
