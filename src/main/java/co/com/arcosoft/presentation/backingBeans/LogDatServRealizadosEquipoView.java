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
import javax.faces.model.SelectItem;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.LogDatServRealizadosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.logServiciosMaqDTO;
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
public class LogDatServRealizadosEquipoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LogDatServRealizadosEquipoView.class);
    private InputText txtCompania;
    
    private InputText txtDatServRealizadosEquipoId;
    private InputText txtObservacion;
    private InputText txtUsuarioModificacion;
    private InputText txtLogDatServRealizadosEquipoId;
    private Calendar txtFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LogDatServRealizadosEquipoDTO> data;
    private LogDatServRealizadosEquipoDTO selectedLogDatServRealizadosEquipo;
    private LogDatServRealizadosEquipo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

    private List<logServiciosMaqDTO> dataReporte;
    
	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

    private InputNumber txtConsecutivo;
    
    public LogDatServRealizadosEquipoView() {
        super();
    }

 
    public String action_new() {
        action_clear();
        selectedLogDatServRealizadosEquipo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLogDatServRealizadosEquipo = null;

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtConsecutivo != null) {
            txtConsecutivo.setValue(null);
            txtConsecutivo.setDisabled(true);
        }

        if (txtDatServRealizadosEquipoId != null) {
            txtDatServRealizadosEquipoId.setValue(null);
            txtDatServRealizadosEquipoId.setDisabled(true);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(true);
        }

        if (txtUsuarioModificacion != null) {
            txtUsuarioModificacion.setValue(null);
            txtUsuarioModificacion.setDisabled(true);
        }

        if (txtFecha != null) {
            txtFecha.setValue(null);
            txtFecha.setDisabled(true);
        }

        if (txtLogDatServRealizadosEquipoId != null) {
            txtLogDatServRealizadosEquipoId.setValue(null);
            txtLogDatServRealizadosEquipoId.setDisabled(false);
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
            Long logDatServRealizadosEquipoId = FacesUtils.checkLong(txtLogDatServRealizadosEquipoId);
            entity = (logDatServRealizadosEquipoId != null)
                ? businessDelegator2View.getLogDatServRealizadosEquipo(logDatServRealizadosEquipoId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCompania.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            txtDatServRealizadosEquipoId.setDisabled(false);
            txtObservacion.setDisabled(false);
            txtUsuarioModificacion.setDisabled(false);
            txtFecha.setDisabled(false);
            txtLogDatServRealizadosEquipoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCompania.setValue(entity.getCompania());
            txtCompania.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(false);
            txtDatServRealizadosEquipoId.setValue(entity.getDatServRealizadosEquipoId());
            txtDatServRealizadosEquipoId.setDisabled(false);
            txtFecha.setValue(entity.getFecha());
            txtFecha.setDisabled(false);
            txtObservacion.setValue(entity.getObservacion());
            txtObservacion.setDisabled(false);
            txtUsuarioModificacion.setValue(entity.getUsuarioModificacion());
            txtUsuarioModificacion.setDisabled(false);
            txtLogDatServRealizadosEquipoId.setValue(entity.getLogDatServRealizadosEquipoId());
            txtLogDatServRealizadosEquipoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLogDatServRealizadosEquipo = (LogDatServRealizadosEquipoDTO) (evt.getComponent()
                                                                                 .getAttributes()
                                                                                 .get("selectedLogDatServRealizadosEquipo"));
        txtCompania.setValue(selectedLogDatServRealizadosEquipo.getCompania());
        txtCompania.setDisabled(false);
        txtConsecutivo.setValue(selectedLogDatServRealizadosEquipo.getConsecutivo());
        txtConsecutivo.setDisabled(false);
        txtDatServRealizadosEquipoId.setValue(selectedLogDatServRealizadosEquipo.getDatServRealizadosEquipoId());
        txtDatServRealizadosEquipoId.setDisabled(false);
        txtFecha.setValue(selectedLogDatServRealizadosEquipo.getFecha());
        txtFecha.setDisabled(false);
        txtObservacion.setValue(selectedLogDatServRealizadosEquipo.getObservacion());
        txtObservacion.setDisabled(false);
        txtUsuarioModificacion.setValue(selectedLogDatServRealizadosEquipo.getUsuarioModificacion());
        txtUsuarioModificacion.setDisabled(false);
        txtLogDatServRealizadosEquipoId.setValue(selectedLogDatServRealizadosEquipo.getLogDatServRealizadosEquipoId());
        txtLogDatServRealizadosEquipoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLogDatServRealizadosEquipo == null) &&
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
            entity = new LogDatServRealizadosEquipo();

            Long logDatServRealizadosEquipoId = FacesUtils.checkLong(txtLogDatServRealizadosEquipoId);

            entity.setCompania(FacesUtils.checkLong(txtCompania));
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setDatServRealizadosEquipoId(FacesUtils.checkLong(
                    txtDatServRealizadosEquipoId));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setLogDatServRealizadosEquipoId(logDatServRealizadosEquipoId);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setUsuarioModificacion(FacesUtils.checkLong(
                    txtUsuarioModificacion));
            businessDelegator2View.saveLogDatServRealizadosEquipo(entity);
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
                Long logDatServRealizadosEquipoId = new Long(selectedLogDatServRealizadosEquipo.getLogDatServRealizadosEquipoId());
                entity = businessDelegator2View.getLogDatServRealizadosEquipo(logDatServRealizadosEquipoId);
            }

            entity.setCompania(FacesUtils.checkLong(txtCompania));
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setDatServRealizadosEquipoId(FacesUtils.checkLong(
                    txtDatServRealizadosEquipoId));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setUsuarioModificacion(FacesUtils.checkLong(
                    txtUsuarioModificacion));
            businessDelegator2View.updateLogDatServRealizadosEquipo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLogDatServRealizadosEquipo = (LogDatServRealizadosEquipoDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedLogDatServRealizadosEquipo"));

            Long logDatServRealizadosEquipoId = new Long(selectedLogDatServRealizadosEquipo.getLogDatServRealizadosEquipoId());
            entity = businessDelegator2View.getLogDatServRealizadosEquipo(logDatServRealizadosEquipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long logDatServRealizadosEquipoId = FacesUtils.checkLong(txtLogDatServRealizadosEquipoId);
            entity = businessDelegator2View.getLogDatServRealizadosEquipo(logDatServRealizadosEquipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteLogDatServRealizadosEquipo(entity);
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
            selectedLogDatServRealizadosEquipo = (LogDatServRealizadosEquipoDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedLogDatServRealizadosEquipo"));

            Long logDatServRealizadosEquipoId = new Long(selectedLogDatServRealizadosEquipo.getLogDatServRealizadosEquipoId());
            entity = businessDelegator2View.getLogDatServRealizadosEquipo(logDatServRealizadosEquipoId);
            businessDelegator2View.deleteLogDatServRealizadosEquipo(entity);
            data.remove(selectedLogDatServRealizadosEquipo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long compania, Long consecutivo,
        Long datServRealizadosEquipoId, Date fecha,
        Long logDatServRealizadosEquipoId, String observacion,
        Long usuarioModificacion) throws Exception {
        try {
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
            entity.setDatServRealizadosEquipoId(FacesUtils.checkLong(
                    datServRealizadosEquipoId));
            entity.setFecha(FacesUtils.checkDate(fecha));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setUsuarioModificacion(FacesUtils.checkLong(
                    usuarioModificacion));
            businessDelegator2View.updateLogDatServRealizadosEquipo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LogDatServRealizadosEquipoView").requestRender();
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

  
    public InputText getTxtDatServRealizadosEquipoId() {
        return txtDatServRealizadosEquipoId;
    }

    public void setTxtDatServRealizadosEquipoId(
        InputText txtDatServRealizadosEquipoId) {
        this.txtDatServRealizadosEquipoId = txtDatServRealizadosEquipoId;
    }

    public InputText getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputText txtObservacion) {
        this.txtObservacion = txtObservacion;
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

    public InputText getTxtLogDatServRealizadosEquipoId() {
        return txtLogDatServRealizadosEquipoId;
    }

    public void setTxtLogDatServRealizadosEquipoId(
        InputText txtLogDatServRealizadosEquipoId) {
        this.txtLogDatServRealizadosEquipoId = txtLogDatServRealizadosEquipoId;
    }

	public void consultaLogPines() {
		
		try {
			
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			Long documento = 0L;			
			
			Long equipoId  = FacesUtils.checkLong(txtEquipoId_Equipo)	;
			  documento = FacesUtils.checkLong(txtConsecutivo);
			
			if(documento == null) {
			  documento = 0L;
			}
			
			if(equipoId != null && documento != null ){		
			
				dataReporte = businessDelegator2View.pr_log_dat_serv_realizados_equipo(compania,  equipoId, documento);
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
    
    public List<LogDatServRealizadosEquipoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataLogDatServRealizadosEquipo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<LogDatServRealizadosEquipoDTO> logDatServRealizadosEquipoDTO) {
        this.data = logDatServRealizadosEquipoDTO;
    }

    public LogDatServRealizadosEquipoDTO getSelectedLogDatServRealizadosEquipo() {
        return selectedLogDatServRealizadosEquipo;
    }

    public void setSelectedLogDatServRealizadosEquipo(
        LogDatServRealizadosEquipoDTO logDatServRealizadosEquipo) {
        this.selectedLogDatServRealizadosEquipo = logDatServRealizadosEquipo;
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

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {


			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						
						"categoriaEquipo.funcion", true, "Implemento", "<>",
						"categoriaEquipo.funcion", true, "Remolques/Vagones", "<>",
						"categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"
						
				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(), equipo.getCodigo()+"-"+equipo.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipo;
	}

	public void setSelectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}


	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}


	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}


	public void setTxtConsecutivo(InputNumber txtConsecutivo) {
		this.txtConsecutivo = txtConsecutivo;
	}


	public List<logServiciosMaqDTO> getDataReporte() {
		return dataReporte;
	}


	public void setDataReporte(List<logServiciosMaqDTO> dataReporte) {
		this.dataReporte = dataReporte;
	}


	public InputNumber getTxtConsecutivo() {
		return txtConsecutivo;
	}


	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}


	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
}
