package co.com.arcosoft.presentation.backingBeans;

import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.UbicacionesAlmacenDTO;
import co.com.arcosoft.presentation.businessDelegate.*;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectoneradio.SelectOneRadio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UbicacionesAlmacenView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UbicacionesAlmacenView.class);
    private InputText txtCodigo;
    private InputText txtCompania;
    private SelectOneRadio txtEstado;
    private InputTextarea txtInfoAdicional;
    private InputTextarea txtInfoAdicional2;
    private InputText txtNombre;
    private InputText txtUbicacionesAlmacen;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UbicacionesAlmacenDTO> data;
    private UbicacionesAlmacenDTO selectedUbicacionesAlmacen;
    private UbicacionesAlmacen entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;

    public UbicacionesAlmacenView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedUbicacionesAlmacen = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUbicacionesAlmacen = null;

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

        if (txtInfoAdicional != null) {
            txtInfoAdicional.setValue(null);
            txtInfoAdicional.setDisabled(true);
        }

        if (txtInfoAdicional2 != null) {
            txtInfoAdicional2.setValue(null);
            txtInfoAdicional2.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtUbicacionesAlmacen != null) {
            txtUbicacionesAlmacen.setValue(null);
            txtUbicacionesAlmacen.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtCodigo() {
    	try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<UbicacionesAlmacen> lista = (codigo != null)
					? businessDelegator2View.findByCriteriaInUbicacionesAlmacen(condicion, null, null) : null;
	
			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
			} else {
				FacesUtils.addInfoMessage( "Upps! El Código digitado no existe!, si deseas "
						+ "puedes crear un nuevo registro con el código: " + codigo);
			}

		} catch (Exception e) {
			entity = null;
		}

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtEstado.setDisabled(false);
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtInfoAdicional.setValue(entity.getInfoAdicional());
            txtInfoAdicional.setDisabled(false);
            txtInfoAdicional2.setValue(entity.getInfoAdicional2());
            txtInfoAdicional2.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUbicacionesAlmacen = (UbicacionesAlmacenDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedUbicacionesAlmacen"));
        txtCodigo.setValue(selectedUbicacionesAlmacen.getCodigo());
        txtCodigo.setDisabled(false);
        txtEstado.setValue(selectedUbicacionesAlmacen.getEstado());
        txtEstado.setDisabled(false);
        txtInfoAdicional.setValue(selectedUbicacionesAlmacen.getInfoAdicional());
        txtInfoAdicional.setDisabled(false);
        txtInfoAdicional2.setValue(selectedUbicacionesAlmacen.getInfoAdicional2());
        txtInfoAdicional2.setDisabled(false);
        txtNombre.setValue(selectedUbicacionesAlmacen.getNombre());
        txtNombre.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUbicacionesAlmacen == null) && (entity == null)) {
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
            entity = new UbicacionesAlmacen();
            
            Date date = new Date();

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCompania(Long.parseLong(getCompaniaIdSession()));
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaCreacion(date);
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            businessDelegator2View.saveUbicacionesAlmacen(entity);
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
                Long ubicacionesAlmacen = new Long(selectedUbicacionesAlmacen.getUbicacionesAlmacenId());
                entity = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacen);
            }
            
            Date date = new Date();

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCompania(Long.parseLong(getCompaniaIdSession()));
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaModificacion(date);
            entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            businessDelegator2View.updateUbicacionesAlmacen(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUbicacionesAlmacen = (UbicacionesAlmacenDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedUbicacionesAlmacen"));

            Long ubicacionesAlmacen = new Long(selectedUbicacionesAlmacen.getUbicacionesAlmacenId());
            entity = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacen);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long ubicacionesAlmacen = FacesUtils.checkLong(txtUbicacionesAlmacen);
            entity = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacen);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteUbicacionesAlmacen(entity);
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
            selectedUbicacionesAlmacen = (UbicacionesAlmacenDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedUbicacionesAlmacen"));

            Long ubicacionesAlmacen = new Long(selectedUbicacionesAlmacen.getUbicacionesAlmacenId());
            entity = businessDelegator2View.getUbicacionesAlmacen(ubicacionesAlmacen);
            businessDelegator2View.deleteUbicacionesAlmacen(entity);
            data.remove(selectedUbicacionesAlmacen);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Long compania,
        String estado, Date fechaCreacion, Date fechaModificacion,
        String infoAdicional, String infoAdicional2, String nombre,
        Long ubicacionesAlmacen) throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
            entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
            entity.setNombre(FacesUtils.checkString(nombre));
            businessDelegator2View.updateUbicacionesAlmacen(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UbicacionesAlmacenView").requestRender();
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

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
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

    public InputText getTxtUbicacionesAlmacen() {
        return txtUbicacionesAlmacen;
    }

    public void setTxtUbicacionesAlmacen(InputText txtUbicacionesAlmacen) {
        this.txtUbicacionesAlmacen = txtUbicacionesAlmacen;
    }

    public List<UbicacionesAlmacenDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataUbicacionesAlmacen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UbicacionesAlmacenDTO> ubicacionesAlmacenDTO) {
        this.data = ubicacionesAlmacenDTO;
    }

    public UbicacionesAlmacenDTO getSelectedUbicacionesAlmacen() {
        return selectedUbicacionesAlmacen;
    }

    public void setSelectedUbicacionesAlmacen(
        UbicacionesAlmacenDTO ubicacionesAlmacen) {
        this.selectedUbicacionesAlmacen = ubicacionesAlmacen;
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

    public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
