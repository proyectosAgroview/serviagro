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
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.ZonasFabrica;
import co.com.arcosoft.modelo.dto.TagDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TagView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TagView.class);
    private InputText txtCodigo;
    private InputText txtCompania;
    private SelectOneRadio txtEstado;
    private InputTextarea txtFuncion;
    private InputTextarea txtInfoAdicional;
    private InputTextarea txtInfoAdicional2;
    private InputTextarea txtNombre;
    private SelectOneMenu txtNivelPrioridad;
    private InputText txtTagId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TagDTO> data;
    private TagDTO selectedTag;
    private Tag entity;
    
    private SelectOneMenu txtResponsable;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

    
    private SelectOneMenu txtZonasFabricaId;
	SelectItem[] selectZonasFabrica;
	private List<ZonasFabrica> zonasFabrica;

	
    
    private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

    
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TagView() {
        super();
    }


    public String action_new() {
        action_clear();
        selectedTag = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTag = null;
        PrimeFaces.current().resetInputs(":dialogTag :frm");

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(false);
        }

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtEstado != null) {
            txtEstado.setValue("A");
            txtEstado.setDisabled(true);
        }

        if (txtFuncion != null) {
            txtFuncion.setValue(null);
            txtFuncion.setDisabled(true);
        }

        if (txtInfoAdicional != null) {
            txtInfoAdicional.setValue(null);
            txtInfoAdicional.setDisabled(true);
        }

        if (txtInfoAdicional2 != null) {
            txtInfoAdicional2.setValue(null);
            txtInfoAdicional2.setDisabled(true);
        }

        if (txtNivelPrioridad != null) {
            txtNivelPrioridad.setValue(null);
            txtNivelPrioridad.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtResponsable != null) {
            txtResponsable.setValue(null);
            txtResponsable.setDisabled(true);
        }

        if (txtZonasFabricaId != null) {
            txtZonasFabricaId.setValue(null);
            txtZonasFabricaId.setDisabled(true);
        }

        if (txtCentCostId_CentCost != null) {
            txtCentCostId_CentCost.setValue(null);
            txtCentCostId_CentCost.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtTagId != null) {
            txtTagId.setValue(null);
            txtTagId.setDisabled(false);
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

    public void listener_txtId() {
        try {
            Long tagId = FacesUtils.checkLong(txtTagId);
            entity = (tagId != null) ? businessDelegatorView.getTag(tagId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtCompania.setDisabled(false);
            txtEstado.setDisabled(false);
            txtFuncion.setDisabled(false);
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtNivelPrioridad.setDisabled(false);
            txtNombre.setDisabled(false);
            txtResponsable.setDisabled(false);
            txtZonasFabricaId.setDisabled(false);
            txtCentCostId_CentCost.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtTagId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtCompania.setValue(entity.getCompania());
            txtCompania.setDisabled(false);
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtFuncion.setValue(entity.getFuncion());
            txtFuncion.setDisabled(false);
            txtInfoAdicional.setValue(entity.getInfoAdicional());
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtNivelPrioridad.setValue(entity.getNivelPrioridad());
            txtNivelPrioridad.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtResponsable.setValue(entity.getResponsable());
            txtResponsable.setDisabled(false);
            txtZonasFabricaId.setValue(entity.getZonasFabricaId());
            txtZonasFabricaId.setDisabled(false);
            txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
            txtCentCostId_CentCost.setDisabled(false);
            txtTagId.setValue(entity.getTagId());
            txtTagId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    
    public void listener_txtCodigo() {
    	try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Tag> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTag(condicion, null, null) : null;

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
            txtCodigo.setDisabled(false);
          //  txtCompania.setDisabled(false);
            txtEstado.setDisabled(false);
            txtFuncion.setDisabled(false);
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtNivelPrioridad.setDisabled(false);
            txtNombre.setDisabled(false);
            txtResponsable.setDisabled(false);
            txtZonasFabricaId.setDisabled(false);
            txtCentCostId_CentCost.setDisabled(false);
            txtTagId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtFuncion.setValue(entity.getFuncion());
            txtFuncion.setDisabled(false);
            txtInfoAdicional.setValue(entity.getInfoAdicional());
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtNivelPrioridad.setValue(entity.getNivelPrioridad());
            txtNivelPrioridad.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtResponsable.setValue(entity.getResponsable());
            txtResponsable.setDisabled(false);
            txtZonasFabricaId.setValue(entity.getZonasFabricaId());
            txtZonasFabricaId.setDisabled(false);
            txtCentCostId_CentCost.setValue(entity.getCentCost().getCentCostId());
            txtCentCostId_CentCost.setDisabled(false);
            txtTagId.setValue(entity.getTagId());
            txtTagId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTag = (TagDTO) (evt.getComponent().getAttributes()
                                   .get("selectedTag"));
       
        try {

			String codigo = selectedTag.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Tag> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTag(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

        txtCodigo.setValue(entity.getCodigo());
        txtCodigo.setDisabled(false);
        txtEstado.setValue(entity.getEstado());
        txtEstado.setDisabled(false);
        txtFuncion.setValue(entity.getFuncion());
        txtFuncion.setDisabled(false);
        txtInfoAdicional.setValue(entity.getInfoAdicional());
        txtInfoAdicional.setDisabled(false);
        txtInfoAdicional2.setValue(entity.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtNivelPrioridad.setValue(entity.getNivelPrioridad());
        txtNivelPrioridad.setDisabled(false);
        txtNombre.setValue(entity.getNombre());
        txtNombre.setDisabled(false);
        txtResponsable.setValue(entity.getResponsable());
        txtResponsable.setDisabled(false);
        txtZonasFabricaId.setValue(entity.getZonasFabricaId());
        txtZonasFabricaId.setDisabled(false);
        txtCentCostId_CentCost.setValue(selectedTag.getCentCostId_CentCost());
        txtCentCostId_CentCost.setDisabled(false);
        txtTagId.setValue(entity.getTagId());
        txtTagId.setDisabled(true);
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
            if ((selectedTag == null) && (entity == null)) {
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

    public String action_create() {
        try {
            entity = new Tag();

            //Long tagId = FacesUtils.checkLong(txtTagId);
        	Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			entity.setEstado("A");
			entity.setFechaCreacion(date);
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setFuncion(FacesUtils.checkString(txtFuncion));
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNivelPrioridad(FacesUtils.checkString(txtNivelPrioridad));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setResponsable(FacesUtils.checkLong(txtResponsable));
            //entity.setTagId(tagId);
            entity.setZonasFabricaId(FacesUtils.checkLong(txtZonasFabricaId));
            entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
                ? businessDelegatorView.getCentCost(FacesUtils.checkLong(
                        txtCentCostId_CentCost)) : null);
            businessDelegatorView.saveTag(entity);
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
                Long tagId = new Long(selectedTag.getTagId());
                entity = businessDelegatorView.getTag(tagId);
            }
            Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setCompania(compania);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(date);
            entity.setFuncion(FacesUtils.checkString(txtFuncion));
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNivelPrioridad(FacesUtils.checkString(txtNivelPrioridad));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setResponsable(FacesUtils.checkLong(txtResponsable));
            entity.setZonasFabricaId(FacesUtils.checkLong(txtZonasFabricaId));
            entity.setCentCost((FacesUtils.checkLong(txtCentCostId_CentCost) != null)
                ? businessDelegatorView.getCentCost(FacesUtils.checkLong(
                        txtCentCostId_CentCost)) : null);
            businessDelegatorView.updateTag(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTag = (TagDTO) (evt.getComponent().getAttributes()
                                       .get("selectedTag"));

            Long tagId = new Long(selectedTag.getTagId());
            entity = businessDelegatorView.getTag(tagId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long tagId = FacesUtils.checkLong(txtTagId);
            entity = businessDelegatorView.getTag(tagId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTag(entity);
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
            selectedTag = (TagDTO) (evt.getComponent().getAttributes()
                                       .get("selectedTag"));

            Long tagId = new Long(selectedTag.getTagId());
            entity = businessDelegatorView.getTag(tagId);
            businessDelegatorView.deleteTag(entity);
            data.remove(selectedTag);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Long compania,
        String estado, Date fechaCreacion, Date fechaModificacion,
        String funcion, String infoAdicional, String infoAdicional2,
        String nivelPrioridad, String nombre, Long responsable, Long tagId,
        Long zonasFabricaId, Long centCostId_CentCost)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setFuncion(FacesUtils.checkString(funcion));
            entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setNivelPrioridad(FacesUtils.checkString(nivelPrioridad));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setResponsable(FacesUtils.checkLong(responsable));
            entity.setZonasFabricaId(FacesUtils.checkLong(zonasFabricaId));
            businessDelegatorView.updateTag(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TagView").requestRender();
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

    public SelectOneRadio getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(SelectOneRadio txtEstado) {
        this.txtEstado = txtEstado;
    }


    public InputTextarea getTxtFuncion() {
		return txtFuncion;
	}


	public void setTxtFuncion(InputTextarea txtFuncion) {
		this.txtFuncion = txtFuncion;
	}


	public InputTextarea getTxtInfoAdicional() {
		return txtInfoAdicional;
	}


	public void setTxtInfoAdicional(InputTextarea txtInfoAdicional) {
		this.txtInfoAdicional = txtInfoAdicional;
	}


	public InputTextarea getTxtInfoAdicional2() {
		return txtInfoAdicional2;
	}


	public void setTxtInfoAdicional2(InputTextarea txtInfoAdicional2) {
		this.txtInfoAdicional2 = txtInfoAdicional2;
	}


	public InputTextarea getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(InputTextarea txtNombre) {
		this.txtNombre = txtNombre;
	}


	public SelectOneMenu getTxtNivelPrioridad() {
		return txtNivelPrioridad;
	}


	public void setTxtNivelPrioridad(SelectOneMenu txtNivelPrioridad) {
		this.txtNivelPrioridad = txtNivelPrioridad;
	}


	public SelectOneMenu getTxtResponsable() {
		return txtResponsable;
	}


	public void setTxtResponsable(SelectOneMenu txtResponsable) {
		this.txtResponsable = txtResponsable;
	}


	public SelectOneMenu getTxtZonasFabricaId() {
		return txtZonasFabricaId;
	}


	public void setTxtZonasFabricaId(SelectOneMenu txtZonasFabricaId) {
		this.txtZonasFabricaId = txtZonasFabricaId;
	}


	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}


	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
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

    public InputText getTxtTagId() {
        return txtTagId;
    }

    public void setTxtTagId(InputText txtTagId) {
        this.txtTagId = txtTagId;
    }

    public List<TagDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTag();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TagDTO> tagDTO) {
        this.data = tagDTO;
    }

    public TagDTO getSelectedTag() {
        return selectedTag;
    }

    public void setSelectedTag(TagDTO tag) {
        this.selectedTag = tag;
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
    
	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			trabajador = new ArrayList<Trabajador>();

			try {

				trabajador = businessDelegatorView.getTrabajador(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajador[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajador;
	}

	public void setselectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getselectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			centCost = new ArrayList<CentCost>();

			try {

				centCost = businessDelegatorView.getCentCost(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCost = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCost[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCost;
	}

	public void setselectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}
	
	public SelectItem[] getselectZonasFabrica() {

		if (zonasFabrica == null || zonasFabrica.size() == 0) {

			zonasFabrica = new ArrayList<ZonasFabrica>();

			try {

				zonasFabrica = businessDelegatorView.getZonasFabrica(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ZonasFabrica> lista = businessDelegatorView.findByCriteriaInZonasFabrica(condicion, null, null);
				selectZonasFabrica = new SelectItem[lista.size()];

				int i = 0;
				for (ZonasFabrica zonasFabrica : lista) {
					selectZonasFabrica[i] = new SelectItem(zonasFabrica.getZonasFabricaId(), zonasFabrica.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectZonasFabrica;
	}

	public void setselectZonasFabrica(SelectItem[] selectZonasFabrica) {
		this.selectZonasFabrica = selectZonasFabrica;
	}

	
}
