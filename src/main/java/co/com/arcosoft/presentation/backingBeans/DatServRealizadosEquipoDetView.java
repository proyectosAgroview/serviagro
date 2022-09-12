package co.com.arcosoft.presentation.backingBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.spinner.Spinner;
import org.primefaces.event.CellEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaProgLaboresMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgLaboresMecMaqDTO;
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
public class DatServRealizadosEquipoDetView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatServRealizadosEquipoDetView.class);
	private InputText txtCantidad;
	private SelectOneMenu txtDatServRealizadosEquipoId;
	private SelectOneMenu txtEstadoFactura;
	private InputText txtHorasTotal;
	private InputText txtHorometroFinal;
	private InputText txtHorometroInicial;
	private InputText txtHorometroTotal;
	private InputText txtIngresoTotal;
	private InputText txtNivel2Id;
	private InputText txtNivel4Id;
	private InputText txtNombreNivel4;
	private InputText txtNumFactura;
	private InputText txtUsuarioValidacion;
	private InputText txtValorUnitario;
	private InputText txtDatServRealizadosEquipoDetId;
	private Calendar txtFechaValidacion;
	private Calendar txtHoraFinal;
	private Calendar txtHoraInicial;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DatServRealizadosEquipoDetDTO> data;
	private DatServRealizadosEquipoDetDTO selectedDatServRealizadosEquipoDet;
	private DatServRealizadosEquipoDet entity;

	private List<ConsultaServiciosRealizadosMaquinariaDTO> data2;
	private ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo2;
	private List<ConsultaServiciosRealizadosMaquinariaDTO> data3;
	private ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo3;

	private List<String> selectedEquipo;
	private List<Equipo> equipos;

	private Calendar txtFechaInicial;
	private Calendar txtFechaFinal;

	private Calendar txtFechaRegistro;

	private SelectOneMenu txtCentCostId_CentCost;
	SelectItem[] selectCentCost;
	private List<CentCost> centCost;

	private SelectOneMenu txtElemCostoId_ElementoCosto;
	SelectItem[] selectElementoCosto;
	private List<ElementoCosto> elementoCosto;

	private SelectOneMenu txtEquipoId_Equipo;
	SelectItem[] selectEquipo;
	private List<Equipo> equipo;

	private SelectOneMenu txtEquipoId_EquipoConsulta;
	SelectItem[] selectEquipoConsulta;
	private List<Equipo> equipoConsulta;

	private SelectOneMenu txtLaborId_Labor;
	SelectItem[] selectLaborId;
	private List<Labor> laborId;

	private SelectOneMenu txtUdadMedId_UdadMed;
	SelectItem[] selectUdadMed;
	private List<UdadMed> udadMed;

	private int activeTapIndex = 0;

	private InputText txtNombreNivel4Maq;

	private SelectOneMenu txtPersEmprId;
	SelectItem[] selectContratista;
	private List<PersEmpr> contratista;

	private SelectOneMenu txtImplemento;
	SelectItem[] selectImplemento;
	private List<Equipo> implemento;

	private InputText txtProducto;
	SelectItem[] selectProductoId;
	private List<Producto> productoId;

	private SelectOneMenu txtTrabId;
	SelectItem[] selectTrabajador;
	private List<Trabajador> trabajador;

	private SelectOneMenu txtNivel2ClientesId;
	SelectItem[] selectNivel2ClientesId;
	private List<Nivel2Clientesmq> nivel2ClientesId;

	private SelectOneMenu txtNivel4ClientesId;
	SelectItem[] selectNivel4ClientesId;
	private List<Nivel4Clientesmq> nivel4ClientesId;

	private Spinner txtBonificacionTrabajador;

	private SelectOneMenu txtTurno;

	private SelectOneMenu txtConceptoNominaId;
	SelectItem[] selectCeptoNominaId;
	private List<ConceptoNomina> conceptoNomina;

	private List<String> selectedLabor;
	private List<Labor> labores;

	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private InputText txtPin;
	private InputNumber txtAuxilioTransporte;
	private LogDatServRealizadosEquipo entityLog;

	private Long equipoIdPin;
	private Long consecutivoPin;
	private String cambioItemPin;
	private String codEquipoId;
	private Long idReg;

	private InputText txtConsecutivoRdl;
	private InputText txtValorUnitarioTrabajador;
	private InputText txtValorTotalTrabajador;
	private List<DatPlanServiciosMqdet> datPlanServicioMaq;

	private SelectOneMenu txtIdProgramacion;
	SelectItem[] selectDatPlanServicioMaqRegistro;

	SelectItem[] selectDatPlanServicioMaq;

	SelectItem[] selectDatServRealizadosEquipo;
	SelectItem[] selectDatServRealizadosEquipo2;

	private InputText txtCantidadTrabajador;
	private SelectOneMenu txtUnidadMedidaTrabajador;;
	SelectItem[] selectUdadMedTrabajador;

	public DatServRealizadosEquipoDetView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedDatServRealizadosEquipoDet = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDatServRealizadosEquipoDet = null;
		PrimeFaces.current().resetInputs(":frm");

		if (txtUnidadMedidaTrabajador != null) {
			txtUnidadMedidaTrabajador.setValue(null);
			txtUnidadMedidaTrabajador.setDisabled(false);
		}
		if (txtCantidadTrabajador != null) {
			txtCantidadTrabajador.setValue(null);
			txtCantidadTrabajador.setDisabled(false);
		}

		if (txtValorUnitarioTrabajador != null) {
			txtValorUnitarioTrabajador.setValue(null);
			txtValorUnitarioTrabajador.setDisabled(false);
		}

		if (txtValorTotalTrabajador != null) {
			txtValorTotalTrabajador.setValue(null);
			txtValorTotalTrabajador.setDisabled(false);
		}

		if (txtEstadoFactura != null) {
			txtEstadoFactura.setValue(null);
			txtEstadoFactura.setDisabled(true);
		}

		if (txtAuxilioTransporte != null) {
			txtAuxilioTransporte.setValue(null);
			txtAuxilioTransporte.setDisabled(true);
		}

		if (txtBonificacionTrabajador != null) {
			txtBonificacionTrabajador.setValue(null);
			txtBonificacionTrabajador.setDisabled(true);
		}

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(true);
		}

		if (txtConceptoNominaId != null) {
			txtConceptoNominaId.setValue(null);
			txtConceptoNominaId.setDisabled(true);
		}

		if (txtDatServRealizadosEquipoId != null) {
			txtDatServRealizadosEquipoId.setValue(null);
			txtDatServRealizadosEquipoId.setDisabled(true);
		}

		if (txtEstadoFactura != null) {
			txtEstadoFactura.setValue(null);
			txtEstadoFactura.setDisabled(true);
		}

		if (txtHorasTotal != null) {
			txtHorasTotal.setValue(null);
			txtHorasTotal.setDisabled(true);
		}

		if (txtHorometroFinal != null) {
			txtHorometroFinal.setValue(null);
			txtHorometroFinal.setDisabled(true);
		}

		if (txtHorometroInicial != null) {
			txtHorometroInicial.setValue(null);
			txtHorometroInicial.setDisabled(true);
		}

		if (txtHorometroTotal != null) {
			txtHorometroTotal.setValue(null);
			txtHorometroTotal.setDisabled(true);
		}

		if (txtImplemento != null) {
			txtImplemento.setValue(null);
			txtImplemento.setDisabled(true);
		}

		if (txtIngresoTotal != null) {
			txtIngresoTotal.setValue(null);
			txtIngresoTotal.setDisabled(true);
		}

		if (txtNivel2ClientesId != null) {
			txtNivel2ClientesId.setValue(null);
			txtNivel2ClientesId.setDisabled(true);
		}

		if (txtNivel2Id != null) {
			txtNivel2Id.setValue(null);
			txtNivel2Id.setDisabled(true);
		}

		if (txtNivel4ClientesId != null) {
			txtNivel4ClientesId.setValue(null);
			txtNivel4ClientesId.setDisabled(true);
		}

		if (txtNivel4Id != null) {
			txtNivel4Id.setValue(null);
			txtNivel4Id.setDisabled(true);
		}

		if (txtNombreNivel4 != null) {
			txtNombreNivel4.setValue(null);
			txtNombreNivel4.setDisabled(true);
		}

		if (txtNumFactura != null) {
			txtNumFactura.setValue(null);
			txtNumFactura.setDisabled(true);
		}

		if (txtPersEmprId != null) {
			txtPersEmprId.setValue(null);
			txtPersEmprId.setDisabled(true);
		}

		if (txtTrabId != null) {
			txtTrabId.setValue(null);
			txtTrabId.setDisabled(true);
		}

		if (txtTurno != null) {
			txtTurno.setValue(null);
			txtTurno.setDisabled(true);
		}

		if (txtUsuarioValidacion != null) {
			txtUsuarioValidacion.setValue(null);
			txtUsuarioValidacion.setDisabled(true);
		}

		if (txtValorUnitario != null) {
			txtValorUnitario.setValue(null);
			txtValorUnitario.setDisabled(true);
		}

		if (txtLaborId_Labor != null) {
			txtLaborId_Labor.setValue(null);
			txtLaborId_Labor.setDisabled(true);
		}

		if (txtUdadMedId_UdadMed != null) {
			txtUdadMedId_UdadMed.setValue(null);
			txtUdadMedId_UdadMed.setDisabled(true);
		}

		if (txtFechaValidacion != null) {
			txtFechaValidacion.setValue(null);
			txtFechaValidacion.setDisabled(true);
		}

		if (txtHoraFinal != null) {
			txtHoraFinal.setValue(null);
			txtHoraFinal.setDisabled(true);
		}

		if (txtHoraInicial != null) {
			txtHoraInicial.setValue(null);
			txtHoraInicial.setDisabled(true);
		}

		if (txtDatServRealizadosEquipoDetId != null) {
			txtDatServRealizadosEquipoDetId.setValue(null);
			txtDatServRealizadosEquipoDetId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaValidacion() {
		Date inputDate = (Date) txtFechaValidacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtHoraFinal() {
		Date inputDate = (Date) txtHoraFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtHoraInicial() {
		Date inputDate = (Date) txtHoraInicial.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public String action_edit(ActionEvent evt) {
		selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo2"));
		try {

			Long idRegistro = selectedDatServRealizadosEquipo2.getIdRegistro().longValue();
			Object[] condicion = { "datServRealizadosEquipoDetId", true, idRegistro, "=" };
			List<DatServRealizadosEquipoDet> lista = (idRegistro != null)
					? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicion, null, null)
					: null;

			if (lista != null && lista.size() > 0) {
				entity = lista.get(0);
				Long datServRealizadoEquipoId = null;
				Long consecutivo = null;
				Long equipoId = null;
				String codEquipo = "";
				String auxilioTransporte = "";
				String cantidad = "";
				String conceptoNomina = "";
				String horometroInicial = "";
				String horometroFinal = "";
				String idReg = "";
				String finca = "";
				String suerte = "";
				String cliente = "";
				String operario = "";
				String turno = "";
				String valorUnitario = "";
				String labor = "";
				String um = "";
				String valorTotal = "";
				String valorUnitarioTrabajador = "";
				String valorTotalTrabajador = "";

				if (selectedDatServRealizadosEquipo2.getEquipoId() != null) {
					equipoIdPin = selectedDatServRealizadosEquipo2.getEquipoId().longValue();

					codEquipoId = selectedDatServRealizadosEquipo2.getCodEquipo();

				}
				if (selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id() != null) {
					datServRealizadoEquipoId = selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id()
							.longValue();
				}
				if (selectedDatServRealizadosEquipo2.getPin() != null) {
					consecutivo = selectedDatServRealizadosEquipo2.getPin().longValue();
					consecutivoPin = consecutivo;
				}

				if (entity.getAuxilioTransporte() != null) {
					auxilioTransporte = entity.getAuxilioTransporte().toString();
				}
				if (entity.getCantidad() != null) {
					cantidad = entity.getCantidad().toString();
				}

				// if (entity.getConceptoNominaId() != null) {
				// conceptoNomina = entity.getConceptoNominaId().getNombre();
				// }
				if (entity.getHorometroInicial() != null) {
					horometroInicial = entity.getHorometroInicial().toString();
				}
				if (entity.getHorometroFinal() != null) {
					horometroFinal = entity.getHorometroFinal().toString();
				}

				if (entity.getNivel2ClientesId() != null) {
					Long fincaId = entity.getNivel2ClientesId().getNivel2ClientesmqId();
					Nivel2Clientesmq nivel2Cliente = businessDelegator2View.getNivel2Clientesmq(fincaId);
					finca = nivel2Cliente.getNombre();
				}
				if (entity.getNivel4ClientesId() != null) {
					Long suerteId = entity.getNivel4ClientesId().getNivel4ClientesmqId();
					Nivel4Clientesmq nivel4Cliente = businessDelegator2View.getNivel4Clientesmq(suerteId);
					suerte = nivel4Cliente.getCodigo();
				}

				if (entity.getPersEmpr() != null) {
					Long persEmprId = entity.getPersEmpr().getPersEmprId();
					PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
					cliente = persEmpr.getNombre();
				}
				if (entity.getTurno() != null) {
					turno = entity.getTurno().toString();
				}

				if (entity.getValorUnitario() != null) {
					valorUnitario = entity.getValorUnitario().toString();
				}

				if (entity.getLabor() != null) {
					Long laborId = entity.getLabor().getLaborId();
					Labor labores = businessDelegatorView.getLabor(laborId);
					labor = labores.getNombre();

				}
				if (entity.getIngresoTotal() != null) {
					valorTotal = entity.getIngresoTotal().toString();
				}

				if (entity.getDatServRealizadosEquipoDetId() != null) {
					idReg = entity.getDatServRealizadosEquipoDetId().toString();
				}
				if (entity.getValor_unitario_trabajador() != null) {
					valorUnitarioTrabajador = entity.getValor_unitario_trabajador().toString();
				}
				if (entity.getValor_total_trabajador() != null) {
					valorTotalTrabajador = entity.getValor_total_trabajador().toString();
				}

				cambioItemPin = "Valores iniciales: Id. Régistro: " + idReg + " Máquina: " + codEquipoId + " Pin: "
						+ consecutivo.toString() +

						" Cliente: " + cliente + " Hacienda: " + finca + " Suerte: " + suerte + " Labor: " + labor
						+ " Cantidad: " + cantidad + " Tarifa:" + valorUnitario + " Valor total: " + valorTotal
						+ " H. Inicial: " + horometroInicial + " H. Final: " + horometroFinal + " Turno: " + turno
						+ " Aux. Transporte: " + auxilioTransporte + " Vlr unit. trabajador: " + valorUnitarioTrabajador
						+ " Vlr. Total Trabajador: " + valorTotalTrabajador;

				Long usuarioId = new Long(getUsuarioIdSession());
				Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);
				if (selectedDatServRealizadosEquipo2.getEstatusRegistro() != null) {
					if (selectedDatServRealizadosEquipo2.getEstatusRegistro().equals("Sin facturar")
							|| selectedDatServRealizadosEquipo2.getEstatusRegistro().equals("pre-facturado")
							|| selectedDatServRealizadosEquipo2.getEstatusRegistro().equals("facturado")
							|| selectedDatServRealizadosEquipo2.getEstatusRegistro().equals("No aplica")) {

						if (usuario.getNivelAcceso() != null) {
							if (usuario.getNivelAcceso().equals("TOTAL")) {

								txtDatServRealizadosEquipoId
										.setValue(selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id());
								txtDatServRealizadosEquipoId.setDisabled(false);

								txtFechaRegistro.setValue(selectedDatServRealizadosEquipo2.getFechaRegistro());
								txtFechaRegistro.setReadonly(true);
								txtEquipoId_Equipo.setValue(selectedDatServRealizadosEquipo2.getEquipoId());
								txtEquipoId_Equipo.setDisabled(true);

								txtEstadoFactura.setValue(entity.getEstadoFactura());
								txtEstadoFactura.setDisabled(false);

								// txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());
								// txtAuxilioTransporte.setDisabled(false);
								if (entity.getDat_plan_servicios_mqdet_id() != null) {
									Long idProgramacion = entity.getDat_plan_servicios_mqdet_id()
											.getDatPlanServiciosMqdetId();
									txtIdProgramacion.setValue(idProgramacion);
								}
								txtIdProgramacion.setDisabled(false);
								txtCantidad.setValue(entity.getCantidad());
								txtCantidad.setDisabled(false);
								// txtConceptoNominaId.setValue(entity.getConceptoNominaId().getCeptoNominaId());
								// txtConceptoNominaId.setDisabled(false);
								txtHorometroFinal.setValue(entity.getHorometroFinal());
								txtHorometroFinal.setDisabled(false);
								txtHorometroInicial.setValue(entity.getHorometroInicial());
								txtHorometroInicial.setDisabled(false);

								if (entity.getImplemento() != null) {
									txtImplemento.setValue(entity.getImplemento().getEquipoId());
								}
								txtImplemento.setDisabled(false);

								// txtIngresoTotal.setValue(entity.getIngresoTotal());
								// txtIngresoTotal.setDisabled(false);
								txtNivel2ClientesId.setValue(entity.getNivel2ClientesId().getNivel2ClientesmqId());
								txtNivel2ClientesId.setDisabled(false);
								if (entity.getNivel4ClientesId() != null) {
									txtNivel4ClientesId.setValue(entity.getNivel4ClientesId().getNivel4ClientesmqId());
								}
								txtNivel4ClientesId.setDisabled(false);
								txtPersEmprId.setValue(entity.getPersEmpr().getPersEmprId());
								txtPersEmprId.setDisabled(false);
								txtTrabId.setValue(entity.getTrabajador().getTrabId());
								txtTrabId.setDisabled(false);
								txtTurno.setValue(entity.getTurno());
								txtTurno.setDisabled(false);
								txtValorUnitario.setValue(entity.getValorUnitario());
								txtValorUnitario.setDisabled(false);
								txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
								txtLaborId_Labor.setDisabled(false);
								txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
								txtUdadMedId_UdadMed.setDisabled(false);
								txtDatServRealizadosEquipoDetId.setValue(entity.getDatServRealizadosEquipoDetId());
								txtDatServRealizadosEquipoDetId.setDisabled(false);
								txtValorUnitarioTrabajador.setValue(null);
								if (entity.getValor_unitario_trabajador() != null) {
									txtValorUnitarioTrabajador.setValue(entity.getValor_unitario_trabajador());
								}

								txtValorUnitarioTrabajador.setDisabled(false);
								txtUnidadMedidaTrabajador.setValue(null);
								txtUnidadMedidaTrabajador.setValue(entity.getUnidadMedidaTrabajador());
								txtUnidadMedidaTrabajador.setDisabled(false);

								txtValorTotalTrabajador.setValue(null);
								if (entity.getValor_total_trabajador() != null) {
									txtValorTotalTrabajador.setValue(entity.getValor_total_trabajador());
								}
								txtValorTotalTrabajador.setDisabled(false);

								btnSave.setDisabled(false);
								setShowDialog(true);
							} else {
								txtEstadoFactura.setValue(entity.getEstadoFactura());
								txtEstadoFactura.setDisabled(true);
								if (entity.getDat_plan_servicios_mqdet_id() != null) {
									Long idProgramacion = entity.getDat_plan_servicios_mqdet_id()
											.getDatPlanServiciosMqdetId();
									txtIdProgramacion.setValue(idProgramacion);
								}
								// txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());
								// txtAuxilioTransporte.setDisabled(false);
								txtDatServRealizadosEquipoId
										.setValue(selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id());
								txtDatServRealizadosEquipoId.setDisabled(false);

								txtFechaRegistro.setValue(selectedDatServRealizadosEquipo2.getFechaRegistro());
								txtFechaRegistro.setReadonly(true);

								txtEquipoId_Equipo.setValue(selectedDatServRealizadosEquipo2.getEquipoId());
								txtEquipoId_Equipo.setDisabled(true);

								txtCantidad.setValue(entity.getCantidad());
								txtCantidad.setDisabled(false);
								// txtConceptoNominaId.setValue(entity.getConceptoNominaId().getCeptoNominaId());
								// txtConceptoNominaId.setDisabled(false);
								txtHorometroFinal.setValue(entity.getHorometroFinal());
								txtHorometroFinal.setDisabled(true);
								txtHorometroInicial.setValue(entity.getHorometroInicial());
								txtHorometroInicial.setDisabled(true);

								if (entity.getImplemento() != null) {
									txtImplemento.setValue(entity.getImplemento().getEquipoId());
								}
								txtImplemento.setDisabled(false);

								// txtIngresoTotal.setValue(entity.getIngresoTotal());
								// txtIngresoTotal.setDisabled(false);
								txtNivel2ClientesId.setValue(entity.getNivel2ClientesId().getNivel2ClientesmqId());
								txtNivel2ClientesId.setDisabled(true);
								if (entity.getNivel4ClientesId() != null) {
									txtNivel4ClientesId.setValue(entity.getNivel4ClientesId().getNivel4ClientesmqId());
								}
								txtNivel4ClientesId.setDisabled(false);
								txtPersEmprId.setValue(entity.getPersEmpr().getPersEmprId());
								txtPersEmprId.setDisabled(true);
								txtTrabId.setValue(entity.getTrabajador().getTrabId());
								txtTrabId.setDisabled(true);
								txtTurno.setValue(entity.getTurno());
								txtTurno.setDisabled(false);
								txtValorUnitario.setValue(entity.getValorUnitario());
								txtValorUnitario.setDisabled(false);
								txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
								txtLaborId_Labor.setDisabled(true);
								txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
								txtUdadMedId_UdadMed.setDisabled(true);
								txtDatServRealizadosEquipoDetId.setValue(entity.getDatServRealizadosEquipoDetId());
								txtDatServRealizadosEquipoDetId.setDisabled(true);

								txtValorUnitarioTrabajador.setValue(null);
								if (entity.getValor_unitario_trabajador() != null) {
									txtValorUnitarioTrabajador.setValue(entity.getValor_unitario_trabajador());
								}

								txtValorUnitarioTrabajador.setDisabled(false);
								txtUnidadMedidaTrabajador.setValue(null);
								txtUnidadMedidaTrabajador.setValue(entity.getUnidadMedidaTrabajador());
								txtUnidadMedidaTrabajador.setDisabled(false);

								txtValorTotalTrabajador.setValue(null);
								if (entity.getValor_total_trabajador() != null) {
									txtValorTotalTrabajador.setValue(entity.getValor_total_trabajador());
								}
								txtValorTotalTrabajador.setDisabled(false);

								btnSave.setDisabled(false);
								setShowDialog(true);
							}
						}
					} else {
						txtDatServRealizadosEquipoId
								.setValue(selectedDatServRealizadosEquipo2.getDat_serv_realizados_equipo_id());
						txtDatServRealizadosEquipoId.setReadonly(true);

						txtFechaRegistro.setValue(selectedDatServRealizadosEquipo2.getFechaRegistro());
						txtFechaRegistro.setReadonly(true);

						txtEquipoId_Equipo.setValue(selectedDatServRealizadosEquipo2.getEquipoId());
						txtEquipoId_Equipo.setDisabled(true);
						txtEstadoFactura.setValue(entity.getEstadoFactura());
						txtEstadoFactura.setDisabled(true);
						if (entity.getDat_plan_servicios_mqdet_id() != null) {
							Long idProgramacion = entity.getDat_plan_servicios_mqdet_id().getDatPlanServiciosMqdetId();
							txtIdProgramacion.setValue(idProgramacion);
						}
						// txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());

						// txtAuxilioTransporte.setDisabled(false);

						txtCantidad.setValue(entity.getCantidad());
						txtCantidad.setDisabled(true);
						// txtConceptoNominaId.setValue(entity.getConceptoNominaId().getCeptoNominaId());
						// txtConceptoNominaId.setDisabled(true);
						txtHorometroFinal.setValue(entity.getHorometroFinal());
						txtHorometroFinal.setDisabled(true);
						txtHorometroInicial.setValue(entity.getHorometroInicial());
						txtHorometroInicial.setDisabled(true);

						if (entity.getImplemento() != null) {
							txtImplemento.setValue(entity.getImplemento().getEquipoId());
						}
						txtImplemento.setDisabled(true);

						// txtIngresoTotal.setValue(entity.getIngresoTotal());
						// txtIngresoTotal.setDisabled(true);
						txtNivel2ClientesId.setValue(entity.getNivel2ClientesId().getNivel2ClientesmqId());
						txtNivel2ClientesId.setDisabled(true);
						if (entity.getNivel4ClientesId() != null) {
							txtNivel4ClientesId.setValue(entity.getNivel4ClientesId().getNivel4ClientesmqId());
						}
						txtNivel4ClientesId.setDisabled(true);
						txtPersEmprId.setValue(entity.getPersEmpr().getPersEmprId());
						txtPersEmprId.setDisabled(true);
						txtTrabId.setValue(entity.getTrabajador().getTrabId());
						txtTrabId.setDisabled(true);
						txtTurno.setValue(entity.getTurno());
						txtTurno.setDisabled(true);
						txtValorUnitario.setValue(entity.getValorUnitario());
						txtValorUnitario.setDisabled(true);
						txtLaborId_Labor.setValue(entity.getLabor().getLaborId());
						txtLaborId_Labor.setDisabled(true);
						txtUdadMedId_UdadMed.setValue(entity.getUdadMed().getUdadMedId());
						txtUdadMedId_UdadMed.setDisabled(true);
						txtDatServRealizadosEquipoDetId.setValue(entity.getDatServRealizadosEquipoDetId());
						txtDatServRealizadosEquipoDetId.setDisabled(true);

						txtValorUnitarioTrabajador.setValue(null);
						if (entity.getValor_unitario_trabajador() != null) {
							txtValorUnitarioTrabajador.setValue(entity.getValor_unitario_trabajador());
						}

						txtValorUnitarioTrabajador.setDisabled(false);

						txtUnidadMedidaTrabajador.setValue(null);
						txtUnidadMedidaTrabajador.setValue(entity.getUnidadMedidaTrabajador());
						txtUnidadMedidaTrabajador.setDisabled(false);

						txtCantidadTrabajador.setValue(null);
						txtCantidadTrabajador.setValue(entity.getCantidadTrabajador());
						txtCantidadTrabajador.setDisabled(false);

						btnSave.setDisabled(false);
						setShowDialog(true);
					}
				}
			}
		} catch (Exception e) {
			entity = null;
		}

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDatServRealizadosEquipoDet == null) && (entity == null)) {
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
			entity = new DatServRealizadosEquipoDet();
			Long usuarioId = new Long(getUsuarioIdSession());
			Long datServRealizadosEquipoDetId = FacesUtils.checkLong(txtDatServRealizadosEquipoDetId);
			entity.setAuxilioTransporte(FacesUtils.checkDouble(txtAuxilioTransporte));

			entity.setBonificacionTrabajador(FacesUtils.checkDouble(txtBonificacionTrabajador));
			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setDatServRealizadosEquipoDetId(datServRealizadosEquipoDetId);
			entity.setEstadoFactura(FacesUtils.checkString(txtEstadoFactura));
			entity.setFechaValidacion(FacesUtils.checkDate(txtFechaValidacion));
			entity.setHoraFinal(FacesUtils.checkDate(txtHoraFinal));
			entity.setHoraInicial(FacesUtils.checkDate(txtHoraInicial));
			entity.setHorasTotal(FacesUtils.checkDouble(txtHorasTotal));
			entity.setHorometroFinal(FacesUtils.checkDouble(txtHorometroFinal));
			entity.setHorometroInicial(FacesUtils.checkDouble(txtHorometroInicial));
			entity.setHorometroTotal(FacesUtils.checkDouble(txtHorometroTotal));

			entity.setNombreNivel4(FacesUtils.checkString(txtNombreNivel4));
			entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
			entity.setTurno(FacesUtils.checkString(txtTurno));
			entity.setUsuarioValidacion(FacesUtils.checkLong(txtUsuarioValidacion));
			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));

			Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			if (valorUnit != null && cantidad != null) {

				entity.setIngresoTotal(valorUnit * cantidad);
			}

			entity.setTrabajador((FacesUtils.checkLong(txtTrabId) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId))
					: null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);

			entity.setNivel4ClientesId((FacesUtils.checkLong(txtNivel4ClientesId) != null)
					? businessDelegator2View.getNivel4Clientesmq(FacesUtils.checkLong(txtNivel4ClientesId))
					: null);

			entity.setNivel2ClientesId((FacesUtils.checkLong(txtNivel2ClientesId) != null)
					? businessDelegator2View.getNivel2Clientesmq(FacesUtils.checkLong(txtNivel2ClientesId))
					: null);

			entity.setImplemento((FacesUtils.checkLong(txtImplemento) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtImplemento))
					: null);

			entity.setDatServRealizadosEquipoId(
					(FacesUtils.checkLong(txtDatServRealizadosEquipoId) != null) ? businessDelegatorView
							.getDatServRealizadosEquipo(FacesUtils.checkLong(txtDatServRealizadosEquipoId)) : null);

			entity.setConceptoNominaId((FacesUtils.checkLong(txtConceptoNominaId) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtConceptoNominaId))
					: null);

			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);
			entity.setDat_plan_servicios_mqdet_id((FacesUtils.checkLong(txtIdProgramacion) != null)
					? businessDelegatorView.getDatPlanServiciosMqdet(FacesUtils.checkLong(txtIdProgramacion))
					: null);

			entity.setCantidadTrabajador(FacesUtils.checkDouble(txtCantidad));
			entity.setValor_unitario_trabajador(FacesUtils.checkDouble(txtValorUnitarioTrabajador));
			entity.setUnidadMedidaTrabajador(FacesUtils.checkLong(txtUnidadMedidaTrabajador));

			Double cantidadTrabajador = FacesUtils.checkDouble(txtCantidadTrabajador);
			Double valorUnitTrabajador = FacesUtils.checkDouble(txtValorUnitarioTrabajador);
			if (valorUnitTrabajador != null && cantidadTrabajador != null) {
				if (cantidadTrabajador == 0) {
					entity.setValor_total_trabajador(valorUnitTrabajador);
				} else {

					entity.setValor_total_trabajador(valorUnitTrabajador * cantidadTrabajador);
				}

			}

			entity.setUsuarioDigitacion(usuarioId);
			businessDelegatorView.saveDatServRealizadosEquipoDet(entity);
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
				Long datServRealizadosEquipoDetId = new Long(
						selectedDatServRealizadosEquipoDet.getDatServRealizadosEquipoDetId());
				entity = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);
			}
			entityLog = new LogDatServRealizadosEquipo();

			Long compania = new Long(getCompaniaIdSession());
			Long usuarioId = new Long(getUsuarioIdSession());
			Date date = new Date();
			String estado = "A";

			BigDecimal bonif = businessDelegator2View.consultarAdicionalManoObra(compania,
					FacesUtils.checkLong(txtLaborId_Labor), FacesUtils.checkLong(txtUdadMedId_UdadMed),
					FacesUtils.checkDate(txtFechaRegistro), FacesUtils.checkDouble(txtCantidad));
			Double bonificacionTrabajador = bonif.doubleValue();

			entity.setBonificacionTrabajador(bonificacionTrabajador);
			entity.setAuxilioTransporte(FacesUtils.checkDouble(txtAuxilioTransporte));
			entity.setEstadoFactura(FacesUtils.checkString(txtEstadoFactura));
			// entity.setFechaValidacion(FacesUtils.checkDate(txtFechaValidacion));
			entity.setHoraFinal(FacesUtils.checkDate(txtHoraFinal));
			entity.setHoraInicial(FacesUtils.checkDate(txtHoraInicial));
			entity.setHorometroFinal(FacesUtils.checkDouble(txtHorometroFinal));
			entity.setHorometroInicial(FacesUtils.checkDouble(txtHorometroInicial));

			Double horometroIni = FacesUtils.checkDouble(txtHorometroInicial);
			Double horometroFin = FacesUtils.checkDouble(txtHorometroFinal);
			Double totalHorometro = 0.0;
			Double totalHoras = 0.0;
			if (horometroIni != null && horometroFin != null) {
				totalHorometro = (horometroFin - horometroIni);
				totalHoras = (horometroFin - horometroIni);
			}
			entity.setHorasTotal(totalHorometro);
			entity.setHorometroTotal(totalHoras);

			Long udadMedId_UdadMed = null;
			UdadMed udadMed = null;
			if (txtUdadMedId_UdadMed.getValue() != null) {
				udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
				udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
				String tipoUm = udadMed.getClasificacionUm();

				if (tipoUm != null) {
					if (tipoUm.equals("HR")) {
						entity.setCantidad(totalHorometro);
						entity.setCantidadTrabajador(totalHorometro);
					} else {
						entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
						entity.setCantidadTrabajador(FacesUtils.checkDouble(txtCantidad));
					}

				} else {
					entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
					entity.setCantidadTrabajador(FacesUtils.checkDouble(txtCantidad));
				}
			} else {
				entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
				entity.setCantidadTrabajador(FacesUtils.checkDouble(txtCantidad));
			}

			// entity.setIngresoTotal(FacesUtils.checkDouble(txtIngresoTotal));
			entity.setNombreNivel4(FacesUtils.checkString(txtNombreNivel4));
			// entity.setNumFactura(FacesUtils.checkString(txtNumFactura));
			entity.setTurno(FacesUtils.checkString(txtTurno));
			// entity.setUsuarioValidacion(FacesUtils.checkLong(
			// txtUsuarioValidacion));

			entity.setTrabajador((FacesUtils.checkLong(txtTrabId) != null)
					? businessDelegatorView.getTrabajador(FacesUtils.checkLong(txtTrabId))
					: null);

			entity.setPersEmpr((FacesUtils.checkLong(txtPersEmprId) != null)
					? businessDelegatorView.getPersEmpr(FacesUtils.checkLong(txtPersEmprId))
					: null);

			entity.setNivel4ClientesId((FacesUtils.checkLong(txtNivel4ClientesId) != null)
					? businessDelegator2View.getNivel4Clientesmq(FacesUtils.checkLong(txtNivel4ClientesId))
					: null);

			entity.setNivel2ClientesId((FacesUtils.checkLong(txtNivel2ClientesId) != null)
					? businessDelegator2View.getNivel2Clientesmq(FacesUtils.checkLong(txtNivel2ClientesId))
					: null);

			entity.setImplemento((FacesUtils.checkLong(txtImplemento) != null)
					? businessDelegatorView.getEquipo(FacesUtils.checkLong(txtImplemento))
					: null);

			entity.setConceptoNominaId((FacesUtils.checkLong(txtConceptoNominaId) != null)
					? businessDelegatorView.getConceptoNomina(FacesUtils.checkLong(txtConceptoNominaId))
					: null);

			entity.setDat_plan_servicios_mqdet_id((FacesUtils.checkLong(txtIdProgramacion) != null)
					? businessDelegatorView.getDatPlanServiciosMqdet(FacesUtils.checkLong(txtIdProgramacion))
					: null);

			entity.setValorUnitario(FacesUtils.checkDouble(txtValorUnitario));
			entity.setUsuarioDigitacion(usuarioId);

			Double valorUnit = FacesUtils.checkDouble(txtValorUnitario);
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			if (valorUnit != null && cantidad != null) {

				entity.setIngresoTotal(valorUnit * cantidad);
			}

			// Double valorUnitarioTrabajador =
			// businessDelegatorView.consultarTarifaLaborRendimientoBase
			// (compania, 0L, idLabor, 0L, udadMedId_UdadMed, fechaRegistro).doubleValue();

			entity.setLabor((FacesUtils.checkLong(txtLaborId_Labor) != null)
					? businessDelegatorView.getLabor(FacesUtils.checkLong(txtLaborId_Labor))
					: null);
			entity.setUdadMed((FacesUtils.checkLong(txtUdadMedId_UdadMed) != null)
					? businessDelegatorView.getUdadMed(FacesUtils.checkLong(txtUdadMedId_UdadMed))
					: null);
			entity.setDatServRealizadosEquipoId(
					(FacesUtils.checkLong(txtDatServRealizadosEquipoId) != null) ? businessDelegatorView
							.getDatServRealizadosEquipo(FacesUtils.checkLong(txtDatServRealizadosEquipoId)) : null);
 
			entity.setValor_unitario_trabajador(FacesUtils.checkDouble(txtValorUnitarioTrabajador));
			entity.setUnidadMedidaTrabajador(FacesUtils.checkLong(txtUnidadMedidaTrabajador));
			entity.setValor_total_trabajador(FacesUtils.checkDouble(txtValorTotalTrabajador));

			businessDelegatorView.updateDatServRealizadosEquipoDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			Long idmaq = equipoIdPin;

			if (idmaq != null) {
				Object[] condicionCtrlPines = { "equipo.equipoId", true, idmaq, "=" };
				List<DatCtrlMaqPines> listaCtrlPines = (idmaq != null)
						? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicionCtrlPines, null, null)
						: null;
				if (listaCtrlPines != null && listaCtrlPines.size() > 0) {
					DatCtrlMaqPines datCtrlMaqPines = listaCtrlPines.get(0);

					Long consecutivoInicial = datCtrlMaqPines.getConsecutivoPin();
					if (consecutivoInicial >= consecutivoPin) {
						businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoInicial);
					} else {
						businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoPin);
					}

				}
			}
			/**** actualizo la programación ***/

			if (entity.getLabor() != null) {
				Long laborId = entity.getLabor().getLaborId();
				Labor labor = businessDelegatorView.getLabor(laborId);
				if (labor.getClaseLabor() != null) {
					if (!labor.getClaseLabor().equals("Transporte")) {
						Long idPrograma = 0L;
						if (entity.getDat_plan_servicios_mqdet_id() != null) {
							idPrograma = entity.getDat_plan_servicios_mqdet_id().getDatPlanServiciosMqdetId();
							businessDelegator2View.pr_actualizar_prog_maquinaria(idPrograma);

						}
					}
				}
			}

			entityLog.setCompania(compania);
			entityLog.setConsecutivo(consecutivoPin);
			entityLog.setUsuarioModificacion(usuarioId);
			entityLog.setEquipoId((equipoIdPin != null) ? businessDelegatorView.getEquipo(equipoIdPin) : null);

			Usuarios usuario = businessDelegatorView.getUsuarios(usuarioId);

			entityLog.setFecha(date);

			String codusuario = usuario.getLogin();

			entityLog.setDatServRealizadosEquipoId(FacesUtils.checkLong(txtDatServRealizadosEquipoDetId));

			String auxilioTransporte = "";
			String horometroInicial = "";
			String horometroFinal = "";
			String idReg = "";
			String finca = "";
			String suerte = "";
			String cliente = "";
			String operario = "";
			String turno = "";
			String valorUnitario = "";
			String labor = "";
			String um = "";
			String valorTotal = "";

			if (entity.getAuxilioTransporte() != null) {
				auxilioTransporte = entity.getAuxilioTransporte().toString();
			}

			if (entity.getHorometroInicial() != null) {
				horometroInicial = entity.getHorometroInicial().toString();
			}
			if (entity.getHorometroFinal() != null) {
				horometroFinal = entity.getHorometroFinal().toString();
			}

			if (entity.getNivel2ClientesId() != null) {
				Long fincaId = entity.getNivel2ClientesId().getNivel2ClientesmqId();
				Nivel2Clientesmq nivel2Cliente = businessDelegator2View.getNivel2Clientesmq(fincaId);
				finca = nivel2Cliente.getNombre();
			}
			if (entity.getNivel4ClientesId() != null) {
				Long suerteId = entity.getNivel4ClientesId().getNivel4ClientesmqId();
				Nivel4Clientesmq nivel4Cliente = businessDelegator2View.getNivel4Clientesmq(suerteId);
				suerte = nivel4Cliente.getCodigo();
			}

			if (entity.getPersEmpr() != null) {
				Long persEmprId = entity.getPersEmpr().getPersEmprId();
				PersEmpr persEmpr = businessDelegatorView.getPersEmpr(persEmprId);
				cliente = persEmpr.getNombre();
			}
			if (entity.getTurno() != null) {
				turno = entity.getTurno().toString();
			}

			if (entity.getValorUnitario() != null) {
				valorUnitario = entity.getValorUnitario().toString();
			}

			if (entity.getLabor() != null) {
				Long laborId = entity.getLabor().getLaborId();
				Labor labores = businessDelegatorView.getLabor(laborId);
				labor = labores.getNombre();

			}
			if (entity.getIngresoTotal() != null) {
				valorTotal = entity.getIngresoTotal().toString();
			}

			if (entity.getDatServRealizadosEquipoDetId() != null) {
				idReg = entity.getDatServRealizadosEquipoDetId().toString();
			}

			String valoresFinalesTiquete = "Valores finales: Id. Régistro: " + idReg + " Máquina: " + codEquipoId
					+ " Pin: " + consecutivoPin.toString() +

					" Cliente: " + cliente + " Hacienda: " + finca + " Suerte: " + suerte + " Labor: " + labor
					+ " Cantidad: " + cantidad + " Tarifa: " + valorUnitario + " Valor total: " + valorTotal
					+ " H. Inicial: " + horometroInicial + " H. Final: " + horometroFinal + " Turno: " + turno
					+ " Aux. Transporte: " + auxilioTransporte;

			entityLog.setObservacion("El Pin:" + "  " + consecutivoPin.toString() + " de la máquina: " + codEquipoId
					+ " Fue modificado por el usuario: " + codusuario + " " + cambioItemPin + " -------------------- "
					+ valoresFinalesTiquete);

			businessDelegator2View.saveLogDatServRealizadosEquipo(entityLog);

			action_clear();
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			// selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO)
			// (evt.getComponent().getAttributes()
			// .get("selectedDatServRealizadosEquipo2"));

			Long datServRealizadosEquipoDetId = new Long(selectedDatServRealizadosEquipo2.getIdRegistro().longValue());
			entity = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long datServRealizadosEquipoDetId = FacesUtils.checkLong(txtDatServRealizadosEquipoDetId);
			entity = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteDatServRealizadosEquipoDet(entity);
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
			selectedDatServRealizadosEquipoDet = (DatServRealizadosEquipoDetDTO) (evt.getComponent().getAttributes()
					.get("selectedDatServRealizadosEquipoDet"));

			Long datServRealizadosEquipoDetId = new Long(
					selectedDatServRealizadosEquipoDet.getDatServRealizadosEquipoDetId());
			entity = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);
			businessDelegatorView.deleteDatServRealizadosEquipoDet(entity);
			data.remove(selectedDatServRealizadosEquipoDet);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double bonificacionTrabajador, Double cantidad, Long conceptoNominaId,
			Long datServRealizadosEquipoDetId, Long datServRealizadosEquipoId, String estadoFactura,
			Date fechaValidacion, Date horaFinal, Date horaInicial, Double horasTotal, Double horometroFinal,
			Double horometroInicial, Double horometroTotal, Long implemento, Double ingresoTotal, Long nivel2ClientesId,
			Long nivel2Id, Long nivel4ClientesId, Long nivel4Id, String nombreNivel4, Long numFactura, Long persEmprId,
			Long trabId, String turno, Long usuarioValidacion, Double valorUnitario, Long laborId_Labor,
			Long udadMedId_UdadMed) throws Exception {
		try {
			entity.setBonificacionTrabajador(FacesUtils.checkDouble(bonificacionTrabajador));
			entity.setCantidad(FacesUtils.checkDouble(cantidad));
			entity.setEstadoFactura(FacesUtils.checkString(estadoFactura));
			entity.setFechaValidacion(FacesUtils.checkDate(fechaValidacion));
			entity.setHoraFinal(FacesUtils.checkDate(horaFinal));
			entity.setHoraInicial(FacesUtils.checkDate(horaInicial));
			entity.setHorasTotal(FacesUtils.checkDouble(horasTotal));
			entity.setHorometroFinal(FacesUtils.checkDouble(horometroFinal));
			entity.setHorometroInicial(FacesUtils.checkDouble(horometroInicial));
			entity.setHorometroTotal(FacesUtils.checkDouble(horometroTotal));
			entity.setIngresoTotal(FacesUtils.checkDouble(ingresoTotal));
			entity.setNombreNivel4(FacesUtils.checkString(nombreNivel4));
			entity.setNumFactura(FacesUtils.checkString(numFactura));
			entity.setTurno(FacesUtils.checkString(turno));
			entity.setUsuarioValidacion(FacesUtils.checkLong(usuarioValidacion));
			entity.setValorUnitario(FacesUtils.checkDouble(valorUnitario));
			businessDelegatorView.updateDatServRealizadosEquipoDet(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DatServRealizadosEquipoDetView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtDatServRealizadosEquipoId() {
		return txtDatServRealizadosEquipoId;
	}

	public void setTxtDatServRealizadosEquipoId(SelectOneMenu txtDatServRealizadosEquipoId) {
		this.txtDatServRealizadosEquipoId = txtDatServRealizadosEquipoId;
	}

	public SelectOneMenu getTxtEstadoFactura() {
		return txtEstadoFactura;
	}

	public void setTxtEstadoFactura(SelectOneMenu txtEstadoFactura) {
		this.txtEstadoFactura = txtEstadoFactura;
	}

	public InputText getTxtHorasTotal() {
		return txtHorasTotal;
	}

	public void setTxtHorasTotal(InputText txtHorasTotal) {
		this.txtHorasTotal = txtHorasTotal;
	}

	public InputText getTxtHorometroFinal() {
		return txtHorometroFinal;
	}

	public void setTxtHorometroFinal(InputText txtHorometroFinal) {
		this.txtHorometroFinal = txtHorometroFinal;
	}

	public InputText getTxtHorometroInicial() {
		return txtHorometroInicial;
	}

	public void setTxtHorometroInicial(InputText txtHorometroInicial) {
		this.txtHorometroInicial = txtHorometroInicial;
	}

	public InputText getTxtHorometroTotal() {
		return txtHorometroTotal;
	}

	public void setTxtHorometroTotal(InputText txtHorometroTotal) {
		this.txtHorometroTotal = txtHorometroTotal;
	}

	public InputText getTxtIngresoTotal() {
		return txtIngresoTotal;
	}

	public void setTxtIngresoTotal(InputText txtIngresoTotal) {
		this.txtIngresoTotal = txtIngresoTotal;
	}

	public InputText getTxtNivel2Id() {
		return txtNivel2Id;
	}

	public void setTxtNivel2Id(InputText txtNivel2Id) {
		this.txtNivel2Id = txtNivel2Id;
	}

	public InputText getTxtNivel4Id() {
		return txtNivel4Id;
	}

	public void setTxtNivel4Id(InputText txtNivel4Id) {
		this.txtNivel4Id = txtNivel4Id;
	}

	public InputText getTxtNombreNivel4() {
		return txtNombreNivel4;
	}

	public void setTxtNombreNivel4(InputText txtNombreNivel4) {
		this.txtNombreNivel4 = txtNombreNivel4;
	}

	public InputText getTxtNumFactura() {
		return txtNumFactura;
	}

	public void setTxtNumFactura(InputText txtNumFactura) {
		this.txtNumFactura = txtNumFactura;
	}

	public InputText getTxtUsuarioValidacion() {
		return txtUsuarioValidacion;
	}

	public void setTxtUsuarioValidacion(InputText txtUsuarioValidacion) {
		this.txtUsuarioValidacion = txtUsuarioValidacion;
	}

	public InputText getTxtValorUnitario() {
		return txtValorUnitario;
	}

	public void setTxtValorUnitario(InputText txtValorUnitario) {
		this.txtValorUnitario = txtValorUnitario;
	}

	public Calendar getTxtFechaValidacion() {
		return txtFechaValidacion;
	}

	public void setTxtFechaValidacion(Calendar txtFechaValidacion) {
		this.txtFechaValidacion = txtFechaValidacion;
	}

	public Calendar getTxtHoraFinal() {
		return txtHoraFinal;
	}

	public void setTxtHoraFinal(Calendar txtHoraFinal) {
		this.txtHoraFinal = txtHoraFinal;
	}

	public Calendar getTxtHoraInicial() {
		return txtHoraInicial;
	}

	public void setTxtHoraInicial(Calendar txtHoraInicial) {
		this.txtHoraInicial = txtHoraInicial;
	}

	public InputText getTxtDatServRealizadosEquipoDetId() {
		return txtDatServRealizadosEquipoDetId;
	}

	public void setTxtDatServRealizadosEquipoDetId(InputText txtDatServRealizadosEquipoDetId) {
		this.txtDatServRealizadosEquipoDetId = txtDatServRealizadosEquipoDetId;
	}

	public List<DatServRealizadosEquipoDetDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDatServRealizadosEquipoDet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DatServRealizadosEquipoDetDTO> datServRealizadosEquipoDetDTO) {
		this.data = datServRealizadosEquipoDetDTO;
	}

	public DatServRealizadosEquipoDetDTO getSelectedDatServRealizadosEquipoDet() {
		return selectedDatServRealizadosEquipoDet;
	}

	public void setSelectedDatServRealizadosEquipoDet(DatServRealizadosEquipoDetDTO datServRealizadosEquipoDet) {
		this.selectedDatServRealizadosEquipoDet = datServRealizadosEquipoDet;
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

	public void editarServicios() {
		try {

			// Long compania = 1L;
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));
			fechaFinal = (FacesUtils.checkDate(txtFechaFinal));
			Long flagEquipo = 1L;
			Long consecutivoRdl = 0L;
			consecutivoRdl = FacesUtils.checkLong(txtConsecutivoRdl);
			if (consecutivoRdl == null) {
				consecutivoRdl = 0L;
			}

			Long pinId = 0L;
			pinId = FacesUtils.checkLong(txtPin);

			if (pinId == null) {
				pinId = 0L;
			}
			String equipoId = "0";
			if (txtEquipoId_EquipoConsulta.getValue() != null) {
				equipoId = txtEquipoId_EquipoConsulta.getValue().toString();
				flagEquipo = 0l;
			}
			if (fechaInicial != null && fechaFinal != null) {
				data2 = businessDelegator2View.consultaServRealizadosEquipoDet(compania, "Todos", fechaInicial,
						fechaFinal, "0", 1l, "0", 1l, "0", 1l, "0", 1l, "0", 1l, "0", 1l, equipoId, flagEquipo, pinId,
						consecutivoRdl, 0L);

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Upss! No se ha introducido valores para los filtros Máquina y Fechas", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param data2 the data2 to set
	 */

	public void verServiciosRegistrados() {
		try {

			// Long compania = 1L;
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			Long flagEquipo = 1L;

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);

			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();

			Long consecutivoRdl = 0L;
			consecutivoRdl = FacesUtils.checkLong(txtConsecutivoRdl);
			if (consecutivoRdl == null) {
				consecutivoRdl = 0L;
			}

			Long pinId = 0L;
			pinId = FacesUtils.checkLong(txtPin);

			if (pinId == null) {
				pinId = 0L;
			}
			String equipoId = "";
			if (txtEquipoId_EquipoConsulta.getValue() != null) {
				equipoId = txtEquipoId_EquipoConsulta.getValue().toString();
			}

			if (equipoId != null && pinId != null) {
				data3 = businessDelegator2View.consultaServRealizadosEquipoDet(compania, "Todos",
						fechaFinalDateRegistro, date, "0", 1l, "0", 1l, "0", 1l, "0", 1l, "0", 1l, "0", 1l, equipoId,
						0L, pinId, consecutivoRdl, 0L);

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Upss! No se ha introducido valores para los filtros Máquina y Número de pin", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData2() {
		return data2;
	}

	public void setData2(List<ConsultaServiciosRealizadosMaquinariaDTO> data2) {
		this.data2 = data2;
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> getData3() {
		return data3;
	}

	/**
	 * @param data3 the data3 to set
	 */
	public void setData3(List<ConsultaServiciosRealizadosMaquinariaDTO> data3) {
		this.data3 = data3;
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

	/**
	 * @return the txtFechaInicial
	 */
	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	/**
	 * @param txtFechaInicial the txtFechaInicial to set
	 */
	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	/**
	 * @return the txtFechaFinal
	 */
	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	/**
	 * @param txtFechaFinal the txtFechaFinal to set
	 */
	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	/**
	 * @return the selectedDatServRealizadosEquipo2
	 */
	public ConsultaServiciosRealizadosMaquinariaDTO getSelectedDatServRealizadosEquipo2() {
		return selectedDatServRealizadosEquipo2;
	}

	/**
	 * @param selectedDatServRealizadosEquipo2 the selectedDatServRealizadosEquipo2
	 *                                         to set
	 */
	public void setSelectedDatServRealizadosEquipo2(
			ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo2) {
		this.selectedDatServRealizadosEquipo2 = selectedDatServRealizadosEquipo2;
	}

	public SelectItem[] getSelectEquipo() {

		if (equipo == null || equipo.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",

						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"

				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipo = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipo : lista) {
					selectEquipo[i] = new SelectItem(equipo.getEquipoId(),
							equipo.getCodigo() + "-" + equipo.getNombre());
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

	public SelectItem[] getselectEquipoConsulta() {

		if (equipoConsulta == null || equipoConsulta.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Implemento", "<>", "categoriaEquipo.funcion", true,
						"Remolques/Vagones", "<>", "categoriaEquipo.funcion", true, "Herramienta", "<>",
						"categoriaEquipo.funcion", true, "Otros", "<>"

				};
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectEquipoConsulta = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo equipoConsulta : lista) {
					selectEquipoConsulta[i] = new SelectItem(equipoConsulta.getEquipoId(),
							equipoConsulta.getCodigo() + "-" + equipoConsulta.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectEquipoConsulta;
	}

	public void setSelectEquipoConsulta(SelectItem[] selectEquipoConsulta) {
		this.selectEquipoConsulta = selectEquipoConsulta;
	}

	public SelectItem[] getselectCentCost() {

		if (centCost == null || centCost.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<CentCost> lista = businessDelegatorView.findByCriteriaInCentCost(condicion, null, null);
				selectCentCost = new SelectItem[lista.size()];

				int i = 0;
				for (CentCost centCost : lista) {
					selectCentCost[i] = new SelectItem(centCost.getCentCostId(), centCost.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCentCost;
	}

	public void setselectCentCost(SelectItem[] selectCentCost) {
		this.selectCentCost = selectCentCost;
	}

	public SelectItem[] getselectElementoCosto() {

		if (elementoCosto == null || elementoCosto.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ElementoCosto> lista = businessDelegatorView.findByCriteriaInElementoCosto(condicion, null, null);
				selectElementoCosto = new SelectItem[lista.size()];

				int i = 0;
				for (ElementoCosto elementoCosto : lista) {
					selectElementoCosto[i] = new SelectItem(elementoCosto.getElemCostoId(), elementoCosto.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectElementoCosto;
	}

	public void setselectElementoCosto(SelectItem[] selectElementoCosto) {
		this.selectElementoCosto = selectElementoCosto;
	}

	public SelectItem[] getselectContratista() {

		if (contratista == null || contratista.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "="

						, "tipoEmpresa", true, "2", "<>", "tipoEmpresa", true, "3", "<>", "tipoEmpresa", true, "5",
						"<>", "tipoEmpresa", true, "6", "<>" };
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

	public SelectItem[] getselectLaborId() {

		if (laborId == null || laborId.size() == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<Labor> lista = businessDelegatorView.findByCriteriaInLabor(condicion, null, null);
				selectLaborId = new SelectItem[lista.size()];

				int i = 0;
				for (Labor laborId : lista) {
					selectLaborId[i] = new SelectItem(laborId.getLaborId(), laborId.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectLaborId;
	}

	public void setselectLaborId(SelectItem[] selectLaborId) {

		this.selectLaborId = selectLaborId;
	}

	public SelectItem[] getSelectUdadMed() {

		if (udadMed == null || udadMed.size() == 0) {

			try {

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

	public SelectItem[] getSelectUdadMedTrabajador() {

		if (selectUdadMedTrabajador == null || selectUdadMedTrabajador.length == 0) {

			try {

				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<UdadMed> lista = businessDelegatorView.findByCriteriaInUdadMed(condicion, null, null);
				selectUdadMedTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (UdadMed udadMed : lista) {
					selectUdadMedTrabajador[i] = new SelectItem(udadMed.getUdadMedId(), udadMed.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectUdadMedTrabajador;
	}

	public void setSelectUdadMedTrabajador(SelectItem[] selectUdadMedTrabajador) {
		this.selectUdadMedTrabajador = selectUdadMedTrabajador;
	}

	public SelectItem[] getselectImplemento() {

		if (implemento == null || implemento.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "=", "origenDatos", true, "Modulo_TallerAgricola", "=",
						"categoriaEquipo.funcion", true, "Implemento", "=" };
				List<Equipo> lista = businessDelegatorView.findByCriteriaInEquipo(condicion, null, null);
				selectImplemento = new SelectItem[lista.size()];

				int i = 0;
				for (Equipo implemento : lista) {
					selectImplemento[i] = new SelectItem(implemento.getEquipoId(),
							implemento.getCodigo() + "-" + implemento.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectImplemento;
	}

	public void setselectImplemento(SelectItem[] selectImplemento) {
		this.selectImplemento = selectImplemento;
	}

	public SelectItem[] getSelectProductoId() {
		if (productoId == null || productoId.size() == 0) {
			try {
				Long idCompania = new Long(getCompaniaIdSession());

				// Criteria
				List<CatalogProductoDTO> listaProductos = businessDelegatorView
						.consultarCatalogoProductosAgricolas(idCompania);
				selectProductoId = new SelectItem[listaProductos.size()];
				int i = 0;
				for (CatalogProductoDTO listaDTO : listaProductos) {
					selectProductoId[i] = new SelectItem(listaDTO.getProductoId().longValue(), listaDTO.getNombre());
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

	public SelectItem[] getselectTrabajador() {

		if (trabajador == null || trabajador.size() == 0) {

			try {

				Object[] condicion = { "estado", true, "A", "="

				};
				List<Trabajador> lista = businessDelegatorView.findByCriteriaInTrabajador(condicion, null, null);
				selectTrabajador = new SelectItem[lista.size()];

				int i = 0;
				for (Trabajador trabajador : lista) {
					selectTrabajador[i] = new SelectItem(trabajador.getTrabId(), trabajador.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectTrabajador;
	}

	public void setselectTrabajador(SelectItem[] selectTrabajador) {
		this.selectTrabajador = selectTrabajador;
	}

	public SelectItem[] getselectNivel2ClientesId() {

		try {
			Long idCompania = new Long(getCompaniaIdSession());
			Long persEmprId = null;

			if (txtPersEmprId != null && txtPersEmprId.getValue() != null) {
				persEmprId = Long.parseLong(txtPersEmprId.getValue().toString());

				// Criteria
				List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq = businessDelegator2View
						.listaNivel2Clientesmq(idCompania, persEmprId);

				selectNivel2ClientesId = new SelectItem[listaNivel2Clientesmq.size()];
				int i = 0;
				for (ListaNivel2ClientesmqDTO listaNivel2ClientesmqDto : listaNivel2Clientesmq) {
					selectNivel2ClientesId[i] = new SelectItem(listaNivel2ClientesmqDto.getId(),
							listaNivel2ClientesmqDto.getHacienda());
					i++;

				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectNivel2ClientesId;
	}

	public void setselectNivel2ClientesId(SelectItem[] selectNivel2ClientesId) {
		this.selectNivel2ClientesId = selectNivel2ClientesId;
	}

	public SelectItem[] getselectNivel4ClientesId() {

		try {
			Long idCompania = new Long(getCompaniaIdSession());
			String nivel2ClientesId = null;

			if (txtNivel2ClientesId != null && txtNivel2ClientesId.getValue() != null) {
				nivel2ClientesId = txtNivel2ClientesId.getValue().toString();

				// Criteria
				List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq = businessDelegator2View
						.listaNivel4Clientesmq(idCompania, nivel2ClientesId);

				selectNivel4ClientesId = new SelectItem[listaNivel4Clientesmq.size()];
				int i = 0;
				for (ListaNivel4ClientesmqDTO listaNivel4ClientesmqDto : listaNivel4Clientesmq) {
					selectNivel4ClientesId[i] = new SelectItem(listaNivel4ClientesmqDto.getId(),
							listaNivel4ClientesmqDto.getLote());
					i++;

				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectNivel4ClientesId;
	}

	public void setselectNivel4ClientesId(SelectItem[] selectNivel4ClientesId) {
		this.selectNivel4ClientesId = selectNivel4ClientesId;
	}

	public SelectItem[] getSelectCeptoNominaId() {

		if (conceptoNomina == null || conceptoNomina.size() == 0) {

			try {

				// by
				// Criteria
				Object[] condicion = { "estado", true, "A", "=" };
				List<ConceptoNomina> lista = businessDelegatorView.findByCriteriaInConceptoNomina(condicion, null,
						null);
				selectCeptoNominaId = new SelectItem[lista.size()];

				int i = 0;
				for (ConceptoNomina conceptoNomina : lista) {
					selectCeptoNominaId[i] = new SelectItem(conceptoNomina.getCeptoNominaId(),
							conceptoNomina.getNombre());
					i++;

				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return selectCeptoNominaId;
	}

	public void setselectCeptoNominaId(SelectItem[] selectCeptoNominaId) {
		this.selectCeptoNominaId = selectCeptoNominaId;
	}

	public void listener_calcularIngresoTotal() {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnitario = FacesUtils.checkDouble(txtValorUnitario);
		Double cantidad = FacesUtils.checkDouble(txtCantidad);
		Double result = 0.0;
		if (valorUnitario != null && cantidad != null) {
			result = (valorUnitario * cantidad);
			String format = decimalFormat.format(result);
			txtIngresoTotal.setValue(format);
		} else {
			result = 0.0;
			txtIngresoTotal.setValue(result);
		}

	}

	public void listener_calcularCantidad() throws Exception {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);
		Long udadMedId_UdadMed = null;
		UdadMed udadMed = null;
		if (txtUdadMedId_UdadMed.getValue() != null) {
			udadMedId_UdadMed = Long.parseLong(txtUdadMedId_UdadMed.getValue().toString());
			udadMed = businessDelegatorView.getUdadMed(udadMedId_UdadMed);
			String tipoUm = udadMed.getClasificacionUm();
			Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinal);
			Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicial);
			Double result = 0.0;

			if (tipoUm != null) {
				if (tipoUm.equals("HR")) {
					if (horometroFinal != null && horometroInicial != null) {
						result = (horometroFinal - horometroInicial);
						String format = decimalFormat.format(result);
						txtCantidad.setValue(format);
					} else {
						result = 0.0;
						txtCantidad.setValue(result);
					}

				} else {
					result = 0.0;
					txtCantidad.setValue(result);
				}
			} else {
				result = 0.0;
				txtCantidad.setValue(result);
			}

		}
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public Calendar getTxtFechaRegistro() {
		return txtFechaRegistro;
	}

	public void setTxtFechaRegistro(Calendar txtFechaRegistro) {
		this.txtFechaRegistro = txtFechaRegistro;
	}

	public SelectOneMenu getTxtCentCostId_CentCost() {
		return txtCentCostId_CentCost;
	}

	public void setTxtCentCostId_CentCost(SelectOneMenu txtCentCostId_CentCost) {
		this.txtCentCostId_CentCost = txtCentCostId_CentCost;
	}

	public SelectOneMenu getTxtElemCostoId_ElementoCosto() {
		return txtElemCostoId_ElementoCosto;
	}

	public void setTxtElemCostoId_ElementoCosto(SelectOneMenu txtElemCostoId_ElementoCosto) {
		this.txtElemCostoId_ElementoCosto = txtElemCostoId_ElementoCosto;
	}

	public SelectOneMenu getTxtEquipoId_Equipo() {
		return txtEquipoId_Equipo;
	}

	public void setTxtEquipoId_Equipo(SelectOneMenu txtEquipoId_Equipo) {
		this.txtEquipoId_Equipo = txtEquipoId_Equipo;
	}

	public SelectOneMenu getTxtLaborId_Labor() {
		return txtLaborId_Labor;
	}

	public void setTxtLaborId_Labor(SelectOneMenu txtLaborId_Labor) {
		this.txtLaborId_Labor = txtLaborId_Labor;
	}

	public SelectOneMenu getTxtUdadMedId_UdadMed() {
		return txtUdadMedId_UdadMed;
	}

	public void setTxtUdadMedId_UdadMed(SelectOneMenu txtUdadMedId_UdadMed) {
		this.txtUdadMedId_UdadMed = txtUdadMedId_UdadMed;
	}

	public int getActiveTapIndex() {
		return activeTapIndex;
	}

	public void setActiveTapIndex(int activeTapIndex) {
		this.activeTapIndex = activeTapIndex;
	}

	public InputText getTxtNombreNivel4Maq() {
		return txtNombreNivel4Maq;
	}

	public void setTxtNombreNivel4Maq(InputText txtNombreNivel4Maq) {
		this.txtNombreNivel4Maq = txtNombreNivel4Maq;
	}

	public SelectOneMenu getTxtPersEmprId() {
		return txtPersEmprId;
	}

	public void setTxtPersEmprId(SelectOneMenu txtPersEmprId) {
		this.txtPersEmprId = txtPersEmprId;
	}

	public SelectOneMenu getTxtImplemento() {
		return txtImplemento;
	}

	public void setTxtImplemento(SelectOneMenu txtImplemento) {
		this.txtImplemento = txtImplemento;
	}

	public InputText getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(InputText txtProducto) {
		this.txtProducto = txtProducto;
	}

	public SelectOneMenu getTxtTrabId() {
		return txtTrabId;
	}

	public void setTxtTrabId(SelectOneMenu txtTrabId) {
		this.txtTrabId = txtTrabId;
	}

	public SelectOneMenu getTxtNivel2ClientesId() {
		return txtNivel2ClientesId;
	}

	public void setTxtNivel2ClientesId(SelectOneMenu txtNivel2ClientesId) {
		this.txtNivel2ClientesId = txtNivel2ClientesId;
	}

	public SelectOneMenu getTxtNivel4ClientesId() {
		return txtNivel4ClientesId;
	}

	public void setTxtNivel4ClientesId(SelectOneMenu txtNivel4ClientesId) {
		this.txtNivel4ClientesId = txtNivel4ClientesId;
	}

	public Spinner getTxtBonificacionTrabajador() {
		return txtBonificacionTrabajador;
	}

	public void setTxtBonificacionTrabajador(Spinner txtBonificacionTrabajador) {
		this.txtBonificacionTrabajador = txtBonificacionTrabajador;
	}

	public SelectOneMenu getTxtTurno() {
		return txtTurno;
	}

	public void setTxtTurno(SelectOneMenu txtTurno) {
		this.txtTurno = txtTurno;
	}

	public SelectOneMenu getTxtConceptoNominaId() {
		return txtConceptoNominaId;
	}

	public void setTxtConceptoNominaId(SelectOneMenu txtConceptoNominaId) {
		this.txtConceptoNominaId = txtConceptoNominaId;
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

	public InputText getTxtPin() {
		return txtPin;
	}

	public void setTxtPin(InputText txtPin) {
		this.txtPin = txtPin;
	}

	public void listener_ConsultaNombreLaborMaq() {
		Long laborId = null;
		Double valorUnit = 0.0;
		if (txtLaborId_Labor.getValue() != null) {
			laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());
			try {
				Labor labor = businessDelegatorView.getLabor(laborId);
				// txtNombreLaborMaq.setValue(labor.getNombre());
				if (labor.getUdadMedByUdadMedPago() != null) {
					txtUdadMedId_UdadMed.setValue(labor.getUdadMedByUdadMedPago().getUdadMedId());
				}

				if (txtPersEmprId.getValue() != null) {
					Long clientesId = Long.parseLong(txtPersEmprId.getValue().toString());
					PersEmpr persEmpr = businessDelegatorView.getPersEmpr(clientesId);

					String tablaPrecios = "";
					tablaPrecios = persEmpr.getTablaPrecios();

					if (tablaPrecios.equals("1")) {
						valorUnit = labor.getTarifaEstandar();
					}
					if (tablaPrecios.equals("2")) {
						valorUnit = labor.getTarifaEstandar2();
					}
					if (tablaPrecios.equals("3")) {
						valorUnit = labor.getTarifaEstandar3();
					}
					if (tablaPrecios.equals("4")) {
						valorUnit = labor.getTarifaEstandar4();
					}
					if (tablaPrecios.equals("5")) {
						valorUnit = labor.getTarifaEstandar5();
					}
					if (tablaPrecios.equals("6")) {
						valorUnit = labor.getTarifaEstandar6();
					}
					if (tablaPrecios.equals("7")) {
						valorUnit = labor.getTarifaEstandar7();
					}
					if (tablaPrecios.equals("8")) {
						valorUnit = labor.getTarifaEstandar8();
					}
					if (tablaPrecios.equals("9")) {
						valorUnit = labor.getTarifaEstandar9();
					}
					if (tablaPrecios.equals("10")) {
						valorUnit = labor.getTarifaEstandar10();
					}

					txtValorUnitario.setValue(valorUnit);
				}

			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void ConsultarTarifaPagoMaquinaria() throws Exception {
		// Long compania = 1L;

		Long idCompania = new Long(getCompaniaIdSession());
		Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedId_UdadMed);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));
		Long idCliente = FacesUtils.checkLong(txtPersEmprId);
		Long idLabor = FacesUtils.checkLong(txtLaborId_Labor);

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		String pattern = "###.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, simbolos);

		Double valorUnit = 0.0;
		if (txtPersEmprId.getValue() != null && txtLaborId_Labor.getValue() != null) {
			Labor labor = businessDelegatorView.getLabor(idLabor);

			Long clientesId = Long.parseLong(txtPersEmprId.getValue().toString());
			PersEmpr persEmpr = businessDelegatorView.getPersEmpr(clientesId);

			String tablaPrecios = "";
			tablaPrecios = persEmpr.getTablaPrecios();

			if (tablaPrecios.equals("1")) {
				valorUnit = labor.getTarifaEstandar();
			}
			if (tablaPrecios.equals("2")) {
				valorUnit = labor.getTarifaEstandar2();
			}
			if (tablaPrecios.equals("3")) {
				valorUnit = labor.getTarifaEstandar3();
			}
			if (tablaPrecios.equals("4")) {
				valorUnit = labor.getTarifaEstandar4();
			}
			if (tablaPrecios.equals("5")) {
				valorUnit = labor.getTarifaEstandar5();
			}
			if (tablaPrecios.equals("6")) {
				valorUnit = labor.getTarifaEstandar6();
			}
			if (tablaPrecios.equals("7")) {
				valorUnit = labor.getTarifaEstandar7();
			}
			if (tablaPrecios.equals("8")) {
				valorUnit = labor.getTarifaEstandar8();
			}
			if (tablaPrecios.equals("9")) {
				valorUnit = labor.getTarifaEstandar9();
			}
			if (tablaPrecios.equals("10")) {
				valorUnit = labor.getTarifaEstandar10();
			}

			txtValorUnitario.setValue(valorUnit);

			/**
			 * if (idUdadMed != null) { try {
			 * 
			 * 
			 * BigDecimal tarifaPagoMaquina =
			 * businessDelegatorView.consultarTarifaContratista(idCompania, idCliente,
			 * idLabor, 0L, idUdadMed, idFecha, 0.0, "0", 0L, 0L, "0");
			 * 
			 * String format = decimalFormat.format(tarifaPagoMaquina);
			 * txtValorUnitario.setValue(format); if (tarifaPagoMaquina == null) {
			 * BigDecimal tarifaMaquinariaNoEncontrada = new BigDecimal("0");
			 * txtValorUnitario.setValue(tarifaMaquinariaNoEncontrada); }
			 * 
			 * } catch (Exception e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 **/
		} else {
			// pieModel1.set("Sin datos", 0L);
		}
	}

	public void ConsultarTarifaTrabajador() throws Exception {
		// Long compania = 1L;
		Long idCompania = new Long(getCompaniaIdSession());
		// Long idEquipo = FacesUtils.checkLong(txtEquipoId_Equipo);
		Long idUdadMed = FacesUtils.checkLong(txtUdadMedId_UdadMed);
		Date idFecha = (FacesUtils.checkDate(txtFechaRegistro));
		// Long idCliente = FacesUtils.checkLong(txtPersEmprId);
		Long idLabor = FacesUtils.checkLong(txtLaborId_Labor);

		Double valorUnitarioTrabajador = businessDelegatorView
				.consultarTarifaLaborRendimientoBase(idCompania, 0L, idLabor, 0L, idUdadMed, idFecha).doubleValue();

		txtValorUnitarioTrabajador.setValue(valorUnitarioTrabajador);

	}

	public void CalcularValorTotalTrabajador() throws Exception {
		Double cantidad = FacesUtils.checkDouble(txtCantidad);

		Double valorUnitarioTrabajador = FacesUtils.checkDouble(txtValorUnitarioTrabajador);
		if (cantidad != null && valorUnitarioTrabajador != null) {
			txtValorTotalTrabajador.setValue(valorUnitarioTrabajador * cantidad);
		}else {
			txtValorTotalTrabajador.setValue(0.0);
		}
	}

	public ConsultaServiciosRealizadosMaquinariaDTO getSelectedDatServRealizadosEquipo3() {
		return selectedDatServRealizadosEquipo3;
	}

	public void setSelectedDatServRealizadosEquipo3(
			ConsultaServiciosRealizadosMaquinariaDTO selectedDatServRealizadosEquipo3) {
		this.selectedDatServRealizadosEquipo3 = selectedDatServRealizadosEquipo3;
	}

	public SelectOneMenu getTxtEquipoId_EquipoConsulta() {
		return txtEquipoId_EquipoConsulta;
	}

	public void setTxtEquipoId_EquipoConsulta(SelectOneMenu txtEquipoId_EquipoConsulta) {
		this.txtEquipoId_EquipoConsulta = txtEquipoId_EquipoConsulta;
	}

	public InputNumber getTxtAuxilioTransporte() {
		return txtAuxilioTransporte;
	}

	public void setTxtAuxilioTransporte(InputNumber txtAuxilioTransporte) {
		this.txtAuxilioTransporte = txtAuxilioTransporte;
	}

	public DatServRealizadosEquipoDet getEntity() {
		return entity;
	}

	public void setEntity(DatServRealizadosEquipoDet entity) {
		this.entity = entity;
	}

	public LogDatServRealizadosEquipo getEntityLog() {
		return entityLog;
	}

	public void setEntityLog(LogDatServRealizadosEquipo entityLog) {
		this.entityLog = entityLog;
	}

	public String getCambioItemPin() {
		return cambioItemPin;
	}

	public void setCambioItemPin(String cambioItemPin) {
		this.cambioItemPin = cambioItemPin;
	}

	public String getCodEquipoId() {
		return codEquipoId;
	}

	public void setCodEquipoId(String codEquipoId) {
		this.codEquipoId = codEquipoId;
	}

	public Long getIdReg() {
		return idReg;
	}

	public void setIdReg(Long idReg) {
		this.idReg = idReg;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	public InputText getTxtConsecutivoRdl() {
		return txtConsecutivoRdl;
	}

	public void setTxtConsecutivoRdl(InputText txtConsecutivoRdl) {
		this.txtConsecutivoRdl = txtConsecutivoRdl;
	}

	public InputText getTxtValorUnitarioTrabajador() {
		return txtValorUnitarioTrabajador;
	}

	public void setTxtValorUnitarioTrabajador(InputText txtValorUnitarioTrabajador) {
		this.txtValorUnitarioTrabajador = txtValorUnitarioTrabajador;
	}

	public InputText getTxtValorTotalTrabajador() {
		return txtValorTotalTrabajador;
	}

	public void setTxtValorTotalTrabajador(InputText txtValorTotalTrabajador) {
		this.txtValorTotalTrabajador = txtValorTotalTrabajador;
	}

	public SelectItem[] getSelectDatPlanServicioMaqRegistro() {

		try {

			List<ConsultaProgLaboresMaqDTO> lista = null;
			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");

			Long flagEquipo = 1L;
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);
			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();

			Date fechaInicial = null;
			Date fechaFinal = null;

			GregorianCalendar calendarInicial = new GregorianCalendar();
			calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -90);

			GregorianCalendar calendarFinal = new GregorianCalendar();

			calendarFinal.setTime(date); // Configuramos la fecha que se
			calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 1);

			lista = businessDelegator2View.pr_consulta_lista_prog_maquinaria(compania, fechaFinalDateRegistro,
					calendarFinal.getTime());

			if (lista != null) {
				selectDatPlanServicioMaqRegistro = new SelectItem[lista.size()];

				int i = 0;
				for (ConsultaProgLaboresMaqDTO dto : lista) {
					selectDatPlanServicioMaqRegistro[i] = new SelectItem(dto.getId_programa().longValue(),
							dto.getId_programa() + " *Labor* " + dto.getNom_labor() + " *Hda* " + dto.getNom_finca()
									+ " *Ste* " + dto.getNom_lote()

					);
					i++;

				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatPlanServicioMaqRegistro;
	}

	public void setSelectDatPlanServicioMaqRegistro(SelectItem[] selectDatPlanServicioMaqRegistro) {
		this.selectDatPlanServicioMaqRegistro = selectDatPlanServicioMaqRegistro;
	}

	public List<DatPlanServiciosMqdet> getDatPlanServicioMaq() {
		return datPlanServicioMaq;
	}

	public void setDatPlanServicioMaq(List<DatPlanServiciosMqdet> datPlanServicioMaq) {
		this.datPlanServicioMaq = datPlanServicioMaq;
	}

	public SelectOneMenu getTxtIdProgramacion() {
		return txtIdProgramacion;
	}

	public void setTxtIdProgramacion(SelectOneMenu txtIdProgramacion) {
		this.txtIdProgramacion = txtIdProgramacion;
	}

	public void listener_Planilla() throws Exception {
		Long idPlanilla = Long.parseLong(txtDatServRealizadosEquipoId.getValue().toString());
		DatServRealizadosEquipo datServRealizadosEquipo = null;
		if (idPlanilla != null) {

			datServRealizadosEquipo = businessDelegatorView.getDatServRealizadosEquipo(idPlanilla);
			try {
				txtFechaRegistro.setValue(datServRealizadosEquipo.getFechaRegistro());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_ConsultaProgramacion() throws Exception {
		Long idProgramacion = Long.parseLong(txtIdProgramacion.getValue().toString());
		DatPlanServiciosMqdet datPlanServiciosMqdet = null;
		if (idProgramacion != null) {
			idProgramacion = Long.parseLong(txtIdProgramacion.getValue().toString());
			datPlanServiciosMqdet = businessDelegator2View.getDatPlanServiciosMqdet(idProgramacion);
			try {
				txtPersEmprId.setValue(datPlanServiciosMqdet.getPersEmpr().getPersEmprId());
				txtNivel2ClientesId.setValue(datPlanServiciosMqdet.getNivel2Clientesmq().getNivel2ClientesmqId());
				Nivel4Clientesmq nivel4Clientesmq = businessDelegator2View
						.getNivel4Clientesmq(datPlanServiciosMqdet.getNivel4ClientesmqId().getNivel4ClientesmqId());
				txtNivel4ClientesId.setValue(nivel4Clientesmq.getNivel4ClientesmqId());
				txtLaborId_Labor.setValue(datPlanServiciosMqdet.getLabor().getLaborId());
				txtUdadMedId_UdadMed.setValue(datPlanServiciosMqdet.getUdadMed().getUdadMedId());
				txtCantidad.setValue(datPlanServiciosMqdet.getCantidadPendiente());
			} catch (Exception e) {
				FacesUtils.addErrorMessage(e.getMessage());
			}
		}
	}

	public void listener_CalculoCantidadM3() {
		try {
			Long laborId = null;
			Double valorUnit = 0.0;
			Double rendimiento = 0.0;
			Double horometroInicial = FacesUtils.checkDouble(txtHorometroInicial);
			Double horometroFinal = FacesUtils.checkDouble(txtHorometroFinal);
			Double cantidad = FacesUtils.checkDouble(txtCantidad);
			Double horas = 0.0;
			if (txtLaborId_Labor.getValue() != null) {
				laborId = Long.parseLong(txtLaborId_Labor.getValue().toString());

				Labor labor = businessDelegatorView.getLabor(laborId);
				// txtNombreLaborMaq.setValue(labor.getNombre());
				if (labor.getRendimientoMq() == null) {

					txtCantidad.setValue(cantidad);
				} else {
					if (labor.getRendimientoMq() > 0) {
						rendimiento = labor.getRendimientoMq();
						horas = horometroFinal - horometroInicial;
						cantidad = horas * rendimiento;
						txtCantidad.setValue(cantidad);
					}
				}

			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}

	public void onCellEditEventosServicios(CellEditEvent evt) throws Exception {

		selectedDatServRealizadosEquipo2 = (ConsultaServiciosRealizadosMaquinariaDTO) (evt.getComponent()
				.getAttributes().get("selectedDatServRealizadosEquipo2"));

		Long datServRealizadosEquipoDetId = selectedDatServRealizadosEquipo2.getIdRegistro().longValue();

		if (!selectedDatServRealizadosEquipo2.getEstatusRegistro().equals("facturado")) {
			String columnaCell = evt.getColumn().getHeaderText();

			Object oldValue = evt.getOldValue();
			Object newValue = evt.getNewValue();

			if (newValue != null) {

				entity = null;
				entity = businessDelegatorView.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);

				/**
				 * if (columnaCell.equals("Maq")) {
				 * 
				 * Long maqId = new Long(evt.getNewValue().toString()); Equipo e =
				 * businessDelegatorView.getEquipo(maqId);
				 * 
				 * entity.setEquipo(e);
				 * 
				 * }
				 **/

				if (columnaCell.equals("HrInic")) {

					entity.setHorometroInicial(Double.valueOf(evt.getNewValue().toString()));

					Double horInicial = Double.valueOf(evt.getNewValue().toString());

					Double horFinal = entity.getHorometroFinal();
					Double horasTotal = horFinal - horInicial;

					entity.setHorometroTotal(horasTotal);
					entity.setHorasTotal(horasTotal);

				}

				if (columnaCell.equals("HrFin")) {

					entity.setHorometroFinal(Double.valueOf(evt.getNewValue().toString()));

					Double horFinal = Double.valueOf(evt.getNewValue().toString());

					Double horInicial = entity.getHorometroInicial();
					Double horasTotal = horFinal - horInicial;

					entity.setHorometroTotal(horasTotal);
					entity.setHorasTotal(horasTotal);

				}

				if (columnaCell.equals("T. Horas")) {

					entity.setHorasTotal(Double.valueOf(evt.getNewValue().toString()));
					entity.setHorometroTotal(Double.valueOf(evt.getNewValue().toString()));

				}

				if (columnaCell.equals("Cantidad")) {

					entity.setCantidad(Double.valueOf(evt.getNewValue().toString()));
					Double cantidad = Double.valueOf(evt.getNewValue().toString());
					Double tarifa = entity.getValorUnitario();

					Double ingresoTotal = cantidad * tarifa;
					entity.setIngresoTotal(ingresoTotal);

					Double valorUnitarioTrabajador = entity.getValor_unitario_trabajador();
					Double valorTotalTrabajador = cantidad * valorUnitarioTrabajador;

					entity.setValor_total_trabajador(valorTotalTrabajador);
				}

				if (columnaCell.equals("Tarifa")) {

					entity.setValorUnitario(Double.valueOf(evt.getNewValue().toString()));
					Double tarifa = Double.valueOf(evt.getNewValue().toString());
					Double cantidad = entity.getCantidad();

					Double ingresoTotal = cantidad * tarifa;
					entity.setIngresoTotal(ingresoTotal);

				}

				if (columnaCell.equals("VLR. Total")) {

					entity.setIngresoTotal(Double.valueOf(evt.getNewValue().toString()));

				}

				if (columnaCell.equals("VLR. Unit. Oper")) {

					entity.setValor_unitario_trabajador(Double.valueOf(evt.getNewValue().toString()));
					Double tarifaTrab = Double.valueOf(evt.getNewValue().toString());
					Double cantidad = entity.getCantidad();

					Double valorTotalTrabajador = cantidad * tarifaTrab;
					entity.setValor_total_trabajador(valorTotalTrabajador);

				}
				if (columnaCell.equals("VLR. Tot. Oper")) {

					entity.setValor_total_trabajador(Double.valueOf(evt.getNewValue().toString()));

				}

				if (columnaCell.equals("Turno")) {

					entity.setTurno(evt.getNewValue().toString());

				}

				else if (columnaCell.equals("Id Planilla")) {

					Long datServRealizadosEquipoId2 = new Long(evt.getNewValue().toString());
					DatServRealizadosEquipo datServRealizadosEquipo = businessDelegatorView
							.getDatServRealizadosEquipo(datServRealizadosEquipoId2);
					if (datServRealizadosEquipo != null) {
						entity.setDatServRealizadosEquipoId(datServRealizadosEquipo);
					}
				}

				else if (columnaCell.equals("Id Programa")) {

					Long datPlanServicioMaq = new Long(evt.getNewValue().toString());
					DatPlanServiciosMqdet e = businessDelegatorView.getDatPlanServiciosMqdet(datPlanServicioMaq);

					entity.setDat_plan_servicios_mqdet_id(e);
					if (e.getLabor() != null) {
						entity.setLabor(e.getLabor());
						Double valorUnitarioTrabajador = 0.0;
						Double cantidad = entity.getCantidad();
						if (e.getUdadMed() != null && e.getLabor() != null) {
							Long idCompania = new Long(getCompaniaIdSession());
							Long idUdadMed = e.getUdadMed().getUdadMedId();
							Date idFecha = selectedDatServRealizadosEquipo2.getFechaRegistro();
							Long idLabor = e.getLabor().getLaborId();

							valorUnitarioTrabajador = businessDelegatorView.consultarTarifaLaborRendimientoBase(
									idCompania, 0L, idLabor, 0L, idUdadMed, idFecha).doubleValue();
						}

						entity.setValor_unitario_trabajador(valorUnitarioTrabajador);
						Double valorTotalTrabajador = cantidad * valorUnitarioTrabajador;
						entity.setValor_total_trabajador(valorTotalTrabajador);

					}
					if (e.getPersEmpr() != null) {
						entity.setPersEmpr(e.getPersEmpr());
					}

					if (e.getNivel2Clientesmq() != null) {
						entity.setNivel2ClientesId(e.getNivel2Clientesmq());
					}

					if (e.getNivel4ClientesmqId() != null) {
						entity.setNivel4ClientesId(e.getNivel4ClientesmqId());
					}

				}

				// entity =
				// businessDelegatorView.getDatServRealizadosEquipo(datServRealizadosEquipoId);
				// entity.setDatServRealizadosEquipoId(entity);
				businessDelegatorView.updateDatServRealizadosEquipoDet(entity);

				Long idmaq = selectedDatServRealizadosEquipo2.getEquipoId().longValue();
				Long consecutivoPin = selectedDatServRealizadosEquipo2.getPin().longValue();

				if (idmaq != null) {
					Object[] condicionCtrlPines = { "equipo.equipoId", true, idmaq, "=" };
					List<DatCtrlMaqPines> listaCtrlPines = (idmaq != null)
							? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicionCtrlPines, null, null)
							: null;
					if (listaCtrlPines != null && listaCtrlPines.size() > 0) {
						DatCtrlMaqPines datCtrlMaqPines = listaCtrlPines.get(0);

						Long consecutivoInicial = datCtrlMaqPines.getConsecutivoPin();
						if (consecutivoInicial >= consecutivoPin) {
							businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoInicial);
						} else {
							businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoPin);
						}

					}
				}

				/**** actualizo la programación ***/

				if (entity.getLabor() != null) {
					Long laborId = entity.getLabor().getLaborId();
					Labor labor = businessDelegatorView.getLabor(laborId);
					if (labor.getClaseLabor() != null) {
						if (!labor.getClaseLabor().equals("Transporte")) {
							Long idPrograma = 0L;
							if (entity.getDat_plan_servicios_mqdet_id() != null) {
								idPrograma = entity.getDat_plan_servicios_mqdet_id().getDatPlanServiciosMqdetId();
								businessDelegator2View.pr_actualizar_prog_maquinaria(idPrograma);

							}
						}
					}
				}
				entity = null;

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se cambio la información de forma exitosa"));
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"El registro ya esta facturado, no podrá ser modificado"));
		}
	}

	public SelectItem[] getSelectDatPlanServicioMaq() {

		try {

			List<ConsultaProgLaboresMaqDTO> lista = null;

			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");

			Long flagEquipo = 1L;
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaFinalDateRegistro = null;
			Date fechaOriginal = foriginal.parse("1970-01-01");
			String fsalida = sdf.format(fechaOriginal);

			GregorianCalendar calendarInicial = new GregorianCalendar();
			calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -90);

			fechaFinalDateRegistro = sdf.parse(fsalida);
			Date date = new Date();

			Date fechaInicial = null;
			Date fechaFinal = null;

			GregorianCalendar calendarFinal = new GregorianCalendar();

			calendarFinal.setTime(date); // Configuramos la fecha que se
			calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 1);

			lista = businessDelegator2View.pr_consulta_lista_prog_maquinaria(compania, calendarInicial.getTime(),
					calendarFinal.getTime());

			if (lista != null) {
				selectDatPlanServicioMaq = new SelectItem[lista.size()];

				int i = 0;
				for (ConsultaProgLaboresMaqDTO dto : lista) {
					selectDatPlanServicioMaq[i] = new SelectItem(dto.getId_programa().longValue(),
							dto.getId_programa() + " *Labor* " + dto.getNom_labor() + " *Hda* " + dto.getNom_finca()
									+ " *Ste* " + dto.getNom_lote()

					);
					i++;

				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatPlanServicioMaq;
	}

	public void setSelectDatPlanServicioMaq(SelectItem[] selectDatPlanServicioMaq) {
		this.selectDatPlanServicioMaq = selectDatPlanServicioMaq;
	}

	public SelectItem[] getSelectDatServRealizadosEquipo() {

		try {

			List<ConsultaServiciosRealizadosMaquinariaDTO> lista = null;

			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaInicial));

			GregorianCalendar calendarInicial = new GregorianCalendar();
			GregorianCalendar calendarFinal = new GregorianCalendar();

			if (fechaInicial != null) {
				calendarInicial.setTime(fechaInicial); // Configuramos la fecha que se
				calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -15);

				calendarFinal.setTime(fechaInicial); // Configuramos la fecha que se
				calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 15);

				String equipoId = FacesUtils.checkString(txtEquipoId_EquipoConsulta);

				lista = businessDelegator2View.consultaServRealizadosMq(compania, calendarInicial.getTime(),
						calendarFinal.getTime(), equipoId, 0L);

				if (lista != null) {
					selectDatServRealizadosEquipo = new SelectItem[lista.size()];

					int i = 0;
					for (ConsultaServiciosRealizadosMaquinariaDTO consultaServiciosRealizadosMaquinariaDTO : lista) {
						selectDatServRealizadosEquipo[i] = new SelectItem(
								consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id().longValue(),
								consultaServiciosRealizadosMaquinariaDTO.getCodEquipo() + " *ID* "
										+ consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id()
										+ " *Fecha* "
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(8, 10)
										+ "/"
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(5, 7)
										+ "/"
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(0, 4)
										+ " *Consec* " + consultaServiciosRealizadosMaquinariaDTO.getConsecutivo()

						);
						i++;

					}
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatServRealizadosEquipo;
	}

	public void setSelectDatServRealizadosEquipo(SelectItem[] selectDatServRealizadosEquipo) {
		this.selectDatServRealizadosEquipo = selectDatServRealizadosEquipo;
	}

	public SelectItem[] getSelectDatServRealizadosEquipo2() {

		try {

			List<ConsultaServiciosRealizadosMaquinariaDTO> lista = null;

			Long compania = new Long(getCompaniaIdSession());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat anio = new SimpleDateFormat("yyyy");
			Date fechaInicial = null;
			Date fechaFinal = null;
			fechaInicial = (FacesUtils.checkDate(txtFechaRegistro));

			GregorianCalendar calendarInicial = new GregorianCalendar();
			GregorianCalendar calendarFinal = new GregorianCalendar();

			if (fechaInicial != null) {
				calendarInicial.setTime(fechaInicial); // Configuramos la fecha que se
				calendarInicial.add(GregorianCalendar.DAY_OF_YEAR, -15);

				calendarFinal.setTime(fechaInicial); // Configuramos la fecha que se
				calendarFinal.add(GregorianCalendar.DAY_OF_YEAR, 15);

				String equipoId = FacesUtils.checkString(txtEquipoId_Equipo);

				lista = businessDelegator2View.consultaServRealizadosMq(compania, calendarInicial.getTime(),
						calendarFinal.getTime(), equipoId, 0L);

				if (lista != null) {
					selectDatServRealizadosEquipo2 = new SelectItem[lista.size()];

					int i = 0;
					for (ConsultaServiciosRealizadosMaquinariaDTO consultaServiciosRealizadosMaquinariaDTO : lista) {
						selectDatServRealizadosEquipo2[i] = new SelectItem(
								consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id().longValue(),
								consultaServiciosRealizadosMaquinariaDTO.getCodEquipo() + " *ID* "
										+ consultaServiciosRealizadosMaquinariaDTO.getDat_serv_realizados_equipo_id()
										+ " *Fecha* "
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(8, 10)
										+ "/"
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(5, 7)
										+ "/"
										+ consultaServiciosRealizadosMaquinariaDTO.getFechaRegistro().toString()
												.substring(0, 4)
										+ " *Consec* " + consultaServiciosRealizadosMaquinariaDTO.getConsecutivo()

						);
						i++;

					}
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return selectDatServRealizadosEquipo2;
	}

	public void setSelectDatServRealizadosEquipo2(SelectItem[] selectDatServRealizadosEquipo2) {
		this.selectDatServRealizadosEquipo2 = selectDatServRealizadosEquipo2;
	}

	public InputText getTxtCantidadTrabajador() {
		return txtCantidadTrabajador;
	}

	public void setTxtCantidadTrabajador(InputText txtCantidadTrabajador) {
		this.txtCantidadTrabajador = txtCantidadTrabajador;
	}

	public SelectOneMenu getTxtUnidadMedidaTrabajador() {
		return txtUnidadMedidaTrabajador;
	}

	public void setTxtUnidadMedidaTrabajador(SelectOneMenu txtUnidadMedidaTrabajador) {
		this.txtUnidadMedidaTrabajador = txtUnidadMedidaTrabajador;
	}

}
