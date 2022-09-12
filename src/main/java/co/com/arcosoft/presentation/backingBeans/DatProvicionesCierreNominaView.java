package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProvisionesDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatProvicionesCierreNominaView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DatProvicionesCierreNominaView.class);
    private InputText txtAnioRegistro;
    private InputText txtCompania;
    private InputNumber txtDevengos;
    
    private SelectOneMenu txtGastoId;
    SelectItem[] selectLabor;
    
    private InputText txtMes;
    private SelectOneMenu txtPeriodoLiquidacion;
    private SelectOneMenu txtTipoMovimiento;
    private InputText txtUsuarioDigitacion;
    private InputNumber txtValorDeduccion;
    
    private SelectOneMenu txtCeptoNominaId_ConceptoNomina;
    SelectItem[] selectTrabajador;
    
    private SelectOneMenu txtTrabId_Trabajador;
    SelectItem[] selectCeptoNomina;
    
    private InputText txtDatProvicionesCierreNominaId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaFinal;
    private Calendar txtFechaInicial;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatProvicionesCierreNominaDTO> data;
    private DatProvicionesCierreNominaDTO selectedDatProvicionesCierreNomina;
    private DatProvicionesCierreNomina entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;
    
    /*** ***** Filtro ***** ***/

    private List<ListadoProvisionesDTO> dataFiltro;
    private ListadoProvisionesDTO selectedFiltro;
    
    private Calendar txtFechaInicialFiltro;
    private Calendar txtFechaFinalFiltro;
    
    private SelectOneMenu txtTrabajadorFiltro;
    SelectItem[] selectTrabajadorFiltro;
    
    private CommandButton btnConsultar;

    public DatProvicionesCierreNominaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedDatProvicionesCierreNomina = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatProvicionesCierreNomina = null;

        if (txtAnioRegistro != null) {
            txtAnioRegistro.setValue(null);
            txtAnioRegistro.setDisabled(false);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(false);
        }

        if (txtDevengos != null) {
            txtDevengos.setValue(0.0);
            txtDevengos.setDisabled(true);
        }

        if (txtGastoId != null) {
            txtGastoId.setValue(null);
            txtGastoId.setDisabled(false);
        }

        if (txtMes != null) {
            txtMes.setValue(null);
            txtMes.setDisabled(false);
        }

        if (txtPeriodoLiquidacion != null) {
            txtPeriodoLiquidacion.setValue(null);
            txtPeriodoLiquidacion.setDisabled(false);
        }

        if (txtTipoMovimiento != null) {
            txtTipoMovimiento.setValue(null);
            txtTipoMovimiento.setDisabled(false);
        }

        if (txtUsuarioDigitacion != null) {
            txtUsuarioDigitacion.setValue(null);
            txtUsuarioDigitacion.setDisabled(false);
        }

        if (txtValorDeduccion != null) {
            txtValorDeduccion.setValue(0.0);
            txtValorDeduccion.setDisabled(true);
        }

        if (txtCeptoNominaId_ConceptoNomina != null) {
            txtCeptoNominaId_ConceptoNomina.setValue(null);
            txtCeptoNominaId_ConceptoNomina.setDisabled(false);
        }

        if (txtTrabId_Trabajador != null) {
            txtTrabId_Trabajador.setValue(null);
            txtTrabId_Trabajador.setDisabled(false);
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

        if (txtDatProvicionesCierreNominaId != null) {
            txtDatProvicionesCierreNominaId.setValue(null);
            txtDatProvicionesCierreNominaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(false);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(false);
        }

        return "";
    }

    public String action_edit(ActionEvent evt) throws Exception {
        selectedFiltro = (ListadoProvisionesDTO) (evt.getComponent().getAttributes().get("selectedFiltro"));
        
        entity = businessDelegator2View.getDatProvicionesCierreNomina(selectedFiltro.getDatProvisionesCierreNominaId().longValue());
        
        if (entity != null) {
            
            txtFechaFinal.setValue(entity.getFechaFinal());
            txtFechaFinal.setDisabled(false);
            txtFechaInicial.setValue(entity.getFechaInicial());
            txtFechaInicial.setDisabled(false);
            txtGastoId.setValue(entity.getGastoId());
            txtGastoId.setDisabled(false);
            txtPeriodoLiquidacion.setValue(entity.getPeriodoLiquidacion());
            txtPeriodoLiquidacion.setDisabled(false);
            txtTipoMovimiento.setValue(entity.getTipoMovimiento());
            txtTipoMovimiento.setDisabled(false);
            txtCeptoNominaId_ConceptoNomina.setValue(entity.getConceptoNomina() != null ? entity.getConceptoNomina().getCeptoNominaId() : null);
            txtCeptoNominaId_ConceptoNomina.setDisabled(false);
            txtTrabId_Trabajador.setValue(entity.getTrabajador() != null ? entity.getTrabajador().getTrabId() : null);
            txtTrabId_Trabajador.setDisabled(false);
            
            if (entity.getTipoMovimiento() != null && entity.getTipoMovimiento().equals("Devengo")) {

				txtValorDeduccion.setValue(0.0);
				txtValorDeduccion.setDisabled(true);
				
				txtDevengos.setValue(entity.getDevengos());
				txtDevengos.setDisabled(false);
            	
            } else if (entity.getTipoMovimiento() != null && entity.getTipoMovimiento().equals("Deduccion")) {

				txtValorDeduccion.setValue(entity.getValorDeduccion());
				txtValorDeduccion.setDisabled(true);
				
				txtDevengos.setValue(0.0);
				txtDevengos.setDisabled(false);            	
            }            
            
            btnSave.setDisabled(false);
            setShowDialog(true);        	
        }

        return "";
    }

    public String action_save() {
        try {
            if ((selectedDatProvicionesCierreNomina == null) &&
                    (entity == null)) {
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
            entity = new DatProvicionesCierreNomina();
            
            Long mes = (long) (java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1);
            Long anio = (long) java.util.Calendar.YEAR;

            entity.setAnioRegistro(anio);
            entity.setCompania(Long.parseLong(getCompaniaIdSession()));
            entity.setDevengos(FacesUtils.checkDouble(txtDevengos));
            entity.setFechaCreacion(new Date());
            entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
            entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
            entity.setGastoId(FacesUtils.checkLong(txtGastoId));
            entity.setMes(mes);
            entity.setPeriodoLiquidacion(FacesUtils.checkString(txtPeriodoLiquidacion));
            entity.setTipoMovimiento(FacesUtils.checkString(txtTipoMovimiento));
            entity.setUsuarioDigitacion(Long.parseLong(getUsuarioIdSession()));
            entity.setValorDeduccion(FacesUtils.checkDouble(txtValorDeduccion));
            
            entity.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
                ? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(
                        txtCeptoNominaId_ConceptoNomina)) : null);
            
            entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
                ? businessDelegatorView.getTrabajador(FacesUtils.checkLong(
                        txtTrabId_Trabajador)) : null);
            
            businessDelegator2View.saveDatProvicionesCierreNomina(entity);
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
                Long datProvicionesCierreNominaId = new Long(selectedDatProvicionesCierreNomina.getDatProvicionesCierreNominaId());
                entity = businessDelegator2View.getDatProvicionesCierreNomina(datProvicionesCierreNominaId);
            }

            entity.setDevengos(FacesUtils.checkDouble(txtDevengos));
            entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
            entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
            entity.setFechaModificacion(new Date());
            entity.setGastoId(FacesUtils.checkLong(txtGastoId));
            entity.setPeriodoLiquidacion(FacesUtils.checkString(txtPeriodoLiquidacion));
            entity.setTipoMovimiento(FacesUtils.checkString(txtTipoMovimiento));
            entity.setValorDeduccion(FacesUtils.checkDouble(txtValorDeduccion));
            
            entity.setConceptoNomina((FacesUtils.checkLong(txtCeptoNominaId_ConceptoNomina) != null)
                ? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(
                        txtCeptoNominaId_ConceptoNomina)) : null);
            
            entity.setTrabajador((FacesUtils.checkLong(txtTrabId_Trabajador) != null)
                ? businessDelegatorView.getTrabajador(FacesUtils.checkLong(
                        txtTrabId_Trabajador)) : null);
            
            businessDelegator2View.updateDatProvicionesCierreNomina(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatProvicionesCierreNomina = (DatProvicionesCierreNominaDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedDatProvicionesCierreNomina"));

            Long datProvicionesCierreNominaId = new Long(selectedDatProvicionesCierreNomina.getDatProvicionesCierreNominaId());
            entity = businessDelegator2View.getDatProvicionesCierreNomina(datProvicionesCierreNominaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datProvicionesCierreNominaId = FacesUtils.checkLong(txtDatProvicionesCierreNominaId);
            entity = businessDelegator2View.getDatProvicionesCierreNomina(datProvicionesCierreNominaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteDatProvicionesCierreNomina(entity);
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
            selectedDatProvicionesCierreNomina = (DatProvicionesCierreNominaDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedDatProvicionesCierreNomina"));

            Long datProvicionesCierreNominaId = new Long(selectedDatProvicionesCierreNomina.getDatProvicionesCierreNominaId());
            entity = businessDelegator2View.getDatProvicionesCierreNomina(datProvicionesCierreNominaId);
            businessDelegator2View.deleteDatProvicionesCierreNomina(entity);
            data.remove(selectedDatProvicionesCierreNomina);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
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
	
	public void tipoMovimiento() {
		
		String tipoMovimiento = FacesUtils.checkString(txtTipoMovimiento);
		
		if (tipoMovimiento != null && !tipoMovimiento.equals("")) {
			
			if (tipoMovimiento.equals("Devengo")) {

				txtValorDeduccion.setValue(0.0);
				txtValorDeduccion.setDisabled(true);
				
				txtDevengos.setValue(0.0);
				txtDevengos.setDisabled(false);
				
			} else if (tipoMovimiento.equals("Deduccion")) {

				txtValorDeduccion.setValue(0.0);
				txtValorDeduccion.setDisabled(false);
				
				txtDevengos.setValue(0.0);
				txtDevengos.setDisabled(true);				
			}
		}
	}

    public InputText getTxtAnioRegistro() {
        return txtAnioRegistro;
    }

    public void setTxtAnioRegistro(InputText txtAnioRegistro) {
        this.txtAnioRegistro = txtAnioRegistro;
    }

    public InputText getTxtCompania() {
        return txtCompania;
    }

    public void setTxtCompania(InputText txtCompania) {
        this.txtCompania = txtCompania;
    }

    public InputNumber getTxtDevengos() {
        return txtDevengos;
    }

    public void setTxtDevengos(InputNumber txtDevengos) {
        this.txtDevengos = txtDevengos;
    }

    public SelectOneMenu getTxtGastoId() {
        return txtGastoId;
    }

    public void setTxtGastoId(SelectOneMenu txtGastoId) {
        this.txtGastoId = txtGastoId;
    }
	
	public SelectItem[] getSelectLabor() {

		if (selectLabor == null || selectLabor.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLabor = new SelectItem[lista.size()];

				int i = 0;
				for (Labor labor : lista) {
					selectLabor[i] = new SelectItem(labor.getLaborId(), labor.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLabor;
	}

	public void setSelectLabor(SelectItem[] selectLabor) {
		this.selectLabor = selectLabor;
	}

    public InputText getTxtMes() {
        return txtMes;
    }

    public void setTxtMes(InputText txtMes) {
        this.txtMes = txtMes;
    }

    public SelectOneMenu getTxtPeriodoLiquidacion() {
        return txtPeriodoLiquidacion;
    }

    public void setTxtPeriodoLiquidacion(SelectOneMenu txtPeriodoLiquidacion) {
        this.txtPeriodoLiquidacion = txtPeriodoLiquidacion;
    }

    public SelectOneMenu getTxtTipoMovimiento() {
        return txtTipoMovimiento;
    }

    public void setTxtTipoMovimiento(SelectOneMenu txtTipoMovimiento) {
        this.txtTipoMovimiento = txtTipoMovimiento;
    }

    public InputText getTxtUsuarioDigitacion() {
        return txtUsuarioDigitacion;
    }

    public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
        this.txtUsuarioDigitacion = txtUsuarioDigitacion;
    }

    public InputNumber getTxtValorDeduccion() {
        return txtValorDeduccion;
    }

    public void setTxtValorDeduccion(InputNumber txtValorDeduccion) {
        this.txtValorDeduccion = txtValorDeduccion;
    }

    public SelectOneMenu getTxtCeptoNominaId_ConceptoNomina() {
        return txtCeptoNominaId_ConceptoNomina;
    }

    public void setTxtCeptoNominaId_ConceptoNomina(SelectOneMenu txtCeptoNominaId_ConceptoNomina) {
        this.txtCeptoNominaId_ConceptoNomina = txtCeptoNominaId_ConceptoNomina;
    }
	
	public SelectItem[] getSelectConceptoNomina() {

		if (selectCeptoNomina == null || selectCeptoNomina.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
				selectCeptoNomina = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina ceptoNom : lista) {
					selectCeptoNomina[i] = new SelectItem(ceptoNom.getCeptoNominaId(), ceptoNom.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNomina;
	}

	public void setSelectConceptoNomina(SelectItem[] selectCeptoNomina) {
		this.selectCeptoNomina = selectCeptoNomina;
	}

    public SelectOneMenu getTxtTrabId_Trabajador() {
        return txtTrabId_Trabajador;
    }

    public void setTxtTrabId_Trabajador(SelectOneMenu txtTrabId_Trabajador) {
        this.txtTrabId_Trabajador = txtTrabId_Trabajador;
    }
	
	public SelectItem[] getSelectTrabajador() {

		if (selectTrabajador == null || selectTrabajador.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trab : lista) {
					selectTrabajador[i] = new SelectItem(trab.getTrabId(), trab.getNombre());
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

    public InputText getTxtDatProvicionesCierreNominaId() {
        return txtDatProvicionesCierreNominaId;
    }

    public void setTxtDatProvicionesCierreNominaId(
        InputText txtDatProvicionesCierreNominaId) {
        this.txtDatProvicionesCierreNominaId = txtDatProvicionesCierreNominaId;
    }

    public List<DatProvicionesCierreNominaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataDatProvicionesCierreNomina();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<DatProvicionesCierreNominaDTO> datProvicionesCierreNominaDTO) {
        this.data = datProvicionesCierreNominaDTO;
    }

    public DatProvicionesCierreNominaDTO getSelectedDatProvicionesCierreNomina() {
        return selectedDatProvicionesCierreNomina;
    }

    public void setSelectedDatProvicionesCierreNomina(
        DatProvicionesCierreNominaDTO datProvicionesCierreNomina) {
        this.selectedDatProvicionesCierreNomina = datProvicionesCierreNomina;
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
        return businessDelegator2View;
    }

    public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
        this.businessDelegator2View = businessDelegator2View;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

	public List<ListadoProvisionesDTO> getDataFiltro() {
		return dataFiltro;
	}

	public void setDataFiltro(List<ListadoProvisionesDTO> dataFiltro) {
		this.dataFiltro = dataFiltro;
	}
	
	public void consultar() throws Exception {
		
		Long compania = Long.parseLong(getCompaniaIdSession());
		Date fechaInicial = FacesUtils.checkDate(txtFechaInicialFiltro);
		Date fechaFinal = FacesUtils.checkDate(txtFechaFinalFiltro);
		
		Long flagTrabajador = 1L;
		String trabId = "0";
		if (txtTrabajadorFiltro.getValue() != null && !txtTrabajadorFiltro.getValue().equals("")) {
			trabId = FacesUtils.checkString(txtTrabajadorFiltro);
			flagTrabajador = 0L;
		}
		
		if (fechaFinal != null && fechaInicial != null) {
			
			dataFiltro = businessDelegator2View.pr_listar_proviciones(compania, fechaInicial, fechaFinal, trabId, flagTrabajador);
		}
	}

	public ListadoProvisionesDTO getSelectedFiltro() {
		return selectedFiltro;
	}

	public void setSelectedFiltro(ListadoProvisionesDTO selectedFiltro) {
		this.selectedFiltro = selectedFiltro;
	}

	public Calendar getTxtFechaInicialFiltro() {
		return txtFechaInicialFiltro;
	}

	public void setTxtFechaInicialFiltro(Calendar txtFechaInicialFiltro) {
		this.txtFechaInicialFiltro = txtFechaInicialFiltro;
	}

	public Calendar getTxtFechaFinalFiltro() {
		return txtFechaFinalFiltro;
	}

	public void setTxtFechaFinalFiltro(Calendar txtFechaFinalFiltro) {
		this.txtFechaFinalFiltro = txtFechaFinalFiltro;
	}

	public SelectOneMenu getTxtTrabajadorFiltro() {
		return txtTrabajadorFiltro;
	}

	public void setTxtTrabajadorFiltro(SelectOneMenu txtTrabajadorFiltro) {
		this.txtTrabajadorFiltro = txtTrabajadorFiltro;
	}
	
	public SelectItem[] getSelectTrabajadorFiltro() {

		if (selectTrabajadorFiltro == null || selectTrabajadorFiltro.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajadorFiltro = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trab : lista) {
					selectTrabajadorFiltro[i] = new SelectItem(trab.getTrabId(), trab.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajadorFiltro;
	}

	public void setSelectTrabajadorFiltro(SelectItem[] selectTrabajadorFiltro) {
		this.selectTrabajadorFiltro = selectTrabajadorFiltro;
	}

	public CommandButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(CommandButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}
}