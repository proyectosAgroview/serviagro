package co.com.arcosoft.presentation.businessDelegate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.control.*;
import co.com.arcosoft.modelo.dto.*;
import co.com.arcosoft.modelo.informes.dto.AnalisisDiatraeaDTO;
import co.com.arcosoft.modelo.informes.dto.AnalisisEnfermedadDTO;
import co.com.arcosoft.modelo.informes.dto.AnalisisEnfermedadVer2DTO;
import co.com.arcosoft.modelo.informes.dto.AnalisisPlagaDTO;
import co.com.arcosoft.modelo.informes.dto.AnalisisPlagaVer2DTO;
import co.com.arcosoft.modelo.informes.dto.AnalisisProcesoIndustrialDTO;
import co.com.arcosoft.modelo.informes.dto.BasculaVehiculosPesarDTO;
import co.com.arcosoft.modelo.informes.dto.BasculaVehiculosTararDTO;
import co.com.arcosoft.modelo.informes.dto.CalculoProxMttoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.ConsolidadoNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaDatPlanLaborDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaEventosPorPagarDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaMttoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOrdenTrabajoDesDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaSolicitudesParaMttoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaTiqueteSinAnalisisCalidadFrutoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosDTO;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.CostosInsumosDetalladoDTO;
import co.com.arcosoft.modelo.informes.dto.CostosTotalesDTO;
import co.com.arcosoft.modelo.informes.dto.CuadroPrecipitacionDiariaDTO;
import co.com.arcosoft.modelo.informes.dto.DatosClimaticosDTO;
import co.com.arcosoft.modelo.informes.dto.DatosEvaporimetrosDTO;
import co.com.arcosoft.modelo.informes.dto.DetalleInsumosLoteDTO;
import co.com.arcosoft.modelo.informes.dto.DetalleInsumosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.DisponibilidadHidricaDTO;
import co.com.arcosoft.modelo.informes.dto.DistribuccionCostosMaquinaDTO;
import co.com.arcosoft.modelo.informes.dto.DistribucionAreaCultivoDTO;
import co.com.arcosoft.modelo.informes.dto.DistribucionAreaFincaDTO;
import co.com.arcosoft.modelo.informes.dto.DistribucionAreaVariedadDTO;
import co.com.arcosoft.modelo.informes.dto.EstadoOrdenTrabajoDTO;
import co.com.arcosoft.modelo.informes.dto.HorasMaquinaDetalladoDTO;
import co.com.arcosoft.modelo.informes.dto.IncidenciaEnfermedadDTO;
import co.com.arcosoft.modelo.informes.dto.InterfaceNomina85DTO;
import co.com.arcosoft.modelo.informes.dto.LineaBaseAsociacionDTO;
import co.com.arcosoft.modelo.informes.dto.LineaBaseProductorDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaVariablesAnaLaboratorioDTO;
import co.com.arcosoft.modelo.informes.dto.ListaVariablesSanidadDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoRecursosDTO;
import co.com.arcosoft.modelo.informes.dto.MovimientoVagonCosechaDTO;
import co.com.arcosoft.modelo.informes.dto.MttoCheckListEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.MttoHorasTrabajadasEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.MttoParadasFabricaDTO;
import co.com.arcosoft.modelo.informes.dto.MttoPlanFabricaDTO;
import co.com.arcosoft.modelo.informes.dto.MttoProyeccionMttoDTO;
import co.com.arcosoft.modelo.informes.dto.MttoReporteFallasEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.MttoSalidaCombustibleEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.NominaDetalladaDTO;
import co.com.arcosoft.modelo.informes.dto.PluviometriaDTO;
import co.com.arcosoft.modelo.informes.dto.PrecipitacionAniosDTO;
import co.com.arcosoft.modelo.informes.dto.ProduccionAcumFincaDTO;
import co.com.arcosoft.modelo.informes.dto.ProduccionCortesDTO;
import co.com.arcosoft.modelo.informes.dto.ProduccionLoteArcansasDTO;
import co.com.arcosoft.modelo.informes.dto.ProductoresPorTecnicoDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramaCosechaDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramaRiegosDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionSiembraCosechaDTO;
import co.com.arcosoft.modelo.informes.dto.ProntuarioLotesDTO;
import co.com.arcosoft.modelo.informes.dto.ProyeccionLaboresLoteDTO;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaDespachosInformeDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaImprimirDespachosDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaImprimirProdDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaProduccionInformeDTO;
import co.com.arcosoft.modelo.informes.dto.ValoresPosiblesVariablesSanidadVegetalDTO;
import co.com.arcosoft.modelo.informes.dto.interfaceManagerExpRegistrosMODTO;
import co.com.arcosoft.rest.service.dto.ProgMttoPreventivosMaqDTO;

/**
 * Use a Business Delegate to reduce coupling between presentation-tier clients
 * and business services. The Business Delegate hides the underlying
 * implementation details of the business service, such as lookup and access
 * details of the EJB architecture.
 *
 * The Business Delegate acts as a client-side business abstraction; it provides
 * an abstraction for, and thus hides, the implementation of the business
 * services. Using a Business Delegate reduces the coupling between
 * presentation-tier clients and the system's business services. Depending on
 * the implementation strategy, the Business Delegate may shield clients from
 * possible volatility in the implementation of the business service API.
 * Potentially, this reduces the number of changes that must be made to the
 * presentation-tier client code when the business service API or its underlying
 * implementation changes.
 *
 * However, interface methods in the Business Delegate may still require
 * modification if the underlying business service API changes. Admittedly,
 * though, it is more likely that changes will be made to the business service
 * rather than to the Business Delegate.
 *
 * Often, developers are skeptical when a design goal such as abstracting the
 * business layer causes additional upfront work in return for future gains.
 * However, using this pattern or its strategies results in only a small amount
 * of additional upfront work and provides considerable benefits. The main
 * benefit is hiding the details of the underlying service. For example, the
 * client can become transparent to naming and lookup services. The Business
 * Delegate also handles the exceptions from the business services, such as
 * java.rmi.Remote exceptions, Java Messages Service (JMS) exceptions and so on.
 * The Business Delegate may intercept such service level exceptions and
 * generate application level exceptions instead. Application level exceptions
 * are easier to handle by the clients, and may be user friendly. The Business
 * Delegate may also transparently perform any retry or recovery operations
 * necessary in the event of a service failure without exposing the client to
 * the problem until it is determined that the problem is not resolvable. These
 * gains present a compelling reason to use the pattern.
 *
 * Another benefit is that the delegate may cache results and references to
 * remote business services. Caching can significantly improve performance,
 * because it limits unnecessary and potentially costly round trips over the
 * network.
 *
 * A Business Delegate uses a component called the Lookup Service. The Lookup
 * Service is responsible for hiding the underlying implementation details of
 * the business service lookup code. The Lookup Service may be written as part
 * of the Delegate, but we recommend that it be implemented as a separate
 * component, as outlined in the Service Locator pattern (See "Service Locator"
 * on page 368.)
 *
 * When the Business Delegate is used with a Session Facade, typically there is
 * a one-to-one relationship between the two. This one-to-one relationship
 * exists because logic that might have been encapsulated in a Business Delegate
 * relating to its interaction with multiple business services (creating a
 * one-to-many relationship) will often be factored back into a Session Facade.
 *
 * Finally, it should be noted that this pattern could be used to reduce
 * coupling between other tiers, not simply the presentation and the business
 * tiers.
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {

	private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
	@Autowired
	private IAlmacenLogic almacenLogic;
	@Autowired
	private IAnaCultivoLogic anaCultivoLogic;
	@Autowired
	private IAnaSanVegLogic anaSanVegLogic;
	@Autowired
	private IAnioFiscalLogic anioFiscalLogic;
	@Autowired
	private ICalendarioLogic calendarioLogic;
	@Autowired
	private ICategoriaEquipoLogic categoriaEquipoLogic;
	@Autowired
	private ICentCostLogic centCostLogic;
	@Autowired
	private ICiudadLogic ciudadLogic;
	@Autowired
	private IClaseTextSueloLogic claseTextSueloLogic;
	@Autowired
	private IClaseToxicologicaLogic claseToxicologicaLogic;
	@Autowired
	private ITarifaLaborRendimientoLogic tarifaLaborRendimientoLogic;
	@Autowired
	private ICompaniaLogic companiaLogic;
	@Autowired
	private IConceptoNominaLogic conceptoNominaLogic;
	@Autowired
	private IConductorLogic conductorLogic;
	@Autowired
	private IContBancoLogic contBancoLogic;
	@Autowired
	private IPrecioPromProdLogic precioPromProdLogic;
	@Autowired
	private ITarifaContratistaLogic tarifaContratistaLogic;
	@Autowired
	private ITarifaEquipPropLogic tarifaEquipPropLogic;
	@Autowired
	private ITarifaProfesionLogic tarifaProfesionLogic;

	@Autowired
	private ICostoRecursoLogic costoRecursoLogic;
	@Autowired
	private ICuentaContableLogic cuentaContableLogic;
	@Autowired
	private ICultivoLogic cultivoLogic;
	@Autowired
	private ICultivoFitosanidadLogic cultivoFitosanidadLogic;

	@Autowired
	private IDatAplicProdDetLogic datAplicProdDetLogic;
	@Autowired
	private IDatAplicProductoLogic datAplicProductoLogic;
	@Autowired
	private IDatClimatLogic datClimatLogic;
	@Autowired
	private IDatEstimCosechaLogic datEstimCosechaLogic;
	@Autowired
	private IDatEvaporimetroLogic datEvaporimetroLogic;

	@Autowired
	private IDatPlanillaNominaLogic datPlanillaNominaLogic;
	@Autowired
	private IDatPlanLaborLogic datPlanLaborLogic;
	@Autowired
	private IDatPluvioLogic datPluvioLogic;

	@Autowired
	private IDatRiegoLogic datRiegoLogic;
	@Autowired
	private IDatSanVegLogic datSanVegLogic;
	@Autowired
	private IDatServicioLogic datServicioLogic;

	@Autowired
	private IDatTransProdLogic datTransProdLogic;
	@Autowired
	private IDatTransProdDetLogic datTransProdDetLogic;
	@Autowired
	private IDificultadAccesoLogic dificultadAccesoLogic;
	@Autowired
	private IDistSiembraLogic distSiembraLogic;
	@Autowired
	private IElementoCostoLogic elementoCostoLogic;
	@Autowired
	private IEmpaqueLogic empaqueLogic;

	@Autowired
	private IEmpaqueProductoLogic empaqueProductoLogic;
	@Autowired
	private IEntBancLogic entBancLogic;
	@Autowired
	private IEquipoLogic equipoLogic;
	@Autowired
	private IEquipoTrabajoLogic equipoTrabajoLogic;
	@Autowired
	private IEstadoLogic estadoLogic;
	@Autowired
	private IEstClimatLogic estClimatLogic;
	@Autowired
	private IEstEvaporimetroLogic estEvaporimetroLogic;
	@Autowired
	private IEstPluvioLogic estPluvioLogic;
	@Autowired
	private IEstructSiembLogic estructSiembLogic;
	@Autowired
	private IEtapaLogic etapaLogic;
	@Autowired
	private IFabricanteEquipoLogic fabricanteEquipoLogic;
	@Autowired
	private IFactorConversionLogic factorConversionLogic;
	@Autowired
	private IFaseFenologicaLogic faseFenologicaLogic;
	@Autowired
	private IFitosanidadLogic fitosanidadLogic;
	@Autowired
	private IFliaTextSueloLogic fliaTextSueloLogic;
	@Autowired
	private IFlotaTransporteLogic flotaTransporteLogic;
	@Autowired
	private IFrenteCosLogic frenteCosLogic;
	@Autowired
	private IGrpLaborLogic grpLaborLogic;

	@Autowired
	private IGrpSueloLogic grpSueloLogic;
	@Autowired
	private IGrpTenenLogic grpTenenLogic;
	@Autowired
	private IInfraestructuraLogic infraestructuraLogic;

	@Autowired
	private IIngredienteActivoLogic ingredienteActivoLogic;

	@Autowired
	private ILaborLogic laborLogic;

	@Autowired
	private ILaraEdadLogic laraEdadLogic;
	@Autowired
	private ILarvasLogic larvasLogic;

	@Autowired
	private ILimiteCeptoNominaLogic limiteCeptoNominaLogic;
	@Autowired
	private IListValorLogic listValorLogic;

	@Autowired
	private IMedidorLogic medidorLogic;
	@Autowired
	private IModalidadCosechaLogic modalidadCosechaLogic;
	@Autowired
	private IModeloEquipoLogic modeloEquipoLogic;
	@Autowired
	private IMonedaLogic monedaLogic;
	@Autowired
	private IMotElimLogic motElimLogic;
	@Autowired
	private IMotEstimLogic motEstimLogic;
	@Autowired
	private IMotivoCierreOtLogic motivoCierreOtLogic;
	@Autowired
	private IN4MotivoLogic n4MotivoLogic;
	@Autowired
	private INivel1Logic nivel1Logic;
	@Autowired
	private INivel2Logic nivel2Logic;
	@Autowired
	private INivel3Logic nivel3Logic;
	@Autowired
	private INivel4Logic nivel4Logic;
	@Autowired
	private INivelFertilidadLogic nivelFertilidadLogic;
	@Autowired
	private INumeroEjeLogic numeroEjeLogic;
	@Autowired
	private IOcupacionLogic ocupacionLogic;
	@Autowired
	private IOrdenSueloLogic ordenSueloLogic;
	@Autowired
	private IOrganizacionLogic organizacionLogic;
	@Autowired
	private IPaisLogic paisLogic;
	@Autowired
	private IPersEmprLogic persEmprLogic;
	@Autowired
	private IPlanAsignarRecursoLogic planAsignarRecursoLogic;
	@Autowired
	private IProductoLogic productoLogic;
	@Autowired
	private IProfesionLogic profesionLogic;
	@Autowired
	private IAutocompletadoLogic autocompletadoLogic;
	@Autowired
	private IRangoValorLogic rangoValorLogic;
	@Autowired
	private IRestriccionQuemaNivel4Logic restriccionQuemaNivel4Logic;
	@Autowired
	private IRestriMaduranteNivel4Logic restriMaduranteNivel4Logic;
	@Autowired
	private IRestrMaduranteLogic restrMaduranteLogic;
	@Autowired
	private IRestrQuemaLogic restrQuemaLogic;
	@Autowired
	private ISerieSueloLogic serieSueloLogic;
	@Autowired
	private IServicioLogic servicioLogic;
	@Autowired
	private ISistemaRiegoLogic sistemaRiegoLogic;
	@Autowired
	private ITenenciaLogic tenenciaLogic;
	@Autowired
	private ITipCultivoLogic tipCultivoLogic;
	@Autowired
	private ITipoClienteLogic tipoClienteLogic;
	@Autowired
	private ITipoDiaLogic tipoDiaLogic;
	@Autowired
	private ITipoDrenajeLogic tipoDrenajeLogic;
	@Autowired
	private ITipoInfraestructuraLogic tipoInfraestructuraLogic;
	@Autowired
	private ITipoProductoLogic tipoProductoLogic;
	@Autowired
	private ITipoRecursoLogic tipoRecursoLogic;
	@Autowired
	private ITipProveeLogic tipProveeLogic;
	@Autowired
	private ITopografiaLogic topografiaLogic;
	@Autowired
	private ITrabajadorLogic trabajadorLogic;
	@Autowired
	private ITransportadoraLogic transportadoraLogic;
	@Autowired
	private ITurnoCampoLogic turnoCampoLogic;
	@Autowired
	private IUdadMedLogic udadMedLogic;
	@Autowired
	private IValorVarLogic valorVarLogic;
	@Autowired
	private IVariableLogic variableLogic;
	@Autowired
	private IVariedadLogic variedadLogic;
	@Autowired
	private IVariedadNivel4Logic variedadNivel4Logic;
	@Autowired
	private IVehiculosTranspLogic vehiculosTranspLogic;
	@Autowired
	private IZonaGeograficaLogic zonaGeograficaLogic;
	@Autowired
	private IZonAgroecLogic zonAgroecLogic;
	@Autowired
	private IInformesLogic informesLogic;
	@Autowired
	private IGroupAuthoritiesLogic groupAuthoritiesLogic;
	@Autowired
	private IGroupMembersLogic groupMembersLogic;
	@Autowired
	private IGroupsLogic groupsLogic;
	@Autowired
	private IUsuariosLogic usuariosLogic;
	@Autowired
	private ITarifaDeduccionLogic tarifaDeduccionLogic;
	@Autowired
	private ITarifaOtrosDevengosLogic tarifaOtrosDevengosLogic;
	@Autowired
	private IDatPlanillaNominaDetLogic datPlanillaNominaDetLogic;
	@Autowired
	private IDatServicioDetLogic datServicioDetLogic;
	@Autowired
	private IItemsMenuLogic itemsMenuLogic;
	@Autowired
	private ICronogramaLaboresLogic cronogramaLaboresLogic;
	@Autowired
	private ICronogramaLaboresLaboresLogic cronogramaLaboresLaboresLogic;
	@Autowired
	private ICronogramaLaboresNivel4Logic cronogramaLaboresNivel4Logic;
	@Autowired
	private IAgenteCausadorParadaLogic agenteCausadorParadaLogic;
	@Autowired
	private IBombaAbastecimientoLogic bombaAbastecimientoLogic;
	@Autowired
	private IDatAbastCombustibleLogic datAbastCombustibleLogic;
	@Autowired
	private IDatMantenimientoEquipoLogic datMantenimientoEquipoLogic;
	@Autowired
	private IDatMantenimientoEquipoMecLogic datMantenimientoEquipoMecLogic;
	@Autowired
	private IDatMantenimientoEquipoProdLogic datMantenimientoEquipoProdLogic;
	@Autowired
	private IMotivosEntradaTallerLogic motivosEntradaTallerLogic;
	@Autowired
	private IPlanRevisionEquipoLogic planRevisionEquipoLogic;
	@Autowired
	private IPlanRevisionEquipoActivLogic planRevisionEquipoActivLogic;
	@Autowired
	private IPlanRevisionEquipoDetLogic planRevisionEquipoDetLogic;
	@Autowired
	private ITallerMecanicoLogic tallerMecanicoLogic;
	@Autowired
	private ITipoAbastecimientoLogic tipoAbastecimientoLogic;
	@Autowired
	private ITipoMantenimientoLogic tipoMantenimientoLogic;
	@Autowired
	private IDatTransProdNivel4Logic datTransProdNivel4Logic;
	@Autowired
	private IColorIdentProduccionLogic colorIdentProduccionLogic;
	@Autowired
	private INivel2PersemprLogic nivel2PersemprLogic;
	@Autowired
	private ISemanaLogic semanaLogic;
	@Autowired
	private IDatProgramaRiegoLogic datProgramaRiegoLogic;
	@Autowired
	private IDatProgramaRiegoDetLogic datProgramaRiegoDetLogic;

	@Autowired
	private IProgramaSiembraCosechaLogic programaSiembraCosechaLogic;
	@Autowired
	private IProgramaSiembraCosechaDetLogic programaSiembraCosechaDetLogic;

	@Autowired
	private IBasculaLogic basculaLogic;

	@Autowired
	private IDatTransProdTrabajadoresLogic datTransProdTrabajadoresLogic;
	/***** 27-02-2017 ***/
	@Autowired
	private IDatNominaTrabajadorLogic datNominaTrabajadorLogic;
	@Autowired
	private IDatNominaTrabajadorDetLogic datNominaTrabajadorDetLogic;
	@Autowired
	private IDatOtrosCostosLogic datOtrosCostosLogic;
	@Autowired
	private IDatOtrosCostosNivel4Logic datOtrosCostosNivel4Logic;

	@Autowired
	private ITarifaInfraestructuraLogic tarifaInfraestructuraLogic;
	@Autowired
	private IEventosLogic eventosLogic;
	@Autowired
	private IEquipoEventoLogic equipoEventoLogic;

	/*** 16-03-2017 **/
	@Autowired
	private IDatPlanLaborDetLogic datPlanLaborDetLogic;

	@Autowired
	private ILaborRecursosLogic laborRecursosLogic;

	@Autowired
	private ITipoRecursosEquiposLogic tipoRecursosEquiposLogic;

	@Autowired
	private ITipoRecursosInsumosLogic tipoRecursosInsumosLogic;

	@Autowired
	private ITipoRecursosOtrosLogic tipoRecursosOtrosLogic;

	@Autowired
	private ITipoRecursosProfesionLogic tipoRecursosProfesionLogic;

	@Autowired
	private ITagLogic tagLogic;

	@Autowired
	private IZonasFabricaLogic zonasFabricaLogic;

	@Autowired
	private IDatOtrosCostosMqLogic datOtrosCostosMqLogic;
	@Autowired
	private IDatOtrosCostosMqdetLogic datOtrosCostosMqdetLogic;

	@Autowired
	private IDatHorasTrabajoEquipoLogic datHorasTrabajoEquipoLogic;
	@Autowired
	private IDatServRealizadosEquipoLogic datServRealizadosEquipoLogic;

	@Autowired
	private IDatServRealizadosEquipoDetLogic datServRealizadosEquipoDetLogic;

	@Autowired
	private ICompartimientosEquipoLogic compartimientosEquipoLogic;
	@Autowired
	private ISistemasEquipoLogic sistemasEquipoLogic;
	@Autowired
	private IDatReporteFallasLogic datReporteFallasLogic;
	@Autowired
	private IDatPlanAnualFabricaLogic datPlanAnualFabricaLogic;

	/** 23-01-2018 **/

	@Autowired
	private IAreaTrabajoLogic areaTrabajoLogic;

	@Autowired
	private IDatSolicitudesMttoLogic datSolicitudesMttoLogic;

	@Autowired
	private INivelPrioridadLogic nivelPrioridadLogic;

	@Autowired
	private IDatPlanillaNominaOnivel4Logic datPlanillaNominaOnivel4Logic;
	@Autowired
	private IDatParadasFabricaLogic datParadasFabricaLogic;
	@Autowired
	private IPlanRevisionEquipoRecursosLogic planRevisionEquipoRecursosLogic;

	@Autowired
	private IAnaLaboratorioLogic anaLaboratorioLogic;
	@Autowired
	private IAnaLaboratorioVariableLogic anaLaboratorioVariableLogic;
	@Autowired
	private IDatAnaLaboratorioLogic datAnaLaboratorioLogic;
	@Autowired
	private IDatAnaLaboratorioDetLogic datAnaLaboratorioDetLogic;
	@Autowired
	private IVariableLabLogic variableLabLogic;

	@Autowired
	private ILogBasculaLogic logBasculaLogic;

	@Autowired
	private IDatNominaTrabajadorMqLogic datNominaTrabajadorMqLogic;
	@Autowired
	private IDatNominaTrabajadorMqdetLogic datNominaTrabajadorMqdetLogic;
	@Autowired
	private IDatPlanServiciosMqLogic datPlanServiciosMqLogic;
	@Autowired
	private IDatPlanServiciosMqdetLogic datPlanServiciosMqdetLogic;
	@Autowired
	private IDatHerramientaLogic datHerramientaLogic;

	@Override
	public List<AreaTrabajo> getAreaTrabajo() throws Exception {
		return areaTrabajoLogic.getAreaTrabajo();
	}

	@Override
	public void saveAreaTrabajo(AreaTrabajo entity) throws Exception {
		areaTrabajoLogic.saveAreaTrabajo(entity);
	}

	@Override
	public void deleteAreaTrabajo(AreaTrabajo entity) throws Exception {
		areaTrabajoLogic.deleteAreaTrabajo(entity);
	}

	@Override
	public void updateAreaTrabajo(AreaTrabajo entity) throws Exception {
		areaTrabajoLogic.updateAreaTrabajo(entity);
	}

	@Override
	public AreaTrabajo getAreaTrabajo(Long areaTrabajoId) throws Exception {
		AreaTrabajo areaTrabajo = null;

		try {
			areaTrabajo = areaTrabajoLogic.getAreaTrabajo(areaTrabajoId);
		} catch (Exception e) {
			throw e;
		}

		return areaTrabajo;
	}

	@Override
	public List<AreaTrabajo> findByCriteriaInAreaTrabajo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return areaTrabajoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<AreaTrabajo> findPageAreaTrabajo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return areaTrabajoLogic.findPageAreaTrabajo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberAreaTrabajo() throws Exception {
		return areaTrabajoLogic.findTotalNumberAreaTrabajo();
	}

	@Override
	public List<AreaTrabajoDTO> getDataAreaTrabajo() throws Exception {
		return areaTrabajoLogic.getDataAreaTrabajo();
	}

	@Override
	public List<DatSolicitudesMtto> getDatSolicitudesMtto() throws Exception {
		return datSolicitudesMttoLogic.getDatSolicitudesMtto();
	}

	@Override
	public void saveDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception {
		datSolicitudesMttoLogic.saveDatSolicitudesMtto(entity);
	}

	@Override
	public void deleteDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception {
		datSolicitudesMttoLogic.deleteDatSolicitudesMtto(entity);
	}

	@Override
	public void updateDatSolicitudesMtto(DatSolicitudesMtto entity) throws Exception {
		datSolicitudesMttoLogic.updateDatSolicitudesMtto(entity);
	}

	@Override
	public DatSolicitudesMtto getDatSolicitudesMtto(Long datSolicitudesMttoId) throws Exception {
		DatSolicitudesMtto datSolicitudesMtto = null;

		try {
			datSolicitudesMtto = datSolicitudesMttoLogic.getDatSolicitudesMtto(datSolicitudesMttoId);
		} catch (Exception e) {
			throw e;
		}

		return datSolicitudesMtto;
	}

	@Override
	public List<DatSolicitudesMtto> findByCriteriaInDatSolicitudesMtto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datSolicitudesMttoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatSolicitudesMtto> findPageDatSolicitudesMtto(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datSolicitudesMttoLogic.findPageDatSolicitudesMtto(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatSolicitudesMtto() throws Exception {
		return datSolicitudesMttoLogic.findTotalNumberDatSolicitudesMtto();
	}

	@Override
	public List<DatSolicitudesMttoDTO> getDataDatSolicitudesMtto() throws Exception {
		return datSolicitudesMttoLogic.getDataDatSolicitudesMtto();
	}

	@Override
	public List<NivelPrioridad> getNivelPrioridad() throws Exception {
		return nivelPrioridadLogic.getNivelPrioridad();
	}

	@Override
	public void saveNivelPrioridad(NivelPrioridad entity) throws Exception {
		nivelPrioridadLogic.saveNivelPrioridad(entity);
	}

	@Override
	public void deleteNivelPrioridad(NivelPrioridad entity) throws Exception {
		nivelPrioridadLogic.deleteNivelPrioridad(entity);
	}

	@Override
	public void updateNivelPrioridad(NivelPrioridad entity) throws Exception {
		nivelPrioridadLogic.updateNivelPrioridad(entity);
	}

	@Override
	public NivelPrioridad getNivelPrioridad(Long nivelPrioridadId) throws Exception {
		NivelPrioridad nivelPrioridad = null;

		try {
			nivelPrioridad = nivelPrioridadLogic.getNivelPrioridad(nivelPrioridadId);
		} catch (Exception e) {
			throw e;
		}

		return nivelPrioridad;
	}

	@Override
	public List<NivelPrioridad> findByCriteriaInNivelPrioridad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivelPrioridadLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<NivelPrioridad> findPageNivelPrioridad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return nivelPrioridadLogic.findPageNivelPrioridad(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNivelPrioridad() throws Exception {
		return nivelPrioridadLogic.findTotalNumberNivelPrioridad();
	}

	@Override
	public List<NivelPrioridadDTO> getDataNivelPrioridad() throws Exception {
		return nivelPrioridadLogic.getDataNivelPrioridad();
	}

	@Override
	public List<Almacen> getAlmacen() throws Exception {
		return almacenLogic.getAlmacen();
	}

	@Override
	public void saveAlmacen(Almacen entity) throws Exception {
		almacenLogic.saveAlmacen(entity);
	}

	@Override
	public void deleteAlmacen(Almacen entity) throws Exception {
		almacenLogic.deleteAlmacen(entity);
	}

	@Override
	public void updateAlmacen(Almacen entity) throws Exception {
		almacenLogic.updateAlmacen(entity);
	}

	@Override
	public Almacen getAlmacen(Long almacenId) throws Exception {
		Almacen almacen = null;

		try {
			almacen = almacenLogic.getAlmacen(almacenId);
		} catch (Exception e) {
			throw e;
		}

		return almacen;
	}

	@Override
	public List<Almacen> findByCriteriaInAlmacen(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return almacenLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Almacen> findPageAlmacen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return almacenLogic.findPageAlmacen(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberAlmacen() throws Exception {
		return almacenLogic.findTotalNumberAlmacen();
	}

	@Override
	public List<AlmacenDTO> getDataAlmacen(Long companiaUserId) throws Exception {
		return almacenLogic.getDataAlmacen(companiaUserId);
	}

	@Override
	public List<AnaCultivo> getAnaCultivo() throws Exception {
		return anaCultivoLogic.getAnaCultivo();
	}

	@Override
	public void saveAnaCultivo(AnaCultivo entity) throws Exception {
		anaCultivoLogic.saveAnaCultivo(entity);
	}

	@Override
	public void deleteAnaCultivo(AnaCultivo entity) throws Exception {
		anaCultivoLogic.deleteAnaCultivo(entity);
	}

	@Override
	public void updateAnaCultivo(AnaCultivo entity) throws Exception {
		anaCultivoLogic.updateAnaCultivo(entity);
	}

	@Override
	public AnaCultivo getAnaCultivo(Long anaCultId) throws Exception {
		AnaCultivo anaCultivo = null;

		try {
			anaCultivo = anaCultivoLogic.getAnaCultivo(anaCultId);
		} catch (Exception e) {
			throw e;
		}

		return anaCultivo;
	}

	@Override
	public List<AnaCultivo> findByCriteriaInAnaCultivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return anaCultivoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<AnaCultivo> findPageAnaCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return anaCultivoLogic.findPageAnaCultivo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberAnaCultivo() throws Exception {
		return anaCultivoLogic.findTotalNumberAnaCultivo();
	}

	@Override
	public List<AnaCultivoDTO> getDataAnaCultivo() throws Exception {
		return anaCultivoLogic.getDataAnaCultivo();
	}

	@Override
	public List<CategoriaEquipo> getCategoriaEquipo() throws Exception {
		return categoriaEquipoLogic.getCategoriaEquipo();
	}

	@Override
	public void saveCategoriaEquipo(CategoriaEquipo entity) throws Exception {
		categoriaEquipoLogic.saveCategoriaEquipo(entity);
	}

	@Override
	public void deleteCategoriaEquipo(CategoriaEquipo entity) throws Exception {
		categoriaEquipoLogic.deleteCategoriaEquipo(entity);
	}

	@Override
	public void updateCategoriaEquipo(CategoriaEquipo entity) throws Exception {
		categoriaEquipoLogic.updateCategoriaEquipo(entity);
	}

	@Override
	public CategoriaEquipo getCategoriaEquipo(Long categEquipId) throws Exception {
		CategoriaEquipo categoriaEquipo = null;

		try {
			categoriaEquipo = categoriaEquipoLogic.getCategoriaEquipo(categEquipId);
		} catch (Exception e) {
			throw e;
		}

		return categoriaEquipo;
	}

	@Override
	public List<CategoriaEquipo> findByCriteriaInCategoriaEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return categoriaEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CategoriaEquipo> findPageCategoriaEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return categoriaEquipoLogic.findPageCategoriaEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCategoriaEquipo() throws Exception {
		return categoriaEquipoLogic.findTotalNumberCategoriaEquipo();
	}

	@Override
	public List<CategoriaEquipoDTO> getDataCategoriaEquipo() throws Exception {
		return categoriaEquipoLogic.getDataCategoriaEquipo();
	}

	@Override
	public List<Ciudad> getCiudad() throws Exception {
		return ciudadLogic.getCiudad();
	}

	@Override
	public void saveCiudad(Ciudad entity) throws Exception {
		ciudadLogic.saveCiudad(entity);
	}

	@Override
	public void deleteCiudad(Ciudad entity) throws Exception {
		ciudadLogic.deleteCiudad(entity);
	}

	@Override
	public void updateCiudad(Ciudad entity) throws Exception {
		ciudadLogic.updateCiudad(entity);
	}

	@Override
	public Ciudad getCiudad(Long ciudadId) throws Exception {
		Ciudad ciudad = null;

		try {
			ciudad = ciudadLogic.getCiudad(ciudadId);
		} catch (Exception e) {
			throw e;
		}

		return ciudad;
	}

	@Override
	public List<Ciudad> findByCriteriaInCiudad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return ciudadLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Ciudad> findPageCiudad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return ciudadLogic.findPageCiudad(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCiudad() throws Exception {
		return ciudadLogic.findTotalNumberCiudad();
	}

	@Override
	public List<CiudadDTO> getDataCiudad() throws Exception {
		return ciudadLogic.getDataCiudad();
	}

	@Override
	public List<ClaseToxicologica> getClaseToxicologica() throws Exception {
		return claseToxicologicaLogic.getClaseToxicologica();
	}

	@Override
	public void saveClaseToxicologica(ClaseToxicologica entity) throws Exception {
		claseToxicologicaLogic.saveClaseToxicologica(entity);
	}

	@Override
	public void deleteClaseToxicologica(ClaseToxicologica entity) throws Exception {
		claseToxicologicaLogic.deleteClaseToxicologica(entity);
	}

	@Override
	public void updateClaseToxicologica(ClaseToxicologica entity) throws Exception {
		claseToxicologicaLogic.updateClaseToxicologica(entity);
	}

	@Override
	public ClaseToxicologica getClaseToxicologica(Long claseToxicId) throws Exception {
		ClaseToxicologica claseToxicologica = null;

		try {
			claseToxicologica = claseToxicologicaLogic.getClaseToxicologica(claseToxicId);
		} catch (Exception e) {
			throw e;
		}

		return claseToxicologica;
	}

	@Override
	public List<ClaseToxicologica> findByCriteriaInClaseToxicologica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return claseToxicologicaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ClaseToxicologica> findPageClaseToxicologica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return claseToxicologicaLogic.findPageClaseToxicologica(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberClaseToxicologica() throws Exception {
		return claseToxicologicaLogic.findTotalNumberClaseToxicologica();
	}

	@Override
	public List<ClaseToxicologicaDTO> getDataClaseToxicologica() throws Exception {
		return claseToxicologicaLogic.getDataClaseToxicologica();
	}

	@Override
	public List<ConceptoNomina> getConceptoNomina() throws Exception {
		return conceptoNominaLogic.getConceptoNomina();
	}

	@Override
	public void saveConceptoNomina(ConceptoNomina entity) throws Exception {
		conceptoNominaLogic.saveConceptoNomina(entity);
	}

	@Override
	public void deleteConceptoNomina(ConceptoNomina entity) throws Exception {
		conceptoNominaLogic.deleteConceptoNomina(entity);
	}

	@Override
	public void updateConceptoNomina(ConceptoNomina entity) throws Exception {
		conceptoNominaLogic.updateConceptoNomina(entity);
	}

	@Override
	public ConceptoNomina getConceptoNomina(Long ceptoNominaId) throws Exception {
		ConceptoNomina conceptoNomina = null;

		try {
			conceptoNomina = conceptoNominaLogic.getConceptoNomina(ceptoNominaId);
		} catch (Exception e) {
			throw e;
		}

		return conceptoNomina;
	}

	@Override
	public List<ConceptoNomina> findByCriteriaInConceptoNomina(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return conceptoNominaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ConceptoNomina> findPageConceptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return conceptoNominaLogic.findPageConceptoNomina(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberConceptoNomina() throws Exception {
		return conceptoNominaLogic.findTotalNumberConceptoNomina();
	}

	@Override
	public List<ConceptoNominaDTO> getDataConceptoNomina() throws Exception {
		return conceptoNominaLogic.getDataConceptoNomina();
	}

	@Override
	public List<Conductor> getConductor() throws Exception {
		return conductorLogic.getConductor();
	}

	@Override
	public void saveConductor(Conductor entity) throws Exception {
		conductorLogic.saveConductor(entity);
	}

	@Override
	public void deleteConductor(Conductor entity) throws Exception {
		conductorLogic.deleteConductor(entity);
	}

	@Override
	public void updateConductor(Conductor entity) throws Exception {
		conductorLogic.updateConductor(entity);
	}

	@Override
	public Conductor getConductor(Long conductorId) throws Exception {
		Conductor conductor = null;

		try {
			conductor = conductorLogic.getConductor(conductorId);
		} catch (Exception e) {
			throw e;
		}

		return conductor;
	}

	@Override
	public List<Conductor> findByCriteriaInConductor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return conductorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Conductor> findPageConductor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return conductorLogic.findPageConductor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberConductor() throws Exception {
		return conductorLogic.findTotalNumberConductor();
	}

	@Override
	public List<ConductorDTO> getDataConductor() throws Exception {
		return conductorLogic.getDataConductor();
	}

	@Override
	public List<CostoRecurso> getCostoRecurso() throws Exception {
		return costoRecursoLogic.getCostoRecurso();
	}

	@Override
	public void saveCostoRecurso(CostoRecurso entity) throws Exception {
		costoRecursoLogic.saveCostoRecurso(entity);
	}

	@Override
	public void deleteCostoRecurso(CostoRecurso entity) throws Exception {
		costoRecursoLogic.deleteCostoRecurso(entity);
	}

	@Override
	public void updateCostoRecurso(CostoRecurso entity) throws Exception {
		costoRecursoLogic.updateCostoRecurso(entity);
	}

	@Override
	public CostoRecurso getCostoRecurso(CostoRecursoId id) throws Exception {
		CostoRecurso costoRecurso = null;

		try {
			costoRecurso = costoRecursoLogic.getCostoRecurso(id);
		} catch (Exception e) {
			throw e;
		}

		return costoRecurso;
	}

	@Override
	public List<CostoRecurso> findByCriteriaInCostoRecurso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return costoRecursoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CostoRecurso> findPageCostoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return costoRecursoLogic.findPageCostoRecurso(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCostoRecurso() throws Exception {
		return costoRecursoLogic.findTotalNumberCostoRecurso();
	}

	@Override
	public List<CostoRecursoDTO> getDataCostoRecurso() throws Exception {
		return costoRecursoLogic.getDataCostoRecurso();
	}

	@Override
	public List<CuentaContable> getCuentaContable() throws Exception {
		return cuentaContableLogic.getCuentaContable();
	}

	@Override
	public void saveCuentaContable(CuentaContable entity) throws Exception {
		cuentaContableLogic.saveCuentaContable(entity);
	}

	@Override
	public void deleteCuentaContable(CuentaContable entity) throws Exception {
		cuentaContableLogic.deleteCuentaContable(entity);
	}

	@Override
	public void updateCuentaContable(CuentaContable entity) throws Exception {
		cuentaContableLogic.updateCuentaContable(entity);
	}

	@Override
	public CuentaContable getCuentaContable(Long ccontableId) throws Exception {
		CuentaContable cuentaContable = null;

		try {
			cuentaContable = cuentaContableLogic.getCuentaContable(ccontableId);
		} catch (Exception e) {
			throw e;
		}

		return cuentaContable;
	}

	@Override
	public List<CuentaContable> findByCriteriaInCuentaContable(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return cuentaContableLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CuentaContable> findPageCuentaContable(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return cuentaContableLogic.findPageCuentaContable(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCuentaContable() throws Exception {
		return cuentaContableLogic.findTotalNumberCuentaContable();
	}

	@Override
	public List<CuentaContableDTO> getDataCuentaContable() throws Exception {
		return cuentaContableLogic.getDataCuentaContable();
	}

	@Override
	public List<DatAplicProdDet> getDatAplicProdDet() throws Exception {
		return datAplicProdDetLogic.getDatAplicProdDet();
	}

	@Override
	public void saveDatAplicProdDet(DatAplicProdDet entity) throws Exception {
		datAplicProdDetLogic.saveDatAplicProdDet(entity);
	}

	@Override
	public void deleteDatAplicProdDet(DatAplicProdDet entity) throws Exception {
		datAplicProdDetLogic.deleteDatAplicProdDet(entity);
	}

	@Override
	public void updateDatAplicProdDet(DatAplicProdDet entity) throws Exception {
		datAplicProdDetLogic.updateDatAplicProdDet(entity);
	}

	@Override
	public DatAplicProdDet getDatAplicProdDet(Long datProdDetId) throws Exception {
		DatAplicProdDet datAplicProdDet = null;

		try {
			datAplicProdDet = datAplicProdDetLogic.getDatAplicProdDet(datProdDetId);
		} catch (Exception e) {
			throw e;
		}

		return datAplicProdDet;
	}

	@Override
	public List<DatAplicProdDet> findByCriteriaInDatAplicProdDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datAplicProdDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatAplicProdDet> findPageDatAplicProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datAplicProdDetLogic.findPageDatAplicProdDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatAplicProdDet() throws Exception {
		return datAplicProdDetLogic.findTotalNumberDatAplicProdDet();
	}

	@Override
	public List<DatAplicProdDetDTO> getDataDatAplicProdDet() throws Exception {
		return datAplicProdDetLogic.getDataDatAplicProdDet();
	}

	@Override
	public List<DatAplicProducto> getDatAplicProducto() throws Exception {
		return datAplicProductoLogic.getDatAplicProducto();
	}

	@Override
	public void deleteDatAplicProducto(DatAplicProducto entity) throws Exception {
		datAplicProductoLogic.deleteDatAplicProducto(entity);
	}

	@Override
	public DatAplicProducto getDatAplicProducto(Long datAplicProdId) throws Exception {
		DatAplicProducto datAplicProducto = null;

		try {
			datAplicProducto = datAplicProductoLogic.getDatAplicProducto(datAplicProdId);
		} catch (Exception e) {
			throw e;
		}

		return datAplicProducto;
	}

	@Override
	public List<DatAplicProducto> findByCriteriaInDatAplicProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datAplicProductoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatAplicProducto> findPageDatAplicProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datAplicProductoLogic.findPageDatAplicProducto(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatAplicProducto() throws Exception {
		return datAplicProductoLogic.findTotalNumberDatAplicProducto();
	}

	@Override
	public List<DatAplicProductoDTO> getDataDatAplicProducto() throws Exception {
		return datAplicProductoLogic.getDataDatAplicProducto();
	}

	@Override
	public List<DatEstimCosecha> getDatEstimCosecha() throws Exception {
		return datEstimCosechaLogic.getDatEstimCosecha();
	}

	@Override
	public void saveDatEstimCosecha(DatEstimCosecha entity) throws Exception {
		datEstimCosechaLogic.saveDatEstimCosecha(entity);
	}

	@Override
	public void deleteDatEstimCosecha(DatEstimCosecha entity) throws Exception {
		datEstimCosechaLogic.deleteDatEstimCosecha(entity);
	}

	@Override
	public void updateDatEstimCosecha(DatEstimCosecha entity) throws Exception {
		datEstimCosechaLogic.updateDatEstimCosecha(entity);
	}

	@Override
	public DatEstimCosecha getDatEstimCosecha(Long datEstimCosechaId) throws Exception {
		DatEstimCosecha datEstimCosecha = null;

		try {
			datEstimCosecha = datEstimCosechaLogic.getDatEstimCosecha(datEstimCosechaId);
		} catch (Exception e) {
			throw e;
		}

		return datEstimCosecha;
	}

	@Override
	public List<DatEstimCosecha> findByCriteriaInDatEstimCosecha(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datEstimCosechaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatEstimCosecha> findPageDatEstimCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datEstimCosechaLogic.findPageDatEstimCosecha(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatEstimCosecha() throws Exception {
		return datEstimCosechaLogic.findTotalNumberDatEstimCosecha();
	}

	@Override
	public List<DatEstimCosechaDTO> getDataDatEstimCosecha() throws Exception {
		return datEstimCosechaLogic.getDataDatEstimCosecha();
	}

	@Override
	public List<DatPlanillaNomina> getDatPlanillaNomina() throws Exception {
		return datPlanillaNominaLogic.getDatPlanillaNomina();
	}

	@Override
	public void saveDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,
			List<DatServicioDetDTO> dataServicioDet, List<DatAplicProdDetDTO> dataProductoDet,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4)
			throws Exception {
		datPlanillaNominaLogic.saveDatPlanillaNomina(entity, dataPlanillaDet, dataServicioDet, dataProductoDet,
				dataRiegoDet, datPlanillaNominaOnivel4);
	}

	@Override
	public void deleteDatPlanillaNomina(DatPlanillaNomina entity) throws Exception {
		datPlanillaNominaLogic.deleteDatPlanillaNomina(entity);
	}

	@Override
	public void updateDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,
			List<DatServicioDetDTO> dataServicioDet, List<DatAplicProdDetDTO> dataProductoDet,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4)
			throws Exception {
		datPlanillaNominaLogic.updateDatPlanillaNomina(entity, dataPlanillaDet, dataServicioDet, dataProductoDet,
				dataRiegoDet, datPlanillaNominaOnivel4);
	}

	@Override
	public DatPlanillaNomina getDatPlanillaNomina(Long planillaNominaId) throws Exception {
		DatPlanillaNomina datPlanillaNomina = null;

		try {
			datPlanillaNomina = datPlanillaNominaLogic.getDatPlanillaNomina(planillaNominaId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanillaNomina;
	}

	@Override
	public List<DatPlanillaNomina> findByCriteriaInDatPlanillaNomina(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datPlanillaNominaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatPlanillaNomina> findPageDatPlanillaNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datPlanillaNominaLogic.findPageDatPlanillaNomina(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatPlanillaNomina() throws Exception {
		return datPlanillaNominaLogic.findTotalNumberDatPlanillaNomina();
	}

	@Override
	public List<DatPlanillaNominaDTO> getDataDatPlanillaNomina() throws Exception {
		return datPlanillaNominaLogic.getDataDatPlanillaNomina();
	}

	@Override
	public List<DatPlanLabor> getDatPlanLabor() throws Exception {
		return datPlanLaborLogic.getDatPlanLabor();
	}

	@Override
	public void saveDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception {
		datPlanLaborLogic.saveDatPlanLabor(entity, dataPlanLaborDet);
	}

	@Override
	public void deleteDatPlanLabor(DatPlanLabor entity) throws Exception {
		datPlanLaborLogic.deleteDatPlanLabor(entity);
	}

	@Override
	public void updateDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception {
		datPlanLaborLogic.updateDatPlanLabor(entity, dataPlanLaborDet);
	}

	@Override
	public DatPlanLabor getDatPlanLabor(Long planLaborId) throws Exception {
		DatPlanLabor datPlanLabor = null;

		try {
			datPlanLabor = datPlanLaborLogic.getDatPlanLabor(planLaborId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanLabor;
	}

	@Override
	public List<DatPlanLabor> findByCriteriaInDatPlanLabor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datPlanLaborLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatPlanLabor> findPageDatPlanLabor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datPlanLaborLogic.findPageDatPlanLabor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatPlanLabor() throws Exception {
		return datPlanLaborLogic.findTotalNumberDatPlanLabor();
	}

	@Override
	public List<DatPlanLaborDTO> getDataDatPlanLabor() throws Exception {
		return datPlanLaborLogic.getDataDatPlanLabor();
	}

	@Override
	public List<DatRiego> getDatRiego() throws Exception {
		return datRiegoLogic.getDatRiego();
	}

	@Override
	public void saveDatRiego(DatRiego entity) throws Exception {
		datRiegoLogic.saveDatRiego(entity);
	}

	@Override
	public void deleteDatRiego(DatRiego entity) throws Exception {
		datRiegoLogic.deleteDatRiego(entity);
	}

	@Override
	public void updateDatRiego(DatRiego entity) throws Exception {
		datRiegoLogic.updateDatRiego(entity);
	}

	@Override
	public DatRiego getDatRiego(Long datRiegoId) throws Exception {
		DatRiego datRiego = null;

		try {
			datRiego = datRiegoLogic.getDatRiego(datRiegoId);
		} catch (Exception e) {
			throw e;
		}

		return datRiego;
	}

	@Override
	public List<DatRiego> findByCriteriaInDatRiego(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datRiegoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatRiego> findPageDatRiego(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return datRiegoLogic.findPageDatRiego(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatRiego() throws Exception {
		return datRiegoLogic.findTotalNumberDatRiego();
	}

	@Override
	public List<DatRiegoDTO> getDataDatRiego() throws Exception {
		return datRiegoLogic.getDataDatRiego();
	}

	@Override
	public List<DatServicio> getDatServicio() throws Exception {
		return datServicioLogic.getDatServicio();
	}

	@Override
	public void saveDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception {
		datServicioLogic.saveDatServicio(entity, dataDetServicio);
	}

	@Override
	public void deleteDatServicio(DatServicio entity) throws Exception {
		datServicioLogic.deleteDatServicio(entity);
	}

	@Override
	public void updateDatServicio(DatServicio entity, List<DatServicioDetDTO> dataDetServicio) throws Exception {
		datServicioLogic.updateDatServicio(entity, dataDetServicio);
	}

	@Override
	public DatServicio getDatServicio(Long datServicioId) throws Exception {
		DatServicio datServicio = null;

		try {
			datServicio = datServicioLogic.getDatServicio(datServicioId);
		} catch (Exception e) {
			throw e;
		}

		return datServicio;
	}

	@Override
	public List<DatServicio> findByCriteriaInDatServicio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datServicioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatServicio> findPageDatServicio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datServicioLogic.findPageDatServicio(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatServicio() throws Exception {
		return datServicioLogic.findTotalNumberDatServicio();
	}

	@Override
	public List<DatServicioDTO> getDataDatServicio() throws Exception {
		return datServicioLogic.getDataDatServicio();
	}

	@Override
	public List<DatTransProd> getDatTransProd() throws Exception {
		return datTransProdLogic.getDatTransProd();
	}

	/*
	 * public void saveDatTransProd(DatTransProd entity) throws Exception {
	 * datTransProdLogic.saveDatTransProd(entity); }
	 */

	@Override
	public void deleteDatTransProd(DatTransProd entity) throws Exception {
		datTransProdLogic.deleteDatTransProd(entity);
	}

	/*
	 * public void updateDatTransProd(DatTransProd entity) throws Exception {
	 * datTransProdLogic.updateDatTransProd(entity); }
	 */

	@Override
	public DatTransProd getDatTransProd(Long datTransProdId) throws Exception {
		DatTransProd datTransProd = null;

		try {
			datTransProd = datTransProdLogic.getDatTransProd(datTransProdId);
		} catch (Exception e) {
			throw e;
		}

		return datTransProd;
	}

	@Override
	public List<DatTransProd> findByCriteriaInDatTransProd(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datTransProdLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatTransProd> findPageDatTransProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datTransProdLogic.findPageDatTransProd(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatTransProd() throws Exception {
		return datTransProdLogic.findTotalNumberDatTransProd();
	}

	@Override
	public List<DatTransProdDTO> getDataDatTransProd() throws Exception {
		return datTransProdLogic.getDataDatTransProd();
	}

	@Override
	public List<DatTransProdDet> getDatTransProdDet() throws Exception {
		return datTransProdDetLogic.getDatTransProdDet();
	}

	@Override
	public void saveDatTransProdDet(DatTransProdDet entity) throws Exception {
		datTransProdDetLogic.saveDatTransProdDet(entity);
	}

	@Override
	public void deleteDatTransProdDet(DatTransProdDet entity) throws Exception {
		datTransProdDetLogic.deleteDatTransProdDet(entity);
	}

	@Override
	public void updateDatTransProdDet(DatTransProdDet entity) throws Exception {
		datTransProdDetLogic.updateDatTransProdDet(entity);
	}

	@Override
	public DatTransProdDet getDatTransProdDet(Long datTransProdDetId) throws Exception {
		DatTransProdDet datTransProdDet = null;

		try {
			datTransProdDet = datTransProdDetLogic.getDatTransProdDet(datTransProdDetId);
		} catch (Exception e) {
			throw e;
		}

		return datTransProdDet;
	}

	@Override
	public List<DatTransProdDet> findByCriteriaInDatTransProdDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datTransProdDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatTransProdDet> findPageDatTransProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datTransProdDetLogic.findPageDatTransProdDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatTransProdDet() throws Exception {
		return datTransProdDetLogic.findTotalNumberDatTransProdDet();
	}

	@Override
	public List<DatTransProdDetDTO> getDataDatTransProdDet() throws Exception {
		return datTransProdDetLogic.getDataDatTransProdDet();
	}

	@Override
	public List<ElementoCosto> getElementoCosto() throws Exception {
		return elementoCostoLogic.getElementoCosto();
	}

	@Override
	public void saveElementoCosto(ElementoCosto entity) throws Exception {
		elementoCostoLogic.saveElementoCosto(entity);
	}

	@Override
	public void deleteElementoCosto(ElementoCosto entity) throws Exception {
		elementoCostoLogic.deleteElementoCosto(entity);
	}

	@Override
	public void updateElementoCosto(ElementoCosto entity) throws Exception {
		elementoCostoLogic.updateElementoCosto(entity);
	}

	@Override
	public ElementoCosto getElementoCosto(Long elemCostoId) throws Exception {
		ElementoCosto elementoCosto = null;

		try {
			elementoCosto = elementoCostoLogic.getElementoCosto(elemCostoId);
		} catch (Exception e) {
			throw e;
		}

		return elementoCosto;
	}

	@Override
	public List<ElementoCosto> findByCriteriaInElementoCosto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return elementoCostoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ElementoCosto> findPageElementoCosto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return elementoCostoLogic.findPageElementoCosto(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberElementoCosto() throws Exception {
		return elementoCostoLogic.findTotalNumberElementoCosto();
	}

	@Override
	public List<ElementoCostoDTO> getDataElementoCosto() throws Exception {
		return elementoCostoLogic.getDataElementoCosto();
	}

	@Override
	public List<Empaque> getEmpaque() throws Exception {
		return empaqueLogic.getEmpaque();
	}

	@Override
	public void saveEmpaque(Empaque entity) throws Exception {
		empaqueLogic.saveEmpaque(entity);
	}

	@Override
	public void deleteEmpaque(Empaque entity) throws Exception {
		empaqueLogic.deleteEmpaque(entity);
	}

	@Override
	public void updateEmpaque(Empaque entity) throws Exception {
		empaqueLogic.updateEmpaque(entity);
	}

	@Override
	public Empaque getEmpaque(Long empaqueId) throws Exception {
		Empaque empaque = null;

		try {
			empaque = empaqueLogic.getEmpaque(empaqueId);
		} catch (Exception e) {
			throw e;
		}

		return empaque;
	}

	@Override
	public List<Empaque> findByCriteriaInEmpaque(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return empaqueLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Empaque> findPageEmpaque(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return empaqueLogic.findPageEmpaque(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEmpaque() throws Exception {
		return empaqueLogic.findTotalNumberEmpaque();
	}

	@Override
	public List<EmpaqueDTO> getDataEmpaque() throws Exception {
		return empaqueLogic.getDataEmpaque();
	}

	@Override
	public List<EmpaqueProducto> getEmpaqueProducto() throws Exception {
		return empaqueProductoLogic.getEmpaqueProducto();
	}

	@Override
	public void saveEmpaqueProducto(EmpaqueProducto entity) throws Exception {
		empaqueProductoLogic.saveEmpaqueProducto(entity);
	}

	@Override
	public void deleteEmpaqueProducto(EmpaqueProducto entity) throws Exception {
		empaqueProductoLogic.deleteEmpaqueProducto(entity);
	}

	@Override
	public void updateEmpaqueProducto(EmpaqueProducto entity) throws Exception {
		empaqueProductoLogic.updateEmpaqueProducto(entity);
	}

	@Override
	public EmpaqueProducto getEmpaqueProducto(EmpaqueProductoId id) throws Exception {
		EmpaqueProducto empaqueProducto = null;

		try {
			empaqueProducto = empaqueProductoLogic.getEmpaqueProducto(id);
		} catch (Exception e) {
			throw e;
		}

		return empaqueProducto;
	}

	@Override
	public List<EmpaqueProducto> findByCriteriaInEmpaqueProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return empaqueProductoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EmpaqueProducto> findPageEmpaqueProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return empaqueProductoLogic.findPageEmpaqueProducto(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEmpaqueProducto() throws Exception {
		return empaqueProductoLogic.findTotalNumberEmpaqueProducto();
	}

	@Override
	public List<EmpaqueProductoDTO> getDataEmpaqueProducto() throws Exception {
		return empaqueProductoLogic.getDataEmpaqueProducto();
	}

	@Override
	public List<Equipo> getEquipo() throws Exception {
		return equipoLogic.getEquipo();
	}

	@Override
	public void deleteEquipo(Equipo entity) throws Exception {
		equipoLogic.deleteEquipo(entity);
	}

	@Override
	public Equipo getEquipo(Long equipoId) throws Exception {
		Equipo equipo = null;

		try {
			equipo = equipoLogic.getEquipo(equipoId);
		} catch (Exception e) {
			throw e;
		}

		return equipo;
	}

	@Override
	public List<Equipo> findByCriteriaInEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return equipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Equipo> findPageEquipo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return equipoLogic.findPageEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEquipo() throws Exception {
		return equipoLogic.findTotalNumberEquipo();
	}

	@Override
	public List<EquipoDTO> getDataEquipo() throws Exception {
		return equipoLogic.getDataEquipo();
	}

	@Override
	public List<EquipoTrabajo> getEquipoTrabajo() throws Exception {
		return equipoTrabajoLogic.getEquipoTrabajo();
	}

	@Override
	public void saveEquipoTrabajo(EquipoTrabajo entity) throws Exception {
		equipoTrabajoLogic.saveEquipoTrabajo(entity);
	}

	@Override
	public void deleteEquipoTrabajo(EquipoTrabajo entity) throws Exception {
		equipoTrabajoLogic.deleteEquipoTrabajo(entity);
	}

	@Override
	public void updateEquipoTrabajo(EquipoTrabajo entity) throws Exception {
		equipoTrabajoLogic.updateEquipoTrabajo(entity);
	}

	@Override
	public EquipoTrabajo getEquipoTrabajo(Long eqpTrabId) throws Exception {
		EquipoTrabajo equipoTrabajo = null;

		try {
			equipoTrabajo = equipoTrabajoLogic.getEquipoTrabajo(eqpTrabId);
		} catch (Exception e) {
			throw e;
		}

		return equipoTrabajo;
	}

	@Override
	public List<EquipoTrabajo> findByCriteriaInEquipoTrabajo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return equipoTrabajoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EquipoTrabajo> findPageEquipoTrabajo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return equipoTrabajoLogic.findPageEquipoTrabajo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEquipoTrabajo() throws Exception {
		return equipoTrabajoLogic.findTotalNumberEquipoTrabajo();
	}

	@Override
	public List<EquipoTrabajoDTO> getDataEquipoTrabajo() throws Exception {
		return equipoTrabajoLogic.getDataEquipoTrabajo();
	}

	@Override
	public List<Estado> getEstado() throws Exception {
		return estadoLogic.getEstado();
	}

	@Override
	public void saveEstado(Estado entity) throws Exception {
		estadoLogic.saveEstado(entity);
	}

	@Override
	public void deleteEstado(Estado entity) throws Exception {
		estadoLogic.deleteEstado(entity);
	}

	@Override
	public void updateEstado(Estado entity) throws Exception {
		estadoLogic.updateEstado(entity);
	}

	@Override
	public Estado getEstado(Long estadoId) throws Exception {
		Estado estado = null;

		try {
			estado = estadoLogic.getEstado(estadoId);
		} catch (Exception e) {
			throw e;
		}

		return estado;
	}

	@Override
	public List<Estado> findByCriteriaInEstado(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estadoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Estado> findPageEstado(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return estadoLogic.findPageEstado(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEstado() throws Exception {
		return estadoLogic.findTotalNumberEstado();
	}

	@Override
	public List<EstadoDTO> getDataEstado() throws Exception {
		return estadoLogic.getDataEstado();
	}

	@Override
	public List<FabricanteEquipo> getFabricanteEquipo() throws Exception {
		return fabricanteEquipoLogic.getFabricanteEquipo();
	}

	@Override
	public void saveFabricanteEquipo(FabricanteEquipo entity) throws Exception {
		fabricanteEquipoLogic.saveFabricanteEquipo(entity);
	}

	@Override
	public void deleteFabricanteEquipo(FabricanteEquipo entity) throws Exception {
		fabricanteEquipoLogic.deleteFabricanteEquipo(entity);
	}

	@Override
	public void updateFabricanteEquipo(FabricanteEquipo entity) throws Exception {
		fabricanteEquipoLogic.updateFabricanteEquipo(entity);
	}

	@Override
	public FabricanteEquipo getFabricanteEquipo(Long fabricEquipId) throws Exception {
		FabricanteEquipo fabricanteEquipo = null;

		try {
			fabricanteEquipo = fabricanteEquipoLogic.getFabricanteEquipo(fabricEquipId);
		} catch (Exception e) {
			throw e;
		}

		return fabricanteEquipo;
	}

	@Override
	public List<FabricanteEquipo> findByCriteriaInFabricanteEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return fabricanteEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<FabricanteEquipo> findPageFabricanteEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return fabricanteEquipoLogic.findPageFabricanteEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFabricanteEquipo() throws Exception {
		return fabricanteEquipoLogic.findTotalNumberFabricanteEquipo();
	}

	@Override
	public List<FabricanteEquipoDTO> getDataFabricanteEquipo() throws Exception {
		return fabricanteEquipoLogic.getDataFabricanteEquipo();
	}

	@Override
	public List<FactorConversion> getFactorConversion() throws Exception {
		return factorConversionLogic.getFactorConversion();
	}

	@Override
	public void saveFactorConversion(FactorConversion entity) throws Exception {
		factorConversionLogic.saveFactorConversion(entity);
	}

	@Override
	public void deleteFactorConversion(FactorConversion entity) throws Exception {
		factorConversionLogic.deleteFactorConversion(entity);
	}

	@Override
	public void updateFactorConversion(FactorConversion entity) throws Exception {
		factorConversionLogic.updateFactorConversion(entity);
	}

	@Override
	public FactorConversion getFactorConversion(Long factorConversionId) throws Exception {
		FactorConversion factorConversion = null;

		try {
			factorConversion = factorConversionLogic.getFactorConversion(factorConversionId);
		} catch (Exception e) {
			throw e;
		}

		return factorConversion;
	}

	@Override
	public List<FactorConversion> findByCriteriaInFactorConversion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return factorConversionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<FactorConversion> findPageFactorConversion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return factorConversionLogic.findPageFactorConversion(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFactorConversion() throws Exception {
		return factorConversionLogic.findTotalNumberFactorConversion();
	}

	@Override
	public List<FactorConversionDTO> getDataFactorConversion() throws Exception {
		return factorConversionLogic.getDataFactorConversion();
	}

	@Override
	public List<FlotaTransporte> getFlotaTransporte() throws Exception {
		return flotaTransporteLogic.getFlotaTransporte();
	}

	@Override
	public void saveFlotaTransporte(FlotaTransporte entity) throws Exception {
		flotaTransporteLogic.saveFlotaTransporte(entity);
	}

	@Override
	public void deleteFlotaTransporte(FlotaTransporte entity) throws Exception {
		flotaTransporteLogic.deleteFlotaTransporte(entity);
	}

	@Override
	public void updateFlotaTransporte(FlotaTransporte entity) throws Exception {
		flotaTransporteLogic.updateFlotaTransporte(entity);
	}

	@Override
	public FlotaTransporte getFlotaTransporte(Long flotaTranspId) throws Exception {
		FlotaTransporte flotaTransporte = null;

		try {
			flotaTransporte = flotaTransporteLogic.getFlotaTransporte(flotaTranspId);
		} catch (Exception e) {
			throw e;
		}

		return flotaTransporte;
	}

	@Override
	public List<FlotaTransporte> findByCriteriaInFlotaTransporte(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return flotaTransporteLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<FlotaTransporte> findPageFlotaTransporte(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return flotaTransporteLogic.findPageFlotaTransporte(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFlotaTransporte() throws Exception {
		return flotaTransporteLogic.findTotalNumberFlotaTransporte();
	}

	@Override
	public List<FlotaTransporteDTO> getDataFlotaTransporte() throws Exception {
		return flotaTransporteLogic.getDataFlotaTransporte();
	}

	@Override
	public List<GrpLabor> getGrpLabor() throws Exception {
		return grpLaborLogic.getGrpLabor();
	}

	@Override
	public void saveGrpLabor(GrpLabor entity) throws Exception {
		grpLaborLogic.saveGrpLabor(entity);
	}

	@Override
	public void deleteGrpLabor(GrpLabor entity) throws Exception {
		grpLaborLogic.deleteGrpLabor(entity);
	}

	@Override
	public void updateGrpLabor(GrpLabor entity) throws Exception {
		grpLaborLogic.updateGrpLabor(entity);
	}

	@Override
	public GrpLabor getGrpLabor(Long grpLaborId) throws Exception {
		GrpLabor grpLabor = null;

		try {
			grpLabor = grpLaborLogic.getGrpLabor(grpLaborId);
		} catch (Exception e) {
			throw e;
		}

		return grpLabor;
	}

	@Override
	public List<GrpLabor> findByCriteriaInGrpLabor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return grpLaborLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<GrpLabor> findPageGrpLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return grpLaborLogic.findPageGrpLabor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberGrpLabor() throws Exception {
		return grpLaborLogic.findTotalNumberGrpLabor();
	}

	@Override
	public List<GrpLaborDTO> getDataGrpLabor() throws Exception {
		return grpLaborLogic.getDataGrpLabor();
	}

	@Override
	public List<Infraestructura> getInfraestructura() throws Exception {
		return infraestructuraLogic.getInfraestructura();
	}

	@Override
	public void saveInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> dataTarifaInfraestructura)
			throws Exception {
		infraestructuraLogic.saveInfraestructura(entity, dataTarifaInfraestructura);
	}

	@Override
	public void deleteInfraestructura(Infraestructura entity) throws Exception {
		infraestructuraLogic.deleteInfraestructura(entity);
	}

	@Override
	public void updateInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> dataTarifaInfraestructura)
			throws Exception {
		infraestructuraLogic.updateInfraestructura(entity, dataTarifaInfraestructura);
	}

	@Override
	public Infraestructura getInfraestructura(Long infraId) throws Exception {
		Infraestructura infraestructura = null;

		try {
			infraestructura = infraestructuraLogic.getInfraestructura(infraId);
		} catch (Exception e) {
			throw e;
		}

		return infraestructura;
	}

	@Override
	public List<Infraestructura> findByCriteriaInInfraestructura(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return infraestructuraLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Infraestructura> findPageInfraestructura(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return infraestructuraLogic.findPageInfraestructura(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberInfraestructura() throws Exception {
		return infraestructuraLogic.findTotalNumberInfraestructura();
	}

	@Override
	public List<InfraestructuraDTO> getDataInfraestructura() throws Exception {
		return infraestructuraLogic.getDataInfraestructura();
	}

	public List<IngredienteActivo> getIngredienteActivo() throws Exception {
		return ingredienteActivoLogic.getIngredienteActivo();
	}

	public void saveIngredienteActivo(IngredienteActivo entity) throws Exception {
		ingredienteActivoLogic.saveIngredienteActivo(entity);
	}

	public void deleteIngredienteActivo(IngredienteActivo entity) throws Exception {
		ingredienteActivoLogic.deleteIngredienteActivo(entity);
	}

	public void updateIngredienteActivo(IngredienteActivo entity) throws Exception {
		ingredienteActivoLogic.updateIngredienteActivo(entity);
	}

	public IngredienteActivo getIngredienteActivo(Long ingredienteActId) throws Exception {
		IngredienteActivo ingredienteActivo = null;

		try {
			ingredienteActivo = ingredienteActivoLogic.getIngredienteActivo(ingredienteActId);
		} catch (Exception e) {
			throw e;
		}

		return ingredienteActivo;
	}

	public List<IngredienteActivo> findByCriteriaInIngredienteActivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return ingredienteActivoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<IngredienteActivo> findPageIngredienteActivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return ingredienteActivoLogic.findPageIngredienteActivo(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberIngredienteActivo() throws Exception {
		return ingredienteActivoLogic.findTotalNumberIngredienteActivo();
	}

	public List<IngredienteActivoDTO> getDataIngredienteActivo() throws Exception {
		return ingredienteActivoLogic.getDataIngredienteActivo();
	}

	@Override
	public List<Labor> getLabor() throws Exception {
		return laborLogic.getLabor();
	}

	@Override
	public void deleteLabor(Labor entity) throws Exception {
		laborLogic.deleteLabor(entity);
	}

	@Override
	public Labor getLabor(Long laborId) throws Exception {
		Labor labor = null;

		try {
			labor = laborLogic.getLabor(laborId);
		} catch (Exception e) {
			throw e;
		}

		return labor;
	}

	@Override
	public List<Labor> findByCriteriaInLabor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return laborLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Labor> findPageLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return laborLogic.findPageLabor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberLabor() throws Exception {
		return laborLogic.findTotalNumberLabor();
	}

	@Override
	public List<LaborDTO> getDataLabor() throws Exception {
		return laborLogic.getDataLabor();
	}

	@Override
	public List<LimiteCeptoNomina> getLimiteCeptoNomina() throws Exception {
		return limiteCeptoNominaLogic.getLimiteCeptoNomina();
	}

	@Override
	public void saveLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception {
		limiteCeptoNominaLogic.saveLimiteCeptoNomina(entity);
	}

	@Override
	public void deleteLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception {
		limiteCeptoNominaLogic.deleteLimiteCeptoNomina(entity);
	}

	@Override
	public void updateLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception {
		limiteCeptoNominaLogic.updateLimiteCeptoNomina(entity);
	}

	@Override
	public LimiteCeptoNomina getLimiteCeptoNomina(LimiteCeptoNominaId id) throws Exception {
		LimiteCeptoNomina limiteCeptoNomina = null;

		try {
			limiteCeptoNomina = limiteCeptoNominaLogic.getLimiteCeptoNomina(id);
		} catch (Exception e) {
			throw e;
		}

		return limiteCeptoNomina;
	}

	@Override
	public List<LimiteCeptoNomina> findByCriteriaInLimiteCeptoNomina(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return limiteCeptoNominaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<LimiteCeptoNomina> findPageLimiteCeptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return limiteCeptoNominaLogic.findPageLimiteCeptoNomina(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberLimiteCeptoNomina() throws Exception {
		return limiteCeptoNominaLogic.findTotalNumberLimiteCeptoNomina();
	}

	@Override
	public List<LimiteCeptoNominaDTO> getDataLimiteCeptoNomina() throws Exception {
		return limiteCeptoNominaLogic.getDataLimiteCeptoNomina();
	}

	@Override
	public List<Medidor> getMedidor() throws Exception {
		return medidorLogic.getMedidor();
	}

	@Override
	public void saveMedidor(Medidor entity) throws Exception {
		medidorLogic.saveMedidor(entity);
	}

	@Override
	public void deleteMedidor(Medidor entity) throws Exception {
		medidorLogic.deleteMedidor(entity);
	}

	@Override
	public void updateMedidor(Medidor entity) throws Exception {
		medidorLogic.updateMedidor(entity);
	}

	@Override
	public Medidor getMedidor(Long medidorId) throws Exception {
		Medidor medidor = null;

		try {
			medidor = medidorLogic.getMedidor(medidorId);
		} catch (Exception e) {
			throw e;
		}

		return medidor;
	}

	@Override
	public List<Medidor> findByCriteriaInMedidor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return medidorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Medidor> findPageMedidor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return medidorLogic.findPageMedidor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberMedidor() throws Exception {
		return medidorLogic.findTotalNumberMedidor();
	}

	@Override
	public List<MedidorDTO> getDataMedidor() throws Exception {
		return medidorLogic.getDataMedidor();
	}

	@Override
	public List<ModalidadCosecha> getModalidadCosecha() throws Exception {
		return modalidadCosechaLogic.getModalidadCosecha();
	}

	@Override
	public void saveModalidadCosecha(ModalidadCosecha entity) throws Exception {
		modalidadCosechaLogic.saveModalidadCosecha(entity);
	}

	@Override
	public void deleteModalidadCosecha(ModalidadCosecha entity) throws Exception {
		modalidadCosechaLogic.deleteModalidadCosecha(entity);
	}

	@Override
	public void updateModalidadCosecha(ModalidadCosecha entity) throws Exception {
		modalidadCosechaLogic.updateModalidadCosecha(entity);
	}

	@Override
	public ModalidadCosecha getModalidadCosecha(Long modalidadCosId) throws Exception {
		ModalidadCosecha modalidadCosecha = null;

		try {
			modalidadCosecha = modalidadCosechaLogic.getModalidadCosecha(modalidadCosId);
		} catch (Exception e) {
			throw e;
		}

		return modalidadCosecha;
	}

	@Override
	public List<ModalidadCosecha> findByCriteriaInModalidadCosecha(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return modalidadCosechaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ModalidadCosecha> findPageModalidadCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return modalidadCosechaLogic.findPageModalidadCosecha(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberModalidadCosecha() throws Exception {
		return modalidadCosechaLogic.findTotalNumberModalidadCosecha();
	}

	@Override
	public List<ModalidadCosechaDTO> getDataModalidadCosecha() throws Exception {
		return modalidadCosechaLogic.getDataModalidadCosecha();
	}

	@Override
	public List<ModeloEquipo> getModeloEquipo() throws Exception {
		return modeloEquipoLogic.getModeloEquipo();
	}

	@Override
	public void saveModeloEquipo(ModeloEquipo entity) throws Exception {
		modeloEquipoLogic.saveModeloEquipo(entity);
	}

	@Override
	public void deleteModeloEquipo(ModeloEquipo entity) throws Exception {
		modeloEquipoLogic.deleteModeloEquipo(entity);
	}

	@Override
	public void updateModeloEquipo(ModeloEquipo entity) throws Exception {
		modeloEquipoLogic.updateModeloEquipo(entity);
	}

	@Override
	public ModeloEquipo getModeloEquipo(Long modeloEquipoId) throws Exception {
		ModeloEquipo modeloEquipo = null;

		try {
			modeloEquipo = modeloEquipoLogic.getModeloEquipo(modeloEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return modeloEquipo;
	}

	@Override
	public List<ModeloEquipo> findByCriteriaInModeloEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return modeloEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ModeloEquipo> findPageModeloEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return modeloEquipoLogic.findPageModeloEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberModeloEquipo() throws Exception {
		return modeloEquipoLogic.findTotalNumberModeloEquipo();
	}

	@Override
	public List<ModeloEquipoDTO> getDataModeloEquipo() throws Exception {
		return modeloEquipoLogic.getDataModeloEquipo();
	}

	@Override
	public List<MotivoCierreOt> getMotivoCierreOt() throws Exception {
		return motivoCierreOtLogic.getMotivoCierreOt();
	}

	@Override
	public void saveMotivoCierreOt(MotivoCierreOt entity) throws Exception {
		motivoCierreOtLogic.saveMotivoCierreOt(entity);
	}

	@Override
	public void deleteMotivoCierreOt(MotivoCierreOt entity) throws Exception {
		motivoCierreOtLogic.deleteMotivoCierreOt(entity);
	}

	@Override
	public void updateMotivoCierreOt(MotivoCierreOt entity) throws Exception {
		motivoCierreOtLogic.updateMotivoCierreOt(entity);
	}

	@Override
	public MotivoCierreOt getMotivoCierreOt(Long motCierreOtId) throws Exception {
		MotivoCierreOt motivoCierreOt = null;

		try {
			motivoCierreOt = motivoCierreOtLogic.getMotivoCierreOt(motCierreOtId);
		} catch (Exception e) {
			throw e;
		}

		return motivoCierreOt;
	}

	@Override
	public List<MotivoCierreOt> findByCriteriaInMotivoCierreOt(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return motivoCierreOtLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<MotivoCierreOt> findPageMotivoCierreOt(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return motivoCierreOtLogic.findPageMotivoCierreOt(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberMotivoCierreOt() throws Exception {
		return motivoCierreOtLogic.findTotalNumberMotivoCierreOt();
	}

	@Override
	public List<MotivoCierreOtDTO> getDataMotivoCierreOt() throws Exception {
		return motivoCierreOtLogic.getDataMotivoCierreOt();
	}

	@Override
	public List<NumeroEje> getNumeroEje() throws Exception {
		return numeroEjeLogic.getNumeroEje();
	}

	@Override
	public void saveNumeroEje(NumeroEje entity) throws Exception {
		numeroEjeLogic.saveNumeroEje(entity);
	}

	@Override
	public void deleteNumeroEje(NumeroEje entity) throws Exception {
		numeroEjeLogic.deleteNumeroEje(entity);
	}

	@Override
	public void updateNumeroEje(NumeroEje entity) throws Exception {
		numeroEjeLogic.updateNumeroEje(entity);
	}

	@Override
	public NumeroEje getNumeroEje(Long numEjeId) throws Exception {
		NumeroEje numeroEje = null;

		try {
			numeroEje = numeroEjeLogic.getNumeroEje(numEjeId);
		} catch (Exception e) {
			throw e;
		}

		return numeroEje;
	}

	@Override
	public List<NumeroEje> findByCriteriaInNumeroEje(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return numeroEjeLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<NumeroEje> findPageNumeroEje(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return numeroEjeLogic.findPageNumeroEje(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNumeroEje() throws Exception {
		return numeroEjeLogic.findTotalNumberNumeroEje();
	}

	@Override
	public List<NumeroEjeDTO> getDataNumeroEje() throws Exception {
		return numeroEjeLogic.getDataNumeroEje();
	}

	@Override
	public List<Pais> getPais() throws Exception {
		return paisLogic.getPais();
	}

	@Override
	public void savePais(Pais entity) throws Exception {
		paisLogic.savePais(entity);
	}

	@Override
	public void deletePais(Pais entity) throws Exception {
		paisLogic.deletePais(entity);
	}

	@Override
	public void updatePais(Pais entity) throws Exception {
		paisLogic.updatePais(entity);
	}

	@Override
	public Pais getPais(Long paisId) throws Exception {
		Pais pais = null;

		try {
			pais = paisLogic.getPais(paisId);
		} catch (Exception e) {
			throw e;
		}

		return pais;
	}

	@Override
	public List<Pais> findByCriteriaInPais(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return paisLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Pais> findPagePais(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return paisLogic.findPagePais(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberPais() throws Exception {
		return paisLogic.findTotalNumberPais();
	}

	@Override
	public List<PaisDTO> getDataPais() throws Exception {
		return paisLogic.getDataPais();
	}

	@Override
	public List<PlanAsignarRecurso> getPlanAsignarRecurso() throws Exception {
		return planAsignarRecursoLogic.getPlanAsignarRecurso();
	}

	@Override
	public void savePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception {
		planAsignarRecursoLogic.savePlanAsignarRecurso(entity);
	}

	@Override
	public void deletePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception {
		planAsignarRecursoLogic.deletePlanAsignarRecurso(entity);
	}

	@Override
	public void updatePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception {
		planAsignarRecursoLogic.updatePlanAsignarRecurso(entity);
	}

	@Override
	public PlanAsignarRecurso getPlanAsignarRecurso(PlanAsignarRecursoId id) throws Exception {
		PlanAsignarRecurso planAsignarRecurso = null;

		try {
			planAsignarRecurso = planAsignarRecursoLogic.getPlanAsignarRecurso(id);
		} catch (Exception e) {
			throw e;
		}

		return planAsignarRecurso;
	}

	@Override
	public List<PlanAsignarRecurso> findByCriteriaInPlanAsignarRecurso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return planAsignarRecursoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<PlanAsignarRecurso> findPagePlanAsignarRecurso(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return planAsignarRecursoLogic.findPagePlanAsignarRecurso(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberPlanAsignarRecurso() throws Exception {
		return planAsignarRecursoLogic.findTotalNumberPlanAsignarRecurso();
	}

	@Override
	public List<PlanAsignarRecursoDTO> getDataPlanAsignarRecurso() throws Exception {
		return planAsignarRecursoLogic.getDataPlanAsignarRecurso();
	}

	@Override
	public List<PrecioPromProd> getPrecioPromProd() throws Exception {
		return precioPromProdLogic.getPrecioPromProd();
	}

	@Override
	public void savePrecioPromProd(PrecioPromProd entity) throws Exception {
		precioPromProdLogic.savePrecioPromProd(entity);
	}

	@Override
	public void deletePrecioPromProd(PrecioPromProd entity) throws Exception {
		precioPromProdLogic.deletePrecioPromProd(entity);
	}

	@Override
	public void updatePrecioPromProd(PrecioPromProd entity) throws Exception {
		precioPromProdLogic.updatePrecioPromProd(entity);
	}

	@Override
	public PrecioPromProd getPrecioPromProd(Long precioProdId) throws Exception {
		PrecioPromProd precioPromProd = null;

		try {
			precioPromProd = precioPromProdLogic.getPrecioPromProd(precioProdId);
		} catch (Exception e) {
			throw e;
		}

		return precioPromProd;
	}

	@Override
	public List<PrecioPromProd> findByCriteriaInPrecioPromProd(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return precioPromProdLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<PrecioPromProd> findPagePrecioPromProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return precioPromProdLogic.findPagePrecioPromProd(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberPrecioPromProd() throws Exception {
		return precioPromProdLogic.findTotalNumberPrecioPromProd();
	}

	@Override
	public List<PrecioPromProdDTO> getDataPrecioPromProd(Double cantidadCompra) throws Exception {
		return precioPromProdLogic.getDataPrecioPromProd(cantidadCompra);
	}

	@Override
	public List<Producto> getProducto() throws Exception {
		return productoLogic.getProducto();
	}

	@Override
	public void deleteProducto(Producto entity) throws Exception {
		productoLogic.deleteProducto(entity);
	}

	@Override
	public Producto getProducto(Long productoId) throws Exception {
		Producto producto = null;

		try {
			producto = productoLogic.getProducto(productoId);
		} catch (Exception e) {
			throw e;
		}

		return producto;
	}

	@Override
	public List<Producto> findByCriteriaInProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return productoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Producto> findPageProducto(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return productoLogic.findPageProducto(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberProducto() throws Exception {
		return productoLogic.findTotalNumberProducto();
	}

	@Override
	public List<ProductoDTO> getDataProducto() throws Exception {
		return productoLogic.getDataProducto();
	}

	/*
	 * public List<Recurso> getRecurso() throws Exception { return
	 * recursoLogic.getRecurso(); }
	 * 
	 * public void saveRecurso(Recurso entity) throws Exception {
	 * recursoLogic.saveRecurso(entity); }
	 * 
	 * public void deleteRecurso(Recurso entity) throws Exception {
	 * recursoLogic.deleteRecurso(entity); }
	 * 
	 * public void updateRecurso(Recurso entity) throws Exception {
	 * recursoLogic.updateRecurso(entity); }
	 * 
	 * public Recurso getRecurso(Long recursoId) throws Exception { Recurso recurso
	 * = null;
	 * 
	 * try { recurso = recursoLogic.getRecurso(recursoId); } catch (Exception e) {
	 * throw e; }
	 * 
	 * return recurso; }
	 * 
	 * public List<Recurso> findByCriteriaInRecurso(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception { return
	 * recursoLogic.findByCriteria(variables, variablesBetween,
	 * variablesBetweenDates); }
	 * 
	 * public List<Recurso> findPageRecurso(String sortColumnName, boolean
	 * sortAscending, int startRow, int maxResults) throws Exception { return
	 * recursoLogic.findPageRecurso(sortColumnName, sortAscending, startRow,
	 * maxResults); }
	 * 
	 * public Long findTotalNumberRecurso() throws Exception { return
	 * recursoLogic.findTotalNumberRecurso(); }
	 * 
	 * public List<RecursoDTO> getDataRecurso() throws Exception { return
	 * recursoLogic.getDataRecurso(); }
	 */
	@Override
	public List<Servicio> getServicio() throws Exception {
		return servicioLogic.getServicio();
	}

	@Override
	public void saveServicio(Servicio entity) throws Exception {
		servicioLogic.saveServicio(entity);
	}

	@Override
	public void deleteServicio(Servicio entity) throws Exception {
		servicioLogic.deleteServicio(entity);
	}

	@Override
	public void updateServicio(Servicio entity) throws Exception {
		servicioLogic.updateServicio(entity);
	}

	@Override
	public Servicio getServicio(Long servicioId) throws Exception {
		Servicio servicio = null;

		try {
			servicio = servicioLogic.getServicio(servicioId);
		} catch (Exception e) {
			throw e;
		}

		return servicio;
	}

	@Override
	public List<Servicio> findByCriteriaInServicio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return servicioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Servicio> findPageServicio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return servicioLogic.findPageServicio(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberServicio() throws Exception {
		return servicioLogic.findTotalNumberServicio();
	}

	@Override
	public List<ServicioDTO> getDataServicio() throws Exception {
		return servicioLogic.getDataServicio();
	}

	@Override
	public List<SistemaRiego> getSistemaRiego() throws Exception {
		return sistemaRiegoLogic.getSistemaRiego();
	}

	@Override
	public void saveSistemaRiego(SistemaRiego entity) throws Exception {
		sistemaRiegoLogic.saveSistemaRiego(entity);
	}

	@Override
	public void deleteSistemaRiego(SistemaRiego entity) throws Exception {
		sistemaRiegoLogic.deleteSistemaRiego(entity);
	}

	@Override
	public void updateSistemaRiego(SistemaRiego entity) throws Exception {
		sistemaRiegoLogic.updateSistemaRiego(entity);
	}

	@Override
	public SistemaRiego getSistemaRiego(Long sistemaRiegoId) throws Exception {
		SistemaRiego sistemaRiego = null;

		try {
			sistemaRiego = sistemaRiegoLogic.getSistemaRiego(sistemaRiegoId);
		} catch (Exception e) {
			throw e;
		}

		return sistemaRiego;
	}

	@Override
	public List<SistemaRiego> findByCriteriaInSistemaRiego(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return sistemaRiegoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<SistemaRiego> findPageSistemaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return sistemaRiegoLogic.findPageSistemaRiego(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberSistemaRiego() throws Exception {
		return sistemaRiegoLogic.findTotalNumberSistemaRiego();
	}

	@Override
	public List<SistemaRiegoDTO> getDataSistemaRiego() throws Exception {
		return sistemaRiegoLogic.getDataSistemaRiego();
	}

	@Override
	public List<TipoCliente> getTipoCliente() throws Exception {
		return tipoClienteLogic.getTipoCliente();
	}

	@Override
	public void saveTipoCliente(TipoCliente entity) throws Exception {
		tipoClienteLogic.saveTipoCliente(entity);
	}

	@Override
	public void deleteTipoCliente(TipoCliente entity) throws Exception {
		tipoClienteLogic.deleteTipoCliente(entity);
	}

	@Override
	public void updateTipoCliente(TipoCliente entity) throws Exception {
		tipoClienteLogic.updateTipoCliente(entity);
	}

	@Override
	public TipoCliente getTipoCliente(Long tipoClienteId) throws Exception {
		TipoCliente tipoCliente = null;

		try {
			tipoCliente = tipoClienteLogic.getTipoCliente(tipoClienteId);
		} catch (Exception e) {
			throw e;
		}

		return tipoCliente;
	}

	@Override
	public List<TipoCliente> findByCriteriaInTipoCliente(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoClienteLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoCliente> findPageTipoCliente(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoClienteLogic.findPageTipoCliente(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoCliente() throws Exception {
		return tipoClienteLogic.findTotalNumberTipoCliente();
	}

	@Override
	public List<TipoClienteDTO> getDataTipoCliente() throws Exception {
		return tipoClienteLogic.getDataTipoCliente();
	}

	@Override
	public List<TipoInfraestructura> getTipoInfraestructura() throws Exception {
		return tipoInfraestructuraLogic.getTipoInfraestructura();
	}

	@Override
	public void saveTipoInfraestructura(TipoInfraestructura entity) throws Exception {
		tipoInfraestructuraLogic.saveTipoInfraestructura(entity);
	}

	@Override
	public void deleteTipoInfraestructura(TipoInfraestructura entity) throws Exception {
		tipoInfraestructuraLogic.deleteTipoInfraestructura(entity);
	}

	@Override
	public void updateTipoInfraestructura(TipoInfraestructura entity) throws Exception {
		tipoInfraestructuraLogic.updateTipoInfraestructura(entity);
	}

	@Override
	public TipoInfraestructura getTipoInfraestructura(Long tipoInfraId) throws Exception {
		TipoInfraestructura tipoInfraestructura = null;

		try {
			tipoInfraestructura = tipoInfraestructuraLogic.getTipoInfraestructura(tipoInfraId);
		} catch (Exception e) {
			throw e;
		}

		return tipoInfraestructura;
	}

	@Override
	public List<TipoInfraestructura> findByCriteriaInTipoInfraestructura(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoInfraestructuraLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoInfraestructura> findPageTipoInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tipoInfraestructuraLogic.findPageTipoInfraestructura(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTipoInfraestructura() throws Exception {
		return tipoInfraestructuraLogic.findTotalNumberTipoInfraestructura();
	}

	@Override
	public List<TipoInfraestructuraDTO> getDataTipoInfraestructura() throws Exception {
		return tipoInfraestructuraLogic.getDataTipoInfraestructura();
	}

	@Override
	public List<TipoProducto> getTipoProducto() throws Exception {
		return tipoProductoLogic.getTipoProducto();
	}

	@Override
	public void saveTipoProducto(TipoProducto entity) throws Exception {
		tipoProductoLogic.saveTipoProducto(entity);
	}

	@Override
	public void deleteTipoProducto(TipoProducto entity) throws Exception {
		tipoProductoLogic.deleteTipoProducto(entity);
	}

	@Override
	public void updateTipoProducto(TipoProducto entity) throws Exception {
		tipoProductoLogic.updateTipoProducto(entity);
	}

	@Override
	public TipoProducto getTipoProducto(Long tipoProdId) throws Exception {
		TipoProducto tipoProducto = null;

		try {
			tipoProducto = tipoProductoLogic.getTipoProducto(tipoProdId);
		} catch (Exception e) {
			throw e;
		}

		return tipoProducto;
	}

	@Override
	public List<TipoProducto> findByCriteriaInTipoProducto(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoProductoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoProducto> findPageTipoProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoProductoLogic.findPageTipoProducto(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoProducto() throws Exception {
		return tipoProductoLogic.findTotalNumberTipoProducto();
	}

	@Override
	public List<TipoProductoDTO> getDataTipoProducto() throws Exception {
		return tipoProductoLogic.getDataTipoProducto();
	}

	@Override
	public List<TipoRecurso> getTipoRecurso() throws Exception {
		return tipoRecursoLogic.getTipoRecurso();
	}

	@Override
	public void saveTipoRecurso(TipoRecurso entity,

			List<TipoRecursosProfesionDTO> dataTRProfesion, List<TipoRecursosEquiposDTO> dataTREquipos,
			List<TipoRecursosInsumosDTO> dataTRInsumos, List<TipoRecursosOtrosDTO> dataTROtros) throws Exception {
		tipoRecursoLogic.saveTipoRecurso(entity, dataTRProfesion, dataTREquipos, dataTRInsumos, dataTROtros);
	}

	@Override
	public void deleteTipoRecurso(TipoRecurso entity) throws Exception {
		tipoRecursoLogic.deleteTipoRecurso(entity);
	}

	@Override
	public void updateTipoRecurso(TipoRecurso entity,

			List<TipoRecursosProfesionDTO> dataTRProfesion, List<TipoRecursosEquiposDTO> dataTREquipos,
			List<TipoRecursosInsumosDTO> dataTRInsumos, List<TipoRecursosOtrosDTO> dataTROtros) throws Exception {
		tipoRecursoLogic.updateTipoRecurso(entity, dataTRProfesion, dataTREquipos, dataTRInsumos, dataTROtros);
	}

	@Override
	public TipoRecurso getTipoRecurso(Long tpRecursoId) throws Exception {
		TipoRecurso tipoRecurso = null;

		try {
			tipoRecurso = tipoRecursoLogic.getTipoRecurso(tpRecursoId);
		} catch (Exception e) {
			throw e;
		}

		return tipoRecurso;
	}

	@Override
	public List<TipoRecurso> findByCriteriaInTipoRecurso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoRecursoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoRecurso> findPageTipoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoRecursoLogic.findPageTipoRecurso(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoRecurso() throws Exception {
		return tipoRecursoLogic.findTotalNumberTipoRecurso();
	}

	@Override
	public List<TipoRecursoDTO> getDataTipoRecurso() throws Exception {
		return tipoRecursoLogic.getDataTipoRecurso();
	}

	@Override
	public List<Transportadora> getTransportadora() throws Exception {
		return transportadoraLogic.getTransportadora();
	}

	@Override
	public void saveTransportadora(Transportadora entity) throws Exception {
		transportadoraLogic.saveTransportadora(entity);
	}

	@Override
	public void deleteTransportadora(Transportadora entity) throws Exception {
		transportadoraLogic.deleteTransportadora(entity);
	}

	@Override
	public void updateTransportadora(Transportadora entity) throws Exception {
		transportadoraLogic.updateTransportadora(entity);
	}

	@Override
	public Transportadora getTransportadora(Long transpId) throws Exception {
		Transportadora transportadora = null;

		try {
			transportadora = transportadoraLogic.getTransportadora(transpId);
		} catch (Exception e) {
			throw e;
		}

		return transportadora;
	}

	@Override
	public List<Transportadora> findByCriteriaInTransportadora(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return transportadoraLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Transportadora> findPageTransportadora(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return transportadoraLogic.findPageTransportadora(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTransportadora() throws Exception {
		return transportadoraLogic.findTotalNumberTransportadora();
	}

	@Override
	public List<TransportadoraDTO> getDataTransportadora() throws Exception {
		return transportadoraLogic.getDataTransportadora();
	}

	@Override
	public List<TurnoCampo> getTurnoCampo() throws Exception {
		return turnoCampoLogic.getTurnoCampo();
	}

	@Override
	public void saveTurnoCampo(TurnoCampo entity) throws Exception {
		turnoCampoLogic.saveTurnoCampo(entity);
	}

	@Override
	public void deleteTurnoCampo(TurnoCampo entity) throws Exception {
		turnoCampoLogic.deleteTurnoCampo(entity);
	}

	@Override
	public void updateTurnoCampo(TurnoCampo entity) throws Exception {
		turnoCampoLogic.updateTurnoCampo(entity);
	}

	@Override
	public TurnoCampo getTurnoCampo(Long turnoCampoId) throws Exception {
		TurnoCampo turnoCampo = null;

		try {
			turnoCampo = turnoCampoLogic.getTurnoCampo(turnoCampoId);
		} catch (Exception e) {
			throw e;
		}

		return turnoCampo;
	}

	@Override
	public List<TurnoCampo> findByCriteriaInTurnoCampo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return turnoCampoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TurnoCampo> findPageTurnoCampo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return turnoCampoLogic.findPageTurnoCampo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTurnoCampo() throws Exception {
		return turnoCampoLogic.findTotalNumberTurnoCampo();
	}

	@Override
	public List<TurnoCampoDTO> getDataTurnoCampo() throws Exception {
		return turnoCampoLogic.getDataTurnoCampo();
	}

	@Override
	public List<VehiculosTransp> getVehiculosTransp() throws Exception {
		return vehiculosTranspLogic.getVehiculosTransp();
	}

	@Override
	public void saveVehiculosTransp(VehiculosTransp entity) throws Exception {
		vehiculosTranspLogic.saveVehiculosTransp(entity);
	}

	@Override
	public void deleteVehiculosTransp(VehiculosTransp entity) throws Exception {
		vehiculosTranspLogic.deleteVehiculosTransp(entity);
	}

	@Override
	public void updateVehiculosTransp(VehiculosTransp entity) throws Exception {
		vehiculosTranspLogic.updateVehiculosTransp(entity);
	}

	@Override
	public VehiculosTransp getVehiculosTransp(Long vehiTranspId) throws Exception {
		VehiculosTransp vehiculosTransp = null;

		try {
			vehiculosTransp = vehiculosTranspLogic.getVehiculosTransp(vehiTranspId);
		} catch (Exception e) {
			throw e;
		}

		return vehiculosTransp;
	}

	@Override
	public List<VehiculosTransp> findByCriteriaInVehiculosTransp(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return vehiculosTranspLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<VehiculosTransp> findPageVehiculosTransp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return vehiculosTranspLogic.findPageVehiculosTransp(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberVehiculosTransp() throws Exception {
		return vehiculosTranspLogic.findTotalNumberVehiculosTransp();
	}

	@Override
	public List<VehiculosTranspDTO> getDataVehiculosTransp() throws Exception {
		return vehiculosTranspLogic.getDataVehiculosTransp();
	}

	@Override
	public List<AnaSanVeg> getAnaSanVeg() throws Exception {
		return anaSanVegLogic.getAnaSanVeg();
	}

	@Override
	public void saveAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception {
		anaSanVegLogic.saveAnaSanVeg(entity, selectedCultivos);
	}

	@Override
	public void deleteAnaSanVeg(AnaSanVeg entity) throws Exception {
		anaSanVegLogic.deleteAnaSanVeg(entity);
	}

	@Override
	public void updateAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception {
		anaSanVegLogic.updateAnaSanVeg(entity, selectedCultivos);
	}

	@Override
	public AnaSanVeg getAnaSanVeg(Long anaSanVegId) throws Exception {
		AnaSanVeg anaSanVeg = null;

		try {
			anaSanVeg = anaSanVegLogic.getAnaSanVeg(anaSanVegId);
		} catch (Exception e) {
			throw e;
		}

		return anaSanVeg;
	}

	@Override
	public List<AnaSanVeg> findByCriteriaInAnaSanVeg(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return anaSanVegLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<AnaSanVeg> findPageAnaSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return anaSanVegLogic.findPageAnaSanVeg(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberAnaSanVeg() throws Exception {
		return anaSanVegLogic.findTotalNumberAnaSanVeg();
	}

	@Override
	public List<AnaSanVegDTO> getDataAnaSanVeg() throws Exception {
		return anaSanVegLogic.getDataAnaSanVeg();
	}

	@Override
	public List<AnioFiscal> getAnioFiscal() throws Exception {
		return anioFiscalLogic.getAnioFiscal();
	}

	@Override
	public void saveAnioFiscal(AnioFiscal entity) throws Exception {
		anioFiscalLogic.saveAnioFiscal(entity);
	}

	@Override
	public void deleteAnioFiscal(AnioFiscal entity) throws Exception {
		anioFiscalLogic.deleteAnioFiscal(entity);
	}

	@Override
	public void updateAnioFiscal(AnioFiscal entity) throws Exception {
		anioFiscalLogic.updateAnioFiscal(entity);
	}

	@Override
	public AnioFiscal getAnioFiscal(Long anioFiscalId) throws Exception {
		AnioFiscal anioFiscal = null;

		try {
			anioFiscal = anioFiscalLogic.getAnioFiscal(anioFiscalId);
		} catch (Exception e) {
			throw e;
		}

		return anioFiscal;
	}

	@Override
	public List<AnioFiscal> findByCriteriaInAnioFiscal(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return anioFiscalLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<AnioFiscal> findPageAnioFiscal(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return anioFiscalLogic.findPageAnioFiscal(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberAnioFiscal() throws Exception {
		return anioFiscalLogic.findTotalNumberAnioFiscal();
	}

	@Override
	public List<AnioFiscalDTO> getDataAnioFiscal() throws Exception {
		return anioFiscalLogic.getDataAnioFiscal();
	}

	@Override
	public List<Calendario> getCalendario() throws Exception {
		return calendarioLogic.getCalendario();
	}

	@Override
	public void saveCalendario(Calendario entity) throws Exception {
		calendarioLogic.saveCalendario(entity);
	}

	@Override
	public void deleteCalendario(Calendario entity) throws Exception {
		calendarioLogic.deleteCalendario(entity);
	}

	@Override
	public void updateCalendario(Calendario entity) throws Exception {
		calendarioLogic.updateCalendario(entity);
	}

	@Override
	public Calendario getCalendario(Long calendarId) throws Exception {
		Calendario calendario = null;

		try {
			calendario = calendarioLogic.getCalendario(calendarId);
		} catch (Exception e) {
			throw e;
		}

		return calendario;
	}

	@Override
	public List<Calendario> findByCriteriaInCalendario(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return calendarioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Calendario> findPageCalendario(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return calendarioLogic.findPageCalendario(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCalendario() throws Exception {
		return calendarioLogic.findTotalNumberCalendario();
	}

	@Override
	public List<CalendarioDTO> getDataCalendario() throws Exception {
		return calendarioLogic.getDataCalendario();
	}

	@Override
	public List<CentCost> getCentCost() throws Exception {
		return centCostLogic.getCentCost();
	}

	@Override
	public void saveCentCost(CentCost entity) throws Exception {
		centCostLogic.saveCentCost(entity);
	}

	@Override
	public void deleteCentCost(CentCost entity) throws Exception {
		centCostLogic.deleteCentCost(entity);
	}

	@Override
	public void updateCentCost(CentCost entity) throws Exception {
		centCostLogic.updateCentCost(entity);
	}

	@Override
	public CentCost getCentCost(Long centCostId) throws Exception {
		CentCost centCost = null;

		try {
			centCost = centCostLogic.getCentCost(centCostId);
		} catch (Exception e) {
			throw e;
		}

		return centCost;
	}

	@Override
	public List<CentCost> findByCriteriaInCentCost(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return centCostLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CentCost> findPageCentCost(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return centCostLogic.findPageCentCost(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCentCost() throws Exception {
		return centCostLogic.findTotalNumberCentCost();
	}

	@Override
	public List<CentCostDTO> getDataCentCost() throws Exception {
		return centCostLogic.getDataCentCost();
	}

//	@Override
//	public List<ClaseTextSuelo> getClaseTextSuelo() throws Exception {
//		return claseTextSueloLogic.getClaseTextSuelo();
//	}
//
//	@Override
//	public void saveClaseTextSuelo(ClaseTextSuelo entity) throws Exception {
//		claseTextSueloLogic.saveClaseTextSuelo(entity);
//	}
//
//	@Override
//	public void deleteClaseTextSuelo(ClaseTextSuelo entity) throws Exception {
//		claseTextSueloLogic.deleteClaseTextSuelo(entity);
//	}
//
//	@Override
//	public void updateClaseTextSuelo(ClaseTextSuelo entity) throws Exception {
//		claseTextSueloLogic.updateClaseTextSuelo(entity);
//	}
//
//	@Override
//	public ClaseTextSuelo getClaseTextSuelo(Long claseTextSueloId) throws Exception {
//		ClaseTextSuelo claseTextSuelo = null;
//
//		try {
//			claseTextSuelo = claseTextSueloLogic.getClaseTextSuelo(claseTextSueloId);
//		} catch (Exception e) {
//			throw e;
//		}
//
//		return claseTextSuelo;
//	}

//	@Override
//	public List<ClaseTextSuelo> findByCriteriaInClaseTextSuelo(Object[] variables, Object[] variablesBetween,
//			Object[] variablesBetweenDates) throws Exception {
//		return claseTextSueloLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
//	}
//
//	@Override
//	public List<ClaseTextSuelo> findPageClaseTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
//			int maxResults) throws Exception {
//		return claseTextSueloLogic.findPageClaseTextSuelo(sortColumnName, sortAscending, startRow, maxResults);
//	}
//
//	@Override
//	public Long findTotalNumberClaseTextSuelo() throws Exception {
//		return claseTextSueloLogic.findTotalNumberClaseTextSuelo();
//	}
//
//	@Override
//	public List<ClaseTextSueloDTO> getDataClaseTextSuelo() throws Exception {
//		return claseTextSueloLogic.getDataClaseTextSuelo();
//	}

	@Override
	public List<Compania> getCompania() throws Exception {
		return companiaLogic.getCompania();
	}

	@Override
	public void saveCompania(Compania entity) throws Exception {
		companiaLogic.saveCompania(entity);
	}

	@Override
	public void deleteCompania(Compania entity) throws Exception {
		companiaLogic.deleteCompania(entity);
	}

	@Override
	public void updateCompania(Compania entity) throws Exception {
		companiaLogic.updateCompania(entity);
	}

	@Override
	public Compania getCompania(Long companiaId) throws Exception {
		Compania compania = null;

		try {
			compania = companiaLogic.getCompania(companiaId);
		} catch (Exception e) {
			throw e;
		}

		return compania;
	}

	@Override
	public List<Compania> findByCriteriaInCompania(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return companiaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Compania> findPageCompania(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return companiaLogic.findPageCompania(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCompania() throws Exception {
		return companiaLogic.findTotalNumberCompania();
	}

	@Override
	public List<CompaniaDTO> getDataCompania() throws Exception {
		return companiaLogic.getDataCompania();
	}

	@Override
	public List<ContBanco> getContBanco() throws Exception {
		return contBancoLogic.getContBanco();
	}

	@Override
	public void saveContBanco(ContBanco entity) throws Exception {
		contBancoLogic.saveContBanco(entity);
	}

	@Override
	public void deleteContBanco(ContBanco entity) throws Exception {
		contBancoLogic.deleteContBanco(entity);
	}

	@Override
	public void updateContBanco(ContBanco entity) throws Exception {
		contBancoLogic.updateContBanco(entity);
	}

	@Override
	public ContBanco getContBanco(Long contBancId) throws Exception {
		ContBanco contBanco = null;

		try {
			contBanco = contBancoLogic.getContBanco(contBancId);
		} catch (Exception e) {
			throw e;
		}

		return contBanco;
	}

	@Override
	public List<ContBanco> findByCriteriaInContBanco(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return contBancoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ContBanco> findPageContBanco(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return contBancoLogic.findPageContBanco(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberContBanco() throws Exception {
		return contBancoLogic.findTotalNumberContBanco();
	}

	@Override
	public List<ContBancoDTO> getDataContBanco() throws Exception {
		return contBancoLogic.getDataContBanco();
	}

	@Override
	public List<Cultivo> getCultivo() throws Exception {
		return cultivoLogic.getCultivo();
	}

	@Override
	public void saveCultivo(Cultivo entity) throws Exception {
		cultivoLogic.saveCultivo(entity);
	}

	@Override
	public void deleteCultivo(Cultivo entity) throws Exception {
		cultivoLogic.deleteCultivo(entity);
	}

	@Override
	public void updateCultivo(Cultivo entity) throws Exception {
		cultivoLogic.updateCultivo(entity);
	}

	@Override
	public Cultivo getCultivo(Long cultivoId) throws Exception {
		Cultivo cultivo = null;

		try {
			cultivo = cultivoLogic.getCultivo(cultivoId);
		} catch (Exception e) {
			throw e;
		}

		return cultivo;
	}

	@Override
	public List<Cultivo> findByCriteriaInCultivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return cultivoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Cultivo> findPageCultivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return cultivoLogic.findPageCultivo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCultivo() throws Exception {
		return cultivoLogic.findTotalNumberCultivo();
	}

	@Override
	public List<CultivoDTO> getDataCultivo() throws Exception {
		return cultivoLogic.getDataCultivo();
	}

	@Override
	public List<CultivoFitosanidad> getCultivoFitosanidad() throws Exception {
		return cultivoFitosanidadLogic.getCultivoFitosanidad();
	}

	@Override
	public void saveCultivoFitosanidad(CultivoFitosanidad entity) throws Exception {
		cultivoFitosanidadLogic.saveCultivoFitosanidad(entity);
	}

	@Override
	public void deleteCultivoFitosanidad(CultivoFitosanidad entity) throws Exception {
		cultivoFitosanidadLogic.deleteCultivoFitosanidad(entity);
	}

	@Override
	public void updateCultivoFitosanidad(CultivoFitosanidad entity) throws Exception {
		cultivoFitosanidadLogic.updateCultivoFitosanidad(entity);
	}

	@Override
	public CultivoFitosanidad getCultivoFitosanidad(CultivoFitosanidadId id) throws Exception {
		CultivoFitosanidad cultivoFitosanidad = null;

		try {
			cultivoFitosanidad = cultivoFitosanidadLogic.getCultivoFitosanidad(id);
		} catch (Exception e) {
			throw e;
		}

		return cultivoFitosanidad;
	}

	@Override
	public List<CultivoFitosanidad> findByCriteriaInCultivoFitosanidad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return cultivoFitosanidadLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CultivoFitosanidad> findPageCultivoFitosanidad(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return cultivoFitosanidadLogic.findPageCultivoFitosanidad(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCultivoFitosanidad() throws Exception {
		return cultivoFitosanidadLogic.findTotalNumberCultivoFitosanidad();
	}

	@Override
	public List<CultivoFitosanidadDTO> getDataCultivoFitosanidad() throws Exception {
		return cultivoFitosanidadLogic.getDataCultivoFitosanidad();
	}

	@Override
	public List<DatClimat> getDatClimat() throws Exception {
		return datClimatLogic.getDatClimat();
	}

	@Override
	public void saveDatClimat(DatClimat entity) throws Exception {
		datClimatLogic.saveDatClimat(entity);
	}

	@Override
	public void deleteDatClimat(DatClimat entity) throws Exception {
		datClimatLogic.deleteDatClimat(entity);
	}

	@Override
	public void updateDatClimat(DatClimat entity) throws Exception {
		datClimatLogic.updateDatClimat(entity);
	}

	@Override
	public DatClimat getDatClimat(Long datsClimatoId) throws Exception {
		DatClimat datClimat = null;

		try {
			datClimat = datClimatLogic.getDatClimat(datsClimatoId);
		} catch (Exception e) {
			throw e;
		}

		return datClimat;
	}

	@Override
	public List<DatClimat> findByCriteriaInDatClimat(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datClimatLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatClimat> findPageDatClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return datClimatLogic.findPageDatClimat(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatClimat() throws Exception {
		return datClimatLogic.findTotalNumberDatClimat();
	}

	@Override
	public List<DatClimatDTO> getDataDatClimat() throws Exception {
		return datClimatLogic.getDataDatClimat();
	}

	@Override
	public List<DatEvaporimetro> getDatEvaporimetro() throws Exception {
		return datEvaporimetroLogic.getDatEvaporimetro();
	}

	@Override
	public void saveDatEvaporimetro(DatEvaporimetro entity) throws Exception {
		datEvaporimetroLogic.saveDatEvaporimetro(entity);
	}

	@Override
	public void deleteDatEvaporimetro(DatEvaporimetro entity) throws Exception {
		datEvaporimetroLogic.deleteDatEvaporimetro(entity);
	}

	@Override
	public void updateDatEvaporimetro(DatEvaporimetro entity) throws Exception {
		datEvaporimetroLogic.updateDatEvaporimetro(entity);
	}

	@Override
	public DatEvaporimetro getDatEvaporimetro(Long datEvaporimetroId) throws Exception {
		DatEvaporimetro datEvaporimetro = null;

		try {
			datEvaporimetro = datEvaporimetroLogic.getDatEvaporimetro(datEvaporimetroId);
		} catch (Exception e) {
			throw e;
		}

		return datEvaporimetro;
	}

	@Override
	public List<DatEvaporimetro> findByCriteriaInDatEvaporimetro(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datEvaporimetroLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatEvaporimetro> findPageDatEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datEvaporimetroLogic.findPageDatEvaporimetro(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatEvaporimetro() throws Exception {
		return datEvaporimetroLogic.findTotalNumberDatEvaporimetro();
	}

	@Override
	public List<DatEvaporimetroDTO> getDataDatEvaporimetro() throws Exception {
		return datEvaporimetroLogic.getDataDatEvaporimetro();
	}

	@Override
	public List<DatPluvio> getDatPluvio() throws Exception {
		return datPluvioLogic.getDatPluvio();
	}

	@Override
	public void saveDatPluvio(DatPluvio entity) throws Exception {
		datPluvioLogic.saveDatPluvio(entity);
	}

	@Override
	public void deleteDatPluvio(DatPluvio entity) throws Exception {
		datPluvioLogic.deleteDatPluvio(entity);
	}

	@Override
	public void updateDatPluvio(DatPluvio entity) throws Exception {
		datPluvioLogic.updateDatPluvio(entity);
	}

	@Override
	public DatPluvio getDatPluvio(Long datPluvioId) throws Exception {
		DatPluvio datPluvio = null;

		try {
			datPluvio = datPluvioLogic.getDatPluvio(datPluvioId);
		} catch (Exception e) {
			throw e;
		}

		return datPluvio;
	}

	@Override
	public List<DatPluvio> findByCriteriaInDatPluvio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datPluvioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatPluvio> findPageDatPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return datPluvioLogic.findPageDatPluvio(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatPluvio() throws Exception {
		return datPluvioLogic.findTotalNumberDatPluvio();
	}

	@Override
	public List<DatPluvioDTO> getDataDatPluvio() throws Exception {
		return datPluvioLogic.getDataDatPluvio();
	}

	@Override
	public List<DatSanVeg> getDatSanVeg() throws Exception {
		return datSanVegLogic.getDatSanVeg();
	}

	public void saveDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception {
		datSanVegLogic.saveDatSanVeg(entity, dataValor);
	}

	public void deleteDatSanVeg(DatSanVeg entity) throws Exception {
		datSanVegLogic.deleteDatSanVeg(entity);
	}

	public void updateDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception {
		datSanVegLogic.updateDatSanVeg(entity, dataValor);
	}

	@Override
	public DatSanVeg getDatSanVeg(Long datSanVegId) throws Exception {
		DatSanVeg datSanVeg = null;

		try {
			datSanVeg = datSanVegLogic.getDatSanVeg(datSanVegId);
		} catch (Exception e) {
			throw e;
		}

		return datSanVeg;
	}

	@Override
	public List<DatSanVeg> findByCriteriaInDatSanVeg(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datSanVegLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatSanVeg> findPageDatSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return datSanVegLogic.findPageDatSanVeg(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatSanVeg() throws Exception {
		return datSanVegLogic.findTotalNumberDatSanVeg();
	}

	@Override
	public List<DatSanVegDTO> getDataDatSanVeg(Long idAnalisis) throws Exception {
		return datSanVegLogic.getDataDatSanVeg(idAnalisis);
	}

	@Override
	public List<DificultadAcceso> getDificultadAcceso() throws Exception {
		return dificultadAccesoLogic.getDificultadAcceso();
	}

	@Override
	public void saveDificultadAcceso(DificultadAcceso entity) throws Exception {
		dificultadAccesoLogic.saveDificultadAcceso(entity);
	}

	@Override
	public void deleteDificultadAcceso(DificultadAcceso entity) throws Exception {
		dificultadAccesoLogic.deleteDificultadAcceso(entity);
	}

	@Override
	public void updateDificultadAcceso(DificultadAcceso entity) throws Exception {
		dificultadAccesoLogic.updateDificultadAcceso(entity);
	}

	@Override
	public DificultadAcceso getDificultadAcceso(Long dificultadAccesoId) throws Exception {
		DificultadAcceso dificultadAcceso = null;

		try {
			dificultadAcceso = dificultadAccesoLogic.getDificultadAcceso(dificultadAccesoId);
		} catch (Exception e) {
			throw e;
		}

		return dificultadAcceso;
	}

	@Override
	public List<DificultadAcceso> findByCriteriaInDificultadAcceso(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return dificultadAccesoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DificultadAcceso> findPageDificultadAcceso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return dificultadAccesoLogic.findPageDificultadAcceso(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDificultadAcceso() throws Exception {
		return dificultadAccesoLogic.findTotalNumberDificultadAcceso();
	}

	@Override
	public List<DificultadAccesoDTO> getDataDificultadAcceso() throws Exception {
		return dificultadAccesoLogic.getDataDificultadAcceso();
	}

	@Override
	public List<DistSiembra> getDistSiembra() throws Exception {
		return distSiembraLogic.getDistSiembra();
	}

	@Override
	public void saveDistSiembra(DistSiembra entity) throws Exception {
		distSiembraLogic.saveDistSiembra(entity);
	}

	@Override
	public void deleteDistSiembra(DistSiembra entity) throws Exception {
		distSiembraLogic.deleteDistSiembra(entity);
	}

	@Override
	public void updateDistSiembra(DistSiembra entity) throws Exception {
		distSiembraLogic.updateDistSiembra(entity);
	}

	@Override
	public DistSiembra getDistSiembra(Long distSiembraId) throws Exception {
		DistSiembra distSiembra = null;

		try {
			distSiembra = distSiembraLogic.getDistSiembra(distSiembraId);
		} catch (Exception e) {
			throw e;
		}

		return distSiembra;
	}

	@Override
	public List<DistSiembra> findByCriteriaInDistSiembra(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return distSiembraLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DistSiembra> findPageDistSiembra(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return distSiembraLogic.findPageDistSiembra(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDistSiembra() throws Exception {
		return distSiembraLogic.findTotalNumberDistSiembra();
	}

	@Override
	public List<DistSiembraDTO> getDataDistSiembra() throws Exception {
		return distSiembraLogic.getDataDistSiembra();
	}

	@Override
	public List<EntBanc> getEntBanc() throws Exception {
		return entBancLogic.getEntBanc();
	}

	@Override
	public void saveEntBanc(EntBanc entity) throws Exception {
		entBancLogic.saveEntBanc(entity);
	}

	@Override
	public void deleteEntBanc(EntBanc entity) throws Exception {
		entBancLogic.deleteEntBanc(entity);
	}

	@Override
	public void updateEntBanc(EntBanc entity) throws Exception {
		entBancLogic.updateEntBanc(entity);
	}

	@Override
	public EntBanc getEntBanc(Long entBancId) throws Exception {
		EntBanc entBanc = null;

		try {
			entBanc = entBancLogic.getEntBanc(entBancId);
		} catch (Exception e) {
			throw e;
		}

		return entBanc;
	}

	@Override
	public List<EntBanc> findByCriteriaInEntBanc(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return entBancLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EntBanc> findPageEntBanc(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return entBancLogic.findPageEntBanc(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEntBanc() throws Exception {
		return entBancLogic.findTotalNumberEntBanc();
	}

	@Override
	public List<EntBancDTO> getDataEntBanc() throws Exception {
		return entBancLogic.getDataEntBanc();
	}

	@Override
	public List<EstClimat> getEstClimat() throws Exception {
		return estClimatLogic.getEstClimat();
	}

	@Override
	public void saveEstClimat(EstClimat entity) throws Exception {
		estClimatLogic.saveEstClimat(entity);
	}

	@Override
	public void deleteEstClimat(EstClimat entity) throws Exception {
		estClimatLogic.deleteEstClimat(entity);
	}

	@Override
	public void updateEstClimat(EstClimat entity) throws Exception {
		estClimatLogic.updateEstClimat(entity);
	}

	@Override
	public EstClimat getEstClimat(Long estClimatId) throws Exception {
		EstClimat estClimat = null;

		try {
			estClimat = estClimatLogic.getEstClimat(estClimatId);
		} catch (Exception e) {
			throw e;
		}

		return estClimat;
	}

	@Override
	public List<EstClimat> findByCriteriaInEstClimat(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estClimatLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EstClimat> findPageEstClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return estClimatLogic.findPageEstClimat(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEstClimat() throws Exception {
		return estClimatLogic.findTotalNumberEstClimat();
	}

	@Override
	public List<EstClimatDTO> getDataEstClimat() throws Exception {
		return estClimatLogic.getDataEstClimat();
	}

	@Override
	public List<EstEvaporimetro> getEstEvaporimetro() throws Exception {
		return estEvaporimetroLogic.getEstEvaporimetro();
	}

	@Override
	public void saveEstEvaporimetro(EstEvaporimetro entity) throws Exception {
		estEvaporimetroLogic.saveEstEvaporimetro(entity);
	}

	@Override
	public void deleteEstEvaporimetro(EstEvaporimetro entity) throws Exception {
		estEvaporimetroLogic.deleteEstEvaporimetro(entity);
	}

	@Override
	public void updateEstEvaporimetro(EstEvaporimetro entity) throws Exception {
		estEvaporimetroLogic.updateEstEvaporimetro(entity);
	}

	@Override
	public EstEvaporimetro getEstEvaporimetro(Long estEvaporimetroId) throws Exception {
		EstEvaporimetro estEvaporimetro = null;

		try {
			estEvaporimetro = estEvaporimetroLogic.getEstEvaporimetro(estEvaporimetroId);
		} catch (Exception e) {
			throw e;
		}

		return estEvaporimetro;
	}

	@Override
	public List<EstEvaporimetro> findByCriteriaInEstEvaporimetro(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estEvaporimetroLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EstEvaporimetro> findPageEstEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return estEvaporimetroLogic.findPageEstEvaporimetro(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEstEvaporimetro() throws Exception {
		return estEvaporimetroLogic.findTotalNumberEstEvaporimetro();
	}

	@Override
	public List<EstEvaporimetroDTO> getDataEstEvaporimetro() throws Exception {
		return estEvaporimetroLogic.getDataEstEvaporimetro();
	}

	@Override
	public List<EstPluvio> getEstPluvio() throws Exception {
		return estPluvioLogic.getEstPluvio();
	}

	@Override
	public void saveEstPluvio(EstPluvio entity) throws Exception {
		estPluvioLogic.saveEstPluvio(entity);
	}

	@Override
	public void deleteEstPluvio(EstPluvio entity) throws Exception {
		estPluvioLogic.deleteEstPluvio(entity);
	}

	@Override
	public void updateEstPluvio(EstPluvio entity) throws Exception {
		estPluvioLogic.updateEstPluvio(entity);
	}

	@Override
	public EstPluvio getEstPluvio(Long estPluvioId) throws Exception {
		EstPluvio estPluvio = null;

		try {
			estPluvio = estPluvioLogic.getEstPluvio(estPluvioId);
		} catch (Exception e) {
			throw e;
		}

		return estPluvio;
	}

	@Override
	public List<EstPluvio> findByCriteriaInEstPluvio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estPluvioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EstPluvio> findPageEstPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return estPluvioLogic.findPageEstPluvio(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEstPluvio() throws Exception {
		return estPluvioLogic.findTotalNumberEstPluvio();
	}

	@Override
	public List<EstPluvioDTO> getDataEstPluvio() throws Exception {
		return estPluvioLogic.getDataEstPluvio();
	}

	@Override
	public List<EstructSiemb> getEstructSiemb() throws Exception {
		return estructSiembLogic.getEstructSiemb();
	}

	@Override
	public void saveEstructSiemb(EstructSiemb entity) throws Exception {
		estructSiembLogic.saveEstructSiemb(entity);
	}

	@Override
	public void deleteEstructSiemb(EstructSiemb entity) throws Exception {
		estructSiembLogic.deleteEstructSiemb(entity);
	}

	@Override
	public void updateEstructSiemb(EstructSiemb entity) throws Exception {
		estructSiembLogic.updateEstructSiemb(entity);
	}

	@Override
	public EstructSiemb getEstructSiemb(Long estrSiembId) throws Exception {
		EstructSiemb estructSiemb = null;

		try {
			estructSiemb = estructSiembLogic.getEstructSiemb(estrSiembId);
		} catch (Exception e) {
			throw e;
		}

		return estructSiemb;
	}

	@Override
	public List<EstructSiemb> findByCriteriaInEstructSiemb(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estructSiembLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EstructSiemb> findPageEstructSiemb(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return estructSiembLogic.findPageEstructSiemb(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEstructSiemb() throws Exception {
		return estructSiembLogic.findTotalNumberEstructSiemb();
	}

	@Override
	public List<EstructSiembDTO> getDataEstructSiemb() throws Exception {
		return estructSiembLogic.getDataEstructSiemb();
	}

	@Override
	public List<Etapa> getEtapa() throws Exception {
		return etapaLogic.getEtapa();
	}

	@Override
	public void saveEtapa(Etapa entity) throws Exception {
		etapaLogic.saveEtapa(entity);
	}

	@Override
	public void deleteEtapa(Etapa entity) throws Exception {
		etapaLogic.deleteEtapa(entity);
	}

	@Override
	public void updateEtapa(Etapa entity) throws Exception {
		etapaLogic.updateEtapa(entity);
	}

	@Override
	public Etapa getEtapa(Long etapaId) throws Exception {
		Etapa etapa = null;

		try {
			etapa = etapaLogic.getEtapa(etapaId);
		} catch (Exception e) {
			throw e;
		}

		return etapa;
	}

	@Override
	public List<Etapa> findByCriteriaInEtapa(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return etapaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Etapa> findPageEtapa(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return etapaLogic.findPageEtapa(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEtapa() throws Exception {
		return etapaLogic.findTotalNumberEtapa();
	}

	@Override
	public List<EtapaDTO> getDataEtapa() throws Exception {
		return etapaLogic.getDataEtapa();
	}

	@Override
	public List<FaseFenologica> getFaseFenologica() throws Exception {
		return faseFenologicaLogic.getFaseFenologica();
	}

	@Override
	public void saveFaseFenologica(FaseFenologica entity) throws Exception {
		faseFenologicaLogic.saveFaseFenologica(entity);
	}

	@Override
	public void deleteFaseFenologica(FaseFenologica entity) throws Exception {
		faseFenologicaLogic.deleteFaseFenologica(entity);
	}

	@Override
	public void updateFaseFenologica(FaseFenologica entity) throws Exception {
		faseFenologicaLogic.updateFaseFenologica(entity);
	}

	@Override
	public FaseFenologica getFaseFenologica(Long faseFenoId) throws Exception {
		FaseFenologica faseFenologica = null;

		try {
			faseFenologica = faseFenologicaLogic.getFaseFenologica(faseFenoId);
		} catch (Exception e) {
			throw e;
		}

		return faseFenologica;
	}

	@Override
	public List<FaseFenologica> findByCriteriaInFaseFenologica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return faseFenologicaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<FaseFenologica> findPageFaseFenologica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return faseFenologicaLogic.findPageFaseFenologica(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFaseFenologica() throws Exception {
		return faseFenologicaLogic.findTotalNumberFaseFenologica();
	}

	@Override
	public List<FaseFenologicaDTO> getDataFaseFenologica() throws Exception {
		return faseFenologicaLogic.getDataFaseFenologica();
	}

	@Override
	public List<Fitosanidad> getFitosanidad() throws Exception {
		return fitosanidadLogic.getFitosanidad();
	}

	@Override
	public void saveFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception {
		fitosanidadLogic.saveFitosanidad(entity, selectedCultivos);
	}

	@Override
	public void deleteFitosanidad(Fitosanidad entity) throws Exception {
		fitosanidadLogic.deleteFitosanidad(entity);
	}

	@Override
	public void updateFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception {
		fitosanidadLogic.updateFitosanidad(entity, selectedCultivos);
	}

	@Override
	public Fitosanidad getFitosanidad(Long fitosanidadId) throws Exception {
		Fitosanidad fitosanidad = null;

		try {
			fitosanidad = fitosanidadLogic.getFitosanidad(fitosanidadId);
		} catch (Exception e) {
			throw e;
		}

		return fitosanidad;
	}

	@Override
	public List<Fitosanidad> findByCriteriaInFitosanidad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return fitosanidadLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Fitosanidad> findPageFitosanidad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return fitosanidadLogic.findPageFitosanidad(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFitosanidad() throws Exception {
		return fitosanidadLogic.findTotalNumberFitosanidad();
	}

	@Override
	public List<FitosanidadDTO> getDataFitosanidad() throws Exception {
		return fitosanidadLogic.getDataFitosanidad();
	}

	@Override
	public List<FliaTextSuelo> getFliaTextSuelo() throws Exception {
		return fliaTextSueloLogic.getFliaTextSuelo();
	}

	@Override
	public void saveFliaTextSuelo(FliaTextSuelo entity) throws Exception {
		fliaTextSueloLogic.saveFliaTextSuelo(entity);
	}

	@Override
	public void deleteFliaTextSuelo(FliaTextSuelo entity) throws Exception {
		fliaTextSueloLogic.deleteFliaTextSuelo(entity);
	}

	@Override
	public void updateFliaTextSuelo(FliaTextSuelo entity) throws Exception {
		fliaTextSueloLogic.updateFliaTextSuelo(entity);
	}

	@Override
	public FliaTextSuelo getFliaTextSuelo(Long fliaTextSueloId) throws Exception {
		FliaTextSuelo fliaTextSuelo = null;

		try {
			fliaTextSuelo = fliaTextSueloLogic.getFliaTextSuelo(fliaTextSueloId);
		} catch (Exception e) {
			throw e;
		}

		return fliaTextSuelo;
	}

	@Override
	public List<FliaTextSuelo> findByCriteriaInFliaTextSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return fliaTextSueloLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<FliaTextSuelo> findPageFliaTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return fliaTextSueloLogic.findPageFliaTextSuelo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFliaTextSuelo() throws Exception {
		return fliaTextSueloLogic.findTotalNumberFliaTextSuelo();
	}

	@Override
	public List<FliaTextSueloDTO> getDataFliaTextSuelo() throws Exception {
		return fliaTextSueloLogic.getDataFliaTextSuelo();
	}

	@Override
	public List<FrenteCos> getFrenteCos() throws Exception {
		return frenteCosLogic.getFrenteCos();
	}

	@Override
	public void saveFrenteCos(FrenteCos entity) throws Exception {
		frenteCosLogic.saveFrenteCos(entity);
	}

	@Override
	public void deleteFrenteCos(FrenteCos entity) throws Exception {
		frenteCosLogic.deleteFrenteCos(entity);
	}

	@Override
	public void updateFrenteCos(FrenteCos entity) throws Exception {
		frenteCosLogic.updateFrenteCos(entity);
	}

	@Override
	public FrenteCos getFrenteCos(Long frtCosId) throws Exception {
		FrenteCos frenteCos = null;

		try {
			frenteCos = frenteCosLogic.getFrenteCos(frtCosId);
		} catch (Exception e) {
			throw e;
		}

		return frenteCos;
	}

	@Override
	public List<FrenteCos> findByCriteriaInFrenteCos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return frenteCosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<FrenteCos> findPageFrenteCos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return frenteCosLogic.findPageFrenteCos(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberFrenteCos() throws Exception {
		return frenteCosLogic.findTotalNumberFrenteCos();
	}

	@Override
	public List<FrenteCosDTO> getDataFrenteCos() throws Exception {
		return frenteCosLogic.getDataFrenteCos();
	}

	@Override
	public List<GrpSuelo> getGrpSuelo() throws Exception {
		return grpSueloLogic.getGrpSuelo();
	}

	@Override
	public void saveGrpSuelo(GrpSuelo entity, LaraEdad entity2) throws Exception {
		grpSueloLogic.saveGrpSuelo(entity, entity2);
	}

	@Override
	public void deleteGrpSuelo(GrpSuelo entity) throws Exception {
		grpSueloLogic.deleteGrpSuelo(entity);
	}

	@Override
	public void updateGrpSuelo(GrpSuelo entity, LaraEdad entity2) throws Exception {
		grpSueloLogic.updateGrpSuelo(entity, entity2);
	}

	@Override
	public GrpSuelo getGrpSuelo(Long grupoSuelo) throws Exception {
		GrpSuelo grpSuelo = null;

		try {
			grpSuelo = grpSueloLogic.getGrpSuelo(grupoSuelo);
		} catch (Exception e) {
			throw e;
		}

		return grpSuelo;
	}

	@Override
	public List<GrpSuelo> findByCriteriaInGrpSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return grpSueloLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<GrpSuelo> findPageGrpSuelo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return grpSueloLogic.findPageGrpSuelo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberGrpSuelo() throws Exception {
		return grpSueloLogic.findTotalNumberGrpSuelo();
	}

	@Override
	public List<GrpSueloDTO> getDataGrpSuelo() throws Exception {
		return grpSueloLogic.getDataGrpSuelo();
	}

	@Override
	public List<GrpTenen> getGrpTenen() throws Exception {
		return grpTenenLogic.getGrpTenen();
	}

	@Override
	public void saveGrpTenen(GrpTenen entity) throws Exception {
		grpTenenLogic.saveGrpTenen(entity);
	}

	@Override
	public void deleteGrpTenen(GrpTenen entity) throws Exception {
		grpTenenLogic.deleteGrpTenen(entity);
	}

	@Override
	public void updateGrpTenen(GrpTenen entity) throws Exception {
		grpTenenLogic.updateGrpTenen(entity);
	}

	@Override
	public GrpTenen getGrpTenen(Long grpTenId) throws Exception {
		GrpTenen grpTenen = null;

		try {
			grpTenen = grpTenenLogic.getGrpTenen(grpTenId);
		} catch (Exception e) {
			throw e;
		}

		return grpTenen;
	}

	@Override
	public List<GrpTenen> findByCriteriaInGrpTenen(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return grpTenenLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<GrpTenen> findPageGrpTenen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return grpTenenLogic.findPageGrpTenen(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberGrpTenen() throws Exception {
		return grpTenenLogic.findTotalNumberGrpTenen();
	}

	@Override
	public List<GrpTenenDTO> getDataGrpTenen() throws Exception {
		return grpTenenLogic.getDataGrpTenen();
	}

	@Override
	public List<LaraEdad> getLaraEdad() throws Exception {
		return laraEdadLogic.getLaraEdad();
	}

	@Override
	public void saveLaraEdad(LaraEdad entity) throws Exception {
		laraEdadLogic.saveLaraEdad(entity);
	}

	@Override
	public void deleteLaraEdad(LaraEdad entity) throws Exception {
		laraEdadLogic.deleteLaraEdad(entity);
	}

	@Override
	public void updateLaraEdad(LaraEdad entity) throws Exception {
		laraEdadLogic.updateLaraEdad(entity);
	}

	@Override
	public LaraEdad getLaraEdad(Long laraEdadId) throws Exception {
		LaraEdad laraEdad = null;

		try {
			laraEdad = laraEdadLogic.getLaraEdad(laraEdadId);
		} catch (Exception e) {
			throw e;
		}

		return laraEdad;
	}

	@Override
	public List<LaraEdad> findByCriteriaInLaraEdad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return laraEdadLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<LaraEdad> findPageLaraEdad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return laraEdadLogic.findPageLaraEdad(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberLaraEdad() throws Exception {
		return laraEdadLogic.findTotalNumberLaraEdad();
	}

	@Override
	public List<LaraEdadDTO> getDataLaraEdad() throws Exception {
		return laraEdadLogic.getDataLaraEdad();
	}

	@Override
	public List<Larvas> getLarvas() throws Exception {
		return larvasLogic.getLarvas();
	}

	@Override
	public void saveLarvas(Larvas entity) throws Exception {
		larvasLogic.saveLarvas(entity);
	}

	@Override
	public void deleteLarvas(Larvas entity) throws Exception {
		larvasLogic.deleteLarvas(entity);
	}

	@Override
	public void updateLarvas(Larvas entity) throws Exception {
		larvasLogic.updateLarvas(entity);
	}

	@Override
	public Larvas getLarvas(Long larvasId) throws Exception {
		Larvas larvas = null;

		try {
			larvas = larvasLogic.getLarvas(larvasId);
		} catch (Exception e) {
			throw e;
		}

		return larvas;
	}

	@Override
	public List<Larvas> findByCriteriaInLarvas(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return larvasLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Larvas> findPageLarvas(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return larvasLogic.findPageLarvas(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberLarvas() throws Exception {
		return larvasLogic.findTotalNumberLarvas();
	}

	@Override
	public List<LarvasDTO> getDataLarvas() throws Exception {
		return larvasLogic.getDataLarvas();
	}

	@Override
	public List<ListValor> getListValor() throws Exception {
		return listValorLogic.getListValor();
	}

	@Override
	public void saveListValor(ListValor entity) throws Exception {
		listValorLogic.saveListValor(entity);
	}

	@Override
	public void deleteListValor(ListValor entity) throws Exception {
		listValorLogic.deleteListValor(entity);
	}

	@Override
	public void updateListValor(ListValor entity) throws Exception {
		listValorLogic.updateListValor(entity);
	}

	@Override
	public ListValor getListValor(Long listValorId) throws Exception {
		ListValor listValor = null;

		try {
			listValor = listValorLogic.getListValor(listValorId);
		} catch (Exception e) {
			throw e;
		}

		return listValor;
	}

	@Override
	public List<ListValor> findByCriteriaInListValor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return listValorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ListValor> findPageListValor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return listValorLogic.findPageListValor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberListValor() throws Exception {
		return listValorLogic.findTotalNumberListValor();
	}

	@Override
	public List<ListValorDTO> getDataListValor() throws Exception {
		return listValorLogic.getDataListValor();
	}

	@Override
	public List<Moneda> getMoneda() throws Exception {
		return monedaLogic.getMoneda();
	}

	@Override
	public void saveMoneda(Moneda entity) throws Exception {
		monedaLogic.saveMoneda(entity);
	}

	@Override
	public void deleteMoneda(Moneda entity) throws Exception {
		monedaLogic.deleteMoneda(entity);
	}

	@Override
	public void updateMoneda(Moneda entity) throws Exception {
		monedaLogic.updateMoneda(entity);
	}

	@Override
	public Moneda getMoneda(Long monedaId) throws Exception {
		Moneda moneda = null;

		try {
			moneda = monedaLogic.getMoneda(monedaId);
		} catch (Exception e) {
			throw e;
		}

		return moneda;
	}

	@Override
	public List<Moneda> findByCriteriaInMoneda(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return monedaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Moneda> findPageMoneda(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return monedaLogic.findPageMoneda(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberMoneda() throws Exception {
		return monedaLogic.findTotalNumberMoneda();
	}

	@Override
	public List<MonedaDTO> getDataMoneda() throws Exception {
		return monedaLogic.getDataMoneda();
	}

	@Override
	public List<MotElim> getMotElim() throws Exception {
		return motElimLogic.getMotElim();
	}

	@Override
	public void saveMotElim(MotElim entity) throws Exception {
		motElimLogic.saveMotElim(entity);
	}

	@Override
	public void deleteMotElim(MotElim entity) throws Exception {
		motElimLogic.deleteMotElim(entity);
	}

	@Override
	public void updateMotElim(MotElim entity) throws Exception {
		motElimLogic.updateMotElim(entity);
	}

	@Override
	public MotElim getMotElim(Long motElimId) throws Exception {
		MotElim motElim = null;

		try {
			motElim = motElimLogic.getMotElim(motElimId);
		} catch (Exception e) {
			throw e;
		}

		return motElim;
	}

	@Override
	public List<MotElim> findByCriteriaInMotElim(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return motElimLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<MotElim> findPageMotElim(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return motElimLogic.findPageMotElim(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberMotElim() throws Exception {
		return motElimLogic.findTotalNumberMotElim();
	}

	@Override
	public List<MotElimDTO> getDataMotElim() throws Exception {
		return motElimLogic.getDataMotElim();
	}

	@Override
	public List<MotEstim> getMotEstim() throws Exception {
		return motEstimLogic.getMotEstim();
	}

	@Override
	public void saveMotEstim(MotEstim entity) throws Exception {
		motEstimLogic.saveMotEstim(entity);
	}

	@Override
	public void deleteMotEstim(MotEstim entity) throws Exception {
		motEstimLogic.deleteMotEstim(entity);
	}

	@Override
	public void updateMotEstim(MotEstim entity) throws Exception {
		motEstimLogic.updateMotEstim(entity);
	}

	@Override
	public MotEstim getMotEstim(Long motEstimId) throws Exception {
		MotEstim motEstim = null;

		try {
			motEstim = motEstimLogic.getMotEstim(motEstimId);
		} catch (Exception e) {
			throw e;
		}

		return motEstim;
	}

	@Override
	public List<MotEstim> findByCriteriaInMotEstim(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return motEstimLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<MotEstim> findPageMotEstim(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return motEstimLogic.findPageMotEstim(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberMotEstim() throws Exception {
		return motEstimLogic.findTotalNumberMotEstim();
	}

	@Override
	public List<MotEstimDTO> getDataMotEstim() throws Exception {
		return motEstimLogic.getDataMotEstim();
	}

	@Override
	public List<N4Motivo> getN4Motivo() throws Exception {
		return n4MotivoLogic.getN4Motivo();
	}

	@Override
	public void saveN4Motivo(N4Motivo entity) throws Exception {
		n4MotivoLogic.saveN4Motivo(entity);
	}

	@Override
	public void deleteN4Motivo(N4Motivo entity) throws Exception {
		n4MotivoLogic.deleteN4Motivo(entity);
	}

	@Override
	public void updateN4Motivo(N4Motivo entity) throws Exception {
		n4MotivoLogic.updateN4Motivo(entity);
	}

	@Override
	public N4Motivo getN4Motivo(Long n4Mot) throws Exception {
		N4Motivo n4Motivo = null;

		try {
			n4Motivo = n4MotivoLogic.getN4Motivo(n4Mot);
		} catch (Exception e) {
			throw e;
		}

		return n4Motivo;
	}

	@Override
	public List<N4Motivo> findByCriteriaInN4Motivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return n4MotivoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<N4Motivo> findPageN4Motivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return n4MotivoLogic.findPageN4Motivo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberN4Motivo() throws Exception {
		return n4MotivoLogic.findTotalNumberN4Motivo();
	}

	@Override
	public List<N4MotivoDTO> getDataN4Motivo() throws Exception {
		return n4MotivoLogic.getDataN4Motivo();
	}

	@Override
	public List<Nivel1> getNivel1() throws Exception {
		return nivel1Logic.getNivel1();
	}

	@Override
	public void saveNivel1(Nivel1 entity) throws Exception {
		nivel1Logic.saveNivel1(entity);
	}

	@Override
	public void deleteNivel1(Nivel1 entity) throws Exception {
		nivel1Logic.deleteNivel1(entity);
	}

	@Override
	public void updateNivel1(Nivel1 entity) throws Exception {
		nivel1Logic.updateNivel1(entity);
	}

	@Override
	public Nivel1 getNivel1(Long nivel1Id) throws Exception {
		Nivel1 nivel1 = null;

		try {
			nivel1 = nivel1Logic.getNivel1(nivel1Id);
		} catch (Exception e) {
			throw e;
		}

		return nivel1;
	}

	@Override
	public List<Nivel1> findByCriteriaInNivel1(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel1Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Nivel1> findPageNivel1(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return nivel1Logic.findPageNivel1(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNivel1() throws Exception {
		return nivel1Logic.findTotalNumberNivel1();
	}

	@Override
	public List<Nivel1DTO> getDataNivel1() throws Exception {
		return nivel1Logic.getDataNivel1();
	}

	@Override
	public List<Nivel2> getNivel2() throws Exception {
		return nivel2Logic.getNivel2();
	}

	@Override
	public void saveNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception {
		nivel2Logic.saveNivel2(entity, dataNivel2PersEmpr);
	}

	@Override
	public void deleteNivel2(Nivel2 entity) throws Exception {
		nivel2Logic.deleteNivel2(entity);
	}

	@Override
	public void updateNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception {
		nivel2Logic.updateNivel2(entity, dataNivel2PersEmpr);
	}

	@Override
	public Nivel2 getNivel2(Long nivel2Id) throws Exception {
		Nivel2 nivel2 = null;

		try {
			nivel2 = nivel2Logic.getNivel2(nivel2Id);
		} catch (Exception e) {
			throw e;
		}

		return nivel2;
	}

	@Override
	public List<Nivel2> findByCriteriaInNivel2(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel2Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Nivel2> findPageNivel2(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return nivel2Logic.findPageNivel2(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNivel2() throws Exception {
		return nivel2Logic.findTotalNumberNivel2();
	}

	@Override
	public List<Nivel2DTO> getDataNivel2() throws Exception {
		return nivel2Logic.getDataNivel2();
	}

	@Override
	public List<Nivel3> getNivel3() throws Exception {
		return nivel3Logic.getNivel3();
	}

	@Override
	public void saveNivel3(Nivel3 entity) throws Exception {
		nivel3Logic.saveNivel3(entity);
	}

	@Override
	public void deleteNivel3(Nivel3 entity) throws Exception {
		nivel3Logic.deleteNivel3(entity);
	}

	@Override
	public void updateNivel3(Nivel3 entity) throws Exception {
		nivel3Logic.updateNivel3(entity);
	}

	@Override
	public Nivel3 getNivel3(Long nivel3Id) throws Exception {
		Nivel3 nivel3 = null;

		try {
			nivel3 = nivel3Logic.getNivel3(nivel3Id);
		} catch (Exception e) {
			throw e;
		}

		return nivel3;
	}

	@Override
	public List<Nivel3> findByCriteriaInNivel3(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel3Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Nivel3> findPageNivel3(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return nivel3Logic.findPageNivel3(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNivel3() throws Exception {
		return nivel3Logic.findTotalNumberNivel3();
	}

	@Override
	public List<Nivel3DTO> getDataNivel3() throws Exception {
		return nivel3Logic.getDataNivel3();
	}

	@Override
	public List<Nivel4> getNivel4() throws Exception {
		return nivel4Logic.getNivel4();
	}

	@Override
	public void saveNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception {
		nivel4Logic.saveNivel4(entity, restriccionDeQuema, restriccionDeMadurante, dataVariedad);
	}

	@Override
	public void deleteNivel4(Nivel4 entity) throws Exception {
		nivel4Logic.deleteNivel4(entity);
	}

	@Override
	public void updateNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception {
		nivel4Logic.updateNivel4(entity, restriccionDeQuema, restriccionDeMadurante, dataVariedad);
	}

	@Override
	public Nivel4 getNivel4(Long nivel4Id) throws Exception {
		Nivel4 nivel4 = null;

		try {
			nivel4 = nivel4Logic.getNivel4(nivel4Id);
		} catch (Exception e) {
			throw e;
		}

		return nivel4;
	}

	@Override
	public List<Nivel4> findByCriteriaInNivel4(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel4Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Nivel4> findPageNivel4(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return nivel4Logic.findPageNivel4(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNivel4() throws Exception {
		return nivel4Logic.findTotalNumberNivel4();
	}

	@Override
	public List<Nivel4DTO> getDataNivel4() throws Exception {
		return nivel4Logic.getDataNivel4();
	}

	/*
	 * @Override public List<NivelFertilidad> getNivelFertilidad() throws Exception
	 * { return nivelFertilidadLogic.getNivelFertilidad(); }
	 * 
	 * @Override public void saveNivelFertilidad(NivelFertilidad entity) throws
	 * Exception { nivelFertilidadLogic.saveNivelFertilidad(entity); }
	 * 
	 * @Override public void deleteNivelFertilidad(NivelFertilidad entity) throws
	 * Exception { nivelFertilidadLogic.deleteNivelFertilidad(entity); }
	 * 
	 * @Override public void updateNivelFertilidad(NivelFertilidad entity) throws
	 * Exception { nivelFertilidadLogic.updateNivelFertilidad(entity); }
	 * 
	 * @Override public NivelFertilidad getNivelFertilidad(Long nivelFertilidadId)
	 * throws Exception { NivelFertilidad nivelFertilidad = null;
	 * 
	 * try { nivelFertilidad =
	 * nivelFertilidadLogic.getNivelFertilidad(nivelFertilidadId); } catch
	 * (Exception e) { throw e; }
	 * 
	 * return nivelFertilidad; }
	 * 
	 * @Override public List<NivelFertilidad>
	 * findByCriteriaInNivelFertilidad(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception { return
	 * nivelFertilidadLogic.findByCriteria(variables, variablesBetween,
	 * variablesBetweenDates); }
	 * 
	 * @Override public List<NivelFertilidad> findPageNivelFertilidad(String
	 * sortColumnName, boolean sortAscending, int startRow, int maxResults) throws
	 * Exception { return
	 * nivelFertilidadLogic.findPageNivelFertilidad(sortColumnName, sortAscending,
	 * startRow, maxResults); }
	 * 
	 * @Override public Long findTotalNumberNivelFertilidad() throws Exception {
	 * return nivelFertilidadLogic.findTotalNumberNivelFertilidad(); }
	 * 
	 * @Override public List<NivelFertilidadDTO> getDataNivelFertilidad() throws
	 * Exception { return nivelFertilidadLogic.getDataNivelFertilidad(); }
	 */
	@Override
	public List<Ocupacion> getOcupacion() throws Exception {
		return ocupacionLogic.getOcupacion();
	}

	@Override
	public void saveOcupacion(Ocupacion entity) throws Exception {
		ocupacionLogic.saveOcupacion(entity);
	}

	@Override
	public void deleteOcupacion(Ocupacion entity) throws Exception {
		ocupacionLogic.deleteOcupacion(entity);
	}

	@Override
	public void updateOcupacion(Ocupacion entity) throws Exception {
		ocupacionLogic.updateOcupacion(entity);
	}

	@Override
	public Ocupacion getOcupacion(Long ocupacionId) throws Exception {
		Ocupacion ocupacion = null;

		try {
			ocupacion = ocupacionLogic.getOcupacion(ocupacionId);
		} catch (Exception e) {
			throw e;
		}

		return ocupacion;
	}

	@Override
	public List<Ocupacion> findByCriteriaInOcupacion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return ocupacionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Ocupacion> findPageOcupacion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return ocupacionLogic.findPageOcupacion(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberOcupacion() throws Exception {
		return ocupacionLogic.findTotalNumberOcupacion();
	}

	@Override
	public List<OcupacionDTO> getDataOcupacion() throws Exception {
		return ocupacionLogic.getDataOcupacion();
	}

	@Override
	public List<OrdenSuelo> getOrdenSuelo() throws Exception {
		return ordenSueloLogic.getOrdenSuelo();
	}

	@Override
	public void saveOrdenSuelo(OrdenSuelo entity) throws Exception {
		ordenSueloLogic.saveOrdenSuelo(entity);
	}

	@Override
	public void deleteOrdenSuelo(OrdenSuelo entity) throws Exception {
		ordenSueloLogic.deleteOrdenSuelo(entity);
	}

	@Override
	public void updateOrdenSuelo(OrdenSuelo entity) throws Exception {
		ordenSueloLogic.updateOrdenSuelo(entity);
	}

	@Override
	public OrdenSuelo getOrdenSuelo(Long ordenSueloId) throws Exception {
		OrdenSuelo ordenSuelo = null;

		try {
			ordenSuelo = ordenSueloLogic.getOrdenSuelo(ordenSueloId);
		} catch (Exception e) {
			throw e;
		}

		return ordenSuelo;
	}

	@Override
	public List<OrdenSuelo> findByCriteriaInOrdenSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return ordenSueloLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<OrdenSuelo> findPageOrdenSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return ordenSueloLogic.findPageOrdenSuelo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberOrdenSuelo() throws Exception {
		return ordenSueloLogic.findTotalNumberOrdenSuelo();
	}

	@Override
	public List<OrdenSueloDTO> getDataOrdenSuelo() throws Exception {
		return ordenSueloLogic.getDataOrdenSuelo();
	}

	@Override
	public List<Organizacion> getOrganizacion() throws Exception {
		return organizacionLogic.getOrganizacion();
	}

	@Override
	public void saveOrganizacion(Organizacion entity) throws Exception {
		organizacionLogic.saveOrganizacion(entity);
	}

	@Override
	public void deleteOrganizacion(Organizacion entity) throws Exception {
		organizacionLogic.deleteOrganizacion(entity);
	}

	@Override
	public void updateOrganizacion(Organizacion entity) throws Exception {
		organizacionLogic.updateOrganizacion(entity);
	}

	@Override
	public Organizacion getOrganizacion(Long organizId) throws Exception {
		Organizacion organizacion = null;

		try {
			organizacion = organizacionLogic.getOrganizacion(organizId);
		} catch (Exception e) {
			throw e;
		}

		return organizacion;
	}

	@Override
	public List<Organizacion> findByCriteriaInOrganizacion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return organizacionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Organizacion> findPageOrganizacion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return organizacionLogic.findPageOrganizacion(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberOrganizacion() throws Exception {
		return organizacionLogic.findTotalNumberOrganizacion();
	}

	@Override
	public List<OrganizacionDTO> getDataOrganizacion() throws Exception {
		return organizacionLogic.getDataOrganizacion();
	}

	@Override
	public List<PersEmpr> getPersEmpr() throws Exception {
		return persEmprLogic.getPersEmpr();
	}

	@Override
	public void deletePersEmpr(PersEmpr entity) throws Exception {
		persEmprLogic.deletePersEmpr(entity);
	}

	@Override
	public PersEmpr getPersEmpr(Long persEmprId) throws Exception {
		PersEmpr persEmpr = null;

		try {
			persEmpr = persEmprLogic.getPersEmpr(persEmprId);
		} catch (Exception e) {
			throw e;
		}

		return persEmpr;
	}

	@Override
	public List<PersEmpr> findByCriteriaInPersEmpr(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return persEmprLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<PersEmpr> findPagePersEmpr(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return persEmprLogic.findPagePersEmpr(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberPersEmpr() throws Exception {
		return persEmprLogic.findTotalNumberPersEmpr();
	}

	@Override
	public List<PersEmprDTO> getDataPersEmpr() throws Exception {
		return persEmprLogic.getDataPersEmpr();
	}

	@Override
	public List<Profesion> getProfesion() throws Exception {
		return profesionLogic.getProfesion();
	}

	@Override
	public void deleteProfesion(Profesion entity) throws Exception {
		profesionLogic.deleteProfesion(entity);
	}

	@Override
	public Profesion getProfesion(Long profId) throws Exception {
		Profesion profesion = null;

		try {
			profesion = profesionLogic.getProfesion(profId);
		} catch (Exception e) {
			throw e;
		}

		return profesion;
	}

	@Override
	public List<Profesion> findByCriteriaInProfesion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return profesionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Profesion> findPageProfesion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return profesionLogic.findPageProfesion(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberProfesion() throws Exception {
		return profesionLogic.findTotalNumberProfesion();
	}

	@Override
	public List<ProfesionDTO> getDataProfesion() throws Exception {
		return profesionLogic.getDataProfesion();
	}

	@Override
	public List<RangoValor> getRangoValor() throws Exception {
		return rangoValorLogic.getRangoValor();
	}

	@Override
	public void saveRangoValor(RangoValor entity) throws Exception {
		rangoValorLogic.saveRangoValor(entity);
	}

	@Override
	public void deleteRangoValor(RangoValor entity) throws Exception {
		rangoValorLogic.deleteRangoValor(entity);
	}

	@Override
	public void updateRangoValor(RangoValor entity) throws Exception {
		rangoValorLogic.updateRangoValor(entity);
	}

	@Override
	public RangoValor getRangoValor(Long rangoValorId) throws Exception {
		RangoValor rangoValor = null;

		try {
			rangoValor = rangoValorLogic.getRangoValor(rangoValorId);
		} catch (Exception e) {
			throw e;
		}

		return rangoValor;
	}

	@Override
	public List<RangoValor> findByCriteriaInRangoValor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return rangoValorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<RangoValor> findPageRangoValor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return rangoValorLogic.findPageRangoValor(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberRangoValor() throws Exception {
		return rangoValorLogic.findTotalNumberRangoValor();
	}

	@Override
	public List<RangoValorDTO> getDataRangoValor() throws Exception {
		return rangoValorLogic.getDataRangoValor();
	}

	/*
	 * @Override public List<RestriccionQuemaNivel4> getRestriccionQuemaNivel4()
	 * throws Exception { return
	 * restriccionQuemaNivel4Logic.getRestriccionQuemaNivel4(); }
	 * 
	 * @Override public void saveRestriccionQuemaNivel4(RestriccionQuemaNivel4
	 * entity) throws Exception {
	 * restriccionQuemaNivel4Logic.saveRestriccionQuemaNivel4(entity); }
	 * 
	 * @Override public void deleteRestriccionQuemaNivel4(RestriccionQuemaNivel4
	 * entity) throws Exception {
	 * restriccionQuemaNivel4Logic.deleteRestriccionQuemaNivel4(entity); }
	 * 
	 * @Override public void updateRestriccionQuemaNivel4(RestriccionQuemaNivel4
	 * entity) throws Exception {
	 * restriccionQuemaNivel4Logic.updateRestriccionQuemaNivel4(entity); }
	 * 
	 * @Override public RestriccionQuemaNivel4
	 * getRestriccionQuemaNivel4(RestriccionQuemaNivel4Id id) throws Exception {
	 * RestriccionQuemaNivel4 restriccionQuemaNivel4 = null;
	 * 
	 * try { restriccionQuemaNivel4 =
	 * restriccionQuemaNivel4Logic.getRestriccionQuemaNivel4(id); } catch (Exception
	 * e) { throw e; }
	 * 
	 * return restriccionQuemaNivel4; }
	 * 
	 * @Override public List<RestriccionQuemaNivel4>
	 * findByCriteriaInRestriccionQuemaNivel4(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception { return
	 * restriccionQuemaNivel4Logic.findByCriteria(variables, variablesBetween,
	 * variablesBetweenDates); }
	 * 
	 * @Override public List<RestriccionQuemaNivel4>
	 * findPageRestriccionQuemaNivel4(String sortColumnName, boolean sortAscending,
	 * int startRow, int maxResults) throws Exception { return
	 * restriccionQuemaNivel4Logic.findPageRestriccionQuemaNivel4(sortColumnName,
	 * sortAscending, startRow, maxResults); }
	 * 
	 * @Override public Long findTotalNumberRestriccionQuemaNivel4() throws
	 * Exception { return
	 * restriccionQuemaNivel4Logic.findTotalNumberRestriccionQuemaNivel4(); }
	 * 
	 * @Override public List<RestriccionQuemaNivel4DTO>
	 * getDataRestriccionQuemaNivel4() throws Exception { return
	 * restriccionQuemaNivel4Logic.getDataRestriccionQuemaNivel4(); }
	 * 
	 * @Override public List<RestriMaduranteNivel4> getRestriMaduranteNivel4()
	 * throws Exception { return
	 * restriMaduranteNivel4Logic.getRestriMaduranteNivel4(); }
	 * 
	 * @Override public void saveRestriMaduranteNivel4(RestriMaduranteNivel4 entity)
	 * throws Exception {
	 * restriMaduranteNivel4Logic.saveRestriMaduranteNivel4(entity); }
	 * 
	 * @Override public void deleteRestriMaduranteNivel4(RestriMaduranteNivel4
	 * entity) throws Exception {
	 * restriMaduranteNivel4Logic.deleteRestriMaduranteNivel4(entity); }
	 * 
	 * @Override public void updateRestriMaduranteNivel4(RestriMaduranteNivel4
	 * entity) throws Exception {
	 * restriMaduranteNivel4Logic.updateRestriMaduranteNivel4(entity); }
	 * 
	 * @Override public RestriMaduranteNivel4
	 * getRestriMaduranteNivel4(RestriMaduranteNivel4Id id) throws Exception {
	 * RestriMaduranteNivel4 restriMaduranteNivel4 = null;
	 * 
	 * try { restriMaduranteNivel4 =
	 * restriMaduranteNivel4Logic.getRestriMaduranteNivel4(id); } catch (Exception
	 * e) { throw e; }
	 * 
	 * return restriMaduranteNivel4; }
	 * 
	 * @Override public List<RestriMaduranteNivel4>
	 * findByCriteriaInRestriMaduranteNivel4(Object[] variables, Object[]
	 * variablesBetween, Object[] variablesBetweenDates) throws Exception { return
	 * restriMaduranteNivel4Logic.findByCriteria(variables, variablesBetween,
	 * variablesBetweenDates); }
	 * 
	 * @Override public List<RestriMaduranteNivel4>
	 * findPageRestriMaduranteNivel4(String sortColumnName, boolean sortAscending,
	 * int startRow, int maxResults) throws Exception { return
	 * restriMaduranteNivel4Logic.findPageRestriMaduranteNivel4(sortColumnName,
	 * sortAscending, startRow, maxResults); }
	 * 
	 * @Override public Long findTotalNumberRestriMaduranteNivel4() throws Exception
	 * { return restriMaduranteNivel4Logic.findTotalNumberRestriMaduranteNivel4(); }
	 * 
	 * @Override public List<RestriMaduranteNivel4DTO>
	 * getDataRestriMaduranteNivel4() throws Exception { return
	 * restriMaduranteNivel4Logic.getDataRestriMaduranteNivel4(); }
	 * 
	 * @Override public List<RestrMadurante> getRestrMadurante() throws Exception {
	 * return restrMaduranteLogic.getRestrMadurante(); }
	 * 
	 * @Override public void saveRestrMadurante(RestrMadurante entity) throws
	 * Exception { restrMaduranteLogic.saveRestrMadurante(entity); }
	 * 
	 * @Override public void deleteRestrMadurante(RestrMadurante entity) throws
	 * Exception { restrMaduranteLogic.deleteRestrMadurante(entity); }
	 * 
	 * @Override public void updateRestrMadurante(RestrMadurante entity) throws
	 * Exception { restrMaduranteLogic.updateRestrMadurante(entity); }
	 * 
	 * @Override public RestrMadurante getRestrMadurante(Long restMaduId) throws
	 * Exception { RestrMadurante restrMadurante = null;
	 * 
	 * try { restrMadurante = restrMaduranteLogic.getRestrMadurante(restMaduId); }
	 * catch (Exception e) { throw e; }
	 * 
	 * return restrMadurante; }
	 * 
	 * @Override public List<RestrMadurante> findByCriteriaInRestrMadurante(Object[]
	 * variables, Object[] variablesBetween, Object[] variablesBetweenDates) throws
	 * Exception { return restrMaduranteLogic.findByCriteria(variables,
	 * variablesBetween, variablesBetweenDates); }
	 * 
	 * @Override public List<RestrMadurante> findPageRestrMadurante(String
	 * sortColumnName, boolean sortAscending, int startRow, int maxResults) throws
	 * Exception { return restrMaduranteLogic.findPageRestrMadurante(sortColumnName,
	 * sortAscending, startRow, maxResults); }
	 * 
	 * @Override public Long findTotalNumberRestrMadurante() throws Exception {
	 * return restrMaduranteLogic.findTotalNumberRestrMadurante(); }
	 * 
	 * @Override public List<RestrMaduranteDTO> getDataRestrMadurante() throws
	 * Exception { return restrMaduranteLogic.getDataRestrMadurante(); }
	 * 
	 * @Override public List<RestrQuema> getRestrQuema() throws Exception { return
	 * restrQuemaLogic.getRestrQuema(); }
	 * 
	 * @Override public void saveRestrQuema(RestrQuema entity) throws Exception {
	 * restrQuemaLogic.saveRestrQuema(entity); }
	 * 
	 * @Override public void deleteRestrQuema(RestrQuema entity) throws Exception {
	 * restrQuemaLogic.deleteRestrQuema(entity); }
	 * 
	 * @Override public void updateRestrQuema(RestrQuema entity) throws Exception {
	 * restrQuemaLogic.updateRestrQuema(entity); }
	 * 
	 * @Override public RestrQuema getRestrQuema(Long restQuema) throws Exception {
	 * RestrQuema restrQuema = null;
	 * 
	 * try { restrQuema = restrQuemaLogic.getRestrQuema(restQuema); } catch
	 * (Exception e) { throw e; }
	 * 
	 * return restrQuema; }
	 * 
	 * @Override public List<RestrQuema> findByCriteriaInRestrQuema(Object[]
	 * variables, Object[] variablesBetween, Object[] variablesBetweenDates) throws
	 * Exception { return restrQuemaLogic.findByCriteria(variables,
	 * variablesBetween, variablesBetweenDates); }
	 * 
	 * @Override public List<RestrQuema> findPageRestrQuema(String sortColumnName,
	 * boolean sortAscending, int startRow, int maxResults) throws Exception {
	 * return restrQuemaLogic.findPageRestrQuema(sortColumnName, sortAscending,
	 * startRow, maxResults); }
	 * 
	 * @Override public Long findTotalNumberRestrQuema() throws Exception { return
	 * restrQuemaLogic.findTotalNumberRestrQuema(); }
	 * 
	 * @Override public List<RestrQuemaDTO> getDataRestrQuema() throws Exception {
	 * return restrQuemaLogic.getDataRestrQuema(); }
	 */
	@Override
	public List<SerieSuelo> getSerieSuelo() throws Exception {
		return serieSueloLogic.getSerieSuelo();
	}

	@Override
	public void saveSerieSuelo(SerieSuelo entity) throws Exception {
		serieSueloLogic.saveSerieSuelo(entity);
	}

	@Override
	public void deleteSerieSuelo(SerieSuelo entity) throws Exception {
		serieSueloLogic.deleteSerieSuelo(entity);
	}

	@Override
	public void updateSerieSuelo(SerieSuelo entity) throws Exception {
		serieSueloLogic.updateSerieSuelo(entity);
	}

	@Override
	public SerieSuelo getSerieSuelo(Long serieSueloId) throws Exception {
		SerieSuelo serieSuelo = null;

		try {
			serieSuelo = serieSueloLogic.getSerieSuelo(serieSueloId);
		} catch (Exception e) {
			throw e;
		}

		return serieSuelo;
	}

	@Override
	public List<SerieSuelo> findByCriteriaInSerieSuelo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return serieSueloLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<SerieSuelo> findPageSerieSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return serieSueloLogic.findPageSerieSuelo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberSerieSuelo() throws Exception {
		return serieSueloLogic.findTotalNumberSerieSuelo();
	}

	@Override
	public List<SerieSueloDTO> getDataSerieSuelo() throws Exception {
		return serieSueloLogic.getDataSerieSuelo();
	}

	@Override
	public List<TarifaContratista> getTarifaContratista() throws Exception {
		return tarifaContratistaLogic.getTarifaContratista();
	}

	@Override
	public void saveTarifaContratista(TarifaContratista entity) throws Exception {
		tarifaContratistaLogic.saveTarifaContratista(entity);
	}

	@Override
	public void deleteTarifaContratista(TarifaContratista entity) throws Exception {
		tarifaContratistaLogic.deleteTarifaContratista(entity);
	}

	@Override
	public void updateTarifaContratista(TarifaContratista entity) throws Exception {
		tarifaContratistaLogic.updateTarifaContratista(entity);
	}

	@Override
	public TarifaContratista getTarifaContratista(Long tarifaCtrId) throws Exception {
		TarifaContratista tarifaContratista = null;

		try {
			tarifaContratista = tarifaContratistaLogic.getTarifaContratista(tarifaCtrId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaContratista;
	}

	@Override
	public List<TarifaContratista> findByCriteriaInTarifaContratista(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tarifaContratistaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaContratista> findPageTarifaContratista(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tarifaContratistaLogic.findPageTarifaContratista(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTarifaContratista() throws Exception {
		return tarifaContratistaLogic.findTotalNumberTarifaContratista();
	}

	@Override
	public List<TarifaContratistaDTO> getDataTarifaContratista() throws Exception {
		return tarifaContratistaLogic.getDataTarifaContratista();
	}

	@Override
	public List<TarifaEquipProp> getTarifaEquipProp() throws Exception {
		return tarifaEquipPropLogic.getTarifaEquipProp();
	}

	@Override
	public void saveTarifaEquipProp(TarifaEquipProp entity) throws Exception {
		tarifaEquipPropLogic.saveTarifaEquipProp(entity);
	}

	@Override
	public void deleteTarifaEquipProp(TarifaEquipProp entity) throws Exception {
		tarifaEquipPropLogic.deleteTarifaEquipProp(entity);
	}

	@Override
	public void updateTarifaEquipProp(TarifaEquipProp entity) throws Exception {
		tarifaEquipPropLogic.updateTarifaEquipProp(entity);
	}

	@Override
	public TarifaEquipProp getTarifaEquipProp(Long tarifaEquipPropId) throws Exception {
		TarifaEquipProp tarifaEquipProp = null;

		try {
			tarifaEquipProp = tarifaEquipPropLogic.getTarifaEquipProp(tarifaEquipPropId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaEquipProp;
	}

	@Override
	public List<TarifaEquipProp> findByCriteriaInTarifaEquipProp(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tarifaEquipPropLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaEquipProp> findPageTarifaEquipProp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tarifaEquipPropLogic.findPageTarifaEquipProp(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTarifaEquipProp() throws Exception {
		return tarifaEquipPropLogic.findTotalNumberTarifaEquipProp();
	}

	@Override
	public List<TarifaEquipPropDTO> getDataTarifaEquipProp() throws Exception {
		return tarifaEquipPropLogic.getDataTarifaEquipProp();
	}

	@Override
	public List<TarifaProfesion> getTarifaProfesion() throws Exception {
		return tarifaProfesionLogic.getTarifaProfesion();
	}

	@Override
	public void saveTarifaProfesion(TarifaProfesion entity) throws Exception {
		tarifaProfesionLogic.saveTarifaProfesion(entity);
	}

	@Override
	public void deleteTarifaProfesion(TarifaProfesion entity) throws Exception {
		tarifaProfesionLogic.deleteTarifaProfesion(entity);
	}

	@Override
	public void updateTarifaProfesion(TarifaProfesion entity) throws Exception {
		tarifaProfesionLogic.updateTarifaProfesion(entity);
	}

	@Override
	public TarifaProfesion getTarifaProfesion(Long tarifaProfId) throws Exception {
		TarifaProfesion tarifaProfesion = null;

		try {
			tarifaProfesion = tarifaProfesionLogic.getTarifaProfesion(tarifaProfId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaProfesion;
	}

	@Override
	public List<TarifaProfesion> findByCriteriaInTarifaProfesion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tarifaProfesionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaProfesion> findPageTarifaProfesion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tarifaProfesionLogic.findPageTarifaProfesion(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTarifaProfesion() throws Exception {
		return tarifaProfesionLogic.findTotalNumberTarifaProfesion();
	}

	@Override
	public List<TarifaProfesionDTO> getDataTarifaProfesion() throws Exception {
		return tarifaProfesionLogic.getDataTarifaProfesion();
	}

	@Override
	public List<Tenencia> getTenencia() throws Exception {
		return tenenciaLogic.getTenencia();
	}

	@Override
	public void saveTenencia(Tenencia entity) throws Exception {
		tenenciaLogic.saveTenencia(entity);
	}

	@Override
	public void deleteTenencia(Tenencia entity) throws Exception {
		tenenciaLogic.deleteTenencia(entity);
	}

	@Override
	public void updateTenencia(Tenencia entity) throws Exception {
		tenenciaLogic.updateTenencia(entity);
	}

	@Override
	public Tenencia getTenencia(Long tenenId) throws Exception {
		Tenencia tenencia = null;

		try {
			tenencia = tenenciaLogic.getTenencia(tenenId);
		} catch (Exception e) {
			throw e;
		}

		return tenencia;
	}

	@Override
	public List<Tenencia> findByCriteriaInTenencia(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tenenciaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Tenencia> findPageTenencia(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tenenciaLogic.findPageTenencia(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTenencia() throws Exception {
		return tenenciaLogic.findTotalNumberTenencia();
	}

	@Override
	public List<TenenciaDTO> getDataTenencia() throws Exception {
		return tenenciaLogic.getDataTenencia();
	}

	@Override
	public List<TipCultivo> getTipCultivo() throws Exception {
		return tipCultivoLogic.getTipCultivo();
	}

	@Override
	public void saveTipCultivo(TipCultivo entity) throws Exception {
		tipCultivoLogic.saveTipCultivo(entity);
	}

	@Override
	public void deleteTipCultivo(TipCultivo entity) throws Exception {
		tipCultivoLogic.deleteTipCultivo(entity);
	}

	@Override
	public void updateTipCultivo(TipCultivo entity) throws Exception {
		tipCultivoLogic.updateTipCultivo(entity);
	}

	@Override
	public TipCultivo getTipCultivo(Long tipoCultivoId) throws Exception {
		TipCultivo tipCultivo = null;

		try {
			tipCultivo = tipCultivoLogic.getTipCultivo(tipoCultivoId);
		} catch (Exception e) {
			throw e;
		}

		return tipCultivo;
	}

	@Override
	public List<TipCultivo> findByCriteriaInTipCultivo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipCultivoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipCultivo> findPageTipCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipCultivoLogic.findPageTipCultivo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipCultivo() throws Exception {
		return tipCultivoLogic.findTotalNumberTipCultivo();
	}

	@Override
	public List<TipCultivoDTO> getDataTipCultivo() throws Exception {
		return tipCultivoLogic.getDataTipCultivo();
	}

	@Override
	public List<TipoDia> getTipoDia() throws Exception {
		return tipoDiaLogic.getTipoDia();
	}

	@Override
	public void saveTipoDia(TipoDia entity) throws Exception {
		tipoDiaLogic.saveTipoDia(entity);
	}

	@Override
	public void deleteTipoDia(TipoDia entity) throws Exception {
		tipoDiaLogic.deleteTipoDia(entity);
	}

	@Override
	public void updateTipoDia(TipoDia entity) throws Exception {
		tipoDiaLogic.updateTipoDia(entity);
	}

	@Override
	public TipoDia getTipoDia(Long tipDiaId) throws Exception {
		TipoDia tipoDia = null;

		try {
			tipoDia = tipoDiaLogic.getTipoDia(tipDiaId);
		} catch (Exception e) {
			throw e;
		}

		return tipoDia;
	}

	@Override
	public List<TipoDia> findByCriteriaInTipoDia(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoDiaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoDia> findPageTipoDia(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoDiaLogic.findPageTipoDia(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoDia() throws Exception {
		return tipoDiaLogic.findTotalNumberTipoDia();
	}

	@Override
	public List<TipoDiaDTO> getDataTipoDia() throws Exception {
		return tipoDiaLogic.getDataTipoDia();
	}

	@Override
	public List<TipoDrenaje> getTipoDrenaje() throws Exception {
		return tipoDrenajeLogic.getTipoDrenaje();
	}

	@Override
	public void saveTipoDrenaje(TipoDrenaje entity) throws Exception {
		tipoDrenajeLogic.saveTipoDrenaje(entity);
	}

	@Override
	public void deleteTipoDrenaje(TipoDrenaje entity) throws Exception {
		tipoDrenajeLogic.deleteTipoDrenaje(entity);
	}

	@Override
	public void updateTipoDrenaje(TipoDrenaje entity) throws Exception {
		tipoDrenajeLogic.updateTipoDrenaje(entity);
	}

	@Override
	public TipoDrenaje getTipoDrenaje(Long tipoDrenajeId) throws Exception {
		TipoDrenaje tipoDrenaje = null;

		try {
			tipoDrenaje = tipoDrenajeLogic.getTipoDrenaje(tipoDrenajeId);
		} catch (Exception e) {
			throw e;
		}

		return tipoDrenaje;
	}

	@Override
	public List<TipoDrenaje> findByCriteriaInTipoDrenaje(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoDrenajeLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoDrenaje> findPageTipoDrenaje(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoDrenajeLogic.findPageTipoDrenaje(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoDrenaje() throws Exception {
		return tipoDrenajeLogic.findTotalNumberTipoDrenaje();
	}

	@Override
	public List<TipoDrenajeDTO> getDataTipoDrenaje() throws Exception {
		return tipoDrenajeLogic.getDataTipoDrenaje();
	}

	@Override
	public List<TipProvee> getTipProvee() throws Exception {
		return tipProveeLogic.getTipProvee();
	}

	@Override
	public void saveTipProvee(TipProvee entity) throws Exception {
		tipProveeLogic.saveTipProvee(entity);
	}

	@Override
	public void deleteTipProvee(TipProvee entity) throws Exception {
		tipProveeLogic.deleteTipProvee(entity);
	}

	@Override
	public void updateTipProvee(TipProvee entity) throws Exception {
		tipProveeLogic.updateTipProvee(entity);
	}

	@Override
	public TipProvee getTipProvee(Long tpProvId) throws Exception {
		TipProvee tipProvee = null;

		try {
			tipProvee = tipProveeLogic.getTipProvee(tpProvId);
		} catch (Exception e) {
			throw e;
		}

		return tipProvee;
	}

	@Override
	public List<TipProvee> findByCriteriaInTipProvee(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipProveeLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipProvee> findPageTipProvee(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipProveeLogic.findPageTipProvee(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipProvee() throws Exception {
		return tipProveeLogic.findTotalNumberTipProvee();
	}

	@Override
	public List<TipProveeDTO> getDataTipProvee() throws Exception {
		return tipProveeLogic.getDataTipProvee();
	}

//	@Override
//	public List<Topografia> getTopografia() throws Exception {
//		return topografiaLogic.getTopografia();
//	}

	@Override
	public void saveTopografia(Topografia entity) throws Exception {
		topografiaLogic.saveTopografia(entity);
	}

	@Override
	public void deleteTopografia(Topografia entity) throws Exception {
		topografiaLogic.deleteTopografia(entity);
	}

	@Override
	public void updateTopografia(Topografia entity) throws Exception {
		topografiaLogic.updateTopografia(entity);
	}

	@Override
	public Topografia getTopografia(Long topografiaId) throws Exception {
		Topografia topografia = null;

		try {
			topografia = topografiaLogic.getTopografia(topografiaId);
		} catch (Exception e) {
			throw e;
		}

		return topografia;
	}

	@Override
	public List<Topografia> findByCriteriaInTopografia(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return topografiaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Topografia> findPageTopografia(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return topografiaLogic.findPageTopografia(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTopografia() throws Exception {
		return topografiaLogic.findTotalNumberTopografia();
	}

	@Override
	public List<TopografiaDTO> getDataTopografia() throws Exception {
		return topografiaLogic.getDataTopografia();
	}

	@Override
	public List<Trabajador> getTrabajador() throws Exception {
		return trabajadorLogic.getTrabajador();
	}

	@Override
	public void saveTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception {
		trabajadorLogic.saveTrabajador(entity, dataTarifaDeduccion, dataTarifaDevengos);
	}

	@Override
	public void deleteTrabajador(Trabajador entity) throws Exception {
		trabajadorLogic.deleteTrabajador(entity);
	}

	@Override
	public void updateTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception {
		trabajadorLogic.updateTrabajador(entity, dataTarifaDeduccion, dataTarifaDevengos);
	}

	@Override
	public Trabajador getTrabajador(Long trabId) throws Exception {
		Trabajador trabajador = null;

		try {
			trabajador = trabajadorLogic.getTrabajador(trabId);
		} catch (Exception e) {
			throw e;
		}

		return trabajador;
	}

	@Override
	public List<Trabajador> findByCriteriaInTrabajador(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return trabajadorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Trabajador> findPageTrabajador(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return trabajadorLogic.findPageTrabajador(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTrabajador() throws Exception {
		return trabajadorLogic.findTotalNumberTrabajador();
	}

	@Override
	public List<TrabajadorDTO> getDataTrabajador() throws Exception {
		return trabajadorLogic.getDataTrabajador();
	}

	@Override
	public List<UdadMed> getUdadMed() throws Exception {
		return udadMedLogic.getUdadMed();
	}

	@Override
	public void saveUdadMed(UdadMed entity) throws Exception {
		udadMedLogic.saveUdadMed(entity);
	}

	@Override
	public void deleteUdadMed(UdadMed entity) throws Exception {
		udadMedLogic.deleteUdadMed(entity);
	}

	@Override
	public void updateUdadMed(UdadMed entity) throws Exception {
		udadMedLogic.updateUdadMed(entity);
	}

	@Override
	public UdadMed getUdadMed(Long udadMedId) throws Exception {
		UdadMed udadMed = null;

		try {
			udadMed = udadMedLogic.getUdadMed(udadMedId);
		} catch (Exception e) {
			throw e;
		}

		return udadMed;
	}

	@Override
	public List<UdadMed> findByCriteriaInUdadMed(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return udadMedLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<UdadMed> findPageUdadMed(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return udadMedLogic.findPageUdadMed(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberUdadMed() throws Exception {
		return udadMedLogic.findTotalNumberUdadMed();
	}

	@Override
	public List<UdadMedDTO> getDataUdadMed() throws Exception {
		return udadMedLogic.getDataUdadMed();
	}

	@Override
	public List<ValorVar> getValorVar() throws Exception {
		return valorVarLogic.getValorVar();
	}

	@Override
	public void saveValorVar(ValorVar entity) throws Exception {
		valorVarLogic.saveValorVar(entity);
	}

	@Override
	public void deleteValorVar(ValorVar entity) throws Exception {
		valorVarLogic.deleteValorVar(entity);
	}

	@Override
	public void updateValorVar(ValorVar entity) throws Exception {
		valorVarLogic.updateValorVar(entity);
	}

	@Override
	public ValorVar getValorVar(Long valorVarId) throws Exception {
		ValorVar valorVar = null;

		try {
			valorVar = valorVarLogic.getValorVar(valorVarId);
		} catch (Exception e) {
			throw e;
		}

		return valorVar;
	}

	@Override
	public List<ValorVar> findByCriteriaInValorVar(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return valorVarLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ValorVar> findPageValorVar(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return valorVarLogic.findPageValorVar(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberValorVar() throws Exception {
		return valorVarLogic.findTotalNumberValorVar();
	}

	@Override
	public List<ValorVarDTO> getDataValorVar() throws Exception {
		return valorVarLogic.getDataValorVar();
	}

	@Override
	public List<Variable> getVariable() throws Exception {
		return variableLogic.getVariable();
	}

	@Override
	public void deleteVariable(Variable entity) throws Exception {
		variableLogic.deleteVariable(entity);
	}

	@Override
	public Variable getVariable(Long variableId) throws Exception {
		Variable variable = null;

		try {
			variable = variableLogic.getVariable(variableId);
		} catch (Exception e) {
			throw e;
		}

		return variable;
	}

	@Override
	public List<Variable> findByCriteriaInVariable(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return variableLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Variable> findPageVariable(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return variableLogic.findPageVariable(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberVariable() throws Exception {
		return variableLogic.findTotalNumberVariable();
	}

	@Override
	public List<VariableDTO> getDataVariable() throws Exception {
		return variableLogic.getDataVariable();
	}

	@Override
	public List<Variedad> getVariedad() throws Exception {
		return variedadLogic.getVariedad();
	}

	@Override
	public void saveVariedad(Variedad entity) throws Exception {
		variedadLogic.saveVariedad(entity);
	}

	@Override
	public void deleteVariedad(Variedad entity) throws Exception {
		variedadLogic.deleteVariedad(entity);
	}

	@Override
	public void updateVariedad(Variedad entity) throws Exception {
		variedadLogic.updateVariedad(entity);
	}

	@Override
	public Variedad getVariedad(Long variedId) throws Exception {
		Variedad variedad = null;

		try {
			variedad = variedadLogic.getVariedad(variedId);
		} catch (Exception e) {
			throw e;
		}

		return variedad;
	}

	@Override
	public List<Variedad> findByCriteriaInVariedad(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return variedadLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Variedad> findPageVariedad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return variedadLogic.findPageVariedad(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberVariedad() throws Exception {
		return variedadLogic.findTotalNumberVariedad();
	}

	@Override
	public List<VariedadDTO> getDataVariedad() throws Exception {
		return variedadLogic.getDataVariedad();
	}

	@Override
	public List<VariedadNivel4> getVariedadNivel4() throws Exception {
		return variedadNivel4Logic.getVariedadNivel4();
	}

	@Override
	public void saveVariedadNivel4(VariedadNivel4 entity) throws Exception {
		variedadNivel4Logic.saveVariedadNivel4(entity);
	}

	@Override
	public void deleteVariedadNivel4(VariedadNivel4 entity) throws Exception {
		variedadNivel4Logic.deleteVariedadNivel4(entity);
	}

	@Override
	public void updateVariedadNivel4(VariedadNivel4 entity) throws Exception {
		variedadNivel4Logic.updateVariedadNivel4(entity);
	}

	@Override
	public VariedadNivel4 getVariedadNivel4(Long variedadNivel4Id) throws Exception {
		VariedadNivel4 variedadNivel4 = null;

		try {
			variedadNivel4 = variedadNivel4Logic.getVariedadNivel4(variedadNivel4Id);
		} catch (Exception e) {
			throw e;
		}

		return variedadNivel4;
	}

	@Override
	public List<VariedadNivel4> findByCriteriaInVariedadNivel4(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return variedadNivel4Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<VariedadNivel4> findPageVariedadNivel4(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return variedadNivel4Logic.findPageVariedadNivel4(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberVariedadNivel4() throws Exception {
		return variedadNivel4Logic.findTotalNumberVariedadNivel4();
	}

	@Override
	public List<VariedadNivel4DTO> getDataVariedadNivel4() throws Exception {
		return variedadNivel4Logic.getDataVariedadNivel4();
	}

	@Override
	public List<ZonaGeografica> getZonaGeografica() throws Exception {
		return zonaGeograficaLogic.getZonaGeografica();
	}

	@Override
	public void saveZonaGeografica(ZonaGeografica entity) throws Exception {
		zonaGeograficaLogic.saveZonaGeografica(entity);
	}

	@Override
	public void deleteZonaGeografica(ZonaGeografica entity) throws Exception {
		zonaGeograficaLogic.deleteZonaGeografica(entity);
	}

	@Override
	public void updateZonaGeografica(ZonaGeografica entity) throws Exception {
		zonaGeograficaLogic.updateZonaGeografica(entity);
	}

	@Override
	public ZonaGeografica getZonaGeografica(Long zonaGeograficaId) throws Exception {
		ZonaGeografica zonaGeografica = null;

		try {
			zonaGeografica = zonaGeograficaLogic.getZonaGeografica(zonaGeograficaId);
		} catch (Exception e) {
			throw e;
		}

		return zonaGeografica;
	}

	@Override
	public List<ZonaGeografica> findByCriteriaInZonaGeografica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return zonaGeograficaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ZonaGeografica> findPageZonaGeografica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return zonaGeograficaLogic.findPageZonaGeografica(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberZonaGeografica() throws Exception {
		return zonaGeograficaLogic.findTotalNumberZonaGeografica();
	}

	@Override
	public List<ZonaGeograficaDTO> getDataZonaGeografica() throws Exception {
		return zonaGeograficaLogic.getDataZonaGeografica();
	}

	@Override
	public List<ZonAgroec> getZonAgroec() throws Exception {
		return zonAgroecLogic.getZonAgroec();
	}

	@Override
	public void saveZonAgroec(ZonAgroec entity) throws Exception {
		zonAgroecLogic.saveZonAgroec(entity);
	}

	@Override
	public void deleteZonAgroec(ZonAgroec entity) throws Exception {
		zonAgroecLogic.deleteZonAgroec(entity);
	}

	@Override
	public void updateZonAgroec(ZonAgroec entity) throws Exception {
		zonAgroecLogic.updateZonAgroec(entity);
	}

	@Override
	public ZonAgroec getZonAgroec(Long zonAgroecId) throws Exception {
		ZonAgroec zonAgroec = null;

		try {
			zonAgroec = zonAgroecLogic.getZonAgroec(zonAgroecId);
		} catch (Exception e) {
			throw e;
		}

		return zonAgroec;
	}

	@Override
	public List<ZonAgroec> findByCriteriaInZonAgroec(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return zonAgroecLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ZonAgroec> findPageZonAgroec(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return zonAgroecLogic.findPageZonAgroec(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberZonAgroec() throws Exception {
		return zonAgroecLogic.findTotalNumberZonAgroec();
	}

	@Override
	public List<ZonAgroecDTO> getDataZonAgroec() throws Exception {
		return zonAgroecLogic.getDataZonAgroec();
	}

	@Override
	public void saveVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception {
		variableLogic.saveVariable(entity, dataValores, dataRango);
	}

	@Override
	public void updateVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception {
		variableLogic.updateVariable(entity, dataValores, dataRango);
	}

	@Override
	public List<ListValorDTO> getDataValoresByVariableId(Long variableId) throws Exception {
		return listValorLogic.getDataValorByVariableId(variableId);
	}

	@Override
	public List<RangoValorDTO> getDataRangoByVariableId(Long variableId) throws Exception {
		return rangoValorLogic.getDataRangoValorById(variableId);
	}

	@Override
	public List<VariedadNivel4DTO> getDataVariedadNivel4ByNivel4Id(Long nivel4Id) throws Exception {
		return variedadNivel4Logic.getDataVariedadNivel4ByNivel4Id(nivel4Id);

	}

	@Override
	public List<TarifaDeduccion> getTarifaDeduccion() throws Exception {
		return tarifaDeduccionLogic.getTarifaDeduccion();
	}

	@Override
	public void saveTarifaDeduccion(TarifaDeduccion entity) throws Exception {
		tarifaDeduccionLogic.saveTarifaDeduccion(entity);
	}

	@Override
	public void deleteTarifaDeduccion(TarifaDeduccion entity) throws Exception {
		tarifaDeduccionLogic.deleteTarifaDeduccion(entity);
	}

	@Override
	public void updateTarifaDeduccion(TarifaDeduccion entity) throws Exception {
		tarifaDeduccionLogic.updateTarifaDeduccion(entity);
	}

	@Override
	public TarifaDeduccion getTarifaDeduccion(Long deduccionId) throws Exception {
		TarifaDeduccion tarifaDeduccion = null;

		try {
			tarifaDeduccion = tarifaDeduccionLogic.getTarifaDeduccion(deduccionId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaDeduccion;
	}

	@Override
	public List<TarifaDeduccion> findByCriteriaInTarifaDeduccion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tarifaDeduccionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaDeduccion> findPageTarifaDeduccion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tarifaDeduccionLogic.findPageTarifaDeduccion(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTarifaDeduccion() throws Exception {
		return tarifaDeduccionLogic.findTotalNumberTarifaDeduccion();
	}

	@Override
	public List<TarifaDeduccionDTO> getDataTarifaDeduccion() throws Exception {
		return tarifaDeduccionLogic.getDataTarifaDeduccion();
	}

	@Override
	public List<TarifaOtrosDevengos> getTarifaOtrosDevengos() throws Exception {
		return tarifaOtrosDevengosLogic.getTarifaOtrosDevengos();
	}

	@Override
	public void saveTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception {
		tarifaOtrosDevengosLogic.saveTarifaOtrosDevengos(entity);
	}

	@Override
	public void deleteTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception {
		tarifaOtrosDevengosLogic.deleteTarifaOtrosDevengos(entity);
	}

	@Override
	public void updateTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception {
		tarifaOtrosDevengosLogic.updateTarifaOtrosDevengos(entity);
	}

	@Override
	public TarifaOtrosDevengos getTarifaOtrosDevengos(Long odevengosId) throws Exception {
		TarifaOtrosDevengos tarifaOtrosDevengos = null;

		try {
			tarifaOtrosDevengos = tarifaOtrosDevengosLogic.getTarifaOtrosDevengos(odevengosId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaOtrosDevengos;
	}

	@Override
	public List<TarifaOtrosDevengos> findByCriteriaInTarifaOtrosDevengos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tarifaOtrosDevengosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaOtrosDevengos> findPageTarifaOtrosDevengos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tarifaOtrosDevengosLogic.findPageTarifaOtrosDevengos(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTarifaOtrosDevengos() throws Exception {
		return tarifaOtrosDevengosLogic.findTotalNumberTarifaOtrosDevengos();
	}

	@Override
	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengos() throws Exception {
		return tarifaOtrosDevengosLogic.getDataTarifaOtrosDevengos();
	}

	@Override
	public List<DistribucionAreaVariedadDTO> consultarInformeDistribucionAreaVariedad(Long cultivo, String variedad)
			throws Exception {
		return informesLogic.consultarInformeDistribucionAreaVariedad(cultivo, variedad);
	}

	@Override
	public List<DistribucionAreaFincaDTO> consultarInformeDistribucionAreaFinca(Long finca) throws Exception {
		return informesLogic.consultarInformeDistribucionAreaFinca(finca);
	}

	@Override
	public void saveDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception {
		datAplicProductoLogic.saveDatAplicProducto(entity, dataDetProductos);
	}

	@Override
	public void updateDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception {
		datAplicProductoLogic.updateDatAplicProducto(entity, dataDetProductos);
	}

	@Override
	public List<DatAplicProdDetDTO> getDataDetProductosByDatAplicProdId(Long datAplicProdId) throws Exception {
		return datAplicProdDetLogic.getDataDetProductosByDatAplicProdId(datAplicProdId);
	}

	@Override
	public void saveDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4, List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception {
		datTransProdLogic.saveDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4, dataPlanillaDet);

	}

	@Override
	public void updateDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4, List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception {
		datTransProdLogic.updateDatTransProd(entity, dataDetTransProductos, dataDetTransNivel4, dataPlanillaDet);

	}

	@Override
	public List<DatTransProdDetDTO> getDataDetTransProductosByDatTransProdId(Long datTransProdId) throws Exception {
		return datTransProdDetLogic.getDataDetTransProductosByDatTransProdId(datTransProdId);
	}

	@Override
	public List<EstPluvioDTO> getDataPageEstPluvio(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return estPluvioLogic.findByCriteriaPageEstPluvio(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberEstPluvio(Map<String, Object> filters) throws Exception {
		return estPluvioLogic.findTotalNumberEstPluvio(filters);
	}

	@Override
	public List<Nivel4DTO> getDataPageNivel4(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return nivel4Logic.findByCriteriaPageNivel4(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberNivel4(Map<String, Object> filters) throws Exception {
		return nivel4Logic.findTotalNumberNivel4(filters);
	}

	@Override
	public List<Nivel2DTO> getDataPageNivel2(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return nivel2Logic.findByCriteriaPageNivel2(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberNivel2(Map<String, Object> filters) throws Exception {
		return nivel2Logic.findTotalNumberNivel2(filters);
	}

	@Override
	public List<Nivel3DTO> getDataPageNivel3(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return nivel3Logic.findByCriteriaPageNivel3(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberNivel3(Map<String, Object> filters) throws Exception {
		return nivel3Logic.findTotalNumberNivel3(filters);
	}

	@Override
	public List<TrabajadorDTO> getDataPageTrabajador(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) throws Exception {
		return trabajadorLogic.findByCriteriaPageTrabajador(startRow, pageSize, sortField, sortOrder, filters, modulo);
	}

	@Override
	public Long findTotalNumberTrabajador(Map<String, Object> filters) throws Exception {
		return trabajadorLogic.findTotalNumberTrabajador(filters);
	}

	@Override
	public List<EquipoDTO> getDataPageEquipo(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) throws Exception {
		return equipoLogic.findByCriteriaPageEquipo(startRow, pageSize, sortField, sortOrder, filters, modulo);
	}

	@Override
	public Long findTotalNumberEquipo(Map<String, Object> filters) throws Exception {
		return equipoLogic.findTotalNumberEquipo(filters);
	}

	@Override
	public List<PersEmprDTO> getDataPageEmpresa(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return persEmprLogic.findByCriteriaPageEmpresa(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberEmpresa(Map<String, Object> filters) throws Exception {
		return persEmprLogic.findTotalNumberEmpresa(filters);
	}

	@Override
	public List<FlotaTransporteDTO> getDataPageFlotaTransporte(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return flotaTransporteLogic.findByCriteriaPageFlotaTransporte(startRow, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long findTotalNumberFlotaTransporte(Map<String, Object> filters) throws Exception {
		return flotaTransporteLogic.findTotalNumberFlotaTransporte(filters);
	}

	@Override
	public List<ProductoDTO> getDataPageProducto(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return productoLogic.findByCriteriaPageProducto(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberProducto(Map<String, Object> filters) throws Exception {
		return productoLogic.findTotalNumberProducto(filters);
	}

	@Override
	public List<DatPlanLaborDTO> getDataPagePlanLabor(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return datPlanLaborLogic.findByCriteriaPagePlanLabor(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberPlanLabor(Map<String, Object> filters) throws Exception {
		return datPlanLaborLogic.findTotalNumberPlanLabor(filters);
	}

	@Override
	public List<DatPlanillaNominaDTO> getDataPagePlanillaNomina(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return datPlanillaNominaLogic.findByCriteriaPagePlanillaNomina(startRow, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long findTotalNumberPlanillaNomina(Map<String, Object> filters) throws Exception {
		return datPlanillaNominaLogic.findTotalNumberPlanillaNomina(filters);
	}

	@Override
	public List<DatServicioDTO> getDataPageServicio(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return datServicioLogic.findByCriteriaPageServicio(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberServicio(Map<String, Object> filters) throws Exception {
		return datServicioLogic.findTotalNumberServicio(filters);
	}

	@Override
	public List<DatAplicProductoDTO> getDataPageAplicProducto(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return datAplicProductoLogic.findByCriteriaPageAplicProducto(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberAplicProducto(Map<String, Object> filters) throws Exception {
		return datAplicProductoLogic.findTotalNumberAplicProducto(filters);
	}

	@Override
	public List<DatRiegoDTO> getDataPageRiego(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return datRiegoLogic.findByCriteriaPageRiego(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberRiego(Map<String, Object> filters) throws Exception {
		return datRiegoLogic.findTotalNumberRiego(filters);
	}

	@Override
	public List<DatClimatDTO> getDataPageClima(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return datClimatLogic.findByCriteriaPageClima(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberClima(Map<String, Object> filters) throws Exception {
		return datClimatLogic.findTotalNumberClima(filters);
	}

	@Override
	public List<DatPluvioDTO> getDataPageDatPluvio(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		return datPluvioLogic.findByCriteriaPageDatPluvio(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberDatPluvio(Map<String, Object> filters) throws Exception {
		return datPluvioLogic.findTotalNumberDatPluvio(filters);
	}

	@Override
	public List<DatEvaporimetroDTO> getDataPageDatEvaporimetro(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return datEvaporimetroLogic.findByCriteriaPageDatEvaporimetro(startRow, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long findTotalNumberDatEvaporimetro(Map<String, Object> filters) throws Exception {
		return datEvaporimetroLogic.findTotalNumberDatEvaporimetro(filters);
	}

	@Override
	public List<DatEstimCosechaDTO> getDataPageDatEstimCosecha(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return datEstimCosechaLogic.findByCriteriaPageDatEstimCosecha(startRow, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long findTotalNumberDatEstimCosecha(Map<String, Object> filters) throws Exception {
		return datEstimCosechaLogic.findTotalNumberDatEstimCosecha(filters);
	}

	@Override
	public List<DatTransProdDTO> getDataPageDatTransProd(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return datTransProdLogic.findByCriteriaPageDatTransProd(startRow, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public Long findTotalNumberDatTransProd(Map<String, Object> filters) throws Exception {
		return datTransProdLogic.findTotalNumberDatTransProd(filters);
	}

	@Override
	public List<DatPlanillaNominaDet> getDatPlanillaNominaDet() throws Exception {
		return datPlanillaNominaDetLogic.getDatPlanillaNominaDet();
	}

	@Override
	public void saveDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception {
		datPlanillaNominaDetLogic.saveDatPlanillaNominaDet(entity);
	}

	@Override
	public void deleteDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception {
		datPlanillaNominaDetLogic.deleteDatPlanillaNominaDet(entity);
	}

	@Override
	public void updateDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception {
		datPlanillaNominaDetLogic.updateDatPlanillaNominaDet(entity);
	}

	@Override
	public DatPlanillaNominaDet getDatPlanillaNominaDet(Long detPlanillaNominaId) throws Exception {
		DatPlanillaNominaDet datPlanillaNominaDet = null;

		try {
			datPlanillaNominaDet = datPlanillaNominaDetLogic.getDatPlanillaNominaDet(detPlanillaNominaId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanillaNominaDet;
	}

	@Override
	public List<DatPlanillaNominaDet> findByCriteriaInDatPlanillaNominaDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datPlanillaNominaDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatPlanillaNominaDet> findPageDatPlanillaNominaDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datPlanillaNominaDetLogic.findPageDatPlanillaNominaDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatPlanillaNominaDet() throws Exception {
		return datPlanillaNominaDetLogic.findTotalNumberDatPlanillaNominaDet();
	}

	@Override
	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDet() throws Exception {
		return datPlanillaNominaDetLogic.getDataDatPlanillaNominaDet();
	}

	@Override
	public List<DatServicioDet> getDatServicioDet() throws Exception {
		return datServicioDetLogic.getDatServicioDet();
	}

	@Override
	public void saveDatServicioDet(DatServicioDet entity) throws Exception {
		datServicioDetLogic.saveDatServicioDet(entity);
	}

	@Override
	public void deleteDatServicioDet(DatServicioDet entity) throws Exception {
		datServicioDetLogic.deleteDatServicioDet(entity);
	}

	@Override
	public void updateDatServicioDet(DatServicioDet entity) throws Exception {
		datServicioDetLogic.updateDatServicioDet(entity);
	}

	@Override
	public DatServicioDet getDatServicioDet(Long datServicioDetId) throws Exception {
		DatServicioDet datServicioDet = null;

		try {
			datServicioDet = datServicioDetLogic.getDatServicioDet(datServicioDetId);
		} catch (Exception e) {
			throw e;
		}

		return datServicioDet;
	}

	@Override
	public List<DatServicioDet> findByCriteriaInDatServicioDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datServicioDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatServicioDet> findPageDatServicioDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datServicioDetLogic.findPageDatServicioDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatServicioDet() throws Exception {
		return datServicioDetLogic.findTotalNumberDatServicioDet();
	}

	@Override
	public List<DatServicioDetDTO> getDataDatServicioDet() throws Exception {
		return datServicioDetLogic.getDataDatServicioDet();
	}

	/** TARIFAS **/

	@Override
	public List<PrecioPromProdDTO> getDataProductosByPrecioPromProdId(Long productoId) throws Exception {
		return precioPromProdLogic.getDataProductosByPrecioPromProdId(productoId);
	}

	@Override
	public void saveProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception {
		productoLogic.saveProducto(entity, dataDetPrecioProductos, dataProdRelacionado);
	}

	@Override
	public void updateProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception {
		productoLogic.updateProducto(entity, dataDetPrecioProductos, dataProdRelacionado);
	}


	@Override
	public List<TarifaEquipPropDTO> getDataEquipoByTarifaEquipPropId(Long equipoId) throws Exception {
		return tarifaEquipPropLogic.getDataEquipoByTarifaEquipPropId(equipoId);
	}

	@Override
	public void saveEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,
			List<EquipoEventoDTO> dataEventosEquipos) throws Exception {
		equipoLogic.saveEquipo(entity, dataTarifaEquipProp, dataEventosEquipos);
	}

	@Override
	public void updateEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,
			List<EquipoEventoDTO> dataEventosEquipos) throws Exception {
		equipoLogic.updateEquipo(entity, dataTarifaEquipProp, dataEventosEquipos);
	}

	@Override
	public List<TarifaProfesionDTO> getDataProfesionByTarifaProfesionId(Long profesionId) throws Exception {
		return tarifaProfesionLogic.getDataProfesionByTarifaProfesionId(profesionId);
	}

	@Override
	public void saveProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception {
		profesionLogic.saveProfesion(entity, dataTarifaProfesion);
	}

	@Override
	public void updateProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception {
		profesionLogic.updateProfesion(entity, dataTarifaProfesion);
	}

	@Override
	public List<TarifaContratistaDTO> getDataContratistaByTarifaContratistaId(Long persEmprId) throws Exception {
		return tarifaContratistaLogic.getDataContratistaByTarifaContratistaId(persEmprId);
	}

	@Override
	public void savePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception {
		persEmprLogic.savePersEmpr(entity, dataTarifaContratista);
	}

	@Override
	public void updatePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception {
		persEmprLogic.updatePersEmpr(entity, dataTarifaContratista);
	}

	@Override
	public List<TarifaLaborRendimiento> getTarifaLaborRendimiento() throws Exception {
		return tarifaLaborRendimientoLogic.getTarifaLaborRendimiento();
	}

	@Override
	public void saveTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception {
		tarifaLaborRendimientoLogic.saveTarifaLaborRendimiento(entity);
	}

	@Override
	public void deleteTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception {
		tarifaLaborRendimientoLogic.deleteTarifaLaborRendimiento(entity);
	}

	@Override
	public void updateTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception {
		tarifaLaborRendimientoLogic.updateTarifaLaborRendimiento(entity);
	}

	@Override
	public TarifaLaborRendimiento getTarifaLaborRendimiento(Long tarifaLaborId) throws Exception {
		TarifaLaborRendimiento tarifaLaborRendimiento = null;

		try {
			tarifaLaborRendimiento = tarifaLaborRendimientoLogic.getTarifaLaborRendimiento(tarifaLaborId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaLaborRendimiento;
	}

	@Override
	public List<TarifaLaborRendimiento> findByCriteriaInTarifaLaborRendimiento(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return tarifaLaborRendimientoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaLaborRendimiento> findPageTarifaLaborRendimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tarifaLaborRendimientoLogic.findPageTarifaLaborRendimiento(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTarifaLaborRendimiento() throws Exception {
		return tarifaLaborRendimientoLogic.findTotalNumberTarifaLaborRendimiento();
	}

	@Override
	public List<TarifaLaborRendimientoDTO> getDataTarifaLaborRendimiento() throws Exception {
		return tarifaLaborRendimientoLogic.getDataTarifaLaborRendimiento();
	}

	@Override
	public List<TarifaLaborRendimientoDTO> getDataRendimientoByTarifaRendimientoId(Long laborId) throws Exception {
		return tarifaLaborRendimientoLogic.getDataRendimientoByTarifaRendimientoId(laborId);
	}

	@Override
	public void saveLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos, List<LaborCcontableDTO> dataCcontable) throws Exception {
		laborLogic.saveLabor(entity, dataTarifaRendimiento, dataLaborRecursos, dataCcontable);
	}

	@Override
	public void updateLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos, List<LaborCcontableDTO> dataCcontable) throws Exception {
		laborLogic.updateLabor(entity, dataTarifaRendimiento, dataLaborRecursos, dataCcontable);
	}

	/* Reportes */

	@Override
	public List<CostosTotalesDTO> consultarInformeCostosTotales(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception {
		return informesLogic.consultarInformeCostosTotales(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, numeroCosechas, flagNumeroCosechas);
	}

	@Override
	public List<ConsultaMttoDTO> consultarMttoMaquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String propietarioEquipo, Long flagPropietarioEquipo, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto) throws Exception {
		return informesLogic.consultarMttoMaquinaria(compania, fechaInicial, fechaFinal, propietarioEquipo,
				flagPropietarioEquipo, equipo, flagEquipo, tipoMtto, flagTipoMtto);
	}

	@Override
	public List<ProgramacionLaboresDTO> consultarInformeProgramacionLabores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String grupoLabor, Long flagGrupoLabor,
			String supervisor, Long flagSupervisor) throws Exception {
		return informesLogic.consultarInformeProgramacionLabores(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, grupoLabor, flagGrupoLabor,
				supervisor, flagSupervisor);
	}

	@Override
	public List<DatosClimaticosDTO> consultarInformeDatosClimaticos(Long compania, Long estClima, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informesLogic.consultarInformeDatosClimaticos(compania, estClima, fechaInicial, fechaFinal);
	}

	@Override
	public List<DatosEvaporimetrosDTO> consultarInformeDatosEvaporimetros(Long estEvaporimetro, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informesLogic.consultarInformeDatosEvaporimetros(estEvaporimetro, fechaInicial, fechaFinal);
	}

	@Override
	public List<PluviometriaDTO> consultarInformePluviometria(Long estPluvio, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.consultarInformePluviometria(estPluvio, fechaInicial, fechaFinal);
	}

	@Override
	public List<ProntuarioLotesDTO> consultarInformeProntuarioLotes(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String tenencia,
			Long flagTenencia) throws Exception {
		return informesLogic.consultarInformeProntuarioLotes(compania, zona, flagZona, finca, flagFinca, bloque,
				flagBloque, lote, flagLote, tenencia, flagTenencia);
	}

	@Override
	public List<ProgramaCosechaDTO> consultarInformeProgramaCosecha(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String tenencia, Long flagTenencia) throws Exception {
		return informesLogic.consultarInformeProgramaCosecha(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, tenencia, flagTenencia);
	}

	@Override
	public List<EstadoOrdenTrabajoDTO> consultarInformeEstadoOrdenTrabajo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String ordenTrabajo,
			Long flagOrdenTrabajo) throws Exception {
		return informesLogic.consultarInformeEstadoOrdenTrabajo(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, ordenTrabajo, flagOrdenTrabajo);
	}

	@Override
	public List<AnalisisEnfermedadDTO> consultarAnalisisEnfermedad(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception {
		return informesLogic.consultarAnalisisEnfermedad(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, enfermedad, flagEnfermedad);
	}

	@Override
	public List<AnalisisPlagaDTO> consultarAnalisisPlaga(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String plaga, Long flagPlaga) throws Exception {
		return informesLogic.consultarAnalisisPlaga(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, plaga, flagPlaga);
	}

	@Override
	public List<DisponibilidadHidricaDTO> consultarInformeDisponibilidadHidrica(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura,
			Long flagInfraestructura, String sistemaRiego, Long flagSistemaRiego, Long numPlanilla) throws Exception {
		return informesLogic.consultarInformeDisponibilidadHidrica(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, infraestructura, flagInfraestructura, sistemaRiego,
				flagSistemaRiego, numPlanilla);
	}

	@Override
	public List<IncidenciaEnfermedadDTO> consultarInformeIncidenciaEnfermedad(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception {
		return informesLogic.consultarInformeIncidenciaEnfermedad(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, enfermedad, flagEnfermedad);
	}

	@Override
	public List<PrecipitacionAniosDTO> consultarInformePrecipitacionAnios(Long estPluvio) throws Exception {
		return informesLogic.consultarInformePrecipitacionAnios(estPluvio);
	}

	@Override
	public List<HorasMaquinaDetalladoDTO> consultarInformeHorasMaquinaDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo,
			Long numPlanilla) throws Exception {
		return informesLogic.consultarInformeHorasMaquinaDetallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, propietarioEquipo, flagPropietarioEquipo,
				modeloEquipo, flagModeloEquipo, equipo, flagEquipo, numPlanilla);
	}

	@Override
	public List<ConsultaStockDTO> consultaStock(Long compania, String tipoProducto, Long flagTipoProducto,
			String producto, Long flagProducto, String almacen, Long flagAlmacen) throws Exception {
		return informesLogic.consultaStock(compania, tipoProducto, flagTipoProducto, producto, flagProducto, almacen,
				flagAlmacen);
	}

	@Override
	public List<DistribucionAreaCultivoDTO> consultarInformeDistribuccionAreaCultivo(Long compania, String cultivo,
			Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String variedad, Long flagVariedad) throws Exception {
		return informesLogic.consultarInformeDistribuccionAreaCultivo(compania, cultivo, flagCultivo, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, variedad, flagVariedad);

	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLote(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesLogic.consultarInformeProyeccionLaboresLote(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteDet(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesLogic.consultarInformeProyeccionLaboresLoteDet(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	public List<ProduccionCortesDTO> consultarInformeProduccionCortes(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) throws Exception {
		return informesLogic.consultarInformeProduccionCortes(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, numeroCosechas, flagNumeroCosechas, producto, flagProducto);
	}

	@Override
	public List<NominaDetalladaDTO> consultarInformeNominaDetallada(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador, String tipoTransaccion, Long planilla, Long concepto, String flagConcepto,
			String origen, String tipoPersonal) throws Exception {
		return informesLogic.consultarInformeNominaDetallada(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador,
				flagTrabajador, tipoTransaccion, planilla, concepto, flagConcepto, origen, tipoPersonal);

	}

	@Override
	public List<CuadroPrecipitacionDiariaDTO> consultarInformeCuandroPrecipitacionDiario(Long compania,
			Date fechaInicial, Date fechaFinal, Date fechaInicialAcumulada, Date fechaFinalAcumulada, String estPluvio,
			Long flagEstPluvio) throws Exception {
		return informesLogic.consultarInformeCuandroPrecipitacionDiario(compania, fechaInicial, fechaFinal,
				fechaInicialAcumulada, fechaFinalAcumulada, estPluvio, flagEstPluvio);

	}

	@Override
	public List<AnalisisDiatraeaDTO> consultarAnalisisDiatraea(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote) throws Exception {
		return informesLogic.consultarAnalisisDiatraea(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote);

	}

	@Override
	public List<ProduccionAcumFincaDTO> consultarProduccionAcumFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) throws Exception {
		return informesLogic.consultarProduccionAcumFinca(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto, cliente, flagCliente);

	}

	public List<MovimientoVagonCosechaDTO> consultarMovimientoVagon(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String vagon, Long flagVagon) throws Exception {
		return informesLogic.consultarMovimientoVagon(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto, vagon, flagVagon);

	}

	@Override
	public List<DetalleInsumosLoteDTO> consultaDetalleInsumosLoteDTO(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.consultaDetalleInsumosLoteDTO(compania, tipoProducto, flagTipoProducto, producto,
				flagProducto, almacen, flagAlmacen, fechaInicial, fechaFinal);

	}

	/******************* CALCULAR EDAD LOTE **********/
	@Override
	public Double calcularEdadLote(Date fechaActual, Long nivel4) throws Exception {
		return informesLogic.calcularEdadLote(fechaActual, nivel4);
	}

	/***** consulta orden de trabajo ******/
	@Override
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDes(Long compania) throws Exception {
		return informesLogic.consultarOrdenTrabajoDes(compania);
	}

	/****
	 * consulta valores posibles por variable en análisis sanidad vegetal ***+
	 */
	@Override
	public List<ValoresPosiblesVariablesSanidadVegetalDTO> consultarValoresPosiblesVariablesSV(Long idVariable,
			BigDecimal valorVariable, Long idAnalisis) throws Exception {
		return informesLogic.consultarValoresPosiblesVariablesSV(idVariable, valorVariable, idAnalisis);
	}

	@Override
	public String consultarFaseFenologica(Long faseFenologica, Date idFechaDescanso) throws Exception {
		return informesLogic.consultarFaseFenologica(faseFenologica, idFechaDescanso);
	}

	@Override
	public Long consultarFaseFenologicaId(Date idFechaDescanso) throws Exception {
		return informesLogic.consultarFaseFenologicaId(idFechaDescanso);
	}

	/**** consecutivo transaccionales ****/

	@Override
	public long consultarConsecutivoDatEstimCosecha(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatEstimCosecha(compania);
	}

	@Override
	public long consultarConsecutivoUnicoDatPlanillaNomina(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoUnicoDatPlanillaNomina(compania);

	}

	@Override
	public long consultarConsecutivoDatPlanillaNomina(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatPlanillaNomina(compania);
	}

	@Override
	public long consultarConsecutivoDatRiego(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatRiego(compania);
	}

	@Override
	public long consultarConsecutivoDatServicio(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatServicio(compania);
	}

	@Override
	public long consultarConsecutivoDatAplicProducto(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatAplicProducto(compania);
	}

	@Override
	public long consultarConsecutivoDatTransProd(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatTransProd(compania);
	}

	@Override
	public long consultarConsecutivoDatSanVeg(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatSanVeg(compania);
	}

	@Override
	public long consultarConsecutivoDatPlanLabor(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatPlanLabor(compania);
	}

	@Override
	public long consultarConsecutivoDatBascula() throws Exception {
		return informesLogic.consultarConsecutivoDatBascula();
	}

	@Override
	public long consultarConsecutivoAbastecimientoCombustible(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoAbastecimientoCombustible(compania);
	}

	@Override
	public long consultarConsecutivoDatSolicitudesMtto(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatSolicitudesMtto(compania);
	}

	@Override
	public long consultarConsecutivoMantenimientoMaquinaria(Long compania, String tipo_orden) throws Exception {
		return informesLogic.consultarConsecutivoMantenimientoMaquinaria(compania,   tipo_orden);
	}

	// ******tarifas de pago***///

	@Override
	public Double consultarPrecioPromProducto(Long idProducto, Long idAlmacen, Long idCompania, Date idFecha)
			throws Exception {
		return informesLogic.consultarPrecioPromProducto(idProducto, idAlmacen, idCompania, idFecha);
	}

	@Override
	public BigDecimal consultarTarifaProfesion(Long idCompania, Long idContratista, Long idProfesion,
			Long idCeptoNomina, Long idUdadMed, Date idFecha) throws Exception {
		return informesLogic.consultarTarifaProfesion(idCompania, idContratista, idProfesion, idCeptoNomina, idUdadMed,
				idFecha);
	}

	@Override
	public BigDecimal consultarTarifaLaborRendimiento(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception {
		return informesLogic.consultarTarifaLaborRendimiento(idCompania, idContratista, idLabor, idNivel2, idUdadMed,
				idFecha);
	}

	@Override
	public BigDecimal consultarTarifaLaborBonificacion(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception {
		return informesLogic.consultarTarifaLaborBonificacion(idCompania, idContratista, idLabor, idNivel2, idUdadMed,
				idFecha);
	}

	@Override
	public BigDecimal consultarTarifaLaborRendimientoBase(Long idCompania, Long idContratista, Long idLabor,
			Long idNivel2, Long idUdadMed, Date idFecha) throws Exception {
		return informesLogic.consultarTarifaLaborRendimientoBase(idCompania, idContratista, idLabor, idNivel2,
				idUdadMed, idFecha);
	}

	@Override
	public BigDecimal consultarAuxSabado(Long idCompania, Long idTrabajador, Date idFecha) throws Exception {
		return informesLogic.consultarAuxSabado(idCompania, idTrabajador, idFecha);
	}

	@Override
	public Long consultarDiaSabado(Date idFecha) throws Exception {
		return informesLogic.consultarDiaSabado(idFecha);
	}

	@Override
	public BigDecimal consultarTarifaEquipProp(Long idCompania, Long idEquipo, Long idUdadMed, Date idFecha)
			throws Exception {
		return informesLogic.consultarTarifaEquipProp(idCompania, idEquipo, idUdadMed, idFecha);
	}

	@Override
	public BigDecimal consultarTarifaContratista(Long idCompania, Long idContratista, Long idLabor, Long idServicio,
			Long idUdadMed, Date idFecha, Double edadLote, String estadoInc, Long nivel2Id, Long nivel4Id,
			String alturaMata) throws Exception {
		return informesLogic.consultarTarifaContratista(idCompania, idContratista, idLabor, idServicio, idUdadMed,
				idFecha, edadLote, estadoInc, nivel2Id, nivel4Id, alturaMata);
	}

	@Override
	public void saveProducto(Producto entity) throws Exception {

	}

	@Override
	public void updateProducto(Producto entity) throws Exception {

	}

	@Override
	public void savePersEmpr(PersEmpr entity) throws Exception {

	}

	@Override
	public void updatePersEmpr(PersEmpr entity) throws Exception {
	}

	@Override
	public void saveProfesion(Profesion entity) throws Exception {
	}

	@Override
	public void updateProfesion(Profesion entity) throws Exception {
	}

	@Override
	public List<GroupAuthorities> getGroupAuthorities() throws Exception {
		return groupAuthoritiesLogic.getGroupAuthorities();
	}

	@Override
	public void saveGroupAuthorities(GroupAuthorities entity) throws Exception {
		groupAuthoritiesLogic.saveGroupAuthorities(entity);
	}

	@Override
	public void deleteGroupAuthorities(GroupAuthorities entity) throws Exception {
		groupAuthoritiesLogic.deleteGroupAuthorities(entity);
	}

	@Override
	public void updateGroupAuthorities(GroupAuthorities entity) throws Exception {
		groupAuthoritiesLogic.updateGroupAuthorities(entity);
	}

	@Override
	public GroupAuthorities getGroupAuthorities(Long id) throws Exception {
		GroupAuthorities groupAuthorities = null;

		try {
			groupAuthorities = groupAuthoritiesLogic.getGroupAuthorities(id);
		} catch (Exception e) {
			throw e;
		}

		return groupAuthorities;
	}

	@Override
	public List<GroupAuthorities> findByCriteriaInGroupAuthorities(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return groupAuthoritiesLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<GroupAuthorities> findPageGroupAuthorities(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return groupAuthoritiesLogic.findPageGroupAuthorities(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberGroupAuthorities() throws Exception {
		return groupAuthoritiesLogic.findTotalNumberGroupAuthorities();
	}

	@Override
	public List<GroupAuthoritiesDTO> getDataGroupAuthorities() throws Exception {
		return groupAuthoritiesLogic.getDataGroupAuthorities();
	}

	@Override
	public List<GroupMembers> getGroupMembers() throws Exception {
		return groupMembersLogic.getGroupMembers();
	}

	@Override
	public void saveGroupMembers(GroupMembers entity) throws Exception {
		groupMembersLogic.saveGroupMembers(entity);
	}

	@Override
	public void deleteGroupMembers(GroupMembers entity) throws Exception {
		groupMembersLogic.deleteGroupMembers(entity);
	}

	@Override
	public void updateGroupMembers(GroupMembers entity) throws Exception {
		groupMembersLogic.updateGroupMembers(entity);
	}

	@Override
	public GroupMembers getGroupMembers(Long id) throws Exception {
		GroupMembers groupMembers = null;

		try {
			groupMembers = groupMembersLogic.getGroupMembers(id);
		} catch (Exception e) {
			throw e;
		}

		return groupMembers;
	}

	@Override
	public List<GroupMembers> findByCriteriaInGroupMembers(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return groupMembersLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<GroupMembers> findPageGroupMembers(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return groupMembersLogic.findPageGroupMembers(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberGroupMembers() throws Exception {
		return groupMembersLogic.findTotalNumberGroupMembers();
	}

	@Override
	public List<GroupMembersDTO> getDataGroupMembers() throws Exception {
		return groupMembersLogic.getDataGroupMembers();
	}

	@Override
	public List<Groups> getGroups() throws Exception {
		return groupsLogic.getGroups();
	}

	@Override
	public void saveGroups(Groups entity, GroupAuthorities entity2) throws Exception {
		groupsLogic.saveGroups(entity, entity2);
	}

	@Override
	public void deleteGroups(Groups entity) throws Exception {
		groupsLogic.deleteGroups(entity);
	}

	@Override
	public void updateGroups(Groups entity, GroupAuthorities entity2) throws Exception {
		groupsLogic.updateGroups(entity, entity2);
	}

	@Override
	public Groups getGroups(Long id) throws Exception {
		Groups groups = null;

		try {
			groups = groupsLogic.getGroups(id);
		} catch (Exception e) {
			throw e;
		}

		return groups;
	}

	@Override
	public List<Groups> findByCriteriaInGroups(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return groupsLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Groups> findPageGroups(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return groupsLogic.findPageGroups(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberGroups() throws Exception {
		return groupsLogic.findTotalNumberGroups();
	}

	@Override
	public List<GroupsDTO> getDataGroups() throws Exception {
		return groupsLogic.getDataGroups();
	}

	@Override
	public List<Usuarios> getUsuarios() throws Exception {
		return usuariosLogic.getUsuarios();
	}

	@Override
	public void saveUsuarios(Usuarios entity, List<String> grpUser) throws Exception {
		usuariosLogic.saveUsuarios(entity, grpUser);
	}

	@Override
	public void deleteUsuarios(Usuarios entity) throws Exception {
		usuariosLogic.deleteUsuarios(entity);
	}

	@Override
	public void updateUsuarios(Usuarios entity, List<String> grpUser) throws Exception {
		usuariosLogic.updateUsuarios(entity, grpUser);
	}

	@Override
	public Usuarios getUsuarios(Long usuarioId) throws Exception {
		Usuarios usuarios = null;

		try {
			usuarios = usuariosLogic.getUsuarios(usuarioId);
		} catch (Exception e) {
			throw e;
		}

		return usuarios;
	}

	@Override
	public List<Usuarios> findByCriteriaInUsuarios(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return usuariosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Usuarios> findPageUsuarios(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return usuariosLogic.findPageUsuarios(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberUsuarios() throws Exception {
		return usuariosLogic.findTotalNumberUsuarios();
	}

	@Override
	public List<UsuariosDTO> getDataUsuarios() throws Exception {
		return usuariosLogic.getDataUsuarios();
	}

	@Override
	public PrecioPromProd getPrecioPromProd(PrecioPromProdId id) throws Exception {
		return null;
	}

	@Override
	public void saveLabor(Labor entity) throws Exception {

	}

	@Override
	public void updateLabor(Labor entity) throws Exception {

	}

	@Autowired
	private IVeredaLogic veredaLogic;

	@Override
	public List<Vereda> getVereda() throws Exception {
		return veredaLogic.getVereda();
	}

	@Override
	public void saveVereda(Vereda entity) throws Exception {
		veredaLogic.saveVereda(entity);
	}

	@Override
	public void deleteVereda(Vereda entity) throws Exception {
		veredaLogic.deleteVereda(entity);
	}

	@Override
	public void updateVereda(Vereda entity) throws Exception {
		veredaLogic.updateVereda(entity);
	}

	@Override
	public Vereda getVereda(Long veredaId) throws Exception {
		Vereda vereda = null;

		try {
			vereda = veredaLogic.getVereda(veredaId);
		} catch (Exception e) {
			throw e;
		}

		return vereda;
	}

	@Override
	public List<Vereda> findByCriteriaInVereda(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return veredaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Vereda> findPageVereda(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return veredaLogic.findPageVereda(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberVereda() throws Exception {
		return veredaLogic.findTotalNumberVereda();
	}

	@Override
	public List<VeredaDTO> getDataVereda() throws Exception {
		return veredaLogic.getDataVereda();
	}

	/*** AutoCompletado **/

	@Override
	public List<String> consultarItemsPorModulo(String modulo) {
		return autocompletadoLogic.consultarItemsPorModulo(modulo);
	}

	@Override
	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengosByTrabajador(Long Trabajador) throws Exception {
		return tarifaOtrosDevengosLogic.getDataTarifaOtrosDevengosByTrabajador(Trabajador);
	}

	@Override
	public List<TarifaDeduccionDTO> getDataTarifaDeduccionByTrabajador(Long Trabajador) throws Exception {
		return tarifaDeduccionLogic.getDataTarifaDeduccionByTrabajador(Trabajador);
	}

	@Override
	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDetByNomina(Long planillaNominaId) throws Exception {
		return datPlanillaNominaDetLogic.getDataDatPlanillaNominaDetByNomina(planillaNominaId);

	}

	@Override
	public List<DatServicioDetDTO> getDataDatServicioDetByServicio(Long datServicioId) throws Exception {
		return datServicioDetLogic.getDataDatServicioDetByServicio(datServicioId);

	}

	@Override
	public List<ItemsMenu> getItemsMenu() throws Exception {
		return itemsMenuLogic.getItemsMenu();
	}

	@Override
	public void saveItemsMenu(ItemsMenu entity) throws Exception {
		itemsMenuLogic.saveItemsMenu(entity);
	}

	@Override
	public void deleteItemsMenu(ItemsMenu entity) throws Exception {
		itemsMenuLogic.deleteItemsMenu(entity);
	}

	@Override
	public void updateItemsMenu(ItemsMenu entity) throws Exception {
		itemsMenuLogic.updateItemsMenu(entity);
	}

	@Override
	public ItemsMenu getItemsMenu(Long id) throws Exception {
		ItemsMenu itemsMenu = null;

		try {
			itemsMenu = itemsMenuLogic.getItemsMenu(id);
		} catch (Exception e) {
			throw e;
		}

		return itemsMenu;
	}

	@Override
	public List<ItemsMenu> findByCriteriaInItemsMenu(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return itemsMenuLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ItemsMenu> findPageItemsMenu(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return itemsMenuLogic.findPageItemsMenu(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberItemsMenu() throws Exception {
		return itemsMenuLogic.findTotalNumberItemsMenu();
	}

	@Override
	public List<ItemsMenuDTO> getDataItemsMenu() throws Exception {
		return itemsMenuLogic.getDataItemsMenu();
	}

	@Override
	public List<ItemsMenuDTO> getDataItemsMenuGlosario(String modulo) throws Exception {
		return itemsMenuLogic.getDataItemsMenuGlosario(modulo);
	}

	/**** Consulta a DTO de transaccionales ***/
	@Override
	public List<ConsultaDatPlanLaborDTO> consultaDatPlanLabor() throws Exception {
		return informesLogic.consultaDatPlanLabor();
	}

	@Override
	public List<CronogramaLabores> getCronogramaLabores() throws Exception {
		return cronogramaLaboresLogic.getCronogramaLabores();
	}

	@Override
	public void saveCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception {
		cronogramaLaboresLogic.saveCronogramaLabores(entity, dataCronogramaLaboresLabores, dataCronogramaLaboresNivel4);
	}

	@Override
	public void deleteCronogramaLabores(CronogramaLabores entity) throws Exception {
		cronogramaLaboresLogic.deleteCronogramaLabores(entity);
	}

	@Override
	public void updateCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception {
		cronogramaLaboresLogic.updateCronogramaLabores(entity, dataCronogramaLaboresLabores,
				dataCronogramaLaboresNivel4);
	}

	@Override
	public CronogramaLabores getCronogramaLabores(Long cronogramaLaboresId) throws Exception {
		CronogramaLabores cronogramaLabores = null;

		try {
			cronogramaLabores = cronogramaLaboresLogic.getCronogramaLabores(cronogramaLaboresId);
		} catch (Exception e) {
			throw e;
		}

		return cronogramaLabores;
	}

	@Override
	public List<CronogramaLabores> findByCriteriaInCronogramaLabores(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return cronogramaLaboresLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CronogramaLabores> findPageCronogramaLabores(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return cronogramaLaboresLogic.findPageCronogramaLabores(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberCronogramaLabores() throws Exception {
		return cronogramaLaboresLogic.findTotalNumberCronogramaLabores();
	}

	@Override
	public List<CronogramaLaboresDTO> getDataCronogramaLabores() throws Exception {
		return cronogramaLaboresLogic.getDataCronogramaLabores();
	}

	@Override
	public List<CronogramaLaboresLabores> getCronogramaLaboresLabores() throws Exception {
		return cronogramaLaboresLaboresLogic.getCronogramaLaboresLabores();
	}

	@Override
	public void saveCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception {
		cronogramaLaboresLaboresLogic.saveCronogramaLaboresLabores(entity);
	}

	@Override
	public void deleteCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception {
		cronogramaLaboresLaboresLogic.deleteCronogramaLaboresLabores(entity);
	}

	@Override
	public void updateCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception {
		cronogramaLaboresLaboresLogic.updateCronogramaLaboresLabores(entity);
	}

	@Override
	public CronogramaLaboresLabores getCronogramaLaboresLabores(Long cronogramaLaboresLaboresId) throws Exception {
		CronogramaLaboresLabores cronogramaLaboresLabores = null;

		try {
			cronogramaLaboresLabores = cronogramaLaboresLaboresLogic
					.getCronogramaLaboresLabores(cronogramaLaboresLaboresId);
		} catch (Exception e) {
			throw e;
		}

		return cronogramaLaboresLabores;
	}

	@Override
	public List<CronogramaLaboresLabores> findByCriteriaInCronogramaLaboresLabores(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return cronogramaLaboresLaboresLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CronogramaLaboresLabores> findPageCronogramaLaboresLabores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return cronogramaLaboresLaboresLogic.findPageCronogramaLaboresLabores(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberCronogramaLaboresLabores() throws Exception {
		return cronogramaLaboresLaboresLogic.findTotalNumberCronogramaLaboresLabores();
	}

	@Override
	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLabores() throws Exception {
		return cronogramaLaboresLaboresLogic.getDataCronogramaLaboresLabores();
	}

	@Override
	public List<CronogramaLaboresNivel4> getCronogramaLaboresNivel4() throws Exception {
		return cronogramaLaboresNivel4Logic.getCronogramaLaboresNivel4();
	}

	@Override
	public void saveCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception {
		cronogramaLaboresNivel4Logic.saveCronogramaLaboresNivel4(entity);
	}

	@Override
	public void deleteCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception {
		cronogramaLaboresNivel4Logic.deleteCronogramaLaboresNivel4(entity);
	}

	@Override
	public void updateCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception {
		cronogramaLaboresNivel4Logic.updateCronogramaLaboresNivel4(entity);
	}

	@Override
	public CronogramaLaboresNivel4 getCronogramaLaboresNivel4(Long cronogramaLaboresNivel4Id) throws Exception {
		CronogramaLaboresNivel4 cronogramaLaboresNivel4 = null;

		try {
			cronogramaLaboresNivel4 = cronogramaLaboresNivel4Logic
					.getCronogramaLaboresNivel4(cronogramaLaboresNivel4Id);
		} catch (Exception e) {
			throw e;
		}

		return cronogramaLaboresNivel4;
	}

	@Override
	public List<CronogramaLaboresNivel4> findByCriteriaInCronogramaLaboresNivel4(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return cronogramaLaboresNivel4Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CronogramaLaboresNivel4> findPageCronogramaLaboresNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return cronogramaLaboresNivel4Logic.findPageCronogramaLaboresNivel4(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberCronogramaLaboresNivel4() throws Exception {
		return cronogramaLaboresNivel4Logic.findTotalNumberCronogramaLaboresNivel4();
	}

	@Override
	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4() throws Exception {
		return cronogramaLaboresNivel4Logic.getDataCronogramaLaboresNivel4();
	}

	@Override
	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLaboresByCronograma(Long cronogramaLaboresId)
			throws Exception {
		return cronogramaLaboresLaboresLogic.getDataCronogramaLaboresLaboresByCronograma(cronogramaLaboresId);

	}

	@Override
	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4ByCronograma(Long cronogramaLaboresId)
			throws Exception {
		return cronogramaLaboresNivel4Logic.getDataCronogramaLaboresNivel4ByCronograma(cronogramaLaboresId);

	}

	@Override
	public List<AgenteCausadorParada> getAgenteCausadorParada() throws Exception {
		return agenteCausadorParadaLogic.getAgenteCausadorParada();
	}

	@Override
	public void saveAgenteCausadorParada(AgenteCausadorParada entity) throws Exception {
		agenteCausadorParadaLogic.saveAgenteCausadorParada(entity);
	}

	@Override
	public void deleteAgenteCausadorParada(AgenteCausadorParada entity) throws Exception {
		agenteCausadorParadaLogic.deleteAgenteCausadorParada(entity);
	}

	@Override
	public void updateAgenteCausadorParada(AgenteCausadorParada entity) throws Exception {
		agenteCausadorParadaLogic.updateAgenteCausadorParada(entity);
	}

	@Override
	public AgenteCausadorParada getAgenteCausadorParada(Long agenteCausadorParadaId) throws Exception {
		AgenteCausadorParada agenteCausadorParada = null;

		try {
			agenteCausadorParada = agenteCausadorParadaLogic.getAgenteCausadorParada(agenteCausadorParadaId);
		} catch (Exception e) {
			throw e;
		}

		return agenteCausadorParada;
	}

	@Override
	public List<AgenteCausadorParada> findByCriteriaInAgenteCausadorParada(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return agenteCausadorParadaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<AgenteCausadorParada> findPageAgenteCausadorParada(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return agenteCausadorParadaLogic.findPageAgenteCausadorParada(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberAgenteCausadorParada() throws Exception {
		return agenteCausadorParadaLogic.findTotalNumberAgenteCausadorParada();
	}

	@Override
	public List<AgenteCausadorParadaDTO> getDataAgenteCausadorParada() throws Exception {
		return agenteCausadorParadaLogic.getDataAgenteCausadorParada();
	}

	@Override
	public List<BombaAbastecimiento> getBombaAbastecimiento() throws Exception {
		return bombaAbastecimientoLogic.getBombaAbastecimiento();
	}

	@Override
	public void saveBombaAbastecimiento(BombaAbastecimiento entity) throws Exception {
		bombaAbastecimientoLogic.saveBombaAbastecimiento(entity);
	}

	@Override
	public void deleteBombaAbastecimiento(BombaAbastecimiento entity) throws Exception {
		bombaAbastecimientoLogic.deleteBombaAbastecimiento(entity);
	}

	@Override
	public void updateBombaAbastecimiento(BombaAbastecimiento entity) throws Exception {
		bombaAbastecimientoLogic.updateBombaAbastecimiento(entity);
	}

	@Override
	public BombaAbastecimiento getBombaAbastecimiento(Long bombaAbastecimientoId) throws Exception {
		BombaAbastecimiento bombaAbastecimiento = null;

		try {
			bombaAbastecimiento = bombaAbastecimientoLogic.getBombaAbastecimiento(bombaAbastecimientoId);
		} catch (Exception e) {
			throw e;
		}

		return bombaAbastecimiento;
	}

	@Override
	public List<BombaAbastecimiento> findByCriteriaInBombaAbastecimiento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return bombaAbastecimientoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<BombaAbastecimiento> findPageBombaAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return bombaAbastecimientoLogic.findPageBombaAbastecimiento(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberBombaAbastecimiento() throws Exception {
		return bombaAbastecimientoLogic.findTotalNumberBombaAbastecimiento();
	}

	@Override
	public List<BombaAbastecimientoDTO> getDataBombaAbastecimiento() throws Exception {
		return bombaAbastecimientoLogic.getDataBombaAbastecimiento();
	}

	@Override
	public List<DatAbastCombustible> getDatAbastCombustible() throws Exception {
		return datAbastCombustibleLogic.getDatAbastCombustible();
	}

	@Override
	public void saveDatAbastCombustible(DatAbastCombustible entity) throws Exception {
		datAbastCombustibleLogic.saveDatAbastCombustible(entity);
	}

	@Override
	public void deleteDatAbastCombustible(DatAbastCombustible entity) throws Exception {
		datAbastCombustibleLogic.deleteDatAbastCombustible(entity);
	}

	@Override
	public void updateDatAbastCombustible(DatAbastCombustible entity) throws Exception {
		datAbastCombustibleLogic.updateDatAbastCombustible(entity);
	}

	@Override
	public DatAbastCombustible getDatAbastCombustible(Long datAbastCombustibleId) throws Exception {
		DatAbastCombustible datAbastCombustible = null;

		try {
			datAbastCombustible = datAbastCombustibleLogic.getDatAbastCombustible(datAbastCombustibleId);
		} catch (Exception e) {
			throw e;
		}

		return datAbastCombustible;
	}

	@Override
	public List<DatAbastCombustible> findByCriteriaInDatAbastCombustible(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datAbastCombustibleLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatAbastCombustible> findPageDatAbastCombustible(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datAbastCombustibleLogic.findPageDatAbastCombustible(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatAbastCombustible() throws Exception {
		return datAbastCombustibleLogic.findTotalNumberDatAbastCombustible();
	}

	@Override
	public List<DatAbastCombustibleDTO> getDataDatAbastCombustible() throws Exception {
		return datAbastCombustibleLogic.getDataDatAbastCombustible();
	}

	@Override
	public List<DatMantenimientoEquipo> getDatMantenimientoEquipo() throws Exception {
		return datMantenimientoEquipoLogic.getDatMantenimientoEquipo();
	}

	@Override
	public void saveDatMantenimientoEquipo(DatMantenimientoEquipo entity, List<DatMantenimientoEquipoMecDTO> DataEquipoMec, 
			List<DatMantenimientoEquipoProdDTO> DataEquipoProd, List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision,
			DatHorasTrabajoEquipo entity_hrt) throws Exception {
		datMantenimientoEquipoLogic.saveDatMantenimientoEquipo(entity, DataEquipoMec, DataEquipoProd, dataPlanRevision, entity_hrt);
	}

	@Override
	public void deleteDatMantenimientoEquipo(DatMantenimientoEquipo entity) throws Exception {
		datMantenimientoEquipoLogic.deleteDatMantenimientoEquipo(entity);
	}

	@Override
	public void updateDatMantenimientoEquipo(DatMantenimientoEquipo entity, List<DatMantenimientoEquipoMecDTO> DataEquipoMec, 
			List<DatMantenimientoEquipoProdDTO> DataEquipoProd, List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision)
			throws Exception {
		datMantenimientoEquipoLogic.updateDatMantenimientoEquipo(entity, DataEquipoMec, DataEquipoProd, dataPlanRevision);
	}

	@Override
	public DatMantenimientoEquipo getDatMantenimientoEquipo(Long datMantenimientoEquipoId) throws Exception {
		DatMantenimientoEquipo datMantenimientoEquipo = null;

		try {
			datMantenimientoEquipo = datMantenimientoEquipoLogic.getDatMantenimientoEquipo(datMantenimientoEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return datMantenimientoEquipo;
	}

	@Override
	public List<DatMantenimientoEquipo> findByCriteriaInDatMantenimientoEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datMantenimientoEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatMantenimientoEquipo> findPageDatMantenimientoEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datMantenimientoEquipoLogic.findPageDatMantenimientoEquipo(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatMantenimientoEquipo() throws Exception {
		return datMantenimientoEquipoLogic.findTotalNumberDatMantenimientoEquipo();
	}

	@Override
	public List<DatMantenimientoEquipoDTO> getDataDatMantenimientoEquipo(String modulo) throws Exception {
		return datMantenimientoEquipoLogic.getDataDatMantenimientoEquipo(modulo);
	}

	@Override
	public List<DatMantenimientoEquipoMec> getDatMantenimientoEquipoMec() throws Exception {
		return datMantenimientoEquipoMecLogic.getDatMantenimientoEquipoMec();
	}

	@Override
	public void saveDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception {
		datMantenimientoEquipoMecLogic.saveDatMantenimientoEquipoMec(entity);
	}

	@Override
	public void deleteDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception {
		datMantenimientoEquipoMecLogic.deleteDatMantenimientoEquipoMec(entity);
	}

	@Override
	public void updateDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception {
		datMantenimientoEquipoMecLogic.updateDatMantenimientoEquipoMec(entity);
	}

	@Override
	public DatMantenimientoEquipoMec getDatMantenimientoEquipoMec(Long datMantenimientoEquipoMecId) throws Exception {
		DatMantenimientoEquipoMec datMantenimientoEquipoMec = null;

		try {
			datMantenimientoEquipoMec = datMantenimientoEquipoMecLogic
					.getDatMantenimientoEquipoMec(datMantenimientoEquipoMecId);
		} catch (Exception e) {
			throw e;
		}

		return datMantenimientoEquipoMec;
	}

	@Override
	public List<DatMantenimientoEquipoMec> findByCriteriaInDatMantenimientoEquipoMec(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datMantenimientoEquipoMecLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatMantenimientoEquipoMec> findPageDatMantenimientoEquipoMec(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datMantenimientoEquipoMecLogic.findPageDatMantenimientoEquipoMec(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatMantenimientoEquipoMec() throws Exception {
		return datMantenimientoEquipoMecLogic.findTotalNumberDatMantenimientoEquipoMec();
	}

	@Override
	public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMec() throws Exception {
		return datMantenimientoEquipoMecLogic.getDataDatMantenimientoEquipoMec();
	}

	@Override
	public List<DatMantenimientoEquipoProd> getDatMantenimientoEquipoProd() throws Exception {
		return datMantenimientoEquipoProdLogic.getDatMantenimientoEquipoProd();
	}

	@Override
	public void saveDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception {
		datMantenimientoEquipoProdLogic.saveDatMantenimientoEquipoProd(entity);
	}

	@Override
	public void deleteDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception {
		datMantenimientoEquipoProdLogic.deleteDatMantenimientoEquipoProd(entity);
	}

	@Override
	public void updateDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception {
		datMantenimientoEquipoProdLogic.updateDatMantenimientoEquipoProd(entity);
	}

	@Override
	public DatMantenimientoEquipoProd getDatMantenimientoEquipoProd(Long datMantenimientoEquipoProdId)
			throws Exception {
		DatMantenimientoEquipoProd datMantenimientoEquipoProd = null;

		try {
			datMantenimientoEquipoProd = datMantenimientoEquipoProdLogic
					.getDatMantenimientoEquipoProd(datMantenimientoEquipoProdId);
		} catch (Exception e) {
			throw e;
		}

		return datMantenimientoEquipoProd;
	}

	@Override
	public List<DatMantenimientoEquipoProd> findByCriteriaInDatMantenimientoEquipoProd(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datMantenimientoEquipoProdLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatMantenimientoEquipoProd> findPageDatMantenimientoEquipoProd(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datMantenimientoEquipoProdLogic.findPageDatMantenimientoEquipoProd(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatMantenimientoEquipoProd() throws Exception {
		return datMantenimientoEquipoProdLogic.findTotalNumberDatMantenimientoEquipoProd();
	}

	@Override
	public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProd() throws Exception {
		return datMantenimientoEquipoProdLogic.getDataDatMantenimientoEquipoProd();
	}

	@Override
	public List<MotivosEntradaTaller> getMotivosEntradaTaller() throws Exception {
		return motivosEntradaTallerLogic.getMotivosEntradaTaller();
	}

	@Override
	public void saveMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception {
		motivosEntradaTallerLogic.saveMotivosEntradaTaller(entity);
	}

	@Override
	public void deleteMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception {
		motivosEntradaTallerLogic.deleteMotivosEntradaTaller(entity);
	}

	@Override
	public void updateMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception {
		motivosEntradaTallerLogic.updateMotivosEntradaTaller(entity);
	}

	@Override
	public MotivosEntradaTaller getMotivosEntradaTaller(Long motivosEntradaTallerId) throws Exception {
		MotivosEntradaTaller motivosEntradaTaller = null;

		try {
			motivosEntradaTaller = motivosEntradaTallerLogic.getMotivosEntradaTaller(motivosEntradaTallerId);
		} catch (Exception e) {
			throw e;
		}

		return motivosEntradaTaller;
	}

	@Override
	public List<MotivosEntradaTaller> findByCriteriaInMotivosEntradaTaller(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return motivosEntradaTallerLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<MotivosEntradaTaller> findPageMotivosEntradaTaller(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return motivosEntradaTallerLogic.findPageMotivosEntradaTaller(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberMotivosEntradaTaller() throws Exception {
		return motivosEntradaTallerLogic.findTotalNumberMotivosEntradaTaller();
	}

	@Override
	public List<MotivosEntradaTallerDTO> getDataMotivosEntradaTaller() throws Exception {
		return motivosEntradaTallerLogic.getDataMotivosEntradaTaller();
	}

	@Override
	public List<PlanRevisionEquipo> getPlanRevisionEquipo() throws Exception {
		return planRevisionEquipoLogic.getPlanRevisionEquipo();
	}

	@Override
	public void savePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad, List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception {
		planRevisionEquipoLogic.savePlanRevisionEquipo(entity, dataDetEquipo, dataDetActividad, dataRecursos,
				dataPlanRevisionProd);
	}

	@Override
	public void deletePlanRevisionEquipo(PlanRevisionEquipo entity) throws Exception {
		planRevisionEquipoLogic.deletePlanRevisionEquipo(entity);
	}

	@Override
	public void updatePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad, List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception {
		planRevisionEquipoLogic.updatePlanRevisionEquipo(entity, dataDetEquipo, dataDetActividad, dataRecursos,
				dataPlanRevisionProd);
	}

	@Override
	public PlanRevisionEquipo getPlanRevisionEquipo(Long planRevisionEquipoId) throws Exception {
		PlanRevisionEquipo planRevisionEquipo = null;

		try {
			planRevisionEquipo = planRevisionEquipoLogic.getPlanRevisionEquipo(planRevisionEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return planRevisionEquipo;
	}

	@Override
	public List<PlanRevisionEquipo> findByCriteriaInPlanRevisionEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return planRevisionEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<PlanRevisionEquipo> findPagePlanRevisionEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return planRevisionEquipoLogic.findPagePlanRevisionEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberPlanRevisionEquipo() throws Exception {
		return planRevisionEquipoLogic.findTotalNumberPlanRevisionEquipo();
	}

	@Override
	public List<PlanRevisionEquipoDTO> getDataPlanRevisionEquipo(String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception {
		return planRevisionEquipoLogic.getDataPlanRevisionEquipo(modulo, flagPlanRevision, planSeleccionados);
	}

	@Override
	public List<PlanRevisionEquipoActiv> getPlanRevisionEquipoActiv() throws Exception {
		return planRevisionEquipoActivLogic.getPlanRevisionEquipoActiv();
	}

	@Override
	public void savePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception {
		planRevisionEquipoActivLogic.savePlanRevisionEquipoActiv(entity);
	}

	@Override
	public void deletePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception {
		planRevisionEquipoActivLogic.deletePlanRevisionEquipoActiv(entity);
	}

	@Override
	public void updatePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception {
		planRevisionEquipoActivLogic.updatePlanRevisionEquipoActiv(entity);
	}

	@Override
	public PlanRevisionEquipoActiv getPlanRevisionEquipoActiv(Long planRevisionEquipoActivId) throws Exception {
		PlanRevisionEquipoActiv planRevisionEquipoActiv = null;

		try {
			planRevisionEquipoActiv = planRevisionEquipoActivLogic
					.getPlanRevisionEquipoActiv(planRevisionEquipoActivId);
		} catch (Exception e) {
			throw e;
		}

		return planRevisionEquipoActiv;
	}

	@Override
	public List<PlanRevisionEquipoActiv> findByCriteriaInPlanRevisionEquipoActiv(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return planRevisionEquipoActivLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<PlanRevisionEquipoActiv> findPagePlanRevisionEquipoActiv(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return planRevisionEquipoActivLogic.findPagePlanRevisionEquipoActiv(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberPlanRevisionEquipoActiv() throws Exception {
		return planRevisionEquipoActivLogic.findTotalNumberPlanRevisionEquipoActiv();
	}

	@Override
	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionEquipoActiv() throws Exception {
		return planRevisionEquipoActivLogic.getDataPlanRevisionEquipoActiv();
	}

	@Override
	public List<PlanRevisionEquipoDet> getPlanRevisionEquipoDet() throws Exception {
		return planRevisionEquipoDetLogic.getPlanRevisionEquipoDet();
	}

	@Override
	public void savePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception {
		planRevisionEquipoDetLogic.savePlanRevisionEquipoDet(entity);
	}

	@Override
	public void deletePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception {
		planRevisionEquipoDetLogic.deletePlanRevisionEquipoDet(entity);
	}

	@Override
	public void updatePlanRevisionEquipoDet(PlanRevisionEquipoDet entity) throws Exception {
		planRevisionEquipoDetLogic.updatePlanRevisionEquipoDet(entity);
	}

	@Override
	public PlanRevisionEquipoDet getPlanRevisionEquipoDet(Long planRevisionEquipoDetId) throws Exception {
		PlanRevisionEquipoDet planRevisionEquipoDet = null;

		try {
			planRevisionEquipoDet = planRevisionEquipoDetLogic.getPlanRevisionEquipoDet(planRevisionEquipoDetId);
		} catch (Exception e) {
			throw e;
		}

		return planRevisionEquipoDet;
	}

	@Override
	public List<PlanRevisionEquipoDet> findByCriteriaInPlanRevisionEquipoDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return planRevisionEquipoDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<PlanRevisionEquipoDet> findPagePlanRevisionEquipoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return planRevisionEquipoDetLogic.findPagePlanRevisionEquipoDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberPlanRevisionEquipoDet() throws Exception {
		return planRevisionEquipoDetLogic.findTotalNumberPlanRevisionEquipoDet();
	}

	@Override
	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDet() throws Exception {
		return planRevisionEquipoDetLogic.getDataPlanRevisionEquipoDet();
	}

	@Override
	public List<TallerMecanico> getTallerMecanico() throws Exception {
		return tallerMecanicoLogic.getTallerMecanico();
	}

	@Override
	public void saveTallerMecanico(TallerMecanico entity) throws Exception {
		tallerMecanicoLogic.saveTallerMecanico(entity);
	}

	@Override
	public void deleteTallerMecanico(TallerMecanico entity) throws Exception {
		tallerMecanicoLogic.deleteTallerMecanico(entity);
	}

	@Override
	public void updateTallerMecanico(TallerMecanico entity) throws Exception {
		tallerMecanicoLogic.updateTallerMecanico(entity);
	}

	@Override
	public TallerMecanico getTallerMecanico(Long tallerMecanicoId) throws Exception {
		TallerMecanico tallerMecanico = null;

		try {
			tallerMecanico = tallerMecanicoLogic.getTallerMecanico(tallerMecanicoId);
		} catch (Exception e) {
			throw e;
		}

		return tallerMecanico;
	}

	@Override
	public List<TallerMecanico> findByCriteriaInTallerMecanico(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tallerMecanicoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TallerMecanico> findPageTallerMecanico(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tallerMecanicoLogic.findPageTallerMecanico(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTallerMecanico() throws Exception {
		return tallerMecanicoLogic.findTotalNumberTallerMecanico();
	}

	@Override
	public List<TallerMecanicoDTO> getDataTallerMecanico() throws Exception {
		return tallerMecanicoLogic.getDataTallerMecanico();
	}

	@Override
	public List<TipoAbastecimiento> getTipoAbastecimiento() throws Exception {
		return tipoAbastecimientoLogic.getTipoAbastecimiento();
	}

	@Override
	public void saveTipoAbastecimiento(TipoAbastecimiento entity) throws Exception {
		tipoAbastecimientoLogic.saveTipoAbastecimiento(entity);
	}

	@Override
	public void deleteTipoAbastecimiento(TipoAbastecimiento entity) throws Exception {
		tipoAbastecimientoLogic.deleteTipoAbastecimiento(entity);
	}

	@Override
	public void updateTipoAbastecimiento(TipoAbastecimiento entity) throws Exception {
		tipoAbastecimientoLogic.updateTipoAbastecimiento(entity);
	}

	@Override
	public TipoAbastecimiento getTipoAbastecimiento(Long tipoAbastecimientoId) throws Exception {
		TipoAbastecimiento tipoAbastecimiento = null;

		try {
			tipoAbastecimiento = tipoAbastecimientoLogic.getTipoAbastecimiento(tipoAbastecimientoId);
		} catch (Exception e) {
			throw e;
		}

		return tipoAbastecimiento;
	}

	@Override
	public List<TipoAbastecimiento> findByCriteriaInTipoAbastecimiento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoAbastecimientoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoAbastecimiento> findPageTipoAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tipoAbastecimientoLogic.findPageTipoAbastecimiento(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoAbastecimiento() throws Exception {
		return tipoAbastecimientoLogic.findTotalNumberTipoAbastecimiento();
	}

	@Override
	public List<TipoAbastecimientoDTO> getDataTipoAbastecimiento() throws Exception {
		return tipoAbastecimientoLogic.getDataTipoAbastecimiento();
	}

	@Override
	public List<TipoMantenimiento> getTipoMantenimiento() throws Exception {
		return tipoMantenimientoLogic.getTipoMantenimiento();
	}

	@Override
	public void saveTipoMantenimiento(TipoMantenimiento entity) throws Exception {
		tipoMantenimientoLogic.saveTipoMantenimiento(entity);
	}

	@Override
	public void deleteTipoMantenimiento(TipoMantenimiento entity) throws Exception {
		tipoMantenimientoLogic.deleteTipoMantenimiento(entity);
	}

	@Override
	public void updateTipoMantenimiento(TipoMantenimiento entity) throws Exception {
		tipoMantenimientoLogic.updateTipoMantenimiento(entity);
	}

	@Override
	public TipoMantenimiento getTipoMantenimiento(Long tipoMantenimientoId) throws Exception {
		TipoMantenimiento tipoMantenimiento = null;

		try {
			tipoMantenimiento = tipoMantenimientoLogic.getTipoMantenimiento(tipoMantenimientoId);
		} catch (Exception e) {
			throw e;
		}

		return tipoMantenimiento;
	}

	@Override
	public List<TipoMantenimiento> findByCriteriaInTipoMantenimiento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoMantenimientoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoMantenimiento> findPageTipoMantenimiento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoMantenimientoLogic.findPageTipoMantenimiento(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoMantenimiento() throws Exception {
		return tipoMantenimientoLogic.findTotalNumberTipoMantenimiento();
	}

	@Override
	public List<TipoMantenimientoDTO> getDataTipoMantenimiento() throws Exception {
		return tipoMantenimientoLogic.getDataTipoMantenimiento();
	}

	@Override
	public List<DatTransProdNivel4> getDatTransProdNivel4() throws Exception {
		return datTransProdNivel4Logic.getDatTransProdNivel4();
	}

	@Override
	public void saveDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception {
		datTransProdNivel4Logic.saveDatTransProdNivel4(entity);
	}

	@Override
	public void deleteDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception {
		datTransProdNivel4Logic.deleteDatTransProdNivel4(entity);
	}

	@Override
	public void updateDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception {
		datTransProdNivel4Logic.updateDatTransProdNivel4(entity);
	}

	@Override
	public DatTransProdNivel4 getDatTransProdNivel4(Long datTransProdNivel4Id) throws Exception {
		DatTransProdNivel4 datTransProdNivel4 = null;

		try {
			datTransProdNivel4 = datTransProdNivel4Logic.getDatTransProdNivel4(datTransProdNivel4Id);
		} catch (Exception e) {
			throw e;
		}

		return datTransProdNivel4;
	}

	@Override
	public List<DatTransProdNivel4> findByCriteriaInDatTransProdNivel4(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datTransProdNivel4Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatTransProdNivel4> findPageDatTransProdNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datTransProdNivel4Logic.findPageDatTransProdNivel4(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatTransProdNivel4() throws Exception {
		return datTransProdNivel4Logic.findTotalNumberDatTransProdNivel4();
	}

	@Override
	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4() throws Exception {
		return datTransProdNivel4Logic.getDataDatTransProdNivel4();
	}

	@Override
	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4ByNivel4Id(Long datTransProdId) throws Exception {
		return datTransProdNivel4Logic.getDataDatTransProdNivel4ByNivel4Id(datTransProdId);
	}

	@Override
	public List<ColorIdentProduccion> getColorIdentProduccion() throws Exception {
		return colorIdentProduccionLogic.getColorIdentProduccion();
	}

	@Override
	public void saveColorIdentProduccion(ColorIdentProduccion entity) throws Exception {
		colorIdentProduccionLogic.saveColorIdentProduccion(entity);
	}

	@Override
	public void deleteColorIdentProduccion(ColorIdentProduccion entity) throws Exception {
		colorIdentProduccionLogic.deleteColorIdentProduccion(entity);
	}

	@Override
	public void updateColorIdentProduccion(ColorIdentProduccion entity) throws Exception {
		colorIdentProduccionLogic.updateColorIdentProduccion(entity);
	}

	@Override
	public ColorIdentProduccion getColorIdentProduccion(Long colorIdentProdId) throws Exception {
		ColorIdentProduccion colorIdentProduccion = null;

		try {
			colorIdentProduccion = colorIdentProduccionLogic.getColorIdentProduccion(colorIdentProdId);
		} catch (Exception e) {
			throw e;
		}

		return colorIdentProduccion;
	}

	@Override
	public List<ColorIdentProduccion> findByCriteriaInColorIdentProduccion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return colorIdentProduccionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ColorIdentProduccion> findPageColorIdentProduccion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return colorIdentProduccionLogic.findPageColorIdentProduccion(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberColorIdentProduccion() throws Exception {
		return colorIdentProduccionLogic.findTotalNumberColorIdentProduccion();
	}

	@Override
	public List<ColorIdentProduccionDTO> getDataColorIdentProduccion() throws Exception {
		return colorIdentProduccionLogic.getDataColorIdentProduccion();
	}

	@Override
	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionEquipoActivByEquipo(Long planRevisionEquipoId)
			throws Exception {
		return planRevisionEquipoActivLogic.getDataPlanRevisionEquipoActivByEquipo(planRevisionEquipoId);
	}

	@Override
	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipo(Long planRevisionEquipoId)
			throws Exception {
		return planRevisionEquipoDetLogic.getDataPlanRevisionEquipoDetByEquipo(planRevisionEquipoId);

	}

	@Override
	public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProdByProd(Long datMantenimientoEquipoId)
			throws Exception {
		return datMantenimientoEquipoProdLogic.getDataDatMantenimientoEquipoProdByProd(datMantenimientoEquipoId);

	}

	@Override
	public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMecByMec(Long datMantenimientoEquipoId)
			throws Exception {
		return datMantenimientoEquipoMecLogic.getDataDatMantenimientoEquipoMecByMec(datMantenimientoEquipoId);

	}

	@Override
	public List<Nivel2Persempr> getNivel2Persempr() throws Exception {
		return nivel2PersemprLogic.getNivel2Persempr();
	}

	@Override
	public void saveNivel2Persempr(Nivel2Persempr entity) throws Exception {
		nivel2PersemprLogic.saveNivel2Persempr(entity);
	}

	@Override
	public void deleteNivel2Persempr(Nivel2Persempr entity) throws Exception {
		nivel2PersemprLogic.deleteNivel2Persempr(entity);
	}

	@Override
	public void updateNivel2Persempr(Nivel2Persempr entity) throws Exception {
		nivel2PersemprLogic.updateNivel2Persempr(entity);
	}

	@Override
	public Nivel2Persempr getNivel2Persempr(Long id) throws Exception {
		Nivel2Persempr nivel2Persempr = null;

		try {
			nivel2Persempr = nivel2PersemprLogic.getNivel2Persempr(id);
		} catch (Exception e) {
			throw e;
		}

		return nivel2Persempr;
	}

	@Override
	public List<Nivel2Persempr> findByCriteriaInNivel2Persempr(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel2PersemprLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Nivel2Persempr> findPageNivel2Persempr(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return nivel2PersemprLogic.findPageNivel2Persempr(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberNivel2Persempr() throws Exception {
		return nivel2PersemprLogic.findTotalNumberNivel2Persempr();
	}

	@Override
	public List<Nivel2PersemprDTO> getDataNivel2Persempr() throws Exception {
		return nivel2PersemprLogic.getDataNivel2Persempr();
	}

	@Override
	public List<Nivel2PersemprDTO> getDataNivel2PersemprById(Long id) throws Exception {
		return nivel2PersemprLogic.getDataNivel2PersemprById(id);
	}

	@Override
	public List<Semana> getSemana() throws Exception {
		return semanaLogic.getSemana();
	}

	@Override
	public void saveSemana(Semana entity) throws Exception {
		semanaLogic.saveSemana(entity);
	}

	@Override
	public void deleteSemana(Semana entity) throws Exception {
		semanaLogic.deleteSemana(entity);
	}

	@Override
	public void updateSemana(Semana entity) throws Exception {
		semanaLogic.updateSemana(entity);
	}

	@Override
	public Semana getSemana(Long semanaId) throws Exception {
		Semana semana = null;

		try {
			semana = semanaLogic.getSemana(semanaId);
		} catch (Exception e) {
			throw e;
		}

		return semana;
	}

	@Override
	public List<Semana> findByCriteriaInSemana(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return semanaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Semana> findPageSemana(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return semanaLogic.findPageSemana(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberSemana() throws Exception {
		return semanaLogic.findTotalNumberSemana();
	}

	@Override
	public List<SemanaDTO> getDataSemana() throws Exception {
		return semanaLogic.getDataSemana();
	}

	/**** interfaces ***/

	@Override
	public List<InterfaceNomina85DTO> consultarInterfaceNomina85(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception {
		return informesLogic.consultarInterfaceNomina85(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador,
				flagTrabajador);

	}

	/************************************/

	@Override
	public List<DatProgramaRiego> getDatProgramaRiego() throws Exception {
		return datProgramaRiegoLogic.getDatProgramaRiego();
	}

	@Override
	public void saveDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception {
		datProgramaRiegoLogic.saveDatProgramaRiego(entity, dataProgramaRiegoDet);
	}

	@Override
	public void deleteDatProgramaRiego(DatProgramaRiego entity) throws Exception {
		datProgramaRiegoLogic.deleteDatProgramaRiego(entity);
	}

	@Override
	public void updateDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception {
		datProgramaRiegoLogic.updateDatProgramaRiego(entity, dataProgramaRiegoDet);
	}

	@Override
	public DatProgramaRiego getDatProgramaRiego(Long datProgramaRiegoId) throws Exception {
		DatProgramaRiego datProgramaRiego = null;

		try {
			datProgramaRiego = datProgramaRiegoLogic.getDatProgramaRiego(datProgramaRiegoId);
		} catch (Exception e) {
			throw e;
		}

		return datProgramaRiego;
	}

	@Override
	public List<DatProgramaRiego> findByCriteriaInDatProgramaRiego(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datProgramaRiegoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatProgramaRiego> findPageDatProgramaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datProgramaRiegoLogic.findPageDatProgramaRiego(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatProgramaRiego() throws Exception {
		return datProgramaRiegoLogic.findTotalNumberDatProgramaRiego();
	}

	@Override
	public List<DatProgramaRiegoDTO> getDataDatProgramaRiego() throws Exception {
		return datProgramaRiegoLogic.getDataDatProgramaRiego();
	}

	@Override
	public List<DatProgramaRiegoDet> getDatProgramaRiegoDet() throws Exception {
		return datProgramaRiegoDetLogic.getDatProgramaRiegoDet();
	}

	@Override
	public void saveDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception {
		datProgramaRiegoDetLogic.saveDatProgramaRiegoDet(entity);
	}

	@Override
	public void deleteDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception {
		datProgramaRiegoDetLogic.deleteDatProgramaRiegoDet(entity);
	}

	@Override
	public void updateDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception {
		datProgramaRiegoDetLogic.updateDatProgramaRiegoDet(entity);
	}

	@Override
	public DatProgramaRiegoDet getDatProgramaRiegoDet(Long datProgramaRiegoDetId) throws Exception {
		DatProgramaRiegoDet datProgramaRiegoDet = null;

		try {
			datProgramaRiegoDet = datProgramaRiegoDetLogic.getDatProgramaRiegoDet(datProgramaRiegoDetId);
		} catch (Exception e) {
			throw e;
		}

		return datProgramaRiegoDet;
	}

	@Override
	public List<DatProgramaRiegoDet> findByCriteriaInDatProgramaRiegoDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datProgramaRiegoDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatProgramaRiegoDet> findPageDatProgramaRiegoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datProgramaRiegoDetLogic.findPageDatProgramaRiegoDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatProgramaRiegoDet() throws Exception {
		return datProgramaRiegoDetLogic.findTotalNumberDatProgramaRiegoDet();
	}

	@Override
	public List<DatProgramaRiegoDetDTO> getDataDatProgramaRiegoDet() throws Exception {
		return datProgramaRiegoDetLogic.getDataDatProgramaRiegoDet();
	}

	@Override
	public List<ProgramaSiembraCosecha> getProgramaSiembraCosecha() throws Exception {
		return programaSiembraCosechaLogic.getProgramaSiembraCosecha();
	}

	@Override
	public void saveProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception {
		programaSiembraCosechaLogic.saveProgramaSiembraCosecha(entity, dataProgramaDet);
	}

	@Override
	public void deleteProgramaSiembraCosecha(ProgramaSiembraCosecha entity) throws Exception {
		programaSiembraCosechaLogic.deleteProgramaSiembraCosecha(entity);
	}

	@Override
	public void updateProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception {
		programaSiembraCosechaLogic.updateProgramaSiembraCosecha(entity, dataProgramaDet);
	}

	@Override
	public ProgramaSiembraCosecha getProgramaSiembraCosecha(Long programaSiembraCosechaId) throws Exception {
		ProgramaSiembraCosecha programaSiembraCosecha = null;

		try {
			programaSiembraCosecha = programaSiembraCosechaLogic.getProgramaSiembraCosecha(programaSiembraCosechaId);
		} catch (Exception e) {
			throw e;
		}

		return programaSiembraCosecha;
	}

	@Override
	public List<ProgramaSiembraCosecha> findByCriteriaInProgramaSiembraCosecha(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return programaSiembraCosechaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ProgramaSiembraCosecha> findPageProgramaSiembraCosecha(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return programaSiembraCosechaLogic.findPageProgramaSiembraCosecha(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberProgramaSiembraCosecha() throws Exception {
		return programaSiembraCosechaLogic.findTotalNumberProgramaSiembraCosecha();
	}

	@Override
	public List<ProgramaSiembraCosechaDTO> getDataProgramaSiembraCosecha() throws Exception {
		return programaSiembraCosechaLogic.getDataProgramaSiembraCosecha();
	}

	@Override
	public List<ProgramaSiembraCosechaDet> getProgramaSiembraCosechaDet() throws Exception {
		return programaSiembraCosechaDetLogic.getProgramaSiembraCosechaDet();
	}

	@Override
	public void saveProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception {
		programaSiembraCosechaDetLogic.saveProgramaSiembraCosechaDet(entity);
	}

	@Override
	public void deleteProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception {
		programaSiembraCosechaDetLogic.deleteProgramaSiembraCosechaDet(entity);
	}

	@Override
	public void updateProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception {
		programaSiembraCosechaDetLogic.updateProgramaSiembraCosechaDet(entity);
	}

	@Override
	public ProgramaSiembraCosechaDet getProgramaSiembraCosechaDet(Long programaSiembraCosechaDetId) throws Exception {
		ProgramaSiembraCosechaDet programaSiembraCosechaDet = null;

		try {
			programaSiembraCosechaDet = programaSiembraCosechaDetLogic
					.getProgramaSiembraCosechaDet(programaSiembraCosechaDetId);
		} catch (Exception e) {
			throw e;
		}

		return programaSiembraCosechaDet;
	}

	@Override
	public List<ProgramaSiembraCosechaDet> findByCriteriaInProgramaSiembraCosechaDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return programaSiembraCosechaDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ProgramaSiembraCosechaDet> findPageProgramaSiembraCosechaDet(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return programaSiembraCosechaDetLogic.findPageProgramaSiembraCosechaDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberProgramaSiembraCosechaDet() throws Exception {
		return programaSiembraCosechaDetLogic.findTotalNumberProgramaSiembraCosechaDet();
	}

	@Override
	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDet() throws Exception {
		return programaSiembraCosechaDetLogic.getDataProgramaSiembraCosechaDet();
	}

	@Override
	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDetByPrograma(Long programaDetId)
			throws Exception {
		return programaSiembraCosechaDetLogic.getDataProgramaSiembraCosechaDetByPrograma(programaDetId);
	}

	@Override
	public List<DatProgramaRiegoDetDTO> getDataDatProgramaRiegoDetByPrograma(Long programRiegoDet) throws Exception {

		return datProgramaRiegoDetLogic.getDataDatProgramaRiegoDetByPrograma(programRiegoDet);

	}

	/**** ACTUALIZACION 29-01-2017 ****/

	@Override
	public List<DetalleInsumosMaquinariaDTO> consultaDetalleInsumosMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.consultaDetalleInsumosMaquinaria(compania, tipoProducto, flagTipoProducto, producto,
				flagProducto, almacen, flagAlmacen, fechaInicial, fechaFinal);

	}

	@Override
	public List<ConsultaStockMaquinariaDTO> consultaStockMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen)
			throws Exception {
		return informesLogic.consultaStockMaquinaria(compania, tipoProducto, flagTipoProducto, producto, flagProducto,
				almacen, flagAlmacen);
	}

	@Override
	public List<SolicitudesMttoEquipoDTO> consultarInformeSolciitudesMttoDet(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) throws Exception {
		return informesLogic.consultarInformeSolciitudesMttoDet(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo, tipoMtto, flagTipoMtto, idMtto);
	}

	@Override
	public List<ProgramaRiegosDTO> consultarInformeProgramaRiegos(Long compania, Long anio, Long mes, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String infraestructura, Long flagInfraestructura) throws Exception {
		return informesLogic.consultarInformeProgramaRiegos(compania, anio, mes, zona, flagZona, finca, flagFinca,
				bloque, flagBloque, lote, flagLote, infraestructura, flagInfraestructura);
	}

	@Override
	public List<ProductoresPorTecnicoDTO> consultarProductoresPorTecnico(Long compania, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception {
		return informesLogic.consultarProductoresPorTecnico(compania, contratista, flagContratista, trabajador,
				flagTrabajador);
	}

	@Override
	public List<ProgramacionSiembraCosechaDTO> consultarInformeProgramacionSiembraCosecha(Long compania,
			Long anioInicial, Long anioFinal, String productor, Long flagProductor, String variedad, Long flagVariedad,
			String supervisor, Long flagSupervisor) throws Exception {
		return informesLogic.consultarInformeProgramacionSiembraCosecha(compania, anioInicial, anioFinal, productor,
				flagProductor, variedad, flagVariedad, supervisor, flagSupervisor);
	}

	@Override
	public List<LineaBaseProductorDTO> consultarLineaBaseProductor(Long compania, String contratista,
			Long flagContratista) throws Exception {
		return informesLogic.consultarLineaBaseProductor(compania, contratista, flagContratista);
	}

	@Override
	public List<LineaBaseAsociacionDTO> consultarLineaBaseAsociacion(Long compania, String contratista,
			Long flagContratista) throws Exception {
		return informesLogic.consultarLineaBaseAsociacion(compania, contratista, flagContratista);
	}

	/*** actualizacion 01-02-2017 ***/
	@Override
	public long consultarConsecutivoProgramaSiembraCosecha(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoProgramaSiembraCosecha(compania);

	}

	@Override
	public List<ProduccionAcumFincaDTO> consultarProduccionLoteDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) throws Exception {
		return informesLogic.consultarProduccionLoteDetallado(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto, cliente, flagCliente);

	}

	@Override
	public List<Bascula> getBascula() throws Exception {
		return basculaLogic.getBascula();
	}

	@Override
	public void saveBascula(Bascula entity) throws Exception {
		basculaLogic.saveBascula(entity);
	}

	@Override
	public void deleteBascula(Bascula entity) throws Exception {
		basculaLogic.deleteBascula(entity);
	}

	@Override
	public void updateBascula(Bascula entity) throws Exception {
		basculaLogic.updateBascula(entity);
	}

	@Override
	public Bascula getBascula(Long basculaId) throws Exception {
		Bascula bascula = null;

		try {
			bascula = basculaLogic.getBascula(basculaId);
		} catch (Exception e) {
			throw e;
		}

		return bascula;
	}

	@Override
	public List<Bascula> findByCriteriaInBascula(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return basculaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Bascula> findPageBascula(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return basculaLogic.findPageBascula(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberBascula() throws Exception {
		return basculaLogic.findTotalNumberBascula();
	}

	@Override
	public List<BasculaDTO> getDataBascula() throws Exception {
		return basculaLogic.getDataBascula();
	}

	@Override
	public List<BasculaVehiculosPesarDTO> consultarBasculaPesar(Long compania) throws Exception {
		return informesLogic.consultarBasculaPesar(compania);

	}

	@Override
	public List<BasculaVehiculosTararDTO> consultarBasculaTarar(Long compania) throws Exception {
		return informesLogic.consultarBasculaTarar(compania);

	}

	/**** 09-02-2017 ***/

	@Override
	public long consultarConsecutivoProgramRiego(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoProgramRiego(compania);

	}

	/*** 10-02-2017**bascula **/
	@Override
	public List<TiquetesBasculaDTO> consultarTiqueteBascula(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo1, Long flagEquipo, String tiquete,
			Long flagTiquete, String estado1, Long flagEstado) throws Exception {
		return informesLogic.consultarTiqueteBascula(compania1, fechaInicial, fechaFinal, tipoTransaccion,
				flagTipoTransaccion, equipo1, flagEquipo, tiquete, flagTiquete, estado1, flagEstado);

	}

	@Override
	public List<TiquetesBasculaImprimirProdDTO> consultarTiqueteBasculaImprimirProd(Long compania1, Long tiquete)
			throws Exception {
		return informesLogic.consultarTiqueteBasculaImprimirProd(compania1, tiquete);

	}

	@Override
	public List<TiquetesBasculaImprimirDespachosDTO> consultarTiqueteBasculaImprimirDespachos(Long compania1,
			Long tiquete) throws Exception {
		return informesLogic.consultarTiqueteBasculaImprimirDespachos(compania1, tiquete);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaDespachosInformeDTO> consultarTiqueteBasculaDespachosInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String contratista, Long flagContratista) throws Exception {
		return informesLogic.consultarTiqueteBasculaDespachosInforme(compania1, fechaInicial, fechaFinal, equipo1,
				flagEquipo, tiquete, flagTiquete, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaProduccionInformeDTO> consultarTiqueteBasculaProduccionInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String contratista, Long flagContratista, String tipoFecha) throws Exception {
		return informesLogic.consultarTiqueteBasculaProduccionInforme(compania1, fechaInicial, fechaFinal, equipo1,
				flagEquipo, tiquete, flagTiquete, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote,
				contratista, flagContratista, tipoFecha);
	}

	/************* actualizacion 14-02-2017 ***/
	@Override
	public List<DatTransProdTrabajadores> getDatTransProdTrabajadores() throws Exception {
		return datTransProdTrabajadoresLogic.getDatTransProdTrabajadores();
	}

	@Override
	public void saveDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception {
		datTransProdTrabajadoresLogic.saveDatTransProdTrabajadores(entity);
	}

	@Override
	public void deleteDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception {
		datTransProdTrabajadoresLogic.deleteDatTransProdTrabajadores(entity);
	}

	@Override
	public void updateDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception {
		datTransProdTrabajadoresLogic.updateDatTransProdTrabajadores(entity);
	}

	@Override
	public DatTransProdTrabajadores getDatTransProdTrabajadores(Long datTransProdTrabajadoresId) throws Exception {
		DatTransProdTrabajadores datTransProdTrabajadores = null;

		try {
			datTransProdTrabajadores = datTransProdTrabajadoresLogic
					.getDatTransProdTrabajadores(datTransProdTrabajadoresId);
		} catch (Exception e) {
			throw e;
		}

		return datTransProdTrabajadores;
	}

	@Override
	public List<DatTransProdTrabajadores> findByCriteriaInDatTransProdTrabajadores(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datTransProdTrabajadoresLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatTransProdTrabajadores> findPageDatTransProdTrabajadores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datTransProdTrabajadoresLogic.findPageDatTransProdTrabajadores(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatTransProdTrabajadores() throws Exception {
		return datTransProdTrabajadoresLogic.findTotalNumberDatTransProdTrabajadores();
	}

	@Override
	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadores() throws Exception {
		return datTransProdTrabajadoresLogic.getDataDatTransProdTrabajadores();
	}

	/***** 27-02-2017 ***/

	@Override
	public List<DatNominaTrabajador> getDatNominaTrabajador() throws Exception {
		return datNominaTrabajadorLogic.getDatNominaTrabajador();
	}

	@Override
	public void saveDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception {
		datNominaTrabajadorLogic.saveDatNominaTrabajador(entity, dataNominaTrabajador);
	}

	@Override
	public void deleteDatNominaTrabajador(DatNominaTrabajador entity) throws Exception {
		datNominaTrabajadorLogic.deleteDatNominaTrabajador(entity);
	}

	@Override
	public void updateDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception {
		datNominaTrabajadorLogic.updateDatNominaTrabajador(entity, dataNominaTrabajador);
	}

	@Override
	public DatNominaTrabajador getDatNominaTrabajador(Long datNominaTrabajadorId) throws Exception {
		DatNominaTrabajador datNominaTrabajador = null;

		try {
			datNominaTrabajador = datNominaTrabajadorLogic.getDatNominaTrabajador(datNominaTrabajadorId);
		} catch (Exception e) {
			throw e;
		}

		return datNominaTrabajador;
	}

	@Override
	public List<DatNominaTrabajador> findByCriteriaInDatNominaTrabajador(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datNominaTrabajadorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatNominaTrabajador> findPageDatNominaTrabajador(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datNominaTrabajadorLogic.findPageDatNominaTrabajador(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatNominaTrabajador() throws Exception {
		return datNominaTrabajadorLogic.findTotalNumberDatNominaTrabajador();
	}

	@Override
	public List<DatNominaTrabajadorDTO> getDataDatNominaTrabajador() throws Exception {
		return datNominaTrabajadorLogic.getDataDatNominaTrabajador();
	}

	@Override
	public List<DatNominaTrabajadorDet> getDatNominaTrabajadorDet() throws Exception {
		return datNominaTrabajadorDetLogic.getDatNominaTrabajadorDet();
	}

	@Override
	public void saveDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception {
		datNominaTrabajadorDetLogic.saveDatNominaTrabajadorDet(entity);
	}

	@Override
	public void deleteDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception {
		datNominaTrabajadorDetLogic.deleteDatNominaTrabajadorDet(entity);
	}

	@Override
	public void updateDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception {
		datNominaTrabajadorDetLogic.updateDatNominaTrabajadorDet(entity);
	}

	@Override
	public DatNominaTrabajadorDet getDatNominaTrabajadorDet(Long datNominaTrabajadorDetId) throws Exception {
		DatNominaTrabajadorDet datNominaTrabajadorDet = null;

		try {
			datNominaTrabajadorDet = datNominaTrabajadorDetLogic.getDatNominaTrabajadorDet(datNominaTrabajadorDetId);
		} catch (Exception e) {
			throw e;
		}

		return datNominaTrabajadorDet;
	}

	@Override
	public List<DatNominaTrabajadorDet> findByCriteriaInDatNominaTrabajadorDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datNominaTrabajadorDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatNominaTrabajadorDet> findPageDatNominaTrabajadorDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datNominaTrabajadorDetLogic.findPageDatNominaTrabajadorDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatNominaTrabajadorDet() throws Exception {
		return datNominaTrabajadorDetLogic.findTotalNumberDatNominaTrabajadorDet();
	}

	@Override
	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDet() throws Exception {
		return datNominaTrabajadorDetLogic.getDataDatNominaTrabajadorDet();
	}

	@Override
	public List<DatOtrosCostos> getDatOtrosCostos() throws Exception {
		return datOtrosCostosLogic.getDatOtrosCostos();
	}

	@Override
	public void saveDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		datOtrosCostosLogic.saveDatOtrosCostos(entity, dataNivel4, dataDetalle);
	}

	@Override
	public void deleteDatOtrosCostos(DatOtrosCostos entity) throws Exception {
		datOtrosCostosLogic.deleteDatOtrosCostos(entity);
	}

	@Override
	public void updateDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		datOtrosCostosLogic.updateDatOtrosCostos(entity, dataNivel4, dataDetalle);
	}

	@Override
	public DatOtrosCostos getDatOtrosCostos(Long datOtrosCostosId) throws Exception {
		DatOtrosCostos datOtrosCostos = null;

		try {
			datOtrosCostos = datOtrosCostosLogic.getDatOtrosCostos(datOtrosCostosId);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosCostos;
	}

	@Override
	public List<DatOtrosCostos> findByCriteriaInDatOtrosCostos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datOtrosCostosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatOtrosCostos> findPageDatOtrosCostos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datOtrosCostosLogic.findPageDatOtrosCostos(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatOtrosCostos() throws Exception {
		return datOtrosCostosLogic.findTotalNumberDatOtrosCostos();
	}

	@Override
	public List<DatOtrosCostosDTO> getDataDatOtrosCostos() throws Exception {
		return datOtrosCostosLogic.getDataDatOtrosCostos();
	}

	@Override
	public List<DatOtrosCostosNivel4> getDatOtrosCostosNivel4() throws Exception {
		return datOtrosCostosNivel4Logic.getDatOtrosCostosNivel4();
	}

	@Override
	public void saveDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception {
		datOtrosCostosNivel4Logic.saveDatOtrosCostosNivel4(entity);
	}

	@Override
	public void deleteDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception {
		datOtrosCostosNivel4Logic.deleteDatOtrosCostosNivel4(entity);
	}

	@Override
	public void updateDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception {
		datOtrosCostosNivel4Logic.updateDatOtrosCostosNivel4(entity);
	}

	@Override
	public DatOtrosCostosNivel4 getDatOtrosCostosNivel4(Long datOtrosCostosNivel4Id) throws Exception {
		DatOtrosCostosNivel4 datOtrosCostosNivel4 = null;

		try {
			datOtrosCostosNivel4 = datOtrosCostosNivel4Logic.getDatOtrosCostosNivel4(datOtrosCostosNivel4Id);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosCostosNivel4;
	}

	@Override
	public List<DatOtrosCostosNivel4> findByCriteriaInDatOtrosCostosNivel4(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datOtrosCostosNivel4Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatOtrosCostosNivel4> findPageDatOtrosCostosNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datOtrosCostosNivel4Logic.findPageDatOtrosCostosNivel4(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatOtrosCostosNivel4() throws Exception {
		return datOtrosCostosNivel4Logic.findTotalNumberDatOtrosCostosNivel4();
	}

	@Override
	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4() throws Exception {
		return datOtrosCostosNivel4Logic.getDataDatOtrosCostosNivel4();
	}

	/******* Actualizaci+on 06-03-2017 ****/
	@Override
	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4ByNivel4(Long idOtrosCostos) throws Exception {
		return datOtrosCostosNivel4Logic.getDataDatOtrosCostosNivel4ByNivel4(idOtrosCostos);
	}

	@Override
	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDetByNomina(Long idNominaTrabajador)
			throws Exception {
		return datNominaTrabajadorDetLogic.getDataDatNominaTrabajadorDetByNomina(idNominaTrabajador);
	}

	/** 10-03-2017 ***/
	@Override
	public long consultarConsecutivoOtrosCostos(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoOtrosCostos(compania);
	}

	@Override
	public long consultarConsecutivoConsolidadoNomina(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoConsolidadoNomina(compania);
	}

	@Override
	public List<ConsolidadoNominaDTO> consultarConsolidadoNomina(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String contratista, Long flagContratista) throws Exception {
		return informesLogic.consultarConsolidadoNomina(compania, fechaInicial, fechaFinal, trabajador, flagTrabajador,
				contratista, flagContratista);
	}

	@Override
	public List<CostosIndirectosDTO> consultarCostosIndirectos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String labor, Long flagLabor, String hacienda, Long flagHacienda,
			String lote, Long flagLote, String ccontable, Long flagCcontable) throws Exception {
		return informesLogic.consultarCostosIndirectos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				labor, flagLabor, hacienda, flagHacienda, lote, flagLote, ccontable, flagCcontable);
	}

	/*** 16-03-2017 **/

	@Override
	public List<DatPlanLaborDet> getDatPlanLaborDet() throws Exception {
		return datPlanLaborDetLogic.getDatPlanLaborDet();
	}

	@Override
	public void saveDatPlanLaborDet(DatPlanLaborDet entity) throws Exception {
		datPlanLaborDetLogic.saveDatPlanLaborDet(entity);
	}

	@Override
	public void deleteDatPlanLaborDet(DatPlanLaborDet entity) throws Exception {
		datPlanLaborDetLogic.deleteDatPlanLaborDet(entity);
	}

	@Override
	public void updateDatPlanLaborDet(DatPlanLaborDet entity) throws Exception {
		datPlanLaborDetLogic.updateDatPlanLaborDet(entity);
	}

	@Override
	public DatPlanLaborDet getDatPlanLaborDet(Long planLaborDetId) throws Exception {
		DatPlanLaborDet datPlanLaborDet = null;

		try {
			datPlanLaborDet = datPlanLaborDetLogic.getDatPlanLaborDet(planLaborDetId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanLaborDet;
	}

	@Override
	public List<DatPlanLaborDet> findByCriteriaInDatPlanLaborDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datPlanLaborDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatPlanLaborDet> findPageDatPlanLaborDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datPlanLaborDetLogic.findPageDatPlanLaborDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatPlanLaborDet() throws Exception {
		return datPlanLaborDetLogic.findTotalNumberDatPlanLaborDet();
	}

	@Override
	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDet() throws Exception {
		return datPlanLaborDetLogic.getDataDatPlanLaborDet();
	}

	@Override
	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDetByPlan(Long planLaborId) throws Exception {
		return datPlanLaborDetLogic.getDataDatPlanLaborDetByPlan(planLaborId);
	}

	/** 18-03-2017 ***/
	@Override
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoEjecucionLabores(Long compania, Long ordenTrabajoDet)
			throws Exception {
		return informesLogic.consultarOrdenTrabajoEjecucionLabores(compania, ordenTrabajoDet);
	}

	@Override
	public List<TarifaInfraestructura> getTarifaInfraestructura() throws Exception {
		return tarifaInfraestructuraLogic.getTarifaInfraestructura();
	}

	@Override
	public void saveTarifaInfraestructura(TarifaInfraestructura entity) throws Exception {
		tarifaInfraestructuraLogic.saveTarifaInfraestructura(entity);
	}

	@Override
	public void deleteTarifaInfraestructura(TarifaInfraestructura entity) throws Exception {
		tarifaInfraestructuraLogic.deleteTarifaInfraestructura(entity);
	}

	@Override
	public void updateTarifaInfraestructura(TarifaInfraestructura entity) throws Exception {
		tarifaInfraestructuraLogic.updateTarifaInfraestructura(entity);
	}

	@Override
	public TarifaInfraestructura getTarifaInfraestructura(Long tarInfraId) throws Exception {
		TarifaInfraestructura tarifaInfraestructura = null;

		try {
			tarifaInfraestructura = tarifaInfraestructuraLogic.getTarifaInfraestructura(tarInfraId);
		} catch (Exception e) {
			throw e;
		}

		return tarifaInfraestructura;
	}

	@Override
	public List<TarifaInfraestructura> findByCriteriaInTarifaInfraestructura(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return tarifaInfraestructuraLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TarifaInfraestructura> findPageTarifaInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tarifaInfraestructuraLogic.findPageTarifaInfraestructura(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTarifaInfraestructura() throws Exception {
		return tarifaInfraestructuraLogic.findTotalNumberTarifaInfraestructura();
	}

	@Override
	public List<TarifaInfraestructuraDTO> getDataTarifaInfraestructura() throws Exception {
		return tarifaInfraestructuraLogic.getDataTarifaInfraestructura();
	}

	@Override
	public List<Eventos> getEventos() throws Exception {
		return eventosLogic.getEventos();
	}

	@Override
	public void saveEventos(Eventos entity) throws Exception {
		eventosLogic.saveEventos(entity);
	}

	@Override
	public void deleteEventos(Eventos entity) throws Exception {
		eventosLogic.deleteEventos(entity);
	}

	@Override
	public void updateEventos(Eventos entity) throws Exception {
		eventosLogic.updateEventos(entity);
	}

	@Override
	public Eventos getEventos(Long eventosId) throws Exception {
		Eventos eventos = null;

		try {
			eventos = eventosLogic.getEventos(eventosId);
		} catch (Exception e) {
			throw e;
		}

		return eventos;
	}

	@Override
	public List<Eventos> findByCriteriaInEventos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return eventosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Eventos> findPageEventos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return eventosLogic.findPageEventos(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEventos() throws Exception {
		return eventosLogic.findTotalNumberEventos();
	}

	@Override
	public List<EventosDTO> getDataEventos() throws Exception {
		return eventosLogic.getDataEventos();
	}

	@Override
	public List<EquipoEvento> getEquipoEvento() throws Exception {
		return equipoEventoLogic.getEquipoEvento();
	}

	@Override
	public void saveEquipoEvento(EquipoEvento entity) throws Exception {
		equipoEventoLogic.saveEquipoEvento(entity);
	}

	@Override
	public void deleteEquipoEvento(EquipoEvento entity) throws Exception {
		equipoEventoLogic.deleteEquipoEvento(entity);
	}

	@Override
	public void updateEquipoEvento(EquipoEvento entity) throws Exception {
		equipoEventoLogic.updateEquipoEvento(entity);
	}

	@Override
	public EquipoEvento getEquipoEvento(Long id) throws Exception {
		EquipoEvento equipoEvento = null;

		try {
			equipoEvento = equipoEventoLogic.getEquipoEvento(id);
		} catch (Exception e) {
			throw e;
		}

		return equipoEvento;
	}

	@Override
	public List<EquipoEvento> findByCriteriaInEquipoEvento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return equipoEventoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<EquipoEvento> findPageEquipoEvento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return equipoEventoLogic.findPageEquipoEvento(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberEquipoEvento() throws Exception {
		return equipoEventoLogic.findTotalNumberEquipoEvento();
	}

	@Override
	public List<EquipoEventoDTO> getDataEquipoEvento() throws Exception {
		return equipoEventoLogic.getDataEquipoEvento();
	}

	@Override
	public List<EquipoEventoDTO> getDataEquipoEventoByEquipoId(Long equipoId) throws Exception {
		return equipoEventoLogic.getDataEquipoEventoByEquipoId(equipoId);
	}

	@Override
	public List<EquipoEventoDTO> getDataEquipoEventoByEquipoIdCompaniaId(Long equipoId, Long compania)
			throws Exception {

		return equipoEventoLogic.getDataEquipoEventoByEquipoIdCompaniaId(equipoId, compania);
	}

	@Override
	public List<TarifaInfraestructuraDTO> getDataInfraestructuraByTarifaId(Long Id) throws Exception {
		return tarifaInfraestructuraLogic.getDataInfraestructuraByTarifaId(Id);
	}

	/*** ACTUALIZACION 27-05-2017 PRESUPUESTO ***/

	@Override
	public List<LaborRecursos> getLaborRecursos() throws Exception {
		return laborRecursosLogic.getLaborRecursos();
	}

	@Override
	public void saveLaborRecursos(LaborRecursos entity) throws Exception {
		laborRecursosLogic.saveLaborRecursos(entity);
	}

	@Override
	public void deleteLaborRecursos(LaborRecursos entity) throws Exception {
		laborRecursosLogic.deleteLaborRecursos(entity);
	}

	@Override
	public void updateLaborRecursos(LaborRecursos entity) throws Exception {
		laborRecursosLogic.updateLaborRecursos(entity);
	}

	@Override
	public LaborRecursos getLaborRecursos(Long laborRecursosId) throws Exception {
		LaborRecursos laborRecursos = null;

		try {
			laborRecursos = laborRecursosLogic.getLaborRecursos(laborRecursosId);
		} catch (Exception e) {
			throw e;
		}

		return laborRecursos;
	}

	@Override
	public List<LaborRecursos> findByCriteriaInLaborRecursos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return laborRecursosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<LaborRecursos> findPageLaborRecursos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return laborRecursosLogic.findPageLaborRecursos(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberLaborRecursos() throws Exception {
		return laborRecursosLogic.findTotalNumberLaborRecursos();
	}

	@Override
	public List<LaborRecursosDTO> getDataLaborRecursos() throws Exception {
		return laborRecursosLogic.getDataLaborRecursos();
	}

	@Override
	public List<TipoRecursosEquipos> getTipoRecursosEquipos() throws Exception {
		return tipoRecursosEquiposLogic.getTipoRecursosEquipos();
	}

	@Override
	public void saveTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception {
		tipoRecursosEquiposLogic.saveTipoRecursosEquipos(entity);
	}

	@Override
	public void deleteTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception {
		tipoRecursosEquiposLogic.deleteTipoRecursosEquipos(entity);
	}

	@Override
	public void updateTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception {
		tipoRecursosEquiposLogic.updateTipoRecursosEquipos(entity);
	}

	@Override
	public TipoRecursosEquipos getTipoRecursosEquipos(Long tipoRecursosEquiposId) throws Exception {
		TipoRecursosEquipos tipoRecursosEquipos = null;

		try {
			tipoRecursosEquipos = tipoRecursosEquiposLogic.getTipoRecursosEquipos(tipoRecursosEquiposId);
		} catch (Exception e) {
			throw e;
		}

		return tipoRecursosEquipos;
	}

	@Override
	public List<TipoRecursosEquipos> findByCriteriaInTipoRecursosEquipos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoRecursosEquiposLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoRecursosEquipos> findPageTipoRecursosEquipos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tipoRecursosEquiposLogic.findPageTipoRecursosEquipos(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTipoRecursosEquipos() throws Exception {
		return tipoRecursosEquiposLogic.findTotalNumberTipoRecursosEquipos();
	}

	@Override
	public List<TipoRecursosEquiposDTO> getDataTipoRecursosEquipos() throws Exception {
		return tipoRecursosEquiposLogic.getDataTipoRecursosEquipos();
	}

	@Override
	public List<TipoRecursosInsumos> getTipoRecursosInsumos() throws Exception {
		return tipoRecursosInsumosLogic.getTipoRecursosInsumos();
	}

	@Override
	public void saveTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception {
		tipoRecursosInsumosLogic.saveTipoRecursosInsumos(entity);
	}

	@Override
	public void deleteTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception {
		tipoRecursosInsumosLogic.deleteTipoRecursosInsumos(entity);
	}

	@Override
	public void updateTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception {
		tipoRecursosInsumosLogic.updateTipoRecursosInsumos(entity);
	}

	@Override
	public TipoRecursosInsumos getTipoRecursosInsumos(Long tipoRecursosInsumosId) throws Exception {
		TipoRecursosInsumos tipoRecursosInsumos = null;

		try {
			tipoRecursosInsumos = tipoRecursosInsumosLogic.getTipoRecursosInsumos(tipoRecursosInsumosId);
		} catch (Exception e) {
			throw e;
		}

		return tipoRecursosInsumos;
	}

	@Override
	public List<TipoRecursosInsumos> findByCriteriaInTipoRecursosInsumos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoRecursosInsumosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoRecursosInsumos> findPageTipoRecursosInsumos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tipoRecursosInsumosLogic.findPageTipoRecursosInsumos(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTipoRecursosInsumos() throws Exception {
		return tipoRecursosInsumosLogic.findTotalNumberTipoRecursosInsumos();
	}

	@Override
	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumos() throws Exception {
		return tipoRecursosInsumosLogic.getDataTipoRecursosInsumos();
	}

	@Override
	public List<TipoRecursosOtros> getTipoRecursosOtros() throws Exception {
		return tipoRecursosOtrosLogic.getTipoRecursosOtros();
	}

	@Override
	public void saveTipoRecursosOtros(TipoRecursosOtros entity) throws Exception {
		tipoRecursosOtrosLogic.saveTipoRecursosOtros(entity);
	}

	@Override
	public void deleteTipoRecursosOtros(TipoRecursosOtros entity) throws Exception {
		tipoRecursosOtrosLogic.deleteTipoRecursosOtros(entity);
	}

	@Override
	public void updateTipoRecursosOtros(TipoRecursosOtros entity) throws Exception {
		tipoRecursosOtrosLogic.updateTipoRecursosOtros(entity);
	}

	@Override
	public TipoRecursosOtros getTipoRecursosOtros(Long tipoRecursosOtrosId) throws Exception {
		TipoRecursosOtros tipoRecursosOtros = null;

		try {
			tipoRecursosOtros = tipoRecursosOtrosLogic.getTipoRecursosOtros(tipoRecursosOtrosId);
		} catch (Exception e) {
			throw e;
		}

		return tipoRecursosOtros;
	}

	@Override
	public List<TipoRecursosOtros> findByCriteriaInTipoRecursosOtros(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoRecursosOtrosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoRecursosOtros> findPageTipoRecursosOtros(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoRecursosOtrosLogic.findPageTipoRecursosOtros(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTipoRecursosOtros() throws Exception {
		return tipoRecursosOtrosLogic.findTotalNumberTipoRecursosOtros();
	}

	@Override
	public List<TipoRecursosOtrosDTO> getDataTipoRecursosOtros() throws Exception {
		return tipoRecursosOtrosLogic.getDataTipoRecursosOtros();
	}

	@Override
	public List<TipoRecursosProfesion> getTipoRecursosProfesion() throws Exception {
		return tipoRecursosProfesionLogic.getTipoRecursosProfesion();
	}

	@Override
	public void saveTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception {
		tipoRecursosProfesionLogic.saveTipoRecursosProfesion(entity);
	}

	@Override
	public void deleteTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception {
		tipoRecursosProfesionLogic.deleteTipoRecursosProfesion(entity);
	}

	@Override
	public void updateTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception {
		tipoRecursosProfesionLogic.updateTipoRecursosProfesion(entity);
	}

	@Override
	public TipoRecursosProfesion getTipoRecursosProfesion(Long tipoRecursosProfesionId) throws Exception {
		TipoRecursosProfesion tipoRecursosProfesion = null;

		try {
			tipoRecursosProfesion = tipoRecursosProfesionLogic.getTipoRecursosProfesion(tipoRecursosProfesionId);
		} catch (Exception e) {
			throw e;
		}

		return tipoRecursosProfesion;
	}

	@Override
	public List<TipoRecursosProfesion> findByCriteriaInTipoRecursosProfesion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return tipoRecursosProfesionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<TipoRecursosProfesion> findPageTipoRecursosProfesion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tipoRecursosProfesionLogic.findPageTipoRecursosProfesion(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberTipoRecursosProfesion() throws Exception {
		return tipoRecursosProfesionLogic.findTotalNumberTipoRecursosProfesion();
	}

	@Override
	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesion() throws Exception {
		return tipoRecursosProfesionLogic.getDataTipoRecursosProfesion();
	}

	@Override
	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesionByProfesion(Long tipoRecursosProfesionId)
			throws Exception {
		return tipoRecursosProfesionLogic.getDataTipoRecursosProfesionByProfesion(tipoRecursosProfesionId);
	}

	@Override
	public List<TipoRecursosEquiposDTO> getDataTipoRecursosEquiposByEquipos(Long tipoRecursosEquiposId)
			throws Exception {
		return tipoRecursosEquiposLogic.getDataTipoRecursosEquiposByEquipos(tipoRecursosEquiposId);
	}

	@Override
	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumosByInsumos(Long tipoRecursosInsumosId)
			throws Exception {
		return tipoRecursosInsumosLogic.getDataTipoRecursosInsumosByInsumos(tipoRecursosInsumosId);
	}

	@Override
	public List<TipoRecursosOtrosDTO> getDataTipoRecursosOtrosByOtros(Long tipoRecursosOtrosId) throws Exception {
		return tipoRecursosOtrosLogic.getDataTipoRecursosOtrosByOtros(tipoRecursosOtrosId);
	}

	@Override
	public List<LaborRecursosDTO> getDataLaborRecursosByLabor(Long laborRecursosId) throws Exception {
		return laborRecursosLogic.getDataLaborRecursosByLabor(laborRecursosId);
	}

	/** 02-06-2017 PRESUPUESTO **/

	@Override
	public List<ListadoRecursosDTO> consultaListadoRecursos(Long tipoRecursoId) throws Exception {
		return informesLogic.consultaListadoRecursos(tipoRecursoId);
	}

	/** 01-07_2017 **/
	@Override
	public List<ValorVarDTO> getDataValorVarByValor(Long datSanVegId) throws Exception {
		return valorVarLogic.getDataValorVarByValor(datSanVegId);
	}

	@Override
	public List<AnalisisEnfermedadVer2DTO> consultarAnalisisEnfermedadVer2(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception {
		return informesLogic.consultarAnalisisEnfermedadVer2(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, enfermedad, flagEnfermedad);
	}

	@Override
	public List<AnalisisPlagaVer2DTO> consultarAnalisisPlagaVer2(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String plaga, Long flagPlaga) throws Exception {
		return informesLogic.consultarAnalisisPlagaVer2(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, plaga, flagPlaga);
	}

	@Override
	public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipoId(Long equipoId) throws Exception {
		return planRevisionEquipoDetLogic.getDataPlanRevisionEquipoDetByEquipoId(equipoId);

	}

	@Override
	public List<Tag> getTag() throws Exception {
		return tagLogic.getTag();
	}

	@Override
	public void saveTag(Tag entity) throws Exception {
		tagLogic.saveTag(entity);
	}

	@Override
	public void deleteTag(Tag entity) throws Exception {
		tagLogic.deleteTag(entity);
	}

	@Override
	public void updateTag(Tag entity) throws Exception {
		tagLogic.updateTag(entity);
	}

	@Override
	public Tag getTag(Long tagId) throws Exception {
		Tag tag = null;

		try {
			tag = tagLogic.getTag(tagId);
		} catch (Exception e) {
			throw e;
		}

		return tag;
	}

	@Override
	public List<Tag> findByCriteriaInTag(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tagLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<Tag> findPageTag(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tagLogic.findPageTag(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberTag() throws Exception {
		return tagLogic.findTotalNumberTag();
	}

	@Override
	public List<TagDTO> getDataTag() throws Exception {
		return tagLogic.getDataTag();
	}

	@Override
	public List<ZonasFabrica> getZonasFabrica() throws Exception {
		return zonasFabricaLogic.getZonasFabrica();
	}

	@Override
	public void saveZonasFabrica(ZonasFabrica entity) throws Exception {
		zonasFabricaLogic.saveZonasFabrica(entity);
	}

	@Override
	public void deleteZonasFabrica(ZonasFabrica entity) throws Exception {
		zonasFabricaLogic.deleteZonasFabrica(entity);
	}

	@Override
	public void updateZonasFabrica(ZonasFabrica entity) throws Exception {
		zonasFabricaLogic.updateZonasFabrica(entity);
	}

	@Override
	public ZonasFabrica getZonasFabrica(Long zonasFabricaId) throws Exception {
		ZonasFabrica zonasFabrica = null;

		try {
			zonasFabrica = zonasFabricaLogic.getZonasFabrica(zonasFabricaId);
		} catch (Exception e) {
			throw e;
		}

		return zonasFabrica;
	}

	@Override
	public List<ZonasFabrica> findByCriteriaInZonasFabrica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return zonasFabricaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<ZonasFabrica> findPageZonasFabrica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return zonasFabricaLogic.findPageZonasFabrica(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberZonasFabrica() throws Exception {
		return zonasFabricaLogic.findTotalNumberZonasFabrica();
	}

	@Override
	public List<ZonasFabricaDTO> getDataZonasFabrica() throws Exception {
		return zonasFabricaLogic.getDataZonasFabrica();
	}

	@Override
	public List<DatOtrosCostosMq> getDatOtrosCostosMq() throws Exception {
		return datOtrosCostosMqLogic.getDatOtrosCostosMq();
	}

	@Override
	public void saveDatOtrosCostosMq(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr) throws Exception {
		datOtrosCostosMqLogic.saveDatOtrosCostosMq(entity, dataMqdet, dataDistr);
	}

	@Override
	public void deleteDatOtrosCostosMq(DatOtrosCostosMq entity) throws Exception {
		datOtrosCostosMqLogic.deleteDatOtrosCostosMq(entity);
	}

	@Override
	public void updateDatOtrosCostosMq(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr) throws Exception {
		datOtrosCostosMqLogic.updateDatOtrosCostosMq(entity, dataMqdet, dataDistr);
	}

	@Override
	public DatOtrosCostosMq getDatOtrosCostosMq(Long datOtrosCostosMqId) throws Exception {
		DatOtrosCostosMq datOtrosCostosMq = null;

		try {
			datOtrosCostosMq = datOtrosCostosMqLogic.getDatOtrosCostosMq(datOtrosCostosMqId);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosCostosMq;
	}

	@Override
	public List<DatOtrosCostosMq> findByCriteriaInDatOtrosCostosMq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datOtrosCostosMqLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatOtrosCostosMq> findPageDatOtrosCostosMq(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datOtrosCostosMqLogic.findPageDatOtrosCostosMq(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatOtrosCostosMq() throws Exception {
		return datOtrosCostosMqLogic.findTotalNumberDatOtrosCostosMq();
	}

	@Override
	public List<DatOtrosCostosMqDTO> getDataDatOtrosCostosMq() throws Exception {
		return datOtrosCostosMqLogic.getDataDatOtrosCostosMq();
	}

	@Override
	public List<DatOtrosCostosMqdet> getDatOtrosCostosMqdet() throws Exception {
		return datOtrosCostosMqdetLogic.getDatOtrosCostosMqdet();
	}

	@Override
	public void saveDatOtrosCostosMqdet(DatOtrosCostosMqdet entity) throws Exception {
		datOtrosCostosMqdetLogic.saveDatOtrosCostosMqdet(entity);
	}

	@Override
	public void deleteDatOtrosCostosMqdet(DatOtrosCostosMqdet entity) throws Exception {
		datOtrosCostosMqdetLogic.deleteDatOtrosCostosMqdet(entity);
	}

	@Override
	public void updateDatOtrosCostosMqdet(DatOtrosCostosMqdet entity) throws Exception {
		datOtrosCostosMqdetLogic.updateDatOtrosCostosMqdet(entity);
	}

	@Override
	public DatOtrosCostosMqdet getDatOtrosCostosMqdet(Long datOtrosCostosMqdetId) throws Exception {
		DatOtrosCostosMqdet datOtrosCostosMqdet = null;

		try {
			datOtrosCostosMqdet = datOtrosCostosMqdetLogic.getDatOtrosCostosMqdet(datOtrosCostosMqdetId);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosCostosMqdet;
	}

	@Override
	public List<DatOtrosCostosMqdet> findByCriteriaInDatOtrosCostosMqdet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datOtrosCostosMqdetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatOtrosCostosMqdet> findPageDatOtrosCostosMqdet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datOtrosCostosMqdetLogic.findPageDatOtrosCostosMqdet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatOtrosCostosMqdet() throws Exception {
		return datOtrosCostosMqdetLogic.findTotalNumberDatOtrosCostosMqdet();
	}

	@Override
	public List<DatOtrosCostosMqdetDTO> getDataDatOtrosCostosMqdet() throws Exception {
		return datOtrosCostosMqdetLogic.getDataDatOtrosCostosMqdet();
	}

	@Override
	public List<CostosInsumosDetalladoDTO> consultarInformeCostosInsumosDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, Long numPlanilla) throws Exception {
		return informesLogic.consultarInformeCostosInsumosDetallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, producto, flagProducto, numPlanilla);
	}

	@Override
	public List<DatOtrosCostosMqdetDTO> getDataDatOtrosCostosMqdetByMaquinaria(Long idOtrosCostosMq) throws Exception {
		return datOtrosCostosMqdetLogic.getDataDatOtrosCostosMqdetByMaquinaria(idOtrosCostosMq);
	}

	@Override
	public List<ConsultaEventosPorPagarDTO> consultarEventosPorPagar(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String propietario, Long flagPropietario, String evento, Long flagEvento)
			throws Exception {
		return informesLogic.consultarEventosPorPagar(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				propietario, flagPropietario, evento, flagEvento);
	}

	@Override
	public long consultarConsecutivoOtrosCostosMq(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoOtrosCostosMq(compania);
	}

	/**** 27-08-2017 modulo de maquinaria ***/

	@Override
	public List<DatHorasTrabajoEquipo> getDatHorasTrabajoEquipo() throws Exception {
		return datHorasTrabajoEquipoLogic.getDatHorasTrabajoEquipo();
	}

	@Override
	public void saveDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity) throws Exception {
		datHorasTrabajoEquipoLogic.saveDatHorasTrabajoEquipo(entity);
	}

	@Override
	public void deleteDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity) throws Exception {
		datHorasTrabajoEquipoLogic.deleteDatHorasTrabajoEquipo(entity);
	}

	@Override
	public void updateDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity) throws Exception {
		datHorasTrabajoEquipoLogic.updateDatHorasTrabajoEquipo(entity);
	}

	@Override
	public DatHorasTrabajoEquipo getDatHorasTrabajoEquipo(Long datHorasTrabajoEquipoId) throws Exception {
		DatHorasTrabajoEquipo datHorasTrabajoEquipo = null;

		try {
			datHorasTrabajoEquipo = datHorasTrabajoEquipoLogic.getDatHorasTrabajoEquipo(datHorasTrabajoEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return datHorasTrabajoEquipo;
	}

	@Override
	public List<DatHorasTrabajoEquipo> findByCriteriaInDatHorasTrabajoEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datHorasTrabajoEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatHorasTrabajoEquipo> findPageDatHorasTrabajoEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datHorasTrabajoEquipoLogic.findPageDatHorasTrabajoEquipo(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatHorasTrabajoEquipo() throws Exception {
		return datHorasTrabajoEquipoLogic.findTotalNumberDatHorasTrabajoEquipo();
	}

	@Override
	public List<DatHorasTrabajoEquipoDTO> getDataDatHorasTrabajoEquipo(String modulo) throws Exception {
		return datHorasTrabajoEquipoLogic.getDataDatHorasTrabajoEquipo(modulo);
	}

	@Override
	public List<DatRiegoDTO> getDataDatRiegoByPlanillaNomina(Long planillaNominaId) throws Exception {
		return datRiegoLogic.getDataDatRiegoByPlanillaNomina(planillaNominaId);
	}

	@Override
	public List<DatServicioDetDTO> getDataDatServicioDetByPlanillaNomina(Long planillaNominaId) throws Exception {
		return datServicioDetLogic.getDataDatServicioDetByPlanillaNomina(planillaNominaId);
	}

	@Override
	public List<DatAplicProdDetDTO> getDataDetProductosByPlanillaNomina(Long planillaNominaId) throws Exception {
		return datAplicProdDetLogic.getDataDetProductosByPlanillaNomina(planillaNominaId);
	}

	@Override
	public List<DatServRealizadosEquipo> getDatServRealizadosEquipo() throws Exception {
		return datServRealizadosEquipoLogic.getDatServRealizadosEquipo();
	}

	@Override
	public void saveDatServRealizadosEquipo(DatServRealizadosEquipo entity,
			List<DatServRealizadosEquipoDetDTO> dataServDet, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception {
		datServRealizadosEquipoLogic.saveDatServRealizadosEquipo(entity, dataServDet, dataDetPrecioProductos);
	}

	@Override
	public void deleteDatServRealizadosEquipo(DatServRealizadosEquipo entity) throws Exception {
		datServRealizadosEquipoLogic.deleteDatServRealizadosEquipo(entity);
	}

	@Override
	public void updateDatServRealizadosEquipo(DatServRealizadosEquipo entity,
			List<DatServRealizadosEquipoDetDTO> dataServDet, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception {
		datServRealizadosEquipoLogic.updateDatServRealizadosEquipo(entity, dataServDet, dataDetPrecioProductos);
	}

	@Override
	public DatServRealizadosEquipo getDatServRealizadosEquipo(Long datServRealizadosEquipoId) throws Exception {
		DatServRealizadosEquipo datServRealizadosEquipo = null;

		try {
			datServRealizadosEquipo = datServRealizadosEquipoLogic
					.getDatServRealizadosEquipo(datServRealizadosEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return datServRealizadosEquipo;
	}

	@Override
	public List<DatServRealizadosEquipo> findByCriteriaInDatServRealizadosEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datServRealizadosEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatServRealizadosEquipo> findPageDatServRealizadosEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datServRealizadosEquipoLogic.findPageDatServRealizadosEquipo(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatServRealizadosEquipo() throws Exception {
		return datServRealizadosEquipoLogic.findTotalNumberDatServRealizadosEquipo();
	}

	@Override
	public List<DatServRealizadosEquipoDTO> getDataDatServRealizadosEquipo() throws Exception {
		return datServRealizadosEquipoLogic.getDataDatServRealizadosEquipo();
	}

	@Override
	public List<DatServRealizadosEquipoDet> getDatServRealizadosEquipoDet() throws Exception {
		return datServRealizadosEquipoDetLogic.getDatServRealizadosEquipoDet();
	}

	@Override
	public void saveDatServRealizadosEquipoDet(DatServRealizadosEquipoDet entity) throws Exception {
		datServRealizadosEquipoDetLogic.saveDatServRealizadosEquipoDet(entity);
	}

	@Override
	public void deleteDatServRealizadosEquipoDet(DatServRealizadosEquipoDet entity) throws Exception {
		datServRealizadosEquipoDetLogic.deleteDatServRealizadosEquipoDet(entity);
	}

	@Override
	public void updateDatServRealizadosEquipoDet(DatServRealizadosEquipoDet entity) throws Exception {
		datServRealizadosEquipoDetLogic.updateDatServRealizadosEquipoDet(entity);
	}

	@Override
	public DatServRealizadosEquipoDet getDatServRealizadosEquipoDet(Long datServRealizadosEquipoDetId)
			throws Exception {
		DatServRealizadosEquipoDet datServRealizadosEquipoDet = null;

		try {
			datServRealizadosEquipoDet = datServRealizadosEquipoDetLogic
					.getDatServRealizadosEquipoDet(datServRealizadosEquipoDetId);
		} catch (Exception e) {
			throw e;
		}

		return datServRealizadosEquipoDet;
	}

	@Override
	public List<DatServRealizadosEquipoDet> findByCriteriaInDatServRealizadosEquipoDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datServRealizadosEquipoDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatServRealizadosEquipoDet> findPageDatServRealizadosEquipoDet(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datServRealizadosEquipoDetLogic.findPageDatServRealizadosEquipoDet(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatServRealizadosEquipoDet() throws Exception {
		return datServRealizadosEquipoDetLogic.findTotalNumberDatServRealizadosEquipoDet();
	}

	@Override
	public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDet() throws Exception {
		return datServRealizadosEquipoDetLogic.getDataDatServRealizadosEquipoDet();
	}

	@Override
	public List<CompartimientosEquipo> getCompartimientosEquipo() throws Exception {
		return compartimientosEquipoLogic.getCompartimientosEquipo();
	}

	@Override
	public void saveCompartimientosEquipo(CompartimientosEquipo entity) throws Exception {
		compartimientosEquipoLogic.saveCompartimientosEquipo(entity);
	}

	@Override
	public void deleteCompartimientosEquipo(CompartimientosEquipo entity) throws Exception {
		compartimientosEquipoLogic.deleteCompartimientosEquipo(entity);
	}

	@Override
	public void updateCompartimientosEquipo(CompartimientosEquipo entity) throws Exception {
		compartimientosEquipoLogic.updateCompartimientosEquipo(entity);
	}

	@Override
	public CompartimientosEquipo getCompartimientosEquipo(Long compartimientosEquipoId) throws Exception {
		CompartimientosEquipo compartimientosEquipo = null;

		try {
			compartimientosEquipo = compartimientosEquipoLogic.getCompartimientosEquipo(compartimientosEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return compartimientosEquipo;
	}

	@Override
	public List<CompartimientosEquipo> findByCriteriaInCompartimientosEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return compartimientosEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<CompartimientosEquipo> findPageCompartimientosEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return compartimientosEquipoLogic.findPageCompartimientosEquipo(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberCompartimientosEquipo() throws Exception {
		return compartimientosEquipoLogic.findTotalNumberCompartimientosEquipo();
	}

	@Override
	public List<CompartimientosEquipoDTO> getDataCompartimientosEquipo() throws Exception {
		return compartimientosEquipoLogic.getDataCompartimientosEquipo();
	}

	@Override
	public List<SistemasEquipo> getSistemasEquipo() throws Exception {
		return sistemasEquipoLogic.getSistemasEquipo();
	}

	@Override
	public void saveSistemasEquipo(SistemasEquipo entity) throws Exception {
		sistemasEquipoLogic.saveSistemasEquipo(entity);
	}

	@Override
	public void deleteSistemasEquipo(SistemasEquipo entity) throws Exception {
		sistemasEquipoLogic.deleteSistemasEquipo(entity);
	}

	@Override
	public void updateSistemasEquipo(SistemasEquipo entity) throws Exception {
		sistemasEquipoLogic.updateSistemasEquipo(entity);
	}

	@Override
	public SistemasEquipo getSistemasEquipo(Long sistemasEquipoId) throws Exception {
		SistemasEquipo sistemasEquipo = null;

		try {
			sistemasEquipo = sistemasEquipoLogic.getSistemasEquipo(sistemasEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return sistemasEquipo;
	}

	@Override
	public List<SistemasEquipo> findByCriteriaInSistemasEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return sistemasEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<SistemasEquipo> findPageSistemasEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return sistemasEquipoLogic.findPageSistemasEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberSistemasEquipo() throws Exception {
		return sistemasEquipoLogic.findTotalNumberSistemasEquipo();
	}

	@Override
	public List<SistemasEquipoDTO> getDataSistemasEquipo() throws Exception {
		return sistemasEquipoLogic.getDataSistemasEquipo();
	}

	@Override
	public List<DatReporteFallas> getDatReporteFallas() throws Exception {
		return datReporteFallasLogic.getDatReporteFallas();
	}

	@Override
	public void saveDatReporteFallas(DatReporteFallas entity) throws Exception {
		datReporteFallasLogic.saveDatReporteFallas(entity);
	}

	@Override
	public void deleteDatReporteFallas(DatReporteFallas entity) throws Exception {
		datReporteFallasLogic.deleteDatReporteFallas(entity);
	}

	@Override
	public void updateDatReporteFallas(DatReporteFallas entity) throws Exception {
		datReporteFallasLogic.updateDatReporteFallas(entity);
	}

	@Override
	public DatReporteFallas getDatReporteFallas(Long datReporteFallasId) throws Exception {
		DatReporteFallas datReporteFallas = null;

		try {
			datReporteFallas = datReporteFallasLogic.getDatReporteFallas(datReporteFallasId);
		} catch (Exception e) {
			throw e;
		}

		return datReporteFallas;
	}

	@Override
	public List<DatReporteFallas> findByCriteriaInDatReporteFallas(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datReporteFallasLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatReporteFallas> findPageDatReporteFallas(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datReporteFallasLogic.findPageDatReporteFallas(sortColumnName, sortAscending, startRow, maxResults);
	}

	@Override
	public Long findTotalNumberDatReporteFallas() throws Exception {
		return datReporteFallasLogic.findTotalNumberDatReporteFallas();
	}

	@Override
	public List<DatReporteFallasDTO> getDataDatReporteFallas(String modulo) throws Exception {
		return datReporteFallasLogic.getDataDatReporteFallas(modulo);
	}

	@Override
	public List<DatPlanAnualFabrica> getDatPlanAnualFabrica() throws Exception {
		return datPlanAnualFabricaLogic.getDatPlanAnualFabrica();
	}

	@Override
	public void saveDatPlanAnualFabrica(DatPlanAnualFabrica entity) throws Exception {
		datPlanAnualFabricaLogic.saveDatPlanAnualFabrica(entity);
	}

	@Override
	public void deleteDatPlanAnualFabrica(DatPlanAnualFabrica entity) throws Exception {
		datPlanAnualFabricaLogic.deleteDatPlanAnualFabrica(entity);
	}

	@Override
	public void updateDatPlanAnualFabrica(DatPlanAnualFabrica entity) throws Exception {
		datPlanAnualFabricaLogic.updateDatPlanAnualFabrica(entity);
	}

	@Override
	public DatPlanAnualFabrica getDatPlanAnualFabrica(Long datPlanAnualFabricaId) throws Exception {
		DatPlanAnualFabrica datPlanAnualFabrica = null;

		try {
			datPlanAnualFabrica = datPlanAnualFabricaLogic.getDatPlanAnualFabrica(datPlanAnualFabricaId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanAnualFabrica;
	}

	@Override
	public List<DatPlanAnualFabrica> findByCriteriaInDatPlanAnualFabrica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datPlanAnualFabricaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	@Override
	public List<DatPlanAnualFabrica> findPageDatPlanAnualFabrica(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datPlanAnualFabricaLogic.findPageDatPlanAnualFabrica(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	@Override
	public Long findTotalNumberDatPlanAnualFabrica() throws Exception {
		return datPlanAnualFabricaLogic.findTotalNumberDatPlanAnualFabrica();
	}

	@Override
	public List<DatPlanAnualFabricaDTO> getDataDatPlanAnualFabrica() throws Exception {
		return datPlanAnualFabricaLogic.getDataDatPlanAnualFabrica();
	}

	@Override
	public long consultarConsecutivoServRealizados(Long compania, Long equipoId) throws Exception {
		return informesLogic.consultarConsecutivoServRealizados(compania, equipoId);
	}

	@Override
	public long consultarConsecutivoRegistroHorasEquipo(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoRegistroHorasEquipo(compania);
	}

	@Override
	public long consultarConsecutivoPlanAnualFabrica(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoPlanAnualFabrica(compania);
	}

	@Override
	public long consultarConsecutivoCheckListEquipo(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoCheckListEquipo(compania);
	}

	@Override
	public long consultarConsecutivoReporteFallasEquipo(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoReporteFallasEquipo(compania);
	}

	@Override
	public List<CostosIndirectosEquipoDTO> consultarCostosIndirectosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String labor, Long flagLabor) throws Exception {
		return informesLogic.consultarCostosIndirectosMq(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, labor, flagLabor);
	}

	@Override
	public List<ProduccionLoteArcansasDTO> consultarProduccionLoteArcansas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote) throws Exception {
		return informesLogic.consultarProduccionLoteArcansas(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote);

	}

	/***** reportes de mtto de maquinaria ****/
	@Override
	public List<MttoReporteFallasEquipoDTO> consultarInformeReporteFallasEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.consultarInformeReporteFallasEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	public List<MttoHorasTrabajadasEquipoDTO> consultarInformeHorasTrabajoEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.consultarInformeHorasTrabajoEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	public List<MttoSalidaCombustibleEquipoDTO> consultarInformeSalidasCombustibleEquipo(Long compania,
			Date fechaInicial, Date fechaFinal, String propietario, Long flagPropietario, String equipo,
			Long flagEquipo) throws Exception {
		return informesLogic.consultarInformeSalidasCombustibleEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoPlanFabricaDTO> consultarInformePlanFabrica(Long compania, Long anioInicial, Long anioFinal)
			throws Exception {
		return informesLogic.consultarInformePlanFabrica(compania, anioInicial, anioFinal);
	}

	@Override
	public List<MttoCheckListEquipoDTO> consultarInformeCheckListEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.consultarInformeCheckListEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	public List<MttoProyeccionMttoDTO> consultarInformeProyeccionMtto(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String planRevision, Long flagPlanRevision) throws Exception {
		return informesLogic.consultarInformeProyeccionMtto(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				planRevision, flagPlanRevision);
	}

	/************************************/

	@Override
	public List<CalculoProxMttoDTO> consultarProximoMtto(Date fechaentrada, Long equipoid, Long planrevisionid,
			Double horasmtto, Double kmmtto) throws Exception {

		return informesLogic.consultarProximoMtto(fechaentrada, equipoid, planrevisionid, horasmtto, kmmtto);
	}

	@Override
	public BigDecimal consultarHorometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania)
			throws Exception {
		return informesLogic.consultarHorometroActual(idFecha, idEquipo, idMedidor, idCompania);
	}

	@Override
	public BigDecimal consultarOdometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania)
			throws Exception {
		return informesLogic.consultarOdometroActual(idFecha, idEquipo, idMedidor, idCompania);
	}

	@Override
	public List<ConsultaSolicitudesParaMttoDTO> consultaSolicitudesParaMtto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto, String solicitante,
			Long flagSolicitante, String nivelPrioridad, Long flagNivelPrioridad, String origenDatos) throws Exception {

		return informesLogic.consultaSolicitudesParaMtto(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				tipoMtto, flagTipoMtto, solicitante, flagSolicitante, nivelPrioridad, flagNivelPrioridad, origenDatos);

	}

	@Override
	public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDetByServ(Long datServId)
			throws Exception {
		return datServRealizadosEquipoDetLogic.getDataDatServRealizadosEquipoDetByServ(datServId);
	}

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquipos(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos) {

		return informesLogic.consultarListaProximosMttoEquipos(compania, equipo, flagEquipo, planRevision,
				flagPlanRevision, origenDatos);

	}

	@Override
	public List<HorasMaquinaDetalladoDTO> consultarServRealizadosEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.consultarServRealizadosEquipo(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, propietarioEquipo, flagPropietarioEquipo,
				modeloEquipo, flagModeloEquipo, equipo, flagEquipo);
	}

	@Override
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteExpress(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesLogic.consultarInformeProyeccionLaboresLoteExpress(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	public List<DatPlanillaNominaOnivel4> getDatPlanillaNominaOnivel4() throws Exception {
		return datPlanillaNominaOnivel4Logic.getDatPlanillaNominaOnivel4();
	}

	public void saveDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity) throws Exception {
		datPlanillaNominaOnivel4Logic.saveDatPlanillaNominaOnivel4(entity);
	}

	public void deleteDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity) throws Exception {
		datPlanillaNominaOnivel4Logic.deleteDatPlanillaNominaOnivel4(entity);
	}

	public void updateDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity) throws Exception {
		datPlanillaNominaOnivel4Logic.updateDatPlanillaNominaOnivel4(entity);
	}

	public DatPlanillaNominaOnivel4 getDatPlanillaNominaOnivel4(Long detPlanillaNominaOnivel4Id) throws Exception {
		DatPlanillaNominaOnivel4 datPlanillaNominaOnivel4 = null;

		try {
			datPlanillaNominaOnivel4 = datPlanillaNominaOnivel4Logic
					.getDatPlanillaNominaOnivel4(detPlanillaNominaOnivel4Id);
		} catch (Exception e) {
			throw e;
		}

		return datPlanillaNominaOnivel4;
	}

	public List<DatPlanillaNominaOnivel4> findByCriteriaInDatPlanillaNominaOnivel4(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datPlanillaNominaOnivel4Logic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatPlanillaNominaOnivel4> findPageDatPlanillaNominaOnivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datPlanillaNominaOnivel4Logic.findPageDatPlanillaNominaOnivel4(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatPlanillaNominaOnivel4() throws Exception {
		return datPlanillaNominaOnivel4Logic.findTotalNumberDatPlanillaNominaOnivel4();
	}

	public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4() throws Exception {
		return datPlanillaNominaOnivel4Logic.getDataDatPlanillaNominaOnivel4();
	}

	public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4ByNomina(Long planillaNominaId)
			throws Exception {
		return datPlanillaNominaOnivel4Logic.getDataDatPlanillaNominaOnivel4ByNomina(planillaNominaId);
	}

	public List<DatParadasFabrica> getDatParadasFabrica() throws Exception {
		return datParadasFabricaLogic.getDatParadasFabrica();
	}

	public void saveDatParadasFabrica(DatParadasFabrica entity) throws Exception {
		datParadasFabricaLogic.saveDatParadasFabrica(entity);
	}

	public void deleteDatParadasFabrica(DatParadasFabrica entity) throws Exception {
		datParadasFabricaLogic.deleteDatParadasFabrica(entity);
	}

	public void updateDatParadasFabrica(DatParadasFabrica entity) throws Exception {
		datParadasFabricaLogic.updateDatParadasFabrica(entity);
	}

	public DatParadasFabrica getDatParadasFabrica(Long datParadasFabricaId) throws Exception {
		DatParadasFabrica datParadasFabrica = null;

		try {
			datParadasFabrica = datParadasFabricaLogic.getDatParadasFabrica(datParadasFabricaId);
		} catch (Exception e) {
			throw e;
		}

		return datParadasFabrica;
	}

	public List<DatParadasFabrica> findByCriteriaInDatParadasFabrica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datParadasFabricaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatParadasFabrica> findPageDatParadasFabrica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datParadasFabricaLogic.findPageDatParadasFabrica(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatParadasFabrica() throws Exception {
		return datParadasFabricaLogic.findTotalNumberDatParadasFabrica();
	}

	public List<DatParadasFabricaDTO> getDataDatParadasFabrica() throws Exception {
		return datParadasFabricaLogic.getDataDatParadasFabrica();
	}

	public List<PlanRevisionEquipoRecursos> getPlanRevisionEquipoRecursos() throws Exception {
		return planRevisionEquipoRecursosLogic.getPlanRevisionEquipoRecursos();
	}

	public void savePlanRevisionEquipoRecursos(PlanRevisionEquipoRecursos entity) throws Exception {
		planRevisionEquipoRecursosLogic.savePlanRevisionEquipoRecursos(entity);
	}

	public void deletePlanRevisionEquipoRecursos(PlanRevisionEquipoRecursos entity) throws Exception {
		planRevisionEquipoRecursosLogic.deletePlanRevisionEquipoRecursos(entity);
	}

	public void updatePlanRevisionEquipoRecursos(PlanRevisionEquipoRecursos entity) throws Exception {
		planRevisionEquipoRecursosLogic.updatePlanRevisionEquipoRecursos(entity);
	}

	public PlanRevisionEquipoRecursos getPlanRevisionEquipoRecursos(Long planRevisionEquipoRecursosId)
			throws Exception {
		PlanRevisionEquipoRecursos planRevisionEquipoRecursos = null;

		try {
			planRevisionEquipoRecursos = planRevisionEquipoRecursosLogic
					.getPlanRevisionEquipoRecursos(planRevisionEquipoRecursosId);
		} catch (Exception e) {
			throw e;
		}

		return planRevisionEquipoRecursos;
	}

	public List<PlanRevisionEquipoRecursos> findByCriteriaInPlanRevisionEquipoRecursos(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return planRevisionEquipoRecursosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<PlanRevisionEquipoRecursos> findPagePlanRevisionEquipoRecursos(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return planRevisionEquipoRecursosLogic.findPagePlanRevisionEquipoRecursos(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberPlanRevisionEquipoRecursos() throws Exception {
		return planRevisionEquipoRecursosLogic.findTotalNumberPlanRevisionEquipoRecursos();
	}

	public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursos() throws Exception {
		return planRevisionEquipoRecursosLogic.getDataPlanRevisionEquipoRecursos();
	}

	public long consultarConsecutivoParadasFabrica(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoParadasFabrica(compania);
	}

	public List<MttoParadasFabricaDTO> consultarInformeParosFabrica(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String tag, Long flagTag) throws Exception {
		return informesLogic.consultarInformeParosFabrica(compania, fechaInicial, fechaFinal, equipo, flagEquipo, tag,
				flagTag);

	}

	public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursosByRecursos(Long equipoRcursosId)
			throws Exception {
		return planRevisionEquipoRecursosLogic.getDataPlanRevisionEquipoRecursosByRecursos(equipoRcursosId);
	}

	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadoresByTrabajador(Long datTransProdId)
			throws Exception {
		return datTransProdTrabajadoresLogic.getDataDatTransProdTrabajadoresByTrabajador(datTransProdId);
	}

	public List<CatalogoEquiposDTO> consultarCatalogoEquipos(Long compania, String origenDatos) throws Exception {
		return informesLogic.consultarCatalogoEquipos(compania, origenDatos);
	}

	public List<AnaLaboratorio> getAnaLaboratorio() throws Exception {
		return anaLaboratorioLogic.getAnaLaboratorio();
	}

	public void saveAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
			throws Exception {
		anaLaboratorioLogic.saveAnaLaboratorio(entity, dataVariablesLab);
	}

	public void deleteAnaLaboratorio(AnaLaboratorio entity) throws Exception {
		anaLaboratorioLogic.deleteAnaLaboratorio(entity);
	}

	public void updateAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
			throws Exception {
		anaLaboratorioLogic.updateAnaLaboratorio(entity, dataVariablesLab);
	}

	public AnaLaboratorio getAnaLaboratorio(Long anaLabId) throws Exception {
		AnaLaboratorio anaLaboratorio = null;

		try {
			anaLaboratorio = anaLaboratorioLogic.getAnaLaboratorio(anaLabId);
		} catch (Exception e) {
			throw e;
		}

		return anaLaboratorio;
	}

	public List<AnaLaboratorio> findByCriteriaInAnaLaboratorio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return anaLaboratorioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<AnaLaboratorio> findPageAnaLaboratorio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return anaLaboratorioLogic.findPageAnaLaboratorio(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberAnaLaboratorio() throws Exception {
		return anaLaboratorioLogic.findTotalNumberAnaLaboratorio();
	}

	public List<AnaLaboratorioDTO> getDataAnaLaboratorio() throws Exception {
		return anaLaboratorioLogic.getDataAnaLaboratorio();
	}

	public List<AnaLaboratorioVariable> getAnaLaboratorioVariable() throws Exception {
		return anaLaboratorioVariableLogic.getAnaLaboratorioVariable();
	}

	public void saveAnaLaboratorioVariable(AnaLaboratorioVariable entity) throws Exception {
		anaLaboratorioVariableLogic.saveAnaLaboratorioVariable(entity);
	}

	public void deleteAnaLaboratorioVariable(AnaLaboratorioVariable entity) throws Exception {
		anaLaboratorioVariableLogic.deleteAnaLaboratorioVariable(entity);
	}

	public void updateAnaLaboratorioVariable(AnaLaboratorioVariable entity) throws Exception {
		anaLaboratorioVariableLogic.updateAnaLaboratorioVariable(entity);
	}

	public AnaLaboratorioVariable getAnaLaboratorioVariable(Long anaLaboratorioVariableId) throws Exception {
		AnaLaboratorioVariable anaLaboratorioVariable = null;

		try {
			anaLaboratorioVariable = anaLaboratorioVariableLogic.getAnaLaboratorioVariable(anaLaboratorioVariableId);
		} catch (Exception e) {
			throw e;
		}

		return anaLaboratorioVariable;
	}

	public List<AnaLaboratorioVariable> findByCriteriaInAnaLaboratorioVariable(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return anaLaboratorioVariableLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<AnaLaboratorioVariable> findPageAnaLaboratorioVariable(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return anaLaboratorioVariableLogic.findPageAnaLaboratorioVariable(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberAnaLaboratorioVariable() throws Exception {
		return anaLaboratorioVariableLogic.findTotalNumberAnaLaboratorioVariable();
	}

	public List<AnaLaboratorioVariableDTO> getDataAnaLaboratorioVariable() throws Exception {
		return anaLaboratorioVariableLogic.getDataAnaLaboratorioVariable();
	}

	public List<DatAnaLaboratorio> getDatAnaLaboratorio() throws Exception {
		return datAnaLaboratorioLogic.getDatAnaLaboratorio();
	}

	public void saveDatAnaLaboratorio(DatAnaLaboratorio entity,
			List<ListaVariablesAnaLaboratorioDTO> dataAnalisisLabDet) throws Exception {
		datAnaLaboratorioLogic.saveDatAnaLaboratorio(entity, dataAnalisisLabDet);
	}

	public void deleteDatAnaLaboratorio(DatAnaLaboratorio entity) throws Exception {
		datAnaLaboratorioLogic.deleteDatAnaLaboratorio(entity);
	}

	public void updateDatAnaLaboratorio(DatAnaLaboratorio entity, List<DatAnaLaboratorioDetDTO> dataAnalisisLabDet,
			List<ListaVariablesAnaLaboratorioDTO> dataVariables) throws Exception {
		datAnaLaboratorioLogic.updateDatAnaLaboratorio(entity, dataAnalisisLabDet, dataVariables);
	}

	public DatAnaLaboratorio getDatAnaLaboratorio(Long datAnaLabId) throws Exception {
		DatAnaLaboratorio datAnaLaboratorio = null;

		try {
			datAnaLaboratorio = datAnaLaboratorioLogic.getDatAnaLaboratorio(datAnaLabId);
		} catch (Exception e) {
			throw e;
		}

		return datAnaLaboratorio;
	}

	public List<DatAnaLaboratorio> findByCriteriaInDatAnaLaboratorio(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datAnaLaboratorioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatAnaLaboratorio> findPageDatAnaLaboratorio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datAnaLaboratorioLogic.findPageDatAnaLaboratorio(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatAnaLaboratorio() throws Exception {
		return datAnaLaboratorioLogic.findTotalNumberDatAnaLaboratorio();
	}

	public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorio() throws Exception {
		return datAnaLaboratorioLogic.getDataDatAnaLaboratorio();
	}

	public List<DatAnaLaboratorioDet> getDatAnaLaboratorioDet() throws Exception {
		return datAnaLaboratorioDetLogic.getDatAnaLaboratorioDet();
	}

	public void saveDatAnaLaboratorioDet(DatAnaLaboratorioDet entity) throws Exception {
		datAnaLaboratorioDetLogic.saveDatAnaLaboratorioDet(entity);
	}

	public void deleteDatAnaLaboratorioDet(DatAnaLaboratorioDet entity) throws Exception {
		datAnaLaboratorioDetLogic.deleteDatAnaLaboratorioDet(entity);
	}

	public void updateDatAnaLaboratorioDet(DatAnaLaboratorioDet entity) throws Exception {
		datAnaLaboratorioDetLogic.updateDatAnaLaboratorioDet(entity);
	}

	public DatAnaLaboratorioDet getDatAnaLaboratorioDet(Long datAnaLaboratorioDetId) throws Exception {
		DatAnaLaboratorioDet datAnaLaboratorioDet = null;

		try {
			datAnaLaboratorioDet = datAnaLaboratorioDetLogic.getDatAnaLaboratorioDet(datAnaLaboratorioDetId);
		} catch (Exception e) {
			throw e;
		}

		return datAnaLaboratorioDet;
	}

	public List<DatAnaLaboratorioDet> findByCriteriaInDatAnaLaboratorioDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datAnaLaboratorioDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatAnaLaboratorioDet> findPageDatAnaLaboratorioDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datAnaLaboratorioDetLogic.findPageDatAnaLaboratorioDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatAnaLaboratorioDet() throws Exception {
		return datAnaLaboratorioDetLogic.findTotalNumberDatAnaLaboratorioDet();
	}

	public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDet() throws Exception {
		return datAnaLaboratorioDetLogic.getDataDatAnaLaboratorioDet();
	}

	public List<VariableLab> getVariableLab() throws Exception {
		return variableLabLogic.getVariableLab();
	}

	public void saveVariableLab(VariableLab entity) throws Exception {
		variableLabLogic.saveVariableLab(entity);
	}

	public void deleteVariableLab(VariableLab entity) throws Exception {
		variableLabLogic.deleteVariableLab(entity);
	}

	public void updateVariableLab(VariableLab entity) throws Exception {
		variableLabLogic.updateVariableLab(entity);
	}

	public VariableLab getVariableLab(Long variableLabId) throws Exception {
		VariableLab variableLab = null;

		try {
			variableLab = variableLabLogic.getVariableLab(variableLabId);
		} catch (Exception e) {
			throw e;
		}

		return variableLab;
	}

	public List<VariableLab> findByCriteriaInVariableLab(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return variableLabLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<VariableLab> findPageVariableLab(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return variableLabLogic.findPageVariableLab(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberVariableLab() throws Exception {
		return variableLabLogic.findTotalNumberVariableLab();
	}

	public List<VariableLabDTO> getDataVariableLab() throws Exception {
		return variableLabLogic.getDataVariableLab();
	}

	public List<ListaVariablesSanidadDTO> consultarListaVariablesSanidad(Long compania, Long tipoAnalisis)
			throws Exception {
		return informesLogic.consultarListaVariablesSanidad(compania, tipoAnalisis);
	}

	public long consultarIdUnicoDatSanVeg(Long compania) throws Exception {
		return informesLogic.consultarIdUnicoDatSanVeg(compania);
	}

	public List<AnaLaboratorioVariableDTO> getDataAnaLaboratorioVariableByVariable(Long idAnalisis) throws Exception {
		return anaLaboratorioVariableLogic.getDataAnaLaboratorioVariableByVariable(idAnalisis);
	}

	public long consultarConsecutivoDatAnalisisLaboratorio(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatAnalisisLaboratorio(compania);
	}

	public long consultarIdUnicoDatAnalisisLaboratorio(Long compania) throws Exception {
		return informesLogic.consultarIdUnicoDatAnalisisLaboratorio(compania);
	}

	public List<ListaVariablesAnaLaboratorioDTO> consultarListaVariablesAnaLaboratorio(Long compania, Long tipoAnalisis)
			throws Exception {
		return informesLogic.consultarListaVariablesAnaLaboratorio(compania, tipoAnalisis);
	}

	public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDetByAnalisis(Long idDatAnaLaboratorio)
			throws Exception {
		return datAnaLaboratorioDetLogic.getDataDatAnaLaboratorioDetByAnalisis(idDatAnaLaboratorio);
	}

	public List<LogBascula> getLogBascula() throws Exception {
		return logBasculaLogic.getLogBascula();
	}

	public void saveLogBascula(LogBascula entity) throws Exception {
		logBasculaLogic.saveLogBascula(entity);
	}

	public void deleteLogBascula(LogBascula entity) throws Exception {
		logBasculaLogic.deleteLogBascula(entity);
	}

	public void updateLogBascula(LogBascula entity) throws Exception {
		logBasculaLogic.updateLogBascula(entity);
	}

	public LogBascula getLogBascula(Long logBasculaId) throws Exception {
		LogBascula logBascula = null;

		try {
			logBascula = logBasculaLogic.getLogBascula(logBasculaId);
		} catch (Exception e) {
			throw e;
		}

		return logBascula;
	}

	public List<LogBascula> findByCriteriaInLogBascula(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return logBasculaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<LogBascula> findPageLogBascula(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return logBasculaLogic.findPageLogBascula(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberLogBascula() throws Exception {
		return logBasculaLogic.findTotalNumberLogBascula();
	}

	public List<LogBasculaDTO> getDataLogBascula() throws Exception {
		return logBasculaLogic.getDataLogBascula();
	}

	public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorioByTipoAnalisis(Long idAnalisis) throws Exception {
		return datAnaLaboratorioLogic.getDataDatAnaLaboratorioByTipoAnalisis(idAnalisis);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> consultarTiqueteSinAnalisisCalidadFruto(Long compania)
			throws Exception {
		return informesLogic.consultarTiqueteSinAnalisisCalidadFruto(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> consultarTiqueteSinAnalisisCalidadDetalle(
			Long compania, Long tiquete) throws Exception {
		return informesLogic.consultarTiqueteSinAnalisisCalidadDetalle(compania, tiquete);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisProcesoIndustrialDTO> consultarAnalisisProcesoIndustrial(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoAnalisis, Long flagTipoAnalisis) throws Exception {
		return informesLogic.consultarAnalisisProcesoIndustrial(compania, fechaInicial, fechaFinal, tipoAnalisis,
				flagTipoAnalisis);
	}

	// @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	// public long consultarConsec_dat_pluvio(Long compania) throws Exception{
	// return informesLogic.consultarConsec_dat_pluvio( compania);
	// }

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CatalogProductoDTO> consultarCatalogoProductosAgricolas(Long compania) throws Exception {
		return informesLogic.consultarCatalogoProductosAgricolas(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CatalogProductoDTO> consultarCatalogoProductosMtto(Long compania) throws Exception {
		return informesLogic.consultarCatalogoProductosMtto(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public double calcularHoras(Date fechaFinal, Date fechaInicial) throws Exception {
		return informesLogic.calcularHoras(fechaFinal, fechaInicial);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaNivel4DTO> consultarListaNivel4(Long compania, String nivel2) throws Exception {
		return informesLogic.consultarListaNivel4(compania, nivel2);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		datOtrosCostosLogic.saveDatOtrosCostosVer2(entity, dataLotes, dataDetalle);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		datOtrosCostosLogic.updateDatOtrosCostosVer2(entity, dataLotes, dataDetalle);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long borrarNivel4OtrosCostos(Long idOtrosCostos) throws Exception {
		return informesLogic.borrarNivel4OtrosCostos(idOtrosCostos);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarMo(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String trabajador, Long flagTrabajador,
			String conceptonomina, Long flagconceptonomina) throws Exception {
		return informesLogic.consultaInterfaceManagerExportarMo(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, trabajador, flagTrabajador, conceptonomina, flagconceptonomina);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarAusentismosMo(Long compania,
			Date fechaInicial, Date fechaFinal, String contratista, Long flagContratista, String trabajador,
			Long flagTrabajador, String conceptonomina, Long flagconceptonomina) throws Exception {
		return informesLogic.consultaInterfaceManagerExportarAusentismosMo(compania, fechaInicial, fechaFinal,
				contratista, flagContratista, trabajador, flagTrabajador, conceptonomina, flagconceptonomina);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String aprobarOrdenesServicioNivel1(String idPlanLaborDet) throws Exception {
		return informesLogic.aprobarOrdenesServicioNivel1(idPlanLaborDet);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String aprobarOrdenesServicioNivel2(String idPlanLaborDet) throws Exception {
		return informesLogic.aprobarOrdenesServicioNivel1(idPlanLaborDet);
	}

	/***** consulta orden de trabajo ******/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDesAprobacion(Long compania) throws Exception {
		return informesLogic.consultarOrdenTrabajoDesAprobacion(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarExistenciaOtParaSolicitudMq(Long solicitudId) throws Exception {
		return informesLogic.consultarExistenciaOtParaSolicitudMq(solicitudId);
	}

	@Override
	public List<CostosTotalesDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception {
		return informesLogic.consultarInformeHojaVidaLote(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, numeroCosechas, flagNumeroCosechas);
	}

	@Override
	public Long borrarCierreCostosNomina(Long compania, Long anio, Long mes) throws Exception {
		return informesLogic.borrarCierreCostosNomina(compania, anio, mes);
	}

	@Override
	public Long borrarCierreCostosDistriMqAgricola(Long compania, Long anio, Long mes) throws Exception {
		return informesLogic.borrarCierreCostosDistriMqAgricola(compania, anio, mes);

	}

	public Long cierreCostosNomina(Long compania, Long anio, Long mes, String contratista, Long flagContratista)
			throws Exception {
		return informesLogic.cierreCostosNomina(compania, anio, mes, contratista, flagContratista);
	}

	public Long cierreCostosDistriMqAgricola(Long compania, Long anio, Long mes, String equipo, Long flagEquipo,
			String contratista, Long flagContratista) throws Exception {
		return informesLogic.cierreCostosDistriMqAgricola(compania, anio, mes, equipo, flagEquipo, contratista,
				flagContratista);
	}

	public List<ProyeccionLaboresLoteDTO> consultarInformePresupuestoPorHacienda(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String cronogramaLabor,
			Long flagCronogramaLabor) throws Exception {
		return informesLogic.consultarInformePresupuestoPorHacienda(compania, zona, flagZona, finca, flagFinca, labor,
				flagLabor, unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, cronogramaLabor,
				flagCronogramaLabor);
	}

	public Long borrarCalculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.borrarCalculoDominicalesFestivosNomina(compania, fechaInicial, fechaFinal);
	}

	public Long calculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception {
		return informesLogic.calculoDominicalesFestivosNomina(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, trabajador, flagTrabajador);
	}

	public List<DatNominaTrabajadorMq> getDatNominaTrabajadorMq() throws Exception {
		return datNominaTrabajadorMqLogic.getDatNominaTrabajadorMq();
	}

	public void saveDatNominaTrabajadorMq(DatNominaTrabajadorMq entity,
			List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador) throws Exception {
		datNominaTrabajadorMqLogic.saveDatNominaTrabajadorMq(entity, dataNominaTrabajador);
	}

	public void deleteDatNominaTrabajadorMq(DatNominaTrabajadorMq entity) throws Exception {
		datNominaTrabajadorMqLogic.deleteDatNominaTrabajadorMq(entity);
	}

	public void updateDatNominaTrabajadorMq(DatNominaTrabajadorMq entity,
			List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador) throws Exception {
		datNominaTrabajadorMqLogic.updateDatNominaTrabajadorMq(entity, dataNominaTrabajador);
	}

	public DatNominaTrabajadorMq getDatNominaTrabajadorMq(Long datNominaTrabajadorMqId) throws Exception {
		DatNominaTrabajadorMq datNominaTrabajadorMq = null;

		try {
			datNominaTrabajadorMq = datNominaTrabajadorMqLogic.getDatNominaTrabajadorMq(datNominaTrabajadorMqId);
		} catch (Exception e) {
			throw e;
		}

		return datNominaTrabajadorMq;
	}

	public List<DatNominaTrabajadorMq> findByCriteriaInDatNominaTrabajadorMq(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datNominaTrabajadorMqLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatNominaTrabajadorMq> findPageDatNominaTrabajadorMq(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datNominaTrabajadorMqLogic.findPageDatNominaTrabajadorMq(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatNominaTrabajadorMq() throws Exception {
		return datNominaTrabajadorMqLogic.findTotalNumberDatNominaTrabajadorMq();
	}

	public List<DatNominaTrabajadorMqDTO> getDataDatNominaTrabajadorMq() throws Exception {
		return datNominaTrabajadorMqLogic.getDataDatNominaTrabajadorMq();
	}

	public List<DatNominaTrabajadorMqdet> getDatNominaTrabajadorMqdet() throws Exception {
		return datNominaTrabajadorMqdetLogic.getDatNominaTrabajadorMqdet();
	}

	public void saveDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity) throws Exception {
		datNominaTrabajadorMqdetLogic.saveDatNominaTrabajadorMqdet(entity);
	}

	public void deleteDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity) throws Exception {
		datNominaTrabajadorMqdetLogic.deleteDatNominaTrabajadorMqdet(entity);
	}

	public void updateDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity) throws Exception {
		datNominaTrabajadorMqdetLogic.updateDatNominaTrabajadorMqdet(entity);
	}

	public DatNominaTrabajadorMqdet getDatNominaTrabajadorMqdet(Long datNominaTrabajadorMqdetId) throws Exception {
		DatNominaTrabajadorMqdet datNominaTrabajadorMqdet = null;

		try {
			datNominaTrabajadorMqdet = datNominaTrabajadorMqdetLogic
					.getDatNominaTrabajadorMqdet(datNominaTrabajadorMqdetId);
		} catch (Exception e) {
			throw e;
		}

		return datNominaTrabajadorMqdet;
	}

	public List<DatNominaTrabajadorMqdet> findByCriteriaInDatNominaTrabajadorMqdet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datNominaTrabajadorMqdetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatNominaTrabajadorMqdet> findPageDatNominaTrabajadorMqdet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datNominaTrabajadorMqdetLogic.findPageDatNominaTrabajadorMqdet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatNominaTrabajadorMqdet() throws Exception {
		return datNominaTrabajadorMqdetLogic.findTotalNumberDatNominaTrabajadorMqdet();
	}

	public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdet() throws Exception {
		return datNominaTrabajadorMqdetLogic.getDataDatNominaTrabajadorMqdet();
	}

	public List<DatPlanServiciosMqdet> getDatPlanServiciosMqdet() throws Exception {
		return datPlanServiciosMqdetLogic.getDatPlanServiciosMqdet();
	}

	public void saveDatPlanServiciosMqdet(DatPlanServiciosMqdet entity) throws Exception {
		datPlanServiciosMqdetLogic.saveDatPlanServiciosMqdet(entity);
	}

	public void deleteDatPlanServiciosMqdet(DatPlanServiciosMqdet entity) throws Exception {
		datPlanServiciosMqdetLogic.deleteDatPlanServiciosMqdet(entity);
	}

	public void updateDatPlanServiciosMqdet(DatPlanServiciosMqdet entity) throws Exception {
		datPlanServiciosMqdetLogic.updateDatPlanServiciosMqdet(entity);
	}

	public DatPlanServiciosMqdet getDatPlanServiciosMqdet(Long datPlanServiciosMqdetId) throws Exception {
		DatPlanServiciosMqdet datPlanServiciosMqdet = null;

		try {
			datPlanServiciosMqdet = datPlanServiciosMqdetLogic.getDatPlanServiciosMqdet(datPlanServiciosMqdetId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanServiciosMqdet;
	}

	public List<DatPlanServiciosMqdet> findByCriteriaInDatPlanServiciosMqdet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datPlanServiciosMqdetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatPlanServiciosMqdet> findPageDatPlanServiciosMqdet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datPlanServiciosMqdetLogic.findPageDatPlanServiciosMqdet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatPlanServiciosMqdet() throws Exception {
		return datPlanServiciosMqdetLogic.findTotalNumberDatPlanServiciosMqdet();
	}

	public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdet() throws Exception {
		return datPlanServiciosMqdetLogic.getDataDatPlanServiciosMqdet();
	}

	public List<DatHerramienta> getDatHerramienta() throws Exception {
		return datHerramientaLogic.getDatHerramienta();
	}

	public void saveDatHerramienta(DatHerramienta entity) throws Exception {
		datHerramientaLogic.saveDatHerramienta(entity);
	}

	public void deleteDatHerramienta(DatHerramienta entity) throws Exception {
		datHerramientaLogic.deleteDatHerramienta(entity);
	}

	public void updateDatHerramienta(DatHerramienta entity) throws Exception {
		datHerramientaLogic.updateDatHerramienta(entity);
	}

	public DatHerramienta getDatHerramienta(Long datHerramientaId) throws Exception {
		DatHerramienta datHerramienta = null;

		try {
			datHerramienta = datHerramientaLogic.getDatHerramienta(datHerramientaId);
		} catch (Exception e) {
			throw e;
		}

		return datHerramienta;
	}

	public List<DatHerramienta> findByCriteriaInDatHerramienta(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datHerramientaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatHerramienta> findPageDatHerramienta(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datHerramientaLogic.findPageDatHerramienta(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatHerramienta() throws Exception {
		return datHerramientaLogic.findTotalNumberDatHerramienta();
	}

	public List<DatHerramientaDTO> getDataDatHerramienta() throws Exception {
		return datHerramientaLogic.getDataDatHerramienta();
	}

	public List<CatalogProductoDTO> consultarCatalogoProductosSegunTipo(Long compania, Long tipoProducto)
			throws Exception {
		return informesLogic.consultarCatalogoProductosSegunTipo(compania, tipoProducto);
	}

	public long consultarUltimaPlanillaNomina(Long compania, Date fecha) throws Exception {
		return informesLogic.consultarUltimaPlanillaNomina(compania, fecha);
	}



}
