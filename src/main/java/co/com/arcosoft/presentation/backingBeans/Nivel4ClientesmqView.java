package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.Nivel2ClientesmqDTO;
import co.com.arcosoft.modelo.dto.Nivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ProntuarioLotesDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class Nivel4ClientesmqView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Nivel4ClientesmqView.class);
    private InputText txtAreaNeta;
    private InputText txtCodigo;
    private InputText txtCodigoAlternativo;
    private InputText txtCompania;
    private SelectOneRadio txtEstado;
    private InputTextarea txtInfoAdicional;
    private InputTextarea txtInfoAdicional2;
    private InputText txtNombre;
    private InputText txtNumeroPlantas;
    
    private SelectOneMenu txtNivel2ClientesmqId_Nivel2Clientesmq;
	SelectItem[] selectNivel2ClientesId;
	private List<Nivel2Clientesmq> nivel2ClientesId;

    private InputText txtNivel4ClientesmqId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
 //   private List<Nivel4ClientesmqDTO> data;
	private LazyDataModel<Nivel4ClientesmqDTO> data;
	private List<ProntuarioLotesDTO> data2;
	private ProntuarioLotesDTO selectedNivel4Clientesmq2;
    private Nivel4ClientesmqDTO selectedNivel4Clientesmq;
    private Nivel4Clientesmq entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
	private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;
	private int activeTapIndex = 0;

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectCliente;
	private List<PersEmpr> cliente;

	private SelectOneMenu txtNivelConsulta2ClientesId;
	SelectItem[] selectNivelConsulta2ClientesId;
	private List<Nivel2Clientesmq> nivel2ConsultaClientesId;

	private SelectOneMenu txtNivelConsulta4ClientesId;
	SelectItem[] selectNivelConsulta4ClientesId;
	private List<Nivel4Clientesmq> nivel4ClientesId;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
    public Nivel4ClientesmqView() {
        super();
    }
    public String action_new() {
        action_clear();
        selectedNivel4Clientesmq = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedNivel4Clientesmq = null;
	
		PrimeFaces.current().resetInputs(":dialogNivel4Clientesmq :frm");
		activeTapIndex = 0;

        if (txtAreaNeta != null) {
            txtAreaNeta.setValue(null);
            txtAreaNeta.setDisabled(false);
        }

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(false);
        }

        if (txtCodigoAlternativo != null) {
            txtCodigoAlternativo.setValue(null);
            txtCodigoAlternativo.setDisabled(false);
        }

        
        if (txtPersEmprId_PersEmpr != null) {
        	txtPersEmprId_PersEmpr.setValue(null);
            txtPersEmprId_PersEmpr.setDisabled(false);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(false);
        }

        if (txtEstado != null) {
            txtEstado.setValue("A");
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

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(false);
        }

        if (txtNumeroPlantas != null) {
            txtNumeroPlantas.setValue(null);
            txtNumeroPlantas.setDisabled(false);
        }

        if (txtNivel2ClientesmqId_Nivel2Clientesmq != null) {
            txtNivel2ClientesmqId_Nivel2Clientesmq.setValue(null);
            txtNivel2ClientesmqId_Nivel2Clientesmq.setDisabled(false);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(false);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(false);
        }

        if (txtNivel4ClientesmqId != null) {
            txtNivel4ClientesmqId.setValue(null);
            txtNivel4ClientesmqId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(false);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(false);
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

    
    public String action_edit(ActionEvent evt) {
    	selectedNivel4Clientesmq2 = (ProntuarioLotesDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedNivel4Clientesmq2"));
       

		PrimeFaces.current().resetInputs(":dialogNivel4Clientesmq :frm");

		try {

			Long nivel4ClientesmqId = selectedNivel4Clientesmq2.getNivel4ClientesMqId().longValue();
			Object[] condicion = { "nivel4ClientesmqId", true, nivel4ClientesmqId, "=" };
			List<Nivel4Clientesmq> lista = (nivel4ClientesmqId != null) ? businessDelegator2View.findByCriteriaInNivel4Clientesmq(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

        
        txtAreaNeta.setValue(entity.getAreaNeta());
        txtAreaNeta.setDisabled(false);
        txtCodigo.setValue(entity.getCodigo());
        txtCodigo.setDisabled(false);
        txtCodigoAlternativo.setValue(entity.getCodigoAlternativo());
        txtCodigoAlternativo.setDisabled(false);
        txtEstado.setValue(entity.getEstado());
        txtEstado.setDisabled(false);
        txtInfoAdicional.setValue(entity.getInfoAdicional());
        txtInfoAdicional.setDisabled(false);
        txtInfoAdicional2.setValue(entity.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtNombre.setValue(entity.getNombre());
        txtNombre.setDisabled(false);
      //  txtNumeroPlantas.setValue(entity.getNumeroPlantas());
       // txtNumeroPlantas.setDisabled(false);
        txtNivel2ClientesmqId_Nivel2Clientesmq.setValue(entity.getNivel2Clientesmq().getNivel2ClientesmqId());
        txtNivel2ClientesmqId_Nivel2Clientesmq.setDisabled(false);
        
        if (entity.getNivel2Clientesmq() != null) {
        	
        	Nivel2Clientesmq nivel2mq =  businessDelegator2View.getNivel2Clientesmq(entity.getNivel2Clientesmq().getNivel2ClientesmqId());
        	
        	Long persEmprId = nivel2mq.getPersEmpr().getPersEmprId();
        //	PersEmpr empresa = businessDelegatorView.getPersEmpr(persEmprId);
        //	PersEmpr empresa = businessDelegatorView.getPersEmpr(empresaId);
        	txtPersEmprId_PersEmpr.setValue(persEmprId);
            txtPersEmprId_PersEmpr.setDisabled(false);
        }
        txtNivel4ClientesmqId.setValue(entity.getNivel4ClientesmqId());
        txtNivel4ClientesmqId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}


    public String action_save() {
        try {
            if ((selectedNivel4Clientesmq == null) && (entity == null)) {
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
            entity = new Nivel4Clientesmq();

            //Long nivel4ClientesmqId = FacesUtils.checkLong(txtNivel4ClientesmqId);
            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			String estado = "A";
            entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCodigoAlternativo(FacesUtils.checkString(
                    txtCodigoAlternativo));
            entity.setCompania(compania);
            entity.setEstado("A");
            entity.setFechaCreacion(date);
          
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNumeroPlantas(FacesUtils.checkDouble(txtNumeroPlantas));
            entity.setNivel2Clientesmq((FacesUtils.checkLong(
                    txtNivel2ClientesmqId_Nivel2Clientesmq) != null)
                ? businessDelegator2View.getNivel2Clientesmq(
                    FacesUtils.checkLong(txtNivel2ClientesmqId_Nivel2Clientesmq))
                : null);
            String codigoNivel4 ="";
            Long nivel2 = null;
            codigoNivel4 = FacesUtils.checkString(txtCodigo);
            nivel2=  FacesUtils.checkLong(txtNivel2ClientesmqId_Nivel2Clientesmq);
            
           String codNivel4 =  businessDelegator2View.busquedaNivel4Clientes(codigoNivel4, nivel2);
            if(codNivel4.equals(" ") || codNivel4.equals("")){
            	businessDelegator2View.saveNivel4Clientesmq(entity);
                FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
                	
            }else{
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
    					"El código de Suerte que esta intentando crear ya existe en la base de datos"));
            }
            
            
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
                Long nivel4ClientesmqId = new Long(selectedNivel4Clientesmq.getNivel4ClientesmqId());
                entity = businessDelegator2View.getNivel4Clientesmq(nivel4ClientesmqId);
            }
            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			
            entity.setAreaNeta(FacesUtils.checkDouble(txtAreaNeta));
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCodigoAlternativo(FacesUtils.checkString(
                    txtCodigoAlternativo));
            entity.setCompania(compania);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaModificacion(date);
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNumeroPlantas(FacesUtils.checkDouble(txtNumeroPlantas));
            entity.setNivel2Clientesmq((FacesUtils.checkLong(
                    txtNivel2ClientesmqId_Nivel2Clientesmq) != null)
                ? businessDelegator2View.getNivel2Clientesmq(
                    FacesUtils.checkLong(txtNivel2ClientesmqId_Nivel2Clientesmq))
                : null);
            businessDelegator2View.updateNivel4Clientesmq(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedNivel4Clientesmq = (Nivel4ClientesmqDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedNivel4Clientesmq"));

            Long nivel4ClientesmqId = new Long(selectedNivel4Clientesmq.getNivel4ClientesmqId());
            entity = businessDelegator2View.getNivel4Clientesmq(nivel4ClientesmqId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long nivel4ClientesmqId = FacesUtils.checkLong(txtNivel4ClientesmqId);
            entity = businessDelegator2View.getNivel4Clientesmq(nivel4ClientesmqId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
        	businessDelegator2View.deleteNivel4Clientesmq(entity);
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
            selectedNivel4Clientesmq = (Nivel4ClientesmqDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedNivel4Clientesmq"));

            Long nivel4ClientesmqId = new Long(selectedNivel4Clientesmq.getNivel4ClientesmqId());
            entity = businessDelegator2View.getNivel4Clientesmq(nivel4ClientesmqId);
            businessDelegator2View.deleteNivel4Clientesmq(entity);
            ((Map<String, Object>) data).remove(selectedNivel4Clientesmq);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Double areaNeta, String codigo,
        String codigoAlternativo, Long compania, String estado,
        Date fechaCreacion, Date fechaModificacion, String infoAdicional,
        String infoAdicional2, Long nivel4ClientesmqId, String nombre,
        Double numeroPlantas, Long nivel2ClientesmqId_Nivel2Clientesmq)
        throws Exception {
        try {
            entity.setAreaNeta(FacesUtils.checkDouble(areaNeta));
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setCodigoAlternativo(FacesUtils.checkString(
                    codigoAlternativo));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setNumeroPlantas(FacesUtils.checkDouble(numeroPlantas));
            businessDelegator2View.updateNivel4Clientesmq(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("Nivel4ClientesmqView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAreaNeta() {
        return txtAreaNeta;
    }

    public void setTxtAreaNeta(InputText txtAreaNeta) {
        this.txtAreaNeta = txtAreaNeta;
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtCodigoAlternativo() {
        return txtCodigoAlternativo;
    }

    public void setTxtCodigoAlternativo(InputText txtCodigoAlternativo) {
        this.txtCodigoAlternativo = txtCodigoAlternativo;
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

    public InputText getTxtNumeroPlantas() {
        return txtNumeroPlantas;
    }

    public void setTxtNumeroPlantas(InputText txtNumeroPlantas) {
        this.txtNumeroPlantas = txtNumeroPlantas;
    }

    public SelectOneMenu getTxtNivel2ClientesmqId_Nivel2Clientesmq() {
        return txtNivel2ClientesmqId_Nivel2Clientesmq;
    }

    public void setTxtNivel2ClientesmqId_Nivel2Clientesmq(
    		SelectOneMenu txtNivel2ClientesmqId_Nivel2Clientesmq) {
        this.txtNivel2ClientesmqId_Nivel2Clientesmq = txtNivel2ClientesmqId_Nivel2Clientesmq;
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

    public InputText getTxtNivel4ClientesmqId() {
        return txtNivel4ClientesmqId;
    }

    public void setTxtNivel4ClientesmqId(InputText txtNivel4ClientesmqId) {
        this.txtNivel4ClientesmqId = txtNivel4ClientesmqId;
    }
/*
    public List<Nivel4ClientesmqDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataNivel4Clientesmq();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<Nivel4ClientesmqDTO> nivel4ClientesmqDTO) {
        this.data = nivel4ClientesmqDTO;
    }
*/
    public Nivel4ClientesmqDTO getSelectedNivel4Clientesmq() {
        return selectedNivel4Clientesmq;
    }

    public void setSelectedNivel4Clientesmq(
        Nivel4ClientesmqDTO nivel4Clientesmq) {
        this.selectedNivel4Clientesmq = nivel4Clientesmq;
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
    
    public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

		
			try {
	// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
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


	public SelectItem[] getSelectNivel2ClientesId() {

		if (nivel2ClientesId == null || nivel2ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprId_PersEmpr != null && txtPersEmprId_PersEmpr.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprId_PersEmpr.getValue().toString());

					// Criteria
					List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
							.listaNivel2Clientesmq(idCompania, persEmprId);

					selectNivel2ClientesId = new SelectItem[listaNivel2Clientesmq.size()];
					int i = 0;
					for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
						selectNivel2ClientesId[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
								listaNivel2ClientesmqDto.getHacienda());
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivel2ClientesId;
	}

	public void setSelectNivel2ClientesId(SelectItem[] selectNivel2ClientesId) {
		this.selectNivel2ClientesId = selectNivel2ClientesId;
	}
	
	public SelectOneMenu getTxtPersEmprId_PersEmpr() {
		return txtPersEmprId_PersEmpr;
	}
	public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
		this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
	}
	public int getActiveTapIndex() {
		return activeTapIndex;
	}
	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}


	public LazyDataModel<Nivel4ClientesmqDTO> getData() {
		try {
			if (data == null) {
				// data = businessDelegatorView.getDataPersEmpr();
				data = new LocalDataModelDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(LazyDataModel<Nivel4ClientesmqDTO> nivel4ClientesmqDTO) {
		this.data = nivel4ClientesmqDTO;
	}
	
	private class LocalDataModelDTO extends LazyDataModel<Nivel4ClientesmqDTO> {
		private static final long serialVersionUID = 1L;
		private List<Nivel4ClientesmqDTO> nivel4ClientesmqDTO;

	 
		@Override
		public List<Nivel4ClientesmqDTO> load(int startingAt, int maxPerPage, String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			if (filters != null) {
				nivel4ClientesmqDTO = getDataPageDTO(startingAt, maxPerPage, sortField,
						(sortOrder.name().equals("ASCENDING") ? true : false), filters);
				try {
					setRowCount(businessDelegatorView.findTotalNumberEmpresa(filters).intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			setPageSize(maxPerPage);
			return nivel4ClientesmqDTO;

		}

		@Override
		public Nivel4ClientesmqDTO getRowData(String rowKey) {
			for (Nivel4ClientesmqDTO nivel4ClientesmqDTOtmp : nivel4ClientesmqDTO) {
				if (nivel4ClientesmqDTOtmp.getNivel4ClientesmqId().toString().equals(rowKey))
					return nivel4ClientesmqDTOtmp;
			}
			return null;
		}

		@Override
		public Object getRowKey(Nivel4ClientesmqDTO nivel4ClientesmqDTOtmp) {
			return nivel4ClientesmqDTOtmp.getNivel4ClientesmqId();
		}

	}
	
	private List<Nivel4ClientesmqDTO> getDataPageDTO(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) {
		try {
			return businessDelegator2View.getDataPageNivel4Clientesmq(startRow, pageSize, sortField, sortOrder, filters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


	public SelectItem[] getselectCliente() {

		if (cliente == null || cliente.size() == 0) {

			 

			try {

				
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" ,"tipoEmpresa", true, "4", "="};
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectCliente = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr cliente : lista) {
					selectCliente[i] = new SelectItem(cliente.getPersEmprId(), cliente.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCliente;
	}

	public void setselectCliente(SelectItem[] selectCliente) {
		this.selectCliente = selectCliente;
	}
	
	public SelectItem[] getSelectNivelConsulta2ClientesId() {

		if (nivel2ClientesId == null || nivel2ClientesId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());
				Long persEmprId = null;

				if (txtPersEmprId != null && txtPersEmprId.getValue() != null) {
					persEmprId = Long.parseLong(txtPersEmprId.getValue().toString());

					// Criteria
					List<ListaNivel2ClientesmqDTO> listaNivelConsulta2Clientesmq = businessDelegator2View
							.listaNivel2Clientesmq(idCompania, persEmprId);

					selectNivelConsulta2ClientesId = new SelectItem[listaNivelConsulta2Clientesmq.size()];
					int i = 0;
					for (ListaNivel2ClientesmqDTO listaNivelConsulta2ClientesmqDto : listaNivelConsulta2Clientesmq) {
						selectNivelConsulta2ClientesId[i] = new SelectItem(listaNivelConsulta2ClientesmqDto.getId(),
								listaNivelConsulta2ClientesmqDto.getHacienda());
						i++;

					}
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivelConsulta2ClientesId;
	}

	public void setSelectNivelConsulta2ClientesId(SelectItem[] selectNivelConsulta2ClientesId) {
		this.selectNivelConsulta2ClientesId = selectNivelConsulta2ClientesId;
	}
	



	public SelectItem[] getSelectNivelConsulta4ClientesId() throws NumberFormatException, Exception {

				if (txtNivelConsulta2ClientesId != null && txtNivelConsulta2ClientesId.getValue() != null) {
					Long idCompania = new Long(getCompaniaIdSession());
					String nivel2ClientesId = null;

					nivel2ClientesId = txtNivelConsulta2ClientesId.getValue().toString();
				try {
					// Criteria
					List<ListaNivel4ClientesmqDTO> listaNivelConsulta4Clientesmq = businessDelegator2View
							.listaNivel4Clientesmq(idCompania, nivel2ClientesId);

					selectNivelConsulta4ClientesId = new SelectItem[listaNivelConsulta4Clientesmq.size()];
					int i = 0;
					for (ListaNivel4ClientesmqDTO listaNivelConsulta4ClientesmqDto : listaNivelConsulta4Clientesmq) {
						selectNivelConsulta4ClientesId[i] = new SelectItem(listaNivelConsulta4ClientesmqDto.getId(),
								listaNivelConsulta4ClientesmqDto.getLote());
						i++;

					}
				
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectNivelConsulta4ClientesId;
	}

	public void setSelectNivelConsulta4ClientesId(SelectItem[] selectNivelConsulta4ClientesId) {
		this.selectNivelConsulta4ClientesId = selectNivelConsulta4ClientesId;
	}
	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}
	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}
	public SelectOneMenu getTxtNivelConsulta2ClientesId() {
		return txtNivelConsulta2ClientesId;
	}
	public void setTxtNivelConsulta2ClientesId(SelectOneMenu txtNivelConsulta2ClientesId) {
		this.txtNivelConsulta2ClientesId = txtNivelConsulta2ClientesId;
	}
	public SelectOneMenu getTxtNivelConsulta4ClientesId() {
		return txtNivelConsulta4ClientesId;
	}
	public void setTxtNivelConsulta4ClientesId(SelectOneMenu txtNivelConsulta4ClientesId) {
		this.txtNivelConsulta4ClientesId = txtNivelConsulta4ClientesId;
	}
	
	


	public void listarSuertes() {
		try {
			
			Long compania = new Long(getCompaniaIdSession());
			// Long compania = 1L;
		
			String clienteId = "0";
			Long flagClientes = 1L;
			String haciendaId ="0";
			Long flagHacienda = 1L;
			
			String suerteId ="0";
			Long flagSuerte = 1L;
			
			if(txtPersEmprId.getValue()!=null) {
				clienteId = FacesUtils.checkString(txtPersEmprId);
				flagClientes =0L;
			}
			
			if(txtNivelConsulta2ClientesId.getValue()!=null) {
				haciendaId = FacesUtils.checkString(txtNivelConsulta2ClientesId);
				flagHacienda =0L;
			}
			
			if(txtNivelConsulta4ClientesId.getValue()!=null) {
				suerteId = FacesUtils.checkString(txtNivelConsulta4ClientesId);
				flagSuerte =0L;
			}
			
			
			if(compania != null &&  clienteId !=null){
					data2 = businessDelegator2View.pr_prontuario_lotes_maquinaria(compania,  
						haciendaId, flagHacienda,   suerteId, flagSuerte,
						clienteId, flagClientes);
			
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	public List<ProntuarioLotesDTO> getData2() {
		return data2;
	}
	public ProntuarioLotesDTO getSelectedNivel4Clientesmq2() {
		return selectedNivel4Clientesmq2;
	}
	public void setSelectedNivel4Clientesmq2(ProntuarioLotesDTO selectedNivel4Clientesmq2) {
		this.selectedNivel4Clientesmq2 = selectedNivel4Clientesmq2;
	}
	public Nivel4Clientesmq getEntity() {
		return entity;
	}
	public void setEntity(Nivel4Clientesmq entity) {
		this.entity = entity;
	}
	public void setData2(List<ProntuarioLotesDTO> data2) {
		this.data2 = data2;
	}
	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}
	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	
	
	
}
