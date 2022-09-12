package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.EntBanc;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.CompaniaDTO;
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
public class CompaniaView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CompaniaView.class);
	private InputText txtCodigo;
	private InputText txtDireccion;
	private SelectOneRadio txtEstado;
	private SelectOneRadio txtEstadoKml;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtUrlKml;
	private InputText txtLatitud;
	private InputText txtLongitud;
	private InputText txtPrecision;
	private InputText txtNombre;
	private InputText txtPbx;
	private InputText txtRut;
	private InputText txtTelefono;
	private double latitude;
	private double longitude;
	private String urlKmlMap;
	private String hayKml;
	private int activeTapIndex = 0;
	// private InputText txtCiudadId_Ciudad;
	// private InputText txtEntBancId_EntBanc;
	private InputText txtCompaniaId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CompaniaDTO> data;
	private CompaniaDTO selectedCompania;
	private Compania entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private SelectOneMenu txtEntBancId_EntBanc;
	SelectItem[] selectEntBanc;

	private SelectOneMenu txtCiudadId_Ciudad;
	SelectItem[] selectCiudad;

	private MapModel simpleModel;
	private String centerRevGeoMap = "4.086665, -76.188064";
	
	private SelectOneMenu txtNivelAutorizaLabor;

	private InputText txtAnioCurso;
    private InputText txtAuxilioMovilizacion;
    private InputText txtCodigoEntredas;
    
    private SelectOneMenu txtCodigoGastoCmb;
	SelectItem[] selectLaborIdCmb;
    
    private SelectOneMenu txtCodigoGastoNomina;
	SelectItem[] selectLaborIdNomina;

    private InputText txtConsecutivoCajaMenor;
    private InputText txtConsecutivoCotizacion;
    private InputText txtConsecutivoEntradas;
    private InputText txtConsecutivoFacturaCali;
    private InputText txtConsecutivoFacturaRozo;
    private InputText txtConsecutivoGastos;
    private InputText txtConsecutivoGastosoperacion;
    private InputText txtConsecutivoOrdCompras;
    private InputText txtConsecutivoPrefactura;
    private InputText txtConsecutivoSalidas;
    private InputText txtConsecutivoTraslados;
    private InputText txtDesFiscal;
    private InputText txtEmail;
    private InputText txtEntBancId;
    private SelectOneMenu txtImprimeFactura;
    private InputText txtPrecision1;
    private InputText txtPrefijo;
    private InputText txtResolucion;
    private InputText txtSubtitulo;
    
    private SelectOneMenu txtConceptoAuxTransporte;
	SelectItem[] selectCeptoNominaId;

	private SelectOneMenu txtKardexEntradaEstandar;
	SelectItem[] selectKardexEntrada;
	
	private SelectOneMenu txtKardexSalidaEstandar;
	SelectItem[] selectKardexSalida;
	
	private InputNumber txtValorUvt;
	private InputNumber txtSalarioMinimoLegal;
	private InputNumber txtTopeSmlAuxTransporte;
	private InputNumber txtRentasExentasUvt;
	private InputNumber txtPorcMinContribucion;
	private InputNumber txtIpc;
	private InputNumber txtAuxilioTransporte;
	private InputNumber txtPorcRentasExternas;
	private InputNumber txtPorcLey1927;
	private InputNumber txtTarifaIvaRetenido;
	private InputNumber txtPorcProvisionCesantias;
	private InputNumber txtPorcProvisionPrimas;
	private InputNumber txtPorcProvisionVacaciones;
	private InputNumber txtPorcProvisionInteresesCesantias;
	private InputNumber txtPorcAporteEpsEmpleador;
	private InputNumber txtPorcAporteAfpAltoRiesgoEmpleador;
	private InputNumber txtPorcAporteIcbfEmpleador;
	private InputNumber txtPorcAporteAfpEmpleador;
	private InputNumber txtPorcAporteCcfEmpleador;
	private InputNumber txtPorcAporteSenaEmpleador;
	private InputNumber txtMinimoSmlAporteSenaIcbf;
	private SelectOneMenu txtAportesNominaLiquidan;
	private InputNumber txtTopeSmlCotizarEps;
	private InputNumber txtTopeSmlCotizarAfp;
	private InputNumber txtTopeSmlCotizarArl;
	private SelectOneMenu txtAuxilioTransporteLiquidan;
	private InputNumber txtPorcAporteEpsTrabajador;
	private InputNumber txtPorcAporteAfpTrabajador;
	private InputNumber txtPorcAporteFspTrabajador;
	private InputNumber txtMinimoSmlAportaFsp;
	
	private InputNumber txtDevengoMinimoDiario;
	
	
	public CompaniaView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedCompania = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCompania = null;
		activeTapIndex = 0;
		PrimeFaces.current().resetInputs(":dialogCompania :frm");

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtDevengoMinimoDiario != null) {
			txtDevengoMinimoDiario.setValue(null);
			txtDevengoMinimoDiario.setDisabled(true);
		}

		if (txtConceptoAuxTransporte != null) {
			txtConceptoAuxTransporte.setValue(null);
			txtConceptoAuxTransporte.setDisabled(false);
		}
		
		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue("A");
			txtEstado.setDisabled(true);
		}

		if (txtEstadoKml != null) {
			txtEstadoKml.setValue("I");
			txtEstadoKml.setDisabled(true);
		}

		if (txtUrlKml != null) {
			txtUrlKml.setValue("N/A");
			txtUrlKml.setDisabled(true);
		}

		if (txtInfoAdicional != null) {
			txtInfoAdicional.setValue(null);
			txtInfoAdicional.setDisabled(true);
		}
		
		if (txtNivelAutorizaLabor != null) {
			txtNivelAutorizaLabor.setValue(null);
			txtNivelAutorizaLabor.setDisabled(true);
		}
		
		if (txtInfoAdicional2 != null) {
			txtInfoAdicional2.setValue(null);
			txtInfoAdicional2.setDisabled(true);
		}

		if (txtLatitud != null) {
			txtLatitud.setValue("0.0");
			txtLatitud.setDisabled(true);
		}

		if (txtLongitud != null) {
			txtLongitud.setValue("0.0");
			txtLongitud.setDisabled(true);
		}
		
		if (txtPrecision != null) {
			txtPrecision.setValue(null);
			txtPrecision.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtPbx != null) {
			txtPbx.setValue(null);
			txtPbx.setDisabled(true);
		}

		if (txtRut != null) {
			txtRut.setValue(null);
			txtRut.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtCiudadId_Ciudad != null) {
			txtCiudadId_Ciudad.setValue(null);
			txtCiudadId_Ciudad.setDisabled(true);
		}

		if (txtEntBancId_EntBanc != null) {
			txtEntBancId_EntBanc.setValue(null);
			txtEntBancId_EntBanc.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtCompaniaId != null) {
			txtCompaniaId.setValue(null);
			txtCompaniaId.setDisabled(false);
		}
		
		if (txtAnioCurso != null) {
        	Date date = new Date();
            txtAnioCurso.setValue(date);
            txtAnioCurso.setDisabled(false);
        }
		
        if (txtAuxilioMovilizacion != null) {
            txtAuxilioMovilizacion.setValue(null);
            txtAuxilioMovilizacion.setDisabled(true);
        }

        if (txtCodigoEntredas != null) {
            txtCodigoEntredas.setValue(null);
            txtCodigoEntredas.setDisabled(true);
        }

        if (txtCodigoGastoCmb != null) {
            txtCodigoGastoCmb.setValue(null);
            txtCodigoGastoCmb.setDisabled(true);
        }

        if (txtCodigoGastoNomina != null) {
            txtCodigoGastoNomina.setValue(null);
            txtCodigoGastoNomina.setDisabled(true);
        }

        if (txtConsecutivoCajaMenor != null) {
            txtConsecutivoCajaMenor.setValue(null);
            txtConsecutivoCajaMenor.setDisabled(true);
        }

        if (txtConsecutivoCotizacion != null) {
            txtConsecutivoCotizacion.setValue(null);
            txtConsecutivoCotizacion.setDisabled(true);
        }

        if (txtConsecutivoEntradas != null) {
            txtConsecutivoEntradas.setValue(null);
            txtConsecutivoEntradas.setDisabled(true);
        }

        if (txtConsecutivoFacturaCali != null) {
            txtConsecutivoFacturaCali.setValue(null);
            txtConsecutivoFacturaCali.setDisabled(true);
        }

        if (txtConsecutivoFacturaRozo != null) {
            txtConsecutivoFacturaRozo.setValue(null);
            txtConsecutivoFacturaRozo.setDisabled(true);
        }

        if (txtConsecutivoGastos != null) {
            txtConsecutivoGastos.setValue(null);
            txtConsecutivoGastos.setDisabled(true);
        }

        if (txtConsecutivoGastosoperacion != null) {
            txtConsecutivoGastosoperacion.setValue(null);
            txtConsecutivoGastosoperacion.setDisabled(true);
        }

        if (txtConsecutivoOrdCompras != null) {
            txtConsecutivoOrdCompras.setValue(null);
            txtConsecutivoOrdCompras.setDisabled(true);
        }

        if (txtConsecutivoPrefactura != null) {
            txtConsecutivoPrefactura.setValue(null);
            txtConsecutivoPrefactura.setDisabled(true);
        }

        if (txtConsecutivoSalidas != null) {
            txtConsecutivoSalidas.setValue(null);
            txtConsecutivoSalidas.setDisabled(true);
        }

        if (txtConsecutivoTraslados != null) {
            txtConsecutivoTraslados.setValue(null);
            txtConsecutivoTraslados.setDisabled(true);
        }

        if (txtDesFiscal != null) {
            txtDesFiscal.setValue(null);
            txtDesFiscal.setDisabled(true);
        }

        if (txtEmail != null) {
            txtEmail.setValue(null);
            txtEmail.setDisabled(true);
        }

        if (txtImprimeFactura != null) {
            txtImprimeFactura.setValue(null);
            txtImprimeFactura.setDisabled(true);
        }

        if (txtPrefijo != null) {
            txtPrefijo.setValue(null);
            txtPrefijo.setDisabled(true);
        }

        if (txtResolucion != null) {
            txtResolucion.setValue(null);
            txtResolucion.setDisabled(true);
        }

        if (txtSubtitulo != null) {
            txtSubtitulo.setValue(null);
            txtSubtitulo.setDisabled(true);
        }

		if (txtKardexEntradaEstandar != null) {
			txtKardexEntradaEstandar.setValue(null);
			txtKardexEntradaEstandar.setDisabled(true);
		}

		if (txtKardexSalidaEstandar != null) {
			txtKardexSalidaEstandar.setValue(null);
			txtKardexSalidaEstandar.setDisabled(true);
		}

		if (txtValorUvt != null) {
			txtValorUvt.setValue(null);
			txtValorUvt.setDisabled(true);
		}

		if (txtSalarioMinimoLegal != null) {
			txtSalarioMinimoLegal.setValue(null);
			txtSalarioMinimoLegal.setDisabled(true);
		}

		if (txtTopeSmlAuxTransporte != null) {
			txtTopeSmlAuxTransporte.setValue(null);
			txtTopeSmlAuxTransporte.setDisabled(true);
		}

		if (txtRentasExentasUvt != null) {
			txtRentasExentasUvt.setValue(null);
			txtRentasExentasUvt.setDisabled(true);
		}

		if (txtPorcMinContribucion != null) {
			txtPorcMinContribucion.setValue(null);
			txtPorcMinContribucion.setDisabled(true);
		}

		if (txtIpc != null) {
			txtIpc.setValue(null);
			txtIpc.setDisabled(true);
		}

		if (txtAuxilioTransporte != null) {
			txtAuxilioTransporte.setValue(null);
			txtAuxilioTransporte.setDisabled(true);
		}

		if (txtPorcRentasExternas != null) {
			txtPorcRentasExternas.setValue(null);
			txtPorcRentasExternas.setDisabled(true);
		}

		if (txtPorcLey1927 != null) {
			txtPorcLey1927.setValue(null);
			txtPorcLey1927.setDisabled(true);
		}

		if (txtTarifaIvaRetenido != null) {
			txtTarifaIvaRetenido.setValue(null);
			txtTarifaIvaRetenido.setDisabled(true);
		}

		if (txtPorcProvisionCesantias != null) {
			txtPorcProvisionCesantias.setValue(null);
			txtPorcProvisionCesantias.setDisabled(true);
		}

		if (txtPorcProvisionPrimas != null) {
			txtPorcProvisionPrimas.setValue(null);
			txtPorcProvisionPrimas.setDisabled(true);
		}

		if (txtPorcProvisionVacaciones != null) {
			txtPorcProvisionVacaciones.setValue(null);
			txtPorcProvisionVacaciones.setDisabled(true);
		}

		if (txtPorcProvisionInteresesCesantias != null) {
			txtPorcProvisionInteresesCesantias.setValue(null);
			txtPorcProvisionInteresesCesantias.setDisabled(true);
		}

		if (txtPorcAporteEpsEmpleador != null) {
			txtPorcAporteEpsEmpleador.setValue(null);
			txtPorcAporteEpsEmpleador.setDisabled(true);
		}

		if (txtPorcAporteAfpAltoRiesgoEmpleador != null) {
			txtPorcAporteAfpAltoRiesgoEmpleador.setValue(null);
			txtPorcAporteAfpAltoRiesgoEmpleador.setDisabled(true);
		}

		if (txtPorcAporteIcbfEmpleador != null) {
			txtPorcAporteIcbfEmpleador.setValue(null);
			txtPorcAporteIcbfEmpleador.setDisabled(true);
		}

		if (txtPorcAporteAfpEmpleador != null) {
			txtPorcAporteAfpEmpleador.setValue(null);
			txtPorcAporteAfpEmpleador.setDisabled(true);
		}

		if (txtPorcAporteCcfEmpleador != null) {
			txtPorcAporteCcfEmpleador.setValue(null);
			txtPorcAporteCcfEmpleador.setDisabled(true);
		}

		if (txtPorcAporteSenaEmpleador != null) {
			txtPorcAporteSenaEmpleador.setValue(null);
			txtPorcAporteSenaEmpleador.setDisabled(true);
		}

		if (txtMinimoSmlAporteSenaIcbf != null) {
			txtMinimoSmlAporteSenaIcbf.setValue(null);
			txtMinimoSmlAporteSenaIcbf.setDisabled(true);
		}

		if (txtAportesNominaLiquidan != null) {
			txtAportesNominaLiquidan.setValue(null);
			txtAportesNominaLiquidan.setDisabled(true);
		}

		if (txtTopeSmlCotizarEps != null) {
			txtTopeSmlCotizarEps.setValue(null);
			txtTopeSmlCotizarEps.setDisabled(true);
		}

		if (txtTopeSmlCotizarAfp != null) {
			txtTopeSmlCotizarAfp.setValue(null);
			txtTopeSmlCotizarAfp.setDisabled(true);
		}

		if (txtTopeSmlCotizarArl != null) {
			txtTopeSmlCotizarArl.setValue(null);
			txtTopeSmlCotizarArl.setDisabled(true);
		}

		if (txtAuxilioTransporteLiquidan != null) {
			txtAuxilioTransporteLiquidan.setValue(null);
			txtAuxilioTransporteLiquidan.setDisabled(true);
		}

		if (txtPorcAporteEpsTrabajador != null) {
			txtPorcAporteEpsTrabajador.setValue(null);
			txtPorcAporteEpsTrabajador.setDisabled(true);
		}

		if (txtPorcAporteAfpTrabajador != null) {
			txtPorcAporteAfpTrabajador.setValue(null);
			txtPorcAporteAfpTrabajador.setDisabled(true);
		}

		if (txtPorcAporteFspTrabajador != null) {
			txtPorcAporteFspTrabajador.setValue(null);
			txtPorcAporteFspTrabajador.setDisabled(true);
		}

		if (txtMinimoSmlAportaFsp != null) {
			txtMinimoSmlAportaFsp.setValue(null);
			txtMinimoSmlAportaFsp.setDisabled(true);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}
		
		return "";
	}

	public void mapDefault() {

		simpleModel = new DefaultMapModel();
		LatLng coord = new LatLng(4.086665, -76.188064);
		centerRevGeoMap = coord.getLat() + "," + coord.getLng();
		simpleModel.addOverlay(new Marker(coord, "Empresa"));

	}

	public void mapaCompania(double latitude, double longitude, String nombre) {

		if (latitude != 0.0 && longitude != 0.0) {
			simpleModel = new DefaultMapModel();
			LatLng coord1 = new LatLng(latitude, longitude);
			centerRevGeoMap = coord1.getLat() + "," + coord1.getLng();
			simpleModel.addOverlay(new Marker(coord1, nombre));
			
		} else {
			mapDefault();
		}
	}

	public void listener_txtCodigo() {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Compania> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCompania(condicion, null, null) : null;

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
			txtDireccion.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);			
			// txtLatitud.setDisabled(false);
			// txtLongitud.setDisabled(false);
			// txtPrecision.setDisabled(false);
			txtNombre.setDisabled(false);
			txtPbx.setDisabled(false);
			// txtEstadoKml.setDisabled(false);
			// txtUrlKml.setDisabled(true);
			txtRut.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtCiudadId_Ciudad.setDisabled(false);
			txtEntBancId_EntBanc.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtCompaniaId.setDisabled(false);
			btnSave.setDisabled(false);			
			
			txtDevengoMinimoDiario.setDisabled(false);
			
	        if (txtConsecutivoFacturaCali != null) {
	            txtConsecutivoFacturaCali.setValue(null);
	            txtConsecutivoFacturaCali.setDisabled(false);
	        }

	        if (txtConsecutivoPrefactura != null) {
	            txtConsecutivoPrefactura.setValue(null);
	            txtConsecutivoPrefactura.setDisabled(false);
	        }

	        if (txtEmail != null) {
	            txtEmail.setValue(null);
	            txtEmail.setDisabled(false);
	        }

	        if (txtImprimeFactura != null) {
	            txtImprimeFactura.setValue(null);
	            txtImprimeFactura.setDisabled(false);
	        }

	        if (txtPrefijo != null) {
	            txtPrefijo.setValue(null);
	            txtPrefijo.setDisabled(false);
	        }

	        if (txtResolucion != null) {
	            txtResolucion.setValue(null);
	            txtResolucion.setDisabled(false);
	        }

	        if (txtSubtitulo != null) {
	            txtSubtitulo.setValue(null);
	            txtSubtitulo.setDisabled(false);
	        }
	        
	    	txtKardexEntradaEstandar.setDisabled(false);
			txtKardexSalidaEstandar.setDisabled(false);

			txtValorUvt.setDisabled(false);
			txtSalarioMinimoLegal.setDisabled(false);
			txtTopeSmlAuxTransporte.setDisabled(false);
			txtRentasExentasUvt.setDisabled(false);
			txtPorcMinContribucion.setDisabled(false);
			txtIpc.setDisabled(false);
			txtAuxilioTransporte.setDisabled(false);
			txtPorcRentasExternas.setDisabled(false);
			txtPorcLey1927.setDisabled(false);
			txtTarifaIvaRetenido.setDisabled(false);
			txtPorcProvisionCesantias.setDisabled(false);
			txtPorcProvisionPrimas.setDisabled(false);
			txtPorcProvisionVacaciones.setDisabled(false);
			txtPorcProvisionInteresesCesantias.setDisabled(false);
			txtPorcAporteEpsEmpleador.setDisabled(false);
			txtPorcAporteAfpAltoRiesgoEmpleador.setDisabled(false);
			txtPorcAporteIcbfEmpleador.setDisabled(false);
			txtPorcAporteAfpEmpleador.setDisabled(false);
			txtPorcAporteCcfEmpleador.setDisabled(false);
			txtPorcAporteSenaEmpleador.setDisabled(false);
			txtMinimoSmlAporteSenaIcbf.setDisabled(false);
			txtAportesNominaLiquidan.setDisabled(false);
			txtTopeSmlCotizarEps.setDisabled(false);
			txtTopeSmlCotizarAfp.setDisabled(false);
			txtTopeSmlCotizarArl.setDisabled(false);
			txtAuxilioTransporteLiquidan.setDisabled(false);
			txtPorcAporteEpsTrabajador.setDisabled(false);
			txtPorcAporteAfpTrabajador.setDisabled(false);
			txtPorcAporteFspTrabajador.setDisabled(false);
			txtMinimoSmlAportaFsp.setDisabled(false);

		} else {
			
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);			
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			// txtFechaCreacion.setValue(entity.getFechaCreacion());
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setValue(entity.getFechaModificacion());
			// txtFechaModificacion.setDisabled(false);
			txtInfoAdicional.setValue(entity.getInfoAdicional());
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setValue(entity.getInfoAdicional2());
			txtInfoAdicional2.setDisabled(false);
			// txtLatitud.setValue(entity.getLatitud());
			// txtLatitud.setDisabled(false);
			// txtLongitud.setValue(entity.getLongitud());
			// txtLongitud.setDisabled(false);
			// txtPrecision.setValue(entity.getPrecision());
			// txtPrecision.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtPbx.setValue(entity.getPbx());
			txtPbx.setDisabled(false);
			txtRut.setValue(entity.getRut());
			txtRut.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			// txtEstadoKml.setValue(entity.getEstado_kml());
			/*
			 * txtEstadoKml.setDisabled(false);
			 * 
			 * if(entity.getEstado_kml().equals("A") ){
			 * txtUrlKml.setValue(entity.getUrl_kml());
			 * txtUrlKml.setDisabled(false); }else{ txtUrlKml.setDisabled(true);
			 * txtUrlKml.setValue("N/A"); }
			 * 
			 * 
			 * if(entity.getLatitud() != null && entity.getLongitud() != null ){
			 * 
			 * mapaCompania(entity.getLatitud(), entity.getLongitud(),
			 * entity.getNombre());
			 * 
			 * }else{
			 * 
			 * mapDefault(); }
			 */
			txtCiudadId_Ciudad.setValue(entity.getCiudad());
			txtCiudadId_Ciudad.setDisabled(false);
			txtEntBancId_EntBanc.setValue(entity.getEntBanc());
			txtEntBancId_EntBanc.setDisabled(false);
			txtCompaniaId.setValue(entity.getCompaniaId());
			txtCompaniaId.setDisabled(true);						
            txtConsecutivoFacturaCali.setValue(entity.getConsecutivoFacturaCali());
            txtConsecutivoFacturaCali.setDisabled(false);     
            txtConsecutivoPrefactura.setValue(entity.getConsecutivoPrefactura());
            txtConsecutivoPrefactura.setDisabled(false);
            txtDesFiscal.setValue(entity.getDesFiscal());
            txtDesFiscal.setDisabled(false);            
            txtEmail.setValue(entity.getEmail());
            txtEmail.setDisabled(false);            
            txtImprimeFactura.setValue(entity.getImprimeFactura());
            txtImprimeFactura.setDisabled(false);

            txtPrefijo.setValue(entity.getPrefijo());
            txtPrefijo.setDisabled(false);
            txtResolucion.setValue(entity.getResolucion());
            txtResolucion.setDisabled(false);
            txtSubtitulo.setValue(entity.getSubtitulo());
            txtSubtitulo.setDisabled(false);
			txtKardexEntradaEstandar.setValue(entity.getKardexEntradaEstandar() != null ? entity.getKardexEntradaEstandar() : null);
			txtKardexEntradaEstandar.setDisabled(false);			
			txtKardexSalidaEstandar.setValue(entity.getKardexSalidaEstandar() != null ? entity.getKardexSalidaEstandar() : null);
			txtKardexSalidaEstandar.setDisabled(false);

			txtValorUvt.setValue(entity.getValorUvt());
			txtValorUvt.setDisabled(false);
			txtSalarioMinimoLegal.setValue(entity.getSalarioMinimoLegal());
			txtSalarioMinimoLegal.setDisabled(false);
			txtTopeSmlAuxTransporte.setValue(entity.getTopeSmlAuxTransporte());
			txtTopeSmlAuxTransporte.setDisabled(false);
			txtRentasExentasUvt.setValue(entity.getRentasExentasUvt());
			txtRentasExentasUvt.setDisabled(false);			
			txtPorcMinContribucion.setValue(entity.getPorcMinContribucion());
			txtPorcMinContribucion.setDisabled(false);
			txtIpc.setValue(entity.getIpc());
			txtIpc.setDisabled(false);
			txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());
			txtAuxilioTransporte.setDisabled(false);			
			txtPorcRentasExternas.setValue(entity.getPorcRentasExternas());
			txtPorcRentasExternas.setDisabled(false);
			txtPorcLey1927.setValue(entity.getPorcLey1527());
			txtPorcLey1927.setDisabled(false);
			txtTarifaIvaRetenido.setValue(entity.getTarifaIvaRetenido());
			txtTarifaIvaRetenido.setDisabled(false);
			txtPorcProvisionCesantias.setValue(entity.getPorcProvisionCesantias());
			txtPorcProvisionCesantias.setDisabled(false);
			txtPorcProvisionPrimas.setValue(entity.getPorcProvisionPrimas());
			txtPorcProvisionPrimas.setDisabled(false);
			txtPorcProvisionVacaciones.setValue(entity.getPorcProvisionVacaciones());
			txtPorcProvisionVacaciones.setDisabled(false);
			txtPorcProvisionInteresesCesantias.setValue(entity.getPorcProvisionInteresesCesantias());
			txtPorcProvisionInteresesCesantias.setDisabled(false);
			txtPorcAporteEpsEmpleador.setValue(entity.getPorcAporteEpsEmpleador());
			txtPorcAporteEpsEmpleador.setDisabled(false);
			txtPorcAporteAfpAltoRiesgoEmpleador.setValue(entity.getPorcAporteAfpAltoRiesgoEmpleador());
			txtPorcAporteAfpAltoRiesgoEmpleador.setDisabled(false);
			txtPorcAporteIcbfEmpleador.setValue(entity.getPorcAporteIcbfEmpleador());
			txtPorcAporteIcbfEmpleador.setDisabled(false);
			txtPorcAporteAfpEmpleador.setValue(entity.getPorcAporteAfpEmpleador());
			txtPorcAporteAfpEmpleador.setDisabled(false);			
			txtPorcAporteCcfEmpleador.setValue(entity.getPorcAporteCcfEmpleador());
			txtPorcAporteCcfEmpleador.setDisabled(false);
			txtPorcAporteSenaEmpleador.setValue(entity.getPorcAporteSenaEmpleador());
			txtPorcAporteSenaEmpleador.setDisabled(false);
			txtMinimoSmlAporteSenaIcbf.setValue(entity.getMinimoSmlAporteSenaIcbf());
			txtMinimoSmlAporteSenaIcbf.setDisabled(false);
			txtAportesNominaLiquidan.setValue(entity.getAportesNominaLiquidan());
			txtAportesNominaLiquidan.setDisabled(false);
			txtTopeSmlCotizarEps.setValue(entity.getTopeSmlCotizarEps());			
			txtTopeSmlCotizarEps.setDisabled(false);
			txtTopeSmlCotizarAfp.setValue(entity.getTopeSmlCotizarAfp());
			txtTopeSmlCotizarAfp.setDisabled(false);
			txtTopeSmlCotizarArl.setValue(entity.getTopeSmlCotizarArl());
			txtTopeSmlCotizarArl.setDisabled(false);
			txtAuxilioTransporteLiquidan.setValue(entity.getAuxilioTransporteLiquidan());
			txtAuxilioTransporteLiquidan.setDisabled(false);
			txtPorcAporteEpsTrabajador.setValue(entity.getPorcAporteEpsTrabajador());
			txtPorcAporteEpsTrabajador.setDisabled(false);
			txtPorcAporteAfpTrabajador.setValue(entity.getPorcAporteAfpTrabajador());
			txtPorcAporteAfpTrabajador.setDisabled(false);
			txtPorcAporteFspTrabajador.setValue(entity.getPorcAporteFspTrabajador());
			txtPorcAporteFspTrabajador.setDisabled(false);
			txtMinimoSmlAportaFsp.setValue(entity.getMinimoSmlAportaFSP());
			txtMinimoSmlAportaFsp.setDisabled(false);
			
			txtDevengoMinimoDiario.setValue(entity.getDevengoMinimoDiario());
			txtDevengoMinimoDiario.setDisabled(false);
			
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCompania = (CompaniaDTO) (evt.getComponent().getAttributes().get("selectedCompania"));

		PrimeFaces.current().resetInputs(":dialogCompania :frm");


		try {

			String codigo = selectedCompania.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<Compania> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInCompania(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				txtDireccion.setValue(entity.getDireccion());
				txtDireccion.setDisabled(false);				
				txtEstado.setValue(entity.getEstado());
				txtEstado.setDisabled(false);
				// txtFechaCreacion.setValue(entity.getFechaCreacion());
				// txtFechaCreacion.setDisabled(false);
				// txtFechaModificacion.setValue(entity.getFechaModificacion());
				// txtFechaModificacion.setDisabled(false);
				txtInfoAdicional.setValue(entity.getInfoAdicional());
				txtInfoAdicional.setDisabled(false);
				txtInfoAdicional2.setValue(entity.getInfoAdicional2());
				txtInfoAdicional2.setDisabled(false);
				// txtLatitud.setValue(entity.getLatitud());
				// txtLatitud.setDisabled(false);
				// txtLongitud.setValue(entity.getLongitud());
				// txtLongitud.setDisabled(false);
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtPbx.setValue(entity.getPbx());
				txtPbx.setDisabled(false);
				// txtPrecision.setValue(entity.getPrecision());
				// txtPrecision.setDisabled(false);
				txtRut.setValue(entity.getRut());
				txtRut.setDisabled(false);
				txtTelefono.setValue(entity.getTelefono());
				txtTelefono.setDisabled(false);
				/*
				 * txtEstadoKml.setValue(entity.getEstado_kml());
				 * txtEstadoKml.setDisabled(false);
				 * 
				 * if(entity.getEstado_kml().equals("A") ){
				 * txtUrlKml.setValue(entity.getUrl_kml());
				 * txtUrlKml.setDisabled(false); }else{
				 * txtUrlKml.setDisabled(true); txtUrlKml.setValue("N/A"); }
				 * 
				 * if(entity.getLatitud() != null && entity.getLongitud() !=
				 * null ){ mapaCompania(entity.getLatitud(),
				 * entity.getLongitud(), entity.getNombre()); }else{
				 * 
				 * mapDefault(); }
				 * 
				 * urlKmlMap = entity.getUrl_kml().toString(); hayKml =
				 * entity.getEstado_kml();
				 */
				txtCiudadId_Ciudad.setValue(entity.getCiudad());
				txtCiudadId_Ciudad.setDisabled(false);
				txtEntBancId_EntBanc.setValue(entity.getEntBanc());
				txtEntBancId_EntBanc.setDisabled(false);
				txtCompaniaId.setValue(entity.getCompaniaId());
				txtCompaniaId.setDisabled(true);

	            txtConsecutivoFacturaCali.setValue(entity.getConsecutivoFacturaCali());
	            txtConsecutivoFacturaCali.setDisabled(false);
	            txtConsecutivoPrefactura.setValue(entity.getConsecutivoPrefactura());
	            txtConsecutivoPrefactura.setDisabled(false);
	            txtDesFiscal.setValue(entity.getDesFiscal());
	            txtDesFiscal.setDisabled(false);
	            
	            txtEmail.setValue(entity.getEmail());
	            txtEmail.setDisabled(false);
	            
	            txtImprimeFactura.setValue(entity.getImprimeFactura());
	            txtImprimeFactura.setDisabled(false);

	            txtPrefijo.setValue(entity.getPrefijo());
	            txtPrefijo.setDisabled(false);
	            txtResolucion.setValue(entity.getResolucion());
	            txtResolucion.setDisabled(false);
	            txtSubtitulo.setValue(entity.getSubtitulo());
	            txtSubtitulo.setDisabled(false);
				txtKardexEntradaEstandar.setValue(entity.getKardexEntradaEstandar() != null ? entity.getKardexEntradaEstandar() : null);
				txtKardexEntradaEstandar.setDisabled(false);			
				txtKardexSalidaEstandar.setValue(entity.getKardexSalidaEstandar() != null ? entity.getKardexSalidaEstandar() : null);
				txtKardexSalidaEstandar.setDisabled(false);

				txtValorUvt.setValue(entity.getValorUvt());
				txtValorUvt.setDisabled(false);
				txtSalarioMinimoLegal.setValue(entity.getSalarioMinimoLegal());
				txtSalarioMinimoLegal.setDisabled(false);
				txtTopeSmlAuxTransporte.setValue(entity.getTopeSmlAuxTransporte());
				txtTopeSmlAuxTransporte.setDisabled(false);
				txtRentasExentasUvt.setValue(entity.getRentasExentasUvt());
				txtRentasExentasUvt.setDisabled(false);			
				txtPorcMinContribucion.setValue(entity.getPorcMinContribucion());
				txtPorcMinContribucion.setDisabled(false);
				txtIpc.setValue(entity.getIpc());
				txtIpc.setDisabled(false);
				txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());
				txtAuxilioTransporte.setDisabled(false);			
				txtPorcRentasExternas.setValue(entity.getPorcRentasExternas());
				txtPorcRentasExternas.setDisabled(false);
				txtPorcLey1927.setValue(entity.getPorcLey1527());
				txtPorcLey1927.setDisabled(false);
				txtTarifaIvaRetenido.setValue(entity.getTarifaIvaRetenido());
				txtTarifaIvaRetenido.setDisabled(false);
				txtPorcProvisionCesantias.setValue(entity.getPorcProvisionCesantias());
				txtPorcProvisionCesantias.setDisabled(false);
				txtPorcProvisionPrimas.setValue(entity.getPorcProvisionPrimas());
				txtPorcProvisionPrimas.setDisabled(false);
				txtPorcProvisionVacaciones.setValue(entity.getPorcProvisionVacaciones());
				txtPorcProvisionVacaciones.setDisabled(false);
				txtPorcProvisionInteresesCesantias.setValue(entity.getPorcProvisionInteresesCesantias());
				txtPorcProvisionInteresesCesantias.setDisabled(false);
				txtPorcAporteEpsEmpleador.setValue(entity.getPorcAporteEpsEmpleador());
				txtPorcAporteEpsEmpleador.setDisabled(false);
				txtPorcAporteAfpAltoRiesgoEmpleador.setValue(entity.getPorcAporteAfpAltoRiesgoEmpleador());
				txtPorcAporteAfpAltoRiesgoEmpleador.setDisabled(false);
				txtPorcAporteIcbfEmpleador.setValue(entity.getPorcAporteIcbfEmpleador());
				txtPorcAporteIcbfEmpleador.setDisabled(false);
				txtPorcAporteAfpEmpleador.setValue(entity.getPorcAporteAfpEmpleador());
				txtPorcAporteAfpEmpleador.setDisabled(false);			
				txtPorcAporteCcfEmpleador.setValue(entity.getPorcAporteCcfEmpleador());
				txtPorcAporteCcfEmpleador.setDisabled(false);
				txtPorcAporteSenaEmpleador.setValue(entity.getPorcAporteSenaEmpleador());
				txtPorcAporteSenaEmpleador.setDisabled(false);
				txtMinimoSmlAporteSenaIcbf.setValue(entity.getMinimoSmlAporteSenaIcbf());
				txtMinimoSmlAporteSenaIcbf.setDisabled(false);
				txtAportesNominaLiquidan.setValue(entity.getAportesNominaLiquidan());
				txtAportesNominaLiquidan.setDisabled(false);
				txtTopeSmlCotizarEps.setValue(entity.getTopeSmlCotizarEps());			
				txtTopeSmlCotizarEps.setDisabled(false);
				txtTopeSmlCotizarAfp.setValue(entity.getTopeSmlCotizarAfp());
				txtTopeSmlCotizarAfp.setDisabled(false);
				txtTopeSmlCotizarArl.setValue(entity.getTopeSmlCotizarArl());
				txtTopeSmlCotizarArl.setDisabled(false);
				txtAuxilioTransporteLiquidan.setValue(entity.getAuxilioTransporteLiquidan());
				txtAuxilioTransporteLiquidan.setDisabled(false);
				txtPorcAporteEpsTrabajador.setValue(entity.getPorcAporteEpsTrabajador());
				txtPorcAporteEpsTrabajador.setDisabled(false);
				txtPorcAporteAfpTrabajador.setValue(entity.getPorcAporteAfpTrabajador());
				txtPorcAporteAfpTrabajador.setDisabled(false);
				txtPorcAporteFspTrabajador.setValue(entity.getPorcAporteFspTrabajador());
				txtPorcAporteFspTrabajador.setDisabled(false);	
				txtMinimoSmlAportaFsp.setValue(entity.getMinimoSmlAportaFSP());
				txtMinimoSmlAportaFsp.setDisabled(false);			
				txtDevengoMinimoDiario.setValue(entity.getDevengoMinimoDiario());
				txtDevengoMinimoDiario.setDisabled(false);
				
				
				btnSave.setDisabled(false);
				activeTapIndex = 0;
				setShowDialog(true);

			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCompania == null) && (entity == null)) {
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
			entity = new Compania();
			Date date = new Date();

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			entity.setEstadoKml(FacesUtils.checkString(txtEstadoKml));			
			entity.setUrlKml(FacesUtils.checkString(txtUrlKml));			
			entity.setConceptoAuxTransporte(FacesUtils.checkLong(txtConceptoAuxTransporte));			
			entity.setNivelAutorizaLabor(FacesUtils.checkString(txtNivelAutorizaLabor));			
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setRut(FacesUtils.checkString(txtRut));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));
			entity.setEntBanc((FacesUtils.checkLong(txtEntBancId_EntBanc)));
			
		    entity.setAnioCurso(FacesUtils.checkLong(txtAnioCurso));
            entity.setAuxilioMovilizacion(FacesUtils.checkDouble(txtAuxilioMovilizacion));
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setCodigoEntredas(FacesUtils.checkString(txtCodigoEntredas));
            entity.setCodigoGastoCmb(FacesUtils.checkLong(txtCodigoGastoCmb));
            entity.setCodigoGastoNomina(FacesUtils.checkLong(txtCodigoGastoNomina));
            entity.setConsecutivoCajaMenor(FacesUtils.checkLong(txtConsecutivoCajaMenor));
            entity.setConsecutivoCotizacion(FacesUtils.checkLong(txtConsecutivoCotizacion));
            entity.setConsecutivoEntradas(FacesUtils.checkLong(txtConsecutivoEntradas));
            entity.setConsecutivoFacturaCali(FacesUtils.checkLong(txtConsecutivoFacturaCali));
            entity.setConsecutivoFacturaRozo(FacesUtils.checkLong(txtConsecutivoFacturaRozo));
            entity.setConsecutivoGastos(FacesUtils.checkLong(txtConsecutivoGastos));
            entity.setConsecutivoGastosoperacion(FacesUtils.checkLong(txtConsecutivoGastosoperacion));
            entity.setConsecutivoOrdCompras(FacesUtils.checkLong(txtConsecutivoOrdCompras));
            entity.setConsecutivoPrefactura(FacesUtils.checkLong(txtConsecutivoPrefactura));
            entity.setConsecutivoSalidas(FacesUtils.checkLong(txtConsecutivoSalidas));
            entity.setConsecutivoTraslados(FacesUtils.checkLong(txtConsecutivoTraslados));
            entity.setDesFiscal(FacesUtils.checkString(txtDesFiscal));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setImprimeFactura(FacesUtils.checkString(txtImprimeFactura));
            entity.setPrefijo(FacesUtils.checkString(txtPrefijo));
            entity.setResolucion(FacesUtils.checkString(txtResolucion));
            entity.setSubtitulo(FacesUtils.checkString(txtSubtitulo));    	
			entity.setKardexSalidaEstandar(FacesUtils.checkLong(txtKardexSalidaEstandar));
			entity.setKardexEntradaEstandar(FacesUtils.checkLong(txtKardexEntradaEstandar));
			
			entity.setValorUvt(FacesUtils.checkDouble(txtValorUvt));
			entity.setSalarioMinimoLegal(FacesUtils.checkDouble(txtSalarioMinimoLegal));
			entity.setTopeSmlAuxTransporte(FacesUtils.checkDouble(txtTopeSmlAuxTransporte));
			entity.setRentasExentasUvt(FacesUtils.checkDouble(txtRentasExentasUvt));
			entity.setPorcMinContribucion(FacesUtils.checkDouble(txtPorcMinContribucion));
			entity.setIpc(FacesUtils.checkDouble(txtIpc));
			entity.setAuxilioTransporte(FacesUtils.checkDouble(txtAuxilioTransporte));
			entity.setPorcRentasExternas(FacesUtils.checkDouble(txtPorcRentasExternas));
			entity.setPorcLey1527(FacesUtils.checkDouble(txtPorcLey1927));
			entity.setTarifaIvaRetenido(FacesUtils.checkDouble(txtTarifaIvaRetenido));
			entity.setPorcProvisionCesantias(FacesUtils.checkDouble(txtPorcProvisionCesantias));
			entity.setPorcProvisionPrimas(FacesUtils.checkDouble(txtPorcProvisionPrimas));
			entity.setPorcProvisionVacaciones(FacesUtils.checkDouble(txtPorcProvisionVacaciones));
			entity.setPorcProvisionInteresesCesantias(FacesUtils.checkDouble(txtPorcProvisionInteresesCesantias));
			entity.setPorcAporteEpsEmpleador(FacesUtils.checkDouble(txtPorcAporteEpsEmpleador));
			entity.setPorcAporteAfpAltoRiesgoEmpleador(FacesUtils.checkDouble(txtPorcAporteAfpAltoRiesgoEmpleador));
			entity.setPorcAporteIcbfEmpleador(FacesUtils.checkDouble(txtPorcAporteIcbfEmpleador));
			entity.setPorcAporteAfpEmpleador(FacesUtils.checkDouble(txtPorcAporteAfpEmpleador));
			entity.setPorcAporteCcfEmpleador(FacesUtils.checkDouble(txtPorcAporteCcfEmpleador));
			entity.setPorcAporteSenaEmpleador(FacesUtils.checkDouble(txtPorcAporteSenaEmpleador));
			entity.setMinimoSmlAporteSenaIcbf(FacesUtils.checkDouble(txtMinimoSmlAporteSenaIcbf));
			entity.setAportesNominaLiquidan(FacesUtils.checkString(txtAportesNominaLiquidan));
			entity.setTopeSmlCotizarEps(FacesUtils.checkDouble(txtTopeSmlCotizarEps));
			entity.setTopeSmlCotizarAfp(FacesUtils.checkDouble(txtTopeSmlCotizarAfp));
			entity.setTopeSmlCotizarArl(FacesUtils.checkDouble(txtTopeSmlCotizarArl));
			entity.setAuxilioTransporteLiquidan(FacesUtils.checkString(txtAuxilioTransporteLiquidan));
			entity.setPorcAporteEpsTrabajador(FacesUtils.checkDouble(txtPorcAporteEpsTrabajador));
			entity.setPorcAporteAfpTrabajador(FacesUtils.checkDouble(txtPorcAporteAfpTrabajador));
			entity.setPorcAporteFspTrabajador(FacesUtils.checkDouble(txtPorcAporteFspTrabajador));
			entity.setMinimoSmlAportaFSP(FacesUtils.checkDouble(txtMinimoSmlAportaFsp));
			entity.setDevengoMinimoDiario(FacesUtils.checkDouble(txtDevengoMinimoDiario));
			businessDelegatorView.saveCompania(entity);
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
				Long companiaId = new Long(selectedCompania.getCompaniaId());
				entity = businessDelegatorView.getCompania(companiaId);
			}
			Date date = new Date();
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoKml(FacesUtils.checkString(txtEstadoKml));
			entity.setUrlKml(FacesUtils.checkString(txtUrlKml));
			entity.setNivelAutorizaLabor(FacesUtils.checkString(txtNivelAutorizaLabor));
			entity.setConceptoAuxTransporte(FacesUtils.checkLong(txtConceptoAuxTransporte));			
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(txtLatitud));
			entity.setLongitud(FacesUtils.checkFloat(txtLongitud));
			entity.setPrecision(FacesUtils.checkFloat(txtPrecision));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setPbx(FacesUtils.checkString(txtPbx));
			entity.setRut(FacesUtils.checkString(txtRut));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setCiudad((FacesUtils.checkLong(txtCiudadId_Ciudad)));
			entity.setEntBanc((FacesUtils.checkLong(txtEntBancId_EntBanc)));
			
			entity.setAnioCurso(FacesUtils.checkLong(txtAnioCurso));
	        entity.setAuxilioMovilizacion(FacesUtils.checkDouble(txtAuxilioMovilizacion));
	        entity.setCodigo(FacesUtils.checkString(txtCodigo));
	        entity.setCodigoEntredas(FacesUtils.checkString(txtCodigoEntredas));
	        entity.setCodigoGastoCmb(FacesUtils.checkLong(txtCodigoGastoCmb));
	        entity.setCodigoGastoNomina(FacesUtils.checkLong(txtCodigoGastoNomina));
	        entity.setConsecutivoCajaMenor(FacesUtils.checkLong(txtConsecutivoCajaMenor));
	        entity.setConsecutivoCotizacion(FacesUtils.checkLong(txtConsecutivoCotizacion));
	        entity.setConsecutivoEntradas(FacesUtils.checkLong(txtConsecutivoEntradas));
	        entity.setConsecutivoFacturaCali(FacesUtils.checkLong(txtConsecutivoFacturaCali));
            entity.setConsecutivoFacturaRozo(FacesUtils.checkLong(txtConsecutivoFacturaRozo));
            entity.setConsecutivoGastos(FacesUtils.checkLong(txtConsecutivoGastos));
            entity.setConsecutivoGastosoperacion(FacesUtils.checkLong(txtConsecutivoGastosoperacion));
            entity.setConsecutivoOrdCompras(FacesUtils.checkLong(txtConsecutivoOrdCompras));
            entity.setConsecutivoPrefactura(FacesUtils.checkLong(txtConsecutivoPrefactura));
            entity.setConsecutivoSalidas(FacesUtils.checkLong(txtConsecutivoSalidas));
            entity.setConsecutivoTraslados(FacesUtils.checkLong(txtConsecutivoTraslados));
            entity.setDesFiscal(FacesUtils.checkString(txtDesFiscal));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setImprimeFactura(FacesUtils.checkString(txtImprimeFactura));
            entity.setPrefijo(FacesUtils.checkString(txtPrefijo));
            entity.setResolucion(FacesUtils.checkString(txtResolucion));
            entity.setSubtitulo(FacesUtils.checkString(txtSubtitulo));
        	entity.setKardexSalidaEstandar(FacesUtils.checkLong(txtKardexSalidaEstandar));
			entity.setKardexEntradaEstandar(FacesUtils.checkLong(txtKardexEntradaEstandar));
			
			entity.setValorUvt(FacesUtils.checkDouble(txtValorUvt));
			entity.setSalarioMinimoLegal(FacesUtils.checkDouble(txtSalarioMinimoLegal));
			entity.setTopeSmlAuxTransporte(FacesUtils.checkDouble(txtTopeSmlAuxTransporte));
			entity.setRentasExentasUvt(FacesUtils.checkDouble(txtRentasExentasUvt));
			entity.setPorcMinContribucion(FacesUtils.checkDouble(txtPorcMinContribucion));
			entity.setIpc(FacesUtils.checkDouble(txtIpc));
			entity.setAuxilioTransporte(FacesUtils.checkDouble(txtAuxilioTransporte));
			entity.setPorcRentasExternas(FacesUtils.checkDouble(txtPorcRentasExternas));
			entity.setPorcLey1527(FacesUtils.checkDouble(txtPorcLey1927));
			entity.setTarifaIvaRetenido(FacesUtils.checkDouble(txtTarifaIvaRetenido));
			entity.setPorcProvisionCesantias(FacesUtils.checkDouble(txtPorcProvisionCesantias));
			entity.setPorcProvisionPrimas(FacesUtils.checkDouble(txtPorcProvisionPrimas));
			entity.setPorcProvisionVacaciones(FacesUtils.checkDouble(txtPorcProvisionVacaciones));
			entity.setPorcProvisionInteresesCesantias(FacesUtils.checkDouble(txtPorcProvisionInteresesCesantias));
			entity.setPorcAporteEpsEmpleador(FacesUtils.checkDouble(txtPorcAporteEpsEmpleador));
			entity.setPorcAporteAfpAltoRiesgoEmpleador(FacesUtils.checkDouble(txtPorcAporteAfpAltoRiesgoEmpleador));
			entity.setPorcAporteIcbfEmpleador(FacesUtils.checkDouble(txtPorcAporteIcbfEmpleador));
			entity.setPorcAporteAfpEmpleador(FacesUtils.checkDouble(txtPorcAporteAfpEmpleador));
			entity.setPorcAporteCcfEmpleador(FacesUtils.checkDouble(txtPorcAporteCcfEmpleador));
			entity.setPorcAporteSenaEmpleador(FacesUtils.checkDouble(txtPorcAporteSenaEmpleador));
			entity.setMinimoSmlAporteSenaIcbf(FacesUtils.checkDouble(txtMinimoSmlAporteSenaIcbf));
			entity.setAportesNominaLiquidan(FacesUtils.checkString(txtAportesNominaLiquidan));
			entity.setTopeSmlCotizarEps(FacesUtils.checkDouble(txtTopeSmlCotizarEps));
			entity.setTopeSmlCotizarAfp(FacesUtils.checkDouble(txtTopeSmlCotizarAfp));
			entity.setTopeSmlCotizarArl(FacesUtils.checkDouble(txtTopeSmlCotizarArl));
			entity.setAuxilioTransporteLiquidan(FacesUtils.checkString(txtAuxilioTransporteLiquidan));
			entity.setPorcAporteEpsTrabajador(FacesUtils.checkDouble(txtPorcAporteEpsTrabajador));
			entity.setPorcAporteAfpTrabajador(FacesUtils.checkDouble(txtPorcAporteAfpTrabajador));
			entity.setPorcAporteFspTrabajador(FacesUtils.checkDouble(txtPorcAporteFspTrabajador));
			entity.setMinimoSmlAportaFSP(FacesUtils.checkDouble(txtMinimoSmlAportaFsp));
			entity.setDevengoMinimoDiario(FacesUtils.checkDouble(txtDevengoMinimoDiario));
			businessDelegatorView.updateCompania(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedCompania = (CompaniaDTO) (evt.getComponent().getAttributes().get("selectedCompania"));

			Long companiaId = new Long(selectedCompania.getCompaniaId());
			entity = businessDelegatorView.getCompania(companiaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long companiaId = FacesUtils.checkLong(txtCompaniaId);
			entity = businessDelegatorView.getCompania(companiaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteCompania(entity);
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
			selectedCompania = (CompaniaDTO) (evt.getComponent().getAttributes().get("selectedCompania"));

			Long companiaId = new Long(selectedCompania.getCompaniaId());
			entity = businessDelegatorView.getCompania(companiaId);
			businessDelegatorView.deleteCompania(entity);
			data.remove(selectedCompania);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long companiaId, String direccion, String estado,
			Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2, String latitud,
			String longitud, String nombre, String pbx, String precision, String rut, String telefono,
			Long ciudadId_Ciudad, Long entBancId_EntBanc, String estadoKml, String urlKml) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setLatitud(FacesUtils.checkFloat(latitud));
			entity.setLongitud(FacesUtils.checkFloat(longitud));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setPbx(FacesUtils.checkString(pbx));
			entity.setPrecision(FacesUtils.checkFloat(precision));
			entity.setRut(FacesUtils.checkString(rut));
			entity.setTelefono(FacesUtils.checkString(telefono));
			entity.setEstadoKml(FacesUtils.checkString(txtEstadoKml));
			entity.setUrlKml(FacesUtils.checkString(txtUrlKml));
			businessDelegatorView.updateCompania(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CompaniaView").requestRender();
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

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
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

	public InputText getTxtLatitud() {
		return txtLatitud;
	}

	public void setTxtLatitud(InputText txtLatitud) {
		this.txtLatitud = txtLatitud;
	}

	public InputText getTxtLongitud() {
		return txtLongitud;
	}

	public void setTxtLongitud(InputText txtLongitud) {
		this.txtLongitud = txtLongitud;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtPbx() {
		return txtPbx;
	}

	public void setTxtPbx(InputText txtPbx) {
		this.txtPbx = txtPbx;
	}

	public InputText getTxtPrecision() {
		return txtPrecision;
	}

	public void setTxtPrecision(InputText txtPrecision) {
		this.txtPrecision = txtPrecision;
	}

	public InputText getTxtRut() {
		return txtRut;
	}

	public void setTxtRut(InputText txtRut) {
		this.txtRut = txtRut;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public SelectOneMenu getTxtCiudadId_Ciudad() {
		return txtCiudadId_Ciudad;
	}

	public void setTxtCiudadId_Ciudad(SelectOneMenu txtCiudadId_Ciudad) {
		this.txtCiudadId_Ciudad = txtCiudadId_Ciudad;
	}

	public SelectOneMenu getTxtEntBancId_EntBanc() {
		return txtEntBancId_EntBanc;
	}

	public void setTxtEntBancId_EntBanc(SelectOneMenu txtEntBancId_EntBanc) {
		this.txtEntBancId_EntBanc = txtEntBancId_EntBanc;
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

	public InputText getTxtCompaniaId() {
		return txtCompaniaId;
	}

	public void setTxtCompaniaId(InputText txtCompaniaId) {
		this.txtCompaniaId = txtCompaniaId;
	}

	public List<CompaniaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCompania();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CompaniaDTO> companiaDTO) {
		this.data = companiaDTO;
	}

	public CompaniaDTO getSelectedCompania() {
		return selectedCompania;
	}

	public void setSelectedCompania(CompaniaDTO compania) {
		this.selectedCompania = compania;
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

	public SelectItem[] getSelectEntBanc() {

		if (selectEntBanc == null || selectEntBanc.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<EntBanc> lista = businessDelegatorView.findByCriteriaInEntBanc(condicion, null, null);
				selectEntBanc = new SelectItem[lista.size()];

				int i = 0;
				for (EntBanc entBanc : lista) {
					selectEntBanc[i] = new SelectItem(entBanc.getEntBancId(), entBanc.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEntBanc;
	}

	public void setSelectEntBanc(SelectItem[] selectEntBanc) {
		this.selectEntBanc = selectEntBanc;
	}

	public SelectItem[] getSelectCiudad() {

		if (selectCiudad == null || selectCiudad.length == 0) {

			try {
				Object[] condicion = { "estado_1", true, "A", "=" };
				List<Ciudad> lista = businessDelegatorView.findByCriteriaInCiudad(condicion, null, null);
				selectCiudad = new SelectItem[lista.size()];

				int i = 0;
				for (Ciudad ciudad : lista) {
					selectCiudad[i] = new SelectItem(ciudad.getCiudadId(), ciudad.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCiudad;
	}

	public void setSelectCiudad(SelectItem[] selectCiudad) {
		this.selectCiudad = selectCiudad;
	}

	public SelectOneRadio getTxtEstadoKml() {
		return txtEstadoKml;
	}

	public InputText getTxtUrlKml() {
		return txtUrlKml;
	}

	public void setTxtEstadoKml(SelectOneRadio txtEstadoKml) {
		this.txtEstadoKml = txtEstadoKml;
	}

	public void setTxtUrlKml(InputText txtUrlKml) {
		this.txtUrlKml = txtUrlKml;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCenterRevGeoMap() {
		return centerRevGeoMap;
	}

	public void setCenterRevGeoMap(String centerRevGeoMap) {
		this.centerRevGeoMap = centerRevGeoMap;
	}

	public String getUrlKmlMap() {
		return urlKmlMap;
	}

	public void setUrlKmlMap(String urlKmlMap) {
		this.urlKmlMap = urlKmlMap;
	}

	public String getHayKml() {
		return hayKml;
	}

	public void setHayKml(String hayKml) {
		this.hayKml = hayKml;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	
	/**
	 * @return the txtNivelAutorizaLabor
	 */
	public SelectOneMenu getTxtNivelAutorizaLabor() {
		return txtNivelAutorizaLabor;
	}

	/**
	 * @param txtNivelAutorizaLabor the txtNivelAutorizaLabor to set
	 */
	public void setTxtNivelAutorizaLabor(SelectOneMenu txtNivelAutorizaLabor) {
		this.txtNivelAutorizaLabor = txtNivelAutorizaLabor;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtAnioCurso() {
		return txtAnioCurso;
	}

	public void setTxtAnioCurso(InputText txtAnioCurso) {
		this.txtAnioCurso = txtAnioCurso;
	}

	public InputText getTxtAuxilioMovilizacion() {
		return txtAuxilioMovilizacion;
	}

	public void setTxtAuxilioMovilizacion(InputText txtAuxilioMovilizacion) {
		this.txtAuxilioMovilizacion = txtAuxilioMovilizacion;
	}

	public InputText getTxtCodigoEntredas() {
		return txtCodigoEntredas;
	}

	public void setTxtCodigoEntredas(InputText txtCodigoEntredas) {
		this.txtCodigoEntredas = txtCodigoEntredas;
	}

	public SelectOneMenu getTxtCodigoGastoCmb() {
		return txtCodigoGastoCmb;
	}

	public void setTxtCodigoGastoCmb(SelectOneMenu txtCodigoGastoCmb) {
		this.txtCodigoGastoCmb = txtCodigoGastoCmb;
	}

	public SelectOneMenu getTxtCodigoGastoNomina() {
		return txtCodigoGastoNomina;
	}

	public void setTxtCodigoGastoNomina(SelectOneMenu txtCodigoGastoNomina) {
		this.txtCodigoGastoNomina = txtCodigoGastoNomina;
	}

	public InputText getTxtConsecutivoCajaMenor() {
		return txtConsecutivoCajaMenor;
	}

	public void setTxtConsecutivoCajaMenor(InputText txtConsecutivoCajaMenor) {
		this.txtConsecutivoCajaMenor = txtConsecutivoCajaMenor;
	}

	public InputText getTxtConsecutivoCotizacion() {
		return txtConsecutivoCotizacion;
	}

	public void setTxtConsecutivoCotizacion(InputText txtConsecutivoCotizacion) {
		this.txtConsecutivoCotizacion = txtConsecutivoCotizacion;
	}

	public InputText getTxtConsecutivoEntradas() {
		return txtConsecutivoEntradas;
	}

	public void setTxtConsecutivoEntradas(InputText txtConsecutivoEntradas) {
		this.txtConsecutivoEntradas = txtConsecutivoEntradas;
	}

	public InputText getTxtConsecutivoFacturaCali() {
		return txtConsecutivoFacturaCali;
	}

	public void setTxtConsecutivoFacturaCali(InputText txtConsecutivoFacturaCali) {
		this.txtConsecutivoFacturaCali = txtConsecutivoFacturaCali;
	}

	public InputText getTxtConsecutivoFacturaRozo() {
		return txtConsecutivoFacturaRozo;
	}

	public void setTxtConsecutivoFacturaRozo(InputText txtConsecutivoFacturaRozo) {
		this.txtConsecutivoFacturaRozo = txtConsecutivoFacturaRozo;
	}

	public InputText getTxtConsecutivoGastos() {
		return txtConsecutivoGastos;
	}

	public void setTxtConsecutivoGastos(InputText txtConsecutivoGastos) {
		this.txtConsecutivoGastos = txtConsecutivoGastos;
	}

	public InputText getTxtConsecutivoGastosoperacion() {
		return txtConsecutivoGastosoperacion;
	}

	public void setTxtConsecutivoGastosoperacion(InputText txtConsecutivoGastosoperacion) {
		this.txtConsecutivoGastosoperacion = txtConsecutivoGastosoperacion;
	}

	public InputText getTxtConsecutivoOrdCompras() {
		return txtConsecutivoOrdCompras;
	}

	public void setTxtConsecutivoOrdCompras(InputText txtConsecutivoOrdCompras) {
		this.txtConsecutivoOrdCompras = txtConsecutivoOrdCompras;
	}

	public InputText getTxtConsecutivoPrefactura() {
		return txtConsecutivoPrefactura;
	}

	public void setTxtConsecutivoPrefactura(InputText txtConsecutivoPrefactura) {
		this.txtConsecutivoPrefactura = txtConsecutivoPrefactura;
	}

	public InputText getTxtConsecutivoSalidas() {
		return txtConsecutivoSalidas;
	}

	public void setTxtConsecutivoSalidas(InputText txtConsecutivoSalidas) {
		this.txtConsecutivoSalidas = txtConsecutivoSalidas;
	}

	public InputText getTxtConsecutivoTraslados() {
		return txtConsecutivoTraslados;
	}

	public void setTxtConsecutivoTraslados(InputText txtConsecutivoTraslados) {
		this.txtConsecutivoTraslados = txtConsecutivoTraslados;
	}

	public InputText getTxtDesFiscal() {
		return txtDesFiscal;
	}

	public void setTxtDesFiscal(InputText txtDesFiscal) {
		this.txtDesFiscal = txtDesFiscal;
	}

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public InputText getTxtEntBancId() {
		return txtEntBancId;
	}

	public void setTxtEntBancId(InputText txtEntBancId) {
		this.txtEntBancId = txtEntBancId;
	}

	public SelectOneMenu getTxtImprimeFactura() {
		return txtImprimeFactura;
	}

	public void setTxtImprimeFactura(SelectOneMenu txtImprimeFactura) {
		this.txtImprimeFactura = txtImprimeFactura;
	}

	public InputText getTxtPrecision1() {
		return txtPrecision1;
	}

	public void setTxtPrecision1(InputText txtPrecision1) {
		this.txtPrecision1 = txtPrecision1;
	}

	public InputText getTxtPrefijo() {
		return txtPrefijo;
	}

	public void setTxtPrefijo(InputText txtPrefijo) {
		this.txtPrefijo = txtPrefijo;
	}

	public InputText getTxtResolucion() {
		return txtResolucion;
	}

	public void setTxtResolucion(InputText txtResolucion) {
		this.txtResolucion = txtResolucion;
	}

	public InputText getTxtSubtitulo() {
		return txtSubtitulo;
	}

	public void setTxtSubtitulo(InputText txtSubtitulo) {
		this.txtSubtitulo = txtSubtitulo;
	}

	public SelectOneMenu getTxtConceptoAuxTransporte() {
		return txtConceptoAuxTransporte;
	}

	public void setTxtConceptoAuxTransporte(SelectOneMenu txtConceptoAuxTransporte) {
		this.txtConceptoAuxTransporte = txtConceptoAuxTransporte;
	}
	
	public SelectItem[] getSelectCeptoNominaId() {

		if (selectCeptoNominaId == null || selectCeptoNominaId.length == 0) {
			 
			try {
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null, null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(), conceptoNomina.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setSelectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}
	
	public SelectItem[] getSelectLaborIdCmb() {

		if (selectLaborIdCmb == null || selectLaborIdCmb.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborIdCmb = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborIdCmb : lista) {
					selectLaborIdCmb[i] = new SelectItem(laborIdCmb.getLaborId(),laborIdCmb.getCodigo()+"-"+ laborIdCmb.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborIdCmb;
	}

	public void setSelectLaborIdCmb(SelectItem[] selectLaborIdCmb) {
		this.selectLaborIdCmb = selectLaborIdCmb;
	}
	
	public SelectItem[] getSelectLaborIdNomina() {

		if (selectLaborIdNomina == null || selectLaborIdNomina.length == 0) {

			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoLabor", true, "Mtto_Maquinaria_goperacion", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborIdNomina = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborIdNomina : lista) {
					selectLaborIdNomina[i] = new SelectItem(laborIdNomina.getLaborId(),laborIdNomina.getCodigo()+"-"+ laborIdNomina.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborIdNomina;
	}

	public void setSelectLaborIdNomina(SelectItem[] selectLaborIdNomina) {
		this.selectLaborIdNomina = selectLaborIdNomina;
	}
	
	public SelectOneMenu getTxtKardexEntradaEstandar() {
		return txtKardexEntradaEstandar;
	}

	public void setTxtKardexEntradaEstandar(SelectOneMenu txtKardexEntradaEstandar) {
		this.txtKardexEntradaEstandar = txtKardexEntradaEstandar;
	}

	public SelectItem[] getSelectKardexEntrada() throws Exception {

		if (selectKardexEntrada == null || selectKardexEntrada.length == 0) {
			
			Long compania = Long.parseLong(getCompaniaIdSession());

			try {
				Object[] condicion = { "estado", true, "A", "=", "compania", true, compania, "="};
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null, null);
				selectKardexEntrada = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectKardexEntrada[i] = new SelectItem(conceptoKardex.getConceptoKardexId(), 
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return selectKardexEntrada;
	}

	public void setSelectKardexEntrada(SelectItem[] selectKardexEntrada) {
		this.selectKardexEntrada = selectKardexEntrada;
	}

	public SelectOneMenu getTxtKardexSalidaEstandar() {
		return txtKardexSalidaEstandar;
	}

	public void setTxtKardexSalidaEstandar(SelectOneMenu txtKardexSalidaEstandar) {
		this.txtKardexSalidaEstandar = txtKardexSalidaEstandar;
	}

	public SelectItem[] getSelectKardexSalida() throws Exception {

		if (selectKardexSalida == null || selectKardexSalida.length == 0) {
			
			Long compania = Long.parseLong(getCompaniaIdSession());

			try {
				Object[] condicion = { "estado", true, "A", "=", "compania", true, compania, "="};
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null, null);
				selectKardexSalida = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectKardexSalida[i] = new SelectItem(conceptoKardex.getConceptoKardexId(), 
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return selectKardexSalida;
	}

	public void setSelectKardexSalida(SelectItem[] selectKardexSalida) {
		this.selectKardexSalida = selectKardexSalida;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
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

	public InputNumber getTxtValorUvt() {
		return txtValorUvt;
	}

	public void setTxtValorUvt(InputNumber txtValorUvt) {
		this.txtValorUvt = txtValorUvt;
	}

	public InputNumber getTxtSalarioMinimoLegal() {
		return txtSalarioMinimoLegal;
	}

	public void setTxtSalarioMinimoLegal(InputNumber txtSalarioMinimoLegal) {
		this.txtSalarioMinimoLegal = txtSalarioMinimoLegal;
	}

	public InputNumber getTxtTopeSmlAuxTransporte() {
		return txtTopeSmlAuxTransporte;
	}

	public void setTxtTopeSmlAuxTransporte(InputNumber txtTopeSmlAuxTransporte) {
		this.txtTopeSmlAuxTransporte = txtTopeSmlAuxTransporte;
	}

	public InputNumber getTxtRentasExentasUvt() {
		return txtRentasExentasUvt;
	}

	public void setTxtRentasExentasUvt(InputNumber txtRentasExentasUvt) {
		this.txtRentasExentasUvt = txtRentasExentasUvt;
	}

	public InputNumber getTxtPorcMinContribucion() {
		return txtPorcMinContribucion;
	}

	public void setTxtPorcMinContribucion(InputNumber txtPorcMinContribucion) {
		this.txtPorcMinContribucion = txtPorcMinContribucion;
	}

	public InputNumber getTxtIpc() {
		return txtIpc;
	}

	public void setTxtIpc(InputNumber txtIpc) {
		this.txtIpc = txtIpc;
	}

	public InputNumber getTxtAuxilioTransporte() {
		return txtAuxilioTransporte;
	}

	public void setTxtAuxilioTransporte(InputNumber txtAuxilioTransporte) {
		this.txtAuxilioTransporte = txtAuxilioTransporte;
	}

	public InputNumber getTxtPorcRentasExternas() {
		return txtPorcRentasExternas;
	}

	public void setTxtPorcRentasExternas(InputNumber txtPorcRentasExternas) {
		this.txtPorcRentasExternas = txtPorcRentasExternas;
	}

	public InputNumber getTxtPorcLey1927() {
		return txtPorcLey1927;
	}

	public void setTxtPorcLey1927(InputNumber txtPorcLey1927) {
		this.txtPorcLey1927 = txtPorcLey1927;
	}

	public InputNumber getTxtTarifaIvaRetenido() {
		return txtTarifaIvaRetenido;
	}

	public void setTxtTarifaIvaRetenido(InputNumber txtTarifaIvaRetenido) {
		this.txtTarifaIvaRetenido = txtTarifaIvaRetenido;
	}

	public InputNumber getTxtPorcProvisionCesantias() {
		return txtPorcProvisionCesantias;
	}

	public void setTxtPorcProvisionCesantias(InputNumber txtPorcProvisionCesantias) {
		this.txtPorcProvisionCesantias = txtPorcProvisionCesantias;
	}

	public InputNumber getTxtPorcProvisionPrimas() {
		return txtPorcProvisionPrimas;
	}

	public void setTxtPorcProvisionPrimas(InputNumber txtPorcProvisionPrimas) {
		this.txtPorcProvisionPrimas = txtPorcProvisionPrimas;
	}

	public InputNumber getTxtPorcProvisionVacaciones() {
		return txtPorcProvisionVacaciones;
	}

	public void setTxtPorcProvisionVacaciones(InputNumber txtPorcProvisionVacaciones) {
		this.txtPorcProvisionVacaciones = txtPorcProvisionVacaciones;
	}

	public InputNumber getTxtPorcProvisionInteresesCesantias() {
		return txtPorcProvisionInteresesCesantias;
	}

	public void setTxtPorcProvisionInteresesCesantias(InputNumber txtPorcProvisionInteresesCesantias) {
		this.txtPorcProvisionInteresesCesantias = txtPorcProvisionInteresesCesantias;
	}

	public InputNumber getTxtPorcAporteEpsEmpleador() {
		return txtPorcAporteEpsEmpleador;
	}

	public void setTxtPorcAporteEpsEmpleador(InputNumber txtPorcAporteEpsEmpleador) {
		this.txtPorcAporteEpsEmpleador = txtPorcAporteEpsEmpleador;
	}

	public InputNumber getTxtPorcAporteAfpAltoRiesgoEmpleador() {
		return txtPorcAporteAfpAltoRiesgoEmpleador;
	}

	public void setTxtPorcAporteAfpAltoRiesgoEmpleador(InputNumber txtPorcAporteAfpAltoRiesgoEmpleador) {
		this.txtPorcAporteAfpAltoRiesgoEmpleador = txtPorcAporteAfpAltoRiesgoEmpleador;
	}

	public InputNumber getTxtPorcAporteIcbfEmpleador() {
		return txtPorcAporteIcbfEmpleador;
	}

	public void setTxtPorcAporteIcbfEmpleador(InputNumber txtPorcAporteIcbfEmpleador) {
		this.txtPorcAporteIcbfEmpleador = txtPorcAporteIcbfEmpleador;
	}

	public InputNumber getTxtPorcAporteAfpEmpleador() {
		return txtPorcAporteAfpEmpleador;
	}

	public void setTxtPorcAporteAfpEmpleador(InputNumber txtPorcAporteAfpEmpleador) {
		this.txtPorcAporteAfpEmpleador = txtPorcAporteAfpEmpleador;
	}

	public InputNumber getTxtPorcAporteCcfEmpleador() {
		return txtPorcAporteCcfEmpleador;
	}

	public void setTxtPorcAporteCcfEmpleador(InputNumber txtPorcAporteCcfEmpleador) {
		this.txtPorcAporteCcfEmpleador = txtPorcAporteCcfEmpleador;
	}

	public InputNumber getTxtPorcAporteSenaEmpleador() {
		return txtPorcAporteSenaEmpleador;
	}

	public void setTxtPorcAporteSenaEmpleador(InputNumber txtPorcAporteSenaEmpleador) {
		this.txtPorcAporteSenaEmpleador = txtPorcAporteSenaEmpleador;
	}

	public InputNumber getTxtMinimoSmlAporteSenaIcbf() {
		return txtMinimoSmlAporteSenaIcbf;
	}

	public void setTxtMinimoSmlAporteSenaIcbf(InputNumber txtMinimoSmlAporteSenaIcbf) {
		this.txtMinimoSmlAporteSenaIcbf = txtMinimoSmlAporteSenaIcbf;
	}

	public SelectOneMenu getTxtAportesNominaLiquidan() {
		return txtAportesNominaLiquidan;
	}

	public void setTxtAportesNominaLiquidan(SelectOneMenu txtAportesNominaLiquidan) {
		this.txtAportesNominaLiquidan = txtAportesNominaLiquidan;
	}

	public InputNumber getTxtTopeSmlCotizarEps() {
		return txtTopeSmlCotizarEps;
	}

	public void setTxtTopeSmlCotizarEps(InputNumber txtTopeSmlCotizarEps) {
		this.txtTopeSmlCotizarEps = txtTopeSmlCotizarEps;
	}

	public InputNumber getTxtTopeSmlCotizarAfp() {
		return txtTopeSmlCotizarAfp;
	}

	public void setTxtTopeSmlCotizarAfp(InputNumber txtTopeSmlCotizarAfp) {
		this.txtTopeSmlCotizarAfp = txtTopeSmlCotizarAfp;
	}

	public InputNumber getTxtTopeSmlCotizarArl() {
		return txtTopeSmlCotizarArl;
	}

	public void setTxtTopeSmlCotizarArl(InputNumber txtTopeSmlCotizarArl) {
		this.txtTopeSmlCotizarArl = txtTopeSmlCotizarArl;
	}

	public SelectOneMenu getTxtAuxilioTransporteLiquidan() {
		return txtAuxilioTransporteLiquidan;
	}

	public void setTxtAuxilioTransporteLiquidan(SelectOneMenu txtAuxilioTransporteLiquidan) {
		this.txtAuxilioTransporteLiquidan = txtAuxilioTransporteLiquidan;
	}

	public InputNumber getTxtPorcAporteEpsTrabajador() {
		return txtPorcAporteEpsTrabajador;
	}

	public void setTxtPorcAporteEpsTrabajador(InputNumber txtPorcAporteEpsTrabajador) {
		this.txtPorcAporteEpsTrabajador = txtPorcAporteEpsTrabajador;
	}

	public InputNumber getTxtPorcAporteAfpTrabajador() {
		return txtPorcAporteAfpTrabajador;
	}

	public void setTxtPorcAporteAfpTrabajador(InputNumber txtPorcAporteAfpTrabajador) {
		this.txtPorcAporteAfpTrabajador = txtPorcAporteAfpTrabajador;
	}

	public InputNumber getTxtPorcAporteFspTrabajador() {
		return txtPorcAporteFspTrabajador;
	}

	public void setTxtPorcAporteFspTrabajador(InputNumber txtPorcAporteFspTrabajador) {
		this.txtPorcAporteFspTrabajador = txtPorcAporteFspTrabajador;
	}

	public InputNumber getTxtMinimoSmlAportaFsp() {
		return txtMinimoSmlAportaFsp;
	}

	public void setTxtMinimoSmlAportaFsp(InputNumber txtMinimoSmlAportaFsp) {
		this.txtMinimoSmlAportaFsp = txtMinimoSmlAportaFsp;
	}

	public InputNumber getTxtDevengoMinimoDiario() {
		return txtDevengoMinimoDiario;
	}

	public void setTxtDevengoMinimoDiario(InputNumber txtDevengoMinimoDiario) {
		this.txtDevengoMinimoDiario = txtDevengoMinimoDiario;
	}	
	

	
}