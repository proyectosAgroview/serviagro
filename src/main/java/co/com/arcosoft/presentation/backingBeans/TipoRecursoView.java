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
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.Servicio;
import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.TipoRecursosEquipos;
import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.TipoRecursosOtros;
import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.TipoRecursoDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosEquiposDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosInsumosDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosOtrosDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosProfesionDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TipoRecursoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TipoRecursoView.class);
	private SelectOneMenu txtClaseRecurso;
	private InputText txtCodigo;
	private InputText txtCompania;
	private SelectOneRadio txtControlCosto;
	private SelectOneRadio txtEstado;
	private InputTextarea txtInfoAdicional;
	private InputTextarea txtInfoAdicional2;
	private InputText txtNombre;
	private InputText txtTpRecursoId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TipoRecursoDTO> data;
	private TipoRecursoDTO selectedTipoRecurso;
	private TipoRecurso entity;

	private List<TipoRecursosProfesionDTO> dataTRProfesion;
	private TipoRecursosProfesionDTO selectedTRProfesion;

	private List<TipoRecursosEquiposDTO> dataTREquipos;
	private TipoRecursosEquiposDTO selectedTREquipos;

	private List<TipoRecursosInsumosDTO> dataTRInsumos;
	private TipoRecursosInsumosDTO selectedTRInsumos;

	private List<TipoRecursosOtrosDTO> dataTROtros;
	private TipoRecursosOtrosDTO selectedTROtros;

	/*** equipos ***/
	private InputText txtDisponibilidadDiaE;
	private InputText txtDisponibilidadTotalE;
	private InputText txtValorE;
	private SelectOneMenu txtCategEquipId_CategoriaEquipo;
	SelectItem[] selectItemCategoriaEquipo;
	private List<CategoriaEquipo> categoriaEquipo;

	private SelectOneMenu txtElemCostoId_ElementoCostoE;
	SelectItem[] selectItemElemCostoE;
	private List<ElementoCosto> elemCostoE;

	private SelectOneMenu txtUdadMedId_UdadMedE;
	SelectItem[] selectItemUdadMedE;
	private List<UdadMed> udadMedE;

	private InputText txtTipoRecursosEquiposId;
	private Calendar txtFechaFinalE;
	private Calendar txtFechaInicialE;
	private CommandButton btnAgregarEquip;

	/** insumos ***/
	private InputText txtValorI;
	private SelectOneMenu txtElemCostoId_ElementoCostoI;
	SelectItem[] selectItemElemCostoI;
	private List<ElementoCosto> elemCostoI;

	private SelectOneMenu txtProductoId_ProductoI;
	SelectItem[] selectItemProducto;
	private List<Producto> producto;

	private SelectOneMenu txtUdadMedId_UdadMedI;
	SelectItem[] selectItemUdadMedI;
	private List<UdadMed> udadMedI;

	private InputText txtTipoRecursosInsumosId;
	private Calendar txtFechaFinalI;
	private Calendar txtFechaInicialI;
	private CommandButton btnAgregarIns;

	/**** otros **/
	private InputText txtCodigoO;
	private InputText txtNombreO;
	private InputText txtValorO;
	private SelectOneMenu txtElemCostoId_ElementoCostoO;
	SelectItem[] selectItemElemCostoO;
	private List<ElementoCosto> elemCostoO;

	private SelectOneMenu txtUdadMedId_UdadMedO;
	SelectItem[] selectItemUdadMedO;
	private List<UdadMed> udadMedO;

	private InputText txtTipoRecursosOtrosId;
	private Calendar txtFechaFinalO;
	private Calendar txtFechaInicialO;
	private CommandButton btnAgregarOtrosO;

	/**** profesion ***/
	private InputText txtDisponibilidadDiaP;
	private InputText txtDisponibilidadTotalP;
	private InputText txtValorP;
	private SelectOneMenu txtElemCostoId_ElementoCostoP;
	SelectItem[] selectItemElemCostoP;
	private List<ElementoCosto> elemCostoP;

	private SelectOneMenu txtProfId_ProfesionP;
	SelectItem[] selectItempProfesion;
	private List<Profesion> profesion;

	private SelectOneMenu txtUdadMedId_UdadMedP;
	SelectItem[] selectItemUdadMedP;
	private List<UdadMed> udadMedP;

	private InputText txtTipoRecursosProfesionId;
	private Calendar txtFechaFinalP;
	private Calendar txtFechaInicialP;
	private CommandButton btnAgregarProfP;

	private InputText txtNomProfesionP;
	private InputText txtNomUdadMedP;
	private InputText txtNomElementoCostoP;

	private InputText txtNomCategoriaE;
	private InputText txtNomUdadMedE;
	private InputText txtNomElementoCostoE;

	private InputText txtNomProductoI;
	private InputText txtNomUdadMedI;
	private InputText txtNomElementoCostoI;

	private InputText txtNomUdadMedO;
	private InputText txtNomElementoCostoPO;

	private SelectOneMenu txtServicioId_Servicio;
	SelectItem[] selectItemServicio;
	private List<Servicio> servicio;
	
	private TipoRecursosProfesion entityTipoRecursosProfesion;
	private TipoRecursosInsumos entityTipoRecursosInsumos;
	private TipoRecursosEquipos entityTipoRecursosEquipos;
	private TipoRecursosOtros entityTipoRecursosOtros;

	private InputText txtNomServicio;

	private int activeTapIndex = 0;

	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TipoRecursoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoRecursoDTO tipoRecursoDTO = (TipoRecursoDTO) e.getObject();

			if (txtClaseRecurso == null) {
				txtClaseRecurso = new SelectOneMenu();
			}

			txtClaseRecurso.setValue(tipoRecursoDTO.getClaseRecurso());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoRecursoDTO.getCodigo());

			if (txtCompania == null) {
				txtCompania = new InputText();
			}

			txtCompania.setValue(tipoRecursoDTO.getCompania());

			if (txtControlCosto == null) {
				txtControlCosto = new SelectOneRadio();
			}

			txtControlCosto.setValue(tipoRecursoDTO.getControlCosto());

			if (txtEstado == null) {
				txtEstado = new SelectOneRadio();
			}

			txtEstado.setValue(tipoRecursoDTO.getEstado());

			if (txtInfoAdicional == null) {
				txtInfoAdicional = new InputTextarea();
			}

			txtInfoAdicional.setValue(tipoRecursoDTO.getInfoAdicional());

			if (txtInfoAdicional2 == null) {
				txtInfoAdicional2 = new InputTextarea();
			}

			txtInfoAdicional2.setValue(tipoRecursoDTO.getInfoAdicional2());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(tipoRecursoDTO.getNombre());

			if (txtTpRecursoId == null) {
				txtTpRecursoId = new InputText();
			}

			txtTpRecursoId.setValue(tipoRecursoDTO.getTpRecursoId());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tipoRecursoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tipoRecursoDTO.getFechaModificacion());

			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
			entity = businessDelegatorView.getTipoRecurso(tpRecursoId);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoRecurso = null;

		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoRecurso = null;
		PrimeFaces.current().resetInputs(":dialogTipoRecurso :frm");
		activeTapIndex = 0;

		if (txtClaseRecurso != null) {
			txtClaseRecurso.setValue(null);
			txtClaseRecurso.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(false);
		}

		if (txtCompania != null) {
			txtCompania.setValue(null);
			txtCompania.setDisabled(true);
		}

		if (txtControlCosto != null) {
			txtControlCosto.setValue(null);
			txtControlCosto.setDisabled(true);
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

		if (txtTpRecursoId != null) {
			txtTpRecursoId.setValue(null);
			txtTpRecursoId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		if (dataTRProfesion != null) {
			dataTRProfesion = null;
		}
		if (dataTREquipos != null) {
			dataTREquipos = null;
		}
		if (dataTRInsumos != null) {
			dataTRInsumos = null;
		}
		if (dataTROtros != null) {
			dataTROtros = null;
		}

		// ***equipos***/

		if (txtDisponibilidadDiaE != null) {
			txtDisponibilidadDiaE.setValue(null);
			txtDisponibilidadDiaE.setDisabled(true);
		}
		if (txtDisponibilidadTotalE != null) {
			txtDisponibilidadTotalE.setValue(null);
			txtDisponibilidadTotalE.setDisabled(true);
		}
		if (txtValorE != null) {
			txtValorE.setValue(null);
			txtValorE.setDisabled(true);
		}
		if (txtCategEquipId_CategoriaEquipo != null) {
			txtCategEquipId_CategoriaEquipo.setValue(null);
			txtCategEquipId_CategoriaEquipo.setDisabled(true);
		}
		if (txtElemCostoId_ElementoCostoE != null) {
			txtElemCostoId_ElementoCostoE.setValue(null);
			txtElemCostoId_ElementoCostoE.setDisabled(true);
		}
		if (txtUdadMedId_UdadMedE != null) {
			txtUdadMedId_UdadMedE.setValue(null);
			txtUdadMedId_UdadMedE.setDisabled(true);
		}
		if (txtTipoRecursosEquiposId != null) {
			txtTipoRecursosEquiposId.setValue(null);
			txtTipoRecursosEquiposId.setDisabled(true);
		}
		if (txtFechaFinalE != null) {
			txtFechaFinalE.setValue(null);
			txtFechaFinalE.setDisabled(true);
		}
		if (txtFechaInicialE != null) {
			txtFechaInicialE.setValue(null);
			txtFechaInicialE.setDisabled(true);
		}
		if (btnAgregarEquip != null) {
			btnAgregarEquip.setDisabled(true);
		}

		/** insumos ***/

		if (txtValorI != null) {
			txtValorI.setValue(null);
			txtValorI.setDisabled(true);
		}
		if (txtProductoId_ProductoI != null) {
			txtProductoId_ProductoI.setValue(null);
			txtProductoId_ProductoI.setDisabled(true);
		}
		if (txtElemCostoId_ElementoCostoI != null) {
			txtElemCostoId_ElementoCostoI.setValue(null);
			txtElemCostoId_ElementoCostoI.setDisabled(true);
		}
		if (txtUdadMedId_UdadMedI != null) {
			txtUdadMedId_UdadMedI.setValue(null);
			txtUdadMedId_UdadMedI.setDisabled(true);
		}
		if (txtTipoRecursosInsumosId != null) {
			txtTipoRecursosInsumosId.setValue(null);
			txtTipoRecursosInsumosId.setDisabled(true);
		}
		if (txtFechaFinalI != null) {
			txtFechaFinalI.setValue(null);
			txtFechaFinalI.setDisabled(true);
		}
		if (txtFechaInicialI != null) {
			txtFechaInicialI.setValue(null);
			txtFechaInicialI.setDisabled(true);
		}
		if (btnAgregarIns != null) {
			btnAgregarIns.setDisabled(true);
		}

		/**** otros **/

		if (txtValorO != null) {
			txtValorO.setValue(null);
			txtValorO.setDisabled(true);
		}
		if (txtCodigoO != null) {
			txtCodigoO.setValue(null);
			txtCodigoO.setDisabled(true);
		}
		if (txtNombreO != null) {
			txtNombreO.setValue(null);
			txtNombreO.setDisabled(true);
		}
		if (txtElemCostoId_ElementoCostoO != null) {
			txtElemCostoId_ElementoCostoO.setValue(null);
			txtElemCostoId_ElementoCostoO.setDisabled(true);
		}
		if (txtUdadMedId_UdadMedO != null) {
			txtUdadMedId_UdadMedO.setValue(null);
			txtUdadMedId_UdadMedO.setDisabled(true);
		}
		if (txtTipoRecursosOtrosId != null) {
			txtTipoRecursosOtrosId.setValue(null);
			txtTipoRecursosOtrosId.setDisabled(true);
		}
		if (txtFechaFinalO != null) {
			txtFechaFinalO.setValue(null);
			txtFechaFinalO.setDisabled(true);
		}
		if (txtFechaInicialO != null) {
			txtFechaInicialO.setValue(null);
			txtFechaInicialO.setDisabled(true);
		}
		if (btnAgregarOtrosO != null) {
			btnAgregarOtrosO.setDisabled(true);
		}

		/**** profesion ***/

		if (txtDisponibilidadDiaP != null) {
			txtDisponibilidadDiaP.setValue(null);
			txtDisponibilidadDiaP.setDisabled(true);
		}
		if (txtDisponibilidadTotalP != null) {
			txtDisponibilidadTotalP.setValue(null);
			txtDisponibilidadTotalP.setDisabled(true);
		}
		if (txtValorP != null) {
			txtValorP.setValue(null);
			txtValorP.setDisabled(true);
		}
		if (txtProfId_ProfesionP != null) {
			txtProfId_ProfesionP.setValue(null);
			txtProfId_ProfesionP.setDisabled(true);
		}
		if (txtElemCostoId_ElementoCostoP != null) {
			txtElemCostoId_ElementoCostoP.setValue(null);
			txtElemCostoId_ElementoCostoP.setDisabled(true);
		}
		if (txtUdadMedId_UdadMedP != null) {
			txtUdadMedId_UdadMedP.setValue(null);
			txtUdadMedId_UdadMedP.setDisabled(true);
		}
		if (txtTipoRecursosProfesionId != null) {
			txtTipoRecursosProfesionId.setValue(null);
			txtTipoRecursosProfesionId.setDisabled(true);
		}
		if (txtFechaFinalP != null) {
			txtFechaFinalP.setValue(null);
			txtFechaFinalP.setDisabled(true);
		}
		if (txtFechaInicialP != null) {
			txtFechaInicialP.setValue(null);
			txtFechaInicialP.setDisabled(true);
		}
		if (btnAgregarProfP != null) {
			btnAgregarProfP.setDisabled(true);
		}

		if (txtNomProfesionP != null) {
			txtNomProfesionP.setValue(null);
			txtNomProfesionP.setDisabled(true);
		}

		if (txtNomUdadMedP != null) {
			txtNomUdadMedP.setValue(null);
			txtNomUdadMedP.setDisabled(true);
		}

		if (txtNomElementoCostoP != null) {
			txtNomElementoCostoP.setValue(null);
			txtNomElementoCostoP.setDisabled(true);
		}

		if (txtNomUdadMedE != null) {
			txtNomUdadMedE.setValue(null);
			txtNomUdadMedE.setDisabled(true);
		}

		if (txtNomElementoCostoE != null) {
			txtNomElementoCostoE.setValue(null);
			txtNomElementoCostoE.setDisabled(true);
		}

		if (txtNomUdadMedI != null) {
			txtNomUdadMedI.setValue(null);
			txtNomUdadMedI.setDisabled(true);
		}

		if (txtNomElementoCostoI != null) {
			txtNomElementoCostoI.setValue(null);
			txtNomElementoCostoI.setDisabled(true);
		}
		if (txtNomUdadMedO != null) {
			txtNomUdadMedO.setValue(null);
			txtNomUdadMedO.setDisabled(true);
		}

		if (txtNomElementoCostoPO != null) {
			txtNomElementoCostoPO.setValue(null);
			txtNomElementoCostoPO.setDisabled(true);
		}
		if (txtNomCategoriaE != null) {
			txtNomCategoriaE.setValue(null);
			txtNomCategoriaE.setDisabled(true);
		}
		if (txtNomProductoI != null) {
			txtNomProductoI.setValue(null);
			txtNomProductoI.setDisabled(true);
		}

		if (txtServicioId_Servicio != null) {
			txtServicioId_Servicio.setValue(null);
			txtServicioId_Servicio.setDisabled(true);
		}
		if (txtNomServicio != null) {
			txtNomServicio.setValue(null);
			txtNomServicio.setDisabled(true);
		}

		return "";
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

	public void listener_txtCodigo() throws Exception {
		try {

			String codigo = FacesUtils.checkString(txtCodigo).toUpperCase();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<TipoRecurso> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTipoRecurso(condicion, null, null) : null;

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
			txtClaseRecurso.setDisabled(false);
			txtCodigo.setDisabled(false);
			// txtCompania.setDisabled(false);
			// txtControlCosto.setDisabled(false);
			txtEstado.setDisabled(false);
			txtInfoAdicional.setDisabled(false);
			txtInfoAdicional2.setDisabled(false);
			txtNombre.setDisabled(false);
			// txtFechaCreacion.setDisabled(false);
			// txtFechaModificacion.setDisabled(false);
			txtTpRecursoId.setDisabled(false);
			btnSave.setDisabled(false);

			dataTRProfesion = null;
			dataTREquipos = null;
			dataTRInsumos = null;
			dataTROtros = null;
			txtDisponibilidadDiaE.setDisabled(true);
			txtDisponibilidadTotalE.setDisabled(true);
			txtValorE.setDisabled(true);
			txtCategEquipId_CategoriaEquipo.setDisabled(true);
			txtElemCostoId_ElementoCostoE.setDisabled(true);
			txtUdadMedId_UdadMedE.setDisabled(true);
			txtTipoRecursosEquiposId.setDisabled(true);
			txtFechaFinalE.setDisabled(true);
			txtFechaInicialE.setDisabled(true);
			btnAgregarEquip.setDisabled(true);
			txtValorI.setDisabled(true);
			txtProductoId_ProductoI.setDisabled(true);
			txtElemCostoId_ElementoCostoI.setDisabled(true);
			txtUdadMedId_UdadMedI.setDisabled(true);
			txtTipoRecursosInsumosId.setDisabled(true);
			txtFechaFinalI.setDisabled(true);
			txtFechaInicialI.setDisabled(true);
			btnAgregarIns.setDisabled(true);
			txtValorO.setDisabled(true);
			// txtCodigoO.setDisabled(true);
			// txtNombreO.setDisabled(true);
			txtElemCostoId_ElementoCostoO.setDisabled(true);
			txtUdadMedId_UdadMedO.setDisabled(true);
			txtTipoRecursosOtrosId.setDisabled(true);
			txtFechaFinalO.setDisabled(true);
			txtFechaInicialO.setDisabled(true);
			btnAgregarOtrosO.setDisabled(true);
			txtDisponibilidadDiaP.setDisabled(true);
			txtDisponibilidadTotalP.setDisabled(true);
			txtValorP.setDisabled(true);
			txtProfId_ProfesionP.setDisabled(true);
			txtElemCostoId_ElementoCostoP.setDisabled(true);
			txtUdadMedId_UdadMedP.setDisabled(true);
			txtTipoRecursosProfesionId.setDisabled(true);
			txtFechaFinalP.setDisabled(true);
			txtFechaInicialP.setDisabled(true);
			btnAgregarProfP.setDisabled(true);
			txtNomProfesionP.setDisabled(true);
			txtNomUdadMedP.setDisabled(true);
			txtNomElementoCostoP.setDisabled(true);
			txtNomUdadMedE.setDisabled(true);
			txtNomElementoCostoE.setDisabled(true);
			txtNomUdadMedI.setDisabled(true);
			txtNomElementoCostoI.setDisabled(true);
			txtNomUdadMedO.setDisabled(true);
			txtNomElementoCostoPO.setDisabled(true);
			txtNomCategoriaE.setDisabled(true);
			txtNomProductoI.setDisabled(true);

			txtServicioId_Servicio.setDisabled(true);
			txtNomServicio.setDisabled(true);

		} else {
			txtClaseRecurso.setValue(entity.getClaseRecurso());
			txtClaseRecurso.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			// txtCompania.setValue(entity.getCompania());
			// txtCompania.setDisabled(false);
			// txtControlCosto.setValue(entity.getControlCosto());
			// txtControlCosto.setDisabled(false);
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
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtTpRecursoId.setValue(entity.getTpRecursoId());
			txtTpRecursoId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}

			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
			dataTRProfesion = null;
			dataTRProfesion = businessDelegatorView.getDataTipoRecursosProfesionByProfesion(tpRecursoId);

			dataTREquipos = null;
			dataTREquipos = businessDelegatorView.getDataTipoRecursosEquiposByEquipos(tpRecursoId);

			dataTRInsumos = null;
			dataTRInsumos = businessDelegatorView.getDataTipoRecursosInsumosByInsumos(tpRecursoId);

			dataTROtros = null;
			dataTROtros = businessDelegatorView.getDataTipoRecursosOtrosByOtros(tpRecursoId);

			String tipoTransaccion = "";

			if (!txtClaseRecurso.getValue().equals("")) {
				tipoTransaccion = (txtClaseRecurso.getValue().toString());
				if (tipoTransaccion.equals("Productos")) {
					txtDisponibilidadDiaE.setDisabled(true);
					txtDisponibilidadTotalE.setDisabled(true);
					txtValorE.setDisabled(true);
					txtCategEquipId_CategoriaEquipo.setDisabled(true);
					txtElemCostoId_ElementoCostoE.setDisabled(true);
					txtUdadMedId_UdadMedE.setDisabled(true);
					txtTipoRecursosEquiposId.setDisabled(true);
					txtFechaFinalE.setDisabled(true);
					txtFechaInicialE.setDisabled(true);
					btnAgregarEquip.setDisabled(true);
					txtValorI.setDisabled(false);
					txtProductoId_ProductoI.setDisabled(false);
					txtElemCostoId_ElementoCostoI.setDisabled(false);
					txtUdadMedId_UdadMedI.setDisabled(false);
					txtTipoRecursosInsumosId.setDisabled(false);
					txtFechaFinalI.setDisabled(false);
					txtFechaInicialI.setDisabled(false);
					btnAgregarIns.setDisabled(false);
					txtValorO.setDisabled(true);
					// txtCodigoO.setDisabled(true);
					// txtNombreO.setDisabled(true);
					txtServicioId_Servicio.setDisabled(true);
					txtNomServicio.setDisabled(true);
					txtElemCostoId_ElementoCostoO.setDisabled(true);
					txtUdadMedId_UdadMedO.setDisabled(true);
					txtTipoRecursosOtrosId.setDisabled(true);
					txtFechaFinalO.setDisabled(true);
					txtFechaInicialO.setDisabled(true);
					btnAgregarOtrosO.setDisabled(true);
					txtDisponibilidadDiaP.setDisabled(true);
					txtDisponibilidadTotalP.setDisabled(true);
					txtValorP.setDisabled(true);
					txtProfId_ProfesionP.setDisabled(true);
					txtElemCostoId_ElementoCostoP.setDisabled(true);
					txtUdadMedId_UdadMedP.setDisabled(true);
					txtTipoRecursosProfesionId.setDisabled(true);
					txtFechaFinalP.setDisabled(true);
					txtFechaInicialP.setDisabled(true);
					btnAgregarProfP.setDisabled(true);
					txtNomProfesionP.setDisabled(false);
					txtNomUdadMedP.setDisabled(false);
					txtNomElementoCostoP.setDisabled(false);
					txtNomUdadMedE.setDisabled(false);
					txtNomElementoCostoE.setDisabled(false);
					txtNomUdadMedI.setDisabled(false);
					txtNomElementoCostoI.setDisabled(false);
					txtNomUdadMedO.setDisabled(false);
					txtNomElementoCostoPO.setDisabled(false);
					txtNomCategoriaE.setDisabled(false);
					txtNomProductoI.setDisabled(false);

				}
				if (tipoTransaccion.equals("Categoria de equipos")) {
					txtDisponibilidadDiaE.setDisabled(false);
					txtDisponibilidadTotalE.setDisabled(false);
					txtValorE.setDisabled(false);
					txtCategEquipId_CategoriaEquipo.setDisabled(false);
					txtElemCostoId_ElementoCostoE.setDisabled(false);
					txtUdadMedId_UdadMedE.setDisabled(false);
					txtTipoRecursosEquiposId.setDisabled(false);
					txtFechaFinalE.setDisabled(false);
					txtFechaInicialE.setDisabled(false);
					btnAgregarEquip.setDisabled(false);
					txtValorI.setDisabled(true);
					txtProductoId_ProductoI.setDisabled(true);
					txtElemCostoId_ElementoCostoI.setDisabled(true);
					txtUdadMedId_UdadMedI.setDisabled(true);
					txtTipoRecursosInsumosId.setDisabled(true);
					txtFechaFinalI.setDisabled(true);
					txtFechaInicialI.setDisabled(true);
					btnAgregarIns.setDisabled(true);
					txtValorO.setDisabled(true);
					// txtCodigoO.setDisabled(true);
					// txtNombreO.setDisabled(true);
					txtServicioId_Servicio.setDisabled(true);
					txtNomServicio.setDisabled(true);

					txtElemCostoId_ElementoCostoO.setDisabled(true);
					txtUdadMedId_UdadMedO.setDisabled(true);
					txtTipoRecursosOtrosId.setDisabled(true);
					txtFechaFinalO.setDisabled(true);
					txtFechaInicialO.setDisabled(true);
					btnAgregarOtrosO.setDisabled(true);
					txtDisponibilidadDiaP.setDisabled(true);
					txtDisponibilidadTotalP.setDisabled(true);
					txtValorP.setDisabled(true);
					txtProfId_ProfesionP.setDisabled(true);
					txtElemCostoId_ElementoCostoP.setDisabled(true);
					txtUdadMedId_UdadMedP.setDisabled(true);
					txtTipoRecursosProfesionId.setDisabled(true);
					txtFechaFinalP.setDisabled(true);
					txtFechaInicialP.setDisabled(true);
					btnAgregarProfP.setDisabled(true);
					txtNomProfesionP.setDisabled(false);
					txtNomUdadMedP.setDisabled(false);
					txtNomElementoCostoP.setDisabled(false);
					txtNomUdadMedE.setDisabled(false);
					txtNomElementoCostoE.setDisabled(false);
					txtNomUdadMedI.setDisabled(false);
					txtNomElementoCostoI.setDisabled(false);
					txtNomUdadMedO.setDisabled(false);
					txtNomElementoCostoPO.setDisabled(false);
					txtNomCategoriaE.setDisabled(false);
					txtNomProductoI.setDisabled(false);

				}

				if (tipoTransaccion.equals("Profesiones/Cargos")) {
					txtDisponibilidadDiaE.setDisabled(true);
					txtDisponibilidadTotalE.setDisabled(true);
					txtValorE.setDisabled(true);
					txtCategEquipId_CategoriaEquipo.setDisabled(true);
					txtElemCostoId_ElementoCostoE.setDisabled(true);
					txtUdadMedId_UdadMedE.setDisabled(true);
					txtTipoRecursosEquiposId.setDisabled(true);
					txtFechaFinalE.setDisabled(true);
					txtFechaInicialE.setDisabled(true);
					btnAgregarEquip.setDisabled(true);
					txtValorI.setDisabled(true);
					txtProductoId_ProductoI.setDisabled(true);
					txtElemCostoId_ElementoCostoI.setDisabled(true);
					txtUdadMedId_UdadMedI.setDisabled(true);
					txtTipoRecursosInsumosId.setDisabled(true);
					txtFechaFinalI.setDisabled(true);
					txtFechaInicialI.setDisabled(true);
					btnAgregarIns.setDisabled(true);
					txtValorO.setDisabled(true);
					// txtCodigoO.setDisabled(true);
					// txtNombreO.setDisabled(true);
					txtServicioId_Servicio.setDisabled(true);
					txtNomServicio.setDisabled(true);

					txtElemCostoId_ElementoCostoO.setDisabled(true);
					txtUdadMedId_UdadMedO.setDisabled(true);
					txtTipoRecursosOtrosId.setDisabled(true);
					txtFechaFinalO.setDisabled(true);
					txtFechaInicialO.setDisabled(true);
					btnAgregarOtrosO.setDisabled(true);
					txtDisponibilidadDiaP.setDisabled(false);
					txtDisponibilidadTotalP.setDisabled(false);
					txtValorP.setDisabled(false);
					txtProfId_ProfesionP.setDisabled(false);
					txtElemCostoId_ElementoCostoP.setDisabled(false);
					txtUdadMedId_UdadMedP.setDisabled(false);
					txtTipoRecursosProfesionId.setDisabled(false);
					txtFechaFinalP.setDisabled(false);
					txtFechaInicialP.setDisabled(false);
					btnAgregarProfP.setDisabled(false);
					txtNomProfesionP.setDisabled(false);
					txtNomUdadMedP.setDisabled(false);
					txtNomElementoCostoP.setDisabled(false);
					txtNomUdadMedE.setDisabled(false);
					txtNomElementoCostoE.setDisabled(false);
					txtNomUdadMedI.setDisabled(false);
					txtNomElementoCostoI.setDisabled(false);
					txtNomUdadMedO.setDisabled(false);
					txtNomElementoCostoPO.setDisabled(false);
					txtNomCategoriaE.setDisabled(false);
					txtNomProductoI.setDisabled(false);

				}
				if (tipoTransaccion.equals("Otros")) {
					txtDisponibilidadDiaE.setDisabled(true);
					txtDisponibilidadTotalE.setDisabled(true);
					txtValorE.setDisabled(true);
					txtCategEquipId_CategoriaEquipo.setDisabled(true);
					txtElemCostoId_ElementoCostoE.setDisabled(true);
					txtUdadMedId_UdadMedE.setDisabled(true);
					txtTipoRecursosEquiposId.setDisabled(true);
					txtFechaFinalE.setDisabled(true);
					txtFechaInicialE.setDisabled(true);
					btnAgregarEquip.setDisabled(true);
					txtValorI.setDisabled(true);
					txtProductoId_ProductoI.setDisabled(true);
					txtElemCostoId_ElementoCostoI.setDisabled(true);
					txtUdadMedId_UdadMedI.setDisabled(true);
					txtTipoRecursosInsumosId.setDisabled(true);
					txtFechaFinalI.setDisabled(true);
					txtFechaInicialI.setDisabled(true);
					btnAgregarIns.setDisabled(true);
					txtValorO.setDisabled(false);
					// txtCodigoO.setDisabled(false);
					// txtNombreO.setDisabled(false);
					txtServicioId_Servicio.setDisabled(true);
					txtNomServicio.setDisabled(true);

					txtElemCostoId_ElementoCostoO.setDisabled(false);
					txtUdadMedId_UdadMedO.setDisabled(false);
					txtTipoRecursosOtrosId.setDisabled(false);
					txtFechaFinalO.setDisabled(false);
					txtFechaInicialO.setDisabled(false);
					btnAgregarOtrosO.setDisabled(false);
					txtDisponibilidadDiaP.setDisabled(true);
					txtDisponibilidadTotalP.setDisabled(true);
					txtValorP.setDisabled(true);
					txtProfId_ProfesionP.setDisabled(true);
					txtElemCostoId_ElementoCostoP.setDisabled(true);
					txtUdadMedId_UdadMedP.setDisabled(true);
					txtTipoRecursosProfesionId.setDisabled(true);
					txtFechaFinalP.setDisabled(true);
					txtFechaInicialP.setDisabled(true);
					btnAgregarProfP.setDisabled(true);
					txtNomProfesionP.setDisabled(false);
					txtNomUdadMedP.setDisabled(false);
					txtNomElementoCostoP.setDisabled(false);
					txtNomUdadMedE.setDisabled(false);
					txtNomElementoCostoE.setDisabled(false);
					txtNomUdadMedI.setDisabled(false);
					txtNomElementoCostoI.setDisabled(false);
					txtNomUdadMedO.setDisabled(false);
					txtNomElementoCostoPO.setDisabled(false);
					txtNomCategoriaE.setDisabled(false);
					txtNomProductoI.setDisabled(false);

				}

			}

		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoRecurso = (TipoRecursoDTO) (evt.getComponent().getAttributes().get("selectedTipoRecurso"));
		try {

			String codigo = selectedTipoRecurso.getCodigo();
			Object[] condicion = { "codigo", true, codigo, "=" };
			List<TipoRecurso> lista = (codigo != null)
					? businessDelegatorView.findByCriteriaInTipoRecurso(condicion, null, null) : null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);

				txtClaseRecurso.setValue(entity.getClaseRecurso());
				txtClaseRecurso.setDisabled(false);
				txtCodigo.setValue(entity.getCodigo());
				txtCodigo.setDisabled(false);
				// txtCompania.setValue(entity.getCompania());
				// txtCompania.setDisabled(false);
				// txtControlCosto.setValue(entity.getControlCosto());
				// txtControlCosto.setDisabled(false);
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
				txtNombre.setValue(entity.getNombre());
				txtNombre.setDisabled(false);
				txtTpRecursoId.setValue(entity.getTpRecursoId());
				txtTpRecursoId.setDisabled(true);
				btnSave.setDisabled(false);

				Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
				dataTRProfesion = null;
				dataTRProfesion = businessDelegatorView.getDataTipoRecursosProfesionByProfesion(tpRecursoId);

				dataTREquipos = null;
				dataTREquipos = businessDelegatorView.getDataTipoRecursosEquiposByEquipos(tpRecursoId);

				dataTRInsumos = null;
				dataTRInsumos = businessDelegatorView.getDataTipoRecursosInsumosByInsumos(tpRecursoId);

				dataTROtros = null;
				dataTROtros = businessDelegatorView.getDataTipoRecursosOtrosByOtros(tpRecursoId);

				String tipoTransaccion = "";

				if (!txtClaseRecurso.getValue().equals("")) {
					tipoTransaccion = (txtClaseRecurso.getValue().toString());
					if (tipoTransaccion.equals("Productos")) {
						txtDisponibilidadDiaE.setDisabled(true);
						txtDisponibilidadTotalE.setDisabled(true);
						txtValorE.setDisabled(true);
						txtCategEquipId_CategoriaEquipo.setDisabled(true);
						txtElemCostoId_ElementoCostoE.setDisabled(true);
						txtUdadMedId_UdadMedE.setDisabled(true);
						txtTipoRecursosEquiposId.setDisabled(true);
						txtFechaFinalE.setDisabled(true);
						txtFechaInicialE.setDisabled(true);
						btnAgregarEquip.setDisabled(true);
						txtValorI.setDisabled(false);
						txtProductoId_ProductoI.setDisabled(false);
						txtElemCostoId_ElementoCostoI.setDisabled(false);
						txtUdadMedId_UdadMedI.setDisabled(false);
						txtTipoRecursosInsumosId.setDisabled(false);
						txtFechaFinalI.setDisabled(false);
						txtFechaInicialI.setDisabled(false);
						btnAgregarIns.setDisabled(false);
						txtValorO.setDisabled(true);
						// txtCodigoO.setDisabled(true);
						// txtNombreO.setDisabled(true);
						txtServicioId_Servicio.setDisabled(true);
						txtNomServicio.setDisabled(true);

						txtElemCostoId_ElementoCostoO.setDisabled(true);
						txtUdadMedId_UdadMedO.setDisabled(true);
						txtTipoRecursosOtrosId.setDisabled(true);
						txtFechaFinalO.setDisabled(true);
						txtFechaInicialO.setDisabled(true);
						btnAgregarOtrosO.setDisabled(true);
						txtDisponibilidadDiaP.setDisabled(true);
						txtDisponibilidadTotalP.setDisabled(true);
						txtValorP.setDisabled(true);
						txtProfId_ProfesionP.setDisabled(true);
						txtElemCostoId_ElementoCostoP.setDisabled(true);
						txtUdadMedId_UdadMedP.setDisabled(true);
						txtTipoRecursosProfesionId.setDisabled(true);
						txtFechaFinalP.setDisabled(true);
						txtFechaInicialP.setDisabled(true);
						btnAgregarProfP.setDisabled(true);
						txtNomProfesionP.setDisabled(false);
						txtNomUdadMedP.setDisabled(false);
						txtNomElementoCostoP.setDisabled(false);
						txtNomUdadMedE.setDisabled(false);
						txtNomElementoCostoE.setDisabled(false);
						txtNomUdadMedI.setDisabled(false);
						txtNomElementoCostoI.setDisabled(false);
						txtNomUdadMedO.setDisabled(false);
						txtNomElementoCostoPO.setDisabled(false);
						txtNomCategoriaE.setDisabled(false);
						txtNomProductoI.setDisabled(false);

					}
					if (tipoTransaccion.equals("Categoria de equipos")) {
						txtDisponibilidadDiaE.setDisabled(false);
						txtDisponibilidadTotalE.setDisabled(false);
						txtValorE.setDisabled(false);
						txtCategEquipId_CategoriaEquipo.setDisabled(false);
						txtElemCostoId_ElementoCostoE.setDisabled(false);
						txtUdadMedId_UdadMedE.setDisabled(false);
						txtTipoRecursosEquiposId.setDisabled(false);
						txtFechaFinalE.setDisabled(false);
						txtFechaInicialE.setDisabled(false);
						btnAgregarEquip.setDisabled(false);
						txtValorI.setDisabled(true);
						txtProductoId_ProductoI.setDisabled(true);
						txtElemCostoId_ElementoCostoI.setDisabled(true);
						txtUdadMedId_UdadMedI.setDisabled(true);
						txtTipoRecursosInsumosId.setDisabled(true);
						txtFechaFinalI.setDisabled(true);
						txtFechaInicialI.setDisabled(true);
						btnAgregarIns.setDisabled(true);
						txtValorO.setDisabled(true);
						// txtCodigoO.setDisabled(true);
						// txtNombreO.setDisabled(true);
						txtServicioId_Servicio.setDisabled(true);
						txtNomServicio.setDisabled(true);

						txtElemCostoId_ElementoCostoO.setDisabled(true);
						txtUdadMedId_UdadMedO.setDisabled(true);
						txtTipoRecursosOtrosId.setDisabled(true);
						txtFechaFinalO.setDisabled(true);
						txtFechaInicialO.setDisabled(true);
						btnAgregarOtrosO.setDisabled(true);
						txtDisponibilidadDiaP.setDisabled(true);
						txtDisponibilidadTotalP.setDisabled(true);
						txtValorP.setDisabled(true);
						txtProfId_ProfesionP.setDisabled(true);
						txtElemCostoId_ElementoCostoP.setDisabled(true);
						txtUdadMedId_UdadMedP.setDisabled(true);
						txtTipoRecursosProfesionId.setDisabled(true);
						txtFechaFinalP.setDisabled(true);
						txtFechaInicialP.setDisabled(true);
						btnAgregarProfP.setDisabled(true);
						txtNomProfesionP.setDisabled(false);
						txtNomUdadMedP.setDisabled(false);
						txtNomElementoCostoP.setDisabled(false);
						txtNomUdadMedE.setDisabled(false);
						txtNomElementoCostoE.setDisabled(false);
						txtNomUdadMedI.setDisabled(false);
						txtNomElementoCostoI.setDisabled(false);
						txtNomUdadMedO.setDisabled(false);
						txtNomElementoCostoPO.setDisabled(false);
						txtNomCategoriaE.setDisabled(false);
						txtNomProductoI.setDisabled(false);

					}

					if (tipoTransaccion.equals("Profesiones/Cargos")) {
						txtDisponibilidadDiaE.setDisabled(true);
						txtDisponibilidadTotalE.setDisabled(true);
						txtValorE.setDisabled(true);
						txtCategEquipId_CategoriaEquipo.setDisabled(true);
						txtElemCostoId_ElementoCostoE.setDisabled(true);
						txtUdadMedId_UdadMedE.setDisabled(true);
						txtTipoRecursosEquiposId.setDisabled(true);
						txtFechaFinalE.setDisabled(true);
						txtFechaInicialE.setDisabled(true);
						btnAgregarEquip.setDisabled(true);
						txtValorI.setDisabled(true);
						txtProductoId_ProductoI.setDisabled(true);
						txtElemCostoId_ElementoCostoI.setDisabled(true);
						txtUdadMedId_UdadMedI.setDisabled(true);
						txtTipoRecursosInsumosId.setDisabled(true);
						txtFechaFinalI.setDisabled(true);
						txtFechaInicialI.setDisabled(true);
						btnAgregarIns.setDisabled(true);
						txtValorO.setDisabled(true);
						// txtCodigoO.setDisabled(true);
						// txtNombreO.setDisabled(true);
						txtServicioId_Servicio.setDisabled(true);
						txtNomServicio.setDisabled(true);

						txtElemCostoId_ElementoCostoO.setDisabled(true);
						txtUdadMedId_UdadMedO.setDisabled(true);
						txtTipoRecursosOtrosId.setDisabled(true);
						txtFechaFinalO.setDisabled(true);
						txtFechaInicialO.setDisabled(true);
						btnAgregarOtrosO.setDisabled(true);
						txtDisponibilidadDiaP.setDisabled(false);
						txtDisponibilidadTotalP.setDisabled(false);
						txtValorP.setDisabled(false);
						txtProfId_ProfesionP.setDisabled(false);
						txtElemCostoId_ElementoCostoP.setDisabled(false);
						txtUdadMedId_UdadMedP.setDisabled(false);
						txtTipoRecursosProfesionId.setDisabled(false);
						txtFechaFinalP.setDisabled(false);
						txtFechaInicialP.setDisabled(false);
						btnAgregarProfP.setDisabled(false);
						txtNomProfesionP.setDisabled(false);
						txtNomUdadMedP.setDisabled(false);
						txtNomElementoCostoP.setDisabled(false);
						txtNomUdadMedE.setDisabled(false);
						txtNomElementoCostoE.setDisabled(false);
						txtNomUdadMedI.setDisabled(false);
						txtNomElementoCostoI.setDisabled(false);
						txtNomUdadMedO.setDisabled(false);
						txtNomElementoCostoPO.setDisabled(false);
						txtNomCategoriaE.setDisabled(false);
						txtNomProductoI.setDisabled(false);

					}
					if (tipoTransaccion.equals("Otros")) {
						txtDisponibilidadDiaE.setDisabled(true);
						txtDisponibilidadTotalE.setDisabled(true);
						txtValorE.setDisabled(true);
						txtCategEquipId_CategoriaEquipo.setDisabled(true);
						txtElemCostoId_ElementoCostoE.setDisabled(true);
						txtUdadMedId_UdadMedE.setDisabled(true);
						txtTipoRecursosEquiposId.setDisabled(true);
						txtFechaFinalE.setDisabled(true);
						txtFechaInicialE.setDisabled(true);
						btnAgregarEquip.setDisabled(true);
						txtValorI.setDisabled(true);
						txtProductoId_ProductoI.setDisabled(true);
						txtElemCostoId_ElementoCostoI.setDisabled(true);
						txtUdadMedId_UdadMedI.setDisabled(true);
						txtTipoRecursosInsumosId.setDisabled(true);
						txtFechaFinalI.setDisabled(true);
						txtFechaInicialI.setDisabled(true);
						btnAgregarIns.setDisabled(true);
						txtValorO.setDisabled(false);
						// txtCodigoO.setDisabled(false);
						// txtNombreO.setDisabled(false);
						txtServicioId_Servicio.setDisabled(false);
						txtNomServicio.setDisabled(false);

						txtElemCostoId_ElementoCostoO.setDisabled(false);
						txtUdadMedId_UdadMedO.setDisabled(false);
						txtTipoRecursosOtrosId.setDisabled(false);
						txtFechaFinalO.setDisabled(false);
						txtFechaInicialO.setDisabled(false);
						btnAgregarOtrosO.setDisabled(false);
						txtDisponibilidadDiaP.setDisabled(true);
						txtDisponibilidadTotalP.setDisabled(true);
						txtValorP.setDisabled(true);
						txtProfId_ProfesionP.setDisabled(true);
						txtElemCostoId_ElementoCostoP.setDisabled(true);
						txtUdadMedId_UdadMedP.setDisabled(true);
						txtTipoRecursosProfesionId.setDisabled(true);
						txtFechaFinalP.setDisabled(true);
						txtFechaInicialP.setDisabled(true);
						btnAgregarProfP.setDisabled(true);
						txtNomProfesionP.setDisabled(false);
						txtNomUdadMedP.setDisabled(false);
						txtNomElementoCostoP.setDisabled(false);
						txtNomUdadMedE.setDisabled(false);
						txtNomElementoCostoE.setDisabled(false);
						txtNomUdadMedI.setDisabled(false);
						txtNomElementoCostoI.setDisabled(false);
						txtNomUdadMedO.setDisabled(false);
						txtNomElementoCostoPO.setDisabled(false);
						txtNomCategoriaE.setDisabled(false);
						txtNomProductoI.setDisabled(false);

					}

				}
				activeTapIndex = 0;

				setShowDialog(true);
			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public void listener_VerificarTipoTransaccion() {

		String tipoTransaccion = "";

		if (!txtClaseRecurso.getValue().equals("")) {
			tipoTransaccion = (txtClaseRecurso.getValue().toString());
			if (tipoTransaccion.equals("Productos")) {
				txtDisponibilidadDiaE.setDisabled(true);
				txtDisponibilidadTotalE.setDisabled(true);
				txtValorE.setDisabled(true);
				txtCategEquipId_CategoriaEquipo.setDisabled(true);
				txtElemCostoId_ElementoCostoE.setDisabled(true);
				txtUdadMedId_UdadMedE.setDisabled(true);
				txtTipoRecursosEquiposId.setDisabled(true);
				txtFechaFinalE.setDisabled(true);
				txtFechaInicialE.setDisabled(true);
				btnAgregarEquip.setDisabled(true);
				txtValorI.setDisabled(false);
				txtProductoId_ProductoI.setDisabled(false);
				txtElemCostoId_ElementoCostoI.setDisabled(false);
				txtUdadMedId_UdadMedI.setDisabled(false);
				txtTipoRecursosInsumosId.setDisabled(false);
				txtFechaFinalI.setDisabled(false);
				txtFechaInicialI.setDisabled(false);
				btnAgregarIns.setDisabled(false);
				txtValorO.setDisabled(true);
				// txtCodigoO.setDisabled(true);
				// txtNombreO.setDisabled(true);
				txtServicioId_Servicio.setDisabled(true);
				txtNomServicio.setDisabled(true);

				txtElemCostoId_ElementoCostoO.setDisabled(true);
				txtUdadMedId_UdadMedO.setDisabled(true);
				txtTipoRecursosOtrosId.setDisabled(true);
				txtFechaFinalO.setDisabled(true);
				txtFechaInicialO.setDisabled(true);
				btnAgregarOtrosO.setDisabled(true);
				txtDisponibilidadDiaP.setDisabled(true);
				txtDisponibilidadTotalP.setDisabled(true);
				txtValorP.setDisabled(true);
				txtProfId_ProfesionP.setDisabled(true);
				txtElemCostoId_ElementoCostoP.setDisabled(true);
				txtUdadMedId_UdadMedP.setDisabled(true);
				txtTipoRecursosProfesionId.setDisabled(true);
				txtFechaFinalP.setDisabled(true);
				txtFechaInicialP.setDisabled(true);
				btnAgregarProfP.setDisabled(true);
				txtNomProfesionP.setDisabled(false);
				txtNomUdadMedP.setDisabled(false);
				txtNomElementoCostoP.setDisabled(false);
				txtNomUdadMedE.setDisabled(false);
				txtNomElementoCostoE.setDisabled(false);
				txtNomUdadMedI.setDisabled(false);
				txtNomElementoCostoI.setDisabled(false);
				txtNomUdadMedO.setDisabled(false);
				txtNomElementoCostoPO.setDisabled(false);
				txtNomCategoriaE.setDisabled(false);
				txtNomProductoI.setDisabled(false);

			}
			if (tipoTransaccion.equals("Categoria de equipos")) {
				txtDisponibilidadDiaE.setDisabled(false);
				txtDisponibilidadTotalE.setDisabled(false);
				txtValorE.setDisabled(false);
				txtCategEquipId_CategoriaEquipo.setDisabled(false);
				txtElemCostoId_ElementoCostoE.setDisabled(false);
				txtUdadMedId_UdadMedE.setDisabled(false);
				txtTipoRecursosEquiposId.setDisabled(false);
				txtFechaFinalE.setDisabled(false);
				txtFechaInicialE.setDisabled(false);
				btnAgregarEquip.setDisabled(false);
				txtValorI.setDisabled(true);
				txtProductoId_ProductoI.setDisabled(true);
				txtElemCostoId_ElementoCostoI.setDisabled(true);
				txtUdadMedId_UdadMedI.setDisabled(true);
				txtTipoRecursosInsumosId.setDisabled(true);
				txtFechaFinalI.setDisabled(true);
				txtFechaInicialI.setDisabled(true);
				btnAgregarIns.setDisabled(true);
				txtValorO.setDisabled(true);
				// txtCodigoO.setDisabled(true);
				// txtNombreO.setDisabled(true);
				txtServicioId_Servicio.setDisabled(true);
				txtNomServicio.setDisabled(true);

				txtElemCostoId_ElementoCostoO.setDisabled(true);
				txtUdadMedId_UdadMedO.setDisabled(true);
				txtTipoRecursosOtrosId.setDisabled(true);
				txtFechaFinalO.setDisabled(true);
				txtFechaInicialO.setDisabled(true);
				btnAgregarOtrosO.setDisabled(true);
				txtDisponibilidadDiaP.setDisabled(true);
				txtDisponibilidadTotalP.setDisabled(true);
				txtValorP.setDisabled(true);
				txtProfId_ProfesionP.setDisabled(true);
				txtElemCostoId_ElementoCostoP.setDisabled(true);
				txtUdadMedId_UdadMedP.setDisabled(true);
				txtTipoRecursosProfesionId.setDisabled(true);
				txtFechaFinalP.setDisabled(true);
				txtFechaInicialP.setDisabled(true);
				btnAgregarProfP.setDisabled(true);
				txtNomProfesionP.setDisabled(false);
				txtNomUdadMedP.setDisabled(false);
				txtNomElementoCostoP.setDisabled(false);
				txtNomUdadMedE.setDisabled(false);
				txtNomElementoCostoE.setDisabled(false);
				txtNomUdadMedI.setDisabled(false);
				txtNomElementoCostoI.setDisabled(false);
				txtNomUdadMedO.setDisabled(false);
				txtNomElementoCostoPO.setDisabled(false);
				txtNomCategoriaE.setDisabled(false);
				txtNomProductoI.setDisabled(false);

			}

			if (tipoTransaccion.equals("Profesiones/Cargos")) {
				txtDisponibilidadDiaE.setDisabled(true);
				txtDisponibilidadTotalE.setDisabled(true);
				txtValorE.setDisabled(true);
				txtCategEquipId_CategoriaEquipo.setDisabled(true);
				txtElemCostoId_ElementoCostoE.setDisabled(true);
				txtUdadMedId_UdadMedE.setDisabled(true);
				txtTipoRecursosEquiposId.setDisabled(true);
				txtFechaFinalE.setDisabled(true);
				txtFechaInicialE.setDisabled(true);
				btnAgregarEquip.setDisabled(true);
				txtValorI.setDisabled(true);
				txtProductoId_ProductoI.setDisabled(true);
				txtElemCostoId_ElementoCostoI.setDisabled(true);
				txtUdadMedId_UdadMedI.setDisabled(true);
				txtTipoRecursosInsumosId.setDisabled(true);
				txtFechaFinalI.setDisabled(true);
				txtFechaInicialI.setDisabled(true);
				btnAgregarIns.setDisabled(true);
				txtValorO.setDisabled(true);
				// txtCodigoO.setDisabled(true);
				// txtNombreO.setDisabled(true);
				txtServicioId_Servicio.setDisabled(true);
				txtNomServicio.setDisabled(true);

				txtElemCostoId_ElementoCostoO.setDisabled(true);
				txtUdadMedId_UdadMedO.setDisabled(true);
				txtTipoRecursosOtrosId.setDisabled(true);
				txtFechaFinalO.setDisabled(true);
				txtFechaInicialO.setDisabled(true);
				btnAgregarOtrosO.setDisabled(true);
				txtDisponibilidadDiaP.setDisabled(false);
				txtDisponibilidadTotalP.setDisabled(false);
				txtValorP.setDisabled(false);
				txtProfId_ProfesionP.setDisabled(false);
				txtElemCostoId_ElementoCostoP.setDisabled(false);
				txtUdadMedId_UdadMedP.setDisabled(false);
				txtTipoRecursosProfesionId.setDisabled(false);
				txtFechaFinalP.setDisabled(false);
				txtFechaInicialP.setDisabled(false);
				btnAgregarProfP.setDisabled(false);
				txtNomProfesionP.setDisabled(false);
				txtNomUdadMedP.setDisabled(false);
				txtNomElementoCostoP.setDisabled(false);
				txtNomUdadMedE.setDisabled(false);
				txtNomElementoCostoE.setDisabled(false);
				txtNomUdadMedI.setDisabled(false);
				txtNomElementoCostoI.setDisabled(false);
				txtNomUdadMedO.setDisabled(false);
				txtNomElementoCostoPO.setDisabled(false);
				txtNomCategoriaE.setDisabled(false);
				txtNomProductoI.setDisabled(false);

			}
			if (tipoTransaccion.equals("Otros")) {
				txtDisponibilidadDiaE.setDisabled(true);
				txtDisponibilidadTotalE.setDisabled(true);
				txtValorE.setDisabled(true);
				txtCategEquipId_CategoriaEquipo.setDisabled(true);
				txtElemCostoId_ElementoCostoE.setDisabled(true);
				txtUdadMedId_UdadMedE.setDisabled(true);
				txtTipoRecursosEquiposId.setDisabled(true);
				txtFechaFinalE.setDisabled(true);
				txtFechaInicialE.setDisabled(true);
				btnAgregarEquip.setDisabled(true);
				txtValorI.setDisabled(true);
				txtProductoId_ProductoI.setDisabled(true);
				txtElemCostoId_ElementoCostoI.setDisabled(true);
				txtUdadMedId_UdadMedI.setDisabled(true);
				txtTipoRecursosInsumosId.setDisabled(true);
				txtFechaFinalI.setDisabled(true);
				txtFechaInicialI.setDisabled(true);
				btnAgregarIns.setDisabled(true);
				txtValorO.setDisabled(false);
				// txtCodigoO.setDisabled(false);
				// txtNombreO.setDisabled(false);
				txtServicioId_Servicio.setDisabled(false);
				txtNomServicio.setDisabled(false);

				txtElemCostoId_ElementoCostoO.setDisabled(false);
				txtUdadMedId_UdadMedO.setDisabled(false);
				txtTipoRecursosOtrosId.setDisabled(false);
				txtFechaFinalO.setDisabled(false);
				txtFechaInicialO.setDisabled(false);
				btnAgregarOtrosO.setDisabled(false);
				txtDisponibilidadDiaP.setDisabled(true);
				txtDisponibilidadTotalP.setDisabled(true);
				txtValorP.setDisabled(true);
				txtProfId_ProfesionP.setDisabled(true);
				txtElemCostoId_ElementoCostoP.setDisabled(true);
				txtUdadMedId_UdadMedP.setDisabled(true);
				txtTipoRecursosProfesionId.setDisabled(true);
				txtFechaFinalP.setDisabled(true);
				txtFechaInicialP.setDisabled(true);
				btnAgregarProfP.setDisabled(true);
				txtNomProfesionP.setDisabled(false);
				txtNomUdadMedP.setDisabled(false);
				txtNomElementoCostoP.setDisabled(false);
				txtNomUdadMedE.setDisabled(false);
				txtNomElementoCostoE.setDisabled(false);
				txtNomUdadMedI.setDisabled(false);
				txtNomElementoCostoI.setDisabled(false);
				txtNomUdadMedO.setDisabled(false);
				txtNomElementoCostoPO.setDisabled(false);
				txtNomCategoriaE.setDisabled(false);
				txtNomProductoI.setDisabled(false);

			}

		}
	}

	public String action_save() {
		try {
			if ((selectedTipoRecurso == null) && (entity == null)) {
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
			entity = new TipoRecurso();
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			// Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);

			entity.setClaseRecurso(FacesUtils.checkString(txtClaseRecurso));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setControlCosto(FacesUtils.checkString(txtControlCosto));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(date);
			// entity.setFechaModificacion(FacesUtils
			// .checkDate(txtFechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			// entity.setTpRecursoId(tpRecursoId);
			businessDelegatorView.saveTipoRecurso(entity, dataTRProfesion, dataTREquipos, dataTRInsumos, dataTROtros);
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
				Long tpRecursoId = new Long(selectedTipoRecurso.getTpRecursoId());
				entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
			}
			Date date = new Date();
			Long compania = new Long(getCompaniaIdSession());
			entity.setClaseRecurso(FacesUtils.checkString(txtClaseRecurso));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCompania(compania);
			entity.setControlCosto(FacesUtils.checkString(txtControlCosto));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(date);
			entity.setInfoAdicional(FacesUtils.checkString(txtInfoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(txtInfoAdicional2));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			businessDelegatorView.updateTipoRecurso(entity,

					dataTRProfesion, dataTREquipos, dataTRInsumos, dataTROtros);
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
			selectedTipoRecurso = (TipoRecursoDTO) (evt.getComponent().getAttributes().get("selectedTipoRecurso"));

			Long tpRecursoId = new Long(selectedTipoRecurso.getTpRecursoId());
			entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
			entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteTipoRecurso(entity);
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
			selectedTipoRecurso = (TipoRecursoDTO) (evt.getComponent().getAttributes().get("selectedTipoRecurso"));

			Long tpRecursoId = new Long(selectedTipoRecurso.getTpRecursoId());
			entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
			businessDelegatorView.deleteTipoRecurso(entity);
			data.remove(selectedTipoRecurso);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String claseRecurso, String codigo, Long compania, String controlCosto,
			String estado, Date fechaCreacion, Date fechaModificacion, String infoAdicional, String infoAdicional2,
			String nombre, Long tpRecursoId) throws Exception {
		try {
			entity.setClaseRecurso(FacesUtils.checkString(claseRecurso));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCompania(FacesUtils.checkLong(compania));
			entity.setControlCosto(FacesUtils.checkString(controlCosto));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInfoAdicional(FacesUtils.checkString(infoAdicional));
			entity.setInfoAdicional2(FacesUtils.checkString(infoAdicional2));
			entity.setNombre(FacesUtils.checkString(nombre));
			businessDelegatorView.updateTipoRecurso(entity,

					dataTRProfesion, dataTREquipos, dataTRInsumos, dataTROtros);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoRecursoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtClaseRecurso() {
		return txtClaseRecurso;
	}

	public void setTxtClaseRecurso(SelectOneMenu txtClaseRecurso) {
		this.txtClaseRecurso = txtClaseRecurso;
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

	public SelectOneRadio getTxtControlCosto() {
		return txtControlCosto;
	}

	public void setTxtControlCosto(SelectOneRadio txtControlCosto) {
		this.txtControlCosto = txtControlCosto;
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

	public InputText getTxtTpRecursoId() {
		return txtTpRecursoId;
	}

	public void setTxtTpRecursoId(InputText txtTpRecursoId) {
		this.txtTpRecursoId = txtTpRecursoId;
	}

	public List<TipoRecursoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoRecurso();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoRecursoDTO> tipoRecursoDTO) {
		this.data = tipoRecursoDTO;
	}

	public TipoRecursoDTO getSelectedTipoRecurso() {
		return selectedTipoRecurso;
	}

	public void setSelectedTipoRecurso(TipoRecursoDTO tipoRecurso) {
		this.selectedTipoRecurso = tipoRecurso;
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

	public TipoRecurso getEntity() {
		return entity;
	}

	public void setEntity(TipoRecurso entity) {
		this.entity = entity;
	}

	public List<TipoRecursosProfesionDTO> getDataTRProfesion() {
		return dataTRProfesion;
	}

	public void setDataTRProfesion(List<TipoRecursosProfesionDTO> dataTRProfesion) {
		this.dataTRProfesion = dataTRProfesion;
	}

	public List<TipoRecursosEquiposDTO> getDataTREquipos() {
		return dataTREquipos;
	}

	public void setDataTREquipos(List<TipoRecursosEquiposDTO> dataTREquipos) {
		this.dataTREquipos = dataTREquipos;
	}

	public List<TipoRecursosInsumosDTO> getDataTRInsumos() {
		return dataTRInsumos;
	}

	public void setDataTRInsumos(List<TipoRecursosInsumosDTO> dataTRInsumos) {
		this.dataTRInsumos = dataTRInsumos;
	}

	public List<TipoRecursosOtrosDTO> getDataTROtros() {
		return dataTROtros;
	}

	public void setDataTROtros(List<TipoRecursosOtrosDTO> dataTROtros) {
		this.dataTROtros = dataTROtros;
	}

	public InputText getTxtDisponibilidadDiaE() {
		return txtDisponibilidadDiaE;
	}

	public void setTxtDisponibilidadDiaE(InputText txtDisponibilidadDiaE) {
		this.txtDisponibilidadDiaE = txtDisponibilidadDiaE;
	}

	public InputText getTxtDisponibilidadTotalE() {
		return txtDisponibilidadTotalE;
	}

	public void setTxtDisponibilidadTotalE(InputText txtDisponibilidadTotalE) {
		this.txtDisponibilidadTotalE = txtDisponibilidadTotalE;
	}

	public InputText getTxtValorE() {
		return txtValorE;
	}

	public void setTxtValorE(InputText txtValorE) {
		this.txtValorE = txtValorE;
	}

	public SelectOneMenu getTxtCategEquipId_CategoriaEquipo() {
		return txtCategEquipId_CategoriaEquipo;
	}

	public void setTxtCategEquipId_CategoriaEquipo(SelectOneMenu txtCategEquipId_CategoriaEquipo) {
		this.txtCategEquipId_CategoriaEquipo = txtCategEquipId_CategoriaEquipo;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCostoE() {
		return txtElemCostoId_ElementoCostoE;
	}

	public void setTxtElemCostoId_ElementoCostoE(SelectOneMenu txtElemCostoId_ElementoCostoE) {
		this.txtElemCostoId_ElementoCostoE = txtElemCostoId_ElementoCostoE;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMedE() {
		return txtUdadMedId_UdadMedE;
	}

	public void setTxtUdadMedId_UdadMedE(SelectOneMenu txtUdadMedId_UdadMedE) {
		this.txtUdadMedId_UdadMedE = txtUdadMedId_UdadMedE;
	}

	public InputText getTxtTipoRecursosEquiposId() {
		return txtTipoRecursosEquiposId;
	}

	public void setTxtTipoRecursosEquiposId(InputText txtTipoRecursosEquiposId) {
		this.txtTipoRecursosEquiposId = txtTipoRecursosEquiposId;
	}

	public Calendar getTxtFechaFinalE() {
		return txtFechaFinalE;
	}

	public void setTxtFechaFinalE(Calendar txtFechaFinalE) {
		this.txtFechaFinalE = txtFechaFinalE;
	}

	public Calendar getTxtFechaInicialE() {
		return txtFechaInicialE;
	}

	public void setTxtFechaInicialE(Calendar txtFechaInicialE) {
		this.txtFechaInicialE = txtFechaInicialE;
	}

	public CommandButton getBtnAgregarEquip() {
		return btnAgregarEquip;
	}

	public void setBtnAgregarEquip(CommandButton btnAgregarEquip) {
		this.btnAgregarEquip = btnAgregarEquip;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCostoI() {
		return txtElemCostoId_ElementoCostoI;
	}

	public void setTxtElemCostoId_ElementoCostoI(SelectOneMenu txtElemCostoId_ElementoCostoI) {
		this.txtElemCostoId_ElementoCostoI = txtElemCostoId_ElementoCostoI;
	}

	public SelectOneMenu getTxtProductoId_ProductoI() {
		return txtProductoId_ProductoI;
	}

	public void setTxtProductoId_ProductoI(SelectOneMenu txtProductoId_ProductoI) {
		this.txtProductoId_ProductoI = txtProductoId_ProductoI;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMedI() {
		return txtUdadMedId_UdadMedI;
	}

	public void setTxtUdadMedId_UdadMedI(SelectOneMenu txtUdadMedId_UdadMedI) {
		this.txtUdadMedId_UdadMedI = txtUdadMedId_UdadMedI;
	}

	public InputText getTxtTipoRecursosInsumosId() {
		return txtTipoRecursosInsumosId;
	}

	public void setTxtTipoRecursosInsumosId(InputText txtTipoRecursosInsumosId) {
		this.txtTipoRecursosInsumosId = txtTipoRecursosInsumosId;
	}

	public Calendar getTxtFechaFinalI() {
		return txtFechaFinalI;
	}

	public void setTxtFechaFinalI(Calendar txtFechaFinalI) {
		this.txtFechaFinalI = txtFechaFinalI;
	}

	public Calendar getTxtFechaInicialI() {
		return txtFechaInicialI;
	}

	public void setTxtFechaInicialI(Calendar txtFechaInicialI) {
		this.txtFechaInicialI = txtFechaInicialI;
	}

	public CommandButton getBtnAgregarIns() {
		return btnAgregarIns;
	}

	public void setBtnAgregarIns(CommandButton btnAgregarIns) {
		this.btnAgregarIns = btnAgregarIns;
	}

	public InputText getTxtCodigoO() {
		return txtCodigoO;
	}

	public void setTxtCodigoO(InputText txtCodigoO) {
		this.txtCodigoO = txtCodigoO;
	}

	public InputText getTxtNombreO() {
		return txtNombreO;
	}

	public void setTxtNombreO(InputText txtNombreO) {
		this.txtNombreO = txtNombreO;
	}

	public InputText getTxtValorO() {
		return txtValorO;
	}

	public void setTxtValorO(InputText txtValorO) {
		this.txtValorO = txtValorO;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCostoO() {
		return txtElemCostoId_ElementoCostoO;
	}

	public void setTxtElemCostoId_ElementoCostoO(SelectOneMenu txtElemCostoId_ElementoCostoO) {
		this.txtElemCostoId_ElementoCostoO = txtElemCostoId_ElementoCostoO;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMedO() {
		return txtUdadMedId_UdadMedO;
	}

	public void setTxtUdadMedId_UdadMedO(SelectOneMenu txtUdadMedId_UdadMedO) {
		this.txtUdadMedId_UdadMedO = txtUdadMedId_UdadMedO;
	}

	public InputText getTxtTipoRecursosOtrosId() {
		return txtTipoRecursosOtrosId;
	}

	public void setTxtTipoRecursosOtrosId(InputText txtTipoRecursosOtrosId) {
		this.txtTipoRecursosOtrosId = txtTipoRecursosOtrosId;
	}

	public Calendar getTxtFechaFinalO() {
		return txtFechaFinalO;
	}

	public void setTxtFechaFinalO(Calendar txtFechaFinalO) {
		this.txtFechaFinalO = txtFechaFinalO;
	}

	public Calendar getTxtFechaInicialO() {
		return txtFechaInicialO;
	}

	public void setTxtFechaInicialO(Calendar txtFechaInicialO) {
		this.txtFechaInicialO = txtFechaInicialO;
	}

	public InputText getTxtValorI() {
		return txtValorI;
	}

	public void setTxtValorI(InputText txtValorI) {
		this.txtValorI = txtValorI;
	}

	public CommandButton getBtnAgregarOtrosO() {
		return btnAgregarOtrosO;
	}

	public void setBtnAgregarOtrosO(CommandButton btnAgregarOtrosO) {
		this.btnAgregarOtrosO = btnAgregarOtrosO;
	}

	public InputText getTxtDisponibilidadDiaP() {
		return txtDisponibilidadDiaP;
	}

	public void setTxtDisponibilidadDiaP(InputText txtDisponibilidadDiaP) {
		this.txtDisponibilidadDiaP = txtDisponibilidadDiaP;
	}

	public InputText getTxtDisponibilidadTotalP() {
		return txtDisponibilidadTotalP;
	}

	public void setTxtDisponibilidadTotalP(InputText txtDisponibilidadTotalP) {
		this.txtDisponibilidadTotalP = txtDisponibilidadTotalP;
	}

	public InputText getTxtValorP() {
		return txtValorP;
	}

	public void setTxtValorP(InputText txtValorP) {
		this.txtValorP = txtValorP;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCostoP() {
		return txtElemCostoId_ElementoCostoP;
	}

	public void setTxtElemCostoId_ElementoCostoP(SelectOneMenu txtElemCostoId_ElementoCostoP) {
		this.txtElemCostoId_ElementoCostoP = txtElemCostoId_ElementoCostoP;
	}

	public SelectOneMenu getTxtProfId_ProfesionP() {
		return txtProfId_ProfesionP;
	}

	public void setTxtProfId_ProfesionP(SelectOneMenu txtProfId_ProfesionP) {
		this.txtProfId_ProfesionP = txtProfId_ProfesionP;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMedP() {
		return txtUdadMedId_UdadMedP;
	}

	public void setTxtUdadMedId_UdadMedP(SelectOneMenu txtUdadMedId_UdadMedP) {
		this.txtUdadMedId_UdadMedP = txtUdadMedId_UdadMedP;
	}

	public InputText getTxtTipoRecursosProfesionId() {
		return txtTipoRecursosProfesionId;
	}

	public void setTxtTipoRecursosProfesionId(InputText txtTipoRecursosProfesionId) {
		this.txtTipoRecursosProfesionId = txtTipoRecursosProfesionId;
	}

	public Calendar getTxtFechaFinalP() {
		return txtFechaFinalP;
	}

	public void setTxtFechaFinalP(Calendar txtFechaFinalP) {
		this.txtFechaFinalP = txtFechaFinalP;
	}

	public Calendar getTxtFechaInicialP() {
		return txtFechaInicialP;
	}

	public void setTxtFechaInicialP(Calendar txtFechaInicialP) {
		this.txtFechaInicialP = txtFechaInicialP;
	}

	public CommandButton getBtnAgregarProfP() {
		return btnAgregarProfP;
	}

	public void setBtnAgregarProfP(CommandButton btnAgregarProfP) {
		this.btnAgregarProfP = btnAgregarProfP;
	}

	public InputText getTxtNomProfesionP() {
		return txtNomProfesionP;
	}

	public void setTxtNomProfesionP(InputText txtNomProfesionP) {
		this.txtNomProfesionP = txtNomProfesionP;
	}

	public InputText getTxtNomUdadMedP() {
		return txtNomUdadMedP;
	}

	public void setTxtNomUdadMedP(InputText txtNomUdadMedP) {
		this.txtNomUdadMedP = txtNomUdadMedP;
	}

	public InputText getTxtNomElementoCostoP() {
		return txtNomElementoCostoP;
	}

	public void setTxtNomElementoCostoP(InputText txtNomElementoCostoP) {
		this.txtNomElementoCostoP = txtNomElementoCostoP;
	}

	public InputText getTxtNomUdadMedE() {
		return txtNomUdadMedE;
	}

	public void setTxtNomUdadMedE(InputText txtNomUdadMedE) {
		this.txtNomUdadMedE = txtNomUdadMedE;
	}

	public InputText getTxtNomElementoCostoE() {
		return txtNomElementoCostoE;
	}

	public void setTxtNomElementoCostoE(InputText txtNomElementoCostoE) {
		this.txtNomElementoCostoE = txtNomElementoCostoE;
	}

	public InputText getTxtNomProductoI() {
		return txtNomProductoI;
	}

	public void setTxtNomProductoI(InputText txtNomProductoI) {
		this.txtNomProductoI = txtNomProductoI;
	}

	public InputText getTxtNomUdadMedI() {
		return txtNomUdadMedI;
	}

	public void setTxtNomUdadMedI(InputText txtNomUdadMedI) {
		this.txtNomUdadMedI = txtNomUdadMedI;
	}

	public InputText getTxtNomElementoCostoI() {
		return txtNomElementoCostoI;
	}

	public void setTxtNomElementoCostoI(InputText txtNomElementoCostoI) {
		this.txtNomElementoCostoI = txtNomElementoCostoI;
	}

	public InputText getTxtNomUdadMedO() {
		return txtNomUdadMedO;
	}

	public void setTxtNomUdadMedO(InputText txtNomUdadMedO) {
		this.txtNomUdadMedO = txtNomUdadMedO;
	}

	public InputText getTxtNomElementoCostoPO() {
		return txtNomElementoCostoPO;
	}

	public void setTxtNomElementoCostoPO(InputText txtNomElementoCostoPO) {
		this.txtNomElementoCostoPO = txtNomElementoCostoPO;
	}

	public List<TipoRecursosProfesionDTO> getDataTPRecursosProfesion() {

		if (dataTRProfesion == null || dataTRProfesion.size() == 0) {
			return null;
		} else {
			return dataTRProfesion;
		}

	}

	public void action_agregarTipoRecursoProfesion() throws Exception {

		if (txtFechaInicialP.getValue() != null && txtFechaFinalP.getValue() != null
				&& txtProfId_ProfesionP.getValue() != null && txtUdadMedId_UdadMedP.getValue() != null
				&& txtElemCostoId_ElementoCostoP.getValue() != null && txtValorP.getValue() != null) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicialP));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinalP));
			// Long tipoRecurso = Long.parseLong(txtTpRecursoId.getValue()
			// .toString());
			Long profesionId = Long.parseLong(txtProfId_ProfesionP.getValue().toString());
			Profesion profesion = businessDelegatorView.getProfesion(profesionId);
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMedP.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			Long elementoCosto = Long.parseLong(txtElemCostoId_ElementoCostoP.getValue().toString());
			ElementoCosto elementoCostoId = businessDelegatorView.getElementoCosto(elementoCosto);
			String nomProfesion = FacesUtils.checkString(txtNomProfesionP);
			String nomUdadMed = FacesUtils.checkString(txtNomUdadMedP);
			String nomElementoCosto = FacesUtils.checkString(txtNomElementoCostoP);
			Double valorUnit = FacesUtils.checkDouble(txtValorP);
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();
			Double disponibilidadDia = FacesUtils.checkDouble(txtDisponibilidadDiaP);
			Double disponibilidadDiaTotal = FacesUtils.checkDouble(txtDisponibilidadTotalP);
			boolean existeProducto = false;

			if (dataTRProfesion == null) {
				dataTRProfesion = new ArrayList<TipoRecursosProfesionDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataTRProfesion.size() > 0) {

				for (TipoRecursosProfesionDTO d : dataTRProfesion) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getElemCostoId_ElementoCosto().getElemCostoId().longValue() == elementoCostoId
									.getElemCostoId().longValue()
							&& d.getProfId_Profesion().getProfId().longValue() == profesion.getProfId().longValue()
							&& d.getUdadMedId_UdadMed().getUdadMedId().longValue() == udadMed.getUdadMedId()
									.longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Upps!", "Ya éxiste una tarifa para el recurso en este rango de tiempo "
										+ "Verifie el periódo, labor, concepto, unidad de médida, profesión. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				TipoRecursosProfesionDTO tipoRecursosProfesionDTO = new TipoRecursosProfesionDTO();
				tipoRecursosProfesionDTO.setFechaInicial(fechaInicial);
				tipoRecursosProfesionDTO.setFechaFinal(fechaFinal);
				tipoRecursosProfesionDTO.setElemCostoId_ElementoCosto(elementoCostoId);
				tipoRecursosProfesionDTO.setUdadMedId_UdadMed(udadMed);
				// tipoRecursosProfesionDTO.setTpRecursoId_TipoRecurso(tipoRecurso);
				tipoRecursosProfesionDTO.setProfId_Profesion(profesion);
				tipoRecursosProfesionDTO.setValor(valorUnit);
				tipoRecursosProfesionDTO.setDisponibilidadDia(disponibilidadDia);
				tipoRecursosProfesionDTO.setDisponibilidadTotal(disponibilidadDiaTotal);
				;
				tipoRecursosProfesionDTO.setNombreElemCosto(nomElementoCosto);
				tipoRecursosProfesionDTO.setNombreProfesion(nomProfesion);
				tipoRecursosProfesionDTO.setNombreUm(nomUdadMed);
				tipoRecursosProfesionDTO.setFechaCreacion(fechaCreacion);
				tipoRecursosProfesionDTO.setFechaModificacion(fechaModificacion);

				dataTRProfesion.add(tipoRecursosProfesionDTO);

			}
			fechaInicial = null;
			fechaFinal = null;
			profesion = null;
			elementoCostoId = null;
			udadMed = null;
			valorUnit = null;
			nomElementoCosto = null;
			nomProfesion = null;
			nomUdadMed = null;
			disponibilidadDia = null;
			disponibilidadDiaTotal = null;
			fechaCreacion = null;
			fechaModificacion = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final,  profesión, unidad de mèdida y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodProfesion() {

		Long profesionId = null;

		if (!txtProfId_ProfesionP.getValue().equals("")) {
			profesionId = Long.parseLong(txtProfId_ProfesionP.getValue().toString());

			try {
				Profesion profesion = businessDelegatorView.getProfesion(profesionId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomProfesionP.setValue(profesion.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMedProfesion() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMedP.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMedP.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomUdadMedP.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodElemCostoProfesion() {

		Long elemCostoId = null;

		if (!txtElemCostoId_ElementoCostoP.getValue().equals("")) {
			elemCostoId = Long.parseLong(txtElemCostoId_ElementoCostoP.getValue().toString());

			try {

				ElementoCosto elemCosto = businessDelegatorView.getElementoCosto(elemCostoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomElementoCostoP.setValue(elemCosto.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	/*****************************************************/

	public List<TipoRecursosEquiposDTO> getDataTPRecursosEquipos() {

		if (dataTREquipos == null || dataTREquipos.size() == 0) {
			return null;
		} else {
			return dataTREquipos;
		}

	}

	public void action_agregarTipoRecursoEquipos() throws Exception {

		if (txtFechaInicialE.getValue() != null && txtFechaFinalE.getValue() != null
				&& txtCategEquipId_CategoriaEquipo.getValue() != null && txtUdadMedId_UdadMedE.getValue() != null
				&& txtElemCostoId_ElementoCostoE.getValue() != null && txtValorE.getValue() != null) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicialE));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinalE));
			// Long tipoRecurso = Long.parseLong(txtTpRecursoId.getValue()
			// .toString());
			Long categoriaId = Long.parseLong(txtCategEquipId_CategoriaEquipo.getValue().toString());
			CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMedE.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			Long elementoCosto = Long.parseLong(txtElemCostoId_ElementoCostoE.getValue().toString());
			ElementoCosto elementoCostoId = businessDelegatorView.getElementoCosto(elementoCosto);
			String nomEquipos = FacesUtils.checkString(txtNomCategoriaE);
			String nomUdadMed = FacesUtils.checkString(txtNomUdadMedE);
			String nomElementoCosto = FacesUtils.checkString(txtNomElementoCostoE);
			Double valorUnit = FacesUtils.checkDouble(txtValorE);
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();
			Double disponibilidadDia = FacesUtils.checkDouble(txtDisponibilidadDiaE);
			Double disponibilidadDiaTotal = FacesUtils.checkDouble(txtDisponibilidadTotalE);
			boolean existeProducto = false;

			if (dataTREquipos == null) {
				dataTREquipos = new ArrayList<TipoRecursosEquiposDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataTREquipos.size() > 0) {

				for (TipoRecursosEquiposDTO d : dataTREquipos) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getElemCostoId_ElementoCosto().getElemCostoId().longValue() == elementoCostoId
									.getElemCostoId().longValue()
							&& d.getCategEquipId_CategoriaEquipo().getCategEquipId().longValue() == categoria
									.getCategEquipId().longValue()
							&& d.getUdadMedId_UdadMed().getUdadMedId().longValue() == udadMed.getUdadMedId()
									.longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"Ya éxiste una tarifa para el recurso en este rango de tiempo "
												+ "Verifie el periódo, la categoria, unidad de médida. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				TipoRecursosEquiposDTO tipoRecursosEquiposDTO = new TipoRecursosEquiposDTO();
				tipoRecursosEquiposDTO.setFechaInicial(fechaInicial);
				tipoRecursosEquiposDTO.setFechaFinal(fechaFinal);
				tipoRecursosEquiposDTO.setElemCostoId_ElementoCosto(elementoCostoId);
				tipoRecursosEquiposDTO.setUdadMedId_UdadMed(udadMed);
				// tipoRecursosEquiposDTO.setTpRecursoId_TipoRecurso(tipoRecurso);
				tipoRecursosEquiposDTO.setCategEquipId_CategoriaEquipo(categoria);
				tipoRecursosEquiposDTO.setValor(valorUnit);
				tipoRecursosEquiposDTO.setDisponibilidadDia(disponibilidadDia);
				tipoRecursosEquiposDTO.setDisponibilidadTotal(disponibilidadDiaTotal);
				;
				tipoRecursosEquiposDTO.setNombreElemCosto(nomElementoCosto);
				tipoRecursosEquiposDTO.setNombreCategoria(nomEquipos);
				tipoRecursosEquiposDTO.setNombreUm(nomUdadMed);
				tipoRecursosEquiposDTO.setFechaCreacion(fechaCreacion);
				tipoRecursosEquiposDTO.setFechaModificacion(fechaModificacion);

				dataTREquipos.add(tipoRecursosEquiposDTO);

			}
			fechaInicial = null;
			fechaFinal = null;
			categoria = null;
			elementoCostoId = null;
			udadMed = null;
			valorUnit = null;
			nomElementoCosto = null;
			nomEquipos = null;
			nomUdadMed = null;
			disponibilidadDia = null;
			disponibilidadDiaTotal = null;
			fechaCreacion = null;
			fechaModificacion = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final,  categoria, unidad de mèdida y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodCategoria() {

		Long categoriaId = null;

		if (!txtCategEquipId_CategoriaEquipo.getValue().equals("")) {
			categoriaId = Long.parseLong(txtCategEquipId_CategoriaEquipo.getValue().toString());

			try {
				CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomCategoriaE.setValue(categoria.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMedCategoria() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMedE.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMedE.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomUdadMedE.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodElemCostoCategoria() {

		Long elemCostoId = null;

		if (!txtElemCostoId_ElementoCostoE.getValue().equals("")) {
			elemCostoId = Long.parseLong(txtElemCostoId_ElementoCostoE.getValue().toString());

			try {

				ElementoCosto elemCosto = businessDelegatorView.getElementoCosto(elemCostoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomElementoCostoE.setValue(elemCosto.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	/******************************************************************/
	public List<TipoRecursosInsumosDTO> getDataTPRecursosInsumos() {

		if (dataTRInsumos == null || dataTRInsumos.size() == 0) {
			return null;
		} else {
			return dataTRInsumos;
		}

	}

	public void action_agregarTipoRecursoInsumos() throws Exception {

		if (txtFechaInicialI.getValue() != null && txtFechaFinalI.getValue() != null
				&& txtProductoId_ProductoI.getValue() != null && txtUdadMedId_UdadMedI.getValue() != null
				&& txtElemCostoId_ElementoCostoI.getValue() != null && txtValorI.getValue() != null) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicialI));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinalI));
			// Long tipoRecurso = Long.parseLong(txtTpRecursoId.getValue()
			// .toString());
			Long productoId = Long.parseLong(txtProductoId_ProductoI.getValue().toString());
			Producto producto = businessDelegatorView.getProducto(productoId);
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMedI.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			Long elementoCosto = Long.parseLong(txtElemCostoId_ElementoCostoI.getValue().toString());
			ElementoCosto elementoCostoId = businessDelegatorView.getElementoCosto(elementoCosto);
			String nomInsumos = FacesUtils.checkString(txtNomProductoI);
			String nomUdadMed = FacesUtils.checkString(txtNomUdadMedI);
			String nomElementoCosto = FacesUtils.checkString(txtNomElementoCostoI);
			Double valorUnit = FacesUtils.checkDouble(txtValorI);
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();

			boolean existeProducto = false;

			if (dataTRInsumos == null) {
				dataTRInsumos = new ArrayList<TipoRecursosInsumosDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataTRInsumos.size() > 0) {

				for (TipoRecursosInsumosDTO d : dataTRInsumos) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getElemCostoId_ElementoCosto().getElemCostoId().longValue() == elementoCostoId
									.getElemCostoId().longValue()
							&& d.getProductoId_Producto().getProductoId().longValue() == producto.getProductoId()
									.longValue()
							&& d.getUdadMedId_UdadMed().getUdadMedId().longValue() == udadMed.getUdadMedId()
									.longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"Ya éxiste una tarifa para el recurso en este rango de tiempo "
												+ "Verifie el periódo, el producto, unidad de médida. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				TipoRecursosInsumosDTO tipoRecursosInsumosDTO = new TipoRecursosInsumosDTO();
				tipoRecursosInsumosDTO.setFechaInicial(fechaInicial);
				tipoRecursosInsumosDTO.setFechaFinal(fechaFinal);
				tipoRecursosInsumosDTO.setElemCostoId_ElementoCosto(elementoCostoId);
				tipoRecursosInsumosDTO.setUdadMedId_UdadMed(udadMed);
				// tipoRecursosInsumosDTO.setTpRecursoId_TipoRecurso(tipoRecurso);
				tipoRecursosInsumosDTO.setProductoId_Producto(producto);
				tipoRecursosInsumosDTO.setValor(valorUnit);
				tipoRecursosInsumosDTO.setNombreElemCosto(nomElementoCosto);
				tipoRecursosInsumosDTO.setNombreProducto(nomInsumos);
				tipoRecursosInsumosDTO.setNombreUm(nomUdadMed);
				tipoRecursosInsumosDTO.setFechaCreacion(fechaCreacion);
				tipoRecursosInsumosDTO.setFechaModificacion(fechaModificacion);

				dataTRInsumos.add(tipoRecursosInsumosDTO);

			}
			fechaInicial = null;
			fechaFinal = null;
			producto = null;
			elementoCostoId = null;
			udadMed = null;
			valorUnit = null;
			nomElementoCosto = null;
			nomInsumos = null;
			nomUdadMed = null;
			fechaCreacion = null;
			fechaModificacion = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final,  producto, unidad de mèdida y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodProducto() {

		Long productoId = null;

		if (!txtProductoId_ProductoI.getValue().equals("")) {
			productoId = Long.parseLong(txtProductoId_ProductoI.getValue().toString());

			try {
				Producto producto = businessDelegatorView.getProducto(productoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomProductoI.setValue(producto.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMedProducto() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMedI.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMedI.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomUdadMedI.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodElemCostoProducto() {

		Long elemCostoId = null;

		if (!txtElemCostoId_ElementoCostoI.getValue().equals("")) {
			elemCostoId = Long.parseLong(txtElemCostoId_ElementoCostoI.getValue().toString());

			try {
				ElementoCosto elemCosto = businessDelegatorView.getElementoCosto(elemCostoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomElementoCostoI.setValue(elemCosto.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	/************************************************************************************************/

	public List<TipoRecursosOtrosDTO> getDataTPRecursosOtros() {

		if (dataTROtros == null || dataTROtros.size() == 0) {
			return null;
		} else {
			return dataTROtros;
		}

	}

	public void action_agregarTipoRecursoOtros() throws Exception {

		if (txtFechaInicialO.getValue() != null && txtFechaFinalO.getValue() != null
				&& txtServicioId_Servicio.getValue() != null && txtUdadMedId_UdadMedO.getValue() != null
				&& txtElemCostoId_ElementoCostoO.getValue() != null && txtValorO.getValue() != null) {

			Date fechaInicial = (FacesUtils.checkDate(txtFechaInicialO));
			Date fechaFinal = (FacesUtils.checkDate(txtFechaFinalO));
			// Long tipoRecurso = Long.parseLong(txtTpRecursoId.getValue()
			// .toString());
			Long udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMedO.getValue().toString());
			UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			Long elementoCosto = Long.parseLong(txtElemCostoId_ElementoCostoO.getValue().toString());
			ElementoCosto elementoCostoId = businessDelegatorView.getElementoCosto(elementoCosto);

			Long servicio = Long.parseLong(txtServicioId_Servicio.getValue().toString());
			Servicio servicioId = businessDelegatorView.getServicio(servicio);
			String nombreServicio = FacesUtils.checkString(txtNomServicio);

			// String codigoO = FacesUtils.checkString(txtCodigoO);
			// String nombreO = FacesUtils.checkString(txtNombreO);

			String nomUdadMed = FacesUtils.checkString(txtNomUdadMedO);
			String nomElementoCosto = FacesUtils.checkString(txtNomElementoCostoPO);
			Double valorUnit = FacesUtils.checkDouble(txtValorO);
			Date fechaCreacion = new Date();
			Date fechaModificacion = new Date();

			boolean existeProducto = false;

			if (dataTROtros == null) {
				dataTROtros = new ArrayList<TipoRecursosOtrosDTO>();
			}

			// if(dataTarifaContratista.size() > 0){
			if (dataTROtros.size() > 0) {

				for (TipoRecursosOtrosDTO d : dataTROtros) {

					if (d.getFechaInicial() == fechaInicial && d.getFechaFinal() == fechaFinal
							&& d.getElemCostoId_ElementoCosto().getElemCostoId().longValue() == elementoCostoId
									.getElemCostoId().longValue()
							&& d.getServicioId().getServicioId().longValue() == servicioId.getServicioId().longValue()
							&& d.getUdadMedId_UdadMed().getUdadMedId().longValue() == udadMed.getUdadMedId()
									.longValue()) {

						existeProducto = true;

						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
										"Ya éxiste una tarifa para el recurso en este rango de tiempo "
												+ "Verifie el periódo, elemento de costo, unidad de médida. "));

						break;
					}
				}

			}

			if (existeProducto == false) {

				TipoRecursosOtrosDTO tipoRecursosOtrosDTO = new TipoRecursosOtrosDTO();
				tipoRecursosOtrosDTO.setFechaInicial(fechaInicial);
				tipoRecursosOtrosDTO.setFechaFinal(fechaFinal);
				tipoRecursosOtrosDTO.setElemCostoId_ElementoCosto(elementoCostoId);
				tipoRecursosOtrosDTO.setUdadMedId_UdadMed(udadMed);
				// tipoRecursosOtrosDTO.setTpRecursoId_TipoRecurso(tipoRecurso);
				tipoRecursosOtrosDTO.setValor(valorUnit);
				tipoRecursosOtrosDTO.setNombreElemCosto(nomElementoCosto);
				tipoRecursosOtrosDTO.setServicioId(servicioId);
				tipoRecursosOtrosDTO.setNombreServicio(nombreServicio);
				tipoRecursosOtrosDTO.setNombreUm(nomUdadMed);
				tipoRecursosOtrosDTO.setFechaCreacion(fechaCreacion);
				tipoRecursosOtrosDTO.setFechaModificacion(fechaModificacion);

				dataTROtros.add(tipoRecursosOtrosDTO);

			}
			fechaInicial = null;
			fechaFinal = null;
			nombreServicio = null;
			servicioId = null;
			elementoCostoId = null;
			udadMed = null;
			valorUnit = null;
			nomElementoCosto = null;
			nomUdadMed = null;
			fechaCreacion = null;
			fechaModificacion = null;

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!",
					"Verifique que los campos fecha inicial, fecha final,  Otro recursos, unidad de mèdida y tarifa tengan valores. "));
		}
	}

	public void listener_ConsultaCodServicioOtros() {

		Long servicioId = null;

		if (!txtServicioId_Servicio.getValue().equals("")) {
			servicioId = Long.parseLong(txtServicioId_Servicio.getValue().toString());

			try {
				Servicio servicio = businessDelegatorView.getServicio(servicioId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomServicio.setValue(servicio.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodUdadMedOtros() {

		Long udadMedId = null;

		if (!txtUdadMedId_UdadMedO.getValue().equals("")) {
			udadMedId = Long.parseLong(txtUdadMedId_UdadMedO.getValue().toString());

			try {
				UdadMed udadMed = businessDelegatorView.getUdadMed(udadMedId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomUdadMedO.setValue(udadMed.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	public void listener_ConsultaCodElemCostoOtros() {

		Long elemCostoId = null;

		if (!txtElemCostoId_ElementoCostoO.getValue().equals("")) {
			elemCostoId = Long.parseLong(txtElemCostoId_ElementoCostoO.getValue().toString());

			try {
				ElementoCosto elemCosto = businessDelegatorView.getElementoCosto(elemCostoId);
				/* valNPass = datPlanLabor.getNPases(); */
				txtNomElementoCostoPO.setValue(elemCosto.getNombre());

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}

		}

	}

	/*************************** +METODOS DE BORRADO DE LOS DTO ******/

	public String actionDeleteTipoRecursosProfesion(ActionEvent evt) {
		try {

			selectedTRProfesion = (TipoRecursosProfesionDTO) (evt.getComponent().getAttributes()
					.get("selectedTRProfesion"));

			if (selectedTRProfesion.getTipoRecursosProfesionId() == null) {
				dataTRProfesion.remove(selectedTRProfesion);
			} else {
				Long tprprofesionId = new Long(selectedTRProfesion.getTipoRecursosProfesionId());
				TipoRecursosProfesion entity = businessDelegatorView.getTipoRecursosProfesion(tprprofesionId);
				businessDelegatorView.deleteTipoRecursosProfesion(entity);
				dataTRProfesion.remove(selectedTRProfesion);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteTipoRecursosEquipos(ActionEvent evt) {
		try {

			selectedTREquipos = (TipoRecursosEquiposDTO) (evt.getComponent().getAttributes().get("selectedTREquipos"));

			if (selectedTREquipos.getTipoRecursosEquiposId() == null) {
				dataTREquipos.remove(selectedTREquipos);
			} else {
				Long tprequiposId = new Long(selectedTREquipos.getTipoRecursosEquiposId());
				TipoRecursosEquipos entity = businessDelegatorView.getTipoRecursosEquipos(tprequiposId);
				businessDelegatorView.deleteTipoRecursosEquipos(entity);
				dataTREquipos.remove(selectedTREquipos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteTipoRecursosInsumos(ActionEvent evt) {
		try {

			selectedTRInsumos = (TipoRecursosInsumosDTO) (evt.getComponent().getAttributes().get("selectedTRInsumos"));

			if (selectedTRInsumos.getTipoRecursosInsumosId() == null) {
				dataTRInsumos.remove(selectedTRInsumos);
			} else {
				Long tprinsumosId = new Long(selectedTRInsumos.getTipoRecursosInsumosId());
				TipoRecursosInsumos entity = businessDelegatorView.getTipoRecursosInsumos(tprinsumosId);
				businessDelegatorView.deleteTipoRecursosInsumos(entity);
				dataTRInsumos.remove(selectedTRInsumos);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String actionDeleteTipoRecursosOtros(ActionEvent evt) {
		try {

			selectedTROtros = (TipoRecursosOtrosDTO) (evt.getComponent().getAttributes().get("selectedTROtros"));

			if (selectedTROtros.getTipoRecursosOtrosId() == null) {
				dataTROtros.remove(selectedTROtros);
			} else {
				Long tprotrosId = new Long(selectedTROtros.getTipoRecursosOtrosId());
				TipoRecursosOtros entity = businessDelegatorView.getTipoRecursosOtros(tprotrosId);
				businessDelegatorView.deleteTipoRecursosOtros(entity);
				dataTROtros.remove(selectedTROtros);
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	public void onCellEditProfesion(CellEditEvent event) throws Exception {

		selectedTRProfesion = (TipoRecursosProfesionDTO) (event.getComponent().getAttributes()
				.get("selectedTRProfesion"));
		
		if (selectedTRProfesion.getTipoRecursosProfesionId() != null) {

			Long tipoRecursosProfesionId = selectedTRProfesion.getTipoRecursosProfesionId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTipoRecursosProfesion = null;
				Date fechaModificacion = new Date();
	
				entityTipoRecursosProfesion = businessDelegatorView.getTipoRecursosProfesion(tipoRecursosProfesionId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityTipoRecursosProfesion.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityTipoRecursosProfesion.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Recurso")) {
	
					Long ProfesionId = new Long(event.getNewValue().toString());
					Profesion Profesion = businessDelegatorView.getProfesion(ProfesionId);
	
					entityTipoRecursosProfesion.setProfesion(Profesion);
	
				} else if (columnaCell.equals("UM")) {
	
					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);
	
					entityTipoRecursosProfesion.setUdadMed(udadMed);
	
				} else if (columnaCell.equals("El. Costo")) {
	
					Long elementoCosto = new Long(event.getNewValue().toString());
					ElementoCosto ElementoCosto = businessDelegatorView.getElementoCosto(elementoCosto);
	
					entityTipoRecursosProfesion.setElementoCosto(ElementoCosto);
	
				} else if (columnaCell.equals("Valor")) {
	
					entityTipoRecursosProfesion.setValor((Double) newValue);
	
				} else if (columnaCell.equals("Rec.(Día)")) {
	
					entityTipoRecursosProfesion.setDisponibilidadDia((Double) newValue);
	
				} else if (columnaCell.equals("Rec. Total")) {
	
					entityTipoRecursosProfesion.setDisponibilidadTotal((Double) newValue);
	
				}
	
				entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
				entityTipoRecursosProfesion.setTipoRecurso(entity);
				entityTipoRecursosProfesion.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTipoRecursosProfesion(entityTipoRecursosProfesion);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataTRProfesion = null;
				entityTipoRecursosProfesion = null;
				selectedTRProfesion = null;
				entity = null;
	
				dataTRProfesion = businessDelegatorView.getDataTipoRecursosProfesionByProfesion(tpRecursoId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}		

	}
	
	public void onCellEditMaterialProducto(CellEditEvent event) throws Exception {
		selectedTRInsumos = (TipoRecursosInsumosDTO) (event.getComponent().getAttributes()
				.get("selectedTRInsumos"));
		
		if (selectedTRInsumos.getTipoRecursosInsumosId() != null) {

			Long tipoRecursosInsumosId = selectedTRInsumos.getTipoRecursosInsumosId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTipoRecursosInsumos = null;
				Date fechaModificacion = new Date();
	
				entityTipoRecursosInsumos = businessDelegatorView.getTipoRecursosInsumos(tipoRecursosInsumosId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityTipoRecursosInsumos.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityTipoRecursosInsumos.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Recurso")) {
	
					Long productoId = new Long(event.getNewValue().toString());
					Producto Producto = businessDelegatorView.getProducto(productoId);
	
					entityTipoRecursosInsumos.setProducto(Producto);
	
				} else if (columnaCell.equals("UM")) {
	
					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);
	
					entityTipoRecursosInsumos.setUdadMed(udadMed);
	
				} else if (columnaCell.equals("El. Costo")) {
	
					Long elementoCosto = new Long(event.getNewValue().toString());
					ElementoCosto ElementoCosto = businessDelegatorView.getElementoCosto(elementoCosto);
	
					entityTipoRecursosInsumos.setElementoCosto(ElementoCosto);
	
				} else if (columnaCell.equals("Valor")) {
	
					entityTipoRecursosInsumos.setValor((Double) newValue);
				}
	
				entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
				entityTipoRecursosInsumos.setTipoRecurso(entity);
				entityTipoRecursosInsumos.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTipoRecursosInsumos(entityTipoRecursosInsumos);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
					" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
				dataTRInsumos = null;
				entityTipoRecursosInsumos = null;
				selectedTRInsumos = null;
				entity = null;
	
				dataTRInsumos = businessDelegatorView.getDataTipoRecursosInsumosByInsumos(tpRecursoId);
					
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}

	}
	
	public void onCellEditEquipos(CellEditEvent event) throws Exception {

		selectedTREquipos = (TipoRecursosEquiposDTO) (event.getComponent().getAttributes()
				.get("selectedTREquipos"));
		
		if (selectedTREquipos.getTipoRecursosEquiposId() != null) {

			Long tipoRecursosEquiposId = selectedTREquipos.getTipoRecursosEquiposId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTipoRecursosEquipos = null;
				Date fechaModificacion = new Date();
	
				entityTipoRecursosEquipos = businessDelegatorView.getTipoRecursosEquipos(tipoRecursosEquiposId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityTipoRecursosEquipos.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityTipoRecursosEquipos.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Recurso")) {
	
					Long categEquipId = new Long(event.getNewValue().toString());
					CategoriaEquipo CategoriaEquipo = businessDelegatorView.getCategoriaEquipo(categEquipId);
	
					entityTipoRecursosEquipos.setCategoriaEquipo(CategoriaEquipo);
	
				} else if (columnaCell.equals("UM")) {
	
					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);
	
					entityTipoRecursosEquipos.setUdadMed(udadMed);
	
				} else if (columnaCell.equals("El. Costo")) {
	
					Long elementoCosto = new Long(event.getNewValue().toString());
					ElementoCosto ElementoCosto = businessDelegatorView.getElementoCosto(elementoCosto);
	
					entityTipoRecursosEquipos.setElementoCosto(ElementoCosto);
	
				} else if (columnaCell.equals("Valor")) {
	
					entityTipoRecursosEquipos.setValor((Double) newValue);
	
				} else if (columnaCell.equals("Rec.(Día)")) {
	
					entityTipoRecursosEquipos.setDisponibilidadDia((Double) newValue);
	
				} else if (columnaCell.equals("Rec. Total")) {
	
					entityTipoRecursosEquipos.setDisponibilidadTotal((Double) newValue);
	
				}
	
				entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
				entityTipoRecursosEquipos.setTipoRecurso(entity);
				entityTipoRecursosEquipos.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTipoRecursosEquipos(entityTipoRecursosEquipos);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataTREquipos = null;
				entityTipoRecursosEquipos = null;
				selectedTREquipos = null;
				entity = null;
	
				dataTREquipos = businessDelegatorView.getDataTipoRecursosEquiposByEquipos(tpRecursoId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}	

	}
	
	public void onCellEditOtros(CellEditEvent event) throws Exception {

		selectedTROtros = (TipoRecursosOtrosDTO) (event.getComponent().getAttributes()
				.get("selectedTROtros"));
		
		if (selectedTROtros.getTipoRecursosOtrosId() != null) {

			Long tipoRecursosOtrosId = selectedTROtros.getTipoRecursosOtrosId().longValue();
			String columnaCell = event.getColumn().getHeaderText();
			Long tpRecursoId = FacesUtils.checkLong(txtTpRecursoId);
	
			Object oldValue = event.getOldValue();
			Object newValue = event.getNewValue();
	
			if (newValue != null && !newValue.equals(oldValue)) {
	
				entityTipoRecursosOtros = null;
				Date fechaModificacion = new Date();
	
				entityTipoRecursosOtros = businessDelegatorView.getTipoRecursosOtros(tipoRecursosOtrosId);
	
				if (columnaCell.equals("Fecha inicial")) {
	
					entityTipoRecursosOtros.setFechaInicial((Date) newValue);
	
				} else if (columnaCell.equals("Fecha final")) {
	
					entityTipoRecursosOtros.setFechaFinal((Date) newValue);
	
				} else if (columnaCell.equals("Recurso:")) {
	
					Long servicioId = new Long(event.getNewValue().toString());
					Servicio Servicio = businessDelegatorView.getServicio(servicioId);
	
					entityTipoRecursosOtros.setServicioId(Servicio);
	
				} else if (columnaCell.equals("UM")) {
	
					Long UdadMedId = new Long(event.getNewValue().toString());
					UdadMed udadMed = businessDelegatorView.getUdadMed(UdadMedId);
	
					entityTipoRecursosOtros.setUdadMed(udadMed);
	
				} else if (columnaCell.equals("El. Costo")) {
	
					Long elementoCosto = new Long(event.getNewValue().toString());
					ElementoCosto ElementoCosto = businessDelegatorView.getElementoCosto(elementoCosto);
	
					entityTipoRecursosOtros.setElementoCosto(ElementoCosto);
	
				} else if (columnaCell.equals("Valor")) {
	
					entityTipoRecursosOtros.setValor((Double) newValue);
	
				}
	
				entity = businessDelegatorView.getTipoRecurso(tpRecursoId);
				entityTipoRecursosOtros.setTipoRecurso(entity);
				entityTipoRecursosOtros.setFechaModificacion(fechaModificacion);
				businessDelegatorView.updateTipoRecursosOtros(entityTipoRecursosOtros);
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La columna seleccionda : " + columnaCell + "  ha sido modificada con éxito ",
						" valor actual: " + oldValue + ", nuevo valor: " + newValue);
				FacesContext.getCurrentInstance().addMessage(null, msg);
	
				dataTROtros = null;
				entityTipoRecursosOtros = null;
				selectedTROtros = null;
				entity = null;
	
				dataTROtros = businessDelegatorView.getDataTipoRecursosOtrosByOtros(tpRecursoId);
	
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Upps!!",
					"Para poder editar la columna debe grabar primero el registro"));
		}		

	}


	public SelectItem[] getSelectItempProfesion() {

		if (profesion == null || profesion.size() == 0) {

			profesion = new ArrayList<Profesion>();

			try {

				profesion = businessDelegatorView.getProfesion(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Profesion> lista = businessDelegatorView.findByCriteriaInProfesion(condicion, null, null);
				selectItempProfesion = new SelectItem[lista.size()];

				int i = 0;
				for (Profesion p : lista) {
					selectItempProfesion[i] = new SelectItem(p.getProfId(), p.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItempProfesion;
	}

	public void setSelectItempProfesion(SelectItem[] selectItempProfesion) {
		this.selectItempProfesion = selectItempProfesion;
	}

	public SelectItem[] getSelectItemUdadMedP() {

		if (udadMedP == null || udadMedP.size() == 0) {

			udadMedP = new ArrayList<UdadMed>();

			try {

				udadMedP = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectItemUdadMedP = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectItemUdadMedP[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemUdadMedP;
	}

	public void setSelectItemUdadMedP(SelectItem[] selectItemUdadMedP) {
		this.selectItemUdadMedP = selectItemUdadMedP;
	}

	public SelectItem[] getSelectItemElemCostoP() {

		if (elemCostoP == null || elemCostoP.size() == 0) {

			elemCostoP = new ArrayList<ElementoCosto>();

			try {

				elemCostoP = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectItemElemCostoP = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectItemElemCostoP[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemElemCostoP;
	}

	public void setSelectItemElemCostoP(SelectItem[] selectItemElemCostoP) {
		this.selectItemElemCostoP = selectItemElemCostoP;
	}

	/************************ Equipos *****/

	public SelectItem[] getSelectItemCategoriaEquipo() {

		if (categoriaEquipo == null || categoriaEquipo.size() == 0) {

			categoriaEquipo = new ArrayList<CategoriaEquipo>();

			try {

				categoriaEquipo = businessDelegatorView.getCategoriaEquipo(); // Fin
																				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CategoriaEquipo> lista = businessDelegatorView.findByCriteriaInCategoriaEquipo(condicion, null,
						null);
				selectItemCategoriaEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (CategoriaEquipo p : lista) {
					selectItemCategoriaEquipo[i] = new SelectItem(p.getCategEquipId(), p.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemCategoriaEquipo;
	}

	public void setSelectItemCategoriaEquipo(SelectItem[] selectItemCategoriaEquipo) {
		this.selectItemCategoriaEquipo = selectItemCategoriaEquipo;
	}

	public SelectItem[] getSelectItemUdadMedE() {

		if (udadMedE == null || udadMedE.size() == 0) {

			udadMedE = new ArrayList<UdadMed>();

			try {

				udadMedE = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectItemUdadMedE = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectItemUdadMedE[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemUdadMedE;
	}

	public void setSelectItemUdadMedE(SelectItem[] selectItemUdadMedE) {
		this.selectItemUdadMedE = selectItemUdadMedE;
	}

	public SelectItem[] getSelectItemElemCostoE() {

		if (elemCostoE == null || elemCostoE.size() == 0) {

			elemCostoE = new ArrayList<ElementoCosto>();

			try {

				elemCostoE = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectItemElemCostoE = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectItemElemCostoE[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemElemCostoE;
	}

	public void setSelectItemElemCostoE(SelectItem[] selectItemElemCostoE) {
		this.selectItemElemCostoE = selectItemElemCostoE;
	}

	/****************************** Insumos *************************/

	public SelectItem[] getSelectItemProducto() {

		if (producto == null || producto.size() == 0) {

			producto = new ArrayList<Producto>();

			try {

				producto = businessDelegatorView.getProducto(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Producto> lista = businessDelegatorView.findByCriteriaInProducto(condicion, null, null);
				selectItemProducto = new SelectItem[lista.size()];

				int i = 0;
				for (Producto p : lista) {
					selectItemProducto[i] = new SelectItem(p.getProductoId(), p.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemProducto;
	}

	public void setSelectItemProducto(SelectItem[] selectItemProducto) {
		this.selectItemProducto = selectItemProducto;
	}

	public SelectItem[] getSelectItemUdadMedI() {

		if (udadMedI == null || udadMedI.size() == 0) {

			udadMedI = new ArrayList<UdadMed>();

			try {

				udadMedI = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectItemUdadMedI = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectItemUdadMedI[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemUdadMedI;
	}

	public void setSelectItemUdadMedI(SelectItem[] selectItemUdadMedI) {
		this.selectItemUdadMedI = selectItemUdadMedI;
	}

	public SelectItem[] getSelectItemElemCostoI() {

		if (elemCostoI == null || elemCostoI.size() == 0) {

			elemCostoI = new ArrayList<ElementoCosto>();

			try {

				elemCostoI = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectItemElemCostoI = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectItemElemCostoI[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemElemCostoI;
	}

	public void getSelectItemElemCostoI(SelectItem[] selectItemElemCostoI) {
		this.selectItemElemCostoI = selectItemElemCostoI;
	}

	/********************** +Otros ************************/

	public SelectItem[] getSelectItemUdadMedO() {

		if (udadMedO == null || udadMedO.size() == 0) {

			udadMedO = new ArrayList<UdadMed>();

			try {

				udadMedO = businessDelegatorView.getUdadMed(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectItemUdadMedO = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectItemUdadMedO[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemUdadMedO;
	}

	public void setSelectItemUdadMedO(SelectItem[] selectItemUdadMedO) {
		this.selectItemUdadMedO = selectItemUdadMedO;
	}

	public SelectItem[] getSelectItemElemCostoO() {

		if (elemCostoO == null || elemCostoO.size() == 0) {

			elemCostoO = new ArrayList<ElementoCosto>();

			try {

				elemCostoO = businessDelegatorView.getElementoCosto(); // Fin
				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectItemElemCostoO = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectItemElemCostoO[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemElemCostoO;
	}

	public void setSelectItemElemCostoO(SelectItem[] selectItemElemCostoO) {
		this.selectItemElemCostoO = selectItemElemCostoO;
	}

	public SelectItem[] getSelectItemServicio() {

		if (servicio == null || servicio.size() == 0) {

			servicio = new ArrayList<Servicio>();

			try {

				servicio = businessDelegatorView.getServicio(); // Fin by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Servicio> lista = businessDelegatorView.findByCriteriaInServicio(condicion, null, null);
				selectItemServicio = new SelectItem[lista.size()];

				int i = 0;
				for (Servicio p : lista) {
					selectItemServicio[i] = new SelectItem(p.getServicioId(), p.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectItemServicio;
	}

	public void setSelectItemServicio(SelectItem[] selectItemServicio) {
		this.selectItemServicio = selectItemServicio;
	}

	public InputText getTxtNomCategoriaE() {
		return txtNomCategoriaE;
	}

	public void setTxtNomCategoriaE(InputText txtNomCategoriaE) {
		this.txtNomCategoriaE = txtNomCategoriaE;
	}

	public SelectOneMenu getTxtServicioId_Servicio() {
		return txtServicioId_Servicio;
	}

	public void setTxtServicioId_Servicio(SelectOneMenu txtServicioId_Servicio) {
		this.txtServicioId_Servicio = txtServicioId_Servicio;
	}

	public InputText getTxtNomServicio() {
		return txtNomServicio;
	}

	public void setTxtNomServicio(InputText txtNomServicio) {
		this.txtNomServicio = txtNomServicio;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

}
