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
import javax.faces.model.SelectItem;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AgenteCausadorParada;
import co.com.arcosoft.modelo.AreaTrabajo;
import co.com.arcosoft.modelo.DatParadasFabrica;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.MotivosEntradaTaller;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatParadasFabricaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatParadasFabricaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatParadasFabricaView.class);
    private InputText txtCompania;
    private InputText txtConsecutivo;
    private InputTextarea txtDescripcionParada;
    private SelectOneRadio txtEstado;
    private InputText txtObservacionAnularReg;
    private InputText txtObservaciones;
    private SelectOneMenu txtParadaCritica;
    
    
	private SelectOneMenu txtEquipoId;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtMotivosParadaId;
	SelectItem[] selectMotivoEntradaTaller;
	private List<MotivosEntradaTaller> motivoEntradaTaller;

	private SelectOneMenu txtTagId;
	SelectItem[] selectTag;
	private List<Tag> tag;
	
	private SelectOneMenu txtAgenteCausadorParadaId;
	SelectItem[] selectAgenteCausador;
	private List<AgenteCausadorParada> agenteCausador;


	private SelectOneMenu txtAreaTrabajoId;
	SelectItem[] selectAreaTrabajo;
	private List<AreaTrabajo> area;


    
    private InputText txtDatParadasFabricaId;
    private Calendar txtFechaAnulacion;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private Calendar txtFechapFinal;
    private Calendar txtFechapInicial;
    private Calendar txtHorapFinal;
    private Calendar txtHorapInicial;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatParadasFabricaDTO> data;
    private DatParadasFabricaDTO selectedDatParadasFabrica;
    private DatParadasFabrica entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public DatParadasFabricaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedDatParadasFabrica = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatParadasFabrica = null;
        PrimeFaces.current().resetInputs(":dialogDatParadasFabrica :frm");
		
        if (txtAgenteCausadorParadaId != null) {
            txtAgenteCausadorParadaId.setValue(null);
            txtAgenteCausadorParadaId.setDisabled(false);
        }

        if (txtAreaTrabajoId != null) {
            txtAreaTrabajoId.setValue(null);
            txtAreaTrabajoId.setDisabled(false);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(false);
        }

        if (txtConsecutivo != null) {
            txtConsecutivo.setValue(null);
            txtConsecutivo.setDisabled(true);
        }

        if (txtDescripcionParada != null) {
            txtDescripcionParada.setValue(null);
            txtDescripcionParada.setDisabled(false);
        }

        if (txtEquipoId != null) {
            txtEquipoId.setValue(null);
            txtEquipoId.setDisabled(false);
        }

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(false);
        }

        if (txtMotivosParadaId != null) {
            txtMotivosParadaId.setValue(null);
            txtMotivosParadaId.setDisabled(false);
        }

        if (txtObservacionAnularReg != null) {
            txtObservacionAnularReg.setValue(null);
            txtObservacionAnularReg.setDisabled(false);
        }

        if (txtObservaciones != null) {
            txtObservaciones.setValue(null);
            txtObservaciones.setDisabled(false);
        }

        if (txtParadaCritica != null) {
            txtParadaCritica.setValue(null);
            txtParadaCritica.setDisabled(false);
        }

        if (txtTagId != null) {
            txtTagId.setValue(null);
            txtTagId.setDisabled(false);
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

        if (txtFechapFinal != null) {
            txtFechapFinal.setValue(null);
            txtFechapFinal.setDisabled(false);
        }

        if (txtFechapInicial != null) {
            txtFechapInicial.setValue(null);
            txtFechapInicial.setDisabled(false);
        }

        if (txtHorapFinal != null) {
            txtHorapFinal.setValue(null);
            txtHorapFinal.setDisabled(false);
        }

        if (txtHorapInicial != null) {
            txtHorapInicial.setValue(null);
            txtHorapInicial.setDisabled(false);
        }

        if (txtDatParadasFabricaId != null) {
            txtDatParadasFabricaId.setValue(null);
            txtDatParadasFabricaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(false);
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

    public void listener_txtFechapFinal() {
        Date inputDate = (Date) txtFechapFinal.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechapInicial() {
        Date inputDate = (Date) txtFechapInicial.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHorapFinal() {
        Date inputDate = (Date) txtHorapFinal.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHorapInicial() {
        Date inputDate = (Date) txtHorapInicial.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public String action_edit(ActionEvent evt) {
        selectedDatParadasFabrica = (DatParadasFabricaDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedDatParadasFabrica"));
        
    	try {

			Long consecutivo = selectedDatParadasFabrica.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatParadasFabrica> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatParadasFabrica(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

        txtAgenteCausadorParadaId.setValue(selectedDatParadasFabrica.getAgenteCausadorParadaId());
        txtAgenteCausadorParadaId.setDisabled(false);
        txtAreaTrabajoId.setValue(selectedDatParadasFabrica.getAreaTrabajoId());
        txtAreaTrabajoId.setDisabled(false);
        txtConsecutivo.setValue(entity.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        txtDescripcionParada.setValue(entity.getDescripcionParada());
        txtDescripcionParada.setDisabled(false);
        txtEquipoId.setValue(selectedDatParadasFabrica.getEquipoId());
        txtEquipoId.setDisabled(false);
        //txtEstado.setValue(entity.getEstado());
       // txtEstado.setDisabled(false);
        txtFechapFinal.setValue(entity.getFechapFinal());
        txtFechapFinal.setDisabled(false);
        txtFechapInicial.setValue(entity.getFechapInicial());
        txtFechapInicial.setDisabled(false);
        txtMotivosParadaId.setValue(selectedDatParadasFabrica.getMotivosParadaId());
        txtMotivosParadaId.setDisabled(false);
        txtParadaCritica.setValue(entity.getParadaCritica());
        txtParadaCritica.setDisabled(false);
        txtTagId.setValue(selectedDatParadasFabrica.getTagId());
        txtTagId.setDisabled(false);
        txtDatParadasFabricaId.setValue(entity.getDatParadasFabricaId());
        txtDatParadasFabricaId.setDisabled(true);

        btnSave.setDisabled(false);
        setShowDialog(true);


			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}


    public String action_save() {
        try {
            if ((selectedDatParadasFabrica == null) && (entity == null)) {
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
            entity = new DatParadasFabrica();

//            Long datParadasFabricaId = FacesUtils.checkLong(txtDatParadasFabricaId);
			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setAgenteCausadorParadaId(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId))
							: null);
			entity.setEquipoId((FacesUtils.checkLong(txtEquipoId) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId))
					: null);
			entity.setMotivosParadaId(
					(FacesUtils.checkLong(txtMotivosParadaId) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosParadaId))
							: null);
			entity.setTagId((FacesUtils.checkLong(txtTagId) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId))
					: null);
			entity.setAreaTrabajoId((FacesUtils.checkLong(txtAreaTrabajoId) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId))
					: null);
			
			entity.setConsecutivo(businessDelegatorView.consultarConsecutivoParadasFabrica(compania));
			
  //          entity.setDatParadasFabricaId(datParadasFabricaId);
            entity.setDescripcionParada(FacesUtils.checkString(
                    txtDescripcionParada));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setFechapFinal(FacesUtils.checkDate(txtFechapFinal));
            entity.setFechapInicial(FacesUtils.checkDate(txtFechapInicial));
            entity.setHorapFinal(FacesUtils.checkDate(txtHorapFinal));
            entity.setHorapInicial(FacesUtils.checkDate(txtHorapInicial));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setObservaciones(FacesUtils.checkString(txtObservaciones));
            entity.setParadaCritica(FacesUtils.checkString(txtParadaCritica));
            businessDelegatorView.saveDatParadasFabrica(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoParadasFabrica(compania) - 1));
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
                Long datParadasFabricaId = new Long(selectedDatParadasFabrica.getDatParadasFabricaId());
                entity = businessDelegatorView.getDatParadasFabrica(datParadasFabricaId);
            }

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setFechaModificacion(date);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setAgenteCausadorParadaId(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId))
							: null);
			entity.setEquipoId((FacesUtils.checkLong(txtEquipoId) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId))
					: null);
			entity.setMotivosParadaId(
					(FacesUtils.checkLong(txtMotivosParadaId) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosParadaId))
							: null);
			entity.setTagId((FacesUtils.checkLong(txtTagId) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId))
					: null);
			entity.setAreaTrabajoId((FacesUtils.checkLong(txtAreaTrabajoId) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId))
					: null);
			
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setDescripcionParada(FacesUtils.checkString(
                    txtDescripcionParada));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechapFinal(FacesUtils.checkDate(txtFechapFinal));
            entity.setFechapInicial(FacesUtils.checkDate(txtFechapInicial));
            entity.setHorapFinal(FacesUtils.checkDate(txtHorapFinal));
            entity.setHorapInicial(FacesUtils.checkDate(txtHorapInicial));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setObservaciones(FacesUtils.checkString(txtObservaciones));
            entity.setParadaCritica(FacesUtils.checkString(txtParadaCritica));
            businessDelegatorView.updateDatParadasFabrica(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatParadasFabrica = (DatParadasFabricaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedDatParadasFabrica"));

            Long datParadasFabricaId = new Long(selectedDatParadasFabrica.getDatParadasFabricaId());
            entity = businessDelegatorView.getDatParadasFabrica(datParadasFabricaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datParadasFabricaId = FacesUtils.checkLong(txtDatParadasFabricaId);
            entity = businessDelegatorView.getDatParadasFabrica(datParadasFabricaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteDatParadasFabrica(entity);
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
            selectedDatParadasFabrica = (DatParadasFabricaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedDatParadasFabrica"));

            Long datParadasFabricaId = new Long(selectedDatParadasFabrica.getDatParadasFabricaId());
            entity = businessDelegatorView.getDatParadasFabrica(datParadasFabricaId);
            businessDelegatorView.deleteDatParadasFabrica(entity);
            data.remove(selectedDatParadasFabrica);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long agenteCausadorParadaId,
        Long areaTrabajoId, Long compania, Long consecutivo,
        Long datParadasFabricaId, String descripcionParada, Long equipoId,
        String estado, Date fechaAnulacion, Date fechaCreacion,
        Date fechaModificacion, Date fechapFinal, Date fechapInicial,
        Date horapFinal, Date horapInicial, Long motivosParadaId,
        String observacionAnularReg, String observaciones,
        String paradaCritica, Long tagId) throws Exception {
        try {
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
            entity.setDescripcionParada(FacesUtils.checkString(
                    descripcionParada));
            entity.setAgenteCausadorParadaId(
					(FacesUtils.checkLong(txtAgenteCausadorParadaId) != null)
							? businessDelegatorView.getAgenteCausadorParada(
									FacesUtils.checkLong(txtAgenteCausadorParadaId))
							: null);
			entity.setEquipoId((FacesUtils.checkLong(txtEquipoId) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtEquipoId))
					: null);
			entity.setMotivosParadaId(
					(FacesUtils.checkLong(txtMotivosParadaId) != null)
							? businessDelegatorView.getMotivosEntradaTaller(
									FacesUtils.checkLong(txtMotivosParadaId))
							: null);
			entity.setTagId((FacesUtils.checkLong(txtTagId) != null)
					? businessDelegatorView.getTag(FacesUtils.checkLong(txtTagId))
					: null);
			entity.setAreaTrabajoId((FacesUtils.checkLong(txtAreaTrabajoId) != null)
					? businessDelegatorView.getAreaTrabajo(FacesUtils.checkLong(txtAreaTrabajoId))
					: null);
			
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setFechapFinal(FacesUtils.checkDate(fechapFinal));
            entity.setFechapInicial(FacesUtils.checkDate(fechapInicial));
            entity.setHorapFinal(FacesUtils.checkDate(horapFinal));
            entity.setHorapInicial(FacesUtils.checkDate(horapInicial));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    observacionAnularReg));
            entity.setObservaciones(FacesUtils.checkString(observaciones));
            entity.setParadaCritica(FacesUtils.checkString(paradaCritica));
            businessDelegatorView.updateDatParadasFabrica(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatParadasFabricaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    
    /**
	 * @return the txtEquipoId
	 */
	public SelectOneMenu getTxtEquipoId() {
		return txtEquipoId;
	}

	/**
	 * @param txtEquipoId the txtEquipoId to set
	 */
	public void setTxtEquipoId(SelectOneMenu txtEquipoId) {
		this.txtEquipoId = txtEquipoId;
	}

	/**
	 * @return the txtTagId
	 */
	public SelectOneMenu getTxtTagId() {
		return txtTagId;
	}

	/**
	 * @param txtTagId the txtTagId to set
	 */
	public void setTxtTagId(SelectOneMenu txtTagId) {
		this.txtTagId = txtTagId;
	}

	/**
	 * @return the txtAgenteCausadorParadaId
	 */
	public SelectOneMenu getTxtAgenteCausadorParadaId() {
		return txtAgenteCausadorParadaId;
	}

	/**
	 * @param txtAgenteCausadorParadaId the txtAgenteCausadorParadaId to set
	 */
	public void setTxtAgenteCausadorParadaId(SelectOneMenu txtAgenteCausadorParadaId) {
		this.txtAgenteCausadorParadaId = txtAgenteCausadorParadaId;
	}

	/**
	 * @return the txtAreaTrabajoId
	 */
	public SelectOneMenu getTxtAreaTrabajoId() {
		return txtAreaTrabajoId;
	}

	/**
	 * @param txtAreaTrabajoId the txtAreaTrabajoId to set
	 */
	public void setTxtAreaTrabajoId(SelectOneMenu txtAreaTrabajoId) {
		this.txtAreaTrabajoId = txtAreaTrabajoId;
	}

	public InputText getTxtCompania() {
        return txtCompania;
    }

    public void setTxtCompania(InputText txtCompania) {
        this.txtCompania = txtCompania;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    

    public InputText getTxtObservacionAnularReg() {
        return txtObservacionAnularReg;
    }

    public void setTxtObservacionAnularReg(InputText txtObservacionAnularReg) {
        this.txtObservacionAnularReg = txtObservacionAnularReg;
    }

    public InputText getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setTxtObservaciones(InputText txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

   
    /**
	 * @return the txtDescripcionParada
	 */
	public InputTextarea getTxtDescripcionParada() {
		return txtDescripcionParada;
	}

	/**
	 * @param txtDescripcionParada the txtDescripcionParada to set
	 */
	public void setTxtDescripcionParada(InputTextarea txtDescripcionParada) {
		this.txtDescripcionParada = txtDescripcionParada;
	}

	/**
	 * @return the txtEstado
	 */
	public SelectOneRadio getTxtEstado() {
		return txtEstado;
	}

	/**
	 * @param txtEstado the txtEstado to set
	 */
	public void setTxtEstado(SelectOneRadio txtEstado) {
		this.txtEstado = txtEstado;
	}

	/**
	 * @return the txtParadaCritica
	 */
	public SelectOneMenu getTxtParadaCritica() {
		return txtParadaCritica;
	}

	/**
	 * @param txtParadaCritica the txtParadaCritica to set
	 */
	public void setTxtParadaCritica(SelectOneMenu txtParadaCritica) {
		this.txtParadaCritica = txtParadaCritica;
	}

	/**
	 * @return the txtMotivosParadaId
	 */
	public SelectOneMenu getTxtMotivosParadaId() {
		return txtMotivosParadaId;
	}

	/**
	 * @param txtMotivosParadaId the txtMotivosParadaId to set
	 */
	public void setTxtMotivosParadaId(SelectOneMenu txtMotivosParadaId) {
		this.txtMotivosParadaId = txtMotivosParadaId;
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

    public Calendar getTxtFechapFinal() {
        return txtFechapFinal;
    }

    public void setTxtFechapFinal(Calendar txtFechapFinal) {
        this.txtFechapFinal = txtFechapFinal;
    }

    public Calendar getTxtFechapInicial() {
        return txtFechapInicial;
    }

    public void setTxtFechapInicial(Calendar txtFechapInicial) {
        this.txtFechapInicial = txtFechapInicial;
    }

    public Calendar getTxtHorapFinal() {
        return txtHorapFinal;
    }

    public void setTxtHorapFinal(Calendar txtHorapFinal) {
        this.txtHorapFinal = txtHorapFinal;
    }

    public Calendar getTxtHorapInicial() {
        return txtHorapInicial;
    }

    public void setTxtHorapInicial(Calendar txtHorapInicial) {
        this.txtHorapInicial = txtHorapInicial;
    }

    public InputText getTxtDatParadasFabricaId() {
        return txtDatParadasFabricaId;
    }

    public void setTxtDatParadasFabricaId(InputText txtDatParadasFabricaId) {
        this.txtDatParadasFabricaId = txtDatParadasFabricaId;
    }

    public List<DatParadasFabricaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDatParadasFabrica();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatParadasFabricaDTO> datParadasFabricaDTO) {
        this.data = datParadasFabricaDTO;
    }

    public DatParadasFabricaDTO getSelectedDatParadasFabrica() {
        return selectedDatParadasFabrica;
    }

    public void setSelectedDatParadasFabrica(
        DatParadasFabricaDTO datParadasFabrica) {
        this.selectedDatParadasFabrica = datParadasFabrica;
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

			equipo = new ArrayList<Equipo>();

			try {

				//String modulo = txtOrigenDatos.getValue().toString();
				Object[] condicion = { "estado", true, "A", "=", "origenDatos",true,"Modulo_MttoIndustrial","=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(), equipo.getNombre());
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

	public SelectItem[] getselectTag() {

		if (tag == null || tag.size() == 0) {

			tag = new ArrayList<Tag>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<Tag> lista = businessDelegatorView.findByCriteriaInTag(condicion, null, null);
				selectTag = new SelectItem[lista.size()];

				int i = 0;
				for (Tag tag : lista) {
					selectTag[i] = new SelectItem(tag.getTagId(), tag.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTag;
	}

	public void setselectTag(SelectItem[] selectTag) {
		this.selectTag = selectTag;
	}

	public SelectItem[] getSelectMotivoEntradaTaller() {

		if (motivoEntradaTaller == null || motivoEntradaTaller.size() == 0) {

			motivoEntradaTaller = new ArrayList<MotivosEntradaTaller>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<MotivosEntradaTaller> lista = businessDelegatorView.findByCriteriaInMotivosEntradaTaller(condicion,
						null, null);
				selectMotivoEntradaTaller = new SelectItem[lista.size()];

				int i = 0;
				for (MotivosEntradaTaller motivoEntradaTaller : lista) {
					selectMotivoEntradaTaller[i] = new SelectItem(motivoEntradaTaller.getMotivosEntradaTallerId(),
							motivoEntradaTaller.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectMotivoEntradaTaller;
	}

	public void setselectMotivoEntradaTaller(SelectItem[] selectMotivoEntradaTaller) {
		this.selectMotivoEntradaTaller = selectMotivoEntradaTaller;
	}

	public SelectItem[] getSelectAgenteCausador() {

		if (agenteCausador == null || agenteCausador.size() == 0) {

			agenteCausador = new ArrayList<AgenteCausadorParada>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<AgenteCausadorParada> lista = businessDelegatorView.findByCriteriaInAgenteCausadorParada(condicion,
						null, null);
				selectAgenteCausador = new SelectItem[lista.size()];

				int i = 0;
				for (AgenteCausadorParada agenteCausador : lista) {
					selectAgenteCausador[i] = new SelectItem(agenteCausador.getAgenteCausadorParadaId(),
							agenteCausador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAgenteCausador;
	}

	public void setselectAgenteCausador(SelectItem[] selectAgenteCausador) {
		this.selectAgenteCausador = selectAgenteCausador;
	}
	

	public SelectItem[] getSelectAreaTrabajo() {

		if (area == null || area.size() == 0) {

			area = new ArrayList<AreaTrabajo>();

			try {

				Object[] condicion = { "estado", true, "A", "=" };
				List<AreaTrabajo> lista = businessDelegatorView.findByCriteriaInAreaTrabajo(condicion, null, null);
				selectAreaTrabajo = new SelectItem[lista.size()];

				int i = 0;
				for (AreaTrabajo valor : lista) {
					selectAreaTrabajo[i] = new SelectItem(valor.getAreaTrabajoId(), valor.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAreaTrabajo;
	}

	public void setSelectAreaTrabajo(SelectItem[] selectAreaTrabajo) {
		this.selectAreaTrabajo = selectAreaTrabajo;
	}

	public void listener_ConsultaTag() {

		Long equipoid = null;

		if (!txtEquipoId.getValue().equals("")) {
			equipoid = Long.parseLong(txtEquipoId.getValue().toString());

			try {
				Equipo equipoId = businessDelegatorView.getEquipo(equipoid);
				/* valNPass = datPlanLabor.getNPases(); */
				if(equipoId.getTagId()!=null){
					txtTagId.setValue(equipoId.getTagId().longValue());
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}
	}


}
