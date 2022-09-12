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

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAnaLaboratorioDet;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatAnaLaboratorioDetView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatAnaLaboratorioDetView.class);
    private InputText txtDatAnaLabId_DatAnaLaboratorio;
    private InputText txtVariableLabId_VariableLab;
    private InputText txtDatAnaLaboratorioDetId;
    private InputText txtValorVariable;
    private InputText txtHora0000;
    private InputText txtHora0100;
    private InputText txtHora0200;
    private InputText txtHora0300;
    private InputText txtHora0400;
    private InputText txtHora0500;
    private InputText txtHora0600;
    private InputText txtHora0700;
    private InputText txtHora0800;
    private InputText txtHora0900;
    private InputText txtHora1000;
    private InputText txtHora1100;
    private InputText txtHora1200;
    private InputText txtHora1300;
    private InputText txtHora1400;
    private InputText txtHora1500;
    private InputText txtHora1600;
    private InputText txtHora1700;
    private InputText txtHora1800;
    private InputText txtHora1900;
    private InputText txtHora2000;
    private InputText txtHora2100;
    private InputText txtHora2200;
    private InputText txtHora2300;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatAnaLaboratorioDetDTO> data;
    private DatAnaLaboratorioDetDTO selectedDatAnaLaboratorioDet;
    private DatAnaLaboratorioDet entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public DatAnaLaboratorioDetView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            DatAnaLaboratorioDetDTO datAnaLaboratorioDetDTO = (DatAnaLaboratorioDetDTO) e.getObject();

            if (txtValorVariable == null) {
                txtValorVariable = new InputText();
            }

            txtValorVariable.setValue(datAnaLaboratorioDetDTO.getValorVariable());

            if (txtDatAnaLabId_DatAnaLaboratorio == null) {
                txtDatAnaLabId_DatAnaLaboratorio = new InputText();
            }

            txtDatAnaLabId_DatAnaLaboratorio.setValue(datAnaLaboratorioDetDTO.getDatAnaLabId_DatAnaLaboratorio());

            if (txtVariableLabId_VariableLab == null) {
                txtVariableLabId_VariableLab = new InputText();
            }

            txtVariableLabId_VariableLab.setValue(datAnaLaboratorioDetDTO.getVariableLabId_VariableLab());

            if (txtDatAnaLaboratorioDetId == null) {
                txtDatAnaLaboratorioDetId = new InputText();
            }

            txtDatAnaLaboratorioDetId.setValue(datAnaLaboratorioDetDTO.getDatAnaLaboratorioDetId());

            if (txtHora0000 == null) {
                txtHora0000 = new InputText();
            }

            txtHora0000.setValue(datAnaLaboratorioDetDTO.getHora0000());

            if (txtHora0100 == null) {
                txtHora0100 = new InputText();
            }

            txtHora0100.setValue(datAnaLaboratorioDetDTO.getHora0100());

            if (txtHora0200 == null) {
                txtHora0200 = new InputText();
            }

            txtHora0200.setValue(datAnaLaboratorioDetDTO.getHora0200());

            if (txtHora0300 == null) {
                txtHora0300 = new InputText();
            }

            txtHora0300.setValue(datAnaLaboratorioDetDTO.getHora0300());

            if (txtHora0400 == null) {
                txtHora0400 = new InputText();
            }

            txtHora0400.setValue(datAnaLaboratorioDetDTO.getHora0400());

            if (txtHora0500 == null) {
                txtHora0500 = new InputText();
            }

            txtHora0500.setValue(datAnaLaboratorioDetDTO.getHora0500());

            if (txtHora0600 == null) {
                txtHora0600 = new InputText();
            }

            txtHora0600.setValue(datAnaLaboratorioDetDTO.getHora0600());

            if (txtHora0700 == null) {
                txtHora0700 = new InputText();
            }

            txtHora0700.setValue(datAnaLaboratorioDetDTO.getHora0700());

            if (txtHora0800 == null) {
                txtHora0800 = new InputText();
            }

            txtHora0800.setValue(datAnaLaboratorioDetDTO.getHora0800());

            if (txtHora0900 == null) {
                txtHora0900 = new InputText();
            }

            txtHora0900.setValue(datAnaLaboratorioDetDTO.getHora0900());

            if (txtHora1000 == null) {
                txtHora1000 = new InputText();
            }

            txtHora1000.setValue(datAnaLaboratorioDetDTO.getHora1000());

            if (txtHora1100 == null) {
                txtHora1100 = new InputText();
            }

            txtHora1100.setValue(datAnaLaboratorioDetDTO.getHora1100());

            if (txtHora1200 == null) {
                txtHora1200 = new InputText();
            }

            txtHora1200.setValue(datAnaLaboratorioDetDTO.getHora1200());

            if (txtHora1300 == null) {
                txtHora1300 = new InputText();
            }

            txtHora1300.setValue(datAnaLaboratorioDetDTO.getHora1300());

            if (txtHora1400 == null) {
                txtHora1400 = new InputText();
            }

            txtHora1400.setValue(datAnaLaboratorioDetDTO.getHora1400());

            if (txtHora1500 == null) {
                txtHora1500 = new InputText();
            }

            txtHora1500.setValue(datAnaLaboratorioDetDTO.getHora1500());

            if (txtHora1600 == null) {
                txtHora1600 = new InputText();
            }

            txtHora1600.setValue(datAnaLaboratorioDetDTO.getHora1600());

            if (txtHora1700 == null) {
                txtHora1700 = new InputText();
            }

            txtHora1700.setValue(datAnaLaboratorioDetDTO.getHora1700());

            if (txtHora1800 == null) {
                txtHora1800 = new InputText();
            }

            txtHora1800.setValue(datAnaLaboratorioDetDTO.getHora1800());

            if (txtHora1900 == null) {
                txtHora1900 = new InputText();
            }

            txtHora1900.setValue(datAnaLaboratorioDetDTO.getHora1900());

            if (txtHora2000 == null) {
                txtHora2000 = new InputText();
            }

            txtHora2000.setValue(datAnaLaboratorioDetDTO.getHora2000());

            if (txtHora2100 == null) {
                txtHora2100 = new InputText();
            }

            txtHora2100.setValue(datAnaLaboratorioDetDTO.getHora2100());

            if (txtHora2200 == null) {
                txtHora2200 = new InputText();
            }

            txtHora2200.setValue(datAnaLaboratorioDetDTO.getHora2200());

            if (txtHora2300 == null) {
                txtHora2300 = new InputText();
            }

            txtHora2300.setValue(datAnaLaboratorioDetDTO.getHora2300());

            Long datAnaLaboratorioDetId = FacesUtils.checkLong(txtDatAnaLaboratorioDetId);
            entity = businessDelegatorView.getDatAnaLaboratorioDet(datAnaLaboratorioDetId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedDatAnaLaboratorioDet = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatAnaLaboratorioDet = null;

        if (txtValorVariable != null) {
            txtValorVariable.setValue(null);
            txtValorVariable.setDisabled(true);
        }

        if (txtDatAnaLabId_DatAnaLaboratorio != null) {
            txtDatAnaLabId_DatAnaLaboratorio.setValue(null);
            txtDatAnaLabId_DatAnaLaboratorio.setDisabled(true);
        }

        if (txtVariableLabId_VariableLab != null) {
            txtVariableLabId_VariableLab.setValue(null);
            txtVariableLabId_VariableLab.setDisabled(true);
        }

        if (txtHora0000 != null) {
            txtHora0000.setValue(null);
            txtHora0000.setDisabled(true);
        }

        if (txtHora0100 != null) {
            txtHora0100.setValue(null);
            txtHora0100.setDisabled(true);
        }

        if (txtHora0200 != null) {
            txtHora0200.setValue(null);
            txtHora0200.setDisabled(true);
        }

        if (txtHora0300 != null) {
            txtHora0300.setValue(null);
            txtHora0300.setDisabled(true);
        }

        if (txtHora0400 != null) {
            txtHora0400.setValue(null);
            txtHora0400.setDisabled(true);
        }

        if (txtHora0500 != null) {
            txtHora0500.setValue(null);
            txtHora0500.setDisabled(true);
        }

        if (txtHora0600 != null) {
            txtHora0600.setValue(null);
            txtHora0600.setDisabled(true);
        }

        if (txtHora0700 != null) {
            txtHora0700.setValue(null);
            txtHora0700.setDisabled(true);
        }

        if (txtHora0800 != null) {
            txtHora0800.setValue(null);
            txtHora0800.setDisabled(true);
        }

        if (txtHora0900 != null) {
            txtHora0900.setValue(null);
            txtHora0900.setDisabled(true);
        }

        if (txtHora1000 != null) {
            txtHora1000.setValue(null);
            txtHora1000.setDisabled(true);
        }

        if (txtHora1100 != null) {
            txtHora1100.setValue(null);
            txtHora1100.setDisabled(true);
        }

        if (txtHora1200 != null) {
            txtHora1200.setValue(null);
            txtHora1200.setDisabled(true);
        }

        if (txtHora1300 != null) {
            txtHora1300.setValue(null);
            txtHora1300.setDisabled(true);
        }

        if (txtHora1400 != null) {
            txtHora1400.setValue(null);
            txtHora1400.setDisabled(true);
        }

        if (txtHora1500 != null) {
            txtHora1500.setValue(null);
            txtHora1500.setDisabled(true);
        }

        if (txtHora1600 != null) {
            txtHora1600.setValue(null);
            txtHora1600.setDisabled(true);
        }

        if (txtHora1700 != null) {
            txtHora1700.setValue(null);
            txtHora1700.setDisabled(true);
        }

        if (txtHora1800 != null) {
            txtHora1800.setValue(null);
            txtHora1800.setDisabled(true);
        }

        if (txtHora1900 != null) {
            txtHora1900.setValue(null);
            txtHora1900.setDisabled(true);
        }

        if (txtHora2000 != null) {
            txtHora2000.setValue(null);
            txtHora2000.setDisabled(true);
        }

        if (txtHora2100 != null) {
            txtHora2100.setValue(null);
            txtHora2100.setDisabled(true);
        }

        if (txtHora2200 != null) {
            txtHora2200.setValue(null);
            txtHora2200.setDisabled(true);
        }

        if (txtHora2300 != null) {
            txtHora2300.setValue(null);
            txtHora2300.setDisabled(true);
        }

        if (txtDatAnaLaboratorioDetId != null) {
            txtDatAnaLaboratorioDetId.setValue(null);
            txtDatAnaLaboratorioDetId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtHora0000() {
        Date inputDate = (Date) txtHora0000.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0100() {
        Date inputDate = (Date) txtHora0100.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0200() {
        Date inputDate = (Date) txtHora0200.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0300() {
        Date inputDate = (Date) txtHora0300.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0400() {
        Date inputDate = (Date) txtHora0400.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0500() {
        Date inputDate = (Date) txtHora0500.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0600() {
        Date inputDate = (Date) txtHora0600.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0700() {
        Date inputDate = (Date) txtHora0700.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0800() {
        Date inputDate = (Date) txtHora0800.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora0900() {
        Date inputDate = (Date) txtHora0900.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1000() {
        Date inputDate = (Date) txtHora1000.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1100() {
        Date inputDate = (Date) txtHora1100.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1200() {
        Date inputDate = (Date) txtHora1200.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1300() {
        Date inputDate = (Date) txtHora1300.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1400() {
        Date inputDate = (Date) txtHora1400.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1500() {
        Date inputDate = (Date) txtHora1500.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1600() {
        Date inputDate = (Date) txtHora1600.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1700() {
        Date inputDate = (Date) txtHora1700.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1800() {
        Date inputDate = (Date) txtHora1800.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora1900() {
        Date inputDate = (Date) txtHora1900.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora2000() {
        Date inputDate = (Date) txtHora2000.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora2100() {
        Date inputDate = (Date) txtHora2100.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora2200() {
        Date inputDate = (Date) txtHora2200.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHora2300() {
        Date inputDate = (Date) txtHora2300.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long datAnaLaboratorioDetId = FacesUtils.checkLong(txtDatAnaLaboratorioDetId);
            entity = (datAnaLaboratorioDetId != null)
                ? businessDelegatorView.getDatAnaLaboratorioDet(datAnaLaboratorioDetId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtValorVariable.setDisabled(false);
            txtDatAnaLabId_DatAnaLaboratorio.setDisabled(false);
            txtVariableLabId_VariableLab.setDisabled(false);
            txtHora0000.setDisabled(false);
            txtHora0100.setDisabled(false);
            txtHora0200.setDisabled(false);
            txtHora0300.setDisabled(false);
            txtHora0400.setDisabled(false);
            txtHora0500.setDisabled(false);
            txtHora0600.setDisabled(false);
            txtHora0700.setDisabled(false);
            txtHora0800.setDisabled(false);
            txtHora0900.setDisabled(false);
            txtHora1000.setDisabled(false);
            txtHora1100.setDisabled(false);
            txtHora1200.setDisabled(false);
            txtHora1300.setDisabled(false);
            txtHora1400.setDisabled(false);
            txtHora1500.setDisabled(false);
            txtHora1600.setDisabled(false);
            txtHora1700.setDisabled(false);
            txtHora1800.setDisabled(false);
            txtHora1900.setDisabled(false);
            txtHora2000.setDisabled(false);
            txtHora2100.setDisabled(false);
            txtHora2200.setDisabled(false);
            txtHora2300.setDisabled(false);
            txtDatAnaLaboratorioDetId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtHora0000.setValue(entity.getHora0000());
            txtHora0000.setDisabled(false);
            txtHora0100.setValue(entity.getHora0100());
            txtHora0100.setDisabled(false);
            txtHora0200.setValue(entity.getHora0200());
            txtHora0200.setDisabled(false);
            txtHora0300.setValue(entity.getHora0300());
            txtHora0300.setDisabled(false);
            txtHora0400.setValue(entity.getHora0400());
            txtHora0400.setDisabled(false);
            txtHora0500.setValue(entity.getHora0500());
            txtHora0500.setDisabled(false);
            txtHora0600.setValue(entity.getHora0600());
            txtHora0600.setDisabled(false);
            txtHora0700.setValue(entity.getHora0700());
            txtHora0700.setDisabled(false);
            txtHora0800.setValue(entity.getHora0800());
            txtHora0800.setDisabled(false);
            txtHora0900.setValue(entity.getHora0900());
            txtHora0900.setDisabled(false);
            txtHora1000.setValue(entity.getHora1000());
            txtHora1000.setDisabled(false);
            txtHora1100.setValue(entity.getHora1100());
            txtHora1100.setDisabled(false);
            txtHora1200.setValue(entity.getHora1200());
            txtHora1200.setDisabled(false);
            txtHora1300.setValue(entity.getHora1300());
            txtHora1300.setDisabled(false);
            txtHora1400.setValue(entity.getHora1400());
            txtHora1400.setDisabled(false);
            txtHora1500.setValue(entity.getHora1500());
            txtHora1500.setDisabled(false);
            txtHora1600.setValue(entity.getHora1600());
            txtHora1600.setDisabled(false);
            txtHora1700.setValue(entity.getHora1700());
            txtHora1700.setDisabled(false);
            txtHora1800.setValue(entity.getHora1800());
            txtHora1800.setDisabled(false);
            txtHora1900.setValue(entity.getHora1900());
            txtHora1900.setDisabled(false);
            txtHora2000.setValue(entity.getHora2000());
            txtHora2000.setDisabled(false);
            txtHora2100.setValue(entity.getHora2100());
            txtHora2100.setDisabled(false);
            txtHora2200.setValue(entity.getHora2200());
            txtHora2200.setDisabled(false);
            txtHora2300.setValue(entity.getHora2300());
            txtHora2300.setDisabled(false);
            txtValorVariable.setValue(entity.getValorVariable());
            txtValorVariable.setDisabled(false);
            txtDatAnaLabId_DatAnaLaboratorio.setValue(entity.getDatAnaLaboratorio()
                                                            .getDatAnaLabId());
            txtDatAnaLabId_DatAnaLaboratorio.setDisabled(false);
            txtVariableLabId_VariableLab.setValue(entity.getVariableLab()
                                                        .getVariableLabId());
            txtVariableLabId_VariableLab.setDisabled(false);
            txtDatAnaLaboratorioDetId.setValue(entity.getDatAnaLaboratorioDetId());
            txtDatAnaLaboratorioDetId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedDatAnaLaboratorioDet = (DatAnaLaboratorioDetDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedDatAnaLaboratorioDet"));
        txtHora0000.setValue(selectedDatAnaLaboratorioDet.getHora0000());
        txtHora0000.setDisabled(false);
        txtHora0100.setValue(selectedDatAnaLaboratorioDet.getHora0100());
        txtHora0100.setDisabled(false);
        txtHora0200.setValue(selectedDatAnaLaboratorioDet.getHora0200());
        txtHora0200.setDisabled(false);
        txtHora0300.setValue(selectedDatAnaLaboratorioDet.getHora0300());
        txtHora0300.setDisabled(false);
        txtHora0400.setValue(selectedDatAnaLaboratorioDet.getHora0400());
        txtHora0400.setDisabled(false);
        txtHora0500.setValue(selectedDatAnaLaboratorioDet.getHora0500());
        txtHora0500.setDisabled(false);
        txtHora0600.setValue(selectedDatAnaLaboratorioDet.getHora0600());
        txtHora0600.setDisabled(false);
        txtHora0700.setValue(selectedDatAnaLaboratorioDet.getHora0700());
        txtHora0700.setDisabled(false);
        txtHora0800.setValue(selectedDatAnaLaboratorioDet.getHora0800());
        txtHora0800.setDisabled(false);
        txtHora0900.setValue(selectedDatAnaLaboratorioDet.getHora0900());
        txtHora0900.setDisabled(false);
        txtHora1000.setValue(selectedDatAnaLaboratorioDet.getHora1000());
        txtHora1000.setDisabled(false);
        txtHora1100.setValue(selectedDatAnaLaboratorioDet.getHora1100());
        txtHora1100.setDisabled(false);
        txtHora1200.setValue(selectedDatAnaLaboratorioDet.getHora1200());
        txtHora1200.setDisabled(false);
        txtHora1300.setValue(selectedDatAnaLaboratorioDet.getHora1300());
        txtHora1300.setDisabled(false);
        txtHora1400.setValue(selectedDatAnaLaboratorioDet.getHora1400());
        txtHora1400.setDisabled(false);
        txtHora1500.setValue(selectedDatAnaLaboratorioDet.getHora1500());
        txtHora1500.setDisabled(false);
        txtHora1600.setValue(selectedDatAnaLaboratorioDet.getHora1600());
        txtHora1600.setDisabled(false);
        txtHora1700.setValue(selectedDatAnaLaboratorioDet.getHora1700());
        txtHora1700.setDisabled(false);
        txtHora1800.setValue(selectedDatAnaLaboratorioDet.getHora1800());
        txtHora1800.setDisabled(false);
        txtHora1900.setValue(selectedDatAnaLaboratorioDet.getHora1900());
        txtHora1900.setDisabled(false);
        txtHora2000.setValue(selectedDatAnaLaboratorioDet.getHora2000());
        txtHora2000.setDisabled(false);
        txtHora2100.setValue(selectedDatAnaLaboratorioDet.getHora2100());
        txtHora2100.setDisabled(false);
        txtHora2200.setValue(selectedDatAnaLaboratorioDet.getHora2200());
        txtHora2200.setDisabled(false);
        txtHora2300.setValue(selectedDatAnaLaboratorioDet.getHora2300());
        txtHora2300.setDisabled(false);
        txtValorVariable.setValue(selectedDatAnaLaboratorioDet.getValorVariable());
        txtValorVariable.setDisabled(false);
        txtDatAnaLabId_DatAnaLaboratorio.setValue(selectedDatAnaLaboratorioDet.getDatAnaLabId_DatAnaLaboratorio());
        txtDatAnaLabId_DatAnaLaboratorio.setDisabled(false);
        txtVariableLabId_VariableLab.setValue(selectedDatAnaLaboratorioDet.getVariableLabId_VariableLab());
        txtVariableLabId_VariableLab.setDisabled(false);
        txtDatAnaLaboratorioDetId.setValue(selectedDatAnaLaboratorioDet.getDatAnaLaboratorioDetId());
        txtDatAnaLaboratorioDetId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedDatAnaLaboratorioDet == null) && (entity == null)) {
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
            entity = new DatAnaLaboratorioDet();

            Long datAnaLaboratorioDetId = FacesUtils.checkLong(txtDatAnaLaboratorioDetId);

            entity.setDatAnaLaboratorioDetId(datAnaLaboratorioDetId);
            entity.setHora0000(FacesUtils.checkDouble(txtHora0000));
            entity.setHora0100(FacesUtils.checkDouble(txtHora0100));
            entity.setHora0200(FacesUtils.checkDouble(txtHora0200));
            entity.setHora0300(FacesUtils.checkDouble(txtHora0300));
            entity.setHora0400(FacesUtils.checkDouble(txtHora0400));
            entity.setHora0500(FacesUtils.checkDouble(txtHora0500));
            entity.setHora0600(FacesUtils.checkDouble(txtHora0600));
            entity.setHora0700(FacesUtils.checkDouble(txtHora0700));
            entity.setHora0800(FacesUtils.checkDouble(txtHora0800));
            entity.setHora0900(FacesUtils.checkDouble(txtHora0900));
            entity.setHora1000(FacesUtils.checkDouble(txtHora1000));
            entity.setHora1100(FacesUtils.checkDouble(txtHora1100));
            entity.setHora1200(FacesUtils.checkDouble(txtHora1200));
            entity.setHora1300(FacesUtils.checkDouble(txtHora1300));
            entity.setHora1400(FacesUtils.checkDouble(txtHora1400));
            entity.setHora1500(FacesUtils.checkDouble(txtHora1500));
            entity.setHora1600(FacesUtils.checkDouble(txtHora1600));
            entity.setHora1700(FacesUtils.checkDouble(txtHora1700));
            entity.setHora1800(FacesUtils.checkDouble(txtHora1800));
            entity.setHora1900(FacesUtils.checkDouble(txtHora1900));
            entity.setHora2000(FacesUtils.checkDouble(txtHora2000));
            entity.setHora2100(FacesUtils.checkDouble(txtHora2100));
            entity.setHora2200(FacesUtils.checkDouble(txtHora2200));
            entity.setHora2300(FacesUtils.checkDouble(txtHora2300));
            entity.setValorVariable(FacesUtils.checkDouble(txtValorVariable));
            entity.setDatAnaLaboratorio((FacesUtils.checkLong(
                    txtDatAnaLabId_DatAnaLaboratorio) != null)
                ? businessDelegatorView.getDatAnaLaboratorio(
                    FacesUtils.checkLong(txtDatAnaLabId_DatAnaLaboratorio)) : null);
            entity.setVariableLab((FacesUtils.checkLong(
                    txtVariableLabId_VariableLab) != null)
                ? businessDelegatorView.getVariableLab(FacesUtils.checkLong(
                        txtVariableLabId_VariableLab)) : null);
            businessDelegatorView.saveDatAnaLaboratorioDet(entity);
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
                Long datAnaLaboratorioDetId = new Long(selectedDatAnaLaboratorioDet.getDatAnaLaboratorioDetId());
                entity = businessDelegatorView.getDatAnaLaboratorioDet(datAnaLaboratorioDetId);
            }

            entity.setHora0000(FacesUtils.checkDouble(txtHora0000));
            entity.setHora0100(FacesUtils.checkDouble(txtHora0100));
            entity.setHora0200(FacesUtils.checkDouble(txtHora0200));
            entity.setHora0300(FacesUtils.checkDouble(txtHora0300));
            entity.setHora0400(FacesUtils.checkDouble(txtHora0400));
            entity.setHora0500(FacesUtils.checkDouble(txtHora0500));
            entity.setHora0600(FacesUtils.checkDouble(txtHora0600));
            entity.setHora0700(FacesUtils.checkDouble(txtHora0700));
            entity.setHora0800(FacesUtils.checkDouble(txtHora0800));
            entity.setHora0900(FacesUtils.checkDouble(txtHora0900));
            entity.setHora1000(FacesUtils.checkDouble(txtHora1000));
            entity.setHora1100(FacesUtils.checkDouble(txtHora1100));
            entity.setHora1200(FacesUtils.checkDouble(txtHora1200));
            entity.setHora1300(FacesUtils.checkDouble(txtHora1300));
            entity.setHora1400(FacesUtils.checkDouble(txtHora1400));
            entity.setHora1500(FacesUtils.checkDouble(txtHora1500));
            entity.setHora1600(FacesUtils.checkDouble(txtHora1600));
            entity.setHora1700(FacesUtils.checkDouble(txtHora1700));
            entity.setHora1800(FacesUtils.checkDouble(txtHora1800));
            entity.setHora1900(FacesUtils.checkDouble(txtHora1900));
            entity.setHora2000(FacesUtils.checkDouble(txtHora2000));
            entity.setHora2100(FacesUtils.checkDouble(txtHora2100));
            entity.setHora2200(FacesUtils.checkDouble(txtHora2200));
            entity.setHora2300(FacesUtils.checkDouble(txtHora2300));
            entity.setValorVariable(FacesUtils.checkDouble(txtValorVariable));
            entity.setDatAnaLaboratorio((FacesUtils.checkLong(
                    txtDatAnaLabId_DatAnaLaboratorio) != null)
                ? businessDelegatorView.getDatAnaLaboratorio(
                    FacesUtils.checkLong(txtDatAnaLabId_DatAnaLaboratorio)) : null);
            entity.setVariableLab((FacesUtils.checkLong(
                    txtVariableLabId_VariableLab) != null)
                ? businessDelegatorView.getVariableLab(FacesUtils.checkLong(
                        txtVariableLabId_VariableLab)) : null);
            businessDelegatorView.updateDatAnaLaboratorioDet(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatAnaLaboratorioDet = (DatAnaLaboratorioDetDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedDatAnaLaboratorioDet"));

            Long datAnaLaboratorioDetId = new Long(selectedDatAnaLaboratorioDet.getDatAnaLaboratorioDetId());
            entity = businessDelegatorView.getDatAnaLaboratorioDet(datAnaLaboratorioDetId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datAnaLaboratorioDetId = FacesUtils.checkLong(txtDatAnaLaboratorioDetId);
            entity = businessDelegatorView.getDatAnaLaboratorioDet(datAnaLaboratorioDetId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteDatAnaLaboratorioDet(entity);
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
            selectedDatAnaLaboratorioDet = (DatAnaLaboratorioDetDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedDatAnaLaboratorioDet"));

            Long datAnaLaboratorioDetId = new Long(selectedDatAnaLaboratorioDet.getDatAnaLaboratorioDetId());
            entity = businessDelegatorView.getDatAnaLaboratorioDet(datAnaLaboratorioDetId);
            businessDelegatorView.deleteDatAnaLaboratorioDet(entity);
            data.remove(selectedDatAnaLaboratorioDet);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long datAnaLaboratorioDetId,
        Date hora0000, Date hora0100, Date hora0200, Date hora0300,
        Date hora0400, Date hora0500, Date hora0600, Date hora0700,
        Date hora0800, Date hora0900, Date hora1000, Date hora1100,
        Date hora1200, Date hora1300, Date hora1400, Date hora1500,
        Date hora1600, Date hora1700, Date hora1800, Date hora1900,
        Date hora2000, Date hora2100, Date hora2200, Date hora2300,
        Double valorVariable, Long datAnaLabId_DatAnaLaboratorio,
        Long variableLabId_VariableLab) throws Exception {
        try {
            entity.setHora0000(FacesUtils.checkDouble(hora0000));
            entity.setHora0100(FacesUtils.checkDouble(hora0100));
            entity.setHora0200(FacesUtils.checkDouble(hora0200));
            entity.setHora0300(FacesUtils.checkDouble(hora0300));
            entity.setHora0400(FacesUtils.checkDouble(hora0400));
            entity.setHora0500(FacesUtils.checkDouble(hora0500));
            entity.setHora0600(FacesUtils.checkDouble(hora0600));
            entity.setHora0700(FacesUtils.checkDouble(hora0700));
            entity.setHora0800(FacesUtils.checkDouble(hora0800));
            entity.setHora0900(FacesUtils.checkDouble(hora0900));
            entity.setHora1000(FacesUtils.checkDouble(hora1000));
            entity.setHora1100(FacesUtils.checkDouble(hora1100));
            entity.setHora1200(FacesUtils.checkDouble(hora1200));
            entity.setHora1300(FacesUtils.checkDouble(hora1300));
            entity.setHora1400(FacesUtils.checkDouble(hora1400));
            entity.setHora1500(FacesUtils.checkDouble(hora1500));
            entity.setHora1600(FacesUtils.checkDouble(hora1600));
            entity.setHora1700(FacesUtils.checkDouble(hora1700));
            entity.setHora1800(FacesUtils.checkDouble(hora1800));
            entity.setHora1900(FacesUtils.checkDouble(hora1900));
            entity.setHora2000(FacesUtils.checkDouble(hora2000));
            entity.setHora2100(FacesUtils.checkDouble(hora2100));
            entity.setHora2200(FacesUtils.checkDouble(hora2200));
            entity.setHora2300(FacesUtils.checkDouble(hora2300));
            entity.setValorVariable(FacesUtils.checkDouble(valorVariable));
            businessDelegatorView.updateDatAnaLaboratorioDet(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatAnaLaboratorioDetView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtValorVariable() {
        return txtValorVariable;
    }

    public void setTxtValorVariable(InputText txtValorVariable) {
        this.txtValorVariable = txtValorVariable;
    }

    public InputText getTxtDatAnaLabId_DatAnaLaboratorio() {
        return txtDatAnaLabId_DatAnaLaboratorio;
    }

    public void setTxtDatAnaLabId_DatAnaLaboratorio(
        InputText txtDatAnaLabId_DatAnaLaboratorio) {
        this.txtDatAnaLabId_DatAnaLaboratorio = txtDatAnaLabId_DatAnaLaboratorio;
    }

    public InputText getTxtVariableLabId_VariableLab() {
        return txtVariableLabId_VariableLab;
    }

    public void setTxtVariableLabId_VariableLab(
        InputText txtVariableLabId_VariableLab) {
        this.txtVariableLabId_VariableLab = txtVariableLabId_VariableLab;
    }

    public InputText getTxtHora0000() {
        return txtHora0000;
    }

    public void setTxtHora0000(InputText txtHora0000) {
        this.txtHora0000 = txtHora0000;
    }

    public InputText getTxtHora0100() {
        return txtHora0100;
    }

    public void setTxtHora0100(InputText txtHora0100) {
        this.txtHora0100 = txtHora0100;
    }

    public InputText getTxtHora0200() {
        return txtHora0200;
    }

    public void setTxtHora0200(InputText txtHora0200) {
        this.txtHora0200 = txtHora0200;
    }

    public InputText getTxtHora0300() {
        return txtHora0300;
    }

    public void setTxtHora0300(InputText txtHora0300) {
        this.txtHora0300 = txtHora0300;
    }

    public InputText getTxtHora0400() {
        return txtHora0400;
    }

    public void setTxtHora0400(InputText txtHora0400) {
        this.txtHora0400 = txtHora0400;
    }

    public InputText getTxtHora0500() {
        return txtHora0500;
    }

    public void setTxtHora0500(InputText txtHora0500) {
        this.txtHora0500 = txtHora0500;
    }

    public InputText getTxtHora0600() {
        return txtHora0600;
    }

    public void setTxtHora0600(InputText txtHora0600) {
        this.txtHora0600 = txtHora0600;
    }

    public InputText getTxtHora0700() {
        return txtHora0700;
    }

    public void setTxtHora0700(InputText txtHora0700) {
        this.txtHora0700 = txtHora0700;
    }

    public InputText getTxtHora0800() {
        return txtHora0800;
    }

    public void setTxtHora0800(InputText txtHora0800) {
        this.txtHora0800 = txtHora0800;
    }

    public InputText getTxtHora0900() {
        return txtHora0900;
    }

    public void setTxtHora0900(InputText txtHora0900) {
        this.txtHora0900 = txtHora0900;
    }

    public InputText getTxtHora1000() {
        return txtHora1000;
    }

    public void setTxtHora1000(InputText txtHora1000) {
        this.txtHora1000 = txtHora1000;
    }

    public InputText getTxtHora1100() {
        return txtHora1100;
    }

    public void setTxtHora1100(InputText txtHora1100) {
        this.txtHora1100 = txtHora1100;
    }

    public InputText getTxtHora1200() {
        return txtHora1200;
    }

    public void setTxtHora1200(InputText txtHora1200) {
        this.txtHora1200 = txtHora1200;
    }

    public InputText getTxtHora1300() {
        return txtHora1300;
    }

    public void setTxtHora1300(InputText txtHora1300) {
        this.txtHora1300 = txtHora1300;
    }

    public InputText getTxtHora1400() {
        return txtHora1400;
    }

    public void setTxtHora1400(InputText txtHora1400) {
        this.txtHora1400 = txtHora1400;
    }

    public InputText getTxtHora1500() {
        return txtHora1500;
    }

    public void setTxtHora1500(InputText txtHora1500) {
        this.txtHora1500 = txtHora1500;
    }

    public InputText getTxtHora1600() {
        return txtHora1600;
    }

    public void setTxtHora1600(InputText txtHora1600) {
        this.txtHora1600 = txtHora1600;
    }

    public InputText getTxtHora1700() {
        return txtHora1700;
    }

    public void setTxtHora1700(InputText txtHora1700) {
        this.txtHora1700 = txtHora1700;
    }

    public InputText getTxtHora1800() {
        return txtHora1800;
    }

    public void setTxtHora1800(InputText txtHora1800) {
        this.txtHora1800 = txtHora1800;
    }

    public InputText getTxtHora1900() {
        return txtHora1900;
    }

    public void setTxtHora1900(InputText txtHora1900) {
        this.txtHora1900 = txtHora1900;
    }

    public InputText getTxtHora2000() {
        return txtHora2000;
    }

    public void setTxtHora2000(InputText txtHora2000) {
        this.txtHora2000 = txtHora2000;
    }

    public InputText getTxtHora2100() {
        return txtHora2100;
    }

    public void setTxtHora2100(InputText txtHora2100) {
        this.txtHora2100 = txtHora2100;
    }

    public InputText getTxtHora2200() {
        return txtHora2200;
    }

    public void setTxtHora2200(InputText txtHora2200) {
        this.txtHora2200 = txtHora2200;
    }

    public InputText getTxtHora2300() {
        return txtHora2300;
    }

    public void setTxtHora2300(InputText txtHora2300) {
        this.txtHora2300 = txtHora2300;
    }

    public InputText getTxtDatAnaLaboratorioDetId() {
        return txtDatAnaLaboratorioDetId;
    }

    public void setTxtDatAnaLaboratorioDetId(
        InputText txtDatAnaLaboratorioDetId) {
        this.txtDatAnaLaboratorioDetId = txtDatAnaLaboratorioDetId;
    }

    public List<DatAnaLaboratorioDetDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDatAnaLaboratorioDet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatAnaLaboratorioDetDTO> datAnaLaboratorioDetDTO) {
        this.data = datAnaLaboratorioDetDTO;
    }

    public DatAnaLaboratorioDetDTO getSelectedDatAnaLaboratorioDet() {
        return selectedDatAnaLaboratorioDet;
    }

    public void setSelectedDatAnaLaboratorioDet(
        DatAnaLaboratorioDetDTO datAnaLaboratorioDet) {
        this.selectedDatAnaLaboratorioDet = datAnaLaboratorioDet;
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
