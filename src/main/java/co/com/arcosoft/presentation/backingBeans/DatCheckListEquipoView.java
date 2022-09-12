package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDetDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatCheckListEquipoView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DatCheckListEquipoView.class);
    private InputText txtCompania;
    private InputText txtConsecutivo;
    private SelectOneRadio txtEstado;
    private InputTextarea txtObservacion;
    private SelectOneMenu txtOrigenDatos;
    private InputText txtUsuarioDigitacion;
    private InputText txtDatCheckListEquipoId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private CommandButton btnAsignarLabores;
    private List<DatCheckListEquipoDTO> data;
    private DatCheckListEquipoDTO selectedDatCheckListEquipo;
    private DatCheckListEquipo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

    private SelectOneMenu txtSupervisorId;
    SelectItem[] selectSupervisor;

    private SelectOneMenu txtPlanRevisionEquipoId_PlanRevisionEquipo;
    SelectItem[] selectPlanRevision;
    
    /*** Detalle de check-list***/

	private DatCheckListEquipoDetDTO selectedDatCheckListEquipoDet;
	private List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet;	
	private DatCheckListEquipoDet entityDatCheckListEquipoDet;
	
	/*** Detalle de check-list***/
	
	/*** Detalle de check-list para labores***/
	
	private DatCheckListEquipoLaborDTO selectedDatCheckListEquipoLabor;
	private List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor;	
	private DatCheckListEquipoLabor entityDatCheckListEquipoLabor;
	
	private InputText txtDatCheckListDetId;
	
	/*** Detalle de check-list para labores***/

    public DatCheckListEquipoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedDatCheckListEquipo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatCheckListEquipo = null;
        PrimeFaces.current().resetInputs(":dialogDatCheckListEquipo");
        
        if (txtEstado != null) {
            txtEstado.setValue("A");
            txtEstado.setDisabled(true);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(false);
        }

        if (txtOrigenDatos != null) {
            txtOrigenDatos.setValue(null);
            txtOrigenDatos.setDisabled(true);
        }

        if (txtSupervisorId != null) {
            txtSupervisorId.setValue(null);
            txtSupervisorId.setDisabled(false);
        }

        if (txtUsuarioDigitacion != null) {
            txtUsuarioDigitacion.setValue(null);
            txtUsuarioDigitacion.setDisabled(false);
        }

        if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null) {
            txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(null);
            txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
        }

        if (txtDatCheckListEquipoId != null) {
            txtDatCheckListEquipoId.setValue(null);
            txtDatCheckListEquipoId.setDisabled(false);
        }
        
        if (dataDatCheckListEquipoDet != null) {
        	dataDatCheckListEquipoDet = null;
        }
        
        if (dataDatCheckListEquipoLabor != null) {
        	dataDatCheckListEquipoLabor = null;
        }
    
        btnAsignarLabores.setDisabled(true);

        return "";
    }

    public void listener_txtFechaCreacion() {
        Date inputDate = (Date) txtFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance().addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaModificacion() {
        Date inputDate = (Date) txtFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance().addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public String action_edit(ActionEvent evt) throws Exception {
    	
    	//action_clear();
    	
        selectedDatCheckListEquipo = (DatCheckListEquipoDTO) (evt.getComponent().getAttributes()
                                                                 .get("selectedDatCheckListEquipo"));

        txtEstado.setValue(selectedDatCheckListEquipo.getEstado());
        txtEstado.setDisabled(false);
        txtObservacion.setValue(selectedDatCheckListEquipo.getObservacion());
        txtObservacion.setDisabled(false);
        txtOrigenDatos.setValue(selectedDatCheckListEquipo.getOrigenDatos());
        txtOrigenDatos.setDisabled(false);
        txtSupervisorId.setValue(selectedDatCheckListEquipo.getSupervisorId());
        txtSupervisorId.setDisabled(false);
        txtPlanRevisionEquipoId_PlanRevisionEquipo.setValue(selectedDatCheckListEquipo.getPlanRevisionEquipoId_PlanRevisionEquipo());
        txtPlanRevisionEquipoId_PlanRevisionEquipo.setDisabled(false);
        
        Long datCheckListEquipoId = selectedDatCheckListEquipo.getDatCheckListEquipoId();
        
        if (datCheckListEquipoId != null) {
        	
        	dataDatCheckListEquipoDet = businessDelegator2View.getDataDatCheckListEquipoDetByCheckList(datCheckListEquipoId);
        }
        
        btnAsignarLabores.setDisabled(false);
        
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedDatCheckListEquipo == null) && (entity == null)) {
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
            entity = new DatCheckListEquipo();
            
            Long compania = Long.parseLong(getCompaniaIdSession());
            Date date = new Date();

            entity.setCompania(compania);
            entity.setConsecutivo(businessDelegatorView.consultarConsecutivoCheckListEquipo(compania));
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaCreacion(date);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
            entity.setSupervisorId(FacesUtils.checkLong(txtSupervisorId));
            entity.setUsuarioDigitacion(Long.parseLong(getUsuarioIdSession()));
            entity.setPlanRevisionEquipo((FacesUtils.checkLong(
                    txtPlanRevisionEquipoId_PlanRevisionEquipo) != null)
                ? businessDelegatorView.getPlanRevisionEquipo(
                    FacesUtils.checkLong(
                        txtPlanRevisionEquipoId_PlanRevisionEquipo)) : null);            
            businessDelegator2View.saveDatCheckListEquipo(entity, dataDatCheckListEquipoLabor, dataDatCheckListEquipoDet);
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
                Long datCheckListEquipoId = new Long(selectedDatCheckListEquipo.getDatCheckListEquipoId());
                entity = businessDelegator2View.getDatCheckListEquipo(datCheckListEquipoId);
            }
            
            Long compania = Long.parseLong(getCompaniaIdSession());
            Date date = new Date();

            entity.setCompania(compania);
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaModificacion(date);
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
            entity.setSupervisorId(FacesUtils.checkLong(txtSupervisorId));
            entity.setUsuarioDigitacion(Long.parseLong(getUsuarioIdSession()));
            entity.setPlanRevisionEquipo((FacesUtils.checkLong(
                    txtPlanRevisionEquipoId_PlanRevisionEquipo) != null)
                ? businessDelegatorView.getPlanRevisionEquipo(
                    FacesUtils.checkLong(
                        txtPlanRevisionEquipoId_PlanRevisionEquipo)) : null);
            businessDelegator2View.updateDatCheckListEquipo(entity, dataDatCheckListEquipoLabor, dataDatCheckListEquipoDet);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatCheckListEquipo = (DatCheckListEquipoDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedDatCheckListEquipo"));

            Long datCheckListEquipoId = new Long(selectedDatCheckListEquipo.getDatCheckListEquipoId());
            entity = businessDelegator2View.getDatCheckListEquipo(datCheckListEquipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datCheckListEquipoId = FacesUtils.checkLong(txtDatCheckListEquipoId);
            entity = businessDelegator2View.getDatCheckListEquipo(datCheckListEquipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteDatCheckListEquipo(entity);
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
            selectedDatCheckListEquipo = (DatCheckListEquipoDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedDatCheckListEquipo"));

            Long datCheckListEquipoId = new Long(selectedDatCheckListEquipo.getDatCheckListEquipoId());
            entity = businessDelegator2View.getDatCheckListEquipo(datCheckListEquipoId);
            businessDelegator2View.deleteDatCheckListEquipo(entity);
            data.remove(selectedDatCheckListEquipo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long compania, Long consecutivo,
        Long datCheckListEquipoId, String estado, Date fechaCreacion,
        Date fechaModificacion, String observacion, String origenDatos,
        Long supervisorId, Long usuarioDigitacion,
        Long planRevisionEquipoId_PlanRevisionEquipo) throws Exception {
        try {
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
            entity.setSupervisorId(FacesUtils.checkLong(supervisorId));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
            businessDelegator2View.updateDatCheckListEquipo(entity, dataDatCheckListEquipoLabor, dataDatCheckListEquipoDet);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatCheckListEquipoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
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
	
	public SelectItem[] getSelectSupervisor() {

		if (selectPlanRevision == null || selectSupervisor.length == 0) {
			
			try {
				
				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectSupervisor = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectSupervisor[i] = new SelectItem(trabajador.getTrabId(), trabajador.getCodigo() + " || " + trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectSupervisor;
	}

	public void setSelectSupervisor(SelectItem[] selectSupervisor) {
		this.selectSupervisor = selectSupervisor;
	}
	
	public SelectItem[] getSelectPlanRevision() {

		if (selectPlanRevision == null || selectPlanRevision.length == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "tipoProcedimiento", true, "Check-list", "=" };
				List<PlanRevisionEquipo> lista = businessDelegatorView.findByCriteriaInPlanRevisionEquipo(condicion, null, null);
				selectPlanRevision = new SelectItem[lista.size()];

				int i = 0;
				for (PlanRevisionEquipo planRevisionEquipo : lista) {
					selectPlanRevision[i] = new SelectItem(planRevisionEquipo.getPlanRevisionEquipoId(), planRevisionEquipo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectPlanRevision;
	}

	public void setSelectPlanRevision(SelectItem[] selectPlanRevision) {
		this.selectPlanRevision = selectPlanRevision;
	}
	
	public void agregarEquiposAsociados() throws Exception {
		
		dataDatCheckListEquipoDet = null;
		
		if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null && 
				txtPlanRevisionEquipoId_PlanRevisionEquipo.getValue() != null) {

			List<ListadoProximosMttoEquiposDTO> data = null;
			Long compania = Long.parseLong(getCompaniaIdSession());
			String planRevisionEquipoId = (String) txtPlanRevisionEquipoId_PlanRevisionEquipo.getValue();					
			
			data = businessDelegatorView.consultarListaProximosMttoEquipos(compania, "0",
					1L, planRevisionEquipoId, 0L, "Modulo_MttoIndustrial");
			
			if (data != null && data.size() > 0) {
				
				if (dataDatCheckListEquipoDet == null) {
					dataDatCheckListEquipoDet = new ArrayList<DatCheckListEquipoDetDTO>();
				}
				
				for (ListadoProximosMttoEquiposDTO data2 : data) {
					
					DatCheckListEquipoDetDTO datCheckListEquipoDetDTO = new DatCheckListEquipoDetDTO();
					
					datCheckListEquipoDetDTO.setEquipoId_Equipo(data2.getEquipo_id().longValue());
					datCheckListEquipoDetDTO.setNombreEquipo(data2.getNom_equipo());
					
					if (data2.getSistemas_equipo_id().longValue() != 0) {						

						datCheckListEquipoDetDTO.setSistemasEquipoId_SistemasEquipo(data2.getSistemas_equipo_id().longValue());
						datCheckListEquipoDetDTO.setNombreSistema(data2.getNombre_sistema_equipo());
					}
					
					if (data2.getCompartimientos_equipos_id().longValue() != 0) {						

						datCheckListEquipoDetDTO.setCompartimientosEquipoId_CompartimientosEquipo(
								data2.getCompartimientos_equipos_id().longValue());
						datCheckListEquipoDetDTO.setNombreSistema(data2.getNombre_compartimiento_equipo());
					}					
					
					String tipoMedidor = data2.getTipo_medidor();
					
					if (tipoMedidor.equals("dia")) {
						
						datCheckListEquipoDetDTO.setDiasHoy(data2.getHoro_odo_actual().doubleValue());
						
					} else if (tipoMedidor.equals("horometro")) {
						
						datCheckListEquipoDetDTO.setHorasHoy(data2.getHoro_odo_actual().doubleValue());
						
					} else if (tipoMedidor.equals("odometro")) {
						
						datCheckListEquipoDetDTO.setKmHoy(data2.getHoro_odo_actual().doubleValue());
					}
					
					dataDatCheckListEquipoDet.add(datCheckListEquipoDetDTO);
				}
			}
			
			data = null;
		}		
	}
	
	public void consultaLaboresPorEquipo(ActionEvent evt) throws Exception {
				
		selectedDatCheckListEquipoDet = (DatCheckListEquipoDetDTO) (evt.getComponent().getAttributes()
                .get("selectedDatCheckListEquipoDet"));

		txtDatCheckListDetId.setValue(selectedDatCheckListEquipoDet.getDatCheckListEquipoDetId());
			
		Long checkListEquipoId = selectedDatCheckListEquipoDet.getDatCheckListEquipoDetId();		
		dataDatCheckListEquipoLabor = businessDelegator2View.getDataDatCheckListEquipoLaborByEquipo(checkListEquipoId);
		
		/*boolean data =  dataDatCheckListEquipoLabor.isEmpty();

		if (data == true) {
			
			laboresPorEquipo(evt);					
		}*/	
	}
	
	/*public void laboresPorEquipo(ActionEvent evt) throws Exception {
		
		dataDatCheckListEquipoLabor = null;
		txtDatCheckListDetId.setValue(null);
		
		selectedDatCheckListEquipoDet = (DatCheckListEquipoDetDTO) (evt.getComponent().getAttributes()
                .get("selectedDatCheckListEquipoDet"));
		
		if (txtPlanRevisionEquipoId_PlanRevisionEquipo != null && 
				txtPlanRevisionEquipoId_PlanRevisionEquipo.getValue() != null) {

			txtDatCheckListDetId.setValue(selectedDatCheckListEquipoDet.getDatCheckListEquipoDetId());

			List<PlanRevisionEquipoActiv> data = null;
			String planRevisionEquipoId = (String) txtPlanRevisionEquipoId_PlanRevisionEquipo.getValue();	
			
			Object[] condicion = { "planRevisionEquipo", true, planRevisionEquipoId, "=" };
			data = businessDelegatorView.findByCriteriaInPlanRevisionEquipoActiv(condicion, null, null);
						
			if (data != null && data.size() > 0) {
				
				if (dataDatCheckListEquipoLabor == null) {
					dataDatCheckListEquipoLabor = new ArrayList<DatCheckListEquipoLaborDTO>();
				}
				
				for (PlanRevisionEquipoActiv data2 : data) {
					
					DatCheckListEquipoLaborDTO datCheckListEquipoLaborDTO = new DatCheckListEquipoLaborDTO();
					
					datCheckListEquipoLaborDTO.setLaborId_Labor(data2.getLabor().getLaborId());
					
					Labor labor = businessDelegatorView.getLabor(data2.getLabor().getLaborId());	
					datCheckListEquipoLaborDTO.setNombreLabor(labor.getNombre());
					
					datCheckListEquipoLaborDTO.setResultado("Ninguno");
					datCheckListEquipoLaborDTO.setObservacion("Ninguna");
					datCheckListEquipoLaborDTO.setDatCheckListEquipoDetId_DatCheckListEquipoDet(
							selectedDatCheckListEquipoDet.getDatCheckListEquipoDetId());
					
					dataDatCheckListEquipoLabor.add(datCheckListEquipoLaborDTO);
				}
			}
			
			data = null;
		}		
	}*/
	
	public void onCellEditLabor(CellEditEvent event) throws Exception {

		selectedDatCheckListEquipoLabor = (DatCheckListEquipoLaborDTO) (event.getComponent().getAttributes()
				.get("selectedDatCheckListEquipoLabor"));
		
		Long datCheckListEquipoId = FacesUtils.checkLong(txtDatCheckListDetId);
		Long datCheckListEquipoLaborId = selectedDatCheckListEquipoLabor.getDatCheckListEquipoLaborId().longValue();
		String columnaCell = event.getColumn().getHeaderText();

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {

			entityDatCheckListEquipoLabor = businessDelegator2View.getDatCheckListEquipoLabor(datCheckListEquipoLaborId);

			if (columnaCell.equals("Resultado")) {

				entityDatCheckListEquipoLabor.setResultado((String) newValue);

			} else if (columnaCell.equals("Observación")) {

				entityDatCheckListEquipoLabor.setObservacion((String) newValue);
			}			
			
			entityDatCheckListEquipoDet = businessDelegator2View.getDatCheckListEquipoDet(datCheckListEquipoId);
			entityDatCheckListEquipoLabor.setDatCheckListEquipoDet(entityDatCheckListEquipoDet);
			businessDelegator2View.updateDatCheckListEquipoLabor(entityDatCheckListEquipoLabor);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			dataDatCheckListEquipoLabor = null;
			entityDatCheckListEquipoLabor = null;
			selectedDatCheckListEquipoLabor = null;

			dataDatCheckListEquipoLabor = businessDelegator2View.getDataDatCheckListEquipoLaborByEquipo(datCheckListEquipoId);
		}
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

    public SelectOneRadio getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(SelectOneRadio txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputTextarea getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputTextarea txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public SelectOneMenu getTxtOrigenDatos() {
        return txtOrigenDatos;
    }

    public void setTxtOrigenDatos(SelectOneMenu txtOrigenDatos) {
        this.txtOrigenDatos = txtOrigenDatos;
    }

    public SelectOneMenu getTxtSupervisorId() {
        return txtSupervisorId;
    }

    public void setTxtSupervisorId(SelectOneMenu txtSupervisorId) {
        this.txtSupervisorId = txtSupervisorId;
    }

    public InputText getTxtUsuarioDigitacion() {
        return txtUsuarioDigitacion;
    }

    public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
        this.txtUsuarioDigitacion = txtUsuarioDigitacion;
    }

    public SelectOneMenu getTxtPlanRevisionEquipoId_PlanRevisionEquipo() {
        return txtPlanRevisionEquipoId_PlanRevisionEquipo;
    }

    public void setTxtPlanRevisionEquipoId_PlanRevisionEquipo(
    		SelectOneMenu txtPlanRevisionEquipoId_PlanRevisionEquipo) {
        this.txtPlanRevisionEquipoId_PlanRevisionEquipo = txtPlanRevisionEquipoId_PlanRevisionEquipo;
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

    public InputText getTxtDatCheckListEquipoId() {
        return txtDatCheckListEquipoId;
    }

    public void setTxtDatCheckListEquipoId(InputText txtDatCheckListEquipoId) {
        this.txtDatCheckListEquipoId = txtDatCheckListEquipoId;
    }

    public List<DatCheckListEquipoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataDatCheckListEquipo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatCheckListEquipoDTO> datCheckListEquipoDTO) {
        this.data = datCheckListEquipoDTO;
    }

    public DatCheckListEquipoDTO getSelectedDatCheckListEquipo() {
        return selectedDatCheckListEquipo;
    }

    public void setSelectedDatCheckListEquipo(
        DatCheckListEquipoDTO datCheckListEquipo) {
        this.selectedDatCheckListEquipo = datCheckListEquipo;
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

	public void setDataDatCheckListEquipoDet(List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet) {
		this.dataDatCheckListEquipoDet = dataDatCheckListEquipoDet;
	}

	public InputText getTxtDatCheckListDetId() {
		return txtDatCheckListDetId;
	}

	public void setTxtDatCheckListDetId(InputText txtDatCheckListDetId) {
		this.txtDatCheckListDetId = txtDatCheckListDetId;
	}

	public CommandButton getBtnAsignarLabores() {
		return btnAsignarLabores;
	}

	public void setBtnAsignarLabores(CommandButton btnAsignarLabores) {
		this.btnAsignarLabores = btnAsignarLabores;
	}

	public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLabor() {
		return dataDatCheckListEquipoLabor;
	}

	public void setDataDatCheckListEquipoLabor(List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor) {
		this.dataDatCheckListEquipoLabor = dataDatCheckListEquipoLabor;
	}

	public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDet() {
		return dataDatCheckListEquipoDet;
	}
}
