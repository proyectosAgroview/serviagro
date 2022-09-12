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
import co.com.arcosoft.modelo.DatOtrosCostosMqdet;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatOtrosCostosMqdetView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosMqdetView.class);
    private InputText txtOrigenDatos;
    private InputText txtPorcentaje;
    private InputText txtDatOtrosCostosMqId_DatOtrosCostosMq;
    private InputText txtEquipoId_Equipo;
    private InputText txtTagId_Tag;
    private InputText txtDatOtrosCostosMqdetId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatOtrosCostosMqdetDTO> data;
    private DatOtrosCostosMqdetDTO selectedDatOtrosCostosMqdet;
    private DatOtrosCostosMqdet entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public DatOtrosCostosMqdetView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            DatOtrosCostosMqdetDTO datOtrosCostosMqdetDTO = (DatOtrosCostosMqdetDTO) e.getObject();

            if (txtOrigenDatos == null) {
                txtOrigenDatos = new InputText();
            }

            txtOrigenDatos.setValue(datOtrosCostosMqdetDTO.getOrigenDatos());

            if (txtPorcentaje == null) {
                txtPorcentaje = new InputText();
            }

            txtPorcentaje.setValue(datOtrosCostosMqdetDTO.getPorcentaje());

            if (txtDatOtrosCostosMqId_DatOtrosCostosMq == null) {
                txtDatOtrosCostosMqId_DatOtrosCostosMq = new InputText();
            }

            txtDatOtrosCostosMqId_DatOtrosCostosMq.setValue(datOtrosCostosMqdetDTO.getDatOtrosCostosMqId_DatOtrosCostosMq());

            if (txtEquipoId_Equipo == null) {
                txtEquipoId_Equipo = new InputText();
            }

            txtEquipoId_Equipo.setValue(datOtrosCostosMqdetDTO.getEquipoId_Equipo());

            if (txtTagId_Tag == null) {
                txtTagId_Tag = new InputText();
            }

            txtTagId_Tag.setValue(datOtrosCostosMqdetDTO.getTagId_Tag());

            if (txtDatOtrosCostosMqdetId == null) {
                txtDatOtrosCostosMqdetId = new InputText();
            }

            txtDatOtrosCostosMqdetId.setValue(datOtrosCostosMqdetDTO.getDatOtrosCostosMqdetId());

            Long datOtrosCostosMqdetId = FacesUtils.checkLong(txtDatOtrosCostosMqdetId);
            entity = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedDatOtrosCostosMqdet = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatOtrosCostosMqdet = null;

        if (txtOrigenDatos != null) {
            txtOrigenDatos.setValue(null);
            txtOrigenDatos.setDisabled(true);
        }

        if (txtPorcentaje != null) {
            txtPorcentaje.setValue(null);
            txtPorcentaje.setDisabled(true);
        }

        if (txtDatOtrosCostosMqId_DatOtrosCostosMq != null) {
            txtDatOtrosCostosMqId_DatOtrosCostosMq.setValue(null);
            txtDatOtrosCostosMqId_DatOtrosCostosMq.setDisabled(true);
        }

        if (txtEquipoId_Equipo != null) {
            txtEquipoId_Equipo.setValue(null);
            txtEquipoId_Equipo.setDisabled(true);
        }

        if (txtTagId_Tag != null) {
            txtTagId_Tag.setValue(null);
            txtTagId_Tag.setDisabled(true);
        }

        if (txtDatOtrosCostosMqdetId != null) {
            txtDatOtrosCostosMqdetId.setValue(null);
            txtDatOtrosCostosMqdetId.setDisabled(false);
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
            Long datOtrosCostosMqdetId = FacesUtils.checkLong(txtDatOtrosCostosMqdetId);
            entity = (datOtrosCostosMqdetId != null)
                ? businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtOrigenDatos.setDisabled(false);
            txtPorcentaje.setDisabled(false);
            txtDatOtrosCostosMqId_DatOtrosCostosMq.setDisabled(false);
            txtEquipoId_Equipo.setDisabled(false);
            txtTagId_Tag.setDisabled(false);
            txtDatOtrosCostosMqdetId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtOrigenDatos.setValue(entity.getOrigenDatos());
            txtOrigenDatos.setDisabled(false);
            txtPorcentaje.setValue(entity.getPorcentaje());
            txtPorcentaje.setDisabled(false);
            txtDatOtrosCostosMqId_DatOtrosCostosMq.setValue(entity.getDatOtrosCostosMq()
                                                                  .getDatOtrosCostosMqId());
            txtDatOtrosCostosMqId_DatOtrosCostosMq.setDisabled(false);
            txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
            txtEquipoId_Equipo.setDisabled(false);
            txtTagId_Tag.setValue(entity.getTag().getTagId());
            txtTagId_Tag.setDisabled(false);
            txtDatOtrosCostosMqdetId.setValue(entity.getDatOtrosCostosMqdetId());
            txtDatOtrosCostosMqdetId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedDatOtrosCostosMqdet = (DatOtrosCostosMqdetDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedDatOtrosCostosMqdet"));
        txtOrigenDatos.setValue(selectedDatOtrosCostosMqdet.getOrigenDatos());
        txtOrigenDatos.setDisabled(false);
        txtPorcentaje.setValue(selectedDatOtrosCostosMqdet.getPorcentaje());
        txtPorcentaje.setDisabled(false);
        txtDatOtrosCostosMqId_DatOtrosCostosMq.setValue(selectedDatOtrosCostosMqdet.getDatOtrosCostosMqId_DatOtrosCostosMq());
        txtDatOtrosCostosMqId_DatOtrosCostosMq.setDisabled(false);
        txtEquipoId_Equipo.setValue(selectedDatOtrosCostosMqdet.getEquipoId_Equipo());
        txtEquipoId_Equipo.setDisabled(false);
        txtTagId_Tag.setValue(selectedDatOtrosCostosMqdet.getTagId_Tag());
        txtTagId_Tag.setDisabled(false);
        txtDatOtrosCostosMqdetId.setValue(selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId());
        txtDatOtrosCostosMqdetId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedDatOtrosCostosMqdet == null) && (entity == null)) {
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
            entity = new DatOtrosCostosMqdet();

            Long datOtrosCostosMqdetId = FacesUtils.checkLong(txtDatOtrosCostosMqdetId);

            entity.setDatOtrosCostosMqdetId(datOtrosCostosMqdetId);
            entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
            entity.setPorcentaje(FacesUtils.checkDouble(txtPorcentaje));
            entity.setDatOtrosCostosMq((FacesUtils.checkLong(
                    txtDatOtrosCostosMqId_DatOtrosCostosMq) != null)
                ? businessDelegatorView.getDatOtrosCostosMq(
                    FacesUtils.checkLong(txtDatOtrosCostosMqId_DatOtrosCostosMq))
                : null);
            entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
                ? businessDelegatorView.getEquipo(FacesUtils.checkLong(
                        txtEquipoId_Equipo)) : null);
            entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
                ? businessDelegatorView.getTag(FacesUtils.checkLong(
                        txtTagId_Tag)) : null);
            businessDelegatorView.saveDatOtrosCostosMqdet(entity);
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
                Long datOtrosCostosMqdetId = new Long(selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId());
                entity = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);
            }

            entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
            entity.setPorcentaje(FacesUtils.checkDouble(txtPorcentaje));
            entity.setDatOtrosCostosMq((FacesUtils.checkLong(
                    txtDatOtrosCostosMqId_DatOtrosCostosMq) != null)
                ? businessDelegatorView.getDatOtrosCostosMq(
                    FacesUtils.checkLong(txtDatOtrosCostosMqId_DatOtrosCostosMq))
                : null);
            entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
                ? businessDelegatorView.getEquipo(FacesUtils.checkLong(
                        txtEquipoId_Equipo)) : null);
            entity.setTag((FacesUtils.checkLong(txtTagId_Tag) != null)
                ? businessDelegatorView.getTag(FacesUtils.checkLong(
                        txtTagId_Tag)) : null);
            businessDelegatorView.updateDatOtrosCostosMqdet(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatOtrosCostosMqdet = (DatOtrosCostosMqdetDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedDatOtrosCostosMqdet"));

            Long datOtrosCostosMqdetId = new Long(selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId());
            entity = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datOtrosCostosMqdetId = FacesUtils.checkLong(txtDatOtrosCostosMqdetId);
            entity = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteDatOtrosCostosMqdet(entity);
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
            selectedDatOtrosCostosMqdet = (DatOtrosCostosMqdetDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedDatOtrosCostosMqdet"));

            Long datOtrosCostosMqdetId = new Long(selectedDatOtrosCostosMqdet.getDatOtrosCostosMqdetId());
            entity = businessDelegatorView.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);
            businessDelegatorView.deleteDatOtrosCostosMqdet(entity);
            data.remove(selectedDatOtrosCostosMqdet);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long datOtrosCostosMqdetId,
        String origenDatos, Double porcentaje,
        Long datOtrosCostosMqId_DatOtrosCostosMq, Long equipoId_Equipo,
        Long tagId_Tag) throws Exception {
        try {
            entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
            entity.setPorcentaje(FacesUtils.checkDouble(porcentaje));
            businessDelegatorView.updateDatOtrosCostosMqdet(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatOtrosCostosMqdetView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtOrigenDatos() {
        return txtOrigenDatos;
    }

    public void setTxtOrigenDatos(InputText txtOrigenDatos) {
        this.txtOrigenDatos = txtOrigenDatos;
    }

    public InputText getTxtPorcentaje() {
        return txtPorcentaje;
    }

    public void setTxtPorcentaje(InputText txtPorcentaje) {
        this.txtPorcentaje = txtPorcentaje;
    }

    public InputText getTxtDatOtrosCostosMqId_DatOtrosCostosMq() {
        return txtDatOtrosCostosMqId_DatOtrosCostosMq;
    }

    public void setTxtDatOtrosCostosMqId_DatOtrosCostosMq(
        InputText txtDatOtrosCostosMqId_DatOtrosCostosMq) {
        this.txtDatOtrosCostosMqId_DatOtrosCostosMq = txtDatOtrosCostosMqId_DatOtrosCostosMq;
    }

    public InputText getTxtEquipoId_Equipo() {
        return txtEquipoId_Equipo;
    }

    public void setTxtEquipoId_Equipo(InputText txtEquipoId_Equipo) {
        this.txtEquipoId_Equipo = txtEquipoId_Equipo;
    }

    public InputText getTxtTagId_Tag() {
        return txtTagId_Tag;
    }

    public void setTxtTagId_Tag(InputText txtTagId_Tag) {
        this.txtTagId_Tag = txtTagId_Tag;
    }

    public InputText getTxtDatOtrosCostosMqdetId() {
        return txtDatOtrosCostosMqdetId;
    }

    public void setTxtDatOtrosCostosMqdetId(InputText txtDatOtrosCostosMqdetId) {
        this.txtDatOtrosCostosMqdetId = txtDatOtrosCostosMqdetId;
    }

    public List<DatOtrosCostosMqdetDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDatOtrosCostosMqdet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatOtrosCostosMqdetDTO> datOtrosCostosMqdetDTO) {
        this.data = datOtrosCostosMqdetDTO;
    }

    public DatOtrosCostosMqdetDTO getSelectedDatOtrosCostosMqdet() {
        return selectedDatOtrosCostosMqdet;
    }

    public void setSelectedDatOtrosCostosMqdet(
        DatOtrosCostosMqdetDTO datOtrosCostosMqdet) {
        this.selectedDatOtrosCostosMqdet = datOtrosCostosMqdet;
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
