package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.PuntosLubricacionDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class PuntosLubricacionView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PuntosLubricacionView.class);
    private InputText txtCodigo;
    private InputText txtCompania;
    private InputTextarea txtInfoAdicional1;
    private InputTextarea txtInfoAdicional2;
    private InputText txtNombre;
    private InputText txtPuntoLubricacionId;
    private SelectOneRadio txtEstado;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PuntosLubricacionDTO> data;
    private PuntosLubricacionDTO selectedPuntosLubricacion;
    private PuntosLubricacion entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

    public PuntosLubricacionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedPuntosLubricacion = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPuntosLubricacion = null;

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(false);
        }
        
        if (txtEstado != null) {
        	txtEstado.setValue("A");
        	txtEstado.setDisabled(true);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtInfoAdicional1 != null) {
            txtInfoAdicional1.setValue(null);
            txtInfoAdicional1.setDisabled(true);
        }

        if (txtInfoAdicional2 != null) {
            txtInfoAdicional2.setValue(null);
            txtInfoAdicional2.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtPuntoLubricacionId != null) {
            txtPuntoLubricacionId.setValue(null);
            txtPuntoLubricacionId.setDisabled(false);
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
			List<PuntosLubricacion> lista = (codigo != null)
					? businessDelegator2View.findByCriteriaInPuntosLubricacion(condicion, null, null) : null;

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
        	txtEstado.setDisabled(false);
            txtCodigo.setDisabled(false);
            txtInfoAdicional1.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
        	txtEstado.setValue(entity.getEstado());
        	txtEstado.setDisabled(false);
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtInfoAdicional1.setValue(entity.getInfoAdicional1());
            txtInfoAdicional1.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPuntosLubricacion = (PuntosLubricacionDTO) (evt.getComponent().getAttributes()
                                                               .get("selectedPuntosLubricacion"));
        
    	txtEstado.setValue(selectedPuntosLubricacion.getEstado());
    	txtEstado.setDisabled(false);
        txtCodigo.setValue(selectedPuntosLubricacion.getCodigo());
        txtCodigo.setDisabled(false);
        txtInfoAdicional1.setValue(selectedPuntosLubricacion.getInfoAdicional1());
        txtInfoAdicional1.setDisabled(false);
        txtInfoAdicional2.setValue(selectedPuntosLubricacion.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtNombre.setValue(selectedPuntosLubricacion.getNombre());
        txtNombre.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPuntosLubricacion == null) && (entity == null)) {
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
            entity = new PuntosLubricacion();
            
            Date date = new Date();
            Long companiaId = Long.parseLong(getCompaniaIdSession());

            entity.setCodigo(FacesUtils.checkLong(txtCodigo));
            entity.setCompania(companiaId);
            entity.setFechaCreacion(date);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setInfoAdicional1(FacesUtils.checkString(txtInfoAdicional1));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            businessDelegator2View.savePuntosLubricacion(entity);
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
                Long puntoLubricacionId = new Long(selectedPuntosLubricacion.getPuntoLubricacionId());
                entity = businessDelegator2View.getPuntosLubricacion(puntoLubricacionId);
            }
            
            Date date = new Date();
            Long companiaId = Long.parseLong(getCompaniaIdSession());

            entity.setCodigo(FacesUtils.checkLong(txtCodigo));
            entity.setCompania(companiaId);
            entity.setFechaModificacion(date);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setInfoAdicional1(FacesUtils.checkString(txtInfoAdicional1));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            businessDelegator2View.updatePuntosLubricacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPuntosLubricacion = (PuntosLubricacionDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedPuntosLubricacion"));

            Long puntoLubricacionId = new Long(selectedPuntosLubricacion.getPuntoLubricacionId());
            entity = businessDelegator2View.getPuntosLubricacion(puntoLubricacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long puntoLubricacionId = FacesUtils.checkLong(txtPuntoLubricacionId);
            entity = businessDelegator2View.getPuntosLubricacion(puntoLubricacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deletePuntosLubricacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
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

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedPuntosLubricacion = (PuntosLubricacionDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedPuntosLubricacion"));

            Long puntoLubricacionId = new Long(selectedPuntosLubricacion.getPuntoLubricacionId());
            entity = businessDelegator2View.getPuntosLubricacion(puntoLubricacionId);
            businessDelegator2View.deletePuntosLubricacion(entity);
            data.remove(selectedPuntosLubricacion);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long codigo, Long compania,
        Date fechaCreacion, Date fechaModificacion, String infoAdicional1,
        String infoAdicional2, String nombre, Long puntoLubricacionId)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkLong(codigo));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setInfoAdicional1(FacesUtils.checkString(infoAdicional1));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setNombre(FacesUtils.checkString(nombre));
            businessDelegator2View.updatePuntosLubricacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PuntosLubricacionView").requestRender();
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

    public InputTextarea getTxtInfoAdicional1() {
        return txtInfoAdicional1;
    }

    public void setTxtInfoAdicional1(InputTextarea txtInfoAdicional1) {
        this.txtInfoAdicional1 = txtInfoAdicional1;
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

    public InputText getTxtPuntoLubricacionId() {
        return txtPuntoLubricacionId;
    }

    public void setTxtPuntoLubricacionId(InputText txtPuntoLubricacionId) {
        this.txtPuntoLubricacionId = txtPuntoLubricacionId;
    }

    public List<PuntosLubricacionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataPuntosLubricacion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PuntosLubricacionDTO> puntosLubricacionDTO) {
        this.data = puntosLubricacionDTO;
    }

    public PuntosLubricacionDTO getSelectedPuntosLubricacion() {
        return selectedPuntosLubricacion;
    }

    public void setSelectedPuntosLubricacion(
        PuntosLubricacionDTO puntosLubricacion) {
        this.selectedPuntosLubricacion = puntosLubricacion;
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}
}
