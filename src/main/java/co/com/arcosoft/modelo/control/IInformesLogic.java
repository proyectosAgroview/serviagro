package co.com.arcosoft.modelo.control;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.*;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IInformesLogic {
	public List<DistribucionAreaVariedadDTO> consultarInformeDistribucionAreaVariedad(Long cultivo, String variedad)
			throws Exception;

	public List<DistribucionAreaFincaDTO> consultarInformeDistribucionAreaFinca(Long finca) throws Exception;

	public List<CostosFincaDTO> consultarInformeCostosFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia) throws Exception;

	public List<CostosGrupoLaborDTO> consultarInformeCostosGrupoLabor(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia) throws Exception;

	public List<CostosInsumosDTO> consultarInformeCostosInsumos(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto, Long flagProducto)
			throws Exception;

	public List<CostosInsumosDetalladoDTO> consultarInformeCostosInsumosDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, Long numPlanilla) throws Exception;

	public List<CostosServiciosContratadosDTO> consultarInformeCostosServiciosContratados(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String contratista, Long flagContratista) throws Exception;

	public List<DatosClimaticosDTO> consultarInformeDatosClimaticos(Long compania, Long estClima, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public List<DatosEvaporimetrosDTO> consultarInformeDatosEvaporimetros(Long estEvaporimetro, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public List<IndicadoresRiegoDTO> consultarInformeIndicadoresRiego(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura, Long flagInfraestructura,
			String sistemaRiego, Long flagSistemaRiego) throws Exception;

	public List<MateriaPrimaLoteDTO> consultarInformeMateriaPrimaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto) throws Exception;

	public List<PluviometriaDTO> consultarInformePluviometria(Long estPluvio, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public List<ProgramacionLaboresDTO> consultarInformeProgramacionLabores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String grupoLabor, Long flagGrupoLabor,
			String supervisor, Long flagSupervisor) throws Exception;

	public List<VariacionPrecioCultivoDTO> consultarInformeVariacionPrecioCultivo(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida,
			String tenencia, Long flagTenencia, String modCosecha, Long flagModCosecha, String noCosecha,
			Long flagNoCosecha, Long producto) throws Exception;

	public List<VariacionPrecioPromedioDTO> consultarInformeVariacionPrecioPromedio(Long compania, Date fechaInicial,
			Date fechaFinal, Long producto, String almacen, Long flagAlmacen) throws Exception;

	public List<IndicadorVisitasProductoresDTO> consultarInformeIndicadorVisitasProductores(Long compania,
			Date fechaInicial, Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String labor,
			Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor,
			String tenencia, Long flagTenencia, String ordenTrabajo, Long flagOrdenTrabajo) throws Exception;

	public List<ProntuarioLotesDTO> consultarInformeProntuarioLotes(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String tenencia,
			Long flagTenencia) throws Exception;

	public List<PyGDTO> consultarInformePyG(Long compania, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;

	public List<ProgramaCosechaDTO> consultarInformeProgramaCosecha(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String tenencia, Long flagTenencia) throws Exception;

	public List<EstadoOrdenTrabajoDTO> consultarInformeEstadoOrdenTrabajo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String ordenTrabajo,
			Long flagOrdenTrabajo) throws Exception;

	public List<AnalisisEnfermedadDTO> consultarAnalisisEnfermedad(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception;

	public List<AnalisisPlagaDTO> consultarAnalisisPlaga(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String plaga, Long flagPlaga) throws Exception;

	public List<CostosElementoCostosDTO> consultarInformeCostosElementoCostos(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia) throws Exception;

	public List<CostosVsIngresosCompaniaDTO> consultarInformeCostosVsIngresos(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, String numeroCosechas, Long flagNumeroCosechas) throws Exception;

	public List<DatosProduccionDTO> consultarInformeDatosProduccion(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) throws Exception;

	public List<DisponibilidadHidricaDTO> consultarInformeDisponibilidadHidrica(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura,
			Long flagInfraestructura, String sistemaRiego, Long flagSistemaRiego, Long numPlanilla) throws Exception;

	public List<IncidenciaEnfermedadDTO> consultarInformeIncidenciaEnfermedad(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception;

	public List<LiquidacionContratistaDTO> consultarInformeLiquidacionContratistas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista) throws Exception;

	public List<NominaDTO> consultarInformeNomina(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception;

	public List<PrecipitacionAniosDTO> consultarInformePrecipitacionAnios(Long estPluvio) throws Exception;

	public List<ProduccionAniosDTO> consultarInformeProduccionAnios(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia, String modCosecha,
			Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto, Long flagProducto)
			throws Exception;

	public List<ProduccionVsLluviaDTO> consultarInformeProduccionLluvia(Long compania, Date fechaInicial,
			Date fechaFinal, Date fechaInicialP, Date fechaFinalP, String zona, Long flagZona, String finca,
			Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String unidadMedida,
			Long flagUnidadMedida, String tenencia, Long flagTenencia, String modCosecha, Long flagModCosecha,
			String numeroCosechas, Long flagNumeroCosechas, String producto, Long flagProducto, Long pluvio)
			throws Exception;

	public List<RendimientoTrabajadoresDTO> consultarInformeRendimientoTrabajadores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista) throws Exception;

	public List<HorasMaquinaDetalladoDTO> consultarInformeHorasMaquinaDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo,
			Long numPlanilla) throws Exception;

	public List<HorasMaquinaDTO> consultarInformeHorasMaquina(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo)
			throws Exception;

	public List<DespachoProductoDTO> consultarInformeDespachoProducto(Long compania, Date fechaInicial, Date fechaFinal,
			String unidadMedida, Long flagUnidadMedida, String producto, Long flagProducto, String cliente,
			Long flagCliente) throws Exception;

	public List<DespachoProductoClienteDTO> consultarInformeDespachoProductoCliente(Long compania, Date fechaInicial,
			Date fechaFinal, String unidadMedida, Long flagUnidadMedida, String producto, Long flagProducto,
			String cliente, Long flagCliente) throws Exception;

	public List<CostosTotalesDTO> consultarInformeCostosTotales(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;

	public List<ActividadesTrabajadorDTO> consultarActividadesTrabajador(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception;

	public List<ActividadesTrabajadorResumenDTO> consultarActividadesTrabajadorResumen(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception;

	public List<ConsultaStockDTO> consultaStock(Long compania, String tipoProducto, Long flagTipoProducto,
			String producto, Long flagProducto, String almacen, Long flagAlmacen) throws Exception;

	public List<DistribucionAreaCultivoDTO> consultarInformeDistribuccionAreaCultivo(Long compania, String cultivo,
			Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String variedad, Long flagVariedad) throws Exception;

	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLote(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception;

	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteDet(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception;

	public List<ProduccionPalmaPesoPromedioDTO> consultarInformeProduccionPalmaPesoPromedio(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia,
			Long flagTenencia, String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha,
			String producto, Long flagProducto, String consecutivo, Long flagConsecutivo) throws Exception;

	public List<NominaDetalladaDTO> consultarInformeNominaDetallada(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador, String tipoTransaccion, Long planilla, Long concepto,
			String flagConcepto, String origen, String tipoPersonal) throws Exception;

	public List<CuadroPrecipitacionDiariaDTO> consultarInformeCuandroPrecipitacionDiario(Long compania,
			Date fechaInicial, Date fechaFinal, Date fechaInicialAcumulada, Date fechaFinalAcumulada, String estPluvio,
			Long flagEstPluvio) throws Exception;

	public List<AnalisisDiatraeaDTO> consultarAnalisisDiatraea(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote) throws Exception;

	public List<ProduccionAcumFincaDTO> consultarProduccionAcumFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) throws Exception;

	public List<MovimientoVagonCosechaDTO> consultarMovimientoVagon(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String vagon, Long flagVagon) throws Exception;

	public List<DetalleInsumosLoteDTO> consultaDetalleInsumosLoteDTO(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception;

	/****** fase fenologica ***/
	public String consultarFaseFenologica(Long faseFenologica, Date idFechaDescanso) throws Exception;

	public Long consultarFaseFenologicaId(Date idFechaDescanso) throws Exception;

	/******************* ++ASISTENCIA TECNICA *****/
	public List<ProduccionCortesDTO> consultarInformeProduccionCortes(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) throws Exception;

	public List<VisitasTecnicoResumenDTO> consultarInformeVisitasTecnicoResumen(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String trabajador,
			Long flagTrabajador, String productor, Long flagProductor, String cultivo, Long flagCultivo)
			throws Exception;

	public List<VisitasTecnicoDetalladoDTO> consultarInformeVisitasTecnicoDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String trabajador,
			Long flagTrabajador, String productor, Long flagProductor, String cultivo, Long flagCultivo)
			throws Exception;

	public List<PorcentajeProduccionProductorDTO> consultarInformeDatosPorcentajeProdProductor(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia,
			Long flagTenencia, String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas,
			String producto, Long flagProducto, String productor, Long flagProductor, String cultivo, Long flagCultivo)
			throws Exception;

	public List<PorcentajeProveedoresAsociadosDTO> consultarInformePorcentajeTipoProdocutor(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String cultivo, Long flagCultivo, String variedad, Long flagVariedad, String productor, Long flagProductor)
			throws Exception;

	public List<HojaVidaLoteDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String productor, Long flagProductor, String cultivo, Long flagCultivo, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String numeroCosechas, Long flagNumeroCosechas) throws Exception;

	/******************* CALCULAR EDAD LOTE **********/
	public Double calcularEdadLote(Date fechaActual, Long nivel4) throws Exception;

	/************** CONSULTA DE ORDEN DE TRABAJO ****************************/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDes(Long compania) throws Exception;

	/***** Consulta valores posibles variables sanidad vegetal ***/
	public List<ValoresPosiblesVariablesSanidadVegetalDTO> consultarValoresPosiblesVariablesSV(Long idVariable,
			BigDecimal valorVariable, Long idAnalisis) throws Exception;

	/**************
	 * CONSULTA CONSECUTIVO DE TRANSACCIONALES
	 *********************/
	public long consultarConsecutivoDatEstimCosecha(Long compania) throws Exception;

	public long consultarConsecutivoUnicoDatPlanillaNomina(Long compania) throws Exception;

	public long consultarConsecutivoDatPlanillaNomina(Long compania) throws Exception;

	public long consultarConsecutivoDatRiego(Long compania) throws Exception;

	public long consultarConsecutivoDatServicio(Long compania) throws Exception;

	public long consultarConsecutivoDatAplicProducto(Long compania) throws Exception;

	public long consultarConsecutivoDatTransProd(Long compania) throws Exception;

	public long consultarConsecutivoDatSanVeg(Long compania) throws Exception;

	public long consultarConsecutivoDatPlanLabor(Long compania) throws Exception;

	public long consultarConsecutivoDatBascula() throws Exception;

	public long consultarConsecutivoAbastecimientoCombustible(Long compania) throws Exception;

	public long consultarConsecutivoMantenimientoMaquinaria(Long compania, String tipo_orden) throws Exception;

	public Double consultarPrecioPromProducto(Long idProducto, Long idAlmacen, Long idCompania, Date idFecha)
			throws Exception;

	public BigDecimal consultarTarifaProfesion(Long idCompania, Long idContratista, Long idProfesion,
			Long idCeptoNomina, Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarTarifaLaborRendimiento(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarTarifaLaborBonificacion(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarTarifaLaborRendimientoBase(Long idCompania, Long idContratista, Long idLabor,
			Long idNivel2, Long idUdadMed, Date idFecha) throws Exception;

	public BigDecimal consultarAuxSabado(Long idCompania, Long idTrabajador, Date idFecha) throws Exception;

	public Long consultarDiaSabado(Date idFecha) throws Exception;

	public BigDecimal consultarTarifaEquipProp(Long idCompania, Long idEquipo, Long idUdadMed, Date idFecha)
			throws Exception;

	public BigDecimal consultarTarifaContratista(Long idCompania, Long idContratista, Long idLabor, Long idServicio,
			Long idUdadMed, Date idFecha, Double edadLote, String estadoInc, Long nivel2Id, Long nivel4Id,
			String alturaMata) throws Exception;

	/**** Consulta a DTO de transaccionales ***/
	public List<ConsultaDatPlanLaborDTO> consultaDatPlanLabor() throws Exception;

	/******** interfaces *********/
	public List<InterfaceNomina85DTO> consultarInterfaceNomina85(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception;

	/**** ACTUALIZACION 29-01-2017 ***/

	public List<ProgramacionSiembraCosechaDTO> consultarInformeProgramacionSiembraCosecha(Long compania,
			Long anioInicial, Long anioFinal, String productor, Long flagProductor, String variedad, Long flagVariedad,
			String supervisor, Long flagSupervisor) throws Exception;

	public List<ProgramacionSiembraCosechaVariedadDTO> consultarInformeProgramacionSiembraCosechaVariedad(Long compania,
			Long anioInicial, Long anioFinal, String productor, Long flagProductor, String variedad, Long flagVariedad,
			String supervisor, Long flagSupervisor) throws Exception;

	public List<DetalleInsumosMaquinariaDTO> consultaDetalleInsumosMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception;

	public List<ConsultaStockMaquinariaDTO> consultaStockMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen)
			throws Exception;

	public List<SolicitudesMttoEquipoDTO> consultarInformeSolciitudesMttoDet(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) throws Exception;

	public List<ProductoresPorTecnicoDTO> consultarProductoresPorTecnico(Long compania, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception;

	public List<LineaBaseProductorDTO> consultarLineaBaseProductor(Long compania, String contratista,
			Long flagContratista) throws Exception;

	public List<LineaBaseAsociacionDTO> consultarLineaBaseAsociacion(Long compania, String contratista,
			Long flagContratista) throws Exception;

	public List<ProgramaRiegosDTO> consultarInformeProgramaRiegos(Long compania, Long anio, Long mes, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String infraestructura, Long flagInfraestructura) throws Exception;

	/**** ACTUALIZACION 01-02-2017 ***/
	public long consultarConsecutivoProgramaSiembraCosecha(Long compania) throws Exception;

	public List<ProduccionAcumFincaDTO> consultarProduccionLoteDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) throws Exception;

	public List<BasculaVehiculosPesarDTO> consultarBasculaPesar(Long compania) throws Exception;

	public List<BasculaVehiculosTararDTO> consultarBasculaTarar(Long compania) throws Exception;

	/****** 09-0-2017 */
	public long consultarConsecutivoProgramRiego(Long compania) throws Exception;

	/*** 10-02-2017**bascula **/
	public List<TiquetesBasculaDTO> consultarTiqueteBascula(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo1, Long flagEquipo, String tiquete,
			Long flagTiquete, String estado1, Long flagEstado) throws Exception;

	public List<TiquetesBasculaImprimirProdDTO> consultarTiqueteBasculaImprimirProd(Long compania1, Long tiquete)
			throws Exception;

	public List<TiquetesBasculaImprimirDespachosDTO> consultarTiqueteBasculaImprimirDespachos(Long compania1,
			Long tiquete) throws Exception;

	public List<TiquetesBasculaDespachosInformeDTO> consultarTiqueteBasculaDespachosInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String contratista, Long flagContratista) throws Exception;

	public List<TiquetesBasculaProduccionInformeDTO> consultarTiqueteBasculaProduccionInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String contratista, Long flagContratista, String tipoFecha) throws Exception;

	/** 10-03-2017 ***/
	public long consultarConsecutivoOtrosCostos(Long compania) throws Exception;

	public long consultarConsecutivoConsolidadoNomina(Long compania) throws Exception;

	public List<ConsolidadoNominaDTO> consultarConsolidadoNomina(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String contratista, Long flagContratista) throws Exception;

	public List<CostosIndirectosDTO> consultarCostosIndirectos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String labor, Long flagLabor, String hacienda, Long flagHacienda,
			String lote, Long flagLote, String ccontable, Long flagCcontable) throws Exception;

	/** 18-03-2017 ***/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoEjecucionLabores(Long compania, Long ordenTrabajoDet)
			throws Exception;

	public List<ListadoRecursosDTO> consultaListadoRecursos(Long tipoRecursoId) throws Exception;

	public List<AnalisisEnfermedadVer2DTO> consultarAnalisisEnfermedadVer2(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception;

	public List<AnalisisPlagaVer2DTO> consultarAnalisisPlagaVer2(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String plaga, Long flagPlaga) throws Exception;

	public List<ConsultaEventosPorPagarDTO> consultarEventosPorPagar(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String propietario, Long flagPropietario, String evento, Long flagEvento)
			throws Exception;

	public long consultarConsecutivoOtrosCostosMq(Long compania) throws Exception;

	public long consultarConsecutivoServRealizados(Long compania, Long equipoId) throws Exception;

	public long consultarConsecutivoRegistroHorasEquipo(Long compania) throws Exception;

	public long consultarConsecutivoPlanAnualFabrica(Long compania) throws Exception;

	public long consultarConsecutivoCheckListEquipo(Long compania) throws Exception;

	public long consultarConsecutivoReporteFallasEquipo(Long compania) throws Exception;

	public long consultarConsecutivoDatSolicitudesMtto(Long compania) throws Exception;

	public List<CostosIndirectosEquipoDTO> consultarCostosIndirectosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String labor, Long flagLabor) throws Exception;

	public List<ProduccionLoteArcansasDTO> consultarProduccionLoteArcansas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote) throws Exception;

	public List<MttoReporteFallasEquipoDTO> consultarInformeReporteFallasEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) throws Exception;

	public List<MttoHorasTrabajadasEquipoDTO> consultarInformeHorasTrabajoEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) throws Exception;

	public List<MttoSalidaCombustibleEquipoDTO> consultarInformeSalidasCombustibleEquipo(Long compania,
			Date fechaInicial, Date fechaFinal, String propietario, Long flagPropietario, String equipo,
			Long flagEquipo) throws Exception;

	public List<MttoPlanFabricaDTO> consultarInformePlanFabrica(Long compania, Long anioInicial, Long anioFinal)
			throws Exception;

	public List<MttoCheckListEquipoDTO> consultarInformeCheckListEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) throws Exception;

	public List<MttoProyeccionMttoDTO> consultarInformeProyeccionMtto(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String planRevision, Long flagPlanRevision) throws Exception;

	public BigDecimal consultarHorometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania)
			throws Exception;

	public BigDecimal consultarOdometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania)
			throws Exception;

	public List<ConsultaSolicitudesParaMttoDTO> consultaSolicitudesParaMtto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto, String solicitante,
			Long flagSolicitante, String nivelPrioridad, Long flagNivelPrioridad, String origenDatos) throws Exception;

	public List<CalculoProxMttoDTO> consultarProximoMtto(Date fechaentrada, Long equipoid, Long planrevisionid,
			Double horasmtto, Double kmmtto) throws Exception;

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquipos(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos);

	public List<HorasMaquinaDetalladoDTO> consultarServRealizadosEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo)
			throws Exception;

	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteExpress(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception;

	public long consultarConsecutivoParadasFabrica(Long compania) throws Exception;

	public List<MttoParadasFabricaDTO> consultarInformeParosFabrica(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String tag, Long flagTag) throws Exception;

	public List<CatalogoEquiposDTO> consultarCatalogoEquipos(Long compania, String origenDatos) throws Exception;

	public List<ListaVariablesSanidadDTO> consultarListaVariablesSanidad(Long compania, Long tipoAnalisis)
			throws Exception;

	public long consultarIdUnicoDatSanVeg(Long compania) throws Exception;

	public long consultarConsecutivoDatAnalisisLaboratorio(Long compania) throws Exception;

	public long consultarIdUnicoDatAnalisisLaboratorio(Long compania) throws Exception;

	public List<ListaVariablesAnaLaboratorioDTO> consultarListaVariablesAnaLaboratorio(Long compania, Long tipoAnalisis)
			throws Exception;

	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> consultarTiqueteSinAnalisisCalidadFruto(Long compania)
			throws Exception;

	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> consultarTiqueteSinAnalisisCalidadDetalle(
			Long compania, Long tiquete) throws Exception;

	public List<AnalisisProcesoIndustrialDTO> consultarAnalisisProcesoIndustrial(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoAnalisis, Long flagTipoAnalisis) throws Exception;

	public long consultarConsec_dat_pluvio(Long compania) throws Exception;

	public List<CatalogProductoDTO> consultarCatalogoProductosAgricolas(Long compania) throws Exception;

	public List<CatalogProductoDTO> consultarCatalogoProductosMtto(Long compania) throws Exception;

	public double calcularHoras(Date fechaFinal, Date fechaInicial) throws Exception;

	public List<ListaNivel4DTO> consultarListaNivel4(Long compania, String nivel2) throws Exception;

	public Long borrarNivel4OtrosCostos(Long idOtrosCostos) throws Exception;

	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarMo(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String trabajador, Long flagTrabajador,
			String conceptonomina, Long flagconceptonomina) throws Exception;

	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarAusentismosMo(Long compania,
			Date fechaInicial, Date fechaFinal, String contratista, Long flagContratista, String trabajador,
			Long flagTrabajador, String conceptonomina, Long flagconceptonomina) throws Exception;

	public String aprobarOrdenesServicioNivel1(String idPlanLaborDet) throws Exception;

	public String aprobarOrdenesServicioNivel2(String idPlanLaborDet) throws Exception;

	/************** CONSULTA DE ORDEN DE TRABAJO ****************************/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDesAprobacion(Long compania) throws Exception;

	public long consultarExistenciaOtParaSolicitudMq(Long solicitudId) throws Exception;

	public List<CostosTotalesDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;

	public List<ConsultaMttoDTO> consultarMttoMaquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String propietarioEquipo, Long flagPropietarioEquipo, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto) throws Exception;

	public Long borrarCierreCostosNomina(Long compania, Long anio, Long mes) throws Exception;

	public Long borrarCierreCostosDistriMqAgricola(Long compania, Long anio, Long mes) throws Exception;

	public Long cierreCostosNomina(Long compania, Long anio, Long mes, String contratista, Long flagContratista)
			throws Exception;

	public Long cierreCostosDistriMqAgricola(Long compania, Long anio, Long mes, String equipo, Long flagEquipo,
			String contratista, Long flagContratista) throws Exception;

	public List<ProyeccionLaboresLoteDTO> consultarInformePresupuestoPorHacienda(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String cronogramaLabor,
			Long flagCronogramaLabor) throws Exception;

	public Long borrarCalculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public Long calculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception;

	public List<CatalogProductoDTO> consultarCatalogoProductosSegunTipo(Long compania, Long tipoProducto)
			throws Exception;

	public long consultarUltimaPlanillaNomina(Long compania, Date fecha) throws Exception;

	public List<ListaVariablesAnaLaboratorioDTO> pr_validar_existencia_analisis_lab(Long compania, Date fecha,
			String horaDigitacion, Long idAnalisis) throws Exception;

	public Long pr_borrar_dat_ana_laboratorio(Long id) throws Exception;

	public Long pr_borrar_dat_ana_laboratorio_det(Long id) throws Exception;

	public List<ProyeccionLaboresLoteDTO> pr_presupuesto_vs_ejecutado(Long compania, Date fechaInicial, Date fechaFinal,
			String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String cronogramaLabor, Long flagCronogramaLabor) throws Exception;

	List<TiquetesBasculaDTO> consultarEstadoVehiculo(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoEquipos, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception;

	List<TiquetesBasculaDTO> consultarEstadoVehiculoPr(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoEquipos, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception;

	public List<TiquetesBasculaDTO> pr_consulta_vehiculo_en_patio(Long compania, Long equipo) throws Exception;

	public long consultarConsecutivoDatTransProdPesoNeto(Long compania) throws Exception;

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

	public List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq(Long compania, String hdaId) throws Exception;

	public long consultarConsecutivoConsolidadoNominamq(Long compania) throws Exception;

	public Long borrarLiqServRealizadosOperario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;

	public Long interfazLiqServRealizadosEquipoOperario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception;

	public String preFecturarServicios(String datservrealizadosequipodetid) throws Exception;

	public String facturarServicios(String datservrealizadosequipodetid) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_reporte_serv_prefacturados(
			String datservrealizadosequipodetid) throws Exception;

	public Long actualizarConsecPrefacturaCompania(Long compania) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_prefacturas_por_cliente(Long clienteId)
			throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_cargar_serv_prefact_cliente(Long clienteId,
			String prefactura) throws Exception;

	public long consec_facturacion_servicios(Long compania) throws Exception;

	public Long actualizarNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura)
			throws Exception;

	public Long anularNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura) throws Exception;

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
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura, Long tipoProducto, String origenDatos)
			throws Exception;

	public List<ConsultaCostosDiferidosDTO> pr_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception;

	public String busquedaNivel2Clientes(String codNivel2C, Long idpersempr) throws Exception;

	public String busquedaNivel4Clientes(String codNivel4C, Long idnivel2C) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_facturas_cliente(String numFactura) throws Exception;

	public long consec_otros_mov_inventario(Long compania) throws Exception;

	public Long pr_reversar_prefactura_servicio(Long clienteId, Long numPrefactura) throws Exception;

	public List<ProntuarioLotesDTO> pr_prontuario_lotes_maquinaria(Long compania, String finca, Long flagFinca,
			String lote, Long flagLote, String proveedor, Long flagProveedor) throws Exception;

	public Double pr_saldo_prom_producto(Long idProducto, Long idAlmacen, Long idCompania) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_suministros_para_reposicion(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto) throws Exception;

	public Long pr_borrar_maq_otros_costosmq(Long idOtrosCostos) throws Exception;

	public long pr_max_id_unico_dat_compras(Long compania) throws Exception;

	public Long pr_recalcular_costo_productos(Long id_compras) throws Exception;

	public long pr_max_id_unico_dat_otros_costos_mq(Long compania) throws Exception;

	public long pr_max_id_unico_dat_omov_inventario(Long compania) throws Exception;

	public Long pr_borrar_suministros_taller(Long id) throws Exception;

	public Long pr_recalcular_otros_costosmq(Long id_ocostosmq) throws Exception;

	public Long pr_distri_suministros_taller(Long id_otros_mov_inventario) throws Exception;

	public long consec_req_productos(Long compania) throws Exception;

	public Long pr_busqueda_maq_ctrpin(Long idEquipo) throws Exception;

	public Long pr_actualiza_maq_ctrpin_consecutivo(Long idmaq, Long consecutivoPin) throws Exception;

	public Long pr_actualiza_edicion_dat_serv_realizados(Long idmaq, Long consecutivoPin) throws Exception;

	public BigDecimal pr_saldo_total_producto(Long idProducto, Long idCompania) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetPendientesFact(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) throws Exception;

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas_servdetal(Long cliente, String numFactura)
			throws Exception;

	public long consec_plan_serv_mq(Long compania) throws Exception;

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_distribuccion_factura(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long factura) throws Exception;

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_salidas(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long tipoProducto)
			throws Exception;

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
			String contratista, Long flagContratista, Long documento, String tipoCompra, Long numFactura) throws Exception;

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
			String tipogasto, Long documento, Long centCost, Long proveedor, String numFactura) throws Exception;

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

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal, Long documento, Long centCost, Long proveedor, String numfactura )
			throws Exception;

	public Long pr_borrar_dat_diferidos(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_det(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_cuotas(Long id) throws Exception;

	public Long pr_borrar_equipos_otros_costosmqdistr(Long id) throws Exception;

	public Long pr_borrar_dat_caja_menor_det_distr(Long id) throws Exception;

	public Long pr_borrar_precio_prom_prod_distribuccionmaq(Long id) throws Exception;

	public List<ProgramacionLaboresMaqDTO> pr_consulta_estatus_plan_maquinas(Long id_plan_mqdet) throws Exception;

	public Double pr_consulta_estatus_area_plan_maquinas(Long id_plan_mqdet) throws Exception;

	public Long pr_borrar_dat_plan_servicios_mqdet_ejec(Long id) throws Exception;

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

	public List<CostosIndirectosEquipoDTO> pr_val_existencia_otros_costosmq(String idRegistro) throws Exception;

	public List<ListaPlanillaNominaDTO> consultarListaPlanillaNomina(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String origen, String estadoplanilla) throws Exception;

	public List<ListaPlanillaNominaDetalladoDTO> reporteLaboresManualesDetalladoRD(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla, String origen, String estadoplanilla) throws Exception;

	public Long pr_borrar_analisis_lab_detalle(Long id) throws Exception;

	public Long pr_borrar_analisis_lab(Long id) throws Exception;

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos_agricola(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception;

	public long consultarConsecutivoDatDiferidosAgricola(Long compania) throws Exception;

	public Long pr_borrar_dat_diferidos_agricola(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_agricola_det(Long id) throws Exception;

	public Long pr_borrar_dat_diferidos_cuotas_agricola(Long id) throws Exception;

	public List<DatNominaTrabajadorDTO> pr_lista_dat_nomina_trabajador(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla) throws Exception;

	public List<DatOtrosCostosDTO> pr_listar_otros_costos(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String tipoDistri) throws Exception;

	public List<DatTransProdDTO> pr_listar_produccion(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception;

	public List<DatPlanLaborDTO> pr_lista_plan_labor(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception;

	public List<ExportarPlanRevisionDTO> exportarPlanRevisionExcel(Long compania, String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception;

	public List<ListaNivel4DTO> pr_lista_nivel4_filtro_nivel3(String nivel3Id) throws Exception;

	public List<ListaNivel4DTO> listaCodigosErp(String nivel3Id) throws Exception;

	public Long pr_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal, Long usuarioId);

	public Long pr_re_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal,
			Long usuarioId);

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

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception;

	public Long pr_borrar_dat_servicio_equipo(Long idServicio) throws Exception;

	public Long pr_borrar_dat_servicio_equipo_det(Long idServicio) throws Exception;

	public Long pr_borrar_serv_producto(Long idServicio) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long categoria) throws Exception;

	public long pr_ultima_planilla_servicios_maq(Long compania, Date fecha, Long maquina, Long operarioId) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_importacion_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura, Long usuario, String equipo, Long flagEquipo, String tipomovimiento) throws Exception;

	public String pr_importar_salidas_movil_enproceso(String precioprodid, String tipomovimiento);

	public long pr_ultima_programa_labores_maq(Long compania, Date fecha, Long cliente,Long supervisorId) throws Exception;

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
			Long flagGrupoLabor , String finalizado, Double porc_avance) throws Exception;

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

	public List<ImportarNominaEmpAdmonDTO> pr_nomina_empleados_administrativos(Long compania, Date fechaInicial, Date fechaFinal,
			String tiponomina) throws Exception;

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

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception;

	public Long pr_insert_distribuccion_ingresos_equipos(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String origen) throws Exception;

	public List<DistribuccionCostosMaquinaDTO> pr_lista_equipos_distribuccion(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception;

	public List<ConsultaRegistrosUsuariosDTO> pr_digitaciones_por_usuario(Long compania, Date fechaInicial,
			Date fechaFinal, String tipo_reg, Long idusuario) throws Exception;

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos_detalle(Long compania, String anioMes,
			String idOrigen) throws Exception;

	public List<CostosIndirectosEquipoDTO> pr_compras_gastos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception;

	public List<ListadoProvisionesDTO> pr_listar_proviciones(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception;

	public List<ListadoProvisionesDTO> pr_listar_proviciones_mq(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception;
	
	public List<SolicitudesMttoEquipoDTO> pr_ot_plan_revision(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo,  Long idMtto) throws Exception;
	
	public List<ConsultaCompraMateriaPrimaDTO> pr_lista_compra_materia_prima(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception;

	public long consultarConsecutivoDatCompraMateriaPrima(Long compania) throws Exception;

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_materia_prima(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura)
			throws Exception;
	
	public List<ConsultaProgLaboresMaqDTO> pr_consulta_lista_prog_maquinaria(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception;
	

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception;
	
	public Long pr_calculo_provisiones_maq(Long companiaid ,Date fechaInicial, Date fechaFinal, String operador, Long flagOperador,  String tipoNomina, Long usuario )  throws Exception;

	public Long borrar_dat_proviciones_cierre_nomina_mq(Long companiaid ,Date fechaInicial, Date fechaFinal) throws Exception ;
	
	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_nomina_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception;
	public List<DistribuccionCostosMaquinaDTO> pr_costos_distribuidos_equipo(  
			Long compania, Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo ,String idOrigen) throws Exception;
	

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquina_grlabor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo,  Long grupoLabor) throws Exception;


	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquinaria(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo,
			String categoria, Long flagCategoriaEquipo, Long modeloEquipo)
			throws Exception;

public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception;


public Long pr_recalcular_mano_obra_serv_maq(Long compania, Date fechaInicial, Date fechaFinal)throws Exception;
public Long pr_recalcular_mano_obra_serv_maq_parte2(Long compania, Date fechaInicial, Date fechaFinal)  throws Exception;


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
public long consec_dat_factura_servicios_terceros(Long compania) throws Exception;
public List<FacturaServiciosConsolidadosTercerosDTO> pr_listar_factura_servicios_terceros(Long compania, Date fechaInicial,
		Date fechaFinal, Long consec, Long centCost)throws Exception;
public List<FacturaServiciosConsolidadosTercerosDTO> pr_ingresos_egresos_terceros(Long compania, Date fechaInicial,
		Date fechaFinal, Long consec, Long centCost)throws Exception;
public List<ConsultaStockMaquinariaDTO> pr_inventario_recalculo_precio_entrada_producto(Long compania, Date fechaInicial,
		Date fechaFinal, Long flagAlmacen,  Long flagProducto) throws Exception;
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