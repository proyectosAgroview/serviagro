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
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatReqProductos;
import co.com.arcosoft.modelo.DatReqProductosDet;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatReqProductosDTO;
import co.com.arcosoft.modelo.dto.DatReqProductosDetDTO;
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
public class DatReqProductosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatReqProductosView.class);
    private InputText txtCompania;
    private InputText txtConsecutivo;
    private InputText txtEstado;
    private InputTextarea txtObservacion;
    private InputText txtObservacionAnularReg;
    private InputText txtUsuarioDigitacion;
    private InputText txtDatReqProductosId;
    private Calendar txtFechaAnulacion;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private Calendar txtFechaRegistro;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatReqProductosDTO> data;
    private DatReqProductosDTO selectedDatReqProductos;
    private DatReqProductos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;
    private  List<DatReqProductosDetDTO> dataReq;
    
    private CommandButton btnAgregar;
    private InputNumber txtCantidadFaltante;
    private  InputNumber txtCantidadNormal;
    private InputNumber txtCantidadUrgente;
    private InputNumber txtSaldo;
    private SelectOneMenu txtUnidadMedida;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;
	
	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	SelectItem[] selectProducto2;
	private List<Producto> producto2;

    private DatReqProductosDetDTO selectedDatReqProductosDet;	
    private DatReqProductosDet entityReqProductosDet ;
    
    public DatReqProductosView() {
        super();
    }

     public void rowEventListener(RowEditEvent e) {
        try {
            DatReqProductosDTO datReqProductosDTO = (DatReqProductosDTO) e.getObject();

            if (txtCompania == null) {
                txtCompania = new InputText();
            }

            txtCompania.setValue(datReqProductosDTO.getCompania());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(datReqProductosDTO.getConsecutivo());

            if (txtEstado == null) {
                txtEstado = new InputText();
            }

            txtEstado.setValue(datReqProductosDTO.getEstado());

            if (txtObservacion == null) {
                txtObservacion = new InputTextarea();
            }

            txtObservacion.setValue(datReqProductosDTO.getObservacion());

            if (txtObservacionAnularReg == null) {
                txtObservacionAnularReg = new InputText();
            }

            txtObservacionAnularReg.setValue(datReqProductosDTO.getObservacionAnularReg());

            if (txtUsuarioDigitacion == null) {
                txtUsuarioDigitacion = new InputText();
            }

            txtUsuarioDigitacion.setValue(datReqProductosDTO.getUsuarioDigitacion());

            if (txtDatReqProductosId == null) {
                txtDatReqProductosId = new InputText();
            }

            txtDatReqProductosId.setValue(datReqProductosDTO.getDatReqProductosId());

            if (txtFechaAnulacion == null) {
                txtFechaAnulacion = new Calendar();
            }

            txtFechaAnulacion.setValue(datReqProductosDTO.getFechaAnulacion());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(datReqProductosDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(datReqProductosDTO.getFechaModificacion());

            if (txtFechaRegistro == null) {
                txtFechaRegistro = new Calendar();
            }

            txtFechaRegistro.setValue(datReqProductosDTO.getFechaRegistro());

            Long datReqProductosId = FacesUtils.checkLong(txtDatReqProductosId);
            entity = businessDelegator2View.getDatReqProductos(datReqProductosId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() throws Exception {
        action_clear();
        selectedDatReqProductos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() throws Exception {
        entity = null;
        selectedDatReqProductos = null;
		PrimeFaces.current().resetInputs(":frm");

        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtConsecutivo != null) {
        	Long compania = new Long(getCompaniaIdSession());
        	txtConsecutivo.setValue(businessDelegator2View.consec_req_productos(compania));
            txtConsecutivo.setDisabled(true);
        }        

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(true);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(false);
        }

        if (txtObservacionAnularReg != null) {
            txtObservacionAnularReg.setValue(null);
            txtObservacionAnularReg.setDisabled(true);
        }

        if (txtUsuarioDigitacion != null) {
            txtUsuarioDigitacion.setValue(null);
            txtUsuarioDigitacion.setDisabled(true);
        }

        if (txtFechaAnulacion != null) {
            txtFechaAnulacion.setValue(null);
            txtFechaAnulacion.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtFechaRegistro != null) {
        	Date date = new Date();
            txtFechaRegistro.setValue(date);
            txtFechaRegistro.setDisabled(false);
        }

        if (txtDatReqProductosId != null) {
            txtDatReqProductosId.setValue(null);
            txtDatReqProductosId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(false);
        }
        
        if (dataReq != null) {
        	dataReq =null;
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
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

    public void listener_txtFechaRegistro() {
        Date inputDate = (Date) txtFechaRegistro.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public String action_edit(ActionEvent evt) {
        selectedDatReqProductos = (DatReqProductosDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedDatReqProductos"));
       
        try {

			Long datReqProductosId = selectedDatReqProductos.getDatReqProductosId();
			Object[] condicion = { "datReqProductosId", true, datReqProductosId, "=" };
			List<DatReqProductos> lista = (datReqProductosId != null)
					? businessDelegator2View.findByCriteriaInDatReqProductos(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
		         txtConsecutivo.setValue(entity.getConsecutivo());
		        txtConsecutivo.setDisabled(true);
		         txtFechaRegistro.setValue(entity.getFechaRegistro());
		        txtFechaRegistro.setDisabled(false);
		        txtObservacion.setValue(entity.getObservacion());
		        txtObservacion.setDisabled(false);
		       
		        txtDatReqProductosId.setValue(entity.getDatReqProductosId());
		        txtDatReqProductosId.setDisabled(true);
		        
		        Long id = FacesUtils.checkLong(txtDatReqProductosId);

		        dataReq = null;
		        dataReq = businessDelegator2View.getDataDatReqProductosDetByProductos(id);
		        txtProductoId_Producto.setDisabled(false);
		        txtTipoProducto.setDisabled(false);
		        txtUnidadMedida.setDisabled(false);
		       // txtCantidadFaltante.setDisabled(false);
		        txtCantidadNormal.setDisabled(false);
		        txtCantidadUrgente.setDisabled(false);
		        txtSaldo.setDisabled(false);
		       
		       
		        btnAgregar.setDisabled(false);
		       
			
				
		        btnSave.setDisabled(false);
		        
    	setShowDialog(true);

			}
			}catch(
		
		Exception e)
		{
			entity = null;
		}return"";
		}

    public String action_save() {
        try {
            if ((selectedDatReqProductos == null) && (entity == null)) {
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

    /******** sesion de usuarios **/
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
            entity = new DatReqProductos();

           // Long datReqProductosId = FacesUtils.checkLong(txtDatReqProductosId);
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			entity.setFechaCreacion(date);
			
           
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
           // entity.setDatReqProductosId(datReqProductosId);
           
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
           
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            
            businessDelegator2View.saveDatReqProductos(entity,dataReq);
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
                Long datReqProductosId = new Long(selectedDatReqProductos.getDatReqProductosId());
                entity = businessDelegator2View.getDatReqProductos(datReqProductosId);
            }
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			entity.setEstado(estado);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setCompania(compania);
			
			
            
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
             entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
           
            entity.setFechaModificacion(date);
            entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
         
            businessDelegator2View.updateDatReqProductos(entity,dataReq);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
            action_clear();
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatReqProductos = (DatReqProductosDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedDatReqProductos"));

            Long datReqProductosId = new Long(selectedDatReqProductos.getDatReqProductosId());
            entity = businessDelegator2View.getDatReqProductos(datReqProductosId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datReqProductosId = FacesUtils.checkLong(txtDatReqProductosId);
            entity = businessDelegator2View.getDatReqProductos(datReqProductosId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteDatReqProductos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() throws Exception {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedDatReqProductos = (DatReqProductosDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedDatReqProductos"));

            Long datReqProductosId = new Long(selectedDatReqProductos.getDatReqProductosId());
            entity = businessDelegator2View.getDatReqProductos(datReqProductosId);
            businessDelegator2View.deleteDatReqProductos(entity);
            data.remove(selectedDatReqProductos);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long compania, Long consecutivo,
        Long datReqProductosId, String estado, Date fechaAnulacion,
        Date fechaCreacion, Date fechaModificacion, Date fechaRegistro,
        String observacion, String observacionAnularReg, Long usuarioDigitacion)
        throws Exception {
        try {
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    observacionAnularReg));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
            businessDelegator2View.updateDatReqProductos(entity,dataReq);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatReqProductosView").requestRender();
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

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputTextarea getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputTextarea txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public InputText getTxtObservacionAnularReg() {
        return txtObservacionAnularReg;
    }

    public void setTxtObservacionAnularReg(InputText txtObservacionAnularReg) {
        this.txtObservacionAnularReg = txtObservacionAnularReg;
    }

    public InputText getTxtUsuarioDigitacion() {
        return txtUsuarioDigitacion;
    }

    public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
        this.txtUsuarioDigitacion = txtUsuarioDigitacion;
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

    public Calendar getTxtFechaRegistro() {
        return txtFechaRegistro;
    }

    public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
        this.txtFechaRegistro = txtFechaRegistro;
    }

    public InputText getTxtDatReqProductosId() {
        return txtDatReqProductosId;
    }

    public void setTxtDatReqProductosId(InputText txtDatReqProductosId) {
        this.txtDatReqProductosId = txtDatReqProductosId;
    }

    public List<DatReqProductosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataDatReqProductos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatReqProductosDTO> datReqProductosDTO) {
        this.data = datReqProductosDTO;
    }

    public DatReqProductosDTO getSelectedDatReqProductos() {
        return selectedDatReqProductos;
    }

    public void setSelectedDatReqProductos(DatReqProductosDTO datReqProductos) {
        this.selectedDatReqProductos = datReqProductos;
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
    
    public SelectItem[] getSelectProducto2() {

		if (producto2 == null || producto2.size() == 0) {

			// producto2 = new ArrayList<Producto2>();

			try {

				producto2 = businessDelegatorView.getProducto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProducto2 = new SelectItem[lista.size()];

				int i = 0;
				for (Producto producto2 : lista) {
					selectProducto2[i] = new SelectItem(producto2.getProductoId(),
							producto2.getCodigo() + " - " + producto2.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProducto2;
	}

	public void setSelectProducto2(SelectItem[] selectProducto2) {
		this.selectProducto2 = selectProducto2;
	}

	public SelectItem[] getSelectTipoProducto() {

		if (tipoProducto == null || tipoProducto.size() == 0) {

			// tipoProducto = new ArrayList<TipoProducto>();

			try {

				tipoProducto = businessDelegatorView.getTipoProducto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<TipoProducto> lista = businessDelegatorView.findByCriteriaInTipoProducto(condicion, null, null);
				selectTipoProducto = new SelectItem[lista.size()];

				int i = 0;
				for (TipoProducto tipoProducto : lista) {
					selectTipoProducto[i] = new SelectItem(tipoProducto.getTipoProdId(),
							tipoProducto.getCodigo() + " - " + tipoProducto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTipoProducto;
	}

	public void setSelectTipoProducto(SelectItem[] selectTipoProducto) {
		this.selectTipoProducto = selectTipoProducto;
	}

	public SelectItem[] getSelectProductoId() {
		if (txtTipoProducto.getValue() != null) {
			//
			// if (productoId == null || productoId.size() == 0) {

			productoId = new ArrayList<Producto>();
			Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
			try {

				productoId = businessDelegatorView.getProducto(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=", "tipoProducto.tipoProdId", true, tipoProducto, "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectProductoId = new SelectItem[lista.size()];

				int i = 0;
				for (Producto productoId : lista) {
					selectProductoId[i] = new SelectItem(productoId.getProductoId(),
							productoId.getCodigo() + " - " + productoId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectProductoId;
	}

	public void setSelectProductoId(SelectItem[] selectProductoId) {
		this.selectProductoId = selectProductoId;
	}

	public DatReqProductos getEntity() {
		return entity;
	}

	public void setEntity(DatReqProductos entity) {
		this.entity = entity;
	}

	public List<DatReqProductosDetDTO> getDataReq() {
		return dataReq;
	}

	public void setDataReq(List<DatReqProductosDetDTO> dataReq) {
		this.dataReq = dataReq;
	}

	public CommandButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(CommandButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public InputNumber getTxtCantidadFaltante() {
		return txtCantidadFaltante;
	}

	public void setTxtCantidadFaltante(InputNumber txtCantidadFaltante) {
		this.txtCantidadFaltante = txtCantidadFaltante;
	}

	public InputNumber getTxtCantidadNormal() {
		return txtCantidadNormal;
	}

	public void setTxtCantidadNormal(InputNumber txtCantidadNormal) {
		this.txtCantidadNormal = txtCantidadNormal;
	}

	public InputNumber getTxtCantidadUrgente() {
		return txtCantidadUrgente;
	}

	public void setTxtCantidadUrgente(InputNumber txtCantidadUrgente) {
		this.txtCantidadUrgente = txtCantidadUrgente;
	}

	public InputNumber getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(InputNumber txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public SelectOneMenu getTxtUnidadMedida() {
		return txtUnidadMedida;
	}

	public void setTxtUnidadMedida(SelectOneMenu txtUnidadMedida) {
		this.txtUnidadMedida = txtUnidadMedida;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}

	public SelectOneMenu getTxtTipoProducto() {
		return txtTipoProducto;
	}

	public void setTxtTipoProducto(SelectOneMenu txtTipoProducto) {
		this.txtTipoProducto = txtTipoProducto;
	}
	
	


	public List<DatReqProductosDetDTO> getDataDetRe() {

		if (dataReq == null || dataReq.size() == 0) {
			return null;
		} else {
			return dataReq;
		}

	}
	public void action_agregarPrecioProductos() throws Exception {

		if ( txtUnidadMedida.getValue() != null 	&& txtProductoId_Producto.getValue() != null  &&
				txtCantidadNormal.getValue() != null 	&& txtCantidadUrgente.getValue() != null	 &&
						txtSaldo.getValue() != null
				) {
			Date date = new Date();
			Long unidadMedida = Long.parseLong(txtUnidadMedida.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(unidadMedida);

			Long productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			String codigoProducto = producto.getCodigo();
			String nomUnidadMed = udadMed.getNombre();

			SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));
			
			Long compania = new Long(getCompaniaIdSession());
			Double cantidadFaltante =0.0;//Double.parseDouble(txtCantidadFaltante.getValue().toString());
			Double cantidadNormal =Double.parseDouble(txtCantidadNormal.getValue().toString());
			Double cantidadUrgente =Double.parseDouble(txtCantidadUrgente.getValue().toString());
			Double saldo =Double.parseDouble(txtSaldo.getValue().toString());
			if(saldo !=null && cantidadUrgente!=null && cantidadNormal!=null ) {
				cantidadFaltante = (cantidadUrgente+cantidadNormal) - saldo;
			}
			
			boolean existeProducto = false;

			if (dataReq == null || dataReq.size() == 0) {
				dataReq = new ArrayList<DatReqProductosDetDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataReq.size() > 0) {

				for (DatReqProductosDetDTO d : dataReq) {

					if (d.getProductoId_Producto().getProductoId() == producto.getProductoId()
							) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"El producto seleccionado ya fue agregado a la grid " + d.getProductoId_Producto().getCodigo().toString()
												+ "Verifique el codigo del producto y su  unidad de médida asociada "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				DatReqProductosDetDTO dataDTO = new DatReqProductosDetDTO();
				dataDTO.setCantidadFaltante(cantidadFaltante);
				dataDTO.setCantidadNormal(cantidadNormal);
				dataDTO.setCantidadUrgente(cantidadUrgente);
				dataDTO.setCodigoProducto(codigoProducto);
				dataDTO.setSaldo(saldo);
				dataDTO.setNombreUdadMed(nomUnidadMed);
				dataDTO.setProductoId_Producto(producto);
				dataDTO.setUdadMedId_UdadMed(udadMed);
				
				
				dataReq.add(dataDTO);
				
			
			}
			cantidadFaltante =null;
			cantidadNormal=null;
			cantidadUrgente=null;
			codigoProducto=null;
			nomUnidadMed=null;
			saldo=null;
			producto=null;
			udadMed=null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha,  producto, bodega,  unidad de medida, proveedor, valor unitario, cantidad comprada tengan valores. "));
		}
	}
	
	public void listener_ConsultaUmProducto() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		Long productoId = null;
		Long almacenId = null;
		if (txtProductoId_Producto.getValue() !=null) {
			productoId = Long.parseLong(txtProductoId_Producto.getValue().toString());
			
			
			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtUnidadMedida.setValue(producto.getUdadMedByUdadMedProd().getUdadMedId());
				// txtCodProducto.setValue(producto.getNombre());
				Long udadMedId = Long.parseLong(txtUnidadMedida.getValue().toString());

				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				// txtCodUdadMedProd.setValue(udadMed.getNombre());
				Double saldoProducto = 0.0;
				saldoProducto =  businessDelegator2View.pr_saldo_total_producto(productoId,   compania).doubleValue() ;
				txtSaldo.setValue(saldoProducto);
				txtSaldo.setDisabled(true);
				txtUnidadMedida.setDisabled(true);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}


	public String actionDeleteDatReqProductosDet(ActionEvent evt) {
		try {

			selectedDatReqProductosDet = (DatReqProductosDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatReqProductosDet"));

			if (selectedDatReqProductosDet.getDatReqProductosDetId() == null) {
				dataReq.remove(selectedDatReqProductosDet);
			} else {
				Long id = new Long(selectedDatReqProductosDet.getDatReqProductosDetId());
				DatReqProductosDet entity = businessDelegator2View.getDatReqProductosDet(id);
				businessDelegator2View.deleteDatReqProductosDet(entity);
				dataReq.remove(selectedDatReqProductosDet);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public DatReqProductosDetDTO getSelectedDatReqProductosDet() {
		return selectedDatReqProductosDet;
	}

	public void setSelectedDatReqProductosDet(DatReqProductosDetDTO selectedDatReqProductosDet) {
		this.selectedDatReqProductosDet = selectedDatReqProductosDet;
	}
	

	public void onCellEditEventos(CellEditEvent evt) throws Exception {

		// caso 1 : la tabla transaccional no tiene valores

		selectedDatReqProductosDet = (DatReqProductosDetDTO) (evt.getComponent().getAttributes()
				.get("selectedDatReqProductosDet"));

		Long datReqProductosDetId = selectedDatReqProductosDet.getDatReqProductosDetId().longValue();
		
		String columnaCell = evt.getColumn().getHeaderText();

		Object oldValue = evt.getOldValue();
		Object newValue = evt.getNewValue();

		if (newValue != null) {

			entityReqProductosDet  = null;
			entityReqProductosDet  = businessDelegator2View.getDatReqProductosDet(datReqProductosDetId);

			
			

			if (columnaCell.equals("Prod.")) {

				Long productoId = new Long(evt.getNewValue().toString());
				Producto e = businessDelegatorView.getProducto(productoId);

				entityReqProductosDet .setProducto(e);

			}
			if (columnaCell.equals("U.M.")) {

				Long umId = new Long(evt.getNewValue().toString());
				UdadMed e = businessDelegatorView.getUdadMed(umId);

				entityReqProductosDet.setUdadMed(e);

			}

			if (columnaCell.equals("Req. Urgente")) {

				entityReqProductosDet.setCantidadUrgente(Double.valueOf(evt.getNewValue().toString()));

			}
			if (columnaCell.equals("Req. Normal")) {

				entityReqProductosDet.setCantidadNormal(Double.valueOf(evt.getNewValue().toString()));

			}

			if (columnaCell.equals("Faltante")) {

				entityReqProductosDet.setCantidadFaltante(Double.valueOf(evt.getNewValue().toString()));

			}

			if (columnaCell.equals("Saldo")) {

				entityReqProductosDet.setSaldo(Double.valueOf(evt.getNewValue().toString()));

			}
			
			businessDelegator2View.updateDatReqProductosDet(entityReqProductosDet );

			entityReqProductosDet  = null;
			selectedDatReqProductosDet = null;

		}

	}

	public DatReqProductosDet getEntityReqProductosDet() {
		return entityReqProductosDet;
	}

	public void setEntityReqProductosDet(DatReqProductosDet entityReqProductosDet) {
		this.entityReqProductosDet = entityReqProductosDet;
	}


	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			try {

				udadMed = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMed = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMed[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMed;
	}

	public void setSelectUdadMed(SelectItem[] selectUdadMed) {
		this.selectUdadMed = selectUdadMed;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
}
