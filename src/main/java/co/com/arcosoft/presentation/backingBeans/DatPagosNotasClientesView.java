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
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatFacturaServicios;
import co.com.arcosoft.modelo.DatPagosNotasClientes;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatPagosNotasClientesDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosDTO;
import co.com.arcosoft.modelo.informes.dto.PagosNotasClientesDTO;
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
public class DatPagosNotasClientesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatPagosNotasClientesView.class);
    private InputText txtCompania;
    private InputText txtConsecutivo;
    private InputTextarea txtDetalleNota;
    private SelectOneRadio txtEstado;
    private SelectOneMenu txtFormaPago;
    private InputText txtNumFactura;
    private InputTextarea txtObservacion;
    private InputTextarea txtObservacionAnularReg;
    private InputText txtUsuarioDigitacion;
    private InputNumber txtValorNota;
    private InputText txtValorCredito;
    private InputText txtValorDebito;
    private SelectOneMenu txtPersEmprId_PersEmpr;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

    private InputText txtDatPagosNotasClientesId;
    private Calendar txtFechaAnulacion;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private Calendar txtFechaRegistro;
    private Calendar txtFechaVencimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatPagosNotasClientesDTO> data;
    private DatPagosNotasClientesDTO selectedDatPagosNotasClientes;
    private DatPagosNotasClientes entity;
    private DatFacturaServicios entityFactura;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;    

    @ManagedProperty(value = "#{BusinessDelegator2View}")
    private IBusinessDelegator2View businessDelegator2View;
    private int activeTapIndex = 0;
    private Calendar txtFechaFactura;
    
    private InputNumber txtSaldoFactura;
    private List<FacturaServiciosConsolidadosDTO> dataSaldoFactura;
	private List<PagosNotasClientesDTO>  data2;
	private Calendar txtFechaIni;
	private Calendar txtFechaFin;
    private PagosNotasClientesDTO selectedDatPagosNotasClientes2;
	
    public DatPagosNotasClientesView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedDatPagosNotasClientes = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatPagosNotasClientes = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;
        if (txtCompania != null) {
            txtCompania.setValue(null);
            txtCompania.setDisabled(true);
        }

        if (txtConsecutivo != null) {
            txtConsecutivo.setValue(null);
            txtConsecutivo.setDisabled(true);
        }

        if (txtDetalleNota != null) {
            txtDetalleNota.setValue(null);
            txtDetalleNota.setDisabled(false);
        }

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(false);
        }

        if (txtFormaPago != null) {
            txtFormaPago.setValue(null);
            txtFormaPago.setDisabled(false);
        }

        if (txtNumFactura != null) {
            txtNumFactura.setValue(null);
            txtNumFactura.setDisabled(false);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(false);
        }

        if (txtObservacionAnularReg != null) {
            txtObservacionAnularReg.setValue(null);
            txtObservacionAnularReg.setDisabled(false);
        }

        if (txtUsuarioDigitacion != null) {
            txtUsuarioDigitacion.setValue(null);
            txtUsuarioDigitacion.setDisabled(false);
        }

        if (txtValorCredito != null) {
            txtValorCredito.setValue(null);
            txtValorCredito.setDisabled(false);
        }

        if (txtValorDebito != null) {
            txtValorDebito.setValue(null);
            txtValorDebito.setDisabled(false);
        }

        if (txtPersEmprId_PersEmpr != null) {
            txtPersEmprId_PersEmpr.setValue(null);
            txtPersEmprId_PersEmpr.setDisabled(false);
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

        if (txtFechaRegistro != null) {
        	Date date= new Date();
            txtFechaRegistro.setValue(date);
            txtFechaRegistro.setDisabled(false);
        }


        if (txtFechaFactura != null) {
        	txtFechaFactura.setValue(null);
        	txtFechaFactura.setDisabled(false);
        }
        if (txtFechaVencimiento != null) {
        	Date date = new Date();
            txtFechaVencimiento.setValue(date);
            txtFechaVencimiento.setDisabled(false);
        }

        if (txtDatPagosNotasClientesId != null) {
            txtDatPagosNotasClientesId.setValue(null);
            txtDatPagosNotasClientesId.setDisabled(false);
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

    public void listener_txtFechaRegistro() {
        Date inputDate = (Date) txtFechaRegistro.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaVencimiento() {
        Date inputDate = (Date) txtFechaVencimiento.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public String action_edit(ActionEvent evt) {
    	selectedDatPagosNotasClientes2 = (PagosNotasClientesDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedDatPagosNotasClientes2"));
        
		try {

			Long datPagosNotasClientesId = selectedDatPagosNotasClientes2.getDat_pagos_notas_clientes_id().longValue();
			Object[] condicion = { "datPagosNotasClientesId", true, datPagosNotasClientesId, "=" };
			List<DatPagosNotasClientes> lista = (datPagosNotasClientesId != null)
					? businessDelegator2View.findByCriteriaInDatPagosNotasClientes(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
		        //txtConsecutivo.setValue(entity.getConsecutivo());
		        //txtConsecutivo.setDisabled(false);
				
				txtDetalleNota.setValue(entity.getDetalleNota());
		        txtDetalleNota.setDisabled(false);
		        
		        txtFechaRegistro.setValue(entity.getFechaRegistro());
		        txtFechaRegistro.setDisabled(false);
		        
		        txtFechaVencimiento.setValue(entity.getFechaVencimiento());
		        txtFechaVencimiento.setDisabled(false);
		        txtFormaPago.setValue(entity.getFormaPago());
		        txtFormaPago.setDisabled(false);
		        txtNumFactura.setValue(entity.getNumFactura());
		        txtNumFactura.setDisabled(false);
		        //txtObservacion.setValue(entity.getObservacion());
		        //txtObservacion.setDisabled(false);
		     
		        if(entity.getFormaPago() != null){
	            	if(entity.getFormaPago().equals("Recaudo")){
		            	txtValorNota.setValue(entity.getValorCredito());;
		            	
		            }
	            	if(entity.getFormaPago().equals("Nota credito")){
	            		txtValorNota.setValue(entity.getValorCredito());;
	            	}
	            	if(entity.getFormaPago().equals("Nota debito")){
	            		txtValorNota.setValue(entity.getValorDebito());;
		            }
	            }
		        txtValorNota.setDisabled(false);
		        
		        txtPersEmprId_PersEmpr.setValue(entity.getPersEmpr().getPersEmprId());
		        txtPersEmprId_PersEmpr.setDisabled(false);
		        txtDatPagosNotasClientesId.setValue(entity.getDatPagosNotasClientesId());
		        txtDatPagosNotasClientesId.setDisabled(true);
		        btnSave.setDisabled(false);
		    
		    	String numFactura = entity.getNumFactura();
				Object[] condicion1 = { "numFactura", true, numFactura, "=" };
				List<DatFacturaServicios> lista1 = (numFactura != null)
						? businessDelegator2View.findByCriteriaInDatFacturaServicios(condicion1, null, null) : null;

				if (lista != null && lista.size() > 0) {
					entityFactura = lista1.get(0);
					
		            txtFechaFactura.setValue(entityFactura.getFechaRegistro());
		            txtFechaFactura.setDisabled(false);
		        } 	 else
					FacesUtils.addInfoMessage(
							"Upps! El Número de factura  digitado no existe!"
									+ numFactura);	        
		        
		        setShowDialog(true);
		        activeTapIndex = 0;
			
			}
		} catch (Exception e) {
			entity = null;
		}
		return "";
	}

    public String action_save() {
        try {
            if ((selectedDatPagosNotasClientes == null) && (entity == null)) {
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
            entity = new DatPagosNotasClientes();

            //Long datPagosNotasClientesId = FacesUtils.checkLong(txtDatPagosNotasClientesId);
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

            entity.setCompania(compania);
            entity.setConsecutivo(businessDelegator2View.consultarConsecutivoPagoNotasClientes(compania));
            //entity.setDatPagosNotasClientesId(datPagosNotasClientesId);
            entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
            entity.setEstado(estado);
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechaCreacion(date);
           // entity.setFechaModificacion(FacesUtils.checkDate(
            //        txtFechaModificacion));
            entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
            entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
            entity.setFormaPago(FacesUtils.checkString(txtFormaPago));
            entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setUsuarioDigitacion(usuarioId);
            
            if(txtFormaPago.getValue() != null){
            	if(txtFormaPago.getValue().equals("Recaudo")){
	            	entity.setValorCredito(FacesUtils.checkDouble(txtValorNota));
	            	entity.setValorDebito(0.0);
	            }
            	if(txtFormaPago.getValue().equals("Nota credito")){
            		entity.setValorCredito(FacesUtils.checkDouble(txtValorNota));
	            	entity.setValorDebito(0.0);
	            
            	}
            	if(txtFormaPago.getValue().equals("Nota debito")){
	            	entity.setValorCredito(0.0);
	            	entity.setValorDebito(FacesUtils.checkDouble(txtValorNota));
	            }
            }
            entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
                ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
                        txtPersEmprId_PersEmpr)) : null);
            businessDelegator2View.saveDatPagosNotasClientes(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED  + "Número consecutivo: "
					+ (businessDelegator2View.consultarConsecutivoPagoNotasClientes(compania) - 1));
            ;
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
                Long datPagosNotasClientesId = new Long(selectedDatPagosNotasClientes.getDatPagosNotasClientesId());
                entity = businessDelegator2View.getDatPagosNotasClientes(datPagosNotasClientesId);
            }
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
//			String estado = "A";

            entity.setCompania(compania);
            //entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setDetalleNota(FacesUtils.checkString(txtDetalleNota));
            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
           // entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(date);
            entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
            entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
            entity.setFormaPago(FacesUtils.checkString(txtFormaPago));
            entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setUsuarioDigitacion(usuarioId);
            if(txtFormaPago.getValue() != null){
            	if(txtFormaPago.getValue().equals("Recaudo")){
	            	entity.setValorCredito(FacesUtils.checkDouble(txtValorNota));
	            	entity.setValorDebito(0.0);
	            }
            	if(txtFormaPago.getValue().equals("Nota credito")){
            		entity.setValorCredito(FacesUtils.checkDouble(txtValorNota));
	            	entity.setValorDebito(0.0);
	            
            	}
            	if(txtFormaPago.getValue().equals("Nota debito")){
	            	entity.setValorCredito(0.0);
	            	entity.setValorDebito(FacesUtils.checkDouble(txtValorNota));
	            }
            }
            entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId_PersEmpr) != null)
                ? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(
                        txtPersEmprId_PersEmpr)) : null);
            businessDelegator2View.updateDatPagosNotasClientes(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatPagosNotasClientes = (DatPagosNotasClientesDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedDatPagosNotasClientes"));

            Long datPagosNotasClientesId = new Long(selectedDatPagosNotasClientes.getDatPagosNotasClientesId());
            entity = businessDelegator2View.getDatPagosNotasClientes(datPagosNotasClientesId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long datPagosNotasClientesId = FacesUtils.checkLong(txtDatPagosNotasClientesId);
            entity = businessDelegator2View.getDatPagosNotasClientes(datPagosNotasClientesId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegator2View.deleteDatPagosNotasClientes(entity);
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
            selectedDatPagosNotasClientes = (DatPagosNotasClientesDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedDatPagosNotasClientes"));

            Long datPagosNotasClientesId = new Long(selectedDatPagosNotasClientes.getDatPagosNotasClientesId());
            entity = businessDelegator2View.getDatPagosNotasClientes(datPagosNotasClientesId);
            businessDelegator2View.deleteDatPagosNotasClientes(entity);
            data.remove(selectedDatPagosNotasClientes);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long compania, Long consecutivo,
        Long datPagosNotasClientesId, String detalleNota, String estado,
        Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion,
        Date fechaRegistro, Date fechaVencimiento, String formaPago,
        String numFactura, String observacion, String observacionAnularReg,
        Long usuarioDigitacion, Double valorCredito, Double valorDebito,
        Long persEmprId_PersEmpr) throws Exception {
        try {
            entity.setCompania(FacesUtils.checkLong(compania));
            entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
            entity.setDetalleNota(FacesUtils.checkString(detalleNota));
            entity.setEstado(FacesUtils.checkString(estado));
            entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
            entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
            entity.setFormaPago(FacesUtils.checkString(formaPago));
            entity.setNumFactura(FacesUtils.checkString(numFactura));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    observacionAnularReg));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
            entity.setValorCredito(FacesUtils.checkDouble(valorCredito));
            entity.setValorDebito(FacesUtils.checkDouble(valorDebito));
            businessDelegator2View.updateDatPagosNotasClientes(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatPagosNotasClientesView").requestRender();
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

    public InputTextarea getTxtDetalleNota() {
        return txtDetalleNota;
    }

    public void setTxtDetalleNota(InputTextarea txtDetalleNota) {
        this.txtDetalleNota = txtDetalleNota;
    }

    public SelectOneRadio getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(SelectOneRadio txtEstado) {
        this.txtEstado = txtEstado;
    }

    public SelectOneMenu getTxtFormaPago() {
        return txtFormaPago;
    }

    public void setTxtFormaPago(SelectOneMenu txtFormaPago) {
        this.txtFormaPago = txtFormaPago;
    }

    public InputText getTxtNumFactura() {
        return txtNumFactura;
    }

    public void setTxtNumFactura(InputText txtNumFactura) {
        this.txtNumFactura = txtNumFactura;
    }

    public InputTextarea getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputTextarea txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public InputTextarea getTxtObservacionAnularReg() {
        return txtObservacionAnularReg;
    }

    public void setTxtObservacionAnularReg(InputTextarea txtObservacionAnularReg) {
        this.txtObservacionAnularReg = txtObservacionAnularReg;
    }

    public InputText getTxtUsuarioDigitacion() {
        return txtUsuarioDigitacion;
    }

    public void setTxtUsuarioDigitacion(InputText txtUsuarioDigitacion) {
        this.txtUsuarioDigitacion = txtUsuarioDigitacion;
    }

    public InputText getTxtValorCredito() {
        return txtValorCredito;
    }

    public void setTxtValorCredito(InputText txtValorCredito) {
        this.txtValorCredito = txtValorCredito;
    }

    public InputText getTxtValorDebito() {
        return txtValorDebito;
    }

    public void setTxtValorDebito(InputText txtValorDebito) {
        this.txtValorDebito = txtValorDebito;
    }

    public SelectOneMenu getTxtPersEmprId_PersEmpr() {
        return txtPersEmprId_PersEmpr;
    }

    public void setTxtPersEmprId_PersEmpr(SelectOneMenu txtPersEmprId_PersEmpr) {
        this.txtPersEmprId_PersEmpr = txtPersEmprId_PersEmpr;
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

    public Calendar getTxtFechaVencimiento() {
        return txtFechaVencimiento;
    }

    public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
        this.txtFechaVencimiento = txtFechaVencimiento;
    }

    public InputText getTxtDatPagosNotasClientesId() {
        return txtDatPagosNotasClientesId;
    }

    public void setTxtDatPagosNotasClientesId(
        InputText txtDatPagosNotasClientesId) {
        this.txtDatPagosNotasClientesId = txtDatPagosNotasClientesId;
    }

    public List<DatPagosNotasClientesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegator2View.getDataDatPagosNotasClientes();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatPagosNotasClientesDTO> datPagosNotasClientesDTO) {
        this.data = datPagosNotasClientesDTO;
    }

    public DatPagosNotasClientesDTO getSelectedDatPagosNotasClientes() {
        return selectedDatPagosNotasClientes;
    }

    public void setSelectedDatPagosNotasClientes(
        DatPagosNotasClientesDTO datPagosNotasClientes) {
        this.selectedDatPagosNotasClientes = datPagosNotasClientes;
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
    

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatPagosNotasClientes.getDatPagosNotasClientesId().longValue());
				entity = businessDelegator2View.getDatPagosNotasClientes(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			String numFact = FacesUtils.checkString(txtNumFactura);
			 businessDelegator2View.anularNumFacturaEnDatServRDet("0", numFact);
			
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			businessDelegator2View.updateDatPagosNotasClientes(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) throws Exception {

		action_clear();
		selectedDatPagosNotasClientes = (DatPagosNotasClientesDTO) (evt.getComponent()
				.getAttributes().get("selectedDatPagosNotasClientes"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atras. Por favor, estar seguro."));
		return "";

	}
 
	public SelectItem[] getSelectContratista() {

		if (contratista == null || contratista.size() == 0) {

			contratista = new ArrayList<PersEmpr>();

			try {

				contratista = businessDelegatorView.getPersEmpr(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<PersEmpr> lista = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
				selectContratista = new SelectItem[lista.size()];

				int i = 0;
				for (PersEmpr contratista : lista) {
					selectContratista[i] = new SelectItem(contratista.getPersEmprId(), contratista.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectContratista;
	}

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
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


	public void consultaDatosFactura() {
		try {

			String numFactura = FacesUtils.checkString(txtNumFactura);
			Object[] condicion = { "numFactura", true, numFactura, "=" };
			List<DatFacturaServicios> lista = (numFactura != null)
					? businessDelegator2View.findByCriteriaInDatFacturaServicios(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entityFactura = lista.get(0);
				
		            txtFechaVencimiento.setValue(entityFactura.getFechaRegistro());
		            txtFechaVencimiento.setDisabled(false);
		            txtFechaFactura.setValue(entityFactura.getFechaRegistro());
		            txtFechaFactura.setDisabled(false);
		            if(entityFactura.getPersEmprId()!=null){
			            txtPersEmprId_PersEmpr.setValue(entityFactura.getPersEmprId().getPersEmprId());
			            txtPersEmprId_PersEmpr.setDisabled(true);
			            }
		            
			} else {
				FacesUtils.addInfoMessage(
						"Upps! El Número de factura  digitado no existe!"
			  					+ numFactura);
				txtFechaFactura.setDisabled(true);
				txtFechaVencimiento.setDisabled(true);
				txtPersEmprId_PersEmpr.setDisabled(true);
			}
		 }catch (Exception e) {
			entityFactura = null;
		}
		
	}

	public DatPagosNotasClientes getEntity() {
		return entity;
	}

	public void setEntity(DatPagosNotasClientes entity) {
		this.entity = entity;
	}

	public DatFacturaServicios getEntityFactura() {
		return entityFactura;
	}

	public void setEntityFactura(DatFacturaServicios entityFactura) {
		this.entityFactura = entityFactura;
	}

	public InputNumber getTxtValorNota() {
		return txtValorNota;
	}

	public void setTxtValorNota(InputNumber txtValorNota) {
		this.txtValorNota = txtValorNota;
	}

	public Calendar getTxtFechaFactura() {
		return txtFechaFactura;
	}

	public void setTxtFechaFactura(Calendar txtFechaFactura) {
		this.txtFechaFactura = txtFechaFactura;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}
	

	public InputNumber getTxtSaldoFactura() {
		return txtSaldoFactura;
	}

	public void setTxtSaldoFactura(InputNumber txtSaldoFactura) {
		this.txtSaldoFactura = txtSaldoFactura;
	}



	public List<FacturaServiciosConsolidadosDTO> getDataSaldoFactura() {
		try {
			

			// Long compania = 1L;
			String numfactura =  FacesUtils.checkString(txtNumFactura);
			String cadena = "";
						
			double valorTotal = 0;
		    double horas = 0;
		    double cantidad = 0;
		       
			if(numfactura != null  ){
			dataSaldoFactura = businessDelegator2View.pr_saldo_facturas_cliente(numfactura);			
		       if(dataSaldoFactura !=null){
		        for( FacturaServiciosConsolidadosDTO data1 : dataSaldoFactura) { 
		        	valorTotal += data1.getValor_factura().doubleValue();
		        }
		 
			}
			
			txtSaldoFactura.setValue(valorTotal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataSaldoFactura;
	}

	public void setDataSaldoFactura(List<FacturaServiciosConsolidadosDTO> dataSaldoFactura) {
		this.dataSaldoFactura = dataSaldoFactura;
	}

	
	public void listarPagosNotasClientes() {
		try {
			 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaIni));
			fechaFinal = (FacesUtils.checkDate(txtFechaFin));
		
		
			Long compania = new Long(getCompaniaIdSession());
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_notas_clientes(compania, fechaInicial, fechaFinal);
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public List<PagosNotasClientesDTO> getData2() {
		return data2;
	}

	public void setData2(List<PagosNotasClientesDTO> data2) {
		this.data2 = data2;
	}

	public Calendar getTxtFechaIni() {
		return txtFechaIni;
	}

	public void setTxtFechaIni(Calendar txtFechaIni) {
		this.txtFechaIni = txtFechaIni;
	}

	public Calendar getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(Calendar txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}
	
	public String actionDeleteMovimiento(ActionEvent evt) {
		selectedDatPagosNotasClientes2 = (PagosNotasClientesDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPagosNotasClientes2"));
		try {

			Long datPagosNotasClientes = selectedDatPagosNotasClientes2.getDat_pagos_notas_clientes_id().longValue();
			Object[] condicion = { "datPagosNotasClientesId", true, datPagosNotasClientes, "=" };
			List<DatPagosNotasClientes> lista = (datPagosNotasClientes != null)
					? businessDelegator2View.findByCriteriaInDatPagosNotasClientes(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
			
				if(usuario.getNivelAcceso() != null) {
					if(usuario.getNivelAcceso().equals("TOTAL")) {
				
					Long borrarGeneral= businessDelegator2View.pr_borrar_dat_pagos_notas_clientes(datPagosNotasClientes)  ;
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso exitoso!",
							"El movimiento de compra fue eliminado exitosamente!!!"));
			
					
					}else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upps!",
								"Para poder eliminar el movimiento de compra debe tener permisos de administrador "));
				
					}
				}
				setShowDialog(true);

				activeTapIndex = 0;

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
}
