package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.control.IDatPlanLaborDetLogic;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.ManoDeObra;
import co.com.arcosoft.rest.service.dto.ServiciosRealizadosMaqDTO;
import co.com.arcosoft.utilities.FacesUtils;

@Controller
@RequestMapping("/transacciones")
public class WsServiciosRealizadosMaq {

	private static final Logger logger = LoggerFactory.getLogger(WsServiciosRealizadosMaq.class);

	private DatServRealizadosEquipo entity = null;
	List<DatServRealizadosEquipoDetDTO> dataServRealizadosDet = null;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	@Autowired
	IDatPlanLaborDetLogic planLaborLogic;

	@Autowired
	ILaborLogic laborlogic;

	@Autowired
	ITrabajadorLogic trabajadorLogic;

	boolean existeOT = false;

	@RequestMapping(value = "/guardarServiciosRealizadosMaq", method = RequestMethod.POST)
	public ResponseEntity<String> guardarServiciosRealizadosMaq(@RequestBody ServiciosRealizadosMaqDTO servRealizado)
			throws Exception {

		Labor labor = null;
		PersEmpr cliente = null;
		Nivel2Clientesmq nivel2Hacienda = null;
		Nivel4Clientesmq nivel4Lote = null;
		DatServRealizadosEquipoDetDTO detDto = null;
		UdadMed unidadpago = null;
		Trabajador trabajador = null;
		Date fechaFinalDateRegistro = null;
		Long consecutivo = null;
		ConceptoNomina conceptoNomina = null;
		DatPlanServiciosMqdet entityOrdenTrabajo = null;
		Equipo equipo = null;
		Equipo implemento = null;
		Long equipoId = null;
		Long implementoId = null;
		String nombreEquipo = null;
		Long idlabor = null;
		Long operarioId = 0l;

		DatCtrlMaqPines datCtrlMaqPines = null;
		if (servRealizado != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat foriginalRecepcion = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = servRealizado.getFecha_registro();
			String fecha = foriginal.format(fechaOriginal);
			String fecha2 = foriginalRecepcion.format(fechaOriginal);
			Date fechaOriginalRecepcion = foriginalRecepcion.parse(fecha2);
			String fsalida = sdf.format(fechaOriginalRecepcion);
			fechaFinalDateRegistro = sdf.parse(fsalida);

			Object[] condicionPlanilla = { "datServRealizadosEquipoId.fechaRegistro", true, fecha, "=",
					"horometroInicial", true,servRealizado.getHorometro_inicial(), "=",
					"horometroFinal", true,	servRealizado.getHorometro_final(), "=",
					"usuarioDigitacion", true,	servRealizado.getUsuario_digitacion(), "=",
					"labor.laborId", true, servRealizado.getLabor_id(), "=",
					"nivel2ClientesId.nivel2ClientesmqId", true, servRealizado.getNivel2_clientesmq_id(), "=",
					"nivel4ClientesId.nivel4ClientesmqId", true, servRealizado.getNivel4_clientesmq_id(), "=",
					"cantidad", true, servRealizado.getCantidad_pago(), "=",
			};

			List<DatServRealizadosEquipoDet> listaPlanilla = (fecha != null)
					? businessDelegatorView.findByCriteriaInDatServRealizadosEquipoDet(condicionPlanilla, null, null)
					: null;
			if (listaPlanilla != null && listaPlanilla.size() > 0) {

			} else {

				entity = new DatServRealizadosEquipo();

				Long udadMedPlan = null;
				if (servRealizado.getDat_plan_servicios_mqdet_id() != null) {

					Long dat_plan_servicios_mqdet_id = servRealizado.getDat_plan_servicios_mqdet_id();
					Object[] condicionOt = { "datPlanServiciosMqdetId", true, dat_plan_servicios_mqdet_id, "=" };
					List<DatPlanServiciosMqdet> listaOt = (dat_plan_servicios_mqdet_id != null)
							? businessDelegatorView.findByCriteriaInDatPlanServiciosMqdet(condicionOt, null, null)
							: null;
					if (listaOt != null && listaOt.size() > 0) {
						entityOrdenTrabajo = listaOt.get(0);

						idlabor = entityOrdenTrabajo.getLabor().getLaborId();
						Long idCliente = entityOrdenTrabajo.getPersEmpr().getPersEmprId();
						Long idNivel4Lote = entityOrdenTrabajo.getNivel4ClientesmqId().getNivel4ClientesmqId();
						Long idNivel2Hacienda = entityOrdenTrabajo.getNivel2Clientesmq().getNivel2ClientesmqId();
						udadMedPlan = entityOrdenTrabajo.getUdadMed().getUdadMedId();
						labor = businessDelegatorView.getLabor(idlabor);

						cliente = businessDelegatorView.getPersEmpr(idCliente);
						nivel2Hacienda = businessDelegator2View.getNivel2Clientesmq(idNivel2Hacienda);
						nivel4Lote = businessDelegator2View.getNivel4Clientesmq(idNivel4Lote);
						unidadpago = businessDelegatorView.getUdadMed(udadMedPlan);

					}

					if (servRealizado.getObservacion() != null) {
						entity.setObservacion(servRealizado.getObservacion());
					}

					if (servRealizado.getEquipo_id() != null) {
						equipoId = servRealizado.getEquipo_id();
						Object[] condicionEquipo = { "equipoId", true, equipoId, "=" };
						List<Equipo> listaEquipo = (equipoId != null)
								? businessDelegatorView.findByCriteriaInEquipo(condicionEquipo, null, null)
								: null;
						if (listaEquipo != null && listaEquipo.size() > 0) {
							equipo = listaEquipo.get(0);
							nombreEquipo = equipo.getNombre();
						}
					}

					if (servRealizado.getId_implemento() != null) {
						implementoId = servRealizado.getId_implemento();
						Object[] condicionImplemento = { "equipoId", true, implementoId, "=" };
						List<Equipo> listaImplemento = (implementoId != null)
								? businessDelegatorView.findByCriteriaInEquipo(condicionImplemento, null, null)
								: null;
						if (listaImplemento != null && listaImplemento.size() > 0) {
							implemento = listaImplemento.get(0);
						}
					}

					entity.setEstado("A");
					entity.setFechaRegistro(fechaOriginal);

					GregorianCalendar calendario = new GregorianCalendar();
					calendario.setTime(fechaOriginal);
					long anioRegistro = calendario.get(java.util.Calendar.YEAR);

					entity.setFechaCreacion(new Date());
					entity.setUsuarioDigitacion(servRealizado.getUsuario_digitacion());
					Date date = new Date();
					String estado = "A";
					entity.setEstado(estado);
					entity.setCompania(servRealizado.getCompania());

					entity.setEquipo(equipo);
					if(equipo!=null && equipo.getCentCost()!=null) {
						
						Long centCostId = equipo.getCentCost();
						CentCost centCost = businessDelegatorView.getCentCost(centCostId);
						entity.setCentCost(centCost);
					}
					
					// entity.setConsecutivo(businessDelegatorView.consultarConsecutivoServRealizados(servRealizado.getCompania(),
					// equipoId));
					entity.setIndicador_vuelta_medidor(equipo.getIndicador_vuelta_medidor());
					entity.setFechaCreacion(date);

					// entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));

					entity.setOrigenDatos("Modulo_TallerAgricola");
					entity.setPuedeEditarPin("No");
					entity.setNumFactura(0L);
					
					// DAT_PLANILLA_NOMINA_DET

					dataServRealizadosDet = new ArrayList<DatServRealizadosEquipoDetDTO>();
					detDto = new DatServRealizadosEquipoDetDTO();

					if (servRealizado.getUsuario_digitacion() != null) {

						Long usuarioId = servRealizado.getUsuario_digitacion();
						Object[] condicionTrabajador = { "usuario_asociado", true, usuarioId, "=" };
						List<Trabajador> listaTrabajador = (usuarioId != null)
								? businessDelegatorView.findByCriteriaInTrabajador(condicionTrabajador, null, null)
								: null;
						if (listaTrabajador != null && listaTrabajador.size() > 0) {
							trabajador = listaTrabajador.get(0);
							operarioId = trabajador.getTrabId();
						}
					}

					conceptoNomina = businessDelegatorView.getConceptoNomina(1L);

					detDto.setLaborId_Labor(labor);
					detDto.setNivel2ClientesId(nivel2Hacienda);
					detDto.setNivel4ClientesId(nivel4Lote);
					detDto.setDat_plan_servicios_mqdet_id(entityOrdenTrabajo);
					detDto.setCantidad(servRealizado.getCantidad_pago().doubleValue());
					detDto.setUdadMedId_UdadMed(unidadpago);
					if (servRealizado.getObservacion() != null) {
						detDto.setObservacion(servRealizado.getObservacion());
					}

					// detDto.setUdadMedProd(
					// (servRealizado.getUdadMedProd() != null) ?
					// servRealizado.getUdadMedProd().longValue() : null);
					detDto.setTrabajador(trabajador);
					detDto.setPersEmpr(cliente);
					detDto.setConceptoNominaId(conceptoNomina);
					detDto.setHorometroInicial(servRealizado.getHorometro_inicial());
					detDto.setHorometroFinal(servRealizado.getHorometro_final());
					Double totalHorometro = servRealizado.getHorometro_final() - servRealizado.getHorometro_inicial();
					detDto.setHorometroTotal(totalHorometro);
					detDto.setHorasTotal(totalHorometro);
					detDto.setEstadoFactura("Sin facturar");
					detDto.setTurno(servRealizado.getTurno());
					detDto.setImplemento(implemento);
				
					if (servRealizado.getReportarNovedadParada() != null) {
						detDto.setReportarNovedadParada(servRealizado.getReportarNovedadParada());
					}

					Double valorUnit = 0.0;
					String tablaPrecios = "";
					tablaPrecios = cliente.getTablaPrecios();

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
					Double cantidad = servRealizado.getCantidad_pago().doubleValue();
					detDto.setValorUnitario(valorUnit);
					Double ingresoTotal = valorUnit * cantidad;
					ingresoTotal = (double) Math.round((ingresoTotal) * 1000) / 1000;
					detDto.setIngresoTotal(ingresoTotal);

					Double valorUnitarioTrabajador = businessDelegatorView
							.consultarTarifaLaborRendimientoBase(servRealizado.getCompania(), 0L, labor.getLaborId(),
									0L, unidadpago.getUdadMedId(), fechaOriginal)
							.doubleValue();

					Double valorTotalTrabajador = 0.0;
					if (cantidad <= 0.001) {
						valorTotalTrabajador = valorUnitarioTrabajador;
					} else {
						valorTotalTrabajador = valorUnitarioTrabajador * cantidad;
					}

					detDto.setCantidadTrabajador(cantidad);

					detDto.setValor_unitario_trabajador(valorUnitarioTrabajador);
					detDto.setValor_total_trabajador(valorTotalTrabajador);
					detDto.setUnidadMedidaTrabajador(udadMedPlan);

					detDto.setTipoMttoTexto(servRealizado.getTipoMtto());
					
					if (servRealizado.getReportarNovedadParada() != null) {
						if(servRealizado.getReportarNovedadParada().equals("NO")) {
							detDto.setHorometroMtto(0.0);
						}else {
							detDto.setHorometroMtto(servRealizado.getHorometroMtto());
						}
					
					}
					
					

					dataServRealizadosDet.add(detDto);

					Long ultimoId = businessDelegator2View.pr_ultima_planilla_servicios_maq(servRealizado.getCompania(),
							fechaOriginal, equipoId, operarioId);

					if (ultimoId != 0) {

						Object[] condicion = { "datServRealizadosEquipoId", true, ultimoId, "=" };
						List<DatServRealizadosEquipo> lista = (ultimoId != null)
								? businessDelegatorView.findByCriteriaInDatServRealizadosEquipo(condicion, null, null)
								: null;

						if (lista != null && lista.size() > 0) {
							entity = lista.get(0);
						}

						consecutivo = entity.getConsecutivo().longValue();
						businessDelegatorView.updateDatServRealizadosEquipo(entity, dataServRealizadosDet, null);

						if (servRealizado.getEquipo_id() != null) {
							equipoId = servRealizado.getEquipo_id();
							Object[] condicionCtrlPines = { "equipo.equipoId", true, equipoId, "=" };
							List<DatCtrlMaqPines> listaCtrlPines = (equipoId != null)
									? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicionCtrlPines, null,
											null)
									: null;
							if (listaCtrlPines != null && listaCtrlPines.size() > 0) {
								datCtrlMaqPines = listaCtrlPines.get(0);

								Long consecutivoInicial = datCtrlMaqPines.getConsecutivoPin();
								if (consecutivoInicial >= consecutivo) {
									businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(equipoId,
											consecutivoInicial);
								} else {
									businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(equipoId, consecutivo);
								}

							}
						}

					} else {

						entity.setConsecutivo(businessDelegatorView
								.consultarConsecutivoServRealizados(servRealizado.getCompania(), equipoId));
						consecutivo = entity.getConsecutivo().longValue();

						businessDelegatorView.saveDatServRealizadosEquipo(entity, dataServRealizadosDet, null);
						Long actualizaCtrPin = businessDelegator2View.pr_actualiza_maq_ctrpin_consecutivo(equipoId,
								consecutivo);

					}

					Double cantidadRealizadaAnterior = 0.0;
					if (entityOrdenTrabajo.getCantidadRealizada() != null) {
						cantidadRealizadaAnterior = entityOrdenTrabajo.getCantidadRealizada();
					}
					Double cantidadRealizadaFinal = cantidadRealizadaAnterior + cantidad;

					entityOrdenTrabajo.setCantidadRealizada(cantidadRealizadaFinal);

					Double cantidadPlan = entityOrdenTrabajo.getCantidadPlan();
					Double cantidadPendiente = cantidadPlan - cantidadRealizadaFinal;
					entityOrdenTrabajo.setCantidadPendiente(cantidadPendiente);

					if (labor.getClaseLabor() != null) {
						if (!labor.getClaseLabor().equals("Transporte")) {
							if (cantidadRealizadaFinal >= cantidadPlan) {
								entityOrdenTrabajo.setConcluido("SI");
							}
						} else {
							entityOrdenTrabajo.setConcluido("NO");
						}
					}

					businessDelegator2View.updateDatPlanServiciosMqdet(entityOrdenTrabajo);

					labor = null;
					nivel2Hacienda = null;
					// nivel4Lote = null;
					detDto = null;
					unidadpago = null;
					trabajador = null;
					dataServRealizadosDet = null;
					entity = null;
					fechaFinalDateRegistro = null;
					existeOT = false;
					cliente = null;
					equipo = null;

				}
			}
			return new ResponseEntity<String>(
					"El registro de labor mecanizada fue creado en AgroView  para la máquina  ", HttpStatus.CREATED);

		} else {

			return new ResponseEntity<String>("El objeto de Labores realizadas enviado desde AgroViewMobile es nulo",
					HttpStatus.BAD_REQUEST);
		}

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

}
