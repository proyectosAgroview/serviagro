package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatFacturaServicios;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatFacturaServiciosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatFacturaServiciosView.class);
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private InputTextarea txtDetalleFactura;
	private SelectOneRadio txtEstado;
	private SelectOneMenu txtFormaPago;
	private InputText txtNumFactura;
	private InputTextarea txtObservacion;
	private InputTextarea txtObservacionAnularReg;

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private Spinner txtPlazo;
	private InputNumber txtRetencion;
	private InputText txtUsuarioDigitacion;

	private Spinner txtValorBaseIva;

	private InputNumber txtValorFactura;
	private InputNumber txtValorDescuento;
	private InputNumber txtValorIva;

	private InputNumber txtValorDescuentoCenicana;
	private InputNumber txtValorReteIca;
	private InputNumber txtValorRetencionContrato;

	private InputNumber txtValorDescuentoTimbre;
	private InputNumber txtValorReteIva; // retencion en la fuente.

	private InputText txtDatFacturaServiciosId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaRegistro;
	private Calendar txtFechaVencimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatFacturaServiciosDTO> data;
	private List<FacturaServiciosConsolidadosDTO> data2;
	private DatFacturaServiciosDTO selectedDatFacturaServicios;
	private DatFacturaServicios entity;

	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private InputNumber txtVlTotal;
	private InputNumber txtCantidad;
	private InputNumber txtHoras;

	private SelectOneMenu txtNumPrefactura;
	SelectItem[] selectNumPrefactura;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> numPrefactura;
	
	private List<String> selectedNumFacturaConsulta;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> numPrefacturaConsulta;
	
	

	private List<ConsultaServiciosRealizadosMaquinariaDTO> dataClientePrefactura;
	String cadenaFactura = "";
	private int activeTapIndex = 0;

	private String disableDesFactura = "true";
	private StreamedContent fileFactura = null;

	private String visible = "hidden";

	private List<FacturaServiciosConsolidadosDTO> data3;
	private List<FacturaServiciosConsolidadosDTO> data4;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	private InputText txtNumeroFacturaConsulta;

	public DatFacturaServiciosView() {
		super();
	}

	public String action_new() throws NumberFormatException, Exception {
		action_clear();
		selectedDatFacturaServicios = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() throws NumberFormatException, Exception {
		entity = null;
		selectedDatFacturaServicios = null;
		PrimeFaces.current().resetInputs(":frm");
		activeTapIndex = 0;

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(false);
		}

		if (dataClientePrefactura != null) {
			dataClientePrefactura = null;

		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
		//	Long compania = new Long(getCompaniaIdSession());
			//txtConsecutivo.setValue(businessDelegator2View.consec_facturacion_servicios(compania));
			txtConsecutivo.setDisabled(false);
		}

		if (txtDetalleFactura != null) {
			txtDetalleFactura.setValue(null);
			txtDetalleFactura.setDisabled(false);
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

		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(false);
		}

		if (txtPlazo != null) {
			txtPlazo.setValue(null);
			txtPlazo.setDisabled(false);
		}

		if (txtRetencion != null) {
			txtRetencion.setValue(null);
			txtRetencion.setDisabled(false);
		}

		if (txtUsuarioDigitacion != null) {
			txtUsuarioDigitacion.setValue(null);
			txtUsuarioDigitacion.setDisabled(false);
		}

		if (txtValorBaseIva != null) {
			txtValorBaseIva.setValue(null);
			txtValorBaseIva.setDisabled(false);
		}

		if (txtValorDescuento != null) {
			txtValorDescuento.setValue(null);
			txtValorDescuento.setDisabled(false);
		}

		if (txtValorDescuentoCenicana != null) {
			txtValorDescuentoCenicana.setValue(null);
			txtValorDescuentoCenicana.setDisabled(false);
		}

		if (txtValorDescuentoTimbre != null) {
			txtValorDescuentoTimbre.setValue(null);
			txtValorDescuentoTimbre.setDisabled(false);
		}

		if (txtValorFactura != null) {
			txtValorFactura.setValue(null);
			txtValorFactura.setDisabled(false);
		}

		if (txtValorIva != null) {
			txtValorIva.setValue(null);
			txtValorIva.setDisabled(false);
		}

		if (txtValorReteIca != null) {
			txtValorReteIca.setValue(null);
			txtValorReteIca.setDisabled(false);
		}

		if (txtValorReteIva != null) {
			txtValorReteIva.setValue(null);
			txtValorReteIva.setDisabled(false);
		}

		if (txtValorRetencionContrato != null) {
			txtValorRetencionContrato.setValue(null);
			txtValorRetencionContrato.setDisabled(false);
		}

		if (txtFechaAnulacion != null) {
			txtFechaAnulacion.setValue(null);
			txtFechaAnulacion.setDisabled(false);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(false);
		}

		if (txtFechaRegistro != null) {
			txtFechaRegistro.setValue(null);
			txtFechaRegistro.setDisabled(false);
		}

		if (txtFechaVencimiento != null) {
			txtFechaVencimiento.setValue(null);
			txtFechaVencimiento.setDisabled(false);
		}

		if (txtDatFacturaServiciosId != null) {
			txtDatFacturaServiciosId.setValue(null);
			txtDatFacturaServiciosId.setDisabled(false);
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
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaRegistro() {
		Date inputDate = (Date) txtFechaRegistro.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaVencimiento() {
		Date inputDate = (Date) txtFechaVencimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public String action_edit(ActionEvent evt) {
		selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatFacturaServicios"));
		txtCompania.setValue(selectedDatFacturaServicios.getCompania());
		txtCompania.setDisabled(false);
		txtConsecutivo.setValue(selectedDatFacturaServicios.getConsecutivo());
		txtConsecutivo.setDisabled(false);
		txtDetalleFactura.setValue(selectedDatFacturaServicios.getDetalleFactura());
		txtDetalleFactura.setDisabled(false);
		txtEstado.setValue(selectedDatFacturaServicios.getEstado());
		txtEstado.setDisabled(false);
		txtFechaAnulacion.setValue(selectedDatFacturaServicios.getFechaAnulacion());
		txtFechaAnulacion.setDisabled(false);
		txtFechaCreacion.setValue(selectedDatFacturaServicios.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaRegistro.setValue(selectedDatFacturaServicios.getFechaRegistro());
		txtFechaRegistro.setDisabled(false);
		txtFechaVencimiento.setValue(selectedDatFacturaServicios.getFechaVencimiento());
		txtFechaVencimiento.setDisabled(false);
		txtFormaPago.setValue(selectedDatFacturaServicios.getFormaPago());
		txtFormaPago.setDisabled(false);
		txtNumFactura.setValue(selectedDatFacturaServicios.getNumFactura());
		txtNumFactura.setDisabled(false);
		txtObservacion.setValue(selectedDatFacturaServicios.getObservacion());
		txtObservacion.setDisabled(false);
		txtObservacionAnularReg.setValue(selectedDatFacturaServicios.getObservacionAnularReg());
		txtObservacionAnularReg.setDisabled(false);
		txtPersEmprId.setValue(selectedDatFacturaServicios.getPersEmprId());
		txtPersEmprId.setDisabled(false);
		txtPlazo.setValue(selectedDatFacturaServicios.getPlazo());
		txtPlazo.setDisabled(false);
		txtRetencion.setValue(selectedDatFacturaServicios.getRetencion());
		txtRetencion.setDisabled(false);
		txtUsuarioDigitacion.setValue(selectedDatFacturaServicios.getUsuarioDigitacion());
		txtUsuarioDigitacion.setDisabled(false);
		// txtValorBaseIva.setValue(selectedDatFacturaServicios.getValorBaseIva());
		// txtValorBaseIva.setDisabled(false);
		txtValorDescuento.setValue(selectedDatFacturaServicios.getValorDescuento());
		txtValorDescuento.setDisabled(false);
		txtValorDescuentoCenicana.setValue(selectedDatFacturaServicios.getValorDescuentoCenicana());
		txtValorDescuentoCenicana.setDisabled(false);
		// txtValorDescuentoTimbre.setValue(selectedDatFacturaServicios.getValorDescuentoTimbre());
		// txtValorDescuentoTimbre.setDisabled(false);
		txtValorFactura.setValue(selectedDatFacturaServicios.getValorFactura());
		txtValorFactura.setDisabled(false);
		txtValorIva.setValue(selectedDatFacturaServicios.getValorIva());
		txtValorIva.setDisabled(false);
		txtValorReteIca.setValue(selectedDatFacturaServicios.getValorReteIca());
		txtValorReteIca.setDisabled(false);
		txtValorReteIva.setValue(selectedDatFacturaServicios.getValorReteIva());
		txtValorReteIva.setDisabled(false);
		txtValorRetencionContrato.setValue(selectedDatFacturaServicios.getValorRetencionContrato());
		txtValorRetencionContrato.setDisabled(false);
		txtDatFacturaServiciosId.setValue(selectedDatFacturaServicios.getDatFacturaServiciosId());
		txtDatFacturaServiciosId.setDisabled(true);
		btnSave.setDisabled(false);
		activeTapIndex = 0;

		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatFacturaServicios == null) && (entity == null)) {
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
            entity = new DatFacturaServicios();
           
            //Long datFacturaServiciosId = FacesUtils.checkLong(txtDatFacturaServiciosId);
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setFechaCreacion(date);
            entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
//            entity.setDatFacturaServiciosId(datFacturaServiciosId);
            entity.setNumPrefactura(FacesUtils.checkLong(txtNumPrefactura));
            
            entity.setDetalleFactura(FacesUtils.checkString(txtDetalleFactura));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
            entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
            entity.setFormaPago(FacesUtils.checkString(txtFormaPago));
            entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setPersEmprId((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);
            
            entity.setPlazo(FacesUtils.checkLong(txtPlazo));
            entity.setRetencion(FacesUtils.checkDouble(txtRetencion));
            entity.setValorBaseIva(FacesUtils.checkDouble(txtValorBaseIva));
            entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
            entity.setValorDescuentoCenicana(FacesUtils.checkDouble(
                    txtValorDescuentoCenicana));
            entity.setValorDescuentoTimbre(FacesUtils.checkDouble(
                    txtValorDescuentoTimbre));
            entity.setValorFactura(FacesUtils.checkDouble(txtValorFactura));
            Double valor_factura = FacesUtils.checkDouble(txtValorFactura);
            entity.setValorIva(FacesUtils.checkDouble(txtValorIva));
            entity.setValorReteIca(FacesUtils.checkDouble(txtValorReteIca));
            entity.setValorReteIva(FacesUtils.checkDouble(txtValorReteIva));
            entity.setValorRetencionContrato(FacesUtils.checkDouble(
                    txtValorRetencionContrato));
            
            
            Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);
			
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);  
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());
			
			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());
			

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -450);  
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());
			
			if(fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {
				String num_factura = FacesUtils.checkString(txtNumFactura);
			Object[] condicion = { "numFactura", true, num_factura, "=" };
			List<DatFacturaServicios> lista = (num_factura != null)
					? businessDelegator2View.findByCriteriaInDatFacturaServicios(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
						"Upps! El Nùmero de factura digitado ya existe!, debe modificar el valor:. " , num_factura.toString()));
				action_clear();
				
			} else
			{	 			
				if(dataClientePrefactura !=null &&  dataClientePrefactura.size()>0){
			        for( ConsultaServiciosRealizadosMaquinariaDTO data1 : dataClientePrefactura) {
			        	
			        	Long idRegistro = data1.getIdRegistro().longValue();
						Object[] condicionDetalle = { "datServRealizadosEquipoDetId", true, idRegistro, "=" };
						List<DatServRealizadosEquipoDet> listaDetalle = (idRegistro != null)
								? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicionDetalle, null, null) : null;

						if (listaDetalle != null && listaDetalle.size() > 0) {
							DatServRealizadosEquipoDet	entityDetalle  = null;
							entityDetalle = listaDetalle.get(0);
							entityDetalle.setEstadoFactura("facturado");
							entityDetalle.setNumFactura(num_factura);
							entityDetalle.setUsuarioFactura(usuarioId);
							entityDetalle.setFechaFactura(new Date());
							businessDelegatorView.updateDatServRealizadosEquipoDet(entityDetalle);
						} 
			        }
			 
				}
					//businessDelegatorView.actualizarNumFacturaEnDatServRDet(cadenaFactura, num_factura);
		            businessDelegator2View.saveDatFacturaServicios(entity);
		            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
		            imprimirFactura();
		        	//businessDelegatorView.pr_actualiza_consec_factura_compania(compania,num_factura );
		        
		        
				
           }
	}else {
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Upps!, La fecha del registro esta por fuera del rango permitido " + "",
							""));
							
							entity =null;
				
					}

        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long datFacturaServiciosId = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId());
                entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
            }
            Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			
            entity.setEstado(estado);
			entity.setCompania(compania);
			entity.setUsuarioDigitacion(usuarioId);
			entity.setFechaModificacion(date);
			entity.setNumPrefactura(FacesUtils.checkLong(txtNumPrefactura));
            
          entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
            entity.setDetalleFactura(FacesUtils.checkString(txtDetalleFactura));
            entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
            entity.setFechaRegistro(FacesUtils.checkDate(txtFechaRegistro));
            entity.setFechaVencimiento(FacesUtils.checkDate(txtFechaVencimiento));
            entity.setFormaPago(FacesUtils.checkString(txtFormaPago));
            entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setObservacionAnularReg(FacesUtils.checkString(
                    txtObservacionAnularReg));
            entity.setPersEmprId((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);
            
            entity.setPlazo(FacesUtils.checkLong(txtPlazo));
            entity.setRetencion(FacesUtils.checkDouble(txtRetencion));
            entity.setUsuarioDigitacion(FacesUtils.checkLong(
                    txtUsuarioDigitacion));
            entity.setValorBaseIva(FacesUtils.checkDouble(txtValorBaseIva));
            entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
            entity.setValorDescuentoCenicana(FacesUtils.checkDouble(
                    txtValorDescuentoCenicana));
            entity.setValorDescuentoTimbre(FacesUtils.checkDouble(
                    txtValorDescuentoTimbre));
            entity.setValorFactura(FacesUtils.checkDouble(txtValorFactura));
            entity.setValorIva(FacesUtils.checkDouble(txtValorIva));
            entity.setValorReteIca(FacesUtils.checkDouble(txtValorReteIca));
            entity.setValorReteIva(FacesUtils.checkDouble(txtValorReteIva));
            entity.setValorRetencionContrato(FacesUtils.checkDouble(
                    txtValorRetencionContrato));
            Date fechaRegistro = FacesUtils.checkDate(txtFechaRegistro);
			
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.add(GregorianCalendar.DAY_OF_YEAR, 1);  
			java.sql.Date fecha = new java.sql.Date(calendario.getTimeInMillis());
			
			GregorianCalendar calendario2 = new GregorianCalendar();
			calendario2.setTime(fechaRegistro);
			java.sql.Date fechaPin = new java.sql.Date(calendario2.getTimeInMillis());
			

			GregorianCalendar calendario4 = new GregorianCalendar();
			calendario4.add(GregorianCalendar.DAY_OF_YEAR, -450);  
			java.sql.Date fechaMinimaPermitida = new java.sql.Date(calendario4.getTimeInMillis());
			
			if(fechaPin.before(fecha) && fechaMinimaPermitida.before(fechaPin)) {
		
            businessDelegator2View.updateDatFacturaServicios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
            
        }else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Upps!, La fecha del registro esta por fuera del rango permitido " + "",
					""));
					
				
		
			}

        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }
    
	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatFacturaServicios"));

			Long datFacturaServiciosId = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId());
			entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datFacturaServiciosId = FacesUtils.checkLong(txtDatFacturaServiciosId);
			entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegator2View.deleteDatFacturaServicios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() throws NumberFormatException, Exception {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
					.get("selectedDatFacturaServicios"));

			Long datFacturaServiciosId = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId());
			entity = businessDelegator2View.getDatFacturaServicios(datFacturaServiciosId);
			businessDelegator2View.deleteDatFacturaServicios(entity);
			data.remove(selectedDatFacturaServicios);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long compania, Long consecutivo, Long datFacturaServiciosId,
			String detalleFactura, String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaRegistro,
			Date fechaVencimiento, String formaPago, String numfactura, String observacion, String observacionAnularReg,
			Long persEmprId, Long plazo, Double retencion, Long usuarioDigitacion, Double valorBaseIva,
			Double valorDescuento, Double valorDescuentoCenicana, Double valorDescuentoTimbre, Double valorFactura,
			Double valorIva, Double valorReteIca, Double valorReteIva, Double valorRetencionContrato) throws Exception {
		try {
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setDetalleFactura(FacesUtils.checkString(detalleFactura));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaRegistro(FacesUtils.checkDate(fechaRegistro));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setFormaPago(FacesUtils.checkString(formaPago));
			entity.setNumFactura(FacesUtils.checkString(numfactura));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setPersEmprId((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);

			entity.setPlazo(FacesUtils.checkLong(plazo));
			entity.setRetencion(FacesUtils.checkDouble(retencion));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			entity.setValorBaseIva(FacesUtils.checkDouble(valorBaseIva));
			entity.setValorDescuento(FacesUtils.checkDouble(valorDescuento));
			entity.setValorDescuentoCenicana(FacesUtils.checkDouble(valorDescuentoCenicana));
			entity.setValorDescuentoTimbre(FacesUtils.checkDouble(valorDescuentoTimbre));
			entity.setValorFactura(FacesUtils.checkDouble(valorFactura));
			entity.setValorIva(FacesUtils.checkDouble(valorIva));
			entity.setValorReteIca(FacesUtils.checkDouble(valorReteIca));
			entity.setValorReteIva(FacesUtils.checkDouble(valorReteIva));
			entity.setValorRetencionContrato(FacesUtils.checkDouble(valorRetencionContrato));
			businessDelegator2View.updateDatFacturaServicios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatFacturaServiciosView").requestRender();
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

	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
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

	public InputText getTxtDatFacturaServiciosId() {
		return txtDatFacturaServiciosId;
	}

	public void setTxtDatFacturaServiciosId(InputText txtDatFacturaServiciosId) {
		this.txtDatFacturaServiciosId = txtDatFacturaServiciosId;
	}

	public List<DatFacturaServiciosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegator2View.getDataDatFacturaServicios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatFacturaServiciosDTO> datFacturaServiciosDTO) {
		this.data = datFacturaServiciosDTO;
	}

	public DatFacturaServiciosDTO getSelectedDatFacturaServicios() {
		return selectedDatFacturaServicios;
	}

	public void setSelectedDatFacturaServicios(DatFacturaServiciosDTO datFacturaServicios) {
		this.selectedDatFacturaServicios = datFacturaServicios;
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

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public InputTextarea getTxtDetalleFactura() {
		return txtDetalleFactura;
	}

	public void setTxtDetalleFactura(InputTextarea txtDetalleFactura) {
		this.txtDetalleFactura = txtDetalleFactura;
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

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public Spinner getTxtPlazo() {
		return txtPlazo;
	}

	public void setTxtPlazo(Spinner txtPlazo) {
		this.txtPlazo = txtPlazo;
	}

	public InputNumber getTxtRetencion() {
		return txtRetencion;
	}

	public void setTxtRetencion(InputNumber txtRetencion) {
		this.txtRetencion = txtRetencion;
	}

	public SelectOneMenu getTxtNumPrefactura() {
		return txtNumPrefactura;
	}

	public void setTxtNumPrefactura(SelectOneMenu txtNumPrefactura) {
		this.txtNumPrefactura = txtNumPrefactura;
	}

	public Spinner getTxtValorBaseIva() {
		return txtValorBaseIva;
	}

	public void setTxtValorBaseIva(Spinner txtValorBaseIva) {
		this.txtValorBaseIva = txtValorBaseIva;
	}

	public InputNumber getTxtValorDescuento() {
		return txtValorDescuento;
	}

	public void setTxtValorDescuento(InputNumber txtValorDescuento) {
		this.txtValorDescuento = txtValorDescuento;
	}

	public InputNumber getTxtValorDescuentoCenicana() {
		return txtValorDescuentoCenicana;
	}

	public void setTxtValorDescuentoCenicana(InputNumber txtValorDescuentoCenicana) {
		this.txtValorDescuentoCenicana = txtValorDescuentoCenicana;
	}

	public InputNumber getTxtValorDescuentoTimbre() {
		return txtValorDescuentoTimbre;
	}

	public void setTxtValorDescuentoTimbre(InputNumber txtValorDescuentoTimbre) {
		this.txtValorDescuentoTimbre = txtValorDescuentoTimbre;
	}

	public InputNumber getTxtValorFactura() {
		return txtValorFactura;
	}

	public void setTxtValorFactura(InputNumber txtValorFactura) {
		this.txtValorFactura = txtValorFactura;
	}

	public InputNumber getTxtValorIva() {
		return txtValorIva;
	}

	public void setTxtValorIva(InputNumber txtValorIva) {
		this.txtValorIva = txtValorIva;
	}

	public InputNumber getTxtValorReteIca() {
		return txtValorReteIca;
	}

	public void setTxtValorReteIca(InputNumber txtValorReteIca) {
		this.txtValorReteIca = txtValorReteIca;
	}

	public InputNumber getTxtValorReteIva() {
		return txtValorReteIva;
	}

	public void setTxtValorReteIva(InputNumber txtValorReteIva) {
		this.txtValorReteIva = txtValorReteIva;
	}

	public InputNumber getTxtValorRetencionContrato() {
		return txtValorRetencionContrato;
	}

	public void setTxtValorRetencionContrato(InputNumber txtValorRetencionContrato) {
		this.txtValorRetencionContrato = txtValorRetencionContrato;
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

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatFacturaServicios.getDatFacturaServiciosId().longValue());
				entity = businessDelegator2View.getDatFacturaServicios(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			String numFact = FacesUtils.checkString(txtNumFactura);
			businessDelegator2View.anularNumFacturaEnDatServRDet("0", numFact);

			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));

			businessDelegator2View.updateDatFacturaServicios(entity);
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
		selectedDatFacturaServicios = (DatFacturaServiciosDTO) (evt.getComponent().getAttributes()
				.get("selectedDatFacturaServicios"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atras. Por favor, estar seguro."));
		return "";

	}

	public SelectItem[] getSelectContratista() {

		if (contratista == null || contratista.size() == 0) {

			try {

			 	// Criteria
				Object[] condicion = { "estado", true, "A", "=" 			
						, "tipoEmpresa", true, "2", "<>" 
						, "tipoEmpresa", true, "3", "<>"
						, "tipoEmpresa", true, "5", "<>" 
						, "tipoEmpresa", true, "6", "<>" };
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

	/*** Consulta de prefacturas de prefactura por clientes ***/

	public SelectItem[] getSelectNumPrefactura() {
		if (txtPersEmprId.getValue() != null) {
			if (!txtPersEmprId.getValue().equals("")) {
				if (numPrefactura == null || numPrefactura.size() == 0) {
					try {
						Long clienteId = FacesUtils.checkLong(txtPersEmprId);

						// Criteria
						List<ConsultaServiciosRealizadosMaquinariaDTO> lista = businessDelegator2View
								.pr_consulta_prefacturas_por_cliente(clienteId);
						if (lista != null && lista.size() > 0) {
							selectNumPrefactura = new SelectItem[lista.size()];
							int i = 0;
							for (ConsultaServiciosRealizadosMaquinariaDTO consulta : lista) {
								selectNumPrefactura[i] = new SelectItem(consulta.getConsecutivoPrefactura(),
										consulta.getConsecutivoPrefactura().toString());
								i++;

							}
						}
					} catch (Exception e) {
						FacesUtils.addErrorMessage(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return selectNumPrefactura;

	}

	public void setSelectNumPrefactura(SelectItem[] selectNumPrefactura) {
		this.selectNumPrefactura = selectNumPrefactura;
	}

	public void obtenerPrefactura() {
		try {

			// Long compania = 1L;
			Long clienteId = FacesUtils.checkLong(txtPersEmprId);
			//Long prefactura = FacesUtils.checkLong(txtNumPrefactura);
			String cadenaPrefactura = "0";
			double valorTotal = 0;
			double horas = 0;
			double cantidad = 0;
			if (selectedNumFacturaConsulta != null && selectedNumFacturaConsulta.size() > 0) {
				cadenaPrefactura = selectedNumFacturaConsulta.get(0);
			 	for (int i = 1; i < selectedNumFacturaConsulta.size(); i++) {
			 		cadenaPrefactura += "," + selectedNumFacturaConsulta.get(i);
				}
			}
	
			 
			if (cadenaPrefactura != null && clienteId != null) {
				dataClientePrefactura = businessDelegator2View.pr_cargar_serv_prefact_cliente(clienteId, cadenaPrefactura);
				if (dataClientePrefactura != null) {
					for (ConsultaServiciosRealizadosMaquinariaDTO data1 : dataClientePrefactura) {
						valorTotal += data1.getCostoTotal().doubleValue();
						cantidad += data1.getCantidadPago().doubleValue();
						horas += data1.getHoras().doubleValue();
						 

					}

				}

				txtValorFactura.setValue(valorTotal);
				txtRetencion.setValue(0.0);
				txtCantidad.setValue(cantidad);
				txtHoras.setValue(horas);
				 
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
						"Upps! El cliente y el número de prefactura son campos obligatorios " , ""));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getDataClientePrefactura() {
		return dataClientePrefactura;
	}

	public void setData3(List<FacturaServiciosConsolidadosDTO> data3) {
		this.data3 = data3;
	}

	public InputNumber getTxtVlTotal() {
		return txtVlTotal;
	}

	public void setTxtVlTotal(InputNumber txtVlTotal) {
		this.txtVlTotal = txtVlTotal;
	}

	public InputNumber getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputNumber txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public InputNumber getTxtHoras() {
		return txtHoras;
	}

	public void setTxtHoras(InputNumber txtHoras) {
		this.txtHoras = txtHoras;
	}

	public void setDataClientePrefactura(List<ConsultaServiciosRealizadosMaquinariaDTO> dataClientePrefactura) {
		this.dataClientePrefactura = dataClientePrefactura;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public void imprimirFactura() throws NumberFormatException, Exception {

		Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
		String numfactura = FacesUtils.checkString(txtNumFactura);

		if (persEmprId != null && numfactura != null) {
			try {

				List<FacturaServiciosConsolidadosDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoFactura.xlsx";

				data3 = businessDelegator2View.pr_facturas_consolidadas_servdetal(persEmprId, numfactura);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);
					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style1.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style1.setBorderRight((CellStyle.BORDER_MEDIUM));
					style1.setBorderTop((CellStyle.BORDER_MEDIUM));
					style1.setBorderBottom((CellStyle.BORDER_MEDIUM));

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					style2.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style2.setBorderRight((CellStyle.BORDER_MEDIUM));
					style2.setBorderTop((CellStyle.BORDER_MEDIUM));
					style2.setBorderBottom((CellStyle.BORDER_MEDIUM));

					style2.setAlignment(CellStyle.ALIGN_CENTER);

					Font font = book.createFont();
					font.setColor(IndexedColors.WHITE.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");

					style2.setFont(font);

					CellStyle style3 = book.createCellStyle();
					style3.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style3.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style3.setBorderRight((CellStyle.BORDER_MEDIUM));
					style3.setBorderTop((CellStyle.BORDER_MEDIUM));
					style3.setBorderBottom((CellStyle.BORDER_MEDIUM));

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));

					if (data3 != null) {

						cell = row.createCell(0);
						cell.setCellValue("DAT_FACTURA_SERVICIOS_ID");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("CONSECUTIVO");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("NUM_FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("PERS_EMPR_ID");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("COMPANIA");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("FECHA_REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("ANIO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("ANIO_MES");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("FECHA_VENCIMIENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FORMA_PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("PLAZO");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("DETALLE_FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("VALOR_FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("TOTALES");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD_LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM_LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("COD_UM");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("NOM_UM");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("CANTIDAD");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("MAQ");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("DIRECCION_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("TELEFONO_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("HACIENDA");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SUERTE");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("CONCEPTO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						int pos_i = 8;

						for (FacturaServiciosConsolidadosDTO ndDTO : data3) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getDat_factura_servicios_id().doubleValue());
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getConsecutivo().doubleValue());
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getNum_factura());
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getPers_empr_id().doubleValue());
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCod_cliente());
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNom_cliente());
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getCompania().doubleValue());
							cell = row.createCell(7);

							cell.setCellValue(ndDTO.getFecha_registro().toString().substring(8, 10) + "/"
									+ ndDTO.getFecha_registro().toString().substring(5, 7) + "/"
									+ ndDTO.getFecha_registro().toString().substring(0, 4));

							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getAnio_mes());
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getFecha_vencimiento().toString().substring(8, 10) + "/"
									+ ndDTO.getFecha_vencimiento().toString().substring(5, 7) + "/"
									+ ndDTO.getFecha_vencimiento().toString().substring(0, 4));

							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getForma_pago());
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getPlazo().doubleValue());
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getDetalle_factura());
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getValor_factura().doubleValue());
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getTotales().doubleValue());
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodLabor());
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomLabor());
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getCantidad().doubleValue());
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getPin());
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getDireccionCliente());
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getTelefonoCliente());
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getHacienda());
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSuerte());
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getConcepto());
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getNum_prefactura().doubleValue());
							cell.setCellStyle(style);

							pos_i++;

						}

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						fileFactura = new DefaultStreamedContent(stream, "application/xlsx", "MttoFactura.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"El informe se ha generado con exito, ahora puedes Descargar el informe"));

					} else {

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
								"No existe informacion asociada a los criterios de busqueda seleccionados "));
					}

				} catch (Exception e) {

					e.printStackTrace();

					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		visible = "visible";
		disableDesFactura = "false";

	}

	public void consultaFacturaServicios() throws NumberFormatException, Exception {
		Long compania = new Long(getCompaniaIdSession());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
		Date fechaInicial = null;
		Date fechaFinal = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro = null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();
		Long persEmprId = FacesUtils.checkLong(txtPersEmprId);
		String numfactura = FacesUtils.checkString(txtNumFactura);

		if (persEmprId != null && numfactura != null) {
			try {

				List<FacturaServiciosConsolidadosDTO> data = null;
				InputStream stream = null;
				String filename = " ";

				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				Object contextPath = origRequest.getContextPath();

				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();

				Date fechaCreacion = new Date();

				filename = servletContext.getRealPath("") + File.separator + "informes" + File.separator
						+ "MttoFactura.xlsx";

				data4 = businessDelegator2View.pr_facturas_consolidadas_servdetal(persEmprId, numfactura);

				try {

					File excelSalida = new File(filename);
					FileInputStream fis = new FileInputStream(excelSalida);
					XSSFWorkbook book = new XSSFWorkbook(fis);
					XSSFSheet sheet = book.getSheetAt(0);

					XSSFRow row = sheet.createRow(7);
					XSSFCell cell = null;

					sheet.setForceFormulaRecalculation(true);
					CellStyle style = book.createCellStyle();
					style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style.setBorderRight((CellStyle.BORDER_MEDIUM));
					style.setBorderTop((CellStyle.BORDER_MEDIUM));
					style.setBorderBottom((CellStyle.BORDER_MEDIUM));

					CellStyle style1 = book.createCellStyle();
					style1.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style1.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style1.setBorderRight((CellStyle.BORDER_MEDIUM));
					style1.setBorderTop((CellStyle.BORDER_MEDIUM));
					style1.setBorderBottom((CellStyle.BORDER_MEDIUM));

					// Encabezado

					CellStyle style2 = book.createCellStyle();
					style2.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
					style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style2.setAlignment(CellStyle.ALIGN_CENTER);
					style2.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style2.setBorderRight((CellStyle.BORDER_MEDIUM));
					style2.setBorderTop((CellStyle.BORDER_MEDIUM));
					style2.setBorderBottom((CellStyle.BORDER_MEDIUM));

					style2.setAlignment(CellStyle.ALIGN_CENTER);

					Font font = book.createFont();
					font.setColor(IndexedColors.WHITE.getIndex());
					font.setFontHeightInPoints((short) 11);
					font.setBold(true);
					font.setFontName("Calibri");

					style2.setFont(font);

					CellStyle style3 = book.createCellStyle();
					style3.setFillForegroundColor(IndexedColors.WHITE.getIndex());
					style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style3.setBorderLeft((CellStyle.BORDER_MEDIUM));
					style3.setBorderRight((CellStyle.BORDER_MEDIUM));
					style3.setBorderTop((CellStyle.BORDER_MEDIUM));
					style3.setBorderBottom((CellStyle.BORDER_MEDIUM));

					XSSFCellStyle dollarStyle = book.createCellStyle();
					DataFormat df = book.createDataFormat();
					style3.setDataFormat(df.getFormat("#,##0.000"));

					if (data4 != null) {

						cell = row.createCell(0);
						cell.setCellValue("DAT_FACTURA_SERVICIOS_ID");
						cell.setCellStyle(style2);
						cell = row.createCell(1);
						cell.setCellValue("CONSECUTIVO");
						cell.setCellStyle(style2);
						cell = row.createCell(2);
						cell.setCellValue("NUM_FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(3);
						cell.setCellValue("PERS_EMPR_ID");
						cell.setCellStyle(style2);
						cell = row.createCell(4);
						cell.setCellValue("COD_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(5);
						cell.setCellValue("NOM_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(6);
						cell.setCellValue("COMPANIA");
						cell.setCellStyle(style2);
						cell = row.createCell(7);
						cell.setCellValue("FECHA_REGISTRO");
						cell.setCellStyle(style2);
						cell = row.createCell(8);
						cell.setCellValue("ANIO");
						cell.setCellStyle(style2);
						cell = row.createCell(9);
						cell.setCellValue("MES");
						cell.setCellStyle(style2);
						cell = row.createCell(10);
						cell.setCellValue("ANIO_MES");
						cell.setCellStyle(style2);
						cell = row.createCell(11);
						cell.setCellValue("FECHA_VENCIMIENTO");
						cell.setCellStyle(style2);
						cell = row.createCell(12);
						cell.setCellValue("FORMA_PAGO");
						cell.setCellStyle(style2);
						cell = row.createCell(13);
						cell.setCellValue("PLAZO");
						cell.setCellStyle(style2);
						cell = row.createCell(14);
						cell.setCellValue("DETALLE_FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(15);
						cell.setCellValue("VALOR_FACTURA");
						cell.setCellStyle(style2);
						cell = row.createCell(16);
						cell.setCellValue("TOTALES");
						cell.setCellStyle(style2);
						cell = row.createCell(17);
						cell.setCellValue("COD_LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(18);
						cell.setCellValue("NOM_LABOR");
						cell.setCellStyle(style2);
						cell = row.createCell(19);
						cell.setCellValue("COD_UM");
						cell.setCellStyle(style2);
						cell = row.createCell(20);
						cell.setCellValue("NOM_UM");
						cell.setCellStyle(style2);
						cell = row.createCell(21);
						cell.setCellValue("CANTIDAD");
						cell.setCellStyle(style2);
						cell = row.createCell(22);
						cell.setCellValue("VALOR UNITARIO");
						cell.setCellStyle(style2);
						cell = row.createCell(23);
						cell.setCellValue("MAQ");
						cell.setCellStyle(style2);
						cell = row.createCell(24);
						cell.setCellValue("PIN");
						cell.setCellStyle(style2);
						cell = row.createCell(25);
						cell.setCellValue("DIRECCION_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(26);
						cell.setCellValue("TELEFONO_CLIENTE");
						cell.setCellStyle(style2);
						cell = row.createCell(27);
						cell.setCellValue("HACIENDA");
						cell.setCellStyle(style2);
						cell = row.createCell(28);
						cell.setCellValue("SUERTE");
						cell.setCellStyle(style2);
						cell = row.createCell(29);
						cell.setCellValue("CONCEPTO");
						cell.setCellStyle(style2);
						cell = row.createCell(30);
						cell.setCellValue("PREFACTURA");
						cell.setCellStyle(style2);
						int pos_i = 8;

						for (FacturaServiciosConsolidadosDTO ndDTO : data4) {

							row = sheet.createRow(pos_i);
							cell = row.createCell(0);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getDat_factura_servicios_id().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(1);
							cell.setCellValue(ndDTO.getConsecutivo().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(2);
							cell.setCellValue(ndDTO.getNum_factura());
							cell.setCellStyle(style);
							cell = row.createCell(3);
							cell.setCellValue(ndDTO.getPers_empr_id().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(4);
							cell.setCellValue(ndDTO.getCod_cliente());
							cell.setCellStyle(style);
							cell = row.createCell(5);
							cell.setCellValue(ndDTO.getNom_cliente());
							cell.setCellStyle(style);
							cell = row.createCell(6);
							cell.setCellValue(ndDTO.getCompania().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(7);
							cell.setCellValue(ndDTO.getFecha_registro());
							cell.setCellStyle(style);
							cell = row.createCell(8);
							cell.setCellValue(ndDTO.getAnio().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(9);
							cell.setCellValue(ndDTO.getMes().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(10);
							cell.setCellValue(ndDTO.getAnio_mes());
							cell.setCellStyle(style);
							cell = row.createCell(11);
							cell.setCellValue(ndDTO.getFecha_vencimiento());
							cell.setCellStyle(style);
							cell = row.createCell(12);
							cell.setCellValue(ndDTO.getForma_pago());
							cell.setCellStyle(style);
							cell = row.createCell(13);
							cell.setCellValue(ndDTO.getPlazo().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(14);
							cell.setCellValue(ndDTO.getDetalle_factura());
							cell.setCellStyle(style);
							cell = row.createCell(15);
							cell.setCellValue(ndDTO.getValor_factura().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(16);
							cell.setCellValue(ndDTO.getTotales().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(17);
							cell.setCellValue(ndDTO.getCodLabor());
							cell.setCellStyle(style);
							cell = row.createCell(18);
							cell.setCellValue(ndDTO.getNomLabor());
							cell.setCellStyle(style);
							cell = row.createCell(19);
							cell.setCellValue(ndDTO.getCodUdadMed());
							cell.setCellStyle(style);
							cell = row.createCell(20);
							cell.setCellValue(ndDTO.getNomUdadMed());
							cell.setCellStyle(style);
							cell = row.createCell(21);
							cell.setCellValue(ndDTO.getCantidad().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(22);
							cell.setCellValue(ndDTO.getValorUnitario().doubleValue());
							cell.setCellStyle(style);
							cell = row.createCell(23);
							cell.setCellValue(ndDTO.getCodEquipo());
							cell.setCellStyle(style);
							cell = row.createCell(24);
							cell.setCellValue(ndDTO.getPin());
							cell.setCellStyle(style);
							cell = row.createCell(25);
							cell.setCellValue(ndDTO.getDireccionCliente());
							cell.setCellStyle(style);
							cell = row.createCell(26);
							cell.setCellValue(ndDTO.getTelefonoCliente());
							cell.setCellStyle(style);
							cell = row.createCell(27);
							cell.setCellValue(ndDTO.getHacienda());
							cell.setCellStyle(style);
							cell = row.createCell(28);
							cell.setCellValue(ndDTO.getSuerte());
							cell.setCellStyle(style);
							cell = row.createCell(29);
							cell.setCellValue(ndDTO.getConcepto());
							cell.setCellStyle(style);
							cell = row.createCell(30);
							cell.setCellValue(ndDTO.getNum_prefactura().doubleValue());
							cell.setCellStyle(style);
							pos_i++;

						}

						String rutaDescarga = servletContext.getRealPath("") + File.separator + "tmp_reportes"
								+ File.separator;

						FileOutputStream os = new FileOutputStream(new File(rutaDescarga + excelSalida.getName()));

						book.write(os);
						System.out.println("Writing on Excel file Finished ...");

						os.close();
						book.close();
						fis.close();

						stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
								.getResourceAsStream("/tmp_reportes/" + excelSalida.getName());

						fileFactura = new DefaultStreamedContent(stream, "application/xlsx", "MttoFactura.xlsx");

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso Exitoso",
								"El informe se ha generado con exito, ahora puedes Descargar el informe"));

					} else {

						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!",
								"No existe informacion asociada a los criterios de busqueda seleccionados "));
					}

				} catch (Exception e) {

					e.printStackTrace();

					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error: " + e.getMessage()));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		visible = "visible";
		disableDesFactura = "false";

	}

	public List<FacturaServiciosConsolidadosDTO> getData3() {
		return data3;
	}

	public String getDisableDesFactura() {
		return disableDesFactura;
	}

	public void setDisableDesFactura(String disableDesFactura) {
		this.disableDesFactura = disableDesFactura;
	}

	public StreamedContent getFileFactura() {
		return fileFactura;
	}

	public void setFileFactura(StreamedContent fileFactura) {
		this.fileFactura = fileFactura;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public List<FacturaServiciosConsolidadosDTO> getData4() {
		return data4;
	}

	public void setData4(List<FacturaServiciosConsolidadosDTO> data4) {
		this.data4 = data4;
	}

	public DatFacturaServicios getEntity() {
		return entity;
	}

	public void setEntity(DatFacturaServicios entity) {
		this.entity = entity;
	}

	public void listarFacturaServicios() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Long documento = 0L;
			documento = FacesUtils.checkLong(txtNumeroFacturaConsulta);

			if (documento == null) {
				documento = 0L;
			}

			Long compania = new Long(getCompaniaIdSession());
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.pr_listar_factura_servicios(compania, fechaInicial, fechaFinal,
						documento);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<FacturaServiciosConsolidadosDTO> getData2() {
		return data2;
	}

	public void setData2(List<FacturaServiciosConsolidadosDTO> data2) {
		this.data2 = data2;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public InputText getTxtNumeroFacturaConsulta() {
		return txtNumeroFacturaConsulta;
	}

	public void setTxtNumeroFacturaConsulta(InputText txtNumeroFacturaConsulta) {
		this.txtNumeroFacturaConsulta = txtNumeroFacturaConsulta;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public List<String> getSelectedNumFacturaConsulta() {
		return selectedNumFacturaConsulta;
	}
 
	public List<ConsultaServiciosRealizadosMaquinariaDTO> getNumPrefacturaConsulta(){
		if (txtPersEmprId.getValue() != null) {
			if (!txtPersEmprId.getValue().equals("")) { 
					try {
						Long clienteId = FacesUtils.checkLong(txtPersEmprId);

						// Criteria
						numPrefacturaConsulta = businessDelegator2View
								.pr_consulta_prefacturas_por_cliente(clienteId);
					
					} catch (Exception e) {
						FacesUtils.addErrorMessage(e.getMessage());
						e.printStackTrace();
					}
				 
			}
		}
		return numPrefacturaConsulta;

	}

	public void setSelectedNumFacturaConsulta(List<String> selectedNumFacturaConsulta) {
		this.selectedNumFacturaConsulta = selectedNumFacturaConsulta;
	}

	public void setNumPrefacturaConsulta(List<ConsultaServiciosRealizadosMaquinariaDTO> numPrefacturaConsulta) {
		this.numPrefacturaConsulta = numPrefacturaConsulta;
	}

}
