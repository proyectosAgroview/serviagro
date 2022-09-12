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
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.LogBascula;
import co.com.arcosoft.modelo.dto.LogBasculaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class LogBasculaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LogBasculaView.class);
    private InputText txtCompania;
    private InputText txtObservacion;
    private InputText txtTiquete;
    private InputText txtUsuarioModificacion;
    private InputText txtLogBasculaId;
    private Calendar txtFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LogBasculaDTO> data;
    private LogBasculaDTO selectedLogBascula;
    private LogBascula entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public LogBasculaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            LogBasculaDTO logBasculaDTO = (LogBasculaDTO) e.getObject();

            if (txtCompania == null) {
                txtCompania = new InputText();
            }

            txtCompania.setValue(logBasculaDTO.getCompania());

            if (txtObservacion == null) {
                txtObservacion = new InputText();
            }

            txtObservacion.setValue(logBasculaDTO.getObservacion());

            if (txtTiquete == null) {
                txtTiquete = new InputText();
            }

            txtTiquete.setValue(logBasculaDTO.getTiquete());

            if (txtUsuarioModificacion == null) {
                txtUsuarioModificacion = new InputText();
            }

            txtUsuarioModificacion.setValue(logBasculaDTO.getUsuarioModificacion());

            if (txtLogBasculaId == null) {
                txtLogBasculaId = new InputText();
            }

            txtLogBasculaId.setValue(logBasculaDTO.getLogBasculaId());

            if (txtFecha == null) {
                txtFecha = new Calendar();
            }

            txtFecha.setValue(logBasculaDTO.getFecha());

            Long logBasculaId = FacesUtils.checkLong(txtLogBasculaId);
            entity = businessDelegatorView.getLogBascula(logBasculaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedLogBascula = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLogBascula = null;
        PrimeFaces.current().resetInputs(":dialogLogBascula :frm");

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(true);
        }

        if (txtTiquete != null) {
            txtTiquete.setValue(null);
            txtTiquete.setDisabled(true);
        }

        if (txtUsuarioModificacion != null) {
            txtUsuarioModificacion.setValue(null);
            txtUsuarioModificacion.setDisabled(true);
        }

        if (txtFecha != null) {
            txtFecha.setValue(null);
            txtFecha.setDisabled(true);
        }

        if (txtLogBasculaId != null) {
            txtLogBasculaId.setValue(null);
            txtLogBasculaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFecha() {
        Date inputDate = (Date) txtFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long logBasculaId = FacesUtils.checkLong(txtLogBasculaId);
            entity = (logBasculaId != null)
                ? businessDelegatorView.getLogBascula(logBasculaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCompania.setDisabled(false);
            txtObservacion.setDisabled(false);
            txtTiquete.setDisabled(false);
            txtUsuarioModificacion.setDisabled(false);
            txtFecha.setDisabled(false);
            txtLogBasculaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCompania.setValue(entity.getCompania());
            txtCompania.setDisabled(false);
            txtFecha.setValue(entity.getFecha());
            txtFecha.setDisabled(false);
            txtObservacion.setValue(entity.getObservacion());
            txtObservacion.setDisabled(false);
            txtTiquete.setValue(entity.getTiquete());
            txtTiquete.setDisabled(false);
            txtUsuarioModificacion.setValue(entity.getUsuarioModificacion());
            txtUsuarioModificacion.setDisabled(false);
            txtLogBasculaId.setValue(entity.getLogBasculaId());
            txtLogBasculaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLogBascula = (LogBasculaDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedLogBascula"));
        txtCompania.setValue(selectedLogBascula.getCompania());
        txtCompania.setDisabled(false);
        txtFecha.setValue(selectedLogBascula.getFecha());
        txtFecha.setDisabled(false);
        txtObservacion.setValue(selectedLogBascula.getObservacion());
        txtObservacion.setDisabled(false);
        txtTiquete.setValue(selectedLogBascula.getTiquete());
        txtTiquete.setDisabled(false);
        txtUsuarioModificacion.setValue(selectedLogBascula.getUsuarioModificacion());
        txtUsuarioModificacion.setDisabled(false);
        txtLogBasculaId.setValue(selectedLogBascula.getLogBasculaId());
        txtLogBasculaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLogBascula == null) && (entity == null)) {
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
            entity = new LogBascula();

            Long logBasculaId = FacesUtils.checkLong(txtLogBasculaId);

            entity.setCompania(FacesUtils.checkLong(txtCompania));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setLogBasculaId(logBasculaId);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setTiquete(FacesUtils.checkLong(txtTiquete));
            entity.setUsuarioModificacion(FacesUtils.checkLong(
                    txtUsuarioModificacion));
            businessDelegatorView.saveLogBascula(entity);
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
                Long logBasculaId = new Long(selectedLogBascula.getLogBasculaId());
                entity = businessDelegatorView.getLogBascula(logBasculaId);
            }

            entity.setCompania(FacesUtils.checkLong(txtCompania));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setTiquete(FacesUtils.checkLong(txtTiquete));
            entity.setUsuarioModificacion(FacesUtils.checkLong(
                    txtUsuarioModificacion));
            businessDelegatorView.updateLogBascula(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLogBascula = (LogBasculaDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedLogBascula"));

            Long logBasculaId = new Long(selectedLogBascula.getLogBasculaId());
            entity = businessDelegatorView.getLogBascula(logBasculaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long logBasculaId = FacesUtils.checkLong(txtLogBasculaId);
            entity = businessDelegatorView.getLogBascula(logBasculaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLogBascula(entity);
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
            selectedLogBascula = (LogBasculaDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedLogBascula"));

            Long logBasculaId = new Long(selectedLogBascula.getLogBasculaId());
            entity = businessDelegatorView.getLogBascula(logBasculaId);
            businessDelegatorView.deleteLogBascula(entity);
            data.remove(selectedLogBascula);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long compania, Date fecha,
        Long logBasculaId, String observacion, String tiquete,
        Long usuarioModificacion) throws Exception {
        try {
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setFecha(FacesUtils.checkDate(fecha));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setTiquete(FacesUtils.checkLong(tiquete));
            entity.setUsuarioModificacion(FacesUtils.checkLong(
                    usuarioModificacion));
            businessDelegatorView.updateLogBascula(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LogBasculaView").requestRender();
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

    public InputText getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputText txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public InputText getTxtTiquete() {
        return txtTiquete;
    }

    public void setTxtTiquete(InputText txtTiquete) {
        this.txtTiquete = txtTiquete;
    }

    public InputText getTxtUsuarioModificacion() {
        return txtUsuarioModificacion;
    }

    public void setTxtUsuarioModificacion(InputText txtUsuarioModificacion) {
        this.txtUsuarioModificacion = txtUsuarioModificacion;
    }

    public Calendar getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Calendar txtFecha) {
        this.txtFecha = txtFecha;
    }

    public InputText getTxtLogBasculaId() {
        return txtLogBasculaId;
    }

    public void setTxtLogBasculaId(InputText txtLogBasculaId) {
        this.txtLogBasculaId = txtLogBasculaId;
    }

    public List<LogBasculaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLogBascula();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LogBasculaDTO> logBasculaDTO) {
        this.data = logBasculaDTO;
    }

    public LogBasculaDTO getSelectedLogBascula() {
        return selectedLogBascula;
    }

    public void setSelectedLogBascula(LogBasculaDTO logBascula) {
        this.selectedLogBascula = logBascula;
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
}
