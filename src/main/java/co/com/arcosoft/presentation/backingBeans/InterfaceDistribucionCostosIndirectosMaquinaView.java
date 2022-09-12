package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.StreamedContent;
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DificultadAcceso;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DificultadAccesoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.DistribuccionCostosMaquinaDTO;
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
public class InterfaceDistribucionCostosIndirectosMaquinaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InterfaceDistribucionCostosIndirectosMaquinaView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;

	// private List<ProntuarioLotesDTO> data;
	private SelectOneMenu txtEstadoServicio;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;
	
	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private List<DistribuccionCostosMaquinaDTO> dataDistr;
	private DistribuccionCostosMaquinaDTO selectedDistr;
	
	private List<DistribuccionCostosMaquinaDTO> selectedDistr2;
	
	private List<DistribuccionCostosMaquinaDTO> dataDetalleCostos;
	
	private List<String> selectedVariedades;
	private List<Variedad> variedades;

	private SelectOneMenu txtCultivoId_Cultivo;
	SelectItem[] selectCultivo;
	private List<Cultivo> cultivo;

	private List<String> selectedNivel1;
	private List<Nivel1> zonas;

	private List<String> selectedNivel2;
	private List<Nivel2> fincas;

	private List<String> selectedNivel3;
	private List<Nivel3> bloques;

	private List<String> selectedNivel4;
	private List<Nivel4> lotes;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private List<String> selectedPropietario;
	private List<PersEmpr> propietarios;

	private List<String> selectedModelo;
	private List<ModeloEquipo> modelos;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	
	private StreamedContent file = null;
	private String disableButton = "true";

	private String disableDesPreFactura = "true";
	private StreamedContent filePreFactura = null;
	
	private String visible = "hidden";


	private List<String> selectedCliente;
	private List<PersEmpr> clientes;

	private List<String> selectedNivel2Clientesmq;
	private List<Nivel2Clientesmq> nivel2Clientesmq;
	
	private List<String> selectedOperador;
	private List<Trabajador> operadores;
	
	private InputText txtVlTotal;
	private InputNumber txtCantidad;
	private InputNumber txtHoras;
	
	private String disableButtonA = "false";
	private String disableButton1 = "false";
	private String disableNivel1 = "true";
	private String disableNivel2 = "true";
	String cadenaPrefactura ="";
	private InputText txtPin;

	private List<String> selectedCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipos;
	

	private InputNumber txtCantidadPago;				
	private InputNumber txtHorasTotales;
	private InputNumber txtIngresoTotal;
	private InputNumber txtCostoTotal;
	private InputNumber txtCombustible;
	private InputNumber txtGlnHr;
	private InputNumber txtAreaHr;
	private InputNumber txtGlnArea;
	private InputNumber txtCostoHr;
	private InputNumber txtCostoArea;
	private InputNumber txtIngresosHr;
	private InputNumber txtIngresosArea;
	private InputNumber txtUtilidad;
	private SelectItem[]  selectEquiposDistribuccion;
	private SelectOneMenu txtTipoCosto;

	
	private List<String> selectEquiposDistribucciones;
	private List<DistribuccionCostosMaquinaDTO> equipoDistr;
	
	private InputNumber txtCostoTotalDetalle;
	public InterfaceDistribucionCostosIndirectosMaquinaView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
	}

	
	public StreamedContent getFile() {

		return file;
	}

	public void setFile(StreamedContent file) {

		if (file != null) {
			this.file = file;
		}
	}

	public void itemSelect(ItemSelectEvent event) {

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

	public String getDisableButton() {
		return disableButton;
	}

	public void setDisableButton(String disableButton) {
		this.disableButton = disableButton;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public List<String> getSelectedVariedades() {
		return selectedVariedades;
	}

	public void setSelectedVariedades(List<String> selectedVariedades) {
		this.selectedVariedades = selectedVariedades;
	}

	public List<Variedad> getVariedades() {

		if (variedades == null || variedades.size() == 0) {

		
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

	public List<String> getSelectedNivel1() {
		return selectedNivel1;
	}

	public void setSelectedNivel1(List<String> selectedNivel1) {
		this.selectedNivel1 = selectedNivel1;
	}

	public List<Nivel1> getZonas() {
		if (zonas == null || zonas.size() == 0) {

		
			try {
				zonas = businessDelegatorView.getNivel1();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return zonas;
	}

	public void setZonas(List<Nivel1> zonas) {
		this.zonas = zonas;
	}

	public List<String> getSelectedNivel2() {
		return selectedNivel2;
	}

	public void setSelectedNivel2(List<String> selectedNivel2) {
		this.selectedNivel2 = selectedNivel2;
	}

	public List<Nivel2> getFincas() {

		if (fincas == null || fincas.size() == 0) {

			
			try {
				fincas = businessDelegatorView.getNivel2();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return fincas;
	}

	public void setFincas(List<Nivel2> fincas) {
		this.fincas = fincas;
	}

	public List<String> getSelectedNivel3() {
		return selectedNivel3;
	}

	public void setSelectedNivel3(List<String> selectedNivel3) {
		this.selectedNivel3 = selectedNivel3;
	}

	public List<Nivel3> getBloques() {
		if (bloques == null || bloques.size() == 0) {

			
			try {
				bloques = businessDelegatorView.getNivel3();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return bloques;
	}

	public void setBloques(List<Nivel3> bloques) {
		this.bloques = bloques;
	}

	public List<String> getSelectedNivel4() {
		return selectedNivel4;
	}

	public void setSelectedNivel4(List<String> selectedNivel4) {
		this.selectedNivel4 = selectedNivel4;
	}

	public List<Nivel4> getLotes() {

		if (lotes == null || lotes.size() == 0) {

			try {
				lotes = businessDelegatorView.getNivel4();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return lotes;
	}

	public void setLotes(List<Nivel4> lotes) {
		this.lotes = lotes;
	}

	public List<String> getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(List<String> selectedLabor) {
		this.selectedLabor = selectedLabor;
	}

	public List<Labor> getLabores() {
		if (labores == null || labores.size() == 0) {

			
			try {
				labores = businessDelegatorView.getLabor();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return labores;
	}

	public void setLabores(List<Labor> labores) {
		this.labores = labores;
	}

	public List<String> getSelectedGrupoLabor() {
		return selectedGrupoLabor;
	}

	public void setSelectedGrupoLabor(List<String> selectedGrupoLabor) {
		this.selectedGrupoLabor = selectedGrupoLabor;
	}

	public List<GrpLabor> getGrupoLabores() {
		if (grupoLabores == null || grupoLabores.size() == 0) {

			
			try {
				grupoLabores = businessDelegatorView.getGrpLabor();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return grupoLabores;
	}

	public void setGrupoLabores(List<GrpLabor> grupoLabores) {
		this.grupoLabores = grupoLabores;
	}

	public List<String> getSelectedTenencia() {
		return selectedTenencia;
	}

	public void setSelectedTenencia(List<String> selectedTenencia) {
		this.selectedTenencia = selectedTenencia;
	}

	public List<Tenencia> getTenencias() {
		if (tenencias == null || tenencias.size() == 0) {

		
			try {
				tenencias = businessDelegatorView.getTenencia();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return tenencias;
	}

	public void setTenencias(List<Tenencia> tenencias) {
		this.tenencias = tenencias;
	}

	public List<String> getSelectedUdadMed() {
		return selectedUdadMed;
	}

	public void setSelectedUdadMed(List<String> selectedUdadMed) {
		this.selectedUdadMed = selectedUdadMed;
	}

	public List<UdadMed> getUnidadesMedida() {
		if (unidadesMedida == null || unidadesMedida.size() == 0) {

		
			try {
				unidadesMedida = businessDelegatorView.getUdadMed();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return unidadesMedida;
	}

	public void setUnidadesMedida(List<UdadMed> unidadesMedida) {
		this.unidadesMedida = unidadesMedida;
	}

	public List<String> getSelectedPropietario() {
		return selectedPropietario;
	}

	public void setSelectedPropietario(List<String> selectedPropietario) {
		this.selectedPropietario = selectedPropietario;
	}

	public List<PersEmpr> getPropietarios() {
		if (propietarios == null || propietarios.size() == 0) {

			
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

	public List<String> getSelectedModelo() {
		return selectedModelo;
	}

	public void setSelectedModelo(List<String> selectedModelo) {
		this.selectedModelo = selectedModelo;
	}

	public List<ModeloEquipo> getModelos() {
		if (modelos == null || modelos.size() == 0) {

			
			try {
				modelos = businessDelegatorView.getModeloEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return modelos;
	}

	public void setModelos(List<ModeloEquipo> modelos) {
		this.modelos = modelos;
	}

	public List<String> getSelectedEquipo() {
		return selectedEquipo;
	}

	public void setSelectedEquipo(List<String> selectedEquipo) {
		this.selectedEquipo = selectedEquipo;
	}

	public List<Equipo> getEquipos() {
		if (equipos == null || equipos.size() == 0) {

			

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

			try {

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

			
			try {

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
	
	
	public List<String> getSelectedNivel2Clientesmq() {
		return selectedNivel2Clientesmq;
	}

	public void setSelectedNivel2Clientesmq(List<String> selectedNivel2Clientesmq) {
		this.selectedNivel2Clientesmq = selectedNivel2Clientesmq;
	}

	public List<Nivel2Clientesmq> getNivel2Clientesmq() {

		if (nivel2Clientesmq == null || nivel2Clientesmq.size() == 0) {

			try {
				nivel2Clientesmq = businessDelegator2View.getNivel2Clientesmq();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return nivel2Clientesmq;
	}

	public void setNivel2Clientesmq(List<Nivel2Clientesmq> nivel2Clientesmq) {
		this.nivel2Clientesmq = nivel2Clientesmq;
	}


	
	public List<String> getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(List<String> selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public List<PersEmpr> getClientes() {

		if (clientes == null || clientes.size() == 0) {

			
			try {
				Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "4", "="};
				clientes = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return clientes;
	}

	public void setClientes(List<PersEmpr> clientes) {
		this.clientes = clientes;
	}


	
	public List<String> getSelectedOperador() {
		return selectedOperador;
	}

	public void setSelectedOperador(List<String> selectedOperador) {
		this.selectedOperador = selectedOperador;
	}

	public List<Trabajador> getOperadores() {

		if (operadores == null || operadores.size() == 0) {

			try {
				operadores = businessDelegatorView.getTrabajador();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return operadores;
	}

	public void setOperadores(List<Trabajador> operadores) {
		this.operadores = operadores;
	}
	


	public List<String> getSelectedCategoriaEquipo() {
		return selectedCategoriaEquipo;
	}

	public void setSelectedCategoriaEquipo(List<String> selectedCategoriaEquipo) {
		this.selectedCategoriaEquipo = selectedCategoriaEquipo;
	}

	public List<CategoriaEquipo> getCategoriaEquipos() {

		if (categoriaEquipos == null || categoriaEquipos.size() == 0) {

		
			try {
				categoriaEquipos = businessDelegatorView.getCategoriaEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}

		return categoriaEquipos;
	}

	public void setCategoriaEquipos(List<CategoriaEquipo> categoriaEquipos) {
		this.categoriaEquipos = categoriaEquipos;
	}
	
	public SelectOneMenu getTxtEstadoServicio() {
		return txtEstadoServicio;
	}

	public void setTxtEstadoServicio(SelectOneMenu txtEstadoServicio) {
		this.txtEstadoServicio = txtEstadoServicio;
	}

	public InputText txtIngresoTotal() {
		return txtVlTotal;
	}

	public void setTxtVlTotal(InputText txtVlTotal) {
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

	
	
	

	public String getDisableButton1() {
		return disableButton1;
	}

	public void setDisableButton1(String disableButton1) {
		this.disableButton1 = disableButton1;
	}

	public String getDisableNivel1() {
		return disableNivel1;
	}

	public void setDisableNivel1(String disableNivel1) {
		this.disableNivel1 = disableNivel1;
	}

	public String getDisableNivel2() {
		return disableNivel2;
	}

	public void setDisableNivel2(String disableNivel2) {
		this.disableNivel2 = disableNivel2;
	}

	public String getDisableButtonA() {
		return disableButtonA;
	}

	public void setDisableButtonA(String disableButtonA) {
		this.disableButtonA = disableButtonA;
	}	   
	

	

	public String getCadenaPrefactura() {
		return cadenaPrefactura;
	}

	public void setCadenaPrefactura(String cadenaPrefactura) {
		this.cadenaPrefactura = cadenaPrefactura;
	}

	public String getDisableDesPreFactura() {
		return disableDesPreFactura;
	}

	public void setDisableDesPreFactura(String disableDesPreFactura) {
		this.disableDesPreFactura = disableDesPreFactura;
	}

	public StreamedContent getFilePreFactura() {
		return filePreFactura;
	}

	public void setFilePreFactura(StreamedContent filePreFactura) {
		this.filePreFactura = filePreFactura;
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



	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			 

			try {

				
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" ,"tipoEmpresa", true, "4", "="};
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

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}



	public SelectOneMenu getTxtTipoCosto() {
	return txtTipoCosto;
}

public void setTxtTipoCosto(SelectOneMenu txtTipoCosto) {
	this.txtTipoCosto = txtTipoCosto;
}

	public void costosDistribuirMaquina() {
		try {
			

			// Long compania = 1L;
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			
			String tipoCosto="0";
		
			if( txtTipoCosto.getValue()!=null) {
				tipoCosto =FacesUtils.checkString(txtTipoCosto);
			}
		
		    double horas = 0;
		    double cantidad = 0;

		    double ingresoTotal = 0;
			double costoTotal = 0;
			double combustible = 0;
			
				
			if(compania != null && fechaInicial != null && fechaFinal != null){
		
				dataDistr = businessDelegator2View.pr_distribuccion_ingresos_equipos(compania,  fechaInicial, fechaFinal, tipoCosto);
			
		       if(dataDistr !=null && dataDistr.size()>=0) {
		        for( DistribuccionCostosMaquinaDTO data1 : dataDistr) {
		        		costoTotal += data1.getCostoTotal().doubleValue();
		             }
		       }
		 
			}
			txtCostoTotal.setValue(costoTotal);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void action_valoresSeleccionados() {
		try {

			// Long compania = 1L;
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));

			double horas = 0;
			double cantidad = 0;

			double ingresoTotal = 0;
			double costoTotal = 0;
			double combustible = 0;
			Long flagEquipo = 1L;

			
			String cadena = "";
			String cadenaImportacion ="";
			Long flagId=0l;
			 
			 
			if (compania != null && fechaInicial != null && fechaFinal != null) {
				GregorianCalendar calendarioInicial = new GregorianCalendar();
				calendarioInicial.setTime(FacesUtils.checkDate(txtFechaInicial));
				long anioRegistroInicial = calendarioInicial.get(java.util.Calendar.YEAR);
				long mesInicial = calendarioInicial.get(java.util.Calendar.MONTH) + 1;
				String anioMesInicial = anioRegistroInicial + "-" + mesInicial;

				GregorianCalendar calendarioFinal = new GregorianCalendar();
				calendarioFinal.setTime(FacesUtils.checkDate(txtFechaFinal));
				long anioRegistroFinal = calendarioFinal.get(java.util.Calendar.YEAR);
				long mesFinal = calendarioFinal.get(java.util.Calendar.MONTH) + 1;
				String anioMesFinal = anioRegistroFinal + "-" + mesFinal;

				if (anioMesInicial.equals(anioMesFinal)) {
			
					String equiposSeleccionadas = "";
					if (selectEquiposDistribucciones != null && selectEquiposDistribucciones.size() > 0) {
						equiposSeleccionadas = selectEquiposDistribucciones.get(0);
						flagEquipo = 0L; 
						for (int i = 1; i < selectEquiposDistribucciones.size(); i++) {
							equiposSeleccionadas += "," + selectEquiposDistribucciones.get(i);
						}
					}
					  
					   DistribuccionCostosMaquinaDTO idsSeleccionadas = null;
					if (selectedDistr2 != null && selectedDistr2.size() > 0) {
						idsSeleccionadas = selectedDistr2.get(0);
						flagId = 0L;
						for (int i = 0; i < selectedDistr2.size(); i++) {
							idsSeleccionadas =  selectedDistr2.get(i);
							//cadena += ","+ idsSeleccionadas.getAnioMes().toString();
							businessDelegator2View.pr_borrar_distribuccion_costos_ind_maquina(compania, fechaInicial,fechaFinal, idsSeleccionadas.getOrigenDatos2());
							businessDelegator2View.pr_insert_distribuccion_ingresos_equipos(compania, fechaInicial, fechaFinal,  equiposSeleccionadas ,  flagEquipo,idsSeleccionadas.getOrigenDatos2() );
							
						}
					}
					//cadena = "," +cadena;
					cadenaImportacion = "0"+cadena;	
			
				
					
					
				
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"La distribucción de costos fue ejecutada satisfactoriamente!! ",
							""));
					selectEquiposDistribucciones=null;
					costosDistribuirMaquina();
					
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"El intervalo de fechas seleccionadas no puede superar el rango de un mes, vuelva a intentarlo!! ",
							""));
					selectEquiposDistribucciones=null;
				}
				
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La interfaz esta fallando, válidar con el área de soporte de AgroView ", ""));

			e.printStackTrace();
		}


	}
	
	


	public List<DistribuccionCostosMaquinaDTO> getDataDistr() {
		return dataDistr;
	}

	public void setDataDistr(List<DistribuccionCostosMaquinaDTO> dataDistr) {
		this.dataDistr = dataDistr;
	}

	public InputText getTxtVlTotal() {
		return txtVlTotal;
	}

	public InputText getTxtPin() {
		return txtPin;
	}

	public void setTxtPin(InputText txtPin) {
		this.txtPin = txtPin;
	}



	public InputNumber getTxtCantidadPago() {
		return txtCantidadPago;
	}

	public void setTxtCantidadPago(InputNumber txtCantidadPago) {
		this.txtCantidadPago = txtCantidadPago;
	}

	public InputNumber getTxtHorasTotales() {
		return txtHorasTotales;
	}

	public void setTxtHorasTotales(InputNumber txtHorasTotales) {
		this.txtHorasTotales = txtHorasTotales;
	}

	public InputNumber getTxtIngresoTotal() {
		return txtIngresoTotal;
	}

	public void setTxtIngresoTotal(InputNumber txtIngresoTotal) {
		this.txtIngresoTotal = txtIngresoTotal;
	}

	public InputNumber getTxtCostoTotal() {
		return txtCostoTotal;
	}

	public void setTxtCostoTotal(InputNumber txtCostoTotal) {
		this.txtCostoTotal = txtCostoTotal;
	}

	public InputNumber getTxtCombustible() {
		return txtCombustible;
	}

	public void setTxtCombustible(InputNumber txtCombustible) {
		this.txtCombustible = txtCombustible;
	}

	public InputNumber getTxtGlnHr() {
		return txtGlnHr;
	}

	public void setTxtGlnHr(InputNumber txtGlnHr) {
		this.txtGlnHr = txtGlnHr;
	}

	public InputNumber getTxtAreaHr() {
		return txtAreaHr;
	}

	public void setTxtAreaHr(InputNumber txtAreaHr) {
		this.txtAreaHr = txtAreaHr;
	}

	public InputNumber getTxtGlnArea() {
		return txtGlnArea;
	}

	public void setTxtGlnArea(InputNumber txtGlnArea) {
		this.txtGlnArea = txtGlnArea;
	}

	public InputNumber getTxtCostoHr() {
		return txtCostoHr;
	}

	public void setTxtCostoHr(InputNumber txtCostoHr) {
		this.txtCostoHr = txtCostoHr;
	}

	public InputNumber getTxtCostoArea() {
		return txtCostoArea;
	}

	public void setTxtCostoArea(InputNumber txtCostoArea) {
		this.txtCostoArea = txtCostoArea;
	}

	public InputNumber getTxtIngresosHr() {
		return txtIngresosHr;
	}

	public void setTxtIngresosHr(InputNumber txtIngresosHr) {
		this.txtIngresosHr = txtIngresosHr;
	}

	public InputNumber getTxtIngresosArea() {
		return txtIngresosArea;
	}

	public void setTxtIngresosArea(InputNumber txtIngresosArea) {
		this.txtIngresosArea = txtIngresosArea;
	}

	public InputNumber getTxtUtilidad() {
		return txtUtilidad;
	}

	public void setTxtUtilidad(InputNumber txtUtilidad) {
		this.txtUtilidad = txtUtilidad;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
	public SelectItem[] getSelectEquiposDistribuccion() {

			try {
				Long idCompania = new Long(getCompaniaIdSession());
				List<DistribuccionCostosMaquinaDTO> listaEquipos = null;
				Date fechaInicial = FacesUtils.checkDate(txtFechaInicial);
				Date fechaFinal = FacesUtils.checkDate(txtFechaFinal);
				
				if(idCompania!=null && fechaInicial !=null && fechaFinal !=null) {
					
					listaEquipos = businessDelegator2View.pr_lista_equipos_distribuccion(idCompania, fechaInicial, fechaFinal, "0", 1l);
				
				if (listaEquipos != null) {
					selectEquiposDistribuccion = new SelectItem[listaEquipos.size()];

					int i = 0;
					for (DistribuccionCostosMaquinaDTO consulta : listaEquipos) {
						selectEquiposDistribuccion[i] = new SelectItem(consulta.getEquipoId().longValue(),
								consulta.getCodEquipo());
						i++;

					}
				}
				
				}
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			
		}

		return selectEquiposDistribuccion;
	}

	public void setSelectEquiposDistribuccion(SelectItem[] selectEquiposDistribuccion) {
		this.selectEquiposDistribuccion = selectEquiposDistribuccion;
	}

	public DistribuccionCostosMaquinaDTO getSelectedDistr() {
		return selectedDistr;
	}

	public void setSelectedDistr(DistribuccionCostosMaquinaDTO selectedDistr) {
		this.selectedDistr = selectedDistr;
	}



	public List<DistribuccionCostosMaquinaDTO> getSelectedDistr2() {
		return selectedDistr2;
	}

	public void setSelectedDistr2(List<DistribuccionCostosMaquinaDTO> selectedDistr2) {
		this.selectedDistr2 = selectedDistr2;
	}

	public List<String> getSelectEquiposDistribucciones() {
		selectEquiposDistribucciones=null;
		return selectEquiposDistribucciones;
	}

	public void setSelectEquiposDistribucciones(List<String> selectEquiposDistribucciones) {
		this.selectEquiposDistribucciones = selectEquiposDistribucciones;
	}



	public void setEquipoDistr(List<DistribuccionCostosMaquinaDTO> equipoDistr) {
		this.equipoDistr = equipoDistr;
	}

	public SelectItem[] getSelectContratista() {
		return selectContratista;
	}

	public void setSelectContratista(SelectItem[] selectContratista) {
		this.selectContratista = selectContratista;
	}
	
	public List<DistribuccionCostosMaquinaDTO> getEquipoDistr() {
		try {
			Long idCompania = new Long(getCompaniaIdSession());
			equipoDistr = null;
			Date fechaInicial = FacesUtils.checkDate(txtFechaInicial);
			Date fechaFinal = FacesUtils.checkDate(txtFechaFinal);
			
			if(idCompania!=null && fechaInicial !=null && fechaFinal !=null) {
				equipoDistr = businessDelegator2View.pr_lista_equipos_distribuccion(idCompania, fechaInicial, fechaFinal, "0", 1l);
			}
		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		
			}
		return equipoDistr;
		
	}

	public List<DistribuccionCostosMaquinaDTO> getDataDetalleCostos() {
		return dataDetalleCostos;
	}

	public void setDataDetalleCostos(List<DistribuccionCostosMaquinaDTO> dataDetalleCostos) {
		this.dataDetalleCostos = dataDetalleCostos;
	}
	
	
	


	public String action_detalle_gastos(ActionEvent evt) {
		selectedDistr = (DistribuccionCostosMaquinaDTO) (evt.getComponent().getAttributes()
				.get("selectedDistr"));
		try {
			Long idCompania = new Long(getCompaniaIdSession());
			String anioMes = selectedDistr.getAnioMes();
			String idOrigen = selectedDistr.getOrigenDatos2();
			
			dataDetalleCostos =null;
			dataDetalleCostos = businessDelegator2View.pr_distribuccion_ingresos_equipos_detalle(idCompania, anioMes, idOrigen);
			Double costoTotalDetalle = 0.0;
			if (dataDetalleCostos != null && dataDetalleCostos.size() > 0) {
				for(DistribuccionCostosMaquinaDTO dataCostos : dataDetalleCostos) {
					costoTotalDetalle	+= dataCostos.getCostoTotal().doubleValue();
				}
			}
			txtCostoTotalDetalle.setValue(costoTotalDetalle);
			setShowDialog(true);
			
			
		} catch (Exception e) {
			
		}

		return "";
	}

	public InputNumber getTxtCostoTotalDetalle() {
		return txtCostoTotalDetalle;
	}

	public void setTxtCostoTotalDetalle(InputNumber txtCostoTotalDetalle) {
		this.txtCostoTotalDetalle = txtCostoTotalDetalle;
	}

	

}
