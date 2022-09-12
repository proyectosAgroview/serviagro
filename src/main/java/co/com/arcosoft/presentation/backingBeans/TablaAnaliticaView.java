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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TablaAnalitica;
import co.com.arcosoft.modelo.TablaAnaliticaDetalle;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDTO;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDetalleDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TablaAnaliticaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TablaAnaliticaView.class);
    private InputText txtCodigo;
    private InputText txtCompania;
    private SelectOneRadio txtEstado;
    private InputTextarea txtInfoAdicional;
    private InputTextarea txtInfoAdicional2;
    private InputText txtNombre;
    private InputText txtVariableEntrada1;
    private InputText txtVariableEntrada2;
    private InputText txtVariableEntrada3;
    private InputText txtVariableSalida1;
    private InputText txtVariableSalida2;
    private InputText txtTablaAnaliticaId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TablaAnaliticaDTO> data;
    private TablaAnaliticaDTO selectedTablaAnalitica;
    private TablaAnalitica entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

	private int activeTapIndex = 0;
    
    /*** TablaAnaliticaDetalle ***/    

	private List<TablaAnaliticaDetalleDTO> dataTabAna;
	private TablaAnaliticaDetalleDTO selectedTabAna;
	private TablaAnaliticaDetalle entityTabAnaDet;
    
    private InputText txtValorVariableEntrada1; 
    private InputText txtValorVariableEntrada2; 
    private InputText txtValorVariableEntrada3; 
    private InputText txtValorVariableSalida1;  
    private InputText txtValorVariableSalida2; 
    
    private CommandButton btnAgregarVarAna;
    
    /*** TablaAnaliticaDetalle ***/

    public TablaAnaliticaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TablaAnaliticaDTO tablaAnaliticaDTO = (TablaAnaliticaDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(tablaAnaliticaDTO.getCodigo());

            if (txtCompania == null) {
                txtCompania = new InputText();
            }

            txtCompania.setValue(tablaAnaliticaDTO.getCompania());

            if (txtEstado == null) {
                txtEstado = new SelectOneRadio();
            }

            txtEstado.setValue(tablaAnaliticaDTO.getEstado());

            if (txtInfoAdicional == null) {
                txtInfoAdicional = new InputTextarea();
            }

            txtInfoAdicional.setValue(tablaAnaliticaDTO.getInfoAdicional());

            if (txtInfoAdicional2 == null) {
                txtInfoAdicional2 = new InputTextarea();
            }

            txtInfoAdicional2.setValue(tablaAnaliticaDTO.getInfoAdicional2());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(tablaAnaliticaDTO.getNombre());

            if (txtVariableEntrada1 == null) {
                txtVariableEntrada1 = new InputText();
            }

            txtVariableEntrada1.setValue(tablaAnaliticaDTO.getVariableEntrada1());

            if (txtVariableEntrada2 == null) {
                txtVariableEntrada2 = new InputText();
            }

            txtVariableEntrada2.setValue(tablaAnaliticaDTO.getVariableEntrada2());

            if (txtVariableEntrada3 == null) {
                txtVariableEntrada3 = new InputText();
            }

            txtVariableEntrada3.setValue(tablaAnaliticaDTO.getVariableEntrada3());

            if (txtVariableSalida1 == null) {
                txtVariableSalida1 = new InputText();
            }

            txtVariableSalida1.setValue(tablaAnaliticaDTO.getVariableSalida1());

            if (txtVariableSalida2 == null) {
                txtVariableSalida2 = new InputText();
            }

            txtVariableSalida2.setValue(tablaAnaliticaDTO.getVariableSalida2());

            if (txtTablaAnaliticaId == null) {
                txtTablaAnaliticaId = new InputText();
            }

            txtTablaAnaliticaId.setValue(tablaAnaliticaDTO.getTablaAnaliticaId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(tablaAnaliticaDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(tablaAnaliticaDTO.getFechaModificacion());

            Long tablaAnaliticaId = FacesUtils.checkLong(txtTablaAnaliticaId);
            entity = businessDelegator2View.getTablaAnalitica(tablaAnaliticaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTablaAnalitica = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTablaAnalitica = null;
        activeTapIndex = 0;

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(false);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtEstado != null) {
            txtEstado.setValue("A");
            txtEstado.setDisabled(true);
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

        if (txtVariableEntrada1 != null) {
            txtVariableEntrada1.setValue(null);
            txtVariableEntrada1.setDisabled(true);
        }

        if (txtVariableEntrada2 != null) {
            txtVariableEntrada2.setValue(null);
            txtVariableEntrada2.setDisabled(true);
        }

        if (txtVariableEntrada3 != null) {
            txtVariableEntrada3.setValue(null);
            txtVariableEntrada3.setDisabled(true);
        }

        if (txtVariableSalida1 != null) {
            txtVariableSalida1.setValue(null);
            txtVariableSalida1.setDisabled(true);
        }

        if (txtVariableSalida2 != null) {
            txtVariableSalida2.setValue(null);
            txtVariableSalida2.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtTablaAnaliticaId != null) {
            txtTablaAnaliticaId.setValue(null);
            txtTablaAnaliticaId.setDisabled(false);
        }
        
        /*** TablaAnaliticaDetalle ***/
        
        if (dataTabAna != null) {
        	dataTabAna = null;
        }
        
        if (btnAgregarVarAna != null) {
        	btnAgregarVarAna.setDisabled(false);
		}
        
        if (txtValorVariableEntrada1 != null) {
        	txtValorVariableEntrada1.setValue(null);
        	txtValorVariableEntrada1.setDisabled(false);
        }
        
        if (txtValorVariableEntrada2 != null) {
        	txtValorVariableEntrada2.setValue(null);
        	txtValorVariableEntrada2.setDisabled(false);
        }
        
        if (txtValorVariableEntrada3 != null) {
        	txtValorVariableEntrada3.setValue(null);
        	txtValorVariableEntrada3.setDisabled(false);
        }
        
        if (txtValorVariableSalida1 != null) {
        	txtValorVariableSalida1.setValue(null);
        	txtValorVariableSalida1.setDisabled(false);
        }
        
        if (txtValorVariableSalida2 != null) {
        	txtValorVariableSalida2.setValue(null);
        	txtValorVariableSalida2.setDisabled(false);
        }
        
        /*** TablaAnaliticaDetalle ***/

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

    public void listener_txtCodigo() throws Exception {
    	
        try {
        	String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Long idCompania = new Long(getCompaniaIdSession());
			Object[] condicion = { "codigo", true, codigo, "=", "compania", false, idCompania, "=" };
			List<TablaAnalitica> lista = (codigo != null)
					? businessDelegator2View.findByCriteriaInTablaAnalitica(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else {
				FacesUtils.addInfoMessage(
						"Upps! El Código digitado no existe!, si deseas puedes crear un nuevo registro con el código: "
								+ codigo);	    	
	    		action_clear();	    
	    		txtCodigo.setValue(codigo);
			}
	    		
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtEstado.setDisabled(false);
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setDisabled(false);
            txtVariableEntrada1.setDisabled(false);
            txtVariableEntrada2.setDisabled(false);
            txtVariableEntrada3.setDisabled(false);
            txtVariableSalida1.setDisabled(false);
            txtVariableSalida2.setDisabled(false);
            
            txtValorVariableEntrada1.setDisabled(false);
            txtValorVariableEntrada2.setDisabled(false);
            txtValorVariableEntrada3.setDisabled(false);
            txtValorVariableSalida1.setDisabled(false);
            txtValorVariableSalida2.setDisabled(false);
            
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtInfoAdicional.setValue(entity.getInfoAdicional());
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtVariableEntrada1.setValue(entity.getVariableEntrada1());
            txtVariableEntrada1.setDisabled(false);
            txtVariableEntrada2.setValue(entity.getVariableEntrada2());
            txtVariableEntrada2.setDisabled(false);
            txtVariableEntrada3.setValue(entity.getVariableEntrada3());
            txtVariableEntrada3.setDisabled(false);
            txtVariableSalida1.setValue(entity.getVariableSalida1());
            txtVariableSalida1.setDisabled(false);
            txtVariableSalida2.setValue(entity.getVariableSalida2());
            txtVariableSalida2.setDisabled(false);
            txtTablaAnaliticaId.setValue(entity.getTablaAnaliticaId());
            txtTablaAnaliticaId.setDisabled(true);
            
            Long tablaAnaliticaId = FacesUtils.checkLong(txtTablaAnaliticaId);
            
            dataTabAna = null;
            dataTabAna = businessDelegator2View.getDataTablaAnaliticaDetalleByTablaAnalitica(tablaAnaliticaId);
            
            txtValorVariableEntrada1.setDisabled(false);
            txtValorVariableEntrada2.setDisabled(false);
            txtValorVariableEntrada3.setDisabled(false);
            txtValorVariableSalida1.setDisabled(false);
            txtValorVariableSalida2.setDisabled(false);
            
            btnAgregarVarAna.setDisabled(false);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }
    
    public void action_agregarVariableAnalitica() throws NumberFormatException, Exception {
		
		Double valVarEn1 = FacesUtils.checkDouble(txtValorVariableEntrada1);
		Double valVarEn2 = FacesUtils.checkDouble(txtValorVariableEntrada2);
		Double valVarEn3 = FacesUtils.checkDouble(txtValorVariableEntrada3);
		Double valVarSa1 = FacesUtils.checkDouble(txtValorVariableSalida1);
		Double valVarSa2 = FacesUtils.checkDouble(txtValorVariableSalida2);

		if (dataTabAna == null) {
			dataTabAna = new ArrayList<TablaAnaliticaDetalleDTO>();
		}

		TablaAnaliticaDetalleDTO TablaAnaliticaDetalleDTO = new TablaAnaliticaDetalleDTO();
		TablaAnaliticaDetalleDTO.setValorVariableEntrada1(valVarEn1);
		TablaAnaliticaDetalleDTO.setValorVariableEntrada2(valVarEn2);
		TablaAnaliticaDetalleDTO.setValorVariableEntrada3(valVarEn3);
		TablaAnaliticaDetalleDTO.setValorVariableSalida1(valVarSa1);
		TablaAnaliticaDetalleDTO.setValorVariableSalida2(valVarSa2);		

		dataTabAna.add(TablaAnaliticaDetalleDTO);		
			
		valVarEn1 = null;
		valVarEn2 = null;
		valVarEn3 = null;
		valVarSa1 = null;
		valVarSa2 = null;
	}

    public String action_edit(ActionEvent evt) throws Exception {
        selectedTablaAnalitica = (TablaAnaliticaDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedTablaAnalitica"));
        txtCodigo.setValue(selectedTablaAnalitica.getCodigo());
        txtCodigo.setDisabled(false);
        txtEstado.setValue(selectedTablaAnalitica.getEstado());
        txtEstado.setDisabled(false);
        txtInfoAdicional.setValue(selectedTablaAnalitica.getInfoAdicional());
        txtInfoAdicional.setDisabled(false);
        txtInfoAdicional2.setValue(selectedTablaAnalitica.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtNombre.setValue(selectedTablaAnalitica.getNombre());
        txtNombre.setDisabled(false);
        txtVariableEntrada1.setValue(selectedTablaAnalitica.getVariableEntrada1());
        txtVariableEntrada1.setDisabled(false);
        txtVariableEntrada2.setValue(selectedTablaAnalitica.getVariableEntrada2());
        txtVariableEntrada2.setDisabled(false);
        txtVariableEntrada3.setValue(selectedTablaAnalitica.getVariableEntrada3());
        txtVariableEntrada3.setDisabled(false);
        txtVariableSalida1.setValue(selectedTablaAnalitica.getVariableSalida1());
        txtVariableSalida1.setDisabled(false);
        txtVariableSalida2.setValue(selectedTablaAnalitica.getVariableSalida2());
        txtVariableSalida2.setDisabled(false);
        txtTablaAnaliticaId.setValue(selectedTablaAnalitica.getTablaAnaliticaId());
        txtTablaAnaliticaId.setDisabled(true);
        
        Long tablaAnaliticaId = FacesUtils.checkLong(txtTablaAnaliticaId);
        
        dataTabAna = null;
        dataTabAna = businessDelegator2View.getDataTablaAnaliticaDetalleByTablaAnalitica(tablaAnaliticaId);
        
        txtValorVariableEntrada1.setDisabled(false);
        txtValorVariableEntrada2.setDisabled(false);
        txtValorVariableEntrada3.setDisabled(false);
        txtValorVariableSalida1.setDisabled(false);
        txtValorVariableSalida2.setDisabled(false);

        btnAgregarVarAna.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);
        
        activeTapIndex = 0;

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTablaAnalitica == null) && (entity == null)) {
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
            entity = new TablaAnalitica();
            
            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Long usuario = new Long(getUsuarioIdSession());

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCompania(compania);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaCreacion(date);
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuario(usuario);
            entity.setVariableEntrada1(FacesUtils.checkString(
                    txtVariableEntrada1));
            entity.setVariableEntrada2(FacesUtils.checkString(
                    txtVariableEntrada2));
            entity.setVariableEntrada3(FacesUtils.checkString(
                    txtVariableEntrada3));
            entity.setVariableSalida1(FacesUtils.checkString(txtVariableSalida1));
            entity.setVariableSalida2(FacesUtils.checkString(txtVariableSalida2));
            businessDelegator2View.saveTablaAnalitica(entity, dataTabAna);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }
        
        action_clear();

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long tablaAnaliticaId = new Long(selectedTablaAnalitica.getTablaAnaliticaId());
                entity = businessDelegator2View.getTablaAnalitica(tablaAnaliticaId);
            }
            
            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			Long usuario = new Long(getUsuarioIdSession());

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCompania(compania);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaModificacion(date);
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuario(usuario);
            entity.setVariableEntrada1(FacesUtils.checkString(
                    txtVariableEntrada1));
            entity.setVariableEntrada2(FacesUtils.checkString(
                    txtVariableEntrada2));
            entity.setVariableEntrada3(FacesUtils.checkString(
                    txtVariableEntrada3));
            entity.setVariableSalida1(FacesUtils.checkString(txtVariableSalida1));
            entity.setVariableSalida2(FacesUtils.checkString(txtVariableSalida2));
            businessDelegator2View.updateTablaAnalitica(entity, dataTabAna);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }
        
        action_clear();

        return "";
    }
    
    public void onCellEdit(CellEditEvent event) throws Exception {

    	selectedTabAna = (TablaAnaliticaDetalleDTO) (event.getComponent().getAttributes()
				.get("selectedTabAna"));

		Long tabAna = selectedTabAna.getTablaAnaliticaDetalleId().longValue();
		String columnaCell = event.getColumn().getHeaderText();
		Long tabAnaId = FacesUtils.checkLong(txtTablaAnaliticaId);

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityTabAnaDet = null;

			entityTabAnaDet = businessDelegator2View.getTablaAnaliticaDetalle(tabAna);

			if (columnaCell.equals("Valor var. entrada 1")) {

				entityTabAnaDet.setValorVariableEntrada1((Double) newValue);

			} else if (columnaCell.equals("Valor var. entrada 2")) {

				entityTabAnaDet.setValorVariableEntrada2((Double) newValue);
			
			} else if (columnaCell.equals("Valor var. entrada 3")) {
	
				entityTabAnaDet.setValorVariableEntrada3((Double) newValue);
	
			} else if (columnaCell.equals("Valor var. salida 1")) {

				entityTabAnaDet.setValorVariableSalida1((Double) newValue);
			
			} else if (columnaCell.equals("Valor var. salida 2")) {
	
				entityTabAnaDet.setValorVariableSalida2((Double) newValue);
	
			}

			entity = businessDelegator2View.getTablaAnalitica(tabAnaId);
			entityTabAnaDet.setTablaAnalitica(entity);
			businessDelegator2View.updateTablaAnaliticaDetalle(entityTabAnaDet);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataTabAna = null;
			entityTabAnaDet = null;
			selectedTabAna = null;
			entity = null;

			dataTabAna = businessDelegator2View.getDataTablaAnaliticaDetalleByTablaAnalitica(tabAnaId);

		}

	}

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTablaAnalitica = (TablaAnaliticaDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedTablaAnalitica"));

            Long tablaAnaliticaId = new Long(selectedTablaAnalitica.getTablaAnaliticaId());
            entity = businessDelegator2View.getTablaAnalitica(tablaAnaliticaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long tablaAnaliticaId = FacesUtils.checkLong(txtTablaAnaliticaId);
            entity = businessDelegator2View.getTablaAnalitica(tablaAnaliticaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteTablaAnalitica(entity);
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
    
    public String actionDeleteTabAna(ActionEvent evt) {
		try {

			selectedTabAna = (TablaAnaliticaDetalleDTO) (evt.getComponent().getAttributes()
					.get("selectedTabAna"));

			if (selectedTabAna.getTablaAnaliticaDetalleId() == null) {
				dataTabAna.remove(selectedTabAna);
			} else {
				Long tabAna = new Long(selectedTabAna.getTablaAnaliticaDetalleId());
				TablaAnaliticaDetalle entity = businessDelegator2View.getTablaAnaliticaDetalle(tabAna);
				businessDelegator2View.deleteTablaAnaliticaDetalle(entity);
				dataTabAna.remove(selectedTabAna);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedTablaAnalitica = (TablaAnaliticaDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedTablaAnalitica"));

            Long tablaAnaliticaId = new Long(selectedTablaAnalitica.getTablaAnaliticaId());
            entity = businessDelegator2View.getTablaAnalitica(tablaAnaliticaId);
            businessDelegator2View.deleteTablaAnalitica(entity);
            data.remove(selectedTablaAnalitica);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Long compania,
        String estado, Date fechaCreacion, Date fechaModificacion,
        String infoAdicional, String infoAdicional2, String nombre,
        Long tablaAnaliticaId, String variableEntrada1,
        String variableEntrada2, String variableEntrada3,
        String variableSalida1, String variableSalida2)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setVariableEntrada1(FacesUtils.checkString(variableEntrada1));
            entity.setVariableEntrada2(FacesUtils.checkString(variableEntrada2));
            entity.setVariableEntrada3(FacesUtils.checkString(variableEntrada3));
            entity.setVariableSalida1(FacesUtils.checkString(variableSalida1));
            entity.setVariableSalida2(FacesUtils.checkString(variableSalida2));
            businessDelegator2View.updateTablaAnalitica(entity, dataTabAna);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TablaAnaliticaView").requestRender();
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

    public InputText getTxtVariableEntrada1() {
        return txtVariableEntrada1;
    }

    public void setTxtVariableEntrada1(InputText txtVariableEntrada1) {
        this.txtVariableEntrada1 = txtVariableEntrada1;
    }

    public InputText getTxtVariableEntrada2() {
        return txtVariableEntrada2;
    }

    public void setTxtVariableEntrada2(InputText txtVariableEntrada2) {
        this.txtVariableEntrada2 = txtVariableEntrada2;
    }

    public InputText getTxtVariableEntrada3() {
        return txtVariableEntrada3;
    }

    public void setTxtVariableEntrada3(InputText txtVariableEntrada3) {
        this.txtVariableEntrada3 = txtVariableEntrada3;
    }

    public InputText getTxtVariableSalida1() {
        return txtVariableSalida1;
    }

    public void setTxtVariableSalida1(InputText txtVariableSalida1) {
        this.txtVariableSalida1 = txtVariableSalida1;
    }

    public InputText getTxtVariableSalida2() {
        return txtVariableSalida2;
    }

    public void setTxtVariableSalida2(InputText txtVariableSalida2) {
        this.txtVariableSalida2 = txtVariableSalida2;
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

    public InputText getTxtTablaAnaliticaId() {
        return txtTablaAnaliticaId;
    }

    public void setTxtTablaAnaliticaId(InputText txtTablaAnaliticaId) {
        this.txtTablaAnaliticaId = txtTablaAnaliticaId;
    }

    public List<TablaAnaliticaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataTablaAnalitica();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TablaAnaliticaDTO> tablaAnaliticaDTO) {
        this.data = tablaAnaliticaDTO;
    }

    public TablaAnaliticaDTO getSelectedTablaAnalitica() {
        return selectedTablaAnalitica;
    }

    public void setSelectedTablaAnalitica(TablaAnaliticaDTO tablaAnalitica) {
        this.selectedTablaAnalitica = tablaAnalitica;
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

	public List<TablaAnaliticaDetalleDTO> getDataTabAna() {
		return dataTabAna;
	}

	public void setDataTabAna(List<TablaAnaliticaDetalleDTO> dataTabAna) {
		this.dataTabAna = dataTabAna;
	}

	public InputText getTxtValorVariableEntrada1() {
		return txtValorVariableEntrada1;
	}

	public void setTxtValorVariableEntrada1(InputText txtValorVariableEntrada1) {
		this.txtValorVariableEntrada1 = txtValorVariableEntrada1;
	}

	public InputText getTxtValorVariableEntrada2() {
		return txtValorVariableEntrada2;
	}

	public void setTxtValorVariableEntrada2(InputText txtValorVariableEntrada2) {
		this.txtValorVariableEntrada2 = txtValorVariableEntrada2;
	}

	public InputText getTxtValorVariableEntrada3() {
		return txtValorVariableEntrada3;
	}

	public void setTxtValorVariableEntrada3(InputText txtValorVariableEntrada3) {
		this.txtValorVariableEntrada3 = txtValorVariableEntrada3;
	}

	public InputText getTxtValorVariableSalida1() {
		return txtValorVariableSalida1;
	}

	public void setTxtValorVariableSalida1(InputText txtValorVariableSalida1) {
		this.txtValorVariableSalida1 = txtValorVariableSalida1;
	}

	public InputText getTxtValorVariableSalida2() {
		return txtValorVariableSalida2;
	}

	public void setTxtValorVariableSalida2(InputText txtValorVariableSalida2) {
		this.txtValorVariableSalida2 = txtValorVariableSalida2;
	}

	public CommandButton getBtnAgregarVarAna() {
		return btnAgregarVarAna;
	}

	public void setBtnAgregarVarAna(CommandButton btnAgregarVarAna) {
		this.btnAgregarVarAna = btnAgregarVarAna;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
}
