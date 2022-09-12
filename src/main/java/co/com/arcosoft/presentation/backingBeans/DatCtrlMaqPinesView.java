package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatCtrlMaqPinesDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import org.primefaces.event.RowEditEvent;

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
public class DatCtrlMaqPinesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatCtrlMaqPinesView.class);
    private InputNumber txtBoletaFinal;
    private InputNumber txtBoletaInicial;
    private InputText txtCompania;
    private InputNumber txtConsecutivoPin;
    private InputText txtEstado;
    private InputText txtObservacion;
    private InputText txtObservacionAnularReg;
    private InputNumber txtUltHoroOdoMetro;
    private InputText txtUsuarioDigitacion;
    private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;
    private InputText txtDatCtrlMaqPinesId;
    private Calendar txtFechaAnulacion;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnSaveHabilitarEdicionPin;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatCtrlMaqPinesDTO> data;
    private DatCtrlMaqPinesDTO selectedDatCtrlMaqPines;
    private DatCtrlMaqPines entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    
    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;
    
    public DatCtrlMaqPinesView() {
        super();
    }
    
    private SelectOneMenu txtEquipoConsulta;
 	SelectItem[] selectEquipoConsulta;
 	private List<Equipo> equipoConsulta;

    
    public String action_new() {
        action_clear();
        selectedDatCtrlMaqPines = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatCtrlMaqPines = null;
      
    	PrimeFaces.current().resetInputs(":dialogDatCtrlMaqPines :frm");
    	
        if (txtBoletaFinal != null) {
            txtBoletaFinal.setValue(null);
            txtBoletaFinal.setDisabled(false);
        }

        if (txtBoletaInicial != null) {
            txtBoletaInicial.setValue(null);
            txtBoletaInicial.setDisabled(false);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(false);
        }

        if (txtConsecutivoPin != null) {
            txtConsecutivoPin.setValue(null);
            txtConsecutivoPin.setDisabled(false);
        }

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(false);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(false);
        }

        if (txtObservacionAnularReg != null) {
            txtObservacionAnularReg.setValue(null);
            txtObservacionAnularReg.setDisabled(false);
        }

        if (txtUltHoroOdoMetro != null) {
            txtUltHoroOdoMetro.setValue(null);
            txtUltHoroOdoMetro.setDisabled(false);
        }

        if (txtUsuarioDigitacion != null) {
            txtUsuarioDigitacion.setValue(null);
            txtUsuarioDigitacion.setDisabled(false);
        }

        if (txtEquipoId_Equipo != null) {
            txtEquipoId_Equipo.setValue(null);
            txtEquipoId_Equipo.setDisabled(false);
        }

        if (txtFechaAnulacion != null) {
            txtFechaAnulacion.setValue(null);
            txtFechaAnulacion.setDisabled(false);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(false);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(false);
        }

        if (txtDatCtrlMaqPinesId != null) {
            txtDatCtrlMaqPinesId.setValue(null);
            txtDatCtrlMaqPinesId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(false);
        }
        if (btnSaveHabilitarEdicionPin != null) {
        	btnSaveHabilitarEdicionPin.setDisabled(false);
        }
        
        
        if (btnModify != null) {
        	btnModify.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(false);
        }

        return "";
    }

    public void listener_txtFechaAnulacion() {
        Date inputDate = (Date) txtFechaAnulacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
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
        selectedDatCtrlMaqPines = (DatCtrlMaqPinesDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedDatCtrlMaqPines"));
        try {

			Long datCtrlMaqPinesId = selectedDatCtrlMaqPines.getDatCtrlMaqPinesId();
			Object[] condicion = { "datCtrlMaqPinesId", true, datCtrlMaqPinesId, "=" };
			List<DatCtrlMaqPines> lista = (datCtrlMaqPinesId != null)
					? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
		        txtBoletaFinal.setValue(entity.getBoletaFinal());
		        txtBoletaFinal.setDisabled(false);
		        txtBoletaInicial.setValue(entity.getBoletaInicial());
		        txtBoletaInicial.setDisabled(false);
		      
		        txtConsecutivoPin.setValue(entity.getConsecutivoPin());
		        txtConsecutivoPin.setDisabled(false);
		      
		         txtUltHoroOdoMetro.setValue(entity.getUltHoroOdoMetro());
		        txtUltHoroOdoMetro.setDisabled(false);
		        txtEquipoId_Equipo.setValue(entity.getEquipo().getEquipoId());
		        txtEquipoId_Equipo.setDisabled(true);
		        txtDatCtrlMaqPinesId.setValue(entity.getDatCtrlMaqPinesId());
		        txtDatCtrlMaqPinesId.setDisabled(true);
		        btnSave.setDisabled(false);
		        btnSaveHabilitarEdicionPin.setDisabled(false);
		        
		        setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

    public String action_save() {
        try {
            if ((selectedDatCtrlMaqPines == null) && (entity == null)) {
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
    
    public String action_saveHabilitarEdicionPin() {
        try {
            if ((selectedDatCtrlMaqPines == null) && (entity == null)) {
            	action_createHabilitarEdicionPin();
            } else {
            	action_modifyHabilitarEdicionPin();
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

    public String action_create() {
        try {
            entity = new DatCtrlMaqPines();
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
            //Long datCtrlMaqPinesId = FacesUtils.checkLong(txtDatCtrlMaqPinesId);

            entity.setBoletaFinal(FacesUtils.checkLong(txtBoletaFinal));
            entity.setBoletaInicial(FacesUtils.checkLong(txtBoletaInicial));
            entity.setCompania(compania);
            entity.setConsecutivoPin(FacesUtils.checkLong(txtConsecutivoPin));
           
            entity.setEstado(estado);
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechaCreacion(date);
            entity.setFechaModificacion(date);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setUltHoroOdoMetro(FacesUtils.checkDouble(txtUltHoroOdoMetro));
            entity.setUsuarioDigitacion(usuarioId);
            entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
                ? businessDelegatorView.getEquipo(FacesUtils.checkLong(
                        txtEquipoId_Equipo)) : null);
            Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
            
            Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
            Long indicadorMedidor =0L;
            if(equipo.getIndicador_vuelta_medidor()!=null) {
            	indicadorMedidor = equipo.getIndicador_vuelta_medidor();
            }
            entity.setIndicador_vuelta_medidor(indicadorMedidor);
           
            Long idExisteEquipo =  businessDelegator2View.pr_busqueda_maq_ctrpin(idEquipo);
            
        	if(idExisteEquipo==0 ){
        	businessDelegator2View.saveDatCtrlMaqPines(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            	
        }else{
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"El código de Máquina que esta intentando crear ya existe en la base de datos"));
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
                Long datCtrlMaqPinesId = new Long(selectedDatCtrlMaqPines.getDatCtrlMaqPinesId());
                entity = businessDelegator2View.getDatCtrlMaqPines(datCtrlMaqPinesId);
            }
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			
            entity.setBoletaFinal(FacesUtils.checkLong(txtBoletaFinal));
            entity.setBoletaInicial(FacesUtils.checkLong(txtBoletaInicial));
            entity.setCompania(compania);
            entity.setConsecutivoPin(FacesUtils.checkLong(txtConsecutivoPin));
            //entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            //entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(date);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setUltHoroOdoMetro(FacesUtils.checkDouble(txtUltHoroOdoMetro));
            entity.setUsuarioDigitacion(usuarioId);
            entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
                ? businessDelegatorView.getEquipo(FacesUtils.checkLong(
                        txtEquipoId_Equipo)) : null);
            
            Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
            Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
            Long indicadorMedidor =0L;
            if(equipo.getIndicador_vuelta_medidor()!=null) {
            	indicadorMedidor = equipo.getIndicador_vuelta_medidor();
            }
            entity.setIndicador_vuelta_medidor(indicadorMedidor);
            
            businessDelegator2View.updateDatCtrlMaqPines(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }


    
    public String action_createHabilitarEdicionPin() {
        try {
            entity = new DatCtrlMaqPines();
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
            //Long datCtrlMaqPinesId = FacesUtils.checkLong(txtDatCtrlMaqPinesId);

            entity.setBoletaFinal(FacesUtils.checkLong(txtBoletaFinal));
            entity.setBoletaInicial(FacesUtils.checkLong(txtBoletaInicial));
            entity.setCompania(compania);
            entity.setConsecutivoPin(FacesUtils.checkLong(txtConsecutivoPin));
           
            entity.setEstado(estado);
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechaCreacion(date);
            entity.setFechaModificacion(date);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setUltHoroOdoMetro(FacesUtils.checkDouble(txtUltHoroOdoMetro));
            entity.setUsuarioDigitacion(usuarioId);
            entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
                ? businessDelegatorView.getEquipo(FacesUtils.checkLong(
                        txtEquipoId_Equipo)) : null);
            Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
            Equipo equipo = businessDelegatorView.getEquipo(idEquipo);
            Long indicadorMedidor =0L;
            if(equipo.getIndicador_vuelta_medidor()!=null) {
            	indicadorMedidor = equipo.getIndicador_vuelta_medidor();
            }
            entity.setIndicador_vuelta_medidor(indicadorMedidor);
            
            Long idExisteEquipo =  businessDelegator2View.pr_busqueda_maq_ctrpin(idEquipo);
            
        	if(idExisteEquipo==0 ){
        	businessDelegator2View.saveDatCtrlMaqPines(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            Long idmaq = FacesUtils.checkLong(txtEquipoId_Equipo);
			Long consecutivoPin =FacesUtils.checkLong(txtConsecutivoPin); 
			
			 Long habilitaEdicionPin = businessDelegator2View.pr_actualiza_edicion_dat_serv_realizados( idmaq,  consecutivoPin);
        	
            	
        }else{
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"El código de Máquina que esta intentando crear ya existe en la base de datos"));
        }
        
        	
           
            
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyHabilitarEdicionPin() {
        try {
            if (entity == null) {
                Long datCtrlMaqPinesId = new Long(selectedDatCtrlMaqPines.getDatCtrlMaqPinesId());
                entity = businessDelegator2View.getDatCtrlMaqPines(datCtrlMaqPinesId);
            }
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			
            entity.setBoletaFinal(FacesUtils.checkLong(txtBoletaFinal));
            entity.setBoletaInicial(FacesUtils.checkLong(txtBoletaInicial));
            entity.setCompania(compania);
            entity.setConsecutivoPin(FacesUtils.checkLong(txtConsecutivoPin));
            //entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            //entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(date);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setUltHoroOdoMetro(FacesUtils.checkDouble(txtUltHoroOdoMetro));
            entity.setUsuarioDigitacion(usuarioId);
            entity.setEquipo((FacesUtils.checkLong(txtEquipoId_Equipo) != null)
                ? businessDelegatorView.getEquipo(FacesUtils.checkLong(
                        txtEquipoId_Equipo)) : null);
            businessDelegator2View.updateDatCtrlMaqPines(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
            
            Long idmaq = FacesUtils.checkLong(txtEquipoId_Equipo);
			Long consecutivoPin =FacesUtils.checkLong(txtConsecutivoPin); 
			
			 Long habilitaEdicionPin = businessDelegator2View.pr_actualiza_edicion_dat_serv_realizados( idmaq,  consecutivoPin);
        	
        	
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    
    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatCtrlMaqPines = (DatCtrlMaqPinesDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedDatCtrlMaqPines"));

            Long datCtrlMaqPinesId = new Long(selectedDatCtrlMaqPines.getDatCtrlMaqPinesId());
            entity = businessDelegator2View.getDatCtrlMaqPines(datCtrlMaqPinesId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datCtrlMaqPinesId = FacesUtils.checkLong(txtDatCtrlMaqPinesId);
            entity = businessDelegator2View.getDatCtrlMaqPines(datCtrlMaqPinesId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteDatCtrlMaqPines(entity);
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
            selectedDatCtrlMaqPines = (DatCtrlMaqPinesDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedDatCtrlMaqPines"));

            Long datCtrlMaqPinesId = new Long(selectedDatCtrlMaqPines.getDatCtrlMaqPinesId());
            entity = businessDelegator2View.getDatCtrlMaqPines(datCtrlMaqPinesId);
            businessDelegator2View.deleteDatCtrlMaqPines(entity);
            data.remove(selectedDatCtrlMaqPines);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long boletaFinal, Long boletaInicial,
        Long compania, Long consecutivoPin, Long datCtrlMaqPinesId,
        String estado, Date fechaAnulacion, Date fechaCreacion,
        Date fechaModificacion, String observacion,
        String observacionAnularReg, Double ultHoroOdoMetro,
        Long usuarioDigitacion, Long equipoId_Equipo) throws Exception {
        try {
            entity.setBoletaFinal(FacesUtils.checkLong(boletaFinal));
            entity.setBoletaInicial(FacesUtils.checkLong(boletaInicial));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConsecutivoPin(FacesUtils.checkLong(consecutivoPin));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    observacionAnularReg));
            entity.setUltHoroOdoMetro(FacesUtils.checkDouble(ultHoroOdoMetro));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
            businessDelegator2View.updateDatCtrlMaqPines(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatCtrlMaqPinesView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputNumber getTxtBoletaFinal() {
        return txtBoletaFinal;
    }

    public void setTxtBoletaFinal(InputNumber txtBoletaFinal) {
        this.txtBoletaFinal = txtBoletaFinal;
    }

    public InputNumber getTxtBoletaInicial() {
        return txtBoletaInicial;
    }

    public void setTxtBoletaInicial(InputNumber txtBoletaInicial) {
        this.txtBoletaInicial = txtBoletaInicial;
    }

    public InputText getTxtCompania() {
        return txtCompania;
    }

    public void setTxtCompania(InputText txtCompania) {
        this.txtCompania = txtCompania;
    }

    public InputNumber getTxtConsecutivoPin() {
        return txtConsecutivoPin;
    }

    public void setTxtConsecutivoPin(InputNumber txtConsecutivoPin) {
        this.txtConsecutivoPin = txtConsecutivoPin;
    }

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputText getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputText txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public InputText getTxtObservacionAnularReg() {
        return txtObservacionAnularReg;
    }

    public void setTxtObservacionAnularReg(InputText txtObservacionAnularReg) {
        this.txtObservacionAnularReg = txtObservacionAnularReg;
    }

    public InputNumber getTxtUltHoroOdoMetro() {
        return txtUltHoroOdoMetro;
    }

    public void setTxtUltHoroOdoMetro(InputNumber txtUltHoroOdoMetro) {
        this.txtUltHoroOdoMetro = txtUltHoroOdoMetro;
    }

    public InputText getTxtUsuarioDigitacion() {
        return txtUsuarioDigitacion;
    }

    public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
        this.txtUsuarioDigitacion = txtUsuarioDigitacion;
    }

    public SelectOneMenu getTxtEquipoId_Equipo() {
        return txtEquipoId_Equipo;
    }

    public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
        this.txtEquipoId_Equipo = txtEquipoId_Equipo;
    }

    public Calendar getTxtFechaAnulacion() {
        return txtFechaAnulacion;
    }

    public void setTxtFechaAnulacion(Calendar txtFechaAnulacion) {
        this.txtFechaAnulacion = txtFechaAnulacion;
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

    public InputText getTxtDatCtrlMaqPinesId() {
        return txtDatCtrlMaqPinesId;
    }

    public void setTxtDatCtrlMaqPinesId(InputText txtDatCtrlMaqPinesId) {
        this.txtDatCtrlMaqPinesId = txtDatCtrlMaqPinesId;
    }

    public List<DatCtrlMaqPinesDTO> getData() {
        try {
          
            	
            	Long filtroEquipo = 0l;
            	
            	
            	
            	if(txtEquipoConsulta.getValue()!=null) {
            		filtroEquipo = FacesUtils.checkLong(txtEquipoConsulta);
            		if(filtroEquipo==0l) {
                		data = businessDelegator2View.getDataDatCtrlMaqPines();
                	}else {
                		data = businessDelegator2View.getDataDatCtrlMaqPinesFiltroEquipo(filtroEquipo);
                	}
            	}
            	
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatCtrlMaqPinesDTO> datCtrlMaqPinesDTO) {
        this.data = datCtrlMaqPinesDTO;
    }

    public DatCtrlMaqPinesDTO getSelectedDatCtrlMaqPines() {
        return selectedDatCtrlMaqPines;
    }

    public void setSelectedDatCtrlMaqPines(DatCtrlMaqPinesDTO datCtrlMaqPines) {
        this.selectedDatCtrlMaqPines = datCtrlMaqPines;
    }

    public CommandButton getBtnSaveHabilitarEdicionPin() {
		return btnSaveHabilitarEdicionPin;
	}


	public void setBtnSaveHabilitarEdicionPin(CommandButton btnSaveHabilitarEdicionPin) {
		this.btnSaveHabilitarEdicionPin = btnSaveHabilitarEdicionPin;
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
    
	public SelectItem[] getselectEquipo() {

		if (equipo == null || equipo.size() == 0) {


			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "="
						, "categoriaEquipo.funcion", true, "Implemento", "<>",
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

	public void setselectEquipo(SelectItem[] selectEquipo) {
		this.selectEquipo = selectEquipo;
	}


	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}


	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
	

	public SelectItem[] getselectEquipoConsulta() {

		if (equipoConsulta == null || equipoConsulta.size() == 0) {


			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "="
						, "categoriaEquipo.funcion", true, "Implemento", "<>",
						"categoriaEquipo.funcion", true, "Remolques/Vagones", "<>",
						"categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"
						
				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipoConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipoConsulta : lista) {
					selectEquipoConsulta[i] = new SelectItem(equipoConsulta.getEquipoId(), equipoConsulta.getCodigo()+"-"+equipoConsulta.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipoConsulta;
	}

	public void setselectEquipoConsulta(SelectItem[] selectEquipoConsulta) {
		this.selectEquipoConsulta = selectEquipoConsulta;
	}

	public SelectOneMenu getTxtEquipoConsulta() {
		return txtEquipoConsulta;
	}

	public void setTxtEquipoConsulta(SelectOneMenu txtEquipoConsulta) {
		this.txtEquipoConsulta = txtEquipoConsulta;
	}


}
