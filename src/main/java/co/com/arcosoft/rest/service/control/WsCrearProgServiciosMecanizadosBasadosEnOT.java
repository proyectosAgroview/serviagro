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
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatPlanServiciosMq;
import co.com.arcosoft.modelo.DatPlanServiciosMq;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.control.IDatPlanLaborDetLogic;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.modelo.control.INivel2ClientesmqLogic;
import co.com.arcosoft.modelo.control.INivel4ClientesmqLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.control.IUdadMedLogic;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.ManoDeObra;
import co.com.arcosoft.rest.service.dto.ProgLaboresMecMaqDTO;
import co.com.arcosoft.utilities.FacesUtils;

@Controller
@RequestMapping("/transacciones")
public class WsCrearProgServiciosMecanizadosBasadosEnOT {

	private static final Logger logger = LoggerFactory.getLogger(WsCrearProgServiciosMecanizadosBasadosEnOT.class);

	private DatPlanServiciosMq entity = null;
	List<DatPlanServiciosMqdetDTO> dataProgramaLaboresDet = null;

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

	@Autowired
	INivel2ClientesmqLogic nivel2ClientesmqLogic;

	
	@Autowired
	INivel4ClientesmqLogic nivel4ClientesmqLogic;


	@Autowired
	IUdadMedLogic udadMedLogic;

	boolean existeOT = false;

	@RequestMapping(value = "/guardarProgramaLaboresMaq", method = RequestMethod.POST)
	public ResponseEntity<String> guardarServiciosRealizadosMaq(@RequestBody ProgLaboresMecMaqDTO programaLabor)
			throws Exception {

		Labor labor = null;
		PersEmpr cliente = null;
		Nivel2Clientesmq nivel2Hacienda = null;
		Nivel4Clientesmq nivel4Lote = null;
		DatPlanServiciosMqdetDTO detDto = null;
		UdadMed unidadplan = null;
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
		String nomLote = null;
		Long laborId = null;
		Long persEmprId = null;
		Long nivel2ClientesmqId = null;
		Long nivel4ClientesmqId = null;
		Long udadMedId = null;
		Long zonaGeograficaId=null;
		ZonaGeografica  zonaGeo= null;
		Long supervisorId = 0L;
		if (programaLabor != null) {

			entity = new DatPlanServiciosMq();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = programaLabor.getPeriodo_inicial();
			// String fsalida = sdf.format(fechaOriginal);

			// fechaFinalDateRegistro = sdf.parse(fsalida);

			//	if (programaLabor.getDetalle_nota() != null) {
				//	entity.setObservacion(programaLabor.getDetalle_nota());
			//	}
				
				

				if (programaLabor.getId_zona() != null) {
					zonaGeograficaId = programaLabor.getId_zona().longValue();
					Object[] condicionZona = { "zonaGeograficaId", true, zonaGeograficaId, "=" };
					List<ZonaGeografica> listaZona = (zonaGeograficaId != null)
							? businessDelegatorView.findByCriteriaInZonaGeografica(condicionZona, null, null)
							: null;
					if (listaZona != null && listaZona.size() > 0) {
						zonaGeo = listaZona.get(0);
						
					}
				}
				

				if (programaLabor.getId_cliente() != null) {
					persEmprId = programaLabor.getId_cliente().longValue();
					Object[] condicionPersEmpr = { "persEmprId", true, persEmprId, "=" };
					List<PersEmpr> listaPersEmpr = (persEmprId != null)
							? businessDelegatorView.findByCriteriaInPersEmpr(condicionPersEmpr, null, null)
							: null;
					if (listaPersEmpr != null && listaPersEmpr.size() > 0) {
						cliente = listaPersEmpr.get(0);
						
					}
				}
				
				if (programaLabor.getId_finca() != null) {
					nivel2ClientesmqId = programaLabor.getId_finca().longValue();
					Object[] condicionNivel2 = { "nivel2ClientesmqId", true, nivel2ClientesmqId, "=" };
					List<Nivel2Clientesmq> listaNivel2 = (nivel2ClientesmqId != null)
							? businessDelegator2View.findByCriteriaInNivel2Clientesmq(condicionNivel2, null, null)
							: null;
					if (listaNivel2 != null && listaNivel2.size() > 0) {
						nivel2Hacienda = listaNivel2.get(0);
						
					}
				}
				
				
				if (programaLabor.getNom_lote() != null) {
					nomLote =programaLabor.getNom_lote();
					if(nomLote!=null && !nomLote.equals("")) {

						 Object[] condicion = { "codigo", true, nomLote, "=", "nivel2Clientesmq.nivel2ClientesmqId", true, nivel2ClientesmqId, "="  };
							List<Nivel4Clientesmq> nivel4ClientesConsulta = businessDelegator2View.findByCriteriaInNivel4Clientesmq(condicion, null, null);	
							
							if (nivel4ClientesConsulta == null || nivel4ClientesConsulta.size()==0 ) {
								nivel4Lote= new Nivel4Clientesmq();
								Date date = new Date();
								
								nivel4Lote.setNivel2Clientesmq(nivel2Hacienda);
								nivel4Lote.setCodigo(nomLote);
								nivel4Lote.setNombre(nomLote);
								nivel4Lote.setCompania(programaLabor.getCompania().longValue());
								nivel4Lote.setEstado("A");
								nivel4Lote.setAreaNeta(0.0);
								nivel4Lote.setFechaCreacion(date);
								
								businessDelegator2View.saveNivel4Clientesmq(nivel4Lote);
					
							} else {
								nivel4Lote = nivel4ClientesConsulta.get(0);
								
							}				
						}
					
					}
				
				
				

				if (programaLabor.getLabor_id() != null) {
					laborId = programaLabor.getLabor_id().longValue();
					Object[] condicionLabor = { "laborId", true, laborId, "=" };
					List<Labor> listaLabor = (laborId != null)
							? businessDelegatorView.findByCriteriaInLabor(condicionLabor, null, null)
							: null;
					if (listaLabor != null && listaLabor.size() > 0) {
						labor = listaLabor.get(0);
						
					}
				}


				

				if (programaLabor.getUdad_med_id() != null) {
					udadMedId = programaLabor.getUdad_med_id().longValue();
					Object[] condicionUdadMed = { "udadMedId", true, udadMedId, "=" };
					List<UdadMed> listaUdadMed = (udadMedId != null)
							? businessDelegatorView.findByCriteriaInUdadMed(condicionUdadMed, null, null)
							: null;
					if (listaUdadMed != null && listaUdadMed.size() > 0) {
						unidadplan = listaUdadMed.get(0);
						
					}
				}
				
				if (programaLabor.getUsuarioDigitacion() != null) {

					Long usuarioId = programaLabor.getUsuarioDigitacion();
					Object[] condicionTrabajador = { "usuario_asociado", true, usuarioId, "=" };
					List<Trabajador> listaTrabajador = (usuarioId != null)
							? businessDelegatorView.findByCriteriaInTrabajador(condicionTrabajador, null, null)
							: null;
					if (listaTrabajador != null && listaTrabajador.size() > 0) {
						trabajador = listaTrabajador.get(0);
						supervisorId = trabajador.getTrabId();
					}
				}

				
				entity.setEstado("A");
				entity.setPeriodoInicial(fechaOriginal);

				GregorianCalendar calendario = new GregorianCalendar();
				calendario.setTime(fechaOriginal);
				long anioRegistro = calendario.get(java.util.Calendar.YEAR);

				entity.setFechaCreacion(new Date());
				entity.setUsuarioDigitacion(programaLabor.getUsuarioDigitacion());
				Date date = new Date();
				String estado = "A";
				entity.setEstado(estado);
				entity.setCompania(programaLabor.getCompania().longValue());
				
				//entity.setEquipo(equipo);
				// entity.setConsecutivo(businessDelegatorView.consultarConsecutivoProgramaLabores(programaLabor.getCompania(),
				// equipoId));
				entity.setFechaCreacion(date);
				entity.setZonaGeografica(zonaGeo);
				entity.setTipoProyecto("Otros");
				// entity.setNumFactura(FacesUtils.checkLong(txtNumFactura));
				entity.setPersEmpr(cliente);
				entity.setTrabajador(trabajador);
				entity.setNivel2Clientesmq(nivel2Hacienda);
				// DAT_PLANILLA_NOMINA_DET

				dataProgramaLaboresDet = new ArrayList<DatPlanServiciosMqdetDTO>();
				detDto = new DatPlanServiciosMqdetDTO();


				detDto.setPeriodoInicial(fechaOriginal);
				detDto.setLaborId_Labor(labor);
				detDto.setPersEmprId_PersEmpr(cliente);
				detDto.setNivel2ClientesmqId_Nivel2Clientesmq(nivel2Hacienda);
				detDto.setNivel4ClientesmqId(nivel4Lote);
				detDto.setNumPases(programaLabor.getNum_pases().longValue());
				///detDto.setNivel4ClientesId(nivel4Lote);
				
				detDto.setUdadMedId_UdadMed(unidadplan);
				detDto.setCantidadPlan(programaLabor.getCantidad_plan().doubleValue());
				detDto.setCantidadPendiente(programaLabor.getCantidad_plan().doubleValue());
				detDto.setCantidadRealizada(0.0);
				
				detDto.setUdadMedId_UdadMed(unidadplan);
				
				detDto.setCantidadPendiente(programaLabor.getCantidad_plan().doubleValue());
				
				detDto.setAreaProgramada(programaLabor.getArea_programada().doubleValue());
				// detDto.setUdadMedProd(
				// (programaLabor.getUdadMedProd() != null) ?
				// programaLabor.getUdadMedProd().longValue() : null);
				
				detDto.setConcluido("NO");
				detDto.setValorEstTotal(0.0);
				detDto.setValorEstTotal(0.0);
				detDto.setDetalleNota(programaLabor.getDetalle_nota());
				
				dataProgramaLaboresDet.add(detDto);

				Long ultimoId = businessDelegator2View.pr_ultima_programa_labores_maq(programaLabor.getCompania().longValue(),
						fechaOriginal, persEmprId, supervisorId);

				if (ultimoId != 0) {

					Object[] condicion = { "datPlanServiciosMqId", true, ultimoId, "=" };
					List<DatPlanServiciosMq> lista = (ultimoId != null)
							? businessDelegator2View.findByCriteriaInDatPlanServiciosMq(condicion, null, null)
							: null;

					if (lista != null && lista.size() > 0) {
						entity = lista.get(0);
					}

					consecutivo = entity.getConsecutivo().longValue();
					businessDelegator2View.updateDatPlanServiciosMq(entity, dataProgramaLaboresDet);

				} else {

					entity.setConsecutivo(businessDelegator2View.consec_plan_serv_mq(programaLabor.getCompania().longValue()));
					consecutivo = entity.getConsecutivo().longValue();

					businessDelegator2View.saveDatPlanServiciosMq(entity, dataProgramaLaboresDet);

					
				}
				
				labor = null;
				nivel2Hacienda = null;
				nivel4Lote = null;
				detDto = null;
				unidadplan = null;
				trabajador = null;
				dataProgramaLaboresDet = null;
				entity = null;
				fechaFinalDateRegistro = null;
				existeOT = false;
				cliente = null;
				equipo = null;

			

			return new ResponseEntity<String>(
					"El registro de labor mecanizada fue creado en AgroView  para la máquina: " + nombreEquipo
							+ " consecutivo: " + consecutivo.toString(),
					HttpStatus.CREATED);
	
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
