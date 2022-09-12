package co.com.arcosoft.presentation.businessDelegate2;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.modelo.CajaMenor;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatCajaMenor;
import co.com.arcosoft.modelo.DatCajaMenorDet;
import co.com.arcosoft.modelo.DatCheckListEquipo;
import co.com.arcosoft.modelo.DatCheckListEquipoDet;
import co.com.arcosoft.modelo.DatCheckListEquipoLabor;
import co.com.arcosoft.modelo.DatCompraMateriaPrima;
import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.DatDiferidos;
import co.com.arcosoft.modelo.DatDiferidosAgricola;
import co.com.arcosoft.modelo.DatDiferidosAgricolaDet;
import co.com.arcosoft.modelo.DatDiferidosCuotas;
import co.com.arcosoft.modelo.DatDiferidosCuotasAgricolas;
import co.com.arcosoft.modelo.DatDiferidosDet;
import co.com.arcosoft.modelo.DatFacturaServicios;
import co.com.arcosoft.modelo.DatFacturaServiciosTerceros;
import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.DatMantenimientoEquipoPlanRevision;
import co.com.arcosoft.modelo.DatNominaTrabajadorMq;
import co.com.arcosoft.modelo.DatNominaTrabajadorMqdet;
import co.com.arcosoft.modelo.DatOtrosCostosDetalle;
import co.com.arcosoft.modelo.DatOtrosCostosMq;
import co.com.arcosoft.modelo.DatOtrosCostosMqdetDistribuccion;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.DatPagosNotasClientes;
import co.com.arcosoft.modelo.DatPlanServiciosMq;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.DatPlanServiciosMqdetEjec;
import co.com.arcosoft.modelo.DatProductosRelacionados;
import co.com.arcosoft.modelo.DatProvicionesCierreNomina;
import co.com.arcosoft.modelo.DatProvicionesCierreNominaMq;
import co.com.arcosoft.modelo.DatReqProductos;
import co.com.arcosoft.modelo.DatReqProductosDet;
import co.com.arcosoft.modelo.EquipoImplemento;
import co.com.arcosoft.modelo.LaborCcontable;
import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PlanRevisionProd;
import co.com.arcosoft.modelo.PrecioPromMateriaPrima;
import co.com.arcosoft.modelo.PuntosLubricacion;
import co.com.arcosoft.modelo.SubTipoCotizante;
import co.com.arcosoft.modelo.TablaAnalitica;
import co.com.arcosoft.modelo.TablaAnaliticaDetalle;
import co.com.arcosoft.modelo.TarifasArl;
import co.com.arcosoft.modelo.TipoCotizante;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.control.ICajaMenorLogic;
import co.com.arcosoft.modelo.control.IConceptoKardexLogic;
import co.com.arcosoft.modelo.control.IDatCajaMenorDetLogic;
import co.com.arcosoft.modelo.control.IDatCajaMenorLogic;
import co.com.arcosoft.modelo.control.IDatCheckListEquipoDetLogic;
import co.com.arcosoft.modelo.control.IDatCheckListEquipoLaborLogic;
import co.com.arcosoft.modelo.control.IDatCheckListEquipoLogic;
import co.com.arcosoft.modelo.control.IDatCompraMateriaPrimaLogic;
import co.com.arcosoft.modelo.control.IDatCompraProductosLogic;
import co.com.arcosoft.modelo.control.IDatCtrlMaqPinesLogic;
import co.com.arcosoft.modelo.control.IDatDiferidosAgricolaDetLogic;
import co.com.arcosoft.modelo.control.IDatDiferidosAgricolaLogic;
import co.com.arcosoft.modelo.control.IDatDiferidosCuotasAgricolasLogic;
import co.com.arcosoft.modelo.control.IDatDiferidosCuotasLogic;
import co.com.arcosoft.modelo.control.IDatDiferidosDetLogic;
import co.com.arcosoft.modelo.control.IDatDiferidosLogic;
import co.com.arcosoft.modelo.control.IDatFacturaServiciosLogic;
import co.com.arcosoft.modelo.control.IDatFacturaServiciosTercerosLogic;
import co.com.arcosoft.modelo.control.IDatHerramientaLogic;
import co.com.arcosoft.modelo.control.IDatMantenimientoEquipoPlanRevisionLogic;
import co.com.arcosoft.modelo.control.IDatNominaTrabajadorMqLogic;
import co.com.arcosoft.modelo.control.IDatNominaTrabajadorMqdetLogic;
import co.com.arcosoft.modelo.control.IDatOtrosCostosDetalleLogic;
import co.com.arcosoft.modelo.control.IDatOtrosCostosMqLogic;
import co.com.arcosoft.modelo.control.IDatOtrosCostosMqdetDistribuccionLogic;
import co.com.arcosoft.modelo.control.IDatOtrosMovInventarioLogic;
import co.com.arcosoft.modelo.control.IDatPagosNotasClientesLogic;
import co.com.arcosoft.modelo.control.IDatPlanServiciosMqLogic;
import co.com.arcosoft.modelo.control.IDatPlanServiciosMqdetEjecLogic;
import co.com.arcosoft.modelo.control.IDatPlanServiciosMqdetLogic;
import co.com.arcosoft.modelo.control.IDatProductosRelacionadosLogic;
import co.com.arcosoft.modelo.control.IDatProvicionesCierreNominaLogic;
import co.com.arcosoft.modelo.control.IDatProvicionesCierreNominaMqLogic;
import co.com.arcosoft.modelo.control.IDatReqProductosDetLogic;
import co.com.arcosoft.modelo.control.IDatReqProductosLogic;
import co.com.arcosoft.modelo.control.IEquipoImplementoLogic;
import co.com.arcosoft.modelo.control.IInformesLogic;
import co.com.arcosoft.modelo.control.ILaborCcontableLogic;
import co.com.arcosoft.modelo.control.ILogDatServRealizadosEquipoLogic;
import co.com.arcosoft.modelo.control.INivel2ClientesmqLogic;
import co.com.arcosoft.modelo.control.INivel4ClientesmqLogic;
import co.com.arcosoft.modelo.control.IPlanRevisionProdLogic;
import co.com.arcosoft.modelo.control.IPrecioPromMateriaPrimaLogic;
import co.com.arcosoft.modelo.control.IPrecioPromProdLogic;
import co.com.arcosoft.modelo.control.IPuntosLubricacionLogic;
import co.com.arcosoft.modelo.control.ISubTipoCotizanteLogic;
import co.com.arcosoft.modelo.control.ITablaAnaliticaDetalleLogic;
import co.com.arcosoft.modelo.control.ITablaAnaliticaLogic;
import co.com.arcosoft.modelo.control.ITarifasArlLogic;
import co.com.arcosoft.modelo.control.ITipoCotizanteLogic;
import co.com.arcosoft.modelo.control.IUbicacionesAlmacenLogic;
import co.com.arcosoft.modelo.dto.CajaMenorDTO;
import co.com.arcosoft.modelo.dto.ConceptoKardexDTO;
import co.com.arcosoft.modelo.dto.DatCajaMenorDTO;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDetDTO;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;
import co.com.arcosoft.modelo.dto.DatCompraMateriaPrimaDTO;
import co.com.arcosoft.modelo.dto.DatCompraProductosDTO;
import co.com.arcosoft.modelo.dto.DatCtrlMaqPinesDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDetDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasAgricolasDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDetDTO;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosDTO;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosTercerosDTO;
import co.com.arcosoft.modelo.dto.DatHerramientaDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoPlanRevisionDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqdetDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDetalleDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDistribuccionDTO;
import co.com.arcosoft.modelo.dto.DatOtrosMovInventarioDTO;
import co.com.arcosoft.modelo.dto.DatPagosNotasClientesDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetEjecDTO;
import co.com.arcosoft.modelo.dto.DatProductosRelacionadosDTO;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaDTO;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaMqDTO;
import co.com.arcosoft.modelo.dto.DatReqProductosDTO;
import co.com.arcosoft.modelo.dto.DatReqProductosDetDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.EquipoImplementoDTO;
import co.com.arcosoft.modelo.dto.LaborCcontableDTO;
import co.com.arcosoft.modelo.dto.LogDatServRealizadosEquipoDTO;
import co.com.arcosoft.modelo.dto.Nivel2ClientesmqDTO;
import co.com.arcosoft.modelo.dto.Nivel4ClientesmqDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionProdDTO;
import co.com.arcosoft.modelo.dto.PrecioPromMateriaPrimaDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.dto.PuntosLubricacionDTO;
import co.com.arcosoft.modelo.dto.SubTipoCotizanteDTO;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDTO;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDetalleDTO;
import co.com.arcosoft.modelo.dto.TarifasArlDTO;
import co.com.arcosoft.modelo.dto.TipoCotizanteDTO;
import co.com.arcosoft.modelo.dto.UbicacionesAlmacenDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogProductoDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.CatalogoPlanRevisionDTO;
import co.com.arcosoft.modelo.informes.dto.ConsolidadoNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCajaMenorDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraMateriaPrimaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCompraProductosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaComprobantePagoDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaCostosDiferidosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaDiferidosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaOtrosMovimientosInventarioDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaProgLaboresMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaProvisioncesMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaRegistrosUsuariosDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaServiciosRealizadosMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ConsultaStockMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.CosechasLoteDTO;
import co.com.arcosoft.modelo.informes.dto.CostosIndirectosEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.CostosTotalesDTO;
import co.com.arcosoft.modelo.informes.dto.CuadroPrecipitacionDiariaDTO;
import co.com.arcosoft.modelo.informes.dto.DistribuccionCostosMaquinaDTO;
import co.com.arcosoft.modelo.informes.dto.ExportarPlanRevisionDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosDTO;
import co.com.arcosoft.modelo.informes.dto.FacturaServiciosConsolidadosTercerosDTO;
import co.com.arcosoft.modelo.informes.dto.ImportarNominaEmpAdmonDTO;
import co.com.arcosoft.modelo.informes.dto.ListaProduccionDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaLaboresDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel2ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4ClientesmqDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDTO;
import co.com.arcosoft.modelo.informes.dto.ListaPlanillaNominaDetalladoDTO;
import co.com.arcosoft.modelo.informes.dto.ListaVariablesAnaLaboratorioDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoPinesMaquinariaDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProvisionesDTO;
import co.com.arcosoft.modelo.informes.dto.ListadoProximosMttoEquiposDTO;
import co.com.arcosoft.modelo.informes.dto.NominaDetalladaDTO;
import co.com.arcosoft.modelo.informes.dto.PagosNotasClientesDTO;
import co.com.arcosoft.modelo.informes.dto.ProduccionAcumFincaDTO;
import co.com.arcosoft.modelo.informes.dto.ProgLaboresMecMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgMttoPreventivosMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProgramacionLaboresMaqDTO;
import co.com.arcosoft.modelo.informes.dto.ProntuarioLotesDTO;
import co.com.arcosoft.modelo.informes.dto.ProyeccionLaboresLoteDTO;
import co.com.arcosoft.modelo.informes.dto.SolicitudesMttoEquipoDTO;
import co.com.arcosoft.modelo.informes.dto.TiquetesBasculaDTO;
import co.com.arcosoft.modelo.informes.dto.logServiciosMaqDTO;

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
@Service("BusinessDelegator2View")
public class BusinessDelegator2View implements IBusinessDelegator2View {
	private static final Logger log = LoggerFactory.getLogger(BusinessDelegator2View.class);

	@Autowired
	private IInformesLogic informesLogic;
	@Autowired
	private ITablaAnaliticaLogic tablaAnaliticaLogic;
	@Autowired
	private ITablaAnaliticaDetalleLogic tablaAnaliticaDetalleLogic;
	@Autowired
	private IDatNominaTrabajadorMqLogic datNominaTrabajadorMqLogic;
	@Autowired
	private IDatNominaTrabajadorMqdetLogic datNominaTrabajadorMqdetLogic;
	@Autowired
	private IDatPlanServiciosMqLogic datPlanServiciosMqLogic;
	@Autowired
	private IDatPlanServiciosMqdetLogic datPlanServiciosMqdetLogic;
	@Autowired
	private INivel2ClientesmqLogic nivel2ClientesmqLogic;
	@Autowired
	private INivel4ClientesmqLogic nivel4ClientesmqLogic;
	@Autowired
	private ICajaMenorLogic cajaMenorLogic;
	@Autowired
	private IConceptoKardexLogic conceptoKardexLogic;
	@Autowired
	private IDatFacturaServiciosLogic datFacturaServiciosLogic;
	@Autowired
	private IDatCompraProductosLogic datCompraProductosLogic;
	@Autowired
	private IDatDiferidosLogic datDiferidosLogic;
	@Autowired
	private IDatDiferidosDetLogic datDiferidosDetLogic;
	@Autowired
	private IDatHerramientaLogic datHerramientaLogic;
	@Autowired
	private IDatPagosNotasClientesLogic datPagosNotasClientesLogic;
	@Autowired
	private IDatOtrosMovInventarioLogic datOtrosMovInventarioLogic;
	@Autowired
	private IDatCajaMenorLogic datCajaMenorLogic;
	@Autowired
	private IDatCajaMenorDetLogic datCajaMenorDetLogic;
	@Autowired
	private IDatCtrlMaqPinesLogic datCtrlMaqPinesLogic;
	@Autowired
	private IDatReqProductosLogic datReqProductosLogic;
	@Autowired
	private IDatReqProductosDetLogic datReqProductosDetLogic;
	@Autowired
	private IDatOtrosCostosMqdetDistribuccionLogic datOtrosCostosMqdetDistribuccionLogic;
	@Autowired
	private IEquipoImplementoLogic equipoImplementoLogic;
	@Autowired
	private IDatDiferidosCuotasLogic datDiferidosCuotasLogic;
	@Autowired
	private IDatPlanServiciosMqdetEjecLogic datPlanServiciosMqdetEjecLogic;
	@Autowired
	private ILogDatServRealizadosEquipoLogic logDatServRealizadosEquipoLogic;
	@Autowired
	private ILaborCcontableLogic laborCcontableLogic;
	@Autowired
	private IPrecioPromProdLogic precioPromProdLogic;
	@Autowired
	private IDatOtrosCostosMqLogic datOtrosCostosMqLogic;
	@Autowired
	private IDatDiferidosAgricolaLogic datDiferidosAgricolaLogic;
	@Autowired
	private IDatDiferidosAgricolaDetLogic datDiferidosAgricolaDetLogic;
	@Autowired
	private IDatDiferidosCuotasAgricolasLogic datDiferidosCuotasAgricolasLogic;
	@Autowired
	private IPlanRevisionProdLogic planRevisionProdLogic;
	@Autowired
	private IPuntosLubricacionLogic puntosLubricacionLogic;
	@Autowired
	private IDatCheckListEquipoLogic datCheckListEquipoLogic;
	@Autowired
	private IDatCheckListEquipoDetLogic datCheckListEquipoDetLogic;
	@Autowired
	private IDatCheckListEquipoLaborLogic datCheckListEquipoLaborLogic;
	@Autowired
	private IDatOtrosCostosDetalleLogic datOtrosCostosDetalleLogic;
	@Autowired
	private IUbicacionesAlmacenLogic ubicacionesAlmacenLogic;
	@Autowired
	private IDatMantenimientoEquipoPlanRevisionLogic datMantenimientoEquipoPlanRevisionLogic;
	@Autowired
	private ISubTipoCotizanteLogic subTipoCotizanteLogic;
	@Autowired
	private ITipoCotizanteLogic tipoCotizanteLogic;
	@Autowired
	private IDatProvicionesCierreNominaLogic datProvicionesCierreNominaLogic;
	@Autowired
	private IDatProvicionesCierreNominaMqLogic datProvicionesCierreNominaMqLogic;

	@Autowired
	private IDatCompraMateriaPrimaLogic datCompraMateriaPrimaLogic;
	@Autowired
	private IPrecioPromMateriaPrimaLogic precioPromMateriaPrimaLogic;

	@Autowired
	private ITarifasArlLogic tarifasArlLogic;
	@Autowired
	private IDatFacturaServiciosTercerosLogic datFacturaServiciosTercerosLogic;
	@Autowired
	private IDatProductosRelacionadosLogic datProductosRelacionadosLogic;
	
	public long consultarConsec_dat_pluvio(Long compania) throws Exception {
		return informesLogic.consultarConsec_dat_pluvio(compania);
	}

	public List<ListaVariablesAnaLaboratorioDTO> pr_validar_existencia_analisis_lab(Long compania, Date fecha,
			String horaDigitacion, Long idAnalisis) throws Exception {
		return informesLogic.pr_validar_existencia_analisis_lab(compania, fecha, horaDigitacion, idAnalisis);
	}

	public Long pr_borrar_dat_ana_laboratorio(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_ana_laboratorio(id);
	}

	public Long pr_borrar_dat_ana_laboratorio_det(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_ana_laboratorio_det(id);
	}

	public List<ProyeccionLaboresLoteDTO> pr_presupuesto_vs_ejecutado(Long compania, Date fechaInicial, Date fechaFinal,
			String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesLogic.pr_presupuesto_vs_ejecutado(compania, fechaInicial, fechaFinal, cultivo, flagCultivo, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida,
				flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	public List<TablaAnalitica> getTablaAnalitica() throws Exception {
		return tablaAnaliticaLogic.getTablaAnalitica();
	}

	@Override
	public void saveTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna) throws Exception {
		tablaAnaliticaLogic.saveTablaAnalitica(entity, dataTabAna);
	}

	public void deleteTablaAnalitica(TablaAnalitica entity) throws Exception {
		tablaAnaliticaLogic.deleteTablaAnalitica(entity);
	}

	@Override
	public void updateTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna)
			throws Exception {
		tablaAnaliticaLogic.updateTablaAnalitica(entity, dataTabAna);
	}

	public TablaAnalitica getTablaAnalitica(Long tablaAnaliticaId) throws Exception {
		TablaAnalitica tablaAnalitica = null;

		try {
			tablaAnalitica = tablaAnaliticaLogic.getTablaAnalitica(tablaAnaliticaId);
		} catch (Exception e) {
			throw e;
		}

		return tablaAnalitica;
	}

	public List<TablaAnalitica> findByCriteriaInTablaAnalitica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tablaAnaliticaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<TablaAnalitica> findPageTablaAnalitica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tablaAnaliticaLogic.findPageTablaAnalitica(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTablaAnalitica() throws Exception {
		return tablaAnaliticaLogic.findTotalNumberTablaAnalitica();
	}

	public List<TablaAnaliticaDTO> getDataTablaAnalitica() throws Exception {
		return tablaAnaliticaLogic.getDataTablaAnalitica();
	}

	public List<TablaAnaliticaDetalle> getTablaAnaliticaDetalle() throws Exception {
		return tablaAnaliticaDetalleLogic.getTablaAnaliticaDetalle();
	}

	public void saveTablaAnaliticaDetalle(TablaAnaliticaDetalle entity) throws Exception {
		tablaAnaliticaDetalleLogic.saveTablaAnaliticaDetalle(entity);
	}

	public void deleteTablaAnaliticaDetalle(TablaAnaliticaDetalle entity) throws Exception {
		tablaAnaliticaDetalleLogic.deleteTablaAnaliticaDetalle(entity);
	}

	public void updateTablaAnaliticaDetalle(TablaAnaliticaDetalle entity) throws Exception {
		tablaAnaliticaDetalleLogic.updateTablaAnaliticaDetalle(entity);
	}

	public TablaAnaliticaDetalle getTablaAnaliticaDetalle(Long tablaAnaliticaDetalleId) throws Exception {
		TablaAnaliticaDetalle tablaAnaliticaDetalle = null;

		try {
			tablaAnaliticaDetalle = tablaAnaliticaDetalleLogic.getTablaAnaliticaDetalle(tablaAnaliticaDetalleId);
		} catch (Exception e) {
			throw e;
		}

		return tablaAnaliticaDetalle;
	}

	public List<TablaAnaliticaDetalle> findByCriteriaInTablaAnaliticaDetalle(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return tablaAnaliticaDetalleLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<TablaAnaliticaDetalle> findPageTablaAnaliticaDetalle(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return tablaAnaliticaDetalleLogic.findPageTablaAnaliticaDetalle(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberTablaAnaliticaDetalle() throws Exception {
		return tablaAnaliticaDetalleLogic.findTotalNumberTablaAnaliticaDetalle();
	}

	public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalle() throws Exception {
		return tablaAnaliticaDetalleLogic.getDataTablaAnaliticaDetalle();
	}

	public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalleByTablaAnalitica(Long tablaAnaliticaId)
			throws Exception {
		return tablaAnaliticaDetalleLogic.getDataTablaAnaliticaDetalleByTablaAnalitica(tablaAnaliticaId);
	}

	public List<TiquetesBasculaDTO> consultarEstadoVehiculo(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoSeleccionado, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception {
		return informesLogic.consultarEstadoVehiculo(compania1, fechaInicial, fechaFinal, tipoMovimiento,
				tipoTransaccion, flagTipoTransaccion, equipo, flagEquipo, flagEstadoTiquete, estadoSeleccionado,
				selectedTiquet, flagTiquet, tiquete_peso_neto);

	}

	public List<TiquetesBasculaDTO> consultarEstadoVehiculoPr(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoSeleccionado, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception {
		return informesLogic.consultarEstadoVehiculoPr(compania1, fechaInicial, fechaFinal, tipoMovimiento,
				tipoTransaccion, flagTipoTransaccion, equipo, flagEquipo, flagEstadoTiquete, estadoSeleccionado,
				selectedTiquet, flagTiquet, tiquete_peso_neto);

	}

	public List<TiquetesBasculaDTO> pr_consulta_vehiculo_en_patio(Long compania, Long equipo) throws Exception {
		return informesLogic.pr_consulta_vehiculo_en_patio(compania, equipo);
	}

	public long consultarConsecutivoDatTransProdPesoNeto(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatTransProdPesoNeto(compania);
	}

	public List<DatPlanServiciosMq> getDatPlanServiciosMq() throws Exception {
		return datPlanServiciosMqLogic.getDatPlanServiciosMq();
	}

	@Override
	public void saveDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
			throws Exception {
		datPlanServiciosMqLogic.saveDatPlanServiciosMq(entity, dataPlanServDet);
	}

	public void deleteDatPlanServiciosMq(DatPlanServiciosMq entity) throws Exception {
		datPlanServiciosMqLogic.deleteDatPlanServiciosMq(entity);
	}

	@Override
	public void updateDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
			throws Exception {
		datPlanServiciosMqLogic.updateDatPlanServiciosMq(entity, dataPlanServDet);
	}

	public DatPlanServiciosMq getDatPlanServiciosMq(Long datPlanServiciosMqId) throws Exception {
		DatPlanServiciosMq datPlanServiciosMq = null;

		try {
			datPlanServiciosMq = datPlanServiciosMqLogic.getDatPlanServiciosMq(datPlanServiciosMqId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanServiciosMq;
	}

	public List<DatPlanServiciosMq> findByCriteriaInDatPlanServiciosMq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datPlanServiciosMqLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatPlanServiciosMq> findPageDatPlanServiciosMq(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datPlanServiciosMqLogic.findPageDatPlanServiciosMq(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatPlanServiciosMq() throws Exception {
		return datPlanServiciosMqLogic.findTotalNumberDatPlanServiciosMq();
	}

	public List<DatPlanServiciosMqDTO> getDataDatPlanServiciosMq() throws Exception {
		return datPlanServiciosMqLogic.getDataDatPlanServiciosMq();
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

	public List<Nivel2Clientesmq> getNivel2Clientesmq() throws Exception {
		return nivel2ClientesmqLogic.getNivel2Clientesmq();
	}

	public void saveNivel2Clientesmq(Nivel2Clientesmq entity) throws Exception {
		nivel2ClientesmqLogic.saveNivel2Clientesmq(entity);
	}

	public void deleteNivel2Clientesmq(Nivel2Clientesmq entity) throws Exception {
		nivel2ClientesmqLogic.deleteNivel2Clientesmq(entity);
	}

	public void updateNivel2Clientesmq(Nivel2Clientesmq entity) throws Exception {
		nivel2ClientesmqLogic.updateNivel2Clientesmq(entity);
	}

	public Nivel2Clientesmq getNivel2Clientesmq(Long nivel2ClientesmqId) throws Exception {
		Nivel2Clientesmq nivel2Clientesmq = null;

		try {
			nivel2Clientesmq = nivel2ClientesmqLogic.getNivel2Clientesmq(nivel2ClientesmqId);
		} catch (Exception e) {
			throw e;
		}

		return nivel2Clientesmq;
	}

	public List<Nivel2Clientesmq> findByCriteriaInNivel2Clientesmq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel2ClientesmqLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Nivel2Clientesmq> findPageNivel2Clientesmq(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return nivel2ClientesmqLogic.findPageNivel2Clientesmq(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberNivel2Clientesmq() throws Exception {
		return nivel2ClientesmqLogic.findTotalNumberNivel2Clientesmq();
	}

	public List<Nivel2ClientesmqDTO> getDataNivel2Clientesmq() throws Exception {
		return nivel2ClientesmqLogic.getDataNivel2Clientesmq();
	}

	public List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq(Long compania, Long clienteId) throws Exception {
		return informesLogic.listaNivel2Clientesmq(compania, clienteId);
	}

	public BigDecimal consultarAdicionalManoObra(Long idCompania, Long idLabor, Long idUdadMed, Date fecha,
			Double cantidad) throws Exception {
		return informesLogic.consultarAdicionalManoObra(idCompania, idLabor, idUdadMed, fecha, cantidad);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.consultaServRealizadosMq(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDet(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl, Long centCostId) throws Exception {
		return informesLogic.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial, fechaFinal,
				cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida,
				flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl,   centCostId);

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetPendientesFact(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) throws Exception {
		return informesLogic.consultaServRealizadosEquipoDetPendientesFact(compania, estadoServicio, fechaInicial,
				fechaFinal, cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl);

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaLiqServRealizadosEquipoOperario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.consultaLiqServRealizadosEquipoOperario(compania, fechaInicial, fechaFinal, operador,
				flagOperador, equipo, flagEquipo);
	}

	public List<Nivel4Clientesmq> getNivel4Clientesmq() throws Exception {
		return nivel4ClientesmqLogic.getNivel4Clientesmq();
	}

	public void saveNivel4Clientesmq(Nivel4Clientesmq entity) throws Exception {
		nivel4ClientesmqLogic.saveNivel4Clientesmq(entity);
	}

	public void deleteNivel4Clientesmq(Nivel4Clientesmq entity) throws Exception {
		nivel4ClientesmqLogic.deleteNivel4Clientesmq(entity);
	}

	public void updateNivel4Clientesmq(Nivel4Clientesmq entity) throws Exception {
		nivel4ClientesmqLogic.updateNivel4Clientesmq(entity);
	}

	public Nivel4Clientesmq getNivel4Clientesmq(Long nivel4ClientesmqId) throws Exception {
		Nivel4Clientesmq nivel4Clientesmq = null;

		try {
			nivel4Clientesmq = nivel4ClientesmqLogic.getNivel4Clientesmq(nivel4ClientesmqId);
		} catch (Exception e) {
			throw e;
		}

		return nivel4Clientesmq;
	}

	public List<Nivel4Clientesmq> findByCriteriaInNivel4Clientesmq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return nivel4ClientesmqLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Nivel4Clientesmq> findPageNivel4Clientesmq(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return nivel4ClientesmqLogic.findPageNivel4Clientesmq(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberNivel4Clientesmq() throws Exception {
		return nivel4ClientesmqLogic.findTotalNumberNivel4Clientesmq();
	}

	public List<Nivel4ClientesmqDTO> getDataNivel4Clientesmq() throws Exception {
		return nivel4ClientesmqLogic.getDataNivel4Clientesmq();
	}

	public List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq(Long compania, String hdaId) throws Exception {
		return informesLogic.listaNivel4Clientesmq(compania, hdaId);
	}

	public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdetByNomina(Long idNomina) throws Exception {
		return datNominaTrabajadorMqdetLogic.getDataDatNominaTrabajadorMqdetByNomina(idNomina);
	}

	@Override
	public long consultarConsecutivoConsolidadoNominamq(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoConsolidadoNominamq(compania);
	}

	public Long borrarLiqServRealizadosOperario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.borrarLiqServRealizadosOperario(compania, fechaInicial, fechaFinal);
	}

	public Long interfazLiqServRealizadosEquipoOperario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.interfazLiqServRealizadosEquipoOperario(compania, fechaInicial, fechaFinal, trabajador,
				flagTrabajador, equipo, flagEquipo);
	}

	public String preFecturarServicios(String datservrealizadosequipodetid) throws Exception {
		return informesLogic.preFecturarServicios(datservrealizadosequipodetid);
	}

	public String facturarServicios(String datservrealizadosequipodetid) throws Exception {
		return informesLogic.facturarServicios(datservrealizadosequipodetid);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_reporte_serv_prefacturados(
			String datservrealizadosequipodetid) throws Exception {
		return informesLogic.pr_reporte_serv_prefacturados(datservrealizadosequipodetid);
	}

	public Long actualizarConsecPrefacturaCompania(Long compania) throws Exception {
		return informesLogic.actualizarConsecPrefacturaCompania(compania);
	}

	public List<CajaMenor> getCajaMenor() throws Exception {
		return cajaMenorLogic.getCajaMenor();
	}

	public void saveCajaMenor(CajaMenor entity) throws Exception {
		cajaMenorLogic.saveCajaMenor(entity);
	}

	public void deleteCajaMenor(CajaMenor entity) throws Exception {
		cajaMenorLogic.deleteCajaMenor(entity);
	}

	public void updateCajaMenor(CajaMenor entity) throws Exception {
		cajaMenorLogic.updateCajaMenor(entity);
	}

	public CajaMenor getCajaMenor(Long cajaMenorId) throws Exception {
		CajaMenor cajaMenor = null;

		try {
			cajaMenor = cajaMenorLogic.getCajaMenor(cajaMenorId);
		} catch (Exception e) {
			throw e;
		}

		return cajaMenor;
	}

	public List<CajaMenor> findByCriteriaInCajaMenor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return cajaMenorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<CajaMenor> findPageCajaMenor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return cajaMenorLogic.findPageCajaMenor(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberCajaMenor() throws Exception {
		return cajaMenorLogic.findTotalNumberCajaMenor();
	}

	public List<CajaMenorDTO> getDataCajaMenor() throws Exception {
		return cajaMenorLogic.getDataCajaMenor();
	}

	public List<ConceptoKardex> getConceptoKardex() throws Exception {
		return conceptoKardexLogic.getConceptoKardex();
	}

	public void saveConceptoKardex(ConceptoKardex entity) throws Exception {
		conceptoKardexLogic.saveConceptoKardex(entity);
	}

	public void deleteConceptoKardex(ConceptoKardex entity) throws Exception {
		conceptoKardexLogic.deleteConceptoKardex(entity);
	}

	public void updateConceptoKardex(ConceptoKardex entity) throws Exception {
		conceptoKardexLogic.updateConceptoKardex(entity);
	}

	public ConceptoKardex getConceptoKardex(Long conceptoKardexId) throws Exception {
		ConceptoKardex conceptoKardex = null;

		try {
			conceptoKardex = conceptoKardexLogic.getConceptoKardex(conceptoKardexId);
		} catch (Exception e) {
			throw e;
		}

		return conceptoKardex;
	}

	public List<ConceptoKardex> findByCriteriaInConceptoKardex(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return conceptoKardexLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<ConceptoKardex> findPageConceptoKardex(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return conceptoKardexLogic.findPageConceptoKardex(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberConceptoKardex() throws Exception {
		return conceptoKardexLogic.findTotalNumberConceptoKardex();
	}

	public List<ConceptoKardexDTO> getDataConceptoKardex() throws Exception {
		return conceptoKardexLogic.getDataConceptoKardex();
	}

	public List<DatFacturaServicios> getDatFacturaServicios() throws Exception {
		return datFacturaServiciosLogic.getDatFacturaServicios();
	}

	public void saveDatFacturaServicios(DatFacturaServicios entity) throws Exception {
		datFacturaServiciosLogic.saveDatFacturaServicios(entity);
	}

	public void deleteDatFacturaServicios(DatFacturaServicios entity) throws Exception {
		datFacturaServiciosLogic.deleteDatFacturaServicios(entity);
	}

	public void updateDatFacturaServicios(DatFacturaServicios entity) throws Exception {
		datFacturaServiciosLogic.updateDatFacturaServicios(entity);
	}

	public DatFacturaServicios getDatFacturaServicios(Long datFacturaServiciosId) throws Exception {
		DatFacturaServicios datFacturaServicios = null;

		try {
			datFacturaServicios = datFacturaServiciosLogic.getDatFacturaServicios(datFacturaServiciosId);
		} catch (Exception e) {
			throw e;
		}

		return datFacturaServicios;
	}

	public List<DatFacturaServicios> findByCriteriaInDatFacturaServicios(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datFacturaServiciosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatFacturaServicios> findPageDatFacturaServicios(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datFacturaServiciosLogic.findPageDatFacturaServicios(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatFacturaServicios() throws Exception {
		return datFacturaServiciosLogic.findTotalNumberDatFacturaServicios();
	}

	public List<DatFacturaServiciosDTO> getDataDatFacturaServicios() throws Exception {
		return datFacturaServiciosLogic.getDataDatFacturaServicios();
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_prefacturas_por_cliente(Long clienteId)
			throws Exception {
		return informesLogic.pr_consulta_prefacturas_por_cliente(clienteId);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_cargar_serv_prefact_cliente(Long clienteId,
			String prefactura) throws Exception {
		return informesLogic.pr_cargar_serv_prefact_cliente(clienteId, prefactura);
	}

	public long consec_facturacion_servicios(Long compania) throws Exception {
		return informesLogic.consec_facturacion_servicios(compania);

	}

	public Long actualizarNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura)
			throws Exception {
		return informesLogic.actualizarNumFacturaEnDatServRDet(datservrealizadosequipodetid, numfactura);

	}

	public Long anularNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura) throws Exception {
		return informesLogic.anularNumFacturaEnDatServRDet(datservrealizadosequipodetid, numfactura);

	}

	public List<DatCompraProductos> getDatCompraProductos() throws Exception {
		return datCompraProductosLogic.getDatCompraProductos();
	}

	public void saveDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos,
			Double valorFactura, Double totalSuma) throws Exception {
		datCompraProductosLogic.saveDatCompraProductos(entity, dataDetPrecioProductos, valorFactura, totalSuma);
	}

	public void deleteDatCompraProductos(DatCompraProductos entity) throws Exception {
		datCompraProductosLogic.deleteDatCompraProductos(entity);
	}

	public void updateDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception {
		datCompraProductosLogic.updateDatCompraProductos(entity, dataDetPrecioProductos);
	}

	public DatCompraProductos getDatCompraProductos(Long datCompraProductosId) throws Exception {
		DatCompraProductos datCompraProductos = null;

		try {
			datCompraProductos = datCompraProductosLogic.getDatCompraProductos(datCompraProductosId);
		} catch (Exception e) {
			throw e;
		}

		return datCompraProductos;
	}

	public List<DatCompraProductos> findByCriteriaInDatCompraProductos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datCompraProductosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCompraProductos> findPageDatCompraProductos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datCompraProductosLogic.findPageDatCompraProductos(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatCompraProductos() throws Exception {
		return datCompraProductosLogic.findTotalNumberDatCompraProductos();
	}

	public List<DatCompraProductosDTO> getDataDatCompraProductos() throws Exception {
		return datCompraProductosLogic.getDataDatCompraProductos();
	}

	public List<DatDiferidos> getDatDiferidos() throws Exception {
		return datDiferidosLogic.getDatDiferidos();
	}

	public void saveDatDiferidos(DatDiferidos entity, List<DatDiferidosDetDTO> dataDet,
			List<DatDiferidosCuotasDTO> dataCuotas) throws Exception {
		datDiferidosLogic.saveDatDiferidos(entity, dataDet, dataCuotas);
	}

	public void deleteDatDiferidos(DatDiferidos entity) throws Exception {
		datDiferidosLogic.deleteDatDiferidos(entity);
	}

	public void updateDatDiferidos(DatDiferidos entity, List<DatDiferidosDetDTO> dataDet,
			List<DatDiferidosCuotasDTO> dataCuotas) throws Exception {
		datDiferidosLogic.updateDatDiferidos(entity, dataDet, dataCuotas);
	}

	public DatDiferidos getDatDiferidos(Long datDiferidosId) throws Exception {
		DatDiferidos datDiferidos = null;

		try {
			datDiferidos = datDiferidosLogic.getDatDiferidos(datDiferidosId);
		} catch (Exception e) {
			throw e;
		}

		return datDiferidos;
	}

	public List<DatDiferidos> findByCriteriaInDatDiferidos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datDiferidosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatDiferidos> findPageDatDiferidos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datDiferidosLogic.findPageDatDiferidos(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatDiferidos() throws Exception {
		return datDiferidosLogic.findTotalNumberDatDiferidos();
	}

	public List<DatDiferidosDTO> getDataDatDiferidos() throws Exception {
		return datDiferidosLogic.getDataDatDiferidos();
	}

	public List<DatDiferidosDet> getDatDiferidosDet() throws Exception {
		return datDiferidosDetLogic.getDatDiferidosDet();
	}

	public void saveDatDiferidosDet(DatDiferidosDet entity) throws Exception {
		datDiferidosDetLogic.saveDatDiferidosDet(entity);
	}

	public void deleteDatDiferidosDet(DatDiferidosDet entity) throws Exception {
		datDiferidosDetLogic.deleteDatDiferidosDet(entity);
	}

	public void updateDatDiferidosDet(DatDiferidosDet entity) throws Exception {
		datDiferidosDetLogic.updateDatDiferidosDet(entity);
	}

	public DatDiferidosDet getDatDiferidosDet(Long datDiferidosDetId) throws Exception {
		DatDiferidosDet datDiferidosDet = null;

		try {
			datDiferidosDet = datDiferidosDetLogic.getDatDiferidosDet(datDiferidosDetId);
		} catch (Exception e) {
			throw e;
		}

		return datDiferidosDet;
	}

	public List<DatDiferidosDet> findByCriteriaInDatDiferidosDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datDiferidosDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatDiferidosDet> findPageDatDiferidosDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datDiferidosDetLogic.findPageDatDiferidosDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatDiferidosDet() throws Exception {
		return datDiferidosDetLogic.findTotalNumberDatDiferidosDet();
	}

	public List<DatDiferidosDetDTO> getDataDatDiferidosDet() throws Exception {
		return datDiferidosDetLogic.getDataDatDiferidosDet();
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

	public List<DatPagosNotasClientes> getDatPagosNotasClientes() throws Exception {
		return datPagosNotasClientesLogic.getDatPagosNotasClientes();
	}

	public void saveDatPagosNotasClientes(DatPagosNotasClientes entity) throws Exception {
		datPagosNotasClientesLogic.saveDatPagosNotasClientes(entity);
	}

	public void deleteDatPagosNotasClientes(DatPagosNotasClientes entity) throws Exception {
		datPagosNotasClientesLogic.deleteDatPagosNotasClientes(entity);
	}

	public void updateDatPagosNotasClientes(DatPagosNotasClientes entity) throws Exception {
		datPagosNotasClientesLogic.updateDatPagosNotasClientes(entity);
	}

	public DatPagosNotasClientes getDatPagosNotasClientes(Long datPagosNotasClientesId) throws Exception {
		DatPagosNotasClientes datPagosNotasClientes = null;

		try {
			datPagosNotasClientes = datPagosNotasClientesLogic.getDatPagosNotasClientes(datPagosNotasClientesId);
		} catch (Exception e) {
			throw e;
		}

		return datPagosNotasClientes;
	}

	public List<DatPagosNotasClientes> findByCriteriaInDatPagosNotasClientes(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datPagosNotasClientesLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatPagosNotasClientes> findPageDatPagosNotasClientes(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datPagosNotasClientesLogic.findPageDatPagosNotasClientes(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatPagosNotasClientes() throws Exception {
		return datPagosNotasClientesLogic.findTotalNumberDatPagosNotasClientes();
	}

	public List<DatPagosNotasClientesDTO> getDataDatPagosNotasClientes() throws Exception {
		return datPagosNotasClientesLogic.getDataDatPagosNotasClientes();
	}

	public long consultarConsecutivoDatHerramientas(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatHerramientas(compania);
	}

	public long consultarConsecutivoPagoNotasClientes(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoPagoNotasClientes(compania);
	}

	public long consultarConsecutivoCajaMenor(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoCajaMenor(compania);
	}

	public long consultarConsecutivoDatDiferidos(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatDiferidos(compania);
	}

	public long consultarConsecutivoDatCompraProductos(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatCompraProductos(compania);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_factura_serv_consolidada_detal(String factura)
			throws Exception {
		return informesLogic.pr_consulta_factura_serv_consolidada_detal(factura);

	}

	public String pr_borrar_factura_servicio_consolidada(String numfactura) throws Exception {
		return informesLogic.pr_borrar_factura_servicio_consolidada(numfactura);
	}

	public String pr_reversar_factura_servicio_consolidada_detal(String numfactura) throws Exception {
		return informesLogic.pr_reversar_factura_servicio_consolidada_detal(numfactura);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception {
		return informesLogic.pr_facturas_consolidadas(compania, estadoFactura, fechaInicial, fechaFinal, cliente,
				flagCliente, numFactura);
	}

	public List<ListadoPinesMaquinariaDTO> pr_listado_pines_equipo(Long compania, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.pr_listado_pines_equipo(compania, equipo, flagEquipo);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_factura_vs_pago_realizados(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception {
		return informesLogic.pr_factura_vs_pago_realizados(compania, estadoFactura, fechaInicial, fechaFinal, cliente,
				flagCliente, numFactura);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_cartera_clientes(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception {
		return informesLogic.pr_saldo_cartera_clientes(compania, estadoFactura, fechaInicial, fechaFinal, cliente,
				flagCliente, numFactura);
	}

	public Long pr_borrar_equipos_otros_costosmq(Long idOtrosCostosmq) throws Exception {
		return informesLogic.pr_borrar_equipos_otros_costosmq(idOtrosCostosmq);
	}

	public List<ListaEquiposCategoriaDTO> pr_lista_equipo(Long categoriaid) throws Exception {
		return informesLogic.pr_lista_equipo(categoriaid);
	}

	public List<CostosIndirectosEquipoDTO> pr_otros_costos_maquinaria_saz(Long compania, Date fechaInicial,
			Date fechaFinal, String labor, Long flagLabor, Long documento, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.pr_otros_costos_maquinaria_saz(compania, fechaInicial, fechaFinal, labor, flagLabor,
				documento, equipo, flagEquipo);
	}

	public List<ConsultaCajaMenorDTO> pr_caja_menor(Long compania, Date fechaInicial, Date fechaFinal, String caja,
			Long flagCaja, String equipo, Long flagEquipo, String labor, Long flagLabor, Long consecutivo)
			throws Exception {
		return informesLogic.pr_caja_menor(compania, fechaInicial, fechaFinal, caja, flagCaja, equipo, flagEquipo,
				labor, flagLabor, consecutivo);
	}

	public List<ConsultaCompraProductosDTO> pr_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception {
		return informesLogic.pr_compra_productos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				documento);

	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura,
			Long tipoProducto, String origenDatos) throws Exception {
		return informesLogic.pr_inventario_detalle(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex, conseckardex, factura,
				tipoProducto, origenDatos);
	}

	public List<ConsultaCostosDiferidosDTO> pr_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.pr_dat_diferidos(compania, fechaInicial, fechaFinal);

	}

	public String busquedaNivel4Clientes(String codNivel4C, Long idnivel2C) throws Exception {
		return informesLogic.busquedaNivel4Clientes(codNivel4C, idnivel2C);
	}

	public String busquedaNivel2Clientes(String codNivel2C, Long idpersempr) throws Exception {
		return informesLogic.busquedaNivel2Clientes(codNivel2C, idpersempr);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_facturas_cliente(String numFactura) throws Exception {
		return informesLogic.pr_saldo_facturas_cliente(numFactura);
	}

	public List<DatOtrosMovInventario> getDatOtrosMovInventario() throws Exception {
		return datOtrosMovInventarioLogic.getDatOtrosMovInventario();
	}

	public void saveDatOtrosMovInventario(DatOtrosMovInventario entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception {
		datOtrosMovInventarioLogic.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);
	}

	public void deleteDatOtrosMovInventario(DatOtrosMovInventario entity) throws Exception {
		datOtrosMovInventarioLogic.deleteDatOtrosMovInventario(entity);
	}

	public void updateDatOtrosMovInventario(DatOtrosMovInventario entity,
			List<PrecioPromProdDTO> dataDetPrecioProductos) throws Exception {
		datOtrosMovInventarioLogic.updateDatOtrosMovInventario(entity, dataDetPrecioProductos);
	}

	public DatOtrosMovInventario getDatOtrosMovInventario(Long datOtrosMovInventarioId) throws Exception {
		DatOtrosMovInventario datOtrosMovInventario = null;

		try {
			datOtrosMovInventario = datOtrosMovInventarioLogic.getDatOtrosMovInventario(datOtrosMovInventarioId);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosMovInventario;
	}

	public List<DatOtrosMovInventario> findByCriteriaInDatOtrosMovInventario(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datOtrosMovInventarioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatOtrosMovInventario> findPageDatOtrosMovInventario(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datOtrosMovInventarioLogic.findPageDatOtrosMovInventario(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatOtrosMovInventario() throws Exception {
		return datOtrosMovInventarioLogic.findTotalNumberDatOtrosMovInventario();
	}

	public List<DatOtrosMovInventarioDTO> getDataDatOtrosMovInventario() throws Exception {
		return datOtrosMovInventarioLogic.getDataDatOtrosMovInventario();
	}

	public List<PrecioPromProdDTO> getDataProductosByInventarios(Long datOtrosMovInventarioId) throws Exception {
		return precioPromProdLogic.getDataProductosByInventarios(datOtrosMovInventarioId);
	}

	public List<PrecioPromProdDTO> getDataProductosByCompras(Long datOtrosMovInventarioId) throws Exception {
		return precioPromProdLogic.getDataProductosByCompras(datOtrosMovInventarioId);
	}

	public long consec_otros_mov_inventario(Long compania) throws Exception {
		return informesLogic.consec_otros_mov_inventario(compania);
	}

	public Long pr_reversar_prefactura_servicio(Long clienteId, Long numPrefactura) throws Exception {
		return informesLogic.pr_reversar_prefactura_servicio(clienteId, numPrefactura);
	}

	@Override
	public List<Nivel4ClientesmqDTO> getDataPageNivel4Clientesmq(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return nivel4ClientesmqLogic.findByCriteriaPageNivel4Clientesmq(startRow, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long findTotalNumberNivel4Clientesmq(Map<String, Object> filters) throws Exception {
		return nivel4ClientesmqLogic.findTotalNumberNivel4Clientesmq(filters);
	}

	@Override
	public List<Nivel2ClientesmqDTO> getDataPageNivel2Clientesmq(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		return nivel2ClientesmqLogic.findByCriteriaPageNivel2Clientesmq(startRow, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public Long findTotalNumberNivel2Clientesmq(Map<String, Object> filters) throws Exception {
		return nivel2ClientesmqLogic.findTotalNumberNivel2Clientesmq(filters);
	}

	@Override
	public List<ProntuarioLotesDTO> pr_prontuario_lotes_maquinaria(Long compania, String finca, Long flagFinca,
			String lote, Long flagLote, String proveedor, Long flagProveedor) throws Exception {
		return informesLogic.pr_prontuario_lotes_maquinaria(compania, finca, flagFinca, lote, flagLote, proveedor,
				flagProveedor);
	}

	@Override
	public Double pr_saldo_prom_producto(Long idProducto, Long idAlmacen, Long idCompania) throws Exception {
		return informesLogic.pr_saldo_prom_producto(idProducto, idAlmacen, idCompania);
	}

	@Override
	public List<ConsultaStockMaquinariaDTO> pr_suministros_para_reposicion(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto) throws Exception {
		return informesLogic.pr_suministros_para_reposicion(compania, tipoProducto, flagTipoProducto, producto,
				flagProducto);
	}

	public Long pr_borrar_maq_otros_costosmq(Long idOtrosCostos) throws Exception {
		return informesLogic.pr_borrar_maq_otros_costosmq(idOtrosCostos);
	}

	public void saveDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<ListaEquiposCategoriaDTO> dataDistr) throws Exception {
		datOtrosCostosMqLogic.saveDatOtrosCostosMqVer2(entity, dataMqdet, dataDistr);
	}

	public void updateDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<ListaEquiposCategoriaDTO> dataDistr) throws Exception {
		datOtrosCostosMqLogic.updateDatOtrosCostosMqVer2(entity, dataMqdet, dataDistr);

	}

	public long pr_max_id_unico_dat_compras(Long compania) throws Exception {
		return informesLogic.pr_max_id_unico_dat_compras(compania);
	}

	public long pr_max_id_unico_dat_otros_costos_mq(Long compania) throws Exception {
		return informesLogic.pr_max_id_unico_dat_otros_costos_mq(compania);
	}

	public long pr_max_id_unico_dat_omov_inventario(Long compania) throws Exception {
		return informesLogic.pr_max_id_unico_dat_omov_inventario(compania);
	}

	public Long pr_borrar_suministros_taller(Long id) throws Exception {
		return informesLogic.pr_borrar_suministros_taller(id);
	}

	public Long pr_recalcular_otros_costosmq(Long id_ocostosmq) throws Exception {
		return informesLogic.pr_recalcular_otros_costosmq(id_ocostosmq);
	}

	public Long pr_recalcular_costo_productos(Long id_compras) throws Exception {
		return informesLogic.pr_recalcular_costo_productos(id_compras);
	}

	public Long pr_distri_suministros_taller(Long id_otros_mov_inventario) throws Exception {
		return informesLogic.pr_distri_suministros_taller(id_otros_mov_inventario);
	}

	public List<DatCajaMenor> getDatCajaMenor() throws Exception {
		return datCajaMenorLogic.getDatCajaMenor();
	}

	public void deleteDatCajaMenor(DatCajaMenor entity) throws Exception {
		datCajaMenorLogic.deleteDatCajaMenor(entity);
	}

	public DatCajaMenor getDatCajaMenor(Long datCajaMenorId) throws Exception {
		DatCajaMenor datCajaMenor = null;

		try {
			datCajaMenor = datCajaMenorLogic.getDatCajaMenor(datCajaMenorId);
		} catch (Exception e) {
			throw e;
		}

		return datCajaMenor;
	}

	public List<DatCajaMenor> findByCriteriaInDatCajaMenor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datCajaMenorLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCajaMenor> findPageDatCajaMenor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datCajaMenorLogic.findPageDatCajaMenor(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatCajaMenor() throws Exception {
		return datCajaMenorLogic.findTotalNumberDatCajaMenor();
	}

	public List<DatCajaMenorDTO> getDataDatCajaMenor() throws Exception {
		return datCajaMenorLogic.getDataDatCajaMenor();
	}

	public List<DatCajaMenorDet> getDatCajaMenorDet() throws Exception {
		return datCajaMenorDetLogic.getDatCajaMenorDet();
	}

	public void saveDatCajaMenorDet(DatCajaMenorDet entity) throws Exception {
		datCajaMenorDetLogic.saveDatCajaMenorDet(entity);
	}

	public void deleteDatCajaMenorDet(DatCajaMenorDet entity) throws Exception {
		datCajaMenorDetLogic.deleteDatCajaMenorDet(entity);
	}

	public void updateDatCajaMenorDet(DatCajaMenorDet entity) throws Exception {
		datCajaMenorDetLogic.updateDatCajaMenorDet(entity);
	}

	public DatCajaMenorDet getDatCajaMenorDet(Long datCajaMenordetId) throws Exception {
		DatCajaMenorDet datCajaMenorDet = null;

		try {
			datCajaMenorDet = datCajaMenorDetLogic.getDatCajaMenorDet(datCajaMenordetId);
		} catch (Exception e) {
			throw e;
		}

		return datCajaMenorDet;
	}

	public List<DatCajaMenorDet> findByCriteriaInDatCajaMenorDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datCajaMenorDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCajaMenorDet> findPageDatCajaMenorDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datCajaMenorDetLogic.findPageDatCajaMenorDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatCajaMenorDet() throws Exception {
		return datCajaMenorDetLogic.findTotalNumberDatCajaMenorDet();
	}

	public List<DatCajaMenorDetDTO> getDataDatCajaMenorDet() throws Exception {
		return datCajaMenorDetLogic.getDataDatCajaMenorDet();
	}

	public List<DatCtrlMaqPines> getDatCtrlMaqPines() throws Exception {
		return datCtrlMaqPinesLogic.getDatCtrlMaqPines();
	}

	public void saveDatCtrlMaqPines(DatCtrlMaqPines entity) throws Exception {
		datCtrlMaqPinesLogic.saveDatCtrlMaqPines(entity);
	}

	public void deleteDatCtrlMaqPines(DatCtrlMaqPines entity) throws Exception {
		datCtrlMaqPinesLogic.deleteDatCtrlMaqPines(entity);
	}

	public void updateDatCtrlMaqPines(DatCtrlMaqPines entity) throws Exception {
		datCtrlMaqPinesLogic.updateDatCtrlMaqPines(entity);
	}

	public DatCtrlMaqPines getDatCtrlMaqPines(Long datCtrlMaqPinesId) throws Exception {
		DatCtrlMaqPines datCtrlMaqPines = null;

		try {
			datCtrlMaqPines = datCtrlMaqPinesLogic.getDatCtrlMaqPines(datCtrlMaqPinesId);
		} catch (Exception e) {
			throw e;
		}

		return datCtrlMaqPines;
	}

	public List<DatCtrlMaqPines> findByCriteriaInDatCtrlMaqPines(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datCtrlMaqPinesLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCtrlMaqPines> findPageDatCtrlMaqPines(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datCtrlMaqPinesLogic.findPageDatCtrlMaqPines(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatCtrlMaqPines() throws Exception {
		return datCtrlMaqPinesLogic.findTotalNumberDatCtrlMaqPines();
	}

	public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPines() throws Exception {
		return datCtrlMaqPinesLogic.getDataDatCtrlMaqPines();
	}

	public List<DatReqProductos> getDatReqProductos() throws Exception {
		return datReqProductosLogic.getDatReqProductos();
	}

	public void deleteDatReqProductos(DatReqProductos entity) throws Exception {
		datReqProductosLogic.deleteDatReqProductos(entity);
	}

	public DatReqProductos getDatReqProductos(Long datReqProductosId) throws Exception {
		DatReqProductos datReqProductos = null;

		try {
			datReqProductos = datReqProductosLogic.getDatReqProductos(datReqProductosId);
		} catch (Exception e) {
			throw e;
		}

		return datReqProductos;
	}

	public List<DatReqProductos> findByCriteriaInDatReqProductos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datReqProductosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatReqProductos> findPageDatReqProductos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return datReqProductosLogic.findPageDatReqProductos(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatReqProductos() throws Exception {
		return datReqProductosLogic.findTotalNumberDatReqProductos();
	}

	public List<DatReqProductosDTO> getDataDatReqProductos() throws Exception {
		return datReqProductosLogic.getDataDatReqProductos();
	}

	public List<DatReqProductosDet> getDatReqProductosDet() throws Exception {
		return datReqProductosDetLogic.getDatReqProductosDet();
	}

	public void saveDatReqProductosDet(DatReqProductosDet entity) throws Exception {
		datReqProductosDetLogic.saveDatReqProductosDet(entity);
	}

	public void deleteDatReqProductosDet(DatReqProductosDet entity) throws Exception {
		datReqProductosDetLogic.deleteDatReqProductosDet(entity);
	}

	public void updateDatReqProductosDet(DatReqProductosDet entity) throws Exception {
		datReqProductosDetLogic.updateDatReqProductosDet(entity);
	}

	public DatReqProductosDet getDatReqProductosDet(Long datReqProductosDetId) throws Exception {
		DatReqProductosDet datReqProductosDet = null;

		try {
			datReqProductosDet = datReqProductosDetLogic.getDatReqProductosDet(datReqProductosDetId);
		} catch (Exception e) {
			throw e;
		}

		return datReqProductosDet;
	}

	public List<DatReqProductosDet> findByCriteriaInDatReqProductosDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datReqProductosDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatReqProductosDet> findPageDatReqProductosDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datReqProductosDetLogic.findPageDatReqProductosDet(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatReqProductosDet() throws Exception {
		return datReqProductosDetLogic.findTotalNumberDatReqProductosDet();
	}

	public List<DatReqProductosDetDTO> getDataDatReqProductosDet() throws Exception {
		return datReqProductosDetLogic.getDataDatReqProductosDet();
	}

	public long consec_req_productos(Long compania) throws Exception {
		return informesLogic.consec_req_productos(compania);
	}

	public List<DatReqProductosDetDTO> getDataDatReqProductosDetByProductos(Long datReqProductosId) throws Exception {
		return datReqProductosDetLogic.getDataDatReqProductosDetByProductos(datReqProductosId);
	}

	public List<DatCajaMenorDetDTO> getDataDatCajaMenorDetByCaja(Long datCajaMenorId) throws Exception {
		return datCajaMenorDetLogic.getDataDatCajaMenorDetByCaja(datCajaMenorId);
	}

	public void updateDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception {
		datCajaMenorLogic.updateDatCajaMenor(entity, dataCajaMenor);
	}

	public void saveDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception {
		datCajaMenorLogic.saveDatCajaMenor(entity, dataCajaMenor);
	}

	public void updateDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq) throws Exception {
		datReqProductosLogic.updateDatReqProductos(entity, dataReq);
	}

	public void saveDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq) throws Exception {
		datReqProductosLogic.saveDatReqProductos(entity, dataReq);
	}

	public Long pr_busqueda_maq_ctrpin(Long idEquipo) throws Exception {
		return informesLogic.pr_busqueda_maq_ctrpin(idEquipo);
	}

	public Long pr_actualiza_maq_ctrpin_consecutivo(Long idmaq, Long consecutivoPin) throws Exception {
		return informesLogic.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoPin);
	}

	public Long pr_actualiza_edicion_dat_serv_realizados(Long idmaq, Long consecutivoPin) throws Exception {
		return informesLogic.pr_actualiza_edicion_dat_serv_realizados(idmaq, consecutivoPin);
	}

	public BigDecimal pr_saldo_total_producto(Long idProducto, Long idCompania) throws Exception {
		return informesLogic.pr_saldo_total_producto(idProducto, idCompania);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas_servdetal(Long cliente, String numFactura)
			throws Exception {
		return informesLogic.pr_facturas_consolidadas_servdetal(cliente, numFactura);
	}

	public long consec_plan_serv_mq(Long compania) throws Exception {
		return informesLogic.consec_plan_serv_mq(compania);
	}

	public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdetByPlan(Long datPlanServiciosMqId)
			throws Exception {
		return datPlanServiciosMqdetLogic.getDataDatPlanServiciosMqdetByPlan(datPlanServiciosMqId);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto)
			throws Exception {
		return informesLogic.pr_inventario_saldo_bodega(compania, fechaInicial, fechaFinal, almacen, flagAlmacen,
				tipoProducto, flagTipoProducto);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_salidas(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long tipoProducto) throws Exception {
		return informesLogic.pr_inventario_detalle_salidas(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex,
				conseckardex, tipoProducto);
	}

	public List<ProgramacionLaboresMaqDTO> pr_consulta_prog_labormq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica)
			throws Exception {
		return informesLogic.pr_consulta_prog_labormq(compania, fechaInicial, fechaFinal, cliente, flagCliente, finca,
				flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida, grupoLabor,
				flagGrupoLabor, equipo, flagEquipo, zonageografica, flagZonaGeografica);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_distribuccion_factura(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long factura) throws Exception {
		return informesLogic.pr_distribuccion_factura(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, factura);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_det(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String labor, Long flagLabor, String lote, Long flagLote, Long pinId, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informesLogic.pr_consulta_servrea_det(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, labor, flagLabor, lote, flagLote, pinId, grpLabor, flagGrpLabor);
	}

	public List<ConsultaCompraProductosDTO> pr_lista_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento, String tipoCompra, Long numFactura) throws Exception {
		return informesLogic.pr_lista_compra_productos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				documento, tipoCompra, numFactura);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_labores_implemento(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long pinId) throws Exception {
		return informesLogic.pr_labores_implemento(compania, fechaInicial, fechaFinal, equipo, flagEquipo, pinId);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception {
		return informesLogic.pr_inventario_saldo_producto(compania, fechaInicial, fechaFinal, almacen, flagAlmacen,
				producto, flagProducto);
	}

	public List<ConsultaOtrosMovimientosInventarioDTO> pr_lista_otros_mov_productos(Long compania, Date fechaInicial,
			Date fechaFinal, Long documento, Long maquina,  Long centCost) throws Exception {
		return informesLogic.pr_lista_otros_mov_productos(compania, fechaInicial, fechaFinal, documento, maquina,    centCost);
	}

	public List<ProntuarioLotesDTO> pr_prontuario_haciendas_maquinaria(Long compania, String finca, Long flagFinca,
			String proveedor, Long flagProveedor) throws Exception {
		return informesLogic.pr_prontuario_haciendas_maquinaria(compania, finca, flagFinca, proveedor, flagProveedor);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_auxilio_productividad(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informesLogic.pr_liq_auxilio_productividad(compania, fechaInicial, fechaFinal, operador, flagOperador);
	}

	public Long pr_actualiza_consec_factura_compania(Long compania, Long numfactura) throws Exception {
		return informesLogic.pr_actualiza_consec_factura_compania(compania, numfactura);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_listar_factura_servicios(Long compania, Date fechaInicial,
			Date fechaFinal, Long numFactura) throws Exception {
		return informesLogic.pr_listar_factura_servicios(compania, fechaInicial, fechaFinal, numFactura);
	}

	public List<ConsultaCajaMenorDTO> pr_listar_cajamenor(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost)
			throws Exception {
		return informesLogic.pr_listar_cajamenor(compania, fechaInicial, fechaFinal,   documento,    centCost);

	}

	public List<CostosIndirectosEquipoDTO> pr_listar_otrosmq(Long compania, Date fechaInicial, Date fechaFinal,
			String tipogasto, Long documento, Long centCost, Long proveedor, String numfactura) throws Exception {
		return informesLogic.pr_listar_otrosmq(compania, fechaInicial, fechaFinal, tipogasto,   documento,   centCost,   proveedor,   numfactura);

	}

	public List<PagosNotasClientesDTO> pr_listar_notas_clientes(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.pr_listar_notas_clientes(compania, fechaInicial, fechaFinal);

	}

	public List<CatalogProductoDTO> pr_listar_productos_tipop(Long compania, Long tipoproductoid) throws Exception {
		return informesLogic.pr_listar_productos_tipop(compania, tipoproductoid);

	}

	public List<ProgramacionLaboresMaqDTO> pr_listar_planesmq(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String tipoProy) throws Exception {
		return informesLogic.pr_listar_planesmq(compania, fechaInicial, fechaFinal, supervisor, flagSupervisor, zona,
				flagZona, tipoProy);

	}

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informesLogic.pr_comprobante_pago_nomina(compania, fechaInicial, fechaFinal, operador, flagOperador);

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_servre_maq_interface_ssatelital(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_servre_maq_interface_ssatelital(compania, fechaInicial, fechaFinal, equipo, flagEquipo);

	}

	public List<CatalogProductoDTO> pr_list_productos_inventario(Long compania, String producto, Long flagProducto,
			String tipoProducto, Long flagTipoProducto) throws Exception {
		return informesLogic.pr_list_productos_inventario(compania, producto, flagProducto, tipoProducto,
				flagTipoProducto);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_estus(Long compania, Date fechaInicial,
			Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca, String labor,
			Long flagLabor, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_consulta_servrea_estus(compania, fechaInicial, fechaFinal, cliente, flagCliente, finca,
				flagFinca, labor, flagLabor, equipo, flagEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_numero_pines_por_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_numero_pines_por_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_aux_transporte_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.pr_liq_aux_transporte_operario(compania, fechaInicial, fechaFinal, operador, flagOperador,
				equipo, flagEquipo);

	}

	public Long pr_interfaz_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_interfaz_liq_transporte_operario(compania, fechaInicial, fechaFinal, trabajador,
				flagTrabajador, equipo, flagEquipo);

	}

	public Long pr_borrar_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.pr_borrar_liq_transporte_operario(compania, fechaInicial, fechaFinal);

	}

	public Long pr_borrar_compra(Long idCompra) throws Exception {
		return informesLogic.pr_borrar_compra(idCompra);
	}

	public Long pr_borrar_dat_compra_detalle(Long idCompra) throws Exception {
		return informesLogic.pr_borrar_dat_compra_detalle(idCompra);
	}

	public List<CatalogoPlanRevisionDTO> pr_lista_plan_revision_equipo(Long equipoid) throws Exception {
		return informesLogic.pr_lista_plan_revision_equipo(equipoid);
	}

	public List<CatalogoEquiposDTO> pr_listar_eventos_equipos(Long compania, String equipo, Long flagEquipo,
			String evento, Long flagEvento) throws Exception {
		return informesLogic.pr_listar_eventos_equipos(compania, equipo, flagEquipo, evento, flagEvento);
	}

	public Long pr_borrar_dat_otros_movimientos(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_otros_movimientos(id);
	}

	public Long pr_borrar_dat_otros_movimientos_detalle(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_otros_movimientos_detalle(id);
	}

	public Long pr_borrar_dat_otros_costos_mq(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_otros_costos_mq(id);
	}

	public Long pr_borrar_dat_otros_costos_mq_detalle(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_otros_costos_mq_detalle(id);
	}

	public Long pr_borrar_dat_caja_menor(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_caja_menor(id);
	}

	public Long pr_borrar_dat_caja_menor_detalle(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_caja_menor_detalle(id);
	}

	public Long pr_borrar_dat_pagos_notas_clientes(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_pagos_notas_clientes(id);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro, Long modeloequipo) throws Exception {
		return informesLogic.pr_pyg_equipo(compania, fechaInicial, fechaFinal, equipo, flagEquipo, categoriaEquipo,
				flagCategoriaEquipo, estatusRegistro, modeloequipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo_conceptogasto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) throws Exception {
		return informesLogic.pr_pyg_equipo_conceptogasto(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_costo_labor_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) throws Exception {
		return informesLogic.pr_rendimiento_costo_labor_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) throws Exception {
		return informesLogic.pr_rendimiento_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina_consolidados(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) throws Exception {
		return informesLogic.pr_rendimiento_maquina_consolidados(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_ingresos_vs_costos_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro, String tipoMovimiento) throws Exception {
		return informesLogic.pr_ingresos_vs_costos_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro, tipoMovimiento);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_operarios_maquina_periodo(Long compania, Date fechaInicial,
			Date fechaFinal, String cargo, Long flagCargo, String trabajador, Long flagTrabajador, String equipo,
			Long flagEquipo) throws Exception {
		return informesLogic.pr_operarios_maquina_periodo(compania, fechaInicial, fechaFinal, cargo, flagCargo,
				trabajador, flagTrabajador, equipo, flagEquipo);
	}

	public List<DatOtrosCostosMqdetDistribuccion> getDatOtrosCostosMqdetDistribuccion() throws Exception {
		return datOtrosCostosMqdetDistribuccionLogic.getDatOtrosCostosMqdetDistribuccion();
	}

	public void saveDatOtrosCostosMqdetDistribuccion(DatOtrosCostosMqdetDistribuccion entity) throws Exception {
		datOtrosCostosMqdetDistribuccionLogic.saveDatOtrosCostosMqdetDistribuccion(entity);
	}

	public void deleteDatOtrosCostosMqdetDistribuccion(DatOtrosCostosMqdetDistribuccion entity) throws Exception {
		datOtrosCostosMqdetDistribuccionLogic.deleteDatOtrosCostosMqdetDistribuccion(entity);
	}

	public void updateDatOtrosCostosMqdetDistribuccion(DatOtrosCostosMqdetDistribuccion entity) throws Exception {
		datOtrosCostosMqdetDistribuccionLogic.updateDatOtrosCostosMqdetDistribuccion(entity);
	}

	public DatOtrosCostosMqdetDistribuccion getDatOtrosCostosMqdetDistribuccion(Long datOtrosCostosMqdetDistrId)
			throws Exception {
		DatOtrosCostosMqdetDistribuccion datOtrosCostosMqdetDistribuccion = null;

		try {
			datOtrosCostosMqdetDistribuccion = datOtrosCostosMqdetDistribuccionLogic
					.getDatOtrosCostosMqdetDistribuccion(datOtrosCostosMqdetDistrId);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosCostosMqdetDistribuccion;
	}

	public List<DatOtrosCostosMqdetDistribuccion> findByCriteriaInDatOtrosCostosMqdetDistribuccion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datOtrosCostosMqdetDistribuccionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatOtrosCostosMqdetDistribuccion> findPageDatOtrosCostosMqdetDistribuccion(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datOtrosCostosMqdetDistribuccionLogic.findPageDatOtrosCostosMqdetDistribuccion(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatOtrosCostosMqdetDistribuccion() throws Exception {
		return datOtrosCostosMqdetDistribuccionLogic.findTotalNumberDatOtrosCostosMqdetDistribuccion();
	}

	public List<DatOtrosCostosMqdetDistribuccionDTO> getDataDatOtrosCostosMqdetDistribuccion() throws Exception {
		return datOtrosCostosMqdetDistribuccionLogic.getDataDatOtrosCostosMqdetDistribuccion();
	}

	public List<EquipoImplemento> getEquipoImplemento() throws Exception {
		return equipoImplementoLogic.getEquipoImplemento();
	}

	public void saveEquipoImplemento(EquipoImplemento entity) throws Exception {
		equipoImplementoLogic.saveEquipoImplemento(entity);
	}

	public void deleteEquipoImplemento(EquipoImplemento entity) throws Exception {
		equipoImplementoLogic.deleteEquipoImplemento(entity);
	}

	public void updateEquipoImplemento(EquipoImplemento entity) throws Exception {
		equipoImplementoLogic.updateEquipoImplemento(entity);
	}

	public EquipoImplemento getEquipoImplemento(Long equipoImplementoId) throws Exception {
		EquipoImplemento equipoImplemento = null;

		try {
			equipoImplemento = equipoImplementoLogic.getEquipoImplemento(equipoImplementoId);
		} catch (Exception e) {
			throw e;
		}

		return equipoImplemento;
	}

	public List<EquipoImplemento> findByCriteriaInEquipoImplemento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return equipoImplementoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<EquipoImplemento> findPageEquipoImplemento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return equipoImplementoLogic.findPageEquipoImplemento(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberEquipoImplemento() throws Exception {
		return equipoImplementoLogic.findTotalNumberEquipoImplemento();
	}

	public List<EquipoImplementoDTO> getDataEquipoImplemento() throws Exception {
		return equipoImplementoLogic.getDataEquipoImplemento();
	}

	public List<DatDiferidosDetDTO> getDataDatDiferidosDetByDiferidos(Long datDiferidosId) throws Exception {
		return datDiferidosDetLogic.getDataDatDiferidosDetByDiferidos(datDiferidosId);
	}

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost, Long proveedor, String numfactura)
			throws Exception {
		return informesLogic.pr_listar_dat_diferidos(compania, fechaInicial, fechaFinal,   documento,   centCost, proveedor, numfactura);

	}

	public List<DatDiferidosCuotas> getDatDiferidosCuotas() throws Exception {
		return datDiferidosCuotasLogic.getDatDiferidosCuotas();
	}

	public void saveDatDiferidosCuotas(DatDiferidosCuotas entity) throws Exception {
		datDiferidosCuotasLogic.saveDatDiferidosCuotas(entity);
	}

	public void deleteDatDiferidosCuotas(DatDiferidosCuotas entity) throws Exception {
		datDiferidosCuotasLogic.deleteDatDiferidosCuotas(entity);
	}

	public void updateDatDiferidosCuotas(DatDiferidosCuotas entity) throws Exception {
		datDiferidosCuotasLogic.updateDatDiferidosCuotas(entity);
	}

	public DatDiferidosCuotas getDatDiferidosCuotas(Long datDiferidosCuotasId) throws Exception {
		DatDiferidosCuotas datDiferidosCuotas = null;

		try {
			datDiferidosCuotas = datDiferidosCuotasLogic.getDatDiferidosCuotas(datDiferidosCuotasId);
		} catch (Exception e) {
			throw e;
		}

		return datDiferidosCuotas;
	}

	public List<DatDiferidosCuotas> findByCriteriaInDatDiferidosCuotas(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datDiferidosCuotasLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatDiferidosCuotas> findPageDatDiferidosCuotas(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datDiferidosCuotasLogic.findPageDatDiferidosCuotas(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatDiferidosCuotas() throws Exception {
		return datDiferidosCuotasLogic.findTotalNumberDatDiferidosCuotas();
	}

	public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotas() throws Exception {
		return datDiferidosCuotasLogic.getDataDatDiferidosCuotas();
	}

	public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotasByCuotas(Long datDiferidosId) throws Exception {
		return datDiferidosCuotasLogic.getDataDatDiferidosCuotasByCuotas(datDiferidosId);
	}

	public Long pr_borrar_dat_diferidos(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_diferidos(id);
	}

	public Long pr_borrar_dat_diferidos_det(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_diferidos_det(id);

	}

	public Long pr_borrar_dat_diferidos_cuotas(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_diferidos_cuotas(id);

	}

	public Long pr_borrar_equipos_otros_costosmqdistr(Long id) throws Exception {
		return informesLogic.pr_borrar_equipos_otros_costosmqdistr(id);

	}

	public Long pr_borrar_dat_caja_menor_det_distr(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_caja_menor_det_distr(id);

	}

	public Long pr_borrar_precio_prom_prod_distribuccionmaq(Long id) throws Exception {
		return informesLogic.pr_borrar_precio_prom_prod_distribuccionmaq(id);

	}

	public List<DatOtrosCostosMqdetDistribuccionDTO> getDataDatOtrosCostosMqdetDistribuccionByDistr(
			Long idOtrosCostosMq) throws Exception {
		return datOtrosCostosMqdetDistribuccionLogic.getDataDatOtrosCostosMqdetDistribuccionByDistr(idOtrosCostosMq);

	}

	public List<DatPlanServiciosMqdetEjec> getDatPlanServiciosMqdetEjec() throws Exception {
		return datPlanServiciosMqdetEjecLogic.getDatPlanServiciosMqdetEjec();
	}

	public void saveDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity) throws Exception {
		datPlanServiciosMqdetEjecLogic.saveDatPlanServiciosMqdetEjec(entity);
	}

	public void deleteDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity) throws Exception {
		datPlanServiciosMqdetEjecLogic.deleteDatPlanServiciosMqdetEjec(entity);
	}

	public void updateDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity) throws Exception {
		datPlanServiciosMqdetEjecLogic.updateDatPlanServiciosMqdetEjec(entity);
	}

	public DatPlanServiciosMqdetEjec getDatPlanServiciosMqdetEjec(Long datPlanServiciosMqdetEjecId) throws Exception {
		DatPlanServiciosMqdetEjec datPlanServiciosMqdetEjec = null;

		try {
			datPlanServiciosMqdetEjec = datPlanServiciosMqdetEjecLogic
					.getDatPlanServiciosMqdetEjec(datPlanServiciosMqdetEjecId);
		} catch (Exception e) {
			throw e;
		}

		return datPlanServiciosMqdetEjec;
	}

	public List<DatPlanServiciosMqdetEjec> findByCriteriaInDatPlanServiciosMqdetEjec(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datPlanServiciosMqdetEjecLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatPlanServiciosMqdetEjec> findPageDatPlanServiciosMqdetEjec(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datPlanServiciosMqdetEjecLogic.findPageDatPlanServiciosMqdetEjec(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatPlanServiciosMqdetEjec() throws Exception {
		return datPlanServiciosMqdetEjecLogic.findTotalNumberDatPlanServiciosMqdetEjec();
	}

	public List<DatPlanServiciosMqdetEjecDTO> getDataDatPlanServiciosMqdetEjec() throws Exception {
		return datPlanServiciosMqdetEjecLogic.getDataDatPlanServiciosMqdetEjec();
	}

	public List<ProgramacionLaboresMaqDTO> pr_consulta_estatus_plan_maquinas(Long id_plan_mqdet) throws Exception {
		return informesLogic.pr_consulta_estatus_plan_maquinas(id_plan_mqdet);

	}

	public Double pr_consulta_estatus_area_plan_maquinas(Long id_plan_mqdet) throws Exception {
		return informesLogic.pr_consulta_estatus_area_plan_maquinas(id_plan_mqdet);

	}

	public Long pr_borrar_dat_plan_servicios_mqdet_ejec(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_plan_servicios_mqdet_ejec(id);

	}

	public List<LogDatServRealizadosEquipo> getLogDatServRealizadosEquipo() throws Exception {
		return logDatServRealizadosEquipoLogic.getLogDatServRealizadosEquipo();
	}

	public void saveLogDatServRealizadosEquipo(LogDatServRealizadosEquipo entity) throws Exception {
		logDatServRealizadosEquipoLogic.saveLogDatServRealizadosEquipo(entity);
	}

	public void deleteLogDatServRealizadosEquipo(LogDatServRealizadosEquipo entity) throws Exception {
		logDatServRealizadosEquipoLogic.deleteLogDatServRealizadosEquipo(entity);
	}

	public void updateLogDatServRealizadosEquipo(LogDatServRealizadosEquipo entity) throws Exception {
		logDatServRealizadosEquipoLogic.updateLogDatServRealizadosEquipo(entity);
	}

	public LogDatServRealizadosEquipo getLogDatServRealizadosEquipo(Long logDatServRealizadosEquipoId)
			throws Exception {
		LogDatServRealizadosEquipo logDatServRealizadosEquipo = null;

		try {
			logDatServRealizadosEquipo = logDatServRealizadosEquipoLogic
					.getLogDatServRealizadosEquipo(logDatServRealizadosEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return logDatServRealizadosEquipo;
	}

	public List<LogDatServRealizadosEquipo> findByCriteriaInLogDatServRealizadosEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return logDatServRealizadosEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<LogDatServRealizadosEquipo> findPageLogDatServRealizadosEquipo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return logDatServRealizadosEquipoLogic.findPageLogDatServRealizadosEquipo(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberLogDatServRealizadosEquipo() throws Exception {
		return logDatServRealizadosEquipoLogic.findTotalNumberLogDatServRealizadosEquipo();
	}

	public List<LogDatServRealizadosEquipoDTO> getDataLogDatServRealizadosEquipo() throws Exception {
		return logDatServRealizadosEquipoLogic.getDataLogDatServRealizadosEquipo();
	}

	public List<logServiciosMaqDTO> pr_log_dat_serv_realizados_equipo(Long compania, Long equipoid, Long documento)
			throws Exception {
		return informesLogic.pr_log_dat_serv_realizados_equipo(compania, equipoid, documento);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_ingresos_cero(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId)
			throws Exception {
		return informesLogic.pr_consulta_serv_ingresos_cero(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_limite_cantidad(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Double cantidadmax) throws Exception {
		return informesLogic.pr_consulta_serv_limite_cantidad(compania, estadoServicio, fechaInicial, fechaFinal,
				cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida,
				flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, cantidadmax);
	}

	public void saveDatDiferidosVer2(DatDiferidos entity, List<ListaEquiposCategoriaDTO> dataDistr,
			List<DatDiferidosCuotasDTO> dataCuotas

	) throws Exception {
		datDiferidosLogic.saveDatDiferidosVer2(entity, dataDistr, dataCuotas);
	}

	public void updateDatDiferidosVer2(DatDiferidos entity, List<ListaEquiposCategoriaDTO> dataDistr,
			List<DatDiferidosCuotasDTO> dataCuotas) throws Exception {
		datDiferidosLogic.updateDatDiferidosVer2(entity, dataDistr, dataCuotas);
	}

	public List<CostosIndirectosEquipoDTO> pr_val_existencia_otros_costosmq(String idRegistro) throws Exception {
		return informesLogic.pr_val_existencia_otros_costosmq(idRegistro);
	}

	public List<LaborCcontable> getLaborCcontable() throws Exception {
		return laborCcontableLogic.getLaborCcontable();
	}

	public void saveLaborCcontable(LaborCcontable entity) throws Exception {
		laborCcontableLogic.saveLaborCcontable(entity);
	}

	public void deleteLaborCcontable(LaborCcontable entity) throws Exception {
		laborCcontableLogic.deleteLaborCcontable(entity);
	}

	public void updateLaborCcontable(LaborCcontable entity) throws Exception {
		laborCcontableLogic.updateLaborCcontable(entity);
	}

	public LaborCcontable getLaborCcontable(Long id) throws Exception {
		LaborCcontable laborCcontable = null;

		try {
			laborCcontable = laborCcontableLogic.getLaborCcontable(id);
		} catch (Exception e) {
			throw e;
		}

		return laborCcontable;
	}

	public List<LaborCcontable> findByCriteriaInLaborCcontable(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return laborCcontableLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<LaborCcontable> findPageLaborCcontable(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return laborCcontableLogic.findPageLaborCcontable(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberLaborCcontable() throws Exception {
		return laborCcontableLogic.findTotalNumberLaborCcontable();
	}

	public List<LaborCcontableDTO> getDataLaborCcontable() throws Exception {
		return laborCcontableLogic.getDataLaborCcontable();
	}

	public List<LaborCcontableDTO> getDataLaborCcontableByLabor(Long laborId) throws Exception {
		return laborCcontableLogic.getDataLaborCcontableByLabor(laborId);
	}

	public List<ListaPlanillaNominaDTO> consultarListaPlanillaNomina(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String origen, String estadoplanilla) throws Exception {
		return informesLogic.consultarListaPlanillaNomina(compania, fechaInicial, fechaFinal, planilla, origen,
				estadoplanilla);

	}

	public List<ListaPlanillaNominaDetalladoDTO> reporteLaboresManualesDetalladoRD(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla, String origen, String estadoplanilla) throws Exception {
		return informesLogic.reporteLaboresManualesDetalladoRD(compania, fechaInicial, fechaFinal, planilla, origen,
				estadoplanilla);

	}

	public Long pr_borrar_analisis_lab_detalle(Long id) throws Exception {
		return informesLogic.pr_borrar_analisis_lab_detalle(id);
	}

	public Long pr_borrar_analisis_lab(Long id) throws Exception {
		return informesLogic.pr_borrar_analisis_lab(id);
	}

	public List<DatDiferidosAgricola> getDatDiferidosAgricola() throws Exception {
		return datDiferidosAgricolaLogic.getDatDiferidosAgricola();
	}

	public void saveDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception {
		datDiferidosAgricolaLogic.saveDatDiferidosAgricola(entity, dataDet, dataCuotas);
	}

	public void deleteDatDiferidosAgricola(DatDiferidosAgricola entity) throws Exception {
		datDiferidosAgricolaLogic.deleteDatDiferidosAgricola(entity);
	}

	public void updateDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception {
		datDiferidosAgricolaLogic.updateDatDiferidosAgricola(entity, dataDet, dataCuotas);
	}

	public DatDiferidosAgricola getDatDiferidosAgricola(Long datDiferidosAgricolaId) throws Exception {
		DatDiferidosAgricola datDiferidosAgricola = null;

		try {
			datDiferidosAgricola = datDiferidosAgricolaLogic.getDatDiferidosAgricola(datDiferidosAgricolaId);
		} catch (Exception e) {
			throw e;
		}

		return datDiferidosAgricola;
	}

	public List<DatDiferidosAgricola> findByCriteriaInDatDiferidosAgricola(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datDiferidosAgricolaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatDiferidosAgricola> findPageDatDiferidosAgricola(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datDiferidosAgricolaLogic.findPageDatDiferidosAgricola(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatDiferidosAgricola() throws Exception {
		return datDiferidosAgricolaLogic.findTotalNumberDatDiferidosAgricola();
	}

	public List<DatDiferidosAgricolaDTO> getDataDatDiferidosAgricola() throws Exception {
		return datDiferidosAgricolaLogic.getDataDatDiferidosAgricola();
	}

	public List<DatDiferidosAgricolaDet> getDatDiferidosAgricolaDet() throws Exception {
		return datDiferidosAgricolaDetLogic.getDatDiferidosAgricolaDet();
	}

	public void saveDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity) throws Exception {
		datDiferidosAgricolaDetLogic.saveDatDiferidosAgricolaDet(entity);
	}

	public void deleteDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity) throws Exception {
		datDiferidosAgricolaDetLogic.deleteDatDiferidosAgricolaDet(entity);
	}

	public void updateDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity) throws Exception {
		datDiferidosAgricolaDetLogic.updateDatDiferidosAgricolaDet(entity);
	}

	public DatDiferidosAgricolaDet getDatDiferidosAgricolaDet(Long datDiferidosAgricolaDetId) throws Exception {
		DatDiferidosAgricolaDet datDiferidosAgricolaDet = null;

		try {
			datDiferidosAgricolaDet = datDiferidosAgricolaDetLogic
					.getDatDiferidosAgricolaDet(datDiferidosAgricolaDetId);
		} catch (Exception e) {
			throw e;
		}

		return datDiferidosAgricolaDet;
	}

	public List<DatDiferidosAgricolaDet> findByCriteriaInDatDiferidosAgricolaDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datDiferidosAgricolaDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatDiferidosAgricolaDet> findPageDatDiferidosAgricolaDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datDiferidosAgricolaDetLogic.findPageDatDiferidosAgricolaDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatDiferidosAgricolaDet() throws Exception {
		return datDiferidosAgricolaDetLogic.findTotalNumberDatDiferidosAgricolaDet();
	}

	public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDet() throws Exception {
		return datDiferidosAgricolaDetLogic.getDataDatDiferidosAgricolaDet();
	}

	public void saveDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception {
		datDiferidosAgricolaLogic.saveDatDiferidosAgricolaVer2(entity, dataNivel4, dataCuotas);
	}

	public void updateDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception {
		datDiferidosAgricolaLogic.updateDatDiferidosAgricolaVer2(entity, dataNivel4, dataCuotas);
	}

	public Long pr_borrar_dat_diferidos_agricola(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_diferidos_agricola(id);
	}

	public Long pr_borrar_dat_diferidos_agricola_det(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_diferidos_agricola_det(id);

	}

	public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(
			Long datDiferidosAgricolaId) throws Exception {
		return datDiferidosAgricolaDetLogic
				.getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(datDiferidosAgricolaId);
	}

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos_agricola(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informesLogic.pr_listar_dat_diferidos_agricola(compania, fechaInicial, fechaFinal);

	}

	public long consultarConsecutivoDatDiferidosAgricola(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatDiferidosAgricola(compania);
	}

	public List<DatDiferidosCuotasAgricolas> getDatDiferidosCuotasAgricolas() throws Exception {
		return datDiferidosCuotasAgricolasLogic.getDatDiferidosCuotasAgricolas();
	}

	public void saveDatDiferidosCuotasAgricolas(DatDiferidosCuotasAgricolas entity) throws Exception {
		datDiferidosCuotasAgricolasLogic.saveDatDiferidosCuotasAgricolas(entity);
	}

	public void deleteDatDiferidosCuotasAgricolas(DatDiferidosCuotasAgricolas entity) throws Exception {
		datDiferidosCuotasAgricolasLogic.deleteDatDiferidosCuotasAgricolas(entity);
	}

	public void updateDatDiferidosCuotasAgricolas(DatDiferidosCuotasAgricolas entity) throws Exception {
		datDiferidosCuotasAgricolasLogic.updateDatDiferidosCuotasAgricolas(entity);
	}

	public DatDiferidosCuotasAgricolas getDatDiferidosCuotasAgricolas(Long datDiferidosCuotasAgricolasId)
			throws Exception {
		DatDiferidosCuotasAgricolas datDiferidosCuotasAgricolas = null;

		try {
			datDiferidosCuotasAgricolas = datDiferidosCuotasAgricolasLogic
					.getDatDiferidosCuotasAgricolas(datDiferidosCuotasAgricolasId);
		} catch (Exception e) {
			throw e;
		}

		return datDiferidosCuotasAgricolas;
	}

	public List<DatDiferidosCuotasAgricolas> findByCriteriaInDatDiferidosCuotasAgricolas(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datDiferidosCuotasAgricolasLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatDiferidosCuotasAgricolas> findPageDatDiferidosCuotasAgricolas(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datDiferidosCuotasAgricolasLogic.findPageDatDiferidosCuotasAgricolas(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberDatDiferidosCuotasAgricolas() throws Exception {
		return datDiferidosCuotasAgricolasLogic.findTotalNumberDatDiferidosCuotasAgricolas();
	}

	public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolas() throws Exception {
		return datDiferidosCuotasAgricolasLogic.getDataDatDiferidosCuotasAgricolas();
	}

	public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolasByDatDiferidosAgricola(
			Long datDiferidosAgricolaId) throws Exception {
		return datDiferidosCuotasAgricolasLogic
				.getDataDatDiferidosCuotasAgricolasByDatDiferidosAgricola(datDiferidosAgricolaId);
	}

	public Long pr_borrar_dat_diferidos_cuotas_agricola(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_diferidos_agricola_det(id);

	}

	public List<DatOtrosCostosDTO> pr_listar_otros_costos(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String tipoDistri) throws Exception {
		return informesLogic.pr_listar_otros_costos(compania, fechaInicial, fechaFinal, planilla, tipoDistri);
	}

	public List<DatNominaTrabajadorDTO> pr_lista_dat_nomina_trabajador(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla) throws Exception {
		return informesLogic.pr_lista_dat_nomina_trabajador(compania, fechaInicial, fechaFinal, planilla);
	}

	public List<DatTransProdDTO> pr_listar_produccion(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception {
		return informesLogic.pr_listar_produccion(compania, fechaInicial, fechaFinal, planilla);
	}

	public List<DatPlanLaborDTO> pr_lista_plan_labor(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception {
		return informesLogic.pr_lista_plan_labor(compania, fechaInicial, fechaFinal, planilla);
	}

	public List<PlanRevisionProd> getPlanRevisionProd() throws Exception {
		return planRevisionProdLogic.getPlanRevisionProd();
	}

	public void savePlanRevisionProd(PlanRevisionProd entity) throws Exception {
		planRevisionProdLogic.savePlanRevisionProd(entity);
	}

	public void deletePlanRevisionProd(PlanRevisionProd entity) throws Exception {
		planRevisionProdLogic.deletePlanRevisionProd(entity);
	}

	public void updatePlanRevisionProd(PlanRevisionProd entity) throws Exception {
		planRevisionProdLogic.updatePlanRevisionProd(entity);
	}

	public PlanRevisionProd getPlanRevisionProd(Long planRevisionProdId) throws Exception {
		PlanRevisionProd planRevisionProd = null;

		try {
			planRevisionProd = planRevisionProdLogic.getPlanRevisionProd(planRevisionProdId);
		} catch (Exception e) {
			throw e;
		}

		return planRevisionProd;
	}

	public List<PlanRevisionProd> findByCriteriaInPlanRevisionProd(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return planRevisionProdLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<PlanRevisionProd> findPagePlanRevisionProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return planRevisionProdLogic.findPagePlanRevisionProd(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberPlanRevisionProd() throws Exception {
		return planRevisionProdLogic.findTotalNumberPlanRevisionProd();
	}

	public List<PlanRevisionProdDTO> getDataPlanRevisionProd() throws Exception {
		return planRevisionProdLogic.getDataPlanRevisionProd();
	}

	public List<PlanRevisionProdDTO> getDataPlanRevisionProdByPlanRevision(Long planRecursoId) throws Exception {
		return planRevisionProdLogic.getDataPlanRevisionProdByPlanRevision(planRecursoId);
	}

	public List<PuntosLubricacion> getPuntosLubricacion() throws Exception {
		return puntosLubricacionLogic.getPuntosLubricacion();
	}

	public void savePuntosLubricacion(PuntosLubricacion entity) throws Exception {
		puntosLubricacionLogic.savePuntosLubricacion(entity);
	}

	public void deletePuntosLubricacion(PuntosLubricacion entity) throws Exception {
		puntosLubricacionLogic.deletePuntosLubricacion(entity);
	}

	public void updatePuntosLubricacion(PuntosLubricacion entity) throws Exception {
		puntosLubricacionLogic.updatePuntosLubricacion(entity);
	}

	public PuntosLubricacion getPuntosLubricacion(Long puntoLubricacionId) throws Exception {
		PuntosLubricacion puntosLubricacion = null;

		try {
			puntosLubricacion = puntosLubricacionLogic.getPuntosLubricacion(puntoLubricacionId);
		} catch (Exception e) {
			throw e;
		}

		return puntosLubricacion;
	}

	public List<PuntosLubricacion> findByCriteriaInPuntosLubricacion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return puntosLubricacionLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<PuntosLubricacion> findPagePuntosLubricacion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return puntosLubricacionLogic.findPagePuntosLubricacion(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberPuntosLubricacion() throws Exception {
		return puntosLubricacionLogic.findTotalNumberPuntosLubricacion();
	}

	public List<PuntosLubricacionDTO> getDataPuntosLubricacion() throws Exception {
		return puntosLubricacionLogic.getDataPuntosLubricacion();
	}

	public List<DatCheckListEquipo> getDatCheckListEquipo() throws Exception {
		return datCheckListEquipoLogic.getDatCheckListEquipo();
	}

	public void saveDatCheckListEquipo(DatCheckListEquipo entity,
			List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
			List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet) throws Exception {
		datCheckListEquipoLogic.saveDatCheckListEquipo(entity, dataDatCheckListEquipoLabor, dataDatCheckListEquipoDet);
	}

	public void deleteDatCheckListEquipo(DatCheckListEquipo entity) throws Exception {
		datCheckListEquipoLogic.deleteDatCheckListEquipo(entity);
	}

	public void updateDatCheckListEquipo(DatCheckListEquipo entity,
			List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
			List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet) throws Exception {
		datCheckListEquipoLogic.updateDatCheckListEquipo(entity, dataDatCheckListEquipoLabor,
				dataDatCheckListEquipoDet);
	}

	public DatCheckListEquipo getDatCheckListEquipo(Long datCheckListEquipoId) throws Exception {
		DatCheckListEquipo datCheckListEquipo = null;

		try {
			datCheckListEquipo = datCheckListEquipoLogic.getDatCheckListEquipo(datCheckListEquipoId);
		} catch (Exception e) {
			throw e;
		}

		return datCheckListEquipo;
	}

	public List<DatCheckListEquipo> findByCriteriaInDatCheckListEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return datCheckListEquipoLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCheckListEquipo> findPageDatCheckListEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datCheckListEquipoLogic.findPageDatCheckListEquipo(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatCheckListEquipo() throws Exception {
		return datCheckListEquipoLogic.findTotalNumberDatCheckListEquipo();
	}

	public List<DatCheckListEquipoDTO> getDataDatCheckListEquipo() throws Exception {
		return datCheckListEquipoLogic.getDataDatCheckListEquipo();
	}

	public List<DatCheckListEquipoDet> getDatCheckListEquipoDet() throws Exception {
		return datCheckListEquipoDetLogic.getDatCheckListEquipoDet();
	}

	public void saveDatCheckListEquipoDet(DatCheckListEquipoDet entity) throws Exception {
		datCheckListEquipoDetLogic.saveDatCheckListEquipoDet(entity);
	}

	public void deleteDatCheckListEquipoDet(DatCheckListEquipoDet entity) throws Exception {
		datCheckListEquipoDetLogic.deleteDatCheckListEquipoDet(entity);
	}

	public void updateDatCheckListEquipoDet(DatCheckListEquipoDet entity) throws Exception {
		datCheckListEquipoDetLogic.updateDatCheckListEquipoDet(entity);
	}

	public DatCheckListEquipoDet getDatCheckListEquipoDet(Long datCheckListEquipoDetId) throws Exception {
		DatCheckListEquipoDet datCheckListEquipoDet = null;

		try {
			datCheckListEquipoDet = datCheckListEquipoDetLogic.getDatCheckListEquipoDet(datCheckListEquipoDetId);
		} catch (Exception e) {
			throw e;
		}

		return datCheckListEquipoDet;
	}

	public List<DatCheckListEquipoDet> findByCriteriaInDatCheckListEquipoDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datCheckListEquipoDetLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCheckListEquipoDet> findPageDatCheckListEquipoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datCheckListEquipoDetLogic.findPageDatCheckListEquipoDet(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatCheckListEquipoDet() throws Exception {
		return datCheckListEquipoDetLogic.findTotalNumberDatCheckListEquipoDet();
	}

	public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDet() throws Exception {
		return datCheckListEquipoDetLogic.getDataDatCheckListEquipoDet();
	}

	public List<DatCheckListEquipoLabor> getDatCheckListEquipoLabor() throws Exception {
		return datCheckListEquipoLaborLogic.getDatCheckListEquipoLabor();
	}

	public void saveDatCheckListEquipoLabor(DatCheckListEquipoLabor entity) throws Exception {
		datCheckListEquipoLaborLogic.saveDatCheckListEquipoLabor(entity);
	}

	public void deleteDatCheckListEquipoLabor(DatCheckListEquipoLabor entity) throws Exception {
		datCheckListEquipoLaborLogic.deleteDatCheckListEquipoLabor(entity);
	}

	public void updateDatCheckListEquipoLabor(DatCheckListEquipoLabor entity) throws Exception {
		datCheckListEquipoLaborLogic.updateDatCheckListEquipoLabor(entity);
	}

	public DatCheckListEquipoLabor getDatCheckListEquipoLabor(Long datCheckListEquipoLaborId) throws Exception {
		DatCheckListEquipoLabor datCheckListEquipoLabor = null;

		try {
			datCheckListEquipoLabor = datCheckListEquipoLaborLogic
					.getDatCheckListEquipoLabor(datCheckListEquipoLaborId);
		} catch (Exception e) {
			throw e;
		}

		return datCheckListEquipoLabor;
	}

	public List<DatCheckListEquipoLabor> findByCriteriaInDatCheckListEquipoLabor(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datCheckListEquipoLaborLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCheckListEquipoLabor> findPageDatCheckListEquipoLabor(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datCheckListEquipoLaborLogic.findPageDatCheckListEquipoLabor(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatCheckListEquipoLabor() throws Exception {
		return datCheckListEquipoLaborLogic.findTotalNumberDatCheckListEquipoLabor();
	}

	public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLabor() throws Exception {
		return datCheckListEquipoLaborLogic.getDataDatCheckListEquipoLabor();
	}

	public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDetByCheckList(Long datCheckListEquipoId)
			throws Exception {
		return datCheckListEquipoDetLogic.getDataDatCheckListEquipoDetByCheckList(datCheckListEquipoId);
	}

	public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLaborByEquipo(Long checkListEquipoId)
			throws Exception {
		return datCheckListEquipoLaborLogic.getDataDatCheckListEquipoLaborByEquipo(checkListEquipoId);
	}

	public List<ExportarPlanRevisionDTO> exportarPlanRevisionExcel(Long compania, String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception {
		return informesLogic.exportarPlanRevisionExcel(compania, modulo, flagPlanRevision, planSeleccionados);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaNivel4DTO> pr_lista_nivel4_filtro_nivel3(String nivel3Id) throws Exception {
		return informesLogic.pr_lista_nivel4_filtro_nivel3(nivel3Id);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaNivel4DTO> listaCodigosErp(String nivel3Id) throws Exception {
		return informesLogic.listaCodigosErp(nivel3Id);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long pr_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal, Long usuarioId) {
		return informesLogic.pr_liquidar_planilla_nomina_periodo(compania, fechaInicial, fechaFinal, usuarioId);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long pr_re_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal,
			Long usuarioId) {
		return informesLogic.pr_re_liquidar_planilla_nomina_periodo(compania, fechaInicial, fechaFinal, usuarioId);

	}

	public List<DatOtrosCostosDetalle> getDatOtrosCostosDetalle() throws Exception {
		return datOtrosCostosDetalleLogic.getDatOtrosCostosDetalle();
	}

	public void saveDatOtrosCostosDetalle(DatOtrosCostosDetalle entity) throws Exception {
		datOtrosCostosDetalleLogic.saveDatOtrosCostosDetalle(entity);
	}

	public void deleteDatOtrosCostosDetalle(DatOtrosCostosDetalle entity) throws Exception {
		datOtrosCostosDetalleLogic.deleteDatOtrosCostosDetalle(entity);
	}

	public void updateDatOtrosCostosDetalle(DatOtrosCostosDetalle entity) throws Exception {
		datOtrosCostosDetalleLogic.updateDatOtrosCostosDetalle(entity);
	}

	public DatOtrosCostosDetalle getDatOtrosCostosDetalle(Long datOtrosCostosDetId) throws Exception {
		DatOtrosCostosDetalle datOtrosCostosDetalle = null;

		try {
			datOtrosCostosDetalle = datOtrosCostosDetalleLogic.getDatOtrosCostosDetalle(datOtrosCostosDetId);
		} catch (Exception e) {
			throw e;
		}

		return datOtrosCostosDetalle;
	}

	public List<DatOtrosCostosDetalle> findByCriteriaInDatOtrosCostosDetalle(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datOtrosCostosDetalleLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatOtrosCostosDetalle> findPageDatOtrosCostosDetalle(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datOtrosCostosDetalleLogic.findPageDatOtrosCostosDetalle(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatOtrosCostosDetalle() throws Exception {
		return datOtrosCostosDetalleLogic.findTotalNumberDatOtrosCostosDetalle();
	}

	public List<DatOtrosCostosDetalleDTO> getDataDatOtrosCostosDetalle() throws Exception {
		return datOtrosCostosDetalleLogic.getDataDatOtrosCostosDetalle();
	}

	public List<DatOtrosCostosDetalleDTO> getDataDatOtrosCostosDetalleByOtrosCostos(Long idOtrosCostos)
			throws Exception {
		return datOtrosCostosDetalleLogic.getDataDatOtrosCostosDetalleByOtrosCostos(idOtrosCostos);
	}

	public List<NominaDetalladaDTO> pr_desprendible_pago_agricola(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajadorId, Long flagTrabajador) throws Exception {
		return informesLogic.pr_desprendible_pago_agricola(compania, fechaInicial, fechaFinal, trabajadorId,
				flagTrabajador);
	}

	public List<ConsultaDiferidosDTO> pr_dat_diferidos_agricolas(Long compania, Date fechaInicial, Date fechaFinal,
			String hacienda, Long flagHacienda, String lote, Long flagLote) throws Exception {
		return informesLogic.pr_dat_diferidos_agricolas(compania, fechaInicial, fechaFinal, hacienda, flagHacienda,
				lote, flagLote);
	}

	public List<ListaProduccionDTO> pr_listar_reg_produccion(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String hacienda, Long flagHacienda, String lote, Long flagLote) throws Exception {
		return informesLogic.pr_listar_reg_produccion(compania, fechaInicial, fechaFinal, planilla, hacienda,
				flagHacienda, lote, flagLote);
	}

	public List<CostosTotalesDTO> pr_costos_ingresos_compania_detallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1)
			throws Exception {
		return informesLogic.pr_costos_ingresos_compania_detallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas,
				origenDatos1);
	}

	public List<CostosTotalesDTO> pr_costos_detallado(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception {
		return informesLogic.pr_costos_detallado(compania, fechaInicial, fechaFinal, zona, flagZona, finca, flagFinca,
				bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, origenDatos1);
	}

	public List<CostosTotalesDTO> pr_costos_ingresos_lotes_cosechados_periodo_det(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1,
			String grpLabor, Long flagGrpLabor) throws Exception {
		return informesLogic.pr_costos_ingresos_lotes_cosechados_periodo_det(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas,
				origenDatos1, grpLabor, flagGrpLabor);
	}

	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1)
			throws Exception {
		return informesLogic.pr_costos_resumen_labor_grupo(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, origenDatos1);
	}

	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo_lotes_cosechados(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1,
			String grpLabor, Long flagGrpLabor) throws Exception {
		return informesLogic.pr_costos_resumen_labor_grupo_lotes_cosechados(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas,
				origenDatos1, grpLabor, flagGrpLabor);
	}

	public List<CosechasLoteDTO> pr_pyg_lotes_cosechados(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception {
		return informesLogic.pr_pyg_lotes_cosechados(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, origenDatos1);
	}

	public Long pr_borrar_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.pr_borrar_cierre_costos_agricolas(compania, fechaInicial, fechaFinal);
	}

	public Long pr_interfaz_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.pr_interfaz_cierre_costos_agricolas(compania, fechaInicial, fechaFinal);
	}

	public List<CostosTotalesDTO> pr_costo_parcial_detallado(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor,
			Long diaslabor) throws Exception {
		return informesLogic.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor, diaslabor);

	}

	public List<CostosTotalesDTO> pr_costo_parcial_resumen(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informesLogic.pr_costo_parcial_resumen(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor);

	}

	public List<CostosTotalesDTO> pr_costo_lotes_cerrados(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informesLogic.pr_costo_lotes_cerrados(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor);

	}

	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) throws Exception {
		return informesLogic.pr_costos_produccion_lote_cerrado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, flagNumeroCosechas);

	}

	public List<ProduccionAcumFincaDTO> pr_produccion_lote_cerrado(Long compania, Date fecha_inicial, Date fecha_final,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) throws Exception {
		return informesLogic.pr_produccion_lote_cerrado(compania, fecha_inicial, fecha_final, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, flagNumeroCosechas);

	}

	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado_corte(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, Long flagNumeroCosechas) throws Exception {
		return informesLogic.pr_costos_produccion_lote_cerrado_corte(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, flagNumeroCosechas);

	}

	public List<CostosTotalesDTO> pr_costo_parcial_resumen_labor(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informesLogic.pr_costo_parcial_resumen_labor(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor);

	}

	public List<CostosTotalesDTO> pr_costo_parcial_resumen_lote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor,
			Long diaslabor) throws Exception {
		return informesLogic.pr_costo_parcial_resumen_lote(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor, diaslabor);

	}

	public List<ConsolidadoNominaDTO> pr_mo_desprendible_pago(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador) {
		return informesLogic.pr_mo_desprendible_pago(compania, fechaInicial, fechaFinal, trabajador, flagTrabajador);
	}

	public List<CuadroPrecipitacionDiariaDTO> pr_comportamiento_lluvias(Long compania, Date fechaInicial,
			Date fechaFinal, String estPluvio, Long flagEstPluvio) throws Exception {
		return informesLogic.pr_comportamiento_lluvias(compania, fechaInicial, fechaFinal, estPluvio, flagEstPluvio);
	}

	public List<ListaNivel4DTO> pr_lista_etapas_lotes_cosechados(Long compania, Long idnivel4) throws Exception {
		return informesLogic.pr_lista_etapas_lotes_cosechados(compania, idnivel4);
	}

	public Long pr_asociar_reg_produccion_costos(Long idLote, Long idEtapa, Long reg_produccion_id, Long idCiclo)
			throws Exception {
		return informesLogic.pr_asociar_reg_produccion_costos(idLote, idEtapa, reg_produccion_id, idCiclo);
	}

	public Long pr_reabrir_cosecha_costos(Long idLote, Long idEtapa, Long reg_produccion_id, Long idCiclo)
			throws Exception {
		return informesLogic.pr_reabrir_cosecha_costos(idLote, idEtapa, reg_produccion_id, idCiclo);
	}

	public Double pr_ultimo_valor_compra_producto(Long idProducto) throws Exception {
		return informesLogic.pr_ultimo_valor_compra_producto(idProducto);
	}

	public Long pr_recalculo_vr_hora_maquina(Long companiaid, Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.pr_recalculo_vr_hora_maquina(companiaid, fechaInicial, fechaFinal);
	}

	@Override
	public List<PrecioPromProdDTO> getDataProductosByServRealizados(Long datServRealizadosEquipoId) throws Exception {
		return precioPromProdLogic.getDataProductosByServRealizados(datServRealizadosEquipoId);
	}

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception {
		return informesLogic.pr_comprobante_pago_nomina_maq_destajo(compania, fechaInicial, fechaFinal, operador,
				flagOperador, tipoNomina);
	}

	public Long pr_borrar_dat_servicio_equipo(Long idServicio) throws Exception {
		return informesLogic.pr_borrar_dat_servicio_equipo(idServicio);
	}

	public Long pr_borrar_dat_servicio_equipo_det(Long idServicio) throws Exception {
		return informesLogic.pr_borrar_dat_servicio_equipo_det(idServicio);

	}

	public Long pr_borrar_serv_producto(Long idServicio) throws Exception {
		return informesLogic.pr_borrar_serv_producto(idServicio);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long categoria) throws Exception {
		return informesLogic.pr_consumo_combustible_rdl(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoria);
	}

	public long pr_ultima_planilla_servicios_maq(Long compania, Date fecha, Long maquina, Long operarioId)
			throws Exception {
		return informesLogic.pr_ultima_planilla_servicios_maq(compania, fecha, maquina, operarioId);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_importacion_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura, Long usuario, String equipo, Long flagEquipo, String tipomovimiento) throws Exception {
		return informesLogic.pr_inventario_detalle_importacion_movil(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex,
				conseckardex, factura, usuario, equipo, flagEquipo, tipomovimiento);
	}

	public String pr_importar_salidas_movil_enproceso(String precioprodid, String tipomovimiento) {
		return informesLogic.pr_importar_salidas_movil_enproceso(precioprodid, tipomovimiento);
	}

	public long pr_ultima_programa_labores_maq(Long compania, Date fecha, Long cliente, Long supervisorId)
			throws Exception {
		return informesLogic.pr_ultima_programa_labores_maq(compania, fecha, cliente, supervisorId);
	}

	public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPinesFiltroEquipo(Long equipoId) throws Exception {
		return datCtrlMaqPinesLogic.getDataDatCtrlMaqPinesFiltroEquipo(equipoId);

	}

	public List<UbicacionesAlmacen> getUbicacionesAlmacen() throws Exception {
		return ubicacionesAlmacenLogic.getUbicacionesAlmacen();
	}

	public void saveUbicacionesAlmacen(UbicacionesAlmacen entity) throws Exception {
		ubicacionesAlmacenLogic.saveUbicacionesAlmacen(entity);
	}

	public void deleteUbicacionesAlmacen(UbicacionesAlmacen entity) throws Exception {
		ubicacionesAlmacenLogic.deleteUbicacionesAlmacen(entity);
	}

	public void updateUbicacionesAlmacen(UbicacionesAlmacen entity) throws Exception {
		ubicacionesAlmacenLogic.updateUbicacionesAlmacen(entity);
	}

	public UbicacionesAlmacen getUbicacionesAlmacen(Long ubicacionesAlmacenId) throws Exception {
		UbicacionesAlmacen ubicacionesAlmacen = null;

		try {
			ubicacionesAlmacen = ubicacionesAlmacenLogic.getUbicacionesAlmacen(ubicacionesAlmacenId);
		} catch (Exception e) {
			throw e;
		}

		return ubicacionesAlmacen;
	}

	public List<UbicacionesAlmacen> findByCriteriaInUbicacionesAlmacen(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return ubicacionesAlmacenLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<UbicacionesAlmacen> findPageUbicacionesAlmacen(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return ubicacionesAlmacenLogic.findPageUbicacionesAlmacen(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberUbicacionesAlmacen() throws Exception {
		return ubicacionesAlmacenLogic.findTotalNumberUbicacionesAlmacen();
	}

	public List<UbicacionesAlmacenDTO> getDataUbicacionesAlmacen() throws Exception {
		return ubicacionesAlmacenLogic.getDataUbicacionesAlmacen();
	}

	public List<DatMantenimientoEquipoPlanRevision> getDatMantenimientoEquipoPlanRevision() throws Exception {
		return datMantenimientoEquipoPlanRevisionLogic.getDatMantenimientoEquipoPlanRevision();
	}

	public void saveDatMantenimientoEquipoPlanRevision(DatMantenimientoEquipoPlanRevision entity) throws Exception {
		datMantenimientoEquipoPlanRevisionLogic.saveDatMantenimientoEquipoPlanRevision(entity);
	}

	public void deleteDatMantenimientoEquipoPlanRevision(DatMantenimientoEquipoPlanRevision entity) throws Exception {
		datMantenimientoEquipoPlanRevisionLogic.deleteDatMantenimientoEquipoPlanRevision(entity);
	}

	public void updateDatMantenimientoEquipoPlanRevision(DatMantenimientoEquipoPlanRevision entity) throws Exception {
		datMantenimientoEquipoPlanRevisionLogic.updateDatMantenimientoEquipoPlanRevision(entity);
	}

	public DatMantenimientoEquipoPlanRevision getDatMantenimientoEquipoPlanRevision(Long datManPlanRevivionId)
			throws Exception {
		DatMantenimientoEquipoPlanRevision datMantenimientoEquipoPlanRevision = null;

		try {
			datMantenimientoEquipoPlanRevision = datMantenimientoEquipoPlanRevisionLogic
					.getDatMantenimientoEquipoPlanRevision(datManPlanRevivionId);
		} catch (Exception e) {
			throw e;
		}

		return datMantenimientoEquipoPlanRevision;
	}

	public List<DatMantenimientoEquipoPlanRevision> findByCriteriaInDatMantenimientoEquipoPlanRevision(
			Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datMantenimientoEquipoPlanRevisionLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<DatMantenimientoEquipoPlanRevision> findPageDatMantenimientoEquipoPlanRevision(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datMantenimientoEquipoPlanRevisionLogic.findPageDatMantenimientoEquipoPlanRevision(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatMantenimientoEquipoPlanRevision() throws Exception {
		return datMantenimientoEquipoPlanRevisionLogic.findTotalNumberDatMantenimientoEquipoPlanRevision();
	}

	public List<DatMantenimientoEquipoPlanRevisionDTO> getDataDatMantenimientoEquipoPlanRevision() throws Exception {
		return datMantenimientoEquipoPlanRevisionLogic.getDataDatMantenimientoEquipoPlanRevision();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<SolicitudesMttoEquipoDTO> pr_formato_impresion_ot(Long compania, Date fechaInicial, Date fechaFinal,
			String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) throws Exception {
		return informesLogic.pr_formato_impresion_ot(compania, fechaInicial, fechaFinal, propietario, flagPropietario,
				equipo, flagEquipo, tipoMtto, flagTipoMtto, idMtto);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_consumo_combustible_rdl_resumen_maq(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq_labor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_consumo_combustible_rdl_resumen_maq_labor(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_labor(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_consumo_combustible_rdl_resumen_labor(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_hda(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_consumo_combustible_rdl_resumen_hda(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_importacion_movil_formato_dia(Long compania,
			Date fechaInicial, Date fechaFinal, Long flagAlmacen) throws Exception {

		return informesLogic.pr_inventario_importacion_movil_formato_dia(compania, fechaInicial, fechaFinal,
				flagAlmacen);
	}

	public List<DatMantenimientoEquipoPlanRevisionDTO> getDataDatMantenimientoEquipoPlanRevisionByMec(
			Long mantenimientoEquipoId) throws Exception {
		return datMantenimientoEquipoPlanRevisionLogic
				.getDataDatMantenimientoEquipoPlanRevisionByMec(mantenimientoEquipoId);
	}

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquiposPorVencer(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos, String estadoplan)
			throws Exception {
		return informesLogic.consultarListaProximosMttoEquiposPorVencer(compania, equipo, flagEquipo, planRevision,
				flagPlanRevision, origenDatos, estadoplan);
	}

	public Long pr_actualizar_plan_revision_det(Long idequipo, Date fecha_ult_serv, Double horas, Double km,
			String planes, String estadoPlan) throws Exception {
		return informesLogic.pr_actualizar_plan_revision_det(idequipo, fecha_ult_serv, horas, km, planes, estadoPlan);
	}

	public List<ProgMttoPreventivosMaqDTO> pr_ordenes_trabajao_mtto_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String responsableMtto, Long flagResponsable,
			Long consecutivoOt, String estado_ot ,Long centCost, String tipoOrden) throws Exception {
		return informesLogic.pr_ordenes_trabajao_mtto_maq(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				responsableMtto, flagResponsable, consecutivoOt, estado_ot,   centCost, tipoOrden);
	}

	public List<ProgLaboresMecMaqDTO> pr_lista_prog_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String cliente, Long flagCliente,
			String hacienda, Long flagHacienda, Long consecutivoOt, String labor, Long flagLabor, String grupoLabor,
			Long flagGrupoLabor, String finalizado, Double porc_avance) throws Exception {
		return informesLogic.pr_lista_prog_maquinaria(compania, fechaInicial, fechaFinal, supervisor, flagSupervisor,
				zona, flagZona, cliente, flagCliente, hacienda, flagHacienda, consecutivoOt, labor, flagLabor,
				grupoLabor, flagGrupoLabor, finalizado, porc_avance);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception {
		return informesLogic.pr_inventario_saldo_producto_ubicacion(compania, fechaInicial, fechaFinal, almacen,
				flagAlmacen, producto, flagProducto);
	}

	public List<ProgMttoPreventivosMaqDTO> pr_ordenes_trabajao_mtto_maq_detalle(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String responsableMtto, Long flagResponsable,
			Long consecutivoOt, String tipoOrden) throws Exception {
		return informesLogic.pr_ordenes_trabajao_mtto_maq_detalle(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo, responsableMtto, flagResponsable, consecutivoOt, tipoOrden);
	}

	public Long pr_actualizar_prog_maquinaria(Long idprogramacion) throws Exception {
		return informesLogic.pr_actualizar_prog_maquinaria(idprogramacion);
	}

	public Long pr_borrar_dat_plan_servicios_mq(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_plan_servicios_mq(id);
	}

	public Long pr_borrar_dat_plan_servicios_mqdet(Long id) throws Exception {
		return informesLogic.pr_borrar_dat_plan_servicios_mqdet(id);
	}

	public Long pr_act_prog_dat_serv_realizados_equipo_det(Long id) throws Exception {
		return informesLogic.pr_act_prog_dat_serv_realizados_equipo_det(id);
	}

	public List<ListaLaboresDTO> pr_lista_labores(Long compania, String grupoLabor) throws Exception {
		return informesLogic.pr_lista_labores(compania, grupoLabor);
	}

	public Double pr_ult_horo_odometro_tanqueo(Long compania, Long idMaq) throws Exception {
		return informesLogic.pr_ult_horo_odometro_tanqueo(compania, idMaq);
	}

	public List<ImportarNominaEmpAdmonDTO> pr_nomina_empleados_administrativos(Long compania, Date fechaInicial,
			Date fechaFinal, String tiponomina) throws Exception {
		return informesLogic.pr_nomina_empleados_administrativos(compania, fechaInicial, fechaFinal, tiponomina);
	}

	public List<SolicitudesMttoEquipoDTO> pr_hoja_vida_maquina(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_hoja_vida_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ProgramacionLaboresMaqDTO> pr_avance_proyectos_maq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica)
			throws Exception {
		return informesLogic.pr_avance_proyectos_maq(compania, fechaInicial, fechaFinal, cliente, flagCliente, finca,
				flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida, grupoLabor,
				flagGrupoLabor, equipo, flagEquipo, zonageografica, flagZonaGeografica);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoCosto) throws Exception {
		return informesLogic.pr_distribuccion_ingresos_equipos(compania, fechaInicial, fechaFinal, tipoCosto);

	}

	public Long pr_borrar_distribuccion_costos_ind_maquina(Long compania, Date fechaInicial, Date fechaFinal,
			String origen) throws Exception {
		return informesLogic.pr_borrar_distribuccion_costos_ind_maquina(compania, fechaInicial, fechaFinal, origen);

	}

	public Long pr_insert_distribuccion_ingresos_equipos(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String origen) throws Exception {
		return informesLogic.pr_insert_distribuccion_ingresos_equipos(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo, origen);

	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception {
		return informesLogic.pr_inventario_saldo_producto_movil(compania, fechaInicial, fechaFinal, almacen,
				flagAlmacen, producto, flagProducto);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_lista_equipos_distribuccion(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informesLogic.pr_lista_equipos_distribuccion(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ConsultaRegistrosUsuariosDTO> pr_digitaciones_por_usuario(Long compania, Date fechaInicial,
			Date fechaFinal, String tipo_reg, Long idusuario) throws Exception {
		return informesLogic.pr_digitaciones_por_usuario(compania, fechaInicial, fechaFinal, tipo_reg, idusuario);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos_detalle(Long compania, String anioMes,
			String idOrigen) throws Exception {
		return informesLogic.pr_distribuccion_ingresos_equipos_detalle(compania, anioMes, idOrigen);
	}

	public List<CostosIndirectosEquipoDTO> pr_compras_gastos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception {
		return informesLogic.pr_compras_gastos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				documento);
	}

	public List<SubTipoCotizante> getSubTipoCotizante() throws Exception {
		return subTipoCotizanteLogic.getSubTipoCotizante();
	}

	public void saveSubTipoCotizante(SubTipoCotizante entity) throws Exception {
		subTipoCotizanteLogic.saveSubTipoCotizante(entity);
	}

	public void deleteSubTipoCotizante(SubTipoCotizante entity) throws Exception {
		subTipoCotizanteLogic.deleteSubTipoCotizante(entity);
	}

	public void updateSubTipoCotizante(SubTipoCotizante entity) throws Exception {
		subTipoCotizanteLogic.updateSubTipoCotizante(entity);
	}

	public SubTipoCotizante getSubTipoCotizante(Long subTipoCotizanteId) throws Exception {
		SubTipoCotizante subTipoCotizante = null;

		try {
			subTipoCotizante = subTipoCotizanteLogic.getSubTipoCotizante(subTipoCotizanteId);
		} catch (Exception e) {
			throw e;
		}

		return subTipoCotizante;
	}

	public List<SubTipoCotizante> findByCriteriaInSubTipoCotizante(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return subTipoCotizanteLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<SubTipoCotizante> findPageSubTipoCotizante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return subTipoCotizanteLogic.findPageSubTipoCotizante(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberSubTipoCotizante() throws Exception {
		return subTipoCotizanteLogic.findTotalNumberSubTipoCotizante();
	}

	public List<SubTipoCotizanteDTO> getDataSubTipoCotizante() throws Exception {
		return subTipoCotizanteLogic.getDataSubTipoCotizante();
	}

	public List<TipoCotizante> getTipoCotizante() throws Exception {
		return tipoCotizanteLogic.getTipoCotizante();
	}

	public void saveTipoCotizante(TipoCotizante entity) throws Exception {
		tipoCotizanteLogic.saveTipoCotizante(entity);
	}

	public void deleteTipoCotizante(TipoCotizante entity) throws Exception {
		tipoCotizanteLogic.deleteTipoCotizante(entity);
	}

	public void updateTipoCotizante(TipoCotizante entity) throws Exception {
		tipoCotizanteLogic.updateTipoCotizante(entity);
	}

	public TipoCotizante getTipoCotizante(Long tipoCotizanteId) throws Exception {
		TipoCotizante tipoCotizante = null;

		try {
			tipoCotizante = tipoCotizanteLogic.getTipoCotizante(tipoCotizanteId);
		} catch (Exception e) {
			throw e;
		}

		return tipoCotizante;
	}

	public List<TipoCotizante> findByCriteriaInTipoCotizante(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoCotizanteLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<TipoCotizante> findPageTipoCotizante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoCotizanteLogic.findPageTipoCotizante(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoCotizante() throws Exception {
		return tipoCotizanteLogic.findTotalNumberTipoCotizante();
	}

	public List<TipoCotizanteDTO> getDataTipoCotizante() throws Exception {
		return tipoCotizanteLogic.getDataTipoCotizante();
	}

	public List<DatProvicionesCierreNomina> getDatProvicionesCierreNomina() throws Exception {
		return datProvicionesCierreNominaLogic.getDatProvicionesCierreNomina();
	}

	public void saveDatProvicionesCierreNomina(DatProvicionesCierreNomina entity) throws Exception {
		datProvicionesCierreNominaLogic.saveDatProvicionesCierreNomina(entity);
	}

	public void deleteDatProvicionesCierreNomina(DatProvicionesCierreNomina entity) throws Exception {
		datProvicionesCierreNominaLogic.deleteDatProvicionesCierreNomina(entity);
	}

	public void updateDatProvicionesCierreNomina(DatProvicionesCierreNomina entity) throws Exception {
		datProvicionesCierreNominaLogic.updateDatProvicionesCierreNomina(entity);
	}

	public DatProvicionesCierreNomina getDatProvicionesCierreNomina(Long datProvicionesCierreNominaId)
			throws Exception {
		DatProvicionesCierreNomina datProvicionesCierreNomina = null;

		try {
			datProvicionesCierreNomina = datProvicionesCierreNominaLogic
					.getDatProvicionesCierreNomina(datProvicionesCierreNominaId);
		} catch (Exception e) {
			throw e;
		}

		return datProvicionesCierreNomina;
	}

	public List<DatProvicionesCierreNomina> findByCriteriaInDatProvicionesCierreNomina(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datProvicionesCierreNominaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatProvicionesCierreNomina> findPageDatProvicionesCierreNomina(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datProvicionesCierreNominaLogic.findPageDatProvicionesCierreNomina(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberDatProvicionesCierreNomina() throws Exception {
		return datProvicionesCierreNominaLogic.findTotalNumberDatProvicionesCierreNomina();
	}

	public List<DatProvicionesCierreNominaDTO> getDataDatProvicionesCierreNomina() throws Exception {
		return datProvicionesCierreNominaLogic.getDataDatProvicionesCierreNomina();
	}

	public List<DatProvicionesCierreNominaMq> getDatProvicionesCierreNominaMq() throws Exception {
		return datProvicionesCierreNominaMqLogic.getDatProvicionesCierreNominaMq();
	}

	public void saveDatProvicionesCierreNominaMq(DatProvicionesCierreNominaMq entity) throws Exception {
		datProvicionesCierreNominaMqLogic.saveDatProvicionesCierreNominaMq(entity);
	}

	public void deleteDatProvicionesCierreNominaMq(DatProvicionesCierreNominaMq entity) throws Exception {
		datProvicionesCierreNominaMqLogic.deleteDatProvicionesCierreNominaMq(entity);
	}

	public void updateDatProvicionesCierreNominaMq(DatProvicionesCierreNominaMq entity) throws Exception {
		datProvicionesCierreNominaMqLogic.updateDatProvicionesCierreNominaMq(entity);
	}

	public DatProvicionesCierreNominaMq getDatProvicionesCierreNominaMq(Long datProvicionesCierreNominaMqId)
			throws Exception {
		DatProvicionesCierreNominaMq datProvicionesCierreNominaMq = null;

		try {
			datProvicionesCierreNominaMq = datProvicionesCierreNominaMqLogic
					.getDatProvicionesCierreNominaMq(datProvicionesCierreNominaMqId);
		} catch (Exception e) {
			throw e;
		}

		return datProvicionesCierreNominaMq;
	}

	public List<DatProvicionesCierreNominaMq> findByCriteriaInDatProvicionesCierreNominaMq(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datProvicionesCierreNominaMqLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatProvicionesCierreNominaMq> findPageDatProvicionesCierreNominaMq(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datProvicionesCierreNominaMqLogic.findPageDatProvicionesCierreNominaMq(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberDatProvicionesCierreNominaMq() throws Exception {
		return datProvicionesCierreNominaMqLogic.findTotalNumberDatProvicionesCierreNominaMq();
	}

	public List<DatProvicionesCierreNominaMqDTO> getDataDatProvicionesCierreNominaMq() throws Exception {
		return datProvicionesCierreNominaMqLogic.getDataDatProvicionesCierreNominaMq();
	}

	public List<ListadoProvisionesDTO> pr_listar_proviciones(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception {
		return informesLogic.pr_listar_proviciones(compania, fechaInicial, fechaFinal, trabId, flagTrabajador);
	}

	public List<ListadoProvisionesDTO> pr_listar_proviciones_mq(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception {
		return informesLogic.pr_listar_proviciones_mq(compania, fechaInicial, fechaFinal, trabId, flagTrabajador);
	}

	public List<SolicitudesMttoEquipoDTO> pr_ot_plan_revision(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, Long idMtto) throws Exception {
		return informesLogic.pr_ot_plan_revision(compania, fechaInicial, fechaFinal, equipo, flagEquipo, idMtto);
	}

	public List<ConsultaCompraMateriaPrimaDTO> pr_lista_compra_materia_prima(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, Long documento) throws Exception {
		return informesLogic.pr_lista_compra_materia_prima(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, documento);
	}

	public long consultarConsecutivoDatCompraMateriaPrima(Long compania) throws Exception {
		return informesLogic.consultarConsecutivoDatCompraMateriaPrima(compania);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_materia_prima(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura) throws Exception {
		return informesLogic.pr_inventario_detalle_materia_prima(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex,
				conseckardex, factura);
	}

	public List<DatCompraMateriaPrima> getDatCompraMateriaPrima() throws Exception {
		return datCompraMateriaPrimaLogic.getDatCompraMateriaPrima();
	}

	public void saveDatCompraMateriaPrima(DatCompraMateriaPrima entity,
			List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos) throws Exception {
		datCompraMateriaPrimaLogic.saveDatCompraMateriaPrima(entity, dataDetPrecioProductos);
	}

	public void deleteDatCompraMateriaPrima(DatCompraMateriaPrima entity) throws Exception {
		datCompraMateriaPrimaLogic.deleteDatCompraMateriaPrima(entity);
	}

	public void updateDatCompraMateriaPrima(DatCompraMateriaPrima entity,
			List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos) throws Exception {
		datCompraMateriaPrimaLogic.updateDatCompraMateriaPrima(entity, dataDetPrecioProductos);
	}

	public DatCompraMateriaPrima getDatCompraMateriaPrima(Long datCompraMateriaPrimaId) throws Exception {
		DatCompraMateriaPrima datCompraMateriaPrima = null;

		try {
			datCompraMateriaPrima = datCompraMateriaPrimaLogic.getDatCompraMateriaPrima(datCompraMateriaPrimaId);
		} catch (Exception e) {
			throw e;
		}

		return datCompraMateriaPrima;
	}

	public List<DatCompraMateriaPrima> findByCriteriaInDatCompraMateriaPrima(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datCompraMateriaPrimaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatCompraMateriaPrima> findPageDatCompraMateriaPrima(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datCompraMateriaPrimaLogic.findPageDatCompraMateriaPrima(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatCompraMateriaPrima() throws Exception {
		return datCompraMateriaPrimaLogic.findTotalNumberDatCompraMateriaPrima();
	}

	public List<DatCompraMateriaPrimaDTO> getDataDatCompraMateriaPrima() throws Exception {
		return datCompraMateriaPrimaLogic.getDataDatCompraMateriaPrima();
	}

	public List<PrecioPromMateriaPrima> getPrecioPromMateriaPrima() throws Exception {
		return precioPromMateriaPrimaLogic.getPrecioPromMateriaPrima();
	}

	public void savePrecioPromMateriaPrima(PrecioPromMateriaPrima entity) throws Exception {
		precioPromMateriaPrimaLogic.savePrecioPromMateriaPrima(entity);
	}

	public void deletePrecioPromMateriaPrima(PrecioPromMateriaPrima entity) throws Exception {
		precioPromMateriaPrimaLogic.deletePrecioPromMateriaPrima(entity);
	}

	public void updatePrecioPromMateriaPrima(PrecioPromMateriaPrima entity) throws Exception {
		precioPromMateriaPrimaLogic.updatePrecioPromMateriaPrima(entity);
	}

	public PrecioPromMateriaPrima getPrecioPromMateriaPrima(Long precioPromMateriaPrimaId) throws Exception {
		PrecioPromMateriaPrima precioPromMateriaPrima = null;

		try {
			precioPromMateriaPrima = precioPromMateriaPrimaLogic.getPrecioPromMateriaPrima(precioPromMateriaPrimaId);
		} catch (Exception e) {
			throw e;
		}

		return precioPromMateriaPrima;
	}

	public List<PrecioPromMateriaPrima> findByCriteriaInPrecioPromMateriaPrima(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return precioPromMateriaPrimaLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<PrecioPromMateriaPrima> findPagePrecioPromMateriaPrima(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return precioPromMateriaPrimaLogic.findPagePrecioPromMateriaPrima(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberPrecioPromMateriaPrima() throws Exception {
		return precioPromMateriaPrimaLogic.findTotalNumberPrecioPromMateriaPrima();
	}

	public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrima() throws Exception {
		return precioPromMateriaPrimaLogic.getDataPrecioPromMateriaPrima();
	}

	public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByCompra(Long datCompraMateriaPrimaId)
			throws Exception {
		return precioPromMateriaPrimaLogic.getDataPrecioPromMateriaPrimaByCompra(datCompraMateriaPrimaId);
	}

	public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByInventario(Long datCompraMateriaPrimaId)
			throws Exception {
		return precioPromMateriaPrimaLogic.getDataPrecioPromMateriaPrimaByCompra(datCompraMateriaPrimaId);
	}

	public List<TarifasArl> getTarifasArl() throws Exception {
		return tarifasArlLogic.getTarifasArl();
	}

	public void saveTarifasArl(TarifasArl entity) throws Exception {
		tarifasArlLogic.saveTarifasArl(entity);
	}

	public void deleteTarifasArl(TarifasArl entity) throws Exception {
		tarifasArlLogic.deleteTarifasArl(entity);
	}

	public void updateTarifasArl(TarifasArl entity) throws Exception {
		tarifasArlLogic.updateTarifasArl(entity);
	}

	public TarifasArl getTarifasArl(Long tarifasArlId) throws Exception {
		TarifasArl tarifasArl = null;

		try {
			tarifasArl = tarifasArlLogic.getTarifasArl(tarifasArlId);
		} catch (Exception e) {
			throw e;
		}

		return tarifasArl;
	}

	public List<TarifasArl> findByCriteriaInTarifasArl(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tarifasArlLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<TarifasArl> findPageTarifasArl(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tarifasArlLogic.findPageTarifasArl(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTarifasArl() throws Exception {
		return tarifasArlLogic.findTotalNumberTarifasArl();
	}

	public List<TarifasArlDTO> getDataTarifasArl() throws Exception {
		return tarifasArlLogic.getDataTarifasArl();
	}

	public List<ConsultaProgLaboresMaqDTO> pr_consulta_lista_prog_maquinaria(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informesLogic.pr_consulta_lista_prog_maquinaria(compania, fechaInicial, fechaFinal);
	}

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informesLogic.pr_consulta_provisiones_maq(compania, fechaInicial, fechaFinal, operador, flagOperador);
	}

	public Long pr_calculo_provisiones_maq(Long companiaid, Date fechaInicial, Date fechaFinal, String operador,
			Long flagOperador, String tipoNomina, Long usuario) throws Exception {
		return informesLogic.pr_calculo_provisiones_maq(companiaid, fechaInicial, fechaFinal, operador, flagOperador,
				tipoNomina, usuario);
	}

	public Long borrar_dat_proviciones_cierre_nomina_mq(Long companiaid, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.borrar_dat_proviciones_cierre_nomina_mq(companiaid, fechaInicial, fechaFinal);
	}

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_nomina_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informesLogic.pr_consulta_provisiones_nomina_maq(compania, fechaInicial, fechaFinal, operador,
				flagOperador);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_costos_distribuidos_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String idOrigen) throws Exception {
		return informesLogic.pr_costos_distribuidos_equipo(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				idOrigen);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquina_grlabor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, Long grupoLabor) throws Exception {
		return informesLogic.pr_control_productividad_maquina_grlabor(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo, grupoLabor);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquinaria(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo,
			String categoria, Long flagCategoriaEquipo, Long modeloEquipo) throws Exception {
		return informesLogic.pr_control_productividad_maquinaria(compania, fechaInicial, fechaFinal, operador,
				flagOperador, equipo, flagEquipo, categoria, flagCategoriaEquipo, modeloEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception {
		return informesLogic.pr_control_productividad_operario(compania, fechaInicial, fechaFinal, operador,
				flagOperador, equipo, flagEquipo);
	}

	public Long pr_recalcular_mano_obra_serv_maq(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informesLogic.pr_recalcular_mano_obra_serv_maq(compania, fechaInicial, fechaFinal);

	}

	public Long pr_recalcular_mano_obra_serv_maq_parte2(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesLogic.pr_recalcular_mano_obra_serv_maq_parte2(compania, fechaInicial, fechaFinal);
	}

	public Long pr_cierre_nomina_destajo_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String tipoNomina, Long usuario) throws Exception {
		return informesLogic.pr_cierre_nomina_destajo_maquinaria(compania, fechaInicial, fechaFinal, tipoNomina,
				usuario);
	}

	public Long pr_borrar_trabajador_provisiones(Long compania, Date fechaInicial, Date fechaFinal, String trabajadores)
			throws Exception {
		return informesLogic.pr_borrar_trabajador_provisiones(compania, fechaInicial, fechaFinal, trabajadores);
	}

	public List<SolicitudesMttoEquipoDTO> pr_solicitudes_mtto_equipo_productos(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, Long idMtto, Long datmttoprodid, Long tipoProducto) throws Exception {
		return informesLogic.pr_solicitudes_mtto_equipo_productos(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo, producto, flagProducto, almacen, flagAlmacen, idMtto, datmttoprodid, tipoProducto);

	}

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo2(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception {
		return informesLogic.pr_comprobante_pago_nomina_maq_destajo2(compania, fechaInicial, fechaFinal, operador,
				flagOperador, tipoNomina);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetCombustible(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) throws Exception {
		return informesLogic.consultaServRealizadosEquipoDetCombustible(compania, estadoServicio, fechaInicial,
				fechaFinal, cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl);
	}

	public List<DatFacturaServiciosTerceros> getDatFacturaServiciosTerceros() throws Exception {
		return datFacturaServiciosTercerosLogic.getDatFacturaServiciosTerceros();
	}

	public void saveDatFacturaServiciosTerceros(DatFacturaServiciosTerceros entity) throws Exception {
		datFacturaServiciosTercerosLogic.saveDatFacturaServiciosTerceros(entity);
	}

	public void deleteDatFacturaServiciosTerceros(DatFacturaServiciosTerceros entity) throws Exception {
		datFacturaServiciosTercerosLogic.deleteDatFacturaServiciosTerceros(entity);
	}

	public void updateDatFacturaServiciosTerceros(DatFacturaServiciosTerceros entity) throws Exception {
		datFacturaServiciosTercerosLogic.updateDatFacturaServiciosTerceros(entity);
	}

	public DatFacturaServiciosTerceros getDatFacturaServiciosTerceros(Long datFacturaServiciosTercerosId)
			throws Exception {
		DatFacturaServiciosTerceros datFacturaServiciosTerceros = null;

		try {
			datFacturaServiciosTerceros = datFacturaServiciosTercerosLogic
					.getDatFacturaServiciosTerceros(datFacturaServiciosTercerosId);
		} catch (Exception e) {
			throw e;
		}

		return datFacturaServiciosTerceros;
	}

	public List<DatFacturaServiciosTerceros> findByCriteriaInDatFacturaServiciosTerceros(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datFacturaServiciosTercerosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatFacturaServiciosTerceros> findPageDatFacturaServiciosTerceros(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		return datFacturaServiciosTercerosLogic.findPageDatFacturaServiciosTerceros(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberDatFacturaServiciosTerceros() throws Exception {
		return datFacturaServiciosTercerosLogic.findTotalNumberDatFacturaServiciosTerceros();
	}

	public List<DatFacturaServiciosTercerosDTO> getDataDatFacturaServiciosTerceros() throws Exception {
		return datFacturaServiciosTercerosLogic.getDataDatFacturaServiciosTerceros();
	}

	public long consec_dat_factura_servicios_terceros(Long compania) throws Exception {
		return informesLogic.consec_dat_factura_servicios_terceros(compania);
	}

	public List<FacturaServiciosConsolidadosTercerosDTO> pr_listar_factura_servicios_terceros(Long compania,
			Date fechaInicial, Date fechaFinal, Long consec, Long centCost) throws Exception {
		return informesLogic.pr_listar_factura_servicios_terceros(compania, fechaInicial, fechaFinal, consec, centCost);
	}

	public List<FacturaServiciosConsolidadosTercerosDTO> pr_ingresos_egresos_terceros(Long compania, Date fechaInicial,
			Date fechaFinal, Long consec, Long centCost) throws Exception {
		return informesLogic.pr_ingresos_egresos_terceros(compania, fechaInicial, fechaFinal, consec, centCost);
	}
	
	public List<ConsultaStockMaquinariaDTO> pr_inventario_recalculo_precio_entrada_producto(Long compania, Date fechaInicial,
			Date fechaFinal, Long flagAlmacen, Long flagProducto) throws Exception {
		return informesLogic.pr_inventario_recalculo_precio_entrada_producto(compania, fechaInicial, fechaFinal, flagAlmacen,
				flagProducto);
	}
	public List<DatProductosRelacionados> getDatProductosRelacionados() throws Exception {
		return datProductosRelacionadosLogic.getDatProductosRelacionados();
	}

	public void saveDatProductosRelacionados(DatProductosRelacionados entity) throws Exception {
		datProductosRelacionadosLogic.saveDatProductosRelacionados(entity);
	}

	public void deleteDatProductosRelacionados(DatProductosRelacionados entity) throws Exception {
		datProductosRelacionadosLogic.deleteDatProductosRelacionados(entity);
	}

	public void updateDatProductosRelacionados(DatProductosRelacionados entity) throws Exception {
		datProductosRelacionadosLogic.updateDatProductosRelacionados(entity);
	}

	public DatProductosRelacionados getDatProductosRelacionados(Long datProductosAgregadosId) throws Exception {
		DatProductosRelacionados datProductosRelacionados = null;

		try {
			datProductosRelacionados = datProductosRelacionadosLogic
					.getDatProductosRelacionados(datProductosAgregadosId);
		} catch (Exception e) {
			throw e;
		}

		return datProductosRelacionados;
	}

	public List<DatProductosRelacionados> findByCriteriaInDatProductosRelacionados(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception {
		return datProductosRelacionadosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<DatProductosRelacionados> findPageDatProductosRelacionados(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return datProductosRelacionadosLogic.findPageDatProductosRelacionados(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberDatProductosRelacionados() throws Exception {
		return datProductosRelacionadosLogic.findTotalNumberDatProductosRelacionados();
	}

	public List<DatProductosRelacionadosDTO> getDataDatProductosRelacionados() throws Exception {
		return datProductosRelacionadosLogic.getDataDatProductosRelacionados();
	}

	public List<DatProductosRelacionadosDTO> getDataDatProductosRelacionadosByProducto(Long productoId)
			throws Exception {
		return datProductosRelacionadosLogic.getDataDatProductosRelacionadosByProducto(productoId);
	}
	public long pr_consec_producto_tipo(Long compania, Long tipoProd) throws Exception{
		return informesLogic.pr_consec_producto_tipo(compania, tipoProd);
	}
	
	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_realizados_equipo_det_combustible2(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl, Long centCostId) throws Exception {
		return informesLogic.pr_consulta_serv_realizados_equipo_det_combustible2(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl,   centCostId);

	}
	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto)
			throws Exception {
		return informesLogic.pr_inventario_saldo_bodega_ubicacion(compania, fechaInicial, fechaFinal, almacen,
				flagAlmacen, tipoProducto, flagTipoProducto);
	}
}