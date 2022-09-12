package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.spinner.Spinner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanAnualFabrica;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatPlanAnualFabricaDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatPlanAnualFabricaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatPlanAnualFabricaView.class);
	private Spinner txtAnio;
	private InputText txtCompania;
	private InputText txtConsecutivo;
	private SelectOneRadio txtEstado;
	private Spinner txtHorasArranque;
	private InputTextarea txtObservacion;
	private InputText txtObservacionAnularReg;
	private SelectOneMenu txtOrigenDatos;
	private Spinner txtProduccionAbril;
	private Spinner txtProduccionAgosto;
	private Spinner txtProduccionDiciembre;
	private Spinner txtProduccionEnero;
	private Spinner txtProduccionFebrero;
	private Spinner txtProduccionJulio;
	private Spinner txtProduccionJunio;
	private Spinner txtProduccionMarzo;
	private Spinner txtProduccionMayo;
	private Spinner txtProduccionNoviembre;
	private Spinner txtProduccionOctubre;
	private Spinner txtProduccionSeptiembre;
	private InputText txtProduccionTotal;
	private InputText txtUsuarioDigitacion;
	private InputText txtDatPlanAnualFabricaId;
	private Calendar txtFechaAnulacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatPlanAnualFabricaDTO> data;
	private DatPlanAnualFabricaDTO selectedDatPlanAnualFabrica;
	private DatPlanAnualFabrica entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private int activeTapIndex = 0;
    private Spinner txtHorasMttoNoProgEjec;
    private Spinner txtHorasMttoNoProgEst;
    private Spinner txtHorasMttoProgEjec;
    private Spinner txtHorasMttoProgEst;
    private InputText txtHorasPlantaEjec;
    private InputText txtHorasPlantaEst;
    private InputText txtHorasProcesoEjec;
    private InputText txtHorasProcesoEst;

    private Spinner txtProduccionEstAbril;
    private Spinner txtProduccionEstAgosto;
    private Spinner txtProduccionEstDiciembre;
    private Spinner txtProduccionEstEnero;
    private Spinner txtProduccionEstFebrero;
    private Spinner txtProduccionEstJulio;
    private Spinner txtProduccionEstJunio;
    private Spinner txtProduccionEstMarzo;
    private Spinner txtProduccionEstMayo;
    private Spinner txtProduccionEstNoviembre;
    private Spinner txtProduccionEstOctubre;
    private Spinner txtProduccionEstSeptiembre;
    private Spinner txtValorPromedioHrDia;
    private Spinner txtVelocidadEstandar;
    
    private InputText txtProduccionEstTotal;
    
	
	public DatPlanAnualFabricaView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatPlanAnualFabrica = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatPlanAnualFabrica = null;
		PrimeFaces.current().resetInputs(":dialogDatPlanAnualFabrica :frm");

		activeTapIndex = 0;

		   if (txtHorasArranque != null) {
	            txtHorasArranque.setValue(0);
	            txtHorasArranque.setDisabled(false);
	        }

	        if (txtHorasMttoNoProgEjec != null) {
	            txtHorasMttoNoProgEjec.setValue(0);
	            txtHorasMttoNoProgEjec.setDisabled(false);
	        }

	        if (txtHorasMttoNoProgEst != null) {
	            txtHorasMttoNoProgEst.setValue(0);
	            txtHorasMttoNoProgEst.setDisabled(false);
	        }

	        if (txtHorasMttoProgEjec != null) {
	            txtHorasMttoProgEjec.setValue(0);
	            txtHorasMttoProgEjec.setDisabled(false);
	        }

	        if (txtHorasMttoProgEst != null) {
	            txtHorasMttoProgEst.setValue(0);
	            txtHorasMttoProgEst.setDisabled(false);
	        }

	        if (txtHorasPlantaEjec != null) {
	            txtHorasPlantaEjec.setValue(0);
	            txtHorasPlantaEjec.setDisabled(false);
	        }

	        if (txtHorasPlantaEst != null) {
	            txtHorasPlantaEst.setValue(0);
	            txtHorasPlantaEst.setDisabled(false);
	        }

	        if (txtHorasProcesoEjec != null) {
	            txtHorasProcesoEjec.setValue(0);
	            txtHorasProcesoEjec.setDisabled(false);
	        }

	        if (txtHorasProcesoEst != null) {
	            txtHorasProcesoEst.setValue(0);
	            txtHorasProcesoEst.setDisabled(false);
	        }


	        if (txtProduccionEstAbril != null) {
	            txtProduccionEstAbril.setValue(0);
	            txtProduccionEstAbril.setDisabled(false);
	        }

	        if (txtProduccionEstAgosto != null) {
	            txtProduccionEstAgosto.setValue(0);
	            txtProduccionEstAgosto.setDisabled(false);
	        }

	        if (txtProduccionEstDiciembre != null) {
	            txtProduccionEstDiciembre.setValue(0);
	            txtProduccionEstDiciembre.setDisabled(false);
	        }

	        if (txtProduccionEstEnero != null) {
	            txtProduccionEstEnero.setValue(0);
	            txtProduccionEstEnero.setDisabled(false);
	        }

	        if (txtProduccionEstFebrero != null) {
	            txtProduccionEstFebrero.setValue(0);
	            txtProduccionEstFebrero.setDisabled(false);
	        }

	        if (txtProduccionEstJulio != null) {
	            txtProduccionEstJulio.setValue(0);
	            txtProduccionEstJulio.setDisabled(false);
	        }

	        if (txtProduccionEstJunio != null) {
	            txtProduccionEstJunio.setValue(0);
	            txtProduccionEstJunio.setDisabled(false);
	        }

	        if (txtProduccionEstMarzo != null) {
	            txtProduccionEstMarzo.setValue(0);
	            txtProduccionEstMarzo.setDisabled(false);
	        }

	        if (txtProduccionEstMayo != null) {
	            txtProduccionEstMayo.setValue(0);
	            txtProduccionEstMayo.setDisabled(false);
	        }

	        if (txtProduccionEstNoviembre != null) {
	            txtProduccionEstNoviembre.setValue(0);
	            txtProduccionEstNoviembre.setDisabled(false);
	        }

	        if (txtProduccionEstOctubre != null) {
	            txtProduccionEstOctubre.setValue(0);
	            txtProduccionEstOctubre.setDisabled(false);
	        }

	        if (txtProduccionEstSeptiembre != null) {
	            txtProduccionEstSeptiembre.setValue(0);
	            txtProduccionEstSeptiembre.setDisabled(false);
	        }

	        if (txtProduccionEstTotal != null) {
	            txtProduccionEstTotal.setValue(0);
	            txtProduccionEstTotal.setDisabled(false);
	        }

	        if (txtValorPromedioHrDia != null) {
	            txtValorPromedioHrDia.setValue(0);
	            txtValorPromedioHrDia.setDisabled(false);
	        }

	        if (txtVelocidadEstandar != null) {
	            txtVelocidadEstandar.setValue(0);
	            txtVelocidadEstandar.setDisabled(false);
	        }


		
		if (txtAnio != null) {
			txtAnio.setValue(null);
			txtAnio.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtConsecutivo != null) {
			txtConsecutivo.setValue(null);
			txtConsecutivo.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(false);
		}

		if (txtHorasArranque != null) {
			txtHorasArranque.setValue(0);
			txtHorasArranque.setDisabled(false);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(false);
		}

		if (txtObservacionAnularReg != null) {
			txtObservacionAnularReg.setValue(null);
			txtObservacionAnularReg.setDisabled(false);
		}

		if (txtOrigenDatos != null) {
			txtOrigenDatos.setValue(null);
			txtOrigenDatos.setDisabled(true);
		}

		if (txtProduccionAbril != null) {
			txtProduccionAbril.setValue(0);
			txtProduccionAbril.setDisabled(false);
		}

		if (txtProduccionAgosto != null) {
			txtProduccionAgosto.setValue(0);
			txtProduccionAgosto.setDisabled(false);
		}

		if (txtProduccionDiciembre != null) {
			txtProduccionDiciembre.setValue(0);
			txtProduccionDiciembre.setDisabled(false);
		}

		if (txtProduccionEnero != null) {
			txtProduccionEnero.setValue(0);
			txtProduccionEnero.setDisabled(false);
		}

		if (txtProduccionFebrero != null) {
			txtProduccionFebrero.setValue(0);
			txtProduccionFebrero.setDisabled(false);
		}

		if (txtProduccionJulio != null) {
			txtProduccionJulio.setValue(0);
			txtProduccionJulio.setDisabled(false);
		}

		if (txtProduccionJunio != null) {
			txtProduccionJunio.setValue(0);
			txtProduccionJunio.setDisabled(false);
		}

		if (txtProduccionMarzo != null) {
			txtProduccionMarzo.setValue(0);
			txtProduccionMarzo.setDisabled(false);
		}

		if (txtProduccionMayo != null) {
			txtProduccionMayo.setValue(0);
			txtProduccionMayo.setDisabled(false);
		}

		if (txtProduccionNoviembre != null) {
			txtProduccionNoviembre.setValue(0);
			txtProduccionNoviembre.setDisabled(false);
		}

		if (txtProduccionOctubre != null) {
			txtProduccionOctubre.setValue(0);
			txtProduccionOctubre.setDisabled(false);
		}

		if (txtProduccionSeptiembre != null) {
			txtProduccionSeptiembre.setValue(0);
			txtProduccionSeptiembre.setDisabled(false);
		}

		if (txtProduccionTotal != null) {
			txtProduccionTotal.setValue(0);
			txtProduccionTotal.setDisabled(false);
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

		if (txtDatPlanAnualFabricaId != null) {
			txtDatPlanAnualFabricaId.setValue(null);
			txtDatPlanAnualFabricaId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public String action_edit(ActionEvent evt) {
		selectedDatPlanAnualFabrica = (DatPlanAnualFabricaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanAnualFabrica"));
		try {

			Long consecutivo = selectedDatPlanAnualFabrica.getConsecutivo();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatPlanAnualFabrica> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatPlanAnualFabrica(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtAnio.setValue(entity.getAnio());
				txtAnio.setDisabled(false);
				txtConsecutivo.setValue(entity.getConsecutivo());
				txtConsecutivo.setDisabled(true);
				txtHorasArranque.setValue(entity.getHorasArranque());
				txtHorasArranque.setDisabled(false);
				txtObservacion.setValue(entity.getObservacion());
				txtObservacion.setDisabled(false);
				txtOrigenDatos.setValue(entity.getOrigenDatos());
				txtOrigenDatos.setDisabled(true);
				txtProduccionAbril.setValue(entity.getProduccionAbril());
				txtProduccionAbril.setDisabled(false);
				txtProduccionAgosto.setValue(entity.getProduccionAgosto());
				txtProduccionAgosto.setDisabled(false);
				txtProduccionDiciembre.setValue(entity.getProduccionDiciembre());
				txtProduccionDiciembre.setDisabled(false);
				txtProduccionEnero.setValue(entity.getProduccionEnero());
				txtProduccionEnero.setDisabled(false);
				txtProduccionFebrero.setValue(entity.getProduccionFebrero());
				txtProduccionFebrero.setDisabled(false);
				txtProduccionJulio.setValue(entity.getProduccionJulio());
				txtProduccionJulio.setDisabled(false);
				txtProduccionJunio.setValue(entity.getProduccionJunio());
				txtProduccionJunio.setDisabled(false);
				txtProduccionMarzo.setValue(entity.getProduccionMarzo());
				txtProduccionMarzo.setDisabled(false);
				txtProduccionMayo.setValue(entity.getProduccionMayo());
				txtProduccionMayo.setDisabled(false);
				txtProduccionNoviembre.setValue(entity.getProduccionNoviembre());
				txtProduccionNoviembre.setDisabled(false);
				txtProduccionOctubre.setValue(entity.getProduccionOctubre());
				txtProduccionOctubre.setDisabled(false);
				txtProduccionSeptiembre.setValue(entity.getProduccionSeptiembre());
				txtProduccionSeptiembre.setDisabled(false);
				txtProduccionTotal.setValue(entity.getProduccionTotal());
				txtProduccionTotal.setDisabled(false);
				txtDatPlanAnualFabricaId.setValue(entity.getDatPlanAnualFabricaId());
				txtDatPlanAnualFabricaId.setDisabled(true);
				
				   txtHorasMttoNoProgEjec.setValue(entity.getHorasMttoNoProgEjec());
		            txtHorasMttoNoProgEjec.setDisabled(false);
		            txtHorasMttoNoProgEst.setValue(entity.getHorasMttoNoProgEst());
		            txtHorasMttoNoProgEst.setDisabled(false);
		            txtHorasMttoProgEjec.setValue(entity.getHorasMttoProgEjec());
		            txtHorasMttoProgEjec.setDisabled(false);
		            txtHorasMttoProgEst.setValue(entity.getHorasMttoProgEst());
		            txtHorasMttoProgEst.setDisabled(false);
		            txtHorasPlantaEjec.setValue(entity.getHorasPlantaEjec());
		            txtHorasPlantaEjec.setDisabled(false);
		            txtHorasPlantaEst.setValue(entity.getHorasPlantaEst());
		            txtHorasPlantaEst.setDisabled(false);
		            txtHorasProcesoEjec.setValue(entity.getHorasProcesoEjec());
		            txtHorasProcesoEjec.setDisabled(false);
		            txtHorasProcesoEst.setValue(entity.getHorasProcesoEst());
		            txtHorasProcesoEst.setDisabled(false);
		            txtProduccionEstAbril.setValue(entity.getProduccionEstAbril());
		            txtProduccionEstAbril.setDisabled(false);
		            txtProduccionEstAgosto.setValue(entity.getProduccionEstAgosto());
		            txtProduccionEstAgosto.setDisabled(false);
		            txtProduccionEstDiciembre.setValue(entity.getProduccionEstDiciembre());
		            txtProduccionEstDiciembre.setDisabled(false);
		            txtProduccionEstEnero.setValue(entity.getProduccionEstEnero());
		            txtProduccionEstEnero.setDisabled(false);
		            txtProduccionEstFebrero.setValue(entity.getProduccionEstFebrero());
		            txtProduccionEstFebrero.setDisabled(false);
		            txtProduccionEstJulio.setValue(entity.getProduccionEstJulio());
		            txtProduccionEstJulio.setDisabled(false);
		            txtProduccionEstJunio.setValue(entity.getProduccionEstJunio());
		            txtProduccionEstJunio.setDisabled(false);
		            txtProduccionEstMarzo.setValue(entity.getProduccionEstMarzo());
		            txtProduccionEstMarzo.setDisabled(false);
		            txtProduccionEstMayo.setValue(entity.getProduccionEstMayo());
		            txtProduccionEstMayo.setDisabled(false);
		            txtProduccionEstNoviembre.setValue(entity.getProduccionEstNoviembre());
		            txtProduccionEstNoviembre.setDisabled(false);
		            txtProduccionEstOctubre.setValue(entity.getProduccionEstOctubre());
		            txtProduccionEstOctubre.setDisabled(false);
		            txtProduccionEstSeptiembre.setValue(entity.getProduccionEstSeptiembre());
		            txtProduccionEstSeptiembre.setDisabled(false);
		            txtProduccionEstTotal.setValue(entity.getProduccionEstTotal());
		            txtProduccionEstTotal.setDisabled(false);
		            
		            
		         
				
				btnSave.setDisabled(false);
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
			if ((selectedDatPlanAnualFabrica == null) && (entity == null)) {
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
			entity = new DatPlanAnualFabrica();

			// Long datPlanAnualFabricaId =
			// FacesUtils.checkLong(txtDatPlanAnualFabricaId);

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setAnio(FacesUtils.checkLong(txtAnio));
			entity.setConsecutivo(businessDelegatorView.consultarConsecutivoPlanAnualFabrica(compania));
			// entity.setDatPlanAnualFabricaId(datPlanAnualFabricaId);
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setHorasArranque(FacesUtils.checkDouble(txtHorasArranque));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setProduccionAbril(FacesUtils.checkDouble(txtProduccionAbril));
			entity.setProduccionAgosto(FacesUtils.checkDouble(txtProduccionAgosto));
			entity.setProduccionDiciembre(FacesUtils.checkDouble(txtProduccionDiciembre));
			entity.setProduccionEnero(FacesUtils.checkDouble(txtProduccionEnero));
			entity.setProduccionFebrero(FacesUtils.checkDouble(txtProduccionFebrero));
			entity.setProduccionJulio(FacesUtils.checkDouble(txtProduccionJulio));
			entity.setProduccionJunio(FacesUtils.checkDouble(txtProduccionJunio));
			entity.setProduccionMarzo(FacesUtils.checkDouble(txtProduccionMarzo));
			entity.setProduccionMayo(FacesUtils.checkDouble(txtProduccionMayo));
			entity.setProduccionNoviembre(FacesUtils.checkDouble(txtProduccionNoviembre));
			entity.setProduccionOctubre(FacesUtils.checkDouble(txtProduccionOctubre));
			entity.setProduccionSeptiembre(FacesUtils.checkDouble(txtProduccionSeptiembre));
			entity.setProduccionTotal(FacesUtils.checkDouble(txtProduccionTotal));
			
			entity.setHorasMttoNoProgEjec(FacesUtils.checkDouble(
                    txtHorasMttoNoProgEjec));
            entity.setHorasMttoNoProgEst(FacesUtils.checkDouble(
                    txtHorasMttoNoProgEst));
            entity.setHorasMttoProgEjec(FacesUtils.checkDouble(
                    txtHorasMttoProgEjec));
            entity.setHorasMttoProgEst(FacesUtils.checkDouble(
                    txtHorasMttoProgEst));
            entity.setHorasPlantaEjec(FacesUtils.checkDouble(txtHorasPlantaEjec));
            entity.setHorasPlantaEst(FacesUtils.checkDouble(txtHorasPlantaEst));
            entity.setHorasProcesoEjec(FacesUtils.checkDouble(
                    txtHorasProcesoEjec));
            entity.setHorasProcesoEst(FacesUtils.checkDouble(txtHorasProcesoEst));
            
            entity.setProduccionEstAbril(FacesUtils.checkDouble(
                    txtProduccionEstAbril));
            entity.setProduccionEstAgosto(FacesUtils.checkDouble(
                    txtProduccionEstAgosto));
            entity.setProduccionEstDiciembre(FacesUtils.checkDouble(
                    txtProduccionEstDiciembre));
            entity.setProduccionEstEnero(FacesUtils.checkDouble(
                    txtProduccionEstEnero));
            entity.setProduccionEstFebrero(FacesUtils.checkDouble(
                    txtProduccionEstFebrero));
            entity.setProduccionEstJulio(FacesUtils.checkDouble(
                    txtProduccionEstJulio));
            entity.setProduccionEstJunio(FacesUtils.checkDouble(
                    txtProduccionEstJunio));
            entity.setProduccionEstMarzo(FacesUtils.checkDouble(
                    txtProduccionEstMarzo));
            entity.setProduccionEstMayo(FacesUtils.checkDouble(
                    txtProduccionEstMayo));
            entity.setProduccionEstNoviembre(FacesUtils.checkDouble(
                    txtProduccionEstNoviembre));
            entity.setProduccionEstOctubre(FacesUtils.checkDouble(
                    txtProduccionEstOctubre));
            entity.setProduccionEstSeptiembre(FacesUtils.checkDouble(
                    txtProduccionEstSeptiembre));
            entity.setProduccionEstTotal(FacesUtils.checkDouble(
                    txtProduccionEstTotal));
            
			businessDelegatorView.saveDatPlanAnualFabrica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED + "Número consecutivo: "
					+ (businessDelegatorView.consultarConsecutivoPlanAnualFabrica(compania) - 1));
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
				Long datPlanAnualFabricaId = new Long(selectedDatPlanAnualFabrica.getDatPlanAnualFabricaId());
				entity = businessDelegatorView.getDatPlanAnualFabrica(datPlanAnualFabricaId);
			}

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";
			entity.setCompania(compania);
			entity.setEstado(estado);
			entity.setFechaCreacion(date);
			entity.setUsuarioDigitacion(usuarioId);

			entity.setAnio(FacesUtils.checkLong(txtAnio));
			entity.setConsecutivo(FacesUtils.checkLong(txtConsecutivo));
			entity.setFechaAnulacion(FacesUtils.checkDate(txtFechaAnulacion));
			entity.setFechaModificacion(date);
			entity.setHorasArranque(FacesUtils.checkDouble(txtHorasArranque));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(txtOrigenDatos));
			entity.setProduccionAbril(FacesUtils.checkDouble(txtProduccionAbril));
			entity.setProduccionAgosto(FacesUtils.checkDouble(txtProduccionAgosto));
			entity.setProduccionDiciembre(FacesUtils.checkDouble(txtProduccionDiciembre));
			entity.setProduccionEnero(FacesUtils.checkDouble(txtProduccionEnero));
			entity.setProduccionFebrero(FacesUtils.checkDouble(txtProduccionFebrero));
			entity.setProduccionJulio(FacesUtils.checkDouble(txtProduccionJulio));
			entity.setProduccionJunio(FacesUtils.checkDouble(txtProduccionJunio));
			entity.setProduccionMarzo(FacesUtils.checkDouble(txtProduccionMarzo));
			entity.setProduccionMayo(FacesUtils.checkDouble(txtProduccionMayo));
			entity.setProduccionNoviembre(FacesUtils.checkDouble(txtProduccionNoviembre));
			entity.setProduccionOctubre(FacesUtils.checkDouble(txtProduccionOctubre));
			entity.setProduccionSeptiembre(FacesUtils.checkDouble(txtProduccionSeptiembre));
			entity.setProduccionTotal(FacesUtils.checkDouble(txtProduccionTotal));
			
			entity.setHorasMttoNoProgEjec(FacesUtils.checkDouble(
                    txtHorasMttoNoProgEjec));
            entity.setHorasMttoNoProgEst(FacesUtils.checkDouble(
                    txtHorasMttoNoProgEst));
            entity.setHorasMttoProgEjec(FacesUtils.checkDouble(
                    txtHorasMttoProgEjec));
            entity.setHorasMttoProgEst(FacesUtils.checkDouble(
                    txtHorasMttoProgEst));
            entity.setHorasPlantaEjec(FacesUtils.checkDouble(txtHorasPlantaEjec));
            entity.setHorasPlantaEst(FacesUtils.checkDouble(txtHorasPlantaEst));
            entity.setHorasProcesoEjec(FacesUtils.checkDouble(
                    txtHorasProcesoEjec));
            entity.setHorasProcesoEst(FacesUtils.checkDouble(txtHorasProcesoEst));
            
            entity.setProduccionEstAbril(FacesUtils.checkDouble(
                    txtProduccionEstAbril));
            entity.setProduccionEstAgosto(FacesUtils.checkDouble(
                    txtProduccionEstAgosto));
            entity.setProduccionEstDiciembre(FacesUtils.checkDouble(
                    txtProduccionEstDiciembre));
            entity.setProduccionEstEnero(FacesUtils.checkDouble(
                    txtProduccionEstEnero));
            entity.setProduccionEstFebrero(FacesUtils.checkDouble(
                    txtProduccionEstFebrero));
            entity.setProduccionEstJulio(FacesUtils.checkDouble(
                    txtProduccionEstJulio));
            entity.setProduccionEstJunio(FacesUtils.checkDouble(
                    txtProduccionEstJunio));
            entity.setProduccionEstMarzo(FacesUtils.checkDouble(
                    txtProduccionEstMarzo));
            entity.setProduccionEstMayo(FacesUtils.checkDouble(
                    txtProduccionEstMayo));
            entity.setProduccionEstNoviembre(FacesUtils.checkDouble(
                    txtProduccionEstNoviembre));
            entity.setProduccionEstOctubre(FacesUtils.checkDouble(
                    txtProduccionEstOctubre));
            entity.setProduccionEstSeptiembre(FacesUtils.checkDouble(
                    txtProduccionEstSeptiembre));
            entity.setProduccionEstTotal(FacesUtils.checkDouble(
                    txtProduccionEstTotal));
            
			businessDelegatorView.updateDatPlanAnualFabrica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_saveAnularReg() {
		try {

			if (entity == null) {
				Long id = new Long(selectedDatPlanAnualFabrica.getDatPlanAnualFabricaId());
				entity = businessDelegatorView.getDatPlanAnualFabrica(id);
			}

			Date date = new Date();
			entity.setFechaAnulacion(date);
			entity.setEstado("I");
			entity.setObservacionAnularReg(FacesUtils.checkString(txtObservacionAnularReg));
			businessDelegatorView.updateDatPlanAnualFabrica(entity);

			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYANULADE);
			action_clear();
			data = null;

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_anularReg(ActionEvent evt) {

		action_clear();
		selectedDatPlanAnualFabrica = (DatPlanAnualFabricaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatPlanAnualFabrica"));
		setShowDialog(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!",
				"¿Esta seguro que desea anular este registro? Una vez anulado, no hay vuelta atrás. Por favor, estar seguro."));
		return "";

	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedDatPlanAnualFabrica = (DatPlanAnualFabricaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanAnualFabrica"));

			Long datPlanAnualFabricaId = new Long(selectedDatPlanAnualFabrica.getDatPlanAnualFabricaId());
			entity = businessDelegatorView.getDatPlanAnualFabrica(datPlanAnualFabricaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datPlanAnualFabricaId = FacesUtils.checkLong(txtDatPlanAnualFabricaId);
			entity = businessDelegatorView.getDatPlanAnualFabrica(datPlanAnualFabricaId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatPlanAnualFabrica(entity);
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
			selectedDatPlanAnualFabrica = (DatPlanAnualFabricaDTO) (evt.getComponent().getAttributes()
					.get("selectedDatPlanAnualFabrica"));

			Long datPlanAnualFabricaId = new Long(selectedDatPlanAnualFabrica.getDatPlanAnualFabricaId());
			entity = businessDelegatorView.getDatPlanAnualFabrica(datPlanAnualFabricaId);
			businessDelegatorView.deleteDatPlanAnualFabrica(entity);
			data.remove(selectedDatPlanAnualFabrica);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long anio, Long compania, Long consecutivo, Long datPlanAnualFabricaId,
			String estado, Date fechaAnulacion, Date fechaCreacion, Date fechaModificacion, Double horasArranque,
			String observacion, String observacionAnularReg, String origenDatos, Double produccionAbril,
			Double produccionAgosto, Double produccionDiciembre, Double produccionEnero, Double produccionFebrero,
			Double produccionJulio, Double produccionJunio, Double produccionMarzo, Double produccionMayo,
			Double produccionNoviembre, Double produccionOctubre, Double produccionSeptiembre, Double produccionTotal,
			Long usuarioDigitacion) throws Exception {
		try {
			entity.setAnio(FacesUtils.checkLong(anio));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setConsecutivo(FacesUtils.checkLong(consecutivo));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaAnulacion(FacesUtils.checkDate(fechaAnulacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setHorasArranque(FacesUtils.checkDouble(horasArranque));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionAnularReg(FacesUtils.checkString(observacionAnularReg));
			entity.setOrigenDatos(FacesUtils.checkString(origenDatos));
			entity.setProduccionAbril(FacesUtils.checkDouble(produccionAbril));
			entity.setProduccionAgosto(FacesUtils.checkDouble(produccionAgosto));
			entity.setProduccionDiciembre(FacesUtils.checkDouble(produccionDiciembre));
			entity.setProduccionEnero(FacesUtils.checkDouble(produccionEnero));
			entity.setProduccionFebrero(FacesUtils.checkDouble(produccionFebrero));
			entity.setProduccionJulio(FacesUtils.checkDouble(produccionJulio));
			entity.setProduccionJunio(FacesUtils.checkDouble(produccionJunio));
			entity.setProduccionMarzo(FacesUtils.checkDouble(produccionMarzo));
			entity.setProduccionMayo(FacesUtils.checkDouble(produccionMayo));
			entity.setProduccionNoviembre(FacesUtils.checkDouble(produccionNoviembre));
			entity.setProduccionOctubre(FacesUtils.checkDouble(produccionOctubre));
			entity.setProduccionSeptiembre(FacesUtils.checkDouble(produccionSeptiembre));
			entity.setProduccionTotal(FacesUtils.checkDouble(produccionTotal));
			entity.setUsuarioDigitacion(FacesUtils.checkLong(usuarioDigitacion));
			businessDelegatorView.updateDatPlanAnualFabrica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatPlanAnualFabricaView").requestRender();
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

	public InputText getTxtDatPlanAnualFabricaId() {
		return txtDatPlanAnualFabricaId;
	}

	public void setTxtDatPlanAnualFabricaId(InputText txtDatPlanAnualFabricaId) {
		this.txtDatPlanAnualFabricaId = txtDatPlanAnualFabricaId;
	}

	public List<DatPlanAnualFabricaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatPlanAnualFabrica();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatPlanAnualFabricaDTO> datPlanAnualFabricaDTO) {
		this.data = datPlanAnualFabricaDTO;
	}

	public DatPlanAnualFabricaDTO getSelectedDatPlanAnualFabrica() {
		return selectedDatPlanAnualFabrica;
	}

	public void setSelectedDatPlanAnualFabrica(DatPlanAnualFabricaDTO datPlanAnualFabrica) {
		this.selectedDatPlanAnualFabrica = datPlanAnualFabrica;
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

	public Spinner getTxtAnio() {
		return txtAnio;
	}

	public void setTxtAnio(Spinner txtAnio) {
		this.txtAnio = txtAnio;
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

	public Spinner getTxtProduccionAbril() {
		return txtProduccionAbril;
	}

	public void setTxtProduccionAbril(Spinner txtProduccionAbril) {
		this.txtProduccionAbril = txtProduccionAbril;
	}

	public Spinner getTxtProduccionAgosto() {
		return txtProduccionAgosto;
	}

	public void setTxtProduccionAgosto(Spinner txtProduccionAgosto) {
		this.txtProduccionAgosto = txtProduccionAgosto;
	}

	public Spinner getTxtProduccionDiciembre() {
		return txtProduccionDiciembre;
	}

	public void setTxtProduccionDiciembre(Spinner txtProduccionDiciembre) {
		this.txtProduccionDiciembre = txtProduccionDiciembre;
	}

	public Spinner getTxtProduccionEnero() {
		return txtProduccionEnero;
	}

	public void setTxtProduccionEnero(Spinner txtProduccionEnero) {
		this.txtProduccionEnero = txtProduccionEnero;
	}

	public Spinner getTxtProduccionFebrero() {
		return txtProduccionFebrero;
	}

	public void setTxtProduccionFebrero(Spinner txtProduccionFebrero) {
		this.txtProduccionFebrero = txtProduccionFebrero;
	}

	public Spinner getTxtProduccionJulio() {
		return txtProduccionJulio;
	}

	public void setTxtProduccionJulio(Spinner txtProduccionJulio) {
		this.txtProduccionJulio = txtProduccionJulio;
	}

	public Spinner getTxtProduccionJunio() {
		return txtProduccionJunio;
	}

	public void setTxtProduccionJunio(Spinner txtProduccionJunio) {
		this.txtProduccionJunio = txtProduccionJunio;
	}

	public Spinner getTxtProduccionMarzo() {
		return txtProduccionMarzo;
	}

	public void setTxtProduccionMarzo(Spinner txtProduccionMarzo) {
		this.txtProduccionMarzo = txtProduccionMarzo;
	}

	public Spinner getTxtProduccionMayo() {
		return txtProduccionMayo;
	}

	public void setTxtProduccionMayo(Spinner txtProduccionMayo) {
		this.txtProduccionMayo = txtProduccionMayo;
	}

	public Spinner getTxtProduccionNoviembre() {
		return txtProduccionNoviembre;
	}

	public void setTxtProduccionNoviembre(Spinner txtProduccionNoviembre) {
		this.txtProduccionNoviembre = txtProduccionNoviembre;
	}

	public Spinner getTxtProduccionOctubre() {
		return txtProduccionOctubre;
	}

	public void setTxtProduccionOctubre(Spinner txtProduccionOctubre) {
		this.txtProduccionOctubre = txtProduccionOctubre;
	}

	public Spinner getTxtProduccionSeptiembre() {
		return txtProduccionSeptiembre;
	}

	public void setTxtProduccionSeptiembre(Spinner txtProduccionSeptiembre) {
		this.txtProduccionSeptiembre = txtProduccionSeptiembre;
	}

	public InputText getTxtProduccionTotal() {
		return txtProduccionTotal;
	}

	public void setTxtProduccionTotal(InputText txtProduccionTotal) {
		this.txtProduccionTotal = txtProduccionTotal;
	}

	public void listener_calcularProduccionTotal() {
		Double result = 0.0;
		if (txtProduccionEnero.getValue() != null && txtProduccionFebrero.getValue() != null
				&& txtProduccionMarzo.getValue() != null && txtProduccionAbril.getValue() != null
				&& txtProduccionMayo.getValue() != null && txtProduccionJunio.getValue() != null
				&& txtProduccionJulio.getValue() != null && txtProduccionAgosto.getValue() != null
				&& txtProduccionSeptiembre.getValue() != null && txtProduccionOctubre.getValue() != null
				&& txtProduccionNoviembre.getValue() != null && txtProduccionDiciembre.getValue() != null) {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			Double p1 = FacesUtils.checkDouble(txtProduccionEnero);
			Double p2 = FacesUtils.checkDouble(txtProduccionFebrero);
			Double p3 = FacesUtils.checkDouble(txtProduccionMarzo);
			Double p4 = FacesUtils.checkDouble(txtProduccionAbril);
			Double p5 = FacesUtils.checkDouble(txtProduccionMayo);
			Double p6 = FacesUtils.checkDouble(txtProduccionJunio);
			Double p7 = FacesUtils.checkDouble(txtProduccionJulio);
			Double p8 = FacesUtils.checkDouble(txtProduccionAgosto);
			Double p9 = FacesUtils.checkDouble(txtProduccionSeptiembre);
			Double p10 = FacesUtils.checkDouble(txtProduccionOctubre);
			Double p11 = FacesUtils.checkDouble(txtProduccionNoviembre);
			Double p12 = FacesUtils.checkDouble(txtProduccionDiciembre);

			result = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10 + p11 + p12;
			String format = decimalFormat.format(result);
			txtProduccionTotal.setValue(format);
		} else {
			txtProduccionTotal.setValue(0.0);
		}
	}

	
	public void listener_calcularProduccionEstimadaTotal() {
		Double result = 0.0;
		if (txtProduccionEstEnero.getValue() != null && txtProduccionEstFebrero.getValue() != null
				&& txtProduccionEstMarzo.getValue() != null && txtProduccionEstAbril.getValue() != null
				&& txtProduccionEstMayo.getValue() != null && txtProduccionEstJunio.getValue() != null
				&& txtProduccionEstJulio.getValue() != null && txtProduccionEstAgosto.getValue() != null
				&& txtProduccionEstSeptiembre.getValue() != null && txtProduccionEstOctubre.getValue() != null
				&& txtProduccionEstNoviembre.getValue() != null && txtProduccionEstDiciembre.getValue() != null) {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			Double p1 = FacesUtils.checkDouble(txtProduccionEstEnero);
			Double p2 = FacesUtils.checkDouble(txtProduccionEstFebrero);
			Double p3 = FacesUtils.checkDouble(txtProduccionEstMarzo);
			Double p4 = FacesUtils.checkDouble(txtProduccionEstAbril);
			Double p5 = FacesUtils.checkDouble(txtProduccionEstMayo);
			Double p6 = FacesUtils.checkDouble(txtProduccionEstJunio);
			Double p7 = FacesUtils.checkDouble(txtProduccionEstJulio);
			Double p8 = FacesUtils.checkDouble(txtProduccionEstAgosto);
			Double p9 = FacesUtils.checkDouble(txtProduccionEstSeptiembre);
			Double p10 = FacesUtils.checkDouble(txtProduccionEstOctubre);
			Double p11 = FacesUtils.checkDouble(txtProduccionEstNoviembre);
			Double p12 = FacesUtils.checkDouble(txtProduccionEstDiciembre);

			result = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10 + p11 + p12;
			String format = decimalFormat.format(result);
			txtProduccionEstTotal.setValue(format);
		} else {
			txtProduccionEstTotal.setValue(0.0);
		}
	}

	/**
	 * @return the activeTapIndex
	 */
	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	/**
	 * @param activeTapIndex the activeTapIndex to set
	 */
	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	/**
	 * @return the txtHorasMttoNoProgEjec
	 */
	public Spinner getTxtHorasMttoNoProgEjec() {
		return txtHorasMttoNoProgEjec;
	}

	/**
	 * @param txtHorasMttoNoProgEjec the txtHorasMttoNoProgEjec to set
	 */
	public void setTxtHorasMttoNoProgEjec(Spinner txtHorasMttoNoProgEjec) {
		this.txtHorasMttoNoProgEjec = txtHorasMttoNoProgEjec;
	}

	/**
	 * @return the txtHorasMttoNoProgEst
	 */
	public Spinner getTxtHorasMttoNoProgEst() {
		return txtHorasMttoNoProgEst;
	}

	/**
	 * @param txtHorasMttoNoProgEst the txtHorasMttoNoProgEst to set
	 */
	public void setTxtHorasMttoNoProgEst(Spinner txtHorasMttoNoProgEst) {
		this.txtHorasMttoNoProgEst = txtHorasMttoNoProgEst;
	}

	/**
	 * @return the txtHorasMttoProgEjec
	 */
	public Spinner getTxtHorasMttoProgEjec() {
		return txtHorasMttoProgEjec;
	}

	/**
	 * @param txtHorasMttoProgEjec the txtHorasMttoProgEjec to set
	 */
	public void setTxtHorasMttoProgEjec(Spinner txtHorasMttoProgEjec) {
		this.txtHorasMttoProgEjec = txtHorasMttoProgEjec;
	}

	/**
	 * @return the txtHorasMttoProgEst
	 */
	public Spinner getTxtHorasMttoProgEst() {
		return txtHorasMttoProgEst;
	}

	/**
	 * @param txtHorasMttoProgEst the txtHorasMttoProgEst to set
	 */
	public void setTxtHorasMttoProgEst(Spinner txtHorasMttoProgEst) {
		this.txtHorasMttoProgEst = txtHorasMttoProgEst;
	}

	
	/**
	 * @return the txtHorasPlantaEjec
	 */
	public InputText getTxtHorasPlantaEjec() {
		return txtHorasPlantaEjec;
	}

	/**
	 * @param txtHorasPlantaEjec the txtHorasPlantaEjec to set
	 */
	public void setTxtHorasPlantaEjec(InputText txtHorasPlantaEjec) {
		this.txtHorasPlantaEjec = txtHorasPlantaEjec;
	}

	/**
	 * @return the txtHorasPlantaEst
	 */
	public InputText getTxtHorasPlantaEst() {
		return txtHorasPlantaEst;
	}

	/**
	 * @param txtHorasPlantaEst the txtHorasPlantaEst to set
	 */
	public void setTxtHorasPlantaEst(InputText txtHorasPlantaEst) {
		this.txtHorasPlantaEst = txtHorasPlantaEst;
	}

	/**
	 * @return the txtHorasProcesoEjec
	 */
	public InputText getTxtHorasProcesoEjec() {
		return txtHorasProcesoEjec;
	}

	/**
	 * @param txtHorasProcesoEjec the txtHorasProcesoEjec to set
	 */
	public void setTxtHorasProcesoEjec(InputText txtHorasProcesoEjec) {
		this.txtHorasProcesoEjec = txtHorasProcesoEjec;
	}

	/**
	 * @return the txtHorasProcesoEst
	 */
	public InputText getTxtHorasProcesoEst() {
		return txtHorasProcesoEst;
	}

	/**
	 * @param txtHorasProcesoEst the txtHorasProcesoEst to set
	 */
	public void setTxtHorasProcesoEst(InputText txtHorasProcesoEst) {
		this.txtHorasProcesoEst = txtHorasProcesoEst;
	}

	/**
	 * @return the txtProduccionEstAbril
	 */
	public Spinner getTxtProduccionEstAbril() {
		return txtProduccionEstAbril;
	}

	/**
	 * @param txtProduccionEstAbril the txtProduccionEstAbril to set
	 */
	public void setTxtProduccionEstAbril(Spinner txtProduccionEstAbril) {
		this.txtProduccionEstAbril = txtProduccionEstAbril;
	}

	/**
	 * @return the txtProduccionEstAgosto
	 */
	public Spinner getTxtProduccionEstAgosto() {
		return txtProduccionEstAgosto;
	}

	/**
	 * @param txtProduccionEstAgosto the txtProduccionEstAgosto to set
	 */
	public void setTxtProduccionEstAgosto(Spinner txtProduccionEstAgosto) {
		this.txtProduccionEstAgosto = txtProduccionEstAgosto;
	}

	/**
	 * @return the txtProduccionEstDiciembre
	 */
	public Spinner getTxtProduccionEstDiciembre() {
		return txtProduccionEstDiciembre;
	}

	/**
	 * @param txtProduccionEstDiciembre the txtProduccionEstDiciembre to set
	 */
	public void setTxtProduccionEstDiciembre(Spinner txtProduccionEstDiciembre) {
		this.txtProduccionEstDiciembre = txtProduccionEstDiciembre;
	}

	/**
	 * @return the txtProduccionEstEnero
	 */
	public Spinner getTxtProduccionEstEnero() {
		return txtProduccionEstEnero;
	}

	/**
	 * @param txtProduccionEstEnero the txtProduccionEstEnero to set
	 */
	public void setTxtProduccionEstEnero(Spinner txtProduccionEstEnero) {
		this.txtProduccionEstEnero = txtProduccionEstEnero;
	}

	/**
	 * @return the txtProduccionEstFebrero
	 */
	public Spinner getTxtProduccionEstFebrero() {
		return txtProduccionEstFebrero;
	}

	/**
	 * @param txtProduccionEstFebrero the txtProduccionEstFebrero to set
	 */
	public void setTxtProduccionEstFebrero(Spinner txtProduccionEstFebrero) {
		this.txtProduccionEstFebrero = txtProduccionEstFebrero;
	}

	/**
	 * @return the txtProduccionEstJulio
	 */
	public Spinner getTxtProduccionEstJulio() {
		return txtProduccionEstJulio;
	}

	/**
	 * @param txtProduccionEstJulio the txtProduccionEstJulio to set
	 */
	public void setTxtProduccionEstJulio(Spinner txtProduccionEstJulio) {
		this.txtProduccionEstJulio = txtProduccionEstJulio;
	}

	/**
	 * @return the txtProduccionEstJunio
	 */
	public Spinner getTxtProduccionEstJunio() {
		return txtProduccionEstJunio;
	}

	/**
	 * @param txtProduccionEstJunio the txtProduccionEstJunio to set
	 */
	public void setTxtProduccionEstJunio(Spinner txtProduccionEstJunio) {
		this.txtProduccionEstJunio = txtProduccionEstJunio;
	}

	/**
	 * @return the txtProduccionEstMarzo
	 */
	public Spinner getTxtProduccionEstMarzo() {
		return txtProduccionEstMarzo;
	}

	/**
	 * @param txtProduccionEstMarzo the txtProduccionEstMarzo to set
	 */
	public void setTxtProduccionEstMarzo(Spinner txtProduccionEstMarzo) {
		this.txtProduccionEstMarzo = txtProduccionEstMarzo;
	}

	/**
	 * @return the txtProduccionEstMayo
	 */
	public Spinner getTxtProduccionEstMayo() {
		return txtProduccionEstMayo;
	}

	/**
	 * @param txtProduccionEstMayo the txtProduccionEstMayo to set
	 */
	public void setTxtProduccionEstMayo(Spinner txtProduccionEstMayo) {
		this.txtProduccionEstMayo = txtProduccionEstMayo;
	}

	/**
	 * @return the txtProduccionEstNoviembre
	 */
	public Spinner getTxtProduccionEstNoviembre() {
		return txtProduccionEstNoviembre;
	}

	/**
	 * @param txtProduccionEstNoviembre the txtProduccionEstNoviembre to set
	 */
	public void setTxtProduccionEstNoviembre(Spinner txtProduccionEstNoviembre) {
		this.txtProduccionEstNoviembre = txtProduccionEstNoviembre;
	}

	/**
	 * @return the txtProduccionEstOctubre
	 */
	public Spinner getTxtProduccionEstOctubre() {
		return txtProduccionEstOctubre;
	}

	/**
	 * @param txtProduccionEstOctubre the txtProduccionEstOctubre to set
	 */
	public void setTxtProduccionEstOctubre(Spinner txtProduccionEstOctubre) {
		this.txtProduccionEstOctubre = txtProduccionEstOctubre;
	}

	/**
	 * @return the txtProduccionEstSeptiembre
	 */
	public Spinner getTxtProduccionEstSeptiembre() {
		return txtProduccionEstSeptiembre;
	}

	/**
	 * @param txtProduccionEstSeptiembre the txtProduccionEstSeptiembre to set
	 */
	public void setTxtProduccionEstSeptiembre(Spinner txtProduccionEstSeptiembre) {
		this.txtProduccionEstSeptiembre = txtProduccionEstSeptiembre;
	}

	/**
	 * @return the txtValorPromedioHrDia
	 */
	public Spinner getTxtValorPromedioHrDia() {
		return txtValorPromedioHrDia;
	}

	/**
	 * @param txtValorPromedioHrDia the txtValorPromedioHrDia to set
	 */
	public void setTxtValorPromedioHrDia(Spinner txtValorPromedioHrDia) {
		this.txtValorPromedioHrDia = txtValorPromedioHrDia;
	}

	/**
	 * @return the txtVelocidadEstandar
	 */
	public Spinner getTxtVelocidadEstandar() {
		return txtVelocidadEstandar;
	}

	/**
	 * @param txtVelocidadEstandar the txtVelocidadEstandar to set
	 */
	public void setTxtVelocidadEstandar(Spinner txtVelocidadEstandar) {
		this.txtVelocidadEstandar = txtVelocidadEstandar;
	}

	/**
	 * @return the txtProduccionEstTotal
	 */
	public InputText getTxtProduccionEstTotal() {
		return txtProduccionEstTotal;
	}

	/**
	 * @param txtProduccionEstTotal the txtProduccionEstTotal to set
	 */
	public void setTxtProduccionEstTotal(InputText txtProduccionEstTotal) {
		this.txtProduccionEstTotal = txtProduccionEstTotal;
	}
	
	
	public void listener_calcularHorasPlantaEstimado() {
		Double result = 0.0;
		if (txtHorasProcesoEst.getValue() != null && txtHorasArranque.getValue() != null
				&& txtHorasMttoProgEst.getValue() != null && txtHorasMttoNoProgEst.getValue() != null
				) {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			Double p1 = FacesUtils.checkDouble(txtHorasProcesoEst);
			Double p2 = FacesUtils.checkDouble(txtHorasArranque);
			Double p3 = FacesUtils.checkDouble(txtHorasMttoProgEst);
			Double p4 = FacesUtils.checkDouble(txtHorasMttoNoProgEst);
			
			result = p1 + p2 - p3 - p4 ;
			String format = decimalFormat.format(result);
			txtHorasPlantaEst.setValue(format);
		} else {
			txtHorasPlantaEst.setValue(0.0);
		}
	}


	public void listener_calcularHorasPlantaEjecutado() {
		Double result = 0.0;
		if (txtHorasProcesoEjec.getValue() != null && txtHorasArranque.getValue() != null
				&& txtHorasMttoProgEjec.getValue() != null && txtHorasMttoNoProgEjec.getValue() != null
				) {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			Double p1 = FacesUtils.checkDouble(txtHorasProcesoEjec);
			Double p2 = FacesUtils.checkDouble(txtHorasArranque);
			Double p3 = FacesUtils.checkDouble(txtHorasMttoProgEjec);
			Double p4 = FacesUtils.checkDouble(txtHorasMttoNoProgEjec);
			
			result = p1 + p2 - p3 - p4 ;
			String format = decimalFormat.format(result);
			txtHorasPlantaEjec.setValue(format);
		} else {
			txtHorasPlantaEjec.setValue(0.0);
		}
	}
	
	public void listener_calcularHorasProcesoEstimado() {
		Double result = 0.0;
		if (txtProduccionEstTotal.getValue() != null && txtVelocidadEstandar.getValue() != null
				
				) {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			Double p1 = FacesUtils.checkDouble(txtProduccionEstTotal);
			Double p2 = FacesUtils.checkDouble(txtVelocidadEstandar);
			if(p2>0){
				result = p1/p2 ;
			}
			String format = decimalFormat.format(result);
			txtHorasProcesoEst.setValue(format);
		} else {
			txtHorasProcesoEst.setValue(0.0);
		}
	}
	
	public void listener_calcularHorasProcesoEjecutado() {
		Double result = 0.0;
		if (txtProduccionTotal.getValue() != null && txtVelocidadEstandar.getValue() != null
				
				) {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			String pattern = "###.####";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

			Double p1 = FacesUtils.checkDouble(txtProduccionTotal);
			Double p2 = FacesUtils.checkDouble(txtVelocidadEstandar);
			if(p2>0){
				result = p1/p2 ;
			}
			String format = decimalFormat.format(result);
			txtHorasProcesoEjec.setValue(format);
		} else {
			txtHorasProcesoEjec.setValue(0.0);
		}
	}

	/**
	 * @return the txtHorasArranque
	 */
	public Spinner getTxtHorasArranque() {
		return txtHorasArranque;
	}

	/**
	 * @param txtHorasArranque the txtHorasArranque to set
	 */
	public void setTxtHorasArranque(Spinner txtHorasArranque) {
		this.txtHorasArranque = txtHorasArranque;
	}
	
	
	
			

}
