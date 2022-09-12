package co.com.arcosoft.dataaccess.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.com.arcosoft.modelo.dto.DatCheckListEquipoLaborDTO;
import co.com.arcosoft.modelo.informes.dto.*;

public interface IInformesDAO {

	public List<DistribucionAreaVariedadDTO> consultarInformeDistribucionAreaVariedad(Long cultivo, String variedad);

	public List<DistribucionAreaFincaDTO> consultarInformeDistribucionAreaFinca(Long finca);

	public List<CostosFincaDTO> consultarInformeCostosFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia);
	
	public List<ConsultaMttoDTO> consultarMttoMaquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String propietarioEquipo, Long flagPropietarioEquipo, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto);

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
			Long numPlanilla)
			throws Exception;

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

	public List<CostosTotalesDTO> consultarInformeCostosTotales(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;

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
			String trabajador, Long flagTrabajador, String tipoTransaccion, Long planilla, Long concepto, String flagConcepto,
			String origen, String tipoPersonal) throws Exception;

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

	/******************* ++ASISTENCIA TECNICA *****/
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

	/******************* FASE FENOLOGICA DEL LOTE ****/
	public String consultarFaseFenologica(Long faseFenologica, Date idFechaDescanso) throws Exception;

	public Long consultarFaseFenologicaId(Date idFechaDescanso) throws Exception;

	/************** CONSULTA DE ORDEN DE TRABAJO ****************************/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDes(Long compania) throws Exception;

	/***** Consulta valores posibles variables sanidad vegetal ***/
	public List<ValoresPosiblesVariablesSanidadVegetalDTO> consultarValoresPosiblesVariablesSV(Long idVariable,
			BigDecimal valorVariable, Long idAnalisis) throws Exception;

	public List<ProduccionCortesDTO> consultarInformeProduccionCortes(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) throws Exception;

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

	/**** TARIFAS ****/
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
			Long idUdadMed, Date idFecha, Double edadLote, String estadoInc,  Long nivel2Id, Long nivel4Id,String alturaMata ) throws Exception;

	/**** Consulta a DTO de transaccionales ***/
	public List<ConsultaDatPlanLaborDTO> consultaDatPlanLabor() throws Exception;

	/************* interfaces ********/

	public List<InterfaceNomina85DTO> consultarInterfaceNomina85(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception;

	/**** ACTUALIZACION 29-01-2017 *****/

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

	/*** actualizacion 01-02-2017 ***/
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
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete, String contratista, Long flagContratista)
			throws Exception;

	public List<TiquetesBasculaProduccionInformeDTO> consultarTiqueteBasculaProduccionInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote,String contratista, Long flagContratista, String tipoFecha) throws Exception;

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
			String equipo, Long flagEquipo,
			String propietario, Long flagPropietario,
			String evento, Long flagEvento ) throws Exception;

	public long consultarConsecutivoOtrosCostosMq(Long compania) throws Exception;
	
	public long consultarConsecutivoServRealizados(Long compania, Long equipoId) throws Exception;
	public long consultarConsecutivoRegistroHorasEquipo(Long compania) throws Exception;
	public long consultarConsecutivoPlanAnualFabrica(Long compania) throws Exception;
	public long consultarConsecutivoCheckListEquipo(Long compania) throws Exception;
	public long consultarConsecutivoReporteFallasEquipo(Long compania) throws Exception;
	
	public List<CostosIndirectosEquipoDTO> consultarCostosIndirectosMq(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String labor, Long flagLabor) throws Exception;
	public List<ProduccionLoteArcansasDTO> consultarProduccionLoteArcansas(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote) throws Exception;;

	/**********************mantenimiento*********/
	public List<MttoReporteFallasEquipoDTO> consultarInformeReporteFallasEquipo(Long compania, Date fechaInicial,
					Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) ;

	public List<MttoHorasTrabajadasEquipoDTO> consultarInformeHorasTrabajoEquipo(Long compania, Date fechaInicial,
						Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) ;

	public List<MttoSalidaCombustibleEquipoDTO> consultarInformeSalidasCombustibleEquipo(Long compania, Date fechaInicial,
							Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) ;

	public List<MttoPlanFabricaDTO> consultarInformePlanFabrica(Long compania, Long anioInicial, Long anioFinal) ;

	public List<MttoCheckListEquipoDTO> consultarInformeCheckListEquipo(Long compania, Date fechaInicial,
									Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo) ;


	public List<MttoProyeccionMttoDTO> consultarInformeProyeccionMtto(Long compania, Date fechaInicial,
									Date fechaFinal, String equipo, Long flagEquipo, String planRevision, Long flagPlanRevision) ;

	public BigDecimal consultarHorometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania ); 
									

	public BigDecimal consultarOdometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania ) ;

	public long consultarConsecutivoDatSolicitudesMtto(Long compania);

	public List<ConsultaSolicitudesParaMttoDTO> consultaSolicitudesParaMtto(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto, String solicitante,
			Long flagSolicitante, String nivelPrioridad, Long flagNivelPrioridad, String origenDatos) throws Exception;

	public List<CalculoProxMttoDTO> consultarProximoMtto(Date fechaentrada, Long equipoid,
			Long planrevisionid, Double horasmtto, Double kmmtto);

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
	
	public List<MttoParadasFabricaDTO> consultarInformeParosFabrica(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String tag,  Long flagTag) throws Exception;

	public List<CatalogoEquiposDTO> consultarCatalogoEquipos(Long compania, String origenDatos) throws Exception;

	public List<ListaVariablesSanidadDTO> consultarListaVariablesSanidad(Long compania, Long tipoAnalisis )   throws Exception;
	
	public long consultarIdUnicoDatSanVeg(Long compania) throws Exception;
	
	public long consultarConsecutivoDatAnalisisLaboratorio(Long compania)  throws Exception;
	public long consultarIdUnicoDatAnalisisLaboratorio(Long compania) throws Exception;
	public List<ListaVariablesAnaLaboratorioDTO> consultarListaVariablesAnaLaboratorio(Long compania, Long tipoAnalisis ) throws Exception; 

	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> consultarTiqueteSinAnalisisCalidadFruto(Long compania)  throws Exception;
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> consultarTiqueteSinAnalisisCalidadDetalle(Long compania, Long tiquete)  throws Exception;

	public List<AnalisisProcesoIndustrialDTO> consultarAnalisisProcesoIndustrial(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoAnalisis, Long flagTipoAnalisis)  throws Exception;

	public long consultarConsec_dat_pluvio(Long compania) throws Exception;

	public List<CatalogProductoDTO> consultarCatalogoProductosAgricolas(Long compania) throws Exception;
	public List<CatalogProductoDTO> consultarCatalogoProductosMtto(Long compania) throws Exception;
	public double calcularHoras(Date fechaFinal, Date fechaInicial) throws Exception;

	public List<ListaNivel4DTO> consultarListaNivel4(Long compania, String nivel2) throws Exception;

	public Long borrarNivel4OtrosCostos(Long idOtrosCostos) throws Exception;

	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarMo(Long compania, Date fechaInicial, Date fechaFinal,
			 String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador,  String conceptonomina, Long flagconceptonomina)throws Exception;
		
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarAusentismosMo(Long compania, Date fechaInicial, Date fechaFinal,
			 String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador,  String conceptonomina, Long flagconceptonomina)throws Exception;
	
	public String aprobarOrdenesServicioNivel1(String idPlanLaborDet)throws Exception; 
	public String aprobarOrdenesServicioNivel2(String idPlanLaborDet)throws Exception;
		
	/************** CONSULTA DE ORDEN DE TRABAJO APROBACION ****************************/
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDesAprobacion(Long compania) throws Exception;

	public long consultarExistenciaOtParaSolicitudMq(Long solicitudId) throws Exception;
	
	public List<CostosTotalesDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception;
	
	public Long borrarCierreCostosNomina(Long compania, Long anio, Long mes)  throws Exception;
	public Long borrarCierreCostosDistriMqAgricola(Long compania, Long anio, Long mes)  throws Exception;
	public Long cierreCostosNomina(Long compania, Long anio, Long mes,
			 String contratista, Long flagContratista) throws Exception;
	public Long cierreCostosDistriMqAgricola(Long compania, Long anio, Long mes,
			String equipo, Long flagEquipo, String contratista, Long flagContratista) throws Exception;
	
	public List<ProyeccionLaboresLoteDTO> consultarInformePresupuestoPorHacienda(Long compania,
			String zona, Long flagZona, String finca, Long flagFinca,
			String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor,
			String cronogramaLabor, Long flagCronogramaLabor) throws Exception;
	
	public Long borrarCalculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal) throws Exception;
	
	public Long calculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal,
				String contratista, Long flagContratista, String trabajador, Long flagTrabajador
				) throws Exception;

	public List<CatalogProductoDTO> consultarCatalogoProductosSegunTipo(Long compania, Long tipoProducto) throws Exception;

	public long consultarUltimaPlanillaNomina(Long compania, Date fecha)throws Exception;
	

	public List<ListaVariablesAnaLaboratorioDTO> pr_validar_existencia_analisis_lab
							(Long compania, Date fecha, String horaDigitacion, Long idAnalisis )throws Exception;
	
	public Long pr_borrar_dat_ana_laboratorio(Long id) throws Exception;
	public Long pr_borrar_dat_ana_laboratorio_det(Long id)throws Exception;
	
	public List<ProyeccionLaboresLoteDTO> pr_presupuesto_vs_ejecutado(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception;
	
	public	List<TiquetesBasculaDTO> consultarEstadoVehiculo(Long compania1, Date fechaInicial, Date fechaFinal, String tipoMovimiento,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoEquipos, String estadoEquipos, String selectedTiquet, Long flagTiquet, String tiquete_peso_neto);
	
	public List<TiquetesBasculaDTO> consultarEstadoVehiculoPr(Long compania1, Date fechaInicial, Date fechaFinal, String tipoMovimiento,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoEquipos, String estadoEquipos, String selectedTiquet, Long flagTiquet, String tiquete_peso_neto);
	
	public List<TiquetesBasculaDTO> pr_consulta_vehiculo_en_patio(Long compania, Long equipo) throws Exception;	

	public long consultarConsecutivoDatTransProdPesoNeto(Long compania) throws Exception;
	
	public  List<ExportarPlanRevisionDTO>  exportarPlanRevisionExcel(Long compania,String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception;	
	

}