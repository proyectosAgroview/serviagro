package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.map.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.EquipoEvento;
import co.com.arcosoft.modelo.Eventos;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.EquipoEventoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaEventosPorPagarDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class datConsultaEventosPorPagarView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(datConsultaEventosPorPagarView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;
	private MapModel simpleModel;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsultaEventosPorPagarDTO> data;
	private ConsultaEventosPorPagarDTO selectedRegistro;
	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private EquipoEventoDTO selectedEquipoEvento;
	private EquipoEvento entityEquipoEvento;

	private CommandButton btnSave;

	private SelectOneMenu txtEquipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtEvento;
	SelectItem[] selectEvento;
	private List<Eventos> eventos;

	private Spinner txtValorTotal;
	private InputText txtIdRegistro;
	private Calendar txtFechaPago;

	private List<String> selectedPropietario;
	private List<PersEmpr> propietarios;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private List<String> selectedEventos;
	private List<Eventos> eventosEquipo;

	private SelectOneMenu txtProveedor;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;
	private String moduloActivo;
	private String modulo;

	public datConsultaEventosPorPagarView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	public void moduloSeleccionado() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Object contextPath = peticion.getContextPath();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				moduloActivo = cookie2.getValue();

			}
		}

		if (moduloActivo.equals("mantenimiento_maquinaria")) {

			modulo= "Modulo_TallerAgricola";

		} else {

			modulo="Modulo_MttoIndustrial";

		}
	}

	public void itemSelect(ItemSelectEvent event) {
		
		moduloSeleccionado();

		setShowDialog(true);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<ConsultaEventosPorPagarDTO> getData() {
		try {
			// Long compania = 1L;

			Long compania = new Long(getCompaniaIdSession());
			Date fechaInicial = null;
			Date fechaFinal = null;
			// fechaInicial = sdf.parse("2013-01-01");
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			// fechaFinal = sdf.parse("2015-12-31");
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			// String zona = "1";
			Long flagPropietario = 1L;
			Long flagEvento = 1L;
			Long flagEquipo = 1L;

			String eventosSeleccionadas = "";
			if (selectedEventos != null && selectedEventos.size() > 0) {
				eventosSeleccionadas = selectedEventos.get(0);
				flagEvento = 0L;
				for (int i = 1; i < selectedEventos.size(); i++) {
					eventosSeleccionadas += "," + selectedEventos.get(i);
				}
			}

			String propietariosSeleccionadas = "";
			if (selectedPropietario != null && selectedPropietario.size() > 0) {
				propietariosSeleccionadas = selectedPropietario.get(0);
				flagPropietario = 0L;
				for (int i = 1; i < selectedPropietario.size(); i++) {
					propietariosSeleccionadas += "," + selectedPropietario.get(i);
				}
			}

			String equiposSeleccionadas = "";
			if (selectedEquipo != null && selectedEquipo.size() > 0) {
				equiposSeleccionadas = selectedEquipo.get(0);
				flagEquipo = 0L;
				for (int i = 1; i < selectedEquipo.size(); i++) {
					equiposSeleccionadas += "," + selectedEquipo.get(i);
				}
			}

			if (compania != null) {

				data = businessDelegatorView.consultarEventosPorPagar(compania, fechaInicial, fechaFinal,
						equiposSeleccionadas, flagEquipo, propietariosSeleccionadas, flagPropietario,
						eventosSeleccionadas, flagEvento);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public String action_Pagar(ActionEvent evt) {
		selectedRegistro = (ConsultaEventosPorPagarDTO) (evt.getComponent().getAttributes().get("selectedRegistro"));

		try {

			Long idRegistro = selectedRegistro.getIdEquipoEvento().longValue();
			Object[] condicion = { "id", true, idRegistro, "=" };
			List<EquipoEvento> lista = (idRegistro != null)
					? businessDelegatorView.findByCriteriaInEquipoEvento(condicion, null, null)
					: null;
			if (lista != null && lista.size() > 0) {
				entityEquipoEvento = lista.get(0);

				txtIdRegistro.setValue(entityEquipoEvento.getId());
				txtIdRegistro.setDisabled(true);

				Long idEquipo = selectedRegistro.getEquipoId().longValue();
				Long idEvento = selectedRegistro.getIdEvento().longValue();

				Long idProveedor = selectedRegistro.getIdProveedor().longValue();

				Equipo equipoM = businessDelegatorView.getEquipo(idEquipo);
				Eventos eventoM = businessDelegatorView.getEventos(idEvento);

				txtEquipo.setValue(equipoM.getEquipoId());
				txtEquipo.setDisabled(true);
				txtEvento.setValue(eventoM.getEventosId());
				txtEvento.setDisabled(true);

				if (idProveedor == 0) {
					txtProveedor.setValue(null);
					txtProveedor.setDisabled(false);

				} else {
					PersEmpr persEmpr = businessDelegatorView.getPersEmpr(idProveedor);
					txtProveedor.setValue(persEmpr.getPersEmprId());
					txtProveedor.setDisabled(false);

				}

				Date date = new Date();
				txtFechaPago.setValue(entityEquipoEvento.getFechaPago());
				txtFechaPago.setDisabled(false);

				txtValorTotal.setValue(entityEquipoEvento.getValorEvento());
				txtValorTotal.setDisabled(false);

				/******* sesion concerniente al detalle por producto ***/
				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entityEquipoEvento = null;
		}

		return "";
	}

	public String action_savePago() {
		try {
			Long id = null;
			if (entityEquipoEvento == null) {
				id = new Long(selectedEquipoEvento.getId());
				entityEquipoEvento = businessDelegatorView.getEquipoEvento(id);
			}

			Date date = new Date();

			entityEquipoEvento.setId(FacesUtils.checkLong(txtIdRegistro));
			entityEquipoEvento.setFechaPago(FacesUtils.checkDate(txtFechaPago));
			entityEquipoEvento.setValorEvento(FacesUtils.checkDouble(txtValorTotal));
			entityEquipoEvento.setRegistraPago("SI");
			entityEquipoEvento.setPersEmprId(FacesUtils.checkLong(txtProveedor));
			businessDelegatorView.updateEquipoEvento(entityEquipoEvento);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);

			txtIdRegistro.setValue(null);
			txtFechaPago.setValue(null);
			txtValorTotal.setValue(0.0);
			txtEquipo.setValue(null);
			txtEvento.setValue(null);
			txtProveedor.setValue(null);

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
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

	public List<String> getSelectedVariedades() {
		return selectedVariedades;
	}

	public void setSelectedVariedades(List<String> selectedVariedades) {
		this.selectedVariedades = selectedVariedades;
	}

	public List<Variedad> getVariedades() {

		if (variedades == null || variedades.size() == 0) {

			variedades = new ArrayList<Variedad>();

			try {
				variedades = businessDelegatorView.getVariedad();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return variedades;
	}

	public void setVariedades(List<Variedad> variedades) {
		this.variedades = variedades;
	}

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public SelectItem[] getSelectCompania() {
		if (compania == null || compania.size() == 0) {// Para que vaya solo una
														// vez a la base de
														// datos

			compania = new ArrayList<Compania>();

			try {

				compania = businessDelegatorView.getCompania();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Compania> lista = businessDelegatorView.findByCriteriaInCompania(condicion, null, null);
				selectCompania = new SelectItem[lista.size()];

				int i = 0;
				for (Compania compania : lista) {
					selectCompania[i] = new SelectItem(compania.getCompaniaId(), compania.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCompania;
	}

	public void setSelectCompania(SelectItem[] selectCompania) {
		this.selectCompania = selectCompania;
	}

	public SelectOneMenu getTxtCultivoId_Cultivo() {
		return txtCultivoId_Cultivo;
	}

	public void setTxtCultivoId_Cultivo(SelectOneMenu txtCultivoId_Cultivo) {
		this.txtCultivoId_Cultivo = txtCultivoId_Cultivo;
	}

	public SelectItem[] getSelectCultivo() {

		if (cultivo == null || cultivo.size() == 0) {// Para que vaya solo una
														// vez a la base de
														// datos

			cultivo = new ArrayList<Cultivo>();

			try {

				cultivo = businessDelegatorView.getCultivo();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Cultivo> lista = businessDelegatorView.findByCriteriaInCultivo(condicion, null, null);
				selectCultivo = new SelectItem[lista.size()];

				int i = 0;
				for (Cultivo cultivo : lista) {
					selectCultivo[i] = new SelectItem(cultivo.getCultivoId(), cultivo.getNombre());
					i++;
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCultivo;
	}

	public void setSelectCultivo(SelectItem[] selectCultivo) {
		this.selectCultivo = selectCultivo;
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

	private class LocalDataModelDTO extends LazyDataModel<ConsultaEventosPorPagarDTO> {
		private static final long serialVersionUID = 1L;
		private List<ConsultaEventosPorPagarDTO> ConsultaEventosPorPagarDTO;

		public LocalDataModelDTO() {
		}
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public SelectItem[] getselectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			equipo = new ArrayList<Equipo>();

			try {
                
				moduloSeleccionado();
				String m = modulo;
				Object[] condicion = { "estado", true, "A", "=", "origenDatos",true,m,"=" };
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

	public SelectItem[] getSelectEvento() {

		if (eventos == null || eventos.size() == 0) {

			eventos = new ArrayList<Eventos>();

			try {

				eventos = businessDelegatorView.getEventos();

				Object[] condicion = { "estado", true, "A", "=" };
				List<Eventos> lista = businessDelegatorView.findByCriteriaInEventos(condicion, null, null);
				selectEvento = new SelectItem[lista.size()];

				int i = 0;
				for (Eventos ev : lista) {
					selectEvento[i] = new SelectItem(ev.getEventosId(), ev.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return selectEvento;
	}

	public void setSelectEvento(SelectItem[] selectEvento) {
		this.selectEvento = selectEvento;
	}

	public EquipoEventoDTO getSelectedEquipoEvento() {
		return selectedEquipoEvento;
	}

	public void setSelectedEquipoEvento(EquipoEventoDTO selectedEquipoEvento) {
		this.selectedEquipoEvento = selectedEquipoEvento;
	}

	public EquipoEvento getEntityEquipoEvento() {
		return entityEquipoEvento;
	}

	public void setEntityEquipoEvento(EquipoEvento entityEquipoEvento) {
		this.entityEquipoEvento = entityEquipoEvento;
	}

	public SelectOneMenu getTxtEquipo() {
		return txtEquipo;
	}

	public void setTxtEquipo(SelectOneMenu txtEquipo) {
		this.txtEquipo = txtEquipo;
	}

	public SelectOneMenu getTxtEvento() {
		return txtEvento;
	}

	public void setTxtEvento(SelectOneMenu txtEvento) {
		this.txtEvento = txtEvento;
	}

	public Spinner getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(Spinner txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public InputText getTxtIdRegistro() {
		return txtIdRegistro;
	}

	public void setTxtIdRegistro(InputText txtIdRegistro) {
		this.txtIdRegistro = txtIdRegistro;
	}

	public Calendar getTxtFechaPago() {
		return txtFechaPago;
	}

	public void setTxtFechaPago(Calendar txtFechaPago) {
		this.txtFechaPago = txtFechaPago;
	}

	public List<String> getSelectedPropietario() {
		return selectedPropietario;
	}

	public void setSelectedPropietario(List<String> selectedPropietario) {
		this.selectedPropietario = selectedPropietario;
	}

	public List<PersEmpr> getPropietarios() {
		if (propietarios == null || propietarios.size() == 0) {

			propietarios = new ArrayList<PersEmpr>();

			try {
				propietarios = businessDelegatorView.getPersEmpr();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return propietarios;
	}

	public void setPropietarios(List<PersEmpr> propietarios) {
		this.propietarios = propietarios;
	}

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			equipos = new ArrayList<Equipo>();

			try {
				equipos = businessDelegatorView.getEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<String> getSelectedEventos() {
		return selectedEventos;
	}

	public void setSelectedEventos(List<String> selectedEventos) {
		this.selectedEventos = selectedEventos;
	}

	public List<Eventos> getEventosEquipo() {
		if (eventosEquipo == null || eventosEquipo.size() == 0) {

			eventosEquipo = new ArrayList<Eventos>();

			try {
				eventosEquipo = businessDelegatorView.getEventos();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return eventosEquipo;
	}

	public void setEventosEquipo(List<Eventos> eventosEquipo) {
		this.eventosEquipo = eventosEquipo;
	}

	public SelectOneMenu getTxtProveedor() {
		return txtProveedor;
	}

	public void setTxtProveedor(SelectOneMenu txtProveedor) {
		this.txtProveedor = txtProveedor;
	}

	public SelectItem[] getselectContratista() {

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

	public void setselectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}

	public String getModuloActivo() {
		return moduloActivo;
	}

	public void setModuloActivo(String moduloActivo) {
		this.moduloActivo = moduloActivo;
	}

}
