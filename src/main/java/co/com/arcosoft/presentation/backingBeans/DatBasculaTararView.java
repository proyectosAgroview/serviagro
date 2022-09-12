package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
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
import co.com.arcosoft.modelo.Bascula;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.DatTransProdTrabajadoresDTO;
import co.com.arcosoft.modelo.informes.dto.BasculaVehiculosTararDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DatBasculaTararView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatBasculaTararView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private BarChartModel barModel1;
	private boolean showDialog;
	private MapModel simpleModel;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<BasculaVehiculosTararDTO> data;
	private BasculaVehiculosTararDTO selectedPesaje;
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

	private List<String> selectedTenencia;
	private List<Tenencia> tenencias;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private List<String> selectedModCosecha;
	private List<ModalidadCosecha> modCosechas;

	private List<String> selectedEtapaCos;
	private List<Etapa> noCosechas;

	private List<String> selectedProducto;
	private List<Producto> productos;

	private List<String> selectedVagon;
	private List<Equipo> vagones;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private DatTransProdDTO selectedDatTransProd;
	private DatTransProd entity;

	private SelectOneMenu txtVehiTranspId2;
	SelectItem[] selectVehiculosTransp;
	private List<Equipo> vehiculosTransp;

	private InputText txtPesoTara;
	private InputText txtTiquete1;
	private Calendar txtFechaTara;
	private SelectOneMenu txtTipoTransaccionTara;

	private SelectOneMenu txtBasculaTara;
	SelectItem[] selectBascula;
	private List<Bascula> bascula;

	private CommandButton btnSave;
	private Double pesoBrutoDef;
	private Double pesoTaraDef;

	private List<DatTransProdTrabajadoresDTO> dataPlanillaDet;
	private DatTransProdTrabajadoresDTO selectedDatPlanillaDet;

	/** Campos de pantalla de detalle de productos **/
	private List<DatTransProdDetDTO> dataDetTransProductos;
	private DatTransProdDetDTO selectedDatTransProdDet;
	private List<DatTransProdNivel4DTO> dataDetTransNivel4;
	private DatTransProdNivel4DTO selectedDatTransNivel4;

	// BASCULA PUERTO SERIAL
	private static String formatoCadena;
	private static String subCadena;
	private static SerialPort serialPort;
	private boolean portOpened = false;
	private int inicio;
	private int fin;

	
	public static String getFormatoCadena() {
		return formatoCadena;
	}

	public static void setFormatoCadena(String formatoCadena) {
		DatBasculaTararView.formatoCadena = formatoCadena;
	}

	public static String getSubCadena() {
		return subCadena;
	}

	public static void setSubCadena(String subCadena) {
		DatBasculaTararView.subCadena = subCadena;
	}

	public static SerialPort getSerialPort() {
		return serialPort;
	}

	public static void setSerialPort(SerialPort serialPort) {
		DatBasculaTararView.serialPort = serialPort;
	}

	public boolean isPortOpened() {
		return portOpened;
	}

	public void setPortOpened(boolean portOpened) {
		this.portOpened = portOpened;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public DatBasculaTararView() {
		super();
	}

	public String action_informe1() {
		setShowDialog(true);
		return "";
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

	public List<BasculaVehiculosTararDTO> getData() {
		try {
			// Long compania = 1L;

			Long compania = new Long(getCompaniaIdSession());

			if (compania != null) {

				data = businessDelegatorView.consultarBasculaTarar(compania);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public String action_Pesar(ActionEvent evt) {
		selectedPesaje = (BasculaVehiculosTararDTO) (evt.getComponent().getAttributes().get("selectedPesaje"));

		try {

			Long consecutivo = selectedPesaje.getConsecutivo().longValue();
			Object[] condicion = { "consecutivo", true, consecutivo, "=" };
			List<DatTransProd> lista = (consecutivo != null)
					? businessDelegatorView.findByCriteriaInDatTransProd(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtTiquete1.setValue(entity.getConsecutivo());
				txtTiquete1.setDisabled(true);
				txtVehiTranspId2.setValue(entity.getVehiculoId());
				txtVehiTranspId2.setDisabled(true);

				Date date = new Date();
				txtFechaTara.setValue(date);
				txtFechaTara.setDisabled(true);

				txtTipoTransaccionTara.setValue(entity.getTipoTransaccion());
				txtTipoTransaccionTara.setDisabled(true);

				txtBasculaTara.setValue(null);
				txtTipoTransaccionTara.setDisabled(true);

				txtPesoTara.setValue(0);
				txtPesoTara.setDisabled(false);

				if (entity.getPesoBruto() != null) {
					pesoBrutoDef = (entity.getPesoBruto());

				}

				if (entity.getPesoTara() != null) {
					pesoTaraDef = (entity.getPesoTara());

				}

				/******* sesion concerniente al detalle por producto ***/
				btnSave.setDisabled(false);
				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
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

	public List<String> getSelectedNivel1() {
		return selectedNivel1;
	}

	public void setSelectedNivel1(List<String> selectedNivel1) {
		this.selectedNivel1 = selectedNivel1;
	}

	public List<Nivel1> getZonas() {
		if (zonas == null || zonas.size() == 0) {

			zonas = new ArrayList<Nivel1>();

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

			fincas = new ArrayList<Nivel2>();

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

			bloques = new ArrayList<Nivel3>();

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

			lotes = new ArrayList<Nivel4>();

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

	public List<String> getSelectedVagon() {
		return selectedVagon;
	}

	public void setSelectedVagon(List<String> selectedVagon) {
		this.selectedVagon = selectedVagon;
	}

	public List<Equipo> getVagones() {
		if (vagones == null || vagones.size() == 0) {

			vagones = new ArrayList<Equipo>();

			try {
				vagones = businessDelegatorView.getEquipo();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return vagones;
	}

	public void setVagones(List<Equipo> vagones) {
		this.vagones = vagones;
	}

	public List<String> getSelectedTenencia() {
		return selectedTenencia;
	}

	public void setSelectedTenencia(List<String> selectedTenencia) {
		this.selectedTenencia = selectedTenencia;
	}

	public List<Tenencia> getTenencias() {
		if (tenencias == null || tenencias.size() == 0) {

			tenencias = new ArrayList<Tenencia>();

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

			unidadesMedida = new ArrayList<UdadMed>();

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

	public List<ModalidadCosecha> getModCosechas() {
		if (modCosechas == null || modCosechas.size() == 0) {

			modCosechas = new ArrayList<ModalidadCosecha>();

			try {
				modCosechas = businessDelegatorView.getModalidadCosecha();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return modCosechas;
	}

	public void setModCosechas(List<ModalidadCosecha> modCosechas) {
		this.modCosechas = modCosechas;
	}

	public List<String> getSelectedEtapaCos() {
		return selectedEtapaCos;
	}

	public void setSelectedEtapaCos(List<String> selectedEtapaCos) {
		this.selectedEtapaCos = selectedEtapaCos;
	}

	public List<Etapa> getNoCosechas() {
		if (noCosechas == null || noCosechas.size() == 0) {

			noCosechas = new ArrayList<Etapa>();

			try {
				noCosechas = businessDelegatorView.getEtapa();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return noCosechas;
	}

	public void setNoCosechas(List<Etapa> noCosechas) {
		this.noCosechas = noCosechas;
	}

	public List<String> getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(List<String> selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public List<Producto> getProductos() {
		if (productos == null || productos.size() == 0) {

			productos = new ArrayList<Producto>();

			try {
				productos = businessDelegatorView.getProducto();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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

	public DatTransProdDTO getSelectedDatTransProd() {
		return selectedDatTransProd;
	}

	public void setSelectedDatTransProd(DatTransProdDTO selectedDatTransProd) {
		this.selectedDatTransProd = selectedDatTransProd;
	}

	private class LocalDataModelDTO extends LazyDataModel<BasculaVehiculosTararDTO> {
		private static final long serialVersionUID = 1L;
		private List<BasculaVehiculosTararDTO> BasculaVehiculosTararDTO;

		public LocalDataModelDTO() {
		}
	}

	public SelectOneMenu getTxtVehiTranspId() {
		return txtVehiTranspId2;
	}

	public void setTxtVehiTranspId(SelectOneMenu txtVehiTranspId2) {
		this.txtVehiTranspId2 = txtVehiTranspId2;
	}

	public InputText getTxtPesoTara() {
		return txtPesoTara;
	}

	public void setTxtPesoTara(InputText txtPesoTara) {
		this.txtPesoTara = txtPesoTara;
	}

	public InputText getTxtTiquete() {
		return txtTiquete1;
	}

	public void setTxtTiquete(InputText txtTiquete1) {
		this.txtTiquete1 = txtTiquete1;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public SelectOneMenu getTxtBasculaTara() {
		return txtBasculaTara;
	}

	public void setTxtBasculaTara(SelectOneMenu txtBasculaTara) {
		this.txtBasculaTara = txtBasculaTara;
	}

	public List<DatTransProdDetDTO> getDataDetTransProductos() {
		return dataDetTransProductos;
	}

	public void setDataDetTransProductos(List<DatTransProdDetDTO> dataDetTransProductos) {
		this.dataDetTransProductos = dataDetTransProductos;
	}

	public List<DatTransProdNivel4DTO> getDataDetTransNivel4() {
		return dataDetTransNivel4;
	}

	public void setDataDetTransNivel4(List<DatTransProdNivel4DTO> dataDetTransNivel4) {
		this.dataDetTransNivel4 = dataDetTransNivel4;
	}

	public Calendar getTxtFechaPesaje() {
		return txtFechaTara;
	}

	public void setTxtFechaPesaje(Calendar txtFechaTara) {
		this.txtFechaTara = txtFechaTara;
	}

	public SelectOneMenu getTxtTipoTransaccionPesaje() {
		return txtTipoTransaccionTara;
	}

	public void setTxtTipoTransaccionPesaje(SelectOneMenu txtTipoTransaccionTara) {
		this.txtTipoTransaccionTara = txtTipoTransaccionTara;
	}

	public Double getPesoBrutoDef() {
		return pesoBrutoDef;
	}

	public void setPesoBrutoDef(Double pesoBrutoDef) {
		this.pesoBrutoDef = pesoBrutoDef;
	}

	public Double getPesoTaraDef() {
		return pesoTaraDef;
	}

	public void setPesoTaraDef(Double pesoTaraDef) {
		this.pesoTaraDef = pesoTaraDef;
	}

	public SelectItem[] getselectVehiculosTransp() {

		if (vehiculosTransp == null || vehiculosTransp.size() == 0) {

			vehiculosTransp = new ArrayList<Equipo>();

			try {

				vehiculosTransp = businessDelegatorView.getEquipo(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectVehiculosTransp = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo vehiculosTransp : lista) {
					selectVehiculosTransp[i] = new SelectItem(vehiculosTransp.getEquipoId(),
							vehiculosTransp.getNombre() + "-" + vehiculosTransp.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectVehiculosTransp;
	}

	public void setselectVehiculosTransp(SelectItem[] selectVehiculosTransp) {
		this.selectVehiculosTransp = selectVehiculosTransp;
	}

	public SelectItem[] getselectBascula() {

		if (bascula == null || bascula.size() == 0) {

			bascula = new ArrayList<Bascula>();

			try {

				bascula = businessDelegatorView.getBascula(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Bascula> lista = businessDelegatorView.findByCriteriaInBascula(condicion, null, null);
				selectBascula = new SelectItem[lista.size()];

				int i = 0;
				for (Bascula bascula : lista) {
					selectBascula[i] = new SelectItem(bascula.getBasculaId(),
							bascula.getNombre() + "-" + bascula.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectBascula;
	}

	public void setselectBascula(SelectItem[] selectBascula) {
		this.selectBascula = selectBascula;
	}

	public void listener_calcularPesoTara() throws SerialPortException {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		String format = "";
		Double result = 0.0;

		format = decimalFormat.format(result);
		txtPesoTara.setValue(result);
		
		if (portOpened) {
			format = decimalFormat.format(Double.parseDouble(leerDatoPuerto()));
			result = Double.parseDouble(format);
			txtPesoTara.setValue(result);
			closeConnection(); 
		}else {
			txtPesoTara.setValue(result);
		}

	}
	
	public String leerDatoPuerto() {

		String dato = "";
		String receivedData=null;

		try {

			receivedData = serialPort.readString(formatoCadena.length()); 

			if (receivedData == null) {
				System.out.println("Respuesta báscula : Los sentimos no hay datos recibidos... ");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!", " No se pudo recibir datos de la Báscula... "));
			} else {

				dato = receivedData.substring(inicio, fin);
     			System.out.println("Respuesta báscula : " + dato);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Leyendo puerto serial.. ", " El peso recibido es: "+dato));
			}

		} catch (SerialPortException e) {
			closeConnection();
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!", " Respuesta: "+e));
			System.out.println("Respuesta de error báscula : "+e);
		}
		
		return dato;
	}
	
	public void closeConnection() {
		if (portOpened) {
			if (serialPort != null) {
				try {
					//serialPort.removeEventListener();
					serialPort.closePort();
				} catch (SerialPortException e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos!", " Se presento un problema cerrando conexión con la Báscula: "+e));
				}
			}
			portOpened = false;
		}
	}
	
	public void inicializarPuertoSerialBascula(String nombrePuerto, int baudios, int paridad, int dataBits,
			int bitsDeParada, String formato_cadena, String sub_cadena, int inicio1, int fin1) {

		formatoCadena = formato_cadena;
		subCadena = sub_cadena;
		inicio = inicio1;
		fin = fin1;
		
		serialPort = new SerialPort(nombrePuerto);

		try {

			serialPort.openPort();
			serialPort.setParams(baudios, dataBits, bitsDeParada, paridad);
			portOpened = true;

			// writing string to port
			//serialPort.writeString(formato_cadena);
			
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Genial!", " Conexión es exitosa con el puerto serial.. "));
			System.out.println("Puerto inicializado..");

		} catch (SerialPortException e) {
			e.printStackTrace();
		} // Open serial port

	}

	public void listener_basculaActiva() throws Exception {

		Long basculaId = null;

		if (!txtBasculaTara.getValue().equals("")) {
			basculaId = Long.parseLong(txtBasculaTara.getValue().toString());
			try {
				Bascula bascula = businessDelegatorView.getBascula(basculaId);
				String lectura = bascula.getTipoLectura();
				if (lectura.equals("Automatica")) {
					txtPesoTara.setDisabled(true);
					String nombrePuerto = null;
					int baudios = 0;
					int paridad = 0;
					int dataBits = 0;
					int bitsDeParada = 0;
					int inicio = 0;
					int fin = 0;
					String formato_cadena = null;
					String sub_cadena = null;
					
					nombrePuerto = bascula.getPuertoCom();
					baudios = bascula.getVelocidad().intValue();
					paridad = bascula.getBitParada().intValue();
					dataBits = Integer.parseInt(bascula.getBitDatos());
					formato_cadena = bascula.getFormatoCadena();
					sub_cadena = bascula.getSubcadena();
					inicio = bascula.getIniciolectura().intValue();
					fin = bascula.getFinlectura().intValue();
					

					inicializarPuertoSerialBascula(nombrePuerto, baudios, paridad, dataBits, bitsDeParada,
							formato_cadena, sub_cadena,inicio,fin);
					
					
				} else {
					txtPesoTara.setDisabled(false);
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public String action_savePesoTara() {
		try {
			Long id = null;
			if (entity == null) {
				id = new Long(selectedDatTransProd.getDatTransProdId());
				entity = businessDelegatorView.getDatTransProd(id);
			}

			dataDetTransProductos = null;
			dataDetTransProductos = businessDelegatorView.getDataDetTransProductosByDatTransProdId(id);

			dataDetTransNivel4 = null;
			dataDetTransNivel4 = businessDelegatorView.getDataDatTransProdNivel4ByNivel4Id(id);

			dataPlanillaDet = null;
			dataPlanillaDet = businessDelegatorView.getDataDatTransProdTrabajadoresByTrabajador(id);

			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();

			String tipoTransaccion = "";

			if (!txtTipoTransaccionTara.getValue().equals("")) {
				tipoTransaccion = (txtTipoTransaccionTara.getValue().toString());
				if (tipoTransaccion.equals("Produccion")) {
					entity.setFechaSalida(date);
				}
				if (tipoTransaccion.equals("Despachos")) {
					entity.setFechaEntrada(date);
				}
			}

			if (pesoBrutoDef != null) {
				Double pesoTara = FacesUtils.checkDouble(txtPesoTara);
				Double pesoNeto = pesoBrutoDef - pesoTara;
				entity.setPesoNeto(pesoNeto);

			} else {
				entity.setPesoNeto(0.0);

			}

			entity.setPesoTara(FacesUtils.checkDouble(txtPesoTara));
			entity.setFechaTara(date);
			entity.setPesoTara(FacesUtils.checkDouble(txtPesoTara));
			entity.setBasculaTara(FacesUtils.checkLong(txtBasculaTara));
			entity.setUsuarioPesoTara(usuarioId);

			Long idBascula = FacesUtils.checkLong(txtBasculaTara);
			Bascula bascula = businessDelegatorView.getBascula(idBascula);

			entity.setTipoPesajeBruto(bascula.getTipoLectura().toString());

			businessDelegatorView.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4,
					dataPlanillaDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVEDPESOTARA);

			txtBasculaTara.setValue(null);
			txtPesoTara.setValue(0);
			txtVehiTranspId2.setValue(null);
			txtTiquete1.setValue(null);
			txtTipoTransaccionTara.setValue(null);
			txtFechaTara.setValue(null);
			
			closeConnection();

		} catch (Exception e) {
			// data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public SelectOneMenu getTxtVehiTranspId2() {
		return txtVehiTranspId2;
	}

	public void setTxtVehiTranspId2(SelectOneMenu txtVehiTranspId2) {
		this.txtVehiTranspId2 = txtVehiTranspId2;
	}

	public InputText getTxtTiquete1() {
		return txtTiquete1;
	}

	public void setTxtTiquete1(InputText txtTiquete1) {
		this.txtTiquete1 = txtTiquete1;
	}

	public Calendar getTxtFechaTara() {
		return txtFechaTara;
	}

	public void setTxtFechaTara(Calendar txtFechaTara) {
		this.txtFechaTara = txtFechaTara;
	}

	public SelectOneMenu getTxtTipoTransaccionTara() {
		return txtTipoTransaccionTara;
	}

	public void setTxtTipoTransaccionTara(SelectOneMenu txtTipoTransaccionTara) {
		this.txtTipoTransaccionTara = txtTipoTransaccionTara;
	}

	/**
	 * @return the dataPlanillaDet
	 */
	public List<DatTransProdTrabajadoresDTO> getDataPlanillaDet() {
		return dataPlanillaDet;
	}

	/**
	 * @param dataPlanillaDet the dataPlanillaDet to set
	 */
	public void setDataPlanillaDet(List<DatTransProdTrabajadoresDTO> dataPlanillaDet) {
		this.dataPlanillaDet = dataPlanillaDet;
	}

}
