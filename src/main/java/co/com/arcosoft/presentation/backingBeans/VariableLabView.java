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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaLaboratorioVariable;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.VariableLab;
import co.com.arcosoft.modelo.dto.VariableLabDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VariableLabView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VariableLabView.class);
    private InputText txtCodigo;
    private InputTextarea txtConsultaSql;
    private InputText txtCompania;
    private SelectOneRadio txtEstado;
    private InputTextarea txtFormula;
    private InputTextarea txtInfoAdicional;
    private InputTextarea txtInfoAdicional2;
    private InputText txtNombre;
    private Spinner txtNumeroDecimales;
    private SelectOneMenu txtPeriocidadVariable;
    private SelectOneMenu txtTipoDato;
    private SelectOneMenu txtTipoDeAcumulado;
    private SelectOneMenu txtTipoVariable;
    private InputText txtValorMaximo;
    private InputText txtValorMinimo;
    private InputText txtVariableLabId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private InputText txtOrden;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<VariableLabDTO> data;
    private VariableLabDTO selectedVariableLab;
    private VariableLab entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    private int activeTapIndex = 0;

    public VariableLabView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedVariableLab = null;
        setShowDialog(true);
		activeTapIndex = 0;

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedVariableLab = null;
		PrimeFaces.current().resetInputs(":frm");
		
        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(false);
        }
        
        if (txtConsultaSql != null) {
        	txtConsultaSql.setValue(null);
        	txtConsultaSql.setDisabled(true);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtOrden != null) {
        	txtOrden.setValue(null);
        	txtOrden.setDisabled(true);
        }

        if (txtEstado != null) {
            txtEstado.setValue("A");
            txtEstado.setDisabled(true);
        }

        if (txtFormula != null) {
            txtFormula.setValue(null);
            txtFormula.setDisabled(true);
        }

        if (txtInfoAdicional != null) {
            txtInfoAdicional.setValue(null);
            txtInfoAdicional.setDisabled(true);
        }

        if (txtInfoAdicional2 != null) {
            txtInfoAdicional2.setValue(null);
            txtInfoAdicional2.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtNumeroDecimales != null) {
            txtNumeroDecimales.setValue(null);
            txtNumeroDecimales.setDisabled(true);
        }

        if (txtPeriocidadVariable != null) {
            txtPeriocidadVariable.setValue(null);
            txtPeriocidadVariable.setDisabled(true);
        }

        if (txtTipoDato != null) {
            txtTipoDato.setValue(null);
            txtTipoDato.setDisabled(true);
        }

        if (txtTipoDeAcumulado != null) {
            txtTipoDeAcumulado.setValue(null);
            txtTipoDeAcumulado.setDisabled(true);
        }

        if (txtTipoVariable != null) {
            txtTipoVariable.setValue(null);
            txtTipoVariable.setDisabled(true);
        }

        if (txtValorMaximo != null) {
            txtValorMaximo.setValue(null);
            txtValorMaximo.setDisabled(true);
        }

        if (txtValorMinimo != null) {
            txtValorMinimo.setValue(null);
            txtValorMinimo.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtVariableLabId != null) {
            txtVariableLabId.setValue(null);
            txtVariableLabId.setDisabled(true);
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
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaModificacion() {
        Date inputDate = (Date) txtFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<VariableLab> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVariableLab(condicion, null, null) : null;

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
            txtEstado.setDisabled(false);
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setDisabled(false);
            txtPeriocidadVariable.setDisabled(false);
            txtTipoDato.setDisabled(false);
            txtTipoVariable.setDisabled(false);
            txtVariableLabId.setDisabled(false);

        		if (txtTipoDato.getValue() != null
        				&& txtTipoDato.getValue().equals("Decimal")) {

        			txtValorMaximo.setDisabled(false);
        			txtValorMinimo.setDisabled(false);
        			txtNumeroDecimales.setDisabled(false);
        			txtTipoDeAcumulado.setDisabled(false);
        			}


        		if (txtTipoVariable.getValue() != null
        				&& txtTipoVariable.getValue().equals("Formula")) {

        			txtFormula.setDisabled(false);
        			txtConsultaSql.setDisabled(true);
        			
        		} if (txtTipoVariable.getValue() != null
        				&& txtTipoVariable.getValue().equals("Digitada")) {

        			txtFormula.setDisabled(true);
        			txtConsultaSql.setDisabled(true);
        			
        		} if (txtTipoVariable.getValue() != null
        				&& txtTipoVariable.getValue().equals("Consulta_Sql")) {

        			txtFormula.setDisabled(true);
        			txtConsultaSql.setDisabled(false);
        		}

            btnSave.setDisabled(false);
    		activeTapIndex = 0;

        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtFormula.setValue(entity.getFormula());
            txtInfoAdicional.setValue(entity.getInfoAdicional());
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtNumeroDecimales.setValue(entity.getNumeroDecimales());
            txtPeriocidadVariable.setValue(entity.getPeriocidadVariable());
            txtPeriocidadVariable.setDisabled(false);
            txtTipoDato.setValue(entity.getTipoDato());
            txtTipoDato.setDisabled(false);
            txtTipoDeAcumulado.setValue(entity.getTipoDeAcumulado());
            txtTipoVariable.setValue(entity.getTipoVariable());
            txtTipoVariable.setDisabled(false);
            txtValorMaximo.setValue(entity.getValorMaximo());
            txtValorMinimo.setValue(entity.getValorMinimo());
            txtVariableLabId.setValue(entity.getVariableLabId());
            txtVariableLabId.setDisabled(true);
            txtConsultaSql.setValue(entity.getConsultaSql());
            
    		if (txtTipoDato.getValue() != null
    				&& txtTipoDato.getValue().equals("Decimal")) {

    			txtValorMaximo.setDisabled(false);
    			txtValorMinimo.setDisabled(false);
    			txtNumeroDecimales.setDisabled(false);
    			txtTipoDeAcumulado.setDisabled(false);
    			}


	    		if (txtTipoVariable.getValue() != null
	    				&& txtTipoVariable.getValue().equals("Formula")) {
	
	    			txtFormula.setDisabled(false);
	    			txtConsultaSql.setDisabled(true);
	    			
	    		} if (txtTipoVariable.getValue() != null
	    				&& txtTipoVariable.getValue().equals("Digitada")) {
	
	    			txtFormula.setDisabled(true);
	    			txtConsultaSql.setDisabled(true);
	    			
	    		} if (txtTipoVariable.getValue() != null
	    				&& txtTipoVariable.getValue().equals("Consulta_Sql")) {
	
	    			txtFormula.setDisabled(true);
	    			txtConsultaSql.setDisabled(false);
	    		}

            
            btnSave.setDisabled(false);
    		activeTapIndex = 0;

    		
            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

   
    
    public String action_edit(ActionEvent evt) {
        selectedVariableLab = (VariableLabDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedVariableLab"));
		try {

			String codigo = selectedVariableLab.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<VariableLab> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInVariableLab(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

        txtCodigo.setValue(entity.getCodigo());
        txtCodigo.setDisabled(false);
        txtEstado.setValue(entity.getEstado());
        txtEstado.setDisabled(false);
        txtFormula.setValue(entity.getFormula());
        txtInfoAdicional.setValue(entity.getInfoAdicional());
        txtInfoAdicional.setDisabled(false);
        txtInfoAdicional2.setValue(entity.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtNombre.setValue(entity.getNombre());
        txtNombre.setDisabled(false);
        txtNumeroDecimales.setValue(entity.getNumeroDecimales());
        txtPeriocidadVariable.setValue(entity.getPeriocidadVariable());
        txtPeriocidadVariable.setDisabled(false);
        txtTipoDato.setValue(entity.getTipoDato());
        txtTipoDato.setDisabled(false);
        txtTipoDeAcumulado.setValue(entity.getTipoDeAcumulado());
        txtTipoVariable.setValue(entity.getTipoVariable());
        txtTipoVariable.setDisabled(false);
        txtValorMaximo.setValue(entity.getValorMaximo());
        txtValorMinimo.setValue(entity.getValorMinimo());
        txtVariableLabId.setValue(entity.getVariableLabId());
        txtVariableLabId.setDisabled(true);
        txtConsultaSql.setValue(entity.getConsultaSql());
        
		if (txtTipoDato.getValue() != null
				&& txtTipoDato.getValue().equals("Decimal")) {

			txtValorMaximo.setDisabled(false);
			txtValorMinimo.setDisabled(false);
			txtNumeroDecimales.setDisabled(false);
			txtTipoDeAcumulado.setDisabled(false);
			}


		if (txtTipoVariable.getValue() != null
				&& txtTipoVariable.getValue().equals("Formula")) {

			txtFormula.setDisabled(false);
			txtConsultaSql.setDisabled(true);
			
		} if (txtTipoVariable.getValue() != null
				&& txtTipoVariable.getValue().equals("Digitada")) {

			txtFormula.setDisabled(true);
			txtConsultaSql.setDisabled(true);
			
		} if (txtTipoVariable.getValue() != null
				&& txtTipoVariable.getValue().equals("Consulta_Sql")) {

			txtFormula.setDisabled(true);
			txtConsultaSql.setDisabled(false);
		}

        btnSave.setDisabled(false);
		activeTapIndex = 0;
		setShowDialog(true); 
	}
} catch (Exception e) {
	entity = null;
}

return "";
}

    public String action_save() {
        try {
            if ((selectedVariableLab == null) && (entity == null)) {
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
            entity = new VariableLab();

            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			
			entity.setEstado("A");
			entity.setCompania(compania);
			entity.setFechaCreacion(date);            
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setConsultaSql(FacesUtils.checkString(txtConsultaSql));            
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setFormula(FacesUtils.checkString(txtFormula));
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNumeroDecimales(FacesUtils.checkInteger(
                    txtNumeroDecimales));
            entity.setPeriocidadVariable(FacesUtils.checkString(
                    txtPeriocidadVariable));
            entity.setTipoDato(FacesUtils.checkString(txtTipoDato));
            entity.setTipoDeAcumulado(FacesUtils.checkString(txtTipoDeAcumulado));
            entity.setTipoVariable(FacesUtils.checkString(txtTipoVariable));
            entity.setValorMaximo(FacesUtils.checkDouble(txtValorMaximo));
            entity.setValorMinimo(FacesUtils.checkDouble(txtValorMinimo));
            entity.setOrden(FacesUtils.checkLong(txtOrden));
            businessDelegatorView.saveVariableLab(entity);
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
                Long variableLabId = new Long(selectedVariableLab.getVariableLabId());
                entity = businessDelegatorView.getVariableLab(variableLabId);
            }

            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			
			entity.setEstado("A");
			entity.setCompania(compania);
			entity.setFechaModificacion(date);
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setConsultaSql(FacesUtils.checkString(txtConsultaSql));
            entity.setFormula(FacesUtils.checkString(txtFormula));
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNumeroDecimales(FacesUtils.checkInteger(
                    txtNumeroDecimales));
            entity.setPeriocidadVariable(FacesUtils.checkString(
                    txtPeriocidadVariable));
            entity.setTipoDato(FacesUtils.checkString(txtTipoDato));
            entity.setTipoDeAcumulado(FacesUtils.checkString(txtTipoDeAcumulado));
            entity.setTipoVariable(FacesUtils.checkString(txtTipoVariable));
            entity.setValorMaximo(FacesUtils.checkDouble(txtValorMaximo));
            entity.setValorMinimo(FacesUtils.checkDouble(txtValorMinimo));
            businessDelegatorView.updateVariableLab(entity);
            entity.setOrden(FacesUtils.checkLong(txtOrden));
            
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedVariableLab = (VariableLabDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedVariableLab"));

            Long variableLabId = new Long(selectedVariableLab.getVariableLabId());
            entity = businessDelegatorView.getVariableLab(variableLabId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long variableLabId = FacesUtils.checkLong(txtVariableLabId);
            entity = businessDelegatorView.getVariableLab(variableLabId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteVariableLab(entity);
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
            selectedVariableLab = (VariableLabDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedVariableLab"));

            Long variableLabId = new Long(selectedVariableLab.getVariableLabId());
            entity = businessDelegatorView.getVariableLab(variableLabId);
            businessDelegatorView.deleteVariableLab(entity);
            data.remove(selectedVariableLab);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, String consultaSql,
    	Long compania, String estado, Date fechaCreacion, Date fechaModificacion,
        String formula, String infoAdicional, String infoAdicional2,
        String nombre, Integer numeroDecimales, String periocidadVariable,
        String tipoDato, String tipoDeAcumulado, String tipoVariable,
        Double valorMaximo, Double valorMinimo, Long variableLabId)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setConsultaSql(FacesUtils.checkString(consultaSql));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setFormula(FacesUtils.checkString(formula));
            entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setNumeroDecimales(FacesUtils.checkInteger(numeroDecimales));
            entity.setPeriocidadVariable(FacesUtils.checkString(
                    periocidadVariable));
            entity.setTipoDato(FacesUtils.checkString(tipoDato));
            entity.setTipoDeAcumulado(FacesUtils.checkString(tipoDeAcumulado));
            entity.setTipoVariable(FacesUtils.checkString(tipoVariable));
            entity.setValorMaximo(FacesUtils.checkDouble(valorMaximo));
            entity.setValorMinimo(FacesUtils.checkDouble(valorMinimo));
            businessDelegatorView.updateVariableLab(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("VariableLabView").requestRender();
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

    
    
    /**
	 * @return the txtEstado
	 */
	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	/**
	 * @param txtEstado the txtEstado to set
	 */
	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	/**
	 * @return the txtFormula
	 */
	public InputTextarea getTxtFormula() {
		return txtFormula;
	}

	/**
	 * @param txtFormula the txtFormula to set
	 */
	public void setTxtFormula(InputTextarea txtFormula) {
		this.txtFormula = txtFormula;
	}

	/**
	 * @return the txtInfoAdicional
	 */
	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}

	/**
	 * @param txtInfoAdicional the txtInfoAdicional to set
	 */
	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}

	/**
	 * @return the txtInfoAdicional2
	 */
	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}

	/**
	 * @param txtInfoAdicional2 the txtInfoAdicional2 to set
	 */
	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}

	/**
	 * @return the txtNombre
	 */
	public InputText getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @param txtNombre the txtNombre to set
	 */
	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * @return the txtNumeroDecimales
	 */
	public Spinner getTxtNumeroDecimales() {
		return txtNumeroDecimales;
	}

	/**
	 * @param txtNumeroDecimales the txtNumeroDecimales to set
	 */
	public void setTxtNumeroDecimales(Spinner txtNumeroDecimales) {
		this.txtNumeroDecimales = txtNumeroDecimales;
	}

	/**
	 * @return the txtPeriocidadVariable
	 */
	public SelectOneMenu getTxtPeriocidadVariable() {
		return txtPeriocidadVariable;
	}

	/**
	 * @param txtPeriocidadVariable the txtPeriocidadVariable to set
	 */
	public void setTxtPeriocidadVariable(SelectOneMenu txtPeriocidadVariable) {
		this.txtPeriocidadVariable = txtPeriocidadVariable;
	}

	/**
	 * @return the txtTipoDato
	 */
	public SelectOneMenu getTxtTipoDato() {
		return txtTipoDato;
	}

	/**
	 * @param txtTipoDato the txtTipoDato to set
	 */
	public void setTxtTipoDato(SelectOneMenu txtTipoDato) {
		this.txtTipoDato = txtTipoDato;
	}

	/**
	 * @return the txtTipoDeAcumulado
	 */
	public SelectOneMenu getTxtTipoDeAcumulado() {
		return txtTipoDeAcumulado;
	}

	/**
	 * @param txtTipoDeAcumulado the txtTipoDeAcumulado to set
	 */
	public void setTxtTipoDeAcumulado(SelectOneMenu txtTipoDeAcumulado) {
		this.txtTipoDeAcumulado = txtTipoDeAcumulado;
	}

	/**
	 * @return the txtTipoVariable
	 */
	public SelectOneMenu getTxtTipoVariable() {
		return txtTipoVariable;
	}

	/**
	 * @param txtTipoVariable the txtTipoVariable to set
	 */
	public void setTxtTipoVariable(SelectOneMenu txtTipoVariable) {
		this.txtTipoVariable = txtTipoVariable;
	}

	/**
	 * @return the txtOrden
	 */
	public InputText getTxtOrden() {
		return txtOrden;
	}

	/**
	 * @param txtOrden the txtOrden to set
	 */
	public void setTxtOrden(InputText txtOrden) {
		this.txtOrden = txtOrden;
	}

	/**
	 * @return the entity
	 */
	public VariableLab getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(VariableLab entity) {
		this.entity = entity;
	}

	/**
	 * @return the activeTapIndex
	 */
	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	/**
	 * @param activeTapIndex the activeTapIndex to set
	 */
	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtValorMaximo() {
        return txtValorMaximo;
    }

    public void setTxtValorMaximo(InputText txtValorMaximo) {
        this.txtValorMaximo = txtValorMaximo;
    }

    public InputText getTxtValorMinimo() {
        return txtValorMinimo;
    }

    public void setTxtValorMinimo(InputText txtValorMinimo) {
        this.txtValorMinimo = txtValorMinimo;
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

    public InputText getTxtVariableLabId() {
        return txtVariableLabId;
    }

    public void setTxtVariableLabId(InputText txtVariableLabId) {
        this.txtVariableLabId = txtVariableLabId;
    }

    public List<VariableLabDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataVariableLab();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<VariableLabDTO> variableLabDTO) {
        this.data = variableLabDTO;
    }

    public VariableLabDTO getSelectedVariableLab() {
        return selectedVariableLab;
    }

    public void setSelectedVariableLab(VariableLabDTO variableLab) {
        this.selectedVariableLab = variableLab;
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

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
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
	

	

	public void listener_tipoDato() {

		if (txtTipoDato.getValue() != null
				&& txtTipoDato.getValue().equals("Decimal")) {

			txtValorMaximo.setDisabled(false);
			txtValorMinimo.setDisabled(false);
			txtNumeroDecimales.setDisabled(false);
			txtTipoDeAcumulado.setDisabled(false);
			}
	}


	public void listener_tipoVariable() {

		if (txtTipoVariable.getValue() != null
				&& txtTipoVariable.getValue().equals("Formula")) {

			txtFormula.setDisabled(false);
			txtConsultaSql.setDisabled(true);
			
		} if (txtTipoVariable.getValue() != null
				&& txtTipoVariable.getValue().equals("Digitada")) {

			txtFormula.setDisabled(true);
			txtConsultaSql.setDisabled(true);
			
		} if (txtTipoVariable.getValue() != null
				&& txtTipoVariable.getValue().equals("Consulta_Sql")) {

			txtFormula.setDisabled(true);
			txtConsultaSql.setDisabled(false);
		}
	}

	public InputTextarea getTxtConsultaSql() {
		return txtConsultaSql;
	}

	public void setTxtConsultaSql(InputTextarea txtConsultaSql) {
		this.txtConsultaSql = txtConsultaSql;
	}	
	
	
	

	public String actionDeleteMovimientos(ActionEvent evt) {
		selectedVariableLab = (VariableLabDTO) (evt.getComponent().getAttributes().get("selectedVariableLab"));

		try {

			Long variableLabId = selectedVariableLab.getVariableLabId().longValue();
			Object[] condicion1 = { "variableLab.variableLabId", true, variableLabId, "=" };
			List<AnaLaboratorioVariable> lista2 = (variableLabId != null)
					? businessDelegatorView.findByCriteriaInAnaLaboratorioVariable(condicion1, null, null)
					: null;

			if (lista2 != null && lista2.size() > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"La variable que esta intentando eliminar ya esta asociada a un grupo!", "Verifique por favor!!!"));
			} else {

				//Long iD = selectedVariableLab.getAnaLabId().longValue();
				Object[] condicion = { "variableLabId", true, variableLabId, "=" };
				List<VariableLab> lista = (variableLabId != null)
						? businessDelegatorView.findByCriteriaInVariableLab(condicion, null, null)
						: null;

				if (lista != null && lista.size() > 0) {
					entity = lista.get(0);
					
					 businessDelegatorView.deleteVariableLab(entity);
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Proceso exitoso!", "La variable  fue eliminada exitosamente!!!"));

				}

			}

			setShowDialog(true);

			activeTapIndex = 0;
			getData();

		} catch (Exception e) {
			entity = null;
		}

		return "";
	}


}