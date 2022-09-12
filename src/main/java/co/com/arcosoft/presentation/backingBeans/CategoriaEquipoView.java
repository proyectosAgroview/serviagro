package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.CategoriaEquipoDTO;
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
public class CategoriaEquipoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CategoriaEquipoView.class);
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtTaraMax;
	private InputText txtTaraMin;
	private InputText txtCategEquipId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CategoriaEquipoDTO> data;
	private CategoriaEquipoDTO selectedCategoriaEquipo;
	private CategoriaEquipo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtFuncion;

	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;
	private List<ConceptoKardex> conceptoKardex;
	private InputNumber txtRangoDiferenciaMedidor;
	public CategoriaEquipoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CategoriaEquipoDTO categoriaEquipoDTO = (CategoriaEquipoDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(categoriaEquipoDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(categoriaEquipoDTO.getCompania());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(categoriaEquipoDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(categoriaEquipoDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(categoriaEquipoDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(categoriaEquipoDTO.getNombre());

			if (txtTaraMax == null) {
				txtTaraMax = new InputText();
			}

			txtTaraMax.setValue(categoriaEquipoDTO.getTaraMax());

			if (txtTaraMin == null) {
				txtTaraMin = new InputText();
			}

			txtTaraMin.setValue(categoriaEquipoDTO.getTaraMin());

			if (txtCategEquipId == null) {
				txtCategEquipId = new InputText();
			}

			txtCategEquipId.setValue(categoriaEquipoDTO.getCategEquipId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(categoriaEquipoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(categoriaEquipoDTO.getFechaModificacion());

			Long categEquipId = FacesUtils.checkLong(txtCategEquipId);
			entity = businessDelegatorView.getCategoriaEquipo(categEquipId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCategoriaEquipo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCategoriaEquipo = null;
		PrimeFaces.current().resetInputs(":dialogCategoriaEquipo :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}
		if (txtRangoDiferenciaMedidor != null) {
			txtRangoDiferenciaMedidor.setValue(0.0);
			txtRangoDiferenciaMedidor.setDisabled(true);
		}
		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}

		if (txtConceptoKardex != null) {
			txtConceptoKardex.setValue(null);
			txtConceptoKardex.setDisabled(true);
		}
		
		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtFuncion != null) {
			txtFuncion.setValue(null);
			txtFuncion.setDisabled(true);
		}

		if (txtTaraMax != null) {
			txtTaraMax.setValue(null);
			txtTaraMax.setDisabled(true);
		}

		if (txtTaraMin != null) {
			txtTaraMin.setValue(null);
			txtTaraMin.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtCategEquipId != null) {
			txtCategEquipId.setValue(null);
			txtCategEquipId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
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
	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<CategoriaEquipo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);

		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			txtTaraMax.setDisabled(false);
			txtTaraMin.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			txtFuncion.setDisabled(false);
			txtCategEquipId.setDisabled(false);
			
			txtConceptoKardex.setDisabled(false);
			txtRangoDiferenciaMedidor.setDisabled(false);
			
			btnSave.setDisabled(false);
		} else {
			txtFuncion.setValue(entity.getFuncion());
			txtFuncion.setDisabled(false);
			
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtTaraMax.setValue(entity.getTaraMax());
			txtTaraMax.setDisabled(false);
			txtTaraMin.setValue(entity.getTaraMin());
			txtTaraMin.setDisabled(false);
			txtCategEquipId.setValue(entity.getCategEquipId());
			txtCategEquipId.setDisabled(true);
			if(entity.getConceptoKardexId()!=null) {

				txtConceptoKardex.setValue(entity.getConceptoKardexId().getConceptoKardexId());
			}
			txtConceptoKardex.setDisabled(false);
			
			txtRangoDiferenciaMedidor.setValue(entity.getRangoDifHorometro());
			txtRangoDiferenciaMedidor.setDisabled(false);
			
			
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCategoriaEquipo = (CategoriaEquipoDTO) (evt.getComponent().getAttributes()
				.get("selectedCategoriaEquipo"));
		try {

			String codigo = selectedCategoriaEquipo.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<CategoriaEquipo> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtFuncion.setValue(entity.getFuncion());
				txtFuncion.setDisabled(false);
			
				txtRangoDiferenciaMedidor.setValue(entity.getRangoDifHorometro());
				txtRangoDiferenciaMedidor.setDisabled(false);
				
				
				
				
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(entity.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(entity.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtTaraMax.setValue(entity.getTaraMax());
				txtTaraMax.setDisabled(false);
				txtTaraMin.setValue(entity.getTaraMin());
				txtTaraMin.setDisabled(false);
				txtCategEquipId.setValue(entity.getCategEquipId());
				txtCategEquipId.setDisabled(true);
				if(entity.getConceptoKardexId()!=null) {

					txtConceptoKardex.setValue(entity.getConceptoKardexId().getConceptoKardexId());
				}
				txtConceptoKardex.setDisabled(false);
				
				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

	public String action_save() {
		try {
			if ((selectedCategoriaEquipo == null) && (entity == null)) {
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

	public String action_create() {
		try {
			entity = new CategoriaEquipo();

			// Long categEquipId = FacesUtils.checkLong(txtCategEquipId);
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			// entity.setCategEquipId(categEquipId);
			entity.setFuncion(FacesUtils.checkString(txtFuncion));
			
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTaraMax(FacesUtils.checkDouble(txtTaraMax));
			entity.setTaraMin(FacesUtils.checkDouble(txtTaraMin));
			entity.setConceptoKardexId((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);
			 entity.setRangoDifHorometro(FacesUtils.checkDouble(txtRangoDiferenciaMedidor));  
			businessDelegatorView.saveCategoriaEquipo(entity);
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
				Long categEquipId = new Long(selectedCategoriaEquipo.getCategEquipId());
				entity = businessDelegatorView.getCategoriaEquipo(categEquipId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFuncion(FacesUtils.checkString(txtFuncion));
			
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTaraMax(FacesUtils.checkDouble(txtTaraMax));
			entity.setTaraMin(FacesUtils.checkDouble(txtTaraMin));
			entity.setConceptoKardexId((FacesUtils.checkLong(txtConceptoKardex) != null)
					? businessDelegator2View.getConceptoKardex(FacesUtils.checkLong(txtConceptoKardex))
					: null);
			 entity.setRangoDifHorometro(FacesUtils.checkDouble(txtRangoDiferenciaMedidor));  
			businessDelegatorView.updateCategoriaEquipo(entity);
		
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCategoriaEquipo = (CategoriaEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedCategoriaEquipo"));

			Long categEquipId = new Long(selectedCategoriaEquipo.getCategEquipId());
			entity = businessDelegatorView.getCategoriaEquipo(categEquipId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long categEquipId = FacesUtils.checkLong(txtCategEquipId);
			entity = businessDelegatorView.getCategoriaEquipo(categEquipId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCategoriaEquipo(entity);
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
			selectedCategoriaEquipo = (CategoriaEquipoDTO) (evt.getComponent().getAttributes()
					.get("selectedCategoriaEquipo"));

			Long categEquipId = new Long(selectedCategoriaEquipo.getCategEquipId());
			entity = businessDelegatorView.getCategoriaEquipo(categEquipId);
			businessDelegatorView.deleteCategoriaEquipo(entity);
			data.remove(selectedCategoriaEquipo);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long categEquipId, String codigo, Long compania, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String nombre,
			Double taraMax, Double taraMin) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setTaraMax(FacesUtils.checkDouble(taraMax));
			entity.setTaraMin(FacesUtils.checkDouble(taraMin));
			businessDelegatorView.updateCategoriaEquipo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CategoriaEquipoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(InputText txtCompania) {
		this.txtCompania = txtCompania;
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtTaraMax() {
		return txtTaraMax;
	}

	public void setTxtTaraMax(InputText txtTaraMax) {
		this.txtTaraMax = txtTaraMax;
	}

	public InputText getTxtTaraMin() {
		return txtTaraMin;
	}

	public void setTxtTaraMin(InputText txtTaraMin) {
		this.txtTaraMin = txtTaraMin;
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

	public InputText getTxtCategEquipId() {
		return txtCategEquipId;
	}

	public void setTxtCategEquipId(InputText txtCategEquipId) {
		this.txtCategEquipId = txtCategEquipId;
	}

	public List<CategoriaEquipoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCategoriaEquipo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CategoriaEquipoDTO> categoriaEquipoDTO) {
		this.data = categoriaEquipoDTO;
	}

	public CategoriaEquipoDTO getSelectedCategoriaEquipo() {
		return selectedCategoriaEquipo;
	}

	public void setSelectedCategoriaEquipo(CategoriaEquipoDTO categoriaEquipo) {
		this.selectedCategoriaEquipo = categoriaEquipo;
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

	/**
	 * @return the txtFuncion
	 */
	public SelectOneMenu getTxtFuncion() {
		return txtFuncion;
	}

	/**
	 * @param txtFuncion the txtFuncion to set
	 */
	public void setTxtFuncion(SelectOneMenu txtFuncion) {
		this.txtFuncion = txtFuncion;
	}

	public SelectItem[] getSelectConceptoKardex() {

		if (conceptoKardex == null || conceptoKardex.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectConceptoKardex[i] = new SelectItem(conceptoKardex.getConceptoKardexId(),
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex;
	}

	public void setSelectConceptoKardex(SelectItem[] selectConceptoKardex) {
		this.selectConceptoKardex = selectConceptoKardex;
	}

	public SelectOneMenu getTxtConceptoKardex() {
		return txtConceptoKardex;
	}

	public void setTxtConceptoKardex(SelectOneMenu txtConceptoKardex) {
		this.txtConceptoKardex = txtConceptoKardex;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputNumber getTxtRangoDiferenciaMedidor() {
		return txtRangoDiferenciaMedidor;
	}

	public void setTxtRangoDiferenciaMedidor(InputNumber txtRangoDiferenciaMedidor) {
		this.txtRangoDiferenciaMedidor = txtRangoDiferenciaMedidor;
	}

	
	
}
