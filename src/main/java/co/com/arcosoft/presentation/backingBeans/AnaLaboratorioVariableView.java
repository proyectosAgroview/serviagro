package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaLaboratorioVariable;
import co.com.arcosoft.modelo.dto.AnaLaboratorioVariableDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class AnaLaboratorioVariableView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AnaLaboratorioVariableView.class);
    private InputText txtOrdenDigitacion;
    private InputText txtAnaLabId_AnaLaboratorio;
    private InputText txtVariableLabId_VariableLab;
    private InputText txtAnaLaboratorioVariableId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<AnaLaboratorioVariableDTO> data;
    private AnaLaboratorioVariableDTO selectedAnaLaboratorioVariable;
    private AnaLaboratorioVariable entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public AnaLaboratorioVariableView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            AnaLaboratorioVariableDTO anaLaboratorioVariableDTO = (AnaLaboratorioVariableDTO) e.getObject();

            if (txtOrdenDigitacion == null) {
                txtOrdenDigitacion = new InputText();
            }

            txtOrdenDigitacion.setValue(anaLaboratorioVariableDTO.getOrdenDigitacion());

            if (txtAnaLabId_AnaLaboratorio == null) {
                txtAnaLabId_AnaLaboratorio = new InputText();
            }

            txtAnaLabId_AnaLaboratorio.setValue(anaLaboratorioVariableDTO.getAnaLabId_AnaLaboratorio());

            if (txtVariableLabId_VariableLab == null) {
                txtVariableLabId_VariableLab = new InputText();
            }

            txtVariableLabId_VariableLab.setValue(anaLaboratorioVariableDTO.getVariableLabId_VariableLab());

            if (txtAnaLaboratorioVariableId == null) {
                txtAnaLaboratorioVariableId = new InputText();
            }

            txtAnaLaboratorioVariableId.setValue(anaLaboratorioVariableDTO.getAnaLaboratorioVariableId());

            Long anaLaboratorioVariableId = FacesUtils.checkLong(txtAnaLaboratorioVariableId);
            entity = businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedAnaLaboratorioVariable = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedAnaLaboratorioVariable = null;

        if (txtOrdenDigitacion != null) {
            txtOrdenDigitacion.setValue(null);
            txtOrdenDigitacion.setDisabled(true);
        }

        if (txtAnaLabId_AnaLaboratorio != null) {
            txtAnaLabId_AnaLaboratorio.setValue(null);
            txtAnaLabId_AnaLaboratorio.setDisabled(true);
        }

        if (txtVariableLabId_VariableLab != null) {
            txtVariableLabId_VariableLab.setValue(null);
            txtVariableLabId_VariableLab.setDisabled(true);
        }

        if (txtAnaLaboratorioVariableId != null) {
            txtAnaLaboratorioVariableId.setValue(null);
            txtAnaLaboratorioVariableId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long anaLaboratorioVariableId = FacesUtils.checkLong(txtAnaLaboratorioVariableId);
            entity = (anaLaboratorioVariableId != null)
                ? businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtOrdenDigitacion.setDisabled(false);
            txtAnaLabId_AnaLaboratorio.setDisabled(false);
            txtVariableLabId_VariableLab.setDisabled(false);
            txtAnaLaboratorioVariableId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtOrdenDigitacion.setValue(entity.getOrdenDigitacion());
            txtOrdenDigitacion.setDisabled(false);
            txtAnaLabId_AnaLaboratorio.setValue(entity.getAnaLaboratorio()
                                                      .getAnaLabId());
            txtAnaLabId_AnaLaboratorio.setDisabled(false);
            txtVariableLabId_VariableLab.setValue(entity.getVariableLab()
                                                        .getVariableLabId());
            txtVariableLabId_VariableLab.setDisabled(false);
            txtAnaLaboratorioVariableId.setValue(entity.getAnaLaboratorioVariableId());
            txtAnaLaboratorioVariableId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedAnaLaboratorioVariable = (AnaLaboratorioVariableDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedAnaLaboratorioVariable"));
        txtOrdenDigitacion.setValue(selectedAnaLaboratorioVariable.getOrdenDigitacion());
        txtOrdenDigitacion.setDisabled(false);
        txtAnaLabId_AnaLaboratorio.setValue(selectedAnaLaboratorioVariable.getAnaLabId_AnaLaboratorio());
        txtAnaLabId_AnaLaboratorio.setDisabled(false);
        txtVariableLabId_VariableLab.setValue(selectedAnaLaboratorioVariable.getVariableLabId_VariableLab());
        txtVariableLabId_VariableLab.setDisabled(false);
        txtAnaLaboratorioVariableId.setValue(selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId());
        txtAnaLaboratorioVariableId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedAnaLaboratorioVariable == null) && (entity == null)) {
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
            entity = new AnaLaboratorioVariable();

            Long anaLaboratorioVariableId = FacesUtils.checkLong(txtAnaLaboratorioVariableId);

            entity.setAnaLaboratorioVariableId(anaLaboratorioVariableId);
            entity.setOrdenDigitacion(FacesUtils.checkLong(txtOrdenDigitacion));
            entity.setAnaLaboratorio((FacesUtils.checkLong(
                    txtAnaLabId_AnaLaboratorio) != null)
                ? businessDelegatorView.getAnaLaboratorio(FacesUtils.checkLong(
                        txtAnaLabId_AnaLaboratorio)) : null);
            entity.setVariableLab((FacesUtils.checkLong(
                    txtVariableLabId_VariableLab) != null)
                ? businessDelegatorView.getVariableLab(FacesUtils.checkLong(
                        txtVariableLabId_VariableLab)) : null);
            businessDelegatorView.saveAnaLaboratorioVariable(entity);
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
                Long anaLaboratorioVariableId = new Long(selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId());
                entity = businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId);
            }

            entity.setOrdenDigitacion(FacesUtils.checkLong(txtOrdenDigitacion));
            entity.setAnaLaboratorio((FacesUtils.checkLong(
                    txtAnaLabId_AnaLaboratorio) != null)
                ? businessDelegatorView.getAnaLaboratorio(FacesUtils.checkLong(
                        txtAnaLabId_AnaLaboratorio)) : null);
            entity.setVariableLab((FacesUtils.checkLong(
                    txtVariableLabId_VariableLab) != null)
                ? businessDelegatorView.getVariableLab(FacesUtils.checkLong(
                        txtVariableLabId_VariableLab)) : null);
            businessDelegatorView.updateAnaLaboratorioVariable(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedAnaLaboratorioVariable = (AnaLaboratorioVariableDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedAnaLaboratorioVariable"));

            Long anaLaboratorioVariableId = new Long(selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId());
            entity = businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long anaLaboratorioVariableId = FacesUtils.checkLong(txtAnaLaboratorioVariableId);
            entity = businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteAnaLaboratorioVariable(entity);
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
            selectedAnaLaboratorioVariable = (AnaLaboratorioVariableDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedAnaLaboratorioVariable"));

            Long anaLaboratorioVariableId = new Long(selectedAnaLaboratorioVariable.getAnaLaboratorioVariableId());
            entity = businessDelegatorView.getAnaLaboratorioVariable(anaLaboratorioVariableId);
            businessDelegatorView.deleteAnaLaboratorioVariable(entity);
            data.remove(selectedAnaLaboratorioVariable);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long anaLaboratorioVariableId,
        Long ordenDigitacion, Long anaLabId_AnaLaboratorio,
        Long variableLabId_VariableLab) throws Exception {
        try {
            entity.setOrdenDigitacion(FacesUtils.checkLong(ordenDigitacion));
            businessDelegatorView.updateAnaLaboratorioVariable(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("AnaLaboratorioVariableView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtOrdenDigitacion() {
        return txtOrdenDigitacion;
    }

    public void setTxtOrdenDigitacion(InputText txtOrdenDigitacion) {
        this.txtOrdenDigitacion = txtOrdenDigitacion;
    }

    public InputText getTxtAnaLabId_AnaLaboratorio() {
        return txtAnaLabId_AnaLaboratorio;
    }

    public void setTxtAnaLabId_AnaLaboratorio(
        InputText txtAnaLabId_AnaLaboratorio) {
        this.txtAnaLabId_AnaLaboratorio = txtAnaLabId_AnaLaboratorio;
    }

    public InputText getTxtVariableLabId_VariableLab() {
        return txtVariableLabId_VariableLab;
    }

    public void setTxtVariableLabId_VariableLab(
        InputText txtVariableLabId_VariableLab) {
        this.txtVariableLabId_VariableLab = txtVariableLabId_VariableLab;
    }

    public InputText getTxtAnaLaboratorioVariableId() {
        return txtAnaLaboratorioVariableId;
    }

    public void setTxtAnaLaboratorioVariableId(
        InputText txtAnaLaboratorioVariableId) {
        this.txtAnaLaboratorioVariableId = txtAnaLaboratorioVariableId;
    }

    public List<AnaLaboratorioVariableDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataAnaLaboratorioVariable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<AnaLaboratorioVariableDTO> anaLaboratorioVariableDTO) {
        this.data = anaLaboratorioVariableDTO;
    }

    public AnaLaboratorioVariableDTO getSelectedAnaLaboratorioVariable() {
        return selectedAnaLaboratorioVariable;
    }

    public void setSelectedAnaLaboratorioVariable(
        AnaLaboratorioVariableDTO anaLaboratorioVariable) {
        this.selectedAnaLaboratorioVariable = anaLaboratorioVariable;
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
