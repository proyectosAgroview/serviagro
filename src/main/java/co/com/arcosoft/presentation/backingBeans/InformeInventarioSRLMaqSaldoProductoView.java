package co.com.arcosoft.presentation.backingBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
//import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
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
public class InformeInventarioSRLMaqSaldoProductoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InformeInventarioSRLMaqSaldoProductoView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private BarChartModel barModel1;
	private boolean showDialog;

	// private List<ProntuarioLotesDTO> data;
	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private List<ConsultaStockMaquinariaDTO> data;
	private List<ConsultaStockMaquinariaDTO> dataSaldoProducto;
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

	private List<String> selectedLabor;
	private List<Labor> labores;

	private List<String> selectedGrupoLabor;
	private List<GrpLabor> grupoLabores;

	private List<String> selectedEtapaId;
	private List<Etapa> etapas;

	private List<String> selectedUdadMed;
	private List<UdadMed> unidadesMedida;

	private SelectOneMenu txtCompania;
	SelectItem[] selectCompania;
	private List<Compania> compania;

	private StreamedContent file = null;
	private String disableButton = "true";

	private List<String> selectedProducto;
	private List<Producto> productos;

	private String visible = "hidden";
	private InputText txtDocumento;
	
	private List<String> selectedContratista;
	private List<PersEmpr> contratistas;


	private List<String> selectedTipoProducto;
	private List<TipoProducto> tipoProductos;

	private List<String> selectedAlmacen;
	private List<Almacen> almacenes;

	
	private List<String> selectedConceptoKardex;
	private List<ConceptoKardex> conceptoKardexs;
	private InputText txtDocumentoKardex;
	
	private SelectOneMenu txtConceptoKardex;
	SelectItem[] selectConceptoKardex;
	private List<ConceptoKardex> conceptoKardex;

	private SelectOneMenu txtAlmacenId_Almacen;
	SelectItem[] selectAlmacen;
	private List<Almacen> almacen;
	
	private SelectOneMenu txtTipoProducto;
	SelectItem[] selectTipoProducto;
	private List<TipoProducto> tipoProducto;

	private SelectOneMenu txtProductoId_Producto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;
	
	private InputNumber txtValorTotalAcumulado;
	private InputNumber txtSaldoTotal;
	private List<ConsultaCompraProductosDTO> dataProductoPeriodo;
	
	private List<ConsultaStockMaquinariaDTO> dataProductoUbicacion;
	ConsultaStockMaquinariaDTO	selectedProductoUbicacion;
	private ConsultaStockMaquinariaDTO selectedDatCompraProductos2;
	
	
	public InformeInventarioSRLMaqSaldoProductoView() {
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

	public void consultaSaldoProducto() {
		try {
			 
			 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Long compania = new Long(getCompaniaIdSession());
			//String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen); 
			String productoId = FacesUtils.checkString(txtProductoId_Producto); 
			Long flagProducto =1L;
			Long flagAlmacen = 1L;
	    
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro =null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);

			 fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();
			
			double valorTotal = 0;
			double saldoTotal = 0;
			
			 
		 
			if(productoId!=null) {
				dataSaldoProducto = businessDelegator2View.pr_inventario_saldo_producto( compania,  fechaFinalDateRegistro,  date,
						"0" ,  1l, productoId, 0L);
				for( ConsultaStockMaquinariaDTO data1 : dataSaldoProducto) {
					  saldoTotal += data1.getCantidadDisponible().doubleValue();
					 valorTotal += (data1.getCosto_total().doubleValue()) ;
			        }
				 txtSaldoTotal.setValue(saldoTotal);
				 txtValorTotalAcumulado.setValue(valorTotal);
			   }else {
				  
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
								"Verifique que el campo de productos tengan valores. "));
					
				
			   }
			
				

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	


	public List<ConsultaStockMaquinariaDTO> getData() {
		return data;
	}

	public void setData(List<ConsultaStockMaquinariaDTO> data) {
		this.data = data;
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

	public List<String> getSelectedEtapaId() {
		return selectedEtapaId;
	}

	public void setSelectedEtapaId(List<String> selectedEtapaId) {
		this.selectedEtapaId = selectedEtapaId;
	}

	public List<Etapa> getEtapa() {
		if (etapas == null || etapas.size() == 0) {

			etapas = new ArrayList<Etapa>();

			try {
				etapas = businessDelegatorView.getEtapa();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return etapas;
	}

	public void setEtapa(List<Etapa> etapas) {
		this.etapas = etapas;
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

	public List<String> getSelectedLabor() {
		return selectedLabor;
	}

	public void setSelectedLabor(List<String> selectedLabor) {
		this.selectedLabor = selectedLabor;
	}

	public List<Labor> getLabores() {
		if (labores == null || labores.size() == 0) {

			labores = new ArrayList<Labor>();

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

			grupoLabores = new ArrayList<GrpLabor>();

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

	public StreamedContent getFile() {

		return file;
	}

	public void setFile(StreamedContent file) {

		if (file != null) {
			this.file = file;
		}
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

	public InputText getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(InputText txtDocumento) {
		this.txtDocumento = txtDocumento;
	}
	
	public List<String> getSelectedContratista() {
		return selectedContratista;
	}

	public void setSelectedContratista(List<String> selectedContratista) {
		this.selectedContratista = selectedContratista;
	}

	public List<PersEmpr> getContratistas() throws Exception {
		if (contratistas == null || contratistas.size() == 0) {

			contratistas = new ArrayList<PersEmpr>();
			Object[] condicion = { "estado", true, "A", "=", "tipoEmpresa", true, "2", "="};
			
			try {
				contratistas = businessDelegatorView.findByCriteriaInPersEmpr(condicion, null, null);
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return contratistas;
	}


	public void setContratistas(List<PersEmpr> contratistas) {
		this.contratistas = contratistas;
	}
	


	public List<String> getSelectedAlmacen() {
		return selectedAlmacen;
	}

	public void setSelectedAlmacen(List<String> selectedAlmacen) {
		this.selectedAlmacen = selectedAlmacen;
	}

	public List<Almacen> getAlmacenes() {
		if (almacenes == null || almacenes.size() == 0) {

			almacenes = new ArrayList<Almacen>();

			try {
				almacenes = businessDelegatorView.getAlmacen();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return almacenes;
	}

	public void setAlmacenes(List<Almacen> almacenes) {
		this.almacenes = almacenes;
	}
	
	
	

	public List<String> getSelectedConceptoKardex() {
		return selectedConceptoKardex;
	}

	public void setSelectedConceptoKardex(List<String> selectedConceptoKardex) {
		this.selectedConceptoKardex = selectedConceptoKardex;
	}

	public List<ConceptoKardex> getConceptoKardexs() {
		if (conceptoKardexs == null || conceptoKardexs.size() == 0) {

			conceptoKardexs = new ArrayList<ConceptoKardex>();

			try {
				conceptoKardexs = businessDelegator2View.getConceptoKardex();
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}

		}
		return conceptoKardexs;
	}

	public void setConceptoKardexs(List<ConceptoKardex> conceptoKardexs) {
		this.conceptoKardexs = conceptoKardexs;
	}

	public InputText getTxtDocumentoKardex() {
		return txtDocumentoKardex;
	}

	public void setTxtDocumentoKardex(InputText txtDocumentoKardex) {
		this.txtDocumentoKardex = txtDocumentoKardex;
	}

	public SelectItem[] getSelectConceptoKardex() {

		if (conceptoKardex == null || conceptoKardex.size() == 0) {

			try {

					// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoKardex> lista = businessDelegator2View.findByCriteriaInConceptoKardex(condicion, null,
						null);
				selectConceptoKardex = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoKardex conceptoKardex : lista) {
					selectConceptoKardex[i] = new SelectItem(conceptoKardex.getConceptoKardexId(),
							conceptoKardex.getCodigo() + " - " + conceptoKardex.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectConceptoKardex;
	}

	public void setSelectConceptoKardex(SelectItem[] selectConceptoKardex) {
		this.selectConceptoKardex = selectConceptoKardex;
	}

	public SelectOneMenu getTxtConceptoKardex() {
		return txtConceptoKardex;
	}

	public void setTxtConceptoKardex(SelectOneMenu txtConceptoKardex) {
		this.txtConceptoKardex = txtConceptoKardex;
	}
	
	
	public SelectItem[] getSelectAlmacen() {

		if (almacen == null || almacen.size() == 0) {

			try {

				
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Almacen> lista = businessDelegatorView.findByCriteriaInAlmacen(condicion, null, null);
				selectAlmacen = new SelectItem[lista.size()];

				int i = 0;
				for (Almacen almacen : lista) {
					selectAlmacen[i] = new SelectItem(almacen.getAlmacenId(),
							almacen.getCodigo() + " - " + almacen.getCodigo()+"-"+almacen.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectAlmacen;
	}

	
	
	public void setSelectAlmacen(SelectItem[] selectAlmacen) {
		this.selectAlmacen = selectAlmacen;
	}

	public SelectOneMenu getTxtAlmacenId_Almacen() {
		return txtAlmacenId_Almacen;
	}

	public void setTxtAlmacenId_Almacen(SelectOneMenu txtAlmacenId_Almacen) {
		this.txtAlmacenId_Almacen = txtAlmacenId_Almacen;
	}
	
	
	

	public SelectOneMenu getTxtTipoProducto() {
		return txtTipoProducto;
	}

	public void setTxtTipoProducto(SelectOneMenu txtTipoProducto) {
		this.txtTipoProducto = txtTipoProducto;
	}

	public SelectOneMenu getTxtProductoId_Producto() {
		return txtProductoId_Producto;
	}

	public void setTxtProductoId_Producto(SelectOneMenu txtProductoId_Producto) {
		this.txtProductoId_Producto = txtProductoId_Producto;
	}
	

	public List<ConsultaStockMaquinariaDTO> getDataSaldoProducto() {
		return dataSaldoProducto;
	}

	public void setDataSaldoProducto(List<ConsultaStockMaquinariaDTO> dataSaldoProducto) {
		this.dataSaldoProducto = dataSaldoProducto;
	}

	public InputNumber getTxtValorTotalAcumulado() {
		return txtValorTotalAcumulado;
	}

	public void setTxtValorTotalAcumulado(InputNumber txtValorTotalAcumulado) {
		this.txtValorTotalAcumulado = txtValorTotalAcumulado;
	}

	public InputNumber getTxtSaldoTotal() {
		return txtSaldoTotal;
	}

	public void setTxtSaldoTotal(InputNumber txtSaldoTotal) {
		this.txtSaldoTotal = txtSaldoTotal;
	}
	
	public SelectItem[] getSelectTipoProducto() {

		if (tipoProducto == null || tipoProducto.size() == 0) {

			// tipoProducto = new ArrayList<TipoProducto>();

			try {

				//tipoProducto = businessDelegatorView.getTipoProducto(); // Fin
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

	
	public SelectItem[] getSelectProductoId() throws NumberFormatException, Exception {
		if (txtTipoProducto.getValue() != null) {
			//
			// if (productoId == null || productoId.size() == 0) {

			Long idCompania = new Long(getCompaniaIdSession());
			Long tipoProducto = FacesUtils.checkLong(txtTipoProducto);
			try {
				//List<CatalogProductoDTO> lista = null;
				List<CatalogProductoDTO> lista = businessDelegator2View.pr_listar_productos_tipop(idCompania, tipoProducto);
				selectProductoId = new SelectItem[lista.size()];
				/*int i = 0;
					for (CatalogProductoDTO catalogProductoDTO : lista) {
						selectProductoId[i] = new SelectItem(catalogProductoDTO.getProductoId().longValue(),
								catalogProductoDTO.getCodigo()+"-"+	catalogProductoDTO.getNombre()
	
						);
						i++;

					}
					*/
				
				
					  for(int j = 0; j < lista.size(); j++) {
						  selectProductoId[j] = new SelectItem(lista.get(j).getProductoId().longValue(),
								  lista.get(j).getCodigo()+"-"+	lista.get(j).getNombre());  
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

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}
	
	
	public String action_saldo_ubicacion(ActionEvent evt) throws Exception {
		selectedDatCompraProductos2 = (ConsultaStockMaquinariaDTO) (evt.getComponent().getAttributes()
				.get("selectedDatCompraProductos2"));

		SimpleDateFormat anio = new SimpleDateFormat("yyyy");
	//	String almacenId = FacesUtils.checkString(txtAlmacenId_Almacen2);
		String productoId = FacesUtils.checkString(txtProductoId_Producto);
		Long compania = new Long(getCompaniaIdSession());
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFinalDateRegistro =null;
		Date fechaOriginal = foriginal.parse("1970-01-01");
		String fsalida = sdf.format(fechaOriginal);

		 fechaFinalDateRegistro = sdf.parse(fsalida);
		Date date = new Date();
	
		if( txtProductoId_Producto.getValue()!=null) {
		dataProductoUbicacion = businessDelegator2View.pr_inventario_saldo_producto_ubicacion
						( compania,  fechaFinalDateRegistro,  date, "0" ,  1L, productoId, 0l );
		}
		setShowDialog(true);
		return "";
		
	}

	public List<ConsultaStockMaquinariaDTO> getDataProductoUbicacion() {
		return dataProductoUbicacion;
	}

	public void setDataProductoUbicacion(List<ConsultaStockMaquinariaDTO> dataProductoUbicacion) {
		this.dataProductoUbicacion = dataProductoUbicacion;
	}

	public ConsultaStockMaquinariaDTO getSelectedDatCompraProductos2() {
		return selectedDatCompraProductos2;
	}

	public void setSelectedDatCompraProductos2(ConsultaStockMaquinariaDTO selectedDatCompraProductos2) {
		this.selectedDatCompraProductos2 = selectedDatCompraProductos2;
	}

}
