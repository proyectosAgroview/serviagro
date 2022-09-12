package co.com.arcosoft.modelo.control;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IInformes2DAO;
import co.com.arcosoft.dataaccess.dao.IInformesDAO;
import co.com.arcosoft.dataaccess.dao.InformesDAO;
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
@Scope("singleton")
@Service("InformesLogic")
public class InformesLogic implements IInformesLogic {
	private static final Logger log = LoggerFactory.getLogger(InformesDAO.class);

	/**
	 * DAO injected by Spring that manages Informes
	 *
	 */
	@Autowired
	private IInformesDAO informesDAO;

	@Autowired
	private IInformes2DAO informes2DAO;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DistribucionAreaVariedadDTO> consultarInformeDistribucionAreaVariedad(Long cultivo, String variedad)
			throws Exception {
		return informesDAO.consultarInformeDistribucionAreaVariedad(cultivo, variedad);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DistribucionAreaFincaDTO> consultarInformeDistribucionAreaFinca(Long finca) throws Exception {
		return informesDAO.consultarInformeDistribucionAreaFinca(finca);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosFincaDTO> consultarInformeCostosFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia) throws Exception {
		return informesDAO.consultarInformeCostosFinca(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia);
	}

	@Override
	public List<ConsultaMttoDTO> consultarMttoMaquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String propietarioEquipo, Long flagPropietarioEquipo, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto) throws Exception {
		return informesDAO.consultarMttoMaquinaria(compania, fechaInicial, fechaFinal, propietarioEquipo,
				flagPropietarioEquipo, equipo, flagEquipo, tipoMtto, flagTipoMtto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosGrupoLaborDTO> consultarInformeCostosGrupoLabor(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia) throws Exception {
		return informesDAO.consultarInformeCostosGrupoLabor(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosInsumosDTO> consultarInformeCostosInsumos(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto, Long flagProducto)
			throws Exception {
		return informesDAO.consultarInformeCostosInsumos(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, producto, flagProducto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosInsumosDetalladoDTO> consultarInformeCostosInsumosDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, Long numPlanilla) throws Exception {
		return informesDAO.consultarInformeCostosInsumosDetallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, producto, flagProducto, numPlanilla);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosServiciosContratadosDTO> consultarInformeCostosServiciosContratados(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String contratista, Long flagContratista) throws Exception {
		return informesDAO.consultarInformeCostosServiciosContratados(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida,
				flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DatosClimaticosDTO> consultarInformeDatosClimaticos(Long compania, Long estClima, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informesDAO.consultarInformeDatosClimaticos(compania, estClima, fechaInicial, fechaFinal);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DatosEvaporimetrosDTO> consultarInformeDatosEvaporimetros(Long estEvaporimetro, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informesDAO.consultarInformeDatosEvaporimetros(estEvaporimetro, fechaInicial, fechaFinal);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<IndicadoresRiegoDTO> consultarInformeIndicadoresRiego(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura, Long flagInfraestructura,
			String sistemaRiego, Long flagSistemaRiego) throws Exception {
		return informesDAO.consultarInformeIndicadoresRiego(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, infraestructura, flagInfraestructura, sistemaRiego,
				flagSistemaRiego);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MateriaPrimaLoteDTO> consultarInformeMateriaPrimaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto) throws Exception {
		return informesDAO.consultarInformeMateriaPrimaLote(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<PluviometriaDTO> consultarInformePluviometria(Long estPluvio, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesDAO.consultarInformePluviometria(estPluvio, fechaInicial, fechaFinal);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProgramacionLaboresDTO> consultarInformeProgramacionLabores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String grupoLabor, Long flagGrupoLabor,
			String supervisor, Long flagSupervisor) throws Exception {
		return informesDAO.consultarInformeProgramacionLabores(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, grupoLabor, flagGrupoLabor,
				supervisor, flagSupervisor);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<VariacionPrecioCultivoDTO> consultarInformeVariacionPrecioCultivo(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida,
			String tenencia, Long flagTenencia, String modCosecha, Long flagModCosecha, String noCosecha,
			Long flagNoCosecha, Long producto) throws Exception {
		return informesDAO.consultarInformeVariacionPrecioCultivo(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida,
				flagUnidadMedida, tenencia, flagTenencia, modCosecha, flagModCosecha, noCosecha, flagNoCosecha,
				producto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<VariacionPrecioPromedioDTO> consultarInformeVariacionPrecioPromedio(Long compania, Date fechaInicial,
			Date fechaFinal, Long producto, String almacen, Long flagAlmacen) throws Exception {
		return informesDAO.consultarInformeVariacionPrecioPromedio(compania, fechaInicial, fechaFinal, producto,
				almacen, flagAlmacen);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<IndicadorVisitasProductoresDTO> consultarInformeIndicadorVisitasProductores(Long compania,
			Date fechaInicial, Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String labor,
			Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor,
			String tenencia, Long flagTenencia, String ordenTrabajo, Long flagOrdenTrabajo) throws Exception {
		return informesDAO.consultarInformeIndicadorVisitasProductores(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, ordenTrabajo,
				flagOrdenTrabajo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProntuarioLotesDTO> consultarInformeProntuarioLotes(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String tenencia,
			Long flagTenencia) throws Exception {
		return informesDAO.consultarInformeProntuarioLotes(compania, zona, flagZona, finca, flagFinca, bloque,
				flagBloque, lote, flagLote, tenencia, flagTenencia);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<PyGDTO> consultarInformePyG(Long compania, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception {
		return informesDAO.consultarInformePyG(compania, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote,
				flagLote, numeroCosechas, flagNumeroCosechas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProgramaCosechaDTO> consultarInformeProgramaCosecha(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String tenencia, Long flagTenencia) throws Exception {
		return informesDAO.consultarInformeProgramaCosecha(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, tenencia, flagTenencia);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<EstadoOrdenTrabajoDTO> consultarInformeEstadoOrdenTrabajo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String ordenTrabajo,
			Long flagOrdenTrabajo) throws Exception {
		return informesDAO.consultarInformeEstadoOrdenTrabajo(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, ordenTrabajo, flagOrdenTrabajo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisEnfermedadDTO> consultarAnalisisEnfermedad(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception {
		return informesDAO.consultarAnalisisEnfermedad(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, enfermedad, flagEnfermedad);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisPlagaDTO> consultarAnalisisPlaga(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String plaga, Long flagPlaga) throws Exception {
		return informesDAO.consultarAnalisisPlaga(compania, fechaInicial, fechaFinal, zona, flagZona, finca, flagFinca,
				bloque, flagBloque, lote, flagLote, plaga, flagPlaga);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosElementoCostosDTO> consultarInformeCostosElementoCostos(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia) throws Exception {
		return informesDAO.consultarInformeCostosElementoCostos(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosVsIngresosCompaniaDTO> consultarInformeCostosVsIngresos(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String producto,
			Long flagProducto, String numeroCosechas, Long flagNumeroCosechas) throws Exception {
		return informesDAO.consultarInformeCostosVsIngresos(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, producto, flagProducto, numeroCosechas,
				flagNumeroCosechas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DatosProduccionDTO> consultarInformeDatosProduccion(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) throws Exception {
		return informesDAO.consultarInformeDatosProduccion(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, numeroCosechas, flagNumeroCosechas, producto, flagProducto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DisponibilidadHidricaDTO> consultarInformeDisponibilidadHidrica(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String infraestructura,
			Long flagInfraestructura, String sistemaRiego, Long flagSistemaRiego, Long numPlanilla) throws Exception {
		return informesDAO.consultarInformeDisponibilidadHidrica(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, infraestructura, flagInfraestructura, sistemaRiego,
				flagSistemaRiego, numPlanilla);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosTotalesDTO> consultarInformeCostosTotales(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception {
		return informesDAO.consultarInformeCostosTotales(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, numeroCosechas, flagNumeroCosechas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<IncidenciaEnfermedadDTO> consultarInformeIncidenciaEnfermedad(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception {
		return informesDAO.consultarInformeIncidenciaEnfermedad(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, enfermedad, flagEnfermedad);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<LiquidacionContratistaDTO> consultarInformeLiquidacionContratistas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista) throws Exception {
		return informesDAO.consultarInformeLiquidacionContratistas(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<NominaDTO> consultarInformeNomina(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception {
		return informesDAO.consultarInformeNomina(compania, fechaInicial, fechaFinal, zona, flagZona, finca, flagFinca,
				bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida, grupoLabor,
				flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador, flagTrabajador);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<PrecipitacionAniosDTO> consultarInformePrecipitacionAnios(Long estPluvio) throws Exception {
		return informesDAO.consultarInformePrecipitacionAnios(estPluvio);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionAniosDTO> consultarInformeProduccionAnios(Long compania, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia, String modCosecha,
			Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto, Long flagProducto)
			throws Exception {
		return informesDAO.consultarInformeProduccionAnios(compania, zona, flagZona, finca, flagFinca, bloque,
				flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia, modCosecha,
				flagModCosecha, numeroCosechas, flagNumeroCosechas, producto, flagProducto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionVsLluviaDTO> consultarInformeProduccionLluvia(Long compania, Date fechaInicial,
			Date fechaFinal, Date fechaInicialP, Date fechaFinalP, String zona, Long flagZona, String finca,
			Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote, String unidadMedida,
			Long flagUnidadMedida, String tenencia, Long flagTenencia, String modCosecha, Long flagModCosecha,
			String numeroCosechas, Long flagNumeroCosechas, String producto, Long flagProducto, Long pluvio)
			throws Exception {
		return informesDAO.consultarInformeProduccionLluvia(compania, fechaInicial, fechaFinal, fechaInicialP,
				fechaFinalP, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida,
				flagUnidadMedida, tenencia, flagTenencia, modCosecha, flagModCosecha, numeroCosechas,
				flagNumeroCosechas, producto, flagProducto, pluvio);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<RendimientoTrabajadoresDTO> consultarInformeRendimientoTrabajadores(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista) throws Exception {
		return informesDAO.consultarInformeRendimientoTrabajadores(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<HorasMaquinaDetalladoDTO> consultarInformeHorasMaquinaDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo,
			Long numPlanilla) throws Exception {
		return informesDAO.consultarInformeHorasMaquinaDetallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, propietarioEquipo, flagPropietarioEquipo,
				modeloEquipo, flagModeloEquipo, equipo, flagEquipo, numPlanilla);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<HorasMaquinaDTO> consultarInformeHorasMaquina(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo)
			throws Exception {
		return informesDAO.consultarInformeHorasMaquina(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, propietarioEquipo, flagPropietarioEquipo,
				modeloEquipo, flagModeloEquipo, equipo, flagEquipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DespachoProductoDTO> consultarInformeDespachoProducto(Long compania, Date fechaInicial, Date fechaFinal,
			String unidadMedida, Long flagUnidadMedida, String producto, Long flagProducto, String cliente,
			Long flagCliente) throws Exception {
		return informesDAO.consultarInformeDespachoProducto(compania, fechaInicial, fechaFinal, unidadMedida,
				flagUnidadMedida, producto, flagProducto, cliente, flagCliente);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DespachoProductoClienteDTO> consultarInformeDespachoProductoCliente(Long compania, Date fechaInicial,
			Date fechaFinal, String unidadMedida, Long flagUnidadMedida, String producto, Long flagProducto,
			String cliente, Long flagCliente) throws Exception {
		return informesDAO.consultarInformeDespachoProductoCliente(compania, fechaInicial, fechaFinal, unidadMedida,
				flagUnidadMedida, producto, flagProducto, cliente, flagCliente);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ActividadesTrabajadorDTO> consultarActividadesTrabajador(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception {
		return informesDAO.consultarActividadesTrabajador(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador,
				flagTrabajador);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ActividadesTrabajadorResumenDTO> consultarActividadesTrabajadorResumen(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception {
		return informesDAO.consultarActividadesTrabajadorResumen(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador,
				flagTrabajador);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaStockDTO> consultaStock(Long compania, String tipoProducto, Long flagTipoProducto,
			String producto, Long flagProducto, String almacen, Long flagAlmacen) throws Exception {
		return informesDAO.consultaStock(compania, tipoProducto, flagTipoProducto, producto, flagProducto, almacen,
				flagAlmacen);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DistribucionAreaCultivoDTO> consultarInformeDistribuccionAreaCultivo(Long compania, String cultivo,
			Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String variedad, Long flagVariedad) throws Exception {
		return informesDAO.consultarInformeDistribuccionAreaCultivo(compania, cultivo, flagCultivo, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, variedad, flagVariedad);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLote(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesDAO.consultarInformeProyeccionLaboresLote(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteDet(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesDAO.consultarInformeProyeccionLaboresLoteDet(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String consultarFaseFenologica(Long faseFenologica, Date idFechaDescanso) throws Exception {
		return informesDAO.consultarFaseFenologica(faseFenologica, idFechaDescanso);
	}

	@Override
	public Long consultarFaseFenologicaId(Date idFechaDescanso) throws Exception {
		return informesDAO.consultarFaseFenologicaId(idFechaDescanso);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionCortesDTO> consultarInformeProduccionCortes(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas, String producto,
			Long flagProducto) throws Exception {
		return informesDAO.consultarInformeProduccionCortes(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, numeroCosechas, flagNumeroCosechas, producto, flagProducto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionPalmaPesoPromedioDTO> consultarInformeProduccionPalmaPesoPromedio(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia,
			Long flagTenencia, String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha,
			String producto, Long flagProducto, String consecutivo, Long flagConsecutivo) throws Exception {
		return informesDAO.consultarInformeProduccionPalmaPesoPromedio(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida,
				tenencia, flagTenencia, modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto,
				consecutivo, flagConsecutivo);

	}

	@Override
	public List<NominaDetalladaDTO> consultarInformeNominaDetallada(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador, String tipoTransaccion, Long planilla, Long concepto,
			String flagConcepto, String origen, String tipoPersonal) throws Exception {
		return informesDAO.consultarInformeNominaDetallada(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador,
				flagTrabajador, tipoTransaccion, planilla, concepto, flagConcepto, origen, tipoPersonal);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CuadroPrecipitacionDiariaDTO> consultarInformeCuandroPrecipitacionDiario(Long compania,
			Date fechaInicial, Date fechaFinal, Date fechaInicialAcumulada, Date fechaFinalAcumulada, String estPluvio,
			Long flagEstPluvio) throws Exception {
		return informesDAO.consultarInformeCuandroPrecipitacionDiario(compania, fechaInicial, fechaFinal,
				fechaInicialAcumulada, fechaFinalAcumulada, estPluvio, flagEstPluvio);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisDiatraeaDTO> consultarAnalisisDiatraea(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote) throws Exception {
		return informesDAO.consultarAnalisisDiatraea(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionAcumFincaDTO> consultarProduccionAcumFinca(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) throws Exception {
		return informesDAO.consultarProduccionAcumFinca(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto, cliente, flagCliente);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MovimientoVagonCosechaDTO> consultarMovimientoVagon(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String vagon, Long flagVagon) throws Exception {
		return informesDAO.consultarMovimientoVagon(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto, vagon, flagVagon);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DetalleInsumosLoteDTO> consultaDetalleInsumosLoteDTO(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception {
		return informesDAO.consultaDetalleInsumosLoteDTO(compania, tipoProducto, flagTipoProducto, producto,
				flagProducto, almacen, flagAlmacen, fechaInicial, fechaFinal);

	}

	/******************* ++ASISTENCIA TECNICA *****/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<VisitasTecnicoResumenDTO> consultarInformeVisitasTecnicoResumen(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String trabajador,
			Long flagTrabajador, String productor, Long flagProductor, String cultivo, Long flagCultivo)
			throws Exception {
		return informesDAO.consultarInformeVisitasTecnicoResumen(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, trabajador, flagTrabajador, productor,
				flagProductor, cultivo, flagCultivo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<VisitasTecnicoDetalladoDTO> consultarInformeVisitasTecnicoDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String trabajador,
			Long flagTrabajador, String productor, Long flagProductor, String cultivo, Long flagCultivo)
			throws Exception {
		return informesDAO.consultarInformeVisitasTecnicoDetallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, trabajador, flagTrabajador, productor,
				flagProductor, cultivo, flagCultivo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<PorcentajeProduccionProductorDTO> consultarInformeDatosPorcentajeProdProductor(Long compania,
			Date fechaInicial, Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia,
			Long flagTenencia, String modCosecha, Long flagModCosecha, String numeroCosechas, Long flagNumeroCosechas,
			String producto, Long flagProducto, String productor, Long flagProductor, String cultivo, Long flagCultivo)
			throws Exception {
		return informesDAO.consultarInformeDatosPorcentajeProdProductor(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida,
				tenencia, flagTenencia, modCosecha, flagModCosecha, numeroCosechas, flagNumeroCosechas, producto,
				flagProducto, productor, flagProductor, cultivo, flagCultivo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<PorcentajeProveedoresAsociadosDTO> consultarInformePorcentajeTipoProdocutor(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String cultivo, Long flagCultivo, String variedad, Long flagVariedad, String productor, Long flagProductor)
			throws Exception {
		return informesDAO.consultarInformePorcentajeTipoProdocutor(compania, zona, flagZona, finca, flagFinca, bloque,
				flagBloque, lote, flagLote, cultivo, flagCultivo, variedad, flagVariedad, productor, flagProductor);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<HojaVidaLoteDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String productor, Long flagProductor, String cultivo, Long flagCultivo, String zona, Long flagZona,
			String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String numeroCosechas, Long flagNumeroCosechas) throws Exception {
		return informesDAO.consultarInformeHojaVidaLote(compania, fechaInicial, fechaFinal, productor, flagProductor,
				cultivo, flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote,
				numeroCosechas, flagNumeroCosechas);
	}

	/******************* CALCULAR EDAD LOTE **********/

	@Override
	public Double calcularEdadLote(Date fechaActual, Long nivel4) throws Exception {
		return informesDAO.calcularEdadLote(fechaActual, nivel4);
	}

	/***** CONSULTA ORDEN DE TRABAJO ***********/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDes(Long compania) throws Exception {
		return informesDAO.consultarOrdenTrabajoDes(compania);
	}

	/***** Consulta valores posibles variables sanidad vegetal ***/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ValoresPosiblesVariablesSanidadVegetalDTO> consultarValoresPosiblesVariablesSV(Long idVariable,
			BigDecimal valorVariable, Long idAnalisis) throws Exception {
		return informesDAO.consultarValoresPosiblesVariablesSV(idVariable, valorVariable, idAnalisis);
	}

	/*************** CONSECUTIVO DE TRANSACCIONALES ***********************/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatEstimCosecha(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatEstimCosecha(compania);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoUnicoDatPlanillaNomina(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoUnicoDatPlanillaNomina(compania);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatPlanillaNomina(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatPlanillaNomina(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatRiego(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatRiego(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatServicio(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatServicio(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatAplicProducto(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatAplicProducto(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatTransProd(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatTransProd(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatSanVeg(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatSanVeg(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatPlanLabor(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatPlanLabor(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatBascula() throws Exception {
		return informesDAO.consultarConsecutivoDatBascula();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoAbastecimientoCombustible(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoAbastecimientoCombustible(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoMantenimientoMaquinaria(Long compania, String tipo_orden) throws Exception {
		return informesDAO.consultarConsecutivoMantenimientoMaquinaria(compania, tipo_orden);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatSolicitudesMtto(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatSolicitudesMtto(compania);
	}

	/****** tarifas ****/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Double consultarPrecioPromProducto(Long idProducto, Long idAlmacen, Long idCompania, Date idFecha)
			throws Exception {
		return informesDAO.consultarPrecioPromProducto(idProducto, idAlmacen, idCompania, idFecha);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BigDecimal consultarTarifaProfesion(Long idCompania, Long idContratista, Long idProfesion,
			Long idCeptoNomina, Long idUdadMed, Date idFecha) throws Exception {
		return informesDAO.consultarTarifaProfesion(idCompania, idContratista, idProfesion, idCeptoNomina, idUdadMed,
				idFecha);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BigDecimal consultarTarifaLaborRendimiento(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception {
		return informesDAO.consultarTarifaLaborRendimiento(idCompania, idContratista, idLabor, idNivel2, idUdadMed,
				idFecha);
	}

	@Override
	public BigDecimal consultarTarifaLaborBonificacion(Long idCompania, Long idContratista, Long idLabor, Long idNivel2,
			Long idUdadMed, Date idFecha) throws Exception {
		return informesDAO.consultarTarifaLaborBonificacion(idCompania, idContratista, idLabor, idNivel2, idUdadMed,
				idFecha);
	}

	@Override
	public BigDecimal consultarTarifaLaborRendimientoBase(Long idCompania, Long idContratista, Long idLabor,
			Long idNivel2, Long idUdadMed, Date idFecha) throws Exception {
		return informesDAO.consultarTarifaLaborRendimientoBase(idCompania, idContratista, idLabor, idNivel2, idUdadMed,
				idFecha);
	}

	@Override
	public BigDecimal consultarAuxSabado(Long idCompania, Long idTrabajador, Date idFecha) throws Exception {
		return informesDAO.consultarAuxSabado(idCompania, idTrabajador, idFecha);
	}

	@Override
	public Long consultarDiaSabado(Date idFecha) throws Exception {
		return informesDAO.consultarDiaSabado(idFecha);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BigDecimal consultarTarifaEquipProp(Long idCompania, Long idEquipo, Long idUdadMed, Date idFecha)
			throws Exception {
		return informesDAO.consultarTarifaEquipProp(idCompania, idEquipo, idUdadMed, idFecha);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BigDecimal consultarTarifaContratista(Long idCompania, Long idContratista, Long idLabor, Long idServicio,
			Long idUdadMed, Date idFecha, Double edadLote, String estadoInc, Long nivel2Id, Long nivel4Id,
			String alturaMata) throws Exception {
		return informesDAO.consultarTarifaContratista(idCompania, idContratista, idLabor, idServicio, idUdadMed,
				idFecha, edadLote, estadoInc, nivel2Id, nivel4Id, alturaMata);
	}

	/**** Consulta a DTO de transaccionales ***/

	@Override
	public List<ConsultaDatPlanLaborDTO> consultaDatPlanLabor() throws Exception {
		return informesDAO.consultaDatPlanLabor();
	}

	/*** interfaces ***/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<InterfaceNomina85DTO> consultarInterfaceNomina85(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String contratista, Long flagContratista,
			String trabajador, Long flagTrabajador) throws Exception {
		return informesDAO.consultarInterfaceNomina85(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, contratista, flagContratista, trabajador,
				flagTrabajador);

	}

	/************* ACTUALIZACION 29-01-2017 ****/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProgramacionSiembraCosechaDTO> consultarInformeProgramacionSiembraCosecha(Long compania,
			Long anioInicial, Long anioFinal, String productor, Long flagProductor, String variedad, Long flagVariedad,
			String supervisor, Long flagSupervisor) throws Exception {
		return informesDAO.consultarInformeProgramacionSiembraCosecha(compania, anioInicial, anioFinal, productor,
				flagProductor, variedad, flagVariedad, supervisor, flagSupervisor);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProgramacionSiembraCosechaVariedadDTO> consultarInformeProgramacionSiembraCosechaVariedad(Long compania,
			Long anioInicial, Long anioFinal, String productor, Long flagProductor, String variedad, Long flagVariedad,
			String supervisor, Long flagSupervisor) throws Exception {
		return informesDAO.consultarInformeProgramacionSiembraCosechaVariedad(compania, anioInicial, anioFinal,
				productor, flagProductor, variedad, flagVariedad, supervisor, flagSupervisor);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DetalleInsumosMaquinariaDTO> consultaDetalleInsumosMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen,
			Date fechaInicial, Date fechaFinal) throws Exception {
		return informesDAO.consultaDetalleInsumosMaquinaria(compania, tipoProducto, flagTipoProducto, producto,
				flagProducto, almacen, flagAlmacen, fechaInicial, fechaFinal);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaStockMaquinariaDTO> consultaStockMaquinaria(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto, String almacen, Long flagAlmacen)
			throws Exception {
		return informesDAO.consultaStockMaquinaria(compania, tipoProducto, flagTipoProducto, producto, flagProducto,
				almacen, flagAlmacen);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<SolicitudesMttoEquipoDTO> consultarInformeSolciitudesMttoDet(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) throws Exception {
		return informesDAO.consultarInformeSolciitudesMttoDet(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo, tipoMtto, flagTipoMtto, idMtto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProductoresPorTecnicoDTO> consultarProductoresPorTecnico(Long compania, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception {
		return informesDAO.consultarProductoresPorTecnico(compania, contratista, flagContratista, trabajador,
				flagTrabajador);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<LineaBaseProductorDTO> consultarLineaBaseProductor(Long compania, String contratista,
			Long flagContratista) throws Exception {
		return informesDAO.consultarLineaBaseProductor(compania, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<LineaBaseAsociacionDTO> consultarLineaBaseAsociacion(Long compania, String contratista,
			Long flagContratista) throws Exception {
		return informesDAO.consultarLineaBaseAsociacion(compania, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProgramaRiegosDTO> consultarInformeProgramaRiegos(Long compania, Long anio, Long mes, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String infraestructura, Long flagInfraestructura) throws Exception {
		return informesDAO.consultarInformeProgramaRiegos(compania, anio, mes, zona, flagZona, finca, flagFinca, bloque,
				flagBloque, lote, flagLote, infraestructura, flagInfraestructura);
	}

	/*** actualizacion 01-02-2017 ***/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoProgramaSiembraCosecha(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoProgramaSiembraCosecha(compania);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionAcumFincaDTO> consultarProduccionLoteDetallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String unidadMedida, Long flagUnidadMedida, String tenencia, Long flagTenencia,
			String modCosecha, Long flagModCosecha, String noCosecha, Long flagNoCosecha, String producto,
			Long flagProducto, String cliente, Long flagCliente) throws Exception {
		return informesDAO.consultarProduccionLoteDetallado(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, unidadMedida, flagUnidadMedida, tenencia, flagTenencia,
				modCosecha, flagModCosecha, noCosecha, flagNoCosecha, producto, flagProducto, cliente, flagCliente);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<BasculaVehiculosPesarDTO> consultarBasculaPesar(Long compania) throws Exception {
		return informesDAO.consultarBasculaPesar(compania);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<BasculaVehiculosTararDTO> consultarBasculaTarar(Long compania) throws Exception {
		return informesDAO.consultarBasculaTarar(compania);

	}

	/**** 09-02-2017 ***/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoProgramRiego(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoProgramRiego(compania);

	}

	/*** 10-02-2017**bascula **/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaDTO> consultarTiqueteBascula(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoTransaccion, Long flagTipoTransaccion, String equipo1, Long flagEquipo, String tiquete,
			Long flagTiquete, String estado1, Long flagEstado) throws Exception {
		return informesDAO.consultarTiqueteBascula(compania1, fechaInicial, fechaFinal, tipoTransaccion,
				flagTipoTransaccion, equipo1, flagEquipo, tiquete, flagTiquete, estado1, flagEstado);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaImprimirProdDTO> consultarTiqueteBasculaImprimirProd(Long compania1, Long tiquete)
			throws Exception {
		return informesDAO.consultarTiqueteBasculaImprimirProd(compania1, tiquete);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaImprimirDespachosDTO> consultarTiqueteBasculaImprimirDespachos(Long compania1,
			Long tiquete) throws Exception {
		return informesDAO.consultarTiqueteBasculaImprimirDespachos(compania1, tiquete);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaDespachosInformeDTO> consultarTiqueteBasculaDespachosInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String contratista, Long flagContratista) throws Exception {
		return informesDAO.consultarTiqueteBasculaDespachosInforme(compania1, fechaInicial, fechaFinal, equipo1,
				flagEquipo, tiquete, flagTiquete, contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaProduccionInformeDTO> consultarTiqueteBasculaProduccionInforme(Long compania1,
			Date fechaInicial, Date fechaFinal, String equipo1, Long flagEquipo, String tiquete, Long flagTiquete,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String contratista, Long flagContratista, String tipoFecha) throws Exception {
		return informesDAO.consultarTiqueteBasculaProduccionInforme(compania1, fechaInicial, fechaFinal, equipo1,
				flagEquipo, tiquete, flagTiquete, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote,
				contratista, flagContratista, tipoFecha);
	}

	/** 10-03-2017 ***/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoOtrosCostos(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoOtrosCostos(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoConsolidadoNomina(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoConsolidadoNomina(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsolidadoNominaDTO> consultarConsolidadoNomina(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String contratista, Long flagContratista) throws Exception {
		return informesDAO.consultarConsolidadoNomina(compania, fechaInicial, fechaFinal, trabajador, flagTrabajador,
				contratista, flagContratista);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosIndirectosDTO> consultarCostosIndirectos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String labor, Long flagLabor, String hacienda, Long flagHacienda,
			String lote, Long flagLote, String ccontable, Long flagCcontable) throws Exception {
		return informesDAO.consultarCostosIndirectos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				labor, flagLabor, hacienda, flagHacienda, lote, flagLote, ccontable, flagCcontable);
	}

	/** 18-03-2017 ***/

	@Override
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoEjecucionLabores(Long compania, Long ordenTrabajoDet)
			throws Exception {
		return informesDAO.consultarOrdenTrabajoEjecucionLabores(compania, ordenTrabajoDet);
	}

	@Override
	public List<ListadoRecursosDTO> consultaListadoRecursos(Long tipoRecursoId) throws Exception {

		return informesDAO.consultaListadoRecursos(tipoRecursoId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisEnfermedadVer2DTO> consultarAnalisisEnfermedadVer2(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String enfermedad, Long flagEnfermedad) throws Exception {
		return informesDAO.consultarAnalisisEnfermedadVer2(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, enfermedad, flagEnfermedad);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisPlagaVer2DTO> consultarAnalisisPlagaVer2(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String plaga, Long flagPlaga) throws Exception {
		return informesDAO.consultarAnalisisPlagaVer2(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, plaga, flagPlaga);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaEventosPorPagarDTO> consultarEventosPorPagar(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String propietario, Long flagPropietario, String evento, Long flagEvento)
			throws Exception {
		return informesDAO.consultarEventosPorPagar(compania, fechaInicial, fechaFinal, equipo, flagEquipo, propietario,
				flagPropietario, evento, flagEvento);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoOtrosCostosMq(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoOtrosCostosMq(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoServRealizados(Long compania, Long equipoId) throws Exception {
		return informesDAO.consultarConsecutivoServRealizados(compania, equipoId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoRegistroHorasEquipo(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoRegistroHorasEquipo(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoPlanAnualFabrica(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoPlanAnualFabrica(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoCheckListEquipo(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoCheckListEquipo(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoReporteFallasEquipo(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoReporteFallasEquipo(compania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosIndirectosEquipoDTO> consultarCostosIndirectosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String labor, Long flagLabor) throws Exception {
		return informesDAO.consultarCostosIndirectosMq(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				labor, flagLabor);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProduccionLoteArcansasDTO> consultarProduccionLoteArcansas(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote) throws Exception {
		return informesDAO.consultarProduccionLoteArcansas(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote);
	}

	/*** mtto maquinaria ***/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoReporteFallasEquipoDTO> consultarInformeReporteFallasEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo)
			throws Exception {
		return informesDAO.consultarInformeReporteFallasEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoHorasTrabajadasEquipoDTO> consultarInformeHorasTrabajoEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo)
			throws Exception {
		return informesDAO.consultarInformeHorasTrabajoEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoSalidaCombustibleEquipoDTO> consultarInformeSalidasCombustibleEquipo(Long compania,
			Date fechaInicial, Date fechaFinal, String propietario, Long flagPropietario, String equipo,
			Long flagEquipo) throws Exception {
		return informesDAO.consultarInformeSalidasCombustibleEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoPlanFabricaDTO> consultarInformePlanFabrica(Long compania, Long anioInicial, Long anioFinal)
			throws Exception {
		return informesDAO.consultarInformePlanFabrica(compania, anioInicial, anioFinal);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoCheckListEquipoDTO> consultarInformeCheckListEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String propietario, Long flagPropietario, String equipo, Long flagEquipo)
			throws Exception {
		return informesDAO.consultarInformeCheckListEquipo(compania, fechaInicial, fechaFinal, propietario,
				flagPropietario, equipo, flagEquipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoProyeccionMttoDTO> consultarInformeProyeccionMtto(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String planRevision, Long flagPlanRevision) throws Exception {
		return informesDAO.consultarInformeProyeccionMtto(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				planRevision, flagPlanRevision);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CalculoProxMttoDTO> consultarProximoMtto(Date fechaentrada, Long equipoid, Long planrevisionid,
			Double horasmtto, Double kmmtto) throws Exception {
		return informesDAO.consultarProximoMtto(fechaentrada, equipoid, planrevisionid, horasmtto, kmmtto);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BigDecimal consultarHorometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania)
			throws Exception {
		return informesDAO.consultarHorometroActual(idFecha, idEquipo, idMedidor, idCompania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BigDecimal consultarOdometroActual(Date idFecha, Long idEquipo, Long idMedidor, Long idCompania)
			throws Exception {
		return informesDAO.consultarOdometroActual(idFecha, idEquipo, idMedidor, idCompania);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaSolicitudesParaMttoDTO> consultaSolicitudesParaMtto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String tipoMtto, Long flagTipoMtto, String solicitante,
			Long flagSolicitante, String nivelPrioridad, Long flagNivelPrioridad, String origenDatos) throws Exception {

		return informesDAO.consultaSolicitudesParaMtto(compania, fechaInicial, fechaFinal, equipo, flagEquipo, tipoMtto,
				flagTipoMtto, solicitante, flagSolicitante, nivelPrioridad, flagNivelPrioridad, origenDatos);
	}

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquipos(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos) {

		return informesDAO.consultarListaProximosMttoEquipos(compania, equipo, flagEquipo, planRevision,
				flagPlanRevision, origenDatos);
	}

	@Override
	public List<ExportarPlanRevisionDTO> exportarPlanRevisionExcel(Long compania, String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception {

		return informesDAO.exportarPlanRevisionExcel(compania, modulo, flagPlanRevision, planSeleccionados);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<HorasMaquinaDetalladoDTO> consultarServRealizadosEquipo(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida,
			String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia, String propietarioEquipo,
			Long flagPropietarioEquipo, String modeloEquipo, Long flagModeloEquipo, String equipo, Long flagEquipo)
			throws Exception {
		return informesDAO.consultarServRealizadosEquipo(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, propietarioEquipo, flagPropietarioEquipo,
				modeloEquipo, flagModeloEquipo, equipo, flagEquipo);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProyeccionLaboresLoteDTO> consultarInformeProyeccionLaboresLoteExpress(Long compania, Date fechaInicial,
			Date fechaFinal, String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca,
			String bloque, Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia,
			Long flagTenencia, String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesDAO.consultarInformeProyeccionLaboresLoteExpress(compania, fechaInicial, fechaFinal, cultivo,
				flagCultivo, zona, flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoParadasFabrica(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoParadasFabrica(compania);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<MttoParadasFabricaDTO> consultarInformeParosFabrica(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String tag, Long flagTag) throws Exception {
		return informesDAO.consultarInformeParosFabrica(compania, fechaInicial, fechaFinal, equipo, flagEquipo, tag,
				flagTag);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CatalogoEquiposDTO> consultarCatalogoEquipos(Long compania, String origenDatos) throws Exception {
		return informesDAO.consultarCatalogoEquipos(compania, origenDatos);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaVariablesSanidadDTO> consultarListaVariablesSanidad(Long compania, Long tipoAnalisis)
			throws Exception {
		return informesDAO.consultarListaVariablesSanidad(compania, tipoAnalisis);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarIdUnicoDatSanVeg(Long compania) throws Exception {
		return informesDAO.consultarIdUnicoDatSanVeg(compania);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatAnalisisLaboratorio(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatAnalisisLaboratorio(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarIdUnicoDatAnalisisLaboratorio(Long compania) throws Exception {
		return informesDAO.consultarIdUnicoDatAnalisisLaboratorio(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaVariablesAnaLaboratorioDTO> consultarListaVariablesAnaLaboratorio(Long compania, Long tipoAnalisis)
			throws Exception {
		return informesDAO.consultarListaVariablesAnaLaboratorio(compania, tipoAnalisis);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDTO> consultarTiqueteSinAnalisisCalidadFruto(Long compania)
			throws Exception {
		return informesDAO.consultarTiqueteSinAnalisisCalidadFruto(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaTiqueteSinAnalisisCalidadFrutoDetalleDTO> consultarTiqueteSinAnalisisCalidadDetalle(
			Long compania, Long tiquete) throws Exception {
		return informesDAO.consultarTiqueteSinAnalisisCalidadDetalle(compania, tiquete);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<AnalisisProcesoIndustrialDTO> consultarAnalisisProcesoIndustrial(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoAnalisis, Long flagTipoAnalisis) throws Exception {
		return informesDAO.consultarAnalisisProcesoIndustrial(compania, fechaInicial, fechaFinal, tipoAnalisis,
				flagTipoAnalisis);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsec_dat_pluvio(Long compania) throws Exception {
		return informesDAO.consultarConsec_dat_pluvio(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CatalogProductoDTO> consultarCatalogoProductosAgricolas(Long compania) throws Exception {
		return informesDAO.consultarCatalogoProductosAgricolas(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CatalogProductoDTO> consultarCatalogoProductosMtto(Long compania) throws Exception {
		return informesDAO.consultarCatalogoProductosMtto(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public double calcularHoras(Date fechaFinal, Date fechaInicial) throws Exception {
		return informesDAO.calcularHoras(fechaFinal, fechaInicial);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaNivel4DTO> consultarListaNivel4(Long compania, String nivel2) throws Exception {
		return informesDAO.consultarListaNivel4(compania, nivel2);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long borrarNivel4OtrosCostos(Long idOtrosCostos) throws Exception {
		return informesDAO.borrarNivel4OtrosCostos(idOtrosCostos);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarMo(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String trabajador, Long flagTrabajador,
			String conceptonomina, Long flagconceptonomina) throws Exception {
		return informesDAO.consultaInterfaceManagerExportarMo(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, trabajador, flagTrabajador, conceptonomina, flagconceptonomina);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<interfaceManagerExpRegistrosMODTO> consultaInterfaceManagerExportarAusentismosMo(Long compania,
			Date fechaInicial, Date fechaFinal, String contratista, Long flagContratista, String trabajador,
			Long flagTrabajador, String conceptonomina, Long flagconceptonomina) throws Exception {
		return informesDAO.consultaInterfaceManagerExportarAusentismosMo(compania, fechaInicial, fechaFinal,
				contratista, flagContratista, trabajador, flagTrabajador, conceptonomina, flagconceptonomina);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String aprobarOrdenesServicioNivel1(String idPlanLaborDet) throws Exception {
		return informesDAO.aprobarOrdenesServicioNivel1(idPlanLaborDet);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String aprobarOrdenesServicioNivel2(String idPlanLaborDet) throws Exception {
		return informesDAO.aprobarOrdenesServicioNivel1(idPlanLaborDet);
	}

	/***** CONSULTA ORDEN DE TRABAJO APROBACION ***********/

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ConsultaOrdenTrabajoDesDTO> consultarOrdenTrabajoDesAprobacion(Long compania) throws Exception {
		return informesDAO.consultarOrdenTrabajoDesAprobacion(compania);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarExistenciaOtParaSolicitudMq(Long solicitudId) throws Exception {
		return informesDAO.consultarExistenciaOtParaSolicitudMq(solicitudId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CostosTotalesDTO> consultarInformeHojaVidaLote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String tenencia, Long flagTenencia, String numeroCosechas, Long flagNumeroCosechas)
			throws Exception {
		return informesDAO.consultarInformeHojaVidaLote(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, tenencia, flagTenencia, numeroCosechas, flagNumeroCosechas);
	}

	public Long borrarCierreCostosNomina(Long compania, Long anio, Long mes) throws Exception {
		return informesDAO.borrarCierreCostosNomina(compania, anio, mes);

	}

	public Long borrarCierreCostosDistriMqAgricola(Long compania, Long anio, Long mes) throws Exception {
		return informesDAO.borrarCierreCostosDistriMqAgricola(compania, anio, mes);

	}

	public Long cierreCostosNomina(Long compania, Long anio, Long mes, String contratista, Long flagContratista)
			throws Exception {
		return informesDAO.cierreCostosNomina(compania, anio, mes, contratista, flagContratista);
	}

	public Long cierreCostosDistriMqAgricola(Long compania, Long anio, Long mes, String equipo, Long flagEquipo,
			String contratista, Long flagContratista) throws Exception {
		return informesDAO.cierreCostosDistriMqAgricola(compania, anio, mes, equipo, flagEquipo, contratista,
				flagContratista);
	}

	public List<ProyeccionLaboresLoteDTO> consultarInformePresupuestoPorHacienda(Long compania, String zona,
			Long flagZona, String finca, Long flagFinca, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String cronogramaLabor,
			Long flagCronogramaLabor) throws Exception {
		return informesDAO.consultarInformePresupuestoPorHacienda(compania, zona, flagZona, finca, flagFinca, labor,
				flagLabor, unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, cronogramaLabor,
				flagCronogramaLabor);
	}

	public Long borrarCalculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informesDAO.borrarCalculoDominicalesFestivosNomina(compania, fechaInicial, fechaFinal);
	}

	public Long calculoDominicalesFestivosNomina(Long compania, Date fechaInicial, Date fechaFinal, String contratista,
			Long flagContratista, String trabajador, Long flagTrabajador) throws Exception {
		return informesDAO.calculoDominicalesFestivosNomina(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, trabajador, flagTrabajador);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<CatalogProductoDTO> consultarCatalogoProductosSegunTipo(Long compania, Long tipoProducto)
			throws Exception {
		return informesDAO.consultarCatalogoProductosSegunTipo(compania, tipoProducto);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarUltimaPlanillaNomina(Long compania, Date fecha) throws Exception {
		return informesDAO.consultarUltimaPlanillaNomina(compania, fecha);
	}

	public List<ListaVariablesAnaLaboratorioDTO> pr_validar_existencia_analisis_lab(Long compania, Date fecha,
			String horaDigitacion, Long idAnalisis) throws Exception {
		return informesDAO.pr_validar_existencia_analisis_lab(compania, fecha, horaDigitacion, idAnalisis);
	}

	public Long pr_borrar_dat_ana_laboratorio(Long id) throws Exception {
		return informesDAO.pr_borrar_dat_ana_laboratorio(id);
	}

	public Long pr_borrar_dat_ana_laboratorio_det(Long id) throws Exception {
		return informesDAO.pr_borrar_dat_ana_laboratorio_det(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ProyeccionLaboresLoteDTO> pr_presupuesto_vs_ejecutado(Long compania, Date fechaInicial, Date fechaFinal,
			String cultivo, Long flagCultivo, String zona, Long flagZona, String finca, Long flagFinca, String bloque,
			Long flagBloque, String lote, Long flagLote, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String tenencia, Long flagTenencia,
			String cronogramaLabor, Long flagCronogramaLabor) throws Exception {
		return informesDAO.pr_presupuesto_vs_ejecutado(compania, fechaInicial, fechaFinal, cultivo, flagCultivo, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, unidadMedida,
				flagUnidadMedida, grupoLabor, flagGrupoLabor, tenencia, flagTenencia, cronogramaLabor,
				flagCronogramaLabor);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaDTO> consultarEstadoVehiculo(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoSeleccionado, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception {
		return informesDAO.consultarEstadoVehiculo(compania1, fechaInicial, fechaFinal, tipoMovimiento, tipoTransaccion,
				flagTipoTransaccion, equipo, flagEquipo, flagEstadoTiquete, estadoSeleccionado, selectedTiquet,
				flagTiquet, tiquete_peso_neto);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<TiquetesBasculaDTO> consultarEstadoVehiculoPr(Long compania1, Date fechaInicial, Date fechaFinal,
			String tipoMovimiento, String tipoTransaccion, Long flagTipoTransaccion, String equipo, Long flagEquipo,
			Long flagEstadoTiquete, String estadoSeleccionado, String selectedTiquet, Long flagTiquet,
			String tiquete_peso_neto) throws Exception {
		return informesDAO.consultarEstadoVehiculoPr(compania1, fechaInicial, fechaFinal, tipoMovimiento,
				tipoTransaccion, flagTipoTransaccion, equipo, flagEquipo, flagEstadoTiquete, estadoSeleccionado,
				selectedTiquet, flagTiquet, tiquete_peso_neto);

	}

	public List<TiquetesBasculaDTO> pr_consulta_vehiculo_en_patio(Long compania, Long equipo) throws Exception {
		return informesDAO.pr_consulta_vehiculo_en_patio(compania, equipo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoDatTransProdPesoNeto(Long compania) throws Exception {
		return informesDAO.consultarConsecutivoDatTransProdPesoNeto(compania);
	}

	public List<ListaNivel2ClientesmqDTO> listaNivel2Clientesmq(Long compania, Long clienteId) throws Exception {
		return informes2DAO.listaNivel2Clientesmq(compania, clienteId);
	}

	public BigDecimal consultarAdicionalManoObra(Long idCompania, Long idLabor, Long idUdadMed, Date fecha,
			Double cantidad) throws Exception {
		return informes2DAO.consultarAdicionalManoObra(idCompania, idLabor, idUdadMed, fecha, cantidad);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosMq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.consultaServRealizadosMq(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDet(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl, Long centCostId) throws Exception {
		return informes2DAO.consultaServRealizadosEquipoDet(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl, centCostId);

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaLiqServRealizadosEquipoOperario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception {
		return informes2DAO.consultaLiqServRealizadosEquipoOperario(compania, fechaInicial, fechaFinal, operador,
				flagOperador, equipo, flagEquipo);
	}

	public List<ListaNivel4ClientesmqDTO> listaNivel4Clientesmq(Long compania, String hdaId) throws Exception {
		return informes2DAO.listaNivel4Clientesmq(compania, hdaId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public long consultarConsecutivoConsolidadoNominamq(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoConsolidadoNominamq(compania);
	}

	public Long borrarLiqServRealizadosOperario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informes2DAO.borrarLiqServRealizadosOperario(compania, fechaInicial, fechaFinal);
	}

	public Long interfazLiqServRealizadosEquipoOperario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.interfazLiqServRealizadosEquipoOperario(compania, fechaInicial, fechaFinal, trabajador,
				flagTrabajador, equipo, flagEquipo);
	}

	public String preFecturarServicios(String datservrealizadosequipodetid) throws Exception {
		return informes2DAO.preFecturarServicios(datservrealizadosequipodetid);
	}

	public String facturarServicios(String datservrealizadosequipodetid) throws Exception {
		return informes2DAO.facturarServicios(datservrealizadosequipodetid);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_reporte_serv_prefacturados(
			String datservrealizadosequipodetid) throws Exception {
		return informes2DAO.pr_reporte_serv_prefacturados(datservrealizadosequipodetid);
	}

	public Long actualizarConsecPrefacturaCompania(Long compania) throws Exception {
		return informes2DAO.actualizarConsecPrefacturaCompania(compania);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_prefacturas_por_cliente(Long clienteId)
			throws Exception {
		return informes2DAO.pr_consulta_prefacturas_por_cliente(clienteId);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_cargar_serv_prefact_cliente(Long clienteId,
			String prefactura) throws Exception {
		return informes2DAO.pr_cargar_serv_prefact_cliente(clienteId, prefactura);
	}

	public long consec_facturacion_servicios(Long compania) throws Exception {
		return informes2DAO.consec_facturacion_servicios(compania);

	}

	public Long actualizarNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura)
			throws Exception {
		return informes2DAO.actualizarNumFacturaEnDatServRDet(datservrealizadosequipodetid, numfactura);

	}

	public Long anularNumFacturaEnDatServRDet(String datservrealizadosequipodetid, String numfactura) throws Exception {
		return informes2DAO.anularNumFacturaEnDatServRDet(datservrealizadosequipodetid, numfactura);

	}

	public long consultarConsecutivoDatHerramientas(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoDatHerramientas(compania);
	}

	public long consultarConsecutivoPagoNotasClientes(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoPagoNotasClientes(compania);
	}

	public long consultarConsecutivoCajaMenor(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoCajaMenor(compania);
	}

	public long consultarConsecutivoDatDiferidos(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoDatDiferidos(compania);
	}

	public long consultarConsecutivoDatCompraProductos(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoDatCompraProductos(compania);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_factura_serv_consolidada_detal(String factura)
			throws Exception {
		return informes2DAO.pr_consulta_factura_serv_consolidada_detal(factura);

	}

	public String pr_borrar_factura_servicio_consolidada(String numfactura) throws Exception {
		return informes2DAO.pr_borrar_factura_servicio_consolidada(numfactura);
	}

	public String pr_reversar_factura_servicio_consolidada_detal(String numfactura) throws Exception {
		return informes2DAO.pr_reversar_factura_servicio_consolidada_detal(numfactura);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception {
		return informes2DAO.pr_facturas_consolidadas(compania, estadoFactura, fechaInicial, fechaFinal, cliente,
				flagCliente, numFactura);
	}

	public List<ListadoPinesMaquinariaDTO> pr_listado_pines_equipo(Long compania, String equipo, Long flagEquipo)
			throws Exception {
		return informes2DAO.pr_listado_pines_equipo(compania, equipo, flagEquipo);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_factura_vs_pago_realizados(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception {
		return informes2DAO.pr_factura_vs_pago_realizados(compania, estadoFactura, fechaInicial, fechaFinal, cliente,
				flagCliente, numFactura);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_cartera_clientes(Long compania, String estadoFactura,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String numFactura) throws Exception {
		return informes2DAO.pr_saldo_cartera_clientes(compania, estadoFactura, fechaInicial, fechaFinal, cliente,
				flagCliente, numFactura);
	}

	public Long pr_borrar_equipos_otros_costosmq(Long idOtrosCostosmq) throws Exception {
		return informes2DAO.pr_borrar_equipos_otros_costosmq(idOtrosCostosmq);
	}

	public List<ListaEquiposCategoriaDTO> pr_lista_equipo(Long categoriaid) throws Exception {
		return informes2DAO.pr_lista_equipo(categoriaid);
	}

	public List<CostosIndirectosEquipoDTO> pr_otros_costos_maquinaria_saz(Long compania, Date fechaInicial,
			Date fechaFinal, String labor, Long flagLabor, Long documento, String equipo, Long flagEquipo)
			throws Exception {
		return informes2DAO.pr_otros_costos_maquinaria_saz(compania, fechaInicial, fechaFinal, labor, flagLabor,
				documento, equipo, flagEquipo);
	}

	public List<ConsultaCajaMenorDTO> pr_caja_menor(Long compania, Date fechaInicial, Date fechaFinal, String caja,
			Long flagCaja, String equipo, Long flagEquipo, String labor, Long flagLabor, Long consecutivo)
			throws Exception {
		return informes2DAO.pr_caja_menor(compania, fechaInicial, fechaFinal, caja, flagCaja, equipo, flagEquipo, labor,
				flagLabor, consecutivo);
	}

	public List<ConsultaCompraProductosDTO> pr_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception {
		return informes2DAO.pr_compra_productos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				documento);

	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex, Long factura,
			Long tipoProducto, String origenDatos) throws Exception {
		return informes2DAO.pr_inventario_detalle(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex, conseckardex, factura,
				tipoProducto, origenDatos);
	}

	public List<ConsultaCostosDiferidosDTO> pr_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informes2DAO.pr_dat_diferidos(compania, fechaInicial, fechaFinal);

	}

	public String busquedaNivel2Clientes(String codNivel2C, Long idpersempr) throws Exception {
		return informes2DAO.busquedaNivel2Clientes(codNivel2C, idpersempr);
	}

	public String busquedaNivel4Clientes(String codNivel4C, Long idnivel2C) throws Exception {
		return informes2DAO.busquedaNivel4Clientes(codNivel4C, idnivel2C);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_saldo_facturas_cliente(String numFactura) throws Exception {
		return informes2DAO.pr_saldo_facturas_cliente(numFactura);
	}

	public long consec_otros_mov_inventario(Long compania) throws Exception {
		return informes2DAO.consec_otros_mov_inventario(compania);
	}

	public Long pr_reversar_prefactura_servicio(Long clienteId, Long numPrefactura) throws Exception {
		return informes2DAO.pr_reversar_prefactura_servicio(clienteId, numPrefactura);
	}

	public List<ProntuarioLotesDTO> pr_prontuario_lotes_maquinaria(Long compania, String finca, Long flagFinca,
			String lote, Long flagLote, String proveedor, Long flagProveedor) throws Exception {
		return informes2DAO.pr_prontuario_lotes_maquinaria(compania, finca, flagFinca, lote, flagLote, proveedor,
				flagProveedor);
	}

	public Double pr_saldo_prom_producto(Long idProducto, Long idAlmacen, Long idCompania) throws Exception {
		return informes2DAO.pr_saldo_prom_producto(idProducto, idAlmacen, idCompania);
	}

	public List<ConsultaStockMaquinariaDTO> pr_suministros_para_reposicion(Long compania, String tipoProducto,
			Long flagTipoProducto, String producto, Long flagProducto) throws Exception {
		return informes2DAO.pr_suministros_para_reposicion(compania, tipoProducto, flagTipoProducto, producto,
				flagProducto);
	}

	public Long pr_borrar_maq_otros_costosmq(Long idOtrosCostos) throws Exception {
		return informes2DAO.pr_borrar_maq_otros_costosmq(idOtrosCostos);
	}

	public long pr_max_id_unico_dat_compras(Long compania) throws Exception {
		return informes2DAO.pr_max_id_unico_dat_compras(compania);
	}

	public long pr_max_id_unico_dat_otros_costos_mq(Long compania) throws Exception {
		return informes2DAO.pr_max_id_unico_dat_otros_costos_mq(compania);
	}

	public long pr_max_id_unico_dat_omov_inventario(Long compania) throws Exception {
		return informes2DAO.pr_max_id_unico_dat_omov_inventario(compania);
	}

	public Long pr_borrar_suministros_taller(Long id) throws Exception {
		return informes2DAO.pr_borrar_suministros_taller(id);
	}

	public Long pr_recalcular_otros_costosmq(Long id_ocostosmq) throws Exception {
		return informes2DAO.pr_recalcular_otros_costosmq(id_ocostosmq);
	}

	public Long pr_recalcular_costo_productos(Long id_compras) throws Exception {
		return informes2DAO.pr_recalcular_costo_productos(id_compras);
	}

	public Long pr_distri_suministros_taller(Long id_otros_mov_inventario) throws Exception {
		return informes2DAO.pr_distri_suministros_taller(id_otros_mov_inventario);
	}

	public long consec_req_productos(Long compania) throws Exception {
		return informes2DAO.consec_req_productos(compania);
	}

	public Long pr_busqueda_maq_ctrpin(Long idEquipo) throws Exception {
		return informes2DAO.pr_busqueda_maq_ctrpin(idEquipo);
	}

	public Long pr_actualiza_maq_ctrpin_consecutivo(Long idmaq, Long consecutivoPin) throws Exception {
		return informes2DAO.pr_actualiza_maq_ctrpin_consecutivo(idmaq, consecutivoPin);
	}

	public Long pr_actualiza_edicion_dat_serv_realizados(Long idmaq, Long consecutivoPin) throws Exception {
		return informes2DAO.pr_actualiza_edicion_dat_serv_realizados(idmaq, consecutivoPin);
	}

	public BigDecimal pr_saldo_total_producto(Long idProducto, Long idCompania) throws Exception {
		return informes2DAO.pr_saldo_total_producto(idProducto, idCompania);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetPendientesFact(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) throws Exception {
		return informes2DAO.consultaServRealizadosEquipoDetPendientesFact(compania, estadoServicio, fechaInicial,
				fechaFinal, cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl);

	}

	public List<FacturaServiciosConsolidadosDTO> pr_facturas_consolidadas_servdetal(Long cliente, String numFactura)
			throws Exception {
		return informes2DAO.pr_facturas_consolidadas_servdetal(cliente, numFactura);
	}

	public long consec_plan_serv_mq(Long compania) throws Exception {
		return informes2DAO.consec_plan_serv_mq(compania);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_distribuccion_factura(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long factura) throws Exception {
		return informes2DAO.pr_distribuccion_factura(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, factura);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto)
			throws Exception {
		return informes2DAO.pr_inventario_saldo_bodega(compania, fechaInicial, fechaFinal, almacen, flagAlmacen,
				tipoProducto, flagTipoProducto);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_salidas(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long tipoProducto) throws Exception {
		return informes2DAO.pr_inventario_detalle_salidas(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex,
				conseckardex, tipoProducto);
	}

	public List<ProgramacionLaboresMaqDTO> pr_consulta_prog_labormq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica)
			throws Exception {
		return informes2DAO.pr_consulta_prog_labormq(compania, fechaInicial, fechaFinal, cliente, flagCliente, finca,
				flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida, grupoLabor,
				flagGrupoLabor, equipo, flagEquipo, zonageografica, flagZonaGeografica);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_det(Long compania, String estadoServicio,
			Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca,
			String labor, Long flagLabor, String lote, Long flagLote, Long pinId, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informes2DAO.pr_consulta_servrea_det(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, labor, flagLabor, lote, flagLote, pinId, grpLabor, flagGrpLabor);
	}

	public List<ConsultaCompraProductosDTO> pr_lista_compra_productos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento, String tipoCompra, Long numFactura)
			throws Exception {
		return informes2DAO.pr_lista_compra_productos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				documento, tipoCompra, numFactura);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_labores_implemento(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long pinId) throws Exception {
		return informes2DAO.pr_labores_implemento(compania, fechaInicial, fechaFinal, equipo, flagEquipo, pinId);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception {
		return informes2DAO.pr_inventario_saldo_producto(compania, fechaInicial, fechaFinal, almacen, flagAlmacen,
				producto, flagProducto);
	}

	public List<ConsultaOtrosMovimientosInventarioDTO> pr_lista_otros_mov_productos(Long compania, Date fechaInicial,
			Date fechaFinal, Long documento, Long maquina, Long centCost) throws Exception {
		return informes2DAO.pr_lista_otros_mov_productos(compania, fechaInicial, fechaFinal, documento, maquina,
				centCost);
	}

	public List<ProntuarioLotesDTO> pr_prontuario_haciendas_maquinaria(Long compania, String finca, Long flagFinca,
			String proveedor, Long flagProveedor) throws Exception {
		return informes2DAO.pr_prontuario_haciendas_maquinaria(compania, finca, flagFinca, proveedor, flagProveedor);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_auxilio_productividad(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informes2DAO.pr_liq_auxilio_productividad(compania, fechaInicial, fechaFinal, operador, flagOperador);
	}

	public Long pr_actualiza_consec_factura_compania(Long compania, Long numfactura) throws Exception {
		return informes2DAO.pr_actualiza_consec_factura_compania(compania, numfactura);
	}

	public List<FacturaServiciosConsolidadosDTO> pr_listar_factura_servicios(Long compania, Date fechaInicial,
			Date fechaFinal, Long numFactura) throws Exception {
		return informes2DAO.pr_listar_factura_servicios(compania, fechaInicial, fechaFinal, numFactura);
	}

	public List<ConsultaCajaMenorDTO> pr_listar_cajamenor(Long compania, Date fechaInicial, Date fechaFinal,
			Long documento, Long centCost) throws Exception {
		return informes2DAO.pr_listar_cajamenor(compania, fechaInicial, fechaFinal, documento, centCost);

	}

	public List<CostosIndirectosEquipoDTO> pr_listar_otrosmq(Long compania, Date fechaInicial, Date fechaFinal,
			String tipogasto, Long documento, Long centCost, Long proveedor, String numFactura) throws Exception {
		return informes2DAO.pr_listar_otrosmq(compania, fechaInicial, fechaFinal, tipogasto, documento, centCost,
				proveedor, numFactura);

	}

	public List<PagosNotasClientesDTO> pr_listar_notas_clientes(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informes2DAO.pr_listar_notas_clientes(compania, fechaInicial, fechaFinal);

	}

	public List<CatalogProductoDTO> pr_listar_productos_tipop(Long compania, Long tipoproductoid) throws Exception {
		return informes2DAO.pr_listar_productos_tipop(compania, tipoproductoid);

	}

	public List<ProgramacionLaboresMaqDTO> pr_listar_planesmq(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String tipoProy) throws Exception {
		return informes2DAO.pr_listar_planesmq(compania, fechaInicial, fechaFinal, supervisor, flagSupervisor, zona,
				flagZona, tipoProy);

	}

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informes2DAO.pr_comprobante_pago_nomina(compania, fechaInicial, fechaFinal, operador, flagOperador);

	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_servre_maq_interface_ssatelital(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_servre_maq_interface_ssatelital(compania, fechaInicial, fechaFinal, equipo, flagEquipo);

	}

	public List<CatalogProductoDTO> pr_list_productos_inventario(Long compania, String producto, Long flagProducto,
			String tipoProducto, Long flagTipoProducto) throws Exception {
		return informes2DAO.pr_list_productos_inventario(compania, producto, flagProducto, tipoProducto,
				flagTipoProducto);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_servrea_estus(Long compania, Date fechaInicial,
			Date fechaFinal, String cliente, Long flagCliente, String finca, Long flagFinca, String labor,
			Long flagLabor, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_consulta_servrea_estus(compania, fechaInicial, fechaFinal, cliente, flagCliente, finca,
				flagFinca, labor, flagLabor, equipo, flagEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_numero_pines_por_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_numero_pines_por_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_liq_aux_transporte_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception {
		return informes2DAO.pr_liq_aux_transporte_operario(compania, fechaInicial, fechaFinal, operador, flagOperador,
				equipo, flagEquipo);

	}

	public Long pr_interfaz_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_interfaz_liq_transporte_operario(compania, fechaInicial, fechaFinal, trabajador,
				flagTrabajador, equipo, flagEquipo);

	}

	public Long pr_borrar_liq_transporte_operario(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informes2DAO.pr_borrar_liq_transporte_operario(compania, fechaInicial, fechaFinal);

	}

	public Long pr_borrar_compra(Long idCompra) throws Exception {
		return informes2DAO.pr_borrar_compra(idCompra);
	}

	public Long pr_borrar_dat_compra_detalle(Long idCompra) throws Exception {
		return informes2DAO.pr_borrar_dat_compra_detalle(idCompra);
	}

	public List<CatalogoPlanRevisionDTO> pr_lista_plan_revision_equipo(Long equipoid) throws Exception {
		return informes2DAO.pr_lista_plan_revision_equipo(equipoid);
	}

	public List<CatalogoEquiposDTO> pr_listar_eventos_equipos(Long compania, String equipo, Long flagEquipo,
			String evento, Long flagEvento) throws Exception {
		return informes2DAO.pr_listar_eventos_equipos(compania, equipo, flagEquipo, evento, flagEvento);
	}

	public Long pr_borrar_dat_otros_movimientos(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_otros_movimientos(id);
	}

	public Long pr_borrar_dat_otros_movimientos_detalle(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_otros_movimientos_detalle(id);
	}

	public Long pr_borrar_dat_otros_costos_mq(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_otros_costos_mq(id);
	}

	public Long pr_borrar_dat_otros_costos_mq_detalle(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_otros_costos_mq_detalle(id);
	}

	public Long pr_borrar_dat_caja_menor(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_caja_menor(id);
	}

	public Long pr_borrar_dat_caja_menor_detalle(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_caja_menor_detalle(id);
	}

	public Long pr_borrar_dat_pagos_notas_clientes(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_pagos_notas_clientes(id);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro, Long modeloequipo) throws Exception {
		return informes2DAO.pr_pyg_equipo(compania, fechaInicial, fechaFinal, equipo, flagEquipo, categoriaEquipo,
				flagCategoriaEquipo, estatusRegistro, modeloequipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_pyg_equipo_conceptogasto(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) throws Exception {
		return informes2DAO.pr_pyg_equipo_conceptogasto(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_costo_labor_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) throws Exception {
		return informes2DAO.pr_rendimiento_costo_labor_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo, Long flagCategoriaEquipo,
			String estatusRegistro) throws Exception {
		return informes2DAO.pr_rendimiento_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_rendimiento_maquina_consolidados(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro) throws Exception {
		return informes2DAO.pr_rendimiento_maquina_consolidados(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_ingresos_vs_costos_maquina(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, String categoriaEquipo,
			Long flagCategoriaEquipo, String estatusRegistro, String tipoMovimiento) throws Exception {
		return informes2DAO.pr_ingresos_vs_costos_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoriaEquipo, flagCategoriaEquipo, estatusRegistro, tipoMovimiento);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_operarios_maquina_periodo(Long compania, Date fechaInicial,
			Date fechaFinal, String cargo, Long flagCargo, String trabajador, Long flagTrabajador, String equipo,
			Long flagEquipo) throws Exception {
		return informes2DAO.pr_operarios_maquina_periodo(compania, fechaInicial, fechaFinal, cargo, flagCargo,
				trabajador, flagTrabajador, equipo, flagEquipo);
	}

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos(Long compania, Date fechaInicial, Date fechaFinal,
			Long documento, Long centCost, Long proveedor, String numfactura) throws Exception {
		return informes2DAO.pr_listar_dat_diferidos(compania, fechaInicial, fechaFinal, documento, centCost, proveedor,
				numfactura);

	}

	public Long pr_borrar_dat_diferidos(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_diferidos(id);
	}

	public Long pr_borrar_dat_diferidos_det(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_diferidos_det(id);

	}

	public Long pr_borrar_dat_diferidos_cuotas(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_diferidos_cuotas(id);

	}

	public Long pr_borrar_equipos_otros_costosmqdistr(Long id) throws Exception {
		return informes2DAO.pr_borrar_equipos_otros_costosmqdistr(id);

	}

	public Long pr_borrar_dat_caja_menor_det_distr(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_caja_menor_det_distr(id);

	}

	public Long pr_borrar_precio_prom_prod_distribuccionmaq(Long id) throws Exception {
		return informes2DAO.pr_borrar_precio_prom_prod_distribuccionmaq(id);

	}

	public List<ProgramacionLaboresMaqDTO> pr_consulta_estatus_plan_maquinas(Long id_plan_mqdet) throws Exception {
		return informes2DAO.pr_consulta_estatus_plan_maquinas(id_plan_mqdet);

	}

	public Double pr_consulta_estatus_area_plan_maquinas(Long id_plan_mqdet) throws Exception {
		return informes2DAO.pr_consulta_estatus_area_plan_maquinas(id_plan_mqdet);

	}

	public Long pr_borrar_dat_plan_servicios_mqdet_ejec(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_plan_servicios_mqdet_ejec(id);

	}

	public List<logServiciosMaqDTO> pr_log_dat_serv_realizados_equipo(Long compania, Long equipoid, Long documento)
			throws Exception {
		return informes2DAO.pr_log_dat_serv_realizados_equipo(compania, equipoid, documento);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_ingresos_cero(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId)
			throws Exception {
		return informes2DAO.pr_consulta_serv_ingresos_cero(compania, estadoServicio, fechaInicial, fechaFinal, cliente,
				flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida,
				grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_limite_cantidad(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Double cantidadmax) throws Exception {
		return informes2DAO.pr_consulta_serv_limite_cantidad(compania, estadoServicio, fechaInicial, fechaFinal,
				cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida,
				flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, cantidadmax);
	}

	public List<CostosIndirectosEquipoDTO> pr_val_existencia_otros_costosmq(String idRegistro) throws Exception {
		return informes2DAO.pr_val_existencia_otros_costosmq(idRegistro);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaPlanillaNominaDTO> consultarListaPlanillaNomina(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String origen, String estadoplanilla) throws Exception {
		return informes2DAO.consultarListaPlanillaNomina(compania, fechaInicial, fechaFinal, planilla, origen,
				estadoplanilla);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaPlanillaNominaDetalladoDTO> reporteLaboresManualesDetalladoRD(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla, String origen, String estadoplanilla) throws Exception {
		return informes2DAO.reporteLaboresManualesDetalladoRD(compania, fechaInicial, fechaFinal, planilla, origen,
				estadoplanilla);

	}

	public Long pr_borrar_analisis_lab_detalle(Long id) throws Exception {
		return informes2DAO.pr_borrar_analisis_lab_detalle(id);
	}

	public Long pr_borrar_analisis_lab(Long id) throws Exception {
		return informes2DAO.pr_borrar_analisis_lab(id);
	}

	public List<ConsultaCostosDiferidosDTO> pr_listar_dat_diferidos_agricola(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informes2DAO.pr_listar_dat_diferidos_agricola(compania, fechaInicial, fechaFinal);
	}

	public long consultarConsecutivoDatDiferidosAgricola(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoDatDiferidosAgricola(compania);
	}

	public Long pr_borrar_dat_diferidos_agricola(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_diferidos_agricola(id);
	}

	public Long pr_borrar_dat_diferidos_agricola_det(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_diferidos_agricola_det(id);
	}

	public Long pr_borrar_dat_diferidos_cuotas_agricola(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_diferidos_cuotas_agricola(id);
	}

	public List<DatOtrosCostosDTO> pr_listar_otros_costos(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String tipoDistri) throws Exception {
		return informes2DAO.pr_listar_otros_costos(compania, fechaInicial, fechaFinal, planilla, tipoDistri);
	}

	public List<DatNominaTrabajadorDTO> pr_lista_dat_nomina_trabajador(Long compania, Date fechaInicial,
			Date fechaFinal, Long planilla) throws Exception {
		return informes2DAO.pr_lista_dat_nomina_trabajador(compania, fechaInicial, fechaFinal, planilla);
	}

	public List<DatTransProdDTO> pr_listar_produccion(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception {
		return informes2DAO.pr_listar_produccion(compania, fechaInicial, fechaFinal, planilla);
	}

	public List<DatPlanLaborDTO> pr_lista_plan_labor(Long compania, Date fechaInicial, Date fechaFinal, Long planilla)
			throws Exception {
		return informes2DAO.pr_lista_plan_labor(compania, fechaInicial, fechaFinal, planilla);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaNivel4DTO> listaCodigosErp(String nivel3Id) throws Exception {
		return informes2DAO.listaCodigosErp(nivel3Id);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ListaNivel4DTO> pr_lista_nivel4_filtro_nivel3(String nivel3Id) throws Exception {
		return informes2DAO.pr_lista_nivel4_filtro_nivel3(nivel3Id);

	}

	public Long pr_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal, Long usuarioId) {
		return informes2DAO.pr_liquidar_planilla_nomina_periodo(compania, fechaInicial, fechaFinal, usuarioId);

	}

	public Long pr_re_liquidar_planilla_nomina_periodo(Long compania, Date fechaInicial, Date fechaFinal,
			Long usuarioId) {
		return informes2DAO.pr_re_liquidar_planilla_nomina_periodo(compania, fechaInicial, fechaFinal, usuarioId);

	}

	public List<NominaDetalladaDTO> pr_desprendible_pago_agricola(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajadorId, Long flagTrabajador) throws Exception {
		return informes2DAO.pr_desprendible_pago_agricola(compania, fechaInicial, fechaFinal, trabajadorId,
				flagTrabajador);
	}

	public List<ConsultaDiferidosDTO> pr_dat_diferidos_agricolas(Long compania, Date fechaInicial, Date fechaFinal,
			String hacienda, Long flagHacienda, String lote, Long flagLote) throws Exception {
		return informes2DAO.pr_dat_diferidos_agricolas(compania, fechaInicial, fechaFinal, hacienda, flagHacienda, lote,
				flagLote);
	}

	public List<ListaProduccionDTO> pr_listar_reg_produccion(Long compania, Date fechaInicial, Date fechaFinal,
			Long planilla, String hacienda, Long flagHacienda, String lote, Long flagLote) throws Exception {
		return informes2DAO.pr_listar_reg_produccion(compania, fechaInicial, fechaFinal, planilla, hacienda,
				flagHacienda, lote, flagLote);
	}

	public List<CostosTotalesDTO> pr_costos_ingresos_compania_detallado(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1)
			throws Exception {
		return informes2DAO.pr_costos_ingresos_compania_detallado(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas,
				origenDatos1);
	}

	public List<CostosTotalesDTO> pr_costos_detallado(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception {
		return informes2DAO.pr_costos_detallado(compania, fechaInicial, fechaFinal, zona, flagZona, finca, flagFinca,
				bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, origenDatos1);
	}

	public List<CostosTotalesDTO> pr_costos_ingresos_lotes_cosechados_periodo_det(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1,
			String grpLabor, Long flagGrpLabor) throws Exception {
		return informes2DAO.pr_costos_ingresos_lotes_cosechados_periodo_det(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas,
				origenDatos1, grpLabor, flagGrpLabor);
	}

	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1)
			throws Exception {
		return informes2DAO.pr_costos_resumen_labor_grupo(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, origenDatos1);
	}

	public List<CostosTotalesDTO> pr_costos_resumen_labor_grupo_lotes_cosechados(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1,
			String grpLabor, Long flagGrpLabor) throws Exception {
		return informes2DAO.pr_costos_resumen_labor_grupo_lotes_cosechados(compania, fechaInicial, fechaFinal, zona,
				flagZona, finca, flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas,
				origenDatos1, grpLabor, flagGrpLabor);
	}

	public List<CosechasLoteDTO> pr_pyg_lotes_cosechados(Long compania, Date fechaInicial, Date fechaFinal, String zona,
			Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote, Long flagLote,
			String labor, Long flagLabor, Long flagNumeroCosechas, String origenDatos1) throws Exception {
		return informes2DAO.pr_pyg_lotes_cosechados(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, origenDatos1);
	}

	public Long pr_borrar_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informes2DAO.pr_borrar_cierre_costos_agricolas(compania, fechaInicial, fechaFinal);
	}

	public Long pr_interfaz_cierre_costos_agricolas(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informes2DAO.pr_interfaz_cierre_costos_agricolas(compania, fechaInicial, fechaFinal);
	}

	public List<CostosTotalesDTO> pr_costo_parcial_detallado(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor,
			Long diaslabor) throws Exception {
		return informes2DAO.pr_costo_parcial_detallado(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor, diaslabor);

	}

	public List<CostosTotalesDTO> pr_costo_parcial_resumen(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informes2DAO.pr_costo_parcial_resumen(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor);

	}

	public List<CostosTotalesDTO> pr_costo_lotes_cerrados(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informes2DAO.pr_costo_lotes_cerrados(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor);

	}

	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) throws Exception {
		return informes2DAO.pr_costos_produccion_lote_cerrado(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, flagNumeroCosechas);

	}

	public List<ProduccionAcumFincaDTO> pr_produccion_lote_cerrado(Long compania, Date fecha_inicial, Date fecha_final,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, Long flagNumeroCosechas) throws Exception {
		return informes2DAO.pr_produccion_lote_cerrado(compania, fecha_inicial, fecha_final, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, flagNumeroCosechas);

	}

	public List<CostosTotalesDTO> pr_costos_produccion_lote_cerrado_corte(Long compania, Date fechaInicial,
			Date fechaFinal, String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque,
			String lote, Long flagLote, Long flagNumeroCosechas) throws Exception {
		return informes2DAO.pr_costos_produccion_lote_cerrado_corte(compania, fechaInicial, fechaFinal, zona, flagZona,
				finca, flagFinca, bloque, flagBloque, lote, flagLote, flagNumeroCosechas);

	}

	public List<CostosTotalesDTO> pr_costo_parcial_resumen_labor(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor)
			throws Exception {
		return informes2DAO.pr_costo_parcial_resumen_labor(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor);

	}

	public List<CostosTotalesDTO> pr_costo_parcial_resumen_lote(Long compania, Date fechaInicial, Date fechaFinal,
			String zona, Long flagZona, String finca, Long flagFinca, String bloque, Long flagBloque, String lote,
			Long flagLote, String labor, Long flagLabor, Long flagNumeroCosechas, String grpLabor, Long flagGrpLabor,
			Long diaslabor) throws Exception {
		return informes2DAO.pr_costo_parcial_resumen_lote(compania, fechaInicial, fechaFinal, zona, flagZona, finca,
				flagFinca, bloque, flagBloque, lote, flagLote, labor, flagLabor, flagNumeroCosechas, grpLabor,
				flagGrpLabor, diaslabor);

	}

	public List<ConsolidadoNominaDTO> pr_mo_desprendible_pago(Long compania, Date fechaInicial, Date fechaFinal,
			String trabajador, Long flagTrabajador) {
		return informes2DAO.pr_mo_desprendible_pago(compania, fechaInicial, fechaFinal, trabajador, flagTrabajador);
	}

	public List<CuadroPrecipitacionDiariaDTO> pr_comportamiento_lluvias(Long compania, Date fechaInicial,
			Date fechaFinal, String estPluvio, Long flagEstPluvio) throws Exception {
		return informes2DAO.pr_comportamiento_lluvias(compania, fechaInicial, fechaFinal, estPluvio, flagEstPluvio);
	}

	public List<ListaNivel4DTO> pr_lista_etapas_lotes_cosechados(Long compania, Long idnivel4) throws Exception {
		return informes2DAO.pr_lista_etapas_lotes_cosechados(compania, idnivel4);
	}

	public Long pr_asociar_reg_produccion_costos(Long idLote, Long idEtapa, Long reg_produccion_id, Long idCiclo)
			throws Exception {
		return informes2DAO.pr_asociar_reg_produccion_costos(idLote, idEtapa, reg_produccion_id, idCiclo);
	}

	public Long pr_reabrir_cosecha_costos(Long idLote, Long idEtapa, Long reg_produccion_id, Long idCiclo)
			throws Exception {
		return informes2DAO.pr_reabrir_cosecha_costos(idLote, idEtapa, reg_produccion_id, idCiclo);
	}

	public Double pr_ultimo_valor_compra_producto(Long idProducto) throws Exception {
		return informes2DAO.pr_ultimo_valor_compra_producto(idProducto);
	}

	public Long pr_recalculo_vr_hora_maquina(Long companiaid, Date fechaInicial, Date fechaFinal) throws Exception {
		return informes2DAO.pr_recalculo_vr_hora_maquina(companiaid, fechaInicial, fechaFinal);
	}

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception {
		return informes2DAO.pr_comprobante_pago_nomina_maq_destajo(compania, fechaInicial, fechaFinal, operador,
				flagOperador, tipoNomina);
	}

	public Long pr_borrar_dat_servicio_equipo(Long idServicio) throws Exception {
		return informes2DAO.pr_borrar_dat_servicio_equipo(idServicio);
	}

	public Long pr_borrar_dat_servicio_equipo_det(Long idServicio) throws Exception {
		return informes2DAO.pr_borrar_dat_servicio_equipo_det(idServicio);

	}

	public Long pr_borrar_serv_producto(Long idServicio) throws Exception {
		return informes2DAO.pr_borrar_serv_producto(idServicio);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, Long categoria) throws Exception {
		return informes2DAO.pr_consumo_combustible_rdl(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				categoria);
	}

	public long pr_ultima_planilla_servicios_maq(Long compania, Date fecha, Long maquina, Long operarioId)
			throws Exception {
		return informes2DAO.pr_ultima_planilla_servicios_maq(compania, fecha, maquina, operarioId);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_importacion_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura, Long usuario, String equipo, Long flagEquipo, String tipomovimiento) throws Exception {
		return informes2DAO.pr_inventario_detalle_importacion_movil(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex,
				conseckardex, factura, usuario, equipo, flagEquipo, tipomovimiento);
	}

	public String pr_importar_salidas_movil_enproceso(String precioprodid, String tipomovimiento) {
		return informes2DAO.pr_importar_salidas_movil_enproceso(precioprodid, tipomovimiento);
	}

	public long pr_ultima_programa_labores_maq(Long compania, Date fecha, Long cliente, Long supervisorId)
			throws Exception {
		return informes2DAO.pr_ultima_programa_labores_maq(compania, fecha, cliente, supervisorId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<SolicitudesMttoEquipoDTO> pr_formato_impresion_ot(Long compania, Date fechaInicial, Date fechaFinal,
			String propietario, Long flagPropietario, String equipo, Long flagEquipo, String tipoMtto,
			Long flagTipoMtto, Long idMtto) throws Exception {
		return informes2DAO.pr_formato_impresion_ot(compania, fechaInicial, fechaFinal, propietario, flagPropietario,
				equipo, flagEquipo, tipoMtto, flagTipoMtto, idMtto);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_consumo_combustible_rdl_resumen_maq(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_maq_labor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_consumo_combustible_rdl_resumen_maq_labor(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_labor(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_consumo_combustible_rdl_resumen_labor(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_consumo_combustible_rdl_resumen_hda(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_consumo_combustible_rdl_resumen_hda(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_importacion_movil_formato_dia(Long compania,
			Date fechaInicial, Date fechaFinal, Long flagAlmacen) throws Exception {
		return informes2DAO.pr_inventario_importacion_movil_formato_dia(compania, fechaInicial, fechaFinal,
				flagAlmacen);
	}

	public List<ListadoProximosMttoEquiposDTO> consultarListaProximosMttoEquiposPorVencer(Long compania, String equipo,
			Long flagEquipo, String planRevision, Long flagPlanRevision, String origenDatos, String estadoplan)
			throws Exception {
		return informes2DAO.consultarListaProximosMttoEquiposPorVencer(compania, equipo, flagEquipo, planRevision,
				flagPlanRevision, origenDatos, estadoplan);
	}

	public Long pr_actualizar_plan_revision_det(Long idequipo, Date fecha_ult_serv, Double horas, Double km,
			String planes, String estadoPlan) throws Exception {
		return informes2DAO.pr_actualizar_plan_revision_det(idequipo, fecha_ult_serv, horas, km, planes, estadoPlan);
	}

	public List<ProgMttoPreventivosMaqDTO> pr_ordenes_trabajao_mtto_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String responsableMtto, Long flagResponsable,
			Long consecutivoOt, String estado_ot, Long centCost, String tipoOrden) throws Exception {
		return informes2DAO.pr_ordenes_trabajao_mtto_maq(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				responsableMtto, flagResponsable, consecutivoOt, estado_ot, centCost, tipoOrden);
	}

	public List<ProgLaboresMecMaqDTO> pr_lista_prog_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String supervisor, Long flagSupervisor, String zona, Long flagZona, String cliente, Long flagCliente,
			String hacienda, Long flagHacienda, Long consecutivoOt, String labor, Long flagLabor, String grupoLabor,
			Long flagGrupoLabor, String finalizado, Double porc_avance) throws Exception {
		return informes2DAO.pr_lista_prog_maquinaria(compania, fechaInicial, fechaFinal, supervisor, flagSupervisor,
				zona, flagZona, cliente, flagCliente, hacienda, flagHacienda, consecutivoOt, labor, flagLabor,
				grupoLabor, flagGrupoLabor, finalizado, porc_avance);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception {
		return informes2DAO.pr_inventario_saldo_producto_ubicacion(compania, fechaInicial, fechaFinal, almacen,
				flagAlmacen, producto, flagProducto);
	}

	public List<ProgMttoPreventivosMaqDTO> pr_ordenes_trabajao_mtto_maq_detalle(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String responsableMtto, Long flagResponsable,
			Long consecutivoOt, String tipoOrden) throws Exception {
		return informes2DAO.pr_ordenes_trabajao_mtto_maq_detalle(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				responsableMtto, flagResponsable, consecutivoOt, tipoOrden);
	}

	public Long pr_actualizar_prog_maquinaria(Long idprogramacion) throws Exception {
		return informes2DAO.pr_actualizar_prog_maquinaria(idprogramacion);
	}

	public Long pr_borrar_dat_plan_servicios_mq(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_plan_servicios_mq(id);
	}

	public Long pr_borrar_dat_plan_servicios_mqdet(Long id) throws Exception {
		return informes2DAO.pr_borrar_dat_plan_servicios_mqdet(id);
	}

	public Long pr_act_prog_dat_serv_realizados_equipo_det(Long id) throws Exception {
		return informes2DAO.pr_act_prog_dat_serv_realizados_equipo_det(id);
	}

	public List<ListaLaboresDTO> pr_lista_labores(Long compania, String grupoLabor) throws Exception {
		return informes2DAO.pr_lista_labores(compania, grupoLabor);
	}

	public Double pr_ult_horo_odometro_tanqueo(Long compania, Long idMaq) throws Exception {
		return informes2DAO.pr_ult_horo_odometro_tanqueo(compania, idMaq);
	}

	public List<ImportarNominaEmpAdmonDTO> pr_nomina_empleados_administrativos(Long compania, Date fechaInicial,
			Date fechaFinal, String tiponomina) throws Exception {
		return informes2DAO.pr_nomina_empleados_administrativos(compania, fechaInicial, fechaFinal, tiponomina);
	}

	public List<SolicitudesMttoEquipoDTO> pr_hoja_vida_maquina(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_hoja_vida_maquina(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ProgramacionLaboresMaqDTO> pr_avance_proyectos_maq(Long compania, Date fechaInicial, Date fechaFinal,
			String cliente, Long flagCliente, String finca, Long flagFinca, String operador, Long flagOperador,
			String labor, Long flagLabor, String unidadMedida, Long flagUnidadMedida, String grupoLabor,
			Long flagGrupoLabor, String equipo, Long flagEquipo, String zonageografica, Long flagZonaGeografica)
			throws Exception {
		return informes2DAO.pr_avance_proyectos_maq(compania, fechaInicial, fechaFinal, cliente, flagCliente, finca,
				flagFinca, operador, flagOperador, labor, flagLabor, unidadMedida, flagUnidadMedida, grupoLabor,
				flagGrupoLabor, equipo, flagEquipo, zonageografica, flagZonaGeografica);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos(Long compania, Date fechaInicial,
			Date fechaFinal, String tipoCosto) throws Exception {
		return informes2DAO.pr_distribuccion_ingresos_equipos(compania, fechaInicial, fechaFinal, tipoCosto);

	}

	public Long pr_borrar_distribuccion_costos_ind_maquina(Long compania, Date fechaInicial, Date fechaFinal,
			String origen) throws Exception {
		return informes2DAO.pr_borrar_distribuccion_costos_ind_maquina(compania, fechaInicial, fechaFinal, origen);

	}

	public Long pr_insert_distribuccion_ingresos_equipos(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, String origen) throws Exception {
		return informes2DAO.pr_insert_distribuccion_ingresos_equipos(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo, origen);

	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_producto_movil(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String producto, Long flagProducto) throws Exception {
		return informes2DAO.pr_inventario_saldo_producto_movil(compania, fechaInicial, fechaFinal, almacen, flagAlmacen,
				producto, flagProducto);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_lista_equipos_distribuccion(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo) throws Exception {
		return informes2DAO.pr_lista_equipos_distribuccion(compania, fechaInicial, fechaFinal, equipo, flagEquipo);
	}

	public List<ConsultaRegistrosUsuariosDTO> pr_digitaciones_por_usuario(Long compania, Date fechaInicial,
			Date fechaFinal, String tipo_reg, Long idusuario) throws Exception {
		return informes2DAO.pr_digitaciones_por_usuario(compania, fechaInicial, fechaFinal, tipo_reg, idusuario);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_distribuccion_ingresos_equipos_detalle(Long compania, String anioMes,
			String idOrigen) throws Exception {
		return informes2DAO.pr_distribuccion_ingresos_equipos_detalle(compania, anioMes, idOrigen);
	}

	public List<CostosIndirectosEquipoDTO> pr_compras_gastos(Long compania, Date fechaInicial, Date fechaFinal,
			String contratista, Long flagContratista, Long documento) throws Exception {
		return informes2DAO.pr_compras_gastos(compania, fechaInicial, fechaFinal, contratista, flagContratista,
				documento);
	}

	public List<ListadoProvisionesDTO> pr_listar_proviciones(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception {
		return informes2DAO.pr_listar_proviciones(compania, fechaInicial, fechaFinal, trabId, flagTrabajador);
	}

	public List<ListadoProvisionesDTO> pr_listar_proviciones_mq(Long compania, Date fechaInicial, Date fechaFinal,
			String trabId, Long flagTrabajador) throws Exception {
		return informes2DAO.pr_listar_proviciones_mq(compania, fechaInicial, fechaFinal, trabId, flagTrabajador);
	}

	public List<SolicitudesMttoEquipoDTO> pr_ot_plan_revision(Long compania, Date fechaInicial, Date fechaFinal,
			String equipo, Long flagEquipo, Long idMtto) throws Exception {
		return informes2DAO.pr_ot_plan_revision(compania, fechaInicial, fechaFinal, equipo, flagEquipo, idMtto);
	}

	public List<ConsultaCompraMateriaPrimaDTO> pr_lista_compra_materia_prima(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, Long documento) throws Exception {
		return informes2DAO.pr_lista_compra_materia_prima(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, documento);
	}

	public long consultarConsecutivoDatCompraMateriaPrima(Long compania) throws Exception {
		return informes2DAO.consultarConsecutivoDatCompraMateriaPrima(compania);
	}

	public List<ConsultaCompraProductosDTO> pr_inventario_detalle_materia_prima(Long compania, Date fechaInicial,
			Date fechaFinal, String contratista, Long flagContratista, String producto, Long flagProducto,
			String almacen, Long flagAlmacen, String conceptokardex, Long flagConceptokardex, Long conseckardex,
			Long factura) throws Exception {
		return informes2DAO.pr_inventario_detalle_materia_prima(compania, fechaInicial, fechaFinal, contratista,
				flagContratista, producto, flagProducto, almacen, flagAlmacen, conceptokardex, flagConceptokardex,
				conseckardex, factura);
	}

	public List<ConsultaProgLaboresMaqDTO> pr_consulta_lista_prog_maquinaria(Long compania, Date fechaInicial,
			Date fechaFinal) throws Exception {
		return informes2DAO.pr_consulta_lista_prog_maquinaria(compania, fechaInicial, fechaFinal);
	}

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informes2DAO.pr_consulta_provisiones_maq(compania, fechaInicial, fechaFinal, operador, flagOperador);
	}

	public Long pr_calculo_provisiones_maq(Long companiaid, Date fechaInicial, Date fechaFinal, String operador,
			Long flagOperador, String tipoNomina, Long usuario) throws Exception {
		return informes2DAO.pr_calculo_provisiones_maq(companiaid, fechaInicial, fechaFinal, operador, flagOperador,
				tipoNomina, usuario);
	}

	public Long borrar_dat_proviciones_cierre_nomina_mq(Long companiaid, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informes2DAO.borrar_dat_proviciones_cierre_nomina_mq(companiaid, fechaInicial, fechaFinal);
	}

	public List<ConsultaProvisioncesMaqDTO> pr_consulta_provisiones_nomina_maq(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador) throws Exception {
		return informes2DAO.pr_consulta_provisiones_nomina_maq(compania, fechaInicial, fechaFinal, operador,
				flagOperador);
	}

	public List<DistribuccionCostosMaquinaDTO> pr_costos_distribuidos_equipo(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String idOrigen) throws Exception {
		return informes2DAO.pr_costos_distribuidos_equipo(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				idOrigen);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquina_grlabor(Long compania,
			Date fechaInicial, Date fechaFinal, String equipo, Long flagEquipo, Long grupoLabor) throws Exception {
		return informes2DAO.pr_control_productividad_maquina_grlabor(compania, fechaInicial, fechaFinal, equipo,
				flagEquipo, grupoLabor);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_maquinaria(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo,
			String categoria, Long flagCategoriaEquipo, Long modeloEquipo) throws Exception {
		return informes2DAO.pr_control_productividad_maquinaria(compania, fechaInicial, fechaFinal, operador,
				flagOperador, equipo, flagEquipo, categoria, flagCategoriaEquipo, modeloEquipo);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_control_productividad_operario(Long compania,
			Date fechaInicial, Date fechaFinal, String operador, Long flagOperador, String equipo, Long flagEquipo)
			throws Exception {
		return informes2DAO.pr_control_productividad_operario(compania, fechaInicial, fechaFinal, operador,
				flagOperador, equipo, flagEquipo);
	}

	public Long pr_recalcular_mano_obra_serv_maq(Long compania, Date fechaInicial, Date fechaFinal) throws Exception {
		return informes2DAO.pr_recalcular_mano_obra_serv_maq(compania, fechaInicial, fechaFinal);

	}

	public Long pr_recalcular_mano_obra_serv_maq_parte2(Long compania, Date fechaInicial, Date fechaFinal)
			throws Exception {
		return informes2DAO.pr_recalcular_mano_obra_serv_maq_parte2(compania, fechaInicial, fechaFinal);
	}

	public Long pr_cierre_nomina_destajo_maquinaria(Long compania, Date fechaInicial, Date fechaFinal,
			String tipoNomina, Long usuario) throws Exception {
		return informes2DAO.pr_cierre_nomina_destajo_maquinaria(compania, fechaInicial, fechaFinal, tipoNomina,
				usuario);
	}

	public Long pr_borrar_trabajador_provisiones(Long compania, Date fechaInicial, Date fechaFinal, String trabajadores)
			throws Exception {
		return informes2DAO.pr_borrar_trabajador_provisiones(compania, fechaInicial, fechaFinal, trabajadores);
	}

	public List<SolicitudesMttoEquipoDTO> pr_solicitudes_mtto_equipo_productos(Long compania, Date fechaInicial,
			Date fechaFinal, String equipo, Long flagEquipo, String producto, Long flagProducto, String almacen,
			Long flagAlmacen, Long idMtto, Long datmttoprodid, Long tipoProducto) throws Exception {
		return informes2DAO.pr_solicitudes_mtto_equipo_productos(compania, fechaInicial, fechaFinal, equipo, flagEquipo,
				producto, flagProducto, almacen, flagAlmacen, idMtto, datmttoprodid, tipoProducto);

	}

	public List<ConsultaComprobantePagoDTO> pr_comprobante_pago_nomina_maq_destajo2(Long compania, Date fechaInicial,
			Date fechaFinal, String operador, Long flagOperador, String tipoNomina) throws Exception {
		return informes2DAO.pr_comprobante_pago_nomina_maq_destajo2(compania, fechaInicial, fechaFinal, operador,
				flagOperador, tipoNomina);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> consultaServRealizadosEquipoDetCombustible(Long compania,
			String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente, String finca,
			Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor, String unidadMedida,
			Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo, Long flagEquipo, Long pinId,
			Long consecutivoRdl) throws Exception {
		return informes2DAO.consultaServRealizadosEquipoDetCombustible(compania, estadoServicio, fechaInicial,
				fechaFinal, cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl);
	}

	public long consec_dat_factura_servicios_terceros(Long compania) throws Exception {
		return informes2DAO.consec_dat_factura_servicios_terceros(compania);
	}

	public List<FacturaServiciosConsolidadosTercerosDTO> pr_listar_factura_servicios_terceros(Long compania,
			Date fechaInicial, Date fechaFinal, Long consec, Long centCost) throws Exception {
		return informes2DAO.pr_listar_factura_servicios_terceros(compania, fechaInicial, fechaFinal, consec, centCost);
	}

	public List<FacturaServiciosConsolidadosTercerosDTO> pr_ingresos_egresos_terceros(Long compania, Date fechaInicial,
			Date fechaFinal, Long consec, Long centCost) throws Exception {
		return informes2DAO.pr_ingresos_egresos_terceros(compania, fechaInicial, fechaFinal, consec, centCost);
	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_recalculo_precio_entrada_producto(Long compania,
			Date fechaInicial, Date fechaFinal, Long flagAlmacen, Long flagProducto) throws Exception {
		return informes2DAO.pr_inventario_recalculo_precio_entrada_producto(compania, fechaInicial, fechaFinal,
				flagAlmacen, flagProducto);
	}

	public long pr_consec_producto_tipo(Long compania, Long tipoProd) throws Exception {
		return informes2DAO.pr_consec_producto_tipo(compania, tipoProd);
	}

	public List<ConsultaServiciosRealizadosMaquinariaDTO> pr_consulta_serv_realizados_equipo_det_combustible2(
			Long compania, String estadoServicio, Date fechaInicial, Date fechaFinal, String cliente, Long flagCliente,
			String finca, Long flagFinca, String operador, Long flagOperador, String labor, Long flagLabor,
			String unidadMedida, Long flagUnidadMedida, String grupoLabor, Long flagGrupoLabor, String equipo,
			Long flagEquipo, Long pinId, Long consecutivoRdl, Long centCostId) throws Exception {
		return informes2DAO.pr_consulta_serv_realizados_equipo_det_combustible2(compania, estadoServicio, fechaInicial,
				fechaFinal, cliente, flagCliente, finca, flagFinca, operador, flagOperador, labor, flagLabor,
				unidadMedida, flagUnidadMedida, grupoLabor, flagGrupoLabor, equipo, flagEquipo, pinId, consecutivoRdl,
				centCostId);

	}

	public List<ConsultaStockMaquinariaDTO> pr_inventario_saldo_bodega_ubicacion(Long compania, Date fechaInicial,
			Date fechaFinal, String almacen, Long flagAlmacen, String tipoProducto, Long flagTipoProducto)
			throws Exception {
		return informes2DAO.pr_inventario_saldo_bodega_ubicacion(compania, fechaInicial, fechaFinal, almacen,
				flagAlmacen, tipoProducto, flagTipoProducto);
	}
}