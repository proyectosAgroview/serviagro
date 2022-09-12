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
import co.com.arcosoft.modelo.TablaAnaliticaDetalle;
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
public class TablaAnaliticaDetalleView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TablaAnaliticaDetalleView.class);
    private InputText txtValorVariableEntrada1;
    private InputText txtValorVariableEntrada2;
    private InputText txtValorVariableEntrada3;
    private InputText txtValorVariableSalida1;
    private InputText txtValorVariableSalida2;
    private InputText txtTablaAnaliticaId_TablaAnalitica;
    private InputText txtTablaAnaliticaDetalleId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TablaAnaliticaDetalleDTO> data;
    private TablaAnaliticaDetalleDTO selectedTablaAnaliticaDetalle;
    private TablaAnaliticaDetalle entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

    public TablaAnaliticaDetalleView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TablaAnaliticaDetalleDTO tablaAnaliticaDetalleDTO = (TablaAnaliticaDetalleDTO) e.getObject();

            if (txtValorVariableEntrada1 == null) {
                txtValorVariableEntrada1 = new InputText();
            }

            txtValorVariableEntrada1.setValue(tablaAnaliticaDetalleDTO.getValorVariableEntrada1());

            if (txtValorVariableEntrada2 == null) {
                txtValorVariableEntrada2 = new InputText();
            }

            txtValorVariableEntrada2.setValue(tablaAnaliticaDetalleDTO.getValorVariableEntrada2());

            if (txtValorVariableEntrada3 == null) {
                txtValorVariableEntrada3 = new InputText();
            }

            txtValorVariableEntrada3.setValue(tablaAnaliticaDetalleDTO.getValorVariableEntrada3());

            if (txtValorVariableSalida1 == null) {
                txtValorVariableSalida1 = new InputText();
            }

            txtValorVariableSalida1.setValue(tablaAnaliticaDetalleDTO.getValorVariableSalida1());

            if (txtValorVariableSalida2 == null) {
                txtValorVariableSalida2 = new InputText();
            }

            txtValorVariableSalida2.setValue(tablaAnaliticaDetalleDTO.getValorVariableSalida2());

            if (txtTablaAnaliticaId_TablaAnalitica == null) {
                txtTablaAnaliticaId_TablaAnalitica = new InputText();
            }

            txtTablaAnaliticaId_TablaAnalitica.setValue(tablaAnaliticaDetalleDTO.getTablaAnaliticaId_TablaAnalitica());

            if (txtTablaAnaliticaDetalleId == null) {
                txtTablaAnaliticaDetalleId = new InputText();
            }

            txtTablaAnaliticaDetalleId.setValue(tablaAnaliticaDetalleDTO.getTablaAnaliticaDetalleId());

            Long tablaAnaliticaDetalleId = FacesUtils.checkLong(txtTablaAnaliticaDetalleId);
            entity = businessDelegator2View.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTablaAnaliticaDetalle = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTablaAnaliticaDetalle = null;

        if (txtValorVariableEntrada1 != null) {
            txtValorVariableEntrada1.setValue(null);
            txtValorVariableEntrada1.setDisabled(true);
        }

        if (txtValorVariableEntrada2 != null) {
            txtValorVariableEntrada2.setValue(null);
            txtValorVariableEntrada2.setDisabled(true);
        }

        if (txtValorVariableEntrada3 != null) {
            txtValorVariableEntrada3.setValue(null);
            txtValorVariableEntrada3.setDisabled(true);
        }

        if (txtValorVariableSalida1 != null) {
            txtValorVariableSalida1.setValue(null);
            txtValorVariableSalida1.setDisabled(true);
        }

        if (txtValorVariableSalida2 != null) {
            txtValorVariableSalida2.setValue(null);
            txtValorVariableSalida2.setDisabled(true);
        }

        if (txtTablaAnaliticaId_TablaAnalitica != null) {
            txtTablaAnaliticaId_TablaAnalitica.setValue(null);
            txtTablaAnaliticaId_TablaAnalitica.setDisabled(true);
        }

        if (txtTablaAnaliticaDetalleId != null) {
            txtTablaAnaliticaDetalleId.setValue(null);
            txtTablaAnaliticaDetalleId.setDisabled(false);
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
            Long tablaAnaliticaDetalleId = FacesUtils.checkLong(txtTablaAnaliticaDetalleId);
            entity = (tablaAnaliticaDetalleId != null)
                ? businessDelegator2View.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtValorVariableEntrada1.setDisabled(false);
            txtValorVariableEntrada2.setDisabled(false);
            txtValorVariableEntrada3.setDisabled(false);
            txtValorVariableSalida1.setDisabled(false);
            txtValorVariableSalida2.setDisabled(false);
            txtTablaAnaliticaId_TablaAnalitica.setDisabled(false);
            txtTablaAnaliticaDetalleId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtValorVariableEntrada1.setValue(entity.getValorVariableEntrada1());
            txtValorVariableEntrada1.setDisabled(false);
            txtValorVariableEntrada2.setValue(entity.getValorVariableEntrada2());
            txtValorVariableEntrada2.setDisabled(false);
            txtValorVariableEntrada3.setValue(entity.getValorVariableEntrada3());
            txtValorVariableEntrada3.setDisabled(false);
            txtValorVariableSalida1.setValue(entity.getValorVariableSalida1());
            txtValorVariableSalida1.setDisabled(false);
            txtValorVariableSalida2.setValue(entity.getValorVariableSalida2());
            txtValorVariableSalida2.setDisabled(false);
            txtTablaAnaliticaId_TablaAnalitica.setValue(entity.getTablaAnalitica()
                                                              .getTablaAnaliticaId());
            txtTablaAnaliticaId_TablaAnalitica.setDisabled(false);
            txtTablaAnaliticaDetalleId.setValue(entity.getTablaAnaliticaDetalleId());
            txtTablaAnaliticaDetalleId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTablaAnaliticaDetalle = (TablaAnaliticaDetalleDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTablaAnaliticaDetalle"));
        txtValorVariableEntrada1.setValue(selectedTablaAnaliticaDetalle.getValorVariableEntrada1());
        txtValorVariableEntrada1.setDisabled(false);
        txtValorVariableEntrada2.setValue(selectedTablaAnaliticaDetalle.getValorVariableEntrada2());
        txtValorVariableEntrada2.setDisabled(false);
        txtValorVariableEntrada3.setValue(selectedTablaAnaliticaDetalle.getValorVariableEntrada3());
        txtValorVariableEntrada3.setDisabled(false);
        txtValorVariableSalida1.setValue(selectedTablaAnaliticaDetalle.getValorVariableSalida1());
        txtValorVariableSalida1.setDisabled(false);
        txtValorVariableSalida2.setValue(selectedTablaAnaliticaDetalle.getValorVariableSalida2());
        txtValorVariableSalida2.setDisabled(false);
        txtTablaAnaliticaId_TablaAnalitica.setValue(selectedTablaAnaliticaDetalle.getTablaAnaliticaId_TablaAnalitica());
        txtTablaAnaliticaId_TablaAnalitica.setDisabled(false);
        txtTablaAnaliticaDetalleId.setValue(selectedTablaAnaliticaDetalle.getTablaAnaliticaDetalleId());
        txtTablaAnaliticaDetalleId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTablaAnaliticaDetalle == null) && (entity == null)) {
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
            entity = new TablaAnaliticaDetalle();

            Long tablaAnaliticaDetalleId = FacesUtils.checkLong(txtTablaAnaliticaDetalleId);

            entity.setTablaAnaliticaDetalleId(tablaAnaliticaDetalleId);
            entity.setValorVariableEntrada1(FacesUtils.checkDouble(
                    txtValorVariableEntrada1));
            entity.setValorVariableEntrada2(FacesUtils.checkDouble(
                    txtValorVariableEntrada2));
            entity.setValorVariableEntrada3(FacesUtils.checkDouble(
                    txtValorVariableEntrada3));
            entity.setValorVariableSalida1(FacesUtils.checkDouble(
                    txtValorVariableSalida1));
            entity.setValorVariableSalida2(FacesUtils.checkDouble(
                    txtValorVariableSalida2));
            entity.setTablaAnalitica((FacesUtils.checkLong(
                    txtTablaAnaliticaId_TablaAnalitica) != null)
                ? businessDelegator2View.getTablaAnalitica(FacesUtils.checkLong(
                        txtTablaAnaliticaId_TablaAnalitica)) : null);
            businessDelegator2View.saveTablaAnaliticaDetalle(entity);
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
                Long tablaAnaliticaDetalleId = new Long(selectedTablaAnaliticaDetalle.getTablaAnaliticaDetalleId());
                entity = businessDelegator2View.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId);
            }

            entity.setValorVariableEntrada1(FacesUtils.checkDouble(
                    txtValorVariableEntrada1));
            entity.setValorVariableEntrada2(FacesUtils.checkDouble(
                    txtValorVariableEntrada2));
            entity.setValorVariableEntrada3(FacesUtils.checkDouble(
                    txtValorVariableEntrada3));
            entity.setValorVariableSalida1(FacesUtils.checkDouble(
                    txtValorVariableSalida1));
            entity.setValorVariableSalida2(FacesUtils.checkDouble(
                    txtValorVariableSalida2));
            entity.setTablaAnalitica((FacesUtils.checkLong(
                    txtTablaAnaliticaId_TablaAnalitica) != null)
                ? businessDelegator2View.getTablaAnalitica(FacesUtils.checkLong(
                        txtTablaAnaliticaId_TablaAnalitica)) : null);
            businessDelegator2View.updateTablaAnaliticaDetalle(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTablaAnaliticaDetalle = (TablaAnaliticaDetalleDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedTablaAnaliticaDetalle"));

            Long tablaAnaliticaDetalleId = new Long(selectedTablaAnaliticaDetalle.getTablaAnaliticaDetalleId());
            entity = businessDelegator2View.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long tablaAnaliticaDetalleId = FacesUtils.checkLong(txtTablaAnaliticaDetalleId);
            entity = businessDelegator2View.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteTablaAnaliticaDetalle(entity);
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
            selectedTablaAnaliticaDetalle = (TablaAnaliticaDetalleDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedTablaAnaliticaDetalle"));

            Long tablaAnaliticaDetalleId = new Long(selectedTablaAnaliticaDetalle.getTablaAnaliticaDetalleId());
            entity = businessDelegator2View.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId);
            businessDelegator2View.deleteTablaAnaliticaDetalle(entity);
            data.remove(selectedTablaAnaliticaDetalle);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long tablaAnaliticaDetalleId,
        Double valorVariableEntrada1, Double valorVariableEntrada2,
        Double valorVariableEntrada3, Double valorVariableSalida1,
        Double valorVariableSalida2, Long tablaAnaliticaId_TablaAnalitica)
        throws Exception {
        try {
            entity.setValorVariableEntrada1(FacesUtils.checkDouble(
                    valorVariableEntrada1));
            entity.setValorVariableEntrada2(FacesUtils.checkDouble(
                    valorVariableEntrada2));
            entity.setValorVariableEntrada3(FacesUtils.checkDouble(
                    valorVariableEntrada3));
            entity.setValorVariableSalida1(FacesUtils.checkDouble(
                    valorVariableSalida1));
            entity.setValorVariableSalida2(FacesUtils.checkDouble(
                    valorVariableSalida2));
            businessDelegator2View.updateTablaAnaliticaDetalle(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TablaAnaliticaDetalleView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
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

    public InputText getTxtTablaAnaliticaId_TablaAnalitica() {
        return txtTablaAnaliticaId_TablaAnalitica;
    }

    public void setTxtTablaAnaliticaId_TablaAnalitica(
        InputText txtTablaAnaliticaId_TablaAnalitica) {
        this.txtTablaAnaliticaId_TablaAnalitica = txtTablaAnaliticaId_TablaAnalitica;
    }

    public InputText getTxtTablaAnaliticaDetalleId() {
        return txtTablaAnaliticaDetalleId;
    }

    public void setTxtTablaAnaliticaDetalleId(
        InputText txtTablaAnaliticaDetalleId) {
        this.txtTablaAnaliticaDetalleId = txtTablaAnaliticaDetalleId;
    }

    public List<TablaAnaliticaDetalleDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataTablaAnaliticaDetalle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TablaAnaliticaDetalleDTO> tablaAnaliticaDetalleDTO) {
        this.data = tablaAnaliticaDetalleDTO;
    }

    public TablaAnaliticaDetalleDTO getSelectedTablaAnaliticaDetalle() {
        return selectedTablaAnaliticaDetalle;
    }

    public void setSelectedTablaAnaliticaDetalle(
        TablaAnaliticaDetalleDTO tablaAnaliticaDetalle) {
        this.selectedTablaAnaliticaDetalle = tablaAnaliticaDetalle;
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
}
