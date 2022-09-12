package co.com.arcosoft.presentation.businessDelegate2;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 *
 */
public interface IBusinessDelegator2View {
	public long consultarConsec_dat_pluvio(Long compania) throws Exception;

	public List<ListaVariablesAnaLaboratorioDTO> pr_validar_existencia_analisis_lab(Long compania, Date fecha,
			String horaDigitacion, Long idAnalisis) throws Exception;

	public Long pr_borrar_dat_ana_laboratorio(Long id) throws Exception;

	public Long pr_borrar_dat_ana_laboratorio_det(Long id) throws Exception;

	public List<ProyeccionLaboresLoteDTO> pr_presupuesto_vs_ejecutado(Long compania, Date fechaInicial, Date fechaFinal,
			String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String cronogramaLabor, Long flagCronogramaLabor) throws Exception;

	public void saveTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna) throws Exception;

	public void deleteTablaAnalitica(TablaAnalitica entity) throws Exception;

	public void updateTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna) throws Exception;

	public TablaAnalitica getTablaAnalitica(Long tablaAnaliticaId) throws Exception;

	public List<TablaAnalitica> findByCriteriaInTablaAnalitica(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TablaAnalitica> findPageTablaAnalitica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTablaAnalitica() throws Exception;

	public List<TablaAnaliticaDTO> getDataTablaAnalitica() throws Exception;

	public List<TablaAnaliticaDetalle> getTablaAnaliticaDetalle() throws Exception;

	public void saveTablaAnaliticaDetalle(TablaAnaliticaDetalle entity) throws Exception;

	public void deleteTablaAnaliticaDetalle(TablaAnaliticaDetalle entity) throws Exception;

	public void updateTablaAnaliticaDetalle(TablaAnaliticaDetalle entity) throws Exception;

	public TablaAnaliticaDetalle getTablaAnaliticaDetalle(Long tablaAnaliticaDetalleId) throws Exception;

	public List<TablaAnaliticaDetalle> findByCriteriaInTablaAnaliticaDetalle(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<TablaAnaliticaDetalle> findPageTablaAnaliticaDetalle(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTablaAnaliticaDetalle() throws Exception;

	public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalle() throws Exception;

	public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalleByTablaAnalitica(Long tablaAnaliticaId)
			throws Exception;

	List<TiquetesBasculaDTO> consultarEstadoVehiculo(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoSeleccionado, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception;

	List<TiquetesBasculaDTO> consultarEstadoVehiculoPr(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoSeleccionado, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception;

	public List<TiquetesBasculaDTO> pr_consulta_vehiculo_en_patio(Long compania, Long equipo) throws Exception;

	public long consultarConsecutivoDatTransProdPesoNeto(Long compania) throws Exception;

	public List<DatPlanServiciosMq> getDatPlanServiciosMq() throws Exception;

	public void saveDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
			throws Exception;

	public void deleteDatPlanServiciosMq(DatPlanServiciosMq entity) throws Exception;

	public void updateDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
			throws Exception;

	public DatPlanServiciosMq getDatPlanServiciosMq(Long datPlanServiciosMqId) throws Exception;

	public List<DatPlanServiciosMq> findByCriteriaInDatPlanServiciosMq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanServiciosMq> findPageDatPlanServiciosMq(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanServiciosMq() throws Exception;

	public List<DatPlanServiciosMqDTO> getDataDatPlanServiciosMq() throws Exception;

	public List<DatPlanServiciosMqdet> getDatPlanServiciosMqdet() throws Exception;

	public void saveDatPlanServiciosMqdet(DatPlanServiciosMqdet entity) throws Exception;

	public void deleteDatPlanServiciosMqdet(DatPlanServiciosMqdet entity) throws Exception;

	public void updateDatPlanServiciosMqdet(DatPlanServiciosMqdet entity) throws Exception;

	public DatPlanServiciosMqdet getDatPlanServiciosMqdet(Long datPlanServiciosMqdetId) throws Exception;

	public List<DatPlanServiciosMqdet> findByCriteriaInDatPlanServiciosMqdet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanServiciosMqdet> findPageDatPlanServiciosMqdet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanServiciosMqdet() throws Exception;

	public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdet() throws Exception;

	public List<Nivel2Clientesmq> getNivel2Clientesmq() throws Exception;

	public void saveNivel2Clientesmq(Nivel2Clientesmq entity) throws Exception;

	public void deleteNivel2Clientesmq(Nivel2Clientesmq entity) throws Exception;

	public void updateNivel2Clientesmq(Nivel2Clientesmq entity) throws Exception;

	public Nivel2Clientesmq getNivel2Clientesmq(Long nivel2ClientesmqId) throws Exception;

	public List<Nivel2Clientesmq> findByCriteriaInNivel2Clientesmq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel2Clientesmq> findPageNivel2Clientesmq(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberNivel2Clientesmq() throws Exception;

	public List<Nivel2ClientesmqDTO> getDataNivel2Clientesmq() throws Exception;

	public List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq(Long compania, Long clienteId) throws Exception;

	public BigDecimal consultarAdicionalManoObra(Long idCompania, Long idLabor, Long idUdadMed, Date fecha,
			Double cantidad) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDet(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl, Long centCostId) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaLiqServRealizadosEquipoOperario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetPendientesFact(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) throws Exception;

	public List<Nivel4Clientesmq> getNivel4Clientesmq() throws Exception;

	public void saveNivel4Clientesmq(Nivel4Clientesmq entity) throws Exception;

	public void deleteNivel4Clientesmq(Nivel4Clientesmq entity) throws Exception;

	public void updateNivel4Clientesmq(Nivel4Clientesmq entity) throws Exception;

	public Nivel4Clientesmq getNivel4Clientesmq(Long nivel4ClientesmqId) throws Exception;

	public List<Nivel4Clientesmq> findByCriteriaInNivel4Clientesmq(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel4Clientesmq> findPageNivel4Clientesmq(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberNivel4Clientesmq() throws Exception;

	public List<Nivel4ClientesmqDTO> getDataNivel4Clientesmq() throws Exception;

	public List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq(Long compania, String hdaId) throws Exception;

	public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdetByNomina(Long idNomina) throws Exception;

	public long consultarConsecutivoConsolidadoNominamq(Long compania) throws Exception;

	public Long borrarLiqServRealizadosOperario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;

	public Long interfazLiqServRealizadosEquipoOperario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception;

	public String preFecturarServicios(String datservrealizadosequipodetid) throws Exception;

	public String facturarServicios(String datservrealizadosequipodetid) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_reporte_serv_prefacturados(
			String datservrealizadosequipodetid) throws Exception;

	public Long actualizarConsecPrefacturaCompania(Long compania) throws Exception;

	public List<CajaMenor> getCajaMenor() throws Exception;

	public void saveCajaMenor(CajaMenor entity) throws Exception;

	public void deleteCajaMenor(CajaMenor entity) throws Exception;

	public void updateCajaMenor(CajaMenor entity) throws Exception;

	public CajaMenor getCajaMenor(Long cajaMenorId) throws Exception;

	public List<CajaMenor> findByCriteriaInCajaMenor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CajaMenor> findPageCajaMenor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCajaMenor() throws Exception;

	public List<CajaMenorDTO> getDataCajaMenor() throws Exception;

	public List<ConceptoKardex> getConceptoKardex() throws Exception;

	public void saveConceptoKardex(ConceptoKardex entity) throws Exception;

	public void deleteConceptoKardex(ConceptoKardex entity) throws Exception;

	public void updateConceptoKardex(ConceptoKardex entity) throws Exception;

	public ConceptoKardex getConceptoKardex(Long conceptoKardexId) throws Exception;

	public List<ConceptoKardex> findByCriteriaInConceptoKardex(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ConceptoKardex> findPageConceptoKardex(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberConceptoKardex() throws Exception;

	public List<ConceptoKardexDTO> getDataConceptoKardex() throws Exception;

	public List<DatFacturaServicios> getDatFacturaServicios() throws Exception;

	public void saveDatFacturaServicios(DatFacturaServicios entity) throws Exception;

	public void deleteDatFacturaServicios(DatFacturaServicios entity) throws Exception;

	public void updateDatFacturaServicios(DatFacturaServicios entity) throws Exception;

	public DatFacturaServicios getDatFacturaServicios(Long datFacturaServiciosId) throws Exception;

	public List<DatFacturaServicios> findByCriteriaInDatFacturaServicios(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatFacturaServicios> findPageDatFacturaServicios(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatFacturaServicios() throws Exception;

	public List<DatFacturaServiciosDTO> getDataDatFacturaServicios() throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_prefacturas_por_cliente(Long clienteId)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_cargar_serv_prefact_cliente(Long clienteId,
			String prefactura) throws Exception;

	public long consec_facturacion_servicios(Long compania) throws Exception;

	public Long actualizarNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura)
			throws Exception;

	public Long anularNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura) throws Exception;

	public List<DatCompraProductos> getDatCompraProductos() throws Exception;

	public void deleteDatCompraProductos(DatCompraProductos entity) throws Exception;

	public void saveDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos,
			Double valorFactura, Double totalSuma) throws Exception;

	public void updateDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception;

	public DatCompraProductos getDatCompraProductos(Long datCompraProductosId) throws Exception;

	public List<DatCompraProductos> findByCriteriaInDatCompraProductos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatCompraProductos> findPageDatCompraProductos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatCompraProductos() throws Exception;

	public List<DatCompraProductosDTO> getDataDatCompraProductos() throws Exception;

	public List<DatDiferidos> getDatDiferidos() throws Exception;

	public void saveDatDiferidos(DatDiferidos entity, List<DatDiferidosDetDTO> dataDet,
			List<DatDiferidosCuotasDTO> dataCuotas) throws Exception;

	public void deleteDatDiferidos(DatDiferidos entity) throws Exception;

	public void updateDatDiferidos(DatDiferidos entity, List<DatDiferidosDetDTO> dataDet,
			List<DatDiferidosCuotasDTO> dataCuotas) throws Exception;

	public DatDiferidos getDatDiferidos(Long datDiferidosId) throws Exception;

	public List<DatDiferidos> findByCriteriaInDatDiferidos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatDiferidos> findPageDatDiferidos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatDiferidos() throws Exception;

	public List<DatDiferidosDTO> getDataDatDiferidos() throws Exception;

	public List<DatDiferidosDet> getDatDiferidosDet() throws Exception;

	public void saveDatDiferidosDet(DatDiferidosDet entity) throws Exception;

	public void deleteDatDiferidosDet(DatDiferidosDet entity) throws Exception;

	public void updateDatDiferidosDet(DatDiferidosDet entity) throws Exception;

	public DatDiferidosDet getDatDiferidosDet(Long datDiferidosDetId) throws Exception;

	public List<DatDiferidosDet> findByCriteriaInDatDiferidosDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatDiferidosDet> findPageDatDiferidosDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatDiferidosDet() throws Exception;

	public List<DatDiferidosDetDTO> getDataDatDiferidosDet() throws Exception;

	public List<DatHerramienta> getDatHerramienta() throws Exception;

	public void saveDatHerramienta(DatHerramienta entity) throws Exception;

	public void deleteDatHerramienta(DatHerramienta entity) throws Exception;

	public void updateDatHerramienta(DatHerramienta entity) throws Exception;

	public DatHerramienta getDatHerramienta(Long datHerramientaId) throws Exception;

	public List<DatHerramienta> findByCriteriaInDatHerramienta(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatHerramienta> findPageDatHerramienta(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatHerramienta() throws Exception;

	public List<DatHerramientaDTO> getDataDatHerramienta() throws Exception;

	public List<DatPagosNotasClientes> getDatPagosNotasClientes() throws Exception;

	public void saveDatPagosNotasClientes(DatPagosNotasClientes entity) throws Exception;

	public void deleteDatPagosNotasClientes(DatPagosNotasClientes entity) throws Exception;

	public void updateDatPagosNotasClientes(DatPagosNotasClientes entity) throws Exception;

	public DatPagosNotasClientes getDatPagosNotasClientes(Long datPagosNotasClientesId) throws Exception;

	public List<DatPagosNotasClientes> findByCriteriaInDatPagosNotasClientes(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatPagosNotasClientes> findPageDatPagosNotasClientes(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPagosNotasClientes() throws Exception;

	public List<DatPagosNotasClientesDTO> getDataDatPagosNotasClientes() throws Exception;

	public long consultarConsecutivoDatHerramientas(Long compania) throws Exception;

	public long consultarConsecutivoPagoNotasClientes(Long compania) throws Exception;

	public long consultarConsecutivoCajaMenor(Long compania) throws Exception;

	public long consultarConsecutivoDatDiferidos(Long compania) throws Exception;

	public long consultarConsecutivoDatCompraProductos(Long compania) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_factura_serv_consolidada_detal(String factura)
			throws Exception;

	public String pr_borrar_factura_servicio_consolidada(String numfactura) throws Exception;

	public String pr_reversar_factura_servicio_consolidada_detal(String numfactura) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception;

	public List<ListadoPinesMaquinariaDTO> pr_listado_pines_equipo(Long compania, String equipo, Long flagEquipo)
			throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_factura_vs_pago_realizados(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_cartera_clientes(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception;

	public Long pr_borrar_equipos_otros_costosmq(Long idOtrosCostosmq) throws Exception;

	public List<ListaEquiposCategoriaDTO> pr_lista_equipo(Long categoriaid) throws Exception;

	public List<CostosIndirectosEquipoDTO> pr_otros_costos_maquinaria_saz(Long compania, Date fechaInicial,
			Date fechaFinal, String labor, Long flagLabor, Long documento, String equipo, Long flagEquipo)
			throws Exception;

	public List<ConsultaCajaMenorDTO> pr_caja_menor(Long compania, Date fechaInicial, Date fechaFinal, String caja,
			Long flagCaja, String equipo, Long flagEquipo, String labor, Long flagLabor, Long consecutivo)
			throws Exception;

	public List<ConsultaCompraProductosDTO> pr_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura,
			Long tipoProducto, String origenDatos) throws Exception;

	public List<ConsultaCostosDiferidosDTO> pr_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public String busquedaNivel2Clientes(String codNivel2C, Long idpersempr) throws Exception;

	public String busquedaNivel4Clientes(String codNivel4C, Long idnivel2C) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_facturas_cliente(String numFactura) throws Exception;

	public List<DatOtrosMovInventario> getDatOtrosMovInventario() throws Exception;

	public void saveDatOtrosMovInventario(DatOtrosMovInventario entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception;

	public void updateDatOtrosMovInventario(DatOtrosMovInventario entity,
			List<PrecioPromProdDTO> dataDetPrecioProductos) throws Exception;

	public void deleteDatOtrosMovInventario(DatOtrosMovInventario entity) throws Exception;

	public DatOtrosMovInventario getDatOtrosMovInventario(Long datOtrosMovInventarioId) throws Exception;

	public List<DatOtrosMovInventario> findByCriteriaInDatOtrosMovInventario(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosMovInventario> findPageDatOtrosMovInventario(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosMovInventario() throws Exception;

	public List<DatOtrosMovInventarioDTO> getDataDatOtrosMovInventario() throws Exception;

	public List<PrecioPromProdDTO> getDataProductosByInventarios(Long datOtrosMovInventarioId) throws Exception;

	public List<PrecioPromProdDTO> getDataProductosByCompras(Long datOtrosMovInventarioId) throws Exception;

	public long consec_otros_mov_inventario(Long compania) throws Exception;

	public Long pr_reversar_prefactura_servicio(Long clienteId, Long numPrefactura) throws Exception;

	public List<Nivel4ClientesmqDTO> getDataPageNivel4Clientesmq(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel4Clientesmq(Map<String, Object> filters) throws Exception;

	public List<Nivel2ClientesmqDTO> getDataPageNivel2Clientesmq(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel2Clientesmq(Map<String, Object> filters) throws Exception;

	public List<ProntuarioLotesDTO> pr_prontuario_lotes_maquinaria(Long compania, String finca, Long flagFinca,
			String lote, Long flagLote, String proveedor, Long flagProveedor) throws Exception;

	public Double pr_saldo_prom_producto(Long idProducto, Long idAlmacen, Long idCompania) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_suministros_para_reposicion(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto) throws Exception;

	public Long pr_borrar_maq_otros_costosmq(Long idOtrosCostos) throws Exception;

	public void saveDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<ListaEquiposCategoriaDTO> dataDistr) throws Exception;

	public void updateDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet,
			List<ListaEquiposCategoriaDTO> dataDistr) throws Exception;

	public long pr_max_id_unico_dat_compras(Long compania) throws Exception;

	public long pr_max_id_unico_dat_otros_costos_mq(Long compania) throws Exception;

	public long pr_max_id_unico_dat_omov_inventario(Long compania) throws Exception;

	public Long pr_borrar_suministros_taller(Long id) throws Exception;

	public Long pr_recalcular_otros_costosmq(Long id_ocostosmq) throws Exception;

	public Long pr_recalcular_costo_productos(Long id_compras) throws Exception;

	public Long pr_distri_suministros_taller(Long id_otros_mov_inventario) throws Exception;

	public List<DatCajaMenor> getDatCajaMenor() throws Exception;

	public void deleteDatCajaMenor(DatCajaMenor entity) throws Exception;

	public DatCajaMenor getDatCajaMenor(Long datCajaMenorId) throws Exception;

	public List<DatCajaMenor> findByCriteriaInDatCajaMenor(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatCajaMenor> findPageDatCajaMenor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatCajaMenor() throws Exception;

	public List<DatCajaMenorDTO> getDataDatCajaMenor() throws Exception;

	public List<DatCajaMenorDet> getDatCajaMenorDet() throws Exception;

	public void saveDatCajaMenorDet(DatCajaMenorDet entity) throws Exception;

	public void deleteDatCajaMenorDet(DatCajaMenorDet entity) throws Exception;

	public void updateDatCajaMenorDet(DatCajaMenorDet entity) throws Exception;

	public DatCajaMenorDet getDatCajaMenorDet(Long datCajaMenordetId) throws Exception;

	public List<DatCajaMenorDet> findByCriteriaInDatCajaMenorDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatCajaMenorDet> findPageDatCajaMenorDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatCajaMenorDet() throws Exception;

	public List<DatCajaMenorDetDTO> getDataDatCajaMenorDet() throws Exception;

	public List<DatCtrlMaqPines> getDatCtrlMaqPines() throws Exception;

	public void saveDatCtrlMaqPines(DatCtrlMaqPines entity) throws Exception;

	public void deleteDatCtrlMaqPines(DatCtrlMaqPines entity) throws Exception;

	public void updateDatCtrlMaqPines(DatCtrlMaqPines entity) throws Exception;

	public DatCtrlMaqPines getDatCtrlMaqPines(Long datCtrlMaqPinesId) throws Exception;

	public List<DatCtrlMaqPines> findByCriteriaInDatCtrlMaqPines(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatCtrlMaqPines> findPageDatCtrlMaqPines(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatCtrlMaqPines() throws Exception;

	public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPines() throws Exception;

	public List<DatReqProductos> getDatReqProductos() throws Exception;

	public void deleteDatReqProductos(DatReqProductos entity) throws Exception;

	public DatReqProductos getDatReqProductos(Long datReqProductosId) throws Exception;

	public List<DatReqProductos> findByCriteriaInDatReqProductos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatReqProductos> findPageDatReqProductos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatReqProductos() throws Exception;

	public List<DatReqProductosDTO> getDataDatReqProductos() throws Exception;

	public List<DatReqProductosDet> getDatReqProductosDet() throws Exception;

	public void saveDatReqProductosDet(DatReqProductosDet entity) throws Exception;

	public void deleteDatReqProductosDet(DatReqProductosDet entity) throws Exception;

	public void updateDatReqProductosDet(DatReqProductosDet entity) throws Exception;

	public DatReqProductosDet getDatReqProductosDet(Long datReqProductosDetId) throws Exception;

	public List<DatReqProductosDet> findByCriteriaInDatReqProductosDet(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatReqProductosDet> findPageDatReqProductosDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatReqProductosDet() throws Exception;

	public List<DatReqProductosDetDTO> getDataDatReqProductosDet() throws Exception;

	public long consec_req_productos(Long compania) throws Exception;

	public List<DatReqProductosDetDTO> getDataDatReqProductosDetByProductos(Long datReqProductosId) throws Exception;

	public List<DatCajaMenorDetDTO> getDataDatCajaMenorDetByCaja(Long datCajaMenorId) throws Exception;

	public void updateDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception;

	public void saveDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception;

	public void updateDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq) throws Exception;

	public void saveDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq) throws Exception;

	public Long pr_busqueda_maq_ctrpin(Long idEquipo) throws Exception;

	public Long pr_actualiza_maq_ctrpin_consecutivo(Long idmaq, Long consecutivoPin) throws Exception;

	public Long pr_actualiza_edicion_dat_serv_realizados(Long idmaq, Long consecutivoPin) throws Exception;

	public BigDecimal pr_saldo_total_producto(Long idProducto, Long idCompania) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas_servdetal(Long cliente, String numFactura)
			throws Exception;

	public long consec_plan_serv_mq(Long compania) throws Exception;

	public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdetByPlan(Long datPlanServiciosMqId)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_distribuccion_factura(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long factura) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto)
			throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_salidas(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long tipoProducto) throws Exception;

	public List<ProgramacionLaboresMaqDTO> pr_consulta_prog_labormq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_det(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String labor, Long flagLabor, String lote, Long flagLote, Long pinId, String grpLabor, Long flagGrpLabor)
			throws Exception;

	public List<ConsultaCompraProductosDTO> pr_lista_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento, String tipoCmpra, Long numFactura) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_labores_implemento(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long pinId) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception;

	public List<ConsultaOtrosMovimientosInventarioDTO> pr_lista_otros_mov_productos(Long compania, Date fechaInicial,
			Date fechaFinal, Long documento, Long maquina, Long centCost) throws Exception;

	public List<ProntuarioLotesDTO> pr_prontuario_haciendas_maquinaria(Long compania, String finca, Long flagFinca,
			String proveedor, Long flagProveedor) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_auxilio_productividad(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception;

	public Long pr_actualiza_consec_factura_compania(Long compania, Long numfactura) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_listar_factura_servicios(Long compania, Date fechaInicial,
			Date fechaFinal, Long numFactura) throws Exception;

	public List<ConsultaCajaMenorDTO> pr_listar_cajamenor(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost)
			throws Exception;

	public List<CostosIndirectosEquipoDTO> pr_listar_otrosmq(Long compania, Date fechaInicial, Date fechaFinal,
			String tipogasto, Long documento, Long centCost,Long proveedor, String numfactura) throws Exception;

	public List<PagosNotasClientesDTO> pr_listar_notas_clientes(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public List<CatalogProductoDTO> pr_listar_productos_tipop(Long compania, Long tipoproductoid) throws Exception;

	public List<ProgramacionLaboresMaqDTO> pr_listar_planesmq(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String tipoProy) throws Exception;

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_servre_maq_interface_ssatelital(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<CatalogProductoDTO> pr_list_productos_inventario(Long compania, String producto, Long flagProducto,
			String tipoProducto, Long flagTipoProducto) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_estus(Long compania, Date fechaInicial,
			Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca, String labor,
			Long flagLabor, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_numero_pines_por_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_aux_transporte_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception;

	public Long pr_interfaz_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception;

	public Long pr_borrar_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;

	public Long pr_borrar_compra(Long idCompra) throws Exception;

	public Long pr_borrar_dat_compra_detalle(Long idCompra) throws Exception;

	public List<CatalogoPlanRevisionDTO> pr_lista_plan_revision_equipo(Long equipoid) throws Exception;

	public List<CatalogoEquiposDTO> pr_listar_eventos_equipos(Long compania, String equipo, Long flagEquipo,
			String evento, Long flagEvento) throws Exception;

	public Long pr_borrar_dat_otros_movimientos(Long id) throws Exception;

	public Long pr_borrar_dat_otros_movimientos_detalle(Long id) throws Exception;

	public Long pr_borrar_dat_otros_costos_mq(Long id) throws Exception;

	public Long pr_borrar_dat_otros_costos_mq_detalle(Long id) throws Exception;

	public Long pr_borrar_dat_caja_menor(Long id) throws Exception;

	public Long pr_borrar_dat_caja_menor_detalle(Long id) throws Exception;

	public Long pr_borrar_dat_pagos_notas_clientes(Long id) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro, Long modeloequipo) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo_conceptogasto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_costo_labor_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina_consolidados(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_ingresos_vs_costos_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro, String tipoMovimiento) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_operarios_maquina_periodo(Long compania, Date fechaInicial,
			Date fechaFinal, String cargo, Long flagCargo, String trabajador, Long flagTrabajador, String equipo,
			Long flagEquipo) throws Exception;

	public List<DatOtrosCostosMqdetDistribuccion> getDatOtrosCostosMqdetDistribuccion() throws Exception;

	public void saveDatOtrosCostosMqdetDistribuccion(DatOtrosCostosMqdetDistribuccion entity) throws Exception;

	public void deleteDatOtrosCostosMqdetDistribuccion(DatOtrosCostosMqdetDistribuccion entity) throws Exception;

	public void updateDatOtrosCostosMqdetDistribuccion(DatOtrosCostosMqdetDistribuccion entity) throws Exception;

	public DatOtrosCostosMqdetDistribuccion getDatOtrosCostosMqdetDistribuccion(Long datOtrosCostosMqdetDistrId)
			throws Exception;

	public List<DatOtrosCostosMqdetDistribuccion> findByCriteriaInDatOtrosCostosMqdetDistribuccion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostosMqdetDistribuccion> findPageDatOtrosCostosMqdetDistribuccion(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostosMqdetDistribuccion() throws Exception;

	public List<DatOtrosCostosMqdetDistribuccionDTO> getDataDatOtrosCostosMqdetDistribuccion() throws Exception;

	public List<EquipoImplemento> getEquipoImplemento() throws Exception;

	public void saveEquipoImplemento(EquipoImplemento entity) throws Exception;

	public void deleteEquipoImplemento(EquipoImplemento entity) throws Exception;

	public void updateEquipoImplemento(EquipoImplemento entity) throws Exception;

	public EquipoImplemento getEquipoImplemento(Long equipoImplementoId) throws Exception;

	public List<EquipoImplemento> findByCriteriaInEquipoImplemento(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EquipoImplemento> findPageEquipoImplemento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEquipoImplemento() throws Exception;

	public List<EquipoImplementoDTO> getDataEquipoImplemento() throws Exception;

	public List<DatDiferidosDetDTO> getDataDatDiferidosDetByDiferidos(Long datDiferidosId) throws Exception;

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost, Long proveedor, String numfactura)
			throws Exception;

	public List<DatDiferidosCuotas> getDatDiferidosCuotas() throws Exception;

	public void saveDatDiferidosCuotas(DatDiferidosCuotas entity) throws Exception;

	public void deleteDatDiferidosCuotas(DatDiferidosCuotas entity) throws Exception;

	public void updateDatDiferidosCuotas(DatDiferidosCuotas entity) throws Exception;

	public DatDiferidosCuotas getDatDiferidosCuotas(Long datDiferidosCuotasId) throws Exception;

	public List<DatDiferidosCuotas> findByCriteriaInDatDiferidosCuotas(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatDiferidosCuotas> findPageDatDiferidosCuotas(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatDiferidosCuotas() throws Exception;

	public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotas() throws Exception;

	public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotasByCuotas(Long datDiferidosId) throws Exception;

	public Long pr_borrar_dat_diferidos(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_det(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_cuotas(Long id) throws Exception;

	public Long pr_borrar_equipos_otros_costosmqdistr(Long id) throws Exception;

	public Long pr_borrar_dat_caja_menor_det_distr(Long id) throws Exception;

	public Long pr_borrar_precio_prom_prod_distribuccionmaq(Long id) throws Exception;

	public List<DatOtrosCostosMqdetDistribuccionDTO> getDataDatOtrosCostosMqdetDistribuccionByDistr(
			Long idOtrosCostosMq) throws Exception;

	public List<DatPlanServiciosMqdetEjec> getDatPlanServiciosMqdetEjec() throws Exception;

	public void saveDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity) throws Exception;

	public void deleteDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity) throws Exception;

	public void updateDatPlanServiciosMqdetEjec(DatPlanServiciosMqdetEjec entity) throws Exception;

	public DatPlanServiciosMqdetEjec getDatPlanServiciosMqdetEjec(Long datPlanServiciosMqdetEjecId) throws Exception;

	public List<DatPlanServiciosMqdetEjec> findByCriteriaInDatPlanServiciosMqdetEjec(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanServiciosMqdetEjec> findPageDatPlanServiciosMqdetEjec(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanServiciosMqdetEjec() throws Exception;

	public List<DatPlanServiciosMqdetEjecDTO> getDataDatPlanServiciosMqdetEjec() throws Exception;

	public List<ProgramacionLaboresMaqDTO> pr_consulta_estatus_plan_maquinas(Long id_plan_mqdet) throws Exception;

	public Double pr_consulta_estatus_area_plan_maquinas(Long id_plan_mqdet) throws Exception;

	public Long pr_borrar_dat_plan_servicios_mqdet_ejec(Long id) throws Exception;

	public void saveLogDatServRealizadosEquipo(LogDatServRealizadosEquipo entity) throws Exception;

	public void deleteLogDatServRealizadosEquipo(LogDatServRealizadosEquipo entity) throws Exception;

	public void updateLogDatServRealizadosEquipo(LogDatServRealizadosEquipo entity) throws Exception;

	public LogDatServRealizadosEquipo getLogDatServRealizadosEquipo(Long logDatServRealizadosEquipoId) throws Exception;

	public List<LogDatServRealizadosEquipo> findByCriteriaInLogDatServRealizadosEquipo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<LogDatServRealizadosEquipo> findPageLogDatServRealizadosEquipo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberLogDatServRealizadosEquipo() throws Exception;

	public List<LogDatServRealizadosEquipoDTO> getDataLogDatServRealizadosEquipo() throws Exception;

	public List<logServiciosMaqDTO> pr_log_dat_serv_realizados_equipo(Long compania, Long equipoid, Long documento)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_ingresos_cero(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_limite_cantidad(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Double cantidadmax) throws Exception;

	public void saveDatDiferidosVer2(DatDiferidos entity, List<ListaEquiposCategoriaDTO> dataDistr,
			List<DatDiferidosCuotasDTO> dataCuotas

	) throws Exception;

	public void updateDatDiferidosVer2(DatDiferidos entity, List<ListaEquiposCategoriaDTO> dataDistr,
			List<DatDiferidosCuotasDTO> dataCuotas

	) throws Exception;

	public List<CostosIndirectosEquipoDTO> pr_val_existencia_otros_costosmq(String idRegistro) throws Exception;

	public List<LaborCcontable> getLaborCcontable() throws Exception;

	public void saveLaborCcontable(LaborCcontable entity) throws Exception;

	public void deleteLaborCcontable(LaborCcontable entity) throws Exception;

	public void updateLaborCcontable(LaborCcontable entity) throws Exception;

	public LaborCcontable getLaborCcontable(Long id) throws Exception;

	public List<LaborCcontable> findByCriteriaInLaborCcontable(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaborCcontable> findPageLaborCcontable(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLaborCcontable() throws Exception;

	public List<LaborCcontableDTO> getDataLaborCcontable() throws Exception;

	public List<LaborCcontableDTO> getDataLaborCcontableByLabor(Long laborId) throws Exception;

	public List<ListaPlanillaNominaDTO> consultarListaPlanillaNomina(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String origen, String estadoplanilla) throws Exception;

	public List<ListaPlanillaNominaDetalladoDTO> reporteLaboresManualesDetalladoRD(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla, String origen, String estadoplanilla) throws Exception;

	public Long pr_borrar_analisis_lab_detalle(Long id) throws Exception;

	public Long pr_borrar_analisis_lab(Long id) throws Exception;

	public List<DatDiferidosAgricola> getDatDiferidosAgricola() throws Exception;

	public void saveDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception;

	public void deleteDatDiferidosAgricola(DatDiferidosAgricola entity) throws Exception;

	public void updateDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception;

	public DatDiferidosAgricola getDatDiferidosAgricola(Long datDiferidosAgricolaId) throws Exception;

	public List<DatDiferidosAgricola> findByCriteriaInDatDiferidosAgricola(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatDiferidosAgricola> findPageDatDiferidosAgricola(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatDiferidosAgricola() throws Exception;

	public List<DatDiferidosAgricolaDTO> getDataDatDiferidosAgricola() throws Exception;

	public List<DatDiferidosAgricolaDet> getDatDiferidosAgricolaDet() throws Exception;

	public void saveDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity) throws Exception;

	public void deleteDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity) throws Exception;

	public void updateDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity) throws Exception;

	public DatDiferidosAgricolaDet getDatDiferidosAgricolaDet(Long datDiferidosAgricolaDetId) throws Exception;

	public List<DatDiferidosAgricolaDet> findByCriteriaInDatDiferidosAgricolaDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatDiferidosAgricolaDet> findPageDatDiferidosAgricolaDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatDiferidosAgricolaDet() throws Exception;

	public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDet() throws Exception;

	public void saveDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception;

	public void updateDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception;

	public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(
			Long datDiferidosAgricolaId) throws Exception;

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos_agricola(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public long consultarConsecutivoDatDiferidosAgricola(Long compania) throws Exception;

	public Long pr_borrar_dat_diferidos_agricola(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_agricola_det(Long id) throws Exception;

	public List<DatDiferidosCuotasAgricolas> getDatDiferidosCuotasAgricolas() throws Exception;

	public void saveDatDiferidosCuotasAgricolas(DatDiferidosCuotasAgricolas entity) throws Exception;

	public void deleteDatDiferidosCuotasAgricolas(DatDiferidosCuotasAgricolas entity) throws Exception;

	public void updateDatDiferidosCuotasAgricolas(DatDiferidosCuotasAgricolas entity) throws Exception;

	public DatDiferidosCuotasAgricolas getDatDiferidosCuotasAgricolas(Long datDiferidosCuotasAgricolasId)
			throws Exception;

	public List<DatDiferidosCuotasAgricolas> findByCriteriaInDatDiferidosCuotasAgricolas(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatDiferidosCuotasAgricolas> findPageDatDiferidosCuotasAgricolas(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatDiferidosCuotasAgricolas() throws Exception;

	public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolas() throws Exception;

	public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolasByDatDiferidosAgricola(
			Long datDiferidosAgricolaId) throws Exception;

	public Long pr_borrar_dat_diferidos_cuotas_agricola(Long id) throws Exception;

	public List<DatNominaTrabajadorDTO> pr_lista_dat_nomina_trabajador(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla) throws Exception;

	public List<DatOtrosCostosDTO> pr_listar_otros_costos(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String tipoDistri) throws Exception;

	public List<DatTransProdDTO> pr_listar_produccion(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception;

	public List<DatPlanLaborDTO> pr_lista_plan_labor(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception;

	public List<PlanRevisionProd> getPlanRevisionProd() throws Exception;

	public void savePlanRevisionProd(PlanRevisionProd entity) throws Exception;

	public void deletePlanRevisionProd(PlanRevisionProd entity) throws Exception;

	public void updatePlanRevisionProd(PlanRevisionProd entity) throws Exception;

	public PlanRevisionProd getPlanRevisionProd(Long planRevisionProdId) throws Exception;

	public List<PlanRevisionProd> findByCriteriaInPlanRevisionProd(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionProd> findPagePlanRevisionProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionProd() throws Exception;

	public List<PlanRevisionProdDTO> getDataPlanRevisionProd() throws Exception;

	public List<PlanRevisionProdDTO> getDataPlanRevisionProdByPlanRevision(Long planRecursoId) throws Exception;

	public List<PuntosLubricacion> getPuntosLubricacion() throws Exception;

	public void savePuntosLubricacion(PuntosLubricacion entity) throws Exception;

	public void deletePuntosLubricacion(PuntosLubricacion entity) throws Exception;

	public void updatePuntosLubricacion(PuntosLubricacion entity) throws Exception;

	public PuntosLubricacion getPuntosLubricacion(Long puntoLubricacionId) throws Exception;

	public List<PuntosLubricacion> findByCriteriaInPuntosLubricacion(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PuntosLubricacion> findPagePuntosLubricacion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPuntosLubricacion() throws Exception;

	public List<PuntosLubricacionDTO> getDataPuntosLubricacion() throws Exception;

	public List<DatCheckListEquipo> getDatCheckListEquipo() throws Exception;

	public void saveDatCheckListEquipo(DatCheckListEquipo entity,
			List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
			List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet) throws Exception;

	public void deleteDatCheckListEquipo(DatCheckListEquipo entity) throws Exception;

	public void updateDatCheckListEquipo(DatCheckListEquipo entity,
			List<DatCheckListEquipoLaborDTO> dataDatCheckListEquipoLabor,
			List<DatCheckListEquipoDetDTO> dataDatCheckListEquipoDet) throws Exception;

	public DatCheckListEquipo getDatCheckListEquipo(Long datCheckListEquipoId) throws Exception;

	public List<DatCheckListEquipo> findByCriteriaInDatCheckListEquipo(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatCheckListEquipo> findPageDatCheckListEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatCheckListEquipo() throws Exception;

	public List<DatCheckListEquipoDTO> getDataDatCheckListEquipo() throws Exception;

	public List<DatCheckListEquipoDet> getDatCheckListEquipoDet() throws Exception;

	public void saveDatCheckListEquipoDet(DatCheckListEquipoDet entity) throws Exception;

	public void deleteDatCheckListEquipoDet(DatCheckListEquipoDet entity) throws Exception;

	public void updateDatCheckListEquipoDet(DatCheckListEquipoDet entity) throws Exception;

	public DatCheckListEquipoDet getDatCheckListEquipoDet(Long datCheckListEquipoDetId) throws Exception;

	public List<DatCheckListEquipoDet> findByCriteriaInDatCheckListEquipoDet(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatCheckListEquipoDet> findPageDatCheckListEquipoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatCheckListEquipoDet() throws Exception;

	public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDet() throws Exception;

	public List<DatCheckListEquipoLabor> getDatCheckListEquipoLabor() throws Exception;

	public void saveDatCheckListEquipoLabor(DatCheckListEquipoLabor entity) throws Exception;

	public void deleteDatCheckListEquipoLabor(DatCheckListEquipoLabor entity) throws Exception;

	public void updateDatCheckListEquipoLabor(DatCheckListEquipoLabor entity) throws Exception;

	public DatCheckListEquipoLabor getDatCheckListEquipoLabor(Long datCheckListEquipoLaborId) throws Exception;

	public List<DatCheckListEquipoLabor> findByCriteriaInDatCheckListEquipoLabor(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatCheckListEquipoLabor> findPageDatCheckListEquipoLabor(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatCheckListEquipoLabor() throws Exception;

	public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLabor() throws Exception;

	public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDetByCheckList(Long datCheckListEquipoId)
			throws Exception;

	public List<DatCheckListEquipoLaborDTO> getDataDatCheckListEquipoLaborByEquipo(Long checkListEquipoId)
			throws Exception;

	public List<ExportarPlanRevisionDTO> exportarPlanRevisionExcel(Long compania, String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception;

	public List<ListaNivel4DTO> pr_lista_nivel4_filtro_nivel3(String nivel3Id) throws Exception;

	public List<ListaNivel4DTO> listaCodigosErp(String nivel3Id) throws Exception;

	public Long pr_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal, Long usuarioId);

	public Long pr_re_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal,
			Long usuarioId);

	public List<DatOtrosCostosDetalle> getDatOtrosCostosDetalle() throws Exception;

	public void saveDatOtrosCostosDetalle(DatOtrosCostosDetalle entity) throws Exception;

	public void deleteDatOtrosCostosDetalle(DatOtrosCostosDetalle entity) throws Exception;

	public void updateDatOtrosCostosDetalle(DatOtrosCostosDetalle entity) throws Exception;

	public DatOtrosCostosDetalle getDatOtrosCostosDetalle(Long datOtrosCostosDetId) throws Exception;

	public List<DatOtrosCostosDetalle> findByCriteriaInDatOtrosCostosDetalle(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostosDetalle> findPageDatOtrosCostosDetalle(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostosDetalle() throws Exception;

	public List<DatOtrosCostosDetalleDTO> getDataDatOtrosCostosDetalle() throws Exception;

	public List<DatOtrosCostosDetalleDTO> getDataDatOtrosCostosDetalleByOtrosCostos(Long idOtrosCostos)
			throws Exception;

	public List<NominaDetalladaDTO> pr_desprendible_pago_agricola(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajadorId, Long flagTrabajador) throws Exception;

	public List<ConsultaDiferidosDTO> pr_dat_diferidos_agricolas(Long compania, Date fechaInicial, Date fechaFinal,
			String hacienda, Long flagHacienda, String lote, Long flagLote) throws Exception;

	public List<ListaProduccionDTO> pr_listar_reg_produccion(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String hacienda, Long flagHacienda, String lote, Long flagLote) throws Exception;

	public List<CostosTotalesDTO> pr_costos_ingresos_compania_detallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1)
			throws Exception;

	public List<CostosTotalesDTO> pr_costos_detallado(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception;

	public List<CostosTotalesDTO> pr_costos_ingresos_lotes_cosechados_periodo_det(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1,
			String grpLabor, Long flagGrpLabor) throws Exception;

	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception;

	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo_lotes_cosechados(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1,
			String grpLabor, Long flagGrpLabor) throws Exception;

	public List<CosechasLoteDTO> pr_pyg_lotes_cosechados(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception;

	public Long pr_borrar_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;

	public Long pr_interfaz_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;

	public List<CostosTotalesDTO> pr_costo_parcial_detallado(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor,
			Long diaslabor) throws Exception;

	public List<CostosTotalesDTO> pr_costo_parcial_resumen(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception;

	public List<CostosTotalesDTO> pr_costo_lotes_cerrados(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception;

	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) throws Exception;

	public List<ProduccionAcumFincaDTO> pr_produccion_lote_cerrado(Long compania, Date fecha_inicial, Date fecha_final,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) throws Exception;

	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado_corte(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, Long flagNumeroCosechas) throws Exception;

	public List<CostosTotalesDTO> pr_costo_parcial_resumen_labor(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception;

	public List<CostosTotalesDTO> pr_costo_parcial_resumen_lote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor,
			Long diaslabor) throws Exception;

	public List<ConsolidadoNominaDTO> pr_mo_desprendible_pago(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador);

	public List<CuadroPrecipitacionDiariaDTO> pr_comportamiento_lluvias(Long compania, Date fechaInicial,
			Date fechaFinal, String estPluvio, Long flagEstPluvio) throws Exception;

	public List<ListaNivel4DTO> pr_lista_etapas_lotes_cosechados(Long compania, Long idnivel4) throws Exception;

	public Long pr_asociar_reg_produccion_costos(Long idLote, Long idEtapa, Long reg_produccion_id, Long idCiclo)
			throws Exception;

	public Long pr_reabrir_cosecha_costos(Long idLote, Long idEtapa, Long reg_produccion_id, Long idCiclo)
			throws Exception;

	public Double pr_ultimo_valor_compra_producto(Long idProducto) throws Exception;

	public Long pr_recalculo_vr_hora_maquina(Long companiaid, Date fechaInicial, Date fechaFinal) throws Exception;

	public List<PrecioPromProdDTO> getDataProductosByServRealizados(Long datServRealizadosEquipoId) throws Exception;

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception;

	public Long pr_borrar_dat_servicio_equipo(Long idServicio) throws Exception;

	public Long pr_borrar_dat_servicio_equipo_det(Long idServicio) throws Exception;

	public Long pr_borrar_serv_producto(Long idServicio) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long categoria) throws Exception;

	public long pr_ultima_planilla_servicios_maq(Long compania, Date fecha, Long maquina, Long operarioId)
			throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_importacion_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura, Long usuario, String equipo, Long flagEquipo, String tipomovimiento) throws Exception;

	public String pr_importar_salidas_movil_enproceso(String precioprodid, String tipomovimiento);

	public long pr_ultima_programa_labores_maq(Long compania, Date fecha, Long cliente, Long supervisorId)
			throws Exception;

	public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPinesFiltroEquipo(Long equipoId) throws Exception;

	public List<UbicacionesAlmacen> getUbicacionesAlmacen() throws Exception;

	public void saveUbicacionesAlmacen(UbicacionesAlmacen entity) throws Exception;

	public void deleteUbicacionesAlmacen(UbicacionesAlmacen entity) throws Exception;

	public void updateUbicacionesAlmacen(UbicacionesAlmacen entity) throws Exception;

	public UbicacionesAlmacen getUbicacionesAlmacen(Long ubicacionesAlmacen) throws Exception;

	public List<UbicacionesAlmacen> findByCriteriaInUbicacionesAlmacen(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<UbicacionesAlmacen> findPageUbicacionesAlmacen(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberUbicacionesAlmacen() throws Exception;

	public List<UbicacionesAlmacenDTO> getDataUbicacionesAlmacen() throws Exception;

	public List<DatMantenimientoEquipoPlanRevision> getDatMantenimientoEquipoPlanRevision() throws Exception;

	public void saveDatMantenimientoEquipoPlanRevision(DatMantenimientoEquipoPlanRevision entity) throws Exception;

	public void deleteDatMantenimientoEquipoPlanRevision(DatMantenimientoEquipoPlanRevision entity) throws Exception;

	public void updateDatMantenimientoEquipoPlanRevision(DatMantenimientoEquipoPlanRevision entity) throws Exception;

	public DatMantenimientoEquipoPlanRevision getDatMantenimientoEquipoPlanRevision(Long datManPlanRevivionId)
			throws Exception;

	public List<DatMantenimientoEquipoPlanRevision> findByCriteriaInDatMantenimientoEquipoPlanRevision(
			Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipoPlanRevision> findPageDatMantenimientoEquipoPlanRevision(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipoPlanRevision() throws Exception;

	public List<DatMantenimientoEquipoPlanRevisionDTO> getDataDatMantenimientoEquipoPlanRevision() throws Exception;

	public List<SolicitudesMttoEquipoDTO> pr_formato_impresion_ot(Long compania, Date fechaInicial, Date fechaFinal,
			String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq_labor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_labor(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_hda(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_importacion_movil_formato_dia(Long compania,
			Date fechaInicial, Date fechaFinal, Long flagAlmacen) throws Exception;

	public List<DatMantenimientoEquipoPlanRevisionDTO> getDataDatMantenimientoEquipoPlanRevisionByMec(
			Long mantenimientoEquipoId) throws Exception;

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquiposPorVencer(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos, String estadoplan)
			throws Exception;

	public Long pr_actualizar_plan_revision_det(Long idequipo, Date fecha_ult_serv, Double horas, Double km,
			String planes, String estadoPlan) throws Exception;

	public List<ProgMttoPreventivosMaqDTO> pr_ordenes_trabajao_mtto_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String responsableMtto, Long flagResponsable,
			Long consecutivoOt, String estado_ot, Long centCost, String tipoOrden) throws Exception;

	public List<ProgLaboresMecMaqDTO> pr_lista_prog_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String cliente, Long flagCliente,
			String hacienda, Long flagHacienda, Long consecutivoOt, String labor, Long flagLabor, String grupoLabor,
			Long flagGrupoLabor, String finalizado, Double porc_avance) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception;

	public List<ProgMttoPreventivosMaqDTO> pr_ordenes_trabajao_mtto_maq_detalle(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String responsableMtto, Long flagResponsable,
			Long consecutivoOt, String tipoOrden) throws Exception;

	public Long pr_actualizar_prog_maquinaria(Long idprogramacion) throws Exception;

	public Long pr_borrar_dat_plan_servicios_mq(Long id) throws Exception;

	public Long pr_borrar_dat_plan_servicios_mqdet(Long id) throws Exception;

	public Long pr_act_prog_dat_serv_realizados_equipo_det(Long id) throws Exception;

	public List<ListaLaboresDTO> pr_lista_labores(Long compania, String grupoLabor) throws Exception;

	public Double pr_ult_horo_odometro_tanqueo(Long compania, Long idMaq) throws Exception;

	public List<ImportarNominaEmpAdmonDTO> pr_nomina_empleados_administrativos(Long compania, Date fechaInicial,
			Date fechaFinal, String tiponomina) throws Exception;

	public List<SolicitudesMttoEquipoDTO> pr_hoja_vida_maquina(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) throws Exception;

	public List<ProgramacionLaboresMaqDTO> pr_avance_proyectos_maq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica)
			throws Exception;

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoCosto) throws Exception;

	public Long pr_borrar_distribuccion_costos_ind_maquina(Long compania, Date fechaInicial, Date fechaFinal,
			String origen) throws Exception;

	public Long pr_insert_distribuccion_ingresos_equipos(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String origen) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception;

	public List<DistribuccionCostosMaquinaDTO> pr_lista_equipos_distribuccion(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaRegistrosUsuariosDTO> pr_digitaciones_por_usuario(Long compania, Date fechaInicial,
			Date fechaFinal, String tipo_reg, Long idusuario) throws Exception;

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos_detalle(Long compania, String anioMes,
			String idOrigen) throws Exception;

	public List<CostosIndirectosEquipoDTO> pr_compras_gastos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception;

	public List<SubTipoCotizante> getSubTipoCotizante() throws Exception;

	public void saveSubTipoCotizante(SubTipoCotizante entity) throws Exception;

	public void deleteSubTipoCotizante(SubTipoCotizante entity) throws Exception;

	public void updateSubTipoCotizante(SubTipoCotizante entity) throws Exception;

	public SubTipoCotizante getSubTipoCotizante(Long subTipoCotizanteId) throws Exception;

	public List<SubTipoCotizante> findByCriteriaInSubTipoCotizante(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SubTipoCotizante> findPageSubTipoCotizante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSubTipoCotizante() throws Exception;

	public List<SubTipoCotizanteDTO> getDataSubTipoCotizante() throws Exception;

	public List<TipoCotizante> getTipoCotizante() throws Exception;

	public void saveTipoCotizante(TipoCotizante entity) throws Exception;

	public void deleteTipoCotizante(TipoCotizante entity) throws Exception;

	public void updateTipoCotizante(TipoCotizante entity) throws Exception;

	public TipoCotizante getTipoCotizante(Long tipoCotizanteId) throws Exception;

	public List<TipoCotizante> findByCriteriaInTipoCotizante(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoCotizante> findPageTipoCotizante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoCotizante() throws Exception;

	public List<TipoCotizanteDTO> getDataTipoCotizante() throws Exception;

	public List<DatProvicionesCierreNomina> getDatProvicionesCierreNomina() throws Exception;

	public void saveDatProvicionesCierreNomina(DatProvicionesCierreNomina entity) throws Exception;

	public void deleteDatProvicionesCierreNomina(DatProvicionesCierreNomina entity) throws Exception;

	public void updateDatProvicionesCierreNomina(DatProvicionesCierreNomina entity) throws Exception;

	public DatProvicionesCierreNomina getDatProvicionesCierreNomina(Long datProvicionesCierreNominaId) throws Exception;

	public List<DatProvicionesCierreNomina> findByCriteriaInDatProvicionesCierreNomina(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatProvicionesCierreNomina> findPageDatProvicionesCierreNomina(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatProvicionesCierreNomina() throws Exception;

	public List<DatProvicionesCierreNominaDTO> getDataDatProvicionesCierreNomina() throws Exception;

	public List<DatProvicionesCierreNominaMq> getDatProvicionesCierreNominaMq() throws Exception;

	public void saveDatProvicionesCierreNominaMq(DatProvicionesCierreNominaMq entity) throws Exception;

	public void deleteDatProvicionesCierreNominaMq(DatProvicionesCierreNominaMq entity) throws Exception;

	public void updateDatProvicionesCierreNominaMq(DatProvicionesCierreNominaMq entity) throws Exception;

	public DatProvicionesCierreNominaMq getDatProvicionesCierreNominaMq(Long datProvicionesCierreNominaMqId)
			throws Exception;

	public List<DatProvicionesCierreNominaMq> findByCriteriaInDatProvicionesCierreNominaMq(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatProvicionesCierreNominaMq> findPageDatProvicionesCierreNominaMq(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatProvicionesCierreNominaMq() throws Exception;

	public List<DatProvicionesCierreNominaMqDTO> getDataDatProvicionesCierreNominaMq() throws Exception;

	public List<ListadoProvisionesDTO> pr_listar_proviciones(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception;

	public List<ListadoProvisionesDTO> pr_listar_proviciones_mq(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception;

	public List<SolicitudesMttoEquipoDTO> pr_ot_plan_revision(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, Long idMtto) throws Exception;

	public List<ConsultaCompraMateriaPrimaDTO> pr_lista_compra_materia_prima(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, Long documento) throws Exception;

	public long consultarConsecutivoDatCompraMateriaPrima(Long compania) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_materia_prima(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura) throws Exception;

	public List<DatCompraMateriaPrima> getDatCompraMateriaPrima() throws Exception;

	public void saveDatCompraMateriaPrima(DatCompraMateriaPrima entity,
			List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos) throws Exception;

	public void deleteDatCompraMateriaPrima(DatCompraMateriaPrima entity) throws Exception;

	public void updateDatCompraMateriaPrima(DatCompraMateriaPrima entity,
			List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos) throws Exception;

	public DatCompraMateriaPrima getDatCompraMateriaPrima(Long datCompraMateriaPrimaId) throws Exception;

	public List<DatCompraMateriaPrima> findByCriteriaInDatCompraMateriaPrima(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<DatCompraMateriaPrima> findPageDatCompraMateriaPrima(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatCompraMateriaPrima() throws Exception;

	public List<DatCompraMateriaPrimaDTO> getDataDatCompraMateriaPrima() throws Exception;

	public List<PrecioPromMateriaPrima> getPrecioPromMateriaPrima() throws Exception;

	public void savePrecioPromMateriaPrima(PrecioPromMateriaPrima entity) throws Exception;

	public void deletePrecioPromMateriaPrima(PrecioPromMateriaPrima entity) throws Exception;

	public void updatePrecioPromMateriaPrima(PrecioPromMateriaPrima entity) throws Exception;

	public PrecioPromMateriaPrima getPrecioPromMateriaPrima(Long precioPromMateriaPrimaId) throws Exception;

	public List<PrecioPromMateriaPrima> findByCriteriaInPrecioPromMateriaPrima(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

	public List<PrecioPromMateriaPrima> findPagePrecioPromMateriaPrima(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPrecioPromMateriaPrima() throws Exception;

	public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrima() throws Exception;

	public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByCompra(Long datCompraMateriaPrimaId)
			throws Exception;

	public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByInventario(Long datOtrosMovInventarioId)
			throws Exception;

	public List<TarifasArl> getTarifasArl() throws Exception;

	public void saveTarifasArl(TarifasArl entity) throws Exception;

	public void deleteTarifasArl(TarifasArl entity) throws Exception;

	public void updateTarifasArl(TarifasArl entity) throws Exception;

	public TarifasArl getTarifasArl(Long tarifasArlId) throws Exception;

	public List<TarifasArl> findByCriteriaInTarifasArl(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifasArl> findPageTarifasArl(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifasArl() throws Exception;

	public List<TarifasArlDTO> getDataTarifasArl() throws Exception;

	public List<ConsultaProgLaboresMaqDTO> pr_consulta_lista_prog_maquinaria(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception;

	public Long pr_calculo_provisiones_maq(Long companiaid, Date fechaInicial, Date fechaFinal, String operador,
			Long flagOperador, String tipoNomina, Long usuario) throws Exception;

	public Long borrar_dat_proviciones_cierre_nomina_mq(Long companiaid, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_nomina_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception;

	public List<DistribuccionCostosMaquinaDTO> pr_costos_distribuidos_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String idOrigen) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquina_grlabor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, Long grupoLabor) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquinaria(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo,
			String categoria, Long flagCategoriaEquipo, Long modeloEquipo) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception;

	public Long pr_recalcular_mano_obra_serv_maq(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;

	public Long pr_recalcular_mano_obra_serv_maq_parte2(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public Long pr_cierre_nomina_destajo_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String tipoNomina, Long usuario) throws Exception;
	public Long pr_borrar_trabajador_provisiones(Long compania, Date fechaInicial, Date fechaFinal,String trabajadores) throws Exception;

	public List<SolicitudesMttoEquipoDTO> pr_solicitudes_mtto_equipo_productos(Long compania, Date fechaInicial,
			Date fechaFinal,  String equipo, Long flagEquipo, String producto,
			Long flagProducto, String almacen, Long flagAlmacen, Long idMtto, Long datmttoprodid, Long tipoProducto) throws Exception;

public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo2(Long compania, Date fechaInicial,
		Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception;
public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetCombustible(Long compania,
		String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
		Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
		Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
		Long consecutivoRdl) throws Exception;


public void saveDatFacturaServiciosTerceros(
    DatFacturaServiciosTerceros entity) throws Exception;

public void deleteDatFacturaServiciosTerceros(
    DatFacturaServiciosTerceros entity) throws Exception;

public void updateDatFacturaServiciosTerceros(
    DatFacturaServiciosTerceros entity) throws Exception;

public DatFacturaServiciosTerceros getDatFacturaServiciosTerceros(
    Long datFacturaServiciosTercerosId) throws Exception;

public List<DatFacturaServiciosTerceros> findByCriteriaInDatFacturaServiciosTerceros(
    Object[] variables, Object[] variablesBetween,
    Object[] variablesBetweenDates) throws Exception;

public List<DatFacturaServiciosTerceros> findPageDatFacturaServiciosTerceros(
    String sortColumnName, boolean sortAscending, int startRow,
    int maxResults) throws Exception;

public Long findTotalNumberDatFacturaServiciosTerceros()
    throws Exception;

public List<DatFacturaServiciosTercerosDTO> getDataDatFacturaServiciosTerceros()
    throws Exception;

public long consec_dat_factura_servicios_terceros(Long compania) throws Exception;
public List<FacturaServiciosConsolidadosTercerosDTO> pr_listar_factura_servicios_terceros(Long compania, Date fechaInicial,
		Date fechaFinal, Long consec, Long centCost)throws Exception;
public List<FacturaServiciosConsolidadosTercerosDTO> pr_ingresos_egresos_terceros(Long compania, Date fechaInicial,
		Date fechaFinal, Long consec, Long centCost)throws Exception;
public List<ConsultaStockMaquinariaDTO> pr_inventario_recalculo_precio_entrada_producto(Long compania, Date fechaInicial,
		Date fechaFinal,  Long flagAlmacen, Long flagProducto) throws Exception;
public List<DatProductosRelacionados> getDatProductosRelacionados() throws Exception;

public void saveDatProductosRelacionados(DatProductosRelacionados entity) throws Exception;

public void deleteDatProductosRelacionados(DatProductosRelacionados entity) throws Exception;

public void updateDatProductosRelacionados(DatProductosRelacionados entity) throws Exception;

public DatProductosRelacionados getDatProductosRelacionados(Long datProductosAgregadosId) throws Exception;

public List<DatProductosRelacionados> findByCriteriaInDatProductosRelacionados(Object[] variables,
		Object[] variablesBetween, Object[] variablesBetweenDates) throws Exception;

public List<DatProductosRelacionados> findPageDatProductosRelacionados(String sortColumnName, boolean sortAscending,
		int startRow, int maxResults) throws Exception;

public Long findTotalNumberDatProductosRelacionados() throws Exception;

public List<DatProductosRelacionadosDTO> getDataDatProductosRelacionados() throws Exception;

public List<DatProductosRelacionadosDTO> getDataDatProductosRelacionadosByProducto(Long productoId)
		throws Exception;
public long pr_consec_producto_tipo(Long compania, Long tipoProd) throws Exception;
public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_realizados_equipo_det_combustible2(Long compania,
		String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
		Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
		Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
		Long consecutivoRdl, Long centCostId) throws Exception;
public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega_ubicacion(Long compania, Date fechaInicial,
		Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto)
		throws Exception;
}